package jmx.kafka;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hua on 2018/05/03.
 */
public class JmxConnection {
	private static Logger log  = LogManager.getLogger(JmxConnection.class);

    private MBeanServerConnection conn;
    private String jmxURL;
    private String ipAndPort = "localhost:9010";
//    private int port = 9010;
    private boolean newKafkaVersion = false;

    public JmxConnection(Boolean newKafkaVersion, String ipAndPort){
        this.newKafkaVersion = newKafkaVersion;
        this.ipAndPort = ipAndPort;
    }

    public boolean init(){
        jmxURL = "service:jmx:rmi:///jndi/rmi://" +ipAndPort+ "/jmxrmi";
        log.info("init jmx, jmxUrl: {}, and begin to connect it",jmxURL);
        try {
            JMXServiceURL serviceURL = new JMXServiceURL(jmxURL);
            JMXConnector connector = JMXConnectorFactory.connect(serviceURL,null);
            conn = connector.getMBeanServerConnection();
            if(conn == null){
               log.error("get connection return null!");
                return  false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getTopicName(String topicName){
        String s;
        if (newKafkaVersion) {
            s = "kafka.server:type=BrokerTopicMetrics,name=MessagesInPerSec,topic=" + topicName;
        } else {
            s = "\"kafka.server\":type=\"BrokerTopicMetrics\",name=\"" + topicName + "-MessagesInPerSec\"";
        }
        return s;
    }

    /**
     * @param topicName: topic name, test
     * @return message count per second: for single broker, it is the sum of one topic's message
     */
    public long getMsgInCountPerSec(String topicName){
	    String objectName = getTopicName(topicName);
	    Object val = getAttribute(objectName,"Count");
	    String debugInfo = "jmxUrl:"+jmxURL+",objectName="+objectName;
	    if(val !=null){
	        log.info("{}, Count:{}",debugInfo,(long)val);
	        return (long)val;
	    }
	    return 0;
	}

    /**
     * @param topicName: topic name, default_channel_kafka_zzh_demo
     * @return tps
     */
    public double getMsgInTpsPerSec(String topicName){
        String objectName = getTopicName(topicName);
        Object val = getAttribute(objectName,"OneMinuteRate");
        if(val !=null){
            double dVal = ((Double)val).doubleValue();
            return dVal;
        }
        return 0;
    }

    private Object getAttribute(String objName, String objAttr)
    {
        ObjectName objectName =null;
        try {
            objectName = new ObjectName(objName);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
            return null;
        }
        return getAttribute(objectName,objAttr);
    }

    private Object getAttribute(ObjectName objName, String objAttr){
        if(conn== null)
        {
            log.error("jmx connection is null");
            return null;
        }

        try {
            return conn.getAttribute(objName,objAttr);
        } catch (MBeanException e) {
            e.printStackTrace();
            return null;
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (ReflectionException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param topicName
     * @return offset
     */
    public Map<Integer,Long> getTopicEndOffset(String topicName){
        Set<ObjectName> objs = getEndOffsetObjects(topicName);
        if(objs == null){
            return null;
        }
        Map<Integer, Long> map = new HashMap<>();
        for(ObjectName objName:objs){
            int partId = getParId(objName);
            Object val = getAttribute(objName,"Value");
            if(val !=null){
                map.put(partId,(Long)val);
            }
        }
        return map;
    }

    private int getParId(ObjectName objName){
        if(newKafkaVersion){
            String s = objName.getKeyProperty("partition");
            return Integer.parseInt(s);
        }else {
            String s = objName.getKeyProperty("name");

            int to = s.lastIndexOf("-LogEndOffset");
            String s1 = s.substring(0, to);
            int from = s1.lastIndexOf("-") + 1;

            String ss = s.substring(from, to);
            return Integer.parseInt(ss);
        }
    }

    private Set<ObjectName> getEndOffsetObjects(String topicName){
        String objectName;
        if (newKafkaVersion) {
            objectName = "kafka.log:type=Log,name=LogEndOffset,topic="+topicName+",partition=*";
        }else{
            objectName = "\"kafka.log\":type=\"Log\",name=\"" + topicName + "-*-LogEndOffset\"";
        }
        ObjectName objName = null;
        Set<ObjectName> objectNames = null;
        try {
            objName = new ObjectName(objectName);
            objectNames = conn.queryNames(objName,null);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
            return  null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return objectNames;
    }
}
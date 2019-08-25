import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import java.util.List;

public class HotSpotTest {

    public static void main(String [] args) throws Exception {
    		String value=System.getProperty("catalina.home");
    		System.out.println("values: " + value);
      //   printHotSpotOption("MaxHeapFreeRatio");
//         printHotSpotOption("SurvivorRatio");
//         printHotSpotOptions();
				// get a RuntimeMXBean reference
				RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();

				// get the jvm's input arguments as a list of strings
				List<String> listOfArguments = runtimeMxBean.getInputArguments();

				// print the arguments using my logger
// 				for (a <- listOfArguments) {
// 				   System.out.println("ARG: " + a);
// 				}
					System.out.println("listOfArguments:  " + listOfArguments);
    }
// 
//     private static void printHotSpotOption(String option) throws Exception {
//         ObjectName name = new ObjectName("com.sun.management:type=HotSpotDiagnostic");
//         String operationName = "getVMOption";
//         Object [] params = new Object [] {option};
//         String [] signature = new String[] {String.class.getName()};
//         Object result = ManagementFactory.getPlatformMBeanServer().invoke(name, operationName, params, signature);
//         CompositeDataSupport data = (CompositeDataSupport) result;
// 
//         System.out.println(option);
//         System.out.println("- Value: "+data.get("value"));
//         System.out.println("- Origin: "+data.get("origin"));
//     }
// 
//     private static void printHotSpotOptions() throws Exception {
//         ObjectName name = new ObjectName("com.sun.management:type=HotSpotDiagnostic");
//         String attributeName = "DiagnosticOptions";
//         Object result = ManagementFactory.getPlatformMBeanServer().getAttribute(name, attributeName);
//         CompositeData [] array = (CompositeData[]) result;
//         for (CompositeData d : array) {
//             System.out.println(d.get("name"));
//             System.out.println("- Value: "+d.get("value"));
//             System.out.println("- Origin: "+d.get("origin"));
//         }
//     }
}
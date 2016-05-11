import java.io.*;
import java.util.*;
import java.net.*;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
 

class WebReader {
    public StringBuffer getData(String address) throws Exception {
        StringBuffer sb = new StringBuffer();
        
        URL page = new URL(address);
        StringBuffer text = new StringBuffer();
        HttpURLConnection conn = (HttpURLConnection) page.openConnection();
        conn.connect();
        InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
        BufferedReader buff = new BufferedReader(in);

        String line;
        do {
            line = buff.readLine();
            text.append(line + "\n");
        } while (line != null);
        sb.append(text.toString());
        return sb;
    }
}
/*
How many INFO log lines are there?
How many WARN log lines are there?
How many unique sn values are there?
How many unique si values are there?
What is max value for ss? (note, max ss is a value that is closest to 0 without being positive)
*/
class MicromapperInput {
    private int infoCount; 
    private int warnCount; 
    private int uniqSn; 
    private int uniqSi; 
    private int maxSs; 
 
 
    public MicromapperInput(){ 
 
    } 
 
    public MicromapperInput(int infoCount,int warnCount,int uniqSn ,int uniqSi,int maxSs){
        this.infoCount = infoCount; 
        this.warnCount = warnCount; 
        this.uniqSn = uniqSn; 
        this.uniqSi = uniqSi; 
        this.maxSs = maxSs; 
    } 
    
    public int getInfoCount() {
        return this.infoCount;
    }
    
    public int getWarnCount() {
        return this.warnCount;
    }
}

public class Solution {
    
    public static void main(String[] args) {
        String url = "http://interview.euclidanalytics.com/data";
        List<MicromapperInput> list = getAerialClickerInputData(url);
        for (MicromapperInput input: list) {
            System.out.println(input.getInfoCount());
        }
    }
    
    
    private static String getAerialClickerJsonData(String source) throws Exception{ 
        StringBuffer responseOutput = new StringBuffer(); 
        if(source.toLowerCase().startsWith("http")){ 
            URL stockURL = new URL(source); 
            BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream())); 
 
            String output; 
 
            // System.out.println("Output from Server ...." + response.getStatusLine().getStatusCode() + "\n"); 
            while ((output = in.readLine()) != null) { 
                responseOutput.append(output); 
            }; 
 
        } 
        else{ 
            BufferedReader br = new BufferedReader(new FileReader(source)); 
            String sCurrentLine; 
            while ((sCurrentLine = br.readLine()) != null) { 
                responseOutput.append(sCurrentLine); 
            } 
        } 
        return responseOutput.toString(); 
    } 
 
    public static List<MicromapperInput> getAerialClickerInputData(String url) throws Exception{

        String[] row = null;
        List<MicromapperInput> sourceSet = new ArrayList<MicromapperInput>();

        String geoJsonString = getAerialClickerJsonData(url);
        JSONParser parser = new JSONParser();

        JSONArray tileJson = (JSONArray)parser.parse(geoJsonString);

        for (Object object : tileJson) {
            JSONObject aJson = (JSONObject) object;
            JSONArray bounds = (JSONArray) aJson.get("bounds");
            String imgURL = (String) aJson.get("url");
            JSONArray imgSize = (JSONArray) aJson.get("size");

            MicromapperInput source = new MicromapperInput( imgURL, bounds.toJSONString(), imgSize.toJSONString());
            sourceSet.add(source);

        }

        return sourceSet;
    }
 
    
    public static void readAsText() throws Exception {
        WebReader app = new WebReader();
        
        StringBuffer sb = app.getData("http://interview.euclidanalytics.com/data");

        Map<String,Integer> map = new HashMap<String, Integer>();
        StringTokenizer st = new StringTokenizer(sb.toString(),",.! \n");
        while (st.hasMoreTokens()) {
            String letter = st.nextToken();
            int count;
            if (map.get(letter) == null) {
                count = 1;
            } else {
                count = map.get(letter).intValue() + 1;
            }
            map.put(letter,count);
        }
        Set<WordEntity> set = new TreeSet<WordEntity>();
        for (String key : map.keySet()) {
            set.add(new WordEntity(key,map.get(key)));
        }
        System.out.println("Print stat result:");
        for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
            WordEntity w = it.next();

            if (w.getKey().equals("INFO:")) {
                System.out.println("INFO Count :" +  w.getCount());
            }
            if (w.getKey().equals("WARN:")) {
                System.out.println("WARN Count :" +  w.getCount());
            }
        }
        
        
    }
}


class WordEntity implements Comparable<WordEntity> {
    private String key;
    private Integer count;
    public WordEntity (String key, Integer count) {
        this.key = key;
        this.count = count;
    }
    public int compareTo(WordEntity o) {
        int cmp = count.intValue() - o.count.intValue();
        return (cmp == 0 ? key.compareTo(o.key) : -cmp);
    }

    @Override
    public String toString() {
        return key + " log lines:" + count;
    }

    public String getKey() {
        return key;
    }

    public Integer getCount() {
        return count;
    }
}
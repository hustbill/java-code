package com.dockerforjavadevelopers.hello.controller;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringFormatter {
    // private static Logger logger = LoggerFactory.getLogger(StringFormatter.class);
    public static void main(String[] args) {    
        String input = "{\n    \"incidentId\": \"123\",\n    \"severity\": \"critical\",\n    \"serviceId\": \"opera_AI\",\n    \"actionId\": \"call_RedButton\",\n    \"envId\": \"prod\",\n    \"dataCenter\": \"OCE\",\n    \"reasonCode\": \"HIGH_5XX_TRAFFIC\"\n    }";
        String[] result = formatInputMap(input);
        System.out.print(result);

    }

    public static String[] formatInputMap(String input) {
        Map<String, String> map = new HashMap<String, String>();

        if (input.length() > 2) {
            // receive the POST request body from BOSUN notification, it includes multiple
            // "\n" chars
            String kvStr =  input;
                if (kvStr != null) {
                    Pattern pattern = Pattern.compile("\\s*|\t|\r|\n"); // remove chars: \t, \r, \n
                    Matcher matcher = pattern.matcher(kvStr);
                    kvStr = matcher.replaceAll("");
                }
                // Logger.debug("kvStr: ", kvStr);
            System.out.print("\n kvStr 1: " + kvStr + "\n");
            kvStr = kvStr.substring(1, kvStr.length() - 1);  // remove " "
            System.out.print("\n kvStr 2: " + kvStr + "\n");
            List<String> list = new ArrayList<String>(Arrays.asList(kvStr.split(","))); //split str to arraylist by comma
            // logger.debug("list: ", list);
            System.out.print("\n list: " + list + "\n");

            for (String str : list) {
                int index = str.indexOf(":");
                String key = str.substring(1, index - 1);
                String val = str.substring(index + 2, str.length() - 1);  //remove :, space, and comma             
                map.put(key, val);
            }
        }
       
    //    logger.debug("map: {}", map);
       System.out.print("\n map:" + map + "\n");


        String incidentId = map.containsKey("incidentId") ? map.get("incidentId"): "1234";
        String alertName = map.getOrDefault("alertName", "stackstormAlertName"); 
        String severity = map.get("severity");
        String serviceId= map.get("serviceId");
        String actionId = map.get("actionId");
        String envId = map.get("envId");
        String dataCenter = map.get("dataCenter");
        String reasonCode= map.get("reasonCode");
        String type = map.getOrDefault("type", "4xx"); 
        
        String[] result = {incidentId, alertName, severity, serviceId, actionId, envId, dataCenter, reasonCode, type};
        return result;

    }

    // public static String[] formatInputMap(Map<String, String> input) {
    //     Map<String, String> map = new HashMap<String, String>();

    //     if (input.size() < 2) {
    //         // receive the POST request body from BOSUN notification, it includes multiple
    //         // "\n" chars
    //         for (String kvStr : input.keySet()) {
    //             if (kvStr != null) {
    //                 Pattern pattern = Pattern.compile("\\s*|\t|\r|\n"); // remove chars: \t, \r, \n
    //                 Matcher matcher = pattern.matcher(kvStr);
    //                 kvStr = matcher.replaceAll("");
    //             }
    //             // Logger.debug("kvStr: ", kvStr);
    //         System.out.print("\n kvStr 1: " + kvStr + "\n");
    //         kvStr = kvStr.substring(1, kvStr.length() - 1);  // remove " "
    //         System.out.print("\n kvStr 2: " + kvStr + "\n");
    //         List<String> list = new ArrayList<String>(Arrays.asList(kvStr.split(","))); //split str to arraylist by comma
    //         // logger.debug("list: ", list);
    //         System.out.print("\n list: " + list + "\n");

    //         for (String str : list) {
    //             int index = str.indexOf(":");
    //             String key = str.substring(1, index - 1);
    //             String val = str.substring(index + 2, str.length() - 1);  //remove :, space, and comma             
    //             map.put(key, val);
    //         }
    //     }
    //    } else {
    //        map = input;  // receive the POST request body from postman
    //    }
    // //    logger.debug("map: {}", map);
    //    System.out.print("\n map:" + map + "\n");


    //     String incidentId = map.containsKey("incidentId") ? map.get("incidentId"): "1234";
    //     String alertName = map.getOrDefault("alertName", "stackstormAlertName"); 
    //     String severity = map.get("severity");
    //     String serviceId= map.get("serviceId");
    //     String actionId = map.get("actionId");
    //     String envId = map.get("envId");
    //     String dataCenter = map.get("dataCenter");
    //     String reasonCode= map.get("reasonCode");
    //     String type = map.getOrDefault("type", "4xx"); 
        
    //     String[] result = {incidentId, alertName, severity, serviceId, actionId, envId, dataCenter, reasonCode, type};
    //     return result;

    // }

}


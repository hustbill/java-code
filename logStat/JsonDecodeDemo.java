import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

class JsonDecodeDemo {

    public static void main(String[] args) {
        String personJSONData = 
            "  {" +
                "       \"name\": \"John\", " +
                    "       \"age\" : 35, " +
                        "       \"isMarried\" : true, " +
                            "       \"email\": null, " +
                                "       \"address\": { " +
                                    "           \"street\": \"#234, Pembroke Road\", " +
                                        "           \"city\": \"Dublin\", " +
                                            "           \"zipCode\": \"D4\" " +
                                                "       }, " +
                                                    "       \"phoneNumbers\": [\"89-923-2342\", \"89-213-2364\"] " +
                                                        "   }";
        JsonParser parser = Json.createParser(new StringReader(personJSONData));
        while (parser.hasNext()) {
            Event event = parser.next();
            switch (event) {
                case START_OBJECT:
                System.out.print("{/*" + event + "*/ ");
                break;
                case END_OBJECT:
                System.out.print("}/*" + event + "*/ ");
                break;
                case START_ARRAY:
                System.out.print("[/*" + event + "*/ ");
                break;
                case END_ARRAY:
                System.out.print("]/*" + event + "*/ ");
                break;
                case VALUE_NUMBER:
                System.out.print(parser.getInt() + "/*" + event + "*/, ");
                break;
                case VALUE_STRING:
                System.out.print(parser.getString() + "/*" + event + "*/, ");
                break;
                case VALUE_TRUE:
                System.out.print("true/*" + event + "*/, ");
                break;
                case VALUE_FALSE:
                System.out.print("false/*" + event + "*/, ");
                break;
                case VALUE_NULL:
                System.out.print("null/*" + event + "*/, ");
                break;
                case KEY_NAME:
                System.out.print(parser.getString() + "/*" + event + "*/: ");
                break;
                default:
                System.out.print("Unrecognized Event : ");
            }
        }
    }
      
    public static void test(String[] args){
	
        JSONParser parser = new JSONParser();
        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		
        try{
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray)obj;
			
            System.out.println("The 2nd element of array");
            System.out.println(array.get(1));
            System.out.println();

            JSONObject obj2 = (JSONObject)array.get(1);
            System.out.println("Field \"1\"");
            System.out.println(obj2.get("1"));    

            s = "{}";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,]";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,,2]";
            obj = parser.parse(s);
            System.out.println(obj);
        }catch(ParseException pe){
		
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }
}
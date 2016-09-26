import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;


class DateFormat {
    public static void main(String[] args) {
        //long startDate = 1474873200;
       long startDate =  1474959000;
        
	
        try {
            String result = unixToDate(startDate);
            System.out.println(result);  
            
            
            String recoverDate = DateToUnix(result);
            System.out.println("recoverDate " + recoverDate);
                
        } catch (Exception e) {
            System.out.println("error" + e.toString());
        }
     
         
    
    }
    

	public static String changeFormat(Date startDate) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		return df.format(startDate);
	}
    
    
	private static String unixToDate(long unix_timestamp) throws ParseException {    
		long timestamp = unix_timestamp * 1000;
		Date date = new Date(timestamp);     
		Format sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formatdate;
		formatdate= sdf.format(date);
		return formatdate;
	}
    
	//Converts Date and time in given format yyyy-MM-dd H:mm to unix Timestamp
	private static String DateToUnix(String date) throws ParseException {    
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d = dateFormat.parse(date );
		long unixTime = (long) d.getTime()/1000;
		return Long.toString(unixTime);
	}

}

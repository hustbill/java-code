package YapStone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Complete the function below.
 */
public class YapStoneReformatDate {
    static String[] Reformat(String[] dates)  {
        String[] result = new String[dates.length];
        
        for (int j=0; j < dates.length; j++) {
             result[j] = "";
            String input = dates[j];
            String[] strArr = input.split(" ");

            for (int i=0; i < strArr.length; i++) {
                String str = strArr[i];
               
                if (str.indexOf("nd") != -1) {
                    str = str.replace("nd", "");
                }

                if( str.indexOf("st") != -1 ) {
                    str = str.replace("st", "");
                }
                str = str.replace("th", "");
                if (str.length() == 1) {
                     str = "0" + str;
                }

                if ( i < strArr.length -1) {
                    str +=  "-";
                }

                result[j] += str;
               
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            try {
                Date d = formatter.parse(result[j]);
                result[j] = changeFormat(d);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
		
		return result;

    }

     public static String changeFormat(Date startDate) {

	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 

	    return df.format(startDate);
	}
}
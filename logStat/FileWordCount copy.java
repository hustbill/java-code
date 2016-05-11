import java.io.*;
import java.util.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


class WebReader extends JFrame {
    JTextArea box = new JTextArea("Getting data ...");

    public WebReader() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        JScrollPane pane = new JScrollPane(box);
        add(pane);
        setVisible(true);
    }

    public JTextArea getData(String address) throws Exception {
        setTitle(address);
        URL page = new URL(address);
        StringBuffer text = new StringBuffer();
        HttpURLConnection conn = (HttpURLConnection) page.openConnection();
        conn.connect();
        InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
        BufferedReader buff = new BufferedReader(in);
        box.setText("Getting data ...");
        String line;
        do {
            line = buff.readLine();
            text.append(line + "\n");
        } while (line != null);
        box.setText(text.toString());
        return box;
    }
 
}
 

public class FileWordCount {
    public static void main(String[] args) throws Exception {
        WebReader app = new WebReader();
        
        JTextArea textArea = app.getData("http://interview.euclidanalytics.com/data");
        
 

        String s = textArea.getText();
        StringBuffer sb = new StringBuffer();
        sb.append(s);
            
        // URL euclid = new URL("http://interview.euclidanalytics.com/data");
        //          URLConnection yc = euclid.openConnection();
        //          BufferedReader br = new BufferedReader(new InputStreamReader(yc.getInputStream()));   //
        //          String s;
        //          StringBuffer sb = new StringBuffer();
        //          while ((s = br.readLine()) != null) {
            //              sb.append(s);
            //          }
            //          br.close();
   
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
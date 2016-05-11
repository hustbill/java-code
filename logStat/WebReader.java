import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WebReader extends JFrame {
  JTextArea box = new JTextArea("Getting data ...");

  public WebReader() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 300);
    JScrollPane pane = new JScrollPane(box);
    add(pane);
    setVisible(true);
  }

  void getData(String address) throws Exception {
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
  }

  public static void main(String[] arguments) throws Exception {
    WebReader app = new WebReader();
    app.getData("http://interview.euclidanalytics.com/data");
  }
}
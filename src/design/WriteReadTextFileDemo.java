
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * This program demonstrates how to write characters to a text file.
 * @author hua zhang
 *
 */
public class WriteReadTextFileDemo {

    public static void main(String[] args) {
       
       WriteReadTextFileDemo wr = new WriteReadTextFileDemo();
       
        String fileName = "MyFile.txt";
        
        // Write file
        wr.writeFile(fileName);
        
        // read file
        wr.readFile(fileName);
 
    }
    
    public void writeFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
        Reader is the abstract class for reading character streams. 
        It implements the following fundamental methods:
        read(): reads a single character.
        read(char[]): reads an array of characters.
        skip(long): skips some characters.
        close(): closes the stream.
        */
    public void readFile(String fileName) {
         try {
             FileReader reader = new FileReader("MyFile.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
 
             String line;
 
             while ((line = bufferedReader.readLine()) != null) {
                 System.out.println(line);
             }
             reader.close();
 
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 
 }

// Ref : http://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
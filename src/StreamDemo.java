import java.util.*;
import java.util.function.*;


class StreamDemo {

    public static void main(String[] args) {
    
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

     // Stream stream  = Stream.of(1,2, 3, 4, 5);
  //    Stream.forEach(p -> System.out.println(p));
    }
}
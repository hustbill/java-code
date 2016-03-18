import java.util.stream;

class StreamDemo {

public static void main(String[] args) {

 Stream<Integer>  stream  = Stream.of(1,2, 3, 4, 5);
 Stream.forEach(p -> System.out.println(p));
}
}
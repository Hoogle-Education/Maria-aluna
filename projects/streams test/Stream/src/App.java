import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        
        List <Integer> lst1 = Arrays.asList(1, 2, 3, 4);
        Stream <Integer> stream1 = lst1.stream();
        System.out.println( Arrays.toString( 
            stream1.filter(x -> x%2 == 0).toArray() ));

        Stream <Integer> stream2 = Stream.iterate(5 ,  x -> x+5);
        System.out.println( Arrays.toString(stream2.limit(20).toArray()) );

    }
}

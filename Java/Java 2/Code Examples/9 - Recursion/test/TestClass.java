import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) throws IllegalMoveException {
    	List<Integer> arr = Arrays.asList(new Integer[] {});	
    	System.out.println(arr);
    	
    	arr = Recursion.subsetSums(arr);
    	System.out.println(arr);
    }
}
import java.util.ArrayList;

// Java program to demonstrate working of Scanner in Java
import java.util.Scanner;

public class WormyAlgeba {

    public static void main(String args[]){
       
        System.out.println("Run WormyAlgeba, please enter your n: ");

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("You entered integer " + n);

        ArrayList<Integer> res = wormyAlgeba(n)
        ;
        System.out.println("Output Arraylist: ");
        for (int num : res) {
            System.out.printf("  %d", num);
        }
    }


    private static ArrayList<Integer> wormyAlgeba(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            num = 2 * num;
            if (num >= 100) {
                num = num % 100;
            }
            res.add(num);
        }

        return res;
    }

}
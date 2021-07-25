import java.util.Scanner;
public class Shalou {
    public static void main(String[] args) {
        System.out.println("Please insert a number");
        Scanner sc = new Scanner(System.in);
        int scan = sc.nextInt();
        System.out.println("The first type of cup can hold 6 liters of water and the second type can hold 8 liters.");
        System.out.println("The number you inserted is: " + scan);
        System.out.println();
        if (scan >= 50) {
            System.out.println("Sorry, but we don't have that much water. Well, we can use the smaller one.");
            scan %= ((50 / 3) * 2);
        }
        System.out.println("The number you inserted is the the how many liters of water the pitcher can hold.");
        convertType(6, 8, scan);
    }
    static void convertType(Integer input1, Integer input2, int Target) {
        System.out.println("Take two different sized cups.");
        int x = input1;
        int y = input2;
        int z = input2;
        System.out.println("Fill the cups with water.");
        while (x >= 2) {
            System.out.println("Pour some water out until a certain amount.");
            System.out.println();
            x--;
            System.out.print("The first cup now has " + x + " liters and");
            y--;
            System.out.print("The second cup now has " + y + " liters.");
            System.out.println();
        }
        if (x >= 0) {
            System.out.print("The first cup now has " + x + " liter and");
            y--;
            System.out.print("The second cup now has " + y + " liters.");
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Take another large cup and fill it.");
        System.out.println("Repeat the steps until it can be poured in the pitcher.");
        if (z + y == Target) {
            System.out.println("It is finished.");
            return;
        }
        convertType(y * 2, z, Target / 2);
    }
}
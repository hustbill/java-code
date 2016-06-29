/*
Find the factorial of a number
url: http://www.programmingsimplified.com/java/source-code/java-program-find-factorial

Java program for calculating factorial of large numbers
Above program does not give correct result for calculating factorial of say 20. Because 20! is a large number and cant be stored in integer data type which is of 4 bytes. To calculate factorial of say hundred we use BigInteger class of java.math package.

*/

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

class BigFactorial
{
  public static void main(String args[])
  {
    int n, c;
    Random randomGenerator = new Random();
    n = randomGenerator.nextInt(14);
    BigInteger inc = new BigInteger("1");
    BigInteger fact = new BigInteger("1");

    Scanner input = new Scanner(System.in);

    System.out.printf("Input an integer: %d \n", n);
    //n = input.nextInt();

    for (c = 1; c <= n; c++) {
      fact = fact.multiply(inc);
      inc = inc.add(BigInteger.ONE);
    }

    System.out.println(n + "! = " + fact);
  }
}
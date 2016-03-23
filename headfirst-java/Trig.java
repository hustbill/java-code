/******************************************************************************
 *  Compilation:  javac Trig.java
 *  Execution:    java Trig angle
 *  
 *  Illustrates various trig operations. Reads in an angle (in degrees),
 *  converts to radians, and performs various trigonometric 
 *  calculations.
 *
 *  % java Trig
 *  sin(30.0) = 0.49999999999999994
 *  cos(30.0) = 0.8660254037844387
 *  tan(30.0) = 0.5773502691896257
 *  0.49999999999999994 / 0.8660254037844387 = 0.5773502691896256
 *  0.24999999999999994 + 0.7500000000000001 = 1.0
 *
 ******************************************************************************/

public class Trig { 
    public static void main(String[] args) {
        double degrees = 30.0;  //Double.parseDouble(args[0]);
        double radians = Math.toRadians(degrees);

        double s = Math.sin(radians);
        System.out.println("sin(" + degrees + ") = " + s);

        double c = Math.cos(radians);
        System.out.println("cos(" + degrees + ") = " + c);

        double t = Math.tan(radians);
        System.out.println("tan(" + degrees + ") = " + t);
        System.out.println(s + " / " + c + " = " + s / c);

        double r = s*s + c*c;
        System.out.println(s*s + " + " + c*c + " = " + r);
    }
}
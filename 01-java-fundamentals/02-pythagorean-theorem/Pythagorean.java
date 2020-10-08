
import java.lang.Math;
//import java.util.*;

public class Pythagorean{
    int legA;
    int legB;
    public double calculateHypotenuse(int legA, int legB) {
    //the hypotenuse is the side across from the right angle.
    double a = legA;
    double b = legB;
    double c = 0; //hypotenuse
    double squaredC=0; //hypotenuse squared

    //calculate the value of c given legA and legB

    //c = sqrt((legA * legA) + (legB * legB))

    squaredC = (double)(Math.pow(a,2) + Math.pow(b,2));
    System.out.println("squaredC = " + squaredC);
    
    c = Math.sqrt(squaredC);
System.out.println("Per Pythagorean, hypotenuse is: " + c);
    return squaredC;
    }
}
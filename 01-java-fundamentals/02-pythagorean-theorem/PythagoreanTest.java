//package javaFun;

//Use a method from the Math class to calculate the hypotenuse of a right triangle given the values of the two legs. HINT: Use the static sqrt method.
public class PythagoreanTest {
    // int a = 8;
    // int b = 6;
    public static void main(String[] args) {
        int a = 8;   //leg a of right triangle
        int b = 6;   //leg b of right triangle
        
        Pythagorean Hyp = new Pythagorean();
        Hyp = new Pythagorean();
        double squareHyp = Hyp.calculateHypotenuse(a, b);
    
 //   double four = 4.0;
// calling the sqrt static method of the Math class
double squareRoot = Math.sqrt(squareHyp);

System.out.println("Hypotenuse = " + squareRoot);
}

}

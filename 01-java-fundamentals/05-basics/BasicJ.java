import java.util.ArrayList;
import java.util.Arrays;

public class BasicJ {
    public static void main(String[] args) {

    //Print 1-255
    printTo255();

    //Print odd numbers between 1-255
    oddPrint(255);

    //Print Sum
    sumPrint();

    //Iterating through an array
    iterArray();

    //Find Max
    int[] testArray = {-3, -5, -7};
    findMax(testArray);

    //Get Average
    double[] fAveArr = {-3, -5, -7, 9.0, 
        0};
    getAve(fAveArr);

    //Array with Odd Numbers
    oddArrNum();

    //Greater Than Y
    int[] num = {1, 3, 5, 7};
    greaterY(num, 3);

    //Square the values
    int[] sqArray = {1,5,10,-2};
    squareArr(sqArray);

    //Eliminate Negative Numbers
    int[] testArr = {1, 5, 10, -2};
    elimNegNum(testArr);

    //Max, Min, and Average
    int[] multiArray = {1,5,10,-2};
    maxMinAve(multiArray);

    //Shifting the Values in the Array
    int[] notShftArr = {1, 5, 10, 7, -2};
    shiftArray(notShftArr);

    } //end of main

        public static void printTo255() {
            System.out.println("Write a method that prints all the numbers from 1 to 255.");
            //int[] printArray = new int[255];
            for (int i=1; i<=255;i++) {
              //  printArray[i-1] =i;
                System.out.println(i);
            }
      //  return printArray;
        } // end printTo255

public static void oddPrint(int num){
    System.out.println("Write a method that prints all the odd numbers from 1 to 255.");
   // int sum = 0;
     ArrayList<Integer> list = new ArrayList<Integer>();

   // int value = num;
    for (int i = 1; i<= num; i++){
        if (i % 2 != 0){
            list.add(i);
            System.out.println(i);
        }
    }
 //  return list;
}   // end oddPrint

public static void sumPrint() {
    System.out.println("Print the numbers from 0 to 255 with the sum of the numbers that have been printed so far.");
//int num = 0;
int sum = 0;
int value = 255;


    for (int i = 0; i <= value; i++) {
        sum = sum + i;
        System.out.println("New number: " + i + " Sum: "+ sum);
    }
} // end of sumPrint

public static void iterArray(){
    System.out.println("Iterate through each member of the given array and print each value on the screen.");
    int[] X = {1,3,5,7,9,13};
   // int sum = 0;
    
        for (int i = 0; i < X.length; i++) {
          //  sum = sum + X[i];
            System.out.println(X[i]);
        }
        System.out.println("");
} // end of iterArray

public static void findMax(int[] arr){
System.out.println("Take any array and print the maximum value in the array. ");
int max = Integer.MIN_VALUE;
for (int i = 0; i<arr.length; i++) {
    if(arr[i] > max){
        max = arr[i];
        }
    } 
    System.out.println("The maximum number in the given array is: "+ max);
    System.out.println("");
} //end of findMax

public static void getAve(double[] findAveArr){
    System.out.println("Take an array, and print the AVERAGE of the values in the array. Test for other complicated cases.");
    double avg =0;
    double total = 0;
    for (int i= 0; i < findAveArr.length; i++){
    total = total + findAveArr[i];
    avg = total/findAveArr.length;
    }

    System.out.format("The average is: %.3f", avg);
    System.out.println("");
    System.out.println("");
} //end of getAve

public static void oddArrNum(){
    System.out.println("Create an array 'y' that contains all the odd numbers between 1 to 255:");
    ArrayList<Integer> oddArrL = new ArrayList<Integer>();

for (int i = 1; i <= 255; i++) {
    if (i % 2 != 0) {
        oddArrL.add(i);
    }
   
        }
        System.out.println(oddArrL.toString());
        System.out.println("");
    }

public static ArrayList<Integer> greaterY(int[] num, int compare){

ArrayList<Integer> newArrL = new ArrayList<Integer>();
    System.out.println("Take an array and return the number of values in that array whose value is greater than a given value y.");
    
    for (int i = 0; i < num.length; i++) {
        if (num[i] > compare) {
            newArrL.add(num[i]);
        }
    }
    System.out.println("Here is an array (of the numbers from the given array) greater than " + compare + ": " + newArrL.toString());
    System.out.println("");
       
    return newArrL;
} // end of greaterY

public static void squareArr(int[] num){
     
    double answ = 0;
    ArrayList<Double> getArrayL = new ArrayList<Double>();

    System.out.println("These are the results of a method that multiplies each value in an array by itself. When the method is done, the array x should have values that have been squared:");

    // Nothing to do when array size is 1
    if (num.length > 1){
        for (int i = 0; i < num.length; i++) {
           answ = Math.pow((num[i]), 2);
      //     System.out.println("answ: " + answ);
             getArrayL.add(answ);
            //  System.out.println(num[i]);
        }
  //      return getArrayL;
    }
    System.out.println(getArrayL.toString());
    System.out.println("");

} //end of squareArr

public static void elimNegNum(int[] num){
     
    System.out.println("Given an array with multiple values, this method replaces any negative numbers within the array with the value of 0:");

    for (int i = 0; i < num.length; i++) {
        if (num[i] < 0) {
            num[i] = 0;
        }
    }
    System.out.println(Arrays.toString(num));
    System.out.println("");
} //end of elimNegNum

public static void maxMinAve(int[] num){
    Object[] mmaArray =new Object[3];
    
    System.out.println("This method returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array:");
    
    double avg =0;
    double total = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i<num.length; i++) {
        if(num[i] > max){
            max = num[i];
            }
        if(num[i] < min) {
            min = num[i];
            }
        total = total + num[i];
        avg = total/num.length;
    } 
    mmaArray[0] = max;
    mmaArray[1] = min;
    mmaArray[2] = avg;
 
//"The maximum, minimum, and average numbers for the array are: "+
    System.out.println( Arrays.toString(mmaArray));
    System.out.println("");
} //end of maxMinAve

public static void shiftArray(int[] num){
     
    System.out.println("Given any array x,  this method shifts each number by one to the front (or left). The last number is 0 and it does not wrap around the values shifted out of bounds:");

    System.arraycopy(num, 1, num, 0, num.length - 1);
   // System.out.println("\n" + Arrays.toString(num) + "\n");
    num[num.length-1] = 0;
    System.out.println(Arrays.toString(num));
 
} //end of shiftArray

} //end of BasicJava

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class PuzzleJava {
public static void main(String[] args) {

    System.out.println("The numbers > 10 are: " + sumArrayL().toString() + "\n");
    nameArray();
    charShuffle();
    System.out.println("> An array with 10 random numbers between 55-100: " +  "\n" + Arrays.toString(setRandomArray()) + "\n");
    tenRanArray(55, 100);
    randomStrg();
     System.out.println("> Here is an array with 10 random strings that are each 5 characters long:" + "\n" + Arrays.toString(tenArray()) + "\n");
}

public static ArrayList<Integer> sumArrayL(){
    System.out.println("> Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10: ");

    int[] sumArr = {3,5,1,2,7,9,8,13,25,32};
int sum = 0;
ArrayList<Integer> grtrArrayL = new ArrayList<Integer>();
for(int value: sumArr){
    sum +=value;
    if (value > 10) {
grtrArrayL.add(value);
    }
        }
System.out.println("\n" + "Array sum: " + sum + "\n");

return grtrArrayL;
}// end of sumArray

public static ArrayList<String> nameArray(){
    System.out.println("> Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters: ");

    int maxLength=5;

String[] nameArr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};

ArrayList<String> fiveCharArrL = new ArrayList<String>();

Random rand = new Random();
		
for(int i =0; i < nameArr.length; i++){
  
    if (nameArr[i].length() > maxLength){
        fiveCharArrL.add (nameArr[i]);
    }
}
for(int i =0; i < nameArr.length; i++){
			int randomIndexToSwap = rand.nextInt(nameArr.length);
			String temp = nameArr[randomIndexToSwap];
            nameArr[randomIndexToSwap] = nameArr[i];
            nameArr[i] = temp;
		
    }//end for
    System.out.println(Arrays.toString(nameArr) + "\n");

    System.out.println("The names with more than 5 characters are: " + fiveCharArrL.toString() + "\n");
    return fiveCharArrL;
}//end of nameArray

public static void charShuffle(){
    System.out.println("> Shuffle the array of alphabets and, after shuffling, display the last letter and the first letter of the array. If the first letter in the array is a vowel, have it display a message: " + "\n");

    ArrayList<Character> lastCharArrL = new ArrayList<Character>();

    Random rand = new Random();

    Character[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    for(int i =0; i < alphabets.length; i++){
        int randomIndexToSwap = rand.nextInt(alphabets.length);
        char temp = alphabets[randomIndexToSwap];
        alphabets[randomIndexToSwap] = alphabets[i];
        alphabets[i] = temp;
    
    }//end for

  
   char c1 =alphabets[0];
   char c2 = alphabets[alphabets.length-1];
  
   //ArrayList with two values: first and last letters
    lastCharArrL.add(c1);
    lastCharArrL.add(c2);

    

    if(c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u' ){
    System.out.println("The first letter in the new array: " + c1 + " is a vowel." + "\n");
    }else{
    System.out.println("The first letter in the new array: " + c1 + " is a consonant." + "\n");
    };
    if(c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u' ){
    System.out.println("The last letter in the new array: " + c2 + " is a vowel." + "\n");
    }else{
    System.out.println("The last letter in the new array: " + c2 + " is a consonant." + "\n");
    };
    
}//end of charShuffle

public static int[] setRandomArray() {
    int[] arr = new int[10];
 //  int offset = upperBound - lowerBound;
   Random r = new Random();
   for (int i = 0; i < arr.length; i++) {
       arr[i] = r.nextInt(100 - 55) + 55;
   }
  // Arrays.sort(arr);
   return arr; 
   }//end of setRandomArray

public static int[] tenRanArray(int start, int end){
    System.out.println("> Here are 10 random numbers between 55-100 sorted from the smallest to the largest, along with the minimum and maximum values in the array: " + "\n");

   // ArrayList<Inteiger> random = new ArrayList<Integer>();
    int[] myRandom = new int[10];
    for (int i = 0; i < 10; i++) { 
//      //   int random = getRandomInRange(1, 52);
//         myRandom[i] = (start + generator.nextInt(end - start + 1)); 
//         System.out.print(myRandom[i] + " "); 
//     

        double rand = Math.random();

        myRandom[i] = (int)(rand * ((end-start) + 1)) + start;
        }
        Arrays.sort(myRandom);

        int maxValue = myRandom[0]; 
        int minValue = myRandom[0];
        for(int i=1;i < myRandom.length;i++){ 
            if(myRandom[i] > maxValue){ 
            maxValue = myRandom[i]; 
            } 
            if(myRandom[i] < minValue){ 
            minValue = myRandom[i]; 
            } 
        }

        System.out.println(Arrays.toString(myRandom));
        System.out.println("minimum: " + minValue);
        System.out.println("maximum: " + maxValue + "\n");

     return myRandom;

}//end of tenRanArray

public static void randomStrg(){
System.out.println("> A random string that is 5 characters long:");
    //Create a random number
    
    int myRand =0;
    double rand = Math.random();
    myRand = (int)(rand * ((100-1) + 1)) + 1;

   // chose a Character random from this String 
   String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 

    // create StringBuffer size of AlphaNumericString 
    StringBuilder sb = new StringBuilder(myRand); 

    for (int i = 0; i < 5; i++) { 
  
        // generate a random number between 0 to AlphaNumericString variable length 
        int index = (int)(AlphaNumericString.length() 
                    * Math.random()); 

        // add Character one by one in end of sb 
        sb.append(AlphaNumericString 
                      .charAt(index)); 
    } 
    System.out.println(sb.toString() + "\n");

}//end of randomStrg

public static String[] tenArray(){
    //Generates an array with 10 random strings that are each 5 characters long
    String[] randomTen = new String[10];
    for (int i=0; i<10; i++){
        randomTen[i] = randString();
        }
       // System.out.println(Arrays.toString(randomTen));
        return randomTen;
    }//end of tenArray

public static String randString(){
//This method RETURNS A random string that is 5 characters long.;
    //Create a random number
    int myRand =0;
    double rand = Math.random();
    myRand = (int)(rand * ((100-1) + 1)) + 1;

   // chose a Character random from this String 
   String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 

    // create StringBuffer size of AlphaNumericString 
    StringBuilder sb = new StringBuilder(myRand); 

    for (int i = 0; i < 5; i++) { 
  
        // generate a random number between 0 to AlphaNumericString variable length 
        int index = (int)(AlphaNumericString.length() 
                    * Math.random()); 

        // add Character one by one in end of sb 
        sb.append(AlphaNumericString 
                      .charAt(index)); 
    } 
    return (sb.toString() + "\n");

}//end of randomStrg

} //end of PuzzleJava
public class FizzBuzz {
    //Write a program that will take an integer and print Fizz if the number is divisible by 3,
    // Buzz if the number is divisible by 5, FizzBuzz if the number is divisible by 3 and 5, 
    //and the number itself for all other cases.
    public String fizzBuzz(int number) {
        // fizzbuzz logic here
        String result;
       if(((number%3) == 0) && ((number%5) == 0)){
            result = "FizzBuzz";
       }
       else if ((number % 3) == 0){
            result = "Fizz";
       }
       else if ((number % 5) == 0){
            result = "Buzz";
       } 
       else {result = String.valueOf(number);}
        return result;
    }
}
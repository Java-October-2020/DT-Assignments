
public class StringManipulatorTesting{
    public static void main(String[] args) {
        //Trim both input strings and then concatenate them. Return the new string.
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld
        System.out.println("");

           // Get the index of the character and return either the index or null. If the character appears multiple times, return the first index.
        char letter = 'o';
        String a = manipulator.getIndexOrNull("Coding", letter);
        String b = manipulator.getIndexOrNull("Hello World", letter);
        String c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(letter + ", in the first word, is located at index: " + a); // 1
        System.out.println(letter + ", in the second word, is located at index: " + b); // 4
        System.out.println(letter + ", in the third word, is located at index: " + c); // null
        System.out.println("");

        //Get the index of the start of the substring and return either the index or null. 
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        String d = manipulator.getIndexOrNull(word, subString);
        String e = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(subString + ", in the first word, is located at index: " + d); // 2
        System.out.println(notSubString + ", in the first word, is located at index: " + e); // null
        System.out.println("");

        //Get a substring using a starting and ending index, and concatenate that with the second string input to our method.
        String word2 = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println("The concatenated string is: " + word2); // eworld
    }
}

public class StringManipulatorP{
    //Trim both input strings and then concatenate them. Return the new string.
    String trimAndConcat(String String1, String String2){
        String string1 = String1.trim();
        String string2 = String2.trim();
        String string3 = string1.concat(string2);
    // System.out.println(string3);
    return string3;
    }
    // Get the index of the character and return either the index or null. If the character appears multiple times, return the first index.
    String getIndexOrNull(String StringA, char ltr){
        int index = StringA.indexOf(ltr);
        if(index > -1 ){
            String s=Integer.toString(index); 
        return s;
        }
        else
            {return "null";
        }
    }
    //Get the index of the start of the substring and return either the index or null. 
    String getIndexOrNull(String StringC, String StringD){
        int index = StringC.indexOf(StringD);
        if(index > -1 ){
            String s=Integer.toString(index); 
        return s;
        }
        else
        {return "null";
        }
    }
    //Get a substring using a starting and ending index, and concatenate that with the second string input to our method.

    String concatSubstring(String StringG, int int1, int int2, String StringH){

        String result = StringG.substring(int1, int2);
        result = result.concat(StringH);
        return result;
    }
}
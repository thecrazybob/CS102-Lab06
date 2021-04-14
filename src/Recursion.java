import java.util.ArrayList;

/**
 * Instructions for Lab06 are in CS102_Lab06.pdf file located in the root
 * directory of Lab06 Revisions can be seen on the following GitHub URL:
 * https://github.com/thecrazybob/CS102-lab06 Style Guidelines:
 * http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 *
 * @author Mohammed Sohail
 * @version 14/04/2021
 */

public class Recursion {
    public static void main(String[] args) throws Exception {

        // a
        System.out.println("(a) Replace string:");
        System.out.println(replaceCharacter("r", "r myro ro ro ho roer"));
        
        // b
        System.out.println("(b) Decimal to Hex:");
        System.out.println(decimalToHex(1249));
        
        // c
        System.out.println("(c) Reverse string:");
        System.out.println(reverseString("this is very nice"));
        
        // d
        System.out.println("(d) Lexicographic ArrayList:");
        ArrayList<String> stringsList = new ArrayList<String>();
        
        stringsList.add("A");
        stringsList.add("B");
        stringsList.add("D");
        stringsList.add("C");
        
        System.out.println(isLexicographic(stringsList));
        
        // e
        System.out.println("(e) Even numbers passing criteria:");
        evenNumbers(3,0);
        System.out.println(isNumberInCritera(142));

    }
    
    // PART (a)

    /** 
     * Recursive method that computes a new string where all occurrences of the character "r" in an input string have been removed.
     * @param charStr
     * @param string
     * @return String
     */
    public static String replaceCharacter(String charStr, String string) {
        
        // Convert string to char
        char actualChar = charStr.charAt(0);

        // String is empty
        if (string.length() == 0) {
            return string;
        }
    
        char currentChar = string.charAt(0);

        if (currentChar == actualChar) {
            currentChar = '\0';
        }

        return currentChar + replaceCharacter(charStr, string.substring(1));

    }

    // PART (b)

    /** Recursive method that takes a decimal value as an int parameter and returns the hexadecimal equivalent of it as a string.
     * @param decimal
     * @return String
     */
    public static String decimalToHex(int decimal) {

        // if decimal is less than 10, get the string representation
        if (decimal < 10) {
            return Integer.toString(decimal);
        }

        // for decimal between 10-16 (not including 16)
        else if (decimal < 16) {
            switch (decimal) {
                case 10:
                return "A";
                case 11:
                return "B";
                case 12:
                return "C";
                case 13:
                return "D";
                case 14:
                return "E";
                case 15:
                return "F";
                default:
                return "";
            }
        }

        // for 16 and above
        else {
            return decimalToHex(decimal / 16) + "" + decimalToHex(decimal % 16);
        }

    }

    
    // PART (c)
    /** 
     * Recursive method that returns true if the strings in the array are in lexicographic (effectively alphabetic) order, and false otherwise
     * @param stringsArrayList
     * @return boolean
     */
    public static boolean isLexicographic(ArrayList<String> stringsArrayList) {

        // array has one element
        if (stringsArrayList.size() == 1) {
            return true;
        }

        String firstElement = stringsArrayList.get(0);
        String secondElement = stringsArrayList.get(1);

        // compare first and second elements lexicographically
        if (firstElement.compareTo(secondElement) > 0)  {
            return false;
        }

        else {

            // remove first element
            stringsArrayList.remove(0);

            // iterate over the rest
            return isLexicographic(stringsArrayList);

        }

    }

    
    // PART (d)
    
    /** 
     * Recursive method that prints its String argument in reverse direction
     * @param originalString
     * @return String
     */
    public static String reverseString(String originalString) {

        // length of string
        int length = originalString.length();

        // string is one letter
        if (length == 1) {
            return originalString;
        }

        // get last letter
        String lastLetter = originalString.substring(length - 1);

        // iterate
        return lastLetter + reverseString(originalString.substring(0, length - 1));
    
    }

    
    // PART (e)
    /** 
     * Prints all n-digit even numbers in which each digit of the number, from its most-significant to least-significant digits, is greater than the previous one
     * @param n
     */
    public static void evenNumbers(int n, int nextEven) {
        
        // start and end limits according to n
        int startLimit = 1 * (int) Math.pow(10, n-1);
        int endLimit = (1 * (int) Math.pow(10, n)) - 1;
        
        // newly generated even number
        int newEven = startLimit + (nextEven * 2);

        // if its within the limits
        if (newEven < endLimit) {

            // if its within the criteria
            if (isNumberInCritera(newEven)) {
                System.out.println(newEven);
            }
        	
            // iterate further
            evenNumbers(n, nextEven+1);

        }
        
    }

    
    /** 
     * Determines whether a number meets the stated criteria:
     * The most-significant to least-significant digits, is greater than the previous one (that is, for instance, the number 124 is ok, but the number 142 is not, since 2 is less than 4). 
     * @return boolean
     */
    public static boolean isNumberInCritera(int number) {

        // convert integer to string
        String numberStr = number + "";

        // number is single digit
        if (numberStr.length() == 1) {
            return true;
        }

        // number doesn't satisfy the criteria
        if (numberStr.charAt(0) >= numberStr.charAt(1)) {
            return false;
        }

        // iterate further if it satisfies the criteria
        return isNumberInCritera(Integer.parseInt(numberStr.substring(1)));

    }


}

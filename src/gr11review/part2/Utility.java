package gr11review.part2;
import java.io.*;
import java.util.*;

/**
* java files of metthods
* @author: J. Cheung
*/

public class Utility {

/**
* Given a string, return the sum of the numbers appearing in the string
* Ignoring all other characterds
* @param string that will convert
* @return the sum of numbers in string
* @author J. Cheung
*/

  public static int sumNumbers(String str) {

      // initializing variables
      int intCount;
      int intlength;
      int intSum = 0;
      String strNum = "";
      intlength = str.length();

      // Checks each character in String 
      for (intCount = 0; intCount < intlength; intCount++){
        
        // Checks if current character is a digit
        if (Character.isDigit(str.charAt(intCount))) {

          if (intCount < intlength - 1 && Character.isDigit(str.charAt(intCount + 1))){
            strNum += str.charAt(intCount);
          }  

          else {
            strNum += str.charAt(intCount);
            intSum += Integer.parseInt(strNum);
            strNum = "";
          }
        }
      }

    return intSum; 
  }

/** 
* Return the word that is alphabetically first
* @param filenametxt which is the name of the file txt that will be anaylzed 
* @return the word that is alphabetically first in the filename.txt file 
* @author J. Cheung
*/

  public static String alphaWord(String filenametxt) throws IOException {

    BufferedReader key = new BufferedReader(new FileReader(filenametxt));
    
    // initializing variables

    String strFileLine;
    String strAlphabetical;
    strAlphabetical = key.readLine();

    // if the file is empty and has nothing in it return 
    if (strAlphabetical == null){
      key.close();
      return "";
    }

    strFileLine = "";

    // Going through each string line of the file

    while (strFileLine != null) {
      
      strFileLine = key.readLine();

      if (strFileLine != null && strAlphabetical.compareToIgnoreCase(strFileLine) > 0){
      
        strAlphabetical = strFileLine;

      }

    }

  //closing file and returning string
  key.close();
  return strAlphabetical;


}


    
/**
* Return of an array where every instance of the given value is replaced 
* to its numerically greatest value to its left or right
* @param analzying the arrays
* @return array where all of the value turn into its greatest value
* @author J. Cheung
*/

  public static int[] notAlone(int[] nums, int value){
    
    // initializing variables 
    int intLength;
    intLength = nums.length;

    // loops through the array 
    for (int intCount = 1; intCount < intLength -1; intCount++){
      
      // If the num = to the value and not the the num to th left and right it will set the current number = to the greatest number of the two
      if (nums[intCount] == value) {
        if (nums[intCount - 1] != nums[intCount] && nums[intCount + 1] != nums[intCount]) {
          nums[intCount] = Math.max(nums[intCount -1], nums[intCount +1]);
        }

      }
    
    }
   
    return nums;

  }

  /**
  * Returns either an array that can be split into equal sums 
  * @param anayalzing the num of array
  * @return boolean of weather it can be split into an equal sum
  * @author J. Cheung
  */

  public static boolean canBalance(int[] nums) {

    // initializing variables
    int intLength;
    int intSum;
    int intSum2;
    int intCount;
    intLength = nums.length;
    intSum = 0;
    intSum2 = 0;
    

    // Obtaining the sums of all numbers in the array
    for (intCount = 0; intCount < intLength; intCount++) {
      intSum += nums[intCount];
    }

    // Looping the array to keep track of the sum
    for (intCount = 0; intCount < intLength; intCount++) {
      intSum2 += nums[intCount];

      // return true if the array is equal 
      if (intSum == intSum2) 
       return true;
    
    }

    // as back up
    return false;

  }

  /**
  * Given an interger a two dimensional array of size (nxn) is created with comma between
  * The positions on the minor diagonal (from the upper right to the lower left corner)    receive 1 .
  * The positions above this diagonal receive 0 .
  * The positions below the diagonal receive 2 .
  * @param n the num that determines the size of array
  * @author J. Cheung
  */

  public static void diagonal(int n) throws IOException {

    // printwriter

    PrintWriter theBox = new PrintWriter (new FileWriter("src/gr11review/part2/diagonalOut.txt", true));

    // initialzing variables

    int[][] intBox = new int[n][n];
    int intCount;
    int intCount2;

    // Analyzing each row of the box 

    for (intCount = 0; intCount < n; intCount++) {

      for (intCount2 = 0; intCount2 < n; intCount2++){

        if (intCount2 < n - intCount - 1) {
          intBox[intCount][intCount2] = 0;
        }

        else if (intCount2 == n - intCount - 1) {
          intBox[intCount][intCount2] = 1;
        }

        else {
          intBox[intCount][intCount2] = 2;
        }

      }

    }

    // anaylzing to print to text file
    // Goes through every row
  
    for (intCount = 0; intCount < n; intCount++) {
      
      for (intCount2 = 0; intCount2 < n; intCount2++){
        theBox.print(intBox[intCount][intCount2]);
        if (intCount2 != n - 1) {
          theBox.print(",");
        }
      }

    theBox.println("");
    }

    // closing the file
    theBox.close();
}



}

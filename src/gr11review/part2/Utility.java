package gr11review.part2;
import java.io.*;


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

    
}

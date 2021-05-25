package gr11review.part2;
import java.io.*;
import java.util.*;

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

    PrintWriter theBox = new PrintWriter (new FileWriter("diagonalOut.txt", true));

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


  public static String zipZap(String str){
    // set a string variable to output the final string
    String finalOut = "";
    // set a for loop to iterate over the inputted string
    for(int i = 0; i<(str.length()); i++){
      // make sure that when looking for zxp words, that the character index doesn't go over the lenght of given string
      if(i <= (str.length()-3)){
        /**
        * look for three letter substrings that start with z and end with p
        * when you find any replace it with xp
        */
        if(str.charAt(i) == 'z' && str.charAt(i+2) == 'p'){
          finalOut += "zp";
          i += 2;
        }else 
        // if it doesn't detect it, simply write the given character into the finalOut variabe
        finalOut += str.charAt(i);
      }else
        // if therer are less than 3 index values left/if the string is less than 3 index values, just add the character to finalOut
        finalOut += str.charAt(i);
    }
    // return the final string
    return finalOut;
  }
  public static int[] tenRun(int[] nums){
    // set a variable to hold a temporary integer value
    int newNum = 0;
    // run a for loop that iterates over the length of the given array - 1
    for(int i = 0; i < nums.length-1; i++){
      // if the array index value is a multiple of 10, set the newNum variable to it
      if(nums[i] % 10 == 0){
        newNum = nums[i];
        // if the program has not made it to final index value, have it move on to the next value
        if(i < nums.length-1){
          i++; 
        }
        /**
        * set a while loop to replace every sebsequent value after the index value that was
        * a multiple of ten with it.
        * Until you reach a new multiple of 10
        */
        while(nums[i] % 10 != 0){
          nums[i] = newNum;
          // make sure you haven't reached the end of the array, and keep interating through if you haven't
          if(i < nums.length-1){
            i++;
          }
        }
        /* if you reach a new value that is a multiple of 10, go back one index value
        * This allows you to set the newNum value to this index value when the for loop incereases the counter
        */
        if(nums[i] % 10 == 0){
            i--;
          }
      }
    }
    // return the changed array
    return nums;
  } 
  public static String longestWord(String filenametxt){
    // set a string to hold the longest word
    String longest = "";
    // set a bufferedreader to read over the inputs from the file
    try (BufferedReader keyboard = new BufferedReader(new FileReader(filenametxt))){
      /**
      * set an integer value that counts the number of characters a word has
      * set a string value to hold the string the file reader is currently reading
      */
      int length = 0;
      String st = "";
      // a while loop will run as long as the file reader is reading something that isn't an empty line
      while((st = keyboard.readLine()) != null){
        /**
        * if the length of the word it has read is larger than/equal to the length variable
        * set the length variable to the length of that word
        * set the longest word variable to that word
        */
        if(st.length() >= length){
          longest = st;
          length = st.length();
        }
      }
    // set a catch statement for anything that might go wrong when trying to open/read the file
    }catch (Exception e){
      System.out.println("Something went wrong.");
    }
    // return the longest word
    return longest;
  }
  public static boolean linearIn(int[] outer, int[] inner){
    // set a counter variable to interate through the outer array
    int s = 0;
    // set a for loop to iterate through the inner array
    for(int i = 0; i < inner.length-1; i++){
      /**
      * for each value of the inner index
      * check first if the value for the outer at the same index number is greater
      * if it is then, it is deduced that, the inner array value does not exist
      */
      if(inner[i] < outer[s]){
        return false;
      }
      /**  
      * iterate over the rest of the outer array, test each value against the inner index value
      * if the inner array number becomes smaller thant he outer array number, return false
      */
      while(inner[i] >= outer[s]){
        if(inner[i] < outer[s]){
          return false;
        }
        // iterate through the outer array until it either return false or reaches the end
        s++;
      }
    }
    // if nothing has returned false, then return true
    return true;
  }
  public static void pascalTri(int i, int j){
    /**
    * i is how many rows
    * j is how many columns
    */
    int[][] triangle = new int [i][j];
        // fill the first row and column with ones
        for(int x = 0; x < i; x++){
          triangle[x][0] = 1;
        }for(int x = 0; x < j; x++){
          triangle[0][x] = 1;
        }
        /**
         * iterate over the rest of the array
         * using the index value that is one row above and the index value one column before
         * set the chosen index value (i) to be the sum of those two
         * set that value to the triangle array
         */
        if(i > 1 && j > 1){
          for(int x = 1; x<i; x++){
            for(int y = 1; y<j; y++){
              triangle[x][y] = (triangle[x-1][y]+triangle[x][y-1]);
            }
          }
        }
    try{
      // create a new file to write in
      FileWriter writer = new FileWriter("pascalOut.txt");
      BufferedWriter fileWrite = new BufferedWriter(writer);
      // iterate over both the column and row to write each value of the array into the file
      for(int x = 0; x<i; x++){
        for(int y = 0; y<j; y++){
          fileWrite.write(Integer.toString(triangle[x][y]));
          if(y<j-1){
            // write in the commas between numbers
            fileWrite.write(",");
          }
        }
        fileWrite.write('\n');
      }
      /**
       * make sure to put each row in its own line
       * close file
       */
      fileWrite.write('\n');
      fileWrite.close();
    }catch (Exception e){
      // catch eny exepction write out a message for any unexpected errors
      System.out.println("Something went wrong.");
    }      
  }
}

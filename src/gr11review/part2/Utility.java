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





    
}

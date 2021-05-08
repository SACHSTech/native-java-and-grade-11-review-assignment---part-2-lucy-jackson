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
      int intCount2;
      int intSum = 0;
      

      for (intCount = 0; intCount < str.length(); intCount++) {
        
        if (Character.isDigit(strCharAt(intCount))) {
          
          // we start at intCount2 + 1 because we know intCount has a digit 

          for (intCount2 = intCount + 1; intCount2 < str.length() && Character.isDigit(strChartAt(intCount2)); intCount2++);

          intSum += Integer.parseInt(str.subString(intCount, intCount2));
          intCount = intCount2;

        }

      }
    return intSum; 

  }

/** 
* Return the word that is alphabetically first
* @param filenametxt which is the name of the file txt that will be anaylzed 
* @author J. Cheung
*/

  public static String alphaWord(String filenametxt) throws IOException {










  }




    
}

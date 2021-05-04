package gr11review.part2;
import java.io.*;

public class Utility{
  public static String zipZap(String str){
    String finalOut = "";
    for(int i = 0; i<(str.length()); i++){
      if(i <= (str.length()-3)){
        if(str.charAt(i) == 'z' && str.charAt(i+2) == 'p'){
          finalOut += "zp";
          i += 2;
        }else 
        finalOut += str.charAt(i);
      }else
        finalOut += str.charAt(i);
    }
    return finalOut;
  }
}
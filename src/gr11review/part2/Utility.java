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
  public static int[] tenRun(int[] nums){
    int newNum = 0;
    for(int i = 0; i < nums.length-1; i++){
      if(nums[i] % 10 == 0){
        newNum = nums[i];
        if(i < nums.length-1){
          i++; 
        }
        while(nums[i] % 10 != 0){
          nums[i] = newNum;
          if(i < nums.length-1){
            i++;
          }
        }
        if(nums[i] % 10 == 0){
            i--;
          }
      }
    }
    return nums;
  } 
  public static String longestWord(String filenametxt){
    String longest = "";
    try (BufferedReader keyboard = new BufferedReader(new FileReader(filenametxt))){
      int length = 0;
      String st = "";
      while((st = keyboard.readLine()) != null){
        if(st.length() >= length){
          longest = st;
          length = st.length();
        }
      }
    }catch (Exception e){
      System.out.println("Something went wrong.");
    }
    return longest;
  }
  public static boolean linearIn(int[] outer, int[] inner){
    int s = 0;
    for(int i = 0; i < inner.length-1; i++){
      if(inner[i] < outer[s]){
        return false;
      }
      while(inner[i] >= outer[s]){
        if(inner[i] < outer[s]){
          return false;
        }
        s++;
      }
    }
    return true;
  }
  public static void pascalTri(int i, int j){
    /* i is how many rows
    * j is how many columns
    */
    int[][] triangle = new int [i][j];
        for(int x = 0; x < i; x++){
          triangle[x][0] = 1;
        }for(int x = 0; x < j; x++){
          triangle[0][x] = 1;
        }
        if(i > 1 && j > 1){
          for(int x = 1; x<i; x++){
            for(int y = 1; y<j; y++){
              triangle[x][y] = (triangle[x-1][y]+triangle[x][y-1]);
            }
          }
        }
    try{
      FileWriter writer = new FileWriter("src\\gr11review\\part2\\pascalOut.txt");
      BufferedWriter fileWrite = new BufferedWriter(writer);
      for(int x = 0; x<i; x++){
        for(int y = 0; y<j; y++){
          fileWrite.write(Integer.toString(triangle[x][y]));
          if(y<j-1){
            fileWrite.write(",");
          }
        }
        fileWrite.write('\n');
      }
      fileWrite.write('\n');
      fileWrite.close();
    }catch (Exception e){
      System.out.println("Something went wrong.");
    }      
  }
}
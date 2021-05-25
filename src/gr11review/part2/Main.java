package gr11review.part2;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        System.out.println(Utility.zipZap("ziiiiipxxzap"));
        System.out.println(Utility.longestWord("src/gr11review/test2/Review2_3Test_3.txt"));
        System.out.println(Utility.linearIn(new int[] {3, 6, 7, 9}, new int[] {3, 4, 6, 7, 9}));
        Utility.pascalTri(3, 5);
        int[][] triangle = new int [1][5];
        for(int x = 0; x < 1; x++){
          triangle[x][0] = 1;
        }for(int x = 0; x < 5; x++){
          triangle[0][x] = 1;
        }
        if(1 > 1 && 5 > 1){
          for(int x = 1; x<1; x++){
            for(int y = 1; y<5; y++){
              triangle[x][y] = (triangle[x-1][y]+triangle[x][y-1]);
            }
          }
        }
        for(int x = 0; x<1; x++){
            for(int y = 0; y<5; y++){
              System.out.print(triangle[x][y]);
              if(y<5-1){
                System.out.print(",");
              }
            }
            System.out.println();
          }
        
    }
}


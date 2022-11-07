import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
    
        int row = land.length;
        int col = land[0].length;
        
        int dp[][] = new int[row][col];
        
        for(int i = 0 ; i < col ; i++) {
            dp[row-1][i] = land[row-1][i];
        }
        
        for(int i = row -2 ; i >= 0 ; i--) {
            for(int j = 0 ; j < col ; j++) {
                for(int k = 0 ; k < col ; k++) {
                    if(j == k) continue;
                    
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i+1][k]);
                }
            }
        }
        
        for(int i = 0 ; i < col ; i++) {
            answer = Math.max(answer, dp[0][i]);
        }

        return answer;
    }
}
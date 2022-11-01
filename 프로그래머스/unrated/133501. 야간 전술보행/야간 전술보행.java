import java.util.*;

class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = distance;
        
        for(int i = 0 ; i < scope.length ; i++) {
            
            Arrays.sort(scope[i]);
            int a = scope[i][0];
            int b = scope[i][1];
            
            int totalTime = times[i][0] + times[i][1];
            
            for(int j = a ; j <= b ; j++) {
                int time = j % totalTime;
                if(time == 0) {
                    time = totalTime;
                }
                
                //근무중에 걸린것임
                if(time <= times[i][0]) {
                    answer = Math.min(answer, j);
                    break;
                }
                
            }
            
        }
        
        
        return answer;
    }
}
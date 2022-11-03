import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = -1;
        Arrays.sort(citations);
        
        int count = 0;
        for(int i = citations.length -1 ; i >= 0 ; i--) {
            count ++;
            if(count == citations[i]) {
                answer = count;
                break;
            }
            
            if(count > citations[i]) {
                answer = count - 1;
                break;
            }
        }
        
        if(answer == -1) {
            answer = citations.length;
        }
        
        return answer;
    }
}
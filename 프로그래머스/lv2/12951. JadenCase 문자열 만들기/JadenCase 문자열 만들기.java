import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        
        for(int i = 0 ; i < s.length() ;i++) {
            if(i == 0) {
                answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
                continue;
            }
            
            if(s.charAt(i-1) == ' ') {
                answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
                continue;
            }
            
            answer += String.valueOf(s.charAt(i));
        }
        
        return answer;
    }
}
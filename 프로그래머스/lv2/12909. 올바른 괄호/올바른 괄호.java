import java.util.*;
class Solution {
    
    static boolean visit[];
    
    boolean solution(String s) {

        visit = new boolean[s.length()];
        
        int count = 0;
        
        for(int i = s.length() -1 ; i >= 0 ; i--) {
            if(s.charAt(i) == '(') {
                if(count == 0) {
                    return false;
                }
                count--;
            }else{
                count ++;
            }
        }
        
        if(count >= 1) {
            return false;
        }

        return true;
    }
}
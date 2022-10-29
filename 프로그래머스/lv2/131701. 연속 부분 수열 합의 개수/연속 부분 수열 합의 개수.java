import java.util.*;
class Solution {
    
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int answer = 0;
        
        int n = elements.length;
        
        for(int i = 1 ; i < n ; i++) {
            
            int sum = 0;
            
            for(int j = 0 ; j < i ; j++) {
                sum += elements[j];
            }
            set.add(sum);
            
            int left = 0;
            int right = i;
            while(left < n) {
                
                sum -= elements[left];
                left ++;
                sum += elements[right];
                right ++;
                if(right >= n) {
                    right = 0;
                }
                set.add(sum);
                
            }
            
        }//1
        
        int total = 0;
        for(int i = 0 ; i < n ; i++) {
            total += elements[i];
        }
        set.add(total);
        
        answer = set.size();
        
        return answer;
    }
}
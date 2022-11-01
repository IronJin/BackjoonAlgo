import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        
        int[] answer = new int[n];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        long num = 1;
        for(int i = 1 ; i <= n ; i++) {
            num *= i;
            list.add(i);
        }
        k--;
        int idx = 0;
        while(idx < answer.length) {
            num = num/n;
            n--;
            answer[idx] = list.get((int)(k/num));
            list.remove((int)(k/num));
            idx++;
            k %= num;
        }
        
        return answer;
    
    }
    
    
    
}
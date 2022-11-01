import java.util.*;

class Solution {
    public String solution(int n) {
        
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {
            int r = n % 3;
            int q = n / 3;
            if(r == 0) {
                q -= 1;
            }
            list.add(r);
            n = q;
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "4");
        map.put(1, "1");
        map.put(2, "2");
        for(int i = list.size() - 1 ; i >= 0 ; i--) {
            answer += map.get(list.get(i));
        }
        
        
        return answer;
    }
    
}
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        
        for(int i = 0 ; i < topping.length ; i++) {
            if(!mapB.containsKey(topping[i])) {
                mapB.put(topping[i], 1);
            }else {
                mapB.put(topping[i], mapB.get(topping[i]) + 1);
            }
        }
        
        for(int i = 0 ; i < topping.length ; i++) {
            if(!mapA.containsKey(topping[i])) {
                mapA.put(topping[i],1);
            }else {
                mapA.put(topping[i], mapA.get(topping[i]) + 1);
            }
            
            if(mapB.get(topping[i]) == 1) {
                mapB.remove(topping[i]);
            }else {
                mapB.put(topping[i], mapB.get(topping[i]) - 1);
            }
            
            //비교
            if(mapA.size() == mapB.size()) {
                answer++;
            }
            
        }
        
        return answer;
    }
}
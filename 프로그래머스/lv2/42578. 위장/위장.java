import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < clothes.length ; i++) {
            String type = clothes[i][1];
            if(map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            }else {
                map.put(type, 1);
            }
        }

        ArrayList<Integer> countList = new ArrayList<>();
        for(String key : map.keySet()) {
            countList.add(map.get(key));
        }
        
        int answer = 1;
        for(Integer i : countList) {
            answer *= i + 1;
        }
        
        return answer - 1;
        
    }
    
    
    
}
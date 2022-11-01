import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> discountMap = new HashMap<>();
        
        for(int i = 0 ; i < want.length ; i++) {
            wantMap.put(want[i],number[i]);
        }
        //기본세팅 완료
        
        //투포인터를 이용할 거임
        for(int i = 0 ; i < 10 ; i++) {
            
            if(!discountMap.containsKey(discount[i])) {
                discountMap.put(discount[i], 1);
            }else {
                discountMap.put(discount[i], discountMap.get(discount[i])+1);
            }
            
        }
        
                
        int left = 0;
        int right = 10;
        
        
        while(right <= discount.length) {
            
            boolean pos = true;
            for(String key : wantMap.keySet()) {
                if(!discountMap.containsKey(key)) {
                    pos = false;
                    break;
                }
                
                if(discountMap.get(key) != wantMap.get(key)) {
                    pos = false;
                    break;
                }
                
            }
            
            if(pos) {
                answer++;
            }
            
            if(right >= discount.length) break;
            
            if(!discountMap.containsKey(discount[right])) {
                discountMap.put(discount[right],1);
            }else {
                discountMap.put(discount[right], discountMap.get(discount[right])+1);
            }
            
            discountMap.put(discount[left], discountMap.get(discount[left])-1);
            
            right++;
            left++;
            
        }
        
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < scoville.length ; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.size() >= 2) {
            int first = pq.poll();
            if(first >= K) {
                return answer;
            }
            
            answer++;
            int second = pq.poll();
            int newfood = first + second*2;
            pq.add(newfood);
            
        }
        
        if(pq.poll() >= K) {
            return answer;
        }
        
        return -1;
    }
}
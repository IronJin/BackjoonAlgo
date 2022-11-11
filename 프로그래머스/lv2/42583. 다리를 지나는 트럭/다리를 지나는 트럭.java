import java.util.*;

//큐를 활용한 구현문제
//큐에는 현재 다리를 건너는 트럭이고 여러대의 트럭이 못들어가는 경우 그냥 큐에 0을 넣어줘서 칸을 차지하도록 만들것
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        
        int arrived = 0;
        int n = truck_weights.length;
        int curpoint = 0;
        
        while(arrived < n) {
            
            if(q.size() == bridge_length) {
                
                int poll = q.poll();
                if(poll > 0) {
                    arrived++;
                }
                total -= poll;
                
                if(curpoint < n) {
                    if(total + truck_weights[curpoint] <= weight) {
                        total += truck_weights[curpoint];
                        q.add(truck_weights[curpoint]);
                        curpoint++;
                    }else {
                        q.add(0);
                    }
                }else {
                    q.add(0);
                }
                
            }else {
                
                if(curpoint < n) {
                    if(total + truck_weights[curpoint] <= weight) {
                        total += truck_weights[curpoint];
                        q.add(truck_weights[curpoint]);
                        curpoint++;
                    }else {
                        q.add(0);
                    }
                }else {
                    q.add(0);
                }
                
            }
            
            answer++;
        }
        
        
        
        return answer;
    }
}
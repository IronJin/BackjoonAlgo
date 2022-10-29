import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Queue<Integer> mainQ = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();
        
        int n = order.length;
        for(int i = 1 ; i <= n ; i++) {
            mainQ.add(i);
        }
        //초기값 세팅 완료
        
        //현재 order 가 큐에서 맨 처음 뽑은거보다 크다면 스택에 넣어주고 answer 1 증가
        //그게 아니라면 스택 맨위에서 뽑도록 할것
        for(int i = 0 ; i < n ; i++) {
            
            if(!mainQ.isEmpty()) {
                if(mainQ.peek() <= order[i]) {
                    while(!mainQ.isEmpty()) {
                        int q = mainQ.poll();
                        if(q == order[i]) {
                            answer++;
                            break;
                        }else {
                            sub.push(q);
                        }
                    }
                }else {
                    int stack = sub.pop();
                    if(stack == order[i]) {
                        answer++;
                    }else{
                        break;
                    }
                }
            }else{
                int stack = sub.pop();
                if(stack == order[i]) {
                    answer++;
                }else{
                    break;
                }
            }
            
        }
        
        
        
        return answer;
    }
}
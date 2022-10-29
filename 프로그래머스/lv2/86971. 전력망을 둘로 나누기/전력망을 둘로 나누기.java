import java.util.*;

class Solution {
    
    static ArrayList<Integer> list[];
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        list = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }
        
        //----------초기화---------
        
        for(int i = 0 ; i < wires.length ; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        //그래프 연결
        
        //리스트에서 끊어주고 bfs 돌려서 둘의 차이 구하기
        for(int i = 0 ; i < wires.length ; i++ ) {
            int a = wires[i][0];
            int b = wires[i][1];
            //[a] 에서 b 찾아서 b 없애주기
            for(int j = 0 ; j < list[a].size() ; j++) {
                if(list[a].get(j) == b) {
                    list[a].remove(j);
                }
            }
            for(int j = 0 ; j < list[b].size(); j++) {
                if(list[b].get(j) == a) {
                    list[b].remove(j);
                }
            }
            
            boolean visit[] = new boolean[n+1];
            ArrayList<Integer> TwoWide = new ArrayList<>();
            for(int j = 1 ; j <= n ; j++) {
                if(visit[j] == false) {
                    TwoWide.add(bfs(j,1,visit));
                }
            }
            
            answer = Math.min(answer, Math.abs(TwoWide.get(0) - TwoWide.get(1)));
            
            //다시 이어주기
            list[a].add(b);
            list[b].add(a);
            
        }
        
        return answer;
    }
    
    static int bfs(int startnode, int count, boolean visit[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startnode);
        visit[startnode] = true;
        
        while(!q.isEmpty()) {
            int curnode = q.poll();
            for(int i = 0 ; i < list[curnode].size() ; i++) {
                int nextnode = list[curnode].get(i);
                if(visit[nextnode] == false) {
                    q.add(nextnode);
                    visit[nextnode] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}
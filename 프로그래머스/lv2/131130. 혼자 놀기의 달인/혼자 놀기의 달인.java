import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] cards) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < cards.length ; i++) {
            list.add(cards[i]);
        }
        divide(list);

        return answer;
    }
    
//     static void dfs(int []arr, int depth, ArrayList<Integer> list, boolean visit[]) {
        
//         if(depth == arr.length) {
//         //하나의 경우에 대해서 그룹을 나누고 거기서 최고의 수 두개를 곱하는 과정을 진행해주어야함    
//             divide(list);
//             return;
//         }
        
//         for(int i = 0 ; i < arr.length ; i++) {
//             if(visit[i] == false) {
//                 list.add(arr[i]);
//                 visit[i] = true;
//                 dfs(arr, depth + 1, list, visit);
//                 visit[i] = false;
//                 list.remove(list.size() - 1);
//             }
//         }
        
//     }
    
    
    static void divide(ArrayList<Integer> list) {
        
        boolean visit[] = new boolean[list.size()];
        
        ArrayList<Integer> groupSize = new ArrayList<>();
        
        for(int i = 0 ; i < list.size() ; i++) {
            if(visit[i] == true) continue;
            int cur = list.get(i);
            visit[cur-1] = true;
            int count = 1;
            while(true) {
                cur = list.get(cur-1);
                if(visit[cur-1] == true) {
                    break;
                }
                visit[cur-1] = true;
                count++;
            }
            groupSize.add(count);
        }
        
        // for(int i = 0 ; i < groupSize.size() ; i++) {
        //     System.out.println(groupSize.get(i));
        // }
        
        if(groupSize.size() > 1) {
            Collections.sort(groupSize,Collections.reverseOrder());
            answer = Math.max(answer, groupSize.get(0) * groupSize.get(1));
        }
        
        
    }
    
}


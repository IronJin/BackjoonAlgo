import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < records.length ; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            String str3 = st.nextToken();
            
            if(!list.contains(str2)) {
                list.add(str2);
                map2.put(str2, 0);
            }
            
            int curminite = Integer.parseInt(str1.substring(0,2)) * 60 + Integer.parseInt(str1.substring(3,5));
            if(str3.equals("IN")) {
                map.put(str2, curminite);
            }else {
                //누적 시간을 계산해주어야함
                int total = curminite - map.get(str2);
                map.remove(str2);
                map2.put(str2, map2.get(str2) + total);
            }
            
        }
        
        for(String key : map.keySet()) {
            int total = 1439 - map.get(key);
            map2.put(key, map2.get(key) + total);
        }
        
        Collections.sort(list);
            
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++) {
            int sum = map2.get(list.get(i));
            
            if(sum <= fees[0]) {
                answer[i] = fees[1];
            }else {
                answer[i] = fees[1];
                sum -= fees[0];
                if(sum % fees[2] == 0) {
                    answer[i] += (sum/fees[2]) * fees[3];
                }else {
                    answer[i] += (sum/fees[2] + 1) * fees[3];
                }
            }
        }
        
        return answer;
    }
}
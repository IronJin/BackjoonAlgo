import java.util.*;

class Solution {
    
    static ArrayList<String> list = new ArrayList<>();
    
    static ArrayList<String> strlist= new ArrayList<>();
    
    public int solution(String word) {
        
        strlist.add("A");
        strlist.add("E");
        strlist.add("I");
        strlist.add("O");
        strlist.add("U");
        
        String str = "";
        dfs(0,str);
        
        Collections.sort(list);
        
        for(int i = 0 ; i < list.size() ; i++) {
            if(list.get(i).equals(word)) {
                return i;
            }
        }
        
        return -1;
    }
    
    static void dfs(int depth, String str) {
        
        if(depth > 5) {
            return;
        }
        
        list.add(str);
        
        for(int i = 0 ; i < 5 ; i++) {
            String cur = strlist.get(i);
            dfs(depth + 1, str + cur);
        }
        
    }
}
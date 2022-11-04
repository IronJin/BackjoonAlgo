import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        ArrayList<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String str = "";
        String cur = "";
        
        while(n > 0) {
            sb.append(n%k);
            n /= k;
        }
        
        str = sb.reverse().toString();
        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == '0') {
                if(cur.length() > 0) {
                    list.add(Long.parseLong(cur));
                    cur = "";
                }
            }else {
                cur += String.valueOf(str.charAt(i));
            }
        }
        
        if(cur.length() > 0) {
            list.add(Long.parseLong(cur));
        }
        
        for(int i = 0 ; i < list.size() ; i++) {
            if(isPrime(list.get(i))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long n) {
        
        if(n == 1) return false;
        
        for(long i = 2 ; i <= Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
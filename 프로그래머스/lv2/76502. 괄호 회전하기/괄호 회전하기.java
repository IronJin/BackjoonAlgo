import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0 ; i < s.length() ; i++) {
            String str = "";
            str = circle(i,s);
            if(find(str)) {
                answer ++;
            }
        }
        
        return answer;
    }
    
    static boolean find(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            }else if(stack.peek() == '{') {
                if(s.charAt(i) == '}') {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else if(stack.peek() == '[') {
                if(s.charAt(i) == ']') {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                if(s.charAt(i) == ')') {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
            
        }
        
        if(stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
        
        
    }
    
    static String circle(int start, String s) {
        String str = "";
        for(int i = start ; i < s.length() ; i++) {
            str += String.valueOf(s.charAt(i));
        }
        for(int i = 0 ; i < start ; i++) {
            str += String.valueOf(s.charAt(i));
        }
        
        return str;
    }
    
    
    
}
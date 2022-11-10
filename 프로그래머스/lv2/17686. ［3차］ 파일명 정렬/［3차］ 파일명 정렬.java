import java.util.*;

//String 2차원 배열 정렬
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        String arr[][] = new String[files.length][3];
        
        for(int i = 0 ; i < files.length ; i++) {
            boolean numbering = false;
            String head = "";
            String number = "";
            String tail = "";
            for(int j = 0 ; j < files[i].length() ; j++) {
                if(numbering) {
                    if(Character.isDigit(files[i].charAt(j))) {
                        number += String.valueOf(files[i].charAt(j));
                    }else {
                        tail = files[i].substring(j, files[i].length());
                        break;
                    }
                }else {
                    if(!Character.isDigit(files[i].charAt(j))) {
                        head += String.valueOf(files[i].charAt(j));
                    }else {
                        numbering = true;
                        number += String.valueOf(files[i].charAt(j));
                    }
                }
            }
            
            arr[i][0] = head;
            arr[i][1] = number;
            arr[i][2] = tail;
            
        }
        
        Arrays.sort(arr, new Comparator<String[]>() {
           
            @Override
            public int compare(String o1[], String o2[]) {
                if(o1[0].toLowerCase().equals(o2[0].toLowerCase())) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }else {
                    return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
                }
            }
            
        });
        
        // for(int i =  0 ; i < arr.length ; i++) {
        //     System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
        // }
        
        for(int i = 0 ; i < arr.length ; i++) {
            answer[i] = arr[i][0] + arr[i][1] + arr[i][2];
        }
        
        return answer;
    }
}
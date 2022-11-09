import java.util.*;
class Solution {    
    
    //UP RIGHT DOWN LEFT
    static int yr[] = {1,0,-1,0};
    static int xc[] = {0,1,0,-1};
    
    static int arr[][] = new int[11][11];
    static boolean visit[][][] = new boolean[11][11][4];
    
    public int solution(String dirs) {
        int answer = 0;
        
        int currow = 5;
        int curcol = 5;
        
        for(int i = 0 ; i < dirs.length() ; i++) {
            
            int nextrow = -1;
            int nextcol = -1;
            
            if(dirs.charAt(i) == 'U') {
                nextrow = currow + yr[0];
                nextcol = curcol + xc[0];
                if(0 <= nextrow && nextrow < 11 && 0 <= nextcol && nextcol < 11) {
                    if(visit[currow][curcol][0] == false) answer++;
                    visit[currow][curcol][0] = true;
                    visit[nextrow][nextcol][2] = true;
                }
                
            }else if(dirs.charAt(i) == 'R') {
                nextrow = currow + yr[1];
                nextcol = curcol + xc[1];
                if(0 <= nextrow && nextrow < 11 && 0 <= nextcol && nextcol < 11) {
                    if(visit[currow][curcol][1] == false) answer++;
                    visit[currow][curcol][1] = true;
                    visit[nextrow][nextcol][3] = true;
                }
                
                
            }else if(dirs.charAt(i) == 'D') {
                nextrow = currow + yr[2];
                nextcol = curcol + xc[2];
                if(0 <= nextrow && nextrow < 11 && 0 <= nextcol && nextcol < 11) {
                    if(visit[currow][curcol][2] == false) answer++;
                    visit[currow][curcol][2] = true;
                    visit[nextrow][nextcol][0] = true;
                }
                
            } else {
                nextrow = currow + yr[3];
                nextcol = curcol + xc[3];
                if(0 <= nextrow && nextrow < 11 && 0 <= nextcol && nextcol < 11) {
                    if(visit[currow][curcol][3] == false) answer++;
                    visit[currow][curcol][3] = true;
                    visit[nextrow][nextcol][1] = true;
                }
                
            }
            
            if(0 <= nextrow && nextrow < 11 && 0 <= nextcol && nextcol < 11) {
                currow = nextrow;
                curcol = nextcol;
            }
            
        }
        
        return answer;
    }
}
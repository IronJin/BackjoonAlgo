import java.util.*;
import java.io.*;

public class Main {

	static int row;
	static int col;

	static int dist[][];
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	public static int solution(int r, int c, int arr[][]) {
		
		int answer = 0;
		
		row = r;
		col = c;
		dist = new int[row][col];
		answer = bfs(arr);
		
		
		return answer;
		
	}
	
	static int bfs(int arr[][]) {
		
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow + yr[i];
				int nextcol = curcol + xc[i];
				if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
					if(arr[nextrow][nextcol] == 0) {
						q.add(new int[] {nextrow, nextcol});
						dist[nextrow][nextcol] = dist[currow][curcol] + 1;
						arr[nextrow][nextcol] = 1;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					return -1;
				}else {
					answer = Math.max(answer, dist[i][j]);
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int arr[][] = new int[r][c];
		for(int i = 0 ; i < r ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < c ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solution(r,c,arr));
		
	}
}
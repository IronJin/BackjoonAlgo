import java.util.*;
import java.io.*;

public class Main {

	static int row;
	static int col;
	
	static int answer = 0;
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	public static int solution(int r, int c , int arr[][]) {
		
		row = r;
		col = c;
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(1, i, j , arr);
					arr[i][j] = 0;
				}
			}
		}
		
		
//		for(int i = 0 ; i < row ; i++) {
//			for(int j = 0 ; j < col ; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		
		return answer;
	}
	
	static void dfs(int depth, int startrow, int startcol, int arr[][]) {
		
		if(depth == 3) {
			answer = Math.max(bfs(arr), answer);
		}else {
			for(int i = startrow ; i < row ; i++) {
				int j = 0;
				if(i == startrow) {
					j = startcol + 1;
				}
				for(; j < col ; j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						dfs(depth + 1, i, j, arr);
						arr[i][j] = 0;
					}
				}
			}
		}
		
	}
	
	//칸 크기 반환
	static int bfs(int wall[][]) {
		
		int arr[][] = new int[row][col];
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ;j ++) {
				arr[i][j] = wall[i][j];
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 2) {
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
						arr[nextrow][nextcol] = 2;
					}
				}
			}
		}
		
		int zerocount = 0;
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					zerocount++;
				}
			}
		}
		return zerocount;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
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
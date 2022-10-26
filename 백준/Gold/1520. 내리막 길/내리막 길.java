import java.util.*;
import java.io.*;

public class Main {

	static int row;
	static int col;
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	static int dp[][];
	static boolean visit[][];
	
	public static int solution(int arr[][]) {
		
		row = arr.length;
		col = arr[0].length;
		
		dp = new int[row][col];
		visit = new boolean[row][col];
		
		int answer = dfs(0,0,arr);
		
//		for(int i = 0 ; i < row ; i++) {
//			for(int j = 0 ; j < col ; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
		
		return answer;
	}
	
	static int dfs(int currow, int curcol, int arr[][]) {
		
		if(currow == row-1 && curcol == col-1) {
			return 1;
		}
		
		if(visit[currow][curcol] == true) {
			return dp[currow][curcol];
		}
		
		visit[currow][curcol] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nextrow = currow + yr[i];
			int nextcol = curcol + xc[i];
			if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
				if(arr[nextrow][nextcol] < arr[currow][curcol]) {
					dp[currow][curcol] += dfs(nextrow, nextcol , arr);
				}
			}
		}
		
		return dp[currow][curcol];
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
		
		System.out.println(solution(arr));
		
	}

}
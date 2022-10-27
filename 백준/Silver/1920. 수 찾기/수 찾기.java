import java.util.*;
import java.io.*;

public class Main {
	
	public static String solution(int a[], int b[]) {
		
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(a);
		
		for(int i = 0 ; i < b.length ; i++) {
			
			int answer = 0;
			
			int x = b[i];
			
			int left = 0;
			int right = a.length;
			while(left < right) {
				int mid = (left + right)/2;
				if(a[mid] < x) {
					left = mid + 1;
				}else {
					right = mid;
				}
			}
			
			if(right < a.length) {
				if(a[right] == x) {
					answer = 1;
				}
			}
			sb.append(answer).append("\n");
		}
		
		return sb.toString();
	}
	

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a[] = new int[n];
		for(int i = 0 ; i < n ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int b[] = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < m ; j++) {
			b[j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(a,b));
		
	}

}
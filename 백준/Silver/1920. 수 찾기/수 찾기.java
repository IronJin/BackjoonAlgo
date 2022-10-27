import java.io.*;
import java.util.*;

//lower bound 를 이용 -> right 를 끌어내림

public class Main {

	static int n;
	static int arr1[];
	static int m;
	static int arr2[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
	}
	
	static void pro() {
		
		Arrays.sort(arr1);
		
		for(int i = 0 ; i < m ; i++) {
			int answer = 0;
			int index = bin(arr2[i]);
			if(0 <= index && index < n) {
				if(arr1[index] == arr2[i]) {
					answer = 1;
				}
			}
			
			System.out.println(answer);
		}

		
	}
	
	static int bin(int x) {
		
		int left = 0;
		int right = n;
		while(left < right) {
			int mid = (left+right)/2;
			if(arr1[mid] < x) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return right;
		
	}

}

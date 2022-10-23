import java.util.*;
import java.io.*;

public class Main {

	public static int solution(String str) {
		return str.length();
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
	}

}
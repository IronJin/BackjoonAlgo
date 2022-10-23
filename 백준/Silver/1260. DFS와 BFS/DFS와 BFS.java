import java.util.*;
import java.io.*;

public class Main {

	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	
	public static String solution(int startnode, ArrayList<Integer> list[]) {
		
		for(int i = 1 ; i < list.length ; i++) {
			Collections.sort(list[i]);
		}
		
		visit = new boolean[list.length];
		dfs(startnode, list);
		sb.append("\n");
		visit = new boolean[list.length];
		bfs(startnode, list);
		
		return sb.toString();
	}
	
	static void bfs(int startnode, ArrayList<Integer> list[]) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(startnode);
		visit[startnode] = true;
		sb.append(startnode).append(" ");
		
		while(!q.isEmpty()) {
			int curnode = q.poll();
			for(int i = 0 ; i < list[curnode].size(); i++) {
				int nextnode = list[curnode].get(i);
				if(visit[nextnode] == false) {
					q.add(nextnode);
					visit[nextnode] = true;
					sb.append(nextnode).append(" ");
				}
			}
		}
		
	}
	
	static void dfs(int startnode, ArrayList<Integer> list[]) {
		
		visit[startnode] = true;
		sb.append(startnode).append(" ");
		
		for(int i = 0 ; i < list[startnode].size() ; i++) {
			int nextnode = list[startnode].get(i);
			if(visit[nextnode] == false) {
				dfs(nextnode, list);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int startnode = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list[] = new ArrayList[n+1];
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		System.out.println(solution(startnode, list));
		
	}

}
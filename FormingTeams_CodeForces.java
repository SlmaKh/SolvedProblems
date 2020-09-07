package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
 
public class FormingTeams_CodeForces {
	
	static ArrayList<Integer>[] adjList;
	static boolean visited[];
	static int count, remove;
	

	public static boolean dfs(int cur, int parent){
		if(visited[cur])
			return true;
		visited[cur] = true;
		for(int child: adjList[cur]){
			if(child != parent){
				count ++;
				if(dfs(child, cur))
					return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String r [] = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int m = Integer.parseInt(r[1]);
		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			r = br.readLine().split(" ");
			int a = Integer.parseInt(r[0]);
			int b = Integer.parseInt(r[1]);
			int s = a < b ?a:b;
			int e = a > b ?a:b;
			if(adjList[s] == null)
				adjList[s] = new ArrayList<Integer>();
			if(adjList[e] == null)
				adjList[e] = new ArrayList<Integer>();
			adjList[s].add(e);
			adjList[e].add(s);
		}

		
		
		for (int i = 1; i < n + 1; i++) {
			if(!visited[i] && adjList[i] != null){
				count = 0;
				boolean isCycle = dfs(i, -1);
				if (isCycle){
					if(count % 2 != 0)
						remove ++;
				}
			}
		}

	
		
		out.println((n - remove) % 2 == 0? remove : remove + 1);
		out.flush();
		out.close();
	}
	
 
}
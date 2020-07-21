package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;


public class DirectingEdges_CodeForces {
	static int n;
	static int m;
	static ArrayList<Integer>[]adjList;
	static int [] order;
	static Stack<Integer> s;
	static boolean visited[];
	static int idx;

	public static void topologicalSort(int n){
		visited[n] = true;
		for(int x: adjList[n]){
			if(!visited[x]){
				topologicalSort(x);
			}
		}
		s.push(n);
		order[n] = idx++;	
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			String [] r = br.readLine().split(" ");
			n = Integer.parseInt(r[0]);
			m = Integer.parseInt(r[1]);
			adjList = new ArrayList [n + 1];
			for(int i = 0; i < n + 1; i++)
				adjList[i] = new ArrayList<Integer>();
			visited = new boolean [n + 1];
			order = new int[n + 1];
			s = new Stack<Integer>();
			int [] st = new int[m];
			int [] f = new int[m];
			int idxUndirected = 0;
			for(int i = 0 ;i < m; i++){
				r = br.readLine().split(" ");
				int start = Integer.parseInt(r[1]);
				int finish = Integer.parseInt(r[2]);
				if(Integer.parseInt(r[0]) == 1){
					if(adjList[start] == null)
						adjList[start] = new ArrayList<Integer>();
					adjList[start].add(finish); 
				}
				else {
					st[idxUndirected] = start;
					f[idxUndirected++] = finish;
				}
			}
			for(int i = 1; i <= n; i++){
				if(!visited[i]){
					topologicalSort(i);
				}
			}
			boolean acyclic = true;
			for(int i = 0; i < adjList.length; i++){
				if(!adjList[i].isEmpty())
					for(int x: adjList[i]){
						if(order[i] < order[x]){
							acyclic = false;
							break;
						}
					}
			}

			if(acyclic){
				out.println("YES");
				for(int i = 0; i < adjList.length; i++){
					if(!adjList[i].isEmpty())
						for(int x: adjList[i])
							out.println(i+" "+x);
				}
				for(int i = 0; i < m; i++){
					if(st[i] == 0)
						break;
					if(order[st[i]] > order[f[i]])
						out.println(st[i]+" "+ f[i]);
					else
						out.println(f[i]+" "+ st[i]);
				}
			}
			else{
				out.println("NO");
			}

		}
		out.flush();
		out.close();
	}
}

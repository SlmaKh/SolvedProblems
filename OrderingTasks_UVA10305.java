package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class OrderingTasks_UVA10305 {
	static ArrayList<Integer>[]adjList;
	static Stack<Integer> order;
	static boolean visited[];
	public static void topoSort(int i){
		visited[i] = true;
		for(int x: adjList[i]){
			if(!visited[x]){
				topoSort(x);
			}
		}
		if(i != 0)
			order.push(i);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[]r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int m = Integer.parseInt(r[1]);
		while(n != 0){
			
			adjList = new ArrayList[n + 1];
			order = new Stack<Integer>();
			visited = new boolean[n + 1];
			for (int i = 0; i <= n; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				r = br.readLine().split(" ");
				int s = Integer.parseInt(r[0]);
				int e = Integer.parseInt(r[1]);
				adjList[s].add(e);
			}
			
			for (int i = 0; i <= n; i++) {
				if(!visited[i])
					topoSort(i);
			}
			StringBuilder ord = new StringBuilder();
			while(!order.isEmpty()){
				if(order.size() > 1)
					ord.append(order.pop()+" ");
				else
					ord.append(order.pop());
			}
			out.println(ord);
			r = br.readLine().split(" ");
			n = Integer.parseInt(r[0]);
			m = Integer.parseInt(r[1]);
		
		}
		out.flush();
		out.close();
		
		
		
	}
}

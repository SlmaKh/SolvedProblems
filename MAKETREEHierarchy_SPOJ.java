package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class MAKETREEHierarchy_SPOJ {
	static ArrayList<Integer>[]adjList;
	static Stack<Integer> order;
	static boolean visited[];
	
	public static void topo(int u){
		visited[u] = true;
		for(int child:adjList[u]){
			if(!visited[child])
				topo(child);
		}
		order.push(u);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[]r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int k = Integer.parseInt(r[1]);
		
		adjList = new ArrayList[n + 1];
		order = new Stack<Integer>();
		visited = new boolean[n + 1];
		
		
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= k; i++) {
			r = br.readLine().split(" ");
			for (int j = 1; j < r.length; j++) {
				int cur = Integer.parseInt(r[j]);
				if(adjList[cur].contains(i) || adjList[i].contains(cur))
					continue;
				else
					adjList[i].add(cur);
			}
		}
		for (int i = 1; i <= n; i++) {
			if(!visited[i])
				topo(i);
		}
		int[] pos = new int[n + 1];
		int lastBoss = 0;
		Stack <Integer>directlyMain = new Stack<Integer>();
		int main = 0;
		while(!order.isEmpty()){
			int x = order.peek();
			if(x > k)
				directlyMain.push(order.pop());
			else{
				main = x;
				break;
				}
		}
		while(!order.isEmpty()){
			int x = order.pop();
			pos[x] = lastBoss;
			if(x <= k)
				lastBoss = x;
		}
		while(!directlyMain.isEmpty()){
			pos[directlyMain.pop()] = main;
		}
		
		for (int i = 1; i < pos.length; i++) {
			out.println(pos[i]);
		}
		out.flush();
		out.close();
	}
	

}

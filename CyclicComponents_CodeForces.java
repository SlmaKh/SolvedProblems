package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class CyclicComponents_CodeForces {
	static ArrayList<Integer> [] adjList ; 
	static int [] dfs_num ;
	static int [] dfs_parent;
	static int count=0;
	static TreeSet<Integer> ts; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[]=br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]); // no of edges
		int m = Integer.parseInt(temp[1]); // no of vertices 
		adjList = new ArrayList[n+1];
		for(int i=1;i<=n;i++)
			adjList[i]=new ArrayList<Integer>();
		for(int i=0;i<m;i++){
			temp=br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end =  Integer.parseInt(temp[1]);
			adjList[start].add(end);
			adjList[end].add(start);
		}
		dfs_num=new int[n+1];
		dfs_parent=new int[n+1];
		ts=new TreeSet<Integer>();
		for(int i=1;i<=n;i++){
			if(dfs_num[i]==0)
				graph_check(i);
		}
		System.out.println(count);
	}
	
	
	public static void graph_check(int u){
		dfs_num[u]=2;
		for(int m:adjList[u]){
			if(dfs_num[m]==0){//EXPLORED-->UNVISITED
				dfs_parent[m]=u;
				graph_check(m);
			}
			else if (dfs_num[m]==2){ //EXPLORED-->EXPLORED
				if(m==dfs_parent[u])
					System.out.print("");
				else  {
					if( checkSize(u))
					count++;
				}
			}	
			else if( dfs_num[m]==1) //EXPLORED-->VISITED
				System.out.print("");
		}
		dfs_num[u]=1;
	}

	public static boolean checkSize(int start){
		
		if(dfs_parent[start]==0&&adjList[start].size()==2){
			return true;
			}
		if(adjList[start].size()==2){
			return checkSize(dfs_parent[start]);
			}
		else
			return false;
		
	} 
}

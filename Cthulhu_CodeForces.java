package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cthulhu_CodeForces{

	static ArrayList<Integer>[]adjList;
	static int []dfs_num; //0-->UNVISITED 1-->VISITED 2-->EXPLORED
	static int []dfs_parent;
	static int cycles=0;
	public static void main(String []args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		//System.out.println(s);
		String []r= s.split(" ");
	    //System.out.println(r[0]+" "+r[1]+" ");
		int n = Integer.parseInt(r[0]);
		int m= Integer.parseInt(r[1]);
		adjList=new ArrayList[n];
		dfs_num=new int[n];
		dfs_parent=new int[n];
		for(int i=0;i<n;i++)
			adjList[i]=new ArrayList<Integer>();
		for(int i=0;i<m;i++){
			String []a=br.readLine().split(" ");
			int start = Integer.parseInt(a[0]);
			int end   = Integer.parseInt(a[1]);
			adjList[start-1].add(end);
			adjList[end-1].add(start);

		}
		int count=0;
		for(int i=0;i<n;i++){
			if(dfs_num[i]==0){
				graph_check(i);
				count++;
			}
		}
		if(count==1&&cycles==1)
			System.out.println("FHTAGN!");
		else 
			System.out.println("NO");
	}

	public static void graph_check(int s){
		dfs_num[s]=2;
		for(int m:adjList[s]){
			if(dfs_num[m-1]==0){//EXPLORED-->UNVISITED
				dfs_parent[m-1]=s+1;
				graph_check(m-1);
			}
			else if(dfs_num[m-1]==2){//EXPLORED-->EXPLORED
				if(dfs_parent[s]!=m)
					cycles++;
			}
		}
		dfs_num[s]=1;
	}
}
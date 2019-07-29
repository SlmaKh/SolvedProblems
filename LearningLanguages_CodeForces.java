package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class LearningLanguages_CodeForces{
	static ArrayList<Integer>[]adjList;
	static HashSet<Integer>[]langList;
	static boolean []visited;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s =br.readLine();
		String []r=s.split(" ");
		int n = Integer.parseInt(r[0]);//no of employees
		int m = Integer.parseInt(r[1]);
		langList=new HashSet[n];
		adjList=new ArrayList[n];
		visited=new boolean[n];
		for(int i=0;i<n;i++){
			adjList[i]=new ArrayList<Integer>();
			langList[i]=new HashSet<Integer>();}
		for(int i=0;i<n;i++){
			String l = br.readLine();
			String[]temp=l.split(" ");
			int num = Integer.parseInt(temp[0]); // the number of languages ith employee knows
			for(int j=1;j<temp.length;j++)
				langList[i].add(Integer.parseInt(temp[j]));
		}
		for(int i=0;i<n;i++){ //Adjacency list formation 
			for(int x:langList[i]){
				for(int j=0;j<n;j++){
					if(j!=i){
						if(langList[j].contains(x)){
							if(!adjList[i].contains(j+1)){
								adjList[i].add(j+1);
								adjList[j].add(i+1);
							}
						}
					}
				}
			}
		}
		int acorn=0;
		int tree=0;
		for(int i=0;i<n;i++){ // count the acorns make them visited
			if(adjList[i].size()==0){
				acorn++;
				visited[i]=true;
			}
		}
		for(int i=0;i<n;i++){
			if(!visited[i]){
				dfs(i);
				tree++;
			}
		}
		if(tree==0){
			boolean allZero=true;
			for(int i=0;i<n;i++){
				if(!langList[i].isEmpty())
					allZero=false;
			}
			if(allZero)
				System.out.println(acorn);
			else
				System.out.println(acorn-1);
		}
		else
			if(tree<2)
				System.out.println(acorn);
			else
				System.out.println(acorn+tree-1);

	}
	public static void dfs(int s){
		visited[s]=true;
		for(int m:adjList[s]){
			if(!visited[m-1])
				dfs(m-1);
		}
	}

}

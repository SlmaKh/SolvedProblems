package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Vertex_UVA280 {
	static HashSet<Integer>vertices;
	static ArrayList<Integer>[]adjList;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());//number of vertices
		while(n!=0){ // remember to read the others
			ArrayList<String> a = new ArrayList<String>();
			String s = br.readLine();
			while(!s.equals("0")){        // putting all edges in an array list
				a.add(s);
				s=br.readLine();
			}
			adjList= new ArrayList[n]; 
			for(int j=0;j<adjList.length;j++){
				adjList[j]=new ArrayList<Integer>();
			}
			for(int i=0;i<a.size();i++){ // creating adjacency list
				String temp = a.get(i);
				String[]t=temp.split(" ");
				int index= Integer.parseInt(t[0]+"")-1;
				for(int j=1;j<t.length-1;j++){
					int x = Integer.parseInt(t[j]+"");
					adjList[index].add(x);
				}
			}

			vertices = new HashSet<Integer>();//contains all possible vertices
			String list  = br.readLine();
			String []l=list.split(" ");
			int num = Integer.parseInt(l[0]+""); // number of vertices to be investigated
			for(int j=1;j<l.length;j++){
				for(int b=0;b<n;b++){
					vertices.add(b+1);
				}
				int investIndex = Integer.parseInt(l[j]+"")-1;
				dfs(investIndex);
				if(vertices.size()==0)
					System.out.print(vertices.size());
				else
					System.out.print(vertices.size()+" ");
				Object[]v =  vertices.toArray();
				for(int k=0;k<v.length;k++){
					System.out.print((int)v[k]);
					if(k!=v.length-1)
						System.out.print(" ");
				}
				System.out.println("");
			}
			n= Integer.parseInt(br.readLine());
		}
	}
	static void dfs(int s){
		for(int m:adjList[s]){
			if(vertices.contains(m)){
				vertices.remove(m);
				dfs(m-1);

			}
		}
	}

}

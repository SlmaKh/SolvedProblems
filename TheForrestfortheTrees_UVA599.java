package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TheForrestfortheTrees_UVA599 {
	static boolean[] visited;
	static ArrayList<Character>[] adjList;
	static String[]letters;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n   =Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++){
			ArrayList<String>a = new ArrayList<String>();
			String s = br.readLine();
			while(s.charAt(0)!='*'){//arrayList containing edges
				a.add(s);
				s=br.readLine();
			}
			int trees=0;
			int acorns=0;
			String let=br.readLine();
			letters = let.split(","); // String of all vertices 
			adjList= new ArrayList[26];
			visited = new boolean[26];
			for(int j=0;j<adjList.length;j++){
				adjList[j]=new ArrayList<Character>();
			}
			for(int j=0;j<a.size();j++){ //adjacency list formation
				String temp = a.get(j);
				char start = temp.charAt(1);
				char end = temp.charAt(3);
				int index = start-'A';
				adjList[index].add(end);
				index=end-'A';
				adjList[index].add(start);
			}

			for(int j=0;j<adjList.length;j++){ //counting acorns cuz they have no fucking neighbors
				if(adjList[j].size()==0&&exists((char) (j+'A'))){
					acorns++;
					visited[j]=true;
				}
			}
			while(!isAllVisited(visited)){
				for(int j=0;j<visited.length;j++){
					if(!visited[j] &&exists((char) (j+'A'))){
						dfs(j);
						trees++;
					}

				}
			}

			System.out.println("There are "+trees+" tree(s) and "+acorns+" acorn(s).");

		}

	}

	static void dfs(int s){
		visited[s]=true;
		for(char c: adjList[s]){
			if(!visited[c-'A'])
				dfs(c-'A');
		}
	}
	static boolean exists(char c){
		for(int i=0;i<letters.length;i++){
			if(letters[i].equals(c+""))
				return true;
		}
		return false;

	}
	static boolean isAllVisited(boolean[]a){
		for(int i=0;i<a.length;i++)
			if(!a[i]&&exists((char)(i+'A')))
				return false;
		return true;
	}
}

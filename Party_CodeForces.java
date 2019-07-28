package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class Party_CodeForces {
	static ArrayList<Integer>[]adjList;
	static boolean[]visited;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int []t=new int [n];
		adjList = new ArrayList[n];
		visited=new boolean[n];
		for(int i=0;i<n;i++){
			adjList[i]=new ArrayList<Integer>();
			t[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<n;i++){
			if(t[i]!=-1)
				adjList[t[i]-1].add(i+1);
		}
		for(int i=0;i<n;i++){
			if(adjList[i].size()==0&&t[i]==-1)
				visited[i]=true;
		}
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<n;i++){
			if(!visited[i]){
				pq.add(depth(i+1)+1);
			}
		}
		if(pq.isEmpty()){
			System.out.println(1);
		}
		else
			System.out.println(pq.poll());
	}
	//send the actual number
	static int depth(int s){
		PriorityQueue<Integer>pq= new PriorityQueue<Integer>(Collections.reverseOrder());
		if(adjList[s-1].isEmpty())
			return 0;
		else{
			for(int m:adjList[s-1]){
				pq.add(depth(m));
			}
			return 1+pq.poll();
		}
	}
}

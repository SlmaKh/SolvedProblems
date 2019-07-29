package acm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
class disu {
	int[]parent;
	int[]size;
	int maxSize;

	public disu (int n){
		parent=new int [n];
		size= new int [n];
		for(int i=0;i<n;i++){
			parent[i]=i;
			size[i]=1;
		}
	}
	public int findSet(int v){
		if(parent[v]==v)
			return v;
		return parent[v]=findSet(parent[v]);
	}
	public boolean isSameSet(int v1, int v2){
		return findSet(v1)==findSet(v2);
	}
	// I unite only if they are in the same friends group
	public void unite (int a,int b){ // by size
		a=findSet(a);
		b=findSet(b);
		if(a==b)
			return;
		if(size[a]>size[b]){
			parent[b]=a;
			size[a]+=size[b];
			if(size[a]>maxSize)
				maxSize=size[a];
		}
		else {
			parent[a]=b;
			size[b]+=size[a];
			if(size[b]>maxSize)
				maxSize=size[b];
		}
	}

}
public class TheSuspects_UVA1197 {
	static TreeSet<Integer>adjList[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m =sc.nextInt();
		while(n!=0|| m!=0){
			if(n==1){
				System.out.println(1);
			}
			else {
				boolean found =false;
				adjList= new TreeSet[n];
				for(int i=0;i<n;i++)
					adjList[i]=new TreeSet<Integer>();
				for(int i=0;i<m;i++){
					int k = sc.nextInt();
					int start=sc.nextInt();
					for(int j=1;j<k;j++){
						int end =sc.nextInt();
						if(!adjList[end].contains(start))
							adjList[start].add(end);
					}
				}
				disu ds=new disu(n);
				for(int i=0;i<adjList.length;i++){
					for(int cur:adjList[i]){
						ds.unite(i, cur);
						for(int b : adjList[cur])
							ds.unite(i, b);
					}
				}
				int h = ds.findSet(0);
				System.out.println(ds.size[h]);
				
			}
			
			n=sc.nextInt();
			m=sc.nextInt();
		}
	}
}

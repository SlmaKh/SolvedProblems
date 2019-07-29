package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class Friends_UVA10608 {

	static TreeSet<Integer>[]friends;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // no of test cases
		for(int t=0;t<T;t++){
			String []temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]); // the number of citizens 
			int m = Integer.parseInt(temp[1]); // the number of pairs of people
			if(m==0){
				System.out.println(1);
			}
			else{
				friends=new TreeSet[n];
				for(int i=0;i<n;i++)
					friends[i]=new TreeSet<Integer>();
				for(int i=0;i<m;i++){
					temp = br.readLine().split(" ");
					int start = Integer.parseInt(temp[0]); 
					int end  = Integer.parseInt(temp[1]);
					if(!friends[end-1].contains(start)){ // if already friends don't add again 
						friends[start-1].add(end);
					}

				}


				// the following step is uniting friends in the same group
				disu ds=new disu(n+1);
				for( int i=0;i<friends.length;i++){
					for(int cur:friends[i]){
						ds.unite(i+1, cur);
						for(int b: friends[cur-1]){
							ds.unite(i+1, b);
						}
					}
				}
				System.out.println(ds.maxSize);
			}
		}
	}
}

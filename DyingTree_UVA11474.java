package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class tuple {
	int x ; 
	int y ;
	public tuple (int x, int y){
		this.x=x;
		this.y=y;
	}
}

class  dsu {
	int parent [];
	int size[];
	int rank[];
	boolean reachable[];
	public dsu (int n ){
		parent=new int[n];
		size= new int[n];
		rank = new int [n];
		reachable = new boolean[n];
		for(int i=0;i<n;i++){
			parent [i]=i;
		}
	}
	
	public int findSet (int v){
		if(parent[v]==v)
			return v ; 
		else 
			return parent[v]=findSet(parent[v]);
	}
	
	public boolean isSameSet(int t1, int t2){ // two trees are in the same set if they have the same parent(representative)
		return findSet(t1)==findSet(t2);
	}
	
	public boolean canTreeReachDoctor(int t){// a tree can reach a doctor if it's in the same set as one that does 
		int parent = findSet(t);
		return reachable[parent];
	}
	public void unite(int t1, int t2){ // by rank 
		int a =findSet(t1);
		int b =findSet(t2);
		if(a==b)
			return; // they are already in the same set
		if(rank[a]>rank[b]){
			parent[b]=a;
		}
		else if(rank[a]<rank[b]){
			parent[a]=b;
		}
		else if (rank[a]==rank[b]){
			parent[a]=b;
			rank[b]++;
		}
		reachable[a]|=reachable[b];
		reachable[b]|=reachable[a]; 
		// since they are united in the same set if one if them can reach a doctor then the other one can 
		// note that they are only united if they can reach each other this is done in the main 
	}
	
	
	
}
public class DyingTree_UVA11474 {
	
	static tuple [] doctors;
	static tuple [][] trees;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // no of test cases
		for(int t=0;t<T;t++){
			String []temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]); // the number of trees 
			int m = Integer.parseInt(temp[1]); // the number of doctors
			int k = Integer.parseInt(temp[2]); // min distance between trees that can talk  
			int d = Integer.parseInt(temp[3]); // min distance to doctors that can talk 
			doctors = new tuple[m];
			trees = new tuple[n][];
			for(int i=0;i<m;i++){
				temp = br.readLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				doctors[i]=new tuple(x,y);
			}
			for (int i=0;i<n;i++){
				int branch = Integer.parseInt(br.readLine()); 
				trees[i]=new tuple[branch];
				for(int j=0;j<branch;j++){
					temp = br.readLine().split(" ");
					int x = Integer.parseInt(temp[0]);
					int y = Integer.parseInt(temp[1]);
					trees[i][j]=new tuple(x,y);
				}
			}
			dsu ds=new dsu(n); //create a dsu for trees , if these trees can reach each other they are in the same set 
			
			//this loop is for setting reachable for trees that can reach doctors to true
			for(int i=0;i<n;i++){
				for(int j=0;j<trees[i].length;j++){
					tuple cur = trees[i][j];
					boolean reachable =false;
					for (tuple doc:doctors){
						if(Math.pow((doc.x-cur.x),2)+Math.pow((doc.y-cur.y),2)<=d*d){
							reachable =true;
							//System.out.println("hereee and i is "+ i);
							//break;
						}
						ds.reachable[i]|=reachable; //meaning that this tree can reach a doctor 
					}
				}
			}
			
			// this loop is for putting trees that can reach each other in the same set 
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){ // start from the next trees
					if(!ds.isSameSet(i, j)){ // if they aren't in the same set already
						for(tuple pos1 : trees[i]){ // a tree can reach another if any branch can reach any other
							for(tuple pos2: trees[j]){
								if(Math.pow((pos1.x-pos2.x),2)+Math.pow((pos1.y-pos2.y),2)<=k*k){
									ds.unite(i, j);
								}
							}
						}
					}
				}
			}
			
			if(ds.canTreeReachDoctor(0)) // if the first tree can reach a doctor 
				System.out.println("Tree can be saved :)");
			else 
				System.out.println("Tree can't be saved :(");
			//System.out.println("thisss "+ds.reachable[2]);		
			
		}
	}

}

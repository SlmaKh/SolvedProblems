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

















//class dssu {
//	int[]parent;
//	int[]size;
//	int maxSize;
//
//	public dssu (int n){
//		parent=new int [n];
//		size= new int [n];
//		for(int i=0;i<n;i++){
//			parent[i]=i;
//			size[i]=1;
//		}
//	}
//	public int findSet(int v){
//		if(parent[v]==v)
//			return v;
//		return parent[v]=findSet(parent[v]);
//	}
//	public boolean isSameSet(int v1, int v2){
//		return findSet(v1)==findSet(v2);
//	}
//	// I unite only if they are in the same friends group
//	public void unite (int a,int b){ // by size
//		a=findSet(a);
//		b=findSet(b);
//		if(a==b)
//			return;
//		if(size[a]>size[b]){
//			parent[b]=a;
//			size[a]+=size[b];
//			if(size[a]>maxSize)
//				maxSize=size[a];
//		}
//		else {
//			parent[a]=b;
//			size[b]+=size[a];
//			if(size[b]>maxSize)
//				maxSize=size[b];
//		}
//	}
//
//} 
//public class TheSuspects {
//
//	static ArrayList<Integer>groups[];
//	public static void main(String[] args) {
//		Scanner sc= new Scanner (System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		while(n!=0 || m!=0){
//			if(n==1){
//				System.out.println(1);
//			}
//			else {
//				int count=0;
//				int zeroIndex=0;
//				boolean found=false;
//				dssu ds= new dssu(n);
//				groups=new ArrayList[m];
//				for(int i=0;i<m;i++)
//					groups[i]=new ArrayList<Integer>();
//				for(int i=0;i<m;i++){
//					int k =sc.nextInt();
//					int first = sc.nextInt();
//					if(first==0){
//						zeroIndex=i;
//						found=true;
//					}
//					groups[i].add(first);
//					for(int j=1;j<k;j++){
//						int x=sc.nextInt();
//						groups[i].add(x);
//						ds.unite(first, x); // put friend groups in the same group
//						if(x==0){
//							zeroIndex=i;
//							found=true;
//						}
//					}
//				}
//				if(!found){
//					System.out.println(1);
//				}
//				else{
//					for(int i=0;i<groups[zeroIndex].size();i++){
//						int cur = groups[zeroIndex].get(i);
//						System.out.println("above cur is "+ cur);
//						for(int j=0;j<groups.length&& cur!=0;j++){
//							if(j!=zeroIndex && groups[j].contains(cur)){
//								System.out.println("cur is "+ cur);
//								ds.unite(0,groups[j].get(0));
//							}
//						}	
//					}
//					for(int i=0;i<ds.parent.length;i++)
//						System.out.println("i iss " + i +" parent is  "+ ds.parent[i]);
//				//	System.out.println();
//					System.out.println(ds.size[0]);
//				}
//			}
//			n=sc.nextInt();
//			m=sc.nextInt();
//		}
//	}
//}

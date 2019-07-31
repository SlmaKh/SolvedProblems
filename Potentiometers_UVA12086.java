package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class segTree {
	int N;
	int []array;
	int [] STree;
	int [] lazy;
	public segTree(int[]input){
		N=input.length-1;
		array=input;
		STree=new int [N<<1];
		lazy=new int [N<<1];
		build(1,1,N);
	}
	public void build(int node,int b, int e){
		if(b==e){
			STree[node]=array[b];
				}
		else{
			int left = 2*node;
			int right=left+1;
			int mid = (b+e)/2;
			build(left,b,mid);
			build(right,mid+1,e);
			STree[node]=STree[left]+STree[right];
		}
	}
	public void probagate(int node,int b, int e){
		int left = 2*node;
		int right=left+1;
		lazy[left]+=lazy[node];
		lazy[right]+=lazy[node];
		int mid = (b+e)/2;
		STree[left]+= (mid-b+1)*lazy[node];
		STree[right]+=(e-mid)*lazy[node];
		lazy[node]=0;
	}
	public void updatePoint(int i, int val){
		int node= i+N-1;
		//STree[node]+=val;
		STree[node]=val;
		while(node>1){
			node/=2;
			STree[node]= STree[node*2]+STree[node*2+1];
		}
	}
	
	public int query(int i,int j){
		return query(1,1,N,i,j);
	}
	public int query(int node, int b,int e, int i ,int j){
		if(e<i || b> j){
			return 0;
			}
		if(b>=i && e<=j){
			return STree[node];
			}
		int mid =(b+e)/2;
		probagate(node,b,e);
		int q1=query(node*2, b, mid,i,j);
		int q2=query(node*2+1,mid+1,e,i,j);
		return q1+q2;
		
	}
	
}
public class Potentiometers_UVA12086 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int test=0;
		while(N!=0){// don't forget to read it again 
			//create a segment tree and add the values to it 
			test++;
			int size=1;
			while(size<N)
				size<<=1;
			int [] pot = new int [size+1]; // one based 
			for(int i=1;i<N+1;i++){
				pot[i]=Integer.parseInt(br.readLine());
						}
			segTree st= new segTree(pot);
			String s= br.readLine(); 
			//update the segment tree 
			int count=0;
			boolean print=false;
			while(!s.equals("END")){
				char action = s.charAt(0);
				String []r=s.split(" ");
				int i= Integer.parseInt(r[1]);
				int j= Integer.parseInt(r[2]);
				if(action=='M'){
					if(count==0)
						System.out.println("Case "+test+":");
					count++;
					System.out.println(st.query(i, j));
				}
				if(action=='S'){
					st.updatePoint(i, j);
				}
				s=br.readLine(); 
			}
			N = Integer.parseInt(br.readLine());
			if(N!=0)
				System.out.println();
		}
	}
}

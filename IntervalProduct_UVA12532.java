package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class productseg{
	int N;
	int [] Stree, array, lazy;
	public productseg(int[]input){
		N=input.length-1;
		Stree=new int[N<<1];
		array=input;
		lazy=new int[N<<1];
		Arrays.fill(lazy, 1);
		Arrays.fill(Stree, 1);
		build(1,1,N);
	}
	
	public void build(int node, int b, int e){
		if(b==e){
			Stree[node]=array[b];
			}
		else{
			int left= 2*node;
			int right=left+1;
			int mid = (b+e)/2;
			build(left,b,mid);
			build(right,mid+1,e);
			Stree[node]=Stree[left]*Stree[right];
		}
	}
	public void probagate(int node, int b, int e){
		int left= 2*node;
		int right=left+1;
		lazy[left]*=lazy[node];
		lazy[right]*=lazy[node];
		int mid =(b+e)/2;
		Stree[left]*=lazy[node];
		Stree[right]*=lazy[node];
		lazy[node]=1;
	}
	
	public int query(int i, int j){
		return query(1,1,N,i,j);
	}
	
	public int query(int node , int b, int e, int i, int j ){
		if(b>j || e <i)
			return 1;
		if(b>=i && e<=j){
			return Stree[node];
			}
		int mid= (b+e)/2;
		probagate(node,b,e);
		int q1=query(2*node,b,mid, i ,j);
		int q2=query(2*node+1, mid+1,e,i,j);
		return q1*q2;
	}
	
	public void upDatePoint(int i , int val){
		int index = i+N-1;
		Stree[index]=val;
		while(index>1){
			index/=2;
			Stree[index]=Stree[index*2]*Stree[index*2+1];
		}
	}
}
public class IntervalProduct_UVA12532 {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(br.ready()){
			String temp[]= br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			int N=1;
			while(N<n)
				N<<=1;
			int[] input = new int[N+1];
			Arrays.fill(input, 1);
			temp= br.readLine().split(" ");
			for(int i=1;i<n+1;i++){
				int x =Integer.parseInt(temp[i-1]);
				if(x<0)
					input[i]= -1;
				else if(x>0)
					input[i]=1;
				else 
					input[i]=0;
			}
			input[0]=1;
			productseg st = new productseg(input);
			String ans="";
			for(int i=0;i<k;i++){
				String s= br.readLine();
				String []r = s.split(" ");
				int f = Integer.parseInt(r[1]);
				int g = Integer.parseInt(r[2]);
				if(s.charAt(0)=='C'){
					if(g<0)
						g=-1;
						
					else 
						if(g>0)
							g=1;
						else 
							g=0;
					st.upDatePoint(f, g);
				}	
				if(s.charAt(0)=='P'){
					int x = st.query(f, g);		
					if(x<0)
						ans+="-";
					else if (x>0)
						ans+="+";
					else 
						ans+="0";
				}
			}
			System.out.println(ans);
		}
	}

}

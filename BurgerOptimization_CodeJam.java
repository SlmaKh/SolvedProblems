package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BurgerOptimization_CodeJam {
	
	public static int findBefore(int[]arr,int num){
		for(int i=num;i>=0;i--){
			if(arr[i]>0){
				return i;
			}
		}
		return -1;
	}
	public static int findAfter(int[]arr,int num){
		for(int i=num+1;i<arr.length;i++){
			if(arr[i]>0){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out= new PrintWriter(System.out);
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			int k= Integer.parseInt(br.readLine());
			String []r=br.readLine().split(" ");
			int []x=new int[k];
			int []freq2=new int[100];
			for(int i=0;i<k;i++){
				x[i]=Integer.parseInt(r[i]);
				freq2[x[i]]++;
			}
			int y[]=new int[k];
			if(k>=2){
				y[0]=0;
				y[1]=1;
			}
			if(k>=4){
				y[y.length-1]=0;
				y[y.length-2]=1;
			}
			int i=0;
			int freq[]=new int [101];
			for(;i<=k/2-1;i++){
				y[i]=i;
				freq[y[i]]++;
			}	
			int c=0;
			if(k%2==0){
				y[i]=(k/2)-1;
				freq[y[i]]++;
				c=y[i]-1;
				i++;
			}
			else {
				y[i]=(k-1)/2;
				freq[y[i]]++;
				c=y[i]-1;
				i++;
			}
			for(;i<y.length;i++){
				y[i]=c;
				freq[y[i]]++;
				c--;
			}
			int result=0;
			Arrays.sort(x);
			Arrays.sort(y);
			
			for(int j=0;j<x.length;j++){
				result+=(x[j]-y[j])*(x[j]-y[j]);
			}
			out.println("Case #"+(t+1)+": "+	result);
		}
		out.flush();
		out.close();
	}
}

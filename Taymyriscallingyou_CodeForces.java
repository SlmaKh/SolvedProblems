package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taymyriscallingyou_CodeForces {

	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String []a= s.split(" ");
		int n=Integer.parseInt(a[0]);
		int m=Integer.parseInt(a[1]);
		int z=Integer.parseInt(a[2]);
		int max = Math.max(n,m);
		int min=Math.min(n,m);
		int lim=z/max;
		//System.out.println("the limit is  "+ lim);
		int count=0;
		for(int i=1;i<=lim+1;i++){
			int x=max*i;
			if(x<=z&&x%min==0){
				count++;
			}
			if(x>z){
				break;
			}
		}
		System.out.println(count);
				
	}
}

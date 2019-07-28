package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MishkaandContest_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String []r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int k = Integer.parseInt(r[1]);
		r= br.readLine().split(" ");
		int [] diff= new int [n];
		for(int i=0;i<n;i++){
			diff[i]=Integer.parseInt(r[i]);
		}
		int ans=0;
		int index=0;
		for(int i=0;i<diff.length;i++){
			if(diff[i]<=k){
				index=i;
				ans++;
			//	System.out.println(diff[i]);
				}
			else 
				break;
		}
		//System.out.println(index);
		for(int i=diff.length-1;i>index;i--){
			if(diff[i]<=k){
				ans++;
			//	System.out.println(diff[i]);
			}
			else 
				break;
		}
		
		System.out.println(ans);
	}

}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CouponsandDiscounts_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String []temp = br.readLine().split(" ");
		int [] num = new int[n];
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(temp[i]);
		}
		for(int i=0;i<n-1;i++){
			int cur = num[i];
			if(cur%2!=0){
				if(num[i+1]==0){
					num[n-1]=3;
					break;
				}
				num[i+1]--;
			}
		}
		if(num[n-1]!=0 && num[n-1]%2!=0){
			out.println("NO");
		}
		else 
			out.println("YES");
		out.flush();
		out.close();
	}

}

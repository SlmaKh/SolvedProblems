package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BlockAdventure_CodeForces {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String []temp  = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]); // ones he has 
			int k = Integer.parseInt(temp[2]);
			int [] num = new int[n];
			temp  = br.readLine().split(" ");
			for(int i=0;i<n;i++){
				num[i]=Integer.parseInt(temp[i]);
			}
			boolean flag=true;
			for(int i=0;i<n-1&& flag;i++){
				int cur = num[i];
				int next = num[i+1];
				if(cur>=next){
					int ok = next-k;
					if(ok<0)
						ok=0;
					m+=(cur-ok);

				}
				else
					if(cur<next){
						int diff= next-cur;
						if(diff<=k){
							if(next<=k){
								m+=cur;
							}
							else {
								int ok = next-k;
								m+=(cur-ok);
							}
						}
						else 
							if(diff-m<=k){
							m-=(diff-k);
						}
						else if(diff-m>k){
							out.println("NO");
							flag=false;
						}
					}
			}
			if(flag)
				out.println("YES");
		}
		out.flush();
		out.close();

	}

}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class RoundTableKnights_CodeForces {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String [] temp  = br.readLine().split(" ");
		int []num = new int[n];
		int countOnes=0;
		ArrayList<Integer>hs= new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(temp[i]);
			if(num[i]==1)
				countOnes++;
			if(num[i]==1){
				hs.add(i);
			}
		}
		if(countOnes==n){
			System.out.println("YES");
			System.exit(0);
		}
		for(int f:hs){
			for(int x=2;x<n;x++){
				if(((n-f)/(x-1))+1<3){
					break;
				}
				boolean flag=true;
				int target=n/x;
				int count=1;
				int i=f+x;
				for(i=f+x;i<n;i+=x){
					if(num[i]!=1){
						flag=false;
						break;
					}
					else{
						count++;
					}
				}

				if(target>2&&flag && count==target && i-n==f){
					System.out.println("YES");
					System.exit(0);
				}

			}

		}
		System.out.println("NO");
	}
}

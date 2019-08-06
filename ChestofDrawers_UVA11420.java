package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class ChestofDrawers_UVA11420 { // 1 is locked and 0 is unlocked
	static int n;
	static int s;
	static long [][][]memo; // index is number of locked and value is the number secured
	public static long dp(int n,int secured, int above){
		if(n==1){
			if(secured==0&&above==1)
				return 1;
			if(secured==0 &&above==0)
				return 2;
			if(secured==1 && above==1)
				return 1;
			return 0;
		}
		if(n<secured)
			return 0;
		if(n==secured&&above==0)
			return 0;
		if (memo[n][secured][above]!=-1)
			return memo[n][secured][above];
		if(above==1)
			if(secured>0)
				memo[n][secured][above]=dp(n-1,secured-1,1)+dp(n-1,secured,0);
			else memo[n][secured][above]=dp(n-1,secured,0);
		else
			memo[n][secured][above]=dp(n-1,secured,1)+dp(n-1,secured,0);
		return memo[n][secured][above];
	}

	public static int countSecured(int []a){
		int count=0;

		for(int i=0;i<a.length;i++){
			if(i==0 && a[i]==1)
				count++;
			else if(a[i]==1 && a[i-1]==1)
				count++;
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		while(temp.charAt(0)!='-'){ // don't forget to read temp again
			String r[]=temp.split(" ");
			n = Integer.parseInt(r[0]);
			s =Integer.parseInt(r[1]);
			if(s>n)
				System.out.println(0);
			else{
				memo=new long[n+1][s+1][2];
				for(int i=0;i<n+1;i++)
					for(int j=0;j<s+1;j++)
						Arrays.fill(memo[i][j],-1);

				System.out.println(dp(n,s,1));
			} 
			temp=br.readLine();
		}
	}

}

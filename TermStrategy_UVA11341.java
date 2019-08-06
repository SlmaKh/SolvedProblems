package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TermStrategy_UVA11341{
	static int[][]grid;
	static int n; //courses
	static int m; //hours
	static int memo[][];
	public static int dp (int courses, int hours){
		if(hours<0)
			return Integer.MIN_VALUE;
		if(courses==n)
			return 0;
		if(memo[courses][hours]!=-1)
			return memo[courses][hours];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<m;i++){
			int take= grid[courses][i]+dp(courses+1,hours-(i+1));
			if(grid[courses][i]>=5&&take>max)
				max=take;
		}
		return memo[courses][hours]=max;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String []r=br.readLine().split(" ");
			n=Integer.parseInt(r[0]); // no of courses
			m=Integer.parseInt(r[1]);// no of hours
			grid=new int [n][m];
			for(int i=0;i<n;i++){
				String[] temp=br.readLine().split(" ");
				for(int j=0;j<m;j++){
						grid[i][j]=Integer.parseInt(temp[j]);
						}
			}
			memo=new int [n+10][m+10];
			for(int i=0;i<n;i++)
				Arrays.fill(memo[i],-1);
			double total = dp(0,m);
			if(total>0){
				double x = total/n;
				x=Math.round(x*100);
				x=x/100;			
				String ans=x+"";
				for(int i=0;i<ans.length();i++){
					if(ans.charAt(i)=='.'){
//						if(ans.charAt(i+1)=='0'){
//							ans+="0";
//							break;
//						}
						if(i+2==ans.length()){
							ans+="0";
							break;
						}
						
							
					}
				}
				System.out.println("Maximal possible average mark - "+ans+".");
				}
			else 
				System.out.println("Peter, you shouldn’t have played billiard that much.");
		}
	}

}


//2
//4 5
//5 5 6 7 8
//5 5 6 7 8
//5 6 7 8 8
//6 7 8 9 9
//4 5
//4 5 6 7 8
//4 5 6 7 8
//5 6 7 8 8
//6 7 8 9 9

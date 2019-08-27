package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TreasureMap_CodeForces {
	static int []starts;
	static int []d ;
	static int [][]path;
	static int n;
	static int m;
	static int max;
	static long [][]memo;
	public static long dp(int cur, int day){
		if(cur==n)
			return 0;
		if(day>max){
			return 0;
		}
		if(memo[cur][day]!=-1){
			return memo[cur][day];
		}
		long max = Long.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(i!=cur && path[cur+1][i+1]!=0){
				if(starts[cur]-day*d[cur]>0){
					max=Math.max(max,(starts[cur]-day*d[cur])+dp(i,day+path[cur+1][i+1]));
				}
				else{
					max=Math.max(max,dp(i,day+path[cur+1][i+1]));
				}
			}
		}
		return memo[cur][day]=max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		String []temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		starts=new int[n];
		max=0;
		d=new int[n];
		path=new int[1000+1][1000+1];
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			starts[i]=Integer.parseInt(temp[0]);
			d[i]=Integer.parseInt(temp[1]);
			if(starts[i]/d[i]>max)
				max=(int) Math.ceil((double)(starts[i]/d[i]));
		}

		for(int i=0;i<m;i++){
			temp = br.readLine().split(" ");
			int x =Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			path[x][y]=Integer.parseInt(temp[2]);
			path[y][x]=Integer.parseInt(temp[2]);
		}
		memo=new long[n+1][max+1];
		for(int i=0;i<n+1;i++){
			Arrays.fill(memo[i],-1);
		}
		out.println(dp(0,0));
		out.flush();
		out.close();


	}

}

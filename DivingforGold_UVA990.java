package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DivingforGold_UVA990 {
	static int []d;
	static int []v;
	static int n;
	static int t;
	static int w;
	static int [][]memo;
	public static int dp (int index, int rem){ // return max value
		if(rem<0)
			return Integer.MIN_VALUE;
		if(index==n)
			return 0;
		if(memo[index][rem]!=-1)
			return memo[index][rem];
		int take = v[index]+ dp (index+1, rem-(w*d[index]+2*w*d[index]));
		int leave = dp(index+1,rem);
		return memo[index][rem]= Math.max(take, leave);

	}

	public static String trace2 (int index, int rem){
		if(rem<0 || index==n)
			return "";
		int ans= memo[index][rem];
		String x="";
		for(int i=index;i<n;i++){
			if(ans==v[i]+ dp(i+1, rem-(w*d[i]+2*w*d[i]))){
				x+=d[i]+" "+v[i]+","+trace2(i+1,rem-(w*d[i]+2*w*d[i]));
				break;
			}
		}
		return x;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		Thread.sleep(3000);
		while(br.ready()){
			String s=br.readLine();
			String []r = s.split(" ");
			t = Integer.parseInt(r[0]); // time 
			w = Integer.parseInt(r[1]); // time constant
			n= Integer.parseInt(br.readLine()); // no if treasures
			d= new int [n]; // depths
			v= new int [n]; // values
			String temp[]=new String [n];
			ArrayList<String>tempo=new ArrayList<String>();
			for(int i=0;i<n;i++){
				String sel=br.readLine();
				temp[i]=sel;
				tempo.add(sel);
				String[]se = sel.split(" ");
				d[i]=Integer.parseInt(se[0]);
				v[i]=Integer.parseInt(se[1]);
			}
			memo=new int [31][1001];
			for(int i=0;i<31;i++)
				Arrays.fill(memo[i], -1);
			int f=dp(0,t);
			System.out.println(f);
			if(f==0)
				System.out.println(0);
			else{
			String ans=trace2(0,t);
			String[]answer=ans.split(",");
			System.out.println(answer.length);
			boolean[]tracker=new boolean[tempo.size()];
			for(int j=0;j<tempo.size();j++)
				for(int i=0;i<answer.length;i++)
					if(tracker[j]==false&& answer[i].equals(tempo.get(j))){	
						System.out.println(answer[i]);
						tracker[j]=true;
						break;
					}
			}
			if(br.ready()){
				System.out.println();
				s = br.readLine();
			}
		}
	}
}

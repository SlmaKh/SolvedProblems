package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class KitchenCombinatorics_CodeForces {
	static ArrayList<Integer>dishes[];
	static int brands[];
	static boolean[][]comp;
	static long [][][]memo;
	static BigInteger []ways;
	static int s;
	static int m;
	static int d;
	public static BigInteger dp (int lastSide, int lastMain, int lastDessert){
		if(lastSide!=0&& lastMain!=0 && lastDessert!=0)
			return new BigInteger("1");
		BigInteger total=new BigInteger(0+"");
		if(lastSide==0){
			for(int i=1;i<=s;i++){
				BigInteger w = ways[i];
				BigInteger d = dp(i,0,0);
				w=w.multiply(d);
				total=total.add(w);
			}
		}
		else
			if(lastSide!=0 && lastMain==0){
				for(int i=s+1;i<=s+m;i++){
					BigInteger ff = new BigInteger("1");
					if(!comp[lastSide][i]){
						for(int x:dishes[i]){
							if(dishes[lastSide].contains(x)){
								ff=ff.multiply(new BigInteger(brands[x]+""));
							}
						}
						BigInteger w = ways[i];
						w=w.divide(ff);
						w=w.multiply(dp(lastSide,i,0));
						total=total.add(w);
					}
				}
			}
			else 
				for(int i=s+m+1;i<=s+m+d;i++){
					BigInteger ff = new BigInteger("1");
					if(!comp[lastSide][i]&& !comp[lastMain][i]){
						for(int x:dishes[i]){
							if(dishes[lastSide].contains(x)||dishes[lastMain].contains(x)){
								ff=ff.multiply(new BigInteger(brands[x]+""));
							}
						}
						BigInteger w = ways[i];
						w=w.divide(ff);
						w=w.multiply(dp(lastSide,lastMain,i));
						total=total.add(w);
					}
				}
		return total;
	}



	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []temp = br.readLine().split(" ");
		int r = Integer.parseInt(temp[0]);
		s  =Integer.parseInt(temp[1]);
		m = Integer.parseInt(temp[2]);
		d = Integer.parseInt(temp[3]);
		int n = Integer.parseInt(temp[4]);
		temp = br.readLine().split(" ");
		brands=new int [r+1];
		for(int i=0;i<r;i++){
			brands[i+1]=Integer.parseInt(temp[i]);
		}
		dishes=new ArrayList[s+m+d+10];
		ways=new BigInteger[s+m+d+10];
		for(int i=0;i<dishes.length;i++)
			dishes[i]=new ArrayList<Integer>();
		comp = new boolean[1000+1][1000+1];
		for(int i=0;i<s;i++){
			temp = br.readLine().split(" ");
			BigInteger totalDish=new BigInteger(1+"");
			for(int j=1;j<temp.length;j++){
				int cur =Integer.parseInt(temp[j]); 
				dishes[i+1].add(cur);
				BigInteger bb = new BigInteger(brands[cur]+"");
				totalDish=totalDish.multiply(bb);
			}
			ways[i+1]=totalDish;
		}
		for(int i=0;i<m;i++){
			temp = br.readLine().split(" ");
			BigInteger totalDish=new BigInteger(1+"");
			for(int j=1;j<temp.length;j++){
				int cur =Integer.parseInt(temp[j]); 
				dishes[i+1+s].add(cur);
				totalDish=totalDish.multiply(new BigInteger(brands[cur]+""));
			}
			ways[i+1+s]=totalDish;
		}
		for(int i=0;i<d;i++){
			temp = br.readLine().split(" ");
			BigInteger totalDish=new BigInteger(1+"");
			for(int j=1;j<temp.length;j++){
				int cur =Integer.parseInt(temp[j]); 
				dishes[i+1+s+m].add(cur);
				totalDish=totalDish.multiply(new BigInteger(brands[cur]+""));
			}
			ways[i+1+s+m]=totalDish;
		}

		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			int x =Integer.parseInt(temp[0]);
			int y =Integer.parseInt(temp[1]);
			comp[x][y]=true;
			comp[y][x]=true;
		}
		memo = new long[26][26][26];
		for(int i=0;i<26;i++){
			for(int j=0;j<26;j++)
				Arrays.fill(memo[i][j], -1);
		}
		BigInteger xxxx=dp(0,0,0);
		BigInteger m = new BigInteger(10+"");
		m=m.pow(18);
		if(xxxx.compareTo(m)>0||xxxx.compareTo(new BigInteger(0+""))<0){
			out.println("too many");
		}
		else
			out.println(xxxx);
		out.flush();
		out.close();
	}
}

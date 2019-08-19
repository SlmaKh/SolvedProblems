package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AntonandLines_CodeForces {


	final static double EPS = 1e-9;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n= Integer.parseInt(br.readLine());
		String []temp = br.readLine().split(" ");
		int x1 = Integer.parseInt(temp[0]);
		int x2 = Integer.parseInt(temp[1]);
		int []m=new int [n];
		int []c=new int [n];
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			int mm  =Integer.parseInt(temp[0]);
			int cc  =Integer.parseInt(temp[1]);
			m[i]=mm;
			c[i]=cc;
		}
		pairBefore [] before = new pairBefore[n];
		pairAfter [] after= new pairAfter[n];
		for(int i=0;i<n;i++){
			before[i]=new pairBefore(m[i], c[i], x1);
			after [i]=new pairAfter(m[i], c[i], x2);
		}
		Arrays.sort(before);
		Arrays.sort(after);
		for(int i=0;i<n;i++){
			pairBefore cur =before[i];
			pairAfter cur2 =after[i];
			if(cur.m!=cur2.m || cur.c!=cur2.c){
				System.out.println("YES");
				System.exit(0);
			}
		}
		System.out.println("NO");
	}
}

class pairBefore implements Comparable<pairBefore>{ 
	int m,c,x1;
	static final double EPS=1e-9;
	public pairBefore(int m ,int c , int x1){
		this.m=m;
		this.c=c;
		this.x1=x1;
	}
	public int compareTo(pairBefore p){
		double y1=((double)m)*(x1+EPS)+c;
		double y11=((double)p.m)*(x1+EPS)+p.c;
		if(y1>y11)
			return 1;
		if(y1<y11)
			return -1;
		else
			return 0;
		
	}
}
class pairAfter implements Comparable<pairAfter>{ 
	int m,c,x2;
	static final double EPS=1e-9;
	public pairAfter(int m ,int c , int x2){
		this.m=m;
		this.c=c;
		this.x2=x2;
	}
	public int compareTo(pairAfter p){
		double y2 = ((double)m)*(x2-EPS)+c;
		double y22 = ((double)p.m)*(x2-EPS)+p.c;
		if(y2>y22)
			return 1;
		if(y2<y22)
			return -1;
		else 
			return 0;
		
	}
}
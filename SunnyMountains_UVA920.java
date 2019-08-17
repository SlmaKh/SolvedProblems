package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
class pairr implements Comparable<pairr>{
	double x;
	double y;
	public pairr(double x ,double y){
		this.x=x;
		this.y=y;
	}

	public String toString(){
		return "("+x+","+y+")";
	}
	public int compareTo(pairr p ) {
		return (int) (this.x-p.x);
	}

}
public class SunnyMountains_UVA920 {

	public static double getLength(pairr p1 , pairr p2){
		double x1 = p1.x;
		double x2 = p2.x;
		double y1 = p1.y;
		double y2 = p2.y;
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
	public static double getSlope(pairr p1 , pairr p2){
		double x1=p1.x;
		double x2=p2.x;
		double y1=p1.y;
		double y2=p2.y;
		return (double)((double)y2-(double)y1)/(double)((double)x2-(double)x1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int C = Integer.parseInt(br.readLine());
		for(int c=0;c<C;c++){
			int N = Integer.parseInt(br.readLine());
			pairr [] arr = new pairr[N];
			for(int i=0;i<N;i++){
				String []temp = br.readLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				arr[i]=new pairr(x,y);
			}
			Arrays.sort(arr);
			double length=0;
			pairr p2 =arr[arr.length-1];
			pairr p1 =arr[arr.length-2];
			double maxY = p1.y;
			length+=getLength(p1, p2);
			for(int i=arr.length-3;i>0;i--){
				pairr p = arr[i];
				i--;
				pairr pp = arr[i];
				if(pp.y>maxY){
					double slope =getSlope(p,pp);
					double cc = (double)(pp.y-(double)slope*pp.x);
					double xx = (double)(maxY-cc)/slope;
					length+=getLength(pp, new pairr(xx,maxY));
					maxY=pp.y;
				}
			}

			out.printf("%.2f\n",length);

		}
		out.flush();
		out.close();
	}

}

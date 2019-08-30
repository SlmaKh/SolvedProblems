package acm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class KingsHeir_CodeForces {


	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new FileReader("king.in"));
		PrintWriter out = new PrintWriter("king.out");
		String []temp = br.readLine().split(" ");
		int dKing = Integer.parseInt(temp[0]);
		int mKing = Integer.parseInt(temp[1]);
		int yKing = Integer.parseInt(temp[2]);
		int n  = Integer.parseInt(br.readLine()); // no of sons
		PriorityQueue<date>pq=new PriorityQueue<date>();
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			int d=Integer.parseInt(temp[0]);
			int m=Integer.parseInt(temp[1]);
			int y=Integer.parseInt(temp[2]);
			pq.add(new date(d,m,y,(i+1),dKing,mKing,yKing));
		}
		boolean printed=false;
		while(!pq.isEmpty()){
			date t =pq.poll();
			if(t.year>=18){
				out.println(t.number);
				printed=true;
				break;
			}
		}
		if(!printed)
			out.println(-1);


		out.flush();
		out.close();

	}
}


class date  implements Comparable<date>{
	int number;
	int day;
	int month;
	int year;
	int dK;
	int mK;
	int yK;
	static int days[]=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
	public date(int d,int m , int y,int n,int dk,int mk,int yk){
		this.dK=dk;
		this.mK=mk;
		this.yK=yk;
		this.number=n;
		boolean flag1=false;
		boolean flag2=false;
		this.day=d<=dK?dK-d:dK-d+days[mK==1?12:mK-1];
		if(dK<d){
			flag1=true;
			mK--;
		}
		if(mK>=m){
			this.month=mK-m;

		}
		else{
			yK--;
			flag2=true;
			this.month=mK-m+12;

		}
		this.year=yK-y;
	}

	public int compareTo(date d){
		if(this.year==d.year)
			if(this.month==d.month)
				return this.day-d.day;
			else
				return this.month-d.month;
		else
			return this.year-d.year;
	}





	//	public int compareTo(date d){
	//		if(this.year==d.year){
	//			if(this.month==d.month)
	//				return d.day-this.day;
	//			else
	//				return d.month-this.month;
	//		}
	//		else
	//			return d.year-this.year;
	//	}
	public String toString(){
		return "("+day+" , "+month+" , "+year+" , "+number+")";
	}
}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class RotateIt_CodeForces {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		int T  =Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			int n= Integer.parseInt(br.readLine());
			String []temp = br.readLine().split(" ");
			long [] num= new long[n];
			long sum=0;
			int taken=n%2==0?n/2:(n/2)+1;
			for(int i=0;i<n;i++){
				long x= Long.parseLong(temp[i]);
				num[i]=x;
			}
			long max=Long.MIN_VALUE;
			for(int i=0;i<n;i++){
				long total=0;
				int index=i;
				for(int j=0;j<taken;j++){
					if(index>=n)
						index-=n;
					total+=num[index];
					index+=2;
				}
				if(total>max)
					max=total;
			}
			out.println(max);
		}
		out.flush();
		out.close();
		
	}

}

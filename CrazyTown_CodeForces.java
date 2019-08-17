package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CrazyTown_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []temp = br.readLine().split(" ");
		long x1 = Long.parseLong(temp[0]);
		long y1 = Long.parseLong(temp[1]);
		temp = br.readLine().split(" ");
		long x2 = Long.parseLong(temp[0]);
		long y2 = Long.parseLong(temp[1]);
		int n = Integer.parseInt(br.readLine());
		int count=0;
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			long a =Long.parseLong(temp[0]);
			long b =Long.parseLong(temp[1]);
			long c =Long.parseLong(temp[2]);
			double y11 = (double)((double)(-1*c-a*x1)/(double)b);
			double y22 = (double)((double)(-1*c-a*x2)/(double)b);
			if(y11-y1 < 0 && y22-y2 >0)
				count++;
			else 
				if(y11-y1 > 0 && y22-y2 <0)
					count++;
		}
		
		out.println(count);
		out.flush();
		out.close();
	}

}

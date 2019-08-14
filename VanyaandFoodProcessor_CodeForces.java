package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class VanyaandFoodProcessor_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int h = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);
		temp = br.readLine().split(" ");
		int[]heights = new int[n];

		for(int i=0;i<n;i++){
			heights[i]=Integer.parseInt(temp[i]);
		}
		BigInteger sec=new BigInteger(0+"");
		long total =0;
		int cur = heights[0];
		int counter=0;
		for(int i=0;i<n;i++){
			int index=i;
			while(index<n&&total+heights[index]<=h){
				total+=heights[index];
				counter++;
				index++;
			}
			if(index<n&&total+heights[index]<=h)
				i=index;
			else 
				i=index-1;
			if(total<k){
				total=0;
				sec=sec.add(new BigInteger(1+""));
			}
			else{
				sec=sec.add(new BigInteger((total/k)+""));
				total=total-k*(total/k);
			}
		}
		while(total>0){
			if(total<k){
				total=0;
				sec=sec.add(new BigInteger(1+""));
			}
			else{
				sec=sec.add(new BigInteger((total/k)+""));
				total=total-k*(total/k);
			}
		}
		out.println(sec);
		out.flush();
		out.close();
	}
}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class ArpasobviousproblemandMehrdadsterriblesolution_CodeForces {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String [] temp = br.readLine().split(" ");
		int n= Integer.parseInt(temp[0]);
		int x= Integer.parseInt(temp[1]);
		int num []= new int [n];
		int freq[]=new int [10000000+1];
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(temp[i]);
			freq[num[i]]++;
		}
		BigInteger count=new BigInteger(0+"");
		for(int i=0;i<n;i++){
			int cur = num[i];
			int find = cur^x;
			if(freq[cur]!=0&&find==cur){
				BigInteger b = new BigInteger(freq[cur]+"");
				BigInteger c = new BigInteger(freq[cur]-1+"");
				b=b.multiply(c);
				b=b.divide(new BigInteger(2+""));
				count=count.add(b);
				freq[cur]=0;
			}
			else{
				if(freq[find]!=0 && freq[cur]!=0){
					BigInteger b = new BigInteger(freq[find]+"");
					BigInteger c = b.multiply(new BigInteger(freq[cur]+""));
					count=count.add(c);
					freq[cur]=0;
					freq[find]=0;				
				}
			}
		}
		out.println(count);
		out.flush();
		out.close();


	}
}

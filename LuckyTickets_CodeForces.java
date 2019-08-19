package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class LuckyTickets_CodeForces {
	static int []num;
	static int []memo;
	static int n;

	public static int sum(int n){
		int sum=0;
		while(n>0){
			sum+=n%10;
			n/=10;
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		n=Integer.parseInt(br.readLine());
		num = new int[n];
		String []temp= br.readLine().split(" ");
		for(int i=0;i<n;i++){
			int x=Integer.parseInt(temp[i]);
			num[i]=x;
		}
		int count=0;
		for(int i=0;i<n;i++){
			int cur = num[i];
			if(cur!=-1){
				for(int j=i+1;j<n;j++){
					int x = num[j];
					if(x!=-1&&(sum(cur)+sum(x))%3==0){
						count++;
						num[i]=-1;
						num[j]=-1;
						break;
					}
				}
			}
		}
		System.out.println(count);
	}
}

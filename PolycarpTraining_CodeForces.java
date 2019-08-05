package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PolycarpTraining_CodeForces {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp[] = br.readLine().split(" ");
		int [] num = new int [n];
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(temp[i]);
			pq.add(num[i]);
		}
		int count=0;
		int cur=1;
		for(int i=0;i<n;i++){
			int x = pq.poll();
			if(x>=cur){
				count++;
				cur++;
			}
		}
		System.out.println(count);
	}
}

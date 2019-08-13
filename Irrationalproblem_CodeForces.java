package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Irrationalproblem_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String temp [] = br.readLine().split(" ");
		int p1 = Integer.parseInt(temp[0]);
		int p2 = Integer.parseInt(temp[1]);
		int p3 = Integer.parseInt(temp[2]);
		int p4 = Integer.parseInt(temp[3]);
		int a =  Integer.parseInt(temp[4]);
		int b =  Integer.parseInt(temp[5]);
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
		pq.add(p1);
		pq.add(p2);
		pq.add(p3);
		pq.add(p4);
		int min  =pq.poll();
		if(min<a)
			out.println(0);
		else 
			if(min>b)
				out.println(b-a+1);
			else
				out.println(min-a);
		out.flush();
		out.close();
	}
}

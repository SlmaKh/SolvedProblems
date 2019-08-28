package acm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RandomAccessMemory_CodeForces {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out  = new PrintWriter("output.txt");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out  =new  PrintWriter(System.out);
		int N  = Integer.parseInt(br.readLine());
		ArrayList<String> ref1  =new ArrayList<String>();
		ArrayList<String> ref2 =new ArrayList<String>();
		ArrayList<String> ref3  =new ArrayList<String>();
		ArrayList<String> not1  =new ArrayList<String>();
		ArrayList<String> not2 =new ArrayList<String>();
		ArrayList<String> not3  =new ArrayList<String>();
		for(int n=0;n<N;n++){
			String []temp = br.readLine().split(" ");
			String s1=temp[0];
			String s2=temp[1];
			String s3=temp[2];
			String r=temp[3];
			if(r.equals(s1)){
				not1.add(r);
				if(ref1.contains(r))
					ref1.remove(r);
				if(!ref2.contains(s2)&&!not2.contains(s2))
					ref2.add(s2);
				if(!ref3.contains(s3)&&!not3.contains(s3))
					ref3.add(s3);

			}
			if(r.equals(s2)){
				if(ref2.contains(r))
					ref2.remove(r);
				not2.add(r);
				if(!ref1.contains(s1)&&!not1.contains(s1))
					ref1.add(s1);
				if(!ref3.contains(s3)&&!not3.contains(s3))
					ref3.add(s3);
			}
			if(r.equals(s3)){
				not3.add(r);
				if(ref3.contains(r))
					ref3.remove(r);
				if(!ref1.contains(s1)&&!not1.contains(s1))
					ref1.add(s1);
				if(!ref2.contains(s2)&&!not2.contains(s2))
					ref2.add(s2);
			}
			
			out.println(ref1.size()+" "+ref2.size()+" "+ref3.size());
		}
		out.flush();
		out.close();
	}
}

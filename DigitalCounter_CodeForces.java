package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DigitalCounter_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int [] poss = new int [10];
		poss[0]=2; //0 8
		poss[1]=7; //0 1 3 4 7 8 9
		poss[2]=2; //2 8
		poss[3]=3; //3 8 9
		poss[4]=3; //4 8 9
		poss[5]=4; //5 6 8 9
		poss[6]=2; //6 8 
		poss[7]=5; //0 3 7 8 9 
		poss[8]=1; //8
		poss[9]=2; //8 9
		String s = br.readLine();
		int f = Integer.parseInt(s.charAt(0)+"");
		int l = Integer.parseInt(s.charAt(1)+"");
		out.println(poss[f]*poss[l]);
		out.flush();
		out.close();
	}

}

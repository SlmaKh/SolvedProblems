package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MahmoudandLongestUncommonSubsequence_CodeForces {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		if(a.equals(b))
			System.out.println(-1);
		else 
			System.out.println(Math.max(a.length(), b.length()));
	}

}

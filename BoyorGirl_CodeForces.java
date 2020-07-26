package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BoyorGirl_CodeForces {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		int[] freq = new int[26];
		for(int i = 0; i<s.length(); i++){
			freq[s.charAt(i)-'a']++;
		}
		int numDistinct = 0;
		for(int i = 0; i < freq.length; i++){
			if(freq[i] >= 1)
				numDistinct ++;
		}
		if(numDistinct % 2 == 0){
			out.println("CHAT WITH HER!");
		}
		else{
			out.println("IGNORE HIM!");
		}
		out.flush();
		out.close();
	}
}

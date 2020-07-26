package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Lightmorelight_UVA10110 {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long n = Long.parseLong(br.readLine());
		while(n != 0){
			if((int)Math.sqrt(n) == Math.sqrt(n))
				out.println("yes");
			else
				out.println("no");
			n = Long.parseLong(br.readLine());
			}
		out.flush();
		out.close();
	}

}

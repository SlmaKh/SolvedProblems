package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Magnets_CodeForces {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String []r = new String [n];
		for (int i = 0; i < n; i++) {
			r[i]= br.readLine();
		}
		int result = 1;
		for (int i = 0; i < n - 1; i++) {
			String first = r[i];
			String second = r[i + 1];
			if(!first.equals(second))
				result++;
		}
		out.println(result);
		out.flush();
		out.close();
	}
}

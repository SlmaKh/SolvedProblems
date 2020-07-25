package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Team {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i < n; i++){
			int temp = 0;
			String []r = br.readLine().split(" ");
			if(r[0].equals("1"))
				temp ++;
			if(r[1].equals("1"))
				temp ++;
			if(r[2].equals("1"))
				temp ++;
			if(temp > 1)
				result ++;
		}
		out.println(result);
		out.flush();
		out.close();
	}

}

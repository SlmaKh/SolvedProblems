package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ValeraandX_CodeForces {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		char diagonal = ' ';
		String res = "";
		char other =' ';
		all: for (int i = 0; i < n; i++) {
			String r = br.readLine();
			for (int j = 0; j < n; j++) {
				if(i == 0 && j == 0){
					diagonal = r.charAt(0);
				}
				if(i == 0 && j == 1){
					other = r.charAt(1);
					if(other == diagonal){
						res = "NO";
						break all;
					}
				}
				if(i == j && r.charAt(j)!= diagonal){
					res = "NO";
					break all;
				}
				if(i + j == n - 1 && r.charAt(j)!= diagonal){
					res = "NO";
					break all;
				}
				if(!(i == j || i + j == n - 1)){
					if(r.charAt(j) != other){
						res = "NO";
						break all;
					}
				}
					
			}
		}
		if(res.isEmpty()){
			res = "YES";
		}
		out.println(res);
		out.flush();
		out.close();
	}

}

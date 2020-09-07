package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BrainsPhotos_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int m = Integer.parseInt(r[1]);
		String res = "";
		all :for (int i = 0; i < n; i++) {
			r = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				if(r[j].equals("C") || r[j].equals("M") || r[j].equals("Y")){
					res = "#Color";
					break all;
				}
			}
		}
		if(res.isEmpty()){
			res = "#Black&White";
		}
		out.println(res);
		out.flush();
		out.close();
	}
}

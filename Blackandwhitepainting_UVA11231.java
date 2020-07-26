package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Blackandwhitepainting_UVA11231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		while(!s.equals("0 0 0")){
			String [] r = s.split(" ");
			int rows = Integer.parseInt(r[0]);
			int cols = Integer.parseInt(r[1]);
			boolean white = r[2].equals("1");
			cols -= 7;
			rows -= 7;
			int x1 = cols / 2;
			int x2 = cols - x1;
			int smallx = Math.min(x1, x2);
			int bigx = Math.max(x1, x2);
			int y1 = rows /2;
			int y2 = rows - y1;
			int smally = Math.min(y1, y2);
			int bigy = Math.max(y1, y2);
			
			long res = 0;
			if(!white){
				res = smallx * bigy + bigx * smally; 
			}
			else{
				res = bigx * bigy + smallx * smally;
			}
			out.println(res);
			s = br.readLine();
		}
		out.flush();
		out.close();
	}
}

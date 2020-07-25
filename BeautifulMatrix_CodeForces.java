package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BeautifulMatrix_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int x = 0;
		int y = 0;
		all: for(int i = 0; i < 5; i++){
			String [] r = br.readLine().split(" ");
			for(int j = 0; j < 5; j++ ){
				if(r[j].equals("1")){
					x = i;
					y = j;
					break all;
				}
			}
		}
		out.println(Math.abs(x - 2) + Math.abs(y - 2));
		out.flush();
		out.close();
	}

}

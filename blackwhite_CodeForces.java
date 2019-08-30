package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class blackwhite_CodeForces {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String []temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int w = Integer.parseInt(temp[1]);
			int b = Integer.parseInt(temp[2]);
			if(Math.abs(b-w)==1){
				out.println("Mikael");
			}
			else{
			int diff = Math.abs(b-w)-1;
			if(diff%2==1){
				out.println("Steven");
			}
			else 
				out.println("Mikael");
			}
		}
		out.flush();
		out.close();

	}

}

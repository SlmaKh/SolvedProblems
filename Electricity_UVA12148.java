package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Electricity_UVA12148 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		while(!s.equals("0")){
			int n = Integer.parseInt(s);
			int nextDay = 0;
			int nextMonth = 0;
			int nextYear = 0;
			int prevC = 0;
			long total = 0 ;
			int count = 0;
			for (int i = 0; i < n; i++) {
				String []r = br.readLine().split(" ");
				int D = Integer.parseInt(r[0]);
				int M = Integer.parseInt(r[1]);
				int Y = Integer.parseInt(r[2]);
				int C = Integer.parseInt(r[3]);
				if(D == nextDay && M == nextMonth && Y == nextYear){
					total += (C - prevC);
					count ++;
				}
				prevC = C;
				if(D == 31 && M == 12){
					nextDay = 1;
					nextMonth = 1;
					nextYear = ++Y;
				}
				else if (M ==2){
					if((Y % 4 == 0 && Y % 100 != 0 ) || Y % 400 == 0){
						if(D == 29){
							nextDay = 1;
							nextMonth = 3;
							nextYear = Y;
						}
						else {
							nextDay = ++D;
							nextMonth = M;
							nextYear = Y;
						}
					}
					else {
						if(D == 28){
							nextDay = 1;
							nextMonth = 3;
							nextYear = Y;
						}
						else {
							//System.out.println("here");
							nextDay = ++D;
							nextMonth = M;
							nextYear = Y;	
						}
					}
				}
				else if (M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12){
					if(D == 31){
						nextDay = 1;
						nextMonth = ++M ;
						nextYear = Y;
					}
					else {
						//System.out.println("here");
						nextDay = ++D;
						nextMonth = M;
						nextYear = Y;	
					}
				}
				else if(D == 30){
						nextDay = 1;
						nextMonth = ++M;
						nextYear = Y;	
					}
					
				else {
					//System.out.println("here");
					nextDay = ++D;
					nextMonth = M;
					nextYear = Y;	
				}
//				System.out.println("nextDay "+ nextDay);
//				System.out.println("nextMonth "+ nextMonth);
//				System.out.println("nextYear "+ nextYear);
				
				
			}
			
			
			out.println(count + " "+ total);
			s = br.readLine();
			
		}
		out.flush();
		out.close();
	}
}

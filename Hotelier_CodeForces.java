package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Hotelier_CodeForces {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int []num = new int [10];
		int lastLeft=0;
		int lastRight=9;
		for(int i=0;i<n;i++){
			char cur = s.charAt(i);
			if(cur=='L'){
				for(int c=0;c<10;c++){
					if(num[c]==0){
						lastLeft=c;
						break;
					}
				}
				num[lastLeft]=1;
				for(int c=0;c<10;c++){
					if(num[c]==0){
						lastLeft=c;
						break;
					}
				}
			}
			else
				if(cur=='R'){
					for(int c=9;c>=0;c--){
						if(num[c]==0){
							lastRight=c;
							break;
						}
					}
					num[lastRight]=1;
					for(int c=9;c>=0;c--){
						if(num[c]==0){
							lastRight=c;
							break;
						}
					}
				}
				else {
					int index = Integer.parseInt(cur+"");
					num[index]=0;
				}
		}
		for(int i=0;i<10;i++){
			out.print(num[i]);

		}
		out.flush();
		out.close();

	}

}

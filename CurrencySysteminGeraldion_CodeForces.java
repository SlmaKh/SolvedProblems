package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurrencySysteminGeraldion_CodeForces {
	public static void main(String []args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1 = b.readLine();
		int n = Integer.parseInt(s1);
		String s = b.readLine();
		String a []= s.split(" ");		
		for(int i=0;i<n;i++){
			int x =Integer.parseInt(a[i]);
			if(x==1){
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(1);
	}

}

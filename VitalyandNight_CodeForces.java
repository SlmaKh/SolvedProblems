package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VitalyandNight_CodeForces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int [][] apt = new int [n][2*m];
		int count=0;
		for(int i=0;i<n;i++){
			temp=br.readLine().split(" ");
			for(int j=0;j<2*m;j++){
				int s = Integer.parseInt(temp[j]);
				if(s==1){
					count++;
					if(j%2==0)
					j++;
				}
			}
		}
		System.out.println(count);
  
	}

}

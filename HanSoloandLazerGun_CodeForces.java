package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HanSoloandLazerGun_CodeForces {
	static Integer[]x;
	static Integer[]y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int x1 = Integer.parseInt(temp[1]);
		int y1 = Integer.parseInt(temp[2]);
		x = new Integer [n];
		y = new Integer [n];
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			x[i]=Integer.parseInt(temp[0]);
			y[i]=Integer.parseInt(temp[1]);
		}
		int shots=0;
		int count=0;
		for(int i=0;i<n&&count<n;i++){
			Integer x2=x[i];
			Integer y2=y[i];
			x[i]=null;
			y[i]=null;
			if(x2!=null && y2!=null){
				shots++;
				for(int j=0;j<n;j++){
					Integer x3 = x[j];
					Integer y3 = y[j];
					if(x3!=null && y3!=null){
						if((x2-x1)*(y3-y1)==(x3-x1)*(y2-y1)){
							count++;
							x[j]=null;
							y[j]=null;
						}
					}		
				}				
				count++;
			}
		}
		System.out.println(shots);

	}

	public static double getM(int x1 , int y1 , int x2, int y2 ){
		return x2!=x1?(double)((double)(y2-y1)/(double)(x2-x1)):Double.MAX_VALUE;
	}

	public static double getC (int x , int y , double  m){
		return m!=Double.MAX_VALUE?(double)(y-(double)m*x):0;
	}

	public static boolean onLine(int x, int y , double c ,double m){
		return m*x+c==y;
	}

}

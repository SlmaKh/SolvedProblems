package acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class RationalNumbersFromRepeatingFractions_UVA332 {

	public static int gcd(int a , int b){
		if(b==0)
			return a ;
		return gcd(b, a%b);
	}
	public static BigDecimal repeat(String dec, String s){
		StringBuilder res = new StringBuilder(dec+"");
		for(int i=0;i<100;i++){
			res=res.append(s);
		}
		return new BigDecimal(res.toString());
	}
	public static String getFraction(BigDecimal dec){
		String s = dec+"";
		int n=1;
		int i=0;
		for( i= s.length()-1;i>=0 && s.charAt(i)!='.';i--){
			n*=10;
		}
		int num = Integer.parseInt(s.substring(i+1));
		int x = gcd(num,n);
		return (num/x)+"/"+(n/x);
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc= new Scanner(System.in);
		int j = sc.nextInt();
		int count=0;
		while(j!=-1){ 
			count++;
			String decimal = sc.next();
			double ddd= Double.parseDouble(decimal);
			BigDecimal dec = new BigDecimal(decimal);
			String s = dec+"";
			if(ddd==0)
				out.println("Case "+count+":"+" "+"0/1");
			else{
				int k = decimal.substring(2).length()-j;
				int b =decimal.length()-j;
				if(b>=0 && j!=0){
					String sub = decimal.substring(b);
					dec = repeat(decimal,sub);
					BigDecimal num =dec.multiply(new BigDecimal(Math.pow(10, k+j)+"")).subtract(dec.multiply(new BigDecimal(Math.pow(10,k)+"")));
					String nn =num+"";
					int nnnn=(num.add(new BigDecimal(0.9))).intValue();
					int den= (int)((Math.pow(10,k+j))-Math.pow(10,k));
					int gcd = gcd(nnnn,den);
					if(gcd==0){
						System.out.println("the dec is "+ dec);
						System.out.println("the num is "+ num);
						System.out.println("the den is "+ den);
					}
					int up = nnnn/gcd;
					int down = den/gcd;
					out.println("Case "+count+":"+" "+up+"/"+down);
				
				}
				else {
					String f = getFraction(dec);
					out.println("Case "+count+":"+" "+f);
				}
			}
			j = sc.nextInt();
		}
		out.flush();
		out.close();
	}

}

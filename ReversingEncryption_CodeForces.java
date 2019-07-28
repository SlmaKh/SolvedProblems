package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class ReversingEncryption_CodeForces{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String t = br.readLine();
		TreeSet <Integer>ts=new TreeSet<Integer>();
		for(int i=2;i<=n;i++){
			if(n%i==0)
				ts.add(i);
		}
		for(int x:ts){
			String reverse=rev(t.substring(0,x));
			String rest=t.substring(x);
			t=reverse+rest;
		}
		System.out.println(t);
		
		
		
	}
	
	public static String rev (String s){
		String r="";
		for(int i=s.length()-1;i>=0;i--){
			r+=s.charAt(i);
		}
		return r;
				
	}

}

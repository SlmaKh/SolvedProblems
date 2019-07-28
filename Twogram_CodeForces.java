package acm;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

public class Twogram_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s =br.readLine();
		String [] subs = new String [n*2];
		int [] freq= new int [n*2];
		int j=0;
		int  min=n;
		String minString=s;
		for(int i=0;i<n-1;i++){
			String temp=s;
			String substring = s.substring(i,i+2);
			if(i<n-2&&s.charAt(i+2)==s.charAt(i)&&s.charAt(i)==s.charAt(i+1)){
				char cur = s.charAt(i);
				int index=i;
				StringBuilder remove=new StringBuilder("");
				while(index<s.length()&&s.charAt(index)==cur){
					index++;
					remove.append(cur);
					}
				temp=temp.replaceAll(remove.toString(), "");
				
			}
			else 
				temp=temp.replaceAll(substring, "");
			if(temp.length()<min){
				min=temp.length();
				minString=substring;
			}
			subs[j]=substring;
			j++;
		}
		System.out.println(minString);
	}
	

}

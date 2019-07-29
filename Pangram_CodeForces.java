package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.layout.Background;

public class Pangram_CodeForces {
	
	
	public static void main(String[]args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s1= b.readLine();
		String s= b.readLine();
		s=s.toLowerCase();
		int n = Integer.parseInt(s1);
		int [] freq= new int[26];
		for(int i=0;i<n;i++){
			char c= s.charAt(i);
			freq[c-'a']=1;
		}
		for(int i=0;i<26;i++){
			if(freq[i]!=1){
				System.out.println("NO");
				System.exit(0);
			}
			
		}
		System.out.println("YES");
		
	}

}

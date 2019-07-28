package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabeticRemovals {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String []r = br.readLine().split(" ");
		int n = Integer.parseInt(r[0]);
		int k = Integer.parseInt(r[1]);
		String s= br.readLine();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		char[]a=new char[26];
		for(int i=0;i<alpha.length();i++)
			a[i]=alpha.charAt(i);
		int freq[]=new int [26];
		int count=0;
		for(int i=0;i<s.length();i++){
			freq[s.charAt(i)-'a']++;
		}
		boolean cont=true;
		for(int i=0;i<k;i++){
			for(int j=0;j<26;j++){
				if(freq[j]>0){
					freq[j]--;
					count++;
					break;
				}
			}
		}
		
		StringBuilder res=new StringBuilder("");
		for(int i=s.length()-1;i>=0;i--){
			char cur = s.charAt(i);
			if(freq[cur-'a']>0){
				//res=cur+res;
				res.append(cur);
				freq[cur-'a']--;
			}
		}
		
		
		System.out.println(res.reverse());
		
//		int counter=0;
//		for(int i=0;i<26;i++){
//			for(int j=0;j<s.length();j++){
//				if(s.charAt(j)==a[i]){
//					s=remove(s,j);
//					i=-1;
//					counter++;
//					if(counter==k){
//						System.out.println(s);
//						System.exit(0);
//					}
//					break;
//				}
//			}
//		}		
	}

	
	public static String remove(String s, int index){
		String first = s.substring(0,index);
		String second=s.substring(index+1);
		return first+second;
	}
}

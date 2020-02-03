package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ObtainTheString_CodeForces {


	public static int findGreaterThan(ArrayList<Integer>arr,int min){
		if(arr.get(arr.size()-1)<=min)
			return -1;
		else {
			int low=0;
			int high=arr.size()-1;
			int mid=(arr.size()-1)/2;
			while(high-low>1){
				if(arr.get(mid)<min){
					low=mid;
				}
				else if (arr.get(mid)==min){
					return arr.get(mid+1);
				}
				else{
					high=mid;
				}
				int midTemp=mid;
				mid=(high+low-1)/2;
				if(mid==midTemp)
					mid++;
			}
			if(arr.get(low)>min)
				return arr.get(low);
			else 
				return arr.get(high);
		}

	}

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int j=0;j<T;j++){
			String s = br.readLine();
			String t = br.readLine();
			if(s.equals(t))
				out.println(1);
			else{
				ArrayList<Integer>[]index = new ArrayList[26];
				for(int i=0;i<26;i++){
					index[i]=new ArrayList<Integer>();
				}
				for(int i=0;i<s.length();i++){
					char cur = s.charAt(i);
					int ind=cur-'a';
					index[ind].add(i);
				}
				int min=-1;
				long count=1;
				for(int i=0;i<t.length();i++){
					char cur = t.charAt(i);
					if(index[cur-'a'].isEmpty()){
						count=-1;
						break;
					}
					boolean cont=false;
					int x=findGreaterThan(index[cur-'a'], min);
					if(x!=-1){
						cont=true;
						min=x;
					}
					if(!cont){
						count++;
						min=index[cur-'a'].get(0);
					}
				}
				out.println(count);
			}
		}
		out.flush();
		out.close();


	}
}

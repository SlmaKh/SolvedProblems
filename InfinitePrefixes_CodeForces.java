package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class InfinitePrefixes_CodeForces {
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int j=0;j<t;j++){
			String[]r= br.readLine().split(" ");
			int n=Integer.parseInt(r[0]);
			long x=Integer.parseInt(r[1]);
			String s=br.readLine();	
			long count0=0;
			long count1=0;
			ArrayList <Integer>h = new ArrayList<Integer>();
			int n0=0;
			int n1=0;
			h.add(0);
			for(int i=0;i<s.length()-1;i++){
				if(s.charAt(i)=='0')
					n0++;
				else
					n1++;
				h.add(n0-n1);
			}
			if(s.charAt(s.length()-1)=='0')
				n0++;
			else
				n1++;
			int diff=n0-n1;
			long ans=0;
				if (diff==0){
				boolean flag=true;
				for(int l:h){
					if(l==x){
						flag=false;
					}
				}
				if(!flag)
					out.println(-1);
				if(flag)
					out.println(0);
			}
			else{
				for(int l:h){
					if(diff!=0 &&(x-l)%diff==0 && (x-l)*diff>=0){
						ans++;
					}
				}
				out.println(ans);

			}
		}
		out.flush();
		out.close();

	}
}

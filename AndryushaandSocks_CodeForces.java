package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class AndryushaandSocks_CodeForces {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1= br.readLine();
		long n = Long.parseLong(s1);
		String s = br.readLine();
		String []a = s.split(" ");
		HashSet <String >h = new HashSet<String>();
		int max=0;
		for(int i=0;i<2*n;i++){
			int size=h.size();
			if(size>max)
				max=size;
			if(!h.contains(a[i]))
				h.add(a[i]);
			else h.remove(a[i]);
		}
		System.out.println(max);
		
		
	}
}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class ColorfulGraph_CodeForces {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		String r[]=s1.split(" ");
		int n = Integer.parseInt(r[0]);
		int m = Integer.parseInt(r[1]);
		String s2=br.readLine();
		String []c=s2.split(" ");
		int []colors = new int[c.length];
		int max=0;
		for(int i=0;i<c.length;i++){
			colors[i]=Integer.parseInt(c[i]);
			if(colors[i]>max)
				max=colors[i];
		}
		TreeSet<Integer>[] neighbours=new TreeSet[max];
		for(int i=0;i<colors.length;i++){
			neighbours[colors[i]-1]=new TreeSet<Integer>();
		}
		for(int i=0;i<m;i++){
			String edge=br.readLine();
			String []e=edge.split(" ");
			int start=Integer.parseInt(e[0]);
			int end =Integer.parseInt(e[1]);
			if(colors[end-1]!=colors[start-1]){
				neighbours[colors[start-1]-1].add(colors[end-1]);
				neighbours[colors[end-1]-1].add(colors[start-1]);
			}

		}

	
		int maxi=-1;
		int color=0;
		for(int i=0;i<neighbours.length;i++){
				if(neighbours[i]!=null&&neighbours[i].size()>maxi){
					maxi=neighbours[i].size();
					color=i+1;
				}
			}
		
		System.out.println(color);


	}
}

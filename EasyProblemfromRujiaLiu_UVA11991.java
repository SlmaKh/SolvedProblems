package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EasyProblemfromRujiaLiu_UVA11991 {
	
	public static void main(String[]args) throws IOException, InterruptedException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Thread.sleep(3000);
		while(br.ready()){
		String s1 = br.readLine();
		String[] r =s1.split(" ") ;
		int n = Integer.parseInt(r[0]);
		int m=  Integer.parseInt(r[1]);
		int [] a= new int[n];
		String s2 = br.readLine();
		String r2[]=s2.split(" ");
		ArrayList[]graph = new ArrayList[1000000];
		for(int i=0;i<n;i++){
			a[i]= Integer.parseInt(r2[i]);
			int x=a[i];
			if(graph[x-1]==null){
				graph[x-1]=new ArrayList<Integer>();
			}
			graph[x-1].add(i);
		}
		for(int i=0;i<m;i++){
			String s = br.readLine();
			String []r3 = s.split(" ");
			int times=0;
			int occ= Integer.parseInt(r3[0]);
			int num= Integer.parseInt(r3[1]);
			if(graph[num-1].size()<occ){
				System.out.println(0);
			}
			else 
				System.out.println((int)graph[num-1].get(occ-1)+1);

}
		
	
		
		}
	
	}
	
}
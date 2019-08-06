package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyDearNeighbours_UVA10928 {
	public static void main(String[]args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int n = Integer.parseInt(N);
		for(int i=0;i<n;i++){
			String P = br.readLine();
			if(P.isEmpty())
				 P = br.readLine();
			int p = Integer.parseInt(P);
			String [][] arr = new String[p][p-1];
			for(int j=0;j<p;j++){
				String s= br.readLine();
				String [] r = s.split(" ");
				arr[j]=r;
			}
			ArrayList<Integer>answers = new ArrayList<Integer>();
			int min=Integer.MAX_VALUE;
			for(int j=0;j<p;j++){
				if(arr[j].length<min)
					min=arr[j].length;
			}
			for(int j=0;j<p;j++){
				if(arr[j].length==min)
					answers.add(j+1);
			}
			for(int x:answers){
				System.out.print(x);
				int index = answers.indexOf(x);
				if(index!=answers.size()-1)
				System.out.print(" ");
				
			}
			System.out.println("");
			
			
		}
		//System.out.println("");
		
	}

}

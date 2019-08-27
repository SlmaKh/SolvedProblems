	package acm;
	
	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.TreeSet;
	
	public class WhataMess_CodeForces {
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			int T  = Integer.parseInt(br.readLine());
			for(int t=0;t<T;t++){
				int n =Integer.parseInt(br.readLine());
				String []temp = br.readLine().split(" ");
				HashSet<Integer>ts = new HashSet<Integer>();
				int []freq= new int[1000000+1];
				for(int i=0;i<n;i++){
					int x = Integer.parseInt(temp[i]);
					ts.add(x);
					freq[x]++;
				}
				int count=0;
				for(int x:ts){
					int y=2;
					while(y*y<=x){
						if(x%y==0 && freq[y]>0){
							count+=(freq[y]*freq[x]);
						}
						if(x%y==0 && x/y!=y){
							int z=x/y;
							if(freq[z]>0){
								count+=(freq[z]*freq[x]);
							}
						}
						y++;
					}
					if(freq[x]>1){
						int f  = freq[x];
						f=f*(f-1);
						f/=2;
						count+=f;
					}
				}
				
				
//				for(int x:ts){	
//					int cur =x;
//					if(freq[cur]>1){
//						int f  = freq[cur];
//						f=f*(f-1);
//						f/=2;
//						count+=f;
//					}
//					for(int y:ts){	
//						if(y!=x && cur%y==0){
//							int countCur = freq[cur];
//							int countTemp = freq[y];
//							count+=(countCur*countTemp);
//						}
//					}
//				}
				out.println(count);
			}
			out.flush();
			out.close();
		}
	
	}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ParcelPosts_CodeJam {


	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			int k=Integer.parseInt(br.readLine());
			int []num=new int[k+1];
			String[]s=br.readLine().split(" ");
			for(int i=0;i<k+1;i++){
				num[i]=Integer.parseInt(s[i]);
			}
			int count=0;
			int c=0;
			int max=Integer.MAX_VALUE;
			for(int i=0;i<num.length;i++){
				boolean flag=false;
				int left=num[i];
				if(i+2>=max){
					i=max-1;
					max=Integer.MAX_VALUE;
					count++;
					flag=true;
				}
				for(int j=i+1;j<num.length&&!flag;j++){
					int mid=num[j];
					for(int l=j+1;l<num.length&&j+1<max;l++){
						int right=num[l];
						if(mid<left&&mid<right){
							if(l<max){
								max=l;
								break;
							}
						}
						else if(mid>left&&mid>right){
							if(l<max){
								max=l;
								break;
							}
						}
					}
				}
			}
			out.println("Case #"+(t+1)+": "+(count-1));
		}
		out.flush();
		out.close();
	}
}

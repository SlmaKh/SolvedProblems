package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UniformGenerator_UVA408 {
	static int [] values;
	public static int formula(int step , int mod , int x){
		if(x==0)
			return values[0]=0;
		return values[x]=(values[x-1]+step)%mod;
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//Thread.sleep(3000);
		while(br.ready()){
			String []temp = br.readLine().split(" ");
			int step = Integer.parseInt(temp[0]);
			int mod =  Integer.parseInt(temp[1]);
			boolean [] here= new boolean[mod];
			values = new int [mod+1];
			int count=0;
			for(int i=0;i<mod;i++){
				int x = formula(step,mod,i);
				if(!here[x]){
					count++;
					here[x]=true;
				}
			}
			StringBuilder s= new StringBuilder(step+"");
			if(s.length()<10){
				int x = 10-s.length();
				StringBuilder spaces = new StringBuilder("");
				while(x>0){
					spaces.append(" ");
					x--;
				}
				s=spaces.append(s);
			}
			out.print(s);
			s= new StringBuilder(mod+"");
			if(s.length()<10){
				int x = 10-s.length();
				StringBuilder spaces = new StringBuilder("");
				while(x>0){
					spaces.append(" ");
					x--;
				}
				s=spaces.append(s);
			}
			s=s.append("    ");
			out.print(s);
			 if(count==mod)
				 out.println("Good Choice"+"\n");
			 else
				 out.println("Bad Choice"+"\n");
			 
		}
		out.flush();
		out.close();
	}

}

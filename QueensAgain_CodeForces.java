package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class QueensAgain_CodeForces {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		int T  = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			HashSet<Character>chara= new HashSet<Character>();
			HashSet<Integer>num= new HashSet<Integer>();
			String []temp = br.readLine().split(" ");
			int []allnum = new int[8];
			char []allC = new char[8];
			for(int i=0;i<8;i++){
				String cur = temp[i];
				char c = cur.charAt(0);
				int n = Integer.parseInt( cur.charAt(1)+"");
				allC[i]=c;
				allnum[i]=n;
				num.add(n);
				chara.add(c);
			}
			boolean flag=true;
			if(chara.size()!=8||num.size()!=8)
				out.println("Invalid");
			else{
				for(int i=0;i<8&&flag;i++){
					int numb = allnum[i];
					char c = allC[i];
					for(int j=i+1;j<8;j++){
						int numb2=allnum[j];
						char c2=allC[j];
						if(Math.abs(numb-numb2)==Math.abs(c-c2)){
							flag=false;
							break;}
					}
				}
				if(!flag)
					out.println("Invalid");
				else
					out.println("Valid");


			}
		}
		out.flush();
		out.close();
	}
}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class DemandingDilemma_UVA11550 {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		int t = Integer.parseInt(T);
		for(int i=0;i<t;i++){
			String s= br.readLine();
			String []r = s.split(" ");
			int n = Integer.parseInt(r[0]);
			int m = Integer.parseInt(r[1]);
			boolean flag=true;
			String answer="";
			int [][]a= new int[n][m];
			for(int k=0;k<n;k++){
				String ak=br.readLine();
				String akr[]=ak.split(" ");
				for(int j=0;j<m;j++){
					a[k][j]=Integer.parseInt(akr[j]);
				}
			}
			TreeSet<String>ts= new TreeSet<String>();
			for(int j=0;j<m;j++){
				int count=0;
				String temp="";
				for(int l=0;l<n;l++){
					temp+=a[l][j];
					if(a[l][j]==1){
						count++;
					}
				}
				for(String o:ts){
					if(o.equals(temp))
						answer="No";
				}
				if(!answer.equals("No"))
					ts.add(temp);
				temp="";
				if(count!=2){
					answer="No";
					flag=false;
				}
				count=0;
			}
			if(!answer.equals("No")){
				System.out.println("Yes");
			}
			else if(ts.size()==m)
				System.out.println(answer);
			else
				System.out.println("No");
		}


	}

}


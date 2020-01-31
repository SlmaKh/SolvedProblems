package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class DisplayTheNumber_CodeForces {

	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(br.readLine());
			StringBuilder res=new StringBuilder("");
			int length=n/2;
			int rem=n%2;
			int nines=rem/3;
			rem=rem%3;
			int eights=rem/5;
			rem=rem%5;
			int sevens=rem;
			while(nines>0){
				res.append("9");
				nines--;
				length--;
			}
			while(eights>0){
				res.append("8");
				eights--;
				length--;
			}
			while(sevens>0){
				res.append("7");
				sevens--;
				length--;
			}
			while(length>0){
				res.append("1");
				length--;
			}
			out.println(res);
		}
		out.flush();
		out.close();
	}
}

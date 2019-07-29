import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class nonSquareEquation {
 
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		long x1=0;
		long x2=0;
		long x=0;
		for(int s=0;s<=90;s++) {
			/*double a=s*s;
			double b=(double)a/4.0;
			double c = b+n;
			double z =Math.sqrt(c);
			double d= (double)s/2.0;
			x=z-d;*/
			x1=(long)(-s+Math.sqrt((s*s)-(4*(-n))))/2;
			x2=(long)(-s-Math.sqrt((s*s)-(4*(-n))))/2;
			x=Math.max(x1, x2);
			if(x==(int)x&&s==function((int)x)&&((x*x+s*x)==n)) {
				System.out.println((int)x);
				return;}
		}
		System.out.println(-1);
	}
		
	public static int function(long x) {
		int total=0;
		while(x>0) {
			int s = (int) (x%10);
			total+=s;
			x=x/10;
		}
		return total;
	}
}

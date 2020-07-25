package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class BearandBigBrother_CodeForces {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String []r = br.readLine().split(" ");
		double a = Double.parseDouble(r[0]);
		double b = Double.parseDouble(r[1]);
		int res  = (int) (Math.log(b / a) / Math.log(1.5)) + 1;
		out.println(res);
		out.flush();
		out.close();
	}
}

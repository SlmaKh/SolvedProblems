package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Marcus_UVA10452 {
	
	public static boolean isValid(int i, int j , int r , int c){
		if(i >= 0 && i < r && j >=0 && j < c)
			return true;
		else
			return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String [] temp = br.readLine().split(" ");
			
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			char [][]map = new char[r][c];
			int i1 = 0;
			int j1 = 0;
			int i2 = 0;
			int j2 = 0;
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '@'){
						i1 = i;
						j1 = j;
					}
					if(map[i][j] == '#'){
						i2 = i;
						j2 = j;
					}
				}
			}
			String path = "IEHOVA#";
			int idx = 0;
			StringBuilder res = new StringBuilder();
			while( !(i1 == i2 && j1 == j2)){
				if(idx !=0 && (i1 != i2 || j1 != j2)){
					res.append(" ");
				}
				
				if(isValid(i1 - 1,  j1 , r, c) ){ // forth
					if(map[i1 - 1][j1] == path.charAt(idx)){
						i1 = i1 - 1;
						idx ++;
						res.append("forth");
						continue;
					}
				}
				
				if(isValid(i1,  j1 - 1 , r, c) ){ // left
					if(map[i1][j1 - 1] == path.charAt(idx)){
						j1 = j1 - 1;
						idx ++;
						res.append("left");
						continue;
					}
				}
				if(isValid(i1,  j1 + 1 , r, c) ){ // right
					if(map[i1][j1 + 1] == path.charAt(idx)){
						j1 = j1 + 1;
						idx ++;
						res.append("right");
						continue;
					}
				}	
				
				
				
			}	
			out.println(res);
			}
		out.flush();
		out.close();
	}

}

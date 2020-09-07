package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Battleships_UVA11953 {
	static boolean visited[][];
	static int n;
	static char [][]map; 
	
	public static boolean isValid(int i , int j){
		if(i >= 0 && i < n && j >= 0 && j < n)
			return true;
		else
			return false;
	}
	
	public static boolean floodFill(int  i, int j){
		if(!isValid(i, j) || map[i][j] == '.' || visited[i][j])
			return true;
		
		visited[i][j] = true;
		if(map[i][j] == 'x'){
			 floodFill(i - 1, j);floodFill(i + 1, j); // vertically
			 floodFill(i, j - 1); floodFill(i, j + 1); // horizontally
			return false;
		}
		else return floodFill(i - 1, j) && floodFill(i + 1, j) // vertically
				&& floodFill(i, j - 1) &&  floodFill(i, j + 1) ; // horizontally
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j);
				}
			}
		int c = 0;	
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]!= '.' && !visited[i][j]){
					if(!floodFill(i, j)){
						c++;
					}
				}
			}
		}
		out.println("Case "+ (t + 1) + ": "+c);
		}
		out.flush();
		out.close();
	}
	

}

package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GridEscape_CodeJam {

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			String []s = br.readLine().split(" ");
			int r=Integer.parseInt(s[0]);
			int c=Integer.parseInt(s[1]);
			int k=Integer.parseInt(s[2]);
			char[][]grid = new char[r][c];
			boolean[][]can = new boolean[r][c];
			if(k>r*c)
				out.println("Case #"+t+": IMPOSSIBLE");
			else if(r*c==1){
				if(k==0)
					out.println("Case #"+t+": IMPOSSIBLE");
				else if(k==1){
					out.println("Case #"+t+": POSSIBLE");
					out.println("S");
				}
			}
			else{
				boolean flag=false;
				int count=0;
				for(int rowIndex=0;rowIndex<r;rowIndex++){
					for(int colIndex=0;colIndex<c;colIndex++){
						if(count<k){
							count++;
							grid[rowIndex][colIndex]='N';
							can[rowIndex][colIndex]=true;
						}
						else{
							can[rowIndex][colIndex]=false;
							if(rowIndex==r-1){
								if(rowIndex>0&&!can[rowIndex-1][colIndex])
									grid[rowIndex][colIndex]='N';
								else if (colIndex!=c-1&&!can[rowIndex][colIndex+1])
									grid[rowIndex][colIndex]='E';
								else if (colIndex!=0 &&!can[rowIndex][colIndex-1])
									grid[rowIndex][colIndex]='W';
								else{
									out.println("Case #"+t+": IMPOSSIBLE");
									flag=true;
								}
							}
							else {
								if(!can[rowIndex+1][colIndex])
									grid[rowIndex][colIndex]='S';
								else if(rowIndex>0&&!can[rowIndex-1][colIndex])
									grid[rowIndex][colIndex]='N';
								else if (colIndex!=c-1&&!can[rowIndex][colIndex+1])
									grid[rowIndex][colIndex]='E';
								else if (colIndex!=0 &&!can[rowIndex][colIndex-1])
									grid[rowIndex][colIndex]='W';
								else{
									out.println("Case #"+t+": IMPOSSIBLE");
									flag=true;
								}
							}
						}

					}	
				}

				if(!flag){
					out.println("Case #"+t+": POSSIBLE");
					for(int i=0;i<r;i++){
						for(int j=0;j<c;j++){
							out.print(grid[i][j]);
						}
						if(t==T&&i==r-1){}
						else
							out.println();
					}
				}
			}
		}
		out.flush();
		out.close();
	}
}

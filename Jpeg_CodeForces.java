package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Jpeg_CodeForces {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			int n = Integer.parseInt(br.readLine());
			int [][] grid = new int [n][n];
			for(int i=0;i<n;i++){
				String []temp = br.readLine().split(" ");
				for(int j=0;j<n;j++){
					grid[i][j]=Integer.parseInt(temp[j]);
				}
			}
			int[][]result = new int[n][n];
			result[0][0]=grid[0][0];
			int [] visits = new int[n*n];
			int index=0;
			int row=0;
			int col=0;
			int now=0; //0 right 1 down 
			for(int i=0;i<n*n;i++){
				if(row<n && col<n && index<n*n)
					visits[index++]=grid[row][col];
				if(i%2==1){
					int rowTemp=row;
					int colTemp=col;
					int temp=row;
					row=col;
					col=temp;
					if(index!=2){
						while(rowTemp!=row && colTemp!=col){
							if(rowTemp==row && colTemp==col)
								break;
							if(rowTemp<row)
								rowTemp++;
							else
								if(rowTemp>row)
									rowTemp--;
							if(colTemp<col)
								colTemp++;
							else
								if(colTemp>col)
									colTemp--;
							if(rowTemp==row && colTemp==col)
								break;
							visits[index++]=grid[rowTemp][colTemp];
						}
					}
				}
				else {
					if(now==0){
						if(col+1<n){
							col++;
							now++;
						}
						else{
							row++;
						}
					}
					else {
						if(row+1<n){
							row++;
							now=0;
						}
						else{
							col++;
						}
					}
				}

			}
			int count=0;
			for(int i=0;i<n*n;i++){
				out.print(visits[i]);
				count++;
				if(count!=n)
					out.print(" ");
				if(count==n && i!=(n*n)-1){
					out.println();
					count=0;
				}
			}
			if(t!=T-1)
				out.println();

		}

		out.flush();
		out.close();
	}
}





/*
	System.out.println("the now is "+now);
				System.out.println("the row is "+ row +" the col is "+col);
				if(row<n && col<n){
					visits[index]=grid[row][col];
					System.out.println(visits[index]);
					index++;
				}
				if(now==0){
					if(col+1<n){
						col++;
						now=1;
					}
					else{
						row++;
					}
				}
				else
					if(now ==1){
						if(row+1<n){
							row++;
							now=2;
						}
						else
							col++;
					}
					else
						if(now==2){
								System.out.println("hereee  "+ row +"  "+ col);
								int temp=row;
								row=col;
								col=temp;
								now=0;	
								System.out.println("hereee  "+ row +"  "+ col);
						}

 */
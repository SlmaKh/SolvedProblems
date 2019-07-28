package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SerialTime_CodeForces {
	static char [][]grid;
	static int n;
	static int m;
	static int k;
	static int [] dr;//N,S,E,W,JUMP_UP,JUMP_DOWN
	static int [] dc ;
	static int count=0;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]r = br.readLine().split(" ");
		String temp=br.readLine();
		k= Integer.parseInt(r[0]);
		n= Integer.parseInt(r[1]);
		m= Integer.parseInt(r[2]);
	    dr = new int []{-1,1,0,0,-n,n};
		dc =new int[] {0,0,1,-1,0,0};
	    grid=new char [k*n][m];
			for(int i=0;i<k*n;i++){
				String s = br.readLine();
				if(!s.isEmpty()){
					for(int j=0;j<m;j++)
						grid[i][j]=s.charAt(j);
				}
				else 
					i--;
				
			}
			temp=br.readLine();
			r=br.readLine().split(" ");
			int x = Integer.parseInt(r[0]);
			int y=Integer.parseInt(r[1]);
			
			floodfill(x-1,y-1);
			System.out.println(count);
		
	}
	
	public static void floodfill(int x,int y){ //rows coloumns
		if(x>=k*n || x<0 || y>=m || y<0)
			return;
		if(grid[x][y]=='*')
			return;
		if(grid[x][y]=='#')
			return;
		grid[x][y]='*';
		count++;

		for(int i=0;i<6;i++){
			boolean go=true;
			if(((x+1)%n==0&& i==1)|| x%n==0 &&i==0)
				go=false;
			if(go)
			floodfill(x+dr[i],y+dc[i]);
		}
	}

}
 
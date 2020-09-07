package acm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TheSeasonalWar_UVA352 {
	static ArrayList<Integer> []adjList;
	static boolean []visited;
	static int [][]map;
	
	public static void countConnected(int i){
		visited[i] = true;
		for(int x : adjList[i]){
			if(!visited[x])
				countConnected(x);
		}
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder res = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int imgNum = 1;
		boolean first = true;
		//Thread.sleep(1750);
		while(br.ready()){
			if(!first){
				res.append("\n");
			}
			else
				first = false;
			int n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			int idx = 1;
			for (int i = 0; i < map.length; i++) {
				String  r = br.readLine();
				for (int j = 0; j < r.length(); j++) {
					map[i][j] = r.charAt(j) == '1' ?idx ++: 0;
				}
			}
			idx --;
			visited = new boolean [idx + 1];
			adjList = new ArrayList[n * n + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] == 0)
						continue;
					adjList[map[i][j]] = new ArrayList<Integer>();
					if(i > 0 && j > 0){
						if(map[i - 1][j - 1]!= 0)
							adjList[map[i][j]].add(map[i - 1][j - 1]);
					}
					if(i > 0){
						if(map[i - 1][j]!= 0)
							adjList[map[i][j]].add(map[i - 1][j]);
					}
					if(i > 0 && j < n - 1){
						if(map[i - 1][j + 1]!= 0)
							adjList[map[i][j]].add(map[i - 1][j + 1]);
					}
					if(j > 0){
						if(map[i][j - 1]!= 0)
							adjList[map[i][j]].add(map[i][j - 1]);
					}
					if(j < n - 1){
						if(map[i][j + 1]!= 0)
							adjList[map[i][j]].add(map[i][j + 1]);
					}
					if(i < n - 1 && j > 0){
						if(map[i + 1][j - 1]!= 0)
							adjList[map[i][j]].add(map[i + 1][j - 1]);
					}
					if(i < n - 1){
						if(map[i + 1][j]!= 0)
							adjList[map[i][j]].add(map[i + 1][j]);
					}
					if(i < n - 1 && j < n - 1){
						if(map[i + 1][j + 1]!= 0)
							adjList[map[i][j]].add(map[i + 1][j + 1]);
					}
				}
			}
			int count = 0;
			for (int i = 1; i <= idx; i++) {
				if(!visited[i]){
					countConnected(i);
					count ++;
				}
			}
			
				res.append("Image number " +  imgNum ++ + " contains " + count + " war eagles." );

			
			
		}

		out.println(res);
		out.flush();
		out.close();

	}

}

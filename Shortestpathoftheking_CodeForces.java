package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Shortestpathoftheking_CodeForces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int curX  = temp.charAt(0)-'a';
		int curY = Integer.parseInt(temp.charAt(1)+"");
		temp = br.readLine();
		int toX  = temp.charAt(0)-'a';
		int toY = Integer.parseInt(temp.charAt(1)+"");
		
		boolean there = false;
		ArrayList<String>moves = new ArrayList<String>();
		while(!there){
			if(curX==toX){
				if(curY<toY){
					while(curY!=toY){
						moves.add("U");
						curY++;
					}
				}
				else if (curY>toY){
					while(curY!=toY){
						moves.add("D");
						curY--;
					}
				}
				there=true;
				break;
			}
			if(curY==toY){
				if(curX<toX){
					while(curX!=toX){
						moves.add("R");
						curX++;
					}
				}
				else if (curX>toX){
					while(curX!=toX){
						moves.add("L");
						curX--;
					}
				}
				there=true;
				break;
			}
			String s="";
			if(curX<toX){
				curX++;
				s+="R";
			}
			else 
				if(curX>toX){
					curX--;
					s+="L";
				}
			if(curY<toY){
				curY++;
				s+="U";
			}
			else 
				if(curY>toY){
					curY--;
					s+="D";
				}
			moves.add(s);
			if(curX==toX && curY==toY){
				there=true;
				break;
			}
		}
		
		System.out.println(moves.size());
		for(String c: moves){
			System.out.println(c);
		}
	}

}

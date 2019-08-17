package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Therestreasureeverywhere_UVA587 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = br.readLine();
		int counter=0;
		while(!s.equals("END")){ // reread s 
			counter++;
			s=s.substring(0,s.length()-1);
			String [] moves = s.split(",");
			double x=0;
			double y=0;
			for(int i=0;i<moves.length;i++){
				StringBuilder num =new StringBuilder("");
				double count=0;
				StringBuilder  d=new StringBuilder("");
				String cur = moves[i];
				if(cur.length()==2){
					count=Integer.parseInt(cur.charAt(0)+"");
					num=num.append(cur.charAt(0)+"");
					d.append(cur.charAt(1)+"");
				}
				else 
				{
					for(int j=0;j<cur.length();j++){
						if(Character.isDigit(cur.charAt(j))){
							num.append(cur.charAt(j));
						}
						else{
							d.append(cur.charAt(j));
						}
					}
				}
				count=Integer.parseInt(num.toString());
				double dist=0;
				switch (d.toString()){
				case "N":y+=count;break;
				case "S":y-=count;break;
				case "W":x-=count;break;
				case "E":x+=count;break;
				case "NW":dist = Math.sqrt((count*count)/2.0); x-=dist;y+=dist;break;
				case "NE":dist = Math.sqrt((count*count)/2.0); x+=dist;y+=dist;break;
				case "SE":dist = Math.sqrt((count*count)/2.0); x+=dist;y-=dist;break;
				case "SW":dist = Math.sqrt((count*count)/2.0); x-=dist;y-=dist;break;
				}

			}
			double distance = Math.sqrt(x*x+y*y);
			out.println("Map #"+counter);
			out.printf("The treasure is located at (%.3f,%.3f).\n",x,y);
			out.printf("The distance to the treasure is %.3f.\n",distance);
			out.println();
			s=br.readLine();
		}
		out.flush();
		out.close();
	}

}

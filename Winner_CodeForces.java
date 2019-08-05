package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Winner_CodeForces {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] scores = new int [n];
		String [] names = new String [n];
		String curName [] = new String [n];
		int curScore [] = new int [n];
		for(int i=0;i<n;i++){
			String [] temp= br.readLine().split(" ");
			String name = temp[0];
			int score = Integer.parseInt(temp[1]);
			curName[i]=name;
			curScore[i]=score;
			for(int j=0;j<scores.length;j++){
				if(names[j]==null){
					scores[j]=score;
					names[j]=name;
					break;
				}
				else if (names[j].equals(name)){
					scores[j]+=score;
					break;
				}
			}
		}
		
		int max=0; 
		int maxCount=0;
		String maxPerson="";
		for(int i=0;i<scores.length;i++){
			if(scores[i]>max){
				max=scores[i];
				maxCount=1;
				maxPerson=names[i];
			}
			else if ( scores[i]==max){
				maxCount++;
			}
		}
		if (maxCount==1){
			System.out.println(maxPerson);
			System.exit(0);
		}
		else {
			String tempName []=new String [n];
			int tempScore[]= new int [n];
			for (int i=0;i<n;i++){
				String name=curName[i];
				int score=curScore[i];
				for(int j=0;j<curScore.length;j++){
					if(tempName[j]==null){
						tempScore[j]=score;
						tempName[j]=name;
						if(tempScore[j]>=max && scores[j]==max){
							//System.out.println("hereee");
							System.out.println(name);
							System.exit(0);
						}
						break;
					}
					else if (tempName[j].equals(name)){
						tempScore[j]+=score;
						if(tempScore[j]>=max&& scores[j]==max){
							System.out.println(name);
							System.exit(0);
						}
						break;
					}
					
				}
			}
		}
	}

}

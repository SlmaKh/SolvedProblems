import java.util.*;
public class Zsort {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		long []a=new long[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextLong();
		}
		long[]temp=new long[n];
		Arrays.sort(a);
	    int evenTotal=(int)Math.ceil((double)n/2);
	    int oddTotal=n-evenTotal;
		int even=0;
		int odd=(n-1)%2==0?n-2:n-1;
	    for(int j=0;j<n;j++) {
	    	if(even<n) {
	    	temp[even]=a[j];
	    	even+=2;}
	    	else
	    		if(odd>0) {
	    		temp[odd]=a[j];
	    		odd-=2;}
	    }
	    for(int k=0;k<temp.length;k++) {
	    	System.out.print(temp[k]);
	    	if(k!=n-1)
	    		System.out.print(" ");
	    }
	    System.out.println();
	}
 
}

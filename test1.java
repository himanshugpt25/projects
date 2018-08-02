

import java.util.Scanner;

public class test1 {
	    public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int t=in.nextInt();
	        int aa[] ,ba[] ,na[];
	        aa= new int [t];
	        ba=new int [t];
	        na= new int [t];
	        for(int i=0;i<t;i++){
	            aa[i] = in.nextInt();
	        ba[i] = in.nextInt();
	            na[i]= in.nextInt();
	        }
	            for(int j=0;j<t;j++)
	            {
	                int a=aa[j];
	                int b=ba[j];
	                int n=na[j];
	                int s=a;
	                for(int d=0;d<n;d++)
	                {
	                s=s+(b*(2^d));
	                System.out.print(s+" ");
	                }
	                System.out.print("\n");
	            }
	        }
	        //in.close();
	    }



	


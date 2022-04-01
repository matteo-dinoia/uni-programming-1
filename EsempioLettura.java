import java.util.*;
import java.io.*;
/*
cd "D:\Home\Documents\000-Informatica\Programmazione 1\"
javac EsempioLettura.java SavitchIn.java
java EsempioLettura

*/
class EsempioLettura{
	public static void main(String[] args){
		int max, maxI;
		int v[]=new int[50];
		final int LENGTH=v.length;
		
		System.out.println("NORMALE");
		for (int i2=0; i2<LENGTH; i2++) {
			v[i2]=(int)(Math.random()*50);
			System.out.print(v[i2]+"  ");
		}
			
		
		
		
		int count=LENGTH, t=0;
		for (int i2=0; i2<LENGTH; i2++){
			max=v[0];
			maxI=0;
			
			for (int i=0; i<count; i++){
				if(max<v[i]){
					max=v[i];
					maxI=i;
				}
				
			}
			
			//System.out.println("max="+max+":   "+maxI+":"+v[maxI]+"<->"+(count-1)+":"+v[count-1]);
			t=v[count-1];
			v[count-1]=v[maxI];
			v[maxI]=t;
			count--;
		}
		
		System.out.println("\nTRASFORMATA:");
		for (int i2=0; i2<LENGTH; i2++) 
			System.out.print(v[i2]+" ");
		
		
		
		
		//VECCHI PROGRAMMI TEST
		{			
			/*PALLA CHE RIMBALZA
			int cout=1;
			int max=1;
			while(true){
				for(int i=0; i<max/25; i++){
					System.out.print(" ");
				}
				
				if(max<1||max>70*25){
					cout*=-1;
				}
				max+=cout;
				System.out.println("|###|");
			}*/
		}
	}
}

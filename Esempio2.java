import java.util.*;
//calcola il doppio se n>=0
class Esempio2{
	/*
	public static int[] mergeSort(int a[], int b[]){
		int[] result=new int[a.length+b.length];
		int countA=0, countB=0, countRes=0;
		while(countA<a.length||countB<b.length){
			if(countA<a.length&&a[countA]<b[countB]){
				result[countRes]=a[countA];
				countA++;
			}
			else{
				result[countRes]=b[countB];
				countB++;
			}
			countRes++;
		}
		
		return result;
	}*/
	
	public static void main(String[] args){
		
		int[] x={23,3423,3,432,35,5412, 45,546,234,42343,43,65};
		orderDic(x,0,x.length-1);
		
		for(int i =0; i<x.length; i++)
			System.out.println(""+x[i]);
	}
	
	
	
	
	
	//ORDINA ESTREMI COMPRESI
	public static void orderDic(int x[], int start, int finish){
		if(start>=finish) return;
		else if(start+1==finish){
			if(x[start]>x[finish]){ //SCAMBIA ELEMENTI
				int t=x[start];
				x[start]=x[finish];
				x[finish]=t;
			}
		}
		else {
			int middle=(start+finish)/2;
			orderDic(x, start, middle);
			orderDic(x, middle+1, finish);
			mergeSort(x, start, middle, finish);
		}
	}
	
	//Start(compreso) a middle (compresi)  + middle(non compreso) a finish (compresi)  
	public static void mergeSort(int x[], int start, int middle, int finish){
		int[] fixedInput=x.clone();
		
		//MERGE
		int countA=start, countB=middle+1, countRes=start;
		
		
		while(countA<=middle||countB<=finish){
			if(countB>finish||(countA<=middle&&fixedInput[countA]<fixedInput[countB])){
				x[countRes]=fixedInput[countA];
				countA++;
			}
			else{
				x[countRes]=fixedInput[countB];
				countB++;
			}
			countRes++;
		}
	}		

	
}
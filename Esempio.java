import java.util.*;
class Esempio{
	public static int array[][];
	public static int maxN;
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		maxN=sc.nextInt();
		
		//INIZIALIZZO ARRAY
		Esempio.array=new int[maxN][3];
		for(int i=0; i<maxN; i++){
			Esempio.array[i][0]=maxN-i;
			Esempio.array[i][1]=0;
			Esempio.array[i][2]=0;
		}
		
		//INIZIO
		System.out.println("\n\n---------------------------------");
		Esempio.stampa();
		Esempio.muoviTorre(maxN, 0, 1, 2);
	}
	
	public static void muoviTorre(int numeroDischi, int partenza, int intermedio,int arrivo){
		if(numeroDischi>0){
			muoviTorre(numeroDischi-1, partenza, arrivo, intermedio);
			muoviDisco(partenza, arrivo);
			muoviTorre(numeroDischi-1, intermedio, partenza, arrivo);
		}
	}
	
	public static void muoviDisco(int partenza, int arrivo){
		
		
		//cerco y di elemento partenza 
		int ypartenza=0;
		for(int i=maxN-1; i>=0; i--){
			if(array[i][partenza]!=0){
				ypartenza=i;
				i=-1;
			}
		}
		//cerco y di elemento partenza 
		int yarrivo=0;
		for(int i=maxN-1; i>=0; i--){
			if(array[i][arrivo]!=0){
				yarrivo=i+1;
				i=-1;
			}
		}
		
		//SCAMBIO
		int t=array[ypartenza][partenza];
		array[ypartenza][partenza]=array[yarrivo][arrivo];
		array[yarrivo][arrivo]=t;
		
		//STAMPA
		stampa();
	}
	
	public static void stampa(){
		for(int piolo=0; piolo<3;piolo++){
			System.out.print("|");
			for (int i=0; i<maxN&&array[i][piolo]!=0; i++){
				System.out.print(ottieniElementoNonNullo(array[i][piolo]));	
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		
		/*
		for (int i=maxN-1; i>=0; i--){
			if(!(array[i][0]==0&&array[i][1]==0&&array[i][2]==0)){
				for(int piolo=0; piolo<3;piolo++)
					System.out.print("\t"+ottieniElementoNonNullo(array[i][piolo]));
				
				System.out.println();
			}
		}
		System.out.println("---------------------------------");
		System.out.println();*/
	}
	
	public static String ottieniElementoNonNullo(int num){
		return (num==0?"":(" "+num));
		//return (num==0?"":(""+num));
	}
	
}

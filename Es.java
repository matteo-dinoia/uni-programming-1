import java.util.*;
public class Es {
 
  /*
	public static int sommatoriaRicorsiva(){
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		if(i==0)return 0;
		return i+sommatoriaRicorsiva();
	}
	
	public static boolean trovaCarattere(String s, int counter, char car){
	
		
		if(counter>=s.length()) return false;
		if(car==s.charAt(counter))
			return true;
		
		return trovaCarattere(s,counter+1, car);
	}
	
	public static int contaCarattere(String s, int counter, char car){
		int ris=0;
		
		if(counter<s.length()){
			ris=contaCarattere(s,counter+1, car);
			if(car==s.charAt(counter)){ris+=1;}		
		}
		
		
		
		return ris;
	}

	public static void testVocali(String s){
		String vocali="aeiou";
		
		for(int i=0; i<vocali.length(); i++){
			if(trovaCarattere(s, 0, vocali.charAt(i))){
				System.out.println("Lettera '" +vocali.charAt(i)+
				"' compare "+contaCarattere(s,0,vocali.charAt(i))+"volte");
			}
		}
	}
	
	public static boolean isVocali(char c){
		String vocali="aeiou";
		boolean ris=false;
		
		if(trovaCarattere(vocali, 0, c)){
			ris=true;
		}
		return ris;
	}
	
	public static boolean palindroma(String s, int counter){
		boolean ris=false;
		
		if(counter>=s.length()){ris=true;}
		else if(s.charAt(s.length()-1-counter)!=s.charAt(counter)){ris=false;}
		else ris=palindroma (s, counter+1);
		
		return ris;
	}
	
	public static String conversioneStringa(String s, int counter){
		char c;
		String ris="";
		
		if(counter>=s.length()){}
		else {
			if(s.charAt(counter)==' ')c='-';
			else if (isVocali(s.charAt(counter))) c='*';
			else c='$';
			
			ris=c+conversioneStringa(s, counter+1);
		}
		return ris;
	}
	
	public static String inversa(String s, int counter){
		String ris="";
		
		if(counter>=s.length()){}
		else ris=inversa (s, counter+1)+s.charAt(counter);
		
		return ris;
	}
	
	//----------------------------------------------
	
	
	public static void permutazioni(String s, int counter, int max){
		if(counter<max){
			int[] nB=convertiBaseN(counter, s.length());
			stampaArray(nB);
			if(nB.length==s.length()&&!contieneRipetizioni(nB, 0)){
				System.out.println();
				stampa(nB, s,0);
			}
			
			permutazioni(s, counter+1, max);
		}	
	}
	

	
	public static int[] convertiBaseN(int numero, int base){
		int r=numero%base, q=numero/base;
		int ris[]=null;
		
		if(r!=0){
			int risOld[]=convertiBaseN(q, base);
			ris=new int[risOld.length+1];
			unisci(ris, risOld,r, 0);
			
		}
		else ris=new int[0];
		
		return ris;
		
	}
	
	public static void unisci(int ris[], int n[], int finale, int counter){
		
		
		if(counter<n.length){
			ris[counter]=n[counter];
		}
		else if(counter==n.length){
			ris[counter]=finale;
		}
			
		
	}
	
	public static int fattoriale(int numero){
		int ris=1;
		if(numero>0)
			ris=numero *fattoriale(numero-1);
		
		return ris;
	}
	
	public static int max(int numero, int base){
		int ris=1;
		if(numero>0)
			ris=numero*pow(base, numero-1) +max(numero-1, base);
		
		return ris;
	}
	
	public static int pow(int base, int numero){
		int n=1;
		if(numero>0){n=base*pow(base, numero-1);}
		
		return n;
	}
	
	
	
	
	*/
	
	public static String eliminaCar(String s, int counter, int pos){
		String ris="";
		
		if(counter>=s.length()){}
		else if(counter==pos) ris=eliminaCar (s, counter+1, pos);
		else ris=s.charAt(counter)+eliminaCar (s, counter+1, pos);
		
		return ris;
	}
	
	public static void stampa(int[] numeroBaseN, String alfabeto, int counter){
		if(counter<numeroBaseN.length){
			System.out.print(""+alfabeto.charAt(numeroBaseN[counter]));
			stampa(numeroBaseN, alfabeto, counter+1);
		}
			
	}
	
	public static boolean isInBefore(int[] nB, int numero,int counter){
		if(counter<0)return false;
		if(nB[counter]==numero) return true;
		return isInBefore(nB, numero, counter-1);
	}
	
	public static boolean contieneRipetizioni(int[] nB, int counter){
		if(counter>=nB.length)return false;
		if(isInBefore(nB, nB[counter], counter-1)) return true;
		return contieneRipetizioni(nB, counter+1);
	}
	
	public static void stampaArray(int[] nB){
		System.out.println();
		for(int i:nB){
			System.out.print(i+" ");
		}
	}
	
	//-----
	public static void main(String[] args) {
		String s=new Scanner(System.in).nextLine();
		

		permutazioni3(s, "", s.length()-1);
	 }

	public static void permutazioni2(String s, int[] counter){
		if(counter[counter.length-1]<=counter.length-1){
			
			if(!contieneRipetizioni(counter, 0)){
				System.out.println();
				stampa(counter, s,0);
			}
			
			aumenta(counter, 0);
			permutazioni2(s, counter);
		}	
	}
	public static void aumenta(int array[], int indice){
		if(indice >=array.length) System.exit(0);
		array[indice]=array[indice]+1;
		if(array[indice]>=array.length){
			array[indice]=0;
			aumenta(array, indice+1);
		}	
	}
	
	public static void permutazioni3(String text, String soluz, int indice){
		if(indice<0){
			if(text.length()==0)
				System.out.println(soluz);
			return;
		}
		permutazioni3(eliminaCar(text, 0, indice), soluz+text.charAt(indice), text.length()-1-1);
		permutazioni3(text, soluz, indice-1);
	}
	
}
	
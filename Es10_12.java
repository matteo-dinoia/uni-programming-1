public class Es10_12{

	public static void main(String[] s){

		//stampa(m);
		int[] a={-2,-1,01,2, 3, 4,5,6,7};
		System.out.println(e2(a));
	}

	public static int[][] initAlt(int[] matp, int[] matd, int numr){
		int[][] ris=new int[numr][];
		for(int i=0; i<numr; i++){
			ris[i]=clone(i%2==0?matp:matd);
		}

		return ris;
	}

	public static int[] clone(int[] ar){
		int[] ris=new int[ar.length];
		for(int i=0; i<ar.length; i++){
			ris[i]=ar[i];
		}

		return ris;
	}

	public static void stampa(int[][] matr){
		System.out.println(toString(matr));
	}

	public static int contaElementi(int[][] matr){
		int somma=0;
		for(int i=0; i<matr.length; i++){
			if(matr[i]!=null)
				somma+=matr[i].length;
		}
		return somma;
	}

	public static int[] linearizza(int[][] matr){
		if(matr==null) return null;

		int[] ris=new int[contaElementi(matr)];

		int c=0;
		for(int i=0; i<matr.length; i++){
			if(matr[i]!=null){
				for(int t: matr[i]){
					ris[c]=t;
					c++;
				}
			}
		}
		return ris;
	}

	public static String toString(int[][] matr){
		if(matr==null) return null;

		String s="";

		for(int i=0; i<matr.length; i++){
			if(matr[i]!=null){
				for(int t: matr[i]){
					s=s+"\t"+t;

				}
				s+="\n";
			}
		}
		return s;
	}

	public static int maxLen(int[][] matr){
		int max=0;
		if(matr==null)return 0;

		for(int i=0; i<matr.length; i++){
			if(matr[i]!=null&&max<matr[i].length)
				max=matr[i].length;
		}
		return max;
	}

	public static int[] sommaColonne(int[][] matr){
		int maxLen=maxLen(matr);
		int ar[]=new int[maxLen];
		for(int i=0; i<maxLen; i++)
			ar[i]=0;


		for(int i=0; i<matr.length; i++){
			for(int y=0; y<matr[i].length;y++)
				ar[y]+=matr[i][y];

		}

		return ar;
	}

	public static int[] sommaRighe(int[][] matr){
		int maxLen=matr.length;
		int ar[]=new int[maxLen];
		for(int i=0; i<maxLen; i++)
			ar[i]=0;


		for(int i=0; i<matr.length; i++){
			for(int y=0; y<matr[i].length;y++)
				ar[i]+=matr[i][y];

		}

		return ar;
	}

	public static void azzeraColonnaMax(int[][] matr){
		int[] sum=sommaColonne(matr);

		int max=0, maxId=-1;
		for(int i=0; i<sum.length; i++){
			if(max<sum[i]){
				maxId=i;
				max=sum[i];
			}
		}

		for(int i=0; i<matr.length; i++){
			if(matr[i]!=null && matr[i].length>maxId){
				matr[i]=removeEl(matr[i], maxId);
			}
		}

	}

	public static int[] removeEl(int[] ar, int id){
		int[] ris=new int[ar.length-1];
		int c=0;
		for(int i=0; i<ar.length; i++){
			if(i!=id){
				ris[c]=ar[i];
				c++;
			}
		}

		return ris;
	}

	public static boolean domMat(int[][] matr){
		boolean ris=true;
		for(int i=0; i<matr.length; i++){
			ris&=domRiga(matr[i]);
		}
		return ris;
	}

	public static boolean domRiga(int[] ar){
		boolean ris=false;
		for(int i=0; i<ar.length; i++){
			boolean div=true;
			for(int i2=0; i2<ar.length; i2++){
				div&=(ar[i2]%ar[i]==0);

			}
			ris|=div;
		}
		return ris;
	}

	public static void incrementaRic(int[][] m){ //controvariante
		incrementaRic(m, 0);
	}
	public static void incrementaRic(int[][] m, int indice){ //controvariante
		if(indice>=m.length||m==null) return;
		incrementaRigaRic(m[indice]);
		incrementaRic(m, indice+1);
	}

	public static void incrementaRigaRic(int[] ar){ //covariante
		incrementaRigaRic(ar, ar.length-1);
	}
	public static void incrementaRigaRic(int[] ar, int indice){ //covariante
		if(indice<0||ar==null) return;
		ar[indice]++;
		incrementaRigaRic(ar, indice-1);
	}

	public static int conteggioDicotomicoK(int[] ar, int k){
		return conteggioDicotomicoK(ar, k, 0, ar.length-1);
	}
	public static int conteggioDicotomicoK(int[] ar, int k, int i, int f){
		if(i>=f){
			return ar[i]==k?1:0;
		}
		int m=(i+f)/2;
		return conteggioDicotomicoK(ar, k, i,m)
			+conteggioDicotomicoK(ar, k, m+1,f);

	}

	/* ESERCIZIO 1
	 * Scrivere un metodo iterativo e1 con le seguenti caratteristiche:
	 * a) e1 ha due parametri formali con nome a e b, rispettivamente,
	 *    entrambi di tipo (reference ad) array di interi;
	 * b) e1 restituisce true se e solo se, per ogni i,
	 *    a[i] e' multiplo di almeno due elementi di b le cui posizioni
	 *    siano nell'intervallo di indici da i incluso sino al termine di b.
	 *    Quindi, e1 restituisce false nel caso la condizione descritta non
	 *    valga anche solo per un elemento di a.
	 * Si osservi che i parametri attuali possono avere lunghezze differenti,
	 * o possono non esistere. In qualsiasi caso, e1 non deve generare alcun
	 * tipo d'errore.
	 *
	 * Il metodo e1 va scritto immediatamente al di fuori di questo commento.
	 * L'aggiunta del metodo e1 deve mantenere compilabile la classe.
	 */
  public static boolean e1(int[] a, int[] b){
		if(a==null) return true;
		if(b==null||b.length<=a.length) return false;

		boolean ris=true;
		for(int i=0; i<a.length&&ris;i++){
			int multipli=0;
			for(int c=i; c<b.length;c++){
				if(b[c]%a[i]==0) multipli++;
			}
			ris&=multipli>=2;
		}

		return ris;
	}


	/*************************************************************************************************/
	/* Metodi privati che DEVONO ESSERE USATI dalla soluzione all'ESERCIZIO 2. */
	private static boolean t1(int x) {
		return x >= -1;
	}
	private static boolean t2(int x) {
		return x <= 1;
	}
	/* ESERCIZIO 2
	 * Scrivere un metodo e2 che, richiamando un metodo ricorsivo e2R,
	 * rispetti i requisiti riportati.
	 * a) e2 DEVE avere un singolo parametro formale di nome a e di tipo
	 *    reference ad un array di interi;
	 * b) e2 restituisce il valore intero ottenuto dal metodo ricorsivo
	 *    e2R applicato ad a, se a esiste. Se a non esiste, allora e2
	 *    restituisce 0.
	 * c) e2R e' un metodo ricorsvio che visita a dicotomicamente e
	 *   restituisce la somma dei valori di tutti gli elementi di a
	 *   per i quali esattamente uno tra t1 e t2 sia vero.
	 *
	 * La chiamata a e2 non deve generare alcun tipo d'errore.
	 *
	 * Il metodo e2 va scritto immediatamente al di fuori di questo commento.
	 * L'aggiunta del metodo e2 deve mantenere compilabile la classe.
	 */
	 public static int e2(int[] a){
		 if(a==null) return 0;
		 return e2r(a, 0, a.length-1);
	 }

	 public static int e2r(int[] a, int i, int f){
		if(i>=f){
			//TODO DEBUG
		//	boolean b=( t1(a[i]) && !t2(a[i]) ) || ( t2(a[i]) && !t1(a[i]) );
	//		System.out.println( t1(a[i])+" "+t2(a[i])+" "+b);

			return ( t1(a[i]) && !t2(a[i]) ) || ( t2(a[i]) && !t1(a[i]) ) ?1:0;
		}

		int m=(i+f)/2;
		System.out.println(i+" "+m+" "+f);
		return e2r(a, i, m)+e2r(a,m+1, f);
	}
}

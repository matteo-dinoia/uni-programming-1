public class Simulazione {

	public static void main2(){
		int[][] m1={{1,2},{2,1}}; //TRUE
		int[][] m2={{1,2,3},{2, 3, 1},{3,1,2}}; //true
		int[][] m3={{1,2,3},{2, 3, 1},{3,4,1}}; //true
		int[][] m4=null;
		int[][] m5=new int[0][0];

		System.out.println("true, true, false, false true\n");

		System.out.println("e1:m1->"+e1(m1));
		System.out.println("e1:m2->"+e1(m2));
		System.out.println("e1:m3->"+e1(m3));
		System.out.println("e1:m4->"+e1(m4));
		System.out.println("e1:m5->"+e1(m5));
	
		System.out.println("\ne2:m1->"+e2(m1));
		System.out.println("e2:m2->"+e2(m2));
		System.out.println("e2:m3->"+e2(m3));
		System.out.println("e2:m4->"+e2(m4));
		System.out.println("e2:m5->"+e2(m5));

	}
	/** ESERCIZIO 1.
	 * Scrivere un metodo iterativo e1 con le seguenti
	 * caratteristiche:
	 * -) e1 ha un parametro formale di tipo matrice
	 * bidimensionale di interi che puo' essere solo
	 * quadrata, o nulla.
	 * -) e1 restituisce true quando:
	 *    a) la matrice non e' nulla e
	 *    b) la somma degli elementi di ciascuna riga
	 *    concide con la somma degli elementi della
	 *    colonna corrispondente. */
	public static boolean e1(int[][] matrice){
		//C.I è quadrata o nulla
		boolean ris=true;
		if(matrice==null)ris=false;
		else{
			for(int i=0; i<matrice.length&&ris==true; i++){
				int sommaR=0, sommaC=0;
				for(int c=0; c<matrice.length; c++){
					sommaR+=matrice[i][c];
					sommaC+=matrice[c][i];
				}
				if(sommaR!=sommaC) ris=false;
			}
		}

		return ris;
	}
	/** ESERCIZIO 2.
	 * Scrivere un metodo ricorsivo dicotomico e2 con
	 * le seguenti caratteristiche:
	 * -) e2 ha un parametro formale di tipo matrice
	 * bidimensionale di interi che puo' essere solo
	 * quadrata, o nulla.
	 * -) e2 restituisce true quando:
	 *    a) la matrice non e' nulla e
	 *    b) la somma degli elementi di ciascuna riga
	 *    concide con la somma degli elementi della
	 *    colonna corrispondente.
	 * Per il calcolo della somma degli elementi in
	 * una riga, definire un metodo ricorsivo sommaR
	 * co-variante. Per il calcolo della somma degli
	 * elementi in una colonna, definire un metodo
	 * ricorsivo sommaC contro-variante.           */
	public static boolean e2(int[][] matrice){
		//C.I è quadrata o nulla
		boolean ris;

		if(matrice==null)ris=false;
		else ris=e2(matrice,0, matrice.length-1);

		return ris;
	}

	public static boolean e2(int[][] matrice, int inizio, int fine){
	 //C.I è quadrata o nulla
	 boolean ris;

	 if(inizio>=fine){
		 ris=true;
		 if(sommaC(matrice, inizio)!=sommaR(matrice, inizio)){
			 ris=false;
		 }
	 }
	 else{
		 int medio=(inizio+fine)/2;
		 ris=e2(matrice, inizio, medio)&&e2(matrice,medio+1, fine);
	 }

	 return ris;
 }


	public static int sommaC(int[][] matrice, int colonna){
		return sommaC(matrice, colonna, 0);
	}
	public static int sommaC(int[][] matrice, int colonna, int c){
		//controvariante
		int ris=0;

		if(c<matrice.length)
			ris=matrice[colonna][c] + sommaC(matrice, colonna, c+1);

		return ris;
	}

	public static int sommaR(int[][] matrice, int riga){
		return sommaR(matrice, riga, matrice.length-1);
	}
	public static int sommaR(int[][] matrice, int riga, int c){
		//variante
		int ris=0;

		if(c>=0)ris=matrice[c][riga] + sommaR(matrice, riga, c-1);
		return ris;
	}








	/** ESERCIZIO 3.
     * Siano dati:
     * -) il metodo parity, qui sotto definito,
     * da applicare esclusivamente ad un parametro
     * attuale con almeno un elemento (a.length>=1)
     * -) il predicato P(i) seguente:
     *
     *  "Alla sua uscita, parity(a,i) rende vero
     *    'per ogni k.se 0<= k <= i, \
     *                allora a[k]==(k%2==0)' ".
     *
     * 1) Scrivere il predicato P(0).
		 			* P(0): a[0]=true=(0%2==0)
					* MEGLIO
					* "Alla sua uscita, parity(a,0) rende vero
		      *    'per ogni k.se 0<= k <= 0 (k=0), \
		      *                allora a[0]==(k%2==0)' ".
     * 2) Scrivere il predicato P(i-1) ==> P(i).
		 			*P(i-1)=a[0]=0%2&&...&&a[i-1]=(i-1)%2
					*       =>P(i) a[i]=a[0]=0%2&&...&&a[i-1]=(i-1)%2&&a[i]=(i%2==0)
          * MEGLIO
					* "Alla sua uscita, parity(a,i-1) rende vero 'per ogni k.se 0<=k<=i-1, allora a[k]==(k%2==0)'"
                                            ==>
          * "Alla sua uscita, parity(a,i) rende vero 'per ogni k.se 0<=k<=i, allora a[k]==(k%2==0)'"

     * 3) Dimostrare che P(0) e' vero.
		 			* +termina in quanto i'<i e quando i=0 esce
		 			*P(0) è vera perchè se (i=0   => a[i]=TRUE) => a[0]=true cvd
     * 4) Dimostrare che P(i-1) ==> P(i) e' vero,
		 			*Alla riga (A) setto in array a[i-1]
					* nella riga (B) setto a[i]=\neg a[i-1]  il che vale in quanto:
					*  CASO 1: se i-1 è pari allora i-1=2n =>  i=2n+1 quindi dispari
					* CASO 2: se i-1 è dispari i-1=2n+1   => i=2n+2=2(n+1) quindi pari
							* quindi in entrambi i casi
							*  a[i]%2=!a[i-1]%2  (in quanto uno pari e l'altro dispari)
							* inoltre vale P(i-1) ovvero a[0]=0%2&&...&&a[i-1]=(i-1)%2
							* quindi vale a[0]=0%2&&...&&a[i-1]=(i-1)%2&&a[i]=k%2
									* il che è equivalente a P(i-1)
     * ragionando induttivamente.                */
	static void parity(boolean[] a, int i) {
		if (i < a.length) {
			if (i == 0)
				a[i] = true; //(C)
			else {
				parity(a, i - 1); //(A)
				a[i] = !a[i - 1]; //(B)
			}
		}
	}













	/** ESERCIZIO 4. Disegnare lo stato della
	 * memoria immediatamente prima della
	 * disallocazione del record di attivazione
	 * del metodo stack, quando i ha valore 2. */
	static void stack(int[][] x, int i) {
		if (i < x.length) {
			int[] l = new int[x[i].length];  //nuova lista di 2 elementi
			l[i] = x[i][i] + 1;            //l[i]=x(i,i) +1
			x[i] = l;                     //x[i]=l
			stack(x, i + 1); // (B)
		}
	}

	public static void main(String[] args) {
		main2();
		int[][] y = {{0,0}, {0,0}};
		stack(y, 0); // (A)
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				System.out.print(" "+y[i][j]);
			}
			System.out.println();
		}
	}

}

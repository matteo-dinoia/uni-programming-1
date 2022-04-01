
// Esercizio: Scambio di variabili all'interno del metodo main
// utilizzando delle variabili di supporto
public class ScambioVariabili {

    /* main è il metodo principale, che avvia il programma. 
     * Serve alla macchina virtuale, cioè al comando java per 
     * iniziare l'esecuzione del codice Java 
     * nel file ScambioVariabili.class */
    public static void main(String[] args) {
		/*
        boolean x = true;  // RICORDA: il ';' separa due istruzioni in sequenza
        boolean y = true;
        System.out.println("Prima dello scambio: x = " + x + ", y = " + y);
		
		//Per numeri
		
        //x+=y;
		//y=x-y;
		//x-=y;
        if(x!=y){
			x=!x;
			y=!y;
		}
		
        System.out.println("Dopo lo scambio:     x = " + x + ", y = " + y);
*/

		Integer v[]={1,2,3,4};
		System.out.println(""+v[0]+" "+v[1]+" "+v[2]+" "+v[3]);
		
		ScambioVariabili.scambio(v, 0, 1);
		ScambioVariabili.scambio(v, 1, 2);
		ScambioVariabili.scambio(v, 2, 3);
		
		
		System.out.println(""+v[0]+" "+v[1]+" "+v[2]+" "+v[3]);
		
    } // fine del main
	
	public static void scambio(Integer[] x, int i, int j){
		x[i]+=x[j];
		x[j]=x[i]-x[j];
		x[i]-=x[j];
	}
		
    
} // fine della classe

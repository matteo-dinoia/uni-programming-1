
/** Massimo tra due variabili */
public class MassimoDueVariabili {

    public static void main(String[] args) {
        // Massimo tra x1 e y1 
        // Dopo il test la variabile max contiene il massimo tra x1 e y1
		
        int x1 = SavitchIn.readLineInt();
        int y1 = SavitchIn.readLineInt();
		int x2 = SavitchIn.readLineInt();
        int y2 = SavitchIn.readLineInt();
        int max;
        if (x1 > y1) { // se x1 > y1 vero
            max = x1;
        } else { // se x1 > y1 falso
            max = y1;
        }
        System.out.println("x1: " + x1 + ", y1: " + y1 + ", max: " + max);
        
        
        // Secondo modo: assegnamo un valore iniziale a max pari a y1, e
        // cambiamo max nel caso in cui x1 fosse maggiore di y1
        max = y1;
        if (x1 > y1) { // se x1 > y1 vero
            max = x1;
        }
        System.out.println("x1: " + x1 + ", y1: " + y1 + ", max: " + max);

        
        // Massimo tra x2 e y2, con indicatore 
        // La variabile indiceMax conterrà 0 se il massimo è in x2, ed 1 se è in y2
       
        int indiceMax = 0;
        if (y2 > x2) { // se x2 > y2 vero
            indiceMax = 1;
        }
        System.out.println("x2: " + x2 + ", y2: " + y2 + ", indiceMax: " + indiceMax);
        
        
        // Versione con indicatore booleano

        boolean y2IsMax = true; // indica che il massimo è in y2
        if (x2 > y2) { // se x2 > y2 vero
            y2IsMax = false;
        }
        System.out.println("x2: " + x2 + ", y2: " + y2 + ", y2IsMax: " + y2IsMax);

        
        
        // ESERCIZIO: stampare il massimo tra x2 e y2, usando il valore di y2IsMax 
        // per decidere quale variabile stampare.
  
        y2IsMax = true; // indica che il massimo è in y2
        if (x2 > y2) { // se x2 > y2 vero
            y2IsMax = false;
        }
        System.out.println("x2: " + x2 + ", y2: " + y2 + ", y2IsMax: " + (y2IsMax?y2:x2));
        
        // ESERCIZIO: modificare il codice della classe per chiedere all'inizio 
        // una coppia di valori x e y, e sostituire tutti i valori pre-assegnati 
        // per x1,y1 e x2,y2 con questi due nuovi valori x e y.
    }
}

public class SimulazioneEsame10_1{
  public static void main(String[] arg){
    int[] c={1,2,3,4,5,7,8};
    System.out.println(testNR(c));

  }

  //Numero interi pari è pari in segmento
  //c.I. c|=null e i<=lenght
  public static boolean testR(int[] c){
    return testR(c, 0);
  }
  //all'uscita a[i...a.length-1] è pari
  //invariante ris=(numperoPari%2==0);
  public static boolean testR(int[] c, int i){
    //TODO trovo invariante
    boolean ris;
    if(i>=c.length) ris=true;
    else{
      ris=testR(c, i+1);
      if(c[i]%2==0) ris=!ris;
    }

    return ris;
  }
  /*Caso Base: i==a.length
        in a[a.length...a.length-1] ci sono zero eleemtni
        e quindi 0 elementi pari
        => in uqesto caso testR(a.length, a.length-1) ritorna
           correttamente TRUE

    Caso induttivo:
      * se pari(hp): la chiamata superiore restituisce false
          * se pari (numero): il numero di pari aumenta e diventa dispari
              * ris'=!ris (da pari diventa dispari)
          * Se dispari(numero): il numero rimane uguale
      * se dispari(hp):  la chiamata superiore restituisce true 
        * se pari (numero):
        * se pari (numero): il numero di pari aumenta e diventa pari
            * ris'=!ris  (da dispari diventa pari)
        * Se dispari(numero): il numero rimane uguale
  */

  public static boolean testNR(int[] c){
    boolean ris=true;   //in partenza con S={} il numero di pari è 0=>pari
    for(int i=0; i<c.length; i++){
      if(c[i]%2==0) ris=!ris;  //ris=true se numero pari=2n
              //per ogni
    }

    return ris;
  }

}

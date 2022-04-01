import java.util.*;
public class Dicotomico {
  public static void main (String arg[]){
    int[] ar={2,3242, 344, 434 , 344, 434 , 4331, 768};
    System.out.println(tuttiPariDicotomica(ar));
  }

  public static boolean tuttiPariDicotomica(int ar[]){
    return tuttiPariDicotomica(ar, 0, ar.length-1);
  }

  public static boolean tuttiPariDicotomica(int a[], int iniz, int fine){
    if(iniz<fine){ //Ha almeno 2 elementi compresi
      return tuttiPariDicotomica(a, iniz, (iniz+fine)/2)
                &&  tuttiPariDicotomica(a, (iniz+fine)/2+1,fine);
    }
    else if(a[iniz]%2==0){
      return true;
    }
    else {
      return false;
    }
  }

}

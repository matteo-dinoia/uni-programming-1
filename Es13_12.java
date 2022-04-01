public class Es13_12{
  public static void main(String[] args){
    int[] a={1,2, 43, 5, 2, 5, 7,8,9,10, 12, 14, 1, 2, 3};
    System.out.println("\n"+ maxLunghezzaConsecutivi(a));

  }

  public static int maxLunghezzaConsecutivi(int[] ar){
    int c=0, max=0;
    for (int i=0; i<ar.length; i++){
      if(ar[i]%2==0 &&(c==0||ar[i]==ar[i-1]+2))
        c++;
      else{
        if(c>max) max=c;
        c=0;
      }
    //  System.out.println(""+c);
    }
    return max;
  }


}

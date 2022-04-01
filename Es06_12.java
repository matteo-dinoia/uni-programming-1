import java.util.*;

public class Es06_12{

    public static void main(String[] args) {
        int[] a={3, 4, 1, 5, 6, 2, 9};
        insertionSort(a);
    }

    public static void insertionSort(int[] a){
      int j, v;
      for (int i=1; i<a.length; i++){
        v=a[i];

        j=i-1;
        while(j>=0&&a[j]>v){
          a[j+1]=a[j];
          j--;
        }

        a[j+1]=v;  //obb
      }
    }

    public static void bubbleSort(int[] a, int c){
      if(c<0) return;
      bolli(a, c, 0);
      bubbleSort(a, c-1);
    }
    public static void bubbleSort(int[] a){
      bubbleSort(a, a.length-1);
    }
    public static void bolli(int[] a, int max, int c){
      if(c+1>=max) return;

      if(a[c]>a[c+1]){ //scambio
        int t=a[c];
        a[c]=a[c+1];
        a[c+1]=t;
      }

      bolli(a, max, c+1);
    }
}

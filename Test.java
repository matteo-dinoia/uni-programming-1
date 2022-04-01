import java.util.*;
import static java.lang.System.*;
public class Test{
	public static void main(String[] args){
		/*int letto;
		boolean dis=true, pari=true;
		Scanner sc=new Scanner(System.in);
		
		
		letto=sc.nextInt();
		if(letto==0){
		System.out.println("VUOTO");}
		
		do{
			if(letto%2==0){
				dis=false;
			}
			else{
				pari=false;
			}
				
			letto=sc.nextInt();
		}while(letto!=0);

		if(pari){
			System.out.println("p");
		}
		else if (dis){
			System.out.println("d");
		}
		else{
			System.out.println("n");
		}*/
		Scanner sc=new Scanner(System.in);
		
		int larghezza =sc.nextInt();
		
		for (int i=0; i<larghezza*larghezza; i++){
			int x=i/larghezza;
			int y=i%larghezza;
			if(x==y){
				out.print("\\");
			}
			else if(x>y) out.print("*");
			else out.print(":");
			
			if(y==larghezza-1)
			out.println("");
		}
		
			
	}
	
	
	
}
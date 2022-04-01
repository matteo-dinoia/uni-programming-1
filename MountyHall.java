import java.util.*;
//calcola il doppio se n>=0
class MountyHall{
	public static final int m[][][]={{{1,2},{2,2},{1,1}},{{2,2},{0,2},{0,0}},{{1,1},{0,0},{0,1}}};
	
	public static void main(String[] args){
		//MASSIMO VOLTE
		Scanner sc=new Scanner(System.in);
		int max=sc.nextInt(), cV=0;
		
		
		for(int i=0; i<max; i++){
			int S=getRandom(3),P=getRandom(3),random=getRandom(2);
			
			cV+=m[m[S][P][random]][S][0]==P?1:0;
		}
		
		System.out.println(cV+" out of "+max);
		
	}
	
	public static int getRandom(int max){
		return (int)(Math.random()*max);
	}


	
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		   ArrayList<Integer> list3= new ArrayList<Integer>();
		   ArrayList<String> list4= new ArrayList<String>();
		   ArrayList<String> list5= new ArrayList<String>();
		Scanner scan =new Scanner(System.in);
		String group;
		group=scan.nextLine();
		for(int num=0;num<Integer.valueOf(group);num++){
			list4.add(scan.nextLine());
			list5.add(scan.nextLine());
		}
		for(int numOfCut=0;numOfCut<Integer.valueOf(group);numOfCut++){
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 String []str =list4.get(numOfCut).split(" ");
			 String []str1=list5.get(numOfCut).split(" ");
			 for(String indexOfStr :str1){
				 list.add(Integer.valueOf(indexOfStr));
			 }
			 list=sort(list);
			 int []a=new int[list.size()-1];
			 for(int i=0;i<list.size()-1;i++)
			    {
			    	a[i]=list.get(i);
			     }
			 list2.add(makeChange(a,a.length,Integer.valueOf(str[1])));
		}
		 for(int i=0;i<list2.size();i++){
			    System.out.println(list2.get(i));
			   }
	}

	 private static ArrayList<Integer> sort(ArrayList<Integer> list) {
			// TODO Auto-generated method stub
			   Collections.reverse(list);
		     return list;
		}
		   public static int makeChange(int[] values, int valueKinds, int money )
		   {  
			   
			   int[] coinsUsed = new int[money+1]; 
		       coinsUsed[0] = 0;  
		       // 对每一分钱都找零，即保存子问题的解以备用，即填表  


		       for (int cents = 1; cents <= money; cents++) {  
		           // 当用最小币值的硬币找零时，所需硬币数量最多  
		           int minCoins = cents;  
		           // 遍历每一种面值的硬币，看是否可作为找零的其中之一  
		           for (int kind = 0; kind < valueKinds; kind++) {               
		               // 若当前面值的硬币小于当前的cents则分解问题并查表  
		               if (values[kind] <= cents) {  
		                   int temp = coinsUsed[cents - values[kind]] + 1;  
		                   if (temp < minCoins) {  
		                       minCoins = temp;   
		                   }  
		               }  
		           }  
		           // 保存最小硬币数  
		           coinsUsed[cents] = minCoins;
		       }  
		       return (coinsUsed[money]); 
		   }  
}

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
		       // ��ÿһ��Ǯ�����㣬������������Ľ��Ա��ã������  


		       for (int cents = 1; cents <= money; cents++) {  
		           // ������С��ֵ��Ӳ������ʱ������Ӳ���������  
		           int minCoins = cents;  
		           // ����ÿһ����ֵ��Ӳ�ң����Ƿ����Ϊ���������֮һ  
		           for (int kind = 0; kind < valueKinds; kind++) {               
		               // ����ǰ��ֵ��Ӳ��С�ڵ�ǰ��cents��ֽ����Ⲣ���  
		               if (values[kind] <= cents) {  
		                   int temp = coinsUsed[cents - values[kind]] + 1;  
		                   if (temp < minCoins) {  
		                       minCoins = temp;   
		                   }  
		               }  
		           }  
		           // ������СӲ����  
		           coinsUsed[cents] = minCoins;
		       }  
		       return (coinsUsed[money]); 
		   }  
}

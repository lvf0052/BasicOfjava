import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class changeMoney {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	String group;
	group = scan.nextLine();
	ArrayList<String> numAndMoney= new ArrayList<String>();
	ArrayList<String> typeOfMoney= new ArrayList<String>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	ArrayList<Integer> get = new ArrayList<Integer>();
	ArrayList<Integer> output = new ArrayList<Integer>();
	for(int num1=0;num1<Integer.valueOf(group) ;num1++){
		numAndMoney.add(scan.nextLine());
		typeOfMoney.add(scan.nextLine());
		}
	for(int num=0;num<Integer.valueOf(group);num++){
		list.clear();
		String []nAm =numAndMoney.get(num).split(" ");
		String []tYm =typeOfMoney.get(num).split(" ");
		for(String indexOfnAm : tYm){
			list.add(Integer.valueOf(indexOfnAm));
		}
		list=sort(list);
		int []number=new int[list.size()-1];
				for(int i=0;i<list.size()-1;i++)
			    {
					number[i]=list.get(i);
			    }
		output.add(makeChange(number,number.length,Integer.valueOf(nAm[1])));
	}

	 for(int i=0;i<output.size();i++){
		    System.out.println(output.get(i));
		   }
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


private static ArrayList<Integer> sort(ArrayList<Integer> list) {
	// TODO Auto-generated method stub
	Collections.reverse(list);
	return list;
}
}

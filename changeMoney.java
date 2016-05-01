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


private static ArrayList<Integer> sort(ArrayList<Integer> list) {
	// TODO Auto-generated method stub
	Collections.reverse(list);
	return list;
}
}

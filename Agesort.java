import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Agesort {
	public static void main(String[] args) {
		int num = 0;
		int a = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<String> list1 = new ArrayList<String>();
		while (1 == 1) {
			num = scan.nextInt();
			if (num == 0) {
				break;
			}
			for (int temp = 0; temp < Integer.valueOf(num); temp++) {
				list.add(scan.nextInt());
			}
			Collections.sort(list);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		list1.add(sb.toString());
		list.removeAll(list);
		}
		  for(int i=0;i<list1.size();i++)
	       {
	    	   System.out.println(list1.get(i));    	   
	       }
	}
}

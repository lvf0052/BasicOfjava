import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
public class BigExp {
	public static void main(String[] args) {
		int input = 0 ;
		Scanner scan =new Scanner(System.in);
		input = scan.nextInt();
		int [][]arr =new int[input][2];
		for(int row=0;row<input;row++){
			for(int column=0;column<2;column++){
				arr[row][column] = scan.nextInt();
			}
			}
		for(int temp=0;temp<input;temp++){
			String tempr=big(arr[temp][0]).toString();
			String tempc=big(arr[temp][1]).toString();
			BigInteger a=new BigInteger(tempr);
			BigInteger b=new BigInteger(tempc);
			BigInteger c=a.add(b);
			System.out.print(c.toString()+"\r\n");
		}
	}
	public static StringBuffer big(int n){
		final int size=2000;
		int res[]=new int[size+1];
		int i;
		for( i = 0;i < size;++ i){
			res[i] = 0;
		}
		res[0] = 1;
		while(n > 0){
			for(i = 0;i < size;++ i){
				res[i] *= 2;
			}
			for(i = 0;i < size;++ i){
				if(res[i] > 9){
					res[i + 1] += res[i] / 10;
					res[i] %= 10;
				}
			}
			n --;
		}
		boolean bl = false;
		StringBuffer bf = new StringBuffer();
		for(i = size;i >= 0;-- i){
			if(res[i] != 0 || bl){
				bf.append(res[i]);
				bl = true;
			}
			
		}
		return bf;
		
	}
}
import java.util.ArrayList;
import java.util.Scanner;

public class countOfNum {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int output=0;
		Scanner scan = new Scanner(System.in);
		int group = Integer.valueOf(scan.nextLine());
		for (int temp = 0; temp < group; temp++) {
			String line = scan.nextLine();
			String[] str = line.split(" ");
			output=count(str);
			System.out.println(output);
		}

	}

	private static int count(String[] str) {
		// TODO Auto-generated method stub
		int bianchang = Integer.valueOf(str[0]);
		int numOfRec = Integer.valueOf(str[1]);
		int[][] num = new int[bianchang][bianchang];
		int[] shunxu =new int[2];
		
		int m = 0;
		if (bianchang % 2 == 0) {
			m = bianchang;
		} else {
			m = bianchang / 2 + 1;
		}
		for (int i = 0; i < m; i++) {
			for (int j = i; j < bianchang - i; j++) {
				num[i][j] = i + 1;
			}
			for (int j = i + 1; j < bianchang - i; j++) {
				num[j][bianchang - i - 1] = i + 1;
			}
			for (int j = bianchang - i - 2; j >= i; j--) {
				num[bianchang - i - 1][j] = i + 1;
			}
			for (int j = bianchang - i - 2; j >= i + 1; j--) {
				num[j][i] = i + 1;
			}
		}
		shunxu=print(bianchang,numOfRec);
		int a=shunxu[0];
		int b=shunxu[1];
		return num[a][b];
		
		
	}

	private static int[] print(int n,int numOfRec) {
		// TODO Auto-generated method stub
		 int [][] data =new int [n][n];
	        data [0][0]=1;
	        data [n-1][n-1]=n*n;
	 
	        //�����ξ��������Խ��߷�Ϊ�ϰ벿�ֺ��°벿��
	        //������������ϰ벿�֣����Ҹ���Խ��ߣ��ϰ벿�ֿɽ�б�ߵ�˳���Ϊk,��k����ż�Խ����ж�
	        for (int k = 1; k <=(n-1); k++) {
	            if (k%2!=1){//��kΪ��������ż����ʱ������ÿ��б�ߵ���Сֵ���Ϸ�
	                data[0][k]=1+k*(k+1)/2;
	                for (int i = 1; i <= k; i++) {
	                    data[i][k-i]=data[0][k]+i;//�е������еݼ� 
	                }
	            }else{//��k������Ϊ����ʱ������ÿ��б�ߵ���Сֵ���·�
	                data[k][0]=1+k*(k+1)/2;
	                for (int i = 0; i <=k; i++) {
	                    data[k-i][i] =data[k][0]+i;              //�еݼ����е���           
	                }
	            }   
	        }//�ϰ벿�־��Ѿ���ƺ��ˣ���������°벿��
	         
	        //�°벿�־ͻ��ԵñȽϸ��ӣ�����Ҫ���ж�n����ż�ԣ���Ҫ���ж�k����ż��
	        //�������Ұ��մӴ�С��˳�����б�ߵ����ӣ�ͬ����k����б�ߵ����
	        if(n%2==0){//���nΪż��
	            for(int k=1;k<=(n-2);k++){
	                if(k%2==1){//��kΪ������ʱ��ÿ��б�ߵ����ֵ���Ϸ�
	                    data[k][n-1]=  data[n-1][n-1] - (n - k - 1) * (n - k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[k+i][n-1-i]=data[k][n-1]-i;//�е������еݼ�
	                    }
	                }else{//��kΪż����ʱ��ÿ��б�ߵ����ֵ���·�
	                    data[n-1][k]=data[n-1][n-1]-(n-k-1)*(n-k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[n-1-i][k+i]=data[n-1][k]-i;//�еݼ����е���
	                    }
	                }
	            }
	        }else{//���nΪ��������ô�����෴��
	            for(int k=1;k<=(n-2);k++){
	                if(k%2==0){//��kΪż����ʱ��ÿ��б�ߵ����ֵ���Ϸ�
	                    data[k][n-1]=  data[n-1][n-1] - (n - k - 1) * (n - k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[k+i][n-1-i]=data[k][n-1]-i;//�е������еݼ�
	                    }
	                }else{//��kΪ������ʱ��ÿ��б�ߵ����ֵ���·�
	                    data[n-1][k]=data[n-1][n-1]-(n-k-1)*(n-k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[n-1-i][k+i]=data[n-1][k]-i;//�еݼ����е���
	                    }
	                }
	            }
	        }//�°벿�ֵľ���ƺ���
	        int []index =new int[2];
	        for(int temp=0;temp<n;temp++){
	        	for(int temp01=0;temp01<n;temp01++){
	        		int tempofdata =0;
	        		tempofdata=data[temp][temp01];
	        		if(numOfRec == tempofdata){
	        			index[0]=temp;
	        			index[1]=temp01;
	        			break;
	        		}
	        	}
	        }
	        return index;
	        }
}

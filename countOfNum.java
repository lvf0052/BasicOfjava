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
	 
	        //将蛇形矩阵按照正对角线分为上半部分和下半部分
	        //现在先来设计上半部分，并且负责对角线，上半部分可将斜线的顺序记为k,按k的奇偶性进行判断
	        for (int k = 1; k <=(n-1); k++) {
	            if (k%2!=1){//当k为！！！！偶数数时，代表每条斜线的最小值在上方
	                data[0][k]=1+k*(k+1)/2;
	                for (int i = 1; i <= k; i++) {
	                    data[i][k-i]=data[0][k]+i;//行递增，列递减 
	                }
	            }else{//当k！！！为奇数时，代表每条斜线的最小值在下方
	                data[k][0]=1+k*(k+1)/2;
	                for (int i = 0; i <=k; i++) {
	                    data[k-i][i] =data[k][0]+i;              //行递减，列递增           
	                }
	            }   
	        }//上半部分就已经设计好了，接着设计下半部分
	         
	        //下半部分就会显得比较复杂，首先要先判断n的奇偶性，还要再判断k的奇偶性
	        //从左向右按照从大到小的顺序进行斜线的连接，同样以k代表斜线的序号
	        if(n%2==0){//如果n为偶数
	            for(int k=1;k<=(n-2);k++){
	                if(k%2==1){//当k为奇数的时候每条斜线的最大值在上方
	                    data[k][n-1]=  data[n-1][n-1] - (n - k - 1) * (n - k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[k+i][n-1-i]=data[k][n-1]-i;//行递增，列递减
	                    }
	                }else{//当k为偶数的时候，每条斜线的最大值在下方
	                    data[n-1][k]=data[n-1][n-1]-(n-k-1)*(n-k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[n-1-i][k+i]=data[n-1][k]-i;//行递减，列递增
	                    }
	                }
	            }
	        }else{//如果n为奇数，那么就是相反的
	            for(int k=1;k<=(n-2);k++){
	                if(k%2==0){//当k为偶数的时候每条斜线的最大值在上方
	                    data[k][n-1]=  data[n-1][n-1] - (n - k - 1) * (n - k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[k+i][n-1-i]=data[k][n-1]-i;//行递增，列递减
	                    }
	                }else{//当k为奇数的时候，每条斜线的最大值在下方
	                    data[n-1][k]=data[n-1][n-1]-(n-k-1)*(n-k)/2;
	                    for(int i=1;i<n-k;i++){
	                        data[n-1-i][k+i]=data[n-1][k]-i;//行递减，列递增
	                    }
	                }
	            }
	        }//下半部分的就设计好了
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

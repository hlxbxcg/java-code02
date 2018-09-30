package com.hlx07.two;

public class RunJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					if(i!=j&&i!=k&&j!=k&&i!=0){
						cnt++;
						System.out.println(i*100+j*10+k);
				}
			}
		}
      
	}
		System.out.println("cnt="+cnt);
	}
}



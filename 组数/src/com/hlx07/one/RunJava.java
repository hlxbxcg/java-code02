package com.hlx07.one;

public class RunJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int cnt = 0;//百位i
		for (int i = 0; i < 4; i++) {
			//十位j
			for (int j = 0; j < 4; j++) {
				//个位k
				for (int k = 0; k < 4; k++) {
					if (i != j && j != k && i != k&&i!=0 ) {
						cnt++;
						System.out.println(i*100+j*10+k);
					}
				}
			}
		}
		
		System.out.println("cnt = "+cnt);
	}



	}



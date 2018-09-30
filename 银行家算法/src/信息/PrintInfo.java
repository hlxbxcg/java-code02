package 信息;

import java.util.List;

/**
 * 输出信息
 */
public class PrintInfo {
	
	public static void printChart(List<int[]> maxList, List<int[]> allcationList, List<int[]> needList, int[] available) {
		
		for (int i = 0; i < maxList.size(); i++) {
			int[] temp1 = maxList.get(i);
			int[] temp2 = allcationList.get(i);
			int[] temp3 = needList.get(i);
			
			System.out.print("P" + i + "\t");		// 输出进程号
			for (int j : temp1) {
				System.out.print(j + "\t");
			}
			for (int j : temp2) {
				System.out.print(j + "\t");
			}
			for (int j : temp3) {
				System.out.print(j + "\t");
			}
			
			// 第一行
			if (i == 0) {
				for (int j : available) {
					System.out.print(j + "\t");
				}
			}
			
			System.out.println();		// 换行
		}
	}
}























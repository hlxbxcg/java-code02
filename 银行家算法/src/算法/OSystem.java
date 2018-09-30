package 算法;

import java.util.List;

/**
 * 系统类
 *
 */
public class OSystem {
	/**
	 * 判断进程是否安全，并返回安全序列
	 * @param maxList
	 * @param allcationList
	 * @param needList
	 * @param available
	 * @return
	 */
	public String[] judjeProcess(List<int[]> maxList, List<int[]> allcationList, List<int[]> needList, int[] available) {
		int proNum = maxList.size();					// 线程个数
		String[] sequence = null;						// 安全序列
		int[] can = new int[proNum];				// 标记符合规范的序列
		
		/* 第一遍，找到符合预分配规范的进程 */
		for (int i = 0; i < proNum; i++) {
			int[] temp1 = maxList.get(i);
			int[] temp2 = allcationList.get(i);
			int[] temp3 = needList.get(i);
			
			/* 判断是否满足预分配 */
			boolean flagTemp = true;					// 标记是否满足
			for (int j = 0; j < temp3.length; j++) {
				if ((temp3[j] > available[j]) || (temp3[j] + temp2[j] > temp1[j])) {
					// 需求大于提供 或者  需求+现有大于总需求
					flagTemp = false;
					break;
				}
			}
			
			// 将满足条件的与分配线程标记出来
			if (flagTemp) {
				can[i] = 1;		// 满足条件的标记为1
			}
		}
		
		/* 第二遍，开始寻找满足的序列 */
		for (int i = 0; i < can.length; i++) {
			// 从满足条件的里面开始找，遍历所有满足条件的
			if (can[i] == 0) {
				// 不是满足条件的
				continue;
			}
			
			/* 创建临时变量 */
			int[] tempAvailable = new int[available.length];
			for (int j = 0; j < tempAvailable.length; j++) {
				tempAvailable[j] = available[i];
			}
			
			int[] temp1 = maxList.get(i);
			int[] temp2 = allcationList.get(i);
			int[] temp3 = needList.get(i);
			
			/* 开始寻找安全序列 */
			int[] flag = new int[proNum];						// 标记是否满足条件
			String[] sequenceTemp = new String[proNum];			// 临时安全序列
			boolean flagTemp = true;							// 初始为可以回收
			for (int j = 0; j < temp3.length; j++) {
				if (temp2[j] + temp3[j] != temp1[j]) {
					// 分配后不能回收
					flagTemp = false;
				}
			}
			if (flagTemp) {
				for (int j = 0; j < temp3.length; j++) {
					tempAvailable[j] += temp3[j];
				}
				flag[i] = 1;
			} else {
				for (int j = 0; j < temp3.length; j++) {
					tempAvailable[j] -= temp3[j];
				}
			}
			int seqNum = 0;
			sequenceTemp[seqNum] = "P" + i;		// 创建安全序列
			seqNum++;
			
			/*
			 * 遍历所有序列,注意便利顺序
			 */
			for (int j = 0; j < proNum; j++) {
				/* 进程已经完成 */
				if (flag[j] == 1) {
					continue;
				}
				
				temp1 = maxList.get(j);
				temp2 = allcationList.get(j);
				temp3 = needList.get(j);
				
				/* 开始寻找安全序列 */
				flagTemp = true;							// 初始为可以回收
				for (int k = 0; k < temp3.length; k++) {
					if (temp2[k] + temp3[k] != temp1[k]) {
						// 分配后不能回收
						flagTemp = false;
					}
				}
				if (flagTemp) {
					for (int k = 0; k < temp3.length; k++) {
						tempAvailable[k] += temp3[k];
					}
					flag[j] = 1;
				} else {
					for (int k = 0; k < temp3.length; k++) {
						tempAvailable[k] -= temp3[j];
					}
				}
				sequenceTemp[seqNum] = "P" + j;		// 创建安全序列
				seqNum++;
			}
			
			/* 判断是否与分配完成 */
			boolean last = true;
			for (int j = 0; j < flag.length; j++) {
				if (flag[j] != 1) {
					last = false;
					break;
				}
			}
			if (last) {
				sequence = sequenceTemp;
				break;
			} else {
				sequence = null;
			}
		}
		
		return sequence;
	}
}



















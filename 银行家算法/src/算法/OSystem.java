package �㷨;

import java.util.List;

/**
 * ϵͳ��
 *
 */
public class OSystem {
	/**
	 * �жϽ����Ƿ�ȫ�������ذ�ȫ����
	 * @param maxList
	 * @param allcationList
	 * @param needList
	 * @param available
	 * @return
	 */
	public String[] judjeProcess(List<int[]> maxList, List<int[]> allcationList, List<int[]> needList, int[] available) {
		int proNum = maxList.size();					// �̸߳���
		String[] sequence = null;						// ��ȫ����
		int[] can = new int[proNum];				// ��Ƿ��Ϲ淶������
		
		/* ��һ�飬�ҵ�����Ԥ����淶�Ľ��� */
		for (int i = 0; i < proNum; i++) {
			int[] temp1 = maxList.get(i);
			int[] temp2 = allcationList.get(i);
			int[] temp3 = needList.get(i);
			
			/* �ж��Ƿ�����Ԥ���� */
			boolean flagTemp = true;					// ����Ƿ�����
			for (int j = 0; j < temp3.length; j++) {
				if ((temp3[j] > available[j]) || (temp3[j] + temp2[j] > temp1[j])) {
					// ��������ṩ ����  ����+���д���������
					flagTemp = false;
					break;
				}
			}
			
			// ������������������̱߳�ǳ���
			if (flagTemp) {
				can[i] = 1;		// ���������ı��Ϊ1
			}
		}
		
		/* �ڶ��飬��ʼѰ����������� */
		for (int i = 0; i < can.length; i++) {
			// ���������������濪ʼ�ң�������������������
			if (can[i] == 0) {
				// ��������������
				continue;
			}
			
			/* ������ʱ���� */
			int[] tempAvailable = new int[available.length];
			for (int j = 0; j < tempAvailable.length; j++) {
				tempAvailable[j] = available[i];
			}
			
			int[] temp1 = maxList.get(i);
			int[] temp2 = allcationList.get(i);
			int[] temp3 = needList.get(i);
			
			/* ��ʼѰ�Ұ�ȫ���� */
			int[] flag = new int[proNum];						// ����Ƿ���������
			String[] sequenceTemp = new String[proNum];			// ��ʱ��ȫ����
			boolean flagTemp = true;							// ��ʼΪ���Ի���
			for (int j = 0; j < temp3.length; j++) {
				if (temp2[j] + temp3[j] != temp1[j]) {
					// ������ܻ���
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
			sequenceTemp[seqNum] = "P" + i;		// ������ȫ����
			seqNum++;
			
			/*
			 * ������������,ע�����˳��
			 */
			for (int j = 0; j < proNum; j++) {
				/* �����Ѿ���� */
				if (flag[j] == 1) {
					continue;
				}
				
				temp1 = maxList.get(j);
				temp2 = allcationList.get(j);
				temp3 = needList.get(j);
				
				/* ��ʼѰ�Ұ�ȫ���� */
				flagTemp = true;							// ��ʼΪ���Ի���
				for (int k = 0; k < temp3.length; k++) {
					if (temp2[k] + temp3[k] != temp1[k]) {
						// ������ܻ���
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
				sequenceTemp[seqNum] = "P" + j;		// ������ȫ����
				seqNum++;
			}
			
			/* �ж��Ƿ��������� */
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



















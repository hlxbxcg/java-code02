package �㷨;

import java.lang.management.OperatingSystemMXBean;
/* ���� */
import java.util.*;

import ��Ϣ.PrintInfo;
import ��Ϣ.ReadData;



/**
 * ���������������
 *
 */
public class Main {
	
	/**
	 * ���������֣���������
	 * @param args ���в���
	 */
	public static void main(String[] args) {
		int count=0;//����
		String filePath = "F:/data.txt";		// �ļ�·��
		
		/* ������� */
		List<int[]> maxList = new ArrayList<int[]>();
		List<int[]> allcationList = new ArrayList<int[]>();
		List<int[]> needList = new ArrayList<int[]>();
		int[] available = new int[3];
		
		/* ��ȡ�ļ� */
		ReadData rd = new ReadData(filePath);		// ������ȡ�ļ���
		rd.readInData(maxList, allcationList, needList, available);
		
		/* ��ӡ��ȡ����Ϣ */
		PrintInfo.printChart(maxList, allcationList, needList, available);
		
		/* �ж������Ƿ�ȫ */
		OSystem os = new OSystem();
		String[] sequence = os.judjeProcess(maxList, allcationList, needList, available);
		
		if (sequence == null) {
			System.out.println("δ�ҵ���ȫ����:");
		} else {
			System.out.println("�ҵ���ȫ�������£�");
			for (String string : sequence) {
				System.out.print(string + "\t");
				count++;
				if(count%10==0){
					System.out.println("");
					
				}
				
				}
			}
		}
	}































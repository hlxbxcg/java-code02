package ��Ϣ;

/* ���� */
import java.util.*;
import java.io.*;

/**
 * ��ȡ�ļ��е�����
 */
public class ReadData {
	private File file = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
	/**
	 * ���췽������ʼ���ļ�����
	 * @param filePath �ļ�·��
	 */
	public ReadData(String filePath) {
		file = new File(filePath);			// �����ļ�
		try {
			fr = new FileReader(file);		// ��׼�ļ�������
			br = new BufferedReader(fr);	// �ļ���װ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�ļ��е���������
	 * @param maxList ���ʱ����Ҫ����Դ����
	 * @param allcationList �Ѿ�ӵ�е���Դ����
	 * @param needList ����Ҫ����Դ����
	 * @param available ϵͳ�ɷ�����Դ��
	 */
	public void readInData(List<int[]> maxList, List<int[]> allcationList, List<int[]> needList, int[] available) {
		List<String> strList = new ArrayList<String>();			// ���ļ���ȡΪ�ַ�������
		
		/* ��ʼ��ȡ�ļ� */
		try {
			String str = "";		// ��ȡ����һ�����ݵ���ʱ��ű���
			while((str = br.readLine()) != null) {
				strList.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* ��ʼ�Զ�ȡ�����ַ������д��� */
		for(int i = 0; i < strList.size(); i++) {
			String[] strs = strList.get(i).split("\t");			// �ָ�һ������
			
			/* ��ʱ���� */
			int[] max = new int[3];
			int[] all = new int[3];
			int[] need = new int[3];
			
			/* ��ʱ�±� */
			int mIndex = 0;
			int aIndex = 0;
			int nIndex = 0;
			
			/* ��ʼ������ */
			for (int j = 0; j < strs.length; j++) {
				if(j < 3) {
					// ǰ����0 1 2
					max[mIndex] = Integer.parseInt(strs[j]);
					mIndex++;
				}
				if ((j >= 3) && (j < 6)) {
					// 3 4 5
					all[aIndex] = Integer.parseInt(strs[j]);
					aIndex++;
				}
				if ((j >= 6) && (j < 9)) {
					// 6 7 8
					need[nIndex] = Integer.parseInt(strs[j]);
					nIndex++;
				}
			}
			
			if (i == 0) {
				// ��һ����������available��Ϣ
				available[0] = Integer.parseInt(strs[9]);
				available[1] = Integer.parseInt(strs[10]);
				available[2] = Integer.parseInt(strs[11]);
			}
			
			/* �����ݼ��뼯�� */
			maxList.add(max);
			allcationList.add(all);
			needList.add(need);
		}
		
		/* �ر��� */
		this.closeIO();
	}
	
	/**
	 * �ڲ��������ر���
	 * 
	 */
	private void closeIO() {
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}








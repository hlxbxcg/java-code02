package com.hlx07;
//����JAVA���߰�
import java.io.*;
import java.util.*;

public class RunJava{
	public static void main(String[] args) {
		// ��������
		List<Process> processList = new ArrayList<Process>();		
		Process process = null;
		// �������������
		Util util = new Util();			
		String path = "C:/data.txt";
		// ��ȡ�����ļ���Ϣ��ÿ������һ��
		List<String> proStrList = util.readFileData(path);
		
		// ������ȡ���Ľ�����Ϣ
		for (String string : proStrList) {
			String[] strs = util.handleStringData(string);
			
			// ����Process����
			process = new Process();
	
			process.setProcessName(strs[0]);
			process.setArrivedTime(Long.parseLong(strs[1]));
			process.setServerTime(Long.parseLong(strs[2]));
			
			// ���뼯��
			processList.add(process);
		}
		//�Զ�����������ݽ������� 
		Collections.sort(processList);
		
		for (int i = 0; i < processList.size(); i++) {
			// ���㿪ʼʱ��
			if (i == 0) {
				// ��һ������
				OS.calcStartTime(processList.get(i), null);
			} else {			
				//����һ������
				OS.calcStartTime(processList.get(i), processList.get(i - 1));
			}
			
			// ���ʱ��
			OS.calcFinishTime(processList.get(i));
			
			//������תʱ��
			OS.calcCycleTime(processList.get(i));
			
			// ��Ȩ��תʱ��
			OS.calcSPCycleTime(processList.get(i));
		}
		
		//��ӡ��� 
		OS.printOrder(processList);		
		OS.printChart(processList);
		// ��ӡƽ����תʱ�� �� ƽ����Ȩ��תʱ��

		OS.printAvgCycleime(processList);	
	
	}		


}


class Process implements Comparable<Process> {
	private String processName = null;
	private double arrivedTime = 0;
	private double serverTime = 0;
	private double startTime = 0;
	private double finishTime = 0;
	private double cycleTime = 0;
	private double specialCycleTime = 0;
	
	
	public Process(String processName, double arrivedTime, double serverTime) {
		//��������
		this.processName = processName;
		//����ʱ��
		this.arrivedTime = arrivedTime;
		 //����ʱ��
		this.serverTime = serverTime;
	}
	
	
	public Process() {
		// TODO Auto-generated constructor stub
	}
	
public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public double getArrivedTime() {
		return arrivedTime;
	}

	public void setArrivedTime(long arrivedTime) {
		this.arrivedTime = arrivedTime;
	}

	public double getServerTime() {
		return serverTime;
	}

	public void setServerTime(double serverTime) {
		this.serverTime = serverTime;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(double finishTime) {
		this.finishTime = finishTime;
	}

	public double getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(double cycleTime) {
		this.cycleTime = cycleTime;
	}

	public double getSpecialCycleTime() {
		return specialCycleTime;
	}

	public void setSpecialCycleTime(double specialCycleTime) {
		this.specialCycleTime = specialCycleTime;
	}
	
	

	@Override
	public int compareTo(Process o) {
		if (o.arrivedTime > this.arrivedTime) {
			return -1;
		} else if (o.arrivedTime == this.arrivedTime) {
			return 0;
		} else {
			return 1;
		}
	}
}


class Util {
	private File file = null;
	private BufferedReader br = null; 
	
	/**
	 * ��ȡ�ļ��е�����
	 * @param path ��ȡ���ļ�·��
	 * @return ���ض�ȡ�����ַ����ݣ�ÿ����������Ϊһ���ַ���
	 */
	public List<String> readFileData(String path) {
		List<String> processList = new ArrayList<String>();
		
		file = new File(path);
		try {
			br = new BufferedReader(new FileReader(file));
			
			String str = "";
			while((str = br.readLine()) != null) {
				processList.add(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return processList;
	}
	
	
	public String[] handleStringData(String data) {
		String[] strs = data.split(" ");
		
		return strs;
	}
}


class OS {
	
	/**
	 * ������̿�ʼʱ��
	 * ��ǰ����
	 * ��ǰ���̵���һ�����̣����û�У���Ϊ��
	 *
	 */
	public static void calcStartTime(Process myProcess, Process lastProcess) {
		double stTime = 0;
		
		// ��һ������ ���� ��ǰ���̵���ʱ�� > ��һ���������ʱ��
		if ((lastProcess == null) || (myProcess.getArrivedTime() >= lastProcess.getFinishTime())) {
			stTime = myProcess.getArrivedTime();
		} else {
			// ��һ���������ʱ�� = ��ǰ���̿�ʼʱ��
			stTime = lastProcess.getFinishTime();
		}
		
		// ��ֵ
		myProcess.setStartTime(stTime);
	}
	
	/**
	 * ���㵱ǰ���̵����ʱ��
	 *  ��ǰ����
	 */
	public static void calcFinishTime(Process myProcess) {
		// ���ʱ�� = ��ʼʱ�� + ����ʱ��
		myProcess.setFinishTime(myProcess.getStartTime() + myProcess.getServerTime());
	}
	
	/**
	 * ���㵱ǰ���̵���תʱ��
	 * @param myProcess ��ǰ����
	 */
	public static void calcCycleTime(Process myProcess) {
		// ��תʱ�� = ���ʱ�� - ����ʱ��
		myProcess.setCycleTime(myProcess.getFinishTime() - myProcess.getArrivedTime());
	}
	
	public static void calcSPCycleTime(Process myProcess) {
		// ��Ȩ��תʱ�� = ��תʱ�� / ����ʱ��
		myProcess.setSpecialCycleTime(myProcess.getCycleTime() / myProcess.getServerTime());
	}
	public static void printOrder(List<Process> processList) {
		System.out.println("ʵ�����д���Ϊ��");
		for (Process process : processList) {
			System.out.println(process.getProcessName());
		}
	}
	
		public static void printChart(List<Process> processList) {
		System.out.println("������	����ʱ��	  ����ʱ��	��ʼʱ��  	���ʱ��	    ��תʱ��	��Ȩ��תʱ��");
		for (Process process : processList) {
			System.out.println(process.getProcessName() + "	" + process.getArrivedTime() + "	" + process.getServerTime() + "	" + 
					process.getStartTime() + "	" + process.getFinishTime() + "	" + process.getCycleTime() + "	" + 
					process.getSpecialCycleTime());
		}
	}
	
	
	 // ����ƽ����תʱ�� �� ƽ����Ȩ��תʱ��
	  public static void printAvgCycleime(List<Process> processList) {
		double cycleTimeSum = 0;
		double spCycleTimeSum = 0;
		int n = 0;
		
		for (Process process : processList) {
			cycleTimeSum += process.getCycleTime();
			spCycleTimeSum += process.getSpecialCycleTime();
			n++;
		}
		
		System.out.println("ƽ����תʱ��Ϊ��" + (cycleTimeSum / n));
		System.out.println("ƽ����Ȩ��תʱ��Ϊ��" + (spCycleTimeSum / n));
	}
}







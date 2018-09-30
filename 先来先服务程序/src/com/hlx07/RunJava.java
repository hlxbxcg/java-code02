package com.hlx07;
//导入JAVA工具包
import java.io.*;
import java.util.*;

public class RunJava{
	public static void main(String[] args) {
		// 创建集合
		List<Process> processList = new ArrayList<Process>();		
		Process process = null;
		// 创建工具类对象
		Util util = new Util();			
		String path = "C:/data.txt";
		// 读取所有文件信息，每个进程一行
		List<String> proStrList = util.readFileData(path);
		
		// 遍历读取到的进程信息
		for (String string : proStrList) {
			String[] strs = util.handleStringData(string);
			
			// 创建Process对象
			process = new Process();
	
			process.setProcessName(strs[0]);
			process.setArrivedTime(Long.parseLong(strs[1]));
			process.setServerTime(Long.parseLong(strs[2]));
			
			// 放入集合
			processList.add(process);
		}
		//对读入乱序的数据进行排序 
		Collections.sort(processList);
		
		for (int i = 0; i < processList.size(); i++) {
			// 计算开始时间
			if (i == 0) {
				// 第一个进程
				OS.calcStartTime(processList.get(i), null);
			} else {			
				//另外一个进程
				OS.calcStartTime(processList.get(i), processList.get(i - 1));
			}
			
			// 完成时间
			OS.calcFinishTime(processList.get(i));
			
			//计算周转时间
			OS.calcCycleTime(processList.get(i));
			
			// 带权周转时间
			OS.calcSPCycleTime(processList.get(i));
		}
		
		//打印输出 
		OS.printOrder(processList);		
		OS.printChart(processList);
		// 打印平均周转时间 和 平均加权周转时间

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
		//进程名称
		this.processName = processName;
		//到达时间
		this.arrivedTime = arrivedTime;
		 //服务时间
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
	 * 读取文件中的数据
	 * @param path 读取的文件路径
	 * @return 返回读取到的字符内容，每个进程数据为一个字符串
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
	 * 计算进程开始时间
	 * 当前进程
	 * 当前进程的上一个进程，如果没有，则为空
	 *
	 */
	public static void calcStartTime(Process myProcess, Process lastProcess) {
		double stTime = 0;
		
		// 第一个进程 或者 当前进程到达时间 > 上一个进程完成时间
		if ((lastProcess == null) || (myProcess.getArrivedTime() >= lastProcess.getFinishTime())) {
			stTime = myProcess.getArrivedTime();
		} else {
			// 上一个进程完成时间 = 当前进程开始时间
			stTime = lastProcess.getFinishTime();
		}
		
		// 传值
		myProcess.setStartTime(stTime);
	}
	
	/**
	 * 计算当前进程的完成时间
	 *  当前进程
	 */
	public static void calcFinishTime(Process myProcess) {
		// 完成时间 = 开始时间 + 服务时间
		myProcess.setFinishTime(myProcess.getStartTime() + myProcess.getServerTime());
	}
	
	/**
	 * 计算当前进程的周转时间
	 * @param myProcess 当前进程
	 */
	public static void calcCycleTime(Process myProcess) {
		// 周转时间 = 完成时间 - 到达时间
		myProcess.setCycleTime(myProcess.getFinishTime() - myProcess.getArrivedTime());
	}
	
	public static void calcSPCycleTime(Process myProcess) {
		// 带权周转时间 = 周转时间 / 服务时间
		myProcess.setSpecialCycleTime(myProcess.getCycleTime() / myProcess.getServerTime());
	}
	public static void printOrder(List<Process> processList) {
		System.out.println("实际运行次序为：");
		for (Process process : processList) {
			System.out.println(process.getProcessName());
		}
	}
	
		public static void printChart(List<Process> processList) {
		System.out.println("任务名	到达时间	  服务时间	开始时间  	完成时间	    周转时间	带权周转时间");
		for (Process process : processList) {
			System.out.println(process.getProcessName() + "	" + process.getArrivedTime() + "	" + process.getServerTime() + "	" + 
					process.getStartTime() + "	" + process.getFinishTime() + "	" + process.getCycleTime() + "	" + 
					process.getSpecialCycleTime());
		}
	}
	
	
	 // 计算平均周转时间 和 平均带权周转时间
	  public static void printAvgCycleime(List<Process> processList) {
		double cycleTimeSum = 0;
		double spCycleTimeSum = 0;
		int n = 0;
		
		for (Process process : processList) {
			cycleTimeSum += process.getCycleTime();
			spCycleTimeSum += process.getSpecialCycleTime();
			n++;
		}
		
		System.out.println("平均周转时间为：" + (cycleTimeSum / n));
		System.out.println("平均带权周转时间为：" + (spCycleTimeSum / n));
	}
}







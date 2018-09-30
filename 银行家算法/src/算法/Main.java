package 算法;

import java.lang.management.OperatingSystemMXBean;
/* 引包 */
import java.util.*;

import 信息.PrintInfo;
import 信息.ReadData;



/**
 * 主函数，程序入口
 *
 */
public class Main {
	
	/**
	 * 主函数在手，程序我有
	 * @param args 运行参数
	 */
	public static void main(String[] args) {
		int count=0;//计数
		String filePath = "F:/data.txt";		// 文件路径
		
		/* 传入参数 */
		List<int[]> maxList = new ArrayList<int[]>();
		List<int[]> allcationList = new ArrayList<int[]>();
		List<int[]> needList = new ArrayList<int[]>();
		int[] available = new int[3];
		
		/* 读取文件 */
		ReadData rd = new ReadData(filePath);		// 创建读取文件类
		rd.readInData(maxList, allcationList, needList, available);
		
		/* 打印读取的信息 */
		PrintInfo.printChart(maxList, allcationList, needList, available);
		
		/* 判断序列是否安全 */
		OSystem os = new OSystem();
		String[] sequence = os.judjeProcess(maxList, allcationList, needList, available);
		
		if (sequence == null) {
			System.out.println("未找到安全序列:");
		} else {
			System.out.println("找到安全序列如下：");
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































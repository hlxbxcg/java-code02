package 信息;

/* 引包 */
import java.util.*;
import java.io.*;

/**
 * 读取文件中的数据
 */
public class ReadData {
	private File file = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
	/**
	 * 构造方法，初始化文件操作
	 * @param filePath 文件路径
	 */
	public ReadData(String filePath) {
		file = new File(filePath);			// 创建文件
		try {
			fr = new FileReader(file);		// 标准文件输入流
			br = new BufferedReader(fr);	// 文件包装刘
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取文件中的所有数据
	 * @param maxList 完成时所需要的资源数量
	 * @param allcationList 已经拥有的资源数量
	 * @param needList 还需要的资源数量
	 * @param available 系统可分配资源数
	 */
	public void readInData(List<int[]> maxList, List<int[]> allcationList, List<int[]> needList, int[] available) {
		List<String> strList = new ArrayList<String>();			// 将文件读取为字符串集合
		
		/* 开始读取文件 */
		try {
			String str = "";		// 读取到的一行数据的临时存放变量
			while((str = br.readLine()) != null) {
				strList.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* 开始对读取到的字符串进行处理 */
		for(int i = 0; i < strList.size(); i++) {
			String[] strs = strList.get(i).split("\t");			// 分割一行数据
			
			/* 临时数组 */
			int[] max = new int[3];
			int[] all = new int[3];
			int[] need = new int[3];
			
			/* 临时下标 */
			int mIndex = 0;
			int aIndex = 0;
			int nIndex = 0;
			
			/* 开始拿数据 */
			for (int j = 0; j < strs.length; j++) {
				if(j < 3) {
					// 前三个0 1 2
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
				// 第一行数据中有available信息
				available[0] = Integer.parseInt(strs[9]);
				available[1] = Integer.parseInt(strs[10]);
				available[2] = Integer.parseInt(strs[11]);
			}
			
			/* 将数据加入集合 */
			maxList.add(max);
			allcationList.add(all);
			needList.add(need);
		}
		
		/* 关闭流 */
		this.closeIO();
	}
	
	/**
	 * 内部方法，关闭流
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








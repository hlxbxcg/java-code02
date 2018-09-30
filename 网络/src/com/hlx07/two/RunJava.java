package com.hlx07.two;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CORBA_2_3.portable.OutputStream;

public class RunJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String path="d:/hlx/aaa.exe";
		File file=new File(path);
		
		FileInputStream fis=new FileInputStream(file);
		byte []buffer=new byte[1024];
		int len=0;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		while((len=fis.read(buffer))!=-1){
			baos.write(buffer,0,len);
		}
		baos.flush();
		fis.close();
		//--------------
		String pathSever="http://192.168.8.110:8080/io-sever/io-sever/dattaSeverlet";
		URL url=new URL(pathSever);
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POS");
		conn.setReadTimeout(5000);
		conn.setRequestProperty("Content-type","application/x-www-form-yrlencorded");
		conn.setRequestProperty("Content-length",file.separator+"");
		conn.setDoOutput(true);
		java.io.OutputStream os= conn.getOutputStream();
		//os.write(file);
		int Code =conn.getResponseCode();
		if(Code==200){
			System.out.println("文件上传成功");
			
		}
		else{
			System.out.println("文件上传失败");
		}
		
		

	}

}

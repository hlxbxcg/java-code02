package com.hlx07.one;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RunJava {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		String path="http://192.168.8.110:8080/io-sever/data.txt";
		URL url=new URL(path);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setReadTimeout(5000);
		InputStream is=conn.getInputStream();
		byte []buffer=new byte[1024];
		int len=0;
		 ByteArrayOutputStream baos=new ByteArrayOutputStream();
		while((len=is.read(buffer))!=-1){
			baos.write(buffer,0,len);
			
		}
		baos.flush();
		is.close();
		byte []result=baos.toByteArray();
		 String re =new String(result);
		 System.out.println(re);
		
		

	}

}

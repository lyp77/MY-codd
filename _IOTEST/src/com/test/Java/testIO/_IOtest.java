package com.test.Java.testIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class _IOtest {
	
	public static String getPath(String command) {
		ArrayList list = new ArrayList(Arrays.asList(command.split("\\\\")));
		StringBuffer aBuffer = new StringBuffer();
		for (int i = 0; i < list.size()-1; i++) {
			aBuffer.append(list.get(i)+"/");
		//	System.out.println(aBuffer);
		}
		return aBuffer.toString();
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			String aString ="VDD-"+new Random().nextInt(500);
			String command ="/workspace/_IOTEST/src/com/test/Java/picture/crocodile.jpg";
			File file = new File(command);
			String newfile =getPath(file.getAbsolutePath().toString())+aString+file.getName().substring(file.getName().indexOf("."));
			System.out.println(newfile);
			File getfile = new File(newfile);
			try{
				getfile.createNewFile();
			}catch (Exception e) {
				e.printStackTrace();
			}
			RandomAccessFile  a= null;
			RandomAccessFile  b= null;
			FileChannel ao =null;
			FileChannel bc =null;
			
			try{
			a = new RandomAccessFile(file, "rw");
			b = new RandomAccessFile(getfile, "rw");
			ao= a.getChannel();
			bc=  b.getChannel();
			ao.transferTo(0, ao.size(), bc);
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				a.close();
				b.close();
				ao.close();
				bc.close();
			}
			System.out.println("copyfile succeed");
		}
	
	
	}



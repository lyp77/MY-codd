package com.test.Java.testIO;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

import com.jfinal.core.Controller;

public class ControllerTestIo extends Controller {
		public void testIO() throws IOException{
			File file = new File("/workspace/_IOTEST/src/com/test/Java/picture/crocodile.jpg");
			System.out.println(file);
			String newfile = file.getPath()+file.getName()+file.getName().indexOf(3);
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
			
		}
}

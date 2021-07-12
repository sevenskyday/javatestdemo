package demo.first;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		
		
		// windows 分隔符"\"
		// linux 分隔符 "/"
		// public static final String separaor
		File file=new File("C:"+File.separator+"Users\\XRNY\\Desktop\\test.txt");
		//File file = new File("C:" + File.separator);
//		if (file.isDirectory()) {
//			File result[] = file.listFiles();
//			for (int x = 0; x < result.length; x++) {
//				System.out.println(result[x]);
//			}
//		} else {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			OutputStream output=new FileOutputStream(file);
			String str="www.baidu.com";
			output.write(str.getBytes());
			output.close();
			
			
//			if (file.exists()) {
//				file.delete();
//
//			} else {
//				System.out.println(file.createNewFile());
//				System.out.println(file.canRead());
//				System.out.println(file.canWrite());
//				// 文件大小返回字节
//				System.out.println(MathUtil.round(file.length() / (1024 * 1024), 2));
//
//				System.out.println(DateUtil.ToyyyMMddHHmmss(file.lastModified()));
//
//				System.out.println(file.isDirectory());
//
//				System.out.println(file.isFile());
//			}
			//}
	}
}

class FileUtil {
	private FileUtil() {
	};

	public static void ListDir(File file) {
		if (file.isDirectory()) {
			File results[] = file.listFiles();
			if(results!=null)
			{
				for (int x = 0; x < results.length; x++) {
					ListDir(results[x]);
				}
			}
		}
		System.out.println(file);
	}
	
	public static void RenameDir(File file) {
		if (file.isDirectory()) {
			File results[] = file.listFiles();
			if(results!=null)
			{
				for (int x = 0; x < results.length; x++) {
					RenameDir(results[x]);
				}
			}
		}else {
			if(file.isFile())
			{
				String filename=file.getName();
				if(filename.contains("."))
				{
					filename=filename.substring(0,filename.lastIndexOf("."))+".txt";
					
				}else
				{
					filename=filename+".txt";
				}
				File newfile=new File(file.getParent(),filename);
				file.renameTo(newfile);
			}
		}
		System.out.println(file);
	}
}

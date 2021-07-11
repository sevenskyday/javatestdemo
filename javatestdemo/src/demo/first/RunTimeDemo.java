package demo.first;

public class RunTimeDemo {
	public static void main(String args[]) throws Exception {
		Runtime run=Runtime.getRuntime();
		System.out.println(run.availableProcessors());
		System.out.println("**************************");
		//8内核。最大并发访问量
		System.out.println("maxMemory "+ (run.maxMemory()/(1024*1024)));
		System.out.println("totalMemory "+(run.totalMemory()/(1024*1024)));
		System.out.println("freeMemory "+(run.freeMemory()/(1024*1024)));
		System.out.println("**************************");
		long start =System.currentTimeMillis();
		String str="";
		for(int x=0;x<100000;x++) {
			str +=x;
		}
		long end =System.currentTimeMillis();
		System.out.println("操作耗时  "+ (end-start));
		System.out.println("**************************");
		System.out.println("maxMemory "+ (run.maxMemory()/(1024*1024)));
		System.out.println("totalMemory "+(run.totalMemory()/(1024*1024)));
		System.out.println("freeMemory "+(run.freeMemory()/(1024*1024)));
		System.out.println("**************************");
		Thread.sleep(200);
		run.gc();
		System.out.println("maxMemory "+ (run.maxMemory()/(1024*1024)));
		System.out.println("totalMemory "+(run.totalMemory()/(1024*1024)));
		System.out.println("freeMemory "+(run.freeMemory()/(1024*1024)));
	}

}

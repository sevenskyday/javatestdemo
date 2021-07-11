package demo.first;

class MyThread implements  Runnable {
	// 线程的主体

	private String title;

	public MyThread(String title) {
		this.title = title;
	}

	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(this.title + "运行,x=" + x);
		}
	}
}

public class ThreadDemo {
	public static void main(String args[]) {
		Thread thread1=new Thread(new MyThread("线程A"));
		Thread thread2=new Thread(new MyThread("线程B"));
		Thread thread3=new Thread(new MyThread("线程C"));
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

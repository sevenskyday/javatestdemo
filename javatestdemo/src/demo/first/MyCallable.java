package demo.first;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable {

	public static void main(String args[]) throws Exception {
		CallThread mt=new CallThread();
		FutureTask<String> taskA =new FutureTask<String>(mt);
		FutureTask<String> taskB =new FutureTask<String>(mt);
		FutureTask<String> taskC =new FutureTask<String>(mt);
		new Thread (taskA,"竞赛者A").start();
		new Thread (taskB,"竞赛者B").start();
		new Thread (taskC,"竞赛者C").start();
		System.out.println(taskA.get());
		System.out.println(taskB.get());
		System.out.println(taskC.get());
	}
}

class CallThread implements Callable<String> {

	private boolean flag = false; // 抢答标志

	@Override
	public String call() throws Exception {
		synchronized (this) {
			if (this.flag == false) {
				this.flag = true;
				return Thread.currentThread().getName() + "抢答成功";
			} else {
				return Thread.currentThread().getName() + "抢答失败";
			}
		}

	}
}
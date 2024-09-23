package newThreads;

import java.time.LocalDateTime;

public class WaitingThreads {
public static void main(String[] args) throws InterruptedException {
	System.out.println("Main thread starts "+LocalDateTime.now());
	System.out.println("Thread name "+Thread.currentThread().getName());
	Thread.sleep(5000);
	System.out.println("Main thread ends "+LocalDateTime.now());
	
	Object resource = new Object();
	Thread th1 = new Thread(() ->{
		synchronized (resource) {
			System.out.println("Thread-1 is running "+ Thread.currentThread().getName());
			System.out.println("Thread-1 is pausing using wait()");
			try {
				resource.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Resumeing thread-1");
			
		}
	}, "Thread-1");
	
	Thread th2 = new Thread(() ->{
		synchronized (resource) {
			System.out.println("Thread-2 is running "+ Thread.currentThread().getName());
			System.out.println("Thread-2 is notify using notify()");
			resource.notify();
			System.out.println("Resumeing thread-2");
			
		}
	}, "Thread-2");
	
	th1.start();
	th2.start();
	
	Thread thYield1 = new Thread(() ->{
		for(int i=0;i<5;i++) {
			System.out.println("Excecting Thread "+ Thread.currentThread().getName());
			Thread.yield();
		}
	}, "Thread Yield-1");
	
	Thread thYield2 = new Thread(() ->{
		for(int i=0;i<5;i++) {
			System.out.println("Excecting Thread "+ Thread.currentThread().getName());
			Thread.yield();
		}
	}, "Thread Yield-2");
	
	thYield1.start();
	thYield2.start();
}
}

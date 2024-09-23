package newThreads;

import java.util.Iterator;

public class Main {
public static void main(String[] args) {
	System.out.println("Main Thread starts");
	for(int i=0;i<5;i++) {
		Thread thread = new ThreadClass();
		thread.start();
	}
	for(int i=0;i<5;i++) {
		Thread th = new Thread(new RunnableClass(), "runabble Thread"+i);
		th.start();
	}
	for(int i=0;i<5;i++) {
		Thread th = new Thread(() ->{
			try {
				Thread.sleep(3000);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName());
		}, "runabble Thread using lamda"+i);
		th.start();
	}
	System.out.println("Main Thread Ends");
}
}

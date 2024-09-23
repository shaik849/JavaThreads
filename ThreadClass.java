package newThreads;

public class ThreadClass extends Thread {
@Override
public void run() {
	// TODO Auto-generated method stub
//	super.run();
	try {
		Thread.sleep(3000);
		
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	System.out.println("Exceuting "+Thread.currentThread().getName());
}
}

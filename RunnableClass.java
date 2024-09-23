package newThreads;

public class RunnableClass implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
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

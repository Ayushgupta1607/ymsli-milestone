
package ques2;

import java.util.Random;

class Sum implements Runnable {
	Random random = new Random();
	private int sum;
	private boolean isDone = false;
	int count = 0;

	@Override
	public void run() {
		int randomNumber = random.nextInt(10) + 1;
		System.out.println(Thread.currentThread().getName() + ": " + randomNumber);
		count++;
		sum = sum + randomNumber;
		if (count == 5) {
			isDone = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}

	public synchronized int getSum() {
		if (!isDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}

public class ques2 {
	public static void main(String[] args) {
		Sum thread = new Sum();
		Thread thread1 = new Thread(thread, "thread1");
		Thread thread2 = new Thread(thread, "thread2");
		Thread thread3 = new Thread(thread, "thread3");
		Thread thread4 = new Thread(thread, "thread4");
		Thread thread5 = new Thread(thread, "thread5");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		System.out.println("Sum: " + thread.getSum());
	}
}

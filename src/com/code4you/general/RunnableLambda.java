package com.code4you.general;

public class RunnableLambda {

	public static void main(String[] args) {
		
		Runnable task1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runnable 1");
				
			}
		};
		
		new Thread(task1).start();
		
		Runnable task2 = ()->System.out.println("runnable 2");
		new Thread(task2).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runnable 3");
				
			}
		}).start();
		
		new Thread(()->System.out.println("runnable 4")).start();

	}

}

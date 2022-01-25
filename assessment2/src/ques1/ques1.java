package ques1;

import java.io.Serializable;

enum MySingleton {
	INSTANCE;

}

class Singleton implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	// using volatile with double lock checking

	// lazy Initialization
	private static volatile Singleton singleton = null;

	// //eager 
	// public static Singleton getInstance() { return singleton; }
	
	private Singleton() {
		if (singleton != null) {
			// reflection issue
			throw new IllegalStateException();
		}
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			if (singleton == null) {
				// thread safe
				synchronized (Singleton.class) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	// serialization issue
	private Object readResolve() {
		return singleton;
	}

	// cloning issue
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singleton;
	}
}

public class ques1 {
	public static void main(String[] args) {
		// Enum Singleton
		MySingleton singletonEnum = MySingleton.INSTANCE;
		System.out.println(singletonEnum.hashCode());

		MySingleton singletonEnum2 = MySingleton.INSTANCE;
		System.out.println(singletonEnum2.hashCode());
	}
}
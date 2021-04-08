package org.seckill.test.ref;

/**
 * @author cgm
 * @create 2021-04-03 11:24
 */
public class ReflectionTest {
	public void t2Method() {
		getCaller();
	}

	public void getCaller() {
		StackTraceElement stacks[] = Thread.currentThread().getStackTrace();
		for (StackTraceElement stack : stacks) {
			if ((stack.getClassName().indexOf("Test")) != -1) {
				System.out.println(
						"called by "
								+ stack.getClassName()
								+ "."
								+ stack.getMethodName()
								+ "/"
								+ stack.getFileName());
			}
		}
	}
}

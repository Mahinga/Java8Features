/**
 * 
 */
package lambdaUnderHood;

/**
 * @author MAHINGA
 *
 *Lambda seems just the replacement of the anonymous classes but thats not completely true. It works in a smart way.
 * 
 * With below program, it could be proved that when commented code is executed, it creates additional class files
 * in the heap memory for each anonymous.
 * 
 * But when same work is done through lambda, there is only one single class i.e lambdaUnderHood.class
 * 
 * It basically works on the functionality of invokedynamic.
 * 
 *  Code of class file is also attached here in the end of program.
 */
public class LambdaUnderHood {
	public static void main(String[] args) {
		Thread th;
//		th= new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("inside thread");
//				
//			}
//		});
		
       th= new Thread(() -> System.out.println("in thread"));
       th= new Thread(() -> System.out.println("in thread"));
       th= new Thread(() -> System.out.println("in thread"));
       th= new Thread(() -> System.out.println("in thread"));
       th= new Thread(System.out::println);
				

		th.start();
		
		System.out.println("in main method");
	}


}
/*
 * MAHINGAs-MacBook-Air:src MAHINGA$ javap -c LambdaUnderHood.class
Compiled from "LambdaUnderHood.java"
public class src.LambdaUnderHood {
  public src.LambdaUnderHood();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/lang/Thread
       3: dup
       4: invokedynamic #3,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
       9: invokespecial #4                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      12: astore_1
      13: new           #2                  // class java/lang/Thread
      16: dup
      17: invokedynamic #5,  0              // InvokeDynamic #1:run:()Ljava/lang/Runnable;
      22: invokespecial #4                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      25: astore_1
      26: new           #2                  // class java/lang/Thread
      29: dup
      30: invokedynamic #6,  0              // InvokeDynamic #2:run:()Ljava/lang/Runnable;
      35: invokespecial #4                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      38: astore_1
      39: new           #2                  // class java/lang/Thread
      42: dup
      43: invokedynamic #7,  0              // InvokeDynamic #3:run:()Ljava/lang/Runnable;
      48: invokespecial #4                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      51: astore_1
      52: aload_1
      53: invokevirtual #8                  // Method java/lang/Thread.start:()V
      56: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
      59: ldc           #10                 // String in main method
      61: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      64: return
}
*/

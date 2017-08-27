package InfiniteStreams;

import java.util.stream.Stream;

public class InfiniteStreamsExamples {
	public static void main(String[] args) {
		System.out.println(compute(1,5000));
		
	}
	
	/**
	 * This method calculate  the total of the double of the all even numbers with square root greater than 10
	 * starting from "limit"
	 * upto "count"
	 * @param limit
	 * @param count
	 * @return
	 */
	private static int compute(int limit, int count){
		return Stream.iterate(limit, number -> number+1)
				      .filter(number -> number % 2 ==0)
				      .filter(number -> Math.sqrt(number)>10)
				      .mapToInt(number -> number*2)
				      .limit(count)
				      .sum();
	}

}

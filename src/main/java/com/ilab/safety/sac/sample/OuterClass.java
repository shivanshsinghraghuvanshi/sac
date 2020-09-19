package com.ilab.safety.sac.sample;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class OuterClass {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 7, 8, 9, 10, 11);
		Multiplier m = (int x) -> x * 3;
		int sum = numbers.stream().filter(num -> (num % 2 != 0)).map(m::multiply).reduce(0, Integer::sum);
		System.out.println(sum);
	}
}

// class Multiplier {
// public int multiply(int num) {
// return num * 3;
// }
// }

@FunctionalInterface
interface Multiplier {
	int multiply(int num);
}
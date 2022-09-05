package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
@DisplayName("Root Test")
class JunitNestedTest {

	@Test
	void test1() {
		System.out.println("=> test()");
	}
@Nested
@DisplayName("Nested Test A")
class TestA{
	@Test
	void testA_test1() {
		System.out.println("=> testA_test1()");
	}

@Nested
@DisplayName("Nested Test AA")
class TestAA{
	@Test
	void testAA_test1() {
		System.out.println("=> testAA_test1()");
	}
}}
@Nested
@DisplayName("Nested Test B")
class TestB{
	@Test
	void test() {
		System.out.println("=> testB_test1()");
	}
}
}

package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class DynamicTesting {

	@TestFactory
	Collection<DynamicTest> dynamicTestwithCollection(){

		return Arrays.asList(
		DynamicTest.dynamicTest("Add Test", ()-> assertEquals(2,Math.addExact(1, 1))),
		DynamicTest.dynamicTest("Multiply Test", ()-> assertEquals(6,Math.multiplyExact(2, 3)))
 				);
	}
}

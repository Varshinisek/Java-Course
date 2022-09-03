package Practices;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
@ExtendWith(ValidateParameterResolver.class)
class Testing1 {
	@Test
	@Tag("my-tag")
	 void test( Class at) {
		assertTrue(at.Validate("varsh", "1234"));
	  
	 }
}

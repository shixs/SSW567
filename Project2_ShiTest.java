import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/* @author Xingsheng Shi SSW 567
 * Project 2
 * 
 * 2014-9-15
 * 
 * */
@RunWith(Parameterized.class)
public class Project2_ShiTest {
	private Object line = new Object();
	private int expected;;
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] objects = {{0, "120 80 10 15 jio"},{1,"1/2 2 42 3 Shi"},{2,"110 75 10 8 jack"},{1,"1.1 21 10 4 Tom"},{1,"jdkl 3 e 12 1"},{0,"110 75 7 9 Teri"},{1,"@#$% 2 d 88 a"}};
		return Arrays.asList(objects);
	}
	
	public Project2_ShiTest(int expected, Object line){
		this.expected = expected;
		this.line = line; 
	}
	
	@Test
	public void test() {
		assertEquals(expected,Project2_Shi.analyze(line));

	}

}

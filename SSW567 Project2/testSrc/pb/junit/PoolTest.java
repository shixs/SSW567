package pb.junit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PoolTest {

	Pool pool = new Pool();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testReadData() {
		File file1 = new File("Test.txt");
		Assert.assertEquals(Pool.readData(file1),true);
	}
	
	@Test
	public void testReadDataFail() {
		File file2 = new File("None.txt");
		Assert.assertEquals(Pool.readData(file2),false);
	}

	@Test
	public void testCheckNum() {
		String sample1 = "8 6 7 8 Sam";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample1, bw),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckNumDecimal() {
		String sample2 = "5.5 6 7 8 Kin";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample2, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckNumNegative() {
		String sample3 = "3 -5 -9 8 Justin";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample3, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckInputLess() {
		String sample4 = "6 7 3 Mike";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample4, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckInputMore() {
		String sample5 = "6 7 8 6 7 8 Jack";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample5, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckNotNum() {
		String sample6 = "3 aaa 5 4 Jimmy";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample6, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckLongerWidth() {
		String sample7 = "3 4 5 8 Chris";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample7, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckLongerShallow() {
		String sample8 = "6 3 7 5 Marry";
		File targetFile = new File("OutputSample.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			Assert.assertEquals(Pool.checkNum(sample8, bw),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateResult() {
		File targetFile = new File("OutputSample.txt");
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(targetFile));
			List<Integer> numList = new ArrayList<Integer>();
			numList.add(8);
			numList.add(4);
			numList.add(4);
			numList.add(6);
			Assert.assertEquals(Pool.calculateResult(numList, bw),32.0, 0);
			//Assert.assertEquals(Pool.calculateResult(numList, bw),31.0, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

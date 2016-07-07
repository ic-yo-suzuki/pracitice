package jp.co.junit4.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConverterUtilityTest {

	static{
		System.out.println("スタティックイニシャライザ");
	}

	public ConverterUtilityTest(){
		System.out.println("コンストラクタ");
	}

	{
		System.out.println("インスタンスイニシャライザ");
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}


	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testNullToBlank_Nullを空白に() {
		System.out.println("nullToBlank: Nullを空白に");
		assertEquals("", ConvertUtility.nullToBlank(null));
	}

	@Test
	public void testNullToBlank_BlankToBlank() {
		System.out.println("nullToBlank: 空白を空白に");
		assertEquals("", ConvertUtility.nullToBlank(""));
	}

	@Test
	public void testNullToBlank_StringToBlank() {
		System.out.println("nullToBlank: 文字列を空白に");
		assertEquals("xyz", ConvertUtility.nullToBlank("xyz"));
	}

	@Test
	public void testConcatHyphen_NullAndNull() {
		System.out.println("concatHypyen: NullとNull");
		assertEquals("-", ConvertUtility.concatHyphen(null, null));
	}

	@Test
	public void testConcatHyphen_NullAndString() {
		System.out.println("concatHypyen: Nullと文字列");
		assertEquals("-xyz", ConvertUtility.concatHyphen(null, "xyz"));
	}

	@Test
	public void testConcatHyphen_StringAndNull() {
		System.out.println("concatHypyen: 文字列とNull");
		assertEquals("xyz-", ConvertUtility.concatHyphen("xyz", null));
	}

	@Test
	public void testConcatHyphen_StringAndString() {
		System.out.println("concatHypyen: 文字列と文字列");
		assertEquals("abc-xyz", ConvertUtility.concatHyphen("abc", "xyz"));
		assertThat(ConvertUtility.concatHyphen("abc", "def"), is("abc-def"));
	}

}

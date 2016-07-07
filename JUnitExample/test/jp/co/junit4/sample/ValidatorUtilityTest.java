/**
 *
 */
package jp.co.junit4.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author trainee180
 *
 */
public class ValidatorUtilityTest {

	static{
		System.out.println("スタティックイニシャライザ");
	}

	public ValidatorUtilityTest(){
		System.out.println("コンストラクタ");
	}

	{
		System.out.println("インスタンスイニシャライザ");
	}


	/**
	 * @throws java.lang.Exception
	 */
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

	/**
	 * {@link jp.co.junit4.sample.ValidatorUtility#isBlank(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testIsBlank_01() {
		System.out.println("isBlankのテスト：Nullは空白か：" + ValidatorUtility.isBlank(null));
		assertThat(null, is(nullValue()));
		assertThat(true, is(ValidatorUtility.isBlank(null)));
	}

	@Test
	public void testIsBlank_02(){
		System.out.println("isBlankのテスト：空白は空白か：" + ValidatorUtility.isBlank(""));
		assertThat("", is(""));
		assertThat(true, is(ValidatorUtility.isBlank("")));
	}

	@Test
	public void testIsBlank_03(){
		System.out.println("isBlankのテスト：文字列は空白か：" + ValidatorUtility.isBlank("xxx"));
		assertThat(false, is(ValidatorUtility.isBlank("xxx")));
	}

	/**
	 * {@link jp.co.junit4.sample.ValidatorUtility#isInt(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testIsInt_01() {
		System.out.println("isIntのテスト：Nullは整数ではないか：" + ValidatorUtility.isInt(null));
		assertThat(true, is(not(ValidatorUtility.isInt(null))));
	}

	@Test
	public void testIsInt_02() {
		System.out.println("isIntのテスト：空白は整数か：" + ValidatorUtility.isInt(""));
		assertThat(false, is(ValidatorUtility.isInt("")));
	}

	@Test
	public void testIsInt_03() {
		System.out.println("isIntのテスト：文字列'x'は整数か：" + ValidatorUtility.isInt("x"));
		assertThat(false, is(ValidatorUtility.isInt("x")));
		assertThat("x", is(not(instanceOf(Integer.class))));
	}

	@Test
	public void testIsInt_04() {
		System.out.println("isIntのテスト：文字列'123456'は整数か：" + ValidatorUtility.isInt("123456"));
		assertThat(true, is(ValidatorUtility.isInt("123456")));
	}

	@Test
	public void testIsInt_05() {
		System.out.println("isIntのテスト：文字列'-123456'は整数か：" + ValidatorUtility.isInt("-123456"));
		assertThat(true, is(ValidatorUtility.isInt("-123456")));
	}

	@Test
	public void testIsInt_06() {
		System.out.println("isIntのテスト：文字列'12345678901234567890'は整数か：" + ValidatorUtility.isInt("12345678901234567890"));
		assertThat(false, is(ValidatorUtility.isInt("12345678901234567890")));
	}



}

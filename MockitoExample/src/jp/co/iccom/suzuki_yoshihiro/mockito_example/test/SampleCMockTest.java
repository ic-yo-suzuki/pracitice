package jp.co.iccom.suzuki_yoshihiro.mockito_example.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import jp.co.iccom.suzuki_yoshihiro.mockito_example.sample.SampleA;
import jp.co.iccom.suzuki_yoshihiro.mockito_example.sample.SampleC;

public class SampleCMockTest {

	@Spy
	private SampleC sampleCMock = new SampleC();

	@InjectMocks
	private SampleA sampleA = new SampleA();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void メソッドのMock化のテスト() {
		doReturn(555).when(sampleCMock).getPrice((Integer)anyObject());

		String ret = sampleA.createName();

		System.out.println("取得できた値は：" + ret);

		assertThat("id:3 price:555", is(ret));
	}

}

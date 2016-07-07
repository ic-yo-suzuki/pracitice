package jp.co.iccom.suzuki_yoshihiro.mockito_example.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jp.co.iccom.suzuki_yoshihiro.mockito_example.sample.SampleA;
import jp.co.iccom.suzuki_yoshihiro.mockito_example.sample.SampleB;

public class MockitoSampleTest {

	@Mock(name = "sampleB1")
	private SampleB sampleBMock1;
	@Mock(name = "sampleB2")
	private SampleB sampleBMock2;

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
	public void MockアノテーションのName属性を使ったテスト() {
		when(sampleBMock1.getName((Integer)anyObject())).thenReturn("mock");
		when(sampleBMock2.getName((Integer)anyObject())).thenReturn("mock");

		String ret = sampleA.createName();

		assertThat("mock", is(ret));
	}
}

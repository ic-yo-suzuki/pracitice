package jp.co.iccom.suzuki_yoshihiro.mockito_example.sample;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListMockSample {

	@SuppressWarnings("unchecked")
	@Test
	public void No01_クラスをMock化する(){
		List<String> mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("testValue");
		String value = mockList.get(0);

		System.out.println("値を取得：" + value);
		verify(mockList, times(1)).get(0);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RuntimeException.class)
	public void No02_クラスをMock化する_例外を発生させる(){
		List<String> mockList = mock(List.class);

		when(mockList.get(0)).thenThrow(new RuntimeException("ランタイムException"));

		mockList.get(0);
	}

	@Test()
	@SuppressWarnings("unchecked")
	public void No03_クラスをMock化する_対象メソッドになにもさせない(){

		List<String> mockList = mock(List.class);

		doNothing().when(mockList).clear();

		mockList.clear();
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RuntimeException.class)
	public void No04_クラスをMock化させる_例外を発生させる(){
		List<String> mockList = mock(List.class);

		doThrow(new RuntimeException("ランタイムException")).when(mockList).clear();
		mockList.clear();
	}

	@Test
	public void No05_インスタンスをMock化させる_Spyメソッドの使い方(){
		List<String> mockList = new ArrayList<String>();
		mockList = spy(mockList);

		doNothing().when(mockList).clear();
		mockList.clear();
	}
}

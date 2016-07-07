package jp.co.iccom.suzuki_yoshihiro.mockito_example.sample;

public class SampleC {
	public Integer getId(){
		return 1 + 2;
	}

	public Integer getPrice(Integer id){
		Integer price = id * 100;
		return price;
	}
}

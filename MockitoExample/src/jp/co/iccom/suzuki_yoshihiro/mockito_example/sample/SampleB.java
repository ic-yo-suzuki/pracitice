package jp.co.iccom.suzuki_yoshihiro.mockito_example.sample;

public class SampleB {
	public String getName(Integer id){
		String name = null;
		if(id == 1){
			name = "test1";
		}else if(id == 2){
			name = "test2";
		}else{
			name = "other";
		}
		return name;
	}
}

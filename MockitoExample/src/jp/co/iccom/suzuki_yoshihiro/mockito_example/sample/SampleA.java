package jp.co.iccom.suzuki_yoshihiro.mockito_example.sample;

public class SampleA {

//	private SampleB sampleB1;
//	private SampleB sampleB2;
	private SampleC sampleC;

//	public String createName(){
//		String ret = sampleB1.getName(1);
//		ret = sampleB2.getName(1);
//		return ret;
//	}

	public String createName(){
		Integer id = sampleC.getId();
		Integer price = sampleC.getPrice(id);

		String ret = "id:" + id + " price:" + price;
		return ret;
	}
}

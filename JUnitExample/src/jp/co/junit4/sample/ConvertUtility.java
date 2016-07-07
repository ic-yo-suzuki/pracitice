package jp.co.junit4.sample;

public class ConvertUtility {
	static public String nullToBlank(String value){
		if(value == null){
			return "";
		}
		return value;
	}

	static public String concatHyphen(String value1, String value2){
		if(value1 == null){
			value1 = "";
		}
		if(value2 == null){
			value2 = "";
		}

		return value1 + "-" + value2;
	}
}

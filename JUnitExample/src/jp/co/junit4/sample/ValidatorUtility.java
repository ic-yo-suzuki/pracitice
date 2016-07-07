package jp.co.junit4.sample;

public class ValidatorUtility {

	static public boolean isBlank(String value){
		if(value == null || value.length() == 0){
			return true;
		}
		return false;
	}

	static public boolean isInt(String value){
		if(isBlank(value)){
			return false;
		}
		try{
			Integer.parseInt(value);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}

}

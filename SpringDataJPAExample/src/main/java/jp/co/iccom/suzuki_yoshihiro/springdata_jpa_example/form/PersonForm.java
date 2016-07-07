package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.form;

import lombok.Data;

@Data
public class PersonForm {
	public int id, age;
	public String name, sex;
}

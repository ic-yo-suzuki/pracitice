package jp.co.iccom.suzuki_yoshihiro.spring_ajax.bean;

import java.io.Serializable;


public class SampleBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
}

package jp.co.iccom.suzuki_yoshihiro.spring_ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.iccom.suzuki_yoshihiro.spring_ajax.bean.SampleBean;

@Controller
public class SampleController {
	@RequestMapping(value = "/service", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<String> top(@RequestBody SampleBean bean){
		List<String> list = new ArrayList<String>();
		System.out.println(bean.getName());
		list.add("太宰");
		list.add("夏目");
		return list;
	}
}

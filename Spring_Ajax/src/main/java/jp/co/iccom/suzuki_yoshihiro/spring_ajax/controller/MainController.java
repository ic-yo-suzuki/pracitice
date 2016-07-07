package jp.co.iccom.suzuki_yoshihiro.spring_ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMessage(Model model) {
        model.addAttribute("message", "hello world!!");
        return "showMessage";
    }


/*	 RequestMappingのvalueはjQuery.ajax関数の第2引数、methodは第1引数と一致させる

	$.ajax({
			type : "GET",
			url : "getTestData", ← @RequestMapping(value = "getTestData", method = RequestMethod.GET)
			dataType : "json",
			success : function(data) {
				success(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				error(XMLHttpRequest, textStatus, errorThrown);
			}
		});

	*/

	@RequestMapping(value = "getTestData", method = RequestMethod.GET)
	@ResponseBody
	public String[] getTestData(Model model){
		String[] datas = {"test1", "test2", "test3"};
		return datas;
	}
}

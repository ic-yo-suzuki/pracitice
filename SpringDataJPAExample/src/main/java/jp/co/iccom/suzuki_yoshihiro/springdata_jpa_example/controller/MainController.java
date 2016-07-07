package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.service.PersonService;

@Controller
public class MainController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/top/", method = RequestMethod.GET)
	public ModelAndView showMessage(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "登録者一覧");
		mav.addObject("personList", personService.getPersonList());
		mav.setViewName("top");

		return mav;
	}
}

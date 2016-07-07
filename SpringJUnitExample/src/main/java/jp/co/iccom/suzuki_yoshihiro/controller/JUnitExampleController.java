package jp.co.iccom.suzuki_yoshihiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.iccom.suzuki_yoshihiro.service.BatisDbConnectionTestService;

@Controller
public class JUnitExampleController {

	@Autowired
	BatisDbConnectionTestService batisDbConnectionTestService;

	@RequestMapping(value = "/top/", method = RequestMethod.GET)
	public ModelAndView showMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", batisDbConnectionTestService.getUser(46).getName());
		modelAndView.setViewName("showMessage");

		return modelAndView;

	}
}

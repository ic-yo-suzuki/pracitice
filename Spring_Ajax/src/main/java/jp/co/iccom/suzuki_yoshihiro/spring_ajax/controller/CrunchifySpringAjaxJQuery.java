package jp.co.iccom.suzuki_yoshihiro.spring_ajax.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CrunchifySpringAjaxJQuery {
	@RequestMapping("/ajax")
	public ModelAndView helloAjaxTest(){
		return new ModelAndView("ajax", "message", "Crunchify Spring MVC with Ajax and jQuery Demo..");
	}

	@RequestMapping(value =  "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody String getTime(){
		Random rand = new Random();
		float r = rand.nextFloat() * 100;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String result  = "<br> Next Random # is <b>" + r + "</b>. Generated on <b>" + sfd.format(c.getTime()) + "</b>.";
		System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller..");
		return result;
	}
}

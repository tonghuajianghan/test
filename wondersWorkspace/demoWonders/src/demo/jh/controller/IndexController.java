package demo.jh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class IndexController {

	@RequestMapping("/getIndex")
	public String getIndex(){
		return "page/index";
	}
}

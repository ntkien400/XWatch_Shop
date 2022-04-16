package XWatchShop.Controller.Admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.Service.Admin.AdHomeServiceImpl;
import XWatchShop.Service.User.HomeServiceImpl;

@Controller
public class AdBaseController {
	@Autowired
	AdHomeServiceImpl adHomeService;
	public ModelAndView mvShare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init() {
			
		return mvShare;
	}
	
}
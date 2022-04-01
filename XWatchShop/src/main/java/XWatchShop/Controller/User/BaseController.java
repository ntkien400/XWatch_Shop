package XWatchShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.Service.User.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl homeService;
	public ModelAndView mvShare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init() {
		mvShare.addObject("menus", homeService.GetDataMenus());
		mvShare.addObject("brands", homeService.GetDataBrands());
		return mvShare;
	}
}

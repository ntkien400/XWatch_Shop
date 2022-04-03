package XWatchShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.PaginatesDTO;
import XWatchShop.Service.User.HomeServiceImpl;
import XWatchShop.Service.User.PaginateServiceImpl;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	PaginateServiceImpl paginateService;
	public ModelAndView mvShare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init() {
		mvShare.addObject("menus", homeService.GetDataMenus());
		mvShare.addObject("brands", homeService.GetDataBrands());
		return mvShare;
	}
	
}

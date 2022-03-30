package XWatchShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrandController {
	@RequestMapping(value = "/thuong-hieu/{brandname}")
	public ModelAndView Brand(@PathVariable String brandname) {
		ModelAndView mv = new ModelAndView("User/product/brand");
		mv.addObject("brandname", brandname);
		return mv;
	}
}

package XWatchShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{productID}"})
	public ModelAndView Product(@PathVariable String productID) {
		mvShare.addObject("product", productService.GetProductByID(productID));
		mvShare.addObject("images", productService.GetImagesByID(productID));
		mvShare.addObject("products", productService.Get5Products());
		mvShare.setViewName("User/product/product");
		return mvShare;
	}
}

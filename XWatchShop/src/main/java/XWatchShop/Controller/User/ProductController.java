package XWatchShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.PaginatesDTO;
import XWatchShop.Service.User.PaginateServiceImpl;
import XWatchShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private PaginateServiceImpl paginateService;
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{productID}"})
	public ModelAndView Product(@PathVariable String productID) {
		mvShare.addObject("product", productService.GetProductByID(productID));
		mvShare.addObject("images", productService.GetImagesByID(productID));
		mvShare.addObject("products", productService.Get5Products());
		mvShare.setViewName("User/product/product");
		return mvShare;
	}
	@RequestMapping(value = "/dong-ho-nam")
	public ModelAndView MenWatches() {
		mvShare.setViewName("User/product/brand");
		mvShare.addObject("productsPaginate", productService.GetMenProducts());
		return mvShare;
	}
	@RequestMapping(value = "/dong-ho-nu")
	public ModelAndView WomenWatches() {
		mvShare.setViewName("User/product/brand");
		mvShare.addObject("productsPaginate", productService.GetWomenProducts());
		return mvShare;
	}
}

package XWatchShop.Controller.User;

import javax.management.ConstructorParameters;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.PaginatesDTO;

@Controller
public class HomeController extends BaseController {
	private int productsPerPage = 6;
	
	@RequestMapping(value = {"/","/home-page"})
	public ModelAndView Index() {
		mvShare.addObject("slide", homeService.GetDataSlide());
		mvShare.addObject("products", homeService.GetDataProducts());
		mvShare.addObject("newproducts", homeService.GetDataNewProducts());
		mvShare.addObject("highlight", homeService.GetDataProductsHighlight());
		mvShare.setViewName("User/index");
		return mvShare;
	}
	
	@RequestMapping(value={"/search"})
	public ModelAndView Search(@RequestParam("keyword") String keyword) {
		mvShare.addObject("search", homeService.SearchProducts(keyword));
		int totalData = homeService.SearchProducts(keyword).size();
		PaginatesDTO paginatesData = paginateService.GetPaginatesData(totalData, productsPerPage,1);
		mvShare.addObject("paginatesData",paginatesData);
		mvShare.addObject("keyword",keyword);
		mvShare.addObject("searchPaginate", homeService.SearchProductsPaginate(keyword, paginatesData.getStart(), productsPerPage));
		mvShare.setViewName("User/product/search");
		return mvShare;
	}
	@RequestMapping(value={"/search/{currentPage}"})
	public ModelAndView SearchPaginate(@RequestParam("keyword") String keyword, @PathVariable int currentPage) {
		mvShare.addObject("search", homeService.SearchProducts(keyword));
		int totalData = homeService.SearchProducts(keyword).size();
		PaginatesDTO paginatesData = paginateService.GetPaginatesData(totalData, 6,currentPage);
		mvShare.addObject("paginatesData",paginatesData);
		mvShare.addObject("searchPaginate", homeService.SearchProductsPaginate(keyword, paginatesData.getStart(), productsPerPage));
		mvShare.setViewName("User/product/search");
		return mvShare;
	}
	
}

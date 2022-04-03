package XWatchShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.PaginatesDTO;
import XWatchShop.Service.User.BrandServiceImpl;
import XWatchShop.Service.User.PaginateServiceImpl;

@Controller
public class BrandController extends BaseController {
	@Autowired
	private BrandServiceImpl brandService;
	@Autowired
	private PaginateServiceImpl paginateService;
	private int productsPerPage = 6;
	
	@RequestMapping(value = "/thuong-hieu/{brandname}")
	public ModelAndView Brand(@PathVariable String brandname) {
		mvShare.setViewName("User/product/brand");
		int totalData = brandService.GetAllProductsByID(brandname).size();
		PaginatesDTO paginatesData = paginateService.GetPaginatesData(totalData, productsPerPage,1);
		mvShare.addObject("brandName", brandname);
		mvShare.addObject("paginatesData",paginatesData);
		mvShare.addObject("productsPaginate", brandService.GetDataProductsPaginates(brandname, paginatesData.getStart(), productsPerPage));
		return mvShare;
	}
	
	@RequestMapping(value = "/thuong-hieu/{brandname}/{currentPage}")
	public ModelAndView Brand(@PathVariable String brandname, @PathVariable int currentPage ) {
		mvShare.setViewName("User/product/brand");
		int totalData = brandService.GetAllProductsByID(brandname).size();
		PaginatesDTO paginatesData = paginateService.GetPaginatesData(totalData, productsPerPage,currentPage);
		mvShare.addObject("brandName", brandname);
		mvShare.addObject("paginatesData",paginatesData);
		mvShare.addObject("productsPaginate", brandService.GetDataProductsPaginates(brandname, paginatesData.getStart(), productsPerPage));
		return mvShare;
	}
}

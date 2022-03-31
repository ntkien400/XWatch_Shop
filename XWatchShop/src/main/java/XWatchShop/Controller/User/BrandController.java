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
	
	@RequestMapping(value = "/thuong-hieu/{brandname}")
	public ModelAndView Brand(@PathVariable String brandname) {
		mvShare.setViewName("User/product/brand");
		int totalData = brandService.GetAllProductsByID(brandname).size();
		PaginatesDTO paginatesData = paginateService.GetPaginatesData(totalData, 9,1);
		mvShare.addObject("paginatesData",paginatesData);
		mvShare.addObject("productsPaginate", brandService.GetDataProductsPaginates(paginatesData.getStart(), paginatesData.getEnd()));
		return mvShare;
	}
}

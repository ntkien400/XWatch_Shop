package XWatchShop.Controller.Admin;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.PaginatesDTO;
import XWatchShop.DTO.ProductsDTO;
import XWatchShop.Entity.Users;

@Controller
@RequestMapping(value ="/admin")
public class AdHomeController extends AdBaseController {
	@RequestMapping(value ={"", "/*"})
	public String Check(@RequestParam(value = "message", required = false) String message, HttpSession session) {
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		if(loginInfo == null) {
			return "redirect:/dang-nhap";
		}
		if(loginInfo != null && loginInfo.isRole() == true) {
			return "/admin/list-product";
		}
		return "redirect:/403";
	}
	@RequestMapping(value ={"/list-product"})
	public ModelAndView Index(@RequestParam(value = "message", required = false) String message) {
		mvShare.setViewName("Admin/product/product");
		mvShare.addObject("products", adHomeService.GetAllProduct());
		mvShare.addObject("message", message);
		return mvShare;
	}
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public ModelAndView ProductDetailPage(@RequestParam(value = "message", required = false) String message) {
		mvShare.setViewName("Admin/product/addproduct");
		mvShare.addObject("products", adHomeService.GetAllProduct());
		mvShare.addObject("brands", adHomeService.GetAllBrands());
		mvShare.addObject("series", adHomeService.GetSeries());
		mvShare.addObject("product", new ProductsDTO());
		mvShare.addObject("message", message);
		return mvShare;
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String AddProduct(@ModelAttribute("product") ProductsDTO product, @RequestParam("imagename") MultipartFile images,
			HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		mvShare.setViewName("Admin/product/addproduct");
		product.setImage(images.getOriginalFilename()); 
		int count = adHomeService.AddProduct(product);
		if (count > 0) {
			try {
				String path = context.getRealPath("/assets/user/watch/" + images.getOriginalFilename());
				images.transferTo(new File(path));
			} catch (Exception e) {
				mvShare.addObject("status", "Lỗi lưu file!");
			}
			return "redirect:/admin/add-product?message=Add succesfully!";
		} 
		return "redirect:/admin/add-product?message=Add error!";
	}


	@RequestMapping(value = "/product-detail/{productID}", method =  RequestMethod.GET)
	public ModelAndView EditProductPage(@PathVariable("productID") String productID,
			@RequestParam(value = "message", required = false) String message) {
		mvShare.setViewName("Admin/product/editproduct");
		mvShare.addObject("product", adHomeService.getProductByID(productID)); 
		mvShare.addObject("brands", adHomeService.GetAllBrands());
		mvShare.addObject("series", adHomeService.GetSeries());
		mvShare.addObject("message", message);
		return mvShare;
	}
	@RequestMapping(value = "/product-detail/edit-product/{productID}",method = RequestMethod.POST)
	public String EditProduct(@ModelAttribute("product") ProductsDTO product, @RequestParam("imagename") MultipartFile images,
			@PathVariable("productID") String productID,HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		product.setImage(images.getOriginalFilename()); 
		int count = adHomeService.EditProduct(productID,product);
		if (count > 0) {
			try {
				String path = context.getRealPath("/assets/user/watch/" + images.getOriginalFilename());
				images.transferTo(new File(path));
			} catch (Exception e) {
				mvShare.addObject("status", "Lỗi lưu file!");
			}
			return "redirect:/admin/product-detail/" +productID+ "?message=Edit success!";
		} 
		return "redirect:/admin/product-detail/" +productID+ "?message=Edit error!";
	}
	@RequestMapping(value = "/delete-product/{productID}", method = RequestMethod.GET)
	public String DeleteProduct(@PathVariable("productID") String productID, HttpServletRequest request) {
		int count = adHomeService.DeleteProduct(productID);
		if(count >0) {
			return "redirect:/admin?message=Delete success!";
		}
		return "redirect:/admin?message=Delete error!";
	}
	@RequestMapping(value={"/search"})
	public ModelAndView Search(@RequestParam("keyword") String keyword) {
		mvShare.addObject("products", adHomeService.SearchProducts(keyword));
		mvShare.addObject("keyword",keyword);
		mvShare.setViewName("Admin/product/product");
		return mvShare;
	}
}
	

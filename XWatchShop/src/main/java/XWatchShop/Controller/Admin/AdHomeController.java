package XWatchShop.Controller.Admin;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.ProductsDTO;

@Controller
@RequestMapping(value ="/admin")
public class AdHomeController extends AdBaseController {
	@RequestMapping(value ="/")
	public ModelAndView Index() {
		mvShare.setViewName("Admin/product/product");
		mvShare.addObject("products", adHomeService.GetAllProduct());
		return mvShare;
	}
	@RequestMapping(value = "/product-detail", method = RequestMethod.GET)
	public ModelAndView ProductDetailPage() {
		mvShare.setViewName("Admin/product/addproduct");
		mvShare.addObject("products", adHomeService.GetAllProduct());
		mvShare.addObject("brands", adHomeService.GetAllBrands());
		mvShare.addObject("series", adHomeService.GetSeries());
		mvShare.addObject("product", new ProductsDTO());
		return mvShare;
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public ModelAndView AddProduct(@ModelAttribute("product") ProductsDTO product, @RequestParam("imagename") MultipartFile images,
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
			mvShare.addObject("status", "Thêm thành công");
		} else {
			mvShare.addObject("status", "Thêm thất bại");
		}
		return mvShare;
	}


	@RequestMapping(value = "/product-detail/{productID}", method =  RequestMethod.GET)
	public ModelAndView EditProductPage(@PathVariable("productID") String productID) {
		mvShare.setViewName("Admin/product/editproduct");
		mvShare.addObject("product", adHomeService.getProductByID(productID)); 
		mvShare.addObject("brands", adHomeService.GetAllBrands());
		mvShare.addObject("series", adHomeService.GetSeries());
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
			mvShare.addObject("status", "Thêm thành công");
		} else {
			mvShare.addObject("status", "Thêm thất bại");
		}
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value = "/delete-product/{productID}", method = RequestMethod.GET)
	public String DeleteProduct(@PathVariable("productID") String productID, HttpServletRequest request) {
		int count = adHomeService.DeleteProduct(productID);
		return  "redirect:"+request.getHeader("Referer");
	}
}
	

package XWatchShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.DTO.CartDTO;
import XWatchShop.Entity.Bills;
import XWatchShop.Entity.Users;
import XWatchShop.Service.User.BillServiceImpl;
import XWatchShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billService = new BillServiceImpl();
	
	@RequestMapping(value = "gio-hang", method = RequestMethod.GET)
	public ModelAndView Index() {
		mvShare.setViewName("User/cart/cart");
		return mvShare;
	}
	
	@RequestMapping(value = "add-cart/{productID}")
	public String AddCart(@RequestParam( value = "qty", required = false, defaultValue = "1") int qty, HttpSession session, @PathVariable String productID, HttpServletRequest request) {
		HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>)session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartService.AddCart(productID, qty, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("CartQty", cartService.TotalCartQuantity(cart));
		session.setAttribute("CartTotalPrice", cartService.TotalCartPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "edit-cart/{productID}/{qty}")
	public String EditCart( @PathVariable int qty, HttpSession session, @PathVariable String productID, HttpServletRequest request) {
		HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>)session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartService.EditCart(productID, qty, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("CartQty", cartService.TotalCartQuantity(cart));
		session.setAttribute("CartTotalPrice", cartService.TotalCartPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "delete-cart/{productID}")
	public String DeleteCart(HttpSession session, @PathVariable String productID, HttpServletRequest request) {
		HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>)session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartService.DeleteCart(productID, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("CartQty", cartService.TotalCartQuantity(cart));
		session.setAttribute("CartTotalPrice", cartService.TotalCartPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "thanh-toan", method = RequestMethod.GET)
	public ModelAndView CheckOutPage(HttpSession session, HttpServletRequest request) {
		mvShare.setViewName("User/bill/checkout");
		Bills bill = new Bills();
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		bill.setAddress(loginInfo.getAddress());
		bill.setDisplay_name(loginInfo.getLast_name()+ " "+ loginInfo.getFirst_name());
		bill.setPhone_number(loginInfo.getPhone_number());
		bill.setUserID(loginInfo.getUserID());
		mvShare.addObject("bill", bill);
		return mvShare;
	}
	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST)
	public String CheckOutBill(HttpSession session, HttpServletRequest request, @ModelAttribute("bill") Bills bill) {
		bill.setQuantity((Integer)session.getAttribute("CartQty"));
		bill.setTotal((Double)session.getAttribute("CartTotalPrice"));
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		if(billService.AddBill(bill) > 0) {
			HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>)session.getAttribute("ShoppingCart");
			billService.AddBillDetails(loginInfo.getUserID(), cart);
		}
		session.removeAttribute("ShoppingCart");
		session.removeAttribute("CartQty");
		session.removeAttribute("CartTotalPrice");
		return "redirect:gio-hang";
	}
}

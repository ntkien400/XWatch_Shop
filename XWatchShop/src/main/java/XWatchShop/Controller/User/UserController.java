package XWatchShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import XWatchShop.Entity.Users;
import XWatchShop.Service.User.UserServiceImpl;

@Controller
public class UserController extends BaseController  {
	@Autowired
	private UserServiceImpl userService = new UserServiceImpl();
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView RegisterPage() {
		mvShare.setViewName("User/account/register");
		mvShare.addObject("user", new Users());
		return mvShare;
	}
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateUser(@ModelAttribute("user") Users user) {
		int count = userService.AddUser(user);
		if(count > 0) {
			mvShare.addObject("statusRegister", "Đăng ký thành công!");
		}
		else {
			mvShare.addObject("statusRegister", "Đăng ký thất bại!");
		}
		mvShare.setViewName("User/account/register");
		return mvShare;
	}
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView LoginPage() {
		mvShare.setViewName("User/account/login");
		mvShare.addObject("user", new Users());
		return mvShare;
	}
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
		 user = userService.CheckAccount(user);
		if(user !=null) {
			mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		}
		else {
			mvShare.addObject("statusLogin", "Đăng nhập thất bại!");
		}
		return mvShare;
	}
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:"+request.getHeader("Referer");
	}
}

package XWatchShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import XWatchShop.DAO.CartDAO;
import XWatchShop.DTO.CartDTO;

public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDAO cartDAO;

	@Override
	public HashMap<String, CartDTO> AddCart(String productID, int quantity, HashMap<String, CartDTO> shoppingCart) {
		return cartDAO.AddCart(productID, quantity, shoppingCart);
	}

	@Override
	public HashMap<String, CartDTO> EditCart(String productID, int quantity, HashMap<String, CartDTO> shoppingCart) {
		return cartDAO.EditCart(productID, quantity, shoppingCart);
	}

	@Override
	public HashMap<String, CartDTO> DeleteCart(String productID, HashMap<String, CartDTO> shoppingCart) {
		return cartDAO.DeleteCart(productID, shoppingCart);
	}

	@Override
	public int TotalCartQuantity(HashMap<String, CartDTO> shoppingCart) {
		return cartDAO.TotalCartQuantity(shoppingCart);
	}

	@Override
	public double TotalCartPrice(HashMap<String, CartDTO> shoppingCart) {
		return cartDAO.TotalCartPrice(shoppingCart);
	}

}

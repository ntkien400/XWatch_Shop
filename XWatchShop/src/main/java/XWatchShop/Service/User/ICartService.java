package XWatchShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.CartDTO;

@Service
public interface ICartService {
	public HashMap<String, CartDTO> AddCart(String productID, int quantity, HashMap<String, CartDTO> shoppingCart);
	public HashMap<String, CartDTO> EditCart(String productID, int quantity, HashMap<String, CartDTO> shoppingCart);
	public HashMap<String, CartDTO> DeleteCart(String productID, HashMap<String, CartDTO> shoppingCart);
	public int TotalCartQuantity( HashMap<String, CartDTO> shoppingCart);
	public double TotalCartPrice( HashMap<String, CartDTO> shoppingCart);
}

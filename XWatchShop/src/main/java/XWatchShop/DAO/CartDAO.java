package XWatchShop.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import XWatchShop.DTO.CartDTO;
import XWatchShop.DTO.ProductsDTO;
import XWatchShop.Entity.MapperMenus;

@Repository
public class CartDAO extends BaseDAO {
	@Autowired
	ProductsDAO productsDAO = new ProductsDAO();
	
	public HashMap<String, CartDTO> AddCart(String productID, int quantity, HashMap<String, CartDTO> shoppingCart) {
		CartDTO itemCart = new CartDTO();
		ProductsDTO product = productsDAO.FindProductsByID(productID);
		if(product != null && !shoppingCart.containsKey(productID)) {
			itemCart.setProduct(product);
			itemCart.setQuantity(quantity);
			double totalPrice = product.getPrice() * quantity;
			itemCart.setTotalPrice(totalPrice);
		}
		if(shoppingCart.containsKey(productID)) {
			itemCart = shoppingCart.get(productID);
			itemCart.setQuantity(itemCart.getQuantity() + quantity);
		}
		shoppingCart.put(productID, itemCart);
		return shoppingCart;
	}
	
	public HashMap<String, CartDTO> EditCart(String productID, int quantity, HashMap<String, CartDTO> shoppingCart) {
		if(shoppingCart == null) {
			return shoppingCart;
		}
		CartDTO itemCart = new CartDTO();
		if(shoppingCart.containsKey(productID)) {
			itemCart = shoppingCart.get(productID);
			itemCart.setQuantity(quantity);
			double totalPrice = itemCart.getProduct().getPrice() * quantity;
			itemCart.setTotalPrice(totalPrice);
		}
		shoppingCart.put(productID, itemCart);
		return shoppingCart;
	}
	
	public HashMap<String, CartDTO> DeleteCart(String productID, HashMap<String, CartDTO> shoppingCart) {
		if(shoppingCart == null) {
			return shoppingCart;
		}
		if(shoppingCart.containsKey(productID)) {
			shoppingCart.remove(productID);
		}
		return shoppingCart;
	}
	public int TotalCartQuantity( HashMap<String, CartDTO> shoppingCart){
		int totalQuantity =0;
		for(Map.Entry<String, CartDTO> itemCart : shoppingCart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	public double TotalCartPrice( HashMap<String, CartDTO> shoppingCart){
		double totalPrice =0;
		for(Map.Entry<String, CartDTO> itemCart : shoppingCart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}

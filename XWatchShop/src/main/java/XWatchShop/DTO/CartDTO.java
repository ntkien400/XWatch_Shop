package XWatchShop.DTO;

import java.util.Date;

public class CartDTO {
	private String userID;
	private Date created_at;
	private int quantity;
	private double totalPrice;
	private ProductsDTO product;
	
	
	
	public CartDTO() {
		
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public CartDTO(int quantity, double totalPrice, ProductsDTO product) {
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductsDTO getProduct() {
		return product;
	}
	public void setProduct(ProductsDTO product) {
		this.product = product;
	}
}

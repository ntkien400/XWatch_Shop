package XWatchShop.DTO;

public class CartDTO {
	private int quantity;
	private double totalPrice;
	private ProductsDTO product;
	
	
	
	public CartDTO() {
		
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

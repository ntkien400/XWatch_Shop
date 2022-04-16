package XWatchShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.ProductsDTO;
import XWatchShop.Entity.Brands;
import XWatchShop.Entity.Series;

@Service
public interface IAdHomeService {
	public List<ProductsDTO> GetAllProduct();
	public List<Brands> GetAllBrands();
	public List<Series> GetSeries();
	public int AddProduct(ProductsDTO products);
	public ProductsDTO getProductByID(String productID);
	public int EditProduct(String productID, ProductsDTO products );
	public int DeleteProduct(String productID);
}

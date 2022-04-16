package XWatchShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DAO.ProductsDAO;
import XWatchShop.DTO.ProductsDTO;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductsDAO productsDAO;
	
	@Override
	public ProductsDTO GetProductByID(String productID) {
		ProductsDTO Product = productsDAO.GetProductByID(productID);
		return Product;
	}

	@Override
	public List<ProductsDTO> GetImagesByID(String productID) {
		List<ProductsDTO> listProducts = productsDAO.GetImagesByID(productID);
		return listProducts;
	}

	@Override
	public List<ProductsDTO> Get5Products() {
		List<ProductsDTO> listProducts = productsDAO.Get5Products();
		return listProducts;
	}
	
}

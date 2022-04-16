package XWatchShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DAO.BrandsDAO;
import XWatchShop.DAO.ProductsDAO;
import XWatchShop.DTO.ProductsDTO;
import XWatchShop.Entity.Brands;
import XWatchShop.Entity.Series;

@Service
public class AdHomeServiceImpl implements IAdHomeService {
	@Autowired
	private ProductsDAO productsDAO;
	@Autowired
	private BrandsDAO brandsDAO;
	@Override
	public List<ProductsDTO> GetAllProduct() {
		List<ProductsDTO> listProducts = productsDAO.GetAllProducts();
		return listProducts;
	}
	@Override
	public List<Brands> GetAllBrands() {
		List<Brands> listBrands = brandsDAO.GetDataBrands();
		return listBrands;
	}
	@Override
	public List<Series> GetSeries() {
		List<Series> listSeries = brandsDAO.GetSeries();
		return listSeries;
	}
	@Override
	public int AddProduct(ProductsDTO products) {
		return productsDAO.AddProduct(products);
	}
	@Override
	public ProductsDTO getProductByID(String productID) {
		return productsDAO.GetProductByID(productID);
	}
	@Override
	public int EditProduct(String productID, ProductsDTO products) {
		return productsDAO.EditProduct(productID,products);
	}
	@Override
	public int DeleteProduct(String productID) {
		return productsDAO.DeleteProduct(productID);
	}
	
}

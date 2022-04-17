package XWatchShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.ProductsDTO;

@Service
public interface IProductService {
	public ProductsDTO GetProductByID(String productID);
	public List<ProductsDTO> GetImagesByID(String productID);
	public List<ProductsDTO> Get5Products();
	public List<ProductsDTO> GetMenProducts();
	public List<ProductsDTO> GetWomenProducts();
}

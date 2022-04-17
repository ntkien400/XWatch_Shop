package XWatchShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DAO.ProductsDAO;
import XWatchShop.DTO.ProductsDTO;

@Service
public class BrandServiceImpl implements IBrandService {
	@Autowired
	private ProductsDAO productsDAO;
	
	@Override
	public List<ProductsDTO> GetAllProductsByID(String brandName) {
		List<ProductsDTO> productsDTOs = productsDAO.GetAllProductsByID(brandName);
		return productsDTOs;
	}
	
	public List<ProductsDTO> GetDataProductsPaginates(String brandName, int start, int productsPerPage){
		List<ProductsDTO> productsDTOs = productsDAO.GetBrandDataProductsPaginates(brandName, start, productsPerPage);
		return productsDTOs;
	}

}

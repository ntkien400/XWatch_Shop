package XWatchShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DTO.ProductsDTO;
import XWatchShop.Entity.Brands;
import XWatchShop.Entity.Menus;
import XWatchShop.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Brands> GetDataBrands();
	public List<Menus> GetDataMenus();
	public List<ProductsDTO> GetDataProducts();
	public List<ProductsDTO> GetDataNewProducts();
	public List<ProductsDTO> GetDataProductsHighlight();
}

package XWatchShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XWatchShop.DAO.BrandsDAO;
import XWatchShop.DAO.MenusDAO;
import XWatchShop.DAO.ProductsDAO;
import XWatchShop.DAO.SlidesDAO;
import XWatchShop.DTO.ProductsDTO;
import XWatchShop.Entity.Brands;
import XWatchShop.Entity.Menus;
import XWatchShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private SlidesDAO slidesDAO;
	@Autowired
	private BrandsDAO brandsDAO;
	@Autowired
	private MenusDAO menusDAO;
	@Autowired
	private ProductsDAO productsDAO;
	
	@Override
	public List<Slides> GetDataSlide() {
		return slidesDAO.GetDataSlide();
	}
	@Override
	public List<Brands> GetDataBrands() {
		return brandsDAO.GetDataBrands();
	}
	@Override
	public List<Menus> GetDataMenus() {
		return menusDAO.GetDataMenus();
	}
	@Override
	public List<ProductsDTO> GetDataProducts() {
		List<ProductsDTO> listProducts = productsDAO.GetDataProducts();
		return listProducts;
	}
	@Override
	public List<ProductsDTO> GetDataNewProducts() {
		List<ProductsDTO> listProducts = productsDAO.GetDataNewProducts();
		return listProducts;
	}
	@Override
	public List<ProductsDTO> GetDataProductsHighlight() {
		List<ProductsDTO> listProducts = productsDAO.GetDataProductsHighlight();
		return listProducts;
	}
}

package XWatchShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import XWatchShop.DTO.ProductsDTO;

@Service
public interface IBrandService {
	public List<ProductsDTO> GetAllProductsByID(String brandName);
	public List<ProductsDTO> GetDataProductsPaginates(int start, int end);
}

package XWatchShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import XWatchShop.DTO.ProductsDTO;
import XWatchShop.DTO.ProductsDTOMapper;
@Repository
public class ProductsDAO extends BaseDAO{
	
	private String SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.productID, ");
		sql.append("p.seriesID, ");
		sql.append("p.brandID, ");
		sql.append("p.name, ");
		sql.append("p.price, ");
		sql.append("p.glass, ");
		sql.append("p.strap_material, ");
		sql.append("p.water_resistant, ");
		sql.append("p.color, ");
		sql.append("p.sale, ");
		sql.append("p.highlight, ");
		sql.append("p.new_product, ");
		sql.append("p.title, ");
		sql.append("p.detail, ");
		sql.append("i.imageID, ");
		sql.append("i.image_name, ");
		sql.append("p.created_at, ");
		sql.append("p.updated_at ");
		sql.append("FROM products AS p INNER JOIN images AS i ");
		sql.append("ON p.productID = i.productID ");
		sql.append("GROUP By p.productID, i.productID");
		return sql.toString();
	}
	public List<ProductsDTO> GetDataProducts(){
		String sql = SqlString();
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
}

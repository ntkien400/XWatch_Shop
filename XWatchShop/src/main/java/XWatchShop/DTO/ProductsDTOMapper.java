package XWatchShop.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDTOMapper implements RowMapper<ProductsDTO> {

	@Override
	public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDTO productsDTO = new ProductsDTO();
		productsDTO.setProductID(rs.getString("productID"));
		productsDTO.setSeriesID(rs.getInt("seriesID"));
		productsDTO.setBrandID(rs.getInt("brandID"));
		productsDTO.setName(rs.getString("name"));
		productsDTO.setPrice(rs.getDouble("price"));
		productsDTO.setGlass(rs.getString("glass"));
		productsDTO.setStrap_material(rs.getString("strap_material"));
		productsDTO.setWater_resistant(rs.getInt("water_resistant"));
		productsDTO.setColor(rs.getString("color"));
		productsDTO.setAmount(rs.getInt("amount"));
		productsDTO.setGender(rs.getInt("gender"));
		productsDTO.setSale(rs.getInt("sale"));
		productsDTO.setHighlight(rs.getBoolean("highlight"));
		productsDTO.setNew_product(rs.getBoolean("new_product"));
		productsDTO.setTitle(rs.getString("title"));
		productsDTO.setDetail(rs.getString("detail"));
		productsDTO.setImageID(rs.getInt("imageID"));
		productsDTO.setImage_name(rs.getString("image_name"));
		productsDTO.setCreated_at(rs.getDate("created_at"));
		productsDTO.setUpdated_at(rs.getDate("updated_at"));
		return productsDTO;
	}

}

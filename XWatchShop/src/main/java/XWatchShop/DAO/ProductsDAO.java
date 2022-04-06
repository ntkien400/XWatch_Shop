package XWatchShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import XWatchShop.DTO.ProductsDTO;
import XWatchShop.DTO.ProductsDTOMapper;
@Repository
public class ProductsDAO extends BaseDAO{
	
	private StringBuffer SqlString() {
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
		sql.append("p.amount, ");
		sql.append("p.gender, ");
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
		return sql;
	}
	
	private StringBuffer SqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer  sql = SqlString();
		if(newProduct) {
			sql.append("WHERE p.new_product = true ");
		}
		if(highLight) {
			sql.append("AND p.highlight = true ");
		}
		sql.append("GROUP By p.productID, i.productID ");
		sql.append("ORDER BY RAND() ");
		return sql;
	}
	private String SqlBrandIDByName(String brandName) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("b.brandID ");
		sql.append("FROM brands AS b ");
		sql.append("WHERE b.brandname = '" + brandName +"'" + " ");
		return sql.toString();
	}
	private StringBuffer SqlProductsByID(int brandID) {
		StringBuffer  sql = SqlString();
		sql.append("WHERE 1=1 ");
		sql.append("AND brandID = " + brandID+" ");
		sql.append("GROUP By p.productID, i.productID ");
		return sql;
	}
	private String SqlLimitProductsPaginates(int brandID, int start, int totalPage) {
		StringBuffer  sql = SqlProductsByID(brandID);
		sql.append("LIMIT "+ start +", "+totalPage+" ");
		return sql.toString();
	}
	private String SqlProductByID(String productID) {
		StringBuffer  sql = SqlString();
		sql.append("WHERE 1=1 ");
		sql.append("AND p.productID = '" + productID+"' ");
		return sql.toString();
	}
	private String SqlGetImagesByID(String productID) {
		StringBuffer  sql = SqlString();
		sql.append("WHERE p.productID = '" + productID +"'" + " ");
		return sql.toString();
	}

//	----------Get Data Function-------------
	public List<ProductsDTO> GetImagesByID(String productID){
		String sql = SqlGetImagesByID(productID);
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetProductByID(String productID){
		String sql = SqlProductByID(productID);
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetDataProducts(){
		String sql = SqlProducts(true, true).toString();
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetDataNewProducts(){
		String sql = SqlProducts(true, false).toString();
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetDataProductsHighlight(){
		String sql = SqlProducts(false, true).toString();
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public int BrandIDByName(String brandName) {
		String sql = SqlBrandIDByName(brandName);
		int brandID = jdbcTemplate.queryForObject(sql, Integer.class);
		return brandID;
	}
	public List<ProductsDTO> GetAllProductsByID(String brandName){
		int brandID = BrandIDByName(brandName);
		String sql = SqlProductsByID(brandID).toString();
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetAllProducts(){
		StringBuffer sql = SqlProducts(false, false);
		sql.append("LIMIT 5");
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetDataProductsPaginates(String brandName, int start, int productsPerPage){
		int brandID = BrandIDByName(brandName);
		String sql = SqlLimitProductsPaginates(brandID,start, productsPerPage);
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	public List<ProductsDTO> SearchProducts(String keyword ) {
		StringBuffer sql = SqlProducts(false, false);
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		sql.append("LIMIT 0");
		List<ProductsDTO> list = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		for (ProductsDTO productsDTO : listProducts) {
			if(productsDTO.getName().toLowerCase().contains(keyword.toLowerCase()) == true ) {
				list.add(productsDTO);
			}
		}
		return list;
	}
	public List<ProductsDTO> SearchProductsPaginate(String keyword, int start, int productsPerPage ) {
		StringBuffer sql = SqlProducts(false, false);
		List<ProductsDTO> listProducts = SearchProducts(keyword);
		sql.append("LIMIT 0");
		List<ProductsDTO> listSearch = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		if((start+productsPerPage) <= listProducts.size()) {
			for( int i= start; i< (start + productsPerPage); i++) {
				listSearch.add(listProducts.get(i));
			}
		}
		if((start+productsPerPage) > listProducts.size()) {
			for( int i= start; i< listProducts.size(); i++) {
				listSearch.add(listProducts.get(i));
			}
		}
		return listSearch;
	}
	
	public ProductsDTO FindProductsByID(String productID) {
		String sql = SqlProductByID(productID);
		ProductsDTO product = jdbcTemplate.queryForObject(sql, new ProductsDTOMapper());
		return product;
	}
}

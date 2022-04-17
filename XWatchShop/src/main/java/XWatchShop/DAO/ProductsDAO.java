package XWatchShop.DAO;

import java.time.LocalDateTime;
import java.util.List;

import javax.lang.model.element.UnknownAnnotationValueException;

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
		sql.append("b.brandname, ");
		sql.append("s.seriesname, ");
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
		sql.append("p.image, ");
		sql.append("p.created_at, ");
		sql.append("p.updated_at ");
		sql.append("FROM products AS p  ");
		sql.append("INNER JOIN brands as b ON p.brandID = b.brandID ");
		sql.append("INNER JOIN series as s ON p.seriesID = s.seriesID ");
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
		sql.append("GROUP By p.productID, b.brandID, s.seriesID ");
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
		sql.append("AND p.brandID = " + brandID+" ");
		sql.append("GROUP By p.productID, b.brandID, s.seriesID ");
		return sql;
	}
	private String SqlBrandLimitProductsPaginates(int brandID, int start, int totalPage) {
		StringBuffer  sql = SqlProductsByID(brandID);
		sql.append("LIMIT "+ start +", "+totalPage+" ");
		return sql.toString();
	}
	
	private String SqlProductByID(String productID) {
		StringBuffer  sql = SqlString();
		sql.append("WHERE 1=1 ");
		sql.append("AND p.productID = '" + productID+"' ");
		sql.append("GROUP By p.productID, b.brandID, s.seriesID ");
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
	public ProductsDTO GetProductByID(String productID){
		String sql = SqlProductByID(productID);
		ProductsDTO Product = jdbcTemplate.queryForObject(sql, new ProductsDTOMapper());
		return Product;
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
	public String BrandNameByID(int brandID) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT brandname ");
		sql.append("FROM brands ");
		sql.append("WHERE brandID = " + brandID+" ");
		String brandName = jdbcTemplate.queryForObject(sql.toString(), String.class);
		return brandName;
	}
	public List<ProductsDTO> GetAllProductsByID(String brandName){
		int brandID = BrandIDByName(brandName);
		String sql = SqlProductsByID(brandID).toString();
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> Get5Products(){
		StringBuffer sql = SqlProducts(false, false);
		sql.append("LIMIT 5");
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetAllProducts(){
		StringBuffer sql = SqlString();
		sql.append("GROUP By p.productID, b.brandID, s.seriesID ");
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetAllMenProducts(){
		StringBuffer sql = SqlString();
		sql.append("WHERE p.gender = 1 ");
		sql.append("GROUP By p.productID, b.brandID, s.seriesID ");
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetAllWomenProducts(){
		StringBuffer sql = SqlString();
		sql.append("WHERE p.gender = 0 ");
		sql.append("GROUP By p.productID, b.brandID, s.seriesID ");
		List<ProductsDTO> listProducts = jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return listProducts;
	}
	public List<ProductsDTO> GetBrandDataProductsPaginates(String brandName, int start, int productsPerPage){
		int brandID = BrandIDByName(brandName);
		String sql = SqlBrandLimitProductsPaginates(brandID,start, productsPerPage);
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
	public int AddProduct(ProductsDTO product) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO products");
		sql.append("( productID");
		sql.append(", brandID");
		sql.append(", seriesID");
		sql.append(", name");
		sql.append(", price");
		sql.append(", glass");
		sql.append(", strap_material");
		sql.append(", water_resistant");
		sql.append(", color");
		sql.append(", amount");
		sql.append(", sale");
		sql.append(", highlight");
		sql.append(", new_product");
		sql.append(", gender");
		sql.append(", image");
		sql.append(", title");
		sql.append(", detail ");
		sql.append(", created_at ");
		sql.append(", updated_at )");
		sql.append("VALUES ");
		sql.append("( '"+product.getProductID()+"', ");
		sql.append(product.getBrandID()+", ");
		sql.append(product.getSeriesID()+", ");
		sql.append(" '"+product.getName()+"', ");
		sql.append(product.getPrice()+", ");
		sql.append(" '"+product.getGlass()+"', ");
		sql.append(" '"+product.getStrap_material()+"', ");
		sql.append(product.getWater_resistant()+", ");
		sql.append(" '"+product.getColor()+"', ");
		sql.append(product.getAmount()+", ");
		sql.append(product.getSale()+", ");
		sql.append(product.isHighlight()+", ");
		sql.append(product.isNew_product()+", ");
		sql.append(product.getGender()+", ");
		sql.append(" '"+product.getImage()+"', ");
		sql.append(" '"+product.getTitle()+"', ");
		sql.append(" '"+product.getDetail()+"', ");
		sql.append(" now(), ");
		sql.append(" now() )");
		int count = jdbcTemplate.update(sql.toString());
		return count;
		
	}
	public int EditProduct(String productID, ProductsDTO product) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE products SET");
		sql.append(" productID ='"+product.getProductID()+"'");
		sql.append(", brandID ="+product.getBrandID());
		sql.append(", seriesID ="+product.getSeriesID());
		sql.append(", name ='"+product.getName()+"'");
		sql.append(", price ="+product.getPrice());
		sql.append(", glass ='"+product.getGlass()+"'");
		sql.append(", strap_material ='"+product.getStrap_material()+"'");
		sql.append(", water_resistant ='"+product.getWater_resistant()+"'");
		sql.append(", color ='"+product.getColor()+"'");
		sql.append(", amount ="+product.getAmount());
		sql.append(", sale ="+product.getSale());
		sql.append(", highlight ="+product.isHighlight());
		sql.append(", new_product ="+product.isNew_product());
		sql.append(", gender ="+product.getGender());
		if(product.getImage()!="") {
			sql.append(", image ='"+product.getImage()+"'");
		}
		sql.append(", title ='"+product.getTitle()+"'");
		sql.append(", detail ='"+product.getDetail()+"'");
		sql.append(", updated_at = now()");
		sql.append("WHERE products.productID ='"+productID+"' ");
		int count = jdbcTemplate.update(sql.toString());
		return count;
		
	}
	public int DeleteProduct(String productID) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM products ");
		sql.append("WHERE products.productID ='"+productID+"'");
		int count = jdbcTemplate.update(sql.toString());
		return count;
	}
}

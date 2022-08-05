
public class Products {

	int id;
	String goods;
	int price;
	int stock;
	
	public Products(int id, String goods, int price, int stock) {
		super();
		this.id = id;
		this.goods = goods;
		this.price = price;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}

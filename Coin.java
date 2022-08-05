
public class Coin {

	int id;
	int money;
	int stock;
	
	
	public Coin(int id, int money, int stock) {
		super();
		this.id = id;
		this.money = money;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}

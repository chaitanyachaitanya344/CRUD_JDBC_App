package model;

public class product {
	private int prodid;
	private String proname;
	private int minimumsellingQuantity;
	private int price;
	private int quantity;
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getMinimumsellingQuantity() {
		return minimumsellingQuantity;
	}
	public void setMinimumsellingQuantity(int minimumsellingQuantity) {
		this.minimumsellingQuantity = minimumsellingQuantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

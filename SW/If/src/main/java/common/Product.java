package common;

public class Product {
	private String name;
	private String type;
	private String seller;
	private Double price;
	private String comment;
	
	
	public Product() {}
	
	public Product(String name, String type, String seller, Double price, String comment) {
		super();
		this.name = name;
		this.type = type;
		this.seller = seller;
		this.price = price;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
	public String getSeller() {
		return seller;
	}

	public Double getPrice() {
		return price;
	}

	public String getComment() {
		return comment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getInfo() {
		return "Product { name : " + name 
		+ ", type : " + type
		+ ", seller : " + seller
		+ ", price : " + price
		+ ", comment : " + comment + "}";
	}
}

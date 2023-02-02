package model;

public class ModelProductList {
	private int productCode;
	private String image;
	private String productName;
	private String manufacturer;
	private boolean status;
	private double price;
	private int amount;
	private int likes;
	
	public ModelProductList() {
		// TODO Auto-generated constructor stub
	}

	public ModelProductList(int productCode, String image, String productName, String manufacturer, boolean status,
			double price, int amount, int likes) {
		this.productCode = productCode;
		this.image = image;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.status = status;
		this.price = price;
		this.amount = amount;
		this.likes = likes;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
}

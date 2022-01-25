package com.company.app.products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Product")
public class Product {
	@Id
	private Long idProduct;
	private String name;
	private Double price;
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [idProduct=");
		builder.append(idProduct);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

	
}

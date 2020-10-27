package com.example.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.course.entities.pk.OrderItemPK;

//usar o Serializable para que os objetos possam trafegar na rede
//annotation
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//atributos
	@EmbeddedId
	private OrderItemPK id;
	private Integer quantaty;
	private Double price;
	
	//construtor padrão
	public OrderItem() {
	}

	//construtor com argumentos
	public OrderItem(Order order, Product product, Integer quantaty, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantaty = quantaty;
		this.price = price;
	}

	//getters and Setters
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantaty() {
		return quantaty;
	}

	public void setQuantaty(Integer quantaty) {
		this.quantaty = quantaty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	//hashCode and equals para comparar objetos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

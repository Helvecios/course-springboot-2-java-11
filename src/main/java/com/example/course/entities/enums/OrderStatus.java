package com.example.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	//atributo
	private int code;
	
	//Construtor padrão
	private OrderStatus (int code) {
		this.code = code;
	}
	
	//método para o "code" ficar acessível a outras classes 
	public int getCode() {
		return code;
	}
	
	//método estático para converter um valor numérico para um tipo numerado
	//método estático (não precisa ser instanciado para funcionar)
	public static OrderStatus valueOf (int code) {
		for (OrderStatus value : OrderStatus.values()) { //percorre todos os valores do OrderStatus
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}

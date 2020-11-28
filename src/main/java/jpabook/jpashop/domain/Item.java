package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 주문 입장에선 어떤 상품에 의해 주문이 되었는지 중요하다.
// 상품 입장에선 어떤 주문에 의해 상품되어 있는지 그닥 중요하지 않다 -> 상품을 보고 역방향으로 연관관게를 찾아갈만큼 중요하진 않음. (주문서를 보고 아이템을 찾지, 아이템을 보고 어떤 주문서에서 주문이 되었나 찾진 않음)
@Entity
public class Item {
	
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	

}

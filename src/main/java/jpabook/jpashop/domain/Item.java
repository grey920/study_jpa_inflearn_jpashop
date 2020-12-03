package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
/*
 * 1. Item이 단독으로 쓰일 일이 있나 없나를 생각해야 한다
 * 	- 없으면 추상 클래스로 만든다.
 * 2. 상속관계 매핑 전략을 명시. 
 *  - @Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
 * */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 싱글테이블 전략
@DiscriminatorColumn
public abstract class Item extends BaseEntity{
	
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
	/* 양방향 매핑 */
	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<Category>();
	
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

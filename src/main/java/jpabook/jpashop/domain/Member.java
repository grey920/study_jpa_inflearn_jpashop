package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Member extends BaseEntity {
	
	@Id @GeneratedValue//auto
	@Column(name="MEMBER_ID") // 대문자? -> 회사마다 룰이 다름 (우리회사는 소문자)
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	/* 잘못된 설계지만 예시니까 사용한 것. Member를 보고 orders를 꺼낼 일이 거의 없다. 필요하면 order를 따로 조회하는 것이 맞다. 비즈니스 상 끊어주는게 더 깔끔함*/
	// 그래도 예를 들어 Order와 양방향 매핑을 한다면
	@OneToMany(mappedBy = "member") //Order 엔티티에 있는 member
	private List<Order> orders = new ArrayList<Order>();
	
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}

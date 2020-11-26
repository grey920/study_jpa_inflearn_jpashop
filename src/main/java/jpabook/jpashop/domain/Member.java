package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
public class Member {
	
	@Id @GeneratedValue//auto
	@Column(name="MEMBER_ID") // 대문자? -> 회사마다 룰이 다름 (우리회사는 소문자)
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	/* getter, setter
	 * 꼭 다 만들 필요는 없는데 getter는 가급적 만들어주는게 좋고 setter는 고민할 필요가 있음
	 * - setter를 막 만들면 아무곳에서 set 할 수 있으니까 코드를 추적하기 어렵다 -> 유지보수성이 떨어진다
	 * => 생성자를 이용해서 값을 셋팅하고 setter를 최소화하는 것이 좋다 */
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

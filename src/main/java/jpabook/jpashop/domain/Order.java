package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS") // 테이블명이 ORDER가 예약어로 걸려있는 경우가 많아서 ORDERS로 지정
public class Order {
	
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	@ManyToOne // 주문 입장에선 나를 주문한 회원은 하나! //회원 입장에선 하나의 회원이 주문을 여러번 한다.
	@JoinColumn(name = "MEMBER_ID") // 이렇게하면 단방향 매핑을 끝남. 가급적 단방향에서 끝내자. 만약 양방향 매핑을 하고싶다면, Member에서 컬렉션 List<Order>를 추가한다
	private Member member;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING) //enum타입
	private OrderStatus status;

	// 연관관계 편의 메소드 생성
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem); // 넘어온 주문서를 추가 
		orderItem.setOrder(this); // 현재 오더를 넣어서 양방향 연관관계가 딱 걸리게!
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	

}

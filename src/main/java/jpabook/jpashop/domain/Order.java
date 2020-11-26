package jpabook.jpashop.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS") // 테이블명이 ORDER가 예약어로 걸려있는 경우가 많아서 ORDERS로 지정
public class Order {
	
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	// 관계형 디비에 맞춘 설계
	@Column(name = "MEMBER_ID")
	private Long memberId;
	
	// Order를 주문한 Member가 누군지 찾으려면
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING) //enum타입
	private OrderStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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

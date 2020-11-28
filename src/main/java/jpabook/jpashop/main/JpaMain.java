package jpabook.jpashop.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			/* 주문해야 한다면 */
			// 주문 생성
			Order order = new Order();
			//order.addOrderItem(new OrderItem());
			
			// 양방향 연관관계를 만들지 않아도 주문서 만들어서 set으로 주문 넣어도 된다.
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			
			em.persist(orderItem);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}

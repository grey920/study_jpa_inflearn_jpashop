package jpabook.jpashop.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
/*	데이터 중심 설계의 문제점
 *  - 현재 방식은 객체 설계를 테이블 설계에 맞춘 방식
 *  - 테이블의 외래키를 객체에 그대로 가져옴
 *  - 객체 그래프 탐색이 불가능
 *  - 참조가 없으므로 UML도 잘못됨
 *  (memberId를 가지는게 아니라 진짜 Member를 가지는 것)
 * */
public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			// 객체지향스럽지 못한 방법
			Order order = em.find(Order.class, 1L);
			Long memberId = order.getMemberId();
			
			Member member = em.find(Member.class, memberId);
			
			// 객체그래프 참조로 쭉쭉 찾아가는 방법
			Member findMember = order.getMember();
			

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}

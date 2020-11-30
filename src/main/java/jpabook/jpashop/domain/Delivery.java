package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

	@Id @GeneratedValue
	private Long id;
	
	private String city;
	private String street;
	private String zipcode;
	private DeliveryStatus status;
	
	/*Order와 양방향으로 간다면..
	 *: 어떤 주문에 의해 배송된건지 알고싶을 떄 */
	@OneToOne(mappedBy = "delivery")
	private Order order;
}

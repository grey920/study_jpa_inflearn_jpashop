package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends BaseEntity {
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	/*카테고리*/
	// 상위 카테고리
	@ManyToOne // 자식 입장에선 부모가 하나
	@JoinColumn(name = "PARENT_ID")
	private Category parent;
	
	// 자식 카테고리. 양방향으로 셀프로 잡힌 것. 
	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<Category>();
	
	/*Item과 다대다 관계
	 * : 하나의 카테고리에 여러 아이템이 있고, 한 아이템이 여러 카테고리로 들어갈 수 있다.  */
	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM", // 중간 테이블 만드는 것
		joinColumns = @JoinColumn(name ="CATEGORY_ID"),
		inverseJoinColumns = @JoinColumn(name ="ITEM_ID")
			)
	private List<Item> items = new ArrayList<Item>();
}

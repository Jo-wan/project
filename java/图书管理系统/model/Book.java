package bookmanage.model;

/**
 * 图书实体类
 */
public class Book {
	private String id;			//图书编号
	private String name;		//图书名称
	private int num;			//数量
	private float price;		//价格
	
	//无参构造方法
	public Book() {
		super();
	}
	
	//全参构造方法
	public Book(String id, String name, int num, float price) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}

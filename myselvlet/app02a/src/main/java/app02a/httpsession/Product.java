package app02a.httpsession;
/**
 * 类说明：商品实体类
 * @Author fatcat
 * @date 2018-08-08
 */
public class Product {
	/** 商品Id */
	private int id;
	/** 商品名称 */
	private String name;
	/** 商品描述 */
	private String description;
	/** 商品价格 */
	private float price;

    /**
     * [商品构造方法]
     * @param  id          [商品Id]
     * @param  name        [商品名称]
     * @param  description [商品描述]
     * @param  price       [商品价格]
     * @return             [无]
     */
    public Product(int id, String name, String description, float price) {
    	this.id = id;
    	this.name = name;
    	this.description = description;
    	this.price = price;
    }
    /** [商品Id ] */
    public int getId() {
    	return id;
    }
    /** 商品Id */
    public void setId(int id) {
    	this.id = id;
    }
    /** 商品名称 */
    public String getName() {
    	return name;
    }
    /** 商品名称 */
    public void setName(String name) {
    	this.name = name;
    }
    /** 商品描述 */
    public String getDescription() {
    	return description;
    }
    /** 商品描述 */
    public void setDescription(String description) {
    	this.description = description;
    }
    /** 商品价格 */
    public float getPrice() {
    	return price;
    }
    /** 商品价格 */
    public void setPrice(float price) {
    	this.price = price;
    }
}

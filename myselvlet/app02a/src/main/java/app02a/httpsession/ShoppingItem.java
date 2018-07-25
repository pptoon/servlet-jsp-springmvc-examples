package app02a.httpsession;
/**
 * 类说明：购物车中商品信息（商品名称和数量）
 * @Author fatcat
 * @date 2018-08-08
 */
public class ShoppingItem {

	/** 商品 */
	private Product product;
	/** 数量 */
	private int quantity;
	/**
	 * [购物车商品信息构造方法]
	 * @param  product  [商品]
	 * @param  quantity [数量]
	 * @return          [无]
	 */
	public ShoppingItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	/** 商品 */
	public Product getProduct() {
		return product;
	}
	/** 商品 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/** 数量 */
	public int getQuantity() {
		return quantity;
	}
	/** 数量 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

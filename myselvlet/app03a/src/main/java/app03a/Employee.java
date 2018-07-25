package app03a;

/**
 * @author fatcat
 * @date 2018年6月29日下午3:51:25
 */
public class Employee {
	/** 员工编号 */
	private String id;
	/** 名字 */
	private String firstName;
	/** 姓氏 */
	private String lastName;

	/**
	 * @return 员工编号
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            员工编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 名字
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            名字
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return 姓氏
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            姓氏
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

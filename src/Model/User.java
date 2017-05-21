package Model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User> {

	private int id;
	private String name;
	private String pwd;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 获得user Dao操作类
	 */
	public final static User me = new User().dao();
	/*
	 * 删除用户
	 */
	public void delUser() {
		// me.deleteById("1");
	}
	/*
	 * 普通无参数查询
	 */
	public List<User> queryUserList() {
		List<User> find = me.find("select * from user where id>1");
		return find;
	}
	/*
	 * 带参数查询
	 */
	public List<User> queryparamList() {
		List<User> find = me.find("select * from user where id>?", 2);
		return find;
	}
	/*
	 * 分页查询
	 */
	public Page<User> queryUserListpage() {
		Page<User> page = me.paginate(1, 4, "select *",
				" from user where id > ?", 2);
		return page;
	}
	/*
	 * 修改数据库 update()
	 */
	public void updateUser(){
		User user = me.findById("2");
		System.out.println(user.id);
		System.out.println(user.id);
		System.out.println(user.id);
		System.out.println(user.id);
		System.out.println(user.id);
	}
	
}

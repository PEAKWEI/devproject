package Action;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;

import Model.User;
import services.impl.myServicesImpl;

public class HelloController extends Controller{
	//@Before(Tx.class)
	public void index(){
//		renderText("hello world!");
		render("/login.html");
/*		User user=getModel(User.class);
//		user.deleteById("1");
//		user.delete();
*/	}
	/*
	 * ï¿½ï¿½Â¼ï¿½ï¿½ï¿½ï¿½
	 */
	public void login(){
		User user=getModel(User.class);
		user.save();
		render("/result.html");
		System.out.println("ok!");
		/*String name = this.getPara("user.name");
		String pwd = this.getPara("user.pwd");
		
		System.out.println("ï¿½ï¿½Â¼ï¿½É¹ï¿½"+name+pwd);
		String name1 = "yetangtang";
        String pwd1 = "123456";
		setAttr("name22", "asd");
		setAttr("pwd22", pwd1);
		*/
	}
	/*
	 * ÎÞ·¨äÖÈ¾Ò³Ãæ
	 */
	public void pagejava(){
		User user=getModel(User.class);
		List<User> list = user.queryUserList();
		System.out.println(list.toString());
		setAttr("listname", list);
		render("/pagelist.jsp");
	}
	//@ActionKey("tests")
	//@Before(Tx.class)
	public void tests(){
		myServicesImpl mImpl=new myServicesImpl();
		//System.out.println(mImpl.queryList());
		Record record=new Record();
		record.set("name", "ÖÐ¹ú3333");
		record.set("pwd", "12313213");
		 //ÖÆÔìÒì³£
		System.out.println(mImpl.addUser(record));
		renderText("sssssssssssssssssssssssssssss");
	}
	

}

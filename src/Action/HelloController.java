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
	 * ��¼����
	 */
	public void login(){
		User user=getModel(User.class);
		user.save();
		render("/result.html");
		System.out.println("ok!");
		/*String name = this.getPara("user.name");
		String pwd = this.getPara("user.pwd");
		
		System.out.println("��¼�ɹ�"+name+pwd);
		String name1 = "yetangtang";
        String pwd1 = "123456";
		setAttr("name22", "asd");
		setAttr("pwd22", pwd1);
		*/
	}
	/*
	 * �޷���Ⱦҳ��
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
		record.set("name", "�й�3333");
		record.set("pwd", "12313213");
		 //�����쳣
		System.out.println(mImpl.addUser(record));
		renderText("sssssssssssssssssssssssssssss");
	}
	

}

package Test;

import com.jfinal.core.Controller;

import Model.User;

public class TestDemo extends Controller {

	public void index(){
		renderNull();
	}
	public void test1() {
		User user = getModel(User.class);
		user.updateUser();
	}

}

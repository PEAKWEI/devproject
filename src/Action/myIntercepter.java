package Action;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class myIntercepter implements Interceptor{

	public void intercept(Invocation inv) {
		System.out.println("before-------��ִ�д���-----------");
		inv.invoke();
		System.out.println("after----------��ִ�д���ʵ��aop---------");
	}

}

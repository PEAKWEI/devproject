package Action;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class myIntercepter implements Interceptor{

	public void intercept(Invocation inv) {
		System.out.println("before-------先执行代码-----------");
		inv.invoke();
		System.out.println("after----------后执行代码实现aop---------");
	}

}

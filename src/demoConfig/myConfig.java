package demoConfig;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.tx.TxByMethods;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

import Action.HelloController;
import Action.myIntercepter;
import Model.User;
import Test.TestDemo;

public class myConfig extends JFinalConfig {
	
	public static void main(String[] args) {
		JFinal.start("WebContent", 80, "/", 5);
	}

	@Override
	public void configConstant(Constants me) {

		me.setViewType(ViewType.JSP);
		PropKit.use("popkit.txt");
		me.setDevMode(PropKit.getBoolean("DevMode"));
		System.out.println(PropKit.get("jdbcUrl"));

	}

	@Override
	public void configRoute(Routes me) {
		// index 方法
		// me.add("/hello", HelloController.class);
		// 配置登录 在类始于action配置的时候 /sinlogin/login(加上方法名)
		me.add("/", HelloController.class);
		me.add("/demo/tests", HelloController.class);
		me.add("/test",TestDemo.class);
	}

	@Override
	public void configEngine(Engine me) {
	}

	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"),
				PropKit.get("password").trim());

	}

	@Override
	public void configPlugin(Plugins me) {
		// 调用c3p0连接池
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		// 创建记录
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
	    //增加对sql方言的支持
		//arp.setDialect();
		me.add(arp);
		// 大小写不敏感工厂
		arp.setContainerFactory(new CaseInsensitiveContainerFactory());
		/*
		 * arp.addMapping("user",
		 * User.class);这个方法是用来配置数据库表名和程序中model的映射关系的，默认情况下表数据的主键是id，
		 * 不需要修改配置。 如果宝宝们的主键不是id，那么需要改变一下调用方法arp.addMapping("user","表中的主键名",
		 * User.class)。参数一：表名；参数二：表中主键名；参数三：映射的实体类。
		 */
		arp.addMapping("user","id", User.class);

	}
	/*拦截器配置
	 * (non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.Interceptors)
	 */

	@Override
	public void configInterceptor(Interceptors me) {
		//me.add(new TxByMethods("index"));
		me.add(new myIntercepter());
	}

	@Override
	public void configHandler(Handlers me) {

	}

}

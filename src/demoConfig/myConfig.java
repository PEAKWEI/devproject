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
		// index ����
		// me.add("/hello", HelloController.class);
		// ���õ�¼ ����ʼ��action���õ�ʱ�� /sinlogin/login(���Ϸ�����)
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
		// ����c3p0���ӳ�
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		// ������¼
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
	    //���Ӷ�sql���Ե�֧��
		//arp.setDialect();
		me.add(arp);
		// ��Сд�����й���
		arp.setContainerFactory(new CaseInsensitiveContainerFactory());
		/*
		 * arp.addMapping("user",
		 * User.class);��������������������ݿ�����ͳ�����model��ӳ���ϵ�ģ�Ĭ������±����ݵ�������id��
		 * ����Ҫ�޸����á� ��������ǵ���������id����ô��Ҫ�ı�һ�µ��÷���arp.addMapping("user","���е�������",
		 * User.class)������һ������������������������������������ӳ���ʵ���ࡣ
		 */
		arp.addMapping("user","id", User.class);

	}
	/*����������
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

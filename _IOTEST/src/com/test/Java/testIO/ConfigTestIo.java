package com.test.Java.testIO;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class ConfigTestIo extends JFinalConfig {

	public static void main(String[] args) {
		JFinal.start("WebRoot",8080,"/",5);
}

public void configConstant(Constants me) {
	me.setDevMode(true);
	}
	public void configRoute(Routes me) {
	me.add("/web", ControllerTestIo.class);
	}
	public void configEngine(Engine me) {}
	public void configPlugin(Plugins me) {
		loadPropertyFile("config.properties");
		DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		me.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		me.add(arp);
	}
	public void configInterceptor(Interceptors me) {}
	public void configHandler(Handlers me) {}


}

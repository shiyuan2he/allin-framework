import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path paac-core/com.codelibrary.javaee.UnitTestBaseHibernate.java	
 * @time 2016年5月28日 下午8:26:55
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class UnitTestBaseSpring {
	
	private ClassPathXmlApplicationContext context;
	
	private String springXmlpath;
	
	public UnitTestBaseSpring() {}
	
	public UnitTestBaseSpring(String springXmlpath) {
		this.springXmlpath = springXmlpath;
	}
	
	@Before
	public void before() {
		// 如果初始化没有传递spring配置文件，默认加载所有spring配置文件
		if (StringUtils.isEmpty(springXmlpath)) {
			springXmlpath = "classpath*:spring/spring-*.xml";
		}
		try {
			context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));//匹配逗号或字符串
			//文件 
			//FileSystemXmlApplicationContext content = new FileSystemXmlApplicationContext("c:/workspace/applicationContext.xml") ;
			context.start();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after() {
		context.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {
		try {
			return (T)context.getBean(beanId);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T extends Object> T getBean(Class<T> clazz) {
		try {
			return context.getBean(clazz);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}

}

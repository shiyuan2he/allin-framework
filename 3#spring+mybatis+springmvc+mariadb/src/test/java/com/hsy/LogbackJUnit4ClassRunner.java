package com.hsy;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/PACKAGE_NAME
 * @date 20/08/2017 4:56 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class LogbackJUnit4ClassRunner extends SpringJUnit4ClassRunner {
    static {
        initLogback();
    }

    public LogbackJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
    public static void initLogback(){
        /*try {
            File cfgFile = ResourceUtils.getFile("classpath:logback.xml");
            ConfigurationSource source = new ConfigurationSource(new FileInputStream(cfgFile));
            Configurator.initialize(null, source);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

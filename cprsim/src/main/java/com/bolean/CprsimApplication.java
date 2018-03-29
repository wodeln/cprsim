package com.bolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@EnableSwagger2
@MapperScan("com.bolean.dao")
public class CprsimApplication {
    private static final Logger logger = LogManager.getLogger(CprsimApplication.class);
    private static final Log log = LogFactory.getLog(CprsimApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(CprsimApplication.class, args);

        logger.trace("这是 org.apache.logging.log4j LogManager trace log");
        logger.warn("这是 org.apache.logging.log4j LogManager warn log");
        logger.debug("这是 org.apache.logging.log4j LogManager debug log");
        logger.error("折是 org.apache.logging.log4j LogManager error log");
        System.out.println("-----------------------------------------------------------华丽丽的分割线----------------------------------------------------------------");
        log.trace("这是 org.apache.commons.logging LogFactory trace log");
        log.warn("这是 org.apache.commons.logging LogFactory warn log");
        log.debug("这是 org.apache.commons.logging LogFactory debug log");
        log.error("这是 org.apache.commons.logging LogFactory error log");
    }

    /*@Value("templates") String templatesPath;
    @Bean(name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        //获取Spring Boot 的ClassLoader
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader==null){
            loader = AnalyseStudentApplication.class.getClassLoader();
        }
//        beetlGroupUtilConfiguration.setConfigProperties(extProperties);//额外的配置，可以覆盖默认配置，一般不需要
        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader,
                templatesPath);
        beetlGroupUtilConfiguration.setResourceLoader(cploder);
        beetlGroupUtilConfiguration.init();
        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
        return beetlGroupUtilConfiguration;

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }*/
}

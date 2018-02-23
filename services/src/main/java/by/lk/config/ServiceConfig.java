package by.lk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Vinty on 02.07.2017.
 */
@Configuration
@ComponentScan(basePackages = "by.lk")
@Import(value ={RootConfig.class})
@EnableTransactionManagement
public class ServiceConfig {
}

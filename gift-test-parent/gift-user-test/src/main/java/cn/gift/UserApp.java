package cn.gift;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 刘某吃不饱
 */
@SpringBootApplication
@MapperScan("com.liu.mapper")
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);
        System.out.println("Hello world!");
    }
}
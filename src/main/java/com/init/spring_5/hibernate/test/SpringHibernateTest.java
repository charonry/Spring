package com.init.spring_5.hibernate.test;

import com.init.spring_5.hibernate.service.BookShopService;
import com.init.spring_5.hibernate.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

public class SpringHibernateTest {
    private ApplicationContext ctx = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("spring_5/applicationContext.xml");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testCashier() {
        cashier.checkout("aa", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("aa", "1001");
    }
}

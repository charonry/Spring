package com.init.spring_4.tx.tx_xml;

import com.init.spring_4.tx.tx_xml.service.BookShopService;
import com.init.spring_4.tx.tx_xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {
    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("spring_4/applicationContext-tx_xml.xml");
        bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testTransactionlPropagation() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }
}

package com.init.spring_4.tx.tx_xml.service.impl;

import com.init.spring_4.tx.tx_xml.service.BookShopService;
import com.init.spring_4.tx.tx_xml.service.Cashier;

import java.util.List;


public class CashierImpl implements Cashier {

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}

package com.init.spring_5.hibernate.service.impl;

import com.init.spring_5.hibernate.dao.BookShopDao;
import com.init.spring_5.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username, price);
    }
}

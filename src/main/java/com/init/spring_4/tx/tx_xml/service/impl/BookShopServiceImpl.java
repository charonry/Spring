package com.init.spring_4.tx.tx_xml.service.impl;

import com.init.spring_4.tx.tx_xml.BookShopDao;
import com.init.spring_4.tx.tx_xml.service.BookShopService;


public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, String isbn) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        //1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //2. 更新数的库存
        bookShopDao.updateBookStock(isbn);
        //3. 更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }

}

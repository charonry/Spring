package com.init.spring_4.tx.tx_xml.service;

import java.util.List;

public interface Cashier {
    public void checkout(String username, List<String> isbns);
}

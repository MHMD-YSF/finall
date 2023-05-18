package com.example.demo;

import java.util.Comparator;

public class PageCountComparator implements Comparator<BOOK> {
    public int compare(BOOK b1, BOOK b2) {
        return Integer.compare(b1.getPageCount(), b2.getPageCount());
    }
}


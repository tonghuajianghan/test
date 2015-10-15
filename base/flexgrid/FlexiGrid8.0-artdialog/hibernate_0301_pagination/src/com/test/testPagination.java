package com.test;

import com.hibernate.util.Pagination;

public class testPagination {
  public static void main(String[] args) {
	Pagination p = new Pagination();
	System.out.println(p.getSize());
  }
}

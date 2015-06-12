package com.helper.dao;

import java.util.List;

import com.helper.entity.Order;

public interface OrderDao {
	/**
	 * ≤È—Ø
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param s4
	 * @return
	 */
	List<Order> findOrders(String s1,String s2,String s3,String s4,int first,int second);
	int insert(Order ord);
	}

package web.orderlist.service;

import web.orderlist.vo.Orderlist;

public interface OrderlistService {
	Orderlist searchOrderlist(Orderlist orderlist); //查詢
	Integer insertOrderlist(Orderlist orderlist); //新增
	Integer deleteOrderlist(Orderlist orderlist); //刪除
	Integer modifyOrderlist(Orderlist orderlist); //修改
	
	
}

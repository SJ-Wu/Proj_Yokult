package web.orderlist.service;

import java.util.List;

import web.orderlist.vo.Orderlist;

public interface OrderlistService {
	List<Orderlist> searchOrderlistByOrdid(String orderID); //查詢
	Integer insertOrderlist(Orderlist orderlist); //新增
	Integer deleteOrderlist(Orderlist orderlist); //刪除
	Integer modifyOrderlist(Orderlist orderlist); //修改
	
	
}

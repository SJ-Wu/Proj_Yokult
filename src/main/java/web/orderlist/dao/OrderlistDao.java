package web.orderlist.dao;

import web.orderlist.vo.Orderlist;

public interface OrderlistDao {
	Orderlist searchOrderlist(Orderlist orderlist); //查詢（界面）
	Integer insertOrderlist(Orderlist orderlist); //新增（界面）
	Integer deleteOrderlist(Orderlist orderlist); //刪除（界面）
	Integer modifyOrderlist(Orderlist orderlist);  //修改（界面）
}
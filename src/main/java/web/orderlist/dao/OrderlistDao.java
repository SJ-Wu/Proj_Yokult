package web.orderlist.dao;

import java.util.List;

import web.orderlist.vo.*;

public interface OrderlistDao {
	List<Orderlist> searchOrderlist(Orderlist orderlist); //查詢（界面）
	List<OrderlistView> searchOrderlistView(OrderlistView orderlist); //查詢（界面）
	Integer insertOrderlist(Orderlist orderlist); //新增（界面）
	Integer deleteOrderlist(Orderlist orderlist); //刪除（界面）
	Integer modifyOrderlist(Orderlist orderlist);  //修改（界面）
}
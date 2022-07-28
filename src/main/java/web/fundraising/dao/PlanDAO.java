package web.fundraising.dao;

import java.util.List;

import web.fundraising.vo.PlanBean;

public interface PlanDAO {
	public abstract PlanBean insert(PlanBean planBean);
	public abstract Boolean delete(Integer id);
	public abstract PlanBean update(Integer id, PlanBean planBean);
	public abstract PlanBean select(Integer id);
	public abstract List<PlanBean> selectAll();
}

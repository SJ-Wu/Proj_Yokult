package web.fundraising.service;

import java.util.List;

import org.hibernate.Session;

import web.fundraising.dao.ProposalDAO;
import web.fundraising.dao.ProposalDAOhibernateHQL;
import web.fundraising.vo.ProposalBean;

public class ProposalService {
	ProposalDAO ProposalDAO;
	
	public ProposalService(Session session) {
		this.ProposalDAO = new ProposalDAOhibernateHQL(session);
	}
	
	public ProposalBean insertBean(ProposalBean proposalBean) {
		return this.ProposalDAO.insert(proposalBean);
	}
	public Boolean deleteBean(Integer id) {
		return this.ProposalDAO.delete(id);
	}
	public ProposalBean updateBean(Integer id, ProposalBean proposalBean) {
		return this.ProposalDAO.update(id, proposalBean);
	}
	public ProposalBean selectBean(Integer id) {
		return this.ProposalDAO.select(id);
	}
	public List<ProposalBean> selectAllBeans() {
		return this.ProposalDAO.selectAll();
	}
}

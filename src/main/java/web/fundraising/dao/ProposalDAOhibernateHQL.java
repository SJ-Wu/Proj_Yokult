package web.fundraising.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import web.fundraising.vo.ProposalBean;

public class ProposalDAOhibernateHQL implements ProposalDAO {
	
	private Session session;
	
//	public ProposalDAOhibernateHQL(Session session) {
//		this.session = session;
//	}
	
	@Override
	public ProposalBean insert(ProposalBean proposalBean) {
		if(proposalBean != null && proposalBean.getProposalID() == null) {			
			this.session.save(proposalBean);
			return proposalBean;				
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		if(id != null && id >0) {
			ProposalBean delete = this.session.get(ProposalBean.class, id);
			if(delete != null) {
				this.session.delete(delete);
				return true;
			}
		}
		return null;
	}

	@Override
	public ProposalBean update(Integer id, ProposalBean proposalBean) {
		if(id != null && id > 0 && proposalBean != null && proposalBean.getProposalID() == null) {			
			ProposalBean update = this.session.get(ProposalBean.class, id);
			if(update != null) {
				this.session.save(update);
				return update;				
			}
		}
		return null;
	}

	@Override
	public ProposalBean select(Integer id) {
		if(id != null && id >0) {
			return this.session.get(ProposalBean.class, id);
		}
		return null;
	}

	@Override
	public List<ProposalBean> selectAll() {
		Query<ProposalBean> qurey = this.session.createQuery("from Fund_PROPOSAL", ProposalBean.class);
		List<ProposalBean> result = qurey.list();
		return result;
	}
	
}

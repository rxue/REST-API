package rx.masterdata.company;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CompanyRepository {
	@Inject
	private EntityManager entityManager;
	
	/**
	 * NOTE! Based on P of EAA, all() might not be a good idea
	 * 
	 * @return
	 */
	public List<Company> all() {
		return entityManager.createQuery("select a from Company a", Company.class)
				.getResultList();
	}
	
	public Company save(Company company) {
		entityManager.persist(company);
		return company;
	}
}

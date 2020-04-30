package daobackup.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public abstract class DAOJPA {
	@PersistenceContext
	protected EntityManager em;
	
}

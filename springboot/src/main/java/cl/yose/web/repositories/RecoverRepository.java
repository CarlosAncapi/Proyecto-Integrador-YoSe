package cl.yose.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.yose.web.models.Recover;

@Repository
public interface RecoverRepository extends JpaRepository<Recover, Long> {
	

}

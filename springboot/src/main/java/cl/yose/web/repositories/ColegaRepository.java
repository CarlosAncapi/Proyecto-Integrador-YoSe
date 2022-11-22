package cl.yose.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.yose.web.models.Colega;

// import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ColegaRepository extends JpaRepository<Colega, Long>{


}

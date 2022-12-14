package cl.yose.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.yose.web.models.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long>{
}

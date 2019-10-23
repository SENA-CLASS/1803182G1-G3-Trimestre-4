package co.edu.sena.ejemplo.repository;

import co.edu.sena.ejemplo.domain.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Long> {
}

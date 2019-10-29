package co.edu.sena.horariossurogate.repository;

import co.edu.sena.horariossurogate.domain.User;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


}

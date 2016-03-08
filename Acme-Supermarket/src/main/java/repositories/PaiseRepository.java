package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Paise;

@Repository
public interface PaiseRepository extends JpaRepository<Paise,Integer>{

}

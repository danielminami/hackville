package hackville.elderly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hackville.elderly.model.ModelConnection;


@Repository
public interface RepositoryConnection extends JpaRepository<ModelConnection, Integer> {
	
}

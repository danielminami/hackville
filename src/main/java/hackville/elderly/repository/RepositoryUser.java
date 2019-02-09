package hackville.elderly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hackville.elderly.model.ModelUser;

@Repository
public interface RepositoryUser extends JpaRepository<ModelUser, Integer> {
	
}

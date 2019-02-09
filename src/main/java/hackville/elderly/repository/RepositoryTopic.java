package hackville.elderly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hackville.elderly.model.ModelTopic;

@Repository
public interface RepositoryTopic extends JpaRepository<ModelTopic, Integer> {
	
}

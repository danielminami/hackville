package hackville.elderly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hackville.elderly.model.ModelTopic;
import hackville.elderly.model.ModelTopicUser;

@Repository
public interface RepositoryTopicUser extends JpaRepository<ModelTopicUser, Integer> {
	
}

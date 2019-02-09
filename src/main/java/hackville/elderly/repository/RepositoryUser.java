package hackville.elderly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import hackville.elderly.model.ModelUser;

@Repository
public interface RepositoryUser extends JpaRepository<ModelUser, Integer> {
		
	@Query(value="SELECT * "
			+ "FROM tb_user AS u, tb_topic_usr AS t "
			+ "WHERE u.id = t.user_id and "
			+ "t.topic_id = ?1"
			, nativeQuery = true)
	List<ModelUser> findByTopic(Integer topic);
	
}

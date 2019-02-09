package hackville.elderly.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import hackville.elderly.model.ModelTopicUser;
import hackville.elderly.repository.RepositoryTopicUser;
import hackville.elderly.repository.RepositoryUser;
import hackville.elderly.resources.ResourceNotFoundException;

@RestController    
@RequestMapping(path="/topic_user") 
public class ControllerTopicUser {
	
	@Autowired 
	private RepositoryTopicUser repo;
	
	@Autowired 
	private RepositoryUser repoUser;
	
	@PostMapping(path="/create")
	public @ResponseBody ModelTopicUser create (@RequestBody ModelTopicUser n) {
		return repo.save(n);
	}
	
    @PostMapping(path="/create/{userId}")
    public ModelTopicUser create(@PathVariable (value = "userId") Integer userId,
               @Valid @RequestBody ModelTopicUser topic) {
  	
        return repoUser.findById(userId).map(pdata -> {
        	topic.setUserId(pdata);
            return repo.save(topic);
        }
        ).orElseThrow(
        	() -> new ResourceNotFoundException("User Id: " + userId + " not found"));
    }
	
	
	@GetMapping(path="/read")
	public @ResponseBody Iterable<ModelTopicUser> list() {
		return repo.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody ModelTopicUser update (@RequestBody ModelTopicUser n) {
		return repo.save(n);
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody ModelTopicUser delete (@RequestBody ModelTopicUser n) {
		repo.delete(n);
		return n;
	}
	
	@PostMapping(path="/getById")
	public @ResponseBody Optional<ModelTopicUser> getById(@RequestBody ModelTopicUser n) {
		return repo.findById(n.getId());
	}
	
}



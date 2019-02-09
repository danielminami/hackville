package hackville.elderly.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import hackville.elderly.model.ModelTopic;
import hackville.elderly.repository.RepositoryTopic;

@RestController    
@RequestMapping(path="/topic") 
public class ControllerTopic {
	
	@Autowired 
	private RepositoryTopic repo;
	
	@PostMapping(path="/create")
	public @ResponseBody ModelTopic create (@RequestBody ModelTopic n) {
		return repo.save(n);
	}

	@GetMapping(path="/read")
	public @ResponseBody Iterable<ModelTopic> list() {
		return repo.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody ModelTopic update (@RequestBody ModelTopic n) {
		return repo.save(n);
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody ModelTopic delete (@RequestBody ModelTopic n) {
		repo.delete(n);
		return n;
	}
	
	@PostMapping(path="/getById")
	public @ResponseBody Optional<ModelTopic> getById(@RequestBody ModelTopic n) {
		return repo.findById(n.getId());
	}
	
}



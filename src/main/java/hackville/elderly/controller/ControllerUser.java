package hackville.elderly.controller;

import java.util.List;
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
import hackville.elderly.model.ModelUser;
import hackville.elderly.repository.RepositoryUser;
import hackville.elderly.resources.ResourceNotFoundException;

@RestController    
@RequestMapping(path="/user") 
public class ControllerUser {
	
	@Autowired 
	private RepositoryUser repo;
	
	@PostMapping(path="/create")
	public @ResponseBody ModelUser create (@RequestBody ModelUser n) {
		return repo.save(n);
	}

	@GetMapping(path="/read")
	public @ResponseBody Iterable<ModelUser> list() {
		return repo.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody ModelUser update (@RequestBody ModelUser n) {
		return repo.save(n);
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody ModelUser delete (@RequestBody ModelUser n) {
		repo.delete(n);
		return n;
	}
	
	@GetMapping(path="/getByTopic/{topicId}")
	public @ResponseBody List<ModelUser> create(@PathVariable (value = "topicId") Integer topicId) {
		return repo.findByTopic(topicId);
	}
	
	
}



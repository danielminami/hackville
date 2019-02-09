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
import hackville.elderly.model.ModelConnection;
import hackville.elderly.repository.RepositoryConnection;
import hackville.elderly.repository.RepositoryTopicUser;
import hackville.elderly.repository.RepositoryUser;
import hackville.elderly.resources.ResourceNotFoundException;

@RestController    
@RequestMapping(path="/connection") 
public class ControllerConnection {
	
	@Autowired 
	private RepositoryConnection repo;
	
	@Autowired 
	private RepositoryUser repoUser;
	
    @PostMapping(path="/create/{userId}")
    public ModelConnection create(@PathVariable (value = "userId") Integer userId,
               @Valid @RequestBody ModelConnection connection) {
  	   	
    	return repoUser.findById(userId).map(pdata -> {
	       	connection.setUserId(pdata);
	        return repo.save(connection);
	    }
	        ).orElseThrow(
	        	() -> new ResourceNotFoundException("User Id: " + userId + " not found"));
    }
		
	@GetMapping(path="/read")
	public @ResponseBody Iterable<ModelConnection> list() {
		return repo.findAll();
	}
	
	@PutMapping(path="/update")
	public @ResponseBody ModelConnection update (@RequestBody ModelConnection n) {
		return repo.save(n);
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody ModelConnection delete (@RequestBody ModelConnection n) {
		repo.delete(n);
		return n;
	}
	
	@PostMapping(path="/getById")
	public @ResponseBody Optional<ModelConnection> getById(@RequestBody ModelConnection n) {
		return repo.findById(n.getId());
	}
	
}



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
import hackville.elderly.model.ModelUser;
import hackville.elderly.repository.RepositoryUser;

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
	
	@PostMapping(path="/getById")
	public @ResponseBody Optional<ModelUser> getById(@RequestBody ModelUser n) {
		return repo.findById(n.getId());
	}
	
}



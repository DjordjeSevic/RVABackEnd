package rva.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.model.Status;
import rva.repositories.StatusRepository;

@CrossOrigin
@RestController
@RequestMapping("/status")
@Api(tags = {"CRUD operations on Status table"})
public class StatusController {
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	@ApiOperation(value = "Method which returns all rows from Status table")
	public Collection<Status> getAllStatus(){
		return statusRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Method which returns one row from Status table by Id")
	public Status getStatusById(@PathVariable int id){
		return statusRepository.getById(id);
	}
	
	@GetMapping("/naziv/{naziv}")
	@ApiOperation(value = "Method which returns all rows from Status table by Naziv")
	public Collection<Status> getStatusByNaziv(@PathVariable String naziv){
		return statusRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping
	@ApiOperation(value = "Method which creates one row to Status table")
	public ResponseEntity<Status> createStatus(@RequestBody Status status) {
		if(status.getId() == null || !statusRepository.existsById(status.getId())) {
			Status tempStatus = statusRepository.save(status);
			return new ResponseEntity<Status>(tempStatus, HttpStatus.CREATED);
		}
		return new ResponseEntity<Status>(HttpStatus.CONFLICT);
	}
	
	@PutMapping
	@ApiOperation(value = "Method which updates one row to Status table")
	public ResponseEntity<Status> updateStatus(@RequestBody Status status) {
		if(!statusRepository.existsById(status.getId()))
			return new ResponseEntity<Status>(HttpStatus.CONFLICT);
		Status tempStatus = statusRepository.save(status);
		return new ResponseEntity<Status>(tempStatus, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Method which deletes one row to Status table")
	public ResponseEntity<Status> deleteStatus(@PathVariable int id){
		if(statusRepository.existsById(id)) {
			statusRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("Insert into status(\"id\", \"naziv\", \"oznaka\") values(-100,'testnaz', 'testozn')");
			return new ResponseEntity<Status>(HttpStatus.OK);
		}
		return new ResponseEntity<Status>(HttpStatus.NOT_FOUND);
	}
}
 
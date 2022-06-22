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
import rva.model.Fakultet;
import rva.repositories.FakultetRepository;

@CrossOrigin
@RestController
@RequestMapping("/fakultet")
@Api(tags = {"CRUD operations on Fakultet table"})
public class FakultetController {
	@Autowired
	private FakultetRepository fakultetRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	@ApiOperation(value = "Method which returns all rows from Fakultet table")
	public Collection<Fakultet> getAllFakultets(){
		return fakultetRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Method which returns one row from Fakultet table by Id")
	public Fakultet getFakultetById(@PathVariable int id){
		return fakultetRepository.getById(id);
	}
	
	@GetMapping("/naziv/{naziv}")
	@ApiOperation(value = "Method which returns all rows from Fakultet table by Naziv")
	public Collection<Fakultet> getFakultetByNaziv(@PathVariable String naziv){
		return fakultetRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping
	@ApiOperation(value = "Method which creates one row to Fakultet table")
	public ResponseEntity<Fakultet> createFakultet(@RequestBody Fakultet fakultet) {
		if(fakultet.getId() == null || !fakultetRepository.existsById(fakultet.getId())) {
			Fakultet tempFakultet = fakultetRepository.save(fakultet);
			return new ResponseEntity<Fakultet>(tempFakultet, HttpStatus.CREATED);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.CONFLICT);
	}
	
	@PutMapping
	@ApiOperation(value = "Method which updates one row from Fakultet table")
	public ResponseEntity<Fakultet> updateFakultet(@RequestBody Fakultet fakultet) {
		if(!fakultetRepository.existsById(fakultet.getId()))
			return new ResponseEntity<Fakultet>(HttpStatus.CONFLICT);
		Fakultet tempFakultet = fakultetRepository.save(fakultet);
		return new ResponseEntity<Fakultet>(tempFakultet, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Method which deletes one row from Fakultet table")
	public ResponseEntity<Fakultet> deleteFakultet(@PathVariable int id){
		if(fakultetRepository.existsById(id)) {
			fakultetRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("Insert into fakultet(\"id\", \"naziv\", \"sediste\") values(-100,'testnaz', 'testsed')");
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
	}
}

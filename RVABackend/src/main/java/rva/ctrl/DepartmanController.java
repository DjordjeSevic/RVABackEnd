package rva.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.model.Departman;
import rva.repositories.DepartmanRepository;

@CrossOrigin
@RestController
@RequestMapping("/departman")
@Api(tags = {"CRUD operations on Departman table"})
public class DepartmanController {
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	@ApiOperation(value = "Method which returns all rows from Departman table")
	public Collection<Departman> getAllDepartmans(){
		return departmanRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Method which returns one row from Departman table by Id")
	public Departman getDepartmanById(@PathVariable int id){
		return departmanRepository.getById(id);
	}
	
	@GetMapping("/naziv/{naziv}")
	@ApiOperation(value = "Method which returns all rows from Departman table by Naziv")
	public Collection<Departman> getDepartmanByNaziv (@PathVariable String naziv){
		return departmanRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping
	@ApiOperation(value = "Method which creates one row to Departman table")
	public ResponseEntity<Departman> createDepartman(@RequestBody Departman departman) {
		if(departman.getId() == null || !departmanRepository.existsById(departman.getId())) {
			Departman tempDepartman = departmanRepository.save(departman);
			return new ResponseEntity<Departman>(tempDepartman, HttpStatus.CREATED);
		}
		return new ResponseEntity<Departman>(HttpStatus.CONFLICT);
	}
	
	@PutMapping
	@ApiOperation(value = "Method which updates one row from Departman table")
	public ResponseEntity<Departman> updateDepartman(@RequestBody Departman departman) {
		if(!departmanRepository.existsById(departman.getId()))
			return new ResponseEntity<Departman>(HttpStatus.CONFLICT);
		Departman tempDepartman = departmanRepository.save(departman);
		return new ResponseEntity<Departman>(tempDepartman, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Method which deletes one row from Departman table")
	public ResponseEntity<Departman> deleteDepartman(@PathVariable int id){
		if(departmanRepository.existsById(id)) {
			departmanRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("Insert into departman(\"id\", \"naziv\", \"oznaka\", \"fakultet\") values(-100,'testnaz', 'testozn', '1')");
			return new ResponseEntity<Departman>(HttpStatus.OK);
		}
		return new ResponseEntity<Departman>(HttpStatus.NOT_FOUND);
	}
}

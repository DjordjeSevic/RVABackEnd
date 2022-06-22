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
import rva.model.Departman;
import rva.model.Student;
import rva.repositories.DepartmanRepository;
import rva.repositories.StudentRepository;

@CrossOrigin
@RestController
@RequestMapping("/student")
@Api(tags = {"CRUD operations on Student table"})
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	@ApiOperation(value = "Method which returns all rows from Student table")
	public Collection<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Method which returns one row from Student table by Id")
	public Student getStudentById(@PathVariable int id){
		return studentRepository.getById(id);
	}
	
	@GetMapping("/indeks/{indeks}")
	@ApiOperation(value = "Method which returns one row from Student table by Index")
	public Student getStudentByIndeks (@PathVariable String indeks){
		return studentRepository.findByBrojIndeksa(indeks);
	}
	
	@GetMapping("/forDepartman/{id}")
	@ApiOperation(value = "Method which returns all rows from Student table by Departman")
	public Collection<Student> getStudentsByDepartman(@PathVariable int id){
		Departman tempDep = departmanRepository.getById(id);
		return studentRepository.findByDepartman(tempDep);
	}
	
	@PostMapping
	@ApiOperation(value = "Method which creates one row to Student table")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		if(student.getId() == null || !studentRepository.existsById(student.getId())) {
			Student tempStudent = studentRepository.save(student);
			return new ResponseEntity<Student>(tempStudent, HttpStatus.CREATED);
		}
		return new ResponseEntity<Student>(HttpStatus.CONFLICT);
	}
	
	@PutMapping
	@ApiOperation(value = "Method which updates one row from Student table")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		if(!studentRepository.existsById(student.getId()))
			return new ResponseEntity<Student>(HttpStatus.CONFLICT);
		Student tempStudent = studentRepository.save(student);
		return new ResponseEntity<Student>(tempStudent, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Method which deletes one row from Student table")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id){
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("Insert into student(\"id\", \"ime\", \"prezime\", \"broj_indeksa\", \"status\", \"departman\") values(-100,'testime', 'testprz', 'testbrind', '1', '1')");
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
}

package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import klu.model.Faculty;
import klu.model.FacultyManager;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyManager FM;
	
	@PostMapping("/save")
	public String saveFaculty(@RequestBody Faculty F)
	{
		return FM.addFaculty(F);
	}
	
	@GetMapping("/read")
	public String readFaculty()
	{
		return FM.getFaculty().toString();
	}
	
	@PutMapping("/update")
	public String updateFaculty(@RequestBody Faculty F)
	{
		return FM.updateFaculty(F);
	}
	
	@DeleteMapping("/delete")
	public String deleteFaculty(@RequestParam("ID") Long id)
	{
		return FM.deleteFaculty(id);
	}
}

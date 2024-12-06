package klu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import klu.repository.FacultyRepository;

@Service
public class FacultyManager {
	
	@Autowired
	FacultyRepository FR;
	
	public String addFaculty(Faculty F)
	{
		if(FR.getFID(F.getId()) == 0)
		{
			FR.save(F); //INSERT OPERATION
			
			Map<String, String> resp = new HashMap<String,String>();
			resp.put("code", "200");
			resp.put("msg", "New faculty has been added");
			return toJSON(resp);
		}
		else
		{
			Map<String, String> resp = new HashMap<String,String>();
			resp.put("code", "401");
			resp.put("msg", "Faculty ID already exist!");
			return toJSON(resp);
		}
		
	}
	
	public List<String> getFaculty()
	{
		List<String> flist = new ArrayList<String>();
		for(Faculty F : FR.findAll())
		{
			flist.add(toJSON(F));
		}
		return flist;
	}
	
	public String updateFaculty(Faculty F)
	{
		FR.save(F); //UPDATE OPERATION
		
		Map<String, String> resp = new HashMap<String,String>();
		resp.put("code", "200");
		resp.put("msg", "Faculty data has been updated");
		return toJSON(resp);
	}
	
	public String deleteFaculty(Long id)
	{
		FR.deleteById(id); // DELETE OPERATION
		
		Map<String, String> resp = new HashMap<String,String>();
		resp.put("code", "200");
		resp.put("msg", "Faculty data has been deleted");
		return toJSON(resp);
	}
	
	//Convert into JSON
	public String toJSON(Object obj)
	{
		GsonBuilder GB = new GsonBuilder();
		Gson G = GB.create();
		return G.toJson(obj);
	}
}

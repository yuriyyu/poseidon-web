package edu.mum.se.poseidon.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.se.poseidon.web.models.Course;
import edu.mum.se.poseidon.web.services.CourseService;
import edu.mum.se.poseidon.web.services.FacultyService;
import edu.mum.se.poseidon.web.services.dto.CourseDto;
import edu.mum.se.poseidon.web.services.dto.FacultyDto;
import edu.mum.se.poseidon.web.services.dto.UserDto;

/**
 * Created by Munkhtsogt Tsogbadrakh on 10/11/2017.
 *
 * @author Munkhtsogt Tsogbadrakh
 */

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CourseController {

	public FacultyService facultyService;
	public CourseService courseService;
	
	@Autowired
	public CourseController(FacultyService facultyService, CourseService courseService){
		this.facultyService = facultyService;
		this.courseService = courseService;
	}
	
	@RequestMapping(path = "/admin/course", method = RequestMethod.GET)
	public String index(Model model) {
		
		return "admin/course/index";
	}
	
	@RequestMapping(path = "/admin/course/create", method = RequestMethod.GET)
	public String create(Model model) throws Exception {
		List<FacultyDto> faculties = facultyService.getFaculties();
		List<CourseDto> courses = courseService.getCourses();
		model.addAttribute("course", new Course());
		model.addAttribute("faculties", faculties);
		model.addAttribute("courses", courses);
		return "admin/course/create";
	}
}

/**
 * 
 */
package dev.patten.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.patten.entities.Department;
import dev.patten.services.read_only.DepartmentService;
import dev.patten.services.read_only.DepartmentServiceImpl;

/**
 * @author james
 *
 */
public class DepartmentController {
	
	/*
	 * Read any necessary information from the request
	 * Call the appropriate Service(s).
	 * Prepare our data to be added to the response
	 * Add said data into the Response Body.
	 * 
	 * Processing Requests and Generating Responses
	 */
	
	public static DepartmentService as = new DepartmentServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		Department dep = as.get(id);
		
		response.getWriter().append((dep != null) ? gson.toJson(dep) : "{}");
	}

	public static void getAllDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Department> listDepartments = as.getAll();
		System.out.println(listDepartments.toString());
		response.getWriter().append((listDepartments != null) ? gson.toJson(listDepartments) : "{}");
	}
	

}

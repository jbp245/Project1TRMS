/**
 * 
 */
package dev.patten.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.patten.entities.Roles;
import dev.patten.services.read_only.RolesService;
import dev.patten.services.read_only.RolesServiceImpl;

/**
 * @author james
 *
 */
public class RolesController {
	
	/*
	 * Read any necessary information from the request
	 * Call the appropriate Service(s).
	 * Prepare our data to be added to the response
	 * Add said data into the Response Body.
	 * 
	 * Processing Requests and Generating Responses
	 */
	
	public static RolesService as = new RolesServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		Roles role = as.get(id);
		
		response.getWriter().append((role != null) ? gson.toJson(role) : "{}");
	}

	public static void getAllRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Roles> listRoles = as.getAll();
		System.out.println(listRoles.toString());
		response.getWriter().append((listRoles != null) ? gson.toJson(listRoles) : "{}");
	}
	

}
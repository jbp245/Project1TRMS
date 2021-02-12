/**
 * 
 */
package dev.patten.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.patten.entities.EventGrades;
import dev.patten.services.read_only.EventGradesService;
import dev.patten.services.read_only.EventGradesServiceImpl;

/**
 * @author james
 *
 */
public class EventGradesController {
	
	/*
	 * Read any necessary information from the request
	 * Call the appropriate Service(s).
	 * Prepare our data to be added to the response
	 * Add said data into the Response Body.
	 * 
	 * Processing Requests and Generating Responses
	 */
	
	public static EventGradesService as = new EventGradesServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getEventGrade(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		EventGrades eventGrade = as.get(id);
		
		response.getWriter().append((eventGrade != null) ? gson.toJson(eventGrade) : "{}");
	}

	public static void getAllEventGrades(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<EventGrades> listEventGrades = as.getAll();
		System.out.println(listEventGrades.toString());
		response.getWriter().append((listEventGrades != null) ? gson.toJson(listEventGrades) : "{}");
	}
	

}

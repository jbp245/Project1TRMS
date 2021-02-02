/**
 * 
 */
package dev.patten.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.patten.entities.EventType;
import dev.patten.services.read_only.EventTypeService;
import dev.patten.services.read_only.EventTypeServiceImpl;

/**
 * @author james
 *
 */
public class EventTypeController {
	
	/*
	 * Read any necessary information from the request
	 * Call the appropriate Service(s).
	 * Prepare our data to be added to the response
	 * Add said data into the Response Body.
	 * 
	 * Processing Requests and Generating Responses
	 */
	
	public static EventTypeService as = new EventTypeServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getEventType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("id");
		
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}
		
		EventType eventType = as.get(id);
		
		response.getWriter().append((eventType != null) ? gson.toJson(eventType) : "{}");
	}

	public static void getAllEventTypes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<EventType> listTypes = as.getAll();
		System.out.println(listTypes.toString());
		response.getWriter().append((listTypes != null) ? gson.toJson(listTypes) : "{}");
	}
	

}
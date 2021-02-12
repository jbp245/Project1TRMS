/**
 * 
 */
package dev.patten.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.patten.entities.Employee;
import dev.patten.services.EmployeeService;
import dev.patten.services.EmployeeServiceImpl;

/**
 * @author james
 *
 */
public class EmployeeController {

	/*
	 * Read any necessary information from the request Call the appropriate
	 * Service(s). Prepare our data to be added to the response Add said data into
	 * the Response Body.
	 * 
	 * Processing Requests and Generating Responses
	 */

	public static EmployeeService as = new EmployeeServiceImpl();
	public static Gson gson = new Gson();

	public static void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Employee emp = as.get(id);

		response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
	}
	
	public static void getSuperById(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Employee emp = as.get(id);

		response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
	}

	public static void getEmployeeByUsername(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String input = request.getParameter("username");

		String username;
		try {
			username = input;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "Username parameter incorrectly formatted.");
			return;
		}

		Employee emp = as.getByUsername(username);

		response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
	}

	public static void putAdjustAwardAvail(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		//amount in a js function
		String input = request.getParameter("amount");
		// cookie name is hard to pass in postman
		Employee subject = as.getByUsername(getCookieVal(request));
		// works in postman
		// Employee subject = as.getByUsername("mscott");

		System.out.println(subject);
		System.out.println(subject.toString());

		double change;
		try {
			change = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "Amount parameter incorrectly formatted.");
			return;
		}

		// TODO should technically go in EmoployeeServiceImpl
		if (change <= subject.getAward_available()) {
			subject.setAward_available(subject.getAward_available() - change);
			as.update(subject);
		} else {
			subject.setAward_available(0);
			as.update(subject);
		}

		response.getWriter().append((as.get(subject.getId()) != null) ? gson.toJson(as.get(subject.getId())) : "{}");
	}

	// support/utility method
	public static String getCookieVal(HttpServletRequest request) {
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		System.out.println(cookies.get(0).getValue() + " getValue()");
		for (Cookie element : cookies) {
			if (element.getName().equals("loggedInUser")) {
				System.out.println("getCookieVal :" + element.getValue());
				return element.getValue();
			}
		}
		System.out.println("Unsuccessful getCookieVal");
		return null;
	}

	public static void getAllUnder(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// logged in employee
		//Employee subject = as.getByUsername(getCookieVal(request));
		// works in postman (for pam)
		Employee subject = as.getByUsername("rhoward");
		List<Employee> employees = as.getAll();

		employees = as.getAllUnder(subject);

		System.out.println(employees.toString() + "reached end");
		response.getWriter().append((employees != null) ? gson.toJson(employees) : "{}");
	}

	public static void getAllAbove(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// logged in employee
		Employee subject = as.getByUsername(getCookieVal(request));
		// untested in postman
		// Employee subject = as.getByUsername("dphilbin");
		List<Employee> employees = as.getAll();

		employees = as.getAllAbove(subject, employees);

		System.out.println(employees.toString() + "reached end");
		response.getWriter().append((employees != null) ? gson.toJson(employees) : "{}");
	}
	

}
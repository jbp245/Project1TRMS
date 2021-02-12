/**
 * 
 */
package dev.patten.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.patten.entities.Employee;
import dev.patten.entities.Form;
import dev.patten.services.EmployeeServiceImpl;
import dev.patten.services.FormService;
import dev.patten.services.FormServiceImpl;

/**
 * @author james
 *
 */
public class FormController {
	
	public static FormService as = new FormServiceImpl();
	public static Gson gson = new Gson();

	// POST
	public static void postForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BufferedReader reader = request.getReader();

		Form form = gson.fromJson(reader, Form.class);
		System.out.println(form);
		if (as.add(form)) {
			System.out.println("form submission successful: " + form.toString());
		}
		response.getWriter().append(gson.toJson(form));

	}

	// GET
	public static void getForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Form form = as.get(id);

		response.getWriter().append((form != null) ? gson.toJson(form) : "{}");
	}

	public static void getAllForms(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Form> listForms = as.getAll();
		System.out.println(listForms.toString());
		response.getWriter().append((listForms != null) ? gson.toJson(listForms) : "{}");
	}

	// works in postman
	public static void getAllFormsByUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Form> listForms = as.getAll();
		List<Form> usersForms = new ArrayList<Form>();
		// System.out.println(listForms.toString());
		Employee current_user = new EmployeeServiceImpl().getByUsername(getCookieVal(request));
		// works in postman
		// Employee current_user = new EmployeeServiceImpl().getByUsername("mscott");
		System.out.println("reached " + current_user);
		for (Form element : listForms) {
			if (element.getEmp_id() == current_user.getId()) {
				usersForms.add(element);
			}
		}
		System.out.println(usersForms);
		response.getWriter().append((usersForms != null) ? gson.toJson(usersForms) : "{}");

	}

	public static void getAllFormsUnderUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// System.out.println(listForms.toString());
		Employee current_user = new EmployeeServiceImpl().getByUsername(getCookieVal(request));
		// Employee current_user = new EmployeeServiceImpl().getByUsername("mscott");
		// List<Form> listForms = getAllFormsGivenUsername(current_user.getUsername());
		List<Form> all = as.getAll();
		List<Form> underForms = new ArrayList<Form>();
		List<Employee> subordinates = new EmployeeServiceImpl().getAllUnder(current_user);
		if (current_user.getRole_id() == 4) {
			response.getWriter().append((all != null) ? gson.toJson(all) : "{}");

		} else {
			for (Form each : all) {
				for (Employee sub : subordinates) {
					if (each.getEmp_id() == sub.getId()) {
						underForms.add(each);
					}
				}
			}
			System.out.println(underForms);
			response.getWriter().append((underForms != null) ? gson.toJson(underForms) : "{}");

		}
	}

	public static List<Form> getAllFormsGivenUsername(String username) {
		Employee given_user = new EmployeeServiceImpl().getByUsername(username);
		List<Form> temp = new ArrayList<Form>();
		List<Form> all = as.getAll();
		for (Form each : all) {
			if (each.getEmp_id() == given_user.getId()) {
				temp.add(each);
			}
		}
		return temp;
	}

	// PUT
	public static void putForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	// DELETE
	public static void deleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String param_id = request.getParameter("form_id");
		
		int id;
		try {
			id = Integer.parseInt(param_id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		as.delete(id);

		response.getWriter().append("Deleted a form"); 
	}

	// UTIL
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
}

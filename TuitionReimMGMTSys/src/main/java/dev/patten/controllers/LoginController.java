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
public class LoginController {

	public static EmployeeService login_service = new EmployeeServiceImpl();
	public static Gson gson = new Gson();

	public static void postLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Employee emp = gson.fromJson(request.getReader(), Employee.class);
		
		emp = login_service.login(emp.getUsername(), emp.getPassword());
		
		Cookie cookie = new Cookie("loggedInUser", emp.getUsername());
		cookie.setSecure(true);
		response.addCookie(cookie);

	}

	public static void getLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		System.out.println(cookies.toString());
		for (Cookie element : cookies) {
			if (element.getName().equals("loggedInUser")) {
				response.setContentType("text/html");
				element.setValue("null");
				element.setMaxAge(-1);
				response.addCookie(element);
			}
		}
	}
	
	public static void getCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		System.out.println(cookies.toString());
		for (Cookie element : cookies) {
			if (element.getName().equals("loggedInUser")) {
				Employee emp = login_service.getByUsername(element.getValue());
				response.getWriter().append((emp != null) ? gson.toJson(emp) : "{}");
			}
		}
	}
	
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

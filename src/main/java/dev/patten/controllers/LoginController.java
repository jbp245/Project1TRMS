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

	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);

		Employee emp = login_service.login(username, password);

		Cookie cookie = new Cookie("loggedInUser", emp.getUsername());
		cookie.setSecure(true);
		response.addCookie(cookie);

	}

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		for (Cookie element : cookies) {
			if (element.getName().equals("loggedInUser")) {
				element.setMaxAge(0);
			}
		}
	}

}

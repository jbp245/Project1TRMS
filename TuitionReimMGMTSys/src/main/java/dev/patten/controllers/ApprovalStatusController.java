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

import dev.patten.entities.ApprovalStatus;
import dev.patten.entities.Employee;
import dev.patten.entities.Form;
import dev.patten.services.ApprovalStatusService;
import dev.patten.services.ApprovalStatusServiceImpl;
import dev.patten.services.EmployeeService;
import dev.patten.services.EmployeeServiceImpl;
import dev.patten.services.FormServiceImpl;

/**
 * @author james
 *
 */
public class ApprovalStatusController {

	public static ApprovalStatusService as = new ApprovalStatusServiceImpl();
	public static Gson gson = new Gson();

	// POST
	public static void postApprovalStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BufferedReader reader = request.getReader();

		ApprovalStatus appstat = gson.fromJson(reader, ApprovalStatus.class);
		System.out.println(appstat);
		if (as.add(appstat)) {
			System.out.println("form submission successful: " + appstat.toString());
		}
		response.getWriter().append(gson.toJson(appstat));

	}

	// GET
	public static void getApprovalStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		ApprovalStatus dep = as.get(id);

		response.getWriter().append((dep != null) ? gson.toJson(dep) : "{}");
	}

	public static void getAllApprovals(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ApprovalStatus> listApprovals = as.getAll();
		System.out.println(listApprovals.toString());
		response.getWriter().append((listApprovals != null) ? gson.toJson(listApprovals) : "{}");
	}

	public static void getAllApprovalsGivenUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<ApprovalStatus> listApprovalStatus = as.getAll();
		List<ApprovalStatus> usersAppStatus = new ArrayList<ApprovalStatus>();

		// System.out.println(listForms.toString());
		Employee current_user = new EmployeeServiceImpl().getByUsername(getCookieVal(request));
		// works in postman
		// Employee current_user = new EmployeeServiceImpl().getByUsername("mscott");
		List<Form> usersForms = FormController.getAllFormsGivenUsername(current_user.getUsername());
		System.out.println("reached " + current_user);
		for (Form ele : usersForms) {
			for (ApprovalStatus element : listApprovalStatus) {
				if (element.getId() == ele.getId()) {
					usersAppStatus.add(element);
				}
			}
		}
		System.out.println(usersAppStatus);
		response.getWriter().append((usersAppStatus != null) ? gson.toJson(usersAppStatus) : "{}");

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

	public static void approve(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BufferedReader reader = request.getReader();
		ApprovalStatus stat = gson.fromJson(reader, ApprovalStatus.class);

		Employee current_user = new EmployeeServiceImpl().getByUsername(getCookieVal(request));
		//ApprovalStatus astat = new ApprovalStatusServiceImpl().get(stat.getId());
		//List<Form> usersForms = new FormServiceImpl().getAll();

		Form current = new FormServiceImpl().get(stat.getId());
		stat.setGrade(stat.getGrade() + 1);
		stat.setStatus(stat.getStatus() + 1);
//		for (Form each : usersForms) {
//			if (each.getId() == stat.getId()) {
//				current = each;
//				if (current_user.getFirst_name().equals(each.getFirst_name())) {
//					
//				}
//			}
//		}
		Employee target = new EmployeeServiceImpl().get(current.getEmp_id());
		if (current_user.getRole_id() == 4) {
			target.setAward_available(target.getAward_available()-current.getCost());
			EmployeeService to_update = new EmployeeServiceImpl();
			to_update.update(target);
		}
		ApprovalStatusService stat_update = new ApprovalStatusServiceImpl();
		stat_update.update(stat);
		response.getWriter().append(gson.toJson(current_user));

	}
	// PUT

	// DELETE - cant imagine implementing unless trigger on delete archive
}

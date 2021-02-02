package dev.patten.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.patten.controllers.DepartmentServiceController;
import dev.patten.controllers.EventGradesController;
import dev.patten.controllers.EventTypeController;
import dev.patten.controllers.LoginController;
import dev.patten.controllers.RolesController;

public class RequestHelper {
	
	/**
	 * This method will delegate other methods on the controller
	 * layer of our application to process the request.
	 * @param request the HTTP Request
	 * @param response the HTTP Response
	 * @throws IOException 
	 */
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		final String trms = "/TuitionReimMGMTSys/";
		
		System.out.println(uri);
		
		switch (uri) {
		// see: Login Controller
		case (trms + "login.do"): {
			LoginController.login(request, response);
			break;
		}
		case (trms + "logout.do"):{
			LoginController.logout(request, response);
		}
		
		// see: RolesController
		case (trms + "getRole.do"): {
			RolesController.getRole(request, response);
			break;
		}
		case (trms + "getAllRoles.do"): { 
			RolesController.getAllRoles(request, response);
			break;
		}
		
		// see: EventTypeController
		case (trms + "getEventType.do"): {
			EventTypeController.getEventType(request, response);
			break;
		}
		case (trms + "getAllEventTypes.do"): { 
			EventTypeController.getAllEventTypes(request, response);
			break;
		}
		
		// see: EventGradesController
		case (trms + "getEventGrade.do"): {
			EventGradesController.getEventGrade(request, response);
			break;
		}
		case (trms + "getAllEventGrades.do"): {
			EventGradesController.getAllEventGrades(request, response);
			break;
		}
		
		// see: DepartmentServiceController
		case (trms + "getDepartment.do"): {
			DepartmentServiceController.getDepartment(request, response);
			break;
		}
		case (trms + "getAllDepartments.do"): {
			DepartmentServiceController.getAllDepartments(request, response);
			break;
		}
		
		// default
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, is teapot.");
			break;
		}
		}
		
	}

}

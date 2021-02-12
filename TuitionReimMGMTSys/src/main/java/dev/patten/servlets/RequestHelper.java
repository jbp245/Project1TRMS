package dev.patten.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.patten.controllers.ApprovalStatusController;
import dev.patten.controllers.DepartmentController;
import dev.patten.controllers.EmployeeController;
import dev.patten.controllers.EventGradesController;
import dev.patten.controllers.EventTypeController;
import dev.patten.controllers.FormController;
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
		case (trms + "postLogin.do"): {
			LoginController.postLogin(request, response);
			break;
		}
		case (trms + "getLogout.do"):{
			LoginController.getLogout(request, response);
			break;
		}
		case (trms + "getCurrentUser.do"): {
			LoginController.getCurrentUser(request, response);
			break;
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
			DepartmentController.getDepartment(request, response);
			break;
		}
		case (trms + "getAllDepartments.do"): {
			DepartmentController.getAllDepartments(request, response);
			break;
		}
		
		// see: EmployeeServiceController
		case (trms + "getEmployeeByUsername.do"): {
			EmployeeController.getEmployeeByUsername(request, response);
			break;
		}
		case (trms + "getEmploteeById.do"): {
			EmployeeController.getEmployeeById(request, response);
			break;
		}	
		case (trms + "putAdjustAwardAvail.do"): {
			EmployeeController.putAdjustAwardAvail(request, response);
			break;
		}
		case (trms + "getAllUnder.do"): {
			EmployeeController.getAllUnder(request, response);
			break;
		}
		case (trms + "getAllAbove.do"): {
			EmployeeController.getAllUnder(request, response);
			break;
		}
		case (trms + "getSuperById.do"): {
			EmployeeController.getSuperById(request, response);
			break;
		}
		
		// see: FormController
		case (trms + "getForm.do"): {
			FormController.getForm(request, response);
			break;
		}
		case (trms + "getAllForms.do"): {
			FormController.getAllForms(request, response);
			break;
		}
		case (trms + "getAllFormsByUser.do"): {
			FormController.getAllFormsByUser(request, response);
			break;
		}
		case (trms + "postForm.do"): {
			FormController.postForm(request, response);
			break;
		}
		case (trms + "getAllFormsUnderUser.do"): {
			FormController.getAllFormsUnderUser(request, response);
			break;
		}
		case (trms + "deleteForm.do"): {
			FormController.deleteForm(request, response);
			break;
		}
		
		// see; ApprovalStatusController
		case (trms + "getAllApprovalsGivenUser.do"): {
			ApprovalStatusController.getAllApprovalsGivenUser(request, response);
			break;
		}
		case (trms + "getAllApprovals.do"): {
			ApprovalStatusController.getAllApprovals(request, response);
			break;
		}
		case (trms + "postApprovalStatus.do"): {
			ApprovalStatusController.postApprovalStatus(request, response);
			break;
		}
		case (trms + "getApprovalStatus.do"): {
			ApprovalStatusController.getApprovalStatus(request, response);
			break;
		}
		case (trms + "approve.do"): {
			ApprovalStatusController.approve(request, response);
			break;
		}
		
		// default
		default: {
			response.sendError(418, "You forgot to add a case/ spelled one wrong");
			break;
		}
		}
		
	}

}

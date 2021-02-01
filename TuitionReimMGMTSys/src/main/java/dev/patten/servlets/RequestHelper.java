package dev.patten.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	/**
	 * This method will delegate other methods on the controller layer of our
	 * application to process the request.
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();

		System.out.println(uri);

		switch (uri) {
		case "/TuitionReimMGMTSys/test.do": {
			response.getWriter().append("test worked");
			break;
		}
		default: {
			response.sendError(418, "Default case hit. Nonsense!");
			break;
		}
		}
	}

}

package com.loggerspage.api;

import com.loggerspage.model.Response;
import com.loggerspage.model.ResponseMeta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by caniven on 18/11/2017.
 */
public class AbstractController {

	protected <T> ResponseEntity successfulResponse(T body) {
		return successfulResponse(body, 0);
	}

	protected <T> ResponseEntity successfulResponse(T body, int code) {
		final ResponseMeta meta = new ResponseMeta().code(code).message("");
		final Response response = new Response().meta(meta);
		response.setResponse(body);
		ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.OK);
		return responseEntity;
	}


	protected <T> ResponseEntity badRequest(T body,int code) {
		final ResponseMeta meta = new ResponseMeta().code(code).message("Bad Request");
		final Response response = new Response().meta(meta);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	protected <T> ResponseEntity badRequest(T body) {
		return badRequest(body,400);
	}
}

package com.loggerspage.api.interceptor;

import com.loggerspage.model.Response;
import com.loggerspage.model.ResponseMeta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caniven on 18/11/2017.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResponseEntity<?> handleControllerException(HttpServletRequest req, Exception ex) {
    logger.error(ex.getMessage(), ex);
    // get exception code from custom exception
    // ex.getCode()
    // find corresponding error message of exception code.
    // create a meta message from it

    final ResponseMeta meta = new ResponseMeta().code(0).message("message");
    final Response response = new Response().meta(meta);
    response.setResponse(null);
    ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.OK);

    return responseEntity;
  }
}

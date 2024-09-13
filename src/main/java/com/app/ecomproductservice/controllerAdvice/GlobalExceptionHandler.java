package com.app.ecomproductservice.controllerAdvice;

import com.app.ecomproductservice.DTOs.ExceptionDTO;
import com.app.ecomproductservice.exception.ProductNotFoundException;
import com.app.ecomproductservice.modles.Product;
import com.app.ecomproductservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArthimeticException()
    {
        ResponseEntity<String> response = new ResponseEntity<>(
                "Something went wrong, coming from controller advice",
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDTO> handlenullPointerException()
    {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Null pointer exception as occured");
        exceptionDTO.setSolution("Please try again");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException()
    {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Product Not found");
        exceptionDTO.setSolution("Please try again with valid id");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
}

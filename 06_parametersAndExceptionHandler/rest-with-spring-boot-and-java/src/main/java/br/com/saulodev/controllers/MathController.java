package br.com.saulodev.controllers;

import java.lang.Exception;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulodev.converts.NumberConverters;
import br.com.saulodev.exceptions.UnsupportedMathOperationException;
import br.com.saulodev.math.SimpleMath;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value= "/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET
			)
	public Double sum(
			/*PathParam não tem um valor padrão pois é obrigatorio*/
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo")	String numberTwo) throws Exception {	
		if(!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return math.sum(NumberConverters.convertToDouble(numberOne) , NumberConverters.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/division/{numberOne}/{numberTwo}",
			method=RequestMethod.GET
			)
	public Double division(
			/*PathParam não tem um valor padrão pois é obrigatorio*/
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo")	String numberTwo) throws Exception {	
		if(!NumberConverters.isNumeric(numberOne) || !NumberConverters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return math.division(NumberConverters.convertToDouble(numberOne), NumberConverters.convertToDouble(numberTwo));
	}
	


}

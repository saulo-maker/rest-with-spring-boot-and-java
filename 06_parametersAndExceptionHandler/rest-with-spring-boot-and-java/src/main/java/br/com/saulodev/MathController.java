package br.com.saulodev;

import java.lang.Exception;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulodev.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value= "/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET
			)
	public Double sum(
			/*PathParam não tem um valor padrão pois é obrigatorio*/
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo")	String numberTwo) throws Exception {	
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@RequestMapping(value= "/division/{numberOne}/{numberTwo}",
			method=RequestMethod.GET
			)
	public Double division(
			/*PathParam não tem um valor padrão pois é obrigatorio*/
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo")	String numberTwo) throws Exception {	
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D; // BR 10,25	
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9+]");
	}

}

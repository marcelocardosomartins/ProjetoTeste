package br.com.projetoteste;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoteste.exception.UnsuportedMathOperationException;

@RestController
public class CalculadoraController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Deve tê algum trem errado ai na soma, já oio se num digitô letra?");
		}
		
		Double sum = convertToDouble(numberOne)+convertToDouble(numberTwo);
		
		return sum;
		
	}

	@RequestMapping(value = "/subtration/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtration(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Deve tê algum trem errado ai na subtração, já oio se num digitô letra?");
		}
		
		Double subtration = convertToDouble(numberOne)-convertToDouble(numberTwo);
		
		return subtration;
		
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Deve tê algum trem errado ai na multiplicação, já oio se num digitô letra?");
		}
		
		Double multiplication = convertToDouble(numberOne)*convertToDouble(numberTwo);
		
		return multiplication;
		
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Deve tê algum trem errado ai na divisão, já oio se num digitô letra?");
		}
		
		Double division = convertToDouble(numberOne)/convertToDouble(numberTwo);
		
		return division;
		
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Deve tê algum trem errado ai na divisão, já oio se num digitô letra?");
		}
		
		Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		
		return mean;
		
	}

	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new UnsuportedMathOperationException("Deve tê algum trem errado ai na raiz quadrada, já oio se num digitô letra?");
		}
		
		Double squareRoot = (Double) Math.sqrt(convertToDouble(number));
		
		return squareRoot;
		
	}
	
	private Double convertToDouble(String strNumber) {
		
		if(strNumber == null) {
			return 0D;
		}
		
		String number = strNumber.replaceAll(",", ".");		
		
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}


	private boolean isNumeric(String strNumber) {
		
		if(strNumber == null) {
			return false;
		}
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}	
	

}

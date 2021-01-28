// Calculator.java
// Written by Paul Tymann
//
// A simple calculator class.  Provides integer only arithmetic and a
// clear key.

public class CalcLogic {

    private static final String DIGITS = "0123456789" ;

    private boolean firstDigit;              // State for State machine
    private int lOperand;                       // "Left" operator
    private String operator;                  // Last operator

    public CalcLogic() {
	firstDigit = true;
	lOperand = 0;
	operator = "=";
    }

    // Routine to handle button events

    public void handleButton(String keyPressed, Calculator gui ) {
	if (DIGITS.indexOf(keyPressed) != -1) {      // Is a digit
	    if (firstDigit) {
		firstDigit = false ;
		gui.setDisplay(keyPressed) ;
	    }
	    else
		gui.setDisplay(gui.getDisplay()+keyPressed) ;
	}
	else if (keyPressed.equals("C")) {           // Is the Clear
	    firstDigit = true ;
	    lOperand = 0 ;
	    operator = "=" ;
	    gui.setDisplay("0") ;
	}
	else {                                       // Just a command
	    if ( !firstDigit ) {
		compute(Integer.valueOf(gui.getDisplay()).intValue()) ;
		gui.setDisplay( String.valueOf(lOperand) );
		firstDigit = true ;
	    }

	    operator = keyPressed ;
	}
    }

    // Handles the "computations"

    public void compute(int rOperand) {
	switch(operator.charAt(0)) {
	case '=':
	    lOperand = rOperand ;
	    break ;
	case '+':
	    lOperand = lOperand + rOperand ;
	    break ;
	case '-':
	    lOperand = lOperand - rOperand ;
	    break ;
	case 'X':
	    lOperand = lOperand * rOperand ;
	    break ;
	case '/':
	    lOperand = lOperand / rOperand ;
	    break ;
	}
    }
}

package GUI;


/**  
* AppInterfaceButtonEvents.java - AppInterfaceButtonEvents is the connection between AppLogic and UserInterface classes.
*  Here are defined the methods that implements the AppLogic and are called from UserInterface in order to announce the controller that the user pressed some button. 
* @author  Vlad Bonta
* @see AppLogic
* @see UserInterface
*/
public interface AppInterfaceButtonEvents {
	    public void buttonTouched (String operationString, String firstPolynomString, String secondPolynomString);

}

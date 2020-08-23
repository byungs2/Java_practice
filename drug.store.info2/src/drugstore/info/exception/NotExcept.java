package drugstore.info.exception;

import org.apache.log4j.Logger;

public class NotExcept extends Exception {
	Logger log = Logger.getRootLogger();
	public NotExcept(){}
	public NotExcept(String message){
		super(message);
		log.debug("Non-Exist Error!");
	}
}

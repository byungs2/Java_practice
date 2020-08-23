package drugstore.info.exception;

import org.apache.log4j.Logger;

public class DuplExcept extends Exception {
	Logger log = Logger.getRootLogger(); 
	public DuplExcept() {}
	public DuplExcept(String message) {
		super(message);
		log.debug("Duplicated Data Error!");
	
	}
}

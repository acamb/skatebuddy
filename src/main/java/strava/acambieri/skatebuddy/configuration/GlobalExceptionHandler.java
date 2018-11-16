package strava.acambieri.skatebuddy.configuration;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import strava.acambieri.skatebuddy.Utils;
import strava.acambieri.skatebuddy.services.SkateBuddyService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author andrea AC
 *         Date: 12/08/2017
 */
@ControllerAdvice
@Scope("request")
public class GlobalExceptionHandler {
    
    @Autowired
    private SkateBuddyService service;
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleConflict(HttpServletRequest req, Exception e) {
        service.rollback();
        LoggerFactory.getLogger(getClass()).error("G.E.H. : " + Utils.exceptionToString(e));
        ResponseEntity<Object> response = new ResponseEntity<Object>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
    
    
}

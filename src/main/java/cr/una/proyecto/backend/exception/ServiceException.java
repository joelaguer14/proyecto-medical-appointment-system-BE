package cr.una.proyecto.backend.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Manage the exceptions of the backend for Service
 */
public class ServiceException extends Exception {
    private static final Logger logger = LogManager.getLogger(ServiceException.class);

    /**
     * Manage the exception for Service classes
     *
     * @param message, message of the exception
     */
    public ServiceException(String message) {
        super(message);
        logger.error("Several Error - Service Layer");
    }

    /**
     * Manage the exception for Service classes
     *
     * @param message, message of the exception
     * @param cause, cause of the exception
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        logger.error("Several Error - Service Layer", cause);
    }
}
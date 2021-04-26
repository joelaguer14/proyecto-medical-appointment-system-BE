package cr.una.proyecto.backend.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Manage the exceptions of the backend for DAO
 */
public class DAOException extends Exception {
    private static final Logger logger = LogManager.getLogger(DAOException.class);

    /**
     * Manage the exception for DAO classes
     * @param message, message of the exception
     */
    public DAOException(String message) {
        super(message);
        logger.error("Error - DAO layer");
    }

    /**
     * Manage the exception for DAO classes
     * @param message, message of the exception
     * @param cause, cause of the exception
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
        logger.error("Error - DAO layer", cause);
    }
}
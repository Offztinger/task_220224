package co.edu.elpoli.task.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class TaskException extends RuntimeException{
    public TaskException(String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private String message;
    private HttpStatus httpStatus;
}

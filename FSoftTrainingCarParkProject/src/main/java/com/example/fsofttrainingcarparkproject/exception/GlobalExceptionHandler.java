package com.example.fsofttrainingcarparkproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException() {
        return new ErrorMessage(LocalDate.now(),10500, "Đã xảy ra RuntimeException");
    }

    @ExceptionHandler(IOException.class)
    public String someException() {
        return "Đây là IOException";
    }

    @ExceptionHandler({NullPointerException.class})
    public String handleNullPointerException() {
        return "Something wrong, this is Null Pointer - Kiểm tra lại @Validated và @Valid ở Controller";
    }

    // Có thể dùng @ExceptionHandler cho List Exception (để trong cặp ngoặc nhọn)
    @ExceptionHandler({SQLException.class, SQLDataException.class})
    public String handleSQLException() {
        return "Something wrong with SQL Query or SQL Data";
    }

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest  request) {
        // Qúa trình kiểm soát lỗi diễn ra ở đây
        return new ErrorMessage(LocalDate.now(),1500, "Exception tổng: " + ex.getMessage());
    }


    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleIndexOutOfBoundsException(Exception ex, WebRequest  request) {
        return new ErrorMessage(LocalDate.now(),10100, "Vượt qúa phạm vi cho phép");
    }

    /*@ExceptionHandler({NullPointerException.class, NoSuchElementException.class})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ErrorMessage noElementException(Exception ex, WebRequest  request) {
        return new ErrorMessage(200, ex.getMessage());
    }*/
}

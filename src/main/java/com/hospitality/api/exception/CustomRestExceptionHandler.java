package com.hospitality.api.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.UUID;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LogManager.getLogger(CustomRestExceptionHandler.class);
    static String NOMBREAPLICACION;


    public CustomRestExceptionHandler() {
        String methodName = "Error | CustomRestExceptionHandler | ";

        try {
            NOMBREAPLICACION = ".kleverness-hospitality-backoffice-v1";
        }
        catch (Exception e) {
            //logger.info(logs.GetLogCustom(methodName + "Ocurrió un error al obtener las propiedades del sistema", new ArrayList<>()));
            throw new InternalServerError("Ocurrió un error al obtener las propiedades del sistema");
        }
    }


    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleServletRequestBindingException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
                                                                        HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleConversionNotSupported(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
                                                                      HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        errors.add("Error en el cuerpo del mensaje");

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
        
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMessageNotWritable(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {
        return super.handleMissingPathVariable(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        String errorlm = ex.getLocalizedMessage();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return handleExceptionInternal(ex, ResponseApiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
                                                         final HttpStatus status, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        String errorlm = ex.getLocalizedMessage();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return handleExceptionInternal(ex, ResponseApiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex, final HttpHeaders headers,
                                                        final HttpStatus status, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();

        final String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type "
                + ex.getRequiredType();
        errors.add(error);

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(final MissingServletRequestPartException ex,
                                                                     final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        String methodName = CustomRestExceptionHandler.class.getName() + "."
                + new Throwable().getStackTrace()[0].getMethodName() + ". ";
       final ArrayList<String> errors = new ArrayList<String>();

        final String error = ex.getRequestPartName() + " part is missing";
        errors.add(error);

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            final MissingServletRequestParameterException ex, final HttpHeaders headers, final HttpStatus status,
            final WebRequest request) {
         final String error = ex.getParameterName() + " parameter is missing";

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(error);

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    //

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
                                                                   final WebRequest request) {
        final String error = "Valores incompletos en la búsqueda";

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(error);

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);;
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNoHandlerFound(NoHandlerFoundException ex, WebRequest request) {
        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(error);

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.NOT_FOUND.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.NOT_FOUND.value())
                , GetMessage(HttpStatus.NOT_FOUND.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    // 404
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex,
                                                                   final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(error);

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.NOT_FOUND.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.NOT_FOUND.value())
                , GetMessage(HttpStatus.NOT_FOUND.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    // 405
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            final HttpRequestMethodNotSupportedException ex, final HttpHeaders headers, final HttpStatus status,
            final WebRequest request) {
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(builder.toString());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.METHOD_NOT_ALLOWED.value() + NOMBREAPLICACION,
                GetMessage(HttpStatus.METHOD_NOT_ALLOWED.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    // 415
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(final HttpMediaTypeNotSupportedException ex,
                                                                     final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t + " "));

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(builder.toString());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value() + NOMBREAPLICACION,
                GetMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler({ BadRequest.class })
    public ResponseEntity<Object> handleBadRequest(final BadRequest ex, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getError());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ InternalServerError.class })
    public ResponseEntity<Object> handleInternalError(final InternalServerError ex, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getError());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.INTERNAL_SERVER_ERROR.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.INTERNAL_SERVER_ERROR.value())
                , GetMessage(HttpStatus.INTERNAL_SERVER_ERROR.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ NotFoundError.class })
    public ResponseEntity<Object> handleInternalError(final NotFoundError ex, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getError());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.NOT_FOUND.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.NOT_FOUND.value())
                , GetMessage(HttpStatus.NOT_FOUND.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ NotAuthorizedException.class })
    public ResponseEntity<Object> handleInternalError(final NotAuthorizedException ex, final WebRequest request) {
        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getError());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.UNAUTHORIZED.value() + NOMBREAPLICACION,
                GetMessage(HttpStatus.UNAUTHORIZED.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ UncategorizedSQLException.class })
    public ResponseEntity<Object> handleAll(final UncategorizedSQLException ex, final WebRequest request) {
        String error = ex.getLocalizedMessage();
        if (ex.getCause() != null && ex.getCause().getLocalizedMessage() != null) {
            error = ex.getCause().getLocalizedMessage();
        }

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getSQLException().getLocalizedMessage());
        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.BAD_REQUEST.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.BAD_REQUEST.value())
                , GetMessage(HttpStatus.BAD_REQUEST.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    // 500
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
        String error = ex.getLocalizedMessage();
        if (ex.getCause() != null && ex.getCause().getLocalizedMessage() != null) {
            error = ex.getCause().getLocalizedMessage();
        }

        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());

        final ResponseApiError ResponseApiError = new ResponseApiError(HttpStatus.INTERNAL_SERVER_ERROR.value() + NOMBREAPLICACION + GetArea(request.getDescription(false)) + GetNumeroError(HttpStatus.INTERNAL_SERVER_ERROR.value())
                , GetMessage(HttpStatus.INTERNAL_SERVER_ERROR.value()), Folio(), Info(), errors);
        return new ResponseEntity<Object>(ResponseApiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static String Folio() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    private String GetArea(String descripcion) {
        String area= "";
        return area;
    }

    private String GetNumeroError(int status) {
        String numero = ".";
        switch (status) {
            case 400:
                numero = ".1001";
                break;
            case 404:
                numero = ".1002";
                break;
            case 500:
                numero = ".1003";
                break;
            default:
                break;
        }

        return numero;
    }

    private String GetMessage(int status) {
        String message = ".";
        switch (status) {
            case 400:
                message = "Peticion no valida, favor de validar su informacion";
                break;
            case 404:
                message = "No se encontró información";
                break;
            case 500:
                message = "Problemas al procesar su solicitud favor de contactar a su administrador";
                break;
            default:
                break;
        }
        return message;
    }

    private String Info() {
        return "";
    }
}

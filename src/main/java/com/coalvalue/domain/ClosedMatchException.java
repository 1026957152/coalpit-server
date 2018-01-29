package com.coalvalue.domain;


/**
 * Created by silence on 2016-07-11.
 */
public class ClosedMatchException extends Throwable {



    public boolean Success ;

    public String errorMessage ;

    private String resultMessage;
    private String action;
    private Object messages;
    public ClosedMatchException(Object jsonObject) {
        this.messages = jsonObject;
    }

    public Object getMessages() {
        return messages;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }



    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}

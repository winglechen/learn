package com.wingle.hello.designpattern.chain;

public class Request {
    private final RequestType requestType;
    private final String requestDescription;
    private boolean handled;

    public Request(final RequestType requestType, final String requestDescription) {
        this.requestType = requestType;
        this.requestDescription = requestDescription;
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    @Override
    public String toString() {
        return requestDescription;
    }
}

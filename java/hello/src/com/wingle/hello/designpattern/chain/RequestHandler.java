package com.wingle.hello.designpattern.chain;

public abstract class RequestHandler {
    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if(null != next) {
            next.handleRequest(request);
        }
    }

    public void printHandling(Request request) {
        System.out.println(this + " is handling request: " + request);
    }

    @Override
    public abstract String toString();
}

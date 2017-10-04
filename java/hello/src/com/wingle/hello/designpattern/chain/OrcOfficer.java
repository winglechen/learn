package com.wingle.hello.designpattern.chain;

public class OrcOfficer extends RequestHandler {
    public OrcOfficer(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(RequestType.TORTURE_PRISONER)) {
            printHandling(request);
            request.markHandled();
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc Officer";
    }
}

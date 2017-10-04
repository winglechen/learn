package com.wingle.hello.designpattern.chain;

public class OrcCommander extends RequestHandler {
    public OrcCommander(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
            printHandling(request);
            request.markHandled();
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc Commander";
    }
}

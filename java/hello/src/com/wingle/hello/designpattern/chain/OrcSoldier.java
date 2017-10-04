package com.wingle.hello.designpattern.chain;

public class OrcSoldier extends RequestHandler {
    public OrcSoldier(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(RequestType.COLLECT_TAX)) {
            printHandling(request);
            request.markHandled();
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc Soldier";
    }
}

interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(String request);
}

class ConcreteHandlerA implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("Handler A is processing the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class ConcreteHandlerB implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("Handler B is processing the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}


public class Main{
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest("B");
    }
}

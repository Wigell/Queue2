package client;

public class Controller {
    private int queueLength = 0;
    private String strQueueLength = "";

    public String getQueueLength() {
         strQueueLength = Integer.toString(queueLength);
        return strQueueLength;
    }
    public void setQueueLength(String str) {
        queueLength = Integer.parseInt(strQueueLength) + 1;
    }
    public void remove() {
        queueLength = queueLength - 1;
    }
}

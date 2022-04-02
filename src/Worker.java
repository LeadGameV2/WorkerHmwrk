import java.util.ArrayList;

public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        ArrayList<Integer> failed = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " can't be completed");
                failed.add(i);
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
        if (failed.size() > 0) {
            System.out.println("Task " + failed + " failed");
        }
    }

}

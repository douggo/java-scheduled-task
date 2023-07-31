import java.util.Timer;
import java.util.TimerTask;

class DisableIntegrationTask {

    private final Timer timer;
    private TimerTask disableIntegConfigTask;
    private final long timeToExecute = 1000L * 60L * 60L * 24L; // 86.400.000 milissegundos (1000ms * 60s * 60m * 24h) 
    private final long delayToExecute = 5000L;

    public DisableIntegrationTask() {
        this.timer = new Timer();
        this.createTask();
    }

    private void createTask() {
        if(this.disableIntegConfigTask != null) {
            return;
        }
        this.disableIntegConfigTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task realizada");
            }
        };
    }

    public void execute() {
        this.timer.scheduleAtFixedRate(disableIntegConfigTask, this.delayToExecute, this.timeToExecute);
    }

}

class Execute {

    public static void main(String[] args) {
        DisableIntegrationTask teste = new DisableIntegrationTask();
        teste.execute();
    }

}
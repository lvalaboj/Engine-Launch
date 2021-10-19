/**
 * Rocket class
 *
 * Uses the Engine class to create three engines
 *
 * @author Lakshmi Valaboju, Purdue CS
 * @version July 1, 2021
 */
public class Rocket {
    private int launchTime;
    private int upTime;
    private int totalEngineTime;
    private String status;
    private Engine firstEngine;
    private Engine secondEngine;
    private Engine thirdEngine;

    public Rocket(int totalEngineTime, int launchTime) {
        this.totalEngineTime = totalEngineTime;
        this.launchTime = launchTime;
        firstEngine = new Engine("First");
        secondEngine = new Engine("Second");
        thirdEngine = new Engine("Third");
        upTime = 0;
        status = "";
    }

    public void primeEngines() {
        int first = totalEngineTime * 1 / 3;
        int second = totalEngineTime * 2 / 3;
        firstEngine.setEngineTime(first);
        secondEngine.setEngineTime(second);
        thirdEngine.setEngineTime(totalEngineTime);
    }

    public void countDown() {
        System.out.println("Countdown: " + launchTime);
        while (launchTime > 0) {
            launchTime--;
            System.out.println("Countdown: " + launchTime);
        }
    }

    public boolean launch() {
        if (launchTime == 0) {
            firstEngine.setStatus("On");
            status = "Launch";
            System.out.print(generateReport());
            return true;
        } else {
            return false;
        }
    }

    public void ignite() {
        primeEngines();
        while (launchTime >= 0) {
            if (upTime < firstEngine.getEngineTime()) {
                firstEngine.setStatus("Up");
                System.out.print(generateReport());
            } else if (upTime < secondEngine.getEngineTime()) {
                secondEngine.setStatus("Up");
                firstEngine.setStatus("Down");
                System.out.print(generateReport());
            } else if (upTime < thirdEngine.getEngineTime()) {
                thirdEngine.setStatus("Up");
                secondEngine.setStatus("Down");
                System.out.print(generateReport());
            } else if (upTime == totalEngineTime) {
                firstEngine.setStatus("Detached");
                secondEngine.setStatus("Detached");
                thirdEngine.setStatus("Detached");
                System.out.print(generateReport());
                break;
            }
            upTime++;
        }
    }

    public String generateReport() {
        return "Beginning of Report \n" + "Rocket status " + status + "\n" + "First Engine status " +
                firstEngine.getStatus() + "\n" + "Second Engine status " + secondEngine.getStatus() +
                "\n" + "Third Engine status " + thirdEngine.getStatus() + "\n" + "End of Report" + "\n";
    }

    public int getUpTime() {
        return upTime;
    }

    public int getLaunchTime() {
        return launchTime;
    }

    public Engine getFirstEngine() {
        return firstEngine;
    }

    public Engine getSecondEngine() {
        return secondEngine;
    }

    public Engine getThirdEngine() {
        return thirdEngine;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalEngineTime() {
        return totalEngineTime;
    }

    public void setUpTime(int upTime) {
        this.upTime = upTime;
    }

    public void setLaunchTime(int launchTime) {
        this.launchTime = launchTime;
    }

    public void setFirstEngine(Engine firstEngine) {
        this.firstEngine = firstEngine;
    }

    public void setSecondEngine(Engine secondEngine) {
        this.secondEngine = secondEngine;
    }

    public void setThirdEngine(Engine thirdEngine) {
        this.thirdEngine = thirdEngine;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalEngineTime(int totalEngineTime) {
        this.totalEngineTime = totalEngineTime;
    }

}

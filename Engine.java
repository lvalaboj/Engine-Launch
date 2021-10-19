/**
 * Engine class
 *
 * Gets the basics of the engine data ready to go.
 *
 * @author Lakshmi Valaboju, Purdue CS
 * @version July 1, 2021
 */
public class Engine {
    private String name;
    private String status;
    private int engineTime;

    public Engine(String name) {
        this.name = name;
        status = "Ready";
        engineTime = 0;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getEngineTime() {
        return engineTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEngineTime(int engineTime) {
        this.engineTime = engineTime;
    }


}

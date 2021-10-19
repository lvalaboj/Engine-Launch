import java.util.Scanner;
/**
 * Launch Control
 *
 * Creates the output using Engine and Rocket classes
 *
 * @author Lakshmi Valaboju, Purdue CS
 * @version July 1, 2021
 */
public class LaunchControl {
    public static void main(String[] args) {
        String menu = "What would you like to do?" + "\n" +
                "1. Start Countdown" + "\n" +
                "2. Launch" + "\n" +
                "3. Ignite" + "\n" +
                "4. Quit";
        String greeting = "Launch Control Simulator Active.";
        String launchTimePrompt = "Please enter the launch time:";
        String totalEngineTimePrompt = "Please enter the total engine time:";
        String primingPrompt = "Priming engines...";
        String countdownComplete = "launchTime is now 0.";
        String launchErrorOne = "Error, launchTime is not 0.";
        String launchErrorTwo = "Error, launchTime is already 0.";
        String igniteError = "Error, rocketStatus is not 'Launch'.";
        String launchComplete = "Rocket launch complete!";
        String incomplete = "Exiting without launch sequence...";

        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting);
        System.out.println(launchTimePrompt);
        int launchTime = scanner.nextInt();
        System.out.println(totalEngineTimePrompt);
        int totalEngineTime = scanner.nextInt();
        System.out.println(primingPrompt);
        Rocket rocket = new Rocket(totalEngineTime, launchTime);
        int choice;

        do {
            System.out.println(menu);
            choice = scanner.nextInt();

            if (choice == 1) {
                if (rocket.getLaunchTime() > 0) {
                    rocket.countDown();
                    System.out.println(countdownComplete);
                } else {
                    System.out.println(launchErrorTwo);
                }
            } else if (choice == 2) {
                if (rocket.getLaunchTime() > 0) {
                    System.out.println(launchErrorOne);
                } else {
                    rocket.launch();
                }
            } else if (choice == 3) {
                String status = rocket.getStatus();
                if (status.equals("Launch")) {
                    rocket.ignite();
                    System.out.println(launchComplete);
                    break;
                } else {
                    System.out.println(igniteError);
                }
            } else {
                System.out.println(incomplete);
                break;
            }
        }
        while (choice != 4);

    }
}
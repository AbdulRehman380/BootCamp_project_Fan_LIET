package fans;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class FanDemo {

    public static void main(String[] args) {
        ArrayList<ElectricFan> fanArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fanArrayList.add(new ElectricFan());
        }

        System.out.println("No of fans in warehouse: " + fanArrayList.size());

        Scanner sc = new Scanner(System.in);
        boolean outerRunning = true;
        int TotalCount = 0;


        while (outerRunning) {
            System.out.print("Enter the fan number to test (0 - " + (fanArrayList.size() - 1) + "): ");
            int fanSelected = sc.nextInt();

            if (fanSelected < 0 || fanSelected >= fanArrayList.size()) {
                System.out.println("Invalid fan number.");
                continue;
            }

            ElectricFan f1 = fanArrayList.get(fanSelected);
            boolean running = true;

            while (running) {
                System.out.println("\n--- Fan Controls ---");
                System.out.println("1) Switch on the fan.");
                System.out.println("2) Switch off the fan.");
                System.out.println("3) Increase the fan speed.");
                System.out.println("4) Decrease the fan speed.");
                System.out.println("5) Select another fan.");
                System.out.println("6) List all fans that are ON.");
                System.out.println("7) - Exit");
                System.out.println("8) Total operation count.");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        if (!f1.isSwitchedOn()) {
                            f1.switchOnTheFan();
                            TotalCount++;
                        } else {
                            System.out.println("Fan is already running");
                        }
                    }
                    case 2 -> {
                        f1.switchOffTheFan();
                        TotalCount++;

                    }
                    case 3 -> {
                        f1.increaseSpeed();
                        TotalCount++;

                        System.out.println("Fan speed is now: " + f1.getSpeed());
                    }
                    case 4 -> {
                        f1.decreaseSpeed();
                        TotalCount++;

                        System.out.println("Fan speed is now: " + f1.getSpeed());
                    }
                    case 5 -> {
                        running = false;
                        TotalCount++;

                    }
//                    case 6 -> {
//                        System.out.println("\n--- List of Fans that are ON ---");
//                        boolean anyOn = false;
//                        for (int i = 0; i < fanArrayList.size(); i++) {
//                            ElectricFan fan = fanArrayList.get(i);
//                            if (fan.isSwitchedOn()) {
//                                System.out.println("Fan #" + i + " | Speed: " + fan.getSpeed());
//                                anyOn = true;
//                            }
//                        }
//                        if (!anyOn) {
//                            System.out.println("No fans are currently ON.");
//                        }
//                    }
                    case 6 -> {
                        System.out.println("\n--- List of Fans that are ON ---");
                        int count = 0;
                        for (int i = 0; i < fanArrayList.size(); i++) {
                            ElectricFan fan = fanArrayList.get(i);
                            if (fan.isSwitchedOn()) {
                                System.out.println("Fan #" + i + " | Speed: " + fan.getSpeed());
                                count++;
                            }
                        }
                        if (count == 0) {
                            System.out.println("No fans are currently ON.");
                        } else {
                            System.out.println("Total fans ON: " + count);
                        }
                    }
                    case 7 -> {
                        System.out.println("Exiting.");
                        return;
                    }
                    case 8 -> {
                        System.out.println("Over all count of buttons tested : " + TotalCount);
                    }

                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}

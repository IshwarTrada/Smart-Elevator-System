import java.util.Scanner;
import java.lang.*;


class printDelay{
    public static void printWithDelay(String str, int delay) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            Thread.sleep(delay);
        }
        System.out.println();
    }
}

// For Number of floors, we want to build the lift
// Lift Floor
class Total_Floor {
    Scanner s = new Scanner(System.in);

    // Floor Input & print and default it is on the ground floor & return total floor
    short total_floor() throws InterruptedException {
        //Lift Floor
        short f_no;
        String des = "-------------------------------------------------------------------------";
        printDelay.printWithDelay(des, 20);
        System.out.println("\tWrite down the number of floors of the lift to be built");
        printDelay.printWithDelay(des, 20);
        f_no = s.nextShort();
        if(f_no<0)
        {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Invalid Input...");
            System.out.println("-------------------------------------------------------------------------");
            total_floor();
        }

        printDelay.printWithDelay(des, 20);
        for (int i = 0; i <= f_no; i++) {
            System.out.println("\t\tLift at Floor no. " + i + " is now ready to use...");
            Thread.sleep(700);
        }
        printDelay.printWithDelay(des, 20);

        System.out.println("\t\tCurrently Lift is on the \" Ground Floor(0) \"");
        printDelay.printWithDelay(des, 20);
        return f_no;
    }

    // Extra Floor Input & print & return new total floor
    short extra_floor_lift(short f_no, short current_floor) throws InterruptedException {
        short ex_f_no, t;
        String des = "-------------------------------------------------------------------------";
        System.out.println();
        printDelay.printWithDelay(des, 20);
        System.out.println(" Write down the extra number of floors of the lift you want to be built");
        printDelay.printWithDelay(des, 20);
        ex_f_no = s.nextShort();
        if(ex_f_no<0){
            System.out.println("\nInvalid Input , Please enter Floor number in Positive");
            return extra_floor_lift(f_no,current_floor);
        }
        else {
            printDelay.printWithDelay(des, 20);
            t = (short) (f_no + ex_f_no);
            for (int i = (f_no + 1); i <= t; i++) {
                System.out.println("\t\tLift at Floor no. " + i + " is now ready to use...");
                Thread.sleep(700);
            }
            if (ex_f_no == 0) {
                System.out.println("\t\t\tYou have available Elevator service");
                System.out.println("\t\t\t\t upto " + t + " Floors");
                System.out.println("\t\t\tYou are Currently at " + current_floor + " Floor");
                printDelay.printWithDelay(des, 20);
            } else {
                System.out.println("\n\t\tNow, You have available Elevator service");
                System.out.println("\t\t\t\tupto " + t + " Floors");
                System.out.println("\t\t\tYou are Currently at " + current_floor + " Floor");
                printDelay.printWithDelay(des, 20);
            }
            return t;
        }
    }
}

class Floor_No extends Total_Floor {

    // Input(Where we want to go) & print where we arrive
    void floor_No(short current_floor, short f_no) throws InterruptedException {
        //short current_floor = 0;
        short i, f_n;
        do {
            System.out.print("\nEnter Floor Number where you want to go : ");
            f_n = s.nextShort();
            if(f_n<0){
                clr.clearScreen();
                System.out.println("\n\n" +
                        "$$\\   $$\\                                                         $$\\                     \n" +
                        "$$$\\  $$ |                                                        \\__|                    \n" +
                        "$$$$\\ $$ | $$$$$$\\         $$$$$$$\\  $$$$$$\\   $$$$$$\\ $$\\    $$\\ $$\\  $$$$$$$\\  $$$$$$\\  \n" +
                        "$$ $$\\$$ |$$  __$$\\       $$  _____|$$  __$$\\ $$  __$$\\\\$$\\  $$  |$$ |$$  _____|$$  __$$\\ \n" +
                        "$$ \\$$$$ |$$ /  $$ |      \\$$$$$$\\  $$$$$$$$ |$$ |  \\__|\\$$\\$$  / $$ |$$ /      $$$$$$$$ |\n" +
                        "$$ |\\$$$ |$$ |  $$ |       \\____$$\\ $$   ____|$$ |       \\$$$  /  $$ |$$ |      $$   ____|\n" +
                        "$$ | \\$$ |\\$$$$$$  |      $$$$$$$  |\\$$$$$$$\\ $$ |        \\$  /   $$ |\\$$$$$$$\\ \\$$$$$$$\\ \n" +
                        "\\__|  \\__| \\______/       \\_______/  \\_______|\\__|         \\_/    \\__| \\_______| \\_______|\n\n\n");
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("\t\tSorry, We Don't Provide Underground Lift Service...");
                System.out.println("-------------------------------------------------------------------------");
            }
            else if (f_n <= f_no && f_n >= 0 && f_n != current_floor) {
                if (current_floor < f_n) {
                    Thread.sleep(700);
                    System.out.println("Floor :: " + current_floor + " (Current Floor)");
                    Thread.sleep(700);
                    for (i = (short) (current_floor + 1); i < f_n; i++) {
                        System.out.println("Floor :: " + i);
                        Thread.sleep(700);
                    }
                    System.out.println("Floor :: " + f_n + " (You Arrived)");
                    Thread.sleep(700);
                    current_floor = f_n;
                } else {
                    Thread.sleep(700);
                    System.out.println("Floor :: " + current_floor + " (Current Floor)");
                    Thread.sleep(700);
                    for (i = (short) (current_floor - 1); i > f_n; i--) {
                        System.out.println("Floor :: " + i);
                        Thread.sleep(700);
                    }
                    System.out.println("Floor :: " + f_n + " (You Arrived)");
                    Thread.sleep(700);
                    current_floor = f_n;
                }
            } else if (f_n == current_floor) {

                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("\t\t\t\tYou are already there....");
                System.out.println("-------------------------------------------------------------------------");
            } else {
                clr.clearScreen();
                System.out.println("\n\n" +
                        "$$\\   $$\\                                                         $$\\                     \n" +
                        "$$$\\  $$ |                                                        \\__|                    \n" +
                        "$$$$\\ $$ | $$$$$$\\         $$$$$$$\\  $$$$$$\\   $$$$$$\\ $$\\    $$\\ $$\\  $$$$$$$\\  $$$$$$\\  \n" +
                        "$$ $$\\$$ |$$  __$$\\       $$  _____|$$  __$$\\ $$  __$$\\\\$$\\  $$  |$$ |$$  _____|$$  __$$\\ \n" +
                        "$$ \\$$$$ |$$ /  $$ |      \\$$$$$$\\  $$$$$$$$ |$$ |  \\__|\\$$\\$$  / $$ |$$ /      $$$$$$$$ |\n" +
                        "$$ |\\$$$ |$$ |  $$ |       \\____$$\\ $$   ____|$$ |       \\$$$  /  $$ |$$ |      $$   ____|\n" +
                        "$$ | \\$$ |\\$$$$$$  |      $$$$$$$  |\\$$$$$$$\\ $$ |        \\$  /   $$ |\\$$$$$$$\\ \\$$$$$$$\\ \n" +
                        "\\__|  \\__| \\______/       \\_______/  \\_______|\\__|         \\_/    \\__| \\_______| \\_______|\n\n");
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("\t  Sorry,Currently there is no lift service available...");
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("\t\t\tFor Rebuild / Continue enter :: 1");
                System.out.println("\t\t\t   For Deadend/Exit enter :: 0");
                System.out.println("-------------------------------------------------------------------------\n");
                Rebuild r = new Rebuild();
                r.rebuild(f_no, current_floor);
            }
        } while ((f_n <= f_no) && (f_n >= 0));
    }
}

class Rebuild extends Floor_No {


    // Input (rebuild/extra floor) or exit for  Positive extra lift number which is not existing
    void rebuild(short f_no, short current_floor) throws InterruptedException {
        System.out.print("Enter your choice : ");
        short b = s.nextShort();
        clr.clearScreen();
        switch (b) {
            case 0 : {
                clr.clearScreen();
                break;
            }
            case 1 : {
                clr.clearScreen();
                System.out.println("\n\nFor Rebuilding, Enter extra floor number");
                System.out.println("For Continue enter 0");
                short t1 = extra_floor_lift(f_no, current_floor);
                floor_No(current_floor, t1);
                break;
            }
            default : {
                System.out.println("Invalid Input");
                rebuild(f_no, current_floor);
            }
        }
    }
}
class clr{
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
public class Lift extends Rebuild {
    public static void main(String[] args) throws InterruptedException {
        clr.clearScreen();
        System.out.println("\n" +
                "                   __              __  ___                             \n" +
                "                  /__`  |\\/|  /\\  |__)  |                              \n" +
                "                  .__/  |  | /~~\\ |  \\  |                              \n" +
                "                                                                       \n" +
                " ___       ___           ___  __   __      __       __  ___  ___       \n" +
                "|__  |    |__  \\  /  /\\   |  /  \\ |__)    /__` \\ / /__`  |  |__   |\\/| \n" +
                "|___ |___ |___  \\/  /~~\\  |  \\__/ |  \\    .__/  |  .__/  |  |___  |  | \n" +
                "                                                                       \n");
        Total_Floor tf = new Total_Floor();
        short a = tf.total_floor();
        Floor_No z = new Floor_No();
        z.floor_No((short) 0, a);
    }
}
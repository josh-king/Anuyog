package tk.joshking.anuyog;

import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Simple program that uses a combination within a preset array and then
 * randomly generates certain lookup values and then check to see if they have
 * created the target combination.
 *
 * The chance is 1 in 1679616
 *
 * @author joshking.tk
 */
public class Anuyog {
    static String[] syllables = new String[] { "anu", "yog", "moh", "ara",
            "dar", "ji" };
    static String anu = "anuyog mohara darji", name = "";
    static String print;
    static Random rand = new Random();
    static long startTime, duration;
    static int temp0 = 0, temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0,
            temp5 = 0, counter = 0;

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        startTime = System.nanoTime();
        System.out.println("What's your name now?");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new AnuPanel().setVisible(true);
        });

        loop();
    }

    static void loop() {
        do {
            for (int i = 0; i < syllables.length; i++) {
                generate(syllables.length);

                name = syllables[temp0] + syllables[temp1] + " "
                        + syllables[temp2] + syllables[temp3] + " "
                        + syllables[temp4] + syllables[temp5];

                counter += 1;

                System.out.println(String.format(
                        "Tried %s. Total: %d time(s)!", name, counter));
                duration = System.nanoTime() - startTime;
            }

            if (name.equalsIgnoreCase(anu)) {
                info(name, counter, duration);
                break;
            }
        } while (!name.equalsIgnoreCase(anu));
    }

    /**
     * Generate the random lookup values.
     *
     * @param i
     *            Return random int for the different array values
     */
    static void generate(int i) {
        temp0 = rand.nextInt(i);
        temp1 = rand.nextInt(i);
        temp2 = rand.nextInt(i);
        temp3 = rand.nextInt(i);
        temp4 = rand.nextInt(i);
        temp5 = rand.nextInt(i);
    }

    /**
     * Just a basic method to clean up code, separates it from the actual main
     * method
     *
     * @param s
     *            String of final result
     * @param i
     *            Total tried combinations
     * @param l
     *            System.nanTime() calculation
     */
    static void info(String s, int i, long l) {
        System.out.println("////////////////////INFO////////////////////");
        System.out.println("Target combination: " + anu);
        System.out.println("Final result: " + s);
        System.out.println("Total combinations tried: " + i);
        System.out.println("Total time run: " + (l / 1000000000) + "(s)");
        System.out.println("Created by: josh king (joshking.tk)");
        System.out.println("////////////////////////////////////////////");
    }
}

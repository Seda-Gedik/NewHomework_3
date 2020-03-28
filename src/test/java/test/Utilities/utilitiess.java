package test.Utilities;

public class utilitiess {
    /**
     * Pause test for some time
     *
     * @param seconds
     */

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

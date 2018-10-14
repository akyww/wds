/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela2;

/**
 *
 * @author joel
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Matei
 *
 */
public class NetworkConnectionsLoader implements Runnable {

    private static final String STRING_THREAD_EXECUTION_START = "Beginning network connections loading: %s\n";
    private static final String STRING_THREAD_EXECUTION_END = "Network connections loading has finished: %s\n";
    
    private static final long LONG_THREAD_SLEEP_TIME = 6L;
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.printf(STRING_THREAD_EXECUTION_START, new Date());
        
        try {
            TimeUnit.SECONDS.sleep(LONG_THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.printf(STRING_THREAD_EXECUTION_END, new Date());
    }

}


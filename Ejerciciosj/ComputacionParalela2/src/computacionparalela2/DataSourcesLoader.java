/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class DataSourcesLoader implements Runnable{
    
    @Override
    //Implementando metodo run.
    public void run()
    {
        //Indica la fecha y hora de ejecución.
        System.out.printf("Beginning data souces loagind : %s\n", new Date() );
        try{
            //Lo detiene por 4 segundos.
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //Imprime mensaje que terminó la ejecución, fecha y hora.
        System.out.printf("Data sources loading has finished : %s\n", new Date());
    }
}

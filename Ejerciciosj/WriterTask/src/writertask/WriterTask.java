/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writertask;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class WriterTask implements Runnable {
    
    //Creando una cola de objetos de nuestra clase Event
    private Deque<Event> deque;
    //Constructor
    public WriterTask(Deque<Event> deque)
    {
        this.deque = deque;
    }
    @Override
    //Creando un nuevo evento en cada iteración, se enviala fecha y un nuevo evento
    //Se agrega el evento a la cola
    //Se da un tiempo de 1 segundo para cada evento.
    public void run()
    {
        for(int i = 1; i<=100 ; i++)
        {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event",Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}

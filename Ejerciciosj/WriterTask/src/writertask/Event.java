/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writertask;

import java.util.Date;

/**
 *
 * @author joel
 */
public class Event {
    private Date date;
    private String event;
    
    public Event()
    {
        
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public String getEvent()
    {
        return event;
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public void setEvent(String event)
    {
        this.event = event;
    }
    
}

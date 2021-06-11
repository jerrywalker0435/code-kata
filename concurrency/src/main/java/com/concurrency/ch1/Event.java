package com.concurrency.ch1;

import java.util.Date;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class Event {

    private Date date;
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

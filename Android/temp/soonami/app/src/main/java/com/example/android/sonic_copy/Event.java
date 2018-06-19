package com.example.android.sonic_copy;

public class Event {

    private String eventTitle;
    private long unixTimeInMillis;
    private int hasTsunmaiAlert;

    public Event(String eventTitle, long unixTimeInMillis, int hasTsunmaiAlert) {
        this.eventTitle = eventTitle;
        this.unixTimeInMillis = unixTimeInMillis;
        this.hasTsunmaiAlert = hasTsunmaiAlert;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public long getUnixTimeInMillis() {
        return unixTimeInMillis;
    }

    public void setUnixTimeInMillis(long unixTimeInMillis) {
        this.unixTimeInMillis = unixTimeInMillis;
    }

    public int getHasTsunmaiAlert() {
        return hasTsunmaiAlert;
    }

    public void setHasTsunmaiAlert(int hasTsunmaiAlert) {
        this.hasTsunmaiAlert = hasTsunmaiAlert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (unixTimeInMillis != event.unixTimeInMillis) return false;
        if (hasTsunmaiAlert != event.hasTsunmaiAlert) return false;
        return eventTitle != null ? eventTitle.equals(event.eventTitle) : event.eventTitle == null;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventTitle='" + eventTitle + '\'' +
                '}';
    }
}

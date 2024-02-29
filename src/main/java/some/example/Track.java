package com.home.java.demo.thread;

public class Track
{
    int trackno;

    public Track(int trackno) {
        this.trackno = trackno;
    }

    void show_data()
    {
        System.out.println("Track Id = "+trackno+"    ");
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackno=" + trackno +
                '}';
    }
}

package com.burra.practice.leetcode;

public class AngleBetweenHandsClock {
    public double angleClock(int hour, int minutes) {
        double minutesFraction = (double)minutes/60;
        double hoursAngle = 30*(double)hour + 30*minutesFraction;
        int mintesNumber = minutes/5;
        int minutesReminder = minutes%5;
        double mintesAngle = 30*mintesNumber + minutesReminder * 6;

        double val = Math.abs(hoursAngle - mintesAngle);
        return val > 180 ? 360-val : val;
    }

    public static void main(String args[])
    {
        AngleBetweenHandsClock a = new AngleBetweenHandsClock();
        System.out.println(a.angleClock(12, 30));
    }
}

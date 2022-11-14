package com.burra.practice.softwareAg;

import java.util.concurrent.atomic.AtomicInteger;

// Thread safe class since every thread can read the most updated value of min, max, mean, and variance.
public class SingletonStatisticImpl implements Statistic{
    private static Statistic instance;

    // initializing at this point is readable and find the default values right away
    private final AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
    private final AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

    // since there is not atomicFloat type, I used integer to store byte code of float value and covert to int values to
    // float on every read operation.
    private final AtomicInteger currentAverage = new AtomicInteger();
    private final AtomicInteger variance = new AtomicInteger();

    // These variables are not accessed by multiple threads simultaneously because of the synchronized block on event
    private int count;
    private float prevAverage;
    private float sumOfSquares;

    private SingletonStatisticImpl() {
    }

    // Used singleton pattern to make sure that only one instance of the class exists. This also prevents accidental
    // creation the instance. Assuming that we only need one statistics calculator for the data stream.
    // Still debating on this.
    public static Statistic getInstance() {
        if(instance == null){
            instance = new SingletonStatisticImpl();
        }
        return instance;
    }


    // Trade off for using synchronized on the event method, multiple threads cannot use enter the add at the same time
    // Assumption that event is called less frequent than min, max, mean, and variance methods.
    // And it is easy to segregate mathematical operations to a single method to achieve thread safe code, and also
    // it is more maintainable and easy to troubleshoot issues since variance calculation depends on mean().
    @Override
    public synchronized void event(int value) {
        count++;
        if(count == 1) {
            prevAverage = value;
            currentAverage.set(Float.floatToIntBits(value));
            sumOfSquares = 0f;
        }
        else {
            // compromise on readability to achieve atomic operations on float values using atomic integer
            currentAverage.set(Float.floatToIntBits(prevAverage + (value - prevAverage)/count)); // Mk = Mk-1+ (xk – Mk-1)/k
            sumOfSquares += (value - prevAverage) * (value - Float.intBitsToFloat(currentAverage.get())); // Sk = Sk-1 + (xk – Mk-1)*(xk – Mk).

            prevAverage = Float.intBitsToFloat(currentAverage.get()); // updating current values to previous variable to calculate next input value
            variance.set(Float.floatToIntBits(sumOfSquares /(count-1)));
        }

        min.set(Math.min(min.get(), value));
        max.set(Math.max(max.get(), value));
    }

    @Override
    public float mean() {
        return Float.intBitsToFloat(currentAverage.get()); // assuming read operating is more frequent than read operation
    }

    @Override
    public int minimum() {
        return min.get();
    }

    @Override
    public int maximum() {
        return max.get();
    }

    @Override
    public float variance() {
        return Float.intBitsToFloat(variance.get()); // assuming read operating is more frequent than read operation
    }
}

package com.example.oooh;
import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class TimerManager {


        public AnimationTimer timer;
        private LongProperty elapsedTime;

         static TimerManager instance;
    public static boolean timeon=false;
    public static boolean timeoff=false;

        public TimerManager() {
            elapsedTime = new SimpleLongProperty();
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    long elapsed = (now - startTime) / 1000000000;
                    elapsedTime.set(elapsed);
                }
            };
        }

        public static TimerManager getInstance() {
            if (instance == null) {
                instance = new TimerManager();
            }
            return instance;
        }

        public void start() {
            startTime = System.nanoTime();
            timer.start();
            timeon=true;
            timeoff=false;
        }

        public void stop() {
            timer.stop();
            timeon=false;
            timeoff=true;
        }

        public LongProperty elapsedTimeProperty() {
            return elapsedTime;
        }

        private long startTime;
    }


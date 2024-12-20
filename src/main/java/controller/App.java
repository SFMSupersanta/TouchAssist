package controller;

import java.awt.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Continuous Mouse Pointer Position Tracker...");
        trackMousePositionContinuously();
    }

    private static void trackMousePositionContinuously() {
        new Thread(() -> {
            try {
                Point lastMousePosition = MouseInfo.getPointerInfo().getLocation();
                while (true) {
                    Point currentMousePosition = MouseInfo.getPointerInfo().getLocation();

                    // Print only if the position has changed to avoid redundant logs
                    if (!currentMousePosition.equals(lastMousePosition)) {
                        System.out.println("Mouse: " + currentMousePosition.getX() + " " + currentMousePosition.getY());
                        lastMousePosition = currentMousePosition;
                    }

                    // Sleep for a short interval to reduce CPU usage
                    Thread.sleep(50); // 50ms interval
                }
            } catch (InterruptedException e) {
                System.err.println("Mouse tracking thread interrupted.");
            }
        }).start();
    }
}

package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        int moveFloor = floor - currentFloor;

        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Этаж задан не верно!");
        } else if (floor == currentFloor) {
            System.out.println("Вы уже на этом этаже!");
        } else {
            if (moveFloor > 0) {
                for (int i = 0; i < moveFloor; i++) {
                    moveUp();
                    System.out.println("Едеме вверх. Вы сейчас на " + currentFloor + " этаже");
                }
            } else if (moveFloor < 0) {
                for (int i = 0; i < -moveFloor; i++) {
                    moveDown();
                    System.out.println("Едем вниз. Вы сейчас на " + currentFloor + " этаже");
                }
            }
        }
    }
}

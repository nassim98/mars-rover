package org.rover.model;

public class Rover implements Movable {
    private int x, y;
    private Direction direction;
    private int plateauWidth, plateauHeight;

    public Rover(int x, int y, Direction direction, int plateauWidth, int plateauHeight) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateauWidth = plateauWidth;
        this.plateauHeight = plateauHeight;
    }

    @Override
    public void move() {
        switch (direction) {
            case N:
                if (y < plateauHeight) y++;
                break;
            case E:
                if (x < plateauWidth) x++;
                break;
            case S:
                if (y > 0) y--;
                break;
            case W:
                if (x > 0) x--;
                break;
        }
    }

    @Override
    public void rotateLeft() {
        this.direction = direction.turnLeft();
    }

    @Override
    public void rotateRight() {
        this.direction = direction.turnRight();
    }

    public String getPosition() {
        return x + " " + y + " " + direction;
    }

    public void processInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    rotateLeft();
                    break;
                case 'R':
                    rotateRight();
                    break;
                case 'M':
                    move();
                    break;
            }
        }
    }

}
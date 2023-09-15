public class Chandrayan{
    private int x, y, z;
    private char directionInPlane;
    private int facing_in_Z_axis; //this variable will hold the value 1 - when its facing_UP 
                                  //                                 -1 - when its facing_Down
                                  //                                  0 - when its in either of N/S/E/W (neither up nor down)

    public Chandrayan(int x, int y, int z, char directionInPlane) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.directionInPlane = directionInPlane;
        facing_in_Z_axis = 0;
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void moveWest() {
            x = getX() - 1; 
    }

    public void moveNorth() {
            y = getY() + 1;
    }

    public void moveEast() {
            x = getX() + 1;
    }

    public void moveSouth() {
        y = getY() - 1;
    }

    public void move(char moves) {
        switch (moves) {
            case 'f':
                if (facing_in_Z_axis == 0) {
                    switch (directionInPlane) {
                        case 'N':
                            moveNorth();
                            break;
                        case 'S':
                            moveSouth();
                            break;
                        case 'E':
                            moveEast();
                            break;
                        case 'W':
                            moveWest();
                            break;
                    }
                } else if (facing_in_Z_axis != 0) {
                    z = getZ() + facing_in_Z_axis;
                }
                break;
                
            case 'b':
                if (facing_in_Z_axis == 0) {
                    switch (directionInPlane) {
                        case 'N':
                            moveSouth(); // backward of north is move south
                            break;
                        case 'S':
                            moveNorth();;
                            break;
                        case 'E':
                            moveWest();;
                            break;
                        case 'W':
                            moveEast();;
                            break;
                    }
                } else if (facing_in_Z_axis != 0) {
                    z = getZ() - facing_in_Z_axis;
                }
                break;
        }
    }

    public void turn(char direction) {
        switch (direction) {
            case 'l':
                switch (directionInPlane) {
                    case 'N':
                        directionInPlane = 'W'; // left of north is west
                        facing_in_Z_axis = 0; // reset to 0 zero when directionInPlane = 'W'/'N'/'S'/'E';
                        break;
                    case 'E':
                        directionInPlane = 'N';
                        facing_in_Z_axis = 0;
                        break;
                    case 'W':
                        directionInPlane = 'S';
                        facing_in_Z_axis = 0;
                        break;
                    case 'S':
                        directionInPlane = 'E';
                        facing_in_Z_axis = 0;
                        break;
                }
                break;
                
            case 'r':
                switch (directionInPlane) {
                    case 'N':
                        directionInPlane = 'E'; // right of north is east
                        facing_in_Z_axis = 0; // reset to 0 zero when directionInPlane = 'W'/'N'/'S'/'E';
                        break;
                    case 'E':
                        directionInPlane = 'S';
                        facing_in_Z_axis = 0;
                        break;
                    case 'W':
                        directionInPlane = 'N';
                        facing_in_Z_axis = 0;
                        break;
                    case 'S':
                        directionInPlane = 'W';
                        facing_in_Z_axis = 0;
                        break;
                }
                break;
                
            case 'u':
                facing_in_Z_axis = 1; // setting it to 1 since its facing UP
                break;
                
            case 'd':
                facing_in_Z_axis = -1; // setting it to -1 since its facing down
                break;
        }
    }

    public void printLocAndDir() {
        System.out.println("\n" + x + " " + y + " " + z + " : ");
        if (facing_in_Z_axis == 0) {
            System.out.print(directionInPlane);
        } else if (facing_in_Z_axis == 1) {
            System.out.print("U");
        } else if (facing_in_Z_axis == -1) {
            System.out.print("D");
        }
    } // function to print current coordinates and direction
}
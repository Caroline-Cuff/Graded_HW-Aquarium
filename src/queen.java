import java.awt.*;


public class queen {

//Variable Declaration
public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive; //a boolean to denote if the hero is alive or dead.
//    public Rectangle hitbox;
//    public Boolean isCrashing;

public queen (int pxpos, int pypos){

    xpos = pxpos;
    ypos = pypos;
    dx = 1;
    dy = 1;
    width =49;
    height = 90;
    isAlive = true;

}
    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;

    }

}

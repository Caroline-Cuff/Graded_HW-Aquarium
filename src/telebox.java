import java.awt.*;

public class telebox {
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive; //a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;
    public Boolean isCrashing;

    public telebox (int pxpos, int pypos){

        xpos = pxpos;
        ypos = pypos;
        dx = 3;
        dy = 6;
        width =100;
        height = 120;
        isAlive = true;
        hitbox = new Rectangle(xpos, ypos, width, height);
        isCrashing = false;

    }
    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        if (ypos>700) { // wrap at bottom wall
            dy = -dy;
        }
        if (ypos < 0){
            dy = -dy;
        }
        if (xpos > 1000 - width){
            dx = -dx;
        }
        if (xpos <  0){
            dx = -dx;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;

        hitbox = new Rectangle(xpos,ypos, width, height);
    }


}

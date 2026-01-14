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
    public Rectangle hitbox;
    public Boolean isCrashing;

public queen (int pxpos, int pypos){

    xpos = pxpos;
    ypos = pypos;
    dx = -7;
    dy = 10;
    width =98;
    height = 180;
    isAlive = true;
    hitbox = new Rectangle(xpos, ypos, width, height);
    isCrashing = false;

}
    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        if (ypos>700) { // wrap at bottom wall
            ypos = 0;
        }
        if (ypos < 0){
            ypos = 700;
        }
        if (xpos > 1000){
            xpos = 1;
        }
        if (xpos < 0){
            xpos = 1000;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;

        hitbox = new Rectangle(xpos,ypos, width, height);
    }



}

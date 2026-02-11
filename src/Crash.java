import java.awt.*;

public class Crash {

    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive; //a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;

    public Crash (int pxpos, int pypos){

        xpos = pxpos;
        ypos = pypos;
        width =50;
        height = 50;
        isAlive = false;
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

}



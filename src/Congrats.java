import java.awt.*;

public class Congrats {


    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive; //a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;

    public Congrats (int pxpos, int pypos){

        xpos = pxpos;
        ypos = pypos;
        width =100;
        height = 120;
        isAlive = false;
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

}

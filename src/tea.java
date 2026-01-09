public class tea {

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

        public tea (int pxpos, int pypos){

            xpos = pxpos;
            ypos = pypos;
            dx = 3;
            dy = 6;
            width =30;
            height = 30;
            isAlive = true;

        }
        //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
        public void move() {
            xpos = xpos + dx;
            ypos = ypos + dy;

        }

    }


//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//astroPic = tea

//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image teaPic;
    public Image queenPic;
    public Image backgroundpic;
    public Image crownpic;
    public Image telepic;

    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    private tea earlg;
    private queen liz;
    private Crown coro;
    private telebox telebo;


    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method


    }


    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() {

        setUpGraphics();
        //randomness
        // 10 is number of numbers, starts at 0
        // eg 0-9
        int randx = (int) (Math.random() * 10);

        //1-10
        randx = (int) (Math.random() * 10) + 1;

        //1-1000
        randx = (int) (Math.random() * 1000) + 1;

        //1-700
        int randy = (int) (Math.random() * 700) + 1;

        //variable and objects
        //create (construct) the objects needed for the game and load up
        teaPic = Toolkit.getDefaultToolkit().getImage("tea.jpg"); //load the picture
        earlg = new tea(randx, randy);
        queenPic = Toolkit.getDefaultToolkit().getImage("queen.png");
        liz = new queen(randx, randy);
        backgroundpic = Toolkit.getDefaultToolkit().getImage("backgrounduj.jpg");
        crownpic = Toolkit.getDefaultToolkit().getImage("crown.jpg");
        coro = new Crown(randx, randy);
        telepic = Toolkit.getDefaultToolkit().getImage("tbox.jpg");
        telebo = new telebox(randx, randy);


    }// BasicGameApp()


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
        }
    }


    public void moveThings() {
        //calls the move( ) code in the objects
        earlg.move();
        liz.move();
        coro.move();
        telebo.move();

    }

    public void crashing() {
        // if astros crash into each other
        if (liz.hitbox.intersects(earlg.hitbox)) {
            System.out.println("CRASH");
            liz.dx = -liz.dx;
            earlg.dx = -earlg.dx;
            liz.dy = -liz.dy;
            earlg.dy = -earlg.dy;
        }
    }

//        if (coro.hitbox.intersects(telebo.hitbox)) {
//            System.out.println("CRASH AST");
//
//            coro.height = liz.height + 25;
//
//        }



//Pauses or sleeps the computer for the amount specified in milliseconds
public void pause(int time) {
    //sleep
    try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
    }
}

//Graphics setup method
private void setUpGraphics() {
    frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

    panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
    panel.setLayout(null);   //set the layout

    // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
    // and trap input events (Mouse and Keyboard events)
    canvas = new Canvas();
    canvas.setBounds(0, 0, WIDTH, HEIGHT);
    canvas.setIgnoreRepaint(true);

    panel.add(canvas);  // adds the canvas to the panel.

    // frame operations
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
    frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
    frame.setResizable(false);   //makes it so the frame cannot be resized
    frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

    // sets up things so the screen displays images nicely.
    canvas.createBufferStrategy(2);
    bufferStrategy = canvas.getBufferStrategy();
    canvas.requestFocus();
    System.out.println("DONE graphic setup");

}


//paints things on the screen using bufferStrategy
private void render() {
    Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
    g.clearRect(0, 0, WIDTH, HEIGHT);

    //draw the image of the astronaut
    g.drawImage(backgroundpic, 0, 0, WIDTH, HEIGHT, null);
    g.drawImage(teaPic, earlg.xpos, earlg.ypos, earlg.width, earlg.height, null);
    g.drawImage(queenPic, liz.xpos, liz.ypos, liz.width, liz.height, null);
    g.drawImage(crownpic, coro.xpos, coro.ypos, coro.width, coro.height, null);
    g.drawImage(telepic, telebo.xpos, telebo.ypos, telebo.width, telebo.height, null);


    g.dispose();

    bufferStrategy.show();
}
}
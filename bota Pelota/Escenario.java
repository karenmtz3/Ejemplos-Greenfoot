import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escenario extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Escenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 
        prepare();
    }

    @Override
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //System.out.println("Click en el mundo");
            MouseInfo raton = Greenfoot.getMouseInfo();
            // System.out.println("Coords x = "+raton.getX() +
            //"Coordenadas y = " + raton.getY());
            Pelota pelota = new Pelota();
            super.addObject(pelota,raton.getX(), raton.getY());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Personaje persona = new Personaje();
        addObject(persona,270,378);
        Pelota pelota = new Pelota();
        addObject(pelota,82,86);
        Pelota pelota2 = new Pelota();
        addObject(pelota2,259,79);
        Pelota pelota3 = new Pelota();
        addObject(pelota3,423,240);
    }
}

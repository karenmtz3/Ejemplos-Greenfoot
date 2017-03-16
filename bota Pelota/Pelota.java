import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pelota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pelota extends Actor
{
    private int incx;
    private int incy;
    
    public Pelota()
    {
        incx = 10;
        incy = 10;
        int x = Greenfoot.getRandomNumber(10);
        int y = Greenfoot.getRandomNumber(10);
        if(x <= 5){
            x = 1;
        }
        else{
            x =-1;
        }
        if(y <= 5){
            y = 1;
        }
        else{
            y = -1;
        }
    }
    
    @Override
    public void act() 
    {
        //consulta las coords actuales heredadas de actor
        int posx = this.getX();
        int posy = this.getY();
        
        //calcula las nuevas coords
        int nuevox = posx + incx;
        int nuevoy = posy + incy;
        
        World mundo = this.getWorld();
        if(nuevox > mundo.getWidth()) //rebota derecho
        {
            incx = -incx;
        }
        
         if(nuevoy > mundo.getHeight()) //rebota abajo
        {
            incy = -incy;
        }
        
         if(nuevoy < 0) //rebota arriba
        {
            incy = -incy;
        }
        
          if(nuevox < 0) //rebota izquierda
        {
            incx = -incx;
        }
        //cambiamos de posicion a la pelota
        this.setLocation(nuevox, nuevoy);
    }       
}

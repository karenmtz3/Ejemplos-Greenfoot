import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor
{
    private boolean disparando;
    
    public Personaje()
    {
        disparando = false;
    }
    
    @Override
    public void act() 
    {
        //si presiona la tecla derecha
        if(Greenfoot.isKeyDown("right"))
        {
            //mueve a la derecha
           this.setLocation(this.getX()+3, this.getY());
        }
        
        //si presiona tecla izq
        if(Greenfoot.isKeyDown("left"))
        {
            //mueve a la isquierda
           this.setLocation(this.getX()-3, this.getY());
        }
        
        //si se presiona la barra espaciadora
        if(Greenfoot.isKeyDown("space") && !disparando)
        {
           Disparo d = new Disparo();
           World mundo = this.getWorld();
           mundo.addObject(d, this.getX(), this.getY());
           disparando = true;
        }
        
        //revisa cuanto disparos hay en el mundo
        World mundo = this.getWorld();
        List lista = mundo.getObjects(Disparo.class);
        if(lista.isEmpty())
        {
            disparando = false;
        }
    }
}

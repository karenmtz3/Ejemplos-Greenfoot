import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paddle  extends Actor{
    private String con1;
    private String con2;
    
    
    public Paddle(String c1, String c2){
        con1 = c1;
        con2 = c2;
    }
    
    @Override
    public void act(){
        if(Greenfoot.isKeyDown(con1))
        {
            this.setLocation(this.getX()+15, getY());       
        }
        if(Greenfoot.isKeyDown(con2))
        {
            this.setLocation(this.getX()-15, getY());
        }
            
    }    
}

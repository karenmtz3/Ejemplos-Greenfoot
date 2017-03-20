import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ball  extends Actor{
    private int incx;
    private int incy;
    private int vel;
    private int j1;
    private int j2;
    
    public Ball(){
        incx=10;
        incy=10;
        j1 = 0;
        j2 = 0;
        //veocidad con la que empieza moverse la pelota 
        vel = 40;
        Greenfoot.setSpeed(vel);
        
        //empieza a moverse la pelota de manera random
        int x = Greenfoot.getRandomNumber(10);
        int y = Greenfoot.getRandomNumber(10);
        if(x <= 5 ){
            x = 1;
        }
        else{
            x = -1;
        }
        if(y <= 5){
            y = 1;
        }
        else{
            y = -1;
        }
        incx *=x;
        incy *=y;
    }
    
    @Override
    public void act() {
        int posx = this.getX();
        int posy = this.getY();
        
        int nuevox = posx + incx;
        int nuevoy = posy + incy;
        
        World mundo = this.getWorld();

        if(nuevox > mundo.getWidth()){
            incx = -incx;  
        }
        
        if(nuevoy > mundo.getHeight()){
           j1++;
           //incy = -incy;
           nuevox = mundo.getWidth()/2;
           nuevoy = mundo.getHeight()/2;
           Greenfoot.delay(12);
        }
        
        if(nuevoy < 0){
           j2++;
           //incy = -incy;
           nuevox = mundo.getWidth()/2;
           nuevoy = mundo.getHeight()/2;
           Greenfoot.delay(12);
        }
        
        if(nuevox < 0){
            incx = -incx;
        }
        
         if(this.isTouching(Paddle.class)){
            incy = -incy;
        }
        this.setLocation(nuevox, nuevoy);
        
        //al tener 3 puntos la pelota empieza a moverse mas rapido
        if(j1 > 3 || j2 > 3)
        {
            if(vel < 60)
            {
                int r = Greenfoot.getRandomNumber(5);
                vel += r;
                Greenfoot.setSpeed(vel);
            }
        }
        
        //muestra puntuacion 
        String s = j1 + "";
        mundo.showText("Player 1", 40, 10);
        mundo.showText(s, 100, 10);
        mundo.showText("Player 2", 40, mundo.getHeight()-10);
        s = j2 + "";
        mundo.showText(s, 100, mundo.getHeight()-10);
        
        //muestra mensaje de fin de juego y de quien fue el ganador 
        if(j1 == 5 || j2 ==5)
        {
            mundo.showText("Game Over ",mundo.getWidth()/2 , mundo.getHeight()/2);
            if(j1 == 5){
                mundo.showText("Winner Player 1", mundo.getWidth()/2 , mundo.getHeight()/2+20);
            }
            else{
                mundo.showText("Winner Player 2", mundo.getWidth()/2 , mundo.getHeight()/2+20);
            }
            Greenfoot.stop();
        }
        
    }    
}

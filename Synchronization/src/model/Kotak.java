/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import viewmodel.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
/**
 *
 * @author anandita k
 */
public class Kotak extends GameObject{
     /**
     * Constructor.
     */
    private Player lingkaran;
    private Game game;
    private void posisi(){
        Random temp=new Random();
        this.x=temp.nextInt(500);
        this.y=temp.nextInt(350);

    }
    
    // Default constructor.
    public Kotak(Player lingkaran, Game game)
    {
        super(0, 0, "Kotak");
        super.setHeight(30);
        this.lingkaran=lingkaran;
        this.game = game;
        posisi();
    }
    
    // Constructor with player position.
    public Kotak(int x, int y)
    {
        super(x, y, "Kotak");
        super.setHeight(30);
    }
    
    /**
     * Override interface.
     */
    
    @Override
    public void render(Graphics object)
    {
        // Set player shape.
        object.setColor(Color.decode("#b4a7d6"));
        object.fillRect(x, y, 60, 60);
    }
    
    @Override
    public void loop()
    {
        int x1,x2,y1,y2;
        x1=this.x;
        y1=this.y;
        x2=lingkaran.getX();
        y2=lingkaran.getY();
        double jarak = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        if(jarak<45){
            posisi();
            game.setScore(game.getScore() + 10);
        } 
    }
    
}

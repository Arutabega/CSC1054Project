import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.image.*;

import java.io.*;

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;



public class Mines extends DrawableObject
{
   private float x;
   private float y;
   private boolean isPlayer;
   static double color=0;
   static int way=1;
   
   public void draw(float xPlayer, float yPlayer, GraphicsContext gc, boolean isPlayer)
   {
      if(!isPlayer)
         drawMe(-xPlayer+300+x,-yPlayer+300+y,gc);
      else
         drawMe(xPlayer,yPlayer,gc);
   }
   
   public Mines(float x2, float y2)
   {
      super(x2,y2);
   }
   
   public static void advanceColor()
   {
      color+=0.1f*way;
      
      if(color>1)
      {
         color=1;
         way=-1;
      }
      if(color<0)
      {
         color=0;
         way=1;
      }
   }
   
   public void drawMe(float x, float y, GraphicsContext gc)
   {
      gc.setFill(Color.CYAN.interpolate(Color.MAGENTA,color));
      gc.fillOval(x-6,y-6,10,10);
   }
   
   public float getX()
   {
      return x;
   }
   public float getY()
   {
      return y;
   }
   
   public void setY(float y2)
   {
      y=y2;
   }
   public void setX(float x2)
   {
      x=x2;
   }
   public double distance(DrawableObject other)
   {
      return (Math.sqrt((other.getX()-x)*(other.getX()-x) +  (other.getY()-y)*(other.getY()-y)   ));
   }
   
}
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/** Create an applet that has two buttons one to let ball star moving randomly
and one to pause this ball moving */
public class PlayAndPause extends Applet implements Runnable{
	
	Thread th;
	int x;
	int y;
	int r=25;
    int xStep=50;
	int yStep=-50;
	boolean play; 
	Button b1;
	Button b2;
	
	public void init(){
	    x=0;
	    y=300;
		th =new Thread(this);
		th.start();
		b1= new Button ("Start");
		b2= new Button ("Pasue");
		
		b1.addActionListener((ActionEvent ex)->{
			play=true;
		});
		b2.addActionListener((ActionEvent ex)->{
			play=false;
		});
	    add(b1);
		add(b2);
	}
	public void paint (Graphics g){
		 g.setColor(Color.red);
		 g.drawOval(x,y,r*2,r*2);
		 g.fillOval(x,y,r*2,r*2);
	}
	public void run(){
	    
	
		while (true){
			
			if(play)
			   {   
			      if (x+xStep <0 || x+2*r+xStep>getWidth())
				       xStep*=-1;
				  if (y+yStep<0 || y+2*r+yStep>getHeight())
				       yStep*=-1;
				  x+=xStep;
				  y+=yStep;
					this.repaint();	

                 }
					
			try{
                   th.sleep(100);  
             }
            catch(InterruptedException e)
			
			{
			e.printStackTrace();
			 }
			
			
		}
}
}
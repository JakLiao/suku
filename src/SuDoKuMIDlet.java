import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;
import java.io.*;


public class  SuDoKuMIDlet  extends MIDlet  
{
 
    private MenuList menuList;

    private SuDoKuCanvas myCanvas;
    private Alert alert = null;
    public SuDoKuMIDlet() 
    {

    	    	
    }

    
    public void startApp()
    {    
        Displayable current = Display.getDisplay(this).getCurrent();
        if (current == null)
        {
            // first time we've been called
            Display.getDisplay(this).setCurrent(new SplashScreen(this));
        }
    }
    public void menuListNewGame()
    {
        Display.getDisplay(this).setCurrent(myCanvas);
        myCanvas.startNewGame();
        myCanvas.start();

    }
    public void menuListLoadGame()
    {
    	  Display.getDisplay(this).setCurrent(myCanvas);
        myCanvas.loadGame();
        myCanvas.start();
      
    	
    }
    public void menuListInstructions()
    {

        Display.getDisplay(this).setCurrent(new InstructionsScreen(this));
    }
    public void menuListOptions()
    {

        Display.getDisplay(this).setCurrent(new OptionsScreen(this));
    }    

    public void splashScreenDone()
    {
        menuList = new MenuList(this);
        myCanvas = new SuDoKuCanvas(this);
        Display.getDisplay(this).setCurrent(menuList);
    }
    public void instructionsBack()
    {
        Display.getDisplay(this).setCurrent(menuList);
    }
    public void gameBack()
    {
        menuList.setGameActive(true);
        Display.getDisplay(this).setCurrent(menuList);
    }
    public void menuListContinue()
    {
        Display.getDisplay(this).setCurrent(myCanvas);
        myCanvas.start();
    }
    public void optionsBack(byte level,byte back,byte input,byte music)
    {
    	  myCanvas.setOptions(level,back,input,music);
        Display.getDisplay(this).setCurrent(menuList);
        
    }
    public void pauseApp()
    {

    }
    public void destroyApp(boolean unconditional)
    {

    }

    public void notifyGameOver(byte level,long  gameDuration,boolean isSolved)
    {
         String strTime;
        String s;
        long temp;
        temp = gameDuration / 1000;
        strTime = (gameDuration % 60) + " 秒" ;
        if (temp >= 60){


        temp = temp / 60;
        strTime = (temp % 60) + " 分  "  + strTime;
        if (temp >=60){


        temp = temp/ 60;
        strTime = temp + " 小时  "+ strTime;
      }
      }
      if(isSolved)s="恭喜，在"+strTime+"内您顺利完成了本题！";
      else s="未能完成本题，请继续加油！";
      if (alert == null)
        {
           alert = new Alert ("游戏结束");
           alert.setTimeout (Alert.FOREVER);
           alert.setType (AlertType.INFO);
        }
        alert.setString (s);
        Image imgGameOver;
        if(isSolved)imgGameOver = createImage("/win.png");
        else imgGameOver = createImage("/lose.png");
        alert.setImage(imgGameOver);
        menuList.setGameActive(false);
        Display.getDisplay(this).setCurrent (alert, menuList);
    }
    
    
    public void quit()
    {
        destroyApp(false);
        notifyDestroyed();
    }
    // method needed by lots of classes, shared by putting it here
    static Image createImage(String filename)
    {
        Image image = null;
        try
        {
            image = Image.createImage(filename);
        }
        catch (java.io.IOException ex)
        {
            // just let return value be null
        }
        return image;
    }

}


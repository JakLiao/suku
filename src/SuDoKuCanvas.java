import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import javax.microedition.media.*;
import java.io.*;
//Download by http://www.codefans.net

class SuDoKuCanvas  extends Canvas    implements CommandListener, Runnable
{
    public static final byte CORRECT = 1, ERROR = 2, CURSOR = 4, CARVEDINSTONE = 8; 
    private int CanvasWidth = getWidth();
    private int CanvasHeight = getHeight();
  
    private Image imgDigits;
    protected Image imgBack;
    protected Graphics gBack;
    private static final int MILLIS_PER_TICK = 50;
    protected static final String[] BackArray = {"/bg1.png", "/bg2.png", "/bg3.png", "/bg4.png", "/bg5.png", "/bg6.png"};

    private volatile Thread animationThread = null;
    private int cellWidth;
    private int puzzleWidth;
    private int xStart, yStart;
    private int digitOffset = 0, totalOffset = 0;    
    private  static final byte[] digitSize = {8, 10, 12, 16,20,24};
    private int digit;
    private SuDoKuMIDlet midlet;
    private SoundEffects sound;
    private SuDoKuModel model;
    private SuDoKuStore store;

    protected static final int[][] backColor = {
        {
            0x00B5ADD6, 0x008181FF, 0x00EFD286, 0x00D8BC68, 0x00D0CAAE,0x00FCA179
        },
        {
             0x00D0CAEE, 0x001919F0, 0x00CBAE62, 0x00C09C45, 0x00B0A48F,0x00FF5200
        }
    };
  
    private byte back = 0;
    private byte music = 1;
    public  long gameDuration = 0;
    private long startTime;
    private boolean isSolutionShowed = false;
    private final Command CMD_BACK;
    private final Command CMD_SKIP;
    private final Command CMD_SOLUTION;
    private final Command CMD_BACKGROUND;
    private final Command CMD_GUIDE;
    private final Command CMD_NOGUIDE;
    private final Command CMD_SAVE;
    private final Command CMD_SOUND;
    SuDoKuCanvas(SuDoKuMIDlet midlet)
    {
        this.midlet = midlet;
        CMD_BACK = new Command("返回菜单", 8, 2);
        CMD_SOLUTION = new Command("显示结果", 8, 2);
        CMD_SKIP = new Command("跳过本题", 8, 2);
        CMD_BACKGROUND = new Command("更改背景", 8, 2);
        CMD_SOUND = new Command("切换声音", 8, 2);
        CMD_GUIDE = new Command("有提示输入", 8, 2);
        CMD_NOGUIDE = new Command("无提示输入", 8, 2);
        CMD_SAVE = new Command("保存", 2, 1);
        addCommand(CMD_BACK); 
        addCommand(CMD_SOLUTION);        
        addCommand(CMD_SKIP);
        addCommand(CMD_BACKGROUND);
        addCommand(CMD_SOUND);
        addCommand(CMD_SAVE);       
        store = new SuDoKuStore();

        addCommand(CMD_NOGUIDE);

        
        setCommandListener(this);
        try
        {
            imgDigits = Image.createImage ("/digits.png");
        } catch (IOException ioe) { System.out.println ("Img not found for digits " ); }
        int i = digitSize.length, j;
        do
        {
            i--;
            cellWidth = digitSize[i];
            puzzleWidth = 9 * cellWidth + 1;
        } while (((puzzleWidth > CanvasWidth) || (puzzleWidth > CanvasHeight)) && (i > 0));
        digitOffset = 0;
        for (j = 0; j < i; j++)
            digitOffset += digitSize[j];
        totalOffset = 0;
        for (j = 0; j < digitSize.length; j++)
            totalOffset += digitSize[j];
        digit = digitSize[i];
        xStart = (CanvasWidth - puzzleWidth) / 2;
        yStart = Math.max (0, (CanvasHeight - puzzleWidth) / 2 - 1);
        imgBack = Image.createImage (getWidth(), getHeight());
        gBack = imgBack.getGraphics();

        sound = SoundEffects.getInstance();
        model = new SuDoKuModel (midlet, this, store); 

    }
    public synchronized void start()
    {
        animationThread = new Thread(this);
        animationThread.start();
        playMusic();
        startTime = System.currentTimeMillis() - gameDuration;
    }
    public void startNewGame(){
    	  gameDuration = 0;
        drawBackground(gBack);
        drawTable(gBack);
        model.startNewGame();
        repaint();
    }
    private void playMusic(){
    	  sound.stopMusic();
        switch(music){
          case 0:
             
             break;
          case 1:
              sound.playSpringMusic();
              break;
          case 2:
              sound.playCityMusic();
              break;
          case 3:
              sound.playFlowerMusic();
              break;
          default:break;
   
        }
    
    
    }
    public synchronized void destroy()
    {

        animationThread = null;
    }


    public void run()
    {
        Thread currentThread = Thread.currentThread();
        long timeStart;
        long timeTaken;
        try
        {

            while (currentThread == animationThread)
            {
                timeStart = System.currentTimeMillis();

                repaint();
                serviceRepaints();

                timeTaken = System.currentTimeMillis() - timeStart;
                if (timeTaken < MILLIS_PER_TICK)
                {
                    synchronized (this)
                    {
                        wait(MILLIS_PER_TICK - timeTaken);
                    }
                }
                else
                {
                    currentThread.yield();
                }
            }
        }
        catch (InterruptedException e)
        {
            // won't be thrown
        }
    }
    public void keyPressed(int keyCode)
    {
        if (isSolutionShowed)
            return;
        model.handleEvent (keyCode);

    }

    protected void keyRepeated (int keyCode)
    {
        if (!isSolutionShowed && (getGameAction(keyCode) != 0))
            model.handleEvent (keyCode);
    }


    protected void paint(Graphics g) {

        if(imgBack != null) 
        {

            g.drawImage (imgBack, 0, 0, Graphics.TOP|Graphics.LEFT);

        }

    }
    

    protected void drawBackground (Graphics g)
    {
        byte bX = 0, bY = 0;
        int imgWidth, imgHeight;
        Image image;
        if (back < 0)
        {
            g.setColor (0x00AAAAFF);
            g.fillRect (0, 0, CanvasWidth, CanvasHeight);

        } else
        {
            try
            {
                
                image = Image.createImage (BackArray[back] );
                
                imgWidth = image.getWidth();
                imgHeight = image.getHeight();
                while (bY * imgHeight <= CanvasHeight)
                {
                    bX = 0;
                    while (bX * imgWidth <= CanvasWidth)
                    {
                        g.drawImage (image, bX * imgWidth, bY * imgHeight, Graphics.TOP|Graphics.LEFT);
                        bX++;
                    };
                    bY++;
                };
            } catch (IOException ioe)
            {
                System.out.println ("Img not found:" + BackArray[back]);
                g.setColor (0x00AAAAFF);
                g.fillRect (0, 0, CanvasWidth, CanvasHeight);
            }
        }
    }
    public void showSolution()
    {
        isSolutionShowed = true;
        model.writeSolution();
    }

   public byte getBackground()
    {
        return back;
    }

    protected void drawTable (Graphics g)
    {
        int i, j;
        g.setColor (0x00000000);
        for (i = 0; i < 10; i++)
        {
            g.drawLine (xStart + i * cellWidth, yStart, xStart + i * cellWidth, yStart + puzzleWidth - 1);
            g.drawLine (xStart, yStart + i * cellWidth, xStart + puzzleWidth - 1, yStart + i * cellWidth);
        }   
 
        for (i = 0; i < 9; i++)
            for (j = 0; j < 9; j++)
            {
                g.setColor (backColor[(i / 3 + j / 3) % 2][back]);
                g.fillRect (xStart + 1 + i * cellWidth, yStart + 1 + j * cellWidth, cellWidth - 1, cellWidth - 1);
            }

     }

    protected void writeNumber (int x, int y, int n, byte nMode, boolean isRepaint)
    {

        if ((nMode & CURSOR) == 0)
        {

            gBack.setColor (backColor[(x / 3 + y / 3) % 2][back]);
            gBack.fillRect (xStart + getWriteOffset (x), yStart + getWriteOffset (y), getWriteWidth (x), getWriteWidth (y));

        }
        else
        {

            gBack.setColor (0x00FFFFFF);
            gBack.fillRect (xStart + getWriteOffset (x), yStart + getWriteOffset (y), getWriteWidth (x), getWriteWidth (y));

        }
        if (n > 0)
        {
            gBack.setClip (xStart + getWriteOffset (x), yStart + getWriteOffset (y), getWriteWidth (x), getWriteWidth (y));
            if ((nMode & CARVEDINSTONE) > 0)
                gBack.drawImage (imgDigits, xStart + x * cellWidth + 1 - (n - 1) * cellWidth - 1, yStart + y * cellWidth + 1 - digitOffset - 1, Graphics.TOP|Graphics.LEFT);
            else
                gBack.drawImage (imgDigits, xStart + x * cellWidth + 1 - (n - 1) * cellWidth - 1, yStart + y * cellWidth + 1 - digitOffset - totalOffset - 1, Graphics.TOP|Graphics.LEFT);
            gBack.setClip (0, 0, CanvasWidth, CanvasHeight);
        }
        if (isRepaint)
        {
            repaint (xStart + getWriteOffset (x), yStart + getWriteOffset (y), getWriteWidth (x), getWriteWidth (y));
            serviceRepaints();
        }
    }

    protected void writeNumber (int x, int y, int n, byte nMode)
    {
        writeNumber (x, y, n, nMode, true);
    }

    protected int getWriteOffset (int n)
    {

            return n * cellWidth + 1;
    }
    protected int getWriteWidth (int n)
    {

            return cellWidth - 1;
    }
    public void loadGame(){
          drawBackground(gBack);
          drawTable(gBack);
        	model.loadGame();
        	isSolutionShowed = false;
        	repaint();
    }

   public void setOptions (byte level,byte back,byte input,byte music)
    {
    	  model.setInputMode(input);

        if (back < BackArray.length)
            this.back = back;
        if(model.level!=level){
        	model.setLevel(level);
        	startNewGame();
        	}
        this.music = music;

    }   

    public synchronized void stop()
    {
        gameDuration = System.currentTimeMillis() - startTime;
        animationThread = null;
    }
    public void commandAction(Command c, Displayable d)
    {

    	  if (c == CMD_BACK)
        {
           stop();
           midlet.gameBack();

        }else if (c == CMD_SKIP)
        {
        	gameDuration = 0;
        	startTime = System.currentTimeMillis() - gameDuration;
        	drawBackground(gBack);
          drawTable(gBack);
        	model.startNewGame();
        	isSolutionShowed = false;
       // 	repaint();
        }else if (c == CMD_SOLUTION)
        {
        	showSolution();
        	isSolutionShowed = true;
        }else if (c == CMD_BACKGROUND)
        {
        	back++;
        	if(back==BackArray.length)back=0;
        	drawBackground(gBack);
          drawTable(gBack);
          model.writeAllNumbers();
          repaint();        	
        }else if (c == CMD_GUIDE)
        {
        	 model.setInputMode(SuDoKuModel.GUIDE);
        	 removeCommand(CMD_GUIDE);
        	 addCommand(CMD_NOGUIDE);
        	
        }else if (c == CMD_NOGUIDE)
        {
        	 model.setInputMode(SuDoKuModel.NOGUIDE);
        	 removeCommand(CMD_NOGUIDE);
        	 addCommand(CMD_GUIDE);
        	
        }else if (c == CMD_SAVE)
        {
        	model.saveGame();

        	
        }else if (c == CMD_SOUND)
        {
        	music++;
        	if(music==5)music=0;
        	playMusic();

        	
        }
    }
}

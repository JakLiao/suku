import javax.microedition.lcdui.*;
class SplashScreen    extends Canvas    implements Runnable
{
    private final SuDoKuMIDlet midlet;
    private Image imgSplash;
    private volatile boolean isDismissed = false;
    SplashScreen( SuDoKuMIDlet midlet)
    {
        this.midlet = midlet;

        imgSplash =  midlet.createImage("/splash.png");
        new Thread(this).start();
    }
    public void run()
    {
        synchronized(this)
        {
            try
            {
                wait(3000L);   
            }
            catch (InterruptedException e)
            {
                
            }
            dismiss();
        }
    }
    public void paint(Graphics g)
    {
        int CanvasWidth = getWidth();
        int CanvasHeight = getHeight();
   
        if (imgSplash != null)
        {
            g.drawImage(imgSplash,
                        CanvasWidth/2,
                        CanvasHeight/2,
                        Graphics.VCENTER | Graphics.HCENTER);
            imgSplash = null;
            
            
        }

    }

    public synchronized void keyPressed(int keyCode)
    {
        dismiss();
    }


    private void dismiss()
    {
        if (!isDismissed)
        {
            isDismissed = true;
            midlet.splashScreenDone();
        }
    }
}

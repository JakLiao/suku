import javax.microedition.media.*;
//Download by http://www.codefans.net
import java.io.*;
class SoundEffects
{
    private static SoundEffects instance;

    private Player cityPlayer;
    private Player springPlayer;
    private Player flowerPlayer;
    private SoundEffects()
    {
       
        
    }
    static SoundEffects getInstance()
    {
        if (instance == null)
        {
            instance = new SoundEffects();
        }
        return instance;
    }

    public void playCityMusic()
    {
    	  springPlayer = null;
    	  flowerPlayer = null;

    	  cityPlayer = createPlayer("/city.mid", "audio/midi");
        startPlayer(cityPlayer);
    }

    public void playSpringMusic()
    {
    	  cityPlayer = null;
    	  flowerPlayer = null;

    	  springPlayer = createPlayer("/spring.mid", "audio/midi");
        startPlayer(springPlayer);
    }   

    public void playFlowerMusic()
    {
    	  cityPlayer = null;
    	  springPlayer = null;

    	  flowerPlayer = createPlayer("/flower.mid", "audio/midi");
        startPlayer(flowerPlayer);
    }


    public void stopMusic()
    {
    	try{
    	  if(cityPlayer!= null)cityPlayer.stop();
    	  if(springPlayer!= null)springPlayer.stop();
    	  if(flowerPlayer!= null)flowerPlayer.stop();
    	  cityPlayer = null;
    	  springPlayer = null;
    	  flowerPlayer = null;
    	}catch(IllegalStateException ise){}
    	catch(MediaException me){}
    }
    

    private void startPlayer(Player p)
    {
        if (p != null)
        {
            try
            {
                p.stop();
                p.setMediaTime(0L);
                p.setLoopCount(-1);
                p.start();
            }
            catch (MediaException me)
            {
                // ignore
            }
        }
    }


    private Player createPlayer(String filename, String format)
    {
        Player p = null;
        try
        {
            InputStream is = getClass().getResourceAsStream(filename);
          
            p = Manager.createPlayer(is, format);
            p.prefetch();
        }
        catch (IOException ioe)
        {
            // ignore
        }
        catch (MediaException me)
        {
            // ignore
        }
        return p;
    }
}

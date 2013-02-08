import javax.microedition.lcdui.*;
//Download by http://www.codefans.net
class MenuList    extends List    implements CommandListener
{
    private  SuDoKuMIDlet midlet;
 
    private boolean gameActive = false;


    MenuList(SuDoKuMIDlet midlet)
    {
        super("数独", List.IMPLICIT);
        this.midlet = midlet;

        append("开始新游戏", null);
        append("加载游戏", null);
        append("参数设置", null);
        append("游戏说明", null);
        append("退出游戏", null);
        
        setCommandListener(this);
    }


    void setGameActive(boolean active)
    {
        if (active && !gameActive)
        {
            gameActive = true;
            insert(0, "继续游戏", null);
        }
        else if (!active && gameActive)
        {
            gameActive = false;
            delete(0);
        }
    }


    public void commandAction(Command c, Displayable d)
    {
        if (c == List.SELECT_COMMAND)
        {
            int index = getSelectedIndex();
            if (index != -1)  // should never be -1
            {
                if (!gameActive)
                {
                    index++;
                }
                switch (index)
                {
                case 0: 
                    midlet.menuListContinue();
                    break;
                case 1: 
                    midlet.menuListNewGame();
                    break;
                case 2:  
                    midlet.menuListLoadGame();
                    break;
                case 3: 
                    midlet.menuListOptions();
                    break;
                case 4:
                    midlet.menuListInstructions();
                    break;
                case 5:
                    midlet.quit();
                    break;
                default:

                    break;
                }
            }
        }

    }
}

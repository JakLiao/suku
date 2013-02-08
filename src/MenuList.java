import javax.microedition.lcdui.*;
//Download by http://www.codefans.net
class MenuList    extends List    implements CommandListener
{
    private  SuDoKuMIDlet midlet;
 
    private boolean gameActive = false;


    MenuList(SuDoKuMIDlet midlet)
    {
        super("����", List.IMPLICIT);
        this.midlet = midlet;

        append("��ʼ����Ϸ", null);
        append("������Ϸ", null);
        append("��������", null);
        append("��Ϸ˵��", null);
        append("�˳���Ϸ", null);
        
        setCommandListener(this);
    }


    void setGameActive(boolean active)
    {
        if (active && !gameActive)
        {
            gameActive = true;
            insert(0, "������Ϸ", null);
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

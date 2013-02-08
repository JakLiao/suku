import javax.microedition.lcdui.*;
//Download by http://www.codefans.net

class OptionsScreen    extends Form    implements CommandListener
{
    private final SuDoKuMIDlet midlet;
    private final Command CMD_OK;
    private ChoiceGroup choicelevel;
    private ChoiceGroup choiceBackground;
    private ChoiceGroup choiceInputMode;    
    private ChoiceGroup choiceMusic; 
    private byte level;
    private byte back;
    private byte input; 
    private byte music;     
    OptionsScreen(SuDoKuMIDlet midlet)
    {
        super("��Ϸ�����趨");
        this.midlet = midlet;
        choicelevel = new ChoiceGroup("ѡ����Ϸ�Ѷ�:", 1);
        choicelevel.append("��", null);
        choicelevel.append("��", null);
        append(choicelevel);
        choiceBackground = new ChoiceGroup("ѡ�񱳾����:", 1);
        choiceBackground.append("ˮ��", null);
        choiceBackground.append("����", null);    
        choiceBackground.append("ɳĮ", null);
        choiceBackground.append("ľ��", null);
        choiceBackground.append("ʯ��", null);  
        append(choiceBackground);
        choiceInputMode = new ChoiceGroup("ѡ�����뷽ʽ:", 1);
        choiceInputMode.append("����ʾ", null);
        choiceInputMode.append("����ʾ", null);    
        append(choiceInputMode);
        choiceMusic = new ChoiceGroup("ѡ�񱳾�����:", 1);
        choiceMusic.append("����", null);
        choiceMusic.append("��������ҹ", null);    
        choiceMusic.append("������¹�", null);
        choiceMusic.append("�ջ�̨", null);
        append(choiceMusic); 
        CMD_OK = new Command("ȷ��", 4, 2);
        addCommand(CMD_OK);
        setCommandListener(this);
    }
    

    public void commandAction(Command c, Displayable d)
    {
    	  if (c == CMD_OK)
        {
            level = (byte)choicelevel.getSelectedIndex();
            back = (byte)choiceBackground.getSelectedIndex();
            input = (byte)(choiceInputMode.getSelectedIndex()+1);
            music = (byte)choiceMusic.getSelectedIndex();
            midlet.optionsBack(level,back,input,music);
        }
        
    }
}

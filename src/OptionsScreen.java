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
        super("游戏参数设定");
        this.midlet = midlet;
        choicelevel = new ChoiceGroup("选择游戏难度:", 1);
        choicelevel.append("难", null);
        choicelevel.append("易", null);
        append(choicelevel);
        choiceBackground = new ChoiceGroup("选择背景风格:", 1);
        choiceBackground.append("水珠", null);
        choiceBackground.append("花纹", null);    
        choiceBackground.append("沙漠", null);
        choiceBackground.append("木纹", null);
        choiceBackground.append("石砾", null);  
        append(choiceBackground);
        choiceInputMode = new ChoiceGroup("选择输入方式:", 1);
        choiceInputMode.append("带提示", null);
        choiceInputMode.append("无提示", null);    
        append(choiceInputMode);
        choiceMusic = new ChoiceGroup("选择背景音乐:", 1);
        choiceMusic.append("静音", null);
        choiceMusic.append("春江花月夜", null);    
        choiceMusic.append("城里的月光", null);
        choiceMusic.append("菊花台", null);
        append(choiceMusic); 
        CMD_OK = new Command("确定", 4, 2);
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

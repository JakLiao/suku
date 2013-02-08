import javax.microedition.lcdui.*;
//Download by http://www.codefans.net
class InstructionsScreen    extends Form    implements CommandListener
{
    private final SuDoKuMIDlet midlet;
    private final Command CMD_BACK;

    private static final String instructions =
      "“数独”的玩法很简单，就是在9x9的小格子里面填上合适的数字，"+
      "使得每一行，每一列以及每个厢格(就是3x3部分的小格)"+
      "都要包含从一到九的数字，不能重复。"+
      "方格事先会被填上一些数字作为提示，而给出数字的多少，"+
      "决定了“数独”的难易程度。游戏提供多种背景风格和声音效果"+
      "供玩家选择。难度分为两个等级，此外游戏提供了简单的提示"+
      "功能，例如根据其他方格的内容推断出某个方格的只有3种可能"+
      "玩家便无法输入其他的数字，如果玩家想要挑战自己，也可以选择"+
      "不带提示的输入方法" ;
      
    InstructionsScreen(SuDoKuMIDlet midlet)
    {
        super("游戏说明");
        this.midlet = midlet;

        append(new StringItem(null, instructions));

        CMD_BACK = new Command("返回", Command.BACK, 1);
        addCommand(CMD_BACK);
        setCommandListener(this);
    }
    

    public void commandAction(Command c, Displayable d)
    {
        midlet.instructionsBack();
    }
}

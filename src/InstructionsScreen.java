import javax.microedition.lcdui.*;
//Download by http://www.codefans.net
class InstructionsScreen    extends Form    implements CommandListener
{
    private final SuDoKuMIDlet midlet;
    private final Command CMD_BACK;

    private static final String instructions =
      "�����������淨�ܼ򵥣�������9x9��С�����������Ϻ��ʵ����֣�"+
      "ʹ��ÿһ�У�ÿһ���Լ�ÿ�����(����3x3���ֵ�С��)"+
      "��Ҫ������һ���ŵ����֣������ظ���"+
      "�������Ȼᱻ����һЩ������Ϊ��ʾ�����������ֵĶ��٣�"+
      "�����ˡ������������׳̶ȡ���Ϸ�ṩ���ֱ�����������Ч��"+
      "�����ѡ���Ѷȷ�Ϊ�����ȼ���������Ϸ�ṩ�˼򵥵���ʾ"+
      "���ܣ����������������������ƶϳ�ĳ�������ֻ��3�ֿ���"+
      "��ұ��޷��������������֣���������Ҫ��ս�Լ���Ҳ����ѡ��"+
      "������ʾ�����뷽��" ;
      
    InstructionsScreen(SuDoKuMIDlet midlet)
    {
        super("��Ϸ˵��");
        this.midlet = midlet;

        append(new StringItem(null, instructions));

        CMD_BACK = new Command("����", Command.BACK, 1);
        addCommand(CMD_BACK);
        setCommandListener(this);
    }
    

    public void commandAction(Command c, Displayable d)
    {
        midlet.instructionsBack();
    }
}

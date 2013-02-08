import java.util.Random;

//Download by http://www.codefans.net
public class SuDoKuModel {
  protected static final byte DIFFICULT = 1, EASY = 0;
  protected static final byte GUIDE = 1, NOGUIDE = 2;
  protected static final byte NUM = 40;
  protected static final String[][] strPuzzles = {
      {
  
      ";9<=>?@87684179523=A5B26;4C5<79;48=6B;65329A>9>37@82?1<6C45A3;B45168379273B<C;>6?",
      ";<=7956486978>31<?485@<;97=9@>=7<5818?<914A=6731?6B<C4<46;BC357?A82=6419319457B@<",
      ";98<=67>5?72>813@9>36?9A1B221C8>3?768?=762C;464A9;5<383<1@5>89A9@517B42=7B43<C65;",
      ";64<85=79<78>39?16?93@A1<489B63?>1<74?;827C@37=2;C64B561?9>B73<82C71=65>34A56<89;",
      "485967;<=912>38?7@=A@?12894@?;7B49327<43C16?88936<5A>;13725@>BC?6C84=217<>B179365",
      "9;846<=75>?397;@282A6B3?>91B976;354<=>52871@C@215>983A73<;5@9B418C=247?@56>A982;3",
      ";68<79=>5=79?142@8>2?6389A179>;<5B36B1<463?9A53@8CA;246B1942A5=2?378@41C9>A35;68<",
      ";68<79=>5=79?142@8>2?6389A179>;<5B36B1<463?9A53@8CA;246B1942A5=2?378@41C9>A35;68<",
      "57;<689=4<83>9?@71>9631AB258?47=12C63<A6>9;?81@95B27>394B;2356A61?C7>38<7=285@>19",
      "485967;<=912>38?7@=A@?12894@?;7B49327<43C16?88936<5A>;13725@>BC?6C84=217<>B179365",
      "56;78<94=82>=9?17@93A46;25B@B51A93<44;35<86C77C26>38;?<46B17?39=79<5@>81;58C34A62",
      ";<8=>?@A9734961852?96B2A13>8@57=94<13A94;25B62>16?83C7C13<8@74?4521739686BA?C>2;=",
      ";96<478=5>28;?39@7A3?B691<464<5=8A918A=912?>651C4A6<833B762?>1C9?43B;67<2@179>35B",
      "6;<897=>5?3814<@A9A9453@1B285@4;3<9712C6A5B3447=2B9?162B1C6475=9@A=5842;3>?721C@8",
      ";<=>?879@ABC613542456279138B1>5=@<799=?782>@126A;C4B5=391845627572961=B>@483<AC;?",
      "87;<6=59>23?4897;@96>?1A32B5B31<46A94;97?68=26<73C81>5=98@4;<57A?6932>81;42B7?C63",
      "87;436<59=>9?2;87@2@5A9B14=C5=1A246861B3>5C277248@9?3;;92@5A3B4>86<1=7C?53A984@12",
      ";<=>?@A9B>85C27631769813254?>67=C18<B3156247CC72;>85@=65439182731827?94@<9A@B>=;?",
      "698;<54=7>21=79?@8=A5B642C153<6>1A8974@9=8;2581C7?2=469B741=6?<1?=28@97>2@45CA813",

      "785;96<=><;9?34867@>3A2815917B9@5>2=45@3B2A91C3<4;7?8689427=6;?52164C3AB=@A85;942",
      ";<8=>?9@A=6A928415594167238B>15A2@9=<356;987>@7C8=41?<912783546786451=2C>?3<C@7B;",
      "65;<874=9=89>?1@72A42@93B159@7?;23>8><53681CA8;39A>2?619>82?76=53B7>@92;2A613C?84",
      ";987<=>56?@7948<31324@5;A89BA<3;9564C315@487<6452B7;C=75=>9<61848C1763<?21@B=594A",
      "9;678<4=528>?=19@753A@942B1=61<>785CBA23596;>>598;@37<7C312B?466>59A=;281<8>657C3",
      "8;7<9645=2>9?3817@6?3A14B9<17?C>3@2846B1<7C3593<8@?A14?2@47C3B1A8435;2@9=9168<5>7",
      ";<6=789>59?3214@A84ABC56;23=42;B956A@9172583>?876>=21C21C83A>?67@>5913B28=546<7C;",
      "6;<75=89>8?912>73@4A39@B15<13B<A9>6572@435C1859>8;@=27=85@C72>1<67=415B9C41?82@A3",
      "5;8<=>769764198?=<932?@A4B185;C4@327<7=815C4@496A2=;581>9@?<873@B?379214327>B;6C5",
      ";79<58=>6?48=7@921<63914AB54876=9;?<6C15B24=7=<?7>16989;>86527=832;9A56>7?@42=81C",
      "768945;<=<>?318967913@<AB45B?A2=6419;26>7C35B4398?1@A<57>;B=296681792?=>=C<564781",
      ";4<5=9876789>16=?<=@5A8294161=2?7>98?9>8@1A2=27B3C4@1585197=2@>C<@14B5374376<5;8C",
      "768945;<=3>?@218971<9A=B465<9;8?>376B3A216C5>654=A9<1B472?C=6B158316<A>9C;@487532",
      "9;<=>6?78@A5821943843579612=?B6;7<C><674C385;>C;2B5=@A1397624855861347<C72>9?B;=6",
      "75;<984=689=>?67<142@A315B9C18@<435A<6?387;9>=745;C26B1=796<B456B21>?C735>987=@12",
      "968;<=7542>;?87@933?A649<B1B793@241?;359A486<>268;537C6C<731?>858>29@;=7713>?B926",
      "59;<647=838>?971@262AB;35C4B691A<34?>7?638C2;<13C>568A9>23?;B761=872@>597?648C<13",
      ";<=>89?7@756;23498948A@?132BCA5>26136;29=78>54358;6C<A371@CB25426935>781?8>27;=@C",
      "9;<=>?@A8?A8269431643871295A31><B9?6>B96537;<2@5;CA38>1547328698279165>=3C@?B>;<7",
      "8;795<=6>9?4@38<176<3>1AB59=951<478@>813A692?A628C543;53C<4;6A814B76=5C2<7@?891>3",
      "7;6<58=>9298=14?@A>?=976128;4A5@9283B6<137C5>5398>2@7;675491B=<C<>68=7153B;72?4C6",
      ";<5986=74897>13?@<=6><5A1894B37@92;59A15=26>82?68>17C3618=9?>2A?><17B93673C6248?;"
  }
      , {
      "68;74<95=27=51986>49?8@321A9>7;8@3253<69547B1158=2A4C6?346C8;72A69231?48B12>75@39",
      "7859;46<=26>73891?193@<548A5A9B423@13;85697>24<617=5C8@512CA834C47381<56B=24?6179",
      "7;69<5348=28>76?91954813@<A<93@4B175B4715296=561A3C28>>AC36185218?29>73@6325B74;9",
      ";7845<=6939<8617>?54@A392187=42B5691<@91438?A8516C74<361397>?82CB5326;7442A?1893@",
      ";<8549=676>?378912739<@;4859@A;345285B27961>331482?AC6251CBA634876413<?949=6528A;",
      "7;653894<=289>17?6>95@A238114<B97@3563A125>9885C46=;275742;C86=9B37?621><613845A9",
      "7;5<89=6><9364?87184@3A1592629>5B713?=47169<B187C2=6454528@7;39361?9428AC7B13<4?6",
      ";<687=>59587491623=94?2@A18>617B539<C326;487?A582=914@81=C4<56A67915823424?=679B;",
      ";<=>95687687132945?49@AB3129@52;4873>A13895<@2387?64C1754C<=16B81654723939286;A?>",
      "597;<=8642>38769?1@185942A345;6B7=2976<3>9;8583C2?1@471A643859<9B57124=6324C@?718",
      ";97<8=65>8?@741239234695718>693A2;B558=1@4C277;<9?834@628537491941826?A3=75>1C86<",
      ";4657923889<=61>57=?7842@19@A19?38249=81<45A64257B63C;76C4351B<58>21AC6321369874?",
      ";<698754=75>;32689398?>@7125@14<93A82B73651C44=97;82?6642BA;93581569=>27C732548@;",
      ";6<7594=8379>1862?854@329A1<1@9A458398?3<6;474375B1<6C5>829=716A2186?3946C3147B5<",
      "867;5<=>9<4?@39871931874256@923>871?A5426193B=185C746<17392658452648=;9A4BCA1?623",
      "367498;52<;975=86>8?412@39A98=6A524114<3B9?766752;4C38>38C617<5A91?426B=52@837419",
      "7;<86495=965=7182>348?9217@4?A9<86312=96;54B71867>3?C2B2143C765@9315A248?74286=;9",
      ";87<=659>249758631?3@;9482A6A59>12B34<85637;93C18A24@5B5461C=7<963427158A123B?94@",
      "7;8523964<=916>78?4@598A13269>3;2B5718A4?6=2935<7C8@41576<394;8B41@752C=9238415A6",
      ";5<9=764873968>?128@4521A39<91B6=457>8675239;573;4C82@91?3762B434A<981656284;5C7=",

      ";<=>?9768@A5382419894167253>569<B=7178C531@4223;A>698?9182745363678951<>5426;=BCA",
      "49837;<56267895=;>3?1@42798A8>5=9162?127B643C6392;4B7?14592A6B3C<=16854787@>53921",
      "86749;35<1<5873946=9>?2@1A8@317B542CA4913268?<586>971=4B6=5A<9;9732185@4?12C64837",
      "74;8693<528=>5;6979?@A32148B396<7514?173C428@4625;897=17528@>=9328C4?A616C4173B52",
      "9;<=8>?@7A6B592134453716289<849A16?31C52637>86=74?892;529837416876145=9<3>;@2CBA5",
      "69;78<53478=>1?@29254639AB1>358C6217B762>139?1295A384@3@<95417854A;2BC63918=67>52",
      "3749;65<828957=>61?@184<397A;36?8942BC61247=?4253C78;@657>312BC14<A896539=82@5174",
      "547986;<=381>2?9679<@713548A3B5C4612;642=785C2958@1=7>612349AB5873;5<496>?C678231",
      "893245;7667<918=>?415=@A8292=;69>5875B61724C3749?83<@1367B<;954C?B436A1212>759638",
      ";7859<=>6692437851?43@18A298<63>95;77;52B64C39=47?12@825A96=18>3618249754BC;7563<",
      "4967;58<3=8729>1?6?1238@4A995;8<3@4727B649?3163>5A1C827>5;6239B8@3C5721>1<94=8765",
      ";9<=>?876@A4281539853796214>298;3@5736B5A4C2171?6<948=5374621989861573><241C=BA6?",
      "8564937;<=7>182?96192@?A8437B3C142@59<15764=86>523B1A9439B<;65721A365C8>?@8749321",
      "9;876<54=362594871>7?=1829@2=41A96?81?76B39<48C62>53;7A2983;>6?581426739@43C571B2",
      ";984<6=577>2?83;965@3A91B42=569;2478<7184563C9843@721?63?17B9<481C25>7@342A6=958;",
      ";<=87>569647591283?89@32A143A14B69?22C57;36>84@89<51=781>25C37@752368491936;47B<?",
      "59;243768<6=978>5;847?;@392>857<961=@1935482AA326B154C126>=A985C7B165<3>354892;76",
      "87649;53<=297851>6?14=2@78993<6A8>1516B2?4C7345A1=9@28795B4<36;2>196385A@83?17294",
      "689;57<4327=489615>?1@23A9B3@82C14?79;58743@27<45=61B9B9@71<5=>542368C7113A94?826",
      ";9568<74=72>13968?83@A542196B93;75<42?38>69A14A12C53@851297B>36C68423;57=47?6189<"
  }
  };

  protected byte level=0, input=1;
  protected SuDoKuLogic logic;
  protected SuDoKuCanvas canvas;

  protected SuDoKuStore store;
  protected SuDoKuMIDlet midlet;

  protected Random rand;

  protected byte xCursor, yCursor;

  public SuDoKuModel(SuDoKuMIDlet midlet, SuDoKuCanvas canvas, SuDoKuStore store) {


    this.canvas = canvas;
    this.midlet = midlet;
   
    this.store = store;
    rand = new Random(System.currentTimeMillis());
  
  }

  public void startNewGame() {


    logic = SuDoKuLogic.getPuzzle(shuffle(strPuzzles[level][Math.abs(rand.nextInt()) % NUM]));

    xCursor = 4;
    yCursor = 4;


    writeAllNumbers();
    canvas.writeNumber(xCursor, yCursor,
                       logic.getValue(yCursor, xCursor),
                       (byte) (SuDoKuCanvas.CURSOR |
                               (logic.
                                isCarved(yCursor, xCursor) ?
                                SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT)));

  }

  public byte getlevel() {
    return level;
  }

  public byte getInputMode() {
    return input;
  }

  public void setInputMode(byte input) {
    if ( (input >= 1) && (input <= NOGUIDE))
      this.input = input;
  }

  public void setLevel(byte level) {
    if (level==DIFFICULT||level==EASY)
      this.level = level;
  }

  public void writeAllNumbers() {
    byte i, j;
 
    for (i = 0; i < 9; i++)
      for (j = 0; j < 9; j++)
        if (logic.getValue(i, j) > 0)
          canvas.writeNumber(j, i, logic.getValue(i, j),
                             (logic.isCarved(i, j) ?
                              SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT), false);
    canvas.writeNumber(xCursor, yCursor,
                       logic.getValue(yCursor, xCursor),
                       (byte) (SuDoKuCanvas.CURSOR |
                               (logic.
                                isCarved(yCursor, xCursor) ?
                                SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT)), false);
  }

  public void writeSolution() {
    byte i, j, val;

    for (i = 0; i < 9; i++)
      for (j = 0; j < 9; j++) {
        val = logic.getSolutionValue(i, j);
        canvas.writeNumber(j, i, val,
                           (logic.isCarved(i, j) ?
                            SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT), false);
      }
    canvas.repaint();
  }



  private byte findNextValue(byte x, byte y) {
    byte flag[] = {
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    byte i, j;

    for (i = 0; i < 9; i++) {
      byte v = logic.getValue(i, y);
      if (v != 0)
        flag[v] = 0;
      v = logic.getValue(x, i);
      if (v != 0)
        flag[v] = 0;
    }

    i = (byte) (x - (x % 3));
    j = (byte) (y - (y % 3));
    for (byte k1 = 0; k1 < 3; k1++) {
      for (byte k2 = 0; k2 < 3; k2++) {
        byte v = logic.getValue( (byte) (i + k1), (byte) (j + k2));
        if (v != 0)
          flag[v] = 0;
      }
    }

    byte oldVal = logic.getValue(x, y);
    byte newVal = (byte) ( (oldVal + 1) % 10);
    while (flag[newVal] == 0) {
      newVal = (byte) ( (newVal + 1) % 10);
    }
    return newVal;
  }

  public void handleEvent(int keyCode) {
    int g = canvas.getGameAction(keyCode);

    if ( (input == NOGUIDE) && (keyCode <= canvas.KEY_NUM9) &&
        (keyCode >= canvas.KEY_NUM0)) {
      if (!logic.isCarved(yCursor, xCursor)) {
        logic.setValueWithoutChecks(yCursor, xCursor,
                                              (byte) (keyCode -SuDoKuCanvas.KEY_NUM0));
        canvas.writeNumber(xCursor, yCursor, (byte) (keyCode - SuDoKuCanvas.KEY_NUM0),
                           (byte) (SuDoKuCanvas.CURSOR | SuDoKuCanvas.CORRECT));

      }
      return;
    }

    if ( g != 0 ) {
      if (g == SuDoKuCanvas.LEFT) {

        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (logic.isCarved(yCursor, xCursor) ?
                            SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT));

        xCursor = (byte) ( (xCursor + 8) % 9);
        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (byte) (SuDoKuCanvas.CURSOR |
                                   (logic.
                                    isCarved(yCursor, xCursor) ?
                                    SuDoKuCanvas.CARVEDINSTONE :
                                    SuDoKuCanvas.CORRECT)));

      }
      else if (g == SuDoKuCanvas.RIGHT) {

        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (logic.isCarved(yCursor, xCursor) ?
                            SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT));

        xCursor = (byte) ( (xCursor + 1) % 9);
        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (byte) (SuDoKuCanvas.CURSOR |
                                   (logic.
                                    isCarved(yCursor, xCursor) ?
                                    SuDoKuCanvas.CARVEDINSTONE :
                                    SuDoKuCanvas.CORRECT)));
      }
      else if (g == SuDoKuCanvas.UP) {

        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (logic.isCarved(yCursor, xCursor) ?
                            SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT));

        yCursor = (byte) ( (yCursor + 8) % 9);
        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (byte) (SuDoKuCanvas.CURSOR |
                                   (logic.
                                    isCarved(yCursor, xCursor) ?
                                    SuDoKuCanvas.CARVEDINSTONE :
                                    SuDoKuCanvas.CORRECT)));

      }
      else if (g == SuDoKuCanvas.DOWN) {

        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (logic.isCarved(yCursor, xCursor) ?
                            SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT));

        yCursor = (byte) ( (yCursor + 1) % 9);
        canvas.writeNumber(xCursor, yCursor,
                           logic.getValue(yCursor, xCursor),
                           (byte) (SuDoKuCanvas.CURSOR |
                                   (logic.
                                    isCarved(yCursor, xCursor) ?
                                    SuDoKuCanvas.CARVEDINSTONE :
                                    SuDoKuCanvas.CORRECT)));

      }
      else if (g == SuDoKuCanvas.FIRE) {
        if (!logic.isCarved(yCursor, xCursor) &&
            (input != NOGUIDE)) {
     
          logic.setValueWithoutChecks(yCursor, xCursor,
                                                findNextValue(yCursor, xCursor));
          canvas.writeNumber(xCursor, yCursor,
                             (byte) logic.getValue(yCursor, xCursor),
                             (byte) (SuDoKuCanvas.CURSOR | SuDoKuCanvas.CORRECT));

        }
      }
    }


    if (logic.isSolved()) midlet.notifyGameOver(level, canvas.gameDuration,true);
    else if(logic.writtenCnt==81)midlet.notifyGameOver(level, canvas.gameDuration,false);
  }

  public void loadGame(){
    level = store.getCurrentLevel();//µÈ¼¶
   
    String strPuzzle = store.getCurrentPuzzleAsString();
    String strSolution = store.getCurrentSolutionAsString();
 
    input = store.getInput();
    canvas.gameDuration = store.getTime();
    if(strPuzzle==null||strSolution==null)logic = SuDoKuLogic.getPuzzle(shuffle(strPuzzles[level][Math.abs(rand.nextInt()) % NUM]));
    else  logic = SuDoKuLogic.getPuzzle(strSolution, strPuzzle);
    xCursor = 4;
    yCursor = 4;

    writeAllNumbers();
    canvas.writeNumber(xCursor, yCursor,
                       logic.getValue(yCursor, xCursor),
                       (byte) (SuDoKuCanvas.CURSOR |
                               (logic.
                                isCarved(yCursor, xCursor) ?
                                SuDoKuCanvas.CARVEDINSTONE : SuDoKuCanvas.CORRECT)));
    
  }

  public void saveGame() {
    store.save(level, 
                 logic.getPuzzleAsString(),
                 logic.getSolutionAsString(), canvas.getBackground(),
                 canvas.gameDuration, input);
  }

  protected String shuffle(String s) {
    String sReturn = s;
    byte[] ba;
    byte b, t, i, j;

    for (b = 0; b < 3; b++) {
      ba = getShuffledArray( (byte) 3);
      sReturn = swapCols(s, ba, b);
      ba = getShuffledArray( (byte) 3);
      sReturn = swapRows(s, ba, b);
    }

    ba = getShuffledArray( (byte) 9);
    sReturn = swapNumbers(sReturn, ba);

    return sReturn;
  }

  protected String swapCols(String s, byte[] ba, byte b) {
    char[] caReturn = s.toCharArray();
    ;
    byte i, j;

    for (j = 0; j < ba.length; j++)
      if (j != ba[j])
        for (i = 0; i < 9; i++)
          caReturn[9 * i + 3 * b + j] = s.charAt(9 * i + 3 * b + ba[j]);

    return new String(caReturn);
  }

  protected String swapRows(String s, byte[] ba, byte b) {
    char[] caReturn = s.toCharArray();
    ;
    byte i, j;

    for (i = 0; i < ba.length; i++)
      if (i != ba[i])
        for (j = 0; j < 9; j++)
          caReturn[9 * (3 * b + i) + j] = s.charAt(9 * (3 * b + ba[i]) + j);

    return new String(caReturn);
  }

  protected String swapNumbers(String sOrig, byte[] ba) {
    StringBuffer sbReturn = new StringBuffer(sOrig.length());
    byte yNum, yCiS;

    for (byte i = 0; i < sOrig.length(); i++) {
      yNum = (byte) (sOrig.charAt(i) - '0');
      yCiS = (byte) (yNum / 10);
      yNum = (byte) (yNum % 10);
      sbReturn.append( (char) ('0' + ba[yNum - 1] + 1 + 10 * yCiS));
    }


    return sbReturn.toString();
  }

  protected byte[] getShuffledArray(byte n) {
    byte[] baReturn = new byte[n];
    byte b, t, i, j;

    for (b = 0; b < n; b++)
      baReturn[b] = b;

    for (b = 0; b < 2 * n; b++) {
      i = (byte) (Math.abs(rand.nextInt()) % n);
      j = (byte) (Math.abs(rand.nextInt()) % n);
      t = baReturn[i];
      baReturn[i] = baReturn[j];
      baReturn[j] = t;
    }

    return baReturn;
  }
}

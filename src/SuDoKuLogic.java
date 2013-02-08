//Download by http://www.codefans.net


public class SuDoKuLogic {

    protected byte[][] board, solution;
    protected boolean[][] isCarved;
    protected byte writtenCnt = 0;
    protected String strSolution;
    

    protected SuDoKuLogic (String s) {
        int i, j;
        strSolution = s;
        board = new byte[9][9];// 
        solution = new byte[9][9];
        isCarved = new boolean[9][9];
        for (i = 0; i < 9; i++)
            for (j = 0; j < 9; j++)
            {
                board[i][j] = (byte) (s.charAt (i * 9 + j) - '0');
                if (board[i][j] > 10)
                {
                    isCarved[i][j] = true;
                    board[i][j] -= 10;
                    solution[i][j] = board[i][j];
                    writtenCnt++;
                }
                else
                {
                    solution[i][j] = board[i][j];
                    board[i][j] = 0;
                    isCarved[i][j] = false;
                }
            }
    }
    

    protected SuDoKuLogic (String strOrig, String strSaved) {
        int i, j;
        byte b;
        
        strSolution = strOrig;
        board = new byte[9][9];
        solution = new byte[9][9];
        isCarved = new boolean[9][9];
        for (i = 0; i < 9; i++)
            for (j = 0; j < 9; j++)
            {
                board[i][j] = (byte) (strSaved.charAt (i * 9 + j) - '0');
                b = (byte) (strOrig.charAt (i * 9 + j) - '0');
                if (board[i][j] > 0)
                    writtenCnt++;
                if (b > 10)
                {
                    isCarved[i][j] = true;
                    solution[i][j] = (byte) (b - 10);
                }
                else
                {
                    isCarved[i][j] = false;
                    solution[i][j] = b;
                }

            }
    }


    public static SuDoKuLogic getPuzzle (String s)
    {
        if (s.length() != 81)
            return null;
        return new SuDoKuLogic (s);
    }
    

    public static SuDoKuLogic getPuzzle (String strOrig, String strSaved)
    {
        if ((strOrig.length() != 81) || (strSaved.length() != 81))
            return null;
        return new SuDoKuLogic (strOrig, strSaved);
    }

    public boolean isCarved(int i, int j)
    {
        return isCarved[i][j];
    }

    public byte getValue (byte i, byte j)
    {
        return board[i][j];
    }

    public byte getSolutionValue (byte i, byte j)
    {
        return solution[i][j];
    }

    public void setValueWithoutChecks (byte i, byte j, byte n)
    {
        byte old = board[i][j];
        
        board[i][j] = n;
        
        if (!isCarved[i][j])
            if ((n > 0) && (old == 0))
                writtenCnt++;
            else if ((n == 0) && (old > 0))
                writtenCnt--;

    }

    public boolean isSolved()
    {

        if (writtenCnt < 81)
            return false;
        for (byte i = 0; i < 9; i++)
        {

            if (!isValidColumn (i))
                return false;

            if (!isValidRow (i))
                return false;

            if (!isValidSquare ((byte) (i / 3), (byte) (i % 3)))
                return false;
        }

        return true;
    }
    

    protected boolean isValidColumn (byte j)
    {
        byte b, k;
        for (byte i = 0; i < 8; i++)
        {
            b = board[i][j];
            for (k = (byte) (i + 1); k < 9; k++)
                if (b == board[k][j])
                    return false;
        }
        return true;
    }
    

    protected boolean isValidRow (byte i)
    {
        byte b, k;
        for (byte j = 0; j < 8; j++)
        {
            b = board[i][j];
            for (k = (byte) (j + 1); k < 9; k++)
                if (b == board[i][k])
                    return false;
        }
        return true;
    }


    protected boolean isValidSquare (byte iRow, byte jCol)
    {
        byte b, k;
        for (byte n = 0; n < 8; n++)
        {
            b = board[iRow * 3 + (n / 3)][jCol * 3 + (n % 3)];
            for (k = (byte) (n + 1); n < 9; n++)
                if (b == board[iRow * 3 + (k / 3)][jCol * 3 + (k % 3)])
                    return false;
        }
        return true;
    }


    public String getPuzzleAsString()
    {
      char[] caReturn = new char[81];
      byte i, j;
      
      for (i = 0; i < 9; i++)
          for (j = 0; j < 9; j++)
              caReturn[i * 9 + j] = (char) ('0' + board[i][j]);
      

      return new String (caReturn);
    }


    public String getSolutionAsString()
    {
        return strSolution;
    }
    

    public void clean()
    {
        byte i, j;
        
        for (i = 0; i < 9; i++)
            for (j = 0; j < 9; j++)
                if (!isCarved[i][j])
                    board[i][j] = 0;
    }
}

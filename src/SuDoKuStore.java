//Download by http://www.codefans.net

import javax.microedition.rms.*;


public class SuDoKuStore {

    protected static final String sRecordName = "SuDoKu";
    protected static final int Size = 82;
    protected static final int totalSize = 163;
    protected static final int timeSize = Long.toString (Long.MAX_VALUE).length() + 2;
    
    protected RecordStore rs;

    protected byte level = 0;

    protected byte back = 0;
    protected byte input = SuDoKuModel.GUIDE;
    protected long gameDuration = 0;
    protected String strPuzzle = null, strSolution = null;
    
    /** Creates a new instance of SuDoKuStore */
    public SuDoKuStore()
    {
        int len;
        
        try
        {
            rs = RecordStore.openRecordStore (sRecordName, true);

            if (rs.getNumRecords() == 0)
                return;

            len = rs.getRecordSize (1);
            byte[] temp = new byte[len];
            try
            {
                rs.getRecord (1, temp, 0);
            } catch (ArrayIndexOutOfBoundsException aioobe)
            {
                return;
            }
            
            if ((len != Size) && (len != totalSize))
                return;
            
            level = temp[0];

            strPuzzle = new String (temp, 1, 81);
            if (len== totalSize)
                strSolution = new String (temp, 82, 81);

            
            if (rs.getNumRecords() == 1)
                return;

            len = rs.getRecordSize (2);
            temp = new byte[len];
            try
            {
                rs.getRecord (2, temp, 0);
            } catch (ArrayIndexOutOfBoundsException aioobe)
            {
                return;
            }
            
            if ((len != timeSize) && (len != timeSize - 1))
                return;
            
            back = (byte) (temp[0] - 1);
            if (len == timeSize)
                input = (byte) (temp[1]);
            try
            {
                if (len == timeSize)
                    gameDuration = Long.parseLong(new String (temp, 2, len - 2));
                else
                    gameDuration = Long.parseLong(new String (temp, 1, len - 1));
            }
            catch (NumberFormatException nfe)
            {
                gameDuration = 0;
            }

        } catch (RecordStoreNotFoundException rsnfe)
        {
            System.out.println ("RecordStoreNotFoundException: " + rsnfe.getMessage());
        } catch (RecordStoreFullException rsfe)
        {
            System.out.println ("RecordStoreFullException: " + rsfe.getMessage());
        } catch (RecordStoreException rse)
        {
            System.out.println ("RecordStoreException: " + rse.getMessage());
        }
    }

    public byte getCurrentLevel()
    {
        return level;
    }

    public byte getBack()
    {
        return back;
    }


    public byte getInput()
    {
        return input;
    }


    public long getTime()
    {
        return gameDuration;
    }


    

    public String getCurrentPuzzleAsString()
    {
        return strPuzzle;
    }

    public String getCurrentSolutionAsString()
    {
        return strSolution;
    }



    public void save (byte level,  String strPuzzle, String strSolution, byte back, long gameDuration, byte input)
    {
        byte[] str2write = new byte[totalSize];
        byte[] time2write = new byte[timeSize];
        
        str2write[0] = level;

        System.arraycopy (strPuzzle.getBytes(), 0, str2write, 1, 81);
        System.arraycopy (strSolution.getBytes(), 0, str2write, 82, 81);
        
        time2write[0] = (byte) (back + 1);
        time2write[1] = input;
        System.arraycopy (formatTime (Long.toString (gameDuration)).getBytes(), 0, time2write, 2, timeSize - 2);
        
        try
        {
            if (rs.getNumRecords() == 0)

                rs.addRecord (str2write, 0, str2write.length);
            else
                rs.setRecord (1, str2write, 0, str2write.length);
            if (rs.getNumRecords() == 1)

                rs.addRecord (time2write, 0, time2write.length);
            else
                rs.setRecord (2, time2write, 0, time2write.length);
            rs.closeRecordStore();
        } catch (RecordStoreException rse)
        {

        }
    }
    
    protected String formatTime (String strTime)
    {
        String strReturn = strTime;
        int i, n = Long.toString (Long.MAX_VALUE).length() - strTime.length();
        
        for (i = 0; i < n; i++)
            strReturn = "0" + strReturn;
        
        return strReturn;
    }
}

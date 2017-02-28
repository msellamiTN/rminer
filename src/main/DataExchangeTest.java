// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   DataExchangeTest.java

package main;

import java.awt.EventQueue;

// Referenced classes of package main:
//            DataExchangeFrame

public class DataExchangeTest
{

    public DataExchangeTest()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                DataExchangeFrame frame = new DataExchangeFrame();
            //    0    0:new             #18  <Class DataExchangeFrame>
            //    1    3:dup             
            //    2    4:invokespecial   #19  <Method void DataExchangeFrame()>
            //    3    7:astore_1        
                frame.setDefaultCloseOperation(3);
            //    4    8:aload_1         
            //    5    9:iconst_3        
            //    6   10:invokevirtual   #23  <Method void DataExchangeFrame.setDefaultCloseOperation(int)>
                frame.setVisible(true);
            //    7   13:aload_1         
            //    8   14:iconst_1        
            //    9   15:invokevirtual   #27  <Method void DataExchangeFrame.setVisible(boolean)>
            //   10   18:return          
            }

        }
);
    //    0    0:new             #17  <Class DataExchangeTest$1>
    //    1    3:dup             
    //    2    4:invokespecial   #18  <Method void DataExchangeTest$1()>
    //    3    7:invokestatic    #24  <Method void EventQueue.invokeLater(Runnable)>
    //    4   10:return          
    }
}

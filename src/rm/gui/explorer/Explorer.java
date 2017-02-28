// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Explorer.java

package rm.gui.explorer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.EventListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import rm.core.Capabilities;
import rm.gui.Logger;

// Referenced classes of package rm.gui.explorer:
//            TabbedPane

public class Explorer
{
    public static interface LogHandler
    {

        public abstract void setLog(Logger logger);
    }

    public static interface CapabilitiesFilterChangeListener
        extends EventListener
    {

        public abstract void capabilitiesFilterChanged(CapabilitiesFilterChangeEvent capabilitiesfilterchangeevent);
    }

    public static class CapabilitiesFilterChangeEvent extends ChangeEvent
    {

        protected Capabilities m_Filter;

        public CapabilitiesFilterChangeEvent(Object source, Capabilities filter)
        {
            super(source);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:invokespecial   #12  <Method void ChangeEvent(Object)>
            m_Filter = filter;
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:putfield        #14  <Field Capabilities m_Filter>
        //    6   10:return          
        }
    }


    public Explorer()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //    0    0:invokestatic    #22  <Method String UIManager.getSystemLookAndFeelClassName()>
            //    1    3:invokestatic    #26  <Method void UIManager.setLookAndFeel(String)>
                }
            //*   2    6:goto            14
                catch(Exception exception)
            //*   3    9:astore_1        
                {
                    exception.printStackTrace();
            //    4   10:aload_1         
            //    5   11:invokevirtual   #31  <Method void Exception.printStackTrace()>
                }
                JFrame frame = new TabbedPane();
            //    6   14:new             #33  <Class TabbedPane>
            //    7   17:dup             
            //    8   18:invokespecial   #34  <Method void TabbedPane()>
            //    9   21:astore_1        
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            //   10   22:invokestatic    #40  <Method Toolkit Toolkit.getDefaultToolkit()>
            //   11   25:invokevirtual   #44  <Method Dimension Toolkit.getScreenSize()>
            //   12   28:astore_2        
                frame.setLocation((screenSize.width - 800) / 2, (screenSize.height - 600) / 2);
            //   13   29:aload_1         
            //   14   30:aload_2         
            //   15   31:getfield        #50  <Field int Dimension.width>
            //   16   34:sipush          800
            //   17   37:isub            
            //   18   38:iconst_2        
            //   19   39:idiv            
            //   20   40:aload_2         
            //   21   41:getfield        #53  <Field int Dimension.height>
            //   22   44:sipush          600
            //   23   47:isub            
            //   24   48:iconst_2        
            //   25   49:idiv            
            //   26   50:invokevirtual   #59  <Method void JFrame.setLocation(int, int)>
                frame.setDefaultCloseOperation(3);
            //   27   53:aload_1         
            //   28   54:iconst_3        
            //   29   55:invokevirtual   #63  <Method void JFrame.setDefaultCloseOperation(int)>
                frame.setVisible(true);
            //   30   58:aload_1         
            //   31   59:iconst_1        
            //   32   60:invokevirtual   #67  <Method void JFrame.setVisible(boolean)>
            //   33   63:return          
            }

        }
);
    //    0    0:new             #17  <Class Explorer$1>
    //    1    3:dup             
    //    2    4:invokespecial   #18  <Method void Explorer$1()>
    //    3    7:invokestatic    #24  <Method void SwingUtilities.invokeLater(Runnable)>
    //    4   10:return          
    }
}

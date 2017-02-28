// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PrintablePanel.java

package rm.gui.visualize;

import java.util.Hashtable;
import javax.swing.JPanel;

// Referenced classes of package rm.gui.visualize:
//            PrintableHandler, PrintableComponent, JComponentWriter

public class PrintablePanel extends JPanel
    implements PrintableHandler
{

    public PrintablePanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #13  <Method void JPanel()>
        m_Printer = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #15  <Field PrintableComponent m_Printer>
        m_Printer = new PrintableComponent(this);
    //    5    9:aload_0         
    //    6   10:new             #17  <Class PrintableComponent>
    //    7   13:dup             
    //    8   14:aload_0         
    //    9   15:invokespecial   #20  <Method void PrintableComponent(javax.swing.JComponent)>
    //   10   18:putfield        #15  <Field PrintableComponent m_Printer>
    //   11   21:return          
    }

    public Hashtable getWriters()
    {
        return m_Printer.getWriters();
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:invokevirtual   #28  <Method Hashtable PrintableComponent.getWriters()>
    //    3    7:areturn         
    }

    public JComponentWriter getWriter(String name)
    {
        return m_Printer.getWriter(name);
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #32  <Method JComponentWriter PrintableComponent.getWriter(String)>
    //    4    8:areturn         
    }

    public void setSaveDialogTitle(String title)
    {
        m_Printer.setSaveDialogTitle(title);
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #38  <Method void PrintableComponent.setSaveDialogTitle(String)>
    //    4    8:return          
    }

    public String getSaveDialogTitle()
    {
        return m_Printer.getSaveDialogTitle();
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:invokevirtual   #43  <Method String PrintableComponent.getSaveDialogTitle()>
    //    3    7:areturn         
    }

    public void setScale(double x, double y)
    {
        m_Printer.setScale(x, y);
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:dload_1         
    //    3    5:dload_3         
    //    4    6:invokevirtual   #47  <Method void PrintableComponent.setScale(double, double)>
    //    5    9:return          
    }

    public double getXScale()
    {
        return m_Printer.getXScale();
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:invokevirtual   #54  <Method double PrintableComponent.getXScale()>
    //    3    7:dreturn         
    }

    public double getYScale()
    {
        return m_Printer.getYScale();
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:invokevirtual   #57  <Method double PrintableComponent.getYScale()>
    //    3    7:dreturn         
    }

    public void saveComponent()
    {
        m_Printer.saveComponent();
    //    0    0:aload_0         
    //    1    1:getfield        #15  <Field PrintableComponent m_Printer>
    //    2    4:invokevirtual   #60  <Method void PrintableComponent.saveComponent()>
    //    3    7:return          
    }

    protected PrintableComponent m_Printer;
}

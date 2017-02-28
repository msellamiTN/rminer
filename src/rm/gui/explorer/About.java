// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   About.java

package rm.gui.explorer;

import java.io.IOException;
import javax.swing.*;

public class About extends JPanel
{

    public About()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #11  <Method void JPanel()>
        editorPane = new JEditorPane();
    //    2    4:aload_0         
    //    3    5:new             #13  <Class JEditorPane>
    //    4    8:dup             
    //    5    9:invokespecial   #14  <Method void JEditorPane()>
    //    6   12:putfield        #16  <Field JEditorPane editorPane>
        editorPane.setEditable(false);
    //    7   15:aload_0         
    //    8   16:getfield        #16  <Field JEditorPane editorPane>
    //    9   19:iconst_0        
    //   10   20:invokevirtual   #20  <Method void JEditorPane.setEditable(boolean)>
        java.net.URL path = getClass().getClassLoader().getResource("help/RMiner.htm");
    //   11   23:aload_0         
    //   12   24:invokevirtual   #26  <Method Class Object.getClass()>
    //   13   27:invokevirtual   #32  <Method ClassLoader Class.getClassLoader()>
    //   14   30:ldc1            #34  <String "help/RMiner.htm">
    //   15   32:invokevirtual   #40  <Method java.net.URL ClassLoader.getResource(String)>
    //   16   35:astore_1        
        try
        {
            editorPane.setPage(path);
    //   17   36:aload_0         
    //   18   37:getfield        #16  <Field JEditorPane editorPane>
    //   19   40:aload_1         
    //   20   41:invokevirtual   #44  <Method void JEditorPane.setPage(java.net.URL)>
        }
    //*  21   44:goto            52
        catch(IOException e)
    //*  22   47:astore_2        
        {
            e.printStackTrace();
    //   23   48:aload_2         
    //   24   49:invokevirtual   #49  <Method void IOException.printStackTrace()>
        }
    //   25   52:return          
    }

    public JScrollPane getJPanel()
    {
        return new JScrollPane(editorPane);
    //    0    0:new             #61  <Class JScrollPane>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #16  <Field JEditorPane editorPane>
    //    4    8:invokespecial   #64  <Method void JScrollPane(java.awt.Component)>
    //    5   11:areturn         
    }

    private JEditorPane editorPane;
}

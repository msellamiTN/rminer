// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertyText.java

package rm.gui;

import java.awt.event.*;
import java.beans.PropertyEditor;
import javax.swing.JTextField;

class PropertyText extends JTextField
{

    PropertyText(PropertyEditor pe)
    {
        super(pe.getAsText().equals("null") ? "" : pe.getAsText());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokeinterface #20  <Method String PropertyEditor.getAsText()>
    //    3    7:ldc1            #22  <String "null">
    //    4    9:invokevirtual   #28  <Method boolean String.equals(Object)>
    //    5   12:ifeq            20
    //    6   15:ldc1            #30  <String "">
    //    7   17:goto            26
    //    8   20:aload_1         
    //    9   21:invokeinterface #20  <Method String PropertyEditor.getAsText()>
    //   10   26:invokespecial   #33  <Method void JTextField(String)>
        m_Editor = pe;
    //   11   29:aload_0         
    //   12   30:aload_1         
    //   13   31:putfield        #35  <Field PropertyEditor m_Editor>
        addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e)
            {
                updateEditor();
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field PropertyText this$0>
            //    2    4:invokevirtual   #25  <Method void PropertyText.updateEditor()>
            //    3    7:return          
            }

            final PropertyText this$0;

            
            {
                this$0 = PropertyText.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field PropertyText this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void KeyAdapter()>
            //    5    9:return          
            }
        }
);
    //   14   34:aload_0         
    //   15   35:new             #37  <Class PropertyText$1>
    //   16   38:dup             
    //   17   39:aload_0         
    //   18   40:invokespecial   #40  <Method void PropertyText$1(PropertyText)>
    //   19   43:invokevirtual   #44  <Method void addKeyListener(java.awt.event.KeyListener)>
        addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent e)
            {
                updateEditor();
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field PropertyText this$0>
            //    2    4:invokevirtual   #25  <Method void PropertyText.updateEditor()>
            //    3    7:return          
            }

            final PropertyText this$0;

            
            {
                this$0 = PropertyText.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field PropertyText this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void FocusAdapter()>
            //    5    9:return          
            }
        }
);
    //   20   46:aload_0         
    //   21   47:new             #46  <Class PropertyText$2>
    //   22   50:dup             
    //   23   51:aload_0         
    //   24   52:invokespecial   #47  <Method void PropertyText$2(PropertyText)>
    //   25   55:invokevirtual   #51  <Method void addFocusListener(java.awt.event.FocusListener)>
    //   26   58:return          
    }

    protected void updateUs()
    {
        try
        {
            setText(m_Editor.getAsText());
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #35  <Field PropertyEditor m_Editor>
    //    3    5:invokeinterface #20  <Method String PropertyEditor.getAsText()>
    //    4   10:invokevirtual   #61  <Method void setText(String)>
        }
    //*   5   13:goto            17
        catch(IllegalArgumentException illegalargumentexception) { }
    //    6   16:astore_1        
    //    7   17:return          
    }

    protected void updateEditor()
    {
        try
        {
            m_Editor.setAsText(getText());
    //    0    0:aload_0         
    //    1    1:getfield        #35  <Field PropertyEditor m_Editor>
    //    2    4:aload_0         
    //    3    5:invokevirtual   #67  <Method String getText()>
    //    4    8:invokeinterface #70  <Method void PropertyEditor.setAsText(String)>
        }
    //*   5   13:goto            17
        catch(IllegalArgumentException illegalargumentexception) { }
    //    6   16:astore_1        
    //    7   17:return          
    }

    private static final long serialVersionUID = 0xc9a9e859c17fd1f6L;
    private PropertyEditor m_Editor;
}

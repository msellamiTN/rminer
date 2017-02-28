// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PropertyDialog.java

package rm.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyEditor;
import javax.swing.JDialog;

public class PropertyDialog extends JDialog
{

    /**
     * @deprecated Method PropertyDialog is deprecated
     */

    public PropertyDialog(PropertyEditor pe, int x, int y)
    {
        this(((Frame) (null)), pe, x, y);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:aload_1         
    //    3    3:iload_2         
    //    4    4:iload_3         
    //    5    5:invokespecial   #20  <Method void PropertyDialog(Frame, PropertyEditor, int, int)>
        setVisible(true);
    //    6    8:aload_0         
    //    7    9:iconst_1        
    //    8   10:invokevirtual   #24  <Method void setVisible(boolean)>
    //    9   13:return          
    }

    public PropertyDialog(Dialog owner, PropertyEditor pe)
    {
        this(owner, pe, -1, -1);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:iconst_m1       
    //    4    4:iconst_m1       
    //    5    5:invokespecial   #36  <Method void PropertyDialog(Dialog, PropertyEditor, int, int)>
    //    6    8:return          
    }

    public PropertyDialog(Dialog owner, PropertyEditor pe, int x, int y)
    {
        super(owner, pe.getClass().getName(), true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokevirtual   #44  <Method Class Object.getClass()>
    //    4    6:invokevirtual   #50  <Method String Class.getName()>
    //    5    9:iconst_1        
    //    6   10:invokespecial   #53  <Method void JDialog(Dialog, String, boolean)>
        initialize(pe, x, y);
    //    7   13:aload_0         
    //    8   14:aload_2         
    //    9   15:iload_3         
    //   10   16:iload           4
    //   11   18:invokevirtual   #56  <Method void initialize(PropertyEditor, int, int)>
    //   12   21:return          
    }

    public PropertyDialog(Frame owner, PropertyEditor pe)
    {
        this(owner, pe, -1, -1);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:iconst_m1       
    //    4    4:iconst_m1       
    //    5    5:invokespecial   #20  <Method void PropertyDialog(Frame, PropertyEditor, int, int)>
    //    6    8:return          
    }

    public PropertyDialog(Frame owner, PropertyEditor pe, int x, int y)
    {
        super(owner, pe.getClass().getName(), true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokevirtual   #44  <Method Class Object.getClass()>
    //    4    6:invokevirtual   #50  <Method String Class.getName()>
    //    5    9:iconst_1        
    //    6   10:invokespecial   #61  <Method void JDialog(Frame, String, boolean)>
        initialize(pe, x, y);
    //    7   13:aload_0         
    //    8   14:aload_2         
    //    9   15:iload_3         
    //   10   16:iload           4
    //   11   18:invokevirtual   #56  <Method void initialize(PropertyEditor, int, int)>
    //   12   21:return          
    }

    protected void initialize(PropertyEditor pe, int x, int y)
    {
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
            //    0    0:aload_1         
            //    1    1:invokevirtual   #26  <Method Window WindowEvent.getWindow()>
            //    2    4:invokevirtual   #31  <Method void Window.dispose()>
            //    3    7:return          
            }

            final PropertyDialog this$0;

            
            {
                this$0 = PropertyDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field PropertyDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void WindowAdapter()>
            //    5    9:return          
            }
        }
);
    //    0    0:aload_0         
    //    1    1:new             #63  <Class PropertyDialog$1>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:invokespecial   #66  <Method void PropertyDialog$1(PropertyDialog)>
    //    5    9:invokevirtual   #70  <Method void addWindowListener(java.awt.event.WindowListener)>
        getContentPane().setLayout(new BorderLayout());
    //    6   12:aload_0         
    //    7   13:invokevirtual   #74  <Method Container getContentPane()>
    //    8   16:new             #76  <Class BorderLayout>
    //    9   19:dup             
    //   10   20:invokespecial   #79  <Method void BorderLayout()>
    //   11   23:invokevirtual   #85  <Method void Container.setLayout(java.awt.LayoutManager)>
        m_Editor = pe;
    //   12   26:aload_0         
    //   13   27:aload_1         
    //   14   28:putfield        #87  <Field PropertyEditor m_Editor>
        m_EditorComponent = pe.getCustomEditor();
    //   15   31:aload_0         
    //   16   32:aload_1         
    //   17   33:invokeinterface #93  <Method Component PropertyEditor.getCustomEditor()>
    //   18   38:putfield        #95  <Field Component m_EditorComponent>
        getContentPane().add(m_EditorComponent, "Center");
    //   19   41:aload_0         
    //   20   42:invokevirtual   #74  <Method Container getContentPane()>
    //   21   45:aload_0         
    //   22   46:getfield        #95  <Field Component m_EditorComponent>
    //   23   49:ldc1            #97  <String "Center">
    //   24   51:invokevirtual   #101 <Method void Container.add(Component, Object)>
        pack();
    //   25   54:aload_0         
    //   26   55:invokevirtual   #104 <Method void pack()>
        int screenWidth = getGraphicsConfiguration().getBounds().width;
    //   27   58:aload_0         
    //   28   59:invokevirtual   #108 <Method GraphicsConfiguration getGraphicsConfiguration()>
    //   29   62:invokevirtual   #114 <Method Rectangle GraphicsConfiguration.getBounds()>
    //   30   65:getfield        #119 <Field int Rectangle.width>
    //   31   68:istore          4
        int screenHeight = getGraphicsConfiguration().getBounds().height;
    //   32   70:aload_0         
    //   33   71:invokevirtual   #108 <Method GraphicsConfiguration getGraphicsConfiguration()>
    //   34   74:invokevirtual   #114 <Method Rectangle GraphicsConfiguration.getBounds()>
    //   35   77:getfield        #122 <Field int Rectangle.height>
    //   36   80:istore          5
        if((double)getHeight() > (double)screenHeight * 0.94999999999999996D)
    //*  37   82:aload_0         
    //*  38   83:invokevirtual   #126 <Method int getHeight()>
    //*  39   86:i2d             
    //*  40   87:iload           5
    //*  41   89:i2d             
    //*  42   90:ldc2w           #127 <Double 0.94999999999999996D>
    //*  43   93:dmul            
    //*  44   94:dcmpl           
    //*  45   95:ifle            114
            setSize(getWidth(), (int)((double)screenHeight * 0.94999999999999996D));
    //   46   98:aload_0         
    //   47   99:aload_0         
    //   48  100:invokevirtual   #131 <Method int getWidth()>
    //   49  103:iload           5
    //   50  105:i2d             
    //   51  106:ldc2w           #127 <Double 0.94999999999999996D>
    //   52  109:dmul            
    //   53  110:d2i             
    //   54  111:invokevirtual   #135 <Method void setSize(int, int)>
        if(x == -1 && y == -1)
    //*  55  114:iload_2         
    //*  56  115:iconst_m1       
    //*  57  116:icmpne          132
    //*  58  119:iload_3         
    //*  59  120:iconst_m1       
    //*  60  121:icmpne          132
        {
            setLocationRelativeTo(null);
    //   61  124:aload_0         
    //   62  125:aconst_null     
    //   63  126:invokevirtual   #139 <Method void setLocationRelativeTo(Component)>
        } else
    //*  64  129:goto            176
        {
            if(x + getWidth() > screenWidth)
    //*  65  132:iload_2         
    //*  66  133:aload_0         
    //*  67  134:invokevirtual   #131 <Method int getWidth()>
    //*  68  137:iadd            
    //*  69  138:iload           4
    //*  70  140:icmple          151
                x = screenWidth - getWidth();
    //   71  143:iload           4
    //   72  145:aload_0         
    //   73  146:invokevirtual   #131 <Method int getWidth()>
    //   74  149:isub            
    //   75  150:istore_2        
            if(y + getHeight() > screenHeight)
    //*  76  151:iload_3         
    //*  77  152:aload_0         
    //*  78  153:invokevirtual   #126 <Method int getHeight()>
    //*  79  156:iadd            
    //*  80  157:iload           5
    //*  81  159:icmple          170
                y = screenHeight - getHeight();
    //   82  162:iload           5
    //   83  164:aload_0         
    //   84  165:invokevirtual   #126 <Method int getHeight()>
    //   85  168:isub            
    //   86  169:istore_3        
            setLocation(x, y);
    //   87  170:aload_0         
    //   88  171:iload_2         
    //   89  172:iload_3         
    //   90  173:invokevirtual   #142 <Method void setLocation(int, int)>
        }
    //   91  176:return          
    }

    public PropertyEditor getEditor()
    {
        return m_Editor;
    //    0    0:aload_0         
    //    1    1:getfield        #87  <Field PropertyEditor m_Editor>
    //    2    4:areturn         
    }

    public static Frame getParentFrame(Container c)
    {
        Frame result = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        for(Container parent = c; parent != null; parent = parent.getParent())
    //*   2    2:aload_0         
    //*   3    3:astore_2        
    //*   4    4:goto            27
        {
            if(!(parent instanceof Frame))
                continue;
    //    5    7:aload_2         
    //    6    8:instanceof      #150 <Class Frame>
    //    7   11:ifeq            22
            result = (Frame)parent;
    //    8   14:aload_2         
    //    9   15:checkcast       #150 <Class Frame>
    //   10   18:astore_1        
            break;
    //   11   19:goto            31
        }

    //   12   22:aload_2         
    //   13   23:invokevirtual   #153 <Method Container Container.getParent()>
    //   14   26:astore_2        
    //   15   27:aload_2         
    //   16   28:ifnonnull       7
        return result;
    //   17   31:aload_1         
    //   18   32:areturn         
    }

    public static Dialog getParentDialog(Container c)
    {
        Dialog result = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        for(Container parent = c; parent != null; parent = parent.getParent())
    //*   2    2:aload_0         
    //*   3    3:astore_2        
    //*   4    4:goto            27
        {
            if(!(parent instanceof Dialog))
                continue;
    //    5    7:aload_2         
    //    6    8:instanceof      #161 <Class Dialog>
    //    7   11:ifeq            22
            result = (Dialog)parent;
    //    8   14:aload_2         
    //    9   15:checkcast       #161 <Class Dialog>
    //   10   18:astore_1        
            break;
    //   11   19:goto            31
        }

    //   12   22:aload_2         
    //   13   23:invokevirtual   #153 <Method Container Container.getParent()>
    //   14   26:astore_2        
    //   15   27:aload_2         
    //   16   28:ifnonnull       7
        return result;
    //   17   31:aload_1         
    //   18   32:areturn         
    }

    private static final long serialVersionUID = 0xdfdfff6871e8027dL;
    private PropertyEditor m_Editor;
    private Component m_EditorComponent;
}

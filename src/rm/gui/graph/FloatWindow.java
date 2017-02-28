// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   FloatWindow.java

package rm.gui.graph;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class FloatWindow
{
    private class ToolTipSingle extends JWindow
    {

        private void initComponents()
        {
            setSize(width, height);
        //    0    0:aload_0         
        //    1    1:aload_0         
        //    2    2:getfield        #20  <Field FloatWindow this$0>
        //    3    5:invokestatic    #46  <Method int FloatWindow.access$0(FloatWindow)>
        //    4    8:aload_0         
        //    5    9:getfield        #20  <Field FloatWindow this$0>
        //    6   12:invokestatic    #49  <Method int FloatWindow.access$1(FloatWindow)>
        //    7   15:invokevirtual   #53  <Method void setSize(int, int)>
            perms.setFont(font);
        //    8   18:aload_0         
        //    9   19:getfield        #33  <Field JTextArea perms>
        //   10   22:aload_0         
        //   11   23:getfield        #20  <Field FloatWindow this$0>
        //   12   26:invokestatic    #57  <Method Font FloatWindow.access$2(FloatWindow)>
        //   13   29:invokevirtual   #61  <Method void JTextArea.setFont(Font)>
            JPanel externalPanel = new JPanel(new BorderLayout(1, 1));
        //   14   32:new             #63  <Class JPanel>
        //   15   35:dup             
        //   16   36:new             #65  <Class BorderLayout>
        //   17   39:dup             
        //   18   40:iconst_1        
        //   19   41:iconst_1        
        //   20   42:invokespecial   #67  <Method void BorderLayout(int, int)>
        //   21   45:invokespecial   #70  <Method void JPanel(java.awt.LayoutManager)>
        //   22   48:astore_1        
            externalPanel.setBackground(bgColor);
        //   23   49:aload_1         
        //   24   50:aload_0         
        //   25   51:getfield        #20  <Field FloatWindow this$0>
        //   26   54:invokestatic    #74  <Method Color FloatWindow.access$3(FloatWindow)>
        //   27   57:invokevirtual   #78  <Method void JPanel.setBackground(Color)>
            JPanel innerPanel = new JPanel(new BorderLayout());
        //   28   60:new             #63  <Class JPanel>
        //   29   63:dup             
        //   30   64:new             #65  <Class BorderLayout>
        //   31   67:dup             
        //   32   68:invokespecial   #79  <Method void BorderLayout()>
        //   33   71:invokespecial   #70  <Method void JPanel(java.awt.LayoutManager)>
        //   34   74:astore_2        
            innerPanel.setBackground(bgColor);
        //   35   75:aload_2         
        //   36   76:aload_0         
        //   37   77:getfield        #20  <Field FloatWindow this$0>
        //   38   80:invokestatic    #74  <Method Color FloatWindow.access$3(FloatWindow)>
        //   39   83:invokevirtual   #78  <Method void JPanel.setBackground(Color)>
            perms.setBackground(bgColor);
        //   40   86:aload_0         
        //   41   87:getfield        #33  <Field JTextArea perms>
        //   42   90:aload_0         
        //   43   91:getfield        #20  <Field FloatWindow this$0>
        //   44   94:invokestatic    #74  <Method Color FloatWindow.access$3(FloatWindow)>
        //   45   97:invokevirtual   #80  <Method void JTextArea.setBackground(Color)>
            perms.setMargin(new Insets(4, 4, 4, 4));
        //   46  100:aload_0         
        //   47  101:getfield        #33  <Field JTextArea perms>
        //   48  104:new             #82  <Class Insets>
        //   49  107:dup             
        //   50  108:iconst_4        
        //   51  109:iconst_4        
        //   52  110:iconst_4        
        //   53  111:iconst_4        
        //   54  112:invokespecial   #85  <Method void Insets(int, int, int, int)>
        //   55  115:invokevirtual   #89  <Method void JTextArea.setMargin(Insets)>
            perms.setLineWrap(true);
        //   56  118:aload_0         
        //   57  119:getfield        #33  <Field JTextArea perms>
        //   58  122:iconst_1        
        //   59  123:invokevirtual   #93  <Method void JTextArea.setLineWrap(boolean)>
            perms.setWrapStyleWord(true);
        //   60  126:aload_0         
        //   61  127:getfield        #33  <Field JTextArea perms>
        //   62  130:iconst_1        
        //   63  131:invokevirtual   #96  <Method void JTextArea.setWrapStyleWord(boolean)>
            EtchedBorder etchedBorder = (EtchedBorder)BorderFactory.createEtchedBorder();
        //   64  134:invokestatic    #102 <Method javax.swing.border.Border BorderFactory.createEtchedBorder()>
        //   65  137:checkcast       #104 <Class EtchedBorder>
        //   66  140:astore_3        
            externalPanel.setBorder(etchedBorder);
        //   67  141:aload_1         
        //   68  142:aload_3         
        //   69  143:invokevirtual   #108 <Method void JPanel.setBorder(javax.swing.border.Border)>
            externalPanel.add(innerPanel);
        //   70  146:aload_1         
        //   71  147:aload_2         
        //   72  148:invokevirtual   #112 <Method java.awt.Component JPanel.add(java.awt.Component)>
        //   73  151:pop             
            perms.setForeground(messageColor);
        //   74  152:aload_0         
        //   75  153:getfield        #33  <Field JTextArea perms>
        //   76  156:aload_0         
        //   77  157:getfield        #20  <Field FloatWindow this$0>
        //   78  160:invokestatic    #115 <Method Color FloatWindow.access$4(FloatWindow)>
        //   79  163:invokevirtual   #118 <Method void JTextArea.setForeground(Color)>
            roleName.setForeground(roleColor);
        //   80  166:aload_0         
        //   81  167:getfield        #28  <Field JLabel roleName>
        //   82  170:aload_0         
        //   83  171:getfield        #20  <Field FloatWindow this$0>
        //   84  174:invokestatic    #121 <Method Color FloatWindow.access$5(FloatWindow)>
        //   85  177:invokevirtual   #122 <Method void JLabel.setForeground(Color)>
            innerPanel.add(roleName, "West");
        //   86  180:aload_2         
        //   87  181:aload_0         
        //   88  182:getfield        #28  <Field JLabel roleName>
        //   89  185:ldc1            #124 <String "West">
        //   90  187:invokevirtual   #127 <Method void JPanel.add(java.awt.Component, Object)>
            innerPanel.add(new JScrollPane(perms), "Center");
        //   91  190:aload_2         
        //   92  191:new             #129 <Class JScrollPane>
        //   93  194:dup             
        //   94  195:aload_0         
        //   95  196:getfield        #33  <Field JTextArea perms>
        //   96  199:invokespecial   #132 <Method void JScrollPane(java.awt.Component)>
        //   97  202:ldc1            #134 <String "Center">
        //   98  204:invokevirtual   #127 <Method void JPanel.add(java.awt.Component, Object)>
            getContentPane().add(externalPanel);
        //   99  207:aload_0         
        //  100  208:invokevirtual   #138 <Method Container getContentPane()>
        //  101  211:aload_1         
        //  102  212:invokevirtual   #141 <Method java.awt.Component Container.add(java.awt.Component)>
        //  103  215:pop             
        //  104  216:return          
        }

        public void animate(int x, int y)
        {
            (new Animation(this, x, y)).start();
        //    0    0:new             #149 <Class FloatWindow$Animation>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #20  <Field FloatWindow this$0>
        //    4    8:aload_0         
        //    5    9:iload_1         
        //    6   10:iload_2         
        //    7   11:invokespecial   #152 <Method void FloatWindow$Animation(FloatWindow, FloatWindow$ToolTipSingle, int, int)>
        //    8   14:invokevirtual   #155 <Method void FloatWindow$Animation.start()>
        //    9   17:return          
        }

        private static final long serialVersionUID = 1L;
        private JLabel roleName;
        private JTextArea perms;
        final FloatWindow this$0;


/*
        static JLabel access$0(ToolTipSingle tooltipsingle)
        {
            return tooltipsingle.roleName;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field JLabel roleName>
        //    2    4:areturn         
        }

*/


/*
        static JTextArea access$1(ToolTipSingle tooltipsingle)
        {
            return tooltipsingle.perms;
        //    0    0:aload_0         
        //    1    1:getfield        #33  <Field JTextArea perms>
        //    2    4:areturn         
        }

*/

        public ToolTipSingle()
        {
            this$0 = FloatWindow.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field FloatWindow this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void JWindow()>
            roleName = new JLabel();
        //    5    9:aload_0         
        //    6   10:new             #25  <Class JLabel>
        //    7   13:dup             
        //    8   14:invokespecial   #26  <Method void JLabel()>
        //    9   17:putfield        #28  <Field JLabel roleName>
            perms = new JTextArea();
        //   10   20:aload_0         
        //   11   21:new             #30  <Class JTextArea>
        //   12   24:dup             
        //   13   25:invokespecial   #31  <Method void JTextArea()>
        //   14   28:putfield        #33  <Field JTextArea perms>
            initComponents();
        //   15   31:aload_0         
        //   16   32:invokespecial   #36  <Method void initComponents()>
        //   17   35:return          
        }
    }

    class Animation extends Thread
    {

        public void run()
        {
            try
            {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //    0    0:invokestatic    #36  <Method GraphicsEnvironment GraphicsEnvironment.getLocalGraphicsEnvironment()>
        //    1    3:astore_1        
                Rectangle screenRect = ge.getMaximumWindowBounds();
        //    2    4:aload_1         
        //    3    5:invokevirtual   #40  <Method Rectangle GraphicsEnvironment.getMaximumWindowBounds()>
        //    4    8:astore_2        
                if(x >= screenRect.width - width - 1)
        //*   5    9:aload_0         
        //*   6   10:getfield        #23  <Field int x>
        //*   7   13:aload_2         
        //*   8   14:getfield        #45  <Field int Rectangle.width>
        //*   9   17:aload_0         
        //*  10   18:getfield        #16  <Field FloatWindow this$0>
        //*  11   21:invokestatic    #51  <Method int FloatWindow.access$0(FloatWindow)>
        //*  12   24:isub            
        //*  13   25:iconst_1        
        //*  14   26:isub            
        //*  15   27:icmplt          48
                    x = screenRect.width - width - 1;
        //   16   30:aload_0         
        //   17   31:aload_2         
        //   18   32:getfield        #45  <Field int Rectangle.width>
        //   19   35:aload_0         
        //   20   36:getfield        #16  <Field FloatWindow this$0>
        //   21   39:invokestatic    #51  <Method int FloatWindow.access$0(FloatWindow)>
        //   22   42:isub            
        //   23   43:iconst_1        
        //   24   44:isub            
        //   25   45:putfield        #23  <Field int x>
                if(y >= screenRect.height - height - 1)
        //*  26   48:aload_0         
        //*  27   49:getfield        #25  <Field int y>
        //*  28   52:aload_2         
        //*  29   53:getfield        #54  <Field int Rectangle.height>
        //*  30   56:aload_0         
        //*  31   57:getfield        #16  <Field FloatWindow this$0>
        //*  32   60:invokestatic    #57  <Method int FloatWindow.access$1(FloatWindow)>
        //*  33   63:isub            
        //*  34   64:iconst_1        
        //*  35   65:isub            
        //*  36   66:icmplt          87
                    y = screenRect.height - height - 1;
        //   37   69:aload_0         
        //   38   70:aload_2         
        //   39   71:getfield        #54  <Field int Rectangle.height>
        //   40   74:aload_0         
        //   41   75:getfield        #16  <Field FloatWindow this$0>
        //   42   78:invokestatic    #57  <Method int FloatWindow.access$1(FloatWindow)>
        //   43   81:isub            
        //   44   82:iconst_1        
        //   45   83:isub            
        //   46   84:putfield        #25  <Field int y>
                single.setLocation(x, y);
        //   47   87:aload_0         
        //   48   88:getfield        #21  <Field FloatWindow$ToolTipSingle single>
        //   49   91:aload_0         
        //   50   92:getfield        #23  <Field int x>
        //   51   95:aload_0         
        //   52   96:getfield        #25  <Field int y>
        //   53   99:invokevirtual   #63  <Method void FloatWindow$ToolTipSingle.setLocation(int, int)>
                single.setVisible(true);
        //   54  102:aload_0         
        //   55  103:getfield        #21  <Field FloatWindow$ToolTipSingle single>
        //   56  106:iconst_1        
        //   57  107:invokevirtual   #67  <Method void FloatWindow$ToolTipSingle.setVisible(boolean)>
                Thread.sleep(displayTime);
        //   58  110:aload_0         
        //   59  111:getfield        #16  <Field FloatWindow this$0>
        //   60  114:invokestatic    #70  <Method int FloatWindow.access$6(FloatWindow)>
        //   61  117:i2l             
        //   62  118:invokestatic    #74  <Method void Thread.sleep(long)>
                single.dispose();
        //   63  121:aload_0         
        //   64  122:getfield        #21  <Field FloatWindow$ToolTipSingle single>
        //   65  125:invokevirtual   #77  <Method void FloatWindow$ToolTipSingle.dispose()>
            }
        //*  66  128:goto            141
            catch(Exception e)
        //*  67  131:astore_1        
            {
                throw new RuntimeException(e);
        //   68  132:new             #79  <Class RuntimeException>
        //   69  135:dup             
        //   70  136:aload_1         
        //   71  137:invokespecial   #82  <Method void RuntimeException(Throwable)>
        //   72  140:athrow          
            }
        //   73  141:return          
        }

        ToolTipSingle single;
        int x;
        int y;
        final FloatWindow this$0;

        public Animation(ToolTipSingle single, int x, int y)
        {
            this$0 = FloatWindow.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field FloatWindow this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void Thread()>
            this.single = single;
        //    5    9:aload_0         
        //    6   10:aload_2         
        //    7   11:putfield        #21  <Field FloatWindow$ToolTipSingle single>
            this.x = x;
        //    8   14:aload_0         
        //    9   15:iload_3         
        //   10   16:putfield        #23  <Field int x>
            this.y = y;
        //   11   19:aload_0         
        //   12   20:iload           4
        //   13   22:putfield        #25  <Field int y>
        //   14   25:return          
        }
    }


    public FloatWindow()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
        width = 200;
    //    2    4:aload_0         
    //    3    5:sipush          200
    //    4    8:putfield        #22  <Field int width>
        height = 100;
    //    5   11:aload_0         
    //    6   12:bipush          100
    //    7   14:putfield        #24  <Field int height>
        displayTime = 6000;
    //    8   17:aload_0         
    //    9   18:sipush          6000
    //   10   21:putfield        #26  <Field int displayTime>
        font = new Font("Arial", 0, 12);
    //   11   24:aload_0         
    //   12   25:new             #28  <Class Font>
    //   13   28:dup             
    //   14   29:ldc1            #30  <String "Arial">
    //   15   31:iconst_0        
    //   16   32:bipush          12
    //   17   34:invokespecial   #33  <Method void Font(String, int, int)>
    //   18   37:putfield        #35  <Field Font font>
        bgColor = new Color(255, 255, 225);
    //   19   40:aload_0         
    //   20   41:new             #37  <Class Color>
    //   21   44:dup             
    //   22   45:sipush          255
    //   23   48:sipush          255
    //   24   51:sipush          225
    //   25   54:invokespecial   #40  <Method void Color(int, int, int)>
    //   26   57:putfield        #42  <Field Color bgColor>
        border = Color.BLACK;
    //   27   60:aload_0         
    //   28   61:getstatic       #45  <Field Color Color.BLACK>
    //   29   64:putfield        #47  <Field Color border>
        messageColor = Color.BLACK;
    //   30   67:aload_0         
    //   31   68:getstatic       #45  <Field Color Color.BLACK>
    //   32   71:putfield        #49  <Field Color messageColor>
        roleColor = Color.RED;
    //   33   74:aload_0         
    //   34   75:getstatic       #52  <Field Color Color.RED>
    //   35   78:putfield        #54  <Field Color roleColor>
    //   36   81:return          
    }

    public void setToolTip(int x, int y, String roleName, String perms)
    {
        ToolTipSingle single = new ToolTipSingle();
    //    0    0:new             #62  <Class FloatWindow$ToolTipSingle>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #65  <Method void FloatWindow$ToolTipSingle(FloatWindow)>
    //    4    8:astore          5
        single.roleName.setText(roleName);
    //    5   10:aload           5
    //    6   12:invokestatic    #69  <Method JLabel FloatWindow$ToolTipSingle.access$0(FloatWindow$ToolTipSingle)>
    //    7   15:aload_3         
    //    8   16:invokevirtual   #75  <Method void JLabel.setText(String)>
        single.perms.setText(perms);
    //    9   19:aload           5
    //   10   21:invokestatic    #79  <Method JTextArea FloatWindow$ToolTipSingle.access$1(FloatWindow$ToolTipSingle)>
    //   11   24:aload           4
    //   12   26:invokevirtual   #82  <Method void JTextArea.setText(String)>
        single.animate(x, y);
    //   13   29:aload           5
    //   14   31:iload_1         
    //   15   32:iload_2         
    //   16   33:invokevirtual   #86  <Method void FloatWindow$ToolTipSingle.animate(int, int)>
    //   17   36:return          
    }

    public static void main(String args[])
    {
        FloatWindow tip = new FloatWindow();
    //    0    0:new             #2   <Class FloatWindow>
    //    1    3:dup             
    //    2    4:invokespecial   #96  <Method void FloatWindow()>
    //    3    7:astore_1        
        tip.setToolTip(10, 10, "R1", "46546");
    //    4    8:aload_1         
    //    5    9:bipush          10
    //    6   11:bipush          10
    //    7   13:ldc1            #98  <String "R1">
    //    8   15:ldc1            #100 <String "46546">
    //    9   17:invokevirtual   #102 <Method void setToolTip(int, int, String, String)>
    //   10   20:return          
    }

    private int width;
    private int height;
    private int displayTime;
    private Font font;
    private Color bgColor;
    private Color border;
    private Color messageColor;
    private Color roleColor;


/*
    static int access$0(FloatWindow floatwindow)
    {
        return floatwindow.width;
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field int width>
    //    2    4:ireturn         
    }

*/


/*
    static int access$1(FloatWindow floatwindow)
    {
        return floatwindow.height;
    //    0    0:aload_0         
    //    1    1:getfield        #24  <Field int height>
    //    2    4:ireturn         
    }

*/


/*
    static Font access$2(FloatWindow floatwindow)
    {
        return floatwindow.font;
    //    0    0:aload_0         
    //    1    1:getfield        #35  <Field Font font>
    //    2    4:areturn         
    }

*/


/*
    static Color access$3(FloatWindow floatwindow)
    {
        return floatwindow.bgColor;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field Color bgColor>
    //    2    4:areturn         
    }

*/


/*
    static Color access$4(FloatWindow floatwindow)
    {
        return floatwindow.messageColor;
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field Color messageColor>
    //    2    4:areturn         
    }

*/


/*
    static Color access$5(FloatWindow floatwindow)
    {
        return floatwindow.roleColor;
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field Color roleColor>
    //    2    4:areturn         
    }

*/


/*
    static int access$6(FloatWindow floatwindow)
    {
        return floatwindow.displayTime;
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field int displayTime>
    //    2    4:ireturn         
    }

*/
}

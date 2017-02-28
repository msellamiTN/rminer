// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   testFloat.java

package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class testFloat
{
    class ToolTipSingle extends JWindow
    {

        private void initComponents()
        {
            setSize(_width, _height);
        //    0    0:aload_0         
        //    1    1:aload_0         
        //    2    2:getfield        #20  <Field testFloat this$0>
        //    3    5:invokestatic    #46  <Method int testFloat.access$0(testFloat)>
        //    4    8:aload_0         
        //    5    9:getfield        #20  <Field testFloat this$0>
        //    6   12:invokestatic    #49  <Method int testFloat.access$1(testFloat)>
        //    7   15:invokevirtual   #53  <Method void setSize(int, int)>
            _message.setFont(getMessageFont());
        //    8   18:aload_0         
        //    9   19:getfield        #33  <Field JTextArea _message>
        //   10   22:aload_0         
        //   11   23:getfield        #20  <Field testFloat this$0>
        //   12   26:invokevirtual   #57  <Method Font testFloat.getMessageFont()>
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
            externalPanel.setBackground(_bgColor);
        //   23   49:aload_1         
        //   24   50:aload_0         
        //   25   51:getfield        #20  <Field testFloat this$0>
        //   26   54:invokestatic    #74  <Method Color testFloat.access$2(testFloat)>
        //   27   57:invokevirtual   #78  <Method void JPanel.setBackground(Color)>
            JPanel innerPanel = new JPanel(new BorderLayout(getGap(), getGap()));
        //   28   60:new             #63  <Class JPanel>
        //   29   63:dup             
        //   30   64:new             #65  <Class BorderLayout>
        //   31   67:dup             
        //   32   68:aload_0         
        //   33   69:getfield        #20  <Field testFloat this$0>
        //   34   72:invokevirtual   #82  <Method int testFloat.getGap()>
        //   35   75:aload_0         
        //   36   76:getfield        #20  <Field testFloat this$0>
        //   37   79:invokevirtual   #82  <Method int testFloat.getGap()>
        //   38   82:invokespecial   #67  <Method void BorderLayout(int, int)>
        //   39   85:invokespecial   #70  <Method void JPanel(java.awt.LayoutManager)>
        //   40   88:astore_2        
            innerPanel.setBackground(_bgColor);
        //   41   89:aload_2         
        //   42   90:aload_0         
        //   43   91:getfield        #20  <Field testFloat this$0>
        //   44   94:invokestatic    #74  <Method Color testFloat.access$2(testFloat)>
        //   45   97:invokevirtual   #78  <Method void JPanel.setBackground(Color)>
            _message.setBackground(_bgColor);
        //   46  100:aload_0         
        //   47  101:getfield        #33  <Field JTextArea _message>
        //   48  104:aload_0         
        //   49  105:getfield        #20  <Field testFloat this$0>
        //   50  108:invokestatic    #74  <Method Color testFloat.access$2(testFloat)>
        //   51  111:invokevirtual   #83  <Method void JTextArea.setBackground(Color)>
            _message.setMargin(new Insets(4, 4, 4, 4));
        //   52  114:aload_0         
        //   53  115:getfield        #33  <Field JTextArea _message>
        //   54  118:new             #85  <Class Insets>
        //   55  121:dup             
        //   56  122:iconst_4        
        //   57  123:iconst_4        
        //   58  124:iconst_4        
        //   59  125:iconst_4        
        //   60  126:invokespecial   #88  <Method void Insets(int, int, int, int)>
        //   61  129:invokevirtual   #92  <Method void JTextArea.setMargin(Insets)>
            _message.setLineWrap(true);
        //   62  132:aload_0         
        //   63  133:getfield        #33  <Field JTextArea _message>
        //   64  136:iconst_1        
        //   65  137:invokevirtual   #96  <Method void JTextArea.setLineWrap(boolean)>
            _message.setWrapStyleWord(true);
        //   66  140:aload_0         
        //   67  141:getfield        #33  <Field JTextArea _message>
        //   68  144:iconst_1        
        //   69  145:invokevirtual   #99  <Method void JTextArea.setWrapStyleWord(boolean)>
            EtchedBorder etchedBorder = (EtchedBorder)BorderFactory.createEtchedBorder();
        //   70  148:invokestatic    #105 <Method javax.swing.border.Border BorderFactory.createEtchedBorder()>
        //   71  151:checkcast       #107 <Class EtchedBorder>
        //   72  154:astore_3        
            externalPanel.setBorder(etchedBorder);
        //   73  155:aload_1         
        //   74  156:aload_3         
        //   75  157:invokevirtual   #111 <Method void JPanel.setBorder(javax.swing.border.Border)>
            externalPanel.add(innerPanel);
        //   76  160:aload_1         
        //   77  161:aload_2         
        //   78  162:invokevirtual   #115 <Method java.awt.Component JPanel.add(java.awt.Component)>
        //   79  165:pop             
            _message.setForeground(getMessageColor());
        //   80  166:aload_0         
        //   81  167:getfield        #33  <Field JTextArea _message>
        //   82  170:aload_0         
        //   83  171:getfield        #20  <Field testFloat this$0>
        //   84  174:invokevirtual   #119 <Method Color testFloat.getMessageColor()>
        //   85  177:invokevirtual   #122 <Method void JTextArea.setForeground(Color)>
            innerPanel.add(_iconLabel, "West");
        //   86  180:aload_2         
        //   87  181:aload_0         
        //   88  182:getfield        #28  <Field JLabel _iconLabel>
        //   89  185:ldc1            #124 <String "West">
        //   90  187:invokevirtual   #127 <Method void JPanel.add(java.awt.Component, Object)>
            innerPanel.add(_message, "Center");
        //   91  190:aload_2         
        //   92  191:aload_0         
        //   93  192:getfield        #33  <Field JTextArea _message>
        //   94  195:ldc1            #129 <String "Center">
        //   95  197:invokevirtual   #127 <Method void JPanel.add(java.awt.Component, Object)>
            getContentPane().add(externalPanel);
        //   96  200:aload_0         
        //   97  201:invokevirtual   #133 <Method Container getContentPane()>
        //   98  204:aload_1         
        //   99  205:invokevirtual   #136 <Method java.awt.Component Container.add(java.awt.Component)>
        //  100  208:pop             
        //  101  209:return          
        }

        public void animate()
        {
            (new Animation(this)).start();
        //    0    0:new             #144 <Class testFloat$Animation>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #20  <Field testFloat this$0>
        //    4    8:aload_0         
        //    5    9:invokespecial   #147 <Method void testFloat$Animation(testFloat, testFloat$ToolTipSingle)>
        //    6   12:invokevirtual   #150 <Method void testFloat$Animation.start()>
        //    7   15:return          
        }

        private static final long serialVersionUID = 1L;
        private JLabel _iconLabel;
        private JTextArea _message;
        final testFloat this$0;


/*
        static JLabel access$0(ToolTipSingle tooltipsingle)
        {
            return tooltipsingle._iconLabel;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field JLabel _iconLabel>
        //    2    4:areturn         
        }

*/


/*
        static JTextArea access$1(ToolTipSingle tooltipsingle)
        {
            return tooltipsingle._message;
        //    0    0:aload_0         
        //    1    1:getfield        #33  <Field JTextArea _message>
        //    2    4:areturn         
        }

*/

        public ToolTipSingle()
        {
            this$0 = testFloat.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field testFloat this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void JWindow()>
            _iconLabel = new JLabel();
        //    5    9:aload_0         
        //    6   10:new             #25  <Class JLabel>
        //    7   13:dup             
        //    8   14:invokespecial   #26  <Method void JLabel()>
        //    9   17:putfield        #28  <Field JLabel _iconLabel>
            _message = new JTextArea();
        //   10   20:aload_0         
        //   11   21:new             #30  <Class JTextArea>
        //   12   24:dup             
        //   13   25:invokespecial   #31  <Method void JTextArea()>
        //   14   28:putfield        #33  <Field JTextArea _message>
            initComponents();
        //   15   31:aload_0         
        //   16   32:invokespecial   #36  <Method void initComponents()>
        //   17   35:return          
        }
    }

    class Animation extends Thread
    {

        private void animateVertically(int posx, int startY, int endY)
            throws InterruptedException
        {
            _single.setLocation(posx, startY);
        //    0    0:aload_0         
        //    1    1:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //    2    4:iload_1         
        //    3    5:iload_2         
        //    4    6:invokevirtual   #34  <Method void testFloat$ToolTipSingle.setLocation(int, int)>
            if(endY < startY)
        //*   5    9:iload_3         
        //*   6   10:iload_2         
        //*   7   11:icmpge          62
            {
                for(int i = startY; i > endY; i -= _step)
        //*   8   14:iload_2         
        //*   9   15:istore          4
        //*  10   17:goto            53
                {
                    _single.setLocation(posx, i);
        //   11   20:aload_0         
        //   12   21:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //   13   24:iload_1         
        //   14   25:iload           4
        //   15   27:invokevirtual   #34  <Method void testFloat$ToolTipSingle.setLocation(int, int)>
                    Thread.sleep(_stepTime);
        //   16   30:aload_0         
        //   17   31:getfield        #13  <Field testFloat this$0>
        //   18   34:invokestatic    #40  <Method int testFloat.access$3(testFloat)>
        //   19   37:i2l             
        //   20   38:invokestatic    #44  <Method void Thread.sleep(long)>
                }

        //   21   41:iload           4
        //   22   43:aload_0         
        //   23   44:getfield        #13  <Field testFloat this$0>
        //   24   47:invokestatic    #47  <Method int testFloat.access$4(testFloat)>
        //   25   50:isub            
        //   26   51:istore          4
        //   27   53:iload           4
        //   28   55:iload_3         
        //   29   56:icmpgt          20
            } else
        //*  30   59:goto            107
            {
                for(int i = startY; i < endY; i += _step)
        //*  31   62:iload_2         
        //*  32   63:istore          4
        //*  33   65:goto            101
                {
                    _single.setLocation(posx, i);
        //   34   68:aload_0         
        //   35   69:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //   36   72:iload_1         
        //   37   73:iload           4
        //   38   75:invokevirtual   #34  <Method void testFloat$ToolTipSingle.setLocation(int, int)>
                    Thread.sleep(_stepTime);
        //   39   78:aload_0         
        //   40   79:getfield        #13  <Field testFloat this$0>
        //   41   82:invokestatic    #40  <Method int testFloat.access$3(testFloat)>
        //   42   85:i2l             
        //   43   86:invokestatic    #44  <Method void Thread.sleep(long)>
                }

        //   44   89:iload           4
        //   45   91:aload_0         
        //   46   92:getfield        #13  <Field testFloat this$0>
        //   47   95:invokestatic    #47  <Method int testFloat.access$4(testFloat)>
        //   48   98:iadd            
        //   49   99:istore          4
        //   50  101:iload           4
        //   51  103:iload_3         
        //   52  104:icmplt          68
            }
            _single.setLocation(posx, endY);
        //   53  107:aload_0         
        //   54  108:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //   55  111:iload_1         
        //   56  112:iload_3         
        //   57  113:invokevirtual   #34  <Method void testFloat$ToolTipSingle.setLocation(int, int)>
        //   58  116:return          
        }

        public void run()
        {
            try
            {
                boolean animate = true;
        //    0    0:iconst_1        
        //    1    1:istore_1        
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //    2    2:invokestatic    #59  <Method GraphicsEnvironment GraphicsEnvironment.getLocalGraphicsEnvironment()>
        //    3    5:astore_2        
                Rectangle screenRect = ge.getMaximumWindowBounds();
        //    4    6:aload_2         
        //    5    7:invokevirtual   #63  <Method Rectangle GraphicsEnvironment.getMaximumWindowBounds()>
        //    6   10:astore_3        
                int screenHeight = screenRect.height;
        //    7   11:aload_3         
        //    8   12:getfield        #68  <Field int Rectangle.height>
        //    9   15:istore          4
                if(screenRect.y > 0)
        //*  10   17:aload_3         
        //*  11   18:getfield        #71  <Field int Rectangle.y>
        //*  12   21:ifle            26
                    animate = false;
        //   13   24:iconst_0        
        //   14   25:istore_1        
                _maxToolTipSceen = screenHeight / _height;
        //   15   26:aload_0         
        //   16   27:getfield        #13  <Field testFloat this$0>
        //   17   30:iload           4
        //   18   32:aload_0         
        //   19   33:getfield        #13  <Field testFloat this$0>
        //   20   36:invokestatic    #74  <Method int testFloat.access$1(testFloat)>
        //   21   39:idiv            
        //   22   40:invokestatic    #78  <Method void testFloat.access$5(testFloat, int)>
                int posx = screenRect.width - _width - 1;
        //   23   43:aload_3         
        //   24   44:getfield        #81  <Field int Rectangle.width>
        //   25   47:aload_0         
        //   26   48:getfield        #13  <Field testFloat this$0>
        //   27   51:invokestatic    #84  <Method int testFloat.access$0(testFloat)>
        //   28   54:isub            
        //   29   55:iconst_1        
        //   30   56:isub            
        //   31   57:istore          7
                _single.setLocation(posx, screenHeight);
        //   32   59:aload_0         
        //   33   60:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //   34   63:iload           7
        //   35   65:iload           4
        //   36   67:invokevirtual   #34  <Method void testFloat$ToolTipSingle.setLocation(int, int)>
                _single.setVisible(true);
        //   37   70:aload_0         
        //   38   71:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //   39   74:iconst_1        
        //   40   75:invokevirtual   #88  <Method void testFloat$ToolTipSingle.setVisible(boolean)>
                if(_useTop)
        //*  41   78:aload_0         
        //*  42   79:getfield        #13  <Field testFloat this$0>
        //*  43   82:getfield        #92  <Field boolean testFloat._useTop>
        //*  44   85:ifeq            96
                    _single.setAlwaysOnTop(true);
        //   45   88:aload_0         
        //   46   89:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //   47   92:iconst_1        
        //   48   93:invokevirtual   #95  <Method void testFloat$ToolTipSingle.setAlwaysOnTop(boolean)>
                int startYPosition;
                int stopYPosition;
                if(animate)
        //*  49   96:iload_1         
        //*  50   97:ifeq            170
                {
                    startYPosition = screenHeight;
        //   51  100:iload           4
        //   52  102:istore          5
                    stopYPosition = startYPosition - _height - 1;
        //   53  104:iload           5
        //   54  106:aload_0         
        //   55  107:getfield        #13  <Field testFloat this$0>
        //   56  110:invokestatic    #74  <Method int testFloat.access$1(testFloat)>
        //   57  113:isub            
        //   58  114:iconst_1        
        //   59  115:isub            
        //   60  116:istore          6
                    if(_countOfToolTip > 0)
        //*  61  118:aload_0         
        //*  62  119:getfield        #13  <Field testFloat this$0>
        //*  63  122:invokestatic    #98  <Method int testFloat.access$6(testFloat)>
        //*  64  125:ifle            159
                        stopYPosition -= (_maxToolTip % _maxToolTipSceen) * _height;
        //   65  128:iload           6
        //   66  130:aload_0         
        //   67  131:getfield        #13  <Field testFloat this$0>
        //   68  134:invokestatic    #101 <Method int testFloat.access$7(testFloat)>
        //   69  137:aload_0         
        //   70  138:getfield        #13  <Field testFloat this$0>
        //   71  141:invokestatic    #104 <Method int testFloat.access$8(testFloat)>
        //   72  144:irem            
        //   73  145:aload_0         
        //   74  146:getfield        #13  <Field testFloat this$0>
        //   75  149:invokestatic    #74  <Method int testFloat.access$1(testFloat)>
        //   76  152:imul            
        //   77  153:isub            
        //   78  154:istore          6
                    else
        //*  79  156:goto            239
                        _maxToolTip = 0;
        //   80  159:aload_0         
        //   81  160:getfield        #13  <Field testFloat this$0>
        //   82  163:iconst_0        
        //   83  164:invokestatic    #107 <Method void testFloat.access$9(testFloat, int)>
                } else
        //*  84  167:goto            239
                {
                    startYPosition = screenRect.y - _height;
        //   85  170:aload_3         
        //   86  171:getfield        #71  <Field int Rectangle.y>
        //   87  174:aload_0         
        //   88  175:getfield        #13  <Field testFloat this$0>
        //   89  178:invokestatic    #74  <Method int testFloat.access$1(testFloat)>
        //   90  181:isub            
        //   91  182:istore          5
                    stopYPosition = screenRect.y;
        //   92  184:aload_3         
        //   93  185:getfield        #71  <Field int Rectangle.y>
        //   94  188:istore          6
                    if(_countOfToolTip > 0)
        //*  95  190:aload_0         
        //*  96  191:getfield        #13  <Field testFloat this$0>
        //*  97  194:invokestatic    #98  <Method int testFloat.access$6(testFloat)>
        //*  98  197:ifle            231
                        stopYPosition += (_maxToolTip % _maxToolTipSceen) * _height;
        //   99  200:iload           6
        //  100  202:aload_0         
        //  101  203:getfield        #13  <Field testFloat this$0>
        //  102  206:invokestatic    #101 <Method int testFloat.access$7(testFloat)>
        //  103  209:aload_0         
        //  104  210:getfield        #13  <Field testFloat this$0>
        //  105  213:invokestatic    #104 <Method int testFloat.access$8(testFloat)>
        //  106  216:irem            
        //  107  217:aload_0         
        //  108  218:getfield        #13  <Field testFloat this$0>
        //  109  221:invokestatic    #74  <Method int testFloat.access$1(testFloat)>
        //  110  224:imul            
        //  111  225:iadd            
        //  112  226:istore          6
                    else
        //* 113  228:goto            239
                        _maxToolTip = 0;
        //  114  231:aload_0         
        //  115  232:getfield        #13  <Field testFloat this$0>
        //  116  235:iconst_0        
        //  117  236:invokestatic    #107 <Method void testFloat.access$9(testFloat, int)>
                }
                _countOfToolTip++;
        //  118  239:aload_0         
        //  119  240:getfield        #13  <Field testFloat this$0>
        //  120  243:dup             
        //  121  244:invokestatic    #98  <Method int testFloat.access$6(testFloat)>
        //  122  247:iconst_1        
        //  123  248:iadd            
        //  124  249:invokestatic    #110 <Method void testFloat.access$10(testFloat, int)>
                _maxToolTip++;
        //  125  252:aload_0         
        //  126  253:getfield        #13  <Field testFloat this$0>
        //  127  256:dup             
        //  128  257:invokestatic    #101 <Method int testFloat.access$7(testFloat)>
        //  129  260:iconst_1        
        //  130  261:iadd            
        //  131  262:invokestatic    #107 <Method void testFloat.access$9(testFloat, int)>
                animateVertically(posx, startYPosition, stopYPosition);
        //  132  265:aload_0         
        //  133  266:iload           7
        //  134  268:iload           5
        //  135  270:iload           6
        //  136  272:invokespecial   #112 <Method void animateVertically(int, int, int)>
                Thread.sleep(_displayTime);
        //  137  275:aload_0         
        //  138  276:getfield        #13  <Field testFloat this$0>
        //  139  279:invokestatic    #115 <Method int testFloat.access$11(testFloat)>
        //  140  282:i2l             
        //  141  283:invokestatic    #44  <Method void Thread.sleep(long)>
                animateVertically(posx, stopYPosition, startYPosition);
        //  142  286:aload_0         
        //  143  287:iload           7
        //  144  289:iload           6
        //  145  291:iload           5
        //  146  293:invokespecial   #112 <Method void animateVertically(int, int, int)>
                _countOfToolTip--;
        //  147  296:aload_0         
        //  148  297:getfield        #13  <Field testFloat this$0>
        //  149  300:dup             
        //  150  301:invokestatic    #98  <Method int testFloat.access$6(testFloat)>
        //  151  304:iconst_1        
        //  152  305:isub            
        //  153  306:invokestatic    #110 <Method void testFloat.access$10(testFloat, int)>
                _single.setVisible(false);
        //  154  309:aload_0         
        //  155  310:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //  156  313:iconst_0        
        //  157  314:invokevirtual   #88  <Method void testFloat$ToolTipSingle.setVisible(boolean)>
                _single.dispose();
        //  158  317:aload_0         
        //  159  318:getfield        #18  <Field testFloat$ToolTipSingle _single>
        //  160  321:invokevirtual   #118 <Method void testFloat$ToolTipSingle.dispose()>
            }
        //* 161  324:goto            337
            catch(Exception e)
        //* 162  327:astore_1        
            {
                throw new RuntimeException(e);
        //  163  328:new             #120 <Class RuntimeException>
        //  164  331:dup             
        //  165  332:aload_1         
        //  166  333:invokespecial   #123 <Method void RuntimeException(Throwable)>
        //  167  336:athrow          
            }
        //  168  337:return          
        }

        ToolTipSingle _single;
        final testFloat this$0;

        public Animation(ToolTipSingle single)
        {
            this$0 = testFloat.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #13  <Field testFloat this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #16  <Method void Thread()>
            _single = single;
        //    5    9:aload_0         
        //    6   10:aload_2         
        //    7   11:putfield        #18  <Field testFloat$ToolTipSingle _single>
        //    8   14:return          
        }
    }


    public testFloat()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #30  <Method void Object()>
        _width = 300;
    //    2    4:aload_0         
    //    3    5:sipush          300
    //    4    8:putfield        #32  <Field int _width>
        _height = 100;
    //    5   11:aload_0         
    //    6   12:bipush          100
    //    7   14:putfield        #34  <Field int _height>
        _step = 30;
    //    8   17:aload_0         
    //    9   18:bipush          30
    //   10   20:putfield        #36  <Field int _step>
        _stepTime = 30;
    //   11   23:aload_0         
    //   12   24:bipush          30
    //   13   26:putfield        #38  <Field int _stepTime>
        _displayTime = 6000;
    //   14   29:aload_0         
    //   15   30:sipush          6000
    //   16   33:putfield        #40  <Field int _displayTime>
        _countOfToolTip = 0;
    //   17   36:aload_0         
    //   18   37:iconst_0        
    //   19   38:putfield        #42  <Field int _countOfToolTip>
        _maxToolTip = 0;
    //   20   41:aload_0         
    //   21   42:iconst_0        
    //   22   43:putfield        #44  <Field int _maxToolTip>
        _useTop = true;
    //   23   46:aload_0         
    //   24   47:iconst_1        
    //   25   48:putfield        #46  <Field boolean _useTop>
        _font = new Font("\u5B8B\u4F53", 0, 12);
    //   26   51:aload_0         
    //   27   52:new             #48  <Class Font>
    //   28   55:dup             
    //   29   56:ldc1            #50  <String "\u5B8B\u4F53">
    //   30   58:iconst_0        
    //   31   59:bipush          12
    //   32   61:invokespecial   #53  <Method void Font(String, int, int)>
    //   33   64:putfield        #55  <Field Font _font>
        _bgColor = new Color(255, 255, 225);
    //   34   67:aload_0         
    //   35   68:new             #57  <Class Color>
    //   36   71:dup             
    //   37   72:sipush          255
    //   38   75:sipush          255
    //   39   78:sipush          225
    //   40   81:invokespecial   #60  <Method void Color(int, int, int)>
    //   41   84:putfield        #62  <Field Color _bgColor>
        _border = Color.BLACK;
    //   42   87:aload_0         
    //   43   88:getstatic       #65  <Field Color Color.BLACK>
    //   44   91:putfield        #67  <Field Color _border>
        _messageColor = Color.BLACK;
    //   45   94:aload_0         
    //   46   95:getstatic       #65  <Field Color Color.BLACK>
    //   47   98:putfield        #69  <Field Color _messageColor>
        _useTop = true;
    //   48  101:aload_0         
    //   49  102:iconst_1        
    //   50  103:putfield        #46  <Field boolean _useTop>
        try
        {
            javax/swing/JWindow.getMethod("setAlwaysOnTop", new Class[] {
                java/lang/Boolean
            });
    //   51  106:ldc1            #71  <Class JWindow>
    //   52  108:ldc1            #73  <String "setAlwaysOnTop">
    //   53  110:iconst_1        
    //   54  111:anewarray       Class[]
    //   55  114:dup             
    //   56  115:iconst_0        
    //   57  116:ldc1            #77  <Class Boolean>
    //   58  118:aastore         
    //   59  119:invokevirtual   #81  <Method java.lang.reflect.Method Class.getMethod(String, Class[])>
    //   60  122:pop             
        }
    //*  61  123:goto            132
        catch(Exception e)
    //*  62  126:astore_1        
        {
            _useTop = false;
    //   63  127:aload_0         
    //   64  128:iconst_0        
    //   65  129:putfield        #46  <Field boolean _useTop>
        }
    //   66  132:return          
    }

    public void setToolTip(Icon icon, String msg)
    {
        ToolTipSingle single = new ToolTipSingle();
    //    0    0:new             #93  <Class testFloat$ToolTipSingle>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #96  <Method void testFloat$ToolTipSingle(testFloat)>
    //    4    8:astore_3        
        if(icon != null)
    //*   5    9:aload_1         
    //*   6   10:ifnull          21
            single._iconLabel.setIcon(icon);
    //    7   13:aload_3         
    //    8   14:invokestatic    #100 <Method JLabel testFloat$ToolTipSingle.access$0(testFloat$ToolTipSingle)>
    //    9   17:aload_1         
    //   10   18:invokevirtual   #106 <Method void JLabel.setIcon(Icon)>
        single._message.setText(msg);
    //   11   21:aload_3         
    //   12   22:invokestatic    #110 <Method JTextArea testFloat$ToolTipSingle.access$1(testFloat$ToolTipSingle)>
    //   13   25:aload_2         
    //   14   26:invokevirtual   #116 <Method void JTextArea.setText(String)>
        single.animate();
    //   15   29:aload_3         
    //   16   30:invokevirtual   #119 <Method void testFloat$ToolTipSingle.animate()>
    //   17   33:return          
    }

    public void setToolTip(String msg)
    {
        setToolTip(null, msg);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:aload_1         
    //    3    3:invokevirtual   #127 <Method void setToolTip(Icon, String)>
    //    4    6:return          
    }

    public Font getMessageFont()
    {
        return _font;
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field Font _font>
    //    2    4:areturn         
    }

    public void setMessageFont(Font font)
    {
        _font = font;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #55  <Field Font _font>
    //    3    5:return          
    }

    public Color getBorderColor()
    {
        return _border;
    //    0    0:aload_0         
    //    1    1:getfield        #67  <Field Color _border>
    //    2    4:areturn         
    }

    public void setBorderColor(Color borderColor)
    {
        _border = borderColor;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #67  <Field Color _border>
    //    3    5:return          
    }

    public int getDisplayTime()
    {
        return _displayTime;
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field int _displayTime>
    //    2    4:ireturn         
    }

    public void setDisplayTime(int displayTime)
    {
        _displayTime = displayTime;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #40  <Field int _displayTime>
    //    3    5:return          
    }

    public int getGap()
    {
        return _gap;
    //    0    0:aload_0         
    //    1    1:getfield        #145 <Field int _gap>
    //    2    4:ireturn         
    }

    public void setGap(int gap)
    {
        _gap = gap;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #145 <Field int _gap>
    //    3    5:return          
    }

    public Color getMessageColor()
    {
        return _messageColor;
    //    0    0:aload_0         
    //    1    1:getfield        #69  <Field Color _messageColor>
    //    2    4:areturn         
    }

    public void setMessageColor(Color messageColor)
    {
        _messageColor = messageColor;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #69  <Field Color _messageColor>
    //    3    5:return          
    }

    public int getStep()
    {
        return _step;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field int _step>
    //    2    4:ireturn         
    }

    public void setStep(int _step)
    {
        this._step = _step;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #36  <Field int _step>
    //    3    5:return          
    }

    public int getStepTime()
    {
        return _stepTime;
    //    0    0:aload_0         
    //    1    1:getfield        #38  <Field int _stepTime>
    //    2    4:ireturn         
    }

    public void setStepTime(int _stepTime)
    {
        this._stepTime = _stepTime;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #38  <Field int _stepTime>
    //    3    5:return          
    }

    public Color getBackgroundColor()
    {
        return _bgColor;
    //    0    0:aload_0         
    //    1    1:getfield        #62  <Field Color _bgColor>
    //    2    4:areturn         
    }

    public void setBackgroundColor(Color bgColor)
    {
        _bgColor = bgColor;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #62  <Field Color _bgColor>
    //    3    5:return          
    }

    public int getHeight()
    {
        return _height;
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field int _height>
    //    2    4:ireturn         
    }

    public void setHeight(int height)
    {
        _height = height;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #34  <Field int _height>
    //    3    5:return          
    }

    public int getWidth()
    {
        return _width;
    //    0    0:aload_0         
    //    1    1:getfield        #32  <Field int _width>
    //    2    4:ireturn         
    }

    public void setWidth(int width)
    {
        _width = width;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #32  <Field int _width>
    //    3    5:return          
    }

    public static void main(String args[])
    {
        testFloat tip = new testFloat();
    //    0    0:new             #2   <Class testFloat>
    //    1    3:dup             
    //    2    4:invokespecial   #166 <Method void testFloat()>
    //    3    7:astore_1        
        tip.setToolTip(new ImageIcon("E:\\RBACreator\\RMiner0.1\\src\\images\\ico_max.gif"), "\u201C\u7A0B\u5E8F\u5458\u201D\u5C31\u662F\u7279\u6307\u8D8A\u5199\u7A0B\u5E8F\u8EAB\u6750\u8D8A\u201C\u5706\u201D\u90A3\u7FA4\u4EBA -- cping1982");
    //    4    8:aload_1         
    //    5    9:new             #168 <Class ImageIcon>
    //    6   12:dup             
    //    7   13:ldc1            #170 <String "E:\\RBACreator\\RMiner0.1\\src\\images\\ico_max.gif">
    //    8   15:invokespecial   #172 <Method void ImageIcon(String)>
    //    9   18:ldc1            #174 <String "\u201C\u7A0B\u5E8F\u5458\u201D\u5C31\u662F\u7279\u6307\u8D8A\u5199\u7A0B\u5E8F\u8EAB\u6750\u8D8A\u201C\u5706\u201D\u90A3\u7FA4\u4EBA -- cping1982">
    //   10   20:invokevirtual   #127 <Method void setToolTip(Icon, String)>
    //   11   23:return          
    }

    private int _width;
    private int _height;
    private int _step;
    private int _stepTime;
    private int _displayTime;
    private int _countOfToolTip;
    private int _maxToolTip;
    private int _maxToolTipSceen;
    private Font _font;
    private Color _bgColor;
    private Color _border;
    private Color _messageColor;
    int _gap;
    boolean _useTop;
    static Class class$0;
    static Class class$1;


/*
    static int access$0(testFloat testfloat)
    {
        return testfloat._width;
    //    0    0:aload_0         
    //    1    1:getfield        #32  <Field int _width>
    //    2    4:ireturn         
    }

*/


/*
    static int access$1(testFloat testfloat)
    {
        return testfloat._height;
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field int _height>
    //    2    4:ireturn         
    }

*/


/*
    static Color access$2(testFloat testfloat)
    {
        return testfloat._bgColor;
    //    0    0:aload_0         
    //    1    1:getfield        #62  <Field Color _bgColor>
    //    2    4:areturn         
    }

*/


/*
    static int access$3(testFloat testfloat)
    {
        return testfloat._stepTime;
    //    0    0:aload_0         
    //    1    1:getfield        #38  <Field int _stepTime>
    //    2    4:ireturn         
    }

*/


/*
    static int access$4(testFloat testfloat)
    {
        return testfloat._step;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field int _step>
    //    2    4:ireturn         
    }

*/


/*
    static void access$5(testFloat testfloat, int i)
    {
        testfloat._maxToolTipSceen = i;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #187 <Field int _maxToolTipSceen>
        return;
    //    3    5:return          
    }

*/


/*
    static int access$6(testFloat testfloat)
    {
        return testfloat._countOfToolTip;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field int _countOfToolTip>
    //    2    4:ireturn         
    }

*/


/*
    static int access$7(testFloat testfloat)
    {
        return testfloat._maxToolTip;
    //    0    0:aload_0         
    //    1    1:getfield        #44  <Field int _maxToolTip>
    //    2    4:ireturn         
    }

*/


/*
    static int access$8(testFloat testfloat)
    {
        return testfloat._maxToolTipSceen;
    //    0    0:aload_0         
    //    1    1:getfield        #187 <Field int _maxToolTipSceen>
    //    2    4:ireturn         
    }

*/


/*
    static void access$9(testFloat testfloat, int i)
    {
        testfloat._maxToolTip = i;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #44  <Field int _maxToolTip>
        return;
    //    3    5:return          
    }

*/


/*
    static void access$10(testFloat testfloat, int i)
    {
        testfloat._countOfToolTip = i;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #42  <Field int _countOfToolTip>
        return;
    //    3    5:return          
    }

*/


/*
    static int access$11(testFloat testfloat)
    {
        return testfloat._displayTime;
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field int _displayTime>
    //    2    4:ireturn         
    }

*/
}

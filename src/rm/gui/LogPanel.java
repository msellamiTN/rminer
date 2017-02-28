// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   LogPanel.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Referenced classes of package rm.gui:
//            Logger, TaskLogger, RMinerTaskMonitor

public class LogPanel extends JPanel
    implements Logger, TaskLogger
{

    public LogPanel()
    {
        this(null, false, false, true);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:iconst_0        
    //    3    3:iconst_0        
    //    4    4:iconst_1        
    //    5    5:invokespecial   #29  <Method void LogPanel(RMinerTaskMonitor, boolean, boolean, boolean)>
    //    6    8:return          
    }

    public LogPanel(RMinerTaskMonitor tm)
    {
        this(tm, true, false, true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_1        
    //    3    3:iconst_0        
    //    4    4:iconst_1        
    //    5    5:invokespecial   #29  <Method void LogPanel(RMinerTaskMonitor, boolean, boolean, boolean)>
    //    6    8:return          
    }

    public LogPanel(RMinerTaskMonitor tm, boolean logHidden)
    {
        this(tm, logHidden, false, true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_2         
    //    3    3:iconst_0        
    //    4    4:iconst_1        
    //    5    5:invokespecial   #29  <Method void LogPanel(RMinerTaskMonitor, boolean, boolean, boolean)>
    //    6    8:return          
    }

    public LogPanel(RMinerTaskMonitor tm, boolean logHidden, boolean statusHidden, boolean titledBorder)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #39  <Method void JPanel()>
        m_StatusLab = new JLabel("OK");
    //    2    4:aload_0         
    //    3    5:new             #41  <Class JLabel>
    //    4    8:dup             
    //    5    9:ldc1            #43  <String "OK">
    //    6   11:invokespecial   #46  <Method void JLabel(String)>
    //    7   14:putfield        #48  <Field JLabel m_StatusLab>
        m_LogText = new JTextArea(4, 20);
    //    8   17:aload_0         
    //    9   18:new             #50  <Class JTextArea>
    //   10   21:dup             
    //   11   22:iconst_4        
    //   12   23:bipush          20
    //   13   25:invokespecial   #53  <Method void JTextArea(int, int)>
    //   14   28:putfield        #55  <Field JTextArea m_LogText>
        m_logButton = new JButton("Log");
    //   15   31:aload_0         
    //   16   32:new             #57  <Class JButton>
    //   17   35:dup             
    //   18   36:ldc1            #59  <String "Log">
    //   19   38:invokespecial   #60  <Method void JButton(String)>
    //   20   41:putfield        #62  <Field JButton m_logButton>
        m_First = true;
    //   21   44:aload_0         
    //   22   45:iconst_1        
    //   23   46:putfield        #64  <Field boolean m_First>
        m_TaskMonitor = null;
    //   24   49:aload_0         
    //   25   50:aconst_null     
    //   26   51:putfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
        m_TaskMonitor = tm;
    //   27   54:aload_0         
    //   28   55:aload_1         
    //   29   56:putfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
        m_LogText.setEditable(false);
    //   30   59:aload_0         
    //   31   60:getfield        #55  <Field JTextArea m_LogText>
    //   32   63:iconst_0        
    //   33   64:invokevirtual   #70  <Method void JTextArea.setEditable(boolean)>
        m_LogText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //   34   67:aload_0         
    //   35   68:getfield        #55  <Field JTextArea m_LogText>
    //   36   71:iconst_5        
    //   37   72:iconst_5        
    //   38   73:iconst_5        
    //   39   74:iconst_5        
    //   40   75:invokestatic    #76  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   41   78:invokevirtual   #80  <Method void JTextArea.setBorder(javax.swing.border.Border)>
        m_StatusLab.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Status"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
    //   42   81:aload_0         
    //   43   82:getfield        #48  <Field JLabel m_StatusLab>
    //   44   85:ldc1            #82  <String "Status">
    //   45   87:invokestatic    #86  <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   46   90:iconst_0        
    //   47   91:iconst_5        
    //   48   92:iconst_5        
    //   49   93:iconst_5        
    //   50   94:invokestatic    #76  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   51   97:invokestatic    #90  <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //   52  100:invokevirtual   #91  <Method void JLabel.setBorder(javax.swing.border.Border)>
        JScrollPane js = new JScrollPane(m_LogText);
    //   53  103:new             #93  <Class JScrollPane>
    //   54  106:dup             
    //   55  107:aload_0         
    //   56  108:getfield        #55  <Field JTextArea m_LogText>
    //   57  111:invokespecial   #96  <Method void JScrollPane(java.awt.Component)>
    //   58  114:astore          5
        js.getViewport().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e)
            {
                JViewport vp = (JViewport)e.getSource();
            //    0    0:aload_1         
            //    1    1:invokevirtual   #30  <Method Object ChangeEvent.getSource()>
            //    2    4:checkcast       #32  <Class JViewport>
            //    3    7:astore_2        
                int h = vp.getViewSize().height;
            //    4    8:aload_2         
            //    5    9:invokevirtual   #36  <Method Dimension JViewport.getViewSize()>
            //    6   12:getfield        #41  <Field int Dimension.height>
            //    7   15:istore_3        
                if(h != lastHeight)
            //*   8   16:iload_3         
            //*   9   17:aload_0         
            //*  10   18:getfield        #43  <Field int lastHeight>
            //*  11   21:icmpeq          54
                {
                    lastHeight = h;
            //   12   24:aload_0         
            //   13   25:iload_3         
            //   14   26:putfield        #43  <Field int lastHeight>
                    int x = h - vp.getExtentSize().height;
            //   15   29:iload_3         
            //   16   30:aload_2         
            //   17   31:invokevirtual   #46  <Method Dimension JViewport.getExtentSize()>
            //   18   34:getfield        #41  <Field int Dimension.height>
            //   19   37:isub            
            //   20   38:istore          4
                    vp.setViewPosition(new Point(0, x));
            //   21   40:aload_2         
            //   22   41:new             #48  <Class Point>
            //   23   44:dup             
            //   24   45:iconst_0        
            //   25   46:iload           4
            //   26   48:invokespecial   #51  <Method void Point(int, int)>
            //   27   51:invokevirtual   #55  <Method void JViewport.setViewPosition(Point)>
                }
            //   28   54:return          
            }

            private int lastHeight;
            final LogPanel this$0;

            
            {
                this$0 = LogPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field LogPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #18  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   59  116:aload           5
    //   60  118:invokevirtual   #100 <Method JViewport JScrollPane.getViewport()>
    //   61  121:new             #102 <Class LogPanel$1>
    //   62  124:dup             
    //   63  125:aload_0         
    //   64  126:invokespecial   #105 <Method void LogPanel$1(LogPanel)>
    //   65  129:invokevirtual   #111 <Method void JViewport.addChangeListener(ChangeListener)>
        if(logHidden)
    //*  66  132:iload_2         
    //*  67  133:ifeq            387
        {
            final JFrame jf = new JFrame("Log");
    //   68  136:new             #113 <Class JFrame>
    //   69  139:dup             
    //   70  140:ldc1            #59  <String "Log">
    //   71  142:invokespecial   #114 <Method void JFrame(String)>
    //   72  145:astore          6
            jf.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    jf.setVisible(false);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field JFrame val$jf>
                //    2    4:iconst_0        
                //    3    5:invokevirtual   #30  <Method void JFrame.setVisible(boolean)>
                //    4    8:return          
                }

                final LogPanel this$0;
                private final JFrame val$jf;

            
            {
                this$0 = LogPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field LogPanel this$0>
                jf = jframe;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field JFrame val$jf>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void WindowAdapter()>
            //    8   14:return          
            }
            }
);
    //   73  147:aload           6
    //   74  149:new             #116 <Class LogPanel$2>
    //   75  152:dup             
    //   76  153:aload_0         
    //   77  154:aload           6
    //   78  156:invokespecial   #119 <Method void LogPanel$2(LogPanel, JFrame)>
    //   79  159:invokevirtual   #123 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.getContentPane().setLayout(new BorderLayout());
    //   80  162:aload           6
    //   81  164:invokevirtual   #127 <Method Container JFrame.getContentPane()>
    //   82  167:new             #129 <Class BorderLayout>
    //   83  170:dup             
    //   84  171:invokespecial   #130 <Method void BorderLayout()>
    //   85  174:invokevirtual   #136 <Method void Container.setLayout(java.awt.LayoutManager)>
            jf.getContentPane().add(js, "Center");
    //   86  177:aload           6
    //   87  179:invokevirtual   #127 <Method Container JFrame.getContentPane()>
    //   88  182:aload           5
    //   89  184:ldc1            #138 <String "Center">
    //   90  186:invokevirtual   #142 <Method void Container.add(java.awt.Component, Object)>
            jf.pack();
    //   91  189:aload           6
    //   92  191:invokevirtual   #145 <Method void JFrame.pack()>
            jf.setSize(450, 350);
    //   93  194:aload           6
    //   94  196:sipush          450
    //   95  199:sipush          350
    //   96  202:invokevirtual   #148 <Method void JFrame.setSize(int, int)>
            m_logButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    jf.setVisible(true);
                //    0    0:aload_0         
                //    1    1:getfield        #17  <Field JFrame val$jf>
                //    2    4:iconst_1        
                //    3    5:invokevirtual   #32  <Method void JFrame.setVisible(boolean)>
                //    4    8:return          
                }

                final LogPanel this$0;
                private final JFrame val$jf;

            
            {
                this$0 = LogPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field LogPanel this$0>
                jf = jframe;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field JFrame val$jf>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
);
    //   97  205:aload_0         
    //   98  206:getfield        #62  <Field JButton m_logButton>
    //   99  209:new             #150 <Class LogPanel$3>
    //  100  212:dup             
    //  101  213:aload_0         
    //  102  214:aload           6
    //  103  216:invokespecial   #151 <Method void LogPanel$3(LogPanel, JFrame)>
    //  104  219:invokevirtual   #155 <Method void JButton.addActionListener(ActionListener)>
            setLayout(new BorderLayout());
    //  105  222:aload_0         
    //  106  223:new             #129 <Class BorderLayout>
    //  107  226:dup             
    //  108  227:invokespecial   #130 <Method void BorderLayout()>
    //  109  230:invokevirtual   #156 <Method void setLayout(java.awt.LayoutManager)>
            JPanel logButPanel = new JPanel();
    //  110  233:new             #4   <Class JPanel>
    //  111  236:dup             
    //  112  237:invokespecial   #39  <Method void JPanel()>
    //  113  240:astore          7
            logButPanel.setLayout(new BorderLayout());
    //  114  242:aload           7
    //  115  244:new             #129 <Class BorderLayout>
    //  116  247:dup             
    //  117  248:invokespecial   #130 <Method void BorderLayout()>
    //  118  251:invokevirtual   #157 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            logButPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
    //  119  254:aload           7
    //  120  256:bipush          10
    //  121  258:iconst_5        
    //  122  259:bipush          10
    //  123  261:iconst_5        
    //  124  262:invokestatic    #76  <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  125  265:invokevirtual   #158 <Method void JPanel.setBorder(javax.swing.border.Border)>
            logButPanel.add(m_logButton, "Center");
    //  126  268:aload           7
    //  127  270:aload_0         
    //  128  271:getfield        #62  <Field JButton m_logButton>
    //  129  274:ldc1            #138 <String "Center">
    //  130  276:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
            JPanel p1 = new JPanel();
    //  131  279:new             #4   <Class JPanel>
    //  132  282:dup             
    //  133  283:invokespecial   #39  <Method void JPanel()>
    //  134  286:astore          8
            p1.setLayout(new BorderLayout());
    //  135  288:aload           8
    //  136  290:new             #129 <Class BorderLayout>
    //  137  293:dup             
    //  138  294:invokespecial   #130 <Method void BorderLayout()>
    //  139  297:invokevirtual   #157 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            p1.add(m_StatusLab, "Center");
    //  140  300:aload           8
    //  141  302:aload_0         
    //  142  303:getfield        #48  <Field JLabel m_StatusLab>
    //  143  306:ldc1            #138 <String "Center">
    //  144  308:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
            p1.add(logButPanel, "East");
    //  145  311:aload           8
    //  146  313:aload           7
    //  147  315:ldc1            #161 <String "East">
    //  148  317:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
            if(tm == null)
    //* 149  320:aload_1         
    //* 150  321:ifnonnull       335
            {
                add(p1, "South");
    //  151  324:aload_0         
    //  152  325:aload           8
    //  153  327:ldc1            #163 <String "South">
    //  154  329:invokevirtual   #164 <Method void add(java.awt.Component, Object)>
            } else
    //* 155  332:goto            527
            {
                JPanel p2 = new JPanel();
    //  156  335:new             #4   <Class JPanel>
    //  157  338:dup             
    //  158  339:invokespecial   #39  <Method void JPanel()>
    //  159  342:astore          9
                p2.setLayout(new BorderLayout());
    //  160  344:aload           9
    //  161  346:new             #129 <Class BorderLayout>
    //  162  349:dup             
    //  163  350:invokespecial   #130 <Method void BorderLayout()>
    //  164  353:invokevirtual   #157 <Method void JPanel.setLayout(java.awt.LayoutManager)>
                p2.add(p1, "Center");
    //  165  356:aload           9
    //  166  358:aload           8
    //  167  360:ldc1            #138 <String "Center">
    //  168  362:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
                p2.add(m_TaskMonitor, "East");
    //  169  365:aload           9
    //  170  367:aload_0         
    //  171  368:getfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
    //  172  371:ldc1            #161 <String "East">
    //  173  373:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
                add(p2, "South");
    //  174  376:aload_0         
    //  175  377:aload           9
    //  176  379:ldc1            #163 <String "South">
    //  177  381:invokevirtual   #164 <Method void add(java.awt.Component, Object)>
            }
        } else
    //* 178  384:goto            527
        {
            JPanel p1 = new JPanel();
    //  179  387:new             #4   <Class JPanel>
    //  180  390:dup             
    //  181  391:invokespecial   #39  <Method void JPanel()>
    //  182  394:astore          6
            if(titledBorder)
    //* 183  396:iload           4
    //* 184  398:ifeq            411
                p1.setBorder(BorderFactory.createTitledBorder("Log"));
    //  185  401:aload           6
    //  186  403:ldc1            #59  <String "Log">
    //  187  405:invokestatic    #86  <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  188  408:invokevirtual   #158 <Method void JPanel.setBorder(javax.swing.border.Border)>
            p1.setLayout(new BorderLayout());
    //  189  411:aload           6
    //  190  413:new             #129 <Class BorderLayout>
    //  191  416:dup             
    //  192  417:invokespecial   #130 <Method void BorderLayout()>
    //  193  420:invokevirtual   #157 <Method void JPanel.setLayout(java.awt.LayoutManager)>
            p1.add(js, "Center");
    //  194  423:aload           6
    //  195  425:aload           5
    //  196  427:ldc1            #138 <String "Center">
    //  197  429:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
            setLayout(new BorderLayout());
    //  198  432:aload_0         
    //  199  433:new             #129 <Class BorderLayout>
    //  200  436:dup             
    //  201  437:invokespecial   #130 <Method void BorderLayout()>
    //  202  440:invokevirtual   #156 <Method void setLayout(java.awt.LayoutManager)>
            add(p1, "Center");
    //  203  443:aload_0         
    //  204  444:aload           6
    //  205  446:ldc1            #138 <String "Center">
    //  206  448:invokevirtual   #164 <Method void add(java.awt.Component, Object)>
            if(tm == null)
    //* 207  451:aload_1         
    //* 208  452:ifnonnull       472
            {
                if(!statusHidden)
    //* 209  455:iload_3         
    //* 210  456:ifne            527
                    add(m_StatusLab, "South");
    //  211  459:aload_0         
    //  212  460:aload_0         
    //  213  461:getfield        #48  <Field JLabel m_StatusLab>
    //  214  464:ldc1            #163 <String "South">
    //  215  466:invokevirtual   #164 <Method void add(java.awt.Component, Object)>
            } else
    //* 216  469:goto            527
            if(!statusHidden)
    //* 217  472:iload_3         
    //* 218  473:ifne            527
            {
                JPanel p2 = new JPanel();
    //  219  476:new             #4   <Class JPanel>
    //  220  479:dup             
    //  221  480:invokespecial   #39  <Method void JPanel()>
    //  222  483:astore          7
                p2.setLayout(new BorderLayout());
    //  223  485:aload           7
    //  224  487:new             #129 <Class BorderLayout>
    //  225  490:dup             
    //  226  491:invokespecial   #130 <Method void BorderLayout()>
    //  227  494:invokevirtual   #157 <Method void JPanel.setLayout(java.awt.LayoutManager)>
                p2.add(m_StatusLab, "Center");
    //  228  497:aload           7
    //  229  499:aload_0         
    //  230  500:getfield        #48  <Field JLabel m_StatusLab>
    //  231  503:ldc1            #138 <String "Center">
    //  232  505:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
                p2.add(m_TaskMonitor, "East");
    //  233  508:aload           7
    //  234  510:aload_0         
    //  235  511:getfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
    //  236  514:ldc1            #161 <String "East">
    //  237  516:invokevirtual   #159 <Method void JPanel.add(java.awt.Component, Object)>
                add(p2, "South");
    //  238  519:aload_0         
    //  239  520:aload           7
    //  240  522:ldc1            #163 <String "South">
    //  241  524:invokevirtual   #164 <Method void add(java.awt.Component, Object)>
            }
        }
        addPopup();
    //  242  527:aload_0         
    //  243  528:invokespecial   #167 <Method void addPopup()>
    //  244  531:return          
    }

    private String printLong(long l)
    {
        String str = Long.toString(l);
    //    0    0:lload_1         
    //    1    1:invokestatic    #184 <Method String Long.toString(long)>
    //    2    4:astore          4
        String result = "";
    //    3    6:ldc1            #186 <String "">
    //    4    8:astore_3        
        int count = 0;
    //    5    9:iconst_0        
    //    6   10:istore          6
        for(int i = str.length() - 1; i >= 0; i--)
    //*   7   12:aload           4
    //*   8   14:invokevirtual   #192 <Method int String.length()>
    //*   9   17:iconst_1        
    //*  10   18:isub            
    //*  11   19:istore          5
    //*  12   21:goto            86
        {
            count++;
    //   13   24:iinc            6  1
            result = (new StringBuilder(String.valueOf(str.charAt(i)))).append(result).toString();
    //   14   27:new             #194 <Class StringBuilder>
    //   15   30:dup             
    //   16   31:aload           4
    //   17   33:iload           5
    //   18   35:invokevirtual   #198 <Method char String.charAt(int)>
    //   19   38:invokestatic    #202 <Method String String.valueOf(char)>
    //   20   41:invokespecial   #203 <Method void StringBuilder(String)>
    //   21   44:aload_3         
    //   22   45:invokevirtual   #207 <Method StringBuilder StringBuilder.append(String)>
    //   23   48:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   24   51:astore_3        
            if(count == 3 && i > 0)
    //*  25   52:iload           6
    //*  26   54:iconst_3        
    //*  27   55:icmpne          83
    //*  28   58:iload           5
    //*  29   60:ifle            83
            {
                result = (new StringBuilder(",")).append(result).toString();
    //   30   63:new             #194 <Class StringBuilder>
    //   31   66:dup             
    //   32   67:ldc1            #212 <String ",">
    //   33   69:invokespecial   #203 <Method void StringBuilder(String)>
    //   34   72:aload_3         
    //   35   73:invokevirtual   #207 <Method StringBuilder StringBuilder.append(String)>
    //   36   76:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   37   79:astore_3        
                count = 0;
    //   38   80:iconst_0        
    //   39   81:istore          6
            }
        }

    //   40   83:iinc            5  -1
    //   41   86:iload           5
    //   42   88:ifge            24
        return result;
    //   43   91:aload_3         
    //   44   92:areturn         
    }

    private void addPopup()
    {
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e)
            {
                if((e.getModifiers() & 0x10) != 16 || e.isAltDown())
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
            //*   2    4:bipush          16
            //*   3    6:iand            
            //*   4    7:bipush          16
            //*   5    9:icmpne          19
            //*   6   12:aload_1         
            //*   7   13:invokevirtual   #30  <Method boolean MouseEvent.isAltDown()>
            //*   8   16:ifeq            102
                {
                    JPopupMenu gcMenu = new JPopupMenu();
            //    9   19:new             #32  <Class JPopupMenu>
            //   10   22:dup             
            //   11   23:invokespecial   #33  <Method void JPopupMenu()>
            //   12   26:astore_2        
                    JMenuItem availMem = new JMenuItem("Memory information");
            //   13   27:new             #35  <Class JMenuItem>
            //   14   30:dup             
            //   15   31:ldc1            #37  <String "Memory information">
            //   16   33:invokespecial   #40  <Method void JMenuItem(String)>
            //   17   36:astore_3        
                    availMem.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent ee)
                        {
                            System.gc();
                        //    0    0:invokestatic    #27  <Method void System.gc()>
                            Runtime currR = Runtime.getRuntime();
                        //    1    3:invokestatic    #33  <Method Runtime Runtime.getRuntime()>
                        //    2    6:astore_2        
                            long freeM = currR.freeMemory();
                        //    3    7:aload_2         
                        //    4    8:invokevirtual   #37  <Method long Runtime.freeMemory()>
                        //    5   11:lstore_3        
                            long totalM = currR.totalMemory();
                        //    6   12:aload_2         
                        //    7   13:invokevirtual   #40  <Method long Runtime.totalMemory()>
                        //    8   16:lstore          5
                            long maxM = currR.maxMemory();
                        //    9   18:aload_2         
                        //   10   19:invokevirtual   #43  <Method long Runtime.maxMemory()>
                        //   11   22:lstore          7
                            logMessage((new StringBuilder("Memory (free/total/max.) in bytes: ")).append(printLong(freeM)).append(" / ").append(printLong(totalM)).append(" / ").append(printLong(maxM)).toString());
                        //   12   24:aload_0         
                        //   13   25:getfield        #13  <Field LogPanel$4 this$1>
                        //   14   28:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   15   31:new             #51  <Class StringBuilder>
                        //   16   34:dup             
                        //   17   35:ldc1            #53  <String "Memory (free/total/max.) in bytes: ">
                        //   18   37:invokespecial   #56  <Method void StringBuilder(String)>
                        //   19   40:aload_0         
                        //   20   41:getfield        #13  <Field LogPanel$4 this$1>
                        //   21   44:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   22   47:lload_3         
                        //   23   48:invokestatic    #61  <Method String LogPanel.access$0(LogPanel, long)>
                        //   24   51:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   25   54:ldc1            #67  <String " / ">
                        //   26   56:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   27   59:aload_0         
                        //   28   60:getfield        #13  <Field LogPanel$4 this$1>
                        //   29   63:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   30   66:lload           5
                        //   31   68:invokestatic    #61  <Method String LogPanel.access$0(LogPanel, long)>
                        //   32   71:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   33   74:ldc1            #67  <String " / ">
                        //   34   76:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   35   79:aload_0         
                        //   36   80:getfield        #13  <Field LogPanel$4 this$1>
                        //   37   83:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   38   86:lload           7
                        //   39   88:invokestatic    #61  <Method String LogPanel.access$0(LogPanel, long)>
                        //   40   91:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   41   94:invokevirtual   #71  <Method String StringBuilder.toString()>
                        //   42   97:invokevirtual   #74  <Method void LogPanel.logMessage(String)>
                            statusMessage((new StringBuilder("Memory (free/total/max.) in bytes: ")).append(printLong(freeM)).append(" / ").append(printLong(totalM)).append(" / ").append(printLong(maxM)).toString());
                        //   43  100:aload_0         
                        //   44  101:getfield        #13  <Field LogPanel$4 this$1>
                        //   45  104:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   46  107:new             #51  <Class StringBuilder>
                        //   47  110:dup             
                        //   48  111:ldc1            #53  <String "Memory (free/total/max.) in bytes: ">
                        //   49  113:invokespecial   #56  <Method void StringBuilder(String)>
                        //   50  116:aload_0         
                        //   51  117:getfield        #13  <Field LogPanel$4 this$1>
                        //   52  120:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   53  123:lload_3         
                        //   54  124:invokestatic    #61  <Method String LogPanel.access$0(LogPanel, long)>
                        //   55  127:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   56  130:ldc1            #67  <String " / ">
                        //   57  132:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   58  135:aload_0         
                        //   59  136:getfield        #13  <Field LogPanel$4 this$1>
                        //   60  139:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   61  142:lload           5
                        //   62  144:invokestatic    #61  <Method String LogPanel.access$0(LogPanel, long)>
                        //   63  147:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   64  150:ldc1            #67  <String " / ">
                        //   65  152:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   66  155:aload_0         
                        //   67  156:getfield        #13  <Field LogPanel$4 this$1>
                        //   68  159:invokestatic    #49  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //   69  162:lload           7
                        //   70  164:invokestatic    #61  <Method String LogPanel.access$0(LogPanel, long)>
                        //   71  167:invokevirtual   #65  <Method StringBuilder StringBuilder.append(String)>
                        //   72  170:invokevirtual   #71  <Method String StringBuilder.toString()>
                        //   73  173:invokevirtual   #77  <Method void LogPanel.statusMessage(String)>
                        //   74  176:return          
                        }

                        final _cls4 this$1;

                    
                    {
                        this$1 = _cls4.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #13  <Field LogPanel$4 this$1>
                        super();
                    //    3    5:aload_0         
                    //    4    6:invokespecial   #16  <Method void Object()>
                    //    5    9:return          
                    }
                    }
);
            //   18   37:aload_3         
            //   19   38:new             #42  <Class LogPanel$5>
            //   20   41:dup             
            //   21   42:aload_0         
            //   22   43:invokespecial   #45  <Method void LogPanel$5(LogPanel$4)>
            //   23   46:invokevirtual   #49  <Method void JMenuItem.addActionListener(ActionListener)>
                    gcMenu.add(availMem);
            //   24   49:aload_2         
            //   25   50:aload_3         
            //   26   51:invokevirtual   #53  <Method JMenuItem JPopupMenu.add(JMenuItem)>
            //   27   54:pop             
                    JMenuItem runGC = new JMenuItem("Run garbage collector");
            //   28   55:new             #35  <Class JMenuItem>
            //   29   58:dup             
            //   30   59:ldc1            #55  <String "Run garbage collector">
            //   31   61:invokespecial   #40  <Method void JMenuItem(String)>
            //   32   64:astore          4
                    runGC.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent ee)
                        {
                            statusMessage("Running garbage collector");
                        //    0    0:aload_0         
                        //    1    1:getfield        #13  <Field LogPanel$4 this$1>
                        //    2    4:invokestatic    #28  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //    3    7:ldc1            #30  <String "Running garbage collector">
                        //    4    9:invokevirtual   #36  <Method void LogPanel.statusMessage(String)>
                            System.gc();
                        //    5   12:invokestatic    #41  <Method void System.gc()>
                            statusMessage("OK");
                        //    6   15:aload_0         
                        //    7   16:getfield        #13  <Field LogPanel$4 this$1>
                        //    8   19:invokestatic    #28  <Method LogPanel LogPanel$4.access$0(LogPanel$4)>
                        //    9   22:ldc1            #43  <String "OK">
                        //   10   24:invokevirtual   #36  <Method void LogPanel.statusMessage(String)>
                        //   11   27:return          
                        }

                        final _cls4 this$1;

                    
                    {
                        this$1 = _cls4.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #13  <Field LogPanel$4 this$1>
                        super();
                    //    3    5:aload_0         
                    //    4    6:invokespecial   #16  <Method void Object()>
                    //    5    9:return          
                    }
                    }
);
            //   33   66:aload           4
            //   34   68:new             #57  <Class LogPanel$6>
            //   35   71:dup             
            //   36   72:aload_0         
            //   37   73:invokespecial   #58  <Method void LogPanel$6(LogPanel$4)>
            //   38   76:invokevirtual   #49  <Method void JMenuItem.addActionListener(ActionListener)>
                    gcMenu.add(runGC);
            //   39   79:aload_2         
            //   40   80:aload           4
            //   41   82:invokevirtual   #53  <Method JMenuItem JPopupMenu.add(JMenuItem)>
            //   42   85:pop             
                    gcMenu.show(LogPanel.this, e.getX(), e.getY());
            //   43   86:aload_2         
            //   44   87:aload_0         
            //   45   88:getfield        #11  <Field LogPanel this$0>
            //   46   91:aload_1         
            //   47   92:invokevirtual   #61  <Method int MouseEvent.getX()>
            //   48   95:aload_1         
            //   49   96:invokevirtual   #64  <Method int MouseEvent.getY()>
            //   50   99:invokevirtual   #68  <Method void JPopupMenu.show(java.awt.Component, int, int)>
                }
            //   51  102:return          
            }

            final LogPanel this$0;


/*
            static LogPanel access$0(_cls4 _pcls4)
            {
                return _pcls4.this$0;
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field LogPanel this$0>
            //    2    4:areturn         
            }

*/

            
            {
                this$0 = LogPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field LogPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //    0    0:aload_0         
    //    1    1:new             #221 <Class LogPanel$4>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:invokespecial   #222 <Method void LogPanel$4(LogPanel)>
    //    5    9:invokevirtual   #226 <Method void addMouseListener(java.awt.event.MouseListener)>
    //    6   12:return          
    }

    public void taskStarted()
    {
        if(m_TaskMonitor != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
    //*   2    4:ifnull          14
            m_TaskMonitor.taskStarted();
    //    3    7:aload_0         
    //    4    8:getfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
    //    5   11:invokevirtual   #231 <Method void RMinerTaskMonitor.taskStarted()>
    //    6   14:return          
    }

    public void taskFinished()
    {
        if(m_TaskMonitor != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
    //*   2    4:ifnull          14
            m_TaskMonitor.taskFinished();
    //    3    7:aload_0         
    //    4    8:getfield        #66  <Field RMinerTaskMonitor m_TaskMonitor>
    //    5   11:invokevirtual   #234 <Method void RMinerTaskMonitor.taskFinished()>
    //    6   14:return          
    }

    protected static String getTimestamp()
    {
        return (new SimpleDateFormat("HH:mm:ss:")).format(new Date());
    //    0    0:new             #237 <Class SimpleDateFormat>
    //    1    3:dup             
    //    2    4:ldc1            #239 <String "HH:mm:ss:">
    //    3    6:invokespecial   #240 <Method void SimpleDateFormat(String)>
    //    4    9:new             #242 <Class Date>
    //    5   12:dup             
    //    6   13:invokespecial   #243 <Method void Date()>
    //    7   16:invokevirtual   #247 <Method String SimpleDateFormat.format(Date)>
    //    8   19:areturn         
    }

    public synchronized void logMessage(String message)
    {
        if(m_First)
    //*   0    0:aload_0         
    //*   1    1:getfield        #64  <Field boolean m_First>
    //*   2    4:ifeq            15
            m_First = false;
    //    3    7:aload_0         
    //    4    8:iconst_0        
    //    5    9:putfield        #64  <Field boolean m_First>
        else
    //*   6   12:goto            24
            m_LogText.append("\n");
    //    7   15:aload_0         
    //    8   16:getfield        #55  <Field JTextArea m_LogText>
    //    9   19:ldc1            #250 <String "\n">
    //   10   21:invokevirtual   #252 <Method void JTextArea.append(String)>
        m_LogText.append((new StringBuilder(String.valueOf(getTimestamp()))).append(' ').append(message).toString());
    //   11   24:aload_0         
    //   12   25:getfield        #55  <Field JTextArea m_LogText>
    //   13   28:new             #194 <Class StringBuilder>
    //   14   31:dup             
    //   15   32:invokestatic    #254 <Method String getTimestamp()>
    //   16   35:invokestatic    #257 <Method String String.valueOf(Object)>
    //   17   38:invokespecial   #203 <Method void StringBuilder(String)>
    //   18   41:bipush          32
    //   19   43:invokevirtual   #260 <Method StringBuilder StringBuilder.append(char)>
    //   20   46:aload_1         
    //   21   47:invokevirtual   #207 <Method StringBuilder StringBuilder.append(String)>
    //   22   50:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   23   53:invokevirtual   #252 <Method void JTextArea.append(String)>
    //   24   56:return          
    }

    public synchronized void statusMessage(String message)
    {
        m_StatusLab.setText(message);
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field JLabel m_StatusLab>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #265 <Method void JLabel.setText(String)>
    //    4    8:return          
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("Log Panel");
    //    0    0:new             #113 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc2            #269 <String "Log Panel">
    //    3    7:invokespecial   #114 <Method void JFrame(String)>
    //    4   10:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   11:aload_1         
    //    6   12:invokevirtual   #127 <Method Container JFrame.getContentPane()>
    //    7   15:new             #129 <Class BorderLayout>
    //    8   18:dup             
    //    9   19:invokespecial   #130 <Method void BorderLayout()>
    //   10   22:invokevirtual   #136 <Method void Container.setLayout(java.awt.LayoutManager)>
            LogPanel lp = new LogPanel();
    //   11   25:new             #2   <Class LogPanel>
    //   12   28:dup             
    //   13   29:invokespecial   #270 <Method void LogPanel()>
    //   14   32:astore_2        
            jf.getContentPane().add(lp, "Center");
    //   15   33:aload_1         
    //   16   34:invokevirtual   #127 <Method Container JFrame.getContentPane()>
    //   17   37:aload_2         
    //   18   38:ldc1            #138 <String "Center">
    //   19   40:invokevirtual   #142 <Method void Container.add(java.awt.Component, Object)>
            jf.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e)
                {
                    jf.dispose();
                //    0    0:aload_0         
                //    1    1:getfield        #11  <Field JFrame val$jf>
                //    2    4:invokevirtual   #25  <Method void JFrame.dispose()>
                    System.exit(0);
                //    3    7:iconst_0        
                //    4    8:invokestatic    #31  <Method void System.exit(int)>
                //    5   11:return          
                }

                private final JFrame val$jf;

            
            {
                jf = jframe;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field JFrame val$jf>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void WindowAdapter()>
            //    5    9:return          
            }
            }
);
    //   20   43:aload_1         
    //   21   44:new             #272 <Class LogPanel$7>
    //   22   47:dup             
    //   23   48:aload_1         
    //   24   49:invokespecial   #275 <Method void LogPanel$7(JFrame)>
    //   25   52:invokevirtual   #123 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   26   55:aload_1         
    //   27   56:invokevirtual   #145 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   28   59:aload_1         
    //   29   60:iconst_1        
    //   30   61:invokevirtual   #278 <Method void JFrame.setVisible(boolean)>
            lp.logMessage("Welcome to the generic log panel!");
    //   31   64:aload_2         
    //   32   65:ldc2            #280 <String "Welcome to the generic log panel!">
    //   33   68:invokevirtual   #282 <Method void logMessage(String)>
            lp.statusMessage("Hi there");
    //   34   71:aload_2         
    //   35   72:ldc2            #284 <String "Hi there">
    //   36   75:invokevirtual   #286 <Method void statusMessage(String)>
            lp.logMessage("Funky chickens");
    //   37   78:aload_2         
    //   38   79:ldc2            #288 <String "Funky chickens">
    //   39   82:invokevirtual   #282 <Method void logMessage(String)>
        }
    //*  40   85:goto            103
        catch(Exception ex)
    //*  41   88:astore_1        
        {
            ex.printStackTrace();
    //   42   89:aload_1         
    //   43   90:invokevirtual   #293 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   44   93:getstatic       #299 <Field PrintStream System.err>
    //   45   96:aload_1         
    //   46   97:invokevirtual   #302 <Method String Exception.getMessage()>
    //   47  100:invokevirtual   #307 <Method void PrintStream.println(String)>
        }
    //   48  103:return          
    }

    private static final long serialVersionUID = 0xc77bb311c5c81d44L;
    protected JLabel m_StatusLab;
    protected JTextArea m_LogText;
    protected JButton m_logButton;
    protected boolean m_First;
    protected RMinerTaskMonitor m_TaskMonitor;


/*
    static String access$0(LogPanel logpanel, long l)
    {
        return logpanel.printLong(l);
    //    0    0:aload_0         
    //    1    1:lload_1         
    //    2    2:invokespecial   #316 <Method String printLong(long)>
    //    3    5:areturn         
    }

*/
}

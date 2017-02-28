// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RoleminerPanel.java

package rm.gui.explorer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rm.core.Assignment;
import rm.core.Attribute;
import rm.core.Instances;
import rm.core.Option;
import rm.core.OptionHandler;
import rm.core.Utils;
import rm.gui.AccuracyDialog;
import rm.gui.ConverterFileChooser;
import rm.gui.GenericObjectEditor;
import rm.gui.LogPanel;
import rm.gui.Logger;
import rm.gui.PropertyPanel;
import rm.gui.ResultHistoryPanel;
import rm.gui.SaveBuffer;
import rm.gui.SysErrLog;
import rm.gui.TaskLogger;
import rm.rolemining.Roleminer;

// Referenced classes of package rm.gui.explorer:
//            ExplorerDefaults, Explorer, TabbedPane

public class RoleminerPanel extends JPanel
    implements Explorer.LogHandler
{

    public RoleminerPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #50  <Method void JPanel()>
        m_Explorer = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #52  <Field Explorer m_Explorer>
        m_Tabbedpane = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #54  <Field TabbedPane m_Tabbedpane>
        m_FileChooser = new ConverterFileChooser(new File(ExplorerDefaults.getInitialDirectory()));
    //    8   14:aload_0         
    //    9   15:new             #56  <Class ConverterFileChooser>
    //   10   18:dup             
    //   11   19:new             #58  <Class File>
    //   12   22:dup             
    //   13   23:invokestatic    #64  <Method String ExplorerDefaults.getInitialDirectory()>
    //   14   26:invokespecial   #67  <Method void File(String)>
    //   15   29:invokespecial   #70  <Method void ConverterFileChooser(File)>
    //   16   32:putfield        #72  <Field ConverterFileChooser m_FileChooser>
        m_RoleMinerEditor = new GenericObjectEditor();
    //   17   35:aload_0         
    //   18   36:new             #42  <Class GenericObjectEditor>
    //   19   39:dup             
    //   20   40:invokespecial   #73  <Method void GenericObjectEditor()>
    //   21   43:putfield        #75  <Field GenericObjectEditor m_RoleMinerEditor>
        m_CEPanel = new PropertyPanel(m_RoleMinerEditor);
    //   22   46:aload_0         
    //   23   47:new             #77  <Class PropertyPanel>
    //   24   50:dup             
    //   25   51:aload_0         
    //   26   52:getfield        #75  <Field GenericObjectEditor m_RoleMinerEditor>
    //   27   55:invokespecial   #80  <Method void PropertyPanel(java.beans.PropertyEditor)>
    //   28   58:putfield        #82  <Field PropertyPanel m_CEPanel>
        m_OutText = new JTextArea(20, 40);
    //   29   61:aload_0         
    //   30   62:new             #84  <Class JTextArea>
    //   31   65:dup             
    //   32   66:bipush          20
    //   33   68:bipush          40
    //   34   70:invokespecial   #87  <Method void JTextArea(int, int)>
    //   35   73:putfield        #89  <Field JTextArea m_OutText>
        m_Log = new SysErrLog();
    //   36   76:aload_0         
    //   37   77:new             #91  <Class SysErrLog>
    //   38   80:dup             
    //   39   81:invokespecial   #92  <Method void SysErrLog()>
    //   40   84:putfield        #94  <Field Logger m_Log>
        m_History = new ResultHistoryPanel(m_OutText);
    //   41   87:aload_0         
    //   42   88:new             #96  <Class ResultHistoryPanel>
    //   43   91:dup             
    //   44   92:aload_0         
    //   45   93:getfield        #89  <Field JTextArea m_OutText>
    //   46   96:invokespecial   #99  <Method void ResultHistoryPanel(javax.swing.text.JTextComponent)>
    //   47   99:putfield        #101 <Field ResultHistoryPanel m_History>
        m_AccuracyBut = new JButton("Accuracy");
    //   48  102:aload_0         
    //   49  103:new             #103 <Class JButton>
    //   50  106:dup             
    //   51  107:ldc1            #105 <String "Accuracy">
    //   52  109:invokespecial   #106 <Method void JButton(String)>
    //   53  112:putfield        #108 <Field JButton m_AccuracyBut>
        dialog = null;
    //   54  115:aload_0         
    //   55  116:aconst_null     
    //   56  117:putfield        #110 <Field AccuracyDialog dialog>
        m_StartBut = new JButton("Start");
    //   57  120:aload_0         
    //   58  121:new             #103 <Class JButton>
    //   59  124:dup             
    //   60  125:ldc1            #112 <String "Start">
    //   61  127:invokespecial   #106 <Method void JButton(String)>
    //   62  130:putfield        #114 <Field JButton m_StartBut>
        m_StopBut = new JButton("Stop");
    //   63  133:aload_0         
    //   64  134:new             #103 <Class JButton>
    //   65  137:dup             
    //   66  138:ldc1            #116 <String "Stop">
    //   67  140:invokespecial   #106 <Method void JButton(String)>
    //   68  143:putfield        #118 <Field JButton m_StopBut>
        m_SaveOut = new SaveBuffer(m_Log, this);
    //   69  146:aload_0         
    //   70  147:new             #120 <Class SaveBuffer>
    //   71  150:dup             
    //   72  151:aload_0         
    //   73  152:getfield        #94  <Field Logger m_Log>
    //   74  155:aload_0         
    //   75  156:invokespecial   #123 <Method void SaveBuffer(Logger, java.awt.Component)>
    //   76  159:putfield        #125 <Field SaveBuffer m_SaveOut>
        m_OutText.setEditable(false);
    //   77  162:aload_0         
    //   78  163:getfield        #89  <Field JTextArea m_OutText>
    //   79  166:iconst_0        
    //   80  167:invokevirtual   #129 <Method void JTextArea.setEditable(boolean)>
        m_OutText.setFont(new Font("Monospaced", 0, 12));
    //   81  170:aload_0         
    //   82  171:getfield        #89  <Field JTextArea m_OutText>
    //   83  174:new             #131 <Class Font>
    //   84  177:dup             
    //   85  178:ldc1            #133 <String "Monospaced">
    //   86  180:iconst_0        
    //   87  181:bipush          12
    //   88  183:invokespecial   #136 <Method void Font(String, int, int)>
    //   89  186:invokevirtual   #140 <Method void JTextArea.setFont(Font)>
        m_OutText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //   90  189:aload_0         
    //   91  190:getfield        #89  <Field JTextArea m_OutText>
    //   92  193:iconst_5        
    //   93  194:iconst_5        
    //   94  195:iconst_5        
    //   95  196:iconst_5        
    //   96  197:invokestatic    #146 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   97  200:invokevirtual   #150 <Method void JTextArea.setBorder(javax.swing.border.Border)>
        m_OutText.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e)
            {
                if((e.getModifiers() & 0x10) != 16)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #26  <Method int MouseEvent.getModifiers()>
            //*   2    4:bipush          16
            //*   3    6:iand            
            //*   4    7:bipush          16
            //*   5    9:icmpeq          22
                    m_OutText.selectAll();
            //    6   12:aload_0         
            //    7   13:getfield        #11  <Field RoleminerPanel this$0>
            //    8   16:getfield        #32  <Field JTextArea RoleminerPanel.m_OutText>
            //    9   19:invokevirtual   #37  <Method void JTextArea.selectAll()>
            //   10   22:return          
            }

            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //   98  203:aload_0         
    //   99  204:getfield        #89  <Field JTextArea m_OutText>
    //  100  207:new             #152 <Class RoleminerPanel$1>
    //  101  210:dup             
    //  102  211:aload_0         
    //  103  212:invokespecial   #155 <Method void RoleminerPanel$1(RoleminerPanel)>
    //  104  215:invokevirtual   #159 <Method void JTextArea.addMouseListener(java.awt.event.MouseListener)>
        m_History.setBorder(BorderFactory.createTitledBorder("Result list (right-click for options)"));
    //  105  218:aload_0         
    //  106  219:getfield        #101 <Field ResultHistoryPanel m_History>
    //  107  222:ldc1            #161 <String "Result list (right-click for options)">
    //  108  224:invokestatic    #165 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  109  227:invokevirtual   #166 <Method void ResultHistoryPanel.setBorder(javax.swing.border.Border)>
        m_History.setHandleRightClicks(false);
    //  110  230:aload_0         
    //  111  231:getfield        #101 <Field ResultHistoryPanel m_History>
    //  112  234:iconst_0        
    //  113  235:invokevirtual   #169 <Method void ResultHistoryPanel.setHandleRightClicks(boolean)>
        m_History.getList().addMouseListener(new MouseAdapter() {

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
            //*   8   16:ifeq            89
                {
                    int index = m_History.getList().locationToIndex(e.getPoint());
            //    9   19:aload_0         
            //   10   20:getfield        #11  <Field RoleminerPanel this$0>
            //   11   23:getfield        #36  <Field ResultHistoryPanel RoleminerPanel.m_History>
            //   12   26:invokevirtual   #42  <Method JList ResultHistoryPanel.getList()>
            //   13   29:aload_1         
            //   14   30:invokevirtual   #46  <Method Point MouseEvent.getPoint()>
            //   15   33:invokevirtual   #52  <Method int JList.locationToIndex(Point)>
            //   16   36:istore_2        
                    if(index != -1)
            //*  17   37:iload_2         
            //*  18   38:iconst_m1       
            //*  19   39:icmpeq          73
                    {
                        String name = m_History.getNameAtIndex(index);
            //   20   42:aload_0         
            //   21   43:getfield        #11  <Field RoleminerPanel this$0>
            //   22   46:getfield        #36  <Field ResultHistoryPanel RoleminerPanel.m_History>
            //   23   49:iload_2         
            //   24   50:invokevirtual   #56  <Method String ResultHistoryPanel.getNameAtIndex(int)>
            //   25   53:astore_3        
                        historyRightClickPopup(name, e.getX(), e.getY());
            //   26   54:aload_0         
            //   27   55:getfield        #11  <Field RoleminerPanel this$0>
            //   28   58:aload_3         
            //   29   59:aload_1         
            //   30   60:invokevirtual   #59  <Method int MouseEvent.getX()>
            //   31   63:aload_1         
            //   32   64:invokevirtual   #62  <Method int MouseEvent.getY()>
            //   33   67:invokevirtual   #66  <Method void RoleminerPanel.historyRightClickPopup(String, int, int)>
                    } else
            //*  34   70:goto            89
                    {
                        historyRightClickPopup(null, e.getX(), e.getY());
            //   35   73:aload_0         
            //   36   74:getfield        #11  <Field RoleminerPanel this$0>
            //   37   77:aconst_null     
            //   38   78:aload_1         
            //   39   79:invokevirtual   #59  <Method int MouseEvent.getX()>
            //   40   82:aload_1         
            //   41   83:invokevirtual   #62  <Method int MouseEvent.getY()>
            //   42   86:invokevirtual   #66  <Method void RoleminerPanel.historyRightClickPopup(String, int, int)>
                    }
                }
            //   43   89:return          
            }

            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //  114  238:aload_0         
    //  115  239:getfield        #101 <Field ResultHistoryPanel m_History>
    //  116  242:invokevirtual   #173 <Method JList ResultHistoryPanel.getList()>
    //  117  245:new             #175 <Class RoleminerPanel$2>
    //  118  248:dup             
    //  119  249:aload_0         
    //  120  250:invokespecial   #176 <Method void RoleminerPanel$2(RoleminerPanel)>
    //  121  253:invokevirtual   #179 <Method void JList.addMouseListener(java.awt.event.MouseListener)>
        m_RoleMinerEditor.setClassType(rm/rolemining/Roleminer);
    //  122  256:aload_0         
    //  123  257:getfield        #75  <Field GenericObjectEditor m_RoleMinerEditor>
    //  124  260:ldc1            #181 <Class Roleminer>
    //  125  262:invokevirtual   #185 <Method void GenericObjectEditor.setClassType(Class)>
        m_RoleMinerEditor.setValue(ExplorerDefaults.getRoleminer());
    //  126  265:aload_0         
    //  127  266:getfield        #75  <Field GenericObjectEditor m_RoleMinerEditor>
    //  128  269:invokestatic    #189 <Method Object ExplorerDefaults.getRoleminer()>
    //  129  272:invokevirtual   #193 <Method void GenericObjectEditor.setValue(Object)>
        m_RoleMinerEditor.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e)
            {
                m_StartBut.setEnabled(true);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field RoleminerPanel this$0>
            //    2    4:getfield        #28  <Field JButton RoleminerPanel.m_StartBut>
            //    3    7:iconst_1        
            //    4    8:invokevirtual   #34  <Method void JButton.setEnabled(boolean)>
                Roleminer miner = (Roleminer)m_RoleMinerEditor.getValue();
            //    5   11:aload_0         
            //    6   12:getfield        #13  <Field RoleminerPanel this$0>
            //    7   15:getfield        #38  <Field GenericObjectEditor RoleminerPanel.m_RoleMinerEditor>
            //    8   18:invokevirtual   #44  <Method Object GenericObjectEditor.getValue()>
            //    9   21:checkcast       #46  <Class Roleminer>
            //   10   24:astore_2        
                repaint();
            //   11   25:aload_0         
            //   12   26:getfield        #13  <Field RoleminerPanel this$0>
            //   13   29:invokevirtual   #49  <Method void RoleminerPanel.repaint()>
            //   14   32:return          
            }

            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  130  275:aload_0         
    //  131  276:getfield        #75  <Field GenericObjectEditor m_RoleMinerEditor>
    //  132  279:new             #195 <Class RoleminerPanel$3>
    //  133  282:dup             
    //  134  283:aload_0         
    //  135  284:invokespecial   #196 <Method void RoleminerPanel$3(RoleminerPanel)>
    //  136  287:invokevirtual   #200 <Method void GenericObjectEditor.addPropertyChangeListener(PropertyChangeListener)>
        m_StartBut.setToolTipText("Starts the roleminer");
    //  137  290:aload_0         
    //  138  291:getfield        #114 <Field JButton m_StartBut>
    //  139  294:ldc1            #202 <String "Starts the roleminer">
    //  140  296:invokevirtual   #205 <Method void JButton.setToolTipText(String)>
        m_StopBut.setToolTipText("Stops the roleminer");
    //  141  299:aload_0         
    //  142  300:getfield        #118 <Field JButton m_StopBut>
    //  143  303:ldc1            #207 <String "Stops the roleminer">
    //  144  305:invokevirtual   #205 <Method void JButton.setToolTipText(String)>
        m_StartBut.setEnabled(false);
    //  145  308:aload_0         
    //  146  309:getfield        #114 <Field JButton m_StartBut>
    //  147  312:iconst_0        
    //  148  313:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
        m_StopBut.setEnabled(false);
    //  149  316:aload_0         
    //  150  317:getfield        #118 <Field JButton m_StopBut>
    //  151  320:iconst_0        
    //  152  321:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
        m_StartBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                startRoleminer();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field RoleminerPanel this$0>
            //    2    4:invokevirtual   #27  <Method void RoleminerPanel.startRoleminer()>
            //    3    7:return          
            }

            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  153  324:aload_0         
    //  154  325:getfield        #114 <Field JButton m_StartBut>
    //  155  328:new             #212 <Class RoleminerPanel$4>
    //  156  331:dup             
    //  157  332:aload_0         
    //  158  333:invokespecial   #213 <Method void RoleminerPanel$4(RoleminerPanel)>
    //  159  336:invokevirtual   #217 <Method void JButton.addActionListener(ActionListener)>
        m_StopBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                stopRoleminer();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field RoleminerPanel this$0>
            //    2    4:invokevirtual   #27  <Method void RoleminerPanel.stopRoleminer()>
            //    3    7:return          
            }

            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  160  339:aload_0         
    //  161  340:getfield        #118 <Field JButton m_StopBut>
    //  162  343:new             #219 <Class RoleminerPanel$5>
    //  163  346:dup             
    //  164  347:aload_0         
    //  165  348:invokespecial   #220 <Method void RoleminerPanel$5(RoleminerPanel)>
    //  166  351:invokevirtual   #217 <Method void JButton.addActionListener(ActionListener)>
        JPanel p1 = new JPanel();
    //  167  354:new             #4   <Class JPanel>
    //  168  357:dup             
    //  169  358:invokespecial   #50  <Method void JPanel()>
    //  170  361:astore_1        
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("RoleMiner"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
    //  171  362:aload_1         
    //  172  363:ldc1            #222 <String "RoleMiner">
    //  173  365:invokestatic    #165 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  174  368:iconst_0        
    //  175  369:iconst_5        
    //  176  370:iconst_5        
    //  177  371:iconst_5        
    //  178  372:invokestatic    #146 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  179  375:invokestatic    #226 <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //  180  378:invokevirtual   #227 <Method void JPanel.setBorder(javax.swing.border.Border)>
        p1.setLayout(new BorderLayout());
    //  181  381:aload_1         
    //  182  382:new             #229 <Class BorderLayout>
    //  183  385:dup             
    //  184  386:invokespecial   #230 <Method void BorderLayout()>
    //  185  389:invokevirtual   #234 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        p1.add(m_CEPanel, "Center");
    //  186  392:aload_1         
    //  187  393:aload_0         
    //  188  394:getfield        #82  <Field PropertyPanel m_CEPanel>
    //  189  397:ldc1            #236 <String "Center">
    //  190  399:invokevirtual   #240 <Method void JPanel.add(java.awt.Component, Object)>
        p1.add(m_AccuracyBut, "East");
    //  191  402:aload_1         
    //  192  403:aload_0         
    //  193  404:getfield        #108 <Field JButton m_AccuracyBut>
    //  194  407:ldc1            #242 <String "East">
    //  195  409:invokevirtual   #240 <Method void JPanel.add(java.awt.Component, Object)>
        m_AccuracyBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                if(dialog == null)
            //*   0    0:aload_0         
            //*   1    1:getfield        #13  <Field RoleminerPanel this$0>
            //*   2    4:getfield        #28  <Field AccuracyDialog RoleminerPanel.dialog>
            //*   3    7:ifnonnull       24
                    dialog = new AccuracyDialog();
            //    4   10:aload_0         
            //    5   11:getfield        #13  <Field RoleminerPanel this$0>
            //    6   14:new             #30  <Class AccuracyDialog>
            //    7   17:dup             
            //    8   18:invokespecial   #31  <Method void AccuracyDialog()>
            //    9   21:putfield        #28  <Field AccuracyDialog RoleminerPanel.dialog>
                dialog.setGenerateRoles(m_assroles);
            //   10   24:aload_0         
            //   11   25:getfield        #13  <Field RoleminerPanel this$0>
            //   12   28:getfield        #28  <Field AccuracyDialog RoleminerPanel.dialog>
            //   13   31:aload_0         
            //   14   32:getfield        #13  <Field RoleminerPanel this$0>
            //   15   35:getfield        #35  <Field Assignment RoleminerPanel.m_assroles>
            //   16   38:invokevirtual   #39  <Method void AccuracyDialog.setGenerateRoles(Assignment)>
                dialog.showDialog(RoleminerPanel.this, "Compute Accuracy of Roles");
            //   17   41:aload_0         
            //   18   42:getfield        #13  <Field RoleminerPanel this$0>
            //   19   45:getfield        #28  <Field AccuracyDialog RoleminerPanel.dialog>
            //   20   48:aload_0         
            //   21   49:getfield        #13  <Field RoleminerPanel this$0>
            //   22   52:ldc1            #41  <String "Compute Accuracy of Roles">
            //   23   54:invokevirtual   #45  <Method void AccuracyDialog.showDialog(java.awt.Component, String)>
            //   24   57:return          
            }

            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  196  412:aload_0         
    //  197  413:getfield        #108 <Field JButton m_AccuracyBut>
    //  198  416:new             #244 <Class RoleminerPanel$6>
    //  199  419:dup             
    //  200  420:aload_0         
    //  201  421:invokespecial   #245 <Method void RoleminerPanel$6(RoleminerPanel)>
    //  202  424:invokevirtual   #217 <Method void JButton.addActionListener(ActionListener)>
        m_AccuracyBut.setEnabled(false);
    //  203  427:aload_0         
    //  204  428:getfield        #108 <Field JButton m_AccuracyBut>
    //  205  431:iconst_0        
    //  206  432:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
        JPanel buttons = new JPanel();
    //  207  435:new             #4   <Class JPanel>
    //  208  438:dup             
    //  209  439:invokespecial   #50  <Method void JPanel()>
    //  210  442:astore_2        
        buttons.setLayout(new GridLayout(1, 2));
    //  211  443:aload_2         
    //  212  444:new             #247 <Class GridLayout>
    //  213  447:dup             
    //  214  448:iconst_1        
    //  215  449:iconst_2        
    //  216  450:invokespecial   #248 <Method void GridLayout(int, int)>
    //  217  453:invokevirtual   #234 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JPanel ssButs = new JPanel();
    //  218  456:new             #4   <Class JPanel>
    //  219  459:dup             
    //  220  460:invokespecial   #50  <Method void JPanel()>
    //  221  463:astore_3        
        ssButs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //  222  464:aload_3         
    //  223  465:iconst_5        
    //  224  466:iconst_5        
    //  225  467:iconst_5        
    //  226  468:iconst_5        
    //  227  469:invokestatic    #146 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  228  472:invokevirtual   #227 <Method void JPanel.setBorder(javax.swing.border.Border)>
        ssButs.setLayout(new GridLayout(1, 2, 5, 5));
    //  229  475:aload_3         
    //  230  476:new             #247 <Class GridLayout>
    //  231  479:dup             
    //  232  480:iconst_1        
    //  233  481:iconst_2        
    //  234  482:iconst_5        
    //  235  483:iconst_5        
    //  236  484:invokespecial   #251 <Method void GridLayout(int, int, int, int)>
    //  237  487:invokevirtual   #234 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        ssButs.add(m_StartBut);
    //  238  490:aload_3         
    //  239  491:aload_0         
    //  240  492:getfield        #114 <Field JButton m_StartBut>
    //  241  495:invokevirtual   #254 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  242  498:pop             
        ssButs.add(m_StopBut);
    //  243  499:aload_3         
    //  244  500:aload_0         
    //  245  501:getfield        #118 <Field JButton m_StopBut>
    //  246  504:invokevirtual   #254 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  247  507:pop             
        buttons.add(ssButs);
    //  248  508:aload_2         
    //  249  509:aload_3         
    //  250  510:invokevirtual   #254 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  251  513:pop             
        JPanel p3 = new JPanel();
    //  252  514:new             #4   <Class JPanel>
    //  253  517:dup             
    //  254  518:invokespecial   #50  <Method void JPanel()>
    //  255  521:astore          4
        p3.setBorder(BorderFactory.createTitledBorder("RoleMiner output"));
    //  256  523:aload           4
    //  257  525:ldc2            #256 <String "RoleMiner output">
    //  258  528:invokestatic    #165 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  259  531:invokevirtual   #227 <Method void JPanel.setBorder(javax.swing.border.Border)>
        p3.setLayout(new BorderLayout());
    //  260  534:aload           4
    //  261  536:new             #229 <Class BorderLayout>
    //  262  539:dup             
    //  263  540:invokespecial   #230 <Method void BorderLayout()>
    //  264  543:invokevirtual   #234 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JScrollPane js = new JScrollPane(m_OutText);
    //  265  546:new             #258 <Class JScrollPane>
    //  266  549:dup             
    //  267  550:aload_0         
    //  268  551:getfield        #89  <Field JTextArea m_OutText>
    //  269  554:invokespecial   #261 <Method void JScrollPane(java.awt.Component)>
    //  270  557:astore          5
        p3.add(js, "Center");
    //  271  559:aload           4
    //  272  561:aload           5
    //  273  563:ldc1            #236 <String "Center">
    //  274  565:invokevirtual   #240 <Method void JPanel.add(java.awt.Component, Object)>
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
            final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #18  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  275  568:aload           5
    //  276  570:invokevirtual   #265 <Method JViewport JScrollPane.getViewport()>
    //  277  573:new             #267 <Class RoleminerPanel$7>
    //  278  576:dup             
    //  279  577:aload_0         
    //  280  578:invokespecial   #268 <Method void RoleminerPanel$7(RoleminerPanel)>
    //  281  581:invokevirtual   #274 <Method void JViewport.addChangeListener(ChangeListener)>
        GridBagLayout gbL = new GridBagLayout();
    //  282  584:new             #276 <Class GridBagLayout>
    //  283  587:dup             
    //  284  588:invokespecial   #277 <Method void GridBagLayout()>
    //  285  591:astore          6
        GridBagConstraints gbC = new GridBagConstraints();
    //  286  593:new             #279 <Class GridBagConstraints>
    //  287  596:dup             
    //  288  597:invokespecial   #280 <Method void GridBagConstraints()>
    //  289  600:astore          7
        JPanel mondo = new JPanel();
    //  290  602:new             #4   <Class JPanel>
    //  291  605:dup             
    //  292  606:invokespecial   #50  <Method void JPanel()>
    //  293  609:astore          8
        gbL = new GridBagLayout();
    //  294  611:new             #276 <Class GridBagLayout>
    //  295  614:dup             
    //  296  615:invokespecial   #277 <Method void GridBagLayout()>
    //  297  618:astore          6
        mondo.setLayout(gbL);
    //  298  620:aload           8
    //  299  622:aload           6
    //  300  624:invokevirtual   #234 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        gbC = new GridBagConstraints();
    //  301  627:new             #279 <Class GridBagConstraints>
    //  302  630:dup             
    //  303  631:invokespecial   #280 <Method void GridBagConstraints()>
    //  304  634:astore          7
        gbC.anchor = 11;
    //  305  636:aload           7
    //  306  638:bipush          11
    //  307  640:putfield        #284 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  308  643:aload           7
    //  309  645:iconst_2        
    //  310  646:putfield        #287 <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  311  649:aload           7
    //  312  651:iconst_1        
    //  313  652:putfield        #290 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  314  655:aload           7
    //  315  657:iconst_0        
    //  316  658:putfield        #293 <Field int GridBagConstraints.gridx>
        gbL.setConstraints(buttons, gbC);
    //  317  661:aload           6
    //  318  663:aload_2         
    //  319  664:aload           7
    //  320  666:invokevirtual   #297 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        mondo.add(buttons);
    //  321  669:aload           8
    //  322  671:aload_2         
    //  323  672:invokevirtual   #254 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  324  675:pop             
        gbC = new GridBagConstraints();
    //  325  676:new             #279 <Class GridBagConstraints>
    //  326  679:dup             
    //  327  680:invokespecial   #280 <Method void GridBagConstraints()>
    //  328  683:astore          7
        gbC.fill = 1;
    //  329  685:aload           7
    //  330  687:iconst_1        
    //  331  688:putfield        #287 <Field int GridBagConstraints.fill>
        gbC.gridy = 2;
    //  332  691:aload           7
    //  333  693:iconst_2        
    //  334  694:putfield        #290 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  335  697:aload           7
    //  336  699:iconst_0        
    //  337  700:putfield        #293 <Field int GridBagConstraints.gridx>
        gbC.weightx = 0.0D;
    //  338  703:aload           7
    //  339  705:dconst_0        
    //  340  706:putfield        #301 <Field double GridBagConstraints.weightx>
        gbL.setConstraints(m_History, gbC);
    //  341  709:aload           6
    //  342  711:aload_0         
    //  343  712:getfield        #101 <Field ResultHistoryPanel m_History>
    //  344  715:aload           7
    //  345  717:invokevirtual   #297 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        mondo.add(m_History);
    //  346  720:aload           8
    //  347  722:aload_0         
    //  348  723:getfield        #101 <Field ResultHistoryPanel m_History>
    //  349  726:invokevirtual   #254 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  350  729:pop             
        gbC = new GridBagConstraints();
    //  351  730:new             #279 <Class GridBagConstraints>
    //  352  733:dup             
    //  353  734:invokespecial   #280 <Method void GridBagConstraints()>
    //  354  737:astore          7
        gbC.fill = 1;
    //  355  739:aload           7
    //  356  741:iconst_1        
    //  357  742:putfield        #287 <Field int GridBagConstraints.fill>
        gbC.gridy = 0;
    //  358  745:aload           7
    //  359  747:iconst_0        
    //  360  748:putfield        #290 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  361  751:aload           7
    //  362  753:iconst_1        
    //  363  754:putfield        #293 <Field int GridBagConstraints.gridx>
        gbC.gridheight = 3;
    //  364  757:aload           7
    //  365  759:iconst_3        
    //  366  760:putfield        #304 <Field int GridBagConstraints.gridheight>
        gbC.weightx = 100D;
    //  367  763:aload           7
    //  368  765:ldc2w           #305 <Double 100D>
    //  369  768:putfield        #301 <Field double GridBagConstraints.weightx>
        gbC.weighty = 100D;
    //  370  771:aload           7
    //  371  773:ldc2w           #305 <Double 100D>
    //  372  776:putfield        #309 <Field double GridBagConstraints.weighty>
        gbL.setConstraints(p3, gbC);
    //  373  779:aload           6
    //  374  781:aload           4
    //  375  783:aload           7
    //  376  785:invokevirtual   #297 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        mondo.add(p3);
    //  377  788:aload           8
    //  378  790:aload           4
    //  379  792:invokevirtual   #254 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  380  795:pop             
        setLayout(new BorderLayout());
    //  381  796:aload_0         
    //  382  797:new             #229 <Class BorderLayout>
    //  383  800:dup             
    //  384  801:invokespecial   #230 <Method void BorderLayout()>
    //  385  804:invokevirtual   #310 <Method void setLayout(java.awt.LayoutManager)>
        add(p1, "North");
    //  386  807:aload_0         
    //  387  808:aload_1         
    //  388  809:ldc2            #312 <String "North">
    //  389  812:invokevirtual   #313 <Method void add(java.awt.Component, Object)>
        add(mondo, "Center");
    //  390  815:aload_0         
    //  391  816:aload           8
    //  392  818:ldc1            #236 <String "Center">
    //  393  820:invokevirtual   #313 <Method void add(java.awt.Component, Object)>
    //  394  823:return          
    }

    public void setLog(Logger newLog)
    {
        m_Log = newLog;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #94  <Field Logger m_Log>
    //    3    5:return          
    }

    protected void startRoleminer()
    {
        if(m_RunThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #333 <Field Thread m_RunThread>
    //*   2    4:ifnonnull       50
        {
            m_StartBut.setEnabled(false);
    //    3    7:aload_0         
    //    4    8:getfield        #114 <Field JButton m_StartBut>
    //    5   11:iconst_0        
    //    6   12:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
            m_StopBut.setEnabled(true);
    //    7   15:aload_0         
    //    8   16:getfield        #118 <Field JButton m_StopBut>
    //    9   19:iconst_1        
    //   10   20:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
            m_RunThread = new Thread() {

                public void run()
                {
                    Assignment ass;
                    Roleminer miner;
                    StringBuffer outBuff;
                    String name;
                    String cname;
                    String cmd;
                    m_Log.statusMessage("Setting up...");
                //    0    0:aload_0         
                //    1    1:getfield        #11  <Field RoleminerPanel this$0>
                //    2    4:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //    3    7:ldc1            #27  <String "Setting up...">
                //    4    9:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    ass = new Assignment(m_Assignment);
                //    5   14:new             #35  <Class Assignment>
                //    6   17:dup             
                //    7   18:aload_0         
                //    8   19:getfield        #11  <Field RoleminerPanel this$0>
                //    9   22:getfield        #39  <Field Assignment RoleminerPanel.m_Assignment>
                //   10   25:invokespecial   #42  <Method void Assignment(Assignment)>
                //   11   28:astore_1        
                    miner = (Roleminer)m_RoleMinerEditor.getValue();
                //   12   29:aload_0         
                //   13   30:getfield        #11  <Field RoleminerPanel this$0>
                //   14   33:getfield        #46  <Field GenericObjectEditor RoleminerPanel.m_RoleMinerEditor>
                //   15   36:invokevirtual   #52  <Method Object GenericObjectEditor.getValue()>
                //   16   39:checkcast       #54  <Class Roleminer>
                //   17   42:astore_2        
                    outBuff = new StringBuffer();
                //   18   43:new             #56  <Class StringBuffer>
                //   19   46:dup             
                //   20   47:invokespecial   #57  <Method void StringBuffer()>
                //   21   50:astore_3        
                    name = (new SimpleDateFormat("HH:mm:ss - ")).format(new Date());
                //   22   51:new             #59  <Class SimpleDateFormat>
                //   23   54:dup             
                //   24   55:ldc1            #61  <String "HH:mm:ss - ">
                //   25   57:invokespecial   #63  <Method void SimpleDateFormat(String)>
                //   26   60:new             #65  <Class Date>
                //   27   63:dup             
                //   28   64:invokespecial   #66  <Method void Date()>
                //   29   67:invokevirtual   #70  <Method String SimpleDateFormat.format(Date)>
                //   30   70:astore          4
                    cname = miner.getClass().getName();
                //   31   72:aload_2         
                //   32   73:invokevirtual   #76  <Method Class Object.getClass()>
                //   33   76:invokevirtual   #82  <Method String Class.getName()>
                //   34   79:astore          5
                    if(cname.startsWith("rm.rolemining"))
                //*  35   81:aload           5
                //*  36   83:ldc1            #84  <String "rm.rolemining">
                //*  37   85:invokevirtual   #90  <Method boolean String.startsWith(String)>
                //*  38   88:ifeq            124
                        name = (new StringBuilder(String.valueOf(name))).append(cname.substring("rm.rolemining.".length())).toString();
                //   39   91:new             #92  <Class StringBuilder>
                //   40   94:dup             
                //   41   95:aload           4
                //   42   97:invokestatic    #96  <Method String String.valueOf(Object)>
                //   43  100:invokespecial   #97  <Method void StringBuilder(String)>
                //   44  103:aload           5
                //   45  105:ldc1            #99  <String "rm.rolemining.">
                //   46  107:invokevirtual   #103 <Method int String.length()>
                //   47  110:invokevirtual   #107 <Method String String.substring(int)>
                //   48  113:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //   49  116:invokevirtual   #114 <Method String StringBuilder.toString()>
                //   50  119:astore          4
                    else
                //*  51  121:goto            146
                        name = (new StringBuilder(String.valueOf(name))).append(cname).toString();
                //   52  124:new             #92  <Class StringBuilder>
                //   53  127:dup             
                //   54  128:aload           4
                //   55  130:invokestatic    #96  <Method String String.valueOf(Object)>
                //   56  133:invokespecial   #97  <Method void StringBuilder(String)>
                //   57  136:aload           5
                //   58  138:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //   59  141:invokevirtual   #114 <Method String StringBuilder.toString()>
                //   60  144:astore          4
                    cmd = m_RoleMinerEditor.getValue().getClass().getName();
                //   61  146:aload_0         
                //   62  147:getfield        #11  <Field RoleminerPanel this$0>
                //   63  150:getfield        #46  <Field GenericObjectEditor RoleminerPanel.m_RoleMinerEditor>
                //   64  153:invokevirtual   #52  <Method Object GenericObjectEditor.getValue()>
                //   65  156:invokevirtual   #76  <Method Class Object.getClass()>
                //   66  159:invokevirtual   #82  <Method String Class.getName()>
                //   67  162:astore          6
                    if(m_RoleMinerEditor.getValue() instanceof OptionHandler)
                //*  68  164:aload_0         
                //*  69  165:getfield        #11  <Field RoleminerPanel this$0>
                //*  70  168:getfield        #46  <Field GenericObjectEditor RoleminerPanel.m_RoleMinerEditor>
                //*  71  171:invokevirtual   #52  <Method Object GenericObjectEditor.getValue()>
                //*  72  174:instanceof      #116 <Class OptionHandler>
                //*  73  177:ifeq            226
                        cmd = (new StringBuilder(String.valueOf(cmd))).append(" ").append(Utils.joinOptions(((OptionHandler)m_RoleMinerEditor.getValue()).getOptions())).toString();
                //   74  180:new             #92  <Class StringBuilder>
                //   75  183:dup             
                //   76  184:aload           6
                //   77  186:invokestatic    #96  <Method String String.valueOf(Object)>
                //   78  189:invokespecial   #97  <Method void StringBuilder(String)>
                //   79  192:ldc1            #118 <String " ">
                //   80  194:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //   81  197:aload_0         
                //   82  198:getfield        #11  <Field RoleminerPanel this$0>
                //   83  201:getfield        #46  <Field GenericObjectEditor RoleminerPanel.m_RoleMinerEditor>
                //   84  204:invokevirtual   #52  <Method Object GenericObjectEditor.getValue()>
                //   85  207:checkcast       #116 <Class OptionHandler>
                //   86  210:invokeinterface #122 <Method String[] OptionHandler.getOptions()>
                //   87  215:invokestatic    #128 <Method String Utils.joinOptions(String[])>
                //   88  218:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //   89  221:invokevirtual   #114 <Method String StringBuilder.toString()>
                //   90  224:astore          6
                    try
                    {
                        m_Log.logMessage((new StringBuilder("Started ")).append(cname).toString());
                //   91  226:aload_0         
                //   92  227:getfield        #11  <Field RoleminerPanel this$0>
                //   93  230:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //   94  233:new             #92  <Class StringBuilder>
                //   95  236:dup             
                //   96  237:ldc1            #130 <String "Started ">
                //   97  239:invokespecial   #97  <Method void StringBuilder(String)>
                //   98  242:aload           5
                //   99  244:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  100  247:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  101  250:invokeinterface #133 <Method void Logger.logMessage(String)>
                        m_Log.logMessage((new StringBuilder("Command: ")).append(cmd).toString());
                //  102  255:aload_0         
                //  103  256:getfield        #11  <Field RoleminerPanel this$0>
                //  104  259:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  105  262:new             #92  <Class StringBuilder>
                //  106  265:dup             
                //  107  266:ldc1            #135 <String "Command: ">
                //  108  268:invokespecial   #97  <Method void StringBuilder(String)>
                //  109  271:aload           6
                //  110  273:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  111  276:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  112  279:invokeinterface #133 <Method void Logger.logMessage(String)>
                        if(m_Log instanceof TaskLogger)
                //* 113  284:aload_0         
                //* 114  285:getfield        #11  <Field RoleminerPanel this$0>
                //* 115  288:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //* 116  291:instanceof      #137 <Class TaskLogger>
                //* 117  294:ifeq            312
                            ((TaskLogger)m_Log).taskStarted();
                //  118  297:aload_0         
                //  119  298:getfield        #11  <Field RoleminerPanel this$0>
                //  120  301:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  121  304:checkcast       #137 <Class TaskLogger>
                //  122  307:invokeinterface #140 <Method void TaskLogger.taskStarted()>
                        outBuff.append("=== Run information ===\n\n");
                //  123  312:aload_3         
                //  124  313:ldc1            #142 <String "=== Run information ===\n\n">
                //  125  315:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  126  318:pop             
                        outBuff.append((new StringBuilder("Scheme:       ")).append(cname).toString());
                //  127  319:aload_3         
                //  128  320:new             #92  <Class StringBuilder>
                //  129  323:dup             
                //  130  324:ldc1            #147 <String "Scheme:       ">
                //  131  326:invokespecial   #97  <Method void StringBuilder(String)>
                //  132  329:aload           5
                //  133  331:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  134  334:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  135  337:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  136  340:pop             
                        if(miner instanceof OptionHandler)
                //* 137  341:aload_2         
                //* 138  342:instanceof      #116 <Class OptionHandler>
                //* 139  345:ifeq            391
                        {
                            outBuff.append("\n-------------------------------\n");
                //  140  348:aload_3         
                //  141  349:ldc1            #149 <String "\n-------------------------------\n">
                //  142  351:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  143  354:pop             
                            String o[] = ((OptionHandler)miner).getOptions();
                //  144  355:aload_2         
                //  145  356:checkcast       #116 <Class OptionHandler>
                //  146  359:invokeinterface #122 <Method String[] OptionHandler.getOptions()>
                //  147  364:astore          7
                            outBuff.append((new StringBuilder(" ")).append(Utils.joinOptions(o)).toString());
                //  148  366:aload_3         
                //  149  367:new             #92  <Class StringBuilder>
                //  150  370:dup             
                //  151  371:ldc1            #118 <String " ">
                //  152  373:invokespecial   #97  <Method void StringBuilder(String)>
                //  153  376:aload           7
                //  154  378:invokestatic    #128 <Method String Utils.joinOptions(String[])>
                //  155  381:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  156  384:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  157  387:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  158  390:pop             
                        }
                        outBuff.append("\n");
                //  159  391:aload_3         
                //  160  392:ldc1            #151 <String "\n">
                //  161  394:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  162  397:pop             
                        outBuff.append((new StringBuilder("Assignement:   ")).append(ass.getAssignementName()).append('\n').toString());
                //  163  398:aload_3         
                //  164  399:new             #92  <Class StringBuilder>
                //  165  402:dup             
                //  166  403:ldc1            #153 <String "Assignement:   ">
                //  167  405:invokespecial   #97  <Method void StringBuilder(String)>
                //  168  408:aload_1         
                //  169  409:invokevirtual   #156 <Method String Assignment.getAssignementName()>
                //  170  412:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  171  415:bipush          10
                //  172  417:invokevirtual   #159 <Method StringBuilder StringBuilder.append(char)>
                //  173  420:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  174  423:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  175  426:pop             
                        outBuff.append((new StringBuilder(String.valueOf(ass.getDimensionX().getName()))).append(":    ").append(ass.getDimensionX().getDimensionAttribute().numValues()).append('\n').toString());
                //  176  427:aload_3         
                //  177  428:new             #92  <Class StringBuilder>
                //  178  431:dup             
                //  179  432:aload_1         
                //  180  433:invokevirtual   #163 <Method rm.core.Dimension Assignment.getDimensionX()>
                //  181  436:invokevirtual   #166 <Method String rm.core.Dimension.getName()>
                //  182  439:invokestatic    #96  <Method String String.valueOf(Object)>
                //  183  442:invokespecial   #97  <Method void StringBuilder(String)>
                //  184  445:ldc1            #168 <String ":    ">
                //  185  447:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  186  450:aload_1         
                //  187  451:invokevirtual   #163 <Method rm.core.Dimension Assignment.getDimensionX()>
                //  188  454:invokevirtual   #172 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
                //  189  457:invokevirtual   #177 <Method int Attribute.numValues()>
                //  190  460:invokevirtual   #180 <Method StringBuilder StringBuilder.append(int)>
                //  191  463:bipush          10
                //  192  465:invokevirtual   #159 <Method StringBuilder StringBuilder.append(char)>
                //  193  468:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  194  471:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  195  474:pop             
                        Object dx[] = ass.getDimensionX().getDimensionAttribute().toArray();
                //  196  475:aload_1         
                //  197  476:invokevirtual   #163 <Method rm.core.Dimension Assignment.getDimensionX()>
                //  198  479:invokevirtual   #172 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
                //  199  482:invokevirtual   #184 <Method Object[] Attribute.toArray()>
                //  200  485:astore          7
                        if(dx.length < 100)
                //* 201  487:aload           7
                //* 202  489:arraylength     
                //* 203  490:bipush          100
                //* 204  492:icmpge          567
                        {
                            for(int i = 0; i < dx.length; i++)
                //* 205  495:iconst_0        
                //* 206  496:istore          8
                //* 207  498:goto            549
                            {
                                outBuff.append((new StringBuilder(" ")).append(dx[i]).toString());
                //  208  501:aload_3         
                //  209  502:new             #92  <Class StringBuilder>
                //  210  505:dup             
                //  211  506:ldc1            #118 <String " ">
                //  212  508:invokespecial   #97  <Method void StringBuilder(String)>
                //  213  511:aload           7
                //  214  513:iload           8
                //  215  515:aaload          
                //  216  516:invokevirtual   #187 <Method StringBuilder StringBuilder.append(Object)>
                //  217  519:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  218  522:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  219  525:pop             
                                if(i % 12 == 0 && i != 0)
                //* 220  526:iload           8
                //* 221  528:bipush          12
                //* 222  530:irem            
                //* 223  531:ifne            546
                //* 224  534:iload           8
                //* 225  536:ifeq            546
                                    outBuff.append('\n');
                //  226  539:aload_3         
                //  227  540:bipush          10
                //  228  542:invokevirtual   #190 <Method StringBuffer StringBuffer.append(char)>
                //  229  545:pop             
                            }

                //  230  546:iinc            8  1
                //  231  549:iload           8
                //  232  551:aload           7
                //  233  553:arraylength     
                //  234  554:icmplt          501
                            outBuff.append('\n');
                //  235  557:aload_3         
                //  236  558:bipush          10
                //  237  560:invokevirtual   #190 <Method StringBuffer StringBuffer.append(char)>
                //  238  563:pop             
                        } else
                //* 239  564:goto            599
                        {
                            outBuff.append((new StringBuilder("  [list of ")).append(ass.getDimensionX().getName()).append(" omitted]\n").toString());
                //  240  567:aload_3         
                //  241  568:new             #92  <Class StringBuilder>
                //  242  571:dup             
                //  243  572:ldc1            #192 <String "  [list of ">
                //  244  574:invokespecial   #97  <Method void StringBuilder(String)>
                //  245  577:aload_1         
                //  246  578:invokevirtual   #163 <Method rm.core.Dimension Assignment.getDimensionX()>
                //  247  581:invokevirtual   #166 <Method String rm.core.Dimension.getName()>
                //  248  584:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  249  587:ldc1            #194 <String " omitted]\n">
                //  250  589:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  251  592:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  252  595:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  253  598:pop             
                        }
                        outBuff.append((new StringBuilder(String.valueOf(ass.getDimensionY().getName()))).append(":    ").append(ass.getDimensionY().getDimensionAttribute().numValues()).append('\n').toString());
                //  254  599:aload_3         
                //  255  600:new             #92  <Class StringBuilder>
                //  256  603:dup             
                //  257  604:aload_1         
                //  258  605:invokevirtual   #197 <Method rm.core.Dimension Assignment.getDimensionY()>
                //  259  608:invokevirtual   #166 <Method String rm.core.Dimension.getName()>
                //  260  611:invokestatic    #96  <Method String String.valueOf(Object)>
                //  261  614:invokespecial   #97  <Method void StringBuilder(String)>
                //  262  617:ldc1            #168 <String ":    ">
                //  263  619:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  264  622:aload_1         
                //  265  623:invokevirtual   #197 <Method rm.core.Dimension Assignment.getDimensionY()>
                //  266  626:invokevirtual   #172 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
                //  267  629:invokevirtual   #177 <Method int Attribute.numValues()>
                //  268  632:invokevirtual   #180 <Method StringBuilder StringBuilder.append(int)>
                //  269  635:bipush          10
                //  270  637:invokevirtual   #159 <Method StringBuilder StringBuilder.append(char)>
                //  271  640:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  272  643:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  273  646:pop             
                        Object dy[] = ass.getDimensionY().getDimensionAttribute().toArray();
                //  274  647:aload_1         
                //  275  648:invokevirtual   #197 <Method rm.core.Dimension Assignment.getDimensionY()>
                //  276  651:invokevirtual   #172 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
                //  277  654:invokevirtual   #184 <Method Object[] Attribute.toArray()>
                //  278  657:astore          8
                        if(dy.length < 100)
                //* 279  659:aload           8
                //* 280  661:arraylength     
                //* 281  662:bipush          100
                //* 282  664:icmpge          739
                        {
                            for(int i = 0; i < dy.length; i++)
                //* 283  667:iconst_0        
                //* 284  668:istore          9
                //* 285  670:goto            721
                            {
                                outBuff.append((new StringBuilder(" ")).append(dy[i]).toString());
                //  286  673:aload_3         
                //  287  674:new             #92  <Class StringBuilder>
                //  288  677:dup             
                //  289  678:ldc1            #118 <String " ">
                //  290  680:invokespecial   #97  <Method void StringBuilder(String)>
                //  291  683:aload           8
                //  292  685:iload           9
                //  293  687:aaload          
                //  294  688:invokevirtual   #187 <Method StringBuilder StringBuilder.append(Object)>
                //  295  691:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  296  694:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  297  697:pop             
                                if(i % 12 == 0 && i != 0)
                //* 298  698:iload           9
                //* 299  700:bipush          12
                //* 300  702:irem            
                //* 301  703:ifne            718
                //* 302  706:iload           9
                //* 303  708:ifeq            718
                                    outBuff.append('\n');
                //  304  711:aload_3         
                //  305  712:bipush          10
                //  306  714:invokevirtual   #190 <Method StringBuffer StringBuffer.append(char)>
                //  307  717:pop             
                            }

                //  308  718:iinc            9  1
                //  309  721:iload           9
                //  310  723:aload           8
                //  311  725:arraylength     
                //  312  726:icmplt          673
                            outBuff.append('\n');
                //  313  729:aload_3         
                //  314  730:bipush          10
                //  315  732:invokevirtual   #190 <Method StringBuffer StringBuffer.append(char)>
                //  316  735:pop             
                        } else
                //* 317  736:goto            771
                        {
                            outBuff.append((new StringBuilder("  [list of ")).append(ass.getDimensionY().getName()).append(" omitted]\n").toString());
                //  318  739:aload_3         
                //  319  740:new             #92  <Class StringBuilder>
                //  320  743:dup             
                //  321  744:ldc1            #192 <String "  [list of ">
                //  322  746:invokespecial   #97  <Method void StringBuilder(String)>
                //  323  749:aload_1         
                //  324  750:invokevirtual   #197 <Method rm.core.Dimension Assignment.getDimensionY()>
                //  325  753:invokevirtual   #166 <Method String rm.core.Dimension.getName()>
                //  326  756:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  327  759:ldc1            #194 <String " omitted]\n">
                //  328  761:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  329  764:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  330  767:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  331  770:pop             
                        }
                        m_History.addResult(name, outBuff);
                //  332  771:aload_0         
                //  333  772:getfield        #11  <Field RoleminerPanel this$0>
                //  334  775:getfield        #201 <Field ResultHistoryPanel RoleminerPanel.m_History>
                //  335  778:aload           4
                //  336  780:aload_3         
                //  337  781:invokevirtual   #207 <Method void ResultHistoryPanel.addResult(String, StringBuffer)>
                        m_History.setSingle(name);
                //  338  784:aload_0         
                //  339  785:getfield        #11  <Field RoleminerPanel this$0>
                //  340  788:getfield        #201 <Field ResultHistoryPanel RoleminerPanel.m_History>
                //  341  791:aload           4
                //  342  793:invokevirtual   #210 <Method void ResultHistoryPanel.setSingle(String)>
                        m_Log.statusMessage("Building model on upa data...");
                //  343  796:aload_0         
                //  344  797:getfield        #11  <Field RoleminerPanel this$0>
                //  345  800:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  346  803:ldc1            #212 <String "Building model on upa data...">
                //  347  805:invokeinterface #33  <Method void Logger.statusMessage(String)>
                        long startTime = System.currentTimeMillis();
                //  348  810:invokestatic    #218 <Method long System.currentTimeMillis()>
                //  349  813:lstore          9
                        System.out.println(miner.toString());
                //  350  815:getstatic       #222 <Field PrintStream System.out>
                //  351  818:aload_2         
                //  352  819:invokevirtual   #223 <Method String Object.toString()>
                //  353  822:invokevirtual   #228 <Method void PrintStream.println(String)>
                        miner.buildRoleminers(ass);
                //  354  825:aload_2         
                //  355  826:aload_1         
                //  356  827:invokeinterface #231 <Method void Roleminer.buildRoleminers(Assignment)>
                        long endTime = System.currentTimeMillis();
                //  357  832:invokestatic    #218 <Method long System.currentTimeMillis()>
                //  358  835:lstore          11
                        outBuff.append("===  model (full upa set) ===\n\n");
                //  359  837:aload_3         
                //  360  838:ldc1            #233 <String "===  model (full upa set) ===\n\n">
                //  361  840:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  362  843:pop             
                        outBuff.append((new StringBuilder(String.valueOf(miner.toString()))).append('\n').toString());
                //  363  844:aload_3         
                //  364  845:new             #92  <Class StringBuilder>
                //  365  848:dup             
                //  366  849:aload_2         
                //  367  850:invokevirtual   #223 <Method String Object.toString()>
                //  368  853:invokestatic    #96  <Method String String.valueOf(Object)>
                //  369  856:invokespecial   #97  <Method void StringBuilder(String)>
                //  370  859:bipush          10
                //  371  861:invokevirtual   #159 <Method StringBuilder StringBuilder.append(char)>
                //  372  864:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  373  867:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  374  870:pop             
                        outBuff.append("\n=== Evaluation ===\n\n");
                //  375  871:aload_3         
                //  376  872:ldc1            #235 <String "\n=== Evaluation ===\n\n">
                //  377  874:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  378  877:pop             
                        Option option;
                        for(Enumeration enm = ((OptionHandler)miner).listOptions(); enm.hasMoreElements(); outBuff.append((new StringBuilder(String.valueOf(option.description()))).append("\n").toString()))
                //* 379  878:aload_2         
                //* 380  879:checkcast       #116 <Class OptionHandler>
                //* 381  882:invokeinterface #239 <Method Enumeration OptionHandler.listOptions()>
                //* 382  887:astore          13
                //* 383  889:goto            963
                        {
                            option = (Option)(Option)enm.nextElement();
                //  384  892:aload           13
                //  385  894:invokeinterface #244 <Method Object Enumeration.nextElement()>
                //  386  899:checkcast       #246 <Class Option>
                //  387  902:checkcast       #246 <Class Option>
                //  388  905:astore          14
                            outBuff.append((new StringBuilder(String.valueOf(option.synopsis()))).append("\n").toString());
                //  389  907:aload_3         
                //  390  908:new             #92  <Class StringBuilder>
                //  391  911:dup             
                //  392  912:aload           14
                //  393  914:invokevirtual   #249 <Method String Option.synopsis()>
                //  394  917:invokestatic    #96  <Method String String.valueOf(Object)>
                //  395  920:invokespecial   #97  <Method void StringBuilder(String)>
                //  396  923:ldc1            #151 <String "\n">
                //  397  925:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  398  928:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  399  931:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  400  934:pop             
                        }

                //  401  935:aload_3         
                //  402  936:new             #92  <Class StringBuilder>
                //  403  939:dup             
                //  404  940:aload           14
                //  405  942:invokevirtual   #252 <Method String Option.description()>
                //  406  945:invokestatic    #96  <Method String String.valueOf(Object)>
                //  407  948:invokespecial   #97  <Method void StringBuilder(String)>
                //  408  951:ldc1            #151 <String "\n">
                //  409  953:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  410  956:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  411  959:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  412  962:pop             
                //  413  963:aload           13
                //  414  965:invokeinterface #256 <Method boolean Enumeration.hasMoreElements()>
                //  415  970:ifne            892
                        outBuff.append("\n\n");
                //  416  973:aload_3         
                //  417  974:ldc2            #258 <String "\n\n">
                //  418  977:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  419  980:pop             
                        outBuff.append((new StringBuilder("Elapsed time: ")).append(endTime - startTime).append(" milliseconds").toString());
                //  420  981:aload_3         
                //  421  982:new             #92  <Class StringBuilder>
                //  422  985:dup             
                //  423  986:ldc2            #260 <String "Elapsed time: ">
                //  424  989:invokespecial   #97  <Method void StringBuilder(String)>
                //  425  992:lload           11
                //  426  994:lload           9
                //  427  996:lsub            
                //  428  997:l2d             
                //  429  998:invokevirtual   #263 <Method StringBuilder StringBuilder.append(double)>
                //  430 1001:ldc2            #265 <String " milliseconds">
                //  431 1004:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  432 1007:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  433 1010:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  434 1013:pop             
                        outBuff.append("\n");
                //  435 1014:aload_3         
                //  436 1015:ldc1            #151 <String "\n">
                //  437 1017:invokevirtual   #145 <Method StringBuffer StringBuffer.append(String)>
                //  438 1020:pop             
                        m_assroles = miner.generateRoles();
                //  439 1021:aload_0         
                //  440 1022:getfield        #11  <Field RoleminerPanel this$0>
                //  441 1025:aload_2         
                //  442 1026:invokeinterface #269 <Method Assignment Roleminer.generateRoles()>
                //  443 1031:putfield        #272 <Field Assignment RoleminerPanel.m_assroles>
                        if(m_assroles != null)
                //* 444 1034:aload_0         
                //* 445 1035:getfield        #11  <Field RoleminerPanel this$0>
                //* 446 1038:getfield        #272 <Field Assignment RoleminerPanel.m_assroles>
                //* 447 1041:ifnull          1055
                            m_AccuracyBut.setEnabled(true);
                //  448 1044:aload_0         
                //  449 1045:getfield        #11  <Field RoleminerPanel this$0>
                //  450 1048:getfield        #276 <Field JButton RoleminerPanel.m_AccuracyBut>
                //  451 1051:iconst_1        
                //  452 1052:invokevirtual   #282 <Method void JButton.setEnabled(boolean)>
                        m_Tabbedpane.setRoles();
                //  453 1055:aload_0         
                //  454 1056:getfield        #11  <Field RoleminerPanel this$0>
                //  455 1059:getfield        #286 <Field TabbedPane RoleminerPanel.m_Tabbedpane>
                //  456 1062:invokevirtual   #291 <Method void TabbedPane.setRoles()>
                        m_History.updateResult(name);
                //  457 1065:aload_0         
                //  458 1066:getfield        #11  <Field RoleminerPanel this$0>
                //  459 1069:getfield        #201 <Field ResultHistoryPanel RoleminerPanel.m_History>
                //  460 1072:aload           4
                //  461 1074:invokevirtual   #294 <Method void ResultHistoryPanel.updateResult(String)>
                        m_Log.logMessage((new StringBuilder("Finished ")).append(cname).toString());
                //  462 1077:aload_0         
                //  463 1078:getfield        #11  <Field RoleminerPanel this$0>
                //  464 1081:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  465 1084:new             #92  <Class StringBuilder>
                //  466 1087:dup             
                //  467 1088:ldc2            #296 <String "Finished ">
                //  468 1091:invokespecial   #97  <Method void StringBuilder(String)>
                //  469 1094:aload           5
                //  470 1096:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  471 1099:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  472 1102:invokeinterface #133 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("OK");
                //  473 1107:aload_0         
                //  474 1108:getfield        #11  <Field RoleminerPanel this$0>
                //  475 1111:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  476 1114:ldc2            #298 <String "OK">
                //  477 1117:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                //* 478 1122:goto            1277
                    catch(Exception ex)
                //* 479 1125:astore          7
                    {
                        m_Log.logMessage(ex.getMessage());
                //  480 1127:aload_0         
                //  481 1128:getfield        #11  <Field RoleminerPanel this$0>
                //  482 1131:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  483 1134:aload           7
                //  484 1136:invokevirtual   #303 <Method String Exception.getMessage()>
                //  485 1139:invokeinterface #133 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("See error log");
                //  486 1144:aload_0         
                //  487 1145:getfield        #11  <Field RoleminerPanel this$0>
                //  488 1148:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  489 1151:ldc2            #305 <String "See error log">
                //  490 1154:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                    break MISSING_BLOCK_LABEL_1277;
                //  491 1159:goto            1277
                    Exception exception;
                    exception;
                //  492 1162:astore          15
                    if(isInterrupted())
                //* 493 1164:aload_0         
                //* 494 1165:invokevirtual   #308 <Method boolean isInterrupted()>
                //* 495 1168:ifeq            1216
                    {
                        m_Log.logMessage((new StringBuilder("Interrupted ")).append(cname).toString());
                //  496 1171:aload_0         
                //  497 1172:getfield        #11  <Field RoleminerPanel this$0>
                //  498 1175:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  499 1178:new             #92  <Class StringBuilder>
                //  500 1181:dup             
                //  501 1182:ldc2            #310 <String "Interrupted ">
                //  502 1185:invokespecial   #97  <Method void StringBuilder(String)>
                //  503 1188:aload           5
                //  504 1190:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  505 1193:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  506 1196:invokeinterface #133 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("See error log");
                //  507 1201:aload_0         
                //  508 1202:getfield        #11  <Field RoleminerPanel this$0>
                //  509 1205:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  510 1208:ldc2            #305 <String "See error log">
                //  511 1211:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                    m_RunThread = null;
                //  512 1216:aload_0         
                //  513 1217:getfield        #11  <Field RoleminerPanel this$0>
                //  514 1220:aconst_null     
                //  515 1221:putfield        #314 <Field Thread RoleminerPanel.m_RunThread>
                    m_StartBut.setEnabled(true);
                //  516 1224:aload_0         
                //  517 1225:getfield        #11  <Field RoleminerPanel this$0>
                //  518 1228:getfield        #317 <Field JButton RoleminerPanel.m_StartBut>
                //  519 1231:iconst_1        
                //  520 1232:invokevirtual   #282 <Method void JButton.setEnabled(boolean)>
                    m_StopBut.setEnabled(false);
                //  521 1235:aload_0         
                //  522 1236:getfield        #11  <Field RoleminerPanel this$0>
                //  523 1239:getfield        #320 <Field JButton RoleminerPanel.m_StopBut>
                //  524 1242:iconst_0        
                //  525 1243:invokevirtual   #282 <Method void JButton.setEnabled(boolean)>
                    if(m_Log instanceof TaskLogger)
                //* 526 1246:aload_0         
                //* 527 1247:getfield        #11  <Field RoleminerPanel this$0>
                //* 528 1250:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //* 529 1253:instanceof      #137 <Class TaskLogger>
                //* 530 1256:ifeq            1274
                        ((TaskLogger)m_Log).taskFinished();
                //  531 1259:aload_0         
                //  532 1260:getfield        #11  <Field RoleminerPanel this$0>
                //  533 1263:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  534 1266:checkcast       #137 <Class TaskLogger>
                //  535 1269:invokeinterface #323 <Method void TaskLogger.taskFinished()>
                    throw exception;
                //  536 1274:aload           15
                //  537 1276:athrow          
                    if(isInterrupted())
                //* 538 1277:aload_0         
                //* 539 1278:invokevirtual   #308 <Method boolean isInterrupted()>
                //* 540 1281:ifeq            1329
                    {
                        m_Log.logMessage((new StringBuilder("Interrupted ")).append(cname).toString());
                //  541 1284:aload_0         
                //  542 1285:getfield        #11  <Field RoleminerPanel this$0>
                //  543 1288:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  544 1291:new             #92  <Class StringBuilder>
                //  545 1294:dup             
                //  546 1295:ldc2            #310 <String "Interrupted ">
                //  547 1298:invokespecial   #97  <Method void StringBuilder(String)>
                //  548 1301:aload           5
                //  549 1303:invokevirtual   #111 <Method StringBuilder StringBuilder.append(String)>
                //  550 1306:invokevirtual   #114 <Method String StringBuilder.toString()>
                //  551 1309:invokeinterface #133 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("See error log");
                //  552 1314:aload_0         
                //  553 1315:getfield        #11  <Field RoleminerPanel this$0>
                //  554 1318:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  555 1321:ldc2            #305 <String "See error log">
                //  556 1324:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                    m_RunThread = null;
                //  557 1329:aload_0         
                //  558 1330:getfield        #11  <Field RoleminerPanel this$0>
                //  559 1333:aconst_null     
                //  560 1334:putfield        #314 <Field Thread RoleminerPanel.m_RunThread>
                    m_StartBut.setEnabled(true);
                //  561 1337:aload_0         
                //  562 1338:getfield        #11  <Field RoleminerPanel this$0>
                //  563 1341:getfield        #317 <Field JButton RoleminerPanel.m_StartBut>
                //  564 1344:iconst_1        
                //  565 1345:invokevirtual   #282 <Method void JButton.setEnabled(boolean)>
                    m_StopBut.setEnabled(false);
                //  566 1348:aload_0         
                //  567 1349:getfield        #11  <Field RoleminerPanel this$0>
                //  568 1352:getfield        #320 <Field JButton RoleminerPanel.m_StopBut>
                //  569 1355:iconst_0        
                //  570 1356:invokevirtual   #282 <Method void JButton.setEnabled(boolean)>
                    if(m_Log instanceof TaskLogger)
                //* 571 1359:aload_0         
                //* 572 1360:getfield        #11  <Field RoleminerPanel this$0>
                //* 573 1363:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //* 574 1366:instanceof      #137 <Class TaskLogger>
                //* 575 1369:ifeq            1387
                        ((TaskLogger)m_Log).taskFinished();
                //  576 1372:aload_0         
                //  577 1373:getfield        #11  <Field RoleminerPanel this$0>
                //  578 1376:getfield        #25  <Field Logger RoleminerPanel.m_Log>
                //  579 1379:checkcast       #137 <Class TaskLogger>
                //  580 1382:invokeinterface #323 <Method void TaskLogger.taskFinished()>
                    return;
                //  581 1387:return          
                }

                final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void Thread()>
            //    5    9:return          
            }
            }
;
    //   11   23:aload_0         
    //   12   24:new             #335 <Class RoleminerPanel$8>
    //   13   27:dup             
    //   14   28:aload_0         
    //   15   29:invokespecial   #336 <Method void RoleminerPanel$8(RoleminerPanel)>
    //   16   32:putfield        #333 <Field Thread m_RunThread>
            m_RunThread.setPriority(1);
    //   17   35:aload_0         
    //   18   36:getfield        #333 <Field Thread m_RunThread>
    //   19   39:iconst_1        
    //   20   40:invokevirtual   #342 <Method void Thread.setPriority(int)>
            m_RunThread.start();
    //   21   43:aload_0         
    //   22   44:getfield        #333 <Field Thread m_RunThread>
    //   23   47:invokevirtual   #345 <Method void Thread.start()>
        }
    //   24   50:return          
    }

    protected void stopRoleminer()
    {
        if(m_RunThread != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #333 <Field Thread m_RunThread>
    //*   2    4:ifnull          21
        {
            m_RunThread.interrupt();
    //    3    7:aload_0         
    //    4    8:getfield        #333 <Field Thread m_RunThread>
    //    5   11:invokevirtual   #349 <Method void Thread.interrupt()>
            m_RunThread.stop();
    //    6   14:aload_0         
    //    7   15:getfield        #333 <Field Thread m_RunThread>
    //    8   18:invokevirtual   #352 <Method void Thread.stop()>
        }
    //    9   21:return          
    }

    public void setAssignments(Assignment assign)
    {
        m_Assignment = assign;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #356 <Field Assignment m_Assignment>
        m_StartBut.setEnabled(m_RunThread == null);
    //    3    5:aload_0         
    //    4    6:getfield        #114 <Field JButton m_StartBut>
    //    5    9:aload_0         
    //    6   10:getfield        #333 <Field Thread m_RunThread>
    //    7   13:ifnonnull       20
    //    8   16:iconst_1        
    //    9   17:goto            21
    //   10   20:iconst_0        
    //   11   21:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
        m_StopBut.setEnabled(m_RunThread != null);
    //   12   24:aload_0         
    //   13   25:getfield        #118 <Field JButton m_StopBut>
    //   14   28:aload_0         
    //   15   29:getfield        #333 <Field Thread m_RunThread>
    //   16   32:ifnull          39
    //   17   35:iconst_1        
    //   18   36:goto            40
    //   19   39:iconst_0        
    //   20   40:invokevirtual   #210 <Method void JButton.setEnabled(boolean)>
    //   21   43:return          
    }

    public Assignment getRoles()
    {
        return m_assroles;
    //    0    0:aload_0         
    //    1    1:getfield        #361 <Field Assignment m_assroles>
    //    2    4:areturn         
    }

    protected void historyRightClickPopup(String name, int x, int y)
    {
        final String selectedName = name;
    //    0    0:aload_1         
    //    1    1:astore          4
        JPopupMenu resultListMenu = new JPopupMenu();
    //    2    3:new             #364 <Class JPopupMenu>
    //    3    6:dup             
    //    4    7:invokespecial   #365 <Method void JPopupMenu()>
    //    5   10:astore          5
        JMenuItem visMainBuffer = new JMenuItem("View in main window");
    //    6   12:new             #367 <Class JMenuItem>
    //    7   15:dup             
    //    8   16:ldc2            #369 <String "View in main window">
    //    9   19:invokespecial   #370 <Method void JMenuItem(String)>
    //   10   22:astore          6
        if(selectedName != null)
    //*  11   24:aload           4
    //*  12   26:ifnull          47
            visMainBuffer.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_History.setSingle(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field RoleminerPanel this$0>
                //    2    4:getfield        #32  <Field ResultHistoryPanel RoleminerPanel.m_History>
                //    3    7:aload_0         
                //    4    8:getfield        #17  <Field String val$selectedName>
                //    5   11:invokevirtual   #38  <Method void ResultHistoryPanel.setSingle(String)>
                //    6   14:return          
                }

                final RoleminerPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field RoleminerPanel this$0>
                selectedName = s;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field String val$selectedName>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
);
    //   13   29:aload           6
    //   14   31:new             #372 <Class RoleminerPanel$9>
    //   15   34:dup             
    //   16   35:aload_0         
    //   17   36:aload           4
    //   18   38:invokespecial   #375 <Method void RoleminerPanel$9(RoleminerPanel, String)>
    //   19   41:invokevirtual   #376 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  20   44:goto            53
            visMainBuffer.setEnabled(false);
    //   21   47:aload           6
    //   22   49:iconst_0        
    //   23   50:invokevirtual   #377 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(visMainBuffer);
    //   24   53:aload           5
    //   25   55:aload           6
    //   26   57:invokevirtual   #380 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   27   60:pop             
        JMenuItem visSepBuffer = new JMenuItem("View in separate window");
    //   28   61:new             #367 <Class JMenuItem>
    //   29   64:dup             
    //   30   65:ldc2            #382 <String "View in separate window">
    //   31   68:invokespecial   #370 <Method void JMenuItem(String)>
    //   32   71:astore          7
        if(selectedName != null)
    //*  33   73:aload           4
    //*  34   75:ifnull          96
            visSepBuffer.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_History.openFrame(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field RoleminerPanel this$0>
                //    2    4:getfield        #32  <Field ResultHistoryPanel RoleminerPanel.m_History>
                //    3    7:aload_0         
                //    4    8:getfield        #17  <Field String val$selectedName>
                //    5   11:invokevirtual   #38  <Method void ResultHistoryPanel.openFrame(String)>
                //    6   14:return          
                }

                final RoleminerPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field RoleminerPanel this$0>
                selectedName = s;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field String val$selectedName>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
);
    //   35   78:aload           7
    //   36   80:new             #384 <Class RoleminerPanel$10>
    //   37   83:dup             
    //   38   84:aload_0         
    //   39   85:aload           4
    //   40   87:invokespecial   #385 <Method void RoleminerPanel$10(RoleminerPanel, String)>
    //   41   90:invokevirtual   #376 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  42   93:goto            102
            visSepBuffer.setEnabled(false);
    //   43   96:aload           7
    //   44   98:iconst_0        
    //   45   99:invokevirtual   #377 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(visSepBuffer);
    //   46  102:aload           5
    //   47  104:aload           7
    //   48  106:invokevirtual   #380 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   49  109:pop             
        JMenuItem saveOutput = new JMenuItem("Save result buffer");
    //   50  110:new             #367 <Class JMenuItem>
    //   51  113:dup             
    //   52  114:ldc2            #387 <String "Save result buffer">
    //   53  117:invokespecial   #370 <Method void JMenuItem(String)>
    //   54  120:astore          8
        if(selectedName != null)
    //*  55  122:aload           4
    //*  56  124:ifnull          145
            saveOutput.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    saveBuffer(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field RoleminerPanel this$0>
                //    2    4:aload_0         
                //    3    5:getfield        #17  <Field String val$selectedName>
                //    4    8:invokevirtual   #32  <Method void RoleminerPanel.saveBuffer(String)>
                //    5   11:return          
                }

                final RoleminerPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field RoleminerPanel this$0>
                selectedName = s;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field String val$selectedName>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
);
    //   57  127:aload           8
    //   58  129:new             #389 <Class RoleminerPanel$11>
    //   59  132:dup             
    //   60  133:aload_0         
    //   61  134:aload           4
    //   62  136:invokespecial   #390 <Method void RoleminerPanel$11(RoleminerPanel, String)>
    //   63  139:invokevirtual   #376 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  64  142:goto            151
            saveOutput.setEnabled(false);
    //   65  145:aload           8
    //   66  147:iconst_0        
    //   67  148:invokevirtual   #377 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(saveOutput);
    //   68  151:aload           5
    //   69  153:aload           8
    //   70  155:invokevirtual   #380 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   71  158:pop             
        JMenuItem deleteOutput = new JMenuItem("Delete result buffer");
    //   72  159:new             #367 <Class JMenuItem>
    //   73  162:dup             
    //   74  163:ldc2            #392 <String "Delete result buffer">
    //   75  166:invokespecial   #370 <Method void JMenuItem(String)>
    //   76  169:astore          9
        if(selectedName != null)
    //*  77  171:aload           4
    //*  78  173:ifnull          194
            deleteOutput.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_History.removeResult(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field RoleminerPanel this$0>
                //    2    4:getfield        #32  <Field ResultHistoryPanel RoleminerPanel.m_History>
                //    3    7:aload_0         
                //    4    8:getfield        #17  <Field String val$selectedName>
                //    5   11:invokevirtual   #38  <Method void ResultHistoryPanel.removeResult(String)>
                //    6   14:return          
                }

                final RoleminerPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field RoleminerPanel this$0>
                selectedName = s;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field String val$selectedName>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
);
    //   79  176:aload           9
    //   80  178:new             #394 <Class RoleminerPanel$12>
    //   81  181:dup             
    //   82  182:aload_0         
    //   83  183:aload           4
    //   84  185:invokespecial   #395 <Method void RoleminerPanel$12(RoleminerPanel, String)>
    //   85  188:invokevirtual   #376 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  86  191:goto            200
            deleteOutput.setEnabled(false);
    //   87  194:aload           9
    //   88  196:iconst_0        
    //   89  197:invokevirtual   #377 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(deleteOutput);
    //   90  200:aload           5
    //   91  202:aload           9
    //   92  204:invokevirtual   #380 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   93  207:pop             
        JMenuItem saveRoles = new JMenuItem("Save generate roles as a file");
    //   94  208:new             #367 <Class JMenuItem>
    //   95  211:dup             
    //   96  212:ldc2            #397 <String "Save generate roles as a file">
    //   97  215:invokespecial   #370 <Method void JMenuItem(String)>
    //   98  218:astore          10
        if(selectedName != null)
    //*  99  220:aload           4
    //* 100  222:ifnull          241
            saveRoles.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    saveRoles();
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field RoleminerPanel this$0>
                //    2    4:invokestatic    #27  <Method void RoleminerPanel.access$0(RoleminerPanel)>
                //    3    7:return          
                }

                final RoleminerPanel this$0;

            
            {
                this$0 = RoleminerPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleminerPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
            }
);
    //  101  225:aload           10
    //  102  227:new             #399 <Class RoleminerPanel$13>
    //  103  230:dup             
    //  104  231:aload_0         
    //  105  232:invokespecial   #400 <Method void RoleminerPanel$13(RoleminerPanel)>
    //  106  235:invokevirtual   #376 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //* 107  238:goto            247
            saveRoles.setEnabled(false);
    //  108  241:aload           10
    //  109  243:iconst_0        
    //  110  244:invokevirtual   #377 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(saveRoles);
    //  111  247:aload           5
    //  112  249:aload           10
    //  113  251:invokevirtual   #380 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  114  254:pop             
        resultListMenu.show(m_History.getList(), x, y);
    //  115  255:aload           5
    //  116  257:aload_0         
    //  117  258:getfield        #101 <Field ResultHistoryPanel m_History>
    //  118  261:invokevirtual   #173 <Method JList ResultHistoryPanel.getList()>
    //  119  264:iload_2         
    //  120  265:iload_3         
    //  121  266:invokevirtual   #404 <Method void JPopupMenu.show(java.awt.Component, int, int)>
    //  122  269:return          
    }

    protected void saveBuffer(String name)
    {
        StringBuffer sb = m_History.getNamedBuffer(name);
    //    0    0:aload_0         
    //    1    1:getfield        #101 <Field ResultHistoryPanel m_History>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #422 <Method StringBuffer ResultHistoryPanel.getNamedBuffer(String)>
    //    4    8:astore_2        
        if(sb != null && m_SaveOut.save(sb))
    //*   5    9:aload_2         
    //*   6   10:ifnull          36
    //*   7   13:aload_0         
    //*   8   14:getfield        #125 <Field SaveBuffer m_SaveOut>
    //*   9   17:aload_2         
    //*  10   18:invokevirtual   #426 <Method boolean SaveBuffer.save(StringBuffer)>
    //*  11   21:ifeq            36
            m_Log.logMessage("Save successful.");
    //   12   24:aload_0         
    //   13   25:getfield        #94  <Field Logger m_Log>
    //   14   28:ldc2            #428 <String "Save successful.">
    //   15   31:invokeinterface #433 <Method void Logger.logMessage(String)>
    //   16   36:return          
    }

    public JPanel getJPanel()
    {
        return this;
    //    0    0:aload_0         
    //    1    1:areturn         
    }

    public void setExplorer(Explorer parent)
    {
        m_Explorer = parent;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #52  <Field Explorer m_Explorer>
    //    3    5:return          
    }

    public Explorer getExplorer()
    {
        return m_Explorer;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field Explorer m_Explorer>
    //    2    4:areturn         
    }

    public String getTabTitle()
    {
        return "RoleMiner";
    //    0    0:ldc1            #222 <String "RoleMiner">
    //    1    2:areturn         
    }

    public String getTabTitleToolTip()
    {
        return "Generate Roles";
    //    0    0:ldc2            #446 <String "Generate Roles">
    //    1    3:areturn         
    }

    public void setTabbedPane(TabbedPane parent)
    {
        m_Tabbedpane = parent;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #54  <Field TabbedPane m_Tabbedpane>
    //    3    5:return          
    }

    private void saveRoles()
    {
        m_Log.statusMessage("Saving to file...");
    //    0    0:aload_0         
    //    1    1:getfield        #94  <Field Logger m_Log>
    //    2    4:ldc2            #450 <String "Saving to file...">
    //    3    7:invokeinterface #453 <Method void Logger.statusMessage(String)>
        m_FileChooser.setDialogTitle("Save Assignment File");
    //    4   12:aload_0         
    //    5   13:getfield        #72  <Field ConverterFileChooser m_FileChooser>
    //    6   16:ldc2            #455 <String "Save Assignment File">
    //    7   19:invokevirtual   #458 <Method void ConverterFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //    8   22:aload_0         
    //    9   23:getfield        #72  <Field ConverterFileChooser m_FileChooser>
    //   10   26:new             #58  <Class File>
    //   11   29:dup             
    //   12   30:ldc2            #460 <String "user.dir">
    //   13   33:invokestatic    #466 <Method String System.getProperty(String)>
    //   14   36:invokespecial   #67  <Method void File(String)>
    //   15   39:invokevirtual   #469 <Method void ConverterFileChooser.setCurrentDirectory(File)>
        int returnVal = m_FileChooser.showSaveDialog(this);
    //   16   42:aload_0         
    //   17   43:getfield        #72  <Field ConverterFileChooser m_FileChooser>
    //   18   46:aload_0         
    //   19   47:invokevirtual   #473 <Method int ConverterFileChooser.showSaveDialog(java.awt.Component)>
    //   20   50:istore_1        
        if(returnVal == 0)
    //*  21   51:iload_1         
    //*  22   52:ifne            105
        {
            Assignment newAssignment = new Assignment(m_assroles);
    //   23   55:new             #475 <Class Assignment>
    //   24   58:dup             
    //   25   59:aload_0         
    //   26   60:getfield        #361 <Field Assignment m_assroles>
    //   27   63:invokespecial   #477 <Method void Assignment(Assignment)>
    //   28   66:astore_2        
            try
            {
                FileWriter fw = new FileWriter(m_FileChooser.getSelectedFile());
    //   29   67:new             #479 <Class FileWriter>
    //   30   70:dup             
    //   31   71:aload_0         
    //   32   72:getfield        #72  <Field ConverterFileChooser m_FileChooser>
    //   33   75:invokevirtual   #483 <Method File ConverterFileChooser.getSelectedFile()>
    //   34   78:invokespecial   #484 <Method void FileWriter(File)>
    //   35   81:astore_3        
                fw.write(newAssignment.toString());
    //   36   82:aload_3         
    //   37   83:aload_2         
    //   38   84:invokevirtual   #487 <Method String Assignment.toString()>
    //   39   87:invokevirtual   #490 <Method void FileWriter.write(String)>
                fw.close();
    //   40   90:aload_3         
    //   41   91:invokevirtual   #493 <Method void FileWriter.close()>
            }
    //*  42   94:goto            116
            catch(Exception e)
    //*  43   97:astore_3        
            {
                e.printStackTrace();
    //   44   98:aload_3         
    //   45   99:invokevirtual   #498 <Method void Exception.printStackTrace()>
            }
        } else
    //*  46  102:goto            116
        {
            JOptionPane.showMessageDialog(this, "Can't save at this time,\ncurrently busy with other IO", "Saving assingment", 2);
    //   47  105:aload_0         
    //   48  106:ldc2            #500 <String "Can't save at this time,\ncurrently busy with other IO">
    //   49  109:ldc2            #502 <String "Saving assingment">
    //   50  112:iconst_2        
    //   51  113:invokestatic    #508 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   52  116:return          
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("RMiner Explorer: RoleMiner");
    //    0    0:new             #518 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc2            #520 <String "RMiner Explorer: RoleMiner">
    //    3    7:invokespecial   #521 <Method void JFrame(String)>
    //    4   10:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   11:aload_1         
    //    6   12:invokevirtual   #525 <Method Container JFrame.getContentPane()>
    //    7   15:new             #229 <Class BorderLayout>
    //    8   18:dup             
    //    9   19:invokespecial   #230 <Method void BorderLayout()>
    //   10   22:invokevirtual   #528 <Method void Container.setLayout(java.awt.LayoutManager)>
            RoleminerPanel sp = new RoleminerPanel();
    //   11   25:new             #2   <Class RoleminerPanel>
    //   12   28:dup             
    //   13   29:invokespecial   #529 <Method void RoleminerPanel()>
    //   14   32:astore_2        
            jf.getContentPane().add(sp, "Center");
    //   15   33:aload_1         
    //   16   34:invokevirtual   #525 <Method Container JFrame.getContentPane()>
    //   17   37:aload_2         
    //   18   38:ldc1            #236 <String "Center">
    //   19   40:invokevirtual   #530 <Method void Container.add(java.awt.Component, Object)>
            LogPanel lp = new LogPanel();
    //   20   43:new             #532 <Class LogPanel>
    //   21   46:dup             
    //   22   47:invokespecial   #533 <Method void LogPanel()>
    //   23   50:astore_3        
            jf.getContentPane().add(lp, "South");
    //   24   51:aload_1         
    //   25   52:invokevirtual   #525 <Method Container JFrame.getContentPane()>
    //   26   55:aload_3         
    //   27   56:ldc2            #535 <String "South">
    //   28   59:invokevirtual   #530 <Method void Container.add(java.awt.Component, Object)>
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
    //   29   62:aload_1         
    //   30   63:new             #537 <Class RoleminerPanel$14>
    //   31   66:dup             
    //   32   67:aload_1         
    //   33   68:invokespecial   #540 <Method void RoleminerPanel$14(JFrame)>
    //   34   71:invokevirtual   #544 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   35   74:aload_1         
    //   36   75:invokevirtual   #547 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   37   78:aload_1         
    //   38   79:iconst_1        
    //   39   80:invokevirtual   #550 <Method void JFrame.setVisible(boolean)>
            if(args.length == 1)
    //*  40   83:aload_0         
    //*  41   84:arraylength     
    //*  42   85:iconst_1        
    //*  43   86:icmpne          162
            {
                System.err.println((new StringBuilder("Loading instances from ")).append(args[0]).toString());
    //   44   89:getstatic       #554 <Field PrintStream System.err>
    //   45   92:new             #556 <Class StringBuilder>
    //   46   95:dup             
    //   47   96:ldc2            #558 <String "Loading instances from ">
    //   48   99:invokespecial   #559 <Method void StringBuilder(String)>
    //   49  102:aload_0         
    //   50  103:iconst_0        
    //   51  104:aaload          
    //   52  105:invokevirtual   #563 <Method StringBuilder StringBuilder.append(String)>
    //   53  108:invokevirtual   #564 <Method String StringBuilder.toString()>
    //   54  111:invokevirtual   #569 <Method void PrintStream.println(String)>
                java.io.Reader r = new BufferedReader(new FileReader(args[0]));
    //   55  114:new             #571 <Class BufferedReader>
    //   56  117:dup             
    //   57  118:new             #573 <Class FileReader>
    //   58  121:dup             
    //   59  122:aload_0         
    //   60  123:iconst_0        
    //   61  124:aaload          
    //   62  125:invokespecial   #574 <Method void FileReader(String)>
    //   63  128:invokespecial   #577 <Method void BufferedReader(java.io.Reader)>
    //   64  131:astore          4
                Instances i = new Instances(r);
    //   65  133:new             #579 <Class Instances>
    //   66  136:dup             
    //   67  137:aload           4
    //   68  139:invokespecial   #580 <Method void Instances(java.io.Reader)>
    //   69  142:astore          5
            }
        }
    //*  70  144:goto            162
        catch(Exception ex)
    //*  71  147:astore_1        
        {
            ex.printStackTrace();
    //   72  148:aload_1         
    //   73  149:invokevirtual   #498 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   74  152:getstatic       #554 <Field PrintStream System.err>
    //   75  155:aload_1         
    //   76  156:invokevirtual   #583 <Method String Exception.getMessage()>
    //   77  159:invokevirtual   #569 <Method void PrintStream.println(String)>
        }
    //   78  162:return          
    }

    protected Explorer m_Explorer;
    protected TabbedPane m_Tabbedpane;
    protected ConverterFileChooser m_FileChooser;
    protected GenericObjectEditor m_RoleMinerEditor;
    protected PropertyPanel m_CEPanel;
    protected JTextArea m_OutText;
    protected Logger m_Log;
    protected ResultHistoryPanel m_History;
    protected JButton m_AccuracyBut;
    protected AccuracyDialog dialog;
    protected JButton m_StartBut;
    protected JButton m_StopBut;
    protected SaveBuffer m_SaveOut;
    protected Assignment m_Assignment;
    protected Assignment m_assroles;
    protected Thread m_RunThread;
    static Class class$0;

    static 
    {
        GenericObjectEditor.registerEditors();
    //    0    0:invokestatic    #45  <Method void GenericObjectEditor.registerEditors()>
    //*   1    3:return          
    }


/*
    static void access$0(RoleminerPanel roleminerpanel)
    {
        roleminerpanel.saveRoles();
    //    0    0:aload_0         
    //    1    1:invokespecial   #598 <Method void saveRoles()>
        return;
    //    2    4:return          
    }

*/
}

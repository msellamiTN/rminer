// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   TabbedPane.java

package rm.gui.explorer;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rm.core.Assignment;
import rm.gui.LogPanel;
import rm.gui.RMinerTaskMonitor;

// Referenced classes of package rm.gui.explorer:
//            PreprocessPanel, RoleminerPanel, AssignmentPanel, About, 
//            VisualizePanel

class TabbedPane extends JFrame
{

    public TabbedPane()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #45  <Method void JFrame()>
        m_LogPanel = new LogPanel(new RMinerTaskMonitor());
    //    2    4:aload_0         
    //    3    5:new             #47  <Class LogPanel>
    //    4    8:dup             
    //    5    9:new             #49  <Class RMinerTaskMonitor>
    //    6   12:dup             
    //    7   13:invokespecial   #50  <Method void RMinerTaskMonitor()>
    //    8   16:invokespecial   #53  <Method void LogPanel(RMinerTaskMonitor)>
    //    9   19:putfield        #55  <Field LogPanel m_LogPanel>
        preprocess = new PreprocessPanel();
    //   10   22:aload_0         
    //   11   23:new             #57  <Class PreprocessPanel>
    //   12   26:dup             
    //   13   27:invokespecial   #58  <Method void PreprocessPanel()>
    //   14   30:putfield        #60  <Field PreprocessPanel preprocess>
        rolemining = new RoleminerPanel();
    //   15   33:aload_0         
    //   16   34:new             #62  <Class RoleminerPanel>
    //   17   37:dup             
    //   18   38:invokespecial   #63  <Method void RoleminerPanel()>
    //   19   41:putfield        #65  <Field RoleminerPanel rolemining>
        assignment = new AssignmentPanel();
    //   20   44:aload_0         
    //   21   45:new             #67  <Class AssignmentPanel>
    //   22   48:dup             
    //   23   49:invokespecial   #68  <Method void AssignmentPanel()>
    //   24   52:putfield        #70  <Field AssignmentPanel assignment>
        visulize = null;
    //   25   55:aload_0         
    //   26   56:aconst_null     
    //   27   57:putfield        #72  <Field VisualizePanel visulize>
        about = new About();
    //   28   60:aload_0         
    //   29   61:new             #74  <Class About>
    //   30   64:dup             
    //   31   65:invokespecial   #75  <Method void About()>
    //   32   68:putfield        #77  <Field About about>
        ico_max = new ImageIcon(getClass().getClassLoader().getResource("images/ico_max.gif"));
    //   33   71:aload_0         
    //   34   72:new             #79  <Class ImageIcon>
    //   35   75:dup             
    //   36   76:aload_0         
    //   37   77:invokevirtual   #85  <Method Class Object.getClass()>
    //   38   80:invokevirtual   #91  <Method ClassLoader Class.getClassLoader()>
    //   39   83:ldc1            #93  <String "images/ico_max.gif">
    //   40   85:invokevirtual   #99  <Method java.net.URL ClassLoader.getResource(String)>
    //   41   88:invokespecial   #102 <Method void ImageIcon(java.net.URL)>
    //   42   91:putfield        #104 <Field ImageIcon ico_max>
        ico_min = new ImageIcon(getClass().getClassLoader().getResource("images/ico_min.gif"));
    //   43   94:aload_0         
    //   44   95:new             #79  <Class ImageIcon>
    //   45   98:dup             
    //   46   99:aload_0         
    //   47  100:invokevirtual   #85  <Method Class Object.getClass()>
    //   48  103:invokevirtual   #91  <Method ClassLoader Class.getClassLoader()>
    //   49  106:ldc1            #106 <String "images/ico_min.gif">
    //   50  108:invokevirtual   #99  <Method java.net.URL ClassLoader.getResource(String)>
    //   51  111:invokespecial   #102 <Method void ImageIcon(java.net.URL)>
    //   52  114:putfield        #108 <Field ImageIcon ico_min>
        AssignData = null;
    //   53  117:aload_0         
    //   54  118:aconst_null     
    //   55  119:putfield        #110 <Field Assignment AssignData>
    //   56  122:aload_0         
    //   57  123:iconst_0        
    //   58  124:putfield        #112 <Field int flag>
        String date = (new SimpleDateFormat("EEEE, d MMMM yyyy")).format(new Date());
    //   59  127:new             #114 <Class SimpleDateFormat>
    //   60  130:dup             
    //   61  131:ldc1            #116 <String "EEEE, d MMMM yyyy">
    //   62  133:invokespecial   #119 <Method void SimpleDateFormat(String)>
    //   63  136:new             #121 <Class Date>
    //   64  139:dup             
    //   65  140:invokespecial   #122 <Method void Date()>
    //   66  143:invokevirtual   #126 <Method String SimpleDateFormat.format(Date)>
    //   67  146:astore_1        
        m_LogPanel.logMessage("RMiner Explorer");
    //   68  147:aload_0         
    //   69  148:getfield        #55  <Field LogPanel m_LogPanel>
    //   70  151:ldc1            #128 <String "RMiner Explorer">
    //   71  153:invokevirtual   #131 <Method void LogPanel.logMessage(String)>
        m_LogPanel.logMessage((new StringBuilder("Started on ")).append(date).toString());
    //   72  156:aload_0         
    //   73  157:getfield        #55  <Field LogPanel m_LogPanel>
    //   74  160:new             #133 <Class StringBuilder>
    //   75  163:dup             
    //   76  164:ldc1            #135 <String "Started on ">
    //   77  166:invokespecial   #136 <Method void StringBuilder(String)>
    //   78  169:aload_1         
    //   79  170:invokevirtual   #140 <Method StringBuilder StringBuilder.append(String)>
    //   80  173:invokevirtual   #144 <Method String StringBuilder.toString()>
    //   81  176:invokevirtual   #131 <Method void LogPanel.logMessage(String)>
        m_LogPanel.statusMessage("Welcome to the RMiner Explorer");
    //   82  179:aload_0         
    //   83  180:getfield        #55  <Field LogPanel m_LogPanel>
    //   84  183:ldc1            #146 <String "Welcome to the RMiner Explorer">
    //   85  185:invokevirtual   #149 <Method void LogPanel.statusMessage(String)>
        Toolkit tk = Toolkit.getDefaultToolkit();
    //   86  188:invokestatic    #155 <Method Toolkit Toolkit.getDefaultToolkit()>
    //   87  191:astore_2        
        setTitle("RMiner");
    //   88  192:aload_0         
    //   89  193:ldc1            #157 <String "RMiner">
    //   90  195:invokevirtual   #160 <Method void setTitle(String)>
        setSize(800, 600);
    //   91  198:aload_0         
    //   92  199:sipush          800
    //   93  202:sipush          600
    //   94  205:invokevirtual   #164 <Method void setSize(int, int)>
        java.net.URL Imagepath = getClass().getClassLoader().getResource("images/Icon.png");
    //   95  208:aload_0         
    //   96  209:invokevirtual   #85  <Method Class Object.getClass()>
    //   97  212:invokevirtual   #91  <Method ClassLoader Class.getClassLoader()>
    //   98  215:ldc1            #166 <String "images/Icon.png">
    //   99  217:invokevirtual   #99  <Method java.net.URL ClassLoader.getResource(String)>
    //  100  220:astore_3        
        java.awt.Image img = tk.getImage(Imagepath);
    //  101  221:aload_2         
    //  102  222:aload_3         
    //  103  223:invokevirtual   #170 <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //  104  226:astore          4
        setIconImage(img);
    //  105  228:aload_0         
    //  106  229:aload           4
    //  107  231:invokevirtual   #174 <Method void setIconImage(java.awt.Image)>
        tabbedPane = new JTabbedPane();
    //  108  234:aload_0         
    //  109  235:new             #176 <Class JTabbedPane>
    //  110  238:dup             
    //  111  239:invokespecial   #177 <Method void JTabbedPane()>
    //  112  242:putfield        #179 <Field JTabbedPane tabbedPane>
        tabbedPane.addTab("Preprocess", ico_max, null, "Data processing");
    //  113  245:aload_0         
    //  114  246:getfield        #179 <Field JTabbedPane tabbedPane>
    //  115  249:ldc1            #181 <String "Preprocess">
    //  116  251:aload_0         
    //  117  252:getfield        #104 <Field ImageIcon ico_max>
    //  118  255:aconst_null     
    //  119  256:ldc1            #183 <String "Data processing">
    //  120  258:invokevirtual   #187 <Method void JTabbedPane.addTab(String, javax.swing.Icon, java.awt.Component, String)>
        tabbedPane.addTab("RoleMining", ico_min, null, "Select role mining algorithm");
    //  121  261:aload_0         
    //  122  262:getfield        #179 <Field JTabbedPane tabbedPane>
    //  123  265:ldc1            #189 <String "RoleMining">
    //  124  267:aload_0         
    //  125  268:getfield        #108 <Field ImageIcon ico_min>
    //  126  271:aconst_null     
    //  127  272:ldc1            #191 <String "Select role mining algorithm">
    //  128  274:invokevirtual   #187 <Method void JTabbedPane.addTab(String, javax.swing.Icon, java.awt.Component, String)>
        tabbedPane.addTab("Assignment", ico_min, null, "Role assignment");
    //  129  277:aload_0         
    //  130  278:getfield        #179 <Field JTabbedPane tabbedPane>
    //  131  281:ldc1            #193 <String "Assignment">
    //  132  283:aload_0         
    //  133  284:getfield        #108 <Field ImageIcon ico_min>
    //  134  287:aconst_null     
    //  135  288:ldc1            #195 <String "Role assignment">
    //  136  290:invokevirtual   #187 <Method void JTabbedPane.addTab(String, javax.swing.Icon, java.awt.Component, String)>
        tabbedPane.addTab("Visualize", ico_max, null, "Visualize the result");
    //  137  293:aload_0         
    //  138  294:getfield        #179 <Field JTabbedPane tabbedPane>
    //  139  297:ldc1            #197 <String "Visualize">
    //  140  299:aload_0         
    //  141  300:getfield        #104 <Field ImageIcon ico_max>
    //  142  303:aconst_null     
    //  143  304:ldc1            #199 <String "Visualize the result">
    //  144  306:invokevirtual   #187 <Method void JTabbedPane.addTab(String, javax.swing.Icon, java.awt.Component, String)>
        tabbedPane.addTab("About", ico_max, null, "About RMiner");
    //  145  309:aload_0         
    //  146  310:getfield        #179 <Field JTabbedPane tabbedPane>
    //  147  313:ldc1            #201 <String "About">
    //  148  315:aload_0         
    //  149  316:getfield        #104 <Field ImageIcon ico_max>
    //  150  319:aconst_null     
    //  151  320:ldc1            #203 <String "About RMiner">
    //  152  322:invokevirtual   #187 <Method void JTabbedPane.addTab(String, javax.swing.Icon, java.awt.Component, String)>
        tabbedPane.setComponentAt(4, about.getJPanel());
    //  153  325:aload_0         
    //  154  326:getfield        #179 <Field JTabbedPane tabbedPane>
    //  155  329:iconst_4        
    //  156  330:aload_0         
    //  157  331:getfield        #77  <Field About about>
    //  158  334:invokevirtual   #207 <Method javax.swing.JScrollPane About.getJPanel()>
    //  159  337:invokevirtual   #211 <Method void JTabbedPane.setComponentAt(int, java.awt.Component)>
        setTabmin(1);
    //  160  340:aload_0         
    //  161  341:iconst_1        
    //  162  342:invokevirtual   #215 <Method void setTabmin(int)>
        setTabmin(2);
    //  163  345:aload_0         
    //  164  346:iconst_2        
    //  165  347:invokevirtual   #215 <Method void setTabmin(int)>
        setTabmin(3);
    //  166  350:aload_0         
    //  167  351:iconst_3        
    //  168  352:invokevirtual   #215 <Method void setTabmin(int)>
        tabbedPane.setComponentAt(0, preprocess.getJPanel());
    //  169  355:aload_0         
    //  170  356:getfield        #179 <Field JTabbedPane tabbedPane>
    //  171  359:iconst_0        
    //  172  360:aload_0         
    //  173  361:getfield        #60  <Field PreprocessPanel preprocess>
    //  174  364:invokevirtual   #218 <Method javax.swing.JPanel PreprocessPanel.getJPanel()>
    //  175  367:invokevirtual   #211 <Method void JTabbedPane.setComponentAt(int, java.awt.Component)>
        preprocess.setLog(m_LogPanel);
    //  176  370:aload_0         
    //  177  371:getfield        #60  <Field PreprocessPanel preprocess>
    //  178  374:aload_0         
    //  179  375:getfield        #55  <Field LogPanel m_LogPanel>
    //  180  378:invokevirtual   #222 <Method void PreprocessPanel.setLog(rm.gui.Logger)>
        preprocess.setTabbedPane(this);
    //  181  381:aload_0         
    //  182  382:getfield        #60  <Field PreprocessPanel preprocess>
    //  183  385:aload_0         
    //  184  386:invokevirtual   #226 <Method void PreprocessPanel.setTabbedPane(TabbedPane)>
        rolemining.setTabbedPane(this);
    //  185  389:aload_0         
    //  186  390:getfield        #65  <Field RoleminerPanel rolemining>
    //  187  393:aload_0         
    //  188  394:invokevirtual   #227 <Method void RoleminerPanel.setTabbedPane(TabbedPane)>
        add(tabbedPane, "Center");
    //  189  397:aload_0         
    //  190  398:aload_0         
    //  191  399:getfield        #179 <Field JTabbedPane tabbedPane>
    //  192  402:ldc1            #229 <String "Center">
    //  193  404:invokevirtual   #233 <Method void add(java.awt.Component, Object)>
        tabbedPane.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent event)
            {
                int n = tabbedPane.getSelectedIndex();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field TabbedPane this$0>
            //    2    4:invokestatic    #28  <Method JTabbedPane TabbedPane.access$0(TabbedPane)>
            //    3    7:invokevirtual   #34  <Method int JTabbedPane.getSelectedIndex()>
            //    4   10:istore_2        
                String Title = tabbedPane.getTitleAt(n);
            //    5   11:aload_0         
            //    6   12:getfield        #13  <Field TabbedPane this$0>
            //    7   15:invokestatic    #28  <Method JTabbedPane TabbedPane.access$0(TabbedPane)>
            //    8   18:iload_2         
            //    9   19:invokevirtual   #38  <Method String JTabbedPane.getTitleAt(int)>
            //   10   22:astore_3        
                tabbedPane.setSelectedIndex(n);
            //   11   23:aload_0         
            //   12   24:getfield        #13  <Field TabbedPane this$0>
            //   13   27:invokestatic    #28  <Method JTabbedPane TabbedPane.access$0(TabbedPane)>
            //   14   30:iload_2         
            //   15   31:invokevirtual   #42  <Method void JTabbedPane.setSelectedIndex(int)>
                m_LogPanel.logMessage((new StringBuilder("Selected Panel : ")).append(Title).toString());
            //   16   34:aload_0         
            //   17   35:getfield        #13  <Field TabbedPane this$0>
            //   18   38:getfield        #46  <Field LogPanel TabbedPane.m_LogPanel>
            //   19   41:new             #48  <Class StringBuilder>
            //   20   44:dup             
            //   21   45:ldc1            #50  <String "Selected Panel : ">
            //   22   47:invokespecial   #53  <Method void StringBuilder(String)>
            //   23   50:aload_3         
            //   24   51:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
            //   25   54:invokevirtual   #61  <Method String StringBuilder.toString()>
            //   26   57:invokevirtual   #66  <Method void LogPanel.logMessage(String)>
            //   27   60:return          
            }

            final TabbedPane this$0;

            
            {
                this$0 = TabbedPane.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field TabbedPane this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  194  407:aload_0         
    //  195  408:getfield        #179 <Field JTabbedPane tabbedPane>
    //  196  411:new             #235 <Class TabbedPane$1>
    //  197  414:dup             
    //  198  415:aload_0         
    //  199  416:invokespecial   #237 <Method void TabbedPane$1(TabbedPane)>
    //  200  419:invokevirtual   #241 <Method void JTabbedPane.addChangeListener(ChangeListener)>
        add(m_LogPanel, "South");
    //  201  422:aload_0         
    //  202  423:aload_0         
    //  203  424:getfield        #55  <Field LogPanel m_LogPanel>
    //  204  427:ldc1            #243 <String "South">
    //  205  429:invokevirtual   #233 <Method void add(java.awt.Component, Object)>
    //  206  432:return          
    }

    public void setTabmin(int n)
    {
        tabbedPane.setEnabledAt(n, false);
    //    0    0:aload_0         
    //    1    1:getfield        #179 <Field JTabbedPane tabbedPane>
    //    2    4:iload_1         
    //    3    5:iconst_0        
    //    4    6:invokevirtual   #259 <Method void JTabbedPane.setEnabledAt(int, boolean)>
        tabbedPane.setIconAt(n, ico_min);
    //    5    9:aload_0         
    //    6   10:getfield        #179 <Field JTabbedPane tabbedPane>
    //    7   13:iload_1         
    //    8   14:aload_0         
    //    9   15:getfield        #108 <Field ImageIcon ico_min>
    //   10   18:invokevirtual   #263 <Method void JTabbedPane.setIconAt(int, javax.swing.Icon)>
    //   11   21:return          
    }

    public void setTabmax(int n)
    {
        tabbedPane.setEnabledAt(n, true);
    //    0    0:aload_0         
    //    1    1:getfield        #179 <Field JTabbedPane tabbedPane>
    //    2    4:iload_1         
    //    3    5:iconst_1        
    //    4    6:invokevirtual   #259 <Method void JTabbedPane.setEnabledAt(int, boolean)>
        tabbedPane.setIconAt(n, ico_max);
    //    5    9:aload_0         
    //    6   10:getfield        #179 <Field JTabbedPane tabbedPane>
    //    7   13:iload_1         
    //    8   14:aload_0         
    //    9   15:getfield        #104 <Field ImageIcon ico_max>
    //   10   18:invokevirtual   #263 <Method void JTabbedPane.setIconAt(int, javax.swing.Icon)>
    //   11   21:return          
    }

    public void setAllAssignment()
    {
        AssignData = preprocess.getAssignment();
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #60  <Field PreprocessPanel preprocess>
    //    3    5:invokevirtual   #270 <Method Assignment PreprocessPanel.getAssignment()>
    //    4    8:putfield        #110 <Field Assignment AssignData>
        tabbedPane.setComponentAt(1, rolemining.getJPanel());
    //    5   11:aload_0         
    //    6   12:getfield        #179 <Field JTabbedPane tabbedPane>
    //    7   15:iconst_1        
    //    8   16:aload_0         
    //    9   17:getfield        #65  <Field RoleminerPanel rolemining>
    //   10   20:invokevirtual   #271 <Method javax.swing.JPanel RoleminerPanel.getJPanel()>
    //   11   23:invokevirtual   #211 <Method void JTabbedPane.setComponentAt(int, java.awt.Component)>
        rolemining.setAssignments(AssignData);
    //   12   26:aload_0         
    //   13   27:getfield        #65  <Field RoleminerPanel rolemining>
    //   14   30:aload_0         
    //   15   31:getfield        #110 <Field Assignment AssignData>
    //   16   34:invokevirtual   #275 <Method void RoleminerPanel.setAssignments(Assignment)>
        rolemining.setLog(m_LogPanel);
    //   17   37:aload_0         
    //   18   38:getfield        #65  <Field RoleminerPanel rolemining>
    //   19   41:aload_0         
    //   20   42:getfield        #55  <Field LogPanel m_LogPanel>
    //   21   45:invokevirtual   #276 <Method void RoleminerPanel.setLog(rm.gui.Logger)>
        tabbedPane.setComponentAt(2, assignment.getJPanel());
    //   22   48:aload_0         
    //   23   49:getfield        #179 <Field JTabbedPane tabbedPane>
    //   24   52:iconst_2        
    //   25   53:aload_0         
    //   26   54:getfield        #70  <Field AssignmentPanel assignment>
    //   27   57:invokevirtual   #277 <Method javax.swing.JPanel AssignmentPanel.getJPanel()>
    //   28   60:invokevirtual   #211 <Method void JTabbedPane.setComponentAt(int, java.awt.Component)>
        assignment.setAssignments(AssignData);
    //   29   63:aload_0         
    //   30   64:getfield        #70  <Field AssignmentPanel assignment>
    //   31   67:aload_0         
    //   32   68:getfield        #110 <Field Assignment AssignData>
    //   33   71:invokevirtual   #278 <Method void AssignmentPanel.setAssignments(Assignment)>
        assignment.setLog(m_LogPanel);
    //   34   74:aload_0         
    //   35   75:getfield        #70  <Field AssignmentPanel assignment>
    //   36   78:aload_0         
    //   37   79:getfield        #55  <Field LogPanel m_LogPanel>
    //   38   82:invokevirtual   #279 <Method void AssignmentPanel.setLog(rm.gui.Logger)>
        visulize = new VisualizePanel(AssignData);
    //   39   85:aload_0         
    //   40   86:new             #281 <Class VisualizePanel>
    //   41   89:dup             
    //   42   90:aload_0         
    //   43   91:getfield        #110 <Field Assignment AssignData>
    //   44   94:invokespecial   #283 <Method void VisualizePanel(Assignment)>
    //   45   97:putfield        #72  <Field VisualizePanel visulize>
        tabbedPane.setComponentAt(3, visulize.getJPanel());
    //   46  100:aload_0         
    //   47  101:getfield        #179 <Field JTabbedPane tabbedPane>
    //   48  104:iconst_3        
    //   49  105:aload_0         
    //   50  106:getfield        #72  <Field VisualizePanel visulize>
    //   51  109:invokevirtual   #284 <Method javax.swing.JPanel VisualizePanel.getJPanel()>
    //   52  112:invokevirtual   #211 <Method void JTabbedPane.setComponentAt(int, java.awt.Component)>
        visulize.setLog(m_LogPanel);
    //   53  115:aload_0         
    //   54  116:getfield        #72  <Field VisualizePanel visulize>
    //   55  119:aload_0         
    //   56  120:getfield        #55  <Field LogPanel m_LogPanel>
    //   57  123:invokevirtual   #285 <Method void VisualizePanel.setLog(rm.gui.Logger)>
        setTabmax(1);
    //   58  126:aload_0         
    //   59  127:iconst_1        
    //   60  128:invokevirtual   #287 <Method void setTabmax(int)>
        setTabmax(2);
    //   61  131:aload_0         
    //   62  132:iconst_2        
    //   63  133:invokevirtual   #287 <Method void setTabmax(int)>
        setTabmax(3);
    //   64  136:aload_0         
    //   65  137:iconst_3        
    //   66  138:invokevirtual   #287 <Method void setTabmax(int)>
    //   67  141:return          
    }

    public void setRoles()
    {
        if(rolemining.getRoles() != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #65  <Field RoleminerPanel rolemining>
    //*   2    4:invokevirtual   #291 <Method Assignment RoleminerPanel.getRoles()>
    //*   3    7:ifnull          27
            assignment.setRoles(rolemining.getRoles());
    //    4   10:aload_0         
    //    5   11:getfield        #70  <Field AssignmentPanel assignment>
    //    6   14:aload_0         
    //    7   15:getfield        #65  <Field RoleminerPanel rolemining>
    //    8   18:invokevirtual   #291 <Method Assignment RoleminerPanel.getRoles()>
    //    9   21:invokevirtual   #293 <Method void AssignmentPanel.setRoles(Assignment)>
        else
    //*  10   24:goto            37
            m_LogPanel.logMessage("roles are not generated, please load from file.");
    //   11   27:aload_0         
    //   12   28:getfield        #55  <Field LogPanel m_LogPanel>
    //   13   31:ldc2            #295 <String "roles are not generated, please load from file.">
    //   14   34:invokevirtual   #131 <Method void LogPanel.logMessage(String)>
    //   15   37:return          
    }

    private JTabbedPane tabbedPane;
    protected LogPanel m_LogPanel;
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    public static final int PREPROCESS = 0;
    public static final int ROLEMINING = 1;
    public static final int ASSIGMENT = 2;
    public static final int VISUALIZE = 3;
    public static final int ABOUT = 4;
    public PreprocessPanel preprocess;
    public RoleminerPanel rolemining;
    public AssignmentPanel assignment;
    public VisualizePanel visulize;
    public About about;
    ImageIcon ico_max;
    ImageIcon ico_min;
    private Assignment AssignData;
    final int flag = 0;


/*
    static JTabbedPane access$0(TabbedPane tabbedpane)
    {
        return tabbedpane.tabbedPane;
    //    0    0:aload_0         
    //    1    1:getfield        #179 <Field JTabbedPane tabbedPane>
    //    2    4:areturn         
    }

*/
}

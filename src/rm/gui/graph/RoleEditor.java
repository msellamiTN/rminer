// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RoleEditor.java

package rm.gui.graph;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import rm.core.Assignment;
import rm.core.Dimension;
import rm.core.Instance;
import rm.core.Instances;
import rm.core.IntegerSet;
import rm.core.Matrix;
import rm.core.converters.AssLoader;
import rm.gui.ConverterFileChooser;
import rm.gui.explorer.ExplorerDefaults;

// Referenced classes of package rm.gui.graph:
//            RoleNodes, RoleEditorTable, FloatWindow

public class RoleEditor extends JFrame
{

    public void AddJMenu()
    {
        JMenu fileMenu = new JMenu("File");
    //    0    0:new             #41  <Class JMenu>
    //    1    3:dup             
    //    2    4:ldc1            #43  <String "File">
    //    3    6:invokespecial   #47  <Method void JMenu(String)>
    //    4    9:astore_1        
        JMenuItem openItem = new JMenuItem("Open");
    //    5   10:new             #49  <Class JMenuItem>
    //    6   13:dup             
    //    7   14:ldc1            #51  <String "Open">
    //    8   16:invokespecial   #52  <Method void JMenuItem(String)>
    //    9   19:astore_2        
        openItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                generateRoles = LoadRoleFile();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field RoleEditor this$0>
            //    2    4:aload_0         
            //    3    5:getfield        #13  <Field RoleEditor this$0>
            //    4    8:invokestatic    #28  <Method Assignment RoleEditor.access$0(RoleEditor)>
            //    5   11:invokestatic    #32  <Method void RoleEditor.access$1(RoleEditor, Assignment)>
                ComputePanelData();
            //    6   14:aload_0         
            //    7   15:getfield        #13  <Field RoleEditor this$0>
            //    8   18:invokestatic    #35  <Method void RoleEditor.access$2(RoleEditor)>
                jp.removeAll();
            //    9   21:aload_0         
            //   10   22:getfield        #13  <Field RoleEditor this$0>
            //   11   25:getfield        #39  <Field JPanel RoleEditor.jp>
            //   12   28:invokevirtual   #44  <Method void JPanel.removeAll()>
                jp.add(rtPanel, "North");
            //   13   31:aload_0         
            //   14   32:getfield        #13  <Field RoleEditor this$0>
            //   15   35:getfield        #39  <Field JPanel RoleEditor.jp>
            //   16   38:aload_0         
            //   17   39:getfield        #13  <Field RoleEditor this$0>
            //   18   42:invokestatic    #48  <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //   19   45:ldc1            #50  <String "North">
            //   20   47:invokevirtual   #54  <Method void JPanel.add(java.awt.Component, Object)>
                jp.add(BorderPanel, "South");
            //   21   50:aload_0         
            //   22   51:getfield        #13  <Field RoleEditor this$0>
            //   23   54:getfield        #39  <Field JPanel RoleEditor.jp>
            //   24   57:aload_0         
            //   25   58:getfield        #13  <Field RoleEditor this$0>
            //   26   61:getfield        #57  <Field JPanel RoleEditor.BorderPanel>
            //   27   64:ldc1            #59  <String "South">
            //   28   66:invokevirtual   #54  <Method void JPanel.add(java.awt.Component, Object)>
                sp.updateUI();
            //   29   69:aload_0         
            //   30   70:getfield        #13  <Field RoleEditor this$0>
            //   31   73:invokestatic    #63  <Method JSplitPane RoleEditor.access$4(RoleEditor)>
            //   32   76:invokevirtual   #68  <Method void JSplitPane.updateUI()>
            //   33   79:return          
            }

            final RoleEditor this$0;

            
            {
                this$0 = RoleEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleEditor this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   10   20:aload_2         
    //   11   21:new             #54  <Class RoleEditor$1>
    //   12   24:dup             
    //   13   25:aload_0         
    //   14   26:invokespecial   #57  <Method void RoleEditor$1(RoleEditor)>
    //   15   29:invokevirtual   #61  <Method void JMenuItem.addActionListener(ActionListener)>
        fileMenu.add(openItem);
    //   16   32:aload_1         
    //   17   33:aload_2         
    //   18   34:invokevirtual   #65  <Method JMenuItem JMenu.add(JMenuItem)>
    //   19   37:pop             
        JMenuItem saveMenu = new JMenuItem("Save");
    //   20   38:new             #49  <Class JMenuItem>
    //   21   41:dup             
    //   22   42:ldc1            #67  <String "Save">
    //   23   44:invokespecial   #52  <Method void JMenuItem(String)>
    //   24   47:astore_3        
        saveMenu.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                SaveRoleFile();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field RoleEditor this$0>
            //    2    4:invokestatic    #27  <Method void RoleEditor.access$5(RoleEditor)>
            //    3    7:return          
            }

            final RoleEditor this$0;

            
            {
                this$0 = RoleEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleEditor this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   25   48:aload_3         
    //   26   49:new             #69  <Class RoleEditor$2>
    //   27   52:dup             
    //   28   53:aload_0         
    //   29   54:invokespecial   #70  <Method void RoleEditor$2(RoleEditor)>
    //   30   57:invokevirtual   #61  <Method void JMenuItem.addActionListener(ActionListener)>
        fileMenu.add(saveMenu);
    //   31   60:aload_1         
    //   32   61:aload_3         
    //   33   62:invokevirtual   #65  <Method JMenuItem JMenu.add(JMenuItem)>
    //   34   65:pop             
        JMenuItem exitItem = new JMenuItem("Exit");
    //   35   66:new             #49  <Class JMenuItem>
    //   36   69:dup             
    //   37   70:ldc1            #72  <String "Exit">
    //   38   72:invokespecial   #52  <Method void JMenuItem(String)>
    //   39   75:astore          4
        exitItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            //    0    0:iconst_0        
            //    1    1:invokestatic    #28  <Method void System.exit(int)>
            //    2    4:return          
            }

            final RoleEditor this$0;

            
            {
                this$0 = RoleEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleEditor this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   40   77:aload           4
    //   41   79:new             #74  <Class RoleEditor$3>
    //   42   82:dup             
    //   43   83:aload_0         
    //   44   84:invokespecial   #75  <Method void RoleEditor$3(RoleEditor)>
    //   45   87:invokevirtual   #61  <Method void JMenuItem.addActionListener(ActionListener)>
        fileMenu.add(exitItem);
    //   46   90:aload_1         
    //   47   91:aload           4
    //   48   93:invokevirtual   #65  <Method JMenuItem JMenu.add(JMenuItem)>
    //   49   96:pop             
        JMenuBar menuBar = new JMenuBar();
    //   50   97:new             #77  <Class JMenuBar>
    //   51  100:dup             
    //   52  101:invokespecial   #79  <Method void JMenuBar()>
    //   53  104:astore          5
        menuBar.add(fileMenu);
    //   54  106:aload           5
    //   55  108:aload_1         
    //   56  109:invokevirtual   #82  <Method JMenu JMenuBar.add(JMenu)>
    //   57  112:pop             
        setJMenuBar(menuBar);
    //   58  113:aload_0         
    //   59  114:aload           5
    //   60  116:invokevirtual   #86  <Method void setJMenuBar(JMenuBar)>
    //   61  119:return          
    }

    public RoleEditor(Assignment AssData)
    {
        super("Role Editor");
    //    0    0:aload_0         
    //    1    1:ldc1            #101 <String "Role Editor">
    //    2    3:invokespecial   #102 <Method void JFrame(String)>
    //    3    6:aload_0         
    //    4    7:new             #104 <Class JPanel>
    //    5   10:dup             
    //    6   11:invokespecial   #105 <Method void JPanel()>
    //    7   14:putfield        #107 <Field JPanel jp>
    //    8   17:aload_0         
    //    9   18:new             #109 <Class mxGraph>
    //   10   21:dup             
    //   11   22:invokespecial   #110 <Method void mxGraph()>
    //   12   25:putfield        #112 <Field mxGraph rt>
        hasFloatWindow = false;
    //   13   28:aload_0         
    //   14   29:iconst_0        
    //   15   30:putfield        #114 <Field boolean hasFloatWindow>
    //   16   33:aload_0         
    //   17   34:new             #104 <Class JPanel>
    //   18   37:dup             
    //   19   38:invokespecial   #105 <Method void JPanel()>
    //   20   41:putfield        #116 <Field JPanel BorderPanel>
        AddJMenu();
    //   21   44:aload_0         
    //   22   45:invokevirtual   #118 <Method void AddJMenu()>
        Toolkit tk = Toolkit.getDefaultToolkit();
    //   23   48:invokestatic    #124 <Method Toolkit Toolkit.getDefaultToolkit()>
    //   24   51:astore_2        
        java.net.URL Imagepath = getClass().getClassLoader().getResource("images/Icon.png");
    //   25   52:aload_0         
    //   26   53:invokevirtual   #130 <Method Class Object.getClass()>
    //   27   56:invokevirtual   #136 <Method ClassLoader Class.getClassLoader()>
    //   28   59:ldc1            #138 <String "images/Icon.png">
    //   29   61:invokevirtual   #144 <Method java.net.URL ClassLoader.getResource(String)>
    //   30   64:astore_3        
        java.awt.Image img = tk.getImage(Imagepath);
    //   31   65:aload_2         
    //   32   66:aload_3         
    //   33   67:invokevirtual   #148 <Method java.awt.Image Toolkit.getImage(java.net.URL)>
    //   34   70:astore          4
        setIconImage(img);
    //   35   72:aload_0         
    //   36   73:aload           4
    //   37   75:invokevirtual   #152 <Method void setIconImage(java.awt.Image)>
        generateRoles = AssData;
    //   38   78:aload_0         
    //   39   79:aload_1         
    //   40   80:putfield        #154 <Field Assignment generateRoles>
        graphComponent = new mxGraphComponent(rt);
    //   41   83:aload_0         
    //   42   84:new             #156 <Class mxGraphComponent>
    //   43   87:dup             
    //   44   88:aload_0         
    //   45   89:getfield        #112 <Field mxGraph rt>
    //   46   92:invokespecial   #159 <Method void mxGraphComponent(mxGraph)>
    //   47   95:putfield        #161 <Field mxGraphComponent graphComponent>
        ComputePanelData();
    //   48   98:aload_0         
    //   49   99:invokespecial   #164 <Method void ComputePanelData()>
        setAllPanel();
    //   50  102:aload_0         
    //   51  103:invokespecial   #167 <Method void setAllPanel()>
    //   52  106:return          
    }

    private void setAllPanel()
    {
        JScrollPane roleStructure = new JScrollPane(graphComponent);
    //    0    0:new             #176 <Class JScrollPane>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #161 <Field mxGraphComponent graphComponent>
    //    4    8:invokespecial   #179 <Method void JScrollPane(java.awt.Component)>
    //    5   11:astore_1        
        jp.setLayout(new BorderLayout());
    //    6   12:aload_0         
    //    7   13:getfield        #107 <Field JPanel jp>
    //    8   16:new             #181 <Class BorderLayout>
    //    9   19:dup             
    //   10   20:invokespecial   #182 <Method void BorderLayout()>
    //   11   23:invokevirtual   #186 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        jp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("role-permission"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
    //   12   26:aload_0         
    //   13   27:getfield        #107 <Field JPanel jp>
    //   14   30:ldc1            #188 <String "role-permission">
    //   15   32:invokestatic    #194 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   16   35:iconst_0        
    //   17   36:iconst_5        
    //   18   37:iconst_5        
    //   19   38:iconst_5        
    //   20   39:invokestatic    #198 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   21   42:invokestatic    #202 <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //   22   45:invokevirtual   #206 <Method void JPanel.setBorder(javax.swing.border.Border)>
        BorderPanel.setLayout(new FlowLayout());
    //   23   48:aload_0         
    //   24   49:getfield        #116 <Field JPanel BorderPanel>
    //   25   52:new             #208 <Class FlowLayout>
    //   26   55:dup             
    //   27   56:invokespecial   #209 <Method void FlowLayout()>
    //   28   59:invokevirtual   #186 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JLabel left = new JLabel();
    //   29   62:new             #211 <Class JLabel>
    //   30   65:dup             
    //   31   66:invokespecial   #212 <Method void JLabel()>
    //   32   69:astore_2        
        BorderPanel.add(left);
    //   33   70:aload_0         
    //   34   71:getfield        #116 <Field JPanel BorderPanel>
    //   35   74:aload_2         
    //   36   75:invokevirtual   #215 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   37   78:pop             
        JPanel buttonPanel = new JPanel();
    //   38   79:new             #104 <Class JPanel>
    //   39   82:dup             
    //   40   83:invokespecial   #105 <Method void JPanel()>
    //   41   86:astore_3        
        GridBagLayout gb = new GridBagLayout();
    //   42   87:new             #217 <Class GridBagLayout>
    //   43   90:dup             
    //   44   91:invokespecial   #218 <Method void GridBagLayout()>
    //   45   94:astore          4
        buttonPanel.setLayout(gb);
    //   46   96:aload_3         
    //   47   97:aload           4
    //   48   99:invokevirtual   #186 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        GridBagConstraints gbC = new GridBagConstraints();
    //   49  102:new             #220 <Class GridBagConstraints>
    //   50  105:dup             
    //   51  106:invokespecial   #221 <Method void GridBagConstraints()>
    //   52  109:astore          5
        gbC.gridy = 1;
    //   53  111:aload           5
    //   54  113:iconst_1        
    //   55  114:putfield        #224 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //   56  117:aload           5
    //   57  119:iconst_0        
    //   58  120:putfield        #227 <Field int GridBagConstraints.gridx>
        gbC.anchor = 13;
    //   59  123:aload           5
    //   60  125:bipush          13
    //   61  127:putfield        #230 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //   62  130:aload           5
    //   63  132:iconst_2        
    //   64  133:putfield        #233 <Field int GridBagConstraints.fill>
        JButton m_RefreshBut = new JButton("Refresh");
    //   65  136:new             #235 <Class JButton>
    //   66  139:dup             
    //   67  140:ldc1            #237 <String "Refresh">
    //   68  142:invokespecial   #238 <Method void JButton(String)>
    //   69  145:astore          6
        gb.setConstraints(m_RefreshBut, gbC);
    //   70  147:aload           4
    //   71  149:aload           6
    //   72  151:aload           5
    //   73  153:invokevirtual   #242 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        buttonPanel.add(m_RefreshBut);
    //   74  156:aload_3         
    //   75  157:aload           6
    //   76  159:invokevirtual   #215 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   77  162:pop             
        gbC = new GridBagConstraints();
    //   78  163:new             #220 <Class GridBagConstraints>
    //   79  166:dup             
    //   80  167:invokespecial   #221 <Method void GridBagConstraints()>
    //   81  170:astore          5
        gbC.gridy = 1;
    //   82  172:aload           5
    //   83  174:iconst_1        
    //   84  175:putfield        #224 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //   85  178:aload           5
    //   86  180:iconst_1        
    //   87  181:putfield        #227 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //   88  184:aload           5
    //   89  186:bipush          17
    //   90  188:putfield        #230 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //   91  191:aload           5
    //   92  193:iconst_2        
    //   93  194:putfield        #233 <Field int GridBagConstraints.fill>
        final JButton m_FloatBut = new JButton("AddFloatingBox");
    //   94  197:new             #235 <Class JButton>
    //   95  200:dup             
    //   96  201:ldc1            #244 <String "AddFloatingBox">
    //   97  203:invokespecial   #238 <Method void JButton(String)>
    //   98  206:astore          7
        gb.setConstraints(m_FloatBut, gbC);
    //   99  208:aload           4
    //  100  210:aload           7
    //  101  212:aload           5
    //  102  214:invokevirtual   #242 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        buttonPanel.add(m_FloatBut);
    //  103  217:aload_3         
    //  104  218:aload           7
    //  105  220:invokevirtual   #215 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  106  223:pop             
        BorderPanel.add(buttonPanel);
    //  107  224:aload_0         
    //  108  225:getfield        #116 <Field JPanel BorderPanel>
    //  109  228:aload_3         
    //  110  229:invokevirtual   #215 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  111  232:pop             
        JLabel right = new JLabel();
    //  112  233:new             #211 <Class JLabel>
    //  113  236:dup             
    //  114  237:invokespecial   #212 <Method void JLabel()>
    //  115  240:astore          8
        BorderPanel.add(right);
    //  116  242:aload_0         
    //  117  243:getfield        #116 <Field JPanel BorderPanel>
    //  118  246:aload           8
    //  119  248:invokevirtual   #215 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  120  251:pop             
        jp.add(rtPanel, "Center");
    //  121  252:aload_0         
    //  122  253:getfield        #107 <Field JPanel jp>
    //  123  256:aload_0         
    //  124  257:getfield        #246 <Field RoleEditorTable rtPanel>
    //  125  260:ldc1            #248 <String "Center">
    //  126  262:invokevirtual   #251 <Method void JPanel.add(java.awt.Component, Object)>
        jp.add(BorderPanel, "South");
    //  127  265:aload_0         
    //  128  266:getfield        #107 <Field JPanel jp>
    //  129  269:aload_0         
    //  130  270:getfield        #116 <Field JPanel BorderPanel>
    //  131  273:ldc1            #253 <String "South">
    //  132  275:invokevirtual   #251 <Method void JPanel.add(java.awt.Component, Object)>
        sp = new JSplitPane(1, roleStructure, jp);
    //  133  278:aload_0         
    //  134  279:new             #255 <Class JSplitPane>
    //  135  282:dup             
    //  136  283:iconst_1        
    //  137  284:aload_1         
    //  138  285:aload_0         
    //  139  286:getfield        #107 <Field JPanel jp>
    //  140  289:invokespecial   #258 <Method void JSplitPane(int, java.awt.Component, java.awt.Component)>
    //  141  292:putfield        #260 <Field JSplitPane sp>
        sp.setContinuousLayout(true);
    //  142  295:aload_0         
    //  143  296:getfield        #260 <Field JSplitPane sp>
    //  144  299:iconst_1        
    //  145  300:invokevirtual   #264 <Method void JSplitPane.setContinuousLayout(boolean)>
        sp.setOneTouchExpandable(true);
    //  146  303:aload_0         
    //  147  304:getfield        #260 <Field JSplitPane sp>
    //  148  307:iconst_1        
    //  149  308:invokevirtual   #267 <Method void JSplitPane.setOneTouchExpandable(boolean)>
        sp.setResizeWeight(0.5D);
    //  150  311:aload_0         
    //  151  312:getfield        #260 <Field JSplitPane sp>
    //  152  315:ldc2w           #268 <Double 0.5D>
    //  153  318:invokevirtual   #273 <Method void JSplitPane.setResizeWeight(double)>
        sp.setDividerSize(6);
    //  154  321:aload_0         
    //  155  322:getfield        #260 <Field JSplitPane sp>
    //  156  325:bipush          6
    //  157  327:invokevirtual   #277 <Method void JSplitPane.setDividerSize(int)>
        getContentPane().add(sp, "Center");
    //  158  330:aload_0         
    //  159  331:invokevirtual   #281 <Method Container getContentPane()>
    //  160  334:aload_0         
    //  161  335:getfield        #260 <Field JSplitPane sp>
    //  162  338:ldc1            #248 <String "Center">
    //  163  340:invokevirtual   #284 <Method void Container.add(java.awt.Component, Object)>
        m_FloatBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                if(!hasFloatWindow)
            //*   0    0:aload_0         
            //*   1    1:getfield        #15  <Field RoleEditor this$0>
            //*   2    4:invokestatic    #32  <Method boolean RoleEditor.access$6(RoleEditor)>
            //*   3    7:ifne            30
                {
                    m_FloatBut.setText("MvFloatingBox");
            //    4   10:aload_0         
            //    5   11:getfield        #17  <Field JButton val$m_FloatBut>
            //    6   14:ldc1            #34  <String "MvFloatingBox">
            //    7   16:invokevirtual   #40  <Method void JButton.setText(String)>
                    hasFloatWindow = true;
            //    8   19:aload_0         
            //    9   20:getfield        #15  <Field RoleEditor this$0>
            //   10   23:iconst_1        
            //   11   24:invokestatic    #44  <Method void RoleEditor.access$7(RoleEditor, boolean)>
                } else
            //*  12   27:goto            47
                {
                    m_FloatBut.setText("AddFloatingBox");
            //   13   30:aload_0         
            //   14   31:getfield        #17  <Field JButton val$m_FloatBut>
            //   15   34:ldc1            #46  <String "AddFloatingBox">
            //   16   36:invokevirtual   #40  <Method void JButton.setText(String)>
                    hasFloatWindow = false;
            //   17   39:aload_0         
            //   18   40:getfield        #15  <Field RoleEditor this$0>
            //   19   43:iconst_0        
            //   20   44:invokestatic    #44  <Method void RoleEditor.access$7(RoleEditor, boolean)>
                }
            //   21   47:return          
            }

            final RoleEditor this$0;
            private final JButton val$m_FloatBut;

            
            {
                this$0 = RoleEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field RoleEditor this$0>
                m_FloatBut = jbutton;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field JButton val$m_FloatBut>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
        }
);
    //  164  343:aload           7
    //  165  345:new             #286 <Class RoleEditor$4>
    //  166  348:dup             
    //  167  349:aload_0         
    //  168  350:aload           7
    //  169  352:invokespecial   #289 <Method void RoleEditor$4(RoleEditor, JButton)>
    //  170  355:invokevirtual   #290 <Method void JButton.addActionListener(ActionListener)>
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e)
            {
                mxCell SelectedCell = (mxCell)graphComponent.getCellAt(e.getX(), e.getY());
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field RoleEditor this$0>
            //    2    4:invokestatic    #26  <Method mxGraphComponent RoleEditor.access$8(RoleEditor)>
            //    3    7:aload_1         
            //    4    8:invokevirtual   #32  <Method int MouseEvent.getX()>
            //    5   11:aload_1         
            //    6   12:invokevirtual   #35  <Method int MouseEvent.getY()>
            //    7   15:invokevirtual   #41  <Method Object mxGraphComponent.getCellAt(int, int)>
            //    8   18:checkcast       #43  <Class mxCell>
            //    9   21:astore_2        
                if(SelectedCell != null && SelectedCell.isVertex())
            //*  10   22:aload_2         
            //*  11   23:ifnull          251
            //*  12   26:aload_2         
            //*  13   27:invokevirtual   #47  <Method boolean mxCell.isVertex()>
            //*  14   30:ifeq            251
                {
                    String selectedVertex = SelectedCell.getValue().toString();
            //   15   33:aload_2         
            //   16   34:invokevirtual   #51  <Method Object mxCell.getValue()>
            //   17   37:invokevirtual   #57  <Method String Object.toString()>
            //   18   40:astore_3        
                    if(hasFloatWindow)
            //*  19   41:aload_0         
            //*  20   42:getfield        #11  <Field RoleEditor this$0>
            //*  21   45:invokestatic    #61  <Method boolean RoleEditor.access$6(RoleEditor)>
            //*  22   48:ifeq            240
                    {
                        RoleNodes.RNode nodes[] = rData.getNodes();
            //   23   51:aload_0         
            //   24   52:getfield        #11  <Field RoleEditor this$0>
            //   25   55:invokestatic    #65  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   26   58:invokevirtual   #71  <Method RoleNodes$RNode[] RoleNodes.getNodes()>
            //   27   61:astore          4
                        int i = -1;
            //   28   63:iconst_m1       
            //   29   64:istore          5
                        for(i = 0; i < nodes.length; i++)
            //*  30   66:iconst_0        
            //*  31   67:istore          5
            //*  32   69:goto            93
                            if(nodes[i].RoleName.equals(selectedVertex))
            //*  33   72:aload           4
            //*  34   74:iload           5
            //*  35   76:aaload          
            //*  36   77:getfield        #77  <Field String RoleNodes$RNode.RoleName>
            //*  37   80:aload_3         
            //*  38   81:invokevirtual   #83  <Method boolean String.equals(Object)>
            //*  39   84:ifeq            90
                                break;
            //   40   87:goto            101

            //   41   90:iinc            5  1
            //   42   93:iload           5
            //   43   95:aload           4
            //   44   97:arraylength     
            //   45   98:icmplt          72
                        String txt = (new StringBuilder("Weight: ")).append(nodes[i].weight).append("\n").toString();
            //   46  101:new             #85  <Class StringBuilder>
            //   47  104:dup             
            //   48  105:ldc1            #87  <String "Weight: ">
            //   49  107:invokespecial   #90  <Method void StringBuilder(String)>
            //   50  110:aload           4
            //   51  112:iload           5
            //   52  114:aaload          
            //   53  115:getfield        #94  <Field double RoleNodes$RNode.weight>
            //   54  118:invokevirtual   #98  <Method StringBuilder StringBuilder.append(double)>
            //   55  121:ldc1            #100 <String "\n">
            //   56  123:invokevirtual   #103 <Method StringBuilder StringBuilder.append(String)>
            //   57  126:invokevirtual   #104 <Method String StringBuilder.toString()>
            //   58  129:astore          6
                        txt = (new StringBuilder(String.valueOf(txt))).append("Perms: ").append(nodes[i].SelfPerms.getSize()).append("\n").toString();
            //   59  131:new             #85  <Class StringBuilder>
            //   60  134:dup             
            //   61  135:aload           6
            //   62  137:invokestatic    #108 <Method String String.valueOf(Object)>
            //   63  140:invokespecial   #90  <Method void StringBuilder(String)>
            //   64  143:ldc1            #110 <String "Perms: ">
            //   65  145:invokevirtual   #103 <Method StringBuilder StringBuilder.append(String)>
            //   66  148:aload           4
            //   67  150:iload           5
            //   68  152:aaload          
            //   69  153:getfield        #114 <Field IntegerSet RoleNodes$RNode.SelfPerms>
            //   70  156:invokevirtual   #119 <Method int IntegerSet.getSize()>
            //   71  159:invokevirtual   #122 <Method StringBuilder StringBuilder.append(int)>
            //   72  162:ldc1            #100 <String "\n">
            //   73  164:invokevirtual   #103 <Method StringBuilder StringBuilder.append(String)>
            //   74  167:invokevirtual   #104 <Method String StringBuilder.toString()>
            //   75  170:astore          6
                        txt = (new StringBuilder(String.valueOf(txt))).append("       ").append(rData.PermstoString(nodes[i].SelfPerms)).toString();
            //   76  172:new             #85  <Class StringBuilder>
            //   77  175:dup             
            //   78  176:aload           6
            //   79  178:invokestatic    #108 <Method String String.valueOf(Object)>
            //   80  181:invokespecial   #90  <Method void StringBuilder(String)>
            //   81  184:ldc1            #124 <String "       ">
            //   82  186:invokevirtual   #103 <Method StringBuilder StringBuilder.append(String)>
            //   83  189:aload_0         
            //   84  190:getfield        #11  <Field RoleEditor this$0>
            //   85  193:invokestatic    #65  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   86  196:aload           4
            //   87  198:iload           5
            //   88  200:aaload          
            //   89  201:getfield        #114 <Field IntegerSet RoleNodes$RNode.SelfPerms>
            //   90  204:invokevirtual   #128 <Method String RoleNodes.PermstoString(IntegerSet)>
            //   91  207:invokevirtual   #103 <Method StringBuilder StringBuilder.append(String)>
            //   92  210:invokevirtual   #104 <Method String StringBuilder.toString()>
            //   93  213:astore          6
                        FloatWindow details = new FloatWindow();
            //   94  215:new             #130 <Class FloatWindow>
            //   95  218:dup             
            //   96  219:invokespecial   #131 <Method void FloatWindow()>
            //   97  222:astore          7
                        details.setToolTip(e.getX(), e.getY(), selectedVertex, txt);
            //   98  224:aload           7
            //   99  226:aload_1         
            //  100  227:invokevirtual   #32  <Method int MouseEvent.getX()>
            //  101  230:aload_1         
            //  102  231:invokevirtual   #35  <Method int MouseEvent.getY()>
            //  103  234:aload_3         
            //  104  235:aload           6
            //  105  237:invokevirtual   #135 <Method void FloatWindow.setToolTip(int, int, String, String)>
                    }
                    rtPanel.setChoosed(selectedVertex);
            //  106  240:aload_0         
            //  107  241:getfield        #11  <Field RoleEditor this$0>
            //  108  244:invokestatic    #139 <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //  109  247:aload_3         
            //  110  248:invokevirtual   #144 <Method void RoleEditorTable.setChoosed(String)>
                }
            //  111  251:return          
            }

            final RoleEditor this$0;

            
            {
                this$0 = RoleEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field RoleEditor this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //  171  358:aload_0         
    //  172  359:getfield        #161 <Field mxGraphComponent graphComponent>
    //  173  362:invokevirtual   #294 <Method com.mxgraph.swing.mxGraphComponent$mxGraphControl mxGraphComponent.getGraphControl()>
    //  174  365:new             #296 <Class RoleEditor$5>
    //  175  368:dup             
    //  176  369:aload_0         
    //  177  370:invokespecial   #297 <Method void RoleEditor$5(RoleEditor)>
    //  178  373:invokevirtual   #303 <Method void com.mxgraph.swing.mxGraphComponent$mxGraphControl.addMouseListener(java.awt.event.MouseListener)>
        m_RefreshBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                if(rtPanel.haveChaged == 1)
            //*   0    0:aload_0         
            //*   1    1:getfield        #13  <Field RoleEditor this$0>
            //*   2    4:invokestatic    #28  <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //*   3    7:getfield        #34  <Field int RoleEditorTable.haveChaged>
            //*   4   10:iconst_1        
            //*   5   11:icmpne          146
                {
                    RoleNodes.RNode nodes[] = rtPanel.getNodes();
            //    6   14:aload_0         
            //    7   15:getfield        #13  <Field RoleEditor this$0>
            //    8   18:invokestatic    #28  <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //    9   21:invokevirtual   #38  <Method RoleNodes$RNode[] RoleEditorTable.getNodes()>
            //   10   24:astore_2        
                    rData.setNodes(nodes);
            //   11   25:aload_0         
            //   12   26:getfield        #13  <Field RoleEditor this$0>
            //   13   29:invokestatic    #42  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   14   32:aload_2         
            //   15   33:invokevirtual   #48  <Method void RoleNodes.setNodes(RoleNodes$RNode[])>
                    rData.resetParents(nodes);
            //   16   36:aload_0         
            //   17   37:getfield        #13  <Field RoleEditor this$0>
            //   18   40:invokestatic    #42  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   19   43:aload_2         
            //   20   44:invokevirtual   #51  <Method void RoleNodes.resetParents(RoleNodes$RNode[])>
                    rData.computeLocation(nodes);
            //   21   47:aload_0         
            //   22   48:getfield        #13  <Field RoleEditor this$0>
            //   23   51:invokestatic    #42  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   24   54:aload_2         
            //   25   55:invokevirtual   #54  <Method void RoleNodes.computeLocation(RoleNodes$RNode[])>
                    rtPanel.setNodes(nodes);
            //   26   58:aload_0         
            //   27   59:getfield        #13  <Field RoleEditor this$0>
            //   28   62:invokestatic    #28  <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //   29   65:aload_2         
            //   30   66:invokevirtual   #55  <Method void RoleEditorTable.setNodes(RoleNodes$RNode[])>
                    rtPanel.setUPATable();
            //   31   69:aload_0         
            //   32   70:getfield        #13  <Field RoleEditor this$0>
            //   33   73:invokestatic    #28  <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //   34   76:invokevirtual   #58  <Method void RoleEditorTable.setUPATable()>
                    rtPanel.setPane();
            //   35   79:aload_0         
            //   36   80:getfield        #13  <Field RoleEditor this$0>
            //   37   83:invokestatic    #28  <Method RoleEditorTable RoleEditor.access$3(RoleEditor)>
            //   38   86:invokevirtual   #61  <Method void RoleEditorTable.setPane()>
                    jp.updateUI();
            //   39   89:aload_0         
            //   40   90:getfield        #13  <Field RoleEditor this$0>
            //   41   93:getfield        #65  <Field JPanel RoleEditor.jp>
            //   42   96:invokevirtual   #70  <Method void JPanel.updateUI()>
                    graphComponent.repaint();
            //   43   99:aload_0         
            //   44  100:getfield        #13  <Field RoleEditor this$0>
            //   45  103:invokestatic    #74  <Method mxGraphComponent RoleEditor.access$8(RoleEditor)>
            //   46  106:invokevirtual   #79  <Method void mxGraphComponent.repaint()>
                    graphComponent.setGraph(genRolestructure(rData.getNodes(), rData.getN_Roles()));
            //   47  109:aload_0         
            //   48  110:getfield        #13  <Field RoleEditor this$0>
            //   49  113:invokestatic    #74  <Method mxGraphComponent RoleEditor.access$8(RoleEditor)>
            //   50  116:aload_0         
            //   51  117:getfield        #13  <Field RoleEditor this$0>
            //   52  120:aload_0         
            //   53  121:getfield        #13  <Field RoleEditor this$0>
            //   54  124:invokestatic    #42  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   55  127:invokevirtual   #80  <Method RoleNodes$RNode[] RoleNodes.getNodes()>
            //   56  130:aload_0         
            //   57  131:getfield        #13  <Field RoleEditor this$0>
            //   58  134:invokestatic    #42  <Method RoleNodes RoleEditor.access$9(RoleEditor)>
            //   59  137:invokevirtual   #84  <Method int RoleNodes.getN_Roles()>
            //   60  140:invokestatic    #88  <Method mxGraph RoleEditor.access$10(RoleEditor, RoleNodes$RNode[], int)>
            //   61  143:invokevirtual   #92  <Method void mxGraphComponent.setGraph(mxGraph)>
                }
            //   62  146:return          
            }

            final RoleEditor this$0;

            
            {
                this$0 = RoleEditor.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleEditor this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  179  376:aload           6
    //  180  378:new             #305 <Class RoleEditor$6>
    //  181  381:dup             
    //  182  382:aload_0         
    //  183  383:invokespecial   #306 <Method void RoleEditor$6(RoleEditor)>
    //  184  386:invokevirtual   #290 <Method void JButton.addActionListener(ActionListener)>
    //  185  389:return          
    }

    private void ComputePanelData()
    {
        rData = new RoleNodes(generateRoles);
    //    0    0:aload_0         
    //    1    1:new             #321 <Class RoleNodes>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:getfield        #154 <Field Assignment generateRoles>
    //    5    9:invokespecial   #323 <Method void RoleNodes(Assignment)>
    //    6   12:putfield        #325 <Field RoleNodes rData>
        int nRoles = rData.getN_Roles();
    //    7   15:aload_0         
    //    8   16:getfield        #325 <Field RoleNodes rData>
    //    9   19:invokevirtual   #329 <Method int RoleNodes.getN_Roles()>
    //   10   22:istore_1        
        RoleNodes.RNode nodes[] = rData.getNodes();
    //   11   23:aload_0         
    //   12   24:getfield        #325 <Field RoleNodes rData>
    //   13   27:invokevirtual   #333 <Method RoleNodes$RNode[] RoleNodes.getNodes()>
    //   14   30:astore_2        
        rData.computeLocation(rData.getNodes());
    //   15   31:aload_0         
    //   16   32:getfield        #325 <Field RoleNodes rData>
    //   17   35:aload_0         
    //   18   36:getfield        #325 <Field RoleNodes rData>
    //   19   39:invokevirtual   #333 <Method RoleNodes$RNode[] RoleNodes.getNodes()>
    //   20   42:invokevirtual   #337 <Method void RoleNodes.computeLocation(RoleNodes$RNode[])>
        graphComponent.setGraph(genRolestructure(nodes, nRoles));
    //   21   45:aload_0         
    //   22   46:getfield        #161 <Field mxGraphComponent graphComponent>
    //   23   49:aload_0         
    //   24   50:aload_2         
    //   25   51:iload_1         
    //   26   52:invokespecial   #341 <Method mxGraph genRolestructure(RoleNodes$RNode[], int)>
    //   27   55:invokevirtual   #344 <Method void mxGraphComponent.setGraph(mxGraph)>
        rtPanel = new RoleEditorTable(generateRoles, nodes);
    //   28   58:aload_0         
    //   29   59:new             #346 <Class RoleEditorTable>
    //   30   62:dup             
    //   31   63:aload_0         
    //   32   64:getfield        #154 <Field Assignment generateRoles>
    //   33   67:aload_2         
    //   34   68:invokespecial   #349 <Method void RoleEditorTable(Assignment, RoleNodes$RNode[])>
    //   35   71:putfield        #246 <Field RoleEditorTable rtPanel>
    //   36   74:return          
    }

    private mxGraph genRolestructure(RoleNodes.RNode nodes[], int nRoles)
    {
        RoleEditor = new mxGraph();
    //    0    0:aload_0         
    //    1    1:new             #109 <Class mxGraph>
    //    2    4:dup             
    //    3    5:invokespecial   #110 <Method void mxGraph()>
    //    4    8:putfield        #354 <Field mxGraph RoleEditor>
        RoleEditor.removeCellsFromParent();
    //    5   11:aload_0         
    //    6   12:getfield        #354 <Field mxGraph RoleEditor>
    //    7   15:invokevirtual   #358 <Method Object[] mxGraph.removeCellsFromParent()>
    //    8   18:pop             
        RoleEditor.getModel().beginUpdate();
    //    9   19:aload_0         
    //   10   20:getfield        #354 <Field mxGraph RoleEditor>
    //   11   23:invokevirtual   #362 <Method mxIGraphModel mxGraph.getModel()>
    //   12   26:invokeinterface #367 <Method void mxIGraphModel.beginUpdate()>
        Vertex = new Object[nRoles];
    //   13   31:aload_0         
    //   14   32:iload_2         
    //   15   33:anewarray       Object[]
    //   16   36:putfield        #369 <Field Object[] Vertex>
        for(int i = 0; i < nRoles; i++)
    //*  17   39:iconst_0        
    //*  18   40:istore_3        
    //*  19   41:goto            90
            Vertex[i] = RoleEditor.insertVertex(null, "0", nodes[i].RoleName, nodes[i].x, nodes[i].y, 80D, 20D);
    //   20   44:aload_0         
    //   21   45:getfield        #369 <Field Object[] Vertex>
    //   22   48:iload_3         
    //   23   49:aload_0         
    //   24   50:getfield        #354 <Field mxGraph RoleEditor>
    //   25   53:aconst_null     
    //   26   54:ldc2            #371 <String "0">
    //   27   57:aload_1         
    //   28   58:iload_3         
    //   29   59:aaload          
    //   30   60:getfield        #377 <Field String RoleNodes$RNode.RoleName>
    //   31   63:aload_1         
    //   32   64:iload_3         
    //   33   65:aaload          
    //   34   66:getfield        #380 <Field int RoleNodes$RNode.x>
    //   35   69:i2d             
    //   36   70:aload_1         
    //   37   71:iload_3         
    //   38   72:aaload          
    //   39   73:getfield        #383 <Field int RoleNodes$RNode.y>
    //   40   76:i2d             
    //   41   77:ldc2w           #384 <Double 80D>
    //   42   80:ldc2w           #386 <Double 20D>
    //   43   83:invokevirtual   #391 <Method Object mxGraph.insertVertex(Object, String, Object, double, double, double, double)>
    //   44   86:aastore         

    //   45   87:iinc            3  1
    //   46   90:iload_3         
    //   47   91:iload_2         
    //   48   92:icmplt          44
        for(int i = 0; i < nRoles; i++)
    //*  49   95:iconst_0        
    //*  50   96:istore_3        
    //*  51   97:goto            171
        {
            for(int j = 0; j < nodes[i].Parents.size(); j++)
    //*  52  100:iconst_0        
    //*  53  101:istore          4
    //*  54  103:goto            152
                RoleEditor.insertEdge(null, null, " ", Vertex[i], Vertex[((Integer)nodes[i].Parents.get(j)).intValue()]);
    //   55  106:aload_0         
    //   56  107:getfield        #354 <Field mxGraph RoleEditor>
    //   57  110:aconst_null     
    //   58  111:aconst_null     
    //   59  112:ldc2            #393 <String " ">
    //   60  115:aload_0         
    //   61  116:getfield        #369 <Field Object[] Vertex>
    //   62  119:iload_3         
    //   63  120:aaload          
    //   64  121:aload_0         
    //   65  122:getfield        #369 <Field Object[] Vertex>
    //   66  125:aload_1         
    //   67  126:iload_3         
    //   68  127:aaload          
    //   69  128:getfield        #397 <Field java.util.List RoleNodes$RNode.Parents>
    //   70  131:iload           4
    //   71  133:invokeinterface #403 <Method Object java.util.List.get(int)>
    //   72  138:checkcast       #405 <Class Integer>
    //   73  141:invokevirtual   #408 <Method int Integer.intValue()>
    //   74  144:aaload          
    //   75  145:invokevirtual   #412 <Method Object mxGraph.insertEdge(Object, String, Object, Object, Object)>
    //   76  148:pop             

    //   77  149:iinc            4  1
    //   78  152:iload           4
    //   79  154:aload_1         
    //   80  155:iload_3         
    //   81  156:aaload          
    //   82  157:getfield        #397 <Field java.util.List RoleNodes$RNode.Parents>
    //   83  160:invokeinterface #415 <Method int java.util.List.size()>
    //   84  165:icmplt          106
        }

    //   85  168:iinc            3  1
    //   86  171:iload_3         
    //   87  172:iload_2         
    //   88  173:icmplt          100
        break MISSING_BLOCK_LABEL_196;
    //   89  176:goto            196
        Exception exception;
        exception;
    //   90  179:astore          5
        RoleEditor.getModel().endUpdate();
    //   91  181:aload_0         
    //   92  182:getfield        #354 <Field mxGraph RoleEditor>
    //   93  185:invokevirtual   #362 <Method mxIGraphModel mxGraph.getModel()>
    //   94  188:invokeinterface #418 <Method void mxIGraphModel.endUpdate()>
        throw exception;
    //   95  193:aload           5
    //   96  195:athrow          
        RoleEditor.getModel().endUpdate();
    //   97  196:aload_0         
    //   98  197:getfield        #354 <Field mxGraph RoleEditor>
    //   99  200:invokevirtual   #362 <Method mxIGraphModel mxGraph.getModel()>
    //  100  203:invokeinterface #418 <Method void mxIGraphModel.endUpdate()>
        RoleEditor.setMultigraph(false);
    //  101  208:aload_0         
    //  102  209:getfield        #354 <Field mxGraph RoleEditor>
    //  103  212:iconst_0        
    //  104  213:invokevirtual   #421 <Method void mxGraph.setMultigraph(boolean)>
        RoleEditor.setAllowDanglingEdges(false);
    //  105  216:aload_0         
    //  106  217:getfield        #354 <Field mxGraph RoleEditor>
    //  107  220:iconst_0        
    //  108  221:invokevirtual   #424 <Method void mxGraph.setAllowDanglingEdges(boolean)>
        RoleEditor.setCellsResizable(false);
    //  109  224:aload_0         
    //  110  225:getfield        #354 <Field mxGraph RoleEditor>
    //  111  228:iconst_0        
    //  112  229:invokevirtual   #427 <Method void mxGraph.setCellsResizable(boolean)>
        return RoleEditor;
    //  113  232:aload_0         
    //  114  233:getfield        #354 <Field mxGraph RoleEditor>
    //  115  236:areturn         
    }

    private Assignment LoadRoleFile()
    {
        ConverterFileChooser m_FileChooser = new ConverterFileChooser(new File(ExplorerDefaults.getInitialDirectory()));
    //    0    0:new             #433 <Class ConverterFileChooser>
    //    1    3:dup             
    //    2    4:new             #435 <Class File>
    //    3    7:dup             
    //    4    8:invokestatic    #441 <Method String ExplorerDefaults.getInitialDirectory()>
    //    5   11:invokespecial   #442 <Method void File(String)>
    //    6   14:invokespecial   #445 <Method void ConverterFileChooser(File)>
    //    7   17:astore_1        
        int Fileflag = -1;
    //    8   18:iconst_m1       
    //    9   19:istore_2        
        m_FileChooser.setDialogTitle("Load Roles");
    //   10   20:aload_1         
    //   11   21:ldc2            #447 <String "Load Roles">
    //   12   24:invokevirtual   #450 <Method void ConverterFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //   13   27:aload_1         
    //   14   28:new             #435 <Class File>
    //   15   31:dup             
    //   16   32:ldc2            #452 <String "user.dir">
    //   17   35:invokestatic    #458 <Method String System.getProperty(String)>
    //   18   38:invokespecial   #442 <Method void File(String)>
    //   19   41:invokevirtual   #461 <Method void ConverterFileChooser.setCurrentDirectory(File)>
        try
        {
            Fileflag = m_FileChooser.showOpenDialog(this);
    //   20   44:aload_1         
    //   21   45:aload_0         
    //   22   46:invokevirtual   #465 <Method int ConverterFileChooser.showOpenDialog(java.awt.Component)>
    //   23   49:istore_2        
        }
    //*  24   50:goto            63
        catch(HeadlessException head)
    //*  25   53:astore_3        
        {
            System.out.println("Open File Dialog ERROR!");
    //   26   54:getstatic       #469 <Field PrintStream System.out>
    //   27   57:ldc2            #471 <String "Open File Dialog ERROR!">
    //   28   60:invokevirtual   #476 <Method void PrintStream.println(String)>
        }
        if(Fileflag == 0)
    //*  29   63:iload_2         
    //*  30   64:ifne            113
        {
            File SelectedFile = m_FileChooser.getSelectedFile();
    //   31   67:aload_1         
    //   32   68:invokevirtual   #480 <Method File ConverterFileChooser.getSelectedFile()>
    //   33   71:astore_3        
            try
            {
                if(SelectedFile != null)
    //*  34   72:aload_3         
    //*  35   73:ifnull          113
                {
                    AssLoader AssLoad = new AssLoader(new FileReader(SelectedFile));
    //   36   76:new             #482 <Class AssLoader>
    //   37   79:dup             
    //   38   80:new             #484 <Class FileReader>
    //   39   83:dup             
    //   40   84:aload_3         
    //   41   85:invokespecial   #485 <Method void FileReader(File)>
    //   42   88:invokespecial   #488 <Method void AssLoader(FileReader)>
    //   43   91:astore          4
                    Assignment assData = AssLoad.getData();
    //   44   93:aload           4
    //   45   95:invokevirtual   #491 <Method Assignment AssLoader.getData()>
    //   46   98:astore          5
                    return assData;
    //   47  100:aload           5
    //   48  102:areturn         
                }
            }
    //*  49  103:goto            113
            catch(Exception e)
    //*  50  106:astore          4
            {
                e.printStackTrace();
    //   51  108:aload           4
    //   52  110:invokevirtual   #496 <Method void Exception.printStackTrace()>
            }
        }
        return null;
    //   53  113:aconst_null     
    //   54  114:areturn         
    }

    private void SaveRoleFile()
    {
        JFileChooser m_FileChooser = new JFileChooser(new File(ExplorerDefaults.getInitialDirectory()));
    //    0    0:new             #512 <Class JFileChooser>
    //    1    3:dup             
    //    2    4:new             #435 <Class File>
    //    3    7:dup             
    //    4    8:invokestatic    #441 <Method String ExplorerDefaults.getInitialDirectory()>
    //    5   11:invokespecial   #442 <Method void File(String)>
    //    6   14:invokespecial   #513 <Method void JFileChooser(File)>
    //    7   17:astore_1        
        int Fileflag = -1;
    //    8   18:iconst_m1       
    //    9   19:istore_2        
        m_FileChooser.setDialogTitle("Save Roles");
    //   10   20:aload_1         
    //   11   21:ldc2            #515 <String "Save Roles">
    //   12   24:invokevirtual   #516 <Method void JFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //   13   27:aload_1         
    //   14   28:new             #435 <Class File>
    //   15   31:dup             
    //   16   32:ldc2            #452 <String "user.dir">
    //   17   35:invokestatic    #458 <Method String System.getProperty(String)>
    //   18   38:invokespecial   #442 <Method void File(String)>
    //   19   41:invokevirtual   #517 <Method void JFileChooser.setCurrentDirectory(File)>
        try
        {
            Fileflag = m_FileChooser.showSaveDialog(this);
    //   20   44:aload_1         
    //   21   45:aload_0         
    //   22   46:invokevirtual   #520 <Method int JFileChooser.showSaveDialog(java.awt.Component)>
    //   23   49:istore_2        
        }
    //*  24   50:goto            63
        catch(HeadlessException head)
    //*  25   53:astore_3        
        {
            System.out.println("Save File Dialog ERROR!");
    //   26   54:getstatic       #469 <Field PrintStream System.out>
    //   27   57:ldc2            #522 <String "Save File Dialog ERROR!">
    //   28   60:invokevirtual   #476 <Method void PrintStream.println(String)>
        }
        if(Fileflag == 0)
    //*  29   63:iload_2         
    //*  30   64:ifne            109
        {
            File SelectedFile = m_FileChooser.getSelectedFile();
    //   31   67:aload_1         
    //   32   68:invokevirtual   #523 <Method File JFileChooser.getSelectedFile()>
    //   33   71:astore_3        
            try
            {
                FileWriter fw = new FileWriter(SelectedFile);
    //   34   72:new             #525 <Class FileWriter>
    //   35   75:dup             
    //   36   76:aload_3         
    //   37   77:invokespecial   #526 <Method void FileWriter(File)>
    //   38   80:astore          4
                fw.write(reconstruceRoles().toString());
    //   39   82:aload           4
    //   40   84:aload_0         
    //   41   85:invokespecial   #529 <Method Assignment reconstruceRoles()>
    //   42   88:invokevirtual   #534 <Method String Assignment.toString()>
    //   43   91:invokevirtual   #537 <Method void FileWriter.write(String)>
                fw.close();
    //   44   94:aload           4
    //   45   96:invokevirtual   #540 <Method void FileWriter.close()>
            }
    //*  46   99:goto            109
            catch(Exception e)
    //*  47  102:astore          4
            {
                e.printStackTrace();
    //   48  104:aload           4
    //   49  106:invokevirtual   #496 <Method void Exception.printStackTrace()>
            }
        }
    //   50  109:return          
    }

    private Assignment reconstruceRoles()
    {
        RoleNodes.RNode nodes[] = rtPanel.getNodes();
    //    0    0:aload_0         
    //    1    1:getfield        #246 <Field RoleEditorTable rtPanel>
    //    2    4:invokevirtual   #544 <Method RoleNodes$RNode[] RoleEditorTable.getNodes()>
    //    3    7:astore_1        
        Matrix mat = generateRoles.getAssignmentMatrix();
    //    4    8:aload_0         
    //    5    9:getfield        #154 <Field Assignment generateRoles>
    //    6   12:invokevirtual   #548 <Method Matrix Assignment.getAssignmentMatrix()>
    //    7   15:astore_2        
        for(int i = 0; i < mat.getRowDimension(); i++)
    //*   8   16:iconst_0        
    //*   9   17:istore_3        
    //*  10   18:goto            75
        {
            for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  11   21:iconst_0        
    //*  12   22:istore          4
    //*  13   24:goto            63
                if(nodes[i].SelfPerms.contains(j))
    //*  14   27:aload_1         
    //*  15   28:iload_3         
    //*  16   29:aaload          
    //*  17   30:getfield        #552 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //*  18   33:iload           4
    //*  19   35:invokevirtual   #558 <Method boolean IntegerSet.contains(int)>
    //*  20   38:ifeq            52
                    mat.set(i, j, (byte)1);
    //   21   41:aload_2         
    //   22   42:iload_3         
    //   23   43:iload           4
    //   24   45:iconst_1        
    //   25   46:invokevirtual   #564 <Method void Matrix.set(int, int, byte)>
                else
    //*  26   49:goto            60
                    mat.set(i, j, (byte)0);
    //   27   52:aload_2         
    //   28   53:iload_3         
    //   29   54:iload           4
    //   30   56:iconst_0        
    //   31   57:invokevirtual   #564 <Method void Matrix.set(int, int, byte)>

    //   32   60:iinc            4  1
    //   33   63:iload           4
    //   34   65:aload_2         
    //   35   66:invokevirtual   #567 <Method int Matrix.getColumnDimension()>
    //   36   69:icmplt          27
        }

    //   37   72:iinc            3  1
    //   38   75:iload_3         
    //   39   76:aload_2         
    //   40   77:invokevirtual   #570 <Method int Matrix.getRowDimension()>
    //   41   80:icmplt          21
        generateRoles.setAssignmentMatrix(mat);
    //   42   83:aload_0         
    //   43   84:getfield        #154 <Field Assignment generateRoles>
    //   44   87:aload_2         
    //   45   88:invokevirtual   #574 <Method void Assignment.setAssignmentMatrix(Matrix)>
        if(generateRoles.getDimensionX().getDimensionInstances() != null)
    //*  46   91:aload_0         
    //*  47   92:getfield        #154 <Field Assignment generateRoles>
    //*  48   95:invokevirtual   #578 <Method Dimension Assignment.getDimensionX()>
    //*  49   98:invokevirtual   #584 <Method Instances Dimension.getDimensionInstances()>
    //*  50  101:ifnull          269
        {
            Instances insSet = generateRoles.getDimensionX().getDimensionInstances();
    //   51  104:aload_0         
    //   52  105:getfield        #154 <Field Assignment generateRoles>
    //   53  108:invokevirtual   #578 <Method Dimension Assignment.getDimensionX()>
    //   54  111:invokevirtual   #584 <Method Instances Dimension.getDimensionInstances()>
    //   55  114:astore_3        
            rm.core.Attribute attparent = generateRoles.getDimensionX().getDimensionInstances().attribute("parents");
    //   56  115:aload_0         
    //   57  116:getfield        #154 <Field Assignment generateRoles>
    //   58  119:invokevirtual   #578 <Method Dimension Assignment.getDimensionX()>
    //   59  122:invokevirtual   #584 <Method Instances Dimension.getDimensionInstances()>
    //   60  125:ldc2            #586 <String "parents">
    //   61  128:invokevirtual   #592 <Method rm.core.Attribute Instances.attribute(String)>
    //   62  131:astore          4
            if(attparent != null && insSet != null)
    //*  63  133:aload           4
    //*  64  135:ifnull          269
    //*  65  138:aload_3         
    //*  66  139:ifnull          269
            {
                for(int i = 0; i < nodes.length; i++)
    //*  67  142:iconst_0        
    //*  68  143:istore          5
    //*  69  145:goto            262
                {
                    StringBuffer parentSet = new StringBuffer();
    //   70  148:new             #594 <Class StringBuffer>
    //   71  151:dup             
    //   72  152:invokespecial   #595 <Method void StringBuffer()>
    //   73  155:astore          6
                    for(int j = 0; j < nodes[i].Parents.size(); j++)
    //*  74  157:iconst_0        
    //*  75  158:istore          7
    //*  76  160:goto            205
                        parentSet.append((new StringBuilder()).append(nodes[i].Parents.get(j)).append("|").toString());
    //   77  163:aload           6
    //   78  165:new             #597 <Class StringBuilder>
    //   79  168:dup             
    //   80  169:invokespecial   #598 <Method void StringBuilder()>
    //   81  172:aload_1         
    //   82  173:iload           5
    //   83  175:aaload          
    //   84  176:getfield        #397 <Field java.util.List RoleNodes$RNode.Parents>
    //   85  179:iload           7
    //   86  181:invokeinterface #403 <Method Object java.util.List.get(int)>
    //   87  186:invokevirtual   #602 <Method StringBuilder StringBuilder.append(Object)>
    //   88  189:ldc2            #604 <String "|">
    //   89  192:invokevirtual   #607 <Method StringBuilder StringBuilder.append(String)>
    //   90  195:invokevirtual   #608 <Method String StringBuilder.toString()>
    //   91  198:invokevirtual   #611 <Method StringBuffer StringBuffer.append(String)>
    //   92  201:pop             

    //   93  202:iinc            7  1
    //   94  205:iload           7
    //   95  207:aload_1         
    //   96  208:iload           5
    //   97  210:aaload          
    //   98  211:getfield        #397 <Field java.util.List RoleNodes$RNode.Parents>
    //   99  214:invokeinterface #415 <Method int java.util.List.size()>
    //  100  219:icmplt          163
                    if(parentSet.length() > 0)
    //* 101  222:aload           6
    //* 102  224:invokevirtual   #614 <Method int StringBuffer.length()>
    //* 103  227:ifle            243
                        parentSet.deleteCharAt(parentSet.length() - 1);
    //  104  230:aload           6
    //  105  232:aload           6
    //  106  234:invokevirtual   #614 <Method int StringBuffer.length()>
    //  107  237:iconst_1        
    //  108  238:isub            
    //  109  239:invokevirtual   #618 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  110  242:pop             
                    insSet.instance(i).setValue(attparent, parentSet.toString());
    //  111  243:aload_3         
    //  112  244:iload           5
    //  113  246:invokevirtual   #622 <Method Instance Instances.instance(int)>
    //  114  249:aload           4
    //  115  251:aload           6
    //  116  253:invokevirtual   #623 <Method String StringBuffer.toString()>
    //  117  256:invokevirtual   #629 <Method void Instance.setValue(rm.core.Attribute, String)>
                }

    //  118  259:iinc            5  1
    //  119  262:iload           5
    //  120  264:aload_1         
    //  121  265:arraylength     
    //  122  266:icmplt          148
            }
        }
        return generateRoles;
    //  123  269:aload_0         
    //  124  270:getfield        #154 <Field Assignment generateRoles>
    //  125  273:areturn         
    }

    public static void main(String args[])
        throws FileNotFoundException, IOException
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    //    0    0:invokestatic    #649 <Method String UIManager.getSystemLookAndFeelClassName()>
    //    1    3:invokestatic    #652 <Method void UIManager.setLookAndFeel(String)>
        }
    //*   2    6:goto            14
        catch(Exception exception)
    //*   3    9:astore_1        
        {
            exception.printStackTrace();
    //    4   10:aload_1         
    //    5   11:invokevirtual   #496 <Method void Exception.printStackTrace()>
        }
        File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\testrole.ass").toString());
    //    6   14:new             #435 <Class File>
    //    7   17:dup             
    //    8   18:new             #597 <Class StringBuilder>
    //    9   21:dup             
    //   10   22:ldc2            #452 <String "user.dir">
    //   11   25:invokestatic    #458 <Method String System.getProperty(String)>
    //   12   28:invokestatic    #658 <Method String String.valueOf(Object)>
    //   13   31:invokespecial   #659 <Method void StringBuilder(String)>
    //   14   34:ldc2            #661 <String "\\datasets\\testrole.ass">
    //   15   37:invokevirtual   #607 <Method StringBuilder StringBuilder.append(String)>
    //   16   40:invokevirtual   #608 <Method String StringBuilder.toString()>
    //   17   43:invokespecial   #442 <Method void File(String)>
    //   18   46:astore_1        
        AssLoader AL = new AssLoader(new FileReader(file));
    //   19   47:new             #482 <Class AssLoader>
    //   20   50:dup             
    //   21   51:new             #484 <Class FileReader>
    //   22   54:dup             
    //   23   55:aload_1         
    //   24   56:invokespecial   #485 <Method void FileReader(File)>
    //   25   59:invokespecial   #488 <Method void AssLoader(FileReader)>
    //   26   62:astore_2        
        RoleEditor frame = new RoleEditor(AL.getData());
    //   27   63:new             #2   <Class RoleEditor>
    //   28   66:dup             
    //   29   67:aload_2         
    //   30   68:invokevirtual   #491 <Method Assignment AssLoader.getData()>
    //   31   71:invokespecial   #662 <Method void RoleEditor(Assignment)>
    //   32   74:astore_3        
        frame.setDefaultCloseOperation(3);
    //   33   75:aload_3         
    //   34   76:iconst_3        
    //   35   77:invokevirtual   #665 <Method void setDefaultCloseOperation(int)>
        frame.setSize(800, 600);
    //   36   80:aload_3         
    //   37   81:sipush          800
    //   38   84:sipush          600
    //   39   87:invokevirtual   #669 <Method void setSize(int, int)>
        frame.setVisible(true);
    //   40   90:aload_3         
    //   41   91:iconst_1        
    //   42   92:invokevirtual   #672 <Method void setVisible(boolean)>
    //   43   95:return          
    }

    static final int DEFAULT_WIDTH = 800;
    static final int DEFAULT_HEIGHT = 600;
    static final int ROLEBOX_WIDTH = 80;
    static final int ROLEBOX_HEIGHT = 20;
    final JPanel jp = new JPanel();
    final mxGraph rt = new mxGraph();
    private boolean hasFloatWindow;
    private Assignment generateRoles;
    private mxGraphComponent graphComponent;
    private mxGraph RoleEditor;
    private Object Vertex[];
    private RoleEditorTable rtPanel;
    final JPanel BorderPanel = new JPanel();
    private JSplitPane sp;
    private File file;
    private RoleNodes rData;


/*
    static Assignment access$0(RoleEditor roleeditor)
    {
        return roleeditor.LoadRoleFile();
    //    0    0:aload_0         
    //    1    1:invokespecial   #681 <Method Assignment LoadRoleFile()>
    //    2    4:areturn         
    }

*/


/*
    static void access$1(RoleEditor roleeditor, Assignment assignment)
    {
        roleeditor.generateRoles = assignment;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #154 <Field Assignment generateRoles>
        return;
    //    3    5:return          
    }

*/


/*
    static void access$2(RoleEditor roleeditor)
    {
        roleeditor.ComputePanelData();
    //    0    0:aload_0         
    //    1    1:invokespecial   #164 <Method void ComputePanelData()>
        return;
    //    2    4:return          
    }

*/


/*
    static RoleEditorTable access$3(RoleEditor roleeditor)
    {
        return roleeditor.rtPanel;
    //    0    0:aload_0         
    //    1    1:getfield        #246 <Field RoleEditorTable rtPanel>
    //    2    4:areturn         
    }

*/


/*
    static JSplitPane access$4(RoleEditor roleeditor)
    {
        return roleeditor.sp;
    //    0    0:aload_0         
    //    1    1:getfield        #260 <Field JSplitPane sp>
    //    2    4:areturn         
    }

*/


/*
    static void access$5(RoleEditor roleeditor)
    {
        roleeditor.SaveRoleFile();
    //    0    0:aload_0         
    //    1    1:invokespecial   #692 <Method void SaveRoleFile()>
        return;
    //    2    4:return          
    }

*/


/*
    static boolean access$6(RoleEditor roleeditor)
    {
        return roleeditor.hasFloatWindow;
    //    0    0:aload_0         
    //    1    1:getfield        #114 <Field boolean hasFloatWindow>
    //    2    4:ireturn         
    }

*/


/*
    static void access$7(RoleEditor roleeditor, boolean flag)
    {
        roleeditor.hasFloatWindow = flag;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #114 <Field boolean hasFloatWindow>
        return;
    //    3    5:return          
    }

*/


/*
    static mxGraphComponent access$8(RoleEditor roleeditor)
    {
        return roleeditor.graphComponent;
    //    0    0:aload_0         
    //    1    1:getfield        #161 <Field mxGraphComponent graphComponent>
    //    2    4:areturn         
    }

*/


/*
    static RoleNodes access$9(RoleEditor roleeditor)
    {
        return roleeditor.rData;
    //    0    0:aload_0         
    //    1    1:getfield        #325 <Field RoleNodes rData>
    //    2    4:areturn         
    }

*/


/*
    static mxGraph access$10(RoleEditor roleeditor, RoleNodes.RNode arnode[], int i)
    {
        return roleeditor.genRolestructure(arnode, i);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_2         
    //    3    3:invokespecial   #341 <Method mxGraph genRolestructure(RoleNodes$RNode[], int)>
    //    4    6:areturn         
    }

*/
}

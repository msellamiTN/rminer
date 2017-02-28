// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AssignmentPanel.java

package rm.gui.explorer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rm.assignment.Assignment;
import rm.core.Capabilities;
import rm.core.CapabilitiesHandler;
import rm.core.Instances;
import rm.core.Matrix;
import rm.core.Option;
import rm.core.OptionHandler;
import rm.core.Utils;
import rm.core.converters.AssLoader;
import rm.gui.GenericObjectEditor;
import rm.gui.Logger;
import rm.gui.PropertyPanel;
import rm.gui.ResultHistoryPanel;
import rm.gui.SaveBuffer;
import rm.gui.SysErrLog;
import rm.gui.TaskLogger;
import rm.gui.graph.RoleEditor;

// Referenced classes of package rm.gui.explorer:
//            ExplorerDefaults, Explorer

public class AssignmentPanel extends JPanel
    implements Explorer.LogHandler
{

    public AssignmentPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #59  <Method void JPanel()>
        m_Explorer = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #61  <Field Explorer m_Explorer>
        m_AssignmentEditor = new GenericObjectEditor();
    //    5    9:aload_0         
    //    6   10:new             #51  <Class GenericObjectEditor>
    //    7   13:dup             
    //    8   14:invokespecial   #62  <Method void GenericObjectEditor()>
    //    9   17:putfield        #64  <Field GenericObjectEditor m_AssignmentEditor>
        m_CEPanel = new PropertyPanel(m_AssignmentEditor);
    //   10   20:aload_0         
    //   11   21:new             #66  <Class PropertyPanel>
    //   12   24:dup             
    //   13   25:aload_0         
    //   14   26:getfield        #64  <Field GenericObjectEditor m_AssignmentEditor>
    //   15   29:invokespecial   #69  <Method void PropertyPanel(java.beans.PropertyEditor)>
    //   16   32:putfield        #71  <Field PropertyPanel m_CEPanel>
        m_LoadRoles = new JPanel();
    //   17   35:aload_0         
    //   18   36:new             #4   <Class JPanel>
    //   19   39:dup             
    //   20   40:invokespecial   #59  <Method void JPanel()>
    //   21   43:putfield        #73  <Field JPanel m_LoadRoles>
        m_OutText = new JTextArea(18, 40);
    //   22   46:aload_0         
    //   23   47:new             #75  <Class JTextArea>
    //   24   50:dup             
    //   25   51:bipush          18
    //   26   53:bipush          40
    //   27   55:invokespecial   #78  <Method void JTextArea(int, int)>
    //   28   58:putfield        #80  <Field JTextArea m_OutText>
        m_Log = new SysErrLog();
    //   29   61:aload_0         
    //   30   62:new             #82  <Class SysErrLog>
    //   31   65:dup             
    //   32   66:invokespecial   #83  <Method void SysErrLog()>
    //   33   69:putfield        #85  <Field Logger m_Log>
        m_History = new ResultHistoryPanel(m_OutText);
    //   34   72:aload_0         
    //   35   73:new             #87  <Class ResultHistoryPanel>
    //   36   76:dup             
    //   37   77:aload_0         
    //   38   78:getfield        #80  <Field JTextArea m_OutText>
    //   39   81:invokespecial   #90  <Method void ResultHistoryPanel(javax.swing.text.JTextComponent)>
    //   40   84:putfield        #92  <Field ResultHistoryPanel m_History>
        m_StartBut = new JButton("Start");
    //   41   87:aload_0         
    //   42   88:new             #94  <Class JButton>
    //   43   91:dup             
    //   44   92:ldc1            #96  <String "Start">
    //   45   94:invokespecial   #99  <Method void JButton(String)>
    //   46   97:putfield        #101 <Field JButton m_StartBut>
        m_StopBut = new JButton("Stop");
    //   47  100:aload_0         
    //   48  101:new             #94  <Class JButton>
    //   49  104:dup             
    //   50  105:ldc1            #103 <String "Stop">
    //   51  107:invokespecial   #99  <Method void JButton(String)>
    //   52  110:putfield        #105 <Field JButton m_StopBut>
        m_LoadBut = new JButton("Loading");
    //   53  113:aload_0         
    //   54  114:new             #94  <Class JButton>
    //   55  117:dup             
    //   56  118:ldc1            #107 <String "Loading">
    //   57  120:invokespecial   #99  <Method void JButton(String)>
    //   58  123:putfield        #109 <Field JButton m_LoadBut>
        m_RoleEditorBut = new JButton("Edit Roles");
    //   59  126:aload_0         
    //   60  127:new             #94  <Class JButton>
    //   61  130:dup             
    //   62  131:ldc1            #111 <String "Edit Roles">
    //   63  133:invokespecial   #99  <Method void JButton(String)>
    //   64  136:putfield        #113 <Field JButton m_RoleEditorBut>
        m_DetailTxt = new JTextField();
    //   65  139:aload_0         
    //   66  140:new             #115 <Class JTextField>
    //   67  143:dup             
    //   68  144:invokespecial   #116 <Method void JTextField()>
    //   69  147:putfield        #118 <Field JTextField m_DetailTxt>
        m_FileChooser = new JFileChooser();
    //   70  150:aload_0         
    //   71  151:new             #120 <Class JFileChooser>
    //   72  154:dup             
    //   73  155:invokespecial   #121 <Method void JFileChooser()>
    //   74  158:putfield        #123 <Field JFileChooser m_FileChooser>
        SelectedFile = null;
    //   75  161:aload_0         
    //   76  162:aconst_null     
    //   77  163:putfield        #125 <Field File SelectedFile>
        AssPAData = null;
    //   78  166:aload_0         
    //   79  167:aconst_null     
    //   80  168:putfield        #127 <Field rm.core.Assignment AssPAData>
        m_SaveOut = new SaveBuffer(m_Log, this);
    //   81  171:aload_0         
    //   82  172:new             #129 <Class SaveBuffer>
    //   83  175:dup             
    //   84  176:aload_0         
    //   85  177:getfield        #85  <Field Logger m_Log>
    //   86  180:aload_0         
    //   87  181:invokespecial   #132 <Method void SaveBuffer(Logger, java.awt.Component)>
    //   88  184:putfield        #134 <Field SaveBuffer m_SaveOut>
        m_OutText.setEditable(false);
    //   89  187:aload_0         
    //   90  188:getfield        #80  <Field JTextArea m_OutText>
    //   91  191:iconst_0        
    //   92  192:invokevirtual   #138 <Method void JTextArea.setEditable(boolean)>
        m_OutText.setFont(new Font("Monospaced", 0, 12));
    //   93  195:aload_0         
    //   94  196:getfield        #80  <Field JTextArea m_OutText>
    //   95  199:new             #140 <Class Font>
    //   96  202:dup             
    //   97  203:ldc1            #142 <String "Monospaced">
    //   98  205:iconst_0        
    //   99  206:bipush          12
    //  100  208:invokespecial   #145 <Method void Font(String, int, int)>
    //  101  211:invokevirtual   #149 <Method void JTextArea.setFont(Font)>
        m_OutText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //  102  214:aload_0         
    //  103  215:getfield        #80  <Field JTextArea m_OutText>
    //  104  218:iconst_5        
    //  105  219:iconst_5        
    //  106  220:iconst_5        
    //  107  221:iconst_5        
    //  108  222:invokestatic    #155 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  109  225:invokevirtual   #159 <Method void JTextArea.setBorder(javax.swing.border.Border)>
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
            //    7   13:getfield        #11  <Field AssignmentPanel this$0>
            //    8   16:getfield        #32  <Field JTextArea AssignmentPanel.m_OutText>
            //    9   19:invokevirtual   #37  <Method void JTextArea.selectAll()>
            //   10   22:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //  110  228:aload_0         
    //  111  229:getfield        #80  <Field JTextArea m_OutText>
    //  112  232:new             #161 <Class AssignmentPanel$1>
    //  113  235:dup             
    //  114  236:aload_0         
    //  115  237:invokespecial   #164 <Method void AssignmentPanel$1(AssignmentPanel)>
    //  116  240:invokevirtual   #168 <Method void JTextArea.addMouseListener(java.awt.event.MouseListener)>
        m_History.setBorder(BorderFactory.createTitledBorder("Result list (right-click for options)"));
    //  117  243:aload_0         
    //  118  244:getfield        #92  <Field ResultHistoryPanel m_History>
    //  119  247:ldc1            #170 <String "Result list (right-click for options)">
    //  120  249:invokestatic    #174 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  121  252:invokevirtual   #175 <Method void ResultHistoryPanel.setBorder(javax.swing.border.Border)>
        m_History.setHandleRightClicks(false);
    //  122  255:aload_0         
    //  123  256:getfield        #92  <Field ResultHistoryPanel m_History>
    //  124  259:iconst_0        
    //  125  260:invokevirtual   #178 <Method void ResultHistoryPanel.setHandleRightClicks(boolean)>
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
            //   10   20:getfield        #11  <Field AssignmentPanel this$0>
            //   11   23:getfield        #36  <Field ResultHistoryPanel AssignmentPanel.m_History>
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
            //   21   43:getfield        #11  <Field AssignmentPanel this$0>
            //   22   46:getfield        #36  <Field ResultHistoryPanel AssignmentPanel.m_History>
            //   23   49:iload_2         
            //   24   50:invokevirtual   #56  <Method String ResultHistoryPanel.getNameAtIndex(int)>
            //   25   53:astore_3        
                        historyRightClickPopup(name, e.getX(), e.getY());
            //   26   54:aload_0         
            //   27   55:getfield        #11  <Field AssignmentPanel this$0>
            //   28   58:aload_3         
            //   29   59:aload_1         
            //   30   60:invokevirtual   #59  <Method int MouseEvent.getX()>
            //   31   63:aload_1         
            //   32   64:invokevirtual   #62  <Method int MouseEvent.getY()>
            //   33   67:invokevirtual   #66  <Method void AssignmentPanel.historyRightClickPopup(String, int, int)>
                    } else
            //*  34   70:goto            89
                    {
                        historyRightClickPopup(null, e.getX(), e.getY());
            //   35   73:aload_0         
            //   36   74:getfield        #11  <Field AssignmentPanel this$0>
            //   37   77:aconst_null     
            //   38   78:aload_1         
            //   39   79:invokevirtual   #59  <Method int MouseEvent.getX()>
            //   40   82:aload_1         
            //   41   83:invokevirtual   #62  <Method int MouseEvent.getY()>
            //   42   86:invokevirtual   #66  <Method void AssignmentPanel.historyRightClickPopup(String, int, int)>
                    }
                }
            //   43   89:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void MouseAdapter()>
            //    5    9:return          
            }
        }
);
    //  126  263:aload_0         
    //  127  264:getfield        #92  <Field ResultHistoryPanel m_History>
    //  128  267:invokevirtual   #182 <Method JList ResultHistoryPanel.getList()>
    //  129  270:new             #184 <Class AssignmentPanel$2>
    //  130  273:dup             
    //  131  274:aload_0         
    //  132  275:invokespecial   #185 <Method void AssignmentPanel$2(AssignmentPanel)>
    //  133  278:invokevirtual   #188 <Method void JList.addMouseListener(java.awt.event.MouseListener)>
        m_AssignmentEditor.setClassType(rm/assignment/Assignment);
    //  134  281:aload_0         
    //  135  282:getfield        #64  <Field GenericObjectEditor m_AssignmentEditor>
    //  136  285:ldc1            #190 <Class Assignment>
    //  137  287:invokevirtual   #194 <Method void GenericObjectEditor.setClassType(Class)>
        m_AssignmentEditor.setValue(ExplorerDefaults.getAssigner());
    //  138  290:aload_0         
    //  139  291:getfield        #64  <Field GenericObjectEditor m_AssignmentEditor>
    //  140  294:invokestatic    #200 <Method Object ExplorerDefaults.getAssigner()>
    //  141  297:invokevirtual   #204 <Method void GenericObjectEditor.setValue(Object)>
        m_AssignmentEditor.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e)
            {
                m_StartBut.setEnabled(true);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentPanel this$0>
            //    2    4:getfield        #28  <Field JButton AssignmentPanel.m_StartBut>
            //    3    7:iconst_1        
            //    4    8:invokevirtual   #34  <Method void JButton.setEnabled(boolean)>
                Capabilities currentFilter = m_AssignmentEditor.getCapabilitiesFilter();
            //    5   11:aload_0         
            //    6   12:getfield        #13  <Field AssignmentPanel this$0>
            //    7   15:getfield        #38  <Field GenericObjectEditor AssignmentPanel.m_AssignmentEditor>
            //    8   18:invokevirtual   #44  <Method Capabilities GenericObjectEditor.getCapabilitiesFilter()>
            //    9   21:astore_2        
                Assignment assigner = (Assignment)m_AssignmentEditor.getValue();
            //   10   22:aload_0         
            //   11   23:getfield        #13  <Field AssignmentPanel this$0>
            //   12   26:getfield        #38  <Field GenericObjectEditor AssignmentPanel.m_AssignmentEditor>
            //   13   29:invokevirtual   #48  <Method Object GenericObjectEditor.getValue()>
            //   14   32:checkcast       #50  <Class Assignment>
            //   15   35:astore_3        
                Capabilities currentSchemeCapabilities = null;
            //   16   36:aconst_null     
            //   17   37:astore          4
                if(assigner != null && currentFilter != null && (assigner instanceof CapabilitiesHandler))
            //*  18   39:aload_3         
            //*  19   40:ifnull          94
            //*  20   43:aload_2         
            //*  21   44:ifnull          94
            //*  22   47:aload_3         
            //*  23   48:instanceof      #52  <Class CapabilitiesHandler>
            //*  24   51:ifeq            94
                {
                    currentSchemeCapabilities = ((CapabilitiesHandler)assigner).getCapabilities();
            //   25   54:aload_3         
            //   26   55:checkcast       #52  <Class CapabilitiesHandler>
            //   27   58:invokeinterface #55  <Method Capabilities CapabilitiesHandler.getCapabilities()>
            //   28   63:astore          4
                    if(!currentSchemeCapabilities.supportsMaybe(currentFilter) && !currentSchemeCapabilities.supports(currentFilter))
            //*  29   65:aload           4
            //*  30   67:aload_2         
            //*  31   68:invokevirtual   #61  <Method boolean Capabilities.supportsMaybe(Capabilities)>
            //*  32   71:ifne            94
            //*  33   74:aload           4
            //*  34   76:aload_2         
            //*  35   77:invokevirtual   #64  <Method boolean Capabilities.supports(Capabilities)>
            //*  36   80:ifne            94
                        m_StartBut.setEnabled(false);
            //   37   83:aload_0         
            //   38   84:getfield        #13  <Field AssignmentPanel this$0>
            //   39   87:getfield        #28  <Field JButton AssignmentPanel.m_StartBut>
            //   40   90:iconst_0        
            //   41   91:invokevirtual   #34  <Method void JButton.setEnabled(boolean)>
                }
                repaint();
            //   42   94:aload_0         
            //   43   95:getfield        #13  <Field AssignmentPanel this$0>
            //   44   98:invokevirtual   #67  <Method void AssignmentPanel.repaint()>
            //   45  101:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  142  300:aload_0         
    //  143  301:getfield        #64  <Field GenericObjectEditor m_AssignmentEditor>
    //  144  304:new             #206 <Class AssignmentPanel$3>
    //  145  307:dup             
    //  146  308:aload_0         
    //  147  309:invokespecial   #207 <Method void AssignmentPanel$3(AssignmentPanel)>
    //  148  312:invokevirtual   #211 <Method void GenericObjectEditor.addPropertyChangeListener(PropertyChangeListener)>
        m_LoadRoles.setLayout(new BorderLayout());
    //  149  315:aload_0         
    //  150  316:getfield        #73  <Field JPanel m_LoadRoles>
    //  151  319:new             #213 <Class BorderLayout>
    //  152  322:dup             
    //  153  323:invokespecial   #214 <Method void BorderLayout()>
    //  154  326:invokevirtual   #218 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        m_LoadBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                LoadPAFile();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentPanel this$0>
            //    2    4:invokevirtual   #27  <Method void AssignmentPanel.LoadPAFile()>
                String TxtRoles = (new StringBuilder("-F ")).append(SelectedFile.getName()).toString();
            //    3    7:new             #29  <Class StringBuilder>
            //    4   10:dup             
            //    5   11:ldc1            #31  <String "-F ">
            //    6   13:invokespecial   #34  <Method void StringBuilder(String)>
            //    7   16:aload_0         
            //    8   17:getfield        #13  <Field AssignmentPanel this$0>
            //    9   20:getfield        #38  <Field File AssignmentPanel.SelectedFile>
            //   10   23:invokevirtual   #44  <Method String File.getName()>
            //   11   26:invokevirtual   #48  <Method StringBuilder StringBuilder.append(String)>
            //   12   29:invokevirtual   #51  <Method String StringBuilder.toString()>
            //   13   32:astore_2        
                TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -N ").append(AssPAData.getAssignementName()).toString();
            //   14   33:new             #29  <Class StringBuilder>
            //   15   36:dup             
            //   16   37:aload_2         
            //   17   38:invokestatic    #57  <Method String String.valueOf(Object)>
            //   18   41:invokespecial   #34  <Method void StringBuilder(String)>
            //   19   44:ldc1            #59  <String "  -N ">
            //   20   46:invokevirtual   #48  <Method StringBuilder StringBuilder.append(String)>
            //   21   49:aload_0         
            //   22   50:getfield        #13  <Field AssignmentPanel this$0>
            //   23   53:getfield        #63  <Field rm.core.Assignment AssignmentPanel.AssPAData>
            //   24   56:invokevirtual   #68  <Method String rm.core.Assignment.getAssignementName()>
            //   25   59:invokevirtual   #48  <Method StringBuilder StringBuilder.append(String)>
            //   26   62:invokevirtual   #51  <Method String StringBuilder.toString()>
            //   27   65:astore_2        
                TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -R ").append(AssPAData.getAssignmentMatrix().getRowDimension()).toString();
            //   28   66:new             #29  <Class StringBuilder>
            //   29   69:dup             
            //   30   70:aload_2         
            //   31   71:invokestatic    #57  <Method String String.valueOf(Object)>
            //   32   74:invokespecial   #34  <Method void StringBuilder(String)>
            //   33   77:ldc1            #70  <String "  -R ">
            //   34   79:invokevirtual   #48  <Method StringBuilder StringBuilder.append(String)>
            //   35   82:aload_0         
            //   36   83:getfield        #13  <Field AssignmentPanel this$0>
            //   37   86:getfield        #63  <Field rm.core.Assignment AssignmentPanel.AssPAData>
            //   38   89:invokevirtual   #74  <Method Matrix rm.core.Assignment.getAssignmentMatrix()>
            //   39   92:invokevirtual   #80  <Method int Matrix.getRowDimension()>
            //   40   95:invokevirtual   #83  <Method StringBuilder StringBuilder.append(int)>
            //   41   98:invokevirtual   #51  <Method String StringBuilder.toString()>
            //   42  101:astore_2        
                TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -P ").append(AssPAData.getAssignmentMatrix().getColumnDimension()).toString();
            //   43  102:new             #29  <Class StringBuilder>
            //   44  105:dup             
            //   45  106:aload_2         
            //   46  107:invokestatic    #57  <Method String String.valueOf(Object)>
            //   47  110:invokespecial   #34  <Method void StringBuilder(String)>
            //   48  113:ldc1            #85  <String "  -P ">
            //   49  115:invokevirtual   #48  <Method StringBuilder StringBuilder.append(String)>
            //   50  118:aload_0         
            //   51  119:getfield        #13  <Field AssignmentPanel this$0>
            //   52  122:getfield        #63  <Field rm.core.Assignment AssignmentPanel.AssPAData>
            //   53  125:invokevirtual   #74  <Method Matrix rm.core.Assignment.getAssignmentMatrix()>
            //   54  128:invokevirtual   #88  <Method int Matrix.getColumnDimension()>
            //   55  131:invokevirtual   #83  <Method StringBuilder StringBuilder.append(int)>
            //   56  134:invokevirtual   #51  <Method String StringBuilder.toString()>
            //   57  137:astore_2        
                m_DetailTxt.setText(TxtRoles);
            //   58  138:aload_0         
            //   59  139:getfield        #13  <Field AssignmentPanel this$0>
            //   60  142:getfield        #92  <Field JTextField AssignmentPanel.m_DetailTxt>
            //   61  145:aload_2         
            //   62  146:invokevirtual   #97  <Method void JTextField.setText(String)>
            //   63  149:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  155  329:aload_0         
    //  156  330:getfield        #109 <Field JButton m_LoadBut>
    //  157  333:new             #220 <Class AssignmentPanel$4>
    //  158  336:dup             
    //  159  337:aload_0         
    //  160  338:invokespecial   #221 <Method void AssignmentPanel$4(AssignmentPanel)>
    //  161  341:invokevirtual   #225 <Method void JButton.addActionListener(ActionListener)>
        m_RoleEditorBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //    0    0:invokestatic    #28  <Method String UIManager.getSystemLookAndFeelClassName()>
            //    1    3:invokestatic    #32  <Method void UIManager.setLookAndFeel(String)>
                }
            //*   2    6:goto            14
                catch(Exception exception)
            //*   3    9:astore_2        
                {
                    exception.printStackTrace();
            //    4   10:aload_2         
            //    5   11:invokevirtual   #37  <Method void Exception.printStackTrace()>
                }
                if(m_assroles != null)
            //*   6   14:aload_0         
            //*   7   15:getfield        #13  <Field AssignmentPanel this$0>
            //*   8   18:getfield        #43  <Field rm.core.Assignment AssignmentPanel.m_assroles>
            //*   9   21:ifnull          70
                    try
                    {
                        RoleEditor frame = new RoleEditor(m_assroles);
            //   10   24:new             #45  <Class RoleEditor>
            //   11   27:dup             
            //   12   28:aload_0         
            //   13   29:getfield        #13  <Field AssignmentPanel this$0>
            //   14   32:getfield        #43  <Field rm.core.Assignment AssignmentPanel.m_assroles>
            //   15   35:invokespecial   #48  <Method void RoleEditor(rm.core.Assignment)>
            //   16   38:astore_2        
                        frame.setDefaultCloseOperation(2);
            //   17   39:aload_2         
            //   18   40:iconst_2        
            //   19   41:invokevirtual   #52  <Method void RoleEditor.setDefaultCloseOperation(int)>
                        frame.setSize(800, 600);
            //   20   44:aload_2         
            //   21   45:sipush          800
            //   22   48:sipush          600
            //   23   51:invokevirtual   #56  <Method void RoleEditor.setSize(int, int)>
                        frame.setVisible(true);
            //   24   54:aload_2         
            //   25   55:iconst_1        
            //   26   56:invokevirtual   #60  <Method void RoleEditor.setVisible(boolean)>
                    }
            //*  27   59:goto            84
                    catch(Exception ex)
            //*  28   62:astore_2        
                    {
                        ex.printStackTrace();
            //   29   63:aload_2         
            //   30   64:invokevirtual   #37  <Method void Exception.printStackTrace()>
                    }
                else
            //*  31   67:goto            84
                    m_Log.statusMessage("Role set is null");
            //   32   70:aload_0         
            //   33   71:getfield        #13  <Field AssignmentPanel this$0>
            //   34   74:getfield        #64  <Field Logger AssignmentPanel.m_Log>
            //   35   77:ldc1            #66  <String "Role set is null">
            //   36   79:invokeinterface #71  <Method void Logger.statusMessage(String)>
            //   37   84:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  162  344:aload_0         
    //  163  345:getfield        #113 <Field JButton m_RoleEditorBut>
    //  164  348:new             #227 <Class AssignmentPanel$5>
    //  165  351:dup             
    //  166  352:aload_0         
    //  167  353:invokespecial   #228 <Method void AssignmentPanel$5(AssignmentPanel)>
    //  168  356:invokevirtual   #225 <Method void JButton.addActionListener(ActionListener)>
        m_DetailTxt.setEditable(false);
    //  169  359:aload_0         
    //  170  360:getfield        #118 <Field JTextField m_DetailTxt>
    //  171  363:iconst_0        
    //  172  364:invokevirtual   #229 <Method void JTextField.setEditable(boolean)>
        m_LoadRoles.add(m_LoadBut, "West");
    //  173  367:aload_0         
    //  174  368:getfield        #73  <Field JPanel m_LoadRoles>
    //  175  371:aload_0         
    //  176  372:getfield        #109 <Field JButton m_LoadBut>
    //  177  375:ldc1            #231 <String "West">
    //  178  377:invokevirtual   #235 <Method void JPanel.add(java.awt.Component, Object)>
        m_LoadRoles.add(m_DetailTxt, "Center");
    //  179  380:aload_0         
    //  180  381:getfield        #73  <Field JPanel m_LoadRoles>
    //  181  384:aload_0         
    //  182  385:getfield        #118 <Field JTextField m_DetailTxt>
    //  183  388:ldc1            #237 <String "Center">
    //  184  390:invokevirtual   #235 <Method void JPanel.add(java.awt.Component, Object)>
        m_LoadRoles.add(m_RoleEditorBut, "East");
    //  185  393:aload_0         
    //  186  394:getfield        #73  <Field JPanel m_LoadRoles>
    //  187  397:aload_0         
    //  188  398:getfield        #113 <Field JButton m_RoleEditorBut>
    //  189  401:ldc1            #239 <String "East">
    //  190  403:invokevirtual   #235 <Method void JPanel.add(java.awt.Component, Object)>
        m_StartBut.setToolTipText("Starts the assigner");
    //  191  406:aload_0         
    //  192  407:getfield        #101 <Field JButton m_StartBut>
    //  193  410:ldc1            #241 <String "Starts the assigner">
    //  194  412:invokevirtual   #244 <Method void JButton.setToolTipText(String)>
        m_StopBut.setToolTipText("Stops the assigner");
    //  195  415:aload_0         
    //  196  416:getfield        #105 <Field JButton m_StopBut>
    //  197  419:ldc1            #246 <String "Stops the assigner">
    //  198  421:invokevirtual   #244 <Method void JButton.setToolTipText(String)>
        m_StartBut.setEnabled(false);
    //  199  424:aload_0         
    //  200  425:getfield        #101 <Field JButton m_StartBut>
    //  201  428:iconst_0        
    //  202  429:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
        m_StopBut.setEnabled(false);
    //  203  432:aload_0         
    //  204  433:getfield        #105 <Field JButton m_StopBut>
    //  205  436:iconst_0        
    //  206  437:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
        m_RoleEditorBut.setEnabled(false);
    //  207  440:aload_0         
    //  208  441:getfield        #113 <Field JButton m_RoleEditorBut>
    //  209  444:iconst_0        
    //  210  445:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
        m_StartBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                startAssignmenter();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentPanel this$0>
            //    2    4:invokevirtual   #27  <Method void AssignmentPanel.startAssignmenter()>
            //    3    7:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  211  448:aload_0         
    //  212  449:getfield        #101 <Field JButton m_StartBut>
    //  213  452:new             #251 <Class AssignmentPanel$6>
    //  214  455:dup             
    //  215  456:aload_0         
    //  216  457:invokespecial   #252 <Method void AssignmentPanel$6(AssignmentPanel)>
    //  217  460:invokevirtual   #225 <Method void JButton.addActionListener(ActionListener)>
        m_StopBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                stopAssignmenter();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AssignmentPanel this$0>
            //    2    4:invokevirtual   #27  <Method void AssignmentPanel.stopAssignmenter()>
            //    3    7:return          
            }

            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  218  463:aload_0         
    //  219  464:getfield        #105 <Field JButton m_StopBut>
    //  220  467:new             #254 <Class AssignmentPanel$7>
    //  221  470:dup             
    //  222  471:aload_0         
    //  223  472:invokespecial   #255 <Method void AssignmentPanel$7(AssignmentPanel)>
    //  224  475:invokevirtual   #225 <Method void JButton.addActionListener(ActionListener)>
        JPanel p1 = new JPanel();
    //  225  478:new             #4   <Class JPanel>
    //  226  481:dup             
    //  227  482:invokespecial   #59  <Method void JPanel()>
    //  228  485:astore_1        
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Assignment"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
    //  229  486:aload_1         
    //  230  487:ldc2            #257 <String "Assignment">
    //  231  490:invokestatic    #174 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  232  493:iconst_0        
    //  233  494:iconst_5        
    //  234  495:iconst_5        
    //  235  496:iconst_5        
    //  236  497:invokestatic    #155 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  237  500:invokestatic    #261 <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //  238  503:invokevirtual   #262 <Method void JPanel.setBorder(javax.swing.border.Border)>
        p1.setLayout(new BorderLayout());
    //  239  506:aload_1         
    //  240  507:new             #213 <Class BorderLayout>
    //  241  510:dup             
    //  242  511:invokespecial   #214 <Method void BorderLayout()>
    //  243  514:invokevirtual   #218 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        p1.add(m_LoadRoles, "North");
    //  244  517:aload_1         
    //  245  518:aload_0         
    //  246  519:getfield        #73  <Field JPanel m_LoadRoles>
    //  247  522:ldc2            #264 <String "North">
    //  248  525:invokevirtual   #235 <Method void JPanel.add(java.awt.Component, Object)>
        p1.add(m_CEPanel, "South");
    //  249  528:aload_1         
    //  250  529:aload_0         
    //  251  530:getfield        #71  <Field PropertyPanel m_CEPanel>
    //  252  533:ldc2            #266 <String "South">
    //  253  536:invokevirtual   #235 <Method void JPanel.add(java.awt.Component, Object)>
        JPanel buttons = new JPanel();
    //  254  539:new             #4   <Class JPanel>
    //  255  542:dup             
    //  256  543:invokespecial   #59  <Method void JPanel()>
    //  257  546:astore_2        
        buttons.setLayout(new GridLayout(1, 2));
    //  258  547:aload_2         
    //  259  548:new             #268 <Class GridLayout>
    //  260  551:dup             
    //  261  552:iconst_1        
    //  262  553:iconst_2        
    //  263  554:invokespecial   #269 <Method void GridLayout(int, int)>
    //  264  557:invokevirtual   #218 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JPanel ssButs = new JPanel();
    //  265  560:new             #4   <Class JPanel>
    //  266  563:dup             
    //  267  564:invokespecial   #59  <Method void JPanel()>
    //  268  567:astore_3        
        ssButs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    //  269  568:aload_3         
    //  270  569:iconst_5        
    //  271  570:iconst_5        
    //  272  571:iconst_5        
    //  273  572:iconst_5        
    //  274  573:invokestatic    #155 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  275  576:invokevirtual   #262 <Method void JPanel.setBorder(javax.swing.border.Border)>
        ssButs.setLayout(new GridLayout(1, 2, 5, 5));
    //  276  579:aload_3         
    //  277  580:new             #268 <Class GridLayout>
    //  278  583:dup             
    //  279  584:iconst_1        
    //  280  585:iconst_2        
    //  281  586:iconst_5        
    //  282  587:iconst_5        
    //  283  588:invokespecial   #272 <Method void GridLayout(int, int, int, int)>
    //  284  591:invokevirtual   #218 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        ssButs.add(m_StartBut);
    //  285  594:aload_3         
    //  286  595:aload_0         
    //  287  596:getfield        #101 <Field JButton m_StartBut>
    //  288  599:invokevirtual   #275 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  289  602:pop             
        ssButs.add(m_StopBut);
    //  290  603:aload_3         
    //  291  604:aload_0         
    //  292  605:getfield        #105 <Field JButton m_StopBut>
    //  293  608:invokevirtual   #275 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  294  611:pop             
        buttons.add(ssButs);
    //  295  612:aload_2         
    //  296  613:aload_3         
    //  297  614:invokevirtual   #275 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  298  617:pop             
        JPanel p3 = new JPanel();
    //  299  618:new             #4   <Class JPanel>
    //  300  621:dup             
    //  301  622:invokespecial   #59  <Method void JPanel()>
    //  302  625:astore          4
        p3.setBorder(BorderFactory.createTitledBorder("Assignment output"));
    //  303  627:aload           4
    //  304  629:ldc2            #277 <String "Assignment output">
    //  305  632:invokestatic    #174 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  306  635:invokevirtual   #262 <Method void JPanel.setBorder(javax.swing.border.Border)>
        p3.setLayout(new BorderLayout());
    //  307  638:aload           4
    //  308  640:new             #213 <Class BorderLayout>
    //  309  643:dup             
    //  310  644:invokespecial   #214 <Method void BorderLayout()>
    //  311  647:invokevirtual   #218 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JScrollPane js = new JScrollPane(m_OutText);
    //  312  650:new             #279 <Class JScrollPane>
    //  313  653:dup             
    //  314  654:aload_0         
    //  315  655:getfield        #80  <Field JTextArea m_OutText>
    //  316  658:invokespecial   #282 <Method void JScrollPane(java.awt.Component)>
    //  317  661:astore          5
        p3.add(js, "Center");
    //  318  663:aload           4
    //  319  665:aload           5
    //  320  667:ldc1            #237 <String "Center">
    //  321  669:invokevirtual   #235 <Method void JPanel.add(java.awt.Component, Object)>
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
            final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #18  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  322  672:aload           5
    //  323  674:invokevirtual   #286 <Method JViewport JScrollPane.getViewport()>
    //  324  677:new             #288 <Class AssignmentPanel$8>
    //  325  680:dup             
    //  326  681:aload_0         
    //  327  682:invokespecial   #289 <Method void AssignmentPanel$8(AssignmentPanel)>
    //  328  685:invokevirtual   #295 <Method void JViewport.addChangeListener(ChangeListener)>
        GridBagLayout gbL = new GridBagLayout();
    //  329  688:new             #297 <Class GridBagLayout>
    //  330  691:dup             
    //  331  692:invokespecial   #298 <Method void GridBagLayout()>
    //  332  695:astore          6
        GridBagConstraints gbC = new GridBagConstraints();
    //  333  697:new             #300 <Class GridBagConstraints>
    //  334  700:dup             
    //  335  701:invokespecial   #301 <Method void GridBagConstraints()>
    //  336  704:astore          7
        JPanel mondo = new JPanel();
    //  337  706:new             #4   <Class JPanel>
    //  338  709:dup             
    //  339  710:invokespecial   #59  <Method void JPanel()>
    //  340  713:astore          8
        gbL = new GridBagLayout();
    //  341  715:new             #297 <Class GridBagLayout>
    //  342  718:dup             
    //  343  719:invokespecial   #298 <Method void GridBagLayout()>
    //  344  722:astore          6
        mondo.setLayout(gbL);
    //  345  724:aload           8
    //  346  726:aload           6
    //  347  728:invokevirtual   #218 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        gbC = new GridBagConstraints();
    //  348  731:new             #300 <Class GridBagConstraints>
    //  349  734:dup             
    //  350  735:invokespecial   #301 <Method void GridBagConstraints()>
    //  351  738:astore          7
        gbC.anchor = 11;
    //  352  740:aload           7
    //  353  742:bipush          11
    //  354  744:putfield        #304 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  355  747:aload           7
    //  356  749:iconst_2        
    //  357  750:putfield        #307 <Field int GridBagConstraints.fill>
        gbC.gridy = 1;
    //  358  753:aload           7
    //  359  755:iconst_1        
    //  360  756:putfield        #310 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  361  759:aload           7
    //  362  761:iconst_0        
    //  363  762:putfield        #313 <Field int GridBagConstraints.gridx>
        gbL.setConstraints(buttons, gbC);
    //  364  765:aload           6
    //  365  767:aload_2         
    //  366  768:aload           7
    //  367  770:invokevirtual   #317 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        mondo.add(buttons);
    //  368  773:aload           8
    //  369  775:aload_2         
    //  370  776:invokevirtual   #275 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  371  779:pop             
        gbC = new GridBagConstraints();
    //  372  780:new             #300 <Class GridBagConstraints>
    //  373  783:dup             
    //  374  784:invokespecial   #301 <Method void GridBagConstraints()>
    //  375  787:astore          7
        gbC.fill = 1;
    //  376  789:aload           7
    //  377  791:iconst_1        
    //  378  792:putfield        #307 <Field int GridBagConstraints.fill>
        gbC.gridy = 2;
    //  379  795:aload           7
    //  380  797:iconst_2        
    //  381  798:putfield        #310 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  382  801:aload           7
    //  383  803:iconst_0        
    //  384  804:putfield        #313 <Field int GridBagConstraints.gridx>
        gbC.weightx = 0.0D;
    //  385  807:aload           7
    //  386  809:dconst_0        
    //  387  810:putfield        #321 <Field double GridBagConstraints.weightx>
        gbL.setConstraints(m_History, gbC);
    //  388  813:aload           6
    //  389  815:aload_0         
    //  390  816:getfield        #92  <Field ResultHistoryPanel m_History>
    //  391  819:aload           7
    //  392  821:invokevirtual   #317 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        mondo.add(m_History);
    //  393  824:aload           8
    //  394  826:aload_0         
    //  395  827:getfield        #92  <Field ResultHistoryPanel m_History>
    //  396  830:invokevirtual   #275 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  397  833:pop             
        gbC = new GridBagConstraints();
    //  398  834:new             #300 <Class GridBagConstraints>
    //  399  837:dup             
    //  400  838:invokespecial   #301 <Method void GridBagConstraints()>
    //  401  841:astore          7
        gbC.fill = 1;
    //  402  843:aload           7
    //  403  845:iconst_1        
    //  404  846:putfield        #307 <Field int GridBagConstraints.fill>
        gbC.gridy = 0;
    //  405  849:aload           7
    //  406  851:iconst_0        
    //  407  852:putfield        #310 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  408  855:aload           7
    //  409  857:iconst_1        
    //  410  858:putfield        #313 <Field int GridBagConstraints.gridx>
        gbC.gridheight = 3;
    //  411  861:aload           7
    //  412  863:iconst_3        
    //  413  864:putfield        #324 <Field int GridBagConstraints.gridheight>
        gbC.weightx = 100D;
    //  414  867:aload           7
    //  415  869:ldc2w           #325 <Double 100D>
    //  416  872:putfield        #321 <Field double GridBagConstraints.weightx>
        gbC.weighty = 100D;
    //  417  875:aload           7
    //  418  877:ldc2w           #325 <Double 100D>
    //  419  880:putfield        #329 <Field double GridBagConstraints.weighty>
        gbL.setConstraints(p3, gbC);
    //  420  883:aload           6
    //  421  885:aload           4
    //  422  887:aload           7
    //  423  889:invokevirtual   #317 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        mondo.add(p3);
    //  424  892:aload           8
    //  425  894:aload           4
    //  426  896:invokevirtual   #275 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  427  899:pop             
        setLayout(new BorderLayout());
    //  428  900:aload_0         
    //  429  901:new             #213 <Class BorderLayout>
    //  430  904:dup             
    //  431  905:invokespecial   #214 <Method void BorderLayout()>
    //  432  908:invokevirtual   #330 <Method void setLayout(java.awt.LayoutManager)>
        add(p1, "North");
    //  433  911:aload_0         
    //  434  912:aload_1         
    //  435  913:ldc2            #264 <String "North">
    //  436  916:invokevirtual   #331 <Method void add(java.awt.Component, Object)>
        add(mondo, "Center");
    //  437  919:aload_0         
    //  438  920:aload           8
    //  439  922:ldc1            #237 <String "Center">
    //  440  924:invokevirtual   #331 <Method void add(java.awt.Component, Object)>
    //  441  927:return          
    }

    public void setLog(Logger newLog)
    {
        m_Log = newLog;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #85  <Field Logger m_Log>
    //    3    5:return          
    }

    protected void LoadPAFile()
    {
        m_FileChooser.setDialogTitle("Load the role - permission assignment");
    //    0    0:aload_0         
    //    1    1:getfield        #123 <Field JFileChooser m_FileChooser>
    //    2    4:ldc2            #350 <String "Load the role - permission assignment">
    //    3    7:invokevirtual   #353 <Method void JFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //    4   10:aload_0         
    //    5   11:getfield        #123 <Field JFileChooser m_FileChooser>
    //    6   14:new             #355 <Class File>
    //    7   17:dup             
    //    8   18:ldc2            #357 <String "user.dir">
    //    9   21:invokestatic    #363 <Method String System.getProperty(String)>
    //   10   24:invokespecial   #364 <Method void File(String)>
    //   11   27:invokevirtual   #368 <Method void JFileChooser.setCurrentDirectory(File)>
        try
        {
            Fileflag = m_FileChooser.showOpenDialog(this);
    //   12   30:aload_0         
    //   13   31:aload_0         
    //   14   32:getfield        #123 <Field JFileChooser m_FileChooser>
    //   15   35:aload_0         
    //   16   36:invokevirtual   #372 <Method int JFileChooser.showOpenDialog(java.awt.Component)>
    //   17   39:putfield        #374 <Field int Fileflag>
        }
    //*  18   42:goto            55
        catch(HeadlessException head)
    //*  19   45:astore_1        
        {
            System.out.println("Open File Dialog ERROR!");
    //   20   46:getstatic       #378 <Field PrintStream System.out>
    //   21   49:ldc2            #380 <String "Open File Dialog ERROR!">
    //   22   52:invokevirtual   #385 <Method void PrintStream.println(String)>
        }
        if(Fileflag == 0)
    //*  23   55:aload_0         
    //*  24   56:getfield        #374 <Field int Fileflag>
    //*  25   59:ifne            182
        {
            SelectedFile = m_FileChooser.getSelectedFile();
    //   26   62:aload_0         
    //   27   63:aload_0         
    //   28   64:getfield        #123 <Field JFileChooser m_FileChooser>
    //   29   67:invokevirtual   #389 <Method File JFileChooser.getSelectedFile()>
    //   30   70:putfield        #125 <Field File SelectedFile>
            try
            {
                if(SelectedFile != null)
    //*  31   73:aload_0         
    //*  32   74:getfield        #125 <Field File SelectedFile>
    //*  33   77:ifnull          162
                {
                    AssLoader AssLoad = new AssLoader(new FileReader(SelectedFile));
    //   34   80:new             #391 <Class AssLoader>
    //   35   83:dup             
    //   36   84:new             #393 <Class FileReader>
    //   37   87:dup             
    //   38   88:aload_0         
    //   39   89:getfield        #125 <Field File SelectedFile>
    //   40   92:invokespecial   #395 <Method void FileReader(File)>
    //   41   95:invokespecial   #398 <Method void AssLoader(FileReader)>
    //   42   98:astore_1        
                    AssPAData = AssLoad.getData();
    //   43   99:aload_0         
    //   44  100:aload_1         
    //   45  101:invokevirtual   #402 <Method rm.core.Assignment AssLoader.getData()>
    //   46  104:putfield        #127 <Field rm.core.Assignment AssPAData>
                    setRoles(AssPAData);
    //   47  107:aload_0         
    //   48  108:aload_0         
    //   49  109:getfield        #127 <Field rm.core.Assignment AssPAData>
    //   50  112:invokevirtual   #406 <Method void setRoles(rm.core.Assignment)>
                    m_Log.statusMessage("Open an Assignment File");
    //   51  115:aload_0         
    //   52  116:getfield        #85  <Field Logger m_Log>
    //   53  119:ldc2            #408 <String "Open an Assignment File">
    //   54  122:invokeinterface #413 <Method void Logger.statusMessage(String)>
                    m_Log.logMessage((new StringBuilder("Load the assignment file: ")).append(SelectedFile.getName()).toString());
    //   55  127:aload_0         
    //   56  128:getfield        #85  <Field Logger m_Log>
    //   57  131:new             #415 <Class StringBuilder>
    //   58  134:dup             
    //   59  135:ldc2            #417 <String "Load the assignment file: ">
    //   60  138:invokespecial   #418 <Method void StringBuilder(String)>
    //   61  141:aload_0         
    //   62  142:getfield        #125 <Field File SelectedFile>
    //   63  145:invokevirtual   #422 <Method String File.getName()>
    //   64  148:invokevirtual   #426 <Method StringBuilder StringBuilder.append(String)>
    //   65  151:invokevirtual   #429 <Method String StringBuilder.toString()>
    //   66  154:invokeinterface #432 <Method void Logger.logMessage(String)>
                } else
    //*  67  159:goto            182
                {
                    m_Log.statusMessage("Open File ERROR");
    //   68  162:aload_0         
    //   69  163:getfield        #85  <Field Logger m_Log>
    //   70  166:ldc2            #434 <String "Open File ERROR">
    //   71  169:invokeinterface #413 <Method void Logger.statusMessage(String)>
                }
            }
    //*  72  174:goto            182
            catch(Exception e)
    //*  73  177:astore_1        
            {
                e.printStackTrace();
    //   74  178:aload_1         
    //   75  179:invokevirtual   #439 <Method void Exception.printStackTrace()>
            }
        }
    //   76  182:return          
    }

    protected void startAssignmenter()
    {
        if(m_RunThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #450 <Field Thread m_RunThread>
    //*   2    4:ifnonnull       50
        {
            m_StartBut.setEnabled(false);
    //    3    7:aload_0         
    //    4    8:getfield        #101 <Field JButton m_StartBut>
    //    5   11:iconst_0        
    //    6   12:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
            m_StopBut.setEnabled(true);
    //    7   15:aload_0         
    //    8   16:getfield        #105 <Field JButton m_StopBut>
    //    9   19:iconst_1        
    //   10   20:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
            m_RunThread = new Thread() {

                public void run()
                {
                    Assignment assigner;
                    StringBuffer outBuff;
                    String name;
                    String cname;
                    String cmd;
                    m_Log.statusMessage("Setting up...");
                //    0    0:aload_0         
                //    1    1:getfield        #11  <Field AssignmentPanel this$0>
                //    2    4:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //    3    7:ldc1            #27  <String "Setting up...">
                //    4    9:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    assigner = (Assignment)m_AssignmentEditor.getValue();
                //    5   14:aload_0         
                //    6   15:getfield        #11  <Field AssignmentPanel this$0>
                //    7   18:getfield        #37  <Field GenericObjectEditor AssignmentPanel.m_AssignmentEditor>
                //    8   21:invokevirtual   #43  <Method Object GenericObjectEditor.getValue()>
                //    9   24:checkcast       #45  <Class Assignment>
                //   10   27:astore_1        
                    outBuff = new StringBuffer();
                //   11   28:new             #47  <Class StringBuffer>
                //   12   31:dup             
                //   13   32:invokespecial   #48  <Method void StringBuffer()>
                //   14   35:astore_2        
                    name = (new SimpleDateFormat("HH:mm:ss - ")).format(new Date());
                //   15   36:new             #50  <Class SimpleDateFormat>
                //   16   39:dup             
                //   17   40:ldc1            #52  <String "HH:mm:ss - ">
                //   18   42:invokespecial   #54  <Method void SimpleDateFormat(String)>
                //   19   45:new             #56  <Class Date>
                //   20   48:dup             
                //   21   49:invokespecial   #57  <Method void Date()>
                //   22   52:invokevirtual   #61  <Method String SimpleDateFormat.format(Date)>
                //   23   55:astore_3        
                    cname = assigner.getClass().getName();
                //   24   56:aload_1         
                //   25   57:invokevirtual   #67  <Method Class Object.getClass()>
                //   26   60:invokevirtual   #73  <Method String Class.getName()>
                //   27   63:astore          4
                    if(cname.startsWith("rm.assignment."))
                //*  28   65:aload           4
                //*  29   67:ldc1            #75  <String "rm.assignment.">
                //*  30   69:invokevirtual   #81  <Method boolean String.startsWith(String)>
                //*  31   72:ifeq            106
                        name = (new StringBuilder(String.valueOf(name))).append(cname.substring("rm.assignment.".length())).toString();
                //   32   75:new             #83  <Class StringBuilder>
                //   33   78:dup             
                //   34   79:aload_3         
                //   35   80:invokestatic    #87  <Method String String.valueOf(Object)>
                //   36   83:invokespecial   #88  <Method void StringBuilder(String)>
                //   37   86:aload           4
                //   38   88:ldc1            #75  <String "rm.assignment.">
                //   39   90:invokevirtual   #92  <Method int String.length()>
                //   40   93:invokevirtual   #96  <Method String String.substring(int)>
                //   41   96:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //   42   99:invokevirtual   #103 <Method String StringBuilder.toString()>
                //   43  102:astore_3        
                    else
                //*  44  103:goto            126
                        name = (new StringBuilder(String.valueOf(name))).append(cname).toString();
                //   45  106:new             #83  <Class StringBuilder>
                //   46  109:dup             
                //   47  110:aload_3         
                //   48  111:invokestatic    #87  <Method String String.valueOf(Object)>
                //   49  114:invokespecial   #88  <Method void StringBuilder(String)>
                //   50  117:aload           4
                //   51  119:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //   52  122:invokevirtual   #103 <Method String StringBuilder.toString()>
                //   53  125:astore_3        
                    cmd = m_AssignmentEditor.getValue().getClass().getName();
                //   54  126:aload_0         
                //   55  127:getfield        #11  <Field AssignmentPanel this$0>
                //   56  130:getfield        #37  <Field GenericObjectEditor AssignmentPanel.m_AssignmentEditor>
                //   57  133:invokevirtual   #43  <Method Object GenericObjectEditor.getValue()>
                //   58  136:invokevirtual   #67  <Method Class Object.getClass()>
                //   59  139:invokevirtual   #73  <Method String Class.getName()>
                //   60  142:astore          5
                    if(m_AssignmentEditor.getValue() instanceof OptionHandler)
                //*  61  144:aload_0         
                //*  62  145:getfield        #11  <Field AssignmentPanel this$0>
                //*  63  148:getfield        #37  <Field GenericObjectEditor AssignmentPanel.m_AssignmentEditor>
                //*  64  151:invokevirtual   #43  <Method Object GenericObjectEditor.getValue()>
                //*  65  154:instanceof      #105 <Class OptionHandler>
                //*  66  157:ifeq            206
                        cmd = (new StringBuilder(String.valueOf(cmd))).append(" ").append(Utils.joinOptions(((OptionHandler)m_AssignmentEditor.getValue()).getOptions())).toString();
                //   67  160:new             #83  <Class StringBuilder>
                //   68  163:dup             
                //   69  164:aload           5
                //   70  166:invokestatic    #87  <Method String String.valueOf(Object)>
                //   71  169:invokespecial   #88  <Method void StringBuilder(String)>
                //   72  172:ldc1            #107 <String " ">
                //   73  174:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //   74  177:aload_0         
                //   75  178:getfield        #11  <Field AssignmentPanel this$0>
                //   76  181:getfield        #37  <Field GenericObjectEditor AssignmentPanel.m_AssignmentEditor>
                //   77  184:invokevirtual   #43  <Method Object GenericObjectEditor.getValue()>
                //   78  187:checkcast       #105 <Class OptionHandler>
                //   79  190:invokeinterface #111 <Method String[] OptionHandler.getOptions()>
                //   80  195:invokestatic    #117 <Method String Utils.joinOptions(String[])>
                //   81  198:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //   82  201:invokevirtual   #103 <Method String StringBuilder.toString()>
                //   83  204:astore          5
                    try
                    {
                        m_Log.logMessage((new StringBuilder("Started ")).append(cname).toString());
                //   84  206:aload_0         
                //   85  207:getfield        #11  <Field AssignmentPanel this$0>
                //   86  210:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //   87  213:new             #83  <Class StringBuilder>
                //   88  216:dup             
                //   89  217:ldc1            #119 <String "Started ">
                //   90  219:invokespecial   #88  <Method void StringBuilder(String)>
                //   91  222:aload           4
                //   92  224:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //   93  227:invokevirtual   #103 <Method String StringBuilder.toString()>
                //   94  230:invokeinterface #122 <Method void Logger.logMessage(String)>
                        m_Log.logMessage((new StringBuilder("Command: ")).append(cmd).toString());
                //   95  235:aload_0         
                //   96  236:getfield        #11  <Field AssignmentPanel this$0>
                //   97  239:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //   98  242:new             #83  <Class StringBuilder>
                //   99  245:dup             
                //  100  246:ldc1            #124 <String "Command: ">
                //  101  248:invokespecial   #88  <Method void StringBuilder(String)>
                //  102  251:aload           5
                //  103  253:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  104  256:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  105  259:invokeinterface #122 <Method void Logger.logMessage(String)>
                        if(m_Log instanceof TaskLogger)
                //* 106  264:aload_0         
                //* 107  265:getfield        #11  <Field AssignmentPanel this$0>
                //* 108  268:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //* 109  271:instanceof      #126 <Class TaskLogger>
                //* 110  274:ifeq            292
                            ((TaskLogger)m_Log).taskStarted();
                //  111  277:aload_0         
                //  112  278:getfield        #11  <Field AssignmentPanel this$0>
                //  113  281:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  114  284:checkcast       #126 <Class TaskLogger>
                //  115  287:invokeinterface #129 <Method void TaskLogger.taskStarted()>
                        outBuff.append("=== Run information ===\n\n");
                //  116  292:aload_2         
                //  117  293:ldc1            #131 <String "=== Run information ===\n\n">
                //  118  295:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  119  298:pop             
                        outBuff.append((new StringBuilder("Scheme:       ")).append(cname).toString());
                //  120  299:aload_2         
                //  121  300:new             #83  <Class StringBuilder>
                //  122  303:dup             
                //  123  304:ldc1            #136 <String "Scheme:       ">
                //  124  306:invokespecial   #88  <Method void StringBuilder(String)>
                //  125  309:aload           4
                //  126  311:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  127  314:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  128  317:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  129  320:pop             
                        if(assigner instanceof OptionHandler)
                //* 130  321:aload_1         
                //* 131  322:instanceof      #105 <Class OptionHandler>
                //* 132  325:ifeq            364
                        {
                            String o[] = ((OptionHandler)assigner).getOptions();
                //  133  328:aload_1         
                //  134  329:checkcast       #105 <Class OptionHandler>
                //  135  332:invokeinterface #111 <Method String[] OptionHandler.getOptions()>
                //  136  337:astore          6
                            outBuff.append((new StringBuilder(" ")).append(Utils.joinOptions(o)).toString());
                //  137  339:aload_2         
                //  138  340:new             #83  <Class StringBuilder>
                //  139  343:dup             
                //  140  344:ldc1            #107 <String " ">
                //  141  346:invokespecial   #88  <Method void StringBuilder(String)>
                //  142  349:aload           6
                //  143  351:invokestatic    #117 <Method String Utils.joinOptions(String[])>
                //  144  354:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  145  357:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  146  360:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  147  363:pop             
                        }
                        outBuff.append("\n");
                //  148  364:aload_2         
                //  149  365:ldc1            #138 <String "\n">
                //  150  367:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  151  370:pop             
                        outBuff.append((new StringBuilder("UPA:  ")).append(m_assignment.getAssignementName()).append('\n').toString());
                //  152  371:aload_2         
                //  153  372:new             #83  <Class StringBuilder>
                //  154  375:dup             
                //  155  376:ldc1            #140 <String "UPA:  ">
                //  156  378:invokespecial   #88  <Method void StringBuilder(String)>
                //  157  381:aload_0         
                //  158  382:getfield        #11  <Field AssignmentPanel this$0>
                //  159  385:getfield        #144 <Field rm.core.Assignment AssignmentPanel.m_assignment>
                //  160  388:invokevirtual   #149 <Method String rm.core.Assignment.getAssignementName()>
                //  161  391:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  162  394:bipush          10
                //  163  396:invokevirtual   #152 <Method StringBuilder StringBuilder.append(char)>
                //  164  399:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  165  402:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  166  405:pop             
                        outBuff.append((new StringBuilder(String.valueOf(m_assignment.toObjectAtrribute()))).append('\n').toString());
                //  167  406:aload_2         
                //  168  407:new             #83  <Class StringBuilder>
                //  169  410:dup             
                //  170  411:aload_0         
                //  171  412:getfield        #11  <Field AssignmentPanel this$0>
                //  172  415:getfield        #144 <Field rm.core.Assignment AssignmentPanel.m_assignment>
                //  173  418:invokevirtual   #155 <Method String rm.core.Assignment.toObjectAtrribute()>
                //  174  421:invokestatic    #87  <Method String String.valueOf(Object)>
                //  175  424:invokespecial   #88  <Method void StringBuilder(String)>
                //  176  427:bipush          10
                //  177  429:invokevirtual   #152 <Method StringBuilder StringBuilder.append(char)>
                //  178  432:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  179  435:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  180  438:pop             
                        outBuff.append((new StringBuilder("PA:  ")).append(m_assroles.getAssignementName()).append('\n').toString());
                //  181  439:aload_2         
                //  182  440:new             #83  <Class StringBuilder>
                //  183  443:dup             
                //  184  444:ldc1            #157 <String "PA:  ">
                //  185  446:invokespecial   #88  <Method void StringBuilder(String)>
                //  186  449:aload_0         
                //  187  450:getfield        #11  <Field AssignmentPanel this$0>
                //  188  453:getfield        #160 <Field rm.core.Assignment AssignmentPanel.m_assroles>
                //  189  456:invokevirtual   #149 <Method String rm.core.Assignment.getAssignementName()>
                //  190  459:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  191  462:bipush          10
                //  192  464:invokevirtual   #152 <Method StringBuilder StringBuilder.append(char)>
                //  193  467:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  194  470:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  195  473:pop             
                        outBuff.append((new StringBuilder(String.valueOf(m_assroles.toObjectAtrribute()))).append('\n').toString());
                //  196  474:aload_2         
                //  197  475:new             #83  <Class StringBuilder>
                //  198  478:dup             
                //  199  479:aload_0         
                //  200  480:getfield        #11  <Field AssignmentPanel this$0>
                //  201  483:getfield        #160 <Field rm.core.Assignment AssignmentPanel.m_assroles>
                //  202  486:invokevirtual   #155 <Method String rm.core.Assignment.toObjectAtrribute()>
                //  203  489:invokestatic    #87  <Method String String.valueOf(Object)>
                //  204  492:invokespecial   #88  <Method void StringBuilder(String)>
                //  205  495:bipush          10
                //  206  497:invokevirtual   #152 <Method StringBuilder StringBuilder.append(char)>
                //  207  500:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  208  503:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  209  506:pop             
                        m_History.addResult(name, outBuff);
                //  210  507:aload_0         
                //  211  508:getfield        #11  <Field AssignmentPanel this$0>
                //  212  511:getfield        #164 <Field ResultHistoryPanel AssignmentPanel.m_History>
                //  213  514:aload_3         
                //  214  515:aload_2         
                //  215  516:invokevirtual   #170 <Method void ResultHistoryPanel.addResult(String, StringBuffer)>
                        m_History.setSingle(name);
                //  216  519:aload_0         
                //  217  520:getfield        #11  <Field AssignmentPanel this$0>
                //  218  523:getfield        #164 <Field ResultHistoryPanel AssignmentPanel.m_History>
                //  219  526:aload_3         
                //  220  527:invokevirtual   #173 <Method void ResultHistoryPanel.setSingle(String)>
                        m_Log.statusMessage("Building model on upa and pa data...");
                //  221  530:aload_0         
                //  222  531:getfield        #11  <Field AssignmentPanel this$0>
                //  223  534:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  224  537:ldc1            #175 <String "Building model on upa and pa data...">
                //  225  539:invokeinterface #33  <Method void Logger.statusMessage(String)>
                        long startTime = System.currentTimeMillis();
                //  226  544:invokestatic    #181 <Method long System.currentTimeMillis()>
                //  227  547:lstore          6
                        assigner.buildAssigns(m_assignment, m_assroles);
                //  228  549:aload_1         
                //  229  550:aload_0         
                //  230  551:getfield        #11  <Field AssignmentPanel this$0>
                //  231  554:getfield        #144 <Field rm.core.Assignment AssignmentPanel.m_assignment>
                //  232  557:aload_0         
                //  233  558:getfield        #11  <Field AssignmentPanel this$0>
                //  234  561:getfield        #160 <Field rm.core.Assignment AssignmentPanel.m_assroles>
                //  235  564:invokeinterface #185 <Method void Assignment.buildAssigns(rm.core.Assignment, rm.core.Assignment)>
                        long endTime = System.currentTimeMillis();
                //  236  569:invokestatic    #181 <Method long System.currentTimeMillis()>
                //  237  572:lstore          8
                        outBuff.append("===  model (full dataset) ===\n\n");
                //  238  574:aload_2         
                //  239  575:ldc1            #187 <String "===  model (full dataset) ===\n\n">
                //  240  577:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  241  580:pop             
                        outBuff.append((new StringBuilder(String.valueOf(assigner.toString()))).append('\n').toString());
                //  242  581:aload_2         
                //  243  582:new             #83  <Class StringBuilder>
                //  244  585:dup             
                //  245  586:aload_1         
                //  246  587:invokevirtual   #188 <Method String Object.toString()>
                //  247  590:invokestatic    #87  <Method String String.valueOf(Object)>
                //  248  593:invokespecial   #88  <Method void StringBuilder(String)>
                //  249  596:bipush          10
                //  250  598:invokevirtual   #152 <Method StringBuilder StringBuilder.append(char)>
                //  251  601:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  252  604:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  253  607:pop             
                        m_assua = assigner.generateUA();
                //  254  608:aload_0         
                //  255  609:getfield        #11  <Field AssignmentPanel this$0>
                //  256  612:aload_1         
                //  257  613:invokeinterface #192 <Method rm.core.Assignment Assignment.generateUA()>
                //  258  618:putfield        #195 <Field rm.core.Assignment AssignmentPanel.m_assua>
                        outBuff.append("\n=== Evaluation ===\n\n");
                //  259  621:aload_2         
                //  260  622:ldc1            #197 <String "\n=== Evaluation ===\n\n">
                //  261  624:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  262  627:pop             
                        Option option;
                        for(Enumeration enm = ((OptionHandler)assigner).listOptions(); enm.hasMoreElements(); outBuff.append((new StringBuilder(String.valueOf(option.description()))).append("\n").toString()))
                //* 263  628:aload_1         
                //* 264  629:checkcast       #105 <Class OptionHandler>
                //* 265  632:invokeinterface #201 <Method Enumeration OptionHandler.listOptions()>
                //* 266  637:astore          10
                //* 267  639:goto            713
                        {
                            option = (Option)(Option)enm.nextElement();
                //  268  642:aload           10
                //  269  644:invokeinterface #206 <Method Object Enumeration.nextElement()>
                //  270  649:checkcast       #208 <Class Option>
                //  271  652:checkcast       #208 <Class Option>
                //  272  655:astore          11
                            outBuff.append((new StringBuilder(String.valueOf(option.synopsis()))).append("\n").toString());
                //  273  657:aload_2         
                //  274  658:new             #83  <Class StringBuilder>
                //  275  661:dup             
                //  276  662:aload           11
                //  277  664:invokevirtual   #211 <Method String Option.synopsis()>
                //  278  667:invokestatic    #87  <Method String String.valueOf(Object)>
                //  279  670:invokespecial   #88  <Method void StringBuilder(String)>
                //  280  673:ldc1            #138 <String "\n">
                //  281  675:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  282  678:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  283  681:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  284  684:pop             
                        }

                //  285  685:aload_2         
                //  286  686:new             #83  <Class StringBuilder>
                //  287  689:dup             
                //  288  690:aload           11
                //  289  692:invokevirtual   #214 <Method String Option.description()>
                //  290  695:invokestatic    #87  <Method String String.valueOf(Object)>
                //  291  698:invokespecial   #88  <Method void StringBuilder(String)>
                //  292  701:ldc1            #138 <String "\n">
                //  293  703:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  294  706:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  295  709:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  296  712:pop             
                //  297  713:aload           10
                //  298  715:invokeinterface #218 <Method boolean Enumeration.hasMoreElements()>
                //  299  720:ifne            642
                        outBuff.append("\n\n");
                //  300  723:aload_2         
                //  301  724:ldc1            #220 <String "\n\n">
                //  302  726:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  303  729:pop             
                        outBuff.append((new StringBuilder("Elapsed time: ")).append(endTime - startTime).append(" milliseconds").toString());
                //  304  730:aload_2         
                //  305  731:new             #83  <Class StringBuilder>
                //  306  734:dup             
                //  307  735:ldc1            #222 <String "Elapsed time: ">
                //  308  737:invokespecial   #88  <Method void StringBuilder(String)>
                //  309  740:lload           8
                //  310  742:lload           6
                //  311  744:lsub            
                //  312  745:l2d             
                //  313  746:invokevirtual   #225 <Method StringBuilder StringBuilder.append(double)>
                //  314  749:ldc1            #227 <String " milliseconds">
                //  315  751:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  316  754:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  317  757:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  318  760:pop             
                        outBuff.append("\n");
                //  319  761:aload_2         
                //  320  762:ldc1            #138 <String "\n">
                //  321  764:invokevirtual   #134 <Method StringBuffer StringBuffer.append(String)>
                //  322  767:pop             
                        m_History.updateResult(name);
                //  323  768:aload_0         
                //  324  769:getfield        #11  <Field AssignmentPanel this$0>
                //  325  772:getfield        #164 <Field ResultHistoryPanel AssignmentPanel.m_History>
                //  326  775:aload_3         
                //  327  776:invokevirtual   #230 <Method void ResultHistoryPanel.updateResult(String)>
                        m_Log.logMessage((new StringBuilder("Finished ")).append(cname).toString());
                //  328  779:aload_0         
                //  329  780:getfield        #11  <Field AssignmentPanel this$0>
                //  330  783:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  331  786:new             #83  <Class StringBuilder>
                //  332  789:dup             
                //  333  790:ldc1            #232 <String "Finished ">
                //  334  792:invokespecial   #88  <Method void StringBuilder(String)>
                //  335  795:aload           4
                //  336  797:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  337  800:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  338  803:invokeinterface #122 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("OK");
                //  339  808:aload_0         
                //  340  809:getfield        #11  <Field AssignmentPanel this$0>
                //  341  812:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  342  815:ldc1            #234 <String "OK">
                //  343  817:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                //* 344  822:goto            974
                    catch(Exception ex)
                //* 345  825:astore          6
                    {
                        m_Log.logMessage(ex.getMessage());
                //  346  827:aload_0         
                //  347  828:getfield        #11  <Field AssignmentPanel this$0>
                //  348  831:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  349  834:aload           6
                //  350  836:invokevirtual   #239 <Method String Exception.getMessage()>
                //  351  839:invokeinterface #122 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("See error log");
                //  352  844:aload_0         
                //  353  845:getfield        #11  <Field AssignmentPanel this$0>
                //  354  848:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  355  851:ldc1            #241 <String "See error log">
                //  356  853:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                    break MISSING_BLOCK_LABEL_974;
                //  357  858:goto            974
                    Exception exception;
                    exception;
                //  358  861:astore          12
                    if(isInterrupted())
                //* 359  863:aload_0         
                //* 360  864:invokevirtual   #244 <Method boolean isInterrupted()>
                //* 361  867:ifeq            913
                    {
                        m_Log.logMessage((new StringBuilder("Interrupted ")).append(cname).toString());
                //  362  870:aload_0         
                //  363  871:getfield        #11  <Field AssignmentPanel this$0>
                //  364  874:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  365  877:new             #83  <Class StringBuilder>
                //  366  880:dup             
                //  367  881:ldc1            #246 <String "Interrupted ">
                //  368  883:invokespecial   #88  <Method void StringBuilder(String)>
                //  369  886:aload           4
                //  370  888:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  371  891:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  372  894:invokeinterface #122 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("See error log");
                //  373  899:aload_0         
                //  374  900:getfield        #11  <Field AssignmentPanel this$0>
                //  375  903:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  376  906:ldc1            #241 <String "See error log">
                //  377  908:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                    m_RunThread = null;
                //  378  913:aload_0         
                //  379  914:getfield        #11  <Field AssignmentPanel this$0>
                //  380  917:aconst_null     
                //  381  918:putfield        #250 <Field Thread AssignmentPanel.m_RunThread>
                    m_StartBut.setEnabled(true);
                //  382  921:aload_0         
                //  383  922:getfield        #11  <Field AssignmentPanel this$0>
                //  384  925:getfield        #254 <Field JButton AssignmentPanel.m_StartBut>
                //  385  928:iconst_1        
                //  386  929:invokevirtual   #260 <Method void JButton.setEnabled(boolean)>
                    m_StopBut.setEnabled(false);
                //  387  932:aload_0         
                //  388  933:getfield        #11  <Field AssignmentPanel this$0>
                //  389  936:getfield        #263 <Field JButton AssignmentPanel.m_StopBut>
                //  390  939:iconst_0        
                //  391  940:invokevirtual   #260 <Method void JButton.setEnabled(boolean)>
                    if(m_Log instanceof TaskLogger)
                //* 392  943:aload_0         
                //* 393  944:getfield        #11  <Field AssignmentPanel this$0>
                //* 394  947:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //* 395  950:instanceof      #126 <Class TaskLogger>
                //* 396  953:ifeq            971
                        ((TaskLogger)m_Log).taskFinished();
                //  397  956:aload_0         
                //  398  957:getfield        #11  <Field AssignmentPanel this$0>
                //  399  960:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  400  963:checkcast       #126 <Class TaskLogger>
                //  401  966:invokeinterface #266 <Method void TaskLogger.taskFinished()>
                    throw exception;
                //  402  971:aload           12
                //  403  973:athrow          
                    if(isInterrupted())
                //* 404  974:aload_0         
                //* 405  975:invokevirtual   #244 <Method boolean isInterrupted()>
                //* 406  978:ifeq            1024
                    {
                        m_Log.logMessage((new StringBuilder("Interrupted ")).append(cname).toString());
                //  407  981:aload_0         
                //  408  982:getfield        #11  <Field AssignmentPanel this$0>
                //  409  985:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  410  988:new             #83  <Class StringBuilder>
                //  411  991:dup             
                //  412  992:ldc1            #246 <String "Interrupted ">
                //  413  994:invokespecial   #88  <Method void StringBuilder(String)>
                //  414  997:aload           4
                //  415  999:invokevirtual   #100 <Method StringBuilder StringBuilder.append(String)>
                //  416 1002:invokevirtual   #103 <Method String StringBuilder.toString()>
                //  417 1005:invokeinterface #122 <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("See error log");
                //  418 1010:aload_0         
                //  419 1011:getfield        #11  <Field AssignmentPanel this$0>
                //  420 1014:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  421 1017:ldc1            #241 <String "See error log">
                //  422 1019:invokeinterface #33  <Method void Logger.statusMessage(String)>
                    }
                    m_RunThread = null;
                //  423 1024:aload_0         
                //  424 1025:getfield        #11  <Field AssignmentPanel this$0>
                //  425 1028:aconst_null     
                //  426 1029:putfield        #250 <Field Thread AssignmentPanel.m_RunThread>
                    m_StartBut.setEnabled(true);
                //  427 1032:aload_0         
                //  428 1033:getfield        #11  <Field AssignmentPanel this$0>
                //  429 1036:getfield        #254 <Field JButton AssignmentPanel.m_StartBut>
                //  430 1039:iconst_1        
                //  431 1040:invokevirtual   #260 <Method void JButton.setEnabled(boolean)>
                    m_StopBut.setEnabled(false);
                //  432 1043:aload_0         
                //  433 1044:getfield        #11  <Field AssignmentPanel this$0>
                //  434 1047:getfield        #263 <Field JButton AssignmentPanel.m_StopBut>
                //  435 1050:iconst_0        
                //  436 1051:invokevirtual   #260 <Method void JButton.setEnabled(boolean)>
                    if(m_Log instanceof TaskLogger)
                //* 437 1054:aload_0         
                //* 438 1055:getfield        #11  <Field AssignmentPanel this$0>
                //* 439 1058:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //* 440 1061:instanceof      #126 <Class TaskLogger>
                //* 441 1064:ifeq            1082
                        ((TaskLogger)m_Log).taskFinished();
                //  442 1067:aload_0         
                //  443 1068:getfield        #11  <Field AssignmentPanel this$0>
                //  444 1071:getfield        #25  <Field Logger AssignmentPanel.m_Log>
                //  445 1074:checkcast       #126 <Class TaskLogger>
                //  446 1077:invokeinterface #266 <Method void TaskLogger.taskFinished()>
                    return;
                //  447 1082:return          
                }

                final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void Thread()>
            //    5    9:return          
            }
            }
;
    //   11   23:aload_0         
    //   12   24:new             #452 <Class AssignmentPanel$9>
    //   13   27:dup             
    //   14   28:aload_0         
    //   15   29:invokespecial   #453 <Method void AssignmentPanel$9(AssignmentPanel)>
    //   16   32:putfield        #450 <Field Thread m_RunThread>
            m_RunThread.setPriority(1);
    //   17   35:aload_0         
    //   18   36:getfield        #450 <Field Thread m_RunThread>
    //   19   39:iconst_1        
    //   20   40:invokevirtual   #459 <Method void Thread.setPriority(int)>
            m_RunThread.start();
    //   21   43:aload_0         
    //   22   44:getfield        #450 <Field Thread m_RunThread>
    //   23   47:invokevirtual   #462 <Method void Thread.start()>
        }
    //   24   50:return          
    }

    protected void stopAssignmenter()
    {
        if(m_RunThread != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #450 <Field Thread m_RunThread>
    //*   2    4:ifnull          21
        {
            m_RunThread.interrupt();
    //    3    7:aload_0         
    //    4    8:getfield        #450 <Field Thread m_RunThread>
    //    5   11:invokevirtual   #466 <Method void Thread.interrupt()>
            m_RunThread.stop();
    //    6   14:aload_0         
    //    7   15:getfield        #450 <Field Thread m_RunThread>
    //    8   18:invokevirtual   #469 <Method void Thread.stop()>
        }
    //    9   21:return          
    }

    public void setAssignments(rm.core.Assignment assign)
    {
        m_assignment = assign;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #472 <Field rm.core.Assignment m_assignment>
        m_StartBut.setEnabled(m_RunThread == null);
    //    3    5:aload_0         
    //    4    6:getfield        #101 <Field JButton m_StartBut>
    //    5    9:aload_0         
    //    6   10:getfield        #450 <Field Thread m_RunThread>
    //    7   13:ifnonnull       20
    //    8   16:iconst_1        
    //    9   17:goto            21
    //   10   20:iconst_0        
    //   11   21:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
        m_StopBut.setEnabled(m_RunThread != null);
    //   12   24:aload_0         
    //   13   25:getfield        #105 <Field JButton m_StopBut>
    //   14   28:aload_0         
    //   15   29:getfield        #450 <Field Thread m_RunThread>
    //   16   32:ifnull          39
    //   17   35:iconst_1        
    //   18   36:goto            40
    //   19   39:iconst_0        
    //   20   40:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
    //   21   43:return          
    }

    public void setRoles(rm.core.Assignment assroles)
    {
        m_assroles = assroles;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #475 <Field rm.core.Assignment m_assroles>
        String TxtRoles = "-F Default";
    //    3    5:ldc2            #477 <String "-F Default">
    //    4    8:astore_2        
        TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -N ").append(m_assroles.getAssignementName()).toString();
    //    5    9:new             #415 <Class StringBuilder>
    //    6   12:dup             
    //    7   13:aload_2         
    //    8   14:invokestatic    #483 <Method String String.valueOf(Object)>
    //    9   17:invokespecial   #418 <Method void StringBuilder(String)>
    //   10   20:ldc2            #485 <String "  -N ">
    //   11   23:invokevirtual   #426 <Method StringBuilder StringBuilder.append(String)>
    //   12   26:aload_0         
    //   13   27:getfield        #475 <Field rm.core.Assignment m_assroles>
    //   14   30:invokevirtual   #490 <Method String rm.core.Assignment.getAssignementName()>
    //   15   33:invokevirtual   #426 <Method StringBuilder StringBuilder.append(String)>
    //   16   36:invokevirtual   #429 <Method String StringBuilder.toString()>
    //   17   39:astore_2        
        TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -R ").append(m_assroles.getAssignmentMatrix().getRowDimension()).toString();
    //   18   40:new             #415 <Class StringBuilder>
    //   19   43:dup             
    //   20   44:aload_2         
    //   21   45:invokestatic    #483 <Method String String.valueOf(Object)>
    //   22   48:invokespecial   #418 <Method void StringBuilder(String)>
    //   23   51:ldc2            #492 <String "  -R ">
    //   24   54:invokevirtual   #426 <Method StringBuilder StringBuilder.append(String)>
    //   25   57:aload_0         
    //   26   58:getfield        #475 <Field rm.core.Assignment m_assroles>
    //   27   61:invokevirtual   #496 <Method Matrix rm.core.Assignment.getAssignmentMatrix()>
    //   28   64:invokevirtual   #502 <Method int Matrix.getRowDimension()>
    //   29   67:invokevirtual   #505 <Method StringBuilder StringBuilder.append(int)>
    //   30   70:invokevirtual   #429 <Method String StringBuilder.toString()>
    //   31   73:astore_2        
        TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -P ").append(m_assroles.getAssignmentMatrix().getColumnDimension()).toString();
    //   32   74:new             #415 <Class StringBuilder>
    //   33   77:dup             
    //   34   78:aload_2         
    //   35   79:invokestatic    #483 <Method String String.valueOf(Object)>
    //   36   82:invokespecial   #418 <Method void StringBuilder(String)>
    //   37   85:ldc2            #507 <String "  -P ">
    //   38   88:invokevirtual   #426 <Method StringBuilder StringBuilder.append(String)>
    //   39   91:aload_0         
    //   40   92:getfield        #475 <Field rm.core.Assignment m_assroles>
    //   41   95:invokevirtual   #496 <Method Matrix rm.core.Assignment.getAssignmentMatrix()>
    //   42   98:invokevirtual   #510 <Method int Matrix.getColumnDimension()>
    //   43  101:invokevirtual   #505 <Method StringBuilder StringBuilder.append(int)>
    //   44  104:invokevirtual   #429 <Method String StringBuilder.toString()>
    //   45  107:astore_2        
        m_DetailTxt.setText(TxtRoles);
    //   46  108:aload_0         
    //   47  109:getfield        #118 <Field JTextField m_DetailTxt>
    //   48  112:aload_2         
    //   49  113:invokevirtual   #513 <Method void JTextField.setText(String)>
        m_RoleEditorBut.setEnabled(true);
    //   50  116:aload_0         
    //   51  117:getfield        #113 <Field JButton m_RoleEditorBut>
    //   52  120:iconst_1        
    //   53  121:invokevirtual   #249 <Method void JButton.setEnabled(boolean)>
        repaint();
    //   54  124:aload_0         
    //   55  125:invokevirtual   #516 <Method void repaint()>
    //   56  128:return          
    }

    protected void historyRightClickPopup(String name, int x, int y)
    {
        final String selectedName = name;
    //    0    0:aload_1         
    //    1    1:astore          4
        JPopupMenu resultListMenu = new JPopupMenu();
    //    2    3:new             #522 <Class JPopupMenu>
    //    3    6:dup             
    //    4    7:invokespecial   #523 <Method void JPopupMenu()>
    //    5   10:astore          5
        JMenuItem visMainBuffer = new JMenuItem("View in main window");
    //    6   12:new             #525 <Class JMenuItem>
    //    7   15:dup             
    //    8   16:ldc2            #527 <String "View in main window">
    //    9   19:invokespecial   #528 <Method void JMenuItem(String)>
    //   10   22:astore          6
        if(selectedName != null)
    //*  11   24:aload           4
    //*  12   26:ifnull          47
            visMainBuffer.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_History.setSingle(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field AssignmentPanel this$0>
                //    2    4:getfield        #32  <Field ResultHistoryPanel AssignmentPanel.m_History>
                //    3    7:aload_0         
                //    4    8:getfield        #17  <Field String val$selectedName>
                //    5   11:invokevirtual   #38  <Method void ResultHistoryPanel.setSingle(String)>
                //    6   14:return          
                }

                final AssignmentPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field AssignmentPanel this$0>
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
    //   14   31:new             #530 <Class AssignmentPanel$10>
    //   15   34:dup             
    //   16   35:aload_0         
    //   17   36:aload           4
    //   18   38:invokespecial   #533 <Method void AssignmentPanel$10(AssignmentPanel, String)>
    //   19   41:invokevirtual   #534 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  20   44:goto            53
            visMainBuffer.setEnabled(false);
    //   21   47:aload           6
    //   22   49:iconst_0        
    //   23   50:invokevirtual   #535 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(visMainBuffer);
    //   24   53:aload           5
    //   25   55:aload           6
    //   26   57:invokevirtual   #538 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   27   60:pop             
        JMenuItem visSepBuffer = new JMenuItem("View in separate window");
    //   28   61:new             #525 <Class JMenuItem>
    //   29   64:dup             
    //   30   65:ldc2            #540 <String "View in separate window">
    //   31   68:invokespecial   #528 <Method void JMenuItem(String)>
    //   32   71:astore          7
        if(selectedName != null)
    //*  33   73:aload           4
    //*  34   75:ifnull          96
            visSepBuffer.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_History.openFrame(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field AssignmentPanel this$0>
                //    2    4:getfield        #32  <Field ResultHistoryPanel AssignmentPanel.m_History>
                //    3    7:aload_0         
                //    4    8:getfield        #17  <Field String val$selectedName>
                //    5   11:invokevirtual   #38  <Method void ResultHistoryPanel.openFrame(String)>
                //    6   14:return          
                }

                final AssignmentPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field AssignmentPanel this$0>
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
    //   36   80:new             #542 <Class AssignmentPanel$11>
    //   37   83:dup             
    //   38   84:aload_0         
    //   39   85:aload           4
    //   40   87:invokespecial   #543 <Method void AssignmentPanel$11(AssignmentPanel, String)>
    //   41   90:invokevirtual   #534 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  42   93:goto            102
            visSepBuffer.setEnabled(false);
    //   43   96:aload           7
    //   44   98:iconst_0        
    //   45   99:invokevirtual   #535 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(visSepBuffer);
    //   46  102:aload           5
    //   47  104:aload           7
    //   48  106:invokevirtual   #538 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   49  109:pop             
        JMenuItem saveOutput = new JMenuItem("Save result buffer");
    //   50  110:new             #525 <Class JMenuItem>
    //   51  113:dup             
    //   52  114:ldc2            #545 <String "Save result buffer">
    //   53  117:invokespecial   #528 <Method void JMenuItem(String)>
    //   54  120:astore          8
        if(selectedName != null)
    //*  55  122:aload           4
    //*  56  124:ifnull          145
            saveOutput.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    saveBuffer(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field AssignmentPanel this$0>
                //    2    4:aload_0         
                //    3    5:getfield        #17  <Field String val$selectedName>
                //    4    8:invokevirtual   #32  <Method void AssignmentPanel.saveBuffer(String)>
                //    5   11:return          
                }

                final AssignmentPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field AssignmentPanel this$0>
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
    //   58  129:new             #547 <Class AssignmentPanel$12>
    //   59  132:dup             
    //   60  133:aload_0         
    //   61  134:aload           4
    //   62  136:invokespecial   #548 <Method void AssignmentPanel$12(AssignmentPanel, String)>
    //   63  139:invokevirtual   #534 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  64  142:goto            151
            saveOutput.setEnabled(false);
    //   65  145:aload           8
    //   66  147:iconst_0        
    //   67  148:invokevirtual   #535 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(saveOutput);
    //   68  151:aload           5
    //   69  153:aload           8
    //   70  155:invokevirtual   #538 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   71  158:pop             
        JMenuItem deleteOutput = new JMenuItem("Delete result buffer");
    //   72  159:new             #525 <Class JMenuItem>
    //   73  162:dup             
    //   74  163:ldc2            #550 <String "Delete result buffer">
    //   75  166:invokespecial   #528 <Method void JMenuItem(String)>
    //   76  169:astore          9
        if(selectedName != null)
    //*  77  171:aload           4
    //*  78  173:ifnull          194
            deleteOutput.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    m_History.removeResult(selectedName);
                //    0    0:aload_0         
                //    1    1:getfield        #15  <Field AssignmentPanel this$0>
                //    2    4:getfield        #32  <Field ResultHistoryPanel AssignmentPanel.m_History>
                //    3    7:aload_0         
                //    4    8:getfield        #17  <Field String val$selectedName>
                //    5   11:invokevirtual   #38  <Method void ResultHistoryPanel.removeResult(String)>
                //    6   14:return          
                }

                final AssignmentPanel this$0;
                private final String val$selectedName;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field AssignmentPanel this$0>
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
    //   80  178:new             #552 <Class AssignmentPanel$13>
    //   81  181:dup             
    //   82  182:aload_0         
    //   83  183:aload           4
    //   84  185:invokespecial   #553 <Method void AssignmentPanel$13(AssignmentPanel, String)>
    //   85  188:invokevirtual   #534 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //*  86  191:goto            200
            deleteOutput.setEnabled(false);
    //   87  194:aload           9
    //   88  196:iconst_0        
    //   89  197:invokevirtual   #535 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(deleteOutput);
    //   90  200:aload           5
    //   91  202:aload           9
    //   92  204:invokevirtual   #538 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   93  207:pop             
        JMenuItem saveua = new JMenuItem("Save user-role assignment as a file");
    //   94  208:new             #525 <Class JMenuItem>
    //   95  211:dup             
    //   96  212:ldc2            #555 <String "Save user-role assignment as a file">
    //   97  215:invokespecial   #528 <Method void JMenuItem(String)>
    //   98  218:astore          10
        if(selectedName != null)
    //*  99  220:aload           4
    //* 100  222:ifnull          241
            saveua.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    saveUA();
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field AssignmentPanel this$0>
                //    2    4:invokestatic    #27  <Method void AssignmentPanel.access$0(AssignmentPanel)>
                //    3    7:return          
                }

                final AssignmentPanel this$0;

            
            {
                this$0 = AssignmentPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AssignmentPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
            }
);
    //  101  225:aload           10
    //  102  227:new             #557 <Class AssignmentPanel$14>
    //  103  230:dup             
    //  104  231:aload_0         
    //  105  232:invokespecial   #558 <Method void AssignmentPanel$14(AssignmentPanel)>
    //  106  235:invokevirtual   #534 <Method void JMenuItem.addActionListener(ActionListener)>
        else
    //* 107  238:goto            247
            saveua.setEnabled(false);
    //  108  241:aload           10
    //  109  243:iconst_0        
    //  110  244:invokevirtual   #535 <Method void JMenuItem.setEnabled(boolean)>
        resultListMenu.add(saveua);
    //  111  247:aload           5
    //  112  249:aload           10
    //  113  251:invokevirtual   #538 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  114  254:pop             
        resultListMenu.show(m_History.getList(), x, y);
    //  115  255:aload           5
    //  116  257:aload_0         
    //  117  258:getfield        #92  <Field ResultHistoryPanel m_History>
    //  118  261:invokevirtual   #182 <Method JList ResultHistoryPanel.getList()>
    //  119  264:iload_2         
    //  120  265:iload_3         
    //  121  266:invokevirtual   #562 <Method void JPopupMenu.show(java.awt.Component, int, int)>
    //  122  269:return          
    }

    protected void saveBuffer(String name)
    {
        StringBuffer sb = m_History.getNamedBuffer(name);
    //    0    0:aload_0         
    //    1    1:getfield        #92  <Field ResultHistoryPanel m_History>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #579 <Method StringBuffer ResultHistoryPanel.getNamedBuffer(String)>
    //    4    8:astore_2        
        if(sb != null && m_SaveOut.save(sb))
    //*   5    9:aload_2         
    //*   6   10:ifnull          36
    //*   7   13:aload_0         
    //*   8   14:getfield        #134 <Field SaveBuffer m_SaveOut>
    //*   9   17:aload_2         
    //*  10   18:invokevirtual   #583 <Method boolean SaveBuffer.save(StringBuffer)>
    //*  11   21:ifeq            36
            m_Log.logMessage("Save successful.");
    //   12   24:aload_0         
    //   13   25:getfield        #85  <Field Logger m_Log>
    //   14   28:ldc2            #585 <String "Save successful.">
    //   15   31:invokeinterface #432 <Method void Logger.logMessage(String)>
    //   16   36:return          
    }

    private void saveUA()
    {
        m_Log.statusMessage("Saving to file...");
    //    0    0:aload_0         
    //    1    1:getfield        #85  <Field Logger m_Log>
    //    2    4:ldc2            #590 <String "Saving to file...">
    //    3    7:invokeinterface #413 <Method void Logger.statusMessage(String)>
        m_FileChooser.setDialogTitle("Save Assignment File");
    //    4   12:aload_0         
    //    5   13:getfield        #123 <Field JFileChooser m_FileChooser>
    //    6   16:ldc2            #592 <String "Save Assignment File">
    //    7   19:invokevirtual   #353 <Method void JFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //    8   22:aload_0         
    //    9   23:getfield        #123 <Field JFileChooser m_FileChooser>
    //   10   26:new             #355 <Class File>
    //   11   29:dup             
    //   12   30:ldc2            #357 <String "user.dir">
    //   13   33:invokestatic    #363 <Method String System.getProperty(String)>
    //   14   36:invokespecial   #364 <Method void File(String)>
    //   15   39:invokevirtual   #368 <Method void JFileChooser.setCurrentDirectory(File)>
        int returnVal = m_FileChooser.showSaveDialog(this);
    //   16   42:aload_0         
    //   17   43:getfield        #123 <Field JFileChooser m_FileChooser>
    //   18   46:aload_0         
    //   19   47:invokevirtual   #595 <Method int JFileChooser.showSaveDialog(java.awt.Component)>
    //   20   50:istore_1        
        if(returnVal == 0)
    //*  21   51:iload_1         
    //*  22   52:ifne            105
        {
            rm.core.Assignment newAssignment = new rm.core.Assignment(m_assua);
    //   23   55:new             #487 <Class rm.core.Assignment>
    //   24   58:dup             
    //   25   59:aload_0         
    //   26   60:getfield        #597 <Field rm.core.Assignment m_assua>
    //   27   63:invokespecial   #599 <Method void rm.core.Assignment(rm.core.Assignment)>
    //   28   66:astore_2        
            try
            {
                FileWriter fw = new FileWriter(m_FileChooser.getSelectedFile());
    //   29   67:new             #601 <Class FileWriter>
    //   30   70:dup             
    //   31   71:aload_0         
    //   32   72:getfield        #123 <Field JFileChooser m_FileChooser>
    //   33   75:invokevirtual   #389 <Method File JFileChooser.getSelectedFile()>
    //   34   78:invokespecial   #602 <Method void FileWriter(File)>
    //   35   81:astore_3        
                fw.write(newAssignment.toString());
    //   36   82:aload_3         
    //   37   83:aload_2         
    //   38   84:invokevirtual   #603 <Method String rm.core.Assignment.toString()>
    //   39   87:invokevirtual   #606 <Method void FileWriter.write(String)>
                fw.close();
    //   40   90:aload_3         
    //   41   91:invokevirtual   #609 <Method void FileWriter.close()>
            }
    //*  42   94:goto            116
            catch(Exception e)
    //*  43   97:astore_3        
            {
                e.printStackTrace();
    //   44   98:aload_3         
    //   45   99:invokevirtual   #439 <Method void Exception.printStackTrace()>
            }
        } else
    //*  46  102:goto            116
        {
            JOptionPane.showMessageDialog(this, "Can't save at this time,\ncurrently busy with other IO", "Saving assingment", 2);
    //   47  105:aload_0         
    //   48  106:ldc2            #611 <String "Can't save at this time,\ncurrently busy with other IO">
    //   49  109:ldc2            #613 <String "Saving assingment">
    //   50  112:iconst_2        
    //   51  113:invokestatic    #619 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   52  116:return          
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
    //    2    2:putfield        #61  <Field Explorer m_Explorer>
    //    3    5:return          
    }

    public Explorer getExplorer()
    {
        return m_Explorer;
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field Explorer m_Explorer>
    //    2    4:areturn         
    }

    public String getTabTitle()
    {
        return "Assignment";
    //    0    0:ldc2            #257 <String "Assignment">
    //    1    3:areturn         
    }

    public String getTabTitleToolTip()
    {
        return "Assign Roles";
    //    0    0:ldc2            #634 <String "Assign Roles">
    //    1    3:areturn         
    }

    protected Explorer m_Explorer;
    protected GenericObjectEditor m_AssignmentEditor;
    protected PropertyPanel m_CEPanel;
    protected JPanel m_LoadRoles;
    protected JTextArea m_OutText;
    protected Logger m_Log;
    protected ResultHistoryPanel m_History;
    protected JButton m_StartBut;
    protected JButton m_StopBut;
    protected JButton m_LoadBut;
    protected JButton m_RoleEditorBut;
    protected JTextField m_DetailTxt;
    protected JFileChooser m_FileChooser;
    protected int Fileflag;
    protected File SelectedFile;
    protected rm.core.Assignment AssPAData;
    protected SaveBuffer m_SaveOut;
    protected rm.core.Assignment m_assignment;
    protected rm.core.Assignment m_assroles;
    protected rm.core.Assignment m_assua;
    protected Instances m_TestInstances;
    protected Thread m_RunThread;
    static Class class$0;

    static 
    {
        GenericObjectEditor.registerEditors();
    //    0    0:invokestatic    #54  <Method void GenericObjectEditor.registerEditors()>
    //*   1    3:return          
    }


/*
    static void access$0(AssignmentPanel assignmentpanel)
    {
        assignmentpanel.saveUA();
    //    0    0:aload_0         
    //    1    1:invokespecial   #637 <Method void saveUA()>
        return;
    //    2    4:return          
    }

*/
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffPanel.java

package rm.gui.arffviewer;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.JTableHeader;
import rm.core.*;
import rm.gui.*;

// Referenced classes of package rm.gui.arffviewer:
//            ArffTable, ArffTableCellRenderer, ArffSortedTableModel

public class ArffPanel extends JPanel
    implements ActionListener, ChangeListener, MouseListener, Undoable
{

    public ArffPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #61  <Method void JPanel()>
        initialize();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #64  <Method void initialize()>
        createPanel();
    //    4    8:aload_0         
    //    5    9:invokevirtual   #67  <Method void createPanel()>
    //    6   12:return          
    }

    public ArffPanel(String filename)
    {
        this();
    //    0    0:aload_0         
    //    1    1:invokespecial   #73  <Method void ArffPanel()>
        loadFile(filename);
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokespecial   #76  <Method void loadFile(String)>
    //    5    9:return          
    }

    public ArffPanel(Instances data)
    {
        this();
    //    0    0:aload_0         
    //    1    1:invokespecial   #73  <Method void ArffPanel()>
        m_Filename = "";
    //    2    4:aload_0         
    //    3    5:ldc1            #80  <String "">
    //    4    7:putfield        #82  <Field String m_Filename>
        setInstances(data);
    //    5   10:aload_0         
    //    6   11:aload_1         
    //    7   12:invokevirtual   #85  <Method void setInstances(Instances)>
    //    8   15:return          
    }

    protected void initialize()
    {
        m_Filename = "";
    //    0    0:aload_0         
    //    1    1:ldc1            #80  <String "">
    //    2    3:putfield        #82  <Field String m_Filename>
        m_Title = "";
    //    3    6:aload_0         
    //    4    7:ldc1            #80  <String "">
    //    5    9:putfield        #89  <Field String m_Title>
        m_CurrentCol = -1;
    //    6   12:aload_0         
    //    7   13:iconst_m1       
    //    8   14:putfield        #91  <Field int m_CurrentCol>
        m_LastSearch = "";
    //    9   17:aload_0         
    //   10   18:ldc1            #80  <String "">
    //   11   20:putfield        #93  <Field String m_LastSearch>
        m_LastReplace = "";
    //   12   23:aload_0         
    //   13   24:ldc1            #80  <String "">
    //   14   26:putfield        #95  <Field String m_LastReplace>
        m_Changed = false;
    //   15   29:aload_0         
    //   16   30:iconst_0        
    //   17   31:putfield        #97  <Field boolean m_Changed>
        m_ChangeListeners = new HashSet();
    //   18   34:aload_0         
    //   19   35:new             #99  <Class HashSet>
    //   20   38:dup             
    //   21   39:invokespecial   #100 <Method void HashSet()>
    //   22   42:putfield        #102 <Field HashSet m_ChangeListeners>
    //   23   45:return          
    }

    protected void createPanel()
    {
        setLayout(new BorderLayout());
    //    0    0:aload_0         
    //    1    1:new             #104 <Class BorderLayout>
    //    2    4:dup             
    //    3    5:invokespecial   #105 <Method void BorderLayout()>
    //    4    8:invokevirtual   #109 <Method void setLayout(java.awt.LayoutManager)>
        menuItemMean = new JMenuItem("Get mean...");
    //    5   11:aload_0         
    //    6   12:new             #111 <Class JMenuItem>
    //    7   15:dup             
    //    8   16:ldc1            #113 <String "Get mean...">
    //    9   18:invokespecial   #115 <Method void JMenuItem(String)>
    //   10   21:putfield        #117 <Field JMenuItem menuItemMean>
        menuItemMean.addActionListener(this);
    //   11   24:aload_0         
    //   12   25:getfield        #117 <Field JMenuItem menuItemMean>
    //   13   28:aload_0         
    //   14   29:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemSetAllValues = new JMenuItem("Set all values to...");
    //   15   32:aload_0         
    //   16   33:new             #111 <Class JMenuItem>
    //   17   36:dup             
    //   18   37:ldc1            #123 <String "Set all values to...">
    //   19   39:invokespecial   #115 <Method void JMenuItem(String)>
    //   20   42:putfield        #125 <Field JMenuItem menuItemSetAllValues>
        menuItemSetAllValues.addActionListener(this);
    //   21   45:aload_0         
    //   22   46:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //   23   49:aload_0         
    //   24   50:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemSetMissingValues = new JMenuItem("Set missing values to...");
    //   25   53:aload_0         
    //   26   54:new             #111 <Class JMenuItem>
    //   27   57:dup             
    //   28   58:ldc1            #127 <String "Set missing values to...">
    //   29   60:invokespecial   #115 <Method void JMenuItem(String)>
    //   30   63:putfield        #129 <Field JMenuItem menuItemSetMissingValues>
        menuItemSetMissingValues.addActionListener(this);
    //   31   66:aload_0         
    //   32   67:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //   33   70:aload_0         
    //   34   71:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemReplaceValues = new JMenuItem("Replace values with...");
    //   35   74:aload_0         
    //   36   75:new             #111 <Class JMenuItem>
    //   37   78:dup             
    //   38   79:ldc1            #131 <String "Replace values with...">
    //   39   81:invokespecial   #115 <Method void JMenuItem(String)>
    //   40   84:putfield        #133 <Field JMenuItem menuItemReplaceValues>
        menuItemReplaceValues.addActionListener(this);
    //   41   87:aload_0         
    //   42   88:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //   43   91:aload_0         
    //   44   92:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemRenameAttribute = new JMenuItem("Rename attribute...");
    //   45   95:aload_0         
    //   46   96:new             #111 <Class JMenuItem>
    //   47   99:dup             
    //   48  100:ldc1            #135 <String "Rename attribute...">
    //   49  102:invokespecial   #115 <Method void JMenuItem(String)>
    //   50  105:putfield        #137 <Field JMenuItem menuItemRenameAttribute>
        menuItemRenameAttribute.addActionListener(this);
    //   51  108:aload_0         
    //   52  109:getfield        #137 <Field JMenuItem menuItemRenameAttribute>
    //   53  112:aload_0         
    //   54  113:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemAttributeAsClass = new JMenuItem("Attribute as class");
    //   55  116:aload_0         
    //   56  117:new             #111 <Class JMenuItem>
    //   57  120:dup             
    //   58  121:ldc1            #139 <String "Attribute as class">
    //   59  123:invokespecial   #115 <Method void JMenuItem(String)>
    //   60  126:putfield        #141 <Field JMenuItem menuItemAttributeAsClass>
        menuItemAttributeAsClass.addActionListener(this);
    //   61  129:aload_0         
    //   62  130:getfield        #141 <Field JMenuItem menuItemAttributeAsClass>
    //   63  133:aload_0         
    //   64  134:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemDeleteAttribute = new JMenuItem("Delete attribute");
    //   65  137:aload_0         
    //   66  138:new             #111 <Class JMenuItem>
    //   67  141:dup             
    //   68  142:ldc1            #143 <String "Delete attribute">
    //   69  144:invokespecial   #115 <Method void JMenuItem(String)>
    //   70  147:putfield        #145 <Field JMenuItem menuItemDeleteAttribute>
        menuItemDeleteAttribute.addActionListener(this);
    //   71  150:aload_0         
    //   72  151:getfield        #145 <Field JMenuItem menuItemDeleteAttribute>
    //   73  154:aload_0         
    //   74  155:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemDeleteAttributes = new JMenuItem("Delete attributes...");
    //   75  158:aload_0         
    //   76  159:new             #111 <Class JMenuItem>
    //   77  162:dup             
    //   78  163:ldc1            #147 <String "Delete attributes...">
    //   79  165:invokespecial   #115 <Method void JMenuItem(String)>
    //   80  168:putfield        #149 <Field JMenuItem menuItemDeleteAttributes>
        menuItemDeleteAttributes.addActionListener(this);
    //   81  171:aload_0         
    //   82  172:getfield        #149 <Field JMenuItem menuItemDeleteAttributes>
    //   83  175:aload_0         
    //   84  176:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemSortInstances = new JMenuItem("Sort data (ascending)");
    //   85  179:aload_0         
    //   86  180:new             #111 <Class JMenuItem>
    //   87  183:dup             
    //   88  184:ldc1            #151 <String "Sort data (ascending)">
    //   89  186:invokespecial   #115 <Method void JMenuItem(String)>
    //   90  189:putfield        #153 <Field JMenuItem menuItemSortInstances>
        menuItemSortInstances.addActionListener(this);
    //   91  192:aload_0         
    //   92  193:getfield        #153 <Field JMenuItem menuItemSortInstances>
    //   93  196:aload_0         
    //   94  197:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemOptimalColWidth = new JMenuItem("Optimal column width (current)");
    //   95  200:aload_0         
    //   96  201:new             #111 <Class JMenuItem>
    //   97  204:dup             
    //   98  205:ldc1            #155 <String "Optimal column width (current)">
    //   99  207:invokespecial   #115 <Method void JMenuItem(String)>
    //  100  210:putfield        #157 <Field JMenuItem menuItemOptimalColWidth>
        menuItemOptimalColWidth.addActionListener(this);
    //  101  213:aload_0         
    //  102  214:getfield        #157 <Field JMenuItem menuItemOptimalColWidth>
    //  103  217:aload_0         
    //  104  218:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemOptimalColWidths = new JMenuItem("Optimal column width (all)");
    //  105  221:aload_0         
    //  106  222:new             #111 <Class JMenuItem>
    //  107  225:dup             
    //  108  226:ldc1            #159 <String "Optimal column width (all)">
    //  109  228:invokespecial   #115 <Method void JMenuItem(String)>
    //  110  231:putfield        #161 <Field JMenuItem menuItemOptimalColWidths>
        menuItemOptimalColWidths.addActionListener(this);
    //  111  234:aload_0         
    //  112  235:getfield        #161 <Field JMenuItem menuItemOptimalColWidths>
    //  113  238:aload_0         
    //  114  239:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemUndo = new JMenuItem("Undo");
    //  115  242:aload_0         
    //  116  243:new             #111 <Class JMenuItem>
    //  117  246:dup             
    //  118  247:ldc1            #163 <String "Undo">
    //  119  249:invokespecial   #115 <Method void JMenuItem(String)>
    //  120  252:putfield        #165 <Field JMenuItem menuItemUndo>
        menuItemUndo.addActionListener(this);
    //  121  255:aload_0         
    //  122  256:getfield        #165 <Field JMenuItem menuItemUndo>
    //  123  259:aload_0         
    //  124  260:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemCopy = new JMenuItem("Copy");
    //  125  263:aload_0         
    //  126  264:new             #111 <Class JMenuItem>
    //  127  267:dup             
    //  128  268:ldc1            #167 <String "Copy">
    //  129  270:invokespecial   #115 <Method void JMenuItem(String)>
    //  130  273:putfield        #169 <Field JMenuItem menuItemCopy>
        menuItemCopy.addActionListener(this);
    //  131  276:aload_0         
    //  132  277:getfield        #169 <Field JMenuItem menuItemCopy>
    //  133  280:aload_0         
    //  134  281:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemSearch = new JMenuItem("Search...");
    //  135  284:aload_0         
    //  136  285:new             #111 <Class JMenuItem>
    //  137  288:dup             
    //  138  289:ldc1            #171 <String "Search...">
    //  139  291:invokespecial   #115 <Method void JMenuItem(String)>
    //  140  294:putfield        #173 <Field JMenuItem menuItemSearch>
        menuItemSearch.addActionListener(this);
    //  141  297:aload_0         
    //  142  298:getfield        #173 <Field JMenuItem menuItemSearch>
    //  143  301:aload_0         
    //  144  302:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemClearSearch = new JMenuItem("Clear search");
    //  145  305:aload_0         
    //  146  306:new             #111 <Class JMenuItem>
    //  147  309:dup             
    //  148  310:ldc1            #175 <String "Clear search">
    //  149  312:invokespecial   #115 <Method void JMenuItem(String)>
    //  150  315:putfield        #177 <Field JMenuItem menuItemClearSearch>
        menuItemClearSearch.addActionListener(this);
    //  151  318:aload_0         
    //  152  319:getfield        #177 <Field JMenuItem menuItemClearSearch>
    //  153  322:aload_0         
    //  154  323:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemDeleteSelectedInstance = new JMenuItem("Delete selected instance");
    //  155  326:aload_0         
    //  156  327:new             #111 <Class JMenuItem>
    //  157  330:dup             
    //  158  331:ldc1            #179 <String "Delete selected instance">
    //  159  333:invokespecial   #115 <Method void JMenuItem(String)>
    //  160  336:putfield        #181 <Field JMenuItem menuItemDeleteSelectedInstance>
        menuItemDeleteSelectedInstance.addActionListener(this);
    //  161  339:aload_0         
    //  162  340:getfield        #181 <Field JMenuItem menuItemDeleteSelectedInstance>
    //  163  343:aload_0         
    //  164  344:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        menuItemDeleteAllSelectedInstances = new JMenuItem("Delete ALL selected instances");
    //  165  347:aload_0         
    //  166  348:new             #111 <Class JMenuItem>
    //  167  351:dup             
    //  168  352:ldc1            #183 <String "Delete ALL selected instances">
    //  169  354:invokespecial   #115 <Method void JMenuItem(String)>
    //  170  357:putfield        #185 <Field JMenuItem menuItemDeleteAllSelectedInstances>
        menuItemDeleteAllSelectedInstances.addActionListener(this);
    //  171  360:aload_0         
    //  172  361:getfield        #185 <Field JMenuItem menuItemDeleteAllSelectedInstances>
    //  173  364:aload_0         
    //  174  365:invokevirtual   #121 <Method void JMenuItem.addActionListener(ActionListener)>
        m_TableArff = new ArffTable();
    //  175  368:aload_0         
    //  176  369:new             #187 <Class ArffTable>
    //  177  372:dup             
    //  178  373:invokespecial   #188 <Method void ArffTable()>
    //  179  376:putfield        #190 <Field ArffTable m_TableArff>
        m_TableArff.setToolTipText("Right click (or left+alt) for context menu");
    //  180  379:aload_0         
    //  181  380:getfield        #190 <Field ArffTable m_TableArff>
    //  182  383:ldc1            #192 <String "Right click (or left+alt) for context menu">
    //  183  385:invokevirtual   #195 <Method void ArffTable.setToolTipText(String)>
        m_TableArff.getTableHeader().addMouseListener(this);
    //  184  388:aload_0         
    //  185  389:getfield        #190 <Field ArffTable m_TableArff>
    //  186  392:invokevirtual   #199 <Method JTableHeader ArffTable.getTableHeader()>
    //  187  395:aload_0         
    //  188  396:invokevirtual   #205 <Method void JTableHeader.addMouseListener(MouseListener)>
        m_TableArff.getTableHeader().setToolTipText("<html><b>Sort view:</b> left click = ascending / Shift + left click = descending<br><b>Menu:</b> right click (or left+alt)</html>");
    //  189  399:aload_0         
    //  190  400:getfield        #190 <Field ArffTable m_TableArff>
    //  191  403:invokevirtual   #199 <Method JTableHeader ArffTable.getTableHeader()>
    //  192  406:ldc1            #207 <String "<html><b>Sort view:</b> left click = ascending / Shift + left click = descending<br><b>Menu:</b> right click (or left+alt)</html>">
    //  193  408:invokevirtual   #208 <Method void JTableHeader.setToolTipText(String)>
        m_TableArff.getTableHeader().setDefaultRenderer(new ArffTableCellRenderer());
    //  194  411:aload_0         
    //  195  412:getfield        #190 <Field ArffTable m_TableArff>
    //  196  415:invokevirtual   #199 <Method JTableHeader ArffTable.getTableHeader()>
    //  197  418:new             #210 <Class ArffTableCellRenderer>
    //  198  421:dup             
    //  199  422:invokespecial   #211 <Method void ArffTableCellRenderer()>
    //  200  425:invokevirtual   #215 <Method void JTableHeader.setDefaultRenderer(javax.swing.table.TableCellRenderer)>
        m_TableArff.addChangeListener(this);
    //  201  428:aload_0         
    //  202  429:getfield        #190 <Field ArffTable m_TableArff>
    //  203  432:aload_0         
    //  204  433:invokevirtual   #219 <Method void ArffTable.addChangeListener(ChangeListener)>
        m_TableArff.addMouseListener(this);
    //  205  436:aload_0         
    //  206  437:getfield        #190 <Field ArffTable m_TableArff>
    //  207  440:aload_0         
    //  208  441:invokevirtual   #220 <Method void ArffTable.addMouseListener(MouseListener)>
        JScrollPane pane = new JScrollPane(m_TableArff);
    //  209  444:new             #222 <Class JScrollPane>
    //  210  447:dup             
    //  211  448:aload_0         
    //  212  449:getfield        #190 <Field ArffTable m_TableArff>
    //  213  452:invokespecial   #225 <Method void JScrollPane(java.awt.Component)>
    //  214  455:astore_1        
        add(pane, "Center");
    //  215  456:aload_0         
    //  216  457:aload_1         
    //  217  458:ldc1            #227 <String "Center">
    //  218  460:invokevirtual   #231 <Method void add(java.awt.Component, Object)>
        m_LabelName = new JLabel();
    //  219  463:aload_0         
    //  220  464:new             #233 <Class JLabel>
    //  221  467:dup             
    //  222  468:invokespecial   #234 <Method void JLabel()>
    //  223  471:putfield        #236 <Field JLabel m_LabelName>
        add(m_LabelName, "North");
    //  224  474:aload_0         
    //  225  475:aload_0         
    //  226  476:getfield        #236 <Field JLabel m_LabelName>
    //  227  479:ldc1            #238 <String "North">
    //  228  481:invokevirtual   #231 <Method void add(java.awt.Component, Object)>
    //  229  484:return          
    }

    private void initPopupMenus()
    {
        m_PopupHeader = new JPopupMenu();
    //    0    0:aload_0         
    //    1    1:new             #243 <Class JPopupMenu>
    //    2    4:dup             
    //    3    5:invokespecial   #244 <Method void JPopupMenu()>
    //    4    8:putfield        #246 <Field JPopupMenu m_PopupHeader>
        m_PopupHeader.addMouseListener(this);
    //    5   11:aload_0         
    //    6   12:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //    7   15:aload_0         
    //    8   16:invokevirtual   #247 <Method void JPopupMenu.addMouseListener(MouseListener)>
        m_PopupHeader.add(menuItemMean);
    //    9   19:aload_0         
    //   10   20:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   11   23:aload_0         
    //   12   24:getfield        #117 <Field JMenuItem menuItemMean>
    //   13   27:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   14   30:pop             
        if(!isReadOnly())
    //*  15   31:aload_0         
    //*  16   32:invokevirtual   #254 <Method boolean isReadOnly()>
    //*  17   35:ifne            148
        {
            m_PopupHeader.addSeparator();
    //   18   38:aload_0         
    //   19   39:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   20   42:invokevirtual   #257 <Method void JPopupMenu.addSeparator()>
            m_PopupHeader.add(menuItemSetAllValues);
    //   21   45:aload_0         
    //   22   46:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   23   49:aload_0         
    //   24   50:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //   25   53:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   26   56:pop             
            m_PopupHeader.add(menuItemSetMissingValues);
    //   27   57:aload_0         
    //   28   58:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   29   61:aload_0         
    //   30   62:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //   31   65:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   32   68:pop             
            m_PopupHeader.add(menuItemReplaceValues);
    //   33   69:aload_0         
    //   34   70:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   35   73:aload_0         
    //   36   74:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //   37   77:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   38   80:pop             
            m_PopupHeader.addSeparator();
    //   39   81:aload_0         
    //   40   82:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   41   85:invokevirtual   #257 <Method void JPopupMenu.addSeparator()>
            m_PopupHeader.add(menuItemRenameAttribute);
    //   42   88:aload_0         
    //   43   89:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   44   92:aload_0         
    //   45   93:getfield        #137 <Field JMenuItem menuItemRenameAttribute>
    //   46   96:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   47   99:pop             
            m_PopupHeader.add(menuItemAttributeAsClass);
    //   48  100:aload_0         
    //   49  101:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   50  104:aload_0         
    //   51  105:getfield        #141 <Field JMenuItem menuItemAttributeAsClass>
    //   52  108:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   53  111:pop             
            m_PopupHeader.add(menuItemDeleteAttribute);
    //   54  112:aload_0         
    //   55  113:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   56  116:aload_0         
    //   57  117:getfield        #145 <Field JMenuItem menuItemDeleteAttribute>
    //   58  120:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   59  123:pop             
            m_PopupHeader.add(menuItemDeleteAttributes);
    //   60  124:aload_0         
    //   61  125:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   62  128:aload_0         
    //   63  129:getfield        #149 <Field JMenuItem menuItemDeleteAttributes>
    //   64  132:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   65  135:pop             
            m_PopupHeader.add(menuItemSortInstances);
    //   66  136:aload_0         
    //   67  137:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   68  140:aload_0         
    //   69  141:getfield        #153 <Field JMenuItem menuItemSortInstances>
    //   70  144:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   71  147:pop             
        }
        m_PopupHeader.addSeparator();
    //   72  148:aload_0         
    //   73  149:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   74  152:invokevirtual   #257 <Method void JPopupMenu.addSeparator()>
        m_PopupHeader.add(menuItemOptimalColWidth);
    //   75  155:aload_0         
    //   76  156:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   77  159:aload_0         
    //   78  160:getfield        #157 <Field JMenuItem menuItemOptimalColWidth>
    //   79  163:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   80  166:pop             
        m_PopupHeader.add(menuItemOptimalColWidths);
    //   81  167:aload_0         
    //   82  168:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   83  171:aload_0         
    //   84  172:getfield        #161 <Field JMenuItem menuItemOptimalColWidths>
    //   85  175:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //   86  178:pop             
        m_PopupRows = new JPopupMenu();
    //   87  179:aload_0         
    //   88  180:new             #243 <Class JPopupMenu>
    //   89  183:dup             
    //   90  184:invokespecial   #244 <Method void JPopupMenu()>
    //   91  187:putfield        #259 <Field JPopupMenu m_PopupRows>
        m_PopupRows.addMouseListener(this);
    //   92  190:aload_0         
    //   93  191:getfield        #259 <Field JPopupMenu m_PopupRows>
    //   94  194:aload_0         
    //   95  195:invokevirtual   #247 <Method void JPopupMenu.addMouseListener(MouseListener)>
        if(!isReadOnly())
    //*  96  198:aload_0         
    //*  97  199:invokevirtual   #254 <Method boolean isReadOnly()>
    //*  98  202:ifne            224
        {
            m_PopupRows.add(menuItemUndo);
    //   99  205:aload_0         
    //  100  206:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  101  209:aload_0         
    //  102  210:getfield        #165 <Field JMenuItem menuItemUndo>
    //  103  213:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  104  216:pop             
            m_PopupRows.addSeparator();
    //  105  217:aload_0         
    //  106  218:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  107  221:invokevirtual   #257 <Method void JPopupMenu.addSeparator()>
        }
        m_PopupRows.add(menuItemCopy);
    //  108  224:aload_0         
    //  109  225:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  110  228:aload_0         
    //  111  229:getfield        #169 <Field JMenuItem menuItemCopy>
    //  112  232:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  113  235:pop             
        m_PopupRows.addSeparator();
    //  114  236:aload_0         
    //  115  237:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  116  240:invokevirtual   #257 <Method void JPopupMenu.addSeparator()>
        m_PopupRows.add(menuItemSearch);
    //  117  243:aload_0         
    //  118  244:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  119  247:aload_0         
    //  120  248:getfield        #173 <Field JMenuItem menuItemSearch>
    //  121  251:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  122  254:pop             
        m_PopupRows.add(menuItemClearSearch);
    //  123  255:aload_0         
    //  124  256:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  125  259:aload_0         
    //  126  260:getfield        #177 <Field JMenuItem menuItemClearSearch>
    //  127  263:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  128  266:pop             
        if(!isReadOnly())
    //* 129  267:aload_0         
    //* 130  268:invokevirtual   #254 <Method boolean isReadOnly()>
    //* 131  271:ifne            305
        {
            m_PopupRows.addSeparator();
    //  132  274:aload_0         
    //  133  275:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  134  278:invokevirtual   #257 <Method void JPopupMenu.addSeparator()>
            m_PopupRows.add(menuItemDeleteSelectedInstance);
    //  135  281:aload_0         
    //  136  282:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  137  285:aload_0         
    //  138  286:getfield        #181 <Field JMenuItem menuItemDeleteSelectedInstance>
    //  139  289:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  140  292:pop             
            m_PopupRows.add(menuItemDeleteAllSelectedInstances);
    //  141  293:aload_0         
    //  142  294:getfield        #259 <Field JPopupMenu m_PopupRows>
    //  143  297:aload_0         
    //  144  298:getfield        #185 <Field JMenuItem menuItemDeleteAllSelectedInstances>
    //  145  301:invokevirtual   #250 <Method JMenuItem JPopupMenu.add(JMenuItem)>
    //  146  304:pop             
        }
    //  147  305:return          
    }

    private void setMenu()
    {
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:astore          5
        boolean isNull = model.getInstances() == null;
    //    5   12:aload           5
    //    6   14:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //    7   17:ifnonnull       24
    //    8   20:iconst_1        
    //    9   21:goto            25
    //   10   24:iconst_0        
    //   11   25:istore          6
        boolean hasColumns = !isNull && model.getInstances().numAttributes() > 0;
    //   12   27:iload           6
    //   13   29:ifne            47
    //   14   32:aload           5
    //   15   34:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //   16   37:invokevirtual   #276 <Method int Instances.numAttributes()>
    //   17   40:ifle            47
    //   18   43:iconst_1        
    //   19   44:goto            48
    //   20   47:iconst_0        
    //   21   48:istore_2        
        boolean hasRows = !isNull && model.getInstances().numInstances() > 0;
    //   22   49:iload           6
    //   23   51:ifne            69
    //   24   54:aload           5
    //   25   56:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //   26   59:invokevirtual   #279 <Method int Instances.numInstances()>
    //   27   62:ifle            69
    //   28   65:iconst_1        
    //   29   66:goto            70
    //   30   69:iconst_0        
    //   31   70:istore_3        
        boolean attSelected = hasColumns && m_CurrentCol > 0;
    //   32   71:iload_2         
    //   33   72:ifeq            86
    //   34   75:aload_0         
    //   35   76:getfield        #91  <Field int m_CurrentCol>
    //   36   79:ifle            86
    //   37   82:iconst_1        
    //   38   83:goto            87
    //   39   86:iconst_0        
    //   40   87:istore          4
        boolean isNumeric = attSelected && model.getAttributeAt(m_CurrentCol).isNumeric();
    //   41   89:iload           4
    //   42   91:ifeq            113
    //   43   94:aload           5
    //   44   96:aload_0         
    //   45   97:getfield        #91  <Field int m_CurrentCol>
    //   46  100:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //   47  103:invokevirtual   #288 <Method boolean Attribute.isNumeric()>
    //   48  106:ifeq            113
    //   49  109:iconst_1        
    //   50  110:goto            114
    //   51  113:iconst_0        
    //   52  114:istore_1        
        menuItemUndo.setEnabled(canUndo());
    //   53  115:aload_0         
    //   54  116:getfield        #165 <Field JMenuItem menuItemUndo>
    //   55  119:aload_0         
    //   56  120:invokevirtual   #291 <Method boolean canUndo()>
    //   57  123:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemCopy.setEnabled(true);
    //   58  126:aload_0         
    //   59  127:getfield        #169 <Field JMenuItem menuItemCopy>
    //   60  130:iconst_1        
    //   61  131:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemSearch.setEnabled(true);
    //   62  134:aload_0         
    //   63  135:getfield        #173 <Field JMenuItem menuItemSearch>
    //   64  138:iconst_1        
    //   65  139:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemClearSearch.setEnabled(true);
    //   66  142:aload_0         
    //   67  143:getfield        #177 <Field JMenuItem menuItemClearSearch>
    //   68  146:iconst_1        
    //   69  147:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemMean.setEnabled(isNumeric);
    //   70  150:aload_0         
    //   71  151:getfield        #117 <Field JMenuItem menuItemMean>
    //   72  154:iload_1         
    //   73  155:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemSetAllValues.setEnabled(attSelected);
    //   74  158:aload_0         
    //   75  159:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //   76  162:iload           4
    //   77  164:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemSetMissingValues.setEnabled(attSelected);
    //   78  167:aload_0         
    //   79  168:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //   80  171:iload           4
    //   81  173:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemReplaceValues.setEnabled(attSelected);
    //   82  176:aload_0         
    //   83  177:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //   84  180:iload           4
    //   85  182:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemRenameAttribute.setEnabled(attSelected);
    //   86  185:aload_0         
    //   87  186:getfield        #137 <Field JMenuItem menuItemRenameAttribute>
    //   88  189:iload           4
    //   89  191:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemDeleteAttribute.setEnabled(attSelected);
    //   90  194:aload_0         
    //   91  195:getfield        #145 <Field JMenuItem menuItemDeleteAttribute>
    //   92  198:iload           4
    //   93  200:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemDeleteAttributes.setEnabled(attSelected);
    //   94  203:aload_0         
    //   95  204:getfield        #149 <Field JMenuItem menuItemDeleteAttributes>
    //   96  207:iload           4
    //   97  209:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemSortInstances.setEnabled(hasRows && attSelected);
    //   98  212:aload_0         
    //   99  213:getfield        #153 <Field JMenuItem menuItemSortInstances>
    //  100  216:iload_3         
    //  101  217:ifeq            229
    //  102  220:iload           4
    //  103  222:ifeq            229
    //  104  225:iconst_1        
    //  105  226:goto            230
    //  106  229:iconst_0        
    //  107  230:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemDeleteSelectedInstance.setEnabled(hasRows && m_TableArff.getSelectedRow() > -1);
    //  108  233:aload_0         
    //  109  234:getfield        #181 <Field JMenuItem menuItemDeleteSelectedInstance>
    //  110  237:iload_3         
    //  111  238:ifeq            256
    //  112  241:aload_0         
    //  113  242:getfield        #190 <Field ArffTable m_TableArff>
    //  114  245:invokevirtual   #298 <Method int ArffTable.getSelectedRow()>
    //  115  248:iconst_m1       
    //  116  249:icmple          256
    //  117  252:iconst_1        
    //  118  253:goto            257
    //  119  256:iconst_0        
    //  120  257:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
        menuItemDeleteAllSelectedInstances.setEnabled(hasRows && m_TableArff.getSelectedRows().length > 0);
    //  121  260:aload_0         
    //  122  261:getfield        #185 <Field JMenuItem menuItemDeleteAllSelectedInstances>
    //  123  264:iload_3         
    //  124  265:ifeq            283
    //  125  268:aload_0         
    //  126  269:getfield        #190 <Field ArffTable m_TableArff>
    //  127  272:invokevirtual   #302 <Method int[] ArffTable.getSelectedRows()>
    //  128  275:arraylength     
    //  129  276:ifle            283
    //  130  279:iconst_1        
    //  131  280:goto            284
    //  132  283:iconst_0        
    //  133  284:invokevirtual   #295 <Method void JMenuItem.setEnabled(boolean)>
    //  134  287:return          
    }

    public ArffTable getTable()
    {
        return m_TableArff;
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:areturn         
    }

    public String getTitle()
    {
        return m_Title;
    //    0    0:aload_0         
    //    1    1:getfield        #89  <Field String m_Title>
    //    2    4:areturn         
    }

    public String getFilename()
    {
        return m_Filename;
    //    0    0:aload_0         
    //    1    1:getfield        #82  <Field String m_Filename>
    //    2    4:areturn         
    }

    public void setFilename(String filename)
    {
        m_Filename = filename;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #82  <Field String m_Filename>
        createTitle();
    //    3    5:aload_0         
    //    4    6:invokespecial   #317 <Method void createTitle()>
    //    5    9:return          
    }

    public Instances getInstances()
    {
        Instances result = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        if(m_TableArff.getModel() != null)
    //*   2    2:aload_0         
    //*   3    3:getfield        #190 <Field ArffTable m_TableArff>
    //*   4    6:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //*   5    9:ifnull          26
            result = ((ArffSortedTableModel)m_TableArff.getModel()).getInstances();
    //    6   12:aload_0         
    //    7   13:getfield        #190 <Field ArffTable m_TableArff>
    //    8   16:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    9   19:checkcast       #266 <Class ArffSortedTableModel>
    //   10   22:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //   11   25:astore_1        
        return result;
    //   12   26:aload_1         
    //   13   27:areturn         
    }

    public void setInstances(Instances data)
    {
        m_Filename = "Instances";
    //    0    0:aload_0         
    //    1    1:ldc1            #21  <String "Instances">
    //    2    3:putfield        #82  <Field String m_Filename>
        createTitle();
    //    3    6:aload_0         
    //    4    7:invokespecial   #317 <Method void createTitle()>
        ArffSortedTableModel model = new ArffSortedTableModel(data);
    //    5   10:new             #266 <Class ArffSortedTableModel>
    //    6   13:dup             
    //    7   14:aload_1         
    //    8   15:invokespecial   #320 <Method void ArffSortedTableModel(Instances)>
    //    9   18:astore_2        
        m_TableArff.setModel(model);
    //   10   19:aload_0         
    //   11   20:getfield        #190 <Field ArffTable m_TableArff>
    //   12   23:aload_2         
    //   13   24:invokevirtual   #324 <Method void ArffTable.setModel(javax.swing.table.TableModel)>
        clearUndo();
    //   14   27:aload_0         
    //   15   28:invokevirtual   #327 <Method void clearUndo()>
        setChanged(false);
    //   16   31:aload_0         
    //   17   32:iconst_0        
    //   18   33:invokevirtual   #330 <Method void setChanged(boolean)>
        createName();
    //   19   36:aload_0         
    //   20   37:invokespecial   #333 <Method void createName()>
    //   21   40:return          
    }

    public Vector getAttributes()
    {
        Vector result = new Vector();
    //    0    0:new             #337 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #338 <Method void Vector()>
    //    3    7:astore_1        
        for(int i = 0; i < getInstances().numAttributes(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            32
            result.add(getInstances().attribute(i).name());
    //    7   13:aload_1         
    //    8   14:aload_0         
    //    9   15:invokevirtual   #339 <Method Instances getInstances()>
    //   10   18:iload_2         
    //   11   19:invokevirtual   #342 <Method Attribute Instances.attribute(int)>
    //   12   22:invokevirtual   #345 <Method String Attribute.name()>
    //   13   25:invokevirtual   #348 <Method boolean Vector.add(Object)>
    //   14   28:pop             

    //   15   29:iinc            2  1
    //   16   32:iload_2         
    //   17   33:aload_0         
    //   18   34:invokevirtual   #339 <Method Instances getInstances()>
    //   19   37:invokevirtual   #276 <Method int Instances.numAttributes()>
    //   20   40:icmplt          13
        Collections.sort(result);
    //   21   43:aload_1         
    //   22   44:invokestatic    #354 <Method void Collections.sort(java.util.List)>
        return result;
    //   23   47:aload_1         
    //   24   48:areturn         
    }

    public void setChanged(boolean changed)
    {
        if(!changed)
    //*   0    0:iload_1         
    //*   1    1:ifne            13
        {
            m_Changed = changed;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #97  <Field boolean m_Changed>
            createTitle();
    //    5    9:aload_0         
    //    6   10:invokespecial   #317 <Method void createTitle()>
        }
    //    7   13:return          
    }

    public boolean isChanged()
    {
        return m_Changed;
    //    0    0:aload_0         
    //    1    1:getfield        #97  <Field boolean m_Changed>
    //    2    4:ireturn         
    }

    public boolean isReadOnly()
    {
        if(m_TableArff == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #190 <Field ArffTable m_TableArff>
    //*   2    4:ifnonnull       9
            return true;
    //    3    7:iconst_1        
    //    4    8:ireturn         
        else
            return ((ArffSortedTableModel)m_TableArff.getModel()).isReadOnly();
    //    5    9:aload_0         
    //    6   10:getfield        #190 <Field ArffTable m_TableArff>
    //    7   13:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    8   16:checkcast       #266 <Class ArffSortedTableModel>
    //    9   19:invokevirtual   #359 <Method boolean ArffSortedTableModel.isReadOnly()>
    //   10   22:ireturn         
    }

    public void setReadOnly(boolean value)
    {
        if(m_TableArff != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #190 <Field ArffTable m_TableArff>
    //*   2    4:ifnull          21
            ((ArffSortedTableModel)m_TableArff.getModel()).setReadOnly(value);
    //    3    7:aload_0         
    //    4    8:getfield        #190 <Field ArffTable m_TableArff>
    //    5   11:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    6   14:checkcast       #266 <Class ArffSortedTableModel>
    //    7   17:iload_1         
    //    8   18:invokevirtual   #362 <Method void ArffSortedTableModel.setReadOnly(boolean)>
    //    9   21:return          
    }

    public boolean isUndoEnabled()
    {
        return ((ArffSortedTableModel)m_TableArff.getModel()).isUndoEnabled();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:invokevirtual   #366 <Method boolean ArffSortedTableModel.isUndoEnabled()>
    //    5   13:ireturn         
    }

    public void setUndoEnabled(boolean enabled)
    {
        ((ArffSortedTableModel)m_TableArff.getModel()).setUndoEnabled(enabled);
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:iload_1         
    //    5   11:invokevirtual   #369 <Method void ArffSortedTableModel.setUndoEnabled(boolean)>
    //    6   14:return          
    }

    public void clearUndo()
    {
        ((ArffSortedTableModel)m_TableArff.getModel()).clearUndo();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:invokevirtual   #371 <Method void ArffSortedTableModel.clearUndo()>
    //    5   13:return          
    }

    public boolean canUndo()
    {
        return ((ArffSortedTableModel)m_TableArff.getModel()).canUndo();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:invokevirtual   #372 <Method boolean ArffSortedTableModel.canUndo()>
    //    5   13:ireturn         
    }

    public void undo()
    {
        if(canUndo())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #291 <Method boolean canUndo()>
    //*   2    4:ifeq            24
        {
            ((ArffSortedTableModel)m_TableArff.getModel()).undo();
    //    3    7:aload_0         
    //    4    8:getfield        #190 <Field ArffTable m_TableArff>
    //    5   11:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    6   14:checkcast       #266 <Class ArffSortedTableModel>
    //    7   17:invokevirtual   #375 <Method void ArffSortedTableModel.undo()>
            notifyListener();
    //    8   20:aload_0         
    //    9   21:invokevirtual   #378 <Method void notifyListener()>
        }
    //   10   24:return          
    }

    public void addUndoPoint()
    {
        ((ArffSortedTableModel)m_TableArff.getModel()).addUndoPoint();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:invokevirtual   #381 <Method void ArffSortedTableModel.addUndoPoint()>
        setMenu();
    //    5   13:aload_0         
    //    6   14:invokespecial   #383 <Method void setMenu()>
    //    7   17:return          
    }

    private void createTitle()
    {
        if(m_Filename.equals(""))
    //*   0    0:aload_0         
    //*   1    1:getfield        #82  <Field String m_Filename>
    //*   2    4:ldc1            #80  <String "">
    //*   3    6:invokevirtual   #388 <Method boolean String.equals(Object)>
    //*   4    9:ifeq            22
            m_Title = "-none-";
    //    5   12:aload_0         
    //    6   13:ldc2            #390 <String "-none-">
    //    7   16:putfield        #89  <Field String m_Title>
        else
    //*   8   19:goto            74
        if(m_Filename.equals("Instances"))
    //*   9   22:aload_0         
    //*  10   23:getfield        #82  <Field String m_Filename>
    //*  11   26:ldc1            #21  <String "Instances">
    //*  12   28:invokevirtual   #388 <Method boolean String.equals(Object)>
    //*  13   31:ifeq            43
            m_Title = "Instances";
    //   14   34:aload_0         
    //   15   35:ldc1            #21  <String "Instances">
    //   16   37:putfield        #89  <Field String m_Title>
        else
    //*  17   40:goto            74
            try
            {
                File file = new File(m_Filename);
    //   18   43:new             #392 <Class File>
    //   19   46:dup             
    //   20   47:aload_0         
    //   21   48:getfield        #82  <Field String m_Filename>
    //   22   51:invokespecial   #393 <Method void File(String)>
    //   23   54:astore_1        
                m_Title = file.getName();
    //   24   55:aload_0         
    //   25   56:aload_1         
    //   26   57:invokevirtual   #396 <Method String File.getName()>
    //   27   60:putfield        #89  <Field String m_Title>
            }
    //*  28   63:goto            74
            catch(Exception e)
    //*  29   66:astore_2        
            {
                m_Title = "-none-";
    //   30   67:aload_0         
    //   31   68:ldc2            #390 <String "-none-">
    //   32   71:putfield        #89  <Field String m_Title>
            }
        if(!isChanged()) goto _L2; else goto _L1
    //   33   74:aload_0         
    //   34   75:invokevirtual   #398 <Method boolean isChanged()>
    //   35   78:ifeq            109
_L1:
        this;
    //   36   81:aload_0         
        m_Title;
    //   37   82:dup             
    //   38   83:getfield        #89  <Field String m_Title>
        JVM INSTR new #400 <Class StringBuilder>;
    //   39   86:new             #400 <Class StringBuilder>
        JVM INSTR dup_x1 ;
    //   40   89:dup_x1          
        JVM INSTR swap ;
    //   41   90:swap            
        String.valueOf();
    //   42   91:invokestatic    #404 <Method String String.valueOf(Object)>
        StringBuilder();
    //   43   94:invokespecial   #405 <Method void StringBuilder(String)>
        " *";
    //   44   97:ldc2            #407 <String " *">
        append();
    //   45  100:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
        toString();
    //   46  103:invokevirtual   #414 <Method String StringBuilder.toString()>
        m_Title;
    //   47  106:putfield        #89  <Field String m_Title>
_L2:
    //   48  109:return          
    }

    private void createName()
    {
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    3    7:checkcast       #266 <Class ArffSortedTableModel>
    //    4   10:astore_1        
        if(model != null && model.getInstances() != null)
    //*   5   11:aload_1         
    //*   6   12:ifnull          55
    //*   7   15:aload_1         
    //*   8   16:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //*   9   19:ifnull          55
            m_LabelName.setText((new StringBuilder("Attributeof: ")).append(model.getInstances().relationName()).toString());
    //   10   22:aload_0         
    //   11   23:getfield        #236 <Field JLabel m_LabelName>
    //   12   26:new             #400 <Class StringBuilder>
    //   13   29:dup             
    //   14   30:ldc2            #422 <String "Attributeof: ">
    //   15   33:invokespecial   #405 <Method void StringBuilder(String)>
    //   16   36:aload_1         
    //   17   37:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //   18   40:invokevirtual   #425 <Method String Instances.relationName()>
    //   19   43:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //   20   46:invokevirtual   #414 <Method String StringBuilder.toString()>
    //   21   49:invokevirtual   #428 <Method void JLabel.setText(String)>
        else
    //*  22   52:goto            64
            m_LabelName.setText("");
    //   23   55:aload_0         
    //   24   56:getfield        #236 <Field JLabel m_LabelName>
    //   25   59:ldc1            #80  <String "">
    //   26   61:invokevirtual   #428 <Method void JLabel.setText(String)>
    //   27   64:return          
    }

    private void loadFile(String filename)
    {
        m_Filename = filename;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #82  <Field String m_Filename>
        createTitle();
    //    3    5:aload_0         
    //    4    6:invokespecial   #317 <Method void createTitle()>
        ArffSortedTableModel model;
        if(filename.equals(""))
    //*   5    9:aload_1         
    //*   6   10:ldc1            #80  <String "">
    //*   7   12:invokevirtual   #388 <Method boolean String.equals(Object)>
    //*   8   15:ifeq            23
            model = null;
    //    9   18:aconst_null     
    //   10   19:astore_2        
        else
    //*  11   20:goto            32
            model = new ArffSortedTableModel(filename);
    //   12   23:new             #266 <Class ArffSortedTableModel>
    //   13   26:dup             
    //   14   27:aload_1         
    //   15   28:invokespecial   #429 <Method void ArffSortedTableModel(String)>
    //   16   31:astore_2        
        m_TableArff.setModel(model);
    //   17   32:aload_0         
    //   18   33:getfield        #190 <Field ArffTable m_TableArff>
    //   19   36:aload_2         
    //   20   37:invokevirtual   #324 <Method void ArffTable.setModel(javax.swing.table.TableModel)>
        setChanged(false);
    //   21   40:aload_0         
    //   22   41:iconst_0        
    //   23   42:invokevirtual   #330 <Method void setChanged(boolean)>
        createName();
    //   24   45:aload_0         
    //   25   46:invokespecial   #333 <Method void createName()>
    //   26   49:return          
    }

    private void calcMean()
    {
        if(m_CurrentCol == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #91  <Field int m_CurrentCol>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          9
            return;
    //    4    8:return          
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //    5    9:aload_0         
    //    6   10:getfield        #190 <Field ArffTable m_TableArff>
    //    7   13:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    8   16:checkcast       #266 <Class ArffSortedTableModel>
    //    9   19:astore_1        
        if(!model.getAttributeAt(m_CurrentCol).isNumeric())
    //*  10   20:aload_1         
    //*  11   21:aload_0         
    //*  12   22:getfield        #91  <Field int m_CurrentCol>
    //*  13   25:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //*  14   28:invokevirtual   #288 <Method boolean Attribute.isNumeric()>
    //*  15   31:ifne            35
            return;
    //   16   34:return          
        double mean = 0.0D;
    //   17   35:dconst_0        
    //   18   36:dstore_3        
        for(int i = 0; i < model.getRowCount(); i++)
    //*  19   37:iconst_0        
    //*  20   38:istore_2        
    //*  21   39:goto            65
            mean += model.getInstances().instance(i).value(m_CurrentCol - 1);
    //   22   42:dload_3         
    //   23   43:aload_1         
    //   24   44:invokevirtual   #270 <Method Instances ArffSortedTableModel.getInstances()>
    //   25   47:iload_2         
    //   26   48:invokevirtual   #434 <Method Instance Instances.instance(int)>
    //   27   51:aload_0         
    //   28   52:getfield        #91  <Field int m_CurrentCol>
    //   29   55:iconst_1        
    //   30   56:isub            
    //   31   57:invokevirtual   #439 <Method double Instance.value(int)>
    //   32   60:dadd            
    //   33   61:dstore_3        

    //   34   62:iinc            2  1
    //   35   65:iload_2         
    //   36   66:aload_1         
    //   37   67:invokevirtual   #442 <Method int ArffSortedTableModel.getRowCount()>
    //   38   70:icmplt          42
        mean /= model.getRowCount();
    //   39   73:dload_3         
    //   40   74:aload_1         
    //   41   75:invokevirtual   #442 <Method int ArffSortedTableModel.getRowCount()>
    //   42   78:i2d             
    //   43   79:ddiv            
    //   44   80:dstore_3        
        ComponentHelper.showMessageBox(getParent(), "Mean for attribute...", (new StringBuilder("Mean for attribute '")).append(m_TableArff.getPlainColumnName(m_CurrentCol)).append("':\n\t").append(Utils.doubleToString(mean, 3)).toString(), 2, -1);
    //   45   81:aload_0         
    //   46   82:invokevirtual   #446 <Method java.awt.Container getParent()>
    //   47   85:ldc2            #448 <String "Mean for attribute...">
    //   48   88:new             #400 <Class StringBuilder>
    //   49   91:dup             
    //   50   92:ldc2            #450 <String "Mean for attribute '">
    //   51   95:invokespecial   #405 <Method void StringBuilder(String)>
    //   52   98:aload_0         
    //   53   99:getfield        #190 <Field ArffTable m_TableArff>
    //   54  102:aload_0         
    //   55  103:getfield        #91  <Field int m_CurrentCol>
    //   56  106:invokevirtual   #454 <Method String ArffTable.getPlainColumnName(int)>
    //   57  109:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //   58  112:ldc2            #456 <String "':\n\t">
    //   59  115:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //   60  118:dload_3         
    //   61  119:iconst_3        
    //   62  120:invokestatic    #462 <Method String Utils.doubleToString(double, int)>
    //   63  123:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //   64  126:invokevirtual   #414 <Method String StringBuilder.toString()>
    //   65  129:iconst_2        
    //   66  130:iconst_m1       
    //   67  131:invokestatic    #468 <Method int ComponentHelper.showMessageBox(java.awt.Component, String, String, int, int)>
    //   68  134:pop             
    //   69  135:return          
    }

    private void setValues(Object o)
    {
        String value = "";
    //    0    0:ldc1            #80  <String "">
    //    1    2:astore          4
        String valueNew = "";
    //    2    4:ldc1            #80  <String "">
    //    3    6:astore          5
        String msg;
        String title;
        if(o == menuItemSetMissingValues)
    //*   4    8:aload_1         
    //*   5    9:aload_0         
    //*   6   10:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //*   7   13:if_acmpne       27
        {
            title = "Replace missing values...";
    //    8   16:ldc2            #474 <String "Replace missing values...">
    //    9   19:astore_3        
            msg = "New value for MISSING values";
    //   10   20:ldc2            #476 <String "New value for MISSING values">
    //   11   23:astore_2        
        } else
    //*  12   24:goto            66
        if(o == menuItemSetAllValues)
    //*  13   27:aload_1         
    //*  14   28:aload_0         
    //*  15   29:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //*  16   32:if_acmpne       46
        {
            title = "Set all values...";
    //   17   35:ldc2            #478 <String "Set all values...">
    //   18   38:astore_3        
            msg = "New value for ALL values";
    //   19   39:ldc2            #480 <String "New value for ALL values">
    //   20   42:astore_2        
        } else
    //*  21   43:goto            66
        if(o == menuItemReplaceValues)
    //*  22   46:aload_1         
    //*  23   47:aload_0         
    //*  24   48:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //*  25   51:if_acmpne       65
        {
            title = "Replace values...";
    //   26   54:ldc2            #482 <String "Replace values...">
    //   27   57:astore_3        
            msg = "Old value";
    //   28   58:ldc2            #484 <String "Old value">
    //   29   61:astore_2        
        } else
    //*  30   62:goto            66
        {
            return;
    //   31   65:return          
        }
        value = ComponentHelper.showInputBox(m_TableArff.getParent(), title, msg, m_LastSearch);
    //   32   66:aload_0         
    //   33   67:getfield        #190 <Field ArffTable m_TableArff>
    //   34   70:invokevirtual   #485 <Method java.awt.Container ArffTable.getParent()>
    //   35   73:aload_3         
    //   36   74:aload_2         
    //   37   75:aload_0         
    //   38   76:getfield        #93  <Field String m_LastSearch>
    //   39   79:invokestatic    #489 <Method String ComponentHelper.showInputBox(java.awt.Component, String, String, Object)>
    //   40   82:astore          4
        if(value == null)
    //*  41   84:aload           4
    //*  42   86:ifnonnull       90
            return;
    //   43   89:return          
        m_LastSearch = value;
    //   44   90:aload_0         
    //   45   91:aload           4
    //   46   93:putfield        #93  <Field String m_LastSearch>
        if(o == menuItemReplaceValues)
    //*  47   96:aload_1         
    //*  48   97:aload_0         
    //*  49   98:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //*  50  101:if_acmpne       136
        {
            valueNew = ComponentHelper.showInputBox(m_TableArff.getParent(), title, "New value", m_LastReplace);
    //   51  104:aload_0         
    //   52  105:getfield        #190 <Field ArffTable m_TableArff>
    //   53  108:invokevirtual   #485 <Method java.awt.Container ArffTable.getParent()>
    //   54  111:aload_3         
    //   55  112:ldc2            #491 <String "New value">
    //   56  115:aload_0         
    //   57  116:getfield        #95  <Field String m_LastReplace>
    //   58  119:invokestatic    #489 <Method String ComponentHelper.showInputBox(java.awt.Component, String, String, Object)>
    //   59  122:astore          5
            if(valueNew == null)
    //*  60  124:aload           5
    //*  61  126:ifnonnull       130
                return;
    //   62  129:return          
            m_LastReplace = valueNew;
    //   63  130:aload_0         
    //   64  131:aload           5
    //   65  133:putfield        #95  <Field String m_LastReplace>
        }
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //   66  136:aload_0         
    //   67  137:getfield        #190 <Field ArffTable m_TableArff>
    //   68  140:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //   69  143:checkcast       #266 <Class ArffSortedTableModel>
    //   70  146:astore          7
        model.setNotificationEnabled(false);
    //   71  148:aload           7
    //   72  150:iconst_0        
    //   73  151:invokevirtual   #494 <Method void ArffSortedTableModel.setNotificationEnabled(boolean)>
        addUndoPoint();
    //   74  154:aload_0         
    //   75  155:invokevirtual   #495 <Method void addUndoPoint()>
        model.setUndoEnabled(false);
    //   76  158:aload           7
    //   77  160:iconst_0        
    //   78  161:invokevirtual   #369 <Method void ArffSortedTableModel.setUndoEnabled(boolean)>
        String valueCopy = value;
    //   79  164:aload           4
    //   80  166:astore          8
        for(int i = 0; i < m_TableArff.getRowCount(); i++)
    //*  81  168:iconst_0        
    //*  82  169:istore          6
    //*  83  171:goto            307
            if(o == menuItemSetAllValues)
    //*  84  174:aload_1         
    //*  85  175:aload_0         
    //*  86  176:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //*  87  179:if_acmpne       223
            {
                if(valueCopy.equals("NaN") || valueCopy.equals("?"))
    //*  88  182:aload           8
    //*  89  184:ldc2            #497 <String "NaN">
    //*  90  187:invokevirtual   #388 <Method boolean String.equals(Object)>
    //*  91  190:ifne            204
    //*  92  193:aload           8
    //*  93  195:ldc2            #499 <String "?">
    //*  94  198:invokevirtual   #388 <Method boolean String.equals(Object)>
    //*  95  201:ifeq            207
                    value = null;
    //   96  204:aconst_null     
    //   97  205:astore          4
                model.setValueAt(value, i, m_CurrentCol);
    //   98  207:aload           7
    //   99  209:aload           4
    //  100  211:iload           6
    //  101  213:aload_0         
    //  102  214:getfield        #91  <Field int m_CurrentCol>
    //  103  217:invokevirtual   #503 <Method void ArffSortedTableModel.setValueAt(Object, int, int)>
            } else
    //* 104  220:goto            304
            if(o == menuItemSetMissingValues && model.isMissingAt(i, m_CurrentCol))
    //* 105  223:aload_1         
    //* 106  224:aload_0         
    //* 107  225:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //* 108  228:if_acmpne       261
    //* 109  231:aload           7
    //* 110  233:iload           6
    //* 111  235:aload_0         
    //* 112  236:getfield        #91  <Field int m_CurrentCol>
    //* 113  239:invokevirtual   #507 <Method boolean ArffSortedTableModel.isMissingAt(int, int)>
    //* 114  242:ifeq            261
                model.setValueAt(value, i, m_CurrentCol);
    //  115  245:aload           7
    //  116  247:aload           4
    //  117  249:iload           6
    //  118  251:aload_0         
    //  119  252:getfield        #91  <Field int m_CurrentCol>
    //  120  255:invokevirtual   #503 <Method void ArffSortedTableModel.setValueAt(Object, int, int)>
            else
    //* 121  258:goto            304
            if(o == menuItemReplaceValues && model.getValueAt(i, m_CurrentCol).toString().equals(value))
    //* 122  261:aload_1         
    //* 123  262:aload_0         
    //* 124  263:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //* 125  266:if_acmpne       304
    //* 126  269:aload           7
    //* 127  271:iload           6
    //* 128  273:aload_0         
    //* 129  274:getfield        #91  <Field int m_CurrentCol>
    //* 130  277:invokevirtual   #511 <Method Object ArffSortedTableModel.getValueAt(int, int)>
    //* 131  280:invokevirtual   #514 <Method String Object.toString()>
    //* 132  283:aload           4
    //* 133  285:invokevirtual   #388 <Method boolean String.equals(Object)>
    //* 134  288:ifeq            304
                model.setValueAt(valueNew, i, m_CurrentCol);
    //  135  291:aload           7
    //  136  293:aload           5
    //  137  295:iload           6
    //  138  297:aload_0         
    //  139  298:getfield        #91  <Field int m_CurrentCol>
    //  140  301:invokevirtual   #503 <Method void ArffSortedTableModel.setValueAt(Object, int, int)>

    //  141  304:iinc            6  1
    //  142  307:iload           6
    //  143  309:aload_0         
    //  144  310:getfield        #190 <Field ArffTable m_TableArff>
    //  145  313:invokevirtual   #515 <Method int ArffTable.getRowCount()>
    //  146  316:icmplt          174
        model.setUndoEnabled(true);
    //  147  319:aload           7
    //  148  321:iconst_1        
    //  149  322:invokevirtual   #369 <Method void ArffSortedTableModel.setUndoEnabled(boolean)>
        model.setNotificationEnabled(true);
    //  150  325:aload           7
    //  151  327:iconst_1        
    //  152  328:invokevirtual   #494 <Method void ArffSortedTableModel.setNotificationEnabled(boolean)>
        model.notifyListener(new TableModelEvent(model, 0, model.getRowCount(), m_CurrentCol, 0));
    //  153  331:aload           7
    //  154  333:new             #517 <Class TableModelEvent>
    //  155  336:dup             
    //  156  337:aload           7
    //  157  339:iconst_0        
    //  158  340:aload           7
    //  159  342:invokevirtual   #442 <Method int ArffSortedTableModel.getRowCount()>
    //  160  345:aload_0         
    //  161  346:getfield        #91  <Field int m_CurrentCol>
    //  162  349:iconst_0        
    //  163  350:invokespecial   #520 <Method void TableModelEvent(javax.swing.table.TableModel, int, int, int, int)>
    //  164  353:invokevirtual   #523 <Method void ArffSortedTableModel.notifyListener(TableModelEvent)>
        m_TableArff.repaint();
    //  165  356:aload_0         
    //  166  357:getfield        #190 <Field ArffTable m_TableArff>
    //  167  360:invokevirtual   #526 <Method void ArffTable.repaint()>
    //  168  363:return          
    }

    public void deleteAttribute()
    {
        if(m_CurrentCol == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #91  <Field int m_CurrentCol>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          9
            return;
    //    4    8:return          
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //    5    9:aload_0         
    //    6   10:getfield        #190 <Field ArffTable m_TableArff>
    //    7   13:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    8   16:checkcast       #266 <Class ArffSortedTableModel>
    //    9   19:astore_1        
        if(model.getAttributeAt(m_CurrentCol) == null)
    //*  10   20:aload_1         
    //*  11   21:aload_0         
    //*  12   22:getfield        #91  <Field int m_CurrentCol>
    //*  13   25:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //*  14   28:ifnonnull       32
            return;
    //   15   31:return          
        if(ComponentHelper.showMessageBox(getParent(), "Confirm...", (new StringBuilder("Do you really want to delete the attribute '")).append(model.getAttributeAt(m_CurrentCol).name()).append("'?").toString(), 0, 3) != 0)
    //*  16   32:aload_0         
    //*  17   33:invokevirtual   #446 <Method java.awt.Container getParent()>
    //*  18   36:ldc2            #535 <String "Confirm...">
    //*  19   39:new             #400 <Class StringBuilder>
    //*  20   42:dup             
    //*  21   43:ldc2            #537 <String "Do you really want to delete the attribute '">
    //*  22   46:invokespecial   #405 <Method void StringBuilder(String)>
    //*  23   49:aload_1         
    //*  24   50:aload_0         
    //*  25   51:getfield        #91  <Field int m_CurrentCol>
    //*  26   54:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //*  27   57:invokevirtual   #345 <Method String Attribute.name()>
    //*  28   60:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //*  29   63:ldc2            #539 <String "'?">
    //*  30   66:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //*  31   69:invokevirtual   #414 <Method String StringBuilder.toString()>
    //*  32   72:iconst_0        
    //*  33   73:iconst_3        
    //*  34   74:invokestatic    #468 <Method int ComponentHelper.showMessageBox(java.awt.Component, String, String, int, int)>
    //*  35   77:ifeq            81
        {
            return;
    //   36   80:return          
        } else
        {
            setCursor(Cursor.getPredefinedCursor(3));
    //   37   81:aload_0         
    //   38   82:iconst_3        
    //   39   83:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   40   86:invokevirtual   #549 <Method void setCursor(Cursor)>
            model.deleteAttributeAt(m_CurrentCol);
    //   41   89:aload_1         
    //   42   90:aload_0         
    //   43   91:getfield        #91  <Field int m_CurrentCol>
    //   44   94:invokevirtual   #553 <Method void ArffSortedTableModel.deleteAttributeAt(int)>
            setCursor(Cursor.getPredefinedCursor(0));
    //   45   97:aload_0         
    //   46   98:iconst_0        
    //   47   99:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   48  102:invokevirtual   #549 <Method void setCursor(Cursor)>
            return;
    //   49  105:return          
        }
    }

    public void deleteAttributes()
    {
        JList list = new JList(getAttributes());
    //    0    0:new             #556 <Class JList>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokevirtual   #558 <Method Vector getAttributes()>
    //    4    8:invokespecial   #561 <Method void JList(Vector)>
    //    5   11:astore          6
        ListSelectorDialog dialog = new ListSelectorDialog(null, list);
    //    6   13:new             #563 <Class ListSelectorDialog>
    //    7   16:dup             
    //    8   17:aconst_null     
    //    9   18:aload           6
    //   10   20:invokespecial   #566 <Method void ListSelectorDialog(java.awt.Frame, JList)>
    //   11   23:astore_1        
        int result = dialog.showDialog();
    //   12   24:aload_1         
    //   13   25:invokevirtual   #569 <Method int ListSelectorDialog.showDialog()>
    //   14   28:istore          7
        if(result != 0)
    //*  15   30:iload           7
    //*  16   32:ifeq            36
            return;
    //   17   35:return          
        Object atts[] = list.getSelectedValues();
    //   18   36:aload           6
    //   19   38:invokevirtual   #573 <Method Object[] JList.getSelectedValues()>
    //   20   41:astore_3        
        if(ComponentHelper.showMessageBox(getParent(), "Confirm...", (new StringBuilder("Do you really want to delete these ")).append(atts.length).append(" attributes?").toString(), 0, 3) != 0)
    //*  21   42:aload_0         
    //*  22   43:invokevirtual   #446 <Method java.awt.Container getParent()>
    //*  23   46:ldc2            #535 <String "Confirm...">
    //*  24   49:new             #400 <Class StringBuilder>
    //*  25   52:dup             
    //*  26   53:ldc2            #575 <String "Do you really want to delete these ">
    //*  27   56:invokespecial   #405 <Method void StringBuilder(String)>
    //*  28   59:aload_3         
    //*  29   60:arraylength     
    //*  30   61:invokevirtual   #578 <Method StringBuilder StringBuilder.append(int)>
    //*  31   64:ldc2            #580 <String " attributes?">
    //*  32   67:invokevirtual   #411 <Method StringBuilder StringBuilder.append(String)>
    //*  33   70:invokevirtual   #414 <Method String StringBuilder.toString()>
    //*  34   73:iconst_0        
    //*  35   74:iconst_3        
    //*  36   75:invokestatic    #468 <Method int ComponentHelper.showMessageBox(java.awt.Component, String, String, int, int)>
    //*  37   78:ifeq            82
            return;
    //   38   81:return          
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //   39   82:aload_0         
    //   40   83:getfield        #190 <Field ArffTable m_TableArff>
    //   41   86:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //   42   89:checkcast       #266 <Class ArffSortedTableModel>
    //   43   92:astore_2        
        int indices[] = new int[atts.length];
    //   44   93:aload_3         
    //   45   94:arraylength     
    //   46   95:newarray        int[]
    //   47   97:astore          4
        for(int i = 0; i < atts.length; i++)
    //*  48   99:iconst_0        
    //*  49  100:istore          5
    //*  50  102:goto            124
            indices[i] = model.getAttributeColumn(atts[i].toString());
    //   51  105:aload           4
    //   52  107:iload           5
    //   53  109:aload_2         
    //   54  110:aload_3         
    //   55  111:iload           5
    //   56  113:aaload          
    //   57  114:invokevirtual   #514 <Method String Object.toString()>
    //   58  117:invokevirtual   #584 <Method int ArffSortedTableModel.getAttributeColumn(String)>
    //   59  120:iastore         

    //   60  121:iinc            5  1
    //   61  124:iload           5
    //   62  126:aload_3         
    //   63  127:arraylength     
    //   64  128:icmplt          105
        setCursor(Cursor.getPredefinedCursor(3));
    //   65  131:aload_0         
    //   66  132:iconst_3        
    //   67  133:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   68  136:invokevirtual   #549 <Method void setCursor(Cursor)>
        model.deleteAttributes(indices);
    //   69  139:aload_2         
    //   70  140:aload           4
    //   71  142:invokevirtual   #587 <Method void ArffSortedTableModel.deleteAttributes(int[])>
        setCursor(Cursor.getPredefinedCursor(0));
    //   72  145:aload_0         
    //   73  146:iconst_0        
    //   74  147:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   75  150:invokevirtual   #549 <Method void setCursor(Cursor)>
    //   76  153:return          
    }

    public void attributeAsClass()
    {
        if(m_CurrentCol == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #91  <Field int m_CurrentCol>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          9
            return;
    //    4    8:return          
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //    5    9:aload_0         
    //    6   10:getfield        #190 <Field ArffTable m_TableArff>
    //    7   13:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    8   16:checkcast       #266 <Class ArffSortedTableModel>
    //    9   19:astore_1        
        if(model.getAttributeAt(m_CurrentCol) == null)
    //*  10   20:aload_1         
    //*  11   21:aload_0         
    //*  12   22:getfield        #91  <Field int m_CurrentCol>
    //*  13   25:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //*  14   28:ifnonnull       32
        {
            return;
    //   15   31:return          
        } else
        {
            setCursor(Cursor.getPredefinedCursor(3));
    //   16   32:aload_0         
    //   17   33:iconst_3        
    //   18   34:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   19   37:invokevirtual   #549 <Method void setCursor(Cursor)>
            model.attributeAsClassAt(m_CurrentCol);
    //   20   40:aload_1         
    //   21   41:aload_0         
    //   22   42:getfield        #91  <Field int m_CurrentCol>
    //   23   45:invokevirtual   #599 <Method void ArffSortedTableModel.attributeAsClassAt(int)>
            setCursor(Cursor.getPredefinedCursor(0));
    //   24   48:aload_0         
    //   25   49:iconst_0        
    //   26   50:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   27   53:invokevirtual   #549 <Method void setCursor(Cursor)>
            return;
    //   28   56:return          
        }
    }

    public void renameAttribute()
    {
        if(m_CurrentCol == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #91  <Field int m_CurrentCol>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          9
            return;
    //    4    8:return          
        ArffSortedTableModel model = (ArffSortedTableModel)m_TableArff.getModel();
    //    5    9:aload_0         
    //    6   10:getfield        #190 <Field ArffTable m_TableArff>
    //    7   13:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    8   16:checkcast       #266 <Class ArffSortedTableModel>
    //    9   19:astore_1        
        if(model.getAttributeAt(m_CurrentCol) == null)
    //*  10   20:aload_1         
    //*  11   21:aload_0         
    //*  12   22:getfield        #91  <Field int m_CurrentCol>
    //*  13   25:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //*  14   28:ifnonnull       32
            return;
    //   15   31:return          
        String newName = ComponentHelper.showInputBox(getParent(), "Rename attribute...", "Enter new Attribute name", model.getAttributeAt(m_CurrentCol).name());
    //   16   32:aload_0         
    //   17   33:invokevirtual   #446 <Method java.awt.Container getParent()>
    //   18   36:ldc1            #135 <String "Rename attribute...">
    //   19   38:ldc2            #602 <String "Enter new Attribute name">
    //   20   41:aload_1         
    //   21   42:aload_0         
    //   22   43:getfield        #91  <Field int m_CurrentCol>
    //   23   46:invokevirtual   #283 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //   24   49:invokevirtual   #345 <Method String Attribute.name()>
    //   25   52:invokestatic    #489 <Method String ComponentHelper.showInputBox(java.awt.Component, String, String, Object)>
    //   26   55:astore_2        
        if(newName == null)
    //*  27   56:aload_2         
    //*  28   57:ifnonnull       61
        {
            return;
    //   29   60:return          
        } else
        {
            setCursor(Cursor.getPredefinedCursor(3));
    //   30   61:aload_0         
    //   31   62:iconst_3        
    //   32   63:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   33   66:invokevirtual   #549 <Method void setCursor(Cursor)>
            model.renameAttributeAt(m_CurrentCol, newName);
    //   34   69:aload_1         
    //   35   70:aload_0         
    //   36   71:getfield        #91  <Field int m_CurrentCol>
    //   37   74:aload_2         
    //   38   75:invokevirtual   #606 <Method void ArffSortedTableModel.renameAttributeAt(int, String)>
            setCursor(Cursor.getPredefinedCursor(0));
    //   39   78:aload_0         
    //   40   79:iconst_0        
    //   41   80:invokestatic    #545 <Method Cursor Cursor.getPredefinedCursor(int)>
    //   42   83:invokevirtual   #549 <Method void setCursor(Cursor)>
            return;
    //   43   86:return          
        }
    }

    public void deleteInstance()
    {
        int index = m_TableArff.getSelectedRow();
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:invokevirtual   #298 <Method int ArffTable.getSelectedRow()>
    //    3    7:istore_1        
        if(index == -1)
    //*   4    8:iload_1         
    //*   5    9:iconst_m1       
    //*   6   10:icmpne          14
        {
            return;
    //    7   13:return          
        } else
        {
            ((ArffSortedTableModel)m_TableArff.getModel()).deleteInstanceAt(index);
    //    8   14:aload_0         
    //    9   15:getfield        #190 <Field ArffTable m_TableArff>
    //   10   18:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //   11   21:checkcast       #266 <Class ArffSortedTableModel>
    //   12   24:iload_1         
    //   13   25:invokevirtual   #611 <Method void ArffSortedTableModel.deleteInstanceAt(int)>
            return;
    //   14   28:return          
        }
    }

    public void deleteInstances()
    {
        if(m_TableArff.getSelectedRow() == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #190 <Field ArffTable m_TableArff>
    //*   2    4:invokevirtual   #298 <Method int ArffTable.getSelectedRow()>
    //*   3    7:iconst_m1       
    //*   4    8:icmpne          12
        {
            return;
    //    5   11:return          
        } else
        {
            int indices[] = m_TableArff.getSelectedRows();
    //    6   12:aload_0         
    //    7   13:getfield        #190 <Field ArffTable m_TableArff>
    //    8   16:invokevirtual   #302 <Method int[] ArffTable.getSelectedRows()>
    //    9   19:astore_1        
            ((ArffSortedTableModel)m_TableArff.getModel()).deleteInstances(indices);
    //   10   20:aload_0         
    //   11   21:getfield        #190 <Field ArffTable m_TableArff>
    //   12   24:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //   13   27:checkcast       #266 <Class ArffSortedTableModel>
    //   14   30:aload_1         
    //   15   31:invokevirtual   #615 <Method void ArffSortedTableModel.deleteInstances(int[])>
            return;
    //   16   34:return          
        }
    }

    public void sortInstances()
    {
        if(m_CurrentCol == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #91  <Field int m_CurrentCol>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          9
        {
            return;
    //    4    8:return          
        } else
        {
            ((ArffSortedTableModel)m_TableArff.getModel()).sortInstances(m_CurrentCol);
    //    5    9:aload_0         
    //    6   10:getfield        #190 <Field ArffTable m_TableArff>
    //    7   13:invokevirtual   #264 <Method javax.swing.table.TableModel ArffTable.getModel()>
    //    8   16:checkcast       #266 <Class ArffSortedTableModel>
    //    9   19:aload_0         
    //   10   20:getfield        #91  <Field int m_CurrentCol>
    //   11   23:invokevirtual   #618 <Method void ArffSortedTableModel.sortInstances(int)>
            return;
    //   12   26:return          
        }
    }

    public void copyContent()
    {
        java.awt.datatransfer.StringSelection selection = getTable().getStringSelection();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #621 <Method ArffTable getTable()>
    //    2    4:invokevirtual   #625 <Method java.awt.datatransfer.StringSelection ArffTable.getStringSelection()>
    //    3    7:astore_1        
        if(selection == null)
    //*   4    8:aload_1         
    //*   5    9:ifnonnull       13
        {
            return;
    //    6   12:return          
        } else
        {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    //    7   13:invokestatic    #631 <Method Toolkit Toolkit.getDefaultToolkit()>
    //    8   16:invokevirtual   #635 <Method Clipboard Toolkit.getSystemClipboard()>
    //    9   19:astore_2        
            clipboard.setContents(selection, selection);
    //   10   20:aload_2         
    //   11   21:aload_1         
    //   12   22:aload_1         
    //   13   23:invokevirtual   #641 <Method void Clipboard.setContents(java.awt.datatransfer.Transferable, java.awt.datatransfer.ClipboardOwner)>
            return;
    //   14   26:return          
        }
    }

    public void search()
    {
        String searchString = ComponentHelper.showInputBox(getParent(), "Search...", "Enter the string to search for", m_LastSearch);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #446 <Method java.awt.Container getParent()>
    //    2    4:ldc1            #171 <String "Search...">
    //    3    6:ldc2            #648 <String "Enter the string to search for">
    //    4    9:aload_0         
    //    5   10:getfield        #93  <Field String m_LastSearch>
    //    6   13:invokestatic    #489 <Method String ComponentHelper.showInputBox(java.awt.Component, String, String, Object)>
    //    7   16:astore_1        
        if(searchString != null)
    //*   8   17:aload_1         
    //*   9   18:ifnull          26
            m_LastSearch = searchString;
    //   10   21:aload_0         
    //   11   22:aload_1         
    //   12   23:putfield        #93  <Field String m_LastSearch>
        getTable().setSearchString(searchString);
    //   13   26:aload_0         
    //   14   27:invokevirtual   #621 <Method ArffTable getTable()>
    //   15   30:aload_1         
    //   16   31:invokevirtual   #651 <Method void ArffTable.setSearchString(String)>
    //   17   34:return          
    }

    public void clearSearch()
    {
        getTable().setSearchString("");
    //    0    0:aload_0         
    //    1    1:invokevirtual   #621 <Method ArffTable getTable()>
    //    2    4:ldc1            #80  <String "">
    //    3    6:invokevirtual   #651 <Method void ArffTable.setSearchString(String)>
    //    4    9:return          
    }

    public void setOptimalColWidth()
    {
        if(m_CurrentCol == -1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #91  <Field int m_CurrentCol>
    //*   2    4:iconst_m1       
    //*   3    5:icmpne          9
        {
            return;
    //    4    8:return          
        } else
        {
            JTableHelper.setOptimalColumnWidth(getTable(), m_CurrentCol);
    //    5    9:aload_0         
    //    6   10:invokevirtual   #621 <Method ArffTable getTable()>
    //    7   13:aload_0         
    //    8   14:getfield        #91  <Field int m_CurrentCol>
    //    9   17:invokestatic    #660 <Method void JTableHelper.setOptimalColumnWidth(javax.swing.JTable, int)>
            return;
    //   10   20:return          
        }
    }

    public void setOptimalColWidths()
    {
        JTableHelper.setOptimalColumnWidth(getTable());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #621 <Method ArffTable getTable()>
    //    2    4:invokestatic    #664 <Method void JTableHelper.setOptimalColumnWidth(javax.swing.JTable)>
    //    3    7:return          
    }

    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #672 <Method Object ActionEvent.getSource()>
    //    2    4:astore_2        
        if(o == menuItemMean)
    //*   3    5:aload_2         
    //*   4    6:aload_0         
    //*   5    7:getfield        #117 <Field JMenuItem menuItemMean>
    //*   6   10:if_acmpne       20
            calcMean();
    //    7   13:aload_0         
    //    8   14:invokespecial   #674 <Method void calcMean()>
        else
    //*   9   17:goto            269
        if(o == menuItemSetAllValues)
    //*  10   20:aload_2         
    //*  11   21:aload_0         
    //*  12   22:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //*  13   25:if_acmpne       39
            setValues(menuItemSetAllValues);
    //   14   28:aload_0         
    //   15   29:aload_0         
    //   16   30:getfield        #125 <Field JMenuItem menuItemSetAllValues>
    //   17   33:invokespecial   #676 <Method void setValues(Object)>
        else
    //*  18   36:goto            269
        if(o == menuItemSetMissingValues)
    //*  19   39:aload_2         
    //*  20   40:aload_0         
    //*  21   41:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //*  22   44:if_acmpne       58
            setValues(menuItemSetMissingValues);
    //   23   47:aload_0         
    //   24   48:aload_0         
    //   25   49:getfield        #129 <Field JMenuItem menuItemSetMissingValues>
    //   26   52:invokespecial   #676 <Method void setValues(Object)>
        else
    //*  27   55:goto            269
        if(o == menuItemReplaceValues)
    //*  28   58:aload_2         
    //*  29   59:aload_0         
    //*  30   60:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //*  31   63:if_acmpne       77
            setValues(menuItemReplaceValues);
    //   32   66:aload_0         
    //   33   67:aload_0         
    //   34   68:getfield        #133 <Field JMenuItem menuItemReplaceValues>
    //   35   71:invokespecial   #676 <Method void setValues(Object)>
        else
    //*  36   74:goto            269
        if(o == menuItemRenameAttribute)
    //*  37   77:aload_2         
    //*  38   78:aload_0         
    //*  39   79:getfield        #137 <Field JMenuItem menuItemRenameAttribute>
    //*  40   82:if_acmpne       92
            renameAttribute();
    //   41   85:aload_0         
    //   42   86:invokevirtual   #678 <Method void renameAttribute()>
        else
    //*  43   89:goto            269
        if(o == menuItemAttributeAsClass)
    //*  44   92:aload_2         
    //*  45   93:aload_0         
    //*  46   94:getfield        #141 <Field JMenuItem menuItemAttributeAsClass>
    //*  47   97:if_acmpne       107
            attributeAsClass();
    //   48  100:aload_0         
    //   49  101:invokevirtual   #680 <Method void attributeAsClass()>
        else
    //*  50  104:goto            269
        if(o == menuItemDeleteAttribute)
    //*  51  107:aload_2         
    //*  52  108:aload_0         
    //*  53  109:getfield        #145 <Field JMenuItem menuItemDeleteAttribute>
    //*  54  112:if_acmpne       122
            deleteAttribute();
    //   55  115:aload_0         
    //   56  116:invokevirtual   #682 <Method void deleteAttribute()>
        else
    //*  57  119:goto            269
        if(o == menuItemDeleteAttributes)
    //*  58  122:aload_2         
    //*  59  123:aload_0         
    //*  60  124:getfield        #149 <Field JMenuItem menuItemDeleteAttributes>
    //*  61  127:if_acmpne       137
            deleteAttributes();
    //   62  130:aload_0         
    //   63  131:invokevirtual   #684 <Method void deleteAttributes()>
        else
    //*  64  134:goto            269
        if(o == menuItemDeleteSelectedInstance)
    //*  65  137:aload_2         
    //*  66  138:aload_0         
    //*  67  139:getfield        #181 <Field JMenuItem menuItemDeleteSelectedInstance>
    //*  68  142:if_acmpne       152
            deleteInstance();
    //   69  145:aload_0         
    //   70  146:invokevirtual   #686 <Method void deleteInstance()>
        else
    //*  71  149:goto            269
        if(o == menuItemDeleteAllSelectedInstances)
    //*  72  152:aload_2         
    //*  73  153:aload_0         
    //*  74  154:getfield        #185 <Field JMenuItem menuItemDeleteAllSelectedInstances>
    //*  75  157:if_acmpne       167
            deleteInstances();
    //   76  160:aload_0         
    //   77  161:invokevirtual   #688 <Method void deleteInstances()>
        else
    //*  78  164:goto            269
        if(o == menuItemSortInstances)
    //*  79  167:aload_2         
    //*  80  168:aload_0         
    //*  81  169:getfield        #153 <Field JMenuItem menuItemSortInstances>
    //*  82  172:if_acmpne       182
            sortInstances();
    //   83  175:aload_0         
    //   84  176:invokevirtual   #690 <Method void sortInstances()>
        else
    //*  85  179:goto            269
        if(o == menuItemSearch)
    //*  86  182:aload_2         
    //*  87  183:aload_0         
    //*  88  184:getfield        #173 <Field JMenuItem menuItemSearch>
    //*  89  187:if_acmpne       197
            search();
    //   90  190:aload_0         
    //   91  191:invokevirtual   #692 <Method void search()>
        else
    //*  92  194:goto            269
        if(o == menuItemClearSearch)
    //*  93  197:aload_2         
    //*  94  198:aload_0         
    //*  95  199:getfield        #177 <Field JMenuItem menuItemClearSearch>
    //*  96  202:if_acmpne       212
            clearSearch();
    //   97  205:aload_0         
    //   98  206:invokevirtual   #694 <Method void clearSearch()>
        else
    //*  99  209:goto            269
        if(o == menuItemUndo)
    //* 100  212:aload_2         
    //* 101  213:aload_0         
    //* 102  214:getfield        #165 <Field JMenuItem menuItemUndo>
    //* 103  217:if_acmpne       227
            undo();
    //  104  220:aload_0         
    //  105  221:invokevirtual   #695 <Method void undo()>
        else
    //* 106  224:goto            269
        if(o == menuItemCopy)
    //* 107  227:aload_2         
    //* 108  228:aload_0         
    //* 109  229:getfield        #169 <Field JMenuItem menuItemCopy>
    //* 110  232:if_acmpne       242
            copyContent();
    //  111  235:aload_0         
    //  112  236:invokevirtual   #697 <Method void copyContent()>
        else
    //* 113  239:goto            269
        if(o == menuItemOptimalColWidth)
    //* 114  242:aload_2         
    //* 115  243:aload_0         
    //* 116  244:getfield        #157 <Field JMenuItem menuItemOptimalColWidth>
    //* 117  247:if_acmpne       257
            setOptimalColWidth();
    //  118  250:aload_0         
    //  119  251:invokevirtual   #699 <Method void setOptimalColWidth()>
        else
    //* 120  254:goto            269
        if(o == menuItemOptimalColWidths)
    //* 121  257:aload_2         
    //* 122  258:aload_0         
    //* 123  259:getfield        #161 <Field JMenuItem menuItemOptimalColWidths>
    //* 124  262:if_acmpne       269
            setOptimalColWidths();
    //  125  265:aload_0         
    //  126  266:invokevirtual   #701 <Method void setOptimalColWidths()>
    //  127  269:return          
    }

    public void mouseClicked(MouseEvent e)
    {
        int col = m_TableArff.columnAtPoint(e.getPoint());
    //    0    0:aload_0         
    //    1    1:getfield        #190 <Field ArffTable m_TableArff>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #710 <Method java.awt.Point MouseEvent.getPoint()>
    //    4    8:invokevirtual   #714 <Method int ArffTable.columnAtPoint(java.awt.Point)>
    //    5   11:istore_2        
        boolean popup = e.getButton() == 3 && e.getClickCount() == 1 || e.getButton() == 1 && e.getClickCount() == 1 && e.isAltDown() && !e.isControlDown() && !e.isShiftDown();
    //    6   12:aload_1         
    //    7   13:invokevirtual   #717 <Method int MouseEvent.getButton()>
    //    8   16:iconst_3        
    //    9   17:icmpne          28
    //   10   20:aload_1         
    //   11   21:invokevirtual   #720 <Method int MouseEvent.getClickCount()>
    //   12   24:iconst_1        
    //   13   25:icmpeq          69
    //   14   28:aload_1         
    //   15   29:invokevirtual   #717 <Method int MouseEvent.getButton()>
    //   16   32:iconst_1        
    //   17   33:icmpne          65
    //   18   36:aload_1         
    //   19   37:invokevirtual   #720 <Method int MouseEvent.getClickCount()>
    //   20   40:iconst_1        
    //   21   41:icmpne          65
    //   22   44:aload_1         
    //   23   45:invokevirtual   #723 <Method boolean MouseEvent.isAltDown()>
    //   24   48:ifeq            65
    //   25   51:aload_1         
    //   26   52:invokevirtual   #726 <Method boolean MouseEvent.isControlDown()>
    //   27   55:ifne            65
    //   28   58:aload_1         
    //   29   59:invokevirtual   #729 <Method boolean MouseEvent.isShiftDown()>
    //   30   62:ifeq            69
    //   31   65:iconst_0        
    //   32   66:goto            70
    //   33   69:iconst_1        
    //   34   70:istore_3        
        popup = popup && getInstances() != null;
    //   35   71:iload_3         
    //   36   72:ifeq            86
    //   37   75:aload_0         
    //   38   76:invokevirtual   #339 <Method Instances getInstances()>
    //   39   79:ifnull          86
    //   40   82:iconst_1        
    //   41   83:goto            87
    //   42   86:iconst_0        
    //   43   87:istore_3        
        if(e.getSource() == m_TableArff.getTableHeader())
    //*  44   88:aload_1         
    //*  45   89:invokevirtual   #730 <Method Object MouseEvent.getSource()>
    //*  46   92:aload_0         
    //*  47   93:getfield        #190 <Field ArffTable m_TableArff>
    //*  48   96:invokevirtual   #199 <Method JTableHeader ArffTable.getTableHeader()>
    //*  49   99:if_acmpne       145
        {
            m_CurrentCol = col;
    //   50  102:aload_0         
    //   51  103:iload_2         
    //   52  104:putfield        #91  <Field int m_CurrentCol>
            if(popup)
    //*  53  107:iload_3         
    //*  54  108:ifeq            191
            {
                e.consume();
    //   55  111:aload_1         
    //   56  112:invokevirtual   #733 <Method void MouseEvent.consume()>
                setMenu();
    //   57  115:aload_0         
    //   58  116:invokespecial   #383 <Method void setMenu()>
                initPopupMenus();
    //   59  119:aload_0         
    //   60  120:invokespecial   #735 <Method void initPopupMenus()>
                m_PopupHeader.show(e.getComponent(), e.getX(), e.getY());
    //   61  123:aload_0         
    //   62  124:getfield        #246 <Field JPopupMenu m_PopupHeader>
    //   63  127:aload_1         
    //   64  128:invokevirtual   #739 <Method java.awt.Component MouseEvent.getComponent()>
    //   65  131:aload_1         
    //   66  132:invokevirtual   #742 <Method int MouseEvent.getX()>
    //   67  135:aload_1         
    //   68  136:invokevirtual   #745 <Method int MouseEvent.getY()>
    //   69  139:invokevirtual   #749 <Method void JPopupMenu.show(java.awt.Component, int, int)>
            }
        } else
    //*  70  142:goto            191
        if(e.getSource() == m_TableArff && popup)
    //*  71  145:aload_1         
    //*  72  146:invokevirtual   #730 <Method Object MouseEvent.getSource()>
    //*  73  149:aload_0         
    //*  74  150:getfield        #190 <Field ArffTable m_TableArff>
    //*  75  153:if_acmpne       191
    //*  76  156:iload_3         
    //*  77  157:ifeq            191
        {
            e.consume();
    //   78  160:aload_1         
    //   79  161:invokevirtual   #733 <Method void MouseEvent.consume()>
            setMenu();
    //   80  164:aload_0         
    //   81  165:invokespecial   #383 <Method void setMenu()>
            initPopupMenus();
    //   82  168:aload_0         
    //   83  169:invokespecial   #735 <Method void initPopupMenus()>
            m_PopupRows.show(e.getComponent(), e.getX(), e.getY());
    //   84  172:aload_0         
    //   85  173:getfield        #259 <Field JPopupMenu m_PopupRows>
    //   86  176:aload_1         
    //   87  177:invokevirtual   #739 <Method java.awt.Component MouseEvent.getComponent()>
    //   88  180:aload_1         
    //   89  181:invokevirtual   #742 <Method int MouseEvent.getX()>
    //   90  184:aload_1         
    //   91  185:invokevirtual   #745 <Method int MouseEvent.getY()>
    //   92  188:invokevirtual   #749 <Method void JPopupMenu.show(java.awt.Component, int, int)>
        }
        if(e.getButton() == 1 && e.getClickCount() == 1 && !e.isAltDown() && col > -1)
    //*  93  191:aload_1         
    //*  94  192:invokevirtual   #717 <Method int MouseEvent.getButton()>
    //*  95  195:iconst_1        
    //*  96  196:icmpne          227
    //*  97  199:aload_1         
    //*  98  200:invokevirtual   #720 <Method int MouseEvent.getClickCount()>
    //*  99  203:iconst_1        
    //* 100  204:icmpne          227
    //* 101  207:aload_1         
    //* 102  208:invokevirtual   #723 <Method boolean MouseEvent.isAltDown()>
    //* 103  211:ifne            227
    //* 104  214:iload_2         
    //* 105  215:iconst_m1       
    //* 106  216:icmple          227
            m_TableArff.setSelectedColumn(col);
    //  107  219:aload_0         
    //  108  220:getfield        #190 <Field ArffTable m_TableArff>
    //  109  223:iload_2         
    //  110  224:invokevirtual   #752 <Method void ArffTable.setSelectedColumn(int)>
    //  111  227:return          
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    //    0    0:return          
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    //    0    0:return          
    }

    public void mousePressed(MouseEvent mouseevent)
    {
    //    0    0:return          
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    //    0    0:return          
    }

    public void stateChanged(ChangeEvent e)
    {
        m_Changed = true;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #97  <Field boolean m_Changed>
        createTitle();
    //    3    5:aload_0         
    //    4    6:invokespecial   #317 <Method void createTitle()>
        notifyListener();
    //    5    9:aload_0         
    //    6   10:invokevirtual   #378 <Method void notifyListener()>
    //    7   13:return          
    }

    public void notifyListener()
    {
        for(Iterator iter = m_ChangeListeners.iterator(); iter.hasNext(); ((ChangeListener)(ChangeListener)iter.next()).stateChanged(new ChangeEvent(this)));
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field HashSet m_ChangeListeners>
    //    2    4:invokevirtual   #766 <Method Iterator HashSet.iterator()>
    //    3    7:astore_1        
    //    4    8:goto            36
    //    5   11:aload_1         
    //    6   12:invokeinterface #771 <Method Object Iterator.next()>
    //    7   17:checkcast       #8   <Class ChangeListener>
    //    8   20:checkcast       #8   <Class ChangeListener>
    //    9   23:new             #773 <Class ChangeEvent>
    //   10   26:dup             
    //   11   27:aload_0         
    //   12   28:invokespecial   #775 <Method void ChangeEvent(Object)>
    //   13   31:invokeinterface #777 <Method void ChangeListener.stateChanged(ChangeEvent)>
    //   14   36:aload_1         
    //   15   37:invokeinterface #780 <Method boolean Iterator.hasNext()>
    //   16   42:ifne            11
    //   17   45:return          
    }

    public void addChangeListener(ChangeListener l)
    {
        m_ChangeListeners.add(l);
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field HashSet m_ChangeListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #783 <Method boolean HashSet.add(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    public void removeChangeListener(ChangeListener l)
    {
        m_ChangeListeners.remove(l);
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field HashSet m_ChangeListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #789 <Method boolean HashSet.remove(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    static final long serialVersionUID = 0xbed0c1f58be0cb2dL;
    public static final String TAB_INSTANCES = "Instances";
    public ArffTable m_TableArff;
    private JPopupMenu m_PopupHeader;
    private JPopupMenu m_PopupRows;
    private JLabel m_LabelName;
    private JMenuItem menuItemMean;
    private JMenuItem menuItemSetAllValues;
    private JMenuItem menuItemSetMissingValues;
    private JMenuItem menuItemReplaceValues;
    private JMenuItem menuItemRenameAttribute;
    private JMenuItem menuItemAttributeAsClass;
    private JMenuItem menuItemDeleteAttribute;
    private JMenuItem menuItemDeleteAttributes;
    private JMenuItem menuItemSortInstances;
    private JMenuItem menuItemDeleteSelectedInstance;
    private JMenuItem menuItemDeleteAllSelectedInstances;
    private JMenuItem menuItemSearch;
    private JMenuItem menuItemClearSearch;
    private JMenuItem menuItemUndo;
    private JMenuItem menuItemCopy;
    private JMenuItem menuItemOptimalColWidth;
    private JMenuItem menuItemOptimalColWidths;
    private String m_Filename;
    private String m_Title;
    private int m_CurrentCol;
    private boolean m_Changed;
    private HashSet m_ChangeListeners;
    private String m_LastSearch;
    private String m_LastReplace;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PreprocessPanel.java

package rm.gui.explorer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import rm.core.Assignment;
import rm.core.Attribute;
import rm.core.AttributeVisualizationPanel;
import rm.core.Dimension;
import rm.core.Instances;
import rm.core.OptionHandler;
import rm.core.Utils;
import rm.core.converters.AbstractFileLoader;
import rm.core.converters.AssLoader;
import rm.core.converters.CSVLoader;
import rm.core.converters.ConverterUtils;
import rm.core.converters.Loader;
import rm.core.converters.SerializedInstancesLoader;
import rm.filters.Filter;
import rm.filters.SupervisedFilter;
import rm.generate.Generate;
import rm.gui.AssEdit;
import rm.gui.AssignmentViewer;
import rm.gui.AttributeSelectionPanel;
import rm.gui.AttributeSummaryPanel;
import rm.gui.ConverterFileChooser;
import rm.gui.GenericObjectEditor;
import rm.gui.InstancesSummaryPanel;
import rm.gui.LogPanel;
import rm.gui.Logger;
import rm.gui.PropertyDialog;
import rm.gui.PropertyPanel;
import rm.gui.SysErrLog;
import rm.gui.TaskLogger;
import rm.gui.ViewerDialog;
import rm.gui.beans.AttributeSummarizer;

// Referenced classes of package rm.gui.explorer:
//            ExplorerDefaults, TabbedPane, Remove

public class PreprocessPanel extends JPanel
{
    class action
        implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == m_OpenFileBut)
        //*   0    0:aload_1         
        //*   1    1:invokevirtual   #28  <Method Object ActionEvent.getSource()>
        //*   2    4:aload_0         
        //*   3    5:getfield        #13  <Field PreprocessPanel this$0>
        //*   4    8:getfield        #34  <Field JButton PreprocessPanel.m_OpenFileBut>
        //*   5   11:if_acmpne       24
                openFile();
        //    6   14:aload_0         
        //    7   15:getfield        #13  <Field PreprocessPanel this$0>
        //    8   18:invokestatic    #37  <Method void PreprocessPanel.access$0(PreprocessPanel)>
            else
        //*   9   21:goto            103
            if(e.getSource() == m_EditBut)
        //*  10   24:aload_1         
        //*  11   25:invokevirtual   #28  <Method Object ActionEvent.getSource()>
        //*  12   28:aload_0         
        //*  13   29:getfield        #13  <Field PreprocessPanel this$0>
        //*  14   32:getfield        #40  <Field JButton PreprocessPanel.m_EditBut>
        //*  15   35:if_acmpne       58
                openEditor(SelectedFile.getAbsolutePath());
        //   16   38:aload_0         
        //   17   39:getfield        #13  <Field PreprocessPanel this$0>
        //   18   42:aload_0         
        //   19   43:getfield        #13  <Field PreprocessPanel this$0>
        //   20   46:getfield        #44  <Field File PreprocessPanel.SelectedFile>
        //   21   49:invokevirtual   #50  <Method String File.getAbsolutePath()>
        //   22   52:invokestatic    #54  <Method void PreprocessPanel.access$1(PreprocessPanel, String)>
            else
        //*  23   55:goto            103
            if(e.getSource() == m_GenerateBut)
        //*  24   58:aload_1         
        //*  25   59:invokevirtual   #28  <Method Object ActionEvent.getSource()>
        //*  26   62:aload_0         
        //*  27   63:getfield        #13  <Field PreprocessPanel this$0>
        //*  28   66:getfield        #57  <Field JButton PreprocessPanel.m_GenerateBut>
        //*  29   69:if_acmpne       82
                generateAssignment();
        //   30   72:aload_0         
        //   31   73:getfield        #13  <Field PreprocessPanel this$0>
        //   32   76:invokevirtual   #60  <Method void PreprocessPanel.generateAssignment()>
            else
        //*  33   79:goto            103
            if(e.getSource() == m_SaveBut)
        //*  34   82:aload_1         
        //*  35   83:invokevirtual   #28  <Method Object ActionEvent.getSource()>
        //*  36   86:aload_0         
        //*  37   87:getfield        #13  <Field PreprocessPanel this$0>
        //*  38   90:getfield        #63  <Field JButton PreprocessPanel.m_SaveBut>
        //*  39   93:if_acmpne       103
                saveWorkingAssignment();
        //   40   96:aload_0         
        //   41   97:getfield        #13  <Field PreprocessPanel this$0>
        //   42  100:invokestatic    #66  <Method void PreprocessPanel.access$2(PreprocessPanel)>
        //   43  103:return          
        }

        final PreprocessPanel this$0;

        action()
        {
            this$0 = PreprocessPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #13  <Field PreprocessPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #16  <Method void Object()>
        //    5    9:return          
        }
    }


    public PreprocessPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #77  <Method void JPanel()>
        m_InstSummaryPanel = new InstancesSummaryPanel();
    //    2    4:aload_0         
    //    3    5:new             #79  <Class InstancesSummaryPanel>
    //    4    8:dup             
    //    5    9:invokespecial   #80  <Method void InstancesSummaryPanel()>
    //    6   12:putfield        #82  <Field InstancesSummaryPanel m_InstSummaryPanel>
        m_AttPanel = new AttributeSelectionPanel();
    //    7   15:aload_0         
    //    8   16:new             #84  <Class AttributeSelectionPanel>
    //    9   19:dup             
    //   10   20:invokespecial   #85  <Method void AttributeSelectionPanel()>
    //   11   23:putfield        #87  <Field AttributeSelectionPanel m_AttPanel>
        m_tempUndoIndex = 0;
    //   12   26:aload_0         
    //   13   27:iconst_0        
    //   14   28:putfield        #89  <Field int m_tempUndoIndex>
        m_OpenFileBut = new JButton("Open file...");
    //   15   31:aload_0         
    //   16   32:new             #91  <Class JButton>
    //   17   35:dup             
    //   18   36:ldc1            #93  <String "Open file...">
    //   19   38:invokespecial   #96  <Method void JButton(String)>
    //   20   41:putfield        #98  <Field JButton m_OpenFileBut>
        m_GenerateBut = new JButton("Generate...");
    //   21   44:aload_0         
    //   22   45:new             #91  <Class JButton>
    //   23   48:dup             
    //   24   49:ldc1            #100 <String "Generate...">
    //   25   51:invokespecial   #96  <Method void JButton(String)>
    //   26   54:putfield        #102 <Field JButton m_GenerateBut>
        m_UndoBut = new JButton("Undo");
    //   27   57:aload_0         
    //   28   58:new             #91  <Class JButton>
    //   29   61:dup             
    //   30   62:ldc1            #104 <String "Undo">
    //   31   64:invokespecial   #96  <Method void JButton(String)>
    //   32   67:putfield        #106 <Field JButton m_UndoBut>
        m_EditBut = new JButton("Edit...");
    //   33   70:aload_0         
    //   34   71:new             #91  <Class JButton>
    //   35   74:dup             
    //   36   75:ldc1            #108 <String "Edit...">
    //   37   77:invokespecial   #96  <Method void JButton(String)>
    //   38   80:putfield        #110 <Field JButton m_EditBut>
        m_SaveBut = new JButton("Save...");
    //   39   83:aload_0         
    //   40   84:new             #91  <Class JButton>
    //   41   87:dup             
    //   42   88:ldc1            #112 <String "Save...">
    //   43   90:invokespecial   #96  <Method void JButton(String)>
    //   44   93:putfield        #114 <Field JButton m_SaveBut>
        labR = new JLabel("Assignment:");
    //   45   96:aload_0         
    //   46   97:new             #116 <Class JLabel>
    //   47  100:dup             
    //   48  101:ldc1            #118 <String "Assignment:">
    //   49  103:invokespecial   #119 <Method void JLabel(String)>
    //   50  106:putfield        #121 <Field JLabel labR>
        m_DRBut = new JButton("UPA");
    //   51  109:aload_0         
    //   52  110:new             #91  <Class JButton>
    //   53  113:dup             
    //   54  114:ldc1            #123 <String "UPA">
    //   55  116:invokespecial   #96  <Method void JButton(String)>
    //   56  119:putfield        #125 <Field JButton m_DRBut>
        labX = new JLabel("Attribute:");
    //   57  122:aload_0         
    //   58  123:new             #116 <Class JLabel>
    //   59  126:dup             
    //   60  127:ldc1            #127 <String "Attribute:">
    //   61  129:invokespecial   #119 <Method void JLabel(String)>
    //   62  132:putfield        #129 <Field JLabel labX>
        m_DXBut = new JButton("Users");
    //   63  135:aload_0         
    //   64  136:new             #91  <Class JButton>
    //   65  139:dup             
    //   66  140:ldc1            #131 <String "Users">
    //   67  142:invokespecial   #96  <Method void JButton(String)>
    //   68  145:putfield        #133 <Field JButton m_DXBut>
        labY = new JLabel("Attribute:");
    //   69  148:aload_0         
    //   70  149:new             #116 <Class JLabel>
    //   71  152:dup             
    //   72  153:ldc1            #127 <String "Attribute:">
    //   73  155:invokespecial   #119 <Method void JLabel(String)>
    //   74  158:putfield        #135 <Field JLabel labY>
        m_DYBut = new JButton("Permssions");
    //   75  161:aload_0         
    //   76  162:new             #91  <Class JButton>
    //   77  165:dup             
    //   78  166:ldc1            #137 <String "Permssions">
    //   79  168:invokespecial   #96  <Method void JButton(String)>
    //   80  171:putfield        #139 <Field JButton m_DYBut>
        labNumX = new JLabel("NumofUsers:", 4);
    //   81  174:aload_0         
    //   82  175:new             #116 <Class JLabel>
    //   83  178:dup             
    //   84  179:ldc1            #141 <String "NumofUsers:">
    //   85  181:iconst_4        
    //   86  182:invokespecial   #144 <Method void JLabel(String, int)>
    //   87  185:putfield        #146 <Field JLabel labNumX>
        NumX = new JLabel("None");
    //   88  188:aload_0         
    //   89  189:new             #116 <Class JLabel>
    //   90  192:dup             
    //   91  193:ldc1            #13  <String "None">
    //   92  195:invokespecial   #119 <Method void JLabel(String)>
    //   93  198:putfield        #148 <Field JLabel NumX>
        labNumY = new JLabel("NumofPermssions:", 4);
    //   94  201:aload_0         
    //   95  202:new             #116 <Class JLabel>
    //   96  205:dup             
    //   97  206:ldc1            #150 <String "NumofPermssions:">
    //   98  208:iconst_4        
    //   99  209:invokespecial   #144 <Method void JLabel(String, int)>
    //  100  212:putfield        #152 <Field JLabel labNumY>
        NumY = new JLabel("None");
    //  101  215:aload_0         
    //  102  216:new             #116 <Class JLabel>
    //  103  219:dup             
    //  104  220:ldc1            #13  <String "None">
    //  105  222:invokespecial   #119 <Method void JLabel(String)>
    //  106  225:putfield        #154 <Field JLabel NumY>
        m_FileChooser = new ConverterFileChooser(new File(ExplorerDefaults.getInitialDirectory()));
    //  107  228:aload_0         
    //  108  229:new             #156 <Class ConverterFileChooser>
    //  109  232:dup             
    //  110  233:new             #158 <Class File>
    //  111  236:dup             
    //  112  237:invokestatic    #164 <Method String ExplorerDefaults.getInitialDirectory()>
    //  113  240:invokespecial   #165 <Method void File(String)>
    //  114  243:invokespecial   #168 <Method void ConverterFileChooser(File)>
    //  115  246:putfield        #170 <Field ConverterFileChooser m_FileChooser>
        SelectedFile = null;
    //  116  249:aload_0         
    //  117  250:aconst_null     
    //  118  251:putfield        #172 <Field File SelectedFile>
        AssData = null;
    //  119  254:aload_0         
    //  120  255:aconst_null     
    //  121  256:putfield        #174 <Field AssLoader AssData>
        m_assignment = null;
    //  122  259:aload_0         
    //  123  260:aconst_null     
    //  124  261:putfield        #176 <Field Assignment m_assignment>
        m_Tabbedpane = null;
    //  125  264:aload_0         
    //  126  265:aconst_null     
    //  127  266:putfield        #178 <Field TabbedPane m_Tabbedpane>
        m_RemoveButton = new JButton("Remove");
    //  128  269:aload_0         
    //  129  270:new             #91  <Class JButton>
    //  130  273:dup             
    //  131  274:ldc1            #180 <String "Remove">
    //  132  276:invokespecial   #96  <Method void JButton(String)>
    //  133  279:putfield        #182 <Field JButton m_RemoveButton>
        m_AttSummaryPanel = new AttributeSummaryPanel();
    //  134  282:aload_0         
    //  135  283:new             #184 <Class AttributeSummaryPanel>
    //  136  286:dup             
    //  137  287:invokespecial   #185 <Method void AttributeSummaryPanel()>
    //  138  290:putfield        #187 <Field AttributeSummaryPanel m_AttSummaryPanel>
        m_AttVisualizePanel = new AttributeVisualizationPanel();
    //  139  293:aload_0         
    //  140  294:new             #189 <Class AttributeVisualizationPanel>
    //  141  297:dup             
    //  142  298:invokespecial   #190 <Method void AttributeVisualizationPanel()>
    //  143  301:putfield        #192 <Field AttributeVisualizationPanel m_AttVisualizePanel>
        relation = new JPanel();
    //  144  304:aload_0         
    //  145  305:new             #4   <Class JPanel>
    //  146  308:dup             
    //  147  309:invokespecial   #77  <Method void JPanel()>
    //  148  312:putfield        #194 <Field JPanel relation>
        m_Log = new SysErrLog();
    //  149  315:aload_0         
    //  150  316:new             #196 <Class SysErrLog>
    //  151  319:dup             
    //  152  320:invokespecial   #197 <Method void SysErrLog()>
    //  153  323:putfield        #199 <Field Logger m_Log>
        m_GeneratorEditor = new GenericObjectEditor();
    //  154  326:aload_0         
    //  155  327:new             #201 <Class GenericObjectEditor>
    //  156  330:dup             
    //  157  331:invokespecial   #202 <Method void GenericObjectEditor()>
    //  158  334:putfield        #204 <Field GenericObjectEditor m_GeneratorEditor>
        m_tempUndoFiles = new File[20];
    //  159  337:aload_0         
    //  160  338:bipush          20
    //  161  340:anewarray       File[]
    //  162  343:putfield        #206 <Field File[] m_tempUndoFiles>
        m_OpenFileBut.setToolTipText("Open a set of instances from a file");
    //  163  346:aload_0         
    //  164  347:getfield        #98  <Field JButton m_OpenFileBut>
    //  165  350:ldc1            #208 <String "Open a set of instances from a file">
    //  166  352:invokevirtual   #211 <Method void JButton.setToolTipText(String)>
        m_GenerateBut.setToolTipText("Generates artificial data");
    //  167  355:aload_0         
    //  168  356:getfield        #102 <Field JButton m_GenerateBut>
    //  169  359:ldc1            #213 <String "Generates artificial data">
    //  170  361:invokevirtual   #211 <Method void JButton.setToolTipText(String)>
        m_UndoBut.setToolTipText("Undo the last change to the dataset");
    //  171  364:aload_0         
    //  172  365:getfield        #106 <Field JButton m_UndoBut>
    //  173  368:ldc1            #215 <String "Undo the last change to the dataset">
    //  174  370:invokevirtual   #211 <Method void JButton.setToolTipText(String)>
        m_EditBut.setToolTipText("Open the current dataset in a Viewer for editing");
    //  175  373:aload_0         
    //  176  374:getfield        #110 <Field JButton m_EditBut>
    //  177  377:ldc1            #217 <String "Open the current dataset in a Viewer for editing">
    //  178  379:invokevirtual   #211 <Method void JButton.setToolTipText(String)>
        m_SaveBut.setToolTipText("Save the working relation to a file");
    //  179  382:aload_0         
    //  180  383:getfield        #114 <Field JButton m_SaveBut>
    //  181  386:ldc1            #219 <String "Save the working relation to a file">
    //  182  388:invokevirtual   #211 <Method void JButton.setToolTipText(String)>
        m_FileChooser.setFileSelectionMode(2);
    //  183  391:aload_0         
    //  184  392:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //  185  395:iconst_2        
    //  186  396:invokevirtual   #223 <Method void ConverterFileChooser.setFileSelectionMode(int)>
        JPanel Dimensions = new JPanel();
    //  187  399:new             #4   <Class JPanel>
    //  188  402:dup             
    //  189  403:invokespecial   #77  <Method void JPanel()>
    //  190  406:astore_1        
        Dimensions.setBorder(BorderFactory.createTitledBorder("Assignment"));
    //  191  407:aload_1         
    //  192  408:ldc1            #225 <String "Assignment">
    //  193  410:invokestatic    #231 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  194  413:invokevirtual   #235 <Method void JPanel.setBorder(javax.swing.border.Border)>
        Dimensions.setLayout(new BorderLayout());
    //  195  416:aload_1         
    //  196  417:new             #237 <Class BorderLayout>
    //  197  420:dup             
    //  198  421:invokespecial   #238 <Method void BorderLayout()>
    //  199  424:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        JPanel InforDim = new JPanel();
    //  200  427:new             #4   <Class JPanel>
    //  201  430:dup             
    //  202  431:invokespecial   #77  <Method void JPanel()>
    //  203  434:astore_2        
        GridBagLayout gb = new GridBagLayout();
    //  204  435:new             #244 <Class GridBagLayout>
    //  205  438:dup             
    //  206  439:invokespecial   #245 <Method void GridBagLayout()>
    //  207  442:astore_3        
        InforDim.setLayout(gb);
    //  208  443:aload_2         
    //  209  444:aload_3         
    //  210  445:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        labNumX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
    //  211  448:aload_0         
    //  212  449:getfield        #146 <Field JLabel labNumX>
    //  213  452:iconst_0        
    //  214  453:iconst_0        
    //  215  454:iconst_0        
    //  216  455:iconst_5        
    //  217  456:invokestatic    #249 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  218  459:invokevirtual   #250 <Method void JLabel.setBorder(javax.swing.border.Border)>
        GridBagConstraints gbC = new GridBagConstraints();
    //  219  462:new             #252 <Class GridBagConstraints>
    //  220  465:dup             
    //  221  466:invokespecial   #253 <Method void GridBagConstraints()>
    //  222  469:astore          4
        gbC.gridy = 1;
    //  223  471:aload           4
    //  224  473:iconst_1        
    //  225  474:putfield        #256 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  226  477:aload           4
    //  227  479:iconst_0        
    //  228  480:putfield        #259 <Field int GridBagConstraints.gridx>
        gbC.anchor = 13;
    //  229  483:aload           4
    //  230  485:bipush          13
    //  231  487:putfield        #262 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  232  490:aload           4
    //  233  492:iconst_2        
    //  234  493:putfield        #265 <Field int GridBagConstraints.fill>
        gb.setConstraints(labNumX, gbC);
    //  235  496:aload_3         
    //  236  497:aload_0         
    //  237  498:getfield        #146 <Field JLabel labNumX>
    //  238  501:aload           4
    //  239  503:invokevirtual   #269 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        InforDim.add(labNumX);
    //  240  506:aload_2         
    //  241  507:aload_0         
    //  242  508:getfield        #146 <Field JLabel labNumX>
    //  243  511:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  244  514:pop             
        gbC = new GridBagConstraints();
    //  245  515:new             #252 <Class GridBagConstraints>
    //  246  518:dup             
    //  247  519:invokespecial   #253 <Method void GridBagConstraints()>
    //  248  522:astore          4
        gbC.gridy = 1;
    //  249  524:aload           4
    //  250  526:iconst_1        
    //  251  527:putfield        #256 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  252  530:aload           4
    //  253  532:iconst_1        
    //  254  533:putfield        #259 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //  255  536:aload           4
    //  256  538:bipush          17
    //  257  540:putfield        #262 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  258  543:aload           4
    //  259  545:iconst_2        
    //  260  546:putfield        #265 <Field int GridBagConstraints.fill>
        gbC.weightx = 100D;
    //  261  549:aload           4
    //  262  551:ldc2w           #274 <Double 100D>
    //  263  554:putfield        #279 <Field double GridBagConstraints.weightx>
        gb.setConstraints(NumX, gbC);
    //  264  557:aload_3         
    //  265  558:aload_0         
    //  266  559:getfield        #148 <Field JLabel NumX>
    //  267  562:aload           4
    //  268  564:invokevirtual   #269 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        InforDim.add(NumX);
    //  269  567:aload_2         
    //  270  568:aload_0         
    //  271  569:getfield        #148 <Field JLabel NumX>
    //  272  572:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  273  575:pop             
        NumX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
    //  274  576:aload_0         
    //  275  577:getfield        #148 <Field JLabel NumX>
    //  276  580:iconst_0        
    //  277  581:iconst_0        
    //  278  582:iconst_0        
    //  279  583:bipush          50
    //  280  585:invokestatic    #249 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  281  588:invokevirtual   #250 <Method void JLabel.setBorder(javax.swing.border.Border)>
        labNumY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
    //  282  591:aload_0         
    //  283  592:getfield        #152 <Field JLabel labNumY>
    //  284  595:iconst_0        
    //  285  596:iconst_0        
    //  286  597:iconst_0        
    //  287  598:iconst_5        
    //  288  599:invokestatic    #249 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  289  602:invokevirtual   #250 <Method void JLabel.setBorder(javax.swing.border.Border)>
        gbC = new GridBagConstraints();
    //  290  605:new             #252 <Class GridBagConstraints>
    //  291  608:dup             
    //  292  609:invokespecial   #253 <Method void GridBagConstraints()>
    //  293  612:astore          4
        gbC.gridy = 1;
    //  294  614:aload           4
    //  295  616:iconst_1        
    //  296  617:putfield        #256 <Field int GridBagConstraints.gridy>
        gbC.gridx = 2;
    //  297  620:aload           4
    //  298  622:iconst_2        
    //  299  623:putfield        #259 <Field int GridBagConstraints.gridx>
        gbC.anchor = 13;
    //  300  626:aload           4
    //  301  628:bipush          13
    //  302  630:putfield        #262 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  303  633:aload           4
    //  304  635:iconst_2        
    //  305  636:putfield        #265 <Field int GridBagConstraints.fill>
        gb.setConstraints(labNumY, gbC);
    //  306  639:aload_3         
    //  307  640:aload_0         
    //  308  641:getfield        #152 <Field JLabel labNumY>
    //  309  644:aload           4
    //  310  646:invokevirtual   #269 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        InforDim.add(labNumY);
    //  311  649:aload_2         
    //  312  650:aload_0         
    //  313  651:getfield        #152 <Field JLabel labNumY>
    //  314  654:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  315  657:pop             
        gbC = new GridBagConstraints();
    //  316  658:new             #252 <Class GridBagConstraints>
    //  317  661:dup             
    //  318  662:invokespecial   #253 <Method void GridBagConstraints()>
    //  319  665:astore          4
        gbC.gridy = 1;
    //  320  667:aload           4
    //  321  669:iconst_1        
    //  322  670:putfield        #256 <Field int GridBagConstraints.gridy>
        gbC.gridx = 3;
    //  323  673:aload           4
    //  324  675:iconst_3        
    //  325  676:putfield        #259 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //  326  679:aload           4
    //  327  681:bipush          17
    //  328  683:putfield        #262 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  329  686:aload           4
    //  330  688:iconst_2        
    //  331  689:putfield        #265 <Field int GridBagConstraints.fill>
        gbC.weightx = 100D;
    //  332  692:aload           4
    //  333  694:ldc2w           #274 <Double 100D>
    //  334  697:putfield        #279 <Field double GridBagConstraints.weightx>
        gb.setConstraints(NumY, gbC);
    //  335  700:aload_3         
    //  336  701:aload_0         
    //  337  702:getfield        #154 <Field JLabel NumY>
    //  338  705:aload           4
    //  339  707:invokevirtual   #269 <Method void GridBagLayout.setConstraints(java.awt.Component, GridBagConstraints)>
        InforDim.add(NumY);
    //  340  710:aload_2         
    //  341  711:aload_0         
    //  342  712:getfield        #154 <Field JLabel NumY>
    //  343  715:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  344  718:pop             
        NumY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
    //  345  719:aload_0         
    //  346  720:getfield        #154 <Field JLabel NumY>
    //  347  723:iconst_0        
    //  348  724:iconst_0        
    //  349  725:iconst_0        
    //  350  726:bipush          50
    //  351  728:invokestatic    #249 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  352  731:invokevirtual   #250 <Method void JLabel.setBorder(javax.swing.border.Border)>
        JPanel SelectDim = new JPanel();
    //  353  734:new             #4   <Class JPanel>
    //  354  737:dup             
    //  355  738:invokespecial   #77  <Method void JPanel()>
    //  356  741:astore          5
        SelectDim.add(labX);
    //  357  743:aload           5
    //  358  745:aload_0         
    //  359  746:getfield        #129 <Field JLabel labX>
    //  360  749:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  361  752:pop             
        SelectDim.add(m_DXBut);
    //  362  753:aload           5
    //  363  755:aload_0         
    //  364  756:getfield        #133 <Field JButton m_DXBut>
    //  365  759:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  366  762:pop             
        m_DXBut.setEnabled(false);
    //  367  763:aload_0         
    //  368  764:getfield        #133 <Field JButton m_DXBut>
    //  369  767:iconst_0        
    //  370  768:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_DXBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae)
            {
                if(m_assignment != null)
            //*   0    0:aload_0         
            //*   1    1:getfield        #13  <Field PreprocessPanel this$0>
            //*   2    4:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //*   3    7:ifnull          116
                    if(m_assignment.getDimensionX().getDimensionInstances() != null)
            //*   4   10:aload_0         
            //*   5   11:getfield        #13  <Field PreprocessPanel this$0>
            //*   6   14:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //*   7   17:invokevirtual   #34  <Method Dimension Assignment.getDimensionX()>
            //*   8   20:invokevirtual   #40  <Method Instances Dimension.getDimensionInstances()>
            //*   9   23:ifnull          56
                    {
                        setInstances(m_assignment.getDimensionX().getDimensionInstances());
            //   10   26:aload_0         
            //   11   27:getfield        #13  <Field PreprocessPanel this$0>
            //   12   30:aload_0         
            //   13   31:getfield        #13  <Field PreprocessPanel this$0>
            //   14   34:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //   15   37:invokevirtual   #34  <Method Dimension Assignment.getDimensionX()>
            //   16   40:invokevirtual   #40  <Method Instances Dimension.getDimensionInstances()>
            //   17   43:invokevirtual   #44  <Method void PreprocessPanel.setInstances(Instances)>
                        InstanceEdit();
            //   18   46:aload_0         
            //   19   47:getfield        #13  <Field PreprocessPanel this$0>
            //   20   50:invokestatic    #47  <Method void PreprocessPanel.access$3(PreprocessPanel)>
                    } else
            //*  21   53:goto            116
                    {
                        m_Log.logMessage((new StringBuilder("The Attributes of ")).append(m_assignment.getDimensionX().getDimensionAttribute().name()).append(" is NULL!").toString());
            //   22   56:aload_0         
            //   23   57:getfield        #13  <Field PreprocessPanel this$0>
            //   24   60:getfield        #51  <Field Logger PreprocessPanel.m_Log>
            //   25   63:new             #53  <Class StringBuilder>
            //   26   66:dup             
            //   27   67:ldc1            #55  <String "The Attributes of ">
            //   28   69:invokespecial   #58  <Method void StringBuilder(String)>
            //   29   72:aload_0         
            //   30   73:getfield        #13  <Field PreprocessPanel this$0>
            //   31   76:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //   32   79:invokevirtual   #34  <Method Dimension Assignment.getDimensionX()>
            //   33   82:invokevirtual   #62  <Method Attribute Dimension.getDimensionAttribute()>
            //   34   85:invokevirtual   #68  <Method String Attribute.name()>
            //   35   88:invokevirtual   #72  <Method StringBuilder StringBuilder.append(String)>
            //   36   91:ldc1            #74  <String " is NULL!">
            //   37   93:invokevirtual   #72  <Method StringBuilder StringBuilder.append(String)>
            //   38   96:invokevirtual   #77  <Method String StringBuilder.toString()>
            //   39   99:invokeinterface #82  <Method void Logger.logMessage(String)>
                        JOptionPane.showMessageDialog(PreprocessPanel.this, "The Attributes DimensionX is NULL! ", "Select DimensionX ", 0);
            //   40  104:aload_0         
            //   41  105:getfield        #13  <Field PreprocessPanel this$0>
            //   42  108:ldc1            #84  <String "The Attributes DimensionX is NULL! ">
            //   43  110:ldc1            #86  <String "Select DimensionX ">
            //   44  112:iconst_0        
            //   45  113:invokestatic    #92  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                    }
            //   46  116:return          
            }

            final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  371  771:aload_0         
    //  372  772:getfield        #133 <Field JButton m_DXBut>
    //  373  775:new             #285 <Class PreprocessPanel$1>
    //  374  778:dup             
    //  375  779:aload_0         
    //  376  780:invokespecial   #288 <Method void PreprocessPanel$1(PreprocessPanel)>
    //  377  783:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        SelectDim.add(labY);
    //  378  786:aload           5
    //  379  788:aload_0         
    //  380  789:getfield        #135 <Field JLabel labY>
    //  381  792:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  382  795:pop             
        SelectDim.add(m_DYBut);
    //  383  796:aload           5
    //  384  798:aload_0         
    //  385  799:getfield        #139 <Field JButton m_DYBut>
    //  386  802:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  387  805:pop             
        m_DYBut.setEnabled(false);
    //  388  806:aload_0         
    //  389  807:getfield        #139 <Field JButton m_DYBut>
    //  390  810:iconst_0        
    //  391  811:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_DYBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae)
            {
                if(m_assignment != null)
            //*   0    0:aload_0         
            //*   1    1:getfield        #13  <Field PreprocessPanel this$0>
            //*   2    4:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //*   3    7:ifnull          136
                    if(m_assignment.getDimensionY().getDimensionInstances() != null)
            //*   4   10:aload_0         
            //*   5   11:getfield        #13  <Field PreprocessPanel this$0>
            //*   6   14:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //*   7   17:invokevirtual   #34  <Method Dimension Assignment.getDimensionY()>
            //*   8   20:invokevirtual   #40  <Method Instances Dimension.getDimensionInstances()>
            //*   9   23:ifnull          76
                    {
                        setInstances(m_assignment.getDimensionY().getDimensionInstances());
            //   10   26:aload_0         
            //   11   27:getfield        #13  <Field PreprocessPanel this$0>
            //   12   30:aload_0         
            //   13   31:getfield        #13  <Field PreprocessPanel this$0>
            //   14   34:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //   15   37:invokevirtual   #34  <Method Dimension Assignment.getDimensionY()>
            //   16   40:invokevirtual   #40  <Method Instances Dimension.getDimensionInstances()>
            //   17   43:invokevirtual   #44  <Method void PreprocessPanel.setInstances(Instances)>
                        InstanceEdit();
            //   18   46:aload_0         
            //   19   47:getfield        #13  <Field PreprocessPanel this$0>
            //   20   50:invokestatic    #47  <Method void PreprocessPanel.access$3(PreprocessPanel)>
                        m_assignment.getDimensionY().setDimensionInstances(m_Instances);
            //   21   53:aload_0         
            //   22   54:getfield        #13  <Field PreprocessPanel this$0>
            //   23   57:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //   24   60:invokevirtual   #34  <Method Dimension Assignment.getDimensionY()>
            //   25   63:aload_0         
            //   26   64:getfield        #13  <Field PreprocessPanel this$0>
            //   27   67:getfield        #51  <Field Instances PreprocessPanel.m_Instances>
            //   28   70:invokevirtual   #54  <Method void Dimension.setDimensionInstances(Instances)>
                    } else
            //*  29   73:goto            136
                    {
                        m_Log.logMessage((new StringBuilder("The Attributes of ")).append(m_assignment.getDimensionY().getDimensionAttribute().name()).append(" is NULL!").toString());
            //   30   76:aload_0         
            //   31   77:getfield        #13  <Field PreprocessPanel this$0>
            //   32   80:getfield        #58  <Field Logger PreprocessPanel.m_Log>
            //   33   83:new             #60  <Class StringBuilder>
            //   34   86:dup             
            //   35   87:ldc1            #62  <String "The Attributes of ">
            //   36   89:invokespecial   #65  <Method void StringBuilder(String)>
            //   37   92:aload_0         
            //   38   93:getfield        #13  <Field PreprocessPanel this$0>
            //   39   96:getfield        #28  <Field Assignment PreprocessPanel.m_assignment>
            //   40   99:invokevirtual   #34  <Method Dimension Assignment.getDimensionY()>
            //   41  102:invokevirtual   #69  <Method Attribute Dimension.getDimensionAttribute()>
            //   42  105:invokevirtual   #75  <Method String Attribute.name()>
            //   43  108:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
            //   44  111:ldc1            #81  <String " is NULL!">
            //   45  113:invokevirtual   #79  <Method StringBuilder StringBuilder.append(String)>
            //   46  116:invokevirtual   #84  <Method String StringBuilder.toString()>
            //   47  119:invokeinterface #89  <Method void Logger.logMessage(String)>
                        JOptionPane.showMessageDialog(PreprocessPanel.this, "The Attributes DimensionY is NULL! ", "Select DimensionX ", 0);
            //   48  124:aload_0         
            //   49  125:getfield        #13  <Field PreprocessPanel this$0>
            //   50  128:ldc1            #91  <String "The Attributes DimensionY is NULL! ">
            //   51  130:ldc1            #93  <String "Select DimensionX ">
            //   52  132:iconst_0        
            //   53  133:invokestatic    #99  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                    }
            //   54  136:return          
            }

            final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  392  814:aload_0         
    //  393  815:getfield        #139 <Field JButton m_DYBut>
    //  394  818:new             #294 <Class PreprocessPanel$2>
    //  395  821:dup             
    //  396  822:aload_0         
    //  397  823:invokespecial   #295 <Method void PreprocessPanel$2(PreprocessPanel)>
    //  398  826:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        SelectDim.add(labR);
    //  399  829:aload           5
    //  400  831:aload_0         
    //  401  832:getfield        #121 <Field JLabel labR>
    //  402  835:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  403  838:pop             
        SelectDim.add(m_DRBut);
    //  404  839:aload           5
    //  405  841:aload_0         
    //  406  842:getfield        #125 <Field JButton m_DRBut>
    //  407  845:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  408  848:pop             
        m_DRBut.setEnabled(false);
    //  409  849:aload_0         
    //  410  850:getfield        #125 <Field JButton m_DRBut>
    //  411  853:iconst_0        
    //  412  854:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_DRBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                ViewAssignment();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PreprocessPanel this$0>
            //    2    4:invokevirtual   #27  <Method void PreprocessPanel.ViewAssignment()>
            //    3    7:return          
            }

            final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  413  857:aload_0         
    //  414  858:getfield        #125 <Field JButton m_DRBut>
    //  415  861:new             #297 <Class PreprocessPanel$3>
    //  416  864:dup             
    //  417  865:aload_0         
    //  418  866:invokespecial   #298 <Method void PreprocessPanel$3(PreprocessPanel)>
    //  419  869:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        Dimensions.add(InforDim, "West");
    //  420  872:aload_1         
    //  421  873:aload_2         
    //  422  874:ldc2            #300 <String "West">
    //  423  877:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        Dimensions.add(SelectDim, "East");
    //  424  880:aload_1         
    //  425  881:aload           5
    //  426  883:ldc2            #305 <String "East">
    //  427  886:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        m_UndoBut.setEnabled(false);
    //  428  889:aload_0         
    //  429  890:getfield        #106 <Field JButton m_UndoBut>
    //  430  893:iconst_0        
    //  431  894:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_EditBut.setEnabled(false);
    //  432  897:aload_0         
    //  433  898:getfield        #110 <Field JButton m_EditBut>
    //  434  901:iconst_0        
    //  435  902:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_SaveBut.setEnabled(false);
    //  436  905:aload_0         
    //  437  906:getfield        #114 <Field JButton m_SaveBut>
    //  438  909:iconst_0        
    //  439  910:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        JPanel buttons = new JPanel();
    //  440  913:new             #4   <Class JPanel>
    //  441  916:dup             
    //  442  917:invokespecial   #77  <Method void JPanel()>
    //  443  920:astore          6
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
    //  444  922:aload           6
    //  445  924:bipush          10
    //  446  926:iconst_5        
    //  447  927:bipush          10
    //  448  929:iconst_5        
    //  449  930:invokestatic    #249 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  450  933:invokevirtual   #235 <Method void JPanel.setBorder(javax.swing.border.Border)>
        buttons.setLayout(new GridLayout(1, 5, 5, 5));
    //  451  936:aload           6
    //  452  938:new             #307 <Class GridLayout>
    //  453  941:dup             
    //  454  942:iconst_1        
    //  455  943:iconst_5        
    //  456  944:iconst_5        
    //  457  945:iconst_5        
    //  458  946:invokespecial   #310 <Method void GridLayout(int, int, int, int)>
    //  459  949:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        buttons.add(m_OpenFileBut);
    //  460  952:aload           6
    //  461  954:aload_0         
    //  462  955:getfield        #98  <Field JButton m_OpenFileBut>
    //  463  958:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  464  961:pop             
        buttons.add(m_GenerateBut);
    //  465  962:aload           6
    //  466  964:aload_0         
    //  467  965:getfield        #102 <Field JButton m_GenerateBut>
    //  468  968:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  469  971:pop             
        buttons.add(m_UndoBut);
    //  470  972:aload           6
    //  471  974:aload_0         
    //  472  975:getfield        #106 <Field JButton m_UndoBut>
    //  473  978:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  474  981:pop             
        buttons.add(m_EditBut);
    //  475  982:aload           6
    //  476  984:aload_0         
    //  477  985:getfield        #110 <Field JButton m_EditBut>
    //  478  988:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  479  991:pop             
        buttons.add(m_SaveBut);
    //  480  992:aload           6
    //  481  994:aload_0         
    //  482  995:getfield        #114 <Field JButton m_SaveBut>
    //  483  998:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  484 1001:pop             
        m_OpenFileBut.addActionListener(new action());
    //  485 1002:aload_0         
    //  486 1003:getfield        #98  <Field JButton m_OpenFileBut>
    //  487 1006:new             #312 <Class PreprocessPanel$action>
    //  488 1009:dup             
    //  489 1010:aload_0         
    //  490 1011:invokespecial   #313 <Method void PreprocessPanel$action(PreprocessPanel)>
    //  491 1014:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        m_EditBut.addActionListener(new action());
    //  492 1017:aload_0         
    //  493 1018:getfield        #110 <Field JButton m_EditBut>
    //  494 1021:new             #312 <Class PreprocessPanel$action>
    //  495 1024:dup             
    //  496 1025:aload_0         
    //  497 1026:invokespecial   #313 <Method void PreprocessPanel$action(PreprocessPanel)>
    //  498 1029:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        m_GenerateBut.addActionListener(new action());
    //  499 1032:aload_0         
    //  500 1033:getfield        #102 <Field JButton m_GenerateBut>
    //  501 1036:new             #312 <Class PreprocessPanel$action>
    //  502 1039:dup             
    //  503 1040:aload_0         
    //  504 1041:invokespecial   #313 <Method void PreprocessPanel$action(PreprocessPanel)>
    //  505 1044:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        m_SaveBut.addActionListener(new action());
    //  506 1047:aload_0         
    //  507 1048:getfield        #114 <Field JButton m_SaveBut>
    //  508 1051:new             #312 <Class PreprocessPanel$action>
    //  509 1054:dup             
    //  510 1055:aload_0         
    //  511 1056:invokespecial   #313 <Method void PreprocessPanel$action(PreprocessPanel)>
    //  512 1059:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        m_UndoBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                undo();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PreprocessPanel this$0>
            //    2    4:invokevirtual   #27  <Method void PreprocessPanel.undo()>
            //    3    7:return          
            }

            final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  513 1062:aload_0         
    //  514 1063:getfield        #106 <Field JButton m_UndoBut>
    //  515 1066:new             #315 <Class PreprocessPanel$4>
    //  516 1069:dup             
    //  517 1070:aload_0         
    //  518 1071:invokespecial   #316 <Method void PreprocessPanel$4(PreprocessPanel)>
    //  519 1074:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        setViewPanel();
    //  520 1077:aload_0         
    //  521 1078:invokespecial   #319 <Method void setViewPanel()>
        JPanel middle = new JPanel();
    //  522 1081:new             #4   <Class JPanel>
    //  523 1084:dup             
    //  524 1085:invokespecial   #77  <Method void JPanel()>
    //  525 1088:astore          7
        middle.setLayout(new BorderLayout());
    //  526 1090:aload           7
    //  527 1092:new             #237 <Class BorderLayout>
    //  528 1095:dup             
    //  529 1096:invokespecial   #238 <Method void BorderLayout()>
    //  530 1099:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        middle.add(Dimensions, "North");
    //  531 1102:aload           7
    //  532 1104:aload_1         
    //  533 1105:ldc2            #321 <String "North">
    //  534 1108:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        middle.add(relation, "Center");
    //  535 1111:aload           7
    //  536 1113:aload_0         
    //  537 1114:getfield        #194 <Field JPanel relation>
    //  538 1117:ldc2            #323 <String "Center">
    //  539 1120:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        setLayout(new BorderLayout());
    //  540 1123:aload_0         
    //  541 1124:new             #237 <Class BorderLayout>
    //  542 1127:dup             
    //  543 1128:invokespecial   #238 <Method void BorderLayout()>
    //  544 1131:invokevirtual   #324 <Method void setLayout(java.awt.LayoutManager)>
        add(buttons, "North");
    //  545 1134:aload_0         
    //  546 1135:aload           6
    //  547 1137:ldc2            #321 <String "North">
    //  548 1140:invokevirtual   #325 <Method void add(java.awt.Component, Object)>
        add(middle, "Center");
    //  549 1143:aload_0         
    //  550 1144:aload           7
    //  551 1146:ldc2            #323 <String "Center">
    //  552 1149:invokevirtual   #325 <Method void add(java.awt.Component, Object)>
    //  553 1152:return          
    }

    public JPanel getJPanel()
    {
        return this;
    //    0    0:aload_0         
    //    1    1:areturn         
    }

    private void setViewPanel()
    {
        m_InstSummaryPanel.setBorder(BorderFactory.createTitledBorder("Current dimension"));
    //    0    0:aload_0         
    //    1    1:getfield        #82  <Field InstancesSummaryPanel m_InstSummaryPanel>
    //    2    4:ldc2            #340 <String "Current dimension">
    //    3    7:invokestatic    #231 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //    4   10:invokevirtual   #341 <Method void InstancesSummaryPanel.setBorder(javax.swing.border.Border)>
        JPanel attStuffHolderPanel = new JPanel();
    //    5   13:new             #4   <Class JPanel>
    //    6   16:dup             
    //    7   17:invokespecial   #77  <Method void JPanel()>
    //    8   20:astore_1        
        attStuffHolderPanel.setBorder(BorderFactory.createTitledBorder("Attributes"));
    //    9   21:aload_1         
    //   10   22:ldc2            #343 <String "Attributes">
    //   11   25:invokestatic    #231 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   12   28:invokevirtual   #235 <Method void JPanel.setBorder(javax.swing.border.Border)>
        attStuffHolderPanel.setLayout(new BorderLayout());
    //   13   31:aload_1         
    //   14   32:new             #237 <Class BorderLayout>
    //   15   35:dup             
    //   16   36:invokespecial   #238 <Method void BorderLayout()>
    //   17   39:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        attStuffHolderPanel.add(m_AttPanel, "Center");
    //   18   42:aload_1         
    //   19   43:aload_0         
    //   20   44:getfield        #87  <Field AttributeSelectionPanel m_AttPanel>
    //   21   47:ldc2            #323 <String "Center">
    //   22   50:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        m_RemoveButton.setEnabled(false);
    //   23   53:aload_0         
    //   24   54:getfield        #182 <Field JButton m_RemoveButton>
    //   25   57:iconst_0        
    //   26   58:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_RemoveButton.setToolTipText("Remove selected attributes.");
    //   27   61:aload_0         
    //   28   62:getfield        #182 <Field JButton m_RemoveButton>
    //   29   65:ldc2            #345 <String "Remove selected attributes.">
    //   30   68:invokevirtual   #211 <Method void JButton.setToolTipText(String)>
        m_RemoveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(PreprocessPanel.count++ % 2 == 0)
            //*   0    0:getstatic       #28  <Field int PreprocessPanel.count>
            //*   1    3:dup             
            //*   2    4:iconst_1        
            //*   3    5:iadd            
            //*   4    6:putstatic       #28  <Field int PreprocessPanel.count>
            //*   5    9:iconst_2        
            //*   6   10:irem            
            //*   7   11:ifne            214
                    {
                        Remove r = new Remove();
            //    8   14:new             #30  <Class Remove>
            //    9   17:dup             
            //   10   18:invokespecial   #31  <Method void Remove()>
            //   11   21:astore_2        
                        int selected[] = m_AttPanel.getSelectedAttributes();
            //   12   22:aload_0         
            //   13   23:getfield        #13  <Field PreprocessPanel this$0>
            //   14   26:getfield        #35  <Field AttributeSelectionPanel PreprocessPanel.m_AttPanel>
            //   15   29:invokevirtual   #41  <Method int[] AttributeSelectionPanel.getSelectedAttributes()>
            //   16   32:astore_3        
                        if(selected.length == 0)
            //*  17   33:aload_3         
            //*  18   34:arraylength     
            //*  19   35:ifne            39
                            return;
            //   20   38:return          
                        if(selected.length == m_Instances.numAttributes())
            //*  21   39:aload_3         
            //*  22   40:arraylength     
            //*  23   41:aload_0         
            //*  24   42:getfield        #13  <Field PreprocessPanel this$0>
            //*  25   45:getfield        #45  <Field Instances PreprocessPanel.m_Instances>
            //*  26   48:invokevirtual   #51  <Method int Instances.numAttributes()>
            //*  27   51:icmpne          95
                        {
                            JOptionPane.showMessageDialog(PreprocessPanel.this, "Can't remove all attributes from data!\n", "Remove Attributes", 0);
            //   28   54:aload_0         
            //   29   55:getfield        #13  <Field PreprocessPanel this$0>
            //   30   58:ldc1            #53  <String "Can't remove all attributes from data!\n">
            //   31   60:ldc1            #55  <String "Remove Attributes">
            //   32   62:iconst_0        
            //   33   63:invokestatic    #61  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                            m_Log.logMessage("Can't remove all attributes from data!");
            //   34   66:aload_0         
            //   35   67:getfield        #13  <Field PreprocessPanel this$0>
            //   36   70:getfield        #65  <Field Logger PreprocessPanel.m_Log>
            //   37   73:ldc1            #67  <String "Can't remove all attributes from data!">
            //   38   75:invokeinterface #73  <Method void Logger.logMessage(String)>
                            m_Log.statusMessage("Problem removing attributes");
            //   39   80:aload_0         
            //   40   81:getfield        #13  <Field PreprocessPanel this$0>
            //   41   84:getfield        #65  <Field Logger PreprocessPanel.m_Log>
            //   42   87:ldc1            #75  <String "Problem removing attributes">
            //   43   89:invokeinterface #78  <Method void Logger.statusMessage(String)>
                            return;
            //   44   94:return          
                        }
                        r.setAttributeIndicesArray(selected);
            //   45   95:aload_2         
            //   46   96:aload_3         
            //   47   97:invokevirtual   #82  <Method void Remove.setAttributeIndicesArray(int[])>
                        applyFilter(r);
            //   48  100:aload_0         
            //   49  101:getfield        #13  <Field PreprocessPanel this$0>
            //   50  104:aload_2         
            //   51  105:invokevirtual   #86  <Method void PreprocessPanel.applyFilter(Filter)>
                    }
                }
            //*  52  108:goto            214
                catch(Exception ex)
            //*  53  111:astore_2        
                {
                    if(m_Log instanceof TaskLogger)
            //*  54  112:aload_0         
            //*  55  113:getfield        #13  <Field PreprocessPanel this$0>
            //*  56  116:getfield        #65  <Field Logger PreprocessPanel.m_Log>
            //*  57  119:instanceof      #88  <Class TaskLogger>
            //*  58  122:ifeq            140
                        ((TaskLogger)m_Log).taskFinished();
            //   59  125:aload_0         
            //   60  126:getfield        #13  <Field PreprocessPanel this$0>
            //   61  129:getfield        #65  <Field Logger PreprocessPanel.m_Log>
            //   62  132:checkcast       #88  <Class TaskLogger>
            //   63  135:invokeinterface #91  <Method void TaskLogger.taskFinished()>
                    JOptionPane.showMessageDialog(PreprocessPanel.this, (new StringBuilder("Problem filtering instances:\n")).append(ex.getMessage()).toString(), "Remove Attributes", 0);
            //   64  140:aload_0         
            //   65  141:getfield        #13  <Field PreprocessPanel this$0>
            //   66  144:new             #93  <Class StringBuilder>
            //   67  147:dup             
            //   68  148:ldc1            #95  <String "Problem filtering instances:\n">
            //   69  150:invokespecial   #97  <Method void StringBuilder(String)>
            //   70  153:aload_2         
            //   71  154:invokevirtual   #103 <Method String Exception.getMessage()>
            //   72  157:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
            //   73  160:invokevirtual   #110 <Method String StringBuilder.toString()>
            //   74  163:ldc1            #55  <String "Remove Attributes">
            //   75  165:iconst_0        
            //   76  166:invokestatic    #61  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                    m_Log.logMessage((new StringBuilder("Problem removing attributes: ")).append(ex.getMessage()).toString());
            //   77  169:aload_0         
            //   78  170:getfield        #13  <Field PreprocessPanel this$0>
            //   79  173:getfield        #65  <Field Logger PreprocessPanel.m_Log>
            //   80  176:new             #93  <Class StringBuilder>
            //   81  179:dup             
            //   82  180:ldc1            #112 <String "Problem removing attributes: ">
            //   83  182:invokespecial   #97  <Method void StringBuilder(String)>
            //   84  185:aload_2         
            //   85  186:invokevirtual   #103 <Method String Exception.getMessage()>
            //   86  189:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
            //   87  192:invokevirtual   #110 <Method String StringBuilder.toString()>
            //   88  195:invokeinterface #73  <Method void Logger.logMessage(String)>
                    m_Log.statusMessage("Problem removing attributes");
            //   89  200:aload_0         
            //   90  201:getfield        #13  <Field PreprocessPanel this$0>
            //   91  204:getfield        #65  <Field Logger PreprocessPanel.m_Log>
            //   92  207:ldc1            #75  <String "Problem removing attributes">
            //   93  209:invokeinterface #78  <Method void Logger.statusMessage(String)>
                }
            //   94  214:return          
            }

            final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   31   71:aload_0         
    //   32   72:getfield        #182 <Field JButton m_RemoveButton>
    //   33   75:new             #347 <Class PreprocessPanel$5>
    //   34   78:dup             
    //   35   79:aload_0         
    //   36   80:invokespecial   #348 <Method void PreprocessPanel$5(PreprocessPanel)>
    //   37   83:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        m_AttPanel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e)
            {
                if(!e.getValueIsAdjusting())
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #28  <Method boolean ListSelectionEvent.getValueIsAdjusting()>
            //*   2    4:ifne            69
                {
                    ListSelectionModel lm = (ListSelectionModel)e.getSource();
            //    3    7:aload_1         
            //    4    8:invokevirtual   #32  <Method Object ListSelectionEvent.getSource()>
            //    5   11:checkcast       #34  <Class ListSelectionModel>
            //    6   14:astore_2        
                    for(int i = e.getFirstIndex(); i <= e.getLastIndex(); i++)
            //*   7   15:aload_1         
            //*   8   16:invokevirtual   #38  <Method int ListSelectionEvent.getFirstIndex()>
            //*   9   19:istore_3        
            //*  10   20:goto            61
                    {
                        if(!lm.isSelectedIndex(i))
                            continue;
            //   11   23:aload_2         
            //   12   24:iload_3         
            //   13   25:invokeinterface #42  <Method boolean ListSelectionModel.isSelectedIndex(int)>
            //   14   30:ifeq            58
                        m_AttSummaryPanel.setAttribute(i);
            //   15   33:aload_0         
            //   16   34:getfield        #13  <Field PreprocessPanel this$0>
            //   17   37:getfield        #48  <Field AttributeSummaryPanel PreprocessPanel.m_AttSummaryPanel>
            //   18   40:iload_3         
            //   19   41:invokevirtual   #54  <Method void AttributeSummaryPanel.setAttribute(int)>
                        m_AttVisualizePanel.setAttribute(i);
            //   20   44:aload_0         
            //   21   45:getfield        #13  <Field PreprocessPanel this$0>
            //   22   48:getfield        #58  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
            //   23   51:iload_3         
            //   24   52:invokevirtual   #61  <Method void AttributeVisualizationPanel.setAttribute(int)>
                        break;
            //   25   55:goto            69
                    }

            //   26   58:iinc            3  1
            //   27   61:iload_3         
            //   28   62:aload_1         
            //   29   63:invokevirtual   #64  <Method int ListSelectionEvent.getLastIndex()>
            //   30   66:icmple          23
                }
            //   31   69:return          
            }

            final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   38   86:aload_0         
    //   39   87:getfield        #87  <Field AttributeSelectionPanel m_AttPanel>
    //   40   90:invokevirtual   #352 <Method ListSelectionModel AttributeSelectionPanel.getSelectionModel()>
    //   41   93:new             #354 <Class PreprocessPanel$6>
    //   42   96:dup             
    //   43   97:aload_0         
    //   44   98:invokespecial   #355 <Method void PreprocessPanel$6(PreprocessPanel)>
    //   45  101:invokeinterface #361 <Method void ListSelectionModel.addListSelectionListener(ListSelectionListener)>
        JPanel p1 = new JPanel();
    //   46  106:new             #4   <Class JPanel>
    //   47  109:dup             
    //   48  110:invokespecial   #77  <Method void JPanel()>
    //   49  113:astore_2        
        p1.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
    //   50  114:aload_2         
    //   51  115:bipush          10
    //   52  117:iconst_5        
    //   53  118:bipush          10
    //   54  120:iconst_5        
    //   55  121:invokestatic    #249 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   56  124:invokevirtual   #235 <Method void JPanel.setBorder(javax.swing.border.Border)>
        p1.setLayout(new BorderLayout());
    //   57  127:aload_2         
    //   58  128:new             #237 <Class BorderLayout>
    //   59  131:dup             
    //   60  132:invokespecial   #238 <Method void BorderLayout()>
    //   61  135:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        attStuffHolderPanel.add(p1, "South");
    //   62  138:aload_1         
    //   63  139:aload_2         
    //   64  140:ldc2            #363 <String "South">
    //   65  143:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        p1.add(m_RemoveButton, "Center");
    //   66  146:aload_2         
    //   67  147:aload_0         
    //   68  148:getfield        #182 <Field JButton m_RemoveButton>
    //   69  151:ldc2            #323 <String "Center">
    //   70  154:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        m_AttSummaryPanel.setBorder(BorderFactory.createTitledBorder("Selected attribute"));
    //   71  157:aload_0         
    //   72  158:getfield        #187 <Field AttributeSummaryPanel m_AttSummaryPanel>
    //   73  161:ldc2            #365 <String "Selected attribute">
    //   74  164:invokestatic    #231 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   75  167:invokevirtual   #366 <Method void AttributeSummaryPanel.setBorder(javax.swing.border.Border)>
        JPanel attInfo = new JPanel();
    //   76  170:new             #4   <Class JPanel>
    //   77  173:dup             
    //   78  174:invokespecial   #77  <Method void JPanel()>
    //   79  177:astore_3        
        attInfo.setLayout(new BorderLayout());
    //   80  178:aload_3         
    //   81  179:new             #237 <Class BorderLayout>
    //   82  182:dup             
    //   83  183:invokespecial   #238 <Method void BorderLayout()>
    //   84  186:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        attInfo.add(attStuffHolderPanel, "Center");
    //   85  189:aload_3         
    //   86  190:aload_1         
    //   87  191:ldc2            #323 <String "Center">
    //   88  194:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        JPanel attVis = new JPanel();
    //   89  197:new             #4   <Class JPanel>
    //   90  200:dup             
    //   91  201:invokespecial   #77  <Method void JPanel()>
    //   92  204:astore          4
        attVis.setLayout(new GridLayout(2, 1));
    //   93  206:aload           4
    //   94  208:new             #307 <Class GridLayout>
    //   95  211:dup             
    //   96  212:iconst_2        
    //   97  213:iconst_1        
    //   98  214:invokespecial   #369 <Method void GridLayout(int, int)>
    //   99  217:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        attVis.add(m_AttSummaryPanel);
    //  100  220:aload           4
    //  101  222:aload_0         
    //  102  223:getfield        #187 <Field AttributeSummaryPanel m_AttSummaryPanel>
    //  103  226:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  104  229:pop             
        JComboBox colorBox = m_AttVisualizePanel.getColorBox();
    //  105  230:aload_0         
    //  106  231:getfield        #192 <Field AttributeVisualizationPanel m_AttVisualizePanel>
    //  107  234:invokevirtual   #373 <Method JComboBox AttributeVisualizationPanel.getColorBox()>
    //  108  237:astore          5
        colorBox.setToolTipText("The chosen attribute will also be used as the class attribute when a filter is applied.");
    //  109  239:aload           5
    //  110  241:ldc2            #375 <String "The chosen attribute will also be used as the class attribute when a filter is applied.">
    //  111  244:invokevirtual   #378 <Method void JComboBox.setToolTipText(String)>
        final JButton visAllBut = new JButton("Visualize All");
    //  112  247:new             #91  <Class JButton>
    //  113  250:dup             
    //  114  251:ldc2            #380 <String "Visualize All">
    //  115  254:invokespecial   #96  <Method void JButton(String)>
    //  116  257:astore          6
        visAllBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae)
            {
                if(m_Instances != null)
            //*   0    0:aload_0         
            //*   1    1:getfield        #15  <Field PreprocessPanel this$0>
            //*   2    4:getfield        #32  <Field Instances PreprocessPanel.m_Instances>
            //*   3    7:ifnull          115
                    try
                    {
                        AttributeSummarizer as = new AttributeSummarizer();
            //    4   10:new             #34  <Class AttributeSummarizer>
            //    5   13:dup             
            //    6   14:invokespecial   #35  <Method void AttributeSummarizer()>
            //    7   17:astore_2        
                        as.setColoringIndex(m_AttVisualizePanel.getColoringIndex());
            //    8   18:aload_2         
            //    9   19:aload_0         
            //   10   20:getfield        #15  <Field PreprocessPanel this$0>
            //   11   23:getfield        #39  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
            //   12   26:invokevirtual   #45  <Method int AttributeVisualizationPanel.getColoringIndex()>
            //   13   29:invokevirtual   #49  <Method void AttributeSummarizer.setColoringIndex(int)>
                        as.setInstances(m_Instances);
            //   14   32:aload_2         
            //   15   33:aload_0         
            //   16   34:getfield        #15  <Field PreprocessPanel this$0>
            //   17   37:getfield        #32  <Field Instances PreprocessPanel.m_Instances>
            //   18   40:invokevirtual   #53  <Method void AttributeSummarizer.setInstances(Instances)>
                        final JFrame jf = new JFrame();
            //   19   43:new             #55  <Class JFrame>
            //   20   46:dup             
            //   21   47:invokespecial   #56  <Method void JFrame()>
            //   22   50:astore_3        
                        jf.getContentPane().setLayout(new BorderLayout());
            //   23   51:aload_3         
            //   24   52:invokevirtual   #60  <Method Container JFrame.getContentPane()>
            //   25   55:new             #62  <Class BorderLayout>
            //   26   58:dup             
            //   27   59:invokespecial   #63  <Method void BorderLayout()>
            //   28   62:invokevirtual   #69  <Method void Container.setLayout(java.awt.LayoutManager)>
                        jf.getContentPane().add(as, "Center");
            //   29   65:aload_3         
            //   30   66:invokevirtual   #60  <Method Container JFrame.getContentPane()>
            //   31   69:aload_2         
            //   32   70:ldc1            #71  <String "Center">
            //   33   72:invokevirtual   #75  <Method void Container.add(java.awt.Component, Object)>
                        jf.addWindowListener(new WindowAdapter() {

                            public void windowClosing(WindowEvent e)
                            {
                                visAllBut.setEnabled(true);
                            //    0    0:aload_0         
                            //    1    1:getfield        #17  <Field JButton val$visAllBut>
                            //    2    4:iconst_1        
                            //    3    5:invokevirtual   #34  <Method void JButton.setEnabled(boolean)>
                                jf.dispose();
                            //    4    8:aload_0         
                            //    5    9:getfield        #19  <Field JFrame val$jf>
                            //    6   12:invokevirtual   #39  <Method void JFrame.dispose()>
                            //    7   15:return          
                            }

                            final _cls7 this$1;
                            private final JButton val$visAllBut;
                            private final JFrame val$jf;

                    
                    {
                        this$1 = _cls7.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #15  <Field PreprocessPanel$7 this$1>
                        visAllBut = jbutton;
                    //    3    5:aload_0         
                    //    4    6:aload_2         
                    //    5    7:putfield        #17  <Field JButton val$visAllBut>
                        jf = jframe;
                    //    6   10:aload_0         
                    //    7   11:aload_3         
                    //    8   12:putfield        #19  <Field JFrame val$jf>
                        super();
                    //    9   15:aload_0         
                    //   10   16:invokespecial   #22  <Method void WindowAdapter()>
                    //   11   19:return          
                    }
                        }
);
            //   34   75:aload_3         
            //   35   76:new             #77  <Class PreprocessPanel$8>
            //   36   79:dup             
            //   37   80:aload_0         
            //   38   81:aload_0         
            //   39   82:getfield        #17  <Field JButton val$visAllBut>
            //   40   85:aload_3         
            //   41   86:invokespecial   #80  <Method void PreprocessPanel$8(PreprocessPanel$7, JButton, JFrame)>
            //   42   89:invokevirtual   #84  <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
                        jf.setSize(800, 600);
            //   43   92:aload_3         
            //   44   93:sipush          800
            //   45   96:sipush          600
            //   46   99:invokevirtual   #88  <Method void JFrame.setSize(int, int)>
                        jf.setVisible(true);
            //   47  102:aload_3         
            //   48  103:iconst_1        
            //   49  104:invokevirtual   #92  <Method void JFrame.setVisible(boolean)>
                    }
            //*  50  107:goto            115
                    catch(Exception ex)
            //*  51  110:astore_2        
                    {
                        ex.printStackTrace();
            //   52  111:aload_2         
            //   53  112:invokevirtual   #97  <Method void Exception.printStackTrace()>
                    }
            //   54  115:return          
            }

            final PreprocessPanel this$0;
            private final JButton val$visAllBut;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field PreprocessPanel this$0>
                visAllBut = jbutton;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field JButton val$visAllBut>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
        }
);
    //  117  259:aload           6
    //  118  261:new             #382 <Class PreprocessPanel$7>
    //  119  264:dup             
    //  120  265:aload_0         
    //  121  266:aload           6
    //  122  268:invokespecial   #385 <Method void PreprocessPanel$7(PreprocessPanel, JButton)>
    //  123  271:invokevirtual   #292 <Method void JButton.addActionListener(ActionListener)>
        JPanel histoHolder = new JPanel();
    //  124  274:new             #4   <Class JPanel>
    //  125  277:dup             
    //  126  278:invokespecial   #77  <Method void JPanel()>
    //  127  281:astore          7
        histoHolder.setLayout(new BorderLayout());
    //  128  283:aload           7
    //  129  285:new             #237 <Class BorderLayout>
    //  130  288:dup             
    //  131  289:invokespecial   #238 <Method void BorderLayout()>
    //  132  292:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        histoHolder.add(m_AttVisualizePanel, "Center");
    //  133  295:aload           7
    //  134  297:aload_0         
    //  135  298:getfield        #192 <Field AttributeVisualizationPanel m_AttVisualizePanel>
    //  136  301:ldc2            #323 <String "Center">
    //  137  304:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        JPanel histoControls = new JPanel();
    //  138  307:new             #4   <Class JPanel>
    //  139  310:dup             
    //  140  311:invokespecial   #77  <Method void JPanel()>
    //  141  314:astore          8
        histoControls.setLayout(new BorderLayout());
    //  142  316:aload           8
    //  143  318:new             #237 <Class BorderLayout>
    //  144  321:dup             
    //  145  322:invokespecial   #238 <Method void BorderLayout()>
    //  146  325:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        histoControls.add(colorBox, "Center");
    //  147  328:aload           8
    //  148  330:aload           5
    //  149  332:ldc2            #323 <String "Center">
    //  150  335:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        histoControls.add(visAllBut, "East");
    //  151  338:aload           8
    //  152  340:aload           6
    //  153  342:ldc2            #305 <String "East">
    //  154  345:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        histoHolder.add(histoControls, "North");
    //  155  348:aload           7
    //  156  350:aload           8
    //  157  352:ldc2            #321 <String "North">
    //  158  355:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        attVis.add(histoHolder);
    //  159  358:aload           4
    //  160  360:aload           7
    //  161  362:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  162  365:pop             
        JPanel lhs = new JPanel();
    //  163  366:new             #4   <Class JPanel>
    //  164  369:dup             
    //  165  370:invokespecial   #77  <Method void JPanel()>
    //  166  373:astore          9
        lhs.setLayout(new BorderLayout());
    //  167  375:aload           9
    //  168  377:new             #237 <Class BorderLayout>
    //  169  380:dup             
    //  170  381:invokespecial   #238 <Method void BorderLayout()>
    //  171  384:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        lhs.add(m_InstSummaryPanel, "North");
    //  172  387:aload           9
    //  173  389:aload_0         
    //  174  390:getfield        #82  <Field InstancesSummaryPanel m_InstSummaryPanel>
    //  175  393:ldc2            #321 <String "North">
    //  176  396:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        lhs.add(attInfo, "Center");
    //  177  399:aload           9
    //  178  401:aload_3         
    //  179  402:ldc2            #323 <String "Center">
    //  180  405:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        JPanel rhs = new JPanel();
    //  181  408:new             #4   <Class JPanel>
    //  182  411:dup             
    //  183  412:invokespecial   #77  <Method void JPanel()>
    //  184  415:astore          10
        rhs.setLayout(new BorderLayout());
    //  185  417:aload           10
    //  186  419:new             #237 <Class BorderLayout>
    //  187  422:dup             
    //  188  423:invokespecial   #238 <Method void BorderLayout()>
    //  189  426:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        rhs.add(attVis, "Center");
    //  190  429:aload           10
    //  191  431:aload           4
    //  192  433:ldc2            #323 <String "Center">
    //  193  436:invokevirtual   #303 <Method void JPanel.add(java.awt.Component, Object)>
        relation.removeAll();
    //  194  439:aload_0         
    //  195  440:getfield        #194 <Field JPanel relation>
    //  196  443:invokevirtual   #388 <Method void JPanel.removeAll()>
        relation.setLayout(new GridLayout(1, 2));
    //  197  446:aload_0         
    //  198  447:getfield        #194 <Field JPanel relation>
    //  199  450:new             #307 <Class GridLayout>
    //  200  453:dup             
    //  201  454:iconst_1        
    //  202  455:iconst_2        
    //  203  456:invokespecial   #369 <Method void GridLayout(int, int)>
    //  204  459:invokevirtual   #242 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        relation.add(lhs);
    //  205  462:aload_0         
    //  206  463:getfield        #194 <Field JPanel relation>
    //  207  466:aload           9
    //  208  468:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  209  471:pop             
        relation.add(rhs);
    //  210  472:aload_0         
    //  211  473:getfield        #194 <Field JPanel relation>
    //  212  476:aload           10
    //  213  478:invokevirtual   #273 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  214  481:pop             
    //  215  482:return          
    }

    private void openFile()
    {
        m_FileChooser.setDialogTitle("Load Assignment File.");
    //    0    0:aload_0         
    //    1    1:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //    2    4:ldc2            #402 <String "Load Assignment File.">
    //    3    7:invokevirtual   #405 <Method void ConverterFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //    4   10:aload_0         
    //    5   11:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //    6   14:new             #158 <Class File>
    //    7   17:dup             
    //    8   18:ldc2            #407 <String "user.dir">
    //    9   21:invokestatic    #413 <Method String System.getProperty(String)>
    //   10   24:invokespecial   #165 <Method void File(String)>
    //   11   27:invokevirtual   #416 <Method void ConverterFileChooser.setCurrentDirectory(File)>
        try
        {
            Fileflag = m_FileChooser.showOpenDialog(this);
    //   12   30:aload_0         
    //   13   31:aload_0         
    //   14   32:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //   15   35:aload_0         
    //   16   36:invokevirtual   #420 <Method int ConverterFileChooser.showOpenDialog(java.awt.Component)>
    //   17   39:putfield        #422 <Field int Fileflag>
        }
    //*  18   42:goto            58
        catch(HeadlessException head)
    //*  19   45:astore_1        
        {
            m_Log.logMessage("Open File Dialog ERROR!");
    //   20   46:aload_0         
    //   21   47:getfield        #199 <Field Logger m_Log>
    //   22   50:ldc2            #424 <String "Open File Dialog ERROR!">
    //   23   53:invokeinterface #429 <Method void Logger.logMessage(String)>
        }
        if(Fileflag == 0)
    //*  24   58:aload_0         
    //*  25   59:getfield        #422 <Field int Fileflag>
    //*  26   62:ifne            176
        {
            SelectedFile = m_FileChooser.getSelectedFile();
    //   27   65:aload_0         
    //   28   66:aload_0         
    //   29   67:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //   30   70:invokevirtual   #433 <Method File ConverterFileChooser.getSelectedFile()>
    //   31   73:putfield        #172 <Field File SelectedFile>
            try
            {
                if(SelectedFile != null)
    //*  32   76:aload_0         
    //*  33   77:getfield        #172 <Field File SelectedFile>
    //*  34   80:ifnull          176
                {
                    AssData = new AssLoader(new FileReader(SelectedFile));
    //   35   83:aload_0         
    //   36   84:new             #435 <Class AssLoader>
    //   37   87:dup             
    //   38   88:new             #437 <Class FileReader>
    //   39   91:dup             
    //   40   92:aload_0         
    //   41   93:getfield        #172 <Field File SelectedFile>
    //   42   96:invokespecial   #438 <Method void FileReader(File)>
    //   43   99:invokespecial   #441 <Method void AssLoader(FileReader)>
    //   44  102:putfield        #174 <Field AssLoader AssData>
                    m_assignment = AssData.getData();
    //   45  105:aload_0         
    //   46  106:aload_0         
    //   47  107:getfield        #174 <Field AssLoader AssData>
    //   48  110:invokevirtual   #445 <Method Assignment AssLoader.getData()>
    //   49  113:putfield        #176 <Field Assignment m_assignment>
                    m_Log.statusMessage("Open an Assignment File");
    //   50  116:aload_0         
    //   51  117:getfield        #199 <Field Logger m_Log>
    //   52  120:ldc2            #447 <String "Open an Assignment File">
    //   53  123:invokeinterface #450 <Method void Logger.statusMessage(String)>
                    m_Log.logMessage((new StringBuilder("Load the assignment file: ")).append(SelectedFile.getName()).toString());
    //   54  128:aload_0         
    //   55  129:getfield        #199 <Field Logger m_Log>
    //   56  132:new             #452 <Class StringBuilder>
    //   57  135:dup             
    //   58  136:ldc2            #454 <String "Load the assignment file: ">
    //   59  139:invokespecial   #455 <Method void StringBuilder(String)>
    //   60  142:aload_0         
    //   61  143:getfield        #172 <Field File SelectedFile>
    //   62  146:invokevirtual   #458 <Method String File.getName()>
    //   63  149:invokevirtual   #462 <Method StringBuilder StringBuilder.append(String)>
    //   64  152:invokevirtual   #465 <Method String StringBuilder.toString()>
    //   65  155:invokeinterface #429 <Method void Logger.logMessage(String)>
                    setAssignmentInfor(m_assignment);
    //   66  160:aload_0         
    //   67  161:aload_0         
    //   68  162:getfield        #176 <Field Assignment m_assignment>
    //   69  165:invokevirtual   #469 <Method void setAssignmentInfor(Assignment)>
                }
            }
    //*  70  168:goto            176
            catch(Exception e)
    //*  71  171:astore_1        
            {
                e.printStackTrace();
    //   72  172:aload_1         
    //   73  173:invokevirtual   #474 <Method void Exception.printStackTrace()>
            }
        }
        m_EditBut.setEnabled(true);
    //   74  176:aload_0         
    //   75  177:getfield        #110 <Field JButton m_EditBut>
    //   76  180:iconst_1        
    //   77  181:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
    //   78  184:return          
    }

    protected void applyFilter(final Filter filter)
    {
        if(m_IOThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #484 <Field Thread m_IOThread>
    //*   2    4:ifnonnull       38
        {
            m_IOThread = new Thread() {

                public void run()
                {
                    try
                    {
                        if(filter != null)
                //*   0    0:aload_0         
                //*   1    1:getfield        #15  <Field Filter val$filter>
                //*   2    4:ifnull          468
                        {
                            if(m_Log instanceof TaskLogger)
                //*   3    7:aload_0         
                //*   4    8:getfield        #13  <Field PreprocessPanel this$0>
                //*   5   11:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //*   6   14:instanceof      #31  <Class TaskLogger>
                //*   7   17:ifeq            35
                                ((TaskLogger)m_Log).taskStarted();
                //    8   20:aload_0         
                //    9   21:getfield        #13  <Field PreprocessPanel this$0>
                //   10   24:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //   11   27:checkcast       #31  <Class TaskLogger>
                //   12   30:invokeinterface #34  <Method void TaskLogger.taskStarted()>
                            m_Log.statusMessage((new StringBuilder("Passing dataset through filter ")).append(filter.getClass().getName()).toString());
                //   13   35:aload_0         
                //   14   36:getfield        #13  <Field PreprocessPanel this$0>
                //   15   39:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //   16   42:new             #36  <Class StringBuilder>
                //   17   45:dup             
                //   18   46:ldc1            #38  <String "Passing dataset through filter ">
                //   19   48:invokespecial   #41  <Method void StringBuilder(String)>
                //   20   51:aload_0         
                //   21   52:getfield        #15  <Field Filter val$filter>
                //   22   55:invokevirtual   #47  <Method Class Object.getClass()>
                //   23   58:invokevirtual   #53  <Method String Class.getName()>
                //   24   61:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
                //   25   64:invokevirtual   #60  <Method String StringBuilder.toString()>
                //   26   67:invokeinterface #65  <Method void Logger.statusMessage(String)>
                            String cmd = filter.getClass().getName();
                //   27   72:aload_0         
                //   28   73:getfield        #15  <Field Filter val$filter>
                //   29   76:invokevirtual   #47  <Method Class Object.getClass()>
                //   30   79:invokevirtual   #53  <Method String Class.getName()>
                //   31   82:astore_1        
                            if(filter instanceof OptionHandler)
                //*  32   83:aload_0         
                //*  33   84:getfield        #15  <Field Filter val$filter>
                //*  34   87:instanceof      #67  <Class OptionHandler>
                //*  35   90:ifeq            131
                                cmd = (new StringBuilder(String.valueOf(cmd))).append(" ").append(Utils.joinOptions(((OptionHandler)filter).getOptions())).toString();
                //   36   93:new             #36  <Class StringBuilder>
                //   37   96:dup             
                //   38   97:aload_1         
                //   39   98:invokestatic    #73  <Method String String.valueOf(Object)>
                //   40  101:invokespecial   #41  <Method void StringBuilder(String)>
                //   41  104:ldc1            #75  <String " ">
                //   42  106:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
                //   43  109:aload_0         
                //   44  110:getfield        #15  <Field Filter val$filter>
                //   45  113:checkcast       #67  <Class OptionHandler>
                //   46  116:invokeinterface #79  <Method String[] OptionHandler.getOptions()>
                //   47  121:invokestatic    #85  <Method String Utils.joinOptions(String[])>
                //   48  124:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
                //   49  127:invokevirtual   #60  <Method String StringBuilder.toString()>
                //   50  130:astore_1        
                            m_Log.logMessage((new StringBuilder("Command: ")).append(cmd).toString());
                //   51  131:aload_0         
                //   52  132:getfield        #13  <Field PreprocessPanel this$0>
                //   53  135:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //   54  138:new             #36  <Class StringBuilder>
                //   55  141:dup             
                //   56  142:ldc1            #87  <String "Command: ">
                //   57  144:invokespecial   #41  <Method void StringBuilder(String)>
                //   58  147:aload_1         
                //   59  148:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
                //   60  151:invokevirtual   #60  <Method String StringBuilder.toString()>
                //   61  154:invokeinterface #90  <Method void Logger.logMessage(String)>
                            int classIndex = m_AttVisualizePanel.getColoringIndex();
                //   62  159:aload_0         
                //   63  160:getfield        #13  <Field PreprocessPanel this$0>
                //   64  163:getfield        #94  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
                //   65  166:invokevirtual   #100 <Method int AttributeVisualizationPanel.getColoringIndex()>
                //   66  169:istore_2        
                            if(classIndex < 0 && (filter instanceof SupervisedFilter))
                //*  67  170:iload_2         
                //*  68  171:ifge            194
                //*  69  174:aload_0         
                //*  70  175:getfield        #15  <Field Filter val$filter>
                //*  71  178:instanceof      #102 <Class SupervisedFilter>
                //*  72  181:ifeq            194
                                throw new IllegalArgumentException("Class (colour) needs to be set for supervised filter.");
                //   73  184:new             #104 <Class IllegalArgumentException>
                //   74  187:dup             
                //   75  188:ldc1            #106 <String "Class (colour) needs to be set for supervised filter.">
                //   76  190:invokespecial   #107 <Method void IllegalArgumentException(String)>
                //   77  193:athrow          
                            Instances copy = new Instances(m_Instances);
                //   78  194:new             #109 <Class Instances>
                //   79  197:dup             
                //   80  198:aload_0         
                //   81  199:getfield        #13  <Field PreprocessPanel this$0>
                //   82  202:getfield        #113 <Field Instances PreprocessPanel.m_Instances>
                //   83  205:invokespecial   #116 <Method void Instances(Instances)>
                //   84  208:astore_3        
                            copy.setClassIndex(classIndex);
                //   85  209:aload_3         
                //   86  210:iload_2         
                //   87  211:invokevirtual   #120 <Method void Instances.setClassIndex(int)>
                            filter.setInputFormat(copy);
                //   88  214:aload_0         
                //   89  215:getfield        #15  <Field Filter val$filter>
                //   90  218:aload_3         
                //   91  219:invokevirtual   #126 <Method boolean Filter.setInputFormat(Instances)>
                //   92  222:pop             
                            Instances newInstances = Filter.useFilter(copy, filter);
                //   93  223:aload_3         
                //   94  224:aload_0         
                //   95  225:getfield        #15  <Field Filter val$filter>
                //   96  228:invokestatic    #130 <Method Instances Filter.useFilter(Instances, Filter)>
                //   97  231:astore          4
                            if(newInstances == null || newInstances.numAttributes() < 1)
                //*  98  233:aload           4
                //*  99  235:ifnull          247
                //* 100  238:aload           4
                //* 101  240:invokevirtual   #133 <Method int Instances.numAttributes()>
                //* 102  243:iconst_1        
                //* 103  244:icmpge          257
                                throw new Exception("Dataset is empty.");
                //  104  247:new             #135 <Class Exception>
                //  105  250:dup             
                //  106  251:ldc1            #137 <String "Dataset is empty.">
                //  107  253:invokespecial   #138 <Method void Exception(String)>
                //  108  256:athrow          
                            m_Log.statusMessage("Saving undo information");
                //  109  257:aload_0         
                //  110  258:getfield        #13  <Field PreprocessPanel this$0>
                //  111  261:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //  112  264:ldc1            #140 <String "Saving undo information">
                //  113  266:invokeinterface #65  <Method void Logger.statusMessage(String)>
                            addUndoPoint();
                //  114  271:aload_0         
                //  115  272:getfield        #13  <Field PreprocessPanel this$0>
                //  116  275:invokevirtual   #143 <Method void PreprocessPanel.addUndoPoint()>
                            m_AttVisualizePanel.setColoringIndex(copy.classIndex());
                //  117  278:aload_0         
                //  118  279:getfield        #13  <Field PreprocessPanel this$0>
                //  119  282:getfield        #94  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
                //  120  285:aload_3         
                //  121  286:invokevirtual   #146 <Method int Instances.classIndex()>
                //  122  289:invokevirtual   #149 <Method void AttributeVisualizationPanel.setColoringIndex(int)>
                            if(m_Instances.classIndex() < 0)
                //* 123  292:aload_0         
                //* 124  293:getfield        #13  <Field PreprocessPanel this$0>
                //* 125  296:getfield        #113 <Field Instances PreprocessPanel.m_Instances>
                //* 126  299:invokevirtual   #146 <Method int Instances.classIndex()>
                //* 127  302:ifge            311
                                newInstances.setClassIndex(-1);
                //  128  305:aload           4
                //  129  307:iconst_m1       
                //  130  308:invokevirtual   #120 <Method void Instances.setClassIndex(int)>
                            m_Instances = newInstances;
                //  131  311:aload_0         
                //  132  312:getfield        #13  <Field PreprocessPanel this$0>
                //  133  315:aload           4
                //  134  317:putfield        #113 <Field Instances PreprocessPanel.m_Instances>
                            setInstances(m_Instances);
                //  135  320:aload_0         
                //  136  321:getfield        #13  <Field PreprocessPanel this$0>
                //  137  324:aload_0         
                //  138  325:getfield        #13  <Field PreprocessPanel this$0>
                //  139  328:getfield        #113 <Field Instances PreprocessPanel.m_Instances>
                //  140  331:invokevirtual   #152 <Method void PreprocessPanel.setInstances(Instances)>
                            if(m_Log instanceof TaskLogger)
                //* 141  334:aload_0         
                //* 142  335:getfield        #13  <Field PreprocessPanel this$0>
                //* 143  338:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //* 144  341:instanceof      #31  <Class TaskLogger>
                //* 145  344:ifeq            468
                                ((TaskLogger)m_Log).taskFinished();
                //  146  347:aload_0         
                //  147  348:getfield        #13  <Field PreprocessPanel this$0>
                //  148  351:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //  149  354:checkcast       #31  <Class TaskLogger>
                //  150  357:invokeinterface #155 <Method void TaskLogger.taskFinished()>
                        }
                    }
                //* 151  362:goto            468
                    catch(Exception ex)
                //* 152  365:astore_1        
                    {
                        if(m_Log instanceof TaskLogger)
                //* 153  366:aload_0         
                //* 154  367:getfield        #13  <Field PreprocessPanel this$0>
                //* 155  370:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //* 156  373:instanceof      #31  <Class TaskLogger>
                //* 157  376:ifeq            394
                            ((TaskLogger)m_Log).taskFinished();
                //  158  379:aload_0         
                //  159  380:getfield        #13  <Field PreprocessPanel this$0>
                //  160  383:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //  161  386:checkcast       #31  <Class TaskLogger>
                //  162  389:invokeinterface #155 <Method void TaskLogger.taskFinished()>
                        JOptionPane.showMessageDialog(PreprocessPanel.this, (new StringBuilder("Problem filtering instances:\n")).append(ex.getMessage()).toString(), "Apply Filter", 0);
                //  163  394:aload_0         
                //  164  395:getfield        #13  <Field PreprocessPanel this$0>
                //  165  398:new             #36  <Class StringBuilder>
                //  166  401:dup             
                //  167  402:ldc1            #157 <String "Problem filtering instances:\n">
                //  168  404:invokespecial   #41  <Method void StringBuilder(String)>
                //  169  407:aload_1         
                //  170  408:invokevirtual   #160 <Method String Exception.getMessage()>
                //  171  411:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
                //  172  414:invokevirtual   #60  <Method String StringBuilder.toString()>
                //  173  417:ldc1            #162 <String "Apply Filter">
                //  174  419:iconst_0        
                //  175  420:invokestatic    #168 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                        m_Log.logMessage((new StringBuilder("Problem filtering instances: ")).append(ex.getMessage()).toString());
                //  176  423:aload_0         
                //  177  424:getfield        #13  <Field PreprocessPanel this$0>
                //  178  427:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //  179  430:new             #36  <Class StringBuilder>
                //  180  433:dup             
                //  181  434:ldc1            #170 <String "Problem filtering instances: ">
                //  182  436:invokespecial   #41  <Method void StringBuilder(String)>
                //  183  439:aload_1         
                //  184  440:invokevirtual   #160 <Method String Exception.getMessage()>
                //  185  443:invokevirtual   #57  <Method StringBuilder StringBuilder.append(String)>
                //  186  446:invokevirtual   #60  <Method String StringBuilder.toString()>
                //  187  449:invokeinterface #90  <Method void Logger.logMessage(String)>
                        m_Log.statusMessage("Problem filtering instances");
                //  188  454:aload_0         
                //  189  455:getfield        #13  <Field PreprocessPanel this$0>
                //  190  458:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //  191  461:ldc1            #172 <String "Problem filtering instances">
                //  192  463:invokeinterface #65  <Method void Logger.statusMessage(String)>
                    }
                    m_IOThread = null;
                //  193  468:aload_0         
                //  194  469:getfield        #13  <Field PreprocessPanel this$0>
                //  195  472:aconst_null     
                //  196  473:putfield        #176 <Field Thread PreprocessPanel.m_IOThread>
                //  197  476:return          
                }

                final PreprocessPanel this$0;
                private final Filter val$filter;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                filter = filter1;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field Filter val$filter>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void Thread()>
            //    8   14:return          
            }
            }
;
    //    3    7:aload_0         
    //    4    8:new             #486 <Class PreprocessPanel$9>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:invokespecial   #489 <Method void PreprocessPanel$9(PreprocessPanel, Filter)>
    //    9   17:putfield        #484 <Field Thread m_IOThread>
            m_IOThread.setPriority(1);
    //   10   20:aload_0         
    //   11   21:getfield        #484 <Field Thread m_IOThread>
    //   12   24:iconst_1        
    //   13   25:invokevirtual   #494 <Method void Thread.setPriority(int)>
            m_IOThread.start();
    //   14   28:aload_0         
    //   15   29:getfield        #484 <Field Thread m_IOThread>
    //   16   32:invokevirtual   #497 <Method void Thread.start()>
        } else
    //*  17   35:goto            49
        {
            JOptionPane.showMessageDialog(this, "Can't apply filter at this time,\ncurrently busy with other IO", "Apply Filter", 2);
    //   18   38:aload_0         
    //   19   39:ldc2            #499 <String "Can't apply filter at this time,\ncurrently busy with other IO">
    //   20   42:ldc2            #501 <String "Apply Filter">
    //   21   45:iconst_2        
    //   22   46:invokestatic    #507 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   23   49:return          
    }

    public void addUndoPoint()
        throws Exception
    {
        if(m_Instances != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #513 <Field Instances m_Instances>
    //*   2    4:ifnull          127
        {
            File tempFile = File.createTempFile("weka", SerializedInstancesLoader.FILE_EXTENSION);
    //    3    7:ldc2            #515 <String "weka">
    //    4   10:getstatic       #520 <Field String SerializedInstancesLoader.FILE_EXTENSION>
    //    5   13:invokestatic    #524 <Method File File.createTempFile(String, String)>
    //    6   16:astore_1        
            tempFile.deleteOnExit();
    //    7   17:aload_1         
    //    8   18:invokevirtual   #527 <Method void File.deleteOnExit()>
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(tempFile)));
    //    9   21:new             #529 <Class ObjectOutputStream>
    //   10   24:dup             
    //   11   25:new             #531 <Class BufferedOutputStream>
    //   12   28:dup             
    //   13   29:new             #533 <Class FileOutputStream>
    //   14   32:dup             
    //   15   33:aload_1         
    //   16   34:invokespecial   #534 <Method void FileOutputStream(File)>
    //   17   37:invokespecial   #537 <Method void BufferedOutputStream(java.io.OutputStream)>
    //   18   40:invokespecial   #538 <Method void ObjectOutputStream(java.io.OutputStream)>
    //   19   43:astore_2        
            oos.writeObject(m_Instances);
    //   20   44:aload_2         
    //   21   45:aload_0         
    //   22   46:getfield        #513 <Field Instances m_Instances>
    //   23   49:invokevirtual   #542 <Method void ObjectOutputStream.writeObject(Object)>
            oos.flush();
    //   24   52:aload_2         
    //   25   53:invokevirtual   #545 <Method void ObjectOutputStream.flush()>
            oos.close();
    //   26   56:aload_2         
    //   27   57:invokevirtual   #548 <Method void ObjectOutputStream.close()>
            if(m_tempUndoFiles[m_tempUndoIndex] != null)
    //*  28   60:aload_0         
    //*  29   61:getfield        #206 <Field File[] m_tempUndoFiles>
    //*  30   64:aload_0         
    //*  31   65:getfield        #89  <Field int m_tempUndoIndex>
    //*  32   68:aaload          
    //*  33   69:ifnull          85
                m_tempUndoFiles[m_tempUndoIndex].delete();
    //   34   72:aload_0         
    //   35   73:getfield        #206 <Field File[] m_tempUndoFiles>
    //   36   76:aload_0         
    //   37   77:getfield        #89  <Field int m_tempUndoIndex>
    //   38   80:aaload          
    //   39   81:invokevirtual   #552 <Method boolean File.delete()>
    //   40   84:pop             
            m_tempUndoFiles[m_tempUndoIndex] = tempFile;
    //   41   85:aload_0         
    //   42   86:getfield        #206 <Field File[] m_tempUndoFiles>
    //   43   89:aload_0         
    //   44   90:getfield        #89  <Field int m_tempUndoIndex>
    //   45   93:aload_1         
    //   46   94:aastore         
            if(++m_tempUndoIndex >= m_tempUndoFiles.length)
    //*  47   95:aload_0         
    //*  48   96:dup             
    //*  49   97:getfield        #89  <Field int m_tempUndoIndex>
    //*  50  100:iconst_1        
    //*  51  101:iadd            
    //*  52  102:dup_x1          
    //*  53  103:putfield        #89  <Field int m_tempUndoIndex>
    //*  54  106:aload_0         
    //*  55  107:getfield        #206 <Field File[] m_tempUndoFiles>
    //*  56  110:arraylength     
    //*  57  111:icmplt          119
                m_tempUndoIndex = 0;
    //   58  114:aload_0         
    //   59  115:iconst_0        
    //   60  116:putfield        #89  <Field int m_tempUndoIndex>
            m_UndoBut.setEnabled(true);
    //   61  119:aload_0         
    //   62  120:getfield        #106 <Field JButton m_UndoBut>
    //   63  123:iconst_1        
    //   64  124:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        }
    //   65  127:return          
    }

    public void setInstancesFromFile(final AbstractFileLoader loader)
    {
        if(m_IOThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #484 <Field Thread m_IOThread>
    //*   2    4:ifnonnull       38
        {
            m_IOThread = new Thread() {

                public void run()
                {
                    try
                    {
                        m_Log.statusMessage("Reading from file...");
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field PreprocessPanel this$0>
                //    2    4:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //    3    7:ldc1            #31  <String "Reading from file...">
                //    4    9:invokeinterface #37  <Method void Logger.statusMessage(String)>
                        Instances inst = loader.getDataSet();
                //    5   14:aload_0         
                //    6   15:getfield        #15  <Field AbstractFileLoader val$loader>
                //    7   18:invokevirtual   #43  <Method Instances AbstractFileLoader.getDataSet()>
                //    8   21:astore_1        
                        setInstances(inst);
                //    9   22:aload_0         
                //   10   23:getfield        #13  <Field PreprocessPanel this$0>
                //   11   26:aload_1         
                //   12   27:invokevirtual   #47  <Method void PreprocessPanel.setInstances(Instances)>
                    }
                //*  13   30:goto            195
                    catch(Exception ex)
                //*  14   33:astore_1        
                    {
                        m_Log.statusMessage((new StringBuilder("File '")).append(loader.retrieveFile()).append("' not recognised as an '").append(loader.getFileDescription()).append("' file.").toString());
                //   15   34:aload_0         
                //   16   35:getfield        #13  <Field PreprocessPanel this$0>
                //   17   38:getfield        #29  <Field Logger PreprocessPanel.m_Log>
                //   18   41:new             #49  <Class StringBuilder>
                //   19   44:dup             
                //   20   45:ldc1            #51  <String "File '">
                //   21   47:invokespecial   #53  <Method void StringBuilder(String)>
                //   22   50:aload_0         
                //   23   51:getfield        #15  <Field AbstractFileLoader val$loader>
                //   24   54:invokevirtual   #57  <Method File AbstractFileLoader.retrieveFile()>
                //   25   57:invokevirtual   #61  <Method StringBuilder StringBuilder.append(Object)>
                //   26   60:ldc1            #63  <String "' not recognised as an '">
                //   27   62:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //   28   65:aload_0         
                //   29   66:getfield        #15  <Field AbstractFileLoader val$loader>
                //   30   69:invokevirtual   #70  <Method String AbstractFileLoader.getFileDescription()>
                //   31   72:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //   32   75:ldc1            #72  <String "' file.">
                //   33   77:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //   34   80:invokevirtual   #75  <Method String StringBuilder.toString()>
                //   35   83:invokeinterface #37  <Method void Logger.statusMessage(String)>
                        m_IOThread = null;
                //   36   88:aload_0         
                //   37   89:getfield        #13  <Field PreprocessPanel this$0>
                //   38   92:aconst_null     
                //   39   93:putfield        #79  <Field Thread PreprocessPanel.m_IOThread>
                        if(JOptionPane.showOptionDialog(PreprocessPanel.this, (new StringBuilder("File '")).append(loader.retrieveFile()).append("' not recognised as an '").append(loader.getFileDescription()).append("' file.\n").append("Reason:\n").append(ex.getMessage()).toString(), "Load Instances", 0, 0, null, new String[] {
                "OK", "Use Converter"
            }, null) == 1)
                //*  40   96:aload_0         
                //*  41   97:getfield        #13  <Field PreprocessPanel this$0>
                //*  42  100:new             #49  <Class StringBuilder>
                //*  43  103:dup             
                //*  44  104:ldc1            #51  <String "File '">
                //*  45  106:invokespecial   #53  <Method void StringBuilder(String)>
                //*  46  109:aload_0         
                //*  47  110:getfield        #15  <Field AbstractFileLoader val$loader>
                //*  48  113:invokevirtual   #57  <Method File AbstractFileLoader.retrieveFile()>
                //*  49  116:invokevirtual   #61  <Method StringBuilder StringBuilder.append(Object)>
                //*  50  119:ldc1            #63  <String "' not recognised as an '">
                //*  51  121:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //*  52  124:aload_0         
                //*  53  125:getfield        #15  <Field AbstractFileLoader val$loader>
                //*  54  128:invokevirtual   #70  <Method String AbstractFileLoader.getFileDescription()>
                //*  55  131:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //*  56  134:ldc1            #81  <String "' file.\n">
                //*  57  136:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //*  58  139:ldc1            #83  <String "Reason:\n">
                //*  59  141:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //*  60  144:aload_1         
                //*  61  145:invokevirtual   #88  <Method String Exception.getMessage()>
                //*  62  148:invokevirtual   #66  <Method StringBuilder StringBuilder.append(String)>
                //*  63  151:invokevirtual   #75  <Method String StringBuilder.toString()>
                //*  64  154:ldc1            #90  <String "Load Instances">
                //*  65  156:iconst_0        
                //*  66  157:iconst_0        
                //*  67  158:aconst_null     
                //*  68  159:iconst_2        
                //*  69  160:anewarray       String[]
                //*  70  163:dup             
                //*  71  164:iconst_0        
                //*  72  165:ldc1            #94  <String "OK">
                //*  73  167:aastore         
                //*  74  168:dup             
                //*  75  169:iconst_1        
                //*  76  170:ldc1            #96  <String "Use Converter">
                //*  77  172:aastore         
                //*  78  173:aconst_null     
                //*  79  174:invokestatic    #102 <Method int JOptionPane.showOptionDialog(java.awt.Component, Object, String, int, int, javax.swing.Icon, Object[], Object)>
                //*  80  177:iconst_1        
                //*  81  178:icmpne          195
                            converterQuery(loader.retrieveFile());
                //   82  181:aload_0         
                //   83  182:getfield        #13  <Field PreprocessPanel this$0>
                //   84  185:aload_0         
                //   85  186:getfield        #15  <Field AbstractFileLoader val$loader>
                //   86  189:invokevirtual   #57  <Method File AbstractFileLoader.retrieveFile()>
                //   87  192:invokestatic    #106 <Method void PreprocessPanel.access$4(PreprocessPanel, File)>
                    }
                    m_IOThread = null;
                //   88  195:aload_0         
                //   89  196:getfield        #13  <Field PreprocessPanel this$0>
                //   90  199:aconst_null     
                //   91  200:putfield        #79  <Field Thread PreprocessPanel.m_IOThread>
                //   92  203:return          
                }

                final PreprocessPanel this$0;
                private final AbstractFileLoader val$loader;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                loader = abstractfileloader;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #15  <Field AbstractFileLoader val$loader>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #18  <Method void Thread()>
            //    8   14:return          
            }
            }
;
    //    3    7:aload_0         
    //    4    8:new             #559 <Class PreprocessPanel$10>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:invokespecial   #562 <Method void PreprocessPanel$10(PreprocessPanel, AbstractFileLoader)>
    //    9   17:putfield        #484 <Field Thread m_IOThread>
            m_IOThread.setPriority(1);
    //   10   20:aload_0         
    //   11   21:getfield        #484 <Field Thread m_IOThread>
    //   12   24:iconst_1        
    //   13   25:invokevirtual   #494 <Method void Thread.setPriority(int)>
            m_IOThread.start();
    //   14   28:aload_0         
    //   15   29:getfield        #484 <Field Thread m_IOThread>
    //   16   32:invokevirtual   #497 <Method void Thread.start()>
        } else
    //*  17   35:goto            49
        {
            JOptionPane.showMessageDialog(this, "Can't load at this time,\ncurrently busy with other IO", "Load Instances", 2);
    //   18   38:aload_0         
    //   19   39:ldc2            #564 <String "Can't load at this time,\ncurrently busy with other IO">
    //   20   42:ldc2            #566 <String "Load Instances">
    //   21   45:iconst_2        
    //   22   46:invokestatic    #507 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   23   49:return          
    }

    private void tryConverter(final Loader cnv, final File f)
    {
        if(m_IOThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #484 <Field Thread m_IOThread>
    //*   2    4:ifnonnull       36
        {
            m_IOThread = new Thread() {

                public void run()
                {
                    try
                    {
                        cnv.setSource(f);
                //    0    0:aload_0         
                //    1    1:getfield        #17  <Field Loader val$cnv>
                //    2    4:aload_0         
                //    3    5:getfield        #19  <Field File val$f>
                //    4    8:invokeinterface #33  <Method void Loader.setSource(File)>
                        Instances inst = cnv.getDataSet();
                //    5   13:aload_0         
                //    6   14:getfield        #17  <Field Loader val$cnv>
                //    7   17:invokeinterface #37  <Method Instances Loader.getDataSet()>
                //    8   22:astore_1        
                        setInstances(inst);
                //    9   23:aload_0         
                //   10   24:getfield        #15  <Field PreprocessPanel this$0>
                //   11   27:aload_1         
                //   12   28:invokevirtual   #43  <Method void PreprocessPanel.setInstances(Instances)>
                    }
                //*  13   31:goto            169
                    catch(Exception ex)
                //*  14   34:astore_1        
                    {
                        m_Log.statusMessage((new StringBuilder(String.valueOf(cnv.getClass().getName()))).append(" failed to load ").append(f.getName()).toString());
                //   15   35:aload_0         
                //   16   36:getfield        #15  <Field PreprocessPanel this$0>
                //   17   39:getfield        #47  <Field Logger PreprocessPanel.m_Log>
                //   18   42:new             #49  <Class StringBuilder>
                //   19   45:dup             
                //   20   46:aload_0         
                //   21   47:getfield        #17  <Field Loader val$cnv>
                //   22   50:invokevirtual   #55  <Method Class Object.getClass()>
                //   23   53:invokevirtual   #61  <Method String Class.getName()>
                //   24   56:invokestatic    #67  <Method String String.valueOf(Object)>
                //   25   59:invokespecial   #70  <Method void StringBuilder(String)>
                //   26   62:ldc1            #72  <String " failed to load ">
                //   27   64:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   28   67:aload_0         
                //   29   68:getfield        #19  <Field File val$f>
                //   30   71:invokevirtual   #79  <Method String File.getName()>
                //   31   74:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   32   77:invokevirtual   #82  <Method String StringBuilder.toString()>
                //   33   80:invokeinterface #87  <Method void Logger.statusMessage(String)>
                        JOptionPane.showMessageDialog(PreprocessPanel.this, (new StringBuilder(String.valueOf(cnv.getClass().getName()))).append(" failed to load '").append(f.getName()).append("'.\n").append("Reason:\n").append(ex.getMessage()).toString(), "Convert File", 0);
                //   34   85:aload_0         
                //   35   86:getfield        #15  <Field PreprocessPanel this$0>
                //   36   89:new             #49  <Class StringBuilder>
                //   37   92:dup             
                //   38   93:aload_0         
                //   39   94:getfield        #17  <Field Loader val$cnv>
                //   40   97:invokevirtual   #55  <Method Class Object.getClass()>
                //   41  100:invokevirtual   #61  <Method String Class.getName()>
                //   42  103:invokestatic    #67  <Method String String.valueOf(Object)>
                //   43  106:invokespecial   #70  <Method void StringBuilder(String)>
                //   44  109:ldc1            #89  <String " failed to load '">
                //   45  111:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   46  114:aload_0         
                //   47  115:getfield        #19  <Field File val$f>
                //   48  118:invokevirtual   #79  <Method String File.getName()>
                //   49  121:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   50  124:ldc1            #91  <String "'.\n">
                //   51  126:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   52  129:ldc1            #93  <String "Reason:\n">
                //   53  131:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   54  134:aload_1         
                //   55  135:invokevirtual   #98  <Method String Exception.getMessage()>
                //   56  138:invokevirtual   #76  <Method StringBuilder StringBuilder.append(String)>
                //   57  141:invokevirtual   #82  <Method String StringBuilder.toString()>
                //   58  144:ldc1            #100 <String "Convert File">
                //   59  146:iconst_0        
                //   60  147:invokestatic    #106 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                        m_IOThread = null;
                //   61  150:aload_0         
                //   62  151:getfield        #15  <Field PreprocessPanel this$0>
                //   63  154:aconst_null     
                //   64  155:putfield        #110 <Field Thread PreprocessPanel.m_IOThread>
                        converterQuery(f);
                //   65  158:aload_0         
                //   66  159:getfield        #15  <Field PreprocessPanel this$0>
                //   67  162:aload_0         
                //   68  163:getfield        #19  <Field File val$f>
                //   69  166:invokestatic    #114 <Method void PreprocessPanel.access$4(PreprocessPanel, File)>
                    }
                    m_IOThread = null;
                //   70  169:aload_0         
                //   71  170:getfield        #15  <Field PreprocessPanel this$0>
                //   72  173:aconst_null     
                //   73  174:putfield        #110 <Field Thread PreprocessPanel.m_IOThread>
                //   74  177:return          
                }

                final PreprocessPanel this$0;
                private final Loader val$cnv;
                private final File val$f;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field PreprocessPanel this$0>
                cnv = loader;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field Loader val$cnv>
                f = file;
            //    6   10:aload_0         
            //    7   11:aload_3         
            //    8   12:putfield        #19  <Field File val$f>
                super();
            //    9   15:aload_0         
            //   10   16:invokespecial   #22  <Method void Thread()>
            //   11   19:return          
            }
            }
;
    //    3    7:aload_0         
    //    4    8:new             #572 <Class PreprocessPanel$11>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:aload_2         
    //    9   15:invokespecial   #575 <Method void PreprocessPanel$11(PreprocessPanel, Loader, File)>
    //   10   18:putfield        #484 <Field Thread m_IOThread>
            m_IOThread.setPriority(1);
    //   11   21:aload_0         
    //   12   22:getfield        #484 <Field Thread m_IOThread>
    //   13   25:iconst_1        
    //   14   26:invokevirtual   #494 <Method void Thread.setPriority(int)>
            m_IOThread.start();
    //   15   29:aload_0         
    //   16   30:getfield        #484 <Field Thread m_IOThread>
    //   17   33:invokevirtual   #497 <Method void Thread.start()>
        }
    //   18   36:return          
    }

    private void converterQuery(final File f)
    {
        final GenericObjectEditor convEd = new GenericObjectEditor(true);
    //    0    0:new             #201 <Class GenericObjectEditor>
    //    1    3:dup             
    //    2    4:iconst_1        
    //    3    5:invokespecial   #581 <Method void GenericObjectEditor(boolean)>
    //    4    8:astore_2        
        try
        {
            convEd.setClassType(rm/core/converters/Loader);
    //    5    9:aload_2         
    //    6   10:ldc2            #583 <Class Loader>
    //    7   13:invokevirtual   #587 <Method void GenericObjectEditor.setClassType(Class)>
            convEd.setValue(new CSVLoader());
    //    8   16:aload_2         
    //    9   17:new             #589 <Class CSVLoader>
    //   10   20:dup             
    //   11   21:invokespecial   #590 <Method void CSVLoader()>
    //   12   24:invokevirtual   #593 <Method void GenericObjectEditor.setValue(Object)>
            ((rm.gui.GenericObjectEditor.GOEPanel)convEd.getCustomEditor()).addOkListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    tryConverter((Loader)convEd.getValue(), f);
                //    0    0:aload_0         
                //    1    1:getfield        #17  <Field PreprocessPanel this$0>
                //    2    4:aload_0         
                //    3    5:getfield        #19  <Field GenericObjectEditor val$convEd>
                //    4    8:invokevirtual   #36  <Method Object GenericObjectEditor.getValue()>
                //    5   11:checkcast       #38  <Class Loader>
                //    6   14:aload_0         
                //    7   15:getfield        #21  <Field File val$f>
                //    8   18:invokestatic    #44  <Method void PreprocessPanel.access$5(PreprocessPanel, Loader, File)>
                //    9   21:return          
                }

                final PreprocessPanel this$0;
                private final GenericObjectEditor val$convEd;
                private final File val$f;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #17  <Field PreprocessPanel this$0>
                convEd = genericobjecteditor;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #19  <Field GenericObjectEditor val$convEd>
                f = file;
            //    6   10:aload_0         
            //    7   11:aload_3         
            //    8   12:putfield        #21  <Field File val$f>
                super();
            //    9   15:aload_0         
            //   10   16:invokespecial   #24  <Method void Object()>
            //   11   19:return          
            }
            }
);
    //   13   27:aload_2         
    //   14   28:invokevirtual   #597 <Method java.awt.Component GenericObjectEditor.getCustomEditor()>
    //   15   31:checkcast       #599 <Class rm.gui.GenericObjectEditor$GOEPanel>
    //   16   34:new             #601 <Class PreprocessPanel$12>
    //   17   37:dup             
    //   18   38:aload_0         
    //   19   39:aload_2         
    //   20   40:aload_1         
    //   21   41:invokespecial   #604 <Method void PreprocessPanel$12(PreprocessPanel, GenericObjectEditor, File)>
    //   22   44:invokevirtual   #607 <Method void rm.gui.GenericObjectEditor$GOEPanel.addOkListener(ActionListener)>
        }
    //*  23   47:goto            51
        catch(Exception exception) { }
    //   24   50:astore_3        
        PropertyDialog pd;
        if(PropertyDialog.getParentDialog(this) != null)
    //*  25   51:aload_0         
    //*  26   52:invokestatic    #613 <Method java.awt.Dialog PropertyDialog.getParentDialog(Container)>
    //*  27   55:ifnull          78
            pd = new PropertyDialog(PropertyDialog.getParentDialog(this), convEd, 100, 100);
    //   28   58:new             #609 <Class PropertyDialog>
    //   29   61:dup             
    //   30   62:aload_0         
    //   31   63:invokestatic    #613 <Method java.awt.Dialog PropertyDialog.getParentDialog(Container)>
    //   32   66:aload_2         
    //   33   67:bipush          100
    //   34   69:bipush          100
    //   35   71:invokespecial   #616 <Method void PropertyDialog(java.awt.Dialog, java.beans.PropertyEditor, int, int)>
    //   36   74:astore_3        
        else
    //*  37   75:goto            95
            pd = new PropertyDialog(PropertyDialog.getParentFrame(this), convEd, 100, 100);
    //   38   78:new             #609 <Class PropertyDialog>
    //   39   81:dup             
    //   40   82:aload_0         
    //   41   83:invokestatic    #620 <Method java.awt.Frame PropertyDialog.getParentFrame(Container)>
    //   42   86:aload_2         
    //   43   87:bipush          100
    //   44   89:bipush          100
    //   45   91:invokespecial   #623 <Method void PropertyDialog(java.awt.Frame, java.beans.PropertyEditor, int, int)>
    //   46   94:astore_3        
        pd.setVisible(true);
    //   47   95:aload_3         
    //   48   96:iconst_1        
    //   49   97:invokevirtual   #626 <Method void PropertyDialog.setVisible(boolean)>
    //   50  100:return          
    }

    public void undo()
    {
        if(--m_tempUndoIndex < 0)
    //*   0    0:aload_0         
    //*   1    1:dup             
    //*   2    2:getfield        #89  <Field int m_tempUndoIndex>
    //*   3    5:iconst_1        
    //*   4    6:isub            
    //*   5    7:dup_x1          
    //*   6    8:putfield        #89  <Field int m_tempUndoIndex>
    //*   7   11:ifge            25
            m_tempUndoIndex = m_tempUndoFiles.length - 1;
    //    8   14:aload_0         
    //    9   15:aload_0         
    //   10   16:getfield        #206 <Field File[] m_tempUndoFiles>
    //   11   19:arraylength     
    //   12   20:iconst_1        
    //   13   21:isub            
    //   14   22:putfield        #89  <Field int m_tempUndoIndex>
        if(m_tempUndoFiles[m_tempUndoIndex] != null)
    //*  15   25:aload_0         
    //*  16   26:getfield        #206 <Field File[] m_tempUndoFiles>
    //*  17   29:aload_0         
    //*  18   30:getfield        #89  <Field int m_tempUndoIndex>
    //*  19   33:aaload          
    //*  20   34:ifnull          126
        {
            AbstractFileLoader loader = ConverterUtils.getLoaderForFile(m_tempUndoFiles[m_tempUndoIndex]);
    //   21   37:aload_0         
    //   22   38:getfield        #206 <Field File[] m_tempUndoFiles>
    //   23   41:aload_0         
    //   24   42:getfield        #89  <Field int m_tempUndoIndex>
    //   25   45:aaload          
    //   26   46:invokestatic    #636 <Method AbstractFileLoader ConverterUtils.getLoaderForFile(File)>
    //   27   49:astore_1        
            try
            {
                loader.setFile(m_tempUndoFiles[m_tempUndoIndex]);
    //   28   50:aload_1         
    //   29   51:aload_0         
    //   30   52:getfield        #206 <Field File[] m_tempUndoFiles>
    //   31   55:aload_0         
    //   32   56:getfield        #89  <Field int m_tempUndoIndex>
    //   33   59:aaload          
    //   34   60:invokevirtual   #641 <Method void AbstractFileLoader.setFile(File)>
                setInstancesFromFile(loader);
    //   35   63:aload_0         
    //   36   64:aload_1         
    //   37   65:invokevirtual   #643 <Method void setInstancesFromFile(AbstractFileLoader)>
            }
    //*  38   68:goto            116
            catch(Exception e)
    //*  39   71:astore_2        
            {
                e.printStackTrace();
    //   40   72:aload_2         
    //   41   73:invokevirtual   #474 <Method void Exception.printStackTrace()>
                m_Log.logMessage(e.toString());
    //   42   76:aload_0         
    //   43   77:getfield        #199 <Field Logger m_Log>
    //   44   80:aload_2         
    //   45   81:invokevirtual   #644 <Method String Exception.toString()>
    //   46   84:invokeinterface #429 <Method void Logger.logMessage(String)>
                JOptionPane.showMessageDialog(this, (new StringBuilder("Cannot perform undo operation!\n")).append(e.toString()).toString(), "Undo", 0);
    //   47   89:aload_0         
    //   48   90:new             #452 <Class StringBuilder>
    //   49   93:dup             
    //   50   94:ldc2            #646 <String "Cannot perform undo operation!\n">
    //   51   97:invokespecial   #455 <Method void StringBuilder(String)>
    //   52  100:aload_2         
    //   53  101:invokevirtual   #644 <Method String Exception.toString()>
    //   54  104:invokevirtual   #462 <Method StringBuilder StringBuilder.append(String)>
    //   55  107:invokevirtual   #465 <Method String StringBuilder.toString()>
    //   56  110:ldc1            #104 <String "Undo">
    //   57  112:iconst_0        
    //   58  113:invokestatic    #507 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
            }
            m_tempUndoFiles[m_tempUndoIndex] = null;
    //   59  116:aload_0         
    //   60  117:getfield        #206 <Field File[] m_tempUndoFiles>
    //   61  120:aload_0         
    //   62  121:getfield        #89  <Field int m_tempUndoIndex>
    //   63  124:aconst_null     
    //   64  125:aastore         
        }
        int temp = m_tempUndoIndex - 1;
    //   65  126:aload_0         
    //   66  127:getfield        #89  <Field int m_tempUndoIndex>
    //   67  130:iconst_1        
    //   68  131:isub            
    //   69  132:istore_1        
        if(temp < 0)
    //*  70  133:iload_1         
    //*  71  134:ifge            145
            temp = m_tempUndoFiles.length - 1;
    //   72  137:aload_0         
    //   73  138:getfield        #206 <Field File[] m_tempUndoFiles>
    //   74  141:arraylength     
    //   75  142:iconst_1        
    //   76  143:isub            
    //   77  144:istore_1        
        m_UndoBut.setEnabled(m_tempUndoFiles[temp] != null);
    //   78  145:aload_0         
    //   79  146:getfield        #106 <Field JButton m_UndoBut>
    //   80  149:aload_0         
    //   81  150:getfield        #206 <Field File[] m_tempUndoFiles>
    //   82  153:iload_1         
    //   83  154:aaload          
    //   84  155:ifnull          162
    //   85  158:iconst_1        
    //   86  159:goto            163
    //   87  162:iconst_0        
    //   88  163:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
    //   89  166:return          
    }

    private void saveWorkingAssignment()
    {
        if(m_IOThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #484 <Field Thread m_IOThread>
    //*   2    4:ifnonnull       112
        {
            m_Log.statusMessage("Saving to file...");
    //    3    7:aload_0         
    //    4    8:getfield        #199 <Field Logger m_Log>
    //    5   11:ldc2            #650 <String "Saving to file...">
    //    6   14:invokeinterface #450 <Method void Logger.statusMessage(String)>
            m_FileChooser.setDialogTitle("Save Assignment File");
    //    7   19:aload_0         
    //    8   20:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //    9   23:ldc2            #652 <String "Save Assignment File">
    //   10   26:invokevirtual   #405 <Method void ConverterFileChooser.setDialogTitle(String)>
            m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //   11   29:aload_0         
    //   12   30:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //   13   33:new             #158 <Class File>
    //   14   36:dup             
    //   15   37:ldc2            #407 <String "user.dir">
    //   16   40:invokestatic    #413 <Method String System.getProperty(String)>
    //   17   43:invokespecial   #165 <Method void File(String)>
    //   18   46:invokevirtual   #416 <Method void ConverterFileChooser.setCurrentDirectory(File)>
            int returnVal = m_FileChooser.showSaveDialog(this);
    //   19   49:aload_0         
    //   20   50:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //   21   53:aload_0         
    //   22   54:invokevirtual   #655 <Method int ConverterFileChooser.showSaveDialog(java.awt.Component)>
    //   23   57:istore_1        
            if(returnVal == 0)
    //*  24   58:iload_1         
    //*  25   59:ifne            123
            {
                Assignment newAssignment = new Assignment(m_assignment);
    //   26   62:new             #657 <Class Assignment>
    //   27   65:dup             
    //   28   66:aload_0         
    //   29   67:getfield        #176 <Field Assignment m_assignment>
    //   30   70:invokespecial   #659 <Method void Assignment(Assignment)>
    //   31   73:astore_2        
                try
                {
                    FileWriter fw = new FileWriter(m_FileChooser.getSelectedFile());
    //   32   74:new             #661 <Class FileWriter>
    //   33   77:dup             
    //   34   78:aload_0         
    //   35   79:getfield        #170 <Field ConverterFileChooser m_FileChooser>
    //   36   82:invokevirtual   #433 <Method File ConverterFileChooser.getSelectedFile()>
    //   37   85:invokespecial   #662 <Method void FileWriter(File)>
    //   38   88:astore_3        
                    fw.write(newAssignment.toString());
    //   39   89:aload_3         
    //   40   90:aload_2         
    //   41   91:invokevirtual   #663 <Method String Assignment.toString()>
    //   42   94:invokevirtual   #666 <Method void FileWriter.write(String)>
                    fw.close();
    //   43   97:aload_3         
    //   44   98:invokevirtual   #667 <Method void FileWriter.close()>
                }
    //*  45  101:goto            123
                catch(Exception e)
    //*  46  104:astore_3        
                {
                    e.printStackTrace();
    //   47  105:aload_3         
    //   48  106:invokevirtual   #474 <Method void Exception.printStackTrace()>
                }
            }
        } else
    //*  49  109:goto            123
        {
            JOptionPane.showMessageDialog(this, "Can't save at this time,\ncurrently busy with other IO", "Saving assingment", 2);
    //   50  112:aload_0         
    //   51  113:ldc2            #669 <String "Can't save at this time,\ncurrently busy with other IO">
    //   52  116:ldc2            #671 <String "Saving assingment">
    //   53  119:iconst_2        
    //   54  120:invokestatic    #507 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   55  123:return          
    }

    private void openEditor(String filePath)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    //    0    0:invokestatic    #681 <Method String UIManager.getSystemLookAndFeelClassName()>
    //    1    3:invokestatic    #684 <Method void UIManager.setLookAndFeel(String)>
        }
    //*   2    6:goto            33
        catch(Exception e)
    //*   3    9:astore_2        
        {
            System.err.println((new StringBuilder("Couldn't use the system look and feel:")).append(e).toString());
    //    4   10:getstatic       #688 <Field PrintStream System.err>
    //    5   13:new             #452 <Class StringBuilder>
    //    6   16:dup             
    //    7   17:ldc2            #690 <String "Couldn't use the system look and feel:">
    //    8   20:invokespecial   #455 <Method void StringBuilder(String)>
    //    9   23:aload_2         
    //   10   24:invokevirtual   #693 <Method StringBuilder StringBuilder.append(Object)>
    //   11   27:invokevirtual   #465 <Method String StringBuilder.toString()>
    //   12   30:invokevirtual   #698 <Method void PrintStream.println(String)>
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
    //   13   33:iconst_1        
    //   14   34:invokestatic    #703 <Method void JFrame.setDefaultLookAndFeelDecorated(boolean)>
        JDialog.setDefaultLookAndFeelDecorated(true);
    //   15   37:iconst_1        
    //   16   38:invokestatic    #706 <Method void JDialog.setDefaultLookAndFeelDecorated(boolean)>
        AssEdit note = new AssEdit(filePath);
    //   17   41:new             #708 <Class AssEdit>
    //   18   44:dup             
    //   19   45:aload_1         
    //   20   46:invokespecial   #709 <Method void AssEdit(String)>
    //   21   49:astore_2        
        note.setVisible(true);
    //   22   50:aload_2         
    //   23   51:iconst_1        
    //   24   52:invokevirtual   #710 <Method void AssEdit.setVisible(boolean)>
    //   25   55:return          
    }

    protected void setAssignmentInfor(Assignment AssData)
    {
        NumX.setText((new StringBuilder()).append(AssData.getDimensionX().getDimensionAttribute().numValues()).toString());
    //    0    0:aload_0         
    //    1    1:getfield        #148 <Field JLabel NumX>
    //    2    4:new             #452 <Class StringBuilder>
    //    3    7:dup             
    //    4    8:invokespecial   #714 <Method void StringBuilder()>
    //    5   11:aload_1         
    //    6   12:invokevirtual   #718 <Method Dimension Assignment.getDimensionX()>
    //    7   15:invokevirtual   #724 <Method Attribute Dimension.getDimensionAttribute()>
    //    8   18:invokevirtual   #730 <Method int Attribute.numValues()>
    //    9   21:invokevirtual   #733 <Method StringBuilder StringBuilder.append(int)>
    //   10   24:invokevirtual   #465 <Method String StringBuilder.toString()>
    //   11   27:invokevirtual   #736 <Method void JLabel.setText(String)>
        NumY.setText((new StringBuilder()).append(AssData.getDimensionY().getDimensionAttribute().numValues()).toString());
    //   12   30:aload_0         
    //   13   31:getfield        #154 <Field JLabel NumY>
    //   14   34:new             #452 <Class StringBuilder>
    //   15   37:dup             
    //   16   38:invokespecial   #714 <Method void StringBuilder()>
    //   17   41:aload_1         
    //   18   42:invokevirtual   #739 <Method Dimension Assignment.getDimensionY()>
    //   19   45:invokevirtual   #724 <Method Attribute Dimension.getDimensionAttribute()>
    //   20   48:invokevirtual   #730 <Method int Attribute.numValues()>
    //   21   51:invokevirtual   #733 <Method StringBuilder StringBuilder.append(int)>
    //   22   54:invokevirtual   #465 <Method String StringBuilder.toString()>
    //   23   57:invokevirtual   #736 <Method void JLabel.setText(String)>
        m_DRBut.setEnabled(true);
    //   24   60:aload_0         
    //   25   61:getfield        #125 <Field JButton m_DRBut>
    //   26   64:iconst_1        
    //   27   65:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        if(AssData.getDimensionX().getDimensionInstances() != null)
    //*  28   68:aload_1         
    //*  29   69:invokevirtual   #718 <Method Dimension Assignment.getDimensionX()>
    //*  30   72:invokevirtual   #743 <Method Instances Dimension.getDimensionInstances()>
    //*  31   75:ifnull          89
            m_DXBut.setEnabled(true);
    //   32   78:aload_0         
    //   33   79:getfield        #133 <Field JButton m_DXBut>
    //   34   82:iconst_1        
    //   35   83:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        else
    //*  36   86:goto            97
            m_DXBut.setEnabled(false);
    //   37   89:aload_0         
    //   38   90:getfield        #133 <Field JButton m_DXBut>
    //   39   93:iconst_0        
    //   40   94:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        if(AssData.getDimensionX().getDimensionInstances() != null)
    //*  41   97:aload_1         
    //*  42   98:invokevirtual   #718 <Method Dimension Assignment.getDimensionX()>
    //*  43  101:invokevirtual   #743 <Method Instances Dimension.getDimensionInstances()>
    //*  44  104:ifnull          118
            m_DYBut.setEnabled(true);
    //   45  107:aload_0         
    //   46  108:getfield        #139 <Field JButton m_DYBut>
    //   47  111:iconst_1        
    //   48  112:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        else
    //*  49  115:goto            126
            m_DYBut.setEnabled(false);
    //   50  118:aload_0         
    //   51  119:getfield        #139 <Field JButton m_DYBut>
    //   52  122:iconst_0        
    //   53  123:invokevirtual   #283 <Method void JButton.setEnabled(boolean)>
        m_InstSummaryPanel = new InstancesSummaryPanel();
    //   54  126:aload_0         
    //   55  127:new             #79  <Class InstancesSummaryPanel>
    //   56  130:dup             
    //   57  131:invokespecial   #80  <Method void InstancesSummaryPanel()>
    //   58  134:putfield        #82  <Field InstancesSummaryPanel m_InstSummaryPanel>
        m_AttPanel = new AttributeSelectionPanel();
    //   59  137:aload_0         
    //   60  138:new             #84  <Class AttributeSelectionPanel>
    //   61  141:dup             
    //   62  142:invokespecial   #85  <Method void AttributeSelectionPanel()>
    //   63  145:putfield        #87  <Field AttributeSelectionPanel m_AttPanel>
        m_AttSummaryPanel = new AttributeSummaryPanel();
    //   64  148:aload_0         
    //   65  149:new             #184 <Class AttributeSummaryPanel>
    //   66  152:dup             
    //   67  153:invokespecial   #185 <Method void AttributeSummaryPanel()>
    //   68  156:putfield        #187 <Field AttributeSummaryPanel m_AttSummaryPanel>
        m_AttVisualizePanel = new AttributeVisualizationPanel();
    //   69  159:aload_0         
    //   70  160:new             #189 <Class AttributeVisualizationPanel>
    //   71  163:dup             
    //   72  164:invokespecial   #190 <Method void AttributeVisualizationPanel()>
    //   73  167:putfield        #192 <Field AttributeVisualizationPanel m_AttVisualizePanel>
        setViewPanel();
    //   74  170:aload_0         
    //   75  171:invokespecial   #319 <Method void setViewPanel()>
        m_Tabbedpane.setAllAssignment();
    //   76  174:aload_0         
    //   77  175:getfield        #178 <Field TabbedPane m_Tabbedpane>
    //   78  178:invokevirtual   #748 <Method void TabbedPane.setAllAssignment()>
    //   79  181:return          
    }

    public void setInstances(Instances inst)
    {
        m_Instances = inst;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #513 <Field Instances m_Instances>
        try
        {
            Runnable r = new Runnable() {

                public void run()
                {
                    m_InstSummaryPanel.setInstances(m_Instances);
                //    0    0:aload_0         
                //    1    1:getfield        #13  <Field PreprocessPanel this$0>
                //    2    4:getfield        #27  <Field InstancesSummaryPanel PreprocessPanel.m_InstSummaryPanel>
                //    3    7:aload_0         
                //    4    8:getfield        #13  <Field PreprocessPanel this$0>
                //    5   11:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //    6   14:invokevirtual   #37  <Method void InstancesSummaryPanel.setInstances(Instances)>
                    m_AttPanel.setInstances(m_Instances);
                //    7   17:aload_0         
                //    8   18:getfield        #13  <Field PreprocessPanel this$0>
                //    9   21:getfield        #41  <Field AttributeSelectionPanel PreprocessPanel.m_AttPanel>
                //   10   24:aload_0         
                //   11   25:getfield        #13  <Field PreprocessPanel this$0>
                //   12   28:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   13   31:invokevirtual   #44  <Method void AttributeSelectionPanel.setInstances(Instances)>
                    m_RemoveButton.setEnabled(true);
                //   14   34:aload_0         
                //   15   35:getfield        #13  <Field PreprocessPanel this$0>
                //   16   38:getfield        #48  <Field JButton PreprocessPanel.m_RemoveButton>
                //   17   41:iconst_1        
                //   18   42:invokevirtual   #54  <Method void JButton.setEnabled(boolean)>
                    m_AttSummaryPanel.setInstances(m_Instances);
                //   19   45:aload_0         
                //   20   46:getfield        #13  <Field PreprocessPanel this$0>
                //   21   49:getfield        #58  <Field AttributeSummaryPanel PreprocessPanel.m_AttSummaryPanel>
                //   22   52:aload_0         
                //   23   53:getfield        #13  <Field PreprocessPanel this$0>
                //   24   56:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   25   59:invokevirtual   #61  <Method void AttributeSummaryPanel.setInstances(Instances)>
                    m_AttVisualizePanel.setInstances(m_Instances);
                //   26   62:aload_0         
                //   27   63:getfield        #13  <Field PreprocessPanel this$0>
                //   28   66:getfield        #65  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
                //   29   69:aload_0         
                //   30   70:getfield        #13  <Field PreprocessPanel this$0>
                //   31   73:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   32   76:invokevirtual   #68  <Method void AttributeVisualizationPanel.setInstances(Instances)>
                    m_AttPanel.getSelectionModel().setSelectionInterval(0, 0);
                //   33   79:aload_0         
                //   34   80:getfield        #13  <Field PreprocessPanel this$0>
                //   35   83:getfield        #41  <Field AttributeSelectionPanel PreprocessPanel.m_AttPanel>
                //   36   86:invokevirtual   #72  <Method ListSelectionModel AttributeSelectionPanel.getSelectionModel()>
                //   37   89:iconst_0        
                //   38   90:iconst_0        
                //   39   91:invokeinterface #78  <Method void ListSelectionModel.setSelectionInterval(int, int)>
                    m_AttSummaryPanel.setAttribute(0);
                //   40   96:aload_0         
                //   41   97:getfield        #13  <Field PreprocessPanel this$0>
                //   42  100:getfield        #58  <Field AttributeSummaryPanel PreprocessPanel.m_AttSummaryPanel>
                //   43  103:iconst_0        
                //   44  104:invokevirtual   #82  <Method void AttributeSummaryPanel.setAttribute(int)>
                    m_AttVisualizePanel.setAttribute(0);
                //   45  107:aload_0         
                //   46  108:getfield        #13  <Field PreprocessPanel this$0>
                //   47  111:getfield        #65  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
                //   48  114:iconst_0        
                //   49  115:invokevirtual   #83  <Method void AttributeVisualizationPanel.setAttribute(int)>
                    m_Log.logMessage((new StringBuilder("Base relation is now ")).append(m_Instances.relationName()).append(" (").append(m_Instances.numInstances()).append(" instances)").toString());
                //   50  118:aload_0         
                //   51  119:getfield        #13  <Field PreprocessPanel this$0>
                //   52  122:getfield        #87  <Field Logger PreprocessPanel.m_Log>
                //   53  125:new             #89  <Class StringBuilder>
                //   54  128:dup             
                //   55  129:ldc1            #91  <String "Base relation is now ">
                //   56  131:invokespecial   #94  <Method void StringBuilder(String)>
                //   57  134:aload_0         
                //   58  135:getfield        #13  <Field PreprocessPanel this$0>
                //   59  138:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   60  141:invokevirtual   #100 <Method String Instances.relationName()>
                //   61  144:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
                //   62  147:ldc1            #106 <String " (">
                //   63  149:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
                //   64  152:aload_0         
                //   65  153:getfield        #13  <Field PreprocessPanel this$0>
                //   66  156:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   67  159:invokevirtual   #110 <Method int Instances.numInstances()>
                //   68  162:invokevirtual   #113 <Method StringBuilder StringBuilder.append(int)>
                //   69  165:ldc1            #115 <String " instances)">
                //   70  167:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
                //   71  170:invokevirtual   #118 <Method String StringBuilder.toString()>
                //   72  173:invokeinterface #123 <Method void Logger.logMessage(String)>
                    m_SaveBut.setEnabled(true);
                //   73  178:aload_0         
                //   74  179:getfield        #13  <Field PreprocessPanel this$0>
                //   75  182:getfield        #126 <Field JButton PreprocessPanel.m_SaveBut>
                //   76  185:iconst_1        
                //   77  186:invokevirtual   #54  <Method void JButton.setEnabled(boolean)>
                    m_EditBut.setEnabled(true);
                //   78  189:aload_0         
                //   79  190:getfield        #13  <Field PreprocessPanel this$0>
                //   80  193:getfield        #129 <Field JButton PreprocessPanel.m_EditBut>
                //   81  196:iconst_1        
                //   82  197:invokevirtual   #54  <Method void JButton.setEnabled(boolean)>
                    m_Log.statusMessage("OK");
                //   83  200:aload_0         
                //   84  201:getfield        #13  <Field PreprocessPanel this$0>
                //   85  204:getfield        #87  <Field Logger PreprocessPanel.m_Log>
                //   86  207:ldc1            #131 <String "OK">
                //   87  209:invokeinterface #134 <Method void Logger.statusMessage(String)>
                    try
                    {
                        int oldIndex = m_Instances.classIndex();
                //   88  214:aload_0         
                //   89  215:getfield        #13  <Field PreprocessPanel this$0>
                //   90  218:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   91  221:invokevirtual   #137 <Method int Instances.classIndex()>
                //   92  224:istore_1        
                        m_Instances.setClassIndex(m_AttVisualizePanel.getColorBox().getSelectedIndex() - 1);
                //   93  225:aload_0         
                //   94  226:getfield        #13  <Field PreprocessPanel this$0>
                //   95  229:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //   96  232:aload_0         
                //   97  233:getfield        #13  <Field PreprocessPanel this$0>
                //   98  236:getfield        #65  <Field AttributeVisualizationPanel PreprocessPanel.m_AttVisualizePanel>
                //   99  239:invokevirtual   #141 <Method JComboBox AttributeVisualizationPanel.getColorBox()>
                //  100  242:invokevirtual   #146 <Method int JComboBox.getSelectedIndex()>
                //  101  245:iconst_1        
                //  102  246:isub            
                //  103  247:invokevirtual   #149 <Method void Instances.setClassIndex(int)>
                        m_Instances.setClassIndex(oldIndex);
                //  104  250:aload_0         
                //  105  251:getfield        #13  <Field PreprocessPanel this$0>
                //  106  254:getfield        #31  <Field Instances PreprocessPanel.m_Instances>
                //  107  257:iload_1         
                //  108  258:invokevirtual   #149 <Method void Instances.setClassIndex(int)>
                    }
                //* 109  261:goto            285
                    catch(Exception e)
                //* 110  264:astore_1        
                    {
                        e.printStackTrace();
                //  111  265:aload_1         
                //  112  266:invokevirtual   #154 <Method void Exception.printStackTrace()>
                        m_Log.logMessage(e.toString());
                //  113  269:aload_0         
                //  114  270:getfield        #13  <Field PreprocessPanel this$0>
                //  115  273:getfield        #87  <Field Logger PreprocessPanel.m_Log>
                //  116  276:aload_1         
                //  117  277:invokevirtual   #155 <Method String Exception.toString()>
                //  118  280:invokeinterface #123 <Method void Logger.logMessage(String)>
                    }
                //  119  285:return          
                }

                final PreprocessPanel this$0;

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
            }
;
    //    3    5:new             #752 <Class PreprocessPanel$13>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:invokespecial   #753 <Method void PreprocessPanel$13(PreprocessPanel)>
    //    7   13:astore_2        
            if(SwingUtilities.isEventDispatchThread())
    //*   8   14:invokestatic    #758 <Method boolean SwingUtilities.isEventDispatchThread()>
    //*   9   17:ifeq            29
                r.run();
    //   10   20:aload_2         
    //   11   21:invokeinterface #763 <Method void Runnable.run()>
            else
    //*  12   26:goto            66
                SwingUtilities.invokeAndWait(r);
    //   13   29:aload_2         
    //   14   30:invokestatic    #767 <Method void SwingUtilities.invokeAndWait(Runnable)>
        }
    //*  15   33:goto            66
        catch(Exception ex)
    //*  16   36:astore_2        
        {
            ex.printStackTrace();
    //   17   37:aload_2         
    //   18   38:invokevirtual   #474 <Method void Exception.printStackTrace()>
            JOptionPane.showMessageDialog(this, (new StringBuilder("Problem setting base instances:\n")).append(ex).toString(), "Instances", 0);
    //   19   41:aload_0         
    //   20   42:new             #452 <Class StringBuilder>
    //   21   45:dup             
    //   22   46:ldc2            #769 <String "Problem setting base instances:\n">
    //   23   49:invokespecial   #455 <Method void StringBuilder(String)>
    //   24   52:aload_2         
    //   25   53:invokevirtual   #693 <Method StringBuilder StringBuilder.append(Object)>
    //   26   56:invokevirtual   #465 <Method String StringBuilder.toString()>
    //   27   59:ldc2            #771 <String "Instances">
    //   28   62:iconst_0        
    //   29   63:invokestatic    #507 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   30   66:return          
    }

    public void generateAssignment()
    {
        if(m_GDThread == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #778 <Field Thread m_GDThread>
    //*   2    4:ifnonnull       37
        {
            m_GDThread = new Thread() {

                public void run()
                {
                    try
                    {
                        final JDialog dialog = new JDialog();
                //    0    0:new             #21  <Class JDialog>
                //    1    3:dup             
                //    2    4:invokespecial   #22  <Method void JDialog()>
                //    3    7:astore_1        
                        java.awt.Point p = getTabbedPane().getLocation();
                //    4    8:aload_0         
                //    5    9:getfield        #11  <Field PreprocessPanel this$0>
                //    6   12:invokevirtual   #28  <Method TabbedPane PreprocessPanel.getTabbedPane()>
                //    7   15:invokevirtual   #34  <Method java.awt.Point TabbedPane.getLocation()>
                //    8   18:astore_2        
                        dialog.setLocation(p);
                //    9   19:aload_1         
                //   10   20:aload_2         
                //   11   21:invokevirtual   #38  <Method void JDialog.setLocation(java.awt.Point)>
                        JButton generateButton = new JButton("Generate");
                //   12   24:new             #40  <Class JButton>
                //   13   27:dup             
                //   14   28:ldc1            #42  <String "Generate">
                //   15   30:invokespecial   #45  <Method void JButton(String)>
                //   16   33:astore_3        
                        Toolkit tk = Toolkit.getDefaultToolkit();
                //   17   34:invokestatic    #51  <Method Toolkit Toolkit.getDefaultToolkit()>
                //   18   37:astore          4
                        java.net.URL Imagepath = getClass().getClassLoader().getResource("images/Icon.png");
                //   19   39:aload_0         
                //   20   40:invokevirtual   #57  <Method Class Object.getClass()>
                //   21   43:invokevirtual   #63  <Method ClassLoader Class.getClassLoader()>
                //   22   46:ldc1            #65  <String "images/Icon.png">
                //   23   48:invokevirtual   #71  <Method java.net.URL ClassLoader.getResource(String)>
                //   24   51:astore          5
                        java.awt.Image img = tk.getImage(Imagepath);
                //   25   53:aload           4
                //   26   55:aload           5
                //   27   57:invokevirtual   #75  <Method java.awt.Image Toolkit.getImage(java.net.URL)>
                //   28   60:astore          6
                        dialog.setIconImage(img);
                //   29   62:aload_1         
                //   30   63:aload           6
                //   31   65:invokevirtual   #79  <Method void JDialog.setIconImage(java.awt.Image)>
                        m_GeneratorEditor.setClassType(rm/generate/Generate);
                //   32   68:aload_0         
                //   33   69:getfield        #11  <Field PreprocessPanel this$0>
                //   34   72:getfield        #83  <Field GenericObjectEditor PreprocessPanel.m_GeneratorEditor>
                //   35   75:ldc1            #85  <Class Generate>
                //   36   77:invokevirtual   #91  <Method void GenericObjectEditor.setClassType(Class)>
                        m_GeneratorEditor.setValue(ExplorerDefaults.getGenerater());
                //   37   80:aload_0         
                //   38   81:getfield        #11  <Field PreprocessPanel this$0>
                //   39   84:getfield        #83  <Field GenericObjectEditor PreprocessPanel.m_GeneratorEditor>
                //   40   87:invokestatic    #97  <Method Object ExplorerDefaults.getGenerater()>
                //   41   90:invokevirtual   #101 <Method void GenericObjectEditor.setValue(Object)>
                        PropertyPanel m_CEPanel = new PropertyPanel(m_GeneratorEditor);
                //   42   93:new             #103 <Class PropertyPanel>
                //   43   96:dup             
                //   44   97:aload_0         
                //   45   98:getfield        #11  <Field PreprocessPanel this$0>
                //   46  101:getfield        #83  <Field GenericObjectEditor PreprocessPanel.m_GeneratorEditor>
                //   47  104:invokespecial   #106 <Method void PropertyPanel(java.beans.PropertyEditor)>
                //   48  107:astore          7
                        m_CEPanel.setPreferredSize(new java.awt.Dimension(400, (int)m_CEPanel.getPreferredSize().getHeight()));
                //   49  109:aload           7
                //   50  111:new             #108 <Class java.awt.Dimension>
                //   51  114:dup             
                //   52  115:sipush          400
                //   53  118:aload           7
                //   54  120:invokevirtual   #112 <Method java.awt.Dimension PropertyPanel.getPreferredSize()>
                //   55  123:invokevirtual   #116 <Method double java.awt.Dimension.getHeight()>
                //   56  126:d2i             
                //   57  127:invokespecial   #119 <Method void java.awt.Dimension(int, int)>
                //   58  130:invokevirtual   #123 <Method void PropertyPanel.setPreferredSize(java.awt.Dimension)>
                        generateButton.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent evt)
                            {
                                Generate generater = (Generate)m_GeneratorEditor.getValue();
                            //    0    0:aload_0         
                            //    1    1:getfield        #15  <Field PreprocessPanel$14 this$1>
                            //    2    4:invokestatic    #32  <Method PreprocessPanel PreprocessPanel$14.access$0(PreprocessPanel$14)>
                            //    3    7:getfield        #38  <Field GenericObjectEditor PreprocessPanel.m_GeneratorEditor>
                            //    4   10:invokevirtual   #44  <Method Object GenericObjectEditor.getValue()>
                            //    5   13:checkcast       #46  <Class Generate>
                            //    6   16:astore_2        
                                try
                                {
                                    String o[] = ((OptionHandler)generater).getOptions();
                            //    7   17:aload_2         
                            //    8   18:checkcast       #48  <Class OptionHandler>
                            //    9   21:invokeinterface #52  <Method String[] OptionHandler.getOptions()>
                            //   10   26:astore_3        
                                    ((OptionHandler)generater).setOptions(o);
                            //   11   27:aload_2         
                            //   12   28:checkcast       #48  <Class OptionHandler>
                            //   13   31:aload_3         
                            //   14   32:invokeinterface #56  <Method void OptionHandler.setOptions(String[])>
                                    generater.buildGeneraters();
                            //   15   37:aload_2         
                            //   16   38:invokeinterface #59  <Method void Generate.buildGeneraters()>
                                    AssLoader assUPA = new AssLoader(generater.getUPAString());
                            //   17   43:new             #61  <Class AssLoader>
                            //   18   46:dup             
                            //   19   47:aload_2         
                            //   20   48:invokeinterface #65  <Method String Generate.getUPAString()>
                            //   21   53:invokespecial   #68  <Method void AssLoader(String)>
                            //   22   56:astore          4
                                    m_assignment = assUPA.getData();
                            //   23   58:aload_0         
                            //   24   59:getfield        #15  <Field PreprocessPanel$14 this$1>
                            //   25   62:invokestatic    #32  <Method PreprocessPanel PreprocessPanel$14.access$0(PreprocessPanel$14)>
                            //   26   65:aload           4
                            //   27   67:invokevirtual   #72  <Method Assignment AssLoader.getData()>
                            //   28   70:putfield        #76  <Field Assignment PreprocessPanel.m_assignment>
                                    setAssignmentInfor(m_assignment);
                            //   29   73:aload_0         
                            //   30   74:getfield        #15  <Field PreprocessPanel$14 this$1>
                            //   31   77:invokestatic    #32  <Method PreprocessPanel PreprocessPanel$14.access$0(PreprocessPanel$14)>
                            //   32   80:aload_0         
                            //   33   81:getfield        #15  <Field PreprocessPanel$14 this$1>
                            //   34   84:invokestatic    #32  <Method PreprocessPanel PreprocessPanel$14.access$0(PreprocessPanel$14)>
                            //   35   87:getfield        #76  <Field Assignment PreprocessPanel.m_assignment>
                            //   36   90:invokevirtual   #80  <Method void PreprocessPanel.setAssignmentInfor(Assignment)>
                                    repaint();
                            //   37   93:aload_0         
                            //   38   94:getfield        #15  <Field PreprocessPanel$14 this$1>
                            //   39   97:invokestatic    #32  <Method PreprocessPanel PreprocessPanel$14.access$0(PreprocessPanel$14)>
                            //   40  100:invokevirtual   #83  <Method void PreprocessPanel.repaint()>
                                }
                            //*  41  103:goto            111
                                catch(Exception e)
                            //*  42  106:astore_3        
                                {
                                    e.printStackTrace();
                            //   43  107:aload_3         
                            //   44  108:invokevirtual   #88  <Method void Exception.printStackTrace()>
                                }
                                dialog.dispose();
                            //   45  111:aload_0         
                            //   46  112:getfield        #17  <Field JDialog val$dialog>
                            //   47  115:invokevirtual   #93  <Method void JDialog.dispose()>
                            //   48  118:return          
                            }

                            final _cls14 this$1;
                            private final JDialog val$dialog;

                    
                    {
                        this$1 = _cls14.this;
                    //    0    0:aload_0         
                    //    1    1:aload_1         
                    //    2    2:putfield        #15  <Field PreprocessPanel$14 this$1>
                        dialog = jdialog;
                    //    3    5:aload_0         
                    //    4    6:aload_2         
                    //    5    7:putfield        #17  <Field JDialog val$dialog>
                        super();
                    //    6   10:aload_0         
                    //    7   11:invokespecial   #20  <Method void Object()>
                    //    8   14:return          
                    }
                        }
);
                //   59  133:aload_3         
                //   60  134:new             #125 <Class PreprocessPanel$15>
                //   61  137:dup             
                //   62  138:aload_0         
                //   63  139:aload_1         
                //   64  140:invokespecial   #128 <Method void PreprocessPanel$15(PreprocessPanel$14, JDialog)>
                //   65  143:invokevirtual   #132 <Method void JButton.addActionListener(ActionListener)>
                        dialog.setTitle("DataGenerator");
                //   66  146:aload_1         
                //   67  147:ldc1            #134 <String "DataGenerator">
                //   68  149:invokevirtual   #137 <Method void JDialog.setTitle(String)>
                        dialog.getContentPane().add(m_CEPanel, "Center");
                //   69  152:aload_1         
                //   70  153:invokevirtual   #141 <Method Container JDialog.getContentPane()>
                //   71  156:aload           7
                //   72  158:ldc1            #143 <String "Center">
                //   73  160:invokevirtual   #149 <Method void Container.add(java.awt.Component, Object)>
                        dialog.getContentPane().add(generateButton, "East");
                //   74  163:aload_1         
                //   75  164:invokevirtual   #141 <Method Container JDialog.getContentPane()>
                //   76  167:aload_3         
                //   77  168:ldc1            #151 <String "East">
                //   78  170:invokevirtual   #149 <Method void Container.add(java.awt.Component, Object)>
                        dialog.pack();
                //   79  173:aload_1         
                //   80  174:invokevirtual   #154 <Method void JDialog.pack()>
                        dialog.setVisible(true);
                //   81  177:aload_1         
                //   82  178:iconst_1        
                //   83  179:invokevirtual   #158 <Method void JDialog.setVisible(boolean)>
                    }
                //*  84  182:goto            206
                    catch(Exception ex)
                //*  85  185:astore_1        
                    {
                        ex.printStackTrace();
                //   86  186:aload_1         
                //   87  187:invokevirtual   #163 <Method void Exception.printStackTrace()>
                        m_Log.logMessage(ex.getMessage());
                //   88  190:aload_0         
                //   89  191:getfield        #11  <Field PreprocessPanel this$0>
                //   90  194:getfield        #167 <Field Logger PreprocessPanel.m_Log>
                //   91  197:aload_1         
                //   92  198:invokevirtual   #171 <Method String Exception.getMessage()>
                //   93  201:invokeinterface #176 <Method void Logger.logMessage(String)>
                    }
                    m_GDThread = null;
                //   94  206:aload_0         
                //   95  207:getfield        #11  <Field PreprocessPanel this$0>
                //   96  210:aconst_null     
                //   97  211:putfield        #180 <Field Thread PreprocessPanel.m_GDThread>
                //   98  214:return          
                }

                final PreprocessPanel this$0;


/*
            static PreprocessPanel access$0(_cls14 _pcls14)
            {
                return _pcls14.this$0;
            //    0    0:aload_0         
            //    1    1:getfield        #11  <Field PreprocessPanel this$0>
            //    2    4:areturn         
            }

*/

            
            {
                this$0 = PreprocessPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field PreprocessPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void Thread()>
            //    5    9:return          
            }
            }
;
    //    3    7:aload_0         
    //    4    8:new             #780 <Class PreprocessPanel$14>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:invokespecial   #781 <Method void PreprocessPanel$14(PreprocessPanel)>
    //    8   16:putfield        #778 <Field Thread m_GDThread>
            m_GDThread.setPriority(1);
    //    9   19:aload_0         
    //   10   20:getfield        #778 <Field Thread m_GDThread>
    //   11   23:iconst_1        
    //   12   24:invokevirtual   #494 <Method void Thread.setPriority(int)>
            m_GDThread.start();
    //   13   27:aload_0         
    //   14   28:getfield        #778 <Field Thread m_GDThread>
    //   15   31:invokevirtual   #497 <Method void Thread.start()>
        } else
    //*  16   34:goto            48
        {
            JOptionPane.showMessageDialog(this, "Can't generate data at this time,\ncurrently busy with other IO", "Generate Data", 2);
    //   17   37:aload_0         
    //   18   38:ldc2            #783 <String "Can't generate data at this time,\ncurrently busy with other IO">
    //   19   41:ldc2            #785 <String "Generate Data">
    //   20   44:iconst_2        
    //   21   45:invokestatic    #507 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //   22   48:return          
    }

    public TabbedPane getTabbedPane()
    {
        return m_Tabbedpane;
    //    0    0:aload_0         
    //    1    1:getfield        #178 <Field TabbedPane m_Tabbedpane>
    //    2    4:areturn         
    }

    public void setTabbedPane(TabbedPane parent)
    {
        m_Tabbedpane = parent;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #178 <Field TabbedPane m_Tabbedpane>
    //    3    5:return          
    }

    public void setLog(Logger newLog)
    {
        m_Log = newLog;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #199 <Field Logger m_Log>
    //    3    5:return          
    }

    public void ViewAssignment()
    {
        Assignment copy = new Assignment(m_assignment);
    //    0    0:new             #657 <Class Assignment>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #176 <Field Assignment m_assignment>
    //    4    8:invokespecial   #659 <Method void Assignment(Assignment)>
    //    5   11:astore_2        
        AssignmentViewer dialog = new AssignmentViewer(copy);
    //    6   12:new             #796 <Class AssignmentViewer>
    //    7   15:dup             
    //    8   16:aload_2         
    //    9   17:invokespecial   #797 <Method void AssignmentViewer(Assignment)>
    //   10   20:astore_1        
        dialog.showDialog();
    //   11   21:aload_1         
    //   12   22:invokevirtual   #800 <Method int AssignmentViewer.showDialog()>
    //   13   25:pop             
        m_Log.logMessage("reset the user-permission assignment.");
    //   14   26:aload_0         
    //   15   27:getfield        #199 <Field Logger m_Log>
    //   16   30:ldc2            #802 <String "reset the user-permission assignment.">
    //   17   33:invokeinterface #429 <Method void Logger.logMessage(String)>
        m_assignment = dialog.getAssignment();
    //   18   38:aload_0         
    //   19   39:aload_1         
    //   20   40:invokevirtual   #805 <Method Assignment AssignmentViewer.getAssignment()>
    //   21   43:putfield        #176 <Field Assignment m_assignment>
    //   22   46:return          
    }

    private void InstanceEdit()
    {
        int classIndex = m_AttVisualizePanel.getColoringIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #192 <Field AttributeVisualizationPanel m_AttVisualizePanel>
    //    2    4:invokevirtual   #811 <Method int AttributeVisualizationPanel.getColoringIndex()>
    //    3    7:istore          4
        Instances copy = new Instances(m_Instances);
    //    4    9:new             #813 <Class Instances>
    //    5   12:dup             
    //    6   13:aload_0         
    //    7   14:getfield        #513 <Field Instances m_Instances>
    //    8   17:invokespecial   #815 <Method void Instances(Instances)>
    //    9   20:astore_2        
        copy.setClassIndex(classIndex);
    //   10   21:aload_2         
    //   11   22:iload           4
    //   12   24:invokevirtual   #818 <Method void Instances.setClassIndex(int)>
        dialog = new ViewerDialog(null);
    //   13   27:aload_0         
    //   14   28:new             #820 <Class ViewerDialog>
    //   15   31:dup             
    //   16   32:aconst_null     
    //   17   33:invokespecial   #823 <Method void ViewerDialog(java.awt.Frame)>
    //   18   36:putfield        #825 <Field ViewerDialog dialog>
        int result = dialog.showDialog(copy);
    //   19   39:aload_0         
    //   20   40:getfield        #825 <Field ViewerDialog dialog>
    //   21   43:aload_2         
    //   22   44:invokevirtual   #828 <Method int ViewerDialog.showDialog(Instances)>
    //   23   47:istore_1        
        if(result == 0)
    //*  24   48:iload_1         
    //*  25   49:ifne            80
        {
            Instances newInstances = dialog.getInstances();
    //   26   52:aload_0         
    //   27   53:getfield        #825 <Field ViewerDialog dialog>
    //   28   56:invokevirtual   #831 <Method Instances ViewerDialog.getInstances()>
    //   29   59:astore_3        
            if(m_Instances.classIndex() < 0)
    //*  30   60:aload_0         
    //*  31   61:getfield        #513 <Field Instances m_Instances>
    //*  32   64:invokevirtual   #834 <Method int Instances.classIndex()>
    //*  33   67:ifge            75
                newInstances.setClassIndex(-1);
    //   34   70:aload_3         
    //   35   71:iconst_m1       
    //   36   72:invokevirtual   #818 <Method void Instances.setClassIndex(int)>
            setInstances(newInstances);
    //   37   75:aload_0         
    //   38   76:aload_3         
    //   39   77:invokevirtual   #836 <Method void setInstances(Instances)>
        }
    //   40   80:return          
    }

    public String getTabTitle()
    {
        return "Preprocess";
    //    0    0:ldc2            #841 <String "Preprocess">
    //    1    3:areturn         
    }

    public String getTabTitleToolTip()
    {
        return "Open/Edit/Save assigment";
    //    0    0:ldc2            #844 <String "Open/Edit/Save assigment">
    //    1    3:areturn         
    }

    public Assignment getAssignment()
    {
        return m_assignment;
    //    0    0:aload_0         
    //    1    1:getfield        #176 <Field Assignment m_assignment>
    //    2    4:areturn         
    }

    public static void main(String args[])
    {
        try
        {
            final JFrame jf = new JFrame("RMiner Explorer: Preprocess");
    //    0    0:new             #700 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc2            #848 <String "RMiner Explorer: Preprocess">
    //    3    7:invokespecial   #849 <Method void JFrame(String)>
    //    4   10:astore_1        
            jf.getContentPane().setLayout(new BorderLayout());
    //    5   11:aload_1         
    //    6   12:invokevirtual   #853 <Method Container JFrame.getContentPane()>
    //    7   15:new             #237 <Class BorderLayout>
    //    8   18:dup             
    //    9   19:invokespecial   #238 <Method void BorderLayout()>
    //   10   22:invokevirtual   #856 <Method void Container.setLayout(java.awt.LayoutManager)>
            PreprocessPanel sp = new PreprocessPanel();
    //   11   25:new             #2   <Class PreprocessPanel>
    //   12   28:dup             
    //   13   29:invokespecial   #857 <Method void PreprocessPanel()>
    //   14   32:astore_2        
            jf.getContentPane().add(sp, "Center");
    //   15   33:aload_1         
    //   16   34:invokevirtual   #853 <Method Container JFrame.getContentPane()>
    //   17   37:aload_2         
    //   18   38:ldc2            #323 <String "Center">
    //   19   41:invokevirtual   #858 <Method void Container.add(java.awt.Component, Object)>
            LogPanel lp = new LogPanel();
    //   20   44:new             #860 <Class LogPanel>
    //   21   47:dup             
    //   22   48:invokespecial   #861 <Method void LogPanel()>
    //   23   51:astore_3        
            jf.getContentPane().add(lp, "South");
    //   24   52:aload_1         
    //   25   53:invokevirtual   #853 <Method Container JFrame.getContentPane()>
    //   26   56:aload_3         
    //   27   57:ldc2            #363 <String "South">
    //   28   60:invokevirtual   #858 <Method void Container.add(java.awt.Component, Object)>
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
    //   29   63:aload_1         
    //   30   64:new             #863 <Class PreprocessPanel$16>
    //   31   67:dup             
    //   32   68:aload_1         
    //   33   69:invokespecial   #866 <Method void PreprocessPanel$16(JFrame)>
    //   34   72:invokevirtual   #870 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   35   75:aload_1         
    //   36   76:invokevirtual   #873 <Method void JFrame.pack()>
            jf.setSize(800, 600);
    //   37   79:aload_1         
    //   38   80:sipush          800
    //   39   83:sipush          600
    //   40   86:invokevirtual   #876 <Method void JFrame.setSize(int, int)>
            jf.setVisible(true);
    //   41   89:aload_1         
    //   42   90:iconst_1        
    //   43   91:invokevirtual   #877 <Method void JFrame.setVisible(boolean)>
        }
    //*  44   94:goto            112
        catch(Exception ex)
    //*  45   97:astore_1        
        {
            ex.printStackTrace();
    //   46   98:aload_1         
    //   47   99:invokevirtual   #474 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   48  102:getstatic       #688 <Field PrintStream System.err>
    //   49  105:aload_1         
    //   50  106:invokevirtual   #880 <Method String Exception.getMessage()>
    //   51  109:invokevirtual   #698 <Method void PrintStream.println(String)>
        }
    //   52  112:return          
    }

    protected InstancesSummaryPanel m_InstSummaryPanel;
    protected AttributeSelectionPanel m_AttPanel;
    protected static final String NO_SOURCE = "None";
    protected Instances m_Instances;
    protected int m_tempUndoIndex;
    protected JButton m_OpenFileBut;
    protected JButton m_GenerateBut;
    protected JButton m_UndoBut;
    protected JButton m_EditBut;
    protected JButton m_SaveBut;
    protected JLabel labR;
    protected JButton m_DRBut;
    protected JLabel labX;
    protected JButton m_DXBut;
    protected JLabel labY;
    protected JButton m_DYBut;
    protected JLabel labNumX;
    protected JLabel NumX;
    protected JLabel labNumY;
    protected JLabel NumY;
    protected ConverterFileChooser m_FileChooser;
    protected int Fileflag;
    protected File SelectedFile;
    protected AssLoader AssData;
    protected Assignment m_assignment;
    protected TabbedPane m_Tabbedpane;
    protected ViewerDialog dialog;
    protected JButton m_RemoveButton;
    protected AttributeSummaryPanel m_AttSummaryPanel;
    protected AttributeVisualizationPanel m_AttVisualizePanel;
    protected JPanel relation;
    protected Logger m_Log;
    protected Thread m_GDThread;
    protected Thread m_IOThread;
    GenericObjectEditor m_GeneratorEditor;
    protected File m_tempUndoFiles[];
    protected static int count = 0;
    static Class class$0;
    static Class class$1;

    static 
    {
    //    0    0:iconst_0        
    //    1    1:putstatic       #72  <Field int count>
    //*   2    4:return          
    }


/*
    static void access$0(PreprocessPanel preprocesspanel)
    {
        preprocesspanel.openFile();
    //    0    0:aload_0         
    //    1    1:invokespecial   #890 <Method void openFile()>
        return;
    //    2    4:return          
    }

*/


/*
    static void access$1(PreprocessPanel preprocesspanel, String s)
    {
        preprocesspanel.openEditor(s);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #895 <Method void openEditor(String)>
        return;
    //    3    5:return          
    }

*/


/*
    static void access$2(PreprocessPanel preprocesspanel)
    {
        preprocesspanel.saveWorkingAssignment();
    //    0    0:aload_0         
    //    1    1:invokespecial   #898 <Method void saveWorkingAssignment()>
        return;
    //    2    4:return          
    }

*/


/*
    static void access$3(PreprocessPanel preprocesspanel)
    {
        preprocesspanel.InstanceEdit();
    //    0    0:aload_0         
    //    1    1:invokespecial   #901 <Method void InstanceEdit()>
        return;
    //    2    4:return          
    }

*/


/*
    static void access$4(PreprocessPanel preprocesspanel, File file)
    {
        preprocesspanel.converterQuery(file);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #905 <Method void converterQuery(File)>
        return;
    //    3    5:return          
    }

*/


/*
    static void access$5(PreprocessPanel preprocesspanel, Loader loader, File file)
    {
        preprocesspanel.tryConverter(loader, file);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokespecial   #908 <Method void tryConverter(Loader, File)>
        return;
    //    4    6:return          
    }

*/
}

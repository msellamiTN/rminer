// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   VisualizePanel.java

package rm.gui.explorer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rm.core.Assignment;
import rm.core.Attribute;
import rm.core.Matrix;
import rm.core.converters.AssLoader;
import rm.gui.Logger;
import rm.gui.SysErrLog;
import rm.gui.graph.Colorsimilar;

public class VisualizePanel extends JPanel
{

    public VisualizePanel(Assignment newAssignment)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #32  <Method void JPanel()>
        m_colorSurround = new JPanel();
    //    2    4:aload_0         
    //    3    5:new             #4   <Class JPanel>
    //    4    8:dup             
    //    5    9:invokespecial   #32  <Method void JPanel()>
    //    6   12:putfield        #34  <Field JPanel m_colorSurround>
        m_Log = new SysErrLog();
    //    7   15:aload_0         
    //    8   16:new             #36  <Class SysErrLog>
    //    9   19:dup             
    //   10   20:invokespecial   #37  <Method void SysErrLog()>
    //   11   23:putfield        #39  <Field Logger m_Log>
        m_FileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
    //   12   26:aload_0         
    //   13   27:new             #41  <Class JFileChooser>
    //   14   30:dup             
    //   15   31:new             #43  <Class File>
    //   16   34:dup             
    //   17   35:ldc1            #45  <String "user.dir">
    //   18   37:invokestatic    #51  <Method String System.getProperty(String)>
    //   19   40:invokespecial   #54  <Method void File(String)>
    //   20   43:invokespecial   #57  <Method void JFileChooser(File)>
    //   21   46:putfield        #59  <Field JFileChooser m_FileChooser>
        m_Combo = new JComboBox();
    //   22   49:aload_0         
    //   23   50:new             #61  <Class JComboBox>
    //   24   53:dup             
    //   25   54:invokespecial   #62  <Method void JComboBox()>
    //   26   57:putfield        #64  <Field JComboBox m_Combo>
        m_cancel = new JButton("Clear");
    //   27   60:aload_0         
    //   28   61:new             #66  <Class JButton>
    //   29   64:dup             
    //   30   65:ldc1            #68  <String "Clear">
    //   31   67:invokespecial   #69  <Method void JButton(String)>
    //   32   70:putfield        #71  <Field JButton m_cancel>
        m_openBut = new JButton("Open");
    //   33   73:aload_0         
    //   34   74:new             #66  <Class JButton>
    //   35   77:dup             
    //   36   78:ldc1            #73  <String "Open">
    //   37   80:invokespecial   #69  <Method void JButton(String)>
    //   38   83:putfield        #75  <Field JButton m_openBut>
        COMBO_SIZE = new Dimension(250, m_openBut.getPreferredSize().height);
    //   39   86:aload_0         
    //   40   87:new             #77  <Class Dimension>
    //   41   90:dup             
    //   42   91:sipush          250
    //   43   94:aload_0         
    //   44   95:getfield        #75  <Field JButton m_openBut>
    //   45   98:invokevirtual   #81  <Method Dimension JButton.getPreferredSize()>
    //   46  101:getfield        #85  <Field int Dimension.height>
    //   47  104:invokespecial   #88  <Method void Dimension(int, int)>
    //   48  107:putfield        #90  <Field Dimension COMBO_SIZE>
        m_Assignment = newAssignment;
    //   49  110:aload_0         
    //   50  111:aload_1         
    //   51  112:putfield        #92  <Field Assignment m_Assignment>
        Similarity = new Colorsimilar[2];
    //   52  115:aload_0         
    //   53  116:iconst_2        
    //   54  117:anewarray       Colorsimilar[]
    //   55  120:putfield        #96  <Field Colorsimilar[] Similarity>
        int WidthUser = Math.max(412, m_Assignment.getDimensionX().getDimensionAttribute().numValues());
    //   56  123:sipush          412
    //   57  126:aload_0         
    //   58  127:getfield        #92  <Field Assignment m_Assignment>
    //   59  130:invokevirtual   #102 <Method rm.core.Dimension Assignment.getDimensionX()>
    //   60  133:invokevirtual   #108 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
    //   61  136:invokevirtual   #114 <Method int Attribute.numValues()>
    //   62  139:invokestatic    #120 <Method int Math.max(int, int)>
    //   63  142:istore_2        
        int WidthPerm = Math.max(412, m_Assignment.getDimensionY().getDimensionAttribute().numValues());
    //   64  143:sipush          412
    //   65  146:aload_0         
    //   66  147:getfield        #92  <Field Assignment m_Assignment>
    //   67  150:invokevirtual   #123 <Method rm.core.Dimension Assignment.getDimensionY()>
    //   68  153:invokevirtual   #108 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
    //   69  156:invokevirtual   #114 <Method int Attribute.numValues()>
    //   70  159:invokestatic    #120 <Method int Math.max(int, int)>
    //   71  162:istore_3        
        Similarity[0] = new Colorsimilar(m_Assignment.getAssignmentMatrix(), WidthUser, WidthUser, 0);
    //   72  163:aload_0         
    //   73  164:getfield        #96  <Field Colorsimilar[] Similarity>
    //   74  167:iconst_0        
    //   75  168:new             #94  <Class Colorsimilar>
    //   76  171:dup             
    //   77  172:aload_0         
    //   78  173:getfield        #92  <Field Assignment m_Assignment>
    //   79  176:invokevirtual   #127 <Method Matrix Assignment.getAssignmentMatrix()>
    //   80  179:iload_2         
    //   81  180:iload_2         
    //   82  181:iconst_0        
    //   83  182:invokespecial   #130 <Method void Colorsimilar(Matrix, int, int, int)>
    //   84  185:aastore         
        Similarity[1] = new Colorsimilar(m_Assignment.getAssignmentMatrix(), WidthPerm, WidthPerm, 1);
    //   85  186:aload_0         
    //   86  187:getfield        #96  <Field Colorsimilar[] Similarity>
    //   87  190:iconst_1        
    //   88  191:new             #94  <Class Colorsimilar>
    //   89  194:dup             
    //   90  195:aload_0         
    //   91  196:getfield        #92  <Field Assignment m_Assignment>
    //   92  199:invokevirtual   #127 <Method Matrix Assignment.getAssignmentMatrix()>
    //   93  202:iload_3         
    //   94  203:iload_3         
    //   95  204:iconst_1        
    //   96  205:invokespecial   #130 <Method void Colorsimilar(Matrix, int, int, int)>
    //   97  208:aastore         
        t_NameTable = new JTable[2];
    //   98  209:aload_0         
    //   99  210:iconst_2        
    //  100  211:anewarray       JTable[]
    //  101  214:putfield        #134 <Field JTable[] t_NameTable>
        Users = m_Assignment.getDimensionX().getDimensionAttribute().toArray();
    //  102  217:aload_0         
    //  103  218:aload_0         
    //  104  219:getfield        #92  <Field Assignment m_Assignment>
    //  105  222:invokevirtual   #102 <Method rm.core.Dimension Assignment.getDimensionX()>
    //  106  225:invokevirtual   #108 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
    //  107  228:invokevirtual   #138 <Method Object[] Attribute.toArray()>
    //  108  231:putfield        #140 <Field Object[] Users>
        Perms = m_Assignment.getDimensionY().getDimensionAttribute().toArray();
    //  109  234:aload_0         
    //  110  235:aload_0         
    //  111  236:getfield        #92  <Field Assignment m_Assignment>
    //  112  239:invokevirtual   #123 <Method rm.core.Dimension Assignment.getDimensionY()>
    //  113  242:invokevirtual   #108 <Method Attribute rm.core.Dimension.getDimensionAttribute()>
    //  114  245:invokevirtual   #138 <Method Object[] Attribute.toArray()>
    //  115  248:putfield        #142 <Field Object[] Perms>
        paintPanel();
    //  116  251:aload_0         
    //  117  252:invokespecial   #145 <Method void paintPanel()>
    //  118  255:return          
    }

    private void paintPanel()
    {
        m_FileChooser.setFileSelectionMode(0);
    //    0    0:aload_0         
    //    1    1:getfield        #59  <Field JFileChooser m_FileChooser>
    //    2    4:iconst_0        
    //    3    5:invokevirtual   #156 <Method void JFileChooser.setFileSelectionMode(int)>
        m_Combo.setToolTipText("Select the similar");
    //    4    8:aload_0         
    //    5    9:getfield        #64  <Field JComboBox m_Combo>
    //    6   12:ldc1            #158 <String "Select the similar">
    //    7   14:invokevirtual   #161 <Method void JComboBox.setToolTipText(String)>
        m_Combo.setPreferredSize(COMBO_SIZE);
    //    8   17:aload_0         
    //    9   18:getfield        #64  <Field JComboBox m_Combo>
    //   10   21:aload_0         
    //   11   22:getfield        #90  <Field Dimension COMBO_SIZE>
    //   12   25:invokevirtual   #165 <Method void JComboBox.setPreferredSize(Dimension)>
        m_Combo.setMaximumSize(COMBO_SIZE);
    //   13   28:aload_0         
    //   14   29:getfield        #64  <Field JComboBox m_Combo>
    //   15   32:aload_0         
    //   16   33:getfield        #90  <Field Dimension COMBO_SIZE>
    //   17   36:invokevirtual   #168 <Method void JComboBox.setMaximumSize(Dimension)>
        m_Combo.setMinimumSize(COMBO_SIZE);
    //   18   39:aload_0         
    //   19   40:getfield        #64  <Field JComboBox m_Combo>
    //   20   43:aload_0         
    //   21   44:getfield        #90  <Field Dimension COMBO_SIZE>
    //   22   47:invokevirtual   #171 <Method void JComboBox.setMinimumSize(Dimension)>
        String Names[] = new String[2];
    //   23   50:iconst_2        
    //   24   51:anewarray       String[]
    //   25   54:astore_1        
        Names[0] = (new StringBuilder("Similarity: ")).append(m_Assignment.getDimensionX().getName()).toString();
    //   26   55:aload_1         
    //   27   56:iconst_0        
    //   28   57:new             #175 <Class StringBuilder>
    //   29   60:dup             
    //   30   61:ldc1            #177 <String "Similarity: ">
    //   31   63:invokespecial   #178 <Method void StringBuilder(String)>
    //   32   66:aload_0         
    //   33   67:getfield        #92  <Field Assignment m_Assignment>
    //   34   70:invokevirtual   #102 <Method rm.core.Dimension Assignment.getDimensionX()>
    //   35   73:invokevirtual   #182 <Method String rm.core.Dimension.getName()>
    //   36   76:invokevirtual   #186 <Method StringBuilder StringBuilder.append(String)>
    //   37   79:invokevirtual   #189 <Method String StringBuilder.toString()>
    //   38   82:aastore         
        Names[1] = (new StringBuilder("Similarity: ")).append(m_Assignment.getDimensionY().getName()).toString();
    //   39   83:aload_1         
    //   40   84:iconst_1        
    //   41   85:new             #175 <Class StringBuilder>
    //   42   88:dup             
    //   43   89:ldc1            #177 <String "Similarity: ">
    //   44   91:invokespecial   #178 <Method void StringBuilder(String)>
    //   45   94:aload_0         
    //   46   95:getfield        #92  <Field Assignment m_Assignment>
    //   47   98:invokevirtual   #123 <Method rm.core.Dimension Assignment.getDimensionY()>
    //   48  101:invokevirtual   #182 <Method String rm.core.Dimension.getName()>
    //   49  104:invokevirtual   #186 <Method StringBuilder StringBuilder.append(String)>
    //   50  107:invokevirtual   #189 <Method String StringBuilder.toString()>
    //   51  110:aastore         
        m_Combo.setModel(new DefaultComboBoxModel(Names));
    //   52  111:aload_0         
    //   53  112:getfield        #64  <Field JComboBox m_Combo>
    //   54  115:new             #191 <Class DefaultComboBoxModel>
    //   55  118:dup             
    //   56  119:aload_1         
    //   57  120:invokespecial   #194 <Method void DefaultComboBoxModel(Object[])>
    //   58  123:invokevirtual   #198 <Method void JComboBox.setModel(javax.swing.ComboBoxModel)>
        m_Combo.setEnabled(true);
    //   59  126:aload_0         
    //   60  127:getfield        #64  <Field JComboBox m_Combo>
    //   61  130:iconst_1        
    //   62  131:invokevirtual   #202 <Method void JComboBox.setEnabled(boolean)>
        t_NameTable[0] = new JTable();
    //   63  134:aload_0         
    //   64  135:getfield        #134 <Field JTable[] t_NameTable>
    //   65  138:iconst_0        
    //   66  139:new             #132 <Class JTable>
    //   67  142:dup             
    //   68  143:invokespecial   #203 <Method void JTable()>
    //   69  146:aastore         
        DefaultTableModel dtmuser = (DefaultTableModel)t_NameTable[0].getModel();
    //   70  147:aload_0         
    //   71  148:getfield        #134 <Field JTable[] t_NameTable>
    //   72  151:iconst_0        
    //   73  152:aaload          
    //   74  153:invokevirtual   #207 <Method javax.swing.table.TableModel JTable.getModel()>
    //   75  156:checkcast       #209 <Class DefaultTableModel>
    //   76  159:astore_2        
        dtmuser.setColumnIdentifiers(new Object[] {
            "No.", "Users"
        });
    //   77  160:aload_2         
    //   78  161:iconst_2        
    //   79  162:anewarray       Object[]
    //   80  165:dup             
    //   81  166:iconst_0        
    //   82  167:ldc1            #213 <String "No.">
    //   83  169:aastore         
    //   84  170:dup             
    //   85  171:iconst_1        
    //   86  172:ldc1            #214 <String "Users">
    //   87  174:aastore         
    //   88  175:invokevirtual   #217 <Method void DefaultTableModel.setColumnIdentifiers(Object[])>
        for(int i = 1; i <= m_Assignment.getAssignmentMatrix().getRowDimension(); i++)
    //*  89  178:iconst_1        
    //*  90  179:istore_3        
    //*  91  180:goto            221
        {
            Object temp[] = new Object[2];
    //   92  183:iconst_2        
    //   93  184:anewarray       Object[]
    //   94  187:astore          4
            temp[0] = Integer.valueOf(i);
    //   95  189:aload           4
    //   96  191:iconst_0        
    //   97  192:iload_3         
    //   98  193:invokestatic    #223 <Method Integer Integer.valueOf(int)>
    //   99  196:aastore         
            temp[1] = (String)Users[i - 1];
    //  100  197:aload           4
    //  101  199:iconst_1        
    //  102  200:aload_0         
    //  103  201:getfield        #140 <Field Object[] Users>
    //  104  204:iload_3         
    //  105  205:iconst_1        
    //  106  206:isub            
    //  107  207:aaload          
    //  108  208:checkcast       #173 <Class String>
    //  109  211:aastore         
            dtmuser.addRow(temp);
    //  110  212:aload_2         
    //  111  213:aload           4
    //  112  215:invokevirtual   #226 <Method void DefaultTableModel.addRow(Object[])>
        }

    //  113  218:iinc            3  1
    //  114  221:iload_3         
    //  115  222:aload_0         
    //  116  223:getfield        #92  <Field Assignment m_Assignment>
    //  117  226:invokevirtual   #127 <Method Matrix Assignment.getAssignmentMatrix()>
    //  118  229:invokevirtual   #231 <Method int Matrix.getRowDimension()>
    //  119  232:icmple          183
        t_NameTable[1] = new JTable();
    //  120  235:aload_0         
    //  121  236:getfield        #134 <Field JTable[] t_NameTable>
    //  122  239:iconst_1        
    //  123  240:new             #132 <Class JTable>
    //  124  243:dup             
    //  125  244:invokespecial   #203 <Method void JTable()>
    //  126  247:aastore         
        DefaultTableModel dtmperm = (DefaultTableModel)t_NameTable[1].getModel();
    //  127  248:aload_0         
    //  128  249:getfield        #134 <Field JTable[] t_NameTable>
    //  129  252:iconst_1        
    //  130  253:aaload          
    //  131  254:invokevirtual   #207 <Method javax.swing.table.TableModel JTable.getModel()>
    //  132  257:checkcast       #209 <Class DefaultTableModel>
    //  133  260:astore_3        
        dtmperm.setColumnIdentifiers(new Object[] {
            "No.", "Perms"
        });
    //  134  261:aload_3         
    //  135  262:iconst_2        
    //  136  263:anewarray       Object[]
    //  137  266:dup             
    //  138  267:iconst_0        
    //  139  268:ldc1            #213 <String "No.">
    //  140  270:aastore         
    //  141  271:dup             
    //  142  272:iconst_1        
    //  143  273:ldc1            #232 <String "Perms">
    //  144  275:aastore         
    //  145  276:invokevirtual   #217 <Method void DefaultTableModel.setColumnIdentifiers(Object[])>
        for(int i = 1; i <= m_Assignment.getAssignmentMatrix().getColumnDimension(); i++)
    //* 146  279:iconst_1        
    //* 147  280:istore          4
    //* 148  282:goto            325
        {
            Object temp[] = new Object[2];
    //  149  285:iconst_2        
    //  150  286:anewarray       Object[]
    //  151  289:astore          5
            temp[0] = Integer.valueOf(i);
    //  152  291:aload           5
    //  153  293:iconst_0        
    //  154  294:iload           4
    //  155  296:invokestatic    #223 <Method Integer Integer.valueOf(int)>
    //  156  299:aastore         
            temp[1] = (String)Perms[i - 1];
    //  157  300:aload           5
    //  158  302:iconst_1        
    //  159  303:aload_0         
    //  160  304:getfield        #142 <Field Object[] Perms>
    //  161  307:iload           4
    //  162  309:iconst_1        
    //  163  310:isub            
    //  164  311:aaload          
    //  165  312:checkcast       #173 <Class String>
    //  166  315:aastore         
            dtmperm.addRow(temp);
    //  167  316:aload_3         
    //  168  317:aload           5
    //  169  319:invokevirtual   #226 <Method void DefaultTableModel.addRow(Object[])>
        }

    //  170  322:iinc            4  1
    //  171  325:iload           4
    //  172  327:aload_0         
    //  173  328:getfield        #92  <Field Assignment m_Assignment>
    //  174  331:invokevirtual   #127 <Method Matrix Assignment.getAssignmentMatrix()>
    //  175  334:invokevirtual   #235 <Method int Matrix.getColumnDimension()>
    //  176  337:icmple          285
        m_openBut.setToolTipText("Loads previously saved instances from a file");
    //  177  340:aload_0         
    //  178  341:getfield        #75  <Field JButton m_openBut>
    //  179  344:ldc1            #237 <String "Loads previously saved instances from a file">
    //  180  346:invokevirtual   #238 <Method void JButton.setToolTipText(String)>
        JPanel combos = new JPanel();
    //  181  349:new             #4   <Class JPanel>
    //  182  352:dup             
    //  183  353:invokespecial   #32  <Method void JPanel()>
    //  184  356:astore          4
        GridBagLayout gb = new GridBagLayout();
    //  185  358:new             #240 <Class GridBagLayout>
    //  186  361:dup             
    //  187  362:invokespecial   #241 <Method void GridBagLayout()>
    //  188  365:astore          5
        final GridBagConstraints constraints = new GridBagConstraints();
    //  189  367:new             #243 <Class GridBagConstraints>
    //  190  370:dup             
    //  191  371:invokespecial   #244 <Method void GridBagConstraints()>
    //  192  374:astore          6
        m_Combo.setLightWeightPopupEnabled(false);
    //  193  376:aload_0         
    //  194  377:getfield        #64  <Field JComboBox m_Combo>
    //  195  380:iconst_0        
    //  196  381:invokevirtual   #247 <Method void JComboBox.setLightWeightPopupEnabled(boolean)>
        combos.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
    //  197  384:aload           4
    //  198  386:bipush          10
    //  199  388:iconst_5        
    //  200  389:bipush          10
    //  201  391:iconst_5        
    //  202  392:invokestatic    #253 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  203  395:invokevirtual   #257 <Method void JPanel.setBorder(javax.swing.border.Border)>
        combos.setLayout(gb);
    //  204  398:aload           4
    //  205  400:aload           5
    //  206  402:invokevirtual   #261 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        constraints.gridx = 0;
    //  207  405:aload           6
    //  208  407:iconst_0        
    //  209  408:putfield        #264 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  210  411:aload           6
    //  211  413:iconst_0        
    //  212  414:putfield        #267 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  213  417:aload           6
    //  214  419:ldc2w           #268 <Double 5D>
    //  215  422:putfield        #273 <Field double GridBagConstraints.weightx>
        constraints.fill = 2;
    //  216  425:aload           6
    //  217  427:iconst_2        
    //  218  428:putfield        #276 <Field int GridBagConstraints.fill>
        constraints.gridwidth = 2;
    //  219  431:aload           6
    //  220  433:iconst_2        
    //  221  434:putfield        #279 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  222  437:aload           6
    //  223  439:iconst_1        
    //  224  440:putfield        #282 <Field int GridBagConstraints.gridheight>
        constraints.insets = new Insets(0, 2, 0, 2);
    //  225  443:aload           6
    //  226  445:new             #284 <Class Insets>
    //  227  448:dup             
    //  228  449:iconst_0        
    //  229  450:iconst_2        
    //  230  451:iconst_0        
    //  231  452:iconst_2        
    //  232  453:invokespecial   #287 <Method void Insets(int, int, int, int)>
    //  233  456:putfield        #291 <Field Insets GridBagConstraints.insets>
        combos.add(m_Combo, constraints);
    //  234  459:aload           4
    //  235  461:aload_0         
    //  236  462:getfield        #64  <Field JComboBox m_Combo>
    //  237  465:aload           6
    //  238  467:invokevirtual   #295 <Method void JPanel.add(java.awt.Component, Object)>
        JPanel mbts = new JPanel();
    //  239  470:new             #4   <Class JPanel>
    //  240  473:dup             
    //  241  474:invokespecial   #32  <Method void JPanel()>
    //  242  477:astore          7
        mbts.setLayout(new GridLayout(1, 2));
    //  243  479:aload           7
    //  244  481:new             #297 <Class GridLayout>
    //  245  484:dup             
    //  246  485:iconst_1        
    //  247  486:iconst_2        
    //  248  487:invokespecial   #298 <Method void GridLayout(int, int)>
    //  249  490:invokevirtual   #261 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        mbts.add(m_cancel);
    //  250  493:aload           7
    //  251  495:aload_0         
    //  252  496:getfield        #71  <Field JButton m_cancel>
    //  253  499:invokevirtual   #301 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  254  502:pop             
        mbts.add(m_openBut);
    //  255  503:aload           7
    //  256  505:aload_0         
    //  257  506:getfield        #75  <Field JButton m_openBut>
    //  258  509:invokevirtual   #301 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  259  512:pop             
        constraints.gridx = 2;
    //  260  513:aload           6
    //  261  515:iconst_2        
    //  262  516:putfield        #264 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  263  519:aload           6
    //  264  521:iconst_0        
    //  265  522:putfield        #267 <Field int GridBagConstraints.gridy>
        constraints.weightx = 5D;
    //  266  525:aload           6
    //  267  527:ldc2w           #268 <Double 5D>
    //  268  530:putfield        #273 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 2;
    //  269  533:aload           6
    //  270  535:iconst_2        
    //  271  536:putfield        #279 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  272  539:aload           6
    //  273  541:iconst_1        
    //  274  542:putfield        #282 <Field int GridBagConstraints.gridheight>
        combos.add(mbts, constraints);
    //  275  545:aload           4
    //  276  547:aload           7
    //  277  549:aload           6
    //  278  551:invokevirtual   #295 <Method void JPanel.add(java.awt.Component, Object)>
        m_cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_colorSurround.removeAll();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:getfield        #28  <Field JPanel VisualizePanel.m_colorSurround>
            //    3    7:invokevirtual   #33  <Method void JPanel.removeAll()>
                repaint();
            //    4   10:aload_0         
            //    5   11:getfield        #13  <Field VisualizePanel this$0>
            //    6   14:invokevirtual   #36  <Method void VisualizePanel.repaint()>
            //    7   17:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  279  554:aload_0         
    //  280  555:getfield        #71  <Field JButton m_cancel>
    //  281  558:new             #303 <Class VisualizePanel$1>
    //  282  561:dup             
    //  283  562:aload_0         
    //  284  563:invokespecial   #306 <Method void VisualizePanel$1(VisualizePanel)>
    //  285  566:invokevirtual   #310 <Method void JButton.addActionListener(ActionListener)>
        m_openBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                openFile();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field VisualizePanel this$0>
            //    2    4:invokestatic    #27  <Method void VisualizePanel.access$0(VisualizePanel)>
                repaint();
            //    3    7:aload_0         
            //    4    8:getfield        #13  <Field VisualizePanel this$0>
            //    5   11:invokevirtual   #30  <Method void VisualizePanel.repaint()>
            //    6   14:return          
            }

            final VisualizePanel this$0;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field VisualizePanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  286  569:aload_0         
    //  287  570:getfield        #75  <Field JButton m_openBut>
    //  288  573:new             #312 <Class VisualizePanel$2>
    //  289  576:dup             
    //  290  577:aload_0         
    //  291  578:invokespecial   #313 <Method void VisualizePanel$2(VisualizePanel)>
    //  292  581:invokevirtual   #310 <Method void JButton.addActionListener(ActionListener)>
        GridBagLayout gb2 = new GridBagLayout();
    //  293  584:new             #240 <Class GridBagLayout>
    //  294  587:dup             
    //  295  588:invokespecial   #241 <Method void GridBagLayout()>
    //  296  591:astore          8
        m_colorSurround.setBorder(BorderFactory.createTitledBorder("Visual Assessment"));
    //  297  593:aload_0         
    //  298  594:getfield        #34  <Field JPanel m_colorSurround>
    //  299  597:ldc2            #315 <String "Visual Assessment">
    //  300  600:invokestatic    #319 <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //  301  603:invokevirtual   #257 <Method void JPanel.setBorder(javax.swing.border.Border)>
        m_colorSurround.setLayout(gb2);
    //  302  606:aload_0         
    //  303  607:getfield        #34  <Field JPanel m_colorSurround>
    //  304  610:aload           8
    //  305  612:invokevirtual   #261 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        constraints.fill = 1;
    //  306  615:aload           6
    //  307  617:iconst_1        
    //  308  618:putfield        #276 <Field int GridBagConstraints.fill>
        constraints.insets = new Insets(5, 5, 0, 10);
    //  309  621:aload           6
    //  310  623:new             #284 <Class Insets>
    //  311  626:dup             
    //  312  627:iconst_5        
    //  313  628:iconst_5        
    //  314  629:iconst_0        
    //  315  630:bipush          10
    //  316  632:invokespecial   #287 <Method void Insets(int, int, int, int)>
    //  317  635:putfield        #291 <Field Insets GridBagConstraints.insets>
        constraints.gridx = 0;
    //  318  638:aload           6
    //  319  640:iconst_0        
    //  320  641:putfield        #264 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  321  644:aload           6
    //  322  646:iconst_0        
    //  323  647:putfield        #267 <Field int GridBagConstraints.gridy>
        constraints.weightx = 3D;
    //  324  650:aload           6
    //  325  652:ldc2w           #320 <Double 3D>
    //  326  655:putfield        #273 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 4;
    //  327  658:aload           6
    //  328  660:iconst_4        
    //  329  661:putfield        #279 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  330  664:aload           6
    //  331  666:iconst_1        
    //  332  667:putfield        #282 <Field int GridBagConstraints.gridheight>
        constraints.weighty = 5D;
    //  333  670:aload           6
    //  334  672:ldc2w           #268 <Double 5D>
    //  335  675:putfield        #324 <Field double GridBagConstraints.weighty>
        m_colorSurround.add(Similarity[0], constraints);
    //  336  678:aload_0         
    //  337  679:getfield        #34  <Field JPanel m_colorSurround>
    //  338  682:aload_0         
    //  339  683:getfield        #96  <Field Colorsimilar[] Similarity>
    //  340  686:iconst_0        
    //  341  687:aaload          
    //  342  688:aload           6
    //  343  690:invokevirtual   #295 <Method void JPanel.add(java.awt.Component, Object)>
        m_Combo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                int selected = m_Combo.getSelectedIndex();
            //    0    0:aload_0         
            //    1    1:getfield        #15  <Field VisualizePanel this$0>
            //    2    4:getfield        #32  <Field JComboBox VisualizePanel.m_Combo>
            //    3    7:invokevirtual   #38  <Method int JComboBox.getSelectedIndex()>
            //    4   10:istore_2        
                if(selected < 0)
            //*   5   11:iload_2         
            //*   6   12:ifge            17
                    selected = 0;
            //    7   15:iconst_0        
            //    8   16:istore_2        
                m_colorSurround.removeAll();
            //    9   17:aload_0         
            //   10   18:getfield        #15  <Field VisualizePanel this$0>
            //   11   21:getfield        #42  <Field JPanel VisualizePanel.m_colorSurround>
            //   12   24:invokevirtual   #47  <Method void JPanel.removeAll()>
                constraints.insets = new Insets(5, 5, 0, 10);
            //   13   27:aload_0         
            //   14   28:getfield        #17  <Field GridBagConstraints val$constraints>
            //   15   31:new             #49  <Class Insets>
            //   16   34:dup             
            //   17   35:iconst_5        
            //   18   36:iconst_5        
            //   19   37:iconst_0        
            //   20   38:bipush          10
            //   21   40:invokespecial   #52  <Method void Insets(int, int, int, int)>
            //   22   43:putfield        #58  <Field Insets GridBagConstraints.insets>
                constraints.gridx = 0;
            //   23   46:aload_0         
            //   24   47:getfield        #17  <Field GridBagConstraints val$constraints>
            //   25   50:iconst_0        
            //   26   51:putfield        #62  <Field int GridBagConstraints.gridx>
                constraints.gridy = 0;
            //   27   54:aload_0         
            //   28   55:getfield        #17  <Field GridBagConstraints val$constraints>
            //   29   58:iconst_0        
            //   30   59:putfield        #65  <Field int GridBagConstraints.gridy>
                constraints.weightx = 3D;
            //   31   62:aload_0         
            //   32   63:getfield        #17  <Field GridBagConstraints val$constraints>
            //   33   66:ldc2w           #66  <Double 3D>
            //   34   69:putfield        #71  <Field double GridBagConstraints.weightx>
                constraints.gridwidth = 4;
            //   35   72:aload_0         
            //   36   73:getfield        #17  <Field GridBagConstraints val$constraints>
            //   37   76:iconst_4        
            //   38   77:putfield        #74  <Field int GridBagConstraints.gridwidth>
                constraints.gridheight = 1;
            //   39   80:aload_0         
            //   40   81:getfield        #17  <Field GridBagConstraints val$constraints>
            //   41   84:iconst_1        
            //   42   85:putfield        #77  <Field int GridBagConstraints.gridheight>
                constraints.weighty = 5D;
            //   43   88:aload_0         
            //   44   89:getfield        #17  <Field GridBagConstraints val$constraints>
            //   45   92:ldc2w           #78  <Double 5D>
            //   46   95:putfield        #82  <Field double GridBagConstraints.weighty>
                m_colorSurround.add(Similarity[selected], constraints);
            //   47   98:aload_0         
            //   48   99:getfield        #15  <Field VisualizePanel this$0>
            //   49  102:getfield        #42  <Field JPanel VisualizePanel.m_colorSurround>
            //   50  105:aload_0         
            //   51  106:getfield        #15  <Field VisualizePanel this$0>
            //   52  109:getfield        #86  <Field Colorsimilar[] VisualizePanel.Similarity>
            //   53  112:iload_2         
            //   54  113:aaload          
            //   55  114:aload_0         
            //   56  115:getfield        #17  <Field GridBagConstraints val$constraints>
            //   57  118:invokevirtual   #90  <Method void JPanel.add(java.awt.Component, Object)>
                constraints.insets = new Insets(5, 5, 0, 0);
            //   58  121:aload_0         
            //   59  122:getfield        #17  <Field GridBagConstraints val$constraints>
            //   60  125:new             #49  <Class Insets>
            //   61  128:dup             
            //   62  129:iconst_5        
            //   63  130:iconst_5        
            //   64  131:iconst_0        
            //   65  132:iconst_0        
            //   66  133:invokespecial   #52  <Method void Insets(int, int, int, int)>
            //   67  136:putfield        #58  <Field Insets GridBagConstraints.insets>
                constraints.gridx = 4;
            //   68  139:aload_0         
            //   69  140:getfield        #17  <Field GridBagConstraints val$constraints>
            //   70  143:iconst_4        
            //   71  144:putfield        #62  <Field int GridBagConstraints.gridx>
                constraints.gridy = 0;
            //   72  147:aload_0         
            //   73  148:getfield        #17  <Field GridBagConstraints val$constraints>
            //   74  151:iconst_0        
            //   75  152:putfield        #65  <Field int GridBagConstraints.gridy>
                constraints.weightx = 1.0D;
            //   76  155:aload_0         
            //   77  156:getfield        #17  <Field GridBagConstraints val$constraints>
            //   78  159:dconst_1        
            //   79  160:putfield        #71  <Field double GridBagConstraints.weightx>
                constraints.gridwidth = 1;
            //   80  163:aload_0         
            //   81  164:getfield        #17  <Field GridBagConstraints val$constraints>
            //   82  167:iconst_1        
            //   83  168:putfield        #74  <Field int GridBagConstraints.gridwidth>
                constraints.gridheight = 1;
            //   84  171:aload_0         
            //   85  172:getfield        #17  <Field GridBagConstraints val$constraints>
            //   86  175:iconst_1        
            //   87  176:putfield        #77  <Field int GridBagConstraints.gridheight>
                constraints.weighty = 5D;
            //   88  179:aload_0         
            //   89  180:getfield        #17  <Field GridBagConstraints val$constraints>
            //   90  183:ldc2w           #78  <Double 5D>
            //   91  186:putfield        #82  <Field double GridBagConstraints.weighty>
                m_colorSurround.add(new JScrollPane(t_NameTable[selected]), constraints);
            //   92  189:aload_0         
            //   93  190:getfield        #15  <Field VisualizePanel this$0>
            //   94  193:getfield        #42  <Field JPanel VisualizePanel.m_colorSurround>
            //   95  196:new             #92  <Class JScrollPane>
            //   96  199:dup             
            //   97  200:aload_0         
            //   98  201:getfield        #15  <Field VisualizePanel this$0>
            //   99  204:getfield        #96  <Field JTable[] VisualizePanel.t_NameTable>
            //  100  207:iload_2         
            //  101  208:aaload          
            //  102  209:invokespecial   #99  <Method void JScrollPane(java.awt.Component)>
            //  103  212:aload_0         
            //  104  213:getfield        #17  <Field GridBagConstraints val$constraints>
            //  105  216:invokevirtual   #90  <Method void JPanel.add(java.awt.Component, Object)>
                repaint();
            //  106  219:aload_0         
            //  107  220:getfield        #15  <Field VisualizePanel this$0>
            //  108  223:invokevirtual   #102 <Method void VisualizePanel.repaint()>
            //  109  226:return          
            }

            final VisualizePanel this$0;
            private final GridBagConstraints val$constraints;

            
            {
                this$0 = VisualizePanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field VisualizePanel this$0>
                constraints = gridbagconstraints;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field GridBagConstraints val$constraints>
                super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
        }
);
    //  344  693:aload_0         
    //  345  694:getfield        #64  <Field JComboBox m_Combo>
    //  346  697:new             #326 <Class VisualizePanel$3>
    //  347  700:dup             
    //  348  701:aload_0         
    //  349  702:aload           6
    //  350  704:invokespecial   #329 <Method void VisualizePanel$3(VisualizePanel, GridBagConstraints)>
    //  351  707:invokevirtual   #330 <Method void JComboBox.addActionListener(ActionListener)>
        constraints.insets = new Insets(5, 5, 0, 0);
    //  352  710:aload           6
    //  353  712:new             #284 <Class Insets>
    //  354  715:dup             
    //  355  716:iconst_5        
    //  356  717:iconst_5        
    //  357  718:iconst_0        
    //  358  719:iconst_0        
    //  359  720:invokespecial   #287 <Method void Insets(int, int, int, int)>
    //  360  723:putfield        #291 <Field Insets GridBagConstraints.insets>
        constraints.gridx = 4;
    //  361  726:aload           6
    //  362  728:iconst_4        
    //  363  729:putfield        #264 <Field int GridBagConstraints.gridx>
        constraints.gridy = 0;
    //  364  732:aload           6
    //  365  734:iconst_0        
    //  366  735:putfield        #267 <Field int GridBagConstraints.gridy>
        constraints.weightx = 1.0D;
    //  367  738:aload           6
    //  368  740:dconst_1        
    //  369  741:putfield        #273 <Field double GridBagConstraints.weightx>
        constraints.gridwidth = 1;
    //  370  744:aload           6
    //  371  746:iconst_1        
    //  372  747:putfield        #279 <Field int GridBagConstraints.gridwidth>
        constraints.gridheight = 1;
    //  373  750:aload           6
    //  374  752:iconst_1        
    //  375  753:putfield        #282 <Field int GridBagConstraints.gridheight>
        constraints.weighty = 5D;
    //  376  756:aload           6
    //  377  758:ldc2w           #268 <Double 5D>
    //  378  761:putfield        #324 <Field double GridBagConstraints.weighty>
        m_colorSurround.add(new JScrollPane(t_NameTable[0]), constraints);
    //  379  764:aload_0         
    //  380  765:getfield        #34  <Field JPanel m_colorSurround>
    //  381  768:new             #332 <Class JScrollPane>
    //  382  771:dup             
    //  383  772:aload_0         
    //  384  773:getfield        #134 <Field JTable[] t_NameTable>
    //  385  776:iconst_0        
    //  386  777:aaload          
    //  387  778:invokespecial   #335 <Method void JScrollPane(java.awt.Component)>
    //  388  781:aload           6
    //  389  783:invokevirtual   #295 <Method void JPanel.add(java.awt.Component, Object)>
        setLayout(new BorderLayout());
    //  390  786:aload_0         
    //  391  787:new             #337 <Class BorderLayout>
    //  392  790:dup             
    //  393  791:invokespecial   #338 <Method void BorderLayout()>
    //  394  794:invokevirtual   #339 <Method void setLayout(java.awt.LayoutManager)>
        add(combos, "North");
    //  395  797:aload_0         
    //  396  798:aload           4
    //  397  800:ldc2            #341 <String "North">
    //  398  803:invokevirtual   #342 <Method void add(java.awt.Component, Object)>
        add(m_colorSurround, "Center");
    //  399  806:aload_0         
    //  400  807:aload_0         
    //  401  808:getfield        #34  <Field JPanel m_colorSurround>
    //  402  811:ldc2            #344 <String "Center">
    //  403  814:invokevirtual   #342 <Method void add(java.awt.Component, Object)>
    //  404  817:return          
    }

    private void openFile()
    {
        JFileChooser m_FileChooser = new JFileChooser();
    //    0    0:new             #41  <Class JFileChooser>
    //    1    3:dup             
    //    2    4:invokespecial   #360 <Method void JFileChooser()>
    //    3    7:astore_1        
        int Fileflag = -1;
    //    4    8:iconst_m1       
    //    5    9:istore_2        
        m_FileChooser.setDialogTitle("\u8F7D\u5165\u6743\u9650\u6307\u6D3E\u6587\u4EF6\uFF01");
    //    6   10:aload_1         
    //    7   11:ldc2            #362 <String "\u8F7D\u5165\u6743\u9650\u6307\u6D3E\u6587\u4EF6\uFF01">
    //    8   14:invokevirtual   #365 <Method void JFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //    9   17:aload_1         
    //   10   18:new             #43  <Class File>
    //   11   21:dup             
    //   12   22:ldc1            #45  <String "user.dir">
    //   13   24:invokestatic    #51  <Method String System.getProperty(String)>
    //   14   27:invokespecial   #54  <Method void File(String)>
    //   15   30:invokevirtual   #368 <Method void JFileChooser.setCurrentDirectory(File)>
        try
        {
            Fileflag = m_FileChooser.showOpenDialog(this);
    //   16   33:aload_1         
    //   17   34:aload_0         
    //   18   35:invokevirtual   #372 <Method int JFileChooser.showOpenDialog(java.awt.Component)>
    //   19   38:istore_2        
        }
    //*  20   39:goto            55
        catch(HeadlessException head)
    //*  21   42:astore_3        
        {
            m_Log.logMessage("Open File Dialog ERROR!");
    //   22   43:aload_0         
    //   23   44:getfield        #39  <Field Logger m_Log>
    //   24   47:ldc2            #374 <String "Open File Dialog ERROR!">
    //   25   50:invokeinterface #379 <Method void Logger.logMessage(String)>
        }
        if(Fileflag == 0)
    //*  26   55:iload_2         
    //*  27   56:ifne            149
        {
            File SelectedFile = m_FileChooser.getSelectedFile();
    //   28   59:aload_1         
    //   29   60:invokevirtual   #383 <Method File JFileChooser.getSelectedFile()>
    //   30   63:astore_3        
            try
            {
                AssLoader AssData = new AssLoader(new FileReader(SelectedFile));
    //   31   64:new             #385 <Class AssLoader>
    //   32   67:dup             
    //   33   68:new             #387 <Class FileReader>
    //   34   71:dup             
    //   35   72:aload_3         
    //   36   73:invokespecial   #388 <Method void FileReader(File)>
    //   37   76:invokespecial   #391 <Method void AssLoader(FileReader)>
    //   38   79:astore          4
                m_Assignment = AssData.getData();
    //   39   81:aload_0         
    //   40   82:aload           4
    //   41   84:invokevirtual   #395 <Method Assignment AssLoader.getData()>
    //   42   87:putfield        #92  <Field Assignment m_Assignment>
                removeAll();
    //   43   90:aload_0         
    //   44   91:invokevirtual   #398 <Method void removeAll()>
                paintPanel();
    //   45   94:aload_0         
    //   46   95:invokespecial   #145 <Method void paintPanel()>
                m_Log.statusMessage("Open an Assignment File");
    //   47   98:aload_0         
    //   48   99:getfield        #39  <Field Logger m_Log>
    //   49  102:ldc2            #400 <String "Open an Assignment File">
    //   50  105:invokeinterface #403 <Method void Logger.statusMessage(String)>
                m_Log.logMessage((new StringBuilder("Load the assignment file: ")).append(SelectedFile.getName()).toString());
    //   51  110:aload_0         
    //   52  111:getfield        #39  <Field Logger m_Log>
    //   53  114:new             #175 <Class StringBuilder>
    //   54  117:dup             
    //   55  118:ldc2            #405 <String "Load the assignment file: ">
    //   56  121:invokespecial   #178 <Method void StringBuilder(String)>
    //   57  124:aload_3         
    //   58  125:invokevirtual   #406 <Method String File.getName()>
    //   59  128:invokevirtual   #186 <Method StringBuilder StringBuilder.append(String)>
    //   60  131:invokevirtual   #189 <Method String StringBuilder.toString()>
    //   61  134:invokeinterface #379 <Method void Logger.logMessage(String)>
            }
    //*  62  139:goto            149
            catch(Exception e)
    //*  63  142:astore          4
            {
                e.printStackTrace();
    //   64  144:aload           4
    //   65  146:invokevirtual   #411 <Method void Exception.printStackTrace()>
            }
        }
    //   66  149:return          
    }

    public void setAssignments(Assignment assign)
    {
        m_Assignment = assign;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #92  <Field Assignment m_Assignment>
    //    3    5:return          
    }

    public JPanel getJPanel()
    {
        return this;
    //    0    0:aload_0         
    //    1    1:areturn         
    }

    public void setLog(Logger newLog)
    {
        m_Log = newLog;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #39  <Field Logger m_Log>
    //    3    5:return          
    }

    public static void main(String args[])
    {
        final JFrame jf = new JFrame("RMiner Explorer: Visualize");
    //    0    0:new             #433 <Class JFrame>
    //    1    3:dup             
    //    2    4:ldc2            #435 <String "RMiner Explorer: Visualize">
    //    3    7:invokespecial   #436 <Method void JFrame(String)>
    //    4   10:astore_1        
        jf.setSize(800, 600);
    //    5   11:aload_1         
    //    6   12:sipush          800
    //    7   15:sipush          600
    //    8   18:invokevirtual   #439 <Method void JFrame.setSize(int, int)>
        jf.getContentPane().setLayout(new BorderLayout());
    //    9   21:aload_1         
    //   10   22:invokevirtual   #443 <Method Container JFrame.getContentPane()>
    //   11   25:new             #337 <Class BorderLayout>
    //   12   28:dup             
    //   13   29:invokespecial   #338 <Method void BorderLayout()>
    //   14   32:invokevirtual   #446 <Method void Container.setLayout(java.awt.LayoutManager)>
        VisualizePanel sp = new VisualizePanel(null);
    //   15   35:new             #2   <Class VisualizePanel>
    //   16   38:dup             
    //   17   39:aconst_null     
    //   18   40:invokespecial   #448 <Method void VisualizePanel(Assignment)>
    //   19   43:astore_2        
        jf.getContentPane().add(sp, "Center");
    //   20   44:aload_1         
    //   21   45:invokevirtual   #443 <Method Container JFrame.getContentPane()>
    //   22   48:aload_2         
    //   23   49:ldc2            #344 <String "Center">
    //   24   52:invokevirtual   #449 <Method void Container.add(java.awt.Component, Object)>
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
    //   25   55:aload_1         
    //   26   56:new             #451 <Class VisualizePanel$4>
    //   27   59:dup             
    //   28   60:aload_1         
    //   29   61:invokespecial   #454 <Method void VisualizePanel$4(JFrame)>
    //   30   64:invokevirtual   #458 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
        jf.setVisible(true);
    //   31   67:aload_1         
    //   32   68:iconst_1        
    //   33   69:invokevirtual   #461 <Method void JFrame.setVisible(boolean)>
    //   34   72:return          
    }

    protected Assignment m_Assignment;
    protected JPanel m_colorSurround;
    protected Logger m_Log;
    protected JFileChooser m_FileChooser;
    protected JComboBox m_Combo;
    protected JButton m_cancel;
    protected JButton m_openBut;
    private Dimension COMBO_SIZE;
    JTable t_NameTable[];
    Colorsimilar Similarity[];
    Object Users[];
    Object Perms[];


/*
    static void access$0(VisualizePanel visualizepanel)
    {
        visualizepanel.openFile();
    //    0    0:aload_0         
    //    1    1:invokespecial   #468 <Method void openFile()>
        return;
    //    2    4:return          
    }

*/
}

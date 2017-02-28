// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AccuracyDialog.java

package rm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import rm.core.*;
import rm.core.converters.AssLoader;
import rm.gui.explorer.ExplorerDefaults;

// Referenced classes of package rm.gui:
//            ConverterFileChooser

public class AccuracyDialog extends JPanel
{

    public AccuracyDialog()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #30  <Method void JPanel()>
        m_FileChooser = new ConverterFileChooser(new File(ExplorerDefaults.getInitialDirectory()));
    //    2    4:aload_0         
    //    3    5:new             #32  <Class ConverterFileChooser>
    //    4    8:dup             
    //    5    9:new             #34  <Class File>
    //    6   12:dup             
    //    7   13:invokestatic    #40  <Method String ExplorerDefaults.getInitialDirectory()>
    //    8   16:invokespecial   #43  <Method void File(String)>
    //    9   19:invokespecial   #46  <Method void ConverterFileChooser(File)>
    //   10   22:putfield        #48  <Field ConverterFileChooser m_FileChooser>
        SelectedFile = null;
    //   11   25:aload_0         
    //   12   26:aconst_null     
    //   13   27:putfield        #50  <Field File SelectedFile>
        AssData = null;
    //   14   30:aload_0         
    //   15   31:aconst_null     
    //   16   32:putfield        #52  <Field AssLoader AssData>
        setLayout(new BorderLayout());
    //   17   35:aload_0         
    //   18   36:new             #54  <Class BorderLayout>
    //   19   39:dup             
    //   20   40:invokespecial   #55  <Method void BorderLayout()>
    //   21   43:invokevirtual   #59  <Method void setLayout(java.awt.LayoutManager)>
        JPanel loadPanel = new JPanel();
    //   22   46:new             #4   <Class JPanel>
    //   23   49:dup             
    //   24   50:invokespecial   #30  <Method void JPanel()>
    //   25   53:astore_1        
        JButton origBut = new JButton("Original Roles");
    //   26   54:new             #61  <Class JButton>
    //   27   57:dup             
    //   28   58:ldc1            #63  <String "Original Roles">
    //   29   60:invokespecial   #64  <Method void JButton(String)>
    //   30   63:astore_2        
        origBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                originalRoles = LoadRoleFile();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AccuracyDialog this$0>
            //    2    4:aload_0         
            //    3    5:getfield        #13  <Field AccuracyDialog this$0>
            //    4    8:invokevirtual   #28  <Method Assignment AccuracyDialog.LoadRoleFile()>
            //    5   11:putfield        #32  <Field Assignment AccuracyDialog.originalRoles>
                setRoleInfor(originalRoles, origtxt, SelectedFile);
            //    6   14:aload_0         
            //    7   15:getfield        #13  <Field AccuracyDialog this$0>
            //    8   18:aload_0         
            //    9   19:getfield        #13  <Field AccuracyDialog this$0>
            //   10   22:getfield        #32  <Field Assignment AccuracyDialog.originalRoles>
            //   11   25:aload_0         
            //   12   26:getfield        #13  <Field AccuracyDialog this$0>
            //   13   29:invokestatic    #36  <Method JTextField AccuracyDialog.access$0(AccuracyDialog)>
            //   14   32:aload_0         
            //   15   33:getfield        #13  <Field AccuracyDialog this$0>
            //   16   36:getfield        #40  <Field File AccuracyDialog.SelectedFile>
            //   17   39:invokestatic    #44  <Method void AccuracyDialog.access$1(AccuracyDialog, Assignment, JTextField, File)>
                if(originalRoles != null && generatedRoles != null)
            //*  18   42:aload_0         
            //*  19   43:getfield        #13  <Field AccuracyDialog this$0>
            //*  20   46:getfield        #32  <Field Assignment AccuracyDialog.originalRoles>
            //*  21   49:ifnull          76
            //*  22   52:aload_0         
            //*  23   53:getfield        #13  <Field AccuracyDialog this$0>
            //*  24   56:getfield        #47  <Field Assignment AccuracyDialog.generatedRoles>
            //*  25   59:ifnull          76
                    cButton.setEnabled(true);
            //   26   62:aload_0         
            //   27   63:getfield        #13  <Field AccuracyDialog this$0>
            //   28   66:invokestatic    #51  <Method JButton AccuracyDialog.access$2(AccuracyDialog)>
            //   29   69:iconst_1        
            //   30   70:invokevirtual   #57  <Method void JButton.setEnabled(boolean)>
                else
            //*  31   73:goto            87
                    cButton.setEnabled(false);
            //   32   76:aload_0         
            //   33   77:getfield        #13  <Field AccuracyDialog this$0>
            //   34   80:invokestatic    #51  <Method JButton AccuracyDialog.access$2(AccuracyDialog)>
            //   35   83:iconst_0        
            //   36   84:invokevirtual   #57  <Method void JButton.setEnabled(boolean)>
            //   37   87:return          
            }

            final AccuracyDialog this$0;

            
            {
                this$0 = AccuracyDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AccuracyDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   31   64:aload_2         
    //   32   65:new             #66  <Class AccuracyDialog$1>
    //   33   68:dup             
    //   34   69:aload_0         
    //   35   70:invokespecial   #69  <Method void AccuracyDialog$1(AccuracyDialog)>
    //   36   73:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        JButton genBut = new JButton("Generate Roles");
    //   37   76:new             #61  <Class JButton>
    //   38   79:dup             
    //   39   80:ldc1            #75  <String "Generate Roles">
    //   40   82:invokespecial   #64  <Method void JButton(String)>
    //   41   85:astore_3        
        genBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                generatedRoles = LoadRoleFile();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AccuracyDialog this$0>
            //    2    4:aload_0         
            //    3    5:getfield        #13  <Field AccuracyDialog this$0>
            //    4    8:invokevirtual   #28  <Method Assignment AccuracyDialog.LoadRoleFile()>
            //    5   11:putfield        #32  <Field Assignment AccuracyDialog.generatedRoles>
                setRoleInfor(generatedRoles, gentxt, SelectedFile);
            //    6   14:aload_0         
            //    7   15:getfield        #13  <Field AccuracyDialog this$0>
            //    8   18:aload_0         
            //    9   19:getfield        #13  <Field AccuracyDialog this$0>
            //   10   22:getfield        #32  <Field Assignment AccuracyDialog.generatedRoles>
            //   11   25:aload_0         
            //   12   26:getfield        #13  <Field AccuracyDialog this$0>
            //   13   29:invokestatic    #36  <Method JTextField AccuracyDialog.access$3(AccuracyDialog)>
            //   14   32:aload_0         
            //   15   33:getfield        #13  <Field AccuracyDialog this$0>
            //   16   36:getfield        #40  <Field File AccuracyDialog.SelectedFile>
            //   17   39:invokestatic    #44  <Method void AccuracyDialog.access$1(AccuracyDialog, Assignment, JTextField, File)>
                if(originalRoles != null && generatedRoles != null)
            //*  18   42:aload_0         
            //*  19   43:getfield        #13  <Field AccuracyDialog this$0>
            //*  20   46:getfield        #47  <Field Assignment AccuracyDialog.originalRoles>
            //*  21   49:ifnull          76
            //*  22   52:aload_0         
            //*  23   53:getfield        #13  <Field AccuracyDialog this$0>
            //*  24   56:getfield        #32  <Field Assignment AccuracyDialog.generatedRoles>
            //*  25   59:ifnull          76
                    cButton.setEnabled(true);
            //   26   62:aload_0         
            //   27   63:getfield        #13  <Field AccuracyDialog this$0>
            //   28   66:invokestatic    #51  <Method JButton AccuracyDialog.access$2(AccuracyDialog)>
            //   29   69:iconst_1        
            //   30   70:invokevirtual   #57  <Method void JButton.setEnabled(boolean)>
                else
            //*  31   73:goto            87
                    cButton.setEnabled(false);
            //   32   76:aload_0         
            //   33   77:getfield        #13  <Field AccuracyDialog this$0>
            //   34   80:invokestatic    #51  <Method JButton AccuracyDialog.access$2(AccuracyDialog)>
            //   35   83:iconst_0        
            //   36   84:invokevirtual   #57  <Method void JButton.setEnabled(boolean)>
            //   37   87:return          
            }

            final AccuracyDialog this$0;

            
            {
                this$0 = AccuracyDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AccuracyDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   42   86:aload_3         
    //   43   87:new             #77  <Class AccuracyDialog$2>
    //   44   90:dup             
    //   45   91:aload_0         
    //   46   92:invokespecial   #78  <Method void AccuracyDialog$2(AccuracyDialog)>
    //   47   95:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        cButton = new JButton("Compute");
    //   48   98:aload_0         
    //   49   99:new             #61  <Class JButton>
    //   50  102:dup             
    //   51  103:ldc1            #80  <String "Compute">
    //   52  105:invokespecial   #64  <Method void JButton(String)>
    //   53  108:putfield        #82  <Field JButton cButton>
        cButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                if(check())
            //*   0    0:aload_0         
            //*   1    1:getfield        #13  <Field AccuracyDialog this$0>
            //*   2    4:invokestatic    #28  <Method boolean AccuracyDialog.access$4(AccuracyDialog)>
            //*   3    7:ifeq            45
                    result.setText((new StringBuilder("Result: ")).append(ComputeAccuracy()).toString());
            //    4   10:aload_0         
            //    5   11:getfield        #13  <Field AccuracyDialog this$0>
            //    6   14:invokestatic    #32  <Method JTextField AccuracyDialog.access$5(AccuracyDialog)>
            //    7   17:new             #34  <Class StringBuilder>
            //    8   20:dup             
            //    9   21:ldc1            #36  <String "Result: ">
            //   10   23:invokespecial   #39  <Method void StringBuilder(String)>
            //   11   26:aload_0         
            //   12   27:getfield        #13  <Field AccuracyDialog this$0>
            //   13   30:invokestatic    #43  <Method double AccuracyDialog.access$6(AccuracyDialog)>
            //   14   33:invokevirtual   #47  <Method StringBuilder StringBuilder.append(double)>
            //   15   36:invokevirtual   #51  <Method String StringBuilder.toString()>
            //   16   39:invokevirtual   #56  <Method void JTextField.setText(String)>
                else
            //*  17   42:goto            57
                    result.setText("Error");
            //   18   45:aload_0         
            //   19   46:getfield        #13  <Field AccuracyDialog this$0>
            //   20   49:invokestatic    #32  <Method JTextField AccuracyDialog.access$5(AccuracyDialog)>
            //   21   52:ldc1            #58  <String "Error">
            //   22   54:invokevirtual   #56  <Method void JTextField.setText(String)>
                repaint();
            //   23   57:aload_0         
            //   24   58:getfield        #13  <Field AccuracyDialog this$0>
            //   25   61:invokevirtual   #61  <Method void AccuracyDialog.repaint()>
            //   26   64:return          
            }

            final AccuracyDialog this$0;

            
            {
                this$0 = AccuracyDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AccuracyDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   54  111:aload_0         
    //   55  112:getfield        #82  <Field JButton cButton>
    //   56  115:new             #84  <Class AccuracyDialog$3>
    //   57  118:dup             
    //   58  119:aload_0         
    //   59  120:invokespecial   #85  <Method void AccuracyDialog$3(AccuracyDialog)>
    //   60  123:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        JButton cancelButton = new JButton("Cancel");
    //   61  126:new             #61  <Class JButton>
    //   62  129:dup             
    //   63  130:ldc1            #87  <String "Cancel">
    //   64  132:invokespecial   #64  <Method void JButton(String)>
    //   65  135:astore          4
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                dialog.setVisible(false);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AccuracyDialog this$0>
            //    2    4:invokestatic    #28  <Method JDialog AccuracyDialog.access$7(AccuracyDialog)>
            //    3    7:iconst_0        
            //    4    8:invokevirtual   #34  <Method void JDialog.setVisible(boolean)>
            //    5   11:return          
            }

            final AccuracyDialog this$0;

            
            {
                this$0 = AccuracyDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AccuracyDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   66  137:aload           4
    //   67  139:new             #89  <Class AccuracyDialog$4>
    //   68  142:dup             
    //   69  143:aload_0         
    //   70  144:invokespecial   #90  <Method void AccuracyDialog$4(AccuracyDialog)>
    //   71  147:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        JPanel p1 = new JPanel();
    //   72  150:new             #4   <Class JPanel>
    //   73  153:dup             
    //   74  154:invokespecial   #30  <Method void JPanel()>
    //   75  157:astore          5
        p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Accuracy"), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
    //   76  159:aload           5
    //   77  161:ldc1            #92  <String "Accuracy">
    //   78  163:invokestatic    #98  <Method javax.swing.border.TitledBorder BorderFactory.createTitledBorder(String)>
    //   79  166:iconst_0        
    //   80  167:iconst_5        
    //   81  168:iconst_5        
    //   82  169:iconst_5        
    //   83  170:invokestatic    #102 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //   84  173:invokestatic    #106 <Method javax.swing.border.CompoundBorder BorderFactory.createCompoundBorder(javax.swing.border.Border, javax.swing.border.Border)>
    //   85  176:invokevirtual   #110 <Method void JPanel.setBorder(javax.swing.border.Border)>
        GridBagLayout gb = new GridBagLayout();
    //   86  179:new             #112 <Class GridBagLayout>
    //   87  182:dup             
    //   88  183:invokespecial   #113 <Method void GridBagLayout()>
    //   89  186:astore          6
        p1.setLayout(gb);
    //   90  188:aload           5
    //   91  190:aload           6
    //   92  192:invokevirtual   #114 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        GridBagConstraints gbC = new GridBagConstraints();
    //   93  195:new             #116 <Class GridBagConstraints>
    //   94  198:dup             
    //   95  199:invokespecial   #117 <Method void GridBagConstraints()>
    //   96  202:astore          7
        gbC.gridy = 1;
    //   97  204:aload           7
    //   98  206:iconst_1        
    //   99  207:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  100  210:aload           7
    //  101  212:iconst_0        
    //  102  213:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 13;
    //  103  216:aload           7
    //  104  218:bipush          13
    //  105  220:putfield        #126 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  106  223:aload           7
    //  107  225:iconst_2        
    //  108  226:putfield        #129 <Field int GridBagConstraints.fill>
        gb.setConstraints(origBut, gbC);
    //  109  229:aload           6
    //  110  231:aload_2         
    //  111  232:aload           7
    //  112  234:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p1.add(origBut);
    //  113  237:aload           5
    //  114  239:aload_2         
    //  115  240:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  116  243:pop             
        gbC = new GridBagConstraints();
    //  117  244:new             #116 <Class GridBagConstraints>
    //  118  247:dup             
    //  119  248:invokespecial   #117 <Method void GridBagConstraints()>
    //  120  251:astore          7
        gbC.gridy = 1;
    //  121  253:aload           7
    //  122  255:iconst_1        
    //  123  256:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  124  259:aload           7
    //  125  261:iconst_1        
    //  126  262:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //  127  265:aload           7
    //  128  267:bipush          17
    //  129  269:putfield        #126 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  130  272:aload           7
    //  131  274:iconst_2        
    //  132  275:putfield        #129 <Field int GridBagConstraints.fill>
        gbC.weightx = 100D;
    //  133  278:aload           7
    //  134  280:ldc2w           #138 <Double 100D>
    //  135  283:putfield        #143 <Field double GridBagConstraints.weightx>
        origtxt = new JTextField("");
    //  136  286:aload_0         
    //  137  287:new             #145 <Class JTextField>
    //  138  290:dup             
    //  139  291:ldc1            #147 <String "">
    //  140  293:invokespecial   #148 <Method void JTextField(String)>
    //  141  296:putfield        #150 <Field JTextField origtxt>
        gb.setConstraints(origtxt, gbC);
    //  142  299:aload           6
    //  143  301:aload_0         
    //  144  302:getfield        #150 <Field JTextField origtxt>
    //  145  305:aload           7
    //  146  307:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p1.add(origtxt);
    //  147  310:aload           5
    //  148  312:aload_0         
    //  149  313:getfield        #150 <Field JTextField origtxt>
    //  150  316:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  151  319:pop             
        gbC = new GridBagConstraints();
    //  152  320:new             #116 <Class GridBagConstraints>
    //  153  323:dup             
    //  154  324:invokespecial   #117 <Method void GridBagConstraints()>
    //  155  327:astore          7
        gbC.gridy = 2;
    //  156  329:aload           7
    //  157  331:iconst_2        
    //  158  332:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  159  335:aload           7
    //  160  337:iconst_0        
    //  161  338:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 13;
    //  162  341:aload           7
    //  163  343:bipush          13
    //  164  345:putfield        #126 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  165  348:aload           7
    //  166  350:iconst_2        
    //  167  351:putfield        #129 <Field int GridBagConstraints.fill>
        gb.setConstraints(genBut, gbC);
    //  168  354:aload           6
    //  169  356:aload_3         
    //  170  357:aload           7
    //  171  359:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p1.add(genBut);
    //  172  362:aload           5
    //  173  364:aload_3         
    //  174  365:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  175  368:pop             
        gbC = new GridBagConstraints();
    //  176  369:new             #116 <Class GridBagConstraints>
    //  177  372:dup             
    //  178  373:invokespecial   #117 <Method void GridBagConstraints()>
    //  179  376:astore          7
        gbC.gridy = 2;
    //  180  378:aload           7
    //  181  380:iconst_2        
    //  182  381:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  183  384:aload           7
    //  184  386:iconst_1        
    //  185  387:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //  186  390:aload           7
    //  187  392:bipush          17
    //  188  394:putfield        #126 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  189  397:aload           7
    //  190  399:iconst_2        
    //  191  400:putfield        #129 <Field int GridBagConstraints.fill>
        gbC.weightx = 100D;
    //  192  403:aload           7
    //  193  405:ldc2w           #138 <Double 100D>
    //  194  408:putfield        #143 <Field double GridBagConstraints.weightx>
        gentxt = new JTextField("");
    //  195  411:aload_0         
    //  196  412:new             #145 <Class JTextField>
    //  197  415:dup             
    //  198  416:ldc1            #147 <String "">
    //  199  418:invokespecial   #148 <Method void JTextField(String)>
    //  200  421:putfield        #152 <Field JTextField gentxt>
        gb.setConstraints(gentxt, gbC);
    //  201  424:aload           6
    //  202  426:aload_0         
    //  203  427:getfield        #152 <Field JTextField gentxt>
    //  204  430:aload           7
    //  205  432:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p1.add(gentxt);
    //  206  435:aload           5
    //  207  437:aload_0         
    //  208  438:getfield        #152 <Field JTextField gentxt>
    //  209  441:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  210  444:pop             
        JLabel lab = new JLabel("Result:");
    //  211  445:new             #154 <Class JLabel>
    //  212  448:dup             
    //  213  449:ldc1            #156 <String "Result:">
    //  214  451:invokespecial   #157 <Method void JLabel(String)>
    //  215  454:astore          8
        gbC = new GridBagConstraints();
    //  216  456:new             #116 <Class GridBagConstraints>
    //  217  459:dup             
    //  218  460:invokespecial   #117 <Method void GridBagConstraints()>
    //  219  463:astore          7
        gbC.gridy = 3;
    //  220  465:aload           7
    //  221  467:iconst_3        
    //  222  468:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  223  471:aload           7
    //  224  473:iconst_0        
    //  225  474:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 10;
    //  226  477:aload           7
    //  227  479:bipush          10
    //  228  481:putfield        #126 <Field int GridBagConstraints.anchor>
        gb.setConstraints(lab, gbC);
    //  229  484:aload           6
    //  230  486:aload           8
    //  231  488:aload           7
    //  232  490:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p1.add(lab);
    //  233  493:aload           5
    //  234  495:aload           8
    //  235  497:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  236  500:pop             
        gbC = new GridBagConstraints();
    //  237  501:new             #116 <Class GridBagConstraints>
    //  238  504:dup             
    //  239  505:invokespecial   #117 <Method void GridBagConstraints()>
    //  240  508:astore          7
        gbC.gridy = 3;
    //  241  510:aload           7
    //  242  512:iconst_3        
    //  243  513:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  244  516:aload           7
    //  245  518:iconst_1        
    //  246  519:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //  247  522:aload           7
    //  248  524:bipush          17
    //  249  526:putfield        #126 <Field int GridBagConstraints.anchor>
        gbC.fill = 2;
    //  250  529:aload           7
    //  251  531:iconst_2        
    //  252  532:putfield        #129 <Field int GridBagConstraints.fill>
        gbC.weightx = 100D;
    //  253  535:aload           7
    //  254  537:ldc2w           #138 <Double 100D>
    //  255  540:putfield        #143 <Field double GridBagConstraints.weightx>
        result = new JTextField("");
    //  256  543:aload_0         
    //  257  544:new             #145 <Class JTextField>
    //  258  547:dup             
    //  259  548:ldc1            #147 <String "">
    //  260  550:invokespecial   #148 <Method void JTextField(String)>
    //  261  553:putfield        #159 <Field JTextField result>
        gb.setConstraints(result, gbC);
    //  262  556:aload           6
    //  263  558:aload_0         
    //  264  559:getfield        #159 <Field JTextField result>
    //  265  562:aload           7
    //  266  564:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p1.add(result);
    //  267  567:aload           5
    //  268  569:aload_0         
    //  269  570:getfield        #159 <Field JTextField result>
    //  270  573:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  271  576:pop             
        JPanel p2 = new JPanel();
    //  272  577:new             #4   <Class JPanel>
    //  273  580:dup             
    //  274  581:invokespecial   #30  <Method void JPanel()>
    //  275  584:astore          9
        gb = new GridBagLayout();
    //  276  586:new             #112 <Class GridBagLayout>
    //  277  589:dup             
    //  278  590:invokespecial   #113 <Method void GridBagLayout()>
    //  279  593:astore          6
        p2.setLayout(gb);
    //  280  595:aload           9
    //  281  597:aload           6
    //  282  599:invokevirtual   #114 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        gbC = new GridBagConstraints();
    //  283  602:new             #116 <Class GridBagConstraints>
    //  284  605:dup             
    //  285  606:invokespecial   #117 <Method void GridBagConstraints()>
    //  286  609:astore          7
        gbC.gridy = 1;
    //  287  611:aload           7
    //  288  613:iconst_1        
    //  289  614:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 0;
    //  290  617:aload           7
    //  291  619:iconst_0        
    //  292  620:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 13;
    //  293  623:aload           7
    //  294  625:bipush          13
    //  295  627:putfield        #126 <Field int GridBagConstraints.anchor>
        gb.setConstraints(cButton, gbC);
    //  296  630:aload           6
    //  297  632:aload_0         
    //  298  633:getfield        #82  <Field JButton cButton>
    //  299  636:aload           7
    //  300  638:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p2.add(cButton);
    //  301  641:aload           9
    //  302  643:aload_0         
    //  303  644:getfield        #82  <Field JButton cButton>
    //  304  647:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  305  650:pop             
        gbC = new GridBagConstraints();
    //  306  651:new             #116 <Class GridBagConstraints>
    //  307  654:dup             
    //  308  655:invokespecial   #117 <Method void GridBagConstraints()>
    //  309  658:astore          7
        gbC.gridy = 1;
    //  310  660:aload           7
    //  311  662:iconst_1        
    //  312  663:putfield        #120 <Field int GridBagConstraints.gridy>
        gbC.gridx = 1;
    //  313  666:aload           7
    //  314  668:iconst_1        
    //  315  669:putfield        #123 <Field int GridBagConstraints.gridx>
        gbC.anchor = 17;
    //  316  672:aload           7
    //  317  674:bipush          17
    //  318  676:putfield        #126 <Field int GridBagConstraints.anchor>
        gb.setConstraints(cancelButton, gbC);
    //  319  679:aload           6
    //  320  681:aload           4
    //  321  683:aload           7
    //  322  685:invokevirtual   #133 <Method void GridBagLayout.setConstraints(Component, GridBagConstraints)>
        p2.add(cancelButton);
    //  323  688:aload           9
    //  324  690:aload           4
    //  325  692:invokevirtual   #137 <Method Component JPanel.add(Component)>
    //  326  695:pop             
        add(p1, "Center");
    //  327  696:aload_0         
    //  328  697:aload           5
    //  329  699:ldc1            #161 <String "Center">
    //  330  701:invokevirtual   #164 <Method void add(Component, Object)>
        add(p2, "South");
    //  331  704:aload_0         
    //  332  705:aload           9
    //  333  707:ldc1            #166 <String "South">
    //  334  709:invokevirtual   #164 <Method void add(Component, Object)>
        origtxt.setEditable(false);
    //  335  712:aload_0         
    //  336  713:getfield        #150 <Field JTextField origtxt>
    //  337  716:iconst_0        
    //  338  717:invokevirtual   #170 <Method void JTextField.setEditable(boolean)>
        gentxt.setEditable(false);
    //  339  720:aload_0         
    //  340  721:getfield        #152 <Field JTextField gentxt>
    //  341  724:iconst_0        
    //  342  725:invokevirtual   #170 <Method void JTextField.setEditable(boolean)>
        result.setEditable(false);
    //  343  728:aload_0         
    //  344  729:getfield        #159 <Field JTextField result>
    //  345  732:iconst_0        
    //  346  733:invokevirtual   #170 <Method void JTextField.setEditable(boolean)>
        cButton.setEnabled(false);
    //  347  736:aload_0         
    //  348  737:getfield        #82  <Field JButton cButton>
    //  349  740:iconst_0        
    //  350  741:invokevirtual   #173 <Method void JButton.setEnabled(boolean)>
    //  351  744:return          
    }

    public void showDialog(Component parent, String title)
    {
        Frame owner = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        if(parent instanceof Frame)
    //*   2    2:aload_1         
    //*   3    3:instanceof      #194 <Class Frame>
    //*   4    6:ifeq            17
            owner = (Frame)parent;
    //    5    9:aload_1         
    //    6   10:checkcast       #194 <Class Frame>
    //    7   13:astore_3        
        else
    //*   8   14:goto            27
            owner = (Frame)SwingUtilities.getAncestorOfClass(java/awt/Frame, parent);
    //    9   17:ldc1            #194 <Class Frame>
    //   10   19:aload_1         
    //   11   20:invokestatic    #200 <Method java.awt.Container SwingUtilities.getAncestorOfClass(Class, Component)>
    //   12   23:checkcast       #194 <Class Frame>
    //   13   26:astore_3        
        if(dialog == null || dialog.getOwner() != owner)
    //*  14   27:aload_0         
    //*  15   28:getfield        #202 <Field JDialog dialog>
    //*  16   31:ifnull          45
    //*  17   34:aload_0         
    //*  18   35:getfield        #202 <Field JDialog dialog>
    //*  19   38:invokevirtual   #208 <Method java.awt.Window JDialog.getOwner()>
    //*  20   41:aload_3         
    //*  21   42:if_acmpeq       88
        {
            dialog = new JDialog(owner, true);
    //   22   45:aload_0         
    //   23   46:new             #204 <Class JDialog>
    //   24   49:dup             
    //   25   50:aload_3         
    //   26   51:iconst_1        
    //   27   52:invokespecial   #211 <Method void JDialog(Frame, boolean)>
    //   28   55:putfield        #202 <Field JDialog dialog>
            dialog.add(this);
    //   29   58:aload_0         
    //   30   59:getfield        #202 <Field JDialog dialog>
    //   31   62:aload_0         
    //   32   63:invokevirtual   #212 <Method Component JDialog.add(Component)>
    //   33   66:pop             
            dialog.getRootPane().setDefaultButton(cButton);
    //   34   67:aload_0         
    //   35   68:getfield        #202 <Field JDialog dialog>
    //   36   71:invokevirtual   #216 <Method JRootPane JDialog.getRootPane()>
    //   37   74:aload_0         
    //   38   75:getfield        #82  <Field JButton cButton>
    //   39   78:invokevirtual   #222 <Method void JRootPane.setDefaultButton(JButton)>
            dialog.pack();
    //   40   81:aload_0         
    //   41   82:getfield        #202 <Field JDialog dialog>
    //   42   85:invokevirtual   #225 <Method void JDialog.pack()>
        }
        dialog.setTitle(title);
    //   43   88:aload_0         
    //   44   89:getfield        #202 <Field JDialog dialog>
    //   45   92:aload_2         
    //   46   93:invokevirtual   #228 <Method void JDialog.setTitle(String)>
        if(parent.getMousePosition() != null)
    //*  47   96:aload_1         
    //*  48   97:invokevirtual   #234 <Method java.awt.Point Component.getMousePosition()>
    //*  49  100:ifnull          114
            dialog.setLocation(parent.getMousePosition());
    //   50  103:aload_0         
    //   51  104:getfield        #202 <Field JDialog dialog>
    //   52  107:aload_1         
    //   53  108:invokevirtual   #234 <Method java.awt.Point Component.getMousePosition()>
    //   54  111:invokevirtual   #238 <Method void JDialog.setLocation(java.awt.Point)>
        dialog.setSize(500, 160);
    //   55  114:aload_0         
    //   56  115:getfield        #202 <Field JDialog dialog>
    //   57  118:sipush          500
    //   58  121:sipush          160
    //   59  124:invokevirtual   #242 <Method void JDialog.setSize(int, int)>
        dialog.setVisible(true);
    //   60  127:aload_0         
    //   61  128:getfield        #202 <Field JDialog dialog>
    //   62  131:iconst_1        
    //   63  132:invokevirtual   #245 <Method void JDialog.setVisible(boolean)>
    //   64  135:return          
    }

    private boolean check()
    {
        Object origPermset[] = originalRoles.getDimensionY().getDimensionAttribute().toArray();
    //    0    0:aload_0         
    //    1    1:getfield        #255 <Field Assignment originalRoles>
    //    2    4:invokevirtual   #261 <Method Dimension Assignment.getDimensionY()>
    //    3    7:invokevirtual   #267 <Method Attribute Dimension.getDimensionAttribute()>
    //    4   10:invokevirtual   #273 <Method Object[] Attribute.toArray()>
    //    5   13:astore_3        
        Object genPermset[] = generatedRoles.getDimensionY().getDimensionAttribute().toArray();
    //    6   14:aload_0         
    //    7   15:getfield        #275 <Field Assignment generatedRoles>
    //    8   18:invokevirtual   #261 <Method Dimension Assignment.getDimensionY()>
    //    9   21:invokevirtual   #267 <Method Attribute Dimension.getDimensionAttribute()>
    //   10   24:invokevirtual   #273 <Method Object[] Attribute.toArray()>
    //   11   27:astore          4
        if(origPermset.length != genPermset.length)
    //*  12   29:aload_3         
    //*  13   30:arraylength     
    //*  14   31:aload           4
    //*  15   33:arraylength     
    //*  16   34:icmpeq          39
            return false;
    //   17   37:iconst_0        
    //   18   38:ireturn         
        for(int i = 0; i < origPermset.length; i++)
    //*  19   39:iconst_0        
    //*  20   40:istore_1        
    //*  21   41:goto            87
        {
            int j;
            for(j = 0; j < genPermset.length; j++)
    //*  22   44:iconst_0        
    //*  23   45:istore_2        
    //*  24   46:goto            68
                if(origPermset[i].equals(genPermset[j]))
    //*  25   49:aload_3         
    //*  26   50:iload_1         
    //*  27   51:aaload          
    //*  28   52:aload           4
    //*  29   54:iload_2         
    //*  30   55:aaload          
    //*  31   56:invokevirtual   #281 <Method boolean Object.equals(Object)>
    //*  32   59:ifeq            65
                    break;
    //   33   62:goto            75

    //   34   65:iinc            2  1
    //   35   68:iload_2         
    //   36   69:aload           4
    //   37   71:arraylength     
    //   38   72:icmplt          49
            if(j == genPermset.length)
    //*  39   75:iload_2         
    //*  40   76:aload           4
    //*  41   78:arraylength     
    //*  42   79:icmpne          84
                return false;
    //   43   82:iconst_0        
    //   44   83:ireturn         
        }

    //   45   84:iinc            1  1
    //   46   87:iload_1         
    //   47   88:aload_3         
    //   48   89:arraylength     
    //   49   90:icmplt          44
        return true;
    //   50   93:iconst_1        
    //   51   94:ireturn         
    }

    private double ComputeAccuracy()
    {
        double acc = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        Matrix origmat = originalRoles.getAssignmentMatrix();
    //    2    2:aload_0         
    //    3    3:getfield        #255 <Field Assignment originalRoles>
    //    4    6:invokevirtual   #292 <Method Matrix Assignment.getAssignmentMatrix()>
    //    5    9:astore          6
        boolean flags[] = new boolean[origmat.getRowDimension()];
    //    6   11:aload           6
    //    7   13:invokevirtual   #298 <Method int Matrix.getRowDimension()>
    //    8   16:newarray        boolean[]
    //    9   18:astore          7
        for(int i = 0; i < origmat.getRowDimension(); i++)
    //*  10   20:iconst_0        
    //*  11   21:istore_3        
    //*  12   22:goto            33
            flags[i] = false;
    //   13   25:aload           7
    //   14   27:iload_3         
    //   15   28:iconst_0        
    //   16   29:bastore         

    //   17   30:iinc            3  1
    //   18   33:iload_3         
    //   19   34:aload           6
    //   20   36:invokevirtual   #298 <Method int Matrix.getRowDimension()>
    //   21   39:icmplt          25
        Matrix genmat = generatedRoles.getAssignmentMatrix();
    //   22   42:aload_0         
    //   23   43:getfield        #275 <Field Assignment generatedRoles>
    //   24   46:invokevirtual   #292 <Method Matrix Assignment.getAssignmentMatrix()>
    //   25   49:astore          8
        for(int i = 0; i < genmat.getRowDimension(); i++)
    //*  26   51:iconst_0        
    //*  27   52:istore_3        
    //*  28   53:goto            148
        {
            for(int j = 0; j < origmat.getRowDimension(); j++)
    //*  29   56:iconst_0        
    //*  30   57:istore          4
    //*  31   59:goto            135
                if(!flags[j])
    //*  32   62:aload           7
    //*  33   64:iload           4
    //*  34   66:baload          
    //*  35   67:ifne            132
                {
                    int k;
                    for(k = 0; k < origmat.getColumnDimension(); k++)
    //*  36   70:iconst_0        
    //*  37   71:istore          5
    //*  38   73:goto            102
                        if(genmat.get(i, k) != origmat.get(j, k))
    //*  39   76:aload           8
    //*  40   78:iload_3         
    //*  41   79:iload           5
    //*  42   81:invokevirtual   #302 <Method byte Matrix.get(int, int)>
    //*  43   84:aload           6
    //*  44   86:iload           4
    //*  45   88:iload           5
    //*  46   90:invokevirtual   #302 <Method byte Matrix.get(int, int)>
    //*  47   93:icmpeq          99
                            break;
    //   48   96:goto            112

    //   49   99:iinc            5  1
    //   50  102:iload           5
    //   51  104:aload           6
    //   52  106:invokevirtual   #305 <Method int Matrix.getColumnDimension()>
    //   53  109:icmplt          76
                    if(k == origmat.getColumnDimension())
    //*  54  112:iload           5
    //*  55  114:aload           6
    //*  56  116:invokevirtual   #305 <Method int Matrix.getColumnDimension()>
    //*  57  119:icmpne          132
                    {
                        acc++;
    //   58  122:dload_1         
    //   59  123:dconst_1        
    //   60  124:dadd            
    //   61  125:dstore_1        
                        flags[j] = true;
    //   62  126:aload           7
    //   63  128:iload           4
    //   64  130:iconst_1        
    //   65  131:bastore         
                    }
                }

    //   66  132:iinc            4  1
    //   67  135:iload           4
    //   68  137:aload           6
    //   69  139:invokevirtual   #298 <Method int Matrix.getRowDimension()>
    //   70  142:icmplt          62
        }

    //   71  145:iinc            3  1
    //   72  148:iload_3         
    //   73  149:aload           8
    //   74  151:invokevirtual   #298 <Method int Matrix.getRowDimension()>
    //   75  154:icmplt          56
        return acc / (double)origmat.getRowDimension();
    //   76  157:dload_1         
    //   77  158:aload           6
    //   78  160:invokevirtual   #298 <Method int Matrix.getRowDimension()>
    //   79  163:i2d             
    //   80  164:ddiv            
    //   81  165:dreturn         
    }

    private void setRoleInfor(Assignment assData, JTextField jtxt, File selectedFile)
    {
        String TxtRoles = "-F ";
    //    0    0:ldc2            #316 <String "-F ">
    //    1    3:astore          4
        if(selectedFile == null)
    //*   2    5:aload_3         
    //*   3    6:ifnonnull       35
            TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("Default").toString();
    //    4    9:new             #318 <Class StringBuilder>
    //    5   12:dup             
    //    6   13:aload           4
    //    7   15:invokestatic    #324 <Method String String.valueOf(Object)>
    //    8   18:invokespecial   #325 <Method void StringBuilder(String)>
    //    9   21:ldc2            #327 <String "Default">
    //   10   24:invokevirtual   #331 <Method StringBuilder StringBuilder.append(String)>
    //   11   27:invokevirtual   #334 <Method String StringBuilder.toString()>
    //   12   30:astore          4
        else
    //*  13   32:goto            59
            TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append(selectedFile.getName()).toString();
    //   14   35:new             #318 <Class StringBuilder>
    //   15   38:dup             
    //   16   39:aload           4
    //   17   41:invokestatic    #324 <Method String String.valueOf(Object)>
    //   18   44:invokespecial   #325 <Method void StringBuilder(String)>
    //   19   47:aload_3         
    //   20   48:invokevirtual   #337 <Method String File.getName()>
    //   21   51:invokevirtual   #331 <Method StringBuilder StringBuilder.append(String)>
    //   22   54:invokevirtual   #334 <Method String StringBuilder.toString()>
    //   23   57:astore          4
        TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -N ").append(assData.getAssignementName()).toString();
    //   24   59:new             #318 <Class StringBuilder>
    //   25   62:dup             
    //   26   63:aload           4
    //   27   65:invokestatic    #324 <Method String String.valueOf(Object)>
    //   28   68:invokespecial   #325 <Method void StringBuilder(String)>
    //   29   71:ldc2            #339 <String "  -N ">
    //   30   74:invokevirtual   #331 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:aload_1         
    //   32   78:invokevirtual   #342 <Method String Assignment.getAssignementName()>
    //   33   81:invokevirtual   #331 <Method StringBuilder StringBuilder.append(String)>
    //   34   84:invokevirtual   #334 <Method String StringBuilder.toString()>
    //   35   87:astore          4
        TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -R ").append(assData.getAssignmentMatrix().getRowDimension()).toString();
    //   36   89:new             #318 <Class StringBuilder>
    //   37   92:dup             
    //   38   93:aload           4
    //   39   95:invokestatic    #324 <Method String String.valueOf(Object)>
    //   40   98:invokespecial   #325 <Method void StringBuilder(String)>
    //   41  101:ldc2            #344 <String "  -R ">
    //   42  104:invokevirtual   #331 <Method StringBuilder StringBuilder.append(String)>
    //   43  107:aload_1         
    //   44  108:invokevirtual   #292 <Method Matrix Assignment.getAssignmentMatrix()>
    //   45  111:invokevirtual   #298 <Method int Matrix.getRowDimension()>
    //   46  114:invokevirtual   #347 <Method StringBuilder StringBuilder.append(int)>
    //   47  117:invokevirtual   #334 <Method String StringBuilder.toString()>
    //   48  120:astore          4
        TxtRoles = (new StringBuilder(String.valueOf(TxtRoles))).append("  -P ").append(assData.getAssignmentMatrix().getColumnDimension()).toString();
    //   49  122:new             #318 <Class StringBuilder>
    //   50  125:dup             
    //   51  126:aload           4
    //   52  128:invokestatic    #324 <Method String String.valueOf(Object)>
    //   53  131:invokespecial   #325 <Method void StringBuilder(String)>
    //   54  134:ldc2            #349 <String "  -P ">
    //   55  137:invokevirtual   #331 <Method StringBuilder StringBuilder.append(String)>
    //   56  140:aload_1         
    //   57  141:invokevirtual   #292 <Method Matrix Assignment.getAssignmentMatrix()>
    //   58  144:invokevirtual   #305 <Method int Matrix.getColumnDimension()>
    //   59  147:invokevirtual   #347 <Method StringBuilder StringBuilder.append(int)>
    //   60  150:invokevirtual   #334 <Method String StringBuilder.toString()>
    //   61  153:astore          4
        jtxt.setText(TxtRoles);
    //   62  155:aload_2         
    //   63  156:aload           4
    //   64  158:invokevirtual   #352 <Method void JTextField.setText(String)>
        repaint();
    //   65  161:aload_0         
    //   66  162:invokevirtual   #355 <Method void repaint()>
    //   67  165:return          
    }

    public Assignment LoadRoleFile()
    {
        m_FileChooser.setDialogTitle("Load Roles");
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field ConverterFileChooser m_FileChooser>
    //    2    4:ldc2            #363 <String "Load Roles">
    //    3    7:invokevirtual   #366 <Method void ConverterFileChooser.setDialogTitle(String)>
        m_FileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    //    4   10:aload_0         
    //    5   11:getfield        #48  <Field ConverterFileChooser m_FileChooser>
    //    6   14:new             #34  <Class File>
    //    7   17:dup             
    //    8   18:ldc2            #368 <String "user.dir">
    //    9   21:invokestatic    #374 <Method String System.getProperty(String)>
    //   10   24:invokespecial   #43  <Method void File(String)>
    //   11   27:invokevirtual   #377 <Method void ConverterFileChooser.setCurrentDirectory(File)>
        try
        {
            Fileflag = m_FileChooser.showOpenDialog(this);
    //   12   30:aload_0         
    //   13   31:aload_0         
    //   14   32:getfield        #48  <Field ConverterFileChooser m_FileChooser>
    //   15   35:aload_0         
    //   16   36:invokevirtual   #381 <Method int ConverterFileChooser.showOpenDialog(Component)>
    //   17   39:putfield        #383 <Field int Fileflag>
        }
    //*  18   42:goto            55
        catch(HeadlessException head)
    //*  19   45:astore_1        
        {
            System.out.println("Open File Dialog ERROR!");
    //   20   46:getstatic       #387 <Field PrintStream System.out>
    //   21   49:ldc2            #389 <String "Open File Dialog ERROR!">
    //   22   52:invokevirtual   #394 <Method void PrintStream.println(String)>
        }
        if(Fileflag == 0)
    //*  23   55:aload_0         
    //*  24   56:getfield        #383 <Field int Fileflag>
    //*  25   59:ifne            114
        {
            SelectedFile = m_FileChooser.getSelectedFile();
    //   26   62:aload_0         
    //   27   63:aload_0         
    //   28   64:getfield        #48  <Field ConverterFileChooser m_FileChooser>
    //   29   67:invokevirtual   #398 <Method File ConverterFileChooser.getSelectedFile()>
    //   30   70:putfield        #50  <Field File SelectedFile>
            try
            {
                if(SelectedFile != null)
    //*  31   73:aload_0         
    //*  32   74:getfield        #50  <Field File SelectedFile>
    //*  33   77:ifnull          114
                {
                    AssLoader AssLoad = new AssLoader(new FileReader(SelectedFile));
    //   34   80:new             #400 <Class AssLoader>
    //   35   83:dup             
    //   36   84:new             #402 <Class FileReader>
    //   37   87:dup             
    //   38   88:aload_0         
    //   39   89:getfield        #50  <Field File SelectedFile>
    //   40   92:invokespecial   #403 <Method void FileReader(File)>
    //   41   95:invokespecial   #406 <Method void AssLoader(FileReader)>
    //   42   98:astore_1        
                    Assignment assData = AssLoad.getData();
    //   43   99:aload_1         
    //   44  100:invokevirtual   #409 <Method Assignment AssLoader.getData()>
    //   45  103:astore_2        
                    return assData;
    //   46  104:aload_2         
    //   47  105:areturn         
                }
            }
    //*  48  106:goto            114
            catch(Exception e)
    //*  49  109:astore_1        
            {
                e.printStackTrace();
    //   50  110:aload_1         
    //   51  111:invokevirtual   #414 <Method void Exception.printStackTrace()>
            }
        }
        return null;
    //   52  114:aconst_null     
    //   53  115:areturn         
    }

    public void setGenerateRoles(Assignment newgeneratedRoles)
    {
        generatedRoles = newgeneratedRoles;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #275 <Field Assignment generatedRoles>
        setRoleInfor(generatedRoles, gentxt, null);
    //    3    5:aload_0         
    //    4    6:aload_0         
    //    5    7:getfield        #275 <Field Assignment generatedRoles>
    //    6   10:aload_0         
    //    7   11:getfield        #152 <Field JTextField gentxt>
    //    8   14:aconst_null     
    //    9   15:invokespecial   #425 <Method void setRoleInfor(Assignment, JTextField, File)>
    //   10   18:return          
    }

    private JTextField gentxt;
    private JTextField origtxt;
    private JTextField result;
    private JButton cButton;
    private JDialog dialog;
    protected ConverterFileChooser m_FileChooser;
    protected int Fileflag;
    protected File SelectedFile;
    protected AssLoader AssData;
    protected Assignment originalRoles;
    protected Assignment generatedRoles;
    static Class class$0;


/*
    static JTextField access$0(AccuracyDialog accuracydialog)
    {
        return accuracydialog.origtxt;
    //    0    0:aload_0         
    //    1    1:getfield        #150 <Field JTextField origtxt>
    //    2    4:areturn         
    }

*/


/*
    static void access$1(AccuracyDialog accuracydialog, Assignment assignment, JTextField jtextfield, File file)
    {
        accuracydialog.setRoleInfor(assignment, jtextfield, file);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:aload_3         
    //    4    4:invokespecial   #425 <Method void setRoleInfor(Assignment, JTextField, File)>
        return;
    //    5    7:return          
    }

*/


/*
    static JButton access$2(AccuracyDialog accuracydialog)
    {
        return accuracydialog.cButton;
    //    0    0:aload_0         
    //    1    1:getfield        #82  <Field JButton cButton>
    //    2    4:areturn         
    }

*/


/*
    static JTextField access$3(AccuracyDialog accuracydialog)
    {
        return accuracydialog.gentxt;
    //    0    0:aload_0         
    //    1    1:getfield        #152 <Field JTextField gentxt>
    //    2    4:areturn         
    }

*/


/*
    static boolean access$4(AccuracyDialog accuracydialog)
    {
        return accuracydialog.check();
    //    0    0:aload_0         
    //    1    1:invokespecial   #438 <Method boolean check()>
    //    2    4:ireturn         
    }

*/


/*
    static JTextField access$5(AccuracyDialog accuracydialog)
    {
        return accuracydialog.result;
    //    0    0:aload_0         
    //    1    1:getfield        #159 <Field JTextField result>
    //    2    4:areturn         
    }

*/


/*
    static double access$6(AccuracyDialog accuracydialog)
    {
        return accuracydialog.ComputeAccuracy();
    //    0    0:aload_0         
    //    1    1:invokespecial   #443 <Method double ComputeAccuracy()>
    //    2    4:dreturn         
    }

*/


/*
    static JDialog access$7(AccuracyDialog accuracydialog)
    {
        return accuracydialog.dialog;
    //    0    0:aload_0         
    //    1    1:getfield        #202 <Field JDialog dialog>
    //    2    4:areturn         
    }

*/
}

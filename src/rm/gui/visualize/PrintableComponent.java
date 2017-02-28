// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   PrintableComponent.java

package rm.gui.visualize;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import rm.gui.ExtensionFileFilter;
import rm.gui.GenericObjectEditor;

// Referenced classes of package rm.gui.visualize:
//            PrintableHandler, VisualizeUtils, JComponentWriter

public class PrintableComponent
    implements PrintableHandler
{
    protected class JComponentWriterFileFilter extends ExtensionFileFilter
    {

        public JComponentWriter getWriter()
        {
            return m_Writer;
        //    0    0:aload_0         
        //    1    1:getfield        #18  <Field JComponentWriter m_Writer>
        //    2    4:areturn         
        }

        private JComponentWriter m_Writer;
        final PrintableComponent this$0;

        public JComponentWriterFileFilter(String extension, String description, JComponentWriter writer)
        {
            this$0 = PrintableComponent.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #13  <Field PrintableComponent this$0>
            super(extension, description);
        //    3    5:aload_0         
        //    4    6:aload_2         
        //    5    7:aload_3         
        //    6    8:invokespecial   #16  <Method void ExtensionFileFilter(String, String)>
            m_Writer = writer;
        //    7   11:aload_0         
        //    8   12:aload           4
        //    9   14:putfield        #18  <Field JComponentWriter m_Writer>
        //   10   17:return          
        }
    }

    private class PrintMouseListener extends MouseAdapter
    {

        public void mouseClicked(MouseEvent e)
        {
            int modifiers = e.getModifiers();
        //    0    0:aload_1         
        //    1    1:invokevirtual   #30  <Method int MouseEvent.getModifiers()>
        //    2    4:istore_2        
            if((modifiers & 1) == 1 && (modifiers & 8) == 8 && (modifiers & 0x10) == 16)
        //*   3    5:iload_2         
        //*   4    6:iconst_1        
        //*   5    7:iand            
        //*   6    8:iconst_1        
        //*   7    9:icmpne          41
        //*   8   12:iload_2         
        //*   9   13:bipush          8
        //*  10   15:iand            
        //*  11   16:bipush          8
        //*  12   18:icmpne          41
        //*  13   21:iload_2         
        //*  14   22:bipush          16
        //*  15   24:iand            
        //*  16   25:bipush          16
        //*  17   27:icmpne          41
            {
                e.consume();
        //   18   30:aload_1         
        //   19   31:invokevirtual   #33  <Method void MouseEvent.consume()>
                m_Component.saveComponent();
        //   20   34:aload_0         
        //   21   35:getfield        #17  <Field PrintableComponent m_Component>
        //   22   38:invokevirtual   #38  <Method void PrintableComponent.saveComponent()>
            }
        //   23   41:return          
        }

        private PrintableComponent m_Component;
        final PrintableComponent this$0;

        public PrintMouseListener(PrintableComponent component)
        {
            this$0 = PrintableComponent.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #12  <Field PrintableComponent this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #15  <Method void MouseAdapter()>
            m_Component = component;
        //    5    9:aload_0         
        //    6   10:aload_2         
        //    7   11:putfield        #17  <Field PrintableComponent m_Component>
        //    8   14:return          
        }
    }


    public PrintableComponent(JComponent component)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #81  <Method void Object()>
        m_SaveDialogTitle = "Save as...";
    //    2    4:aload_0         
    //    3    5:ldc1            #83  <String "Save as...">
    //    4    7:putfield        #85  <Field String m_SaveDialogTitle>
        m_xScale = 1.0D;
    //    5   10:aload_0         
    //    6   11:dconst_1        
    //    7   12:putfield        #87  <Field double m_xScale>
        m_yScale = 1.0D;
    //    8   15:aload_0         
    //    9   16:dconst_1        
    //   10   17:putfield        #89  <Field double m_yScale>
        m_Component = component;
    //   11   20:aload_0         
    //   12   21:aload_1         
    //   13   22:putfield        #91  <Field JComponent m_Component>
        m_AspectRatio = (0.0D / 0.0D);
    //   14   25:aload_0         
    //   15   26:ldc2w           #92  <Double (0.0D / 0.0D)>
    //   16   29:putfield        #95  <Field double m_AspectRatio>
        getComponent().addMouseListener(new PrintMouseListener(this));
    //   17   32:aload_0         
    //   18   33:invokevirtual   #99  <Method JComponent getComponent()>
    //   19   36:new             #101 <Class PrintableComponent$PrintMouseListener>
    //   20   39:dup             
    //   21   40:aload_0         
    //   22   41:aload_0         
    //   23   42:invokespecial   #104 <Method void PrintableComponent$PrintMouseListener(PrintableComponent, PrintableComponent)>
    //   24   45:invokevirtual   #110 <Method void JComponent.addMouseListener(java.awt.event.MouseListener)>
        getComponent().setToolTipText(getToolTipText(this));
    //   25   48:aload_0         
    //   26   49:invokevirtual   #99  <Method JComponent getComponent()>
    //   27   52:aload_0         
    //   28   53:invokestatic    #114 <Method String getToolTipText(PrintableComponent)>
    //   29   56:invokevirtual   #118 <Method void JComponent.setToolTipText(String)>
        initFileChooser();
    //   30   59:aload_0         
    //   31   60:invokevirtual   #121 <Method void initFileChooser()>
    //   32   63:return          
    }

    public JComponent getComponent()
    {
        return m_Component;
    //    0    0:aload_0         
    //    1    1:getfield        #91  <Field JComponent m_Component>
    //    2    4:areturn         
    }

    public static String getToolTipText(PrintableComponent component)
    {
        return null;
    //    0    0:aconst_null     
    //    1    1:areturn         
    }

    protected void initFileChooser()
    {
        if(m_FileChooserPanel != null)
    //*   0    0:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //*   1    3:ifnull          7
            return;
    //    2    6:return          
        m_FileChooserPanel = new JFileChooser();
    //    3    7:new             #128 <Class JFileChooser>
    //    4   10:dup             
    //    5   11:invokespecial   #129 <Method void JFileChooser()>
    //    6   14:putstatic       #126 <Field JFileChooser m_FileChooserPanel>
        m_FileChooserPanel.resetChoosableFileFilters();
    //    7   17:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //    8   20:invokevirtual   #132 <Method void JFileChooser.resetChoosableFileFilters()>
        m_FileChooserPanel.setAcceptAllFileFilterUsed(false);
    //    9   23:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //   10   26:iconst_0        
    //   11   27:invokevirtual   #136 <Method void JFileChooser.setAcceptAllFileFilterUsed(boolean)>
        JPanel accessory = new JPanel();
    //   12   30:new             #138 <Class JPanel>
    //   13   33:dup             
    //   14   34:invokespecial   #139 <Method void JPanel()>
    //   15   37:astore          5
        accessory.setLayout(null);
    //   16   39:aload           5
    //   17   41:aconst_null     
    //   18   42:invokevirtual   #143 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        accessory.setPreferredSize(new Dimension(200, 200));
    //   19   45:aload           5
    //   20   47:new             #145 <Class Dimension>
    //   21   50:dup             
    //   22   51:sipush          200
    //   23   54:sipush          200
    //   24   57:invokespecial   #148 <Method void Dimension(int, int)>
    //   25   60:invokevirtual   #152 <Method void JPanel.setPreferredSize(Dimension)>
        accessory.revalidate();
    //   26   63:aload           5
    //   27   65:invokevirtual   #155 <Method void JPanel.revalidate()>
        m_FileChooserPanel.setAccessory(accessory);
    //   28   68:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //   29   71:aload           5
    //   30   73:invokevirtual   #158 <Method void JFileChooser.setAccessory(JComponent)>
        m_CustomDimensionsCheckBox = new JCheckBox("Use custom dimensions");
    //   31   76:new             #160 <Class JCheckBox>
    //   32   79:dup             
    //   33   80:ldc1            #162 <String "Use custom dimensions">
    //   34   82:invokespecial   #164 <Method void JCheckBox(String)>
    //   35   85:putstatic       #166 <Field JCheckBox m_CustomDimensionsCheckBox>
        m_CustomDimensionsCheckBox.setBounds(14, 7, 200, 21);
    //   36   88:getstatic       #166 <Field JCheckBox m_CustomDimensionsCheckBox>
    //   37   91:bipush          14
    //   38   93:bipush          7
    //   39   95:sipush          200
    //   40   98:bipush          21
    //   41  100:invokevirtual   #170 <Method void JCheckBox.setBounds(int, int, int, int)>
        m_CustomDimensionsCheckBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e)
            {
                boolean custom = PrintableComponent.m_CustomDimensionsCheckBox.isSelected();
            //    0    0:getstatic       #28  <Field JCheckBox PrintableComponent.m_CustomDimensionsCheckBox>
            //    1    3:invokevirtual   #34  <Method boolean JCheckBox.isSelected()>
            //    2    6:istore_2        
                PrintableComponent.m_CustomWidthText.setEnabled(custom);
            //    3    7:getstatic       #38  <Field JTextField PrintableComponent.m_CustomWidthText>
            //    4   10:iload_2         
            //    5   11:invokevirtual   #44  <Method void JTextField.setEnabled(boolean)>
                PrintableComponent.m_CustomHeightText.setEnabled(custom);
            //    6   14:getstatic       #47  <Field JTextField PrintableComponent.m_CustomHeightText>
            //    7   17:iload_2         
            //    8   18:invokevirtual   #44  <Method void JTextField.setEnabled(boolean)>
                PrintableComponent.m_AspectRatioCheckBox.setEnabled(custom);
            //    9   21:getstatic       #50  <Field JCheckBox PrintableComponent.m_AspectRatioCheckBox>
            //   10   24:iload_2         
            //   11   25:invokevirtual   #51  <Method void JCheckBox.setEnabled(boolean)>
                if(custom)
            //*  12   28:iload_2         
            //*  13   29:ifeq            109
                {
                    m_IgnoreChange = true;
            //   14   32:aload_0         
            //   15   33:getfield        #13  <Field PrintableComponent this$0>
            //   16   36:iconst_1        
            //   17   37:putfield        #55  <Field boolean PrintableComponent.m_IgnoreChange>
                    PrintableComponent.m_CustomWidthText.setText((new StringBuilder()).append(m_Component.getWidth()).toString());
            //   18   40:getstatic       #38  <Field JTextField PrintableComponent.m_CustomWidthText>
            //   19   43:new             #57  <Class StringBuilder>
            //   20   46:dup             
            //   21   47:invokespecial   #58  <Method void StringBuilder()>
            //   22   50:aload_0         
            //   23   51:getfield        #13  <Field PrintableComponent this$0>
            //   24   54:getfield        #62  <Field JComponent PrintableComponent.m_Component>
            //   25   57:invokevirtual   #68  <Method int JComponent.getWidth()>
            //   26   60:invokevirtual   #72  <Method StringBuilder StringBuilder.append(int)>
            //   27   63:invokevirtual   #76  <Method String StringBuilder.toString()>
            //   28   66:invokevirtual   #80  <Method void JTextField.setText(String)>
                    PrintableComponent.m_CustomHeightText.setText((new StringBuilder()).append(m_Component.getHeight()).toString());
            //   29   69:getstatic       #47  <Field JTextField PrintableComponent.m_CustomHeightText>
            //   30   72:new             #57  <Class StringBuilder>
            //   31   75:dup             
            //   32   76:invokespecial   #58  <Method void StringBuilder()>
            //   33   79:aload_0         
            //   34   80:getfield        #13  <Field PrintableComponent this$0>
            //   35   83:getfield        #62  <Field JComponent PrintableComponent.m_Component>
            //   36   86:invokevirtual   #83  <Method int JComponent.getHeight()>
            //   37   89:invokevirtual   #72  <Method StringBuilder StringBuilder.append(int)>
            //   38   92:invokevirtual   #76  <Method String StringBuilder.toString()>
            //   39   95:invokevirtual   #80  <Method void JTextField.setText(String)>
                    m_IgnoreChange = false;
            //   40   98:aload_0         
            //   41   99:getfield        #13  <Field PrintableComponent this$0>
            //   42  102:iconst_0        
            //   43  103:putfield        #55  <Field boolean PrintableComponent.m_IgnoreChange>
                } else
            //*  44  106:goto            141
                {
                    m_IgnoreChange = true;
            //   45  109:aload_0         
            //   46  110:getfield        #13  <Field PrintableComponent this$0>
            //   47  113:iconst_1        
            //   48  114:putfield        #55  <Field boolean PrintableComponent.m_IgnoreChange>
                    PrintableComponent.m_CustomWidthText.setText("-1");
            //   49  117:getstatic       #38  <Field JTextField PrintableComponent.m_CustomWidthText>
            //   50  120:ldc1            #85  <String "-1">
            //   51  122:invokevirtual   #80  <Method void JTextField.setText(String)>
                    PrintableComponent.m_CustomHeightText.setText("-1");
            //   52  125:getstatic       #47  <Field JTextField PrintableComponent.m_CustomHeightText>
            //   53  128:ldc1            #85  <String "-1">
            //   54  130:invokevirtual   #80  <Method void JTextField.setText(String)>
                    m_IgnoreChange = false;
            //   55  133:aload_0         
            //   56  134:getfield        #13  <Field PrintableComponent this$0>
            //   57  137:iconst_0        
            //   58  138:putfield        #55  <Field boolean PrintableComponent.m_IgnoreChange>
                }
            //   59  141:return          
            }

            final PrintableComponent this$0;

            
            {
                this$0 = PrintableComponent.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PrintableComponent this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   42  103:getstatic       #166 <Field JCheckBox m_CustomDimensionsCheckBox>
    //   43  106:new             #172 <Class PrintableComponent$1>
    //   44  109:dup             
    //   45  110:aload_0         
    //   46  111:invokespecial   #175 <Method void PrintableComponent$1(PrintableComponent)>
    //   47  114:invokevirtual   #179 <Method void JCheckBox.addItemListener(ItemListener)>
        accessory.add(m_CustomDimensionsCheckBox);
    //   48  117:aload           5
    //   49  119:getstatic       #166 <Field JCheckBox m_CustomDimensionsCheckBox>
    //   50  122:invokevirtual   #183 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   51  125:pop             
        m_CustomWidthText = new JTextField(5);
    //   52  126:new             #185 <Class JTextField>
    //   53  129:dup             
    //   54  130:iconst_5        
    //   55  131:invokespecial   #188 <Method void JTextField(int)>
    //   56  134:putstatic       #190 <Field JTextField m_CustomWidthText>
        m_CustomWidthText.setText("-1");
    //   57  137:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   58  140:ldc1            #192 <String "-1">
    //   59  142:invokevirtual   #195 <Method void JTextField.setText(String)>
        m_CustomWidthText.setEnabled(false);
    //   60  145:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   61  148:iconst_0        
    //   62  149:invokevirtual   #198 <Method void JTextField.setEnabled(boolean)>
        m_CustomWidthText.setBounds(65, 35, 50, 21);
    //   63  152:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   64  155:bipush          65
    //   65  157:bipush          35
    //   66  159:bipush          50
    //   67  161:bipush          21
    //   68  163:invokevirtual   #199 <Method void JTextField.setBounds(int, int, int, int)>
        m_CustomWidthText.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e)
            {
                updateDimensions(PrintableComponent.m_CustomWidthText);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PrintableComponent this$0>
            //    2    4:getstatic       #28  <Field JTextField PrintableComponent.m_CustomWidthText>
            //    3    7:invokevirtual   #32  <Method void PrintableComponent.updateDimensions(JTextField)>
            //    4   10:return          
            }

            public void insertUpdate(DocumentEvent e)
            {
                updateDimensions(PrintableComponent.m_CustomWidthText);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PrintableComponent this$0>
            //    2    4:getstatic       #28  <Field JTextField PrintableComponent.m_CustomWidthText>
            //    3    7:invokevirtual   #32  <Method void PrintableComponent.updateDimensions(JTextField)>
            //    4   10:return          
            }

            public void removeUpdate(DocumentEvent e)
            {
                updateDimensions(PrintableComponent.m_CustomWidthText);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PrintableComponent this$0>
            //    2    4:getstatic       #28  <Field JTextField PrintableComponent.m_CustomWidthText>
            //    3    7:invokevirtual   #32  <Method void PrintableComponent.updateDimensions(JTextField)>
            //    4   10:return          
            }

            final PrintableComponent this$0;

            
            {
                this$0 = PrintableComponent.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PrintableComponent this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   69  166:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   70  169:invokevirtual   #203 <Method Document JTextField.getDocument()>
    //   71  172:new             #205 <Class PrintableComponent$2>
    //   72  175:dup             
    //   73  176:aload_0         
    //   74  177:invokespecial   #206 <Method void PrintableComponent$2(PrintableComponent)>
    //   75  180:invokeinterface #212 <Method void Document.addDocumentListener(DocumentListener)>
        JLabel label = new JLabel("Width");
    //   76  185:new             #214 <Class JLabel>
    //   77  188:dup             
    //   78  189:ldc1            #216 <String "Width">
    //   79  191:invokespecial   #217 <Method void JLabel(String)>
    //   80  194:astore          6
        label.setLabelFor(m_CustomWidthText);
    //   81  196:aload           6
    //   82  198:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   83  201:invokevirtual   #221 <Method void JLabel.setLabelFor(java.awt.Component)>
        label.setDisplayedMnemonic('W');
    //   84  204:aload           6
    //   85  206:bipush          87
    //   86  208:invokevirtual   #225 <Method void JLabel.setDisplayedMnemonic(char)>
        label.setBounds(14, 35, 50, 21);
    //   87  211:aload           6
    //   88  213:bipush          14
    //   89  215:bipush          35
    //   90  217:bipush          50
    //   91  219:bipush          21
    //   92  221:invokevirtual   #226 <Method void JLabel.setBounds(int, int, int, int)>
        accessory.add(label);
    //   93  224:aload           5
    //   94  226:aload           6
    //   95  228:invokevirtual   #183 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //   96  231:pop             
        accessory.add(m_CustomWidthText);
    //   97  232:aload           5
    //   98  234:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   99  237:invokevirtual   #183 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  100  240:pop             
        m_CustomHeightText = new JTextField(5);
    //  101  241:new             #185 <Class JTextField>
    //  102  244:dup             
    //  103  245:iconst_5        
    //  104  246:invokespecial   #188 <Method void JTextField(int)>
    //  105  249:putstatic       #228 <Field JTextField m_CustomHeightText>
        m_CustomHeightText.setText("-1");
    //  106  252:getstatic       #228 <Field JTextField m_CustomHeightText>
    //  107  255:ldc1            #192 <String "-1">
    //  108  257:invokevirtual   #195 <Method void JTextField.setText(String)>
        m_CustomHeightText.setEnabled(false);
    //  109  260:getstatic       #228 <Field JTextField m_CustomHeightText>
    //  110  263:iconst_0        
    //  111  264:invokevirtual   #198 <Method void JTextField.setEnabled(boolean)>
        m_CustomHeightText.setBounds(65, 63, 50, 21);
    //  112  267:getstatic       #228 <Field JTextField m_CustomHeightText>
    //  113  270:bipush          65
    //  114  272:bipush          63
    //  115  274:bipush          50
    //  116  276:bipush          21
    //  117  278:invokevirtual   #199 <Method void JTextField.setBounds(int, int, int, int)>
        m_CustomHeightText.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e)
            {
                updateDimensions(PrintableComponent.m_CustomHeightText);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PrintableComponent this$0>
            //    2    4:getstatic       #28  <Field JTextField PrintableComponent.m_CustomHeightText>
            //    3    7:invokevirtual   #32  <Method void PrintableComponent.updateDimensions(JTextField)>
            //    4   10:return          
            }

            public void insertUpdate(DocumentEvent e)
            {
                updateDimensions(PrintableComponent.m_CustomHeightText);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PrintableComponent this$0>
            //    2    4:getstatic       #28  <Field JTextField PrintableComponent.m_CustomHeightText>
            //    3    7:invokevirtual   #32  <Method void PrintableComponent.updateDimensions(JTextField)>
            //    4   10:return          
            }

            public void removeUpdate(DocumentEvent e)
            {
                updateDimensions(PrintableComponent.m_CustomHeightText);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field PrintableComponent this$0>
            //    2    4:getstatic       #28  <Field JTextField PrintableComponent.m_CustomHeightText>
            //    3    7:invokevirtual   #32  <Method void PrintableComponent.updateDimensions(JTextField)>
            //    4   10:return          
            }

            final PrintableComponent this$0;

            
            {
                this$0 = PrintableComponent.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PrintableComponent this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  118  281:getstatic       #228 <Field JTextField m_CustomHeightText>
    //  119  284:invokevirtual   #203 <Method Document JTextField.getDocument()>
    //  120  287:new             #230 <Class PrintableComponent$3>
    //  121  290:dup             
    //  122  291:aload_0         
    //  123  292:invokespecial   #231 <Method void PrintableComponent$3(PrintableComponent)>
    //  124  295:invokeinterface #212 <Method void Document.addDocumentListener(DocumentListener)>
        label = new JLabel("Height");
    //  125  300:new             #214 <Class JLabel>
    //  126  303:dup             
    //  127  304:ldc1            #233 <String "Height">
    //  128  306:invokespecial   #217 <Method void JLabel(String)>
    //  129  309:astore          6
        label.setLabelFor(m_CustomHeightText);
    //  130  311:aload           6
    //  131  313:getstatic       #228 <Field JTextField m_CustomHeightText>
    //  132  316:invokevirtual   #221 <Method void JLabel.setLabelFor(java.awt.Component)>
        label.setDisplayedMnemonic('H');
    //  133  319:aload           6
    //  134  321:bipush          72
    //  135  323:invokevirtual   #225 <Method void JLabel.setDisplayedMnemonic(char)>
        label.setBounds(14, 63, 50, 21);
    //  136  326:aload           6
    //  137  328:bipush          14
    //  138  330:bipush          63
    //  139  332:bipush          50
    //  140  334:bipush          21
    //  141  336:invokevirtual   #226 <Method void JLabel.setBounds(int, int, int, int)>
        accessory.add(label);
    //  142  339:aload           5
    //  143  341:aload           6
    //  144  343:invokevirtual   #183 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  145  346:pop             
        accessory.add(m_CustomHeightText);
    //  146  347:aload           5
    //  147  349:getstatic       #228 <Field JTextField m_CustomHeightText>
    //  148  352:invokevirtual   #183 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  149  355:pop             
        m_AspectRatioCheckBox = new JCheckBox("Keep aspect ratio");
    //  150  356:new             #160 <Class JCheckBox>
    //  151  359:dup             
    //  152  360:ldc1            #235 <String "Keep aspect ratio">
    //  153  362:invokespecial   #164 <Method void JCheckBox(String)>
    //  154  365:putstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
        m_AspectRatioCheckBox.setBounds(14, 91, 200, 21);
    //  155  368:getstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
    //  156  371:bipush          14
    //  157  373:bipush          91
    //  158  375:sipush          200
    //  159  378:bipush          21
    //  160  380:invokevirtual   #170 <Method void JCheckBox.setBounds(int, int, int, int)>
        m_AspectRatioCheckBox.setEnabled(false);
    //  161  383:getstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
    //  162  386:iconst_0        
    //  163  387:invokevirtual   #238 <Method void JCheckBox.setEnabled(boolean)>
        m_AspectRatioCheckBox.setSelected(true);
    //  164  390:getstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
    //  165  393:iconst_1        
    //  166  394:invokevirtual   #241 <Method void JCheckBox.setSelected(boolean)>
        m_AspectRatioCheckBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e)
            {
                boolean keep = PrintableComponent.m_AspectRatioCheckBox.isSelected();
            //    0    0:getstatic       #28  <Field JCheckBox PrintableComponent.m_AspectRatioCheckBox>
            //    1    3:invokevirtual   #34  <Method boolean JCheckBox.isSelected()>
            //    2    6:istore_2        
                if(keep)
            //*   3    7:iload_2         
            //*   4    8:ifeq            85
                {
                    m_IgnoreChange = true;
            //    5   11:aload_0         
            //    6   12:getfield        #13  <Field PrintableComponent this$0>
            //    7   15:iconst_1        
            //    8   16:putfield        #38  <Field boolean PrintableComponent.m_IgnoreChange>
                    PrintableComponent.m_CustomWidthText.setText((new StringBuilder()).append(m_Component.getWidth()).toString());
            //    9   19:getstatic       #42  <Field JTextField PrintableComponent.m_CustomWidthText>
            //   10   22:new             #44  <Class StringBuilder>
            //   11   25:dup             
            //   12   26:invokespecial   #45  <Method void StringBuilder()>
            //   13   29:aload_0         
            //   14   30:getfield        #13  <Field PrintableComponent this$0>
            //   15   33:getfield        #49  <Field JComponent PrintableComponent.m_Component>
            //   16   36:invokevirtual   #55  <Method int JComponent.getWidth()>
            //   17   39:invokevirtual   #59  <Method StringBuilder StringBuilder.append(int)>
            //   18   42:invokevirtual   #63  <Method String StringBuilder.toString()>
            //   19   45:invokevirtual   #69  <Method void JTextField.setText(String)>
                    PrintableComponent.m_CustomHeightText.setText((new StringBuilder()).append(m_Component.getHeight()).toString());
            //   20   48:getstatic       #72  <Field JTextField PrintableComponent.m_CustomHeightText>
            //   21   51:new             #44  <Class StringBuilder>
            //   22   54:dup             
            //   23   55:invokespecial   #45  <Method void StringBuilder()>
            //   24   58:aload_0         
            //   25   59:getfield        #13  <Field PrintableComponent this$0>
            //   26   62:getfield        #49  <Field JComponent PrintableComponent.m_Component>
            //   27   65:invokevirtual   #75  <Method int JComponent.getHeight()>
            //   28   68:invokevirtual   #59  <Method StringBuilder StringBuilder.append(int)>
            //   29   71:invokevirtual   #63  <Method String StringBuilder.toString()>
            //   30   74:invokevirtual   #69  <Method void JTextField.setText(String)>
                    m_IgnoreChange = false;
            //   31   77:aload_0         
            //   32   78:getfield        #13  <Field PrintableComponent this$0>
            //   33   81:iconst_0        
            //   34   82:putfield        #38  <Field boolean PrintableComponent.m_IgnoreChange>
                }
            //   35   85:return          
            }

            final PrintableComponent this$0;

            
            {
                this$0 = PrintableComponent.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field PrintableComponent this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //  167  397:getstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
    //  168  400:new             #243 <Class PrintableComponent$4>
    //  169  403:dup             
    //  170  404:aload_0         
    //  171  405:invokespecial   #244 <Method void PrintableComponent$4(PrintableComponent)>
    //  172  408:invokevirtual   #179 <Method void JCheckBox.addItemListener(ItemListener)>
        accessory.add(m_AspectRatioCheckBox);
    //  173  411:aload           5
    //  174  413:getstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
    //  175  416:invokevirtual   #183 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  176  419:pop             
        Vector writerNames = GenericObjectEditor.getClassnames(rm/gui/visualize/JComponentWriter.getName());
    //  177  420:ldc1            #246 <Class JComponentWriter>
    //  178  422:invokevirtual   #252 <Method String Class.getName()>
    //  179  425:invokestatic    #258 <Method Vector GenericObjectEditor.getClassnames(String)>
    //  180  428:astore_1        
        Collections.sort(writerNames);
    //  181  429:aload_1         
    //  182  430:invokestatic    #264 <Method void Collections.sort(java.util.List)>
        for(int i = 0; i < writerNames.size(); i++)
    //* 183  433:iconst_0        
    //* 184  434:istore_2        
    //* 185  435:goto            564
            try
            {
                Class cls = Class.forName(writerNames.get(i).toString());
    //  186  438:aload_1         
    //  187  439:iload_2         
    //  188  440:invokevirtual   #270 <Method Object Vector.get(int)>
    //  189  443:invokevirtual   #273 <Method String Object.toString()>
    //  190  446:invokestatic    #277 <Method Class Class.forName(String)>
    //  191  449:astore_3        
                JComponentWriter writer = (JComponentWriter)(JComponentWriter)cls.newInstance();
    //  192  450:aload_3         
    //  193  451:invokevirtual   #281 <Method Object Class.newInstance()>
    //  194  454:checkcast       #246 <Class JComponentWriter>
    //  195  457:checkcast       #246 <Class JComponentWriter>
    //  196  460:astore          4
                m_FileChooserPanel.addChoosableFileFilter(new JComponentWriterFileFilter(writer.getExtension(), (new StringBuilder(String.valueOf(writer.getDescription()))).append(" (*").append(writer.getExtension()).append(")").toString(), writer));
    //  197  462:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //  198  465:new             #283 <Class PrintableComponent$JComponentWriterFileFilter>
    //  199  468:dup             
    //  200  469:aload_0         
    //  201  470:aload           4
    //  202  472:invokevirtual   #286 <Method String JComponentWriter.getExtension()>
    //  203  475:new             #288 <Class StringBuilder>
    //  204  478:dup             
    //  205  479:aload           4
    //  206  481:invokevirtual   #291 <Method String JComponentWriter.getDescription()>
    //  207  484:invokestatic    #296 <Method String String.valueOf(Object)>
    //  208  487:invokespecial   #297 <Method void StringBuilder(String)>
    //  209  490:ldc2            #299 <String " (*">
    //  210  493:invokevirtual   #303 <Method StringBuilder StringBuilder.append(String)>
    //  211  496:aload           4
    //  212  498:invokevirtual   #286 <Method String JComponentWriter.getExtension()>
    //  213  501:invokevirtual   #303 <Method StringBuilder StringBuilder.append(String)>
    //  214  504:ldc2            #305 <String ")">
    //  215  507:invokevirtual   #303 <Method StringBuilder StringBuilder.append(String)>
    //  216  510:invokevirtual   #306 <Method String StringBuilder.toString()>
    //  217  513:aload           4
    //  218  515:invokespecial   #309 <Method void PrintableComponent$JComponentWriterFileFilter(PrintableComponent, String, String, JComponentWriter)>
    //  219  518:invokevirtual   #313 <Method void JFileChooser.addChoosableFileFilter(javax.swing.filechooser.FileFilter)>
            }
    //* 220  521:goto            561
            catch(Exception e)
    //* 221  524:astore          7
            {
                System.err.println((new StringBuilder()).append(writerNames.get(i)).append(": ").append(e).toString());
    //  222  526:getstatic       #319 <Field PrintStream System.err>
    //  223  529:new             #288 <Class StringBuilder>
    //  224  532:dup             
    //  225  533:invokespecial   #320 <Method void StringBuilder()>
    //  226  536:aload_1         
    //  227  537:iload_2         
    //  228  538:invokevirtual   #270 <Method Object Vector.get(int)>
    //  229  541:invokevirtual   #323 <Method StringBuilder StringBuilder.append(Object)>
    //  230  544:ldc2            #325 <String ": ">
    //  231  547:invokevirtual   #303 <Method StringBuilder StringBuilder.append(String)>
    //  232  550:aload           7
    //  233  552:invokevirtual   #323 <Method StringBuilder StringBuilder.append(Object)>
    //  234  555:invokevirtual   #306 <Method String StringBuilder.toString()>
    //  235  558:invokevirtual   #330 <Method void PrintStream.println(String)>
            }

    //  236  561:iinc            2  1
    //  237  564:iload_2         
    //  238  565:aload_1         
    //  239  566:invokevirtual   #334 <Method int Vector.size()>
    //  240  569:icmplt          438
        if(m_FileChooserPanel.getChoosableFileFilters().length > 0)
    //* 241  572:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //* 242  575:invokevirtual   #338 <Method javax.swing.filechooser.FileFilter[] JFileChooser.getChoosableFileFilters()>
    //* 243  578:arraylength     
    //* 244  579:ifle            596
            m_FileChooserPanel.setFileFilter(m_FileChooserPanel.getChoosableFileFilters()[0]);
    //  245  582:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //  246  585:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //  247  588:invokevirtual   #338 <Method javax.swing.filechooser.FileFilter[] JFileChooser.getChoosableFileFilters()>
    //  248  591:iconst_0        
    //  249  592:aaload          
    //  250  593:invokevirtual   #341 <Method void JFileChooser.setFileFilter(javax.swing.filechooser.FileFilter)>
    //  251  596:return          
    }

    protected void updateDimensions(JTextField sender)
    {
        if(!m_AspectRatioCheckBox.isSelected() || m_IgnoreChange)
    //*   0    0:getstatic       #237 <Field JCheckBox m_AspectRatioCheckBox>
    //*   1    3:invokevirtual   #357 <Method boolean JCheckBox.isSelected()>
    //*   2    6:ifeq            16
    //*   3    9:aload_0         
    //*   4   10:getfield        #359 <Field boolean m_IgnoreChange>
    //*   5   13:ifeq            17
            return;
    //    6   16:return          
        if(!(sender instanceof JTextField) || sender == null)
    //*   7   17:aload_1         
    //*   8   18:instanceof      #185 <Class JTextField>
    //*   9   21:ifeq            28
    //*  10   24:aload_1         
    //*  11   25:ifnonnull       29
            return;
    //   12   28:return          
        if(sender.getText().length() == 0)
    //*  13   29:aload_1         
    //*  14   30:invokevirtual   #362 <Method String JTextField.getText()>
    //*  15   33:invokevirtual   #365 <Method int String.length()>
    //*  16   36:ifne            40
            return;
    //   17   39:return          
        int baseValue;
        try
        {
            baseValue = Integer.parseInt(sender.getText());
    //   18   40:aload_1         
    //   19   41:invokevirtual   #362 <Method String JTextField.getText()>
    //   20   44:invokestatic    #371 <Method int Integer.parseInt(String)>
    //   21   47:istore_3        
            int newValue = 0;
    //   22   48:iconst_0        
    //   23   49:istore_2        
            if(baseValue <= 0)
    //*  24   50:iload_3         
    //*  25   51:ifgt            55
                return;
    //   26   54:return          
            if(Double.isNaN(m_AspectRatio))
    //*  27   55:aload_0         
    //*  28   56:getfield        #95  <Field double m_AspectRatio>
    //*  29   59:invokestatic    #377 <Method boolean Double.isNaN(double)>
    //*  30   62:ifeq            92
                m_AspectRatio = (double)getComponent().getWidth() / (double)getComponent().getHeight();
    //   31   65:aload_0         
    //   32   66:aload_0         
    //   33   67:invokevirtual   #99  <Method JComponent getComponent()>
    //   34   70:invokevirtual   #380 <Method int JComponent.getWidth()>
    //   35   73:i2d             
    //   36   74:aload_0         
    //   37   75:invokevirtual   #99  <Method JComponent getComponent()>
    //   38   78:invokevirtual   #383 <Method int JComponent.getHeight()>
    //   39   81:i2d             
    //   40   82:ddiv            
    //   41   83:putfield        #95  <Field double m_AspectRatio>
        }
    //*  42   86:goto            92
        catch(Exception e)
    //*  43   89:astore          4
        {
            return;
    //   44   91:return          
        }
        m_IgnoreChange = true;
    //   45   92:aload_0         
    //   46   93:iconst_1        
    //   47   94:putfield        #359 <Field boolean m_IgnoreChange>
        if(sender == m_CustomWidthText)
    //*  48   97:aload_1         
    //*  49   98:getstatic       #190 <Field JTextField m_CustomWidthText>
    //*  50  101:if_acmpne       138
        {
            int newValue = (int)((double)baseValue * (1.0D / m_AspectRatio));
    //   51  104:iload_3         
    //   52  105:i2d             
    //   53  106:dconst_1        
    //   54  107:aload_0         
    //   55  108:getfield        #95  <Field double m_AspectRatio>
    //   56  111:ddiv            
    //   57  112:dmul            
    //   58  113:d2i             
    //   59  114:istore_2        
            m_CustomHeightText.setText((new StringBuilder()).append(newValue).toString());
    //   60  115:getstatic       #228 <Field JTextField m_CustomHeightText>
    //   61  118:new             #288 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #320 <Method void StringBuilder()>
    //   64  125:iload_2         
    //   65  126:invokevirtual   #386 <Method StringBuilder StringBuilder.append(int)>
    //   66  129:invokevirtual   #306 <Method String StringBuilder.toString()>
    //   67  132:invokevirtual   #195 <Method void JTextField.setText(String)>
        } else
    //*  68  135:goto            174
        if(sender == m_CustomHeightText)
    //*  69  138:aload_1         
    //*  70  139:getstatic       #228 <Field JTextField m_CustomHeightText>
    //*  71  142:if_acmpne       174
        {
            int newValue = (int)((double)baseValue * m_AspectRatio);
    //   72  145:iload_3         
    //   73  146:i2d             
    //   74  147:aload_0         
    //   75  148:getfield        #95  <Field double m_AspectRatio>
    //   76  151:dmul            
    //   77  152:d2i             
    //   78  153:istore_2        
            m_CustomWidthText.setText((new StringBuilder()).append(newValue).toString());
    //   79  154:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   80  157:new             #288 <Class StringBuilder>
    //   81  160:dup             
    //   82  161:invokespecial   #320 <Method void StringBuilder()>
    //   83  164:iload_2         
    //   84  165:invokevirtual   #386 <Method StringBuilder StringBuilder.append(int)>
    //   85  168:invokevirtual   #306 <Method String StringBuilder.toString()>
    //   86  171:invokevirtual   #195 <Method void JTextField.setText(String)>
        }
        m_IgnoreChange = false;
    //   87  174:aload_0         
    //   88  175:iconst_0        
    //   89  176:putfield        #359 <Field boolean m_IgnoreChange>
    //   90  179:return          
    }

    public Hashtable getWriters()
    {
        Hashtable result = new Hashtable();
    //    0    0:new             #393 <Class Hashtable>
    //    1    3:dup             
    //    2    4:invokespecial   #394 <Method void Hashtable()>
    //    3    7:astore_1        
        for(int i = 0; i < m_FileChooserPanel.getChoosableFileFilters().length; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            41
        {
            JComponentWriter writer = ((JComponentWriterFileFilter)m_FileChooserPanel.getChoosableFileFilters()[i]).getWriter();
    //    7   13:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //    8   16:invokevirtual   #338 <Method javax.swing.filechooser.FileFilter[] JFileChooser.getChoosableFileFilters()>
    //    9   19:iload_2         
    //   10   20:aaload          
    //   11   21:checkcast       #283 <Class PrintableComponent$JComponentWriterFileFilter>
    //   12   24:invokevirtual   #398 <Method JComponentWriter PrintableComponent$JComponentWriterFileFilter.getWriter()>
    //   13   27:astore_3        
            result.put(writer.getDescription(), writer);
    //   14   28:aload_1         
    //   15   29:aload_3         
    //   16   30:invokevirtual   #291 <Method String JComponentWriter.getDescription()>
    //   17   33:aload_3         
    //   18   34:invokevirtual   #402 <Method Object Hashtable.put(Object, Object)>
    //   19   37:pop             
        }

    //   20   38:iinc            2  1
    //   21   41:iload_2         
    //   22   42:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //   23   45:invokevirtual   #338 <Method javax.swing.filechooser.FileFilter[] JFileChooser.getChoosableFileFilters()>
    //   24   48:arraylength     
    //   25   49:icmplt          13
        return result;
    //   26   52:aload_1         
    //   27   53:areturn         
    }

    public JComponentWriter getWriter(String name)
    {
        return (JComponentWriter)(JComponentWriter)getWriters().get(name);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #407 <Method Hashtable getWriters()>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #410 <Method Object Hashtable.get(Object)>
    //    4    8:checkcast       #246 <Class JComponentWriter>
    //    5   11:checkcast       #246 <Class JComponentWriter>
    //    6   14:areturn         
    }

    public void setSaveDialogTitle(String title)
    {
        m_SaveDialogTitle = title;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #85  <Field String m_SaveDialogTitle>
    //    3    5:return          
    }

    public String getSaveDialogTitle()
    {
        return m_SaveDialogTitle;
    //    0    0:aload_0         
    //    1    1:getfield        #85  <Field String m_SaveDialogTitle>
    //    2    4:areturn         
    }

    public void setScale(double x, double y)
    {
        m_xScale = x;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #87  <Field double m_xScale>
        m_yScale = y;
    //    3    5:aload_0         
    //    4    6:dload_3         
    //    5    7:putfield        #89  <Field double m_yScale>
    //    6   10:return          
    }

    public double getXScale()
    {
        return m_xScale;
    //    0    0:aload_0         
    //    1    1:getfield        #87  <Field double m_xScale>
    //    2    4:dreturn         
    }

    public double getYScale()
    {
        return m_xScale;
    //    0    0:aload_0         
    //    1    1:getfield        #87  <Field double m_xScale>
    //    2    4:dreturn         
    }

    public void saveComponent()
    {
        m_FileChooserPanel.setDialogTitle(getSaveDialogTitle());
    //    0    0:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //    1    3:aload_0         
    //    2    4:invokevirtual   #424 <Method String getSaveDialogTitle()>
    //    3    7:invokevirtual   #427 <Method void JFileChooser.setDialogTitle(String)>
        do
        {
            int result = m_FileChooserPanel.showSaveDialog(getComponent());
    //    4   10:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //    5   13:aload_0         
    //    6   14:invokevirtual   #99  <Method JComponent getComponent()>
    //    7   17:invokevirtual   #431 <Method int JFileChooser.showSaveDialog(java.awt.Component)>
    //    8   20:istore_1        
            if(result != 0)
    //*   9   21:iload_1         
    //*  10   22:ifeq            26
                return;
    //   11   25:return          
        } while(m_FileChooserPanel.getSelectedFile() == null);
    //   12   26:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //   13   29:invokevirtual   #435 <Method File JFileChooser.getSelectedFile()>
    //   14   32:ifnull          10
        try
        {
            JComponentWriterFileFilter filter = (JComponentWriterFileFilter)m_FileChooserPanel.getFileFilter();
    //   15   35:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //   16   38:invokevirtual   #439 <Method javax.swing.filechooser.FileFilter JFileChooser.getFileFilter()>
    //   17   41:checkcast       #283 <Class PrintableComponent$JComponentWriterFileFilter>
    //   18   44:astore          4
            File file = m_FileChooserPanel.getSelectedFile();
    //   19   46:getstatic       #126 <Field JFileChooser m_FileChooserPanel>
    //   20   49:invokevirtual   #435 <Method File JFileChooser.getSelectedFile()>
    //   21   52:astore_3        
            JComponentWriter writer = filter.getWriter();
    //   22   53:aload           4
    //   23   55:invokevirtual   #398 <Method JComponentWriter PrintableComponent$JComponentWriterFileFilter.getWriter()>
    //   24   58:astore_2        
            if(!file.getAbsolutePath().toLowerCase().endsWith(writer.getExtension().toLowerCase()))
    //*  25   59:aload_3         
    //*  26   60:invokevirtual   #444 <Method String File.getAbsolutePath()>
    //*  27   63:invokevirtual   #447 <Method String String.toLowerCase()>
    //*  28   66:aload_2         
    //*  29   67:invokevirtual   #286 <Method String JComponentWriter.getExtension()>
    //*  30   70:invokevirtual   #447 <Method String String.toLowerCase()>
    //*  31   73:invokevirtual   #451 <Method boolean String.endsWith(String)>
    //*  32   76:ifne            111
                file = new File((new StringBuilder(String.valueOf(file.getAbsolutePath()))).append(writer.getExtension()).toString());
    //   33   79:new             #441 <Class File>
    //   34   82:dup             
    //   35   83:new             #288 <Class StringBuilder>
    //   36   86:dup             
    //   37   87:aload_3         
    //   38   88:invokevirtual   #444 <Method String File.getAbsolutePath()>
    //   39   91:invokestatic    #296 <Method String String.valueOf(Object)>
    //   40   94:invokespecial   #297 <Method void StringBuilder(String)>
    //   41   97:aload_2         
    //   42   98:invokevirtual   #286 <Method String JComponentWriter.getExtension()>
    //   43  101:invokevirtual   #303 <Method StringBuilder StringBuilder.append(String)>
    //   44  104:invokevirtual   #306 <Method String StringBuilder.toString()>
    //   45  107:invokespecial   #452 <Method void File(String)>
    //   46  110:astore_3        
            writer.setComponent(getComponent());
    //   47  111:aload_2         
    //   48  112:aload_0         
    //   49  113:invokevirtual   #99  <Method JComponent getComponent()>
    //   50  116:invokevirtual   #455 <Method void JComponentWriter.setComponent(JComponent)>
            writer.setFile(file);
    //   51  119:aload_2         
    //   52  120:aload_3         
    //   53  121:invokevirtual   #459 <Method void JComponentWriter.setFile(File)>
            writer.setScale(getXScale(), getYScale());
    //   54  124:aload_2         
    //   55  125:aload_0         
    //   56  126:invokevirtual   #461 <Method double getXScale()>
    //   57  129:aload_0         
    //   58  130:invokevirtual   #463 <Method double getYScale()>
    //   59  133:invokevirtual   #465 <Method void JComponentWriter.setScale(double, double)>
            writer.setUseCustomDimensions(m_CustomDimensionsCheckBox.isSelected());
    //   60  136:aload_2         
    //   61  137:getstatic       #166 <Field JCheckBox m_CustomDimensionsCheckBox>
    //   62  140:invokevirtual   #357 <Method boolean JCheckBox.isSelected()>
    //   63  143:invokevirtual   #468 <Method void JComponentWriter.setUseCustomDimensions(boolean)>
            if(m_CustomDimensionsCheckBox.isSelected())
    //*  64  146:getstatic       #166 <Field JCheckBox m_CustomDimensionsCheckBox>
    //*  65  149:invokevirtual   #357 <Method boolean JCheckBox.isSelected()>
    //*  66  152:ifeq            184
            {
                writer.setCustomWidth(Integer.parseInt(m_CustomWidthText.getText()));
    //   67  155:aload_2         
    //   68  156:getstatic       #190 <Field JTextField m_CustomWidthText>
    //   69  159:invokevirtual   #362 <Method String JTextField.getText()>
    //   70  162:invokestatic    #371 <Method int Integer.parseInt(String)>
    //   71  165:invokevirtual   #471 <Method void JComponentWriter.setCustomWidth(int)>
                writer.setCustomHeight(Integer.parseInt(m_CustomHeightText.getText()));
    //   72  168:aload_2         
    //   73  169:getstatic       #228 <Field JTextField m_CustomHeightText>
    //   74  172:invokevirtual   #362 <Method String JTextField.getText()>
    //   75  175:invokestatic    #371 <Method int Integer.parseInt(String)>
    //   76  178:invokevirtual   #474 <Method void JComponentWriter.setCustomHeight(int)>
            } else
    //*  77  181:goto            194
            {
                writer.setCustomWidth(-1);
    //   78  184:aload_2         
    //   79  185:iconst_m1       
    //   80  186:invokevirtual   #471 <Method void JComponentWriter.setCustomWidth(int)>
                writer.setCustomHeight(-1);
    //   81  189:aload_2         
    //   82  190:iconst_m1       
    //   83  191:invokevirtual   #474 <Method void JComponentWriter.setCustomHeight(int)>
            }
            writer.toOutput();
    //   84  194:aload_2         
    //   85  195:invokevirtual   #477 <Method void JComponentWriter.toOutput()>
        }
    //*  86  198:goto            208
        catch(Exception e)
    //*  87  201:astore          5
        {
            e.printStackTrace();
    //   88  203:aload           5
    //   89  205:invokevirtual   #480 <Method void Exception.printStackTrace()>
        }
    //   90  208:return          
    }

    protected JComponent m_Component;
    protected static JFileChooser m_FileChooserPanel;
    protected static JCheckBox m_CustomDimensionsCheckBox;
    protected static JTextField m_CustomWidthText;
    protected static JTextField m_CustomHeightText;
    protected static JCheckBox m_AspectRatioCheckBox;
    protected String m_SaveDialogTitle;
    protected double m_xScale;
    protected double m_yScale;
    protected double m_AspectRatio;
    protected boolean m_IgnoreChange;
    private static final boolean DEBUG = false;
    protected static boolean m_ToolTipUserAsked = false;
    protected static final String PROPERTY_SHOW = "PrintableComponentToolTipShow";
    protected static final String PROPERTY_USERASKED = "PrintableComponentToolTipUserAsked";
    protected static boolean m_ShowToolTip = true;
    static Class class$0;
    static Class class$1;

    static 
    {
    //    0    0:iconst_0        
    //    1    1:putstatic       #43  <Field boolean m_ToolTipUserAsked>
    //    2    4:iconst_1        
    //    3    5:putstatic       #45  <Field boolean m_ShowToolTip>
        try
        {
            m_ShowToolTip = Boolean.valueOf(VisualizeUtils.VISUALIZE_PROPERTIES.getProperty("PrintableComponentToolTipShow", "true")).booleanValue();
    //    4    8:getstatic       #51  <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //    5   11:ldc1            #31  <String "PrintableComponentToolTipShow">
    //    6   13:ldc1            #53  <String "true">
    //    7   15:invokevirtual   #59  <Method String Properties.getProperty(String, String)>
    //    8   18:invokestatic    #65  <Method Boolean Boolean.valueOf(String)>
    //    9   21:invokevirtual   #69  <Method boolean Boolean.booleanValue()>
    //   10   24:putstatic       #45  <Field boolean m_ShowToolTip>
            m_ToolTipUserAsked = Boolean.valueOf(VisualizeUtils.VISUALIZE_PROPERTIES.getProperty("PrintableComponentToolTipUserAsked", "false")).booleanValue();
    //   11   27:getstatic       #51  <Field Properties VisualizeUtils.VISUALIZE_PROPERTIES>
    //   12   30:ldc1            #34  <String "PrintableComponentToolTipUserAsked">
    //   13   32:ldc1            #71  <String "false">
    //   14   34:invokevirtual   #59  <Method String Properties.getProperty(String, String)>
    //   15   37:invokestatic    #65  <Method Boolean Boolean.valueOf(String)>
    //   16   40:invokevirtual   #69  <Method boolean Boolean.booleanValue()>
    //   17   43:putstatic       #43  <Field boolean m_ToolTipUserAsked>
        }
    //*  18   46:goto            58
        catch(Exception e)
    //*  19   49:astore_0        
        {
            m_ToolTipUserAsked = false;
    //   20   50:iconst_0        
    //   21   51:putstatic       #43  <Field boolean m_ToolTipUserAsked>
            m_ShowToolTip = true;
    //   22   54:iconst_1        
    //   23   55:putstatic       #45  <Field boolean m_ShowToolTip>
        }
    //*  24   58:return          
    }
}

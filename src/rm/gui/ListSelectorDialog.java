// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ListSelectorDialog.java

package rm.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.regex.Pattern;
import javax.swing.*;

public class ListSelectorDialog extends JDialog
{

    public ListSelectorDialog(Frame parentFrame, JList userList)
    {
        super(parentFrame, "Select items", true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:ldc1            #28  <String "Select items">
    //    3    4:iconst_1        
    //    4    5:invokespecial   #31  <Method void JDialog(Frame, String, boolean)>
        m_SelectBut = new JButton("Select");
    //    5    8:aload_0         
    //    6    9:new             #33  <Class JButton>
    //    7   12:dup             
    //    8   13:ldc1            #35  <String "Select">
    //    9   15:invokespecial   #38  <Method void JButton(String)>
    //   10   18:putfield        #40  <Field JButton m_SelectBut>
        m_CancelBut = new JButton("Cancel");
    //   11   21:aload_0         
    //   12   22:new             #33  <Class JButton>
    //   13   25:dup             
    //   14   26:ldc1            #42  <String "Cancel">
    //   15   28:invokespecial   #38  <Method void JButton(String)>
    //   16   31:putfield        #44  <Field JButton m_CancelBut>
        m_PatternBut = new JButton("Pattern");
    //   17   34:aload_0         
    //   18   35:new             #33  <Class JButton>
    //   19   38:dup             
    //   20   39:ldc1            #46  <String "Pattern">
    //   21   41:invokespecial   #38  <Method void JButton(String)>
    //   22   44:putfield        #48  <Field JButton m_PatternBut>
        m_PatternRegEx = ".*";
    //   23   47:aload_0         
    //   24   48:ldc1            #50  <String ".*">
    //   25   50:putfield        #52  <Field String m_PatternRegEx>
        m_List = userList;
    //   26   53:aload_0         
    //   27   54:aload_2         
    //   28   55:putfield        #54  <Field JList m_List>
        m_CancelBut.setMnemonic('C');
    //   29   58:aload_0         
    //   30   59:getfield        #44  <Field JButton m_CancelBut>
    //   31   62:bipush          67
    //   32   64:invokevirtual   #58  <Method void JButton.setMnemonic(char)>
        m_CancelBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Result = 1;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field ListSelectorDialog this$0>
            //    2    4:iconst_1        
            //    3    5:putfield        #28  <Field int ListSelectorDialog.m_Result>
                setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field ListSelectorDialog this$0>
            //    6   12:iconst_0        
            //    7   13:invokevirtual   #32  <Method void ListSelectorDialog.setVisible(boolean)>
            //    8   16:return          
            }

            final ListSelectorDialog this$0;

            
            {
                this$0 = ListSelectorDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ListSelectorDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   33   67:aload_0         
    //   34   68:getfield        #44  <Field JButton m_CancelBut>
    //   35   71:new             #60  <Class ListSelectorDialog$1>
    //   36   74:dup             
    //   37   75:aload_0         
    //   38   76:invokespecial   #63  <Method void ListSelectorDialog$1(ListSelectorDialog)>
    //   39   79:invokevirtual   #67  <Method void JButton.addActionListener(ActionListener)>
        m_SelectBut.setMnemonic('S');
    //   40   82:aload_0         
    //   41   83:getfield        #40  <Field JButton m_SelectBut>
    //   42   86:bipush          83
    //   43   88:invokevirtual   #58  <Method void JButton.setMnemonic(char)>
        m_SelectBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Result = 0;
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field ListSelectorDialog this$0>
            //    2    4:iconst_0        
            //    3    5:putfield        #28  <Field int ListSelectorDialog.m_Result>
                setVisible(false);
            //    4    8:aload_0         
            //    5    9:getfield        #13  <Field ListSelectorDialog this$0>
            //    6   12:iconst_0        
            //    7   13:invokevirtual   #32  <Method void ListSelectorDialog.setVisible(boolean)>
            //    8   16:return          
            }

            final ListSelectorDialog this$0;

            
            {
                this$0 = ListSelectorDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ListSelectorDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   44   91:aload_0         
    //   45   92:getfield        #40  <Field JButton m_SelectBut>
    //   46   95:new             #69  <Class ListSelectorDialog$2>
    //   47   98:dup             
    //   48   99:aload_0         
    //   49  100:invokespecial   #70  <Method void ListSelectorDialog$2(ListSelectorDialog)>
    //   50  103:invokevirtual   #67  <Method void JButton.addActionListener(ActionListener)>
        m_PatternBut.setMnemonic('P');
    //   51  106:aload_0         
    //   52  107:getfield        #48  <Field JButton m_PatternBut>
    //   53  110:bipush          80
    //   54  112:invokevirtual   #58  <Method void JButton.setMnemonic(char)>
        m_PatternBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                selectPattern();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field ListSelectorDialog this$0>
            //    2    4:invokevirtual   #27  <Method void ListSelectorDialog.selectPattern()>
            //    3    7:return          
            }

            final ListSelectorDialog this$0;

            
            {
                this$0 = ListSelectorDialog.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ListSelectorDialog this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   55  115:aload_0         
    //   56  116:getfield        #48  <Field JButton m_PatternBut>
    //   57  119:new             #72  <Class ListSelectorDialog$3>
    //   58  122:dup             
    //   59  123:aload_0         
    //   60  124:invokespecial   #73  <Method void ListSelectorDialog$3(ListSelectorDialog)>
    //   61  127:invokevirtual   #67  <Method void JButton.addActionListener(ActionListener)>
        Container c = getContentPane();
    //   62  130:aload_0         
    //   63  131:invokevirtual   #77  <Method Container getContentPane()>
    //   64  134:astore_3        
        c.setLayout(new BorderLayout());
    //   65  135:aload_3         
    //   66  136:new             #79  <Class BorderLayout>
    //   67  139:dup             
    //   68  140:invokespecial   #82  <Method void BorderLayout()>
    //   69  143:invokevirtual   #88  <Method void Container.setLayout(java.awt.LayoutManager)>
        Box b1 = new Box(0);
    //   70  146:new             #90  <Class Box>
    //   71  149:dup             
    //   72  150:iconst_0        
    //   73  151:invokespecial   #93  <Method void Box(int)>
    //   74  154:astore          4
        b1.add(m_SelectBut);
    //   75  156:aload           4
    //   76  158:aload_0         
    //   77  159:getfield        #40  <Field JButton m_SelectBut>
    //   78  162:invokevirtual   #97  <Method java.awt.Component Box.add(java.awt.Component)>
    //   79  165:pop             
        b1.add(Box.createHorizontalStrut(10));
    //   80  166:aload           4
    //   81  168:bipush          10
    //   82  170:invokestatic    #101 <Method java.awt.Component Box.createHorizontalStrut(int)>
    //   83  173:invokevirtual   #97  <Method java.awt.Component Box.add(java.awt.Component)>
    //   84  176:pop             
        b1.add(m_PatternBut);
    //   85  177:aload           4
    //   86  179:aload_0         
    //   87  180:getfield        #48  <Field JButton m_PatternBut>
    //   88  183:invokevirtual   #97  <Method java.awt.Component Box.add(java.awt.Component)>
    //   89  186:pop             
        b1.add(Box.createHorizontalStrut(10));
    //   90  187:aload           4
    //   91  189:bipush          10
    //   92  191:invokestatic    #101 <Method java.awt.Component Box.createHorizontalStrut(int)>
    //   93  194:invokevirtual   #97  <Method java.awt.Component Box.add(java.awt.Component)>
    //   94  197:pop             
        b1.add(m_CancelBut);
    //   95  198:aload           4
    //   96  200:aload_0         
    //   97  201:getfield        #44  <Field JButton m_CancelBut>
    //   98  204:invokevirtual   #97  <Method java.awt.Component Box.add(java.awt.Component)>
    //   99  207:pop             
        c.add(b1, "South");
    //  100  208:aload_3         
    //  101  209:aload           4
    //  102  211:ldc1            #103 <String "South">
    //  103  213:invokevirtual   #106 <Method void Container.add(java.awt.Component, Object)>
        c.add(new JScrollPane(m_List), "Center");
    //  104  216:aload_3         
    //  105  217:new             #108 <Class JScrollPane>
    //  106  220:dup             
    //  107  221:aload_0         
    //  108  222:getfield        #54  <Field JList m_List>
    //  109  225:invokespecial   #111 <Method void JScrollPane(java.awt.Component)>
    //  110  228:ldc1            #113 <String "Center">
    //  111  230:invokevirtual   #106 <Method void Container.add(java.awt.Component, Object)>
        getRootPane().setDefaultButton(m_SelectBut);
    //  112  233:aload_0         
    //  113  234:invokevirtual   #117 <Method JRootPane getRootPane()>
    //  114  237:aload_0         
    //  115  238:getfield        #40  <Field JButton m_SelectBut>
    //  116  241:invokevirtual   #123 <Method void JRootPane.setDefaultButton(JButton)>
        pack();
    //  117  244:aload_0         
    //  118  245:invokevirtual   #126 <Method void pack()>
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    //  119  248:invokestatic    #132 <Method Toolkit Toolkit.getDefaultToolkit()>
    //  120  251:invokevirtual   #136 <Method Dimension Toolkit.getScreenSize()>
    //  121  254:astore          5
        int width = (double)getWidth() <= screen.getWidth() ? getWidth() : (int)screen.getWidth();
    //  122  256:aload_0         
    //  123  257:invokevirtual   #140 <Method int getWidth()>
    //  124  260:i2d             
    //  125  261:aload           5
    //  126  263:invokevirtual   #145 <Method double Dimension.getWidth()>
    //  127  266:dcmpl           
    //  128  267:ifle            279
    //  129  270:aload           5
    //  130  272:invokevirtual   #145 <Method double Dimension.getWidth()>
    //  131  275:d2i             
    //  132  276:goto            283
    //  133  279:aload_0         
    //  134  280:invokevirtual   #140 <Method int getWidth()>
    //  135  283:istore          6
        int height = (double)getHeight() <= screen.getHeight() ? getHeight() : (int)screen.getHeight();
    //  136  285:aload_0         
    //  137  286:invokevirtual   #148 <Method int getHeight()>
    //  138  289:i2d             
    //  139  290:aload           5
    //  140  292:invokevirtual   #150 <Method double Dimension.getHeight()>
    //  141  295:dcmpl           
    //  142  296:ifle            308
    //  143  299:aload           5
    //  144  301:invokevirtual   #150 <Method double Dimension.getHeight()>
    //  145  304:d2i             
    //  146  305:goto            312
    //  147  308:aload_0         
    //  148  309:invokevirtual   #148 <Method int getHeight()>
    //  149  312:istore          7
        setSize(width, height);
    //  150  314:aload_0         
    //  151  315:iload           6
    //  152  317:iload           7
    //  153  319:invokevirtual   #154 <Method void setSize(int, int)>
    //  154  322:return          
    }

    public int showDialog()
    {
        m_Result = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #172 <Field int m_Result>
        int origSelected[] = m_List.getSelectedIndices();
    //    3    5:aload_0         
    //    4    6:getfield        #54  <Field JList m_List>
    //    5    9:invokevirtual   #178 <Method int[] JList.getSelectedIndices()>
    //    6   12:astore_1        
        setVisible(true);
    //    7   13:aload_0         
    //    8   14:iconst_1        
    //    9   15:invokevirtual   #182 <Method void setVisible(boolean)>
        if(m_Result == 1)
    //*  10   18:aload_0         
    //*  11   19:getfield        #172 <Field int m_Result>
    //*  12   22:iconst_1        
    //*  13   23:icmpne          34
            m_List.setSelectedIndices(origSelected);
    //   14   26:aload_0         
    //   15   27:getfield        #54  <Field JList m_List>
    //   16   30:aload_1         
    //   17   31:invokevirtual   #186 <Method void JList.setSelectedIndices(int[])>
        return m_Result;
    //   18   34:aload_0         
    //   19   35:getfield        #172 <Field int m_Result>
    //   20   38:ireturn         
    }

    protected void selectPattern()
    {
        String pattern = JOptionPane.showInputDialog(m_PatternBut.getParent(), "Enter a Perl regular expression ('.*' for all)", m_PatternRegEx);
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field JButton m_PatternBut>
    //    2    4:invokevirtual   #192 <Method Container JButton.getParent()>
    //    3    7:ldc1            #194 <String "Enter a Perl regular expression ('.*' for all)">
    //    4    9:aload_0         
    //    5   10:getfield        #52  <Field String m_PatternRegEx>
    //    6   13:invokestatic    #200 <Method String JOptionPane.showInputDialog(java.awt.Component, Object, Object)>
    //    7   16:astore_1        
        if(pattern != null)
    //*   8   17:aload_1         
    //*   9   18:ifnull          141
            try
            {
                Pattern.compile(pattern);
    //   10   21:aload_1         
    //   11   22:invokestatic    #206 <Method Pattern Pattern.compile(String)>
    //   12   25:pop             
                m_PatternRegEx = pattern;
    //   13   26:aload_0         
    //   14   27:aload_1         
    //   15   28:putfield        #52  <Field String m_PatternRegEx>
                m_List.clearSelection();
    //   16   31:aload_0         
    //   17   32:getfield        #54  <Field JList m_List>
    //   18   35:invokevirtual   #209 <Method void JList.clearSelection()>
                for(int i = 0; i < m_List.getModel().getSize(); i++)
    //*  19   38:iconst_0        
    //*  20   39:istore_2        
    //*  21   40:goto            78
                    if(Pattern.matches(pattern, m_List.getModel().getElementAt(i).toString()))
    //*  22   43:aload_1         
    //*  23   44:aload_0         
    //*  24   45:getfield        #54  <Field JList m_List>
    //*  25   48:invokevirtual   #213 <Method ListModel JList.getModel()>
    //*  26   51:iload_2         
    //*  27   52:invokeinterface #219 <Method Object ListModel.getElementAt(int)>
    //*  28   57:invokevirtual   #225 <Method String Object.toString()>
    //*  29   60:invokestatic    #229 <Method boolean Pattern.matches(String, CharSequence)>
    //*  30   63:ifeq            75
                        m_List.addSelectionInterval(i, i);
    //   31   66:aload_0         
    //   32   67:getfield        #54  <Field JList m_List>
    //   33   70:iload_2         
    //   34   71:iload_2         
    //   35   72:invokevirtual   #232 <Method void JList.addSelectionInterval(int, int)>

    //   36   75:iinc            2  1
    //   37   78:iload_2         
    //   38   79:aload_0         
    //   39   80:getfield        #54  <Field JList m_List>
    //   40   83:invokevirtual   #213 <Method ListModel JList.getModel()>
    //   41   86:invokeinterface #235 <Method int ListModel.getSize()>
    //   42   91:icmplt          43
            }
    //*  43   94:goto            141
            catch(Exception ex)
    //*  44   97:astore_2        
            {
                JOptionPane.showMessageDialog(m_PatternBut.getParent(), (new StringBuilder("'")).append(pattern).append("' is not a valid Perl regular expression!\n").append("Error: ").append(ex).toString(), "Error in Pattern...", 0);
    //   45   98:aload_0         
    //   46   99:getfield        #48  <Field JButton m_PatternBut>
    //   47  102:invokevirtual   #192 <Method Container JButton.getParent()>
    //   48  105:new             #237 <Class StringBuilder>
    //   49  108:dup             
    //   50  109:ldc1            #239 <String "'">
    //   51  111:invokespecial   #240 <Method void StringBuilder(String)>
    //   52  114:aload_1         
    //   53  115:invokevirtual   #244 <Method StringBuilder StringBuilder.append(String)>
    //   54  118:ldc1            #246 <String "' is not a valid Perl regular expression!\n">
    //   55  120:invokevirtual   #244 <Method StringBuilder StringBuilder.append(String)>
    //   56  123:ldc1            #248 <String "Error: ">
    //   57  125:invokevirtual   #244 <Method StringBuilder StringBuilder.append(String)>
    //   58  128:aload_2         
    //   59  129:invokevirtual   #251 <Method StringBuilder StringBuilder.append(Object)>
    //   60  132:invokevirtual   #252 <Method String StringBuilder.toString()>
    //   61  135:ldc1            #254 <String "Error in Pattern...">
    //   62  137:iconst_0        
    //   63  138:invokestatic    #258 <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
            }
    //   64  141:return          
    }

    public static void main(String args[])
    {
        try
        {
            DefaultListModel lm = new DefaultListModel();
    //    0    0:new             #268 <Class DefaultListModel>
    //    1    3:dup             
    //    2    4:invokespecial   #269 <Method void DefaultListModel()>
    //    3    7:astore_1        
            lm.addElement("one");
    //    4    8:aload_1         
    //    5    9:ldc2            #271 <String "one">
    //    6   12:invokevirtual   #275 <Method void DefaultListModel.addElement(Object)>
            lm.addElement("two");
    //    7   15:aload_1         
    //    8   16:ldc2            #277 <String "two">
    //    9   19:invokevirtual   #275 <Method void DefaultListModel.addElement(Object)>
            lm.addElement("three");
    //   10   22:aload_1         
    //   11   23:ldc2            #279 <String "three">
    //   12   26:invokevirtual   #275 <Method void DefaultListModel.addElement(Object)>
            lm.addElement("four");
    //   13   29:aload_1         
    //   14   30:ldc2            #281 <String "four">
    //   15   33:invokevirtual   #275 <Method void DefaultListModel.addElement(Object)>
            lm.addElement("five");
    //   16   36:aload_1         
    //   17   37:ldc2            #283 <String "five">
    //   18   40:invokevirtual   #275 <Method void DefaultListModel.addElement(Object)>
            JList jl = new JList(lm);
    //   19   43:new             #174 <Class JList>
    //   20   46:dup             
    //   21   47:aload_1         
    //   22   48:invokespecial   #286 <Method void JList(ListModel)>
    //   23   51:astore_2        
            ListSelectorDialog jd = new ListSelectorDialog(null, jl);
    //   24   52:new             #2   <Class ListSelectorDialog>
    //   25   55:dup             
    //   26   56:aconst_null     
    //   27   57:aload_2         
    //   28   58:invokespecial   #288 <Method void ListSelectorDialog(Frame, JList)>
    //   29   61:astore_3        
            int result = jd.showDialog();
    //   30   62:aload_3         
    //   31   63:invokevirtual   #290 <Method int showDialog()>
    //   32   66:istore          4
            if(result == 0)
    //*  33   68:iload           4
    //*  34   70:ifne            150
            {
                System.err.println("Fields Selected");
    //   35   73:getstatic       #296 <Field PrintStream System.err>
    //   36   76:ldc2            #298 <String "Fields Selected">
    //   37   79:invokevirtual   #303 <Method void PrintStream.println(String)>
                int selected[] = jl.getSelectedIndices();
    //   38   82:aload_2         
    //   39   83:invokevirtual   #178 <Method int[] JList.getSelectedIndices()>
    //   40   86:astore          5
                for(int i = 0; i < selected.length; i++)
    //*  41   88:iconst_0        
    //*  42   89:istore          6
    //*  43   91:goto            139
                    System.err.println((new StringBuilder()).append(selected[i]).append(" ").append(lm.elementAt(selected[i])).toString());
    //   44   94:getstatic       #296 <Field PrintStream System.err>
    //   45   97:new             #237 <Class StringBuilder>
    //   46  100:dup             
    //   47  101:invokespecial   #304 <Method void StringBuilder()>
    //   48  104:aload           5
    //   49  106:iload           6
    //   50  108:iaload          
    //   51  109:invokevirtual   #307 <Method StringBuilder StringBuilder.append(int)>
    //   52  112:ldc2            #309 <String " ">
    //   53  115:invokevirtual   #244 <Method StringBuilder StringBuilder.append(String)>
    //   54  118:aload_1         
    //   55  119:aload           5
    //   56  121:iload           6
    //   57  123:iaload          
    //   58  124:invokevirtual   #312 <Method Object DefaultListModel.elementAt(int)>
    //   59  127:invokevirtual   #251 <Method StringBuilder StringBuilder.append(Object)>
    //   60  130:invokevirtual   #252 <Method String StringBuilder.toString()>
    //   61  133:invokevirtual   #303 <Method void PrintStream.println(String)>

    //   62  136:iinc            6  1
    //   63  139:iload           6
    //   64  141:aload           5
    //   65  143:arraylength     
    //   66  144:icmplt          94
            } else
    //*  67  147:goto            159
            {
                System.err.println("Cancelled");
    //   68  150:getstatic       #296 <Field PrintStream System.err>
    //   69  153:ldc2            #314 <String "Cancelled">
    //   70  156:invokevirtual   #303 <Method void PrintStream.println(String)>
            }
            System.exit(0);
    //   71  159:iconst_0        
    //   72  160:invokestatic    #317 <Method void System.exit(int)>
        }
    //*  73  163:goto            181
        catch(Exception ex)
    //*  74  166:astore_1        
        {
            ex.printStackTrace();
    //   75  167:aload_1         
    //   76  168:invokevirtual   #320 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   77  171:getstatic       #296 <Field PrintStream System.err>
    //   78  174:aload_1         
    //   79  175:invokevirtual   #323 <Method String Exception.getMessage()>
    //   80  178:invokevirtual   #303 <Method void PrintStream.println(String)>
        }
    //   81  181:return          
    }

    private static final long serialVersionUID = 0xc9348bd0d45a67fL;
    protected JButton m_SelectBut;
    protected JButton m_CancelBut;
    protected JButton m_PatternBut;
    protected JList m_List;
    protected int m_Result;
    public static final int APPROVE_OPTION = 0;
    public static final int CANCEL_OPTION = 1;
    protected String m_PatternRegEx;
}

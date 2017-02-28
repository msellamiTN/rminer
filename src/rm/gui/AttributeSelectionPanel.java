// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributeSelectionPanel.java

package rm.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.*;
import rm.core.Attribute;
import rm.core.Instances;

public class AttributeSelectionPanel extends JPanel
{
    class AttributeTableModel extends AbstractTableModel
    {

        public void setInstances(Instances instances)
        {
            m_Instances = instances;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #34  <Field Instances m_Instances>
            m_Selected = new boolean[m_Instances.numAttributes()];
        //    3    5:aload_0         
        //    4    6:aload_0         
        //    5    7:getfield        #34  <Field Instances m_Instances>
        //    6   10:invokevirtual   #40  <Method int Instances.numAttributes()>
        //    7   13:newarray        boolean[]
        //    8   15:putfield        #42  <Field boolean[] m_Selected>
        //    9   18:return          
        }

        public int getRowCount()
        {
            return m_Selected.length;
        //    0    0:aload_0         
        //    1    1:getfield        #42  <Field boolean[] m_Selected>
        //    2    4:arraylength     
        //    3    5:ireturn         
        }

        public int getColumnCount()
        {
            return 3;
        //    0    0:iconst_3        
        //    1    1:ireturn         
        }

        public Object getValueAt(int row, int column)
        {
            switch(column)
        //*   0    0:iload_2         
            {
        //*   1    1:tableswitch     0 2: default 65
        //                       0 28
        //                       1 39
        //                       2 53
            case 0: // '\0'
                return new Integer(row + 1);
        //    2   28:new             #48  <Class Integer>
        //    3   31:dup             
        //    4   32:iload_1         
        //    5   33:iconst_1        
        //    6   34:iadd            
        //    7   35:invokespecial   #51  <Method void Integer(int)>
        //    8   38:areturn         

            case 1: // '\001'
                return new Boolean(m_Selected[row]);
        //    9   39:new             #53  <Class Boolean>
        //   10   42:dup             
        //   11   43:aload_0         
        //   12   44:getfield        #42  <Field boolean[] m_Selected>
        //   13   47:iload_1         
        //   14   48:baload          
        //   15   49:invokespecial   #56  <Method void Boolean(boolean)>
        //   16   52:areturn         

            case 2: // '\002'
                return m_Instances.attribute(row).name();
        //   17   53:aload_0         
        //   18   54:getfield        #34  <Field Instances m_Instances>
        //   19   57:iload_1         
        //   20   58:invokevirtual   #60  <Method Attribute Instances.attribute(int)>
        //   21   61:invokevirtual   #66  <Method String Attribute.name()>
        //   22   64:areturn         
            }
            return null;
        //   23   65:aconst_null     
        //   24   66:areturn         
        }

        public String getColumnName(int column)
        {
            switch(column)
        //*   0    0:iload_1         
            {
        //*   1    1:tableswitch     0 2: default 58
        //                       0 28
        //                       1 38
        //                       2 48
            case 0: // '\0'
                return new String("No.");
        //    2   28:new             #73  <Class String>
        //    3   31:dup             
        //    4   32:ldc1            #75  <String "No.">
        //    5   34:invokespecial   #78  <Method void String(String)>
        //    6   37:areturn         

            case 1: // '\001'
                return new String("");
        //    7   38:new             #73  <Class String>
        //    8   41:dup             
        //    9   42:ldc1            #80  <String "">
        //   10   44:invokespecial   #78  <Method void String(String)>
        //   11   47:areturn         

            case 2: // '\002'
                return new String("Name");
        //   12   48:new             #73  <Class String>
        //   13   51:dup             
        //   14   52:ldc1            #82  <String "Name">
        //   15   54:invokespecial   #78  <Method void String(String)>
        //   16   57:areturn         
            }
            return null;
        //   17   58:aconst_null     
        //   18   59:areturn         
        }

        public void setValueAt(Object value, int row, int col)
        {
            if(col == 1)
        //*   0    0:iload_3         
        //*   1    1:iconst_1        
        //*   2    2:icmpne          18
                m_Selected[row] = ((Boolean)value).booleanValue();
        //    3    5:aload_0         
        //    4    6:getfield        #42  <Field boolean[] m_Selected>
        //    5    9:iload_2         
        //    6   10:aload_1         
        //    7   11:checkcast       #53  <Class Boolean>
        //    8   14:invokevirtual   #88  <Method boolean Boolean.booleanValue()>
        //    9   17:bastore         
        //   10   18:return          
        }

        public Class getColumnClass(int col)
        {
            return getValueAt(0, col).getClass();
        //    0    0:aload_0         
        //    1    1:iconst_0        
        //    2    2:iload_1         
        //    3    3:invokevirtual   #95  <Method Object getValueAt(int, int)>
        //    4    6:invokevirtual   #101 <Method Class Object.getClass()>
        //    5    9:areturn         
        }

        public boolean isCellEditable(int row, int col)
        {
            return col == 1;
        //    0    0:iload_2         
        //    1    1:iconst_1        
        //    2    2:icmpne          7
        //    3    5:iconst_1        
        //    4    6:ireturn         
        //    5    7:iconst_0        
        //    6    8:ireturn         
        }

        public int[] getSelectedAttributes()
        {
            int r1[] = new int[getRowCount()];
        //    0    0:aload_0         
        //    1    1:invokevirtual   #107 <Method int getRowCount()>
        //    2    4:newarray        int[]
        //    3    6:astore_1        
            int selCount = 0;
        //    4    7:iconst_0        
        //    5    8:istore_2        
            for(int i = 0; i < getRowCount(); i++)
        //*   6    9:iconst_0        
        //*   7   10:istore_3        
        //*   8   11:goto            33
                if(m_Selected[i])
        //*   9   14:aload_0         
        //*  10   15:getfield        #42  <Field boolean[] m_Selected>
        //*  11   18:iload_3         
        //*  12   19:baload          
        //*  13   20:ifeq            30
                    r1[selCount++] = i;
        //   14   23:aload_1         
        //   15   24:iload_2         
        //   16   25:iinc            2  1
        //   17   28:iload_3         
        //   18   29:iastore         

        //   19   30:iinc            3  1
        //   20   33:iload_3         
        //   21   34:aload_0         
        //   22   35:invokevirtual   #107 <Method int getRowCount()>
        //   23   38:icmplt          14
            int result[] = new int[selCount];
        //   24   41:iload_2         
        //   25   42:newarray        int[]
        //   26   44:astore_3        
            System.arraycopy(r1, 0, result, 0, selCount);
        //   27   45:aload_1         
        //   28   46:iconst_0        
        //   29   47:aload_3         
        //   30   48:iconst_0        
        //   31   49:iload_2         
        //   32   50:invokestatic    #113 <Method void System.arraycopy(Object, int, Object, int, int)>
            return result;
        //   33   53:aload_3         
        //   34   54:areturn         
        }

        public void includeAll()
        {
            for(int i = 0; i < m_Selected.length; i++)
        //*   0    0:iconst_0        
        //*   1    1:istore_1        
        //*   2    2:goto            15
                m_Selected[i] = true;
        //    3    5:aload_0         
        //    4    6:getfield        #42  <Field boolean[] m_Selected>
        //    5    9:iload_1         
        //    6   10:iconst_1        
        //    7   11:bastore         

        //    8   12:iinc            1  1
        //    9   15:iload_1         
        //   10   16:aload_0         
        //   11   17:getfield        #42  <Field boolean[] m_Selected>
        //   12   20:arraylength     
        //   13   21:icmplt          5
            fireTableRowsUpdated(0, m_Selected.length);
        //   14   24:aload_0         
        //   15   25:iconst_0        
        //   16   26:aload_0         
        //   17   27:getfield        #42  <Field boolean[] m_Selected>
        //   18   30:arraylength     
        //   19   31:invokevirtual   #123 <Method void fireTableRowsUpdated(int, int)>
        //   20   34:return          
        }

        public void removeAll()
        {
            for(int i = 0; i < m_Selected.length; i++)
        //*   0    0:iconst_0        
        //*   1    1:istore_1        
        //*   2    2:goto            15
                m_Selected[i] = false;
        //    3    5:aload_0         
        //    4    6:getfield        #42  <Field boolean[] m_Selected>
        //    5    9:iload_1         
        //    6   10:iconst_0        
        //    7   11:bastore         

        //    8   12:iinc            1  1
        //    9   15:iload_1         
        //   10   16:aload_0         
        //   11   17:getfield        #42  <Field boolean[] m_Selected>
        //   12   20:arraylength     
        //   13   21:icmplt          5
            fireTableRowsUpdated(0, m_Selected.length);
        //   14   24:aload_0         
        //   15   25:iconst_0        
        //   16   26:aload_0         
        //   17   27:getfield        #42  <Field boolean[] m_Selected>
        //   18   30:arraylength     
        //   19   31:invokevirtual   #123 <Method void fireTableRowsUpdated(int, int)>
        //   20   34:return          
        }

        public void invert()
        {
            for(int i = 0; i < m_Selected.length; i++)
        //*   0    0:iconst_0        
        //*   1    1:istore_1        
        //*   2    2:goto            28
                m_Selected[i] = !m_Selected[i];
        //    3    5:aload_0         
        //    4    6:getfield        #42  <Field boolean[] m_Selected>
        //    5    9:iload_1         
        //    6   10:aload_0         
        //    7   11:getfield        #42  <Field boolean[] m_Selected>
        //    8   14:iload_1         
        //    9   15:baload          
        //   10   16:ifeq            23
        //   11   19:iconst_0        
        //   12   20:goto            24
        //   13   23:iconst_1        
        //   14   24:bastore         

        //   15   25:iinc            1  1
        //   16   28:iload_1         
        //   17   29:aload_0         
        //   18   30:getfield        #42  <Field boolean[] m_Selected>
        //   19   33:arraylength     
        //   20   34:icmplt          5
            fireTableRowsUpdated(0, m_Selected.length);
        //   21   37:aload_0         
        //   22   38:iconst_0        
        //   23   39:aload_0         
        //   24   40:getfield        #42  <Field boolean[] m_Selected>
        //   25   43:arraylength     
        //   26   44:invokevirtual   #123 <Method void fireTableRowsUpdated(int, int)>
        //   27   47:return          
        }

        public void pattern(String pattern)
        {
            for(int i = 0; i < m_Selected.length; i++)
        //*   0    0:iconst_0        
        //*   1    1:istore_2        
        //*   2    2:goto            29
                m_Selected[i] = Pattern.matches(pattern, m_Instances.attribute(i).name());
        //    3    5:aload_0         
        //    4    6:getfield        #42  <Field boolean[] m_Selected>
        //    5    9:iload_2         
        //    6   10:aload_1         
        //    7   11:aload_0         
        //    8   12:getfield        #34  <Field Instances m_Instances>
        //    9   15:iload_2         
        //   10   16:invokevirtual   #60  <Method Attribute Instances.attribute(int)>
        //   11   19:invokevirtual   #66  <Method String Attribute.name()>
        //   12   22:invokestatic    #132 <Method boolean Pattern.matches(String, CharSequence)>
        //   13   25:bastore         

        //   14   26:iinc            2  1
        //   15   29:iload_2         
        //   16   30:aload_0         
        //   17   31:getfield        #42  <Field boolean[] m_Selected>
        //   18   34:arraylength     
        //   19   35:icmplt          5
            fireTableRowsUpdated(0, m_Selected.length);
        //   20   38:aload_0         
        //   21   39:iconst_0        
        //   22   40:aload_0         
        //   23   41:getfield        #42  <Field boolean[] m_Selected>
        //   24   44:arraylength     
        //   25   45:invokevirtual   #123 <Method void fireTableRowsUpdated(int, int)>
        //   26   48:return          
        }

        private static final long serialVersionUID = 0xc65d9feea6517d70L;
        protected Instances m_Instances;
        protected boolean m_Selected[];
        final AttributeSelectionPanel this$0;

        public AttributeTableModel(Instances instances)
        {
            this$0 = AttributeSelectionPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field AttributeSelectionPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void AbstractTableModel()>
            setInstances(instances);
        //    5    9:aload_0         
        //    6   10:aload_2         
        //    7   11:invokevirtual   #27  <Method void setInstances(Instances)>
        //    8   14:return          
        }
    }


    public AttributeSelectionPanel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #25  <Method void JPanel()>
        m_IncludeAll = new JButton("All");
    //    2    4:aload_0         
    //    3    5:new             #27  <Class JButton>
    //    4    8:dup             
    //    5    9:ldc1            #29  <String "All">
    //    6   11:invokespecial   #32  <Method void JButton(String)>
    //    7   14:putfield        #34  <Field JButton m_IncludeAll>
        m_RemoveAll = new JButton("None");
    //    8   17:aload_0         
    //    9   18:new             #27  <Class JButton>
    //   10   21:dup             
    //   11   22:ldc1            #36  <String "None">
    //   12   24:invokespecial   #32  <Method void JButton(String)>
    //   13   27:putfield        #38  <Field JButton m_RemoveAll>
        m_Invert = new JButton("Invert");
    //   14   30:aload_0         
    //   15   31:new             #27  <Class JButton>
    //   16   34:dup             
    //   17   35:ldc1            #40  <String "Invert">
    //   18   37:invokespecial   #32  <Method void JButton(String)>
    //   19   40:putfield        #42  <Field JButton m_Invert>
        m_Pattern = new JButton("Pattern");
    //   20   43:aload_0         
    //   21   44:new             #27  <Class JButton>
    //   22   47:dup             
    //   23   48:ldc1            #44  <String "Pattern">
    //   24   50:invokespecial   #32  <Method void JButton(String)>
    //   25   53:putfield        #46  <Field JButton m_Pattern>
        m_Table = new JTable();
    //   26   56:aload_0         
    //   27   57:new             #48  <Class JTable>
    //   28   60:dup             
    //   29   61:invokespecial   #49  <Method void JTable()>
    //   30   64:putfield        #51  <Field JTable m_Table>
        m_PatternRegEx = "";
    //   31   67:aload_0         
    //   32   68:ldc1            #53  <String "">
    //   33   70:putfield        #55  <Field String m_PatternRegEx>
        m_IncludeAll.setToolTipText("Selects all attributes");
    //   34   73:aload_0         
    //   35   74:getfield        #34  <Field JButton m_IncludeAll>
    //   36   77:ldc1            #57  <String "Selects all attributes">
    //   37   79:invokevirtual   #60  <Method void JButton.setToolTipText(String)>
        m_IncludeAll.setEnabled(false);
    //   38   82:aload_0         
    //   39   83:getfield        #34  <Field JButton m_IncludeAll>
    //   40   86:iconst_0        
    //   41   87:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_IncludeAll.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Model.includeAll();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AttributeSelectionPanel this$0>
            //    2    4:getfield        #28  <Field AttributeSelectionPanel$AttributeTableModel AttributeSelectionPanel.m_Model>
            //    3    7:invokevirtual   #33  <Method void AttributeSelectionPanel$AttributeTableModel.includeAll()>
            //    4   10:return          
            }

            final AttributeSelectionPanel this$0;

            
            {
                this$0 = AttributeSelectionPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeSelectionPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   42   90:aload_0         
    //   43   91:getfield        #34  <Field JButton m_IncludeAll>
    //   44   94:new             #66  <Class AttributeSelectionPanel$1>
    //   45   97:dup             
    //   46   98:aload_0         
    //   47   99:invokespecial   #69  <Method void AttributeSelectionPanel$1(AttributeSelectionPanel)>
    //   48  102:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        m_RemoveAll.setToolTipText("Unselects all attributes");
    //   49  105:aload_0         
    //   50  106:getfield        #38  <Field JButton m_RemoveAll>
    //   51  109:ldc1            #75  <String "Unselects all attributes">
    //   52  111:invokevirtual   #60  <Method void JButton.setToolTipText(String)>
        m_RemoveAll.setEnabled(false);
    //   53  114:aload_0         
    //   54  115:getfield        #38  <Field JButton m_RemoveAll>
    //   55  118:iconst_0        
    //   56  119:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_RemoveAll.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Model.removeAll();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AttributeSelectionPanel this$0>
            //    2    4:getfield        #28  <Field AttributeSelectionPanel$AttributeTableModel AttributeSelectionPanel.m_Model>
            //    3    7:invokevirtual   #33  <Method void AttributeSelectionPanel$AttributeTableModel.removeAll()>
            //    4   10:return          
            }

            final AttributeSelectionPanel this$0;

            
            {
                this$0 = AttributeSelectionPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeSelectionPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   57  122:aload_0         
    //   58  123:getfield        #38  <Field JButton m_RemoveAll>
    //   59  126:new             #77  <Class AttributeSelectionPanel$2>
    //   60  129:dup             
    //   61  130:aload_0         
    //   62  131:invokespecial   #78  <Method void AttributeSelectionPanel$2(AttributeSelectionPanel)>
    //   63  134:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        m_Invert.setToolTipText("Inverts the current attribute selection");
    //   64  137:aload_0         
    //   65  138:getfield        #42  <Field JButton m_Invert>
    //   66  141:ldc1            #80  <String "Inverts the current attribute selection">
    //   67  143:invokevirtual   #60  <Method void JButton.setToolTipText(String)>
        m_Invert.setEnabled(false);
    //   68  146:aload_0         
    //   69  147:getfield        #42  <Field JButton m_Invert>
    //   70  150:iconst_0        
    //   71  151:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_Invert.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                m_Model.invert();
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AttributeSelectionPanel this$0>
            //    2    4:getfield        #28  <Field AttributeSelectionPanel$AttributeTableModel AttributeSelectionPanel.m_Model>
            //    3    7:invokevirtual   #33  <Method void AttributeSelectionPanel$AttributeTableModel.invert()>
            //    4   10:return          
            }

            final AttributeSelectionPanel this$0;

            
            {
                this$0 = AttributeSelectionPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeSelectionPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   72  154:aload_0         
    //   73  155:getfield        #42  <Field JButton m_Invert>
    //   74  158:new             #82  <Class AttributeSelectionPanel$3>
    //   75  161:dup             
    //   76  162:aload_0         
    //   77  163:invokespecial   #83  <Method void AttributeSelectionPanel$3(AttributeSelectionPanel)>
    //   78  166:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        m_Pattern.setToolTipText("Selects all attributes that match a reg. expression");
    //   79  169:aload_0         
    //   80  170:getfield        #46  <Field JButton m_Pattern>
    //   81  173:ldc1            #85  <String "Selects all attributes that match a reg. expression">
    //   82  175:invokevirtual   #60  <Method void JButton.setToolTipText(String)>
        m_Pattern.setEnabled(false);
    //   83  178:aload_0         
    //   84  179:getfield        #46  <Field JButton m_Pattern>
    //   85  182:iconst_0        
    //   86  183:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_Pattern.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                String pattern = JOptionPane.showInputDialog(m_Pattern.getParent(), "Enter a Perl regular expression", m_PatternRegEx);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field AttributeSelectionPanel this$0>
            //    2    4:getfield        #28  <Field JButton AttributeSelectionPanel.m_Pattern>
            //    3    7:invokevirtual   #34  <Method Container JButton.getParent()>
            //    4   10:ldc1            #36  <String "Enter a Perl regular expression">
            //    5   12:aload_0         
            //    6   13:getfield        #13  <Field AttributeSelectionPanel this$0>
            //    7   16:getfield        #40  <Field String AttributeSelectionPanel.m_PatternRegEx>
            //    8   19:invokestatic    #46  <Method String JOptionPane.showInputDialog(java.awt.Component, Object, Object)>
            //    9   22:astore_2        
                if(pattern != null)
            //*  10   23:aload_2         
            //*  11   24:ifnull          101
                    try
                    {
                        Pattern.compile(pattern);
            //   12   27:aload_2         
            //   13   28:invokestatic    #52  <Method Pattern Pattern.compile(String)>
            //   14   31:pop             
                        m_PatternRegEx = pattern;
            //   15   32:aload_0         
            //   16   33:getfield        #13  <Field AttributeSelectionPanel this$0>
            //   17   36:aload_2         
            //   18   37:putfield        #40  <Field String AttributeSelectionPanel.m_PatternRegEx>
                        m_Model.pattern(pattern);
            //   19   40:aload_0         
            //   20   41:getfield        #13  <Field AttributeSelectionPanel this$0>
            //   21   44:getfield        #56  <Field AttributeSelectionPanel$AttributeTableModel AttributeSelectionPanel.m_Model>
            //   22   47:aload_2         
            //   23   48:invokevirtual   #62  <Method void AttributeSelectionPanel$AttributeTableModel.pattern(String)>
                    }
            //*  24   51:goto            101
                    catch(Exception ex)
            //*  25   54:astore_3        
                    {
                        JOptionPane.showMessageDialog(m_Pattern.getParent(), (new StringBuilder("'")).append(pattern).append("' is not a valid Perl regular expression!\n").append("Error: ").append(ex).toString(), "Error in Pattern...", 0);
            //   26   55:aload_0         
            //   27   56:getfield        #13  <Field AttributeSelectionPanel this$0>
            //   28   59:getfield        #28  <Field JButton AttributeSelectionPanel.m_Pattern>
            //   29   62:invokevirtual   #34  <Method Container JButton.getParent()>
            //   30   65:new             #64  <Class StringBuilder>
            //   31   68:dup             
            //   32   69:ldc1            #66  <String "'">
            //   33   71:invokespecial   #68  <Method void StringBuilder(String)>
            //   34   74:aload_2         
            //   35   75:invokevirtual   #72  <Method StringBuilder StringBuilder.append(String)>
            //   36   78:ldc1            #74  <String "' is not a valid Perl regular expression!\n">
            //   37   80:invokevirtual   #72  <Method StringBuilder StringBuilder.append(String)>
            //   38   83:ldc1            #76  <String "Error: ">
            //   39   85:invokevirtual   #72  <Method StringBuilder StringBuilder.append(String)>
            //   40   88:aload_3         
            //   41   89:invokevirtual   #79  <Method StringBuilder StringBuilder.append(Object)>
            //   42   92:invokevirtual   #83  <Method String StringBuilder.toString()>
            //   43   95:ldc1            #85  <String "Error in Pattern...">
            //   44   97:iconst_0        
            //   45   98:invokestatic    #89  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
                    }
            //   46  101:return          
            }

            final AttributeSelectionPanel this$0;

            
            {
                this$0 = AttributeSelectionPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field AttributeSelectionPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   87  186:aload_0         
    //   88  187:getfield        #46  <Field JButton m_Pattern>
    //   89  190:new             #87  <Class AttributeSelectionPanel$4>
    //   90  193:dup             
    //   91  194:aload_0         
    //   92  195:invokespecial   #88  <Method void AttributeSelectionPanel$4(AttributeSelectionPanel)>
    //   93  198:invokevirtual   #73  <Method void JButton.addActionListener(ActionListener)>
        m_Table.setSelectionMode(0);
    //   94  201:aload_0         
    //   95  202:getfield        #51  <Field JTable m_Table>
    //   96  205:iconst_0        
    //   97  206:invokevirtual   #92  <Method void JTable.setSelectionMode(int)>
        m_Table.setColumnSelectionAllowed(false);
    //   98  209:aload_0         
    //   99  210:getfield        #51  <Field JTable m_Table>
    //  100  213:iconst_0        
    //  101  214:invokevirtual   #95  <Method void JTable.setColumnSelectionAllowed(boolean)>
        m_Table.setPreferredScrollableViewportSize(new Dimension(250, 150));
    //  102  217:aload_0         
    //  103  218:getfield        #51  <Field JTable m_Table>
    //  104  221:new             #97  <Class Dimension>
    //  105  224:dup             
    //  106  225:sipush          250
    //  107  228:sipush          150
    //  108  231:invokespecial   #100 <Method void Dimension(int, int)>
    //  109  234:invokevirtual   #104 <Method void JTable.setPreferredScrollableViewportSize(Dimension)>
        JPanel p1 = new JPanel();
    //  110  237:new             #4   <Class JPanel>
    //  111  240:dup             
    //  112  241:invokespecial   #25  <Method void JPanel()>
    //  113  244:astore_1        
        p1.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
    //  114  245:aload_1         
    //  115  246:bipush          10
    //  116  248:iconst_5        
    //  117  249:bipush          10
    //  118  251:iconst_5        
    //  119  252:invokestatic    #110 <Method javax.swing.border.Border BorderFactory.createEmptyBorder(int, int, int, int)>
    //  120  255:invokevirtual   #114 <Method void JPanel.setBorder(javax.swing.border.Border)>
        p1.setLayout(new GridLayout(1, 4, 5, 5));
    //  121  258:aload_1         
    //  122  259:new             #116 <Class GridLayout>
    //  123  262:dup             
    //  124  263:iconst_1        
    //  125  264:iconst_4        
    //  126  265:iconst_5        
    //  127  266:iconst_5        
    //  128  267:invokespecial   #119 <Method void GridLayout(int, int, int, int)>
    //  129  270:invokevirtual   #123 <Method void JPanel.setLayout(java.awt.LayoutManager)>
        p1.add(m_IncludeAll);
    //  130  273:aload_1         
    //  131  274:aload_0         
    //  132  275:getfield        #34  <Field JButton m_IncludeAll>
    //  133  278:invokevirtual   #127 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  134  281:pop             
        p1.add(m_RemoveAll);
    //  135  282:aload_1         
    //  136  283:aload_0         
    //  137  284:getfield        #38  <Field JButton m_RemoveAll>
    //  138  287:invokevirtual   #127 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  139  290:pop             
        p1.add(m_Invert);
    //  140  291:aload_1         
    //  141  292:aload_0         
    //  142  293:getfield        #42  <Field JButton m_Invert>
    //  143  296:invokevirtual   #127 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  144  299:pop             
        p1.add(m_Pattern);
    //  145  300:aload_1         
    //  146  301:aload_0         
    //  147  302:getfield        #46  <Field JButton m_Pattern>
    //  148  305:invokevirtual   #127 <Method java.awt.Component JPanel.add(java.awt.Component)>
    //  149  308:pop             
        setLayout(new BorderLayout());
    //  150  309:aload_0         
    //  151  310:new             #129 <Class BorderLayout>
    //  152  313:dup             
    //  153  314:invokespecial   #130 <Method void BorderLayout()>
    //  154  317:invokevirtual   #131 <Method void setLayout(java.awt.LayoutManager)>
        add(p1, "North");
    //  155  320:aload_0         
    //  156  321:aload_1         
    //  157  322:ldc1            #133 <String "North">
    //  158  324:invokevirtual   #136 <Method void add(java.awt.Component, Object)>
        add(new JScrollPane(m_Table), "Center");
    //  159  327:aload_0         
    //  160  328:new             #138 <Class JScrollPane>
    //  161  331:dup             
    //  162  332:aload_0         
    //  163  333:getfield        #51  <Field JTable m_Table>
    //  164  336:invokespecial   #141 <Method void JScrollPane(java.awt.Component)>
    //  165  339:ldc1            #143 <String "Center">
    //  166  341:invokevirtual   #136 <Method void add(java.awt.Component, Object)>
    //  167  344:return          
    }

    public void setInstances(Instances newInstances)
    {
        if(m_Model == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #153 <Field AttributeSelectionPanel$AttributeTableModel m_Model>
    //*   2    4:ifnonnull       86
        {
            m_Model = new AttributeTableModel(newInstances);
    //    3    7:aload_0         
    //    4    8:new             #155 <Class AttributeSelectionPanel$AttributeTableModel>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:invokespecial   #158 <Method void AttributeSelectionPanel$AttributeTableModel(AttributeSelectionPanel, Instances)>
    //    9   17:putfield        #153 <Field AttributeSelectionPanel$AttributeTableModel m_Model>
            m_Table.setModel(m_Model);
    //   10   20:aload_0         
    //   11   21:getfield        #51  <Field JTable m_Table>
    //   12   24:aload_0         
    //   13   25:getfield        #153 <Field AttributeSelectionPanel$AttributeTableModel m_Model>
    //   14   28:invokevirtual   #162 <Method void JTable.setModel(javax.swing.table.TableModel)>
            TableColumnModel tcm = m_Table.getColumnModel();
    //   15   31:aload_0         
    //   16   32:getfield        #51  <Field JTable m_Table>
    //   17   35:invokevirtual   #166 <Method TableColumnModel JTable.getColumnModel()>
    //   18   38:astore_2        
            tcm.getColumn(0).setMaxWidth(60);
    //   19   39:aload_2         
    //   20   40:iconst_0        
    //   21   41:invokeinterface #172 <Method TableColumn TableColumnModel.getColumn(int)>
    //   22   46:bipush          60
    //   23   48:invokevirtual   #177 <Method void TableColumn.setMaxWidth(int)>
            tcm.getColumn(1).setMaxWidth(tcm.getColumn(1).getMinWidth());
    //   24   51:aload_2         
    //   25   52:iconst_1        
    //   26   53:invokeinterface #172 <Method TableColumn TableColumnModel.getColumn(int)>
    //   27   58:aload_2         
    //   28   59:iconst_1        
    //   29   60:invokeinterface #172 <Method TableColumn TableColumnModel.getColumn(int)>
    //   30   65:invokevirtual   #181 <Method int TableColumn.getMinWidth()>
    //   31   68:invokevirtual   #177 <Method void TableColumn.setMaxWidth(int)>
            tcm.getColumn(2).setMinWidth(100);
    //   32   71:aload_2         
    //   33   72:iconst_2        
    //   34   73:invokeinterface #172 <Method TableColumn TableColumnModel.getColumn(int)>
    //   35   78:bipush          100
    //   36   80:invokevirtual   #184 <Method void TableColumn.setMinWidth(int)>
        } else
    //*  37   83:goto            101
        {
            m_Model.setInstances(newInstances);
    //   38   86:aload_0         
    //   39   87:getfield        #153 <Field AttributeSelectionPanel$AttributeTableModel m_Model>
    //   40   90:aload_1         
    //   41   91:invokevirtual   #186 <Method void AttributeSelectionPanel$AttributeTableModel.setInstances(Instances)>
            m_Table.clearSelection();
    //   42   94:aload_0         
    //   43   95:getfield        #51  <Field JTable m_Table>
    //   44   98:invokevirtual   #189 <Method void JTable.clearSelection()>
        }
        m_IncludeAll.setEnabled(true);
    //   45  101:aload_0         
    //   46  102:getfield        #34  <Field JButton m_IncludeAll>
    //   47  105:iconst_1        
    //   48  106:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_RemoveAll.setEnabled(true);
    //   49  109:aload_0         
    //   50  110:getfield        #38  <Field JButton m_RemoveAll>
    //   51  113:iconst_1        
    //   52  114:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_Invert.setEnabled(true);
    //   53  117:aload_0         
    //   54  118:getfield        #42  <Field JButton m_Invert>
    //   55  121:iconst_1        
    //   56  122:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_Pattern.setEnabled(true);
    //   57  125:aload_0         
    //   58  126:getfield        #46  <Field JButton m_Pattern>
    //   59  129:iconst_1        
    //   60  130:invokevirtual   #64  <Method void JButton.setEnabled(boolean)>
        m_Table.sizeColumnsToFit(2);
    //   61  133:aload_0         
    //   62  134:getfield        #51  <Field JTable m_Table>
    //   63  137:iconst_2        
    //   64  138:invokevirtual   #192 <Method void JTable.sizeColumnsToFit(int)>
        m_Table.revalidate();
    //   65  141:aload_0         
    //   66  142:getfield        #51  <Field JTable m_Table>
    //   67  145:invokevirtual   #195 <Method void JTable.revalidate()>
        m_Table.repaint();
    //   68  148:aload_0         
    //   69  149:getfield        #51  <Field JTable m_Table>
    //   70  152:invokevirtual   #198 <Method void JTable.repaint()>
    //   71  155:return          
    }

    public int[] getSelectedAttributes()
    {
        return m_Model.getSelectedAttributes();
    //    0    0:aload_0         
    //    1    1:getfield        #153 <Field AttributeSelectionPanel$AttributeTableModel m_Model>
    //    2    4:invokevirtual   #206 <Method int[] AttributeSelectionPanel$AttributeTableModel.getSelectedAttributes()>
    //    3    7:areturn         
    }

    public ListSelectionModel getSelectionModel()
    {
        return m_Table.getSelectionModel();
    //    0    0:aload_0         
    //    1    1:getfield        #51  <Field JTable m_Table>
    //    2    4:invokevirtual   #210 <Method ListSelectionModel JTable.getSelectionModel()>
    //    3    7:areturn         
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length == 0)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:ifne            15
                throw new Exception("supply the name of an arff file");
    //    3    5:new             #214 <Class Exception>
    //    4    8:dup             
    //    5    9:ldc1            #216 <String "supply the name of an arff file">
    //    6   11:invokespecial   #217 <Method void Exception(String)>
    //    7   14:athrow          
            Instances i = new Instances(new BufferedReader(new FileReader(args[0])));
    //    8   15:new             #219 <Class Instances>
    //    9   18:dup             
    //   10   19:new             #221 <Class BufferedReader>
    //   11   22:dup             
    //   12   23:new             #223 <Class FileReader>
    //   13   26:dup             
    //   14   27:aload_0         
    //   15   28:iconst_0        
    //   16   29:aaload          
    //   17   30:invokespecial   #224 <Method void FileReader(String)>
    //   18   33:invokespecial   #227 <Method void BufferedReader(java.io.Reader)>
    //   19   36:invokespecial   #228 <Method void Instances(java.io.Reader)>
    //   20   39:astore_1        
            AttributeSelectionPanel asp = new AttributeSelectionPanel();
    //   21   40:new             #2   <Class AttributeSelectionPanel>
    //   22   43:dup             
    //   23   44:invokespecial   #229 <Method void AttributeSelectionPanel()>
    //   24   47:astore_2        
            final JFrame jf = new JFrame("Attribute Selection Panel");
    //   25   48:new             #231 <Class JFrame>
    //   26   51:dup             
    //   27   52:ldc1            #233 <String "Attribute Selection Panel">
    //   28   54:invokespecial   #234 <Method void JFrame(String)>
    //   29   57:astore_3        
            jf.getContentPane().setLayout(new BorderLayout());
    //   30   58:aload_3         
    //   31   59:invokevirtual   #238 <Method Container JFrame.getContentPane()>
    //   32   62:new             #129 <Class BorderLayout>
    //   33   65:dup             
    //   34   66:invokespecial   #130 <Method void BorderLayout()>
    //   35   69:invokevirtual   #241 <Method void Container.setLayout(java.awt.LayoutManager)>
            jf.getContentPane().add(asp, "Center");
    //   36   72:aload_3         
    //   37   73:invokevirtual   #238 <Method Container JFrame.getContentPane()>
    //   38   76:aload_2         
    //   39   77:ldc1            #143 <String "Center">
    //   40   79:invokevirtual   #242 <Method void Container.add(java.awt.Component, Object)>
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
    //   41   82:aload_3         
    //   42   83:new             #244 <Class AttributeSelectionPanel$5>
    //   43   86:dup             
    //   44   87:aload_3         
    //   45   88:invokespecial   #247 <Method void AttributeSelectionPanel$5(JFrame)>
    //   46   91:invokevirtual   #251 <Method void JFrame.addWindowListener(java.awt.event.WindowListener)>
            jf.pack();
    //   47   94:aload_3         
    //   48   95:invokevirtual   #254 <Method void JFrame.pack()>
            jf.setVisible(true);
    //   49   98:aload_3         
    //   50   99:iconst_1        
    //   51  100:invokevirtual   #257 <Method void JFrame.setVisible(boolean)>
            asp.setInstances(i);
    //   52  103:aload_2         
    //   53  104:aload_1         
    //   54  105:invokevirtual   #258 <Method void setInstances(Instances)>
        }
    //*  55  108:goto            126
        catch(Exception ex)
    //*  56  111:astore_1        
        {
            ex.printStackTrace();
    //   57  112:aload_1         
    //   58  113:invokevirtual   #261 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   59  116:getstatic       #267 <Field PrintStream System.err>
    //   60  119:aload_1         
    //   61  120:invokevirtual   #271 <Method String Exception.getMessage()>
    //   62  123:invokevirtual   #276 <Method void PrintStream.println(String)>
        }
    //   63  126:return          
    }

    private static final long serialVersionUID = 0x8b404c36031e99aL;
    protected JButton m_IncludeAll;
    protected JButton m_RemoveAll;
    protected JButton m_Invert;
    protected JButton m_Pattern;
    protected JTable m_Table;
    protected AttributeTableModel m_Model;
    protected String m_PatternRegEx;
}

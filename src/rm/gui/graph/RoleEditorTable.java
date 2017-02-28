// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RoleEditorTable.java

package rm.gui.graph;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import rm.core.*;

// Referenced classes of package rm.gui.graph:
//            RoleFixedTableModel

public class RoleEditorTable extends JPanel
{
    class UPATableCellRenderer extends JCheckBox
        implements TableCellRenderer
    {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            Boolean b = (Boolean)value;
        //    0    0:aload_2         
        //    1    1:checkcast       #28  <Class Boolean>
        //    2    4:astore          7
            setSelected(b.booleanValue());
        //    3    6:aload_0         
        //    4    7:aload           7
        //    5    9:invokevirtual   #32  <Method boolean Boolean.booleanValue()>
        //    6   12:invokevirtual   #36  <Method void setSelected(boolean)>
            if(setRow == row)
        //*   7   15:aload_0         
        //*   8   16:getfield        #20  <Field int setRow>
        //*   9   19:iload           5
        //*  10   21:icmpne          34
                setBackground(Color.BLUE);
        //   11   24:aload_0         
        //   12   25:getstatic       #42  <Field Color Color.BLUE>
        //   13   28:invokevirtual   #46  <Method void setBackground(Color)>
            else
        //*  14   31:goto            39
                setBackground(null);
        //   15   34:aload_0         
        //   16   35:aconst_null     
        //   17   36:invokevirtual   #46  <Method void setBackground(Color)>
            for(int i = 0; i < RoleEditorTable.inheritcells.size(); i++)
        //*  18   39:iconst_0        
        //*  19   40:istore          8
        //*  20   42:goto            98
                if(row == ((InheritCell)RoleEditorTable.inheritcells.get(i)).row && column == ((InheritCell)RoleEditorTable.inheritcells.get(i)).column)
        //*  21   45:iload           5
        //*  22   47:invokestatic    #52  <Method Vector RoleEditorTable.access$0()>
        //*  23   50:iload           8
        //*  24   52:invokevirtual   #58  <Method Object Vector.get(int)>
        //*  25   55:checkcast       #60  <Class RoleEditorTable$InheritCell>
        //*  26   58:getfield        #63  <Field int RoleEditorTable$InheritCell.row>
        //*  27   61:icmpne          95
        //*  28   64:iload           6
        //*  29   66:invokestatic    #52  <Method Vector RoleEditorTable.access$0()>
        //*  30   69:iload           8
        //*  31   71:invokevirtual   #58  <Method Object Vector.get(int)>
        //*  32   74:checkcast       #60  <Class RoleEditorTable$InheritCell>
        //*  33   77:getfield        #66  <Field int RoleEditorTable$InheritCell.column>
        //*  34   80:icmpne          95
                {
                    setBackground(Color.GREEN);
        //   35   83:aload_0         
        //   36   84:getstatic       #69  <Field Color Color.GREEN>
        //   37   87:invokevirtual   #46  <Method void setBackground(Color)>
                    setSelected(true);
        //   38   90:aload_0         
        //   39   91:iconst_1        
        //   40   92:invokevirtual   #36  <Method void setSelected(boolean)>
                }

        //   41   95:iinc            8  1
        //   42   98:iload           8
        //   43  100:invokestatic    #52  <Method Vector RoleEditorTable.access$0()>
        //   44  103:invokevirtual   #73  <Method int Vector.size()>
        //   45  106:icmplt          45
            return this;
        //   46  109:aload_0         
        //   47  110:areturn         
        }

        public int setRow;
        final RoleEditorTable this$0;

        UPATableCellRenderer()
        {
            this$0 = RoleEditorTable.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #15  <Field RoleEditorTable this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #18  <Method void JCheckBox()>
            setRow = -1;
        //    5    9:aload_0         
        //    6   10:iconst_m1       
        //    7   11:putfield        #20  <Field int setRow>
        //    8   14:return          
        }
    }

    public class InheritCell
    {

        public int row;
        public int column;
        final RoleEditorTable this$0;

        public InheritCell()
        {
            this$0 = RoleEditorTable.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #14  <Field RoleEditorTable this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #17  <Method void Object()>
            row = -1;
        //    5    9:aload_0         
        //    6   10:iconst_m1       
        //    7   11:putfield        #19  <Field int row>
            column = -1;
        //    8   14:aload_0         
        //    9   15:iconst_m1       
        //   10   16:putfield        #21  <Field int column>
        //   11   19:return          
        }
    }


    public RoleEditorTable(Assignment m_Assignment, RoleNodes.RNode newnodes[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #40  <Method void JPanel()>
        UPATable = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #42  <Field JTable UPATable>
        fixedTable = new JTable();
    //    5    9:aload_0         
    //    6   10:new             #44  <Class JTable>
    //    7   13:dup             
    //    8   14:invokespecial   #45  <Method void JTable()>
    //    9   17:putfield        #47  <Field JTable fixedTable>
        haveChaged = 0;
    //   10   20:aload_0         
    //   11   21:iconst_0        
    //   12   22:putfield        #49  <Field int haveChaged>
        DimX = m_Assignment.getDimensionX().getName();
    //   13   25:aload_0         
    //   14   26:aload_1         
    //   15   27:invokevirtual   #55  <Method Dimension Assignment.getDimensionX()>
    //   16   30:invokevirtual   #61  <Method String Dimension.getName()>
    //   17   33:putfield        #63  <Field String DimX>
        DimY = m_Assignment.getDimensionY().getName();
    //   18   36:aload_0         
    //   19   37:aload_1         
    //   20   38:invokevirtual   #66  <Method Dimension Assignment.getDimensionY()>
    //   21   41:invokevirtual   #61  <Method String Dimension.getName()>
    //   22   44:putfield        #68  <Field String DimY>
        roleSet = m_Assignment.getDimensionX().getDimensionAttribute().toArray();
    //   23   47:aload_0         
    //   24   48:aload_1         
    //   25   49:invokevirtual   #55  <Method Dimension Assignment.getDimensionX()>
    //   26   52:invokevirtual   #72  <Method Attribute Dimension.getDimensionAttribute()>
    //   27   55:invokevirtual   #78  <Method Object[] Attribute.toArray()>
    //   28   58:putfield        #80  <Field Object[] roleSet>
        permSet = m_Assignment.getDimensionY().getDimensionAttribute().toArray();
    //   29   61:aload_0         
    //   30   62:aload_1         
    //   31   63:invokevirtual   #66  <Method Dimension Assignment.getDimensionY()>
    //   32   66:invokevirtual   #72  <Method Attribute Dimension.getDimensionAttribute()>
    //   33   69:invokevirtual   #78  <Method Object[] Attribute.toArray()>
    //   34   72:putfield        #82  <Field Object[] permSet>
        nodes = newnodes;
    //   35   75:aload_0         
    //   36   76:aload_2         
    //   37   77:putfield        #84  <Field RoleNodes$RNode[] nodes>
        weightSet = new Object[roleSet.length];
    //   38   80:aload_0         
    //   39   81:aload_0         
    //   40   82:getfield        #80  <Field Object[] roleSet>
    //   41   85:arraylength     
    //   42   86:anewarray       Object[]
    //   43   89:putfield        #88  <Field Object[] weightSet>
        for(int i = 0; i < roleSet.length; i++)
    //*  44   92:iconst_0        
    //*  45   93:istore_3        
    //*  46   94:goto            118
            weightSet[i] = Double.valueOf(nodes[i].weight);
    //   47   97:aload_0         
    //   48   98:getfield        #88  <Field Object[] weightSet>
    //   49  101:iload_3         
    //   50  102:aload_0         
    //   51  103:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //   52  106:iload_3         
    //   53  107:aaload          
    //   54  108:getfield        #94  <Field double RoleNodes$RNode.weight>
    //   55  111:invokestatic    #100 <Method Double Double.valueOf(double)>
    //   56  114:aastore         

    //   57  115:iinc            3  1
    //   58  118:iload_3         
    //   59  119:aload_0         
    //   60  120:getfield        #80  <Field Object[] roleSet>
    //   61  123:arraylength     
    //   62  124:icmplt          97
        setUPATable();
    //   63  127:aload_0         
    //   64  128:invokevirtual   #103 <Method void setUPATable()>
        setPane();
    //   65  131:aload_0         
    //   66  132:invokevirtual   #106 <Method void setPane()>
    //   67  135:return          
    }

    private void setInheritcells()
    {
        inheritcells.removeAllElements();
    //    0    0:getstatic       #36  <Field Vector inheritcells>
    //    1    3:invokevirtual   #116 <Method void Vector.removeAllElements()>
        for(int i = 0; i < nodes.length; i++)
    //*   2    6:iconst_0        
    //*   3    7:istore_1        
    //*   4    8:goto            74
        {
            for(int j = 0; j < permSet.length; j++)
    //*   5   11:iconst_0        
    //*   6   12:istore_2        
    //*   7   13:goto            62
                if(nodes[i].InheritPerms.contains(j))
    //*   8   16:aload_0         
    //*   9   17:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //*  10   20:iload_1         
    //*  11   21:aaload          
    //*  12   22:getfield        #120 <Field IntegerSet RoleNodes$RNode.InheritPerms>
    //*  13   25:iload_2         
    //*  14   26:invokevirtual   #126 <Method boolean IntegerSet.contains(int)>
    //*  15   29:ifeq            59
                {
                    InheritCell cell = new InheritCell();
    //   16   32:new             #128 <Class RoleEditorTable$InheritCell>
    //   17   35:dup             
    //   18   36:aload_0         
    //   19   37:invokespecial   #131 <Method void RoleEditorTable$InheritCell(RoleEditorTable)>
    //   20   40:astore_3        
                    cell.row = i;
    //   21   41:aload_3         
    //   22   42:iload_1         
    //   23   43:putfield        #134 <Field int RoleEditorTable$InheritCell.row>
                    cell.column = j;
    //   24   46:aload_3         
    //   25   47:iload_2         
    //   26   48:putfield        #137 <Field int RoleEditorTable$InheritCell.column>
                    inheritcells.add(cell);
    //   27   51:getstatic       #36  <Field Vector inheritcells>
    //   28   54:aload_3         
    //   29   55:invokevirtual   #141 <Method boolean Vector.add(Object)>
    //   30   58:pop             
                }

    //   31   59:iinc            2  1
    //   32   62:iload_2         
    //   33   63:aload_0         
    //   34   64:getfield        #82  <Field Object[] permSet>
    //   35   67:arraylength     
    //   36   68:icmplt          16
        }

    //   37   71:iinc            1  1
    //   38   74:iload_1         
    //   39   75:aload_0         
    //   40   76:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //   41   79:arraylength     
    //   42   80:icmplt          11
    //   43   83:return          
    }

    public void setPane()
    {
        removeAll();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #147 <Method void removeAll()>
        fixedTable = new JTable(new RoleFixedTableModel(roleSet, weightSet));
    //    2    4:aload_0         
    //    3    5:new             #44  <Class JTable>
    //    4    8:dup             
    //    5    9:new             #149 <Class RoleFixedTableModel>
    //    6   12:dup             
    //    7   13:aload_0         
    //    8   14:getfield        #80  <Field Object[] roleSet>
    //    9   17:aload_0         
    //   10   18:getfield        #88  <Field Object[] weightSet>
    //   11   21:invokespecial   #152 <Method void RoleFixedTableModel(Object[], Object[])>
    //   12   24:invokespecial   #155 <Method void JTable(TableModel)>
    //   13   27:putfield        #47  <Field JTable fixedTable>
        fixedTable.setAutoResizeMode(0);
    //   14   30:aload_0         
    //   15   31:getfield        #47  <Field JTable fixedTable>
    //   16   34:iconst_0        
    //   17   35:invokevirtual   #159 <Method void JTable.setAutoResizeMode(int)>
        fixedTable.setSelectionMode(0);
    //   18   38:aload_0         
    //   19   39:getfield        #47  <Field JTable fixedTable>
    //   20   42:iconst_0        
    //   21   43:invokevirtual   #162 <Method void JTable.setSelectionMode(int)>
        fixedTable.setBackground(null);
    //   22   46:aload_0         
    //   23   47:getfield        #47  <Field JTable fixedTable>
    //   24   50:aconst_null     
    //   25   51:invokevirtual   #166 <Method void JTable.setBackground(Color)>
        fixedTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent listselectionevent)
            {
            //    0    0:return          
            }

            final RoleEditorTable this$0;

            
            {
                this$0 = RoleEditorTable.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleEditorTable this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   26   54:aload_0         
    //   27   55:getfield        #47  <Field JTable fixedTable>
    //   28   58:invokevirtual   #170 <Method ListSelectionModel JTable.getSelectionModel()>
    //   29   61:new             #172 <Class RoleEditorTable$1>
    //   30   64:dup             
    //   31   65:aload_0         
    //   32   66:invokespecial   #173 <Method void RoleEditorTable$1(RoleEditorTable)>
    //   33   69:invokeinterface #179 <Method void ListSelectionModel.addListSelectionListener(ListSelectionListener)>
        viewport = new JViewport();
    //   34   74:aload_0         
    //   35   75:new             #181 <Class JViewport>
    //   36   78:dup             
    //   37   79:invokespecial   #182 <Method void JViewport()>
    //   38   82:putfield        #184 <Field JViewport viewport>
        viewport.setView(fixedTable);
    //   39   85:aload_0         
    //   40   86:getfield        #184 <Field JViewport viewport>
    //   41   89:aload_0         
    //   42   90:getfield        #47  <Field JTable fixedTable>
    //   43   93:invokevirtual   #188 <Method void JViewport.setView(Component)>
        viewport.setPreferredSize(fixedTable.getPreferredSize());
    //   44   96:aload_0         
    //   45   97:getfield        #184 <Field JViewport viewport>
    //   46  100:aload_0         
    //   47  101:getfield        #47  <Field JTable fixedTable>
    //   48  104:invokevirtual   #192 <Method java.awt.Dimension JTable.getPreferredSize()>
    //   49  107:invokevirtual   #196 <Method void JViewport.setPreferredSize(java.awt.Dimension)>
        t_Scroll = new JScrollPane(UPATable);
    //   50  110:aload_0         
    //   51  111:new             #198 <Class JScrollPane>
    //   52  114:dup             
    //   53  115:aload_0         
    //   54  116:getfield        #42  <Field JTable UPATable>
    //   55  119:invokespecial   #200 <Method void JScrollPane(Component)>
    //   56  122:putfield        #202 <Field JScrollPane t_Scroll>
        t_Scroll.setRowHeaderView(viewport);
    //   57  125:aload_0         
    //   58  126:getfield        #202 <Field JScrollPane t_Scroll>
    //   59  129:aload_0         
    //   60  130:getfield        #184 <Field JViewport viewport>
    //   61  133:invokevirtual   #205 <Method void JScrollPane.setRowHeaderView(Component)>
        t_Scroll.setCorner("UPPER_LEFT_CORNER", fixedTable.getTableHeader());
    //   62  136:aload_0         
    //   63  137:getfield        #202 <Field JScrollPane t_Scroll>
    //   64  140:ldc1            #207 <String "UPPER_LEFT_CORNER">
    //   65  142:aload_0         
    //   66  143:getfield        #47  <Field JTable fixedTable>
    //   67  146:invokevirtual   #211 <Method JTableHeader JTable.getTableHeader()>
    //   68  149:invokevirtual   #215 <Method void JScrollPane.setCorner(String, Component)>
        setLayout(new BorderLayout());
    //   69  152:aload_0         
    //   70  153:new             #217 <Class BorderLayout>
    //   71  156:dup             
    //   72  157:invokespecial   #218 <Method void BorderLayout()>
    //   73  160:invokevirtual   #222 <Method void setLayout(java.awt.LayoutManager)>
        add(t_Scroll, "Center");
    //   74  163:aload_0         
    //   75  164:aload_0         
    //   76  165:getfield        #202 <Field JScrollPane t_Scroll>
    //   77  168:ldc1            #224 <String "Center">
    //   78  170:invokevirtual   #227 <Method void add(Component, Object)>
        UPATable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e)
            {
                if(e.getType() == 0)
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #28  <Method int TableModelEvent.getType()>
            //*   2    4:ifne            97
                {
                    int i = UPATable.getSelectedRow();
            //    3    7:aload_0         
            //    4    8:getfield        #13  <Field RoleEditorTable this$0>
            //    5   11:invokestatic    #34  <Method JTable RoleEditorTable.access$1(RoleEditorTable)>
            //    6   14:invokevirtual   #39  <Method int JTable.getSelectedRow()>
            //    7   17:istore_2        
                    int j = UPATable.getSelectedColumn();
            //    8   18:aload_0         
            //    9   19:getfield        #13  <Field RoleEditorTable this$0>
            //   10   22:invokestatic    #34  <Method JTable RoleEditorTable.access$1(RoleEditorTable)>
            //   11   25:invokevirtual   #42  <Method int JTable.getSelectedColumn()>
            //   12   28:istore_3        
                    Boolean getvalue = (Boolean)UPATable.getValueAt(i, j);
            //   13   29:aload_0         
            //   14   30:getfield        #13  <Field RoleEditorTable this$0>
            //   15   33:invokestatic    #34  <Method JTable RoleEditorTable.access$1(RoleEditorTable)>
            //   16   36:iload_2         
            //   17   37:iload_3         
            //   18   38:invokevirtual   #46  <Method Object JTable.getValueAt(int, int)>
            //   19   41:checkcast       #48  <Class Boolean>
            //   20   44:astore          4
                    if(getvalue.booleanValue())
            //*  21   46:aload           4
            //*  22   48:invokevirtual   #52  <Method boolean Boolean.booleanValue()>
            //*  23   51:ifeq            73
                        nodes[i].SelfPerms.addElement(j);
            //   24   54:aload_0         
            //   25   55:getfield        #13  <Field RoleEditorTable this$0>
            //   26   58:invokestatic    #56  <Method RoleNodes$RNode[] RoleEditorTable.access$2(RoleEditorTable)>
            //   27   61:iload_2         
            //   28   62:aaload          
            //   29   63:getfield        #62  <Field IntegerSet RoleNodes$RNode.SelfPerms>
            //   30   66:iload_3         
            //   31   67:invokevirtual   #68  <Method void IntegerSet.addElement(int)>
                    else
            //*  32   70:goto            89
                        nodes[i].SelfPerms.removeElement(j);
            //   33   73:aload_0         
            //   34   74:getfield        #13  <Field RoleEditorTable this$0>
            //   35   77:invokestatic    #56  <Method RoleNodes$RNode[] RoleEditorTable.access$2(RoleEditorTable)>
            //   36   80:iload_2         
            //   37   81:aaload          
            //   38   82:getfield        #62  <Field IntegerSet RoleNodes$RNode.SelfPerms>
            //   39   85:iload_3         
            //   40   86:invokevirtual   #71  <Method void IntegerSet.removeElement(int)>
                    haveChaged = 1;
            //   41   89:aload_0         
            //   42   90:getfield        #13  <Field RoleEditorTable this$0>
            //   43   93:iconst_1        
            //   44   94:putfield        #75  <Field int RoleEditorTable.haveChaged>
                }
            //   45   97:return          
            }

            final RoleEditorTable this$0;

            
            {
                this$0 = RoleEditorTable.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field RoleEditorTable this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   79  173:aload_0         
    //   80  174:getfield        #42  <Field JTable UPATable>
    //   81  177:invokevirtual   #231 <Method TableModel JTable.getModel()>
    //   82  180:new             #233 <Class RoleEditorTable$2>
    //   83  183:dup             
    //   84  184:aload_0         
    //   85  185:invokespecial   #234 <Method void RoleEditorTable$2(RoleEditorTable)>
    //   86  188:invokeinterface #240 <Method void TableModel.addTableModelListener(TableModelListener)>
    //   87  193:return          
    }

    public void setUPATable()
    {
        setInheritcells();
    //    0    0:aload_0         
    //    1    1:invokespecial   #242 <Method void setInheritcells()>
        UPATable = new JTable() {

            public boolean isCellEditable(int row, int column)
            {
                for(int i = 0; i < RoleEditorTable.inheritcells.size(); i++)
            //*   0    0:iconst_0        
            //*   1    1:istore_3        
            //*   2    2:goto            44
                    if(row == ((InheritCell)RoleEditorTable.inheritcells.get(i)).row && column == ((InheritCell)RoleEditorTable.inheritcells.get(i)).column)
            //*   3    5:iload_1         
            //*   4    6:invokestatic    #26  <Method Vector RoleEditorTable.access$0()>
            //*   5    9:iload_3         
            //*   6   10:invokevirtual   #32  <Method Object Vector.get(int)>
            //*   7   13:checkcast       #34  <Class RoleEditorTable$InheritCell>
            //*   8   16:getfield        #38  <Field int RoleEditorTable$InheritCell.row>
            //*   9   19:icmpne          41
            //*  10   22:iload_2         
            //*  11   23:invokestatic    #26  <Method Vector RoleEditorTable.access$0()>
            //*  12   26:iload_3         
            //*  13   27:invokevirtual   #32  <Method Object Vector.get(int)>
            //*  14   30:checkcast       #34  <Class RoleEditorTable$InheritCell>
            //*  15   33:getfield        #41  <Field int RoleEditorTable$InheritCell.column>
            //*  16   36:icmpne          41
                        return false;
            //   17   39:iconst_0        
            //   18   40:ireturn         

            //   19   41:iinc            3  1
            //   20   44:iload_3         
            //   21   45:invokestatic    #26  <Method Vector RoleEditorTable.access$0()>
            //   22   48:invokevirtual   #45  <Method int Vector.size()>
            //   23   51:icmplt          5
                return true;
            //   24   54:iconst_1        
            //   25   55:ireturn         
            }

            final RoleEditorTable this$0;

            
            {
                this$0 = RoleEditorTable.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #11  <Field RoleEditorTable this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #14  <Method void JTable()>
            //    5    9:return          
            }
        }
;
    //    2    4:aload_0         
    //    3    5:new             #244 <Class RoleEditorTable$3>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:invokespecial   #245 <Method void RoleEditorTable$3(RoleEditorTable)>
    //    7   13:putfield        #42  <Field JTable UPATable>
        DefaultTableModel upamodel = (DefaultTableModel)UPATable.getModel();
    //    8   16:aload_0         
    //    9   17:getfield        #42  <Field JTable UPATable>
    //   10   20:invokevirtual   #231 <Method TableModel JTable.getModel()>
    //   11   23:checkcast       #247 <Class DefaultTableModel>
    //   12   26:astore_3        
        TableColumnModel upacolmodel = UPATable.getColumnModel();
    //   13   27:aload_0         
    //   14   28:getfield        #42  <Field JTable UPATable>
    //   15   31:invokevirtual   #251 <Method TableColumnModel JTable.getColumnModel()>
    //   16   34:astore          4
        upamodel.setColumnIdentifiers(permSet);
    //   17   36:aload_3         
    //   18   37:aload_0         
    //   19   38:getfield        #82  <Field Object[] permSet>
    //   20   41:invokevirtual   #255 <Method void DefaultTableModel.setColumnIdentifiers(Object[])>
        Object cells[][] = new Object[nodes.length][permSet.length];
    //   21   44:aload_0         
    //   22   45:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //   23   48:arraylength     
    //   24   49:aload_0         
    //   25   50:getfield        #82  <Field Object[] permSet>
    //   26   53:arraylength     
    //   27   54:multianewarray  Object[][]
    //   28   58:astore          5
        for(int i = 0; i < roleSet.length; i++)
    //*  29   60:iconst_0        
    //*  30   61:istore_1        
    //*  31   62:goto            140
        {
            for(int j = 0; j < permSet.length; j++)
    //*  32   65:iconst_0        
    //*  33   66:istore_2        
    //*  34   67:goto            120
                if(nodes[i].SelfPerms.getElementAt(j))
    //*  35   70:aload_0         
    //*  36   71:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //*  37   74:iload_1         
    //*  38   75:aaload          
    //*  39   76:getfield        #260 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //*  40   79:iload_2         
    //*  41   80:invokevirtual   #263 <Method boolean IntegerSet.getElementAt(int)>
    //*  42   83:ifeq            103
                    cells[i][j] = new Boolean(true);
    //   43   86:aload           5
    //   44   88:iload_1         
    //   45   89:aaload          
    //   46   90:iload_2         
    //   47   91:new             #265 <Class Boolean>
    //   48   94:dup             
    //   49   95:iconst_1        
    //   50   96:invokespecial   #268 <Method void Boolean(boolean)>
    //   51   99:aastore         
                else
    //*  52  100:goto            117
                    cells[i][j] = new Boolean(false);
    //   53  103:aload           5
    //   54  105:iload_1         
    //   55  106:aaload          
    //   56  107:iload_2         
    //   57  108:new             #265 <Class Boolean>
    //   58  111:dup             
    //   59  112:iconst_0        
    //   60  113:invokespecial   #268 <Method void Boolean(boolean)>
    //   61  116:aastore         

    //   62  117:iinc            2  1
    //   63  120:iload_2         
    //   64  121:aload_0         
    //   65  122:getfield        #82  <Field Object[] permSet>
    //   66  125:arraylength     
    //   67  126:icmplt          70
            upamodel.addRow(cells[i]);
    //   68  129:aload_3         
    //   69  130:aload           5
    //   70  132:iload_1         
    //   71  133:aaload          
    //   72  134:invokevirtual   #271 <Method void DefaultTableModel.addRow(Object[])>
        }

    //   73  137:iinc            1  1
    //   74  140:iload_1         
    //   75  141:aload_0         
    //   76  142:getfield        #80  <Field Object[] roleSet>
    //   77  145:arraylength     
    //   78  146:icmplt          65
        for(int j = 0; j < permSet.length; j++)
    //*  79  149:iconst_0        
    //*  80  150:istore_2        
    //*  81  151:goto            201
        {
            upacolmodel.getColumn(j).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    //   82  154:aload           4
    //   83  156:iload_2         
    //   84  157:invokeinterface #277 <Method TableColumn TableColumnModel.getColumn(int)>
    //   85  162:new             #279 <Class DefaultCellEditor>
    //   86  165:dup             
    //   87  166:new             #281 <Class JCheckBox>
    //   88  169:dup             
    //   89  170:invokespecial   #282 <Method void JCheckBox()>
    //   90  173:invokespecial   #285 <Method void DefaultCellEditor(JCheckBox)>
    //   91  176:invokevirtual   #291 <Method void TableColumn.setCellEditor(javax.swing.table.TableCellEditor)>
            upacolmodel.getColumn(j).setCellRenderer(new UPATableCellRenderer());
    //   92  179:aload           4
    //   93  181:iload_2         
    //   94  182:invokeinterface #277 <Method TableColumn TableColumnModel.getColumn(int)>
    //   95  187:new             #293 <Class RoleEditorTable$UPATableCellRenderer>
    //   96  190:dup             
    //   97  191:aload_0         
    //   98  192:invokespecial   #294 <Method void RoleEditorTable$UPATableCellRenderer(RoleEditorTable)>
    //   99  195:invokevirtual   #298 <Method void TableColumn.setCellRenderer(TableCellRenderer)>
        }

    //  100  198:iinc            2  1
    //  101  201:iload_2         
    //  102  202:aload_0         
    //  103  203:getfield        #82  <Field Object[] permSet>
    //  104  206:arraylength     
    //  105  207:icmplt          154
        UPATable.setAutoCreateRowSorter(false);
    //  106  210:aload_0         
    //  107  211:getfield        #42  <Field JTable UPATable>
    //  108  214:iconst_0        
    //  109  215:invokevirtual   #301 <Method void JTable.setAutoCreateRowSorter(boolean)>
        UPATable.setAutoResizeMode(0);
    //  110  218:aload_0         
    //  111  219:getfield        #42  <Field JTable UPATable>
    //  112  222:iconst_0        
    //  113  223:invokevirtual   #159 <Method void JTable.setAutoResizeMode(int)>
        UPATable.getTableHeader().setReorderingAllowed(true);
    //  114  226:aload_0         
    //  115  227:getfield        #42  <Field JTable UPATable>
    //  116  230:invokevirtual   #211 <Method JTableHeader JTable.getTableHeader()>
    //  117  233:iconst_1        
    //  118  234:invokevirtual   #306 <Method void JTableHeader.setReorderingAllowed(boolean)>
        upacolmodel.setColumnSelectionAllowed(true);
    //  119  237:aload           4
    //  120  239:iconst_1        
    //  121  240:invokeinterface #309 <Method void TableColumnModel.setColumnSelectionAllowed(boolean)>
        UPATable.setRowSelectionAllowed(true);
    //  122  245:aload_0         
    //  123  246:getfield        #42  <Field JTable UPATable>
    //  124  249:iconst_1        
    //  125  250:invokevirtual   #312 <Method void JTable.setRowSelectionAllowed(boolean)>
    //  126  253:return          
    }

    public RoleNodes.RNode[] getNodes()
    {
        return nodes;
    //    0    0:aload_0         
    //    1    1:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //    2    4:areturn         
    }

    public void setNodes(RoleNodes.RNode nodes[])
    {
        this.nodes = nodes;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #84  <Field RoleNodes$RNode[] nodes>
    //    3    5:return          
    }

    public void setChoosed(String roleName)
    {
        UPATable.selectAll();
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field JTable UPATable>
    //    2    4:invokevirtual   #326 <Method void JTable.selectAll()>
        int i = -1;
    //    3    7:iconst_m1       
    //    4    8:istore_2        
        int length = roleSet.length;
    //    5    9:aload_0         
    //    6   10:getfield        #80  <Field Object[] roleSet>
    //    7   13:arraylength     
    //    8   14:istore          4
        for(i = 0; i < length; i++)
    //*   9   16:iconst_0        
    //*  10   17:istore_2        
    //*  11   18:goto            43
            if(roleSet[i].toString().equals(roleName))
    //*  12   21:aload_0         
    //*  13   22:getfield        #80  <Field Object[] roleSet>
    //*  14   25:iload_2         
    //*  15   26:aaload          
    //*  16   27:invokevirtual   #329 <Method String Object.toString()>
    //*  17   30:aload_1         
    //*  18   31:invokevirtual   #334 <Method boolean String.equals(Object)>
    //*  19   34:ifeq            40
                break;
    //   20   37:goto            49

    //   21   40:iinc            2  1
    //   22   43:iload_2         
    //   23   44:iload           4
    //   24   46:icmplt          21
        if(i < length)
    //*  25   49:iload_2         
    //*  26   50:iload           4
    //*  27   52:icmpge          154
        {
            fixedTable.setRowSelectionInterval(i, i);
    //   28   55:aload_0         
    //   29   56:getfield        #47  <Field JTable fixedTable>
    //   30   59:iload_2         
    //   31   60:iload_2         
    //   32   61:invokevirtual   #338 <Method void JTable.setRowSelectionInterval(int, int)>
            fixedTable.setSelectionBackground(Color.BLUE);
    //   33   64:aload_0         
    //   34   65:getfield        #47  <Field JTable fixedTable>
    //   35   68:getstatic       #344 <Field Color Color.BLUE>
    //   36   71:invokevirtual   #347 <Method void JTable.setSelectionBackground(Color)>
            TableColumnModel upacolmodel = UPATable.getColumnModel();
    //   37   74:aload_0         
    //   38   75:getfield        #42  <Field JTable UPATable>
    //   39   78:invokevirtual   #251 <Method TableColumnModel JTable.getColumnModel()>
    //   40   81:astore          5
            for(int j = 0; j < permSet.length; j++)
    //*  41   83:iconst_0        
    //*  42   84:istore_3        
    //*  43   85:goto            145
            {
                upacolmodel.getColumn(j).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    //   44   88:aload           5
    //   45   90:iload_3         
    //   46   91:invokeinterface #277 <Method TableColumn TableColumnModel.getColumn(int)>
    //   47   96:new             #279 <Class DefaultCellEditor>
    //   48   99:dup             
    //   49  100:new             #281 <Class JCheckBox>
    //   50  103:dup             
    //   51  104:invokespecial   #282 <Method void JCheckBox()>
    //   52  107:invokespecial   #285 <Method void DefaultCellEditor(JCheckBox)>
    //   53  110:invokevirtual   #291 <Method void TableColumn.setCellEditor(javax.swing.table.TableCellEditor)>
                UPATableCellRenderer temp = new UPATableCellRenderer();
    //   54  113:new             #293 <Class RoleEditorTable$UPATableCellRenderer>
    //   55  116:dup             
    //   56  117:aload_0         
    //   57  118:invokespecial   #294 <Method void RoleEditorTable$UPATableCellRenderer(RoleEditorTable)>
    //   58  121:astore          6
                temp.setRow = i;
    //   59  123:aload           6
    //   60  125:iload_2         
    //   61  126:putfield        #350 <Field int RoleEditorTable$UPATableCellRenderer.setRow>
                upacolmodel.getColumn(j).setCellRenderer(temp);
    //   62  129:aload           5
    //   63  131:iload_3         
    //   64  132:invokeinterface #277 <Method TableColumn TableColumnModel.getColumn(int)>
    //   65  137:aload           6
    //   66  139:invokevirtual   #298 <Method void TableColumn.setCellRenderer(TableCellRenderer)>
            }

    //   67  142:iinc            3  1
    //   68  145:iload_3         
    //   69  146:aload_0         
    //   70  147:getfield        #82  <Field Object[] permSet>
    //   71  150:arraylength     
    //   72  151:icmplt          88
        }
    //   73  154:return          
    }

    private JTable UPATable;
    private JTable fixedTable;
    private RoleNodes.RNode nodes[];
    private JViewport viewport;
    private JScrollPane t_Scroll;
    private String DimX;
    private String DimY;
    private Object roleSet[];
    private Object permSet[];
    private Object weightSet[];
    private static Vector inheritcells = new Vector();
    public int haveChaged;

    static 
    {
    //    0    0:new             #31  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #34  <Method void Vector()>
    //    3    7:putstatic       #36  <Field Vector inheritcells>
    //*   4   10:return          
    }


/*
    static Vector access$0()
    {
        return inheritcells;
    //    0    0:getstatic       #36  <Field Vector inheritcells>
    //    1    3:areturn         
    }

*/


/*
    static JTable access$1(RoleEditorTable roleeditortable)
    {
        return roleeditortable.UPATable;
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field JTable UPATable>
    //    2    4:areturn         
    }

*/


/*
    static RoleNodes.RNode[] access$2(RoleEditorTable roleeditortable)
    {
        return roleeditortable.nodes;
    //    0    0:aload_0         
    //    1    1:getfield        #84  <Field RoleNodes$RNode[] nodes>
    //    2    4:areturn         
    }

*/
}

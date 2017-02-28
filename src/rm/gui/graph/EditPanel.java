// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   EditPanel.java

package rm.gui.graph;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import rm.core.*;

// Referenced classes of package rm.gui.graph:
//            UserFixedTableModel

public class EditPanel extends JPanel
{
    class UPATableCellRenderer extends JCheckBox
        implements TableCellRenderer
    {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            Boolean bv = (Boolean)value;
        //    0    0:aload_2         
        //    1    1:checkcast       #24  <Class Boolean>
        //    2    4:astore          7
            setSelected(bv.booleanValue());
        //    3    6:aload_0         
        //    4    7:aload           7
        //    5    9:invokevirtual   #28  <Method boolean Boolean.booleanValue()>
        //    6   12:invokevirtual   #32  <Method void setSelected(boolean)>
            return this;
        //    7   15:aload_0         
        //    8   16:areturn         
        }

        final EditPanel this$0;

        UPATableCellRenderer()
        {
            this$0 = EditPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #13  <Field EditPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #16  <Method void JCheckBox()>
        //    5    9:return          
        }
    }

    public class ChangedValue
    {

        public int i;
        public int j;
        public boolean v;
        final EditPanel this$0;

        public ChangedValue()
        {
            this$0 = EditPanel.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field EditPanel this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void Object()>
            i = -1;
        //    5    9:aload_0         
        //    6   10:iconst_m1       
        //    7   11:putfield        #21  <Field int i>
            j = -1;
        //    8   14:aload_0         
        //    9   15:iconst_m1       
        //   10   16:putfield        #23  <Field int j>
            v = false;
        //   11   19:aload_0         
        //   12   20:iconst_0        
        //   13   21:putfield        #25  <Field boolean v>
        //   14   24:return          
        }
    }


    public EditPanel(Assignment m_Assignment, JButton m_UndoButton)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #31  <Method void JPanel()>
        UPATable = new JTable();
    //    2    4:aload_0         
    //    3    5:new             #33  <Class JTable>
    //    4    8:dup             
    //    5    9:invokespecial   #34  <Method void JTable()>
    //    6   12:putfield        #36  <Field JTable UPATable>
        fixedTable = new JTable();
    //    7   15:aload_0         
    //    8   16:new             #33  <Class JTable>
    //    9   19:dup             
    //   10   20:invokespecial   #34  <Method void JTable()>
    //   11   23:putfield        #38  <Field JTable fixedTable>
        changedvalues = new Vector();
    //   12   26:aload_0         
    //   13   27:new             #40  <Class Vector>
    //   14   30:dup             
    //   15   31:invokespecial   #41  <Method void Vector()>
    //   16   34:putfield        #43  <Field Vector changedvalues>
        m_Undo = m_UndoButton;
    //   17   37:aload_0         
    //   18   38:aload_2         
    //   19   39:putfield        #45  <Field JButton m_Undo>
        mat = m_Assignment.getAssignmentMatrix();
    //   20   42:aload_0         
    //   21   43:aload_1         
    //   22   44:invokevirtual   #51  <Method Matrix Assignment.getAssignmentMatrix()>
    //   23   47:putfield        #53  <Field Matrix mat>
        DimX = m_Assignment.getDimensionX().getName();
    //   24   50:aload_0         
    //   25   51:aload_1         
    //   26   52:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //   27   55:invokevirtual   #63  <Method String Dimension.getName()>
    //   28   58:putfield        #65  <Field String DimX>
        DimY = m_Assignment.getDimensionY().getName();
    //   29   61:aload_0         
    //   30   62:aload_1         
    //   31   63:invokevirtual   #68  <Method Dimension Assignment.getDimensionY()>
    //   32   66:invokevirtual   #63  <Method String Dimension.getName()>
    //   33   69:putfield        #70  <Field String DimY>
        userSet = m_Assignment.getDimensionX().getDimensionAttribute().toArray();
    //   34   72:aload_0         
    //   35   73:aload_1         
    //   36   74:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //   37   77:invokevirtual   #74  <Method Attribute Dimension.getDimensionAttribute()>
    //   38   80:invokevirtual   #80  <Method Object[] Attribute.toArray()>
    //   39   83:putfield        #82  <Field Object[] userSet>
        permSet = m_Assignment.getDimensionY().getDimensionAttribute().toArray();
    //   40   86:aload_0         
    //   41   87:aload_1         
    //   42   88:invokevirtual   #68  <Method Dimension Assignment.getDimensionY()>
    //   43   91:invokevirtual   #74  <Method Attribute Dimension.getDimensionAttribute()>
    //   44   94:invokevirtual   #80  <Method Object[] Attribute.toArray()>
    //   45   97:putfield        #84  <Field Object[] permSet>
        SetPanel();
    //   46  100:aload_0         
    //   47  101:invokespecial   #87  <Method void SetPanel()>
    //   48  104:return          
    }

    private void SetPanel()
    {
        setUPATable();
    //    0    0:aload_0         
    //    1    1:invokespecial   #97  <Method void setUPATable()>
        UserFixedTableModel.setColumName(DimX, DimY);
    //    2    4:aload_0         
    //    3    5:getfield        #65  <Field String DimX>
    //    4    8:aload_0         
    //    5    9:getfield        #70  <Field String DimY>
    //    6   12:invokestatic    #103 <Method void UserFixedTableModel.setColumName(String, String)>
        fixedTable = new JTable(new UserFixedTableModel(userSet));
    //    7   15:aload_0         
    //    8   16:new             #33  <Class JTable>
    //    9   19:dup             
    //   10   20:new             #99  <Class UserFixedTableModel>
    //   11   23:dup             
    //   12   24:aload_0         
    //   13   25:getfield        #82  <Field Object[] userSet>
    //   14   28:invokespecial   #106 <Method void UserFixedTableModel(Object[])>
    //   15   31:invokespecial   #109 <Method void JTable(TableModel)>
    //   16   34:putfield        #38  <Field JTable fixedTable>
        fixedTable.setAutoResizeMode(0);
    //   17   37:aload_0         
    //   18   38:getfield        #38  <Field JTable fixedTable>
    //   19   41:iconst_0        
    //   20   42:invokevirtual   #113 <Method void JTable.setAutoResizeMode(int)>
        fixedTable.setSelectionMode(0);
    //   21   45:aload_0         
    //   22   46:getfield        #38  <Field JTable fixedTable>
    //   23   49:iconst_0        
    //   24   50:invokevirtual   #116 <Method void JTable.setSelectionMode(int)>
        viewport = new JViewport();
    //   25   53:aload_0         
    //   26   54:new             #118 <Class JViewport>
    //   27   57:dup             
    //   28   58:invokespecial   #119 <Method void JViewport()>
    //   29   61:putfield        #121 <Field JViewport viewport>
        viewport.setView(fixedTable);
    //   30   64:aload_0         
    //   31   65:getfield        #121 <Field JViewport viewport>
    //   32   68:aload_0         
    //   33   69:getfield        #38  <Field JTable fixedTable>
    //   34   72:invokevirtual   #125 <Method void JViewport.setView(Component)>
        viewport.setPreferredSize(fixedTable.getPreferredSize());
    //   35   75:aload_0         
    //   36   76:getfield        #121 <Field JViewport viewport>
    //   37   79:aload_0         
    //   38   80:getfield        #38  <Field JTable fixedTable>
    //   39   83:invokevirtual   #129 <Method java.awt.Dimension JTable.getPreferredSize()>
    //   40   86:invokevirtual   #133 <Method void JViewport.setPreferredSize(java.awt.Dimension)>
        t_Scroll = new JScrollPane(UPATable);
    //   41   89:aload_0         
    //   42   90:new             #135 <Class JScrollPane>
    //   43   93:dup             
    //   44   94:aload_0         
    //   45   95:getfield        #36  <Field JTable UPATable>
    //   46   98:invokespecial   #137 <Method void JScrollPane(Component)>
    //   47  101:putfield        #139 <Field JScrollPane t_Scroll>
        t_Scroll.setRowHeaderView(viewport);
    //   48  104:aload_0         
    //   49  105:getfield        #139 <Field JScrollPane t_Scroll>
    //   50  108:aload_0         
    //   51  109:getfield        #121 <Field JViewport viewport>
    //   52  112:invokevirtual   #142 <Method void JScrollPane.setRowHeaderView(Component)>
        t_Scroll.setCorner("UPPER_LEFT_CORNER", fixedTable.getTableHeader());
    //   53  115:aload_0         
    //   54  116:getfield        #139 <Field JScrollPane t_Scroll>
    //   55  119:ldc1            #144 <String "UPPER_LEFT_CORNER">
    //   56  121:aload_0         
    //   57  122:getfield        #38  <Field JTable fixedTable>
    //   58  125:invokevirtual   #148 <Method JTableHeader JTable.getTableHeader()>
    //   59  128:invokevirtual   #152 <Method void JScrollPane.setCorner(String, Component)>
        removeAll();
    //   60  131:aload_0         
    //   61  132:invokevirtual   #155 <Method void removeAll()>
        setLayout(new BorderLayout());
    //   62  135:aload_0         
    //   63  136:new             #157 <Class BorderLayout>
    //   64  139:dup             
    //   65  140:invokespecial   #158 <Method void BorderLayout()>
    //   66  143:invokevirtual   #162 <Method void setLayout(java.awt.LayoutManager)>
        add(t_Scroll, "Center");
    //   67  146:aload_0         
    //   68  147:aload_0         
    //   69  148:getfield        #139 <Field JScrollPane t_Scroll>
    //   70  151:ldc1            #164 <String "Center">
    //   71  153:invokevirtual   #168 <Method void add(Component, Object)>
        UPATable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e)
            {
                m_Undo.setEnabled(true);
            //    0    0:aload_0         
            //    1    1:getfield        #13  <Field EditPanel this$0>
            //    2    4:invokestatic    #28  <Method JButton EditPanel.access$0(EditPanel)>
            //    3    7:iconst_1        
            //    4    8:invokevirtual   #34  <Method void JButton.setEnabled(boolean)>
                if(e.getType() == 0 && UPATable.getSelectedRow() != -1)
            //*   5   11:aload_1         
            //*   6   12:invokevirtual   #40  <Method int TableModelEvent.getType()>
            //*   7   15:ifne            152
            //*   8   18:aload_0         
            //*   9   19:getfield        #13  <Field EditPanel this$0>
            //*  10   22:invokestatic    #44  <Method JTable EditPanel.access$1(EditPanel)>
            //*  11   25:invokevirtual   #49  <Method int JTable.getSelectedRow()>
            //*  12   28:iconst_m1       
            //*  13   29:icmpeq          152
                {
                    int i = UPATable.getSelectedRow();
            //   14   32:aload_0         
            //   15   33:getfield        #13  <Field EditPanel this$0>
            //   16   36:invokestatic    #44  <Method JTable EditPanel.access$1(EditPanel)>
            //   17   39:invokevirtual   #49  <Method int JTable.getSelectedRow()>
            //   18   42:istore_2        
                    int j = UPATable.getSelectedColumn();
            //   19   43:aload_0         
            //   20   44:getfield        #13  <Field EditPanel this$0>
            //   21   47:invokestatic    #44  <Method JTable EditPanel.access$1(EditPanel)>
            //   22   50:invokevirtual   #52  <Method int JTable.getSelectedColumn()>
            //   23   53:istore_3        
                    ChangedValue cv = new ChangedValue();
            //   24   54:new             #54  <Class EditPanel$ChangedValue>
            //   25   57:dup             
            //   26   58:aload_0         
            //   27   59:getfield        #13  <Field EditPanel this$0>
            //   28   62:invokespecial   #56  <Method void EditPanel$ChangedValue(EditPanel)>
            //   29   65:astore          4
                    cv.i = i;
            //   30   67:aload           4
            //   31   69:iload_2         
            //   32   70:putfield        #60  <Field int EditPanel$ChangedValue.i>
                    cv.j = j;
            //   33   73:aload           4
            //   34   75:iload_3         
            //   35   76:putfield        #63  <Field int EditPanel$ChangedValue.j>
                    cv.v = ((Boolean)UPATable.getValueAt(i, j)).booleanValue();
            //   36   79:aload           4
            //   37   81:aload_0         
            //   38   82:getfield        #13  <Field EditPanel this$0>
            //   39   85:invokestatic    #44  <Method JTable EditPanel.access$1(EditPanel)>
            //   40   88:iload_2         
            //   41   89:iload_3         
            //   42   90:invokevirtual   #67  <Method Object JTable.getValueAt(int, int)>
            //   43   93:checkcast       #69  <Class Boolean>
            //   44   96:invokevirtual   #73  <Method boolean Boolean.booleanValue()>
            //   45   99:putfield        #77  <Field boolean EditPanel$ChangedValue.v>
                    changedvalues.add(cv);
            //   46  102:aload_0         
            //   47  103:getfield        #13  <Field EditPanel this$0>
            //   48  106:getfield        #81  <Field Vector EditPanel.changedvalues>
            //   49  109:aload           4
            //   50  111:invokevirtual   #87  <Method boolean Vector.add(Object)>
            //   51  114:pop             
                    if(cv.v)
            //*  52  115:aload           4
            //*  53  117:getfield        #77  <Field boolean EditPanel$ChangedValue.v>
            //*  54  120:ifeq            139
                        mat.set(i, j, (byte)1);
            //   55  123:aload_0         
            //   56  124:getfield        #13  <Field EditPanel this$0>
            //   57  127:invokestatic    #91  <Method Matrix EditPanel.access$2(EditPanel)>
            //   58  130:iload_2         
            //   59  131:iload_3         
            //   60  132:iconst_1        
            //   61  133:invokevirtual   #97  <Method void Matrix.set(int, int, byte)>
                    else
            //*  62  136:goto            152
                        mat.set(i, j, (byte)0);
            //   63  139:aload_0         
            //   64  140:getfield        #13  <Field EditPanel this$0>
            //   65  143:invokestatic    #91  <Method Matrix EditPanel.access$2(EditPanel)>
            //   66  146:iload_2         
            //   67  147:iload_3         
            //   68  148:iconst_0        
            //   69  149:invokevirtual   #97  <Method void Matrix.set(int, int, byte)>
                }
            //   70  152:return          
            }

            final EditPanel this$0;

            
            {
                this$0 = EditPanel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field EditPanel this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
);
    //   72  156:aload_0         
    //   73  157:getfield        #36  <Field JTable UPATable>
    //   74  160:invokevirtual   #172 <Method TableModel JTable.getModel()>
    //   75  163:new             #174 <Class EditPanel$1>
    //   76  166:dup             
    //   77  167:aload_0         
    //   78  168:invokespecial   #177 <Method void EditPanel$1(EditPanel)>
    //   79  171:invokeinterface #183 <Method void TableModel.addTableModelListener(TableModelListener)>
    //   80  176:return          
    }

    private void setUPATable()
    {
        DefaultTableModel upamodel = (DefaultTableModel)UPATable.getModel();
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field JTable UPATable>
    //    2    4:invokevirtual   #172 <Method TableModel JTable.getModel()>
    //    3    7:checkcast       #185 <Class DefaultTableModel>
    //    4   10:astore_3        
        TableColumnModel upacolmodel = UPATable.getColumnModel();
    //    5   11:aload_0         
    //    6   12:getfield        #36  <Field JTable UPATable>
    //    7   15:invokevirtual   #189 <Method TableColumnModel JTable.getColumnModel()>
    //    8   18:astore          4
        String PermNames[] = new String[mat.getColumnDimension()];
    //    9   20:aload_0         
    //   10   21:getfield        #53  <Field Matrix mat>
    //   11   24:invokevirtual   #195 <Method int Matrix.getColumnDimension()>
    //   12   27:anewarray       String[]
    //   13   30:astore          5
        upamodel.setColumnIdentifiers(permSet);
    //   14   32:aload_3         
    //   15   33:aload_0         
    //   16   34:getfield        #84  <Field Object[] permSet>
    //   17   37:invokevirtual   #200 <Method void DefaultTableModel.setColumnIdentifiers(Object[])>
        addUPAValue();
    //   18   40:aload_0         
    //   19   41:invokespecial   #203 <Method void addUPAValue()>
        for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  20   44:iconst_0        
    //*  21   45:istore_2        
    //*  22   46:goto            96
        {
            upacolmodel.getColumn(j).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    //   23   49:aload           4
    //   24   51:iload_2         
    //   25   52:invokeinterface #209 <Method TableColumn TableColumnModel.getColumn(int)>
    //   26   57:new             #211 <Class DefaultCellEditor>
    //   27   60:dup             
    //   28   61:new             #213 <Class JCheckBox>
    //   29   64:dup             
    //   30   65:invokespecial   #214 <Method void JCheckBox()>
    //   31   68:invokespecial   #217 <Method void DefaultCellEditor(JCheckBox)>
    //   32   71:invokevirtual   #223 <Method void TableColumn.setCellEditor(javax.swing.table.TableCellEditor)>
            upacolmodel.getColumn(j).setCellRenderer(new UPATableCellRenderer());
    //   33   74:aload           4
    //   34   76:iload_2         
    //   35   77:invokeinterface #209 <Method TableColumn TableColumnModel.getColumn(int)>
    //   36   82:new             #225 <Class EditPanel$UPATableCellRenderer>
    //   37   85:dup             
    //   38   86:aload_0         
    //   39   87:invokespecial   #226 <Method void EditPanel$UPATableCellRenderer(EditPanel)>
    //   40   90:invokevirtual   #230 <Method void TableColumn.setCellRenderer(TableCellRenderer)>
        }

    //   41   93:iinc            2  1
    //   42   96:iload_2         
    //   43   97:aload_0         
    //   44   98:getfield        #53  <Field Matrix mat>
    //   45  101:invokevirtual   #195 <Method int Matrix.getColumnDimension()>
    //   46  104:icmplt          49
        UPATable.setAutoCreateRowSorter(true);
    //   47  107:aload_0         
    //   48  108:getfield        #36  <Field JTable UPATable>
    //   49  111:iconst_1        
    //   50  112:invokevirtual   #234 <Method void JTable.setAutoCreateRowSorter(boolean)>
        UPATable.setAutoResizeMode(0);
    //   51  115:aload_0         
    //   52  116:getfield        #36  <Field JTable UPATable>
    //   53  119:iconst_0        
    //   54  120:invokevirtual   #113 <Method void JTable.setAutoResizeMode(int)>
        UPATable.getTableHeader().setReorderingAllowed(true);
    //   55  123:aload_0         
    //   56  124:getfield        #36  <Field JTable UPATable>
    //   57  127:invokevirtual   #148 <Method JTableHeader JTable.getTableHeader()>
    //   58  130:iconst_1        
    //   59  131:invokevirtual   #239 <Method void JTableHeader.setReorderingAllowed(boolean)>
    //   60  134:return          
    }

    private void addUPAValue()
    {
        DefaultTableModel upamodel = (DefaultTableModel)UPATable.getModel();
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field JTable UPATable>
    //    2    4:invokevirtual   #172 <Method TableModel JTable.getModel()>
    //    3    7:checkcast       #185 <Class DefaultTableModel>
    //    4   10:astore_1        
        Object cells[][] = new Object[mat.getRowDimension()][mat.getColumnDimension()];
    //    5   11:aload_0         
    //    6   12:getfield        #53  <Field Matrix mat>
    //    7   15:invokevirtual   #250 <Method int Matrix.getRowDimension()>
    //    8   18:aload_0         
    //    9   19:getfield        #53  <Field Matrix mat>
    //   10   22:invokevirtual   #195 <Method int Matrix.getColumnDimension()>
    //   11   25:multianewarray  Object[][]
    //   12   29:astore_2        
        for(int i = 0; i < mat.getRowDimension(); i++)
    //*  13   30:iconst_0        
    //*  14   31:istore_3        
    //*  15   32:goto            111
        {
            for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  16   35:iconst_0        
    //*  17   36:istore          4
    //*  18   38:goto            89
                if(mat.get(i, j) == 1)
    //*  19   41:aload_0         
    //*  20   42:getfield        #53  <Field Matrix mat>
    //*  21   45:iload_3         
    //*  22   46:iload           4
    //*  23   48:invokevirtual   #256 <Method byte Matrix.get(int, int)>
    //*  24   51:iconst_1        
    //*  25   52:icmpne          72
                    cells[i][j] = new Boolean(true);
    //   26   55:aload_2         
    //   27   56:iload_3         
    //   28   57:aaload          
    //   29   58:iload           4
    //   30   60:new             #258 <Class Boolean>
    //   31   63:dup             
    //   32   64:iconst_1        
    //   33   65:invokespecial   #260 <Method void Boolean(boolean)>
    //   34   68:aastore         
                else
    //*  35   69:goto            86
                    cells[i][j] = new Boolean(false);
    //   36   72:aload_2         
    //   37   73:iload_3         
    //   38   74:aaload          
    //   39   75:iload           4
    //   40   77:new             #258 <Class Boolean>
    //   41   80:dup             
    //   42   81:iconst_0        
    //   43   82:invokespecial   #260 <Method void Boolean(boolean)>
    //   44   85:aastore         

    //   45   86:iinc            4  1
    //   46   89:iload           4
    //   47   91:aload_0         
    //   48   92:getfield        #53  <Field Matrix mat>
    //   49   95:invokevirtual   #195 <Method int Matrix.getColumnDimension()>
    //   50   98:icmplt          41
            upamodel.addRow(cells[i]);
    //   51  101:aload_1         
    //   52  102:aload_2         
    //   53  103:iload_3         
    //   54  104:aaload          
    //   55  105:invokevirtual   #263 <Method void DefaultTableModel.addRow(Object[])>
        }

    //   56  108:iinc            3  1
    //   57  111:iload_3         
    //   58  112:aload_0         
    //   59  113:getfield        #53  <Field Matrix mat>
    //   60  116:invokevirtual   #250 <Method int Matrix.getRowDimension()>
    //   61  119:icmplt          35
    //   62  122:return          
    }

    public void undo()
    {
        if(changedvalues.size() >= 1)
    //*   0    0:aload_0         
    //*   1    1:getfield        #43  <Field Vector changedvalues>
    //*   2    4:invokevirtual   #269 <Method int Vector.size()>
    //*   3    7:iconst_1        
    //*   4    8:icmplt          111
        {
            System.out.println(changedvalues.size());
    //    5   11:getstatic       #275 <Field PrintStream System.out>
    //    6   14:aload_0         
    //    7   15:getfield        #43  <Field Vector changedvalues>
    //    8   18:invokevirtual   #269 <Method int Vector.size()>
    //    9   21:invokevirtual   #280 <Method void PrintStream.println(int)>
            ChangedValue cv = (ChangedValue)changedvalues.remove(changedvalues.size() - 1);
    //   10   24:aload_0         
    //   11   25:getfield        #43  <Field Vector changedvalues>
    //   12   28:aload_0         
    //   13   29:getfield        #43  <Field Vector changedvalues>
    //   14   32:invokevirtual   #269 <Method int Vector.size()>
    //   15   35:iconst_1        
    //   16   36:isub            
    //   17   37:invokevirtual   #284 <Method Object Vector.remove(int)>
    //   18   40:checkcast       #286 <Class EditPanel$ChangedValue>
    //   19   43:astore_1        
            if(cv.v)
    //*  20   44:aload_1         
    //*  21   45:getfield        #290 <Field boolean EditPanel$ChangedValue.v>
    //*  22   48:ifeq            70
                mat.set(cv.i, cv.j, (byte)0);
    //   23   51:aload_0         
    //   24   52:getfield        #53  <Field Matrix mat>
    //   25   55:aload_1         
    //   26   56:getfield        #292 <Field int EditPanel$ChangedValue.i>
    //   27   59:aload_1         
    //   28   60:getfield        #294 <Field int EditPanel$ChangedValue.j>
    //   29   63:iconst_0        
    //   30   64:invokevirtual   #298 <Method void Matrix.set(int, int, byte)>
            else
    //*  31   67:goto            86
                mat.set(cv.i, cv.j, (byte)1);
    //   32   70:aload_0         
    //   33   71:getfield        #53  <Field Matrix mat>
    //   34   74:aload_1         
    //   35   75:getfield        #292 <Field int EditPanel$ChangedValue.i>
    //   36   78:aload_1         
    //   37   79:getfield        #294 <Field int EditPanel$ChangedValue.j>
    //   38   82:iconst_1        
    //   39   83:invokevirtual   #298 <Method void Matrix.set(int, int, byte)>
            UPATable = new JTable();
    //   40   86:aload_0         
    //   41   87:new             #33  <Class JTable>
    //   42   90:dup             
    //   43   91:invokespecial   #34  <Method void JTable()>
    //   44   94:putfield        #36  <Field JTable UPATable>
            SetPanel();
    //   45   97:aload_0         
    //   46   98:invokespecial   #87  <Method void SetPanel()>
            t_Scroll.updateUI();
    //   47  101:aload_0         
    //   48  102:getfield        #139 <Field JScrollPane t_Scroll>
    //   49  105:invokevirtual   #301 <Method void JScrollPane.updateUI()>
        } else
    //*  50  108:goto            119
        {
            m_Undo.setEnabled(false);
    //   51  111:aload_0         
    //   52  112:getfield        #45  <Field JButton m_Undo>
    //   53  115:iconst_0        
    //   54  116:invokevirtual   #306 <Method void JButton.setEnabled(boolean)>
        }
    //   55  119:return          
    }

    public Matrix getMatrix()
    {
        return mat;
    //    0    0:aload_0         
    //    1    1:getfield        #53  <Field Matrix mat>
    //    2    4:areturn         
    }

    private JTable UPATable;
    private JTable fixedTable;
    private JViewport viewport;
    private JScrollPane t_Scroll;
    private Matrix mat;
    private String DimX;
    private String DimY;
    private Object userSet[];
    private Object permSet[];
    Vector changedvalues;
    private JButton m_Undo;


/*
    static JButton access$0(EditPanel editpanel)
    {
        return editpanel.m_Undo;
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field JButton m_Undo>
    //    2    4:areturn         
    }

*/


/*
    static JTable access$1(EditPanel editpanel)
    {
        return editpanel.UPATable;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field JTable UPATable>
    //    2    4:areturn         
    }

*/


/*
    static Matrix access$2(EditPanel editpanel)
    {
        return editpanel.mat;
    //    0    0:aload_0         
    //    1    1:getfield        #53  <Field Matrix mat>
    //    2    4:areturn         
    }

*/
}

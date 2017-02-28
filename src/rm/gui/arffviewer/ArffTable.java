// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffTable.java

package rm.gui.arffviewer;

import java.awt.Component;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import rm.core.Attribute;
import rm.core.Instances;
import rm.gui.*;

// Referenced classes of package rm.gui.arffviewer:
//            ArffSortedTableModel, ArffTableCellRenderer

public class ArffTable extends JTable
{
    protected class RelationalCellEditor extends AbstractCellEditor
        implements TableCellEditor
    {

        protected Instances getInstancesAt(int rowIndex, int columnIndex)
        {
            ArffSortedTableModel model = (ArffSortedTableModel)getModel();
        //    0    0:aload_0         
        //    1    1:getfield        #25  <Field ArffTable this$0>
        //    2    4:invokevirtual   #68  <Method TableModel ArffTable.getModel()>
        //    3    7:checkcast       #70  <Class ArffSortedTableModel>
        //    4   10:astore          4
            double value = model.getInstancesValueAt(rowIndex, columnIndex);
        //    5   12:aload           4
        //    6   14:iload_1         
        //    7   15:iload_2         
        //    8   16:invokevirtual   #74  <Method double ArffSortedTableModel.getInstancesValueAt(int, int)>
        //    9   19:dstore          5
            Instances result = model.getInstances().attribute(columnIndex - 1).relation((int)value);
        //   10   21:aload           4
        //   11   23:invokevirtual   #78  <Method Instances ArffSortedTableModel.getInstances()>
        //   12   26:iload_2         
        //   13   27:iconst_1        
        //   14   28:isub            
        //   15   29:invokevirtual   #84  <Method Attribute Instances.attribute(int)>
        //   16   32:dload           5
        //   17   34:d2i             
        //   18   35:invokevirtual   #90  <Method Instances Attribute.relation(int)>
        //   19   38:astore_3        
            return result;
        //   20   39:aload_3         
        //   21   40:areturn         
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
        {
            return m_Button;
        //    0    0:aload_0         
        //    1    1:getfield        #47  <Field JButton m_Button>
        //    2    4:areturn         
        }

        public Object getCellEditorValue()
        {
            return m_CurrentInst;
        //    0    0:aload_0         
        //    1    1:getfield        #34  <Field Instances m_CurrentInst>
        //    2    4:areturn         
        }

        private static final long serialVersionUID = 0x9219377cb40a5cbL;
        protected JButton m_Button;
        protected Instances m_CurrentInst;
        protected int m_RowIndex;
        protected int m_ColumnIndex;
        final ArffTable this$0;


/*
        static void access$0(RelationalCellEditor relationalcelleditor)
        {
            relationalcelleditor.fireEditingStopped();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #110 <Method void AbstractCellEditor.fireEditingStopped()>
            return;
        //    2    4:return          
        }

*/


/*
        static void access$1(RelationalCellEditor relationalcelleditor)
        {
            relationalcelleditor.fireEditingCanceled();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #115 <Method void AbstractCellEditor.fireEditingCanceled()>
            return;
        //    2    4:return          
        }

*/


/*
        static ArffTable access$2(RelationalCellEditor relationalcelleditor)
        {
            return relationalcelleditor.this$0;
        //    0    0:aload_0         
        //    1    1:getfield        #25  <Field ArffTable this$0>
        //    2    4:areturn         
        }

*/

        public RelationalCellEditor(int rowIndex, int columnIndex)
        {
            this$0 = ArffTable.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #25  <Field ArffTable this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #28  <Method void AbstractCellEditor()>
            m_CurrentInst = getInstancesAt(rowIndex, columnIndex);
        //    5    9:aload_0         
        //    6   10:aload_0         
        //    7   11:iload_2         
        //    8   12:iload_3         
        //    9   13:invokevirtual   #32  <Method Instances getInstancesAt(int, int)>
        //   10   16:putfield        #34  <Field Instances m_CurrentInst>
            m_RowIndex = rowIndex;
        //   11   19:aload_0         
        //   12   20:iload_2         
        //   13   21:putfield        #36  <Field int m_RowIndex>
            m_ColumnIndex = columnIndex;
        //   14   24:aload_0         
        //   15   25:iload_3         
        //   16   26:putfield        #38  <Field int m_ColumnIndex>
            m_Button = new JButton("...");
        //   17   29:aload_0         
        //   18   30:new             #40  <Class JButton>
        //   19   33:dup             
        //   20   34:ldc1            #42  <String "...">
        //   21   36:invokespecial   #45  <Method void JButton(String)>
        //   22   39:putfield        #47  <Field JButton m_Button>
            m_Button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt)
                {
                    ViewerDialog dialog = new ViewerDialog(null);
                //    0    0:new             #24  <Class ViewerDialog>
                //    1    3:dup             
                //    2    4:aconst_null     
                //    3    5:invokespecial   #27  <Method void ViewerDialog(java.awt.Frame)>
                //    4    8:astore_2        
                    dialog.setTitle((new StringBuilder("Relational attribute Viewer - ")).append(((ArffSortedTableModel)getModel()).getInstances().attribute(m_ColumnIndex - 1).name()).toString());
                //    5    9:aload_2         
                //    6   10:new             #29  <Class StringBuilder>
                //    7   13:dup             
                //    8   14:ldc1            #31  <String "Relational attribute Viewer - ">
                //    9   16:invokespecial   #34  <Method void StringBuilder(String)>
                //   10   19:aload_0         
                //   11   20:getfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                //   12   23:invokestatic    #40  <Method ArffTable ArffTable$RelationalCellEditor.access$2(ArffTable$RelationalCellEditor)>
                //   13   26:invokevirtual   #46  <Method TableModel ArffTable.getModel()>
                //   14   29:checkcast       #48  <Class ArffSortedTableModel>
                //   15   32:invokevirtual   #52  <Method Instances ArffSortedTableModel.getInstances()>
                //   16   35:aload_0         
                //   17   36:getfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                //   18   39:getfield        #56  <Field int ArffTable$RelationalCellEditor.m_ColumnIndex>
                //   19   42:iconst_1        
                //   20   43:isub            
                //   21   44:invokevirtual   #62  <Method Attribute Instances.attribute(int)>
                //   22   47:invokevirtual   #68  <Method String Attribute.name()>
                //   23   50:invokevirtual   #72  <Method StringBuilder StringBuilder.append(String)>
                //   24   53:invokevirtual   #75  <Method String StringBuilder.toString()>
                //   25   56:invokevirtual   #78  <Method void ViewerDialog.setTitle(String)>
                    int result = dialog.showDialog(m_CurrentInst);
                //   26   59:aload_2         
                //   27   60:aload_0         
                //   28   61:getfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                //   29   64:getfield        #82  <Field Instances ArffTable$RelationalCellEditor.m_CurrentInst>
                //   30   67:invokevirtual   #86  <Method int ViewerDialog.showDialog(Instances)>
                //   31   70:istore_3        
                    if(result == 0)
                //*  32   71:iload_3         
                //*  33   72:ifne            96
                    {
                        m_CurrentInst = dialog.getInstances();
                //   34   75:aload_0         
                //   35   76:getfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                //   36   79:aload_2         
                //   37   80:invokevirtual   #87  <Method Instances ViewerDialog.getInstances()>
                //   38   83:putfield        #82  <Field Instances ArffTable$RelationalCellEditor.m_CurrentInst>
                        fireEditingStopped();
                //   39   86:aload_0         
                //   40   87:getfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                //   41   90:invokestatic    #90  <Method void ArffTable$RelationalCellEditor.access$0(ArffTable$RelationalCellEditor)>
                    } else
                //*  42   93:goto            103
                    {
                        fireEditingCanceled();
                //   43   96:aload_0         
                //   44   97:getfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                //   45  100:invokestatic    #93  <Method void ArffTable$RelationalCellEditor.access$1(ArffTable$RelationalCellEditor)>
                    }
                //   46  103:return          
                }

                final RelationalCellEditor this$1;

                
                {
                    this$1 = RelationalCellEditor.this;
                //    0    0:aload_0         
                //    1    1:aload_1         
                //    2    2:putfield        #13  <Field ArffTable$RelationalCellEditor this$1>
                    super();
                //    3    5:aload_0         
                //    4    6:invokespecial   #16  <Method void Object()>
                //    5    9:return          
                }
            }
);
        //   23   42:aload_0         
        //   24   43:getfield        #47  <Field JButton m_Button>
        //   25   46:new             #49  <Class ArffTable$1>
        //   26   49:dup             
        //   27   50:aload_0         
        //   28   51:invokespecial   #52  <Method void ArffTable$1(ArffTable$RelationalCellEditor)>
        //   29   54:invokevirtual   #56  <Method void JButton.addActionListener(ActionListener)>
        //   30   57:return          
        }
    }


    public ArffTable()
    {
        this(((TableModel) (new ArffSortedTableModel(""))));
    //    0    0:aload_0         
    //    1    1:new             #18  <Class ArffSortedTableModel>
    //    2    4:dup             
    //    3    5:ldc1            #20  <String "">
    //    4    7:invokespecial   #23  <Method void ArffSortedTableModel(String)>
    //    5   10:invokespecial   #26  <Method void ArffTable(TableModel)>
    //    6   13:return          
    }

    public ArffTable(TableModel model)
    {
        super(model);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #31  <Method void JTable(TableModel)>
        setAutoResizeMode(0);
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:invokevirtual   #35  <Method void setAutoResizeMode(int)>
    //    6   10:return          
    }

    public void setModel(TableModel model)
    {
        m_SearchString = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #40  <Field String m_SearchString>
        if(m_ChangeListeners == null)
    //*   3    5:aload_0         
    //*   4    6:getfield        #42  <Field HashSet m_ChangeListeners>
    //*   5    9:ifnonnull       23
            m_ChangeListeners = new HashSet();
    //    6   12:aload_0         
    //    7   13:new             #44  <Class HashSet>
    //    8   16:dup             
    //    9   17:invokespecial   #46  <Method void HashSet()>
    //   10   20:putfield        #42  <Field HashSet m_ChangeListeners>
        super.setModel(model);
    //   11   23:aload_0         
    //   12   24:aload_1         
    //   13   25:invokespecial   #48  <Method void JTable.setModel(TableModel)>
        if(model == null)
    //*  14   28:aload_1         
    //*  15   29:ifnonnull       33
            return;
    //   16   32:return          
        if(!(model instanceof ArffSortedTableModel))
    //*  17   33:aload_1         
    //*  18   34:instanceof      #18  <Class ArffSortedTableModel>
    //*  19   37:ifne            41
            return;
    //   20   40:return          
        ArffSortedTableModel arffModel = (ArffSortedTableModel)model;
    //   21   41:aload_1         
    //   22   42:checkcast       #18  <Class ArffSortedTableModel>
    //   23   45:astore_2        
        arffModel.addMouseListenerToHeader(this);
    //   24   46:aload_2         
    //   25   47:aload_0         
    //   26   48:invokevirtual   #52  <Method void ArffSortedTableModel.addMouseListenerToHeader(JTable)>
        arffModel.addTableModelListener(this);
    //   27   51:aload_2         
    //   28   52:aload_0         
    //   29   53:invokevirtual   #56  <Method void ArffSortedTableModel.addTableModelListener(javax.swing.event.TableModelListener)>
        arffModel.sort(0);
    //   30   56:aload_2         
    //   31   57:iconst_0        
    //   32   58:invokevirtual   #59  <Method void ArffSortedTableModel.sort(int)>
        setLayout();
    //   33   61:aload_0         
    //   34   62:invokespecial   #62  <Method void setLayout()>
        setSelectedColumn(0);
    //   35   65:aload_0         
    //   36   66:iconst_0        
    //   37   67:invokevirtual   #65  <Method void setSelectedColumn(int)>
        if(getTableHeader() != null)
    //*  38   70:aload_0         
    //*  39   71:invokevirtual   #69  <Method JTableHeader getTableHeader()>
    //*  40   74:ifnull          85
            getTableHeader().setReorderingAllowed(false);
    //   41   77:aload_0         
    //   42   78:invokevirtual   #69  <Method JTableHeader getTableHeader()>
    //   43   81:iconst_0        
    //   44   82:invokevirtual   #75  <Method void JTableHeader.setReorderingAllowed(boolean)>
    //   45   85:return          
    }

    public TableCellEditor getCellEditor(int row, int column)
    {
        TableCellEditor result;
        if((getModel() instanceof ArffSortedTableModel) && ((ArffSortedTableModel)getModel()).getType(column) == 4)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #83  <Method TableModel getModel()>
    //*   2    4:instanceof      #18  <Class ArffSortedTableModel>
    //*   3    7:ifeq            39
    //*   4   10:aload_0         
    //*   5   11:invokevirtual   #83  <Method TableModel getModel()>
    //*   6   14:checkcast       #18  <Class ArffSortedTableModel>
    //*   7   17:iload_2         
    //*   8   18:invokevirtual   #87  <Method int ArffSortedTableModel.getType(int)>
    //*   9   21:iconst_4        
    //*  10   22:icmpne          39
            result = new RelationalCellEditor(row, column);
    //   11   25:new             #89  <Class ArffTable$RelationalCellEditor>
    //   12   28:dup             
    //   13   29:aload_0         
    //   14   30:iload_1         
    //   15   31:iload_2         
    //   16   32:invokespecial   #92  <Method void ArffTable$RelationalCellEditor(ArffTable, int, int)>
    //   17   35:astore_3        
        else
    //*  18   36:goto            46
            result = super.getCellEditor(row, column);
    //   19   39:aload_0         
    //   20   40:iload_1         
    //   21   41:iload_2         
    //   22   42:invokespecial   #94  <Method TableCellEditor JTable.getCellEditor(int, int)>
    //   23   45:astore_3        
        return result;
    //   24   46:aload_3         
    //   25   47:areturn         
    }

    public boolean isReadOnly()
    {
        return ((ArffSortedTableModel)getModel()).isReadOnly();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #83  <Method TableModel getModel()>
    //    2    4:checkcast       #18  <Class ArffSortedTableModel>
    //    3    7:invokevirtual   #103 <Method boolean ArffSortedTableModel.isReadOnly()>
    //    4   10:ireturn         
    }

    public void setReadOnly(boolean value)
    {
        ((ArffSortedTableModel)getModel()).setReadOnly(value);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #83  <Method TableModel getModel()>
    //    2    4:checkcast       #18  <Class ArffSortedTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #106 <Method void ArffSortedTableModel.setReadOnly(boolean)>
    //    5   11:return          
    }

    private void setLayout()
    {
        ArffSortedTableModel arffModel = (ArffSortedTableModel)getModel();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #83  <Method TableModel getModel()>
    //    2    4:checkcast       #18  <Class ArffSortedTableModel>
    //    3    7:astore_1        
        for(int i = 0; i < getColumnCount(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            144
        {
            JTableHelper.setOptimalHeaderWidth(this, i);
    //    7   13:aload_0         
    //    8   14:iload_2         
    //    9   15:invokestatic    #114 <Method void JTableHelper.setOptimalHeaderWidth(JTable, int)>
            getColumnModel().getColumn(i).setCellRenderer(new ArffTableCellRenderer());
    //   10   18:aload_0         
    //   11   19:invokevirtual   #118 <Method TableColumnModel getColumnModel()>
    //   12   22:iload_2         
    //   13   23:invokeinterface #124 <Method TableColumn TableColumnModel.getColumn(int)>
    //   14   28:new             #126 <Class ArffTableCellRenderer>
    //   15   31:dup             
    //   16   32:invokespecial   #127 <Method void ArffTableCellRenderer()>
    //   17   35:invokevirtual   #133 <Method void TableColumn.setCellRenderer(javax.swing.table.TableCellRenderer)>
            if(i > 0)
    //*  18   38:iload_2         
    //*  19   39:ifle            141
                if(arffModel.getType(i) == 1)
    //*  20   42:aload_1         
    //*  21   43:iload_2         
    //*  22   44:invokevirtual   #87  <Method int ArffSortedTableModel.getType(int)>
    //*  23   47:iconst_1        
    //*  24   48:icmpne          127
                {
                    JComboBox combo = new JComboBox();
    //   25   51:new             #135 <Class JComboBox>
    //   26   54:dup             
    //   27   55:invokespecial   #136 <Method void JComboBox()>
    //   28   58:astore_3        
                    combo.addItem(null);
    //   29   59:aload_3         
    //   30   60:aconst_null     
    //   31   61:invokevirtual   #140 <Method void JComboBox.addItem(Object)>
                    for(Enumeration enm = arffModel.getInstances().attribute(i - 1).enumerateValues(); enm.hasMoreElements(); combo.addItem(enm.nextElement()));
    //   32   64:aload_1         
    //   33   65:invokevirtual   #144 <Method Instances ArffSortedTableModel.getInstances()>
    //   34   68:iload_2         
    //   35   69:iconst_1        
    //   36   70:isub            
    //   37   71:invokevirtual   #150 <Method Attribute Instances.attribute(int)>
    //   38   74:invokevirtual   #156 <Method Enumeration Attribute.enumerateValues()>
    //   39   77:astore          4
    //   40   79:goto            93
    //   41   82:aload_3         
    //   42   83:aload           4
    //   43   85:invokeinterface #162 <Method Object Enumeration.nextElement()>
    //   44   90:invokevirtual   #140 <Method void JComboBox.addItem(Object)>
    //   45   93:aload           4
    //   46   95:invokeinterface #165 <Method boolean Enumeration.hasMoreElements()>
    //   47  100:ifne            82
                    getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(combo));
    //   48  103:aload_0         
    //   49  104:invokevirtual   #118 <Method TableColumnModel getColumnModel()>
    //   50  107:iload_2         
    //   51  108:invokeinterface #124 <Method TableColumn TableColumnModel.getColumn(int)>
    //   52  113:new             #167 <Class DefaultCellEditor>
    //   53  116:dup             
    //   54  117:aload_3         
    //   55  118:invokespecial   #170 <Method void DefaultCellEditor(JComboBox)>
    //   56  121:invokevirtual   #174 <Method void TableColumn.setCellEditor(TableCellEditor)>
                } else
    //*  57  124:goto            141
                {
                    getColumnModel().getColumn(i).setCellEditor(null);
    //   58  127:aload_0         
    //   59  128:invokevirtual   #118 <Method TableColumnModel getColumnModel()>
    //   60  131:iload_2         
    //   61  132:invokeinterface #124 <Method TableColumn TableColumnModel.getColumn(int)>
    //   62  137:aconst_null     
    //   63  138:invokevirtual   #174 <Method void TableColumn.setCellEditor(TableCellEditor)>
                }
        }

    //   64  141:iinc            2  1
    //   65  144:iload_2         
    //   66  145:aload_0         
    //   67  146:invokevirtual   #178 <Method int getColumnCount()>
    //   68  149:icmplt          13
    //   69  152:return          
    }

    public String getPlainColumnName(int columnIndex)
    {
        String result = "";
    //    0    0:ldc1            #20  <String "">
    //    1    2:astore_3        
        if(getModel() == null)
    //*   2    3:aload_0         
    //*   3    4:invokevirtual   #83  <Method TableModel getModel()>
    //*   4    7:ifnonnull       12
            return result;
    //    5   10:aload_3         
    //    6   11:areturn         
        if(!(getModel() instanceof ArffSortedTableModel))
    //*   7   12:aload_0         
    //*   8   13:invokevirtual   #83  <Method TableModel getModel()>
    //*   9   16:instanceof      #18  <Class ArffSortedTableModel>
    //*  10   19:ifne            24
            return result;
    //   11   22:aload_3         
    //   12   23:areturn         
        ArffSortedTableModel arffModel = (ArffSortedTableModel)getModel();
    //   13   24:aload_0         
    //   14   25:invokevirtual   #83  <Method TableModel getModel()>
    //   15   28:checkcast       #18  <Class ArffSortedTableModel>
    //   16   31:astore_2        
        if(columnIndex >= 0 && columnIndex < getColumnCount())
    //*  17   32:iload_1         
    //*  18   33:iflt            63
    //*  19   36:iload_1         
    //*  20   37:aload_0         
    //*  21   38:invokevirtual   #178 <Method int getColumnCount()>
    //*  22   41:icmpge          63
            if(columnIndex == 0)
    //*  23   44:iload_1         
    //*  24   45:ifne            54
                result = "No.";
    //   25   48:ldc1            #187 <String "No.">
    //   26   50:astore_3        
            else
    //*  27   51:goto            63
                result = arffModel.getAttributeAt(columnIndex).name();
    //   28   54:aload_2         
    //   29   55:iload_1         
    //   30   56:invokevirtual   #190 <Method Attribute ArffSortedTableModel.getAttributeAt(int)>
    //   31   59:invokevirtual   #194 <Method String Attribute.name()>
    //   32   62:astore_3        
        return result;
    //   33   63:aload_3         
    //   34   64:areturn         
    }

    public StringSelection getStringSelection()
    {
        StringSelection result = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        int indices[];
        if(getSelectedRow() == -1)
    //*   2    2:aload_0         
    //*   3    3:invokevirtual   #200 <Method int getSelectedRow()>
    //*   4    6:iconst_m1       
    //*   5    7:icmpne          56
        {
            if(ComponentHelper.showMessageBox(getParent(), "Question...", "Do you really want to copy the whole table?", 0, 3) != 0)
    //*   6   10:aload_0         
    //*   7   11:invokevirtual   #204 <Method java.awt.Container getParent()>
    //*   8   14:ldc1            #206 <String "Question...">
    //*   9   16:ldc1            #208 <String "Do you really want to copy the whole table?">
    //*  10   18:iconst_0        
    //*  11   19:iconst_3        
    //*  12   20:invokestatic    #214 <Method int ComponentHelper.showMessageBox(Component, String, String, int, int)>
    //*  13   23:ifeq            28
                return result;
    //   14   26:aload_1         
    //   15   27:areturn         
            indices = new int[getRowCount()];
    //   16   28:aload_0         
    //   17   29:invokevirtual   #217 <Method int getRowCount()>
    //   18   32:newarray        int[]
    //   19   34:astore_2        
            for(int i = 0; i < indices.length; i++)
    //*  20   35:iconst_0        
    //*  21   36:istore_3        
    //*  22   37:goto            47
                indices[i] = i;
    //   23   40:aload_2         
    //   24   41:iload_3         
    //   25   42:iload_3         
    //   26   43:iastore         

    //   27   44:iinc            3  1
    //   28   47:iload_3         
    //   29   48:aload_2         
    //   30   49:arraylength     
    //   31   50:icmplt          40
        } else
    //*  32   53:goto            61
        {
            indices = getSelectedRows();
    //   33   56:aload_0         
    //   34   57:invokevirtual   #221 <Method int[] getSelectedRows()>
    //   35   60:astore_2        
        }
        StringBuffer tmp = new StringBuffer();
    //   36   61:new             #223 <Class StringBuffer>
    //   37   64:dup             
    //   38   65:invokespecial   #224 <Method void StringBuffer()>
    //   39   68:astore          5
        for(int i = 0; i < getColumnCount(); i++)
    //*  40   70:iconst_0        
    //*  41   71:istore_3        
    //*  42   72:goto            101
        {
            if(i > 0)
    //*  43   75:iload_3         
    //*  44   76:ifle            87
                tmp.append("\t");
    //   45   79:aload           5
    //   46   81:ldc1            #226 <String "\t">
    //   47   83:invokevirtual   #230 <Method StringBuffer StringBuffer.append(String)>
    //   48   86:pop             
            tmp.append(getPlainColumnName(i));
    //   49   87:aload           5
    //   50   89:aload_0         
    //   51   90:iload_3         
    //   52   91:invokevirtual   #232 <Method String getPlainColumnName(int)>
    //   53   94:invokevirtual   #230 <Method StringBuffer StringBuffer.append(String)>
    //   54   97:pop             
        }

    //   55   98:iinc            3  1
    //   56  101:iload_3         
    //   57  102:aload_0         
    //   58  103:invokevirtual   #178 <Method int getColumnCount()>
    //   59  106:icmplt          75
        tmp.append("\n");
    //   60  109:aload           5
    //   61  111:ldc1            #234 <String "\n">
    //   62  113:invokevirtual   #230 <Method StringBuffer StringBuffer.append(String)>
    //   63  116:pop             
        for(int i = 0; i < indices.length; i++)
    //*  64  117:iconst_0        
    //*  65  118:istore_3        
    //*  66  119:goto            182
        {
            for(int n = 0; n < getColumnCount(); n++)
    //*  67  122:iconst_0        
    //*  68  123:istore          4
    //*  69  125:goto            162
            {
                if(n > 0)
    //*  70  128:iload           4
    //*  71  130:ifle            141
                    tmp.append("\t");
    //   72  133:aload           5
    //   73  135:ldc1            #226 <String "\t">
    //   74  137:invokevirtual   #230 <Method StringBuffer StringBuffer.append(String)>
    //   75  140:pop             
                tmp.append(getValueAt(indices[i], n).toString());
    //   76  141:aload           5
    //   77  143:aload_0         
    //   78  144:aload_2         
    //   79  145:iload_3         
    //   80  146:iaload          
    //   81  147:iload           4
    //   82  149:invokevirtual   #238 <Method Object getValueAt(int, int)>
    //   83  152:invokevirtual   #243 <Method String Object.toString()>
    //   84  155:invokevirtual   #230 <Method StringBuffer StringBuffer.append(String)>
    //   85  158:pop             
            }

    //   86  159:iinc            4  1
    //   87  162:iload           4
    //   88  164:aload_0         
    //   89  165:invokevirtual   #178 <Method int getColumnCount()>
    //   90  168:icmplt          128
            tmp.append("\n");
    //   91  171:aload           5
    //   92  173:ldc1            #234 <String "\n">
    //   93  175:invokevirtual   #230 <Method StringBuffer StringBuffer.append(String)>
    //   94  178:pop             
        }

    //   95  179:iinc            3  1
    //   96  182:iload_3         
    //   97  183:aload_2         
    //   98  184:arraylength     
    //   99  185:icmplt          122
        result = new StringSelection(tmp.toString());
    //  100  188:new             #245 <Class StringSelection>
    //  101  191:dup             
    //  102  192:aload           5
    //  103  194:invokevirtual   #246 <Method String StringBuffer.toString()>
    //  104  197:invokespecial   #247 <Method void StringSelection(String)>
    //  105  200:astore_1        
        return result;
    //  106  201:aload_1         
    //  107  202:areturn         
    }

    public void setSearchString(String searchString)
    {
        m_SearchString = searchString;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #40  <Field String m_SearchString>
        repaint();
    //    3    5:aload_0         
    //    4    6:invokevirtual   #257 <Method void repaint()>
    //    5    9:return          
    }

    public String getSearchString()
    {
        return m_SearchString;
    //    0    0:aload_0         
    //    1    1:getfield        #40  <Field String m_SearchString>
    //    2    4:areturn         
    }

    public void setSelectedColumn(int index)
    {
        getColumnModel().getSelectionModel().clearSelection();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #118 <Method TableColumnModel getColumnModel()>
    //    2    4:invokeinterface #263 <Method ListSelectionModel TableColumnModel.getSelectionModel()>
    //    3    9:invokeinterface #268 <Method void ListSelectionModel.clearSelection()>
        getColumnModel().getSelectionModel().setSelectionInterval(index, index);
    //    4   14:aload_0         
    //    5   15:invokevirtual   #118 <Method TableColumnModel getColumnModel()>
    //    6   18:invokeinterface #263 <Method ListSelectionModel TableColumnModel.getSelectionModel()>
    //    7   23:iload_1         
    //    8   24:iload_1         
    //    9   25:invokeinterface #272 <Method void ListSelectionModel.setSelectionInterval(int, int)>
        resizeAndRepaint();
    //   10   30:aload_0         
    //   11   31:invokevirtual   #275 <Method void resizeAndRepaint()>
        if(getTableHeader() != null)
    //*  12   34:aload_0         
    //*  13   35:invokevirtual   #69  <Method JTableHeader getTableHeader()>
    //*  14   38:ifnull          48
            getTableHeader().resizeAndRepaint();
    //   15   41:aload_0         
    //   16   42:invokevirtual   #69  <Method JTableHeader getTableHeader()>
    //   17   45:invokevirtual   #276 <Method void JTableHeader.resizeAndRepaint()>
    //   18   48:return          
    }

    public void tableChanged(TableModelEvent e)
    {
        super.tableChanged(e);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #281 <Method void JTable.tableChanged(TableModelEvent)>
        setLayout();
    //    3    5:aload_0         
    //    4    6:invokespecial   #62  <Method void setLayout()>
        notifyListener();
    //    5    9:aload_0         
    //    6   10:invokespecial   #284 <Method void notifyListener()>
    //    7   13:return          
    }

    private void notifyListener()
    {
        for(Iterator iter = m_ChangeListeners.iterator(); iter.hasNext(); ((ChangeListener)(ChangeListener)iter.next()).stateChanged(new ChangeEvent(this)));
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field HashSet m_ChangeListeners>
    //    2    4:invokevirtual   #290 <Method Iterator HashSet.iterator()>
    //    3    7:astore_1        
    //    4    8:goto            36
    //    5   11:aload_1         
    //    6   12:invokeinterface #295 <Method Object Iterator.next()>
    //    7   17:checkcast       #297 <Class ChangeListener>
    //    8   20:checkcast       #297 <Class ChangeListener>
    //    9   23:new             #299 <Class ChangeEvent>
    //   10   26:dup             
    //   11   27:aload_0         
    //   12   28:invokespecial   #301 <Method void ChangeEvent(Object)>
    //   13   31:invokeinterface #305 <Method void ChangeListener.stateChanged(ChangeEvent)>
    //   14   36:aload_1         
    //   15   37:invokeinterface #308 <Method boolean Iterator.hasNext()>
    //   16   42:ifne            11
    //   17   45:return          
    }

    public void addChangeListener(ChangeListener l)
    {
        m_ChangeListeners.add(l);
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field HashSet m_ChangeListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #316 <Method boolean HashSet.add(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    public void removeChangeListener(ChangeListener l)
    {
        m_ChangeListeners.remove(l);
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field HashSet m_ChangeListeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #322 <Method boolean HashSet.remove(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    static final long serialVersionUID = 0xe40504523dbf84f1L;
    private String m_SearchString;
    private HashSet m_ChangeListeners;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   SortedTableModel.java

package rm.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import rm.core.ClassDiscovery;

public class SortedTableModel extends AbstractTableModel
    implements TableModelListener
{
    public static class SortContainer
        implements Comparable
    {

        public Comparable getValue()
        {
            return m_Value;
        //    0    0:aload_0         
        //    1    1:getfield        #18  <Field Comparable m_Value>
        //    2    4:areturn         
        }

        public int getIndex()
        {
            return m_Index;
        //    0    0:aload_0         
        //    1    1:getfield        #20  <Field int m_Index>
        //    2    4:ireturn         
        }

        public int compareTo(SortContainer o)
        {
            if(m_Value == null || o.getValue() == null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #18  <Field Comparable m_Value>
        //*   2    4:ifnull          14
        //*   3    7:aload_1         
        //*   4    8:invokevirtual   #34  <Method Comparable getValue()>
        //*   5   11:ifnonnull       38
            {
                if(m_Value == o.getValue())
        //*   6   14:aload_0         
        //*   7   15:getfield        #18  <Field Comparable m_Value>
        //*   8   18:aload_1         
        //*   9   19:invokevirtual   #34  <Method Comparable getValue()>
        //*  10   22:if_acmpne       27
                    return 0;
        //   11   25:iconst_0        
        //   12   26:ireturn         
                return m_Value != null ? 1 : -1;
        //   13   27:aload_0         
        //   14   28:getfield        #18  <Field Comparable m_Value>
        //   15   31:ifnonnull       36
        //   16   34:iconst_m1       
        //   17   35:ireturn         
        //   18   36:iconst_1        
        //   19   37:ireturn         
            } else
            {
                return m_Value.compareTo(o.getValue());
        //   20   38:aload_0         
        //   21   39:getfield        #18  <Field Comparable m_Value>
        //   22   42:aload_1         
        //   23   43:invokevirtual   #34  <Method Comparable getValue()>
        //   24   46:invokeinterface #37  <Method int Comparable.compareTo(Object)>
        //   25   51:ireturn         
            }
        }

        public boolean equals(Object obj)
        {
            return compareTo((SortContainer)obj) == 0;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:checkcast       #2   <Class SortedTableModel$SortContainer>
        //    3    5:invokevirtual   #42  <Method int compareTo(SortedTableModel$SortContainer)>
        //    4    8:ifne            13
        //    5   11:iconst_1        
        //    6   12:ireturn         
        //    7   13:iconst_0        
        //    8   14:ireturn         
        }

        public String toString()
        {
            return (new StringBuilder("value=")).append(m_Value).append(", index=").append(m_Index).toString();
        //    0    0:new             #48  <Class StringBuilder>
        //    1    3:dup             
        //    2    4:ldc1            #50  <String "value=">
        //    3    6:invokespecial   #53  <Method void StringBuilder(String)>
        //    4    9:aload_0         
        //    5   10:getfield        #18  <Field Comparable m_Value>
        //    6   13:invokevirtual   #57  <Method StringBuilder StringBuilder.append(Object)>
        //    7   16:ldc1            #59  <String ", index=">
        //    8   18:invokevirtual   #62  <Method StringBuilder StringBuilder.append(String)>
        //    9   21:aload_0         
        //   10   22:getfield        #20  <Field int m_Index>
        //   11   25:invokevirtual   #65  <Method StringBuilder StringBuilder.append(int)>
        //   12   28:invokevirtual   #67  <Method String StringBuilder.toString()>
        //   13   31:areturn         
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((SortContainer)obj);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:checkcast       #2   <Class SortedTableModel$SortContainer>
        //    3    5:invokevirtual   #42  <Method int compareTo(SortedTableModel$SortContainer)>
        //    4    8:ireturn         
        }

        protected Comparable m_Value;
        protected int m_Index;

        public SortContainer(Comparable value, int index)
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #16  <Method void Object()>
            m_Value = value;
        //    2    4:aload_0         
        //    3    5:aload_1         
        //    4    6:putfield        #18  <Field Comparable m_Value>
            m_Index = index;
        //    5    9:aload_0         
        //    6   10:iload_2         
        //    7   11:putfield        #20  <Field int m_Index>
        //    8   14:return          
        }
    }


    public SortedTableModel()
    {
        this(null);
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:invokespecial   #27  <Method void SortedTableModel(TableModel)>
    //    3    5:return          
    }

    public SortedTableModel(TableModel model)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #33  <Method void AbstractTableModel()>
        setModel(model);
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #36  <Method void setModel(TableModel)>
    //    5    9:return          
    }

    public void setModel(TableModel value)
    {
        mModel = value;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #39  <Field TableModel mModel>
        if(mModel == null)
    //*   3    5:aload_0         
    //*   4    6:getfield        #39  <Field TableModel mModel>
    //*   5    9:ifnonnull       20
        {
            mIndices = null;
    //    6   12:aload_0         
    //    7   13:aconst_null     
    //    8   14:putfield        #41  <Field int[] mIndices>
        } else
    //*   9   17:goto            44
        {
            initializeIndices();
    //   10   20:aload_0         
    //   11   21:invokevirtual   #44  <Method void initializeIndices()>
            mSortColumn = -1;
    //   12   24:aload_0         
    //   13   25:iconst_m1       
    //   14   26:putfield        #46  <Field int mSortColumn>
            mAscending = true;
    //   15   29:aload_0         
    //   16   30:iconst_1        
    //   17   31:putfield        #48  <Field boolean mAscending>
            mModel.addTableModelListener(this);
    //   18   34:aload_0         
    //   19   35:getfield        #39  <Field TableModel mModel>
    //   20   38:aload_0         
    //   21   39:invokeinterface #54  <Method void TableModel.addTableModelListener(TableModelListener)>
        }
    //   22   44:return          
    }

    protected void initializeIndices()
    {
        mIndices = new int[mModel.getRowCount()];
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #39  <Field TableModel mModel>
    //    3    5:invokeinterface #59  <Method int TableModel.getRowCount()>
    //    4   10:newarray        int[]
    //    5   12:putfield        #41  <Field int[] mIndices>
        for(int i = 0; i < mIndices.length; i++)
    //*   6   15:iconst_0        
    //*   7   16:istore_1        
    //*   8   17:goto            30
            mIndices[i] = i;
    //    9   20:aload_0         
    //   10   21:getfield        #41  <Field int[] mIndices>
    //   11   24:iload_1         
    //   12   25:iload_1         
    //   13   26:iastore         

    //   14   27:iinc            1  1
    //   15   30:iload_1         
    //   16   31:aload_0         
    //   17   32:getfield        #41  <Field int[] mIndices>
    //   18   35:arraylength     
    //   19   36:icmplt          20
    //   20   39:return          
    }

    public TableModel getModel()
    {
        return mModel;
    //    0    0:aload_0         
    //    1    1:getfield        #39  <Field TableModel mModel>
    //    2    4:areturn         
    }

    public boolean isSorted()
    {
        return mSortColumn > -1;
    //    0    0:aload_0         
    //    1    1:getfield        #46  <Field int mSortColumn>
    //    2    4:iconst_m1       
    //    3    5:icmple          10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    protected boolean isInitialized()
    {
        return getModel() != null;
    //    0    0:aload_0         
    //    1    1:invokevirtual   #67  <Method TableModel getModel()>
    //    2    4:ifnull          9
    //    3    7:iconst_1        
    //    4    8:ireturn         
    //    5    9:iconst_0        
    //    6   10:ireturn         
    }

    public int getActualRow(int visibleRow)
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return -1;
    //    3    7:iconst_m1       
    //    4    8:ireturn         
        else
            return mIndices[visibleRow];
    //    5    9:aload_0         
    //    6   10:getfield        #41  <Field int[] mIndices>
    //    7   13:iload_1         
    //    8   14:iaload          
    //    9   15:ireturn         
    }

    public Class getColumnClass(int columnIndex)
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return null;
    //    3    7:aconst_null     
    //    4    8:areturn         
        else
            return getModel().getColumnClass(columnIndex);
    //    5    9:aload_0         
    //    6   10:invokevirtual   #67  <Method TableModel getModel()>
    //    7   13:iload_1         
    //    8   14:invokeinterface #76  <Method Class TableModel.getColumnClass(int)>
    //    9   19:areturn         
    }

    public int getColumnCount()
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return 0;
    //    3    7:iconst_0        
    //    4    8:ireturn         
        else
            return getModel().getColumnCount();
    //    5    9:aload_0         
    //    6   10:invokevirtual   #67  <Method TableModel getModel()>
    //    7   13:invokeinterface #80  <Method int TableModel.getColumnCount()>
    //    8   18:ireturn         
    }

    public String getColumnName(int columnIndex)
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return null;
    //    3    7:aconst_null     
    //    4    8:areturn         
        else
            return getModel().getColumnName(columnIndex);
    //    5    9:aload_0         
    //    6   10:invokevirtual   #67  <Method TableModel getModel()>
    //    7   13:iload_1         
    //    8   14:invokeinterface #84  <Method String TableModel.getColumnName(int)>
    //    9   19:areturn         
    }

    public int getRowCount()
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return 0;
    //    3    7:iconst_0        
    //    4    8:ireturn         
        else
            return getModel().getRowCount();
    //    5    9:aload_0         
    //    6   10:invokevirtual   #67  <Method TableModel getModel()>
    //    7   13:invokeinterface #59  <Method int TableModel.getRowCount()>
    //    8   18:ireturn         
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return null;
    //    3    7:aconst_null     
    //    4    8:areturn         
        else
            return getModel().getValueAt(mIndices[rowIndex], columnIndex);
    //    5    9:aload_0         
    //    6   10:invokevirtual   #67  <Method TableModel getModel()>
    //    7   13:aload_0         
    //    8   14:getfield        #41  <Field int[] mIndices>
    //    9   17:iload_1         
    //   10   18:iaload          
    //   11   19:iload_2         
    //   12   20:invokeinterface #88  <Method Object TableModel.getValueAt(int, int)>
    //   13   25:areturn         
    }

    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if(!isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifne            9
            return false;
    //    3    7:iconst_0        
    //    4    8:ireturn         
        else
            return getModel().isCellEditable(mIndices[rowIndex], columnIndex);
    //    5    9:aload_0         
    //    6   10:invokevirtual   #67  <Method TableModel getModel()>
    //    7   13:aload_0         
    //    8   14:getfield        #41  <Field int[] mIndices>
    //    9   17:iload_1         
    //   10   18:iaload          
    //   11   19:iload_2         
    //   12   20:invokeinterface #93  <Method boolean TableModel.isCellEditable(int, int)>
    //   13   25:ireturn         
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        if(isInitialized())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifeq            24
            getModel().setValueAt(aValue, mIndices[rowIndex], columnIndex);
    //    3    7:aload_0         
    //    4    8:invokevirtual   #67  <Method TableModel getModel()>
    //    5   11:aload_1         
    //    6   12:aload_0         
    //    7   13:getfield        #41  <Field int[] mIndices>
    //    8   16:iload_2         
    //    9   17:iaload          
    //   10   18:iload_3         
    //   11   19:invokeinterface #97  <Method void TableModel.setValueAt(Object, int, int)>
    //   12   24:return          
    }

    public void sort(int columnIndex)
    {
        sort(columnIndex, true);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:iconst_1        
    //    3    3:invokevirtual   #104 <Method void sort(int, boolean)>
    //    4    6:return          
    }

    public void sort(int columnIndex, boolean ascending)
    {
        if(!isInitialized() || getModel().getRowCount() != mIndices.length)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #71  <Method boolean isInitialized()>
    //*   2    4:ifeq            24
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #67  <Method TableModel getModel()>
    //*   5   11:invokeinterface #59  <Method int TableModel.getRowCount()>
    //*   6   16:aload_0         
    //*   7   17:getfield        #41  <Field int[] mIndices>
    //*   8   20:arraylength     
    //*   9   21:icmpeq          56
        {
            System.out.println((new StringBuilder(String.valueOf(getClass().getName()))).append(": Table model not initialized!").toString());
    //   10   24:getstatic       #110 <Field PrintStream System.out>
    //   11   27:new             #112 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:aload_0         
    //   14   32:invokevirtual   #118 <Method Class Object.getClass()>
    //   15   35:invokevirtual   #124 <Method String Class.getName()>
    //   16   38:invokestatic    #130 <Method String String.valueOf(Object)>
    //   17   41:invokespecial   #133 <Method void StringBuilder(String)>
    //   18   44:ldc1            #135 <String ": Table model not initialized!">
    //   19   46:invokevirtual   #139 <Method StringBuilder StringBuilder.append(String)>
    //   20   49:invokevirtual   #142 <Method String StringBuilder.toString()>
    //   21   52:invokevirtual   #147 <Method void PrintStream.println(String)>
            return;
    //   22   55:return          
        }
        mSortColumn = columnIndex;
    //   23   56:aload_0         
    //   24   57:iload_1         
    //   25   58:putfield        #46  <Field int mSortColumn>
        mAscending = ascending;
    //   26   61:aload_0         
    //   27   62:iload_2         
    //   28   63:putfield        #48  <Field boolean mAscending>
        initializeIndices();
    //   29   66:aload_0         
    //   30   67:invokevirtual   #44  <Method void initializeIndices()>
        int columnType;
        if(ClassDiscovery.hasInterface(java/lang/Comparable, getColumnClass(mSortColumn)))
    //*  31   70:ldc1            #149 <Class Comparable>
    //*  32   72:aload_0         
    //*  33   73:aload_0         
    //*  34   74:getfield        #46  <Field int mSortColumn>
    //*  35   77:invokevirtual   #150 <Method Class getColumnClass(int)>
    //*  36   80:invokestatic    #156 <Method boolean ClassDiscovery.hasInterface(Class, Class)>
    //*  37   83:ifeq            91
            columnType = 1;
    //   38   86:iconst_1        
    //   39   87:istore_3        
        else
    //*  40   88:goto            93
            columnType = 0;
    //   41   91:iconst_0        
    //   42   92:istore_3        
        ArrayList sorted = new ArrayList();
    //   43   93:new             #158 <Class ArrayList>
    //   44   96:dup             
    //   45   97:invokespecial   #159 <Method void ArrayList()>
    //   46  100:astore          5
        for(int i = 0; i < getRowCount(); i++)
    //*  47  102:iconst_0        
    //*  48  103:istore          4
    //*  49  105:goto            199
        {
            Object value = mModel.getValueAt(mIndices[i], mSortColumn);
    //   50  108:aload_0         
    //   51  109:getfield        #39  <Field TableModel mModel>
    //   52  112:aload_0         
    //   53  113:getfield        #41  <Field int[] mIndices>
    //   54  116:iload           4
    //   55  118:iaload          
    //   56  119:aload_0         
    //   57  120:getfield        #46  <Field int mSortColumn>
    //   58  123:invokeinterface #88  <Method Object TableModel.getValueAt(int, int)>
    //   59  128:astore          7
            SortContainer cont;
            if(columnType == 0)
    //*  60  130:iload_3         
    //*  61  131:ifne            167
                cont = new SortContainer(value != null ? ((Comparable) (value.toString())) : null, mIndices[i]);
    //   62  134:new             #161 <Class SortedTableModel$SortContainer>
    //   63  137:dup             
    //   64  138:aload           7
    //   65  140:ifnonnull       147
    //   66  143:aconst_null     
    //   67  144:goto            152
    //   68  147:aload           7
    //   69  149:invokevirtual   #162 <Method String Object.toString()>
    //   70  152:aload_0         
    //   71  153:getfield        #41  <Field int[] mIndices>
    //   72  156:iload           4
    //   73  158:iaload          
    //   74  159:invokespecial   #165 <Method void SortedTableModel$SortContainer(Comparable, int)>
    //   75  162:astore          6
            else
    //*  76  164:goto            188
                cont = new SortContainer((Comparable)value, mIndices[i]);
    //   77  167:new             #161 <Class SortedTableModel$SortContainer>
    //   78  170:dup             
    //   79  171:aload           7
    //   80  173:checkcast       #149 <Class Comparable>
    //   81  176:aload_0         
    //   82  177:getfield        #41  <Field int[] mIndices>
    //   83  180:iload           4
    //   84  182:iaload          
    //   85  183:invokespecial   #165 <Method void SortedTableModel$SortContainer(Comparable, int)>
    //   86  186:astore          6
            sorted.add(cont);
    //   87  188:aload           5
    //   88  190:aload           6
    //   89  192:invokevirtual   #169 <Method boolean ArrayList.add(Object)>
    //   90  195:pop             
        }

    //   91  196:iinc            4  1
    //   92  199:iload           4
    //   93  201:aload_0         
    //   94  202:invokevirtual   #170 <Method int getRowCount()>
    //   95  205:icmplt          108
        Collections.sort(sorted);
    //   96  208:aload           5
    //   97  210:invokestatic    #175 <Method void Collections.sort(java.util.List)>
        for(int i = 0; i < sorted.size(); i++)
    //*  98  213:iconst_0        
    //*  99  214:istore          4
    //* 100  216:goto            280
            if(mAscending)
    //* 101  219:aload_0         
    //* 102  220:getfield        #48  <Field boolean mAscending>
    //* 103  223:ifeq            249
                mIndices[i] = ((SortContainer)sorted.get(i)).getIndex();
    //  104  226:aload_0         
    //  105  227:getfield        #41  <Field int[] mIndices>
    //  106  230:iload           4
    //  107  232:aload           5
    //  108  234:iload           4
    //  109  236:invokevirtual   #179 <Method Object ArrayList.get(int)>
    //  110  239:checkcast       #161 <Class SortedTableModel$SortContainer>
    //  111  242:invokevirtual   #182 <Method int SortedTableModel$SortContainer.getIndex()>
    //  112  245:iastore         
            else
    //* 113  246:goto            277
                mIndices[i] = ((SortContainer)sorted.get(sorted.size() - 1 - i)).getIndex();
    //  114  249:aload_0         
    //  115  250:getfield        #41  <Field int[] mIndices>
    //  116  253:iload           4
    //  117  255:aload           5
    //  118  257:aload           5
    //  119  259:invokevirtual   #185 <Method int ArrayList.size()>
    //  120  262:iconst_1        
    //  121  263:isub            
    //  122  264:iload           4
    //  123  266:isub            
    //  124  267:invokevirtual   #179 <Method Object ArrayList.get(int)>
    //  125  270:checkcast       #161 <Class SortedTableModel$SortContainer>
    //  126  273:invokevirtual   #182 <Method int SortedTableModel$SortContainer.getIndex()>
    //  127  276:iastore         

    //  128  277:iinc            4  1
    //  129  280:iload           4
    //  130  282:aload           5
    //  131  284:invokevirtual   #185 <Method int ArrayList.size()>
    //  132  287:icmplt          219
        sorted.clear();
    //  133  290:aload           5
    //  134  292:invokevirtual   #188 <Method void ArrayList.clear()>
        sorted = null;
    //  135  295:aconst_null     
    //  136  296:astore          5
    //  137  298:return          
    }

    public void tableChanged(TableModelEvent e)
    {
        initializeIndices();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #44  <Method void initializeIndices()>
        if(isSorted())
    //*   2    4:aload_0         
    //*   3    5:invokevirtual   #200 <Method boolean isSorted()>
    //*   4    8:ifeq            23
            sort(mSortColumn, mAscending);
    //    5   11:aload_0         
    //    6   12:aload_0         
    //    7   13:getfield        #46  <Field int mSortColumn>
    //    8   16:aload_0         
    //    9   17:getfield        #48  <Field boolean mAscending>
    //   10   20:invokevirtual   #104 <Method void sort(int, boolean)>
        fireTableChanged(e);
    //   11   23:aload_0         
    //   12   24:aload_1         
    //   13   25:invokevirtual   #203 <Method void fireTableChanged(TableModelEvent)>
    //   14   28:return          
    }

    public void addMouseListenerToHeader(JTable table)
    {
        final SortedTableModel modelFinal = this;
    //    0    0:aload_0         
    //    1    1:astore_2        
        final JTable tableFinal = table;
    //    2    2:aload_1         
    //    3    3:astore_3        
        tableFinal.setColumnSelectionAllowed(false);
    //    4    4:aload_3         
    //    5    5:iconst_0        
    //    6    6:invokevirtual   #213 <Method void JTable.setColumnSelectionAllowed(boolean)>
        JTableHeader header = tableFinal.getTableHeader();
    //    7    9:aload_3         
    //    8   10:invokevirtual   #217 <Method JTableHeader JTable.getTableHeader()>
    //    9   13:astore          4
        if(header != null)
    //*  10   15:aload           4
    //*  11   17:ifnull          39
        {
            MouseAdapter listMouseListener = new MouseAdapter() {

                public void mouseClicked(MouseEvent e)
                {
                    TableColumnModel columnModel = tableFinal.getColumnModel();
                //    0    0:aload_0         
                //    1    1:getfield        #16  <Field JTable val$tableFinal>
                //    2    4:invokevirtual   #33  <Method TableColumnModel JTable.getColumnModel()>
                //    3    7:astore_2        
                    int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                //    4    8:aload_2         
                //    5    9:aload_1         
                //    6   10:invokevirtual   #39  <Method int MouseEvent.getX()>
                //    7   13:invokeinterface #45  <Method int TableColumnModel.getColumnIndexAtX(int)>
                //    8   18:istore_3        
                    int column = tableFinal.convertColumnIndexToModel(viewColumn);
                //    9   19:aload_0         
                //   10   20:getfield        #16  <Field JTable val$tableFinal>
                //   11   23:iload_3         
                //   12   24:invokevirtual   #48  <Method int JTable.convertColumnIndexToModel(int)>
                //   13   27:istore          4
                    if(e.getButton() == 1 && e.getClickCount() == 1 && !e.isAltDown() && column != -1)
                //*  14   29:aload_1         
                //*  15   30:invokevirtual   #51  <Method int MouseEvent.getButton()>
                //*  16   33:iconst_1        
                //*  17   34:icmpne          89
                //*  18   37:aload_1         
                //*  19   38:invokevirtual   #54  <Method int MouseEvent.getClickCount()>
                //*  20   41:iconst_1        
                //*  21   42:icmpne          89
                //*  22   45:aload_1         
                //*  23   46:invokevirtual   #58  <Method boolean MouseEvent.isAltDown()>
                //*  24   49:ifne            89
                //*  25   52:iload           4
                //*  26   54:iconst_m1       
                //*  27   55:icmpeq          89
                    {
                        int shiftPressed = e.getModifiers() & 1;
                //   28   58:aload_1         
                //   29   59:invokevirtual   #61  <Method int MouseEvent.getModifiers()>
                //   30   62:iconst_1        
                //   31   63:iand            
                //   32   64:istore          5
                        boolean ascending = shiftPressed == 0;
                //   33   66:iload           5
                //   34   68:ifne            75
                //   35   71:iconst_1        
                //   36   72:goto            76
                //   37   75:iconst_0        
                //   38   76:istore          6
                        modelFinal.sort(column, ascending);
                //   39   78:aload_0         
                //   40   79:getfield        #18  <Field SortedTableModel val$modelFinal>
                //   41   82:iload           4
                //   42   84:iload           6
                //   43   86:invokevirtual   #67  <Method void SortedTableModel.sort(int, boolean)>
                    }
                //   44   89:return          
                }

                final SortedTableModel this$0;
                private final JTable val$tableFinal;
                private final SortedTableModel val$modelFinal;

            
            {
                this$0 = SortedTableModel.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #14  <Field SortedTableModel this$0>
                tableFinal = jtable;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #16  <Field JTable val$tableFinal>
                modelFinal = sortedtablemodel1;
            //    6   10:aload_0         
            //    7   11:aload_3         
            //    8   12:putfield        #18  <Field SortedTableModel val$modelFinal>
                super();
            //    9   15:aload_0         
            //   10   16:invokespecial   #21  <Method void MouseAdapter()>
            //   11   19:return          
            }
            }
;
    //   12   20:new             #219 <Class SortedTableModel$1>
    //   13   23:dup             
    //   14   24:aload_0         
    //   15   25:aload_3         
    //   16   26:aload_2         
    //   17   27:invokespecial   #222 <Method void SortedTableModel$1(SortedTableModel, JTable, SortedTableModel)>
    //   18   30:astore          5
            header.addMouseListener(listMouseListener);
    //   19   32:aload           4
    //   20   34:aload           5
    //   21   36:invokevirtual   #228 <Method void JTableHeader.addMouseListener(java.awt.event.MouseListener)>
        }
    //   22   39:return          
    }

    static final long serialVersionUID = 0x37f0a965dcffa97cL;
    protected TableModel mModel;
    protected int mIndices[];
    protected int mSortColumn;
    protected boolean mAscending;
    static Class class$0;
}

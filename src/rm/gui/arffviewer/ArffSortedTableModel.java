// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffSortedTableModel.java

package rm.gui.arffviewer;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import rm.core.*;
import rm.gui.SortedTableModel;

// Referenced classes of package rm.gui.arffviewer:
//            ArffTableModel

public class ArffSortedTableModel extends SortedTableModel
    implements Undoable
{

    public ArffSortedTableModel(String filename)
    {
        this(((TableModel) (new ArffTableModel(filename))));
    //    0    0:aload_0         
    //    1    1:new             #16  <Class ArffTableModel>
    //    2    4:dup             
    //    3    5:aload_1         
    //    4    6:invokespecial   #18  <Method void ArffTableModel(String)>
    //    5    9:invokespecial   #21  <Method void ArffSortedTableModel(TableModel)>
    //    6   12:return          
    }

    public ArffSortedTableModel(Instances data)
    {
        this(((TableModel) (new ArffTableModel(data))));
    //    0    0:aload_0         
    //    1    1:new             #16  <Class ArffTableModel>
    //    2    4:dup             
    //    3    5:aload_1         
    //    4    6:invokespecial   #30  <Method void ArffTableModel(Instances)>
    //    5    9:invokespecial   #21  <Method void ArffSortedTableModel(TableModel)>
    //    6   12:return          
    }

    public ArffSortedTableModel(TableModel model)
    {
        super(model);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #33  <Method void SortedTableModel(TableModel)>
    //    3    5:return          
    }

    public boolean isNotificationEnabled()
    {
        return ((ArffTableModel)getModel()).isNotificationEnabled();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #43  <Method boolean ArffTableModel.isNotificationEnabled()>
    //    4   10:ireturn         
    }

    public void setNotificationEnabled(boolean enabled)
    {
        ((ArffTableModel)getModel()).setNotificationEnabled(enabled);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #47  <Method void ArffTableModel.setNotificationEnabled(boolean)>
    //    5   11:return          
    }

    public boolean isUndoEnabled()
    {
        return ((ArffTableModel)getModel()).isUndoEnabled();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #52  <Method boolean ArffTableModel.isUndoEnabled()>
    //    4   10:ireturn         
    }

    public void setUndoEnabled(boolean enabled)
    {
        ((ArffTableModel)getModel()).setUndoEnabled(enabled);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #55  <Method void ArffTableModel.setUndoEnabled(boolean)>
    //    5   11:return          
    }

    public boolean isReadOnly()
    {
        return ((ArffTableModel)getModel()).isReadOnly();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #58  <Method boolean ArffTableModel.isReadOnly()>
    //    4   10:ireturn         
    }

    public void setReadOnly(boolean value)
    {
        ((ArffTableModel)getModel()).setReadOnly(value);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #61  <Method void ArffTableModel.setReadOnly(boolean)>
    //    5   11:return          
    }

    public double getInstancesValueAt(int rowIndex, int columnIndex)
    {
        return ((ArffTableModel)getModel()).getInstancesValueAt(mIndices[rowIndex], columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_0         
    //    4    8:getfield        #68  <Field int[] mIndices>
    //    5   11:iload_1         
    //    6   12:iaload          
    //    7   13:iload_2         
    //    8   14:invokevirtual   #70  <Method double ArffTableModel.getInstancesValueAt(int, int)>
    //    9   17:dreturn         
    }

    public Object getModelValueAt(int rowIndex, int columnIndex)
    {
        Object result = super.getModel().getValueAt(rowIndex, columnIndex);
    //    0    0:aload_0         
    //    1    1:invokespecial   #76  <Method TableModel SortedTableModel.getModel()>
    //    2    4:iload_1         
    //    3    5:iload_2         
    //    4    6:invokeinterface #81  <Method Object TableModel.getValueAt(int, int)>
    //    5   11:astore_3        
        if(((ArffTableModel)getModel()).isMissingAt(rowIndex, columnIndex))
    //*   6   12:aload_0         
    //*   7   13:invokevirtual   #41  <Method TableModel getModel()>
    //*   8   16:checkcast       #16  <Class ArffTableModel>
    //*   9   19:iload_1         
    //*  10   20:iload_2         
    //*  11   21:invokevirtual   #85  <Method boolean ArffTableModel.isMissingAt(int, int)>
    //*  12   24:ifeq            29
            result = null;
    //   13   27:aconst_null     
    //   14   28:astore_3        
        return result;
    //   15   29:aload_3         
    //   16   30:areturn         
    }

    public int getType(int columnIndex)
    {
        return ((ArffTableModel)getModel()).getType(mIndices[0], columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_0         
    //    4    8:getfield        #68  <Field int[] mIndices>
    //    5   11:iconst_0        
    //    6   12:iaload          
    //    7   13:iload_1         
    //    8   14:invokevirtual   #92  <Method int ArffTableModel.getType(int, int)>
    //    9   17:ireturn         
    }

    public int getType(int rowIndex, int columnIndex)
    {
        return ((ArffTableModel)getModel()).getType(mIndices[rowIndex], columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_0         
    //    4    8:getfield        #68  <Field int[] mIndices>
    //    5   11:iload_1         
    //    6   12:iaload          
    //    7   13:iload_2         
    //    8   14:invokevirtual   #92  <Method int ArffTableModel.getType(int, int)>
    //    9   17:ireturn         
    }

    public void deleteAttributeAt(int columnIndex)
    {
        ((ArffTableModel)getModel()).deleteAttributeAt(columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #96  <Method void ArffTableModel.deleteAttributeAt(int)>
    //    5   11:return          
    }

    public void deleteAttributes(int columnIndices[])
    {
        ((ArffTableModel)getModel()).deleteAttributes(columnIndices);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_1         
    //    4    8:invokevirtual   #100 <Method void ArffTableModel.deleteAttributes(int[])>
    //    5   11:return          
    }

    public void renameAttributeAt(int columnIndex, String newName)
    {
        ((ArffTableModel)getModel()).renameAttributeAt(columnIndex, newName);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:aload_2         
    //    5    9:invokevirtual   #105 <Method void ArffTableModel.renameAttributeAt(int, String)>
    //    6   12:return          
    }

    public void attributeAsClassAt(int columnIndex)
    {
        ((ArffTableModel)getModel()).attributeAsClassAt(columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #109 <Method void ArffTableModel.attributeAsClassAt(int)>
    //    5   11:return          
    }

    public void deleteInstanceAt(int rowIndex)
    {
        ((ArffTableModel)getModel()).deleteInstanceAt(mIndices[rowIndex]);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_0         
    //    4    8:getfield        #68  <Field int[] mIndices>
    //    5   11:iload_1         
    //    6   12:iaload          
    //    7   13:invokevirtual   #112 <Method void ArffTableModel.deleteInstanceAt(int)>
    //    8   16:return          
    }

    public void deleteInstances(int rowIndices[])
    {
        int realIndices[] = new int[rowIndices.length];
    //    0    0:aload_1         
    //    1    1:arraylength     
    //    2    2:newarray        int[]
    //    3    4:astore_2        
        for(int i = 0; i < rowIndices.length; i++)
    //*   4    5:iconst_0        
    //*   5    6:istore_3        
    //*   6    7:goto            24
            realIndices[i] = mIndices[rowIndices[i]];
    //    7   10:aload_2         
    //    8   11:iload_3         
    //    9   12:aload_0         
    //   10   13:getfield        #68  <Field int[] mIndices>
    //   11   16:aload_1         
    //   12   17:iload_3         
    //   13   18:iaload          
    //   14   19:iaload          
    //   15   20:iastore         

    //   16   21:iinc            3  1
    //   17   24:iload_3         
    //   18   25:aload_1         
    //   19   26:arraylength     
    //   20   27:icmplt          10
        ((ArffTableModel)getModel()).deleteInstances(realIndices);
    //   21   30:aload_0         
    //   22   31:invokevirtual   #41  <Method TableModel getModel()>
    //   23   34:checkcast       #16  <Class ArffTableModel>
    //   24   37:aload_2         
    //   25   38:invokevirtual   #115 <Method void ArffTableModel.deleteInstances(int[])>
    //   26   41:return          
    }

    public void sortInstances(int columnIndex)
    {
        ((ArffTableModel)getModel()).sortInstances(columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #121 <Method void ArffTableModel.sortInstances(int)>
    //    5   11:return          
    }

    public int getAttributeColumn(String name)
    {
        return ((ArffTableModel)getModel()).getAttributeColumn(name);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_1         
    //    4    8:invokevirtual   #125 <Method int ArffTableModel.getAttributeColumn(String)>
    //    5   11:ireturn         
    }

    public boolean isMissingAt(int rowIndex, int columnIndex)
    {
        return ((ArffTableModel)getModel()).isMissingAt(mIndices[rowIndex], columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_0         
    //    4    8:getfield        #68  <Field int[] mIndices>
    //    5   11:iload_1         
    //    6   12:iaload          
    //    7   13:iload_2         
    //    8   14:invokevirtual   #85  <Method boolean ArffTableModel.isMissingAt(int, int)>
    //    9   17:ireturn         
    }

    public void setInstances(Instances data)
    {
        ((ArffTableModel)getModel()).setInstances(data);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_1         
    //    4    8:invokevirtual   #129 <Method void ArffTableModel.setInstances(Instances)>
    //    5   11:return          
    }

    public Instances getInstances()
    {
        return ((ArffTableModel)getModel()).getInstances();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #133 <Method Instances ArffTableModel.getInstances()>
    //    4   10:areturn         
    }

    public Attribute getAttributeAt(int columnIndex)
    {
        return ((ArffTableModel)getModel()).getAttributeAt(columnIndex);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:iload_1         
    //    4    8:invokevirtual   #137 <Method Attribute ArffTableModel.getAttributeAt(int)>
    //    5   11:areturn         
    }

    public void addTableModelListener(TableModelListener l)
    {
        if(getModel() != null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #41  <Method TableModel getModel()>
    //*   2    4:ifnull          18
            ((ArffTableModel)getModel()).addTableModelListener(l);
    //    3    7:aload_0         
    //    4    8:invokevirtual   #41  <Method TableModel getModel()>
    //    5   11:checkcast       #16  <Class ArffTableModel>
    //    6   14:aload_1         
    //    7   15:invokevirtual   #141 <Method void ArffTableModel.addTableModelListener(TableModelListener)>
    //    8   18:return          
    }

    public void removeTableModelListener(TableModelListener l)
    {
        if(getModel() != null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #41  <Method TableModel getModel()>
    //*   2    4:ifnull          18
            ((ArffTableModel)getModel()).removeTableModelListener(l);
    //    3    7:aload_0         
    //    4    8:invokevirtual   #41  <Method TableModel getModel()>
    //    5   11:checkcast       #16  <Class ArffTableModel>
    //    6   14:aload_1         
    //    7   15:invokevirtual   #146 <Method void ArffTableModel.removeTableModelListener(TableModelListener)>
    //    8   18:return          
    }

    public void notifyListener(TableModelEvent e)
    {
        ((ArffTableModel)getModel()).notifyListener(e);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:aload_1         
    //    4    8:invokevirtual   #150 <Method void ArffTableModel.notifyListener(TableModelEvent)>
    //    5   11:return          
    }

    public void clearUndo()
    {
        ((ArffTableModel)getModel()).clearUndo();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #156 <Method void ArffTableModel.clearUndo()>
    //    4   10:return          
    }

    public boolean canUndo()
    {
        return ((ArffTableModel)getModel()).canUndo();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #159 <Method boolean ArffTableModel.canUndo()>
    //    4   10:ireturn         
    }

    public void undo()
    {
        ((ArffTableModel)getModel()).undo();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #162 <Method void ArffTableModel.undo()>
    //    4   10:return          
    }

    public void addUndoPoint()
    {
        ((ArffTableModel)getModel()).addUndoPoint();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #41  <Method TableModel getModel()>
    //    2    4:checkcast       #16  <Class ArffTableModel>
    //    3    7:invokevirtual   #165 <Method void ArffTableModel.addUndoPoint()>
    //    4   10:return          
    }

    static final long serialVersionUID = 0xb06fc3ed5ecc1332L;
}

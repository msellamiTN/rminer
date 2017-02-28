// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RoleFixedTableModel.java

package rm.gui.graph;

import javax.swing.table.AbstractTableModel;

public class RoleFixedTableModel extends AbstractTableModel
{

    public RoleFixedTableModel(Object roleList[], Object weightList[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void AbstractTableModel()>
        this.roleList = (Object[])((Object []) (roleList)).clone();
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #23  <Method Object _5B_Ljava.lang.Object_3B_.clone()>
    //    5    9:checkcast       #19  <Class Object[]>
    //    6   12:putfield        #25  <Field Object[] roleList>
        this.weightList = (Object[])((Object []) (weightList)).clone();
    //    7   15:aload_0         
    //    8   16:aload_2         
    //    9   17:invokevirtual   #23  <Method Object _5B_Ljava.lang.Object_3B_.clone()>
    //   10   20:checkcast       #19  <Class Object[]>
    //   11   23:putfield        #27  <Field Object[] weightList>
    //   12   26:return          
    }

    public int getColumnCount()
    {
        return 2;
    //    0    0:iconst_2        
    //    1    1:ireturn         
    }

    public int getRowCount()
    {
        return roleList.length;
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Object[] roleList>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public String getColumnName(int column)
    {
        if(column == 0)
    //*   0    0:iload_1         
    //*   1    1:ifne            7
            return "Role/Perm";
    //    2    4:ldc1            #38  <String "Role/Perm">
    //    3    6:areturn         
        if(column == 1)
    //*   4    7:iload_1         
    //*   5    8:iconst_1        
    //*   6    9:icmpne          15
            return "Weight";
    //    7   12:ldc1            #40  <String "Weight">
    //    8   14:areturn         
        else
            return "";
    //    9   15:ldc1            #42  <String "">
    //   10   17:areturn         
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if(columnIndex == 0)
    //*   0    0:iload_2         
    //*   1    1:ifne            14
            return (String)roleList[rowIndex];
    //    2    4:aload_0         
    //    3    5:getfield        #25  <Field Object[] roleList>
    //    4    8:iload_1         
    //    5    9:aaload          
    //    6   10:checkcast       #48  <Class String>
    //    7   13:areturn         
        else
            return weightList[rowIndex];
    //    8   14:aload_0         
    //    9   15:getfield        #27  <Field Object[] weightList>
    //   10   18:iload_1         
    //   11   19:aaload          
    //   12   20:areturn         
    }

    private static final long serialVersionUID = 1L;
    Object roleList[];
    Object weightList[];
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   UserFixedTableModel.java

package rm.gui.graph;

import javax.swing.table.AbstractTableModel;

public class UserFixedTableModel extends AbstractTableModel
{

    public static void setColumName(String DimX, String DimY)
    {
        ColumName = (new StringBuilder(String.valueOf(DimX))).append("/").append(DimY).toString();
    //    0    0:new             #26  <Class StringBuilder>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokestatic    #32  <Method String String.valueOf(Object)>
    //    4    8:invokespecial   #36  <Method void StringBuilder(String)>
    //    5   11:ldc1            #38  <String "/">
    //    6   13:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //    7   16:aload_1         
    //    8   17:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //    9   20:invokevirtual   #46  <Method String StringBuilder.toString()>
    //   10   23:putstatic       #20  <Field String ColumName>
    //   11   26:return          
    }

    public UserFixedTableModel(Object userSet[])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #51  <Method void AbstractTableModel()>
        userList = (Object[])((Object []) (userSet)).clone();
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #56  <Method Object _5B_Ljava.lang.Object_3B_.clone()>
    //    5    9:checkcast       #52  <Class Object[]>
    //    6   12:putfield        #58  <Field Object[] userList>
    //    7   15:return          
    }

    public int getColumnCount()
    {
        return 1;
    //    0    0:iconst_1        
    //    1    1:ireturn         
    }

    public int getRowCount()
    {
        return userList.length;
    //    0    0:aload_0         
    //    1    1:getfield        #58  <Field Object[] userList>
    //    2    4:arraylength     
    //    3    5:ireturn         
    }

    public String getColumnName(int row)
    {
        return ColumName;
    //    0    0:getstatic       #20  <Field String ColumName>
    //    1    3:areturn         
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return (String)userList[rowIndex];
    //    0    0:aload_0         
    //    1    1:getfield        #58  <Field Object[] userList>
    //    2    4:iload_1         
    //    3    5:aaload          
    //    4    6:checkcast       #28  <Class String>
    //    5    9:areturn         
    }

    private static final long serialVersionUID = 1L;
    Object userList[];
    static String ColumName = "";

    static 
    {
    //    0    0:ldc1            #18  <String "">
    //    1    2:putstatic       #20  <Field String ColumName>
    //*   2    5:return          
    }
}

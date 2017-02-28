// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffTableModel.java

package rm.gui.arffviewer;

import java.io.*;
import java.util.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import rm.core.*;
import rm.core.converters.AbstractFileLoader;
import rm.core.converters.ConverterUtils;
import rm.gui.ComponentHelper;

public class ArffTableModel
    implements TableModel, Undoable
{

    private ArffTableModel()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #28  <Method void Object()>
        m_Listeners = new HashSet();
    //    2    4:aload_0         
    //    3    5:new             #30  <Class HashSet>
    //    4    8:dup             
    //    5    9:invokespecial   #31  <Method void HashSet()>
    //    6   12:putfield        #33  <Field HashSet m_Listeners>
        m_Data = null;
    //    7   15:aload_0         
    //    8   16:aconst_null     
    //    9   17:putfield        #35  <Field Instances m_Data>
        m_NotificationEnabled = true;
    //   10   20:aload_0         
    //   11   21:iconst_1        
    //   12   22:putfield        #37  <Field boolean m_NotificationEnabled>
        m_UndoList = new Vector();
    //   13   25:aload_0         
    //   14   26:new             #39  <Class Vector>
    //   15   29:dup             
    //   16   30:invokespecial   #40  <Method void Vector()>
    //   17   33:putfield        #42  <Field Vector m_UndoList>
        m_IgnoreChanges = false;
    //   18   36:aload_0         
    //   19   37:iconst_0        
    //   20   38:putfield        #44  <Field boolean m_IgnoreChanges>
        m_UndoEnabled = true;
    //   21   41:aload_0         
    //   22   42:iconst_1        
    //   23   43:putfield        #46  <Field boolean m_UndoEnabled>
        m_ReadOnly = false;
    //   24   46:aload_0         
    //   25   47:iconst_0        
    //   26   48:putfield        #48  <Field boolean m_ReadOnly>
    //   27   51:return          
    }

    public ArffTableModel(String filename)
    {
        this();
    //    0    0:aload_0         
    //    1    1:invokespecial   #54  <Method void ArffTableModel()>
        if(filename != null && !filename.equals(""))
    //*   2    4:aload_1         
    //*   3    5:ifnull          22
    //*   4    8:aload_1         
    //*   5    9:ldc1            #56  <String "">
    //*   6   11:invokevirtual   #62  <Method boolean String.equals(Object)>
    //*   7   14:ifne            22
            loadFile(filename);
    //    8   17:aload_0         
    //    9   18:aload_1         
    //   10   19:invokespecial   #65  <Method void loadFile(String)>
    //   11   22:return          
    }

    public ArffTableModel(Instances data)
    {
        this();
    //    0    0:aload_0         
    //    1    1:invokespecial   #54  <Method void ArffTableModel()>
        m_Data = data;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #35  <Field Instances m_Data>
    //    5    9:return          
    }

    public boolean isNotificationEnabled()
    {
        return m_NotificationEnabled;
    //    0    0:aload_0         
    //    1    1:getfield        #37  <Field boolean m_NotificationEnabled>
    //    2    4:ireturn         
    }

    public void setNotificationEnabled(boolean enabled)
    {
        m_NotificationEnabled = enabled;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #37  <Field boolean m_NotificationEnabled>
    //    3    5:return          
    }

    public boolean isUndoEnabled()
    {
        return m_UndoEnabled;
    //    0    0:aload_0         
    //    1    1:getfield        #46  <Field boolean m_UndoEnabled>
    //    2    4:ireturn         
    }

    public void setUndoEnabled(boolean enabled)
    {
        m_UndoEnabled = enabled;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #46  <Field boolean m_UndoEnabled>
    //    3    5:return          
    }

    public boolean isReadOnly()
    {
        return m_ReadOnly;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field boolean m_ReadOnly>
    //    2    4:ireturn         
    }

    public void setReadOnly(boolean value)
    {
        m_ReadOnly = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #48  <Field boolean m_ReadOnly>
    //    3    5:return          
    }

    private void loadFile(String filename)
    {
        AbstractFileLoader loader = ConverterUtils.getLoaderForFile(filename);
    //    0    0:aload_1         
    //    1    1:invokestatic    #85  <Method AbstractFileLoader ConverterUtils.getLoaderForFile(String)>
    //    2    4:astore_2        
        if(loader != null)
    //*   3    5:aload_2         
    //*   4    6:ifnull          58
            try
            {
                loader.setFile(new File(filename));
    //    5    9:aload_2         
    //    6   10:new             #87  <Class File>
    //    7   13:dup             
    //    8   14:aload_1         
    //    9   15:invokespecial   #89  <Method void File(String)>
    //   10   18:invokevirtual   #95  <Method void AbstractFileLoader.setFile(File)>
                m_Data = loader.getDataSet();
    //   11   21:aload_0         
    //   12   22:aload_2         
    //   13   23:invokevirtual   #99  <Method Instances AbstractFileLoader.getDataSet()>
    //   14   26:putfield        #35  <Field Instances m_Data>
            }
    //*  15   29:goto            58
            catch(Exception e)
    //*  16   32:astore_3        
            {
                ComponentHelper.showMessageBox(null, "Error loading file...", e.toString(), 2, 0);
    //   17   33:aconst_null     
    //   18   34:ldc1            #101 <String "Error loading file...">
    //   19   36:aload_3         
    //   20   37:invokevirtual   #107 <Method String Exception.toString()>
    //   21   40:iconst_2        
    //   22   41:iconst_0        
    //   23   42:invokestatic    #113 <Method int ComponentHelper.showMessageBox(java.awt.Component, String, String, int, int)>
    //   24   45:pop             
                System.out.println(e);
    //   25   46:getstatic       #119 <Field PrintStream System.out>
    //   26   49:aload_3         
    //   27   50:invokevirtual   #125 <Method void PrintStream.println(Object)>
                m_Data = null;
    //   28   53:aload_0         
    //   29   54:aconst_null     
    //   30   55:putfield        #35  <Field Instances m_Data>
            }
    //   31   58:return          
    }

    public void setInstances(Instances data)
    {
        m_Data = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #35  <Field Instances m_Data>
    //    3    5:return          
    }

    public Instances getInstances()
    {
        return m_Data;
    //    0    0:aload_0         
    //    1    1:getfield        #35  <Field Instances m_Data>
    //    2    4:areturn         
    }

    public Attribute getAttributeAt(int columnIndex)
    {
        if(columnIndex > 0 && columnIndex < getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:ifle            23
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #137 <Method int getColumnCount()>
    //*   5    9:icmpge          23
            return m_Data.attribute(columnIndex - 1);
    //    6   12:aload_0         
    //    7   13:getfield        #35  <Field Instances m_Data>
    //    8   16:iload_1         
    //    9   17:iconst_1        
    //   10   18:isub            
    //   11   19:invokevirtual   #142 <Method Attribute Instances.attribute(int)>
    //   12   22:areturn         
        else
            return null;
    //   13   23:aconst_null     
    //   14   24:areturn         
    }

    public int getType(int columnIndex)
    {
        return getType(0, columnIndex);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:iload_1         
    //    3    3:invokevirtual   #149 <Method int getType(int, int)>
    //    4    6:ireturn         
    }

    public int getType(int rowIndex, int columnIndex)
    {
        int result = 2;
    //    0    0:iconst_2        
    //    1    1:istore_3        
        if(rowIndex >= 0 && rowIndex < getRowCount() && columnIndex > 0 && columnIndex < getColumnCount())
    //*   2    2:iload_1         
    //*   3    3:iflt            44
    //*   4    6:iload_1         
    //*   5    7:aload_0         
    //*   6    8:invokevirtual   #152 <Method int getRowCount()>
    //*   7   11:icmpge          44
    //*   8   14:iload_2         
    //*   9   15:ifle            44
    //*  10   18:iload_2         
    //*  11   19:aload_0         
    //*  12   20:invokevirtual   #137 <Method int getColumnCount()>
    //*  13   23:icmpge          44
            result = m_Data.instance(rowIndex).attribute(columnIndex - 1).type();
    //   14   26:aload_0         
    //   15   27:getfield        #35  <Field Instances m_Data>
    //   16   30:iload_1         
    //   17   31:invokevirtual   #156 <Method Instance Instances.instance(int)>
    //   18   34:iload_2         
    //   19   35:iconst_1        
    //   20   36:isub            
    //   21   37:invokevirtual   #159 <Method Attribute Instance.attribute(int)>
    //   22   40:invokevirtual   #164 <Method int Attribute.type()>
    //   23   43:istore_3        
        return result;
    //   24   44:iload_3         
    //   25   45:ireturn         
    }

    public void deleteAttributeAt(int columnIndex)
    {
        deleteAttributeAt(columnIndex, true);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:iconst_1        
    //    3    3:invokevirtual   #171 <Method void deleteAttributeAt(int, boolean)>
    //    4    6:return          
    }

    public void deleteAttributeAt(int columnIndex, boolean notify)
    {
        if(columnIndex > 0 && columnIndex < getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:ifle            50
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #137 <Method int getColumnCount()>
    //*   5    9:icmpge          50
        {
            if(!m_IgnoreChanges)
    //*   6   12:aload_0         
    //*   7   13:getfield        #44  <Field boolean m_IgnoreChanges>
    //*   8   16:ifne            23
                addUndoPoint();
    //    9   19:aload_0         
    //   10   20:invokevirtual   #174 <Method void addUndoPoint()>
            m_Data.deleteAttributeAt(columnIndex - 1);
    //   11   23:aload_0         
    //   12   24:getfield        #35  <Field Instances m_Data>
    //   13   27:iload_1         
    //   14   28:iconst_1        
    //   15   29:isub            
    //   16   30:invokevirtual   #176 <Method void Instances.deleteAttributeAt(int)>
            if(notify)
    //*  17   33:iload_2         
    //*  18   34:ifeq            50
                notifyListener(new TableModelEvent(this, -1));
    //   19   37:aload_0         
    //   20   38:new             #178 <Class TableModelEvent>
    //   21   41:dup             
    //   22   42:aload_0         
    //   23   43:iconst_m1       
    //   24   44:invokespecial   #181 <Method void TableModelEvent(TableModel, int)>
    //   25   47:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
        }
    //   26   50:return          
    }

    public void deleteAttributes(int columnIndices[])
    {
        Arrays.sort(columnIndices);
    //    0    0:aload_1         
    //    1    1:invokestatic    #193 <Method void Arrays.sort(int[])>
        addUndoPoint();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #174 <Method void addUndoPoint()>
        m_IgnoreChanges = true;
    //    4    8:aload_0         
    //    5    9:iconst_1        
    //    6   10:putfield        #44  <Field boolean m_IgnoreChanges>
        for(int i = columnIndices.length - 1; i >= 0; i--)
    //*   7   13:aload_1         
    //*   8   14:arraylength     
    //*   9   15:iconst_1        
    //*  10   16:isub            
    //*  11   17:istore_2        
    //*  12   18:goto            32
            deleteAttributeAt(columnIndices[i], false);
    //   13   21:aload_0         
    //   14   22:aload_1         
    //   15   23:iload_2         
    //   16   24:iaload          
    //   17   25:iconst_0        
    //   18   26:invokevirtual   #171 <Method void deleteAttributeAt(int, boolean)>

    //   19   29:iinc            2  -1
    //   20   32:iload_2         
    //   21   33:ifge            21
        m_IgnoreChanges = false;
    //   22   36:aload_0         
    //   23   37:iconst_0        
    //   24   38:putfield        #44  <Field boolean m_IgnoreChanges>
        notifyListener(new TableModelEvent(this, -1));
    //   25   41:aload_0         
    //   26   42:new             #178 <Class TableModelEvent>
    //   27   45:dup             
    //   28   46:aload_0         
    //   29   47:iconst_m1       
    //   30   48:invokespecial   #181 <Method void TableModelEvent(TableModel, int)>
    //   31   51:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
    //   32   54:return          
    }

    public void renameAttributeAt(int columnIndex, String newName)
    {
        if(columnIndex > 0 && columnIndex < getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:ifle            40
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #137 <Method int getColumnCount()>
    //*   5    9:icmpge          40
        {
            addUndoPoint();
    //    6   12:aload_0         
    //    7   13:invokevirtual   #174 <Method void addUndoPoint()>
            m_Data.renameAttribute(columnIndex - 1, newName);
    //    8   16:aload_0         
    //    9   17:getfield        #35  <Field Instances m_Data>
    //   10   20:iload_1         
    //   11   21:iconst_1        
    //   12   22:isub            
    //   13   23:aload_2         
    //   14   24:invokevirtual   #201 <Method void Instances.renameAttribute(int, String)>
            notifyListener(new TableModelEvent(this, -1));
    //   15   27:aload_0         
    //   16   28:new             #178 <Class TableModelEvent>
    //   17   31:dup             
    //   18   32:aload_0         
    //   19   33:iconst_m1       
    //   20   34:invokespecial   #181 <Method void TableModelEvent(TableModel, int)>
    //   21   37:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
        }
    //   22   40:return          
    }

    public void attributeAsClassAt(int columnIndex)
    {
        if(columnIndex > 0 && columnIndex < getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:ifle            189
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #137 <Method int getColumnCount()>
    //*   5    9:icmpge          189
        {
            try
            {
                String order = "";
    //    6   12:ldc1            #56  <String "">
    //    7   14:astore_2        
                for(int i = 1; i < m_Data.numAttributes() + 1; i++)
    //*   8   15:iconst_1        
    //*   9   16:istore_3        
    //*  10   17:goto            82
                    if(i != columnIndex)
    //*  11   20:iload_3         
    //*  12   21:iload_1         
    //*  13   22:icmpne          28
    //*  14   25:goto            79
                    {
                        if(!order.equals(""))
    //*  15   28:aload_2         
    //*  16   29:ldc1            #56  <String "">
    //*  17   31:invokevirtual   #62  <Method boolean String.equals(Object)>
    //*  18   34:ifne            57
                            order = (new StringBuilder(String.valueOf(order))).append(",").toString();
    //   19   37:new             #205 <Class StringBuilder>
    //   20   40:dup             
    //   21   41:aload_2         
    //   22   42:invokestatic    #209 <Method String String.valueOf(Object)>
    //   23   45:invokespecial   #210 <Method void StringBuilder(String)>
    //   24   48:ldc1            #212 <String ",">
    //   25   50:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   26   53:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   27   56:astore_2        
                        order = (new StringBuilder(String.valueOf(order))).append(Integer.toString(i)).toString();
    //   28   57:new             #205 <Class StringBuilder>
    //   29   60:dup             
    //   30   61:aload_2         
    //   31   62:invokestatic    #209 <Method String String.valueOf(Object)>
    //   32   65:invokespecial   #210 <Method void StringBuilder(String)>
    //   33   68:iload_3         
    //   34   69:invokestatic    #222 <Method String Integer.toString(int)>
    //   35   72:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   36   75:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   37   78:astore_2        
                    }

    //   38   79:iinc            3  1
    //   39   82:iload_3         
    //   40   83:aload_0         
    //   41   84:getfield        #35  <Field Instances m_Data>
    //   42   87:invokevirtual   #225 <Method int Instances.numAttributes()>
    //   43   90:iconst_1        
    //   44   91:iadd            
    //   45   92:icmplt          20
                if(!order.equals(""))
    //*  46   95:aload_2         
    //*  47   96:ldc1            #56  <String "">
    //*  48   98:invokevirtual   #62  <Method boolean String.equals(Object)>
    //*  49  101:ifne            124
                    order = (new StringBuilder(String.valueOf(order))).append(",").toString();
    //   50  104:new             #205 <Class StringBuilder>
    //   51  107:dup             
    //   52  108:aload_2         
    //   53  109:invokestatic    #209 <Method String String.valueOf(Object)>
    //   54  112:invokespecial   #210 <Method void StringBuilder(String)>
    //   55  115:ldc1            #212 <String ",">
    //   56  117:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   57  120:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   58  123:astore_2        
                order = (new StringBuilder(String.valueOf(order))).append(Integer.toString(columnIndex)).toString();
    //   59  124:new             #205 <Class StringBuilder>
    //   60  127:dup             
    //   61  128:aload_2         
    //   62  129:invokestatic    #209 <Method String String.valueOf(Object)>
    //   63  132:invokespecial   #210 <Method void StringBuilder(String)>
    //   64  135:iload_1         
    //   65  136:invokestatic    #222 <Method String Integer.toString(int)>
    //   66  139:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   67  142:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   68  145:astore_2        
                m_Data.setClassIndex(m_Data.numAttributes() - 1);
    //   69  146:aload_0         
    //   70  147:getfield        #35  <Field Instances m_Data>
    //   71  150:aload_0         
    //   72  151:getfield        #35  <Field Instances m_Data>
    //   73  154:invokevirtual   #225 <Method int Instances.numAttributes()>
    //   74  157:iconst_1        
    //   75  158:isub            
    //   76  159:invokevirtual   #228 <Method void Instances.setClassIndex(int)>
            }
    //*  77  162:goto            176
            catch(Exception e)
    //*  78  165:astore          4
            {
                e.printStackTrace();
    //   79  167:aload           4
    //   80  169:invokevirtual   #231 <Method void Exception.printStackTrace()>
                undo();
    //   81  172:aload_0         
    //   82  173:invokevirtual   #234 <Method void undo()>
            }
            notifyListener(new TableModelEvent(this, -1));
    //   83  176:aload_0         
    //   84  177:new             #178 <Class TableModelEvent>
    //   85  180:dup             
    //   86  181:aload_0         
    //   87  182:iconst_m1       
    //   88  183:invokespecial   #181 <Method void TableModelEvent(TableModel, int)>
    //   89  186:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
        }
    //   90  189:return          
    }

    public void deleteInstanceAt(int rowIndex)
    {
        deleteInstanceAt(rowIndex, true);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:iconst_1        
    //    3    3:invokevirtual   #238 <Method void deleteInstanceAt(int, boolean)>
    //    4    6:return          
    }

    public void deleteInstanceAt(int rowIndex, boolean notify)
    {
        if(rowIndex >= 0 && rowIndex < getRowCount())
    //*   0    0:iload_1         
    //*   1    1:iflt            51
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #152 <Method int getRowCount()>
    //*   5    9:icmpge          51
        {
            if(!m_IgnoreChanges)
    //*   6   12:aload_0         
    //*   7   13:getfield        #44  <Field boolean m_IgnoreChanges>
    //*   8   16:ifne            23
                addUndoPoint();
    //    9   19:aload_0         
    //   10   20:invokevirtual   #174 <Method void addUndoPoint()>
            m_Data.delete(rowIndex);
    //   11   23:aload_0         
    //   12   24:getfield        #35  <Field Instances m_Data>
    //   13   27:iload_1         
    //   14   28:invokevirtual   #241 <Method void Instances.delete(int)>
            if(notify)
    //*  15   31:iload_2         
    //*  16   32:ifeq            51
                notifyListener(new TableModelEvent(this, rowIndex, rowIndex, -1, -1));
    //   17   35:aload_0         
    //   18   36:new             #178 <Class TableModelEvent>
    //   19   39:dup             
    //   20   40:aload_0         
    //   21   41:iload_1         
    //   22   42:iload_1         
    //   23   43:iconst_m1       
    //   24   44:iconst_m1       
    //   25   45:invokespecial   #244 <Method void TableModelEvent(TableModel, int, int, int, int)>
    //   26   48:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
        }
    //   27   51:return          
    }

    public void deleteInstances(int rowIndices[])
    {
        Arrays.sort(rowIndices);
    //    0    0:aload_1         
    //    1    1:invokestatic    #193 <Method void Arrays.sort(int[])>
        addUndoPoint();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #174 <Method void addUndoPoint()>
        m_IgnoreChanges = true;
    //    4    8:aload_0         
    //    5    9:iconst_1        
    //    6   10:putfield        #44  <Field boolean m_IgnoreChanges>
        for(int i = rowIndices.length - 1; i >= 0; i--)
    //*   7   13:aload_1         
    //*   8   14:arraylength     
    //*   9   15:iconst_1        
    //*  10   16:isub            
    //*  11   17:istore_2        
    //*  12   18:goto            32
            deleteInstanceAt(rowIndices[i], false);
    //   13   21:aload_0         
    //   14   22:aload_1         
    //   15   23:iload_2         
    //   16   24:iaload          
    //   17   25:iconst_0        
    //   18   26:invokevirtual   #238 <Method void deleteInstanceAt(int, boolean)>

    //   19   29:iinc            2  -1
    //   20   32:iload_2         
    //   21   33:ifge            21
        m_IgnoreChanges = false;
    //   22   36:aload_0         
    //   23   37:iconst_0        
    //   24   38:putfield        #44  <Field boolean m_IgnoreChanges>
        notifyListener(new TableModelEvent(this, rowIndices[0], rowIndices[rowIndices.length - 1], -1, -1));
    //   25   41:aload_0         
    //   26   42:new             #178 <Class TableModelEvent>
    //   27   45:dup             
    //   28   46:aload_0         
    //   29   47:aload_1         
    //   30   48:iconst_0        
    //   31   49:iaload          
    //   32   50:aload_1         
    //   33   51:aload_1         
    //   34   52:arraylength     
    //   35   53:iconst_1        
    //   36   54:isub            
    //   37   55:iaload          
    //   38   56:iconst_m1       
    //   39   57:iconst_m1       
    //   40   58:invokespecial   #244 <Method void TableModelEvent(TableModel, int, int, int, int)>
    //   41   61:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
    //   42   64:return          
    }

    public void sortInstances(int columnIndex)
    {
        if(columnIndex > 0 && columnIndex < getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:ifle            38
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #137 <Method int getColumnCount()>
    //*   5    9:icmpge          38
        {
            addUndoPoint();
    //    6   12:aload_0         
    //    7   13:invokevirtual   #174 <Method void addUndoPoint()>
            m_Data.sort(columnIndex - 1);
    //    8   16:aload_0         
    //    9   17:getfield        #35  <Field Instances m_Data>
    //   10   20:iload_1         
    //   11   21:iconst_1        
    //   12   22:isub            
    //   13   23:invokevirtual   #249 <Method void Instances.sort(int)>
            notifyListener(new TableModelEvent(this));
    //   14   26:aload_0         
    //   15   27:new             #178 <Class TableModelEvent>
    //   16   30:dup             
    //   17   31:aload_0         
    //   18   32:invokespecial   #252 <Method void TableModelEvent(TableModel)>
    //   19   35:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
        }
    //   20   38:return          
    }

    public int getAttributeColumn(String name)
    {
        int result = -1;
    //    0    0:iconst_m1       
    //    1    1:istore_3        
        for(int i = 0; i < m_Data.numAttributes(); i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_2        
    //*   4    4:goto            35
        {
            if(!m_Data.attribute(i).name().equals(name))
                continue;
    //    5    7:aload_0         
    //    6    8:getfield        #35  <Field Instances m_Data>
    //    7   11:iload_2         
    //    8   12:invokevirtual   #142 <Method Attribute Instances.attribute(int)>
    //    9   15:invokevirtual   #257 <Method String Attribute.name()>
    //   10   18:aload_1         
    //   11   19:invokevirtual   #62  <Method boolean String.equals(Object)>
    //   12   22:ifeq            32
            result = i + 1;
    //   13   25:iload_2         
    //   14   26:iconst_1        
    //   15   27:iadd            
    //   16   28:istore_3        
            break;
    //   17   29:goto            46
        }

    //   18   32:iinc            2  1
    //   19   35:iload_2         
    //   20   36:aload_0         
    //   21   37:getfield        #35  <Field Instances m_Data>
    //   22   40:invokevirtual   #225 <Method int Instances.numAttributes()>
    //   23   43:icmplt          7
        return result;
    //   24   46:iload_3         
    //   25   47:ireturn         
    }

    public Class getColumnClass(int columnIndex)
    {
        Class result = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        if(columnIndex >= 0 && columnIndex < getColumnCount())
    //*   2    2:iload_1         
    //*   3    3:iflt            42
    //*   4    6:iload_1         
    //*   5    7:aload_0         
    //*   6    8:invokevirtual   #137 <Method int getColumnCount()>
    //*   7   11:icmpge          42
            if(columnIndex == 0)
    //*   8   14:iload_1         
    //*   9   15:ifne            24
                result = java/lang/Integer;
    //   10   18:ldc1            #219 <Class Integer>
    //   11   20:astore_2        
            else
    //*  12   21:goto            42
            if(getType(columnIndex) == 0)
    //*  13   24:aload_0         
    //*  14   25:iload_1         
    //*  15   26:invokevirtual   #261 <Method int getType(int)>
    //*  16   29:ifne            39
                result = java/lang/Double;
    //   17   32:ldc2            #263 <Class Double>
    //   18   35:astore_2        
            else
    //*  19   36:goto            42
                result = java/lang/String;
    //   20   39:ldc1            #58  <Class String>
    //   21   41:astore_2        
        return result;
    //   22   42:aload_2         
    //   23   43:areturn         
    }

    public int getColumnCount()
    {
        int result = 1;
    //    0    0:iconst_1        
    //    1    1:istore_1        
        if(m_Data != null)
    //*   2    2:aload_0         
    //*   3    3:getfield        #35  <Field Instances m_Data>
    //*   4    6:ifnull          19
            result += m_Data.numAttributes();
    //    5    9:iload_1         
    //    6   10:aload_0         
    //    7   11:getfield        #35  <Field Instances m_Data>
    //    8   14:invokevirtual   #225 <Method int Instances.numAttributes()>
    //    9   17:iadd            
    //   10   18:istore_1        
        return result;
    //   11   19:iload_1         
    //   12   20:ireturn         
    }

    private boolean isClassIndex(int columnIndex)
    {
        int index = m_Data.classIndex();
    //    0    0:aload_0         
    //    1    1:getfield        #35  <Field Instances m_Data>
    //    2    4:invokevirtual   #268 <Method int Instances.classIndex()>
    //    3    7:istore_3        
        boolean result = index == -1 && m_Data.numAttributes() == columnIndex || index == columnIndex - 1;
    //    4    8:iload_3         
    //    5    9:iconst_m1       
    //    6   10:icmpne          24
    //    7   13:aload_0         
    //    8   14:getfield        #35  <Field Instances m_Data>
    //    9   17:invokevirtual   #225 <Method int Instances.numAttributes()>
    //   10   20:iload_1         
    //   11   21:icmpeq          35
    //   12   24:iload_3         
    //   13   25:iload_1         
    //   14   26:iconst_1        
    //   15   27:isub            
    //   16   28:icmpeq          35
    //   17   31:iconst_0        
    //   18   32:goto            36
    //   19   35:iconst_1        
    //   20   36:istore_2        
        return result;
    //   21   37:iload_2         
    //   22   38:ireturn         
    }

    public String getColumnName(int columnIndex)
    {
        String result = "";
    //    0    0:ldc1            #56  <String "">
    //    1    2:astore_2        
        if(columnIndex >= 0 && columnIndex < getColumnCount())
    //*   2    3:iload_1         
    //*   3    4:iflt            338
    //*   4    7:iload_1         
    //*   5    8:aload_0         
    //*   6    9:invokevirtual   #137 <Method int getColumnCount()>
    //*   7   12:icmpge          338
            if(columnIndex == 0)
    //*   8   15:iload_1         
    //*   9   16:ifne            26
                result = "<html><center>No.<br><font size=\"-2\">&nbsp;</font></center></html>";
    //   10   19:ldc2            #272 <String "<html><center>No.<br><font size=\"-2\">&nbsp;</font></center></html>">
    //   11   22:astore_2        
            else
    //*  12   23:goto            338
            if(m_Data != null && columnIndex - 1 < m_Data.numAttributes())
    //*  13   26:aload_0         
    //*  14   27:getfield        #35  <Field Instances m_Data>
    //*  15   30:ifnull          338
    //*  16   33:iload_1         
    //*  17   34:iconst_1        
    //*  18   35:isub            
    //*  19   36:aload_0         
    //*  20   37:getfield        #35  <Field Instances m_Data>
    //*  21   40:invokevirtual   #225 <Method int Instances.numAttributes()>
    //*  22   43:icmpge          338
            {
                result = "<html><center>";
    //   23   46:ldc2            #274 <String "<html><center>">
    //   24   49:astore_2        
                if(isClassIndex(columnIndex))
    //*  25   50:aload_0         
    //*  26   51:iload_1         
    //*  27   52:invokespecial   #276 <Method boolean isClassIndex(int)>
    //*  28   55:ifeq            104
                    result = (new StringBuilder(String.valueOf(result))).append("<b>").append(m_Data.attribute(columnIndex - 1).name()).append("</b>").toString();
    //   29   58:new             #205 <Class StringBuilder>
    //   30   61:dup             
    //   31   62:aload_2         
    //   32   63:invokestatic    #209 <Method String String.valueOf(Object)>
    //   33   66:invokespecial   #210 <Method void StringBuilder(String)>
    //   34   69:ldc2            #278 <String "<b>">
    //   35   72:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   36   75:aload_0         
    //   37   76:getfield        #35  <Field Instances m_Data>
    //   38   79:iload_1         
    //   39   80:iconst_1        
    //   40   81:isub            
    //   41   82:invokevirtual   #142 <Method Attribute Instances.attribute(int)>
    //   42   85:invokevirtual   #257 <Method String Attribute.name()>
    //   43   88:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   44   91:ldc2            #280 <String "</b>">
    //   45   94:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   46   97:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   47  100:astore_2        
                else
    //*  48  101:goto            135
                    result = (new StringBuilder(String.valueOf(result))).append(m_Data.attribute(columnIndex - 1).name()).toString();
    //   49  104:new             #205 <Class StringBuilder>
    //   50  107:dup             
    //   51  108:aload_2         
    //   52  109:invokestatic    #209 <Method String String.valueOf(Object)>
    //   53  112:invokespecial   #210 <Method void StringBuilder(String)>
    //   54  115:aload_0         
    //   55  116:getfield        #35  <Field Instances m_Data>
    //   56  119:iload_1         
    //   57  120:iconst_1        
    //   58  121:isub            
    //   59  122:invokevirtual   #142 <Method Attribute Instances.attribute(int)>
    //   60  125:invokevirtual   #257 <Method String Attribute.name()>
    //   61  128:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   62  131:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   63  134:astore_2        
                switch(getType(columnIndex))
    //*  64  135:aload_0         
    //*  65  136:iload_1         
    //*  66  137:invokevirtual   #261 <Method int getType(int)>
                {
    //*  67  140:tableswitch     0 4: default 296
    //                   0 248
    //                   1 200
    //                   2 224
    //                   3 176
    //                   4 272
                case 3: // '\003'
                    result = (new StringBuilder(String.valueOf(result))).append("<br><font size=\"-2\">Date</font>").toString();
    //   68  176:new             #205 <Class StringBuilder>
    //   69  179:dup             
    //   70  180:aload_2         
    //   71  181:invokestatic    #209 <Method String String.valueOf(Object)>
    //   72  184:invokespecial   #210 <Method void StringBuilder(String)>
    //   73  187:ldc2            #282 <String "<br><font size=\"-2\">Date</font>">
    //   74  190:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   75  193:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   76  196:astore_2        
                    break;

    //*  77  197:goto            317
                case 1: // '\001'
                    result = (new StringBuilder(String.valueOf(result))).append("<br><font size=\"-2\">Nominal</font>").toString();
    //   78  200:new             #205 <Class StringBuilder>
    //   79  203:dup             
    //   80  204:aload_2         
    //   81  205:invokestatic    #209 <Method String String.valueOf(Object)>
    //   82  208:invokespecial   #210 <Method void StringBuilder(String)>
    //   83  211:ldc2            #284 <String "<br><font size=\"-2\">Nominal</font>">
    //   84  214:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   85  217:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   86  220:astore_2        
                    break;

    //*  87  221:goto            317
                case 2: // '\002'
                    result = (new StringBuilder(String.valueOf(result))).append("<br><font size=\"-2\">String</font>").toString();
    //   88  224:new             #205 <Class StringBuilder>
    //   89  227:dup             
    //   90  228:aload_2         
    //   91  229:invokestatic    #209 <Method String String.valueOf(Object)>
    //   92  232:invokespecial   #210 <Method void StringBuilder(String)>
    //   93  235:ldc2            #286 <String "<br><font size=\"-2\">String</font>">
    //   94  238:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //   95  241:invokevirtual   #217 <Method String StringBuilder.toString()>
    //   96  244:astore_2        
                    break;

    //*  97  245:goto            317
                case 0: // '\0'
                    result = (new StringBuilder(String.valueOf(result))).append("<br><font size=\"-2\">Numeric</font>").toString();
    //   98  248:new             #205 <Class StringBuilder>
    //   99  251:dup             
    //  100  252:aload_2         
    //  101  253:invokestatic    #209 <Method String String.valueOf(Object)>
    //  102  256:invokespecial   #210 <Method void StringBuilder(String)>
    //  103  259:ldc2            #288 <String "<br><font size=\"-2\">Numeric</font>">
    //  104  262:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  105  265:invokevirtual   #217 <Method String StringBuilder.toString()>
    //  106  268:astore_2        
                    break;

    //* 107  269:goto            317
                case 4: // '\004'
                    result = (new StringBuilder(String.valueOf(result))).append("<br><font size=\"-2\">Relational</font>").toString();
    //  108  272:new             #205 <Class StringBuilder>
    //  109  275:dup             
    //  110  276:aload_2         
    //  111  277:invokestatic    #209 <Method String String.valueOf(Object)>
    //  112  280:invokespecial   #210 <Method void StringBuilder(String)>
    //  113  283:ldc2            #290 <String "<br><font size=\"-2\">Relational</font>">
    //  114  286:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  115  289:invokevirtual   #217 <Method String StringBuilder.toString()>
    //  116  292:astore_2        
                    break;

    //* 117  293:goto            317
                default:
                    result = (new StringBuilder(String.valueOf(result))).append("<br><font size=\"-2\">???</font>").toString();
    //  118  296:new             #205 <Class StringBuilder>
    //  119  299:dup             
    //  120  300:aload_2         
    //  121  301:invokestatic    #209 <Method String String.valueOf(Object)>
    //  122  304:invokespecial   #210 <Method void StringBuilder(String)>
    //  123  307:ldc2            #292 <String "<br><font size=\"-2\">???</font>">
    //  124  310:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  125  313:invokevirtual   #217 <Method String StringBuilder.toString()>
    //  126  316:astore_2        
                    break;
                }
                result = (new StringBuilder(String.valueOf(result))).append("</center></html>").toString();
    //  127  317:new             #205 <Class StringBuilder>
    //  128  320:dup             
    //  129  321:aload_2         
    //  130  322:invokestatic    #209 <Method String String.valueOf(Object)>
    //  131  325:invokespecial   #210 <Method void StringBuilder(String)>
    //  132  328:ldc2            #294 <String "</center></html>">
    //  133  331:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  134  334:invokevirtual   #217 <Method String StringBuilder.toString()>
    //  135  337:astore_2        
            }
        return result;
    //  136  338:aload_2         
    //  137  339:areturn         
    }

    public int getRowCount()
    {
        if(m_Data == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #35  <Field Instances m_Data>
    //*   2    4:ifnonnull       9
            return 0;
    //    3    7:iconst_0        
    //    4    8:ireturn         
        else
            return m_Data.numInstances();
    //    5    9:aload_0         
    //    6   10:getfield        #35  <Field Instances m_Data>
    //    7   13:invokevirtual   #297 <Method int Instances.numInstances()>
    //    8   16:ireturn         
    }

    public boolean isMissingAt(int rowIndex, int columnIndex)
    {
        boolean result = false;
    //    0    0:iconst_0        
    //    1    1:istore_3        
        if(rowIndex >= 0 && rowIndex < getRowCount() && columnIndex > 0 && columnIndex < getColumnCount())
    //*   2    2:iload_1         
    //*   3    3:iflt            41
    //*   4    6:iload_1         
    //*   5    7:aload_0         
    //*   6    8:invokevirtual   #152 <Method int getRowCount()>
    //*   7   11:icmpge          41
    //*   8   14:iload_2         
    //*   9   15:ifle            41
    //*  10   18:iload_2         
    //*  11   19:aload_0         
    //*  12   20:invokevirtual   #137 <Method int getColumnCount()>
    //*  13   23:icmpge          41
            result = m_Data.instance(rowIndex).isMissing(columnIndex - 1);
    //   14   26:aload_0         
    //   15   27:getfield        #35  <Field Instances m_Data>
    //   16   30:iload_1         
    //   17   31:invokevirtual   #156 <Method Instance Instances.instance(int)>
    //   18   34:iload_2         
    //   19   35:iconst_1        
    //   20   36:isub            
    //   21   37:invokevirtual   #302 <Method boolean Instance.isMissing(int)>
    //   22   40:istore_3        
        return result;
    //   23   41:iload_3         
    //   24   42:ireturn         
    }

    public double getInstancesValueAt(int rowIndex, int columnIndex)
    {
        double result = -1D;
    //    0    0:ldc2w           #305 <Double -1D>
    //    1    3:dstore_3        
        if(rowIndex >= 0 && rowIndex < getRowCount() && columnIndex > 0 && columnIndex < getColumnCount())
    //*   2    4:iload_1         
    //*   3    5:iflt            43
    //*   4    8:iload_1         
    //*   5    9:aload_0         
    //*   6   10:invokevirtual   #152 <Method int getRowCount()>
    //*   7   13:icmpge          43
    //*   8   16:iload_2         
    //*   9   17:ifle            43
    //*  10   20:iload_2         
    //*  11   21:aload_0         
    //*  12   22:invokevirtual   #137 <Method int getColumnCount()>
    //*  13   25:icmpge          43
            result = m_Data.instance(rowIndex).value(columnIndex - 1);
    //   14   28:aload_0         
    //   15   29:getfield        #35  <Field Instances m_Data>
    //   16   32:iload_1         
    //   17   33:invokevirtual   #156 <Method Instance Instances.instance(int)>
    //   18   36:iload_2         
    //   19   37:iconst_1        
    //   20   38:isub            
    //   21   39:invokevirtual   #309 <Method double Instance.value(int)>
    //   22   42:dstore_3        
        return result;
    //   23   43:dload_3         
    //   24   44:dreturn         
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object result = null;
    //    0    0:aconst_null     
    //    1    1:astore_3        
        if(rowIndex >= 0 && rowIndex < getRowCount() && columnIndex >= 0 && columnIndex < getColumnCount())
    //*   2    2:iload_1         
    //*   3    3:iflt            143
    //*   4    6:iload_1         
    //*   5    7:aload_0         
    //*   6    8:invokevirtual   #152 <Method int getRowCount()>
    //*   7   11:icmpge          143
    //*   8   14:iload_2         
    //*   9   15:iflt            143
    //*  10   18:iload_2         
    //*  11   19:aload_0         
    //*  12   20:invokevirtual   #137 <Method int getColumnCount()>
    //*  13   23:icmpge          143
            if(columnIndex == 0)
    //*  14   26:iload_2         
    //*  15   27:ifne            44
                result = new Integer(rowIndex + 1);
    //   16   30:new             #219 <Class Integer>
    //   17   33:dup             
    //   18   34:iload_1         
    //   19   35:iconst_1        
    //   20   36:iadd            
    //   21   37:invokespecial   #314 <Method void Integer(int)>
    //   22   40:astore_3        
            else
    //*  23   41:goto            143
            if(isMissingAt(rowIndex, columnIndex))
    //*  24   44:aload_0         
    //*  25   45:iload_1         
    //*  26   46:iload_2         
    //*  27   47:invokevirtual   #316 <Method boolean isMissingAt(int, int)>
    //*  28   50:ifeq            58
                result = null;
    //   29   53:aconst_null     
    //   30   54:astore_3        
            else
    //*  31   55:goto            143
                switch(getType(columnIndex))
    //*  32   58:aload_0         
    //*  33   59:iload_2         
    //*  34   60:invokevirtual   #261 <Method int getType(int)>
                {
    //*  35   63:tableswitch     0 4: default 139
    //                   0 114
    //                   1 96
    //                   2 96
    //                   3 96
    //                   4 96
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    result = m_Data.instance(rowIndex).stringValue(columnIndex - 1);
    //   36   96:aload_0         
    //   37   97:getfield        #35  <Field Instances m_Data>
    //   38  100:iload_1         
    //   39  101:invokevirtual   #156 <Method Instance Instances.instance(int)>
    //   40  104:iload_2         
    //   41  105:iconst_1        
    //   42  106:isub            
    //   43  107:invokevirtual   #319 <Method String Instance.stringValue(int)>
    //   44  110:astore_3        
                    break;

    //*  45  111:goto            143
                case 0: // '\0'
                    result = new Double(m_Data.instance(rowIndex).value(columnIndex - 1));
    //   46  114:new             #263 <Class Double>
    //   47  117:dup             
    //   48  118:aload_0         
    //   49  119:getfield        #35  <Field Instances m_Data>
    //   50  122:iload_1         
    //   51  123:invokevirtual   #156 <Method Instance Instances.instance(int)>
    //   52  126:iload_2         
    //   53  127:iconst_1        
    //   54  128:isub            
    //   55  129:invokevirtual   #309 <Method double Instance.value(int)>
    //   56  132:invokespecial   #322 <Method void Double(double)>
    //   57  135:astore_3        
                    break;

    //*  58  136:goto            143
                default:
                    result = "-can't display-";
    //   59  139:ldc2            #324 <String "-can't display-">
    //   60  142:astore_3        
                    break;
                }
        if(getType(columnIndex) != 0 && result != null)
    //*  61  143:aload_0         
    //*  62  144:iload_2         
    //*  63  145:invokevirtual   #261 <Method int getType(int)>
    //*  64  148:ifeq            249
    //*  65  151:aload_3         
    //*  66  152:ifnull          249
        {
            String tmp = result.toString();
    //   67  155:aload_3         
    //   68  156:invokevirtual   #325 <Method String Object.toString()>
    //   69  159:astore          4
            if(tmp.indexOf("\n") > -1 || tmp.indexOf("\r") > -1)
    //*  70  161:aload           4
    //*  71  163:ldc2            #327 <String "\n">
    //*  72  166:invokevirtual   #330 <Method int String.indexOf(String)>
    //*  73  169:iconst_m1       
    //*  74  170:icmpgt          185
    //*  75  173:aload           4
    //*  76  175:ldc2            #332 <String "\r">
    //*  77  178:invokevirtual   #330 <Method int String.indexOf(String)>
    //*  78  181:iconst_m1       
    //*  79  182:icmple          249
            {
                tmp = tmp.replaceAll("\\r\\n", "<font color=\"red\"><b>\\\\r\\\\n</b></font>");
    //   80  185:aload           4
    //   81  187:ldc2            #334 <String "\\r\\n">
    //   82  190:ldc2            #336 <String "<font color=\"red\"><b>\\\\r\\\\n</b></font>">
    //   83  193:invokevirtual   #340 <Method String String.replaceAll(String, String)>
    //   84  196:astore          4
                tmp = tmp.replaceAll("\\r", "<font color=\"red\"><b>\\\\r</b></font>");
    //   85  198:aload           4
    //   86  200:ldc2            #342 <String "\\r">
    //   87  203:ldc2            #344 <String "<font color=\"red\"><b>\\\\r</b></font>">
    //   88  206:invokevirtual   #340 <Method String String.replaceAll(String, String)>
    //   89  209:astore          4
                tmp = tmp.replaceAll("\\n", "<font color=\"red\"><b>\\\\n</b></font>");
    //   90  211:aload           4
    //   91  213:ldc2            #346 <String "\\n">
    //   92  216:ldc2            #348 <String "<font color=\"red\"><b>\\\\n</b></font>">
    //   93  219:invokevirtual   #340 <Method String String.replaceAll(String, String)>
    //   94  222:astore          4
                result = (new StringBuilder("<html>")).append(tmp).append("</html>").toString();
    //   95  224:new             #205 <Class StringBuilder>
    //   96  227:dup             
    //   97  228:ldc2            #350 <String "<html>">
    //   98  231:invokespecial   #210 <Method void StringBuilder(String)>
    //   99  234:aload           4
    //  100  236:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  101  239:ldc2            #352 <String "</html>">
    //  102  242:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  103  245:invokevirtual   #217 <Method String StringBuilder.toString()>
    //  104  248:astore_3        
            }
        }
        return result;
    //  105  249:aload_3         
    //  106  250:areturn         
    }

    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex > 0 && !isReadOnly();
    //    0    0:iload_2         
    //    1    1:ifle            13
    //    2    4:aload_0         
    //    3    5:invokevirtual   #357 <Method boolean isReadOnly()>
    //    4    8:ifne            13
    //    5   11:iconst_1        
    //    6   12:ireturn         
    //    7   13:iconst_0        
    //    8   14:ireturn         
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        setValueAt(aValue, rowIndex, columnIndex, true);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iload_2         
    //    3    3:iload_3         
    //    4    4:iconst_1        
    //    5    5:invokevirtual   #362 <Method void setValueAt(Object, int, int, boolean)>
    //    6    8:return          
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex, boolean notify)
    {
        if(!m_IgnoreChanges)
    //*   0    0:aload_0         
    //*   1    1:getfield        #44  <Field boolean m_IgnoreChanges>
    //*   2    4:ifne            11
            addUndoPoint();
    //    3    7:aload_0         
    //    4    8:invokevirtual   #174 <Method void addUndoPoint()>
        Object oldValue = getValueAt(rowIndex, columnIndex);
    //    5   11:aload_0         
    //    6   12:iload_2         
    //    7   13:iload_3         
    //    8   14:invokevirtual   #365 <Method Object getValueAt(int, int)>
    //    9   17:astore          10
        int type = getType(rowIndex, columnIndex);
    //   10   19:aload_0         
    //   11   20:iload_2         
    //   12   21:iload_3         
    //   13   22:invokevirtual   #149 <Method int getType(int, int)>
    //   14   25:istore          5
        int index = columnIndex - 1;
    //   15   27:iload_3         
    //   16   28:iconst_1        
    //   17   29:isub            
    //   18   30:istore          6
        Instance inst = m_Data.instance(rowIndex);
    //   19   32:aload_0         
    //   20   33:getfield        #35  <Field Instances m_Data>
    //   21   36:iload_2         
    //   22   37:invokevirtual   #156 <Method Instance Instances.instance(int)>
    //   23   40:astore          8
        Attribute att = inst.attribute(index);
    //   24   42:aload           8
    //   25   44:iload           6
    //   26   46:invokevirtual   #159 <Method Attribute Instance.attribute(int)>
    //   27   49:astore          9
        if(aValue == null)
    //*  28   51:aload_1         
    //*  29   52:ifnonnull       68
        {
            inst.setValue(index, Instance.missingValue());
    //   30   55:aload           8
    //   31   57:iload           6
    //   32   59:invokestatic    #369 <Method double Instance.missingValue()>
    //   33   62:invokevirtual   #373 <Method void Instance.setValue(int, double)>
        } else
    //*  34   65:goto            271
        {
            String tmp = aValue.toString();
    //   35   68:aload_1         
    //   36   69:invokevirtual   #325 <Method String Object.toString()>
    //   37   72:astore          7
            switch(type)
    //*  38   74:iload           5
            {
    //*  39   76:tableswitch     0 4: default 239
    //                   0 183
    //                   1 142
    //                   2 171
    //                   3 112
    //                   4 209
            case 3: // '\003'
                try
                {
                    att.parseDate(tmp);
    //   40  112:aload           9
    //   41  114:aload           7
    //   42  116:invokevirtual   #377 <Method double Attribute.parseDate(String)>
    //   43  119:pop2            
                    inst.setValue(index, att.parseDate(tmp));
    //   44  120:aload           8
    //   45  122:iload           6
    //   46  124:aload           9
    //   47  126:aload           7
    //   48  128:invokevirtual   #377 <Method double Attribute.parseDate(String)>
    //   49  131:invokevirtual   #373 <Method void Instance.setValue(int, double)>
                    break;
    //   50  134:goto            271
                }
                catch(Exception exception) { }
    //   51  137:astore          11
                break;
    //   52  139:goto            271

            case 1: // '\001'
                if(att.indexOfValue(tmp) > -1)
    //*  53  142:aload           9
    //*  54  144:aload           7
    //*  55  146:invokevirtual   #380 <Method int Attribute.indexOfValue(String)>
    //*  56  149:iconst_m1       
    //*  57  150:icmple          271
                    inst.setValue(index, att.indexOfValue(tmp));
    //   58  153:aload           8
    //   59  155:iload           6
    //   60  157:aload           9
    //   61  159:aload           7
    //   62  161:invokevirtual   #380 <Method int Attribute.indexOfValue(String)>
    //   63  164:i2d             
    //   64  165:invokevirtual   #373 <Method void Instance.setValue(int, double)>
                break;
    //   65  168:goto            271

            case 2: // '\002'
                inst.setValue(index, tmp);
    //   66  171:aload           8
    //   67  173:iload           6
    //   68  175:aload           7
    //   69  177:invokevirtual   #382 <Method void Instance.setValue(int, String)>
                break;
    //   70  180:goto            271

            case 0: // '\0'
                try
                {
                    Double.parseDouble(tmp);
    //   71  183:aload           7
    //   72  185:invokestatic    #385 <Method double Double.parseDouble(String)>
    //   73  188:pop2            
                    inst.setValue(index, Double.parseDouble(tmp));
    //   74  189:aload           8
    //   75  191:iload           6
    //   76  193:aload           7
    //   77  195:invokestatic    #385 <Method double Double.parseDouble(String)>
    //   78  198:invokevirtual   #373 <Method void Instance.setValue(int, double)>
                    break;
    //   79  201:goto            271
                }
                catch(Exception exception1) { }
    //   80  204:astore          11
                break;
    //   81  206:goto            271

            case 4: // '\004'
                try
                {
                    inst.setValue(index, inst.attribute(index).addRelation((Instances)aValue));
    //   82  209:aload           8
    //   83  211:iload           6
    //   84  213:aload           8
    //   85  215:iload           6
    //   86  217:invokevirtual   #159 <Method Attribute Instance.attribute(int)>
    //   87  220:aload_1         
    //   88  221:checkcast       #139 <Class Instances>
    //   89  224:invokevirtual   #389 <Method int Attribute.addRelation(Instances)>
    //   90  227:i2d             
    //   91  228:invokevirtual   #373 <Method void Instance.setValue(int, double)>
                    break;
    //   92  231:goto            271
                }
                catch(Exception exception2) { }
    //   93  234:astore          11
                break;

    //*  94  236:goto            271
            default:
                throw new IllegalArgumentException((new StringBuilder("Unsupported Attribute type: ")).append(type).append("!").toString());
    //   95  239:new             #391 <Class IllegalArgumentException>
    //   96  242:dup             
    //   97  243:new             #205 <Class StringBuilder>
    //   98  246:dup             
    //   99  247:ldc2            #393 <String "Unsupported Attribute type: ">
    //  100  250:invokespecial   #210 <Method void StringBuilder(String)>
    //  101  253:iload           5
    //  102  255:invokevirtual   #396 <Method StringBuilder StringBuilder.append(int)>
    //  103  258:ldc2            #398 <String "!">
    //  104  261:invokevirtual   #216 <Method StringBuilder StringBuilder.append(String)>
    //  105  264:invokevirtual   #217 <Method String StringBuilder.toString()>
    //  106  267:invokespecial   #399 <Method void IllegalArgumentException(String)>
    //  107  270:athrow          
            }
        }
        if(notify && !(new StringBuilder()).append(oldValue).toString().equals((new StringBuilder()).append(aValue).toString()))
    //* 108  271:iload           4
    //* 109  273:ifeq            325
    //* 110  276:new             #205 <Class StringBuilder>
    //* 111  279:dup             
    //* 112  280:invokespecial   #400 <Method void StringBuilder()>
    //* 113  283:aload           10
    //* 114  285:invokevirtual   #403 <Method StringBuilder StringBuilder.append(Object)>
    //* 115  288:invokevirtual   #217 <Method String StringBuilder.toString()>
    //* 116  291:new             #205 <Class StringBuilder>
    //* 117  294:dup             
    //* 118  295:invokespecial   #400 <Method void StringBuilder()>
    //* 119  298:aload_1         
    //* 120  299:invokevirtual   #403 <Method StringBuilder StringBuilder.append(Object)>
    //* 121  302:invokevirtual   #217 <Method String StringBuilder.toString()>
    //* 122  305:invokevirtual   #62  <Method boolean String.equals(Object)>
    //* 123  308:ifne            325
            notifyListener(new TableModelEvent(this, rowIndex, columnIndex));
    //  124  311:aload_0         
    //  125  312:new             #178 <Class TableModelEvent>
    //  126  315:dup             
    //  127  316:aload_0         
    //  128  317:iload_2         
    //  129  318:iload_3         
    //  130  319:invokespecial   #406 <Method void TableModelEvent(TableModel, int, int)>
    //  131  322:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
    //  132  325:return          
    }

    public void addTableModelListener(TableModelListener l)
    {
        m_Listeners.add(l);
    //    0    0:aload_0         
    //    1    1:getfield        #33  <Field HashSet m_Listeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #416 <Method boolean HashSet.add(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    public void removeTableModelListener(TableModelListener l)
    {
        m_Listeners.remove(l);
    //    0    0:aload_0         
    //    1    1:getfield        #33  <Field HashSet m_Listeners>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #422 <Method boolean HashSet.remove(Object)>
    //    4    8:pop             
    //    5    9:return          
    }

    public void notifyListener(TableModelEvent e)
    {
        if(!isNotificationEnabled())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #424 <Method boolean isNotificationEnabled()>
    //*   2    4:ifne            8
            return;
    //    3    7:return          
        TableModelListener l;
        for(Iterator iter = m_Listeners.iterator(); iter.hasNext(); l.tableChanged(e))
    //*   4    8:aload_0         
    //*   5    9:getfield        #33  <Field HashSet m_Listeners>
    //*   6   12:invokevirtual   #428 <Method Iterator HashSet.iterator()>
    //*   7   15:astore_2        
    //*   8   16:goto            39
            l = (TableModelListener)(TableModelListener)iter.next();
    //    9   19:aload_2         
    //   10   20:invokeinterface #434 <Method Object Iterator.next()>
    //   11   25:checkcast       #436 <Class TableModelListener>
    //   12   28:checkcast       #436 <Class TableModelListener>
    //   13   31:astore_3        

    //   14   32:aload_3         
    //   15   33:aload_1         
    //   16   34:invokeinterface #439 <Method void TableModelListener.tableChanged(TableModelEvent)>
    //   17   39:aload_2         
    //   18   40:invokeinterface #442 <Method boolean Iterator.hasNext()>
    //   19   45:ifne            19
    //   20   48:return          
    }

    public void clearUndo()
    {
        m_UndoList = new Vector();
    //    0    0:aload_0         
    //    1    1:new             #39  <Class Vector>
    //    2    4:dup             
    //    3    5:invokespecial   #40  <Method void Vector()>
    //    4    8:putfield        #42  <Field Vector m_UndoList>
    //    5   11:return          
    }

    public boolean canUndo()
    {
        return !m_UndoList.isEmpty();
    //    0    0:aload_0         
    //    1    1:getfield        #42  <Field Vector m_UndoList>
    //    2    4:invokevirtual   #450 <Method boolean Vector.isEmpty()>
    //    3    7:ifeq            14
    //    4   10:iconst_0        
    //    5   11:goto            15
    //    6   14:iconst_1        
    //    7   15:ireturn         
    }

    public void undo()
    {
        if(canUndo())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #452 <Method boolean canUndo()>
    //*   2    4:ifeq            127
        {
            File tempFile = (File)(File)m_UndoList.get(m_UndoList.size() - 1);
    //    3    7:aload_0         
    //    4    8:getfield        #42  <Field Vector m_UndoList>
    //    5   11:aload_0         
    //    6   12:getfield        #42  <Field Vector m_UndoList>
    //    7   15:invokevirtual   #455 <Method int Vector.size()>
    //    8   18:iconst_1        
    //    9   19:isub            
    //   10   20:invokevirtual   #459 <Method Object Vector.get(int)>
    //   11   23:checkcast       #87  <Class File>
    //   12   26:checkcast       #87  <Class File>
    //   13   29:astore_1        
            try
            {
                ObjectInputStream ooi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(tempFile)));
    //   14   30:new             #461 <Class ObjectInputStream>
    //   15   33:dup             
    //   16   34:new             #463 <Class BufferedInputStream>
    //   17   37:dup             
    //   18   38:new             #465 <Class FileInputStream>
    //   19   41:dup             
    //   20   42:aload_1         
    //   21   43:invokespecial   #467 <Method void FileInputStream(File)>
    //   22   46:invokespecial   #470 <Method void BufferedInputStream(java.io.InputStream)>
    //   23   49:invokespecial   #471 <Method void ObjectInputStream(java.io.InputStream)>
    //   24   52:astore_3        
                Instances inst = (Instances)ooi.readObject();
    //   25   53:aload_3         
    //   26   54:invokevirtual   #474 <Method Object ObjectInputStream.readObject()>
    //   27   57:checkcast       #139 <Class Instances>
    //   28   60:astore_2        
                ooi.close();
    //   29   61:aload_3         
    //   30   62:invokevirtual   #477 <Method void ObjectInputStream.close()>
                setInstances(inst);
    //   31   65:aload_0         
    //   32   66:aload_2         
    //   33   67:invokevirtual   #479 <Method void setInstances(Instances)>
                notifyListener(new TableModelEvent(this, -1));
    //   34   70:aload_0         
    //   35   71:new             #178 <Class TableModelEvent>
    //   36   74:dup             
    //   37   75:aload_0         
    //   38   76:iconst_m1       
    //   39   77:invokespecial   #181 <Method void TableModelEvent(TableModel, int)>
    //   40   80:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
                notifyListener(new TableModelEvent(this));
    //   41   83:aload_0         
    //   42   84:new             #178 <Class TableModelEvent>
    //   43   87:dup             
    //   44   88:aload_0         
    //   45   89:invokespecial   #252 <Method void TableModelEvent(TableModel)>
    //   46   92:invokevirtual   #185 <Method void notifyListener(TableModelEvent)>
            }
    //*  47   95:goto            105
            catch(Exception e)
    //*  48   98:astore          4
            {
                e.printStackTrace();
    //   49  100:aload           4
    //   50  102:invokevirtual   #231 <Method void Exception.printStackTrace()>
            }
            tempFile.delete();
    //   51  105:aload_1         
    //   52  106:invokevirtual   #481 <Method boolean File.delete()>
    //   53  109:pop             
            m_UndoList.remove(m_UndoList.size() - 1);
    //   54  110:aload_0         
    //   55  111:getfield        #42  <Field Vector m_UndoList>
    //   56  114:aload_0         
    //   57  115:getfield        #42  <Field Vector m_UndoList>
    //   58  118:invokevirtual   #455 <Method int Vector.size()>
    //   59  121:iconst_1        
    //   60  122:isub            
    //   61  123:invokevirtual   #483 <Method Object Vector.remove(int)>
    //   62  126:pop             
        }
    //   63  127:return          
    }

    public void addUndoPoint()
    {
        if(!isUndoEnabled())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #489 <Method boolean isUndoEnabled()>
    //*   2    4:ifne            8
            return;
    //    3    7:return          
        if(getInstances() != null)
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #491 <Method Instances getInstances()>
    //*   6   12:ifnull          83
            try
            {
                File tempFile = File.createTempFile("arffviewer", null);
    //    7   15:ldc2            #493 <String "arffviewer">
    //    8   18:aconst_null     
    //    9   19:invokestatic    #497 <Method File File.createTempFile(String, String)>
    //   10   22:astore_1        
                tempFile.deleteOnExit();
    //   11   23:aload_1         
    //   12   24:invokevirtual   #500 <Method void File.deleteOnExit()>
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(tempFile)));
    //   13   27:new             #502 <Class ObjectOutputStream>
    //   14   30:dup             
    //   15   31:new             #504 <Class BufferedOutputStream>
    //   16   34:dup             
    //   17   35:new             #506 <Class FileOutputStream>
    //   18   38:dup             
    //   19   39:aload_1         
    //   20   40:invokespecial   #507 <Method void FileOutputStream(File)>
    //   21   43:invokespecial   #510 <Method void BufferedOutputStream(java.io.OutputStream)>
    //   22   46:invokespecial   #511 <Method void ObjectOutputStream(java.io.OutputStream)>
    //   23   49:astore_2        
                oos.writeObject(getInstances());
    //   24   50:aload_2         
    //   25   51:aload_0         
    //   26   52:invokevirtual   #491 <Method Instances getInstances()>
    //   27   55:invokevirtual   #514 <Method void ObjectOutputStream.writeObject(Object)>
                oos.flush();
    //   28   58:aload_2         
    //   29   59:invokevirtual   #517 <Method void ObjectOutputStream.flush()>
                oos.close();
    //   30   62:aload_2         
    //   31   63:invokevirtual   #518 <Method void ObjectOutputStream.close()>
                m_UndoList.add(tempFile);
    //   32   66:aload_0         
    //   33   67:getfield        #42  <Field Vector m_UndoList>
    //   34   70:aload_1         
    //   35   71:invokevirtual   #519 <Method boolean Vector.add(Object)>
    //   36   74:pop             
            }
    //*  37   75:goto            83
            catch(Exception e)
    //*  38   78:astore_3        
            {
                e.printStackTrace();
    //   39   79:aload_3         
    //   40   80:invokevirtual   #231 <Method void Exception.printStackTrace()>
            }
    //   41   83:return          
    }

    private HashSet m_Listeners;
    private Instances m_Data;
    private boolean m_NotificationEnabled;
    private boolean m_UndoEnabled;
    private boolean m_IgnoreChanges;
    private Vector m_UndoList;
    private boolean m_ReadOnly;
    static Class class$0;
    static Class class$1;
    static Class class$2;
}

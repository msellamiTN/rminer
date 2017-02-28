// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   JTableHelper.java

package rm.gui;

import java.awt.*;
import java.io.PrintStream;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.*;

public class JTableHelper
{

    public JTableHelper(JTable jtable)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #12  <Method void Object()>
        this.jtable = jtable;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #14  <Field JTable jtable>
    //    5    9:return          
    }

    public JTable getJTable()
    {
        return jtable;
    //    0    0:aload_0         
    //    1    1:getfield        #14  <Field JTable jtable>
    //    2    4:areturn         
    }

    public int calcColumnWidth(int col)
    {
        return calcColumnWidth(getJTable(), col);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:iload_1         
    //    3    5:invokestatic    #27  <Method int calcColumnWidth(JTable, int)>
    //    4    8:ireturn         
    }

    public static int calcColumnWidth(JTable table, int col)
    {
        int width = calcHeaderWidth(table, col);
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:invokestatic    #32  <Method int calcHeaderWidth(JTable, int)>
    //    3    5:istore_2        
        if(width == -1)
    //*   4    6:iload_2         
    //*   5    7:iconst_m1       
    //*   6    8:icmpne          13
            return width;
    //    7   11:iload_2         
    //    8   12:ireturn         
        TableColumnModel columns = table.getColumnModel();
    //    9   13:aload_0         
    //   10   14:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //   11   17:astore_3        
        TableModel data = table.getModel();
    //   12   18:aload_0         
    //   13   19:invokevirtual   #42  <Method TableModel JTable.getModel()>
    //   14   22:astore          4
        int rowCount = data.getRowCount();
    //   15   24:aload           4
    //   16   26:invokeinterface #48  <Method int TableModel.getRowCount()>
    //   17   31:istore          5
        TableColumn column = columns.getColumn(col);
    //   18   33:aload_3         
    //   19   34:iload_1         
    //   20   35:invokeinterface #54  <Method TableColumn TableColumnModel.getColumn(int)>
    //   21   40:astore          6
        try
        {
            for(int row = rowCount - 1; row >= 0; row--)
    //*  22   42:iload           5
    //*  23   44:iconst_1        
    //*  24   45:isub            
    //*  25   46:istore          7
    //*  26   48:goto            86
            {
                Component c = table.prepareRenderer(table.getCellRenderer(row, col), row, col);
    //   27   51:aload_0         
    //   28   52:aload_0         
    //   29   53:iload           7
    //   30   55:iload_1         
    //   31   56:invokevirtual   #58  <Method TableCellRenderer JTable.getCellRenderer(int, int)>
    //   32   59:iload           7
    //   33   61:iload_1         
    //   34   62:invokevirtual   #62  <Method Component JTable.prepareRenderer(TableCellRenderer, int, int)>
    //   35   65:astore          8
                width = Math.max(width, c.getPreferredSize().width + 10);
    //   36   67:iload_2         
    //   37   68:aload           8
    //   38   70:invokevirtual   #68  <Method Dimension Component.getPreferredSize()>
    //   39   73:getfield        #73  <Field int Dimension.width>
    //   40   76:bipush          10
    //   41   78:iadd            
    //   42   79:invokestatic    #79  <Method int Math.max(int, int)>
    //   43   82:istore_2        
            }

    //   44   83:iinc            7  -1
    //   45   86:iload           7
    //   46   88:ifge            51
        }
    //*  47   91:goto            101
        catch(Exception e)
    //*  48   94:astore          7
        {
            e.printStackTrace();
    //   49   96:aload           7
    //   50   98:invokevirtual   #84  <Method void Exception.printStackTrace()>
        }
        return width;
    //   51  101:iload_2         
    //   52  102:ireturn         
    }

    public int calcHeaderWidth(int col)
    {
        return calcHeaderWidth(getJTable(), col);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:iload_1         
    //    3    5:invokestatic    #32  <Method int calcHeaderWidth(JTable, int)>
    //    4    8:ireturn         
    }

    public static int calcHeaderWidth(JTable table, int col)
    {
        if(table == null)
    //*   0    0:aload_0         
    //*   1    1:ifnonnull       6
            return -1;
    //    2    4:iconst_m1       
    //    3    5:ireturn         
        if(col < 0 || col > table.getColumnCount())
    //*   4    6:iload_1         
    //*   5    7:iflt            18
    //*   6   10:iload_1         
    //*   7   11:aload_0         
    //*   8   12:invokevirtual   #100 <Method int JTable.getColumnCount()>
    //*   9   15:icmple          42
        {
            System.out.println((new StringBuilder("invalid col ")).append(col).toString());
    //   10   18:getstatic       #106 <Field PrintStream System.out>
    //   11   21:new             #108 <Class StringBuilder>
    //   12   24:dup             
    //   13   25:ldc1            #110 <String "invalid col ">
    //   14   27:invokespecial   #113 <Method void StringBuilder(String)>
    //   15   30:iload_1         
    //   16   31:invokevirtual   #117 <Method StringBuilder StringBuilder.append(int)>
    //   17   34:invokevirtual   #121 <Method String StringBuilder.toString()>
    //   18   37:invokevirtual   #126 <Method void PrintStream.println(String)>
            return -1;
    //   19   40:iconst_m1       
    //   20   41:ireturn         
        }
        JTableHeader header = table.getTableHeader();
    //   21   42:aload_0         
    //   22   43:invokevirtual   #130 <Method JTableHeader JTable.getTableHeader()>
    //   23   46:astore_2        
        TableCellRenderer defaultHeaderRenderer = null;
    //   24   47:aconst_null     
    //   25   48:astore_3        
        if(header != null)
    //*  26   49:aload_2         
    //*  27   50:ifnull          58
            defaultHeaderRenderer = header.getDefaultRenderer();
    //   28   53:aload_2         
    //   29   54:invokevirtual   #136 <Method TableCellRenderer JTableHeader.getDefaultRenderer()>
    //   30   57:astore_3        
        TableColumnModel columns = table.getColumnModel();
    //   31   58:aload_0         
    //   32   59:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //   33   62:astore          4
        TableModel data = table.getModel();
    //   34   64:aload_0         
    //   35   65:invokevirtual   #42  <Method TableModel JTable.getModel()>
    //   36   68:astore          5
        TableColumn column = columns.getColumn(col);
    //   37   70:aload           4
    //   38   72:iload_1         
    //   39   73:invokeinterface #54  <Method TableColumn TableColumnModel.getColumn(int)>
    //   40   78:astore          6
        int width = -1;
    //   41   80:iconst_m1       
    //   42   81:istore          7
        TableCellRenderer h = column.getHeaderRenderer();
    //   43   83:aload           6
    //   44   85:invokevirtual   #141 <Method TableCellRenderer TableColumn.getHeaderRenderer()>
    //   45   88:astore          8
        if(h == null)
    //*  46   90:aload           8
    //*  47   92:ifnonnull       98
            h = defaultHeaderRenderer;
    //   48   95:aload_3         
    //   49   96:astore          8
        if(h != null)
    //*  50   98:aload           8
    //*  51  100:ifnull          134
        {
            Component c = h.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, -1, col);
    //   52  103:aload           8
    //   53  105:aload_0         
    //   54  106:aload           6
    //   55  108:invokevirtual   #145 <Method Object TableColumn.getHeaderValue()>
    //   56  111:iconst_0        
    //   57  112:iconst_0        
    //   58  113:iconst_m1       
    //   59  114:iload_1         
    //   60  115:invokeinterface #151 <Method Component TableCellRenderer.getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)>
    //   61  120:astore          9
            width = c.getPreferredSize().width + 5;
    //   62  122:aload           9
    //   63  124:invokevirtual   #68  <Method Dimension Component.getPreferredSize()>
    //   64  127:getfield        #73  <Field int Dimension.width>
    //   65  130:iconst_5        
    //   66  131:iadd            
    //   67  132:istore          7
        }
        return width;
    //   68  134:iload           7
    //   69  136:ireturn         
    }

    public void setOptimalColumnWidth(int col)
    {
        setOptimalColumnWidth(getJTable(), col);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:iload_1         
    //    3    5:invokestatic    #161 <Method void setOptimalColumnWidth(JTable, int)>
    //    4    8:return          
    }

    public static void setOptimalColumnWidth(JTable jtable, int col)
    {
        if(col >= 0 && col < jtable.getColumnModel().getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:iflt            59
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //*   5    9:invokeinterface #162 <Method int TableColumnModel.getColumnCount()>
    //*   6   14:icmpge          59
        {
            int width = calcColumnWidth(jtable, col);
    //    7   17:aload_0         
    //    8   18:iload_1         
    //    9   19:invokestatic    #27  <Method int calcColumnWidth(JTable, int)>
    //   10   22:istore_2        
            if(width >= 0)
    //*  11   23:iload_2         
    //*  12   24:iflt            59
            {
                JTableHeader header = jtable.getTableHeader();
    //   13   27:aload_0         
    //   14   28:invokevirtual   #130 <Method JTableHeader JTable.getTableHeader()>
    //   15   31:astore          4
                TableColumn column = jtable.getColumnModel().getColumn(col);
    //   16   33:aload_0         
    //   17   34:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //   18   37:iload_1         
    //   19   38:invokeinterface #54  <Method TableColumn TableColumnModel.getColumn(int)>
    //   20   43:astore_3        
                column.setPreferredWidth(width);
    //   21   44:aload_3         
    //   22   45:iload_2         
    //   23   46:invokevirtual   #165 <Method void TableColumn.setPreferredWidth(int)>
                jtable.sizeColumnsToFit(-1);
    //   24   49:aload_0         
    //   25   50:iconst_m1       
    //   26   51:invokevirtual   #168 <Method void JTable.sizeColumnsToFit(int)>
                header.repaint();
    //   27   54:aload           4
    //   28   56:invokevirtual   #171 <Method void JTableHeader.repaint()>
            }
        }
    //   29   59:return          
    }

    public void setOptimalColumnWidth()
    {
        setOptimalColumnWidth(getJTable());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:invokestatic    #173 <Method void setOptimalColumnWidth(JTable)>
    //    3    7:return          
    }

    public static void setOptimalColumnWidth(JTable jtable)
    {
        for(int i = 0; i < jtable.getColumnModel().getColumnCount(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            13
            setOptimalColumnWidth(jtable, i);
    //    3    5:aload_0         
    //    4    6:iload_1         
    //    5    7:invokestatic    #161 <Method void setOptimalColumnWidth(JTable, int)>

    //    6   10:iinc            1  1
    //    7   13:iload_1         
    //    8   14:aload_0         
    //    9   15:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //   10   18:invokeinterface #162 <Method int TableColumnModel.getColumnCount()>
    //   11   23:icmplt          5
    //   12   26:return          
    }

    public void setOptimalHeaderWidth(int col)
    {
        setOptimalHeaderWidth(getJTable(), col);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:iload_1         
    //    3    5:invokestatic    #177 <Method void setOptimalHeaderWidth(JTable, int)>
    //    4    8:return          
    }

    public static void setOptimalHeaderWidth(JTable jtable, int col)
    {
        if(col >= 0 && col < jtable.getColumnModel().getColumnCount())
    //*   0    0:iload_1         
    //*   1    1:iflt            59
    //*   2    4:iload_1         
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //*   5    9:invokeinterface #162 <Method int TableColumnModel.getColumnCount()>
    //*   6   14:icmpge          59
        {
            int width = calcHeaderWidth(jtable, col);
    //    7   17:aload_0         
    //    8   18:iload_1         
    //    9   19:invokestatic    #32  <Method int calcHeaderWidth(JTable, int)>
    //   10   22:istore_2        
            if(width >= 0)
    //*  11   23:iload_2         
    //*  12   24:iflt            59
            {
                JTableHeader header = jtable.getTableHeader();
    //   13   27:aload_0         
    //   14   28:invokevirtual   #130 <Method JTableHeader JTable.getTableHeader()>
    //   15   31:astore          4
                TableColumn column = jtable.getColumnModel().getColumn(col);
    //   16   33:aload_0         
    //   17   34:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //   18   37:iload_1         
    //   19   38:invokeinterface #54  <Method TableColumn TableColumnModel.getColumn(int)>
    //   20   43:astore_3        
                column.setPreferredWidth(width);
    //   21   44:aload_3         
    //   22   45:iload_2         
    //   23   46:invokevirtual   #165 <Method void TableColumn.setPreferredWidth(int)>
                jtable.sizeColumnsToFit(-1);
    //   24   49:aload_0         
    //   25   50:iconst_m1       
    //   26   51:invokevirtual   #168 <Method void JTable.sizeColumnsToFit(int)>
                header.repaint();
    //   27   54:aload           4
    //   28   56:invokevirtual   #171 <Method void JTableHeader.repaint()>
            }
        }
    //   29   59:return          
    }

    public void setOptimalHeaderWidth()
    {
        setOptimalHeaderWidth(getJTable());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:invokestatic    #179 <Method void setOptimalHeaderWidth(JTable)>
    //    3    7:return          
    }

    public static void setOptimalHeaderWidth(JTable jtable)
    {
        for(int i = 0; i < jtable.getColumnModel().getColumnCount(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            13
            setOptimalHeaderWidth(jtable, i);
    //    3    5:aload_0         
    //    4    6:iload_1         
    //    5    7:invokestatic    #177 <Method void setOptimalHeaderWidth(JTable, int)>

    //    6   10:iinc            1  1
    //    7   13:iload_1         
    //    8   14:aload_0         
    //    9   15:invokevirtual   #38  <Method TableColumnModel JTable.getColumnModel()>
    //   10   18:invokeinterface #162 <Method int TableColumnModel.getColumnCount()>
    //   11   23:icmplt          5
    //   12   26:return          
    }

    public void scrollToVisible(int row, int col)
    {
        scrollToVisible(getJTable(), row, col);
    //    0    0:aload_0         
    //    1    1:invokevirtual   #24  <Method JTable getJTable()>
    //    2    4:iload_1         
    //    3    5:iload_2         
    //    4    6:invokestatic    #184 <Method void scrollToVisible(JTable, int, int)>
    //    5    9:return          
    }

    public static void scrollToVisible(JTable table, int row, int col)
    {
        if(!(table.getParent() instanceof JViewport))
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #188 <Method java.awt.Container JTable.getParent()>
    //*   2    4:instanceof      #190 <Class JViewport>
    //*   3    7:ifne            11
        {
            return;
    //    4   10:return          
        } else
        {
            JViewport viewport = (JViewport)table.getParent();
    //    5   11:aload_0         
    //    6   12:invokevirtual   #188 <Method java.awt.Container JTable.getParent()>
    //    7   15:checkcast       #190 <Class JViewport>
    //    8   18:astore_3        
            Rectangle rect = table.getCellRect(row, col, true);
    //    9   19:aload_0         
    //   10   20:iload_1         
    //   11   21:iload_2         
    //   12   22:iconst_1        
    //   13   23:invokevirtual   #194 <Method Rectangle JTable.getCellRect(int, int, boolean)>
    //   14   26:astore          4
            Point pt = viewport.getViewPosition();
    //   15   28:aload_3         
    //   16   29:invokevirtual   #198 <Method Point JViewport.getViewPosition()>
    //   17   32:astore          5
            rect.setLocation(rect.x - pt.x, rect.y - pt.y);
    //   18   34:aload           4
    //   19   36:aload           4
    //   20   38:getfield        #203 <Field int Rectangle.x>
    //   21   41:aload           5
    //   22   43:getfield        #206 <Field int Point.x>
    //   23   46:isub            
    //   24   47:aload           4
    //   25   49:getfield        #209 <Field int Rectangle.y>
    //   26   52:aload           5
    //   27   54:getfield        #210 <Field int Point.y>
    //   28   57:isub            
    //   29   58:invokevirtual   #213 <Method void Rectangle.setLocation(int, int)>
            viewport.scrollRectToVisible(rect);
    //   30   61:aload_3         
    //   31   62:aload           4
    //   32   64:invokevirtual   #217 <Method void JViewport.scrollRectToVisible(Rectangle)>
            return;
    //   33   67:return          
        }
    }

    private JTable jtable;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffTableCellRenderer.java

package rm.gui.arffviewer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

// Referenced classes of package rm.gui.arffviewer:
//            ArffTable, ArffSortedTableModel

public class ArffTableCellRenderer extends DefaultTableCellRenderer
{

    public ArffTableCellRenderer()
    {
        this(new Color(223, 223, 223), new Color(192, 192, 192));
    //    0    0:aload_0         
    //    1    1:new             #19  <Class Color>
    //    2    4:dup             
    //    3    5:sipush          223
    //    4    8:sipush          223
    //    5   11:sipush          223
    //    6   14:invokespecial   #22  <Method void Color(int, int, int)>
    //    7   17:new             #19  <Class Color>
    //    8   20:dup             
    //    9   21:sipush          192
    //   10   24:sipush          192
    //   11   27:sipush          192
    //   12   30:invokespecial   #22  <Method void Color(int, int, int)>
    //   13   33:invokespecial   #25  <Method void ArffTableCellRenderer(Color, Color)>
    //   14   36:return          
    }

    public ArffTableCellRenderer(Color missingColor, Color missingColorSelected)
    {
        this(missingColor, missingColorSelected, Color.RED, Color.RED.darker());
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:getstatic       #32  <Field Color Color.RED>
    //    4    6:getstatic       #32  <Field Color Color.RED>
    //    5    9:invokevirtual   #36  <Method Color Color.darker()>
    //    6   12:invokespecial   #39  <Method void ArffTableCellRenderer(Color, Color, Color, Color)>
    //    7   15:return          
    }

    public ArffTableCellRenderer(Color missingColor, Color missingColorSelected, Color highlightColor, Color highlightColorSelected)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #41  <Method void DefaultTableCellRenderer()>
        this.missingColor = missingColor;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #43  <Field Color missingColor>
        this.missingColorSelected = missingColorSelected;
    //    5    9:aload_0         
    //    6   10:aload_2         
    //    7   11:putfield        #45  <Field Color missingColorSelected>
        this.highlightColor = highlightColor;
    //    8   14:aload_0         
    //    9   15:aload_3         
    //   10   16:putfield        #47  <Field Color highlightColor>
        this.highlightColorSelected = highlightColorSelected;
    //   11   19:aload_0         
    //   12   20:aload           4
    //   13   22:putfield        #49  <Field Color highlightColorSelected>
    //   14   25:return          
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:iload_3         
    //    4    4:iload           4
    //    5    6:iload           5
    //    6    8:iload           6
    //    7   10:invokespecial   #53  <Method Component DefaultTableCellRenderer.getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)>
    //    8   13:astore          8
        String searchString;
        if(table instanceof ArffTable)
    //*   9   15:aload_1         
    //*  10   16:instanceof      #55  <Class ArffTable>
    //*  11   19:ifeq            34
            searchString = ((ArffTable)table).getSearchString();
    //   12   22:aload_1         
    //   13   23:checkcast       #55  <Class ArffTable>
    //   14   26:invokevirtual   #59  <Method String ArffTable.getSearchString()>
    //   15   29:astore          9
        else
    //*  16   31:goto            37
            searchString = null;
    //   17   34:aconst_null     
    //   18   35:astore          9
        boolean found;
        if(searchString != null && !searchString.equals(""))
    //*  19   37:aload           9
    //*  20   39:ifnull          66
    //*  21   42:aload           9
    //*  22   44:ldc1            #61  <String "">
    //*  23   46:invokevirtual   #67  <Method boolean String.equals(Object)>
    //*  24   49:ifne            66
            found = searchString.equals(value.toString());
    //   25   52:aload           9
    //   26   54:aload_2         
    //   27   55:invokevirtual   #72  <Method String Object.toString()>
    //   28   58:invokevirtual   #67  <Method boolean String.equals(Object)>
    //   29   61:istore          10
        else
    //*  30   63:goto            69
            found = false;
    //   31   66:iconst_0        
    //   32   67:istore          10
        if(table.getModel() instanceof ArffSortedTableModel)
    //*  33   69:aload_1         
    //*  34   70:invokevirtual   #78  <Method javax.swing.table.TableModel JTable.getModel()>
    //*  35   73:instanceof      #80  <Class ArffSortedTableModel>
    //*  36   76:ifeq            321
        {
            ArffSortedTableModel model = (ArffSortedTableModel)table.getModel();
    //   37   79:aload_1         
    //   38   80:invokevirtual   #78  <Method javax.swing.table.TableModel JTable.getModel()>
    //   39   83:checkcast       #80  <Class ArffSortedTableModel>
    //   40   86:astore          7
            if(row >= 0)
    //*  41   88:iload           5
    //*  42   90:iflt            262
            {
                if(model.isMissingAt(row, column))
    //*  43   93:aload           7
    //*  44   95:iload           5
    //*  45   97:iload           6
    //*  46   99:invokevirtual   #84  <Method boolean ArffSortedTableModel.isMissingAt(int, int)>
    //*  47  102:ifeq            172
                {
                    setToolTipText("missing");
    //   48  105:aload_0         
    //   49  106:ldc1            #86  <String "missing">
    //   50  108:invokevirtual   #90  <Method void setToolTipText(String)>
                    if(found)
    //*  51  111:iload           10
    //*  52  113:ifeq            144
                    {
                        if(isSelected)
    //*  53  116:iload_3         
    //*  54  117:ifeq            132
                            result.setBackground(highlightColorSelected);
    //   55  120:aload           8
    //   56  122:aload_0         
    //   57  123:getfield        #49  <Field Color highlightColorSelected>
    //   58  126:invokevirtual   #96  <Method void Component.setBackground(Color)>
                        else
    //*  59  129:goto            234
                            result.setBackground(highlightColor);
    //   60  132:aload           8
    //   61  134:aload_0         
    //   62  135:getfield        #47  <Field Color highlightColor>
    //   63  138:invokevirtual   #96  <Method void Component.setBackground(Color)>
                    } else
    //*  64  141:goto            234
                    if(isSelected)
    //*  65  144:iload_3         
    //*  66  145:ifeq            160
                        result.setBackground(missingColorSelected);
    //   67  148:aload           8
    //   68  150:aload_0         
    //   69  151:getfield        #45  <Field Color missingColorSelected>
    //   70  154:invokevirtual   #96  <Method void Component.setBackground(Color)>
                    else
    //*  71  157:goto            234
                        result.setBackground(missingColor);
    //   72  160:aload           8
    //   73  162:aload_0         
    //   74  163:getfield        #43  <Field Color missingColor>
    //   75  166:invokevirtual   #96  <Method void Component.setBackground(Color)>
                } else
    //*  76  169:goto            234
                {
                    setToolTipText(null);
    //   77  172:aload_0         
    //   78  173:aconst_null     
    //   79  174:invokevirtual   #90  <Method void setToolTipText(String)>
                    if(found)
    //*  80  177:iload           10
    //*  81  179:ifeq            210
                    {
                        if(isSelected)
    //*  82  182:iload_3         
    //*  83  183:ifeq            198
                            result.setBackground(highlightColorSelected);
    //   84  186:aload           8
    //   85  188:aload_0         
    //   86  189:getfield        #49  <Field Color highlightColorSelected>
    //   87  192:invokevirtual   #96  <Method void Component.setBackground(Color)>
                        else
    //*  88  195:goto            234
                            result.setBackground(highlightColor);
    //   89  198:aload           8
    //   90  200:aload_0         
    //   91  201:getfield        #47  <Field Color highlightColor>
    //   92  204:invokevirtual   #96  <Method void Component.setBackground(Color)>
                    } else
    //*  93  207:goto            234
                    if(isSelected)
    //*  94  210:iload_3         
    //*  95  211:ifeq            226
                        result.setBackground(table.getSelectionBackground());
    //   96  214:aload           8
    //   97  216:aload_1         
    //   98  217:invokevirtual   #99  <Method Color JTable.getSelectionBackground()>
    //   99  220:invokevirtual   #96  <Method void Component.setBackground(Color)>
                    else
    //* 100  223:goto            234
                        result.setBackground(Color.WHITE);
    //  101  226:aload           8
    //  102  228:getstatic       #102 <Field Color Color.WHITE>
    //  103  231:invokevirtual   #96  <Method void Component.setBackground(Color)>
                }
                if(model.getType(row, column) == 0)
    //* 104  234:aload           7
    //* 105  236:iload           5
    //* 106  238:iload           6
    //* 107  240:invokevirtual   #106 <Method int ArffSortedTableModel.getType(int, int)>
    //* 108  243:ifne            254
                    setHorizontalAlignment(4);
    //  109  246:aload_0         
    //  110  247:iconst_4        
    //  111  248:invokevirtual   #110 <Method void setHorizontalAlignment(int)>
                else
    //* 112  251:goto            321
                    setHorizontalAlignment(2);
    //  113  254:aload_0         
    //  114  255:iconst_2        
    //  115  256:invokevirtual   #110 <Method void setHorizontalAlignment(int)>
            } else
    //* 116  259:goto            321
            {
                setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    //  117  262:aload_0         
    //  118  263:ldc1            #112 <String "TableHeader.cellBorder">
    //  119  265:invokestatic    #118 <Method javax.swing.border.Border UIManager.getBorder(Object)>
    //  120  268:invokevirtual   #122 <Method void setBorder(javax.swing.border.Border)>
                setHorizontalAlignment(0);
    //  121  271:aload_0         
    //  122  272:iconst_0        
    //  123  273:invokevirtual   #110 <Method void setHorizontalAlignment(int)>
                if(table.getColumnModel().getSelectionModel().isSelectedIndex(column))
    //* 124  276:aload_1         
    //* 125  277:invokevirtual   #126 <Method TableColumnModel JTable.getColumnModel()>
    //* 126  280:invokeinterface #132 <Method ListSelectionModel TableColumnModel.getSelectionModel()>
    //* 127  285:iload           6
    //* 128  287:invokeinterface #138 <Method boolean ListSelectionModel.isSelectedIndex(int)>
    //* 129  292:ifeq            311
                    result.setBackground(UIManager.getColor("TableHeader.background").darker());
    //  130  295:aload           8
    //  131  297:ldc1            #140 <String "TableHeader.background">
    //  132  299:invokestatic    #144 <Method Color UIManager.getColor(Object)>
    //  133  302:invokevirtual   #36  <Method Color Color.darker()>
    //  134  305:invokevirtual   #96  <Method void Component.setBackground(Color)>
                else
    //* 135  308:goto            321
                    result.setBackground(UIManager.getColor("TableHeader.background"));
    //  136  311:aload           8
    //  137  313:ldc1            #140 <String "TableHeader.background">
    //  138  315:invokestatic    #144 <Method Color UIManager.getColor(Object)>
    //  139  318:invokevirtual   #96  <Method void Component.setBackground(Color)>
            }
        }
        return result;
    //  140  321:aload           8
    //  141  323:areturn         
    }

    static final long serialVersionUID = 0x7f9e065ec8b5f203L;
    private Color missingColor;
    private Color missingColorSelected;
    private Color highlightColor;
    private Color highlightColorSelected;
}

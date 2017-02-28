// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Colorsimilar.java

package rm.gui.graph;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import rm.core.Assignment;
import rm.core.Matrix;
import rm.core.converters.AssLoader;

public class Colorsimilar extends JPanel
{

    public Colorsimilar(Matrix mat, int width, int height, int UorP)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #21  <Method void JPanel()>
        this.mat = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #23  <Field Matrix mat>
        if(UorP == 1)
    //*   5    9:iload           4
    //*   6   11:iconst_1        
    //*   7   12:icmpne          23
            this.mat = mat;
    //    8   15:aload_0         
    //    9   16:aload_1         
    //   10   17:putfield        #23  <Field Matrix mat>
        else
    //*  11   20:goto            31
            this.mat = mat.transpose();
    //   12   23:aload_0         
    //   13   24:aload_1         
    //   14   25:invokevirtual   #29  <Method Matrix Matrix.transpose()>
    //   15   28:putfield        #23  <Field Matrix mat>
        this.width = width;
    //   16   31:aload_0         
    //   17   32:iload_2         
    //   18   33:putfield        #31  <Field int width>
        this.height = height;
    //   19   36:aload_0         
    //   20   37:iload_3         
    //   21   38:putfield        #33  <Field int height>
        repaint();
    //   22   41:aload_0         
    //   23   42:invokevirtual   #36  <Method void repaint()>
    //   24   45:return          
    }

    public void paintComponent(Graphics g)
    {
        cellWidth = Math.min(width, height) / mat.getColumnDimension();
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #31  <Field int width>
    //    3    5:aload_0         
    //    4    6:getfield        #33  <Field int height>
    //    5    9:invokestatic    #49  <Method int Math.min(int, int)>
    //    6   12:aload_0         
    //    7   13:getfield        #23  <Field Matrix mat>
    //    8   16:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //    9   19:idiv            
    //   10   20:putfield        #55  <Field int cellWidth>
        g.drawRect(0, 0, cellWidth * mat.getColumnDimension(), cellWidth * mat.getColumnDimension());
    //   11   23:aload_1         
    //   12   24:iconst_0        
    //   13   25:iconst_0        
    //   14   26:aload_0         
    //   15   27:getfield        #55  <Field int cellWidth>
    //   16   30:aload_0         
    //   17   31:getfield        #23  <Field Matrix mat>
    //   18   34:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //   19   37:imul            
    //   20   38:aload_0         
    //   21   39:getfield        #55  <Field int cellWidth>
    //   22   42:aload_0         
    //   23   43:getfield        #23  <Field Matrix mat>
    //   24   46:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //   25   49:imul            
    //   26   50:invokevirtual   #61  <Method void Graphics.drawRect(int, int, int, int)>
        double m_Similarity[][] = calculateSimilarity();
    //   27   53:aload_0         
    //   28   54:invokespecial   #65  <Method double[][] calculateSimilarity()>
    //   29   57:astore_2        
        double similarity = 0.0D;
    //   30   58:dconst_0        
    //   31   59:dstore_3        
        for(int index = 0; index < mat.getColumnDimension(); index++)
    //*  32   60:iconst_0        
    //*  33   61:istore          5
    //*  34   63:goto            190
        {
            for(int jndex = index; jndex < mat.getColumnDimension(); jndex++)
    //*  35   66:iload           5
    //*  36   68:istore          6
    //*  37   70:goto            175
            {
                similarity = m_Similarity[index][jndex];
    //   38   73:aload_2         
    //   39   74:iload           5
    //   40   76:aaload          
    //   41   77:iload           6
    //   42   79:daload          
    //   43   80:dstore_3        
                Color color = new Color((int)((1.0D - similarity) * 255D), (int)((1.0D - similarity) * 255D), (int)((1.0D - similarity) * 255D));
    //   44   81:new             #67  <Class Color>
    //   45   84:dup             
    //   46   85:dconst_1        
    //   47   86:dload_3         
    //   48   87:dsub            
    //   49   88:ldc2w           #68  <Double 255D>
    //   50   91:dmul            
    //   51   92:d2i             
    //   52   93:dconst_1        
    //   53   94:dload_3         
    //   54   95:dsub            
    //   55   96:ldc2w           #68  <Double 255D>
    //   56   99:dmul            
    //   57  100:d2i             
    //   58  101:dconst_1        
    //   59  102:dload_3         
    //   60  103:dsub            
    //   61  104:ldc2w           #68  <Double 255D>
    //   62  107:dmul            
    //   63  108:d2i             
    //   64  109:invokespecial   #72  <Method void Color(int, int, int)>
    //   65  112:astore          7
                g.setColor(color);
    //   66  114:aload_1         
    //   67  115:aload           7
    //   68  117:invokevirtual   #76  <Method void Graphics.setColor(Color)>
                g.fillRect(index * cellWidth, jndex * cellWidth, cellWidth, cellWidth);
    //   69  120:aload_1         
    //   70  121:iload           5
    //   71  123:aload_0         
    //   72  124:getfield        #55  <Field int cellWidth>
    //   73  127:imul            
    //   74  128:iload           6
    //   75  130:aload_0         
    //   76  131:getfield        #55  <Field int cellWidth>
    //   77  134:imul            
    //   78  135:aload_0         
    //   79  136:getfield        #55  <Field int cellWidth>
    //   80  139:aload_0         
    //   81  140:getfield        #55  <Field int cellWidth>
    //   82  143:invokevirtual   #79  <Method void Graphics.fillRect(int, int, int, int)>
                g.fillRect(jndex * cellWidth, index * cellWidth, cellWidth, cellWidth);
    //   83  146:aload_1         
    //   84  147:iload           6
    //   85  149:aload_0         
    //   86  150:getfield        #55  <Field int cellWidth>
    //   87  153:imul            
    //   88  154:iload           5
    //   89  156:aload_0         
    //   90  157:getfield        #55  <Field int cellWidth>
    //   91  160:imul            
    //   92  161:aload_0         
    //   93  162:getfield        #55  <Field int cellWidth>
    //   94  165:aload_0         
    //   95  166:getfield        #55  <Field int cellWidth>
    //   96  169:invokevirtual   #79  <Method void Graphics.fillRect(int, int, int, int)>
            }

    //   97  172:iinc            6  1
    //   98  175:iload           6
    //   99  177:aload_0         
    //  100  178:getfield        #23  <Field Matrix mat>
    //  101  181:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //  102  184:icmplt          73
        }

    //  103  187:iinc            5  1
    //  104  190:iload           5
    //  105  192:aload_0         
    //  106  193:getfield        #23  <Field Matrix mat>
    //  107  196:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //  108  199:icmplt          66
    //  109  202:return          
    }

    private double[][] calculateSimilarity()
    {
        double similarity[][] = new double[mat.getColumnDimension()][mat.getColumnDimension()];
    //    0    0:aload_0         
    //    1    1:getfield        #23  <Field Matrix mat>
    //    2    4:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //    3    7:aload_0         
    //    4    8:getfield        #23  <Field Matrix mat>
    //    5   11:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //    6   14:multianewarray  double[][]
    //    7   18:astore_1        
        for(int index = 0; index < mat.getColumnDimension(); index++)
    //*   8   19:iconst_0        
    //*   9   20:istore          6
    //*  10   22:goto            126
        {
            similarity[index][index] = 1.0D;
    //   11   25:aload_1         
    //   12   26:iload           6
    //   13   28:aaload          
    //   14   29:iload           6
    //   15   31:dconst_1        
    //   16   32:dastore         
            for(int jndex = index + 1; jndex < mat.getColumnDimension(); jndex++)
    //*  17   33:iload           6
    //*  18   35:iconst_1        
    //*  19   36:iadd            
    //*  20   37:istore          7
    //*  21   39:goto            111
            {
                Vector indexSet = getSet(mat, index);
    //   22   42:aload_0         
    //   23   43:aload_0         
    //   24   44:getfield        #23  <Field Matrix mat>
    //   25   47:iload           6
    //   26   49:invokespecial   #94  <Method Vector getSet(Matrix, int)>
    //   27   52:astore_2        
                Vector jndexSet = getSet(mat, jndex);
    //   28   53:aload_0         
    //   29   54:aload_0         
    //   30   55:getfield        #23  <Field Matrix mat>
    //   31   58:iload           7
    //   32   60:invokespecial   #94  <Method Vector getSet(Matrix, int)>
    //   33   63:astore_3        
                Vector commonSet = getCommonSet(indexSet, jndexSet);
    //   34   64:aload_0         
    //   35   65:aload_2         
    //   36   66:aload_3         
    //   37   67:invokespecial   #98  <Method Vector getCommonSet(Vector, Vector)>
    //   38   70:astore          4
                Vector allSet = getAllSet(indexSet, jndexSet);
    //   39   72:aload_0         
    //   40   73:aload_2         
    //   41   74:aload_3         
    //   42   75:invokespecial   #101 <Method Vector getAllSet(Vector, Vector)>
    //   43   78:astore          5
                similarity[jndex][index] = similarity[index][jndex] = (double)commonSet.size() / (double)allSet.size();
    //   44   80:aload_1         
    //   45   81:iload           7
    //   46   83:aaload          
    //   47   84:iload           6
    //   48   86:aload_1         
    //   49   87:iload           6
    //   50   89:aaload          
    //   51   90:iload           7
    //   52   92:aload           4
    //   53   94:invokevirtual   #106 <Method int Vector.size()>
    //   54   97:i2d             
    //   55   98:aload           5
    //   56  100:invokevirtual   #106 <Method int Vector.size()>
    //   57  103:i2d             
    //   58  104:ddiv            
    //   59  105:dup2_x2         
    //   60  106:dastore         
    //   61  107:dastore         
            }

    //   62  108:iinc            7  1
    //   63  111:iload           7
    //   64  113:aload_0         
    //   65  114:getfield        #23  <Field Matrix mat>
    //   66  117:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //   67  120:icmplt          42
        }

    //   68  123:iinc            6  1
    //   69  126:iload           6
    //   70  128:aload_0         
    //   71  129:getfield        #23  <Field Matrix mat>
    //   72  132:invokevirtual   #53  <Method int Matrix.getColumnDimension()>
    //   73  135:icmplt          25
        return similarity;
    //   74  138:aload_1         
    //   75  139:areturn         
    }

    private Vector getAllSet(Vector indexSet, Vector jndexSet)
    {
        Vector allSet = (Vector)indexSet.clone();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #119 <Method Object Vector.clone()>
    //    2    4:checkcast       #103 <Class Vector>
    //    3    7:astore_3        
        for(Iterator iterator = jndexSet.iterator(); iterator.hasNext();)
    //*   4    8:aload_2         
    //*   5    9:invokevirtual   #123 <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            54
        {
            int user = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #128 <Method Object Iterator.next()>
    //   10   24:checkcast       #130 <Class Integer>
    //   11   27:invokevirtual   #133 <Method int Integer.intValue()>
    //   12   30:istore          4
            if(!allSet.contains(Integer.valueOf(user)))
    //*  13   32:aload_3         
    //*  14   33:iload           4
    //*  15   35:invokestatic    #137 <Method Integer Integer.valueOf(int)>
    //*  16   38:invokevirtual   #141 <Method boolean Vector.contains(Object)>
    //*  17   41:ifne            54
                allSet.add(Integer.valueOf(user));
    //   18   44:aload_3         
    //   19   45:iload           4
    //   20   47:invokestatic    #137 <Method Integer Integer.valueOf(int)>
    //   21   50:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //   22   53:pop             
        }

    //   23   54:aload           5
    //   24   56:invokeinterface #148 <Method boolean Iterator.hasNext()>
    //   25   61:ifne            17
        return allSet;
    //   26   64:aload_3         
    //   27   65:areturn         
    }

    private Vector getCommonSet(Vector indexSet, Vector jndexSet)
    {
        Vector commonSet = new Vector();
    //    0    0:new             #103 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #150 <Method void Vector()>
    //    3    7:astore_3        
        for(Iterator iterator = indexSet.iterator(); iterator.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #123 <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            54
        {
            int user = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #128 <Method Object Iterator.next()>
    //   10   24:checkcast       #130 <Class Integer>
    //   11   27:invokevirtual   #133 <Method int Integer.intValue()>
    //   12   30:istore          4
            if(jndexSet.contains(Integer.valueOf(user)))
    //*  13   32:aload_2         
    //*  14   33:iload           4
    //*  15   35:invokestatic    #137 <Method Integer Integer.valueOf(int)>
    //*  16   38:invokevirtual   #141 <Method boolean Vector.contains(Object)>
    //*  17   41:ifeq            54
                commonSet.add(Integer.valueOf(user));
    //   18   44:aload_3         
    //   19   45:iload           4
    //   20   47:invokestatic    #137 <Method Integer Integer.valueOf(int)>
    //   21   50:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //   22   53:pop             
        }

    //   23   54:aload           5
    //   24   56:invokeinterface #148 <Method boolean Iterator.hasNext()>
    //   25   61:ifne            17
        return commonSet;
    //   26   64:aload_3         
    //   27   65:areturn         
    }

    private Vector getSet(Matrix mat2, int index)
    {
        Vector Set = new Vector();
    //    0    0:new             #103 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #150 <Method void Vector()>
    //    3    7:astore_3        
        for(int row = 0; row < mat2.getRowDimension(); row++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            38
            if(mat2.get(row, index) == 1)
    //*   7   14:aload_1         
    //*   8   15:iload           4
    //*   9   17:iload_2         
    //*  10   18:invokevirtual   #155 <Method byte Matrix.get(int, int)>
    //*  11   21:iconst_1        
    //*  12   22:icmpne          35
                Set.add(Integer.valueOf(row));
    //   13   25:aload_3         
    //   14   26:iload           4
    //   15   28:invokestatic    #137 <Method Integer Integer.valueOf(int)>
    //   16   31:invokevirtual   #144 <Method boolean Vector.add(Object)>
    //   17   34:pop             

    //   18   35:iinc            4  1
    //   19   38:iload           4
    //   20   40:aload_1         
    //   21   41:invokevirtual   #158 <Method int Matrix.getRowDimension()>
    //   22   44:icmplt          14
        return Set;
    //   23   47:aload_3         
    //   24   48:areturn         
    }

    public static void main(String args[])
        throws Exception
    {
        File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\orca_user_permission.ass").toString());
    //    0    0:new             #168 <Class File>
    //    1    3:dup             
    //    2    4:new             #170 <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #172 <String "user.dir">
    //    5   10:invokestatic    #178 <Method String System.getProperty(String)>
    //    6   13:invokestatic    #183 <Method String String.valueOf(Object)>
    //    7   16:invokespecial   #186 <Method void StringBuilder(String)>
    //    8   19:ldc1            #188 <String "\\datasets\\orca_user_permission.ass">
    //    9   21:invokevirtual   #192 <Method StringBuilder StringBuilder.append(String)>
    //   10   24:invokevirtual   #196 <Method String StringBuilder.toString()>
    //   11   27:invokespecial   #197 <Method void File(String)>
    //   12   30:astore_1        
        AssLoader AL = new AssLoader(new FileReader(file));
    //   13   31:new             #199 <Class AssLoader>
    //   14   34:dup             
    //   15   35:new             #201 <Class FileReader>
    //   16   38:dup             
    //   17   39:aload_1         
    //   18   40:invokespecial   #204 <Method void FileReader(File)>
    //   19   43:invokespecial   #207 <Method void AssLoader(FileReader)>
    //   20   46:astore_2        
        Assignment Ass = AL.getData();
    //   21   47:aload_2         
    //   22   48:invokevirtual   #211 <Method Assignment AssLoader.getData()>
    //   23   51:astore_3        
        Matrix mat = Ass.getAssignmentMatrix();
    //   24   52:aload_3         
    //   25   53:invokevirtual   #216 <Method Matrix Assignment.getAssignmentMatrix()>
    //   26   56:astore          4
        JFrame frame = new JFrame();
    //   27   58:new             #218 <Class JFrame>
    //   28   61:dup             
    //   29   62:invokespecial   #219 <Method void JFrame()>
    //   30   65:astore          5
        frame.setTitle("Role Visual Assessment Tool");
    //   31   67:aload           5
    //   32   69:ldc1            #221 <String "Role Visual Assessment Tool">
    //   33   71:invokevirtual   #224 <Method void JFrame.setTitle(String)>
        frame.setSize(800, 600);
    //   34   74:aload           5
    //   35   76:sipush          800
    //   36   79:sipush          600
    //   37   82:invokevirtual   #228 <Method void JFrame.setSize(int, int)>
        Colorsimilar comp = new Colorsimilar(mat, 800, 600, 1);
    //   38   85:new             #2   <Class Colorsimilar>
    //   39   88:dup             
    //   40   89:aload           4
    //   41   91:sipush          800
    //   42   94:sipush          600
    //   43   97:iconst_1        
    //   44   98:invokespecial   #230 <Method void Colorsimilar(Matrix, int, int, int)>
    //   45  101:astore          6
        frame.add(comp, "Center");
    //   46  103:aload           5
    //   47  105:aload           6
    //   48  107:ldc1            #232 <String "Center">
    //   49  109:invokevirtual   #235 <Method void JFrame.add(java.awt.Component, Object)>
        frame.setDefaultCloseOperation(3);
    //   50  112:aload           5
    //   51  114:iconst_3        
    //   52  115:invokevirtual   #239 <Method void JFrame.setDefaultCloseOperation(int)>
        frame.setVisible(true);
    //   53  118:aload           5
    //   54  120:iconst_1        
    //   55  121:invokevirtual   #243 <Method void JFrame.setVisible(boolean)>
    //   56  124:return          
    }

    private Matrix mat;
    private int width;
    private int height;
    private int cellWidth;
    public static final int USER = 0;
    public static final int PERM = 1;
}

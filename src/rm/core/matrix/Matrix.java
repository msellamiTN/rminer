// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Matrix.java

package rm.core.matrix;

import java.io.*;
import java.text.*;
import java.util.Locale;
import java.util.Vector;

// Referenced classes of package rm.core.matrix:
//            SingularValueDecomposition, Maths, LUDecomposition, QRDecomposition, 
//            CholeskyDecomposition, EigenvalueDecomposition

public class Matrix
    implements Cloneable, Serializable
{

    public Matrix(int m, int n)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        this.m = m;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #21  <Field int m>
        this.n = n;
    //    5    9:aload_0         
    //    6   10:iload_2         
    //    7   11:putfield        #23  <Field int n>
        A = new double[m][n];
    //    8   14:aload_0         
    //    9   15:iload_1         
    //   10   16:iload_2         
    //   11   17:multianewarray  double[][]
    //   12   21:putfield        #26  <Field double[][] A>
    //   13   24:return          
    }

    public Matrix(int m, int n, double s)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        this.m = m;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #21  <Field int m>
        this.n = n;
    //    5    9:aload_0         
    //    6   10:iload_2         
    //    7   11:putfield        #23  <Field int n>
        A = new double[m][n];
    //    8   14:aload_0         
    //    9   15:iload_1         
    //   10   16:iload_2         
    //   11   17:multianewarray  double[][]
    //   12   21:putfield        #26  <Field double[][] A>
        for(int i = 0; i < m; i++)
    //*  13   24:iconst_0        
    //*  14   25:istore          5
    //*  15   27:goto            59
        {
            for(int j = 0; j < n; j++)
    //*  16   30:iconst_0        
    //*  17   31:istore          6
    //*  18   33:goto            50
                A[i][j] = s;
    //   19   36:aload_0         
    //   20   37:getfield        #26  <Field double[][] A>
    //   21   40:iload           5
    //   22   42:aaload          
    //   23   43:iload           6
    //   24   45:dload_3         
    //   25   46:dastore         

    //   26   47:iinc            6  1
    //   27   50:iload           6
    //   28   52:iload_2         
    //   29   53:icmplt          36
        }

    //   30   56:iinc            5  1
    //   31   59:iload           5
    //   32   61:iload_1         
    //   33   62:icmplt          30
    //   34   65:return          
    }

    public Matrix(double A[][])
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        m = A.length;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:arraylength     
    //    5    7:putfield        #21  <Field int m>
        n = A[0].length;
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:iconst_0        
    //    9   13:aaload          
    //   10   14:arraylength     
    //   11   15:putfield        #23  <Field int n>
        for(int i = 0; i < m; i++)
    //*  12   18:iconst_0        
    //*  13   19:istore_2        
    //*  14   20:goto            47
            if(A[i].length != n)
    //*  15   23:aload_1         
    //*  16   24:iload_2         
    //*  17   25:aaload          
    //*  18   26:arraylength     
    //*  19   27:aload_0         
    //*  20   28:getfield        #23  <Field int n>
    //*  21   31:icmpeq          44
                throw new IllegalArgumentException("All rows must have the same length.");
    //   22   34:new             #38  <Class IllegalArgumentException>
    //   23   37:dup             
    //   24   38:ldc1            #40  <String "All rows must have the same length.">
    //   25   40:invokespecial   #43  <Method void IllegalArgumentException(String)>
    //   26   43:athrow          

    //   27   44:iinc            2  1
    //   28   47:iload_2         
    //   29   48:aload_0         
    //   30   49:getfield        #21  <Field int m>
    //   31   52:icmplt          23
        this.A = A;
    //   32   55:aload_0         
    //   33   56:aload_1         
    //   34   57:putfield        #26  <Field double[][] A>
    //   35   60:return          
    }

    public Matrix(double A[][], int m, int n)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        this.A = A;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #26  <Field double[][] A>
        this.m = m;
    //    5    9:aload_0         
    //    6   10:iload_2         
    //    7   11:putfield        #21  <Field int m>
        this.n = n;
    //    8   14:aload_0         
    //    9   15:iload_3         
    //   10   16:putfield        #23  <Field int n>
    //   11   19:return          
    }

    public Matrix(double vals[], int m)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        this.m = m;
    //    2    4:aload_0         
    //    3    5:iload_2         
    //    4    6:putfield        #21  <Field int m>
        n = m == 0 ? 0 : vals.length / m;
    //    5    9:aload_0         
    //    6   10:iload_2         
    //    7   11:ifeq            21
    //    8   14:aload_1         
    //    9   15:arraylength     
    //   10   16:iload_2         
    //   11   17:idiv            
    //   12   18:goto            22
    //   13   21:iconst_0        
    //   14   22:putfield        #23  <Field int n>
        if(m * n != vals.length)
    //*  15   25:iload_2         
    //*  16   26:aload_0         
    //*  17   27:getfield        #23  <Field int n>
    //*  18   30:imul            
    //*  19   31:aload_1         
    //*  20   32:arraylength     
    //*  21   33:icmpeq          46
            throw new IllegalArgumentException("Array length must be a multiple of m.");
    //   22   36:new             #38  <Class IllegalArgumentException>
    //   23   39:dup             
    //   24   40:ldc1            #47  <String "Array length must be a multiple of m.">
    //   25   42:invokespecial   #43  <Method void IllegalArgumentException(String)>
    //   26   45:athrow          
        A = new double[m][n];
    //   27   46:aload_0         
    //   28   47:iload_2         
    //   29   48:aload_0         
    //   30   49:getfield        #23  <Field int n>
    //   31   52:multianewarray  double[][]
    //   32   56:putfield        #26  <Field double[][] A>
        for(int i = 0; i < m; i++)
    //*  33   59:iconst_0        
    //*  34   60:istore_3        
    //*  35   61:goto            102
        {
            for(int j = 0; j < n; j++)
    //*  36   64:iconst_0        
    //*  37   65:istore          4
    //*  38   67:goto            90
                A[i][j] = vals[i + j * m];
    //   39   70:aload_0         
    //   40   71:getfield        #26  <Field double[][] A>
    //   41   74:iload_3         
    //   42   75:aaload          
    //   43   76:iload           4
    //   44   78:aload_1         
    //   45   79:iload_3         
    //   46   80:iload           4
    //   47   82:iload_2         
    //   48   83:imul            
    //   49   84:iadd            
    //   50   85:daload          
    //   51   86:dastore         

    //   52   87:iinc            4  1
    //   53   90:iload           4
    //   54   92:aload_0         
    //   55   93:getfield        #23  <Field int n>
    //   56   96:icmplt          70
        }

    //   57   99:iinc            3  1
    //   58  102:iload_3         
    //   59  103:iload_2         
    //   60  104:icmplt          64
    //   61  107:return          
    }

    public static Matrix constructWithCopy(double A[][])
    {
        int m = A.length;
    //    0    0:aload_0         
    //    1    1:arraylength     
    //    2    2:istore_1        
        int n = A[0].length;
    //    3    3:aload_0         
    //    4    4:iconst_0        
    //    5    5:aaload          
    //    6    6:arraylength     
    //    7    7:istore_2        
        Matrix X = new Matrix(m, n);
    //    8    8:new             #2   <Class Matrix>
    //    9   11:dup             
    //   10   12:iload_1         
    //   11   13:iload_2         
    //   12   14:invokespecial   #53  <Method void Matrix(int, int)>
    //   13   17:astore_3        
        double C[][] = X.getArray();
    //   14   18:aload_3         
    //   15   19:invokevirtual   #57  <Method double[][] getArray()>
    //   16   22:astore          4
        for(int i = 0; i < m; i++)
    //*  17   24:iconst_0        
    //*  18   25:istore          5
    //*  19   27:goto            82
        {
            if(A[i].length != n)
    //*  20   30:aload_0         
    //*  21   31:iload           5
    //*  22   33:aaload          
    //*  23   34:arraylength     
    //*  24   35:iload_2         
    //*  25   36:icmpeq          49
                throw new IllegalArgumentException("All rows must have the same length.");
    //   26   39:new             #38  <Class IllegalArgumentException>
    //   27   42:dup             
    //   28   43:ldc1            #40  <String "All rows must have the same length.">
    //   29   45:invokespecial   #43  <Method void IllegalArgumentException(String)>
    //   30   48:athrow          
            for(int j = 0; j < n; j++)
    //*  31   49:iconst_0        
    //*  32   50:istore          6
    //*  33   52:goto            73
                C[i][j] = A[i][j];
    //   34   55:aload           4
    //   35   57:iload           5
    //   36   59:aaload          
    //   37   60:iload           6
    //   38   62:aload_0         
    //   39   63:iload           5
    //   40   65:aaload          
    //   41   66:iload           6
    //   42   68:daload          
    //   43   69:dastore         

    //   44   70:iinc            6  1
    //   45   73:iload           6
    //   46   75:iload_2         
    //   47   76:icmplt          55
        }

    //   48   79:iinc            5  1
    //   49   82:iload           5
    //   50   84:iload_1         
    //   51   85:icmplt          30
        return X;
    //   52   88:aload_3         
    //   53   89:areturn         
    }

    public Matrix copy()
    {
        Matrix X = new Matrix(m, n);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #21  <Field int m>
    //    4    8:aload_0         
    //    5    9:getfield        #23  <Field int n>
    //    6   12:invokespecial   #53  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double C[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #57  <Method double[][] getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < m; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            62
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            50
                C[i][j] = A[i][j];
    //   17   32:aload_2         
    //   18   33:iload_3         
    //   19   34:aaload          
    //   20   35:iload           4
    //   21   37:aload_0         
    //   22   38:getfield        #26  <Field double[][] A>
    //   23   41:iload_3         
    //   24   42:aaload          
    //   25   43:iload           4
    //   26   45:daload          
    //   27   46:dastore         

    //   28   47:iinc            4  1
    //   29   50:iload           4
    //   30   52:aload_0         
    //   31   53:getfield        #23  <Field int n>
    //   32   56:icmplt          32
        }

    //   33   59:iinc            3  1
    //   34   62:iload_3         
    //   35   63:aload_0         
    //   36   64:getfield        #21  <Field int m>
    //   37   67:icmplt          26
        return X;
    //   38   70:aload_1         
    //   39   71:areturn         
    }

    public Object clone()
    {
        return copy();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #65  <Method Matrix copy()>
    //    2    4:areturn         
    }

    public double[][] getArray()
    {
        return A;
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field double[][] A>
    //    2    4:areturn         
    }

    public double[][] getArrayCopy()
    {
        double C[][] = new double[m][n];
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field int m>
    //    2    4:aload_0         
    //    3    5:getfield        #23  <Field int n>
    //    4    8:multianewarray  double[][]
    //    5   12:astore_1        
        for(int i = 0; i < m; i++)
    //*   6   13:iconst_0        
    //*   7   14:istore_2        
    //*   8   15:goto            50
        {
            for(int j = 0; j < n; j++)
    //*   9   18:iconst_0        
    //*  10   19:istore_3        
    //*  11   20:goto            39
                C[i][j] = A[i][j];
    //   12   23:aload_1         
    //   13   24:iload_2         
    //   14   25:aaload          
    //   15   26:iload_3         
    //   16   27:aload_0         
    //   17   28:getfield        #26  <Field double[][] A>
    //   18   31:iload_2         
    //   19   32:aaload          
    //   20   33:iload_3         
    //   21   34:daload          
    //   22   35:dastore         

    //   23   36:iinc            3  1
    //   24   39:iload_3         
    //   25   40:aload_0         
    //   26   41:getfield        #23  <Field int n>
    //   27   44:icmplt          23
        }

    //   28   47:iinc            2  1
    //   29   50:iload_2         
    //   30   51:aload_0         
    //   31   52:getfield        #21  <Field int m>
    //   32   55:icmplt          18
        return C;
    //   33   58:aload_1         
    //   34   59:areturn         
    }

    public double[] getColumnPackedCopy()
    {
        double vals[] = new double[m * n];
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field int m>
    //    2    4:aload_0         
    //    3    5:getfield        #23  <Field int n>
    //    4    8:imul            
    //    5    9:newarray        double[]
    //    6   11:astore_1        
        for(int i = 0; i < m; i++)
    //*   7   12:iconst_0        
    //*   8   13:istore_2        
    //*   9   14:goto            54
        {
            for(int j = 0; j < n; j++)
    //*  10   17:iconst_0        
    //*  11   18:istore_3        
    //*  12   19:goto            43
                vals[i + j * m] = A[i][j];
    //   13   22:aload_1         
    //   14   23:iload_2         
    //   15   24:iload_3         
    //   16   25:aload_0         
    //   17   26:getfield        #21  <Field int m>
    //   18   29:imul            
    //   19   30:iadd            
    //   20   31:aload_0         
    //   21   32:getfield        #26  <Field double[][] A>
    //   22   35:iload_2         
    //   23   36:aaload          
    //   24   37:iload_3         
    //   25   38:daload          
    //   26   39:dastore         

    //   27   40:iinc            3  1
    //   28   43:iload_3         
    //   29   44:aload_0         
    //   30   45:getfield        #23  <Field int n>
    //   31   48:icmplt          22
        }

    //   32   51:iinc            2  1
    //   33   54:iload_2         
    //   34   55:aload_0         
    //   35   56:getfield        #21  <Field int m>
    //   36   59:icmplt          17
        return vals;
    //   37   62:aload_1         
    //   38   63:areturn         
    }

    public double[] getRowPackedCopy()
    {
        double vals[] = new double[m * n];
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field int m>
    //    2    4:aload_0         
    //    3    5:getfield        #23  <Field int n>
    //    4    8:imul            
    //    5    9:newarray        double[]
    //    6   11:astore_1        
        for(int i = 0; i < m; i++)
    //*   7   12:iconst_0        
    //*   8   13:istore_2        
    //*   9   14:goto            54
        {
            for(int j = 0; j < n; j++)
    //*  10   17:iconst_0        
    //*  11   18:istore_3        
    //*  12   19:goto            43
                vals[i * n + j] = A[i][j];
    //   13   22:aload_1         
    //   14   23:iload_2         
    //   15   24:aload_0         
    //   16   25:getfield        #23  <Field int n>
    //   17   28:imul            
    //   18   29:iload_3         
    //   19   30:iadd            
    //   20   31:aload_0         
    //   21   32:getfield        #26  <Field double[][] A>
    //   22   35:iload_2         
    //   23   36:aaload          
    //   24   37:iload_3         
    //   25   38:daload          
    //   26   39:dastore         

    //   27   40:iinc            3  1
    //   28   43:iload_3         
    //   29   44:aload_0         
    //   30   45:getfield        #23  <Field int n>
    //   31   48:icmplt          22
        }

    //   32   51:iinc            2  1
    //   33   54:iload_2         
    //   34   55:aload_0         
    //   35   56:getfield        #21  <Field int m>
    //   36   59:icmplt          17
        return vals;
    //   37   62:aload_1         
    //   38   63:areturn         
    }

    public int getRowDimension()
    {
        return m;
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field int m>
    //    2    4:ireturn         
    }

    public int getColumnDimension()
    {
        return n;
    //    0    0:aload_0         
    //    1    1:getfield        #23  <Field int n>
    //    2    4:ireturn         
    }

    public double get(int i, int j)
    {
        return A[i][j];
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field double[][] A>
    //    2    4:iload_1         
    //    3    5:aaload          
    //    4    6:iload_2         
    //    5    7:daload          
    //    6    8:dreturn         
    }

    public Matrix getMatrix(int i0, int i1, int j0, int j1)
    {
        Matrix X = new Matrix((i1 - i0) + 1, (j1 - j0) + 1);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:iload_2         
    //    3    5:iload_1         
    //    4    6:isub            
    //    5    7:iconst_1        
    //    6    8:iadd            
    //    7    9:iload           4
    //    8   11:iload_3         
    //    9   12:isub            
    //   10   13:iconst_1        
    //   11   14:iadd            
    //   12   15:invokespecial   #53  <Method void Matrix(int, int)>
    //   13   18:astore          5
        double B[][] = X.getArray();
    //   14   20:aload           5
    //   15   22:invokevirtual   #57  <Method double[][] getArray()>
    //   16   25:astore          6
        try
        {
            for(int i = i0; i <= i1; i++)
    //*  17   27:iload_1         
    //*  18   28:istore          7
    //*  19   30:goto            74
            {
                for(int j = j0; j <= j1; j++)
    //*  20   33:iload_3         
    //*  21   34:istore          8
    //*  22   36:goto            64
                    B[i - i0][j - j0] = A[i][j];
    //   23   39:aload           6
    //   24   41:iload           7
    //   25   43:iload_1         
    //   26   44:isub            
    //   27   45:aaload          
    //   28   46:iload           8
    //   29   48:iload_3         
    //   30   49:isub            
    //   31   50:aload_0         
    //   32   51:getfield        #26  <Field double[][] A>
    //   33   54:iload           7
    //   34   56:aaload          
    //   35   57:iload           8
    //   36   59:daload          
    //   37   60:dastore         

    //   38   61:iinc            8  1
    //   39   64:iload           8
    //   40   66:iload           4
    //   41   68:icmple          39
            }

    //   42   71:iinc            7  1
    //   43   74:iload           7
    //   44   76:iload_2         
    //   45   77:icmple          33
        }
    //*  46   80:goto            95
        catch(ArrayIndexOutOfBoundsException e)
    //*  47   83:astore          7
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   48   85:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   49   88:dup             
    //   50   89:ldc1            #80  <String "Submatrix indices">
    //   51   91:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   52   94:athrow          
        }
        return X;
    //   53   95:aload           5
    //   54   97:areturn         
    }

    public Matrix getMatrix(int r[], int c[])
    {
        Matrix X = new Matrix(r.length, c.length);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:arraylength     
    //    4    6:aload_2         
    //    5    7:arraylength     
    //    6    8:invokespecial   #53  <Method void Matrix(int, int)>
    //    7   11:astore_3        
        double B[][] = X.getArray();
    //    8   12:aload_3         
    //    9   13:invokevirtual   #57  <Method double[][] getArray()>
    //   10   16:astore          4
        try
        {
            for(int i = 0; i < r.length; i++)
    //*  11   18:iconst_0        
    //*  12   19:istore          5
    //*  13   21:goto            65
            {
                for(int j = 0; j < c.length; j++)
    //*  14   24:iconst_0        
    //*  15   25:istore          6
    //*  16   27:goto            55
                    B[i][j] = A[r[i]][c[j]];
    //   17   30:aload           4
    //   18   32:iload           5
    //   19   34:aaload          
    //   20   35:iload           6
    //   21   37:aload_0         
    //   22   38:getfield        #26  <Field double[][] A>
    //   23   41:aload_1         
    //   24   42:iload           5
    //   25   44:iaload          
    //   26   45:aaload          
    //   27   46:aload_2         
    //   28   47:iload           6
    //   29   49:iaload          
    //   30   50:daload          
    //   31   51:dastore         

    //   32   52:iinc            6  1
    //   33   55:iload           6
    //   34   57:aload_2         
    //   35   58:arraylength     
    //   36   59:icmplt          30
            }

    //   37   62:iinc            5  1
    //   38   65:iload           5
    //   39   67:aload_1         
    //   40   68:arraylength     
    //   41   69:icmplt          24
        }
    //*  42   72:goto            87
        catch(ArrayIndexOutOfBoundsException e)
    //*  43   75:astore          5
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   44   77:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   45   80:dup             
    //   46   81:ldc1            #80  <String "Submatrix indices">
    //   47   83:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   48   86:athrow          
        }
        return X;
    //   49   87:aload_3         
    //   50   88:areturn         
    }

    public Matrix getMatrix(int i0, int i1, int c[])
    {
        Matrix X = new Matrix((i1 - i0) + 1, c.length);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:iload_2         
    //    3    5:iload_1         
    //    4    6:isub            
    //    5    7:iconst_1        
    //    6    8:iadd            
    //    7    9:aload_3         
    //    8   10:arraylength     
    //    9   11:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   14:astore          4
        double B[][] = X.getArray();
    //   11   16:aload           4
    //   12   18:invokevirtual   #57  <Method double[][] getArray()>
    //   13   21:astore          5
        try
        {
            for(int i = i0; i <= i1; i++)
    //*  14   23:iload_1         
    //*  15   24:istore          6
    //*  16   26:goto            70
            {
                for(int j = 0; j < c.length; j++)
    //*  17   29:iconst_0        
    //*  18   30:istore          7
    //*  19   32:goto            60
                    B[i - i0][j] = A[i][c[j]];
    //   20   35:aload           5
    //   21   37:iload           6
    //   22   39:iload_1         
    //   23   40:isub            
    //   24   41:aaload          
    //   25   42:iload           7
    //   26   44:aload_0         
    //   27   45:getfield        #26  <Field double[][] A>
    //   28   48:iload           6
    //   29   50:aaload          
    //   30   51:aload_3         
    //   31   52:iload           7
    //   32   54:iaload          
    //   33   55:daload          
    //   34   56:dastore         

    //   35   57:iinc            7  1
    //   36   60:iload           7
    //   37   62:aload_3         
    //   38   63:arraylength     
    //   39   64:icmplt          35
            }

    //   40   67:iinc            6  1
    //   41   70:iload           6
    //   42   72:iload_2         
    //   43   73:icmple          29
        }
    //*  44   76:goto            91
        catch(ArrayIndexOutOfBoundsException e)
    //*  45   79:astore          6
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   46   81:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   47   84:dup             
    //   48   85:ldc1            #80  <String "Submatrix indices">
    //   49   87:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   50   90:athrow          
        }
        return X;
    //   51   91:aload           4
    //   52   93:areturn         
    }

    public Matrix getMatrix(int r[], int j0, int j1)
    {
        Matrix X = new Matrix(r.length, (j1 - j0) + 1);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:arraylength     
    //    4    6:iload_3         
    //    5    7:iload_2         
    //    6    8:isub            
    //    7    9:iconst_1        
    //    8   10:iadd            
    //    9   11:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   14:astore          4
        double B[][] = X.getArray();
    //   11   16:aload           4
    //   12   18:invokevirtual   #57  <Method double[][] getArray()>
    //   13   21:astore          5
        try
        {
            for(int i = 0; i < r.length; i++)
    //*  14   23:iconst_0        
    //*  15   24:istore          6
    //*  16   26:goto            69
            {
                for(int j = j0; j <= j1; j++)
    //*  17   29:iload_2         
    //*  18   30:istore          7
    //*  19   32:goto            60
                    B[i][j - j0] = A[r[i]][j];
    //   20   35:aload           5
    //   21   37:iload           6
    //   22   39:aaload          
    //   23   40:iload           7
    //   24   42:iload_2         
    //   25   43:isub            
    //   26   44:aload_0         
    //   27   45:getfield        #26  <Field double[][] A>
    //   28   48:aload_1         
    //   29   49:iload           6
    //   30   51:iaload          
    //   31   52:aaload          
    //   32   53:iload           7
    //   33   55:daload          
    //   34   56:dastore         

    //   35   57:iinc            7  1
    //   36   60:iload           7
    //   37   62:iload_3         
    //   38   63:icmple          35
            }

    //   39   66:iinc            6  1
    //   40   69:iload           6
    //   41   71:aload_1         
    //   42   72:arraylength     
    //   43   73:icmplt          29
        }
    //*  44   76:goto            91
        catch(ArrayIndexOutOfBoundsException e)
    //*  45   79:astore          6
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   46   81:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   47   84:dup             
    //   48   85:ldc1            #80  <String "Submatrix indices">
    //   49   87:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   50   90:athrow          
        }
        return X;
    //   51   91:aload           4
    //   52   93:areturn         
    }

    public void set(int i, int j, double s)
    {
        A[i][j] = s;
    //    0    0:aload_0         
    //    1    1:getfield        #26  <Field double[][] A>
    //    2    4:iload_1         
    //    3    5:aaload          
    //    4    6:iload_2         
    //    5    7:dload_3         
    //    6    8:dastore         
    //    7    9:return          
    }

    public void setMatrix(int i0, int i1, int j0, int j1, Matrix X)
    {
        try
        {
            for(int i = i0; i <= i1; i++)
    //*   0    0:iload_1         
    //*   1    1:istore          6
    //*   2    3:goto            48
            {
                for(int j = j0; j <= j1; j++)
    //*   3    6:iload_3         
    //*   4    7:istore          7
    //*   5    9:goto            38
                    A[i][j] = X.get(i - i0, j - j0);
    //    6   12:aload_0         
    //    7   13:getfield        #26  <Field double[][] A>
    //    8   16:iload           6
    //    9   18:aaload          
    //   10   19:iload           7
    //   11   21:aload           5
    //   12   23:iload           6
    //   13   25:iload_1         
    //   14   26:isub            
    //   15   27:iload           7
    //   16   29:iload_3         
    //   17   30:isub            
    //   18   31:invokevirtual   #99  <Method double get(int, int)>
    //   19   34:dastore         

    //   20   35:iinc            7  1
    //   21   38:iload           7
    //   22   40:iload           4
    //   23   42:icmple          12
            }

    //   24   45:iinc            6  1
    //   25   48:iload           6
    //   26   50:iload_2         
    //   27   51:icmple          6
        }
    //*  28   54:goto            69
        catch(ArrayIndexOutOfBoundsException e)
    //*  29   57:astore          6
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   30   59:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   31   62:dup             
    //   32   63:ldc1            #80  <String "Submatrix indices">
    //   33   65:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   34   68:athrow          
        }
    //   35   69:return          
    }

    public void setMatrix(int r[], int c[], Matrix X)
    {
        try
        {
            for(int i = 0; i < r.length; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore          4
    //*   2    3:goto            47
            {
                for(int j = 0; j < c.length; j++)
    //*   3    6:iconst_0        
    //*   4    7:istore          5
    //*   5    9:goto            37
                    A[r[i]][c[j]] = X.get(i, j);
    //    6   12:aload_0         
    //    7   13:getfield        #26  <Field double[][] A>
    //    8   16:aload_1         
    //    9   17:iload           4
    //   10   19:iaload          
    //   11   20:aaload          
    //   12   21:aload_2         
    //   13   22:iload           5
    //   14   24:iaload          
    //   15   25:aload_3         
    //   16   26:iload           4
    //   17   28:iload           5
    //   18   30:invokevirtual   #99  <Method double get(int, int)>
    //   19   33:dastore         

    //   20   34:iinc            5  1
    //   21   37:iload           5
    //   22   39:aload_2         
    //   23   40:arraylength     
    //   24   41:icmplt          12
            }

    //   25   44:iinc            4  1
    //   26   47:iload           4
    //   27   49:aload_1         
    //   28   50:arraylength     
    //   29   51:icmplt          6
        }
    //*  30   54:goto            69
        catch(ArrayIndexOutOfBoundsException e)
    //*  31   57:astore          4
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   32   59:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   33   62:dup             
    //   34   63:ldc1            #80  <String "Submatrix indices">
    //   35   65:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   36   68:athrow          
        }
    //   37   69:return          
    }

    public void setMatrix(int r[], int j0, int j1, Matrix X)
    {
        try
        {
            for(int i = 0; i < r.length; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore          5
    //*   2    3:goto            47
            {
                for(int j = j0; j <= j1; j++)
    //*   3    6:iload_2         
    //*   4    7:istore          6
    //*   5    9:goto            38
                    A[r[i]][j] = X.get(i, j - j0);
    //    6   12:aload_0         
    //    7   13:getfield        #26  <Field double[][] A>
    //    8   16:aload_1         
    //    9   17:iload           5
    //   10   19:iaload          
    //   11   20:aaload          
    //   12   21:iload           6
    //   13   23:aload           4
    //   14   25:iload           5
    //   15   27:iload           6
    //   16   29:iload_2         
    //   17   30:isub            
    //   18   31:invokevirtual   #99  <Method double get(int, int)>
    //   19   34:dastore         

    //   20   35:iinc            6  1
    //   21   38:iload           6
    //   22   40:iload_3         
    //   23   41:icmple          12
            }

    //   24   44:iinc            5  1
    //   25   47:iload           5
    //   26   49:aload_1         
    //   27   50:arraylength     
    //   28   51:icmplt          6
        }
    //*  29   54:goto            69
        catch(ArrayIndexOutOfBoundsException e)
    //*  30   57:astore          5
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   31   59:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   32   62:dup             
    //   33   63:ldc1            #80  <String "Submatrix indices">
    //   34   65:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   35   68:athrow          
        }
    //   36   69:return          
    }

    public void setMatrix(int i0, int i1, int c[], Matrix X)
    {
        try
        {
            for(int i = i0; i <= i1; i++)
    //*   0    0:iload_1         
    //*   1    1:istore          5
    //*   2    3:goto            48
            {
                for(int j = 0; j < c.length; j++)
    //*   3    6:iconst_0        
    //*   4    7:istore          6
    //*   5    9:goto            38
                    A[i][c[j]] = X.get(i - i0, j);
    //    6   12:aload_0         
    //    7   13:getfield        #26  <Field double[][] A>
    //    8   16:iload           5
    //    9   18:aaload          
    //   10   19:aload_3         
    //   11   20:iload           6
    //   12   22:iaload          
    //   13   23:aload           4
    //   14   25:iload           5
    //   15   27:iload_1         
    //   16   28:isub            
    //   17   29:iload           6
    //   18   31:invokevirtual   #99  <Method double get(int, int)>
    //   19   34:dastore         

    //   20   35:iinc            6  1
    //   21   38:iload           6
    //   22   40:aload_3         
    //   23   41:arraylength     
    //   24   42:icmplt          12
            }

    //   25   45:iinc            5  1
    //   26   48:iload           5
    //   27   50:iload_2         
    //   28   51:icmple          6
        }
    //*  29   54:goto            69
        catch(ArrayIndexOutOfBoundsException e)
    //*  30   57:astore          5
        {
            throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    //   31   59:new             #78  <Class ArrayIndexOutOfBoundsException>
    //   32   62:dup             
    //   33   63:ldc1            #80  <String "Submatrix indices">
    //   34   65:invokespecial   #81  <Method void ArrayIndexOutOfBoundsException(String)>
    //   35   68:athrow          
        }
    //   36   69:return          
    }

    public Matrix transpose()
    {
        Matrix X = new Matrix(n, m);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #23  <Field int n>
    //    4    8:aload_0         
    //    5    9:getfield        #21  <Field int m>
    //    6   12:invokespecial   #53  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double C[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #57  <Method double[][] getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < m; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            62
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            50
                C[j][i] = A[i][j];
    //   17   32:aload_2         
    //   18   33:iload           4
    //   19   35:aaload          
    //   20   36:iload_3         
    //   21   37:aload_0         
    //   22   38:getfield        #26  <Field double[][] A>
    //   23   41:iload_3         
    //   24   42:aaload          
    //   25   43:iload           4
    //   26   45:daload          
    //   27   46:dastore         

    //   28   47:iinc            4  1
    //   29   50:iload           4
    //   30   52:aload_0         
    //   31   53:getfield        #23  <Field int n>
    //   32   56:icmplt          32
        }

    //   33   59:iinc            3  1
    //   34   62:iload_3         
    //   35   63:aload_0         
    //   36   64:getfield        #21  <Field int m>
    //   37   67:icmplt          26
        return X;
    //   38   70:aload_1         
    //   39   71:areturn         
    }

    public double norm1()
    {
        double f = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int j = 0; j < n; j++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            55
        {
            double s = 0.0D;
    //    5    7:dconst_0        
    //    6    8:dstore          4
            for(int i = 0; i < m; i++)
    //*   7   10:iconst_0        
    //*   8   11:istore          6
    //*   9   13:goto            36
                s += Math.abs(A[i][j]);
    //   10   16:dload           4
    //   11   18:aload_0         
    //   12   19:getfield        #26  <Field double[][] A>
    //   13   22:iload           6
    //   14   24:aaload          
    //   15   25:iload_3         
    //   16   26:daload          
    //   17   27:invokestatic    #111 <Method double Math.abs(double)>
    //   18   30:dadd            
    //   19   31:dstore          4

    //   20   33:iinc            6  1
    //   21   36:iload           6
    //   22   38:aload_0         
    //   23   39:getfield        #21  <Field int m>
    //   24   42:icmplt          16
            f = Math.max(f, s);
    //   25   45:dload_1         
    //   26   46:dload           4
    //   27   48:invokestatic    #115 <Method double Math.max(double, double)>
    //   28   51:dstore_1        
        }

    //   29   52:iinc            3  1
    //   30   55:iload_3         
    //   31   56:aload_0         
    //   32   57:getfield        #23  <Field int n>
    //   33   60:icmplt          7
        return f;
    //   34   63:dload_1         
    //   35   64:dreturn         
    }

    public double norm2()
    {
        return (new SingularValueDecomposition(this)).norm2();
    //    0    0:new             #119 <Class SingularValueDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #122 <Method void SingularValueDecomposition(Matrix)>
    //    4    8:invokevirtual   #124 <Method double SingularValueDecomposition.norm2()>
    //    5   11:dreturn         
    }

    public double normInf()
    {
        double f = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int i = 0; i < m; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            55
        {
            double s = 0.0D;
    //    5    7:dconst_0        
    //    6    8:dstore          4
            for(int j = 0; j < n; j++)
    //*   7   10:iconst_0        
    //*   8   11:istore          6
    //*   9   13:goto            36
                s += Math.abs(A[i][j]);
    //   10   16:dload           4
    //   11   18:aload_0         
    //   12   19:getfield        #26  <Field double[][] A>
    //   13   22:iload_3         
    //   14   23:aaload          
    //   15   24:iload           6
    //   16   26:daload          
    //   17   27:invokestatic    #111 <Method double Math.abs(double)>
    //   18   30:dadd            
    //   19   31:dstore          4

    //   20   33:iinc            6  1
    //   21   36:iload           6
    //   22   38:aload_0         
    //   23   39:getfield        #23  <Field int n>
    //   24   42:icmplt          16
            f = Math.max(f, s);
    //   25   45:dload_1         
    //   26   46:dload           4
    //   27   48:invokestatic    #115 <Method double Math.max(double, double)>
    //   28   51:dstore_1        
        }

    //   29   52:iinc            3  1
    //   30   55:iload_3         
    //   31   56:aload_0         
    //   32   57:getfield        #21  <Field int m>
    //   33   60:icmplt          7
        return f;
    //   34   63:dload_1         
    //   35   64:dreturn         
    }

    public double normF()
    {
        double f = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int i = 0; i < m; i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            42
        {
            for(int j = 0; j < n; j++)
    //*   5    7:iconst_0        
    //*   6    8:istore          4
    //*   7   10:goto            30
                f = Maths.hypot(f, A[i][j]);
    //    8   13:dload_1         
    //    9   14:aload_0         
    //   10   15:getfield        #26  <Field double[][] A>
    //   11   18:iload_3         
    //   12   19:aaload          
    //   13   20:iload           4
    //   14   22:daload          
    //   15   23:invokestatic    #131 <Method double Maths.hypot(double, double)>
    //   16   26:dstore_1        

    //   17   27:iinc            4  1
    //   18   30:iload           4
    //   19   32:aload_0         
    //   20   33:getfield        #23  <Field int n>
    //   21   36:icmplt          13
        }

    //   22   39:iinc            3  1
    //   23   42:iload_3         
    //   24   43:aload_0         
    //   25   44:getfield        #21  <Field int m>
    //   26   47:icmplt          7
        return f;
    //   27   50:dload_1         
    //   28   51:dreturn         
    }

    public Matrix uminus()
    {
        Matrix X = new Matrix(m, n);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #21  <Field int m>
    //    4    8:aload_0         
    //    5    9:getfield        #23  <Field int n>
    //    6   12:invokespecial   #53  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double C[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #57  <Method double[][] getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < m; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            63
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            51
                C[i][j] = -A[i][j];
    //   17   32:aload_2         
    //   18   33:iload_3         
    //   19   34:aaload          
    //   20   35:iload           4
    //   21   37:aload_0         
    //   22   38:getfield        #26  <Field double[][] A>
    //   23   41:iload_3         
    //   24   42:aaload          
    //   25   43:iload           4
    //   26   45:daload          
    //   27   46:dneg            
    //   28   47:dastore         

    //   29   48:iinc            4  1
    //   30   51:iload           4
    //   31   53:aload_0         
    //   32   54:getfield        #23  <Field int n>
    //   33   57:icmplt          32
        }

    //   34   60:iinc            3  1
    //   35   63:iload_3         
    //   36   64:aload_0         
    //   37   65:getfield        #21  <Field int m>
    //   38   68:icmplt          26
        return X;
    //   39   71:aload_1         
    //   40   72:areturn         
    }

    public Matrix plus(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        Matrix X = new Matrix(m, n);
    //    3    5:new             #2   <Class Matrix>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:getfield        #21  <Field int m>
    //    7   13:aload_0         
    //    8   14:getfield        #23  <Field int n>
    //    9   17:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   20:astore_2        
        double C[][] = X.getArray();
    //   11   21:aload_2         
    //   12   22:invokevirtual   #57  <Method double[][] getArray()>
    //   13   25:astore_3        
        for(int i = 0; i < m; i++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            81
        {
            for(int j = 0; j < n; j++)
    //*  17   32:iconst_0        
    //*  18   33:istore          5
    //*  19   35:goto            69
                C[i][j] = A[i][j] + B.A[i][j];
    //   20   38:aload_3         
    //   21   39:iload           4
    //   22   41:aaload          
    //   23   42:iload           5
    //   24   44:aload_0         
    //   25   45:getfield        #26  <Field double[][] A>
    //   26   48:iload           4
    //   27   50:aaload          
    //   28   51:iload           5
    //   29   53:daload          
    //   30   54:aload_1         
    //   31   55:getfield        #26  <Field double[][] A>
    //   32   58:iload           4
    //   33   60:aaload          
    //   34   61:iload           5
    //   35   63:daload          
    //   36   64:dadd            
    //   37   65:dastore         

    //   38   66:iinc            5  1
    //   39   69:iload           5
    //   40   71:aload_0         
    //   41   72:getfield        #23  <Field int n>
    //   42   75:icmplt          38
        }

    //   43   78:iinc            4  1
    //   44   81:iload           4
    //   45   83:aload_0         
    //   46   84:getfield        #21  <Field int m>
    //   47   87:icmplt          32
        return X;
    //   48   90:aload_2         
    //   49   91:areturn         
    }

    public Matrix plusEquals(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        for(int i = 0; i < m; i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            54
        {
            for(int j = 0; j < n; j++)
    //*   6   10:iconst_0        
    //*   7   11:istore_3        
    //*   8   12:goto            43
                A[i][j] = A[i][j] + B.A[i][j];
    //    9   15:aload_0         
    //   10   16:getfield        #26  <Field double[][] A>
    //   11   19:iload_2         
    //   12   20:aaload          
    //   13   21:iload_3         
    //   14   22:aload_0         
    //   15   23:getfield        #26  <Field double[][] A>
    //   16   26:iload_2         
    //   17   27:aaload          
    //   18   28:iload_3         
    //   19   29:daload          
    //   20   30:aload_1         
    //   21   31:getfield        #26  <Field double[][] A>
    //   22   34:iload_2         
    //   23   35:aaload          
    //   24   36:iload_3         
    //   25   37:daload          
    //   26   38:dadd            
    //   27   39:dastore         

    //   28   40:iinc            3  1
    //   29   43:iload_3         
    //   30   44:aload_0         
    //   31   45:getfield        #23  <Field int n>
    //   32   48:icmplt          15
        }

    //   33   51:iinc            2  1
    //   34   54:iload_2         
    //   35   55:aload_0         
    //   36   56:getfield        #21  <Field int m>
    //   37   59:icmplt          10
        return this;
    //   38   62:aload_0         
    //   39   63:areturn         
    }

    public Matrix minus(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        Matrix X = new Matrix(m, n);
    //    3    5:new             #2   <Class Matrix>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:getfield        #21  <Field int m>
    //    7   13:aload_0         
    //    8   14:getfield        #23  <Field int n>
    //    9   17:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   20:astore_2        
        double C[][] = X.getArray();
    //   11   21:aload_2         
    //   12   22:invokevirtual   #57  <Method double[][] getArray()>
    //   13   25:astore_3        
        for(int i = 0; i < m; i++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            81
        {
            for(int j = 0; j < n; j++)
    //*  17   32:iconst_0        
    //*  18   33:istore          5
    //*  19   35:goto            69
                C[i][j] = A[i][j] - B.A[i][j];
    //   20   38:aload_3         
    //   21   39:iload           4
    //   22   41:aaload          
    //   23   42:iload           5
    //   24   44:aload_0         
    //   25   45:getfield        #26  <Field double[][] A>
    //   26   48:iload           4
    //   27   50:aaload          
    //   28   51:iload           5
    //   29   53:daload          
    //   30   54:aload_1         
    //   31   55:getfield        #26  <Field double[][] A>
    //   32   58:iload           4
    //   33   60:aaload          
    //   34   61:iload           5
    //   35   63:daload          
    //   36   64:dsub            
    //   37   65:dastore         

    //   38   66:iinc            5  1
    //   39   69:iload           5
    //   40   71:aload_0         
    //   41   72:getfield        #23  <Field int n>
    //   42   75:icmplt          38
        }

    //   43   78:iinc            4  1
    //   44   81:iload           4
    //   45   83:aload_0         
    //   46   84:getfield        #21  <Field int m>
    //   47   87:icmplt          32
        return X;
    //   48   90:aload_2         
    //   49   91:areturn         
    }

    public Matrix minusEquals(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        for(int i = 0; i < m; i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            54
        {
            for(int j = 0; j < n; j++)
    //*   6   10:iconst_0        
    //*   7   11:istore_3        
    //*   8   12:goto            43
                A[i][j] = A[i][j] - B.A[i][j];
    //    9   15:aload_0         
    //   10   16:getfield        #26  <Field double[][] A>
    //   11   19:iload_2         
    //   12   20:aaload          
    //   13   21:iload_3         
    //   14   22:aload_0         
    //   15   23:getfield        #26  <Field double[][] A>
    //   16   26:iload_2         
    //   17   27:aaload          
    //   18   28:iload_3         
    //   19   29:daload          
    //   20   30:aload_1         
    //   21   31:getfield        #26  <Field double[][] A>
    //   22   34:iload_2         
    //   23   35:aaload          
    //   24   36:iload_3         
    //   25   37:daload          
    //   26   38:dsub            
    //   27   39:dastore         

    //   28   40:iinc            3  1
    //   29   43:iload_3         
    //   30   44:aload_0         
    //   31   45:getfield        #23  <Field int n>
    //   32   48:icmplt          15
        }

    //   33   51:iinc            2  1
    //   34   54:iload_2         
    //   35   55:aload_0         
    //   36   56:getfield        #21  <Field int m>
    //   37   59:icmplt          10
        return this;
    //   38   62:aload_0         
    //   39   63:areturn         
    }

    public Matrix arrayTimes(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        Matrix X = new Matrix(m, n);
    //    3    5:new             #2   <Class Matrix>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:getfield        #21  <Field int m>
    //    7   13:aload_0         
    //    8   14:getfield        #23  <Field int n>
    //    9   17:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   20:astore_2        
        double C[][] = X.getArray();
    //   11   21:aload_2         
    //   12   22:invokevirtual   #57  <Method double[][] getArray()>
    //   13   25:astore_3        
        for(int i = 0; i < m; i++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            81
        {
            for(int j = 0; j < n; j++)
    //*  17   32:iconst_0        
    //*  18   33:istore          5
    //*  19   35:goto            69
                C[i][j] = A[i][j] * B.A[i][j];
    //   20   38:aload_3         
    //   21   39:iload           4
    //   22   41:aaload          
    //   23   42:iload           5
    //   24   44:aload_0         
    //   25   45:getfield        #26  <Field double[][] A>
    //   26   48:iload           4
    //   27   50:aaload          
    //   28   51:iload           5
    //   29   53:daload          
    //   30   54:aload_1         
    //   31   55:getfield        #26  <Field double[][] A>
    //   32   58:iload           4
    //   33   60:aaload          
    //   34   61:iload           5
    //   35   63:daload          
    //   36   64:dmul            
    //   37   65:dastore         

    //   38   66:iinc            5  1
    //   39   69:iload           5
    //   40   71:aload_0         
    //   41   72:getfield        #23  <Field int n>
    //   42   75:icmplt          38
        }

    //   43   78:iinc            4  1
    //   44   81:iload           4
    //   45   83:aload_0         
    //   46   84:getfield        #21  <Field int m>
    //   47   87:icmplt          32
        return X;
    //   48   90:aload_2         
    //   49   91:areturn         
    }

    public Matrix arrayTimesEquals(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        for(int i = 0; i < m; i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            54
        {
            for(int j = 0; j < n; j++)
    //*   6   10:iconst_0        
    //*   7   11:istore_3        
    //*   8   12:goto            43
                A[i][j] = A[i][j] * B.A[i][j];
    //    9   15:aload_0         
    //   10   16:getfield        #26  <Field double[][] A>
    //   11   19:iload_2         
    //   12   20:aaload          
    //   13   21:iload_3         
    //   14   22:aload_0         
    //   15   23:getfield        #26  <Field double[][] A>
    //   16   26:iload_2         
    //   17   27:aaload          
    //   18   28:iload_3         
    //   19   29:daload          
    //   20   30:aload_1         
    //   21   31:getfield        #26  <Field double[][] A>
    //   22   34:iload_2         
    //   23   35:aaload          
    //   24   36:iload_3         
    //   25   37:daload          
    //   26   38:dmul            
    //   27   39:dastore         

    //   28   40:iinc            3  1
    //   29   43:iload_3         
    //   30   44:aload_0         
    //   31   45:getfield        #23  <Field int n>
    //   32   48:icmplt          15
        }

    //   33   51:iinc            2  1
    //   34   54:iload_2         
    //   35   55:aload_0         
    //   36   56:getfield        #21  <Field int m>
    //   37   59:icmplt          10
        return this;
    //   38   62:aload_0         
    //   39   63:areturn         
    }

    public Matrix arrayRightDivide(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        Matrix X = new Matrix(m, n);
    //    3    5:new             #2   <Class Matrix>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:getfield        #21  <Field int m>
    //    7   13:aload_0         
    //    8   14:getfield        #23  <Field int n>
    //    9   17:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   20:astore_2        
        double C[][] = X.getArray();
    //   11   21:aload_2         
    //   12   22:invokevirtual   #57  <Method double[][] getArray()>
    //   13   25:astore_3        
        for(int i = 0; i < m; i++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            81
        {
            for(int j = 0; j < n; j++)
    //*  17   32:iconst_0        
    //*  18   33:istore          5
    //*  19   35:goto            69
                C[i][j] = A[i][j] / B.A[i][j];
    //   20   38:aload_3         
    //   21   39:iload           4
    //   22   41:aaload          
    //   23   42:iload           5
    //   24   44:aload_0         
    //   25   45:getfield        #26  <Field double[][] A>
    //   26   48:iload           4
    //   27   50:aaload          
    //   28   51:iload           5
    //   29   53:daload          
    //   30   54:aload_1         
    //   31   55:getfield        #26  <Field double[][] A>
    //   32   58:iload           4
    //   33   60:aaload          
    //   34   61:iload           5
    //   35   63:daload          
    //   36   64:ddiv            
    //   37   65:dastore         

    //   38   66:iinc            5  1
    //   39   69:iload           5
    //   40   71:aload_0         
    //   41   72:getfield        #23  <Field int n>
    //   42   75:icmplt          38
        }

    //   43   78:iinc            4  1
    //   44   81:iload           4
    //   45   83:aload_0         
    //   46   84:getfield        #21  <Field int m>
    //   47   87:icmplt          32
        return X;
    //   48   90:aload_2         
    //   49   91:areturn         
    }

    public Matrix arrayRightDivideEquals(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        for(int i = 0; i < m; i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            54
        {
            for(int j = 0; j < n; j++)
    //*   6   10:iconst_0        
    //*   7   11:istore_3        
    //*   8   12:goto            43
                A[i][j] = A[i][j] / B.A[i][j];
    //    9   15:aload_0         
    //   10   16:getfield        #26  <Field double[][] A>
    //   11   19:iload_2         
    //   12   20:aaload          
    //   13   21:iload_3         
    //   14   22:aload_0         
    //   15   23:getfield        #26  <Field double[][] A>
    //   16   26:iload_2         
    //   17   27:aaload          
    //   18   28:iload_3         
    //   19   29:daload          
    //   20   30:aload_1         
    //   21   31:getfield        #26  <Field double[][] A>
    //   22   34:iload_2         
    //   23   35:aaload          
    //   24   36:iload_3         
    //   25   37:daload          
    //   26   38:ddiv            
    //   27   39:dastore         

    //   28   40:iinc            3  1
    //   29   43:iload_3         
    //   30   44:aload_0         
    //   31   45:getfield        #23  <Field int n>
    //   32   48:icmplt          15
        }

    //   33   51:iinc            2  1
    //   34   54:iload_2         
    //   35   55:aload_0         
    //   36   56:getfield        #21  <Field int m>
    //   37   59:icmplt          10
        return this;
    //   38   62:aload_0         
    //   39   63:areturn         
    }

    public Matrix arrayLeftDivide(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        Matrix X = new Matrix(m, n);
    //    3    5:new             #2   <Class Matrix>
    //    4    8:dup             
    //    5    9:aload_0         
    //    6   10:getfield        #21  <Field int m>
    //    7   13:aload_0         
    //    8   14:getfield        #23  <Field int n>
    //    9   17:invokespecial   #53  <Method void Matrix(int, int)>
    //   10   20:astore_2        
        double C[][] = X.getArray();
    //   11   21:aload_2         
    //   12   22:invokevirtual   #57  <Method double[][] getArray()>
    //   13   25:astore_3        
        for(int i = 0; i < m; i++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            81
        {
            for(int j = 0; j < n; j++)
    //*  17   32:iconst_0        
    //*  18   33:istore          5
    //*  19   35:goto            69
                C[i][j] = B.A[i][j] / A[i][j];
    //   20   38:aload_3         
    //   21   39:iload           4
    //   22   41:aaload          
    //   23   42:iload           5
    //   24   44:aload_1         
    //   25   45:getfield        #26  <Field double[][] A>
    //   26   48:iload           4
    //   27   50:aaload          
    //   28   51:iload           5
    //   29   53:daload          
    //   30   54:aload_0         
    //   31   55:getfield        #26  <Field double[][] A>
    //   32   58:iload           4
    //   33   60:aaload          
    //   34   61:iload           5
    //   35   63:daload          
    //   36   64:ddiv            
    //   37   65:dastore         

    //   38   66:iinc            5  1
    //   39   69:iload           5
    //   40   71:aload_0         
    //   41   72:getfield        #23  <Field int n>
    //   42   75:icmplt          38
        }

    //   43   78:iinc            4  1
    //   44   81:iload           4
    //   45   83:aload_0         
    //   46   84:getfield        #21  <Field int m>
    //   47   87:icmplt          32
        return X;
    //   48   90:aload_2         
    //   49   91:areturn         
    }

    public Matrix arrayLeftDivideEquals(Matrix B)
    {
        checkMatrixDimensions(B);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #137 <Method void checkMatrixDimensions(Matrix)>
        for(int i = 0; i < m; i++)
    //*   3    5:iconst_0        
    //*   4    6:istore_2        
    //*   5    7:goto            54
        {
            for(int j = 0; j < n; j++)
    //*   6   10:iconst_0        
    //*   7   11:istore_3        
    //*   8   12:goto            43
                A[i][j] = B.A[i][j] / A[i][j];
    //    9   15:aload_0         
    //   10   16:getfield        #26  <Field double[][] A>
    //   11   19:iload_2         
    //   12   20:aaload          
    //   13   21:iload_3         
    //   14   22:aload_1         
    //   15   23:getfield        #26  <Field double[][] A>
    //   16   26:iload_2         
    //   17   27:aaload          
    //   18   28:iload_3         
    //   19   29:daload          
    //   20   30:aload_0         
    //   21   31:getfield        #26  <Field double[][] A>
    //   22   34:iload_2         
    //   23   35:aaload          
    //   24   36:iload_3         
    //   25   37:daload          
    //   26   38:ddiv            
    //   27   39:dastore         

    //   28   40:iinc            3  1
    //   29   43:iload_3         
    //   30   44:aload_0         
    //   31   45:getfield        #23  <Field int n>
    //   32   48:icmplt          15
        }

    //   33   51:iinc            2  1
    //   34   54:iload_2         
    //   35   55:aload_0         
    //   36   56:getfield        #21  <Field int m>
    //   37   59:icmplt          10
        return this;
    //   38   62:aload_0         
    //   39   63:areturn         
    }

    public Matrix times(double s)
    {
        Matrix X = new Matrix(m, n);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #21  <Field int m>
    //    4    8:aload_0         
    //    5    9:getfield        #23  <Field int n>
    //    6   12:invokespecial   #53  <Method void Matrix(int, int)>
    //    7   15:astore_3        
        double C[][] = X.getArray();
    //    8   16:aload_3         
    //    9   17:invokevirtual   #57  <Method double[][] getArray()>
    //   10   20:astore          4
        for(int i = 0; i < m; i++)
    //*  11   22:iconst_0        
    //*  12   23:istore          5
    //*  13   25:goto            69
        {
            for(int j = 0; j < n; j++)
    //*  14   28:iconst_0        
    //*  15   29:istore          6
    //*  16   31:goto            57
                C[i][j] = s * A[i][j];
    //   17   34:aload           4
    //   18   36:iload           5
    //   19   38:aaload          
    //   20   39:iload           6
    //   21   41:dload_1         
    //   22   42:aload_0         
    //   23   43:getfield        #26  <Field double[][] A>
    //   24   46:iload           5
    //   25   48:aaload          
    //   26   49:iload           6
    //   27   51:daload          
    //   28   52:dmul            
    //   29   53:dastore         

    //   30   54:iinc            6  1
    //   31   57:iload           6
    //   32   59:aload_0         
    //   33   60:getfield        #23  <Field int n>
    //   34   63:icmplt          34
        }

    //   35   66:iinc            5  1
    //   36   69:iload           5
    //   37   71:aload_0         
    //   38   72:getfield        #21  <Field int m>
    //   39   75:icmplt          28
        return X;
    //   40   78:aload_3         
    //   41   79:areturn         
    }

    public Matrix timesEquals(double s)
    {
        for(int i = 0; i < m; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            46
        {
            for(int j = 0; j < n; j++)
    //*   3    5:iconst_0        
    //*   4    6:istore          4
    //*   5    8:goto            34
                A[i][j] = s * A[i][j];
    //    6   11:aload_0         
    //    7   12:getfield        #26  <Field double[][] A>
    //    8   15:iload_3         
    //    9   16:aaload          
    //   10   17:iload           4
    //   11   19:dload_1         
    //   12   20:aload_0         
    //   13   21:getfield        #26  <Field double[][] A>
    //   14   24:iload_3         
    //   15   25:aaload          
    //   16   26:iload           4
    //   17   28:daload          
    //   18   29:dmul            
    //   19   30:dastore         

    //   20   31:iinc            4  1
    //   21   34:iload           4
    //   22   36:aload_0         
    //   23   37:getfield        #23  <Field int n>
    //   24   40:icmplt          11
        }

    //   25   43:iinc            3  1
    //   26   46:iload_3         
    //   27   47:aload_0         
    //   28   48:getfield        #21  <Field int m>
    //   29   51:icmplt          5
        return this;
    //   30   54:aload_0         
    //   31   55:areturn         
    }

    public Matrix times(Matrix B)
    {
        if(B.m != n)
    //*   0    0:aload_1         
    //*   1    1:getfield        #21  <Field int m>
    //*   2    4:aload_0         
    //*   3    5:getfield        #23  <Field int n>
    //*   4    8:icmpeq          21
            throw new IllegalArgumentException("Matrix inner dimensions must agree.");
    //    5   11:new             #38  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc1            #151 <String "Matrix inner dimensions must agree.">
    //    8   17:invokespecial   #43  <Method void IllegalArgumentException(String)>
    //    9   20:athrow          
        Matrix X = new Matrix(m, B.n);
    //   10   21:new             #2   <Class Matrix>
    //   11   24:dup             
    //   12   25:aload_0         
    //   13   26:getfield        #21  <Field int m>
    //   14   29:aload_1         
    //   15   30:getfield        #23  <Field int n>
    //   16   33:invokespecial   #53  <Method void Matrix(int, int)>
    //   17   36:astore_2        
        double C[][] = X.getArray();
    //   18   37:aload_2         
    //   19   38:invokevirtual   #57  <Method double[][] getArray()>
    //   20   41:astore_3        
        double Bcolj[] = new double[n];
    //   21   42:aload_0         
    //   22   43:getfield        #23  <Field int n>
    //   23   46:newarray        double[]
    //   24   48:astore          4
        for(int j = 0; j < B.n; j++)
    //*  25   50:iconst_0        
    //*  26   51:istore          5
    //*  27   53:goto            165
        {
            for(int k = 0; k < n; k++)
    //*  28   56:iconst_0        
    //*  29   57:istore          6
    //*  30   59:goto            80
                Bcolj[k] = B.A[k][j];
    //   31   62:aload           4
    //   32   64:iload           6
    //   33   66:aload_1         
    //   34   67:getfield        #26  <Field double[][] A>
    //   35   70:iload           6
    //   36   72:aaload          
    //   37   73:iload           5
    //   38   75:daload          
    //   39   76:dastore         

    //   40   77:iinc            6  1
    //   41   80:iload           6
    //   42   82:aload_0         
    //   43   83:getfield        #23  <Field int n>
    //   44   86:icmplt          62
            for(int i = 0; i < m; i++)
    //*  45   89:iconst_0        
    //*  46   90:istore          6
    //*  47   92:goto            153
            {
                double Arowi[] = A[i];
    //   48   95:aload_0         
    //   49   96:getfield        #26  <Field double[][] A>
    //   50   99:iload           6
    //   51  101:aaload          
    //   52  102:astore          7
                double s = 0.0D;
    //   53  104:dconst_0        
    //   54  105:dstore          8
                for(int k = 0; k < n; k++)
    //*  55  107:iconst_0        
    //*  56  108:istore          10
    //*  57  110:goto            132
                    s += Arowi[k] * Bcolj[k];
    //   58  113:dload           8
    //   59  115:aload           7
    //   60  117:iload           10
    //   61  119:daload          
    //   62  120:aload           4
    //   63  122:iload           10
    //   64  124:daload          
    //   65  125:dmul            
    //   66  126:dadd            
    //   67  127:dstore          8

    //   68  129:iinc            10  1
    //   69  132:iload           10
    //   70  134:aload_0         
    //   71  135:getfield        #23  <Field int n>
    //   72  138:icmplt          113
                C[i][j] = s;
    //   73  141:aload_3         
    //   74  142:iload           6
    //   75  144:aaload          
    //   76  145:iload           5
    //   77  147:dload           8
    //   78  149:dastore         
            }

    //   79  150:iinc            6  1
    //   80  153:iload           6
    //   81  155:aload_0         
    //   82  156:getfield        #21  <Field int m>
    //   83  159:icmplt          95
        }

    //   84  162:iinc            5  1
    //   85  165:iload           5
    //   86  167:aload_1         
    //   87  168:getfield        #23  <Field int n>
    //   88  171:icmplt          56
        return X;
    //   89  174:aload_2         
    //   90  175:areturn         
    }

    public LUDecomposition lu()
    {
        return new LUDecomposition(this);
    //    0    0:new             #158 <Class LUDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #159 <Method void LUDecomposition(Matrix)>
    //    4    8:areturn         
    }

    public QRDecomposition qr()
    {
        return new QRDecomposition(this);
    //    0    0:new             #163 <Class QRDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #164 <Method void QRDecomposition(Matrix)>
    //    4    8:areturn         
    }

    public CholeskyDecomposition chol()
    {
        return new CholeskyDecomposition(this);
    //    0    0:new             #168 <Class CholeskyDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #169 <Method void CholeskyDecomposition(Matrix)>
    //    4    8:areturn         
    }

    public SingularValueDecomposition svd()
    {
        return new SingularValueDecomposition(this);
    //    0    0:new             #119 <Class SingularValueDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #122 <Method void SingularValueDecomposition(Matrix)>
    //    4    8:areturn         
    }

    public EigenvalueDecomposition eig()
    {
        return new EigenvalueDecomposition(this);
    //    0    0:new             #175 <Class EigenvalueDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #176 <Method void EigenvalueDecomposition(Matrix)>
    //    4    8:areturn         
    }

    public Matrix solve(Matrix B)
    {
        return m != n ? (new QRDecomposition(this)).solve(B) : (new LUDecomposition(this)).solve(B);
    //    0    0:aload_0         
    //    1    1:getfield        #21  <Field int m>
    //    2    4:aload_0         
    //    3    5:getfield        #23  <Field int n>
    //    4    8:icmpne          26
    //    5   11:new             #158 <Class LUDecomposition>
    //    6   14:dup             
    //    7   15:aload_0         
    //    8   16:invokespecial   #159 <Method void LUDecomposition(Matrix)>
    //    9   19:aload_1         
    //   10   20:invokevirtual   #179 <Method Matrix LUDecomposition.solve(Matrix)>
    //   11   23:goto            38
    //   12   26:new             #163 <Class QRDecomposition>
    //   13   29:dup             
    //   14   30:aload_0         
    //   15   31:invokespecial   #164 <Method void QRDecomposition(Matrix)>
    //   16   34:aload_1         
    //   17   35:invokevirtual   #180 <Method Matrix QRDecomposition.solve(Matrix)>
    //   18   38:areturn         
    }

    public Matrix solveTranspose(Matrix B)
    {
        return transpose().solve(B.transpose());
    //    0    0:aload_0         
    //    1    1:invokevirtual   #183 <Method Matrix transpose()>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #183 <Method Matrix transpose()>
    //    4    8:invokevirtual   #184 <Method Matrix solve(Matrix)>
    //    5   11:areturn         
    }

    public Matrix inverse()
    {
        return solve(identity(m, m));
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #21  <Field int m>
    //    3    5:aload_0         
    //    4    6:getfield        #21  <Field int m>
    //    5    9:invokestatic    #189 <Method Matrix identity(int, int)>
    //    6   12:invokevirtual   #184 <Method Matrix solve(Matrix)>
    //    7   15:areturn         
    }

    public double det()
    {
        return (new LUDecomposition(this)).det();
    //    0    0:new             #158 <Class LUDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #159 <Method void LUDecomposition(Matrix)>
    //    4    8:invokevirtual   #192 <Method double LUDecomposition.det()>
    //    5   11:dreturn         
    }

    public int rank()
    {
        return (new SingularValueDecomposition(this)).rank();
    //    0    0:new             #119 <Class SingularValueDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #122 <Method void SingularValueDecomposition(Matrix)>
    //    4    8:invokevirtual   #195 <Method int SingularValueDecomposition.rank()>
    //    5   11:ireturn         
    }

    public double cond()
    {
        return (new SingularValueDecomposition(this)).cond();
    //    0    0:new             #119 <Class SingularValueDecomposition>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #122 <Method void SingularValueDecomposition(Matrix)>
    //    4    8:invokevirtual   #198 <Method double SingularValueDecomposition.cond()>
    //    5   11:dreturn         
    }

    public double trace()
    {
        double t = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_1        
        for(int i = 0; i < Math.min(m, n); i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_3        
    //*   4    4:goto            21
            t += A[i][i];
    //    5    7:dload_1         
    //    6    8:aload_0         
    //    7    9:getfield        #26  <Field double[][] A>
    //    8   12:iload_3         
    //    9   13:aaload          
    //   10   14:iload_3         
    //   11   15:daload          
    //   12   16:dadd            
    //   13   17:dstore_1        

    //   14   18:iinc            3  1
    //   15   21:iload_3         
    //   16   22:aload_0         
    //   17   23:getfield        #21  <Field int m>
    //   18   26:aload_0         
    //   19   27:getfield        #23  <Field int n>
    //   20   30:invokestatic    #203 <Method int Math.min(int, int)>
    //   21   33:icmplt          7
        return t;
    //   22   36:dload_1         
    //   23   37:dreturn         
    }

    public static Matrix random(int m, int n)
    {
        Matrix A = new Matrix(m, n);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:iload_0         
    //    3    5:iload_1         
    //    4    6:invokespecial   #53  <Method void Matrix(int, int)>
    //    5    9:astore_2        
        double X[][] = A.getArray();
    //    6   10:aload_2         
    //    7   11:invokevirtual   #57  <Method double[][] getArray()>
    //    8   14:astore_3        
        for(int i = 0; i < m; i++)
    //*   9   15:iconst_0        
    //*  10   16:istore          4
    //*  11   18:goto            49
        {
            for(int j = 0; j < n; j++)
    //*  12   21:iconst_0        
    //*  13   22:istore          5
    //*  14   24:goto            40
                X[i][j] = Math.random();
    //   15   27:aload_3         
    //   16   28:iload           4
    //   17   30:aaload          
    //   18   31:iload           5
    //   19   33:invokestatic    #207 <Method double Math.random()>
    //   20   36:dastore         

    //   21   37:iinc            5  1
    //   22   40:iload           5
    //   23   42:iload_1         
    //   24   43:icmplt          27
        }

    //   25   46:iinc            4  1
    //   26   49:iload           4
    //   27   51:iload_0         
    //   28   52:icmplt          21
        return A;
    //   29   55:aload_2         
    //   30   56:areturn         
    }

    public static Matrix identity(int m, int n)
    {
        Matrix A = new Matrix(m, n);
    //    0    0:new             #2   <Class Matrix>
    //    1    3:dup             
    //    2    4:iload_0         
    //    3    5:iload_1         
    //    4    6:invokespecial   #53  <Method void Matrix(int, int)>
    //    5    9:astore_2        
        double X[][] = A.getArray();
    //    6   10:aload_2         
    //    7   11:invokevirtual   #57  <Method double[][] getArray()>
    //    8   14:astore_3        
        for(int i = 0; i < m; i++)
    //*   9   15:iconst_0        
    //*  10   16:istore          4
    //*  11   18:goto            58
        {
            for(int j = 0; j < n; j++)
    //*  12   21:iconst_0        
    //*  13   22:istore          5
    //*  14   24:goto            49
                X[i][j] = i != j ? 0.0D : 1.0D;
    //   15   27:aload_3         
    //   16   28:iload           4
    //   17   30:aaload          
    //   18   31:iload           5
    //   19   33:iload           4
    //   20   35:iload           5
    //   21   37:icmpne          44
    //   22   40:dconst_1        
    //   23   41:goto            45
    //   24   44:dconst_0        
    //   25   45:dastore         

    //   26   46:iinc            5  1
    //   27   49:iload           5
    //   28   51:iload_1         
    //   29   52:icmplt          27
        }

    //   30   55:iinc            4  1
    //   31   58:iload           4
    //   32   60:iload_0         
    //   33   61:icmplt          21
        return A;
    //   34   64:aload_2         
    //   35   65:areturn         
    }

    public void print(int w, int d)
    {
        print(new PrintWriter(System.out, true), w, d);
    //    0    0:aload_0         
    //    1    1:new             #210 <Class PrintWriter>
    //    2    4:dup             
    //    3    5:getstatic       #216 <Field java.io.PrintStream System.out>
    //    4    8:iconst_1        
    //    5    9:invokespecial   #219 <Method void PrintWriter(java.io.OutputStream, boolean)>
    //    6   12:iload_1         
    //    7   13:iload_2         
    //    8   14:invokevirtual   #222 <Method void print(PrintWriter, int, int)>
    //    9   17:return          
    }

    public void print(PrintWriter output, int w, int d)
    {
        DecimalFormat format = new DecimalFormat();
    //    0    0:new             #226 <Class DecimalFormat>
    //    1    3:dup             
    //    2    4:invokespecial   #227 <Method void DecimalFormat()>
    //    3    7:astore          4
        format.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
    //    4    9:aload           4
    //    5   11:new             #229 <Class DecimalFormatSymbols>
    //    6   14:dup             
    //    7   15:getstatic       #235 <Field Locale Locale.US>
    //    8   18:invokespecial   #238 <Method void DecimalFormatSymbols(Locale)>
    //    9   21:invokevirtual   #242 <Method void DecimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols)>
        format.setMinimumIntegerDigits(1);
    //   10   24:aload           4
    //   11   26:iconst_1        
    //   12   27:invokevirtual   #246 <Method void DecimalFormat.setMinimumIntegerDigits(int)>
        format.setMaximumFractionDigits(d);
    //   13   30:aload           4
    //   14   32:iload_3         
    //   15   33:invokevirtual   #249 <Method void DecimalFormat.setMaximumFractionDigits(int)>
        format.setMinimumFractionDigits(d);
    //   16   36:aload           4
    //   17   38:iload_3         
    //   18   39:invokevirtual   #252 <Method void DecimalFormat.setMinimumFractionDigits(int)>
        format.setGroupingUsed(false);
    //   19   42:aload           4
    //   20   44:iconst_0        
    //   21   45:invokevirtual   #256 <Method void DecimalFormat.setGroupingUsed(boolean)>
        print(output, ((NumberFormat) (format)), w + 2);
    //   22   48:aload_0         
    //   23   49:aload_1         
    //   24   50:aload           4
    //   25   52:iload_2         
    //   26   53:iconst_2        
    //   27   54:iadd            
    //   28   55:invokevirtual   #259 <Method void print(PrintWriter, NumberFormat, int)>
    //   29   58:return          
    }

    public void print(NumberFormat format, int width)
    {
        print(new PrintWriter(System.out, true), format, width);
    //    0    0:aload_0         
    //    1    1:new             #210 <Class PrintWriter>
    //    2    4:dup             
    //    3    5:getstatic       #216 <Field java.io.PrintStream System.out>
    //    4    8:iconst_1        
    //    5    9:invokespecial   #219 <Method void PrintWriter(java.io.OutputStream, boolean)>
    //    6   12:aload_1         
    //    7   13:iload_2         
    //    8   14:invokevirtual   #259 <Method void print(PrintWriter, NumberFormat, int)>
    //    9   17:return          
    }

    public void print(PrintWriter output, NumberFormat format, int width)
    {
        output.println();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #269 <Method void PrintWriter.println()>
        for(int i = 0; i < m; i++)
    //*   2    4:iconst_0        
    //*   3    5:istore          4
    //*   4    7:goto            92
        {
            for(int j = 0; j < n; j++)
    //*   5   10:iconst_0        
    //*   6   11:istore          5
    //*   7   13:goto            76
            {
                String s = format.format(A[i][j]);
    //    8   16:aload_2         
    //    9   17:aload_0         
    //   10   18:getfield        #26  <Field double[][] A>
    //   11   21:iload           4
    //   12   23:aaload          
    //   13   24:iload           5
    //   14   26:daload          
    //   15   27:invokevirtual   #274 <Method String NumberFormat.format(double)>
    //   16   30:astore          6
                int padding = Math.max(1, width - s.length());
    //   17   32:iconst_1        
    //   18   33:iload_3         
    //   19   34:aload           6
    //   20   36:invokevirtual   #279 <Method int String.length()>
    //   21   39:isub            
    //   22   40:invokestatic    #281 <Method int Math.max(int, int)>
    //   23   43:istore          7
                for(int k = 0; k < padding; k++)
    //*  24   45:iconst_0        
    //*  25   46:istore          8
    //*  26   48:goto            60
                    output.print(' ');
    //   27   51:aload_1         
    //   28   52:bipush          32
    //   29   54:invokevirtual   #284 <Method void PrintWriter.print(char)>

    //   30   57:iinc            8  1
    //   31   60:iload           8
    //   32   62:iload           7
    //   33   64:icmplt          51
                output.print(s);
    //   34   67:aload_1         
    //   35   68:aload           6
    //   36   70:invokevirtual   #286 <Method void PrintWriter.print(String)>
            }

    //   37   73:iinc            5  1
    //   38   76:iload           5
    //   39   78:aload_0         
    //   40   79:getfield        #23  <Field int n>
    //   41   82:icmplt          16
            output.println();
    //   42   85:aload_1         
    //   43   86:invokevirtual   #269 <Method void PrintWriter.println()>
        }

    //   44   89:iinc            4  1
    //   45   92:iload           4
    //   46   94:aload_0         
    //   47   95:getfield        #21  <Field int m>
    //   48   98:icmplt          10
        output.println();
    //   49  101:aload_1         
    //   50  102:invokevirtual   #269 <Method void PrintWriter.println()>
    //   51  105:return          
    }

    public static Matrix read(BufferedReader input)
        throws IOException
    {
        StreamTokenizer tokenizer = new StreamTokenizer(input);
    //    0    0:new             #295 <Class StreamTokenizer>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #298 <Method void StreamTokenizer(java.io.Reader)>
    //    4    8:astore_1        
        tokenizer.resetSyntax();
    //    5    9:aload_1         
    //    6   10:invokevirtual   #301 <Method void StreamTokenizer.resetSyntax()>
        tokenizer.wordChars(0, 255);
    //    7   13:aload_1         
    //    8   14:iconst_0        
    //    9   15:sipush          255
    //   10   18:invokevirtual   #304 <Method void StreamTokenizer.wordChars(int, int)>
        tokenizer.whitespaceChars(0, 32);
    //   11   21:aload_1         
    //   12   22:iconst_0        
    //   13   23:bipush          32
    //   14   25:invokevirtual   #307 <Method void StreamTokenizer.whitespaceChars(int, int)>
        tokenizer.eolIsSignificant(true);
    //   15   28:aload_1         
    //   16   29:iconst_1        
    //   17   30:invokevirtual   #310 <Method void StreamTokenizer.eolIsSignificant(boolean)>
        Vector v = new Vector();
    //   18   33:new             #312 <Class Vector>
    //   19   36:dup             
    //   20   37:invokespecial   #313 <Method void Vector()>
    //   21   40:astore_2        
        while(tokenizer.nextToken() == 10) ;
    //   22   41:aload_1         
    //   23   42:invokevirtual   #316 <Method int StreamTokenizer.nextToken()>
    //   24   45:bipush          10
    //   25   47:icmpeq          41
        if(tokenizer.ttype == -1)
    //*  26   50:aload_1         
    //*  27   51:getfield        #319 <Field int StreamTokenizer.ttype>
    //*  28   54:iconst_m1       
    //*  29   55:icmpne          69
            throw new IOException("Unexpected EOF on matrix read.");
    //   30   58:new             #293 <Class IOException>
    //   31   61:dup             
    //   32   62:ldc2            #321 <String "Unexpected EOF on matrix read.">
    //   33   65:invokespecial   #322 <Method void IOException(String)>
    //   34   68:athrow          
        do
            v.addElement(Double.valueOf(tokenizer.sval));
    //   35   69:aload_2         
    //   36   70:aload_1         
    //   37   71:getfield        #325 <Field String StreamTokenizer.sval>
    //   38   74:invokestatic    #331 <Method Double Double.valueOf(String)>
    //   39   77:invokevirtual   #335 <Method void Vector.addElement(Object)>
        while(tokenizer.nextToken() == -3);
    //   40   80:aload_1         
    //   41   81:invokevirtual   #316 <Method int StreamTokenizer.nextToken()>
    //   42   84:bipush          -3
    //   43   86:icmpeq          69
        int n = v.size();
    //   44   89:aload_2         
    //   45   90:invokevirtual   #338 <Method int Vector.size()>
    //   46   93:istore_3        
        double row[] = new double[n];
    //   47   94:iload_3         
    //   48   95:newarray        double[]
    //   49   97:astore          4
        for(int j = 0; j < n; j++)
    //*  50   99:iconst_0        
    //*  51  100:istore          5
    //*  52  102:goto            128
            row[j] = ((Double)(Double)v.elementAt(j)).doubleValue();
    //   53  105:aload           4
    //   54  107:iload           5
    //   55  109:aload_2         
    //   56  110:iload           5
    //   57  112:invokevirtual   #342 <Method Object Vector.elementAt(int)>
    //   58  115:checkcast       #327 <Class Double>
    //   59  118:checkcast       #327 <Class Double>
    //   60  121:invokevirtual   #345 <Method double Double.doubleValue()>
    //   61  124:dastore         

    //   62  125:iinc            5  1
    //   63  128:iload           5
    //   64  130:iload_3         
    //   65  131:icmplt          105
        v.removeAllElements();
    //   66  134:aload_2         
    //   67  135:invokevirtual   #348 <Method void Vector.removeAllElements()>
        v.addElement(row);
    //   68  138:aload_2         
    //   69  139:aload           4
    //   70  141:invokevirtual   #335 <Method void Vector.addElement(Object)>
    //*  71  144:goto            267
        while(tokenizer.nextToken() == -3) 
        {
            v.addElement(row = new double[n]);
    //   72  147:aload_2         
    //   73  148:iload_3         
    //   74  149:newarray        double[]
    //   75  151:dup             
    //   76  152:astore          4
    //   77  154:invokevirtual   #335 <Method void Vector.addElement(Object)>
            int j = 0;
    //   78  157:iconst_0        
    //   79  158:istore          5
            do
            {
                if(j >= n)
    //*  80  160:iload           5
    //*  81  162:iload_3         
    //*  82  163:icmplt          200
                    throw new IOException((new StringBuilder("Row ")).append(v.size()).append(" is too long.").toString());
    //   83  166:new             #293 <Class IOException>
    //   84  169:dup             
    //   85  170:new             #350 <Class StringBuilder>
    //   86  173:dup             
    //   87  174:ldc2            #352 <String "Row ">
    //   88  177:invokespecial   #353 <Method void StringBuilder(String)>
    //   89  180:aload_2         
    //   90  181:invokevirtual   #338 <Method int Vector.size()>
    //   91  184:invokevirtual   #357 <Method StringBuilder StringBuilder.append(int)>
    //   92  187:ldc2            #359 <String " is too long.">
    //   93  190:invokevirtual   #362 <Method StringBuilder StringBuilder.append(String)>
    //   94  193:invokevirtual   #366 <Method String StringBuilder.toString()>
    //   95  196:invokespecial   #322 <Method void IOException(String)>
    //   96  199:athrow          
                row[j++] = Double.valueOf(tokenizer.sval).doubleValue();
    //   97  200:aload           4
    //   98  202:iload           5
    //   99  204:iinc            5  1
    //  100  207:aload_1         
    //  101  208:getfield        #325 <Field String StreamTokenizer.sval>
    //  102  211:invokestatic    #331 <Method Double Double.valueOf(String)>
    //  103  214:invokevirtual   #345 <Method double Double.doubleValue()>
    //  104  217:dastore         
            } while(tokenizer.nextToken() == -3);
    //  105  218:aload_1         
    //  106  219:invokevirtual   #316 <Method int StreamTokenizer.nextToken()>
    //  107  222:bipush          -3
    //  108  224:icmpeq          160
            if(j < n)
    //* 109  227:iload           5
    //* 110  229:iload_3         
    //* 111  230:icmpge          267
                throw new IOException((new StringBuilder("Row ")).append(v.size()).append(" is too short.").toString());
    //  112  233:new             #293 <Class IOException>
    //  113  236:dup             
    //  114  237:new             #350 <Class StringBuilder>
    //  115  240:dup             
    //  116  241:ldc2            #352 <String "Row ">
    //  117  244:invokespecial   #353 <Method void StringBuilder(String)>
    //  118  247:aload_2         
    //  119  248:invokevirtual   #338 <Method int Vector.size()>
    //  120  251:invokevirtual   #357 <Method StringBuilder StringBuilder.append(int)>
    //  121  254:ldc2            #368 <String " is too short.">
    //  122  257:invokevirtual   #362 <Method StringBuilder StringBuilder.append(String)>
    //  123  260:invokevirtual   #366 <Method String StringBuilder.toString()>
    //  124  263:invokespecial   #322 <Method void IOException(String)>
    //  125  266:athrow          
        }
    //  126  267:aload_1         
    //  127  268:invokevirtual   #316 <Method int StreamTokenizer.nextToken()>
    //  128  271:bipush          -3
    //  129  273:icmpeq          147
        int m = v.size();
    //  130  276:aload_2         
    //  131  277:invokevirtual   #338 <Method int Vector.size()>
    //  132  280:istore          5
        double A[][] = new double[m][];
    //  133  282:iload           5
    //  134  284:multianewarray  double[][]
    //  135  288:astore          6
        v.copyInto(A);
    //  136  290:aload_2         
    //  137  291:aload           6
    //  138  293:invokevirtual   #372 <Method void Vector.copyInto(Object[])>
        return new Matrix(A);
    //  139  296:new             #2   <Class Matrix>
    //  140  299:dup             
    //  141  300:aload           6
    //  142  302:invokespecial   #374 <Method void Matrix(double[][])>
    //  143  305:areturn         
    }

    private void checkMatrixDimensions(Matrix B)
    {
        if(B.m != m || B.n != n)
    //*   0    0:aload_1         
    //*   1    1:getfield        #21  <Field int m>
    //*   2    4:aload_0         
    //*   3    5:getfield        #21  <Field int m>
    //*   4    8:icmpne          22
    //*   5   11:aload_1         
    //*   6   12:getfield        #23  <Field int n>
    //*   7   15:aload_0         
    //*   8   16:getfield        #23  <Field int n>
    //*   9   19:icmpeq          33
            throw new IllegalArgumentException("Matrix dimensions must agree.");
    //   10   22:new             #38  <Class IllegalArgumentException>
    //   11   25:dup             
    //   12   26:ldc2            #383 <String "Matrix dimensions must agree.">
    //   13   29:invokespecial   #43  <Method void IllegalArgumentException(String)>
    //   14   32:athrow          
        else
            return;
    //   15   33:return          
    }

    private double A[][];
    private int m;
    private int n;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   LUDecomposition.java

package rm.core.matrix;

import java.io.Serializable;

// Referenced classes of package rm.core.matrix:
//            Matrix

public class LUDecomposition
    implements Serializable
{

    public LUDecomposition(Matrix A)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
        LU = A.getArrayCopy();
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #26  <Method double[][] Matrix.getArrayCopy()>
    //    5    9:putfield        #28  <Field double[][] LU>
        m = A.getRowDimension();
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:invokevirtual   #32  <Method int Matrix.getRowDimension()>
    //    9   17:putfield        #34  <Field int m>
        n = A.getColumnDimension();
    //   10   20:aload_0         
    //   11   21:aload_1         
    //   12   22:invokevirtual   #37  <Method int Matrix.getColumnDimension()>
    //   13   25:putfield        #39  <Field int n>
        piv = new int[m];
    //   14   28:aload_0         
    //   15   29:aload_0         
    //   16   30:getfield        #34  <Field int m>
    //   17   33:newarray        int[]
    //   18   35:putfield        #41  <Field int[] piv>
        for(int i = 0; i < m; i++)
    //*  19   38:iconst_0        
    //*  20   39:istore_2        
    //*  21   40:goto            53
            piv[i] = i;
    //   22   43:aload_0         
    //   23   44:getfield        #41  <Field int[] piv>
    //   24   47:iload_2         
    //   25   48:iload_2         
    //   26   49:iastore         

    //   27   50:iinc            2  1
    //   28   53:iload_2         
    //   29   54:aload_0         
    //   30   55:getfield        #34  <Field int m>
    //   31   58:icmplt          43
        pivsign = 1;
    //   32   61:aload_0         
    //   33   62:iconst_1        
    //   34   63:putfield        #43  <Field int pivsign>
        double LUcolj[] = new double[m];
    //   35   66:aload_0         
    //   36   67:getfield        #34  <Field int m>
    //   37   70:newarray        double[]
    //   38   72:astore_3        
        for(int j = 0; j < n; j++)
    //*  39   73:iconst_0        
    //*  40   74:istore          4
    //*  41   76:goto            435
        {
            for(int i = 0; i < m; i++)
    //*  42   79:iconst_0        
    //*  43   80:istore          5
    //*  44   82:goto            102
                LUcolj[i] = LU[i][j];
    //   45   85:aload_3         
    //   46   86:iload           5
    //   47   88:aload_0         
    //   48   89:getfield        #28  <Field double[][] LU>
    //   49   92:iload           5
    //   50   94:aaload          
    //   51   95:iload           4
    //   52   97:daload          
    //   53   98:dastore         

    //   54   99:iinc            5  1
    //   55  102:iload           5
    //   56  104:aload_0         
    //   57  105:getfield        #34  <Field int m>
    //   58  108:icmplt          85
            for(int i = 0; i < m; i++)
    //*  59  111:iconst_0        
    //*  60  112:istore          5
    //*  61  114:goto            184
            {
                double LUrowi[] = LU[i];
    //   62  117:aload_0         
    //   63  118:getfield        #28  <Field double[][] LU>
    //   64  121:iload           5
    //   65  123:aaload          
    //   66  124:astore_2        
                int kmax = Math.min(i, j);
    //   67  125:iload           5
    //   68  127:iload           4
    //   69  129:invokestatic    #49  <Method int Math.min(int, int)>
    //   70  132:istore          6
                double s = 0.0D;
    //   71  134:dconst_0        
    //   72  135:dstore          7
                for(int k = 0; k < kmax; k++)
    //*  73  137:iconst_0        
    //*  74  138:istore          9
    //*  75  140:goto            160
                    s += LUrowi[k] * LUcolj[k];
    //   76  143:dload           7
    //   77  145:aload_2         
    //   78  146:iload           9
    //   79  148:daload          
    //   80  149:aload_3         
    //   81  150:iload           9
    //   82  152:daload          
    //   83  153:dmul            
    //   84  154:dadd            
    //   85  155:dstore          7

    //   86  157:iinc            9  1
    //   87  160:iload           9
    //   88  162:iload           6
    //   89  164:icmplt          143
                LUrowi[j] = LUcolj[i] -= s;
    //   90  167:aload_2         
    //   91  168:iload           4
    //   92  170:aload_3         
    //   93  171:iload           5
    //   94  173:dup2            
    //   95  174:daload          
    //   96  175:dload           7
    //   97  177:dsub            
    //   98  178:dup2_x2         
    //   99  179:dastore         
    //  100  180:dastore         
            }

    //  101  181:iinc            5  1
    //  102  184:iload           5
    //  103  186:aload_0         
    //  104  187:getfield        #34  <Field int m>
    //  105  190:icmplt          117
            int p = j;
    //  106  193:iload           4
    //  107  195:istore          5
            for(int i = j + 1; i < m; i++)
    //* 108  197:iload           4
    //* 109  199:iconst_1        
    //* 110  200:iadd            
    //* 111  201:istore          6
    //* 112  203:goto            231
                if(Math.abs(LUcolj[i]) > Math.abs(LUcolj[p]))
    //* 113  206:aload_3         
    //* 114  207:iload           6
    //* 115  209:daload          
    //* 116  210:invokestatic    #53  <Method double Math.abs(double)>
    //* 117  213:aload_3         
    //* 118  214:iload           5
    //* 119  216:daload          
    //* 120  217:invokestatic    #53  <Method double Math.abs(double)>
    //* 121  220:dcmpl           
    //* 122  221:ifle            228
                    p = i;
    //  123  224:iload           6
    //  124  226:istore          5

    //  125  228:iinc            6  1
    //  126  231:iload           6
    //  127  233:aload_0         
    //  128  234:getfield        #34  <Field int m>
    //  129  237:icmplt          206
            if(p != j)
    //* 130  240:iload           5
    //* 131  242:iload           4
    //* 132  244:icmpeq          350
            {
                int k;
                for(k = 0; k < n; k++)
    //* 133  247:iconst_0        
    //* 134  248:istore          6
    //* 135  250:goto            300
                {
                    double t = LU[p][k];
    //  136  253:aload_0         
    //  137  254:getfield        #28  <Field double[][] LU>
    //  138  257:iload           5
    //  139  259:aaload          
    //  140  260:iload           6
    //  141  262:daload          
    //  142  263:dstore          7
                    LU[p][k] = LU[j][k];
    //  143  265:aload_0         
    //  144  266:getfield        #28  <Field double[][] LU>
    //  145  269:iload           5
    //  146  271:aaload          
    //  147  272:iload           6
    //  148  274:aload_0         
    //  149  275:getfield        #28  <Field double[][] LU>
    //  150  278:iload           4
    //  151  280:aaload          
    //  152  281:iload           6
    //  153  283:daload          
    //  154  284:dastore         
                    LU[j][k] = t;
    //  155  285:aload_0         
    //  156  286:getfield        #28  <Field double[][] LU>
    //  157  289:iload           4
    //  158  291:aaload          
    //  159  292:iload           6
    //  160  294:dload           7
    //  161  296:dastore         
                }

    //  162  297:iinc            6  1
    //  163  300:iload           6
    //  164  302:aload_0         
    //  165  303:getfield        #39  <Field int n>
    //  166  306:icmplt          253
                k = piv[p];
    //  167  309:aload_0         
    //  168  310:getfield        #41  <Field int[] piv>
    //  169  313:iload           5
    //  170  315:iaload          
    //  171  316:istore          6
                piv[p] = piv[j];
    //  172  318:aload_0         
    //  173  319:getfield        #41  <Field int[] piv>
    //  174  322:iload           5
    //  175  324:aload_0         
    //  176  325:getfield        #41  <Field int[] piv>
    //  177  328:iload           4
    //  178  330:iaload          
    //  179  331:iastore         
                piv[j] = k;
    //  180  332:aload_0         
    //  181  333:getfield        #41  <Field int[] piv>
    //  182  336:iload           4
    //  183  338:iload           6
    //  184  340:iastore         
                pivsign = -pivsign;
    //  185  341:aload_0         
    //  186  342:aload_0         
    //  187  343:getfield        #43  <Field int pivsign>
    //  188  346:ineg            
    //  189  347:putfield        #43  <Field int pivsign>
            }
            if((j < m) & (LU[j][j] != 0.0D))
    //* 190  350:iload           4
    //* 191  352:aload_0         
    //* 192  353:getfield        #34  <Field int m>
    //* 193  356:icmpge          363
    //* 194  359:iconst_1        
    //* 195  360:goto            364
    //* 196  363:iconst_0        
    //* 197  364:aload_0         
    //* 198  365:getfield        #28  <Field double[][] LU>
    //* 199  368:iload           4
    //* 200  370:aaload          
    //* 201  371:iload           4
    //* 202  373:daload          
    //* 203  374:dconst_0        
    //* 204  375:dcmpl           
    //* 205  376:ifeq            383
    //* 206  379:iconst_1        
    //* 207  380:goto            384
    //* 208  383:iconst_0        
    //* 209  384:iand            
    //* 210  385:ifeq            432
            {
                for(int i = j + 1; i < m; i++)
    //* 211  388:iload           4
    //* 212  390:iconst_1        
    //* 213  391:iadd            
    //* 214  392:istore          6
    //* 215  394:goto            423
                    LU[i][j] /= LU[j][j];
    //  216  397:aload_0         
    //  217  398:getfield        #28  <Field double[][] LU>
    //  218  401:iload           6
    //  219  403:aaload          
    //  220  404:iload           4
    //  221  406:dup2            
    //  222  407:daload          
    //  223  408:aload_0         
    //  224  409:getfield        #28  <Field double[][] LU>
    //  225  412:iload           4
    //  226  414:aaload          
    //  227  415:iload           4
    //  228  417:daload          
    //  229  418:ddiv            
    //  230  419:dastore         

    //  231  420:iinc            6  1
    //  232  423:iload           6
    //  233  425:aload_0         
    //  234  426:getfield        #34  <Field int m>
    //  235  429:icmplt          397
            }
        }

    //  236  432:iinc            4  1
    //  237  435:iload           4
    //  238  437:aload_0         
    //  239  438:getfield        #39  <Field int n>
    //  240  441:icmplt          79
    //  241  444:return          
    }

    public boolean isNonsingular()
    {
        for(int j = 0; j < n; j++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            23
            if(LU[j][j] == 0.0D)
    //*   3    5:aload_0         
    //*   4    6:getfield        #28  <Field double[][] LU>
    //*   5    9:iload_1         
    //*   6   10:aaload          
    //*   7   11:iload_1         
    //*   8   12:daload          
    //*   9   13:dconst_0        
    //*  10   14:dcmpl           
    //*  11   15:ifne            20
                return false;
    //   12   18:iconst_0        
    //   13   19:ireturn         

    //   14   20:iinc            1  1
    //   15   23:iload_1         
    //   16   24:aload_0         
    //   17   25:getfield        #39  <Field int n>
    //   18   28:icmplt          5
        return true;
    //   19   31:iconst_1        
    //   20   32:ireturn         
    }

    public Matrix getL()
    {
        Matrix X = new Matrix(m, n);
    //    0    0:new             #22  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #34  <Field int m>
    //    4    8:aload_0         
    //    5    9:getfield        #39  <Field int n>
    //    6   12:invokespecial   #77  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double L[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #80  <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < m; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            94
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            82
                if(i > j)
    //*  17   32:iload_3         
    //*  18   33:iload           4
    //*  19   35:icmple          56
                    L[i][j] = LU[i][j];
    //   20   38:aload_2         
    //   21   39:iload_3         
    //   22   40:aaload          
    //   23   41:iload           4
    //   24   43:aload_0         
    //   25   44:getfield        #28  <Field double[][] LU>
    //   26   47:iload_3         
    //   27   48:aaload          
    //   28   49:iload           4
    //   29   51:daload          
    //   30   52:dastore         
                else
    //*  31   53:goto            79
                if(i == j)
    //*  32   56:iload_3         
    //*  33   57:iload           4
    //*  34   59:icmpne          72
                    L[i][j] = 1.0D;
    //   35   62:aload_2         
    //   36   63:iload_3         
    //   37   64:aaload          
    //   38   65:iload           4
    //   39   67:dconst_1        
    //   40   68:dastore         
                else
    //*  41   69:goto            79
                    L[i][j] = 0.0D;
    //   42   72:aload_2         
    //   43   73:iload_3         
    //   44   74:aaload          
    //   45   75:iload           4
    //   46   77:dconst_0        
    //   47   78:dastore         

    //   48   79:iinc            4  1
    //   49   82:iload           4
    //   50   84:aload_0         
    //   51   85:getfield        #39  <Field int n>
    //   52   88:icmplt          32
        }

    //   53   91:iinc            3  1
    //   54   94:iload_3         
    //   55   95:aload_0         
    //   56   96:getfield        #34  <Field int m>
    //   57   99:icmplt          26
        return X;
    //   58  102:aload_1         
    //   59  103:areturn         
    }

    public Matrix getU()
    {
        Matrix X = new Matrix(n, n);
    //    0    0:new             #22  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #39  <Field int n>
    //    4    8:aload_0         
    //    5    9:getfield        #39  <Field int n>
    //    6   12:invokespecial   #77  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double U[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #80  <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < n; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            78
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            66
                if(i <= j)
    //*  17   32:iload_3         
    //*  18   33:iload           4
    //*  19   35:icmpgt          56
                    U[i][j] = LU[i][j];
    //   20   38:aload_2         
    //   21   39:iload_3         
    //   22   40:aaload          
    //   23   41:iload           4
    //   24   43:aload_0         
    //   25   44:getfield        #28  <Field double[][] LU>
    //   26   47:iload_3         
    //   27   48:aaload          
    //   28   49:iload           4
    //   29   51:daload          
    //   30   52:dastore         
                else
    //*  31   53:goto            63
                    U[i][j] = 0.0D;
    //   32   56:aload_2         
    //   33   57:iload_3         
    //   34   58:aaload          
    //   35   59:iload           4
    //   36   61:dconst_0        
    //   37   62:dastore         

    //   38   63:iinc            4  1
    //   39   66:iload           4
    //   40   68:aload_0         
    //   41   69:getfield        #39  <Field int n>
    //   42   72:icmplt          32
        }

    //   43   75:iinc            3  1
    //   44   78:iload_3         
    //   45   79:aload_0         
    //   46   80:getfield        #39  <Field int n>
    //   47   83:icmplt          26
        return X;
    //   48   86:aload_1         
    //   49   87:areturn         
    }

    public int[] getPivot()
    {
        int p[] = new int[m];
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field int m>
    //    2    4:newarray        int[]
    //    3    6:astore_1        
        for(int i = 0; i < m; i++)
    //*   4    7:iconst_0        
    //*   5    8:istore_2        
    //*   6    9:goto            24
            p[i] = piv[i];
    //    7   12:aload_1         
    //    8   13:iload_2         
    //    9   14:aload_0         
    //   10   15:getfield        #41  <Field int[] piv>
    //   11   18:iload_2         
    //   12   19:iaload          
    //   13   20:iastore         

    //   14   21:iinc            2  1
    //   15   24:iload_2         
    //   16   25:aload_0         
    //   17   26:getfield        #34  <Field int m>
    //   18   29:icmplt          12
        return p;
    //   19   32:aload_1         
    //   20   33:areturn         
    }

    public double[] getDoublePivot()
    {
        double vals[] = new double[m];
    //    0    0:aload_0         
    //    1    1:getfield        #34  <Field int m>
    //    2    4:newarray        double[]
    //    3    6:astore_1        
        for(int i = 0; i < m; i++)
    //*   4    7:iconst_0        
    //*   5    8:istore_2        
    //*   6    9:goto            25
            vals[i] = piv[i];
    //    7   12:aload_1         
    //    8   13:iload_2         
    //    9   14:aload_0         
    //   10   15:getfield        #41  <Field int[] piv>
    //   11   18:iload_2         
    //   12   19:iaload          
    //   13   20:i2d             
    //   14   21:dastore         

    //   15   22:iinc            2  1
    //   16   25:iload_2         
    //   17   26:aload_0         
    //   18   27:getfield        #34  <Field int m>
    //   19   30:icmplt          12
        return vals;
    //   20   33:aload_1         
    //   21   34:areturn         
    }

    public double det()
    {
        if(m != n)
    //*   0    0:aload_0         
    //*   1    1:getfield        #34  <Field int m>
    //*   2    4:aload_0         
    //*   3    5:getfield        #39  <Field int n>
    //*   4    8:icmpeq          21
            throw new IllegalArgumentException("Matrix must be square.");
    //    5   11:new             #93  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc1            #95  <String "Matrix must be square.">
    //    8   17:invokespecial   #98  <Method void IllegalArgumentException(String)>
    //    9   20:athrow          
        double d = pivsign;
    //   10   21:aload_0         
    //   11   22:getfield        #43  <Field int pivsign>
    //   12   25:i2d             
    //   13   26:dstore_1        
        for(int j = 0; j < n; j++)
    //*  14   27:iconst_0        
    //*  15   28:istore_3        
    //*  16   29:goto            46
            d *= LU[j][j];
    //   17   32:dload_1         
    //   18   33:aload_0         
    //   19   34:getfield        #28  <Field double[][] LU>
    //   20   37:iload_3         
    //   21   38:aaload          
    //   22   39:iload_3         
    //   23   40:daload          
    //   24   41:dmul            
    //   25   42:dstore_1        

    //   26   43:iinc            3  1
    //   27   46:iload_3         
    //   28   47:aload_0         
    //   29   48:getfield        #39  <Field int n>
    //   30   51:icmplt          32
        return d;
    //   31   54:dload_1         
    //   32   55:dreturn         
    }

    public Matrix solve(Matrix B)
    {
        if(B.getRowDimension() != m)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #32  <Method int Matrix.getRowDimension()>
    //*   2    4:aload_0         
    //*   3    5:getfield        #34  <Field int m>
    //*   4    8:icmpeq          21
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
    //    5   11:new             #93  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc1            #103 <String "Matrix row dimensions must agree.">
    //    8   17:invokespecial   #98  <Method void IllegalArgumentException(String)>
    //    9   20:athrow          
        if(!isNonsingular())
    //*  10   21:aload_0         
    //*  11   22:invokevirtual   #105 <Method boolean isNonsingular()>
    //*  12   25:ifne            38
            throw new RuntimeException("Matrix is singular.");
    //   13   28:new             #107 <Class RuntimeException>
    //   14   31:dup             
    //   15   32:ldc1            #109 <String "Matrix is singular.">
    //   16   34:invokespecial   #110 <Method void RuntimeException(String)>
    //   17   37:athrow          
        int nx = B.getColumnDimension();
    //   18   38:aload_1         
    //   19   39:invokevirtual   #37  <Method int Matrix.getColumnDimension()>
    //   20   42:istore_2        
        Matrix Xmat = B.getMatrix(piv, 0, nx - 1);
    //   21   43:aload_1         
    //   22   44:aload_0         
    //   23   45:getfield        #41  <Field int[] piv>
    //   24   48:iconst_0        
    //   25   49:iload_2         
    //   26   50:iconst_1        
    //   27   51:isub            
    //   28   52:invokevirtual   #114 <Method Matrix Matrix.getMatrix(int[], int, int)>
    //   29   55:astore_3        
        double X[][] = Xmat.getArray();
    //   30   56:aload_3         
    //   31   57:invokevirtual   #80  <Method double[][] Matrix.getArray()>
    //   32   60:astore          4
        for(int k = 0; k < n; k++)
    //*  33   62:iconst_0        
    //*  34   63:istore          5
    //*  35   65:goto            137
        {
            for(int i = k + 1; i < n; i++)
    //*  36   68:iload           5
    //*  37   70:iconst_1        
    //*  38   71:iadd            
    //*  39   72:istore          6
    //*  40   74:goto            125
            {
                for(int j = 0; j < nx; j++)
    //*  41   77:iconst_0        
    //*  42   78:istore          7
    //*  43   80:goto            116
                    X[i][j] -= X[k][j] * LU[i][k];
    //   44   83:aload           4
    //   45   85:iload           6
    //   46   87:aaload          
    //   47   88:iload           7
    //   48   90:dup2            
    //   49   91:daload          
    //   50   92:aload           4
    //   51   94:iload           5
    //   52   96:aaload          
    //   53   97:iload           7
    //   54   99:daload          
    //   55  100:aload_0         
    //   56  101:getfield        #28  <Field double[][] LU>
    //   57  104:iload           6
    //   58  106:aaload          
    //   59  107:iload           5
    //   60  109:daload          
    //   61  110:dmul            
    //   62  111:dsub            
    //   63  112:dastore         

    //   64  113:iinc            7  1
    //   65  116:iload           7
    //   66  118:iload_2         
    //   67  119:icmplt          83
            }

    //   68  122:iinc            6  1
    //   69  125:iload           6
    //   70  127:aload_0         
    //   71  128:getfield        #39  <Field int n>
    //   72  131:icmplt          77
        }

    //   73  134:iinc            5  1
    //   74  137:iload           5
    //   75  139:aload_0         
    //   76  140:getfield        #39  <Field int n>
    //   77  143:icmplt          68
        for(int k = n - 1; k >= 0; k--)
    //*  78  146:aload_0         
    //*  79  147:getfield        #39  <Field int n>
    //*  80  150:iconst_1        
    //*  81  151:isub            
    //*  82  152:istore          5
    //*  83  154:goto            257
        {
            for(int j = 0; j < nx; j++)
    //*  84  157:iconst_0        
    //*  85  158:istore          6
    //*  86  160:goto            187
                X[k][j] /= LU[k][k];
    //   87  163:aload           4
    //   88  165:iload           5
    //   89  167:aaload          
    //   90  168:iload           6
    //   91  170:dup2            
    //   92  171:daload          
    //   93  172:aload_0         
    //   94  173:getfield        #28  <Field double[][] LU>
    //   95  176:iload           5
    //   96  178:aaload          
    //   97  179:iload           5
    //   98  181:daload          
    //   99  182:ddiv            
    //  100  183:dastore         

    //  101  184:iinc            6  1
    //  102  187:iload           6
    //  103  189:iload_2         
    //  104  190:icmplt          163
            for(int i = 0; i < k; i++)
    //* 105  193:iconst_0        
    //* 106  194:istore          6
    //* 107  196:goto            247
            {
                for(int j = 0; j < nx; j++)
    //* 108  199:iconst_0        
    //* 109  200:istore          7
    //* 110  202:goto            238
                    X[i][j] -= X[k][j] * LU[i][k];
    //  111  205:aload           4
    //  112  207:iload           6
    //  113  209:aaload          
    //  114  210:iload           7
    //  115  212:dup2            
    //  116  213:daload          
    //  117  214:aload           4
    //  118  216:iload           5
    //  119  218:aaload          
    //  120  219:iload           7
    //  121  221:daload          
    //  122  222:aload_0         
    //  123  223:getfield        #28  <Field double[][] LU>
    //  124  226:iload           6
    //  125  228:aaload          
    //  126  229:iload           5
    //  127  231:daload          
    //  128  232:dmul            
    //  129  233:dsub            
    //  130  234:dastore         

    //  131  235:iinc            7  1
    //  132  238:iload           7
    //  133  240:iload_2         
    //  134  241:icmplt          205
            }

    //  135  244:iinc            6  1
    //  136  247:iload           6
    //  137  249:iload           5
    //  138  251:icmplt          199
        }

    //  139  254:iinc            5  -1
    //  140  257:iload           5
    //  141  259:ifge            157
        return Xmat;
    //  142  262:aload_3         
    //  143  263:areturn         
    }

    private double LU[][];
    private int m;
    private int n;
    private int pivsign;
    private int piv[];
}

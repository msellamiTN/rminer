// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CholeskyDecomposition.java

package rm.core.matrix;

import java.io.Serializable;

// Referenced classes of package rm.core.matrix:
//            Matrix

public class CholeskyDecomposition
    implements Serializable
{

    public CholeskyDecomposition(Matrix Arg)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void Object()>
        double A[][] = Arg.getArray();
    //    2    4:aload_1         
    //    3    5:invokevirtual   #24  <Method double[][] Matrix.getArray()>
    //    4    8:astore_2        
        n = Arg.getRowDimension();
    //    5    9:aload_0         
    //    6   10:aload_1         
    //    7   11:invokevirtual   #28  <Method int Matrix.getRowDimension()>
    //    8   14:putfield        #30  <Field int n>
        L = new double[n][n];
    //    9   17:aload_0         
    //   10   18:aload_0         
    //   11   19:getfield        #30  <Field int n>
    //   12   22:aload_0         
    //   13   23:getfield        #30  <Field int n>
    //   14   26:multianewarray  double[][]
    //   15   30:putfield        #33  <Field double[][] L>
        isspd = Arg.getColumnDimension() == n;
    //   16   33:aload_0         
    //   17   34:aload_1         
    //   18   35:invokevirtual   #36  <Method int Matrix.getColumnDimension()>
    //   19   38:aload_0         
    //   20   39:getfield        #30  <Field int n>
    //   21   42:icmpne          49
    //   22   45:iconst_1        
    //   23   46:goto            50
    //   24   49:iconst_0        
    //   25   50:putfield        #38  <Field boolean isspd>
        for(int j = 0; j < n; j++)
    //*  26   53:iconst_0        
    //*  27   54:istore_3        
    //*  28   55:goto            277
        {
            double Lrowj[] = L[j];
    //   29   58:aload_0         
    //   30   59:getfield        #33  <Field double[][] L>
    //   31   62:iload_3         
    //   32   63:aaload          
    //   33   64:astore          4
            double d = 0.0D;
    //   34   66:dconst_0        
    //   35   67:dstore          5
            for(int k = 0; k < j; k++)
    //*  36   69:iconst_0        
    //*  37   70:istore          7
    //*  38   72:goto            190
            {
                double Lrowk[] = L[k];
    //   39   75:aload_0         
    //   40   76:getfield        #33  <Field double[][] L>
    //   41   79:iload           7
    //   42   81:aaload          
    //   43   82:astore          8
                double s = 0.0D;
    //   44   84:dconst_0        
    //   45   85:dstore          9
                for(int i = 0; i < k; i++)
    //*  46   87:iconst_0        
    //*  47   88:istore          11
    //*  48   90:goto            112
                    s += Lrowk[i] * Lrowj[i];
    //   49   93:dload           9
    //   50   95:aload           8
    //   51   97:iload           11
    //   52   99:daload          
    //   53  100:aload           4
    //   54  102:iload           11
    //   55  104:daload          
    //   56  105:dmul            
    //   57  106:dadd            
    //   58  107:dstore          9

    //   59  109:iinc            11  1
    //   60  112:iload           11
    //   61  114:iload           7
    //   62  116:icmplt          93
                Lrowj[k] = s = (A[j][k] - s) / L[k][k];
    //   63  119:aload           4
    //   64  121:iload           7
    //   65  123:aload_2         
    //   66  124:iload_3         
    //   67  125:aaload          
    //   68  126:iload           7
    //   69  128:daload          
    //   70  129:dload           9
    //   71  131:dsub            
    //   72  132:aload_0         
    //   73  133:getfield        #33  <Field double[][] L>
    //   74  136:iload           7
    //   75  138:aaload          
    //   76  139:iload           7
    //   77  141:daload          
    //   78  142:ddiv            
    //   79  143:dup2            
    //   80  144:dstore          9
    //   81  146:dastore         
                d += s * s;
    //   82  147:dload           5
    //   83  149:dload           9
    //   84  151:dload           9
    //   85  153:dmul            
    //   86  154:dadd            
    //   87  155:dstore          5
                isspd &= A[k][j] == A[j][k];
    //   88  157:aload_0         
    //   89  158:dup             
    //   90  159:getfield        #38  <Field boolean isspd>
    //   91  162:aload_2         
    //   92  163:iload           7
    //   93  165:aaload          
    //   94  166:iload_3         
    //   95  167:daload          
    //   96  168:aload_2         
    //   97  169:iload_3         
    //   98  170:aaload          
    //   99  171:iload           7
    //  100  173:daload          
    //  101  174:dcmpl           
    //  102  175:ifne            182
    //  103  178:iconst_1        
    //  104  179:goto            183
    //  105  182:iconst_0        
    //  106  183:iand            
    //  107  184:putfield        #38  <Field boolean isspd>
            }

    //  108  187:iinc            7  1
    //  109  190:iload           7
    //  110  192:iload_3         
    //  111  193:icmplt          75
            d = A[j][j] - d;
    //  112  196:aload_2         
    //  113  197:iload_3         
    //  114  198:aaload          
    //  115  199:iload_3         
    //  116  200:daload          
    //  117  201:dload           5
    //  118  203:dsub            
    //  119  204:dstore          5
            isspd &= d > 0.0D;
    //  120  206:aload_0         
    //  121  207:dup             
    //  122  208:getfield        #38  <Field boolean isspd>
    //  123  211:dload           5
    //  124  213:dconst_0        
    //  125  214:dcmpl           
    //  126  215:ifle            222
    //  127  218:iconst_1        
    //  128  219:goto            223
    //  129  222:iconst_0        
    //  130  223:iand            
    //  131  224:putfield        #38  <Field boolean isspd>
            L[j][j] = Math.sqrt(Math.max(d, 0.0D));
    //  132  227:aload_0         
    //  133  228:getfield        #33  <Field double[][] L>
    //  134  231:iload_3         
    //  135  232:aaload          
    //  136  233:iload_3         
    //  137  234:dload           5
    //  138  236:dconst_0        
    //  139  237:invokestatic    #44  <Method double Math.max(double, double)>
    //  140  240:invokestatic    #48  <Method double Math.sqrt(double)>
    //  141  243:dastore         
            for(int k = j + 1; k < n; k++)
    //* 142  244:iload_3         
    //* 143  245:iconst_1        
    //* 144  246:iadd            
    //* 145  247:istore          7
    //* 146  249:goto            265
                L[j][k] = 0.0D;
    //  147  252:aload_0         
    //  148  253:getfield        #33  <Field double[][] L>
    //  149  256:iload_3         
    //  150  257:aaload          
    //  151  258:iload           7
    //  152  260:dconst_0        
    //  153  261:dastore         

    //  154  262:iinc            7  1
    //  155  265:iload           7
    //  156  267:aload_0         
    //  157  268:getfield        #30  <Field int n>
    //  158  271:icmplt          252
        }

    //  159  274:iinc            3  1
    //  160  277:iload_3         
    //  161  278:aload_0         
    //  162  279:getfield        #30  <Field int n>
    //  163  282:icmplt          58
    //  164  285:return          
    }

    public boolean isSPD()
    {
        return isspd;
    //    0    0:aload_0         
    //    1    1:getfield        #38  <Field boolean isspd>
    //    2    4:ireturn         
    }

    public Matrix getL()
    {
        return new Matrix(L, n, n);
    //    0    0:new             #20  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #33  <Field double[][] L>
    //    4    8:aload_0         
    //    5    9:getfield        #30  <Field int n>
    //    6   12:aload_0         
    //    7   13:getfield        #30  <Field int n>
    //    8   16:invokespecial   #71  <Method void Matrix(double[][], int, int)>
    //    9   19:areturn         
    }

    public Matrix solve(Matrix B)
    {
        if(B.getRowDimension() != n)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #28  <Method int Matrix.getRowDimension()>
    //*   2    4:aload_0         
    //*   3    5:getfield        #30  <Field int n>
    //*   4    8:icmpeq          21
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
    //    5   11:new             #75  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc1            #77  <String "Matrix row dimensions must agree.">
    //    8   17:invokespecial   #80  <Method void IllegalArgumentException(String)>
    //    9   20:athrow          
        if(!isspd)
    //*  10   21:aload_0         
    //*  11   22:getfield        #38  <Field boolean isspd>
    //*  12   25:ifne            38
            throw new RuntimeException("Matrix is not symmetric positive definite.");
    //   13   28:new             #82  <Class RuntimeException>
    //   14   31:dup             
    //   15   32:ldc1            #84  <String "Matrix is not symmetric positive definite.">
    //   16   34:invokespecial   #85  <Method void RuntimeException(String)>
    //   17   37:athrow          
        double X[][] = B.getArrayCopy();
    //   18   38:aload_1         
    //   19   39:invokevirtual   #88  <Method double[][] Matrix.getArrayCopy()>
    //   20   42:astore_2        
        int nx = B.getColumnDimension();
    //   21   43:aload_1         
    //   22   44:invokevirtual   #36  <Method int Matrix.getColumnDimension()>
    //   23   47:istore_3        
        for(int k = 0; k < n; k++)
    //*  24   48:iconst_0        
    //*  25   49:istore          4
    //*  26   51:goto            136
        {
            for(int j = 0; j < nx; j++)
    //*  27   54:iconst_0        
    //*  28   55:istore          5
    //*  29   57:goto            127
            {
                for(int i = 0; i < k; i++)
    //*  30   60:iconst_0        
    //*  31   61:istore          6
    //*  32   63:goto            97
                    X[k][j] -= X[i][j] * L[k][i];
    //   33   66:aload_2         
    //   34   67:iload           4
    //   35   69:aaload          
    //   36   70:iload           5
    //   37   72:dup2            
    //   38   73:daload          
    //   39   74:aload_2         
    //   40   75:iload           6
    //   41   77:aaload          
    //   42   78:iload           5
    //   43   80:daload          
    //   44   81:aload_0         
    //   45   82:getfield        #33  <Field double[][] L>
    //   46   85:iload           4
    //   47   87:aaload          
    //   48   88:iload           6
    //   49   90:daload          
    //   50   91:dmul            
    //   51   92:dsub            
    //   52   93:dastore         

    //   53   94:iinc            6  1
    //   54   97:iload           6
    //   55   99:iload           4
    //   56  101:icmplt          66
                X[k][j] /= L[k][k];
    //   57  104:aload_2         
    //   58  105:iload           4
    //   59  107:aaload          
    //   60  108:iload           5
    //   61  110:dup2            
    //   62  111:daload          
    //   63  112:aload_0         
    //   64  113:getfield        #33  <Field double[][] L>
    //   65  116:iload           4
    //   66  118:aaload          
    //   67  119:iload           4
    //   68  121:daload          
    //   69  122:ddiv            
    //   70  123:dastore         
            }

    //   71  124:iinc            5  1
    //   72  127:iload           5
    //   73  129:iload_3         
    //   74  130:icmplt          60
        }

    //   75  133:iinc            4  1
    //   76  136:iload           4
    //   77  138:aload_0         
    //   78  139:getfield        #30  <Field int n>
    //   79  142:icmplt          54
        for(int k = n - 1; k >= 0; k--)
    //*  80  145:aload_0         
    //*  81  146:getfield        #30  <Field int n>
    //*  82  149:iconst_1        
    //*  83  150:isub            
    //*  84  151:istore          4
    //*  85  153:goto            243
        {
            for(int j = 0; j < nx; j++)
    //*  86  156:iconst_0        
    //*  87  157:istore          5
    //*  88  159:goto            234
            {
                for(int i = k + 1; i < n; i++)
    //*  89  162:iload           4
    //*  90  164:iconst_1        
    //*  91  165:iadd            
    //*  92  166:istore          6
    //*  93  168:goto            202
                    X[k][j] -= X[i][j] * L[i][k];
    //   94  171:aload_2         
    //   95  172:iload           4
    //   96  174:aaload          
    //   97  175:iload           5
    //   98  177:dup2            
    //   99  178:daload          
    //  100  179:aload_2         
    //  101  180:iload           6
    //  102  182:aaload          
    //  103  183:iload           5
    //  104  185:daload          
    //  105  186:aload_0         
    //  106  187:getfield        #33  <Field double[][] L>
    //  107  190:iload           6
    //  108  192:aaload          
    //  109  193:iload           4
    //  110  195:daload          
    //  111  196:dmul            
    //  112  197:dsub            
    //  113  198:dastore         

    //  114  199:iinc            6  1
    //  115  202:iload           6
    //  116  204:aload_0         
    //  117  205:getfield        #30  <Field int n>
    //  118  208:icmplt          171
                X[k][j] /= L[k][k];
    //  119  211:aload_2         
    //  120  212:iload           4
    //  121  214:aaload          
    //  122  215:iload           5
    //  123  217:dup2            
    //  124  218:daload          
    //  125  219:aload_0         
    //  126  220:getfield        #33  <Field double[][] L>
    //  127  223:iload           4
    //  128  225:aaload          
    //  129  226:iload           4
    //  130  228:daload          
    //  131  229:ddiv            
    //  132  230:dastore         
            }

    //  133  231:iinc            5  1
    //  134  234:iload           5
    //  135  236:iload_3         
    //  136  237:icmplt          162
        }

    //  137  240:iinc            4  -1
    //  138  243:iload           4
    //  139  245:ifge            156
        return new Matrix(X, n, nx);
    //  140  248:new             #20  <Class Matrix>
    //  141  251:dup             
    //  142  252:aload_2         
    //  143  253:aload_0         
    //  144  254:getfield        #30  <Field int n>
    //  145  257:iload_3         
    //  146  258:invokespecial   #71  <Method void Matrix(double[][], int, int)>
    //  147  261:areturn         
    }

    private double L[][];
    private int n;
    private boolean isspd;
}

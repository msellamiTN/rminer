// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   QRDecomposition.java

package rm.core.matrix;

import java.io.Serializable;

// Referenced classes of package rm.core.matrix:
//            Matrix, Maths

public class QRDecomposition
    implements Serializable
{

    public QRDecomposition(Matrix A)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #19  <Method void Object()>
        QR = A.getArrayCopy();
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #25  <Method double[][] Matrix.getArrayCopy()>
    //    5    9:putfield        #27  <Field double[][] QR>
        m = A.getRowDimension();
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:invokevirtual   #31  <Method int Matrix.getRowDimension()>
    //    9   17:putfield        #33  <Field int m>
        n = A.getColumnDimension();
    //   10   20:aload_0         
    //   11   21:aload_1         
    //   12   22:invokevirtual   #36  <Method int Matrix.getColumnDimension()>
    //   13   25:putfield        #38  <Field int n>
        Rdiag = new double[n];
    //   14   28:aload_0         
    //   15   29:aload_0         
    //   16   30:getfield        #38  <Field int n>
    //   17   33:newarray        double[]
    //   18   35:putfield        #40  <Field double[] Rdiag>
        for(int k = 0; k < n; k++)
    //*  19   38:iconst_0        
    //*  20   39:istore_2        
    //*  21   40:goto            276
        {
            double nrm = 0.0D;
    //   22   43:dconst_0        
    //   23   44:dstore_3        
            for(int i = k; i < m; i++)
    //*  24   45:iload_2         
    //*  25   46:istore          5
    //*  26   48:goto            68
                nrm = Maths.hypot(nrm, QR[i][k]);
    //   27   51:dload_3         
    //   28   52:aload_0         
    //   29   53:getfield        #27  <Field double[][] QR>
    //   30   56:iload           5
    //   31   58:aaload          
    //   32   59:iload_2         
    //   33   60:daload          
    //   34   61:invokestatic    #46  <Method double Maths.hypot(double, double)>
    //   35   64:dstore_3        

    //   36   65:iinc            5  1
    //   37   68:iload           5
    //   38   70:aload_0         
    //   39   71:getfield        #33  <Field int m>
    //   40   74:icmplt          51
            if(nrm != 0.0D)
    //*  41   77:dload_3         
    //*  42   78:dconst_0        
    //*  43   79:dcmpl           
    //*  44   80:ifeq            265
            {
                if(QR[k][k] < 0.0D)
    //*  45   83:aload_0         
    //*  46   84:getfield        #27  <Field double[][] QR>
    //*  47   87:iload_2         
    //*  48   88:aaload          
    //*  49   89:iload_2         
    //*  50   90:daload          
    //*  51   91:dconst_0        
    //*  52   92:dcmpg           
    //*  53   93:ifge            99
                    nrm = -nrm;
    //   54   96:dload_3         
    //   55   97:dneg            
    //   56   98:dstore_3        
                for(int i = k; i < m; i++)
    //*  57   99:iload_2         
    //*  58  100:istore          5
    //*  59  102:goto            121
                    QR[i][k] /= nrm;
    //   60  105:aload_0         
    //   61  106:getfield        #27  <Field double[][] QR>
    //   62  109:iload           5
    //   63  111:aaload          
    //   64  112:iload_2         
    //   65  113:dup2            
    //   66  114:daload          
    //   67  115:dload_3         
    //   68  116:ddiv            
    //   69  117:dastore         

    //   70  118:iinc            5  1
    //   71  121:iload           5
    //   72  123:aload_0         
    //   73  124:getfield        #33  <Field int m>
    //   74  127:icmplt          105
                QR[k][k]++;
    //   75  130:aload_0         
    //   76  131:getfield        #27  <Field double[][] QR>
    //   77  134:iload_2         
    //   78  135:aaload          
    //   79  136:iload_2         
    //   80  137:dup2            
    //   81  138:daload          
    //   82  139:dconst_1        
    //   83  140:dadd            
    //   84  141:dastore         
                for(int j = k + 1; j < n; j++)
    //*  85  142:iload_2         
    //*  86  143:iconst_1        
    //*  87  144:iadd            
    //*  88  145:istore          5
    //*  89  147:goto            256
                {
                    double s = 0.0D;
    //   90  150:dconst_0        
    //   91  151:dstore          6
                    for(int i = k; i < m; i++)
    //*  92  153:iload_2         
    //*  93  154:istore          8
    //*  94  156:goto            187
                        s += QR[i][k] * QR[i][j];
    //   95  159:dload           6
    //   96  161:aload_0         
    //   97  162:getfield        #27  <Field double[][] QR>
    //   98  165:iload           8
    //   99  167:aaload          
    //  100  168:iload_2         
    //  101  169:daload          
    //  102  170:aload_0         
    //  103  171:getfield        #27  <Field double[][] QR>
    //  104  174:iload           8
    //  105  176:aaload          
    //  106  177:iload           5
    //  107  179:daload          
    //  108  180:dmul            
    //  109  181:dadd            
    //  110  182:dstore          6

    //  111  184:iinc            8  1
    //  112  187:iload           8
    //  113  189:aload_0         
    //  114  190:getfield        #33  <Field int m>
    //  115  193:icmplt          159
                    s = -s / QR[k][k];
    //  116  196:dload           6
    //  117  198:dneg            
    //  118  199:aload_0         
    //  119  200:getfield        #27  <Field double[][] QR>
    //  120  203:iload_2         
    //  121  204:aaload          
    //  122  205:iload_2         
    //  123  206:daload          
    //  124  207:ddiv            
    //  125  208:dstore          6
                    for(int i = k; i < m; i++)
    //* 126  210:iload_2         
    //* 127  211:istore          8
    //* 128  213:goto            244
                        QR[i][j] += s * QR[i][k];
    //  129  216:aload_0         
    //  130  217:getfield        #27  <Field double[][] QR>
    //  131  220:iload           8
    //  132  222:aaload          
    //  133  223:iload           5
    //  134  225:dup2            
    //  135  226:daload          
    //  136  227:dload           6
    //  137  229:aload_0         
    //  138  230:getfield        #27  <Field double[][] QR>
    //  139  233:iload           8
    //  140  235:aaload          
    //  141  236:iload_2         
    //  142  237:daload          
    //  143  238:dmul            
    //  144  239:dadd            
    //  145  240:dastore         

    //  146  241:iinc            8  1
    //  147  244:iload           8
    //  148  246:aload_0         
    //  149  247:getfield        #33  <Field int m>
    //  150  250:icmplt          216
                }

    //  151  253:iinc            5  1
    //  152  256:iload           5
    //  153  258:aload_0         
    //  154  259:getfield        #38  <Field int n>
    //  155  262:icmplt          150
            }
            Rdiag[k] = -nrm;
    //  156  265:aload_0         
    //  157  266:getfield        #40  <Field double[] Rdiag>
    //  158  269:iload_2         
    //  159  270:dload_3         
    //  160  271:dneg            
    //  161  272:dastore         
        }

    //  162  273:iinc            2  1
    //  163  276:iload_2         
    //  164  277:aload_0         
    //  165  278:getfield        #38  <Field int n>
    //  166  281:icmplt          43
    //  167  284:return          
    }

    public boolean isFullRank()
    {
        for(int j = 0; j < n; j++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            21
            if(Rdiag[j] == 0.0D)
    //*   3    5:aload_0         
    //*   4    6:getfield        #40  <Field double[] Rdiag>
    //*   5    9:iload_1         
    //*   6   10:daload          
    //*   7   11:dconst_0        
    //*   8   12:dcmpl           
    //*   9   13:ifne            18
                return false;
    //   10   16:iconst_0        
    //   11   17:ireturn         

    //   12   18:iinc            1  1
    //   13   21:iload_1         
    //   14   22:aload_0         
    //   15   23:getfield        #38  <Field int n>
    //   16   26:icmplt          5
        return true;
    //   17   29:iconst_1        
    //   18   30:ireturn         
    }

    public Matrix getH()
    {
        Matrix X = new Matrix(m, n);
    //    0    0:new             #21  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #33  <Field int m>
    //    4    8:aload_0         
    //    5    9:getfield        #38  <Field int n>
    //    6   12:invokespecial   #65  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double H[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #68  <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < m; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            78
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            66
                if(i >= j)
    //*  17   32:iload_3         
    //*  18   33:iload           4
    //*  19   35:icmplt          56
                    H[i][j] = QR[i][j];
    //   20   38:aload_2         
    //   21   39:iload_3         
    //   22   40:aaload          
    //   23   41:iload           4
    //   24   43:aload_0         
    //   25   44:getfield        #27  <Field double[][] QR>
    //   26   47:iload_3         
    //   27   48:aaload          
    //   28   49:iload           4
    //   29   51:daload          
    //   30   52:dastore         
                else
    //*  31   53:goto            63
                    H[i][j] = 0.0D;
    //   32   56:aload_2         
    //   33   57:iload_3         
    //   34   58:aaload          
    //   35   59:iload           4
    //   36   61:dconst_0        
    //   37   62:dastore         

    //   38   63:iinc            4  1
    //   39   66:iload           4
    //   40   68:aload_0         
    //   41   69:getfield        #38  <Field int n>
    //   42   72:icmplt          32
        }

    //   43   75:iinc            3  1
    //   44   78:iload_3         
    //   45   79:aload_0         
    //   46   80:getfield        #33  <Field int m>
    //   47   83:icmplt          26
        return X;
    //   48   86:aload_1         
    //   49   87:areturn         
    }

    public Matrix getR()
    {
        Matrix X = new Matrix(n, n);
    //    0    0:new             #21  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #38  <Field int n>
    //    4    8:aload_0         
    //    5    9:getfield        #38  <Field int n>
    //    6   12:invokespecial   #65  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double R[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #68  <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int i = 0; i < n; i++)
    //*  11   21:iconst_0        
    //*  12   22:istore_3        
    //*  13   23:goto            99
        {
            for(int j = 0; j < n; j++)
    //*  14   26:iconst_0        
    //*  15   27:istore          4
    //*  16   29:goto            87
                if(i < j)
    //*  17   32:iload_3         
    //*  18   33:iload           4
    //*  19   35:icmpge          56
                    R[i][j] = QR[i][j];
    //   20   38:aload_2         
    //   21   39:iload_3         
    //   22   40:aaload          
    //   23   41:iload           4
    //   24   43:aload_0         
    //   25   44:getfield        #27  <Field double[][] QR>
    //   26   47:iload_3         
    //   27   48:aaload          
    //   28   49:iload           4
    //   29   51:daload          
    //   30   52:dastore         
                else
    //*  31   53:goto            84
                if(i == j)
    //*  32   56:iload_3         
    //*  33   57:iload           4
    //*  34   59:icmpne          77
                    R[i][j] = Rdiag[i];
    //   35   62:aload_2         
    //   36   63:iload_3         
    //   37   64:aaload          
    //   38   65:iload           4
    //   39   67:aload_0         
    //   40   68:getfield        #40  <Field double[] Rdiag>
    //   41   71:iload_3         
    //   42   72:daload          
    //   43   73:dastore         
                else
    //*  44   74:goto            84
                    R[i][j] = 0.0D;
    //   45   77:aload_2         
    //   46   78:iload_3         
    //   47   79:aaload          
    //   48   80:iload           4
    //   49   82:dconst_0        
    //   50   83:dastore         

    //   51   84:iinc            4  1
    //   52   87:iload           4
    //   53   89:aload_0         
    //   54   90:getfield        #38  <Field int n>
    //   55   93:icmplt          32
        }

    //   56   96:iinc            3  1
    //   57   99:iload_3         
    //   58  100:aload_0         
    //   59  101:getfield        #38  <Field int n>
    //   60  104:icmplt          26
        return X;
    //   61  107:aload_1         
    //   62  108:areturn         
    }

    public Matrix getQ()
    {
        Matrix X = new Matrix(m, n);
    //    0    0:new             #21  <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #33  <Field int m>
    //    4    8:aload_0         
    //    5    9:getfield        #38  <Field int n>
    //    6   12:invokespecial   #65  <Method void Matrix(int, int)>
    //    7   15:astore_1        
        double Q[][] = X.getArray();
    //    8   16:aload_1         
    //    9   17:invokevirtual   #68  <Method double[][] Matrix.getArray()>
    //   10   20:astore_2        
        for(int k = n - 1; k >= 0; k--)
    //*  11   21:aload_0         
    //*  12   22:getfield        #38  <Field int n>
    //*  13   25:iconst_1        
    //*  14   26:isub            
    //*  15   27:istore_3        
    //*  16   28:goto            193
        {
            for(int i = 0; i < m; i++)
    //*  17   31:iconst_0        
    //*  18   32:istore          4
    //*  19   34:goto            47
                Q[i][k] = 0.0D;
    //   20   37:aload_2         
    //   21   38:iload           4
    //   22   40:aaload          
    //   23   41:iload_3         
    //   24   42:dconst_0        
    //   25   43:dastore         

    //   26   44:iinc            4  1
    //   27   47:iload           4
    //   28   49:aload_0         
    //   29   50:getfield        #33  <Field int m>
    //   30   53:icmplt          37
            Q[k][k] = 1.0D;
    //   31   56:aload_2         
    //   32   57:iload_3         
    //   33   58:aaload          
    //   34   59:iload_3         
    //   35   60:dconst_1        
    //   36   61:dastore         
            for(int j = k; j < n; j++)
    //*  37   62:iload_3         
    //*  38   63:istore          4
    //*  39   65:goto            181
                if(QR[k][k] != 0.0D)
    //*  40   68:aload_0         
    //*  41   69:getfield        #27  <Field double[][] QR>
    //*  42   72:iload_3         
    //*  43   73:aaload          
    //*  44   74:iload_3         
    //*  45   75:daload          
    //*  46   76:dconst_0        
    //*  47   77:dcmpl           
    //*  48   78:ifeq            178
                {
                    double s = 0.0D;
    //   49   81:dconst_0        
    //   50   82:dstore          5
                    for(int i = k; i < m; i++)
    //*  51   84:iload_3         
    //*  52   85:istore          7
    //*  53   87:goto            115
                        s += QR[i][k] * Q[i][j];
    //   54   90:dload           5
    //   55   92:aload_0         
    //   56   93:getfield        #27  <Field double[][] QR>
    //   57   96:iload           7
    //   58   98:aaload          
    //   59   99:iload_3         
    //   60  100:daload          
    //   61  101:aload_2         
    //   62  102:iload           7
    //   63  104:aaload          
    //   64  105:iload           4
    //   65  107:daload          
    //   66  108:dmul            
    //   67  109:dadd            
    //   68  110:dstore          5

    //   69  112:iinc            7  1
    //   70  115:iload           7
    //   71  117:aload_0         
    //   72  118:getfield        #33  <Field int m>
    //   73  121:icmplt          90
                    s = -s / QR[k][k];
    //   74  124:dload           5
    //   75  126:dneg            
    //   76  127:aload_0         
    //   77  128:getfield        #27  <Field double[][] QR>
    //   78  131:iload_3         
    //   79  132:aaload          
    //   80  133:iload_3         
    //   81  134:daload          
    //   82  135:ddiv            
    //   83  136:dstore          5
                    for(int i = k; i < m; i++)
    //*  84  138:iload_3         
    //*  85  139:istore          7
    //*  86  141:goto            169
                        Q[i][j] += s * QR[i][k];
    //   87  144:aload_2         
    //   88  145:iload           7
    //   89  147:aaload          
    //   90  148:iload           4
    //   91  150:dup2            
    //   92  151:daload          
    //   93  152:dload           5
    //   94  154:aload_0         
    //   95  155:getfield        #27  <Field double[][] QR>
    //   96  158:iload           7
    //   97  160:aaload          
    //   98  161:iload_3         
    //   99  162:daload          
    //  100  163:dmul            
    //  101  164:dadd            
    //  102  165:dastore         

    //  103  166:iinc            7  1
    //  104  169:iload           7
    //  105  171:aload_0         
    //  106  172:getfield        #33  <Field int m>
    //  107  175:icmplt          144
                }

    //  108  178:iinc            4  1
    //  109  181:iload           4
    //  110  183:aload_0         
    //  111  184:getfield        #38  <Field int n>
    //  112  187:icmplt          68
        }

    //  113  190:iinc            3  -1
    //  114  193:iload_3         
    //  115  194:ifge            31
        return X;
    //  116  197:aload_1         
    //  117  198:areturn         
    }

    public Matrix solve(Matrix B)
    {
        if(B.getRowDimension() != m)
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #31  <Method int Matrix.getRowDimension()>
    //*   2    4:aload_0         
    //*   3    5:getfield        #33  <Field int m>
    //*   4    8:icmpeq          21
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
    //    5   11:new             #78  <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc1            #80  <String "Matrix row dimensions must agree.">
    //    8   17:invokespecial   #83  <Method void IllegalArgumentException(String)>
    //    9   20:athrow          
        if(!isFullRank())
    //*  10   21:aload_0         
    //*  11   22:invokevirtual   #85  <Method boolean isFullRank()>
    //*  12   25:ifne            38
            throw new RuntimeException("Matrix is rank deficient.");
    //   13   28:new             #87  <Class RuntimeException>
    //   14   31:dup             
    //   15   32:ldc1            #89  <String "Matrix is rank deficient.">
    //   16   34:invokespecial   #90  <Method void RuntimeException(String)>
    //   17   37:athrow          
        int nx = B.getColumnDimension();
    //   18   38:aload_1         
    //   19   39:invokevirtual   #36  <Method int Matrix.getColumnDimension()>
    //   20   42:istore_2        
        double X[][] = B.getArrayCopy();
    //   21   43:aload_1         
    //   22   44:invokevirtual   #25  <Method double[][] Matrix.getArrayCopy()>
    //   23   47:astore_3        
        for(int k = 0; k < n; k++)
    //*  24   48:iconst_0        
    //*  25   49:istore          4
    //*  26   51:goto            175
        {
            for(int j = 0; j < nx; j++)
    //*  27   54:iconst_0        
    //*  28   55:istore          5
    //*  29   57:goto            166
            {
                double s = 0.0D;
    //   30   60:dconst_0        
    //   31   61:dstore          6
                for(int i = k; i < m; i++)
    //*  32   63:iload           4
    //*  33   65:istore          8
    //*  34   67:goto            96
                    s += QR[i][k] * X[i][j];
    //   35   70:dload           6
    //   36   72:aload_0         
    //   37   73:getfield        #27  <Field double[][] QR>
    //   38   76:iload           8
    //   39   78:aaload          
    //   40   79:iload           4
    //   41   81:daload          
    //   42   82:aload_3         
    //   43   83:iload           8
    //   44   85:aaload          
    //   45   86:iload           5
    //   46   88:daload          
    //   47   89:dmul            
    //   48   90:dadd            
    //   49   91:dstore          6

    //   50   93:iinc            8  1
    //   51   96:iload           8
    //   52   98:aload_0         
    //   53   99:getfield        #33  <Field int m>
    //   54  102:icmplt          70
                s = -s / QR[k][k];
    //   55  105:dload           6
    //   56  107:dneg            
    //   57  108:aload_0         
    //   58  109:getfield        #27  <Field double[][] QR>
    //   59  112:iload           4
    //   60  114:aaload          
    //   61  115:iload           4
    //   62  117:daload          
    //   63  118:ddiv            
    //   64  119:dstore          6
                for(int i = k; i < m; i++)
    //*  65  121:iload           4
    //*  66  123:istore          8
    //*  67  125:goto            154
                    X[i][j] += s * QR[i][k];
    //   68  128:aload_3         
    //   69  129:iload           8
    //   70  131:aaload          
    //   71  132:iload           5
    //   72  134:dup2            
    //   73  135:daload          
    //   74  136:dload           6
    //   75  138:aload_0         
    //   76  139:getfield        #27  <Field double[][] QR>
    //   77  142:iload           8
    //   78  144:aaload          
    //   79  145:iload           4
    //   80  147:daload          
    //   81  148:dmul            
    //   82  149:dadd            
    //   83  150:dastore         

    //   84  151:iinc            8  1
    //   85  154:iload           8
    //   86  156:aload_0         
    //   87  157:getfield        #33  <Field int m>
    //   88  160:icmplt          128
            }

    //   89  163:iinc            5  1
    //   90  166:iload           5
    //   91  168:iload_2         
    //   92  169:icmplt          60
        }

    //   93  172:iinc            4  1
    //   94  175:iload           4
    //   95  177:aload_0         
    //   96  178:getfield        #38  <Field int n>
    //   97  181:icmplt          54
        for(int k = n - 1; k >= 0; k--)
    //*  98  184:aload_0         
    //*  99  185:getfield        #38  <Field int n>
    //* 100  188:iconst_1        
    //* 101  189:isub            
    //* 102  190:istore          4
    //* 103  192:goto            289
        {
            for(int j = 0; j < nx; j++)
    //* 104  195:iconst_0        
    //* 105  196:istore          5
    //* 106  198:goto            221
                X[k][j] /= Rdiag[k];
    //  107  201:aload_3         
    //  108  202:iload           4
    //  109  204:aaload          
    //  110  205:iload           5
    //  111  207:dup2            
    //  112  208:daload          
    //  113  209:aload_0         
    //  114  210:getfield        #40  <Field double[] Rdiag>
    //  115  213:iload           4
    //  116  215:daload          
    //  117  216:ddiv            
    //  118  217:dastore         

    //  119  218:iinc            5  1
    //  120  221:iload           5
    //  121  223:iload_2         
    //  122  224:icmplt          201
            for(int i = 0; i < k; i++)
    //* 123  227:iconst_0        
    //* 124  228:istore          5
    //* 125  230:goto            279
            {
                for(int j = 0; j < nx; j++)
    //* 126  233:iconst_0        
    //* 127  234:istore          6
    //* 128  236:goto            270
                    X[i][j] -= X[k][j] * QR[i][k];
    //  129  239:aload_3         
    //  130  240:iload           5
    //  131  242:aaload          
    //  132  243:iload           6
    //  133  245:dup2            
    //  134  246:daload          
    //  135  247:aload_3         
    //  136  248:iload           4
    //  137  250:aaload          
    //  138  251:iload           6
    //  139  253:daload          
    //  140  254:aload_0         
    //  141  255:getfield        #27  <Field double[][] QR>
    //  142  258:iload           5
    //  143  260:aaload          
    //  144  261:iload           4
    //  145  263:daload          
    //  146  264:dmul            
    //  147  265:dsub            
    //  148  266:dastore         

    //  149  267:iinc            6  1
    //  150  270:iload           6
    //  151  272:iload_2         
    //  152  273:icmplt          239
            }

    //  153  276:iinc            5  1
    //  154  279:iload           5
    //  155  281:iload           4
    //  156  283:icmplt          233
        }

    //  157  286:iinc            4  -1
    //  158  289:iload           4
    //  159  291:ifge            195
        return (new Matrix(X, n, nx)).getMatrix(0, n - 1, 0, nx - 1);
    //  160  294:new             #21  <Class Matrix>
    //  161  297:dup             
    //  162  298:aload_3         
    //  163  299:aload_0         
    //  164  300:getfield        #38  <Field int n>
    //  165  303:iload_2         
    //  166  304:invokespecial   #93  <Method void Matrix(double[][], int, int)>
    //  167  307:iconst_0        
    //  168  308:aload_0         
    //  169  309:getfield        #38  <Field int n>
    //  170  312:iconst_1        
    //  171  313:isub            
    //  172  314:iconst_0        
    //  173  315:iload_2         
    //  174  316:iconst_1        
    //  175  317:isub            
    //  176  318:invokevirtual   #97  <Method Matrix Matrix.getMatrix(int, int, int, int)>
    //  177  321:areturn         
    }

    private double QR[][];
    private int m;
    private int n;
    private double Rdiag[];
}

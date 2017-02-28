// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RandomGenerateData.java

package rm.generate;

import java.io.*;
import java.util.*;
import rm.core.*;

// Referenced classes of package rm.generate:
//            AbstractGenerate

public class RandomGenerateData extends AbstractGenerate
    implements OptionHandler
{
    public static class Distribution extends Enum
    {

        public static final Distribution[] values()
        {
            Distribution adistribution[];
            int i;
            Distribution adistribution1[];
            System.arraycopy(adistribution = ENUM$VALUES, 0, adistribution1 = new Distribution[i = adistribution.length], 0, i);
        //    0    0:getstatic       #24  <Field RandomGenerateData$Distribution[] ENUM$VALUES>
        //    1    3:dup             
        //    2    4:astore_0        
        //    3    5:iconst_0        
        //    4    6:aload_0         
        //    5    7:arraylength     
        //    6    8:dup             
        //    7    9:istore_1        
        //    8   10:anewarray       Distribution[]
        //    9   13:dup             
        //   10   14:astore_2        
        //   11   15:iconst_0        
        //   12   16:iload_1         
        //   13   17:invokestatic    #36  <Method void System.arraycopy(Object, int, Object, int, int)>
            return adistribution1;
        //   14   20:aload_2         
        //   15   21:areturn         
        }

        public static final Distribution valueOf(String s)
        {
            Distribution adistribution[];
            Distribution distribution;
            for(int i = (adistribution = ENUM$VALUES).length; --i >= 0;)
        //*   0    0:getstatic       #24  <Field RandomGenerateData$Distribution[] ENUM$VALUES>
        //*   1    3:dup             
        //*   2    4:astore_1        
        //*   3    5:arraylength     
        //*   4    6:istore_2        
        //*   5    7:goto            27
                if(s.equals((distribution = adistribution[i]).name()))
        //*   6   10:aload_0         
        //*   7   11:aload_1         
        //*   8   12:iload_2         
        //*   9   13:aaload          
        //*  10   14:dup             
        //*  11   15:astore_3        
        //*  12   16:invokevirtual   #42  <Method String name()>
        //*  13   19:invokevirtual   #48  <Method boolean String.equals(Object)>
        //*  14   22:ifeq            27
                    return distribution;
        //   15   25:aload_3         
        //   16   26:areturn         

        //   17   27:iinc            2  -1
        //   18   30:iload_2         
        //   19   31:ifge            10
            throw new IllegalArgumentException(s);
        //   20   34:new             #50  <Class IllegalArgumentException>
        //   21   37:dup             
        //   22   38:aload_0         
        //   23   39:invokespecial   #53  <Method void IllegalArgumentException(String)>
        //   24   42:athrow          
        }

        public static final Distribution RANDOM;
        public static final Distribution GAUSSIAN;
        private static final Distribution ENUM$VALUES[];

        static 
        {
            RANDOM = new Distribution("RANDOM", 0);
        //    0    0:new             #2   <Class RandomGenerateData$Distribution>
        //    1    3:dup             
        //    2    4:ldc1            #13  <String "RANDOM">
        //    3    6:iconst_0        
        //    4    7:invokespecial   #17  <Method void RandomGenerateData$Distribution(String, int)>
        //    5   10:putstatic       #19  <Field RandomGenerateData$Distribution RANDOM>
            GAUSSIAN = new Distribution("GAUSSIAN", 1);
        //    6   13:new             #2   <Class RandomGenerateData$Distribution>
        //    7   16:dup             
        //    8   17:ldc1            #20  <String "GAUSSIAN">
        //    9   19:iconst_1        
        //   10   20:invokespecial   #17  <Method void RandomGenerateData$Distribution(String, int)>
        //   11   23:putstatic       #22  <Field RandomGenerateData$Distribution GAUSSIAN>
            ENUM$VALUES = (new Distribution[] {
                RANDOM, GAUSSIAN
            });
        //   12   26:iconst_2        
        //   13   27:anewarray       Distribution[]
        //   14   30:dup             
        //   15   31:iconst_0        
        //   16   32:getstatic       #19  <Field RandomGenerateData$Distribution RANDOM>
        //   17   35:aastore         
        //   18   36:dup             
        //   19   37:iconst_1        
        //   20   38:getstatic       #22  <Field RandomGenerateData$Distribution GAUSSIAN>
        //   21   41:aastore         
        //   22   42:putstatic       #24  <Field RandomGenerateData$Distribution[] ENUM$VALUES>
        //*  23   45:return          
        }

        private Distribution(String s, int i)
        {
            super(s, i);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iload_2         
        //    3    3:invokespecial   #27  <Method void Enum(String, int)>
        //    4    6:return          
        }
    }


    public void resetOptions()
    {
        noUsers = 20;
    //    0    0:aload_0         
    //    1    1:bipush          20
    //    2    3:putfield        #59  <Field int noUsers>
        noRoles = 10;
    //    3    6:aload_0         
    //    4    7:bipush          10
    //    5    9:putfield        #61  <Field int noRoles>
        noPermissions = 50;
    //    6   12:aload_0         
    //    7   13:bipush          50
    //    8   15:putfield        #63  <Field int noPermissions>
        urMean = 3;
    //    9   18:aload_0         
    //   10   19:iconst_3        
    //   11   20:putfield        #65  <Field int urMean>
        rpMean = 5;
    //   12   23:aload_0         
    //   13   24:iconst_5        
    //   14   25:putfield        #67  <Field int rpMean>
        urStd = 1.0D;
    //   15   28:aload_0         
    //   16   29:dconst_1        
    //   17   30:putfield        #69  <Field double urStd>
        rpStd = 2D;
    //   18   33:aload_0         
    //   19   34:ldc2w           #70  <Double 2D>
    //   20   37:putfield        #73  <Field double rpStd>
        seed = 20;
    //   21   40:aload_0         
    //   22   41:bipush          20
    //   23   43:putfield        #75  <Field int seed>
        outputFile = "test";
    //   24   46:aload_0         
    //   25   47:ldc1            #77  <String "test">
    //   26   49:putfield        #79  <Field String outputFile>
        disjoint = false;
    //   27   52:aload_0         
    //   28   53:iconst_0        
    //   29   54:putfield        #81  <Field boolean disjoint>
        dist = Distribution.GAUSSIAN;
    //   30   57:aload_0         
    //   31   58:getstatic       #86  <Field RandomGenerateData$Distribution RandomGenerateData$Distribution.GAUSSIAN>
    //   32   61:putfield        #88  <Field RandomGenerateData$Distribution dist>
    //   33   64:return          
    }

    public RandomGenerateData()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #95  <Method void AbstractGenerate()>
        disjoint = false;
    //    2    4:aload_0         
    //    3    5:iconst_0        
    //    4    6:putfield        #81  <Field boolean disjoint>
        dist = Distribution.GAUSSIAN;
    //    5    9:aload_0         
    //    6   10:getstatic       #86  <Field RandomGenerateData$Distribution RandomGenerateData$Distribution.GAUSSIAN>
    //    7   13:putfield        #88  <Field RandomGenerateData$Distribution dist>
        outputFile = "test";
    //    8   16:aload_0         
    //    9   17:ldc1            #77  <String "test">
    //   10   19:putfield        #79  <Field String outputFile>
        upastr = new StringBuffer();
    //   11   22:aload_0         
    //   12   23:new             #97  <Class StringBuffer>
    //   13   26:dup             
    //   14   27:invokespecial   #98  <Method void StringBuffer()>
    //   15   30:putfield        #100 <Field StringBuffer upastr>
        resetOptions();
    //   16   33:aload_0         
    //   17   34:invokevirtual   #102 <Method void resetOptions()>
    //   18   37:return          
    }

    public void generate()
    {
        rand = new Random(seed);
    //    0    0:aload_0         
    //    1    1:new             #105 <Class Random>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:getfield        #75  <Field int seed>
    //    5    9:i2l             
    //    6   10:invokespecial   #108 <Method void Random(long)>
    //    7   13:putfield        #110 <Field Random rand>
        generateData(outputFile);
    //    8   16:aload_0         
    //    9   17:aload_0         
    //   10   18:getfield        #79  <Field String outputFile>
    //   11   21:invokespecial   #114 <Method void generateData(String)>
    //   12   24:return          
    }

    private void generateData(String filename)
    {
        Vector v_users = new Vector();
    //    0    0:new             #116 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #117 <Method void Vector()>
    //    3    7:astore_2        
        Vector v_roles = new Vector();
    //    4    8:new             #116 <Class Vector>
    //    5   11:dup             
    //    6   12:invokespecial   #117 <Method void Vector()>
    //    7   15:astore_3        
        Vector v_permissions = new Vector();
    //    8   16:new             #116 <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #117 <Method void Vector()>
    //   11   23:astore          4
        generateObjects("User", v_users, noUsers);
    //   12   25:aload_0         
    //   13   26:ldc1            #20  <String "User">
    //   14   28:aload_2         
    //   15   29:aload_0         
    //   16   30:getfield        #59  <Field int noUsers>
    //   17   33:invokespecial   #121 <Method void generateObjects(String, Vector, int)>
        generateObjects("Role", v_roles, noRoles);
    //   18   36:aload_0         
    //   19   37:ldc1            #23  <String "Role">
    //   20   39:aload_3         
    //   21   40:aload_0         
    //   22   41:getfield        #61  <Field int noRoles>
    //   23   44:invokespecial   #121 <Method void generateObjects(String, Vector, int)>
        generateObjects("Perm", v_permissions, noPermissions);
    //   24   47:aload_0         
    //   25   48:ldc1            #123 <String "Perm">
    //   26   50:aload           4
    //   27   52:aload_0         
    //   28   53:getfield        #63  <Field int noPermissions>
    //   29   56:invokespecial   #121 <Method void generateObjects(String, Vector, int)>
        Matrix UA = new Matrix(noUsers, noRoles);
    //   30   59:new             #125 <Class Matrix>
    //   31   62:dup             
    //   32   63:aload_0         
    //   33   64:getfield        #59  <Field int noUsers>
    //   34   67:aload_0         
    //   35   68:getfield        #61  <Field int noRoles>
    //   36   71:invokespecial   #128 <Method void Matrix(int, int)>
    //   37   74:astore          5
        generateRelationships(v_users, v_roles, UA, urMean, urStd);
    //   38   76:aload_0         
    //   39   77:aload_2         
    //   40   78:aload_3         
    //   41   79:aload           5
    //   42   81:aload_0         
    //   43   82:getfield        #65  <Field int urMean>
    //   44   85:aload_0         
    //   45   86:getfield        #69  <Field double urStd>
    //   46   89:invokespecial   #132 <Method void generateRelationships(Vector, Vector, Matrix, int, double)>
        printRelationships(UA, v_users, v_roles, "User", "Role", "user-role", (new StringBuilder(String.valueOf(filename))).append("-user-role.ur").toString());
    //   47   92:aload_0         
    //   48   93:aload           5
    //   49   95:aload_2         
    //   50   96:aload_3         
    //   51   97:ldc1            #20  <String "User">
    //   52   99:ldc1            #23  <String "Role">
    //   53  101:ldc1            #29  <String "user-role">
    //   54  103:new             #134 <Class StringBuilder>
    //   55  106:dup             
    //   56  107:aload_1         
    //   57  108:invokestatic    #140 <Method String String.valueOf(Object)>
    //   58  111:invokespecial   #142 <Method void StringBuilder(String)>
    //   59  114:ldc1            #144 <String "-user-role.ur">
    //   60  116:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   61  119:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   62  122:invokevirtual   #156 <Method void printRelationships(Matrix, Vector, Vector, String, String, String, String)>
        Matrix PA = new Matrix(noRoles, noPermissions);
    //   63  125:new             #125 <Class Matrix>
    //   64  128:dup             
    //   65  129:aload_0         
    //   66  130:getfield        #61  <Field int noRoles>
    //   67  133:aload_0         
    //   68  134:getfield        #63  <Field int noPermissions>
    //   69  137:invokespecial   #128 <Method void Matrix(int, int)>
    //   70  140:astore          6
        if(disjoint)
    //*  71  142:aload_0         
    //*  72  143:getfield        #81  <Field boolean disjoint>
    //*  73  146:ifeq            169
            generateDisjointRelationships(v_roles, v_permissions, PA, rpMean, rpStd);
    //   74  149:aload_0         
    //   75  150:aload_3         
    //   76  151:aload           4
    //   77  153:aload           6
    //   78  155:aload_0         
    //   79  156:getfield        #67  <Field int rpMean>
    //   80  159:aload_0         
    //   81  160:getfield        #73  <Field double rpStd>
    //   82  163:invokespecial   #159 <Method void generateDisjointRelationships(Vector, Vector, Matrix, int, double)>
        else
    //*  83  166:goto            186
            generateRelationships(v_roles, v_permissions, PA, rpMean, rpStd);
    //   84  169:aload_0         
    //   85  170:aload_3         
    //   86  171:aload           4
    //   87  173:aload           6
    //   88  175:aload_0         
    //   89  176:getfield        #67  <Field int rpMean>
    //   90  179:aload_0         
    //   91  180:getfield        #73  <Field double rpStd>
    //   92  183:invokespecial   #132 <Method void generateRelationships(Vector, Vector, Matrix, int, double)>
        printRelationships(PA, v_roles, v_permissions, "Role", "Permssion", "role-permission", (new StringBuilder(String.valueOf(filename))).append("-role-permission.rp").toString());
    //   93  186:aload_0         
    //   94  187:aload           6
    //   95  189:aload_3         
    //   96  190:aload           4
    //   97  192:ldc1            #23  <String "Role">
    //   98  194:ldc1            #26  <String "Permssion">
    //   99  196:ldc1            #32  <String "role-permission">
    //  100  198:new             #134 <Class StringBuilder>
    //  101  201:dup             
    //  102  202:aload_1         
    //  103  203:invokestatic    #140 <Method String String.valueOf(Object)>
    //  104  206:invokespecial   #142 <Method void StringBuilder(String)>
    //  105  209:ldc1            #161 <String "-role-permission.rp">
    //  106  211:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  107  214:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  108  217:invokevirtual   #156 <Method void printRelationships(Matrix, Vector, Vector, String, String, String, String)>
        generateUPA(v_users, v_permissions, UA, PA, (new StringBuilder(String.valueOf(filename))).append("-user-permission.up").toString());
    //  109  220:aload_0         
    //  110  221:aload_2         
    //  111  222:aload           4
    //  112  224:aload           5
    //  113  226:aload           6
    //  114  228:new             #134 <Class StringBuilder>
    //  115  231:dup             
    //  116  232:aload_1         
    //  117  233:invokestatic    #140 <Method String String.valueOf(Object)>
    //  118  236:invokespecial   #142 <Method void StringBuilder(String)>
    //  119  239:ldc1            #163 <String "-user-permission.up">
    //  120  241:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  121  244:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  122  247:invokespecial   #167 <Method void generateUPA(Vector, Vector, Matrix, Matrix, String)>
        UPAtoString(v_users, v_permissions, UA, PA);
    //  123  250:aload_0         
    //  124  251:aload_2         
    //  125  252:aload           4
    //  126  254:aload           5
    //  127  256:aload           6
    //  128  258:invokespecial   #171 <Method void UPAtoString(Vector, Vector, Matrix, Matrix)>
    //  129  261:return          
    }

    private void generateObjects(String objectName, Vector v, int max)
    {
        for(int i = 1; i <= max; i++)
    //*   0    0:iconst_1        
    //*   1    1:istore          4
    //*   2    3:goto            33
            v.add((new StringBuilder(String.valueOf(objectName))).append(i).toString());
    //    3    6:aload_2         
    //    4    7:new             #134 <Class StringBuilder>
    //    5   10:dup             
    //    6   11:aload_1         
    //    7   12:invokestatic    #140 <Method String String.valueOf(Object)>
    //    8   15:invokespecial   #142 <Method void StringBuilder(String)>
    //    9   18:iload           4
    //   10   20:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   11   23:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   12   26:invokevirtual   #190 <Method boolean Vector.add(Object)>
    //   13   29:pop             

    //   14   30:iinc            4  1
    //   15   33:iload           4
    //   16   35:iload_3         
    //   17   36:icmple          6
    //   18   39:return          
    }

    private void generateRelationships(Vector v_rows, Vector v_columns, Matrix relation, int mean, double std)
    {
        Random rand = new Random();
    //    0    0:new             #105 <Class Random>
    //    1    3:dup             
    //    2    4:invokespecial   #196 <Method void Random()>
    //    3    7:astore          7
        for(int i = 0; i < v_rows.size(); i++)
    //*   4    9:iconst_0        
    //*   5   10:istore          10
    //*   6   12:goto            161
        {
            int numColumns;
            if(dist == Distribution.GAUSSIAN)
    //*   7   15:aload_0         
    //*   8   16:getfield        #88  <Field RandomGenerateData$Distribution dist>
    //*   9   19:getstatic       #86  <Field RandomGenerateData$Distribution RandomGenerateData$Distribution.GAUSSIAN>
    //*  10   22:if_acmpne       48
                numColumns = (int)Math.round(std * rand.nextGaussian() + (double)mean) + 1;
    //   11   25:dload           5
    //   12   27:aload           7
    //   13   29:invokevirtual   #200 <Method double Random.nextGaussian()>
    //   14   32:dmul            
    //   15   33:iload           4
    //   16   35:i2d             
    //   17   36:dadd            
    //   18   37:invokestatic    #206 <Method long Math.round(double)>
    //   19   40:l2i             
    //   20   41:iconst_1        
    //   21   42:iadd            
    //   22   43:istore          8
            else
    //*  23   45:goto            62
                numColumns = (int)(Math.random() * (double)v_columns.size() + 1.0D);
    //   24   48:invokestatic    #209 <Method double Math.random()>
    //   25   51:aload_2         
    //   26   52:invokevirtual   #213 <Method int Vector.size()>
    //   27   55:i2d             
    //   28   56:dmul            
    //   29   57:dconst_1        
    //   30   58:dadd            
    //   31   59:d2i             
    //   32   60:istore          8
            if(numColumns > v_columns.size())
    //*  33   62:iload           8
    //*  34   64:aload_2         
    //*  35   65:invokevirtual   #213 <Method int Vector.size()>
    //*  36   68:icmple          77
                numColumns = v_columns.size();
    //   37   71:aload_2         
    //   38   72:invokevirtual   #213 <Method int Vector.size()>
    //   39   75:istore          8
            for(int j = 0; j < v_columns.size(); j++)
    //*  40   77:iconst_0        
    //*  41   78:istore          11
    //*  42   80:goto            95
                relation.set(i, j, (byte)0);
    //   43   83:aload_3         
    //   44   84:iload           10
    //   45   86:iload           11
    //   46   88:iconst_0        
    //   47   89:invokevirtual   #217 <Method void Matrix.set(int, int, byte)>

    //   48   92:iinc            11  1
    //   49   95:iload           11
    //   50   97:aload_2         
    //   51   98:invokevirtual   #213 <Method int Vector.size()>
    //   52  101:icmplt          83
            for(int j = 0; j < numColumns; j++)
    //*  53  104:iconst_0        
    //*  54  105:istore          11
    //*  55  107:goto            151
            {
                int columnNo = rand.nextInt(v_columns.size());
    //   56  110:aload           7
    //   57  112:aload_2         
    //   58  113:invokevirtual   #213 <Method int Vector.size()>
    //   59  116:invokevirtual   #221 <Method int Random.nextInt(int)>
    //   60  119:istore          9
                if(relation.get(i, columnNo) == 1)
    //*  61  121:aload_3         
    //*  62  122:iload           10
    //*  63  124:iload           9
    //*  64  126:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //*  65  129:iconst_1        
    //*  66  130:icmpne          139
                    j--;
    //   67  133:iinc            11  -1
                else
    //*  68  136:goto            148
                    relation.set(i, columnNo, (byte)1);
    //   69  139:aload_3         
    //   70  140:iload           10
    //   71  142:iload           9
    //   72  144:iconst_1        
    //   73  145:invokevirtual   #217 <Method void Matrix.set(int, int, byte)>
            }

    //   74  148:iinc            11  1
    //   75  151:iload           11
    //   76  153:iload           8
    //   77  155:icmplt          110
        }

    //   78  158:iinc            10  1
    //   79  161:iload           10
    //   80  163:aload_1         
    //   81  164:invokevirtual   #213 <Method int Vector.size()>
    //   82  167:icmplt          15
    //   83  170:return          
    }

    private void generateDisjointRelationships(Vector v_rows, Vector v_columns, Matrix relation, int mean, double std)
    {
        Random r = new Random();
    //    0    0:new             #105 <Class Random>
    //    1    3:dup             
    //    2    4:invokespecial   #196 <Method void Random()>
    //    3    7:astore          7
        Vector columnsRand = new Vector();
    //    4    9:new             #116 <Class Vector>
    //    5   12:dup             
    //    6   13:invokespecial   #117 <Method void Vector()>
    //    7   16:astore          8
        for(int i = 0; i < columnsRand.size(); i++)
    //*   8   18:iconst_0        
    //*   9   19:istore          9
    //*  10   21:goto            38
            columnsRand.add(Integer.valueOf(i));
    //   11   24:aload           8
    //   12   26:iload           9
    //   13   28:invokestatic    #238 <Method Integer Integer.valueOf(int)>
    //   14   31:invokevirtual   #190 <Method boolean Vector.add(Object)>
    //   15   34:pop             

    //   16   35:iinc            9  1
    //   17   38:iload           9
    //   18   40:aload           8
    //   19   42:invokevirtual   #213 <Method int Vector.size()>
    //   20   45:icmplt          24
        for(int i = 0; i < v_rows.size(); i++)
    //*  21   48:iconst_0        
    //*  22   49:istore          10
    //*  23   51:goto            190
        {
            for(int j = 0; j < v_columns.size(); j++)
    //*  24   54:iconst_0        
    //*  25   55:istore          11
    //*  26   57:goto            72
                relation.set(i, j, (byte)0);
    //   27   60:aload_3         
    //   28   61:iload           10
    //   29   63:iload           11
    //   30   65:iconst_0        
    //   31   66:invokevirtual   #217 <Method void Matrix.set(int, int, byte)>

    //   32   69:iinc            11  1
    //   33   72:iload           11
    //   34   74:aload_2         
    //   35   75:invokevirtual   #213 <Method int Vector.size()>
    //   36   78:icmplt          60
            int numColumns;
            if(dist == Distribution.GAUSSIAN)
    //*  37   81:aload_0         
    //*  38   82:getfield        #88  <Field RandomGenerateData$Distribution dist>
    //*  39   85:getstatic       #86  <Field RandomGenerateData$Distribution RandomGenerateData$Distribution.GAUSSIAN>
    //*  40   88:if_acmpne       114
                numColumns = (int)Math.round(std * r.nextGaussian() + (double)mean) + 1;
    //   41   91:dload           5
    //   42   93:aload           7
    //   43   95:invokevirtual   #200 <Method double Random.nextGaussian()>
    //   44   98:dmul            
    //   45   99:iload           4
    //   46  101:i2d             
    //   47  102:dadd            
    //   48  103:invokestatic    #206 <Method long Math.round(double)>
    //   49  106:l2i             
    //   50  107:iconst_1        
    //   51  108:iadd            
    //   52  109:istore          9
            else
    //*  53  111:goto            128
                numColumns = (int)(Math.random() * (double)v_columns.size() + 1.0D);
    //   54  114:invokestatic    #209 <Method double Math.random()>
    //   55  117:aload_2         
    //   56  118:invokevirtual   #213 <Method int Vector.size()>
    //   57  121:i2d             
    //   58  122:dmul            
    //   59  123:dconst_1        
    //   60  124:dadd            
    //   61  125:d2i             
    //   62  126:istore          9
            Collections.shuffle(columnsRand, r);
    //   63  128:aload           8
    //   64  130:aload           7
    //   65  132:invokestatic    #244 <Method void Collections.shuffle(java.util.List, Random)>
            if(numColumns > columnsRand.size())
    //*  66  135:iload           9
    //*  67  137:aload           8
    //*  68  139:invokevirtual   #213 <Method int Vector.size()>
    //*  69  142:icmple          152
                numColumns = columnsRand.size();
    //   70  145:aload           8
    //   71  147:invokevirtual   #213 <Method int Vector.size()>
    //   72  150:istore          9
            for(int j = 0; j < numColumns; j++)
    //*  73  152:iconst_0        
    //*  74  153:istore          11
    //*  75  155:goto            180
                relation.set(i, ((Integer)columnsRand.remove(0)).intValue(), (byte)1);
    //   76  158:aload_3         
    //   77  159:iload           10
    //   78  161:aload           8
    //   79  163:iconst_0        
    //   80  164:invokevirtual   #248 <Method Object Vector.remove(int)>
    //   81  167:checkcast       #235 <Class Integer>
    //   82  170:invokevirtual   #251 <Method int Integer.intValue()>
    //   83  173:iconst_1        
    //   84  174:invokevirtual   #217 <Method void Matrix.set(int, int, byte)>

    //   85  177:iinc            11  1
    //   86  180:iload           11
    //   87  182:iload           9
    //   88  184:icmplt          158
        }

    //   89  187:iinc            10  1
    //   90  190:iload           10
    //   91  192:aload_1         
    //   92  193:invokevirtual   #213 <Method int Vector.size()>
    //   93  196:icmplt          54
    //   94  199:return          
    }

    public void printRelationships(Matrix relation, Vector v_rows, Vector v_columns, String n_rows, String n_columns, String n_relation, String fileName)
    {
        try
        {
            PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));
    //    0    0:new             #257 <Class PrintWriter>
    //    1    3:dup             
    //    2    4:new             #259 <Class FileWriter>
    //    3    7:dup             
    //    4    8:aload           7
    //    5   10:invokespecial   #260 <Method void FileWriter(String)>
    //    6   13:invokespecial   #263 <Method void PrintWriter(java.io.Writer)>
    //    7   16:astore          8
            outputFile.println((new StringBuilder("@assignment ")).append(n_relation).toString());
    //    8   18:aload           8
    //    9   20:new             #134 <Class StringBuilder>
    //   10   23:dup             
    //   11   24:ldc2            #265 <String "@assignment ">
    //   12   27:invokespecial   #142 <Method void StringBuilder(String)>
    //   13   30:aload           6
    //   14   32:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   15   35:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   16   38:invokevirtual   #268 <Method void PrintWriter.println(String)>
            outputFile.print((new StringBuilder("@dimension ")).append(n_rows).append(" {").toString());
    //   17   41:aload           8
    //   18   43:new             #134 <Class StringBuilder>
    //   19   46:dup             
    //   20   47:ldc2            #270 <String "@dimension ">
    //   21   50:invokespecial   #142 <Method void StringBuilder(String)>
    //   22   53:aload           4
    //   23   55:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   24   58:ldc2            #272 <String " {">
    //   25   61:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   26   64:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   27   67:invokevirtual   #275 <Method void PrintWriter.print(String)>
            for(int i = 0; i < v_rows.size() - 1; i++)
    //*  28   70:iconst_0        
    //*  29   71:istore          9
    //*  30   73:goto            112
                outputFile.print((new StringBuilder(String.valueOf((String)v_rows.get(i)))).append(",").toString());
    //   31   76:aload           8
    //   32   78:new             #134 <Class StringBuilder>
    //   33   81:dup             
    //   34   82:aload_2         
    //   35   83:iload           9
    //   36   85:invokevirtual   #277 <Method Object Vector.get(int)>
    //   37   88:checkcast       #136 <Class String>
    //   38   91:invokestatic    #140 <Method String String.valueOf(Object)>
    //   39   94:invokespecial   #142 <Method void StringBuilder(String)>
    //   40   97:ldc2            #279 <String ",">
    //   41  100:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   42  103:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   43  106:invokevirtual   #275 <Method void PrintWriter.print(String)>

    //   44  109:iinc            9  1
    //   45  112:iload           9
    //   46  114:aload_2         
    //   47  115:invokevirtual   #213 <Method int Vector.size()>
    //   48  118:iconst_1        
    //   49  119:isub            
    //   50  120:icmplt          76
            outputFile.println((new StringBuilder(String.valueOf((String)v_rows.get(v_rows.size() - 1)))).append("}").toString());
    //   51  123:aload           8
    //   52  125:new             #134 <Class StringBuilder>
    //   53  128:dup             
    //   54  129:aload_2         
    //   55  130:aload_2         
    //   56  131:invokevirtual   #213 <Method int Vector.size()>
    //   57  134:iconst_1        
    //   58  135:isub            
    //   59  136:invokevirtual   #277 <Method Object Vector.get(int)>
    //   60  139:checkcast       #136 <Class String>
    //   61  142:invokestatic    #140 <Method String String.valueOf(Object)>
    //   62  145:invokespecial   #142 <Method void StringBuilder(String)>
    //   63  148:ldc2            #281 <String "}">
    //   64  151:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   65  154:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   66  157:invokevirtual   #268 <Method void PrintWriter.println(String)>
            outputFile.print((new StringBuilder("@dimension ")).append(n_columns).append(" {").toString());
    //   67  160:aload           8
    //   68  162:new             #134 <Class StringBuilder>
    //   69  165:dup             
    //   70  166:ldc2            #270 <String "@dimension ">
    //   71  169:invokespecial   #142 <Method void StringBuilder(String)>
    //   72  172:aload           5
    //   73  174:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   74  177:ldc2            #272 <String " {">
    //   75  180:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   76  183:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   77  186:invokevirtual   #275 <Method void PrintWriter.print(String)>
            for(int i = 0; i < v_columns.size() - 1; i++)
    //*  78  189:iconst_0        
    //*  79  190:istore          9
    //*  80  192:goto            231
                outputFile.print((new StringBuilder(String.valueOf((String)v_columns.get(i)))).append(",").toString());
    //   81  195:aload           8
    //   82  197:new             #134 <Class StringBuilder>
    //   83  200:dup             
    //   84  201:aload_3         
    //   85  202:iload           9
    //   86  204:invokevirtual   #277 <Method Object Vector.get(int)>
    //   87  207:checkcast       #136 <Class String>
    //   88  210:invokestatic    #140 <Method String String.valueOf(Object)>
    //   89  213:invokespecial   #142 <Method void StringBuilder(String)>
    //   90  216:ldc2            #279 <String ",">
    //   91  219:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   92  222:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   93  225:invokevirtual   #275 <Method void PrintWriter.print(String)>

    //   94  228:iinc            9  1
    //   95  231:iload           9
    //   96  233:aload_3         
    //   97  234:invokevirtual   #213 <Method int Vector.size()>
    //   98  237:iconst_1        
    //   99  238:isub            
    //  100  239:icmplt          195
            outputFile.println((new StringBuilder(String.valueOf((String)v_columns.get(v_columns.size() - 1)))).append("}").toString());
    //  101  242:aload           8
    //  102  244:new             #134 <Class StringBuilder>
    //  103  247:dup             
    //  104  248:aload_3         
    //  105  249:aload_3         
    //  106  250:invokevirtual   #213 <Method int Vector.size()>
    //  107  253:iconst_1        
    //  108  254:isub            
    //  109  255:invokevirtual   #277 <Method Object Vector.get(int)>
    //  110  258:checkcast       #136 <Class String>
    //  111  261:invokestatic    #140 <Method String String.valueOf(Object)>
    //  112  264:invokespecial   #142 <Method void StringBuilder(String)>
    //  113  267:ldc2            #281 <String "}">
    //  114  270:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  115  273:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  116  276:invokevirtual   #268 <Method void PrintWriter.println(String)>
            outputFile.println("@matrix");
    //  117  279:aload           8
    //  118  281:ldc1            #17  <String "@matrix">
    //  119  283:invokevirtual   #268 <Method void PrintWriter.println(String)>
            for(int i = 0; i < relation.getRowDimension(); i++)
    //* 120  286:iconst_0        
    //* 121  287:istore          9
    //* 122  289:goto            364
            {
                for(int j = 0; j < relation.getColumnDimension() - 1; j++)
    //* 123  292:iconst_0        
    //* 124  293:istore          10
    //* 125  295:goto            333
                    outputFile.print((new StringBuilder(String.valueOf(relation.get(i, j)))).append(",").toString());
    //  126  298:aload           8
    //  127  300:new             #134 <Class StringBuilder>
    //  128  303:dup             
    //  129  304:aload_1         
    //  130  305:iload           9
    //  131  307:iload           10
    //  132  309:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //  133  312:invokestatic    #284 <Method String String.valueOf(int)>
    //  134  315:invokespecial   #142 <Method void StringBuilder(String)>
    //  135  318:ldc2            #279 <String ",">
    //  136  321:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  137  324:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  138  327:invokevirtual   #275 <Method void PrintWriter.print(String)>

    //  139  330:iinc            10  1
    //  140  333:iload           10
    //  141  335:aload_1         
    //  142  336:invokevirtual   #287 <Method int Matrix.getColumnDimension()>
    //  143  339:iconst_1        
    //  144  340:isub            
    //  145  341:icmplt          298
                outputFile.println(relation.get(i, relation.getColumnDimension() - 1));
    //  146  344:aload           8
    //  147  346:aload_1         
    //  148  347:iload           9
    //  149  349:aload_1         
    //  150  350:invokevirtual   #287 <Method int Matrix.getColumnDimension()>
    //  151  353:iconst_1        
    //  152  354:isub            
    //  153  355:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //  154  358:invokevirtual   #290 <Method void PrintWriter.println(int)>
            }

    //  155  361:iinc            9  1
    //  156  364:iload           9
    //  157  366:aload_1         
    //  158  367:invokevirtual   #293 <Method int Matrix.getRowDimension()>
    //  159  370:icmplt          292
            outputFile.close();
    //  160  373:aload           8
    //  161  375:invokevirtual   #296 <Method void PrintWriter.close()>
        }
    //* 162  378:goto            388
        catch(IOException e)
    //* 163  381:astore          9
        {
            e.printStackTrace();
    //  164  383:aload           9
    //  165  385:invokevirtual   #301 <Method void IOException.printStackTrace()>
        }
    //  166  388:return          
    }

    private void generateUPA(Vector v_users, Vector v_permissions, Matrix UA, Matrix PA, String fileName)
    {
        Matrix UPA = UA.times(PA);
    //    0    0:aload_3         
    //    1    1:aload           4
    //    2    3:invokevirtual   #313 <Method Matrix Matrix.times(Matrix)>
    //    3    6:astore          7
        try
        {
            PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));
    //    4    8:new             #257 <Class PrintWriter>
    //    5   11:dup             
    //    6   12:new             #259 <Class FileWriter>
    //    7   15:dup             
    //    8   16:aload           5
    //    9   18:invokespecial   #260 <Method void FileWriter(String)>
    //   10   21:invokespecial   #263 <Method void PrintWriter(java.io.Writer)>
    //   11   24:astore          6
            outputFile.println("@assignment user-permission");
    //   12   26:aload           6
    //   13   28:ldc2            #315 <String "@assignment user-permission">
    //   14   31:invokevirtual   #268 <Method void PrintWriter.println(String)>
            outputFile.print("@dimension User {");
    //   15   34:aload           6
    //   16   36:ldc2            #317 <String "@dimension User {">
    //   17   39:invokevirtual   #275 <Method void PrintWriter.print(String)>
            for(int i = 0; i < v_users.size() - 1; i++)
    //*  18   42:iconst_0        
    //*  19   43:istore          8
    //*  20   45:goto            84
                outputFile.print((new StringBuilder(String.valueOf((String)v_users.get(i)))).append(",").toString());
    //   21   48:aload           6
    //   22   50:new             #134 <Class StringBuilder>
    //   23   53:dup             
    //   24   54:aload_1         
    //   25   55:iload           8
    //   26   57:invokevirtual   #277 <Method Object Vector.get(int)>
    //   27   60:checkcast       #136 <Class String>
    //   28   63:invokestatic    #140 <Method String String.valueOf(Object)>
    //   29   66:invokespecial   #142 <Method void StringBuilder(String)>
    //   30   69:ldc2            #279 <String ",">
    //   31   72:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   32   75:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   33   78:invokevirtual   #275 <Method void PrintWriter.print(String)>

    //   34   81:iinc            8  1
    //   35   84:iload           8
    //   36   86:aload_1         
    //   37   87:invokevirtual   #213 <Method int Vector.size()>
    //   38   90:iconst_1        
    //   39   91:isub            
    //   40   92:icmplt          48
            outputFile.println((new StringBuilder(String.valueOf((String)v_users.get(v_users.size() - 1)))).append("}").toString());
    //   41   95:aload           6
    //   42   97:new             #134 <Class StringBuilder>
    //   43  100:dup             
    //   44  101:aload_1         
    //   45  102:aload_1         
    //   46  103:invokevirtual   #213 <Method int Vector.size()>
    //   47  106:iconst_1        
    //   48  107:isub            
    //   49  108:invokevirtual   #277 <Method Object Vector.get(int)>
    //   50  111:checkcast       #136 <Class String>
    //   51  114:invokestatic    #140 <Method String String.valueOf(Object)>
    //   52  117:invokespecial   #142 <Method void StringBuilder(String)>
    //   53  120:ldc2            #281 <String "}">
    //   54  123:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   55  126:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   56  129:invokevirtual   #268 <Method void PrintWriter.println(String)>
            outputFile.print("@dimension Permssion {");
    //   57  132:aload           6
    //   58  134:ldc2            #319 <String "@dimension Permssion {">
    //   59  137:invokevirtual   #275 <Method void PrintWriter.print(String)>
            for(int i = 0; i < v_permissions.size() - 1; i++)
    //*  60  140:iconst_0        
    //*  61  141:istore          8
    //*  62  143:goto            182
                outputFile.print((new StringBuilder(String.valueOf((String)v_permissions.get(i)))).append(",").toString());
    //   63  146:aload           6
    //   64  148:new             #134 <Class StringBuilder>
    //   65  151:dup             
    //   66  152:aload_2         
    //   67  153:iload           8
    //   68  155:invokevirtual   #277 <Method Object Vector.get(int)>
    //   69  158:checkcast       #136 <Class String>
    //   70  161:invokestatic    #140 <Method String String.valueOf(Object)>
    //   71  164:invokespecial   #142 <Method void StringBuilder(String)>
    //   72  167:ldc2            #279 <String ",">
    //   73  170:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   74  173:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   75  176:invokevirtual   #275 <Method void PrintWriter.print(String)>

    //   76  179:iinc            8  1
    //   77  182:iload           8
    //   78  184:aload_2         
    //   79  185:invokevirtual   #213 <Method int Vector.size()>
    //   80  188:iconst_1        
    //   81  189:isub            
    //   82  190:icmplt          146
            outputFile.println((new StringBuilder(String.valueOf((String)v_permissions.get(v_permissions.size() - 1)))).append("}").toString());
    //   83  193:aload           6
    //   84  195:new             #134 <Class StringBuilder>
    //   85  198:dup             
    //   86  199:aload_2         
    //   87  200:aload_2         
    //   88  201:invokevirtual   #213 <Method int Vector.size()>
    //   89  204:iconst_1        
    //   90  205:isub            
    //   91  206:invokevirtual   #277 <Method Object Vector.get(int)>
    //   92  209:checkcast       #136 <Class String>
    //   93  212:invokestatic    #140 <Method String String.valueOf(Object)>
    //   94  215:invokespecial   #142 <Method void StringBuilder(String)>
    //   95  218:ldc2            #281 <String "}">
    //   96  221:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   97  224:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   98  227:invokevirtual   #268 <Method void PrintWriter.println(String)>
            outputFile.println("@matrix");
    //   99  230:aload           6
    //  100  232:ldc1            #17  <String "@matrix">
    //  101  234:invokevirtual   #268 <Method void PrintWriter.println(String)>
            for(int i = 0; i < UPA.getRowDimension(); i++)
    //* 102  237:iconst_0        
    //* 103  238:istore          8
    //* 104  240:goto            319
            {
                for(int j = 0; j < UPA.getColumnDimension() - 1; j++)
    //* 105  243:iconst_0        
    //* 106  244:istore          9
    //* 107  246:goto            285
                    outputFile.print((new StringBuilder(String.valueOf(UPA.get(i, j)))).append(",").toString());
    //  108  249:aload           6
    //  109  251:new             #134 <Class StringBuilder>
    //  110  254:dup             
    //  111  255:aload           7
    //  112  257:iload           8
    //  113  259:iload           9
    //  114  261:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //  115  264:invokestatic    #284 <Method String String.valueOf(int)>
    //  116  267:invokespecial   #142 <Method void StringBuilder(String)>
    //  117  270:ldc2            #279 <String ",">
    //  118  273:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  119  276:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  120  279:invokevirtual   #275 <Method void PrintWriter.print(String)>

    //  121  282:iinc            9  1
    //  122  285:iload           9
    //  123  287:aload           7
    //  124  289:invokevirtual   #287 <Method int Matrix.getColumnDimension()>
    //  125  292:iconst_1        
    //  126  293:isub            
    //  127  294:icmplt          249
                outputFile.println(UPA.get(i, UPA.getColumnDimension() - 1));
    //  128  297:aload           6
    //  129  299:aload           7
    //  130  301:iload           8
    //  131  303:aload           7
    //  132  305:invokevirtual   #287 <Method int Matrix.getColumnDimension()>
    //  133  308:iconst_1        
    //  134  309:isub            
    //  135  310:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //  136  313:invokevirtual   #290 <Method void PrintWriter.println(int)>
            }

    //  137  316:iinc            8  1
    //  138  319:iload           8
    //  139  321:aload           7
    //  140  323:invokevirtual   #293 <Method int Matrix.getRowDimension()>
    //  141  326:icmplt          243
            outputFile.close();
    //  142  329:aload           6
    //  143  331:invokevirtual   #296 <Method void PrintWriter.close()>
        }
    //* 144  334:goto            344
        catch(IOException e)
    //* 145  337:astore          8
        {
            e.printStackTrace();
    //  146  339:aload           8
    //  147  341:invokevirtual   #301 <Method void IOException.printStackTrace()>
        }
    //  148  344:return          
    }

    private void UPAtoString(Vector v_users, Vector v_permissions, Matrix UA, Matrix PA)
    {
        Matrix UPA = UA.times(PA);
    //    0    0:aload_3         
    //    1    1:aload           4
    //    2    3:invokevirtual   #313 <Method Matrix Matrix.times(Matrix)>
    //    3    6:astore          5
        upastr.append("@assignment user-permission\n");
    //    4    8:aload_0         
    //    5    9:getfield        #100 <Field StringBuffer upastr>
    //    6   12:ldc2            #323 <String "@assignment user-permission\n">
    //    7   15:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //    8   18:pop             
        upastr.append("@dimension User {");
    //    9   19:aload_0         
    //   10   20:getfield        #100 <Field StringBuffer upastr>
    //   11   23:ldc2            #317 <String "@dimension User {">
    //   12   26:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //   13   29:pop             
        for(int i = 0; i < v_users.size() - 1; i++)
    //*  14   30:iconst_0        
    //*  15   31:istore          6
    //*  16   33:goto            75
            upastr.append((new StringBuilder(String.valueOf((String)v_users.get(i)))).append(",").toString());
    //   17   36:aload_0         
    //   18   37:getfield        #100 <Field StringBuffer upastr>
    //   19   40:new             #134 <Class StringBuilder>
    //   20   43:dup             
    //   21   44:aload_1         
    //   22   45:iload           6
    //   23   47:invokevirtual   #277 <Method Object Vector.get(int)>
    //   24   50:checkcast       #136 <Class String>
    //   25   53:invokestatic    #140 <Method String String.valueOf(Object)>
    //   26   56:invokespecial   #142 <Method void StringBuilder(String)>
    //   27   59:ldc2            #279 <String ",">
    //   28   62:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   29   65:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   30   68:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //   31   71:pop             

    //   32   72:iinc            6  1
    //   33   75:iload           6
    //   34   77:aload_1         
    //   35   78:invokevirtual   #213 <Method int Vector.size()>
    //   36   81:iconst_1        
    //   37   82:isub            
    //   38   83:icmplt          36
        upastr.append((new StringBuilder(String.valueOf((String)v_users.get(v_users.size() - 1)))).append("}").append("\n").toString());
    //   39   86:aload_0         
    //   40   87:getfield        #100 <Field StringBuffer upastr>
    //   41   90:new             #134 <Class StringBuilder>
    //   42   93:dup             
    //   43   94:aload_1         
    //   44   95:aload_1         
    //   45   96:invokevirtual   #213 <Method int Vector.size()>
    //   46   99:iconst_1        
    //   47  100:isub            
    //   48  101:invokevirtual   #277 <Method Object Vector.get(int)>
    //   49  104:checkcast       #136 <Class String>
    //   50  107:invokestatic    #140 <Method String String.valueOf(Object)>
    //   51  110:invokespecial   #142 <Method void StringBuilder(String)>
    //   52  113:ldc2            #281 <String "}">
    //   53  116:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   54  119:ldc2            #328 <String "\n">
    //   55  122:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   56  125:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   57  128:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //   58  131:pop             
        upastr.append("@dimension Permssion {");
    //   59  132:aload_0         
    //   60  133:getfield        #100 <Field StringBuffer upastr>
    //   61  136:ldc2            #319 <String "@dimension Permssion {">
    //   62  139:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //   63  142:pop             
        for(int i = 0; i < v_permissions.size() - 1; i++)
    //*  64  143:iconst_0        
    //*  65  144:istore          6
    //*  66  146:goto            188
            upastr.append((new StringBuilder(String.valueOf((String)v_permissions.get(i)))).append(",").toString());
    //   67  149:aload_0         
    //   68  150:getfield        #100 <Field StringBuffer upastr>
    //   69  153:new             #134 <Class StringBuilder>
    //   70  156:dup             
    //   71  157:aload_2         
    //   72  158:iload           6
    //   73  160:invokevirtual   #277 <Method Object Vector.get(int)>
    //   74  163:checkcast       #136 <Class String>
    //   75  166:invokestatic    #140 <Method String String.valueOf(Object)>
    //   76  169:invokespecial   #142 <Method void StringBuilder(String)>
    //   77  172:ldc2            #279 <String ",">
    //   78  175:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   79  178:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   80  181:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //   81  184:pop             

    //   82  185:iinc            6  1
    //   83  188:iload           6
    //   84  190:aload_2         
    //   85  191:invokevirtual   #213 <Method int Vector.size()>
    //   86  194:iconst_1        
    //   87  195:isub            
    //   88  196:icmplt          149
        upastr.append((new StringBuilder(String.valueOf((String)v_permissions.get(v_permissions.size() - 1)))).append("}").append("\n").toString());
    //   89  199:aload_0         
    //   90  200:getfield        #100 <Field StringBuffer upastr>
    //   91  203:new             #134 <Class StringBuilder>
    //   92  206:dup             
    //   93  207:aload_2         
    //   94  208:aload_2         
    //   95  209:invokevirtual   #213 <Method int Vector.size()>
    //   96  212:iconst_1        
    //   97  213:isub            
    //   98  214:invokevirtual   #277 <Method Object Vector.get(int)>
    //   99  217:checkcast       #136 <Class String>
    //  100  220:invokestatic    #140 <Method String String.valueOf(Object)>
    //  101  223:invokespecial   #142 <Method void StringBuilder(String)>
    //  102  226:ldc2            #281 <String "}">
    //  103  229:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  104  232:ldc2            #328 <String "\n">
    //  105  235:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  106  238:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  107  241:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //  108  244:pop             
        upastr.append("@matrix\r\n");
    //  109  245:aload_0         
    //  110  246:getfield        #100 <Field StringBuffer upastr>
    //  111  249:ldc2            #330 <String "@matrix\r\n">
    //  112  252:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //  113  255:pop             
        for(int i = 0; i < UPA.getRowDimension(); i++)
    //* 114  256:iconst_0        
    //* 115  257:istore          6
    //* 116  259:goto            363
        {
            for(int j = 0; j < UPA.getColumnDimension() - 1; j++)
    //* 117  262:iconst_0        
    //* 118  263:istore          7
    //* 119  265:goto            307
                upastr.append((new StringBuilder(String.valueOf(UPA.get(i, j)))).append(",").toString());
    //  120  268:aload_0         
    //  121  269:getfield        #100 <Field StringBuffer upastr>
    //  122  272:new             #134 <Class StringBuilder>
    //  123  275:dup             
    //  124  276:aload           5
    //  125  278:iload           6
    //  126  280:iload           7
    //  127  282:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //  128  285:invokestatic    #284 <Method String String.valueOf(int)>
    //  129  288:invokespecial   #142 <Method void StringBuilder(String)>
    //  130  291:ldc2            #279 <String ",">
    //  131  294:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  132  297:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  133  300:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //  134  303:pop             

    //  135  304:iinc            7  1
    //  136  307:iload           7
    //  137  309:aload           5
    //  138  311:invokevirtual   #287 <Method int Matrix.getColumnDimension()>
    //  139  314:iconst_1        
    //  140  315:isub            
    //  141  316:icmplt          268
            upastr.append((new StringBuilder(String.valueOf(UPA.get(i, UPA.getColumnDimension() - 1)))).append("\n").toString());
    //  142  319:aload_0         
    //  143  320:getfield        #100 <Field StringBuffer upastr>
    //  144  323:new             #134 <Class StringBuilder>
    //  145  326:dup             
    //  146  327:aload           5
    //  147  329:iload           6
    //  148  331:aload           5
    //  149  333:invokevirtual   #287 <Method int Matrix.getColumnDimension()>
    //  150  336:iconst_1        
    //  151  337:isub            
    //  152  338:invokevirtual   #225 <Method byte Matrix.get(int, int)>
    //  153  341:invokestatic    #284 <Method String String.valueOf(int)>
    //  154  344:invokespecial   #142 <Method void StringBuilder(String)>
    //  155  347:ldc2            #328 <String "\n">
    //  156  350:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  157  353:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  158  356:invokevirtual   #326 <Method StringBuffer StringBuffer.append(String)>
    //  159  359:pop             
        }

    //  160  360:iinc            6  1
    //  161  363:iload           6
    //  162  365:aload           5
    //  163  367:invokevirtual   #293 <Method int Matrix.getRowDimension()>
    //  164  370:icmplt          262
    //  165  373:return          
    }

    public String getUPAString()
    {
        return upastr.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #100 <Field StringBuffer upastr>
    //    2    4:invokevirtual   #332 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public void main(String args[])
    {
        RandomGenerateData gd = new RandomGenerateData();
    //    0    0:new             #2   <Class RandomGenerateData>
    //    1    3:dup             
    //    2    4:invokespecial   #335 <Method void RandomGenerateData()>
    //    3    7:astore_2        
        gd.generate();
    //    4    8:aload_2         
    //    5    9:invokevirtual   #337 <Method void generate()>
    //    6   12:return          
    }

    public void buildGeneraters()
        throws Exception
    {
        generate();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #337 <Method void generate()>
    //    2    4:return          
    }

    public String globalInfo()
    {
        return "random dataset generater \nuser-role,role-permission,user-permission.";
    //    0    0:ldc2            #347 <String "random dataset generater \nuser-role,role-permission,user-permission.">
    //    1    3:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tThe required number of users. (default = ")).append(noUsers).append(")").toString();
    //    0    0:new             #134 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #351 <String "\tThe required number of users. (default = ">
    //    3    7:invokespecial   #142 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #59  <Field int noUsers>
    //    6   14:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #353 <String ")">
    //    8   20:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tThe required number of roles. (default = ")).append(noRoles).append(")").toString();
    //   11   27:new             #134 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #355 <String "\tThe required number of roles. (default = ">
    //   14   34:invokespecial   #142 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #61  <Field int noRoles>
    //   17   41:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #353 <String ")">
    //   19   47:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tThe required number of permission. (default = ")).append(noPermissions).append(")").toString();
    //   22   54:new             #134 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #357 <String "\tThe required number of permission. (default = ">
    //   25   61:invokespecial   #142 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #63  <Field int noPermissions>
    //   28   68:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #353 <String ")">
    //   30   74:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tThe required seed of random. (default = ")).append(seed).append(")").toString();
    //   33   81:new             #134 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #359 <String "\tThe required seed of random. (default = ">
    //   36   88:invokespecial   #142 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #75  <Field int seed>
    //   39   95:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #353 <String ")">
    //   41  101:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        String string5 = (new StringBuilder("\tThe required filename of output. (default = ")).append(outputFile).append(")").toString();
    //   44  109:new             #134 <Class StringBuilder>
    //   45  112:dup             
    //   46  113:ldc2            #361 <String "\tThe required filename of output. (default = ">
    //   47  116:invokespecial   #142 <Method void StringBuilder(String)>
    //   48  119:aload_0         
    //   49  120:getfield        #79  <Field String outputFile>
    //   50  123:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   51  126:ldc2            #353 <String ")">
    //   52  129:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   53  132:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   54  135:astore          5
        String string6 = (new StringBuilder("\tMean of every user's roles. (default = ")).append(urMean).append(")").toString();
    //   55  137:new             #134 <Class StringBuilder>
    //   56  140:dup             
    //   57  141:ldc2            #363 <String "\tMean of every user's roles. (default = ">
    //   58  144:invokespecial   #142 <Method void StringBuilder(String)>
    //   59  147:aload_0         
    //   60  148:getfield        #65  <Field int urMean>
    //   61  151:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   62  154:ldc2            #353 <String ")">
    //   63  157:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   64  160:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   65  163:astore          6
        String string7 = (new StringBuilder("\tVariance of every user's roles. (default = ")).append(urStd).append(")").toString();
    //   66  165:new             #134 <Class StringBuilder>
    //   67  168:dup             
    //   68  169:ldc2            #365 <String "\tVariance of every user's roles. (default = ">
    //   69  172:invokespecial   #142 <Method void StringBuilder(String)>
    //   70  175:aload_0         
    //   71  176:getfield        #69  <Field double urStd>
    //   72  179:invokevirtual   #368 <Method StringBuilder StringBuilder.append(double)>
    //   73  182:ldc2            #353 <String ")">
    //   74  185:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   75  188:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   76  191:astore          7
        String string8 = (new StringBuilder("\tMean of every role's permissions. (default = ")).append(rpMean).append(")").toString();
    //   77  193:new             #134 <Class StringBuilder>
    //   78  196:dup             
    //   79  197:ldc2            #370 <String "\tMean of every role's permissions. (default = ">
    //   80  200:invokespecial   #142 <Method void StringBuilder(String)>
    //   81  203:aload_0         
    //   82  204:getfield        #67  <Field int rpMean>
    //   83  207:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   84  210:ldc2            #353 <String ")">
    //   85  213:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   86  216:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   87  219:astore          8
        String string9 = (new StringBuilder("\tVariance of every role's permissions. (default = ")).append(rpStd).append(")").toString();
    //   88  221:new             #134 <Class StringBuilder>
    //   89  224:dup             
    //   90  225:ldc2            #372 <String "\tVariance of every role's permissions. (default = ">
    //   91  228:invokespecial   #142 <Method void StringBuilder(String)>
    //   92  231:aload_0         
    //   93  232:getfield        #73  <Field double rpStd>
    //   94  235:invokevirtual   #368 <Method StringBuilder StringBuilder.append(double)>
    //   95  238:ldc2            #353 <String ")">
    //   96  241:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   97  244:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   98  247:astore          9
        String string10 = (new StringBuilder("\tDetermines if roles are disjoint. (default = ")).append(disjoint).append(")").toString();
    //   99  249:new             #134 <Class StringBuilder>
    //  100  252:dup             
    //  101  253:ldc2            #374 <String "\tDetermines if roles are disjoint. (default = ">
    //  102  256:invokespecial   #142 <Method void StringBuilder(String)>
    //  103  259:aload_0         
    //  104  260:getfield        #81  <Field boolean disjoint>
    //  105  263:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  106  266:ldc2            #353 <String ")">
    //  107  269:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //  108  272:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  109  275:astore          10
        FastVector newVector = new FastVector(10);
    //  110  277:new             #379 <Class FastVector>
    //  111  280:dup             
    //  112  281:bipush          10
    //  113  283:invokespecial   #381 <Method void FastVector(int)>
    //  114  286:astore          11
        newVector.addElement(new Option(string1, "U", 1, "-U <Required number of users>"));
    //  115  288:aload           11
    //  116  290:new             #383 <Class Option>
    //  117  293:dup             
    //  118  294:aload_1         
    //  119  295:ldc2            #385 <String "U">
    //  120  298:iconst_1        
    //  121  299:ldc2            #387 <String "-U <Required number of users>">
    //  122  302:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  123  305:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "R", 1, "-R <Required number of roles>"));
    //  124  308:aload           11
    //  125  310:new             #383 <Class Option>
    //  126  313:dup             
    //  127  314:aload_2         
    //  128  315:ldc2            #396 <String "R">
    //  129  318:iconst_1        
    //  130  319:ldc2            #398 <String "-R <Required number of roles>">
    //  131  322:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  132  325:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", 1, "-P <Required number of permission>"));
    //  133  328:aload           11
    //  134  330:new             #383 <Class Option>
    //  135  333:dup             
    //  136  334:aload_3         
    //  137  335:ldc2            #400 <String "P">
    //  138  338:iconst_1        
    //  139  339:ldc2            #402 <String "-P <Required number of permission>">
    //  140  342:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  141  345:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "S", 1, "-S <Required seed of random>"));
    //  142  348:aload           11
    //  143  350:new             #383 <Class Option>
    //  144  353:dup             
    //  145  354:aload           4
    //  146  356:ldc2            #404 <String "S">
    //  147  359:iconst_1        
    //  148  360:ldc2            #406 <String "-S <Required seed of random>">
    //  149  363:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  150  366:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string5, "F", 1, "-F <Required filename of output>"));
    //  151  369:aload           11
    //  152  371:new             #383 <Class Option>
    //  153  374:dup             
    //  154  375:aload           5
    //  155  377:ldc2            #408 <String "F">
    //  156  380:iconst_1        
    //  157  381:ldc2            #410 <String "-F <Required filename of output>">
    //  158  384:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  159  387:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string6, "urM", 1, "-urM <Mean of every user's roles>"));
    //  160  390:aload           11
    //  161  392:new             #383 <Class Option>
    //  162  395:dup             
    //  163  396:aload           6
    //  164  398:ldc2            #412 <String "urM">
    //  165  401:iconst_1        
    //  166  402:ldc2            #414 <String "-urM <Mean of every user's roles>">
    //  167  405:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  168  408:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string7, "urS", 1, "-urS <Variance of every user's roles>"));
    //  169  411:aload           11
    //  170  413:new             #383 <Class Option>
    //  171  416:dup             
    //  172  417:aload           7
    //  173  419:ldc2            #416 <String "urS">
    //  174  422:iconst_1        
    //  175  423:ldc2            #418 <String "-urS <Variance of every user's roles>">
    //  176  426:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  177  429:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string8, "rpM", 1, "-rpM <Mean of every role's permissions>"));
    //  178  432:aload           11
    //  179  434:new             #383 <Class Option>
    //  180  437:dup             
    //  181  438:aload           8
    //  182  440:ldc2            #420 <String "rpM">
    //  183  443:iconst_1        
    //  184  444:ldc2            #422 <String "-rpM <Mean of every role's permissions>">
    //  185  447:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  186  450:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string9, "rpS", 1, "-rpS <Variance of every role's permissions>"));
    //  187  453:aload           11
    //  188  455:new             #383 <Class Option>
    //  189  458:dup             
    //  190  459:aload           9
    //  191  461:ldc2            #424 <String "rpS">
    //  192  464:iconst_1        
    //  193  465:ldc2            #426 <String "-rpS <Variance of every role's permissions>">
    //  194  468:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  195  471:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string10, "DisJ", 1, "-DisJ <Determines if roles are disjoint>"));
    //  196  474:aload           11
    //  197  476:new             #383 <Class Option>
    //  198  479:dup             
    //  199  480:aload           10
    //  200  482:ldc2            #428 <String "DisJ">
    //  201  485:iconst_1        
    //  202  486:ldc2            #430 <String "-DisJ <Determines if roles are disjoint>">
    //  203  489:invokespecial   #390 <Method void Option(String, String, int, String)>
    //  204  492:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //  205  495:aload           11
    //  206  497:invokevirtual   #433 <Method Enumeration FastVector.elements()>
    //  207  500:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #102 <Method void resetOptions()>
        String s_noUsers = Utils.getOption('U', options);
    //    2    4:bipush          85
    //    3    6:aload_1         
    //    4    7:invokestatic    #452 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_noUsers.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #455 <Method int String.length()>
    //*   8   15:ifeq            26
            noUsers = Integer.parseInt(s_noUsers);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #459 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #59  <Field int noUsers>
        String s_noRoles = Utils.getOption('R', options);
    //   13   26:bipush          82
    //   14   28:aload_1         
    //   15   29:invokestatic    #452 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_noRoles.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #455 <Method int String.length()>
    //*  19   37:ifeq            48
            noRoles = Integer.parseInt(s_noUsers);
    //   20   40:aload_0         
    //   21   41:aload_2         
    //   22   42:invokestatic    #459 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #61  <Field int noRoles>
        String s_noPermissions = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #452 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_noPermissions.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #455 <Method int String.length()>
    //*  30   61:ifeq            73
            noPermissions = Integer.parseInt(s_noPermissions);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #459 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #63  <Field int noPermissions>
        String s_seed = Utils.getOption('S', options);
    //   35   73:bipush          83
    //   36   75:aload_1         
    //   37   76:invokestatic    #452 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_seed.length() != 0)
    //*  39   81:aload           5
    //*  40   83:invokevirtual   #455 <Method int String.length()>
    //*  41   86:ifeq            98
            seed = Integer.parseInt(s_seed);
    //   42   89:aload_0         
    //   43   90:aload           5
    //   44   92:invokestatic    #459 <Method int Integer.parseInt(String)>
    //   45   95:putfield        #75  <Field int seed>
        outputFile = Utils.getOption('F', options);
    //   46   98:aload_0         
    //   47   99:bipush          70
    //   48  101:aload_1         
    //   49  102:invokestatic    #452 <Method String Utils.getOption(char, String[])>
    //   50  105:putfield        #79  <Field String outputFile>
        if(outputFile.length() == 0)
    //*  51  108:aload_0         
    //*  52  109:getfield        #79  <Field String outputFile>
    //*  53  112:invokevirtual   #455 <Method int String.length()>
    //*  54  115:ifne            124
            outputFile = "test";
    //   55  118:aload_0         
    //   56  119:ldc1            #77  <String "test">
    //   57  121:putfield        #79  <Field String outputFile>
        String s_urMean = Utils.getOption("urM", options);
    //   58  124:ldc2            #412 <String "urM">
    //   59  127:aload_1         
    //   60  128:invokestatic    #462 <Method String Utils.getOption(String, String[])>
    //   61  131:astore          6
        if(s_urMean.length() != 0)
    //*  62  133:aload           6
    //*  63  135:invokevirtual   #455 <Method int String.length()>
    //*  64  138:ifeq            150
            urMean = Integer.parseInt(s_urMean);
    //   65  141:aload_0         
    //   66  142:aload           6
    //   67  144:invokestatic    #459 <Method int Integer.parseInt(String)>
    //   68  147:putfield        #65  <Field int urMean>
        String s_urStd = Utils.getOption("urS", options);
    //   69  150:ldc2            #416 <String "urS">
    //   70  153:aload_1         
    //   71  154:invokestatic    #462 <Method String Utils.getOption(String, String[])>
    //   72  157:astore          7
        if(s_urStd.length() != 0)
    //*  73  159:aload           7
    //*  74  161:invokevirtual   #455 <Method int String.length()>
    //*  75  164:ifeq            176
            urStd = Double.parseDouble(s_urStd);
    //   76  167:aload_0         
    //   77  168:aload           7
    //   78  170:invokestatic    #468 <Method double Double.parseDouble(String)>
    //   79  173:putfield        #69  <Field double urStd>
        String s_rpMean = Utils.getOption("rpM", options);
    //   80  176:ldc2            #420 <String "rpM">
    //   81  179:aload_1         
    //   82  180:invokestatic    #462 <Method String Utils.getOption(String, String[])>
    //   83  183:astore          8
        if(s_rpMean.length() != 0)
    //*  84  185:aload           8
    //*  85  187:invokevirtual   #455 <Method int String.length()>
    //*  86  190:ifeq            202
            rpMean = Integer.parseInt(s_urMean);
    //   87  193:aload_0         
    //   88  194:aload           6
    //   89  196:invokestatic    #459 <Method int Integer.parseInt(String)>
    //   90  199:putfield        #67  <Field int rpMean>
        String s_rpStd = Utils.getOption("rpS", options);
    //   91  202:ldc2            #424 <String "rpS">
    //   92  205:aload_1         
    //   93  206:invokestatic    #462 <Method String Utils.getOption(String, String[])>
    //   94  209:astore          9
        if(s_rpStd.length() != 0)
    //*  95  211:aload           9
    //*  96  213:invokevirtual   #455 <Method int String.length()>
    //*  97  216:ifeq            228
            rpStd = Double.parseDouble(s_urStd);
    //   98  219:aload_0         
    //   99  220:aload           7
    //  100  222:invokestatic    #468 <Method double Double.parseDouble(String)>
    //  101  225:putfield        #73  <Field double rpStd>
        String s_disjoint = Utils.getOption("DisJ", options);
    //  102  228:ldc2            #428 <String "DisJ">
    //  103  231:aload_1         
    //  104  232:invokestatic    #462 <Method String Utils.getOption(String, String[])>
    //  105  235:astore          10
        if(s_disjoint.equals("true") || s_disjoint.equals("TRUE"))
    //* 106  237:aload           10
    //* 107  239:ldc2            #470 <String "true">
    //* 108  242:invokevirtual   #473 <Method boolean String.equals(Object)>
    //* 109  245:ifne            259
    //* 110  248:aload           10
    //* 111  250:ldc2            #475 <String "TRUE">
    //* 112  253:invokevirtual   #473 <Method boolean String.equals(Object)>
    //* 113  256:ifeq            267
            disjoint = true;
    //  114  259:aload_0         
    //  115  260:iconst_1        
    //  116  261:putfield        #81  <Field boolean disjoint>
        else
    //* 117  264:goto            272
            disjoint = false;
    //  118  267:aload_0         
    //  119  268:iconst_0        
    //  120  269:putfield        #81  <Field boolean disjoint>
    //  121  272:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[30];
    //    0    0:bipush          30
    //    1    2:anewarray       String[]
    //    2    5:astore_1        
        int current = 0;
    //    3    6:iconst_0        
    //    4    7:istore_2        
        options[current++] = "-U";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #489 <String "-U">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(noUsers).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #134 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #490 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #59  <Field int noUsers>
    //   18   33:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-R";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #492 <String "-R">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(noRoles).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #134 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #490 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #61  <Field int noRoles>
    //   34   65:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #494 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(noPermissions).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #134 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #490 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #63  <Field int noPermissions>
    //   50   97:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-S";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #496 <String "-S">
    //   57  112:aastore         
        options[current++] = (new StringBuilder()).append(seed).toString();
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #134 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #490 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #75  <Field int seed>
    //   66  129:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   68  135:aastore         
        options[current++] = "-F";
    //   69  136:aload_1         
    //   70  137:iload_2         
    //   71  138:iinc            2  1
    //   72  141:ldc2            #498 <String "-F">
    //   73  144:aastore         
        options[current++] = (new StringBuilder()).append(outputFile).toString();
    //   74  145:aload_1         
    //   75  146:iload_2         
    //   76  147:iinc            2  1
    //   77  150:new             #134 <Class StringBuilder>
    //   78  153:dup             
    //   79  154:invokespecial   #490 <Method void StringBuilder()>
    //   80  157:aload_0         
    //   81  158:getfield        #79  <Field String outputFile>
    //   82  161:invokevirtual   #148 <Method StringBuilder StringBuilder.append(String)>
    //   83  164:invokevirtual   #152 <Method String StringBuilder.toString()>
    //   84  167:aastore         
        options[current++] = "-urM";
    //   85  168:aload_1         
    //   86  169:iload_2         
    //   87  170:iinc            2  1
    //   88  173:ldc2            #500 <String "-urM">
    //   89  176:aastore         
        options[current++] = (new StringBuilder()).append(urMean).toString();
    //   90  177:aload_1         
    //   91  178:iload_2         
    //   92  179:iinc            2  1
    //   93  182:new             #134 <Class StringBuilder>
    //   94  185:dup             
    //   95  186:invokespecial   #490 <Method void StringBuilder()>
    //   96  189:aload_0         
    //   97  190:getfield        #65  <Field int urMean>
    //   98  193:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //   99  196:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  100  199:aastore         
        options[current++] = "-urS";
    //  101  200:aload_1         
    //  102  201:iload_2         
    //  103  202:iinc            2  1
    //  104  205:ldc2            #502 <String "-urS">
    //  105  208:aastore         
        options[current++] = (new StringBuilder()).append(urStd).toString();
    //  106  209:aload_1         
    //  107  210:iload_2         
    //  108  211:iinc            2  1
    //  109  214:new             #134 <Class StringBuilder>
    //  110  217:dup             
    //  111  218:invokespecial   #490 <Method void StringBuilder()>
    //  112  221:aload_0         
    //  113  222:getfield        #69  <Field double urStd>
    //  114  225:invokevirtual   #368 <Method StringBuilder StringBuilder.append(double)>
    //  115  228:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  116  231:aastore         
        options[current++] = "-rpM";
    //  117  232:aload_1         
    //  118  233:iload_2         
    //  119  234:iinc            2  1
    //  120  237:ldc2            #504 <String "-rpM">
    //  121  240:aastore         
        options[current++] = (new StringBuilder()).append(rpMean).toString();
    //  122  241:aload_1         
    //  123  242:iload_2         
    //  124  243:iinc            2  1
    //  125  246:new             #134 <Class StringBuilder>
    //  126  249:dup             
    //  127  250:invokespecial   #490 <Method void StringBuilder()>
    //  128  253:aload_0         
    //  129  254:getfield        #67  <Field int rpMean>
    //  130  257:invokevirtual   #186 <Method StringBuilder StringBuilder.append(int)>
    //  131  260:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  132  263:aastore         
        options[current++] = "-rpS";
    //  133  264:aload_1         
    //  134  265:iload_2         
    //  135  266:iinc            2  1
    //  136  269:ldc2            #506 <String "-rpS">
    //  137  272:aastore         
        options[current++] = (new StringBuilder()).append(rpStd).toString();
    //  138  273:aload_1         
    //  139  274:iload_2         
    //  140  275:iinc            2  1
    //  141  278:new             #134 <Class StringBuilder>
    //  142  281:dup             
    //  143  282:invokespecial   #490 <Method void StringBuilder()>
    //  144  285:aload_0         
    //  145  286:getfield        #73  <Field double rpStd>
    //  146  289:invokevirtual   #368 <Method StringBuilder StringBuilder.append(double)>
    //  147  292:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  148  295:aastore         
        options[current++] = "-DisJ";
    //  149  296:aload_1         
    //  150  297:iload_2         
    //  151  298:iinc            2  1
    //  152  301:ldc2            #508 <String "-DisJ">
    //  153  304:aastore         
        for(options[current++] = (new StringBuilder()).append(disjoint).toString(); current < options.length; options[current++] = "");
    //  154  305:aload_1         
    //  155  306:iload_2         
    //  156  307:iinc            2  1
    //  157  310:new             #134 <Class StringBuilder>
    //  158  313:dup             
    //  159  314:invokespecial   #490 <Method void StringBuilder()>
    //  160  317:aload_0         
    //  161  318:getfield        #81  <Field boolean disjoint>
    //  162  321:invokevirtual   #377 <Method StringBuilder StringBuilder.append(boolean)>
    //  163  324:invokevirtual   #152 <Method String StringBuilder.toString()>
    //  164  327:aastore         
    //  165  328:goto            340
    //  166  331:aload_1         
    //  167  332:iload_2         
    //  168  333:iinc            2  1
    //  169  336:ldc2            #510 <String "">
    //  170  339:aastore         
    //  171  340:iload_2         
    //  172  341:aload_1         
    //  173  342:arraylength     
    //  174  343:icmplt          331
        return options;
    //  175  346:aload_1         
    //  176  347:areturn         
    }

    public int getNoUsers()
    {
        return noUsers;
    //    0    0:aload_0         
    //    1    1:getfield        #59  <Field int noUsers>
    //    2    4:ireturn         
    }

    public void setNoUsers(int noUsers)
    {
        this.noUsers = noUsers;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #59  <Field int noUsers>
    //    3    5:return          
    }

    public String noUsersTipText()
    {
        return "The required number of users.";
    //    0    0:ldc2            #516 <String "The required number of users.">
    //    1    3:areturn         
    }

    public int getNoRoles()
    {
        return noRoles;
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field int noRoles>
    //    2    4:ireturn         
    }

    public void setNoRoles(int noRoles)
    {
        this.noRoles = noRoles;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #61  <Field int noRoles>
    //    3    5:return          
    }

    public String noRolesTipText()
    {
        return "The required number of roles.";
    //    0    0:ldc2            #521 <String "The required number of roles.">
    //    1    3:areturn         
    }

    public int getNoPermissions()
    {
        return noPermissions;
    //    0    0:aload_0         
    //    1    1:getfield        #63  <Field int noPermissions>
    //    2    4:ireturn         
    }

    public void setNoPermissions(int noPermissions)
    {
        this.noPermissions = noPermissions;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #63  <Field int noPermissions>
    //    3    5:return          
    }

    public String noPermissionsTipText()
    {
        return "The required number of permission.";
    //    0    0:ldc2            #526 <String "The required number of permission.">
    //    1    3:areturn         
    }

    public int getUrMean()
    {
        return urMean;
    //    0    0:aload_0         
    //    1    1:getfield        #65  <Field int urMean>
    //    2    4:ireturn         
    }

    public void setUrMean(int urMean)
    {
        this.urMean = urMean;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #65  <Field int urMean>
    //    3    5:return          
    }

    public String urMeanTipText()
    {
        return "Mean of every user's roles.";
    //    0    0:ldc2            #531 <String "Mean of every user's roles.">
    //    1    3:areturn         
    }

    public double getUrStd()
    {
        return urStd;
    //    0    0:aload_0         
    //    1    1:getfield        #69  <Field double urStd>
    //    2    4:dreturn         
    }

    public void setUrStd(double urStd)
    {
        this.urStd = urStd;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #69  <Field double urStd>
    //    3    5:return          
    }

    public String urStdTipText()
    {
        return "Variance of every user's roles.";
    //    0    0:ldc2            #537 <String "Variance of every user's roles.">
    //    1    3:areturn         
    }

    public int getRpMean()
    {
        return rpMean;
    //    0    0:aload_0         
    //    1    1:getfield        #67  <Field int rpMean>
    //    2    4:ireturn         
    }

    public void setRpMean(int rpMean)
    {
        this.rpMean = rpMean;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #67  <Field int rpMean>
    //    3    5:return          
    }

    public String rpMeanTipText()
    {
        return "Mean of every role's permissions.";
    //    0    0:ldc2            #542 <String "Mean of every role's permissions.">
    //    1    3:areturn         
    }

    public double getRpStd()
    {
        return rpStd;
    //    0    0:aload_0         
    //    1    1:getfield        #73  <Field double rpStd>
    //    2    4:dreturn         
    }

    public void setRpStd(double rpStd)
    {
        this.rpStd = rpStd;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #73  <Field double rpStd>
    //    3    5:return          
    }

    public String rpStdTipText()
    {
        return "Variance of every role's permissions.";
    //    0    0:ldc2            #547 <String "Variance of every role's permissions.">
    //    1    3:areturn         
    }

    public boolean isDisjoint()
    {
        return disjoint;
    //    0    0:aload_0         
    //    1    1:getfield        #81  <Field boolean disjoint>
    //    2    4:ireturn         
    }

    public void setDisjoint(boolean disjoint)
    {
        this.disjoint = disjoint;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #81  <Field boolean disjoint>
    //    3    5:return          
    }

    public String disjointTipText()
    {
        return "Variance of every role's permissions.";
    //    0    0:ldc2            #547 <String "Variance of every role's permissions.">
    //    1    3:areturn         
    }

    public Distribution getDist()
    {
        return dist;
    //    0    0:aload_0         
    //    1    1:getfield        #88  <Field RandomGenerateData$Distribution dist>
    //    2    4:areturn         
    }

    public void setDist(Distribution dist)
    {
        this.dist = dist;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #88  <Field RandomGenerateData$Distribution dist>
    //    3    5:return          
    }

    public int getSeed()
    {
        return seed;
    //    0    0:aload_0         
    //    1    1:getfield        #75  <Field int seed>
    //    2    4:ireturn         
    }

    public void setSeed(int seed)
    {
        this.seed = seed;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #75  <Field int seed>
    //    3    5:return          
    }

    public String seedTipText()
    {
        return "The required seed of random.";
    //    0    0:ldc2            #561 <String "The required seed of random.">
    //    1    3:areturn         
    }

    public String getOutputFile()
    {
        return outputFile;
    //    0    0:aload_0         
    //    1    1:getfield        #79  <Field String outputFile>
    //    2    4:areturn         
    }

    public void setOutputFile(String newFile)
    {
        outputFile = newFile;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #79  <Field String outputFile>
    //    3    5:return          
    }

    public String outputFileTipText()
    {
        return "The required filename of output.";
    //    0    0:ldc2            #567 <String "The required filename of output.">
    //    1    3:areturn         
    }

    static final String ASSIGNMENT = "@assignment";
    static final String DIMENSION = "@dimension";
    static final String MATRIX = "@matrix";
    static final String USERS = "User";
    static final String ROLES = "Role";
    static final String PERMS = "Permssion";
    static final String ASSUA = "user-role";
    static final String ASSPA = "role-permission";
    static final String ASSUPA = "user-permission";
    private int noUsers;
    private int noRoles;
    private int noPermissions;
    private int urMean;
    private int rpMean;
    private double urStd;
    private double rpStd;
    private int seed;
    private Random rand;
    private boolean disjoint;
    private Distribution dist;
    private String outputFile;
    private StringBuffer upastr;
}

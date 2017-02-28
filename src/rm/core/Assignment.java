// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Assignment.java

package rm.core;


// Referenced classes of package rm.core:
//            Matrix, Dimension, Attribute, Instances

public class Assignment
{

    public Assignment(Assignment newassignment)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #27  <Method void Object()>
        DimensionX = newassignment.getDimensionX();
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #31  <Method Dimension getDimensionX()>
    //    5    9:putfield        #33  <Field Dimension DimensionX>
        DimensionY = newassignment.getDimensionY();
    //    6   12:aload_0         
    //    7   13:aload_1         
    //    8   14:invokevirtual   #36  <Method Dimension getDimensionY()>
    //    9   17:putfield        #38  <Field Dimension DimensionY>
        m_AssignementName = newassignment.getAssignementName();
    //   10   20:aload_0         
    //   11   21:aload_1         
    //   12   22:invokevirtual   #42  <Method String getAssignementName()>
    //   13   25:putfield        #44  <Field String m_AssignementName>
        AssignmentMatrix = newassignment.getAssignmentMatrix().copy();
    //   14   28:aload_0         
    //   15   29:aload_1         
    //   16   30:invokevirtual   #48  <Method Matrix getAssignmentMatrix()>
    //   17   33:invokevirtual   #53  <Method Matrix Matrix.copy()>
    //   18   36:putfield        #55  <Field Matrix AssignmentMatrix>
    //   19   39:return          
    }

    public Assignment()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #27  <Method void Object()>
        m_AssignementName = "";
    //    2    4:aload_0         
    //    3    5:ldc1            #62  <String "">
    //    4    7:putfield        #44  <Field String m_AssignementName>
        DimensionX = new Dimension();
    //    5   10:aload_0         
    //    6   11:new             #64  <Class Dimension>
    //    7   14:dup             
    //    8   15:invokespecial   #65  <Method void Dimension()>
    //    9   18:putfield        #33  <Field Dimension DimensionX>
        DimensionY = new Dimension();
    //   10   21:aload_0         
    //   11   22:new             #64  <Class Dimension>
    //   12   25:dup             
    //   13   26:invokespecial   #65  <Method void Dimension()>
    //   14   29:putfield        #38  <Field Dimension DimensionY>
        AssignmentMatrix = new Matrix(1, 1);
    //   15   32:aload_0         
    //   16   33:new             #50  <Class Matrix>
    //   17   36:dup             
    //   18   37:iconst_1        
    //   19   38:iconst_1        
    //   20   39:invokespecial   #68  <Method void Matrix(int, int)>
    //   21   42:putfield        #55  <Field Matrix AssignmentMatrix>
    //   22   45:return          
    }

    public String getAssignementName()
    {
        return m_AssignementName;
    //    0    0:aload_0         
    //    1    1:getfield        #44  <Field String m_AssignementName>
    //    2    4:areturn         
    }

    public void setAssignementName(String newName)
    {
        m_AssignementName = newName;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #44  <Field String m_AssignementName>
    //    3    5:return          
    }

    public Dimension getDimensionX()
    {
        return DimensionX;
    //    0    0:aload_0         
    //    1    1:getfield        #33  <Field Dimension DimensionX>
    //    2    4:areturn         
    }

    public void setDimensionX(Dimension dimensionx)
    {
        DimensionX = dimensionx;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #33  <Field Dimension DimensionX>
    //    3    5:return          
    }

    public Dimension getDimensionY()
    {
        return DimensionY;
    //    0    0:aload_0         
    //    1    1:getfield        #38  <Field Dimension DimensionY>
    //    2    4:areturn         
    }

    public void setDimensionY(Dimension dimensiony)
    {
        DimensionY = dimensiony;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #38  <Field Dimension DimensionY>
    //    3    5:return          
    }

    public Matrix getAssignmentMatrix()
    {
        return AssignmentMatrix;
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field Matrix AssignmentMatrix>
    //    2    4:areturn         
    }

    public void setAssignmentMatrix(Matrix assignmentMatrix)
    {
        AssignmentMatrix = assignmentMatrix;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #55  <Field Matrix AssignmentMatrix>
    //    3    5:return          
    }

    public String toString()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #82  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #83  <Method void StringBuffer()>
    //    3    7:astore_1        
        text.append("@assignment").append(" ").append((new StringBuilder(String.valueOf(m_AssignementName))).append("\n").toString());
    //    4    8:aload_1         
    //    5    9:ldc1            #12  <String "@assignment">
    //    6   11:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //    7   14:ldc1            #89  <String " ">
    //    8   16:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //    9   19:new             #91  <Class StringBuilder>
    //   10   22:dup             
    //   11   23:aload_0         
    //   12   24:getfield        #44  <Field String m_AssignementName>
    //   13   27:invokestatic    #97  <Method String String.valueOf(Object)>
    //   14   30:invokespecial   #99  <Method void StringBuilder(String)>
    //   15   33:ldc1            #101 <String "\n">
    //   16   35:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   17   38:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   18   41:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   19   44:pop             
        text.append((new StringBuilder("@dimension ")).append(DimensionX.getName()).append(" {").toString());
    //   20   45:aload_1         
    //   21   46:new             #91  <Class StringBuilder>
    //   22   49:dup             
    //   23   50:ldc1            #108 <String "@dimension ">
    //   24   52:invokespecial   #99  <Method void StringBuilder(String)>
    //   25   55:aload_0         
    //   26   56:getfield        #33  <Field Dimension DimensionX>
    //   27   59:invokevirtual   #111 <Method String Dimension.getName()>
    //   28   62:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   29   65:ldc1            #113 <String " {">
    //   30   67:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   31   70:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   32   73:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   33   76:pop             
        Object dx[] = DimensionX.getDimensionAttribute().toArray();
    //   34   77:aload_0         
    //   35   78:getfield        #33  <Field Dimension DimensionX>
    //   36   81:invokevirtual   #117 <Method Attribute Dimension.getDimensionAttribute()>
    //   37   84:invokevirtual   #123 <Method Object[] Attribute.toArray()>
    //   38   87:astore_2        
        for(int i = 0; i < dx.length - 1; i++)
    //*  39   88:iconst_0        
    //*  40   89:istore_3        
    //*  41   90:goto            122
            text.append((new StringBuilder()).append(dx[i]).append(",").toString());
    //   42   93:aload_1         
    //   43   94:new             #91  <Class StringBuilder>
    //   44   97:dup             
    //   45   98:invokespecial   #124 <Method void StringBuilder()>
    //   46  101:aload_2         
    //   47  102:iload_3         
    //   48  103:aaload          
    //   49  104:invokevirtual   #127 <Method StringBuilder StringBuilder.append(Object)>
    //   50  107:ldc1            #129 <String ",">
    //   51  109:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   52  112:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   53  115:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   54  118:pop             

    //   55  119:iinc            3  1
    //   56  122:iload_3         
    //   57  123:aload_2         
    //   58  124:arraylength     
    //   59  125:iconst_1        
    //   60  126:isub            
    //   61  127:icmplt          93
        text.append((new StringBuilder()).append(dx[dx.length - 1]).append("}").append("\n").toString());
    //   62  130:aload_1         
    //   63  131:new             #91  <Class StringBuilder>
    //   64  134:dup             
    //   65  135:invokespecial   #124 <Method void StringBuilder()>
    //   66  138:aload_2         
    //   67  139:aload_2         
    //   68  140:arraylength     
    //   69  141:iconst_1        
    //   70  142:isub            
    //   71  143:aaload          
    //   72  144:invokevirtual   #127 <Method StringBuilder StringBuilder.append(Object)>
    //   73  147:ldc1            #131 <String "}">
    //   74  149:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   75  152:ldc1            #101 <String "\n">
    //   76  154:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   77  157:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   78  160:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   79  163:pop             
        text.append((new StringBuilder("@dimension ")).append(DimensionY.getName()).append(" {").toString());
    //   80  164:aload_1         
    //   81  165:new             #91  <Class StringBuilder>
    //   82  168:dup             
    //   83  169:ldc1            #108 <String "@dimension ">
    //   84  171:invokespecial   #99  <Method void StringBuilder(String)>
    //   85  174:aload_0         
    //   86  175:getfield        #38  <Field Dimension DimensionY>
    //   87  178:invokevirtual   #111 <Method String Dimension.getName()>
    //   88  181:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   89  184:ldc1            #113 <String " {">
    //   90  186:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   91  189:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   92  192:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   93  195:pop             
        Object dy[] = DimensionY.getDimensionAttribute().toArray();
    //   94  196:aload_0         
    //   95  197:getfield        #38  <Field Dimension DimensionY>
    //   96  200:invokevirtual   #117 <Method Attribute Dimension.getDimensionAttribute()>
    //   97  203:invokevirtual   #123 <Method Object[] Attribute.toArray()>
    //   98  206:astore_3        
        for(int i = 0; i < dy.length - 1; i++)
    //*  99  207:iconst_0        
    //* 100  208:istore          4
    //* 101  210:goto            243
            text.append((new StringBuilder()).append(dy[i]).append(",").toString());
    //  102  213:aload_1         
    //  103  214:new             #91  <Class StringBuilder>
    //  104  217:dup             
    //  105  218:invokespecial   #124 <Method void StringBuilder()>
    //  106  221:aload_3         
    //  107  222:iload           4
    //  108  224:aaload          
    //  109  225:invokevirtual   #127 <Method StringBuilder StringBuilder.append(Object)>
    //  110  228:ldc1            #129 <String ",">
    //  111  230:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  112  233:invokevirtual   #106 <Method String StringBuilder.toString()>
    //  113  236:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  114  239:pop             

    //  115  240:iinc            4  1
    //  116  243:iload           4
    //  117  245:aload_3         
    //  118  246:arraylength     
    //  119  247:iconst_1        
    //  120  248:isub            
    //  121  249:icmplt          213
        text.append((new StringBuilder()).append(dy[dy.length - 1]).append("}").append("\n").toString());
    //  122  252:aload_1         
    //  123  253:new             #91  <Class StringBuilder>
    //  124  256:dup             
    //  125  257:invokespecial   #124 <Method void StringBuilder()>
    //  126  260:aload_3         
    //  127  261:aload_3         
    //  128  262:arraylength     
    //  129  263:iconst_1        
    //  130  264:isub            
    //  131  265:aaload          
    //  132  266:invokevirtual   #127 <Method StringBuilder StringBuilder.append(Object)>
    //  133  269:ldc1            #131 <String "}">
    //  134  271:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  135  274:ldc1            #101 <String "\n">
    //  136  276:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  137  279:invokevirtual   #106 <Method String StringBuilder.toString()>
    //  138  282:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  139  285:pop             
        text.append("@matrix\n");
    //  140  286:aload_1         
    //  141  287:ldc1            #133 <String "@matrix\n">
    //  142  289:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  143  292:pop             
        for(int i = 0; i < AssignmentMatrix.getRowDimension(); i++)
    //* 144  293:iconst_0        
    //* 145  294:istore          4
    //* 146  296:goto            400
        {
            for(int j = 0; j < AssignmentMatrix.getColumnDimension() - 1; j++)
    //* 147  299:iconst_0        
    //* 148  300:istore          5
    //* 149  302:goto            342
                text.append((new StringBuilder(String.valueOf(AssignmentMatrix.get(i, j)))).append(",").toString());
    //  150  305:aload_1         
    //  151  306:new             #91  <Class StringBuilder>
    //  152  309:dup             
    //  153  310:aload_0         
    //  154  311:getfield        #55  <Field Matrix AssignmentMatrix>
    //  155  314:iload           4
    //  156  316:iload           5
    //  157  318:invokevirtual   #137 <Method byte Matrix.get(int, int)>
    //  158  321:invokestatic    #140 <Method String String.valueOf(int)>
    //  159  324:invokespecial   #99  <Method void StringBuilder(String)>
    //  160  327:ldc1            #129 <String ",">
    //  161  329:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  162  332:invokevirtual   #106 <Method String StringBuilder.toString()>
    //  163  335:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  164  338:pop             

    //  165  339:iinc            5  1
    //  166  342:iload           5
    //  167  344:aload_0         
    //  168  345:getfield        #55  <Field Matrix AssignmentMatrix>
    //  169  348:invokevirtual   #144 <Method int Matrix.getColumnDimension()>
    //  170  351:iconst_1        
    //  171  352:isub            
    //  172  353:icmplt          305
            text.append((new StringBuilder(String.valueOf(AssignmentMatrix.get(i, AssignmentMatrix.getColumnDimension() - 1)))).append("\n").toString());
    //  173  356:aload_1         
    //  174  357:new             #91  <Class StringBuilder>
    //  175  360:dup             
    //  176  361:aload_0         
    //  177  362:getfield        #55  <Field Matrix AssignmentMatrix>
    //  178  365:iload           4
    //  179  367:aload_0         
    //  180  368:getfield        #55  <Field Matrix AssignmentMatrix>
    //  181  371:invokevirtual   #144 <Method int Matrix.getColumnDimension()>
    //  182  374:iconst_1        
    //  183  375:isub            
    //  184  376:invokevirtual   #137 <Method byte Matrix.get(int, int)>
    //  185  379:invokestatic    #140 <Method String String.valueOf(int)>
    //  186  382:invokespecial   #99  <Method void StringBuilder(String)>
    //  187  385:ldc1            #101 <String "\n">
    //  188  387:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  189  390:invokevirtual   #106 <Method String StringBuilder.toString()>
    //  190  393:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  191  396:pop             
        }

    //  192  397:iinc            4  1
    //  193  400:iload           4
    //  194  402:aload_0         
    //  195  403:getfield        #55  <Field Matrix AssignmentMatrix>
    //  196  406:invokevirtual   #147 <Method int Matrix.getRowDimension()>
    //  197  409:icmplt          299
        if(DimensionX.getDimensionInstances() != null)
    //* 198  412:aload_0         
    //* 199  413:getfield        #33  <Field Dimension DimensionX>
    //* 200  416:invokevirtual   #151 <Method Instances Dimension.getDimensionInstances()>
    //* 201  419:ifnull          457
            text.append((new StringBuilder("\n")).append(DimensionX.getDimensionInstances().toString()).append("\n\n").toString());
    //  202  422:aload_1         
    //  203  423:new             #91  <Class StringBuilder>
    //  204  426:dup             
    //  205  427:ldc1            #101 <String "\n">
    //  206  429:invokespecial   #99  <Method void StringBuilder(String)>
    //  207  432:aload_0         
    //  208  433:getfield        #33  <Field Dimension DimensionX>
    //  209  436:invokevirtual   #151 <Method Instances Dimension.getDimensionInstances()>
    //  210  439:invokevirtual   #154 <Method String Instances.toString()>
    //  211  442:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  212  445:ldc1            #156 <String "\n\n">
    //  213  447:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  214  450:invokevirtual   #106 <Method String StringBuilder.toString()>
    //  215  453:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  216  456:pop             
        if(DimensionY.getDimensionInstances() != null)
    //* 217  457:aload_0         
    //* 218  458:getfield        #38  <Field Dimension DimensionY>
    //* 219  461:invokevirtual   #151 <Method Instances Dimension.getDimensionInstances()>
    //* 220  464:ifnull          502
            text.append((new StringBuilder("\n")).append(DimensionY.getDimensionInstances().toString()).append("\n\n").toString());
    //  221  467:aload_1         
    //  222  468:new             #91  <Class StringBuilder>
    //  223  471:dup             
    //  224  472:ldc1            #101 <String "\n">
    //  225  474:invokespecial   #99  <Method void StringBuilder(String)>
    //  226  477:aload_0         
    //  227  478:getfield        #38  <Field Dimension DimensionY>
    //  228  481:invokevirtual   #151 <Method Instances Dimension.getDimensionInstances()>
    //  229  484:invokevirtual   #154 <Method String Instances.toString()>
    //  230  487:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  231  490:ldc1            #156 <String "\n\n">
    //  232  492:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //  233  495:invokevirtual   #106 <Method String StringBuilder.toString()>
    //  234  498:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //  235  501:pop             
        return text.toString();
    //  236  502:aload_1         
    //  237  503:invokevirtual   #157 <Method String StringBuffer.toString()>
    //  238  506:areturn         
    }

    public String toObjectAtrribute()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #82  <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #83  <Method void StringBuffer()>
    //    3    7:astore_1        
        Object dx[] = DimensionX.getDimensionAttribute().toArray();
    //    4    8:aload_0         
    //    5    9:getfield        #33  <Field Dimension DimensionX>
    //    6   12:invokevirtual   #117 <Method Attribute Dimension.getDimensionAttribute()>
    //    7   15:invokevirtual   #123 <Method Object[] Attribute.toArray()>
    //    8   18:astore_2        
        Object dy[] = DimensionY.getDimensionAttribute().toArray();
    //    9   19:aload_0         
    //   10   20:getfield        #38  <Field Dimension DimensionY>
    //   11   23:invokevirtual   #117 <Method Attribute Dimension.getDimensionAttribute()>
    //   12   26:invokevirtual   #123 <Method Object[] Attribute.toArray()>
    //   13   29:astore_3        
        boolean flag = false;
    //   14   30:iconst_0        
    //   15   31:istore          4
        for(int i = 0; i < AssignmentMatrix.getRowDimension(); i++)
    //*  16   33:iconst_0        
    //*  17   34:istore          5
    //*  18   36:goto            163
        {
            text.append((new StringBuilder()).append(dx[i]).append(" [").toString());
    //   19   39:aload_1         
    //   20   40:new             #91  <Class StringBuilder>
    //   21   43:dup             
    //   22   44:invokespecial   #124 <Method void StringBuilder()>
    //   23   47:aload_2         
    //   24   48:iload           5
    //   25   50:aaload          
    //   26   51:invokevirtual   #127 <Method StringBuilder StringBuilder.append(Object)>
    //   27   54:ldc1            #168 <String " [">
    //   28   56:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   29   59:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   30   62:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   31   65:pop             
            flag = false;
    //   32   66:iconst_0        
    //   33   67:istore          4
            for(int j = 0; j < AssignmentMatrix.getColumnDimension() - 1; j++)
    //*  34   69:iconst_0        
    //*  35   70:istore          6
    //*  36   72:goto            123
                if(AssignmentMatrix.get(i, j) == 1)
    //*  37   75:aload_0         
    //*  38   76:getfield        #55  <Field Matrix AssignmentMatrix>
    //*  39   79:iload           5
    //*  40   81:iload           6
    //*  41   83:invokevirtual   #137 <Method byte Matrix.get(int, int)>
    //*  42   86:iconst_1        
    //*  43   87:icmpne          120
                {
                    text.append((new StringBuilder()).append(dy[j]).append(",").toString());
    //   44   90:aload_1         
    //   45   91:new             #91  <Class StringBuilder>
    //   46   94:dup             
    //   47   95:invokespecial   #124 <Method void StringBuilder()>
    //   48   98:aload_3         
    //   49   99:iload           6
    //   50  101:aaload          
    //   51  102:invokevirtual   #127 <Method StringBuilder StringBuilder.append(Object)>
    //   52  105:ldc1            #129 <String ",">
    //   53  107:invokevirtual   #104 <Method StringBuilder StringBuilder.append(String)>
    //   54  110:invokevirtual   #106 <Method String StringBuilder.toString()>
    //   55  113:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   56  116:pop             
                    flag = true;
    //   57  117:iconst_1        
    //   58  118:istore          4
                }

    //   59  120:iinc            6  1
    //   60  123:iload           6
    //   61  125:aload_0         
    //   62  126:getfield        #55  <Field Matrix AssignmentMatrix>
    //   63  129:invokevirtual   #144 <Method int Matrix.getColumnDimension()>
    //   64  132:iconst_1        
    //   65  133:isub            
    //   66  134:icmplt          75
            if(flag)
    //*  67  137:iload           4
    //*  68  139:ifeq            153
                text.deleteCharAt(text.length() - 1);
    //   69  142:aload_1         
    //   70  143:aload_1         
    //   71  144:invokevirtual   #171 <Method int StringBuffer.length()>
    //   72  147:iconst_1        
    //   73  148:isub            
    //   74  149:invokevirtual   #175 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //   75  152:pop             
            text.append("]\n");
    //   76  153:aload_1         
    //   77  154:ldc1            #177 <String "]\n">
    //   78  156:invokevirtual   #87  <Method StringBuffer StringBuffer.append(String)>
    //   79  159:pop             
        }

    //   80  160:iinc            5  1
    //   81  163:iload           5
    //   82  165:aload_0         
    //   83  166:getfield        #55  <Field Matrix AssignmentMatrix>
    //   84  169:invokevirtual   #147 <Method int Matrix.getRowDimension()>
    //   85  172:icmplt          39
        return text.toString();
    //   86  175:aload_1         
    //   87  176:invokevirtual   #157 <Method String StringBuffer.toString()>
    //   88  179:areturn         
    }

    public static final String FILE_EXTENSION = ".ass";
    public static final String ASS_ASSIGNMENT = "@assignment";
    public static final String ASS_MATRIX = "@matrix";
    protected String m_AssignementName;
    protected Dimension DimensionX;
    protected Dimension DimensionY;
    protected Matrix AssignmentMatrix;
}

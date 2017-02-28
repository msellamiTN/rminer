// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   YeHRMiner.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;
import rm.rolemining.lattice.Concept;
import rm.rolemining.lattice.ConceptSet;
import rm.rolemining.lattice.Context;
import rm.rolemining.lattice.IntegerSet;
import rm.rolemining.lattice.ReducedLattices;

public class YeHRMiner extends ReducedLattices
    implements OptionHandler
{
    public class HWSC
        implements Serializable
    {

        public HWSC copy()
        {
            HWSC wsc = new HWSC();
        //    0    0:new             #2   <Class YeHRMiner$HWSC>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #18  <Field YeHRMiner this$0>
        //    4    8:invokespecial   #29  <Method void YeHRMiner$HWSC(YeHRMiner)>
        //    5   11:astore_1        
            wsc.edges = edges;
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #31  <Field int edges>
        //    9   17:putfield        #31  <Field int edges>
            wsc.loss = loss;
        //   10   20:aload_1         
        //   11   21:aload_0         
        //   12   22:getfield        #33  <Field int loss>
        //   13   25:putfield        #33  <Field int loss>
            wsc.R = R;
        //   14   28:aload_1         
        //   15   29:aload_0         
        //   16   30:getfield        #35  <Field int R>
        //   17   33:putfield        #35  <Field int R>
            wsc.value = value;
        //   18   36:aload_1         
        //   19   37:aload_0         
        //   20   38:getfield        #37  <Field int value>
        //   21   41:putfield        #37  <Field int value>
            return wsc;
        //   22   44:aload_1         
        //   23   45:areturn         
        }

        public int getEdges()
        {
            return edges;
        //    0    0:aload_0         
        //    1    1:getfield        #31  <Field int edges>
        //    2    4:ireturn         
        }

        public void setEdges(int edges)
        {
            this.edges = edges;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #31  <Field int edges>
        //    3    5:return          
        }

        public int getLoss()
        {
            return loss;
        //    0    0:aload_0         
        //    1    1:getfield        #33  <Field int loss>
        //    2    4:ireturn         
        }

        public void setLoss(int loss)
        {
            this.loss = loss;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #33  <Field int loss>
        //    3    5:return          
        }

        public int getR()
        {
            return R;
        //    0    0:aload_0         
        //    1    1:getfield        #35  <Field int R>
        //    2    4:ireturn         
        }

        public void setR(int r)
        {
            R = r;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #35  <Field int R>
        //    3    5:return          
        }

        public int getValue()
        {
            return value;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field int value>
        //    2    4:ireturn         
        }

        public void setValue(int value)
        {
            this.value = value;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #37  <Field int value>
        //    3    5:return          
        }

        int R;
        int edges;
        int value;
        int loss;
        final YeHRMiner this$0;

        public HWSC()
        {
            this$0 = YeHRMiner.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field YeHRMiner this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }

    public class con2RoleIndex
    {

        double con;
        int indexRole;
        final YeHRMiner this$0;

        public con2RoleIndex()
        {
            this$0 = YeHRMiner.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #15  <Field YeHRMiner this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #18  <Method void Object()>
        //    5    9:return          
        }
    }


    public YeHRMiner()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #56  <Method void ReducedLattices()>
        log = new StringBuffer();
    //    2    4:aload_0         
    //    3    5:new             #58  <Class StringBuffer>
    //    4    8:dup             
    //    5    9:invokespecial   #59  <Method void StringBuffer()>
    //    6   12:putfield        #61  <Field StringBuffer log>
        beforewsc = new HWSC();
    //    7   15:aload_0         
    //    8   16:new             #63  <Class YeHRMiner$HWSC>
    //    9   19:dup             
    //   10   20:aload_0         
    //   11   21:invokespecial   #66  <Method void YeHRMiner$HWSC(YeHRMiner)>
    //   12   24:putfield        #68  <Field YeHRMiner$HWSC beforewsc>
        afterwsc = new HWSC();
    //   13   27:aload_0         
    //   14   28:new             #63  <Class YeHRMiner$HWSC>
    //   15   31:dup             
    //   16   32:aload_0         
    //   17   33:invokespecial   #66  <Method void YeHRMiner$HWSC(YeHRMiner)>
    //   18   36:putfield        #70  <Field YeHRMiner$HWSC afterwsc>
        useVec = new Vector();
    //   19   39:aload_0         
    //   20   40:new             #72  <Class Vector>
    //   21   43:dup             
    //   22   44:invokespecial   #73  <Method void Vector()>
    //   23   47:putfield        #75  <Field Vector useVec>
        perVec = new Vector();
    //   24   50:aload_0         
    //   25   51:new             #72  <Class Vector>
    //   26   54:dup             
    //   27   55:invokespecial   #73  <Method void Vector()>
    //   28   58:putfield        #77  <Field Vector perVec>
        resetOptions();
    //   29   61:aload_0         
    //   30   62:invokevirtual   #80  <Method void resetOptions()>
    //   31   65:return          
    }

    private Vector splitString(String curPer, String split, Vector perVec2)
    {
        Vector idVec = new Vector();
    //    0    0:new             #72  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #73  <Method void Vector()>
    //    3    7:astore          4
        String pers[] = curPer.split(split);
    //    4    9:aload_1         
    //    5   10:aload_2         
    //    6   11:invokevirtual   #91  <Method String[] String.split(String)>
    //    7   14:astore          5
        for(int index = 0; index < pers.length; index++)
    //*   8   16:iconst_0        
    //*   9   17:istore          6
    //*  10   19:goto            93
        {
            String per = pers[index];
    //   11   22:aload           5
    //   12   24:iload           6
    //   13   26:aaload          
    //   14   27:astore          7
            int id = 0;
    //   15   29:iconst_0        
    //   16   30:istore          8
            for(Iterator iterator = perVec2.iterator(); iterator.hasNext(); id++)
    //*  17   32:aload_3         
    //*  18   33:invokevirtual   #95  <Method Iterator Vector.iterator()>
    //*  19   36:astore          10
    //*  20   38:goto            80
            {
                String sstr = (String)iterator.next();
    //   21   41:aload           10
    //   22   43:invokeinterface #101 <Method Object Iterator.next()>
    //   23   48:checkcast       #87  <Class String>
    //   24   51:astore          9
                if(!sstr.equals(per))
                    continue;
    //   25   53:aload           9
    //   26   55:aload           7
    //   27   57:invokevirtual   #105 <Method boolean String.equals(Object)>
    //   28   60:ifeq            77
                idVec.add(Integer.valueOf(id));
    //   29   63:aload           4
    //   30   65:iload           8
    //   31   67:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   32   70:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //   33   73:pop             
                break;
    //   34   74:goto            90
            }

    //   35   77:iinc            8  1
    //   36   80:aload           10
    //   37   82:invokeinterface #118 <Method boolean Iterator.hasNext()>
    //   38   87:ifne            41
        }

    //   39   90:iinc            6  1
    //   40   93:iload           6
    //   41   95:aload           5
    //   42   97:arraylength     
    //   43   98:icmplt          22
        return idVec;
    //   44  101:aload           4
    //   45  103:areturn         
    }

    private void initMatrix()
    {
        numberOfRoles = nnodes;
    //    0    0:aload_0         
    //    1    1:getfield        #133 <Field int nnodes>
    //    2    4:putstatic       #51  <Field int numberOfRoles>
        userToRole = new Matrix(noUsers, numberOfRoles);
    //    3    7:aload_0         
    //    4    8:new             #135 <Class Matrix>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:getfield        #137 <Field int noUsers>
    //    8   16:getstatic       #51  <Field int numberOfRoles>
    //    9   19:invokespecial   #140 <Method void Matrix(int, int)>
    //   10   22:putfield        #142 <Field Matrix userToRole>
        roleToPermission = new Matrix(numberOfRoles, noPerms);
    //   11   25:aload_0         
    //   12   26:new             #135 <Class Matrix>
    //   13   29:dup             
    //   14   30:getstatic       #51  <Field int numberOfRoles>
    //   15   33:aload_0         
    //   16   34:getfield        #144 <Field int noPerms>
    //   17   37:invokespecial   #140 <Method void Matrix(int, int)>
    //   18   40:putfield        #146 <Field Matrix roleToPermission>
        for(int index = 0; index < allFormalConcepts.getNumberOfConcepts(); index++)
    //*  19   43:iconst_0        
    //*  20   44:istore_1        
    //*  21   45:goto            206
        {
            Concept cpt = allFormalConcepts.getConcept(index);
    //   22   48:aload_0         
    //   23   49:getfield        #150 <Field ConceptSet allFormalConcepts>
    //   24   52:iload_1         
    //   25   53:invokevirtual   #156 <Method Concept ConceptSet.getConcept(int)>
    //   26   56:astore_2        
            String userset = getNameList(formalObjects, cpt.allObjects);
    //   27   57:aload_0         
    //   28   58:aload_0         
    //   29   59:getfield        #158 <Field String[] formalObjects>
    //   30   62:aload_2         
    //   31   63:getfield        #164 <Field IntegerSet Concept.allObjects>
    //   32   66:invokevirtual   #168 <Method String getNameList(String[], IntegerSet)>
    //   33   69:astore_3        
            Vector idOfUser = splitString(userset, ", ", useVec);
    //   34   70:aload_0         
    //   35   71:aload_3         
    //   36   72:ldc1            #170 <String ", ">
    //   37   74:aload_0         
    //   38   75:getfield        #75  <Field Vector useVec>
    //   39   78:invokespecial   #172 <Method Vector splitString(String, String, Vector)>
    //   40   81:astore          4
            int curidOfUser;
            for(Iterator iterator = idOfUser.iterator(); iterator.hasNext(); userToRole.set(curidOfUser, index, (byte)1))
    //*  41   83:aload           4
    //*  42   85:invokevirtual   #95  <Method Iterator Vector.iterator()>
    //*  43   88:astore          6
    //*  44   90:goto            119
                curidOfUser = ((Integer)iterator.next()).intValue();
    //   45   93:aload           6
    //   46   95:invokeinterface #101 <Method Object Iterator.next()>
    //   47  100:checkcast       #107 <Class Integer>
    //   48  103:invokevirtual   #176 <Method int Integer.intValue()>
    //   49  106:istore          5

    //   50  108:aload_0         
    //   51  109:getfield        #142 <Field Matrix userToRole>
    //   52  112:iload           5
    //   53  114:iload_1         
    //   54  115:iconst_1        
    //   55  116:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>
    //   56  119:aload           6
    //   57  121:invokeinterface #118 <Method boolean Iterator.hasNext()>
    //   58  126:ifne            93
            String perset = getNameList(formalAttributes, cpt.allAttributes);
    //   59  129:aload_0         
    //   60  130:aload_0         
    //   61  131:getfield        #182 <Field String[] formalAttributes>
    //   62  134:aload_2         
    //   63  135:getfield        #185 <Field IntegerSet Concept.allAttributes>
    //   64  138:invokevirtual   #168 <Method String getNameList(String[], IntegerSet)>
    //   65  141:astore          5
            Vector idOfPer = splitString(perset, ", ", perVec);
    //   66  143:aload_0         
    //   67  144:aload           5
    //   68  146:ldc1            #170 <String ", ">
    //   69  148:aload_0         
    //   70  149:getfield        #77  <Field Vector perVec>
    //   71  152:invokespecial   #172 <Method Vector splitString(String, String, Vector)>
    //   72  155:astore          6
            int curidOfPer;
            for(Iterator iterator1 = idOfPer.iterator(); iterator1.hasNext(); roleToPermission.set(index, curidOfPer, (byte)1))
    //*  73  157:aload           6
    //*  74  159:invokevirtual   #95  <Method Iterator Vector.iterator()>
    //*  75  162:astore          8
    //*  76  164:goto            193
                curidOfPer = ((Integer)iterator1.next()).intValue();
    //   77  167:aload           8
    //   78  169:invokeinterface #101 <Method Object Iterator.next()>
    //   79  174:checkcast       #107 <Class Integer>
    //   80  177:invokevirtual   #176 <Method int Integer.intValue()>
    //   81  180:istore          7

    //   82  182:aload_0         
    //   83  183:getfield        #146 <Field Matrix roleToPermission>
    //   84  186:iload_1         
    //   85  187:iload           7
    //   86  189:iconst_1        
    //   87  190:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>
    //   88  193:aload           8
    //   89  195:invokeinterface #118 <Method boolean Iterator.hasNext()>
    //   90  200:ifne            167
        }

    //   91  203:iinc            1  1
    //   92  206:iload_1         
    //   93  207:aload_0         
    //   94  208:getfield        #150 <Field ConceptSet allFormalConcepts>
    //   95  211:invokevirtual   #188 <Method int ConceptSet.getNumberOfConcepts()>
    //   96  214:icmplt          48
        log.append("\u521D\u59CB\u7528\u6237-\u89D2\u8272\u77E9\u9635\u4E3A: \n");
    //   97  217:aload_0         
    //   98  218:getfield        #61  <Field StringBuffer log>
    //   99  221:ldc1            #190 <String "\u521D\u59CB\u7528\u6237-\u89D2\u8272\u77E9\u9635\u4E3A: \n">
    //  100  223:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  101  226:pop             
        for(int i = 0; i < noUsers; i++)
    //* 102  227:iconst_0        
    //* 103  228:istore_1        
    //* 104  229:goto            332
        {
            for(int j = 0; j < numberOfRoles; j++)
    //* 105  232:iconst_0        
    //* 106  233:istore_2        
    //* 107  234:goto            322
                if(j != numberOfRoles - 1)
    //* 108  237:iload_2         
    //* 109  238:getstatic       #51  <Field int numberOfRoles>
    //* 110  241:iconst_1        
    //* 111  242:isub            
    //* 112  243:icmpeq          284
                    log.append((new StringBuilder(String.valueOf(userToRole.get(i, j)))).append(",").toString());
    //  113  246:aload_0         
    //  114  247:getfield        #61  <Field StringBuffer log>
    //  115  250:new             #196 <Class StringBuilder>
    //  116  253:dup             
    //  117  254:aload_0         
    //  118  255:getfield        #142 <Field Matrix userToRole>
    //  119  258:iload_1         
    //  120  259:iload_2         
    //  121  260:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  122  263:invokestatic    #203 <Method String String.valueOf(int)>
    //  123  266:invokespecial   #206 <Method void StringBuilder(String)>
    //  124  269:ldc1            #208 <String ",">
    //  125  271:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  126  274:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  127  277:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  128  280:pop             
                else
    //* 129  281:goto            319
                    log.append((new StringBuilder(String.valueOf(userToRole.get(i, j)))).append("\n").toString());
    //  130  284:aload_0         
    //  131  285:getfield        #61  <Field StringBuffer log>
    //  132  288:new             #196 <Class StringBuilder>
    //  133  291:dup             
    //  134  292:aload_0         
    //  135  293:getfield        #142 <Field Matrix userToRole>
    //  136  296:iload_1         
    //  137  297:iload_2         
    //  138  298:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  139  301:invokestatic    #203 <Method String String.valueOf(int)>
    //  140  304:invokespecial   #206 <Method void StringBuilder(String)>
    //  141  307:ldc1            #217 <String "\n">
    //  142  309:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  143  312:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  144  315:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  145  318:pop             

    //  146  319:iinc            2  1
    //  147  322:iload_2         
    //  148  323:getstatic       #51  <Field int numberOfRoles>
    //  149  326:icmplt          237
        }

    //  150  329:iinc            1  1
    //  151  332:iload_1         
    //  152  333:aload_0         
    //  153  334:getfield        #137 <Field int noUsers>
    //  154  337:icmplt          232
        log.append("--------------------------------------\n");
    //  155  340:aload_0         
    //  156  341:getfield        #61  <Field StringBuffer log>
    //  157  344:ldc1            #219 <String "--------------------------------------\n">
    //  158  346:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  159  349:pop             
        log.append("\u521D\u59CB\u89D2\u8272-\u6743\u9650\u77E9\u9635\u4E3A: \n");
    //  160  350:aload_0         
    //  161  351:getfield        #61  <Field StringBuffer log>
    //  162  354:ldc1            #221 <String "\u521D\u59CB\u89D2\u8272-\u6743\u9650\u77E9\u9635\u4E3A: \n">
    //  163  356:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  164  359:pop             
        for(int k = 0; k < numberOfRoles; k++)
    //* 165  360:iconst_0        
    //* 166  361:istore_1        
    //* 167  362:goto            467
        {
            for(int t = 0; t < noPerms; t++)
    //* 168  365:iconst_0        
    //* 169  366:istore_2        
    //* 170  367:goto            456
                if(t != noPerms - 1)
    //* 171  370:iload_2         
    //* 172  371:aload_0         
    //* 173  372:getfield        #144 <Field int noPerms>
    //* 174  375:iconst_1        
    //* 175  376:isub            
    //* 176  377:icmpeq          418
                    log.append((new StringBuilder(String.valueOf(roleToPermission.get(k, t)))).append(",").toString());
    //  177  380:aload_0         
    //  178  381:getfield        #61  <Field StringBuffer log>
    //  179  384:new             #196 <Class StringBuilder>
    //  180  387:dup             
    //  181  388:aload_0         
    //  182  389:getfield        #146 <Field Matrix roleToPermission>
    //  183  392:iload_1         
    //  184  393:iload_2         
    //  185  394:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  186  397:invokestatic    #203 <Method String String.valueOf(int)>
    //  187  400:invokespecial   #206 <Method void StringBuilder(String)>
    //  188  403:ldc1            #208 <String ",">
    //  189  405:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  190  408:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  191  411:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  192  414:pop             
                else
    //* 193  415:goto            453
                    log.append((new StringBuilder(String.valueOf(roleToPermission.get(k, t)))).append("\n").toString());
    //  194  418:aload_0         
    //  195  419:getfield        #61  <Field StringBuffer log>
    //  196  422:new             #196 <Class StringBuilder>
    //  197  425:dup             
    //  198  426:aload_0         
    //  199  427:getfield        #146 <Field Matrix roleToPermission>
    //  200  430:iload_1         
    //  201  431:iload_2         
    //  202  432:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  203  435:invokestatic    #203 <Method String String.valueOf(int)>
    //  204  438:invokespecial   #206 <Method void StringBuilder(String)>
    //  205  441:ldc1            #217 <String "\n">
    //  206  443:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  207  446:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  208  449:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  209  452:pop             

    //  210  453:iinc            2  1
    //  211  456:iload_2         
    //  212  457:aload_0         
    //  213  458:getfield        #144 <Field int noPerms>
    //  214  461:icmplt          370
        }

    //  215  464:iinc            1  1
    //  216  467:iload_1         
    //  217  468:getstatic       #51  <Field int numberOfRoles>
    //  218  471:icmplt          365
        log.append("--------------------------------------\n");
    //  219  474:aload_0         
    //  220  475:getfield        #61  <Field StringBuffer log>
    //  221  478:ldc1            #219 <String "--------------------------------------\n">
    //  222  480:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  223  483:pop             
        calculatEdges(userToRole, roleToPermission, new Matrix(10, 10), beforewsc);
    //  224  484:aload_0         
    //  225  485:aload_0         
    //  226  486:getfield        #142 <Field Matrix userToRole>
    //  227  489:aload_0         
    //  228  490:getfield        #146 <Field Matrix roleToPermission>
    //  229  493:new             #135 <Class Matrix>
    //  230  496:dup             
    //  231  497:bipush          10
    //  232  499:bipush          10
    //  233  501:invokespecial   #140 <Method void Matrix(int, int)>
    //  234  504:aload_0         
    //  235  505:getfield        #68  <Field YeHRMiner$HWSC beforewsc>
    //  236  508:invokespecial   #225 <Method void calculatEdges(Matrix, Matrix, Matrix, YeHRMiner$HWSC)>
        beforewsc.R = userToRole.getColumnDimension();
    //  237  511:aload_0         
    //  238  512:getfield        #68  <Field YeHRMiner$HWSC beforewsc>
    //  239  515:aload_0         
    //  240  516:getfield        #142 <Field Matrix userToRole>
    //  241  519:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  242  522:putfield        #231 <Field int YeHRMiner$HWSC.R>
        calculateWSC(beforewsc);
    //  243  525:aload_0         
    //  244  526:aload_0         
    //  245  527:getfield        #68  <Field YeHRMiner$HWSC beforewsc>
    //  246  530:invokespecial   #235 <Method void calculateWSC(YeHRMiner$HWSC)>
    //  247  533:return          
    }

    private void calculateWSC(HWSC wsc2)
    {
        wsc2.value = (wsc2.R + wsc2.edges) - 100 * wsc2.loss;
    //    0    0:aload_1         
    //    1    1:aload_1         
    //    2    2:getfield        #231 <Field int YeHRMiner$HWSC.R>
    //    3    5:aload_1         
    //    4    6:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //    5    9:iadd            
    //    6   10:bipush          100
    //    7   12:aload_1         
    //    8   13:getfield        #253 <Field int YeHRMiner$HWSC.loss>
    //    9   16:imul            
    //   10   17:isub            
    //   11   18:putfield        #256 <Field int YeHRMiner$HWSC.value>
    //   12   21:return          
    }

    private void calculatEdges(Matrix userToRole2, Matrix roleToPermission2, Matrix hroleToRole2, HWSC wsc2)
    {
        wsc2.edges = 0;
    //    0    0:aload           4
    //    1    2:iconst_0        
    //    2    3:putfield        #250 <Field int YeHRMiner$HWSC.edges>
        for(int index = 0; index < userToRole2.getRowDimension(); index++)
    //*   3    6:iconst_0        
    //*   4    7:istore          5
    //*   5    9:goto            56
        {
            for(int jndex = 0; jndex < userToRole2.getColumnDimension(); jndex++)
    //*   6   12:iconst_0        
    //*   7   13:istore          6
    //*   8   15:goto            44
                if(userToRole2.get(index, jndex) == 1)
    //*   9   18:aload_1         
    //*  10   19:iload           5
    //*  11   21:iload           6
    //*  12   23:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  13   26:iconst_1        
    //*  14   27:icmpne          41
                    wsc2.edges++;
    //   15   30:aload           4
    //   16   32:dup             
    //   17   33:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //   18   36:iconst_1        
    //   19   37:iadd            
    //   20   38:putfield        #250 <Field int YeHRMiner$HWSC.edges>

    //   21   41:iinc            6  1
    //   22   44:iload           6
    //   23   46:aload_1         
    //   24   47:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   25   50:icmplt          18
        }

    //   26   53:iinc            5  1
    //   27   56:iload           5
    //   28   58:aload_1         
    //   29   59:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   30   62:icmplt          12
        for(int i = 0; i < roleToPermission2.getRowDimension(); i++)
    //*  31   65:iconst_0        
    //*  32   66:istore          5
    //*  33   68:goto            115
        {
            for(int j = 0; j < roleToPermission2.getColumnDimension(); j++)
    //*  34   71:iconst_0        
    //*  35   72:istore          6
    //*  36   74:goto            103
                if(roleToPermission2.get(i, j) == 1)
    //*  37   77:aload_2         
    //*  38   78:iload           5
    //*  39   80:iload           6
    //*  40   82:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  41   85:iconst_1        
    //*  42   86:icmpne          100
                    wsc2.edges++;
    //   43   89:aload           4
    //   44   91:dup             
    //   45   92:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //   46   95:iconst_1        
    //   47   96:iadd            
    //   48   97:putfield        #250 <Field int YeHRMiner$HWSC.edges>

    //   49  100:iinc            6  1
    //   50  103:iload           6
    //   51  105:aload_2         
    //   52  106:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   53  109:icmplt          77
        }

    //   54  112:iinc            5  1
    //   55  115:iload           5
    //   56  117:aload_2         
    //   57  118:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   58  121:icmplt          71
        for(int i = 0; i < hroleToRole2.getRowDimension(); i++)
    //*  59  124:iconst_0        
    //*  60  125:istore          5
    //*  61  127:goto            174
        {
            for(int j = 0; j < hroleToRole2.getColumnDimension(); j++)
    //*  62  130:iconst_0        
    //*  63  131:istore          6
    //*  64  133:goto            162
                if(hroleToRole2.get(i, j) == 1)
    //*  65  136:aload_3         
    //*  66  137:iload           5
    //*  67  139:iload           6
    //*  68  141:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  69  144:iconst_1        
    //*  70  145:icmpne          159
                    wsc2.edges++;
    //   71  148:aload           4
    //   72  150:dup             
    //   73  151:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //   74  154:iconst_1        
    //   75  155:iadd            
    //   76  156:putfield        #250 <Field int YeHRMiner$HWSC.edges>

    //   77  159:iinc            6  1
    //   78  162:iload           6
    //   79  164:aload_3         
    //   80  165:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   81  168:icmplt          136
        }

    //   82  171:iinc            5  1
    //   83  174:iload           5
    //   84  176:aload_3         
    //   85  177:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   86  180:icmplt          130
    //   87  183:return          
    }

    private void cloneMatrix()
    {
        if(tempuserToRole != null && temproleToPermission != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #267 <Field Matrix tempuserToRole>
    //*   2    4:ifnull          24
    //*   3    7:aload_0         
    //*   4    8:getfield        #269 <Field Matrix temproleToPermission>
    //*   5   11:ifnull          24
        {
            tempuserToRole = null;
    //    6   14:aload_0         
    //    7   15:aconst_null     
    //    8   16:putfield        #267 <Field Matrix tempuserToRole>
            temproleToPermission = null;
    //    9   19:aload_0         
    //   10   20:aconst_null     
    //   11   21:putfield        #269 <Field Matrix temproleToPermission>
        }
        tempuserToRole = new Matrix(userToRole.getRowDimension(), userToRole.getColumnDimension());
    //   12   24:aload_0         
    //   13   25:new             #135 <Class Matrix>
    //   14   28:dup             
    //   15   29:aload_0         
    //   16   30:getfield        #142 <Field Matrix userToRole>
    //   17   33:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   18   36:aload_0         
    //   19   37:getfield        #142 <Field Matrix userToRole>
    //   20   40:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   21   43:invokespecial   #140 <Method void Matrix(int, int)>
    //   22   46:putfield        #267 <Field Matrix tempuserToRole>
        temproleToPermission = new Matrix(roleToPermission.getRowDimension(), roleToPermission.getColumnDimension());
    //   23   49:aload_0         
    //   24   50:new             #135 <Class Matrix>
    //   25   53:dup             
    //   26   54:aload_0         
    //   27   55:getfield        #146 <Field Matrix roleToPermission>
    //   28   58:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   29   61:aload_0         
    //   30   62:getfield        #146 <Field Matrix roleToPermission>
    //   31   65:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   32   68:invokespecial   #140 <Method void Matrix(int, int)>
    //   33   71:putfield        #269 <Field Matrix temproleToPermission>
        htempuserToRole = new Matrix(huserToRole.getRowDimension(), huserToRole.getColumnDimension());
    //   34   74:aload_0         
    //   35   75:new             #135 <Class Matrix>
    //   36   78:dup             
    //   37   79:aload_0         
    //   38   80:getfield        #271 <Field Matrix huserToRole>
    //   39   83:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   40   86:aload_0         
    //   41   87:getfield        #271 <Field Matrix huserToRole>
    //   42   90:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   43   93:invokespecial   #140 <Method void Matrix(int, int)>
    //   44   96:putfield        #273 <Field Matrix htempuserToRole>
        htemproleToPermission = new Matrix(hroleToPermission.getRowDimension(), hroleToPermission.getColumnDimension());
    //   45   99:aload_0         
    //   46  100:new             #135 <Class Matrix>
    //   47  103:dup             
    //   48  104:aload_0         
    //   49  105:getfield        #275 <Field Matrix hroleToPermission>
    //   50  108:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   51  111:aload_0         
    //   52  112:getfield        #275 <Field Matrix hroleToPermission>
    //   53  115:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   54  118:invokespecial   #140 <Method void Matrix(int, int)>
    //   55  121:putfield        #277 <Field Matrix htemproleToPermission>
        htemproleToRole = new Matrix(hroleToRole.getRowDimension(), hroleToRole.getColumnDimension());
    //   56  124:aload_0         
    //   57  125:new             #135 <Class Matrix>
    //   58  128:dup             
    //   59  129:aload_0         
    //   60  130:getfield        #279 <Field Matrix hroleToRole>
    //   61  133:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   62  136:aload_0         
    //   63  137:getfield        #279 <Field Matrix hroleToRole>
    //   64  140:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   65  143:invokespecial   #140 <Method void Matrix(int, int)>
    //   66  146:putfield        #281 <Field Matrix htemproleToRole>
        for(int index = 0; index < userToRole.getRowDimension(); index++)
    //*  67  149:iconst_0        
    //*  68  150:istore_1        
    //*  69  151:goto            194
        {
            for(int jndex = 0; jndex < userToRole.getColumnDimension(); jndex++)
    //*  70  154:iconst_0        
    //*  71  155:istore_2        
    //*  72  156:goto            180
                tempuserToRole.set(index, jndex, userToRole.get(index, jndex));
    //   73  159:aload_0         
    //   74  160:getfield        #267 <Field Matrix tempuserToRole>
    //   75  163:iload_1         
    //   76  164:iload_2         
    //   77  165:aload_0         
    //   78  166:getfield        #142 <Field Matrix userToRole>
    //   79  169:iload_1         
    //   80  170:iload_2         
    //   81  171:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   82  174:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   83  177:iinc            2  1
    //   84  180:iload_2         
    //   85  181:aload_0         
    //   86  182:getfield        #142 <Field Matrix userToRole>
    //   87  185:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   88  188:icmplt          159
        }

    //   89  191:iinc            1  1
    //   90  194:iload_1         
    //   91  195:aload_0         
    //   92  196:getfield        #142 <Field Matrix userToRole>
    //   93  199:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   94  202:icmplt          154
        for(int i = 0; i < roleToPermission.getRowDimension(); i++)
    //*  95  205:iconst_0        
    //*  96  206:istore_1        
    //*  97  207:goto            250
        {
            for(int j = 0; j < roleToPermission.getColumnDimension(); j++)
    //*  98  210:iconst_0        
    //*  99  211:istore_2        
    //* 100  212:goto            236
                temproleToPermission.set(i, j, roleToPermission.get(i, j));
    //  101  215:aload_0         
    //  102  216:getfield        #269 <Field Matrix temproleToPermission>
    //  103  219:iload_1         
    //  104  220:iload_2         
    //  105  221:aload_0         
    //  106  222:getfield        #146 <Field Matrix roleToPermission>
    //  107  225:iload_1         
    //  108  226:iload_2         
    //  109  227:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  110  230:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  111  233:iinc            2  1
    //  112  236:iload_2         
    //  113  237:aload_0         
    //  114  238:getfield        #146 <Field Matrix roleToPermission>
    //  115  241:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  116  244:icmplt          215
        }

    //  117  247:iinc            1  1
    //  118  250:iload_1         
    //  119  251:aload_0         
    //  120  252:getfield        #146 <Field Matrix roleToPermission>
    //  121  255:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  122  258:icmplt          210
        for(int index = 0; index < huserToRole.getRowDimension(); index++)
    //* 123  261:iconst_0        
    //* 124  262:istore_1        
    //* 125  263:goto            306
        {
            for(int jndex = 0; jndex < huserToRole.getColumnDimension(); jndex++)
    //* 126  266:iconst_0        
    //* 127  267:istore_2        
    //* 128  268:goto            292
                htempuserToRole.set(index, jndex, huserToRole.get(index, jndex));
    //  129  271:aload_0         
    //  130  272:getfield        #273 <Field Matrix htempuserToRole>
    //  131  275:iload_1         
    //  132  276:iload_2         
    //  133  277:aload_0         
    //  134  278:getfield        #271 <Field Matrix huserToRole>
    //  135  281:iload_1         
    //  136  282:iload_2         
    //  137  283:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  138  286:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  139  289:iinc            2  1
    //  140  292:iload_2         
    //  141  293:aload_0         
    //  142  294:getfield        #271 <Field Matrix huserToRole>
    //  143  297:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  144  300:icmplt          271
        }

    //  145  303:iinc            1  1
    //  146  306:iload_1         
    //  147  307:aload_0         
    //  148  308:getfield        #271 <Field Matrix huserToRole>
    //  149  311:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  150  314:icmplt          266
        for(int i = 0; i < hroleToRole.getRowDimension(); i++)
    //* 151  317:iconst_0        
    //* 152  318:istore_1        
    //* 153  319:goto            362
        {
            for(int j = 0; j < hroleToRole.getColumnDimension(); j++)
    //* 154  322:iconst_0        
    //* 155  323:istore_2        
    //* 156  324:goto            348
                htemproleToRole.set(i, j, hroleToRole.get(i, j));
    //  157  327:aload_0         
    //  158  328:getfield        #281 <Field Matrix htemproleToRole>
    //  159  331:iload_1         
    //  160  332:iload_2         
    //  161  333:aload_0         
    //  162  334:getfield        #279 <Field Matrix hroleToRole>
    //  163  337:iload_1         
    //  164  338:iload_2         
    //  165  339:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  166  342:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  167  345:iinc            2  1
    //  168  348:iload_2         
    //  169  349:aload_0         
    //  170  350:getfield        #279 <Field Matrix hroleToRole>
    //  171  353:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  172  356:icmplt          327
        }

    //  173  359:iinc            1  1
    //  174  362:iload_1         
    //  175  363:aload_0         
    //  176  364:getfield        #279 <Field Matrix hroleToRole>
    //  177  367:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  178  370:icmplt          322
        for(int i = 0; i < hroleToPermission.getRowDimension(); i++)
    //* 179  373:iconst_0        
    //* 180  374:istore_1        
    //* 181  375:goto            418
        {
            for(int j = 0; j < hroleToPermission.getColumnDimension(); j++)
    //* 182  378:iconst_0        
    //* 183  379:istore_2        
    //* 184  380:goto            404
                htemproleToPermission.set(i, j, hroleToPermission.get(i, j));
    //  185  383:aload_0         
    //  186  384:getfield        #277 <Field Matrix htemproleToPermission>
    //  187  387:iload_1         
    //  188  388:iload_2         
    //  189  389:aload_0         
    //  190  390:getfield        #275 <Field Matrix hroleToPermission>
    //  191  393:iload_1         
    //  192  394:iload_2         
    //  193  395:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  194  398:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  195  401:iinc            2  1
    //  196  404:iload_2         
    //  197  405:aload_0         
    //  198  406:getfield        #275 <Field Matrix hroleToPermission>
    //  199  409:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  200  412:icmplt          383
        }

    //  201  415:iinc            1  1
    //  202  418:iload_1         
    //  203  419:aload_0         
    //  204  420:getfield        #275 <Field Matrix hroleToPermission>
    //  205  423:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  206  426:icmplt          378
    //  207  429:return          
    }

    private void resetRowAndCol(int index)
    {
        for(int i = 0; i < tempuserToRole.getRowDimension(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            18
            tempuserToRole.set(i, index, (byte)0);
    //    3    5:aload_0         
    //    4    6:getfield        #267 <Field Matrix tempuserToRole>
    //    5    9:iload_2         
    //    6   10:iload_1         
    //    7   11:iconst_0        
    //    8   12:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //    9   15:iinc            2  1
    //   10   18:iload_2         
    //   11   19:aload_0         
    //   12   20:getfield        #267 <Field Matrix tempuserToRole>
    //   13   23:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   14   26:icmplt          5
        for(int j = 0; j < temproleToPermission.getColumnDimension(); j++)
    //*  15   29:iconst_0        
    //*  16   30:istore_2        
    //*  17   31:goto            47
            temproleToPermission.set(index, j, (byte)0);
    //   18   34:aload_0         
    //   19   35:getfield        #269 <Field Matrix temproleToPermission>
    //   20   38:iload_1         
    //   21   39:iload_2         
    //   22   40:iconst_0        
    //   23   41:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   24   44:iinc            2  1
    //   25   47:iload_2         
    //   26   48:aload_0         
    //   27   49:getfield        #269 <Field Matrix temproleToPermission>
    //   28   52:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   29   55:icmplt          34
    //   30   58:return          
    }

    private void multiplicationOfMatrix()
    {
        if(tempUPA != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #286 <Field Matrix tempUPA>
    //*   2    4:ifnull          12
            tempUPA = null;
    //    3    7:aload_0         
    //    4    8:aconst_null     
    //    5    9:putfield        #286 <Field Matrix tempUPA>
        tempUPA = new Matrix(tempuserToRole.getRowDimension(), temproleToPermission.getColumnDimension());
    //    6   12:aload_0         
    //    7   13:new             #135 <Class Matrix>
    //    8   16:dup             
    //    9   17:aload_0         
    //   10   18:getfield        #267 <Field Matrix tempuserToRole>
    //   11   21:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   12   24:aload_0         
    //   13   25:getfield        #269 <Field Matrix temproleToPermission>
    //   14   28:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   15   31:invokespecial   #140 <Method void Matrix(int, int)>
    //   16   34:putfield        #286 <Field Matrix tempUPA>
        for(int i = 0; i < tempuserToRole.getRowDimension(); i++)
    //*  17   37:iconst_0        
    //*  18   38:istore_1        
    //*  19   39:goto            127
        {
            for(int j = 0; j < temproleToPermission.getColumnDimension(); j++)
    //*  20   42:iconst_0        
    //*  21   43:istore_2        
    //*  22   44:goto            113
            {
                byte value = 0;
    //   23   47:iconst_0        
    //   24   48:istore_3        
                for(int k = 0; k < tempuserToRole.getColumnDimension(); k++)
    //*  25   49:iconst_0        
    //*  26   50:istore          4
    //*  27   52:goto            88
                {
                    byte member = (byte)(tempuserToRole.get(i, k) & temproleToPermission.get(k, j));
    //   28   55:aload_0         
    //   29   56:getfield        #267 <Field Matrix tempuserToRole>
    //   30   59:iload_1         
    //   31   60:iload           4
    //   32   62:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   33   65:aload_0         
    //   34   66:getfield        #269 <Field Matrix temproleToPermission>
    //   35   69:iload           4
    //   36   71:iload_2         
    //   37   72:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   38   75:iand            
    //   39   76:int2byte        
    //   40   77:istore          5
                    value |= member;
    //   41   79:iload_3         
    //   42   80:iload           5
    //   43   82:ior             
    //   44   83:int2byte        
    //   45   84:istore_3        
                }

    //   46   85:iinc            4  1
    //   47   88:iload           4
    //   48   90:aload_0         
    //   49   91:getfield        #267 <Field Matrix tempuserToRole>
    //   50   94:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   51   97:icmplt          55
                tempUPA.set(i, j, value);
    //   52  100:aload_0         
    //   53  101:getfield        #286 <Field Matrix tempUPA>
    //   54  104:iload_1         
    //   55  105:iload_2         
    //   56  106:iload_3         
    //   57  107:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>
            }

    //   58  110:iinc            2  1
    //   59  113:iload_2         
    //   60  114:aload_0         
    //   61  115:getfield        #269 <Field Matrix temproleToPermission>
    //   62  118:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   63  121:icmplt          47
        }

    //   64  124:iinc            1  1
    //   65  127:iload_1         
    //   66  128:aload_0         
    //   67  129:getfield        #267 <Field Matrix tempuserToRole>
    //   68  132:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   69  135:icmplt          42
    //   70  138:return          
    }

    private void computeLoss(Matrix tempUPA2, Matrix upa2)
    {
        int count = 0;
    //    0    0:iconst_0        
    //    1    1:istore_3        
        for(int index = 0; index < tempUPA2.getRowDimension(); index++)
    //*   2    2:iconst_0        
    //*   3    3:istore          4
    //*   4    5:goto            51
        {
            for(int jndex = 0; jndex < tempUPA2.getColumnDimension(); jndex++)
    //*   5    8:iconst_0        
    //*   6    9:istore          5
    //*   7   11:goto            39
                if(tempUPA2.get(index, jndex) != upa2.get(index, jndex))
    //*   8   14:aload_1         
    //*   9   15:iload           4
    //*  10   17:iload           5
    //*  11   19:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  12   22:aload_2         
    //*  13   23:iload           4
    //*  14   25:iload           5
    //*  15   27:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  16   30:icmpeq          36
                    count++;
    //   17   33:iinc            3  1

    //   18   36:iinc            5  1
    //   19   39:iload           5
    //   20   41:aload_1         
    //   21   42:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   22   45:icmplt          14
        }

    //   23   48:iinc            4  1
    //   24   51:iload           4
    //   25   53:aload_1         
    //   26   54:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   27   57:icmplt          8
        afterwsc.loss = count;
    //   28   60:aload_0         
    //   29   61:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //   30   64:iload_3         
    //   31   65:putfield        #253 <Field int YeHRMiner$HWSC.loss>
    //   32   68:return          
    }

    private void deleteRowAndCol(int index)
    {
        Matrix tempUA = new Matrix(tempuserToRole.getRowDimension(), tempuserToRole.getColumnDimension() - 1);
    //    0    0:new             #135 <Class Matrix>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #267 <Field Matrix tempuserToRole>
    //    4    8:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //    5   11:aload_0         
    //    6   12:getfield        #267 <Field Matrix tempuserToRole>
    //    7   15:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //    8   18:iconst_1        
    //    9   19:isub            
    //   10   20:invokespecial   #140 <Method void Matrix(int, int)>
    //   11   23:astore_2        
        for(int j = index; j < tempuserToRole.getColumnDimension() - 1; j++)
    //*  12   24:iload_1         
    //*  13   25:istore_3        
    //*  14   26:goto            75
        {
            for(int i = 0; i < tempuserToRole.getRowDimension(); i++)
    //*  15   29:iconst_0        
    //*  16   30:istore          4
    //*  17   32:goto            60
                tempuserToRole.set(i, j, tempuserToRole.get(i, j + 1));
    //   18   35:aload_0         
    //   19   36:getfield        #267 <Field Matrix tempuserToRole>
    //   20   39:iload           4
    //   21   41:iload_3         
    //   22   42:aload_0         
    //   23   43:getfield        #267 <Field Matrix tempuserToRole>
    //   24   46:iload           4
    //   25   48:iload_3         
    //   26   49:iconst_1        
    //   27   50:iadd            
    //   28   51:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   29   54:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   30   57:iinc            4  1
    //   31   60:iload           4
    //   32   62:aload_0         
    //   33   63:getfield        #267 <Field Matrix tempuserToRole>
    //   34   66:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   35   69:icmplt          35
        }

    //   36   72:iinc            3  1
    //   37   75:iload_3         
    //   38   76:aload_0         
    //   39   77:getfield        #267 <Field Matrix tempuserToRole>
    //   40   80:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   41   83:iconst_1        
    //   42   84:isub            
    //   43   85:icmplt          29
        for(int j = 0; j < tempuserToRole.getColumnDimension() - 1; j++)
    //*  44   88:iconst_0        
    //*  45   89:istore_3        
    //*  46   90:goto            134
        {
            for(int i = 0; i < tempuserToRole.getRowDimension(); i++)
    //*  47   93:iconst_0        
    //*  48   94:istore          4
    //*  49   96:goto            119
                tempUA.set(i, j, tempuserToRole.get(i, j));
    //   50   99:aload_2         
    //   51  100:iload           4
    //   52  102:iload_3         
    //   53  103:aload_0         
    //   54  104:getfield        #267 <Field Matrix tempuserToRole>
    //   55  107:iload           4
    //   56  109:iload_3         
    //   57  110:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   58  113:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   59  116:iinc            4  1
    //   60  119:iload           4
    //   61  121:aload_0         
    //   62  122:getfield        #267 <Field Matrix tempuserToRole>
    //   63  125:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   64  128:icmplt          99
        }

    //   65  131:iinc            3  1
    //   66  134:iload_3         
    //   67  135:aload_0         
    //   68  136:getfield        #267 <Field Matrix tempuserToRole>
    //   69  139:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   70  142:iconst_1        
    //   71  143:isub            
    //   72  144:icmplt          93
        tempuserToRole = tempUA.copy();
    //   73  147:aload_0         
    //   74  148:aload_2         
    //   75  149:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //   76  152:putfield        #267 <Field Matrix tempuserToRole>
        Matrix tempPA = new Matrix(temproleToPermission.getRowDimension() - 1, temproleToPermission.getColumnDimension());
    //   77  155:new             #135 <Class Matrix>
    //   78  158:dup             
    //   79  159:aload_0         
    //   80  160:getfield        #269 <Field Matrix temproleToPermission>
    //   81  163:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   82  166:iconst_1        
    //   83  167:isub            
    //   84  168:aload_0         
    //   85  169:getfield        #269 <Field Matrix temproleToPermission>
    //   86  172:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   87  175:invokespecial   #140 <Method void Matrix(int, int)>
    //   88  178:astore_3        
        for(int i = index; i < temproleToPermission.getRowDimension() - 1; i++)
    //*  89  179:iload_1         
    //*  90  180:istore          4
    //*  91  182:goto            233
        {
            for(int j = 0; j < temproleToPermission.getColumnDimension(); j++)
    //*  92  185:iconst_0        
    //*  93  186:istore          5
    //*  94  188:goto            218
                temproleToPermission.set(i, j, temproleToPermission.get(i + 1, j));
    //   95  191:aload_0         
    //   96  192:getfield        #269 <Field Matrix temproleToPermission>
    //   97  195:iload           4
    //   98  197:iload           5
    //   99  199:aload_0         
    //  100  200:getfield        #269 <Field Matrix temproleToPermission>
    //  101  203:iload           4
    //  102  205:iconst_1        
    //  103  206:iadd            
    //  104  207:iload           5
    //  105  209:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  106  212:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  107  215:iinc            5  1
    //  108  218:iload           5
    //  109  220:aload_0         
    //  110  221:getfield        #269 <Field Matrix temproleToPermission>
    //  111  224:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  112  227:icmplt          191
        }

    //  113  230:iinc            4  1
    //  114  233:iload           4
    //  115  235:aload_0         
    //  116  236:getfield        #269 <Field Matrix temproleToPermission>
    //  117  239:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  118  242:iconst_1        
    //  119  243:isub            
    //  120  244:icmplt          185
        for(int i = 0; i < temproleToPermission.getRowDimension() - 1; i++)
    //* 121  247:iconst_0        
    //* 122  248:istore          4
    //* 123  250:goto            296
        {
            for(int j = 0; j < temproleToPermission.getColumnDimension(); j++)
    //* 124  253:iconst_0        
    //* 125  254:istore          5
    //* 126  256:goto            281
                tempPA.set(i, j, temproleToPermission.get(i, j));
    //  127  259:aload_3         
    //  128  260:iload           4
    //  129  262:iload           5
    //  130  264:aload_0         
    //  131  265:getfield        #269 <Field Matrix temproleToPermission>
    //  132  268:iload           4
    //  133  270:iload           5
    //  134  272:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  135  275:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  136  278:iinc            5  1
    //  137  281:iload           5
    //  138  283:aload_0         
    //  139  284:getfield        #269 <Field Matrix temproleToPermission>
    //  140  287:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  141  290:icmplt          259
        }

    //  142  293:iinc            4  1
    //  143  296:iload           4
    //  144  298:aload_0         
    //  145  299:getfield        #269 <Field Matrix temproleToPermission>
    //  146  302:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  147  305:iconst_1        
    //  148  306:isub            
    //  149  307:icmplt          253
        temproleToPermission = tempPA.copy();
    //  150  310:aload_0         
    //  151  311:aload_3         
    //  152  312:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  153  315:putfield        #269 <Field Matrix temproleToPermission>
    //  154  318:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #307 <Field Assignment m_assignment>
        Object set[] = m_assignment.getDimensionX().getDimensionAttribute().toArray();
    //    3    5:aload_0         
    //    4    6:getfield        #307 <Field Assignment m_assignment>
    //    5    9:invokevirtual   #313 <Method Dimension Assignment.getDimensionX()>
    //    6   12:invokevirtual   #319 <Method Attribute Dimension.getDimensionAttribute()>
    //    7   15:invokevirtual   #325 <Method Object[] Attribute.toArray()>
    //    8   18:astore_2        
        String userSet[] = new String[set.length];
    //    9   19:aload_2         
    //   10   20:arraylength     
    //   11   21:anewarray       String[]
    //   12   24:astore_3        
        noUsers = set.length;
    //   13   25:aload_0         
    //   14   26:aload_2         
    //   15   27:arraylength     
    //   16   28:putfield        #137 <Field int noUsers>
        for(int i = 0; i < set.length; i++)
    //*  17   31:iconst_0        
    //*  18   32:istore          4
    //*  19   34:goto            66
        {
            userSet[i] = (String)set[i];
    //   20   37:aload_3         
    //   21   38:iload           4
    //   22   40:aload_2         
    //   23   41:iload           4
    //   24   43:aaload          
    //   25   44:checkcast       #87  <Class String>
    //   26   47:aastore         
            useVec.add((String)set[i]);
    //   27   48:aload_0         
    //   28   49:getfield        #75  <Field Vector useVec>
    //   29   52:aload_2         
    //   30   53:iload           4
    //   31   55:aaload          
    //   32   56:checkcast       #87  <Class String>
    //   33   59:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //   34   62:pop             
        }

    //   35   63:iinc            4  1
    //   36   66:iload           4
    //   37   68:aload_2         
    //   38   69:arraylength     
    //   39   70:icmplt          37
        set = m_assignment.getDimensionY().getDimensionAttribute().toArray();
    //   40   73:aload_0         
    //   41   74:getfield        #307 <Field Assignment m_assignment>
    //   42   77:invokevirtual   #328 <Method Dimension Assignment.getDimensionY()>
    //   43   80:invokevirtual   #319 <Method Attribute Dimension.getDimensionAttribute()>
    //   44   83:invokevirtual   #325 <Method Object[] Attribute.toArray()>
    //   45   86:astore_2        
        String permSet[] = new String[set.length];
    //   46   87:aload_2         
    //   47   88:arraylength     
    //   48   89:anewarray       String[]
    //   49   92:astore          4
        noPerms = set.length;
    //   50   94:aload_0         
    //   51   95:aload_2         
    //   52   96:arraylength     
    //   53   97:putfield        #144 <Field int noPerms>
        for(int i = 0; i < set.length; i++)
    //*  54  100:iconst_0        
    //*  55  101:istore          5
    //*  56  103:goto            136
        {
            permSet[i] = (String)set[i];
    //   57  106:aload           4
    //   58  108:iload           5
    //   59  110:aload_2         
    //   60  111:iload           5
    //   61  113:aaload          
    //   62  114:checkcast       #87  <Class String>
    //   63  117:aastore         
            perVec.add((String)set[i]);
    //   64  118:aload_0         
    //   65  119:getfield        #77  <Field Vector perVec>
    //   66  122:aload_2         
    //   67  123:iload           5
    //   68  125:aaload          
    //   69  126:checkcast       #87  <Class String>
    //   70  129:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //   71  132:pop             
        }

    //   72  133:iinc            5  1
    //   73  136:iload           5
    //   74  138:aload_2         
    //   75  139:arraylength     
    //   76  140:icmplt          106
        Matrix mat = m_assignment.getAssignmentMatrix();
    //   77  143:aload_0         
    //   78  144:getfield        #307 <Field Assignment m_assignment>
    //   79  147:invokevirtual   #331 <Method Matrix Assignment.getAssignmentMatrix()>
    //   80  150:astore          5
        f_context = new Context(userSet, permSet, mat, log);
    //   81  152:aload_0         
    //   82  153:new             #333 <Class Context>
    //   83  156:dup             
    //   84  157:aload_3         
    //   85  158:aload           4
    //   86  160:aload           5
    //   87  162:aload_0         
    //   88  163:getfield        #61  <Field StringBuffer log>
    //   89  166:invokespecial   #336 <Method void Context(String[], String[], Matrix, StringBuffer)>
    //   90  169:putfield        #338 <Field Context f_context>
        setContext(f_context, log);
    //   91  172:aload_0         
    //   92  173:aload_0         
    //   93  174:getfield        #338 <Field Context f_context>
    //   94  177:aload_0         
    //   95  178:getfield        #61  <Field StringBuffer log>
    //   96  181:invokevirtual   #342 <Method void setContext(Context, StringBuffer)>
        setWeights(wr, wu, wp, wh);
    //   97  184:aload_0         
    //   98  185:aload_0         
    //   99  186:getfield        #344 <Field int wr>
    //  100  189:aload_0         
    //  101  190:getfield        #346 <Field int wu>
    //  102  193:aload_0         
    //  103  194:getfield        #348 <Field int wp>
    //  104  197:aload_0         
    //  105  198:getfield        #350 <Field int wh>
    //  106  201:invokevirtual   #354 <Method void setWeights(int, int, int, int)>
        log.append("--------------------------------------\n");
    //  107  204:aload_0         
    //  108  205:getfield        #61  <Field StringBuffer log>
    //  109  208:ldc1            #219 <String "--------------------------------------\n">
    //  110  210:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  111  213:pop             
        UPA = (Matrix)mat.clone();
    //  112  214:aload_0         
    //  113  215:aload           5
    //  114  217:invokevirtual   #357 <Method Object Matrix.clone()>
    //  115  220:checkcast       #135 <Class Matrix>
    //  116  223:putfield        #359 <Field Matrix UPA>
        formalObjects = f_context.getAllObjects();
    //  117  226:aload_0         
    //  118  227:aload_0         
    //  119  228:getfield        #338 <Field Context f_context>
    //  120  231:invokevirtual   #363 <Method String[] Context.getAllObjects()>
    //  121  234:putfield        #158 <Field String[] formalObjects>
        formalAttributes = f_context.getAllAttributes();
    //  122  237:aload_0         
    //  123  238:aload_0         
    //  124  239:getfield        #338 <Field Context f_context>
    //  125  242:invokevirtual   #366 <Method String[] Context.getAllAttributes()>
    //  126  245:putfield        #182 <Field String[] formalAttributes>
        initMatrix();
    //  127  248:aload_0         
    //  128  249:invokespecial   #368 <Method void initMatrix()>
        ReduceEdges();
    //  129  252:aload_0         
    //  130  253:invokevirtual   #371 <Method int ReduceEdges()>
    //  131  256:pop             
        initHRMatrixs();
    //  132  257:aload_0         
    //  133  258:invokespecial   #374 <Method void initHRMatrixs()>
        afterwsc = beforewsc.copy();
    //  134  261:aload_0         
    //  135  262:aload_0         
    //  136  263:getfield        #68  <Field YeHRMiner$HWSC beforewsc>
    //  137  266:invokevirtual   #377 <Method YeHRMiner$HWSC YeHRMiner$HWSC.copy()>
    //  138  269:putfield        #70  <Field YeHRMiner$HWSC afterwsc>
        calculatEdges(huserToRole, hroleToPermission, hroleToRole, afterwsc);
    //  139  272:aload_0         
    //  140  273:aload_0         
    //  141  274:getfield        #271 <Field Matrix huserToRole>
    //  142  277:aload_0         
    //  143  278:getfield        #275 <Field Matrix hroleToPermission>
    //  144  281:aload_0         
    //  145  282:getfield        #279 <Field Matrix hroleToRole>
    //  146  285:aload_0         
    //  147  286:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  148  289:invokespecial   #225 <Method void calculatEdges(Matrix, Matrix, Matrix, YeHRMiner$HWSC)>
        log.append((new StringBuilder("\u521D\u59CB\u7684\u8FB9\u4E3A: ")).append(afterwsc.edges).append("\n").toString());
    //  149  292:aload_0         
    //  150  293:getfield        #61  <Field StringBuffer log>
    //  151  296:new             #196 <Class StringBuilder>
    //  152  299:dup             
    //  153  300:ldc2            #379 <String "\u521D\u59CB\u7684\u8FB9\u4E3A: ">
    //  154  303:invokespecial   #206 <Method void StringBuilder(String)>
    //  155  306:aload_0         
    //  156  307:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  157  310:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //  158  313:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  159  316:ldc1            #217 <String "\n">
    //  160  318:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  161  321:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  162  324:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  163  327:pop             
        boolean done = true;
    //  164  328:iconst_1        
    //  165  329:istore          6
    //* 166  331:goto            713
        while(done) 
        {
            done = false;
    //  167  334:iconst_0        
    //  168  335:istore          6
            Vector mapVector = new Vector();
    //  169  337:new             #72  <Class Vector>
    //  170  340:dup             
    //  171  341:invokespecial   #73  <Method void Vector()>
    //  172  344:astore          7
            for(int index = 0; index < numberOfRoles; index++)
    //* 173  346:iconst_0        
    //* 174  347:istore          8
    //* 175  349:goto            539
            {
                cloneMatrix();
    //  176  352:aload_0         
    //  177  353:invokespecial   #384 <Method void cloneMatrix()>
                resetRowAndCol(index);
    //  178  356:aload_0         
    //  179  357:iload           8
    //  180  359:invokespecial   #386 <Method void resetRowAndCol(int)>
                deleteRoleDealWith(index);
    //  181  362:aload_0         
    //  182  363:iload           8
    //  183  365:invokespecial   #389 <Method void deleteRoleDealWith(int)>
                multiplicationOfMatrix();
    //  184  368:aload_0         
    //  185  369:invokespecial   #391 <Method void multiplicationOfMatrix()>
                computeLoss(tempUPA, UPA);
    //  186  372:aload_0         
    //  187  373:aload_0         
    //  188  374:getfield        #286 <Field Matrix tempUPA>
    //  189  377:aload_0         
    //  190  378:getfield        #359 <Field Matrix UPA>
    //  191  381:invokespecial   #393 <Method void computeLoss(Matrix, Matrix)>
                calculatEdges(htempuserToRole, htemproleToPermission, htemproleToRole, afterwsc);
    //  192  384:aload_0         
    //  193  385:aload_0         
    //  194  386:getfield        #273 <Field Matrix htempuserToRole>
    //  195  389:aload_0         
    //  196  390:getfield        #277 <Field Matrix htemproleToPermission>
    //  197  393:aload_0         
    //  198  394:getfield        #281 <Field Matrix htemproleToRole>
    //  199  397:aload_0         
    //  200  398:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  201  401:invokespecial   #225 <Method void calculatEdges(Matrix, Matrix, Matrix, YeHRMiner$HWSC)>
                calculateWSC(afterwsc);
    //  202  404:aload_0         
    //  203  405:aload_0         
    //  204  406:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  205  409:invokespecial   #235 <Method void calculateWSC(YeHRMiner$HWSC)>
                double con = (1 + (beforewsc.edges - afterwsc.edges)) - 1 * afterwsc.loss;
    //  206  412:iconst_1        
    //  207  413:aload_0         
    //  208  414:getfield        #68  <Field YeHRMiner$HWSC beforewsc>
    //  209  417:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //  210  420:aload_0         
    //  211  421:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  212  424:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //  213  427:isub            
    //  214  428:iadd            
    //  215  429:iconst_1        
    //  216  430:aload_0         
    //  217  431:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  218  434:getfield        #253 <Field int YeHRMiner$HWSC.loss>
    //  219  437:imul            
    //  220  438:isub            
    //  221  439:i2d             
    //  222  440:dstore          9
                if(con >= 0.0D)
    //* 223  442:dload           9
    //* 224  444:dconst_0        
    //* 225  445:dcmpl           
    //* 226  446:iflt            481
                {
                    con2RoleIndex c2ri = new con2RoleIndex();
    //  227  449:new             #395 <Class YeHRMiner$con2RoleIndex>
    //  228  452:dup             
    //  229  453:aload_0         
    //  230  454:invokespecial   #396 <Method void YeHRMiner$con2RoleIndex(YeHRMiner)>
    //  231  457:astore          11
                    c2ri.con = con;
    //  232  459:aload           11
    //  233  461:dload           9
    //  234  463:putfield        #400 <Field double YeHRMiner$con2RoleIndex.con>
                    c2ri.indexRole = index;
    //  235  466:aload           11
    //  236  468:iload           8
    //  237  470:putfield        #403 <Field int YeHRMiner$con2RoleIndex.indexRole>
                    mapVector.add(c2ri);
    //  238  473:aload           7
    //  239  475:aload           11
    //  240  477:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //  241  480:pop             
                }
                tempuserToRole = userToRole.copy();
    //  242  481:aload_0         
    //  243  482:aload_0         
    //  244  483:getfield        #142 <Field Matrix userToRole>
    //  245  486:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  246  489:putfield        #267 <Field Matrix tempuserToRole>
                temproleToPermission = roleToPermission.copy();
    //  247  492:aload_0         
    //  248  493:aload_0         
    //  249  494:getfield        #146 <Field Matrix roleToPermission>
    //  250  497:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  251  500:putfield        #269 <Field Matrix temproleToPermission>
                htempuserToRole = huserToRole.copy();
    //  252  503:aload_0         
    //  253  504:aload_0         
    //  254  505:getfield        #271 <Field Matrix huserToRole>
    //  255  508:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  256  511:putfield        #273 <Field Matrix htempuserToRole>
                htemproleToPermission = hroleToPermission.copy();
    //  257  514:aload_0         
    //  258  515:aload_0         
    //  259  516:getfield        #275 <Field Matrix hroleToPermission>
    //  260  519:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  261  522:putfield        #277 <Field Matrix htemproleToPermission>
                htemproleToRole = hroleToRole.copy();
    //  262  525:aload_0         
    //  263  526:aload_0         
    //  264  527:getfield        #279 <Field Matrix hroleToRole>
    //  265  530:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  266  533:putfield        #281 <Field Matrix htemproleToRole>
            }

    //  267  536:iinc            8  1
    //  268  539:iload           8
    //  269  541:getstatic       #51  <Field int numberOfRoles>
    //  270  544:icmplt          352
            cloneMatrix();
    //  271  547:aload_0         
    //  272  548:invokespecial   #384 <Method void cloneMatrix()>
            int indexMaxRole = getIndexMaxRole(mapVector);
    //  273  551:aload_0         
    //  274  552:aload           7
    //  275  554:invokespecial   #407 <Method int getIndexMaxRole(Vector)>
    //  276  557:istore          8
            if(indexMaxRole < numberOfRoles)
    //* 277  559:iload           8
    //* 278  561:getstatic       #51  <Field int numberOfRoles>
    //* 279  564:icmpge          713
            {
                numberOfRoles--;
    //  280  567:getstatic       #51  <Field int numberOfRoles>
    //  281  570:iconst_1        
    //  282  571:isub            
    //  283  572:putstatic       #51  <Field int numberOfRoles>
                done = true;
    //  284  575:iconst_1        
    //  285  576:istore          6
                deleteRowAndCol(indexMaxRole);
    //  286  578:aload_0         
    //  287  579:iload           8
    //  288  581:invokespecial   #409 <Method void deleteRowAndCol(int)>
                deleteRoleDealWith(indexMaxRole);
    //  289  584:aload_0         
    //  290  585:iload           8
    //  291  587:invokespecial   #389 <Method void deleteRoleDealWith(int)>
                multiplicationOfMatrix();
    //  292  590:aload_0         
    //  293  591:invokespecial   #391 <Method void multiplicationOfMatrix()>
                computeLoss(tempUPA, UPA);
    //  294  594:aload_0         
    //  295  595:aload_0         
    //  296  596:getfield        #286 <Field Matrix tempUPA>
    //  297  599:aload_0         
    //  298  600:getfield        #359 <Field Matrix UPA>
    //  299  603:invokespecial   #393 <Method void computeLoss(Matrix, Matrix)>
                calculatEdges(htempuserToRole, htemproleToPermission, htemproleToRole, afterwsc);
    //  300  606:aload_0         
    //  301  607:aload_0         
    //  302  608:getfield        #273 <Field Matrix htempuserToRole>
    //  303  611:aload_0         
    //  304  612:getfield        #277 <Field Matrix htemproleToPermission>
    //  305  615:aload_0         
    //  306  616:getfield        #281 <Field Matrix htemproleToRole>
    //  307  619:aload_0         
    //  308  620:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  309  623:invokespecial   #225 <Method void calculatEdges(Matrix, Matrix, Matrix, YeHRMiner$HWSC)>
                afterwsc.R--;
    //  310  626:aload_0         
    //  311  627:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  312  630:dup             
    //  313  631:getfield        #231 <Field int YeHRMiner$HWSC.R>
    //  314  634:iconst_1        
    //  315  635:isub            
    //  316  636:putfield        #231 <Field int YeHRMiner$HWSC.R>
                calculateWSC(afterwsc);
    //  317  639:aload_0         
    //  318  640:aload_0         
    //  319  641:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  320  644:invokespecial   #235 <Method void calculateWSC(YeHRMiner$HWSC)>
                beforewsc = afterwsc.copy();
    //  321  647:aload_0         
    //  322  648:aload_0         
    //  323  649:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  324  652:invokevirtual   #377 <Method YeHRMiner$HWSC YeHRMiner$HWSC.copy()>
    //  325  655:putfield        #68  <Field YeHRMiner$HWSC beforewsc>
                userToRole = tempuserToRole.copy();
    //  326  658:aload_0         
    //  327  659:aload_0         
    //  328  660:getfield        #267 <Field Matrix tempuserToRole>
    //  329  663:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  330  666:putfield        #142 <Field Matrix userToRole>
                roleToPermission = temproleToPermission.copy();
    //  331  669:aload_0         
    //  332  670:aload_0         
    //  333  671:getfield        #269 <Field Matrix temproleToPermission>
    //  334  674:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  335  677:putfield        #146 <Field Matrix roleToPermission>
                huserToRole = htempuserToRole.copy();
    //  336  680:aload_0         
    //  337  681:aload_0         
    //  338  682:getfield        #273 <Field Matrix htempuserToRole>
    //  339  685:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  340  688:putfield        #271 <Field Matrix huserToRole>
                hroleToPermission = htemproleToPermission.copy();
    //  341  691:aload_0         
    //  342  692:aload_0         
    //  343  693:getfield        #277 <Field Matrix htemproleToPermission>
    //  344  696:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  345  699:putfield        #275 <Field Matrix hroleToPermission>
                hroleToRole = htemproleToRole.copy();
    //  346  702:aload_0         
    //  347  703:aload_0         
    //  348  704:getfield        #281 <Field Matrix htemproleToRole>
    //  349  707:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  350  710:putfield        #279 <Field Matrix hroleToRole>
            }
        }
    //  351  713:iload           6
    //  352  715:ifne            334
        multiplicationOfMatrix();
    //  353  718:aload_0         
    //  354  719:invokespecial   #391 <Method void multiplicationOfMatrix()>
        computeLoss(tempUPA, UPA);
    //  355  722:aload_0         
    //  356  723:aload_0         
    //  357  724:getfield        #286 <Field Matrix tempUPA>
    //  358  727:aload_0         
    //  359  728:getfield        #359 <Field Matrix UPA>
    //  360  731:invokespecial   #393 <Method void computeLoss(Matrix, Matrix)>
        calculatEdges(huserToRole, hroleToPermission, hroleToRole, afterwsc);
    //  361  734:aload_0         
    //  362  735:aload_0         
    //  363  736:getfield        #271 <Field Matrix huserToRole>
    //  364  739:aload_0         
    //  365  740:getfield        #275 <Field Matrix hroleToPermission>
    //  366  743:aload_0         
    //  367  744:getfield        #279 <Field Matrix hroleToRole>
    //  368  747:aload_0         
    //  369  748:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  370  751:invokespecial   #225 <Method void calculatEdges(Matrix, Matrix, Matrix, YeHRMiner$HWSC)>
        printUAandPA(huserToRole, hroleToPermission, hroleToRole);
    //  371  754:aload_0         
    //  372  755:aload_0         
    //  373  756:getfield        #271 <Field Matrix huserToRole>
    //  374  759:aload_0         
    //  375  760:getfield        #275 <Field Matrix hroleToPermission>
    //  376  763:aload_0         
    //  377  764:getfield        #279 <Field Matrix hroleToRole>
    //  378  767:invokespecial   #413 <Method void printUAandPA(Matrix, Matrix, Matrix)>
    //  379  770:return          
    }

    private void deleteRoleDealWith(int index)
    {
        ArrayList Jun = new ArrayList();
    //    0    0:new             #427 <Class ArrayList>
    //    1    3:dup             
    //    2    4:invokespecial   #428 <Method void ArrayList()>
    //    3    7:astore_2        
        ArrayList Sen = new ArrayList();
    //    4    8:new             #427 <Class ArrayList>
    //    5   11:dup             
    //    6   12:invokespecial   #428 <Method void ArrayList()>
    //    7   15:astore_3        
        for(int jndex = 0; jndex < htemproleToRole.getColumnDimension(); jndex++)
    //*   8   16:iconst_0        
    //*   9   17:istore          4
    //*  10   19:goto            49
            if(htemproleToRole.get(index, jndex) == 1)
    //*  11   22:aload_0         
    //*  12   23:getfield        #281 <Field Matrix htemproleToRole>
    //*  13   26:iload_1         
    //*  14   27:iload           4
    //*  15   29:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  16   32:iconst_1        
    //*  17   33:icmpne          46
                Jun.add(Integer.valueOf(jndex));
    //   18   36:aload_2         
    //   19   37:iload           4
    //   20   39:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   21   42:invokevirtual   #429 <Method boolean ArrayList.add(Object)>
    //   22   45:pop             

    //   23   46:iinc            4  1
    //   24   49:iload           4
    //   25   51:aload_0         
    //   26   52:getfield        #281 <Field Matrix htemproleToRole>
    //   27   55:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   28   58:icmplt          22
        for(int kndex = 0; kndex < htemproleToRole.getRowDimension(); kndex++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            94
            if(htemproleToRole.get(kndex, index) == 1)
    //*  32   67:aload_0         
    //*  33   68:getfield        #281 <Field Matrix htemproleToRole>
    //*  34   71:iload           4
    //*  35   73:iload_1         
    //*  36   74:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  37   77:iconst_1        
    //*  38   78:icmpne          91
                Sen.add(Integer.valueOf(kndex));
    //   39   81:aload_3         
    //   40   82:iload           4
    //   41   84:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   42   87:invokevirtual   #429 <Method boolean ArrayList.add(Object)>
    //   43   90:pop             

    //   44   91:iinc            4  1
    //   45   94:iload           4
    //   46   96:aload_0         
    //   47   97:getfield        #281 <Field Matrix htemproleToRole>
    //   48  100:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   49  103:icmplt          67
        Vector currentPermLists = new Vector();
    //   50  106:new             #72  <Class Vector>
    //   51  109:dup             
    //   52  110:invokespecial   #73  <Method void Vector()>
    //   53  113:astore          4
        for(int jndex = 0; jndex < htemproleToPermission.getColumnDimension(); jndex++)
    //*  54  115:iconst_0        
    //*  55  116:istore          5
    //*  56  118:goto            149
            if(htemproleToPermission.get(index, jndex) == 1)
    //*  57  121:aload_0         
    //*  58  122:getfield        #277 <Field Matrix htemproleToPermission>
    //*  59  125:iload_1         
    //*  60  126:iload           5
    //*  61  128:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  62  131:iconst_1        
    //*  63  132:icmpne          146
                currentPermLists.add(Integer.valueOf(jndex));
    //   64  135:aload           4
    //   65  137:iload           5
    //   66  139:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   67  142:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //   68  145:pop             

    //   69  146:iinc            5  1
    //   70  149:iload           5
    //   71  151:aload_0         
    //   72  152:getfield        #277 <Field Matrix htemproleToPermission>
    //   73  155:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   74  158:icmplt          121
        Vector currentUserLists = new Vector();
    //   75  161:new             #72  <Class Vector>
    //   76  164:dup             
    //   77  165:invokespecial   #73  <Method void Vector()>
    //   78  168:astore          5
        for(int jndex = 0; jndex < htempuserToRole.getRowDimension(); jndex++)
    //*  79  170:iconst_0        
    //*  80  171:istore          6
    //*  81  173:goto            204
            if(htempuserToRole.get(jndex, index) == 1)
    //*  82  176:aload_0         
    //*  83  177:getfield        #273 <Field Matrix htempuserToRole>
    //*  84  180:iload           6
    //*  85  182:iload_1         
    //*  86  183:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  87  186:iconst_1        
    //*  88  187:icmpne          201
                currentUserLists.add(Integer.valueOf(jndex));
    //   89  190:aload           5
    //   90  192:iload           6
    //   91  194:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   92  197:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //   93  200:pop             

    //   94  201:iinc            6  1
    //   95  204:iload           6
    //   96  206:aload_0         
    //   97  207:getfield        #273 <Field Matrix htempuserToRole>
    //   98  210:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   99  213:icmplt          176
        for(int jndex = 0; jndex < Jun.size(); jndex++)
    //* 100  216:iconst_0        
    //* 101  217:istore          6
    //* 102  219:goto            280
        {
            for(int kndex = 0; kndex < currentUserLists.size(); kndex++)
    //* 103  222:iconst_0        
    //* 104  223:istore          7
    //* 105  225:goto            267
                htempuserToRole.set(((Integer)currentUserLists.get(kndex)).intValue(), ((Integer)(Integer)Jun.get(jndex)).intValue(), (byte)1);
    //  106  228:aload_0         
    //  107  229:getfield        #273 <Field Matrix htempuserToRole>
    //  108  232:aload           5
    //  109  234:iload           7
    //  110  236:invokevirtual   #432 <Method Object Vector.get(int)>
    //  111  239:checkcast       #107 <Class Integer>
    //  112  242:invokevirtual   #176 <Method int Integer.intValue()>
    //  113  245:aload_2         
    //  114  246:iload           6
    //  115  248:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //  116  251:checkcast       #107 <Class Integer>
    //  117  254:checkcast       #107 <Class Integer>
    //  118  257:invokevirtual   #176 <Method int Integer.intValue()>
    //  119  260:iconst_1        
    //  120  261:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  121  264:iinc            7  1
    //  122  267:iload           7
    //  123  269:aload           5
    //  124  271:invokevirtual   #436 <Method int Vector.size()>
    //  125  274:icmplt          228
        }

    //  126  277:iinc            6  1
    //  127  280:iload           6
    //  128  282:aload_2         
    //  129  283:invokevirtual   #437 <Method int ArrayList.size()>
    //  130  286:icmplt          222
        deleteIndex(index, 0);
    //  131  289:aload_0         
    //  132  290:iload_1         
    //  133  291:iconst_0        
    //  134  292:invokespecial   #440 <Method void deleteIndex(int, int)>
        for(int jndex = 0; jndex < Sen.size(); jndex++)
    //* 135  295:iconst_0        
    //* 136  296:istore          6
    //* 137  298:goto            359
        {
            for(int kndex = 0; kndex < currentPermLists.size(); kndex++)
    //* 138  301:iconst_0        
    //* 139  302:istore          7
    //* 140  304:goto            346
                htemproleToPermission.set(((Integer)(Integer)Sen.get(jndex)).intValue(), ((Integer)currentPermLists.get(kndex)).intValue(), (byte)1);
    //  141  307:aload_0         
    //  142  308:getfield        #277 <Field Matrix htemproleToPermission>
    //  143  311:aload_3         
    //  144  312:iload           6
    //  145  314:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //  146  317:checkcast       #107 <Class Integer>
    //  147  320:checkcast       #107 <Class Integer>
    //  148  323:invokevirtual   #176 <Method int Integer.intValue()>
    //  149  326:aload           4
    //  150  328:iload           7
    //  151  330:invokevirtual   #432 <Method Object Vector.get(int)>
    //  152  333:checkcast       #107 <Class Integer>
    //  153  336:invokevirtual   #176 <Method int Integer.intValue()>
    //  154  339:iconst_1        
    //  155  340:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  156  343:iinc            7  1
    //  157  346:iload           7
    //  158  348:aload           4
    //  159  350:invokevirtual   #436 <Method int Vector.size()>
    //  160  353:icmplt          307
        }

    //  161  356:iinc            6  1
    //  162  359:iload           6
    //  163  361:aload_3         
    //  164  362:invokevirtual   #437 <Method int ArrayList.size()>
    //  165  365:icmplt          301
        deleteIndex(index, 1);
    //  166  368:aload_0         
    //  167  369:iload_1         
    //  168  370:iconst_1        
    //  169  371:invokespecial   #440 <Method void deleteIndex(int, int)>
        for(int jndex = 0; jndex < Sen.size(); jndex++)
    //* 170  374:iconst_0        
    //* 171  375:istore          6
    //* 172  377:goto            476
        {
            for(int kndex = 0; kndex < Jun.size(); kndex++)
    //* 173  380:iconst_0        
    //* 174  381:istore          7
    //* 175  383:goto            464
                if(!hasMorePaths(((Integer)(Integer)Sen.get(jndex)).intValue(), ((Integer)(Integer)Jun.get(kndex)).intValue()))
    //* 176  386:aload_0         
    //* 177  387:aload_3         
    //* 178  388:iload           6
    //* 179  390:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //* 180  393:checkcast       #107 <Class Integer>
    //* 181  396:checkcast       #107 <Class Integer>
    //* 182  399:invokevirtual   #176 <Method int Integer.intValue()>
    //* 183  402:aload_2         
    //* 184  403:iload           7
    //* 185  405:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //* 186  408:checkcast       #107 <Class Integer>
    //* 187  411:checkcast       #107 <Class Integer>
    //* 188  414:invokevirtual   #176 <Method int Integer.intValue()>
    //* 189  417:invokespecial   #444 <Method boolean hasMorePaths(int, int)>
    //* 190  420:ifne            461
                    htemproleToRole.set(((Integer)(Integer)Sen.get(jndex)).intValue(), ((Integer)(Integer)Jun.get(kndex)).intValue(), (byte)1);
    //  191  423:aload_0         
    //  192  424:getfield        #281 <Field Matrix htemproleToRole>
    //  193  427:aload_3         
    //  194  428:iload           6
    //  195  430:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //  196  433:checkcast       #107 <Class Integer>
    //  197  436:checkcast       #107 <Class Integer>
    //  198  439:invokevirtual   #176 <Method int Integer.intValue()>
    //  199  442:aload_2         
    //  200  443:iload           7
    //  201  445:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //  202  448:checkcast       #107 <Class Integer>
    //  203  451:checkcast       #107 <Class Integer>
    //  204  454:invokevirtual   #176 <Method int Integer.intValue()>
    //  205  457:iconst_1        
    //  206  458:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  207  461:iinc            7  1
    //  208  464:iload           7
    //  209  466:aload_2         
    //  210  467:invokevirtual   #437 <Method int ArrayList.size()>
    //  211  470:icmplt          386
        }

    //  212  473:iinc            6  1
    //  213  476:iload           6
    //  214  478:aload_3         
    //  215  479:invokevirtual   #437 <Method int ArrayList.size()>
    //  216  482:icmplt          380
        deleteIndex(index, 2);
    //  217  485:aload_0         
    //  218  486:iload_1         
    //  219  487:iconst_2        
    //  220  488:invokespecial   #440 <Method void deleteIndex(int, int)>
    //  221  491:return          
    }

    private boolean hasMorePaths(int jndex, int kndex)
    {
        int nopath = 0;
    //    0    0:iconst_0        
    //    1    1:istore_3        
        int qnode = jndex;
    //    2    2:iload_1         
    //    3    3:istore          4
        ArrayDeque qnodes = new ArrayDeque();
    //    4    5:new             #452 <Class ArrayDeque>
    //    5    8:dup             
    //    6    9:invokespecial   #453 <Method void ArrayDeque()>
    //    7   12:astore          5
        qnodes.add(Integer.valueOf(jndex));
    //    8   14:aload           5
    //    9   16:iload_1         
    //   10   17:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   11   20:invokevirtual   #454 <Method boolean ArrayDeque.add(Object)>
    //   12   23:pop             
    //*  13   24:goto            108
        while(!qnodes.isEmpty()) 
        {
            qnode = ((Integer)(Integer)qnodes.getFirst()).intValue();
    //   14   27:aload           5
    //   15   29:invokevirtual   #457 <Method Object ArrayDeque.getFirst()>
    //   16   32:checkcast       #107 <Class Integer>
    //   17   35:checkcast       #107 <Class Integer>
    //   18   38:invokevirtual   #176 <Method int Integer.intValue()>
    //   19   41:istore          4
            qnodes.removeFirst();
    //   20   43:aload           5
    //   21   45:invokevirtual   #460 <Method Object ArrayDeque.removeFirst()>
    //   22   48:pop             
            for(int i = 0; i < htemproleToRole.getColumnDimension(); i++)
    //*  23   49:iconst_0        
    //*  24   50:istore          6
    //*  25   52:goto            96
                if(htemproleToRole.get(qnode, i) == 1)
    //*  26   55:aload_0         
    //*  27   56:getfield        #281 <Field Matrix htemproleToRole>
    //*  28   59:iload           4
    //*  29   61:iload           6
    //*  30   63:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  31   66:iconst_1        
    //*  32   67:icmpne          93
                    if(i == kndex)
    //*  33   70:iload           6
    //*  34   72:iload_2         
    //*  35   73:icmpne          82
                        nopath++;
    //   36   76:iinc            3  1
                    else
    //*  37   79:goto            93
                        qnodes.add(Integer.valueOf(i));
    //   38   82:aload           5
    //   39   84:iload           6
    //   40   86:invokestatic    #111 <Method Integer Integer.valueOf(int)>
    //   41   89:invokevirtual   #454 <Method boolean ArrayDeque.add(Object)>
    //   42   92:pop             

    //   43   93:iinc            6  1
    //   44   96:iload           6
    //   45   98:aload_0         
    //   46   99:getfield        #281 <Field Matrix htemproleToRole>
    //   47  102:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   48  105:icmplt          55
        }
    //   49  108:aload           5
    //   50  110:invokevirtual   #463 <Method boolean ArrayDeque.isEmpty()>
    //   51  113:ifeq            27
        return nopath > 1;
    //   52  116:iload_3         
    //   53  117:iconst_1        
    //   54  118:icmple          125
    //   55  121:iconst_1        
    //   56  122:goto            126
    //   57  125:iconst_0        
    //   58  126:ireturn         
    }

    private void deleteIndex(int index, int flag)
    {
        if(flag == 0)
    //*   0    0:iload_2         
    //*   1    1:ifne            170
        {
            Matrix temphUA = new Matrix(htempuserToRole.getRowDimension(), htempuserToRole.getColumnDimension() - 1);
    //    2    4:new             #135 <Class Matrix>
    //    3    7:dup             
    //    4    8:aload_0         
    //    5    9:getfield        #273 <Field Matrix htempuserToRole>
    //    6   12:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //    7   15:aload_0         
    //    8   16:getfield        #273 <Field Matrix htempuserToRole>
    //    9   19:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   10   22:iconst_1        
    //   11   23:isub            
    //   12   24:invokespecial   #140 <Method void Matrix(int, int)>
    //   13   27:astore_3        
            for(int j = index; j < htempuserToRole.getColumnDimension() - 1; j++)
    //*  14   28:iload_1         
    //*  15   29:istore          4
    //*  16   31:goto            82
            {
                for(int i = 0; i < htempuserToRole.getRowDimension(); i++)
    //*  17   34:iconst_0        
    //*  18   35:istore          5
    //*  19   37:goto            67
                    htempuserToRole.set(i, j, htempuserToRole.get(i, j + 1));
    //   20   40:aload_0         
    //   21   41:getfield        #273 <Field Matrix htempuserToRole>
    //   22   44:iload           5
    //   23   46:iload           4
    //   24   48:aload_0         
    //   25   49:getfield        #273 <Field Matrix htempuserToRole>
    //   26   52:iload           5
    //   27   54:iload           4
    //   28   56:iconst_1        
    //   29   57:iadd            
    //   30   58:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   31   61:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   32   64:iinc            5  1
    //   33   67:iload           5
    //   34   69:aload_0         
    //   35   70:getfield        #273 <Field Matrix htempuserToRole>
    //   36   73:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   37   76:icmplt          40
            }

    //   38   79:iinc            4  1
    //   39   82:iload           4
    //   40   84:aload_0         
    //   41   85:getfield        #273 <Field Matrix htempuserToRole>
    //   42   88:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   43   91:iconst_1        
    //   44   92:isub            
    //   45   93:icmplt          34
            for(int j = 0; j < htempuserToRole.getColumnDimension() - 1; j++)
    //*  46   96:iconst_0        
    //*  47   97:istore          4
    //*  48   99:goto            145
            {
                for(int i = 0; i < htempuserToRole.getRowDimension(); i++)
    //*  49  102:iconst_0        
    //*  50  103:istore          5
    //*  51  105:goto            130
                    temphUA.set(i, j, htempuserToRole.get(i, j));
    //   52  108:aload_3         
    //   53  109:iload           5
    //   54  111:iload           4
    //   55  113:aload_0         
    //   56  114:getfield        #273 <Field Matrix htempuserToRole>
    //   57  117:iload           5
    //   58  119:iload           4
    //   59  121:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   60  124:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   61  127:iinc            5  1
    //   62  130:iload           5
    //   63  132:aload_0         
    //   64  133:getfield        #273 <Field Matrix htempuserToRole>
    //   65  136:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   66  139:icmplt          108
            }

    //   67  142:iinc            4  1
    //   68  145:iload           4
    //   69  147:aload_0         
    //   70  148:getfield        #273 <Field Matrix htempuserToRole>
    //   71  151:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   72  154:iconst_1        
    //   73  155:isub            
    //   74  156:icmplt          102
            htempuserToRole = temphUA.copy();
    //   75  159:aload_0         
    //   76  160:aload_3         
    //   77  161:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //   78  164:putfield        #273 <Field Matrix htempuserToRole>
        } else
    //*  79  167:goto            581
        if(flag == 1)
    //*  80  170:iload_2         
    //*  81  171:iconst_1        
    //*  82  172:icmpne          341
        {
            Matrix temphPA = new Matrix(htemproleToPermission.getRowDimension() - 1, htemproleToPermission.getColumnDimension());
    //   83  175:new             #135 <Class Matrix>
    //   84  178:dup             
    //   85  179:aload_0         
    //   86  180:getfield        #277 <Field Matrix htemproleToPermission>
    //   87  183:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   88  186:iconst_1        
    //   89  187:isub            
    //   90  188:aload_0         
    //   91  189:getfield        #277 <Field Matrix htemproleToPermission>
    //   92  192:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   93  195:invokespecial   #140 <Method void Matrix(int, int)>
    //   94  198:astore_3        
            for(int i = index; i < htemproleToPermission.getRowDimension() - 1; i++)
    //*  95  199:iload_1         
    //*  96  200:istore          4
    //*  97  202:goto            253
            {
                for(int j = 0; j < htemproleToPermission.getColumnDimension(); j++)
    //*  98  205:iconst_0        
    //*  99  206:istore          5
    //* 100  208:goto            238
                    htemproleToPermission.set(i, j, htemproleToPermission.get(i + 1, j));
    //  101  211:aload_0         
    //  102  212:getfield        #277 <Field Matrix htemproleToPermission>
    //  103  215:iload           4
    //  104  217:iload           5
    //  105  219:aload_0         
    //  106  220:getfield        #277 <Field Matrix htemproleToPermission>
    //  107  223:iload           4
    //  108  225:iconst_1        
    //  109  226:iadd            
    //  110  227:iload           5
    //  111  229:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  112  232:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  113  235:iinc            5  1
    //  114  238:iload           5
    //  115  240:aload_0         
    //  116  241:getfield        #277 <Field Matrix htemproleToPermission>
    //  117  244:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  118  247:icmplt          211
            }

    //  119  250:iinc            4  1
    //  120  253:iload           4
    //  121  255:aload_0         
    //  122  256:getfield        #277 <Field Matrix htemproleToPermission>
    //  123  259:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  124  262:iconst_1        
    //  125  263:isub            
    //  126  264:icmplt          205
            for(int i = 0; i < htemproleToPermission.getRowDimension() - 1; i++)
    //* 127  267:iconst_0        
    //* 128  268:istore          4
    //* 129  270:goto            316
            {
                for(int j = 0; j < htemproleToPermission.getColumnDimension(); j++)
    //* 130  273:iconst_0        
    //* 131  274:istore          5
    //* 132  276:goto            301
                    temphPA.set(i, j, htemproleToPermission.get(i, j));
    //  133  279:aload_3         
    //  134  280:iload           4
    //  135  282:iload           5
    //  136  284:aload_0         
    //  137  285:getfield        #277 <Field Matrix htemproleToPermission>
    //  138  288:iload           4
    //  139  290:iload           5
    //  140  292:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  141  295:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  142  298:iinc            5  1
    //  143  301:iload           5
    //  144  303:aload_0         
    //  145  304:getfield        #277 <Field Matrix htemproleToPermission>
    //  146  307:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  147  310:icmplt          279
            }

    //  148  313:iinc            4  1
    //  149  316:iload           4
    //  150  318:aload_0         
    //  151  319:getfield        #277 <Field Matrix htemproleToPermission>
    //  152  322:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  153  325:iconst_1        
    //  154  326:isub            
    //  155  327:icmplt          273
            htemproleToPermission = temphPA.copy();
    //  156  330:aload_0         
    //  157  331:aload_3         
    //  158  332:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  159  335:putfield        #277 <Field Matrix htemproleToPermission>
        } else
    //* 160  338:goto            581
        if(flag == 2)
    //* 161  341:iload_2         
    //* 162  342:iconst_2        
    //* 163  343:icmpne          581
        {
            Matrix temphRH = new Matrix(htemproleToRole.getRowDimension() - 1, htemproleToRole.getColumnDimension() - 1);
    //  164  346:new             #135 <Class Matrix>
    //  165  349:dup             
    //  166  350:aload_0         
    //  167  351:getfield        #281 <Field Matrix htemproleToRole>
    //  168  354:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  169  357:iconst_1        
    //  170  358:isub            
    //  171  359:aload_0         
    //  172  360:getfield        #281 <Field Matrix htemproleToRole>
    //  173  363:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  174  366:iconst_1        
    //  175  367:isub            
    //  176  368:invokespecial   #140 <Method void Matrix(int, int)>
    //  177  371:astore_3        
            for(int j = index; j < htemproleToRole.getColumnDimension() - 1; j++)
    //* 178  372:iload_1         
    //* 179  373:istore          4
    //* 180  375:goto            426
            {
                for(int i = 0; i < htemproleToRole.getRowDimension(); i++)
    //* 181  378:iconst_0        
    //* 182  379:istore          5
    //* 183  381:goto            411
                    htemproleToRole.set(i, j, htemproleToRole.get(i, j + 1));
    //  184  384:aload_0         
    //  185  385:getfield        #281 <Field Matrix htemproleToRole>
    //  186  388:iload           5
    //  187  390:iload           4
    //  188  392:aload_0         
    //  189  393:getfield        #281 <Field Matrix htemproleToRole>
    //  190  396:iload           5
    //  191  398:iload           4
    //  192  400:iconst_1        
    //  193  401:iadd            
    //  194  402:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  195  405:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  196  408:iinc            5  1
    //  197  411:iload           5
    //  198  413:aload_0         
    //  199  414:getfield        #281 <Field Matrix htemproleToRole>
    //  200  417:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  201  420:icmplt          384
            }

    //  202  423:iinc            4  1
    //  203  426:iload           4
    //  204  428:aload_0         
    //  205  429:getfield        #281 <Field Matrix htemproleToRole>
    //  206  432:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  207  435:iconst_1        
    //  208  436:isub            
    //  209  437:icmplt          378
            for(int i = index; i < htemproleToRole.getRowDimension() - 1; i++)
    //* 210  440:iload_1         
    //* 211  441:istore          4
    //* 212  443:goto            494
            {
                for(int j = 0; j < htemproleToRole.getColumnDimension(); j++)
    //* 213  446:iconst_0        
    //* 214  447:istore          5
    //* 215  449:goto            479
                    htemproleToRole.set(i, j, htemproleToRole.get(i + 1, j));
    //  216  452:aload_0         
    //  217  453:getfield        #281 <Field Matrix htemproleToRole>
    //  218  456:iload           4
    //  219  458:iload           5
    //  220  460:aload_0         
    //  221  461:getfield        #281 <Field Matrix htemproleToRole>
    //  222  464:iload           4
    //  223  466:iconst_1        
    //  224  467:iadd            
    //  225  468:iload           5
    //  226  470:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  227  473:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  228  476:iinc            5  1
    //  229  479:iload           5
    //  230  481:aload_0         
    //  231  482:getfield        #281 <Field Matrix htemproleToRole>
    //  232  485:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  233  488:icmplt          452
            }

    //  234  491:iinc            4  1
    //  235  494:iload           4
    //  236  496:aload_0         
    //  237  497:getfield        #281 <Field Matrix htemproleToRole>
    //  238  500:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  239  503:iconst_1        
    //  240  504:isub            
    //  241  505:icmplt          446
            for(int j = 0; j < htemproleToRole.getColumnDimension() - 1; j++)
    //* 242  508:iconst_0        
    //* 243  509:istore          4
    //* 244  511:goto            559
            {
                for(int i = 0; i < htemproleToRole.getRowDimension() - 1; i++)
    //* 245  514:iconst_0        
    //* 246  515:istore          5
    //* 247  517:goto            542
                    temphRH.set(i, j, htemproleToRole.get(i, j));
    //  248  520:aload_3         
    //  249  521:iload           5
    //  250  523:iload           4
    //  251  525:aload_0         
    //  252  526:getfield        #281 <Field Matrix htemproleToRole>
    //  253  529:iload           5
    //  254  531:iload           4
    //  255  533:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  256  536:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  257  539:iinc            5  1
    //  258  542:iload           5
    //  259  544:aload_0         
    //  260  545:getfield        #281 <Field Matrix htemproleToRole>
    //  261  548:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  262  551:iconst_1        
    //  263  552:isub            
    //  264  553:icmplt          520
            }

    //  265  556:iinc            4  1
    //  266  559:iload           4
    //  267  561:aload_0         
    //  268  562:getfield        #281 <Field Matrix htemproleToRole>
    //  269  565:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  270  568:iconst_1        
    //  271  569:isub            
    //  272  570:icmplt          514
            htemproleToRole = temphRH.copy();
    //  273  573:aload_0         
    //  274  574:aload_3         
    //  275  575:invokevirtual   #298 <Method Matrix Matrix.copy()>
    //  276  578:putfield        #281 <Field Matrix htemproleToRole>
        }
    //  277  581:return          
    }

    private void initHRMatrixs()
    {
        huserToRole = new Matrix(noUsers, numberOfRoles);
    //    0    0:aload_0         
    //    1    1:new             #135 <Class Matrix>
    //    2    4:dup             
    //    3    5:aload_0         
    //    4    6:getfield        #137 <Field int noUsers>
    //    5    9:getstatic       #51  <Field int numberOfRoles>
    //    6   12:invokespecial   #140 <Method void Matrix(int, int)>
    //    7   15:putfield        #271 <Field Matrix huserToRole>
        hroleToPermission = new Matrix(numberOfRoles, noPerms);
    //    8   18:aload_0         
    //    9   19:new             #135 <Class Matrix>
    //   10   22:dup             
    //   11   23:getstatic       #51  <Field int numberOfRoles>
    //   12   26:aload_0         
    //   13   27:getfield        #144 <Field int noPerms>
    //   14   30:invokespecial   #140 <Method void Matrix(int, int)>
    //   15   33:putfield        #275 <Field Matrix hroleToPermission>
        hroleToRole = new Matrix(numberOfRoles, numberOfRoles);
    //   16   36:aload_0         
    //   17   37:new             #135 <Class Matrix>
    //   18   40:dup             
    //   19   41:getstatic       #51  <Field int numberOfRoles>
    //   20   44:getstatic       #51  <Field int numberOfRoles>
    //   21   47:invokespecial   #140 <Method void Matrix(int, int)>
    //   22   50:putfield        #279 <Field Matrix hroleToRole>
        for(int index = 0; index < numberOfRoles; index++)
    //*  23   53:iconst_0        
    //*  24   54:istore_1        
    //*  25   55:goto            300
        {
            String indexPerms[] = TranslateAttributelist(((Concept)nodes.get(index)).allAttributes).split(", ");
    //   26   58:aload_0         
    //   27   59:aload_0         
    //   28   60:getfield        #474 <Field Vector nodes>
    //   29   63:iload_1         
    //   30   64:invokevirtual   #432 <Method Object Vector.get(int)>
    //   31   67:checkcast       #160 <Class Concept>
    //   32   70:getfield        #185 <Field IntegerSet Concept.allAttributes>
    //   33   73:invokevirtual   #478 <Method String TranslateAttributelist(IntegerSet)>
    //   34   76:ldc1            #170 <String ", ">
    //   35   78:invokevirtual   #91  <Method String[] String.split(String)>
    //   36   81:astore_2        
            String indexUsers[] = TranslateObjectlist(((Concept)nodes.get(index)).allObjects).split(", ");
    //   37   82:aload_0         
    //   38   83:aload_0         
    //   39   84:getfield        #474 <Field Vector nodes>
    //   40   87:iload_1         
    //   41   88:invokevirtual   #432 <Method Object Vector.get(int)>
    //   42   91:checkcast       #160 <Class Concept>
    //   43   94:getfield        #164 <Field IntegerSet Concept.allObjects>
    //   44   97:invokevirtual   #481 <Method String TranslateObjectlist(IntegerSet)>
    //   45  100:ldc1            #170 <String ", ">
    //   46  102:invokevirtual   #91  <Method String[] String.split(String)>
    //   47  105:astore_3        
            for(int jndex = 0; jndex < indexUsers.length; jndex++)
    //*  48  106:iconst_0        
    //*  49  107:istore          4
    //*  50  109:goto            169
            {
                for(int kndex = 0; kndex < useVec.size(); kndex++)
    //*  51  112:iconst_0        
    //*  52  113:istore          5
    //*  53  115:goto            154
                    if(((String)useVec.get(kndex)).equals(indexUsers[jndex]))
    //*  54  118:aload_0         
    //*  55  119:getfield        #75  <Field Vector useVec>
    //*  56  122:iload           5
    //*  57  124:invokevirtual   #432 <Method Object Vector.get(int)>
    //*  58  127:checkcast       #87  <Class String>
    //*  59  130:aload_3         
    //*  60  131:iload           4
    //*  61  133:aaload          
    //*  62  134:invokevirtual   #105 <Method boolean String.equals(Object)>
    //*  63  137:ifeq            151
                        huserToRole.set(kndex, index, (byte)1);
    //   64  140:aload_0         
    //   65  141:getfield        #271 <Field Matrix huserToRole>
    //   66  144:iload           5
    //   67  146:iload_1         
    //   68  147:iconst_1        
    //   69  148:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //   70  151:iinc            5  1
    //   71  154:iload           5
    //   72  156:aload_0         
    //   73  157:getfield        #75  <Field Vector useVec>
    //   74  160:invokevirtual   #436 <Method int Vector.size()>
    //   75  163:icmplt          118
            }

    //   76  166:iinc            4  1
    //   77  169:iload           4
    //   78  171:aload_3         
    //   79  172:arraylength     
    //   80  173:icmplt          112
            for(int jndex = 0; jndex < indexPerms.length; jndex++)
    //*  81  176:iconst_0        
    //*  82  177:istore          4
    //*  83  179:goto            239
            {
                for(int kndex = 0; kndex < perVec.size(); kndex++)
    //*  84  182:iconst_0        
    //*  85  183:istore          5
    //*  86  185:goto            224
                    if(((String)perVec.get(kndex)).equals(indexPerms[jndex]))
    //*  87  188:aload_0         
    //*  88  189:getfield        #77  <Field Vector perVec>
    //*  89  192:iload           5
    //*  90  194:invokevirtual   #432 <Method Object Vector.get(int)>
    //*  91  197:checkcast       #87  <Class String>
    //*  92  200:aload_2         
    //*  93  201:iload           4
    //*  94  203:aaload          
    //*  95  204:invokevirtual   #105 <Method boolean String.equals(Object)>
    //*  96  207:ifeq            221
                        hroleToPermission.set(index, kndex, (byte)1);
    //   97  210:aload_0         
    //   98  211:getfield        #275 <Field Matrix hroleToPermission>
    //   99  214:iload_1         
    //  100  215:iload           5
    //  101  217:iconst_1        
    //  102  218:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  103  221:iinc            5  1
    //  104  224:iload           5
    //  105  226:aload_0         
    //  106  227:getfield        #77  <Field Vector perVec>
    //  107  230:invokevirtual   #436 <Method int Vector.size()>
    //  108  233:icmplt          188
            }

    //  109  236:iinc            4  1
    //  110  239:iload           4
    //  111  241:aload_2         
    //  112  242:arraylength     
    //  113  243:icmplt          182
            ArrayList Jun = getJun(index);
    //  114  246:aload_0         
    //  115  247:iload_1         
    //  116  248:invokevirtual   #485 <Method ArrayList getJun(int)>
    //  117  251:astore          4
            for(int jndex = 0; jndex < Jun.size(); jndex++)
    //* 118  253:iconst_0        
    //* 119  254:istore          5
    //* 120  256:goto            287
                hroleToRole.set(index, ((Integer)(Integer)Jun.get(jndex)).intValue(), (byte)1);
    //  121  259:aload_0         
    //  122  260:getfield        #279 <Field Matrix hroleToRole>
    //  123  263:iload_1         
    //  124  264:aload           4
    //  125  266:iload           5
    //  126  268:invokevirtual   #433 <Method Object ArrayList.get(int)>
    //  127  271:checkcast       #107 <Class Integer>
    //  128  274:checkcast       #107 <Class Integer>
    //  129  277:invokevirtual   #176 <Method int Integer.intValue()>
    //  130  280:iconst_1        
    //  131  281:invokevirtual   #180 <Method void Matrix.set(int, int, byte)>

    //  132  284:iinc            5  1
    //  133  287:iload           5
    //  134  289:aload           4
    //  135  291:invokevirtual   #437 <Method int ArrayList.size()>
    //  136  294:icmplt          259
        }

    //  137  297:iinc            1  1
    //  138  300:iload_1         
    //  139  301:getstatic       #51  <Field int numberOfRoles>
    //  140  304:icmplt          58
    //  141  307:return          
    }

    private int getIndexMaxRole(Vector mapVector)
    {
        int index = 0x7fffffff;
    //    0    0:ldc2            #489 <Int 0x7fffffff>
    //    1    3:istore_2        
        double max = 0.0D;
    //    2    4:dconst_0        
    //    3    5:dstore_3        
        for(Iterator iterator = mapVector.iterator(); iterator.hasNext();)
    //*   4    6:aload_1         
    //*   5    7:invokevirtual   #95  <Method Iterator Vector.iterator()>
    //*   6   10:astore          6
    //*   7   12:goto            49
        {
            con2RoleIndex c2ri = (con2RoleIndex)iterator.next();
    //    8   15:aload           6
    //    9   17:invokeinterface #101 <Method Object Iterator.next()>
    //   10   22:checkcast       #395 <Class YeHRMiner$con2RoleIndex>
    //   11   25:astore          5
            if(c2ri.con >= max)
    //*  12   27:aload           5
    //*  13   29:getfield        #400 <Field double YeHRMiner$con2RoleIndex.con>
    //*  14   32:dload_3         
    //*  15   33:dcmpl           
    //*  16   34:iflt            49
            {
                max = c2ri.con;
    //   17   37:aload           5
    //   18   39:getfield        #400 <Field double YeHRMiner$con2RoleIndex.con>
    //   19   42:dstore_3        
                index = c2ri.indexRole;
    //   20   43:aload           5
    //   21   45:getfield        #403 <Field int YeHRMiner$con2RoleIndex.indexRole>
    //   22   48:istore_2        
            }
        }

    //   23   49:aload           6
    //   24   51:invokeinterface #118 <Method boolean Iterator.hasNext()>
    //   25   56:ifne            15
        return index;
    //   26   59:iload_2         
    //   27   60:ireturn         
    }

    private void printUAandPA(Matrix userToRole2, Matrix roleToPermission2, Matrix roleToRole2)
    {
        int count = 0;
    //    0    0:iconst_0        
    //    1    1:istore          4
        log.append("----------------------------------\n");
    //    2    3:aload_0         
    //    3    4:getfield        #61  <Field StringBuffer log>
    //    4    7:ldc2            #492 <String "----------------------------------\n">
    //    5   10:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //    6   13:pop             
        log.append("\u7B97\u6CD5\u7ED3\u675F\u540EUA\u4E3A: \n");
    //    7   14:aload_0         
    //    8   15:getfield        #61  <Field StringBuffer log>
    //    9   18:ldc2            #494 <String "\u7B97\u6CD5\u7ED3\u675F\u540EUA\u4E3A: \n">
    //   10   21:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //   11   24:pop             
        for(int i = 0; i < userToRole2.getRowDimension(); i++)
    //*  12   25:iconst_0        
    //*  13   26:istore          5
    //*  14   28:goto            149
        {
            for(int j = 0; j < userToRole2.getColumnDimension(); j++)
    //*  15   31:iconst_0        
    //*  16   32:istore          6
    //*  17   34:goto            137
            {
                if(userToRole2.get(i, j) == 1)
    //*  18   37:aload_1         
    //*  19   38:iload           5
    //*  20   40:iload           6
    //*  21   42:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  22   45:iconst_1        
    //*  23   46:icmpne          52
                    count++;
    //   24   49:iinc            4  1
                if(j != userToRole2.getColumnDimension() - 1)
    //*  25   52:iload           6
    //*  26   54:aload_1         
    //*  27   55:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //*  28   58:iconst_1        
    //*  29   59:isub            
    //*  30   60:icmpeq          100
                    log.append((new StringBuilder(String.valueOf(userToRole2.get(i, j)))).append(",").toString());
    //   31   63:aload_0         
    //   32   64:getfield        #61  <Field StringBuffer log>
    //   33   67:new             #196 <Class StringBuilder>
    //   34   70:dup             
    //   35   71:aload_1         
    //   36   72:iload           5
    //   37   74:iload           6
    //   38   76:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   39   79:invokestatic    #203 <Method String String.valueOf(int)>
    //   40   82:invokespecial   #206 <Method void StringBuilder(String)>
    //   41   85:ldc1            #208 <String ",">
    //   42   87:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   43   90:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   44   93:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //   45   96:pop             
                else
    //*  46   97:goto            134
                    log.append((new StringBuilder(String.valueOf(userToRole2.get(i, j)))).append("\n").toString());
    //   47  100:aload_0         
    //   48  101:getfield        #61  <Field StringBuffer log>
    //   49  104:new             #196 <Class StringBuilder>
    //   50  107:dup             
    //   51  108:aload_1         
    //   52  109:iload           5
    //   53  111:iload           6
    //   54  113:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //   55  116:invokestatic    #203 <Method String String.valueOf(int)>
    //   56  119:invokespecial   #206 <Method void StringBuilder(String)>
    //   57  122:ldc1            #217 <String "\n">
    //   58  124:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   59  127:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   60  130:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //   61  133:pop             
            }

    //   62  134:iinc            6  1
    //   63  137:iload           6
    //   64  139:aload_1         
    //   65  140:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   66  143:icmplt          37
        }

    //   67  146:iinc            5  1
    //   68  149:iload           5
    //   69  151:aload_1         
    //   70  152:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   71  155:icmplt          31
        log.append("---------------------------------\n");
    //   72  158:aload_0         
    //   73  159:getfield        #61  <Field StringBuffer log>
    //   74  162:ldc2            #496 <String "---------------------------------\n">
    //   75  165:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //   76  168:pop             
        log.append("\u7B97\u6CD5\u7ED3\u675F\u540ERH\u4E3A: \n");
    //   77  169:aload_0         
    //   78  170:getfield        #61  <Field StringBuffer log>
    //   79  173:ldc2            #498 <String "\u7B97\u6CD5\u7ED3\u675F\u540ERH\u4E3A: \n">
    //   80  176:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //   81  179:pop             
        for(int i = 0; i < roleToRole2.getRowDimension(); i++)
    //*  82  180:iconst_0        
    //*  83  181:istore          5
    //*  84  183:goto            304
        {
            for(int j = 0; j < roleToRole2.getColumnDimension(); j++)
    //*  85  186:iconst_0        
    //*  86  187:istore          6
    //*  87  189:goto            292
            {
                if(roleToRole2.get(i, j) == 1)
    //*  88  192:aload_3         
    //*  89  193:iload           5
    //*  90  195:iload           6
    //*  91  197:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  92  200:iconst_1        
    //*  93  201:icmpne          207
                    count++;
    //   94  204:iinc            4  1
                if(j != roleToRole2.getColumnDimension() - 1)
    //*  95  207:iload           6
    //*  96  209:aload_3         
    //*  97  210:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //*  98  213:iconst_1        
    //*  99  214:isub            
    //* 100  215:icmpeq          255
                    log.append((new StringBuilder(String.valueOf(roleToRole2.get(i, j)))).append(",").toString());
    //  101  218:aload_0         
    //  102  219:getfield        #61  <Field StringBuffer log>
    //  103  222:new             #196 <Class StringBuilder>
    //  104  225:dup             
    //  105  226:aload_3         
    //  106  227:iload           5
    //  107  229:iload           6
    //  108  231:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  109  234:invokestatic    #203 <Method String String.valueOf(int)>
    //  110  237:invokespecial   #206 <Method void StringBuilder(String)>
    //  111  240:ldc1            #208 <String ",">
    //  112  242:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  113  245:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  114  248:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  115  251:pop             
                else
    //* 116  252:goto            289
                    log.append((new StringBuilder(String.valueOf(roleToRole2.get(i, j)))).append("\n").toString());
    //  117  255:aload_0         
    //  118  256:getfield        #61  <Field StringBuffer log>
    //  119  259:new             #196 <Class StringBuilder>
    //  120  262:dup             
    //  121  263:aload_3         
    //  122  264:iload           5
    //  123  266:iload           6
    //  124  268:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  125  271:invokestatic    #203 <Method String String.valueOf(int)>
    //  126  274:invokespecial   #206 <Method void StringBuilder(String)>
    //  127  277:ldc1            #217 <String "\n">
    //  128  279:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  129  282:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  130  285:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  131  288:pop             
            }

    //  132  289:iinc            6  1
    //  133  292:iload           6
    //  134  294:aload_3         
    //  135  295:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  136  298:icmplt          192
        }

    //  137  301:iinc            5  1
    //  138  304:iload           5
    //  139  306:aload_3         
    //  140  307:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  141  310:icmplt          186
        log.append("----------------------------------\n");
    //  142  313:aload_0         
    //  143  314:getfield        #61  <Field StringBuffer log>
    //  144  317:ldc2            #492 <String "----------------------------------\n">
    //  145  320:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  146  323:pop             
        log.append("\u7B97\u6CD5\u7ED3\u675F\u540EPA\u4E3A: \n");
    //  147  324:aload_0         
    //  148  325:getfield        #61  <Field StringBuffer log>
    //  149  328:ldc2            #500 <String "\u7B97\u6CD5\u7ED3\u675F\u540EPA\u4E3A: \n">
    //  150  331:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  151  334:pop             
        for(int i = 0; i < roleToPermission2.getRowDimension(); i++)
    //* 152  335:iconst_0        
    //* 153  336:istore          5
    //* 154  338:goto            459
        {
            for(int j = 0; j < roleToPermission2.getColumnDimension(); j++)
    //* 155  341:iconst_0        
    //* 156  342:istore          6
    //* 157  344:goto            447
            {
                if(roleToPermission2.get(i, j) == 1)
    //* 158  347:aload_2         
    //* 159  348:iload           5
    //* 160  350:iload           6
    //* 161  352:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //* 162  355:iconst_1        
    //* 163  356:icmpne          362
                    count++;
    //  164  359:iinc            4  1
                if(j != roleToPermission2.getColumnDimension() - 1)
    //* 165  362:iload           6
    //* 166  364:aload_2         
    //* 167  365:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //* 168  368:iconst_1        
    //* 169  369:isub            
    //* 170  370:icmpeq          410
                    log.append((new StringBuilder(String.valueOf(roleToPermission2.get(i, j)))).append(",").toString());
    //  171  373:aload_0         
    //  172  374:getfield        #61  <Field StringBuffer log>
    //  173  377:new             #196 <Class StringBuilder>
    //  174  380:dup             
    //  175  381:aload_2         
    //  176  382:iload           5
    //  177  384:iload           6
    //  178  386:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  179  389:invokestatic    #203 <Method String String.valueOf(int)>
    //  180  392:invokespecial   #206 <Method void StringBuilder(String)>
    //  181  395:ldc1            #208 <String ",">
    //  182  397:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  183  400:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  184  403:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  185  406:pop             
                else
    //* 186  407:goto            444
                    log.append((new StringBuilder(String.valueOf(roleToPermission2.get(i, j)))).append("\n").toString());
    //  187  410:aload_0         
    //  188  411:getfield        #61  <Field StringBuffer log>
    //  189  414:new             #196 <Class StringBuilder>
    //  190  417:dup             
    //  191  418:aload_2         
    //  192  419:iload           5
    //  193  421:iload           6
    //  194  423:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //  195  426:invokestatic    #203 <Method String String.valueOf(int)>
    //  196  429:invokespecial   #206 <Method void StringBuilder(String)>
    //  197  432:ldc1            #217 <String "\n">
    //  198  434:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  199  437:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  200  440:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  201  443:pop             
            }

    //  202  444:iinc            6  1
    //  203  447:iload           6
    //  204  449:aload_2         
    //  205  450:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  206  453:icmplt          347
        }

    //  207  456:iinc            5  1
    //  208  459:iload           5
    //  209  461:aload_2         
    //  210  462:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  211  465:icmplt          341
        log.append("----------------------------------\n");
    //  212  468:aload_0         
    //  213  469:getfield        #61  <Field StringBuffer log>
    //  214  472:ldc2            #492 <String "----------------------------------\n">
    //  215  475:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  216  478:pop             
        log.append((new StringBuilder("All the roles : ")).append(roleToPermission2.getRowDimension()).append("\n").toString());
    //  217  479:aload_0         
    //  218  480:getfield        #61  <Field StringBuffer log>
    //  219  483:new             #196 <Class StringBuilder>
    //  220  486:dup             
    //  221  487:ldc2            #502 <String "All the roles : ">
    //  222  490:invokespecial   #206 <Method void StringBuilder(String)>
    //  223  493:aload_2         
    //  224  494:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  225  497:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  226  500:ldc1            #217 <String "\n">
    //  227  502:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  228  505:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  229  508:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  230  511:pop             
        for(int i = 0; i < roleToPermission2.getRowDimension(); i++)
    //* 231  512:iconst_0        
    //* 232  513:istore          5
    //* 233  515:goto            707
        {
            log.append((new StringBuilder(String.valueOf(i))).append(" :  ").toString());
    //  234  518:aload_0         
    //  235  519:getfield        #61  <Field StringBuffer log>
    //  236  522:new             #196 <Class StringBuilder>
    //  237  525:dup             
    //  238  526:iload           5
    //  239  528:invokestatic    #203 <Method String String.valueOf(int)>
    //  240  531:invokespecial   #206 <Method void StringBuilder(String)>
    //  241  534:ldc2            #504 <String " :  ">
    //  242  537:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  243  540:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  244  543:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  245  546:pop             
            Vector iUsers = new Vector();
    //  246  547:new             #72  <Class Vector>
    //  247  550:dup             
    //  248  551:invokespecial   #73  <Method void Vector()>
    //  249  554:astore          6
            for(int j = 0; j < userToRole2.getRowDimension(); j++)
    //* 250  556:iconst_0        
    //* 251  557:istore          7
    //* 252  559:goto            595
                if(userToRole2.get(j, i) == 1)
    //* 253  562:aload_1         
    //* 254  563:iload           7
    //* 255  565:iload           5
    //* 256  567:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //* 257  570:iconst_1        
    //* 258  571:icmpne          592
                    iUsers.add((String)useVec.get(j));
    //  259  574:aload           6
    //  260  576:aload_0         
    //  261  577:getfield        #75  <Field Vector useVec>
    //  262  580:iload           7
    //  263  582:invokevirtual   #432 <Method Object Vector.get(int)>
    //  264  585:checkcast       #87  <Class String>
    //  265  588:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //  266  591:pop             

    //  267  592:iinc            7  1
    //  268  595:iload           7
    //  269  597:aload_1         
    //  270  598:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  271  601:icmplt          562
            Vector iPerms = new Vector();
    //  272  604:new             #72  <Class Vector>
    //  273  607:dup             
    //  274  608:invokespecial   #73  <Method void Vector()>
    //  275  611:astore          7
            for(int j = 0; j < roleToPermission2.getColumnDimension(); j++)
    //* 276  613:iconst_0        
    //* 277  614:istore          8
    //* 278  616:goto            652
                if(roleToPermission2.get(i, j) == 1)
    //* 279  619:aload_2         
    //* 280  620:iload           5
    //* 281  622:iload           8
    //* 282  624:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //* 283  627:iconst_1        
    //* 284  628:icmpne          649
                    iPerms.add((String)perVec.get(j));
    //  285  631:aload           7
    //  286  633:aload_0         
    //  287  634:getfield        #77  <Field Vector perVec>
    //  288  637:iload           8
    //  289  639:invokevirtual   #432 <Method Object Vector.get(int)>
    //  290  642:checkcast       #87  <Class String>
    //  291  645:invokevirtual   #114 <Method boolean Vector.add(Object)>
    //  292  648:pop             

    //  293  649:iinc            8  1
    //  294  652:iload           8
    //  295  654:aload_2         
    //  296  655:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  297  658:icmplt          619
            log.append((new StringBuilder("{")).append(iUsers).append(";").append(iPerms).append("}\n").toString());
    //  298  661:aload_0         
    //  299  662:getfield        #61  <Field StringBuffer log>
    //  300  665:new             #196 <Class StringBuilder>
    //  301  668:dup             
    //  302  669:ldc2            #506 <String "{">
    //  303  672:invokespecial   #206 <Method void StringBuilder(String)>
    //  304  675:aload           6
    //  305  677:invokevirtual   #509 <Method StringBuilder StringBuilder.append(Object)>
    //  306  680:ldc2            #511 <String ";">
    //  307  683:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  308  686:aload           7
    //  309  688:invokevirtual   #509 <Method StringBuilder StringBuilder.append(Object)>
    //  310  691:ldc2            #513 <String "}\n">
    //  311  694:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  312  697:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  313  700:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  314  703:pop             
        }

    //  315  704:iinc            5  1
    //  316  707:iload           5
    //  317  709:aload_2         
    //  318  710:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  319  713:icmplt          518
        log.append("\n--------------------------------------------------------\n");
    //  320  716:aload_0         
    //  321  717:getfield        #61  <Field StringBuffer log>
    //  322  720:ldc2            #515 <String "\n--------------------------------------------------------\n">
    //  323  723:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  324  726:pop             
        log.append("---------------------------------\n");
    //  325  727:aload_0         
    //  326  728:getfield        #61  <Field StringBuffer log>
    //  327  731:ldc2            #496 <String "---------------------------------\n">
    //  328  734:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  329  737:pop             
        log.append((new StringBuilder("\u89D2\u8272\u6570\u4E3A: ")).append(userToRole2.getColumnDimension()).append("\n").toString());
    //  330  738:aload_0         
    //  331  739:getfield        #61  <Field StringBuffer log>
    //  332  742:new             #196 <Class StringBuilder>
    //  333  745:dup             
    //  334  746:ldc2            #517 <String "\u89D2\u8272\u6570\u4E3A: ">
    //  335  749:invokespecial   #206 <Method void StringBuilder(String)>
    //  336  752:aload_1         
    //  337  753:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  338  756:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  339  759:ldc1            #217 <String "\n">
    //  340  761:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  341  764:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  342  767:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  343  770:pop             
        log.append((new StringBuilder("\u635F\u8017\u4E3A: ")).append(afterwsc.loss).append("\n").toString());
    //  344  771:aload_0         
    //  345  772:getfield        #61  <Field StringBuffer log>
    //  346  775:new             #196 <Class StringBuilder>
    //  347  778:dup             
    //  348  779:ldc2            #519 <String "\u635F\u8017\u4E3A: ">
    //  349  782:invokespecial   #206 <Method void StringBuilder(String)>
    //  350  785:aload_0         
    //  351  786:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  352  789:getfield        #253 <Field int YeHRMiner$HWSC.loss>
    //  353  792:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  354  795:ldc1            #217 <String "\n">
    //  355  797:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  356  800:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  357  803:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  358  806:pop             
        log.append((new StringBuilder("\u8FB9\u6570\u4E3A: ")).append(afterwsc.edges).append("\n").toString());
    //  359  807:aload_0         
    //  360  808:getfield        #61  <Field StringBuffer log>
    //  361  811:new             #196 <Class StringBuilder>
    //  362  814:dup             
    //  363  815:ldc2            #521 <String "\u8FB9\u6570\u4E3A: ">
    //  364  818:invokespecial   #206 <Method void StringBuilder(String)>
    //  365  821:aload_0         
    //  366  822:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  367  825:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //  368  828:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  369  831:ldc1            #217 <String "\n">
    //  370  833:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  371  836:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  372  839:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  373  842:pop             
        log.append((new StringBuilder("\u76F4\u63A5\u8BA1\u7B97\u8FB9\u6570\u4E3A\uFF1A")).append(count).append("\n").toString());
    //  374  843:aload_0         
    //  375  844:getfield        #61  <Field StringBuffer log>
    //  376  847:new             #196 <Class StringBuilder>
    //  377  850:dup             
    //  378  851:ldc2            #523 <String "\u76F4\u63A5\u8BA1\u7B97\u8FB9\u6570\u4E3A\uFF1A">
    //  379  854:invokespecial   #206 <Method void StringBuilder(String)>
    //  380  857:iload           4
    //  381  859:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  382  862:ldc1            #217 <String "\n">
    //  383  864:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  384  867:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  385  870:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  386  873:pop             
        log.append((new StringBuilder("WSC\u4E3A: ")).append(userToRole2.getColumnDimension() + afterwsc.edges).append("\n").toString());
    //  387  874:aload_0         
    //  388  875:getfield        #61  <Field StringBuffer log>
    //  389  878:new             #196 <Class StringBuilder>
    //  390  881:dup             
    //  391  882:ldc2            #525 <String "WSC\u4E3A: ">
    //  392  885:invokespecial   #206 <Method void StringBuilder(String)>
    //  393  888:aload_1         
    //  394  889:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //  395  892:aload_0         
    //  396  893:getfield        #70  <Field YeHRMiner$HWSC afterwsc>
    //  397  896:getfield        #250 <Field int YeHRMiner$HWSC.edges>
    //  398  899:iadd            
    //  399  900:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //  400  903:ldc1            #217 <String "\n">
    //  401  905:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //  402  908:invokevirtual   #215 <Method String StringBuilder.toString()>
    //  403  911:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  404  914:pop             
        log.append("---------------------------------\n");
    //  405  915:aload_0         
    //  406  916:getfield        #61  <Field StringBuffer log>
    //  407  919:ldc2            #496 <String "---------------------------------\n">
    //  408  922:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //  409  925:pop             
    //  410  926:return          
    }

    public String getNameList(String obj[], IntegerSet nameIndexes)
    {
        String result = "";
    //    0    0:ldc2            #530 <String "">
    //    1    3:astore_3        
        for(int i = 0; i < obj.length; i++)
    //*   2    4:iconst_0        
    //*   3    5:istore          4
    //*   4    7:goto            49
            if(nameIndexes.contains(i))
    //*   5   10:aload_2         
    //*   6   11:iload           4
    //*   7   13:invokevirtual   #536 <Method boolean IntegerSet.contains(int)>
    //*   8   16:ifeq            46
                result = (new StringBuilder(String.valueOf(result))).append(obj[i]).append(", ").toString();
    //    9   19:new             #196 <Class StringBuilder>
    //   10   22:dup             
    //   11   23:aload_3         
    //   12   24:invokestatic    #539 <Method String String.valueOf(Object)>
    //   13   27:invokespecial   #206 <Method void StringBuilder(String)>
    //   14   30:aload_1         
    //   15   31:iload           4
    //   16   33:aaload          
    //   17   34:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   18   37:ldc1            #170 <String ", ">
    //   19   39:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   20   42:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   21   45:astore_3        

    //   22   46:iinc            4  1
    //   23   49:iload           4
    //   24   51:aload_1         
    //   25   52:arraylength     
    //   26   53:icmplt          10
        if(result != "")
    //*  27   56:aload_3         
    //*  28   57:ldc2            #530 <String "">
    //*  29   60:if_acmpeq       75
            result = result.substring(0, result.length() - 2);
    //   30   63:aload_3         
    //   31   64:iconst_0        
    //   32   65:aload_3         
    //   33   66:invokevirtual   #542 <Method int String.length()>
    //   34   69:iconst_2        
    //   35   70:isub            
    //   36   71:invokevirtual   #546 <Method String String.substring(int, int)>
    //   37   74:astore_3        
        return result;
    //   38   75:aload_3         
    //   39   76:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #309 <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #552 <Method void Assignment()>
    //    4    8:putfield        #554 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #554 <Field Assignment m_assroles>
    //    7   15:ldc2            #556 <String "role-permission">
    //    8   18:invokevirtual   #559 <Method void Assignment.setAssignementName(String)>
        m_assroles.setAssignmentMatrix(hroleToPermission);
    //    9   21:aload_0         
    //   10   22:getfield        #554 <Field Assignment m_assroles>
    //   11   25:aload_0         
    //   12   26:getfield        #275 <Field Matrix hroleToPermission>
    //   13   29:invokevirtual   #563 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   14   32:new             #565 <Class FastVector>
    //   15   35:dup             
    //   16   36:invokespecial   #566 <Method void FastVector()>
    //   17   39:astore_1        
        for(int i = 0; i < hroleToPermission.getRowDimension(); i++)
    //*  18   40:iconst_0        
    //*  19   41:istore_2        
    //*  20   42:goto            69
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   21   45:aload_1         
    //   22   46:new             #196 <Class StringBuilder>
    //   23   49:dup             
    //   24   50:ldc2            #567 <String "R">
    //   25   53:invokespecial   #206 <Method void StringBuilder(String)>
    //   26   56:iload_2         
    //   27   57:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   28   60:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   29   63:invokevirtual   #571 <Method void FastVector.addElement(Object)>

    //   30   66:iinc            2  1
    //   31   69:iload_2         
    //   32   70:aload_0         
    //   33   71:getfield        #275 <Field Matrix hroleToPermission>
    //   34   74:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   35   77:icmplt          45
        Attribute dxa = new Attribute("role", fv);
    //   36   80:new             #321 <Class Attribute>
    //   37   83:dup             
    //   38   84:ldc2            #573 <String "role">
    //   39   87:aload_1         
    //   40   88:invokespecial   #576 <Method void Attribute(String, FastVector)>
    //   41   91:astore_2        
        Dimension dx = new Dimension();
    //   42   92:new             #315 <Class Dimension>
    //   43   95:dup             
    //   44   96:invokespecial   #577 <Method void Dimension()>
    //   45   99:astore_3        
        dx.setDimensionAttribute(dxa);
    //   46  100:aload_3         
    //   47  101:aload_2         
    //   48  102:invokevirtual   #581 <Method void Dimension.setDimensionAttribute(Attribute)>
        StringBuffer parents[] = new StringBuffer[hroleToRole.getRowDimension()];
    //   49  105:aload_0         
    //   50  106:getfield        #279 <Field Matrix hroleToRole>
    //   51  109:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   52  112:anewarray       StringBuffer[]
    //   53  115:astore          4
        for(int i = 0; i < hroleToRole.getRowDimension(); i++)
    //*  54  117:iconst_0        
    //*  55  118:istore          5
    //*  56  120:goto            204
        {
            parents[i] = new StringBuffer();
    //   57  123:aload           4
    //   58  125:iload           5
    //   59  127:new             #58  <Class StringBuffer>
    //   60  130:dup             
    //   61  131:invokespecial   #59  <Method void StringBuffer()>
    //   62  134:aastore         
            for(int j = 0; j < hroleToRole.getColumnDimension(); j++)
    //*  63  135:iconst_0        
    //*  64  136:istore          6
    //*  65  138:goto            189
                if(hroleToRole.get(i, j) == 1)
    //*  66  141:aload_0         
    //*  67  142:getfield        #279 <Field Matrix hroleToRole>
    //*  68  145:iload           5
    //*  69  147:iload           6
    //*  70  149:invokevirtual   #200 <Method byte Matrix.get(int, int)>
    //*  71  152:iconst_1        
    //*  72  153:icmpne          186
                    parents[i].append((new StringBuilder(String.valueOf(j))).append("|").toString());
    //   73  156:aload           4
    //   74  158:iload           5
    //   75  160:aaload          
    //   76  161:new             #196 <Class StringBuilder>
    //   77  164:dup             
    //   78  165:iload           6
    //   79  167:invokestatic    #203 <Method String String.valueOf(int)>
    //   80  170:invokespecial   #206 <Method void StringBuilder(String)>
    //   81  173:ldc2            #583 <String "|">
    //   82  176:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   83  179:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   84  182:invokevirtual   #194 <Method StringBuffer StringBuffer.append(String)>
    //   85  185:pop             

    //   86  186:iinc            6  1
    //   87  189:iload           6
    //   88  191:aload_0         
    //   89  192:getfield        #279 <Field Matrix hroleToRole>
    //   90  195:invokevirtual   #228 <Method int Matrix.getColumnDimension()>
    //   91  198:icmplt          141
        }

    //   92  201:iinc            5  1
    //   93  204:iload           5
    //   94  206:aload_0         
    //   95  207:getfield        #279 <Field Matrix hroleToRole>
    //   96  210:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //   97  213:icmplt          123
        for(int i = 0; i < hroleToRole.getRowDimension(); i++)
    //*  98  216:iconst_0        
    //*  99  217:istore          5
    //* 100  219:goto            256
            if(parents[i].length() > 1)
    //* 101  222:aload           4
    //* 102  224:iload           5
    //* 103  226:aaload          
    //* 104  227:invokevirtual   #584 <Method int StringBuffer.length()>
    //* 105  230:iconst_1        
    //* 106  231:icmple          253
                parents[i].deleteCharAt(parents[i].length() - 1);
    //  107  234:aload           4
    //  108  236:iload           5
    //  109  238:aaload          
    //  110  239:aload           4
    //  111  241:iload           5
    //  112  243:aaload          
    //  113  244:invokevirtual   #584 <Method int StringBuffer.length()>
    //  114  247:iconst_1        
    //  115  248:isub            
    //  116  249:invokevirtual   #588 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //  117  252:pop             

    //  118  253:iinc            5  1
    //  119  256:iload           5
    //  120  258:aload_0         
    //  121  259:getfield        #279 <Field Matrix hroleToRole>
    //  122  262:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  123  265:icmplt          222
        Attribute att = new Attribute("parents", null);
    //  124  268:new             #321 <Class Attribute>
    //  125  271:dup             
    //  126  272:ldc2            #590 <String "parents">
    //  127  275:aconst_null     
    //  128  276:invokespecial   #576 <Method void Attribute(String, FastVector)>
    //  129  279:astore          5
        FastVector fv_atts = new FastVector();
    //  130  281:new             #565 <Class FastVector>
    //  131  284:dup             
    //  132  285:invokespecial   #566 <Method void FastVector()>
    //  133  288:astore          6
        fv_atts.addElement(att);
    //  134  290:aload           6
    //  135  292:aload           5
    //  136  294:invokevirtual   #571 <Method void FastVector.addElement(Object)>
        Instances insSet = new Instances("role", fv_atts, 0);
    //  137  297:new             #592 <Class Instances>
    //  138  300:dup             
    //  139  301:ldc2            #573 <String "role">
    //  140  304:aload           6
    //  141  306:iconst_0        
    //  142  307:invokespecial   #595 <Method void Instances(String, FastVector, int)>
    //  143  310:astore          7
        for(int i = 0; i < hroleToRole.getRowDimension(); i++)
    //* 144  312:iconst_0        
    //* 145  313:istore          8
    //* 146  315:goto            360
        {
            Instance insi = new Instance(1);
    //  147  318:new             #597 <Class Instance>
    //  148  321:dup             
    //  149  322:iconst_1        
    //  150  323:invokespecial   #599 <Method void Instance(int)>
    //  151  326:astore          9
            insi.setDataset(insSet);
    //  152  328:aload           9
    //  153  330:aload           7
    //  154  332:invokevirtual   #603 <Method void Instance.setDataset(Instances)>
            insi.setValue(att, parents[i].toString());
    //  155  335:aload           9
    //  156  337:aload           5
    //  157  339:aload           4
    //  158  341:iload           8
    //  159  343:aaload          
    //  160  344:invokevirtual   #604 <Method String StringBuffer.toString()>
    //  161  347:invokevirtual   #608 <Method void Instance.setValue(Attribute, String)>
            insSet.add(insi);
    //  162  350:aload           7
    //  163  352:aload           9
    //  164  354:invokevirtual   #611 <Method void Instances.add(Instance)>
        }

    //  165  357:iinc            8  1
    //  166  360:iload           8
    //  167  362:aload_0         
    //  168  363:getfield        #279 <Field Matrix hroleToRole>
    //  169  366:invokevirtual   #260 <Method int Matrix.getRowDimension()>
    //  170  369:icmplt          318
        dx.setDimensionInstances(insSet);
    //  171  372:aload_3         
    //  172  373:aload           7
    //  173  375:invokevirtual   #614 <Method void Dimension.setDimensionInstances(Instances)>
        m_assroles.setDimensionX(dx);
    //  174  378:aload_0         
    //  175  379:getfield        #554 <Field Assignment m_assroles>
    //  176  382:aload_3         
    //  177  383:invokevirtual   #618 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //  178  386:aload_0         
    //  179  387:getfield        #307 <Field Assignment m_assignment>
    //  180  390:invokevirtual   #328 <Method Dimension Assignment.getDimensionY()>
    //  181  393:invokevirtual   #319 <Method Attribute Dimension.getDimensionAttribute()>
    //  182  396:astore          8
        Dimension dy = new Dimension();
    //  183  398:new             #315 <Class Dimension>
    //  184  401:dup             
    //  185  402:invokespecial   #577 <Method void Dimension()>
    //  186  405:astore          9
        dy.setDimensionAttribute(dya);
    //  187  407:aload           9
    //  188  409:aload           8
    //  189  411:invokevirtual   #581 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  190  414:aload_0         
    //  191  415:getfield        #554 <Field Assignment m_assroles>
    //  192  418:aload           9
    //  193  420:invokevirtual   #621 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  194  423:aload_0         
    //  195  424:getfield        #554 <Field Assignment m_assroles>
    //  196  427:areturn         
    }

    public void resetOptions()
    {
        wr = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #344 <Field int wr>
        wu = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #346 <Field int wu>
        wp = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #348 <Field int wp>
        wh = 1;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #350 <Field int wh>
        wd = 1;
    //   12   20:aload_0         
    //   13   21:iconst_1        
    //   14   22:putfield        #638 <Field int wd>
    //   15   25:return          
    }

    public String globalInfo()
    {
        return "YeHR use the theory of formal concept analysis \nprovides a solid theoretical foundation for mining \n roles from userpermission relation. \n";
    //    0    0:ldc2            #641 <String "YeHR use the theory of formal concept analysis \nprovides a solid theoretical foundation for mining \n roles from userpermission relation. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #645 <Method Capabilities ReducedLattices.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #650 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #656 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #660 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #663 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #660 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #666 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #660 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #669 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #660 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #672 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #660 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of number of role for WSC. (default = ")).append(wr).append(")").toString();
    //    0    0:new             #196 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #677 <String "\tRequired weight of number of role for WSC. (default = ">
    //    3    7:invokespecial   #206 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #344 <Field int wr>
    //    6   14:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #679 <String ")">
    //    8   20:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired weight of number of user for WSC. (default = ")).append(wu).append(")").toString();
    //   11   27:new             #196 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #681 <String "\tRequired weight of number of user for WSC. (default = ">
    //   14   34:invokespecial   #206 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #346 <Field int wu>
    //   17   41:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #679 <String ")">
    //   19   47:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired weight of number of permission for WSC. (default = ")).append(wp).append(")").toString();
    //   22   54:new             #196 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #683 <String "\tRequired weight of number of permission for WSC. (default = ">
    //   25   61:invokespecial   #206 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #348 <Field int wp>
    //   28   68:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #679 <String ")">
    //   30   74:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired weight of number of roles' hierarchy for WSC. (default = ")).append(wh).append(")").toString();
    //   33   81:new             #196 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #685 <String "\tRequired weight of number of roles' hierarchy for WSC. (default = ">
    //   36   88:invokespecial   #206 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #350 <Field int wh>
    //   39   95:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #679 <String ")">
    //   41  101:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        FastVector newVector = new FastVector(4);
    //   44  109:new             #565 <Class FastVector>
    //   45  112:dup             
    //   46  113:iconst_4        
    //   47  114:invokespecial   #686 <Method void FastVector(int)>
    //   48  117:astore          5
        newVector.addElement(new Option(string1, "R", wr, "-R <required weight of number of role>"));
    //   49  119:aload           5
    //   50  121:new             #688 <Class Option>
    //   51  124:dup             
    //   52  125:aload_1         
    //   53  126:ldc2            #567 <String "R">
    //   54  129:aload_0         
    //   55  130:getfield        #344 <Field int wr>
    //   56  133:ldc2            #690 <String "-R <required weight of number of role>">
    //   57  136:invokespecial   #693 <Method void Option(String, String, int, String)>
    //   58  139:invokevirtual   #571 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "U", wu, "-U <required weight of number of user>"));
    //   59  142:aload           5
    //   60  144:new             #688 <Class Option>
    //   61  147:dup             
    //   62  148:aload_2         
    //   63  149:ldc2            #695 <String "U">
    //   64  152:aload_0         
    //   65  153:getfield        #346 <Field int wu>
    //   66  156:ldc2            #697 <String "-U <required weight of number of user>">
    //   67  159:invokespecial   #693 <Method void Option(String, String, int, String)>
    //   68  162:invokevirtual   #571 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", wp, "-P <required weight of number of permission>"));
    //   69  165:aload           5
    //   70  167:new             #688 <Class Option>
    //   71  170:dup             
    //   72  171:aload_3         
    //   73  172:ldc2            #699 <String "P">
    //   74  175:aload_0         
    //   75  176:getfield        #348 <Field int wp>
    //   76  179:ldc2            #701 <String "-P <required weight of number of permission>">
    //   77  182:invokespecial   #693 <Method void Option(String, String, int, String)>
    //   78  185:invokevirtual   #571 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "H", wh, "-H <required weight of number of roles' hierarchy>"));
    //   79  188:aload           5
    //   80  190:new             #688 <Class Option>
    //   81  193:dup             
    //   82  194:aload           4
    //   83  196:ldc2            #703 <String "H">
    //   84  199:aload_0         
    //   85  200:getfield        #350 <Field int wh>
    //   86  203:ldc2            #705 <String "-H <required weight of number of roles' hierarchy>">
    //   87  206:invokespecial   #693 <Method void Option(String, String, int, String)>
    //   88  209:invokevirtual   #571 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   89  212:aload           5
    //   90  214:invokevirtual   #708 <Method Enumeration FastVector.elements()>
    //   91  217:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #80  <Method void resetOptions()>
        String s_wr = Utils.getOption('R', options);
    //    2    4:bipush          82
    //    3    6:aload_1         
    //    4    7:invokestatic    #721 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #542 <Method int String.length()>
    //*   8   15:ifeq            26
            wr = Integer.parseInt(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #725 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #344 <Field int wr>
        String s_wu = Utils.getOption('U', options);
    //   13   26:bipush          85
    //   14   28:aload_1         
    //   15   29:invokestatic    #721 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wu.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #542 <Method int String.length()>
    //*  19   37:ifeq            48
            wu = Integer.parseInt(s_wu);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #725 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #346 <Field int wu>
        String s_wp = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #721 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wp.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #542 <Method int String.length()>
    //*  30   61:ifeq            73
            wp = Integer.parseInt(s_wp);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #725 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #348 <Field int wp>
        String s_wh = Utils.getOption('H', options);
    //   35   73:bipush          72
    //   36   75:aload_1         
    //   37   76:invokestatic    #721 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wu.length() != 0)
    //*  39   81:aload_3         
    //*  40   82:invokevirtual   #542 <Method int String.length()>
    //*  41   85:ifeq            97
            wh = Integer.parseInt(s_wh);
    //   42   88:aload_0         
    //   43   89:aload           5
    //   44   91:invokestatic    #725 <Method int Integer.parseInt(String)>
    //   45   94:putfield        #350 <Field int wh>
    //   46   97:return          
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
        options[current++] = "-R";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #733 <String "-R">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(wr).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #196 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #734 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #344 <Field int wr>
    //   18   33:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-U";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #736 <String "-U">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(wu).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #196 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #734 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #346 <Field int wu>
    //   34   65:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #738 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(wp).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #196 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #734 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #348 <Field int wp>
    //   50   97:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-H";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #740 <String "-H">
    //   57  112:aastore         
        for(options[current++] = (new StringBuilder()).append(wh).toString(); current < options.length; options[current++] = "");
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #196 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #734 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #350 <Field int wh>
    //   66  129:invokevirtual   #382 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   68  135:aastore         
    //   69  136:goto            148
    //   70  139:aload_1         
    //   71  140:iload_2         
    //   72  141:iinc            2  1
    //   73  144:ldc2            #530 <String "">
    //   74  147:aastore         
    //   75  148:iload_2         
    //   76  149:aload_1         
    //   77  150:arraylength     
    //   78  151:icmplt          139
        return options;
    //   79  154:aload_1         
    //   80  155:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field StringBuffer log>
    //    2    4:invokevirtual   #604 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public int getWr()
    {
        return wr;
    //    0    0:aload_0         
    //    1    1:getfield        #344 <Field int wr>
    //    2    4:ireturn         
    }

    public void setWr(int wr)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #344 <Field int wr>
    //    3    5:return          
    }

    public String wrTipText()
    {
        return "The required weight of number of role for WSC.";
    //    0    0:ldc2            #746 <String "The required weight of number of role for WSC.">
    //    1    3:areturn         
    }

    public int getWu()
    {
        return wu;
    //    0    0:aload_0         
    //    1    1:getfield        #346 <Field int wu>
    //    2    4:ireturn         
    }

    public void setWu(int wu)
    {
        this.wu = wu;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #346 <Field int wu>
    //    3    5:return          
    }

    public String wuTipText()
    {
        return "The required weight of number of user for WSC.";
    //    0    0:ldc2            #751 <String "The required weight of number of user for WSC.">
    //    1    3:areturn         
    }

    public int getWp()
    {
        return wp;
    //    0    0:aload_0         
    //    1    1:getfield        #348 <Field int wp>
    //    2    4:ireturn         
    }

    public void setWp(int wp)
    {
        this.wp = wp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #348 <Field int wp>
    //    3    5:return          
    }

    public String wpTipText()
    {
        return "The required weight of number of permission for WSC.";
    //    0    0:ldc2            #756 <String "The required weight of number of permission for WSC.">
    //    1    3:areturn         
    }

    public int getWh()
    {
        return wh;
    //    0    0:aload_0         
    //    1    1:getfield        #350 <Field int wh>
    //    2    4:ireturn         
    }

    public void setWh(int wh)
    {
        this.wh = wh;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #350 <Field int wh>
    //    3    5:return          
    }

    public String whTipText()
    {
        return "The required weight of number of roles' hierarchy for WSC.";
    //    0    0:ldc2            #761 <String "The required weight of number of roles' hierarchy for WSC.">
    //    1    3:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_large.ass").toString());
    //    2    2:new             #764 <Class File>
    //    3    5:dup             
    //    4    6:new             #196 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #766 <String "user.dir">
    //    7   13:invokestatic    #772 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #539 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #206 <Method void StringBuilder(String)>
    //   10   22:ldc2            #774 <String "\\datasets\\university_large.ass">
    //   11   25:invokevirtual   #211 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #215 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #775 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #777 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #779 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #782 <Method void FileReader(File)>
    //   21   47:invokespecial   #785 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #788 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #792 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #795 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #800 <Method void PrintStream.println(String)>
            YeHRMiner yeh = new YeHRMiner();
    //   30   66:new             #2   <Class YeHRMiner>
    //   31   69:dup             
    //   32   70:invokespecial   #801 <Method void YeHRMiner()>
    //   33   73:astore          4
            yeh.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #803 <Method void buildRoleminers(Assignment)>
            System.out.println(yeh.toString());
    //   37   81:getstatic       #792 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #804 <Method String toString()>
    //   40   89:invokevirtual   #800 <Method void PrintStream.println(String)>
            System.out.println(yeh.generateRoles());
    //   41   92:getstatic       #792 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #806 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #808 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #811 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    Assignment m_assignment;
    Assignment m_assroles;
    StringBuffer log;
    Context f_context;
    private HWSC beforewsc;
    private HWSC afterwsc;
    private int wr;
    private int wu;
    private int wp;
    private int wh;
    private int wd;
    private Matrix userToRole;
    private Matrix tempuserToRole;
    private Matrix roleToPermission;
    private Matrix temproleToPermission;
    private Matrix huserToRole;
    private Matrix htempuserToRole;
    private Matrix hroleToPermission;
    private Matrix htemproleToPermission;
    private Matrix hroleToRole;
    private Matrix htemproleToRole;
    private Matrix UPA;
    private Matrix tempUPA;
    private Vector useVec;
    private Vector perVec;
    public static int numberOfRoles = 0;
    private int noUsers;
    private int noPerms;
    String formalObjects[];
    String formalAttributes[];

    static 
    {
    //    0    0:iconst_0        
    //    1    1:putstatic       #51  <Field int numberOfRoles>
    //*   2    4:return          
    }
}

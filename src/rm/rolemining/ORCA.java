// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ORCA.java

package rm.rolemining;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public class ORCA extends AbstractRoleminer
    implements OptionHandler
{
    public class Node
    {

        public boolean flag;
        public IntegerSet users;
        public IntegerSet perms;
        public int parent;
        final ORCA this$0;

        public Node()
        {
            this$0 = ORCA.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field ORCA this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
            flag = false;
        //    5    9:aload_0         
        //    6   10:iconst_0        
        //    7   11:putfield        #23  <Field boolean flag>
            users = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #25  <Field IntegerSet users>
            perms = null;
        //   11   19:aload_0         
        //   12   20:aconst_null     
        //   13   21:putfield        #27  <Field IntegerSet perms>
            parent = -1;
        //   14   24:aload_0         
        //   15   25:iconst_m1       
        //   16   26:putfield        #29  <Field int parent>
        //   17   29:return          
        }
    }


    public ORCA()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #24  <Method void AbstractRoleminer()>
        v_Roles = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #26  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #27  <Method void Vector()>
    //    6   12:putfield        #29  <Field Vector v_Roles>
    //    7   15:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #40  <Field Assignment m_assignment>
        Matrix mat = m_assignment.getAssignmentMatrix();
    //    3    5:aload_0         
    //    4    6:getfield        #40  <Field Assignment m_assignment>
    //    5    9:invokevirtual   #46  <Method Matrix Assignment.getAssignmentMatrix()>
    //    6   12:astore_2        
        noUsers = mat.getRowDimension();
    //    7   13:aload_0         
    //    8   14:aload_2         
    //    9   15:invokevirtual   #52  <Method int Matrix.getRowDimension()>
    //   10   18:putfield        #54  <Field int noUsers>
        noPerms = mat.getColumnDimension();
    //   11   21:aload_0         
    //   12   22:aload_2         
    //   13   23:invokevirtual   #57  <Method int Matrix.getColumnDimension()>
    //   14   26:putfield        #59  <Field int noPerms>
        userSet = m_assignment.getDimensionX().getDimensionAttribute().toArray();
    //   15   29:aload_0         
    //   16   30:aload_0         
    //   17   31:getfield        #40  <Field Assignment m_assignment>
    //   18   34:invokevirtual   #63  <Method Dimension Assignment.getDimensionX()>
    //   19   37:invokevirtual   #69  <Method Attribute Dimension.getDimensionAttribute()>
    //   20   40:invokevirtual   #75  <Method Object[] Attribute.toArray()>
    //   21   43:putfield        #77  <Field Object[] userSet>
        permSet = m_assignment.getDimensionY().getDimensionAttribute().toArray();
    //   22   46:aload_0         
    //   23   47:aload_0         
    //   24   48:getfield        #40  <Field Assignment m_assignment>
    //   25   51:invokevirtual   #80  <Method Dimension Assignment.getDimensionY()>
    //   26   54:invokevirtual   #69  <Method Attribute Dimension.getDimensionAttribute()>
    //   27   57:invokevirtual   #75  <Method Object[] Attribute.toArray()>
    //   28   60:putfield        #82  <Field Object[] permSet>
        for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  29   63:iconst_0        
    //*  30   64:istore_3        
    //*  31   65:goto            179
        {
            int nr = mat.getRowDimension();
    //   32   68:aload_2         
    //   33   69:invokevirtual   #52  <Method int Matrix.getRowDimension()>
    //   34   72:istore          4
            int nc = mat.getColumnDimension();
    //   35   74:aload_2         
    //   36   75:invokevirtual   #57  <Method int Matrix.getColumnDimension()>
    //   37   78:istore          5
            Node nd = new Node();
    //   38   80:new             #84  <Class ORCA$Node>
    //   39   83:dup             
    //   40   84:aload_0         
    //   41   85:invokespecial   #87  <Method void ORCA$Node(ORCA)>
    //   42   88:astore          6
            IntegerSet curusers = new IntegerSet(nr);
    //   43   90:new             #89  <Class IntegerSet>
    //   44   93:dup             
    //   45   94:iload           4
    //   46   96:invokespecial   #92  <Method void IntegerSet(int)>
    //   47   99:astore          7
            IntegerSet curperms = new IntegerSet(nc);
    //   48  101:new             #89  <Class IntegerSet>
    //   49  104:dup             
    //   50  105:iload           5
    //   51  107:invokespecial   #92  <Method void IntegerSet(int)>
    //   52  110:astore          8
            for(int i = 0; i < nr; i++)
    //*  53  112:iconst_0        
    //*  54  113:istore          9
    //*  55  115:goto            139
                if(mat.get(i, j) == 1)
    //*  56  118:aload_2         
    //*  57  119:iload           9
    //*  58  121:iload_3         
    //*  59  122:invokevirtual   #96  <Method byte Matrix.get(int, int)>
    //*  60  125:iconst_1        
    //*  61  126:icmpne          136
                    curusers.addElement(i);
    //   62  129:aload           7
    //   63  131:iload           9
    //   64  133:invokevirtual   #99  <Method void IntegerSet.addElement(int)>

    //   65  136:iinc            9  1
    //   66  139:iload           9
    //   67  141:iload           4
    //   68  143:icmplt          118
            curperms.addElement(j);
    //   69  146:aload           8
    //   70  148:iload_3         
    //   71  149:invokevirtual   #99  <Method void IntegerSet.addElement(int)>
            nd.users = curusers;
    //   72  152:aload           6
    //   73  154:aload           7
    //   74  156:putfield        #103 <Field IntegerSet ORCA$Node.users>
            nd.perms = curperms;
    //   75  159:aload           6
    //   76  161:aload           8
    //   77  163:putfield        #106 <Field IntegerSet ORCA$Node.perms>
            v_Roles.add(nd);
    //   78  166:aload_0         
    //   79  167:getfield        #29  <Field Vector v_Roles>
    //   80  170:aload           6
    //   81  172:invokevirtual   #110 <Method boolean Vector.add(Object)>
    //   82  175:pop             
        }

    //   83  176:iinc            3  1
    //   84  179:iload_3         
    //   85  180:aload_2         
    //   86  181:invokevirtual   #57  <Method int Matrix.getColumnDimension()>
    //   87  184:icmplt          68
    //*  88  187:goto            538
        while(falseNum() > 1) 
        {
            int maxi = -1;
    //   89  190:iconst_m1       
    //   90  191:istore_3        
            int maxj = -1;
    //   91  192:iconst_m1       
    //   92  193:istore          4
            int max = -1;
    //   93  195:iconst_m1       
    //   94  196:istore          5
            for(int i = 0; i < v_Roles.size(); i++)
    //*  95  198:iconst_0        
    //*  96  199:istore          6
    //*  97  201:goto            334
            {
                for(int j = i + 1; j < v_Roles.size(); j++)
    //*  98  204:iload           6
    //*  99  206:iconst_1        
    //* 100  207:iadd            
    //* 101  208:istore          7
    //* 102  210:goto            319
                    if(!((Node)v_Roles.get(i)).flag && !((Node)v_Roles.get(j)).flag)
    //* 103  213:aload_0         
    //* 104  214:getfield        #29  <Field Vector v_Roles>
    //* 105  217:iload           6
    //* 106  219:invokevirtual   #113 <Method Object Vector.get(int)>
    //* 107  222:checkcast       #84  <Class ORCA$Node>
    //* 108  225:getfield        #117 <Field boolean ORCA$Node.flag>
    //* 109  228:ifne            316
    //* 110  231:aload_0         
    //* 111  232:getfield        #29  <Field Vector v_Roles>
    //* 112  235:iload           7
    //* 113  237:invokevirtual   #113 <Method Object Vector.get(int)>
    //* 114  240:checkcast       #84  <Class ORCA$Node>
    //* 115  243:getfield        #117 <Field boolean ORCA$Node.flag>
    //* 116  246:ifne            316
                    {
                        IntegerSet is = ((Node)v_Roles.get(i)).users.getIntersection(((Node)v_Roles.get(j)).users);
    //  117  249:aload_0         
    //  118  250:getfield        #29  <Field Vector v_Roles>
    //  119  253:iload           6
    //  120  255:invokevirtual   #113 <Method Object Vector.get(int)>
    //  121  258:checkcast       #84  <Class ORCA$Node>
    //  122  261:getfield        #103 <Field IntegerSet ORCA$Node.users>
    //  123  264:aload_0         
    //  124  265:getfield        #29  <Field Vector v_Roles>
    //  125  268:iload           7
    //  126  270:invokevirtual   #113 <Method Object Vector.get(int)>
    //  127  273:checkcast       #84  <Class ORCA$Node>
    //  128  276:getfield        #103 <Field IntegerSet ORCA$Node.users>
    //  129  279:invokevirtual   #121 <Method IntegerSet IntegerSet.getIntersection(IntegerSet)>
    //  130  282:astore          8
                        if(is.getSize() > max && is.getSize() > 0)
    //* 131  284:aload           8
    //* 132  286:invokevirtual   #124 <Method int IntegerSet.getSize()>
    //* 133  289:iload           5
    //* 134  291:icmple          316
    //* 135  294:aload           8
    //* 136  296:invokevirtual   #124 <Method int IntegerSet.getSize()>
    //* 137  299:ifle            316
                        {
                            maxi = i;
    //  138  302:iload           6
    //  139  304:istore_3        
                            maxj = j;
    //  140  305:iload           7
    //  141  307:istore          4
                            max = is.getSize();
    //  142  309:aload           8
    //  143  311:invokevirtual   #124 <Method int IntegerSet.getSize()>
    //  144  314:istore          5
                        }
                    }

    //  145  316:iinc            7  1
    //  146  319:iload           7
    //  147  321:aload_0         
    //  148  322:getfield        #29  <Field Vector v_Roles>
    //  149  325:invokevirtual   #127 <Method int Vector.size()>
    //  150  328:icmplt          213
            }

    //  151  331:iinc            6  1
    //  152  334:iload           6
    //  153  336:aload_0         
    //  154  337:getfield        #29  <Field Vector v_Roles>
    //  155  340:invokevirtual   #127 <Method int Vector.size()>
    //  156  343:icmplt          204
            if(max == -1)
                break;
    //  157  346:iload           5
    //  158  348:iconst_m1       
    //  159  349:icmpeq          546
            IntegerSet newusers = ((Node)v_Roles.get(maxi)).users.getIntersection(((Node)v_Roles.get(maxj)).users);
    //  160  352:aload_0         
    //  161  353:getfield        #29  <Field Vector v_Roles>
    //  162  356:iload_3         
    //  163  357:invokevirtual   #113 <Method Object Vector.get(int)>
    //  164  360:checkcast       #84  <Class ORCA$Node>
    //  165  363:getfield        #103 <Field IntegerSet ORCA$Node.users>
    //  166  366:aload_0         
    //  167  367:getfield        #29  <Field Vector v_Roles>
    //  168  370:iload           4
    //  169  372:invokevirtual   #113 <Method Object Vector.get(int)>
    //  170  375:checkcast       #84  <Class ORCA$Node>
    //  171  378:getfield        #103 <Field IntegerSet ORCA$Node.users>
    //  172  381:invokevirtual   #121 <Method IntegerSet IntegerSet.getIntersection(IntegerSet)>
    //  173  384:astore          6
            IntegerSet newperms = ((Node)v_Roles.get(maxi)).perms.getUnion(((Node)v_Roles.get(maxj)).perms);
    //  174  386:aload_0         
    //  175  387:getfield        #29  <Field Vector v_Roles>
    //  176  390:iload_3         
    //  177  391:invokevirtual   #113 <Method Object Vector.get(int)>
    //  178  394:checkcast       #84  <Class ORCA$Node>
    //  179  397:getfield        #106 <Field IntegerSet ORCA$Node.perms>
    //  180  400:aload_0         
    //  181  401:getfield        #29  <Field Vector v_Roles>
    //  182  404:iload           4
    //  183  406:invokevirtual   #113 <Method Object Vector.get(int)>
    //  184  409:checkcast       #84  <Class ORCA$Node>
    //  185  412:getfield        #106 <Field IntegerSet ORCA$Node.perms>
    //  186  415:invokevirtual   #130 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  187  418:astore          7
            ((Node)v_Roles.get(maxi)).flag = true;
    //  188  420:aload_0         
    //  189  421:getfield        #29  <Field Vector v_Roles>
    //  190  424:iload_3         
    //  191  425:invokevirtual   #113 <Method Object Vector.get(int)>
    //  192  428:checkcast       #84  <Class ORCA$Node>
    //  193  431:iconst_1        
    //  194  432:putfield        #117 <Field boolean ORCA$Node.flag>
            ((Node)v_Roles.get(maxj)).flag = true;
    //  195  435:aload_0         
    //  196  436:getfield        #29  <Field Vector v_Roles>
    //  197  439:iload           4
    //  198  441:invokevirtual   #113 <Method Object Vector.get(int)>
    //  199  444:checkcast       #84  <Class ORCA$Node>
    //  200  447:iconst_1        
    //  201  448:putfield        #117 <Field boolean ORCA$Node.flag>
            Node nd = new Node();
    //  202  451:new             #84  <Class ORCA$Node>
    //  203  454:dup             
    //  204  455:aload_0         
    //  205  456:invokespecial   #87  <Method void ORCA$Node(ORCA)>
    //  206  459:astore          8
            nd.users = newusers;
    //  207  461:aload           8
    //  208  463:aload           6
    //  209  465:putfield        #103 <Field IntegerSet ORCA$Node.users>
            nd.perms = newperms;
    //  210  468:aload           8
    //  211  470:aload           7
    //  212  472:putfield        #106 <Field IntegerSet ORCA$Node.perms>
            v_Roles.add(nd);
    //  213  475:aload_0         
    //  214  476:getfield        #29  <Field Vector v_Roles>
    //  215  479:aload           8
    //  216  481:invokevirtual   #110 <Method boolean Vector.add(Object)>
    //  217  484:pop             
            ((Node)v_Roles.get(maxi)).parent = v_Roles.indexOf(nd);
    //  218  485:aload_0         
    //  219  486:getfield        #29  <Field Vector v_Roles>
    //  220  489:iload_3         
    //  221  490:invokevirtual   #113 <Method Object Vector.get(int)>
    //  222  493:checkcast       #84  <Class ORCA$Node>
    //  223  496:aload_0         
    //  224  497:getfield        #29  <Field Vector v_Roles>
    //  225  500:aload           8
    //  226  502:invokevirtual   #134 <Method int Vector.indexOf(Object)>
    //  227  505:putfield        #137 <Field int ORCA$Node.parent>
            ((Node)v_Roles.get(maxj)).parent = v_Roles.indexOf(nd);
    //  228  508:aload_0         
    //  229  509:getfield        #29  <Field Vector v_Roles>
    //  230  512:iload           4
    //  231  514:invokevirtual   #113 <Method Object Vector.get(int)>
    //  232  517:checkcast       #84  <Class ORCA$Node>
    //  233  520:aload_0         
    //  234  521:getfield        #29  <Field Vector v_Roles>
    //  235  524:aload           8
    //  236  526:invokevirtual   #134 <Method int Vector.indexOf(Object)>
    //  237  529:putfield        #137 <Field int ORCA$Node.parent>
        }
    //  238  532:goto            538
    //  239  535:goto            546
    //  240  538:aload_0         
    //  241  539:invokevirtual   #140 <Method int falseNum()>
    //  242  542:iconst_1        
    //  243  543:icmpgt          190
    //  244  546:return          
    }

    public int falseNum()
    {
        int n = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        for(int i = 0; i < v_Roles.size(); i++)
    //*   2    2:iconst_0        
    //*   3    3:istore_2        
    //*   4    4:goto            30
            if(!((Node)v_Roles.get(i)).flag)
    //*   5    7:aload_0         
    //*   6    8:getfield        #29  <Field Vector v_Roles>
    //*   7   11:iload_2         
    //*   8   12:invokevirtual   #113 <Method Object Vector.get(int)>
    //*   9   15:checkcast       #84  <Class ORCA$Node>
    //*  10   18:getfield        #117 <Field boolean ORCA$Node.flag>
    //*  11   21:ifne            27
                n++;
    //   12   24:iinc            1  1

    //   13   27:iinc            2  1
    //   14   30:iload_2         
    //   15   31:aload_0         
    //   16   32:getfield        #29  <Field Vector v_Roles>
    //   17   35:invokevirtual   #127 <Method int Vector.size()>
    //   18   38:icmplt          7
        return n;
    //   19   41:iload_1         
    //   20   42:ireturn         
    }

    public Vector IntegerSettoString(IntegerSet set, Object objs[])
    {
        int n = objs.length;
    //    0    0:aload_2         
    //    1    1:arraylength     
    //    2    2:istore_3        
        Vector vs = new Vector();
    //    3    3:new             #26  <Class Vector>
    //    4    6:dup             
    //    5    7:invokespecial   #27  <Method void Vector()>
    //    6   10:astore          4
        for(int i = 0; i < n; i++)
    //*   7   12:iconst_0        
    //*   8   13:istore          5
    //*   9   15:goto            43
            if(set.contains(i))
    //*  10   18:aload_1         
    //*  11   19:iload           5
    //*  12   21:invokevirtual   #165 <Method boolean IntegerSet.contains(int)>
    //*  13   24:ifeq            40
                vs.add((String)objs[i]);
    //   14   27:aload           4
    //   15   29:aload_2         
    //   16   30:iload           5
    //   17   32:aaload          
    //   18   33:checkcast       #167 <Class String>
    //   19   36:invokevirtual   #110 <Method boolean Vector.add(Object)>
    //   20   39:pop             

    //   21   40:iinc            5  1
    //   22   43:iload           5
    //   23   45:iload_3         
    //   24   46:icmplt          18
        return vs;
    //   25   49:aload           4
    //   26   51:areturn         
    }

    public String toString()
    {
        StringBuffer txt = new StringBuffer();
    //    0    0:new             #176 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #177 <Method void StringBuffer()>
    //    3    7:astore_1        
        for(int i = 0; i < v_Roles.size(); i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            173
        {
            txt.append((new StringBuilder(String.valueOf(i))).append(": ").toString());
    //    7   13:aload_1         
    //    8   14:new             #179 <Class StringBuilder>
    //    9   17:dup             
    //   10   18:iload_2         
    //   11   19:invokestatic    #183 <Method String String.valueOf(int)>
    //   12   22:invokespecial   #186 <Method void StringBuilder(String)>
    //   13   25:ldc1            #188 <String ": ">
    //   14   27:invokevirtual   #192 <Method StringBuilder StringBuilder.append(String)>
    //   15   30:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   16   33:invokevirtual   #197 <Method StringBuffer StringBuffer.append(String)>
    //   17   36:pop             
            txt.append((new StringBuilder(String.valueOf(IntegerSettoString(((Node)v_Roles.get(i)).users, userSet).toString()))).append(" ").toString());
    //   18   37:aload_1         
    //   19   38:new             #179 <Class StringBuilder>
    //   20   41:dup             
    //   21   42:aload_0         
    //   22   43:aload_0         
    //   23   44:getfield        #29  <Field Vector v_Roles>
    //   24   47:iload_2         
    //   25   48:invokevirtual   #113 <Method Object Vector.get(int)>
    //   26   51:checkcast       #84  <Class ORCA$Node>
    //   27   54:getfield        #103 <Field IntegerSet ORCA$Node.users>
    //   28   57:aload_0         
    //   29   58:getfield        #77  <Field Object[] userSet>
    //   30   61:invokevirtual   #199 <Method Vector IntegerSettoString(IntegerSet, Object[])>
    //   31   64:invokevirtual   #200 <Method String Vector.toString()>
    //   32   67:invokestatic    #203 <Method String String.valueOf(Object)>
    //   33   70:invokespecial   #186 <Method void StringBuilder(String)>
    //   34   73:ldc1            #205 <String " ">
    //   35   75:invokevirtual   #192 <Method StringBuilder StringBuilder.append(String)>
    //   36   78:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   37   81:invokevirtual   #197 <Method StringBuffer StringBuffer.append(String)>
    //   38   84:pop             
            txt.append((new StringBuilder(String.valueOf(IntegerSettoString(((Node)v_Roles.get(i)).perms, permSet).toString()))).append(" ").toString());
    //   39   85:aload_1         
    //   40   86:new             #179 <Class StringBuilder>
    //   41   89:dup             
    //   42   90:aload_0         
    //   43   91:aload_0         
    //   44   92:getfield        #29  <Field Vector v_Roles>
    //   45   95:iload_2         
    //   46   96:invokevirtual   #113 <Method Object Vector.get(int)>
    //   47   99:checkcast       #84  <Class ORCA$Node>
    //   48  102:getfield        #106 <Field IntegerSet ORCA$Node.perms>
    //   49  105:aload_0         
    //   50  106:getfield        #82  <Field Object[] permSet>
    //   51  109:invokevirtual   #199 <Method Vector IntegerSettoString(IntegerSet, Object[])>
    //   52  112:invokevirtual   #200 <Method String Vector.toString()>
    //   53  115:invokestatic    #203 <Method String String.valueOf(Object)>
    //   54  118:invokespecial   #186 <Method void StringBuilder(String)>
    //   55  121:ldc1            #205 <String " ">
    //   56  123:invokevirtual   #192 <Method StringBuilder StringBuilder.append(String)>
    //   57  126:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   58  129:invokevirtual   #197 <Method StringBuffer StringBuffer.append(String)>
    //   59  132:pop             
            txt.append((new StringBuilder(String.valueOf(((Node)v_Roles.get(i)).parent))).append("\n").toString());
    //   60  133:aload_1         
    //   61  134:new             #179 <Class StringBuilder>
    //   62  137:dup             
    //   63  138:aload_0         
    //   64  139:getfield        #29  <Field Vector v_Roles>
    //   65  142:iload_2         
    //   66  143:invokevirtual   #113 <Method Object Vector.get(int)>
    //   67  146:checkcast       #84  <Class ORCA$Node>
    //   68  149:getfield        #137 <Field int ORCA$Node.parent>
    //   69  152:invokestatic    #183 <Method String String.valueOf(int)>
    //   70  155:invokespecial   #186 <Method void StringBuilder(String)>
    //   71  158:ldc1            #207 <String "\n">
    //   72  160:invokevirtual   #192 <Method StringBuilder StringBuilder.append(String)>
    //   73  163:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   74  166:invokevirtual   #197 <Method StringBuffer StringBuffer.append(String)>
    //   75  169:pop             
        }

    //   76  170:iinc            2  1
    //   77  173:iload_2         
    //   78  174:aload_0         
    //   79  175:getfield        #29  <Field Vector v_Roles>
    //   80  178:invokevirtual   #127 <Method int Vector.size()>
    //   81  181:icmplt          13
        return txt.toString();
    //   82  184:aload_1         
    //   83  185:invokevirtual   #208 <Method String StringBuffer.toString()>
    //   84  188:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #42  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #213 <Method void Assignment()>
    //    4    8:putfield        #215 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #215 <Field Assignment m_assroles>
    //    7   15:ldc1            #217 <String "role-permission">
    //    8   17:invokevirtual   #220 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(v_Roles.size(), noPerms, (byte)0);
    //    9   20:new             #48  <Class Matrix>
    //   10   23:dup             
    //   11   24:aload_0         
    //   12   25:getfield        #29  <Field Vector v_Roles>
    //   13   28:invokevirtual   #127 <Method int Vector.size()>
    //   14   31:aload_0         
    //   15   32:getfield        #59  <Field int noPerms>
    //   16   35:iconst_0        
    //   17   36:invokespecial   #223 <Method void Matrix(int, int, byte)>
    //   18   39:astore_1        
        for(int i = 0; i < v_Roles.size(); i++)
    //*  19   40:iconst_0        
    //*  20   41:istore_2        
    //*  21   42:goto            98
        {
            IntegerSet upi = ((Node)v_Roles.get(i)).perms;
    //   22   45:aload_0         
    //   23   46:getfield        #29  <Field Vector v_Roles>
    //   24   49:iload_2         
    //   25   50:invokevirtual   #113 <Method Object Vector.get(int)>
    //   26   53:checkcast       #84  <Class ORCA$Node>
    //   27   56:getfield        #106 <Field IntegerSet ORCA$Node.perms>
    //   28   59:astore_3        
            for(int j = 0; j < noPerms; j++)
    //*  29   60:iconst_0        
    //*  30   61:istore          4
    //*  31   63:goto            86
                if(upi.contains(j))
    //*  32   66:aload_3         
    //*  33   67:iload           4
    //*  34   69:invokevirtual   #165 <Method boolean IntegerSet.contains(int)>
    //*  35   72:ifeq            83
                    mat.set(i, j, (byte)1);
    //   36   75:aload_1         
    //   37   76:iload_2         
    //   38   77:iload           4
    //   39   79:iconst_1        
    //   40   80:invokevirtual   #225 <Method void Matrix.set(int, int, byte)>

    //   41   83:iinc            4  1
    //   42   86:iload           4
    //   43   88:aload_0         
    //   44   89:getfield        #59  <Field int noPerms>
    //   45   92:icmplt          66
        }

    //   46   95:iinc            2  1
    //   47   98:iload_2         
    //   48   99:aload_0         
    //   49  100:getfield        #29  <Field Vector v_Roles>
    //   50  103:invokevirtual   #127 <Method int Vector.size()>
    //   51  106:icmplt          45
        m_assroles.setAssignmentMatrix(mat);
    //   52  109:aload_0         
    //   53  110:getfield        #215 <Field Assignment m_assroles>
    //   54  113:aload_1         
    //   55  114:invokevirtual   #229 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   56  117:new             #231 <Class FastVector>
    //   57  120:dup             
    //   58  121:invokespecial   #232 <Method void FastVector()>
    //   59  124:astore_2        
        for(int i = 0; i < v_Roles.size(); i++)
    //*  60  125:iconst_0        
    //*  61  126:istore_3        
    //*  62  127:goto            153
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   63  130:aload_2         
    //   64  131:new             #179 <Class StringBuilder>
    //   65  134:dup             
    //   66  135:ldc1            #234 <String "R">
    //   67  137:invokespecial   #186 <Method void StringBuilder(String)>
    //   68  140:iload_3         
    //   69  141:invokevirtual   #237 <Method StringBuilder StringBuilder.append(int)>
    //   70  144:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   71  147:invokevirtual   #240 <Method void FastVector.addElement(Object)>

    //   72  150:iinc            3  1
    //   73  153:iload_3         
    //   74  154:aload_0         
    //   75  155:getfield        #29  <Field Vector v_Roles>
    //   76  158:invokevirtual   #127 <Method int Vector.size()>
    //   77  161:icmplt          130
        Attribute dxa = new Attribute("role", fv);
    //   78  164:new             #71  <Class Attribute>
    //   79  167:dup             
    //   80  168:ldc1            #242 <String "role">
    //   81  170:aload_2         
    //   82  171:invokespecial   #245 <Method void Attribute(String, FastVector)>
    //   83  174:astore_3        
        Dimension dx = new Dimension();
    //   84  175:new             #65  <Class Dimension>
    //   85  178:dup             
    //   86  179:invokespecial   #246 <Method void Dimension()>
    //   87  182:astore          4
        Attribute att = new Attribute("parents", null);
    //   88  184:new             #71  <Class Attribute>
    //   89  187:dup             
    //   90  188:ldc1            #248 <String "parents">
    //   91  190:aconst_null     
    //   92  191:invokespecial   #245 <Method void Attribute(String, FastVector)>
    //   93  194:astore          5
        FastVector fv_atts = new FastVector();
    //   94  196:new             #231 <Class FastVector>
    //   95  199:dup             
    //   96  200:invokespecial   #232 <Method void FastVector()>
    //   97  203:astore          6
        fv_atts.addElement(att);
    //   98  205:aload           6
    //   99  207:aload           5
    //  100  209:invokevirtual   #240 <Method void FastVector.addElement(Object)>
        Instances insSet = new Instances("role", fv_atts, 0);
    //  101  212:new             #250 <Class Instances>
    //  102  215:dup             
    //  103  216:ldc1            #242 <String "role">
    //  104  218:aload           6
    //  105  220:iconst_0        
    //  106  221:invokespecial   #253 <Method void Instances(String, FastVector, int)>
    //  107  224:astore          7
        for(int i = 0; i < v_Roles.size(); i++)
    //* 108  226:iconst_0        
    //* 109  227:istore          8
    //* 110  229:goto            294
        {
            Instance insi = new Instance(1);
    //  111  232:new             #255 <Class Instance>
    //  112  235:dup             
    //  113  236:iconst_1        
    //  114  237:invokespecial   #256 <Method void Instance(int)>
    //  115  240:astore          9
            insi.setDataset(insSet);
    //  116  242:aload           9
    //  117  244:aload           7
    //  118  246:invokevirtual   #260 <Method void Instance.setDataset(Instances)>
            insi.setValue(att, (new StringBuilder(String.valueOf(((Node)v_Roles.get(i)).parent))).toString());
    //  119  249:aload           9
    //  120  251:aload           5
    //  121  253:new             #179 <Class StringBuilder>
    //  122  256:dup             
    //  123  257:aload_0         
    //  124  258:getfield        #29  <Field Vector v_Roles>
    //  125  261:iload           8
    //  126  263:invokevirtual   #113 <Method Object Vector.get(int)>
    //  127  266:checkcast       #84  <Class ORCA$Node>
    //  128  269:getfield        #137 <Field int ORCA$Node.parent>
    //  129  272:invokestatic    #183 <Method String String.valueOf(int)>
    //  130  275:invokespecial   #186 <Method void StringBuilder(String)>
    //  131  278:invokevirtual   #194 <Method String StringBuilder.toString()>
    //  132  281:invokevirtual   #264 <Method void Instance.setValue(Attribute, String)>
            insSet.add(insi);
    //  133  284:aload           7
    //  134  286:aload           9
    //  135  288:invokevirtual   #267 <Method void Instances.add(Instance)>
        }

    //  136  291:iinc            8  1
    //  137  294:iload           8
    //  138  296:aload_0         
    //  139  297:getfield        #29  <Field Vector v_Roles>
    //  140  300:invokevirtual   #127 <Method int Vector.size()>
    //  141  303:icmplt          232
        dx.setDimensionAttribute(dxa);
    //  142  306:aload           4
    //  143  308:aload_3         
    //  144  309:invokevirtual   #271 <Method void Dimension.setDimensionAttribute(Attribute)>
        dx.setDimensionInstances(insSet);
    //  145  312:aload           4
    //  146  314:aload           7
    //  147  316:invokevirtual   #274 <Method void Dimension.setDimensionInstances(Instances)>
        m_assroles.setDimensionX(dx);
    //  148  319:aload_0         
    //  149  320:getfield        #215 <Field Assignment m_assroles>
    //  150  323:aload           4
    //  151  325:invokevirtual   #278 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //  152  328:aload_0         
    //  153  329:getfield        #40  <Field Assignment m_assignment>
    //  154  332:invokevirtual   #80  <Method Dimension Assignment.getDimensionY()>
    //  155  335:invokevirtual   #69  <Method Attribute Dimension.getDimensionAttribute()>
    //  156  338:astore          8
        Dimension dy = new Dimension();
    //  157  340:new             #65  <Class Dimension>
    //  158  343:dup             
    //  159  344:invokespecial   #246 <Method void Dimension()>
    //  160  347:astore          9
        dy.setDimensionAttribute(dya);
    //  161  349:aload           9
    //  162  351:aload           8
    //  163  353:invokevirtual   #271 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  164  356:aload_0         
    //  165  357:getfield        #215 <Field Assignment m_assroles>
    //  166  360:aload           9
    //  167  362:invokevirtual   #281 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  168  365:aload_0         
    //  169  366:getfield        #215 <Field Assignment m_assroles>
    //  170  369:areturn         
    }

    public String globalInfo()
    {
        return "ORCA performs a cluster analysis on \npermission assignments to build a hierarchy \n of permission clusters and presents the results \n to the user in graphical form.";
    //    0    0:ldc2            #299 <String "ORCA performs a cluster analysis on \npermission assignments to build a hierarchy \n of permission clusters and presents the results \n to the user in graphical form.">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #303 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #308 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #314 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #318 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #321 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #318 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #324 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #318 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #327 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #318 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #330 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #318 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = "\t. this algorithm has no parameters \n";
    //    0    0:ldc2            #336 <String "\t. this algorithm has no parameters \n">
    //    1    3:astore_1        
        FastVector newVector = new FastVector(1);
    //    2    4:new             #231 <Class FastVector>
    //    3    7:dup             
    //    4    8:iconst_1        
    //    5    9:invokespecial   #337 <Method void FastVector(int)>
    //    6   12:astore_2        
        newVector.addElement(new Option(string1, "", 0, "- < no paramenters>"));
    //    7   13:aload_2         
    //    8   14:new             #339 <Class Option>
    //    9   17:dup             
    //   10   18:aload_1         
    //   11   19:ldc2            #341 <String "">
    //   12   22:iconst_0        
    //   13   23:ldc2            #343 <String "- < no paramenters>">
    //   14   26:invokespecial   #346 <Method void Option(String, String, int, String)>
    //   15   29:invokevirtual   #240 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   16   32:aload_2         
    //   17   33:invokevirtual   #349 <Method Enumeration FastVector.elements()>
    //   18   36:areturn         
    }

    public void setOptions(String as[])
        throws Exception
    {
    //    0    0:return          
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
        options[current++] = "";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #341 <String "">
    //    9   16:aastore         
        for(options[current++] = ""; current < options.length; options[current++] = "");
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:ldc2            #341 <String "">
    //   14   25:aastore         
    //   15   26:goto            38
    //   16   29:aload_1         
    //   17   30:iload_2         
    //   18   31:iinc            2  1
    //   19   34:ldc2            #341 <String "">
    //   20   37:aastore         
    //   21   38:iload_2         
    //   22   39:aload_1         
    //   23   40:arraylength     
    //   24   41:icmplt          29
        return options;
    //   25   44:aload_1         
    //   26   45:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\orca_user_permission.ass").toString());
    //    2    2:new             #362 <Class File>
    //    3    5:dup             
    //    4    6:new             #179 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #364 <String "user.dir">
    //    7   13:invokestatic    #370 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #203 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #186 <Method void StringBuilder(String)>
    //   10   22:ldc2            #372 <String "\\datasets\\orca_user_permission.ass">
    //   11   25:invokevirtual   #192 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #373 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #375 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #377 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #380 <Method void FileReader(File)>
    //   21   47:invokespecial   #383 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #386 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #390 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #393 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #398 <Method void PrintStream.println(String)>
            ORCA orca = new ORCA();
    //   30   66:new             #2   <Class ORCA>
    //   31   69:dup             
    //   32   70:invokespecial   #399 <Method void ORCA()>
    //   33   73:astore          4
            orca.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #401 <Method void buildRoleminers(Assignment)>
            System.out.println(orca.toString());
    //   37   81:getstatic       #390 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #402 <Method String toString()>
    //   40   89:invokevirtual   #398 <Method void PrintStream.println(String)>
            System.out.println(orca.generateRoles().toString());
    //   41   92:getstatic       #390 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #404 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #405 <Method String Assignment.toString()>
    //   45  103:invokevirtual   #398 <Method void PrintStream.println(String)>
        }
    //*  46  106:goto            114
        catch(Exception e)
    //*  47  109:astore_2        
        {
            e.printStackTrace();
    //   48  110:aload_2         
    //   49  111:invokevirtual   #408 <Method void Exception.printStackTrace()>
        }
    //   50  114:return          
    }

    private Assignment m_assignment;
    private Assignment m_assroles;
    private Vector v_Roles;
    private int noUsers;
    private int noPerms;
    private Object userSet[];
    private Object permSet[];
}

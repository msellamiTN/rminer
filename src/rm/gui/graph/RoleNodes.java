// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RoleNodes.java

package rm.gui.graph;

import java.io.*;
import java.util.*;
import javax.swing.UIManager;
import rm.core.*;
import rm.core.converters.AssLoader;

public class RoleNodes
{
    public class RNode
    {

        public int x;
        public int y;
        public String RoleName;
        public IntegerSet SelfPerms;
        public IntegerSet InheritPerms;
        public List Parents;
        public double weight;
        public int Level;
        final RoleNodes this$0;

        public RNode()
        {
            this$0 = RoleNodes.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #26  <Field RoleNodes this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #29  <Method void Object()>
            x = 0;
        //    5    9:aload_0         
        //    6   10:iconst_0        
        //    7   11:putfield        #31  <Field int x>
            y = 0;
        //    8   14:aload_0         
        //    9   15:iconst_0        
        //   10   16:putfield        #33  <Field int y>
            RoleName = "";
        //   11   19:aload_0         
        //   12   20:ldc1            #35  <String "">
        //   13   22:putfield        #37  <Field String RoleName>
            SelfPerms = null;
        //   14   25:aload_0         
        //   15   26:aconst_null     
        //   16   27:putfield        #39  <Field IntegerSet SelfPerms>
            InheritPerms = null;
        //   17   30:aload_0         
        //   18   31:aconst_null     
        //   19   32:putfield        #41  <Field IntegerSet InheritPerms>
            Parents = new ArrayList();
        //   20   35:aload_0         
        //   21   36:new             #43  <Class ArrayList>
        //   22   39:dup             
        //   23   40:invokespecial   #44  <Method void ArrayList()>
        //   24   43:putfield        #46  <Field List Parents>
            weight = 0.0D;
        //   25   46:aload_0         
        //   26   47:dconst_0        
        //   27   48:putfield        #48  <Field double weight>
            Level = -1;
        //   28   51:aload_0         
        //   29   52:iconst_m1       
        //   30   53:putfield        #50  <Field int Level>
        //   31   56:return          
        }
    }

    public class Edge
    {

        public int from;
        public int to;
        final RoleNodes this$0;

        public Edge()
        {
            this$0 = RoleNodes.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #14  <Field RoleNodes this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #17  <Method void Object()>
        //    5    9:return          
        }
    }


    public RoleNodes(Assignment AssData)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #41  <Method void Object()>
        m_assPA = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #43  <Field Assignment m_assPA>
        nodes = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #45  <Field RoleNodes$RNode[] nodes>
        matPA = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #47  <Field Matrix matPA>
        m_assPA = AssData;
    //   11   19:aload_0         
    //   12   20:aload_1         
    //   13   21:putfield        #43  <Field Assignment m_assPA>
        matPA = m_assPA.getAssignmentMatrix();
    //   14   24:aload_0         
    //   15   25:aload_0         
    //   16   26:getfield        #43  <Field Assignment m_assPA>
    //   17   29:invokevirtual   #53  <Method Matrix Assignment.getAssignmentMatrix()>
    //   18   32:putfield        #47  <Field Matrix matPA>
        Attribute Roles = m_assPA.getDimensionX().getDimensionAttribute();
    //   19   35:aload_0         
    //   20   36:getfield        #43  <Field Assignment m_assPA>
    //   21   39:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //   22   42:invokevirtual   #63  <Method Attribute Dimension.getDimensionAttribute()>
    //   23   45:astore          5
        Attribute Permissions = m_assPA.getDimensionY().getDimensionAttribute();
    //   24   47:aload_0         
    //   25   48:getfield        #43  <Field Assignment m_assPA>
    //   26   51:invokevirtual   #66  <Method Dimension Assignment.getDimensionY()>
    //   27   54:invokevirtual   #63  <Method Attribute Dimension.getDimensionAttribute()>
    //   28   57:astore          6
        n_Roles = Roles.numValues();
    //   29   59:aload_0         
    //   30   60:aload           5
    //   31   62:invokevirtual   #72  <Method int Attribute.numValues()>
    //   32   65:putfield        #74  <Field int n_Roles>
        n_Permissions = Permissions.numValues();
    //   33   68:aload_0         
    //   34   69:aload           6
    //   35   71:invokevirtual   #72  <Method int Attribute.numValues()>
    //   36   74:putfield        #76  <Field int n_Permissions>
        roleset = Roles.toArray();
    //   37   77:aload_0         
    //   38   78:aload           5
    //   39   80:invokevirtual   #80  <Method Object[] Attribute.toArray()>
    //   40   83:putfield        #82  <Field Object[] roleset>
        permset = Permissions.toArray();
    //   41   86:aload_0         
    //   42   87:aload           6
    //   43   89:invokevirtual   #80  <Method Object[] Attribute.toArray()>
    //   44   92:putfield        #84  <Field Object[] permset>
        nodes = new RNode[n_Roles];
    //   45   95:aload_0         
    //   46   96:aload_0         
    //   47   97:getfield        #74  <Field int n_Roles>
    //   48  100:anewarray       RNode[]
    //   49  103:putfield        #45  <Field RoleNodes$RNode[] nodes>
        if(n_Roles == matPA.getRowDimension())
    //*  50  106:aload_0         
    //*  51  107:getfield        #74  <Field int n_Roles>
    //*  52  110:aload_0         
    //*  53  111:getfield        #47  <Field Matrix matPA>
    //*  54  114:invokevirtual   #91  <Method int Matrix.getRowDimension()>
    //*  55  117:icmpne          211
        {
            for(int i = 0; i < matPA.getRowDimension(); i++)
    //*  56  120:iconst_0        
    //*  57  121:istore_2        
    //*  58  122:goto            200
            {
                nodes[i] = new RNode();
    //   59  125:aload_0         
    //   60  126:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   61  129:iload_2         
    //   62  130:new             #86  <Class RoleNodes$RNode>
    //   63  133:dup             
    //   64  134:aload_0         
    //   65  135:invokespecial   #94  <Method void RoleNodes$RNode(RoleNodes)>
    //   66  138:aastore         
                nodes[i].InheritPerms = new IntegerSet(n_Permissions);
    //   67  139:aload_0         
    //   68  140:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   69  143:iload_2         
    //   70  144:aaload          
    //   71  145:new             #96  <Class IntegerSet>
    //   72  148:dup             
    //   73  149:aload_0         
    //   74  150:getfield        #76  <Field int n_Permissions>
    //   75  153:invokespecial   #99  <Method void IntegerSet(int)>
    //   76  156:putfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
                nodes[i].SelfPerms = new IntegerSet(n_Permissions);
    //   77  159:aload_0         
    //   78  160:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   79  163:iload_2         
    //   80  164:aaload          
    //   81  165:new             #96  <Class IntegerSet>
    //   82  168:dup             
    //   83  169:aload_0         
    //   84  170:getfield        #76  <Field int n_Permissions>
    //   85  173:invokespecial   #99  <Method void IntegerSet(int)>
    //   86  176:putfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
                nodes[i].RoleName = (String)roleset[i];
    //   87  179:aload_0         
    //   88  180:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   89  183:iload_2         
    //   90  184:aaload          
    //   91  185:aload_0         
    //   92  186:getfield        #82  <Field Object[] roleset>
    //   93  189:iload_2         
    //   94  190:aaload          
    //   95  191:checkcast       #29  <Class String>
    //   96  194:putfield        #109 <Field String RoleNodes$RNode.RoleName>
            }

    //   97  197:iinc            2  1
    //   98  200:iload_2         
    //   99  201:aload_0         
    //  100  202:getfield        #47  <Field Matrix matPA>
    //  101  205:invokevirtual   #91  <Method int Matrix.getRowDimension()>
    //  102  208:icmplt          125
        }
        if(m_assPA.getDimensionX().getDimensionInstances() != null)
    //* 103  211:aload_0         
    //* 104  212:getfield        #43  <Field Assignment m_assPA>
    //* 105  215:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //* 106  218:invokevirtual   #113 <Method Instances Dimension.getDimensionInstances()>
    //* 107  221:ifnull          425
        {
            Enumeration parentset = m_assPA.getDimensionX().getDimensionInstances().enumerateInstances();
    //  108  224:aload_0         
    //  109  225:getfield        #43  <Field Assignment m_assPA>
    //  110  228:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //  111  231:invokevirtual   #113 <Method Instances Dimension.getDimensionInstances()>
    //  112  234:invokevirtual   #119 <Method Enumeration Instances.enumerateInstances()>
    //  113  237:astore          7
            Attribute attparent = m_assPA.getDimensionX().getDimensionInstances().attribute("parents");
    //  114  239:aload_0         
    //  115  240:getfield        #43  <Field Assignment m_assPA>
    //  116  243:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //  117  246:invokevirtual   #113 <Method Instances Dimension.getDimensionInstances()>
    //  118  249:ldc1            #121 <String "parents">
    //  119  251:invokevirtual   #125 <Method Attribute Instances.attribute(String)>
    //  120  254:astore          8
            Attribute attweight = m_assPA.getDimensionX().getDimensionInstances().attribute("weight");
    //  121  256:aload_0         
    //  122  257:getfield        #43  <Field Assignment m_assPA>
    //  123  260:invokevirtual   #57  <Method Dimension Assignment.getDimensionX()>
    //  124  263:invokevirtual   #113 <Method Instances Dimension.getDimensionInstances()>
    //  125  266:ldc1            #127 <String "weight">
    //  126  268:invokevirtual   #125 <Method Attribute Instances.attribute(String)>
    //  127  271:astore          9
            for(int i = 0; parentset.hasMoreElements(); i++)
    //* 128  273:iconst_0        
    //* 129  274:istore_2        
    //* 130  275:goto            412
            {
                Instance insi = (Instance)(Instance)parentset.nextElement();
    //  131  278:aload           7
    //  132  280:invokeinterface #133 <Method Object Enumeration.nextElement()>
    //  133  285:checkcast       #135 <Class Instance>
    //  134  288:checkcast       #135 <Class Instance>
    //  135  291:astore          10
                if(attparent != null && !insi.toString(attparent).equals("''"))
    //* 136  293:aload           8
    //* 137  295:ifnull          388
    //* 138  298:aload           10
    //* 139  300:aload           8
    //* 140  302:invokevirtual   #139 <Method String Instance.toString(Attribute)>
    //* 141  305:ldc1            #141 <String "''">
    //* 142  307:invokevirtual   #145 <Method boolean String.equals(Object)>
    //* 143  310:ifne            388
                {
                    String StrParents[] = insi.toString(attparent).split("\\|");
    //  144  313:aload           10
    //  145  315:aload           8
    //  146  317:invokevirtual   #139 <Method String Instance.toString(Attribute)>
    //  147  320:ldc1            #147 <String "\\|">
    //  148  322:invokevirtual   #151 <Method String[] String.split(String)>
    //  149  325:astore          11
                    for(int k = 0; k < StrParents.length; k++)
    //* 150  327:iconst_0        
    //* 151  328:istore          4
    //* 152  330:goto            380
                    {
                        int parent = Integer.parseInt(StrParents[k]);
    //  153  333:aload           11
    //  154  335:iload           4
    //  155  337:aaload          
    //  156  338:invokestatic    #157 <Method int Integer.parseInt(String)>
    //  157  341:istore          12
                        if(parent >= 0 && parent < n_Roles)
    //* 158  343:iload           12
    //* 159  345:iflt            377
    //* 160  348:iload           12
    //* 161  350:aload_0         
    //* 162  351:getfield        #74  <Field int n_Roles>
    //* 163  354:icmpge          377
                            nodes[i].Parents.add(Integer.valueOf(parent));
    //  164  357:aload_0         
    //  165  358:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //  166  361:iload_2         
    //  167  362:aaload          
    //  168  363:getfield        #161 <Field List RoleNodes$RNode.Parents>
    //  169  366:iload           12
    //  170  368:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //  171  371:invokeinterface #170 <Method boolean List.add(Object)>
    //  172  376:pop             
                    }

    //  173  377:iinc            4  1
    //  174  380:iload           4
    //  175  382:aload           11
    //  176  384:arraylength     
    //  177  385:icmplt          333
                }
                if(attweight != null)
    //* 178  388:aload           9
    //* 179  390:ifnull          409
                    nodes[i].weight = insi.value(attweight);
    //  180  393:aload_0         
    //  181  394:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //  182  397:iload_2         
    //  183  398:aaload          
    //  184  399:aload           10
    //  185  401:aload           9
    //  186  403:invokevirtual   #174 <Method double Instance.value(Attribute)>
    //  187  406:putfield        #177 <Field double RoleNodes$RNode.weight>
            }

    //  188  409:iinc            2  1
    //  189  412:aload           7
    //  190  414:invokeinterface #181 <Method boolean Enumeration.hasMoreElements()>
    //  191  419:ifne            278
        } else
    //* 192  422:goto            433
        {
            resetParents(nodes);
    //  193  425:aload_0         
    //  194  426:aload_0         
    //  195  427:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //  196  430:invokevirtual   #185 <Method void resetParents(RoleNodes$RNode[])>
        }
        for(int i = 0; i < matPA.getRowDimension(); i++)
    //* 197  433:iconst_0        
    //* 198  434:istore_2        
    //* 199  435:goto            486
        {
            for(int j = 0; j < matPA.getColumnDimension(); j++)
    //* 200  438:iconst_0        
    //* 201  439:istore_3        
    //* 202  440:goto            472
                if(matPA.get(i, j) == 1)
    //* 203  443:aload_0         
    //* 204  444:getfield        #47  <Field Matrix matPA>
    //* 205  447:iload_2         
    //* 206  448:iload_3         
    //* 207  449:invokevirtual   #189 <Method byte Matrix.get(int, int)>
    //* 208  452:iconst_1        
    //* 209  453:icmpne          469
                    nodes[i].SelfPerms.addElement(j);
    //  210  456:aload_0         
    //  211  457:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //  212  460:iload_2         
    //  213  461:aaload          
    //  214  462:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //  215  465:iload_3         
    //  216  466:invokevirtual   #192 <Method void IntegerSet.addElement(int)>

    //  217  469:iinc            3  1
    //  218  472:iload_3         
    //  219  473:aload_0         
    //  220  474:getfield        #47  <Field Matrix matPA>
    //  221  477:invokevirtual   #195 <Method int Matrix.getColumnDimension()>
    //  222  480:icmplt          443
        }

    //  223  483:iinc            2  1
    //  224  486:iload_2         
    //  225  487:aload_0         
    //  226  488:getfield        #47  <Field Matrix matPA>
    //  227  491:invokevirtual   #91  <Method int Matrix.getRowDimension()>
    //  228  494:icmplt          438
    //  229  497:return          
    }

    public void computeLocation(RNode nodes[])
    {
        Vector AllChildren[] = new Vector[nodes.length];
    //    0    0:aload_1         
    //    1    1:arraylength     
    //    2    2:anewarray       Vector[]
    //    3    5:astore          6
        boolean usedflags[] = new boolean[nodes.length];
    //    4    7:aload_1         
    //    5    8:arraylength     
    //    6    9:newarray        boolean[]
    //    7   11:astore          7
        for(int i = 0; i < nodes.length; i++)
    //*   8   13:iconst_0        
    //*   9   14:istore_2        
    //*  10   15:goto            37
        {
            AllChildren[i] = new Vector();
    //   11   18:aload           6
    //   12   20:iload_2         
    //   13   21:new             #214 <Class Vector>
    //   14   24:dup             
    //   15   25:invokespecial   #215 <Method void Vector()>
    //   16   28:aastore         
            usedflags[i] = false;
    //   17   29:aload           7
    //   18   31:iload_2         
    //   19   32:iconst_0        
    //   20   33:bastore         
        }

    //   21   34:iinc            2  1
    //   22   37:iload_2         
    //   23   38:aload_1         
    //   24   39:arraylength     
    //   25   40:icmplt          18
        for(int i = 0; i < nodes.length; i++)
    //*  26   43:iconst_0        
    //*  27   44:istore_2        
    //*  28   45:goto            130
        {
            List parents = nodes[i].Parents;
    //   29   48:aload_1         
    //   30   49:iload_2         
    //   31   50:aaload          
    //   32   51:getfield        #161 <Field List RoleNodes$RNode.Parents>
    //   33   54:astore          8
            for(int j = 0; j < parents.size(); j++)
    //*  34   56:iconst_0        
    //*  35   57:istore_3        
    //*  36   58:goto            116
                if(!AllChildren[((Integer)parents.get(j)).intValue()].contains(Integer.valueOf(i)))
    //*  37   61:aload           6
    //*  38   63:aload           8
    //*  39   65:iload_3         
    //*  40   66:invokeinterface #218 <Method Object List.get(int)>
    //*  41   71:checkcast       #153 <Class Integer>
    //*  42   74:invokevirtual   #221 <Method int Integer.intValue()>
    //*  43   77:aaload          
    //*  44   78:iload_2         
    //*  45   79:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //*  46   82:invokevirtual   #224 <Method boolean Vector.contains(Object)>
    //*  47   85:ifne            113
                    AllChildren[((Integer)parents.get(j)).intValue()].add(Integer.valueOf(i));
    //   48   88:aload           6
    //   49   90:aload           8
    //   50   92:iload_3         
    //   51   93:invokeinterface #218 <Method Object List.get(int)>
    //   52   98:checkcast       #153 <Class Integer>
    //   53  101:invokevirtual   #221 <Method int Integer.intValue()>
    //   54  104:aaload          
    //   55  105:iload_2         
    //   56  106:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //   57  109:invokevirtual   #225 <Method boolean Vector.add(Object)>
    //   58  112:pop             

    //   59  113:iinc            3  1
    //   60  116:iload_3         
    //   61  117:aload           8
    //   62  119:invokeinterface #228 <Method int List.size()>
    //   63  124:icmplt          61
        }

    //   64  127:iinc            2  1
    //   65  130:iload_2         
    //   66  131:aload_1         
    //   67  132:arraylength     
    //   68  133:icmplt          48
        int usednodes = nodes.length;
    //   69  136:aload_1         
    //   70  137:arraylength     
    //   71  138:istore          8
        int curlevel = 0;
    //   72  140:iconst_0        
    //   73  141:istore          9
        Vector NumofLevels = new Vector();
    //   74  143:new             #214 <Class Vector>
    //   75  146:dup             
    //   76  147:invokespecial   #215 <Method void Vector()>
    //   77  150:astore          10
    //*  78  152:goto            411
        while(usednodes > 0) 
        {
            Vector Allcurlevel = new Vector();
    //   79  155:new             #214 <Class Vector>
    //   80  158:dup             
    //   81  159:invokespecial   #215 <Method void Vector()>
    //   82  162:astore          11
            for(int i = 0; i < nodes.length; i++)
    //*  83  164:iconst_0        
    //*  84  165:istore_2        
    //*  85  166:goto            355
                if(!usedflags[i])
    //*  86  169:aload           7
    //*  87  171:iload_2         
    //*  88  172:baload          
    //*  89  173:ifne            352
                {
                    int j;
                    for(j = 0; j < AllChildren[i].size(); j++)
    //*  90  176:iconst_0        
    //*  91  177:istore_3        
    //*  92  178:goto            210
                        if(!usedflags[((Integer)(Integer)AllChildren[i].get(j)).intValue()])
    //*  93  181:aload           7
    //*  94  183:aload           6
    //*  95  185:iload_2         
    //*  96  186:aaload          
    //*  97  187:iload_3         
    //*  98  188:invokevirtual   #229 <Method Object Vector.get(int)>
    //*  99  191:checkcast       #153 <Class Integer>
    //* 100  194:checkcast       #153 <Class Integer>
    //* 101  197:invokevirtual   #221 <Method int Integer.intValue()>
    //* 102  200:baload          
    //* 103  201:ifne            207
                            break;
    //  104  204:goto            221

    //  105  207:iinc            3  1
    //  106  210:iload_3         
    //  107  211:aload           6
    //  108  213:iload_2         
    //  109  214:aaload          
    //  110  215:invokevirtual   #230 <Method int Vector.size()>
    //  111  218:icmplt          181
                    if(AllChildren[i].size() == 0 || j == AllChildren[i].size())
    //* 112  221:aload           6
    //* 113  223:iload_2         
    //* 114  224:aaload          
    //* 115  225:invokevirtual   #230 <Method int Vector.size()>
    //* 116  228:ifeq            242
    //* 117  231:iload_3         
    //* 118  232:aload           6
    //* 119  234:iload_2         
    //* 120  235:aaload          
    //* 121  236:invokevirtual   #230 <Method int Vector.size()>
    //* 122  239:icmpne          352
                    {
                        Allcurlevel.add(Integer.valueOf(i));
    //  123  242:aload           11
    //  124  244:iload_2         
    //  125  245:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //  126  248:invokevirtual   #225 <Method boolean Vector.add(Object)>
    //  127  251:pop             
                        nodes[i].Level = curlevel;
    //  128  252:aload_1         
    //  129  253:iload_2         
    //  130  254:aaload          
    //  131  255:iload           9
    //  132  257:putfield        #233 <Field int RoleNodes$RNode.Level>
                        usednodes--;
    //  133  260:iinc            8  -1
                        IntegerSet curset = new IntegerSet(n_Permissions);
    //  134  263:new             #96  <Class IntegerSet>
    //  135  266:dup             
    //  136  267:aload_0         
    //  137  268:getfield        #76  <Field int n_Permissions>
    //  138  271:invokespecial   #99  <Method void IntegerSet(int)>
    //  139  274:astore          12
                        for(int k = 0; k < AllChildren[i].size(); k++)
    //* 140  276:iconst_0        
    //* 141  277:istore          4
    //* 142  279:goto            319
                        {
                            int index = ((Integer)(Integer)AllChildren[i].get(k)).intValue();
    //  143  282:aload           6
    //  144  284:iload_2         
    //  145  285:aaload          
    //  146  286:iload           4
    //  147  288:invokevirtual   #229 <Method Object Vector.get(int)>
    //  148  291:checkcast       #153 <Class Integer>
    //  149  294:checkcast       #153 <Class Integer>
    //  150  297:invokevirtual   #221 <Method int Integer.intValue()>
    //  151  300:istore          13
                            curset = curset.getUnion(nodes[index].InheritPerms);
    //  152  302:aload           12
    //  153  304:aload_1         
    //  154  305:iload           13
    //  155  307:aaload          
    //  156  308:getfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
    //  157  311:invokevirtual   #237 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  158  314:astore          12
                        }

    //  159  316:iinc            4  1
    //  160  319:iload           4
    //  161  321:aload           6
    //  162  323:iload_2         
    //  163  324:aaload          
    //  164  325:invokevirtual   #230 <Method int Vector.size()>
    //  165  328:icmplt          282
                        curset = curset.getUnion(nodes[i].SelfPerms);
    //  166  331:aload           12
    //  167  333:aload_1         
    //  168  334:iload_2         
    //  169  335:aaload          
    //  170  336:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //  171  339:invokevirtual   #237 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //  172  342:astore          12
                        nodes[i].InheritPerms = curset;
    //  173  344:aload_1         
    //  174  345:iload_2         
    //  175  346:aaload          
    //  176  347:aload           12
    //  177  349:putfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
                    }
                }

    //  178  352:iinc            2  1
    //  179  355:iload_2         
    //  180  356:aload_1         
    //  181  357:arraylength     
    //  182  358:icmplt          169
            curlevel++;
    //  183  361:iinc            9  1
            for(int i = 0; i < Allcurlevel.size(); i++)
    //* 184  364:iconst_0        
    //* 185  365:istore_2        
    //* 186  366:goto            388
                usedflags[((Integer)Allcurlevel.get(i)).intValue()] = true;
    //  187  369:aload           7
    //  188  371:aload           11
    //  189  373:iload_2         
    //  190  374:invokevirtual   #229 <Method Object Vector.get(int)>
    //  191  377:checkcast       #153 <Class Integer>
    //  192  380:invokevirtual   #221 <Method int Integer.intValue()>
    //  193  383:iconst_1        
    //  194  384:bastore         

    //  195  385:iinc            2  1
    //  196  388:iload_2         
    //  197  389:aload           11
    //  198  391:invokevirtual   #230 <Method int Vector.size()>
    //  199  394:icmplt          369
            NumofLevels.add(Integer.valueOf(Allcurlevel.size()));
    //  200  397:aload           10
    //  201  399:aload           11
    //  202  401:invokevirtual   #230 <Method int Vector.size()>
    //  203  404:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //  204  407:invokevirtual   #225 <Method boolean Vector.add(Object)>
    //  205  410:pop             
        }
    //  206  411:iload           8
    //  207  413:ifgt            155
        for(int i = 0; i < nodes.length; i++)
    //* 208  416:iconst_0        
    //* 209  417:istore_2        
    //* 210  418:goto            445
            nodes[i].InheritPerms = nodes[i].InheritPerms.getDifference(nodes[i].SelfPerms);
    //  211  421:aload_1         
    //  212  422:iload_2         
    //  213  423:aaload          
    //  214  424:aload_1         
    //  215  425:iload_2         
    //  216  426:aaload          
    //  217  427:getfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
    //  218  430:aload_1         
    //  219  431:iload_2         
    //  220  432:aaload          
    //  221  433:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //  222  436:invokevirtual   #240 <Method IntegerSet IntegerSet.getDifference(IntegerSet)>
    //  223  439:putfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>

    //  224  442:iinc            2  1
    //  225  445:iload_2         
    //  226  446:aload_1         
    //  227  447:arraylength     
    //  228  448:icmplt          421
        getXYValues(nodes, NumofLevels);
    //  229  451:aload_0         
    //  230  452:aload_1         
    //  231  453:aload           10
    //  232  455:invokespecial   #244 <Method void getXYValues(RoleNodes$RNode[], Vector)>
    //  233  458:return          
    }

    private void getXYValues(RNode nodes[], Vector NumofLevels)
    {
        int maxRoles = ((Integer)NumofLevels.get(0)).intValue();
    //    0    0:aload_2         
    //    1    1:iconst_0        
    //    2    2:invokevirtual   #229 <Method Object Vector.get(int)>
    //    3    5:checkcast       #153 <Class Integer>
    //    4    8:invokevirtual   #221 <Method int Integer.intValue()>
    //    5   11:istore_3        
        for(int i = 0; i < NumofLevels.size(); i++)
    //*   6   12:iconst_0        
    //*   7   13:istore          4
    //*   8   15:goto            50
            if(maxRoles < ((Integer)NumofLevels.get(i)).intValue())
    //*   9   18:iload_3         
    //*  10   19:aload_2         
    //*  11   20:iload           4
    //*  12   22:invokevirtual   #229 <Method Object Vector.get(int)>
    //*  13   25:checkcast       #153 <Class Integer>
    //*  14   28:invokevirtual   #221 <Method int Integer.intValue()>
    //*  15   31:icmpge          47
                maxRoles = ((Integer)NumofLevels.get(i)).intValue();
    //   16   34:aload_2         
    //   17   35:iload           4
    //   18   37:invokevirtual   #229 <Method Object Vector.get(int)>
    //   19   40:checkcast       #153 <Class Integer>
    //   20   43:invokevirtual   #221 <Method int Integer.intValue()>
    //   21   46:istore_3        

    //   22   47:iinc            4  1
    //   23   50:iload           4
    //   24   52:aload_2         
    //   25   53:invokevirtual   #230 <Method int Vector.size()>
    //   26   56:icmplt          18
        int maxWidth = maxRoles * (80 + LevelWidth) + LevelWidth;
    //   27   59:iload_3         
    //   28   60:bipush          80
    //   29   62:getstatic       #27  <Field int LevelWidth>
    //   30   65:iadd            
    //   31   66:imul            
    //   32   67:getstatic       #27  <Field int LevelWidth>
    //   33   70:iadd            
    //   34   71:istore          4
        int curwidth = 0;
    //   35   73:iconst_0        
    //   36   74:istore          5
        int curheight = LevelHeight;
    //   37   76:getstatic       #25  <Field int LevelHeight>
    //   38   79:istore          6
        for(int i = 0; i < NumofLevels.size(); i++)
    //*  39   81:iconst_0        
    //*  40   82:istore          7
    //*  41   84:goto            208
        {
            double curLevelWidth = (maxWidth - ((Integer)NumofLevels.get(i)).intValue() * 80) / (((Integer)NumofLevels.get(i)).intValue() + 1);
    //   42   87:iload           4
    //   43   89:aload_2         
    //   44   90:iload           7
    //   45   92:invokevirtual   #229 <Method Object Vector.get(int)>
    //   46   95:checkcast       #153 <Class Integer>
    //   47   98:invokevirtual   #221 <Method int Integer.intValue()>
    //   48  101:bipush          80
    //   49  103:imul            
    //   50  104:isub            
    //   51  105:aload_2         
    //   52  106:iload           7
    //   53  108:invokevirtual   #229 <Method Object Vector.get(int)>
    //   54  111:checkcast       #153 <Class Integer>
    //   55  114:invokevirtual   #221 <Method int Integer.intValue()>
    //   56  117:iconst_1        
    //   57  118:iadd            
    //   58  119:idiv            
    //   59  120:i2d             
    //   60  121:dstore          8
            curLevelWidth = Math.floor(curLevelWidth);
    //   61  123:dload           8
    //   62  125:invokestatic    #266 <Method double Math.floor(double)>
    //   63  128:dstore          8
            curwidth = (int)curLevelWidth;
    //   64  130:dload           8
    //   65  132:d2i             
    //   66  133:istore          5
            for(int j = 0; j < nodes.length; j++)
    //*  67  135:iconst_0        
    //*  68  136:istore          10
    //*  69  138:goto            187
                if(nodes[j].Level == i)
    //*  70  141:aload_1         
    //*  71  142:iload           10
    //*  72  144:aaload          
    //*  73  145:getfield        #233 <Field int RoleNodes$RNode.Level>
    //*  74  148:iload           7
    //*  75  150:icmpne          184
                {
                    nodes[j].x = curwidth;
    //   76  153:aload_1         
    //   77  154:iload           10
    //   78  156:aaload          
    //   79  157:iload           5
    //   80  159:putfield        #269 <Field int RoleNodes$RNode.x>
                    nodes[j].y = curheight;
    //   81  162:aload_1         
    //   82  163:iload           10
    //   83  165:aaload          
    //   84  166:iload           6
    //   85  168:putfield        #272 <Field int RoleNodes$RNode.y>
                    curwidth = (int)((double)curwidth + (80D + curLevelWidth));
    //   86  171:iload           5
    //   87  173:i2d             
    //   88  174:ldc2w           #273 <Double 80D>
    //   89  177:dload           8
    //   90  179:dadd            
    //   91  180:dadd            
    //   92  181:d2i             
    //   93  182:istore          5
                }

    //   94  184:iinc            10  1
    //   95  187:iload           10
    //   96  189:aload_1         
    //   97  190:arraylength     
    //   98  191:icmplt          141
            curheight += 20 + LevelHeight;
    //   99  194:iload           6
    //  100  196:bipush          20
    //  101  198:getstatic       #25  <Field int LevelHeight>
    //  102  201:iadd            
    //  103  202:iadd            
    //  104  203:istore          6
        }

    //  105  205:iinc            7  1
    //  106  208:iload           7
    //  107  210:aload_2         
    //  108  211:invokevirtual   #230 <Method int Vector.size()>
    //  109  214:icmplt          87
    //  110  217:return          
    }

    public void resetParents(RNode nodes[])
    {
        Vector edges = new Vector();
    //    0    0:new             #214 <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #215 <Method void Vector()>
    //    3    7:astore_2        
        for(int i = 0; i < nodes.length; i++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            37
            nodes[i].SelfPerms = nodes[i].SelfPerms.getUnion(nodes[i].InheritPerms);
    //    7   13:aload_1         
    //    8   14:iload_3         
    //    9   15:aaload          
    //   10   16:aload_1         
    //   11   17:iload_3         
    //   12   18:aaload          
    //   13   19:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //   14   22:aload_1         
    //   15   23:iload_3         
    //   16   24:aaload          
    //   17   25:getfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
    //   18   28:invokevirtual   #237 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //   19   31:putfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>

    //   20   34:iinc            3  1
    //   21   37:iload_3         
    //   22   38:aload_1         
    //   23   39:arraylength     
    //   24   40:icmplt          13
        for(int i = 0; i < nodes.length; i++)
    //*  25   43:iconst_0        
    //*  26   44:istore_3        
    //*  27   45:goto            158
        {
            for(int j = 0; j < nodes.length; j++)
    //*  28   48:iconst_0        
    //*  29   49:istore          4
    //*  30   51:goto            148
                if(i != j)
    //*  31   54:iload_3         
    //*  32   55:iload           4
    //*  33   57:icmpeq          145
                {
                    IntegerSet curun = nodes[i].SelfPerms.getUnion(nodes[j].SelfPerms);
    //   34   60:aload_1         
    //   35   61:iload_3         
    //   36   62:aaload          
    //   37   63:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //   38   66:aload_1         
    //   39   67:iload           4
    //   40   69:aaload          
    //   41   70:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //   42   73:invokevirtual   #237 <Method IntegerSet IntegerSet.getUnion(IntegerSet)>
    //   43   76:astore          5
                    if(nodes[i].SelfPerms.getSize() < nodes[j].SelfPerms.getSize() && curun.equals(nodes[j].SelfPerms))
    //*  44   78:aload_1         
    //*  45   79:iload_3         
    //*  46   80:aaload          
    //*  47   81:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //*  48   84:invokevirtual   #282 <Method int IntegerSet.getSize()>
    //*  49   87:aload_1         
    //*  50   88:iload           4
    //*  51   90:aaload          
    //*  52   91:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //*  53   94:invokevirtual   #282 <Method int IntegerSet.getSize()>
    //*  54   97:icmpge          145
    //*  55  100:aload           5
    //*  56  102:aload_1         
    //*  57  103:iload           4
    //*  58  105:aaload          
    //*  59  106:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //*  60  109:invokevirtual   #285 <Method boolean IntegerSet.equals(IntegerSet)>
    //*  61  112:ifeq            145
                    {
                        Edge edge = new Edge();
    //   62  115:new             #287 <Class RoleNodes$Edge>
    //   63  118:dup             
    //   64  119:aload_0         
    //   65  120:invokespecial   #288 <Method void RoleNodes$Edge(RoleNodes)>
    //   66  123:astore          6
                        edge.from = i;
    //   67  125:aload           6
    //   68  127:iload_3         
    //   69  128:putfield        #291 <Field int RoleNodes$Edge.from>
                        edge.to = j;
    //   70  131:aload           6
    //   71  133:iload           4
    //   72  135:putfield        #294 <Field int RoleNodes$Edge.to>
                        edges.add(edge);
    //   73  138:aload_2         
    //   74  139:aload           6
    //   75  141:invokevirtual   #225 <Method boolean Vector.add(Object)>
    //   76  144:pop             
                    }
                }

    //   77  145:iinc            4  1
    //   78  148:iload           4
    //   79  150:aload_1         
    //   80  151:arraylength     
    //   81  152:icmplt          54
        }

    //   82  155:iinc            3  1
    //   83  158:iload_3         
    //   84  159:aload_1         
    //   85  160:arraylength     
    //   86  161:icmplt          48
        for(int i = 0; i < edges.size(); i++)
    //*  87  164:iconst_0        
    //*  88  165:istore_3        
    //*  89  166:goto            209
            if(FindPath(((Edge)edges.get(i)).from, ((Edge)edges.get(i)).to, edges) >= 2)
    //*  90  169:aload_0         
    //*  91  170:aload_2         
    //*  92  171:iload_3         
    //*  93  172:invokevirtual   #229 <Method Object Vector.get(int)>
    //*  94  175:checkcast       #287 <Class RoleNodes$Edge>
    //*  95  178:getfield        #291 <Field int RoleNodes$Edge.from>
    //*  96  181:aload_2         
    //*  97  182:iload_3         
    //*  98  183:invokevirtual   #229 <Method Object Vector.get(int)>
    //*  99  186:checkcast       #287 <Class RoleNodes$Edge>
    //* 100  189:getfield        #294 <Field int RoleNodes$Edge.to>
    //* 101  192:aload_2         
    //* 102  193:invokevirtual   #298 <Method int FindPath(int, int, Vector)>
    //* 103  196:iconst_2        
    //* 104  197:icmplt          206
                edges.remove(i);
    //  105  200:aload_2         
    //  106  201:iload_3         
    //  107  202:invokevirtual   #301 <Method Object Vector.remove(int)>
    //  108  205:pop             

    //  109  206:iinc            3  1
    //  110  209:iload_3         
    //  111  210:aload_2         
    //  112  211:invokevirtual   #230 <Method int Vector.size()>
    //  113  214:icmplt          169
        for(int i = 0; i < nodes.length; i++)
    //* 114  217:iconst_0        
    //* 115  218:istore_3        
    //* 116  219:goto            238
            nodes[i].Parents = new ArrayList();
    //  117  222:aload_1         
    //  118  223:iload_3         
    //  119  224:aaload          
    //  120  225:new             #303 <Class ArrayList>
    //  121  228:dup             
    //  122  229:invokespecial   #304 <Method void ArrayList()>
    //  123  232:putfield        #161 <Field List RoleNodes$RNode.Parents>

    //  124  235:iinc            3  1
    //  125  238:iload_3         
    //  126  239:aload_1         
    //  127  240:arraylength     
    //  128  241:icmplt          222
        for(int i = 0; i < edges.size(); i++)
    //* 129  244:iconst_0        
    //* 130  245:istore_3        
    //* 131  246:goto            288
            nodes[((Edge)edges.get(i)).from].Parents.add(Integer.valueOf(((Edge)edges.get(i)).to));
    //  132  249:aload_1         
    //  133  250:aload_2         
    //  134  251:iload_3         
    //  135  252:invokevirtual   #229 <Method Object Vector.get(int)>
    //  136  255:checkcast       #287 <Class RoleNodes$Edge>
    //  137  258:getfield        #291 <Field int RoleNodes$Edge.from>
    //  138  261:aaload          
    //  139  262:getfield        #161 <Field List RoleNodes$RNode.Parents>
    //  140  265:aload_2         
    //  141  266:iload_3         
    //  142  267:invokevirtual   #229 <Method Object Vector.get(int)>
    //  143  270:checkcast       #287 <Class RoleNodes$Edge>
    //  144  273:getfield        #294 <Field int RoleNodes$Edge.to>
    //  145  276:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //  146  279:invokeinterface #170 <Method boolean List.add(Object)>
    //  147  284:pop             

    //  148  285:iinc            3  1
    //  149  288:iload_3         
    //  150  289:aload_2         
    //  151  290:invokevirtual   #230 <Method int Vector.size()>
    //  152  293:icmplt          249
        for(int i = 0; i < nodes.length; i++)
    //* 153  296:iconst_0        
    //* 154  297:istore_3        
    //* 155  298:goto            325
            nodes[i].SelfPerms = nodes[i].SelfPerms.getDifference(nodes[i].InheritPerms);
    //  156  301:aload_1         
    //  157  302:iload_3         
    //  158  303:aaload          
    //  159  304:aload_1         
    //  160  305:iload_3         
    //  161  306:aaload          
    //  162  307:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //  163  310:aload_1         
    //  164  311:iload_3         
    //  165  312:aaload          
    //  166  313:getfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
    //  167  316:invokevirtual   #240 <Method IntegerSet IntegerSet.getDifference(IntegerSet)>
    //  168  319:putfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>

    //  169  322:iinc            3  1
    //  170  325:iload_3         
    //  171  326:aload_1         
    //  172  327:arraylength     
    //  173  328:icmplt          301
    //  174  331:return          
    }

    int FindPath(int from, int to, Vector edges)
    {
        int nopath = 0;
    //    0    0:iconst_0        
    //    1    1:istore          4
        int qnode = from;
    //    2    3:iload_1         
    //    3    4:istore          5
        ArrayDeque qnodes = new ArrayDeque();
    //    4    6:new             #312 <Class ArrayDeque>
    //    5    9:dup             
    //    6   10:invokespecial   #313 <Method void ArrayDeque()>
    //    7   13:astore          6
        qnodes.add(Integer.valueOf(from));
    //    8   15:aload           6
    //    9   17:iload_1         
    //   10   18:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //   11   21:invokevirtual   #314 <Method boolean ArrayDeque.add(Object)>
    //   12   24:pop             
    //*  13   25:goto            128
        while(!qnodes.isEmpty()) 
        {
            qnode = ((Integer)(Integer)qnodes.getFirst()).intValue();
    //   14   28:aload           6
    //   15   30:invokevirtual   #317 <Method Object ArrayDeque.getFirst()>
    //   16   33:checkcast       #153 <Class Integer>
    //   17   36:checkcast       #153 <Class Integer>
    //   18   39:invokevirtual   #221 <Method int Integer.intValue()>
    //   19   42:istore          5
            qnodes.removeFirst();
    //   20   44:aload           6
    //   21   46:invokevirtual   #320 <Method Object ArrayDeque.removeFirst()>
    //   22   49:pop             
            for(int i = 0; i < edges.size(); i++)
    //*  23   50:iconst_0        
    //*  24   51:istore          7
    //*  25   53:goto            119
                if(((Edge)edges.get(i)).from == qnode)
    //*  26   56:aload_3         
    //*  27   57:iload           7
    //*  28   59:invokevirtual   #229 <Method Object Vector.get(int)>
    //*  29   62:checkcast       #287 <Class RoleNodes$Edge>
    //*  30   65:getfield        #291 <Field int RoleNodes$Edge.from>
    //*  31   68:iload           5
    //*  32   70:icmpne          116
                    if(((Edge)edges.get(i)).to != to)
    //*  33   73:aload_3         
    //*  34   74:iload           7
    //*  35   76:invokevirtual   #229 <Method Object Vector.get(int)>
    //*  36   79:checkcast       #287 <Class RoleNodes$Edge>
    //*  37   82:getfield        #294 <Field int RoleNodes$Edge.to>
    //*  38   85:iload_2         
    //*  39   86:icmpeq          113
                        qnodes.add(Integer.valueOf(((Edge)edges.get(i)).to));
    //   40   89:aload           6
    //   41   91:aload_3         
    //   42   92:iload           7
    //   43   94:invokevirtual   #229 <Method Object Vector.get(int)>
    //   44   97:checkcast       #287 <Class RoleNodes$Edge>
    //   45  100:getfield        #294 <Field int RoleNodes$Edge.to>
    //   46  103:invokestatic    #165 <Method Integer Integer.valueOf(int)>
    //   47  106:invokevirtual   #314 <Method boolean ArrayDeque.add(Object)>
    //   48  109:pop             
                    else
    //*  49  110:goto            116
                        nopath++;
    //   50  113:iinc            4  1

    //   51  116:iinc            7  1
    //   52  119:iload           7
    //   53  121:aload_3         
    //   54  122:invokevirtual   #230 <Method int Vector.size()>
    //   55  125:icmplt          56
        }
    //   56  128:aload           6
    //   57  130:invokevirtual   #323 <Method boolean ArrayDeque.isEmpty()>
    //   58  133:ifeq            28
        return nopath;
    //   59  136:iload           4
    //   60  138:ireturn         
    }

    public String PermstoString(IntegerSet is)
    {
        StringBuffer txt = new StringBuffer();
    //    0    0:new             #331 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #332 <Method void StringBuffer()>
    //    3    7:astore_2        
        if(permset.length != is.getNelements())
    //*   4    8:aload_0         
    //*   5    9:getfield        #84  <Field Object[] permset>
    //*   6   12:arraylength     
    //*   7   13:aload_1         
    //*   8   14:invokevirtual   #335 <Method int IntegerSet.getNelements()>
    //*   9   17:icmpeq          22
            return null;
    //   10   20:aconst_null     
    //   11   21:areturn         
        txt.append("[");
    //   12   22:aload_2         
    //   13   23:ldc2            #337 <String "[">
    //   14   26:invokevirtual   #341 <Method StringBuffer StringBuffer.append(String)>
    //   15   29:pop             
        for(int i = 0; i < permset.length; i++)
    //*  16   30:iconst_0        
    //*  17   31:istore_3        
    //*  18   32:goto            76
            if(is.getElementAt(i))
    //*  19   35:aload_1         
    //*  20   36:iload_3         
    //*  21   37:invokevirtual   #345 <Method boolean IntegerSet.getElementAt(int)>
    //*  22   40:ifeq            73
                txt.append((new StringBuilder()).append(permset[i]).append(",").toString());
    //   23   43:aload_2         
    //   24   44:new             #347 <Class StringBuilder>
    //   25   47:dup             
    //   26   48:invokespecial   #348 <Method void StringBuilder()>
    //   27   51:aload_0         
    //   28   52:getfield        #84  <Field Object[] permset>
    //   29   55:iload_3         
    //   30   56:aaload          
    //   31   57:invokevirtual   #351 <Method StringBuilder StringBuilder.append(Object)>
    //   32   60:ldc2            #353 <String ",">
    //   33   63:invokevirtual   #356 <Method StringBuilder StringBuilder.append(String)>
    //   34   66:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   35   69:invokevirtual   #341 <Method StringBuffer StringBuffer.append(String)>
    //   36   72:pop             

    //   37   73:iinc            3  1
    //   38   76:iload_3         
    //   39   77:aload_0         
    //   40   78:getfield        #84  <Field Object[] permset>
    //   41   81:arraylength     
    //   42   82:icmplt          35
        if(is.getSize() > 0)
    //*  43   85:aload_1         
    //*  44   86:invokevirtual   #282 <Method int IntegerSet.getSize()>
    //*  45   89:ifle            103
            txt.deleteCharAt(txt.length() - 1);
    //   46   92:aload_2         
    //   47   93:aload_2         
    //   48   94:invokevirtual   #362 <Method int StringBuffer.length()>
    //   49   97:iconst_1        
    //   50   98:isub            
    //   51   99:invokevirtual   #366 <Method StringBuffer StringBuffer.deleteCharAt(int)>
    //   52  102:pop             
        txt.append("]");
    //   53  103:aload_2         
    //   54  104:ldc2            #368 <String "]">
    //   55  107:invokevirtual   #341 <Method StringBuffer StringBuffer.append(String)>
    //   56  110:pop             
        return txt.toString();
    //   57  111:aload_2         
    //   58  112:invokevirtual   #369 <Method String StringBuffer.toString()>
    //   59  115:areturn         
    }

    public void print()
    {
        for(int i = 0; i < nodes.length; i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            223
        {
            System.out.println((new StringBuilder("node: ")).append(i).toString());
    //    3    5:getstatic       #379 <Field PrintStream System.out>
    //    4    8:new             #347 <Class StringBuilder>
    //    5   11:dup             
    //    6   12:ldc2            #381 <String "node: ">
    //    7   15:invokespecial   #384 <Method void StringBuilder(String)>
    //    8   18:iload_1         
    //    9   19:invokevirtual   #387 <Method StringBuilder StringBuilder.append(int)>
    //   10   22:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   11   25:invokevirtual   #392 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("SelfPerms: ")).append(PermstoString(nodes[i].SelfPerms)).toString());
    //   12   28:getstatic       #379 <Field PrintStream System.out>
    //   13   31:new             #347 <Class StringBuilder>
    //   14   34:dup             
    //   15   35:ldc2            #394 <String "SelfPerms: ">
    //   16   38:invokespecial   #384 <Method void StringBuilder(String)>
    //   17   41:aload_0         
    //   18   42:aload_0         
    //   19   43:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   20   46:iload_1         
    //   21   47:aaload          
    //   22   48:getfield        #106 <Field IntegerSet RoleNodes$RNode.SelfPerms>
    //   23   51:invokevirtual   #396 <Method String PermstoString(IntegerSet)>
    //   24   54:invokevirtual   #356 <Method StringBuilder StringBuilder.append(String)>
    //   25   57:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   26   60:invokevirtual   #392 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("InheritPerms: ")).append(PermstoString(nodes[i].InheritPerms)).toString());
    //   27   63:getstatic       #379 <Field PrintStream System.out>
    //   28   66:new             #347 <Class StringBuilder>
    //   29   69:dup             
    //   30   70:ldc2            #398 <String "InheritPerms: ">
    //   31   73:invokespecial   #384 <Method void StringBuilder(String)>
    //   32   76:aload_0         
    //   33   77:aload_0         
    //   34   78:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   35   81:iload_1         
    //   36   82:aaload          
    //   37   83:getfield        #103 <Field IntegerSet RoleNodes$RNode.InheritPerms>
    //   38   86:invokevirtual   #396 <Method String PermstoString(IntegerSet)>
    //   39   89:invokevirtual   #356 <Method StringBuilder StringBuilder.append(String)>
    //   40   92:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   41   95:invokevirtual   #392 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Level: ")).append(nodes[i].Level).toString());
    //   42   98:getstatic       #379 <Field PrintStream System.out>
    //   43  101:new             #347 <Class StringBuilder>
    //   44  104:dup             
    //   45  105:ldc2            #400 <String "Level: ">
    //   46  108:invokespecial   #384 <Method void StringBuilder(String)>
    //   47  111:aload_0         
    //   48  112:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   49  115:iload_1         
    //   50  116:aaload          
    //   51  117:getfield        #233 <Field int RoleNodes$RNode.Level>
    //   52  120:invokevirtual   #387 <Method StringBuilder StringBuilder.append(int)>
    //   53  123:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   54  126:invokevirtual   #392 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("Parents: ")).append(nodes[i].Parents.toString()).toString());
    //   55  129:getstatic       #379 <Field PrintStream System.out>
    //   56  132:new             #347 <Class StringBuilder>
    //   57  135:dup             
    //   58  136:ldc2            #402 <String "Parents: ">
    //   59  139:invokespecial   #384 <Method void StringBuilder(String)>
    //   60  142:aload_0         
    //   61  143:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   62  146:iload_1         
    //   63  147:aaload          
    //   64  148:getfield        #161 <Field List RoleNodes$RNode.Parents>
    //   65  151:invokevirtual   #403 <Method String Object.toString()>
    //   66  154:invokevirtual   #356 <Method StringBuilder StringBuilder.append(String)>
    //   67  157:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   68  160:invokevirtual   #392 <Method void PrintStream.println(String)>
            System.out.println((new StringBuilder("X: ")).append(nodes[i].x).append(" Y: ").append(nodes[i].y).toString());
    //   69  163:getstatic       #379 <Field PrintStream System.out>
    //   70  166:new             #347 <Class StringBuilder>
    //   71  169:dup             
    //   72  170:ldc2            #405 <String "X: ">
    //   73  173:invokespecial   #384 <Method void StringBuilder(String)>
    //   74  176:aload_0         
    //   75  177:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   76  180:iload_1         
    //   77  181:aaload          
    //   78  182:getfield        #269 <Field int RoleNodes$RNode.x>
    //   79  185:invokevirtual   #387 <Method StringBuilder StringBuilder.append(int)>
    //   80  188:ldc2            #407 <String " Y: ">
    //   81  191:invokevirtual   #356 <Method StringBuilder StringBuilder.append(String)>
    //   82  194:aload_0         
    //   83  195:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   84  198:iload_1         
    //   85  199:aaload          
    //   86  200:getfield        #272 <Field int RoleNodes$RNode.y>
    //   87  203:invokevirtual   #387 <Method StringBuilder StringBuilder.append(int)>
    //   88  206:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   89  209:invokevirtual   #392 <Method void PrintStream.println(String)>
            System.out.println('\n');
    //   90  212:getstatic       #379 <Field PrintStream System.out>
    //   91  215:bipush          10
    //   92  217:invokevirtual   #410 <Method void PrintStream.println(char)>
        }

    //   93  220:iinc            1  1
    //   94  223:iload_1         
    //   95  224:aload_0         
    //   96  225:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //   97  228:arraylength     
    //   98  229:icmplt          5
    //   99  232:return          
    }

    public RNode[] getNodes()
    {
        return nodes;
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field RoleNodes$RNode[] nodes>
    //    2    4:areturn         
    }

    public void setNodes(RNode nodes[])
    {
        this.nodes = nodes;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #45  <Field RoleNodes$RNode[] nodes>
    //    3    5:return          
    }

    public int getN_Roles()
    {
        return n_Roles;
    //    0    0:aload_0         
    //    1    1:getfield        #74  <Field int n_Roles>
    //    2    4:ireturn         
    }

    public int getN_Permissions()
    {
        return n_Permissions;
    //    0    0:aload_0         
    //    1    1:getfield        #76  <Field int n_Permissions>
    //    2    4:ireturn         
    }

    public Matrix getMatPA()
    {
        return matPA;
    //    0    0:aload_0         
    //    1    1:getfield        #47  <Field Matrix matPA>
    //    2    4:areturn         
    }

    public Assignment getAssignment()
    {
        return m_assPA;
    //    0    0:aload_0         
    //    1    1:getfield        #43  <Field Assignment m_assPA>
    //    2    4:areturn         
    }

    public static void main(String args[])
        throws FileNotFoundException, IOException
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    //    0    0:invokestatic    #430 <Method String UIManager.getSystemLookAndFeelClassName()>
    //    1    3:invokestatic    #433 <Method void UIManager.setLookAndFeel(String)>
        }
    //*   2    6:goto            14
        catch(Exception exception)
    //*   3    9:astore_1        
        {
            exception.printStackTrace();
    //    4   10:aload_1         
    //    5   11:invokevirtual   #438 <Method void Exception.printStackTrace()>
        }
        File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\testrole.ass").toString());
    //    6   14:new             #440 <Class File>
    //    7   17:dup             
    //    8   18:new             #347 <Class StringBuilder>
    //    9   21:dup             
    //   10   22:ldc2            #442 <String "user.dir">
    //   11   25:invokestatic    #446 <Method String System.getProperty(String)>
    //   12   28:invokestatic    #449 <Method String String.valueOf(Object)>
    //   13   31:invokespecial   #384 <Method void StringBuilder(String)>
    //   14   34:ldc2            #451 <String "\\datasets\\testrole.ass">
    //   15   37:invokevirtual   #356 <Method StringBuilder StringBuilder.append(String)>
    //   16   40:invokevirtual   #359 <Method String StringBuilder.toString()>
    //   17   43:invokespecial   #452 <Method void File(String)>
    //   18   46:astore_1        
        AssLoader AL = new AssLoader(new FileReader(file));
    //   19   47:new             #454 <Class AssLoader>
    //   20   50:dup             
    //   21   51:new             #456 <Class FileReader>
    //   22   54:dup             
    //   23   55:aload_1         
    //   24   56:invokespecial   #459 <Method void FileReader(File)>
    //   25   59:invokespecial   #462 <Method void AssLoader(FileReader)>
    //   26   62:astore_2        
        RoleNodes rt = new RoleNodes(AL.getData());
    //   27   63:new             #2   <Class RoleNodes>
    //   28   66:dup             
    //   29   67:aload_2         
    //   30   68:invokevirtual   #465 <Method Assignment AssLoader.getData()>
    //   31   71:invokespecial   #467 <Method void RoleNodes(Assignment)>
    //   32   74:astore_3        
        rt.resetParents(rt.getNodes());
    //   33   75:aload_3         
    //   34   76:aload_3         
    //   35   77:invokevirtual   #469 <Method RoleNodes$RNode[] getNodes()>
    //   36   80:invokevirtual   #185 <Method void resetParents(RoleNodes$RNode[])>
        rt.computeLocation(rt.getNodes());
    //   37   83:aload_3         
    //   38   84:aload_3         
    //   39   85:invokevirtual   #469 <Method RoleNodes$RNode[] getNodes()>
    //   40   88:invokevirtual   #471 <Method void computeLocation(RoleNodes$RNode[])>
        rt.print();
    //   41   91:aload_3         
    //   42   92:invokevirtual   #473 <Method void print()>
    //   43   95:return          
    }

    private Assignment m_assPA;
    private int n_Roles;
    private int n_Permissions;
    private RNode nodes[];
    private static int LevelHeight = 50;
    private static int LevelWidth = 60;
    public static String columnNames[] = {
        "RoleName", "Permissions"
    };
    private Matrix matPA;
    private Object roleset[];
    private Object permset[];

    static 
    {
    //    0    0:bipush          50
    //    1    2:putstatic       #25  <Field int LevelHeight>
    //    2    5:bipush          60
    //    3    7:putstatic       #27  <Field int LevelWidth>
    //    4   10:iconst_2        
    //    5   11:anewarray       String[]
    //    6   14:dup             
    //    7   15:iconst_0        
    //    8   16:ldc1            #31  <String "RoleName">
    //    9   18:aastore         
    //   10   19:dup             
    //   11   20:iconst_1        
    //   12   21:ldc1            #33  <String "Permissions">
    //   13   23:aastore         
    //   14   24:putstatic       #35  <Field String[] columnNames>
    //*  15   27:return          
    }
}

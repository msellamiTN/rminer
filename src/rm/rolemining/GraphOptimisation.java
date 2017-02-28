// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   GraphOptimisation.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public class GraphOptimisation extends AbstractRoleminer
    implements OptionHandler
{
    public class permissionNode
    {

        public int getNumberOfpermissionNode()
        {
            return numberOfpermissionNode;
        //    0    0:aload_0         
        //    1    1:getfield        #26  <Field int numberOfpermissionNode>
        //    2    4:ireturn         
        }

        public void setNumberOfpermissionNode(int numberOfpermissionNode)
        {
            this.numberOfpermissionNode = numberOfpermissionNode;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #26  <Field int numberOfpermissionNode>
        //    3    5:return          
        }

        public String getPermissionName()
        {
            return permissionName;
        //    0    0:aload_0         
        //    1    1:getfield        #32  <Field String permissionName>
        //    2    4:areturn         
        }

        public void setPermissionName(String permissionName)
        {
            this.permissionName = permissionName;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #32  <Field String permissionName>
        //    3    5:return          
        }

        private int numberOfpermissionNode;
        private String permissionName;
        final GraphOptimisation this$0;

        public permissionNode()
        {
            this$0 = GraphOptimisation.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #15  <Field GraphOptimisation this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #18  <Method void Object()>
        //    5    9:return          
        }
    }

    public class roleNode
    {

        public int getNumberOfroleNode()
        {
            return numberOfroleNode;
        //    0    0:aload_0         
        //    1    1:getfield        #38  <Field int numberOfroleNode>
        //    2    4:ireturn         
        }

        public Vector getEdgesSet()
        {
            return edgesSet;
        //    0    0:aload_0         
        //    1    1:getfield        #30  <Field Vector edgesSet>
        //    2    4:areturn         
        }

        public void setEdgesSet(Vector edgesSet)
        {
            this.edgesSet = edgesSet;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #30  <Field Vector edgesSet>
        //    3    5:return          
        }

        public Vector getParentNodeList()
        {
            return parentNodeList;
        //    0    0:aload_0         
        //    1    1:getfield        #49  <Field Vector parentNodeList>
        //    2    4:areturn         
        }

        public void setParentNodeList(Vector parentNodeList)
        {
            this.parentNodeList = parentNodeList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #49  <Field Vector parentNodeList>
        //    3    5:return          
        }

        public void setNumberOfroleNode(int numberOfroleNode)
        {
            this.numberOfroleNode = numberOfroleNode;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #38  <Field int numberOfroleNode>
        //    3    5:return          
        }

        public Vector getPermissionSet()
        {
            return permissionSet;
        //    0    0:aload_0         
        //    1    1:getfield        #28  <Field Vector permissionSet>
        //    2    4:areturn         
        }

        public void setPermissionSet(Vector permissionSet)
        {
            this.permissionSet = permissionSet;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #28  <Field Vector permissionSet>
        //    3    5:return          
        }

        public String getRoleName()
        {
            return roleName;
        //    0    0:aload_0         
        //    1    1:getfield        #59  <Field String roleName>
        //    2    4:areturn         
        }

        public void setRoleName(String roleName)
        {
            this.roleName = roleName;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #59  <Field String roleName>
        //    3    5:return          
        }

        public Vector getUseList()
        {
            return useList;
        //    0    0:aload_0         
        //    1    1:getfield        #64  <Field Vector useList>
        //    2    4:areturn         
        }

        public void setUseList(Vector useList)
        {
            this.useList = useList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #64  <Field Vector useList>
        //    3    5:return          
        }

        private int numberOfroleNode;
        private String roleName;
        private Vector parentNodeList;
        private Vector useList;
        private Vector permissionSet;
        private Vector edgesSet;
        final GraphOptimisation this$0;

        public roleNode()
        {
            this$0 = GraphOptimisation.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #23  <Field GraphOptimisation this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #26  <Method void Object()>
            permissionSet = null;
        //    5    9:aload_0         
        //    6   10:aconst_null     
        //    7   11:putfield        #28  <Field Vector permissionSet>
            edgesSet = null;
        //    8   14:aload_0         
        //    9   15:aconst_null     
        //   10   16:putfield        #30  <Field Vector edgesSet>
        //   11   19:return          
        }
    }

    public class rolePermissionEdge
    {

        public int getFrom()
        {
            return from;
        //    0    0:aload_0         
        //    1    1:getfield        #26  <Field int from>
        //    2    4:ireturn         
        }

        public void setFrom(int from)
        {
            this.from = from;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #26  <Field int from>
        //    3    5:return          
        }

        public int getNumberOfedge()
        {
            return numberOfedge;
        //    0    0:aload_0         
        //    1    1:getfield        #31  <Field int numberOfedge>
        //    2    4:ireturn         
        }

        public void setNumberOfedge(int numberOfedge)
        {
            this.numberOfedge = numberOfedge;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #31  <Field int numberOfedge>
        //    3    5:return          
        }

        public int getTo()
        {
            return to;
        //    0    0:aload_0         
        //    1    1:getfield        #35  <Field int to>
        //    2    4:ireturn         
        }

        public void setTo(int to)
        {
            this.to = to;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #35  <Field int to>
        //    3    5:return          
        }

        private int numberOfedge;
        private int from;
        private int to;
        final GraphOptimisation this$0;

        public rolePermissionEdge()
        {
            this$0 = GraphOptimisation.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #15  <Field GraphOptimisation this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #18  <Method void Object()>
        //    5    9:return          
        }
    }

    public class roleRoleEdge
    {

        public int getFrom()
        {
            return from;
        //    0    0:aload_0         
        //    1    1:getfield        #25  <Field int from>
        //    2    4:ireturn         
        }

        public void setFrom(int from)
        {
            this.from = from;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #25  <Field int from>
        //    3    5:return          
        }

        public int getTo()
        {
            return to;
        //    0    0:aload_0         
        //    1    1:getfield        #30  <Field int to>
        //    2    4:ireturn         
        }

        public void setTo(int to)
        {
            this.to = to;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #30  <Field int to>
        //    3    5:return          
        }

        private int from;
        private int to;
        final GraphOptimisation this$0;

        public roleRoleEdge()
        {
            this$0 = GraphOptimisation.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #14  <Field GraphOptimisation this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #17  <Method void Object()>
        //    5    9:return          
        }
    }


    public GraphOptimisation()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #42  <Method void AbstractRoleminer()>
        log = new StringBuffer();
    //    2    4:aload_0         
    //    3    5:new             #44  <Class StringBuffer>
    //    4    8:dup             
    //    5    9:invokespecial   #45  <Method void StringBuffer()>
    //    6   12:putfield        #47  <Field StringBuffer log>
        roleNodeAscending = 0;
    //    7   15:aload_0         
    //    8   16:iconst_0        
    //    9   17:putfield        #49  <Field int roleNodeAscending>
        WSC = 0;
    //   10   20:aload_0         
    //   11   21:iconst_0        
    //   12   22:putfield        #51  <Field int WSC>
        deletionNodeNumber = new Vector();
    //   13   25:aload_0         
    //   14   26:new             #53  <Class Vector>
    //   15   29:dup             
    //   16   30:invokespecial   #54  <Method void Vector()>
    //   17   33:putfield        #56  <Field Vector deletionNodeNumber>
        rolePermissionEdgeSetAscending = 0;
    //   18   36:aload_0         
    //   19   37:iconst_0        
    //   20   38:putfield        #58  <Field int rolePermissionEdgeSetAscending>
        roleNodeSet = new Vector();
    //   21   41:aload_0         
    //   22   42:new             #53  <Class Vector>
    //   23   45:dup             
    //   24   46:invokespecial   #54  <Method void Vector()>
    //   25   49:putfield        #60  <Field Vector roleNodeSet>
        isRoleDealedWith = new Vector();
    //   26   52:aload_0         
    //   27   53:new             #53  <Class Vector>
    //   28   56:dup             
    //   29   57:invokespecial   #54  <Method void Vector()>
    //   30   60:putfield        #62  <Field Vector isRoleDealedWith>
        tempisRoleDealedWith = new Vector();
    //   31   63:aload_0         
    //   32   64:new             #53  <Class Vector>
    //   33   67:dup             
    //   34   68:invokespecial   #54  <Method void Vector()>
    //   35   71:putfield        #64  <Field Vector tempisRoleDealedWith>
        permissionNodeSet = new Vector();
    //   36   74:aload_0         
    //   37   75:new             #53  <Class Vector>
    //   38   78:dup             
    //   39   79:invokespecial   #54  <Method void Vector()>
    //   40   82:putfield        #66  <Field Vector permissionNodeSet>
        rolePermissionEdgeSet = new Vector();
    //   41   85:aload_0         
    //   42   86:new             #53  <Class Vector>
    //   43   89:dup             
    //   44   90:invokespecial   #54  <Method void Vector()>
    //   45   93:putfield        #68  <Field Vector rolePermissionEdgeSet>
        roleRoleEdgeSet = new Vector();
    //   46   96:aload_0         
    //   47   97:new             #53  <Class Vector>
    //   48  100:dup             
    //   49  101:invokespecial   #54  <Method void Vector()>
    //   50  104:putfield        #70  <Field Vector roleRoleEdgeSet>
        permissions = new Vector();
    //   51  107:aload_0         
    //   52  108:new             #53  <Class Vector>
    //   53  111:dup             
    //   54  112:invokespecial   #54  <Method void Vector()>
    //   55  115:putfield        #72  <Field Vector permissions>
        users = new Vector();
    //   56  118:aload_0         
    //   57  119:new             #53  <Class Vector>
    //   58  122:dup             
    //   59  123:invokespecial   #54  <Method void Vector()>
    //   60  126:putfield        #74  <Field Vector users>
        resetOptions();
    //   61  129:aload_0         
    //   62  130:invokevirtual   #77  <Method void resetOptions()>
    //   63  133:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #88  <Field Assignment m_assignment>
        constructionInitialRole(data);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokespecial   #91  <Method void constructionInitialRole(Assignment)>
        for(int Isdone = 1; Isdone > 0;)
    //*   6   10:iconst_1        
    //*   7   11:istore_2        
    //*   8   12:goto            32
        {
            Isdone = 0;
    //    9   15:iconst_0        
    //   10   16:istore_2        
            initisRoleDealedWith();
    //   11   17:aload_0         
    //   12   18:invokespecial   #94  <Method void initisRoleDealedWith()>
            if(oneTraversalAndDealWith(data))
    //*  13   21:aload_0         
    //*  14   22:aload_1         
    //*  15   23:invokespecial   #98  <Method boolean oneTraversalAndDealWith(Assignment)>
    //*  16   26:ifeq            32
                Isdone++;
    //   17   29:iinc            2  1
        }

    //   18   32:iload_2         
    //   19   33:ifgt            15
        updateNumber();
    //   20   36:aload_0         
    //   21   37:invokespecial   #101 <Method void updateNumber()>
        printRoleState();
    //   22   40:aload_0         
    //   23   41:invokespecial   #104 <Method void printRoleState()>
    //   24   44:return          
    }

    private void updateNumber()
    {
        int count = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        for(Iterator iterator = roleNodeSet.iterator(); iterator.hasNext();)
    //*   2    2:aload_0         
    //*   3    3:getfield        #60  <Field Vector roleNodeSet>
    //*   4    6:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   5    9:astore_3        
    //*   6   10:goto            151
        {
            roleNode roleA = (roleNode)iterator.next();
    //    7   13:aload_3         
    //    8   14:invokeinterface #116 <Method Object Iterator.next()>
    //    9   19:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   10   22:astore_2        
            int currentNo = roleA.getNumberOfroleNode();
    //   11   23:aload_2         
    //   12   24:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   13   27:istore          4
            roleA.setNumberOfroleNode(count);
    //   14   29:aload_2         
    //   15   30:iload_1         
    //   16   31:invokevirtual   #126 <Method void GraphOptimisation$roleNode.setNumberOfroleNode(int)>
            for(Iterator iterator1 = roleNodeSet.iterator(); iterator1.hasNext();)
    //*  17   34:aload_0         
    //*  18   35:getfield        #60  <Field Vector roleNodeSet>
    //*  19   38:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*  20   41:astore          6
    //*  21   43:goto            138
            {
                roleNode roleB = (roleNode)iterator1.next();
    //   22   46:aload           6
    //   23   48:invokeinterface #116 <Method Object Iterator.next()>
    //   24   53:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   25   56:astore          5
                if(roleB.getParentNodeList() != null)
    //*  26   58:aload           5
    //*  27   60:invokevirtual   #130 <Method Vector GraphOptimisation$roleNode.getParentNodeList()>
    //*  28   63:ifnull          138
                {
                    Vector parentSet = (Vector)roleB.getParentNodeList().clone();
    //   29   66:aload           5
    //   30   68:invokevirtual   #130 <Method Vector GraphOptimisation$roleNode.getParentNodeList()>
    //   31   71:invokevirtual   #133 <Method Object Vector.clone()>
    //   32   74:checkcast       #53  <Class Vector>
    //   33   77:astore          7
                    for(int index = 0; index < parentSet.size(); index++)
    //*  34   79:iconst_0        
    //*  35   80:istore          8
    //*  36   82:goto            121
                    {
                        if(((Integer)parentSet.get(index)).intValue() != currentNo)
                            continue;
    //   37   85:aload           7
    //   38   87:iload           8
    //   39   89:invokevirtual   #137 <Method Object Vector.get(int)>
    //   40   92:checkcast       #139 <Class Integer>
    //   41   95:invokevirtual   #142 <Method int Integer.intValue()>
    //   42   98:iload           4
    //   43  100:icmpne          118
                        parentSet.set(index, Integer.valueOf(count));
    //   44  103:aload           7
    //   45  105:iload           8
    //   46  107:iload_1         
    //   47  108:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   48  111:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //   49  114:pop             
                        break;
    //   50  115:goto            131
                    }

    //   51  118:iinc            8  1
    //   52  121:iload           8
    //   53  123:aload           7
    //   54  125:invokevirtual   #153 <Method int Vector.size()>
    //   55  128:icmplt          85
                    roleB.setParentNodeList(parentSet);
    //   56  131:aload           5
    //   57  133:aload           7
    //   58  135:invokevirtual   #157 <Method void GraphOptimisation$roleNode.setParentNodeList(Vector)>
                }
            }

    //   59  138:aload           6
    //   60  140:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   61  145:ifne            46
            count++;
    //   62  148:iinc            1  1
        }

    //   63  151:aload_3         
    //   64  152:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   65  157:ifne            13
    //   66  160:return          
    }

    private void printRoleState()
    {
        log.append("\n--------------------------------------------------------\n");
    //    0    0:aload_0         
    //    1    1:getfield        #47  <Field StringBuffer log>
    //    2    4:ldc1            #171 <String "\n--------------------------------------------------------\n">
    //    3    6:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //    4    9:pop             
        for(int i = 0; i < roleNodeSet.size(); i++)
    //*   5   10:iconst_0        
    //*   6   11:istore_1        
    //*   7   12:goto            423
        {
            log.append((new StringBuilder("The users of the ")).append(((roleNode)roleNodeSet.get(i)).getNumberOfroleNode()).append("th role are\uFF1A\n").toString());
    //    8   15:aload_0         
    //    9   16:getfield        #47  <Field StringBuffer log>
    //   10   19:new             #177 <Class StringBuilder>
    //   11   22:dup             
    //   12   23:ldc1            #179 <String "The users of the ">
    //   13   25:invokespecial   #182 <Method void StringBuilder(String)>
    //   14   28:aload_0         
    //   15   29:getfield        #60  <Field Vector roleNodeSet>
    //   16   32:iload_1         
    //   17   33:invokevirtual   #137 <Method Object Vector.get(int)>
    //   18   36:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   19   39:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   20   42:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   21   45:ldc1            #187 <String "th role are\uFF1A\n">
    //   22   47:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   23   50:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   24   53:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   25   56:pop             
            Vector userlist = ((roleNode)roleNodeSet.get(i)).getUseList();
    //   26   57:aload_0         
    //   27   58:getfield        #60  <Field Vector roleNodeSet>
    //   28   61:iload_1         
    //   29   62:invokevirtual   #137 <Method Object Vector.get(int)>
    //   30   65:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   31   68:invokevirtual   #197 <Method Vector GraphOptimisation$roleNode.getUseList()>
    //   32   71:astore_2        
            for(int index = 0; index < userlist.size(); index++)
    //*  33   72:iconst_0        
    //*  34   73:istore_3        
    //*  35   74:goto            187
                if(index != userlist.size() - 1)
    //*  36   77:iload_3         
    //*  37   78:aload_2         
    //*  38   79:invokevirtual   #153 <Method int Vector.size()>
    //*  39   82:iconst_1        
    //*  40   83:isub            
    //*  41   84:icmpeq          137
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)userlist.get(index)).intValue())))).append(",").toString());
    //   42   87:aload_0         
    //   43   88:getfield        #47  <Field StringBuffer log>
    //   44   91:new             #177 <Class StringBuilder>
    //   45   94:dup             
    //   46   95:aload_0         
    //   47   96:getfield        #74  <Field Vector users>
    //   48   99:aload_2         
    //   49  100:iload_3         
    //   50  101:invokevirtual   #137 <Method Object Vector.get(int)>
    //   51  104:checkcast       #139 <Class Integer>
    //   52  107:invokevirtual   #142 <Method int Integer.intValue()>
    //   53  110:invokevirtual   #137 <Method Object Vector.get(int)>
    //   54  113:checkcast       #199 <Class String>
    //   55  116:invokestatic    #202 <Method String String.valueOf(Object)>
    //   56  119:invokespecial   #182 <Method void StringBuilder(String)>
    //   57  122:ldc1            #204 <String ",">
    //   58  124:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   59  127:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   60  130:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   61  133:pop             
                else
    //*  62  134:goto            184
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)userlist.get(index)).intValue())))).append("\n").toString());
    //   63  137:aload_0         
    //   64  138:getfield        #47  <Field StringBuffer log>
    //   65  141:new             #177 <Class StringBuilder>
    //   66  144:dup             
    //   67  145:aload_0         
    //   68  146:getfield        #74  <Field Vector users>
    //   69  149:aload_2         
    //   70  150:iload_3         
    //   71  151:invokevirtual   #137 <Method Object Vector.get(int)>
    //   72  154:checkcast       #139 <Class Integer>
    //   73  157:invokevirtual   #142 <Method int Integer.intValue()>
    //   74  160:invokevirtual   #137 <Method Object Vector.get(int)>
    //   75  163:checkcast       #199 <Class String>
    //   76  166:invokestatic    #202 <Method String String.valueOf(Object)>
    //   77  169:invokespecial   #182 <Method void StringBuilder(String)>
    //   78  172:ldc1            #206 <String "\n">
    //   79  174:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   80  177:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   81  180:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   82  183:pop             

    //   83  184:iinc            3  1
    //   84  187:iload_3         
    //   85  188:aload_2         
    //   86  189:invokevirtual   #153 <Method int Vector.size()>
    //   87  192:icmplt          77
            log.append("The permissions are\uFF1A\n");
    //   88  195:aload_0         
    //   89  196:getfield        #47  <Field StringBuffer log>
    //   90  199:ldc1            #208 <String "The permissions are\uFF1A\n">
    //   91  201:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   92  204:pop             
            Vector permlist = ((roleNode)roleNodeSet.get(i)).getPermissionSet();
    //   93  205:aload_0         
    //   94  206:getfield        #60  <Field Vector roleNodeSet>
    //   95  209:iload_1         
    //   96  210:invokevirtual   #137 <Method Object Vector.get(int)>
    //   97  213:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   98  216:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //   99  219:astore_3        
            for(int index = 0; index < permlist.size(); index++)
    //* 100  220:iconst_0        
    //* 101  221:istore          4
    //* 102  223:goto            339
                if(index != permlist.size() - 1)
    //* 103  226:iload           4
    //* 104  228:aload_3         
    //* 105  229:invokevirtual   #153 <Method int Vector.size()>
    //* 106  232:iconst_1        
    //* 107  233:isub            
    //* 108  234:icmpeq          288
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)permlist.get(index)).intValue())))).append(",").toString());
    //  109  237:aload_0         
    //  110  238:getfield        #47  <Field StringBuffer log>
    //  111  241:new             #177 <Class StringBuilder>
    //  112  244:dup             
    //  113  245:aload_0         
    //  114  246:getfield        #72  <Field Vector permissions>
    //  115  249:aload_3         
    //  116  250:iload           4
    //  117  252:invokevirtual   #137 <Method Object Vector.get(int)>
    //  118  255:checkcast       #139 <Class Integer>
    //  119  258:invokevirtual   #142 <Method int Integer.intValue()>
    //  120  261:invokevirtual   #137 <Method Object Vector.get(int)>
    //  121  264:checkcast       #199 <Class String>
    //  122  267:invokestatic    #202 <Method String String.valueOf(Object)>
    //  123  270:invokespecial   #182 <Method void StringBuilder(String)>
    //  124  273:ldc1            #204 <String ",">
    //  125  275:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //  126  278:invokevirtual   #194 <Method String StringBuilder.toString()>
    //  127  281:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //  128  284:pop             
                else
    //* 129  285:goto            336
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)permlist.get(index)).intValue())))).append("\n").toString());
    //  130  288:aload_0         
    //  131  289:getfield        #47  <Field StringBuffer log>
    //  132  292:new             #177 <Class StringBuilder>
    //  133  295:dup             
    //  134  296:aload_0         
    //  135  297:getfield        #72  <Field Vector permissions>
    //  136  300:aload_3         
    //  137  301:iload           4
    //  138  303:invokevirtual   #137 <Method Object Vector.get(int)>
    //  139  306:checkcast       #139 <Class Integer>
    //  140  309:invokevirtual   #142 <Method int Integer.intValue()>
    //  141  312:invokevirtual   #137 <Method Object Vector.get(int)>
    //  142  315:checkcast       #199 <Class String>
    //  143  318:invokestatic    #202 <Method String String.valueOf(Object)>
    //  144  321:invokespecial   #182 <Method void StringBuilder(String)>
    //  145  324:ldc1            #206 <String "\n">
    //  146  326:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //  147  329:invokevirtual   #194 <Method String StringBuilder.toString()>
    //  148  332:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //  149  335:pop             

    //  150  336:iinc            4  1
    //  151  339:iload           4
    //  152  341:aload_3         
    //  153  342:invokevirtual   #153 <Method int Vector.size()>
    //  154  345:icmplt          226
            if(((roleNode)roleNodeSet.get(i)).getParentNodeList() != null)
    //* 155  348:aload_0         
    //* 156  349:getfield        #60  <Field Vector roleNodeSet>
    //* 157  352:iload_1         
    //* 158  353:invokevirtual   #137 <Method Object Vector.get(int)>
    //* 159  356:checkcast       #118 <Class GraphOptimisation$roleNode>
    //* 160  359:invokevirtual   #130 <Method Vector GraphOptimisation$roleNode.getParentNodeList()>
    //* 161  362:ifnull          410
                log.append((new StringBuilder("The parent nodes are\uFF1A")).append(((roleNode)roleNodeSet.get(i)).getParentNodeList()).append("\n").toString());
    //  162  365:aload_0         
    //  163  366:getfield        #47  <Field StringBuffer log>
    //  164  369:new             #177 <Class StringBuilder>
    //  165  372:dup             
    //  166  373:ldc1            #213 <String "The parent nodes are\uFF1A">
    //  167  375:invokespecial   #182 <Method void StringBuilder(String)>
    //  168  378:aload_0         
    //  169  379:getfield        #60  <Field Vector roleNodeSet>
    //  170  382:iload_1         
    //  171  383:invokevirtual   #137 <Method Object Vector.get(int)>
    //  172  386:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  173  389:invokevirtual   #130 <Method Vector GraphOptimisation$roleNode.getParentNodeList()>
    //  174  392:invokevirtual   #216 <Method StringBuilder StringBuilder.append(Object)>
    //  175  395:ldc1            #206 <String "\n">
    //  176  397:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //  177  400:invokevirtual   #194 <Method String StringBuilder.toString()>
    //  178  403:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //  179  406:pop             
            else
    //* 180  407:goto            420
                log.append("There is no parent node for current node.\n");
    //  181  410:aload_0         
    //  182  411:getfield        #47  <Field StringBuffer log>
    //  183  414:ldc1            #218 <String "There is no parent node for current node.\n">
    //  184  416:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //  185  419:pop             
        }

    //  186  420:iinc            1  1
    //  187  423:iload_1         
    //  188  424:aload_0         
    //  189  425:getfield        #60  <Field Vector roleNodeSet>
    //  190  428:invokevirtual   #153 <Method int Vector.size()>
    //  191  431:icmplt          15
        log.append("--------------------------------------------------------\n");
    //  192  434:aload_0         
    //  193  435:getfield        #47  <Field StringBuffer log>
    //  194  438:ldc1            #220 <String "--------------------------------------------------------\n">
    //  195  440:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //  196  443:pop             
    //  197  444:return          
    }

    private void computeWSC()
    {
        WSC += wp * permissions.size();
    //    0    0:aload_0         
    //    1    1:dup             
    //    2    2:getfield        #51  <Field int WSC>
    //    3    5:aload_0         
    //    4    6:getfield        #226 <Field int wp>
    //    5    9:aload_0         
    //    6   10:getfield        #72  <Field Vector permissions>
    //    7   13:invokevirtual   #153 <Method int Vector.size()>
    //    8   16:imul            
    //    9   17:iadd            
    //   10   18:putfield        #51  <Field int WSC>
        log.append((new StringBuilder("PA are\uFF1A")).append(permissions.size()).append("\n").toString());
    //   11   21:aload_0         
    //   12   22:getfield        #47  <Field StringBuffer log>
    //   13   25:new             #177 <Class StringBuilder>
    //   14   28:dup             
    //   15   29:ldc1            #228 <String "PA are\uFF1A">
    //   16   31:invokespecial   #182 <Method void StringBuilder(String)>
    //   17   34:aload_0         
    //   18   35:getfield        #72  <Field Vector permissions>
    //   19   38:invokevirtual   #153 <Method int Vector.size()>
    //   20   41:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   21   44:ldc1            #206 <String "\n">
    //   22   46:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   23   49:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   24   52:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   25   55:pop             
        WSC += wr * roleNodeAscending;
    //   26   56:aload_0         
    //   27   57:dup             
    //   28   58:getfield        #51  <Field int WSC>
    //   29   61:aload_0         
    //   30   62:getfield        #230 <Field int wr>
    //   31   65:aload_0         
    //   32   66:getfield        #49  <Field int roleNodeAscending>
    //   33   69:imul            
    //   34   70:iadd            
    //   35   71:putfield        #51  <Field int WSC>
        WSC += wh * roleRoleEdgeSet.size();
    //   36   74:aload_0         
    //   37   75:dup             
    //   38   76:getfield        #51  <Field int WSC>
    //   39   79:aload_0         
    //   40   80:getfield        #232 <Field int wh>
    //   41   83:aload_0         
    //   42   84:getfield        #70  <Field Vector roleRoleEdgeSet>
    //   43   87:invokevirtual   #153 <Method int Vector.size()>
    //   44   90:imul            
    //   45   91:iadd            
    //   46   92:putfield        #51  <Field int WSC>
        log.append((new StringBuilder("RH are\uFF1A")).append(roleRoleEdgeSet.size()).append("\n").toString());
    //   47   95:aload_0         
    //   48   96:getfield        #47  <Field StringBuffer log>
    //   49   99:new             #177 <Class StringBuilder>
    //   50  102:dup             
    //   51  103:ldc1            #234 <String "RH are\uFF1A">
    //   52  105:invokespecial   #182 <Method void StringBuilder(String)>
    //   53  108:aload_0         
    //   54  109:getfield        #70  <Field Vector roleRoleEdgeSet>
    //   55  112:invokevirtual   #153 <Method int Vector.size()>
    //   56  115:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   57  118:ldc1            #206 <String "\n">
    //   58  120:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   59  123:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   60  126:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   61  129:pop             
    //   62  130:return          
    }

    private void initisRoleDealedWith()
    {
        int sizeOfroleNodeSet = roleNodeSet.size();
    //    0    0:aload_0         
    //    1    1:getfield        #60  <Field Vector roleNodeSet>
    //    2    4:invokevirtual   #153 <Method int Vector.size()>
    //    3    7:istore_1        
        for(int index = 0; index < sizeOfroleNodeSet; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            54
        {
            Boolean Flag = new Boolean(true);
    //    7   13:new             #236 <Class Boolean>
    //    8   16:dup             
    //    9   17:iconst_1        
    //   10   18:invokespecial   #239 <Method void Boolean(boolean)>
    //   11   21:astore_3        
            Boolean tempFlag = new Boolean(false);
    //   12   22:new             #236 <Class Boolean>
    //   13   25:dup             
    //   14   26:iconst_0        
    //   15   27:invokespecial   #239 <Method void Boolean(boolean)>
    //   16   30:astore          4
            isRoleDealedWith.add(Flag);
    //   17   32:aload_0         
    //   18   33:getfield        #62  <Field Vector isRoleDealedWith>
    //   19   36:aload_3         
    //   20   37:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   21   40:pop             
            tempisRoleDealedWith.add(tempFlag);
    //   22   41:aload_0         
    //   23   42:getfield        #64  <Field Vector tempisRoleDealedWith>
    //   24   45:aload           4
    //   25   47:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   26   50:pop             
        }

    //   27   51:iinc            2  1
    //   28   54:iload_2         
    //   29   55:iload_1         
    //   30   56:icmplt          13
    //   31   59:return          
    }

    private boolean oneTraversalAndDealWith(Assignment data)
    {
        boolean hasdone = false;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        settempisRoleDealedWithfalse();
    //    2    2:aload_0         
    //    3    3:invokespecial   #250 <Method void settempisRoleDealedWithfalse()>
        for(int iindexOfroleNodeSet = 0; iindexOfroleNodeSet < roleNodeSet.size() - 1 && ((Boolean)isRoleDealedWith.get(iindexOfroleNodeSet)).booleanValue(); iindexOfroleNodeSet++)
    //*   4    6:iconst_0        
    //*   5    7:istore_3        
    //*   6    8:goto            123
        {
            for(int jiindexOfroleNodeSet = iindexOfroleNodeSet + 1; jiindexOfroleNodeSet < roleNodeSet.size() && ((Boolean)isRoleDealedWith.get(jiindexOfroleNodeSet)).booleanValue();)
    //*   7   11:iload_3         
    //*   8   12:iconst_1        
    //*   9   13:iadd            
    //*  10   14:istore          4
    //*  11   16:goto            90
            {
                roleNode firstOfroleNode = (roleNode)roleNodeSet.get(iindexOfroleNodeSet);
    //   12   19:aload_0         
    //   13   20:getfield        #60  <Field Vector roleNodeSet>
    //   14   23:iload_3         
    //   15   24:invokevirtual   #137 <Method Object Vector.get(int)>
    //   16   27:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   17   30:astore          5
                roleNode secondOfroleNode = (roleNode)roleNodeSet.get(jiindexOfroleNodeSet);
    //   18   32:aload_0         
    //   19   33:getfield        #60  <Field Vector roleNodeSet>
    //   20   36:iload           4
    //   21   38:invokevirtual   #137 <Method Object Vector.get(int)>
    //   22   41:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   23   44:astore          6
                if(firstOfroleNode.getPermissionSet().equals(secondOfroleNode.getPermissionSet()))
    //*  24   46:aload           5
    //*  25   48:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //*  26   51:aload           6
    //*  27   53:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //*  28   56:invokevirtual   #253 <Method boolean Vector.equals(Object)>
    //*  29   59:ifeq            87
                {
                    dealWithEuqal(iindexOfroleNodeSet, jiindexOfroleNodeSet);
    //   30   62:aload_0         
    //   31   63:iload_3         
    //   32   64:iload           4
    //   33   66:invokespecial   #257 <Method void dealWithEuqal(int, int)>
                    tempisRoleDealedWith.set(iindexOfroleNodeSet, Boolean.valueOf(true));
    //   34   69:aload_0         
    //   35   70:getfield        #64  <Field Vector tempisRoleDealedWith>
    //   36   73:iload_3         
    //   37   74:iconst_1        
    //   38   75:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //   39   78:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //   40   81:pop             
                    hasdone = true;
    //   41   82:iconst_1        
    //   42   83:istore_2        
                } else
    //*  43   84:goto            90
                {
                    jiindexOfroleNodeSet++;
    //   44   87:iinc            4  1
                }
            }

    //   45   90:iload           4
    //   46   92:aload_0         
    //   47   93:getfield        #60  <Field Vector roleNodeSet>
    //   48   96:invokevirtual   #153 <Method int Vector.size()>
    //   49   99:icmpge          120
    //   50  102:aload_0         
    //   51  103:getfield        #62  <Field Vector isRoleDealedWith>
    //   52  106:iload           4
    //   53  108:invokevirtual   #137 <Method Object Vector.get(int)>
    //   54  111:checkcast       #236 <Class Boolean>
    //   55  114:invokevirtual   #263 <Method boolean Boolean.booleanValue()>
    //   56  117:ifne            19
        }

    //   57  120:iinc            3  1
    //   58  123:iload_3         
    //   59  124:aload_0         
    //   60  125:getfield        #60  <Field Vector roleNodeSet>
    //   61  128:invokevirtual   #153 <Method int Vector.size()>
    //   62  131:iconst_1        
    //   63  132:isub            
    //   64  133:icmpge          153
    //   65  136:aload_0         
    //   66  137:getfield        #62  <Field Vector isRoleDealedWith>
    //   67  140:iload_3         
    //   68  141:invokevirtual   #137 <Method Object Vector.get(int)>
    //   69  144:checkcast       #236 <Class Boolean>
    //   70  147:invokevirtual   #263 <Method boolean Boolean.booleanValue()>
    //   71  150:ifne            11
        for(int iindexOfroleNodeSet = 0; iindexOfroleNodeSet < roleNodeSet.size() - 1 && ((Boolean)isRoleDealedWith.get(iindexOfroleNodeSet)).booleanValue(); iindexOfroleNodeSet++)
    //*  72  153:iconst_0        
    //*  73  154:istore_3        
    //*  74  155:goto            319
        {
            for(int jiindexOfroleNodeSet = iindexOfroleNodeSet + 1; jiindexOfroleNodeSet < roleNodeSet.size() && ((Boolean)isRoleDealedWith.get(jiindexOfroleNodeSet)).booleanValue(); jiindexOfroleNodeSet++)
    //*  75  158:iload_3         
    //*  76  159:iconst_1        
    //*  77  160:iadd            
    //*  78  161:istore          4
    //*  79  163:goto            286
            {
                roleNode firstOfroleNode = (roleNode)roleNodeSet.get(iindexOfroleNodeSet);
    //   80  166:aload_0         
    //   81  167:getfield        #60  <Field Vector roleNodeSet>
    //   82  170:iload_3         
    //   83  171:invokevirtual   #137 <Method Object Vector.get(int)>
    //   84  174:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   85  177:astore          5
                roleNode secondOfroleNode = (roleNode)roleNodeSet.get(jiindexOfroleNodeSet);
    //   86  179:aload_0         
    //   87  180:getfield        #60  <Field Vector roleNodeSet>
    //   88  183:iload           4
    //   89  185:invokevirtual   #137 <Method Object Vector.get(int)>
    //   90  188:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   91  191:astore          6
                if(firstOfroleNode.getPermissionSet().containsAll(secondOfroleNode.getPermissionSet()) && !hasEdge(firstOfroleNode, secondOfroleNode) || secondOfroleNode.getPermissionSet().containsAll(firstOfroleNode.getPermissionSet()) && !hasEdge(secondOfroleNode, firstOfroleNode))
    //*  92  193:aload           5
    //*  93  195:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //*  94  198:aload           6
    //*  95  200:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //*  96  203:invokevirtual   #267 <Method boolean Vector.containsAll(java.util.Collection)>
    //*  97  206:ifeq            220
    //*  98  209:aload_0         
    //*  99  210:aload           5
    //* 100  212:aload           6
    //* 101  214:invokespecial   #271 <Method boolean hasEdge(GraphOptimisation$roleNode, GraphOptimisation$roleNode)>
    //* 102  217:ifeq            247
    //* 103  220:aload           6
    //* 104  222:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //* 105  225:aload           5
    //* 106  227:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //* 107  230:invokevirtual   #267 <Method boolean Vector.containsAll(java.util.Collection)>
    //* 108  233:ifeq            283
    //* 109  236:aload_0         
    //* 110  237:aload           6
    //* 111  239:aload           5
    //* 112  241:invokespecial   #271 <Method boolean hasEdge(GraphOptimisation$roleNode, GraphOptimisation$roleNode)>
    //* 113  244:ifne            283
                {
                    dealWithSubset(iindexOfroleNodeSet, jiindexOfroleNodeSet);
    //  114  247:aload_0         
    //  115  248:iload_3         
    //  116  249:iload           4
    //  117  251:invokespecial   #274 <Method void dealWithSubset(int, int)>
                    tempisRoleDealedWith.set(iindexOfroleNodeSet, Boolean.valueOf(true));
    //  118  254:aload_0         
    //  119  255:getfield        #64  <Field Vector tempisRoleDealedWith>
    //  120  258:iload_3         
    //  121  259:iconst_1        
    //  122  260:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //  123  263:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //  124  266:pop             
                    tempisRoleDealedWith.set(jiindexOfroleNodeSet, Boolean.valueOf(true));
    //  125  267:aload_0         
    //  126  268:getfield        #64  <Field Vector tempisRoleDealedWith>
    //  127  271:iload           4
    //  128  273:iconst_1        
    //  129  274:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //  130  277:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //  131  280:pop             
                    hasdone = true;
    //  132  281:iconst_1        
    //  133  282:istore_2        
                }
            }

    //  134  283:iinc            4  1
    //  135  286:iload           4
    //  136  288:aload_0         
    //  137  289:getfield        #60  <Field Vector roleNodeSet>
    //  138  292:invokevirtual   #153 <Method int Vector.size()>
    //  139  295:icmpge          316
    //  140  298:aload_0         
    //  141  299:getfield        #62  <Field Vector isRoleDealedWith>
    //  142  302:iload           4
    //  143  304:invokevirtual   #137 <Method Object Vector.get(int)>
    //  144  307:checkcast       #236 <Class Boolean>
    //  145  310:invokevirtual   #263 <Method boolean Boolean.booleanValue()>
    //  146  313:ifne            166
        }

    //  147  316:iinc            3  1
    //  148  319:iload_3         
    //  149  320:aload_0         
    //  150  321:getfield        #60  <Field Vector roleNodeSet>
    //  151  324:invokevirtual   #153 <Method int Vector.size()>
    //  152  327:iconst_1        
    //  153  328:isub            
    //  154  329:icmpge          349
    //  155  332:aload_0         
    //  156  333:getfield        #62  <Field Vector isRoleDealedWith>
    //  157  336:iload_3         
    //  158  337:invokevirtual   #137 <Method Object Vector.get(int)>
    //  159  340:checkcast       #236 <Class Boolean>
    //  160  343:invokevirtual   #263 <Method boolean Boolean.booleanValue()>
    //  161  346:ifne            158
        for(int iindexOfroleNodeSet = 0; iindexOfroleNodeSet < roleNodeSet.size() - 1 && ((Boolean)isRoleDealedWith.get(iindexOfroleNodeSet)).booleanValue(); iindexOfroleNodeSet++)
    //* 162  349:iconst_0        
    //* 163  350:istore_3        
    //* 164  351:goto            512
        {
            for(int jiindexOfroleNodeSet = iindexOfroleNodeSet + 1; jiindexOfroleNodeSet < roleNodeSet.size() && ((Boolean)isRoleDealedWith.get(jiindexOfroleNodeSet)).booleanValue(); jiindexOfroleNodeSet++)
    //* 165  354:iload_3         
    //* 166  355:iconst_1        
    //* 167  356:iadd            
    //* 168  357:istore          4
    //* 169  359:goto            479
            {
                roleNode firstOfroleNode = (roleNode)roleNodeSet.get(iindexOfroleNodeSet);
    //  170  362:aload_0         
    //  171  363:getfield        #60  <Field Vector roleNodeSet>
    //  172  366:iload_3         
    //  173  367:invokevirtual   #137 <Method Object Vector.get(int)>
    //  174  370:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  175  373:astore          5
                roleNode secondOfroleNode = (roleNode)roleNodeSet.get(jiindexOfroleNodeSet);
    //  176  375:aload_0         
    //  177  376:getfield        #60  <Field Vector roleNodeSet>
    //  178  379:iload           4
    //  179  381:invokevirtual   #137 <Method Object Vector.get(int)>
    //  180  384:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  181  387:astore          6
                if(isIntersection(firstOfroleNode.getPermissionSet(), secondOfroleNode.getPermissionSet()).size() > 2 && !isSubset(firstOfroleNode, secondOfroleNode) && !hasOutsideEdge(firstOfroleNode) && !hasOutsideEdge(secondOfroleNode))
    //* 182  389:aload_0         
    //* 183  390:aload           5
    //* 184  392:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //* 185  395:aload           6
    //* 186  397:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //* 187  400:invokespecial   #278 <Method Vector isIntersection(Vector, Vector)>
    //* 188  403:invokevirtual   #153 <Method int Vector.size()>
    //* 189  406:iconst_2        
    //* 190  407:icmple          476
    //* 191  410:aload_0         
    //* 192  411:aload           5
    //* 193  413:aload           6
    //* 194  415:invokespecial   #281 <Method boolean isSubset(GraphOptimisation$roleNode, GraphOptimisation$roleNode)>
    //* 195  418:ifne            476
    //* 196  421:aload_0         
    //* 197  422:aload           5
    //* 198  424:invokespecial   #285 <Method boolean hasOutsideEdge(GraphOptimisation$roleNode)>
    //* 199  427:ifne            476
    //* 200  430:aload_0         
    //* 201  431:aload           6
    //* 202  433:invokespecial   #285 <Method boolean hasOutsideEdge(GraphOptimisation$roleNode)>
    //* 203  436:ifne            476
                {
                    dealWithIntersection(iindexOfroleNodeSet, jiindexOfroleNodeSet, data);
    //  204  439:aload_0         
    //  205  440:iload_3         
    //  206  441:iload           4
    //  207  443:aload_1         
    //  208  444:invokespecial   #289 <Method void dealWithIntersection(int, int, Assignment)>
                    tempisRoleDealedWith.set(iindexOfroleNodeSet, Boolean.valueOf(true));
    //  209  447:aload_0         
    //  210  448:getfield        #64  <Field Vector tempisRoleDealedWith>
    //  211  451:iload_3         
    //  212  452:iconst_1        
    //  213  453:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //  214  456:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //  215  459:pop             
                    tempisRoleDealedWith.set(jiindexOfroleNodeSet, Boolean.valueOf(true));
    //  216  460:aload_0         
    //  217  461:getfield        #64  <Field Vector tempisRoleDealedWith>
    //  218  464:iload           4
    //  219  466:iconst_1        
    //  220  467:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //  221  470:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //  222  473:pop             
                    hasdone = true;
    //  223  474:iconst_1        
    //  224  475:istore_2        
                }
            }

    //  225  476:iinc            4  1
    //  226  479:iload           4
    //  227  481:aload_0         
    //  228  482:getfield        #60  <Field Vector roleNodeSet>
    //  229  485:invokevirtual   #153 <Method int Vector.size()>
    //  230  488:icmpge          509
    //  231  491:aload_0         
    //  232  492:getfield        #62  <Field Vector isRoleDealedWith>
    //  233  495:iload           4
    //  234  497:invokevirtual   #137 <Method Object Vector.get(int)>
    //  235  500:checkcast       #236 <Class Boolean>
    //  236  503:invokevirtual   #263 <Method boolean Boolean.booleanValue()>
    //  237  506:ifne            362
        }

    //  238  509:iinc            3  1
    //  239  512:iload_3         
    //  240  513:aload_0         
    //  241  514:getfield        #60  <Field Vector roleNodeSet>
    //  242  517:invokevirtual   #153 <Method int Vector.size()>
    //  243  520:iconst_1        
    //  244  521:isub            
    //  245  522:icmpge          542
    //  246  525:aload_0         
    //  247  526:getfield        #62  <Field Vector isRoleDealedWith>
    //  248  529:iload_3         
    //  249  530:invokevirtual   #137 <Method Object Vector.get(int)>
    //  250  533:checkcast       #236 <Class Boolean>
    //  251  536:invokevirtual   #263 <Method boolean Boolean.booleanValue()>
    //  252  539:ifne            354
        if(hasdone)
    //* 253  542:iload_2         
    //* 254  543:ifeq            550
            assignmentFlag();
    //  255  546:aload_0         
    //  256  547:invokespecial   #292 <Method void assignmentFlag()>
        return hasdone;
    //  257  550:iload_2         
    //  258  551:ireturn         
    }

    private boolean isSubset(roleNode firstOfroleNode, roleNode secondOfroleNode)
    {
        return firstOfroleNode.getPermissionSet().containsAll(secondOfroleNode.getPermissionSet()) || secondOfroleNode.getPermissionSet().containsAll(firstOfroleNode.getPermissionSet());
    //    0    0:aload_1         
    //    1    1:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //    2    4:aload_2         
    //    3    5:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //    4    8:invokevirtual   #267 <Method boolean Vector.containsAll(java.util.Collection)>
    //    5   11:ifne            28
    //    6   14:aload_2         
    //    7   15:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //    8   18:aload_1         
    //    9   19:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //   10   22:invokevirtual   #267 <Method boolean Vector.containsAll(java.util.Collection)>
    //   11   25:ifeq            30
    //   12   28:iconst_1        
    //   13   29:ireturn         
    //   14   30:iconst_0        
    //   15   31:ireturn         
    }

    private boolean hasOutsideEdge(roleNode firstOfroleNode)
    {
        int sizeOfroleRoleEdgeSet = roleRoleEdgeSet.size();
    //    0    0:aload_0         
    //    1    1:getfield        #70  <Field Vector roleRoleEdgeSet>
    //    2    4:invokevirtual   #153 <Method int Vector.size()>
    //    3    7:istore_2        
        for(Iterator iterator = roleRoleEdgeSet.iterator(); iterator.hasNext();)
    //*   4    8:aload_0         
    //*   5    9:getfield        #70  <Field Vector roleRoleEdgeSet>
    //*   6   12:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   7   15:astore          4
    //*   8   17:goto            44
        {
            roleRoleEdge rrEdge = (roleRoleEdge)iterator.next();
    //    9   20:aload           4
    //   10   22:invokeinterface #116 <Method Object Iterator.next()>
    //   11   27:checkcast       #300 <Class GraphOptimisation$roleRoleEdge>
    //   12   30:astore_3        
            if(rrEdge.getFrom() == firstOfroleNode.getNumberOfroleNode())
    //*  13   31:aload_3         
    //*  14   32:invokevirtual   #303 <Method int GraphOptimisation$roleRoleEdge.getFrom()>
    //*  15   35:aload_1         
    //*  16   36:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  17   39:icmpne          44
                return true;
    //   18   42:iconst_1        
    //   19   43:ireturn         
        }

    //   20   44:aload           4
    //   21   46:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   22   51:ifne            20
        return false;
    //   23   54:iconst_0        
    //   24   55:ireturn         
    }

    private boolean hasEdge(roleNode firstOfroleNode, roleNode secondOfroleNode)
    {
        int sizeOfroleRoleEdgeSet = roleRoleEdgeSet.size();
    //    0    0:aload_0         
    //    1    1:getfield        #70  <Field Vector roleRoleEdgeSet>
    //    2    4:invokevirtual   #153 <Method int Vector.size()>
    //    3    7:istore_3        
        for(Iterator iterator = roleRoleEdgeSet.iterator(); iterator.hasNext();)
    //*   4    8:aload_0         
    //*   5    9:getfield        #70  <Field Vector roleRoleEdgeSet>
    //*   6   12:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   7   15:astore          5
    //*   8   17:goto            82
        {
            roleRoleEdge rrEdge = (roleRoleEdge)iterator.next();
    //    9   20:aload           5
    //   10   22:invokeinterface #116 <Method Object Iterator.next()>
    //   11   27:checkcast       #300 <Class GraphOptimisation$roleRoleEdge>
    //   12   30:astore          4
            if(rrEdge.getFrom() == firstOfroleNode.getNumberOfroleNode() && rrEdge.getTo() == secondOfroleNode.getNumberOfroleNode() || rrEdge.getFrom() == secondOfroleNode.getNumberOfroleNode() && rrEdge.getTo() == firstOfroleNode.getNumberOfroleNode())
    //*  13   32:aload           4
    //*  14   34:invokevirtual   #303 <Method int GraphOptimisation$roleRoleEdge.getFrom()>
    //*  15   37:aload_1         
    //*  16   38:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  17   41:icmpne          56
    //*  18   44:aload           4
    //*  19   46:invokevirtual   #309 <Method int GraphOptimisation$roleRoleEdge.getTo()>
    //*  20   49:aload_2         
    //*  21   50:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  22   53:icmpeq          80
    //*  23   56:aload           4
    //*  24   58:invokevirtual   #303 <Method int GraphOptimisation$roleRoleEdge.getFrom()>
    //*  25   61:aload_2         
    //*  26   62:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  27   65:icmpne          82
    //*  28   68:aload           4
    //*  29   70:invokevirtual   #309 <Method int GraphOptimisation$roleRoleEdge.getTo()>
    //*  30   73:aload_1         
    //*  31   74:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  32   77:icmpne          82
                return true;
    //   33   80:iconst_1        
    //   34   81:ireturn         
        }

    //   35   82:aload           5
    //   36   84:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   37   89:ifne            20
        return false;
    //   38   92:iconst_0        
    //   39   93:ireturn         
    }

    private void dealWithEuqal(int iindexOfroleNodeSet, int jiindexOfroleNodeSet)
    {
        deletionNodeNumber.add(Integer.valueOf(((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode()));
    //    0    0:aload_0         
    //    1    1:getfield        #56  <Field Vector deletionNodeNumber>
    //    2    4:aload_0         
    //    3    5:getfield        #60  <Field Vector roleNodeSet>
    //    4    8:iload_2         
    //    5    9:invokevirtual   #137 <Method Object Vector.get(int)>
    //    6   12:checkcast       #118 <Class GraphOptimisation$roleNode>
    //    7   15:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //    8   18:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //    9   21:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   10   24:pop             
        for(int index = 0; index < rolePermissionEdgeSet.size();)
    //*  11   25:iconst_0        
    //*  12   26:istore_3        
    //*  13   27:goto            76
            if(((rolePermissionEdge)rolePermissionEdgeSet.get(index)).getFrom() == ((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode())
    //*  14   30:aload_0         
    //*  15   31:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //*  16   34:iload_3         
    //*  17   35:invokevirtual   #137 <Method Object Vector.get(int)>
    //*  18   38:checkcast       #311 <Class GraphOptimisation$rolePermissionEdge>
    //*  19   41:invokevirtual   #312 <Method int GraphOptimisation$rolePermissionEdge.getFrom()>
    //*  20   44:aload_0         
    //*  21   45:getfield        #60  <Field Vector roleNodeSet>
    //*  22   48:iload_2         
    //*  23   49:invokevirtual   #137 <Method Object Vector.get(int)>
    //*  24   52:checkcast       #118 <Class GraphOptimisation$roleNode>
    //*  25   55:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  26   58:icmpne          73
                rolePermissionEdgeSet.remove(index);
    //   27   61:aload_0         
    //   28   62:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //   29   65:iload_3         
    //   30   66:invokevirtual   #315 <Method Object Vector.remove(int)>
    //   31   69:pop             
            else
    //*  32   70:goto            76
                index++;
    //   33   73:iinc            3  1

    //   34   76:iload_3         
    //   35   77:aload_0         
    //   36   78:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //   37   81:invokevirtual   #153 <Method int Vector.size()>
    //   38   84:icmplt          30
        roleNodeSet.remove(jiindexOfroleNodeSet);
    //   39   87:aload_0         
    //   40   88:getfield        #60  <Field Vector roleNodeSet>
    //   41   91:iload_2         
    //   42   92:invokevirtual   #315 <Method Object Vector.remove(int)>
    //   43   95:pop             
        tempisRoleDealedWith.remove(jiindexOfroleNodeSet);
    //   44   96:aload_0         
    //   45   97:getfield        #64  <Field Vector tempisRoleDealedWith>
    //   46  100:iload_2         
    //   47  101:invokevirtual   #315 <Method Object Vector.remove(int)>
    //   48  104:pop             
        isRoleDealedWith.remove(jiindexOfroleNodeSet);
    //   49  105:aload_0         
    //   50  106:getfield        #62  <Field Vector isRoleDealedWith>
    //   51  109:iload_2         
    //   52  110:invokevirtual   #315 <Method Object Vector.remove(int)>
    //   53  113:pop             
        roleNodeAscending--;
    //   54  114:aload_0         
    //   55  115:dup             
    //   56  116:getfield        #49  <Field int roleNodeAscending>
    //   57  119:iconst_1        
    //   58  120:isub            
    //   59  121:putfield        #49  <Field int roleNodeAscending>
    //   60  124:return          
    }

    private void dealWithSubset(int iindexOfroleNodeSet, int jiindexOfroleNodeSet)
    {
        boolean IsfirstBigger = ((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getPermissionSet().size() > ((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getPermissionSet().size();
    //    0    0:aload_0         
    //    1    1:getfield        #60  <Field Vector roleNodeSet>
    //    2    4:iload_1         
    //    3    5:invokevirtual   #137 <Method Object Vector.get(int)>
    //    4    8:checkcast       #118 <Class GraphOptimisation$roleNode>
    //    5   11:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //    6   14:invokevirtual   #153 <Method int Vector.size()>
    //    7   17:aload_0         
    //    8   18:getfield        #60  <Field Vector roleNodeSet>
    //    9   21:iload_2         
    //   10   22:invokevirtual   #137 <Method Object Vector.get(int)>
    //   11   25:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   12   28:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //   13   31:invokevirtual   #153 <Method int Vector.size()>
    //   14   34:icmple          41
    //   15   37:iconst_1        
    //   16   38:goto            42
    //   17   41:iconst_0        
    //   18   42:istore_3        
        roleRoleEdge rrEdge = new roleRoleEdge();
    //   19   43:new             #300 <Class GraphOptimisation$roleRoleEdge>
    //   20   46:dup             
    //   21   47:aload_0         
    //   22   48:invokespecial   #318 <Method void GraphOptimisation$roleRoleEdge(GraphOptimisation)>
    //   23   51:astore          4
        if(IsfirstBigger)
    //*  24   53:iload_3         
    //*  25   54:ifeq            146
        {
            rrEdge.setFrom(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getNumberOfroleNode());
    //   26   57:aload           4
    //   27   59:aload_0         
    //   28   60:getfield        #60  <Field Vector roleNodeSet>
    //   29   63:iload_1         
    //   30   64:invokevirtual   #137 <Method Object Vector.get(int)>
    //   31   67:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   32   70:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   33   73:invokevirtual   #321 <Method void GraphOptimisation$roleRoleEdge.setFrom(int)>
            rrEdge.setTo(((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode());
    //   34   76:aload           4
    //   35   78:aload_0         
    //   36   79:getfield        #60  <Field Vector roleNodeSet>
    //   37   82:iload_2         
    //   38   83:invokevirtual   #137 <Method Object Vector.get(int)>
    //   39   86:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   40   89:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   41   92:invokevirtual   #324 <Method void GraphOptimisation$roleRoleEdge.setTo(int)>
            Vector parentList = new Vector();
    //   42   95:new             #53  <Class Vector>
    //   43   98:dup             
    //   44   99:invokespecial   #54  <Method void Vector()>
    //   45  102:astore          5
            parentList.add(Integer.valueOf(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getNumberOfroleNode()));
    //   46  104:aload           5
    //   47  106:aload_0         
    //   48  107:getfield        #60  <Field Vector roleNodeSet>
    //   49  110:iload_1         
    //   50  111:invokevirtual   #137 <Method Object Vector.get(int)>
    //   51  114:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   52  117:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   53  120:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   54  123:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   55  126:pop             
            ((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).setParentNodeList(parentList);
    //   56  127:aload_0         
    //   57  128:getfield        #60  <Field Vector roleNodeSet>
    //   58  131:iload_2         
    //   59  132:invokevirtual   #137 <Method Object Vector.get(int)>
    //   60  135:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   61  138:aload           5
    //   62  140:invokevirtual   #157 <Method void GraphOptimisation$roleNode.setParentNodeList(Vector)>
        } else
    //*  63  143:goto            232
        {
            rrEdge.setFrom(((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode());
    //   64  146:aload           4
    //   65  148:aload_0         
    //   66  149:getfield        #60  <Field Vector roleNodeSet>
    //   67  152:iload_2         
    //   68  153:invokevirtual   #137 <Method Object Vector.get(int)>
    //   69  156:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   70  159:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   71  162:invokevirtual   #321 <Method void GraphOptimisation$roleRoleEdge.setFrom(int)>
            rrEdge.setTo(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getNumberOfroleNode());
    //   72  165:aload           4
    //   73  167:aload_0         
    //   74  168:getfield        #60  <Field Vector roleNodeSet>
    //   75  171:iload_1         
    //   76  172:invokevirtual   #137 <Method Object Vector.get(int)>
    //   77  175:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   78  178:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   79  181:invokevirtual   #324 <Method void GraphOptimisation$roleRoleEdge.setTo(int)>
            Vector parentList = new Vector();
    //   80  184:new             #53  <Class Vector>
    //   81  187:dup             
    //   82  188:invokespecial   #54  <Method void Vector()>
    //   83  191:astore          5
            parentList.add(Integer.valueOf(((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode()));
    //   84  193:aload           5
    //   85  195:aload_0         
    //   86  196:getfield        #60  <Field Vector roleNodeSet>
    //   87  199:iload_2         
    //   88  200:invokevirtual   #137 <Method Object Vector.get(int)>
    //   89  203:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   90  206:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   91  209:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   92  212:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   93  215:pop             
            ((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).setParentNodeList(parentList);
    //   94  216:aload_0         
    //   95  217:getfield        #60  <Field Vector roleNodeSet>
    //   96  220:iload_1         
    //   97  221:invokevirtual   #137 <Method Object Vector.get(int)>
    //   98  224:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   99  227:aload           5
    //  100  229:invokevirtual   #157 <Method void GraphOptimisation$roleNode.setParentNodeList(Vector)>
        }
        roleRoleEdgeSet.add(rrEdge);
    //  101  232:aload_0         
    //  102  233:getfield        #70  <Field Vector roleRoleEdgeSet>
    //  103  236:aload           4
    //  104  238:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //  105  241:pop             
        Vector deletionEdgeOfPermission = isIntersection(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getPermissionSet(), ((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getPermissionSet());
    //  106  242:aload_0         
    //  107  243:aload_0         
    //  108  244:getfield        #60  <Field Vector roleNodeSet>
    //  109  247:iload_1         
    //  110  248:invokevirtual   #137 <Method Object Vector.get(int)>
    //  111  251:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  112  254:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //  113  257:aload_0         
    //  114  258:getfield        #60  <Field Vector roleNodeSet>
    //  115  261:iload_2         
    //  116  262:invokevirtual   #137 <Method Object Vector.get(int)>
    //  117  265:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  118  268:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //  119  271:invokespecial   #278 <Method Vector isIntersection(Vector, Vector)>
    //  120  274:astore          5
        if(IsfirstBigger)
    //* 121  276:iload_3         
    //* 122  277:ifeq            290
            deleteRolePermissionEdges(iindexOfroleNodeSet, deletionEdgeOfPermission);
    //  123  280:aload_0         
    //  124  281:iload_1         
    //  125  282:aload           5
    //  126  284:invokespecial   #328 <Method void deleteRolePermissionEdges(int, Vector)>
        else
    //* 127  287:goto            297
            deleteRolePermissionEdges(jiindexOfroleNodeSet, deletionEdgeOfPermission);
    //  128  290:aload_0         
    //  129  291:iload_2         
    //  130  292:aload           5
    //  131  294:invokespecial   #328 <Method void deleteRolePermissionEdges(int, Vector)>
    //  132  297:return          
    }

    private void dealWithIntersection(int iindexOfroleNodeSet, int jiindexOfroleNodeSet, Assignment data)
    {
        Matrix mat = data.getAssignmentMatrix();
    //    0    0:aload_3         
    //    1    1:invokevirtual   #337 <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore          4
        Vector maxIntersection = isIntersection(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getPermissionSet(), ((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getPermissionSet());
    //    3    6:aload_0         
    //    4    7:aload_0         
    //    5    8:getfield        #60  <Field Vector roleNodeSet>
    //    6   11:iload_1         
    //    7   12:invokevirtual   #137 <Method Object Vector.get(int)>
    //    8   15:checkcast       #118 <Class GraphOptimisation$roleNode>
    //    9   18:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //   10   21:aload_0         
    //   11   22:getfield        #60  <Field Vector roleNodeSet>
    //   12   25:iload_2         
    //   13   26:invokevirtual   #137 <Method Object Vector.get(int)>
    //   14   29:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   15   32:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //   16   35:invokespecial   #278 <Method Vector isIntersection(Vector, Vector)>
    //   17   38:astore          5
        int rolenumber = roleContainmaxIntersection(maxIntersection);
    //   18   40:aload_0         
    //   19   41:aload           5
    //   20   43:invokespecial   #341 <Method int roleContainmaxIntersection(Vector)>
    //   21   46:istore          6
        if(rolenumber == -1)
    //*  22   48:iload           6
    //*  23   50:iconst_m1       
    //*  24   51:icmpne          336
        {
            roleNode rNode = new roleNode();
    //   25   54:new             #118 <Class GraphOptimisation$roleNode>
    //   26   57:dup             
    //   27   58:aload_0         
    //   28   59:invokespecial   #342 <Method void GraphOptimisation$roleNode(GraphOptimisation)>
    //   29   62:astore          7
            int isableNumber = 0;
    //   30   64:iconst_0        
    //   31   65:istore          8
            if(!deletionNodeNumber.isEmpty())
    //*  32   67:aload_0         
    //*  33   68:getfield        #56  <Field Vector deletionNodeNumber>
    //*  34   71:invokevirtual   #345 <Method boolean Vector.isEmpty()>
    //*  35   74:ifne            96
                isableNumber = ((Integer)deletionNodeNumber.get(0)).intValue();
    //   36   77:aload_0         
    //   37   78:getfield        #56  <Field Vector deletionNodeNumber>
    //   38   81:iconst_0        
    //   39   82:invokevirtual   #137 <Method Object Vector.get(int)>
    //   40   85:checkcast       #139 <Class Integer>
    //   41   88:invokevirtual   #142 <Method int Integer.intValue()>
    //   42   91:istore          8
            else
    //*  43   93:goto            102
                isableNumber = roleNodeAscending;
    //   44   96:aload_0         
    //   45   97:getfield        #49  <Field int roleNodeAscending>
    //   46  100:istore          8
            rNode.setRoleName((new StringBuilder("r")).append(isableNumber).toString());
    //   47  102:aload           7
    //   48  104:new             #177 <Class StringBuilder>
    //   49  107:dup             
    //   50  108:ldc2            #347 <String "r">
    //   51  111:invokespecial   #182 <Method void StringBuilder(String)>
    //   52  114:iload           8
    //   53  116:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   54  119:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   55  122:invokevirtual   #350 <Method void GraphOptimisation$roleNode.setRoleName(String)>
            rNode.setPermissionSet(maxIntersection);
    //   56  125:aload           7
    //   57  127:aload           5
    //   58  129:invokevirtual   #353 <Method void GraphOptimisation$roleNode.setPermissionSet(Vector)>
            rNode.setEdgesSet(createRolepermissionEdges(isableNumber, maxIntersection));
    //   59  132:aload           7
    //   60  134:aload_0         
    //   61  135:iload           8
    //   62  137:aload           5
    //   63  139:invokespecial   #357 <Method Vector createRolepermissionEdges(int, Vector)>
    //   64  142:invokevirtual   #360 <Method void GraphOptimisation$roleNode.setEdgesSet(Vector)>
            Vector parentList = new Vector();
    //   65  145:new             #53  <Class Vector>
    //   66  148:dup             
    //   67  149:invokespecial   #54  <Method void Vector()>
    //   68  152:astore          9
            parentList.add(Integer.valueOf(iindexOfroleNodeSet));
    //   69  154:aload           9
    //   70  156:iload_1         
    //   71  157:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   72  160:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   73  163:pop             
            parentList.add(Integer.valueOf(jiindexOfroleNodeSet));
    //   74  164:aload           9
    //   75  166:iload_2         
    //   76  167:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   77  170:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   78  173:pop             
            rNode.setParentNodeList(parentList);
    //   79  174:aload           7
    //   80  176:aload           9
    //   81  178:invokevirtual   #157 <Method void GraphOptimisation$roleNode.setParentNodeList(Vector)>
            Vector userSet = getUserSet(maxIntersection, mat);
    //   82  181:aload_0         
    //   83  182:aload           5
    //   84  184:aload           4
    //   85  186:invokespecial   #364 <Method Vector getUserSet(Vector, Matrix)>
    //   86  189:astore          10
            rNode.setUseList(userSet);
    //   87  191:aload           7
    //   88  193:aload           10
    //   89  195:invokevirtual   #367 <Method void GraphOptimisation$roleNode.setUseList(Vector)>
            Boolean roleFlag = new Boolean(false);
    //   90  198:new             #236 <Class Boolean>
    //   91  201:dup             
    //   92  202:iconst_0        
    //   93  203:invokespecial   #239 <Method void Boolean(boolean)>
    //   94  206:astore          11
            tempisRoleDealedWith.add(roleFlag);
    //   95  208:aload_0         
    //   96  209:getfield        #64  <Field Vector tempisRoleDealedWith>
    //   97  212:aload           11
    //   98  214:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   99  217:pop             
            Boolean Flag = new Boolean(false);
    //  100  218:new             #236 <Class Boolean>
    //  101  221:dup             
    //  102  222:iconst_0        
    //  103  223:invokespecial   #239 <Method void Boolean(boolean)>
    //  104  226:astore          12
            isRoleDealedWith.add(Flag);
    //  105  228:aload_0         
    //  106  229:getfield        #62  <Field Vector isRoleDealedWith>
    //  107  232:aload           12
    //  108  234:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //  109  237:pop             
            tempisRoleDealedWith.set(isableNumber, Boolean.valueOf(true));
    //  110  238:aload_0         
    //  111  239:getfield        #64  <Field Vector tempisRoleDealedWith>
    //  112  242:iload           8
    //  113  244:iconst_1        
    //  114  245:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //  115  248:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //  116  251:pop             
            rNode.setNumberOfroleNode(isableNumber);
    //  117  252:aload           7
    //  118  254:iload           8
    //  119  256:invokevirtual   #126 <Method void GraphOptimisation$roleNode.setNumberOfroleNode(int)>
            roleNodeAscending++;
    //  120  259:aload_0         
    //  121  260:dup             
    //  122  261:getfield        #49  <Field int roleNodeAscending>
    //  123  264:iconst_1        
    //  124  265:iadd            
    //  125  266:putfield        #49  <Field int roleNodeAscending>
            roleNodeSet.add(rNode);
    //  126  269:aload_0         
    //  127  270:getfield        #60  <Field Vector roleNodeSet>
    //  128  273:aload           7
    //  129  275:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //  130  278:pop             
            createRoleRoleEdge(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getNumberOfroleNode(), isableNumber);
    //  131  279:aload_0         
    //  132  280:aload_0         
    //  133  281:getfield        #60  <Field Vector roleNodeSet>
    //  134  284:iload_1         
    //  135  285:invokevirtual   #137 <Method Object Vector.get(int)>
    //  136  288:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  137  291:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //  138  294:iload           8
    //  139  296:invokespecial   #370 <Method void createRoleRoleEdge(int, int)>
            createRoleRoleEdge(((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode(), isableNumber);
    //  140  299:aload_0         
    //  141  300:aload_0         
    //  142  301:getfield        #60  <Field Vector roleNodeSet>
    //  143  304:iload_2         
    //  144  305:invokevirtual   #137 <Method Object Vector.get(int)>
    //  145  308:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  146  311:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //  147  314:iload           8
    //  148  316:invokespecial   #370 <Method void createRoleRoleEdge(int, int)>
            deleteRolePermissionEdges(iindexOfroleNodeSet, maxIntersection);
    //  149  319:aload_0         
    //  150  320:iload_1         
    //  151  321:aload           5
    //  152  323:invokespecial   #328 <Method void deleteRolePermissionEdges(int, Vector)>
            deleteRolePermissionEdges(jiindexOfroleNodeSet, maxIntersection);
    //  153  326:aload_0         
    //  154  327:iload_2         
    //  155  328:aload           5
    //  156  330:invokespecial   #328 <Method void deleteRolePermissionEdges(int, Vector)>
        } else
    //* 157  333:goto            390
        {
            createRoleRoleEdge(((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getNumberOfroleNode(), rolenumber);
    //  158  336:aload_0         
    //  159  337:aload_0         
    //  160  338:getfield        #60  <Field Vector roleNodeSet>
    //  161  341:iload_1         
    //  162  342:invokevirtual   #137 <Method Object Vector.get(int)>
    //  163  345:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  164  348:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //  165  351:iload           6
    //  166  353:invokespecial   #370 <Method void createRoleRoleEdge(int, int)>
            createRoleRoleEdge(((roleNode)roleNodeSet.get(jiindexOfroleNodeSet)).getNumberOfroleNode(), rolenumber);
    //  167  356:aload_0         
    //  168  357:aload_0         
    //  169  358:getfield        #60  <Field Vector roleNodeSet>
    //  170  361:iload_2         
    //  171  362:invokevirtual   #137 <Method Object Vector.get(int)>
    //  172  365:checkcast       #118 <Class GraphOptimisation$roleNode>
    //  173  368:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //  174  371:iload           6
    //  175  373:invokespecial   #370 <Method void createRoleRoleEdge(int, int)>
            deleteRolePermissionEdges(iindexOfroleNodeSet, maxIntersection);
    //  176  376:aload_0         
    //  177  377:iload_1         
    //  178  378:aload           5
    //  179  380:invokespecial   #328 <Method void deleteRolePermissionEdges(int, Vector)>
            deleteRolePermissionEdges(jiindexOfroleNodeSet, maxIntersection);
    //  180  383:aload_0         
    //  181  384:iload_2         
    //  182  385:aload           5
    //  183  387:invokespecial   #328 <Method void deleteRolePermissionEdges(int, Vector)>
        }
    //  184  390:return          
    }

    private int roleContainmaxIntersection(Vector maxIntersection)
    {
        for(Iterator iterator = roleNodeSet.iterator(); iterator.hasNext();)
    //*   0    0:aload_0         
    //*   1    1:getfield        #60  <Field Vector roleNodeSet>
    //*   2    4:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   3    7:astore_3        
    //*   4    8:goto            37
        {
            roleNode roNode = (roleNode)iterator.next();
    //    5   11:aload_3         
    //    6   12:invokeinterface #116 <Method Object Iterator.next()>
    //    7   17:checkcast       #118 <Class GraphOptimisation$roleNode>
    //    8   20:astore_2        
            if(roNode.getPermissionSet().equals(maxIntersection))
    //*   9   21:aload_2         
    //*  10   22:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //*  11   25:aload_1         
    //*  12   26:invokevirtual   #253 <Method boolean Vector.equals(Object)>
    //*  13   29:ifeq            37
                return roNode.getNumberOfroleNode();
    //   14   32:aload_2         
    //   15   33:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //   16   36:ireturn         
        }

    //   17   37:aload_3         
    //   18   38:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   19   43:ifne            11
        return -1;
    //   20   46:iconst_m1       
    //   21   47:ireturn         
    }

    private void deleteRolePermissionEdges(int iindexOfroleNodeSet, Vector permissionSet)
    {
        for(Iterator iterator = permissionSet.iterator(); iterator.hasNext();)
    //*   0    0:aload_2         
    //*   1    1:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   2    4:astore          4
    //*   3    6:goto            108
        {
            int rolePerEdge = ((Integer)iterator.next()).intValue();
    //    4    9:aload           4
    //    5   11:invokeinterface #116 <Method Object Iterator.next()>
    //    6   16:checkcast       #139 <Class Integer>
    //    7   19:invokevirtual   #142 <Method int Integer.intValue()>
    //    8   22:istore_3        
            for(int index = 0; index < rolePermissionEdgeSet.size();)
    //*   9   23:iconst_0        
    //*  10   24:istore          5
    //*  11   26:goto            96
                if(((rolePermissionEdge)rolePermissionEdgeSet.get(index)).getFrom() == ((roleNode)roleNodeSet.get(iindexOfroleNodeSet)).getNumberOfroleNode() && ((rolePermissionEdge)rolePermissionEdgeSet.get(index)).getTo() == rolePerEdge)
    //*  12   29:aload_0         
    //*  13   30:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //*  14   33:iload           5
    //*  15   35:invokevirtual   #137 <Method Object Vector.get(int)>
    //*  16   38:checkcast       #311 <Class GraphOptimisation$rolePermissionEdge>
    //*  17   41:invokevirtual   #312 <Method int GraphOptimisation$rolePermissionEdge.getFrom()>
    //*  18   44:aload_0         
    //*  19   45:getfield        #60  <Field Vector roleNodeSet>
    //*  20   48:iload_1         
    //*  21   49:invokevirtual   #137 <Method Object Vector.get(int)>
    //*  22   52:checkcast       #118 <Class GraphOptimisation$roleNode>
    //*  23   55:invokevirtual   #122 <Method int GraphOptimisation$roleNode.getNumberOfroleNode()>
    //*  24   58:icmpne          93
    //*  25   61:aload_0         
    //*  26   62:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //*  27   65:iload           5
    //*  28   67:invokevirtual   #137 <Method Object Vector.get(int)>
    //*  29   70:checkcast       #311 <Class GraphOptimisation$rolePermissionEdge>
    //*  30   73:invokevirtual   #382 <Method int GraphOptimisation$rolePermissionEdge.getTo()>
    //*  31   76:iload_3         
    //*  32   77:icmpne          93
                    rolePermissionEdgeSet.remove(index);
    //   33   80:aload_0         
    //   34   81:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //   35   84:iload           5
    //   36   86:invokevirtual   #315 <Method Object Vector.remove(int)>
    //   37   89:pop             
                else
    //*  38   90:goto            96
                    index++;
    //   39   93:iinc            5  1

    //   40   96:iload           5
    //   41   98:aload_0         
    //   42   99:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //   43  102:invokevirtual   #153 <Method int Vector.size()>
    //   44  105:icmplt          29
        }

    //   45  108:aload           4
    //   46  110:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   47  115:ifne            9
    //   48  118:return          
    }

    private void createRoleRoleEdge(int first, int second)
    {
        roleRoleEdge rrEdge = new roleRoleEdge();
    //    0    0:new             #300 <Class GraphOptimisation$roleRoleEdge>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #318 <Method void GraphOptimisation$roleRoleEdge(GraphOptimisation)>
    //    4    8:astore_3        
        rrEdge.setFrom(first);
    //    5    9:aload_3         
    //    6   10:iload_1         
    //    7   11:invokevirtual   #321 <Method void GraphOptimisation$roleRoleEdge.setFrom(int)>
        rrEdge.setTo(second);
    //    8   14:aload_3         
    //    9   15:iload_2         
    //   10   16:invokevirtual   #324 <Method void GraphOptimisation$roleRoleEdge.setTo(int)>
        roleRoleEdgeSet.add(rrEdge);
    //   11   19:aload_0         
    //   12   20:getfield        #70  <Field Vector roleRoleEdgeSet>
    //   13   23:aload_3         
    //   14   24:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   15   27:pop             
    //   16   28:return          
    }

    private Vector createRolepermissionEdges(int roleNodeAscending2, Vector maxIntersection)
    {
        Vector rolePerEdges = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_3        
        rolePermissionEdge rpEdge;
        for(Iterator iterator = maxIntersection.iterator(); iterator.hasNext(); rolePerEdges.add(rpEdge))
    //*   4    8:aload_2         
    //*   5    9:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            88
        {
            int permission = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #116 <Method Object Iterator.next()>
    //   10   24:checkcast       #139 <Class Integer>
    //   11   27:invokevirtual   #142 <Method int Integer.intValue()>
    //   12   30:istore          4
            rpEdge = new rolePermissionEdge();
    //   13   32:new             #311 <Class GraphOptimisation$rolePermissionEdge>
    //   14   35:dup             
    //   15   36:aload_0         
    //   16   37:invokespecial   #388 <Method void GraphOptimisation$rolePermissionEdge(GraphOptimisation)>
    //   17   40:astore          6
            rpEdge.setNumberOfedge(rolePermissionEdgeSetAscending++);
    //   18   42:aload           6
    //   19   44:aload_0         
    //   20   45:dup             
    //   21   46:getfield        #58  <Field int rolePermissionEdgeSetAscending>
    //   22   49:dup_x1          
    //   23   50:iconst_1        
    //   24   51:iadd            
    //   25   52:putfield        #58  <Field int rolePermissionEdgeSetAscending>
    //   26   55:invokevirtual   #391 <Method void GraphOptimisation$rolePermissionEdge.setNumberOfedge(int)>
            rpEdge.setFrom(roleNodeAscending2);
    //   27   58:aload           6
    //   28   60:iload_1         
    //   29   61:invokevirtual   #392 <Method void GraphOptimisation$rolePermissionEdge.setFrom(int)>
            rpEdge.setTo(permission);
    //   30   64:aload           6
    //   31   66:iload           4
    //   32   68:invokevirtual   #393 <Method void GraphOptimisation$rolePermissionEdge.setTo(int)>
            rolePermissionEdgeSet.add(rpEdge);
    //   33   71:aload_0         
    //   34   72:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //   35   75:aload           6
    //   36   77:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   37   80:pop             
        }

    //   38   81:aload_3         
    //   39   82:aload           6
    //   40   84:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   41   87:pop             
    //   42   88:aload           5
    //   43   90:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   44   95:ifne            17
        return rolePerEdges;
    //   45   98:aload_3         
    //   46   99:areturn         
    }

    private void assignmentFlag()
    {
        int biggerSize = tempisRoleDealedWith.size() < isRoleDealedWith.size() ? isRoleDealedWith.size() : tempisRoleDealedWith.size();
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field Vector tempisRoleDealedWith>
    //    2    4:invokevirtual   #153 <Method int Vector.size()>
    //    3    7:aload_0         
    //    4    8:getfield        #62  <Field Vector isRoleDealedWith>
    //    5   11:invokevirtual   #153 <Method int Vector.size()>
    //    6   14:icmplt          27
    //    7   17:aload_0         
    //    8   18:getfield        #64  <Field Vector tempisRoleDealedWith>
    //    9   21:invokevirtual   #153 <Method int Vector.size()>
    //   10   24:goto            34
    //   11   27:aload_0         
    //   12   28:getfield        #62  <Field Vector isRoleDealedWith>
    //   13   31:invokevirtual   #153 <Method int Vector.size()>
    //   14   34:istore_1        
        if(biggerSize != isRoleDealedWith.size())
    //*  15   35:iload_1         
    //*  16   36:aload_0         
    //*  17   37:getfield        #62  <Field Vector isRoleDealedWith>
    //*  18   40:invokevirtual   #153 <Method int Vector.size()>
    //*  19   43:icmpeq          83
        {
            for(int index = isRoleDealedWith.size(); index < biggerSize; index++)
    //*  20   46:aload_0         
    //*  21   47:getfield        #62  <Field Vector isRoleDealedWith>
    //*  22   50:invokevirtual   #153 <Method int Vector.size()>
    //*  23   53:istore_2        
    //*  24   54:goto            78
            {
                Boolean tempbool = new Boolean(false);
    //   25   57:new             #236 <Class Boolean>
    //   26   60:dup             
    //   27   61:iconst_0        
    //   28   62:invokespecial   #239 <Method void Boolean(boolean)>
    //   29   65:astore_3        
                isRoleDealedWith.add(tempbool);
    //   30   66:aload_0         
    //   31   67:getfield        #62  <Field Vector isRoleDealedWith>
    //   32   70:aload_3         
    //   33   71:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   34   74:pop             
            }

    //   35   75:iinc            2  1
    //   36   78:iload_2         
    //   37   79:iload_1         
    //   38   80:icmplt          57
        }
        for(int index = 0; index < biggerSize; index++)
    //*  39   83:iconst_0        
    //*  40   84:istore_2        
    //*  41   85:goto            111
            isRoleDealedWith.set(index, (Boolean)tempisRoleDealedWith.get(index));
    //   42   88:aload_0         
    //   43   89:getfield        #62  <Field Vector isRoleDealedWith>
    //   44   92:iload_2         
    //   45   93:aload_0         
    //   46   94:getfield        #64  <Field Vector tempisRoleDealedWith>
    //   47   97:iload_2         
    //   48   98:invokevirtual   #137 <Method Object Vector.get(int)>
    //   49  101:checkcast       #236 <Class Boolean>
    //   50  104:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //   51  107:pop             

    //   52  108:iinc            2  1
    //   53  111:iload_2         
    //   54  112:iload_1         
    //   55  113:icmplt          88
    //   56  116:return          
    }

    private Vector isIntersection(Vector permissionSet, Vector permissionSet2)
    {
        Vector maxIntersection = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_3        
        for(Iterator iterator = permissionSet.iterator(); iterator.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            54
        {
            int firstPermission = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #116 <Method Object Iterator.next()>
    //   10   24:checkcast       #139 <Class Integer>
    //   11   27:invokevirtual   #142 <Method int Integer.intValue()>
    //   12   30:istore          4
            if(permissionSet2.contains(Integer.valueOf(firstPermission)))
    //*  13   32:aload_2         
    //*  14   33:iload           4
    //*  15   35:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //*  16   38:invokevirtual   #404 <Method boolean Vector.contains(Object)>
    //*  17   41:ifeq            54
                maxIntersection.add(Integer.valueOf(firstPermission));
    //   18   44:aload_3         
    //   19   45:iload           4
    //   20   47:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   21   50:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   22   53:pop             
        }

    //   23   54:aload           5
    //   24   56:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   25   61:ifne            17
        return maxIntersection;
    //   26   64:aload_3         
    //   27   65:areturn         
    }

    private void settempisRoleDealedWithfalse()
    {
        int sizeOftempisRoleDealedWith = tempisRoleDealedWith.size();
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field Vector tempisRoleDealedWith>
    //    2    4:invokevirtual   #153 <Method int Vector.size()>
    //    3    7:istore_1        
        for(int index = 0; index < sizeOftempisRoleDealedWith; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_2        
    //*   6   10:goto            29
            tempisRoleDealedWith.set(index, Boolean.valueOf(false));
    //    7   13:aload_0         
    //    8   14:getfield        #64  <Field Vector tempisRoleDealedWith>
    //    9   17:iload_2         
    //   10   18:iconst_0        
    //   11   19:invokestatic    #260 <Method Boolean Boolean.valueOf(boolean)>
    //   12   22:invokevirtual   #150 <Method Object Vector.set(int, Object)>
    //   13   25:pop             

    //   14   26:iinc            2  1
    //   15   29:iload_2         
    //   16   30:iload_1         
    //   17   31:icmplt          13
    //   18   34:return          
    }

    private void constructionInitialRole(Assignment Ass)
    {
        Matrix mat = Ass.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #337 <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        Attribute usersAttr = Ass.getDimensionX().getDimensionAttribute();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #411 <Method Dimension Assignment.getDimensionX()>
    //    5    9:invokevirtual   #417 <Method Attribute Dimension.getDimensionAttribute()>
    //    6   12:astore_3        
        Attribute permissionsAttr = Ass.getDimensionY().getDimensionAttribute();
    //    7   13:aload_1         
    //    8   14:invokevirtual   #420 <Method Dimension Assignment.getDimensionY()>
    //    9   17:invokevirtual   #417 <Method Attribute Dimension.getDimensionAttribute()>
    //   10   20:astore          4
        initialPermissionsAndUsers(Ass);
    //   11   22:aload_0         
    //   12   23:aload_1         
    //   13   24:invokespecial   #423 <Method void initialPermissionsAndUsers(Assignment)>
        createAllPermissionNode();
    //   14   27:aload_0         
    //   15   28:invokespecial   #426 <Method void createAllPermissionNode()>
        createInitalroleNode(mat);
    //   16   31:aload_0         
    //   17   32:aload_2         
    //   18   33:invokespecial   #430 <Method void createInitalroleNode(Matrix)>
    //   19   36:return          
    }

    private void createInitalroleNode(Matrix mat)
    {
        int RowDimension = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #439 <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int ColumnDimension = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #442 <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        WSC += wu * RowDimension;
    //    6   10:aload_0         
    //    7   11:dup             
    //    8   12:getfield        #51  <Field int WSC>
    //    9   15:aload_0         
    //   10   16:getfield        #444 <Field int wu>
    //   11   19:iload_2         
    //   12   20:imul            
    //   13   21:iadd            
    //   14   22:putfield        #51  <Field int WSC>
        log.append((new StringBuilder("UA are:")).append(RowDimension).append("\n").toString());
    //   15   25:aload_0         
    //   16   26:getfield        #47  <Field StringBuffer log>
    //   17   29:new             #177 <Class StringBuilder>
    //   18   32:dup             
    //   19   33:ldc2            #446 <String "UA are:">
    //   20   36:invokespecial   #182 <Method void StringBuilder(String)>
    //   21   39:iload_2         
    //   22   40:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   23   43:ldc1            #206 <String "\n">
    //   24   45:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   25   48:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   26   51:invokevirtual   #175 <Method StringBuffer StringBuffer.append(String)>
    //   27   54:pop             
        for(int i = 0; i < RowDimension; i++)
    //*  28   55:iconst_0        
    //*  29   56:istore          4
    //*  30   58:goto            227
        {
            Vector permissionSet = new Vector();
    //   31   61:new             #53  <Class Vector>
    //   32   64:dup             
    //   33   65:invokespecial   #54  <Method void Vector()>
    //   34   68:astore          5
            for(int j = 0; j < ColumnDimension; j++)
    //*  35   70:iconst_0        
    //*  36   71:istore          6
    //*  37   73:goto            102
                if(1 == mat.get(i, j))
    //*  38   76:iconst_1        
    //*  39   77:aload_1         
    //*  40   78:iload           4
    //*  41   80:iload           6
    //*  42   82:invokevirtual   #449 <Method byte Matrix.get(int, int)>
    //*  43   85:icmpne          99
                    permissionSet.add(Integer.valueOf(j));
    //   44   88:aload           5
    //   45   90:iload           6
    //   46   92:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   47   95:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   48   98:pop             

    //   49   99:iinc            6  1
    //   50  102:iload           6
    //   51  104:iload_3         
    //   52  105:icmplt          76
            roleNode rnode = new roleNode();
    //   53  108:new             #118 <Class GraphOptimisation$roleNode>
    //   54  111:dup             
    //   55  112:aload_0         
    //   56  113:invokespecial   #342 <Method void GraphOptimisation$roleNode(GraphOptimisation)>
    //   57  116:astore          6
            rnode.setRoleName((new StringBuilder("r")).append(roleNodeAscending).toString());
    //   58  118:aload           6
    //   59  120:new             #177 <Class StringBuilder>
    //   60  123:dup             
    //   61  124:ldc2            #347 <String "r">
    //   62  127:invokespecial   #182 <Method void StringBuilder(String)>
    //   63  130:aload_0         
    //   64  131:getfield        #49  <Field int roleNodeAscending>
    //   65  134:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   66  137:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   67  140:invokevirtual   #350 <Method void GraphOptimisation$roleNode.setRoleName(String)>
            rnode.setNumberOfroleNode(roleNodeAscending);
    //   68  143:aload           6
    //   69  145:aload_0         
    //   70  146:getfield        #49  <Field int roleNodeAscending>
    //   71  149:invokevirtual   #126 <Method void GraphOptimisation$roleNode.setNumberOfroleNode(int)>
            rnode.setPermissionSet(permissionSet);
    //   72  152:aload           6
    //   73  154:aload           5
    //   74  156:invokevirtual   #353 <Method void GraphOptimisation$roleNode.setPermissionSet(Vector)>
            Vector useSet = getUserSet(permissionSet, mat);
    //   75  159:aload_0         
    //   76  160:aload           5
    //   77  162:aload_1         
    //   78  163:invokespecial   #364 <Method Vector getUserSet(Vector, Matrix)>
    //   79  166:astore          7
            rnode.setUseList(useSet);
    //   80  168:aload           6
    //   81  170:aload           7
    //   82  172:invokevirtual   #367 <Method void GraphOptimisation$roleNode.setUseList(Vector)>
            Vector initEdges = createInitEdges(permissionSet, roleNodeAscending);
    //   83  175:aload_0         
    //   84  176:aload           5
    //   85  178:aload_0         
    //   86  179:getfield        #49  <Field int roleNodeAscending>
    //   87  182:invokespecial   #453 <Method Vector createInitEdges(Vector, int)>
    //   88  185:astore          8
            roleNodeAscending++;
    //   89  187:aload_0         
    //   90  188:dup             
    //   91  189:getfield        #49  <Field int roleNodeAscending>
    //   92  192:iconst_1        
    //   93  193:iadd            
    //   94  194:putfield        #49  <Field int roleNodeAscending>
            rolePermissionEdgeSet.addAll(initEdges);
    //   95  197:aload_0         
    //   96  198:getfield        #68  <Field Vector rolePermissionEdgeSet>
    //   97  201:aload           8
    //   98  203:invokevirtual   #456 <Method boolean Vector.addAll(java.util.Collection)>
    //   99  206:pop             
            rnode.setEdgesSet(initEdges);
    //  100  207:aload           6
    //  101  209:aload           8
    //  102  211:invokevirtual   #360 <Method void GraphOptimisation$roleNode.setEdgesSet(Vector)>
            roleNodeSet.add(rnode);
    //  103  214:aload_0         
    //  104  215:getfield        #60  <Field Vector roleNodeSet>
    //  105  218:aload           6
    //  106  220:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //  107  223:pop             
        }

    //  108  224:iinc            4  1
    //  109  227:iload           4
    //  110  229:iload_2         
    //  111  230:icmplt          61
    //  112  233:return          
    }

    private Vector getUserSet(Vector permissionSet, Matrix mat)
    {
        Vector useSet = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_3        
        for(int index = 0; index < mat.getRowDimension(); index++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            86
        {
            Vector permList = new Vector();
    //    7   14:new             #53  <Class Vector>
    //    8   17:dup             
    //    9   18:invokespecial   #54  <Method void Vector()>
    //   10   21:astore          5
            for(int jndex = 0; jndex < mat.getColumnDimension(); jndex++)
    //*  11   23:iconst_0        
    //*  12   24:istore          6
    //*  13   26:goto            55
                if(1 == mat.get(index, jndex))
    //*  14   29:iconst_1        
    //*  15   30:aload_2         
    //*  16   31:iload           4
    //*  17   33:iload           6
    //*  18   35:invokevirtual   #449 <Method byte Matrix.get(int, int)>
    //*  19   38:icmpne          52
                    permList.add(Integer.valueOf(jndex));
    //   20   41:aload           5
    //   21   43:iload           6
    //   22   45:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   23   48:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   24   51:pop             

    //   25   52:iinc            6  1
    //   26   55:iload           6
    //   27   57:aload_2         
    //   28   58:invokevirtual   #442 <Method int Matrix.getColumnDimension()>
    //   29   61:icmplt          29
            if(permList.containsAll(permissionSet))
    //*  30   64:aload           5
    //*  31   66:aload_1         
    //*  32   67:invokevirtual   #267 <Method boolean Vector.containsAll(java.util.Collection)>
    //*  33   70:ifeq            83
                useSet.add(Integer.valueOf(index));
    //   34   73:aload_3         
    //   35   74:iload           4
    //   36   76:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //   37   79:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   38   82:pop             
        }

    //   39   83:iinc            4  1
    //   40   86:iload           4
    //   41   88:aload_2         
    //   42   89:invokevirtual   #439 <Method int Matrix.getRowDimension()>
    //   43   92:icmplt          14
        return useSet;
    //   44   95:aload_3         
    //   45   96:areturn         
    }

    private Vector createInitEdges(Vector permissionSet, int roleNodeAscending)
    {
        Vector initrolePermissionEdges = new Vector();
    //    0    0:new             #53  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #54  <Method void Vector()>
    //    3    7:astore_3        
        for(Iterator iterator = permissionSet.iterator(); iterator.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            137
        {
            int permissionId = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #116 <Method Object Iterator.next()>
    //   10   24:checkcast       #139 <Class Integer>
    //   11   27:invokevirtual   #142 <Method int Integer.intValue()>
    //   12   30:istore          4
            for(Iterator iterator1 = permissionNodeSet.iterator(); iterator1.hasNext();)
    //*  13   32:aload_0         
    //*  14   33:getfield        #66  <Field Vector permissionNodeSet>
    //*  15   36:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*  16   39:astore          7
    //*  17   41:goto            127
            {
                permissionNode perNode = (permissionNode)iterator1.next();
    //   18   44:aload           7
    //   19   46:invokeinterface #116 <Method Object Iterator.next()>
    //   20   51:checkcast       #468 <Class GraphOptimisation$permissionNode>
    //   21   54:astore          6
                if(((String)permissions.get(permissionId)).equals(perNode.getPermissionName()))
    //*  22   56:aload_0         
    //*  23   57:getfield        #72  <Field Vector permissions>
    //*  24   60:iload           4
    //*  25   62:invokevirtual   #137 <Method Object Vector.get(int)>
    //*  26   65:checkcast       #199 <Class String>
    //*  27   68:aload           6
    //*  28   70:invokevirtual   #471 <Method String GraphOptimisation$permissionNode.getPermissionName()>
    //*  29   73:invokevirtual   #472 <Method boolean String.equals(Object)>
    //*  30   76:ifeq            127
                {
                    rolePermissionEdge rpEdge = new rolePermissionEdge();
    //   31   79:new             #311 <Class GraphOptimisation$rolePermissionEdge>
    //   32   82:dup             
    //   33   83:aload_0         
    //   34   84:invokespecial   #388 <Method void GraphOptimisation$rolePermissionEdge(GraphOptimisation)>
    //   35   87:astore          8
                    rpEdge.setFrom(roleNodeAscending);
    //   36   89:aload           8
    //   37   91:iload_2         
    //   38   92:invokevirtual   #392 <Method void GraphOptimisation$rolePermissionEdge.setFrom(int)>
                    rpEdge.setTo(rolePermissionEdgeSetAscending);
    //   39   95:aload           8
    //   40   97:aload_0         
    //   41   98:getfield        #58  <Field int rolePermissionEdgeSetAscending>
    //   42  101:invokevirtual   #393 <Method void GraphOptimisation$rolePermissionEdge.setTo(int)>
                    rpEdge.setNumberOfedge(rolePermissionEdgeSetAscending++);
    //   43  104:aload           8
    //   44  106:aload_0         
    //   45  107:dup             
    //   46  108:getfield        #58  <Field int rolePermissionEdgeSetAscending>
    //   47  111:dup_x1          
    //   48  112:iconst_1        
    //   49  113:iadd            
    //   50  114:putfield        #58  <Field int rolePermissionEdgeSetAscending>
    //   51  117:invokevirtual   #391 <Method void GraphOptimisation$rolePermissionEdge.setNumberOfedge(int)>
                    initrolePermissionEdges.add(rpEdge);
    //   52  120:aload_3         
    //   53  121:aload           8
    //   54  123:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   55  126:pop             
                }
            }

    //   56  127:aload           7
    //   57  129:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   58  134:ifne            44
        }

    //   59  137:aload           5
    //   60  139:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   61  144:ifne            17
        return initrolePermissionEdges;
    //   62  147:aload_3         
    //   63  148:areturn         
    }

    private void createAllPermissionNode()
    {
        int count = 0;
    //    0    0:iconst_0        
    //    1    1:istore_1        
        for(Iterator iterator = permissions.iterator(); iterator.hasNext();)
    //*   2    2:aload_0         
    //*   3    3:getfield        #72  <Field Vector permissions>
    //*   4    6:invokevirtual   #110 <Method Iterator Vector.iterator()>
    //*   5    9:astore_3        
    //*   6   10:goto            58
        {
            String permission = (String)iterator.next();
    //    7   13:aload_3         
    //    8   14:invokeinterface #116 <Method Object Iterator.next()>
    //    9   19:checkcast       #199 <Class String>
    //   10   22:astore_2        
            permissionNode perNode = new permissionNode();
    //   11   23:new             #468 <Class GraphOptimisation$permissionNode>
    //   12   26:dup             
    //   13   27:aload_0         
    //   14   28:invokespecial   #477 <Method void GraphOptimisation$permissionNode(GraphOptimisation)>
    //   15   31:astore          4
            perNode.setNumberOfpermissionNode(count);
    //   16   33:aload           4
    //   17   35:iload_1         
    //   18   36:invokevirtual   #480 <Method void GraphOptimisation$permissionNode.setNumberOfpermissionNode(int)>
            perNode.setPermissionName(permission);
    //   19   39:aload           4
    //   20   41:aload_2         
    //   21   42:invokevirtual   #483 <Method void GraphOptimisation$permissionNode.setPermissionName(String)>
            permissionNodeSet.add(perNode);
    //   22   45:aload_0         
    //   23   46:getfield        #66  <Field Vector permissionNodeSet>
    //   24   49:aload           4
    //   25   51:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   26   54:pop             
            count++;
    //   27   55:iinc            1  1
        }

    //   28   58:aload_3         
    //   29   59:invokeinterface #161 <Method boolean Iterator.hasNext()>
    //   30   64:ifne            13
    //   31   67:return          
    }

    private void initialPermissionsAndUsers(Assignment Ass)
    {
        splitAttruteString(Ass.getDimensionY().getDimensionAttribute(), permissions);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #420 <Method Dimension Assignment.getDimensionY()>
    //    3    5:invokevirtual   #417 <Method Attribute Dimension.getDimensionAttribute()>
    //    4    8:aload_0         
    //    5    9:getfield        #72  <Field Vector permissions>
    //    6   12:invokespecial   #488 <Method void splitAttruteString(Attribute, Vector)>
        splitAttruteString(Ass.getDimensionX().getDimensionAttribute(), users);
    //    7   15:aload_0         
    //    8   16:aload_1         
    //    9   17:invokevirtual   #411 <Method Dimension Assignment.getDimensionX()>
    //   10   20:invokevirtual   #417 <Method Attribute Dimension.getDimensionAttribute()>
    //   11   23:aload_0         
    //   12   24:getfield        #74  <Field Vector users>
    //   13   27:invokespecial   #488 <Method void splitAttruteString(Attribute, Vector)>
    //   14   30:return          
    }

    private void splitAttruteString(Attribute Attr, Vector set)
    {
        String perAttr = Attr.toString();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #492 <Method String Attribute.toString()>
    //    2    4:astore_3        
        int fristChar = perAttr.indexOf('{');
    //    3    5:aload_3         
    //    4    6:bipush          123
    //    5    8:invokevirtual   #496 <Method int String.indexOf(int)>
    //    6   11:istore          4
        int lastChar = perAttr.lastIndexOf('}');
    //    7   13:aload_3         
    //    8   14:bipush          125
    //    9   16:invokevirtual   #499 <Method int String.lastIndexOf(int)>
    //   10   19:istore          5
        perAttr = perAttr.substring(fristChar + 1, lastChar);
    //   11   21:aload_3         
    //   12   22:iload           4
    //   13   24:iconst_1        
    //   14   25:iadd            
    //   15   26:iload           5
    //   16   28:invokevirtual   #503 <Method String String.substring(int, int)>
    //   17   31:astore_3        
        for(int index = perAttr.indexOf(','); index != -1; index = perAttr.indexOf(','))
    //*  18   32:aload_3         
    //*  19   33:bipush          44
    //*  20   35:invokevirtual   #496 <Method int String.indexOf(int)>
    //*  21   38:istore          6
    //*  22   40:goto            72
        {
            set.add(perAttr.substring(0, index));
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:iconst_0        
    //   26   46:iload           6
    //   27   48:invokevirtual   #503 <Method String String.substring(int, int)>
    //   28   51:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   29   54:pop             
            perAttr = perAttr.substring(index + 1);
    //   30   55:aload_3         
    //   31   56:iload           6
    //   32   58:iconst_1        
    //   33   59:iadd            
    //   34   60:invokevirtual   #506 <Method String String.substring(int)>
    //   35   63:astore_3        
        }

    //   36   64:aload_3         
    //   37   65:bipush          44
    //   38   67:invokevirtual   #496 <Method int String.indexOf(int)>
    //   39   70:istore          6
    //   40   72:iload           6
    //   41   74:iconst_m1       
    //   42   75:icmpne          43
        set.add(perAttr.substring(0));
    //   43   78:aload_2         
    //   44   79:aload_3         
    //   45   80:iconst_0        
    //   46   81:invokevirtual   #506 <Method String String.substring(int)>
    //   47   84:invokevirtual   #243 <Method boolean Vector.add(Object)>
    //   48   87:pop             
    //   49   88:return          
    }

    public void resetOptions()
    {
        wr = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #230 <Field int wr>
        wu = 1;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #444 <Field int wu>
        wp = 1;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #226 <Field int wp>
        wh = 1;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #232 <Field int wh>
    //   12   20:return          
    }

    public String globalInfo()
    {
        return "GO first generates roles by one role for all permissions a user has then for\nOptimizating the number of edges it deals with equality,subset and intersection\nsituation respectively until no further improvement is possible. \n";
    //    0    0:ldc2            #513 <String "GO first generates roles by one role for all permissions a user has then for\nOptimizating the number of edges it deals with equality,subset and intersection\nsituation respectively until no further improvement is possible. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #517 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #522 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #528 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #532 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #535 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #532 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #538 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #532 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #541 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #532 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #544 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #532 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of number of role for WSC. (default = ")).append(wr).append(")").toString();
    //    0    0:new             #177 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #550 <String "\tRequired weight of number of role for WSC. (default = ">
    //    3    7:invokespecial   #182 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #230 <Field int wr>
    //    6   14:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //    7   17:ldc2            #552 <String ")">
    //    8   20:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        String string2 = (new StringBuilder("\tRequired weight of number of user for WSC. (default = ")).append(wu).append(")").toString();
    //   11   27:new             #177 <Class StringBuilder>
    //   12   30:dup             
    //   13   31:ldc2            #554 <String "\tRequired weight of number of user for WSC. (default = ">
    //   14   34:invokespecial   #182 <Method void StringBuilder(String)>
    //   15   37:aload_0         
    //   16   38:getfield        #444 <Field int wu>
    //   17   41:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   18   44:ldc2            #552 <String ")">
    //   19   47:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   20   50:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   21   53:astore_2        
        String string3 = (new StringBuilder("\tRequired weight of number of permission for WSC. (default = ")).append(wp).append(")").toString();
    //   22   54:new             #177 <Class StringBuilder>
    //   23   57:dup             
    //   24   58:ldc2            #556 <String "\tRequired weight of number of permission for WSC. (default = ">
    //   25   61:invokespecial   #182 <Method void StringBuilder(String)>
    //   26   64:aload_0         
    //   27   65:getfield        #226 <Field int wp>
    //   28   68:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   29   71:ldc2            #552 <String ")">
    //   30   74:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   31   77:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   32   80:astore_3        
        String string4 = (new StringBuilder("\tRequired weight of number of roles' hierarchy for WSC. (default = ")).append(wh).append(")").toString();
    //   33   81:new             #177 <Class StringBuilder>
    //   34   84:dup             
    //   35   85:ldc2            #558 <String "\tRequired weight of number of roles' hierarchy for WSC. (default = ">
    //   36   88:invokespecial   #182 <Method void StringBuilder(String)>
    //   37   91:aload_0         
    //   38   92:getfield        #232 <Field int wh>
    //   39   95:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   40   98:ldc2            #552 <String ")">
    //   41  101:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   42  104:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   43  107:astore          4
        FastVector newVector = new FastVector(4);
    //   44  109:new             #560 <Class FastVector>
    //   45  112:dup             
    //   46  113:iconst_4        
    //   47  114:invokespecial   #562 <Method void FastVector(int)>
    //   48  117:astore          5
        newVector.addElement(new Option(string1, "R", 1, "-R <required weight of number of role>"));
    //   49  119:aload           5
    //   50  121:new             #564 <Class Option>
    //   51  124:dup             
    //   52  125:aload_1         
    //   53  126:ldc2            #566 <String "R">
    //   54  129:iconst_1        
    //   55  130:ldc2            #568 <String "-R <required weight of number of role>">
    //   56  133:invokespecial   #571 <Method void Option(String, String, int, String)>
    //   57  136:invokevirtual   #575 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string2, "U", 1, "-U <required weight of number of user>"));
    //   58  139:aload           5
    //   59  141:new             #564 <Class Option>
    //   60  144:dup             
    //   61  145:aload_2         
    //   62  146:ldc2            #577 <String "U">
    //   63  149:iconst_1        
    //   64  150:ldc2            #579 <String "-U <required weight of number of user>">
    //   65  153:invokespecial   #571 <Method void Option(String, String, int, String)>
    //   66  156:invokevirtual   #575 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string3, "P", 1, "-P <required weight of number of permission>"));
    //   67  159:aload           5
    //   68  161:new             #564 <Class Option>
    //   69  164:dup             
    //   70  165:aload_3         
    //   71  166:ldc2            #581 <String "P">
    //   72  169:iconst_1        
    //   73  170:ldc2            #583 <String "-P <required weight of number of permission>">
    //   74  173:invokespecial   #571 <Method void Option(String, String, int, String)>
    //   75  176:invokevirtual   #575 <Method void FastVector.addElement(Object)>
        newVector.addElement(new Option(string4, "H", 1, "-H <required weight of number of roles' hierarchy>"));
    //   76  179:aload           5
    //   77  181:new             #564 <Class Option>
    //   78  184:dup             
    //   79  185:aload           4
    //   80  187:ldc2            #585 <String "H">
    //   81  190:iconst_1        
    //   82  191:ldc2            #587 <String "-H <required weight of number of roles' hierarchy>">
    //   83  194:invokespecial   #571 <Method void Option(String, String, int, String)>
    //   84  197:invokevirtual   #575 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   85  200:aload           5
    //   86  202:invokevirtual   #590 <Method Enumeration FastVector.elements()>
    //   87  205:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #77  <Method void resetOptions()>
        String s_wr = Utils.getOption('R', options);
    //    2    4:bipush          82
    //    3    6:aload_1         
    //    4    7:invokestatic    #604 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #607 <Method int String.length()>
    //*   8   15:ifeq            26
            wr = Integer.parseInt(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #611 <Method int Integer.parseInt(String)>
    //   12   23:putfield        #230 <Field int wr>
        String s_wu = Utils.getOption('U', options);
    //   13   26:bipush          85
    //   14   28:aload_1         
    //   15   29:invokestatic    #604 <Method String Utils.getOption(char, String[])>
    //   16   32:astore_3        
        if(s_wu.length() != 0)
    //*  17   33:aload_3         
    //*  18   34:invokevirtual   #607 <Method int String.length()>
    //*  19   37:ifeq            48
            wu = Integer.parseInt(s_wu);
    //   20   40:aload_0         
    //   21   41:aload_3         
    //   22   42:invokestatic    #611 <Method int Integer.parseInt(String)>
    //   23   45:putfield        #444 <Field int wu>
        String s_wp = Utils.getOption('P', options);
    //   24   48:bipush          80
    //   25   50:aload_1         
    //   26   51:invokestatic    #604 <Method String Utils.getOption(char, String[])>
    //   27   54:astore          4
        if(s_wp.length() != 0)
    //*  28   56:aload           4
    //*  29   58:invokevirtual   #607 <Method int String.length()>
    //*  30   61:ifeq            73
            wp = Integer.parseInt(s_wp);
    //   31   64:aload_0         
    //   32   65:aload           4
    //   33   67:invokestatic    #611 <Method int Integer.parseInt(String)>
    //   34   70:putfield        #226 <Field int wp>
        String s_wh = Utils.getOption('H', options);
    //   35   73:bipush          72
    //   36   75:aload_1         
    //   37   76:invokestatic    #604 <Method String Utils.getOption(char, String[])>
    //   38   79:astore          5
        if(s_wu.length() != 0)
    //*  39   81:aload_3         
    //*  40   82:invokevirtual   #607 <Method int String.length()>
    //*  41   85:ifeq            97
            wh = Integer.parseInt(s_wh);
    //   42   88:aload_0         
    //   43   89:aload           5
    //   44   91:invokestatic    #611 <Method int Integer.parseInt(String)>
    //   45   94:putfield        #232 <Field int wh>
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
    //    8   13:ldc2            #621 <String "-R">
    //    9   16:aastore         
        options[current++] = (new StringBuilder()).append(wr).toString();
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #177 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #622 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #230 <Field int wr>
    //   18   33:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   19   36:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   20   39:aastore         
        options[current++] = "-U";
    //   21   40:aload_1         
    //   22   41:iload_2         
    //   23   42:iinc            2  1
    //   24   45:ldc2            #624 <String "-U">
    //   25   48:aastore         
        options[current++] = (new StringBuilder()).append(wu).toString();
    //   26   49:aload_1         
    //   27   50:iload_2         
    //   28   51:iinc            2  1
    //   29   54:new             #177 <Class StringBuilder>
    //   30   57:dup             
    //   31   58:invokespecial   #622 <Method void StringBuilder()>
    //   32   61:aload_0         
    //   33   62:getfield        #444 <Field int wu>
    //   34   65:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   35   68:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   36   71:aastore         
        options[current++] = "-P";
    //   37   72:aload_1         
    //   38   73:iload_2         
    //   39   74:iinc            2  1
    //   40   77:ldc2            #626 <String "-P">
    //   41   80:aastore         
        options[current++] = (new StringBuilder()).append(wp).toString();
    //   42   81:aload_1         
    //   43   82:iload_2         
    //   44   83:iinc            2  1
    //   45   86:new             #177 <Class StringBuilder>
    //   46   89:dup             
    //   47   90:invokespecial   #622 <Method void StringBuilder()>
    //   48   93:aload_0         
    //   49   94:getfield        #226 <Field int wp>
    //   50   97:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   51  100:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   52  103:aastore         
        options[current++] = "-H";
    //   53  104:aload_1         
    //   54  105:iload_2         
    //   55  106:iinc            2  1
    //   56  109:ldc2            #628 <String "-H">
    //   57  112:aastore         
        for(options[current++] = (new StringBuilder()).append(wh).toString(); current < options.length; options[current++] = "");
    //   58  113:aload_1         
    //   59  114:iload_2         
    //   60  115:iinc            2  1
    //   61  118:new             #177 <Class StringBuilder>
    //   62  121:dup             
    //   63  122:invokespecial   #622 <Method void StringBuilder()>
    //   64  125:aload_0         
    //   65  126:getfield        #232 <Field int wh>
    //   66  129:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   67  132:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   68  135:aastore         
    //   69  136:goto            148
    //   70  139:aload_1         
    //   71  140:iload_2         
    //   72  141:iinc            2  1
    //   73  144:ldc2            #630 <String "">
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
    //    1    1:getfield        #47  <Field StringBuffer log>
    //    2    4:invokevirtual   #632 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #333 <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #635 <Method void Assignment()>
    //    4    8:putfield        #637 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #637 <Field Assignment m_assroles>
    //    7   15:ldc2            #639 <String "role-permission">
    //    8   18:invokevirtual   #642 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(roleNodeAscending, permissions.size(), (byte)0);
    //    9   21:new             #436 <Class Matrix>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:getfield        #49  <Field int roleNodeAscending>
    //   13   29:aload_0         
    //   14   30:getfield        #72  <Field Vector permissions>
    //   15   33:invokevirtual   #153 <Method int Vector.size()>
    //   16   36:iconst_0        
    //   17   37:invokespecial   #645 <Method void Matrix(int, int, byte)>
    //   18   40:astore_1        
        for(int i = 0; i < roleNodeAscending; i++)
    //*  19   41:iconst_0        
    //*  20   42:istore_2        
    //*  21   43:goto            105
        {
            Vector upi = ((roleNode)roleNodeSet.get(i)).getPermissionSet();
    //   22   46:aload_0         
    //   23   47:getfield        #60  <Field Vector roleNodeSet>
    //   24   50:iload_2         
    //   25   51:invokevirtual   #137 <Method Object Vector.get(int)>
    //   26   54:checkcast       #118 <Class GraphOptimisation$roleNode>
    //   27   57:invokevirtual   #211 <Method Vector GraphOptimisation$roleNode.getPermissionSet()>
    //   28   60:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            90
                if(upi.contains(Integer.valueOf(j)))
    //*  32   67:aload_3         
    //*  33   68:iload           4
    //*  34   70:invokestatic    #146 <Method Integer Integer.valueOf(int)>
    //*  35   73:invokevirtual   #404 <Method boolean Vector.contains(Object)>
    //*  36   76:ifeq            87
                    mat.set(i, j, (byte)1);
    //   37   79:aload_1         
    //   38   80:iload_2         
    //   39   81:iload           4
    //   40   83:iconst_1        
    //   41   84:invokevirtual   #647 <Method void Matrix.set(int, int, byte)>

    //   42   87:iinc            4  1
    //   43   90:iload           4
    //   44   92:aload_0         
    //   45   93:getfield        #72  <Field Vector permissions>
    //   46   96:invokevirtual   #153 <Method int Vector.size()>
    //   47   99:icmplt          67
        }

    //   48  102:iinc            2  1
    //   49  105:iload_2         
    //   50  106:aload_0         
    //   51  107:getfield        #49  <Field int roleNodeAscending>
    //   52  110:icmplt          46
        m_assroles.setAssignmentMatrix(mat);
    //   53  113:aload_0         
    //   54  114:getfield        #637 <Field Assignment m_assroles>
    //   55  117:aload_1         
    //   56  118:invokevirtual   #650 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   57  121:new             #560 <Class FastVector>
    //   58  124:dup             
    //   59  125:invokespecial   #651 <Method void FastVector()>
    //   60  128:astore_2        
        for(int i = 0; i < roleNodeAscending; i++)
    //*  61  129:iconst_0        
    //*  62  130:istore_3        
    //*  63  131:goto            158
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   64  134:aload_2         
    //   65  135:new             #177 <Class StringBuilder>
    //   66  138:dup             
    //   67  139:ldc2            #566 <String "R">
    //   68  142:invokespecial   #182 <Method void StringBuilder(String)>
    //   69  145:iload_3         
    //   70  146:invokevirtual   #185 <Method StringBuilder StringBuilder.append(int)>
    //   71  149:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   72  152:invokevirtual   #575 <Method void FastVector.addElement(Object)>

    //   73  155:iinc            3  1
    //   74  158:iload_3         
    //   75  159:aload_0         
    //   76  160:getfield        #49  <Field int roleNodeAscending>
    //   77  163:icmplt          134
        Attribute dxa = new Attribute("role", fv);
    //   78  166:new             #491 <Class Attribute>
    //   79  169:dup             
    //   80  170:ldc2            #653 <String "role">
    //   81  173:aload_2         
    //   82  174:invokespecial   #656 <Method void Attribute(String, FastVector)>
    //   83  177:astore_3        
        Dimension dx = new Dimension();
    //   84  178:new             #413 <Class Dimension>
    //   85  181:dup             
    //   86  182:invokespecial   #657 <Method void Dimension()>
    //   87  185:astore          4
        dx.setDimensionAttribute(dxa);
    //   88  187:aload           4
    //   89  189:aload_3         
    //   90  190:invokevirtual   #661 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   91  193:aload_0         
    //   92  194:getfield        #637 <Field Assignment m_assroles>
    //   93  197:aload           4
    //   94  199:invokevirtual   #665 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   95  202:aload_0         
    //   96  203:getfield        #88  <Field Assignment m_assignment>
    //   97  206:invokevirtual   #420 <Method Dimension Assignment.getDimensionY()>
    //   98  209:invokevirtual   #417 <Method Attribute Dimension.getDimensionAttribute()>
    //   99  212:astore          5
        Dimension dy = new Dimension();
    //  100  214:new             #413 <Class Dimension>
    //  101  217:dup             
    //  102  218:invokespecial   #657 <Method void Dimension()>
    //  103  221:astore          6
        dy.setDimensionAttribute(dya);
    //  104  223:aload           6
    //  105  225:aload           5
    //  106  227:invokevirtual   #661 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  107  230:aload_0         
    //  108  231:getfield        #637 <Field Assignment m_assroles>
    //  109  234:aload           6
    //  110  236:invokevirtual   #668 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  111  239:aload_0         
    //  112  240:getfield        #637 <Field Assignment m_assroles>
    //  113  243:areturn         
    }

    public int getWh()
    {
        return wh;
    //    0    0:aload_0         
    //    1    1:getfield        #232 <Field int wh>
    //    2    4:ireturn         
    }

    public void setWh(int wh)
    {
        this.wh = wh;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #232 <Field int wh>
    //    3    5:return          
    }

    public int getWp()
    {
        return wp;
    //    0    0:aload_0         
    //    1    1:getfield        #226 <Field int wp>
    //    2    4:ireturn         
    }

    public void setWp(int wp)
    {
        this.wp = wp;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #226 <Field int wp>
    //    3    5:return          
    }

    public int getWr()
    {
        return wr;
    //    0    0:aload_0         
    //    1    1:getfield        #230 <Field int wr>
    //    2    4:ireturn         
    }

    public void setWr(int wr)
    {
        this.wr = wr;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #230 <Field int wr>
    //    3    5:return          
    }

    public int getWu()
    {
        return wu;
    //    0    0:aload_0         
    //    1    1:getfield        #444 <Field int wu>
    //    2    4:ireturn         
    }

    public void setWu(int wu)
    {
        this.wu = wu;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #444 <Field int wu>
    //    3    5:return          
    }

    public String wrTipText()
    {
        return "The required weight of number of role for WSC.";
    //    0    0:ldc2            #686 <String "The required weight of number of role for WSC.">
    //    1    3:areturn         
    }

    public String wuTipText()
    {
        return "The required weight of number of user for WSC.";
    //    0    0:ldc2            #689 <String "The required weight of number of user for WSC.">
    //    1    3:areturn         
    }

    public String wpTipText()
    {
        return "The required weight of number of permission for WSC.";
    //    0    0:ldc2            #692 <String "The required weight of number of permission for WSC.">
    //    1    3:areturn         
    }

    public String whTipText()
    {
        return "The required weight of number of roles' hierarchy for WSC.";
    //    0    0:ldc2            #695 <String "The required weight of number of roles' hierarchy for WSC.">
    //    1    3:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\orca_user_permission.ass").toString());
    //    2    2:new             #698 <Class File>
    //    3    5:dup             
    //    4    6:new             #177 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #700 <String "user.dir">
    //    7   13:invokestatic    #706 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #202 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #182 <Method void StringBuilder(String)>
    //   10   22:ldc2            #708 <String "\\datasets\\orca_user_permission.ass">
    //   11   25:invokevirtual   #190 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #194 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #709 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #711 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #713 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #716 <Method void FileReader(File)>
    //   21   47:invokespecial   #719 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #722 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #726 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #729 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #734 <Method void PrintStream.println(String)>
            GraphOptimisation go = new GraphOptimisation();
    //   30   66:new             #2   <Class GraphOptimisation>
    //   31   69:dup             
    //   32   70:invokespecial   #735 <Method void GraphOptimisation()>
    //   33   73:astore          4
            go.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #737 <Method void buildRoleminers(Assignment)>
            System.out.println(go.toString());
    //   37   81:getstatic       #726 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #738 <Method String toString()>
    //   40   89:invokevirtual   #734 <Method void PrintStream.println(String)>
            System.out.println(go.generateRoles());
    //   41   92:getstatic       #726 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #740 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #742 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #745 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    private int wr;
    private int wu;
    private int wp;
    private int wh;
    private StringBuffer log;
    private int roleNodeAscending;
    private int WSC;
    private Vector deletionNodeNumber;
    private int rolePermissionEdgeSetAscending;
    private Vector roleNodeSet;
    private Vector isRoleDealedWith;
    private Vector tempisRoleDealedWith;
    private Vector permissionNodeSet;
    private Vector rolePermissionEdgeSet;
    private Vector roleRoleEdgeSet;
    private Vector permissions;
    private Vector users;
    private Assignment m_assignment;
    private Assignment m_assroles;
}

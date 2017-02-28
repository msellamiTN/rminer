// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   HPRoleMinimization.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public class HPRoleMinimization extends AbstractRoleminer
    implements OptionHandler
{
    public class Role
    {

        public Vector getPerList()
        {
            return perList;
        //    0    0:aload_0         
        //    1    1:getfield        #30  <Field Vector perList>
        //    2    4:areturn         
        }

        public void setPerList(Vector perList)
        {
            this.perList = perList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #30  <Field Vector perList>
        //    3    5:return          
        }

        public Vector getUseList()
        {
            return useList;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field Vector useList>
        //    2    4:areturn         
        }

        public void setUseList(Vector useList)
        {
            this.useList = useList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #37  <Field Vector useList>
        //    3    5:return          
        }

        public String getRoleName()
        {
            return roleName;
        //    0    0:aload_0         
        //    1    1:getfield        #42  <Field String roleName>
        //    2    4:areturn         
        }

        public void setRoleName(String roleName)
        {
            this.roleName = roleName;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #42  <Field String roleName>
        //    3    5:return          
        }

        private String roleName;
        private Vector useList;
        private Vector perList;
        final HPRoleMinimization this$0;


/*
        static Vector access$0(Role role)
        {
            return role.useList;
        //    0    0:aload_0         
        //    1    1:getfield        #37  <Field Vector useList>
        //    2    4:areturn         
        }

*/

        public Role()
        {
            this$0 = HPRoleMinimization.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field HPRoleMinimization this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }

    public class FourTuples
    {

        public int getIndex()
        {
            return index;
        //    0    0:aload_0         
        //    1    1:getfield        #27  <Field int index>
        //    2    4:ireturn         
        }

        public void setIndex(int index)
        {
            this.index = index;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #27  <Field int index>
        //    3    5:return          
        }

        public int getJndex()
        {
            return jndex;
        //    0    0:aload_0         
        //    1    1:getfield        #32  <Field int jndex>
        //    2    4:ireturn         
        }

        public void setJndex(int jndex)
        {
            this.jndex = jndex;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #32  <Field int jndex>
        //    3    5:return          
        }

        public int getOrder()
        {
            return order;
        //    0    0:aload_0         
        //    1    1:getfield        #36  <Field int order>
        //    2    4:ireturn         
        }

        public void setOrder(int order)
        {
            this.order = order;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #36  <Field int order>
        //    3    5:return          
        }

        public int getReduce()
        {
            return reduce;
        //    0    0:aload_0         
        //    1    1:getfield        #40  <Field int reduce>
        //    2    4:ireturn         
        }

        public void setReduce(int reduce)
        {
            this.reduce = reduce;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #40  <Field int reduce>
        //    3    5:return          
        }

        private int reduce;
        private int index;
        private int jndex;
        private int order;
        final HPRoleMinimization this$0;

        public FourTuples()
        {
            this$0 = HPRoleMinimization.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #16  <Field HPRoleMinimization this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #19  <Method void Object()>
        //    5    9:return          
        }
    }


    public HPRoleMinimization()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #31  <Method void AbstractRoleminer()>
        log = new StringBuffer();
    //    2    4:aload_0         
    //    3    5:new             #33  <Class StringBuffer>
    //    4    8:dup             
    //    5    9:invokespecial   #34  <Method void StringBuffer()>
    //    6   12:putfield        #36  <Field StringBuffer log>
        numberOfRoles = 0;
    //    7   15:aload_0         
    //    8   16:iconst_0        
    //    9   17:putfield        #38  <Field int numberOfRoles>
        ableUseList = new Vector();
    //   10   20:aload_0         
    //   11   21:new             #40  <Class Vector>
    //   12   24:dup             
    //   13   25:invokespecial   #41  <Method void Vector()>
    //   14   28:putfield        #43  <Field Vector ableUseList>
        notCoveredPerList = new Vector();
    //   15   31:aload_0         
    //   16   32:new             #40  <Class Vector>
    //   17   35:dup             
    //   18   36:invokespecial   #41  <Method void Vector()>
    //   19   39:putfield        #45  <Field Vector notCoveredPerList>
        permissions = new Vector();
    //   20   42:aload_0         
    //   21   43:new             #40  <Class Vector>
    //   22   46:dup             
    //   23   47:invokespecial   #41  <Method void Vector()>
    //   24   50:putfield        #47  <Field Vector permissions>
        users = new Vector();
    //   25   53:aload_0         
    //   26   54:new             #40  <Class Vector>
    //   27   57:dup             
    //   28   58:invokespecial   #41  <Method void Vector()>
    //   29   61:putfield        #49  <Field Vector users>
        WSC = 0;
    //   30   64:aload_0         
    //   31   65:iconst_0        
    //   32   66:putfield        #51  <Field int WSC>
        roles = new Vector();
    //   33   69:aload_0         
    //   34   70:new             #40  <Class Vector>
    //   35   73:dup             
    //   36   74:invokespecial   #41  <Method void Vector()>
    //   37   77:putfield        #53  <Field Vector roles>
        isShould = true;
    //   38   80:aload_0         
    //   39   81:iconst_1        
    //   40   82:putfield        #55  <Field boolean isShould>
    //   41   85:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #66  <Field Assignment m_assignment>
        Matrix mat = data.getAssignmentMatrix();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #72  <Method Matrix Assignment.getAssignmentMatrix()>
    //    5    9:astore_2        
        initList(mat.getRowDimension(), ableUseList);
    //    6   10:aload_0         
    //    7   11:aload_2         
    //    8   12:invokevirtual   #78  <Method int Matrix.getRowDimension()>
    //    9   15:aload_0         
    //   10   16:getfield        #43  <Field Vector ableUseList>
    //   11   19:invokespecial   #82  <Method void initList(int, Vector)>
        initList(mat.getColumnDimension(), notCoveredPerList);
    //   12   22:aload_0         
    //   13   23:aload_2         
    //   14   24:invokevirtual   #85  <Method int Matrix.getColumnDimension()>
    //   15   27:aload_0         
    //   16   28:getfield        #45  <Field Vector notCoveredPerList>
    //   17   31:invokespecial   #82  <Method void initList(int, Vector)>
        splitAttruteString(data.getDimensionY().getDimensionAttribute(), permissions);
    //   18   34:aload_0         
    //   19   35:aload_1         
    //   20   36:invokevirtual   #89  <Method Dimension Assignment.getDimensionY()>
    //   21   39:invokevirtual   #95  <Method Attribute Dimension.getDimensionAttribute()>
    //   22   42:aload_0         
    //   23   43:getfield        #47  <Field Vector permissions>
    //   24   46:invokespecial   #99  <Method void splitAttruteString(Attribute, Vector)>
        splitAttruteString(data.getDimensionX().getDimensionAttribute(), users);
    //   25   49:aload_0         
    //   26   50:aload_1         
    //   27   51:invokevirtual   #102 <Method Dimension Assignment.getDimensionX()>
    //   28   54:invokevirtual   #95  <Method Attribute Dimension.getDimensionAttribute()>
    //   29   57:aload_0         
    //   30   58:getfield        #49  <Field Vector users>
    //   31   61:invokespecial   #99  <Method void splitAttruteString(Attribute, Vector)>
        for(int cycle = 0; cycle < mat.getRowDimension(); cycle++)
    //*  32   64:iconst_0        
    //*  33   65:istore_3        
    //*  34   66:goto            162
        {
            int nextUser = selectNextUser(mat);
    //   35   69:aload_0         
    //   36   70:aload_2         
    //   37   71:invokespecial   #106 <Method int selectNextUser(Matrix)>
    //   38   74:istore          4
            if(nextUser < mat.getRowDimension())
    //*  39   76:iload           4
    //*  40   78:aload_2         
    //*  41   79:invokevirtual   #78  <Method int Matrix.getRowDimension()>
    //*  42   82:icmpge          159
            {
                Role role = new Role();
    //   43   85:new             #108 <Class HPRoleMinimization$Role>
    //   44   88:dup             
    //   45   89:aload_0         
    //   46   90:invokespecial   #111 <Method void HPRoleMinimization$Role(HPRoleMinimization)>
    //   47   93:astore          5
                role.setRoleName((new StringBuilder("role")).append(numberOfRoles).toString());
    //   48   95:aload           5
    //   49   97:new             #113 <Class StringBuilder>
    //   50  100:dup             
    //   51  101:ldc1            #115 <String "role">
    //   52  103:invokespecial   #118 <Method void StringBuilder(String)>
    //   53  106:aload_0         
    //   54  107:getfield        #38  <Field int numberOfRoles>
    //   55  110:invokevirtual   #122 <Method StringBuilder StringBuilder.append(int)>
    //   56  113:invokevirtual   #126 <Method String StringBuilder.toString()>
    //   57  116:invokevirtual   #129 <Method void HPRoleMinimization$Role.setRoleName(String)>
                initMember(role, mat, nextUser);
    //   58  119:aload_0         
    //   59  120:aload           5
    //   60  122:aload_2         
    //   61  123:iload           4
    //   62  125:invokespecial   #133 <Method void initMember(HPRoleMinimization$Role, Matrix, int)>
                roles.add(numberOfRoles, role);
    //   63  128:aload_0         
    //   64  129:getfield        #53  <Field Vector roles>
    //   65  132:aload_0         
    //   66  133:getfield        #38  <Field int numberOfRoles>
    //   67  136:aload           5
    //   68  138:invokevirtual   #137 <Method void Vector.add(int, Object)>
                RemoveUP(nextUser, role);
    //   69  141:aload_0         
    //   70  142:iload           4
    //   71  144:aload           5
    //   72  146:invokespecial   #141 <Method void RemoveUP(int, HPRoleMinimization$Role)>
                numberOfRoles++;
    //   73  149:aload_0         
    //   74  150:dup             
    //   75  151:getfield        #38  <Field int numberOfRoles>
    //   76  154:iconst_1        
    //   77  155:iadd            
    //   78  156:putfield        #38  <Field int numberOfRoles>
            }
        }

    //   79  159:iinc            3  1
    //   80  162:iload_3         
    //   81  163:aload_2         
    //   82  164:invokevirtual   #78  <Method int Matrix.getRowDimension()>
    //   83  167:icmplt          69
        if(isShould)
    //*  84  170:aload_0         
    //*  85  171:getfield        #55  <Field boolean isShould>
    //*  86  174:ifeq            189
            printRoleSet(roles, WSC);
    //   87  177:aload_0         
    //   88  178:aload_0         
    //   89  179:getfield        #53  <Field Vector roles>
    //   90  182:aload_0         
    //   91  183:getfield        #51  <Field int WSC>
    //   92  186:invokespecial   #145 <Method void printRoleSet(Vector, int)>
    //   93  189:return          
    }

    private void printRoleSet(Vector roles2, int wsc2)
    {
        log.append("\n--------------------------------------------------------");
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field StringBuffer log>
    //    2    4:ldc1            #154 <String "\n--------------------------------------------------------">
    //    3    6:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //    4    9:pop             
        for(int indexRole = 0; indexRole < roles2.size(); indexRole++)
    //*   5   10:iconst_0        
    //*   6   11:istore_3        
    //*   7   12:goto            285
        {
            Role role = (Role)roles2.get(indexRole);
    //    8   15:aload_1         
    //    9   16:iload_3         
    //   10   17:invokevirtual   #161 <Method Object Vector.get(int)>
    //   11   20:checkcast       #108 <Class HPRoleMinimization$Role>
    //   12   23:astore          4
            log.append((new StringBuilder("\nThe users of role")).append(indexRole).append(" are: \n").toString());
    //   13   25:aload_0         
    //   14   26:getfield        #36  <Field StringBuffer log>
    //   15   29:new             #113 <Class StringBuilder>
    //   16   32:dup             
    //   17   33:ldc1            #163 <String "\nThe users of role">
    //   18   35:invokespecial   #118 <Method void StringBuilder(String)>
    //   19   38:iload_3         
    //   20   39:invokevirtual   #122 <Method StringBuilder StringBuilder.append(int)>
    //   21   42:ldc1            #165 <String " are: \n">
    //   22   44:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   23   47:invokevirtual   #126 <Method String StringBuilder.toString()>
    //   24   50:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   25   53:pop             
            for(int index = 0; index < role.useList.size(); index++)
    //*  26   54:iconst_0        
    //*  27   55:istore          5
    //*  28   57:goto            159
                if(index != role.useList.size() - 1)
    //*  29   60:iload           5
    //*  30   62:aload           4
    //*  31   64:invokestatic    #172 <Method Vector HPRoleMinimization$Role.access$0(HPRoleMinimization$Role)>
    //*  32   67:invokevirtual   #175 <Method int Vector.size()>
    //*  33   70:iconst_1        
    //*  34   71:isub            
    //*  35   72:icmpeq          117
                    log.append((new StringBuilder(String.valueOf((String)role.useList.get(index)))).append(", ").toString());
    //   36   75:aload_0         
    //   37   76:getfield        #36  <Field StringBuffer log>
    //   38   79:new             #113 <Class StringBuilder>
    //   39   82:dup             
    //   40   83:aload           4
    //   41   85:invokestatic    #172 <Method Vector HPRoleMinimization$Role.access$0(HPRoleMinimization$Role)>
    //   42   88:iload           5
    //   43   90:invokevirtual   #161 <Method Object Vector.get(int)>
    //   44   93:checkcast       #177 <Class String>
    //   45   96:invokestatic    #181 <Method String String.valueOf(Object)>
    //   46   99:invokespecial   #118 <Method void StringBuilder(String)>
    //   47  102:ldc1            #183 <String ", ">
    //   48  104:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   49  107:invokevirtual   #126 <Method String StringBuilder.toString()>
    //   50  110:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   51  113:pop             
                else
    //*  52  114:goto            156
                    log.append((new StringBuilder(String.valueOf((String)role.useList.get(index)))).append("\n").toString());
    //   53  117:aload_0         
    //   54  118:getfield        #36  <Field StringBuffer log>
    //   55  121:new             #113 <Class StringBuilder>
    //   56  124:dup             
    //   57  125:aload           4
    //   58  127:invokestatic    #172 <Method Vector HPRoleMinimization$Role.access$0(HPRoleMinimization$Role)>
    //   59  130:iload           5
    //   60  132:invokevirtual   #161 <Method Object Vector.get(int)>
    //   61  135:checkcast       #177 <Class String>
    //   62  138:invokestatic    #181 <Method String String.valueOf(Object)>
    //   63  141:invokespecial   #118 <Method void StringBuilder(String)>
    //   64  144:ldc1            #185 <String "\n">
    //   65  146:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   66  149:invokevirtual   #126 <Method String StringBuilder.toString()>
    //   67  152:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   68  155:pop             

    //   69  156:iinc            5  1
    //   70  159:iload           5
    //   71  161:aload           4
    //   72  163:invokestatic    #172 <Method Vector HPRoleMinimization$Role.access$0(HPRoleMinimization$Role)>
    //   73  166:invokevirtual   #175 <Method int Vector.size()>
    //   74  169:icmplt          60
            log.append("The permissions are: \n");
    //   75  172:aload_0         
    //   76  173:getfield        #36  <Field StringBuffer log>
    //   77  176:ldc1            #187 <String "The permissions are: \n">
    //   78  178:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //   79  181:pop             
            for(int index = 0; index < role.getPerList().size(); index++)
    //*  80  182:iconst_0        
    //*  81  183:istore          5
    //*  82  185:goto            269
                if(index != role.getPerList().size() - 1)
    //*  83  188:iload           5
    //*  84  190:aload           4
    //*  85  192:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  86  195:invokevirtual   #175 <Method int Vector.size()>
    //*  87  198:iconst_1        
    //*  88  199:isub            
    //*  89  200:icmpeq          245
                    log.append((new StringBuilder(String.valueOf((String)role.getPerList().get(index)))).append(", ").toString());
    //   90  203:aload_0         
    //   91  204:getfield        #36  <Field StringBuffer log>
    //   92  207:new             #113 <Class StringBuilder>
    //   93  210:dup             
    //   94  211:aload           4
    //   95  213:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //   96  216:iload           5
    //   97  218:invokevirtual   #161 <Method Object Vector.get(int)>
    //   98  221:checkcast       #177 <Class String>
    //   99  224:invokestatic    #181 <Method String String.valueOf(Object)>
    //  100  227:invokespecial   #118 <Method void StringBuilder(String)>
    //  101  230:ldc1            #183 <String ", ">
    //  102  232:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //  103  235:invokevirtual   #126 <Method String StringBuilder.toString()>
    //  104  238:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  105  241:pop             
                else
    //* 106  242:goto            266
                    log.append((String)role.getPerList().get(index));
    //  107  245:aload_0         
    //  108  246:getfield        #36  <Field StringBuffer log>
    //  109  249:aload           4
    //  110  251:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //  111  254:iload           5
    //  112  256:invokevirtual   #161 <Method Object Vector.get(int)>
    //  113  259:checkcast       #177 <Class String>
    //  114  262:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  115  265:pop             

    //  116  266:iinc            5  1
    //  117  269:iload           5
    //  118  271:aload           4
    //  119  273:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //  120  276:invokevirtual   #175 <Method int Vector.size()>
    //  121  279:icmplt          188
        }

    //  122  282:iinc            3  1
    //  123  285:iload_3         
    //  124  286:aload_1         
    //  125  287:invokevirtual   #175 <Method int Vector.size()>
    //  126  290:icmplt          15
        log.append("\n--------------------------------------------------------\n");
    //  127  293:aload_0         
    //  128  294:getfield        #36  <Field StringBuffer log>
    //  129  297:ldc1            #193 <String "\n--------------------------------------------------------\n">
    //  130  299:invokevirtual   #157 <Method StringBuffer StringBuffer.append(String)>
    //  131  302:pop             
    //  132  303:return          
    }

    private void optimizationHPr(Vector roles2)
    {
        for(int index = 0; index < roles2.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            197
        {
            Vector role_pers = (Vector)((Role)roles2.get(index)).getPerList().clone();
    //    3    5:aload_1         
    //    4    6:iload_2         
    //    5    7:invokevirtual   #161 <Method Object Vector.get(int)>
    //    6   10:checkcast       #108 <Class HPRoleMinimization$Role>
    //    7   13:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //    8   16:invokevirtual   #205 <Method Object Vector.clone()>
    //    9   19:checkcast       #40  <Class Vector>
    //   10   22:astore_3        
            boolean covered = true;
    //   11   23:iconst_1        
    //   12   24:istore          4
            Vector allCovered = new Vector();
    //   13   26:new             #40  <Class Vector>
    //   14   29:dup             
    //   15   30:invokespecial   #41  <Method void Vector()>
    //   16   33:astore          5
            for(int i = 0; i < role_pers.size(); i++)
    //*  17   35:iconst_0        
    //*  18   36:istore          6
    //*  19   38:goto            112
            {
                boolean isContain = false;
    //   20   41:iconst_0        
    //   21   42:istore          7
                for(int jndex = 0; jndex < roles2.size(); jndex++)
    //*  22   44:iconst_0        
    //*  23   45:istore          8
    //*  24   47:goto            89
                {
                    if(jndex == index || !((Role)roles2.get(jndex)).getPerList().contains(role_pers.get(i)))
                        continue;
    //   25   50:iload           8
    //   26   52:iload_2         
    //   27   53:icmpeq          86
    //   28   56:aload_1         
    //   29   57:iload           8
    //   30   59:invokevirtual   #161 <Method Object Vector.get(int)>
    //   31   62:checkcast       #108 <Class HPRoleMinimization$Role>
    //   32   65:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //   33   68:aload_3         
    //   34   69:iload           6
    //   35   71:invokevirtual   #161 <Method Object Vector.get(int)>
    //   36   74:invokevirtual   #209 <Method boolean Vector.contains(Object)>
    //   37   77:ifeq            86
                    isContain = true;
    //   38   80:iconst_1        
    //   39   81:istore          7
                    break;
    //   40   83:goto            98
                }

    //   41   86:iinc            8  1
    //   42   89:iload           8
    //   43   91:aload_1         
    //   44   92:invokevirtual   #175 <Method int Vector.size()>
    //   45   95:icmplt          50
                allCovered.add(Boolean.valueOf(isContain));
    //   46   98:aload           5
    //   47  100:iload           7
    //   48  102:invokestatic    #214 <Method Boolean Boolean.valueOf(boolean)>
    //   49  105:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //   50  108:pop             
            }

    //   51  109:iinc            6  1
    //   52  112:iload           6
    //   53  114:aload_3         
    //   54  115:invokevirtual   #175 <Method int Vector.size()>
    //   55  118:icmplt          41
            for(Iterator iterator = allCovered.iterator(); iterator.hasNext();)
    //*  56  121:aload           5
    //*  57  123:invokevirtual   #220 <Method Iterator Vector.iterator()>
    //*  58  126:astore          7
    //*  59  128:goto            157
            {
                boolean indexCovered = ((Boolean)iterator.next()).booleanValue();
    //   60  131:aload           7
    //   61  133:invokeinterface #225 <Method Object Iterator.next()>
    //   62  138:checkcast       #211 <Class Boolean>
    //   63  141:invokevirtual   #229 <Method boolean Boolean.booleanValue()>
    //   64  144:istore          6
                if(!indexCovered)
    //*  65  146:iload           6
    //*  66  148:ifne            157
                {
                    covered = false;
    //   67  151:iconst_0        
    //   68  152:istore          4
                    break;
    //   69  154:goto            167
                }
            }

    //   70  157:aload           7
    //   71  159:invokeinterface #232 <Method boolean Iterator.hasNext()>
    //   72  164:ifne            131
            if(covered)
    //*  73  167:iload           4
    //*  74  169:ifeq            194
            {
                numberOfRoles--;
    //   75  172:aload_0         
    //   76  173:dup             
    //   77  174:getfield        #38  <Field int numberOfRoles>
    //   78  177:iconst_1        
    //   79  178:isub            
    //   80  179:putfield        #38  <Field int numberOfRoles>
                roles.remove(index);
    //   81  182:aload_0         
    //   82  183:getfield        #53  <Field Vector roles>
    //   83  186:iload_2         
    //   84  187:invokevirtual   #235 <Method Object Vector.remove(int)>
    //   85  190:pop             
                index--;
    //   86  191:iinc            2  -1
            }
        }

    //   87  194:iinc            2  1
    //   88  197:iload_2         
    //   89  198:aload_1         
    //   90  199:invokevirtual   #175 <Method int Vector.size()>
    //   91  202:icmplt          5
    //   92  205:return          
    }

    private void RemoveUP(int nextUser, Role role)
    {
        for(int index = 0; index < ableUseList.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            38
        {
            if(nextUser != ((Integer)ableUseList.get(index)).intValue())
                continue;
    //    3    5:iload_1         
    //    4    6:aload_0         
    //    5    7:getfield        #43  <Field Vector ableUseList>
    //    6   10:iload_3         
    //    7   11:invokevirtual   #161 <Method Object Vector.get(int)>
    //    8   14:checkcast       #245 <Class Integer>
    //    9   17:invokevirtual   #248 <Method int Integer.intValue()>
    //   10   20:icmpne          35
            ableUseList.remove(index);
    //   11   23:aload_0         
    //   12   24:getfield        #43  <Field Vector ableUseList>
    //   13   27:iload_3         
    //   14   28:invokevirtual   #235 <Method Object Vector.remove(int)>
    //   15   31:pop             
            break;
    //   16   32:goto            49
        }

    //   17   35:iinc            3  1
    //   18   38:iload_3         
    //   19   39:aload_0         
    //   20   40:getfield        #43  <Field Vector ableUseList>
    //   21   43:invokevirtual   #175 <Method int Vector.size()>
    //   22   46:icmplt          5
        for(int jndex = 0; jndex < notCoveredPerList.size(); jndex++)
    //*  23   49:iconst_0        
    //*  24   50:istore_3        
    //*  25   51:goto            100
            if(role.getPerList().contains(permissions.get(((Integer)notCoveredPerList.get(jndex)).intValue())))
    //*  26   54:aload_2         
    //*  27   55:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //*  28   58:aload_0         
    //*  29   59:getfield        #47  <Field Vector permissions>
    //*  30   62:aload_0         
    //*  31   63:getfield        #45  <Field Vector notCoveredPerList>
    //*  32   66:iload_3         
    //*  33   67:invokevirtual   #161 <Method Object Vector.get(int)>
    //*  34   70:checkcast       #245 <Class Integer>
    //*  35   73:invokevirtual   #248 <Method int Integer.intValue()>
    //*  36   76:invokevirtual   #161 <Method Object Vector.get(int)>
    //*  37   79:invokevirtual   #209 <Method boolean Vector.contains(Object)>
    //*  38   82:ifeq            97
            {
                notCoveredPerList.remove(jndex);
    //   39   85:aload_0         
    //   40   86:getfield        #45  <Field Vector notCoveredPerList>
    //   41   89:iload_3         
    //   42   90:invokevirtual   #235 <Method Object Vector.remove(int)>
    //   43   93:pop             
                jndex--;
    //   44   94:iinc            3  -1
            }

    //   45   97:iinc            3  1
    //   46  100:iload_3         
    //   47  101:aload_0         
    //   48  102:getfield        #45  <Field Vector notCoveredPerList>
    //   49  105:invokevirtual   #175 <Method int Vector.size()>
    //   50  108:icmplt          54
    //   51  111:return          
    }

    private void initMember(Role role, Matrix mat, int nextUser)
    {
        Vector role2Per = new Vector();
    //    0    0:new             #40  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #41  <Method void Vector()>
    //    3    7:astore          4
        Vector role2User = new Vector();
    //    4    9:new             #40  <Class Vector>
    //    5   12:dup             
    //    6   13:invokespecial   #41  <Method void Vector()>
    //    7   16:astore          5
        for(int index = 0; index < mat.getColumnDimension(); index++)
    //*   8   18:iconst_0        
    //*   9   19:istore          6
    //*  10   21:goto            56
            if(mat.get(nextUser, index) == 1)
    //*  11   24:aload_2         
    //*  12   25:iload_3         
    //*  13   26:iload           6
    //*  14   28:invokevirtual   #251 <Method byte Matrix.get(int, int)>
    //*  15   31:iconst_1        
    //*  16   32:icmpne          53
                role2Per.add((String)permissions.get(index));
    //   17   35:aload           4
    //   18   37:aload_0         
    //   19   38:getfield        #47  <Field Vector permissions>
    //   20   41:iload           6
    //   21   43:invokevirtual   #161 <Method Object Vector.get(int)>
    //   22   46:checkcast       #177 <Class String>
    //   23   49:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //   24   52:pop             

    //   25   53:iinc            6  1
    //   26   56:iload           6
    //   27   58:aload_2         
    //   28   59:invokevirtual   #85  <Method int Matrix.getColumnDimension()>
    //   29   62:icmplt          24
        for(int i = 0; i < mat.getRowDimension(); i++)
    //*  30   65:iconst_0        
    //*  31   66:istore          6
    //*  32   68:goto            159
        {
            Vector _perlist = new Vector();
    //   33   71:new             #40  <Class Vector>
    //   34   74:dup             
    //   35   75:invokespecial   #41  <Method void Vector()>
    //   36   78:astore          7
            for(int j = 0; j < mat.getColumnDimension(); j++)
    //*  37   80:iconst_0        
    //*  38   81:istore          8
    //*  39   83:goto            119
                if(mat.get(i, j) == 1)
    //*  40   86:aload_2         
    //*  41   87:iload           6
    //*  42   89:iload           8
    //*  43   91:invokevirtual   #251 <Method byte Matrix.get(int, int)>
    //*  44   94:iconst_1        
    //*  45   95:icmpne          116
                    _perlist.add((String)permissions.get(j));
    //   46   98:aload           7
    //   47  100:aload_0         
    //   48  101:getfield        #47  <Field Vector permissions>
    //   49  104:iload           8
    //   50  106:invokevirtual   #161 <Method Object Vector.get(int)>
    //   51  109:checkcast       #177 <Class String>
    //   52  112:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //   53  115:pop             

    //   54  116:iinc            8  1
    //   55  119:iload           8
    //   56  121:aload_2         
    //   57  122:invokevirtual   #85  <Method int Matrix.getColumnDimension()>
    //   58  125:icmplt          86
            if(_perlist.containsAll(role2Per))
    //*  59  128:aload           7
    //*  60  130:aload           4
    //*  61  132:invokevirtual   #255 <Method boolean Vector.containsAll(java.util.Collection)>
    //*  62  135:ifeq            156
                role2User.add((String)users.get(i));
    //   63  138:aload           5
    //   64  140:aload_0         
    //   65  141:getfield        #49  <Field Vector users>
    //   66  144:iload           6
    //   67  146:invokevirtual   #161 <Method Object Vector.get(int)>
    //   68  149:checkcast       #177 <Class String>
    //   69  152:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //   70  155:pop             
        }

    //   71  156:iinc            6  1
    //   72  159:iload           6
    //   73  161:aload_2         
    //   74  162:invokevirtual   #78  <Method int Matrix.getRowDimension()>
    //   75  165:icmplt          71
        role.setPerList((Vector)role2Per.clone());
    //   76  168:aload_1         
    //   77  169:aload           4
    //   78  171:invokevirtual   #205 <Method Object Vector.clone()>
    //   79  174:checkcast       #40  <Class Vector>
    //   80  177:invokevirtual   #258 <Method void HPRoleMinimization$Role.setPerList(Vector)>
        role.setUseList((Vector)role2User.clone());
    //   81  180:aload_1         
    //   82  181:aload           5
    //   83  183:invokevirtual   #205 <Method Object Vector.clone()>
    //   84  186:checkcast       #40  <Class Vector>
    //   85  189:invokevirtual   #261 <Method void HPRoleMinimization$Role.setUseList(Vector)>
    //   86  192:return          
    }

    private int selectNextUser(Matrix mat)
    {
        int rows = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #78  <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int cols = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #85  <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        Map user2Number = new HashMap();
    //    6   10:new             #267 <Class HashMap>
    //    7   13:dup             
    //    8   14:invokespecial   #268 <Method void HashMap()>
    //    9   17:astore          4
        for(int index = 0; index < rows; index++)
    //*  10   19:iconst_0        
    //*  11   20:istore          5
    //*  12   22:goto            109
            if(ableUseList.contains(Integer.valueOf(index)))
    //*  13   25:aload_0         
    //*  14   26:getfield        #43  <Field Vector ableUseList>
    //*  15   29:iload           5
    //*  16   31:invokestatic    #271 <Method Integer Integer.valueOf(int)>
    //*  17   34:invokevirtual   #209 <Method boolean Vector.contains(Object)>
    //*  18   37:ifeq            106
            {
                int number = 0;
    //   19   40:iconst_0        
    //   20   41:istore          6
                for(int jndex = 0; jndex < cols; jndex++)
    //*  21   43:iconst_0        
    //*  22   44:istore          7
    //*  23   46:goto            82
                    if(mat.get(index, jndex) == 1 && notCoveredPerList.contains(Integer.valueOf(jndex)))
    //*  24   49:aload_1         
    //*  25   50:iload           5
    //*  26   52:iload           7
    //*  27   54:invokevirtual   #251 <Method byte Matrix.get(int, int)>
    //*  28   57:iconst_1        
    //*  29   58:icmpne          79
    //*  30   61:aload_0         
    //*  31   62:getfield        #45  <Field Vector notCoveredPerList>
    //*  32   65:iload           7
    //*  33   67:invokestatic    #271 <Method Integer Integer.valueOf(int)>
    //*  34   70:invokevirtual   #209 <Method boolean Vector.contains(Object)>
    //*  35   73:ifeq            79
                        number++;
    //   36   76:iinc            6  1

    //   37   79:iinc            7  1
    //   38   82:iload           7
    //   39   84:iload_3         
    //   40   85:icmplt          49
                user2Number.put(Integer.valueOf(index), Integer.valueOf(number));
    //   41   88:aload           4
    //   42   90:iload           5
    //   43   92:invokestatic    #271 <Method Integer Integer.valueOf(int)>
    //   44   95:iload           6
    //   45   97:invokestatic    #271 <Method Integer Integer.valueOf(int)>
    //   46  100:invokeinterface #277 <Method Object Map.put(Object, Object)>
    //   47  105:pop             
            }

    //   48  106:iinc            5  1
    //   49  109:iload           5
    //   50  111:iload_2         
    //   51  112:icmplt          25
        return getMinIndex(user2Number);
    //   52  115:aload_0         
    //   53  116:aload           4
    //   54  118:invokespecial   #281 <Method int getMinIndex(Map)>
    //   55  121:ireturn         
    }

    private int getMinIndex(Map user2Number)
    {
        int min = 0x7fffffff;
    //    0    0:ldc2            #289 <Int 0x7fffffff>
    //    1    3:istore_2        
        int index = 0x7fffffff;
    //    2    4:ldc2            #289 <Int 0x7fffffff>
    //    3    7:istore_3        
        for(Iterator iter = user2Number.entrySet().iterator(); iter.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokeinterface #293 <Method Set Map.entrySet()>
    //*   6   14:invokeinterface #296 <Method Iterator Set.iterator()>
    //*   7   19:astore          4
    //*   8   21:goto            92
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)(java.util.Map.Entry)iter.next();
    //    9   24:aload           4
    //   10   26:invokeinterface #225 <Method Object Iterator.next()>
    //   11   31:checkcast       #298 <Class java.util.Map$Entry>
    //   12   34:checkcast       #298 <Class java.util.Map$Entry>
    //   13   37:astore          5
            int key = ((Integer)(Integer)entry.getKey()).intValue();
    //   14   39:aload           5
    //   15   41:invokeinterface #301 <Method Object java.util.Map$Entry.getKey()>
    //   16   46:checkcast       #245 <Class Integer>
    //   17   49:checkcast       #245 <Class Integer>
    //   18   52:invokevirtual   #248 <Method int Integer.intValue()>
    //   19   55:istore          6
            int val = ((Integer)(Integer)entry.getValue()).intValue();
    //   20   57:aload           5
    //   21   59:invokeinterface #304 <Method Object java.util.Map$Entry.getValue()>
    //   22   64:checkcast       #245 <Class Integer>
    //   23   67:checkcast       #245 <Class Integer>
    //   24   70:invokevirtual   #248 <Method int Integer.intValue()>
    //   25   73:istore          7
            if(val != 0 && val < min)
    //*  26   75:iload           7
    //*  27   77:ifeq            92
    //*  28   80:iload           7
    //*  29   82:iload_2         
    //*  30   83:icmpge          92
            {
                min = val;
    //   31   86:iload           7
    //   32   88:istore_2        
                index = key;
    //   33   89:iload           6
    //   34   91:istore_3        
            }
        }

    //   35   92:aload           4
    //   36   94:invokeinterface #232 <Method boolean Iterator.hasNext()>
    //   37   99:ifne            24
        return index;
    //   38  102:iload_3         
    //   39  103:ireturn         
    }

    private void splitAttruteString(Attribute latitudeAttrute, Vector splitString)
    {
        String perAttr = latitudeAttrute.toString();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #315 <Method String Attribute.toString()>
    //    2    4:astore_3        
        int fristChar = perAttr.indexOf('{');
    //    3    5:aload_3         
    //    4    6:bipush          123
    //    5    8:invokevirtual   #319 <Method int String.indexOf(int)>
    //    6   11:istore          4
        int lastChar = perAttr.lastIndexOf('}');
    //    7   13:aload_3         
    //    8   14:bipush          125
    //    9   16:invokevirtual   #322 <Method int String.lastIndexOf(int)>
    //   10   19:istore          5
        perAttr = perAttr.substring(fristChar + 1, lastChar);
    //   11   21:aload_3         
    //   12   22:iload           4
    //   13   24:iconst_1        
    //   14   25:iadd            
    //   15   26:iload           5
    //   16   28:invokevirtual   #326 <Method String String.substring(int, int)>
    //   17   31:astore_3        
        for(int index = perAttr.indexOf(','); index != -1; index = perAttr.indexOf(','))
    //*  18   32:aload_3         
    //*  19   33:bipush          44
    //*  20   35:invokevirtual   #319 <Method int String.indexOf(int)>
    //*  21   38:istore          6
    //*  22   40:goto            72
        {
            splitString.add(perAttr.substring(0, index));
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:iconst_0        
    //   26   46:iload           6
    //   27   48:invokevirtual   #326 <Method String String.substring(int, int)>
    //   28   51:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //   29   54:pop             
            perAttr = perAttr.substring(index + 1);
    //   30   55:aload_3         
    //   31   56:iload           6
    //   32   58:iconst_1        
    //   33   59:iadd            
    //   34   60:invokevirtual   #329 <Method String String.substring(int)>
    //   35   63:astore_3        
        }

    //   36   64:aload_3         
    //   37   65:bipush          44
    //   38   67:invokevirtual   #319 <Method int String.indexOf(int)>
    //   39   70:istore          6
    //   40   72:iload           6
    //   41   74:iconst_m1       
    //   42   75:icmpne          43
        splitString.add(perAttr.substring(0));
    //   43   78:aload_2         
    //   44   79:aload_3         
    //   45   80:iconst_0        
    //   46   81:invokevirtual   #329 <Method String String.substring(int)>
    //   47   84:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //   48   87:pop             
    //   49   88:return          
    }

    private void initList(int dimension, Vector list)
    {
        for(int index = 0; index < dimension; index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_3        
    //*   2    2:goto            17
            list.add(Integer.valueOf(index));
    //    3    5:aload_2         
    //    4    6:iload_3         
    //    5    7:invokestatic    #271 <Method Integer Integer.valueOf(int)>
    //    6   10:invokevirtual   #216 <Method boolean Vector.add(Object)>
    //    7   13:pop             

    //    8   14:iinc            3  1
    //    9   17:iload_3         
    //   10   18:iload_1         
    //   11   19:icmplt          5
    //   12   22:return          
    }

    public String globalInfo()
    {
        return "HPr continuously selects the user owned the fewest uncovered permissions \nthen make the permissions of the user a role. The process does until \n the permissions of current role set covers entirely all  \ndefault permissions. \n";
    //    0    0:ldc2            #342 <String "HPr continuously selects the user owned the fewest uncovered permissions \nthen make the permissions of the user a role. The process does until \n the permissions of current role set covers entirely all  \ndefault permissions. \n">
    //    1    3:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #346 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #351 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #357 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #361 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #364 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #361 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #367 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #361 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #370 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #361 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #373 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #361 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = "\t. no paramenters (default =  NULL)";
    //    0    0:ldc2            #379 <String "\t. no paramenters (default =  NULL)">
    //    1    3:astore_1        
        FastVector newVector = new FastVector(1);
    //    2    4:new             #381 <Class FastVector>
    //    3    7:dup             
    //    4    8:iconst_1        
    //    5    9:invokespecial   #384 <Method void FastVector(int)>
    //    6   12:astore_2        
        newVector.addElement(new Option(string1, "", 0, "- < no paramenters>"));
    //    7   13:aload_2         
    //    8   14:new             #386 <Class Option>
    //    9   17:dup             
    //   10   18:aload_1         
    //   11   19:ldc2            #388 <String "">
    //   12   22:iconst_0        
    //   13   23:ldc2            #390 <String "- < no paramenters>">
    //   14   26:invokespecial   #393 <Method void Option(String, String, int, String)>
    //   15   29:invokevirtual   #397 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   16   32:aload_2         
    //   17   33:invokevirtual   #400 <Method Enumeration FastVector.elements()>
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
    //    8   13:ldc2            #388 <String "">
    //    9   16:aastore         
        for(options[current++] = ""; current < options.length; options[current++] = "");
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:ldc2            #388 <String "">
    //   14   25:aastore         
    //   15   26:goto            38
    //   16   29:aload_1         
    //   17   30:iload_2         
    //   18   31:iinc            2  1
    //   19   34:ldc2            #388 <String "">
    //   20   37:aastore         
    //   21   38:iload_2         
    //   22   39:aload_1         
    //   23   40:arraylength     
    //   24   41:icmplt          29
        return options;
    //   25   44:aload_1         
    //   26   45:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field StringBuffer log>
    //    2    4:invokevirtual   #411 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #68  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #414 <Method void Assignment()>
    //    4    8:putfield        #416 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #416 <Field Assignment m_assroles>
    //    7   15:ldc2            #418 <String "role-permission">
    //    8   18:invokevirtual   #421 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(numberOfRoles, permissions.size(), (byte)0);
    //    9   21:new             #74  <Class Matrix>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:getfield        #38  <Field int numberOfRoles>
    //   13   29:aload_0         
    //   14   30:getfield        #47  <Field Vector permissions>
    //   15   33:invokevirtual   #175 <Method int Vector.size()>
    //   16   36:iconst_0        
    //   17   37:invokespecial   #424 <Method void Matrix(int, int, byte)>
    //   18   40:astore_1        
        for(int i = 0; i < numberOfRoles; i++)
    //*  19   41:iconst_0        
    //*  20   42:istore_2        
    //*  21   43:goto            109
        {
            Vector upi = ((Role)roles.get(i)).getPerList();
    //   22   46:aload_0         
    //   23   47:getfield        #53  <Field Vector roles>
    //   24   50:iload_2         
    //   25   51:invokevirtual   #161 <Method Object Vector.get(int)>
    //   26   54:checkcast       #108 <Class HPRoleMinimization$Role>
    //   27   57:invokevirtual   #191 <Method Vector HPRoleMinimization$Role.getPerList()>
    //   28   60:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            94
                if(upi.contains(permissions.get(j)))
    //*  32   67:aload_3         
    //*  33   68:aload_0         
    //*  34   69:getfield        #47  <Field Vector permissions>
    //*  35   72:iload           4
    //*  36   74:invokevirtual   #161 <Method Object Vector.get(int)>
    //*  37   77:invokevirtual   #209 <Method boolean Vector.contains(Object)>
    //*  38   80:ifeq            91
                    mat.set(i, j, (byte)1);
    //   39   83:aload_1         
    //   40   84:iload_2         
    //   41   85:iload           4
    //   42   87:iconst_1        
    //   43   88:invokevirtual   #427 <Method void Matrix.set(int, int, byte)>

    //   44   91:iinc            4  1
    //   45   94:iload           4
    //   46   96:aload_0         
    //   47   97:getfield        #47  <Field Vector permissions>
    //   48  100:invokevirtual   #175 <Method int Vector.size()>
    //   49  103:icmplt          67
        }

    //   50  106:iinc            2  1
    //   51  109:iload_2         
    //   52  110:aload_0         
    //   53  111:getfield        #38  <Field int numberOfRoles>
    //   54  114:icmplt          46
        m_assroles.setAssignmentMatrix(mat);
    //   55  117:aload_0         
    //   56  118:getfield        #416 <Field Assignment m_assroles>
    //   57  121:aload_1         
    //   58  122:invokevirtual   #431 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   59  125:new             #381 <Class FastVector>
    //   60  128:dup             
    //   61  129:invokespecial   #432 <Method void FastVector()>
    //   62  132:astore_2        
        for(int i = 0; i < numberOfRoles; i++)
    //*  63  133:iconst_0        
    //*  64  134:istore_3        
    //*  65  135:goto            162
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   66  138:aload_2         
    //   67  139:new             #113 <Class StringBuilder>
    //   68  142:dup             
    //   69  143:ldc2            #434 <String "R">
    //   70  146:invokespecial   #118 <Method void StringBuilder(String)>
    //   71  149:iload_3         
    //   72  150:invokevirtual   #122 <Method StringBuilder StringBuilder.append(int)>
    //   73  153:invokevirtual   #126 <Method String StringBuilder.toString()>
    //   74  156:invokevirtual   #397 <Method void FastVector.addElement(Object)>

    //   75  159:iinc            3  1
    //   76  162:iload_3         
    //   77  163:aload_0         
    //   78  164:getfield        #38  <Field int numberOfRoles>
    //   79  167:icmplt          138
        Attribute dxa = new Attribute("role", fv);
    //   80  170:new             #314 <Class Attribute>
    //   81  173:dup             
    //   82  174:ldc1            #115 <String "role">
    //   83  176:aload_2         
    //   84  177:invokespecial   #437 <Method void Attribute(String, FastVector)>
    //   85  180:astore_3        
        Dimension dx = new Dimension();
    //   86  181:new             #91  <Class Dimension>
    //   87  184:dup             
    //   88  185:invokespecial   #438 <Method void Dimension()>
    //   89  188:astore          4
        dx.setDimensionAttribute(dxa);
    //   90  190:aload           4
    //   91  192:aload_3         
    //   92  193:invokevirtual   #442 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   93  196:aload_0         
    //   94  197:getfield        #416 <Field Assignment m_assroles>
    //   95  200:aload           4
    //   96  202:invokevirtual   #446 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   97  205:aload_0         
    //   98  206:getfield        #66  <Field Assignment m_assignment>
    //   99  209:invokevirtual   #89  <Method Dimension Assignment.getDimensionY()>
    //  100  212:invokevirtual   #95  <Method Attribute Dimension.getDimensionAttribute()>
    //  101  215:astore          5
        Dimension dy = new Dimension();
    //  102  217:new             #91  <Class Dimension>
    //  103  220:dup             
    //  104  221:invokespecial   #438 <Method void Dimension()>
    //  105  224:astore          6
        dy.setDimensionAttribute(dya);
    //  106  226:aload           6
    //  107  228:aload           5
    //  108  230:invokevirtual   #442 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  109  233:aload_0         
    //  110  234:getfield        #416 <Field Assignment m_assroles>
    //  111  237:aload           6
    //  112  239:invokevirtual   #449 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  113  242:aload_0         
    //  114  243:getfield        #416 <Field Assignment m_assroles>
    //  115  246:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\university_large.ass").toString());
    //    2    2:new             #459 <Class File>
    //    3    5:dup             
    //    4    6:new             #113 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #461 <String "user.dir">
    //    7   13:invokestatic    #467 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #181 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #118 <Method void StringBuilder(String)>
    //   10   22:ldc2            #469 <String "\\datasets\\university_large.ass">
    //   11   25:invokevirtual   #168 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #126 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #470 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #472 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #474 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #477 <Method void FileReader(File)>
    //   21   47:invokespecial   #480 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #483 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #487 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #490 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #495 <Method void PrintStream.println(String)>
            HPRoleMinimization HPr = new HPRoleMinimization();
    //   30   66:new             #2   <Class HPRoleMinimization>
    //   31   69:dup             
    //   32   70:invokespecial   #496 <Method void HPRoleMinimization()>
    //   33   73:astore          4
            HPr.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #498 <Method void buildRoleminers(Assignment)>
            System.out.println(HPr.toString());
    //   37   81:getstatic       #487 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #499 <Method String toString()>
    //   40   89:invokevirtual   #495 <Method void PrintStream.println(String)>
            System.out.println(HPr.generateRoles());
    //   41   92:getstatic       #487 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #501 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #503 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #506 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    public boolean isShould()
    {
        return isShould;
    //    0    0:aload_0         
    //    1    1:getfield        #55  <Field boolean isShould>
    //    2    4:ireturn         
    }

    public void setShould(boolean isShould)
    {
        this.isShould = isShould;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #55  <Field boolean isShould>
    //    3    5:return          
    }

    public Vector getPermissions()
    {
        return permissions;
    //    0    0:aload_0         
    //    1    1:getfield        #47  <Field Vector permissions>
    //    2    4:areturn         
    }

    public void setPermissions(Vector permissions)
    {
        this.permissions = permissions;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #47  <Field Vector permissions>
    //    3    5:return          
    }

    public Vector getRoles()
    {
        return roles;
    //    0    0:aload_0         
    //    1    1:getfield        #53  <Field Vector roles>
    //    2    4:areturn         
    }

    public void setRoles(Vector roles)
    {
        this.roles = roles;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #53  <Field Vector roles>
    //    3    5:return          
    }

    public Vector getUsers()
    {
        return users;
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field Vector users>
    //    2    4:areturn         
    }

    public void setUsers(Vector users)
    {
        this.users = users;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #49  <Field Vector users>
    //    3    5:return          
    }

    public int getWSC()
    {
        return WSC;
    //    0    0:aload_0         
    //    1    1:getfield        #51  <Field int WSC>
    //    2    4:ireturn         
    }

    public void setWSC(int wsc)
    {
        WSC = wsc;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #51  <Field int WSC>
    //    3    5:return          
    }

    protected StringBuffer log;
    protected int numberOfRoles;
    private Vector ableUseList;
    private Vector notCoveredPerList;
    protected Vector permissions;
    protected Vector users;
    protected int WSC;
    protected Vector roles;
    protected boolean isShould;
    protected Assignment m_assignment;
    protected Assignment m_assroles;
}

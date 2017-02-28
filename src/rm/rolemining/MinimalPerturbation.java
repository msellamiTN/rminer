// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   MinimalPerturbation.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.*;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            FastMiner

public class MinimalPerturbation extends FastMiner
{
    public class Role
        implements Comparable
    {

        public int compareTo(Object object)
        {
            Role other = (Role)object;
        //    0    0:aload_1         
        //    1    1:checkcast       #2   <Class MinimalPerturbation$Role>
        //    2    4:astore_2        
            if(area < other.area)
        //*   3    5:aload_0         
        //*   4    6:getfield        #31  <Field int area>
        //*   5    9:aload_2         
        //*   6   10:getfield        #31  <Field int area>
        //*   7   13:icmpge          18
                return 1;
        //    8   16:iconst_1        
        //    9   17:ireturn         
            return area != other.area ? -1 : 0;
        //   10   18:aload_0         
        //   11   19:getfield        #31  <Field int area>
        //   12   22:aload_2         
        //   13   23:getfield        #31  <Field int area>
        //   14   26:icmpne          31
        //   15   29:iconst_0        
        //   16   30:ireturn         
        //   17   31:iconst_m1       
        //   18   32:ireturn         
        }

        public Role copy()
        {
            Role copyRole = new Role();
        //    0    0:new             #2   <Class MinimalPerturbation$Role>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #20  <Field MinimalPerturbation this$0>
        //    4    8:invokespecial   #38  <Method void MinimalPerturbation$Role(MinimalPerturbation)>
        //    5   11:astore_1        
            copyRole.indexOfPerms = (Vector)indexOfPerms.clone();
        //    6   12:aload_1         
        //    7   13:aload_0         
        //    8   14:getfield        #40  <Field Vector indexOfPerms>
        //    9   17:invokevirtual   #46  <Method Object Vector.clone()>
        //   10   20:checkcast       #42  <Class Vector>
        //   11   23:putfield        #40  <Field Vector indexOfPerms>
            copyRole.area = area;
        //   12   26:aload_1         
        //   13   27:aload_0         
        //   14   28:getfield        #31  <Field int area>
        //   15   31:putfield        #31  <Field int area>
            copyRole.useList = useList;
        //   16   34:aload_1         
        //   17   35:aload_0         
        //   18   36:getfield        #48  <Field Vector useList>
        //   19   39:putfield        #48  <Field Vector useList>
            return copyRole;
        //   20   42:aload_1         
        //   21   43:areturn         
        }

        public int getArea()
        {
            return area;
        //    0    0:aload_0         
        //    1    1:getfield        #31  <Field int area>
        //    2    4:ireturn         
        }

        public void setArea(int area)
        {
            this.area = area;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #31  <Field int area>
        //    3    5:return          
        }

        public Vector getIndexOfPerms()
        {
            return indexOfPerms;
        //    0    0:aload_0         
        //    1    1:getfield        #40  <Field Vector indexOfPerms>
        //    2    4:areturn         
        }

        public void setIndexOfPerms(Vector indexOfPerms)
        {
            this.indexOfPerms = indexOfPerms;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #40  <Field Vector indexOfPerms>
        //    3    5:return          
        }

        public Vector getUseList()
        {
            return useList;
        //    0    0:aload_0         
        //    1    1:getfield        #48  <Field Vector useList>
        //    2    4:areturn         
        }

        public void setUseList(Vector useList)
        {
            this.useList = useList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #48  <Field Vector useList>
        //    3    5:return          
        }

        private Vector indexOfPerms;
        private Vector useList;
        private int area;
        final MinimalPerturbation this$0;

        public Role()
        {
            this$0 = MinimalPerturbation.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field MinimalPerturbation this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void Object()>
        //    5    9:return          
        }
    }


    public MinimalPerturbation()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #17  <Method void FastMiner()>
        droles = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #19  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #20  <Method void Vector()>
    //    6   12:putfield        #22  <Field Vector droles>
        roles = new Vector();
    //    7   15:aload_0         
    //    8   16:new             #19  <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #20  <Method void Vector()>
    //   11   23:putfield        #24  <Field Vector roles>
        allroles = new Vector();
    //   12   26:aload_0         
    //   13   27:new             #19  <Class Vector>
    //   14   30:dup             
    //   15   31:invokespecial   #20  <Method void Vector()>
    //   16   34:putfield        #26  <Field Vector allroles>
        resetOptions();
    //   17   37:aload_0         
    //   18   38:invokevirtual   #29  <Method void resetOptions()>
    //   19   41:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        super.setShould(false);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:invokespecial   #42  <Method void FastMiner.setShould(boolean)>
        super.buildRoleminers(data);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokespecial   #44  <Method void FastMiner.buildRoleminers(Assignment)>
        GetAllRoles();
    //    6   10:aload_0         
    //    7   11:invokespecial   #47  <Method void GetAllRoles()>
        getUsersOfallroles();
    //    8   14:aload_0         
    //    9   15:invokespecial   #50  <Method void getUsersOfallroles()>
        initDRoles(data);
    //   10   18:aload_0         
    //   11   19:aload_1         
    //   12   20:invokespecial   #53  <Method void initDRoles(Assignment)>
        sortAllRoles(data);
    //   13   23:aload_0         
    //   14   24:aload_1         
    //   15   25:invokespecial   #56  <Method void sortAllRoles(Assignment)>
    //*  16   28:goto            189
        while(!isUPACovered(data)) 
        {
            Role bestRole = new Role();
    //   17   31:new             #58  <Class MinimalPerturbation$Role>
    //   18   34:dup             
    //   19   35:aload_0         
    //   20   36:invokespecial   #61  <Method void MinimalPerturbation$Role(MinimalPerturbation)>
    //   21   39:astore_2        
            double bestScore = 0.0D;
    //   22   40:dconst_0        
    //   23   41:dstore_3        
            int bestIndex = 0x7fffffff;
    //   24   42:ldc1            #62  <Int 0x7fffffff>
    //   25   44:istore          5
            for(int index = 0; index < allroles.size(); index++)
    //*  26   46:iconst_0        
    //*  27   47:istore          6
    //*  28   49:goto            146
            {
                Role selectRole = (Role)allroles.get(index);
    //   29   52:aload_0         
    //   30   53:getfield        #26  <Field Vector allroles>
    //   31   56:iload           6
    //   32   58:invokevirtual   #66  <Method Object Vector.get(int)>
    //   33   61:checkcast       #58  <Class MinimalPerturbation$Role>
    //   34   64:astore          7
                if((double)selectRole.getArea() < bestScore)
    //*  35   66:aload           7
    //*  36   68:invokevirtual   #70  <Method int MinimalPerturbation$Role.getArea()>
    //*  37   71:i2d             
    //*  38   72:dload_3         
    //*  39   73:dcmpg           
    //*  40   74:ifge            80
                    break;
    //   41   77:goto            158
                double carea = Unconvered_Area(selectRole, data);
    //   42   80:aload_0         
    //   43   81:aload           7
    //   44   83:aload_1         
    //   45   84:invokespecial   #74  <Method double Unconvered_Area(MinimalPerturbation$Role, Assignment)>
    //   46   87:dstore          8
                double csim = Similarity(selectRole, droles);
    //   47   89:aload_0         
    //   48   90:aload           7
    //   49   92:aload_0         
    //   50   93:getfield        #22  <Field Vector droles>
    //   51   96:invokespecial   #78  <Method double Similarity(MinimalPerturbation$Role, Vector)>
    //   52   99:dstore          10
                double score = (1.0D - w) * carea + w * carea * csim;
    //   53  101:dconst_1        
    //   54  102:aload_0         
    //   55  103:getfield        #80  <Field double w>
    //   56  106:dsub            
    //   57  107:dload           8
    //   58  109:dmul            
    //   59  110:aload_0         
    //   60  111:getfield        #80  <Field double w>
    //   61  114:dload           8
    //   62  116:dmul            
    //   63  117:dload           10
    //   64  119:dmul            
    //   65  120:dadd            
    //   66  121:dstore          12
                if(score > bestScore)
    //*  67  123:dload           12
    //*  68  125:dload_3         
    //*  69  126:dcmpl           
    //*  70  127:ifle            143
                {
                    bestScore = score;
    //   71  130:dload           12
    //   72  132:dstore_3        
                    bestRole = selectRole.copy();
    //   73  133:aload           7
    //   74  135:invokevirtual   #84  <Method MinimalPerturbation$Role MinimalPerturbation$Role.copy()>
    //   75  138:astore_2        
                    bestIndex = index;
    //   76  139:iload           6
    //   77  141:istore          5
                }
            }

    //   78  143:iinc            6  1
    //   79  146:iload           6
    //   80  148:aload_0         
    //   81  149:getfield        #26  <Field Vector allroles>
    //   82  152:invokevirtual   #87  <Method int Vector.size()>
    //   83  155:icmplt          52
            if(bestIndex < allroles.size())
    //*  84  158:iload           5
    //*  85  160:aload_0         
    //*  86  161:getfield        #26  <Field Vector allroles>
    //*  87  164:invokevirtual   #87  <Method int Vector.size()>
    //*  88  167:icmpge          189
            {
                roles.add(bestRole);
    //   89  170:aload_0         
    //   90  171:getfield        #24  <Field Vector roles>
    //   91  174:aload_2         
    //   92  175:invokevirtual   #91  <Method boolean Vector.add(Object)>
    //   93  178:pop             
                allroles.remove(bestIndex);
    //   94  179:aload_0         
    //   95  180:getfield        #26  <Field Vector allroles>
    //   96  183:iload           5
    //   97  185:invokevirtual   #94  <Method Object Vector.remove(int)>
    //   98  188:pop             
            }
        }
    //   99  189:aload_0         
    //  100  190:aload_1         
    //  101  191:invokespecial   #98  <Method boolean isUPACovered(Assignment)>
    //  102  194:ifeq            31
        printRoleState(roles);
    //  103  197:aload_0         
    //  104  198:aload_0         
    //  105  199:getfield        #24  <Field Vector roles>
    //  106  202:invokespecial   #102 <Method void printRoleState(Vector)>
    //  107  205:return          
    }

    private void getUsersOfallroles()
    {
        for(int index = 0; index < allroles.size(); index++)
    //*   0    0:iconst_0        
    //*   1    1:istore_1        
    //*   2    2:goto            36
            ((Role)allroles.get(index)).setUseList(((CFMAbstractParent.Role)allroleSet.get(index)).getUseList());
    //    3    5:aload_0         
    //    4    6:getfield        #26  <Field Vector allroles>
    //    5    9:iload_1         
    //    6   10:invokevirtual   #66  <Method Object Vector.get(int)>
    //    7   13:checkcast       #58  <Class MinimalPerturbation$Role>
    //    8   16:aload_0         
    //    9   17:getfield        #117 <Field Vector allroleSet>
    //   10   20:iload_1         
    //   11   21:invokevirtual   #66  <Method Object Vector.get(int)>
    //   12   24:checkcast       #119 <Class CFMAbstractParent$Role>
    //   13   27:invokevirtual   #123 <Method Vector CFMAbstractParent$Role.getUseList()>
    //   14   30:invokevirtual   #126 <Method void MinimalPerturbation$Role.setUseList(Vector)>

    //   15   33:iinc            1  1
    //   16   36:iload_1         
    //   17   37:aload_0         
    //   18   38:getfield        #26  <Field Vector allroles>
    //   19   41:invokevirtual   #87  <Method int Vector.size()>
    //   20   44:icmplt          5
    //   21   47:return          
    }

    private void GetAllRoles()
    {
        Role role;
        for(Iterator iterator = GenRoles.iterator(); iterator.hasNext(); allroles.add(role))
    //*   0    0:aload_0         
    //*   1    1:getfield        #129 <Field Vector GenRoles>
    //*   2    4:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*   3    7:astore_2        
    //*   4    8:goto            69
        {
            CFMAbstractParent.GenRoleToCounts genRole = (CFMAbstractParent.GenRoleToCounts)iterator.next();
    //    5   11:aload_2         
    //    6   12:invokeinterface #139 <Method Object Iterator.next()>
    //    7   17:checkcast       #141 <Class CFMAbstractParent$GenRoleToCounts>
    //    8   20:astore_1        
            role = new Role();
    //    9   21:new             #58  <Class MinimalPerturbation$Role>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:invokespecial   #61  <Method void MinimalPerturbation$Role(MinimalPerturbation)>
    //   13   29:astore_3        
            role.setIndexOfPerms((Vector)genRole.getInitRole().clone());
    //   14   30:aload_3         
    //   15   31:aload_1         
    //   16   32:invokevirtual   #144 <Method Vector CFMAbstractParent$GenRoleToCounts.getInitRole()>
    //   17   35:invokevirtual   #147 <Method Object Vector.clone()>
    //   18   38:checkcast       #19  <Class Vector>
    //   19   41:invokevirtual   #150 <Method void MinimalPerturbation$Role.setIndexOfPerms(Vector)>
            role.setArea(genRole.getCounts());
    //   20   44:aload_3         
    //   21   45:aload_1         
    //   22   46:invokevirtual   #153 <Method int CFMAbstractParent$GenRoleToCounts.getCounts()>
    //   23   49:invokevirtual   #157 <Method void MinimalPerturbation$Role.setArea(int)>
            role.setUseList(genRole.getUseList());
    //   24   52:aload_3         
    //   25   53:aload_1         
    //   26   54:invokevirtual   #158 <Method Vector CFMAbstractParent$GenRoleToCounts.getUseList()>
    //   27   57:invokevirtual   #126 <Method void MinimalPerturbation$Role.setUseList(Vector)>
        }

    //   28   60:aload_0         
    //   29   61:getfield        #26  <Field Vector allroles>
    //   30   64:aload_3         
    //   31   65:invokevirtual   #91  <Method boolean Vector.add(Object)>
    //   32   68:pop             
    //   33   69:aload_2         
    //   34   70:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   35   75:ifne            11
        Role role;
        for(Iterator iterator1 = InitRoles.iterator(); iterator1.hasNext(); allroles.add(role))
    //*  36   78:aload_0         
    //*  37   79:getfield        #165 <Field Vector InitRoles>
    //*  38   82:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*  39   85:astore_2        
    //*  40   86:goto            147
        {
            CFMAbstractParent.InitRoleToCounts inToRole = (CFMAbstractParent.InitRoleToCounts)iterator1.next();
    //   41   89:aload_2         
    //   42   90:invokeinterface #139 <Method Object Iterator.next()>
    //   43   95:checkcast       #167 <Class CFMAbstractParent$InitRoleToCounts>
    //   44   98:astore_1        
            role = new Role();
    //   45   99:new             #58  <Class MinimalPerturbation$Role>
    //   46  102:dup             
    //   47  103:aload_0         
    //   48  104:invokespecial   #61  <Method void MinimalPerturbation$Role(MinimalPerturbation)>
    //   49  107:astore_3        
            role.setIndexOfPerms((Vector)inToRole.getInitRole().clone());
    //   50  108:aload_3         
    //   51  109:aload_1         
    //   52  110:invokevirtual   #168 <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   53  113:invokevirtual   #147 <Method Object Vector.clone()>
    //   54  116:checkcast       #19  <Class Vector>
    //   55  119:invokevirtual   #150 <Method void MinimalPerturbation$Role.setIndexOfPerms(Vector)>
            role.setArea(inToRole.getCounts());
    //   56  122:aload_3         
    //   57  123:aload_1         
    //   58  124:invokevirtual   #169 <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //   59  127:invokevirtual   #157 <Method void MinimalPerturbation$Role.setArea(int)>
            role.setUseList(inToRole.getUseList());
    //   60  130:aload_3         
    //   61  131:aload_1         
    //   62  132:invokevirtual   #170 <Method Vector CFMAbstractParent$InitRoleToCounts.getUseList()>
    //   63  135:invokevirtual   #126 <Method void MinimalPerturbation$Role.setUseList(Vector)>
        }

    //   64  138:aload_0         
    //   65  139:getfield        #26  <Field Vector allroles>
    //   66  142:aload_3         
    //   67  143:invokevirtual   #91  <Method boolean Vector.add(Object)>
    //   68  146:pop             
    //   69  147:aload_2         
    //   70  148:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   71  153:ifne            89
    //   72  156:return          
    }

    private void printRoleState(Vector roles2)
    {
        numberOfRoles = roles2.size();
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #87  <Method int Vector.size()>
    //    3    5:putfield        #179 <Field int numberOfRoles>
        log.append("\n--------------------------------------------------------\n");
    //    4    8:aload_0         
    //    5    9:getfield        #183 <Field StringBuffer log>
    //    6   12:ldc1            #185 <String "\n--------------------------------------------------------\n">
    //    7   14:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //    8   17:pop             
        for(int index = 0; index < numberOfRoles; index++)
    //*   9   18:iconst_0        
    //*  10   19:istore_2        
    //*  11   20:goto            369
        {
            log.append((new StringBuilder("The permissions of the ")).append(index).append("th role are: \n").toString());
    //   12   23:aload_0         
    //   13   24:getfield        #183 <Field StringBuffer log>
    //   14   27:new             #193 <Class StringBuilder>
    //   15   30:dup             
    //   16   31:ldc1            #195 <String "The permissions of the ">
    //   17   33:invokespecial   #198 <Method void StringBuilder(String)>
    //   18   36:iload_2         
    //   19   37:invokevirtual   #201 <Method StringBuilder StringBuilder.append(int)>
    //   20   40:ldc1            #203 <String "th role are: \n">
    //   21   42:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //   22   45:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   23   48:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //   24   51:pop             
            Vector currentPerms = ((Role)roles2.get(index)).getIndexOfPerms();
    //   25   52:aload_1         
    //   26   53:iload_2         
    //   27   54:invokevirtual   #66  <Method Object Vector.get(int)>
    //   28   57:checkcast       #58  <Class MinimalPerturbation$Role>
    //   29   60:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //   30   63:astore_3        
            for(int jndex = 0; jndex < currentPerms.size(); jndex++)
    //*  31   64:iconst_0        
    //*  32   65:istore          4
    //*  33   67:goto            183
                if(jndex != currentPerms.size() - 1)
    //*  34   70:iload           4
    //*  35   72:aload_3         
    //*  36   73:invokevirtual   #87  <Method int Vector.size()>
    //*  37   76:iconst_1        
    //*  38   77:isub            
    //*  39   78:icmpeq          132
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)currentPerms.get(jndex)).intValue())))).append(",").toString());
    //   40   81:aload_0         
    //   41   82:getfield        #183 <Field StringBuffer log>
    //   42   85:new             #193 <Class StringBuilder>
    //   43   88:dup             
    //   44   89:aload_0         
    //   45   90:getfield        #216 <Field Vector permissions>
    //   46   93:aload_3         
    //   47   94:iload           4
    //   48   96:invokevirtual   #66  <Method Object Vector.get(int)>
    //   49   99:checkcast       #218 <Class Integer>
    //   50  102:invokevirtual   #221 <Method int Integer.intValue()>
    //   51  105:invokevirtual   #66  <Method Object Vector.get(int)>
    //   52  108:checkcast       #223 <Class String>
    //   53  111:invokestatic    #227 <Method String String.valueOf(Object)>
    //   54  114:invokespecial   #198 <Method void StringBuilder(String)>
    //   55  117:ldc1            #229 <String ",">
    //   56  119:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //   57  122:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   58  125:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //   59  128:pop             
                else
    //*  60  129:goto            180
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)currentPerms.get(jndex)).intValue())))).append("\n").toString());
    //   61  132:aload_0         
    //   62  133:getfield        #183 <Field StringBuffer log>
    //   63  136:new             #193 <Class StringBuilder>
    //   64  139:dup             
    //   65  140:aload_0         
    //   66  141:getfield        #216 <Field Vector permissions>
    //   67  144:aload_3         
    //   68  145:iload           4
    //   69  147:invokevirtual   #66  <Method Object Vector.get(int)>
    //   70  150:checkcast       #218 <Class Integer>
    //   71  153:invokevirtual   #221 <Method int Integer.intValue()>
    //   72  156:invokevirtual   #66  <Method Object Vector.get(int)>
    //   73  159:checkcast       #223 <Class String>
    //   74  162:invokestatic    #227 <Method String String.valueOf(Object)>
    //   75  165:invokespecial   #198 <Method void StringBuilder(String)>
    //   76  168:ldc1            #231 <String "\n">
    //   77  170:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //   78  173:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   79  176:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //   80  179:pop             

    //   81  180:iinc            4  1
    //   82  183:iload           4
    //   83  185:aload_3         
    //   84  186:invokevirtual   #87  <Method int Vector.size()>
    //   85  189:icmplt          70
            log.append((new StringBuilder("The users of the ")).append(index).append("th role are: ").toString());
    //   86  192:aload_0         
    //   87  193:getfield        #183 <Field StringBuffer log>
    //   88  196:new             #193 <Class StringBuilder>
    //   89  199:dup             
    //   90  200:ldc1            #233 <String "The users of the ">
    //   91  202:invokespecial   #198 <Method void StringBuilder(String)>
    //   92  205:iload_2         
    //   93  206:invokevirtual   #201 <Method StringBuilder StringBuilder.append(int)>
    //   94  209:ldc1            #235 <String "th role are: ">
    //   95  211:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //   96  214:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   97  217:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //   98  220:pop             
            Vector currentUsers = ((Role)roles2.get(index)).getUseList();
    //   99  221:aload_1         
    //  100  222:iload_2         
    //  101  223:invokevirtual   #66  <Method Object Vector.get(int)>
    //  102  226:checkcast       #58  <Class MinimalPerturbation$Role>
    //  103  229:invokevirtual   #236 <Method Vector MinimalPerturbation$Role.getUseList()>
    //  104  232:astore          4
            for(int jndex = 0; jndex < currentUsers.size(); jndex++)
    //* 105  234:iconst_0        
    //* 106  235:istore          5
    //* 107  237:goto            356
                if(jndex != currentUsers.size() - 1)
    //* 108  240:iload           5
    //* 109  242:aload           4
    //* 110  244:invokevirtual   #87  <Method int Vector.size()>
    //* 111  247:iconst_1        
    //* 112  248:isub            
    //* 113  249:icmpeq          304
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)currentUsers.get(jndex)).intValue())))).append(",").toString());
    //  114  252:aload_0         
    //  115  253:getfield        #183 <Field StringBuffer log>
    //  116  256:new             #193 <Class StringBuilder>
    //  117  259:dup             
    //  118  260:aload_0         
    //  119  261:getfield        #239 <Field Vector users>
    //  120  264:aload           4
    //  121  266:iload           5
    //  122  268:invokevirtual   #66  <Method Object Vector.get(int)>
    //  123  271:checkcast       #218 <Class Integer>
    //  124  274:invokevirtual   #221 <Method int Integer.intValue()>
    //  125  277:invokevirtual   #66  <Method Object Vector.get(int)>
    //  126  280:checkcast       #223 <Class String>
    //  127  283:invokestatic    #227 <Method String String.valueOf(Object)>
    //  128  286:invokespecial   #198 <Method void StringBuilder(String)>
    //  129  289:ldc1            #229 <String ",">
    //  130  291:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //  131  294:invokevirtual   #210 <Method String StringBuilder.toString()>
    //  132  297:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //  133  300:pop             
                else
    //* 134  301:goto            353
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)currentUsers.get(jndex)).intValue())))).append("\n").toString());
    //  135  304:aload_0         
    //  136  305:getfield        #183 <Field StringBuffer log>
    //  137  308:new             #193 <Class StringBuilder>
    //  138  311:dup             
    //  139  312:aload_0         
    //  140  313:getfield        #239 <Field Vector users>
    //  141  316:aload           4
    //  142  318:iload           5
    //  143  320:invokevirtual   #66  <Method Object Vector.get(int)>
    //  144  323:checkcast       #218 <Class Integer>
    //  145  326:invokevirtual   #221 <Method int Integer.intValue()>
    //  146  329:invokevirtual   #66  <Method Object Vector.get(int)>
    //  147  332:checkcast       #223 <Class String>
    //  148  335:invokestatic    #227 <Method String String.valueOf(Object)>
    //  149  338:invokespecial   #198 <Method void StringBuilder(String)>
    //  150  341:ldc1            #231 <String "\n">
    //  151  343:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //  152  346:invokevirtual   #210 <Method String StringBuilder.toString()>
    //  153  349:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //  154  352:pop             

    //  155  353:iinc            5  1
    //  156  356:iload           5
    //  157  358:aload           4
    //  158  360:invokevirtual   #87  <Method int Vector.size()>
    //  159  363:icmplt          240
        }

    //  160  366:iinc            2  1
    //  161  369:iload_2         
    //  162  370:aload_0         
    //  163  371:getfield        #179 <Field int numberOfRoles>
    //  164  374:icmplt          23
        log.append("\n--------------------------------------------------------\n");
    //  165  377:aload_0         
    //  166  378:getfield        #183 <Field StringBuffer log>
    //  167  381:ldc1            #185 <String "\n--------------------------------------------------------\n">
    //  168  383:invokevirtual   #191 <Method StringBuffer StringBuffer.append(String)>
    //  169  386:pop             
    //  170  387:return          
    }

    private double Similarity(Role selectRole, Vector droles2)
    {
        double maxSim = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_3        
        for(Iterator iterator = droles2.iterator(); iterator.hasNext();)
    //*   2    2:aload_2         
    //*   3    3:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*   4    6:astore          6
    //*   5    8:goto            58
        {
            Role dRole = (Role)iterator.next();
    //    6   11:aload           6
    //    7   13:invokeinterface #139 <Method Object Iterator.next()>
    //    8   18:checkcast       #58  <Class MinimalPerturbation$Role>
    //    9   21:astore          5
            double ni = intersection(selectRole, dRole);
    //   10   23:aload_0         
    //   11   24:aload_1         
    //   12   25:aload           5
    //   13   27:invokespecial   #250 <Method double intersection(MinimalPerturbation$Role, MinimalPerturbation$Role)>
    //   14   30:dstore          7
            double nu = union(selectRole, dRole);
    //   15   32:aload_0         
    //   16   33:aload_1         
    //   17   34:aload           5
    //   18   36:invokespecial   #253 <Method double union(MinimalPerturbation$Role, MinimalPerturbation$Role)>
    //   19   39:dstore          9
            double sim = ni / nu;
    //   20   41:dload           7
    //   21   43:dload           9
    //   22   45:ddiv            
    //   23   46:dstore          11
            if(sim > maxSim)
    //*  24   48:dload           11
    //*  25   50:dload_3         
    //*  26   51:dcmpl           
    //*  27   52:ifle            58
                maxSim = sim;
    //   28   55:dload           11
    //   29   57:dstore_3        
        }

    //   30   58:aload           6
    //   31   60:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   32   65:ifne            11
        return maxSim;
    //   33   68:dload_3         
    //   34   69:dreturn         
    }

    private double union(Role selectRole, Role role)
    {
        double count = selectRole.getIndexOfPerms().size();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //    2    4:invokevirtual   #87  <Method int Vector.size()>
    //    3    7:i2d             
    //    4    8:dstore_3        
        for(Iterator iterator = role.getIndexOfPerms().iterator(); iterator.hasNext();)
    //*   5    9:aload_2         
    //*   6   10:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //*   7   13:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*   8   16:astore          6
    //*   9   18:goto            55
        {
            int jndexperm = ((Integer)iterator.next()).intValue();
    //   10   21:aload           6
    //   11   23:invokeinterface #139 <Method Object Iterator.next()>
    //   12   28:checkcast       #218 <Class Integer>
    //   13   31:invokevirtual   #221 <Method int Integer.intValue()>
    //   14   34:istore          5
            if(!selectRole.getIndexOfPerms().contains(Integer.valueOf(jndexperm)))
    //*  15   36:aload_1         
    //*  16   37:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //*  17   40:iload           5
    //*  18   42:invokestatic    #262 <Method Integer Integer.valueOf(int)>
    //*  19   45:invokevirtual   #265 <Method boolean Vector.contains(Object)>
    //*  20   48:ifne            55
                count++;
    //   21   51:dload_3         
    //   22   52:dconst_1        
    //   23   53:dadd            
    //   24   54:dstore_3        
        }

    //   25   55:aload           6
    //   26   57:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   27   62:ifne            21
        return count;
    //   28   65:dload_3         
    //   29   66:dreturn         
    }

    private double intersection(Role selectRole, Role role)
    {
        double count = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_3        
        for(Iterator iterator = selectRole.getIndexOfPerms().iterator(); iterator.hasNext();)
    //*   2    2:aload_1         
    //*   3    3:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //*   4    6:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*   5    9:astore          6
    //*   6   11:goto            48
        {
            int indexperm = ((Integer)iterator.next()).intValue();
    //    7   14:aload           6
    //    8   16:invokeinterface #139 <Method Object Iterator.next()>
    //    9   21:checkcast       #218 <Class Integer>
    //   10   24:invokevirtual   #221 <Method int Integer.intValue()>
    //   11   27:istore          5
            if(role.getIndexOfPerms().contains(Integer.valueOf(indexperm)))
    //*  12   29:aload_2         
    //*  13   30:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //*  14   33:iload           5
    //*  15   35:invokestatic    #262 <Method Integer Integer.valueOf(int)>
    //*  16   38:invokevirtual   #265 <Method boolean Vector.contains(Object)>
    //*  17   41:ifeq            48
                count++;
    //   18   44:dload_3         
    //   19   45:dconst_1        
    //   20   46:dadd            
    //   21   47:dstore_3        
        }

    //   22   48:aload           6
    //   23   50:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   24   55:ifne            14
        return count;
    //   25   58:dload_3         
    //   26   59:dreturn         
    }

    private double Unconvered_Area(Role selectRole, Assignment ass)
    {
        double area = 0.0D;
    //    0    0:dconst_0        
    //    1    1:dstore_3        
        Vector permList = (Vector)selectRole.getIndexOfPerms().clone();
    //    2    2:aload_1         
    //    3    3:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //    4    6:invokevirtual   #147 <Method Object Vector.clone()>
    //    5    9:checkcast       #19  <Class Vector>
    //    6   12:astore          5
        for(int index = 0; index < permList.size(); index++)
    //*   7   14:iconst_0        
    //*   8   15:istore          6
    //*   9   17:goto            86
        {
            for(Iterator iterator = roles.iterator(); iterator.hasNext();)
    //*  10   20:aload_0         
    //*  11   21:getfield        #24  <Field Vector roles>
    //*  12   24:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*  13   27:astore          8
    //*  14   29:goto            73
            {
                Role role = (Role)iterator.next();
    //   15   32:aload           8
    //   16   34:invokeinterface #139 <Method Object Iterator.next()>
    //   17   39:checkcast       #58  <Class MinimalPerturbation$Role>
    //   18   42:astore          7
                if(role.getIndexOfPerms().contains(permList.get(index)))
    //*  19   44:aload           7
    //*  20   46:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //*  21   49:aload           5
    //*  22   51:iload           6
    //*  23   53:invokevirtual   #66  <Method Object Vector.get(int)>
    //*  24   56:invokevirtual   #265 <Method boolean Vector.contains(Object)>
    //*  25   59:ifeq            73
                {
                    permList.remove(index);
    //   26   62:aload           5
    //   27   64:iload           6
    //   28   66:invokevirtual   #94  <Method Object Vector.remove(int)>
    //   29   69:pop             
                    break;
    //   30   70:goto            83
                }
            }

    //   31   73:aload           8
    //   32   75:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   33   80:ifne            32
        }

    //   34   83:iinc            6  1
    //   35   86:iload           6
    //   36   88:aload           5
    //   37   90:invokevirtual   #87  <Method int Vector.size()>
    //   38   93:icmplt          20
        Matrix mat = ass.getAssignmentMatrix();
    //   39   96:aload_2         
    //   40   97:invokevirtual   #274 <Method Matrix Assignment.getAssignmentMatrix()>
    //   41  100:astore          6
        for(Iterator iterator1 = permList.iterator(); iterator1.hasNext();)
    //*  42  102:aload           5
    //*  43  104:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*  44  107:astore          8
    //*  45  109:goto            163
        {
            int indexPerm = ((Integer)iterator1.next()).intValue();
    //   46  112:aload           8
    //   47  114:invokeinterface #139 <Method Object Iterator.next()>
    //   48  119:checkcast       #218 <Class Integer>
    //   49  122:invokevirtual   #221 <Method int Integer.intValue()>
    //   50  125:istore          7
            for(int index = 0; index < mat.getRowDimension(); index++)
    //*  51  127:iconst_0        
    //*  52  128:istore          9
    //*  53  130:goto            153
                if(mat.get(index, indexPerm) == 1)
    //*  54  133:aload           6
    //*  55  135:iload           9
    //*  56  137:iload           7
    //*  57  139:invokevirtual   #279 <Method byte Matrix.get(int, int)>
    //*  58  142:iconst_1        
    //*  59  143:icmpne          150
                    area++;
    //   60  146:dload_3         
    //   61  147:dconst_1        
    //   62  148:dadd            
    //   63  149:dstore_3        

    //   64  150:iinc            9  1
    //   65  153:iload           9
    //   66  155:aload           6
    //   67  157:invokevirtual   #282 <Method int Matrix.getRowDimension()>
    //   68  160:icmplt          133
        }

    //   69  163:aload           8
    //   70  165:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   71  170:ifne            112
        return area;
    //   72  173:dload_3         
    //   73  174:dreturn         
    }

    private boolean isUPACovered(Assignment ass)
    {
        Matrix mat = ass.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #274 <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        for(int index = 0; index < mat.getColumnDimension(); index++)
    //*   3    5:iconst_0        
    //*   4    6:istore_3        
    //*   5    7:goto            76
        {
            int jndex;
            for(jndex = 0; jndex < roles.size(); jndex++)
    //*   6   10:iconst_0        
    //*   7   11:istore          4
    //*   8   13:goto            47
                if(((Role)roles.get(jndex)).getIndexOfPerms().contains(Integer.valueOf(index)))
    //*   9   16:aload_0         
    //*  10   17:getfield        #24  <Field Vector roles>
    //*  11   20:iload           4
    //*  12   22:invokevirtual   #66  <Method Object Vector.get(int)>
    //*  13   25:checkcast       #58  <Class MinimalPerturbation$Role>
    //*  14   28:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //*  15   31:iload_3         
    //*  16   32:invokestatic    #262 <Method Integer Integer.valueOf(int)>
    //*  17   35:invokevirtual   #265 <Method boolean Vector.contains(Object)>
    //*  18   38:ifeq            44
                    break;
    //   19   41:goto            59

    //   20   44:iinc            4  1
    //   21   47:iload           4
    //   22   49:aload_0         
    //   23   50:getfield        #24  <Field Vector roles>
    //   24   53:invokevirtual   #87  <Method int Vector.size()>
    //   25   56:icmplt          16
            if(jndex == roles.size())
    //*  26   59:iload           4
    //*  27   61:aload_0         
    //*  28   62:getfield        #24  <Field Vector roles>
    //*  29   65:invokevirtual   #87  <Method int Vector.size()>
    //*  30   68:icmpne          73
                return false;
    //   31   71:iconst_0        
    //   32   72:ireturn         
        }

    //   33   73:iinc            3  1
    //   34   76:iload_3         
    //   35   77:aload_2         
    //   36   78:invokevirtual   #291 <Method int Matrix.getColumnDimension()>
    //   37   81:icmplt          10
        return true;
    //   38   84:iconst_1        
    //   39   85:ireturn         
    }

    private void sortAllRoles(Assignment ass)
    {
        Role role;
        for(Iterator iterator = allroles.iterator(); iterator.hasNext(); role.setArea(calculateArea(role, ass)))
    //*   0    0:aload_0         
    //*   1    1:getfield        #26  <Field Vector allroles>
    //*   2    4:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*   3    7:astore_3        
    //*   4    8:goto            31
            role = (Role)iterator.next();
    //    5   11:aload_3         
    //    6   12:invokeinterface #139 <Method Object Iterator.next()>
    //    7   17:checkcast       #58  <Class MinimalPerturbation$Role>
    //    8   20:astore_2        

    //    9   21:aload_2         
    //   10   22:aload_0         
    //   11   23:aload_2         
    //   12   24:aload_1         
    //   13   25:invokespecial   #295 <Method int calculateArea(MinimalPerturbation$Role, Assignment)>
    //   14   28:invokevirtual   #157 <Method void MinimalPerturbation$Role.setArea(int)>
    //   15   31:aload_3         
    //   16   32:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   17   37:ifne            11
        Collections.sort(allroles);
    //   18   40:aload_0         
    //   19   41:getfield        #26  <Field Vector allroles>
    //   20   44:invokestatic    #301 <Method void Collections.sort(java.util.List)>
    //   21   47:return          
    }

    private int calculateArea(Role role, Assignment ass)
    {
        Matrix mat = ass.getAssignmentMatrix();
    //    0    0:aload_2         
    //    1    1:invokevirtual   #274 <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_3        
        Vector permVect = role.getIndexOfPerms();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //    5    9:astore          4
        int area = 0;
    //    6   11:iconst_0        
    //    7   12:istore          5
        for(Iterator iterator = permVect.iterator(); iterator.hasNext();)
    //*   8   14:aload           4
    //*   9   16:invokevirtual   #133 <Method Iterator Vector.iterator()>
    //*  10   19:astore          7
    //*  11   21:goto            72
        {
            int perm = ((Integer)iterator.next()).intValue();
    //   12   24:aload           7
    //   13   26:invokeinterface #139 <Method Object Iterator.next()>
    //   14   31:checkcast       #218 <Class Integer>
    //   15   34:invokevirtual   #221 <Method int Integer.intValue()>
    //   16   37:istore          6
            for(int index = 0; index < mat.getRowDimension(); index++)
    //*  17   39:iconst_0        
    //*  18   40:istore          8
    //*  19   42:goto            63
                if(mat.get(index, perm) == 1)
    //*  20   45:aload_3         
    //*  21   46:iload           8
    //*  22   48:iload           6
    //*  23   50:invokevirtual   #279 <Method byte Matrix.get(int, int)>
    //*  24   53:iconst_1        
    //*  25   54:icmpne          60
                    area++;
    //   26   57:iinc            5  1

    //   27   60:iinc            8  1
    //   28   63:iload           8
    //   29   65:aload_3         
    //   30   66:invokevirtual   #282 <Method int Matrix.getRowDimension()>
    //   31   69:icmplt          45
        }

    //   32   72:aload           7
    //   33   74:invokeinterface #162 <Method boolean Iterator.hasNext()>
    //   34   79:ifne            24
        return area;
    //   35   82:iload           5
    //   36   84:ireturn         
    }

    private void initDRoles(Assignment ass)
    {
        Matrix mat = ass.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #274 <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        for(int index = 0; index < mat.getRowDimension(); index++)
    //*   3    5:iconst_0        
    //*   4    6:istore_3        
    //*   5    7:goto            95
        {
            Role role = new Role();
    //    6   10:new             #58  <Class MinimalPerturbation$Role>
    //    7   13:dup             
    //    8   14:aload_0         
    //    9   15:invokespecial   #61  <Method void MinimalPerturbation$Role(MinimalPerturbation)>
    //   10   18:astore          4
            Vector permSet = new Vector();
    //   11   20:new             #19  <Class Vector>
    //   12   23:dup             
    //   13   24:invokespecial   #20  <Method void Vector()>
    //   14   27:astore          5
            for(int jndex = 0; jndex < mat.getColumnDimension(); jndex++)
    //*  15   29:iconst_0        
    //*  16   30:istore          6
    //*  17   32:goto            60
                if(mat.get(index, jndex) == 1)
    //*  18   35:aload_2         
    //*  19   36:iload_3         
    //*  20   37:iload           6
    //*  21   39:invokevirtual   #279 <Method byte Matrix.get(int, int)>
    //*  22   42:iconst_1        
    //*  23   43:icmpne          57
                    permSet.add(Integer.valueOf(jndex));
    //   24   46:aload           5
    //   25   48:iload           6
    //   26   50:invokestatic    #262 <Method Integer Integer.valueOf(int)>
    //   27   53:invokevirtual   #91  <Method boolean Vector.add(Object)>
    //   28   56:pop             

    //   29   57:iinc            6  1
    //   30   60:iload           6
    //   31   62:aload_2         
    //   32   63:invokevirtual   #291 <Method int Matrix.getColumnDimension()>
    //   33   66:icmplt          35
            role.setIndexOfPerms(permSet);
    //   34   69:aload           4
    //   35   71:aload           5
    //   36   73:invokevirtual   #150 <Method void MinimalPerturbation$Role.setIndexOfPerms(Vector)>
            role.setArea(0);
    //   37   76:aload           4
    //   38   78:iconst_0        
    //   39   79:invokevirtual   #157 <Method void MinimalPerturbation$Role.setArea(int)>
            droles.add(role);
    //   40   82:aload_0         
    //   41   83:getfield        #22  <Field Vector droles>
    //   42   86:aload           4
    //   43   88:invokevirtual   #91  <Method boolean Vector.add(Object)>
    //   44   91:pop             
        }

    //   45   92:iinc            3  1
    //   46   95:iload_3         
    //   47   96:aload_2         
    //   48   97:invokevirtual   #282 <Method int Matrix.getRowDimension()>
    //   49  100:icmplt          10
    //   50  103:return          
    }

    public void resetOptions()
    {
        w = 0.5D;
    //    0    0:aload_0         
    //    1    1:ldc2w           #305 <Double 0.5D>
    //    2    4:putfield        #80  <Field double w>
    //    3    7:return          
    }

    public String globalInfo()
    {
        return "RMP frist gets the candidate sequence by FM, then select roles \nby the max similarity between the current selected role and the \ndefault role set until the UPA is entire covered. \n";
    //    0    0:ldc2            #309 <String "RMP frist gets the candidate sequence by FM, then select roles \nby the max similarity between the current selected role and the \ndefault role set until the UPA is entire covered. \n">
    //    1    3:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of similarity of roleset for WSC. (default = ")).append(w).append(")").toString();
    //    0    0:new             #193 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #313 <String "\tRequired weight of similarity of roleset for WSC. (default = ">
    //    3    7:invokespecial   #198 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #80  <Field double w>
    //    6   14:invokevirtual   #316 <Method StringBuilder StringBuilder.append(double)>
    //    7   17:ldc2            #318 <String ")">
    //    8   20:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        FastVector newVector = new FastVector(1);
    //   11   27:new             #320 <Class FastVector>
    //   12   30:dup             
    //   13   31:iconst_1        
    //   14   32:invokespecial   #322 <Method void FastVector(int)>
    //   15   35:astore_2        
        newVector.addElement(new Option(string1, "W", 1, "-W <required similarity of roleset of role>"));
    //   16   36:aload_2         
    //   17   37:new             #324 <Class Option>
    //   18   40:dup             
    //   19   41:aload_1         
    //   20   42:ldc2            #326 <String "W">
    //   21   45:iconst_1        
    //   22   46:ldc2            #328 <String "-W <required similarity of roleset of role>">
    //   23   49:invokespecial   #331 <Method void Option(String, String, int, String)>
    //   24   52:invokevirtual   #335 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   25   55:aload_2         
    //   26   56:invokevirtual   #338 <Method Enumeration FastVector.elements()>
    //   27   59:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #29  <Method void resetOptions()>
        String s_wr = Utils.getOption('W', options);
    //    2    4:bipush          87
    //    3    6:aload_1         
    //    4    7:invokestatic    #350 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #353 <Method int String.length()>
    //*   8   15:ifeq            26
            w = Double.parseDouble(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #359 <Method double Double.parseDouble(String)>
    //   12   23:putfield        #80  <Field double w>
    //   13   26:return          
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
        options[current++] = "-W";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #366 <String "-W">
    //    9   16:aastore         
        for(options[current++] = (new StringBuilder()).append(w).toString(); current < options.length; options[current++] = "");
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #193 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #367 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #80  <Field double w>
    //   18   33:invokevirtual   #316 <Method StringBuilder StringBuilder.append(double)>
    //   19   36:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   20   39:aastore         
    //   21   40:goto            52
    //   22   43:aload_1         
    //   23   44:iload_2         
    //   24   45:iinc            2  1
    //   25   48:ldc2            #369 <String "">
    //   26   51:aastore         
    //   27   52:iload_2         
    //   28   53:aload_1         
    //   29   54:arraylength     
    //   30   55:icmplt          43
        return options;
    //   31   58:aload_1         
    //   32   59:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #270 <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #373 <Method void Assignment()>
    //    4    8:putfield        #376 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #376 <Field Assignment m_assroles>
    //    7   15:ldc2            #378 <String "role-permission">
    //    8   18:invokevirtual   #381 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(numberOfRoles, permissions.size(), (byte)0);
    //    9   21:new             #276 <Class Matrix>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:getfield        #179 <Field int numberOfRoles>
    //   13   29:aload_0         
    //   14   30:getfield        #216 <Field Vector permissions>
    //   15   33:invokevirtual   #87  <Method int Vector.size()>
    //   16   36:iconst_0        
    //   17   37:invokespecial   #384 <Method void Matrix(int, int, byte)>
    //   18   40:astore_1        
        for(int i = 0; i < numberOfRoles; i++)
    //*  19   41:iconst_0        
    //*  20   42:istore_2        
    //*  21   43:goto            105
        {
            Vector upi = ((Role)roles.get(i)).getIndexOfPerms();
    //   22   46:aload_0         
    //   23   47:getfield        #24  <Field Vector roles>
    //   24   50:iload_2         
    //   25   51:invokevirtual   #66  <Method Object Vector.get(int)>
    //   26   54:checkcast       #58  <Class MinimalPerturbation$Role>
    //   27   57:invokevirtual   #213 <Method Vector MinimalPerturbation$Role.getIndexOfPerms()>
    //   28   60:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            90
                if(upi.contains(Integer.valueOf(j)))
    //*  32   67:aload_3         
    //*  33   68:iload           4
    //*  34   70:invokestatic    #262 <Method Integer Integer.valueOf(int)>
    //*  35   73:invokevirtual   #265 <Method boolean Vector.contains(Object)>
    //*  36   76:ifeq            87
                    mat.set(i, j, (byte)1);
    //   37   79:aload_1         
    //   38   80:iload_2         
    //   39   81:iload           4
    //   40   83:iconst_1        
    //   41   84:invokevirtual   #387 <Method void Matrix.set(int, int, byte)>

    //   42   87:iinc            4  1
    //   43   90:iload           4
    //   44   92:aload_0         
    //   45   93:getfield        #216 <Field Vector permissions>
    //   46   96:invokevirtual   #87  <Method int Vector.size()>
    //   47   99:icmplt          67
        }

    //   48  102:iinc            2  1
    //   49  105:iload_2         
    //   50  106:aload_0         
    //   51  107:getfield        #179 <Field int numberOfRoles>
    //   52  110:icmplt          46
        m_assroles.setAssignmentMatrix(mat);
    //   53  113:aload_0         
    //   54  114:getfield        #376 <Field Assignment m_assroles>
    //   55  117:aload_1         
    //   56  118:invokevirtual   #391 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   57  121:new             #320 <Class FastVector>
    //   58  124:dup             
    //   59  125:invokespecial   #392 <Method void FastVector()>
    //   60  128:astore_2        
        for(int i = 0; i < numberOfRoles; i++)
    //*  61  129:iconst_0        
    //*  62  130:istore_3        
    //*  63  131:goto            158
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   64  134:aload_2         
    //   65  135:new             #193 <Class StringBuilder>
    //   66  138:dup             
    //   67  139:ldc2            #394 <String "R">
    //   68  142:invokespecial   #198 <Method void StringBuilder(String)>
    //   69  145:iload_3         
    //   70  146:invokevirtual   #201 <Method StringBuilder StringBuilder.append(int)>
    //   71  149:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   72  152:invokevirtual   #335 <Method void FastVector.addElement(Object)>

    //   73  155:iinc            3  1
    //   74  158:iload_3         
    //   75  159:aload_0         
    //   76  160:getfield        #179 <Field int numberOfRoles>
    //   77  163:icmplt          134
        Attribute dxa = new Attribute("role", fv);
    //   78  166:new             #396 <Class Attribute>
    //   79  169:dup             
    //   80  170:ldc2            #397 <String "role">
    //   81  173:aload_2         
    //   82  174:invokespecial   #400 <Method void Attribute(String, FastVector)>
    //   83  177:astore_3        
        Dimension dx = new Dimension();
    //   84  178:new             #402 <Class Dimension>
    //   85  181:dup             
    //   86  182:invokespecial   #403 <Method void Dimension()>
    //   87  185:astore          4
        dx.setDimensionAttribute(dxa);
    //   88  187:aload           4
    //   89  189:aload_3         
    //   90  190:invokevirtual   #407 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   91  193:aload_0         
    //   92  194:getfield        #376 <Field Assignment m_assroles>
    //   93  197:aload           4
    //   94  199:invokevirtual   #411 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   95  202:aload_0         
    //   96  203:getfield        #414 <Field Assignment m_assignment>
    //   97  206:invokevirtual   #418 <Method Dimension Assignment.getDimensionY()>
    //   98  209:invokevirtual   #422 <Method Attribute Dimension.getDimensionAttribute()>
    //   99  212:astore          5
        Dimension dy = new Dimension();
    //  100  214:new             #402 <Class Dimension>
    //  101  217:dup             
    //  102  218:invokespecial   #403 <Method void Dimension()>
    //  103  221:astore          6
        dy.setDimensionAttribute(dya);
    //  104  223:aload           6
    //  105  225:aload           5
    //  106  227:invokevirtual   #407 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  107  230:aload_0         
    //  108  231:getfield        #376 <Field Assignment m_assroles>
    //  109  234:aload           6
    //  110  236:invokevirtual   #425 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  111  239:aload_0         
    //  112  240:getfield        #376 <Field Assignment m_assroles>
    //  113  243:areturn         
    }

    public double getW()
    {
        return w;
    //    0    0:aload_0         
    //    1    1:getfield        #80  <Field double w>
    //    2    4:dreturn         
    }

    public void setW(double w)
    {
        this.w = w;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #80  <Field double w>
    //    3    5:return          
    }

    public String wwTipText()
    {
        return "The required weight of similarity of roleset for WSC.";
    //    0    0:ldc2            #442 <String "The required weight of similarity of roleset for WSC.">
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
    //    2    2:new             #445 <Class File>
    //    3    5:dup             
    //    4    6:new             #193 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc2            #447 <String "user.dir">
    //    7   13:invokestatic    #453 <Method String System.getProperty(String)>
    //    8   16:invokestatic    #227 <Method String String.valueOf(Object)>
    //    9   19:invokespecial   #198 <Method void StringBuilder(String)>
    //   10   22:ldc2            #455 <String "\\datasets\\orca_user_permission.ass">
    //   11   25:invokevirtual   #206 <Method StringBuilder StringBuilder.append(String)>
    //   12   28:invokevirtual   #210 <Method String StringBuilder.toString()>
    //   13   31:invokespecial   #456 <Method void File(String)>
    //   14   34:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   35:new             #458 <Class AssLoader>
    //   16   38:dup             
    //   17   39:new             #460 <Class FileReader>
    //   18   42:dup             
    //   19   43:aload_2         
    //   20   44:invokespecial   #463 <Method void FileReader(File)>
    //   21   47:invokespecial   #466 <Method void AssLoader(FileReader)>
    //   22   50:astore_3        
            Ass = AL.getData();
    //   23   51:aload_3         
    //   24   52:invokevirtual   #469 <Method Assignment AssLoader.getData()>
    //   25   55:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   56:getstatic       #473 <Field PrintStream System.out>
    //   27   59:aload_1         
    //   28   60:invokevirtual   #476 <Method String Assignment.getAssignementName()>
    //   29   63:invokevirtual   #481 <Method void PrintStream.println(String)>
            MinimalPerturbation rmp = new MinimalPerturbation();
    //   30   66:new             #2   <Class MinimalPerturbation>
    //   31   69:dup             
    //   32   70:invokespecial   #482 <Method void MinimalPerturbation()>
    //   33   73:astore          4
            rmp.buildRoleminers(Ass);
    //   34   75:aload           4
    //   35   77:aload_1         
    //   36   78:invokevirtual   #483 <Method void buildRoleminers(Assignment)>
            System.out.println(rmp.toString());
    //   37   81:getstatic       #473 <Field PrintStream System.out>
    //   38   84:aload           4
    //   39   86:invokevirtual   #484 <Method String toString()>
    //   40   89:invokevirtual   #481 <Method void PrintStream.println(String)>
            System.out.println(rmp.generateRoles());
    //   41   92:getstatic       #473 <Field PrintStream System.out>
    //   42   95:aload           4
    //   43   97:invokevirtual   #486 <Method Assignment generateRoles()>
    //   44  100:invokevirtual   #488 <Method void PrintStream.println(Object)>
        }
    //*  45  103:goto            111
        catch(Exception e)
    //*  46  106:astore_2        
        {
            e.printStackTrace();
    //   47  107:aload_2         
    //   48  108:invokevirtual   #491 <Method void Exception.printStackTrace()>
        }
    //   49  111:return          
    }

    private Vector droles;
    private Vector roles;
    private Vector allroles;
    private double w;
}

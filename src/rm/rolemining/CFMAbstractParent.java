// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CFMAbstractParent.java

package rm.rolemining;

import java.util.*;
import rm.core.*;

// Referenced classes of package rm.rolemining:
//            AbstractRoleminer

public abstract class CFMAbstractParent extends AbstractRoleminer
    implements OptionHandler
{
    public class GenRoleToCounts
    {

        public int getCounts()
        {
            return counts;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field int counts>
        //    2    4:ireturn         
        }

        public void setCounts(int counts)
        {
            this.counts = counts;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #29  <Field int counts>
        //    3    5:return          
        }

        public Vector getInitRole()
        {
            return InitRole;
        //    0    0:aload_0         
        //    1    1:getfield        #36  <Field Vector InitRole>
        //    2    4:areturn         
        }

        public void setInitRole(Vector initRole)
        {
            InitRole = initRole;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #36  <Field Vector InitRole>
        //    3    5:return          
        }

        public Vector getUseList()
        {
            return useList;
        //    0    0:aload_0         
        //    1    1:getfield        #44  <Field Vector useList>
        //    2    4:areturn         
        }

        public void setUseList(Vector useList)
        {
            this.useList = useList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #44  <Field Vector useList>
        //    3    5:return          
        }

        private Vector InitRole;
        private Vector useList;
        private int counts;
        final CFMAbstractParent this$0;

        public GenRoleToCounts()
        {
            this$0 = CFMAbstractParent.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field CFMAbstractParent this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }

    public class InitRoleToCounts
    {

        public int getCounts()
        {
            return counts;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field int counts>
        //    2    4:ireturn         
        }

        public void setCounts(int counts)
        {
            this.counts = counts;
        //    0    0:aload_0         
        //    1    1:iload_1         
        //    2    2:putfield        #29  <Field int counts>
        //    3    5:return          
        }

        public Vector getInitRole()
        {
            return InitRole;
        //    0    0:aload_0         
        //    1    1:getfield        #36  <Field Vector InitRole>
        //    2    4:areturn         
        }

        public void setInitRole(Vector initRole)
        {
            InitRole = initRole;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #36  <Field Vector InitRole>
        //    3    5:return          
        }

        public Vector getUseList()
        {
            return useList;
        //    0    0:aload_0         
        //    1    1:getfield        #44  <Field Vector useList>
        //    2    4:areturn         
        }

        public void setUseList(Vector useList)
        {
            this.useList = useList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #44  <Field Vector useList>
        //    3    5:return          
        }

        private Vector InitRole;
        private Vector useList;
        private int counts;
        final CFMAbstractParent this$0;

        public InitRoleToCounts()
        {
            this$0 = CFMAbstractParent.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #18  <Field CFMAbstractParent this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #21  <Method void Object()>
        //    5    9:return          
        }
    }

    public class Role
        implements Comparable
    {

        public int compareTo(Object o)
        {
            Role other = (Role)o;
        //    0    0:aload_1         
        //    1    1:checkcast       #2   <Class CFMAbstractParent$Role>
        //    2    4:astore_2        
            if(priority < other.priority)
        //*   3    5:aload_0         
        //*   4    6:getfield        #31  <Field double priority>
        //*   5    9:aload_2         
        //*   6   10:getfield        #31  <Field double priority>
        //*   7   13:dcmpg           
        //*   8   14:ifge            19
                return 1;
        //    9   17:iconst_1        
        //   10   18:ireturn         
            return priority != other.priority ? -1 : 0;
        //   11   19:aload_0         
        //   12   20:getfield        #31  <Field double priority>
        //   13   23:aload_2         
        //   14   24:getfield        #31  <Field double priority>
        //   15   27:dcmpl           
        //   16   28:ifne            33
        //   17   31:iconst_0        
        //   18   32:ireturn         
        //   19   33:iconst_m1       
        //   20   34:ireturn         
        }

        public Vector getPermissionList()
        {
            return permissionList;
        //    0    0:aload_0         
        //    1    1:getfield        #39  <Field Vector permissionList>
        //    2    4:areturn         
        }

        public void setPermissionList(Vector permissionList)
        {
            this.permissionList = permissionList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #39  <Field Vector permissionList>
        //    3    5:return          
        }

        public double getPriority()
        {
            return priority;
        //    0    0:aload_0         
        //    1    1:getfield        #31  <Field double priority>
        //    2    4:dreturn         
        }

        public void setPriority(double priority)
        {
            this.priority = priority;
        //    0    0:aload_0         
        //    1    1:dload_1         
        //    2    2:putfield        #31  <Field double priority>
        //    3    5:return          
        }

        public Vector getUseList()
        {
            return useList;
        //    0    0:aload_0         
        //    1    1:getfield        #50  <Field Vector useList>
        //    2    4:areturn         
        }

        public void setUseList(Vector useList)
        {
            this.useList = useList;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #50  <Field Vector useList>
        //    3    5:return          
        }

        private Vector permissionList;
        private Vector useList;
        private double priority;
        final CFMAbstractParent this$0;

        public Role()
        {
            this$0 = CFMAbstractParent.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #20  <Field CFMAbstractParent this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #23  <Method void Object()>
        //    5    9:return          
        }
    }


    public CFMAbstractParent()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #31  <Method void AbstractRoleminer()>
        InitRoles = new Vector();
    //    2    4:aload_0         
    //    3    5:new             #33  <Class Vector>
    //    4    8:dup             
    //    5    9:invokespecial   #34  <Method void Vector()>
    //    6   12:putfield        #36  <Field Vector InitRoles>
        GenRoles = new Vector();
    //    7   15:aload_0         
    //    8   16:new             #33  <Class Vector>
    //    9   19:dup             
    //   10   20:invokespecial   #34  <Method void Vector()>
    //   11   23:putfield        #38  <Field Vector GenRoles>
        permissions = new Vector();
    //   12   26:aload_0         
    //   13   27:new             #33  <Class Vector>
    //   14   30:dup             
    //   15   31:invokespecial   #34  <Method void Vector()>
    //   16   34:putfield        #40  <Field Vector permissions>
        users = new Vector();
    //   17   37:aload_0         
    //   18   38:new             #33  <Class Vector>
    //   19   41:dup             
    //   20   42:invokespecial   #34  <Method void Vector()>
    //   21   45:putfield        #42  <Field Vector users>
        numberOfRoles = 0;
    //   22   48:aload_0         
    //   23   49:iconst_0        
    //   24   50:putfield        #44  <Field int numberOfRoles>
        log = new StringBuffer();
    //   25   53:aload_0         
    //   26   54:new             #46  <Class StringBuffer>
    //   27   57:dup             
    //   28   58:invokespecial   #47  <Method void StringBuffer()>
    //   29   61:putfield        #49  <Field StringBuffer log>
        allroleSet = new Vector();
    //   30   64:aload_0         
    //   31   65:new             #33  <Class Vector>
    //   32   68:dup             
    //   33   69:invokespecial   #34  <Method void Vector()>
    //   34   72:putfield        #51  <Field Vector allroleSet>
        resetOptions();
    //   35   75:aload_0         
    //   36   76:invokevirtual   #54  <Method void resetOptions()>
    //   37   79:return          
    }

    protected abstract int GenRoleshasSomePermissionSet(Vector vector);

    protected abstract void initialGenRoles(Assignment assignment);

    protected void RoleRecommendation(Assignment data)
    {
        initAllRoles();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #67  <Method void initAllRoles()>
        calculateRolePriorityandSort(data);
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #70  <Method void calculateRolePriorityandSort(Assignment)>
    //    5    9:return          
    }

    protected void calculateRolePriorityandSort(Assignment data)
    {
        Matrix mat = data.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #77  <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        Role role;
        double pri;
        for(Iterator iterator = allroleSet.iterator(); iterator.hasNext(); role.setPriority(pri))
    //*   3    5:aload_0         
    //*   4    6:getfield        #51  <Field Vector allroleSet>
    //*   5    9:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*   6   12:astore          4
    //*   7   14:goto            161
        {
            role = (Role)iterator.next();
    //    8   17:aload           4
    //    9   19:invokeinterface #87  <Method Object Iterator.next()>
    //   10   24:checkcast       #89  <Class CFMAbstractParent$Role>
    //   11   27:astore_3        
            double er = 0.0D;
    //   12   28:dconst_0        
    //   13   29:dstore          5
            double nr = 0.0D;
    //   14   31:dconst_0        
    //   15   32:dstore          7
            for(int index = 0; index < mat.getRowDimension(); index++)
    //*  16   34:iconst_0        
    //*  17   35:istore          9
    //*  18   37:goto            134
            {
                Vector permList = new Vector();
    //   19   40:new             #33  <Class Vector>
    //   20   43:dup             
    //   21   44:invokespecial   #34  <Method void Vector()>
    //   22   47:astore          10
                for(int jndex = 0; jndex < mat.getColumnDimension(); jndex++)
    //*  23   49:iconst_0        
    //*  24   50:istore          11
    //*  25   52:goto            81
                    if(1 == mat.get(index, jndex))
    //*  26   55:iconst_1        
    //*  27   56:aload_2         
    //*  28   57:iload           9
    //*  29   59:iload           11
    //*  30   61:invokevirtual   #95  <Method byte Matrix.get(int, int)>
    //*  31   64:icmpne          78
                        permList.add(Integer.valueOf(jndex));
    //   32   67:aload           10
    //   33   69:iload           11
    //   34   71:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //   35   74:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   36   77:pop             

    //   37   78:iinc            11  1
    //   38   81:iload           11
    //   39   83:aload_2         
    //   40   84:invokevirtual   #109 <Method int Matrix.getColumnDimension()>
    //   41   87:icmplt          55
                if(exactlyEqual(permList, role.getPermissionList()))
    //*  42   90:aload_0         
    //*  43   91:aload           10
    //*  44   93:aload_3         
    //*  45   94:invokevirtual   #113 <Method Vector CFMAbstractParent$Role.getPermissionList()>
    //*  46   97:invokevirtual   #117 <Method boolean exactlyEqual(Vector, Vector)>
    //*  47  100:ifeq            112
                    er++;
    //   48  103:dload           5
    //   49  105:dconst_1        
    //   50  106:dadd            
    //   51  107:dstore          5
                else
    //*  52  109:goto            131
                if(superSet(permList, role.getPermissionList()))
    //*  53  112:aload_0         
    //*  54  113:aload           10
    //*  55  115:aload_3         
    //*  56  116:invokevirtual   #113 <Method Vector CFMAbstractParent$Role.getPermissionList()>
    //*  57  119:invokevirtual   #120 <Method boolean superSet(Vector, Vector)>
    //*  58  122:ifeq            131
                    nr++;
    //   59  125:dload           7
    //   60  127:dconst_1        
    //   61  128:dadd            
    //   62  129:dstore          7
            }

    //   63  131:iinc            9  1
    //   64  134:iload           9
    //   65  136:aload_2         
    //   66  137:invokevirtual   #123 <Method int Matrix.getRowDimension()>
    //   67  140:icmplt          40
            pri = er * a + nr;
    //   68  143:dload           5
    //   69  145:aload_0         
    //   70  146:getfield        #125 <Field double a>
    //   71  149:dmul            
    //   72  150:dload           7
    //   73  152:dadd            
    //   74  153:dstore          9
        }

    //   75  155:aload_3         
    //   76  156:dload           9
    //   77  158:invokevirtual   #129 <Method void CFMAbstractParent$Role.setPriority(double)>
    //   78  161:aload           4
    //   79  163:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   80  168:ifne            17
        Collections.sort(allroleSet);
    //   81  171:aload_0         
    //   82  172:getfield        #51  <Field Vector allroleSet>
    //   83  175:invokestatic    #139 <Method void Collections.sort(java.util.List)>
    //   84  178:return          
    }

    protected boolean superSet(Vector permList, Vector permissionList)
    {
        if(permList.size() <= permissionList.size())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #155 <Method int Vector.size()>
    //*   2    4:aload_2         
    //*   3    5:invokevirtual   #155 <Method int Vector.size()>
    //*   4    8:icmpgt          13
            return false;
    //    5   11:iconst_0        
    //    6   12:ireturn         
        for(Iterator iterator = permissionList.iterator(); iterator.hasNext();)
    //*   7   13:aload_2         
    //*   8   14:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*   9   17:astore          4
    //*  10   19:goto            49
        {
            int two = ((Integer)iterator.next()).intValue();
    //   11   22:aload           4
    //   12   24:invokeinterface #87  <Method Object Iterator.next()>
    //   13   29:checkcast       #97  <Class Integer>
    //   14   32:invokevirtual   #158 <Method int Integer.intValue()>
    //   15   35:istore_3        
            if(!permList.contains(Integer.valueOf(two)))
    //*  16   36:aload_1         
    //*  17   37:iload_3         
    //*  18   38:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //*  19   41:invokevirtual   #161 <Method boolean Vector.contains(Object)>
    //*  20   44:ifne            49
                return false;
    //   21   47:iconst_0        
    //   22   48:ireturn         
        }

    //   23   49:aload           4
    //   24   51:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   25   56:ifne            22
        return true;
    //   26   59:iconst_1        
    //   27   60:ireturn         
    }

    protected boolean exactlyEqual(Vector permList, Vector permissionList)
    {
        if(permList.size() != permissionList.size())
    //*   0    0:aload_1         
    //*   1    1:invokevirtual   #155 <Method int Vector.size()>
    //*   2    4:aload_2         
    //*   3    5:invokevirtual   #155 <Method int Vector.size()>
    //*   4    8:icmpeq          13
            return false;
    //    5   11:iconst_0        
    //    6   12:ireturn         
        for(Iterator iterator = permList.iterator(); iterator.hasNext();)
    //*   7   13:aload_1         
    //*   8   14:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*   9   17:astore          4
    //*  10   19:goto            49
        {
            int one = ((Integer)iterator.next()).intValue();
    //   11   22:aload           4
    //   12   24:invokeinterface #87  <Method Object Iterator.next()>
    //   13   29:checkcast       #97  <Class Integer>
    //   14   32:invokevirtual   #158 <Method int Integer.intValue()>
    //   15   35:istore_3        
            if(!permissionList.contains(Integer.valueOf(one)))
    //*  16   36:aload_2         
    //*  17   37:iload_3         
    //*  18   38:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //*  19   41:invokevirtual   #161 <Method boolean Vector.contains(Object)>
    //*  20   44:ifne            49
                return false;
    //   21   47:iconst_0        
    //   22   48:ireturn         
        }

    //   23   49:aload           4
    //   24   51:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   25   56:ifne            22
        for(Iterator iterator1 = permissionList.iterator(); iterator1.hasNext();)
    //*  26   59:aload_2         
    //*  27   60:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*  28   63:astore          4
    //*  29   65:goto            95
        {
            int two = ((Integer)iterator1.next()).intValue();
    //   30   68:aload           4
    //   31   70:invokeinterface #87  <Method Object Iterator.next()>
    //   32   75:checkcast       #97  <Class Integer>
    //   33   78:invokevirtual   #158 <Method int Integer.intValue()>
    //   34   81:istore_3        
            if(!permList.contains(Integer.valueOf(two)))
    //*  35   82:aload_1         
    //*  36   83:iload_3         
    //*  37   84:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //*  38   87:invokevirtual   #161 <Method boolean Vector.contains(Object)>
    //*  39   90:ifne            95
                return false;
    //   40   93:iconst_0        
    //   41   94:ireturn         
        }

    //   42   95:aload           4
    //   43   97:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   44  102:ifne            68
        return true;
    //   45  105:iconst_1        
    //   46  106:ireturn         
    }

    protected void initAllRoles()
    {
        Role role;
        for(Iterator iterator = GenRoles.iterator(); iterator.hasNext(); allroleSet.add(role))
    //*   0    0:aload_0         
    //*   1    1:getfield        #38  <Field Vector GenRoles>
    //*   2    4:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*   3    7:astore_2        
    //*   4    8:goto            61
        {
            GenRoleToCounts genRole = (GenRoleToCounts)iterator.next();
    //    5   11:aload_2         
    //    6   12:invokeinterface #87  <Method Object Iterator.next()>
    //    7   17:checkcast       #166 <Class CFMAbstractParent$GenRoleToCounts>
    //    8   20:astore_1        
            role = new Role();
    //    9   21:new             #89  <Class CFMAbstractParent$Role>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:invokespecial   #169 <Method void CFMAbstractParent$Role(CFMAbstractParent)>
    //   13   29:astore_3        
            role.setPermissionList((Vector)genRole.getInitRole().clone());
    //   14   30:aload_3         
    //   15   31:aload_1         
    //   16   32:invokevirtual   #172 <Method Vector CFMAbstractParent$GenRoleToCounts.getInitRole()>
    //   17   35:invokevirtual   #175 <Method Object Vector.clone()>
    //   18   38:checkcast       #33  <Class Vector>
    //   19   41:invokevirtual   #179 <Method void CFMAbstractParent$Role.setPermissionList(Vector)>
            role.setUseList(genRole.getUseList());
    //   20   44:aload_3         
    //   21   45:aload_1         
    //   22   46:invokevirtual   #182 <Method Vector CFMAbstractParent$GenRoleToCounts.getUseList()>
    //   23   49:invokevirtual   #185 <Method void CFMAbstractParent$Role.setUseList(Vector)>
        }

    //   24   52:aload_0         
    //   25   53:getfield        #51  <Field Vector allroleSet>
    //   26   56:aload_3         
    //   27   57:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   28   60:pop             
    //   29   61:aload_2         
    //   30   62:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   31   67:ifne            11
        Role role;
        for(Iterator iterator1 = InitRoles.iterator(); iterator1.hasNext(); allroleSet.add(role))
    //*  32   70:aload_0         
    //*  33   71:getfield        #36  <Field Vector InitRoles>
    //*  34   74:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*  35   77:astore_2        
    //*  36   78:goto            131
        {
            InitRoleToCounts inToRole = (InitRoleToCounts)iterator1.next();
    //   37   81:aload_2         
    //   38   82:invokeinterface #87  <Method Object Iterator.next()>
    //   39   87:checkcast       #187 <Class CFMAbstractParent$InitRoleToCounts>
    //   40   90:astore_1        
            role = new Role();
    //   41   91:new             #89  <Class CFMAbstractParent$Role>
    //   42   94:dup             
    //   43   95:aload_0         
    //   44   96:invokespecial   #169 <Method void CFMAbstractParent$Role(CFMAbstractParent)>
    //   45   99:astore_3        
            role.setPermissionList((Vector)inToRole.getInitRole().clone());
    //   46  100:aload_3         
    //   47  101:aload_1         
    //   48  102:invokevirtual   #188 <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   49  105:invokevirtual   #175 <Method Object Vector.clone()>
    //   50  108:checkcast       #33  <Class Vector>
    //   51  111:invokevirtual   #179 <Method void CFMAbstractParent$Role.setPermissionList(Vector)>
            role.setUseList(inToRole.getUseList());
    //   52  114:aload_3         
    //   53  115:aload_1         
    //   54  116:invokevirtual   #189 <Method Vector CFMAbstractParent$InitRoleToCounts.getUseList()>
    //   55  119:invokevirtual   #185 <Method void CFMAbstractParent$Role.setUseList(Vector)>
        }

    //   56  122:aload_0         
    //   57  123:getfield        #51  <Field Vector allroleSet>
    //   58  126:aload_3         
    //   59  127:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   60  130:pop             
    //   61  131:aload_2         
    //   62  132:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   63  137:ifne            81
    //   64  140:return          
    }

    protected void CalculateNumbersOfRoles()
    {
        log.append("\n--------------------------------------------------------\n");
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field StringBuffer log>
    //    2    4:ldc1            #196 <String "\n--------------------------------------------------------\n">
    //    3    6:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //    4    9:pop             
        Role role;
        for(Iterator iterator = allroleSet.iterator(); iterator.hasNext(); log.append((new StringBuilder("The weight of role is\uFF1A")).append(role.getPriority()).append("\n").toString()))
    //*   5   10:aload_0         
    //*   6   11:getfield        #51  <Field Vector allroleSet>
    //*   7   14:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*   8   17:astore_2        
    //*   9   18:goto            354
        {
            role = (Role)iterator.next();
    //   10   21:aload_2         
    //   11   22:invokeinterface #87  <Method Object Iterator.next()>
    //   12   27:checkcast       #89  <Class CFMAbstractParent$Role>
    //   13   30:astore_1        
            log.append("The permissions of role are\uFF1A\n");
    //   14   31:aload_0         
    //   15   32:getfield        #49  <Field StringBuffer log>
    //   16   35:ldc1            #202 <String "The permissions of role are\uFF1A\n">
    //   17   37:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //   18   40:pop             
            Vector permSet = role.getPermissionList();
    //   19   41:aload_1         
    //   20   42:invokevirtual   #113 <Method Vector CFMAbstractParent$Role.getPermissionList()>
    //   21   45:astore_3        
            for(int index = 0; index < permSet.size(); index++)
    //*  22   46:iconst_0        
    //*  23   47:istore          4
    //*  24   49:goto            165
                if(index != permSet.size() - 1)
    //*  25   52:iload           4
    //*  26   54:aload_3         
    //*  27   55:invokevirtual   #155 <Method int Vector.size()>
    //*  28   58:iconst_1        
    //*  29   59:isub            
    //*  30   60:icmpeq          114
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)permSet.get(index)).intValue())))).append(",").toString());
    //   31   63:aload_0         
    //   32   64:getfield        #49  <Field StringBuffer log>
    //   33   67:new             #204 <Class StringBuilder>
    //   34   70:dup             
    //   35   71:aload_0         
    //   36   72:getfield        #40  <Field Vector permissions>
    //   37   75:aload_3         
    //   38   76:iload           4
    //   39   78:invokevirtual   #207 <Method Object Vector.get(int)>
    //   40   81:checkcast       #97  <Class Integer>
    //   41   84:invokevirtual   #158 <Method int Integer.intValue()>
    //   42   87:invokevirtual   #207 <Method Object Vector.get(int)>
    //   43   90:checkcast       #209 <Class String>
    //   44   93:invokestatic    #212 <Method String String.valueOf(Object)>
    //   45   96:invokespecial   #215 <Method void StringBuilder(String)>
    //   46   99:ldc1            #217 <String ",">
    //   47  101:invokevirtual   #220 <Method StringBuilder StringBuilder.append(String)>
    //   48  104:invokevirtual   #224 <Method String StringBuilder.toString()>
    //   49  107:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //   50  110:pop             
                else
    //*  51  111:goto            162
                    log.append((new StringBuilder(String.valueOf((String)permissions.get(((Integer)permSet.get(index)).intValue())))).append("\n").toString());
    //   52  114:aload_0         
    //   53  115:getfield        #49  <Field StringBuffer log>
    //   54  118:new             #204 <Class StringBuilder>
    //   55  121:dup             
    //   56  122:aload_0         
    //   57  123:getfield        #40  <Field Vector permissions>
    //   58  126:aload_3         
    //   59  127:iload           4
    //   60  129:invokevirtual   #207 <Method Object Vector.get(int)>
    //   61  132:checkcast       #97  <Class Integer>
    //   62  135:invokevirtual   #158 <Method int Integer.intValue()>
    //   63  138:invokevirtual   #207 <Method Object Vector.get(int)>
    //   64  141:checkcast       #209 <Class String>
    //   65  144:invokestatic    #212 <Method String String.valueOf(Object)>
    //   66  147:invokespecial   #215 <Method void StringBuilder(String)>
    //   67  150:ldc1            #226 <String "\n">
    //   68  152:invokevirtual   #220 <Method StringBuilder StringBuilder.append(String)>
    //   69  155:invokevirtual   #224 <Method String StringBuilder.toString()>
    //   70  158:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //   71  161:pop             

    //   72  162:iinc            4  1
    //   73  165:iload           4
    //   74  167:aload_3         
    //   75  168:invokevirtual   #155 <Method int Vector.size()>
    //   76  171:icmplt          52
            log.append("The users of role are\uFF1A");
    //   77  174:aload_0         
    //   78  175:getfield        #49  <Field StringBuffer log>
    //   79  178:ldc1            #228 <String "The users of role are\uFF1A">
    //   80  180:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //   81  183:pop             
            Vector userSet = role.getUseList();
    //   82  184:aload_1         
    //   83  185:invokevirtual   #229 <Method Vector CFMAbstractParent$Role.getUseList()>
    //   84  188:astore          4
            for(int index = 0; index < userSet.size(); index++)
    //*  85  190:iconst_0        
    //*  86  191:istore          5
    //*  87  193:goto            312
                if(index != userSet.size() - 1)
    //*  88  196:iload           5
    //*  89  198:aload           4
    //*  90  200:invokevirtual   #155 <Method int Vector.size()>
    //*  91  203:iconst_1        
    //*  92  204:isub            
    //*  93  205:icmpeq          260
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)userSet.get(index)).intValue())))).append(",").toString());
    //   94  208:aload_0         
    //   95  209:getfield        #49  <Field StringBuffer log>
    //   96  212:new             #204 <Class StringBuilder>
    //   97  215:dup             
    //   98  216:aload_0         
    //   99  217:getfield        #42  <Field Vector users>
    //  100  220:aload           4
    //  101  222:iload           5
    //  102  224:invokevirtual   #207 <Method Object Vector.get(int)>
    //  103  227:checkcast       #97  <Class Integer>
    //  104  230:invokevirtual   #158 <Method int Integer.intValue()>
    //  105  233:invokevirtual   #207 <Method Object Vector.get(int)>
    //  106  236:checkcast       #209 <Class String>
    //  107  239:invokestatic    #212 <Method String String.valueOf(Object)>
    //  108  242:invokespecial   #215 <Method void StringBuilder(String)>
    //  109  245:ldc1            #217 <String ",">
    //  110  247:invokevirtual   #220 <Method StringBuilder StringBuilder.append(String)>
    //  111  250:invokevirtual   #224 <Method String StringBuilder.toString()>
    //  112  253:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //  113  256:pop             
                else
    //* 114  257:goto            309
                    log.append((new StringBuilder(String.valueOf((String)users.get(((Integer)userSet.get(index)).intValue())))).append("\n").toString());
    //  115  260:aload_0         
    //  116  261:getfield        #49  <Field StringBuffer log>
    //  117  264:new             #204 <Class StringBuilder>
    //  118  267:dup             
    //  119  268:aload_0         
    //  120  269:getfield        #42  <Field Vector users>
    //  121  272:aload           4
    //  122  274:iload           5
    //  123  276:invokevirtual   #207 <Method Object Vector.get(int)>
    //  124  279:checkcast       #97  <Class Integer>
    //  125  282:invokevirtual   #158 <Method int Integer.intValue()>
    //  126  285:invokevirtual   #207 <Method Object Vector.get(int)>
    //  127  288:checkcast       #209 <Class String>
    //  128  291:invokestatic    #212 <Method String String.valueOf(Object)>
    //  129  294:invokespecial   #215 <Method void StringBuilder(String)>
    //  130  297:ldc1            #226 <String "\n">
    //  131  299:invokevirtual   #220 <Method StringBuilder StringBuilder.append(String)>
    //  132  302:invokevirtual   #224 <Method String StringBuilder.toString()>
    //  133  305:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //  134  308:pop             

    //  135  309:iinc            5  1
    //  136  312:iload           5
    //  137  314:aload           4
    //  138  316:invokevirtual   #155 <Method int Vector.size()>
    //  139  319:icmplt          196
        }

    //  140  322:aload_0         
    //  141  323:getfield        #49  <Field StringBuffer log>
    //  142  326:new             #204 <Class StringBuilder>
    //  143  329:dup             
    //  144  330:ldc1            #231 <String "The weight of role is\uFF1A">
    //  145  332:invokespecial   #215 <Method void StringBuilder(String)>
    //  146  335:aload_1         
    //  147  336:invokevirtual   #235 <Method double CFMAbstractParent$Role.getPriority()>
    //  148  339:invokevirtual   #238 <Method StringBuilder StringBuilder.append(double)>
    //  149  342:ldc1            #226 <String "\n">
    //  150  344:invokevirtual   #220 <Method StringBuilder StringBuilder.append(String)>
    //  151  347:invokevirtual   #224 <Method String StringBuilder.toString()>
    //  152  350:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //  153  353:pop             
    //  154  354:aload_2         
    //  155  355:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //  156  360:ifne            21
        log.append("\n--------------------------------------------------------\n");
    //  157  363:aload_0         
    //  158  364:getfield        #49  <Field StringBuffer log>
    //  159  367:ldc1            #196 <String "\n--------------------------------------------------------\n">
    //  160  369:invokevirtual   #200 <Method StringBuffer StringBuffer.append(String)>
    //  161  372:pop             
        numberOfRoles = InitRoles.size() + GenRoles.size();
    //  162  373:aload_0         
    //  163  374:aload_0         
    //  164  375:getfield        #36  <Field Vector InitRoles>
    //  165  378:invokevirtual   #155 <Method int Vector.size()>
    //  166  381:aload_0         
    //  167  382:getfield        #38  <Field Vector GenRoles>
    //  168  385:invokevirtual   #155 <Method int Vector.size()>
    //  169  388:iadd            
    //  170  389:putfield        #44  <Field int numberOfRoles>
    //  171  392:return          
    }

    protected void constructionInitialRole(Assignment Ass)
    {
        Matrix mat = Ass.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #77  <Method Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        Attribute usersAttr = Ass.getDimensionX().getDimensionAttribute();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #245 <Method Dimension Assignment.getDimensionX()>
    //    5    9:invokevirtual   #251 <Method Attribute Dimension.getDimensionAttribute()>
    //    6   12:astore_3        
        Attribute permissionsAttr = Ass.getDimensionY().getDimensionAttribute();
    //    7   13:aload_1         
    //    8   14:invokevirtual   #254 <Method Dimension Assignment.getDimensionY()>
    //    9   17:invokevirtual   #251 <Method Attribute Dimension.getDimensionAttribute()>
    //   10   20:astore          4
        initialPermissionsAndUsers(Ass);
    //   11   22:aload_0         
    //   12   23:aload_1         
    //   13   24:invokevirtual   #257 <Method void initialPermissionsAndUsers(Assignment)>
        initialInitRoles(mat);
    //   14   27:aload_0         
    //   15   28:aload_2         
    //   16   29:invokevirtual   #261 <Method void initialInitRoles(Matrix)>
    //   17   32:return          
    }

    protected void initialPermissionsAndUsers(Assignment Ass)
    {
        splitAttruteString(Ass.getDimensionY().getDimensionAttribute(), permissions);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #254 <Method Dimension Assignment.getDimensionY()>
    //    3    5:invokevirtual   #251 <Method Attribute Dimension.getDimensionAttribute()>
    //    4    8:aload_0         
    //    5    9:getfield        #40  <Field Vector permissions>
    //    6   12:invokevirtual   #269 <Method void splitAttruteString(Attribute, Vector)>
        splitAttruteString(Ass.getDimensionX().getDimensionAttribute(), users);
    //    7   15:aload_0         
    //    8   16:aload_1         
    //    9   17:invokevirtual   #245 <Method Dimension Assignment.getDimensionX()>
    //   10   20:invokevirtual   #251 <Method Attribute Dimension.getDimensionAttribute()>
    //   11   23:aload_0         
    //   12   24:getfield        #42  <Field Vector users>
    //   13   27:invokevirtual   #269 <Method void splitAttruteString(Attribute, Vector)>
    //   14   30:return          
    }

    protected void splitAttruteString(Attribute Attr, Vector set)
    {
        String perAttr = Attr.toString();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #273 <Method String Attribute.toString()>
    //    2    4:astore_3        
        int fristChar = perAttr.indexOf('{');
    //    3    5:aload_3         
    //    4    6:bipush          123
    //    5    8:invokevirtual   #277 <Method int String.indexOf(int)>
    //    6   11:istore          4
        int lastChar = perAttr.lastIndexOf('}');
    //    7   13:aload_3         
    //    8   14:bipush          125
    //    9   16:invokevirtual   #280 <Method int String.lastIndexOf(int)>
    //   10   19:istore          5
        perAttr = perAttr.substring(fristChar + 1, lastChar);
    //   11   21:aload_3         
    //   12   22:iload           4
    //   13   24:iconst_1        
    //   14   25:iadd            
    //   15   26:iload           5
    //   16   28:invokevirtual   #284 <Method String String.substring(int, int)>
    //   17   31:astore_3        
        for(int index = perAttr.indexOf(','); index != -1; index = perAttr.indexOf(','))
    //*  18   32:aload_3         
    //*  19   33:bipush          44
    //*  20   35:invokevirtual   #277 <Method int String.indexOf(int)>
    //*  21   38:istore          6
    //*  22   40:goto            72
        {
            set.add(perAttr.substring(0, index));
    //   23   43:aload_2         
    //   24   44:aload_3         
    //   25   45:iconst_0        
    //   26   46:iload           6
    //   27   48:invokevirtual   #284 <Method String String.substring(int, int)>
    //   28   51:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   29   54:pop             
            perAttr = perAttr.substring(index + 1);
    //   30   55:aload_3         
    //   31   56:iload           6
    //   32   58:iconst_1        
    //   33   59:iadd            
    //   34   60:invokevirtual   #287 <Method String String.substring(int)>
    //   35   63:astore_3        
        }

    //   36   64:aload_3         
    //   37   65:bipush          44
    //   38   67:invokevirtual   #277 <Method int String.indexOf(int)>
    //   39   70:istore          6
    //   40   72:iload           6
    //   41   74:iconst_m1       
    //   42   75:icmpne          43
        set.add(perAttr.substring(0));
    //   43   78:aload_2         
    //   44   79:aload_3         
    //   45   80:iconst_0        
    //   46   81:invokevirtual   #287 <Method String String.substring(int)>
    //   47   84:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   48   87:pop             
    //   49   88:return          
    }

    protected int hasSomePermissionSet(Vector permissionSet)
    {
        int sizeOfInitRoles = InitRoles.size();
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field Vector InitRoles>
    //    2    4:invokevirtual   #155 <Method int Vector.size()>
    //    3    7:istore_2        
        for(int index = 0; index < sizeOfInitRoles; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            39
            if(((InitRoleToCounts)InitRoles.get(index)).getInitRole().equals(permissionSet))
    //*   7   13:aload_0         
    //*   8   14:getfield        #36  <Field Vector InitRoles>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #207 <Method Object Vector.get(int)>
    //*  11   21:checkcast       #187 <Class CFMAbstractParent$InitRoleToCounts>
    //*  12   24:invokevirtual   #188 <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //*  13   27:aload_1         
    //*  14   28:invokevirtual   #297 <Method boolean Vector.equals(Object)>
    //*  15   31:ifeq            36
                return index;
    //   16   34:iload_3         
    //   17   35:ireturn         

    //   18   36:iinc            3  1
    //   19   39:iload_3         
    //   20   40:iload_2         
    //   21   41:icmplt          13
        return -1;
    //   22   44:iconst_m1       
    //   23   45:ireturn         
    }

    protected Vector getUserSet(Vector permissionSet, Matrix mat)
    {
        Vector useSet = new Vector();
    //    0    0:new             #33  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #34  <Method void Vector()>
    //    3    7:astore_3        
        for(int index = 0; index < mat.getRowDimension(); index++)
    //*   4    8:iconst_0        
    //*   5    9:istore          4
    //*   6   11:goto            86
        {
            Vector permList = new Vector();
    //    7   14:new             #33  <Class Vector>
    //    8   17:dup             
    //    9   18:invokespecial   #34  <Method void Vector()>
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
    //*  18   35:invokevirtual   #95  <Method byte Matrix.get(int, int)>
    //*  19   38:icmpne          52
                    permList.add(Integer.valueOf(jndex));
    //   20   41:aload           5
    //   21   43:iload           6
    //   22   45:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //   23   48:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   24   51:pop             

    //   25   52:iinc            6  1
    //   26   55:iload           6
    //   27   57:aload_2         
    //   28   58:invokevirtual   #109 <Method int Matrix.getColumnDimension()>
    //   29   61:icmplt          29
            if(permList.containsAll(permissionSet))
    //*  30   64:aload           5
    //*  31   66:aload_1         
    //*  32   67:invokevirtual   #306 <Method boolean Vector.containsAll(java.util.Collection)>
    //*  33   70:ifeq            83
                useSet.add(Integer.valueOf(index));
    //   34   73:aload_3         
    //   35   74:iload           4
    //   36   76:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //   37   79:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   38   82:pop             
        }

    //   39   83:iinc            4  1
    //   40   86:iload           4
    //   41   88:aload_2         
    //   42   89:invokevirtual   #123 <Method int Matrix.getRowDimension()>
    //   43   92:icmplt          14
        return useSet;
    //   44   95:aload_3         
    //   45   96:areturn         
    }

    protected void initialInitRoles(Matrix mat)
    {
        int rowDimension = mat.getRowDimension();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #123 <Method int Matrix.getRowDimension()>
    //    2    4:istore_2        
        int colDimension = mat.getColumnDimension();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #109 <Method int Matrix.getColumnDimension()>
    //    5    9:istore_3        
        for(int indexOfUser = 0; indexOfUser < rowDimension; indexOfUser++)
    //*   6   10:iconst_0        
    //*   7   11:istore          4
    //*   8   13:goto            164
        {
            Vector PermissionSet = new Vector();
    //    9   16:new             #33  <Class Vector>
    //   10   19:dup             
    //   11   20:invokespecial   #34  <Method void Vector()>
    //   12   23:astore          5
            for(int indexOfPermission = 0; indexOfPermission < colDimension; indexOfPermission++)
    //*  13   25:iconst_0        
    //*  14   26:istore          6
    //*  15   28:goto            57
                if(1 == mat.get(indexOfUser, indexOfPermission))
    //*  16   31:iconst_1        
    //*  17   32:aload_1         
    //*  18   33:iload           4
    //*  19   35:iload           6
    //*  20   37:invokevirtual   #95  <Method byte Matrix.get(int, int)>
    //*  21   40:icmpne          54
                    PermissionSet.add(Integer.valueOf(indexOfPermission));
    //   22   43:aload           5
    //   23   45:iload           6
    //   24   47:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //   25   50:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   26   53:pop             

    //   27   54:iinc            6  1
    //   28   57:iload           6
    //   29   59:iload_3         
    //   30   60:icmplt          31
            int indexOfPermissionSet = hasSomePermissionSet(PermissionSet);
    //   31   63:aload_0         
    //   32   64:aload           5
    //   33   66:invokevirtual   #309 <Method int hasSomePermissionSet(Vector)>
    //   34   69:istore          6
            if(indexOfPermissionSet != -1)
    //*  35   71:iload           6
    //*  36   73:iconst_m1       
    //*  37   74:icmpeq          112
            {
                ((InitRoleToCounts)InitRoles.get(indexOfPermissionSet)).setCounts(((InitRoleToCounts)InitRoles.get(indexOfPermissionSet)).getCounts() + 1);
    //   38   77:aload_0         
    //   39   78:getfield        #36  <Field Vector InitRoles>
    //   40   81:iload           6
    //   41   83:invokevirtual   #207 <Method Object Vector.get(int)>
    //   42   86:checkcast       #187 <Class CFMAbstractParent$InitRoleToCounts>
    //   43   89:aload_0         
    //   44   90:getfield        #36  <Field Vector InitRoles>
    //   45   93:iload           6
    //   46   95:invokevirtual   #207 <Method Object Vector.get(int)>
    //   47   98:checkcast       #187 <Class CFMAbstractParent$InitRoleToCounts>
    //   48  101:invokevirtual   #312 <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //   49  104:iconst_1        
    //   50  105:iadd            
    //   51  106:invokevirtual   #316 <Method void CFMAbstractParent$InitRoleToCounts.setCounts(int)>
            } else
    //*  52  109:goto            161
            {
                InitRoleToCounts InitRole = new InitRoleToCounts();
    //   53  112:new             #187 <Class CFMAbstractParent$InitRoleToCounts>
    //   54  115:dup             
    //   55  116:aload_0         
    //   56  117:invokespecial   #317 <Method void CFMAbstractParent$InitRoleToCounts(CFMAbstractParent)>
    //   57  120:astore          7
                InitRole.setInitRole(PermissionSet);
    //   58  122:aload           7
    //   59  124:aload           5
    //   60  126:invokevirtual   #320 <Method void CFMAbstractParent$InitRoleToCounts.setInitRole(Vector)>
                InitRole.setCounts(1);
    //   61  129:aload           7
    //   62  131:iconst_1        
    //   63  132:invokevirtual   #316 <Method void CFMAbstractParent$InitRoleToCounts.setCounts(int)>
                Vector useSet = getUserSet(PermissionSet, mat);
    //   64  135:aload_0         
    //   65  136:aload           5
    //   66  138:aload_1         
    //   67  139:invokevirtual   #322 <Method Vector getUserSet(Vector, Matrix)>
    //   68  142:astore          8
                InitRole.setUseList(useSet);
    //   69  144:aload           7
    //   70  146:aload           8
    //   71  148:invokevirtual   #323 <Method void CFMAbstractParent$InitRoleToCounts.setUseList(Vector)>
                InitRoles.add(InitRole);
    //   72  151:aload_0         
    //   73  152:getfield        #36  <Field Vector InitRoles>
    //   74  155:aload           7
    //   75  157:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   76  160:pop             
            }
        }

    //   77  161:iinc            4  1
    //   78  164:iload           4
    //   79  166:iload_2         
    //   80  167:icmplt          16
    //   81  170:return          
    }

    protected Vector permissionIntersection(Vector initRole, Vector initRole2)
    {
        Vector intersection = new Vector();
    //    0    0:new             #33  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #34  <Method void Vector()>
    //    3    7:astore_3        
        for(Iterator iterator = initRole.iterator(); iterator.hasNext();)
    //*   4    8:aload_1         
    //*   5    9:invokevirtual   #81  <Method Iterator Vector.iterator()>
    //*   6   12:astore          5
    //*   7   14:goto            54
        {
            int element = ((Integer)iterator.next()).intValue();
    //    8   17:aload           5
    //    9   19:invokeinterface #87  <Method Object Iterator.next()>
    //   10   24:checkcast       #97  <Class Integer>
    //   11   27:invokevirtual   #158 <Method int Integer.intValue()>
    //   12   30:istore          4
            if(initRole2.contains(Integer.valueOf(element)))
    //*  13   32:aload_2         
    //*  14   33:iload           4
    //*  15   35:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //*  16   38:invokevirtual   #161 <Method boolean Vector.contains(Object)>
    //*  17   41:ifeq            54
                intersection.add(Integer.valueOf(element));
    //   18   44:aload_3         
    //   19   45:iload           4
    //   20   47:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //   21   50:invokevirtual   #105 <Method boolean Vector.add(Object)>
    //   22   53:pop             
        }

    //   23   54:aload           5
    //   24   56:invokeinterface #133 <Method boolean Iterator.hasNext()>
    //   25   61:ifne            17
        return intersection;
    //   26   64:aload_3         
    //   27   65:areturn         
    }

    public void resetOptions()
    {
        a = 0.5D;
    //    0    0:aload_0         
    //    1    1:ldc2w           #338 <Double 0.5D>
    //    2    4:putfield        #125 <Field double a>
    //    3    7:return          
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #343 <Method Capabilities AbstractRoleminer.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #348 <Method void Capabilities.disableAll()>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    //    5    9:aload_1         
    //    6   10:getstatic       #354 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //    7   13:invokevirtual   #358 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    8   16:aload_1         
    //    9   17:getstatic       #361 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #358 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   11   23:aload_1         
    //   12   24:getstatic       #364 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   13   27:invokevirtual   #358 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NOMINAL_CLASS);
    //   14   30:aload_1         
    //   15   31:getstatic       #367 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NOMINAL_CLASS>
    //   16   34:invokevirtual   #358 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   17   37:aload_1         
    //   18   38:getstatic       #370 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   19   41:invokevirtual   #358 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   20   44:aload_1         
    //   21   45:areturn         
    }

    public Enumeration listOptions()
    {
        String string1 = (new StringBuilder("\tRequired weight of bias the results towards the roles found in the initial phase. (default = ")).append(a).append(")").toString();
    //    0    0:new             #204 <Class StringBuilder>
    //    1    3:dup             
    //    2    4:ldc2            #376 <String "\tRequired weight of bias the results towards the roles found in the initial phase. (default = ">
    //    3    7:invokespecial   #215 <Method void StringBuilder(String)>
    //    4   10:aload_0         
    //    5   11:getfield        #125 <Field double a>
    //    6   14:invokevirtual   #238 <Method StringBuilder StringBuilder.append(double)>
    //    7   17:ldc2            #378 <String ")">
    //    8   20:invokevirtual   #220 <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #224 <Method String StringBuilder.toString()>
    //   10   26:astore_1        
        FastVector newVector = new FastVector(1);
    //   11   27:new             #380 <Class FastVector>
    //   12   30:dup             
    //   13   31:iconst_1        
    //   14   32:invokespecial   #382 <Method void FastVector(int)>
    //   15   35:astore_2        
        newVector.addElement(new Option(string1, "a", 1, "-W <required similarity of roleset of role>"));
    //   16   36:aload_2         
    //   17   37:new             #384 <Class Option>
    //   18   40:dup             
    //   19   41:aload_1         
    //   20   42:ldc2            #385 <String "a">
    //   21   45:iconst_1        
    //   22   46:ldc2            #387 <String "-W <required similarity of roleset of role>">
    //   23   49:invokespecial   #390 <Method void Option(String, String, int, String)>
    //   24   52:invokevirtual   #394 <Method void FastVector.addElement(Object)>
        return newVector.elements();
    //   25   55:aload_2         
    //   26   56:invokevirtual   #397 <Method Enumeration FastVector.elements()>
    //   27   59:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        resetOptions();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #54  <Method void resetOptions()>
        String s_wr = Utils.getOption('a', options);
    //    2    4:bipush          97
    //    3    6:aload_1         
    //    4    7:invokestatic    #411 <Method String Utils.getOption(char, String[])>
    //    5   10:astore_2        
        if(s_wr.length() != 0)
    //*   6   11:aload_2         
    //*   7   12:invokevirtual   #414 <Method int String.length()>
    //*   8   15:ifeq            26
            a = Double.parseDouble(s_wr);
    //    9   18:aload_0         
    //   10   19:aload_2         
    //   11   20:invokestatic    #420 <Method double Double.parseDouble(String)>
    //   12   23:putfield        #125 <Field double a>
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
        options[current++] = "a";
    //    5    8:aload_1         
    //    6    9:iload_2         
    //    7   10:iinc            2  1
    //    8   13:ldc2            #385 <String "a">
    //    9   16:aastore         
        for(options[current++] = (new StringBuilder()).append(a).toString(); current < options.length; options[current++] = "");
    //   10   17:aload_1         
    //   11   18:iload_2         
    //   12   19:iinc            2  1
    //   13   22:new             #204 <Class StringBuilder>
    //   14   25:dup             
    //   15   26:invokespecial   #426 <Method void StringBuilder()>
    //   16   29:aload_0         
    //   17   30:getfield        #125 <Field double a>
    //   18   33:invokevirtual   #238 <Method StringBuilder StringBuilder.append(double)>
    //   19   36:invokevirtual   #224 <Method String StringBuilder.toString()>
    //   20   39:aastore         
    //   21   40:goto            52
    //   22   43:aload_1         
    //   23   44:iload_2         
    //   24   45:iinc            2  1
    //   25   48:ldc2            #428 <String "">
    //   26   51:aastore         
    //   27   52:iload_2         
    //   28   53:aload_1         
    //   29   54:arraylength     
    //   30   55:icmplt          43
        return options;
    //   31   58:aload_1         
    //   32   59:areturn         
    }

    public String toString()
    {
        return log.toString();
    //    0    0:aload_0         
    //    1    1:getfield        #49  <Field StringBuffer log>
    //    2    4:invokevirtual   #430 <Method String StringBuffer.toString()>
    //    3    7:areturn         
    }

    public double getA()
    {
        return a;
    //    0    0:aload_0         
    //    1    1:getfield        #125 <Field double a>
    //    2    4:dreturn         
    }

    public void setA(double a)
    {
        this.a = a;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #125 <Field double a>
    //    3    5:return          
    }

    public String waTipText()
    {
        return "Required weight of bias the results towards the roles found in the initial phase.";
    //    0    0:ldc2            #435 <String "Required weight of bias the results towards the roles found in the initial phase.">
    //    1    3:areturn         
    }

    public Assignment generateRoles()
    {
        m_assroles = new Assignment();
    //    0    0:aload_0         
    //    1    1:new             #73  <Class Assignment>
    //    2    4:dup             
    //    3    5:invokespecial   #438 <Method void Assignment()>
    //    4    8:putfield        #440 <Field Assignment m_assroles>
        m_assroles.setAssignementName("role-permission");
    //    5   11:aload_0         
    //    6   12:getfield        #440 <Field Assignment m_assroles>
    //    7   15:ldc2            #442 <String "role-permission">
    //    8   18:invokevirtual   #445 <Method void Assignment.setAssignementName(String)>
        Matrix mat = new Matrix(numberOfRoles, permissions.size(), (byte)0);
    //    9   21:new             #91  <Class Matrix>
    //   10   24:dup             
    //   11   25:aload_0         
    //   12   26:getfield        #44  <Field int numberOfRoles>
    //   13   29:aload_0         
    //   14   30:getfield        #40  <Field Vector permissions>
    //   15   33:invokevirtual   #155 <Method int Vector.size()>
    //   16   36:iconst_0        
    //   17   37:invokespecial   #448 <Method void Matrix(int, int, byte)>
    //   18   40:astore_1        
        for(int i = 0; i < numberOfRoles; i++)
    //*  19   41:iconst_0        
    //*  20   42:istore_2        
    //*  21   43:goto            105
        {
            Vector upi = ((Role)allroleSet.get(i)).getPermissionList();
    //   22   46:aload_0         
    //   23   47:getfield        #51  <Field Vector allroleSet>
    //   24   50:iload_2         
    //   25   51:invokevirtual   #207 <Method Object Vector.get(int)>
    //   26   54:checkcast       #89  <Class CFMAbstractParent$Role>
    //   27   57:invokevirtual   #113 <Method Vector CFMAbstractParent$Role.getPermissionList()>
    //   28   60:astore_3        
            for(int j = 0; j < permissions.size(); j++)
    //*  29   61:iconst_0        
    //*  30   62:istore          4
    //*  31   64:goto            90
                if(upi.contains(Integer.valueOf(j)))
    //*  32   67:aload_3         
    //*  33   68:iload           4
    //*  34   70:invokestatic    #101 <Method Integer Integer.valueOf(int)>
    //*  35   73:invokevirtual   #161 <Method boolean Vector.contains(Object)>
    //*  36   76:ifeq            87
                    mat.set(i, j, (byte)1);
    //   37   79:aload_1         
    //   38   80:iload_2         
    //   39   81:iload           4
    //   40   83:iconst_1        
    //   41   84:invokevirtual   #450 <Method void Matrix.set(int, int, byte)>

    //   42   87:iinc            4  1
    //   43   90:iload           4
    //   44   92:aload_0         
    //   45   93:getfield        #40  <Field Vector permissions>
    //   46   96:invokevirtual   #155 <Method int Vector.size()>
    //   47   99:icmplt          67
        }

    //   48  102:iinc            2  1
    //   49  105:iload_2         
    //   50  106:aload_0         
    //   51  107:getfield        #44  <Field int numberOfRoles>
    //   52  110:icmplt          46
        m_assroles.setAssignmentMatrix(mat);
    //   53  113:aload_0         
    //   54  114:getfield        #440 <Field Assignment m_assroles>
    //   55  117:aload_1         
    //   56  118:invokevirtual   #453 <Method void Assignment.setAssignmentMatrix(Matrix)>
        FastVector fv = new FastVector();
    //   57  121:new             #380 <Class FastVector>
    //   58  124:dup             
    //   59  125:invokespecial   #454 <Method void FastVector()>
    //   60  128:astore_2        
        for(int i = 0; i < numberOfRoles; i++)
    //*  61  129:iconst_0        
    //*  62  130:istore_3        
    //*  63  131:goto            158
            fv.addElement((new StringBuilder("R")).append(i).toString());
    //   64  134:aload_2         
    //   65  135:new             #204 <Class StringBuilder>
    //   66  138:dup             
    //   67  139:ldc2            #456 <String "R">
    //   68  142:invokespecial   #215 <Method void StringBuilder(String)>
    //   69  145:iload_3         
    //   70  146:invokevirtual   #459 <Method StringBuilder StringBuilder.append(int)>
    //   71  149:invokevirtual   #224 <Method String StringBuilder.toString()>
    //   72  152:invokevirtual   #394 <Method void FastVector.addElement(Object)>

    //   73  155:iinc            3  1
    //   74  158:iload_3         
    //   75  159:aload_0         
    //   76  160:getfield        #44  <Field int numberOfRoles>
    //   77  163:icmplt          134
        Attribute dxa = new Attribute("role", fv);
    //   78  166:new             #272 <Class Attribute>
    //   79  169:dup             
    //   80  170:ldc2            #460 <String "role">
    //   81  173:aload_2         
    //   82  174:invokespecial   #463 <Method void Attribute(String, FastVector)>
    //   83  177:astore_3        
        Dimension dx = new Dimension();
    //   84  178:new             #247 <Class Dimension>
    //   85  181:dup             
    //   86  182:invokespecial   #464 <Method void Dimension()>
    //   87  185:astore          4
        dx.setDimensionAttribute(dxa);
    //   88  187:aload           4
    //   89  189:aload_3         
    //   90  190:invokevirtual   #468 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionX(dx);
    //   91  193:aload_0         
    //   92  194:getfield        #440 <Field Assignment m_assroles>
    //   93  197:aload           4
    //   94  199:invokevirtual   #472 <Method void Assignment.setDimensionX(Dimension)>
        Attribute dya = m_assignment.getDimensionY().getDimensionAttribute();
    //   95  202:aload_0         
    //   96  203:getfield        #474 <Field Assignment m_assignment>
    //   97  206:invokevirtual   #254 <Method Dimension Assignment.getDimensionY()>
    //   98  209:invokevirtual   #251 <Method Attribute Dimension.getDimensionAttribute()>
    //   99  212:astore          5
        Dimension dy = new Dimension();
    //  100  214:new             #247 <Class Dimension>
    //  101  217:dup             
    //  102  218:invokespecial   #464 <Method void Dimension()>
    //  103  221:astore          6
        dy.setDimensionAttribute(dya);
    //  104  223:aload           6
    //  105  225:aload           5
    //  106  227:invokevirtual   #468 <Method void Dimension.setDimensionAttribute(Attribute)>
        m_assroles.setDimensionY(dy);
    //  107  230:aload_0         
    //  108  231:getfield        #440 <Field Assignment m_assroles>
    //  109  234:aload           6
    //  110  236:invokevirtual   #477 <Method void Assignment.setDimensionY(Dimension)>
        return m_assroles;
    //  111  239:aload_0         
    //  112  240:getfield        #440 <Field Assignment m_assroles>
    //  113  243:areturn         
    }

    protected Vector InitRoles;
    protected Vector GenRoles;
    protected Vector permissions;
    protected Vector users;
    protected int numberOfRoles;
    protected StringBuffer log;
    protected Assignment m_assignment;
    protected Assignment m_assroles;
    protected double a;
    protected Vector allroleSet;
}

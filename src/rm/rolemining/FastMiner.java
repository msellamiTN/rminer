// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   FastMiner.java

package rm.rolemining;

import java.io.*;
import java.util.*;
import rm.core.Assignment;
import rm.core.converters.AssLoader;

// Referenced classes of package rm.rolemining:
//            CFMAbstractParent, CompleteMiner

public class FastMiner extends CFMAbstractParent
{

    public FastMiner()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #15  <Method void CFMAbstractParent()>
        GenRoleToContribution = new HashMap();
    //    2    4:aload_0         
    //    3    5:new             #17  <Class HashMap>
    //    4    8:dup             
    //    5    9:invokespecial   #18  <Method void HashMap()>
    //    6   12:putfield        #20  <Field Map GenRoleToContribution>
        isShould = true;
    //    7   15:aload_0         
    //    8   16:iconst_1        
    //    9   17:putfield        #22  <Field boolean isShould>
    //   10   20:return          
    }

    public void buildRoleminers(Assignment data)
        throws Exception
    {
        m_assignment = data;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #35  <Field Assignment m_assignment>
        constructionInitialRole(data);
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokevirtual   #38  <Method void constructionInitialRole(Assignment)>
        initialGenRoles(data);
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:invokevirtual   #41  <Method void initialGenRoles(Assignment)>
        RoleRecommendation(data);
    //    9   15:aload_0         
    //   10   16:aload_1         
    //   11   17:invokevirtual   #44  <Method void RoleRecommendation(Assignment)>
        if(isShould)
    //*  12   20:aload_0         
    //*  13   21:getfield        #22  <Field boolean isShould>
    //*  14   24:ifeq            31
            CalculateNumbersOfRoles();
    //   15   27:aload_0         
    //   16   28:invokevirtual   #47  <Method void CalculateNumbersOfRoles()>
    //   17   31:return          
    }

    protected void initialGenRoles(Assignment data)
    {
        rm.core.Matrix mat = data.getAssignmentMatrix();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #54  <Method rm.core.Matrix Assignment.getAssignmentMatrix()>
    //    2    4:astore_2        
        int sizeOfInitRoles = InitRoles.size();
    //    3    5:aload_0         
    //    4    6:getfield        #58  <Field Vector InitRoles>
    //    5    9:invokevirtual   #64  <Method int Vector.size()>
    //    6   12:istore_3        
        for(int iindexOfInitRoles = 0; iindexOfInitRoles < sizeOfInitRoles - 1; iindexOfInitRoles++)
    //*   7   13:iconst_0        
    //*   8   14:istore          4
    //*   9   16:goto            438
        {
            CFMAbstractParent.InitRoleToCounts initRoleA = (CFMAbstractParent.InitRoleToCounts)InitRoles.get(iindexOfInitRoles);
    //   10   19:aload_0         
    //   11   20:getfield        #58  <Field Vector InitRoles>
    //   12   23:iload           4
    //   13   25:invokevirtual   #68  <Method Object Vector.get(int)>
    //   14   28:checkcast       #70  <Class CFMAbstractParent$InitRoleToCounts>
    //   15   31:astore          5
            for(int jindexOfInitRoles = iindexOfInitRoles + 1; jindexOfInitRoles < sizeOfInitRoles; jindexOfInitRoles++)
    //*  16   33:iload           4
    //*  17   35:iconst_1        
    //*  18   36:iadd            
    //*  19   37:istore          6
    //*  20   39:goto            429
            {
                CFMAbstractParent.InitRoleToCounts initRoleB = (CFMAbstractParent.InitRoleToCounts)InitRoles.get(jindexOfInitRoles);
    //   21   42:aload_0         
    //   22   43:getfield        #58  <Field Vector InitRoles>
    //   23   46:iload           6
    //   24   48:invokevirtual   #68  <Method Object Vector.get(int)>
    //   25   51:checkcast       #70  <Class CFMAbstractParent$InitRoleToCounts>
    //   26   54:astore          7
                Vector intersection = permissionIntersection(initRoleA.getInitRole(), initRoleB.getInitRole());
    //   27   56:aload_0         
    //   28   57:aload           5
    //   29   59:invokevirtual   #74  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   30   62:aload           7
    //   31   64:invokevirtual   #74  <Method Vector CFMAbstractParent$InitRoleToCounts.getInitRole()>
    //   32   67:invokevirtual   #78  <Method Vector permissionIntersection(Vector, Vector)>
    //   33   70:astore          8
                if(!intersection.isEmpty())
    //*  34   72:aload           8
    //*  35   74:invokevirtual   #82  <Method boolean Vector.isEmpty()>
    //*  36   77:ifne            426
                {
                    int indexOfPermissionSet = GenRoleshasSomePermissionSet(intersection);
    //   37   80:aload_0         
    //   38   81:aload           8
    //   39   83:invokevirtual   #86  <Method int GenRoleshasSomePermissionSet(Vector)>
    //   40   86:istore          9
                    if(indexOfPermissionSet == -1)
    //*  41   88:iload           9
    //*  42   90:iconst_m1       
    //*  43   91:icmpne          227
                    {
                        if(hasSomePermissionSet(intersection) == -1)
    //*  44   94:aload_0         
    //*  45   95:aload           8
    //*  46   97:invokevirtual   #89  <Method int hasSomePermissionSet(Vector)>
    //*  47  100:iconst_m1       
    //*  48  101:icmpne          426
                        {
                            CFMAbstractParent.GenRoleToCounts GenRole = new CFMAbstractParent.GenRoleToCounts(this);
    //   49  104:new             #91  <Class CFMAbstractParent$GenRoleToCounts>
    //   50  107:dup             
    //   51  108:aload_0         
    //   52  109:invokespecial   #94  <Method void CFMAbstractParent$GenRoleToCounts(CFMAbstractParent)>
    //   53  112:astore          10
                            GenRole.setInitRole(intersection);
    //   54  114:aload           10
    //   55  116:aload           8
    //   56  118:invokevirtual   #98  <Method void CFMAbstractParent$GenRoleToCounts.setInitRole(Vector)>
                            Vector useSet = getUserSet(intersection, mat);
    //   57  121:aload_0         
    //   58  122:aload           8
    //   59  124:aload_2         
    //   60  125:invokevirtual   #102 <Method Vector getUserSet(Vector, rm.core.Matrix)>
    //   61  128:astore          11
                            GenRole.setUseList(useSet);
    //   62  130:aload           10
    //   63  132:aload           11
    //   64  134:invokevirtual   #105 <Method void CFMAbstractParent$GenRoleToCounts.setUseList(Vector)>
                            GenRole.setCounts(GenRole.getCounts() + initRoleA.getCounts());
    //   65  137:aload           10
    //   66  139:aload           10
    //   67  141:invokevirtual   #108 <Method int CFMAbstractParent$GenRoleToCounts.getCounts()>
    //   68  144:aload           5
    //   69  146:invokevirtual   #109 <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //   70  149:iadd            
    //   71  150:invokevirtual   #113 <Method void CFMAbstractParent$GenRoleToCounts.setCounts(int)>
                            GenRole.setCounts(GenRole.getCounts() + initRoleB.getCounts());
    //   72  153:aload           10
    //   73  155:aload           10
    //   74  157:invokevirtual   #108 <Method int CFMAbstractParent$GenRoleToCounts.getCounts()>
    //   75  160:aload           7
    //   76  162:invokevirtual   #109 <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //   77  165:iadd            
    //   78  166:invokevirtual   #113 <Method void CFMAbstractParent$GenRoleToCounts.setCounts(int)>
                            Vector contributionGenRole = new Vector();
    //   79  169:new             #60  <Class Vector>
    //   80  172:dup             
    //   81  173:invokespecial   #114 <Method void Vector()>
    //   82  176:astore          12
                            contributionGenRole.add(Integer.valueOf(iindexOfInitRoles));
    //   83  178:aload           12
    //   84  180:iload           4
    //   85  182:invokestatic    #120 <Method Integer Integer.valueOf(int)>
    //   86  185:invokevirtual   #124 <Method boolean Vector.add(Object)>
    //   87  188:pop             
                            contributionGenRole.add(Integer.valueOf(jindexOfInitRoles));
    //   88  189:aload           12
    //   89  191:iload           6
    //   90  193:invokestatic    #120 <Method Integer Integer.valueOf(int)>
    //   91  196:invokevirtual   #124 <Method boolean Vector.add(Object)>
    //   92  199:pop             
                            GenRoles.add(GenRole);
    //   93  200:aload_0         
    //   94  201:getfield        #127 <Field Vector GenRoles>
    //   95  204:aload           10
    //   96  206:invokevirtual   #124 <Method boolean Vector.add(Object)>
    //   97  209:pop             
                            GenRoleToContribution.put(GenRole, contributionGenRole);
    //   98  210:aload_0         
    //   99  211:getfield        #20  <Field Map GenRoleToContribution>
    //  100  214:aload           10
    //  101  216:aload           12
    //  102  218:invokeinterface #133 <Method Object Map.put(Object, Object)>
    //  103  223:pop             
                        }
                    } else
    //* 104  224:goto            426
                    if(!((Vector)GenRoleToContribution.get(GenRoles.get(indexOfPermissionSet))).contains(Integer.valueOf(iindexOfInitRoles)))
    //* 105  227:aload_0         
    //* 106  228:getfield        #20  <Field Map GenRoleToContribution>
    //* 107  231:aload_0         
    //* 108  232:getfield        #127 <Field Vector GenRoles>
    //* 109  235:iload           9
    //* 110  237:invokevirtual   #68  <Method Object Vector.get(int)>
    //* 111  240:invokeinterface #136 <Method Object Map.get(Object)>
    //* 112  245:checkcast       #60  <Class Vector>
    //* 113  248:iload           4
    //* 114  250:invokestatic    #120 <Method Integer Integer.valueOf(int)>
    //* 115  253:invokevirtual   #139 <Method boolean Vector.contains(Object)>
    //* 116  256:ifne            328
                    {
                        ((CFMAbstractParent.GenRoleToCounts)GenRoles.get(indexOfPermissionSet)).setCounts(((CFMAbstractParent.GenRoleToCounts)GenRoles.get(indexOfPermissionSet)).getCounts() + initRoleA.getCounts());
    //  117  259:aload_0         
    //  118  260:getfield        #127 <Field Vector GenRoles>
    //  119  263:iload           9
    //  120  265:invokevirtual   #68  <Method Object Vector.get(int)>
    //  121  268:checkcast       #91  <Class CFMAbstractParent$GenRoleToCounts>
    //  122  271:aload_0         
    //  123  272:getfield        #127 <Field Vector GenRoles>
    //  124  275:iload           9
    //  125  277:invokevirtual   #68  <Method Object Vector.get(int)>
    //  126  280:checkcast       #91  <Class CFMAbstractParent$GenRoleToCounts>
    //  127  283:invokevirtual   #108 <Method int CFMAbstractParent$GenRoleToCounts.getCounts()>
    //  128  286:aload           5
    //  129  288:invokevirtual   #109 <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //  130  291:iadd            
    //  131  292:invokevirtual   #113 <Method void CFMAbstractParent$GenRoleToCounts.setCounts(int)>
                        ((Vector)GenRoleToContribution.get(GenRoles.get(indexOfPermissionSet))).add(Integer.valueOf(iindexOfInitRoles));
    //  132  295:aload_0         
    //  133  296:getfield        #20  <Field Map GenRoleToContribution>
    //  134  299:aload_0         
    //  135  300:getfield        #127 <Field Vector GenRoles>
    //  136  303:iload           9
    //  137  305:invokevirtual   #68  <Method Object Vector.get(int)>
    //  138  308:invokeinterface #136 <Method Object Map.get(Object)>
    //  139  313:checkcast       #60  <Class Vector>
    //  140  316:iload           4
    //  141  318:invokestatic    #120 <Method Integer Integer.valueOf(int)>
    //  142  321:invokevirtual   #124 <Method boolean Vector.add(Object)>
    //  143  324:pop             
                    } else
    //* 144  325:goto            426
                    if(!((Vector)GenRoleToContribution.get(GenRoles.get(indexOfPermissionSet))).contains(Integer.valueOf(jindexOfInitRoles)))
    //* 145  328:aload_0         
    //* 146  329:getfield        #20  <Field Map GenRoleToContribution>
    //* 147  332:aload_0         
    //* 148  333:getfield        #127 <Field Vector GenRoles>
    //* 149  336:iload           9
    //* 150  338:invokevirtual   #68  <Method Object Vector.get(int)>
    //* 151  341:invokeinterface #136 <Method Object Map.get(Object)>
    //* 152  346:checkcast       #60  <Class Vector>
    //* 153  349:iload           6
    //* 154  351:invokestatic    #120 <Method Integer Integer.valueOf(int)>
    //* 155  354:invokevirtual   #139 <Method boolean Vector.contains(Object)>
    //* 156  357:ifne            426
                    {
                        ((CFMAbstractParent.GenRoleToCounts)GenRoles.get(indexOfPermissionSet)).setCounts(((CFMAbstractParent.GenRoleToCounts)GenRoles.get(indexOfPermissionSet)).getCounts() + initRoleB.getCounts());
    //  157  360:aload_0         
    //  158  361:getfield        #127 <Field Vector GenRoles>
    //  159  364:iload           9
    //  160  366:invokevirtual   #68  <Method Object Vector.get(int)>
    //  161  369:checkcast       #91  <Class CFMAbstractParent$GenRoleToCounts>
    //  162  372:aload_0         
    //  163  373:getfield        #127 <Field Vector GenRoles>
    //  164  376:iload           9
    //  165  378:invokevirtual   #68  <Method Object Vector.get(int)>
    //  166  381:checkcast       #91  <Class CFMAbstractParent$GenRoleToCounts>
    //  167  384:invokevirtual   #108 <Method int CFMAbstractParent$GenRoleToCounts.getCounts()>
    //  168  387:aload           7
    //  169  389:invokevirtual   #109 <Method int CFMAbstractParent$InitRoleToCounts.getCounts()>
    //  170  392:iadd            
    //  171  393:invokevirtual   #113 <Method void CFMAbstractParent$GenRoleToCounts.setCounts(int)>
                        ((Vector)GenRoleToContribution.get(GenRoles.get(indexOfPermissionSet))).add(Integer.valueOf(jindexOfInitRoles));
    //  172  396:aload_0         
    //  173  397:getfield        #20  <Field Map GenRoleToContribution>
    //  174  400:aload_0         
    //  175  401:getfield        #127 <Field Vector GenRoles>
    //  176  404:iload           9
    //  177  406:invokevirtual   #68  <Method Object Vector.get(int)>
    //  178  409:invokeinterface #136 <Method Object Map.get(Object)>
    //  179  414:checkcast       #60  <Class Vector>
    //  180  417:iload           6
    //  181  419:invokestatic    #120 <Method Integer Integer.valueOf(int)>
    //  182  422:invokevirtual   #124 <Method boolean Vector.add(Object)>
    //  183  425:pop             
                    }
                }
            }

    //  184  426:iinc            6  1
    //  185  429:iload           6
    //  186  431:iload_3         
    //  187  432:icmplt          42
        }

    //  188  435:iinc            4  1
    //  189  438:iload           4
    //  190  440:iload_3         
    //  191  441:iconst_1        
    //  192  442:isub            
    //  193  443:icmplt          19
    //  194  446:return          
    }

    protected int GenRoleshasSomePermissionSet(Vector intersection)
    {
        int sizeOfGenRoles = GenRoles.size();
    //    0    0:aload_0         
    //    1    1:getfield        #127 <Field Vector GenRoles>
    //    2    4:invokevirtual   #64  <Method int Vector.size()>
    //    3    7:istore_2        
        for(int index = 0; index < sizeOfGenRoles; index++)
    //*   4    8:iconst_0        
    //*   5    9:istore_3        
    //*   6   10:goto            39
            if(((CFMAbstractParent.GenRoleToCounts)GenRoles.get(index)).getInitRole().equals(intersection))
    //*   7   13:aload_0         
    //*   8   14:getfield        #127 <Field Vector GenRoles>
    //*   9   17:iload_3         
    //*  10   18:invokevirtual   #68  <Method Object Vector.get(int)>
    //*  11   21:checkcast       #91  <Class CFMAbstractParent$GenRoleToCounts>
    //*  12   24:invokevirtual   #158 <Method Vector CFMAbstractParent$GenRoleToCounts.getInitRole()>
    //*  13   27:aload_1         
    //*  14   28:invokevirtual   #161 <Method boolean Vector.equals(Object)>
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

    public String globalInfo()
    {
        return "FM generates the initial roles by every user's permissions \nthen intersect these initial roles to get more candidate\n roles but FM intersect only once for all exist roles. \n";
    //    0    0:ldc1            #167 <String "FM generates the initial roles by every user's permissions \nthen intersect these initial roles to get more candidate\n roles but FM intersect only once for all exist roles. \n">
    //    1    2:areturn         
    }

    public static void main(String args[])
    {
        Assignment Ass = null;
    //    0    0:aconst_null     
    //    1    1:astore_1        
        try
        {
            File file = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\orca_user_permission.ass").toString());
    //    2    2:new             #171 <Class File>
    //    3    5:dup             
    //    4    6:new             #173 <Class StringBuilder>
    //    5    9:dup             
    //    6   10:ldc1            #175 <String "user.dir">
    //    7   12:invokestatic    #181 <Method String System.getProperty(String)>
    //    8   15:invokestatic    #186 <Method String String.valueOf(Object)>
    //    9   18:invokespecial   #189 <Method void StringBuilder(String)>
    //   10   21:ldc1            #191 <String "\\datasets\\orca_user_permission.ass">
    //   11   23:invokevirtual   #195 <Method StringBuilder StringBuilder.append(String)>
    //   12   26:invokevirtual   #198 <Method String StringBuilder.toString()>
    //   13   29:invokespecial   #199 <Method void File(String)>
    //   14   32:astore_2        
            AssLoader AL = new AssLoader(new FileReader(file));
    //   15   33:new             #201 <Class AssLoader>
    //   16   36:dup             
    //   17   37:new             #203 <Class FileReader>
    //   18   40:dup             
    //   19   41:aload_2         
    //   20   42:invokespecial   #206 <Method void FileReader(File)>
    //   21   45:invokespecial   #209 <Method void AssLoader(FileReader)>
    //   22   48:astore_3        
            Ass = AL.getData();
    //   23   49:aload_3         
    //   24   50:invokevirtual   #213 <Method Assignment AssLoader.getData()>
    //   25   53:astore_1        
            System.out.println(Ass.getAssignementName());
    //   26   54:getstatic       #217 <Field PrintStream System.out>
    //   27   57:aload_1         
    //   28   58:invokevirtual   #220 <Method String Assignment.getAssignementName()>
    //   29   61:invokevirtual   #225 <Method void PrintStream.println(String)>
            CompleteMiner cm = new CompleteMiner();
    //   30   64:new             #227 <Class CompleteMiner>
    //   31   67:dup             
    //   32   68:invokespecial   #228 <Method void CompleteMiner()>
    //   33   71:astore          4
            cm.buildRoleminers(Ass);
    //   34   73:aload           4
    //   35   75:aload_1         
    //   36   76:invokevirtual   #230 <Method void CompleteMiner.buildRoleminers(Assignment)>
            System.out.println(cm.toString());
    //   37   79:getstatic       #217 <Field PrintStream System.out>
    //   38   82:aload           4
    //   39   84:invokevirtual   #231 <Method String CompleteMiner.toString()>
    //   40   87:invokevirtual   #225 <Method void PrintStream.println(String)>
            System.out.println(cm.generateRoles());
    //   41   90:getstatic       #217 <Field PrintStream System.out>
    //   42   93:aload           4
    //   43   95:invokevirtual   #234 <Method Assignment CompleteMiner.generateRoles()>
    //   44   98:invokevirtual   #237 <Method void PrintStream.println(Object)>
        }
    //*  45  101:goto            109
        catch(Exception e)
    //*  46  104:astore_2        
        {
            e.printStackTrace();
    //   47  105:aload_2         
    //   48  106:invokevirtual   #240 <Method void Exception.printStackTrace()>
        }
    //   49  109:return          
    }

    public boolean isShould()
    {
        return isShould;
    //    0    0:aload_0         
    //    1    1:getfield        #22  <Field boolean isShould>
    //    2    4:ireturn         
    }

    public void setShould(boolean isShould)
    {
        this.isShould = isShould;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #22  <Field boolean isShould>
    //    3    5:return          
    }

    private Map GenRoleToContribution;
    protected boolean isShould;
}

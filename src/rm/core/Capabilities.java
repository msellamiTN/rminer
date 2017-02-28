// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Capabilities.java

package rm.core;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

// Referenced classes of package rm.core:
//            Utils, Attribute, UnsupportedAttributeTypeException, Instances, 
//            WekaException, UnassignedClassException, Instance, SparseInstance, 
//            NoSupportForMissingValuesException, MultiInstanceCapabilitiesHandler, CapabilitiesHandler

public class Capabilities
    implements Cloneable, Serializable
{
    public static class Capability extends Enum
    {

        public boolean isAttribute()
        {
            return (m_Flags & 1) == 1;
        //    0    0:aload_0         
        //    1    1:getfield        #147 <Field int m_Flags>
        //    2    4:iconst_1        
        //    3    5:iand            
        //    4    6:iconst_1        
        //    5    7:icmpne          12
        //    6   10:iconst_1        
        //    7   11:ireturn         
        //    8   12:iconst_0        
        //    9   13:ireturn         
        }

        public boolean isClass()
        {
            return (m_Flags & 2) == 2;
        //    0    0:aload_0         
        //    1    1:getfield        #147 <Field int m_Flags>
        //    2    4:iconst_2        
        //    3    5:iand            
        //    4    6:iconst_2        
        //    5    7:icmpne          12
        //    6   10:iconst_1        
        //    7   11:ireturn         
        //    8   12:iconst_0        
        //    9   13:ireturn         
        }

        public boolean isAttributeCapability()
        {
            return (m_Flags & 4) == 4;
        //    0    0:aload_0         
        //    1    1:getfield        #147 <Field int m_Flags>
        //    2    4:iconst_4        
        //    3    5:iand            
        //    4    6:iconst_4        
        //    5    7:icmpne          12
        //    6   10:iconst_1        
        //    7   11:ireturn         
        //    8   12:iconst_0        
        //    9   13:ireturn         
        }

        public boolean isOtherCapability()
        {
            return (m_Flags & 0x10) == 16;
        //    0    0:aload_0         
        //    1    1:getfield        #147 <Field int m_Flags>
        //    2    4:bipush          16
        //    3    6:iand            
        //    4    7:bipush          16
        //    5    9:icmpne          14
        //    6   12:iconst_1        
        //    7   13:ireturn         
        //    8   14:iconst_0        
        //    9   15:ireturn         
        }

        public boolean isClassCapability()
        {
            return (m_Flags & 8) == 8;
        //    0    0:aload_0         
        //    1    1:getfield        #147 <Field int m_Flags>
        //    2    4:bipush          8
        //    3    6:iand            
        //    4    7:bipush          8
        //    5    9:icmpne          14
        //    6   12:iconst_1        
        //    7   13:ireturn         
        //    8   14:iconst_0        
        //    9   15:ireturn         
        }

        public String toString()
        {
            return m_Display;
        //    0    0:aload_0         
        //    1    1:getfield        #149 <Field String m_Display>
        //    2    4:areturn         
        }

        public static final Capability[] values()
        {
            Capability acapability[];
            int i;
            Capability acapability1[];
            System.arraycopy(acapability = ENUM$VALUES, 0, acapability1 = new Capability[i = acapability.length], 0, i);
        //    0    0:getstatic       #140 <Field Capabilities$Capability[] ENUM$VALUES>
        //    1    3:dup             
        //    2    4:astore_0        
        //    3    5:iconst_0        
        //    4    6:aload_0         
        //    5    7:arraylength     
        //    6    8:dup             
        //    7    9:istore_1        
        //    8   10:anewarray       Capability[]
        //    9   13:dup             
        //   10   14:astore_2        
        //   11   15:iconst_0        
        //   12   16:iload_1         
        //   13   17:invokestatic    #168 <Method void System.arraycopy(Object, int, Object, int, int)>
            return acapability1;
        //   14   20:aload_2         
        //   15   21:areturn         
        }

        public static final Capability valueOf(String s)
        {
            Capability acapability[];
            Capability capability;
            for(int i = (acapability = ENUM$VALUES).length; --i >= 0;)
        //*   0    0:getstatic       #140 <Field Capabilities$Capability[] ENUM$VALUES>
        //*   1    3:dup             
        //*   2    4:astore_1        
        //*   3    5:arraylength     
        //*   4    6:istore_2        
        //*   5    7:goto            27
                if(s.equals((capability = acapability[i]).name()))
        //*   6   10:aload_0         
        //*   7   11:aload_1         
        //*   8   12:iload_2         
        //*   9   13:aaload          
        //*  10   14:dup             
        //*  11   15:astore_3        
        //*  12   16:invokevirtual   #173 <Method String name()>
        //*  13   19:invokevirtual   #179 <Method boolean String.equals(Object)>
        //*  14   22:ifeq            27
                    return capability;
        //   15   25:aload_3         
        //   16   26:areturn         

        //   17   27:iinc            2  -1
        //   18   30:iload_2         
        //   19   31:ifge            10
            throw new IllegalArgumentException(s);
        //   20   34:new             #181 <Class IllegalArgumentException>
        //   21   37:dup             
        //   22   38:aload_0         
        //   23   39:invokespecial   #184 <Method void IllegalArgumentException(String)>
        //   24   42:athrow          
        }

        public static final Capability NOMINAL_ATTRIBUTES;
        public static final Capability BINARY_ATTRIBUTES;
        public static final Capability UNARY_ATTRIBUTES;
        public static final Capability EMPTY_NOMINAL_ATTRIBUTES;
        public static final Capability NUMERIC_ATTRIBUTES;
        public static final Capability DATE_ATTRIBUTES;
        public static final Capability STRING_ATTRIBUTES;
        public static final Capability RELATIONAL_ATTRIBUTES;
        public static final Capability MISSING_VALUES;
        public static final Capability NO_CLASS;
        public static final Capability NOMINAL_CLASS;
        public static final Capability BINARY_CLASS;
        public static final Capability UNARY_CLASS;
        public static final Capability EMPTY_NOMINAL_CLASS;
        public static final Capability NUMERIC_CLASS;
        public static final Capability DATE_CLASS;
        public static final Capability STRING_CLASS;
        public static final Capability RELATIONAL_CLASS;
        public static final Capability MISSING_CLASS_VALUES;
        public static final Capability ONLY_MULTIINSTANCE;
        private int m_Flags;
        private String m_Display;
        private static final Capability ENUM$VALUES[];

        static 
        {
            NOMINAL_ATTRIBUTES = new Capability("NOMINAL_ATTRIBUTES", 0, 5, "Nominal attributes");
        //    0    0:new             #2   <Class Capabilities$Capability>
        //    1    3:dup             
        //    2    4:ldc1            #35  <String "NOMINAL_ATTRIBUTES">
        //    3    6:iconst_0        
        //    4    7:iconst_5        
        //    5    8:ldc1            #37  <String "Nominal attributes">
        //    6   10:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //    7   13:putstatic       #43  <Field Capabilities$Capability NOMINAL_ATTRIBUTES>
            BINARY_ATTRIBUTES = new Capability("BINARY_ATTRIBUTES", 1, 5, "Binary attributes");
        //    8   16:new             #2   <Class Capabilities$Capability>
        //    9   19:dup             
        //   10   20:ldc1            #44  <String "BINARY_ATTRIBUTES">
        //   11   22:iconst_1        
        //   12   23:iconst_5        
        //   13   24:ldc1            #46  <String "Binary attributes">
        //   14   26:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   15   29:putstatic       #48  <Field Capabilities$Capability BINARY_ATTRIBUTES>
            UNARY_ATTRIBUTES = new Capability("UNARY_ATTRIBUTES", 2, 5, "Unary attributes");
        //   16   32:new             #2   <Class Capabilities$Capability>
        //   17   35:dup             
        //   18   36:ldc1            #49  <String "UNARY_ATTRIBUTES">
        //   19   38:iconst_2        
        //   20   39:iconst_5        
        //   21   40:ldc1            #51  <String "Unary attributes">
        //   22   42:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   23   45:putstatic       #53  <Field Capabilities$Capability UNARY_ATTRIBUTES>
            EMPTY_NOMINAL_ATTRIBUTES = new Capability("EMPTY_NOMINAL_ATTRIBUTES", 3, 5, "Empty nominal attributes");
        //   24   48:new             #2   <Class Capabilities$Capability>
        //   25   51:dup             
        //   26   52:ldc1            #54  <String "EMPTY_NOMINAL_ATTRIBUTES">
        //   27   54:iconst_3        
        //   28   55:iconst_5        
        //   29   56:ldc1            #56  <String "Empty nominal attributes">
        //   30   58:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   31   61:putstatic       #58  <Field Capabilities$Capability EMPTY_NOMINAL_ATTRIBUTES>
            NUMERIC_ATTRIBUTES = new Capability("NUMERIC_ATTRIBUTES", 4, 5, "Numeric attributes");
        //   32   64:new             #2   <Class Capabilities$Capability>
        //   33   67:dup             
        //   34   68:ldc1            #59  <String "NUMERIC_ATTRIBUTES">
        //   35   70:iconst_4        
        //   36   71:iconst_5        
        //   37   72:ldc1            #61  <String "Numeric attributes">
        //   38   74:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   39   77:putstatic       #63  <Field Capabilities$Capability NUMERIC_ATTRIBUTES>
            DATE_ATTRIBUTES = new Capability("DATE_ATTRIBUTES", 5, 5, "Date attributes");
        //   40   80:new             #2   <Class Capabilities$Capability>
        //   41   83:dup             
        //   42   84:ldc1            #64  <String "DATE_ATTRIBUTES">
        //   43   86:iconst_5        
        //   44   87:iconst_5        
        //   45   88:ldc1            #66  <String "Date attributes">
        //   46   90:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   47   93:putstatic       #68  <Field Capabilities$Capability DATE_ATTRIBUTES>
            STRING_ATTRIBUTES = new Capability("STRING_ATTRIBUTES", 6, 5, "String attributes");
        //   48   96:new             #2   <Class Capabilities$Capability>
        //   49   99:dup             
        //   50  100:ldc1            #69  <String "STRING_ATTRIBUTES">
        //   51  102:bipush          6
        //   52  104:iconst_5        
        //   53  105:ldc1            #71  <String "String attributes">
        //   54  107:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   55  110:putstatic       #73  <Field Capabilities$Capability STRING_ATTRIBUTES>
            RELATIONAL_ATTRIBUTES = new Capability("RELATIONAL_ATTRIBUTES", 7, 5, "Relational attributes");
        //   56  113:new             #2   <Class Capabilities$Capability>
        //   57  116:dup             
        //   58  117:ldc1            #74  <String "RELATIONAL_ATTRIBUTES">
        //   59  119:bipush          7
        //   60  121:iconst_5        
        //   61  122:ldc1            #76  <String "Relational attributes">
        //   62  124:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   63  127:putstatic       #78  <Field Capabilities$Capability RELATIONAL_ATTRIBUTES>
            MISSING_VALUES = new Capability("MISSING_VALUES", 8, 4, "Missing values");
        //   64  130:new             #2   <Class Capabilities$Capability>
        //   65  133:dup             
        //   66  134:ldc1            #79  <String "MISSING_VALUES">
        //   67  136:bipush          8
        //   68  138:iconst_4        
        //   69  139:ldc1            #81  <String "Missing values">
        //   70  141:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   71  144:putstatic       #83  <Field Capabilities$Capability MISSING_VALUES>
            NO_CLASS = new Capability("NO_CLASS", 9, 8, "No class");
        //   72  147:new             #2   <Class Capabilities$Capability>
        //   73  150:dup             
        //   74  151:ldc1            #84  <String "NO_CLASS">
        //   75  153:bipush          9
        //   76  155:bipush          8
        //   77  157:ldc1            #86  <String "No class">
        //   78  159:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   79  162:putstatic       #88  <Field Capabilities$Capability NO_CLASS>
            NOMINAL_CLASS = new Capability("NOMINAL_CLASS", 10, 10, "Nominal class");
        //   80  165:new             #2   <Class Capabilities$Capability>
        //   81  168:dup             
        //   82  169:ldc1            #89  <String "NOMINAL_CLASS">
        //   83  171:bipush          10
        //   84  173:bipush          10
        //   85  175:ldc1            #91  <String "Nominal class">
        //   86  177:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   87  180:putstatic       #93  <Field Capabilities$Capability NOMINAL_CLASS>
            BINARY_CLASS = new Capability("BINARY_CLASS", 11, 10, "Binary class");
        //   88  183:new             #2   <Class Capabilities$Capability>
        //   89  186:dup             
        //   90  187:ldc1            #94  <String "BINARY_CLASS">
        //   91  189:bipush          11
        //   92  191:bipush          10
        //   93  193:ldc1            #96  <String "Binary class">
        //   94  195:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //   95  198:putstatic       #98  <Field Capabilities$Capability BINARY_CLASS>
            UNARY_CLASS = new Capability("UNARY_CLASS", 12, 10, "Unary class");
        //   96  201:new             #2   <Class Capabilities$Capability>
        //   97  204:dup             
        //   98  205:ldc1            #99  <String "UNARY_CLASS">
        //   99  207:bipush          12
        //  100  209:bipush          10
        //  101  211:ldc1            #101 <String "Unary class">
        //  102  213:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  103  216:putstatic       #103 <Field Capabilities$Capability UNARY_CLASS>
            EMPTY_NOMINAL_CLASS = new Capability("EMPTY_NOMINAL_CLASS", 13, 10, "Empty nominal class");
        //  104  219:new             #2   <Class Capabilities$Capability>
        //  105  222:dup             
        //  106  223:ldc1            #104 <String "EMPTY_NOMINAL_CLASS">
        //  107  225:bipush          13
        //  108  227:bipush          10
        //  109  229:ldc1            #106 <String "Empty nominal class">
        //  110  231:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  111  234:putstatic       #108 <Field Capabilities$Capability EMPTY_NOMINAL_CLASS>
            NUMERIC_CLASS = new Capability("NUMERIC_CLASS", 14, 10, "Numeric class");
        //  112  237:new             #2   <Class Capabilities$Capability>
        //  113  240:dup             
        //  114  241:ldc1            #109 <String "NUMERIC_CLASS">
        //  115  243:bipush          14
        //  116  245:bipush          10
        //  117  247:ldc1            #111 <String "Numeric class">
        //  118  249:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  119  252:putstatic       #113 <Field Capabilities$Capability NUMERIC_CLASS>
            DATE_CLASS = new Capability("DATE_CLASS", 15, 10, "Date class");
        //  120  255:new             #2   <Class Capabilities$Capability>
        //  121  258:dup             
        //  122  259:ldc1            #114 <String "DATE_CLASS">
        //  123  261:bipush          15
        //  124  263:bipush          10
        //  125  265:ldc1            #116 <String "Date class">
        //  126  267:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  127  270:putstatic       #118 <Field Capabilities$Capability DATE_CLASS>
            STRING_CLASS = new Capability("STRING_CLASS", 16, 10, "String class");
        //  128  273:new             #2   <Class Capabilities$Capability>
        //  129  276:dup             
        //  130  277:ldc1            #119 <String "STRING_CLASS">
        //  131  279:bipush          16
        //  132  281:bipush          10
        //  133  283:ldc1            #121 <String "String class">
        //  134  285:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  135  288:putstatic       #123 <Field Capabilities$Capability STRING_CLASS>
            RELATIONAL_CLASS = new Capability("RELATIONAL_CLASS", 17, 10, "Relational class");
        //  136  291:new             #2   <Class Capabilities$Capability>
        //  137  294:dup             
        //  138  295:ldc1            #124 <String "RELATIONAL_CLASS">
        //  139  297:bipush          17
        //  140  299:bipush          10
        //  141  301:ldc1            #126 <String "Relational class">
        //  142  303:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  143  306:putstatic       #128 <Field Capabilities$Capability RELATIONAL_CLASS>
            MISSING_CLASS_VALUES = new Capability("MISSING_CLASS_VALUES", 18, 8, "Missing class values");
        //  144  309:new             #2   <Class Capabilities$Capability>
        //  145  312:dup             
        //  146  313:ldc1            #129 <String "MISSING_CLASS_VALUES">
        //  147  315:bipush          18
        //  148  317:bipush          8
        //  149  319:ldc1            #131 <String "Missing class values">
        //  150  321:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  151  324:putstatic       #133 <Field Capabilities$Capability MISSING_CLASS_VALUES>
            ONLY_MULTIINSTANCE = new Capability("ONLY_MULTIINSTANCE", 19, 16, "Only multi-Instance data");
        //  152  327:new             #2   <Class Capabilities$Capability>
        //  153  330:dup             
        //  154  331:ldc1            #134 <String "ONLY_MULTIINSTANCE">
        //  155  333:bipush          19
        //  156  335:bipush          16
        //  157  337:ldc1            #136 <String "Only multi-Instance data">
        //  158  339:invokespecial   #41  <Method void Capabilities$Capability(String, int, int, String)>
        //  159  342:putstatic       #138 <Field Capabilities$Capability ONLY_MULTIINSTANCE>
            ENUM$VALUES = (new Capability[] {
                NOMINAL_ATTRIBUTES, BINARY_ATTRIBUTES, UNARY_ATTRIBUTES, EMPTY_NOMINAL_ATTRIBUTES, NUMERIC_ATTRIBUTES, DATE_ATTRIBUTES, STRING_ATTRIBUTES, RELATIONAL_ATTRIBUTES, MISSING_VALUES, NO_CLASS, 
                NOMINAL_CLASS, BINARY_CLASS, UNARY_CLASS, EMPTY_NOMINAL_CLASS, NUMERIC_CLASS, DATE_CLASS, STRING_CLASS, RELATIONAL_CLASS, MISSING_CLASS_VALUES, ONLY_MULTIINSTANCE
            });
        //  160  345:bipush          20
        //  161  347:anewarray       Capability[]
        //  162  350:dup             
        //  163  351:iconst_0        
        //  164  352:getstatic       #43  <Field Capabilities$Capability NOMINAL_ATTRIBUTES>
        //  165  355:aastore         
        //  166  356:dup             
        //  167  357:iconst_1        
        //  168  358:getstatic       #48  <Field Capabilities$Capability BINARY_ATTRIBUTES>
        //  169  361:aastore         
        //  170  362:dup             
        //  171  363:iconst_2        
        //  172  364:getstatic       #53  <Field Capabilities$Capability UNARY_ATTRIBUTES>
        //  173  367:aastore         
        //  174  368:dup             
        //  175  369:iconst_3        
        //  176  370:getstatic       #58  <Field Capabilities$Capability EMPTY_NOMINAL_ATTRIBUTES>
        //  177  373:aastore         
        //  178  374:dup             
        //  179  375:iconst_4        
        //  180  376:getstatic       #63  <Field Capabilities$Capability NUMERIC_ATTRIBUTES>
        //  181  379:aastore         
        //  182  380:dup             
        //  183  381:iconst_5        
        //  184  382:getstatic       #68  <Field Capabilities$Capability DATE_ATTRIBUTES>
        //  185  385:aastore         
        //  186  386:dup             
        //  187  387:bipush          6
        //  188  389:getstatic       #73  <Field Capabilities$Capability STRING_ATTRIBUTES>
        //  189  392:aastore         
        //  190  393:dup             
        //  191  394:bipush          7
        //  192  396:getstatic       #78  <Field Capabilities$Capability RELATIONAL_ATTRIBUTES>
        //  193  399:aastore         
        //  194  400:dup             
        //  195  401:bipush          8
        //  196  403:getstatic       #83  <Field Capabilities$Capability MISSING_VALUES>
        //  197  406:aastore         
        //  198  407:dup             
        //  199  408:bipush          9
        //  200  410:getstatic       #88  <Field Capabilities$Capability NO_CLASS>
        //  201  413:aastore         
        //  202  414:dup             
        //  203  415:bipush          10
        //  204  417:getstatic       #93  <Field Capabilities$Capability NOMINAL_CLASS>
        //  205  420:aastore         
        //  206  421:dup             
        //  207  422:bipush          11
        //  208  424:getstatic       #98  <Field Capabilities$Capability BINARY_CLASS>
        //  209  427:aastore         
        //  210  428:dup             
        //  211  429:bipush          12
        //  212  431:getstatic       #103 <Field Capabilities$Capability UNARY_CLASS>
        //  213  434:aastore         
        //  214  435:dup             
        //  215  436:bipush          13
        //  216  438:getstatic       #108 <Field Capabilities$Capability EMPTY_NOMINAL_CLASS>
        //  217  441:aastore         
        //  218  442:dup             
        //  219  443:bipush          14
        //  220  445:getstatic       #113 <Field Capabilities$Capability NUMERIC_CLASS>
        //  221  448:aastore         
        //  222  449:dup             
        //  223  450:bipush          15
        //  224  452:getstatic       #118 <Field Capabilities$Capability DATE_CLASS>
        //  225  455:aastore         
        //  226  456:dup             
        //  227  457:bipush          16
        //  228  459:getstatic       #123 <Field Capabilities$Capability STRING_CLASS>
        //  229  462:aastore         
        //  230  463:dup             
        //  231  464:bipush          17
        //  232  466:getstatic       #128 <Field Capabilities$Capability RELATIONAL_CLASS>
        //  233  469:aastore         
        //  234  470:dup             
        //  235  471:bipush          18
        //  236  473:getstatic       #133 <Field Capabilities$Capability MISSING_CLASS_VALUES>
        //  237  476:aastore         
        //  238  477:dup             
        //  239  478:bipush          19
        //  240  480:getstatic       #138 <Field Capabilities$Capability ONLY_MULTIINSTANCE>
        //  241  483:aastore         
        //  242  484:putstatic       #140 <Field Capabilities$Capability[] ENUM$VALUES>
        //* 243  487:return          
        }

        private Capability(String s, int i, int flags, String display)
        {
            super(s, i);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iload_2         
        //    3    3:invokespecial   #145 <Method void Enum(String, int)>
            m_Flags = 0;
        //    4    6:aload_0         
        //    5    7:iconst_0        
        //    6    8:putfield        #147 <Field int m_Flags>
            m_Flags = flags;
        //    7   11:aload_0         
        //    8   12:iload_3         
        //    9   13:putfield        #147 <Field int m_Flags>
            m_Display = display;
        //   10   16:aload_0         
        //   11   17:aload           4
        //   12   19:putfield        #149 <Field String m_Display>
        //   13   22:return          
        }
    }


    public Capabilities(CapabilitiesHandler owner)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #50  <Method void Object()>
        m_FailReason = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #52  <Field Exception m_FailReason>
        m_MinimumNumberInstances = 1;
    //    5    9:aload_0         
    //    6   10:iconst_1        
    //    7   11:putfield        #54  <Field int m_MinimumNumberInstances>
        setOwner(owner);
    //    8   14:aload_0         
    //    9   15:aload_1         
    //   10   16:invokevirtual   #57  <Method void setOwner(CapabilitiesHandler)>
        m_Capabilities = new HashSet();
    //   11   19:aload_0         
    //   12   20:new             #59  <Class HashSet>
    //   13   23:dup             
    //   14   24:invokespecial   #60  <Method void HashSet()>
    //   15   27:putfield        #62  <Field HashSet m_Capabilities>
        m_Dependencies = new HashSet();
    //   16   30:aload_0         
    //   17   31:new             #59  <Class HashSet>
    //   18   34:dup             
    //   19   35:invokespecial   #60  <Method void HashSet()>
    //   20   38:putfield        #64  <Field HashSet m_Dependencies>
        if(PROPERTIES == null)
    //*  21   41:getstatic       #66  <Field Properties PROPERTIES>
    //*  22   44:ifnonnull       73
            try
            {
                PROPERTIES = Utils.readProperties("rm/core/Capabilities.props");
    //   23   47:ldc1            #13  <String "rm/core/Capabilities.props">
    //   24   49:invokestatic    #72  <Method Properties Utils.readProperties(String)>
    //   25   52:putstatic       #66  <Field Properties PROPERTIES>
            }
    //*  26   55:goto            73
            catch(Exception e)
    //*  27   58:astore_2        
            {
                e.printStackTrace();
    //   28   59:aload_2         
    //   29   60:invokevirtual   #77  <Method void Exception.printStackTrace()>
                PROPERTIES = new Properties();
    //   30   63:new             #79  <Class Properties>
    //   31   66:dup             
    //   32   67:invokespecial   #80  <Method void Properties()>
    //   33   70:putstatic       #66  <Field Properties PROPERTIES>
            }
        m_Test = Boolean.parseBoolean(PROPERTIES.getProperty("Test", "true"));
    //   34   73:aload_0         
    //   35   74:getstatic       #66  <Field Properties PROPERTIES>
    //   36   77:ldc1            #82  <String "Test">
    //   37   79:ldc1            #84  <String "true">
    //   38   81:invokevirtual   #88  <Method String Properties.getProperty(String, String)>
    //   39   84:invokestatic    #94  <Method boolean Boolean.parseBoolean(String)>
    //   40   87:putfield        #96  <Field boolean m_Test>
        m_InstancesTest = Boolean.parseBoolean(PROPERTIES.getProperty("InstancesTest", "true")) && m_Test;
    //   41   90:aload_0         
    //   42   91:getstatic       #66  <Field Properties PROPERTIES>
    //   43   94:ldc1            #98  <String "InstancesTest">
    //   44   96:ldc1            #84  <String "true">
    //   45   98:invokevirtual   #88  <Method String Properties.getProperty(String, String)>
    //   46  101:invokestatic    #94  <Method boolean Boolean.parseBoolean(String)>
    //   47  104:ifeq            118
    //   48  107:aload_0         
    //   49  108:getfield        #96  <Field boolean m_Test>
    //   50  111:ifeq            118
    //   51  114:iconst_1        
    //   52  115:goto            119
    //   53  118:iconst_0        
    //   54  119:putfield        #100 <Field boolean m_InstancesTest>
        m_AttributeTest = Boolean.parseBoolean(PROPERTIES.getProperty("AttributeTest", "true")) && m_Test;
    //   55  122:aload_0         
    //   56  123:getstatic       #66  <Field Properties PROPERTIES>
    //   57  126:ldc1            #102 <String "AttributeTest">
    //   58  128:ldc1            #84  <String "true">
    //   59  130:invokevirtual   #88  <Method String Properties.getProperty(String, String)>
    //   60  133:invokestatic    #94  <Method boolean Boolean.parseBoolean(String)>
    //   61  136:ifeq            150
    //   62  139:aload_0         
    //   63  140:getfield        #96  <Field boolean m_Test>
    //   64  143:ifeq            150
    //   65  146:iconst_1        
    //   66  147:goto            151
    //   67  150:iconst_0        
    //   68  151:putfield        #104 <Field boolean m_AttributeTest>
        m_MissingValuesTest = Boolean.parseBoolean(PROPERTIES.getProperty("MissingValuesTest", "true")) && m_Test;
    //   69  154:aload_0         
    //   70  155:getstatic       #66  <Field Properties PROPERTIES>
    //   71  158:ldc1            #106 <String "MissingValuesTest">
    //   72  160:ldc1            #84  <String "true">
    //   73  162:invokevirtual   #88  <Method String Properties.getProperty(String, String)>
    //   74  165:invokestatic    #94  <Method boolean Boolean.parseBoolean(String)>
    //   75  168:ifeq            182
    //   76  171:aload_0         
    //   77  172:getfield        #96  <Field boolean m_Test>
    //   78  175:ifeq            182
    //   79  178:iconst_1        
    //   80  179:goto            183
    //   81  182:iconst_0        
    //   82  183:putfield        #108 <Field boolean m_MissingValuesTest>
        m_MissingClassValuesTest = Boolean.parseBoolean(PROPERTIES.getProperty("MissingClassValuesTest", "true")) && m_Test;
    //   83  186:aload_0         
    //   84  187:getstatic       #66  <Field Properties PROPERTIES>
    //   85  190:ldc1            #110 <String "MissingClassValuesTest">
    //   86  192:ldc1            #84  <String "true">
    //   87  194:invokevirtual   #88  <Method String Properties.getProperty(String, String)>
    //   88  197:invokestatic    #94  <Method boolean Boolean.parseBoolean(String)>
    //   89  200:ifeq            214
    //   90  203:aload_0         
    //   91  204:getfield        #96  <Field boolean m_Test>
    //   92  207:ifeq            214
    //   93  210:iconst_1        
    //   94  211:goto            215
    //   95  214:iconst_0        
    //   96  215:putfield        #112 <Field boolean m_MissingClassValuesTest>
        m_MinimumNumberInstancesTest = Boolean.parseBoolean(PROPERTIES.getProperty("MinimumNumberInstancesTest", "true")) && m_Test;
    //   97  218:aload_0         
    //   98  219:getstatic       #66  <Field Properties PROPERTIES>
    //   99  222:ldc1            #114 <String "MinimumNumberInstancesTest">
    //  100  224:ldc1            #84  <String "true">
    //  101  226:invokevirtual   #88  <Method String Properties.getProperty(String, String)>
    //  102  229:invokestatic    #94  <Method boolean Boolean.parseBoolean(String)>
    //  103  232:ifeq            246
    //  104  235:aload_0         
    //  105  236:getfield        #96  <Field boolean m_Test>
    //  106  239:ifeq            246
    //  107  242:iconst_1        
    //  108  243:goto            247
    //  109  246:iconst_0        
    //  110  247:putfield        #116 <Field boolean m_MinimumNumberInstancesTest>
    //  111  250:return          
    }

    public Object clone()
    {
        Capabilities result = new Capabilities(m_Owner);
    //    0    0:new             #2   <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #126 <Field CapabilitiesHandler m_Owner>
    //    4    8:invokespecial   #128 <Method void Capabilities(CapabilitiesHandler)>
    //    5   11:astore_1        
        result.assign(this);
    //    6   12:aload_1         
    //    7   13:aload_0         
    //    8   14:invokevirtual   #132 <Method void assign(Capabilities)>
        return result;
    //    9   17:aload_1         
    //   10   18:areturn         
    }

    public void assign(Capabilities c)
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          5
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_3        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           5
    //*   5    9:arraylength     
    //*   6   10:istore          4
    //*   7   12:goto            65
        {
            Capability cap = acapability[i];
    //    8   15:aload           5
    //    9   17:iload_3         
    //   10   18:aaload          
    //   11   19:astore_2        
            if(c.handles(cap))
    //*  12   20:aload_1         
    //*  13   21:aload_2         
    //*  14   22:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  15   25:ifeq            36
                enable(cap);
    //   16   28:aload_0         
    //   17   29:aload_2         
    //   18   30:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
            else
    //*  19   33:goto            41
                disable(cap);
    //   20   36:aload_0         
    //   21   37:aload_2         
    //   22   38:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
            if(c.hasDependency(cap))
    //*  23   41:aload_1         
    //*  24   42:aload_2         
    //*  25   43:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //*  26   46:ifeq            57
                enableDependency(cap);
    //   27   49:aload_0         
    //   28   50:aload_2         
    //   29   51:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
            else
    //*  30   54:goto            62
                disableDependency(cap);
    //   31   57:aload_0         
    //   32   58:aload_2         
    //   33   59:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        }

    //   34   62:iinc            3  1
    //   35   65:iload_3         
    //   36   66:iload           4
    //   37   68:icmplt          15
        setMinimumNumberInstances(c.getMinimumNumberInstances());
    //   38   71:aload_0         
    //   39   72:aload_1         
    //   40   73:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //   41   76:invokevirtual   #167 <Method void setMinimumNumberInstances(int)>
    //   42   79:return          
    }

    public void and(Capabilities c)
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          5
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_3        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           5
    //*   5    9:arraylength     
    //*   6   10:istore          4
    //*   7   12:goto            97
        {
            Capability cap = acapability[i];
    //    8   15:aload           5
    //    9   17:iload_3         
    //   10   18:aaload          
    //   11   19:astore_2        
            if(handles(cap) && c.handles(cap))
    //*  12   20:aload_0         
    //*  13   21:aload_2         
    //*  14   22:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  15   25:ifeq            48
    //*  16   28:aload_1         
    //*  17   29:aload_2         
    //*  18   30:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  19   33:ifeq            48
                m_Capabilities.add(cap);
    //   20   36:aload_0         
    //   21   37:getfield        #62  <Field HashSet m_Capabilities>
    //   22   40:aload_2         
    //   23   41:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   24   44:pop             
            else
    //*  25   45:goto            57
                m_Capabilities.remove(cap);
    //   26   48:aload_0         
    //   27   49:getfield        #62  <Field HashSet m_Capabilities>
    //   28   52:aload_2         
    //   29   53:invokevirtual   #178 <Method boolean HashSet.remove(Object)>
    //   30   56:pop             
            if(hasDependency(cap) && c.hasDependency(cap))
    //*  31   57:aload_0         
    //*  32   58:aload_2         
    //*  33   59:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //*  34   62:ifeq            85
    //*  35   65:aload_1         
    //*  36   66:aload_2         
    //*  37   67:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //*  38   70:ifeq            85
                m_Dependencies.add(cap);
    //   39   73:aload_0         
    //   40   74:getfield        #64  <Field HashSet m_Dependencies>
    //   41   77:aload_2         
    //   42   78:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   43   81:pop             
            else
    //*  44   82:goto            94
                m_Dependencies.remove(cap);
    //   45   85:aload_0         
    //   46   86:getfield        #64  <Field HashSet m_Dependencies>
    //   47   89:aload_2         
    //   48   90:invokevirtual   #178 <Method boolean HashSet.remove(Object)>
    //   49   93:pop             
        }

    //   50   94:iinc            3  1
    //   51   97:iload_3         
    //   52   98:iload           4
    //   53  100:icmplt          15
        if(c.getMinimumNumberInstances() > getMinimumNumberInstances())
    //*  54  103:aload_1         
    //*  55  104:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //*  56  107:aload_0         
    //*  57  108:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //*  58  111:icmple          122
            setMinimumNumberInstances(c.getMinimumNumberInstances());
    //   59  114:aload_0         
    //   60  115:aload_1         
    //   61  116:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //   62  119:invokevirtual   #167 <Method void setMinimumNumberInstances(int)>
    //   63  122:return          
    }

    public void or(Capabilities c)
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          5
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_3        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           5
    //*   5    9:arraylength     
    //*   6   10:istore          4
    //*   7   12:goto            97
        {
            Capability cap = acapability[i];
    //    8   15:aload           5
    //    9   17:iload_3         
    //   10   18:aaload          
    //   11   19:astore_2        
            if(handles(cap) || c.handles(cap))
    //*  12   20:aload_0         
    //*  13   21:aload_2         
    //*  14   22:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  15   25:ifne            36
    //*  16   28:aload_1         
    //*  17   29:aload_2         
    //*  18   30:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  19   33:ifeq            48
                m_Capabilities.add(cap);
    //   20   36:aload_0         
    //   21   37:getfield        #62  <Field HashSet m_Capabilities>
    //   22   40:aload_2         
    //   23   41:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   24   44:pop             
            else
    //*  25   45:goto            57
                m_Capabilities.remove(cap);
    //   26   48:aload_0         
    //   27   49:getfield        #62  <Field HashSet m_Capabilities>
    //   28   52:aload_2         
    //   29   53:invokevirtual   #178 <Method boolean HashSet.remove(Object)>
    //   30   56:pop             
            if(hasDependency(cap) || c.hasDependency(cap))
    //*  31   57:aload_0         
    //*  32   58:aload_2         
    //*  33   59:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //*  34   62:ifne            73
    //*  35   65:aload_1         
    //*  36   66:aload_2         
    //*  37   67:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //*  38   70:ifeq            85
                m_Dependencies.add(cap);
    //   39   73:aload_0         
    //   40   74:getfield        #64  <Field HashSet m_Dependencies>
    //   41   77:aload_2         
    //   42   78:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   43   81:pop             
            else
    //*  44   82:goto            94
                m_Dependencies.remove(cap);
    //   45   85:aload_0         
    //   46   86:getfield        #64  <Field HashSet m_Dependencies>
    //   47   89:aload_2         
    //   48   90:invokevirtual   #178 <Method boolean HashSet.remove(Object)>
    //   49   93:pop             
        }

    //   50   94:iinc            3  1
    //   51   97:iload_3         
    //   52   98:iload           4
    //   53  100:icmplt          15
        if(c.getMinimumNumberInstances() < getMinimumNumberInstances())
    //*  54  103:aload_1         
    //*  55  104:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //*  56  107:aload_0         
    //*  57  108:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //*  58  111:icmpge          122
            setMinimumNumberInstances(c.getMinimumNumberInstances());
    //   59  114:aload_0         
    //   60  115:aload_1         
    //   61  116:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //   62  119:invokevirtual   #167 <Method void setMinimumNumberInstances(int)>
    //   63  122:return          
    }

    public boolean supports(Capabilities c)
    {
        boolean result = true;
    //    0    0:iconst_1        
    //    1    1:istore_2        
        Capability acapability[] = Capability.values();
    //    2    2:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    3    5:astore          6
        int i = 0;
    //    4    7:iconst_0        
    //    5    8:istore          4
        for(int j = acapability.length; i < j; i++)
    //*   6   10:aload           6
    //*   7   12:arraylength     
    //*   8   13:istore          5
    //*   9   15:goto            48
        {
            Capability cap = acapability[i];
    //   10   18:aload           6
    //   11   20:iload           4
    //   12   22:aaload          
    //   13   23:astore_3        
            if(!c.handles(cap) || handles(cap))
                continue;
    //   14   24:aload_1         
    //   15   25:aload_3         
    //   16   26:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //   17   29:ifeq            45
    //   18   32:aload_0         
    //   19   33:aload_3         
    //   20   34:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //   21   37:ifne            45
            result = false;
    //   22   40:iconst_0        
    //   23   41:istore_2        
            break;
    //   24   42:goto            55
        }

    //   25   45:iinc            4  1
    //   26   48:iload           4
    //   27   50:iload           5
    //   28   52:icmplt          18
        return result;
    //   29   55:iload_2         
    //   30   56:ireturn         
    }

    public boolean supportsMaybe(Capabilities c)
    {
        boolean result = true;
    //    0    0:iconst_1        
    //    1    1:istore_2        
        Capability acapability[] = Capability.values();
    //    2    2:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    3    5:astore          6
        int i = 0;
    //    4    7:iconst_0        
    //    5    8:istore          4
        for(int j = acapability.length; i < j; i++)
    //*   6   10:aload           6
    //*   7   12:arraylength     
    //*   8   13:istore          5
    //*   9   15:goto            56
        {
            Capability cap = acapability[i];
    //   10   18:aload           6
    //   11   20:iload           4
    //   12   22:aaload          
    //   13   23:astore_3        
            if(!c.handles(cap) || handles(cap) || hasDependency(cap))
                continue;
    //   14   24:aload_1         
    //   15   25:aload_3         
    //   16   26:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //   17   29:ifeq            53
    //   18   32:aload_0         
    //   19   33:aload_3         
    //   20   34:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //   21   37:ifne            53
    //   22   40:aload_0         
    //   23   41:aload_3         
    //   24   42:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //   25   45:ifne            53
            result = false;
    //   26   48:iconst_0        
    //   27   49:istore_2        
            break;
    //   28   50:goto            63
        }

    //   29   53:iinc            4  1
    //   30   56:iload           4
    //   31   58:iload           5
    //   32   60:icmplt          18
        return result;
    //   33   63:iload_2         
    //   34   64:ireturn         
    }

    public void setOwner(CapabilitiesHandler value)
    {
        m_Owner = value;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #126 <Field CapabilitiesHandler m_Owner>
    //    3    5:return          
    }

    public CapabilitiesHandler getOwner()
    {
        return m_Owner;
    //    0    0:aload_0         
    //    1    1:getfield        #126 <Field CapabilitiesHandler m_Owner>
    //    2    4:areturn         
    }

    public void setMinimumNumberInstances(int value)
    {
        if(value >= 0)
    //*   0    0:iload_1         
    //*   1    1:iflt            9
            m_MinimumNumberInstances = value;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #54  <Field int m_MinimumNumberInstances>
    //    5    9:return          
    }

    public int getMinimumNumberInstances()
    {
        return m_MinimumNumberInstances;
    //    0    0:aload_0         
    //    1    1:getfield        #54  <Field int m_MinimumNumberInstances>
    //    2    4:ireturn         
    }

    public Iterator capabilities()
    {
        return m_Capabilities.iterator();
    //    0    0:aload_0         
    //    1    1:getfield        #62  <Field HashSet m_Capabilities>
    //    2    4:invokevirtual   #190 <Method Iterator HashSet.iterator()>
    //    3    7:areturn         
    }

    public Iterator dependencies()
    {
        return m_Dependencies.iterator();
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field HashSet m_Dependencies>
    //    2    4:invokevirtual   #190 <Method Iterator HashSet.iterator()>
    //    3    7:areturn         
    }

    public void enable(Capability c)
    {
        if(c == Capability.NOMINAL_ATTRIBUTES)
    //*   0    0:aload_1         
    //*   1    1:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //*   2    4:if_acmpne       17
            enable(Capability.BINARY_ATTRIBUTES);
    //    3    7:aload_0         
    //    4    8:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //    5   11:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        else
    //*   6   14:goto            65
        if(c == Capability.BINARY_ATTRIBUTES)
    //*   7   17:aload_1         
    //*   8   18:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //*   9   21:if_acmpne       34
            enable(Capability.UNARY_ATTRIBUTES);
    //   10   24:aload_0         
    //   11   25:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //   12   28:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        else
    //*  13   31:goto            65
        if(c == Capability.UNARY_ATTRIBUTES)
    //*  14   34:aload_1         
    //*  15   35:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //*  16   38:if_acmpne       51
            enable(Capability.EMPTY_NOMINAL_ATTRIBUTES);
    //   17   41:aload_0         
    //   18   42:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //   19   45:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        else
    //*  20   48:goto            65
        if(c == Capability.NOMINAL_CLASS)
    //*  21   51:aload_1         
    //*  22   52:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //*  23   55:if_acmpne       65
            enable(Capability.BINARY_CLASS);
    //   24   58:aload_0         
    //   25   59:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //   26   62:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        m_Capabilities.add(c);
    //   27   65:aload_0         
    //   28   66:getfield        #62  <Field HashSet m_Capabilities>
    //   29   69:aload_1         
    //   30   70:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   31   73:pop             
    //   32   74:return          
    }

    public void enableDependency(Capability c)
    {
        if(c == Capability.NOMINAL_ATTRIBUTES)
    //*   0    0:aload_1         
    //*   1    1:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //*   2    4:if_acmpne       17
            enableDependency(Capability.BINARY_ATTRIBUTES);
    //    3    7:aload_0         
    //    4    8:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //    5   11:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
        else
    //*   6   14:goto            65
        if(c == Capability.BINARY_ATTRIBUTES)
    //*   7   17:aload_1         
    //*   8   18:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //*   9   21:if_acmpne       34
            enableDependency(Capability.UNARY_ATTRIBUTES);
    //   10   24:aload_0         
    //   11   25:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //   12   28:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
        else
    //*  13   31:goto            65
        if(c == Capability.UNARY_ATTRIBUTES)
    //*  14   34:aload_1         
    //*  15   35:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //*  16   38:if_acmpne       51
            enableDependency(Capability.EMPTY_NOMINAL_ATTRIBUTES);
    //   17   41:aload_0         
    //   18   42:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //   19   45:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
        else
    //*  20   48:goto            65
        if(c == Capability.NOMINAL_CLASS)
    //*  21   51:aload_1         
    //*  22   52:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //*  23   55:if_acmpne       65
            enableDependency(Capability.BINARY_CLASS);
    //   24   58:aload_0         
    //   25   59:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //   26   62:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
        m_Dependencies.add(c);
    //   27   65:aload_0         
    //   28   66:getfield        #64  <Field HashSet m_Dependencies>
    //   29   69:aload_1         
    //   30   70:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   31   73:pop             
    //   32   74:return          
    }

    public void enableAllClasses()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isClass())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #214 <Method boolean Capabilities$Capability.isClass()>
    //*  14   23:ifeq            31
                enable(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void enableAllClassDependencies()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isClass())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #214 <Method boolean Capabilities$Capability.isClass()>
    //*  14   23:ifeq            31
                enableDependency(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void enableAllAttributes()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isAttribute())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #219 <Method boolean Capabilities$Capability.isAttribute()>
    //*  14   23:ifeq            31
                enable(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void enableAllAttributeDependencies()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isAttribute())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #219 <Method boolean Capabilities$Capability.isAttribute()>
    //*  14   23:ifeq            31
                enableDependency(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #156 <Method void enableDependency(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void enableAll()
    {
        enableAllAttributes();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #223 <Method void enableAllAttributes()>
        enableAllAttributeDependencies();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #225 <Method void enableAllAttributeDependencies()>
        enableAllClasses();
    //    4    8:aload_0         
    //    5    9:invokevirtual   #227 <Method void enableAllClasses()>
        enableAllClassDependencies();
    //    6   12:aload_0         
    //    7   13:invokevirtual   #229 <Method void enableAllClassDependencies()>
        enable(Capability.MISSING_VALUES);
    //    8   16:aload_0         
    //    9   17:getstatic       #232 <Field Capabilities$Capability Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        enable(Capability.MISSING_CLASS_VALUES);
    //   11   23:aload_0         
    //   12   24:getstatic       #235 <Field Capabilities$Capability Capabilities$Capability.MISSING_CLASS_VALUES>
    //   13   27:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
    //   14   30:return          
    }

    public void disable(Capability c)
    {
        if(c == Capability.NOMINAL_ATTRIBUTES)
    //*   0    0:aload_1         
    //*   1    1:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //*   2    4:if_acmpne       17
            disable(Capability.BINARY_ATTRIBUTES);
    //    3    7:aload_0         
    //    4    8:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //    5   11:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        else
    //*   6   14:goto            99
        if(c == Capability.BINARY_ATTRIBUTES)
    //*   7   17:aload_1         
    //*   8   18:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //*   9   21:if_acmpne       34
            disable(Capability.UNARY_ATTRIBUTES);
    //   10   24:aload_0         
    //   11   25:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //   12   28:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        else
    //*  13   31:goto            99
        if(c == Capability.UNARY_ATTRIBUTES)
    //*  14   34:aload_1         
    //*  15   35:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //*  16   38:if_acmpne       51
            disable(Capability.EMPTY_NOMINAL_ATTRIBUTES);
    //   17   41:aload_0         
    //   18   42:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //   19   45:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        else
    //*  20   48:goto            99
        if(c == Capability.NOMINAL_CLASS)
    //*  21   51:aload_1         
    //*  22   52:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //*  23   55:if_acmpne       68
            disable(Capability.BINARY_CLASS);
    //   24   58:aload_0         
    //   25   59:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //   26   62:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        else
    //*  27   65:goto            99
        if(c == Capability.BINARY_CLASS)
    //*  28   68:aload_1         
    //*  29   69:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //*  30   72:if_acmpne       85
            disable(Capability.UNARY_CLASS);
    //   31   75:aload_0         
    //   32   76:getstatic       #238 <Field Capabilities$Capability Capabilities$Capability.UNARY_CLASS>
    //   33   79:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        else
    //*  34   82:goto            99
        if(c == Capability.UNARY_CLASS)
    //*  35   85:aload_1         
    //*  36   86:getstatic       #238 <Field Capabilities$Capability Capabilities$Capability.UNARY_CLASS>
    //*  37   89:if_acmpne       99
            disable(Capability.EMPTY_NOMINAL_CLASS);
    //   38   92:aload_0         
    //   39   93:getstatic       #241 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_CLASS>
    //   40   96:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        m_Capabilities.remove(c);
    //   41   99:aload_0         
    //   42  100:getfield        #62  <Field HashSet m_Capabilities>
    //   43  103:aload_1         
    //   44  104:invokevirtual   #178 <Method boolean HashSet.remove(Object)>
    //   45  107:pop             
    //   46  108:return          
    }

    public void disableDependency(Capability c)
    {
        if(c == Capability.NOMINAL_ATTRIBUTES)
    //*   0    0:aload_1         
    //*   1    1:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //*   2    4:if_acmpne       17
            disableDependency(Capability.BINARY_ATTRIBUTES);
    //    3    7:aload_0         
    //    4    8:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //    5   11:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        else
    //*   6   14:goto            99
        if(c == Capability.BINARY_ATTRIBUTES)
    //*   7   17:aload_1         
    //*   8   18:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //*   9   21:if_acmpne       34
            disableDependency(Capability.UNARY_ATTRIBUTES);
    //   10   24:aload_0         
    //   11   25:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //   12   28:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        else
    //*  13   31:goto            99
        if(c == Capability.UNARY_ATTRIBUTES)
    //*  14   34:aload_1         
    //*  15   35:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //*  16   38:if_acmpne       51
            disableDependency(Capability.EMPTY_NOMINAL_ATTRIBUTES);
    //   17   41:aload_0         
    //   18   42:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //   19   45:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        else
    //*  20   48:goto            99
        if(c == Capability.NOMINAL_CLASS)
    //*  21   51:aload_1         
    //*  22   52:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //*  23   55:if_acmpne       68
            disableDependency(Capability.BINARY_CLASS);
    //   24   58:aload_0         
    //   25   59:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //   26   62:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        else
    //*  27   65:goto            99
        if(c == Capability.BINARY_CLASS)
    //*  28   68:aload_1         
    //*  29   69:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //*  30   72:if_acmpne       85
            disableDependency(Capability.UNARY_CLASS);
    //   31   75:aload_0         
    //   32   76:getstatic       #238 <Field Capabilities$Capability Capabilities$Capability.UNARY_CLASS>
    //   33   79:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        else
    //*  34   82:goto            99
        if(c == Capability.UNARY_CLASS)
    //*  35   85:aload_1         
    //*  36   86:getstatic       #238 <Field Capabilities$Capability Capabilities$Capability.UNARY_CLASS>
    //*  37   89:if_acmpne       99
            disableDependency(Capability.EMPTY_NOMINAL_CLASS);
    //   38   92:aload_0         
    //   39   93:getstatic       #241 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_CLASS>
    //   40   96:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        m_Dependencies.remove(c);
    //   41   99:aload_0         
    //   42  100:getfield        #64  <Field HashSet m_Dependencies>
    //   43  103:aload_1         
    //   44  104:invokevirtual   #178 <Method boolean HashSet.remove(Object)>
    //   45  107:pop             
    //   46  108:return          
    }

    public void disableAllClasses()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isClass())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #214 <Method boolean Capabilities$Capability.isClass()>
    //*  14   23:ifeq            31
                disable(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void disableAllClassDependencies()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isClass())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #214 <Method boolean Capabilities$Capability.isClass()>
    //*  14   23:ifeq            31
                disableDependency(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void disableAllAttributes()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isAttribute())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #219 <Method boolean Capabilities$Capability.isAttribute()>
    //*  14   23:ifeq            31
                disable(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void disableAllAttributeDependencies()
    {
        Capability acapability[] = Capability.values();
    //    0    0:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    1    3:astore          4
        int i = 0;
    //    2    5:iconst_0        
    //    3    6:istore_2        
        for(int j = acapability.length; i < j; i++)
    //*   4    7:aload           4
    //*   5    9:arraylength     
    //*   6   10:istore_3        
    //*   7   11:goto            34
        {
            Capability cap = acapability[i];
    //    8   14:aload           4
    //    9   16:iload_2         
    //   10   17:aaload          
    //   11   18:astore_1        
            if(cap.isAttribute())
    //*  12   19:aload_1         
    //*  13   20:invokevirtual   #219 <Method boolean Capabilities$Capability.isAttribute()>
    //*  14   23:ifeq            31
                disableDependency(cap);
    //   15   26:aload_0         
    //   16   27:aload_1         
    //   17   28:invokevirtual   #159 <Method void disableDependency(Capabilities$Capability)>
        }

    //   18   31:iinc            2  1
    //   19   34:iload_2         
    //   20   35:iload_3         
    //   21   36:icmplt          14
    //   22   39:return          
    }

    public void disableAll()
    {
        disableAllAttributes();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #248 <Method void disableAllAttributes()>
        disableAllAttributeDependencies();
    //    2    4:aload_0         
    //    3    5:invokevirtual   #250 <Method void disableAllAttributeDependencies()>
        disableAllClasses();
    //    4    8:aload_0         
    //    5    9:invokevirtual   #252 <Method void disableAllClasses()>
        disableAllClassDependencies();
    //    6   12:aload_0         
    //    7   13:invokevirtual   #254 <Method void disableAllClassDependencies()>
        disable(Capability.MISSING_VALUES);
    //    8   16:aload_0         
    //    9   17:getstatic       #232 <Field Capabilities$Capability Capabilities$Capability.MISSING_VALUES>
    //   10   20:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        disable(Capability.MISSING_CLASS_VALUES);
    //   11   23:aload_0         
    //   12   24:getstatic       #235 <Field Capabilities$Capability Capabilities$Capability.MISSING_CLASS_VALUES>
    //   13   27:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
        disable(Capability.NO_CLASS);
    //   14   30:aload_0         
    //   15   31:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //   16   34:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
    //   17   37:return          
    }

    public Capabilities getClassCapabilities()
    {
        Capabilities result = new Capabilities(getOwner());
    //    0    0:new             #2   <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //    4    8:invokespecial   #128 <Method void Capabilities(CapabilitiesHandler)>
    //    5   11:astore_1        
        Capability acapability[] = Capability.values();
    //    6   12:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    7   15:astore          5
        int i = 0;
    //    8   17:iconst_0        
    //    9   18:istore_3        
        for(int j = acapability.length; i < j; i++)
    //*  10   19:aload           5
    //*  11   21:arraylength     
    //*  12   22:istore          4
    //*  13   24:goto            59
        {
            Capability cap = acapability[i];
    //   14   27:aload           5
    //   15   29:iload_3         
    //   16   30:aaload          
    //   17   31:astore_2        
            if(cap.isClassCapability() && handles(cap))
    //*  18   32:aload_2         
    //*  19   33:invokevirtual   #264 <Method boolean Capabilities$Capability.isClassCapability()>
    //*  20   36:ifeq            56
    //*  21   39:aload_0         
    //*  22   40:aload_2         
    //*  23   41:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  24   44:ifeq            56
                result.m_Capabilities.add(cap);
    //   25   47:aload_1         
    //   26   48:getfield        #62  <Field HashSet m_Capabilities>
    //   27   51:aload_2         
    //   28   52:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   29   55:pop             
        }

    //   30   56:iinc            3  1
    //   31   59:iload_3         
    //   32   60:iload           4
    //   33   62:icmplt          27
        return result;
    //   34   65:aload_1         
    //   35   66:areturn         
    }

    public Capabilities getAttributeCapabilities()
    {
        Capabilities result = new Capabilities(getOwner());
    //    0    0:new             #2   <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //    4    8:invokespecial   #128 <Method void Capabilities(CapabilitiesHandler)>
    //    5   11:astore_1        
        Capability acapability[] = Capability.values();
    //    6   12:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    7   15:astore          5
        int i = 0;
    //    8   17:iconst_0        
    //    9   18:istore_3        
        for(int j = acapability.length; i < j; i++)
    //*  10   19:aload           5
    //*  11   21:arraylength     
    //*  12   22:istore          4
    //*  13   24:goto            59
        {
            Capability cap = acapability[i];
    //   14   27:aload           5
    //   15   29:iload_3         
    //   16   30:aaload          
    //   17   31:astore_2        
            if(cap.isAttributeCapability() && handles(cap))
    //*  18   32:aload_2         
    //*  19   33:invokevirtual   #268 <Method boolean Capabilities$Capability.isAttributeCapability()>
    //*  20   36:ifeq            56
    //*  21   39:aload_0         
    //*  22   40:aload_2         
    //*  23   41:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  24   44:ifeq            56
                result.m_Capabilities.add(cap);
    //   25   47:aload_1         
    //   26   48:getfield        #62  <Field HashSet m_Capabilities>
    //   27   51:aload_2         
    //   28   52:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   29   55:pop             
        }

    //   30   56:iinc            3  1
    //   31   59:iload_3         
    //   32   60:iload           4
    //   33   62:icmplt          27
        return result;
    //   34   65:aload_1         
    //   35   66:areturn         
    }

    public Capabilities getOtherCapabilities()
    {
        Capabilities result = new Capabilities(getOwner());
    //    0    0:new             #2   <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //    4    8:invokespecial   #128 <Method void Capabilities(CapabilitiesHandler)>
    //    5   11:astore_1        
        Capability acapability[] = Capability.values();
    //    6   12:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //    7   15:astore          5
        int i = 0;
    //    8   17:iconst_0        
    //    9   18:istore_3        
        for(int j = acapability.length; i < j; i++)
    //*  10   19:aload           5
    //*  11   21:arraylength     
    //*  12   22:istore          4
    //*  13   24:goto            59
        {
            Capability cap = acapability[i];
    //   14   27:aload           5
    //   15   29:iload_3         
    //   16   30:aaload          
    //   17   31:astore_2        
            if(cap.isOtherCapability() && handles(cap))
    //*  18   32:aload_2         
    //*  19   33:invokevirtual   #272 <Method boolean Capabilities$Capability.isOtherCapability()>
    //*  20   36:ifeq            56
    //*  21   39:aload_0         
    //*  22   40:aload_2         
    //*  23   41:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  24   44:ifeq            56
                result.m_Capabilities.add(cap);
    //   25   47:aload_1         
    //   26   48:getfield        #62  <Field HashSet m_Capabilities>
    //   27   51:aload_2         
    //   28   52:invokevirtual   #175 <Method boolean HashSet.add(Object)>
    //   29   55:pop             
        }

    //   30   56:iinc            3  1
    //   31   59:iload_3         
    //   32   60:iload           4
    //   33   62:icmplt          27
        return result;
    //   34   65:aload_1         
    //   35   66:areturn         
    }

    public boolean handles(Capability c)
    {
        return m_Capabilities.contains(c);
    //    0    0:aload_0         
    //    1    1:getfield        #62  <Field HashSet m_Capabilities>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #275 <Method boolean HashSet.contains(Object)>
    //    4    8:ireturn         
    }

    public boolean hasDependency(Capability c)
    {
        return m_Dependencies.contains(c);
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field HashSet m_Dependencies>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #275 <Method boolean HashSet.contains(Object)>
    //    4    8:ireturn         
    }

    public boolean hasDependencies()
    {
        return m_Dependencies.size() > 0;
    //    0    0:aload_0         
    //    1    1:getfield        #64  <Field HashSet m_Dependencies>
    //    2    4:invokevirtual   #279 <Method int HashSet.size()>
    //    3    7:ifle            12
    //    4   10:iconst_1        
    //    5   11:ireturn         
    //    6   12:iconst_0        
    //    7   13:ireturn         
    }

    public Exception getFailReason()
    {
        return m_FailReason;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field Exception m_FailReason>
    //    2    4:areturn         
    }

    protected String createMessage(String msg)
    {
        String result = "";
    //    0    0:ldc2            #285 <String "">
    //    1    3:astore_2        
        if(getOwner() != null)
    //*   2    4:aload_0         
    //*   3    5:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //*   4    8:ifnull          25
            result = getOwner().getClass().getName();
    //    5   11:aload_0         
    //    6   12:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //    7   15:invokevirtual   #289 <Method Class Object.getClass()>
    //    8   18:invokevirtual   #295 <Method String Class.getName()>
    //    9   21:astore_2        
        else
    //*  10   22:goto            29
            result = "<anonymous>";
    //   11   25:ldc2            #297 <String "<anonymous>">
    //   12   28:astore_2        
        result = (new StringBuilder(String.valueOf(result))).append(": ").append(msg).toString();
    //   13   29:new             #299 <Class StringBuilder>
    //   14   32:dup             
    //   15   33:aload_2         
    //   16   34:invokestatic    #305 <Method String String.valueOf(Object)>
    //   17   37:invokespecial   #308 <Method void StringBuilder(String)>
    //   18   40:ldc2            #310 <String ": ">
    //   19   43:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   20   46:aload_1         
    //   21   47:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   22   50:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   23   53:astore_2        
        return result;
    //   24   54:aload_2         
    //   25   55:areturn         
    }

    public boolean test(Attribute att)
    {
        return test(att, false);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_0        
    //    3    3:invokevirtual   #323 <Method boolean test(Attribute, boolean)>
    //    4    6:ireturn         
    }

    public boolean test(Attribute att, boolean isClass)
    {
        boolean result = true;
    //    0    0:iconst_1        
    //    1    1:istore_3        
        if(!m_AttributeTest)
    //*   2    2:aload_0         
    //*   3    3:getfield        #104 <Field boolean m_AttributeTest>
    //*   4    6:ifne            11
            return result;
    //    5    9:iload_3         
    //    6   10:ireturn         
        String errorStr;
        if(isClass)
    //*   7   11:iload_2         
    //*   8   12:ifeq            23
            errorStr = "class";
    //    9   15:ldc2            #327 <String "class">
    //   10   18:astore          8
        else
    //*  11   20:goto            28
            errorStr = "attributes";
    //   12   23:ldc2            #329 <String "attributes">
    //   13   26:astore          8
        switch(att.type())
    //*  14   28:aload_1         
    //*  15   29:invokevirtual   #334 <Method int Attribute.type()>
        {
    //*  16   32:tableswitch     0 4: default 670
    //                   0 390
    //                   1 68
    //                   2 530
    //                   3 460
    //                   4 600
        case 1: // '\001'
        {
            Capability cap;
            Capability capBinary;
            Capability capUnary;
            Capability capEmpty;
            if(isClass)
    //*  17   68:iload_2         
    //*  18   69:ifeq            95
            {
                cap = Capability.NOMINAL_CLASS;
    //   19   72:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //   20   75:astore          4
                capBinary = Capability.BINARY_CLASS;
    //   21   77:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //   22   80:astore          5
                capUnary = Capability.UNARY_CLASS;
    //   23   82:getstatic       #238 <Field Capabilities$Capability Capabilities$Capability.UNARY_CLASS>
    //   24   85:astore          6
                capEmpty = Capability.EMPTY_NOMINAL_CLASS;
    //   25   87:getstatic       #241 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_CLASS>
    //   26   90:astore          7
            } else
    //*  27   92:goto            115
            {
                cap = Capability.NOMINAL_ATTRIBUTES;
    //   28   95:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //   29   98:astore          4
                capBinary = Capability.BINARY_ATTRIBUTES;
    //   30  100:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //   31  103:astore          5
                capUnary = Capability.UNARY_ATTRIBUTES;
    //   32  105:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //   33  108:astore          6
                capEmpty = Capability.EMPTY_NOMINAL_ATTRIBUTES;
    //   34  110:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //   35  113:astore          7
            }
            if((!handles(cap) || att.numValues() <= 2) && (!handles(capBinary) || att.numValues() != 2) && (!handles(capUnary) || att.numValues() != 1) && (!handles(capEmpty) || att.numValues() != 0))
    //*  36  115:aload_0         
    //*  37  116:aload           4
    //*  38  118:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  39  121:ifeq            135
    //*  40  124:aload_1         
    //*  41  125:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  42  128:iconst_2        
    //*  43  129:icmple          135
    //*  44  132:goto            713
    //*  45  135:aload_0         
    //*  46  136:aload           5
    //*  47  138:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  48  141:ifeq            155
    //*  49  144:aload_1         
    //*  50  145:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  51  148:iconst_2        
    //*  52  149:icmpne          155
    //*  53  152:goto            713
    //*  54  155:aload_0         
    //*  55  156:aload           6
    //*  56  158:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  57  161:ifeq            175
    //*  58  164:aload_1         
    //*  59  165:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  60  168:iconst_1        
    //*  61  169:icmpne          175
    //*  62  172:goto            713
    //*  63  175:aload_0         
    //*  64  176:aload           7
    //*  65  178:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  66  181:ifeq            194
    //*  67  184:aload_1         
    //*  68  185:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  69  188:ifne            194
    //*  70  191:goto            713
            {
                if(att.numValues() == 0)
    //*  71  194:aload_1         
    //*  72  195:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  73  198:ifne            242
                {
                    m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle empty nominal ")).append(errorStr).append("!").toString()));
    //   74  201:aload_0         
    //   75  202:new             #339 <Class UnsupportedAttributeTypeException>
    //   76  205:dup             
    //   77  206:aload_0         
    //   78  207:new             #299 <Class StringBuilder>
    //   79  210:dup             
    //   80  211:ldc2            #341 <String "Cannot handle empty nominal ">
    //   81  214:invokespecial   #308 <Method void StringBuilder(String)>
    //   82  217:aload           8
    //   83  219:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   84  222:ldc2            #343 <String "!">
    //   85  225:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   86  228:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   87  231:invokevirtual   #345 <Method String createMessage(String)>
    //   88  234:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //   89  237:putfield        #52  <Field Exception m_FailReason>
                    result = false;
    //   90  240:iconst_0        
    //   91  241:istore_3        
                }
                if(att.numValues() == 1)
    //*  92  242:aload_1         
    //*  93  243:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  94  246:iconst_1        
    //*  95  247:icmpne          294
                {
                    m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle unary ")).append(errorStr).append("!").toString()));
    //   96  250:aload_0         
    //   97  251:new             #339 <Class UnsupportedAttributeTypeException>
    //   98  254:dup             
    //   99  255:aload_0         
    //  100  256:new             #299 <Class StringBuilder>
    //  101  259:dup             
    //  102  260:ldc2            #348 <String "Cannot handle unary ">
    //  103  263:invokespecial   #308 <Method void StringBuilder(String)>
    //  104  266:aload           8
    //  105  268:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  106  271:ldc2            #343 <String "!">
    //  107  274:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  108  277:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  109  280:invokevirtual   #345 <Method String createMessage(String)>
    //  110  283:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  111  286:putfield        #52  <Field Exception m_FailReason>
                    result = false;
    //  112  289:iconst_0        
    //  113  290:istore_3        
                } else
    //* 114  291:goto            713
                if(att.numValues() == 2)
    //* 115  294:aload_1         
    //* 116  295:invokevirtual   #337 <Method int Attribute.numValues()>
    //* 117  298:iconst_2        
    //* 118  299:icmpne          346
                {
                    m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle binary ")).append(errorStr).append("!").toString()));
    //  119  302:aload_0         
    //  120  303:new             #339 <Class UnsupportedAttributeTypeException>
    //  121  306:dup             
    //  122  307:aload_0         
    //  123  308:new             #299 <Class StringBuilder>
    //  124  311:dup             
    //  125  312:ldc2            #350 <String "Cannot handle binary ">
    //  126  315:invokespecial   #308 <Method void StringBuilder(String)>
    //  127  318:aload           8
    //  128  320:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  129  323:ldc2            #343 <String "!">
    //  130  326:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  131  329:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  132  332:invokevirtual   #345 <Method String createMessage(String)>
    //  133  335:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  134  338:putfield        #52  <Field Exception m_FailReason>
                    result = false;
    //  135  341:iconst_0        
    //  136  342:istore_3        
                } else
    //* 137  343:goto            713
                {
                    m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle multi-valued nominal ")).append(errorStr).append("!").toString()));
    //  138  346:aload_0         
    //  139  347:new             #339 <Class UnsupportedAttributeTypeException>
    //  140  350:dup             
    //  141  351:aload_0         
    //  142  352:new             #299 <Class StringBuilder>
    //  143  355:dup             
    //  144  356:ldc2            #352 <String "Cannot handle multi-valued nominal ">
    //  145  359:invokespecial   #308 <Method void StringBuilder(String)>
    //  146  362:aload           8
    //  147  364:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  148  367:ldc2            #343 <String "!">
    //  149  370:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  150  373:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  151  376:invokevirtual   #345 <Method String createMessage(String)>
    //  152  379:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  153  382:putfield        #52  <Field Exception m_FailReason>
                    result = false;
    //  154  385:iconst_0        
    //  155  386:istore_3        
                }
            }
            break;
    //  156  387:goto            713
        }

        case 0: // '\0'
        {
            Capability cap;
            if(isClass)
    //* 157  390:iload_2         
    //* 158  391:ifeq            402
                cap = Capability.NUMERIC_CLASS;
    //  159  394:getstatic       #355 <Field Capabilities$Capability Capabilities$Capability.NUMERIC_CLASS>
    //  160  397:astore          4
            else
    //* 161  399:goto            407
                cap = Capability.NUMERIC_ATTRIBUTES;
    //  162  402:getstatic       #358 <Field Capabilities$Capability Capabilities$Capability.NUMERIC_ATTRIBUTES>
    //  163  405:astore          4
            if(!handles(cap))
    //* 164  407:aload_0         
    //* 165  408:aload           4
    //* 166  410:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 167  413:ifne            713
            {
                m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle numeric ")).append(errorStr).append("!").toString()));
    //  168  416:aload_0         
    //  169  417:new             #339 <Class UnsupportedAttributeTypeException>
    //  170  420:dup             
    //  171  421:aload_0         
    //  172  422:new             #299 <Class StringBuilder>
    //  173  425:dup             
    //  174  426:ldc2            #360 <String "Cannot handle numeric ">
    //  175  429:invokespecial   #308 <Method void StringBuilder(String)>
    //  176  432:aload           8
    //  177  434:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  178  437:ldc2            #343 <String "!">
    //  179  440:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  180  443:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  181  446:invokevirtual   #345 <Method String createMessage(String)>
    //  182  449:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  183  452:putfield        #52  <Field Exception m_FailReason>
                result = false;
    //  184  455:iconst_0        
    //  185  456:istore_3        
            }
            break;
    //  186  457:goto            713
        }

        case 3: // '\003'
        {
            Capability cap;
            if(isClass)
    //* 187  460:iload_2         
    //* 188  461:ifeq            472
                cap = Capability.DATE_CLASS;
    //  189  464:getstatic       #363 <Field Capabilities$Capability Capabilities$Capability.DATE_CLASS>
    //  190  467:astore          4
            else
    //* 191  469:goto            477
                cap = Capability.DATE_ATTRIBUTES;
    //  192  472:getstatic       #366 <Field Capabilities$Capability Capabilities$Capability.DATE_ATTRIBUTES>
    //  193  475:astore          4
            if(!handles(cap))
    //* 194  477:aload_0         
    //* 195  478:aload           4
    //* 196  480:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 197  483:ifne            713
            {
                m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle date ")).append(errorStr).append("!").toString()));
    //  198  486:aload_0         
    //  199  487:new             #339 <Class UnsupportedAttributeTypeException>
    //  200  490:dup             
    //  201  491:aload_0         
    //  202  492:new             #299 <Class StringBuilder>
    //  203  495:dup             
    //  204  496:ldc2            #368 <String "Cannot handle date ">
    //  205  499:invokespecial   #308 <Method void StringBuilder(String)>
    //  206  502:aload           8
    //  207  504:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  208  507:ldc2            #343 <String "!">
    //  209  510:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  210  513:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  211  516:invokevirtual   #345 <Method String createMessage(String)>
    //  212  519:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  213  522:putfield        #52  <Field Exception m_FailReason>
                result = false;
    //  214  525:iconst_0        
    //  215  526:istore_3        
            }
            break;
    //  216  527:goto            713
        }

        case 2: // '\002'
        {
            Capability cap;
            if(isClass)
    //* 217  530:iload_2         
    //* 218  531:ifeq            542
                cap = Capability.STRING_CLASS;
    //  219  534:getstatic       #371 <Field Capabilities$Capability Capabilities$Capability.STRING_CLASS>
    //  220  537:astore          4
            else
    //* 221  539:goto            547
                cap = Capability.STRING_ATTRIBUTES;
    //  222  542:getstatic       #374 <Field Capabilities$Capability Capabilities$Capability.STRING_ATTRIBUTES>
    //  223  545:astore          4
            if(!handles(cap))
    //* 224  547:aload_0         
    //* 225  548:aload           4
    //* 226  550:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 227  553:ifne            713
            {
                m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle string ")).append(errorStr).append("!").toString()));
    //  228  556:aload_0         
    //  229  557:new             #339 <Class UnsupportedAttributeTypeException>
    //  230  560:dup             
    //  231  561:aload_0         
    //  232  562:new             #299 <Class StringBuilder>
    //  233  565:dup             
    //  234  566:ldc2            #376 <String "Cannot handle string ">
    //  235  569:invokespecial   #308 <Method void StringBuilder(String)>
    //  236  572:aload           8
    //  237  574:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  238  577:ldc2            #343 <String "!">
    //  239  580:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  240  583:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  241  586:invokevirtual   #345 <Method String createMessage(String)>
    //  242  589:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  243  592:putfield        #52  <Field Exception m_FailReason>
                result = false;
    //  244  595:iconst_0        
    //  245  596:istore_3        
            }
            break;
    //  246  597:goto            713
        }

        case 4: // '\004'
        {
            Capability cap;
            if(isClass)
    //* 247  600:iload_2         
    //* 248  601:ifeq            612
                cap = Capability.RELATIONAL_CLASS;
    //  249  604:getstatic       #379 <Field Capabilities$Capability Capabilities$Capability.RELATIONAL_CLASS>
    //  250  607:astore          4
            else
    //* 251  609:goto            617
                cap = Capability.RELATIONAL_ATTRIBUTES;
    //  252  612:getstatic       #382 <Field Capabilities$Capability Capabilities$Capability.RELATIONAL_ATTRIBUTES>
    //  253  615:astore          4
            if(!handles(cap))
    //* 254  617:aload_0         
    //* 255  618:aload           4
    //* 256  620:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 257  623:ifne            713
            {
                m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle relational ")).append(errorStr).append("!").toString()));
    //  258  626:aload_0         
    //  259  627:new             #339 <Class UnsupportedAttributeTypeException>
    //  260  630:dup             
    //  261  631:aload_0         
    //  262  632:new             #299 <Class StringBuilder>
    //  263  635:dup             
    //  264  636:ldc2            #384 <String "Cannot handle relational ">
    //  265  639:invokespecial   #308 <Method void StringBuilder(String)>
    //  266  642:aload           8
    //  267  644:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  268  647:ldc2            #343 <String "!">
    //  269  650:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  270  653:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  271  656:invokevirtual   #345 <Method String createMessage(String)>
    //  272  659:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  273  662:putfield        #52  <Field Exception m_FailReason>
                result = false;
    //  274  665:iconst_0        
    //  275  666:istore_3        
            }
            break;
        }

    //* 276  667:goto            713
        default:
        {
            m_FailReason = new UnsupportedAttributeTypeException(createMessage((new StringBuilder("Cannot handle unknown attribute type '")).append(att.type()).append("'!").toString()));
    //  277  670:aload_0         
    //  278  671:new             #339 <Class UnsupportedAttributeTypeException>
    //  279  674:dup             
    //  280  675:aload_0         
    //  281  676:new             #299 <Class StringBuilder>
    //  282  679:dup             
    //  283  680:ldc2            #386 <String "Cannot handle unknown attribute type '">
    //  284  683:invokespecial   #308 <Method void StringBuilder(String)>
    //  285  686:aload_1         
    //  286  687:invokevirtual   #334 <Method int Attribute.type()>
    //  287  690:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  288  693:ldc2            #391 <String "'!">
    //  289  696:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  290  699:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  291  702:invokevirtual   #345 <Method String createMessage(String)>
    //  292  705:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  293  708:putfield        #52  <Field Exception m_FailReason>
            result = false;
    //  294  711:iconst_0        
    //  295  712:istore_3        
            break;
        }
        }
        return result;
    //  296  713:iload_3         
    //  297  714:ireturn         
    }

    public boolean test(Instances data)
    {
        return test(data, 0, data.numAttributes() - 1);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_0        
    //    3    3:aload_1         
    //    4    4:invokevirtual   #401 <Method int Instances.numAttributes()>
    //    5    7:iconst_1        
    //    6    8:isub            
    //    7    9:invokevirtual   #404 <Method boolean test(Instances, int, int)>
    //    8   12:ireturn         
    }

    public boolean test(Instances data, int fromIndex, int toIndex)
    {
        if(!m_InstancesTest)
    //*   0    0:aload_0         
    //*   1    1:getfield        #100 <Field boolean m_InstancesTest>
    //*   2    4:ifne            9
            return true;
    //    3    7:iconst_1        
    //    4    8:ireturn         
        if(m_Capabilities.size() == 0 || m_Capabilities.size() == 1 && handles(Capability.NO_CLASS))
    //*   5    9:aload_0         
    //*   6   10:getfield        #62  <Field HashSet m_Capabilities>
    //*   7   13:invokevirtual   #279 <Method int HashSet.size()>
    //*   8   16:ifeq            40
    //*   9   19:aload_0         
    //*  10   20:getfield        #62  <Field HashSet m_Capabilities>
    //*  11   23:invokevirtual   #279 <Method int HashSet.size()>
    //*  12   26:iconst_1        
    //*  13   27:icmpne          53
    //*  14   30:aload_0         
    //*  15   31:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //*  16   34:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  17   37:ifeq            53
            System.err.println(createMessage("No capabilities set!"));
    //   18   40:getstatic       #412 <Field PrintStream System.err>
    //   19   43:aload_0         
    //   20   44:ldc2            #414 <String "No capabilities set!">
    //   21   47:invokevirtual   #345 <Method String createMessage(String)>
    //   22   50:invokevirtual   #419 <Method void PrintStream.println(String)>
        if(toIndex - fromIndex < 0)
    //*  23   53:iload_3         
    //*  24   54:iload_2         
    //*  25   55:isub            
    //*  26   56:ifge            79
        {
            m_FailReason = new WekaException(createMessage("No attributes!"));
    //   27   59:aload_0         
    //   28   60:new             #421 <Class WekaException>
    //   29   63:dup             
    //   30   64:aload_0         
    //   31   65:ldc2            #423 <String "No attributes!">
    //   32   68:invokevirtual   #345 <Method String createMessage(String)>
    //   33   71:invokespecial   #424 <Method void WekaException(String)>
    //   34   74:putfield        #52  <Field Exception m_FailReason>
            return false;
    //   35   77:iconst_0        
    //   36   78:ireturn         
        }
        boolean testClass = data.classIndex() > -1 && data.classIndex() >= fromIndex && data.classIndex() <= toIndex;
    //   37   79:aload_1         
    //   38   80:invokevirtual   #427 <Method int Instances.classIndex()>
    //   39   83:iconst_m1       
    //   40   84:icmple          107
    //   41   87:aload_1         
    //   42   88:invokevirtual   #427 <Method int Instances.classIndex()>
    //   43   91:iload_2         
    //   44   92:icmplt          107
    //   45   95:aload_1         
    //   46   96:invokevirtual   #427 <Method int Instances.classIndex()>
    //   47   99:iload_3         
    //   48  100:icmpgt          107
    //   49  103:iconst_1        
    //   50  104:goto            108
    //   51  107:iconst_0        
    //   52  108:istore          9
        for(int i = fromIndex; i <= toIndex; i++)
    //*  53  110:iload_2         
    //*  54  111:istore          4
    //*  55  113:goto            150
        {
            Attribute att = data.attribute(i);
    //   56  116:aload_1         
    //   57  117:iload           4
    //   58  119:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //   59  122:astore          7
            if(i != data.classIndex() && !test(att))
    //*  60  124:iload           4
    //*  61  126:aload_1         
    //*  62  127:invokevirtual   #427 <Method int Instances.classIndex()>
    //*  63  130:icmpne          136
    //*  64  133:goto            147
    //*  65  136:aload_0         
    //*  66  137:aload           7
    //*  67  139:invokevirtual   #433 <Method boolean test(Attribute)>
    //*  68  142:ifne            147
                return false;
    //   69  145:iconst_0        
    //   70  146:ireturn         
        }

    //   71  147:iinc            4  1
    //   72  150:iload           4
    //   73  152:iload_3         
    //   74  153:icmple          116
        if(!handles(Capability.NO_CLASS) && data.classIndex() == -1)
    //*  75  156:aload_0         
    //*  76  157:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //*  77  160:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  78  163:ifne            194
    //*  79  166:aload_1         
    //*  80  167:invokevirtual   #427 <Method int Instances.classIndex()>
    //*  81  170:iconst_m1       
    //*  82  171:icmpne          194
        {
            m_FailReason = new UnassignedClassException(createMessage("Class attribute not set!"));
    //   83  174:aload_0         
    //   84  175:new             #435 <Class UnassignedClassException>
    //   85  178:dup             
    //   86  179:aload_0         
    //   87  180:ldc2            #437 <String "Class attribute not set!">
    //   88  183:invokevirtual   #345 <Method String createMessage(String)>
    //   89  186:invokespecial   #438 <Method void UnassignedClassException(String)>
    //   90  189:putfield        #52  <Field Exception m_FailReason>
            return false;
    //   91  192:iconst_0        
    //   92  193:ireturn         
        }
        if(handles(Capability.NO_CLASS) && data.classIndex() > -1)
    //*  93  194:aload_0         
    //*  94  195:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //*  95  198:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  96  201:ifeq            263
    //*  97  204:aload_1         
    //*  98  205:invokevirtual   #427 <Method int Instances.classIndex()>
    //*  99  208:iconst_m1       
    //* 100  209:icmple          263
        {
            Capabilities cap = getClassCapabilities();
    //  101  212:aload_0         
    //  102  213:invokevirtual   #440 <Method Capabilities getClassCapabilities()>
    //  103  216:astore          10
            cap.disable(Capability.NO_CLASS);
    //  104  218:aload           10
    //  105  220:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //  106  223:invokevirtual   #150 <Method void disable(Capabilities$Capability)>
            Iterator iter = cap.capabilities();
    //  107  226:aload           10
    //  108  228:invokevirtual   #442 <Method Iterator capabilities()>
    //  109  231:astore          12
            if(!iter.hasNext())
    //* 110  233:aload           12
    //* 111  235:invokeinterface #447 <Method boolean Iterator.hasNext()>
    //* 112  240:ifne            263
            {
                m_FailReason = new WekaException(createMessage("Cannot handle any class attribute!"));
    //  113  243:aload_0         
    //  114  244:new             #421 <Class WekaException>
    //  115  247:dup             
    //  116  248:aload_0         
    //  117  249:ldc2            #449 <String "Cannot handle any class attribute!">
    //  118  252:invokevirtual   #345 <Method String createMessage(String)>
    //  119  255:invokespecial   #424 <Method void WekaException(String)>
    //  120  258:putfield        #52  <Field Exception m_FailReason>
                return false;
    //  121  261:iconst_0        
    //  122  262:ireturn         
            }
        }
        if(testClass && !handles(Capability.NO_CLASS))
    //* 123  263:iload           9
    //* 124  265:ifeq            472
    //* 125  268:aload_0         
    //* 126  269:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //* 127  272:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 128  275:ifne            472
        {
            Attribute att = data.classAttribute();
    //  129  278:aload_1         
    //  130  279:invokevirtual   #453 <Method Attribute Instances.classAttribute()>
    //  131  282:astore          7
            if(!test(att, true))
    //* 132  284:aload_0         
    //* 133  285:aload           7
    //* 134  287:iconst_1        
    //* 135  288:invokevirtual   #323 <Method boolean test(Attribute, boolean)>
    //* 136  291:ifne            296
                return false;
    //  137  294:iconst_0        
    //  138  295:ireturn         
            if(m_MissingClassValuesTest)
    //* 139  296:aload_0         
    //* 140  297:getfield        #112 <Field boolean m_MissingClassValuesTest>
    //* 141  300:ifeq            472
                if(!handles(Capability.MISSING_CLASS_VALUES))
    //* 142  303:aload_0         
    //* 143  304:getstatic       #235 <Field Capabilities$Capability Capabilities$Capability.MISSING_CLASS_VALUES>
    //* 144  307:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 145  310:ifne            366
                {
                    for(int i = 0; i < data.numInstances(); i++)
    //* 146  313:iconst_0        
    //* 147  314:istore          4
    //* 148  316:goto            354
                        if(data.instance(i).classIsMissing())
    //* 149  319:aload_1         
    //* 150  320:iload           4
    //* 151  322:invokevirtual   #457 <Method Instance Instances.instance(int)>
    //* 152  325:invokevirtual   #462 <Method boolean Instance.classIsMissing()>
    //* 153  328:ifeq            351
                        {
                            m_FailReason = new WekaException(createMessage("Cannot handle missing class values!"));
    //  154  331:aload_0         
    //  155  332:new             #421 <Class WekaException>
    //  156  335:dup             
    //  157  336:aload_0         
    //  158  337:ldc2            #464 <String "Cannot handle missing class values!">
    //  159  340:invokevirtual   #345 <Method String createMessage(String)>
    //  160  343:invokespecial   #424 <Method void WekaException(String)>
    //  161  346:putfield        #52  <Field Exception m_FailReason>
                            return false;
    //  162  349:iconst_0        
    //  163  350:ireturn         
                        }

    //  164  351:iinc            4  1
    //  165  354:iload           4
    //  166  356:aload_1         
    //  167  357:invokevirtual   #467 <Method int Instances.numInstances()>
    //  168  360:icmplt          319
                } else
    //* 169  363:goto            472
                if(m_MinimumNumberInstancesTest)
    //* 170  366:aload_0         
    //* 171  367:getfield        #116 <Field boolean m_MinimumNumberInstancesTest>
    //* 172  370:ifeq            472
                {
                    int hasClass = 0;
    //  173  373:iconst_0        
    //  174  374:istore          13
                    for(int i = 0; i < data.numInstances(); i++)
    //* 175  376:iconst_0        
    //* 176  377:istore          4
    //* 177  379:goto            400
                        if(!data.instance(i).classIsMissing())
    //* 178  382:aload_1         
    //* 179  383:iload           4
    //* 180  385:invokevirtual   #457 <Method Instance Instances.instance(int)>
    //* 181  388:invokevirtual   #462 <Method boolean Instance.classIsMissing()>
    //* 182  391:ifne            397
                            hasClass++;
    //  183  394:iinc            13  1

    //  184  397:iinc            4  1
    //  185  400:iload           4
    //  186  402:aload_1         
    //  187  403:invokevirtual   #467 <Method int Instances.numInstances()>
    //  188  406:icmplt          382
                    if(hasClass < getMinimumNumberInstances())
    //* 189  409:iload           13
    //* 190  411:aload_0         
    //* 191  412:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //* 192  415:icmpge          472
                    {
                        m_FailReason = new WekaException(createMessage((new StringBuilder("Not enough training instances with class labels (required: ")).append(getMinimumNumberInstances()).append(", provided: ").append(hasClass).append(")!").toString()));
    //  193  418:aload_0         
    //  194  419:new             #421 <Class WekaException>
    //  195  422:dup             
    //  196  423:aload_0         
    //  197  424:new             #299 <Class StringBuilder>
    //  198  427:dup             
    //  199  428:ldc2            #469 <String "Not enough training instances with class labels (required: ">
    //  200  431:invokespecial   #308 <Method void StringBuilder(String)>
    //  201  434:aload_0         
    //  202  435:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //  203  438:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  204  441:ldc2            #471 <String ", provided: ">
    //  205  444:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  206  447:iload           13
    //  207  449:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  208  452:ldc2            #473 <String ")!">
    //  209  455:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  210  458:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  211  461:invokevirtual   #345 <Method String createMessage(String)>
    //  212  464:invokespecial   #424 <Method void WekaException(String)>
    //  213  467:putfield        #52  <Field Exception m_FailReason>
                        return false;
    //  214  470:iconst_0        
    //  215  471:ireturn         
                    }
                }
        }
        if(m_MissingValuesTest && !handles(Capability.MISSING_VALUES))
    //* 216  472:aload_0         
    //* 217  473:getfield        #108 <Field boolean m_MissingValuesTest>
    //* 218  476:ifeq            673
    //* 219  479:aload_0         
    //* 220  480:getstatic       #232 <Field Capabilities$Capability Capabilities$Capability.MISSING_VALUES>
    //* 221  483:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 222  486:ifne            673
        {
            boolean missing = false;
    //  223  489:iconst_0        
    //  224  490:istore          11
            for(int i = 0; i < data.numInstances(); i++)
    //* 225  492:iconst_0        
    //* 226  493:istore          4
    //* 227  495:goto            664
            {
                Instance inst = data.instance(i);
    //  228  498:aload_1         
    //  229  499:iload           4
    //  230  501:invokevirtual   #457 <Method Instance Instances.instance(int)>
    //  231  504:astore          8
                if(inst instanceof SparseInstance)
    //* 232  506:aload           8
    //* 233  508:instanceof      #475 <Class SparseInstance>
    //* 234  511:ifeq            592
                {
                    for(int m = 0; m < inst.numValues(); m++)
    //* 235  514:iconst_0        
    //* 236  515:istore          6
    //* 237  517:goto            579
                    {
                        int n = inst.index(m);
    //  238  520:aload           8
    //  239  522:iload           6
    //  240  524:invokevirtual   #479 <Method int Instance.index(int)>
    //  241  527:istore          5
                        if(n < fromIndex)
    //* 242  529:iload           5
    //* 243  531:iload_2         
    //* 244  532:icmpge          538
                            continue;
    //  245  535:goto            576
                        if(n > toIndex)
    //* 246  538:iload           5
    //* 247  540:iload_3         
    //* 248  541:icmple          547
                            break;
    //  249  544:goto            636
                        if(n == inst.classIndex() || !inst.isMissing(n))
                            continue;
    //  250  547:iload           5
    //  251  549:aload           8
    //  252  551:invokevirtual   #480 <Method int Instance.classIndex()>
    //  253  554:icmpne          560
    //  254  557:goto            576
    //  255  560:aload           8
    //  256  562:iload           5
    //  257  564:invokevirtual   #484 <Method boolean Instance.isMissing(int)>
    //  258  567:ifeq            576
                        missing = true;
    //  259  570:iconst_1        
    //  260  571:istore          11
                        break;
    //  261  573:goto            636
                    }

    //  262  576:iinc            6  1
    //  263  579:iload           6
    //  264  581:aload           8
    //  265  583:invokevirtual   #485 <Method int Instance.numValues()>
    //  266  586:icmplt          520
                } else
    //* 267  589:goto            636
                {
                    for(int n = fromIndex; n <= toIndex; n++)
    //* 268  592:iload_2         
    //* 269  593:istore          5
    //* 270  595:goto            630
                    {
                        if(n == inst.classIndex() || !inst.isMissing(n))
                            continue;
    //  271  598:iload           5
    //  272  600:aload           8
    //  273  602:invokevirtual   #480 <Method int Instance.classIndex()>
    //  274  605:icmpne          611
    //  275  608:goto            627
    //  276  611:aload           8
    //  277  613:iload           5
    //  278  615:invokevirtual   #484 <Method boolean Instance.isMissing(int)>
    //  279  618:ifeq            627
                        missing = true;
    //  280  621:iconst_1        
    //  281  622:istore          11
                        break;
    //  282  624:goto            636
                    }

    //  283  627:iinc            5  1
    //  284  630:iload           5
    //  285  632:iload_3         
    //  286  633:icmple          598
                }
                if(missing)
    //* 287  636:iload           11
    //* 288  638:ifeq            661
                {
                    m_FailReason = new NoSupportForMissingValuesException(createMessage("Cannot handle missing values!"));
    //  289  641:aload_0         
    //  290  642:new             #487 <Class NoSupportForMissingValuesException>
    //  291  645:dup             
    //  292  646:aload_0         
    //  293  647:ldc2            #489 <String "Cannot handle missing values!">
    //  294  650:invokevirtual   #345 <Method String createMessage(String)>
    //  295  653:invokespecial   #490 <Method void NoSupportForMissingValuesException(String)>
    //  296  656:putfield        #52  <Field Exception m_FailReason>
                    return false;
    //  297  659:iconst_0        
    //  298  660:ireturn         
                }
            }

    //  299  661:iinc            4  1
    //  300  664:iload           4
    //  301  666:aload_1         
    //  302  667:invokevirtual   #467 <Method int Instances.numInstances()>
    //  303  670:icmplt          498
        }
        if(m_MinimumNumberInstancesTest && data.numInstances() < getMinimumNumberInstances())
    //* 304  673:aload_0         
    //* 305  674:getfield        #116 <Field boolean m_MinimumNumberInstancesTest>
    //* 306  677:ifeq            747
    //* 307  680:aload_1         
    //* 308  681:invokevirtual   #467 <Method int Instances.numInstances()>
    //* 309  684:aload_0         
    //* 310  685:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //* 311  688:icmpge          747
        {
            m_FailReason = new WekaException(createMessage((new StringBuilder("Not enough training instances (required: ")).append(getMinimumNumberInstances()).append(", provided: ").append(data.numInstances()).append(")!").toString()));
    //  312  691:aload_0         
    //  313  692:new             #421 <Class WekaException>
    //  314  695:dup             
    //  315  696:aload_0         
    //  316  697:new             #299 <Class StringBuilder>
    //  317  700:dup             
    //  318  701:ldc2            #492 <String "Not enough training instances (required: ">
    //  319  704:invokespecial   #308 <Method void StringBuilder(String)>
    //  320  707:aload_0         
    //  321  708:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //  322  711:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  323  714:ldc2            #471 <String ", provided: ">
    //  324  717:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  325  720:aload_1         
    //  326  721:invokevirtual   #467 <Method int Instances.numInstances()>
    //  327  724:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  328  727:ldc2            #473 <String ")!">
    //  329  730:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  330  733:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  331  736:invokevirtual   #345 <Method String createMessage(String)>
    //  332  739:invokespecial   #424 <Method void WekaException(String)>
    //  333  742:putfield        #52  <Field Exception m_FailReason>
            return false;
    //  334  745:iconst_0        
    //  335  746:ireturn         
        }
        if(handles(Capability.ONLY_MULTIINSTANCE))
    //* 336  747:aload_0         
    //* 337  748:getstatic       #495 <Field Capabilities$Capability Capabilities$Capability.ONLY_MULTIINSTANCE>
    //* 338  751:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //* 339  754:ifeq            913
        {
            if(data.numAttributes() != 3)
    //* 340  757:aload_1         
    //* 341  758:invokevirtual   #401 <Method int Instances.numAttributes()>
    //* 342  761:iconst_3        
    //* 343  762:icmpeq          785
            {
                m_FailReason = new WekaException(createMessage("Incorrect Multi-Instance format, must be 'bag-id, bag, class'!"));
    //  344  765:aload_0         
    //  345  766:new             #421 <Class WekaException>
    //  346  769:dup             
    //  347  770:aload_0         
    //  348  771:ldc2            #497 <String "Incorrect Multi-Instance format, must be 'bag-id, bag, class'!">
    //  349  774:invokevirtual   #345 <Method String createMessage(String)>
    //  350  777:invokespecial   #424 <Method void WekaException(String)>
    //  351  780:putfield        #52  <Field Exception m_FailReason>
                return false;
    //  352  783:iconst_0        
    //  353  784:ireturn         
            }
            if(!data.attribute(0).isNominal() || !data.attribute(1).isRelationValued() || data.classIndex() != data.numAttributes() - 1)
    //* 354  785:aload_1         
    //* 355  786:iconst_0        
    //* 356  787:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //* 357  790:invokevirtual   #500 <Method boolean Attribute.isNominal()>
    //* 358  793:ifeq            820
    //* 359  796:aload_1         
    //* 360  797:iconst_1        
    //* 361  798:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //* 362  801:invokevirtual   #503 <Method boolean Attribute.isRelationValued()>
    //* 363  804:ifeq            820
    //* 364  807:aload_1         
    //* 365  808:invokevirtual   #427 <Method int Instances.classIndex()>
    //* 366  811:aload_1         
    //* 367  812:invokevirtual   #401 <Method int Instances.numAttributes()>
    //* 368  815:iconst_1        
    //* 369  816:isub            
    //* 370  817:icmpeq          840
            {
                m_FailReason = new WekaException(createMessage("Incorrect Multi-Instance format, must be 'NOMINAL att, RELATIONAL att, CLASS att'!"));
    //  371  820:aload_0         
    //  372  821:new             #421 <Class WekaException>
    //  373  824:dup             
    //  374  825:aload_0         
    //  375  826:ldc2            #505 <String "Incorrect Multi-Instance format, must be 'NOMINAL att, RELATIONAL att, CLASS att'!">
    //  376  829:invokevirtual   #345 <Method String createMessage(String)>
    //  377  832:invokespecial   #424 <Method void WekaException(String)>
    //  378  835:putfield        #52  <Field Exception m_FailReason>
                return false;
    //  379  838:iconst_0        
    //  380  839:ireturn         
            }
            if(getOwner() instanceof MultiInstanceCapabilitiesHandler)
    //* 381  840:aload_0         
    //* 382  841:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //* 383  844:instanceof      #507 <Class MultiInstanceCapabilitiesHandler>
    //* 384  847:ifeq            913
            {
                MultiInstanceCapabilitiesHandler handler = (MultiInstanceCapabilitiesHandler)getOwner();
    //  385  850:aload_0         
    //  386  851:invokevirtual   #261 <Method CapabilitiesHandler getOwner()>
    //  387  854:checkcast       #507 <Class MultiInstanceCapabilitiesHandler>
    //  388  857:astore          13
                Capabilities cap = handler.getMultiInstanceCapabilities();
    //  389  859:aload           13
    //  390  861:invokeinterface #510 <Method Capabilities MultiInstanceCapabilitiesHandler.getMultiInstanceCapabilities()>
    //  391  866:astore          10
                boolean result;
                if(data.numInstances() > 0)
    //* 392  868:aload_1         
    //* 393  869:invokevirtual   #467 <Method int Instances.numInstances()>
    //* 394  872:ifle            894
                    result = cap.test(data.attribute(1).relation(0));
    //  395  875:aload           10
    //  396  877:aload_1         
    //  397  878:iconst_1        
    //  398  879:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //  399  882:iconst_0        
    //  400  883:invokevirtual   #514 <Method Instances Attribute.relation(int)>
    //  401  886:invokevirtual   #516 <Method boolean test(Instances)>
    //  402  889:istore          14
                else
    //* 403  891:goto            897
                    result = true;
    //  404  894:iconst_1        
    //  405  895:istore          14
                if(!result)
    //* 406  897:iload           14
    //* 407  899:ifne            913
                {
                    m_FailReason = cap.m_FailReason;
    //  408  902:aload_0         
    //  409  903:aload           10
    //  410  905:getfield        #52  <Field Exception m_FailReason>
    //  411  908:putfield        #52  <Field Exception m_FailReason>
                    return false;
    //  412  911:iconst_0        
    //  413  912:ireturn         
                }
            }
        }
        return true;
    //  414  913:iconst_1        
    //  415  914:ireturn         
    }

    public void testWithFail(Attribute att)
        throws Exception
    {
        test(att, false);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_0        
    //    3    3:invokevirtual   #323 <Method boolean test(Attribute, boolean)>
    //    4    6:pop             
    //    5    7:return          
    }

    public void testWithFail(Attribute att, boolean isClass)
        throws Exception
    {
        if(!test(att, isClass))
    //*   0    0:aload_0         
    //*   1    1:aload_1         
    //*   2    2:iload_2         
    //*   3    3:invokevirtual   #323 <Method boolean test(Attribute, boolean)>
    //*   4    6:ifne            14
            throw m_FailReason;
    //    5    9:aload_0         
    //    6   10:getfield        #52  <Field Exception m_FailReason>
    //    7   13:athrow          
        else
            return;
    //    8   14:return          
    }

    public void testWithFail(Instances data, int fromIndex, int toIndex)
        throws Exception
    {
        if(!test(data, fromIndex, toIndex))
    //*   0    0:aload_0         
    //*   1    1:aload_1         
    //*   2    2:iload_2         
    //*   3    3:iload_3         
    //*   4    4:invokevirtual   #404 <Method boolean test(Instances, int, int)>
    //*   5    7:ifne            15
            throw m_FailReason;
    //    6   10:aload_0         
    //    7   11:getfield        #52  <Field Exception m_FailReason>
    //    8   14:athrow          
        else
            return;
    //    9   15:return          
    }

    public void testWithFail(Instances data)
        throws Exception
    {
        if(!test(data))
    //*   0    0:aload_0         
    //*   1    1:aload_1         
    //*   2    2:invokevirtual   #516 <Method boolean test(Instances)>
    //*   3    5:ifne            13
            throw m_FailReason;
    //    4    8:aload_0         
    //    5    9:getfield        #52  <Field Exception m_FailReason>
    //    6   12:athrow          
        else
            return;
    //    7   13:return          
    }

    public String toString()
    {
        StringBuffer result = new StringBuffer();
    //    0    0:new             #538 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #539 <Method void StringBuffer()>
    //    3    7:astore_2        
        Vector sorted = new Vector(m_Capabilities);
    //    4    8:new             #541 <Class Vector>
    //    5   11:dup             
    //    6   12:aload_0         
    //    7   13:getfield        #62  <Field HashSet m_Capabilities>
    //    8   16:invokespecial   #544 <Method void Vector(java.util.Collection)>
    //    9   19:astore_1        
        Collections.sort(sorted);
    //   10   20:aload_1         
    //   11   21:invokestatic    #550 <Method void Collections.sort(List)>
        result.append((new StringBuilder("Capabilities: ")).append(sorted.toString()).append("\n").toString());
    //   12   24:aload_2         
    //   13   25:new             #299 <Class StringBuilder>
    //   14   28:dup             
    //   15   29:ldc2            #552 <String "Capabilities: ">
    //   16   32:invokespecial   #308 <Method void StringBuilder(String)>
    //   17   35:aload_1         
    //   18   36:invokevirtual   #553 <Method String Vector.toString()>
    //   19   39:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   20   42:ldc2            #555 <String "\n">
    //   21   45:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   22   48:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   23   51:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //   24   54:pop             
        sorted = new Vector(m_Dependencies);
    //   25   55:new             #541 <Class Vector>
    //   26   58:dup             
    //   27   59:aload_0         
    //   28   60:getfield        #64  <Field HashSet m_Dependencies>
    //   29   63:invokespecial   #544 <Method void Vector(java.util.Collection)>
    //   30   66:astore_1        
        Collections.sort(sorted);
    //   31   67:aload_1         
    //   32   68:invokestatic    #550 <Method void Collections.sort(List)>
        result.append((new StringBuilder("Dependencies: ")).append(sorted.toString()).append("\n").toString());
    //   33   71:aload_2         
    //   34   72:new             #299 <Class StringBuilder>
    //   35   75:dup             
    //   36   76:ldc2            #560 <String "Dependencies: ">
    //   37   79:invokespecial   #308 <Method void StringBuilder(String)>
    //   38   82:aload_1         
    //   39   83:invokevirtual   #553 <Method String Vector.toString()>
    //   40   86:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   41   89:ldc2            #555 <String "\n">
    //   42   92:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   43   95:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   44   98:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //   45  101:pop             
        result.append((new StringBuilder("min # Instance: ")).append(getMinimumNumberInstances()).append("\n").toString());
    //   46  102:aload_2         
    //   47  103:new             #299 <Class StringBuilder>
    //   48  106:dup             
    //   49  107:ldc2            #562 <String "min # Instance: ">
    //   50  110:invokespecial   #308 <Method void StringBuilder(String)>
    //   51  113:aload_0         
    //   52  114:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //   53  117:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //   54  120:ldc2            #555 <String "\n">
    //   55  123:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   56  126:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   57  129:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //   58  132:pop             
        return result.toString();
    //   59  133:aload_2         
    //   60  134:invokevirtual   #563 <Method String StringBuffer.toString()>
    //   61  137:areturn         
    }

    public String toSource(String objectname)
    {
        return toSource(objectname, 0);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_0        
    //    3    3:invokevirtual   #570 <Method String toSource(String, int)>
    //    4    6:areturn         
    }

    public String toSource(String objectname, int indent)
    {
        StringBuffer result = new StringBuffer();
    //    0    0:new             #538 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #539 <Method void StringBuffer()>
    //    3    7:astore_3        
        String capsName = rm/core/Capabilities.getName();
    //    4    8:ldc1            #2   <Class Capabilities>
    //    5   10:invokevirtual   #295 <Method String Class.getName()>
    //    6   13:astore          4
        String capName = rm/core/Capabilities$Capability.getName().replaceAll("\\$", ".");
    //    7   15:ldc1            #135 <Class Capabilities$Capability>
    //    8   17:invokevirtual   #295 <Method String Class.getName()>
    //    9   20:ldc2            #573 <String "\\$">
    //   10   23:ldc2            #575 <String ".">
    //   11   26:invokevirtual   #578 <Method String String.replaceAll(String, String)>
    //   12   29:astore          5
        String indentStr = "";
    //   13   31:ldc2            #285 <String "">
    //   14   34:astore          6
        for(int i = 0; i < indent; i++)
    //*  15   36:iconst_0        
    //*  16   37:istore          7
    //*  17   39:goto            68
            indentStr = (new StringBuilder(String.valueOf(indentStr))).append(" ").toString();
    //   18   42:new             #299 <Class StringBuilder>
    //   19   45:dup             
    //   20   46:aload           6
    //   21   48:invokestatic    #305 <Method String String.valueOf(Object)>
    //   22   51:invokespecial   #308 <Method void StringBuilder(String)>
    //   23   54:ldc2            #580 <String " ">
    //   24   57:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   25   60:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   26   63:astore          6

    //   27   65:iinc            7  1
    //   28   68:iload           7
    //   29   70:iload_2         
    //   30   71:icmplt          42
        result.append((new StringBuilder(String.valueOf(indentStr))).append(capsName).append(" ").append(objectname).append(" = new ").append(capsName).append("(this);\n").toString());
    //   31   74:aload_3         
    //   32   75:new             #299 <Class StringBuilder>
    //   33   78:dup             
    //   34   79:aload           6
    //   35   81:invokestatic    #305 <Method String String.valueOf(Object)>
    //   36   84:invokespecial   #308 <Method void StringBuilder(String)>
    //   37   87:aload           4
    //   38   89:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   39   92:ldc2            #580 <String " ">
    //   40   95:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   41   98:aload_1         
    //   42   99:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   43  102:ldc2            #582 <String " = new ">
    //   44  105:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   45  108:aload           4
    //   46  110:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   47  113:ldc2            #584 <String "(this);\n">
    //   48  116:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   49  119:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   50  122:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //   51  125:pop             
        List capsList = new ArrayList();
    //   52  126:new             #586 <Class ArrayList>
    //   53  129:dup             
    //   54  130:invokespecial   #587 <Method void ArrayList()>
    //   55  133:astore          8
        boolean hasNominalAtt = false;
    //   56  135:iconst_0        
    //   57  136:istore          9
        boolean hasBinaryAtt = false;
    //   58  138:iconst_0        
    //   59  139:istore          10
        boolean hasUnaryAtt = false;
    //   60  141:iconst_0        
    //   61  142:istore          11
        boolean hasEmptyNomAtt = false;
    //   62  144:iconst_0        
    //   63  145:istore          12
        boolean hasNominalClass = false;
    //   64  147:iconst_0        
    //   65  148:istore          13
        result.append("\n");
    //   66  150:aload_3         
    //   67  151:ldc2            #555 <String "\n">
    //   68  154:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //   69  157:pop             
        Capability acapability[] = Capability.values();
    //   70  158:invokestatic    #139 <Method Capabilities$Capability[] Capabilities$Capability.values()>
    //   71  161:astore          17
        int j = 0;
    //   72  163:iconst_0        
    //   73  164:istore          15
        for(int k = acapability.length; j < k; j++)
    //*  74  166:aload           17
    //*  75  168:arraylength     
    //*  76  169:istore          16
    //*  77  171:goto            258
        {
            Capability cap = acapability[j];
    //   78  174:aload           17
    //   79  176:iload           15
    //   80  178:aaload          
    //   81  179:astore          14
            if(handles(cap))
    //*  82  181:aload_0         
    //*  83  182:aload           14
    //*  84  184:invokevirtual   #143 <Method boolean handles(Capabilities$Capability)>
    //*  85  187:ifeq            255
            {
                if(cap == Capability.NOMINAL_ATTRIBUTES)
    //*  86  190:aload           14
    //*  87  192:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //*  88  195:if_acmpne       201
                    hasNominalAtt = true;
    //   89  198:iconst_1        
    //   90  199:istore          9
                if(cap == Capability.NOMINAL_CLASS)
    //*  91  201:aload           14
    //*  92  203:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //*  93  206:if_acmpne       212
                    hasNominalClass = true;
    //   94  209:iconst_1        
    //   95  210:istore          13
                if(cap == Capability.BINARY_ATTRIBUTES)
    //*  96  212:aload           14
    //*  97  214:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //*  98  217:if_acmpne       223
                    hasBinaryAtt = true;
    //   99  220:iconst_1        
    //  100  221:istore          10
                if(cap == Capability.UNARY_ATTRIBUTES)
    //* 101  223:aload           14
    //* 102  225:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //* 103  228:if_acmpne       234
                    hasUnaryAtt = true;
    //  104  231:iconst_1        
    //  105  232:istore          11
                if(cap == Capability.EMPTY_NOMINAL_ATTRIBUTES)
    //* 106  234:aload           14
    //* 107  236:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //* 108  239:if_acmpne       245
                    hasEmptyNomAtt = true;
    //  109  242:iconst_1        
    //  110  243:istore          12
                capsList.add(cap);
    //  111  245:aload           8
    //  112  247:aload           14
    //  113  249:invokeinterface #590 <Method boolean List.add(Object)>
    //  114  254:pop             
            }
        }

    //  115  255:iinc            15  1
    //  116  258:iload           15
    //  117  260:iload           16
    //  118  262:icmplt          174
        for(Iterator iterator = capsList.iterator(); iterator.hasNext();)
    //* 119  265:aload           8
    //* 120  267:invokeinterface #591 <Method Iterator List.iterator()>
    //* 121  272:astore          15
    //* 122  274:goto            463
        {
            Capability cap = (Capability)iterator.next();
    //  123  277:aload           15
    //  124  279:invokeinterface #594 <Method Object Iterator.next()>
    //  125  284:checkcast       #135 <Class Capabilities$Capability>
    //  126  287:astore          14
            if((cap != Capability.BINARY_ATTRIBUTES || !hasNominalAtt) && (cap != Capability.UNARY_ATTRIBUTES || !hasBinaryAtt) && (cap != Capability.EMPTY_NOMINAL_ATTRIBUTES || !hasUnaryAtt) && (cap != Capability.BINARY_CLASS || !hasNominalClass))
    //* 127  289:aload           14
    //* 128  291:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //* 129  294:if_acmpne       302
    //* 130  297:iload           9
    //* 131  299:ifne            463
    //* 132  302:aload           14
    //* 133  304:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //* 134  307:if_acmpne       315
    //* 135  310:iload           10
    //* 136  312:ifne            463
    //* 137  315:aload           14
    //* 138  317:getstatic       #203 <Field Capabilities$Capability Capabilities$Capability.EMPTY_NOMINAL_ATTRIBUTES>
    //* 139  320:if_acmpne       328
    //* 140  323:iload           11
    //* 141  325:ifne            463
    //* 142  328:aload           14
    //* 143  330:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //* 144  333:if_acmpne       344
    //* 145  336:iload           13
    //* 146  338:ifeq            344
    //* 147  341:goto            463
            {
                result.append((new StringBuilder(String.valueOf(indentStr))).append(objectname).append(".enable(").append(capName).append(".").append(cap.name()).append(");\n").toString());
    //  148  344:aload_3         
    //  149  345:new             #299 <Class StringBuilder>
    //  150  348:dup             
    //  151  349:aload           6
    //  152  351:invokestatic    #305 <Method String String.valueOf(Object)>
    //  153  354:invokespecial   #308 <Method void StringBuilder(String)>
    //  154  357:aload_1         
    //  155  358:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  156  361:ldc2            #596 <String ".enable(">
    //  157  364:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  158  367:aload           5
    //  159  369:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  160  372:ldc2            #575 <String ".">
    //  161  375:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  162  378:aload           14
    //  163  380:invokevirtual   #601 <Method String Enum.name()>
    //  164  383:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  165  386:ldc2            #603 <String ");\n">
    //  166  389:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  167  392:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  168  395:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //  169  398:pop             
                if(hasDependency(cap))
    //* 170  399:aload_0         
    //* 171  400:aload           14
    //* 172  402:invokevirtual   #153 <Method boolean hasDependency(Capabilities$Capability)>
    //* 173  405:ifeq            463
                    result.append((new StringBuilder(String.valueOf(indentStr))).append(objectname).append(".enableDependency(").append(capName).append(".").append(cap.name()).append(");\n").toString());
    //  174  408:aload_3         
    //  175  409:new             #299 <Class StringBuilder>
    //  176  412:dup             
    //  177  413:aload           6
    //  178  415:invokestatic    #305 <Method String String.valueOf(Object)>
    //  179  418:invokespecial   #308 <Method void StringBuilder(String)>
    //  180  421:aload_1         
    //  181  422:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  182  425:ldc2            #605 <String ".enableDependency(">
    //  183  428:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  184  431:aload           5
    //  185  433:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  186  436:ldc2            #575 <String ".">
    //  187  439:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  188  442:aload           14
    //  189  444:invokevirtual   #601 <Method String Enum.name()>
    //  190  447:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  191  450:ldc2            #603 <String ");\n">
    //  192  453:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  193  456:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  194  459:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //  195  462:pop             
            }
        }

    //  196  463:aload           15
    //  197  465:invokeinterface #447 <Method boolean Iterator.hasNext()>
    //  198  470:ifne            277
        result.append("\n");
    //  199  473:aload_3         
    //  200  474:ldc2            #555 <String "\n">
    //  201  477:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //  202  480:pop             
        result.append((new StringBuilder(String.valueOf(indentStr))).append(objectname).append(".setMinimumNumberInstances(").append(getMinimumNumberInstances()).append(");\n").toString());
    //  203  481:aload_3         
    //  204  482:new             #299 <Class StringBuilder>
    //  205  485:dup             
    //  206  486:aload           6
    //  207  488:invokestatic    #305 <Method String String.valueOf(Object)>
    //  208  491:invokespecial   #308 <Method void StringBuilder(String)>
    //  209  494:aload_1         
    //  210  495:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  211  498:ldc2            #607 <String ".setMinimumNumberInstances(">
    //  212  501:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  213  504:aload_0         
    //  214  505:invokevirtual   #163 <Method int getMinimumNumberInstances()>
    //  215  508:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  216  511:ldc2            #603 <String ");\n">
    //  217  514:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  218  517:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  219  520:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //  220  523:pop             
        result.append("\n");
    //  221  524:aload_3         
    //  222  525:ldc2            #555 <String "\n">
    //  223  528:invokevirtual   #558 <Method StringBuffer StringBuffer.append(String)>
    //  224  531:pop             
        return result.toString();
    //  225  532:aload_3         
    //  226  533:invokevirtual   #563 <Method String StringBuffer.toString()>
    //  227  536:areturn         
    }

    public static Capabilities forInstances(Instances data)
        throws Exception
    {
        return forInstances(data, false);
    //    0    0:aload_0         
    //    1    1:iconst_0        
    //    2    2:invokestatic    #625 <Method Capabilities forInstances(Instances, boolean)>
    //    3    5:areturn         
    }

    public static Capabilities forInstances(Instances data, boolean multi)
        throws Exception
    {
        Capabilities result = new Capabilities(null);
    //    0    0:new             #2   <Class Capabilities>
    //    1    3:dup             
    //    2    4:aconst_null     
    //    3    5:invokespecial   #128 <Method void Capabilities(CapabilitiesHandler)>
    //    4    8:astore_2        
        if(data.classIndex() == -1)
    //*   5    9:aload_0         
    //*   6   10:invokevirtual   #427 <Method int Instances.classIndex()>
    //*   7   13:iconst_m1       
    //*   8   14:icmpne          27
        {
            result.enable(Capability.NO_CLASS);
    //    9   17:aload_2         
    //   10   18:getstatic       #257 <Field Capabilities$Capability Capabilities$Capability.NO_CLASS>
    //   11   21:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
        } else
    //*  12   24:goto            234
        {
            switch(data.classAttribute().type())
    //*  13   27:aload_0         
    //*  14   28:invokevirtual   #453 <Method Attribute Instances.classAttribute()>
    //*  15   31:invokevirtual   #334 <Method int Attribute.type()>
            {
    //*  16   34:tableswitch     0 4: default 160
    //                   0 120
    //                   1 68
    //                   2 130
    //                   3 140
    //                   4 150
            case 1: // '\001'
                if(data.classAttribute().numValues() == 1)
    //*  17   68:aload_0         
    //*  18   69:invokevirtual   #453 <Method Attribute Instances.classAttribute()>
    //*  19   72:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  20   75:iconst_1        
    //*  21   76:icmpne          89
                {
                    result.enable(Capability.UNARY_CLASS);
    //   22   79:aload_2         
    //   23   80:getstatic       #238 <Field Capabilities$Capability Capabilities$Capability.UNARY_CLASS>
    //   24   83:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    break;
    //   25   86:goto            194
                }
                if(data.classAttribute().numValues() == 2)
    //*  26   89:aload_0         
    //*  27   90:invokevirtual   #453 <Method Attribute Instances.classAttribute()>
    //*  28   93:invokevirtual   #337 <Method int Attribute.numValues()>
    //*  29   96:iconst_2        
    //*  30   97:icmpne          110
                    result.enable(Capability.BINARY_CLASS);
    //   31  100:aload_2         
    //   32  101:getstatic       #209 <Field Capabilities$Capability Capabilities$Capability.BINARY_CLASS>
    //   33  104:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                else
    //*  34  107:goto            194
                    result.enable(Capability.NOMINAL_CLASS);
    //   35  110:aload_2         
    //   36  111:getstatic       #206 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_CLASS>
    //   37  114:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                break;

    //*  38  117:goto            194
            case 0: // '\0'
                result.enable(Capability.NUMERIC_CLASS);
    //   39  120:aload_2         
    //   40  121:getstatic       #355 <Field Capabilities$Capability Capabilities$Capability.NUMERIC_CLASS>
    //   41  124:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                break;

    //*  42  127:goto            194
            case 2: // '\002'
                result.enable(Capability.STRING_CLASS);
    //   43  130:aload_2         
    //   44  131:getstatic       #371 <Field Capabilities$Capability Capabilities$Capability.STRING_CLASS>
    //   45  134:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                break;

    //*  46  137:goto            194
            case 3: // '\003'
                result.enable(Capability.DATE_CLASS);
    //   47  140:aload_2         
    //   48  141:getstatic       #363 <Field Capabilities$Capability Capabilities$Capability.DATE_CLASS>
    //   49  144:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                break;

    //*  50  147:goto            194
            case 4: // '\004'
                result.enable(Capability.RELATIONAL_CLASS);
    //   51  150:aload_2         
    //   52  151:getstatic       #379 <Field Capabilities$Capability Capabilities$Capability.RELATIONAL_CLASS>
    //   53  154:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                break;

    //*  54  157:goto            194
            default:
                throw new UnsupportedAttributeTypeException((new StringBuilder("Unknown class attribute type '")).append(data.classAttribute()).append("'!").toString());
    //   55  160:new             #339 <Class UnsupportedAttributeTypeException>
    //   56  163:dup             
    //   57  164:new             #299 <Class StringBuilder>
    //   58  167:dup             
    //   59  168:ldc2            #627 <String "Unknown class attribute type '">
    //   60  171:invokespecial   #308 <Method void StringBuilder(String)>
    //   61  174:aload_0         
    //   62  175:invokevirtual   #453 <Method Attribute Instances.classAttribute()>
    //   63  178:invokevirtual   #630 <Method StringBuilder StringBuilder.append(Object)>
    //   64  181:ldc2            #391 <String "'!">
    //   65  184:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   66  187:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   67  190:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //   68  193:athrow          
            }
            for(int i = 0; i < data.numInstances(); i++)
    //*  69  194:iconst_0        
    //*  70  195:istore          4
    //*  71  197:goto            225
            {
                if(!data.instance(i).classIsMissing())
                    continue;
    //   72  200:aload_0         
    //   73  201:iload           4
    //   74  203:invokevirtual   #457 <Method Instance Instances.instance(int)>
    //   75  206:invokevirtual   #462 <Method boolean Instance.classIsMissing()>
    //   76  209:ifeq            222
                result.enable(Capability.MISSING_CLASS_VALUES);
    //   77  212:aload_2         
    //   78  213:getstatic       #235 <Field Capabilities$Capability Capabilities$Capability.MISSING_CLASS_VALUES>
    //   79  216:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                break;
    //   80  219:goto            234
            }

    //   81  222:iinc            4  1
    //   82  225:iload           4
    //   83  227:aload_0         
    //   84  228:invokevirtual   #467 <Method int Instances.numInstances()>
    //   85  231:icmplt          200
        }
        for(int i = 0; i < data.numAttributes(); i++)
    //*  86  234:iconst_0        
    //*  87  235:istore          4
    //*  88  237:goto            431
            if(i != data.classIndex())
    //*  89  240:iload           4
    //*  90  242:aload_0         
    //*  91  243:invokevirtual   #427 <Method int Instances.classIndex()>
    //*  92  246:icmpne          252
    //*  93  249:goto            428
                switch(data.attribute(i).type())
    //*  94  252:aload_0         
    //*  95  253:iload           4
    //*  96  255:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //*  97  258:invokevirtual   #334 <Method int Attribute.type()>
                {
    //*  98  261:tableswitch     0 4: default 389
    //                   0 349
    //                   1 296
    //                   2 369
    //                   3 359
    //                   4 379
                case 1: // '\001'
                    result.enable(Capability.UNARY_ATTRIBUTES);
    //   99  296:aload_2         
    //  100  297:getstatic       #200 <Field Capabilities$Capability Capabilities$Capability.UNARY_ATTRIBUTES>
    //  101  300:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    if(data.attribute(i).numValues() == 2)
    //* 102  303:aload_0         
    //* 103  304:iload           4
    //* 104  306:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //* 105  309:invokevirtual   #337 <Method int Attribute.numValues()>
    //* 106  312:iconst_2        
    //* 107  313:icmpne          326
                    {
                        result.enable(Capability.BINARY_ATTRIBUTES);
    //  108  316:aload_2         
    //  109  317:getstatic       #197 <Field Capabilities$Capability Capabilities$Capability.BINARY_ATTRIBUTES>
    //  110  320:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                        break;
    //  111  323:goto            428
                    }
                    if(data.attribute(i).numValues() > 2)
    //* 112  326:aload_0         
    //* 113  327:iload           4
    //* 114  329:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //* 115  332:invokevirtual   #337 <Method int Attribute.numValues()>
    //* 116  335:iconst_2        
    //* 117  336:icmple          428
                        result.enable(Capability.NOMINAL_ATTRIBUTES);
    //  118  339:aload_2         
    //  119  340:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //  120  343:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    break;

    //* 121  346:goto            428
                case 0: // '\0'
                    result.enable(Capability.NUMERIC_ATTRIBUTES);
    //  122  349:aload_2         
    //  123  350:getstatic       #358 <Field Capabilities$Capability Capabilities$Capability.NUMERIC_ATTRIBUTES>
    //  124  353:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    break;

    //* 125  356:goto            428
                case 3: // '\003'
                    result.enable(Capability.DATE_ATTRIBUTES);
    //  126  359:aload_2         
    //  127  360:getstatic       #366 <Field Capabilities$Capability Capabilities$Capability.DATE_ATTRIBUTES>
    //  128  363:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    break;

    //* 129  366:goto            428
                case 2: // '\002'
                    result.enable(Capability.STRING_ATTRIBUTES);
    //  130  369:aload_2         
    //  131  370:getstatic       #374 <Field Capabilities$Capability Capabilities$Capability.STRING_ATTRIBUTES>
    //  132  373:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    break;

    //* 133  376:goto            428
                case 4: // '\004'
                    result.enable(Capability.RELATIONAL_ATTRIBUTES);
    //  134  379:aload_2         
    //  135  380:getstatic       #382 <Field Capabilities$Capability Capabilities$Capability.RELATIONAL_ATTRIBUTES>
    //  136  383:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
                    break;

    //* 137  386:goto            428
                default:
                    throw new UnsupportedAttributeTypeException((new StringBuilder("Unknown attribute type '")).append(data.attribute(i).type()).append("'!").toString());
    //  138  389:new             #339 <Class UnsupportedAttributeTypeException>
    //  139  392:dup             
    //  140  393:new             #299 <Class StringBuilder>
    //  141  396:dup             
    //  142  397:ldc2            #632 <String "Unknown attribute type '">
    //  143  400:invokespecial   #308 <Method void StringBuilder(String)>
    //  144  403:aload_0         
    //  145  404:iload           4
    //  146  406:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //  147  409:invokevirtual   #334 <Method int Attribute.type()>
    //  148  412:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  149  415:ldc2            #391 <String "'!">
    //  150  418:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  151  421:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  152  424:invokespecial   #346 <Method void UnsupportedAttributeTypeException(String)>
    //  153  427:athrow          
                }

    //  154  428:iinc            4  1
    //  155  431:iload           4
    //  156  433:aload_0         
    //  157  434:invokevirtual   #401 <Method int Instances.numAttributes()>
    //  158  437:icmplt          240
        boolean missing = false;
    //  159  440:iconst_0        
    //  160  441:istore          8
        for(int i = 0; i < data.numInstances(); i++)
    //* 161  443:iconst_0        
    //* 162  444:istore          4
    //* 163  446:goto            590
        {
            Instance inst = data.instance(i);
    //  164  449:aload_0         
    //  165  450:iload           4
    //  166  452:invokevirtual   #457 <Method Instance Instances.instance(int)>
    //  167  455:astore          7
            if(inst instanceof SparseInstance)
    //* 168  457:aload           7
    //* 169  459:instanceof      #475 <Class SparseInstance>
    //* 170  462:ifeq            525
            {
                for(int m = 0; m < inst.numValues(); m++)
    //* 171  465:iconst_0        
    //* 172  466:istore          6
    //* 173  468:goto            512
                {
                    int n = inst.index(m);
    //  174  471:aload           7
    //  175  473:iload           6
    //  176  475:invokevirtual   #479 <Method int Instance.index(int)>
    //  177  478:istore          5
                    if(n == inst.classIndex() || !inst.isMissing(n))
                        continue;
    //  178  480:iload           5
    //  179  482:aload           7
    //  180  484:invokevirtual   #480 <Method int Instance.classIndex()>
    //  181  487:icmpne          493
    //  182  490:goto            509
    //  183  493:aload           7
    //  184  495:iload           5
    //  185  497:invokevirtual   #484 <Method boolean Instance.isMissing(int)>
    //  186  500:ifeq            509
                    missing = true;
    //  187  503:iconst_1        
    //  188  504:istore          8
                    break;
    //  189  506:goto            572
                }

    //  190  509:iinc            6  1
    //  191  512:iload           6
    //  192  514:aload           7
    //  193  516:invokevirtual   #485 <Method int Instance.numValues()>
    //  194  519:icmplt          471
            } else
    //* 195  522:goto            572
            {
                for(int n = 0; n < data.numAttributes(); n++)
    //* 196  525:iconst_0        
    //* 197  526:istore          5
    //* 198  528:goto            563
                {
                    if(n == inst.classIndex() || !inst.isMissing(n))
                        continue;
    //  199  531:iload           5
    //  200  533:aload           7
    //  201  535:invokevirtual   #480 <Method int Instance.classIndex()>
    //  202  538:icmpne          544
    //  203  541:goto            560
    //  204  544:aload           7
    //  205  546:iload           5
    //  206  548:invokevirtual   #484 <Method boolean Instance.isMissing(int)>
    //  207  551:ifeq            560
                    missing = true;
    //  208  554:iconst_1        
    //  209  555:istore          8
                    break;
    //  210  557:goto            572
                }

    //  211  560:iinc            5  1
    //  212  563:iload           5
    //  213  565:aload_0         
    //  214  566:invokevirtual   #401 <Method int Instances.numAttributes()>
    //  215  569:icmplt          531
            }
            if(!missing)
                continue;
    //  216  572:iload           8
    //  217  574:ifeq            587
            result.enable(Capability.MISSING_VALUES);
    //  218  577:aload_2         
    //  219  578:getstatic       #232 <Field Capabilities$Capability Capabilities$Capability.MISSING_VALUES>
    //  220  581:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
            break;
    //  221  584:goto            599
        }

    //  222  587:iinc            4  1
    //  223  590:iload           4
    //  224  592:aload_0         
    //  225  593:invokevirtual   #467 <Method int Instances.numInstances()>
    //  226  596:icmplt          449
        if(multi && data.numAttributes() == 3 && data.attribute(0).isNominal() && data.attribute(1).isRelationValued() && data.classIndex() == data.numAttributes() - 1)
    //* 227  599:iload_1         
    //* 228  600:ifeq            689
    //* 229  603:aload_0         
    //* 230  604:invokevirtual   #401 <Method int Instances.numAttributes()>
    //* 231  607:iconst_3        
    //* 232  608:icmpne          689
    //* 233  611:aload_0         
    //* 234  612:iconst_0        
    //* 235  613:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //* 236  616:invokevirtual   #500 <Method boolean Attribute.isNominal()>
    //* 237  619:ifeq            689
    //* 238  622:aload_0         
    //* 239  623:iconst_1        
    //* 240  624:invokevirtual   #431 <Method Attribute Instances.attribute(int)>
    //* 241  627:invokevirtual   #503 <Method boolean Attribute.isRelationValued()>
    //* 242  630:ifeq            689
    //* 243  633:aload_0         
    //* 244  634:invokevirtual   #427 <Method int Instances.classIndex()>
    //* 245  637:aload_0         
    //* 246  638:invokevirtual   #401 <Method int Instances.numAttributes()>
    //* 247  641:iconst_1        
    //* 248  642:isub            
    //* 249  643:icmpne          689
        {
            Capabilities multiInstance = new Capabilities(null);
    //  250  646:new             #2   <Class Capabilities>
    //  251  649:dup             
    //  252  650:aconst_null     
    //  253  651:invokespecial   #128 <Method void Capabilities(CapabilitiesHandler)>
    //  254  654:astore_3        
            multiInstance.or(result.getClassCapabilities());
    //  255  655:aload_3         
    //  256  656:aload_2         
    //  257  657:invokevirtual   #440 <Method Capabilities getClassCapabilities()>
    //  258  660:invokevirtual   #634 <Method void or(Capabilities)>
            multiInstance.enable(Capability.NOMINAL_ATTRIBUTES);
    //  259  663:aload_3         
    //  260  664:getstatic       #194 <Field Capabilities$Capability Capabilities$Capability.NOMINAL_ATTRIBUTES>
    //  261  667:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
            multiInstance.enable(Capability.RELATIONAL_ATTRIBUTES);
    //  262  670:aload_3         
    //  263  671:getstatic       #382 <Field Capabilities$Capability Capabilities$Capability.RELATIONAL_ATTRIBUTES>
    //  264  674:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
            multiInstance.enable(Capability.ONLY_MULTIINSTANCE);
    //  265  677:aload_3         
    //  266  678:getstatic       #495 <Field Capabilities$Capability Capabilities$Capability.ONLY_MULTIINSTANCE>
    //  267  681:invokevirtual   #147 <Method void enable(Capabilities$Capability)>
            result.assign(multiInstance);
    //  268  684:aload_2         
    //  269  685:aload_3         
    //  270  686:invokevirtual   #132 <Method void assign(Capabilities)>
        }
        return result;
    //  271  689:aload_2         
    //  272  690:areturn         
    }

    public static void main(String args[])
        throws Exception
    {
        if(args.length == 0)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:ifne            39
        {
            System.out.println((new StringBuilder("\nUsage: ")).append(rm/core/Capabilities.getName()).append(" -file <dataset> [-c <class index>]\n").toString());
    //    3    5:getstatic       #641 <Field PrintStream System.out>
    //    4    8:new             #299 <Class StringBuilder>
    //    5   11:dup             
    //    6   12:ldc2            #643 <String "\nUsage: ">
    //    7   15:invokespecial   #308 <Method void StringBuilder(String)>
    //    8   18:ldc1            #2   <Class Capabilities>
    //    9   20:invokevirtual   #295 <Method String Class.getName()>
    //   10   23:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   11   26:ldc2            #645 <String " -file <dataset> [-c <class index>]\n">
    //   12   29:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   13   32:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   14   35:invokevirtual   #419 <Method void PrintStream.println(String)>
            return;
    //   15   38:return          
        }
        String tmpStr = Utils.getOption("file", args);
    //   16   39:ldc2            #647 <String "file">
    //   17   42:aload_0         
    //   18   43:invokestatic    #651 <Method String Utils.getOption(String, String[])>
    //   19   46:astore_1        
        if(tmpStr.length() == 0)
    //*  20   47:aload_1         
    //*  21   48:invokevirtual   #654 <Method int String.length()>
    //*  22   51:ifne            65
            throw new Exception("No file provided with option '-file'!");
    //   23   54:new             #74  <Class Exception>
    //   24   57:dup             
    //   25   58:ldc2            #656 <String "No file provided with option '-file'!">
    //   26   61:invokespecial   #657 <Method void Exception(String)>
    //   27   64:athrow          
        String filename = tmpStr;
    //   28   65:aload_1         
    //   29   66:astore_2        
        tmpStr = Utils.getOption("c", args);
    //   30   67:ldc2            #658 <String "c">
    //   31   70:aload_0         
    //   32   71:invokestatic    #651 <Method String Utils.getOption(String, String[])>
    //   33   74:astore_1        
        int classIndex;
        if(tmpStr.length() != 0)
    //*  34   75:aload_1         
    //*  35   76:invokevirtual   #654 <Method int String.length()>
    //*  36   79:ifeq            126
        {
            if(tmpStr.equals("first"))
    //*  37   82:aload_1         
    //*  38   83:ldc2            #660 <String "first">
    //*  39   86:invokevirtual   #663 <Method boolean String.equals(Object)>
    //*  40   89:ifeq            98
                classIndex = 0;
    //   41   92:iconst_0        
    //   42   93:istore          5
            else
    //*  43   95:goto            130
            if(tmpStr.equals("last"))
    //*  44   98:aload_1         
    //*  45   99:ldc2            #665 <String "last">
    //*  46  102:invokevirtual   #663 <Method boolean String.equals(Object)>
    //*  47  105:ifeq            115
                classIndex = -2;
    //   48  108:bipush          -2
    //   49  110:istore          5
            else
    //*  50  112:goto            130
                classIndex = Integer.parseInt(tmpStr) - 1;
    //   51  115:aload_1         
    //   52  116:invokestatic    #671 <Method int Integer.parseInt(String)>
    //   53  119:iconst_1        
    //   54  120:isub            
    //   55  121:istore          5
        } else
    //*  56  123:goto            130
        {
            classIndex = -3;
    //   57  126:bipush          -3
    //   58  128:istore          5
        }
        rm.core.converters.ConverterUtils.DataSource source = new rm.core.converters.ConverterUtils.DataSource(filename);
    //   59  130:new             #673 <Class rm.core.converters.ConverterUtils$DataSource>
    //   60  133:dup             
    //   61  134:aload_2         
    //   62  135:invokespecial   #674 <Method void rm.core.converters.ConverterUtils$DataSource(String)>
    //   63  138:astore_3        
        Instances data;
        if(classIndex == -3)
    //*  64  139:iload           5
    //*  65  141:bipush          -3
    //*  66  143:icmpne          155
            data = source.getDataSet();
    //   67  146:aload_3         
    //   68  147:invokevirtual   #678 <Method Instances rm.core.converters.ConverterUtils$DataSource.getDataSet()>
    //   69  150:astore          4
        else
    //*  70  152:goto            188
        if(classIndex == -2)
    //*  71  155:iload           5
    //*  72  157:bipush          -2
    //*  73  159:icmpne          180
            data = source.getDataSet(source.getStructure().numAttributes() - 1);
    //   74  162:aload_3         
    //   75  163:aload_3         
    //   76  164:invokevirtual   #681 <Method Instances rm.core.converters.ConverterUtils$DataSource.getStructure()>
    //   77  167:invokevirtual   #401 <Method int Instances.numAttributes()>
    //   78  170:iconst_1        
    //   79  171:isub            
    //   80  172:invokevirtual   #683 <Method Instances rm.core.converters.ConverterUtils$DataSource.getDataSet(int)>
    //   81  175:astore          4
        else
    //*  82  177:goto            188
            data = source.getDataSet(classIndex);
    //   83  180:aload_3         
    //   84  181:iload           5
    //   85  183:invokevirtual   #683 <Method Instances rm.core.converters.ConverterUtils$DataSource.getDataSet(int)>
    //   86  186:astore          4
        Capabilities cap = forInstances(data);
    //   87  188:aload           4
    //   88  190:invokestatic    #685 <Method Capabilities forInstances(Instances)>
    //   89  193:astore          6
        System.out.println((new StringBuilder("File: ")).append(filename).toString());
    //   90  195:getstatic       #641 <Field PrintStream System.out>
    //   91  198:new             #299 <Class StringBuilder>
    //   92  201:dup             
    //   93  202:ldc2            #687 <String "File: ">
    //   94  205:invokespecial   #308 <Method void StringBuilder(String)>
    //   95  208:aload_2         
    //   96  209:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //   97  212:invokevirtual   #317 <Method String StringBuilder.toString()>
    //   98  215:invokevirtual   #419 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("Class index: ")).append(data.classIndex() != -1 ? (new StringBuilder()).append(data.classIndex() + 1).toString() : "not set").toString());
    //   99  218:getstatic       #641 <Field PrintStream System.out>
    //  100  221:new             #299 <Class StringBuilder>
    //  101  224:dup             
    //  102  225:ldc2            #689 <String "Class index: ">
    //  103  228:invokespecial   #308 <Method void StringBuilder(String)>
    //  104  231:aload           4
    //  105  233:invokevirtual   #427 <Method int Instances.classIndex()>
    //  106  236:iconst_m1       
    //  107  237:icmpne          246
    //  108  240:ldc2            #691 <String "not set">
    //  109  243:goto            266
    //  110  246:new             #299 <Class StringBuilder>
    //  111  249:dup             
    //  112  250:invokespecial   #692 <Method void StringBuilder()>
    //  113  253:aload           4
    //  114  255:invokevirtual   #427 <Method int Instances.classIndex()>
    //  115  258:iconst_1        
    //  116  259:iadd            
    //  117  260:invokevirtual   #389 <Method StringBuilder StringBuilder.append(int)>
    //  118  263:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  119  266:invokevirtual   #314 <Method StringBuilder StringBuilder.append(String)>
    //  120  269:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  121  272:invokevirtual   #419 <Method void PrintStream.println(String)>
        System.out.println("Capabilities:");
    //  122  275:getstatic       #641 <Field PrintStream System.out>
    //  123  278:ldc2            #694 <String "Capabilities:">
    //  124  281:invokevirtual   #419 <Method void PrintStream.println(String)>
        for(Iterator iter = cap.capabilities(); iter.hasNext(); System.out.println((new StringBuilder("- ")).append(iter.next()).toString()));
    //  125  284:aload           6
    //  126  286:invokevirtual   #442 <Method Iterator capabilities()>
    //  127  289:astore          7
    //  128  291:goto            323
    //  129  294:getstatic       #641 <Field PrintStream System.out>
    //  130  297:new             #299 <Class StringBuilder>
    //  131  300:dup             
    //  132  301:ldc2            #696 <String "- ">
    //  133  304:invokespecial   #308 <Method void StringBuilder(String)>
    //  134  307:aload           7
    //  135  309:invokeinterface #594 <Method Object Iterator.next()>
    //  136  314:invokevirtual   #630 <Method StringBuilder StringBuilder.append(Object)>
    //  137  317:invokevirtual   #317 <Method String StringBuilder.toString()>
    //  138  320:invokevirtual   #419 <Method void PrintStream.println(String)>
    //  139  323:aload           7
    //  140  325:invokeinterface #447 <Method boolean Iterator.hasNext()>
    //  141  330:ifne            294
    //  142  333:return          
    }

    public static final String PROPERTIES_FILE = "rm/core/Capabilities.props";
    protected static Properties PROPERTIES;
    private static final int ATTRIBUTE = 1;
    private static final int CLASS = 2;
    private static final int ATTRIBUTE_CAPABILITY = 4;
    private static final int CLASS_CAPABILITY = 8;
    private static final int OTHER_CAPABILITY = 16;
    protected CapabilitiesHandler m_Owner;
    protected HashSet m_Capabilities;
    protected HashSet m_Dependencies;
    protected Exception m_FailReason;
    protected int m_MinimumNumberInstances;
    protected boolean m_Test;
    protected boolean m_InstancesTest;
    protected boolean m_AttributeTest;
    protected boolean m_MissingValuesTest;
    protected boolean m_MissingClassValuesTest;
    protected boolean m_MinimumNumberInstancesTest;
    static Class class$0;
    static Class class$1;
}

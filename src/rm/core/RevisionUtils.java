// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RevisionUtils.java

package rm.core;

import java.io.PrintStream;

// Referenced classes of package rm.core:
//            RevisionHandler

public class RevisionUtils
{
    public static class Type extends Enum
    {

        public static final Type[] values()
        {
            Type atype[];
            int i;
            Type atype1[];
            System.arraycopy(atype = ENUM$VALUES, 0, atype1 = new Type[i = atype.length], 0, i);
        //    0    0:getstatic       #28  <Field RevisionUtils$Type[] ENUM$VALUES>
        //    1    3:dup             
        //    2    4:astore_0        
        //    3    5:iconst_0        
        //    4    6:aload_0         
        //    5    7:arraylength     
        //    6    8:dup             
        //    7    9:istore_1        
        //    8   10:anewarray       Type[]
        //    9   13:dup             
        //   10   14:astore_2        
        //   11   15:iconst_0        
        //   12   16:iload_1         
        //   13   17:invokestatic    #40  <Method void System.arraycopy(Object, int, Object, int, int)>
            return atype1;
        //   14   20:aload_2         
        //   15   21:areturn         
        }

        public static final Type valueOf(String s)
        {
            Type atype[];
            Type type;
            for(int i = (atype = ENUM$VALUES).length; --i >= 0;)
        //*   0    0:getstatic       #28  <Field RevisionUtils$Type[] ENUM$VALUES>
        //*   1    3:dup             
        //*   2    4:astore_1        
        //*   3    5:arraylength     
        //*   4    6:istore_2        
        //*   5    7:goto            27
                if(s.equals((type = atype[i]).name()))
        //*   6   10:aload_0         
        //*   7   11:aload_1         
        //*   8   12:iload_2         
        //*   9   13:aaload          
        //*  10   14:dup             
        //*  11   15:astore_3        
        //*  12   16:invokevirtual   #46  <Method String name()>
        //*  13   19:invokevirtual   #52  <Method boolean String.equals(Object)>
        //*  14   22:ifeq            27
                    return type;
        //   15   25:aload_3         
        //   16   26:areturn         

        //   17   27:iinc            2  -1
        //   18   30:iload_2         
        //   19   31:ifge            10
            throw new IllegalArgumentException(s);
        //   20   34:new             #54  <Class IllegalArgumentException>
        //   21   37:dup             
        //   22   38:aload_0         
        //   23   39:invokespecial   #57  <Method void IllegalArgumentException(String)>
        //   24   42:athrow          
        }

        public static final Type UNKNOWN;
        public static final Type CVS;
        public static final Type SUBVERSION;
        private static final Type ENUM$VALUES[];

        static 
        {
            UNKNOWN = new Type("UNKNOWN", 0);
        //    0    0:new             #2   <Class RevisionUtils$Type>
        //    1    3:dup             
        //    2    4:ldc1            #14  <String "UNKNOWN">
        //    3    6:iconst_0        
        //    4    7:invokespecial   #18  <Method void RevisionUtils$Type(String, int)>
        //    5   10:putstatic       #20  <Field RevisionUtils$Type UNKNOWN>
            CVS = new Type("CVS", 1);
        //    6   13:new             #2   <Class RevisionUtils$Type>
        //    7   16:dup             
        //    8   17:ldc1            #21  <String "CVS">
        //    9   19:iconst_1        
        //   10   20:invokespecial   #18  <Method void RevisionUtils$Type(String, int)>
        //   11   23:putstatic       #23  <Field RevisionUtils$Type CVS>
            SUBVERSION = new Type("SUBVERSION", 2);
        //   12   26:new             #2   <Class RevisionUtils$Type>
        //   13   29:dup             
        //   14   30:ldc1            #24  <String "SUBVERSION">
        //   15   32:iconst_2        
        //   16   33:invokespecial   #18  <Method void RevisionUtils$Type(String, int)>
        //   17   36:putstatic       #26  <Field RevisionUtils$Type SUBVERSION>
            ENUM$VALUES = (new Type[] {
                UNKNOWN, CVS, SUBVERSION
            });
        //   18   39:iconst_3        
        //   19   40:anewarray       Type[]
        //   20   43:dup             
        //   21   44:iconst_0        
        //   22   45:getstatic       #20  <Field RevisionUtils$Type UNKNOWN>
        //   23   48:aastore         
        //   24   49:dup             
        //   25   50:iconst_1        
        //   26   51:getstatic       #23  <Field RevisionUtils$Type CVS>
        //   27   54:aastore         
        //   28   55:dup             
        //   29   56:iconst_2        
        //   30   57:getstatic       #26  <Field RevisionUtils$Type SUBVERSION>
        //   31   60:aastore         
        //   32   61:putstatic       #28  <Field RevisionUtils$Type[] ENUM$VALUES>
        //*  33   64:return          
        }

        private Type(String s, int i)
        {
            super(s, i);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iload_2         
        //    3    3:invokespecial   #31  <Method void Enum(String, int)>
        //    4    6:return          
        }
    }


    public RevisionUtils()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #11  <Method void Object()>
    //    2    4:return          
    }

    public static String extract(RevisionHandler handler)
    {
        return extract(handler.getRevision());
    //    0    0:aload_0         
    //    1    1:invokeinterface #23  <Method String RevisionHandler.getRevision()>
    //    2    6:invokestatic    #26  <Method String extract(String)>
    //    3    9:areturn         
    }

    public static String extract(String s)
    {
        String result = s;
    //    0    0:aload_0         
    //    1    1:astore_1        
        result = result.replaceAll("\\$Revision:", "");
    //    2    2:aload_1         
    //    3    3:ldc1            #30  <String "\\$Revision:">
    //    4    5:ldc1            #32  <String "">
    //    5    7:invokevirtual   #38  <Method String String.replaceAll(String, String)>
    //    6   10:astore_1        
        result = result.replaceAll("\\$", "");
    //    7   11:aload_1         
    //    8   12:ldc1            #40  <String "\\$">
    //    9   14:ldc1            #32  <String "">
    //   10   16:invokevirtual   #38  <Method String String.replaceAll(String, String)>
    //   11   19:astore_1        
        result = result.replaceAll(" ", "");
    //   12   20:aload_1         
    //   13   21:ldc1            #42  <String " ">
    //   14   23:ldc1            #32  <String "">
    //   15   25:invokevirtual   #38  <Method String String.replaceAll(String, String)>
    //   16   28:astore_1        
        return result;
    //   17   29:aload_1         
    //   18   30:areturn         
    }

    public static Type getType(RevisionHandler handler)
    {
        return getType(extract(handler));
    //    0    0:aload_0         
    //    1    1:invokestatic    #49  <Method String extract(RevisionHandler)>
    //    2    4:invokestatic    #52  <Method RevisionUtils$Type getType(String)>
    //    3    7:areturn         
    }

    public static Type getType(String revision)
    {
        Type result = Type.UNKNOWN;
    //    0    0:getstatic       #58  <Field RevisionUtils$Type RevisionUtils$Type.UNKNOWN>
    //    1    3:astore_1        
        try
        {
            Integer.parseInt(revision);
    //    2    4:aload_0         
    //    3    5:invokestatic    #64  <Method int Integer.parseInt(String)>
    //    4    8:pop             
            result = Type.SUBVERSION;
    //    5    9:getstatic       #67  <Field RevisionUtils$Type RevisionUtils$Type.SUBVERSION>
    //    6   12:astore_1        
        }
    //*   7   13:goto            18
        catch(Exception exception) { }
    //    8   16:astore          4
        if(result == Type.UNKNOWN)
    //*   9   18:aload_1         
    //*  10   19:getstatic       #58  <Field RevisionUtils$Type RevisionUtils$Type.UNKNOWN>
    //*  11   22:if_acmpne       98
            try
            {
                if(revision.indexOf('.') == -1)
    //*  12   25:aload_0         
    //*  13   26:bipush          46
    //*  14   28:invokevirtual   #71  <Method int String.indexOf(int)>
    //*  15   31:iconst_m1       
    //*  16   32:icmpne          45
                    throw new Exception("invalid CVS revision - not dots!");
    //   17   35:new             #73  <Class Exception>
    //   18   38:dup             
    //   19   39:ldc1            #75  <String "invalid CVS revision - not dots!">
    //   20   41:invokespecial   #78  <Method void Exception(String)>
    //   21   44:athrow          
                String parts[] = revision.split("\\.");
    //   22   45:aload_0         
    //   23   46:ldc1            #80  <String "\\.">
    //   24   48:invokevirtual   #84  <Method String[] String.split(String)>
    //   25   51:astore_2        
                if(parts.length < 2)
    //*  26   52:aload_2         
    //*  27   53:arraylength     
    //*  28   54:iconst_2        
    //*  29   55:icmpge          68
                    throw new Exception("invalid CVS revision - not enough parts separated by dots!");
    //   30   58:new             #73  <Class Exception>
    //   31   61:dup             
    //   32   62:ldc1            #86  <String "invalid CVS revision - not enough parts separated by dots!">
    //   33   64:invokespecial   #78  <Method void Exception(String)>
    //   34   67:athrow          
                for(int i = 0; i < parts.length; i++)
    //*  35   68:iconst_0        
    //*  36   69:istore_3        
    //*  37   70:goto            83
                    Integer.parseInt(parts[i]);
    //   38   73:aload_2         
    //   39   74:iload_3         
    //   40   75:aaload          
    //   41   76:invokestatic    #64  <Method int Integer.parseInt(String)>
    //   42   79:pop             

    //   43   80:iinc            3  1
    //   44   83:iload_3         
    //   45   84:aload_2         
    //   46   85:arraylength     
    //   47   86:icmplt          73
                result = Type.CVS;
    //   48   89:getstatic       #89  <Field RevisionUtils$Type RevisionUtils$Type.CVS>
    //   49   92:astore_1        
            }
    //*  50   93:goto            98
            catch(Exception exception1) { }
    //   51   96:astore          4
        return result;
    //   52   98:aload_1         
    //   53   99:areturn         
    }

    public static void main(String args[])
        throws Exception
    {
        if(args.length != 1)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:iconst_1        
    //*   3    3:icmpeq          41
        {
            System.err.println((new StringBuilder("\nUsage: ")).append(rm/core/RevisionUtils.getName()).append(" <classname>\n").toString());
    //    4    6:getstatic       #103 <Field PrintStream System.err>
    //    5    9:new             #105 <Class StringBuilder>
    //    6   12:dup             
    //    7   13:ldc1            #107 <String "\nUsage: ">
    //    8   15:invokespecial   #108 <Method void StringBuilder(String)>
    //    9   18:ldc1            #2   <Class RevisionUtils>
    //   10   20:invokevirtual   #113 <Method String Class.getName()>
    //   11   23:invokevirtual   #117 <Method StringBuilder StringBuilder.append(String)>
    //   12   26:ldc1            #119 <String " <classname>\n">
    //   13   28:invokevirtual   #117 <Method StringBuilder StringBuilder.append(String)>
    //   14   31:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   15   34:invokevirtual   #127 <Method void PrintStream.println(String)>
            System.exit(1);
    //   16   37:iconst_1        
    //   17   38:invokestatic    #131 <Method void System.exit(int)>
        }
        RevisionHandler handler = (RevisionHandler)(RevisionHandler)Class.forName(args[0]).newInstance();
    //   18   41:aload_0         
    //   19   42:iconst_0        
    //   20   43:aaload          
    //   21   44:invokestatic    #135 <Method Class Class.forName(String)>
    //   22   47:invokevirtual   #139 <Method Object Class.newInstance()>
    //   23   50:checkcast       #19  <Class RevisionHandler>
    //   24   53:checkcast       #19  <Class RevisionHandler>
    //   25   56:astore_1        
        System.out.println((new StringBuilder("Type: ")).append(getType(handler)).toString());
    //   26   57:getstatic       #142 <Field PrintStream System.out>
    //   27   60:new             #105 <Class StringBuilder>
    //   28   63:dup             
    //   29   64:ldc1            #144 <String "Type: ">
    //   30   66:invokespecial   #108 <Method void StringBuilder(String)>
    //   31   69:aload_1         
    //   32   70:invokestatic    #146 <Method RevisionUtils$Type getType(RevisionHandler)>
    //   33   73:invokevirtual   #149 <Method StringBuilder StringBuilder.append(Object)>
    //   34   76:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   35   79:invokevirtual   #127 <Method void PrintStream.println(String)>
        System.out.println((new StringBuilder("Revision: ")).append(extract(handler)).toString());
    //   36   82:getstatic       #142 <Field PrintStream System.out>
    //   37   85:new             #105 <Class StringBuilder>
    //   38   88:dup             
    //   39   89:ldc1            #151 <String "Revision: ">
    //   40   91:invokespecial   #108 <Method void StringBuilder(String)>
    //   41   94:aload_1         
    //   42   95:invokestatic    #49  <Method String extract(RevisionHandler)>
    //   43   98:invokevirtual   #117 <Method StringBuilder StringBuilder.append(String)>
    //   44  101:invokevirtual   #122 <Method String StringBuilder.toString()>
    //   45  104:invokevirtual   #127 <Method void PrintStream.println(String)>
    //   46  107:return          
    }

    static Class class$0;
}

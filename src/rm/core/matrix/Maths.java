// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Maths.java

package rm.core.matrix;


public class Maths
{

    public Maths()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #9   <Method void Object()>
    //    2    4:return          
    }

    public static double hypot(double a, double b)
    {
        double r;
        if(Math.abs(a) > Math.abs(b))
    //*   0    0:dload_0         
    //*   1    1:invokestatic    #21  <Method double Math.abs(double)>
    //*   2    4:dload_2         
    //*   3    5:invokestatic    #21  <Method double Math.abs(double)>
    //*   4    8:dcmpl           
    //*   5    9:ifle            37
        {
            r = b / a;
    //    6   12:dload_2         
    //    7   13:dload_0         
    //    8   14:ddiv            
    //    9   15:dstore          4
            r = Math.abs(a) * Math.sqrt(1.0D + r * r);
    //   10   17:dload_0         
    //   11   18:invokestatic    #21  <Method double Math.abs(double)>
    //   12   21:dconst_1        
    //   13   22:dload           4
    //   14   24:dload           4
    //   15   26:dmul            
    //   16   27:dadd            
    //   17   28:invokestatic    #24  <Method double Math.sqrt(double)>
    //   18   31:dmul            
    //   19   32:dstore          4
        } else
    //*  20   34:goto            71
        if(b != 0.0D)
    //*  21   37:dload_2         
    //*  22   38:dconst_0        
    //*  23   39:dcmpl           
    //*  24   40:ifeq            68
        {
            r = a / b;
    //   25   43:dload_0         
    //   26   44:dload_2         
    //   27   45:ddiv            
    //   28   46:dstore          4
            r = Math.abs(b) * Math.sqrt(1.0D + r * r);
    //   29   48:dload_2         
    //   30   49:invokestatic    #21  <Method double Math.abs(double)>
    //   31   52:dconst_1        
    //   32   53:dload           4
    //   33   55:dload           4
    //   34   57:dmul            
    //   35   58:dadd            
    //   36   59:invokestatic    #24  <Method double Math.sqrt(double)>
    //   37   62:dmul            
    //   38   63:dstore          4
        } else
    //*  39   65:goto            71
        {
            r = 0.0D;
    //   40   68:dconst_0        
    //   41   69:dstore          4
        }
        return r;
    //   42   71:dload           4
    //   43   73:dreturn         
    }
}

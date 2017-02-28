// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   OBLP.java

package rm.assignment;

import java.io.File;
import java.io.FileReader;
import rm.core.Matrix;
import rm.core.converters.AssLoader;

public class OBLP
{
    private class GenoType
    {

        public int gk;
        public int gcp;
        public int grp;
        public double rweight;
        public double cweight;
        public double weight;
        final OBLP this$0;

        GenoType()
        {
            this$0 = OBLP.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #19  <Field OBLP this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #22  <Method void Object()>
        //    5    9:return          
        }
    }

    private class Min_OBLP
    {

        public GenoType gmo;
        public int n;
        final OBLP this$0;

        Min_OBLP()
        {
            this$0 = OBLP.this;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #15  <Field OBLP this$0>
            super();
        //    3    5:aload_0         
        //    4    6:invokespecial   #18  <Method void Object()>
            gmo = new GenoType();
        //    5    9:aload_0         
        //    6   10:new             #20  <Class OBLP$GenoType>
        //    7   13:dup             
        //    8   14:aload_1         
        //    9   15:invokespecial   #22  <Method void OBLP$GenoType(OBLP)>
        //   10   18:putfield        #24  <Field OBLP$GenoType gmo>
        //   11   21:return          
        }
    }


    public OBLP()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #32  <Method void Object()>
        POPSIZE = -1;
    //    2    4:aload_0         
    //    3    5:iconst_m1       
    //    4    6:putfield        #34  <Field int POPSIZE>
    //    5    9:aload_0         
    //    6   10:sipush          1000
    //    7   13:putfield        #36  <Field int MAXGENS>
    //    8   16:aload_0         
    //    9   17:ldc2w           #12  <Double 0.75D>
    //   10   20:putfield        #38  <Field double PXOVER>
    //   11   23:aload_0         
    //   12   24:ldc2w           #15  <Double 0.14999999999999999D>
    //   13   27:putfield        #40  <Field double PMUTATION>
    //   14   30:aload_0         
    //   15   31:sipush          800
    //   16   34:putfield        #42  <Field int PUNISH>
    //   17   37:return          
    }

    public static void main(String args[])
    {
        try
        {
            File fileroles = new File((new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("\\datasets\\testrole.ass").toString());
    //    0    0:new             #50  <Class File>
    //    1    3:dup             
    //    2    4:new             #52  <Class StringBuilder>
    //    3    7:dup             
    //    4    8:ldc1            #54  <String "user.dir">
    //    5   10:invokestatic    #60  <Method String System.getProperty(String)>
    //    6   13:invokestatic    #66  <Method String String.valueOf(Object)>
    //    7   16:invokespecial   #69  <Method void StringBuilder(String)>
    //    8   19:ldc1            #71  <String "\\datasets\\testrole.ass">
    //    9   21:invokevirtual   #75  <Method StringBuilder StringBuilder.append(String)>
    //   10   24:invokevirtual   #79  <Method String StringBuilder.toString()>
    //   11   27:invokespecial   #80  <Method void File(String)>
    //   12   30:astore_1        
            AssLoader ALRoles = new AssLoader(new FileReader(fileroles));
    //   13   31:new             #82  <Class AssLoader>
    //   14   34:dup             
    //   15   35:new             #84  <Class FileReader>
    //   16   38:dup             
    //   17   39:aload_1         
    //   18   40:invokespecial   #87  <Method void FileReader(File)>
    //   19   43:invokespecial   #90  <Method void AssLoader(FileReader)>
    //   20   46:astore_2        
            rm.core.Assignment roles = ALRoles.getData();
    //   21   47:aload_2         
    //   22   48:invokevirtual   #94  <Method rm.core.Assignment AssLoader.getData()>
    //   23   51:astore_3        
        }
    //*  24   52:goto            60
        catch(Exception e)
    //*  25   55:astore_1        
        {
            e.printStackTrace();
    //   26   56:aload_1         
    //   27   57:invokevirtual   #99  <Method void Exception.printStackTrace()>
        }
    //   28   60:return          
    }

    private int POPSIZE;
    private final int MAXGENS = 1000;
    private final double PXOVER = 0.75D;
    private final double PMUTATION = 0.14999999999999999D;
    private final int PUNISH = 800;
    private GenoType Unit[];
    private GenoType NewUnit[];
    private Min_OBLP mgoblp[];
    Matrix PA;
    double pweight[];
}

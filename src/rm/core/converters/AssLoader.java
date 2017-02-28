// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AssLoader.java

package rm.core.converters;

import java.io.*;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            ArffLoader

public class AssLoader
{

    public AssLoader(FileReader reader)
        throws IOException
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
        Ass = new Assignment();
    //    2    4:aload_0         
    //    3    5:new             #22  <Class Assignment>
    //    4    8:dup             
    //    5    9:invokespecial   #23  <Method void Assignment()>
    //    6   12:putfield        #25  <Field Assignment Ass>
        dimensionX = new Dimension();
    //    7   15:aload_0         
    //    8   16:new             #27  <Class Dimension>
    //    9   19:dup             
    //   10   20:invokespecial   #28  <Method void Dimension()>
    //   11   23:putfield        #30  <Field Dimension dimensionX>
        dimensionY = new Dimension();
    //   12   26:aload_0         
    //   13   27:new             #27  <Class Dimension>
    //   14   30:dup             
    //   15   31:invokespecial   #28  <Method void Dimension()>
    //   16   34:putfield        #32  <Field Dimension dimensionY>
        String StrData = "";
    //   17   37:ldc1            #34  <String "">
    //   18   39:astore_2        
        String temp = "";
    //   19   40:ldc1            #34  <String "">
    //   20   42:astore_3        
        try
        {
            BufferedReader br = new BufferedReader(reader);
    //   21   43:new             #36  <Class BufferedReader>
    //   22   46:dup             
    //   23   47:aload_1         
    //   24   48:invokespecial   #39  <Method void BufferedReader(java.io.Reader)>
    //   25   51:astore          4
    //*  26   53:goto            80
            while((temp = br.readLine()) != null) 
                StrData = (new StringBuilder(String.valueOf(StrData))).append(temp).append("\r\n").toString();
    //   27   56:new             #41  <Class StringBuilder>
    //   28   59:dup             
    //   29   60:aload_2         
    //   30   61:invokestatic    #47  <Method String String.valueOf(Object)>
    //   31   64:invokespecial   #50  <Method void StringBuilder(String)>
    //   32   67:aload_3         
    //   33   68:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   34   71:ldc1            #56  <String "\r\n">
    //   35   73:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   36   76:invokevirtual   #60  <Method String StringBuilder.toString()>
    //   37   79:astore_2        
    //   38   80:aload           4
    //   39   82:invokevirtual   #63  <Method String BufferedReader.readLine()>
    //   40   85:dup             
    //   41   86:astore_3        
    //   42   87:ifnonnull       56
        }
    //*  43   90:goto            100
        catch(FileNotFoundException e)
    //*  44   93:astore          4
        {
            e.printStackTrace();
    //   45   95:aload           4
    //   46   97:invokevirtual   #68  <Method void FileNotFoundException.printStackTrace()>
        }
        InitData(StrData);
    //   47  100:aload_0         
    //   48  101:aload_2         
    //   49  102:invokespecial   #71  <Method void InitData(String)>
        reader.close();
    //   50  105:aload_1         
    //   51  106:invokevirtual   #76  <Method void FileReader.close()>
    //   52  109:return          
    }

    public AssLoader(String StrData)
        throws IOException
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #20  <Method void Object()>
        Ass = new Assignment();
    //    2    4:aload_0         
    //    3    5:new             #22  <Class Assignment>
    //    4    8:dup             
    //    5    9:invokespecial   #23  <Method void Assignment()>
    //    6   12:putfield        #25  <Field Assignment Ass>
        dimensionX = new Dimension();
    //    7   15:aload_0         
    //    8   16:new             #27  <Class Dimension>
    //    9   19:dup             
    //   10   20:invokespecial   #28  <Method void Dimension()>
    //   11   23:putfield        #30  <Field Dimension dimensionX>
        dimensionY = new Dimension();
    //   12   26:aload_0         
    //   13   27:new             #27  <Class Dimension>
    //   14   30:dup             
    //   15   31:invokespecial   #28  <Method void Dimension()>
    //   16   34:putfield        #32  <Field Dimension dimensionY>
        InitData(StrData);
    //   17   37:aload_0         
    //   18   38:aload_1         
    //   19   39:invokespecial   #71  <Method void InitData(String)>
    //   20   42:return          
    }

    private void InitData(String StrData)
        throws IOException
    {
        String SplitStr[] = StrData.split("@atributesof");
    //    0    0:aload_1         
    //    1    1:ldc1            #91  <String "@atributesof">
    //    2    3:invokevirtual   #95  <Method String[] String.split(String)>
    //    3    6:astore_2        
        String StrTemp = "";
    //    4    7:ldc1            #34  <String "">
    //    5    9:astore          4
        StrTemp = SplitStr[0].replaceAll("@dimension", "@attribute");
    //    6   11:aload_2         
    //    7   12:iconst_0        
    //    8   13:aaload          
    //    9   14:ldc1            #97  <String "@dimension">
    //   10   16:ldc1            #99  <String "@attribute">
    //   11   18:invokevirtual   #103 <Method String String.replaceAll(String, String)>
    //   12   21:astore          4
        StrTemp = StrTemp.replace("@assignment", "@atributesof");
    //   13   23:aload           4
    //   14   25:ldc1            #105 <String "@assignment">
    //   15   27:ldc1            #91  <String "@atributesof">
    //   16   29:invokevirtual   #109 <Method String String.replace(CharSequence, CharSequence)>
    //   17   32:astore          4
        String SplitStr2[] = StrTemp.split("@matrix");
    //   18   34:aload           4
    //   19   36:ldc1            #111 <String "@matrix">
    //   20   38:invokevirtual   #95  <Method String[] String.split(String)>
    //   21   41:astore          5
        SplitStr2[0] = (new StringBuilder(String.valueOf(SplitStr2[0]))).append(" ").append("@data").toString();
    //   22   43:aload           5
    //   23   45:iconst_0        
    //   24   46:new             #41  <Class StringBuilder>
    //   25   49:dup             
    //   26   50:aload           5
    //   27   52:iconst_0        
    //   28   53:aaload          
    //   29   54:invokestatic    #47  <Method String String.valueOf(Object)>
    //   30   57:invokespecial   #50  <Method void StringBuilder(String)>
    //   31   60:ldc1            #113 <String " ">
    //   32   62:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   33   65:ldc1            #115 <String "@data">
    //   34   67:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   35   70:invokevirtual   #60  <Method String StringBuilder.toString()>
    //   36   73:aastore         
        java.io.InputStream Data1 = new ByteArrayInputStream(SplitStr2[0].getBytes());
    //   37   74:new             #117 <Class ByteArrayInputStream>
    //   38   77:dup             
    //   39   78:aload           5
    //   40   80:iconst_0        
    //   41   81:aaload          
    //   42   82:invokevirtual   #121 <Method byte[] String.getBytes()>
    //   43   85:invokespecial   #124 <Method void ByteArrayInputStream(byte[])>
    //   44   88:astore          6
        ArffLoader loader = new ArffLoader();
    //   45   90:new             #126 <Class ArffLoader>
    //   46   93:dup             
    //   47   94:invokespecial   #127 <Method void ArffLoader()>
    //   48   97:astore          7
        loader.setSource(Data1);
    //   49   99:aload           7
    //   50  101:aload           6
    //   51  103:invokevirtual   #131 <Method void ArffLoader.setSource(java.io.InputStream)>
        Instances LatitudeAttributes = loader.getDataSet();
    //   52  106:aload           7
    //   53  108:invokevirtual   #135 <Method Instances ArffLoader.getDataSet()>
    //   54  111:astore_3        
        String Data2 = SplitStr2[1];
    //   55  112:aload           5
    //   56  114:iconst_1        
    //   57  115:aaload          
    //   58  116:astore          8
        BufferedReader br = new BufferedReader(new StringReader(Data2));
    //   59  118:new             #36  <Class BufferedReader>
    //   60  121:dup             
    //   61  122:new             #137 <Class StringReader>
    //   62  125:dup             
    //   63  126:aload           8
    //   64  128:invokespecial   #138 <Method void StringReader(String)>
    //   65  131:invokespecial   #39  <Method void BufferedReader(java.io.Reader)>
    //   66  134:astore          9
        Ass.setAssignmentMatrix(Matrix.read(br));
    //   67  136:aload_0         
    //   68  137:getfield        #25  <Field Assignment Ass>
    //   69  140:aload           9
    //   70  142:invokestatic    #144 <Method Matrix Matrix.read(BufferedReader)>
    //   71  145:invokevirtual   #148 <Method void Assignment.setAssignmentMatrix(Matrix)>
        Instances LatitudeInstances[] = new Instances[2];
    //   72  148:iconst_2        
    //   73  149:anewarray       Instances[]
    //   74  152:astore          10
        for(int i = 1; i < SplitStr.length; i++)
    //*  75  154:iconst_1        
    //*  76  155:istore          11
    //*  77  157:goto            230
        {
            SplitStr[i] = (new StringBuilder("@atributesof ")).append(SplitStr[i]).toString();
    //   78  160:aload_2         
    //   79  161:iload           11
    //   80  163:new             #41  <Class StringBuilder>
    //   81  166:dup             
    //   82  167:ldc1            #152 <String "@atributesof ">
    //   83  169:invokespecial   #50  <Method void StringBuilder(String)>
    //   84  172:aload_2         
    //   85  173:iload           11
    //   86  175:aaload          
    //   87  176:invokevirtual   #54  <Method StringBuilder StringBuilder.append(String)>
    //   88  179:invokevirtual   #60  <Method String StringBuilder.toString()>
    //   89  182:aastore         
            java.io.InputStream DataLatitude = new ByteArrayInputStream(SplitStr[i].getBytes());
    //   90  183:new             #117 <Class ByteArrayInputStream>
    //   91  186:dup             
    //   92  187:aload_2         
    //   93  188:iload           11
    //   94  190:aaload          
    //   95  191:invokevirtual   #121 <Method byte[] String.getBytes()>
    //   96  194:invokespecial   #124 <Method void ByteArrayInputStream(byte[])>
    //   97  197:astore          12
            loader = new ArffLoader();
    //   98  199:new             #126 <Class ArffLoader>
    //   99  202:dup             
    //  100  203:invokespecial   #127 <Method void ArffLoader()>
    //  101  206:astore          7
            loader.setSource(DataLatitude);
    //  102  208:aload           7
    //  103  210:aload           12
    //  104  212:invokevirtual   #131 <Method void ArffLoader.setSource(java.io.InputStream)>
            LatitudeInstances[i - 1] = loader.getDataSet();
    //  105  215:aload           10
    //  106  217:iload           11
    //  107  219:iconst_1        
    //  108  220:isub            
    //  109  221:aload           7
    //  110  223:invokevirtual   #135 <Method Instances ArffLoader.getDataSet()>
    //  111  226:aastore         
        }

    //  112  227:iinc            11  1
    //  113  230:iload           11
    //  114  232:aload_2         
    //  115  233:arraylength     
    //  116  234:icmplt          160
        dimensionX.setDimensionAttribute(LatitudeAttributes.attribute(0));
    //  117  237:aload_0         
    //  118  238:getfield        #30  <Field Dimension dimensionX>
    //  119  241:aload_3         
    //  120  242:iconst_0        
    //  121  243:invokevirtual   #156 <Method Attribute Instances.attribute(int)>
    //  122  246:invokevirtual   #160 <Method void Dimension.setDimensionAttribute(Attribute)>
        dimensionY.setDimensionAttribute(LatitudeAttributes.attribute(1));
    //  123  249:aload_0         
    //  124  250:getfield        #32  <Field Dimension dimensionY>
    //  125  253:aload_3         
    //  126  254:iconst_1        
    //  127  255:invokevirtual   #156 <Method Attribute Instances.attribute(int)>
    //  128  258:invokevirtual   #160 <Method void Dimension.setDimensionAttribute(Attribute)>
        if(LatitudeInstances[0] != null && LatitudeInstances[0].relationName().equals(dimensionX.getDimensionAttribute().name()))
    //* 129  261:aload           10
    //* 130  263:iconst_0        
    //* 131  264:aaload          
    //* 132  265:ifnull          305
    //* 133  268:aload           10
    //* 134  270:iconst_0        
    //* 135  271:aaload          
    //* 136  272:invokevirtual   #163 <Method String Instances.relationName()>
    //* 137  275:aload_0         
    //* 138  276:getfield        #30  <Field Dimension dimensionX>
    //* 139  279:invokevirtual   #167 <Method Attribute Dimension.getDimensionAttribute()>
    //* 140  282:invokevirtual   #172 <Method String Attribute.name()>
    //* 141  285:invokevirtual   #176 <Method boolean String.equals(Object)>
    //* 142  288:ifeq            305
            dimensionX.setDimensionInstances(LatitudeInstances[0]);
    //  143  291:aload_0         
    //  144  292:getfield        #30  <Field Dimension dimensionX>
    //  145  295:aload           10
    //  146  297:iconst_0        
    //  147  298:aaload          
    //  148  299:invokevirtual   #180 <Method void Dimension.setDimensionInstances(Instances)>
        else
    //* 149  302:goto            346
        if(LatitudeInstances[1] != null && LatitudeInstances[1].relationName().equals(dimensionX.getDimensionAttribute().name()))
    //* 150  305:aload           10
    //* 151  307:iconst_1        
    //* 152  308:aaload          
    //* 153  309:ifnull          346
    //* 154  312:aload           10
    //* 155  314:iconst_1        
    //* 156  315:aaload          
    //* 157  316:invokevirtual   #163 <Method String Instances.relationName()>
    //* 158  319:aload_0         
    //* 159  320:getfield        #30  <Field Dimension dimensionX>
    //* 160  323:invokevirtual   #167 <Method Attribute Dimension.getDimensionAttribute()>
    //* 161  326:invokevirtual   #172 <Method String Attribute.name()>
    //* 162  329:invokevirtual   #176 <Method boolean String.equals(Object)>
    //* 163  332:ifeq            346
            dimensionX.setDimensionInstances(LatitudeInstances[1]);
    //  164  335:aload_0         
    //  165  336:getfield        #30  <Field Dimension dimensionX>
    //  166  339:aload           10
    //  167  341:iconst_1        
    //  168  342:aaload          
    //  169  343:invokevirtual   #180 <Method void Dimension.setDimensionInstances(Instances)>
        if(LatitudeInstances[0] != null && LatitudeInstances[0].relationName().equals(dimensionY.getDimensionAttribute().name()))
    //* 170  346:aload           10
    //* 171  348:iconst_0        
    //* 172  349:aaload          
    //* 173  350:ifnull          390
    //* 174  353:aload           10
    //* 175  355:iconst_0        
    //* 176  356:aaload          
    //* 177  357:invokevirtual   #163 <Method String Instances.relationName()>
    //* 178  360:aload_0         
    //* 179  361:getfield        #32  <Field Dimension dimensionY>
    //* 180  364:invokevirtual   #167 <Method Attribute Dimension.getDimensionAttribute()>
    //* 181  367:invokevirtual   #172 <Method String Attribute.name()>
    //* 182  370:invokevirtual   #176 <Method boolean String.equals(Object)>
    //* 183  373:ifeq            390
            dimensionY.setDimensionInstances(LatitudeInstances[0]);
    //  184  376:aload_0         
    //  185  377:getfield        #32  <Field Dimension dimensionY>
    //  186  380:aload           10
    //  187  382:iconst_0        
    //  188  383:aaload          
    //  189  384:invokevirtual   #180 <Method void Dimension.setDimensionInstances(Instances)>
        else
    //* 190  387:goto            431
        if(LatitudeInstances[1] != null && LatitudeInstances[1].relationName().equals(dimensionY.getDimensionAttribute().name()))
    //* 191  390:aload           10
    //* 192  392:iconst_1        
    //* 193  393:aaload          
    //* 194  394:ifnull          431
    //* 195  397:aload           10
    //* 196  399:iconst_1        
    //* 197  400:aaload          
    //* 198  401:invokevirtual   #163 <Method String Instances.relationName()>
    //* 199  404:aload_0         
    //* 200  405:getfield        #32  <Field Dimension dimensionY>
    //* 201  408:invokevirtual   #167 <Method Attribute Dimension.getDimensionAttribute()>
    //* 202  411:invokevirtual   #172 <Method String Attribute.name()>
    //* 203  414:invokevirtual   #176 <Method boolean String.equals(Object)>
    //* 204  417:ifeq            431
            dimensionY.setDimensionInstances(LatitudeInstances[1]);
    //  205  420:aload_0         
    //  206  421:getfield        #32  <Field Dimension dimensionY>
    //  207  424:aload           10
    //  208  426:iconst_1        
    //  209  427:aaload          
    //  210  428:invokevirtual   #180 <Method void Dimension.setDimensionInstances(Instances)>
        Ass.setDimensionX(dimensionX);
    //  211  431:aload_0         
    //  212  432:getfield        #25  <Field Assignment Ass>
    //  213  435:aload_0         
    //  214  436:getfield        #30  <Field Dimension dimensionX>
    //  215  439:invokevirtual   #184 <Method void Assignment.setDimensionX(Dimension)>
        Ass.setDimensionY(dimensionY);
    //  216  442:aload_0         
    //  217  443:getfield        #25  <Field Assignment Ass>
    //  218  446:aload_0         
    //  219  447:getfield        #32  <Field Dimension dimensionY>
    //  220  450:invokevirtual   #187 <Method void Assignment.setDimensionY(Dimension)>
        Ass.setAssignementName(LatitudeAttributes.relationName());
    //  221  453:aload_0         
    //  222  454:getfield        #25  <Field Assignment Ass>
    //  223  457:aload_3         
    //  224  458:invokevirtual   #163 <Method String Instances.relationName()>
    //  225  461:invokevirtual   #190 <Method void Assignment.setAssignementName(String)>
    //  226  464:return          
    }

    public Assignment getData()
    {
        return Ass;
    //    0    0:aload_0         
    //    1    1:getfield        #25  <Field Assignment Ass>
    //    2    4:areturn         
    }

    private Assignment Ass;
    private Dimension dimensionX;
    private Dimension dimensionY;
    private Matrix AssMatrix;
}

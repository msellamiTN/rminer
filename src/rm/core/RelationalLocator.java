// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   RelationalLocator.java

package rm.core;


// Referenced classes of package rm.core:
//            AttributeLocator, Instance, Instances, Attribute

public class RelationalLocator extends AttributeLocator
{

    public RelationalLocator(Instances data)
    {
        super(data, 4);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_4        
    //    3    3:invokespecial   #15  <Method void AttributeLocator(Instances, int)>
    //    4    6:return          
    }

    public RelationalLocator(Instances data, int fromIndex, int toIndex)
    {
        super(data, 4, fromIndex, toIndex);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_4        
    //    3    3:iload_2         
    //    4    4:iload_3         
    //    5    5:invokespecial   #25  <Method void AttributeLocator(Instances, int, int, int)>
    //    6    8:return          
    }

    public RelationalLocator(Instances data, int indices[])
    {
        super(data, 4, indices);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:iconst_4        
    //    3    3:aload_2         
    //    4    4:invokespecial   #32  <Method void AttributeLocator(Instances, int, int[])>
    //    5    7:return          
    }

    public static void copyRelationalValues(Instance inst, Instances destDataset, AttributeLocator strAtts)
    {
        if(inst.dataset() == null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #42  <Method Instances Instance.dataset()>
    //*   2    4:ifnonnull       17
            throw new IllegalArgumentException("Instance has no dataset assigned!!");
    //    3    7:new             #44  <Class IllegalArgumentException>
    //    4   10:dup             
    //    5   11:ldc1            #46  <String "Instance has no dataset assigned!!">
    //    6   13:invokespecial   #49  <Method void IllegalArgumentException(String)>
    //    7   16:athrow          
        if(inst.dataset().numAttributes() != destDataset.numAttributes())
    //*   8   17:aload_0         
    //*   9   18:invokevirtual   #42  <Method Instances Instance.dataset()>
    //*  10   21:invokevirtual   #55  <Method int Instances.numAttributes()>
    //*  11   24:aload_1         
    //*  12   25:invokevirtual   #55  <Method int Instances.numAttributes()>
    //*  13   28:icmpeq          73
        {
            throw new IllegalArgumentException((new StringBuilder("Src and Dest differ in # of attributes: ")).append(inst.dataset().numAttributes()).append(" != ").append(destDataset.numAttributes()).toString());
    //   14   31:new             #44  <Class IllegalArgumentException>
    //   15   34:dup             
    //   16   35:new             #57  <Class StringBuilder>
    //   17   38:dup             
    //   18   39:ldc1            #59  <String "Src and Dest differ in # of attributes: ">
    //   19   41:invokespecial   #60  <Method void StringBuilder(String)>
    //   20   44:aload_0         
    //   21   45:invokevirtual   #42  <Method Instances Instance.dataset()>
    //   22   48:invokevirtual   #55  <Method int Instances.numAttributes()>
    //   23   51:invokevirtual   #64  <Method StringBuilder StringBuilder.append(int)>
    //   24   54:ldc1            #66  <String " != ">
    //   25   56:invokevirtual   #69  <Method StringBuilder StringBuilder.append(String)>
    //   26   59:aload_1         
    //   27   60:invokevirtual   #55  <Method int Instances.numAttributes()>
    //   28   63:invokevirtual   #64  <Method StringBuilder StringBuilder.append(int)>
    //   29   66:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   30   69:invokespecial   #49  <Method void IllegalArgumentException(String)>
    //   31   72:athrow          
        } else
        {
            copyRelationalValues(inst, true, inst.dataset(), strAtts, destDataset, strAtts);
    //   32   73:aload_0         
    //   33   74:iconst_1        
    //   34   75:aload_0         
    //   35   76:invokevirtual   #42  <Method Instances Instance.dataset()>
    //   36   79:aload_2         
    //   37   80:aload_1         
    //   38   81:aload_2         
    //   39   82:invokestatic    #76  <Method void copyRelationalValues(Instance, boolean, Instances, AttributeLocator, Instances, AttributeLocator)>
            return;
    //   40   85:return          
        }
    }

    public static void copyRelationalValues(Instance instance, boolean instSrcCompat, Instances srcDataset, AttributeLocator srcLoc, Instances destDataset, AttributeLocator destLoc)
    {
        if(srcDataset == destDataset)
    //*   0    0:aload_2         
    //*   1    1:aload           4
    //*   2    3:if_acmpne       7
            return;
    //    3    6:return          
        if(srcLoc.getAttributeIndices().length != destLoc.getAttributeIndices().length)
    //*   4    7:aload_3         
    //*   5    8:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //*   6   11:arraylength     
    //*   7   12:aload           5
    //*   8   14:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //*   9   17:arraylength     
    //*  10   18:icmpeq          63
            throw new IllegalArgumentException((new StringBuilder("Src and Dest relational indices differ in length: ")).append(srcLoc.getAttributeIndices().length).append(" != ").append(destLoc.getAttributeIndices().length).toString());
    //   11   21:new             #44  <Class IllegalArgumentException>
    //   12   24:dup             
    //   13   25:new             #57  <Class StringBuilder>
    //   14   28:dup             
    //   15   29:ldc1            #87  <String "Src and Dest relational indices differ in length: ">
    //   16   31:invokespecial   #60  <Method void StringBuilder(String)>
    //   17   34:aload_3         
    //   18   35:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //   19   38:arraylength     
    //   20   39:invokevirtual   #64  <Method StringBuilder StringBuilder.append(int)>
    //   21   42:ldc1            #66  <String " != ">
    //   22   44:invokevirtual   #69  <Method StringBuilder StringBuilder.append(String)>
    //   23   47:aload           5
    //   24   49:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //   25   52:arraylength     
    //   26   53:invokevirtual   #64  <Method StringBuilder StringBuilder.append(int)>
    //   27   56:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   28   59:invokespecial   #49  <Method void IllegalArgumentException(String)>
    //   29   62:athrow          
        if(srcLoc.getLocatorIndices().length != destLoc.getLocatorIndices().length)
    //*  30   63:aload_3         
    //*  31   64:invokevirtual   #90  <Method int[] AttributeLocator.getLocatorIndices()>
    //*  32   67:arraylength     
    //*  33   68:aload           5
    //*  34   70:invokevirtual   #90  <Method int[] AttributeLocator.getLocatorIndices()>
    //*  35   73:arraylength     
    //*  36   74:icmpeq          119
            throw new IllegalArgumentException((new StringBuilder("Src and Dest locator indices differ in length: ")).append(srcLoc.getLocatorIndices().length).append(" != ").append(destLoc.getLocatorIndices().length).toString());
    //   37   77:new             #44  <Class IllegalArgumentException>
    //   38   80:dup             
    //   39   81:new             #57  <Class StringBuilder>
    //   40   84:dup             
    //   41   85:ldc1            #92  <String "Src and Dest locator indices differ in length: ">
    //   42   87:invokespecial   #60  <Method void StringBuilder(String)>
    //   43   90:aload_3         
    //   44   91:invokevirtual   #90  <Method int[] AttributeLocator.getLocatorIndices()>
    //   45   94:arraylength     
    //   46   95:invokevirtual   #64  <Method StringBuilder StringBuilder.append(int)>
    //   47   98:ldc1            #66  <String " != ">
    //   48  100:invokevirtual   #69  <Method StringBuilder StringBuilder.append(String)>
    //   49  103:aload           5
    //   50  105:invokevirtual   #90  <Method int[] AttributeLocator.getLocatorIndices()>
    //   51  108:arraylength     
    //   52  109:invokevirtual   #64  <Method StringBuilder StringBuilder.append(int)>
    //   53  112:invokevirtual   #73  <Method String StringBuilder.toString()>
    //   54  115:invokespecial   #49  <Method void IllegalArgumentException(String)>
    //   55  118:athrow          
        for(int i = 0; i < srcLoc.getAttributeIndices().length; i++)
    //*  56  119:iconst_0        
    //*  57  120:istore          6
    //*  58  122:goto            235
        {
            int instIndex = instSrcCompat ? srcLoc.getActualIndex(srcLoc.getAttributeIndices()[i]) : destLoc.getActualIndex(destLoc.getAttributeIndices()[i]);
    //   59  125:iload_1         
    //   60  126:ifeq            143
    //   61  129:aload_3         
    //   62  130:aload_3         
    //   63  131:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //   64  134:iload           6
    //   65  136:iaload          
    //   66  137:invokevirtual   #96  <Method int AttributeLocator.getActualIndex(int)>
    //   67  140:goto            156
    //   68  143:aload           5
    //   69  145:aload           5
    //   70  147:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //   71  150:iload           6
    //   72  152:iaload          
    //   73  153:invokevirtual   #96  <Method int AttributeLocator.getActualIndex(int)>
    //   74  156:istore          7
            Attribute src = srcDataset.attribute(srcLoc.getActualIndex(srcLoc.getAttributeIndices()[i]));
    //   75  158:aload_2         
    //   76  159:aload_3         
    //   77  160:aload_3         
    //   78  161:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //   79  164:iload           6
    //   80  166:iaload          
    //   81  167:invokevirtual   #96  <Method int AttributeLocator.getActualIndex(int)>
    //   82  170:invokevirtual   #100 <Method Attribute Instances.attribute(int)>
    //   83  173:astore          8
            Attribute dest = destDataset.attribute(destLoc.getActualIndex(destLoc.getAttributeIndices()[i]));
    //   84  175:aload           4
    //   85  177:aload           5
    //   86  179:aload           5
    //   87  181:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //   88  184:iload           6
    //   89  186:iaload          
    //   90  187:invokevirtual   #96  <Method int AttributeLocator.getActualIndex(int)>
    //   91  190:invokevirtual   #100 <Method Attribute Instances.attribute(int)>
    //   92  193:astore          9
            if(!instance.isMissing(instIndex))
    //*  93  195:aload_0         
    //*  94  196:iload           7
    //*  95  198:invokevirtual   #104 <Method boolean Instance.isMissing(int)>
    //*  96  201:ifne            232
            {
                int valIndex = dest.addRelation(src.relation((int)instance.value(instIndex)));
    //   97  204:aload           9
    //   98  206:aload           8
    //   99  208:aload_0         
    //  100  209:iload           7
    //  101  211:invokevirtual   #108 <Method double Instance.value(int)>
    //  102  214:d2i             
    //  103  215:invokevirtual   #114 <Method Instances Attribute.relation(int)>
    //  104  218:invokevirtual   #118 <Method int Attribute.addRelation(Instances)>
    //  105  221:istore          10
                instance.setValue(instIndex, valIndex);
    //  106  223:aload_0         
    //  107  224:iload           7
    //  108  226:iload           10
    //  109  228:i2d             
    //  110  229:invokevirtual   #122 <Method void Instance.setValue(int, double)>
            }
        }

    //  111  232:iinc            6  1
    //  112  235:iload           6
    //  113  237:aload_3         
    //  114  238:invokevirtual   #85  <Method int[] AttributeLocator.getAttributeIndices()>
    //  115  241:arraylength     
    //  116  242:icmplt          125
        int srcIndices[] = srcLoc.getLocatorIndices();
    //  117  245:aload_3         
    //  118  246:invokevirtual   #90  <Method int[] AttributeLocator.getLocatorIndices()>
    //  119  249:astore          6
        int destIndices[] = destLoc.getLocatorIndices();
    //  120  251:aload           5
    //  121  253:invokevirtual   #90  <Method int[] AttributeLocator.getLocatorIndices()>
    //  122  256:astore          7
        for(int i = 0; i < srcIndices.length; i++)
    //* 123  258:iconst_0        
    //* 124  259:istore          8
    //* 125  261:goto            403
        {
            int index = instSrcCompat ? srcLoc.getActualIndex(srcIndices[i]) : destLoc.getActualIndex(destIndices[i]);
    //  126  264:iload_1         
    //  127  265:ifeq            280
    //  128  268:aload_3         
    //  129  269:aload           6
    //  130  271:iload           8
    //  131  273:iaload          
    //  132  274:invokevirtual   #96  <Method int AttributeLocator.getActualIndex(int)>
    //  133  277:goto            290
    //  134  280:aload           5
    //  135  282:aload           7
    //  136  284:iload           8
    //  137  286:iaload          
    //  138  287:invokevirtual   #96  <Method int AttributeLocator.getActualIndex(int)>
    //  139  290:istore          9
            if(!instance.isMissing(index))
    //* 140  292:aload_0         
    //* 141  293:iload           9
    //* 142  295:invokevirtual   #104 <Method boolean Instance.isMissing(int)>
    //* 143  298:ifeq            304
    //* 144  301:goto            400
            {
                Instances rel = instSrcCompat ? instance.relationalValue(index) : instance.relationalValue(index);
    //  145  304:iload_1         
    //  146  305:ifeq            317
    //  147  308:aload_0         
    //  148  309:iload           9
    //  149  311:invokevirtual   #125 <Method Instances Instance.relationalValue(int)>
    //  150  314:goto            323
    //  151  317:aload_0         
    //  152  318:iload           9
    //  153  320:invokevirtual   #125 <Method Instances Instance.relationalValue(int)>
    //  154  323:astore          10
                AttributeLocator srcRelAttsNew = srcLoc.getLocator(srcIndices[i]);
    //  155  325:aload_3         
    //  156  326:aload           6
    //  157  328:iload           8
    //  158  330:iaload          
    //  159  331:invokevirtual   #129 <Method AttributeLocator AttributeLocator.getLocator(int)>
    //  160  334:astore          11
                Instances srcDatasetNew = srcRelAttsNew.getData();
    //  161  336:aload           11
    //  162  338:invokevirtual   #132 <Method Instances AttributeLocator.getData()>
    //  163  341:astore          12
                AttributeLocator destRelAttsNew = destLoc.getLocator(destIndices[i]);
    //  164  343:aload           5
    //  165  345:aload           7
    //  166  347:iload           8
    //  167  349:iaload          
    //  168  350:invokevirtual   #129 <Method AttributeLocator AttributeLocator.getLocator(int)>
    //  169  353:astore          13
                Instances destDatasetNew = destRelAttsNew.getData();
    //  170  355:aload           13
    //  171  357:invokevirtual   #132 <Method Instances AttributeLocator.getData()>
    //  172  360:astore          14
                for(int n = 0; n < rel.numInstances(); n++)
    //* 173  362:iconst_0        
    //* 174  363:istore          15
    //* 175  365:goto            390
                    copyRelationalValues(rel.instance(n), instSrcCompat, srcDatasetNew, srcRelAttsNew, destDatasetNew, destRelAttsNew);
    //  176  368:aload           10
    //  177  370:iload           15
    //  178  372:invokevirtual   #136 <Method Instance Instances.instance(int)>
    //  179  375:iload_1         
    //  180  376:aload           12
    //  181  378:aload           11
    //  182  380:aload           14
    //  183  382:aload           13
    //  184  384:invokestatic    #76  <Method void copyRelationalValues(Instance, boolean, Instances, AttributeLocator, Instances, AttributeLocator)>

    //  185  387:iinc            15  1
    //  186  390:iload           15
    //  187  392:aload           10
    //  188  394:invokevirtual   #139 <Method int Instances.numInstances()>
    //  189  397:icmplt          368
            }
        }

    //  190  400:iinc            8  1
    //  191  403:iload           8
    //  192  405:aload           6
    //  193  407:arraylength     
    //  194  408:icmplt          264
    //  195  411:return          
    }

    private static final long serialVersionUID = 0x407d01b7443f308cL;
}

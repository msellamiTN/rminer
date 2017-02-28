// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Filter.java

package rm.filters;

import java.io.*;
import java.util.*;
import rm.core.*;

// Referenced classes of package rm.filters:
//            Sourcable

public abstract class Filter
    implements Serializable, CapabilitiesHandler, RevisionHandler
{

    public Filter()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #34  <Method void Object()>
        m_OutputFormat = null;
    //    2    4:aload_0         
    //    3    5:aconst_null     
    //    4    6:putfield        #36  <Field Instances m_OutputFormat>
        m_OutputQueue = null;
    //    5    9:aload_0         
    //    6   10:aconst_null     
    //    7   11:putfield        #38  <Field Queue m_OutputQueue>
        m_OutputStringAtts = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #40  <Field StringLocator m_OutputStringAtts>
        m_InputStringAtts = null;
    //   11   19:aload_0         
    //   12   20:aconst_null     
    //   13   21:putfield        #42  <Field StringLocator m_InputStringAtts>
        m_OutputRelAtts = null;
    //   14   24:aload_0         
    //   15   25:aconst_null     
    //   16   26:putfield        #44  <Field RelationalLocator m_OutputRelAtts>
        m_InputRelAtts = null;
    //   17   29:aload_0         
    //   18   30:aconst_null     
    //   19   31:putfield        #46  <Field RelationalLocator m_InputRelAtts>
        m_InputFormat = null;
    //   20   34:aload_0         
    //   21   35:aconst_null     
    //   22   36:putfield        #48  <Field Instances m_InputFormat>
        m_NewBatch = true;
    //   23   39:aload_0         
    //   24   40:iconst_1        
    //   25   41:putfield        #50  <Field boolean m_NewBatch>
        m_FirstBatchDone = false;
    //   26   44:aload_0         
    //   27   45:iconst_0        
    //   28   46:putfield        #52  <Field boolean m_FirstBatchDone>
    //   29   49:return          
    }

    public boolean isNewBatch()
    {
        return m_NewBatch;
    //    0    0:aload_0         
    //    1    1:getfield        #50  <Field boolean m_NewBatch>
    //    2    4:ireturn         
    }

    public boolean isFirstBatchDone()
    {
        return m_FirstBatchDone;
    //    0    0:aload_0         
    //    1    1:getfield        #52  <Field boolean m_FirstBatchDone>
    //    2    4:ireturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = new Capabilities(this);
    //    0    0:new             #63  <Class Capabilities>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #66  <Method void Capabilities(CapabilitiesHandler)>
    //    4    8:astore_1        
        result.enableAll();
    //    5    9:aload_1         
    //    6   10:invokevirtual   #69  <Method void Capabilities.enableAll()>
        result.setMinimumNumberInstances(0);
    //    7   13:aload_1         
    //    8   14:iconst_0        
    //    9   15:invokevirtual   #73  <Method void Capabilities.setMinimumNumberInstances(int)>
        return result;
    //   10   18:aload_1         
    //   11   19:areturn         
    }

    public String getRevision()
    {
        return RevisionUtils.extract("$Revision: 5549 $");
    //    0    0:ldc1            #79  <String "$Revision: 5549 $">
    //    1    2:invokestatic    #85  <Method String RevisionUtils.extract(String)>
    //    2    5:areturn         
    }

    public Capabilities getCapabilities(Instances data)
    {
        Capabilities result = getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #88  <Method Capabilities getCapabilities()>
    //    2    4:astore_2        
        if(data.classIndex() == -1)
    //*   3    5:aload_1         
    //*   4    6:invokevirtual   #94  <Method int Instances.classIndex()>
    //*   5    9:iconst_m1       
    //*   6   10:icmpne          75
        {
            Capabilities classes = result.getClassCapabilities();
    //    7   13:aload_2         
    //    8   14:invokevirtual   #97  <Method Capabilities Capabilities.getClassCapabilities()>
    //    9   17:astore_3        
            for(Iterator iter = classes.capabilities(); iter.hasNext();)
    //*  10   18:aload_3         
    //*  11   19:invokevirtual   #101 <Method Iterator Capabilities.capabilities()>
    //*  12   22:astore          4
    //*  13   24:goto            62
            {
                rm.core.Capabilities.Capability cap = (rm.core.Capabilities.Capability)(rm.core.Capabilities.Capability)iter.next();
    //   14   27:aload           4
    //   15   29:invokeinterface #107 <Method Object Iterator.next()>
    //   16   34:checkcast       #109 <Class rm.core.Capabilities$Capability>
    //   17   37:checkcast       #109 <Class rm.core.Capabilities$Capability>
    //   18   40:astore          5
                if(cap != rm.core.Capabilities.Capability.NO_CLASS)
    //*  19   42:aload           5
    //*  20   44:getstatic       #113 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //*  21   47:if_acmpeq       62
                {
                    result.disable(cap);
    //   22   50:aload_2         
    //   23   51:aload           5
    //   24   53:invokevirtual   #117 <Method void Capabilities.disable(rm.core.Capabilities$Capability)>
                    result.disableDependency(cap);
    //   25   56:aload_2         
    //   26   57:aload           5
    //   27   59:invokevirtual   #120 <Method void Capabilities.disableDependency(rm.core.Capabilities$Capability)>
                }
            }

    //   28   62:aload           4
    //   29   64:invokeinterface #123 <Method boolean Iterator.hasNext()>
    //   30   69:ifne            27
        } else
    //*  31   72:goto            89
        {
            result.disable(rm.core.Capabilities.Capability.NO_CLASS);
    //   32   75:aload_2         
    //   33   76:getstatic       #113 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   34   79:invokevirtual   #117 <Method void Capabilities.disable(rm.core.Capabilities$Capability)>
            result.disableDependency(rm.core.Capabilities.Capability.NO_CLASS);
    //   35   82:aload_2         
    //   36   83:getstatic       #113 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   37   86:invokevirtual   #120 <Method void Capabilities.disableDependency(rm.core.Capabilities$Capability)>
        }
        return result;
    //   38   89:aload_2         
    //   39   90:areturn         
    }

    protected void setOutputFormat(Instances outputFormat)
    {
        if(outputFormat != null)
    //*   0    0:aload_1         
    //*   1    1:ifnull          123
        {
            m_OutputFormat = outputFormat.stringFreeStructure();
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:invokevirtual   #134 <Method Instances Instances.stringFreeStructure()>
    //    5    9:putfield        #36  <Field Instances m_OutputFormat>
            initOutputLocators(m_OutputFormat, null);
    //    6   12:aload_0         
    //    7   13:aload_0         
    //    8   14:getfield        #36  <Field Instances m_OutputFormat>
    //    9   17:aconst_null     
    //   10   18:invokevirtual   #138 <Method void initOutputLocators(Instances, int[])>
            String relationName = (new StringBuilder(String.valueOf(outputFormat.relationName()))).append("-").append(getClass().getName()).toString();
    //   11   21:new             #140 <Class StringBuilder>
    //   12   24:dup             
    //   13   25:aload_1         
    //   14   26:invokevirtual   #143 <Method String Instances.relationName()>
    //   15   29:invokestatic    #149 <Method String String.valueOf(Object)>
    //   16   32:invokespecial   #152 <Method void StringBuilder(String)>
    //   17   35:ldc1            #154 <String "-">
    //   18   37:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   19   40:aload_0         
    //   20   41:invokevirtual   #162 <Method Class Object.getClass()>
    //   21   44:invokevirtual   #167 <Method String Class.getName()>
    //   22   47:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   23   50:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   24   53:astore_2        
            if(this instanceof OptionHandler)
    //*  25   54:aload_0         
    //*  26   55:instanceof      #172 <Class OptionHandler>
    //*  27   58:ifeq            112
            {
                String options[] = ((OptionHandler)this).getOptions();
    //   28   61:aload_0         
    //   29   62:checkcast       #172 <Class OptionHandler>
    //   30   65:invokeinterface #176 <Method String[] OptionHandler.getOptions()>
    //   31   70:astore_3        
                for(int i = 0; i < options.length; i++)
    //*  32   71:iconst_0        
    //*  33   72:istore          4
    //*  34   74:goto            105
                    relationName = (new StringBuilder(String.valueOf(relationName))).append(options[i].trim()).toString();
    //   35   77:new             #140 <Class StringBuilder>
    //   36   80:dup             
    //   37   81:aload_2         
    //   38   82:invokestatic    #149 <Method String String.valueOf(Object)>
    //   39   85:invokespecial   #152 <Method void StringBuilder(String)>
    //   40   88:aload_3         
    //   41   89:iload           4
    //   42   91:aaload          
    //   43   92:invokevirtual   #179 <Method String String.trim()>
    //   44   95:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   45   98:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   46  101:astore_2        

    //   47  102:iinc            4  1
    //   48  105:iload           4
    //   49  107:aload_3         
    //   50  108:arraylength     
    //   51  109:icmplt          77
            }
            m_OutputFormat.setRelationName(relationName);
    //   52  112:aload_0         
    //   53  113:getfield        #36  <Field Instances m_OutputFormat>
    //   54  116:aload_2         
    //   55  117:invokevirtual   #182 <Method void Instances.setRelationName(String)>
        } else
    //*  56  120:goto            128
        {
            m_OutputFormat = null;
    //   57  123:aload_0         
    //   58  124:aconst_null     
    //   59  125:putfield        #36  <Field Instances m_OutputFormat>
        }
        m_OutputQueue = new Queue();
    //   60  128:aload_0         
    //   61  129:new             #184 <Class Queue>
    //   62  132:dup             
    //   63  133:invokespecial   #185 <Method void Queue()>
    //   64  136:putfield        #38  <Field Queue m_OutputQueue>
    //   65  139:return          
    }

    protected Instances getInputFormat()
    {
        return m_InputFormat;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Instances m_InputFormat>
    //    2    4:areturn         
    }

    protected Instances inputFormatPeek()
    {
        return m_InputFormat;
    //    0    0:aload_0         
    //    1    1:getfield        #48  <Field Instances m_InputFormat>
    //    2    4:areturn         
    }

    protected Instances outputFormatPeek()
    {
        return m_OutputFormat;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field Instances m_OutputFormat>
    //    2    4:areturn         
    }

    protected void push(Instance instance)
    {
        if(instance != null)
    //*   0    0:aload_1         
    //*   1    1:ifnull          34
        {
            if(instance.dataset() != null)
    //*   2    4:aload_1         
    //*   3    5:invokevirtual   #201 <Method Instances Instance.dataset()>
    //*   4    8:ifnull          17
                copyValues(instance, false);
    //    5   11:aload_0         
    //    6   12:aload_1         
    //    7   13:iconst_0        
    //    8   14:invokevirtual   #205 <Method void copyValues(Instance, boolean)>
            instance.setDataset(m_OutputFormat);
    //    9   17:aload_1         
    //   10   18:aload_0         
    //   11   19:getfield        #36  <Field Instances m_OutputFormat>
    //   12   22:invokevirtual   #208 <Method void Instance.setDataset(Instances)>
            m_OutputQueue.push(instance);
    //   13   25:aload_0         
    //   14   26:getfield        #38  <Field Queue m_OutputQueue>
    //   15   29:aload_1         
    //   16   30:invokevirtual   #211 <Method Object Queue.push(Object)>
    //   17   33:pop             
        }
    //   18   34:return          
    }

    protected void resetQueue()
    {
        m_OutputQueue = new Queue();
    //    0    0:aload_0         
    //    1    1:new             #184 <Class Queue>
    //    2    4:dup             
    //    3    5:invokespecial   #185 <Method void Queue()>
    //    4    8:putfield        #38  <Field Queue m_OutputQueue>
    //    5   11:return          
    }

    protected void bufferInput(Instance instance)
    {
        if(instance != null)
    //*   0    0:aload_1         
    //*   1    1:ifnull          18
        {
            copyValues(instance, true);
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:iconst_1        
    //    5    7:invokevirtual   #205 <Method void copyValues(Instance, boolean)>
            m_InputFormat.add(instance);
    //    6   10:aload_0         
    //    7   11:getfield        #48  <Field Instances m_InputFormat>
    //    8   14:aload_1         
    //    9   15:invokevirtual   #218 <Method void Instances.add(Instance)>
        }
    //   10   18:return          
    }

    protected void initInputLocators(Instances data, int indices[])
    {
        if(indices == null)
    //*   0    0:aload_2         
    //*   1    1:ifnonnull       31
        {
            m_InputStringAtts = new StringLocator(data);
    //    2    4:aload_0         
    //    3    5:new             #221 <Class StringLocator>
    //    4    8:dup             
    //    5    9:aload_1         
    //    6   10:invokespecial   #223 <Method void StringLocator(Instances)>
    //    7   13:putfield        #42  <Field StringLocator m_InputStringAtts>
            m_InputRelAtts = new RelationalLocator(data);
    //    8   16:aload_0         
    //    9   17:new             #225 <Class RelationalLocator>
    //   10   20:dup             
    //   11   21:aload_1         
    //   12   22:invokespecial   #226 <Method void RelationalLocator(Instances)>
    //   13   25:putfield        #46  <Field RelationalLocator m_InputRelAtts>
        } else
    //*  14   28:goto            57
        {
            m_InputStringAtts = new StringLocator(data, indices);
    //   15   31:aload_0         
    //   16   32:new             #221 <Class StringLocator>
    //   17   35:dup             
    //   18   36:aload_1         
    //   19   37:aload_2         
    //   20   38:invokespecial   #228 <Method void StringLocator(Instances, int[])>
    //   21   41:putfield        #42  <Field StringLocator m_InputStringAtts>
            m_InputRelAtts = new RelationalLocator(data, indices);
    //   22   44:aload_0         
    //   23   45:new             #225 <Class RelationalLocator>
    //   24   48:dup             
    //   25   49:aload_1         
    //   26   50:aload_2         
    //   27   51:invokespecial   #229 <Method void RelationalLocator(Instances, int[])>
    //   28   54:putfield        #46  <Field RelationalLocator m_InputRelAtts>
        }
    //   29   57:return          
    }

    protected void initOutputLocators(Instances data, int indices[])
    {
        if(indices == null)
    //*   0    0:aload_2         
    //*   1    1:ifnonnull       31
        {
            m_OutputStringAtts = new StringLocator(data);
    //    2    4:aload_0         
    //    3    5:new             #221 <Class StringLocator>
    //    4    8:dup             
    //    5    9:aload_1         
    //    6   10:invokespecial   #223 <Method void StringLocator(Instances)>
    //    7   13:putfield        #40  <Field StringLocator m_OutputStringAtts>
            m_OutputRelAtts = new RelationalLocator(data);
    //    8   16:aload_0         
    //    9   17:new             #225 <Class RelationalLocator>
    //   10   20:dup             
    //   11   21:aload_1         
    //   12   22:invokespecial   #226 <Method void RelationalLocator(Instances)>
    //   13   25:putfield        #44  <Field RelationalLocator m_OutputRelAtts>
        } else
    //*  14   28:goto            57
        {
            m_OutputStringAtts = new StringLocator(data, indices);
    //   15   31:aload_0         
    //   16   32:new             #221 <Class StringLocator>
    //   17   35:dup             
    //   18   36:aload_1         
    //   19   37:aload_2         
    //   20   38:invokespecial   #228 <Method void StringLocator(Instances, int[])>
    //   21   41:putfield        #40  <Field StringLocator m_OutputStringAtts>
            m_OutputRelAtts = new RelationalLocator(data, indices);
    //   22   44:aload_0         
    //   23   45:new             #225 <Class RelationalLocator>
    //   24   48:dup             
    //   25   49:aload_1         
    //   26   50:aload_2         
    //   27   51:invokespecial   #229 <Method void RelationalLocator(Instances, int[])>
    //   28   54:putfield        #44  <Field RelationalLocator m_OutputRelAtts>
        }
    //   29   57:return          
    }

    protected void copyValues(Instance instance, boolean isInput)
    {
        RelationalLocator.copyRelationalValues(instance, isInput ? m_InputFormat : m_OutputFormat, isInput ? ((rm.core.AttributeLocator) (m_InputRelAtts)) : ((rm.core.AttributeLocator) (m_OutputRelAtts)));
    //    0    0:aload_1         
    //    1    1:iload_2         
    //    2    2:ifeq            12
    //    3    5:aload_0         
    //    4    6:getfield        #48  <Field Instances m_InputFormat>
    //    5    9:goto            16
    //    6   12:aload_0         
    //    7   13:getfield        #36  <Field Instances m_OutputFormat>
    //    8   16:iload_2         
    //    9   17:ifeq            27
    //   10   20:aload_0         
    //   11   21:getfield        #46  <Field RelationalLocator m_InputRelAtts>
    //   12   24:goto            31
    //   13   27:aload_0         
    //   14   28:getfield        #44  <Field RelationalLocator m_OutputRelAtts>
    //   15   31:invokestatic    #235 <Method void RelationalLocator.copyRelationalValues(Instance, Instances, rm.core.AttributeLocator)>
        StringLocator.copyStringValues(instance, isInput ? m_InputFormat : m_OutputFormat, isInput ? ((rm.core.AttributeLocator) (m_InputStringAtts)) : ((rm.core.AttributeLocator) (m_OutputStringAtts)));
    //   16   34:aload_1         
    //   17   35:iload_2         
    //   18   36:ifeq            46
    //   19   39:aload_0         
    //   20   40:getfield        #48  <Field Instances m_InputFormat>
    //   21   43:goto            50
    //   22   46:aload_0         
    //   23   47:getfield        #36  <Field Instances m_OutputFormat>
    //   24   50:iload_2         
    //   25   51:ifeq            61
    //   26   54:aload_0         
    //   27   55:getfield        #42  <Field StringLocator m_InputStringAtts>
    //   28   58:goto            65
    //   29   61:aload_0         
    //   30   62:getfield        #40  <Field StringLocator m_OutputStringAtts>
    //   31   65:invokestatic    #238 <Method void StringLocator.copyStringValues(Instance, Instances, rm.core.AttributeLocator)>
    //   32   68:return          
    }

    protected void copyValues(Instance instance, boolean instSrcCompat, Instances srcDataset, Instances destDataset)
    {
        RelationalLocator.copyRelationalValues(instance, instSrcCompat, srcDataset, m_InputRelAtts, destDataset, m_OutputRelAtts);
    //    0    0:aload_1         
    //    1    1:iload_2         
    //    2    2:aload_3         
    //    3    3:aload_0         
    //    4    4:getfield        #46  <Field RelationalLocator m_InputRelAtts>
    //    5    7:aload           4
    //    6    9:aload_0         
    //    7   10:getfield        #44  <Field RelationalLocator m_OutputRelAtts>
    //    8   13:invokestatic    #243 <Method void RelationalLocator.copyRelationalValues(Instance, boolean, Instances, rm.core.AttributeLocator, Instances, rm.core.AttributeLocator)>
        StringLocator.copyStringValues(instance, instSrcCompat, srcDataset, m_InputStringAtts, getOutputFormat(), m_OutputStringAtts);
    //    9   16:aload_1         
    //   10   17:iload_2         
    //   11   18:aload_3         
    //   12   19:aload_0         
    //   13   20:getfield        #42  <Field StringLocator m_InputStringAtts>
    //   14   23:aload_0         
    //   15   24:invokevirtual   #246 <Method Instances getOutputFormat()>
    //   16   27:aload_0         
    //   17   28:getfield        #40  <Field StringLocator m_OutputStringAtts>
    //   18   31:invokestatic    #248 <Method void StringLocator.copyStringValues(Instance, boolean, Instances, rm.core.AttributeLocator, Instances, rm.core.AttributeLocator)>
    //   19   34:return          
    }

    protected void flushInput()
    {
        if(m_InputStringAtts.getAttributeIndices().length > 0 || m_InputRelAtts.getAttributeIndices().length > 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #42  <Field StringLocator m_InputStringAtts>
    //*   2    4:invokevirtual   #256 <Method int[] StringLocator.getAttributeIndices()>
    //*   3    7:arraylength     
    //*   4    8:ifgt            22
    //*   5   11:aload_0         
    //*   6   12:getfield        #46  <Field RelationalLocator m_InputRelAtts>
    //*   7   15:invokevirtual   #257 <Method int[] RelationalLocator.getAttributeIndices()>
    //*   8   18:arraylength     
    //*   9   19:ifle            36
            m_InputFormat = m_InputFormat.stringFreeStructure();
    //   10   22:aload_0         
    //   11   23:aload_0         
    //   12   24:getfield        #48  <Field Instances m_InputFormat>
    //   13   27:invokevirtual   #134 <Method Instances Instances.stringFreeStructure()>
    //   14   30:putfield        #48  <Field Instances m_InputFormat>
        else
    //*  15   33:goto            43
            m_InputFormat.delete();
    //   16   36:aload_0         
    //   17   37:getfield        #48  <Field Instances m_InputFormat>
    //   18   40:invokevirtual   #260 <Method void Instances.delete()>
    //   19   43:return          
    }

    protected void testInputFormat(Instances instanceInfo)
        throws Exception
    {
        getCapabilities(instanceInfo).testWithFail(instanceInfo);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #266 <Method Capabilities getCapabilities(Instances)>
    //    3    5:aload_1         
    //    4    6:invokevirtual   #269 <Method void Capabilities.testWithFail(Instances)>
    //    5    9:return          
    }

    public boolean setInputFormat(Instances instanceInfo)
        throws Exception
    {
        testInputFormat(instanceInfo);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #274 <Method void testInputFormat(Instances)>
        m_InputFormat = instanceInfo.stringFreeStructure();
    //    3    5:aload_0         
    //    4    6:aload_1         
    //    5    7:invokevirtual   #134 <Method Instances Instances.stringFreeStructure()>
    //    6   10:putfield        #48  <Field Instances m_InputFormat>
        m_OutputFormat = null;
    //    7   13:aload_0         
    //    8   14:aconst_null     
    //    9   15:putfield        #36  <Field Instances m_OutputFormat>
        m_OutputQueue = new Queue();
    //   10   18:aload_0         
    //   11   19:new             #184 <Class Queue>
    //   12   22:dup             
    //   13   23:invokespecial   #185 <Method void Queue()>
    //   14   26:putfield        #38  <Field Queue m_OutputQueue>
        m_NewBatch = true;
    //   15   29:aload_0         
    //   16   30:iconst_1        
    //   17   31:putfield        #50  <Field boolean m_NewBatch>
        m_FirstBatchDone = false;
    //   18   34:aload_0         
    //   19   35:iconst_0        
    //   20   36:putfield        #52  <Field boolean m_FirstBatchDone>
        initInputLocators(m_InputFormat, null);
    //   21   39:aload_0         
    //   22   40:aload_0         
    //   23   41:getfield        #48  <Field Instances m_InputFormat>
    //   24   44:aconst_null     
    //   25   45:invokevirtual   #276 <Method void initInputLocators(Instances, int[])>
        return false;
    //   26   48:iconst_0        
    //   27   49:ireturn         
    }

    public Instances getOutputFormat()
    {
        if(m_OutputFormat == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #36  <Field Instances m_OutputFormat>
    //*   2    4:ifnonnull       18
            throw new NullPointerException("No output format defined.");
    //    3    7:new             #278 <Class NullPointerException>
    //    4   10:dup             
    //    5   11:ldc2            #280 <String "No output format defined.">
    //    6   14:invokespecial   #281 <Method void NullPointerException(String)>
    //    7   17:athrow          
        else
            return new Instances(m_OutputFormat, 0);
    //    8   18:new             #90  <Class Instances>
    //    9   21:dup             
    //   10   22:aload_0         
    //   11   23:getfield        #36  <Field Instances m_OutputFormat>
    //   12   26:iconst_0        
    //   13   27:invokespecial   #284 <Method void Instances(Instances, int)>
    //   14   30:areturn         
    }

    public boolean input(Instance instance)
        throws Exception
    {
        if(m_InputFormat == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #48  <Field Instances m_InputFormat>
    //*   2    4:ifnonnull       18
            throw new NullPointerException("No input instance format defined");
    //    3    7:new             #278 <Class NullPointerException>
    //    4   10:dup             
    //    5   11:ldc2            #288 <String "No input instance format defined">
    //    6   14:invokespecial   #281 <Method void NullPointerException(String)>
    //    7   17:athrow          
        if(m_NewBatch)
    //*   8   18:aload_0         
    //*   9   19:getfield        #50  <Field boolean m_NewBatch>
    //*  10   22:ifeq            41
        {
            m_OutputQueue = new Queue();
    //   11   25:aload_0         
    //   12   26:new             #184 <Class Queue>
    //   13   29:dup             
    //   14   30:invokespecial   #185 <Method void Queue()>
    //   15   33:putfield        #38  <Field Queue m_OutputQueue>
            m_NewBatch = false;
    //   16   36:aload_0         
    //   17   37:iconst_0        
    //   18   38:putfield        #50  <Field boolean m_NewBatch>
        }
        bufferInput(instance);
    //   19   41:aload_0         
    //   20   42:aload_1         
    //   21   43:invokevirtual   #290 <Method void bufferInput(Instance)>
        return false;
    //   22   46:iconst_0        
    //   23   47:ireturn         
    }

    public boolean batchFinished()
        throws Exception
    {
        if(m_InputFormat == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #48  <Field Instances m_InputFormat>
    //*   2    4:ifnonnull       18
            throw new NullPointerException("No input instance format defined");
    //    3    7:new             #278 <Class NullPointerException>
    //    4   10:dup             
    //    5   11:ldc2            #288 <String "No input instance format defined">
    //    6   14:invokespecial   #281 <Method void NullPointerException(String)>
    //    7   17:athrow          
        flushInput();
    //    8   18:aload_0         
    //    9   19:invokevirtual   #293 <Method void flushInput()>
        m_NewBatch = true;
    //   10   22:aload_0         
    //   11   23:iconst_1        
    //   12   24:putfield        #50  <Field boolean m_NewBatch>
        m_FirstBatchDone = true;
    //   13   27:aload_0         
    //   14   28:iconst_1        
    //   15   29:putfield        #52  <Field boolean m_FirstBatchDone>
        return numPendingOutput() != 0;
    //   16   32:aload_0         
    //   17   33:invokevirtual   #296 <Method int numPendingOutput()>
    //   18   36:ifeq            41
    //   19   39:iconst_1        
    //   20   40:ireturn         
    //   21   41:iconst_0        
    //   22   42:ireturn         
    }

    public Instance output()
    {
        if(m_OutputFormat == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #36  <Field Instances m_OutputFormat>
    //*   2    4:ifnonnull       18
            throw new NullPointerException("No output instance format defined");
    //    3    7:new             #278 <Class NullPointerException>
    //    4   10:dup             
    //    5   11:ldc2            #300 <String "No output instance format defined">
    //    6   14:invokespecial   #281 <Method void NullPointerException(String)>
    //    7   17:athrow          
        if(m_OutputQueue.empty())
    //*   8   18:aload_0         
    //*   9   19:getfield        #38  <Field Queue m_OutputQueue>
    //*  10   22:invokevirtual   #303 <Method boolean Queue.empty()>
    //*  11   25:ifeq            30
        {
            return null;
    //   12   28:aconst_null     
    //   13   29:areturn         
        } else
        {
            Instance result = (Instance)m_OutputQueue.pop();
    //   14   30:aload_0         
    //   15   31:getfield        #38  <Field Queue m_OutputQueue>
    //   16   34:invokevirtual   #306 <Method Object Queue.pop()>
    //   17   37:checkcast       #198 <Class Instance>
    //   18   40:astore_1        
            return result;
    //   19   41:aload_1         
    //   20   42:areturn         
        }
    }

    public Instance outputPeek()
    {
        if(m_OutputFormat == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #36  <Field Instances m_OutputFormat>
    //*   2    4:ifnonnull       18
            throw new NullPointerException("No output instance format defined");
    //    3    7:new             #278 <Class NullPointerException>
    //    4   10:dup             
    //    5   11:ldc2            #300 <String "No output instance format defined">
    //    6   14:invokespecial   #281 <Method void NullPointerException(String)>
    //    7   17:athrow          
        if(m_OutputQueue.empty())
    //*   8   18:aload_0         
    //*   9   19:getfield        #38  <Field Queue m_OutputQueue>
    //*  10   22:invokevirtual   #303 <Method boolean Queue.empty()>
    //*  11   25:ifeq            30
        {
            return null;
    //   12   28:aconst_null     
    //   13   29:areturn         
        } else
        {
            Instance result = (Instance)m_OutputQueue.peek();
    //   14   30:aload_0         
    //   15   31:getfield        #38  <Field Queue m_OutputQueue>
    //   16   34:invokevirtual   #310 <Method Object Queue.peek()>
    //   17   37:checkcast       #198 <Class Instance>
    //   18   40:astore_1        
            return result;
    //   19   41:aload_1         
    //   20   42:areturn         
        }
    }

    public int numPendingOutput()
    {
        if(m_OutputFormat == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #36  <Field Instances m_OutputFormat>
    //*   2    4:ifnonnull       18
            throw new NullPointerException("No output instance format defined");
    //    3    7:new             #278 <Class NullPointerException>
    //    4   10:dup             
    //    5   11:ldc2            #300 <String "No output instance format defined">
    //    6   14:invokespecial   #281 <Method void NullPointerException(String)>
    //    7   17:athrow          
        else
            return m_OutputQueue.size();
    //    8   18:aload_0         
    //    9   19:getfield        #38  <Field Queue m_OutputQueue>
    //   10   22:invokevirtual   #313 <Method int Queue.size()>
    //   11   25:ireturn         
    }

    public boolean isOutputFormatDefined()
    {
        return m_OutputFormat != null;
    //    0    0:aload_0         
    //    1    1:getfield        #36  <Field Instances m_OutputFormat>
    //    2    4:ifnull          9
    //    3    7:iconst_1        
    //    4    8:ireturn         
    //    5    9:iconst_0        
    //    6   10:ireturn         
    }

    public static Filter makeCopy(Filter model)
        throws Exception
    {
        return (Filter)(new SerializedObject(model)).getObject();
    //    0    0:new             #318 <Class SerializedObject>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #321 <Method void SerializedObject(Object)>
    //    4    8:invokevirtual   #324 <Method Object SerializedObject.getObject()>
    //    5   11:checkcast       #2   <Class Filter>
    //    6   14:areturn         
    }

    public static Filter[] makeCopies(Filter model, int num)
        throws Exception
    {
        if(model == null)
    //*   0    0:aload_0         
    //*   1    1:ifnonnull       15
            throw new Exception("No model filter set");
    //    2    4:new             #264 <Class Exception>
    //    3    7:dup             
    //    4    8:ldc2            #329 <String "No model filter set">
    //    5   11:invokespecial   #330 <Method void Exception(String)>
    //    6   14:athrow          
        Filter filters[] = new Filter[num];
    //    7   15:iload_1         
    //    8   16:anewarray       Filter[]
    //    9   19:astore_2        
        SerializedObject so = new SerializedObject(model);
    //   10   20:new             #318 <Class SerializedObject>
    //   11   23:dup             
    //   12   24:aload_0         
    //   13   25:invokespecial   #321 <Method void SerializedObject(Object)>
    //   14   28:astore_3        
        for(int i = 0; i < filters.length; i++)
    //*  15   29:iconst_0        
    //*  16   30:istore          4
    //*  17   32:goto            49
            filters[i] = (Filter)so.getObject();
    //   18   35:aload_2         
    //   19   36:iload           4
    //   20   38:aload_3         
    //   21   39:invokevirtual   #324 <Method Object SerializedObject.getObject()>
    //   22   42:checkcast       #2   <Class Filter>
    //   23   45:aastore         

    //   24   46:iinc            4  1
    //   25   49:iload           4
    //   26   51:aload_2         
    //   27   52:arraylength     
    //   28   53:icmplt          35
        return filters;
    //   29   56:aload_2         
    //   30   57:areturn         
    }

    public static Instances useFilter(Instances data, Filter filter)
        throws Exception
    {
        for(int i = 0; i < data.numInstances(); i++)
    //*   0    0:iconst_0        
    //*   1    1:istore_2        
    //*   2    2:goto            18
            filter.input(data.instance(i));
    //    3    5:aload_1         
    //    4    6:aload_0         
    //    5    7:iload_2         
    //    6    8:invokevirtual   #340 <Method Instance Instances.instance(int)>
    //    7   11:invokevirtual   #342 <Method boolean input(Instance)>
    //    8   14:pop             

    //    9   15:iinc            2  1
    //   10   18:iload_2         
    //   11   19:aload_0         
    //   12   20:invokevirtual   #345 <Method int Instances.numInstances()>
    //   13   23:icmplt          5
        filter.batchFinished();
    //   14   26:aload_1         
    //   15   27:invokevirtual   #347 <Method boolean batchFinished()>
    //   16   30:pop             
        Instances newData = filter.getOutputFormat();
    //   17   31:aload_1         
    //   18   32:invokevirtual   #246 <Method Instances getOutputFormat()>
    //   19   35:astore_2        
    //*  20   36:goto            44
        Instance processed;
        while((processed = filter.output()) != null) 
            newData.add(processed);
    //   21   39:aload_2         
    //   22   40:aload_3         
    //   23   41:invokevirtual   #218 <Method void Instances.add(Instance)>
    //   24   44:aload_1         
    //   25   45:invokevirtual   #349 <Method Instance output()>
    //   26   48:dup             
    //   27   49:astore_3        
    //   28   50:ifnonnull       39
        return newData;
    //   29   53:aload_2         
    //   30   54:areturn         
    }

    public String toString()
    {
        return getClass().getName();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #162 <Method Class Object.getClass()>
    //    2    4:invokevirtual   #167 <Method String Class.getName()>
    //    3    7:areturn         
    }

    public static String rmStaticWrapper(Sourcable filter, String className, Instances input, Instances output)
        throws Exception
    {
        StringBuffer result = new StringBuffer();
    //    0    0:new             #356 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #357 <Method void StringBuffer()>
    //    3    7:astore          4
        result.append((new StringBuilder("// Generated with Weka ")).append(Version.VERSION).append("\n").toString());
    //    4    9:aload           4
    //    5   11:new             #140 <Class StringBuilder>
    //    6   14:dup             
    //    7   15:ldc2            #359 <String "// Generated with Weka ">
    //    8   18:invokespecial   #152 <Method void StringBuilder(String)>
    //    9   21:getstatic       #364 <Field String Version.VERSION>
    //   10   24:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   11   27:ldc2            #366 <String "\n">
    //   12   30:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   13   33:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   14   36:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   15   39:pop             
        result.append("//\n");
    //   16   40:aload           4
    //   17   42:ldc2            #371 <String "//\n">
    //   18   45:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   19   48:pop             
        result.append("// This code is public domain and comes with no warranty.\n");
    //   20   49:aload           4
    //   21   51:ldc2            #373 <String "// This code is public domain and comes with no warranty.\n">
    //   22   54:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   23   57:pop             
        result.append("//\n");
    //   24   58:aload           4
    //   25   60:ldc2            #371 <String "//\n">
    //   26   63:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   27   66:pop             
        result.append((new StringBuilder("// Timestamp: ")).append(new Date()).append("\n").toString());
    //   28   67:aload           4
    //   29   69:new             #140 <Class StringBuilder>
    //   30   72:dup             
    //   31   73:ldc2            #375 <String "// Timestamp: ">
    //   32   76:invokespecial   #152 <Method void StringBuilder(String)>
    //   33   79:new             #377 <Class Date>
    //   34   82:dup             
    //   35   83:invokespecial   #378 <Method void Date()>
    //   36   86:invokevirtual   #381 <Method StringBuilder StringBuilder.append(Object)>
    //   37   89:ldc2            #366 <String "\n">
    //   38   92:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   39   95:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   40   98:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   41  101:pop             
        result.append((new StringBuilder("// Relation: ")).append(input.relationName()).append("\n").toString());
    //   42  102:aload           4
    //   43  104:new             #140 <Class StringBuilder>
    //   44  107:dup             
    //   45  108:ldc2            #383 <String "// Relation: ">
    //   46  111:invokespecial   #152 <Method void StringBuilder(String)>
    //   47  114:aload_2         
    //   48  115:invokevirtual   #143 <Method String Instances.relationName()>
    //   49  118:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   50  121:ldc2            #366 <String "\n">
    //   51  124:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //   52  127:invokevirtual   #170 <Method String StringBuilder.toString()>
    //   53  130:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   54  133:pop             
        result.append("\n");
    //   55  134:aload           4
    //   56  136:ldc2            #366 <String "\n">
    //   57  139:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   58  142:pop             
        result.append("package rm.filters;\n");
    //   59  143:aload           4
    //   60  145:ldc2            #385 <String "package rm.filters;\n">
    //   61  148:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   62  151:pop             
        result.append("\n");
    //   63  152:aload           4
    //   64  154:ldc2            #366 <String "\n">
    //   65  157:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   66  160:pop             
        result.append("import rm.core.Attribute;\n");
    //   67  161:aload           4
    //   68  163:ldc2            #387 <String "import rm.core.Attribute;\n">
    //   69  166:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   70  169:pop             
        result.append("import rm.core.Capabilities;\n");
    //   71  170:aload           4
    //   72  172:ldc2            #389 <String "import rm.core.Capabilities;\n">
    //   73  175:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   74  178:pop             
        result.append("import rm.core.Capabilities.Capability;\n");
    //   75  179:aload           4
    //   76  181:ldc2            #391 <String "import rm.core.Capabilities.Capability;\n">
    //   77  184:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   78  187:pop             
        result.append("import rm.core.FastVector;\n");
    //   79  188:aload           4
    //   80  190:ldc2            #393 <String "import rm.core.FastVector;\n">
    //   81  193:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   82  196:pop             
        result.append("import rm.core.Instance;\n");
    //   83  197:aload           4
    //   84  199:ldc2            #395 <String "import rm.core.Instance;\n">
    //   85  202:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   86  205:pop             
        result.append("import rm.core.Instances;\n");
    //   87  206:aload           4
    //   88  208:ldc2            #397 <String "import rm.core.Instances;\n">
    //   89  211:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   90  214:pop             
        result.append("import rm.filters.Filter;\n");
    //   91  215:aload           4
    //   92  217:ldc2            #399 <String "import rm.filters.Filter;\n">
    //   93  220:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   94  223:pop             
        result.append("\n");
    //   95  224:aload           4
    //   96  226:ldc2            #366 <String "\n">
    //   97  229:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //   98  232:pop             
        result.append("public class WekaWrapper\n");
    //   99  233:aload           4
    //  100  235:ldc2            #401 <String "public class WekaWrapper\n">
    //  101  238:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  102  241:pop             
        result.append("  extends Filter {\n");
    //  103  242:aload           4
    //  104  244:ldc2            #403 <String "  extends Filter {\n">
    //  105  247:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  106  250:pop             
        result.append("\n");
    //  107  251:aload           4
    //  108  253:ldc2            #366 <String "\n">
    //  109  256:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  110  259:pop             
        result.append("  /**\n");
    //  111  260:aload           4
    //  112  262:ldc2            #405 <String "  /**\n">
    //  113  265:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  114  268:pop             
        result.append("   * Returns only the toString() method.\n");
    //  115  269:aload           4
    //  116  271:ldc2            #407 <String "   * Returns only the toString() method.\n">
    //  117  274:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  118  277:pop             
        result.append("   *\n");
    //  119  278:aload           4
    //  120  280:ldc2            #409 <String "   *\n">
    //  121  283:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  122  286:pop             
        result.append("   * @return a string describing the filter\n");
    //  123  287:aload           4
    //  124  289:ldc2            #411 <String "   * @return a string describing the filter\n">
    //  125  292:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  126  295:pop             
        result.append("   */\n");
    //  127  296:aload           4
    //  128  298:ldc2            #413 <String "   */\n">
    //  129  301:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  130  304:pop             
        result.append("  public String globalInfo() {\n");
    //  131  305:aload           4
    //  132  307:ldc2            #415 <String "  public String globalInfo() {\n">
    //  133  310:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  134  313:pop             
        result.append("    return toString();\n");
    //  135  314:aload           4
    //  136  316:ldc2            #417 <String "    return toString();\n">
    //  137  319:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  138  322:pop             
        result.append("  }\n");
    //  139  323:aload           4
    //  140  325:ldc2            #419 <String "  }\n">
    //  141  328:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  142  331:pop             
        result.append("\n");
    //  143  332:aload           4
    //  144  334:ldc2            #366 <String "\n">
    //  145  337:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  146  340:pop             
        result.append("  /**\n");
    //  147  341:aload           4
    //  148  343:ldc2            #405 <String "  /**\n">
    //  149  346:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  150  349:pop             
        result.append("   * Returns the capabilities of this filter.\n");
    //  151  350:aload           4
    //  152  352:ldc2            #421 <String "   * Returns the capabilities of this filter.\n">
    //  153  355:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  154  358:pop             
        result.append("   *\n");
    //  155  359:aload           4
    //  156  361:ldc2            #409 <String "   *\n">
    //  157  364:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  158  367:pop             
        result.append("   * @return the capabilities\n");
    //  159  368:aload           4
    //  160  370:ldc2            #423 <String "   * @return the capabilities\n">
    //  161  373:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  162  376:pop             
        result.append("   */\n");
    //  163  377:aload           4
    //  164  379:ldc2            #413 <String "   */\n">
    //  165  382:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  166  385:pop             
        result.append("  public Capabilities getCapabilities() {\n");
    //  167  386:aload           4
    //  168  388:ldc2            #425 <String "  public Capabilities getCapabilities() {\n">
    //  169  391:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  170  394:pop             
        result.append(((Filter)filter).getCapabilities().toSource("result", 4));
    //  171  395:aload           4
    //  172  397:aload_0         
    //  173  398:checkcast       #2   <Class Filter>
    //  174  401:invokevirtual   #88  <Method Capabilities getCapabilities()>
    //  175  404:ldc2            #426 <String "result">
    //  176  407:iconst_4        
    //  177  408:invokevirtual   #430 <Method String Capabilities.toSource(String, int)>
    //  178  411:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  179  414:pop             
        result.append("    return result;\n");
    //  180  415:aload           4
    //  181  417:ldc2            #432 <String "    return result;\n">
    //  182  420:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  183  423:pop             
        result.append("  }\n");
    //  184  424:aload           4
    //  185  426:ldc2            #419 <String "  }\n">
    //  186  429:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  187  432:pop             
        result.append("\n");
    //  188  433:aload           4
    //  189  435:ldc2            #366 <String "\n">
    //  190  438:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  191  441:pop             
        result.append("  /**\n");
    //  192  442:aload           4
    //  193  444:ldc2            #405 <String "  /**\n">
    //  194  447:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  195  450:pop             
        result.append("   * turns array of Objects into an Instance object\n");
    //  196  451:aload           4
    //  197  453:ldc2            #434 <String "   * turns array of Objects into an Instance object\n">
    //  198  456:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  199  459:pop             
        result.append("   *\n");
    //  200  460:aload           4
    //  201  462:ldc2            #409 <String "   *\n">
    //  202  465:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  203  468:pop             
        result.append("   * @param obj\tthe Object array to turn into an Instance\n");
    //  204  469:aload           4
    //  205  471:ldc2            #436 <String "   * @param obj\tthe Object array to turn into an Instance\n">
    //  206  474:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  207  477:pop             
        result.append("   * @param format\tthe data format to use\n");
    //  208  478:aload           4
    //  209  480:ldc2            #438 <String "   * @param format\tthe data format to use\n">
    //  210  483:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  211  486:pop             
        result.append("   * @return\t\tthe generated Instance object\n");
    //  212  487:aload           4
    //  213  489:ldc2            #440 <String "   * @return\t\tthe generated Instance object\n">
    //  214  492:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  215  495:pop             
        result.append("   */\n");
    //  216  496:aload           4
    //  217  498:ldc2            #413 <String "   */\n">
    //  218  501:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  219  504:pop             
        result.append("  protected Instance objectsToInstance(Object[] obj, Instances format) {\n");
    //  220  505:aload           4
    //  221  507:ldc2            #442 <String "  protected Instance objectsToInstance(Object[] obj, Instances format) {\n">
    //  222  510:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  223  513:pop             
        result.append("    Instance\t\tresult;\n");
    //  224  514:aload           4
    //  225  516:ldc2            #444 <String "    Instance\t\tresult;\n">
    //  226  519:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  227  522:pop             
        result.append("    double[]\t\tvalues;\n");
    //  228  523:aload           4
    //  229  525:ldc2            #446 <String "    double[]\t\tvalues;\n">
    //  230  528:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  231  531:pop             
        result.append("    int\t\ti;\n");
    //  232  532:aload           4
    //  233  534:ldc2            #448 <String "    int\t\ti;\n">
    //  234  537:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  235  540:pop             
        result.append("\n");
    //  236  541:aload           4
    //  237  543:ldc2            #366 <String "\n">
    //  238  546:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  239  549:pop             
        result.append("    values = new double[obj.length];\n");
    //  240  550:aload           4
    //  241  552:ldc2            #450 <String "    values = new double[obj.length];\n">
    //  242  555:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  243  558:pop             
        result.append("\n");
    //  244  559:aload           4
    //  245  561:ldc2            #366 <String "\n">
    //  246  564:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  247  567:pop             
        result.append("    for (i = 0 ; i < obj.length; i++) {\n");
    //  248  568:aload           4
    //  249  570:ldc2            #452 <String "    for (i = 0 ; i < obj.length; i++) {\n">
    //  250  573:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  251  576:pop             
        result.append("      if (obj[i] == null)\n");
    //  252  577:aload           4
    //  253  579:ldc2            #454 <String "      if (obj[i] == null)\n">
    //  254  582:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  255  585:pop             
        result.append("        values[i] = Instance.missingValue();\n");
    //  256  586:aload           4
    //  257  588:ldc2            #456 <String "        values[i] = Instance.missingValue();\n">
    //  258  591:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  259  594:pop             
        result.append("      else if (format.attribute(i).isNumeric())\n");
    //  260  595:aload           4
    //  261  597:ldc2            #458 <String "      else if (format.attribute(i).isNumeric())\n">
    //  262  600:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  263  603:pop             
        result.append("        values[i] = (Double) obj[i];\n");
    //  264  604:aload           4
    //  265  606:ldc2            #460 <String "        values[i] = (Double) obj[i];\n">
    //  266  609:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  267  612:pop             
        result.append("      else if (format.attribute(i).isNominal())\n");
    //  268  613:aload           4
    //  269  615:ldc2            #462 <String "      else if (format.attribute(i).isNominal())\n">
    //  270  618:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  271  621:pop             
        result.append("        values[i] = format.attribute(i).indexOfValue((String) obj[i]);\n");
    //  272  622:aload           4
    //  273  624:ldc2            #464 <String "        values[i] = format.attribute(i).indexOfValue((String) obj[i]);\n">
    //  274  627:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  275  630:pop             
        result.append("    }\n");
    //  276  631:aload           4
    //  277  633:ldc2            #466 <String "    }\n">
    //  278  636:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  279  639:pop             
        result.append("\n");
    //  280  640:aload           4
    //  281  642:ldc2            #366 <String "\n">
    //  282  645:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  283  648:pop             
        result.append("    // create new instance\n");
    //  284  649:aload           4
    //  285  651:ldc2            #468 <String "    // create new instance\n">
    //  286  654:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  287  657:pop             
        result.append("    result = new Instance(1.0, values);\n");
    //  288  658:aload           4
    //  289  660:ldc2            #470 <String "    result = new Instance(1.0, values);\n">
    //  290  663:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  291  666:pop             
        result.append("    result.setDataset(format);\n");
    //  292  667:aload           4
    //  293  669:ldc2            #472 <String "    result.setDataset(format);\n">
    //  294  672:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  295  675:pop             
        result.append("\n");
    //  296  676:aload           4
    //  297  678:ldc2            #366 <String "\n">
    //  298  681:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  299  684:pop             
        result.append("    return result;\n");
    //  300  685:aload           4
    //  301  687:ldc2            #432 <String "    return result;\n">
    //  302  690:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  303  693:pop             
        result.append("  }\n");
    //  304  694:aload           4
    //  305  696:ldc2            #419 <String "  }\n">
    //  306  699:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  307  702:pop             
        result.append("\n");
    //  308  703:aload           4
    //  309  705:ldc2            #366 <String "\n">
    //  310  708:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  311  711:pop             
        result.append("  /**\n");
    //  312  712:aload           4
    //  313  714:ldc2            #405 <String "  /**\n">
    //  314  717:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  315  720:pop             
        result.append("   * turns the Instance object into an array of Objects\n");
    //  316  721:aload           4
    //  317  723:ldc2            #474 <String "   * turns the Instance object into an array of Objects\n">
    //  318  726:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  319  729:pop             
        result.append("   *\n");
    //  320  730:aload           4
    //  321  732:ldc2            #409 <String "   *\n">
    //  322  735:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  323  738:pop             
        result.append("   * @param inst\tthe instance to turn into an array\n");
    //  324  739:aload           4
    //  325  741:ldc2            #476 <String "   * @param inst\tthe instance to turn into an array\n">
    //  326  744:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  327  747:pop             
        result.append("   * @return\t\tthe Object array representing the instance\n");
    //  328  748:aload           4
    //  329  750:ldc2            #478 <String "   * @return\t\tthe Object array representing the instance\n">
    //  330  753:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  331  756:pop             
        result.append("   */\n");
    //  332  757:aload           4
    //  333  759:ldc2            #413 <String "   */\n">
    //  334  762:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  335  765:pop             
        result.append("  protected Object[] instanceToObjects(Instance inst) {\n");
    //  336  766:aload           4
    //  337  768:ldc2            #480 <String "  protected Object[] instanceToObjects(Instance inst) {\n">
    //  338  771:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  339  774:pop             
        result.append("    Object[]\tresult;\n");
    //  340  775:aload           4
    //  341  777:ldc2            #482 <String "    Object[]\tresult;\n">
    //  342  780:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  343  783:pop             
        result.append("    int\t\ti;\n");
    //  344  784:aload           4
    //  345  786:ldc2            #448 <String "    int\t\ti;\n">
    //  346  789:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  347  792:pop             
        result.append("\n");
    //  348  793:aload           4
    //  349  795:ldc2            #366 <String "\n">
    //  350  798:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  351  801:pop             
        result.append("    result = new Object[inst.numAttributes()];\n");
    //  352  802:aload           4
    //  353  804:ldc2            #484 <String "    result = new Object[inst.numAttributes()];\n">
    //  354  807:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  355  810:pop             
        result.append("\n");
    //  356  811:aload           4
    //  357  813:ldc2            #366 <String "\n">
    //  358  816:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  359  819:pop             
        result.append("    for (i = 0 ; i < inst.numAttributes(); i++) {\n");
    //  360  820:aload           4
    //  361  822:ldc2            #486 <String "    for (i = 0 ; i < inst.numAttributes(); i++) {\n">
    //  362  825:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  363  828:pop             
        result.append("      if (inst.isMissing(i))\n");
    //  364  829:aload           4
    //  365  831:ldc2            #488 <String "      if (inst.isMissing(i))\n">
    //  366  834:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  367  837:pop             
        result.append("  \tresult[i] = null;\n");
    //  368  838:aload           4
    //  369  840:ldc2            #490 <String "  \tresult[i] = null;\n">
    //  370  843:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  371  846:pop             
        result.append("      else if (inst.attribute(i).isNumeric())\n");
    //  372  847:aload           4
    //  373  849:ldc2            #492 <String "      else if (inst.attribute(i).isNumeric())\n">
    //  374  852:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  375  855:pop             
        result.append("  \tresult[i] = inst.value(i);\n");
    //  376  856:aload           4
    //  377  858:ldc2            #494 <String "  \tresult[i] = inst.value(i);\n">
    //  378  861:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  379  864:pop             
        result.append("      else\n");
    //  380  865:aload           4
    //  381  867:ldc2            #496 <String "      else\n">
    //  382  870:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  383  873:pop             
        result.append("  \tresult[i] = inst.stringValue(i);\n");
    //  384  874:aload           4
    //  385  876:ldc2            #498 <String "  \tresult[i] = inst.stringValue(i);\n">
    //  386  879:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  387  882:pop             
        result.append("    }\n");
    //  388  883:aload           4
    //  389  885:ldc2            #466 <String "    }\n">
    //  390  888:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  391  891:pop             
        result.append("\n");
    //  392  892:aload           4
    //  393  894:ldc2            #366 <String "\n">
    //  394  897:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  395  900:pop             
        result.append("    return result;\n");
    //  396  901:aload           4
    //  397  903:ldc2            #432 <String "    return result;\n">
    //  398  906:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  399  909:pop             
        result.append("  }\n");
    //  400  910:aload           4
    //  401  912:ldc2            #419 <String "  }\n">
    //  402  915:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  403  918:pop             
        result.append("\n");
    //  404  919:aload           4
    //  405  921:ldc2            #366 <String "\n">
    //  406  924:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  407  927:pop             
        result.append("  /**\n");
    //  408  928:aload           4
    //  409  930:ldc2            #405 <String "  /**\n">
    //  410  933:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  411  936:pop             
        result.append("   * turns the Instances object into an array of Objects\n");
    //  412  937:aload           4
    //  413  939:ldc2            #500 <String "   * turns the Instances object into an array of Objects\n">
    //  414  942:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  415  945:pop             
        result.append("   *\n");
    //  416  946:aload           4
    //  417  948:ldc2            #409 <String "   *\n">
    //  418  951:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  419  954:pop             
        result.append("   * @param data\tthe instances to turn into an array\n");
    //  420  955:aload           4
    //  421  957:ldc2            #502 <String "   * @param data\tthe instances to turn into an array\n">
    //  422  960:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  423  963:pop             
        result.append("   * @return\t\tthe Object array representing the instances\n");
    //  424  964:aload           4
    //  425  966:ldc2            #504 <String "   * @return\t\tthe Object array representing the instances\n">
    //  426  969:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  427  972:pop             
        result.append("   */\n");
    //  428  973:aload           4
    //  429  975:ldc2            #413 <String "   */\n">
    //  430  978:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  431  981:pop             
        result.append("  protected Object[][] instancesToObjects(Instances data) {\n");
    //  432  982:aload           4
    //  433  984:ldc2            #506 <String "  protected Object[][] instancesToObjects(Instances data) {\n">
    //  434  987:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  435  990:pop             
        result.append("    Object[][]\tresult;\n");
    //  436  991:aload           4
    //  437  993:ldc2            #508 <String "    Object[][]\tresult;\n">
    //  438  996:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  439  999:pop             
        result.append("    int\t\ti;\n");
    //  440 1000:aload           4
    //  441 1002:ldc2            #448 <String "    int\t\ti;\n">
    //  442 1005:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  443 1008:pop             
        result.append("\n");
    //  444 1009:aload           4
    //  445 1011:ldc2            #366 <String "\n">
    //  446 1014:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  447 1017:pop             
        result.append("    result = new Object[data.numInstances()][];\n");
    //  448 1018:aload           4
    //  449 1020:ldc2            #510 <String "    result = new Object[data.numInstances()][];\n">
    //  450 1023:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  451 1026:pop             
        result.append("\n");
    //  452 1027:aload           4
    //  453 1029:ldc2            #366 <String "\n">
    //  454 1032:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  455 1035:pop             
        result.append("    for (i = 0; i < data.numInstances(); i++)\n");
    //  456 1036:aload           4
    //  457 1038:ldc2            #512 <String "    for (i = 0; i < data.numInstances(); i++)\n">
    //  458 1041:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  459 1044:pop             
        result.append("      result[i] = instanceToObjects(data.instance(i));\n");
    //  460 1045:aload           4
    //  461 1047:ldc2            #514 <String "      result[i] = instanceToObjects(data.instance(i));\n">
    //  462 1050:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  463 1053:pop             
        result.append("\n");
    //  464 1054:aload           4
    //  465 1056:ldc2            #366 <String "\n">
    //  466 1059:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  467 1062:pop             
        result.append("    return result;\n");
    //  468 1063:aload           4
    //  469 1065:ldc2            #432 <String "    return result;\n">
    //  470 1068:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  471 1071:pop             
        result.append("  }\n");
    //  472 1072:aload           4
    //  473 1074:ldc2            #419 <String "  }\n">
    //  474 1077:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  475 1080:pop             
        result.append("\n");
    //  476 1081:aload           4
    //  477 1083:ldc2            #366 <String "\n">
    //  478 1086:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  479 1089:pop             
        result.append("  /**\n");
    //  480 1090:aload           4
    //  481 1092:ldc2            #405 <String "  /**\n">
    //  482 1095:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  483 1098:pop             
        result.append("   * Only tests the input data.\n");
    //  484 1099:aload           4
    //  485 1101:ldc2            #516 <String "   * Only tests the input data.\n">
    //  486 1104:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  487 1107:pop             
        result.append("   *\n");
    //  488 1108:aload           4
    //  489 1110:ldc2            #409 <String "   *\n">
    //  490 1113:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  491 1116:pop             
        result.append("   * @param instanceInfo the format of the data to convert\n");
    //  492 1117:aload           4
    //  493 1119:ldc2            #518 <String "   * @param instanceInfo the format of the data to convert\n">
    //  494 1122:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  495 1125:pop             
        result.append("   * @return always true, to indicate that the output format can \n");
    //  496 1126:aload           4
    //  497 1128:ldc2            #520 <String "   * @return always true, to indicate that the output format can \n">
    //  498 1131:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  499 1134:pop             
        result.append("   *         be collected immediately.\n");
    //  500 1135:aload           4
    //  501 1137:ldc2            #522 <String "   *         be collected immediately.\n">
    //  502 1140:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  503 1143:pop             
        result.append("   */\n");
    //  504 1144:aload           4
    //  505 1146:ldc2            #413 <String "   */\n">
    //  506 1149:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  507 1152:pop             
        result.append("  public boolean setInputFormat(Instances instanceInfo) throws Exception {\n");
    //  508 1153:aload           4
    //  509 1155:ldc2            #524 <String "  public boolean setInputFormat(Instances instanceInfo) throws Exception {\n">
    //  510 1158:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  511 1161:pop             
        result.append("    super.setInputFormat(instanceInfo);\n");
    //  512 1162:aload           4
    //  513 1164:ldc2            #526 <String "    super.setInputFormat(instanceInfo);\n">
    //  514 1167:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  515 1170:pop             
        result.append("    \n");
    //  516 1171:aload           4
    //  517 1173:ldc2            #528 <String "    \n">
    //  518 1176:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  519 1179:pop             
        result.append("    // generate output format\n");
    //  520 1180:aload           4
    //  521 1182:ldc2            #530 <String "    // generate output format\n">
    //  522 1185:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  523 1188:pop             
        result.append("    FastVector atts = new FastVector();\n");
    //  524 1189:aload           4
    //  525 1191:ldc2            #532 <String "    FastVector atts = new FastVector();\n">
    //  526 1194:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  527 1197:pop             
        result.append("    FastVector attValues;\n");
    //  528 1198:aload           4
    //  529 1200:ldc2            #534 <String "    FastVector attValues;\n">
    //  530 1203:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  531 1206:pop             
        for(int i = 0; i < output.numAttributes(); i++)
    //* 532 1207:iconst_0        
    //* 533 1208:istore          5
    //* 534 1210:goto            1480
        {
            result.append((new StringBuilder("    // ")).append(output.attribute(i).name()).append("\n").toString());
    //  535 1213:aload           4
    //  536 1215:new             #140 <Class StringBuilder>
    //  537 1218:dup             
    //  538 1219:ldc2            #536 <String "    // ">
    //  539 1222:invokespecial   #152 <Method void StringBuilder(String)>
    //  540 1225:aload_3         
    //  541 1226:iload           5
    //  542 1228:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //  543 1231:invokevirtual   #545 <Method String Attribute.name()>
    //  544 1234:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  545 1237:ldc2            #366 <String "\n">
    //  546 1240:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  547 1243:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  548 1246:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  549 1249:pop             
            if(output.attribute(i).isNumeric())
    //* 550 1250:aload_3         
    //* 551 1251:iload           5
    //* 552 1253:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //* 553 1256:invokevirtual   #548 <Method boolean Attribute.isNumeric()>
    //* 554 1259:ifeq            1302
                result.append((new StringBuilder("    atts.addElement(new Attribute(\"")).append(output.attribute(i).name()).append("\"));\n").toString());
    //  555 1262:aload           4
    //  556 1264:new             #140 <Class StringBuilder>
    //  557 1267:dup             
    //  558 1268:ldc2            #550 <String "    atts.addElement(new Attribute(\"">
    //  559 1271:invokespecial   #152 <Method void StringBuilder(String)>
    //  560 1274:aload_3         
    //  561 1275:iload           5
    //  562 1277:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //  563 1280:invokevirtual   #545 <Method String Attribute.name()>
    //  564 1283:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  565 1286:ldc2            #552 <String "\"));\n">
    //  566 1289:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  567 1292:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  568 1295:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  569 1298:pop             
            else
    //* 570 1299:goto            1477
            if(output.attribute(i).isNominal())
    //* 571 1302:aload_3         
    //* 572 1303:iload           5
    //* 573 1305:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //* 574 1308:invokevirtual   #555 <Method boolean Attribute.isNominal()>
    //* 575 1311:ifeq            1425
            {
                result.append("    attValues = new FastVector();\n");
    //  576 1314:aload           4
    //  577 1316:ldc2            #557 <String "    attValues = new FastVector();\n">
    //  578 1319:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  579 1322:pop             
                for(int n = 0; n < output.attribute(i).numValues(); n++)
    //* 580 1323:iconst_0        
    //* 581 1324:istore          6
    //* 582 1326:goto            1371
                    result.append((new StringBuilder("    attValues.addElement(\"")).append(output.attribute(i).value(n)).append("\");\n").toString());
    //  583 1329:aload           4
    //  584 1331:new             #140 <Class StringBuilder>
    //  585 1334:dup             
    //  586 1335:ldc2            #559 <String "    attValues.addElement(\"">
    //  587 1338:invokespecial   #152 <Method void StringBuilder(String)>
    //  588 1341:aload_3         
    //  589 1342:iload           5
    //  590 1344:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //  591 1347:iload           6
    //  592 1349:invokevirtual   #563 <Method String Attribute.value(int)>
    //  593 1352:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  594 1355:ldc2            #565 <String "\");\n">
    //  595 1358:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  596 1361:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  597 1364:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  598 1367:pop             

    //  599 1368:iinc            6  1
    //  600 1371:iload           6
    //  601 1373:aload_3         
    //  602 1374:iload           5
    //  603 1376:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //  604 1379:invokevirtual   #568 <Method int Attribute.numValues()>
    //  605 1382:icmplt          1329
                result.append((new StringBuilder("    atts.addElement(new Attribute(\"")).append(output.attribute(i).name()).append("\", attValues));\n").toString());
    //  606 1385:aload           4
    //  607 1387:new             #140 <Class StringBuilder>
    //  608 1390:dup             
    //  609 1391:ldc2            #550 <String "    atts.addElement(new Attribute(\"">
    //  610 1394:invokespecial   #152 <Method void StringBuilder(String)>
    //  611 1397:aload_3         
    //  612 1398:iload           5
    //  613 1400:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //  614 1403:invokevirtual   #545 <Method String Attribute.name()>
    //  615 1406:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  616 1409:ldc2            #570 <String "\", attValues));\n">
    //  617 1412:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  618 1415:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  619 1418:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  620 1421:pop             
            } else
    //* 621 1422:goto            1477
            {
                throw new UnsupportedAttributeTypeException((new StringBuilder("Attribute type '")).append(output.attribute(i).type()).append("' (position ").append(i + 1).append(") is not supported!").toString());
    //  622 1425:new             #572 <Class UnsupportedAttributeTypeException>
    //  623 1428:dup             
    //  624 1429:new             #140 <Class StringBuilder>
    //  625 1432:dup             
    //  626 1433:ldc2            #574 <String "Attribute type '">
    //  627 1436:invokespecial   #152 <Method void StringBuilder(String)>
    //  628 1439:aload_3         
    //  629 1440:iload           5
    //  630 1442:invokevirtual   #540 <Method Attribute Instances.attribute(int)>
    //  631 1445:invokevirtual   #577 <Method int Attribute.type()>
    //  632 1448:invokevirtual   #580 <Method StringBuilder StringBuilder.append(int)>
    //  633 1451:ldc2            #582 <String "' (position ">
    //  634 1454:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  635 1457:iload           5
    //  636 1459:iconst_1        
    //  637 1460:iadd            
    //  638 1461:invokevirtual   #580 <Method StringBuilder StringBuilder.append(int)>
    //  639 1464:ldc2            #584 <String ") is not supported!">
    //  640 1467:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  641 1470:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  642 1473:invokespecial   #585 <Method void UnsupportedAttributeTypeException(String)>
    //  643 1476:athrow          
            }
        }

    //  644 1477:iinc            5  1
    //  645 1480:iload           5
    //  646 1482:aload_3         
    //  647 1483:invokevirtual   #588 <Method int Instances.numAttributes()>
    //  648 1486:icmplt          1213
        result.append("    \n");
    //  649 1489:aload           4
    //  650 1491:ldc2            #528 <String "    \n">
    //  651 1494:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  652 1497:pop             
        result.append((new StringBuilder("    Instances format = new Instances(\"")).append(output.relationName()).append("\", atts, 0);\n").toString());
    //  653 1498:aload           4
    //  654 1500:new             #140 <Class StringBuilder>
    //  655 1503:dup             
    //  656 1504:ldc2            #590 <String "    Instances format = new Instances(\"">
    //  657 1507:invokespecial   #152 <Method void StringBuilder(String)>
    //  658 1510:aload_3         
    //  659 1511:invokevirtual   #143 <Method String Instances.relationName()>
    //  660 1514:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  661 1517:ldc2            #592 <String "\", atts, 0);\n">
    //  662 1520:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  663 1523:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  664 1526:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  665 1529:pop             
        result.append((new StringBuilder("    format.setClassIndex(")).append(output.classIndex()).append(");\n").toString());
    //  666 1530:aload           4
    //  667 1532:new             #140 <Class StringBuilder>
    //  668 1535:dup             
    //  669 1536:ldc2            #594 <String "    format.setClassIndex(">
    //  670 1539:invokespecial   #152 <Method void StringBuilder(String)>
    //  671 1542:aload_3         
    //  672 1543:invokevirtual   #94  <Method int Instances.classIndex()>
    //  673 1546:invokevirtual   #580 <Method StringBuilder StringBuilder.append(int)>
    //  674 1549:ldc2            #596 <String ");\n">
    //  675 1552:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  676 1555:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  677 1558:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  678 1561:pop             
        result.append("    setOutputFormat(format);\n");
    //  679 1562:aload           4
    //  680 1564:ldc2            #598 <String "    setOutputFormat(format);\n">
    //  681 1567:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  682 1570:pop             
        result.append("    \n");
    //  683 1571:aload           4
    //  684 1573:ldc2            #528 <String "    \n">
    //  685 1576:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  686 1579:pop             
        result.append("    return true;\n");
    //  687 1580:aload           4
    //  688 1582:ldc2            #600 <String "    return true;\n">
    //  689 1585:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  690 1588:pop             
        result.append("  }\n");
    //  691 1589:aload           4
    //  692 1591:ldc2            #419 <String "  }\n">
    //  693 1594:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  694 1597:pop             
        result.append("\n");
    //  695 1598:aload           4
    //  696 1600:ldc2            #366 <String "\n">
    //  697 1603:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  698 1606:pop             
        result.append("  /**\n");
    //  699 1607:aload           4
    //  700 1609:ldc2            #405 <String "  /**\n">
    //  701 1612:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  702 1615:pop             
        result.append("   * Directly filters the instance.\n");
    //  703 1616:aload           4
    //  704 1618:ldc2            #602 <String "   * Directly filters the instance.\n">
    //  705 1621:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  706 1624:pop             
        result.append("   *\n");
    //  707 1625:aload           4
    //  708 1627:ldc2            #409 <String "   *\n">
    //  709 1630:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  710 1633:pop             
        result.append("   * @param instance the instance to convert\n");
    //  711 1634:aload           4
    //  712 1636:ldc2            #604 <String "   * @param instance the instance to convert\n">
    //  713 1639:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  714 1642:pop             
        result.append("   * @return always true, to indicate that the output can \n");
    //  715 1643:aload           4
    //  716 1645:ldc2            #606 <String "   * @return always true, to indicate that the output can \n">
    //  717 1648:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  718 1651:pop             
        result.append("   *         be collected immediately.\n");
    //  719 1652:aload           4
    //  720 1654:ldc2            #522 <String "   *         be collected immediately.\n">
    //  721 1657:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  722 1660:pop             
        result.append("   */\n");
    //  723 1661:aload           4
    //  724 1663:ldc2            #413 <String "   */\n">
    //  725 1666:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  726 1669:pop             
        result.append("  public boolean input(Instance instance) throws Exception {\n");
    //  727 1670:aload           4
    //  728 1672:ldc2            #608 <String "  public boolean input(Instance instance) throws Exception {\n">
    //  729 1675:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  730 1678:pop             
        result.append((new StringBuilder("    Object[] filtered = ")).append(className).append(".filter(instanceToObjects(instance));\n").toString());
    //  731 1679:aload           4
    //  732 1681:new             #140 <Class StringBuilder>
    //  733 1684:dup             
    //  734 1685:ldc2            #610 <String "    Object[] filtered = ">
    //  735 1688:invokespecial   #152 <Method void StringBuilder(String)>
    //  736 1691:aload_1         
    //  737 1692:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  738 1695:ldc2            #612 <String ".filter(instanceToObjects(instance));\n">
    //  739 1698:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  740 1701:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  741 1704:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  742 1707:pop             
        result.append("    push(objectsToInstance(filtered, getOutputFormat()));\n");
    //  743 1708:aload           4
    //  744 1710:ldc2            #614 <String "    push(objectsToInstance(filtered, getOutputFormat()));\n">
    //  745 1713:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  746 1716:pop             
        result.append("    return true;\n");
    //  747 1717:aload           4
    //  748 1719:ldc2            #600 <String "    return true;\n">
    //  749 1722:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  750 1725:pop             
        result.append("  }\n");
    //  751 1726:aload           4
    //  752 1728:ldc2            #419 <String "  }\n">
    //  753 1731:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  754 1734:pop             
        result.append("\n");
    //  755 1735:aload           4
    //  756 1737:ldc2            #366 <String "\n">
    //  757 1740:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  758 1743:pop             
        result.append("  /**\n");
    //  759 1744:aload           4
    //  760 1746:ldc2            #405 <String "  /**\n">
    //  761 1749:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  762 1752:pop             
        result.append("   * Performs a batch filtering of the buffered data, if any available.\n");
    //  763 1753:aload           4
    //  764 1755:ldc2            #616 <String "   * Performs a batch filtering of the buffered data, if any available.\n">
    //  765 1758:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  766 1761:pop             
        result.append("   *\n");
    //  767 1762:aload           4
    //  768 1764:ldc2            #409 <String "   *\n">
    //  769 1767:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  770 1770:pop             
        result.append("   * @return true if instances were filtered otherwise false\n");
    //  771 1771:aload           4
    //  772 1773:ldc2            #618 <String "   * @return true if instances were filtered otherwise false\n">
    //  773 1776:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  774 1779:pop             
        result.append("   */\n");
    //  775 1780:aload           4
    //  776 1782:ldc2            #413 <String "   */\n">
    //  777 1785:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  778 1788:pop             
        result.append("  public boolean batchFinished() throws Exception {\n");
    //  779 1789:aload           4
    //  780 1791:ldc2            #620 <String "  public boolean batchFinished() throws Exception {\n">
    //  781 1794:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  782 1797:pop             
        result.append("    if (getInputFormat() == null)\n");
    //  783 1798:aload           4
    //  784 1800:ldc2            #622 <String "    if (getInputFormat() == null)\n">
    //  785 1803:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  786 1806:pop             
        result.append("      throw new NullPointerException(\"No input instance format defined\");;\n");
    //  787 1807:aload           4
    //  788 1809:ldc2            #624 <String "      throw new NullPointerException(\"No input instance format defined\");;\n">
    //  789 1812:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  790 1815:pop             
        result.append("\n");
    //  791 1816:aload           4
    //  792 1818:ldc2            #366 <String "\n">
    //  793 1821:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  794 1824:pop             
        result.append("    Instances inst = getInputFormat();\n");
    //  795 1825:aload           4
    //  796 1827:ldc2            #626 <String "    Instances inst = getInputFormat();\n">
    //  797 1830:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  798 1833:pop             
        result.append("    if (inst.numInstances() > 0) {\n");
    //  799 1834:aload           4
    //  800 1836:ldc2            #628 <String "    if (inst.numInstances() > 0) {\n">
    //  801 1839:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  802 1842:pop             
        result.append((new StringBuilder("      Object[][] filtered = ")).append(className).append(".filter(instancesToObjects(inst));\n").toString());
    //  803 1843:aload           4
    //  804 1845:new             #140 <Class StringBuilder>
    //  805 1848:dup             
    //  806 1849:ldc2            #630 <String "      Object[][] filtered = ">
    //  807 1852:invokespecial   #152 <Method void StringBuilder(String)>
    //  808 1855:aload_1         
    //  809 1856:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  810 1859:ldc2            #632 <String ".filter(instancesToObjects(inst));\n">
    //  811 1862:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  812 1865:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  813 1868:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  814 1871:pop             
        result.append("      for (int i = 0; i < filtered.length; i++) {\n");
    //  815 1872:aload           4
    //  816 1874:ldc2            #634 <String "      for (int i = 0; i < filtered.length; i++) {\n">
    //  817 1877:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  818 1880:pop             
        result.append("        push(objectsToInstance(filtered[i], getOutputFormat()));\n");
    //  819 1881:aload           4
    //  820 1883:ldc2            #636 <String "        push(objectsToInstance(filtered[i], getOutputFormat()));\n">
    //  821 1886:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  822 1889:pop             
        result.append("      }\n");
    //  823 1890:aload           4
    //  824 1892:ldc2            #638 <String "      }\n">
    //  825 1895:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  826 1898:pop             
        result.append("    }\n");
    //  827 1899:aload           4
    //  828 1901:ldc2            #466 <String "    }\n">
    //  829 1904:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  830 1907:pop             
        result.append("\n");
    //  831 1908:aload           4
    //  832 1910:ldc2            #366 <String "\n">
    //  833 1913:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  834 1916:pop             
        result.append("    flushInput();\n");
    //  835 1917:aload           4
    //  836 1919:ldc2            #640 <String "    flushInput();\n">
    //  837 1922:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  838 1925:pop             
        result.append("    m_NewBatch = true;\n");
    //  839 1926:aload           4
    //  840 1928:ldc2            #642 <String "    m_NewBatch = true;\n">
    //  841 1931:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  842 1934:pop             
        result.append("    m_FirstBatchDone = true;\n");
    //  843 1935:aload           4
    //  844 1937:ldc2            #644 <String "    m_FirstBatchDone = true;\n">
    //  845 1940:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  846 1943:pop             
        result.append("\n");
    //  847 1944:aload           4
    //  848 1946:ldc2            #366 <String "\n">
    //  849 1949:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  850 1952:pop             
        result.append("    return (inst.numInstances() > 0);\n");
    //  851 1953:aload           4
    //  852 1955:ldc2            #646 <String "    return (inst.numInstances() > 0);\n">
    //  853 1958:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  854 1961:pop             
        result.append("  }\n");
    //  855 1962:aload           4
    //  856 1964:ldc2            #419 <String "  }\n">
    //  857 1967:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  858 1970:pop             
        result.append("\n");
    //  859 1971:aload           4
    //  860 1973:ldc2            #366 <String "\n">
    //  861 1976:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  862 1979:pop             
        result.append("  /**\n");
    //  863 1980:aload           4
    //  864 1982:ldc2            #405 <String "  /**\n">
    //  865 1985:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  866 1988:pop             
        result.append("   * Returns only the classnames and what filter it is based on.\n");
    //  867 1989:aload           4
    //  868 1991:ldc2            #648 <String "   * Returns only the classnames and what filter it is based on.\n">
    //  869 1994:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  870 1997:pop             
        result.append("   *\n");
    //  871 1998:aload           4
    //  872 2000:ldc2            #409 <String "   *\n">
    //  873 2003:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  874 2006:pop             
        result.append("   * @return a short description\n");
    //  875 2007:aload           4
    //  876 2009:ldc2            #650 <String "   * @return a short description\n">
    //  877 2012:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  878 2015:pop             
        result.append("   */\n");
    //  879 2016:aload           4
    //  880 2018:ldc2            #413 <String "   */\n">
    //  881 2021:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  882 2024:pop             
        result.append("  public String toString() {\n");
    //  883 2025:aload           4
    //  884 2027:ldc2            #652 <String "  public String toString() {\n">
    //  885 2030:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  886 2033:pop             
        result.append((new StringBuilder("    return \"Auto-generated filter wrapper, based on ")).append(filter.getClass().getName()).append(" (generated with Weka ").append(Version.VERSION).append(").\\n").append("\" + this.getClass().getName() + \"/").append(className).append("\";\n").toString());
    //  887 2034:aload           4
    //  888 2036:new             #140 <Class StringBuilder>
    //  889 2039:dup             
    //  890 2040:ldc2            #654 <String "    return \"Auto-generated filter wrapper, based on ">
    //  891 2043:invokespecial   #152 <Method void StringBuilder(String)>
    //  892 2046:aload_0         
    //  893 2047:invokevirtual   #162 <Method Class Object.getClass()>
    //  894 2050:invokevirtual   #167 <Method String Class.getName()>
    //  895 2053:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  896 2056:ldc2            #656 <String " (generated with Weka ">
    //  897 2059:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  898 2062:getstatic       #364 <Field String Version.VERSION>
    //  899 2065:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  900 2068:ldc2            #658 <String ").\\n">
    //  901 2071:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  902 2074:ldc2            #660 <String "\" + this.getClass().getName() + \"/">
    //  903 2077:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  904 2080:aload_1         
    //  905 2081:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  906 2084:ldc2            #662 <String "\";\n">
    //  907 2087:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  908 2090:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  909 2093:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  910 2096:pop             
        result.append("  }\n");
    //  911 2097:aload           4
    //  912 2099:ldc2            #419 <String "  }\n">
    //  913 2102:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  914 2105:pop             
        result.append("\n");
    //  915 2106:aload           4
    //  916 2108:ldc2            #366 <String "\n">
    //  917 2111:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  918 2114:pop             
        result.append("  /**\n");
    //  919 2115:aload           4
    //  920 2117:ldc2            #405 <String "  /**\n">
    //  921 2120:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  922 2123:pop             
        result.append("   * Runs the filter from commandline.\n");
    //  923 2124:aload           4
    //  924 2126:ldc2            #664 <String "   * Runs the filter from commandline.\n">
    //  925 2129:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  926 2132:pop             
        result.append("   *\n");
    //  927 2133:aload           4
    //  928 2135:ldc2            #409 <String "   *\n">
    //  929 2138:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  930 2141:pop             
        result.append("   * @param args the commandline arguments\n");
    //  931 2142:aload           4
    //  932 2144:ldc2            #666 <String "   * @param args the commandline arguments\n">
    //  933 2147:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  934 2150:pop             
        result.append("   */\n");
    //  935 2151:aload           4
    //  936 2153:ldc2            #413 <String "   */\n">
    //  937 2156:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  938 2159:pop             
        result.append("  public static void main(String args[]) {\n");
    //  939 2160:aload           4
    //  940 2162:ldc2            #668 <String "  public static void main(String args[]) {\n">
    //  941 2165:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  942 2168:pop             
        result.append("    runFilter(new WekaWrapper(), args);\n");
    //  943 2169:aload           4
    //  944 2171:ldc2            #670 <String "    runFilter(new WekaWrapper(), args);\n">
    //  945 2174:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  946 2177:pop             
        result.append("  }\n");
    //  947 2178:aload           4
    //  948 2180:ldc2            #419 <String "  }\n">
    //  949 2183:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  950 2186:pop             
        result.append("}\n");
    //  951 2187:aload           4
    //  952 2189:ldc2            #672 <String "}\n">
    //  953 2192:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  954 2195:pop             
        result.append("\n");
    //  955 2196:aload           4
    //  956 2198:ldc2            #366 <String "\n">
    //  957 2201:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  958 2204:pop             
        result.append(filter.toSource(className, input));
    //  959 2205:aload           4
    //  960 2207:aload_0         
    //  961 2208:aload_1         
    //  962 2209:aload_2         
    //  963 2210:invokeinterface #677 <Method String Sourcable.toSource(String, Instances)>
    //  964 2215:invokevirtual   #369 <Method StringBuffer StringBuffer.append(String)>
    //  965 2218:pop             
        return result.toString();
    //  966 2219:aload           4
    //  967 2221:invokevirtual   #678 <Method String StringBuffer.toString()>
    //  968 2224:areturn         
    }

    public static void filterFile(Filter filter, String options[])
        throws Exception
    {
        boolean debug = false;
    //    0    0:iconst_0        
    //    1    1:istore_2        
        Instances data = null;
    //    2    2:aconst_null     
    //    3    3:astore_3        
        rm.core.converters.ConverterUtils.DataSource input = null;
    //    4    4:aconst_null     
    //    5    5:astore          4
        PrintWriter output = null;
    //    6    7:aconst_null     
    //    7    8:astore          5
        String sourceCode = "";
    //    8   10:ldc2            #686 <String "">
    //    9   13:astore          7
        try
        {
            boolean helpRequest = Utils.getFlag('h', options);
    //   10   15:bipush          104
    //   11   17:aload_1         
    //   12   18:invokestatic    #692 <Method boolean Utils.getFlag(char, String[])>
    //   13   21:istore          6
            if(Utils.getFlag('d', options))
    //*  14   23:bipush          100
    //*  15   25:aload_1         
    //*  16   26:invokestatic    #692 <Method boolean Utils.getFlag(char, String[])>
    //*  17   29:ifeq            34
                debug = true;
    //   18   32:iconst_1        
    //   19   33:istore_2        
            String infileName = Utils.getOption('i', options);
    //   20   34:bipush          105
    //   21   36:aload_1         
    //   22   37:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   23   40:astore          8
            String outfileName = Utils.getOption('o', options);
    //   24   42:bipush          111
    //   25   44:aload_1         
    //   26   45:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   27   48:astore          9
            String classIndex = Utils.getOption('c', options);
    //   28   50:bipush          99
    //   29   52:aload_1         
    //   30   53:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   31   56:astore          10
            if(filter instanceof Sourcable)
    //*  32   58:aload_0         
    //*  33   59:instanceof      #674 <Class Sourcable>
    //*  34   62:ifeq            73
                sourceCode = Utils.getOption('z', options);
    //   35   65:bipush          122
    //   36   67:aload_1         
    //   37   68:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   38   71:astore          7
            if(filter instanceof OptionHandler)
    //*  39   73:aload_0         
    //*  40   74:instanceof      #172 <Class OptionHandler>
    //*  41   77:ifeq            90
                ((OptionHandler)filter).setOptions(options);
    //   42   80:aload_0         
    //   43   81:checkcast       #172 <Class OptionHandler>
    //   44   84:aload_1         
    //   45   85:invokeinterface #700 <Method void OptionHandler.setOptions(String[])>
            Utils.checkForRemainingOptions(options);
    //   46   90:aload_1         
    //   47   91:invokestatic    #703 <Method void Utils.checkForRemainingOptions(String[])>
            if(helpRequest)
    //*  48   94:iload           6
    //*  49   96:ifeq            110
                throw new Exception("Help requested.\n");
    //   50   99:new             #264 <Class Exception>
    //   51  102:dup             
    //   52  103:ldc2            #705 <String "Help requested.\n">
    //   53  106:invokespecial   #330 <Method void Exception(String)>
    //   54  109:athrow          
            if(infileName.length() != 0)
    //*  55  110:aload           8
    //*  56  112:invokevirtual   #708 <Method int String.length()>
    //*  57  115:ifeq            132
                input = new rm.core.converters.ConverterUtils.DataSource(infileName);
    //   58  118:new             #710 <Class rm.core.converters.ConverterUtils$DataSource>
    //   59  121:dup             
    //   60  122:aload           8
    //   61  124:invokespecial   #711 <Method void rm.core.converters.ConverterUtils$DataSource(String)>
    //   62  127:astore          4
            else
    //*  63  129:goto            144
                input = new rm.core.converters.ConverterUtils.DataSource(System.in);
    //   64  132:new             #710 <Class rm.core.converters.ConverterUtils$DataSource>
    //   65  135:dup             
    //   66  136:getstatic       #717 <Field java.io.InputStream System.in>
    //   67  139:invokespecial   #720 <Method void rm.core.converters.ConverterUtils$DataSource(java.io.InputStream)>
    //   68  142:astore          4
            if(outfileName.length() != 0)
    //*  69  144:aload           9
    //*  70  146:invokevirtual   #708 <Method int String.length()>
    //*  71  149:ifeq            173
                output = new PrintWriter(new FileOutputStream(outfileName));
    //   72  152:new             #722 <Class PrintWriter>
    //   73  155:dup             
    //   74  156:new             #724 <Class FileOutputStream>
    //   75  159:dup             
    //   76  160:aload           9
    //   77  162:invokespecial   #725 <Method void FileOutputStream(String)>
    //   78  165:invokespecial   #728 <Method void PrintWriter(java.io.OutputStream)>
    //   79  168:astore          5
            else
    //*  80  170:goto            185
                output = new PrintWriter(System.out);
    //   81  173:new             #722 <Class PrintWriter>
    //   82  176:dup             
    //   83  177:getstatic       #732 <Field PrintStream System.out>
    //   84  180:invokespecial   #728 <Method void PrintWriter(java.io.OutputStream)>
    //   85  183:astore          5
            data = input.getStructure();
    //   86  185:aload           4
    //   87  187:invokevirtual   #735 <Method Instances rm.core.converters.ConverterUtils$DataSource.getStructure()>
    //   88  190:astore_3        
            if(classIndex.length() != 0)
    //*  89  191:aload           10
    //*  90  193:invokevirtual   #708 <Method int String.length()>
    //*  91  196:ifeq            452
                if(classIndex.equals("first"))
    //*  92  199:aload           10
    //*  93  201:ldc2            #737 <String "first">
    //*  94  204:invokevirtual   #741 <Method boolean String.equals(Object)>
    //*  95  207:ifeq            218
                    data.setClassIndex(0);
    //   96  210:aload_3         
    //   97  211:iconst_0        
    //   98  212:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                else
    //*  99  215:goto            452
                if(classIndex.equals("last"))
    //* 100  218:aload           10
    //* 101  220:ldc2            #746 <String "last">
    //* 102  223:invokevirtual   #741 <Method boolean String.equals(Object)>
    //* 103  226:ifeq            242
                    data.setClassIndex(data.numAttributes() - 1);
    //  104  229:aload_3         
    //  105  230:aload_3         
    //  106  231:invokevirtual   #588 <Method int Instances.numAttributes()>
    //  107  234:iconst_1        
    //  108  235:isub            
    //  109  236:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                else
    //* 110  239:goto            452
                    data.setClassIndex(Integer.parseInt(classIndex) - 1);
    //  111  242:aload_3         
    //  112  243:aload           10
    //  113  245:invokestatic    #752 <Method int Integer.parseInt(String)>
    //  114  248:iconst_1        
    //  115  249:isub            
    //  116  250:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
        }
    //* 117  253:goto            452
        catch(Exception ex)
    //* 118  256:astore          8
        {
            String filterOptions = "";
    //  119  258:ldc2            #686 <String "">
    //  120  261:astore          9
            if(filter instanceof OptionHandler)
    //* 121  263:aload_0         
    //* 122  264:instanceof      #172 <Class OptionHandler>
    //* 123  267:ifeq            376
            {
                filterOptions = (new StringBuilder(String.valueOf(filterOptions))).append("\nFilter options:\n\n").toString();
    //  124  270:new             #140 <Class StringBuilder>
    //  125  273:dup             
    //  126  274:aload           9
    //  127  276:invokestatic    #149 <Method String String.valueOf(Object)>
    //  128  279:invokespecial   #152 <Method void StringBuilder(String)>
    //  129  282:ldc2            #754 <String "\nFilter options:\n\n">
    //  130  285:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  131  288:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  132  291:astore          9
                for(Enumeration enu = ((OptionHandler)filter).listOptions(); enu.hasMoreElements();)
    //* 133  293:aload_0         
    //* 134  294:checkcast       #172 <Class OptionHandler>
    //* 135  297:invokeinterface #758 <Method Enumeration OptionHandler.listOptions()>
    //* 136  302:astore          10
    //* 137  304:goto            366
                {
                    Option option = (Option)(Option)enu.nextElement();
    //  138  307:aload           10
    //  139  309:invokeinterface #763 <Method Object Enumeration.nextElement()>
    //  140  314:checkcast       #765 <Class Option>
    //  141  317:checkcast       #765 <Class Option>
    //  142  320:astore          11
                    filterOptions = (new StringBuilder(String.valueOf(filterOptions))).append(option.synopsis()).append('\n').append(option.description()).append("\n").toString();
    //  143  322:new             #140 <Class StringBuilder>
    //  144  325:dup             
    //  145  326:aload           9
    //  146  328:invokestatic    #149 <Method String String.valueOf(Object)>
    //  147  331:invokespecial   #152 <Method void StringBuilder(String)>
    //  148  334:aload           11
    //  149  336:invokevirtual   #768 <Method String Option.synopsis()>
    //  150  339:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  151  342:bipush          10
    //  152  344:invokevirtual   #771 <Method StringBuilder StringBuilder.append(char)>
    //  153  347:aload           11
    //  154  349:invokevirtual   #774 <Method String Option.description()>
    //  155  352:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  156  355:ldc2            #366 <String "\n">
    //  157  358:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  158  361:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  159  364:astore          9
                }

    //  160  366:aload           10
    //  161  368:invokeinterface #777 <Method boolean Enumeration.hasMoreElements()>
    //  162  373:ifne            307
            }
            String genericOptions = "\nGeneral options:\n\n-h\n\tGet help on available options.\n\t(use -b -h for help on batch mode.)\n-i <file>\n\tThe name of the file containing input instances.\n\tIf not supplied then instances will be read from stdin.\n-o <file>\n\tThe name of the file output instances will be written to.\n\tIf not supplied then instances will be written to stdout.\n-c <class index>\n\tThe number of the attribute to use as the class.\n\t\"first\" and \"last\" are also valid entries.\n\tIf not supplied then no class is assigned.\n";
    //  163  376:ldc2            #779 <String "\nGeneral options:\n\n-h\n\tGet help on available options.\n\t(use -b -h for help on batch mode.)\n-i <file>\n\tThe name of the file containing input instances.\n\tIf not supplied then instances will be read from stdin.\n-o <file>\n\tThe name of the file output instances will be written to.\n\tIf not supplied then instances will be written to stdout.\n-c <class index>\n\tThe number of the attribute to use as the class.\n\t\"first\" and \"last\" are also valid entries.\n\tIf not supplied then no class is assigned.\n">
    //  164  379:astore          10
            if(filter instanceof Sourcable)
    //* 165  381:aload_0         
    //* 166  382:instanceof      #674 <Class Sourcable>
    //* 167  385:ifeq            411
                genericOptions = (new StringBuilder(String.valueOf(genericOptions))).append("-z <class name>\n\tOutputs the source code representing the trained filter.\n").toString();
    //  168  388:new             #140 <Class StringBuilder>
    //  169  391:dup             
    //  170  392:aload           10
    //  171  394:invokestatic    #149 <Method String String.valueOf(Object)>
    //  172  397:invokespecial   #152 <Method void StringBuilder(String)>
    //  173  400:ldc2            #781 <String "-z <class name>\n\tOutputs the source code representing the trained filter.\n">
    //  174  403:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  175  406:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  176  409:astore          10
            throw new Exception((new StringBuilder(String.valueOf('\n'))).append(ex.getMessage()).append(filterOptions).append(genericOptions).toString());
    //  177  411:new             #264 <Class Exception>
    //  178  414:dup             
    //  179  415:new             #140 <Class StringBuilder>
    //  180  418:dup             
    //  181  419:bipush          10
    //  182  421:invokestatic    #784 <Method String String.valueOf(char)>
    //  183  424:invokespecial   #152 <Method void StringBuilder(String)>
    //  184  427:aload           8
    //  185  429:invokevirtual   #787 <Method String Exception.getMessage()>
    //  186  432:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  187  435:aload           9
    //  188  437:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  189  440:aload           10
    //  190  442:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  191  445:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  192  448:invokespecial   #330 <Method void Exception(String)>
    //  193  451:athrow          
        }
        if(debug)
    //* 194  452:iload_2         
    //* 195  453:ifeq            465
            System.err.println("Setting input format");
    //  196  456:getstatic       #790 <Field PrintStream System.err>
    //  197  459:ldc2            #792 <String "Setting input format">
    //  198  462:invokevirtual   #797 <Method void PrintStream.println(String)>
        boolean printedHeader = false;
    //  199  465:iconst_0        
    //  200  466:istore          8
        if(filter.setInputFormat(data))
    //* 201  468:aload_0         
    //* 202  469:aload_3         
    //* 203  470:invokevirtual   #799 <Method boolean setInputFormat(Instances)>
    //* 204  473:ifeq            591
        {
            if(debug)
    //* 205  476:iload_2         
    //* 206  477:ifeq            489
                System.err.println("Getting output format");
    //  207  480:getstatic       #790 <Field PrintStream System.err>
    //  208  483:ldc2            #801 <String "Getting output format">
    //  209  486:invokevirtual   #797 <Method void PrintStream.println(String)>
            output.println(filter.getOutputFormat().toString());
    //  210  489:aload           5
    //  211  491:aload_0         
    //  212  492:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  213  495:invokevirtual   #802 <Method String Instances.toString()>
    //  214  498:invokevirtual   #803 <Method void PrintWriter.println(String)>
            printedHeader = true;
    //  215  501:iconst_1        
    //  216  502:istore          8
        }
    //* 217  504:goto            591
        while(input.hasMoreElements(data)) 
        {
            Instance inst = input.nextElement(data);
    //  218  507:aload           4
    //  219  509:aload_3         
    //  220  510:invokevirtual   #806 <Method Instance rm.core.converters.ConverterUtils$DataSource.nextElement(Instances)>
    //  221  513:astore          9
            if(debug)
    //* 222  515:iload_2         
    //* 223  516:ifeq            528
                System.err.println("Input instance to filter");
    //  224  519:getstatic       #790 <Field PrintStream System.err>
    //  225  522:ldc2            #808 <String "Input instance to filter">
    //  226  525:invokevirtual   #797 <Method void PrintStream.println(String)>
            if(filter.input(inst))
    //* 227  528:aload_0         
    //* 228  529:aload           9
    //* 229  531:invokevirtual   #342 <Method boolean input(Instance)>
    //* 230  534:ifeq            591
            {
                if(debug)
    //* 231  537:iload_2         
    //* 232  538:ifeq            550
                    System.err.println("Filter said collect immediately");
    //  233  541:getstatic       #790 <Field PrintStream System.err>
    //  234  544:ldc2            #810 <String "Filter said collect immediately">
    //  235  547:invokevirtual   #797 <Method void PrintStream.println(String)>
                if(!printedHeader)
    //* 236  550:iload           8
    //* 237  552:ifne            566
                    throw new Error("Filter didn't return true from setInputFormat() earlier!");
    //  238  555:new             #812 <Class Error>
    //  239  558:dup             
    //  240  559:ldc2            #814 <String "Filter didn't return true from setInputFormat() earlier!">
    //  241  562:invokespecial   #815 <Method void Error(String)>
    //  242  565:athrow          
                if(debug)
    //* 243  566:iload_2         
    //* 244  567:ifeq            579
                    System.err.println("Getting output instance");
    //  245  570:getstatic       #790 <Field PrintStream System.err>
    //  246  573:ldc2            #817 <String "Getting output instance">
    //  247  576:invokevirtual   #797 <Method void PrintStream.println(String)>
                output.println(filter.output().toString());
    //  248  579:aload           5
    //  249  581:aload_0         
    //  250  582:invokevirtual   #349 <Method Instance output()>
    //  251  585:invokevirtual   #818 <Method String Instance.toString()>
    //  252  588:invokevirtual   #803 <Method void PrintWriter.println(String)>
            }
        }
    //  253  591:aload           4
    //  254  593:aload_3         
    //  255  594:invokevirtual   #820 <Method boolean rm.core.converters.ConverterUtils$DataSource.hasMoreElements(Instances)>
    //  256  597:ifne            507
        if(debug)
    //* 257  600:iload_2         
    //* 258  601:ifeq            613
            System.err.println("Setting end of batch");
    //  259  604:getstatic       #790 <Field PrintStream System.err>
    //  260  607:ldc2            #822 <String "Setting end of batch">
    //  261  610:invokevirtual   #797 <Method void PrintStream.println(String)>
        if(filter.batchFinished())
    //* 262  613:aload_0         
    //* 263  614:invokevirtual   #347 <Method boolean batchFinished()>
    //* 264  617:ifeq            711
        {
            if(debug)
    //* 265  620:iload_2         
    //* 266  621:ifeq            633
                System.err.println("Filter said collect output");
    //  267  624:getstatic       #790 <Field PrintStream System.err>
    //  268  627:ldc2            #824 <String "Filter said collect output">
    //  269  630:invokevirtual   #797 <Method void PrintStream.println(String)>
            if(!printedHeader)
    //* 270  633:iload           8
    //* 271  635:ifne            663
            {
                if(debug)
    //* 272  638:iload_2         
    //* 273  639:ifeq            651
                    System.err.println("Getting output format");
    //  274  642:getstatic       #790 <Field PrintStream System.err>
    //  275  645:ldc2            #801 <String "Getting output format">
    //  276  648:invokevirtual   #797 <Method void PrintStream.println(String)>
                output.println(filter.getOutputFormat().toString());
    //  277  651:aload           5
    //  278  653:aload_0         
    //  279  654:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  280  657:invokevirtual   #802 <Method String Instances.toString()>
    //  281  660:invokevirtual   #803 <Method void PrintWriter.println(String)>
            }
            if(debug)
    //* 282  663:iload_2         
    //* 283  664:ifeq            704
                System.err.println("Getting output instance");
    //  284  667:getstatic       #790 <Field PrintStream System.err>
    //  285  670:ldc2            #817 <String "Getting output instance">
    //  286  673:invokevirtual   #797 <Method void PrintStream.println(String)>
    //* 287  676:goto            704
            while(filter.numPendingOutput() > 0) 
            {
                output.println(filter.output().toString());
    //  288  679:aload           5
    //  289  681:aload_0         
    //  290  682:invokevirtual   #349 <Method Instance output()>
    //  291  685:invokevirtual   #818 <Method String Instance.toString()>
    //  292  688:invokevirtual   #803 <Method void PrintWriter.println(String)>
                if(debug)
    //* 293  691:iload_2         
    //* 294  692:ifeq            704
                    System.err.println("Getting output instance");
    //  295  695:getstatic       #790 <Field PrintStream System.err>
    //  296  698:ldc2            #817 <String "Getting output instance">
    //  297  701:invokevirtual   #797 <Method void PrintStream.println(String)>
            }
    //  298  704:aload_0         
    //  299  705:invokevirtual   #296 <Method int numPendingOutput()>
    //  300  708:ifgt            679
        }
        if(debug)
    //* 301  711:iload_2         
    //* 302  712:ifeq            724
            System.err.println("Done");
    //  303  715:getstatic       #790 <Field PrintStream System.err>
    //  304  718:ldc2            #826 <String "Done">
    //  305  721:invokevirtual   #797 <Method void PrintStream.println(String)>
        if(output != null)
    //* 306  724:aload           5
    //* 307  726:ifnull          734
            output.close();
    //  308  729:aload           5
    //  309  731:invokevirtual   #829 <Method void PrintWriter.close()>
        if(sourceCode.length() != 0)
    //* 310  734:aload           7
    //* 311  736:invokevirtual   #708 <Method int String.length()>
    //* 312  739:ifeq            762
            System.out.println(rmStaticWrapper((Sourcable)filter, sourceCode, data, filter.getOutputFormat()));
    //  313  742:getstatic       #732 <Field PrintStream System.out>
    //  314  745:aload_0         
    //  315  746:checkcast       #674 <Class Sourcable>
    //  316  749:aload           7
    //  317  751:aload_3         
    //  318  752:aload_0         
    //  319  753:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  320  756:invokestatic    #831 <Method String rmStaticWrapper(Sourcable, String, Instances, Instances)>
    //  321  759:invokevirtual   #797 <Method void PrintStream.println(String)>
    //  322  762:return          
    }

    public static void batchFilterFile(Filter filter, String options[])
        throws Exception
    {
        Instances firstData = null;
    //    0    0:aconst_null     
    //    1    1:astore_2        
        Instances secondData = null;
    //    2    2:aconst_null     
    //    3    3:astore_3        
        rm.core.converters.ConverterUtils.DataSource firstInput = null;
    //    4    4:aconst_null     
    //    5    5:astore          4
        rm.core.converters.ConverterUtils.DataSource secondInput = null;
    //    6    7:aconst_null     
    //    7    8:astore          5
        PrintWriter firstOutput = null;
    //    8   10:aconst_null     
    //    9   11:astore          6
        PrintWriter secondOutput = null;
    //   10   13:aconst_null     
    //   11   14:astore          7
        String sourceCode = "";
    //   12   16:ldc2            #686 <String "">
    //   13   19:astore          9
        try
        {
            boolean helpRequest = Utils.getFlag('h', options);
    //   14   21:bipush          104
    //   15   23:aload_1         
    //   16   24:invokestatic    #692 <Method boolean Utils.getFlag(char, String[])>
    //   17   27:istore          8
            String fileName = Utils.getOption('i', options);
    //   18   29:bipush          105
    //   19   31:aload_1         
    //   20   32:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   21   35:astore          10
            if(fileName.length() != 0)
    //*  22   37:aload           10
    //*  23   39:invokevirtual   #708 <Method int String.length()>
    //*  24   42:ifeq            59
                firstInput = new rm.core.converters.ConverterUtils.DataSource(fileName);
    //   25   45:new             #710 <Class rm.core.converters.ConverterUtils$DataSource>
    //   26   48:dup             
    //   27   49:aload           10
    //   28   51:invokespecial   #711 <Method void rm.core.converters.ConverterUtils$DataSource(String)>
    //   29   54:astore          4
            else
    //*  30   56:goto            70
                throw new Exception("No first input file given.\n");
    //   31   59:new             #264 <Class Exception>
    //   32   62:dup             
    //   33   63:ldc2            #851 <String "No first input file given.\n">
    //   34   66:invokespecial   #330 <Method void Exception(String)>
    //   35   69:athrow          
            fileName = Utils.getOption('r', options);
    //   36   70:bipush          114
    //   37   72:aload_1         
    //   38   73:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   39   76:astore          10
            if(fileName.length() != 0)
    //*  40   78:aload           10
    //*  41   80:invokevirtual   #708 <Method int String.length()>
    //*  42   83:ifeq            100
                secondInput = new rm.core.converters.ConverterUtils.DataSource(fileName);
    //   43   86:new             #710 <Class rm.core.converters.ConverterUtils$DataSource>
    //   44   89:dup             
    //   45   90:aload           10
    //   46   92:invokespecial   #711 <Method void rm.core.converters.ConverterUtils$DataSource(String)>
    //   47   95:astore          5
            else
    //*  48   97:goto            111
                throw new Exception("No second input file given.\n");
    //   49  100:new             #264 <Class Exception>
    //   50  103:dup             
    //   51  104:ldc2            #853 <String "No second input file given.\n">
    //   52  107:invokespecial   #330 <Method void Exception(String)>
    //   53  110:athrow          
            fileName = Utils.getOption('o', options);
    //   54  111:bipush          111
    //   55  113:aload_1         
    //   56  114:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   57  117:astore          10
            if(fileName.length() != 0)
    //*  58  119:aload           10
    //*  59  121:invokevirtual   #708 <Method int String.length()>
    //*  60  124:ifeq            148
                firstOutput = new PrintWriter(new FileOutputStream(fileName));
    //   61  127:new             #722 <Class PrintWriter>
    //   62  130:dup             
    //   63  131:new             #724 <Class FileOutputStream>
    //   64  134:dup             
    //   65  135:aload           10
    //   66  137:invokespecial   #725 <Method void FileOutputStream(String)>
    //   67  140:invokespecial   #728 <Method void PrintWriter(java.io.OutputStream)>
    //   68  143:astore          6
            else
    //*  69  145:goto            160
                firstOutput = new PrintWriter(System.out);
    //   70  148:new             #722 <Class PrintWriter>
    //   71  151:dup             
    //   72  152:getstatic       #732 <Field PrintStream System.out>
    //   73  155:invokespecial   #728 <Method void PrintWriter(java.io.OutputStream)>
    //   74  158:astore          6
            fileName = Utils.getOption('s', options);
    //   75  160:bipush          115
    //   76  162:aload_1         
    //   77  163:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   78  166:astore          10
            if(fileName.length() != 0)
    //*  79  168:aload           10
    //*  80  170:invokevirtual   #708 <Method int String.length()>
    //*  81  173:ifeq            197
                secondOutput = new PrintWriter(new FileOutputStream(fileName));
    //   82  176:new             #722 <Class PrintWriter>
    //   83  179:dup             
    //   84  180:new             #724 <Class FileOutputStream>
    //   85  183:dup             
    //   86  184:aload           10
    //   87  186:invokespecial   #725 <Method void FileOutputStream(String)>
    //   88  189:invokespecial   #728 <Method void PrintWriter(java.io.OutputStream)>
    //   89  192:astore          7
            else
    //*  90  194:goto            209
                secondOutput = new PrintWriter(System.out);
    //   91  197:new             #722 <Class PrintWriter>
    //   92  200:dup             
    //   93  201:getstatic       #732 <Field PrintStream System.out>
    //   94  204:invokespecial   #728 <Method void PrintWriter(java.io.OutputStream)>
    //   95  207:astore          7
            String classIndex = Utils.getOption('c', options);
    //   96  209:bipush          99
    //   97  211:aload_1         
    //   98  212:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //   99  215:astore          11
            if(filter instanceof Sourcable)
    //* 100  217:aload_0         
    //* 101  218:instanceof      #674 <Class Sourcable>
    //* 102  221:ifeq            232
                sourceCode = Utils.getOption('z', options);
    //  103  224:bipush          122
    //  104  226:aload_1         
    //  105  227:invokestatic    #696 <Method String Utils.getOption(char, String[])>
    //  106  230:astore          9
            if(filter instanceof OptionHandler)
    //* 107  232:aload_0         
    //* 108  233:instanceof      #172 <Class OptionHandler>
    //* 109  236:ifeq            249
                ((OptionHandler)filter).setOptions(options);
    //  110  239:aload_0         
    //  111  240:checkcast       #172 <Class OptionHandler>
    //  112  243:aload_1         
    //  113  244:invokeinterface #700 <Method void OptionHandler.setOptions(String[])>
            Utils.checkForRemainingOptions(options);
    //  114  249:aload_1         
    //  115  250:invokestatic    #703 <Method void Utils.checkForRemainingOptions(String[])>
            if(helpRequest)
    //* 116  253:iload           8
    //* 117  255:ifeq            269
                throw new Exception("Help requested.\n");
    //  118  258:new             #264 <Class Exception>
    //  119  261:dup             
    //  120  262:ldc2            #705 <String "Help requested.\n">
    //  121  265:invokespecial   #330 <Method void Exception(String)>
    //  122  268:athrow          
            firstData = firstInput.getStructure();
    //  123  269:aload           4
    //  124  271:invokevirtual   #735 <Method Instances rm.core.converters.ConverterUtils$DataSource.getStructure()>
    //  125  274:astore_2        
            secondData = secondInput.getStructure();
    //  126  275:aload           5
    //  127  277:invokevirtual   #735 <Method Instances rm.core.converters.ConverterUtils$DataSource.getStructure()>
    //  128  280:astore_3        
            if(!secondData.equalHeaders(firstData))
    //* 129  281:aload_3         
    //* 130  282:aload_2         
    //* 131  283:invokevirtual   #856 <Method boolean Instances.equalHeaders(Instances)>
    //* 132  286:ifne            300
                throw new Exception("Input file formats differ.\n");
    //  133  289:new             #264 <Class Exception>
    //  134  292:dup             
    //  135  293:ldc2            #858 <String "Input file formats differ.\n">
    //  136  296:invokespecial   #330 <Method void Exception(String)>
    //  137  299:athrow          
            if(classIndex.length() != 0)
    //* 138  300:aload           11
    //* 139  302:invokevirtual   #708 <Method int String.length()>
    //* 140  305:ifeq            587
                if(classIndex.equals("first"))
    //* 141  308:aload           11
    //* 142  310:ldc2            #737 <String "first">
    //* 143  313:invokevirtual   #741 <Method boolean String.equals(Object)>
    //* 144  316:ifeq            332
                {
                    firstData.setClassIndex(0);
    //  145  319:aload_2         
    //  146  320:iconst_0        
    //  147  321:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                    secondData.setClassIndex(0);
    //  148  324:aload_3         
    //  149  325:iconst_0        
    //  150  326:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                } else
    //* 151  329:goto            587
                if(classIndex.equals("last"))
    //* 152  332:aload           11
    //* 153  334:ldc2            #746 <String "last">
    //* 154  337:invokevirtual   #741 <Method boolean String.equals(Object)>
    //* 155  340:ifeq            366
                {
                    firstData.setClassIndex(firstData.numAttributes() - 1);
    //  156  343:aload_2         
    //  157  344:aload_2         
    //  158  345:invokevirtual   #588 <Method int Instances.numAttributes()>
    //  159  348:iconst_1        
    //  160  349:isub            
    //  161  350:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                    secondData.setClassIndex(secondData.numAttributes() - 1);
    //  162  353:aload_3         
    //  163  354:aload_3         
    //  164  355:invokevirtual   #588 <Method int Instances.numAttributes()>
    //  165  358:iconst_1        
    //  166  359:isub            
    //  167  360:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                } else
    //* 168  363:goto            587
                {
                    firstData.setClassIndex(Integer.parseInt(classIndex) - 1);
    //  169  366:aload_2         
    //  170  367:aload           11
    //  171  369:invokestatic    #752 <Method int Integer.parseInt(String)>
    //  172  372:iconst_1        
    //  173  373:isub            
    //  174  374:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                    secondData.setClassIndex(Integer.parseInt(classIndex) - 1);
    //  175  377:aload_3         
    //  176  378:aload           11
    //  177  380:invokestatic    #752 <Method int Integer.parseInt(String)>
    //  178  383:iconst_1        
    //  179  384:isub            
    //  180  385:invokevirtual   #744 <Method void Instances.setClassIndex(int)>
                }
        }
    //* 181  388:goto            587
        catch(Exception ex)
    //* 182  391:astore          10
        {
            String filterOptions = "";
    //  183  393:ldc2            #686 <String "">
    //  184  396:astore          11
            if(filter instanceof OptionHandler)
    //* 185  398:aload_0         
    //* 186  399:instanceof      #172 <Class OptionHandler>
    //* 187  402:ifeq            511
            {
                filterOptions = (new StringBuilder(String.valueOf(filterOptions))).append("\nFilter options:\n\n").toString();
    //  188  405:new             #140 <Class StringBuilder>
    //  189  408:dup             
    //  190  409:aload           11
    //  191  411:invokestatic    #149 <Method String String.valueOf(Object)>
    //  192  414:invokespecial   #152 <Method void StringBuilder(String)>
    //  193  417:ldc2            #754 <String "\nFilter options:\n\n">
    //  194  420:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  195  423:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  196  426:astore          11
                for(Enumeration enu = ((OptionHandler)filter).listOptions(); enu.hasMoreElements();)
    //* 197  428:aload_0         
    //* 198  429:checkcast       #172 <Class OptionHandler>
    //* 199  432:invokeinterface #758 <Method Enumeration OptionHandler.listOptions()>
    //* 200  437:astore          12
    //* 201  439:goto            501
                {
                    Option option = (Option)(Option)enu.nextElement();
    //  202  442:aload           12
    //  203  444:invokeinterface #763 <Method Object Enumeration.nextElement()>
    //  204  449:checkcast       #765 <Class Option>
    //  205  452:checkcast       #765 <Class Option>
    //  206  455:astore          13
                    filterOptions = (new StringBuilder(String.valueOf(filterOptions))).append(option.synopsis()).append('\n').append(option.description()).append("\n").toString();
    //  207  457:new             #140 <Class StringBuilder>
    //  208  460:dup             
    //  209  461:aload           11
    //  210  463:invokestatic    #149 <Method String String.valueOf(Object)>
    //  211  466:invokespecial   #152 <Method void StringBuilder(String)>
    //  212  469:aload           13
    //  213  471:invokevirtual   #768 <Method String Option.synopsis()>
    //  214  474:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  215  477:bipush          10
    //  216  479:invokevirtual   #771 <Method StringBuilder StringBuilder.append(char)>
    //  217  482:aload           13
    //  218  484:invokevirtual   #774 <Method String Option.description()>
    //  219  487:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  220  490:ldc2            #366 <String "\n">
    //  221  493:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  222  496:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  223  499:astore          11
                }

    //  224  501:aload           12
    //  225  503:invokeinterface #777 <Method boolean Enumeration.hasMoreElements()>
    //  226  508:ifne            442
            }
            String genericOptions = "\nGeneral options:\n\n-h\n\tGet help on available options.\n-i <filename>\n\tThe file containing first input instances.\n-o <filename>\n\tThe file first output instances will be written to.\n-r <filename>\n\tThe file containing second input instances.\n-s <filename>\n\tThe file second output instances will be written to.\n-c <class index>\n\tThe number of the attribute to use as the class.\n\t\"first\" and \"last\" are also valid entries.\n\tIf not supplied then no class is assigned.\n";
    //  227  511:ldc2            #860 <String "\nGeneral options:\n\n-h\n\tGet help on available options.\n-i <filename>\n\tThe file containing first input instances.\n-o <filename>\n\tThe file first output instances will be written to.\n-r <filename>\n\tThe file containing second input instances.\n-s <filename>\n\tThe file second output instances will be written to.\n-c <class index>\n\tThe number of the attribute to use as the class.\n\t\"first\" and \"last\" are also valid entries.\n\tIf not supplied then no class is assigned.\n">
    //  228  514:astore          12
            if(filter instanceof Sourcable)
    //* 229  516:aload_0         
    //* 230  517:instanceof      #674 <Class Sourcable>
    //* 231  520:ifeq            546
                genericOptions = (new StringBuilder(String.valueOf(genericOptions))).append("-z <class name>\n\tOutputs the source code representing the trained filter.\n").toString();
    //  232  523:new             #140 <Class StringBuilder>
    //  233  526:dup             
    //  234  527:aload           12
    //  235  529:invokestatic    #149 <Method String String.valueOf(Object)>
    //  236  532:invokespecial   #152 <Method void StringBuilder(String)>
    //  237  535:ldc2            #781 <String "-z <class name>\n\tOutputs the source code representing the trained filter.\n">
    //  238  538:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  239  541:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  240  544:astore          12
            throw new Exception((new StringBuilder(String.valueOf('\n'))).append(ex.getMessage()).append(filterOptions).append(genericOptions).toString());
    //  241  546:new             #264 <Class Exception>
    //  242  549:dup             
    //  243  550:new             #140 <Class StringBuilder>
    //  244  553:dup             
    //  245  554:bipush          10
    //  246  556:invokestatic    #784 <Method String String.valueOf(char)>
    //  247  559:invokespecial   #152 <Method void StringBuilder(String)>
    //  248  562:aload           10
    //  249  564:invokevirtual   #787 <Method String Exception.getMessage()>
    //  250  567:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  251  570:aload           11
    //  252  572:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  253  575:aload           12
    //  254  577:invokevirtual   #158 <Method StringBuilder StringBuilder.append(String)>
    //  255  580:invokevirtual   #170 <Method String StringBuilder.toString()>
    //  256  583:invokespecial   #330 <Method void Exception(String)>
    //  257  586:athrow          
        }
        boolean printedHeader = false;
    //  258  587:iconst_0        
    //  259  588:istore          10
        if(filter.setInputFormat(firstData))
    //* 260  590:aload_0         
    //* 261  591:aload_2         
    //* 262  592:invokevirtual   #799 <Method boolean setInputFormat(Instances)>
    //* 263  595:ifeq            661
        {
            firstOutput.println(filter.getOutputFormat().toString());
    //  264  598:aload           6
    //  265  600:aload_0         
    //  266  601:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  267  604:invokevirtual   #802 <Method String Instances.toString()>
    //  268  607:invokevirtual   #803 <Method void PrintWriter.println(String)>
            printedHeader = true;
    //  269  610:iconst_1        
    //  270  611:istore          10
        }
    //* 271  613:goto            661
        while(firstInput.hasMoreElements(firstData)) 
        {
            Instance inst = firstInput.nextElement(firstData);
    //  272  616:aload           4
    //  273  618:aload_2         
    //  274  619:invokevirtual   #806 <Method Instance rm.core.converters.ConverterUtils$DataSource.nextElement(Instances)>
    //  275  622:astore          11
            if(filter.input(inst))
    //* 276  624:aload_0         
    //* 277  625:aload           11
    //* 278  627:invokevirtual   #342 <Method boolean input(Instance)>
    //* 279  630:ifeq            661
            {
                if(!printedHeader)
    //* 280  633:iload           10
    //* 281  635:ifne            649
                    throw new Error("Filter didn't return true from setInputFormat() earlier!");
    //  282  638:new             #812 <Class Error>
    //  283  641:dup             
    //  284  642:ldc2            #814 <String "Filter didn't return true from setInputFormat() earlier!">
    //  285  645:invokespecial   #815 <Method void Error(String)>
    //  286  648:athrow          
                firstOutput.println(filter.output().toString());
    //  287  649:aload           6
    //  288  651:aload_0         
    //  289  652:invokevirtual   #349 <Method Instance output()>
    //  290  655:invokevirtual   #818 <Method String Instance.toString()>
    //  291  658:invokevirtual   #803 <Method void PrintWriter.println(String)>
            }
        }
    //  292  661:aload           4
    //  293  663:aload_2         
    //  294  664:invokevirtual   #820 <Method boolean rm.core.converters.ConverterUtils$DataSource.hasMoreElements(Instances)>
    //  295  667:ifne            616
        if(filter.batchFinished())
    //* 296  670:aload_0         
    //* 297  671:invokevirtual   #347 <Method boolean batchFinished()>
    //* 298  674:ifeq            716
        {
            if(!printedHeader)
    //* 299  677:iload           10
    //* 300  679:ifne            709
                firstOutput.println(filter.getOutputFormat().toString());
    //  301  682:aload           6
    //  302  684:aload_0         
    //  303  685:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  304  688:invokevirtual   #802 <Method String Instances.toString()>
    //  305  691:invokevirtual   #803 <Method void PrintWriter.println(String)>
    //* 306  694:goto            709
            for(; filter.numPendingOutput() > 0; firstOutput.println(filter.output().toString()));
    //  307  697:aload           6
    //  308  699:aload_0         
    //  309  700:invokevirtual   #349 <Method Instance output()>
    //  310  703:invokevirtual   #818 <Method String Instance.toString()>
    //  311  706:invokevirtual   #803 <Method void PrintWriter.println(String)>
    //  312  709:aload_0         
    //  313  710:invokevirtual   #296 <Method int numPendingOutput()>
    //  314  713:ifgt            697
        }
        if(firstOutput != null)
    //* 315  716:aload           6
    //* 316  718:ifnull          726
            firstOutput.close();
    //  317  721:aload           6
    //  318  723:invokevirtual   #829 <Method void PrintWriter.close()>
        printedHeader = false;
    //  319  726:iconst_0        
    //  320  727:istore          10
        if(filter.isOutputFormatDefined())
    //* 321  729:aload_0         
    //* 322  730:invokevirtual   #862 <Method boolean isOutputFormatDefined()>
    //* 323  733:ifeq            799
        {
            secondOutput.println(filter.getOutputFormat().toString());
    //  324  736:aload           7
    //  325  738:aload_0         
    //  326  739:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  327  742:invokevirtual   #802 <Method String Instances.toString()>
    //  328  745:invokevirtual   #803 <Method void PrintWriter.println(String)>
            printedHeader = true;
    //  329  748:iconst_1        
    //  330  749:istore          10
        }
    //* 331  751:goto            799
        while(secondInput.hasMoreElements(secondData)) 
        {
            Instance inst = secondInput.nextElement(secondData);
    //  332  754:aload           5
    //  333  756:aload_3         
    //  334  757:invokevirtual   #806 <Method Instance rm.core.converters.ConverterUtils$DataSource.nextElement(Instances)>
    //  335  760:astore          11
            if(filter.input(inst))
    //* 336  762:aload_0         
    //* 337  763:aload           11
    //* 338  765:invokevirtual   #342 <Method boolean input(Instance)>
    //* 339  768:ifeq            799
            {
                if(!printedHeader)
    //* 340  771:iload           10
    //* 341  773:ifne            787
                    throw new Error("Filter didn't return true from isOutputFormatDefined() earlier!");
    //  342  776:new             #812 <Class Error>
    //  343  779:dup             
    //  344  780:ldc2            #864 <String "Filter didn't return true from isOutputFormatDefined() earlier!">
    //  345  783:invokespecial   #815 <Method void Error(String)>
    //  346  786:athrow          
                secondOutput.println(filter.output().toString());
    //  347  787:aload           7
    //  348  789:aload_0         
    //  349  790:invokevirtual   #349 <Method Instance output()>
    //  350  793:invokevirtual   #818 <Method String Instance.toString()>
    //  351  796:invokevirtual   #803 <Method void PrintWriter.println(String)>
            }
        }
    //  352  799:aload           5
    //  353  801:aload_3         
    //  354  802:invokevirtual   #820 <Method boolean rm.core.converters.ConverterUtils$DataSource.hasMoreElements(Instances)>
    //  355  805:ifne            754
        if(filter.batchFinished())
    //* 356  808:aload_0         
    //* 357  809:invokevirtual   #347 <Method boolean batchFinished()>
    //* 358  812:ifeq            854
        {
            if(!printedHeader)
    //* 359  815:iload           10
    //* 360  817:ifne            847
                secondOutput.println(filter.getOutputFormat().toString());
    //  361  820:aload           7
    //  362  822:aload_0         
    //  363  823:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  364  826:invokevirtual   #802 <Method String Instances.toString()>
    //  365  829:invokevirtual   #803 <Method void PrintWriter.println(String)>
    //* 366  832:goto            847
            for(; filter.numPendingOutput() > 0; secondOutput.println(filter.output().toString()));
    //  367  835:aload           7
    //  368  837:aload_0         
    //  369  838:invokevirtual   #349 <Method Instance output()>
    //  370  841:invokevirtual   #818 <Method String Instance.toString()>
    //  371  844:invokevirtual   #803 <Method void PrintWriter.println(String)>
    //  372  847:aload_0         
    //  373  848:invokevirtual   #296 <Method int numPendingOutput()>
    //  374  851:ifgt            835
        }
        if(secondOutput != null)
    //* 375  854:aload           7
    //* 376  856:ifnull          864
            secondOutput.close();
    //  377  859:aload           7
    //  378  861:invokevirtual   #829 <Method void PrintWriter.close()>
        if(sourceCode.length() != 0)
    //* 379  864:aload           9
    //* 380  866:invokevirtual   #708 <Method int String.length()>
    //* 381  869:ifeq            892
            System.out.println(rmStaticWrapper((Sourcable)filter, sourceCode, firstData, filter.getOutputFormat()));
    //  382  872:getstatic       #732 <Field PrintStream System.out>
    //  383  875:aload_0         
    //  384  876:checkcast       #674 <Class Sourcable>
    //  385  879:aload           9
    //  386  881:aload_2         
    //  387  882:aload_0         
    //  388  883:invokevirtual   #246 <Method Instances getOutputFormat()>
    //  389  886:invokestatic    #831 <Method String rmStaticWrapper(Sourcable, String, Instances, Instances)>
    //  390  889:invokevirtual   #797 <Method void PrintStream.println(String)>
    //  391  892:return          
    }

    protected static void runFilter(Filter filter, String options[])
    {
        try
        {
            if(Utils.getFlag('b', options))
    //*   0    0:bipush          98
    //*   1    2:aload_1         
    //*   2    3:invokestatic    #692 <Method boolean Utils.getFlag(char, String[])>
    //*   3    6:ifeq            17
                batchFilterFile(filter, options);
    //    4    9:aload_0         
    //    5   10:aload_1         
    //    6   11:invokestatic    #874 <Method void batchFilterFile(Filter, String[])>
            else
    //*   7   14:goto            71
                filterFile(filter, options);
    //    8   17:aload_0         
    //    9   18:aload_1         
    //   10   19:invokestatic    #876 <Method void filterFile(Filter, String[])>
        }
    //*  11   22:goto            71
        catch(Exception e)
    //*  12   25:astore_2        
        {
            if(e.toString().indexOf("Help requested") == -1 && e.toString().indexOf("Filter options") == -1)
    //*  13   26:aload_2         
    //*  14   27:invokevirtual   #877 <Method String Exception.toString()>
    //*  15   30:ldc2            #879 <String "Help requested">
    //*  16   33:invokevirtual   #882 <Method int String.indexOf(String)>
    //*  17   36:iconst_m1       
    //*  18   37:icmpne          61
    //*  19   40:aload_2         
    //*  20   41:invokevirtual   #877 <Method String Exception.toString()>
    //*  21   44:ldc2            #884 <String "Filter options">
    //*  22   47:invokevirtual   #882 <Method int String.indexOf(String)>
    //*  23   50:iconst_m1       
    //*  24   51:icmpne          61
                e.printStackTrace();
    //   25   54:aload_2         
    //   26   55:invokevirtual   #887 <Method void Exception.printStackTrace()>
            else
    //*  27   58:goto            71
                System.err.println(e.getMessage());
    //   28   61:getstatic       #790 <Field PrintStream System.err>
    //   29   64:aload_2         
    //   30   65:invokevirtual   #787 <Method String Exception.getMessage()>
    //   31   68:invokevirtual   #797 <Method void PrintStream.println(String)>
        }
    //   32   71:return          
    }

    public static void main(String args[])
    {
        try
        {
            if(args.length == 0)
    //*   0    0:aload_0         
    //*   1    1:arraylength     
    //*   2    2:ifne            16
                throw new Exception("First argument must be the class name of a Filter");
    //    3    5:new             #264 <Class Exception>
    //    4    8:dup             
    //    5    9:ldc2            #891 <String "First argument must be the class name of a Filter">
    //    6   12:invokespecial   #330 <Method void Exception(String)>
    //    7   15:athrow          
            String fname = args[0];
    //    8   16:aload_0         
    //    9   17:iconst_0        
    //   10   18:aaload          
    //   11   19:astore_1        
            Filter f = (Filter)(Filter)Class.forName(fname).newInstance();
    //   12   20:aload_1         
    //   13   21:invokestatic    #895 <Method Class Class.forName(String)>
    //   14   24:invokevirtual   #898 <Method Object Class.newInstance()>
    //   15   27:checkcast       #2   <Class Filter>
    //   16   30:checkcast       #2   <Class Filter>
    //   17   33:astore_2        
            args[0] = "";
    //   18   34:aload_0         
    //   19   35:iconst_0        
    //   20   36:ldc2            #686 <String "">
    //   21   39:aastore         
            runFilter(f, args);
    //   22   40:aload_2         
    //   23   41:aload_0         
    //   24   42:invokestatic    #900 <Method void runFilter(Filter, String[])>
        }
    //*  25   45:goto            63
        catch(Exception ex)
    //*  26   48:astore_1        
        {
            ex.printStackTrace();
    //   27   49:aload_1         
    //   28   50:invokevirtual   #887 <Method void Exception.printStackTrace()>
            System.err.println(ex.getMessage());
    //   29   53:getstatic       #790 <Field PrintStream System.err>
    //   30   56:aload_1         
    //   31   57:invokevirtual   #787 <Method String Exception.getMessage()>
    //   32   60:invokevirtual   #797 <Method void PrintStream.println(String)>
        }
    //   33   63:return          
    }

    private static final long serialVersionUID = 0x85638c52fe23402eL;
    private Instances m_OutputFormat;
    private Queue m_OutputQueue;
    protected StringLocator m_OutputStringAtts;
    protected StringLocator m_InputStringAtts;
    protected RelationalLocator m_OutputRelAtts;
    protected RelationalLocator m_InputRelAtts;
    private Instances m_InputFormat;
    protected boolean m_NewBatch;
    protected boolean m_FirstBatchDone;
}

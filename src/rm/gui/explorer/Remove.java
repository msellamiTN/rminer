// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Remove.java

package rm.gui.explorer;

import java.util.Enumeration;
import java.util.Vector;
import rm.core.*;
import rm.filters.*;

public class Remove extends Filter
    implements UnsupervisedFilter, StreamableFilter, OptionHandler
{

    public Remove()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #24  <Method void Filter()>
        m_SelectCols = new Range();
    //    2    4:aload_0         
    //    3    5:new             #26  <Class Range>
    //    4    8:dup             
    //    5    9:invokespecial   #27  <Method void Range()>
    //    6   12:putfield        #29  <Field Range m_SelectCols>
        m_SelectCols.setInvert(true);
    //    7   15:aload_0         
    //    8   16:getfield        #29  <Field Range m_SelectCols>
    //    9   19:iconst_1        
    //   10   20:invokevirtual   #33  <Method void Range.setInvert(boolean)>
    //   11   23:return          
    }

    public Enumeration listOptions()
    {
        Vector newVector = new Vector(2);
    //    0    0:new             #41  <Class Vector>
    //    1    3:dup             
    //    2    4:iconst_2        
    //    3    5:invokespecial   #44  <Method void Vector(int)>
    //    4    8:astore_1        
        newVector.addElement(new Option("\tSpecify list of columns to delete. First and last are valid\n\tindexes. (default none)", "R", 1, "-R <index1,index2-index4,...>"));
    //    5    9:aload_1         
    //    6   10:new             #46  <Class Option>
    //    7   13:dup             
    //    8   14:ldc1            #48  <String "\tSpecify list of columns to delete. First and last are valid\n\tindexes. (default none)">
    //    9   16:ldc1            #50  <String "R">
    //   10   18:iconst_1        
    //   11   19:ldc1            #52  <String "-R <index1,index2-index4,...>">
    //   12   21:invokespecial   #55  <Method void Option(String, String, int, String)>
    //   13   24:invokevirtual   #59  <Method void Vector.addElement(Object)>
        newVector.addElement(new Option("\tInvert matching sense (i.e. only keep specified columns)", "V", 0, "-V"));
    //   14   27:aload_1         
    //   15   28:new             #46  <Class Option>
    //   16   31:dup             
    //   17   32:ldc1            #61  <String "\tInvert matching sense (i.e. only keep specified columns)">
    //   18   34:ldc1            #63  <String "V">
    //   19   36:iconst_0        
    //   20   37:ldc1            #65  <String "-V">
    //   21   39:invokespecial   #55  <Method void Option(String, String, int, String)>
    //   22   42:invokevirtual   #59  <Method void Vector.addElement(Object)>
        return newVector.elements();
    //   23   45:aload_1         
    //   24   46:invokevirtual   #68  <Method Enumeration Vector.elements()>
    //   25   49:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        String deleteList = Utils.getOption('R', options);
    //    0    0:bipush          82
    //    1    2:aload_1         
    //    2    3:invokestatic    #81  <Method String Utils.getOption(char, String[])>
    //    3    6:astore_2        
        if(deleteList.length() != 0)
    //*   4    7:aload_2         
    //*   5    8:invokevirtual   #87  <Method int String.length()>
    //*   6   11:ifeq            19
            setAttributeIndices(deleteList);
    //    7   14:aload_0         
    //    8   15:aload_2         
    //    9   16:invokevirtual   #91  <Method void setAttributeIndices(String)>
        setInvertSelection(Utils.getFlag('V', options));
    //   10   19:aload_0         
    //   11   20:bipush          86
    //   12   22:aload_1         
    //   13   23:invokestatic    #95  <Method boolean Utils.getFlag(char, String[])>
    //   14   26:invokevirtual   #98  <Method void setInvertSelection(boolean)>
        if(getInputFormat() != null)
    //*  15   29:aload_0         
    //*  16   30:invokevirtual   #102 <Method Instances getInputFormat()>
    //*  17   33:ifnull          45
            setInputFormat(getInputFormat());
    //   18   36:aload_0         
    //   19   37:aload_0         
    //   20   38:invokevirtual   #102 <Method Instances getInputFormat()>
    //   21   41:invokevirtual   #106 <Method boolean setInputFormat(Instances)>
    //   22   44:pop             
    //   23   45:return          
    }

    public String[] getOptions()
    {
        String options[] = new String[3];
    //    0    0:iconst_3        
    //    1    1:anewarray       String[]
    //    2    4:astore_1        
        int current = 0;
    //    3    5:iconst_0        
    //    4    6:istore_2        
        if(getInvertSelection())
    //*   5    7:aload_0         
    //*   6    8:invokevirtual   #116 <Method boolean getInvertSelection()>
    //*   7   11:ifeq            22
            options[current++] = "-V";
    //    8   14:aload_1         
    //    9   15:iload_2         
    //   10   16:iinc            2  1
    //   11   19:ldc1            #65  <String "-V">
    //   12   21:aastore         
        if(!getAttributeIndices().equals(""))
    //*  13   22:aload_0         
    //*  14   23:invokevirtual   #120 <Method String getAttributeIndices()>
    //*  15   26:ldc1            #122 <String "">
    //*  16   28:invokevirtual   #126 <Method boolean String.equals(Object)>
    //*  17   31:ifne            63
        {
            options[current++] = "-R";
    //   18   34:aload_1         
    //   19   35:iload_2         
    //   20   36:iinc            2  1
    //   21   39:ldc1            #128 <String "-R">
    //   22   41:aastore         
            options[current++] = getAttributeIndices();
    //   23   42:aload_1         
    //   24   43:iload_2         
    //   25   44:iinc            2  1
    //   26   47:aload_0         
    //   27   48:invokevirtual   #120 <Method String getAttributeIndices()>
    //   28   51:aastore         
        }
    //*  29   52:goto            63
        while(current < options.length) 
            options[current++] = "";
    //   30   55:aload_1         
    //   31   56:iload_2         
    //   32   57:iinc            2  1
    //   33   60:ldc1            #122 <String "">
    //   34   62:aastore         
    //   35   63:iload_2         
    //   36   64:aload_1         
    //   37   65:arraylength     
    //   38   66:icmplt          55
        return options;
    //   39   69:aload_1         
    //   40   70:areturn         
    }

    public Capabilities getCapabilities()
    {
        Capabilities result = super.getCapabilities();
    //    0    0:aload_0         
    //    1    1:invokespecial   #134 <Method Capabilities Filter.getCapabilities()>
    //    2    4:astore_1        
        result.disableAll();
    //    3    5:aload_1         
    //    4    6:invokevirtual   #139 <Method void Capabilities.disableAll()>
        result.enableAllAttributes();
    //    5    9:aload_1         
    //    6   10:invokevirtual   #142 <Method void Capabilities.enableAllAttributes()>
        result.enable(rm.core.Capabilities.Capability.MISSING_VALUES);
    //    7   13:aload_1         
    //    8   14:getstatic       #148 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_VALUES>
    //    9   17:invokevirtual   #152 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enableAllClasses();
    //   10   20:aload_1         
    //   11   21:invokevirtual   #155 <Method void Capabilities.enableAllClasses()>
        result.enable(rm.core.Capabilities.Capability.MISSING_CLASS_VALUES);
    //   12   24:aload_1         
    //   13   25:getstatic       #158 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.MISSING_CLASS_VALUES>
    //   14   28:invokevirtual   #152 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        result.enable(rm.core.Capabilities.Capability.NO_CLASS);
    //   15   31:aload_1         
    //   16   32:getstatic       #161 <Field rm.core.Capabilities$Capability rm.core.Capabilities$Capability.NO_CLASS>
    //   17   35:invokevirtual   #152 <Method void Capabilities.enable(rm.core.Capabilities$Capability)>
        return result;
    //   18   38:aload_1         
    //   19   39:areturn         
    }

    public boolean setInputFormat(Instances instanceInfo)
        throws Exception
    {
        super.setInputFormat(instanceInfo);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #164 <Method boolean Filter.setInputFormat(Instances)>
    //    3    5:pop             
        m_SelectCols.setUpper(instanceInfo.numAttributes() - 1);
    //    4    6:aload_0         
    //    5    7:getfield        #29  <Field Range m_SelectCols>
    //    6   10:aload_1         
    //    7   11:invokevirtual   #169 <Method int Instances.numAttributes()>
    //    8   14:iconst_1        
    //    9   15:isub            
    //   10   16:invokevirtual   #172 <Method void Range.setUpper(int)>
        FastVector attributes = new FastVector();
    //   11   19:new             #174 <Class FastVector>
    //   12   22:dup             
    //   13   23:invokespecial   #175 <Method void FastVector()>
    //   14   26:astore_2        
        int outputClass = -1;
    //   15   27:iconst_m1       
    //   16   28:istore_3        
        m_SelectedAttributes = m_SelectCols.getSelection();
    //   17   29:aload_0         
    //   18   30:aload_0         
    //   19   31:getfield        #29  <Field Range m_SelectCols>
    //   20   34:invokevirtual   #179 <Method int[] Range.getSelection()>
    //   21   37:putfield        #181 <Field int[] m_SelectedAttributes>
        for(int i = 0; i < m_SelectedAttributes.length; i++)
    //*  22   40:iconst_0        
    //*  23   41:istore          4
    //*  24   43:goto            92
        {
            int current = m_SelectedAttributes[i];
    //   25   46:aload_0         
    //   26   47:getfield        #181 <Field int[] m_SelectedAttributes>
    //   27   50:iload           4
    //   28   52:iaload          
    //   29   53:istore          5
            if(instanceInfo.classIndex() == current)
    //*  30   55:aload_1         
    //*  31   56:invokevirtual   #184 <Method int Instances.classIndex()>
    //*  32   59:iload           5
    //*  33   61:icmpne          69
                outputClass = attributes.size();
    //   34   64:aload_2         
    //   35   65:invokevirtual   #187 <Method int FastVector.size()>
    //   36   68:istore_3        
            Attribute keep = (Attribute)instanceInfo.attribute(current).copy();
    //   37   69:aload_1         
    //   38   70:iload           5
    //   39   72:invokevirtual   #191 <Method Attribute Instances.attribute(int)>
    //   40   75:invokevirtual   #197 <Method Object Attribute.copy()>
    //   41   78:checkcast       #193 <Class Attribute>
    //   42   81:astore          6
            attributes.addElement(keep);
    //   43   83:aload_2         
    //   44   84:aload           6
    //   45   86:invokevirtual   #198 <Method void FastVector.addElement(Object)>
        }

    //   46   89:iinc            4  1
    //   47   92:iload           4
    //   48   94:aload_0         
    //   49   95:getfield        #181 <Field int[] m_SelectedAttributes>
    //   50   98:arraylength     
    //   51   99:icmplt          46
        initInputLocators(instanceInfo, m_SelectedAttributes);
    //   52  102:aload_0         
    //   53  103:aload_1         
    //   54  104:aload_0         
    //   55  105:getfield        #181 <Field int[] m_SelectedAttributes>
    //   56  108:invokevirtual   #202 <Method void initInputLocators(Instances, int[])>
        Instances outputFormat = new Instances(instanceInfo.relationName(), attributes, 0);
    //   57  111:new             #166 <Class Instances>
    //   58  114:dup             
    //   59  115:aload_1         
    //   60  116:invokevirtual   #205 <Method String Instances.relationName()>
    //   61  119:aload_2         
    //   62  120:iconst_0        
    //   63  121:invokespecial   #208 <Method void Instances(String, FastVector, int)>
    //   64  124:astore          4
        outputFormat.setClassIndex(outputClass);
    //   65  126:aload           4
    //   66  128:iload_3         
    //   67  129:invokevirtual   #211 <Method void Instances.setClassIndex(int)>
        setOutputFormat(outputFormat);
    //   68  132:aload_0         
    //   69  133:aload           4
    //   70  135:invokevirtual   #215 <Method void setOutputFormat(Instances)>
        return true;
    //   71  138:iconst_1        
    //   72  139:ireturn         
    }

    public boolean input(Instance instance)
    {
        if(getInputFormat() == null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #102 <Method Instances getInputFormat()>
    //*   2    4:ifnonnull       17
            throw new IllegalStateException("No input instance format defined");
    //    3    7:new             #228 <Class IllegalStateException>
    //    4   10:dup             
    //    5   11:ldc1            #230 <String "No input instance format defined">
    //    6   13:invokespecial   #232 <Method void IllegalStateException(String)>
    //    7   16:athrow          
        if(m_NewBatch)
    //*   8   17:aload_0         
    //*   9   18:getfield        #236 <Field boolean m_NewBatch>
    //*  10   21:ifeq            33
        {
            resetQueue();
    //   11   24:aload_0         
    //   12   25:invokevirtual   #239 <Method void resetQueue()>
            m_NewBatch = false;
    //   13   28:aload_0         
    //   14   29:iconst_0        
    //   15   30:putfield        #236 <Field boolean m_NewBatch>
        }
        if(getOutputFormat().numAttributes() == 0)
    //*  16   33:aload_0         
    //*  17   34:invokevirtual   #242 <Method Instances getOutputFormat()>
    //*  18   37:invokevirtual   #169 <Method int Instances.numAttributes()>
    //*  19   40:ifne            45
            return false;
    //   20   43:iconst_0        
    //   21   44:ireturn         
        double vals[] = new double[getOutputFormat().numAttributes()];
    //   22   45:aload_0         
    //   23   46:invokevirtual   #242 <Method Instances getOutputFormat()>
    //   24   49:invokevirtual   #169 <Method int Instances.numAttributes()>
    //   25   52:newarray        double[]
    //   26   54:astore_2        
        for(int i = 0; i < m_SelectedAttributes.length; i++)
    //*  27   55:iconst_0        
    //*  28   56:istore_3        
    //*  29   57:goto            80
        {
            int current = m_SelectedAttributes[i];
    //   30   60:aload_0         
    //   31   61:getfield        #181 <Field int[] m_SelectedAttributes>
    //   32   64:iload_3         
    //   33   65:iaload          
    //   34   66:istore          4
            vals[i] = instance.value(current);
    //   35   68:aload_2         
    //   36   69:iload_3         
    //   37   70:aload_1         
    //   38   71:iload           4
    //   39   73:invokevirtual   #248 <Method double Instance.value(int)>
    //   40   76:dastore         
        }

    //   41   77:iinc            3  1
    //   42   80:iload_3         
    //   43   81:aload_0         
    //   44   82:getfield        #181 <Field int[] m_SelectedAttributes>
    //   45   85:arraylength     
    //   46   86:icmplt          60
        Instance inst = null;
    //   47   89:aconst_null     
    //   48   90:astore_3        
        if(instance instanceof SparseInstance)
    //*  49   91:aload_1         
    //*  50   92:instanceof      #250 <Class SparseInstance>
    //*  51   95:ifeq            114
            inst = new SparseInstance(instance.weight(), vals);
    //   52   98:new             #250 <Class SparseInstance>
    //   53  101:dup             
    //   54  102:aload_1         
    //   55  103:invokevirtual   #254 <Method double Instance.weight()>
    //   56  106:aload_2         
    //   57  107:invokespecial   #257 <Method void SparseInstance(double, double[])>
    //   58  110:astore_3        
        else
    //*  59  111:goto            127
            inst = new Instance(instance.weight(), vals);
    //   60  114:new             #244 <Class Instance>
    //   61  117:dup             
    //   62  118:aload_1         
    //   63  119:invokevirtual   #254 <Method double Instance.weight()>
    //   64  122:aload_2         
    //   65  123:invokespecial   #258 <Method void Instance(double, double[])>
    //   66  126:astore_3        
        inst.setDataset(getOutputFormat());
    //   67  127:aload_3         
    //   68  128:aload_0         
    //   69  129:invokevirtual   #242 <Method Instances getOutputFormat()>
    //   70  132:invokevirtual   #261 <Method void Instance.setDataset(Instances)>
        copyValues(inst, false, instance.dataset(), getOutputFormat());
    //   71  135:aload_0         
    //   72  136:aload_3         
    //   73  137:iconst_0        
    //   74  138:aload_1         
    //   75  139:invokevirtual   #264 <Method Instances Instance.dataset()>
    //   76  142:aload_0         
    //   77  143:invokevirtual   #242 <Method Instances getOutputFormat()>
    //   78  146:invokevirtual   #268 <Method void copyValues(Instance, boolean, Instances, Instances)>
        inst.setDataset(getOutputFormat());
    //   79  149:aload_3         
    //   80  150:aload_0         
    //   81  151:invokevirtual   #242 <Method Instances getOutputFormat()>
    //   82  154:invokevirtual   #261 <Method void Instance.setDataset(Instances)>
        push(inst);
    //   83  157:aload_0         
    //   84  158:aload_3         
    //   85  159:invokevirtual   #272 <Method void push(Instance)>
        return true;
    //   86  162:iconst_1        
    //   87  163:ireturn         
    }

    public String globalInfo()
    {
        return "A filter that removes a range of attributes from the dataset.";
    //    0    0:ldc2            #280 <String "A filter that removes a range of attributes from the dataset.">
    //    1    3:areturn         
    }

    public String invertSelectionTipText()
    {
        return "Determines whether action is to select or delete. If set to true, only the specified attributes will be kept; If set to false, specified attributes will be deleted.";
    //    0    0:ldc2            #283 <String "Determines whether action is to select or delete. If set to true, only the specified attributes will be kept; If set to false, specified attributes will be deleted.">
    //    1    3:areturn         
    }

    public boolean getInvertSelection()
    {
        return !m_SelectCols.getInvert();
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field Range m_SelectCols>
    //    2    4:invokevirtual   #286 <Method boolean Range.getInvert()>
    //    3    7:ifeq            14
    //    4   10:iconst_0        
    //    5   11:goto            15
    //    6   14:iconst_1        
    //    7   15:ireturn         
    }

    public void setInvertSelection(boolean invert)
    {
        m_SelectCols.setInvert(!invert);
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field Range m_SelectCols>
    //    2    4:iload_1         
    //    3    5:ifeq            12
    //    4    8:iconst_0        
    //    5    9:goto            13
    //    6   12:iconst_1        
    //    7   13:invokevirtual   #33  <Method void Range.setInvert(boolean)>
    //    8   16:return          
    }

    public String attributeIndicesTipText()
    {
        return "Specify range of attributes to act on. This is a comma separated list of attribute indices, with \"first\" and \"last\" valid values. Specify an inclusive range with \"-\". E.g: \"first-3,5,6-10,last\".";
    //    0    0:ldc2            #290 <String "Specify range of attributes to act on. This is a comma separated list of attribute indices, with \"first\" and \"last\" valid values. Specify an inclusive range with \"-\". E.g: \"first-3,5,6-10,last\".">
    //    1    3:areturn         
    }

    public String getAttributeIndices()
    {
        return m_SelectCols.getRanges();
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field Range m_SelectCols>
    //    2    4:invokevirtual   #293 <Method String Range.getRanges()>
    //    3    7:areturn         
    }

    public void setAttributeIndices(String rangeList)
    {
        m_SelectCols.setRanges(rangeList);
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field Range m_SelectCols>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #296 <Method void Range.setRanges(String)>
    //    4    8:return          
    }

    public void setAttributeIndicesArray(int attributes[])
    {
        setAttributeIndices(Range.indicesToRangeList(attributes));
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokestatic    #303 <Method String Range.indicesToRangeList(int[])>
    //    3    5:invokevirtual   #91  <Method void setAttributeIndices(String)>
    //    4    8:return          
    }

    public String getRevision()
    {
        return RevisionUtils.extract("$Revision: 6130 $");
    //    0    0:ldc2            #306 <String "$Revision: 6130 $">
    //    1    3:invokestatic    #312 <Method String RevisionUtils.extract(String)>
    //    2    6:areturn         
    }

    public static void main(String argv[])
    {
        Filter.runFilter(new Remove(), argv);
    //    0    0:new             #2   <Class Remove>
    //    1    3:dup             
    //    2    4:invokespecial   #314 <Method void Remove()>
    //    3    7:aload_0         
    //    4    8:invokestatic    #318 <Method void Filter.runFilter(Filter, String[])>
    //    5   11:return          
    }

    static final long serialVersionUID = 0x458bd8c08ed6109fL;
    protected Range m_SelectCols;
    protected int m_SelectedAttributes[];
}

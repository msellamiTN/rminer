// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   CSVLoader.java

package rm.core.converters;

import java.io.*;
import java.util.*;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            AbstractFileLoader, BatchConverter, ConverterUtils

public class CSVLoader extends AbstractFileLoader
    implements BatchConverter, OptionHandler
{

    public CSVLoader()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #40  <Method void AbstractFileLoader()>
        m_NominalAttributes = new Range();
    //    2    4:aload_0         
    //    3    5:new             #42  <Class Range>
    //    4    8:dup             
    //    5    9:invokespecial   #43  <Method void Range()>
    //    6   12:putfield        #45  <Field Range m_NominalAttributes>
        m_StringAttributes = new Range();
    //    7   15:aload_0         
    //    8   16:new             #42  <Class Range>
    //    9   19:dup             
    //   10   20:invokespecial   #43  <Method void Range()>
    //   11   23:putfield        #47  <Field Range m_StringAttributes>
        m_MissingValue = "?";
    //   12   26:aload_0         
    //   13   27:ldc1            #49  <String "?">
    //   14   29:putfield        #51  <Field String m_MissingValue>
        setRetrieval(0);
    //   15   32:aload_0         
    //   16   33:iconst_0        
    //   17   34:invokevirtual   #55  <Method void setRetrieval(int)>
    //   18   37:return          
    }

    public String getFileExtension()
    {
        return FILE_EXTENSION;
    //    0    0:getstatic       #35  <Field String FILE_EXTENSION>
    //    1    3:areturn         
    }

    public String getFileDescription()
    {
        return "CSV data files";
    //    0    0:ldc1            #62  <String "CSV data files">
    //    1    2:areturn         
    }

    public String[] getFileExtensions()
    {
        return (new String[] {
            getFileExtension()
        });
    //    0    0:iconst_1        
    //    1    1:anewarray       String[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:aload_0         
    //    5    7:invokevirtual   #68  <Method String getFileExtension()>
    //    6   10:aastore         
    //    7   11:areturn         
    }

    public String globalInfo()
    {
        return "Reads a source that is in comma separated or tab separated format. Assumes that the first row in the file determines the number of and names of the attributes.";
    //    0    0:ldc1            #71  <String "Reads a source that is in comma separated or tab separated format. Assumes that the first row in the file determines the number of and names of the attributes.">
    //    1    2:areturn         
    }

    public Enumeration listOptions()
    {
        Vector result = new Vector();
    //    0    0:new             #75  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #76  <Method void Vector()>
    //    3    7:astore_1        
        result.addElement(new Option("\tThe range of attributes to force type to be NOMINAL.\n\t'first' and 'last' are accepted as well.\n\tExamples: \"first-last\", \"1,4,5-27,50-last\"\n\t(default: -none-)", "N", 1, "-N <range>"));
    //    4    8:aload_1         
    //    5    9:new             #78  <Class Option>
    //    6   12:dup             
    //    7   13:ldc1            #80  <String "\tThe range of attributes to force type to be NOMINAL.\n\t'first' and 'last' are accepted as well.\n\tExamples: \"first-last\", \"1,4,5-27,50-last\"\n\t(default: -none-)">
    //    8   15:ldc1            #82  <String "N">
    //    9   17:iconst_1        
    //   10   18:ldc1            #84  <String "-N <range>">
    //   11   20:invokespecial   #87  <Method void Option(String, String, int, String)>
    //   12   23:invokevirtual   #91  <Method void Vector.addElement(Object)>
        result.addElement(new Option("\tThe range of attribute to force type to be STRING.\n\t'first' and 'last' are accepted as well.\n\tExamples: \"first-last\", \"1,4,5-27,50-last\"\n\t(default: -none-)", "S", 1, "-S <range>"));
    //   13   26:aload_1         
    //   14   27:new             #78  <Class Option>
    //   15   30:dup             
    //   16   31:ldc1            #93  <String "\tThe range of attribute to force type to be STRING.\n\t'first' and 'last' are accepted as well.\n\tExamples: \"first-last\", \"1,4,5-27,50-last\"\n\t(default: -none-)">
    //   17   33:ldc1            #95  <String "S">
    //   18   35:iconst_1        
    //   19   36:ldc1            #97  <String "-S <range>">
    //   20   38:invokespecial   #87  <Method void Option(String, String, int, String)>
    //   21   41:invokevirtual   #91  <Method void Vector.addElement(Object)>
        result.addElement(new Option("\tThe string representing a missing value.\n\t(default: ?)", "M", 1, "-M <str>"));
    //   22   44:aload_1         
    //   23   45:new             #78  <Class Option>
    //   24   48:dup             
    //   25   49:ldc1            #99  <String "\tThe string representing a missing value.\n\t(default: ?)">
    //   26   51:ldc1            #101 <String "M">
    //   27   53:iconst_1        
    //   28   54:ldc1            #103 <String "-M <str>">
    //   29   56:invokespecial   #87  <Method void Option(String, String, int, String)>
    //   30   59:invokevirtual   #91  <Method void Vector.addElement(Object)>
        return result.elements();
    //   31   62:aload_1         
    //   32   63:invokevirtual   #106 <Method Enumeration Vector.elements()>
    //   33   66:areturn         
    }

    public void setOptions(String options[])
        throws Exception
    {
        String tmpStr = Utils.getOption('N', options);
    //    0    0:bipush          78
    //    1    2:aload_1         
    //    2    3:invokestatic    #119 <Method String Utils.getOption(char, String[])>
    //    3    6:astore_2        
        if(tmpStr.length() != 0)
    //*   4    7:aload_2         
    //*   5    8:invokevirtual   #123 <Method int String.length()>
    //*   6   11:ifeq            22
            setNominalAttributes(tmpStr);
    //    7   14:aload_0         
    //    8   15:aload_2         
    //    9   16:invokevirtual   #127 <Method void setNominalAttributes(String)>
        else
    //*  10   19:goto            28
            setNominalAttributes("");
    //   11   22:aload_0         
    //   12   23:ldc1            #129 <String "">
    //   13   25:invokevirtual   #127 <Method void setNominalAttributes(String)>
        tmpStr = Utils.getOption('S', options);
    //   14   28:bipush          83
    //   15   30:aload_1         
    //   16   31:invokestatic    #119 <Method String Utils.getOption(char, String[])>
    //   17   34:astore_2        
        if(tmpStr.length() != 0)
    //*  18   35:aload_2         
    //*  19   36:invokevirtual   #123 <Method int String.length()>
    //*  20   39:ifeq            50
            setStringAttributes(tmpStr);
    //   21   42:aload_0         
    //   22   43:aload_2         
    //   23   44:invokevirtual   #132 <Method void setStringAttributes(String)>
        else
    //*  24   47:goto            56
            setStringAttributes("");
    //   25   50:aload_0         
    //   26   51:ldc1            #129 <String "">
    //   27   53:invokevirtual   #132 <Method void setStringAttributes(String)>
        tmpStr = Utils.getOption('M', options);
    //   28   56:bipush          77
    //   29   58:aload_1         
    //   30   59:invokestatic    #119 <Method String Utils.getOption(char, String[])>
    //   31   62:astore_2        
        if(tmpStr.length() != 0)
    //*  32   63:aload_2         
    //*  33   64:invokevirtual   #123 <Method int String.length()>
    //*  34   67:ifeq            78
            setMissingValue(tmpStr);
    //   35   70:aload_0         
    //   36   71:aload_2         
    //   37   72:invokevirtual   #135 <Method void setMissingValue(String)>
        else
    //*  38   75:goto            84
            setMissingValue("?");
    //   39   78:aload_0         
    //   40   79:ldc1            #49  <String "?">
    //   41   81:invokevirtual   #135 <Method void setMissingValue(String)>
    //   42   84:return          
    }

    public String[] getOptions()
    {
        Vector result = new Vector();
    //    0    0:new             #75  <Class Vector>
    //    1    3:dup             
    //    2    4:invokespecial   #76  <Method void Vector()>
    //    3    7:astore_1        
        if(getNominalAttributes().length() > 0)
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #142 <Method String getNominalAttributes()>
    //*   6   12:invokevirtual   #123 <Method int String.length()>
    //*   7   15:ifle            34
        {
            result.add("-N");
    //    8   18:aload_1         
    //    9   19:ldc1            #144 <String "-N">
    //   10   21:invokevirtual   #148 <Method boolean Vector.add(Object)>
    //   11   24:pop             
            result.add(getNominalAttributes());
    //   12   25:aload_1         
    //   13   26:aload_0         
    //   14   27:invokevirtual   #142 <Method String getNominalAttributes()>
    //   15   30:invokevirtual   #148 <Method boolean Vector.add(Object)>
    //   16   33:pop             
        }
        if(getStringAttributes().length() > 0)
    //*  17   34:aload_0         
    //*  18   35:invokevirtual   #151 <Method String getStringAttributes()>
    //*  19   38:invokevirtual   #123 <Method int String.length()>
    //*  20   41:ifle            60
        {
            result.add("-S");
    //   21   44:aload_1         
    //   22   45:ldc1            #153 <String "-S">
    //   23   47:invokevirtual   #148 <Method boolean Vector.add(Object)>
    //   24   50:pop             
            result.add(getStringAttributes());
    //   25   51:aload_1         
    //   26   52:aload_0         
    //   27   53:invokevirtual   #151 <Method String getStringAttributes()>
    //   28   56:invokevirtual   #148 <Method boolean Vector.add(Object)>
    //   29   59:pop             
        }
        result.add("-M");
    //   30   60:aload_1         
    //   31   61:ldc1            #155 <String "-M">
    //   32   63:invokevirtual   #148 <Method boolean Vector.add(Object)>
    //   33   66:pop             
        result.add(getMissingValue());
    //   34   67:aload_1         
    //   35   68:aload_0         
    //   36   69:invokevirtual   #158 <Method String getMissingValue()>
    //   37   72:invokevirtual   #148 <Method boolean Vector.add(Object)>
    //   38   75:pop             
        return (String[])result.toArray(new String[result.size()]);
    //   39   76:aload_1         
    //   40   77:aload_1         
    //   41   78:invokevirtual   #161 <Method int Vector.size()>
    //   42   81:anewarray       String[]
    //   43   84:invokevirtual   #165 <Method Object[] Vector.toArray(Object[])>
    //   44   87:checkcast       #166 <Class String[]>
    //   45   90:areturn         
    }

    public void setNominalAttributes(String value)
    {
        m_NominalAttributes.setRanges(value);
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field Range m_NominalAttributes>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #171 <Method void Range.setRanges(String)>
    //    4    8:return          
    }

    public String getNominalAttributes()
    {
        return m_NominalAttributes.getRanges();
    //    0    0:aload_0         
    //    1    1:getfield        #45  <Field Range m_NominalAttributes>
    //    2    4:invokevirtual   #175 <Method String Range.getRanges()>
    //    3    7:areturn         
    }

    public String nominalAttributesTipText()
    {
        return "The range of attributes to force to be of type NOMINAL, example ranges: 'first-last', '1,4,7-14,50-last'.";
    //    0    0:ldc1            #178 <String "The range of attributes to force to be of type NOMINAL, example ranges: 'first-last', '1,4,7-14,50-last'.">
    //    1    2:areturn         
    }

    public void setStringAttributes(String value)
    {
        m_StringAttributes.setRanges(value);
    //    0    0:aload_0         
    //    1    1:getfield        #47  <Field Range m_StringAttributes>
    //    2    4:aload_1         
    //    3    5:invokevirtual   #171 <Method void Range.setRanges(String)>
    //    4    8:return          
    }

    public String getStringAttributes()
    {
        return m_StringAttributes.getRanges();
    //    0    0:aload_0         
    //    1    1:getfield        #47  <Field Range m_StringAttributes>
    //    2    4:invokevirtual   #175 <Method String Range.getRanges()>
    //    3    7:areturn         
    }

    public String stringAttributesTipText()
    {
        return "The range of attributes to force to be of type STRING, example ranges: 'first-last', '1,4,7-14,50-last'.";
    //    0    0:ldc1            #181 <String "The range of attributes to force to be of type STRING, example ranges: 'first-last', '1,4,7-14,50-last'.">
    //    1    2:areturn         
    }

    public void setMissingValue(String value)
    {
        m_MissingValue = value;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #51  <Field String m_MissingValue>
    //    3    5:return          
    }

    public String getMissingValue()
    {
        return m_MissingValue;
    //    0    0:aload_0         
    //    1    1:getfield        #51  <Field String m_MissingValue>
    //    2    4:areturn         
    }

    public String missingValueTipText()
    {
        return "The placeholder for missing values, default is '?'.";
    //    0    0:ldc1            #184 <String "The placeholder for missing values, default is '?'.">
    //    1    2:areturn         
    }

    public void setSource(InputStream input)
        throws IOException
    {
        m_structure = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #192 <Field Instances m_structure>
        m_sourceFile = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #196 <Field File m_sourceFile>
        m_File = null;
    //    6   10:aload_0         
    //    7   11:aconst_null     
    //    8   12:putfield        #199 <Field String m_File>
        m_FirstCheck = true;
    //    9   15:aload_0         
    //   10   16:iconst_1        
    //   11   17:putfield        #201 <Field boolean m_FirstCheck>
        m_sourceReader = new BufferedReader(new InputStreamReader(input));
    //   12   20:aload_0         
    //   13   21:new             #203 <Class BufferedReader>
    //   14   24:dup             
    //   15   25:new             #205 <Class InputStreamReader>
    //   16   28:dup             
    //   17   29:aload_1         
    //   18   30:invokespecial   #207 <Method void InputStreamReader(InputStream)>
    //   19   33:invokespecial   #210 <Method void BufferedReader(java.io.Reader)>
    //   20   36:putfield        #212 <Field BufferedReader m_sourceReader>
    //   21   39:return          
    }

    public void setSource(File file)
        throws IOException
    {
        super.setSource(file);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #217 <Method void AbstractFileLoader.setSource(File)>
    //    3    5:return          
    }

    public Instances getStructure()
        throws IOException
    {
        if(m_sourceFile == null && m_sourceReader == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #196 <Field File m_sourceFile>
    //*   2    4:ifnonnull       24
    //*   3    7:aload_0         
    //*   4    8:getfield        #212 <Field BufferedReader m_sourceReader>
    //*   5   11:ifnonnull       24
            throw new IOException("No source has been specified");
    //    6   14:new             #188 <Class IOException>
    //    7   17:dup             
    //    8   18:ldc1            #222 <String "No source has been specified">
    //    9   20:invokespecial   #224 <Method void IOException(String)>
    //   10   23:athrow          
        if(m_structure == null)
    //*  11   24:aload_0         
    //*  12   25:getfield        #192 <Field Instances m_structure>
    //*  13   28:ifnonnull       66
            try
            {
                m_st = new StreamTokenizer(m_sourceReader);
    //   14   31:aload_0         
    //   15   32:new             #226 <Class StreamTokenizer>
    //   16   35:dup             
    //   17   36:aload_0         
    //   18   37:getfield        #212 <Field BufferedReader m_sourceReader>
    //   19   40:invokespecial   #227 <Method void StreamTokenizer(java.io.Reader)>
    //   20   43:putfield        #229 <Field StreamTokenizer m_st>
                initTokenizer(m_st);
    //   21   46:aload_0         
    //   22   47:aload_0         
    //   23   48:getfield        #229 <Field StreamTokenizer m_st>
    //   24   51:invokespecial   #233 <Method void initTokenizer(StreamTokenizer)>
                readStructure(m_st);
    //   25   54:aload_0         
    //   26   55:aload_0         
    //   27   56:getfield        #229 <Field StreamTokenizer m_st>
    //   28   59:invokespecial   #236 <Method void readStructure(StreamTokenizer)>
            }
    //*  29   62:goto            66
            catch(FileNotFoundException filenotfoundexception) { }
    //   30   65:astore_1        
        return m_structure;
    //   31   66:aload_0         
    //   32   67:getfield        #192 <Field Instances m_structure>
    //   33   70:areturn         
    }

    private void readStructure(StreamTokenizer st)
        throws IOException
    {
        readHeader(st);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #241 <Method void readHeader(StreamTokenizer)>
    //    3    5:return          
    }

    public Instances getDataSet()
        throws IOException
    {
        if(m_sourceFile == null && m_sourceReader == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #196 <Field File m_sourceFile>
    //*   2    4:ifnonnull       24
    //*   3    7:aload_0         
    //*   4    8:getfield        #212 <Field BufferedReader m_sourceReader>
    //*   5   11:ifnonnull       24
            throw new IOException("No source has been specified");
    //    6   14:new             #188 <Class IOException>
    //    7   17:dup             
    //    8   18:ldc1            #222 <String "No source has been specified">
    //    9   20:invokespecial   #224 <Method void IOException(String)>
    //   10   23:athrow          
        if(m_structure == null)
    //*  11   24:aload_0         
    //*  12   25:getfield        #192 <Field Instances m_structure>
    //*  13   28:ifnonnull       36
            getStructure();
    //   14   31:aload_0         
    //   15   32:invokevirtual   #245 <Method Instances getStructure()>
    //   16   35:pop             
        if(m_st == null)
    //*  17   36:aload_0         
    //*  18   37:getfield        #229 <Field StreamTokenizer m_st>
    //*  19   40:ifnonnull       66
        {
            m_st = new StreamTokenizer(m_sourceReader);
    //   20   43:aload_0         
    //   21   44:new             #226 <Class StreamTokenizer>
    //   22   47:dup             
    //   23   48:aload_0         
    //   24   49:getfield        #212 <Field BufferedReader m_sourceReader>
    //   25   52:invokespecial   #227 <Method void StreamTokenizer(java.io.Reader)>
    //   26   55:putfield        #229 <Field StreamTokenizer m_st>
            initTokenizer(m_st);
    //   27   58:aload_0         
    //   28   59:aload_0         
    //   29   60:getfield        #229 <Field StreamTokenizer m_st>
    //   30   63:invokespecial   #233 <Method void initTokenizer(StreamTokenizer)>
        }
        m_st.ordinaryChar(44);
    //   31   66:aload_0         
    //   32   67:getfield        #229 <Field StreamTokenizer m_st>
    //   33   70:bipush          44
    //   34   72:invokevirtual   #248 <Method void StreamTokenizer.ordinaryChar(int)>
        m_st.ordinaryChar(9);
    //   35   75:aload_0         
    //   36   76:getfield        #229 <Field StreamTokenizer m_st>
    //   37   79:bipush          9
    //   38   81:invokevirtual   #248 <Method void StreamTokenizer.ordinaryChar(int)>
        m_cumulativeStructure = new FastVector(m_structure.numAttributes());
    //   39   84:aload_0         
    //   40   85:new             #250 <Class FastVector>
    //   41   88:dup             
    //   42   89:aload_0         
    //   43   90:getfield        #192 <Field Instances m_structure>
    //   44   93:invokevirtual   #255 <Method int Instances.numAttributes()>
    //   45   96:invokespecial   #257 <Method void FastVector(int)>
    //   46   99:putfield        #259 <Field FastVector m_cumulativeStructure>
        for(int i = 0; i < m_structure.numAttributes(); i++)
    //*  47  102:iconst_0        
    //*  48  103:istore_1        
    //*  49  104:goto            124
            m_cumulativeStructure.addElement(new Hashtable());
    //   50  107:aload_0         
    //   51  108:getfield        #259 <Field FastVector m_cumulativeStructure>
    //   52  111:new             #261 <Class Hashtable>
    //   53  114:dup             
    //   54  115:invokespecial   #262 <Method void Hashtable()>
    //   55  118:invokevirtual   #263 <Method void FastVector.addElement(Object)>

    //   56  121:iinc            1  1
    //   57  124:iload_1         
    //   58  125:aload_0         
    //   59  126:getfield        #192 <Field Instances m_structure>
    //   60  129:invokevirtual   #255 <Method int Instances.numAttributes()>
    //   61  132:icmplt          107
        m_cumulativeInstances = new FastVector();
    //   62  135:aload_0         
    //   63  136:new             #250 <Class FastVector>
    //   64  139:dup             
    //   65  140:invokespecial   #264 <Method void FastVector()>
    //   66  143:putfield        #266 <Field FastVector m_cumulativeInstances>
    //*  67  146:goto            157
        FastVector current;
        while((current = getInstance(m_st)) != null) 
            m_cumulativeInstances.addElement(current);
    //   68  149:aload_0         
    //   69  150:getfield        #266 <Field FastVector m_cumulativeInstances>
    //   70  153:aload_1         
    //   71  154:invokevirtual   #263 <Method void FastVector.addElement(Object)>
    //   72  157:aload_0         
    //   73  158:aload_0         
    //   74  159:getfield        #229 <Field StreamTokenizer m_st>
    //   75  162:invokespecial   #270 <Method FastVector getInstance(StreamTokenizer)>
    //   76  165:dup             
    //   77  166:astore_1        
    //   78  167:ifnonnull       149
        FastVector atts = new FastVector(m_structure.numAttributes());
    //   79  170:new             #250 <Class FastVector>
    //   80  173:dup             
    //   81  174:aload_0         
    //   82  175:getfield        #192 <Field Instances m_structure>
    //   83  178:invokevirtual   #255 <Method int Instances.numAttributes()>
    //   84  181:invokespecial   #257 <Method void FastVector(int)>
    //   85  184:astore_2        
        for(int i = 0; i < m_structure.numAttributes(); i++)
    //*  86  185:iconst_0        
    //*  87  186:istore_3        
    //*  88  187:goto            434
        {
            String attname = m_structure.attribute(i).name();
    //   89  190:aload_0         
    //   90  191:getfield        #192 <Field Instances m_structure>
    //   91  194:iload_3         
    //   92  195:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //   93  198:invokevirtual   #279 <Method String Attribute.name()>
    //   94  201:astore          4
            Hashtable tempHash = (Hashtable)m_cumulativeStructure.elementAt(i);
    //   95  203:aload_0         
    //   96  204:getfield        #259 <Field FastVector m_cumulativeStructure>
    //   97  207:iload_3         
    //   98  208:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //   99  211:checkcast       #261 <Class Hashtable>
    //  100  214:astore          5
            if(tempHash.size() == 0)
    //* 101  216:aload           5
    //* 102  218:invokevirtual   #284 <Method int Hashtable.size()>
    //* 103  221:ifne            240
                atts.addElement(new Attribute(attname));
    //  104  224:aload_2         
    //  105  225:new             #276 <Class Attribute>
    //  106  228:dup             
    //  107  229:aload           4
    //  108  231:invokespecial   #285 <Method void Attribute(String)>
    //  109  234:invokevirtual   #263 <Method void FastVector.addElement(Object)>
            else
    //* 110  237:goto            431
            if(m_StringAttributes.isInRange(i))
    //* 111  240:aload_0         
    //* 112  241:getfield        #47  <Field Range m_StringAttributes>
    //* 113  244:iload_3         
    //* 114  245:invokevirtual   #289 <Method boolean Range.isInRange(int)>
    //* 115  248:ifeq            268
            {
                atts.addElement(new Attribute(attname, null));
    //  116  251:aload_2         
    //  117  252:new             #276 <Class Attribute>
    //  118  255:dup             
    //  119  256:aload           4
    //  120  258:aconst_null     
    //  121  259:invokespecial   #292 <Method void Attribute(String, FastVector)>
    //  122  262:invokevirtual   #263 <Method void FastVector.addElement(Object)>
            } else
    //* 123  265:goto            431
            {
                FastVector values = new FastVector(tempHash.size());
    //  124  268:new             #250 <Class FastVector>
    //  125  271:dup             
    //  126  272:aload           5
    //  127  274:invokevirtual   #284 <Method int Hashtable.size()>
    //  128  277:invokespecial   #257 <Method void FastVector(int)>
    //  129  280:astore          6
                for(int z = 0; z < tempHash.size(); z++)
    //* 130  282:iconst_0        
    //* 131  283:istore          7
    //* 132  285:goto            299
                    values.addElement("dummy");
    //  133  288:aload           6
    //  134  290:ldc2            #294 <String "dummy">
    //  135  293:invokevirtual   #263 <Method void FastVector.addElement(Object)>

    //  136  296:iinc            7  1
    //  137  299:iload           7
    //  138  301:aload           5
    //  139  303:invokevirtual   #284 <Method int Hashtable.size()>
    //  140  306:icmplt          288
                int index;
                String s;
                for(Enumeration e = tempHash.keys(); e.hasMoreElements(); values.setElementAt(new String(s), index))
    //* 141  309:aload           5
    //* 142  311:invokevirtual   #297 <Method Enumeration Hashtable.keys()>
    //* 143  314:astore          7
    //* 144  316:goto            406
                {
                    Object ob = e.nextElement();
    //  145  319:aload           7
    //  146  321:invokeinterface #303 <Method Object Enumeration.nextElement()>
    //  147  326:astore          8
                    index = ((Integer)(Integer)tempHash.get(ob)).intValue();
    //  148  328:aload           5
    //  149  330:aload           8
    //  150  332:invokevirtual   #307 <Method Object Hashtable.get(Object)>
    //  151  335:checkcast       #309 <Class Integer>
    //  152  338:checkcast       #309 <Class Integer>
    //  153  341:invokevirtual   #312 <Method int Integer.intValue()>
    //  154  344:istore          9
                    s = ob.toString();
    //  155  346:aload           8
    //  156  348:invokevirtual   #317 <Method String Object.toString()>
    //  157  351:astore          10
                    if(s.startsWith("'") || s.startsWith("\""))
    //* 158  353:aload           10
    //* 159  355:ldc2            #319 <String "'">
    //* 160  358:invokevirtual   #323 <Method boolean String.startsWith(String)>
    //* 161  361:ifne            375
    //* 162  364:aload           10
    //* 163  366:ldc2            #325 <String "\"">
    //* 164  369:invokevirtual   #323 <Method boolean String.startsWith(String)>
    //* 165  372:ifeq            390
                        s = s.substring(1, s.length() - 1);
    //  166  375:aload           10
    //  167  377:iconst_1        
    //  168  378:aload           10
    //  169  380:invokevirtual   #123 <Method int String.length()>
    //  170  383:iconst_1        
    //  171  384:isub            
    //  172  385:invokevirtual   #329 <Method String String.substring(int, int)>
    //  173  388:astore          10
                }

    //  174  390:aload           6
    //  175  392:new             #66  <Class String>
    //  176  395:dup             
    //  177  396:aload           10
    //  178  398:invokespecial   #330 <Method void String(String)>
    //  179  401:iload           9
    //  180  403:invokevirtual   #334 <Method void FastVector.setElementAt(Object, int)>
    //  181  406:aload           7
    //  182  408:invokeinterface #338 <Method boolean Enumeration.hasMoreElements()>
    //  183  413:ifne            319
                atts.addElement(new Attribute(attname, values));
    //  184  416:aload_2         
    //  185  417:new             #276 <Class Attribute>
    //  186  420:dup             
    //  187  421:aload           4
    //  188  423:aload           6
    //  189  425:invokespecial   #292 <Method void Attribute(String, FastVector)>
    //  190  428:invokevirtual   #263 <Method void FastVector.addElement(Object)>
            }
        }

    //  191  431:iinc            3  1
    //  192  434:iload_3         
    //  193  435:aload_0         
    //  194  436:getfield        #192 <Field Instances m_structure>
    //  195  439:invokevirtual   #255 <Method int Instances.numAttributes()>
    //  196  442:icmplt          190
        String relationName;
        if(m_sourceFile != null)
    //* 197  445:aload_0         
    //* 198  446:getfield        #196 <Field File m_sourceFile>
    //* 199  449:ifnull          471
            relationName = m_sourceFile.getName().replaceAll("\\.[cC][sS][vV]$", "");
    //  200  452:aload_0         
    //  201  453:getfield        #196 <Field File m_sourceFile>
    //  202  456:invokevirtual   #343 <Method String File.getName()>
    //  203  459:ldc2            #345 <String "\\.[cC][sS][vV]$">
    //  204  462:ldc1            #129 <String "">
    //  205  464:invokevirtual   #349 <Method String String.replaceAll(String, String)>
    //  206  467:astore_3        
        else
    //* 207  468:goto            475
            relationName = "stream";
    //  208  471:ldc2            #351 <String "stream">
    //  209  474:astore_3        
        Instances dataSet = new Instances(relationName, atts, m_cumulativeInstances.size());
    //  210  475:new             #252 <Class Instances>
    //  211  478:dup             
    //  212  479:aload_3         
    //  213  480:aload_2         
    //  214  481:aload_0         
    //  215  482:getfield        #266 <Field FastVector m_cumulativeInstances>
    //  216  485:invokevirtual   #352 <Method int FastVector.size()>
    //  217  488:invokespecial   #355 <Method void Instances(String, FastVector, int)>
    //  218  491:astore          4
        for(int i = 0; i < m_cumulativeInstances.size(); i++)
    //* 219  493:iconst_0        
    //* 220  494:istore          5
    //* 221  496:goto            845
        {
            current = (FastVector)m_cumulativeInstances.elementAt(i);
    //  222  499:aload_0         
    //  223  500:getfield        #266 <Field FastVector m_cumulativeInstances>
    //  224  503:iload           5
    //  225  505:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //  226  508:checkcast       #250 <Class FastVector>
    //  227  511:astore_1        
            double vals[] = new double[dataSet.numAttributes()];
    //  228  512:aload           4
    //  229  514:invokevirtual   #255 <Method int Instances.numAttributes()>
    //  230  517:newarray        double[]
    //  231  519:astore          6
            for(int j = 0; j < current.size(); j++)
    //* 232  521:iconst_0        
    //* 233  522:istore          7
    //* 234  524:goto            818
            {
                Object cval = current.elementAt(j);
    //  235  527:aload_1         
    //  236  528:iload           7
    //  237  530:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //  238  533:astore          8
                if(cval instanceof String)
    //* 239  535:aload           8
    //* 240  537:instanceof      #66  <Class String>
    //* 241  540:ifeq            699
                {
                    if(((String)cval).compareTo(m_MissingValue) == 0)
    //* 242  543:aload           8
    //* 243  545:checkcast       #66  <Class String>
    //* 244  548:aload_0         
    //* 245  549:getfield        #51  <Field String m_MissingValue>
    //* 246  552:invokevirtual   #359 <Method int String.compareTo(String)>
    //* 247  555:ifne            569
                        vals[j] = Instance.missingValue();
    //  248  558:aload           6
    //  249  560:iload           7
    //  250  562:invokestatic    #365 <Method double Instance.missingValue()>
    //  251  565:dastore         
                    else
    //* 252  566:goto            815
                    if(dataSet.attribute(j).isString())
    //* 253  569:aload           4
    //* 254  571:iload           7
    //* 255  573:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //* 256  576:invokevirtual   #368 <Method boolean Attribute.isString()>
    //* 257  579:ifeq            606
                        vals[j] = dataSet.attribute(j).addStringValue((String)cval);
    //  258  582:aload           6
    //  259  584:iload           7
    //  260  586:aload           4
    //  261  588:iload           7
    //  262  590:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //  263  593:aload           8
    //  264  595:checkcast       #66  <Class String>
    //  265  598:invokevirtual   #371 <Method int Attribute.addStringValue(String)>
    //  266  601:i2d             
    //  267  602:dastore         
                    else
    //* 268  603:goto            815
                    if(dataSet.attribute(j).isNominal())
    //* 269  606:aload           4
    //* 270  608:iload           7
    //* 271  610:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //* 272  613:invokevirtual   #374 <Method boolean Attribute.isNominal()>
    //* 273  616:ifeq            662
                    {
                        Hashtable lookup = (Hashtable)m_cumulativeStructure.elementAt(j);
    //  274  619:aload_0         
    //  275  620:getfield        #259 <Field FastVector m_cumulativeStructure>
    //  276  623:iload           7
    //  277  625:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //  278  628:checkcast       #261 <Class Hashtable>
    //  279  631:astore          9
                        int index = ((Integer)(Integer)lookup.get(cval)).intValue();
    //  280  633:aload           9
    //  281  635:aload           8
    //  282  637:invokevirtual   #307 <Method Object Hashtable.get(Object)>
    //  283  640:checkcast       #309 <Class Integer>
    //  284  643:checkcast       #309 <Class Integer>
    //  285  646:invokevirtual   #312 <Method int Integer.intValue()>
    //  286  649:istore          10
                        vals[j] = index;
    //  287  651:aload           6
    //  288  653:iload           7
    //  289  655:iload           10
    //  290  657:i2d             
    //  291  658:dastore         
                    } else
    //* 292  659:goto            815
                    {
                        throw new IllegalStateException((new StringBuilder("Wrong attribute type at position ")).append(i + 1).append("!!!").toString());
    //  293  662:new             #376 <Class IllegalStateException>
    //  294  665:dup             
    //  295  666:new             #378 <Class StringBuilder>
    //  296  669:dup             
    //  297  670:ldc2            #380 <String "Wrong attribute type at position ">
    //  298  673:invokespecial   #381 <Method void StringBuilder(String)>
    //  299  676:iload           5
    //  300  678:iconst_1        
    //  301  679:iadd            
    //  302  680:invokevirtual   #385 <Method StringBuilder StringBuilder.append(int)>
    //  303  683:ldc2            #387 <String "!!!">
    //  304  686:invokevirtual   #390 <Method StringBuilder StringBuilder.append(String)>
    //  305  689:invokevirtual   #391 <Method String StringBuilder.toString()>
    //  306  692:invokespecial   #392 <Method void IllegalStateException(String)>
    //  307  695:athrow          
                    }
                } else
    //* 308  696:goto            815
                if(dataSet.attribute(j).isNominal())
    //* 309  699:aload           4
    //* 310  701:iload           7
    //* 311  703:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //* 312  706:invokevirtual   #374 <Method boolean Attribute.isNominal()>
    //* 313  709:ifeq            755
                {
                    Hashtable lookup = (Hashtable)m_cumulativeStructure.elementAt(j);
    //  314  712:aload_0         
    //  315  713:getfield        #259 <Field FastVector m_cumulativeStructure>
    //  316  716:iload           7
    //  317  718:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //  318  721:checkcast       #261 <Class Hashtable>
    //  319  724:astore          9
                    int index = ((Integer)(Integer)lookup.get(cval)).intValue();
    //  320  726:aload           9
    //  321  728:aload           8
    //  322  730:invokevirtual   #307 <Method Object Hashtable.get(Object)>
    //  323  733:checkcast       #309 <Class Integer>
    //  324  736:checkcast       #309 <Class Integer>
    //  325  739:invokevirtual   #312 <Method int Integer.intValue()>
    //  326  742:istore          10
                    vals[j] = index;
    //  327  744:aload           6
    //  328  746:iload           7
    //  329  748:iload           10
    //  330  750:i2d             
    //  331  751:dastore         
                } else
    //* 332  752:goto            815
                if(dataSet.attribute(j).isString())
    //* 333  755:aload           4
    //* 334  757:iload           7
    //* 335  759:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //* 336  762:invokevirtual   #368 <Method boolean Attribute.isString()>
    //* 337  765:ifeq            802
                    vals[j] = dataSet.attribute(j).addStringValue((new StringBuilder()).append(cval).toString());
    //  338  768:aload           6
    //  339  770:iload           7
    //  340  772:aload           4
    //  341  774:iload           7
    //  342  776:invokevirtual   #274 <Method Attribute Instances.attribute(int)>
    //  343  779:new             #378 <Class StringBuilder>
    //  344  782:dup             
    //  345  783:invokespecial   #393 <Method void StringBuilder()>
    //  346  786:aload           8
    //  347  788:invokevirtual   #396 <Method StringBuilder StringBuilder.append(Object)>
    //  348  791:invokevirtual   #391 <Method String StringBuilder.toString()>
    //  349  794:invokevirtual   #371 <Method int Attribute.addStringValue(String)>
    //  350  797:i2d             
    //  351  798:dastore         
                else
    //* 352  799:goto            815
                    vals[j] = ((Double)cval).doubleValue();
    //  353  802:aload           6
    //  354  804:iload           7
    //  355  806:aload           8
    //  356  808:checkcast       #398 <Class Double>
    //  357  811:invokevirtual   #401 <Method double Double.doubleValue()>
    //  358  814:dastore         
            }

    //  359  815:iinc            7  1
    //  360  818:iload           7
    //  361  820:aload_1         
    //  362  821:invokevirtual   #352 <Method int FastVector.size()>
    //  363  824:icmplt          527
            dataSet.add(new Instance(1.0D, vals));
    //  364  827:aload           4
    //  365  829:new             #361 <Class Instance>
    //  366  832:dup             
    //  367  833:dconst_1        
    //  368  834:aload           6
    //  369  836:invokespecial   #404 <Method void Instance(double, double[])>
    //  370  839:invokevirtual   #407 <Method void Instances.add(Instance)>
        }

    //  371  842:iinc            5  1
    //  372  845:iload           5
    //  373  847:aload_0         
    //  374  848:getfield        #266 <Field FastVector m_cumulativeInstances>
    //  375  851:invokevirtual   #352 <Method int FastVector.size()>
    //  376  854:icmplt          499
        m_structure = new Instances(dataSet, 0);
    //  377  857:aload_0         
    //  378  858:new             #252 <Class Instances>
    //  379  861:dup             
    //  380  862:aload           4
    //  381  864:iconst_0        
    //  382  865:invokespecial   #410 <Method void Instances(Instances, int)>
    //  383  868:putfield        #192 <Field Instances m_structure>
        setRetrieval(1);
    //  384  871:aload_0         
    //  385  872:iconst_1        
    //  386  873:invokevirtual   #55  <Method void setRetrieval(int)>
        m_cumulativeStructure = null;
    //  387  876:aload_0         
    //  388  877:aconst_null     
    //  389  878:putfield        #259 <Field FastVector m_cumulativeStructure>
        m_sourceReader.close();
    //  390  881:aload_0         
    //  391  882:getfield        #212 <Field BufferedReader m_sourceReader>
    //  392  885:invokevirtual   #413 <Method void BufferedReader.close()>
        return dataSet;
    //  393  888:aload           4
    //  394  890:areturn         
    }

    public Instance getNextInstance(Instances structure)
        throws IOException
    {
        throw new IOException("CSVLoader can't read data sets incrementally.");
    //    0    0:new             #188 <Class IOException>
    //    1    3:dup             
    //    2    4:ldc2            #439 <String "CSVLoader can't read data sets incrementally.">
    //    3    7:invokespecial   #224 <Method void IOException(String)>
    //    4   10:athrow          
    }

    private FastVector getInstance(StreamTokenizer tokenizer)
        throws IOException
    {
        FastVector current = new FastVector();
    //    0    0:new             #250 <Class FastVector>
    //    1    3:dup             
    //    2    4:invokespecial   #264 <Method void FastVector()>
    //    3    7:astore_2        
        ConverterUtils.getFirstToken(tokenizer);
    //    4    8:aload_1         
    //    5    9:invokestatic    #445 <Method void ConverterUtils.getFirstToken(StreamTokenizer)>
        if(tokenizer.ttype == -1)
    //*   6   12:aload_1         
    //*   7   13:getfield        #448 <Field int StreamTokenizer.ttype>
    //*   8   16:iconst_m1       
    //*   9   17:icmpne          22
            return null;
    //   10   20:aconst_null     
    //   11   21:areturn         
        for(boolean first = true; tokenizer.ttype != 10 && tokenizer.ttype != -1; first = false)
    //*  12   22:iconst_1        
    //*  13   23:istore_3        
    //*  14   24:goto            167
        {
            if(!first)
    //*  15   27:iload_3         
    //*  16   28:ifne            35
                ConverterUtils.getToken(tokenizer);
    //   17   31:aload_1         
    //   18   32:invokestatic    #451 <Method void ConverterUtils.getToken(StreamTokenizer)>
            boolean wasSep;
            if(tokenizer.ttype == 44 || tokenizer.ttype == 9 || tokenizer.ttype == 10)
    //*  19   35:aload_1         
    //*  20   36:getfield        #448 <Field int StreamTokenizer.ttype>
    //*  21   39:bipush          44
    //*  22   41:icmpeq          62
    //*  23   44:aload_1         
    //*  24   45:getfield        #448 <Field int StreamTokenizer.ttype>
    //*  25   48:bipush          9
    //*  26   50:icmpeq          62
    //*  27   53:aload_1         
    //*  28   54:getfield        #448 <Field int StreamTokenizer.ttype>
    //*  29   57:bipush          10
    //*  30   59:icmpne          76
            {
                current.addElement(m_MissingValue);
    //   31   62:aload_2         
    //   32   63:aload_0         
    //   33   64:getfield        #51  <Field String m_MissingValue>
    //   34   67:invokevirtual   #263 <Method void FastVector.addElement(Object)>
                wasSep = true;
    //   35   70:iconst_1        
    //   36   71:istore          4
            } else
    //*  37   73:goto            156
            {
                wasSep = false;
    //   38   76:iconst_0        
    //   39   77:istore          4
                if(tokenizer.sval.equals(m_MissingValue))
    //*  40   79:aload_1         
    //*  41   80:getfield        #454 <Field String StreamTokenizer.sval>
    //*  42   83:aload_0         
    //*  43   84:getfield        #51  <Field String m_MissingValue>
    //*  44   87:invokevirtual   #457 <Method boolean String.equals(Object)>
    //*  45   90:ifeq            111
                    current.addElement(new String(m_MissingValue));
    //   46   93:aload_2         
    //   47   94:new             #66  <Class String>
    //   48   97:dup             
    //   49   98:aload_0         
    //   50   99:getfield        #51  <Field String m_MissingValue>
    //   51  102:invokespecial   #330 <Method void String(String)>
    //   52  105:invokevirtual   #263 <Method void FastVector.addElement(Object)>
                else
    //*  53  108:goto            156
                    try
                    {
                        double val = Double.valueOf(tokenizer.sval).doubleValue();
    //   54  111:aload_1         
    //   55  112:getfield        #454 <Field String StreamTokenizer.sval>
    //   56  115:invokestatic    #461 <Method Double Double.valueOf(String)>
    //   57  118:invokevirtual   #401 <Method double Double.doubleValue()>
    //   58  121:dstore          5
                        current.addElement(new Double(val));
    //   59  123:aload_2         
    //   60  124:new             #398 <Class Double>
    //   61  127:dup             
    //   62  128:dload           5
    //   63  130:invokespecial   #464 <Method void Double(double)>
    //   64  133:invokevirtual   #263 <Method void FastVector.addElement(Object)>
                    }
    //*  65  136:goto            156
                    catch(NumberFormatException e)
    //*  66  139:astore          5
                    {
                        current.addElement(new String(tokenizer.sval));
    //   67  141:aload_2         
    //   68  142:new             #66  <Class String>
    //   69  145:dup             
    //   70  146:aload_1         
    //   71  147:getfield        #454 <Field String StreamTokenizer.sval>
    //   72  150:invokespecial   #330 <Method void String(String)>
    //   73  153:invokevirtual   #263 <Method void FastVector.addElement(Object)>
                    }
            }
            if(!wasSep)
    //*  74  156:iload           4
    //*  75  158:ifne            165
                ConverterUtils.getToken(tokenizer);
    //   76  161:aload_1         
    //   77  162:invokestatic    #451 <Method void ConverterUtils.getToken(StreamTokenizer)>
        }

    //   78  165:iconst_0        
    //   79  166:istore_3        
    //   80  167:aload_1         
    //   81  168:getfield        #448 <Field int StreamTokenizer.ttype>
    //   82  171:bipush          10
    //   83  173:icmpeq          184
    //   84  176:aload_1         
    //   85  177:getfield        #448 <Field int StreamTokenizer.ttype>
    //   86  180:iconst_m1       
    //   87  181:icmpne          27
        if(current.size() != m_structure.numAttributes())
    //*  88  184:aload_2         
    //*  89  185:invokevirtual   #352 <Method int FastVector.size()>
    //*  90  188:aload_0         
    //*  91  189:getfield        #192 <Field Instances m_structure>
    //*  92  192:invokevirtual   #255 <Method int Instances.numAttributes()>
    //*  93  195:icmpeq          238
            ConverterUtils.errms(tokenizer, (new StringBuilder("wrong number of values. Read ")).append(current.size()).append(", expected ").append(m_structure.numAttributes()).toString());
    //   94  198:aload_1         
    //   95  199:new             #378 <Class StringBuilder>
    //   96  202:dup             
    //   97  203:ldc2            #466 <String "wrong number of values. Read ">
    //   98  206:invokespecial   #381 <Method void StringBuilder(String)>
    //   99  209:aload_2         
    //  100  210:invokevirtual   #352 <Method int FastVector.size()>
    //  101  213:invokevirtual   #385 <Method StringBuilder StringBuilder.append(int)>
    //  102  216:ldc2            #468 <String ", expected ">
    //  103  219:invokevirtual   #390 <Method StringBuilder StringBuilder.append(String)>
    //  104  222:aload_0         
    //  105  223:getfield        #192 <Field Instances m_structure>
    //  106  226:invokevirtual   #255 <Method int Instances.numAttributes()>
    //  107  229:invokevirtual   #385 <Method StringBuilder StringBuilder.append(int)>
    //  108  232:invokevirtual   #391 <Method String StringBuilder.toString()>
    //  109  235:invokestatic    #472 <Method void ConverterUtils.errms(StreamTokenizer, String)>
        try
        {
            checkStructure(current);
    //  110  238:aload_0         
    //  111  239:aload_2         
    //  112  240:invokespecial   #476 <Method void checkStructure(FastVector)>
        }
    //* 113  243:goto            253
        catch(Exception ex)
    //* 114  246:astore          5
        {
            ex.printStackTrace();
    //  115  248:aload           5
    //  116  250:invokevirtual   #479 <Method void Exception.printStackTrace()>
        }
        return current;
    //  117  253:aload_2         
    //  118  254:areturn         
    }

    private void checkStructure(FastVector current)
        throws Exception
    {
        if(current == null)
    //*   0    0:aload_1         
    //*   1    1:ifnonnull       15
            throw new Exception("current shouldn't be null in checkStructure");
    //    2    4:new             #113 <Class Exception>
    //    3    7:dup             
    //    4    8:ldc2            #491 <String "current shouldn't be null in checkStructure">
    //    5   11:invokespecial   #492 <Method void Exception(String)>
    //    6   14:athrow          
        if(m_FirstCheck)
    //*   7   15:aload_0         
    //*   8   16:getfield        #201 <Field boolean m_FirstCheck>
    //*   9   19:ifeq            53
        {
            m_NominalAttributes.setUpper(current.size() - 1);
    //   10   22:aload_0         
    //   11   23:getfield        #45  <Field Range m_NominalAttributes>
    //   12   26:aload_1         
    //   13   27:invokevirtual   #352 <Method int FastVector.size()>
    //   14   30:iconst_1        
    //   15   31:isub            
    //   16   32:invokevirtual   #495 <Method void Range.setUpper(int)>
            m_StringAttributes.setUpper(current.size() - 1);
    //   17   35:aload_0         
    //   18   36:getfield        #47  <Field Range m_StringAttributes>
    //   19   39:aload_1         
    //   20   40:invokevirtual   #352 <Method int FastVector.size()>
    //   21   43:iconst_1        
    //   22   44:isub            
    //   23   45:invokevirtual   #495 <Method void Range.setUpper(int)>
            m_FirstCheck = false;
    //   24   48:aload_0         
    //   25   49:iconst_0        
    //   26   50:putfield        #201 <Field boolean m_FirstCheck>
        }
        for(int i = 0; i < current.size(); i++)
    //*  27   53:iconst_0        
    //*  28   54:istore_2        
    //*  29   55:goto            347
        {
            Object ob = current.elementAt(i);
    //   30   58:aload_1         
    //   31   59:iload_2         
    //   32   60:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //   33   63:astore_3        
            if((ob instanceof String) || m_NominalAttributes.isInRange(i) || m_StringAttributes.isInRange(i))
    //*  34   64:aload_3         
    //*  35   65:instanceof      #66  <Class String>
    //*  36   68:ifne            93
    //*  37   71:aload_0         
    //*  38   72:getfield        #45  <Field Range m_NominalAttributes>
    //*  39   75:iload_2         
    //*  40   76:invokevirtual   #289 <Method boolean Range.isInRange(int)>
    //*  41   79:ifne            93
    //*  42   82:aload_0         
    //*  43   83:getfield        #47  <Field Range m_StringAttributes>
    //*  44   86:iload_2         
    //*  45   87:invokevirtual   #289 <Method boolean Range.isInRange(int)>
    //*  46   90:ifeq            257
            {
                if(ob.toString().compareTo(m_MissingValue) != 0)
    //*  47   93:aload_3         
    //*  48   94:invokevirtual   #317 <Method String Object.toString()>
    //*  49   97:aload_0         
    //*  50   98:getfield        #51  <Field String m_MissingValue>
    //*  51  101:invokevirtual   #359 <Method int String.compareTo(String)>
    //*  52  104:ifeq            344
                {
                    Hashtable tempHash = (Hashtable)m_cumulativeStructure.elementAt(i);
    //   53  107:aload_0         
    //   54  108:getfield        #259 <Field FastVector m_cumulativeStructure>
    //   55  111:iload_2         
    //   56  112:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //   57  115:checkcast       #261 <Class Hashtable>
    //   58  118:astore          4
                    if(!tempHash.containsKey(ob))
    //*  59  120:aload           4
    //*  60  122:aload_3         
    //*  61  123:invokevirtual   #498 <Method boolean Hashtable.containsKey(Object)>
    //*  62  126:ifne            344
                    {
                        if(tempHash.size() == 0)
    //*  63  129:aload           4
    //*  64  131:invokevirtual   #284 <Method int Hashtable.size()>
    //*  65  134:ifne            231
                        {
                            for(int j = 0; j < m_cumulativeInstances.size(); j++)
    //*  66  137:iconst_0        
    //*  67  138:istore          5
    //*  68  140:goto            219
                            {
                                FastVector tempUpdate = (FastVector)m_cumulativeInstances.elementAt(j);
    //   69  143:aload_0         
    //   70  144:getfield        #266 <Field FastVector m_cumulativeInstances>
    //   71  147:iload           5
    //   72  149:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //   73  152:checkcast       #250 <Class FastVector>
    //   74  155:astore          6
                                Object tempO = tempUpdate.elementAt(i);
    //   75  157:aload           6
    //   76  159:iload_2         
    //   77  160:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //   78  163:astore          7
                                if(!(tempO instanceof String) && !tempHash.containsKey(tempO))
    //*  79  165:aload           7
    //*  80  167:instanceof      #66  <Class String>
    //*  81  170:ifne            216
    //*  82  173:aload           4
    //*  83  175:aload           7
    //*  84  177:invokevirtual   #498 <Method boolean Hashtable.containsKey(Object)>
    //*  85  180:ifne            216
                                    tempHash.put(new Double(((Double)tempO).doubleValue()), new Integer(tempHash.size()));
    //   86  183:aload           4
    //   87  185:new             #398 <Class Double>
    //   88  188:dup             
    //   89  189:aload           7
    //   90  191:checkcast       #398 <Class Double>
    //   91  194:invokevirtual   #401 <Method double Double.doubleValue()>
    //   92  197:invokespecial   #464 <Method void Double(double)>
    //   93  200:new             #309 <Class Integer>
    //   94  203:dup             
    //   95  204:aload           4
    //   96  206:invokevirtual   #284 <Method int Hashtable.size()>
    //   97  209:invokespecial   #499 <Method void Integer(int)>
    //   98  212:invokevirtual   #503 <Method Object Hashtable.put(Object, Object)>
    //   99  215:pop             
                            }

    //  100  216:iinc            5  1
    //  101  219:iload           5
    //  102  221:aload_0         
    //  103  222:getfield        #266 <Field FastVector m_cumulativeInstances>
    //  104  225:invokevirtual   #352 <Method int FastVector.size()>
    //  105  228:icmplt          143
                        }
                        int newIndex = tempHash.size();
    //  106  231:aload           4
    //  107  233:invokevirtual   #284 <Method int Hashtable.size()>
    //  108  236:istore          5
                        tempHash.put(ob, new Integer(newIndex));
    //  109  238:aload           4
    //  110  240:aload_3         
    //  111  241:new             #309 <Class Integer>
    //  112  244:dup             
    //  113  245:iload           5
    //  114  247:invokespecial   #499 <Method void Integer(int)>
    //  115  250:invokevirtual   #503 <Method Object Hashtable.put(Object, Object)>
    //  116  253:pop             
                    }
                }
            } else
    //* 117  254:goto            344
            if(ob instanceof Double)
    //* 118  257:aload_3         
    //* 119  258:instanceof      #398 <Class Double>
    //* 120  261:ifeq            333
            {
                Hashtable tempHash = (Hashtable)m_cumulativeStructure.elementAt(i);
    //  121  264:aload_0         
    //  122  265:getfield        #259 <Field FastVector m_cumulativeStructure>
    //  123  268:iload_2         
    //  124  269:invokevirtual   #283 <Method Object FastVector.elementAt(int)>
    //  125  272:checkcast       #261 <Class Hashtable>
    //  126  275:astore          4
                if(tempHash.size() != 0 && !tempHash.containsKey(ob))
    //* 127  277:aload           4
    //* 128  279:invokevirtual   #284 <Method int Hashtable.size()>
    //* 129  282:ifeq            344
    //* 130  285:aload           4
    //* 131  287:aload_3         
    //* 132  288:invokevirtual   #498 <Method boolean Hashtable.containsKey(Object)>
    //* 133  291:ifne            344
                {
                    int newIndex = tempHash.size();
    //  134  294:aload           4
    //  135  296:invokevirtual   #284 <Method int Hashtable.size()>
    //  136  299:istore          5
                    tempHash.put(new Double(((Double)ob).doubleValue()), new Integer(newIndex));
    //  137  301:aload           4
    //  138  303:new             #398 <Class Double>
    //  139  306:dup             
    //  140  307:aload_3         
    //  141  308:checkcast       #398 <Class Double>
    //  142  311:invokevirtual   #401 <Method double Double.doubleValue()>
    //  143  314:invokespecial   #464 <Method void Double(double)>
    //  144  317:new             #309 <Class Integer>
    //  145  320:dup             
    //  146  321:iload           5
    //  147  323:invokespecial   #499 <Method void Integer(int)>
    //  148  326:invokevirtual   #503 <Method Object Hashtable.put(Object, Object)>
    //  149  329:pop             
                }
            } else
    //* 150  330:goto            344
            {
                throw new Exception("Wrong object type in checkStructure!");
    //  151  333:new             #113 <Class Exception>
    //  152  336:dup             
    //  153  337:ldc2            #505 <String "Wrong object type in checkStructure!">
    //  154  340:invokespecial   #492 <Method void Exception(String)>
    //  155  343:athrow          
            }
        }

    //  156  344:iinc            2  1
    //  157  347:iload_2         
    //  158  348:aload_1         
    //  159  349:invokevirtual   #352 <Method int FastVector.size()>
    //  160  352:icmplt          58
    //  161  355:return          
    }

    private void readHeader(StreamTokenizer tokenizer)
        throws IOException
    {
        FastVector attribNames = new FastVector();
    //    0    0:new             #250 <Class FastVector>
    //    1    3:dup             
    //    2    4:invokespecial   #264 <Method void FastVector()>
    //    3    7:astore_2        
        ConverterUtils.getFirstToken(tokenizer);
    //    4    8:aload_1         
    //    5    9:invokestatic    #445 <Method void ConverterUtils.getFirstToken(StreamTokenizer)>
        if(tokenizer.ttype == -1)
    //*   6   12:aload_1         
    //*   7   13:getfield        #448 <Field int StreamTokenizer.ttype>
    //*   8   16:iconst_m1       
    //*   9   17:icmpne          49
            ConverterUtils.errms(tokenizer, "premature end of file");
    //   10   20:aload_1         
    //   11   21:ldc2            #510 <String "premature end of file">
    //   12   24:invokestatic    #472 <Method void ConverterUtils.errms(StreamTokenizer, String)>
    //*  13   27:goto            49
        while(tokenizer.ttype != 10) 
        {
            attribNames.addElement(new Attribute(tokenizer.sval));
    //   14   30:aload_2         
    //   15   31:new             #276 <Class Attribute>
    //   16   34:dup             
    //   17   35:aload_1         
    //   18   36:getfield        #454 <Field String StreamTokenizer.sval>
    //   19   39:invokespecial   #285 <Method void Attribute(String)>
    //   20   42:invokevirtual   #263 <Method void FastVector.addElement(Object)>
            ConverterUtils.getToken(tokenizer);
    //   21   45:aload_1         
    //   22   46:invokestatic    #451 <Method void ConverterUtils.getToken(StreamTokenizer)>
        }
    //   23   49:aload_1         
    //   24   50:getfield        #448 <Field int StreamTokenizer.ttype>
    //   25   53:bipush          10
    //   26   55:icmpne          30
        String relationName;
        if(m_sourceFile != null)
    //*  27   58:aload_0         
    //*  28   59:getfield        #196 <Field File m_sourceFile>
    //*  29   62:ifnull          84
            relationName = m_sourceFile.getName().replaceAll("\\.[cC][sS][vV]$", "");
    //   30   65:aload_0         
    //   31   66:getfield        #196 <Field File m_sourceFile>
    //   32   69:invokevirtual   #343 <Method String File.getName()>
    //   33   72:ldc2            #345 <String "\\.[cC][sS][vV]$">
    //   34   75:ldc1            #129 <String "">
    //   35   77:invokevirtual   #349 <Method String String.replaceAll(String, String)>
    //   36   80:astore_3        
        else
    //*  37   81:goto            88
            relationName = "stream";
    //   38   84:ldc2            #351 <String "stream">
    //   39   87:astore_3        
        m_structure = new Instances(relationName, attribNames, 0);
    //   40   88:aload_0         
    //   41   89:new             #252 <Class Instances>
    //   42   92:dup             
    //   43   93:aload_3         
    //   44   94:aload_2         
    //   45   95:iconst_0        
    //   46   96:invokespecial   #355 <Method void Instances(String, FastVector, int)>
    //   47   99:putfield        #192 <Field Instances m_structure>
    //   48  102:return          
    }

    private void initTokenizer(StreamTokenizer tokenizer)
    {
        tokenizer.resetSyntax();
    //    0    0:aload_1         
    //    1    1:invokevirtual   #514 <Method void StreamTokenizer.resetSyntax()>
        tokenizer.whitespaceChars(0, 31);
    //    2    4:aload_1         
    //    3    5:iconst_0        
    //    4    6:bipush          31
    //    5    8:invokevirtual   #518 <Method void StreamTokenizer.whitespaceChars(int, int)>
        tokenizer.wordChars(32, 255);
    //    6   11:aload_1         
    //    7   12:bipush          32
    //    8   14:sipush          255
    //    9   17:invokevirtual   #521 <Method void StreamTokenizer.wordChars(int, int)>
        tokenizer.whitespaceChars(44, 44);
    //   10   20:aload_1         
    //   11   21:bipush          44
    //   12   23:bipush          44
    //   13   25:invokevirtual   #518 <Method void StreamTokenizer.whitespaceChars(int, int)>
        tokenizer.whitespaceChars(9, 9);
    //   14   28:aload_1         
    //   15   29:bipush          9
    //   16   31:bipush          9
    //   17   33:invokevirtual   #518 <Method void StreamTokenizer.whitespaceChars(int, int)>
        tokenizer.commentChar(37);
    //   18   36:aload_1         
    //   19   37:bipush          37
    //   20   39:invokevirtual   #524 <Method void StreamTokenizer.commentChar(int)>
        tokenizer.quoteChar(34);
    //   21   42:aload_1         
    //   22   43:bipush          34
    //   23   45:invokevirtual   #527 <Method void StreamTokenizer.quoteChar(int)>
        tokenizer.quoteChar(39);
    //   24   48:aload_1         
    //   25   49:bipush          39
    //   26   51:invokevirtual   #527 <Method void StreamTokenizer.quoteChar(int)>
        tokenizer.eolIsSignificant(true);
    //   27   54:aload_1         
    //   28   55:iconst_1        
    //   29   56:invokevirtual   #531 <Method void StreamTokenizer.eolIsSignificant(boolean)>
    //   30   59:return          
    }

    public void reset()
        throws IOException
    {
        m_structure = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #192 <Field Instances m_structure>
        m_st = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #229 <Field StreamTokenizer m_st>
        setRetrieval(0);
    //    6   10:aload_0         
    //    7   11:iconst_0        
    //    8   12:invokevirtual   #55  <Method void setRetrieval(int)>
        if(m_File != null)
    //*   9   15:aload_0         
    //*  10   16:getfield        #199 <Field String m_File>
    //*  11   19:ifnull          37
            setFile(new File(m_File));
    //   12   22:aload_0         
    //   13   23:new             #340 <Class File>
    //   14   26:dup             
    //   15   27:aload_0         
    //   16   28:getfield        #199 <Field String m_File>
    //   17   31:invokespecial   #533 <Method void File(String)>
    //   18   34:invokevirtual   #536 <Method void setFile(File)>
    //   19   37:return          
    }

    public String getRevision()
    {
        return RevisionUtils.extract("$Revision: 6002 $");
    //    0    0:ldc2            #539 <String "$Revision: 6002 $">
    //    1    3:invokestatic    #545 <Method String RevisionUtils.extract(String)>
    //    2    6:areturn         
    }

    public static void main(String args[])
    {
        AbstractFileLoader.runFileLoader(new CSVLoader(), args);
    //    0    0:new             #2   <Class CSVLoader>
    //    1    3:dup             
    //    2    4:invokespecial   #547 <Method void CSVLoader()>
    //    3    7:aload_0         
    //    4    8:invokestatic    #551 <Method void AbstractFileLoader.runFileLoader(AbstractFileLoader, String[])>
    //    5   11:return          
    }

    static final long serialVersionUID = 0x4dd1f2969cf7f98cL;
    public static String FILE_EXTENSION = ".csv";
    protected FastVector m_cumulativeStructure;
    protected FastVector m_cumulativeInstances;
    protected transient BufferedReader m_sourceReader;
    protected transient StreamTokenizer m_st;
    protected Range m_NominalAttributes;
    protected Range m_StringAttributes;
    protected String m_MissingValue;
    protected boolean m_FirstCheck;

    static 
    {
    //    0    0:ldc1            #33  <String ".csv">
    //    1    2:putstatic       #35  <Field String FILE_EXTENSION>
    //*   2    5:return          
    }
}

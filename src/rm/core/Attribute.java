// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Attribute.java

package rm.core;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package rm.core:
//            ProtectedProperties, FastVector, SerializedObject, Instances, 
//            Utils, Instance

public class Attribute
    implements Serializable
{

    public Attribute(String attributeName)
    {
        this(attributeName, new ProtectedProperties(new Properties()));
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:new             #75  <Class ProtectedProperties>
    //    3    5:dup             
    //    4    6:new             #77  <Class Properties>
    //    5    9:dup             
    //    6   10:invokespecial   #80  <Method void Properties()>
    //    7   13:invokespecial   #83  <Method void ProtectedProperties(Properties)>
    //    8   16:invokespecial   #86  <Method void Attribute(String, ProtectedProperties)>
    //    9   19:return          
    }

    public Attribute(String attributeName, ProtectedProperties metadata)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #92  <Method void Object()>
        m_Name = attributeName;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #94  <Field String m_Name>
        m_Index = -1;
    //    5    9:aload_0         
    //    6   10:iconst_m1       
    //    7   11:putfield        #96  <Field int m_Index>
        m_Values = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #98  <Field FastVector m_Values>
        m_Hashtable = null;
    //   11   19:aload_0         
    //   12   20:aconst_null     
    //   13   21:putfield        #100 <Field Hashtable m_Hashtable>
        m_Type = 0;
    //   14   24:aload_0         
    //   15   25:iconst_0        
    //   16   26:putfield        #102 <Field int m_Type>
        setMetadata(metadata);
    //   17   29:aload_0         
    //   18   30:aload_2         
    //   19   31:invokespecial   #106 <Method void setMetadata(ProtectedProperties)>
    //   20   34:return          
    }

    public Attribute(String attributeName, String dateFormat)
    {
        this(attributeName, dateFormat, new ProtectedProperties(new Properties()));
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:new             #75  <Class ProtectedProperties>
    //    4    6:dup             
    //    5    7:new             #77  <Class Properties>
    //    6   10:dup             
    //    7   11:invokespecial   #80  <Method void Properties()>
    //    8   14:invokespecial   #83  <Method void ProtectedProperties(Properties)>
    //    9   17:invokespecial   #111 <Method void Attribute(String, String, ProtectedProperties)>
    //   10   20:return          
    }

    public Attribute(String attributeName, String dateFormat, ProtectedProperties metadata)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #92  <Method void Object()>
        m_Name = attributeName;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #94  <Field String m_Name>
        m_Index = -1;
    //    5    9:aload_0         
    //    6   10:iconst_m1       
    //    7   11:putfield        #96  <Field int m_Index>
        m_Values = null;
    //    8   14:aload_0         
    //    9   15:aconst_null     
    //   10   16:putfield        #98  <Field FastVector m_Values>
        m_Hashtable = null;
    //   11   19:aload_0         
    //   12   20:aconst_null     
    //   13   21:putfield        #100 <Field Hashtable m_Hashtable>
        m_Type = 3;
    //   14   24:aload_0         
    //   15   25:iconst_3        
    //   16   26:putfield        #102 <Field int m_Type>
        if(dateFormat != null)
    //*  17   29:aload_2         
    //*  18   30:ifnull          48
            m_DateFormat = new SimpleDateFormat(dateFormat);
    //   19   33:aload_0         
    //   20   34:new             #114 <Class SimpleDateFormat>
    //   21   37:dup             
    //   22   38:aload_2         
    //   23   39:invokespecial   #116 <Method void SimpleDateFormat(String)>
    //   24   42:putfield        #118 <Field SimpleDateFormat m_DateFormat>
        else
    //*  25   45:goto            61
            m_DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    //   26   48:aload_0         
    //   27   49:new             #114 <Class SimpleDateFormat>
    //   28   52:dup             
    //   29   53:ldc1            #120 <String "yyyy-MM-dd'T'HH:mm:ss">
    //   30   55:invokespecial   #116 <Method void SimpleDateFormat(String)>
    //   31   58:putfield        #118 <Field SimpleDateFormat m_DateFormat>
        m_DateFormat.setLenient(false);
    //   32   61:aload_0         
    //   33   62:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //   34   65:iconst_0        
    //   35   66:invokevirtual   #124 <Method void SimpleDateFormat.setLenient(boolean)>
        setMetadata(metadata);
    //   36   69:aload_0         
    //   37   70:aload_3         
    //   38   71:invokespecial   #106 <Method void setMetadata(ProtectedProperties)>
    //   39   74:return          
    }

    public Attribute(String attributeName, FastVector attributeValues)
    {
        this(attributeName, attributeValues, new ProtectedProperties(new Properties()));
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:new             #75  <Class ProtectedProperties>
    //    4    6:dup             
    //    5    7:new             #77  <Class Properties>
    //    6   10:dup             
    //    7   11:invokespecial   #80  <Method void Properties()>
    //    8   14:invokespecial   #83  <Method void ProtectedProperties(Properties)>
    //    9   17:invokespecial   #128 <Method void Attribute(String, FastVector, ProtectedProperties)>
    //   10   20:return          
    }

    public Attribute(String attributeName, FastVector attributeValues, ProtectedProperties metadata)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #92  <Method void Object()>
        m_Name = attributeName;
    //    2    4:aload_0         
    //    3    5:aload_1         
    //    4    6:putfield        #94  <Field String m_Name>
        m_Index = -1;
    //    5    9:aload_0         
    //    6   10:iconst_m1       
    //    7   11:putfield        #96  <Field int m_Index>
        if(attributeValues == null)
    //*   8   14:aload_2         
    //*   9   15:ifnonnull       48
        {
            m_Values = new FastVector();
    //   10   18:aload_0         
    //   11   19:new             #131 <Class FastVector>
    //   12   22:dup             
    //   13   23:invokespecial   #132 <Method void FastVector()>
    //   14   26:putfield        #98  <Field FastVector m_Values>
            m_Hashtable = new Hashtable();
    //   15   29:aload_0         
    //   16   30:new             #134 <Class Hashtable>
    //   17   33:dup             
    //   18   34:invokespecial   #135 <Method void Hashtable()>
    //   19   37:putfield        #100 <Field Hashtable m_Hashtable>
            m_Type = 2;
    //   20   40:aload_0         
    //   21   41:iconst_2        
    //   22   42:putfield        #102 <Field int m_Type>
        } else
    //*  23   45:goto            236
        {
            m_Values = new FastVector(attributeValues.size());
    //   24   48:aload_0         
    //   25   49:new             #131 <Class FastVector>
    //   26   52:dup             
    //   27   53:aload_2         
    //   28   54:invokevirtual   #139 <Method int FastVector.size()>
    //   29   57:invokespecial   #142 <Method void FastVector(int)>
    //   30   60:putfield        #98  <Field FastVector m_Values>
            m_Hashtable = new Hashtable(attributeValues.size());
    //   31   63:aload_0         
    //   32   64:new             #134 <Class Hashtable>
    //   33   67:dup             
    //   34   68:aload_2         
    //   35   69:invokevirtual   #139 <Method int FastVector.size()>
    //   36   72:invokespecial   #143 <Method void Hashtable(int)>
    //   37   75:putfield        #100 <Field Hashtable m_Hashtable>
            for(int i = 0; i < attributeValues.size(); i++)
    //*  38   78:iconst_0        
    //*  39   79:istore          4
    //*  40   81:goto            222
            {
                Object store = attributeValues.elementAt(i);
    //   41   84:aload_2         
    //   42   85:iload           4
    //   43   87:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //   44   90:astore          5
                if(((String)store).length() > 200)
    //*  45   92:aload           5
    //*  46   94:checkcast       #149 <Class String>
    //*  47   97:invokevirtual   #152 <Method int String.length()>
    //*  48  100:sipush          200
    //*  49  103:icmple          135
                    try
                    {
                        store = new SerializedObject(attributeValues.elementAt(i), true);
    //   50  106:new             #154 <Class SerializedObject>
    //   51  109:dup             
    //   52  110:aload_2         
    //   53  111:iload           4
    //   54  113:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //   55  116:iconst_1        
    //   56  117:invokespecial   #157 <Method void SerializedObject(Object, boolean)>
    //   57  120:astore          5
                    }
    //*  58  122:goto            135
                    catch(Exception ex)
    //*  59  125:astore          6
                    {
                        System.err.println("Couldn't compress nominal attribute value - storing uncompressed.");
    //   60  127:getstatic       #163 <Field PrintStream System.err>
    //   61  130:ldc1            #165 <String "Couldn't compress nominal attribute value - storing uncompressed.">
    //   62  132:invokevirtual   #170 <Method void PrintStream.println(String)>
                    }
                if(m_Hashtable.containsKey(store))
    //*  63  135:aload_0         
    //*  64  136:getfield        #100 <Field Hashtable m_Hashtable>
    //*  65  139:aload           5
    //*  66  141:invokevirtual   #174 <Method boolean Hashtable.containsKey(Object)>
    //*  67  144:ifeq            191
                    throw new IllegalArgumentException((new StringBuilder("A nominal attribute (")).append(attributeName).append(") cannot").append(" have duplicate labels (").append(store).append(").").toString());
    //   68  147:new             #176 <Class IllegalArgumentException>
    //   69  150:dup             
    //   70  151:new             #178 <Class StringBuilder>
    //   71  154:dup             
    //   72  155:ldc1            #180 <String "A nominal attribute (">
    //   73  157:invokespecial   #181 <Method void StringBuilder(String)>
    //   74  160:aload_1         
    //   75  161:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //   76  164:ldc1            #187 <String ") cannot">
    //   77  166:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //   78  169:ldc1            #189 <String " have duplicate labels (">
    //   79  171:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //   80  174:aload           5
    //   81  176:invokevirtual   #192 <Method StringBuilder StringBuilder.append(Object)>
    //   82  179:ldc1            #194 <String ").">
    //   83  181:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //   84  184:invokevirtual   #198 <Method String StringBuilder.toString()>
    //   85  187:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   86  190:athrow          
                m_Values.addElement(store);
    //   87  191:aload_0         
    //   88  192:getfield        #98  <Field FastVector m_Values>
    //   89  195:aload           5
    //   90  197:invokevirtual   #203 <Method void FastVector.addElement(Object)>
                m_Hashtable.put(store, new Integer(i));
    //   91  200:aload_0         
    //   92  201:getfield        #100 <Field Hashtable m_Hashtable>
    //   93  204:aload           5
    //   94  206:new             #205 <Class Integer>
    //   95  209:dup             
    //   96  210:iload           4
    //   97  212:invokespecial   #206 <Method void Integer(int)>
    //   98  215:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   99  218:pop             
            }

    //  100  219:iinc            4  1
    //  101  222:iload           4
    //  102  224:aload_2         
    //  103  225:invokevirtual   #139 <Method int FastVector.size()>
    //  104  228:icmplt          84
            m_Type = 1;
    //  105  231:aload_0         
    //  106  232:iconst_1        
    //  107  233:putfield        #102 <Field int m_Type>
        }
        setMetadata(metadata);
    //  108  236:aload_0         
    //  109  237:aload_3         
    //  110  238:invokespecial   #106 <Method void setMetadata(ProtectedProperties)>
    //  111  241:return          
    }

    public Attribute(String attributeName, Instances header)
    {
        this(attributeName, header, new ProtectedProperties(new Properties()));
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:new             #75  <Class ProtectedProperties>
    //    4    6:dup             
    //    5    7:new             #77  <Class Properties>
    //    6   10:dup             
    //    7   11:invokespecial   #80  <Method void Properties()>
    //    8   14:invokespecial   #83  <Method void ProtectedProperties(Properties)>
    //    9   17:invokespecial   #221 <Method void Attribute(String, Instances, ProtectedProperties)>
    //   10   20:return          
    }

    public Attribute(String attributeName, Instances header, ProtectedProperties metadata)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #92  <Method void Object()>
        if(header.numInstances() > 0)
    //*   2    4:aload_2         
    //*   3    5:invokevirtual   #228 <Method int Instances.numInstances()>
    //*   4    8:ifle            21
        {
            throw new IllegalArgumentException("Header for relation-valued attribute should not contain any instances");
    //    5   11:new             #176 <Class IllegalArgumentException>
    //    6   14:dup             
    //    7   15:ldc1            #230 <String "Header for relation-valued attribute should not contain any instances">
    //    8   17:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //    9   20:athrow          
        } else
        {
            m_Name = attributeName;
    //   10   21:aload_0         
    //   11   22:aload_1         
    //   12   23:putfield        #94  <Field String m_Name>
            m_Index = -1;
    //   13   26:aload_0         
    //   14   27:iconst_m1       
    //   15   28:putfield        #96  <Field int m_Index>
            m_Values = new FastVector();
    //   16   31:aload_0         
    //   17   32:new             #131 <Class FastVector>
    //   18   35:dup             
    //   19   36:invokespecial   #132 <Method void FastVector()>
    //   20   39:putfield        #98  <Field FastVector m_Values>
            m_Hashtable = new Hashtable();
    //   21   42:aload_0         
    //   22   43:new             #134 <Class Hashtable>
    //   23   46:dup             
    //   24   47:invokespecial   #135 <Method void Hashtable()>
    //   25   50:putfield        #100 <Field Hashtable m_Hashtable>
            m_Type = 4;
    //   26   53:aload_0         
    //   27   54:iconst_4        
    //   28   55:putfield        #102 <Field int m_Type>
            setMetadata(metadata);
    //   29   58:aload_0         
    //   30   59:aload_3         
    //   31   60:invokespecial   #106 <Method void setMetadata(ProtectedProperties)>
            return;
    //   32   63:return          
        }
    }

    public Object[] toArray()
    {
        Object newObjects[] = m_Values.toArray();
    //    0    0:aload_0         
    //    1    1:getfield        #98  <Field FastVector m_Values>
    //    2    4:invokevirtual   #234 <Method Object[] FastVector.toArray()>
    //    3    7:astore_1        
        return newObjects;
    //    4    8:aload_1         
    //    5    9:areturn         
    }

    public Object copy()
    {
        Attribute copy = new Attribute(m_Name);
    //    0    0:new             #2   <Class Attribute>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #94  <Field String m_Name>
    //    4    8:invokespecial   #239 <Method void Attribute(String)>
    //    5   11:astore_1        
        copy.m_Index = m_Index;
    //    6   12:aload_1         
    //    7   13:aload_0         
    //    8   14:getfield        #96  <Field int m_Index>
    //    9   17:putfield        #96  <Field int m_Index>
        copy.m_Type = m_Type;
    //   10   20:aload_1         
    //   11   21:aload_0         
    //   12   22:getfield        #102 <Field int m_Type>
    //   13   25:putfield        #102 <Field int m_Type>
        copy.m_Values = m_Values;
    //   14   28:aload_1         
    //   15   29:aload_0         
    //   16   30:getfield        #98  <Field FastVector m_Values>
    //   17   33:putfield        #98  <Field FastVector m_Values>
        copy.m_Hashtable = m_Hashtable;
    //   18   36:aload_1         
    //   19   37:aload_0         
    //   20   38:getfield        #100 <Field Hashtable m_Hashtable>
    //   21   41:putfield        #100 <Field Hashtable m_Hashtable>
        copy.m_DateFormat = m_DateFormat;
    //   22   44:aload_1         
    //   23   45:aload_0         
    //   24   46:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //   25   49:putfield        #118 <Field SimpleDateFormat m_DateFormat>
        copy.setMetadata(m_Metadata);
    //   26   52:aload_1         
    //   27   53:aload_0         
    //   28   54:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   29   57:invokespecial   #106 <Method void setMetadata(ProtectedProperties)>
        return copy;
    //   30   60:aload_1         
    //   31   61:areturn         
    }

    public final Enumeration enumerateValues()
    {
        if(isNominal() || isString())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #247 <Method boolean isNominal()>
    //*   2    4:ifne            14
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #250 <Method boolean isString()>
    //*   5   11:ifeq            32
        {
            final Enumeration ee = m_Values.elements();
    //    6   14:aload_0         
    //    7   15:getfield        #98  <Field FastVector m_Values>
    //    8   18:invokevirtual   #253 <Method Enumeration FastVector.elements()>
    //    9   21:astore_1        
            return new Enumeration() {

                public boolean hasMoreElements()
                {
                    return ee.hasMoreElements();
                //    0    0:aload_0         
                //    1    1:getfield        #17  <Field Enumeration val$ee>
                //    2    4:invokeinterface #28  <Method boolean Enumeration.hasMoreElements()>
                //    3    9:ireturn         
                }

                public Object nextElement()
                {
                    Object oo = ee.nextElement();
                //    0    0:aload_0         
                //    1    1:getfield        #17  <Field Enumeration val$ee>
                //    2    4:invokeinterface #32  <Method Object Enumeration.nextElement()>
                //    3    9:astore_1        
                    if(oo instanceof SerializedObject)
                //*   4   10:aload_1         
                //*   5   11:instanceof      #34  <Class SerializedObject>
                //*   6   14:ifeq            25
                        return ((SerializedObject)oo).getObject();
                //    7   17:aload_1         
                //    8   18:checkcast       #34  <Class SerializedObject>
                //    9   21:invokevirtual   #37  <Method Object SerializedObject.getObject()>
                //   10   24:areturn         
                    else
                        return oo;
                //   11   25:aload_1         
                //   12   26:areturn         
                }

                final Attribute this$0;
                private final Enumeration val$ee=null;

            
            {
                this$0 = Attribute.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #15  <Field Attribute this$0>
            //    ee = val$ee;
            //    3    5:aload_0         
            //    4    6:aload_2         
            //    5    7:putfield        #17  <Field Enumeration val$ee>
             //   super();
            //    6   10:aload_0         
            //    7   11:invokespecial   #20  <Method void Object()>
            //    8   14:return          
            }
            }
;
    //   10   22:new             #255 <Class Attribute$1>
    //   11   25:dup             
    //   12   26:aload_0         
    //   13   27:aload_1         
    //   14   28:invokespecial   #258 <Method void Attribute$1(Attribute, Enumeration)>
    //   15   31:areturn         
        } else
        {
            return null;
    //   16   32:aconst_null     
    //   17   33:areturn         
        }
    }

    public final boolean equals(Object other)
    {
        if(other == null || !other.getClass().equals(getClass()))
    //*   0    0:aload_1         
    //*   1    1:ifnull          18
    //*   2    4:aload_1         
    //*   3    5:invokevirtual   #265 <Method Class Object.getClass()>
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #265 <Method Class Object.getClass()>
    //*   6   12:invokevirtual   #267 <Method boolean Object.equals(Object)>
    //*   7   15:ifne            20
            return false;
    //    8   18:iconst_0        
    //    9   19:ireturn         
        Attribute att = (Attribute)other;
    //   10   20:aload_1         
    //   11   21:checkcast       #2   <Class Attribute>
    //   12   24:astore_2        
        if(!m_Name.equals(att.m_Name))
    //*  13   25:aload_0         
    //*  14   26:getfield        #94  <Field String m_Name>
    //*  15   29:aload_2         
    //*  16   30:getfield        #94  <Field String m_Name>
    //*  17   33:invokevirtual   #268 <Method boolean String.equals(Object)>
    //*  18   36:ifne            41
            return false;
    //   19   39:iconst_0        
    //   20   40:ireturn         
        if(isNominal() && att.isNominal())
    //*  21   41:aload_0         
    //*  22   42:invokevirtual   #247 <Method boolean isNominal()>
    //*  23   45:ifeq            119
    //*  24   48:aload_2         
    //*  25   49:invokevirtual   #247 <Method boolean isNominal()>
    //*  26   52:ifeq            119
        {
            if(m_Values.size() != att.m_Values.size())
    //*  27   55:aload_0         
    //*  28   56:getfield        #98  <Field FastVector m_Values>
    //*  29   59:invokevirtual   #139 <Method int FastVector.size()>
    //*  30   62:aload_2         
    //*  31   63:getfield        #98  <Field FastVector m_Values>
    //*  32   66:invokevirtual   #139 <Method int FastVector.size()>
    //*  33   69:icmpeq          74
                return false;
    //   34   72:iconst_0        
    //   35   73:ireturn         
            for(int i = 0; i < m_Values.size(); i++)
    //*  36   74:iconst_0        
    //*  37   75:istore_3        
    //*  38   76:goto            106
                if(!m_Values.elementAt(i).equals(att.m_Values.elementAt(i)))
    //*  39   79:aload_0         
    //*  40   80:getfield        #98  <Field FastVector m_Values>
    //*  41   83:iload_3         
    //*  42   84:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //*  43   87:aload_2         
    //*  44   88:getfield        #98  <Field FastVector m_Values>
    //*  45   91:iload_3         
    //*  46   92:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //*  47   95:invokevirtual   #267 <Method boolean Object.equals(Object)>
    //*  48   98:ifne            103
                    return false;
    //   49  101:iconst_0        
    //   50  102:ireturn         

    //   51  103:iinc            3  1
    //   52  106:iload_3         
    //   53  107:aload_0         
    //   54  108:getfield        #98  <Field FastVector m_Values>
    //   55  111:invokevirtual   #139 <Method int FastVector.size()>
    //   56  114:icmplt          79
            return true;
    //   57  117:iconst_1        
    //   58  118:ireturn         
        }
        return type() == att.type();
    //   59  119:aload_0         
    //   60  120:invokevirtual   #271 <Method int type()>
    //   61  123:aload_2         
    //   62  124:invokevirtual   #271 <Method int type()>
    //   63  127:icmpne          132
    //   64  130:iconst_1        
    //   65  131:ireturn         
    //   66  132:iconst_0        
    //   67  133:ireturn         
    }

    public final int index()
    {
        return m_Index;
    //    0    0:aload_0         
    //    1    1:getfield        #96  <Field int m_Index>
    //    2    4:ireturn         
    }

    public final int indexOfValue(String value)
    {
        if(!isNominal() && !isString())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #247 <Method boolean isNominal()>
    //*   2    4:ifne            16
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #250 <Method boolean isString()>
    //*   5   11:ifne            16
            return -1;
    //    6   14:iconst_m1       
    //    7   15:ireturn         
        Object store = value;
    //    8   16:aload_1         
    //    9   17:astore_2        
        if(value.length() > 200)
    //*  10   18:aload_1         
    //*  11   19:invokevirtual   #152 <Method int String.length()>
    //*  12   22:sipush          200
    //*  13   25:icmple          51
            try
            {
                store = new SerializedObject(value, true);
    //   14   28:new             #154 <Class SerializedObject>
    //   15   31:dup             
    //   16   32:aload_1         
    //   17   33:iconst_1        
    //   18   34:invokespecial   #157 <Method void SerializedObject(Object, boolean)>
    //   19   37:astore_2        
            }
    //*  20   38:goto            51
            catch(Exception ex)
    //*  21   41:astore_3        
            {
                System.err.println("Couldn't compress string attribute value - searching uncompressed.");
    //   22   42:getstatic       #163 <Field PrintStream System.err>
    //   23   45:ldc2            #278 <String "Couldn't compress string attribute value - searching uncompressed.">
    //   24   48:invokevirtual   #170 <Method void PrintStream.println(String)>
            }
        Integer val = (Integer)(Integer)m_Hashtable.get(store);
    //   25   51:aload_0         
    //   26   52:getfield        #100 <Field Hashtable m_Hashtable>
    //   27   55:aload_2         
    //   28   56:invokevirtual   #282 <Method Object Hashtable.get(Object)>
    //   29   59:checkcast       #205 <Class Integer>
    //   30   62:checkcast       #205 <Class Integer>
    //   31   65:astore_3        
        if(val == null)
    //*  32   66:aload_3         
    //*  33   67:ifnonnull       72
            return -1;
    //   34   70:iconst_m1       
    //   35   71:ireturn         
        else
            return val.intValue();
    //   36   72:aload_3         
    //   37   73:invokevirtual   #285 <Method int Integer.intValue()>
    //   38   76:ireturn         
    }

    public final boolean isNominal()
    {
        return m_Type == 1;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field int m_Type>
    //    2    4:iconst_1        
    //    3    5:icmpne          10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    public final boolean isNumeric()
    {
        return m_Type == 0 || m_Type == 3;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field int m_Type>
    //    2    4:ifeq            17
    //    3    7:aload_0         
    //    4    8:getfield        #102 <Field int m_Type>
    //    5   11:iconst_3        
    //    6   12:icmpeq          17
    //    7   15:iconst_0        
    //    8   16:ireturn         
    //    9   17:iconst_1        
    //   10   18:ireturn         
    }

    public final boolean isRelationValued()
    {
        return m_Type == 4;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field int m_Type>
    //    2    4:iconst_4        
    //    3    5:icmpne          10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    public final boolean isString()
    {
        return m_Type == 2;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field int m_Type>
    //    2    4:iconst_2        
    //    3    5:icmpne          10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    public final boolean isDate()
    {
        return m_Type == 3;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field int m_Type>
    //    2    4:iconst_3        
    //    3    5:icmpne          10
    //    4    8:iconst_1        
    //    5    9:ireturn         
    //    6   10:iconst_0        
    //    7   11:ireturn         
    }

    public final String name()
    {
        return m_Name;
    //    0    0:aload_0         
    //    1    1:getfield        #94  <Field String m_Name>
    //    2    4:areturn         
    }

    public final int numValues()
    {
        if(!isNominal() && !isString() && !isRelationValued())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #247 <Method boolean isNominal()>
    //*   2    4:ifne            23
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #250 <Method boolean isString()>
    //*   5   11:ifne            23
    //*   6   14:aload_0         
    //*   7   15:invokevirtual   #295 <Method boolean isRelationValued()>
    //*   8   18:ifne            23
            return 0;
    //    9   21:iconst_0        
    //   10   22:ireturn         
        else
            return m_Values.size();
    //   11   23:aload_0         
    //   12   24:getfield        #98  <Field FastVector m_Values>
    //   13   27:invokevirtual   #139 <Method int FastVector.size()>
    //   14   30:ireturn         
    }

    public final String toString()
    {
        StringBuffer text = new StringBuffer();
    //    0    0:new             #297 <Class StringBuffer>
    //    1    3:dup             
    //    2    4:invokespecial   #298 <Method void StringBuffer()>
    //    3    7:astore_1        
        text.append("@attribute").append(" ").append(Utils.quote(m_Name)).append(" ");
    //    4    8:aload_1         
    //    5    9:ldc1            #25  <String "@attribute">
    //    6   11:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //    7   14:ldc2            #303 <String " ">
    //    8   17:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //    9   20:aload_0         
    //   10   21:getfield        #94  <Field String m_Name>
    //   11   24:invokestatic    #309 <Method String Utils.quote(String)>
    //   12   27:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   13   30:ldc2            #303 <String " ">
    //   14   33:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   15   36:pop             
        switch(m_Type)
    //*  16   37:aload_0         
    //*  17   38:getfield        #102 <Field int m_Type>
        {
    //*  18   41:tableswitch     0 3: default 191
    //                   0 142
    //                   1 72
    //                   2 152
    //                   3 162
        case 1: // '\001'
            text.append('{');
    //   19   72:aload_1         
    //   20   73:bipush          123
    //   21   75:invokevirtual   #312 <Method StringBuffer StringBuffer.append(char)>
    //   22   78:pop             
            for(Enumeration enu = enumerateValues(); enu.hasMoreElements();)
    //*  23   79:aload_0         
    //*  24   80:invokevirtual   #314 <Method Enumeration enumerateValues()>
    //*  25   83:astore_2        
    //*  26   84:goto            123
            {
                text.append(Utils.quote((String)(String)enu.nextElement()));
    //   27   87:aload_1         
    //   28   88:aload_2         
    //   29   89:invokeinterface #319 <Method Object Enumeration.nextElement()>
    //   30   94:checkcast       #149 <Class String>
    //   31   97:checkcast       #149 <Class String>
    //   32  100:invokestatic    #309 <Method String Utils.quote(String)>
    //   33  103:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   34  106:pop             
                if(enu.hasMoreElements())
    //*  35  107:aload_2         
    //*  36  108:invokeinterface #322 <Method boolean Enumeration.hasMoreElements()>
    //*  37  113:ifeq            123
                    text.append(',');
    //   38  116:aload_1         
    //   39  117:bipush          44
    //   40  119:invokevirtual   #312 <Method StringBuffer StringBuffer.append(char)>
    //   41  122:pop             
            }

    //   42  123:aload_2         
    //   43  124:invokeinterface #322 <Method boolean Enumeration.hasMoreElements()>
    //   44  129:ifne            87
            text.append('}');
    //   45  132:aload_1         
    //   46  133:bipush          125
    //   47  135:invokevirtual   #312 <Method StringBuffer StringBuffer.append(char)>
    //   48  138:pop             
            break;

    //*  49  139:goto            199
        case 0: // '\0'
            text.append("numeric");
    //   50  142:aload_1         
    //   51  143:ldc1            #34  <String "numeric">
    //   52  145:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   53  148:pop             
            break;

    //*  54  149:goto            199
        case 2: // '\002'
            text.append("string");
    //   55  152:aload_1         
    //   56  153:ldc1            #37  <String "string">
    //   57  155:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   58  158:pop             
            break;

    //*  59  159:goto            199
        case 3: // '\003'
            text.append("date").append(" ").append(Utils.quote(m_DateFormat.toPattern()));
    //   60  162:aload_1         
    //   61  163:ldc1            #40  <String "date">
    //   62  165:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   63  168:ldc2            #303 <String " ">
    //   64  171:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   65  174:aload_0         
    //   66  175:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //   67  178:invokevirtual   #325 <Method String SimpleDateFormat.toPattern()>
    //   68  181:invokestatic    #309 <Method String Utils.quote(String)>
    //   69  184:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   70  187:pop             
            break;

    //*  71  188:goto            199
        default:
            text.append("UNKNOWN");
    //   72  191:aload_1         
    //   73  192:ldc2            #327 <String "UNKNOWN">
    //   74  195:invokevirtual   #301 <Method StringBuffer StringBuffer.append(String)>
    //   75  198:pop             
            break;
        }
        return text.toString();
    //   76  199:aload_1         
    //   77  200:invokevirtual   #328 <Method String StringBuffer.toString()>
    //   78  203:areturn         
    }

    public final int type()
    {
        return m_Type;
    //    0    0:aload_0         
    //    1    1:getfield        #102 <Field int m_Type>
    //    2    4:ireturn         
    }

    public final String getDateFormat()
    {
        if(isDate())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #334 <Method boolean isDate()>
    //*   2    4:ifeq            15
            return m_DateFormat.toPattern();
    //    3    7:aload_0         
    //    4    8:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //    5   11:invokevirtual   #325 <Method String SimpleDateFormat.toPattern()>
    //    6   14:areturn         
        else
            return "";
    //    7   15:ldc2            #336 <String "">
    //    8   18:areturn         
    }

    public final String value(int valIndex)
    {
        if(!isNominal() && !isString())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #247 <Method boolean isNominal()>
    //*   2    4:ifne            18
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #250 <Method boolean isString()>
    //*   5   11:ifne            18
            return "";
    //    6   14:ldc2            #336 <String "">
    //    7   17:areturn         
        Object val = m_Values.elementAt(valIndex);
    //    8   18:aload_0         
    //    9   19:getfield        #98  <Field FastVector m_Values>
    //   10   22:iload_1         
    //   11   23:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //   12   26:astore_2        
        if(val instanceof SerializedObject)
    //*  13   27:aload_2         
    //*  14   28:instanceof      #154 <Class SerializedObject>
    //*  15   31:ifeq            42
            val = ((SerializedObject)val).getObject();
    //   16   34:aload_2         
    //   17   35:checkcast       #154 <Class SerializedObject>
    //   18   38:invokevirtual   #340 <Method Object SerializedObject.getObject()>
    //   19   41:astore_2        
        return (String)val;
    //   20   42:aload_2         
    //   21   43:checkcast       #149 <Class String>
    //   22   46:areturn         
    }

    public final Instances relation(int valIndex)
    {
        if(!isRelationValued())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #295 <Method boolean isRelationValued()>
    //*   2    4:ifne            9
            return null;
    //    3    7:aconst_null     
    //    4    8:areturn         
        else
            return (Instances)m_Values.elementAt(valIndex);
    //    5    9:aload_0         
    //    6   10:getfield        #98  <Field FastVector m_Values>
    //    7   13:iload_1         
    //    8   14:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //    9   17:checkcast       #225 <Class Instances>
    //   10   20:areturn         
    }

    public Attribute(String attributeName, int index)
    {
        this(attributeName);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #239 <Method void Attribute(String)>
        m_Index = index;
    //    3    5:aload_0         
    //    4    6:iload_2         
    //    5    7:putfield        #96  <Field int m_Index>
    //    6   10:return          
    }

    public Attribute(String attributeName, String dateFormat, int index)
    {
        this(attributeName, dateFormat);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokespecial   #347 <Method void Attribute(String, String)>
        m_Index = index;
    //    4    6:aload_0         
    //    5    7:iload_3         
    //    6    8:putfield        #96  <Field int m_Index>
    //    7   11:return          
    }

    public Attribute(String attributeName, FastVector attributeValues, int index)
    {
        this(attributeName, attributeValues);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokespecial   #350 <Method void Attribute(String, FastVector)>
        m_Index = index;
    //    4    6:aload_0         
    //    5    7:iload_3         
    //    6    8:putfield        #96  <Field int m_Index>
    //    7   11:return          
    }

    public Attribute(String attributeName, Instances header, int index)
    {
        this(attributeName, header);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_2         
    //    3    3:invokespecial   #353 <Method void Attribute(String, Instances)>
        m_Index = index;
    //    4    6:aload_0         
    //    5    7:iload_3         
    //    6    8:putfield        #96  <Field int m_Index>
    //    7   11:return          
    }

    public int addStringValue(String value)
    {
        if(!isString())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #250 <Method boolean isString()>
    //*   2    4:ifne            9
            return -1;
    //    3    7:iconst_m1       
    //    4    8:ireturn         
        Object store = value;
    //    5    9:aload_1         
    //    6   10:astore_2        
        if(value.length() > 200)
    //*   7   11:aload_1         
    //*   8   12:invokevirtual   #152 <Method int String.length()>
    //*   9   15:sipush          200
    //*  10   18:icmple          44
            try
            {
                store = new SerializedObject(value, true);
    //   11   21:new             #154 <Class SerializedObject>
    //   12   24:dup             
    //   13   25:aload_1         
    //   14   26:iconst_1        
    //   15   27:invokespecial   #157 <Method void SerializedObject(Object, boolean)>
    //   16   30:astore_2        
            }
    //*  17   31:goto            44
            catch(Exception ex)
    //*  18   34:astore_3        
            {
                System.err.println("Couldn't compress string attribute value - storing uncompressed.");
    //   19   35:getstatic       #163 <Field PrintStream System.err>
    //   20   38:ldc2            #356 <String "Couldn't compress string attribute value - storing uncompressed.">
    //   21   41:invokevirtual   #170 <Method void PrintStream.println(String)>
            }
        Integer index = (Integer)(Integer)m_Hashtable.get(store);
    //   22   44:aload_0         
    //   23   45:getfield        #100 <Field Hashtable m_Hashtable>
    //   24   48:aload_2         
    //   25   49:invokevirtual   #282 <Method Object Hashtable.get(Object)>
    //   26   52:checkcast       #205 <Class Integer>
    //   27   55:checkcast       #205 <Class Integer>
    //   28   58:astore_3        
        if(index != null)
    //*  29   59:aload_3         
    //*  30   60:ifnull          68
        {
            return index.intValue();
    //   31   63:aload_3         
    //   32   64:invokevirtual   #285 <Method int Integer.intValue()>
    //   33   67:ireturn         
        } else
        {
            int intIndex = m_Values.size();
    //   34   68:aload_0         
    //   35   69:getfield        #98  <Field FastVector m_Values>
    //   36   72:invokevirtual   #139 <Method int FastVector.size()>
    //   37   75:istore          4
            m_Values.addElement(store);
    //   38   77:aload_0         
    //   39   78:getfield        #98  <Field FastVector m_Values>
    //   40   81:aload_2         
    //   41   82:invokevirtual   #203 <Method void FastVector.addElement(Object)>
            m_Hashtable.put(store, new Integer(intIndex));
    //   42   85:aload_0         
    //   43   86:getfield        #100 <Field Hashtable m_Hashtable>
    //   44   89:aload_2         
    //   45   90:new             #205 <Class Integer>
    //   46   93:dup             
    //   47   94:iload           4
    //   48   96:invokespecial   #206 <Method void Integer(int)>
    //   49   99:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   50  102:pop             
            return intIndex;
    //   51  103:iload           4
    //   52  105:ireturn         
        }
    }

    public int addStringValue(Attribute src, int index)
    {
        if(!isString())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #250 <Method boolean isString()>
    //*   2    4:ifne            9
            return -1;
    //    3    7:iconst_m1       
    //    4    8:ireturn         
        Object store = src.m_Values.elementAt(index);
    //    5    9:aload_1         
    //    6   10:getfield        #98  <Field FastVector m_Values>
    //    7   13:iload_2         
    //    8   14:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //    9   17:astore_3        
        Integer oldIndex = (Integer)(Integer)m_Hashtable.get(store);
    //   10   18:aload_0         
    //   11   19:getfield        #100 <Field Hashtable m_Hashtable>
    //   12   22:aload_3         
    //   13   23:invokevirtual   #282 <Method Object Hashtable.get(Object)>
    //   14   26:checkcast       #205 <Class Integer>
    //   15   29:checkcast       #205 <Class Integer>
    //   16   32:astore          4
        if(oldIndex != null)
    //*  17   34:aload           4
    //*  18   36:ifnull          45
        {
            return oldIndex.intValue();
    //   19   39:aload           4
    //   20   41:invokevirtual   #285 <Method int Integer.intValue()>
    //   21   44:ireturn         
        } else
        {
            int intIndex = m_Values.size();
    //   22   45:aload_0         
    //   23   46:getfield        #98  <Field FastVector m_Values>
    //   24   49:invokevirtual   #139 <Method int FastVector.size()>
    //   25   52:istore          5
            m_Values.addElement(store);
    //   26   54:aload_0         
    //   27   55:getfield        #98  <Field FastVector m_Values>
    //   28   58:aload_3         
    //   29   59:invokevirtual   #203 <Method void FastVector.addElement(Object)>
            m_Hashtable.put(store, new Integer(intIndex));
    //   30   62:aload_0         
    //   31   63:getfield        #100 <Field Hashtable m_Hashtable>
    //   32   66:aload_3         
    //   33   67:new             #205 <Class Integer>
    //   34   70:dup             
    //   35   71:iload           5
    //   36   73:invokespecial   #206 <Method void Integer(int)>
    //   37   76:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   38   79:pop             
            return intIndex;
    //   39   80:iload           5
    //   40   82:ireturn         
        }
    }

    public int addRelation(Instances value)
    {
        if(!isRelationValued())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #295 <Method boolean isRelationValued()>
    //*   2    4:ifne            9
            return -1;
    //    3    7:iconst_m1       
    //    4    8:ireturn         
        Integer index = (Integer)(Integer)m_Hashtable.get(value);
    //    5    9:aload_0         
    //    6   10:getfield        #100 <Field Hashtable m_Hashtable>
    //    7   13:aload_1         
    //    8   14:invokevirtual   #282 <Method Object Hashtable.get(Object)>
    //    9   17:checkcast       #205 <Class Integer>
    //   10   20:checkcast       #205 <Class Integer>
    //   11   23:astore_2        
        if(index != null)
    //*  12   24:aload_2         
    //*  13   25:ifnull          33
        {
            return index.intValue();
    //   14   28:aload_2         
    //   15   29:invokevirtual   #285 <Method int Integer.intValue()>
    //   16   32:ireturn         
        } else
        {
            int intIndex = m_Values.size();
    //   17   33:aload_0         
    //   18   34:getfield        #98  <Field FastVector m_Values>
    //   19   37:invokevirtual   #139 <Method int FastVector.size()>
    //   20   40:istore_3        
            m_Values.addElement(value);
    //   21   41:aload_0         
    //   22   42:getfield        #98  <Field FastVector m_Values>
    //   23   45:aload_1         
    //   24   46:invokevirtual   #203 <Method void FastVector.addElement(Object)>
            m_Hashtable.put(value, new Integer(intIndex));
    //   25   49:aload_0         
    //   26   50:getfield        #100 <Field Hashtable m_Hashtable>
    //   27   53:aload_1         
    //   28   54:new             #205 <Class Integer>
    //   29   57:dup             
    //   30   58:iload_3         
    //   31   59:invokespecial   #206 <Method void Integer(int)>
    //   32   62:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   33   65:pop             
            return intIndex;
    //   34   66:iload_3         
    //   35   67:ireturn         
        }
    }

    final void addValue(String value)
    {
        m_Values = (FastVector)m_Values.copy();
    //    0    0:aload_0         
    //    1    1:aload_0         
    //    2    2:getfield        #98  <Field FastVector m_Values>
    //    3    5:invokevirtual   #365 <Method Object FastVector.copy()>
    //    4    8:checkcast       #131 <Class FastVector>
    //    5   11:putfield        #98  <Field FastVector m_Values>
        m_Hashtable = (Hashtable)m_Hashtable.clone();
    //    6   14:aload_0         
    //    7   15:aload_0         
    //    8   16:getfield        #100 <Field Hashtable m_Hashtable>
    //    9   19:invokevirtual   #368 <Method Object Hashtable.clone()>
    //   10   22:checkcast       #134 <Class Hashtable>
    //   11   25:putfield        #100 <Field Hashtable m_Hashtable>
        forceAddValue(value);
    //   12   28:aload_0         
    //   13   29:aload_1         
    //   14   30:invokevirtual   #371 <Method void forceAddValue(String)>
    //   15   33:return          
    }

    public final Attribute copy(String newName)
    {
        Attribute copy = new Attribute(newName);
    //    0    0:new             #2   <Class Attribute>
    //    1    3:dup             
    //    2    4:aload_1         
    //    3    5:invokespecial   #239 <Method void Attribute(String)>
    //    4    8:astore_2        
        copy.m_Index = m_Index;
    //    5    9:aload_2         
    //    6   10:aload_0         
    //    7   11:getfield        #96  <Field int m_Index>
    //    8   14:putfield        #96  <Field int m_Index>
        copy.m_DateFormat = m_DateFormat;
    //    9   17:aload_2         
    //   10   18:aload_0         
    //   11   19:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //   12   22:putfield        #118 <Field SimpleDateFormat m_DateFormat>
        copy.m_Type = m_Type;
    //   13   25:aload_2         
    //   14   26:aload_0         
    //   15   27:getfield        #102 <Field int m_Type>
    //   16   30:putfield        #102 <Field int m_Type>
        copy.m_Values = m_Values;
    //   17   33:aload_2         
    //   18   34:aload_0         
    //   19   35:getfield        #98  <Field FastVector m_Values>
    //   20   38:putfield        #98  <Field FastVector m_Values>
        copy.m_Hashtable = m_Hashtable;
    //   21   41:aload_2         
    //   22   42:aload_0         
    //   23   43:getfield        #100 <Field Hashtable m_Hashtable>
    //   24   46:putfield        #100 <Field Hashtable m_Hashtable>
        copy.setMetadata(m_Metadata);
    //   25   49:aload_2         
    //   26   50:aload_0         
    //   27   51:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   28   54:invokespecial   #106 <Method void setMetadata(ProtectedProperties)>
        return copy;
    //   29   57:aload_2         
    //   30   58:areturn         
    }

    final void delete(int index)
    {
        if(!isNominal() && !isString() && !isRelationValued())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #247 <Method boolean isNominal()>
    //*   2    4:ifne            32
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #250 <Method boolean isString()>
    //*   5   11:ifne            32
    //*   6   14:aload_0         
    //*   7   15:invokevirtual   #295 <Method boolean isRelationValued()>
    //*   8   18:ifne            32
            throw new IllegalArgumentException("Can only remove value of nominal, string or relation- valued attribute!");
    //    9   21:new             #176 <Class IllegalArgumentException>
    //   10   24:dup             
    //   11   25:ldc2            #376 <String "Can only remove value of nominal, string or relation- valued attribute!">
    //   12   28:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   13   31:athrow          
        m_Values = (FastVector)m_Values.copy();
    //   14   32:aload_0         
    //   15   33:aload_0         
    //   16   34:getfield        #98  <Field FastVector m_Values>
    //   17   37:invokevirtual   #365 <Method Object FastVector.copy()>
    //   18   40:checkcast       #131 <Class FastVector>
    //   19   43:putfield        #98  <Field FastVector m_Values>
        m_Values.removeElementAt(index);
    //   20   46:aload_0         
    //   21   47:getfield        #98  <Field FastVector m_Values>
    //   22   50:iload_1         
    //   23   51:invokevirtual   #379 <Method void FastVector.removeElementAt(int)>
        if(!isRelationValued())
    //*  24   54:aload_0         
    //*  25   55:invokevirtual   #295 <Method boolean isRelationValued()>
    //*  26   58:ifne            175
        {
            Hashtable hash = new Hashtable(m_Hashtable.size());
    //   27   61:new             #134 <Class Hashtable>
    //   28   64:dup             
    //   29   65:aload_0         
    //   30   66:getfield        #100 <Field Hashtable m_Hashtable>
    //   31   69:invokevirtual   #380 <Method int Hashtable.size()>
    //   32   72:invokespecial   #143 <Method void Hashtable(int)>
    //   33   75:astore_2        
            for(Enumeration enu = m_Hashtable.keys(); enu.hasMoreElements();)
    //*  34   76:aload_0         
    //*  35   77:getfield        #100 <Field Hashtable m_Hashtable>
    //*  36   80:invokevirtual   #383 <Method Enumeration Hashtable.keys()>
    //*  37   83:astore_3        
    //*  38   84:goto            161
            {
                Object string = enu.nextElement();
    //   39   87:aload_3         
    //   40   88:invokeinterface #319 <Method Object Enumeration.nextElement()>
    //   41   93:astore          4
                Integer valIndexObject = (Integer)(Integer)m_Hashtable.get(string);
    //   42   95:aload_0         
    //   43   96:getfield        #100 <Field Hashtable m_Hashtable>
    //   44   99:aload           4
    //   45  101:invokevirtual   #282 <Method Object Hashtable.get(Object)>
    //   46  104:checkcast       #205 <Class Integer>
    //   47  107:checkcast       #205 <Class Integer>
    //   48  110:astore          5
                int valIndex = valIndexObject.intValue();
    //   49  112:aload           5
    //   50  114:invokevirtual   #285 <Method int Integer.intValue()>
    //   51  117:istore          6
                if(valIndex > index)
    //*  52  119:iload           6
    //*  53  121:iload_1         
    //*  54  122:icmple          146
                    hash.put(string, new Integer(valIndex - 1));
    //   55  125:aload_2         
    //   56  126:aload           4
    //   57  128:new             #205 <Class Integer>
    //   58  131:dup             
    //   59  132:iload           6
    //   60  134:iconst_1        
    //   61  135:isub            
    //   62  136:invokespecial   #206 <Method void Integer(int)>
    //   63  139:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   64  142:pop             
                else
    //*  65  143:goto            161
                if(valIndex < index)
    //*  66  146:iload           6
    //*  67  148:iload_1         
    //*  68  149:icmpge          161
                    hash.put(string, valIndexObject);
    //   69  152:aload_2         
    //   70  153:aload           4
    //   71  155:aload           5
    //   72  157:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   73  160:pop             
            }

    //   74  161:aload_3         
    //   75  162:invokeinterface #322 <Method boolean Enumeration.hasMoreElements()>
    //   76  167:ifne            87
            m_Hashtable = hash;
    //   77  170:aload_0         
    //   78  171:aload_2         
    //   79  172:putfield        #100 <Field Hashtable m_Hashtable>
        }
    //   80  175:return          
    }

    final void forceAddValue(String value)
    {
        Object store = value;
    //    0    0:aload_1         
    //    1    1:astore_2        
        if(value.length() > 200)
    //*   2    2:aload_1         
    //*   3    3:invokevirtual   #152 <Method int String.length()>
    //*   4    6:sipush          200
    //*   5    9:icmple          35
            try
            {
                store = new SerializedObject(value, true);
    //    6   12:new             #154 <Class SerializedObject>
    //    7   15:dup             
    //    8   16:aload_1         
    //    9   17:iconst_1        
    //   10   18:invokespecial   #157 <Method void SerializedObject(Object, boolean)>
    //   11   21:astore_2        
            }
    //*  12   22:goto            35
            catch(Exception ex)
    //*  13   25:astore_3        
            {
                System.err.println("Couldn't compress string attribute value - storing uncompressed.");
    //   14   26:getstatic       #163 <Field PrintStream System.err>
    //   15   29:ldc2            #356 <String "Couldn't compress string attribute value - storing uncompressed.">
    //   16   32:invokevirtual   #170 <Method void PrintStream.println(String)>
            }
        m_Values.addElement(store);
    //   17   35:aload_0         
    //   18   36:getfield        #98  <Field FastVector m_Values>
    //   19   39:aload_2         
    //   20   40:invokevirtual   #203 <Method void FastVector.addElement(Object)>
        m_Hashtable.put(store, new Integer(m_Values.size() - 1));
    //   21   43:aload_0         
    //   22   44:getfield        #100 <Field Hashtable m_Hashtable>
    //   23   47:aload_2         
    //   24   48:new             #205 <Class Integer>
    //   25   51:dup             
    //   26   52:aload_0         
    //   27   53:getfield        #98  <Field FastVector m_Values>
    //   28   56:invokevirtual   #139 <Method int FastVector.size()>
    //   29   59:iconst_1        
    //   30   60:isub            
    //   31   61:invokespecial   #206 <Method void Integer(int)>
    //   32   64:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   33   67:pop             
    //   34   68:return          
    }

    final void setIndex(int index)
    {
        m_Index = index;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #96  <Field int m_Index>
    //    3    5:return          
    }

    final void setValue(int index, String string)
    {
        switch(m_Type)
    //*   0    0:aload_0         
    //*   1    1:getfield        #102 <Field int m_Type>
        {
    //*   2    4:tableswitch     1 2: default 137
    //                   1 28
    //                   2 28
        case 1: // '\001'
        case 2: // '\002'
            m_Values = (FastVector)m_Values.copy();
    //    3   28:aload_0         
    //    4   29:aload_0         
    //    5   30:getfield        #98  <Field FastVector m_Values>
    //    6   33:invokevirtual   #365 <Method Object FastVector.copy()>
    //    7   36:checkcast       #131 <Class FastVector>
    //    8   39:putfield        #98  <Field FastVector m_Values>
            m_Hashtable = (Hashtable)m_Hashtable.clone();
    //    9   42:aload_0         
    //   10   43:aload_0         
    //   11   44:getfield        #100 <Field Hashtable m_Hashtable>
    //   12   47:invokevirtual   #368 <Method Object Hashtable.clone()>
    //   13   50:checkcast       #134 <Class Hashtable>
    //   14   53:putfield        #100 <Field Hashtable m_Hashtable>
            Object store = string;
    //   15   56:aload_2         
    //   16   57:astore_3        
            if(string.length() > 200)
    //*  17   58:aload_2         
    //*  18   59:invokevirtual   #152 <Method int String.length()>
    //*  19   62:sipush          200
    //*  20   65:icmple          92
                try
                {
                    store = new SerializedObject(string, true);
    //   21   68:new             #154 <Class SerializedObject>
    //   22   71:dup             
    //   23   72:aload_2         
    //   24   73:iconst_1        
    //   25   74:invokespecial   #157 <Method void SerializedObject(Object, boolean)>
    //   26   77:astore_3        
                }
    //*  27   78:goto            92
                catch(Exception ex)
    //*  28   81:astore          4
                {
                    System.err.println("Couldn't compress string attribute value - storing uncompressed.");
    //   29   83:getstatic       #163 <Field PrintStream System.err>
    //   30   86:ldc2            #356 <String "Couldn't compress string attribute value - storing uncompressed.">
    //   31   89:invokevirtual   #170 <Method void PrintStream.println(String)>
                }
            m_Hashtable.remove(m_Values.elementAt(index));
    //   32   92:aload_0         
    //   33   93:getfield        #100 <Field Hashtable m_Hashtable>
    //   34   96:aload_0         
    //   35   97:getfield        #98  <Field FastVector m_Values>
    //   36  100:iload_1         
    //   37  101:invokevirtual   #147 <Method Object FastVector.elementAt(int)>
    //   38  104:invokevirtual   #391 <Method Object Hashtable.remove(Object)>
    //   39  107:pop             
            m_Values.setElementAt(store, index);
    //   40  108:aload_0         
    //   41  109:getfield        #98  <Field FastVector m_Values>
    //   42  112:aload_3         
    //   43  113:iload_1         
    //   44  114:invokevirtual   #395 <Method void FastVector.setElementAt(Object, int)>
            m_Hashtable.put(store, new Integer(index));
    //   45  117:aload_0         
    //   46  118:getfield        #100 <Field Hashtable m_Hashtable>
    //   47  121:aload_3         
    //   48  122:new             #205 <Class Integer>
    //   49  125:dup             
    //   50  126:iload_1         
    //   51  127:invokespecial   #206 <Method void Integer(int)>
    //   52  130:invokevirtual   #210 <Method Object Hashtable.put(Object, Object)>
    //   53  133:pop             
            break;

    //*  54  134:goto            148
        default:
            throw new IllegalArgumentException("Can only set values for nominal or string attributes!");
    //   55  137:new             #176 <Class IllegalArgumentException>
    //   56  140:dup             
    //   57  141:ldc2            #397 <String "Can only set values for nominal or string attributes!">
    //   58  144:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   59  147:athrow          
        }
    //   60  148:return          
    }

    final void setValue(int index, Instances data)
    {
        if(isRelationValued())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #295 <Method boolean isRelationValued()>
    //*   2    4:ifeq            33
        {
            m_Values = (FastVector)m_Values.copy();
    //    3    7:aload_0         
    //    4    8:aload_0         
    //    5    9:getfield        #98  <Field FastVector m_Values>
    //    6   12:invokevirtual   #365 <Method Object FastVector.copy()>
    //    7   15:checkcast       #131 <Class FastVector>
    //    8   18:putfield        #98  <Field FastVector m_Values>
            m_Values.setElementAt(data, index);
    //    9   21:aload_0         
    //   10   22:getfield        #98  <Field FastVector m_Values>
    //   11   25:aload_2         
    //   12   26:iload_1         
    //   13   27:invokevirtual   #395 <Method void FastVector.setElementAt(Object, int)>
        } else
    //*  14   30:goto            44
        {
            throw new IllegalArgumentException("Can only set value for relation-valued attributes!");
    //   15   33:new             #176 <Class IllegalArgumentException>
    //   16   36:dup             
    //   17   37:ldc2            #400 <String "Can only set value for relation-valued attributes!">
    //   18   40:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   19   43:athrow          
        }
    //   20   44:return          
    }

    public String formatDate(double date)
    {
        switch(m_Type)
    //*   0    0:aload_0         
    //*   1    1:getfield        #102 <Field int m_Type>
        {
    //*   2    4:tableswitch     3 3: default 41
    //                   3 24
        case 3: // '\003'
            return m_DateFormat.format(new Date((long)date));
    //    3   24:aload_0         
    //    4   25:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //    5   28:new             #405 <Class Date>
    //    6   31:dup             
    //    7   32:dload_1         
    //    8   33:d2l             
    //    9   34:invokespecial   #408 <Method void Date(long)>
    //   10   37:invokevirtual   #412 <Method String SimpleDateFormat.format(Date)>
    //   11   40:areturn         
        }
        throw new IllegalArgumentException("Can only format date values for date attributes!");
    //   12   41:new             #176 <Class IllegalArgumentException>
    //   13   44:dup             
    //   14   45:ldc2            #414 <String "Can only format date values for date attributes!">
    //   15   48:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   16   51:athrow          
    }

    public double parseDate(String string)
        throws ParseException
    {
        switch(m_Type)
    //*   0    0:aload_0         
    //*   1    1:getfield        #102 <Field int m_Type>
        {
    //*   2    4:tableswitch     3 3: default 39
    //                   3 24
        case 3: // '\003'
            long time = m_DateFormat.parse(string).getTime();
    //    3   24:aload_0         
    //    4   25:getfield        #118 <Field SimpleDateFormat m_DateFormat>
    //    5   28:aload_1         
    //    6   29:invokevirtual   #423 <Method Date SimpleDateFormat.parse(String)>
    //    7   32:invokevirtual   #427 <Method long Date.getTime()>
    //    8   35:lstore_2        
            return (double)time;
    //    9   36:lload_2         
    //   10   37:l2d             
    //   11   38:dreturn         
        }
        throw new IllegalArgumentException("Can only parse date values for date attributes!");
    //   12   39:new             #176 <Class IllegalArgumentException>
    //   13   42:dup             
    //   14   43:ldc2            #429 <String "Can only parse date values for date attributes!">
    //   15   46:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   16   49:athrow          
    }

    public final ProtectedProperties getMetadata()
    {
        return m_Metadata;
    //    0    0:aload_0         
    //    1    1:getfield        #241 <Field ProtectedProperties m_Metadata>
    //    2    4:areturn         
    }

    public final int ordering()
    {
        return m_Ordering;
    //    0    0:aload_0         
    //    1    1:getfield        #436 <Field int m_Ordering>
    //    2    4:ireturn         
    }

    public final boolean isRegular()
    {
        return m_IsRegular;
    //    0    0:aload_0         
    //    1    1:getfield        #439 <Field boolean m_IsRegular>
    //    2    4:ireturn         
    }

    public final boolean isAveragable()
    {
        return m_IsAveragable;
    //    0    0:aload_0         
    //    1    1:getfield        #442 <Field boolean m_IsAveragable>
    //    2    4:ireturn         
    }

    public final boolean hasZeropoint()
    {
        return m_HasZeropoint;
    //    0    0:aload_0         
    //    1    1:getfield        #445 <Field boolean m_HasZeropoint>
    //    2    4:ireturn         
    }

    public final double weight()
    {
        return m_Weight;
    //    0    0:aload_0         
    //    1    1:getfield        #449 <Field double m_Weight>
    //    2    4:dreturn         
    }

    public void setWeight(double value)
    {
        m_Weight = value;
    //    0    0:aload_0         
    //    1    1:dload_1         
    //    2    2:putfield        #449 <Field double m_Weight>
        Properties props = new Properties();
    //    3    5:new             #77  <Class Properties>
    //    4    8:dup             
    //    5    9:invokespecial   #80  <Method void Properties()>
    //    6   12:astore_3        
        for(Enumeration names = m_Metadata.propertyNames(); names.hasMoreElements();)
    //*   7   13:aload_0         
    //*   8   14:getfield        #241 <Field ProtectedProperties m_Metadata>
    //*   9   17:invokevirtual   #454 <Method Enumeration ProtectedProperties.propertyNames()>
    //*  10   20:astore          4
    //*  11   22:goto            67
        {
            String name = (String)(String)names.nextElement();
    //   12   25:aload           4
    //   13   27:invokeinterface #319 <Method Object Enumeration.nextElement()>
    //   14   32:checkcast       #149 <Class String>
    //   15   35:checkcast       #149 <Class String>
    //   16   38:astore          5
            if(!name.equals("weight"))
    //*  17   40:aload           5
    //*  18   42:ldc2            #455 <String "weight">
    //*  19   45:invokevirtual   #268 <Method boolean String.equals(Object)>
    //*  20   48:ifne            67
                props.setProperty(name, m_Metadata.getProperty(name));
    //   21   51:aload_3         
    //   22   52:aload           5
    //   23   54:aload_0         
    //   24   55:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   25   58:aload           5
    //   26   60:invokevirtual   #458 <Method String ProtectedProperties.getProperty(String)>
    //   27   63:invokevirtual   #462 <Method Object Properties.setProperty(String, String)>
    //   28   66:pop             
        }

    //   29   67:aload           4
    //   30   69:invokeinterface #322 <Method boolean Enumeration.hasMoreElements()>
    //   31   74:ifne            25
        props.setProperty("weight", (new StringBuilder()).append(m_Weight).toString());
    //   32   77:aload_3         
    //   33   78:ldc2            #455 <String "weight">
    //   34   81:new             #178 <Class StringBuilder>
    //   35   84:dup             
    //   36   85:invokespecial   #463 <Method void StringBuilder()>
    //   37   88:aload_0         
    //   38   89:getfield        #449 <Field double m_Weight>
    //   39   92:invokevirtual   #466 <Method StringBuilder StringBuilder.append(double)>
    //   40   95:invokevirtual   #198 <Method String StringBuilder.toString()>
    //   41   98:invokevirtual   #462 <Method Object Properties.setProperty(String, String)>
    //   42  101:pop             
        m_Metadata = new ProtectedProperties(props);
    //   43  102:aload_0         
    //   44  103:new             #75  <Class ProtectedProperties>
    //   45  106:dup             
    //   46  107:aload_3         
    //   47  108:invokespecial   #83  <Method void ProtectedProperties(Properties)>
    //   48  111:putfield        #241 <Field ProtectedProperties m_Metadata>
    //   49  114:return          
    }

    public final double getLowerNumericBound()
    {
        return m_LowerBound;
    //    0    0:aload_0         
    //    1    1:getfield        #472 <Field double m_LowerBound>
    //    2    4:dreturn         
    }

    public final boolean lowerNumericBoundIsOpen()
    {
        return m_LowerBoundIsOpen;
    //    0    0:aload_0         
    //    1    1:getfield        #475 <Field boolean m_LowerBoundIsOpen>
    //    2    4:ireturn         
    }

    public final double getUpperNumericBound()
    {
        return m_UpperBound;
    //    0    0:aload_0         
    //    1    1:getfield        #478 <Field double m_UpperBound>
    //    2    4:dreturn         
    }

    public final boolean upperNumericBoundIsOpen()
    {
        return m_UpperBoundIsOpen;
    //    0    0:aload_0         
    //    1    1:getfield        #481 <Field boolean m_UpperBoundIsOpen>
    //    2    4:ireturn         
    }

    public final boolean isInRange(double value)
    {
        if(m_Type == 3 || Instance.isMissingValue(value))
    //*   0    0:aload_0         
    //*   1    1:getfield        #102 <Field int m_Type>
    //*   2    4:iconst_3        
    //*   3    5:icmpeq          15
    //*   4    8:dload_1         
    //*   5    9:invokestatic    #488 <Method boolean Instance.isMissingValue(double)>
    //*   6   12:ifeq            17
            return true;
    //    7   15:iconst_1        
    //    8   16:ireturn         
        if(m_Type != 0)
    //*   9   17:aload_0         
    //*  10   18:getfield        #102 <Field int m_Type>
    //*  11   21:ifeq            47
        {
            int intVal = (int)value;
    //   12   24:dload_1         
    //   13   25:d2i             
    //   14   26:istore_3        
            if(intVal < 0 || intVal >= m_Hashtable.size())
    //*  15   27:iload_3         
    //*  16   28:iflt            42
    //*  17   31:iload_3         
    //*  18   32:aload_0         
    //*  19   33:getfield        #100 <Field Hashtable m_Hashtable>
    //*  20   36:invokevirtual   #380 <Method int Hashtable.size()>
    //*  21   39:icmplt          111
                return false;
    //   22   42:iconst_0        
    //   23   43:ireturn         
        } else
    //*  24   44:goto            111
        {
            if(m_LowerBoundIsOpen)
    //*  25   47:aload_0         
    //*  26   48:getfield        #475 <Field boolean m_LowerBoundIsOpen>
    //*  27   51:ifeq            68
            {
                if(value <= m_LowerBound)
    //*  28   54:dload_1         
    //*  29   55:aload_0         
    //*  30   56:getfield        #472 <Field double m_LowerBound>
    //*  31   59:dcmpg           
    //*  32   60:ifgt            79
                    return false;
    //   33   63:iconst_0        
    //   34   64:ireturn         
            } else
    //*  35   65:goto            79
            if(value < m_LowerBound)
    //*  36   68:dload_1         
    //*  37   69:aload_0         
    //*  38   70:getfield        #472 <Field double m_LowerBound>
    //*  39   73:dcmpg           
    //*  40   74:ifge            79
                return false;
    //   41   77:iconst_0        
    //   42   78:ireturn         
            if(m_UpperBoundIsOpen)
    //*  43   79:aload_0         
    //*  44   80:getfield        #481 <Field boolean m_UpperBoundIsOpen>
    //*  45   83:ifeq            100
            {
                if(value >= m_UpperBound)
    //*  46   86:dload_1         
    //*  47   87:aload_0         
    //*  48   88:getfield        #478 <Field double m_UpperBound>
    //*  49   91:dcmpl           
    //*  50   92:iflt            111
                    return false;
    //   51   95:iconst_0        
    //   52   96:ireturn         
            } else
    //*  53   97:goto            111
            if(value > m_UpperBound)
    //*  54  100:dload_1         
    //*  55  101:aload_0         
    //*  56  102:getfield        #478 <Field double m_UpperBound>
    //*  57  105:dcmpl           
    //*  58  106:ifle            111
                return false;
    //   59  109:iconst_0        
    //   60  110:ireturn         
        }
        return true;
    //   61  111:iconst_1        
    //   62  112:ireturn         
    }

    private void setMetadata(ProtectedProperties metadata)
    {
        m_Metadata = metadata;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #241 <Field ProtectedProperties m_Metadata>
        if(m_Type == 3)
    //*   3    5:aload_0         
    //*   4    6:getfield        #102 <Field int m_Type>
    //*   5    9:iconst_3        
    //*   6   10:icmpne          36
        {
            m_Ordering = 1;
    //    7   13:aload_0         
    //    8   14:iconst_1        
    //    9   15:putfield        #436 <Field int m_Ordering>
            m_IsRegular = true;
    //   10   18:aload_0         
    //   11   19:iconst_1        
    //   12   20:putfield        #439 <Field boolean m_IsRegular>
            m_IsAveragable = false;
    //   13   23:aload_0         
    //   14   24:iconst_0        
    //   15   25:putfield        #442 <Field boolean m_IsAveragable>
            m_HasZeropoint = false;
    //   16   28:aload_0         
    //   17   29:iconst_0        
    //   18   30:putfield        #445 <Field boolean m_HasZeropoint>
        } else
    //*  19   33:goto            281
        {
            String orderString = m_Metadata.getProperty("ordering", "");
    //   20   36:aload_0         
    //   21   37:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   22   40:ldc2            #490 <String "ordering">
    //   23   43:ldc2            #336 <String "">
    //   24   46:invokevirtual   #493 <Method String ProtectedProperties.getProperty(String, String)>
    //   25   49:astore_2        
            String def;
            if(m_Type == 0 && orderString.compareTo("modulo") != 0 && orderString.compareTo("symbolic") != 0)
    //*  26   50:aload_0         
    //*  27   51:getfield        #102 <Field int m_Type>
    //*  28   54:ifne            84
    //*  29   57:aload_2         
    //*  30   58:ldc2            #495 <String "modulo">
    //*  31   61:invokevirtual   #498 <Method int String.compareTo(String)>
    //*  32   64:ifeq            84
    //*  33   67:aload_2         
    //*  34   68:ldc2            #500 <String "symbolic">
    //*  35   71:invokevirtual   #498 <Method int String.compareTo(String)>
    //*  36   74:ifeq            84
                def = "true";
    //   37   77:ldc2            #502 <String "true">
    //   38   80:astore_3        
            else
    //*  39   81:goto            88
                def = "false";
    //   40   84:ldc2            #504 <String "false">
    //   41   87:astore_3        
            m_IsAveragable = m_Metadata.getProperty("averageable", def).compareTo("true") == 0;
    //   42   88:aload_0         
    //   43   89:aload_0         
    //   44   90:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   45   93:ldc2            #506 <String "averageable">
    //   46   96:aload_3         
    //   47   97:invokevirtual   #493 <Method String ProtectedProperties.getProperty(String, String)>
    //   48  100:ldc2            #502 <String "true">
    //   49  103:invokevirtual   #498 <Method int String.compareTo(String)>
    //   50  106:ifne            113
    //   51  109:iconst_1        
    //   52  110:goto            114
    //   53  113:iconst_0        
    //   54  114:putfield        #442 <Field boolean m_IsAveragable>
            m_HasZeropoint = m_Metadata.getProperty("zeropoint", def).compareTo("true") == 0;
    //   55  117:aload_0         
    //   56  118:aload_0         
    //   57  119:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   58  122:ldc2            #508 <String "zeropoint">
    //   59  125:aload_3         
    //   60  126:invokevirtual   #493 <Method String ProtectedProperties.getProperty(String, String)>
    //   61  129:ldc2            #502 <String "true">
    //   62  132:invokevirtual   #498 <Method int String.compareTo(String)>
    //   63  135:ifne            142
    //   64  138:iconst_1        
    //   65  139:goto            143
    //   66  142:iconst_0        
    //   67  143:putfield        #445 <Field boolean m_HasZeropoint>
            if(m_IsAveragable || m_HasZeropoint)
    //*  68  146:aload_0         
    //*  69  147:getfield        #442 <Field boolean m_IsAveragable>
    //*  70  150:ifne            160
    //*  71  153:aload_0         
    //*  72  154:getfield        #445 <Field boolean m_HasZeropoint>
    //*  73  157:ifeq            164
                def = "true";
    //   74  160:ldc2            #502 <String "true">
    //   75  163:astore_3        
            m_IsRegular = m_Metadata.getProperty("regular", def).compareTo("true") == 0;
    //   76  164:aload_0         
    //   77  165:aload_0         
    //   78  166:getfield        #241 <Field ProtectedProperties m_Metadata>
    //   79  169:ldc2            #510 <String "regular">
    //   80  172:aload_3         
    //   81  173:invokevirtual   #493 <Method String ProtectedProperties.getProperty(String, String)>
    //   82  176:ldc2            #502 <String "true">
    //   83  179:invokevirtual   #498 <Method int String.compareTo(String)>
    //   84  182:ifne            189
    //   85  185:iconst_1        
    //   86  186:goto            190
    //   87  189:iconst_0        
    //   88  190:putfield        #439 <Field boolean m_IsRegular>
            if(orderString.compareTo("symbolic") == 0)
    //*  89  193:aload_2         
    //*  90  194:ldc2            #500 <String "symbolic">
    //*  91  197:invokevirtual   #498 <Method int String.compareTo(String)>
    //*  92  200:ifne            211
                m_Ordering = 0;
    //   93  203:aload_0         
    //   94  204:iconst_0        
    //   95  205:putfield        #436 <Field int m_Ordering>
            else
    //*  96  208:goto            281
            if(orderString.compareTo("ordered") == 0)
    //*  97  211:aload_2         
    //*  98  212:ldc2            #512 <String "ordered">
    //*  99  215:invokevirtual   #498 <Method int String.compareTo(String)>
    //* 100  218:ifne            229
                m_Ordering = 1;
    //  101  221:aload_0         
    //  102  222:iconst_1        
    //  103  223:putfield        #436 <Field int m_Ordering>
            else
    //* 104  226:goto            281
            if(orderString.compareTo("modulo") == 0)
    //* 105  229:aload_2         
    //* 106  230:ldc2            #495 <String "modulo">
    //* 107  233:invokevirtual   #498 <Method int String.compareTo(String)>
    //* 108  236:ifne            247
                m_Ordering = 2;
    //  109  239:aload_0         
    //  110  240:iconst_2        
    //  111  241:putfield        #436 <Field int m_Ordering>
            else
    //* 112  244:goto            281
            if(m_Type == 0 || m_IsAveragable || m_HasZeropoint)
    //* 113  247:aload_0         
    //* 114  248:getfield        #102 <Field int m_Type>
    //* 115  251:ifeq            268
    //* 116  254:aload_0         
    //* 117  255:getfield        #442 <Field boolean m_IsAveragable>
    //* 118  258:ifne            268
    //* 119  261:aload_0         
    //* 120  262:getfield        #445 <Field boolean m_HasZeropoint>
    //* 121  265:ifeq            276
                m_Ordering = 1;
    //  122  268:aload_0         
    //  123  269:iconst_1        
    //  124  270:putfield        #436 <Field int m_Ordering>
            else
    //* 125  273:goto            281
                m_Ordering = 0;
    //  126  276:aload_0         
    //  127  277:iconst_0        
    //  128  278:putfield        #436 <Field int m_Ordering>
        }
        if(m_IsAveragable && !m_IsRegular)
    //* 129  281:aload_0         
    //* 130  282:getfield        #442 <Field boolean m_IsAveragable>
    //* 131  285:ifeq            306
    //* 132  288:aload_0         
    //* 133  289:getfield        #439 <Field boolean m_IsRegular>
    //* 134  292:ifne            306
            throw new IllegalArgumentException("An averagable attribute must be regular");
    //  135  295:new             #176 <Class IllegalArgumentException>
    //  136  298:dup             
    //  137  299:ldc2            #514 <String "An averagable attribute must be regular">
    //  138  302:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  139  305:athrow          
        if(m_HasZeropoint && !m_IsRegular)
    //* 140  306:aload_0         
    //* 141  307:getfield        #445 <Field boolean m_HasZeropoint>
    //* 142  310:ifeq            331
    //* 143  313:aload_0         
    //* 144  314:getfield        #439 <Field boolean m_IsRegular>
    //* 145  317:ifne            331
            throw new IllegalArgumentException("A zeropoint attribute must be regular");
    //  146  320:new             #176 <Class IllegalArgumentException>
    //  147  323:dup             
    //  148  324:ldc2            #516 <String "A zeropoint attribute must be regular">
    //  149  327:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  150  330:athrow          
        if(m_IsRegular && m_Ordering == 0)
    //* 151  331:aload_0         
    //* 152  332:getfield        #439 <Field boolean m_IsRegular>
    //* 153  335:ifeq            356
    //* 154  338:aload_0         
    //* 155  339:getfield        #436 <Field int m_Ordering>
    //* 156  342:ifne            356
            throw new IllegalArgumentException("A symbolic attribute cannot be regular");
    //  157  345:new             #176 <Class IllegalArgumentException>
    //  158  348:dup             
    //  159  349:ldc2            #518 <String "A symbolic attribute cannot be regular">
    //  160  352:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  161  355:athrow          
        if(m_IsAveragable && m_Ordering != 1)
    //* 162  356:aload_0         
    //* 163  357:getfield        #442 <Field boolean m_IsAveragable>
    //* 164  360:ifeq            382
    //* 165  363:aload_0         
    //* 166  364:getfield        #436 <Field int m_Ordering>
    //* 167  367:iconst_1        
    //* 168  368:icmpeq          382
            throw new IllegalArgumentException("An averagable attribute must be ordered");
    //  169  371:new             #176 <Class IllegalArgumentException>
    //  170  374:dup             
    //  171  375:ldc2            #520 <String "An averagable attribute must be ordered">
    //  172  378:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  173  381:athrow          
        if(m_HasZeropoint && m_Ordering != 1)
    //* 174  382:aload_0         
    //* 175  383:getfield        #445 <Field boolean m_HasZeropoint>
    //* 176  386:ifeq            408
    //* 177  389:aload_0         
    //* 178  390:getfield        #436 <Field int m_Ordering>
    //* 179  393:iconst_1        
    //* 180  394:icmpeq          408
            throw new IllegalArgumentException("A zeropoint attribute must be ordered");
    //  181  397:new             #176 <Class IllegalArgumentException>
    //  182  400:dup             
    //  183  401:ldc2            #522 <String "A zeropoint attribute must be ordered">
    //  184  404:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  185  407:athrow          
        m_Weight = 1.0D;
    //  186  408:aload_0         
    //  187  409:dconst_1        
    //  188  410:putfield        #449 <Field double m_Weight>
        String weightString = m_Metadata.getProperty("weight");
    //  189  413:aload_0         
    //  190  414:getfield        #241 <Field ProtectedProperties m_Metadata>
    //  191  417:ldc2            #455 <String "weight">
    //  192  420:invokevirtual   #458 <Method String ProtectedProperties.getProperty(String)>
    //  193  423:astore_2        
        if(weightString != null)
    //* 194  424:aload_2         
    //* 195  425:ifnull          474
            try
            {
                m_Weight = Double.valueOf(weightString).doubleValue();
    //  196  428:aload_0         
    //  197  429:aload_2         
    //  198  430:invokestatic    #528 <Method Double Double.valueOf(String)>
    //  199  433:invokevirtual   #531 <Method double Double.doubleValue()>
    //  200  436:putfield        #449 <Field double m_Weight>
            }
    //* 201  439:goto            474
            catch(NumberFormatException e)
    //* 202  442:astore_3        
            {
                throw new IllegalArgumentException((new StringBuilder("Not a valid attribute weight: '")).append(weightString).append("'").toString());
    //  203  443:new             #176 <Class IllegalArgumentException>
    //  204  446:dup             
    //  205  447:new             #178 <Class StringBuilder>
    //  206  450:dup             
    //  207  451:ldc2            #533 <String "Not a valid attribute weight: '">
    //  208  454:invokespecial   #181 <Method void StringBuilder(String)>
    //  209  457:aload_2         
    //  210  458:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  211  461:ldc2            #535 <String "'">
    //  212  464:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  213  467:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  214  470:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  215  473:athrow          
            }
        if(m_Type == 0)
    //* 216  474:aload_0         
    //* 217  475:getfield        #102 <Field int m_Type>
    //* 218  478:ifne            495
            setNumericRange(m_Metadata.getProperty("range"));
    //  219  481:aload_0         
    //  220  482:aload_0         
    //  221  483:getfield        #241 <Field ProtectedProperties m_Metadata>
    //  222  486:ldc2            #537 <String "range">
    //  223  489:invokevirtual   #458 <Method String ProtectedProperties.getProperty(String)>
    //  224  492:invokespecial   #540 <Method void setNumericRange(String)>
    //  225  495:return          
    }

    private void setNumericRange(String rangeString)
    {
        m_LowerBound = (-1.0D / 0.0D);
    //    0    0:aload_0         
    //    1    1:ldc2w           #548 <Double (-1.0D / 0.0D)>
    //    2    4:putfield        #472 <Field double m_LowerBound>
        m_LowerBoundIsOpen = false;
    //    3    7:aload_0         
    //    4    8:iconst_0        
    //    5    9:putfield        #475 <Field boolean m_LowerBoundIsOpen>
        m_UpperBound = (1.0D / 0.0D);
    //    6   12:aload_0         
    //    7   13:ldc2w           #550 <Double (1.0D / 0.0D)>
    //    8   16:putfield        #478 <Field double m_UpperBound>
        m_UpperBoundIsOpen = false;
    //    9   19:aload_0         
    //   10   20:iconst_0        
    //   11   21:putfield        #481 <Field boolean m_UpperBoundIsOpen>
        if(rangeString == null)
    //*  12   24:aload_1         
    //*  13   25:ifnonnull       29
            return;
    //   14   28:return          
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(rangeString));
    //   15   29:new             #553 <Class StreamTokenizer>
    //   16   32:dup             
    //   17   33:new             #555 <Class StringReader>
    //   18   36:dup             
    //   19   37:aload_1         
    //   20   38:invokespecial   #556 <Method void StringReader(String)>
    //   21   41:invokespecial   #559 <Method void StreamTokenizer(java.io.Reader)>
    //   22   44:astore_2        
        tokenizer.resetSyntax();
    //   23   45:aload_2         
    //   24   46:invokevirtual   #562 <Method void StreamTokenizer.resetSyntax()>
        tokenizer.whitespaceChars(0, 32);
    //   25   49:aload_2         
    //   26   50:iconst_0        
    //   27   51:bipush          32
    //   28   53:invokevirtual   #566 <Method void StreamTokenizer.whitespaceChars(int, int)>
        tokenizer.wordChars(33, 255);
    //   29   56:aload_2         
    //   30   57:bipush          33
    //   31   59:sipush          255
    //   32   62:invokevirtual   #569 <Method void StreamTokenizer.wordChars(int, int)>
        tokenizer.ordinaryChar(91);
    //   33   65:aload_2         
    //   34   66:bipush          91
    //   35   68:invokevirtual   #572 <Method void StreamTokenizer.ordinaryChar(int)>
        tokenizer.ordinaryChar(40);
    //   36   71:aload_2         
    //   37   72:bipush          40
    //   38   74:invokevirtual   #572 <Method void StreamTokenizer.ordinaryChar(int)>
        tokenizer.ordinaryChar(44);
    //   39   77:aload_2         
    //   40   78:bipush          44
    //   41   80:invokevirtual   #572 <Method void StreamTokenizer.ordinaryChar(int)>
        tokenizer.ordinaryChar(93);
    //   42   83:aload_2         
    //   43   84:bipush          93
    //   44   86:invokevirtual   #572 <Method void StreamTokenizer.ordinaryChar(int)>
        tokenizer.ordinaryChar(41);
    //   45   89:aload_2         
    //   46   90:bipush          41
    //   47   92:invokevirtual   #572 <Method void StreamTokenizer.ordinaryChar(int)>
        try
        {
            tokenizer.nextToken();
    //   48   95:aload_2         
    //   49   96:invokevirtual   #575 <Method int StreamTokenizer.nextToken()>
    //   50   99:pop             
            if(tokenizer.ttype == 91)
    //*  51  100:aload_2         
    //*  52  101:getfield        #578 <Field int StreamTokenizer.ttype>
    //*  53  104:bipush          91
    //*  54  106:icmpne          117
                m_LowerBoundIsOpen = false;
    //   55  109:aload_0         
    //   56  110:iconst_0        
    //   57  111:putfield        #475 <Field boolean m_LowerBoundIsOpen>
            else
    //*  58  114:goto            162
            if(tokenizer.ttype == 40)
    //*  59  117:aload_2         
    //*  60  118:getfield        #578 <Field int StreamTokenizer.ttype>
    //*  61  121:bipush          40
    //*  62  123:icmpne          134
                m_LowerBoundIsOpen = true;
    //   63  126:aload_0         
    //   64  127:iconst_1        
    //   65  128:putfield        #475 <Field boolean m_LowerBoundIsOpen>
            else
    //*  66  131:goto            162
                throw new IllegalArgumentException((new StringBuilder("Expected opening brace on range, found: ")).append(tokenizer.toString()).toString());
    //   67  134:new             #176 <Class IllegalArgumentException>
    //   68  137:dup             
    //   69  138:new             #178 <Class StringBuilder>
    //   70  141:dup             
    //   71  142:ldc2            #580 <String "Expected opening brace on range, found: ">
    //   72  145:invokespecial   #181 <Method void StringBuilder(String)>
    //   73  148:aload_2         
    //   74  149:invokevirtual   #581 <Method String StreamTokenizer.toString()>
    //   75  152:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //   76  155:invokevirtual   #198 <Method String StringBuilder.toString()>
    //   77  158:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   78  161:athrow          
            tokenizer.nextToken();
    //   79  162:aload_2         
    //   80  163:invokevirtual   #575 <Method int StreamTokenizer.nextToken()>
    //   81  166:pop             
            if(tokenizer.ttype != -3)
    //*  82  167:aload_2         
    //*  83  168:getfield        #578 <Field int StreamTokenizer.ttype>
    //*  84  171:bipush          -3
    //*  85  173:icmpeq          204
                throw new IllegalArgumentException((new StringBuilder("Expected lower bound in range, found: ")).append(tokenizer.toString()).toString());
    //   86  176:new             #176 <Class IllegalArgumentException>
    //   87  179:dup             
    //   88  180:new             #178 <Class StringBuilder>
    //   89  183:dup             
    //   90  184:ldc2            #583 <String "Expected lower bound in range, found: ">
    //   91  187:invokespecial   #181 <Method void StringBuilder(String)>
    //   92  190:aload_2         
    //   93  191:invokevirtual   #581 <Method String StreamTokenizer.toString()>
    //   94  194:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //   95  197:invokevirtual   #198 <Method String StringBuilder.toString()>
    //   96  200:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //   97  203:athrow          
            if(tokenizer.sval.compareToIgnoreCase("-inf") == 0)
    //*  98  204:aload_2         
    //*  99  205:getfield        #586 <Field String StreamTokenizer.sval>
    //* 100  208:ldc2            #588 <String "-inf">
    //* 101  211:invokevirtual   #591 <Method int String.compareToIgnoreCase(String)>
    //* 102  214:ifne            227
                m_LowerBound = (-1.0D / 0.0D);
    //  103  217:aload_0         
    //  104  218:ldc2w           #548 <Double (-1.0D / 0.0D)>
    //  105  221:putfield        #472 <Field double m_LowerBound>
            else
    //* 106  224:goto            325
            if(tokenizer.sval.compareToIgnoreCase("+inf") == 0)
    //* 107  227:aload_2         
    //* 108  228:getfield        #586 <Field String StreamTokenizer.sval>
    //* 109  231:ldc2            #593 <String "+inf">
    //* 110  234:invokevirtual   #591 <Method int String.compareToIgnoreCase(String)>
    //* 111  237:ifne            250
                m_LowerBound = (1.0D / 0.0D);
    //  112  240:aload_0         
    //  113  241:ldc2w           #550 <Double (1.0D / 0.0D)>
    //  114  244:putfield        #472 <Field double m_LowerBound>
            else
    //* 115  247:goto            325
            if(tokenizer.sval.compareToIgnoreCase("inf") == 0)
    //* 116  250:aload_2         
    //* 117  251:getfield        #586 <Field String StreamTokenizer.sval>
    //* 118  254:ldc2            #595 <String "inf">
    //* 119  257:invokevirtual   #591 <Method int String.compareToIgnoreCase(String)>
    //* 120  260:ifne            273
                m_LowerBound = (-1.0D / 0.0D);
    //  121  263:aload_0         
    //  122  264:ldc2w           #548 <Double (-1.0D / 0.0D)>
    //  123  267:putfield        #472 <Field double m_LowerBound>
            else
    //* 124  270:goto            325
                try
                {
                    m_LowerBound = Double.valueOf(tokenizer.sval).doubleValue();
    //  125  273:aload_0         
    //  126  274:aload_2         
    //  127  275:getfield        #586 <Field String StreamTokenizer.sval>
    //  128  278:invokestatic    #528 <Method Double Double.valueOf(String)>
    //  129  281:invokevirtual   #531 <Method double Double.doubleValue()>
    //  130  284:putfield        #472 <Field double m_LowerBound>
                }
    //* 131  287:goto            325
                catch(NumberFormatException e)
    //* 132  290:astore_3        
                {
                    throw new IllegalArgumentException((new StringBuilder("Expected lower bound in range, found: '")).append(tokenizer.sval).append("'").toString());
    //  133  291:new             #176 <Class IllegalArgumentException>
    //  134  294:dup             
    //  135  295:new             #178 <Class StringBuilder>
    //  136  298:dup             
    //  137  299:ldc2            #597 <String "Expected lower bound in range, found: '">
    //  138  302:invokespecial   #181 <Method void StringBuilder(String)>
    //  139  305:aload_2         
    //  140  306:getfield        #586 <Field String StreamTokenizer.sval>
    //  141  309:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  142  312:ldc2            #535 <String "'">
    //  143  315:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  144  318:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  145  321:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  146  324:athrow          
                }
            if(tokenizer.nextToken() != 44)
    //* 147  325:aload_2         
    //* 148  326:invokevirtual   #575 <Method int StreamTokenizer.nextToken()>
    //* 149  329:bipush          44
    //* 150  331:icmpeq          362
                throw new IllegalArgumentException((new StringBuilder("Expected comma in range, found: ")).append(tokenizer.toString()).toString());
    //  151  334:new             #176 <Class IllegalArgumentException>
    //  152  337:dup             
    //  153  338:new             #178 <Class StringBuilder>
    //  154  341:dup             
    //  155  342:ldc2            #599 <String "Expected comma in range, found: ">
    //  156  345:invokespecial   #181 <Method void StringBuilder(String)>
    //  157  348:aload_2         
    //  158  349:invokevirtual   #581 <Method String StreamTokenizer.toString()>
    //  159  352:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  160  355:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  161  358:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  162  361:athrow          
            tokenizer.nextToken();
    //  163  362:aload_2         
    //  164  363:invokevirtual   #575 <Method int StreamTokenizer.nextToken()>
    //  165  366:pop             
            if(tokenizer.ttype != -3)
    //* 166  367:aload_2         
    //* 167  368:getfield        #578 <Field int StreamTokenizer.ttype>
    //* 168  371:bipush          -3
    //* 169  373:icmpeq          404
                throw new IllegalArgumentException((new StringBuilder("Expected upper bound in range, found: ")).append(tokenizer.toString()).toString());
    //  170  376:new             #176 <Class IllegalArgumentException>
    //  171  379:dup             
    //  172  380:new             #178 <Class StringBuilder>
    //  173  383:dup             
    //  174  384:ldc2            #601 <String "Expected upper bound in range, found: ">
    //  175  387:invokespecial   #181 <Method void StringBuilder(String)>
    //  176  390:aload_2         
    //  177  391:invokevirtual   #581 <Method String StreamTokenizer.toString()>
    //  178  394:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  179  397:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  180  400:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  181  403:athrow          
            if(tokenizer.sval.compareToIgnoreCase("-inf") == 0)
    //* 182  404:aload_2         
    //* 183  405:getfield        #586 <Field String StreamTokenizer.sval>
    //* 184  408:ldc2            #588 <String "-inf">
    //* 185  411:invokevirtual   #591 <Method int String.compareToIgnoreCase(String)>
    //* 186  414:ifne            427
                m_UpperBound = (-1.0D / 0.0D);
    //  187  417:aload_0         
    //  188  418:ldc2w           #548 <Double (-1.0D / 0.0D)>
    //  189  421:putfield        #478 <Field double m_UpperBound>
            else
    //* 190  424:goto            525
            if(tokenizer.sval.compareToIgnoreCase("+inf") == 0)
    //* 191  427:aload_2         
    //* 192  428:getfield        #586 <Field String StreamTokenizer.sval>
    //* 193  431:ldc2            #593 <String "+inf">
    //* 194  434:invokevirtual   #591 <Method int String.compareToIgnoreCase(String)>
    //* 195  437:ifne            450
                m_UpperBound = (1.0D / 0.0D);
    //  196  440:aload_0         
    //  197  441:ldc2w           #550 <Double (1.0D / 0.0D)>
    //  198  444:putfield        #478 <Field double m_UpperBound>
            else
    //* 199  447:goto            525
            if(tokenizer.sval.compareToIgnoreCase("inf") == 0)
    //* 200  450:aload_2         
    //* 201  451:getfield        #586 <Field String StreamTokenizer.sval>
    //* 202  454:ldc2            #595 <String "inf">
    //* 203  457:invokevirtual   #591 <Method int String.compareToIgnoreCase(String)>
    //* 204  460:ifne            473
                m_UpperBound = (1.0D / 0.0D);
    //  205  463:aload_0         
    //  206  464:ldc2w           #550 <Double (1.0D / 0.0D)>
    //  207  467:putfield        #478 <Field double m_UpperBound>
            else
    //* 208  470:goto            525
                try
                {
                    m_UpperBound = Double.valueOf(tokenizer.sval).doubleValue();
    //  209  473:aload_0         
    //  210  474:aload_2         
    //  211  475:getfield        #586 <Field String StreamTokenizer.sval>
    //  212  478:invokestatic    #528 <Method Double Double.valueOf(String)>
    //  213  481:invokevirtual   #531 <Method double Double.doubleValue()>
    //  214  484:putfield        #478 <Field double m_UpperBound>
                }
    //* 215  487:goto            525
                catch(NumberFormatException e)
    //* 216  490:astore_3        
                {
                    throw new IllegalArgumentException((new StringBuilder("Expected upper bound in range, found: '")).append(tokenizer.sval).append("'").toString());
    //  217  491:new             #176 <Class IllegalArgumentException>
    //  218  494:dup             
    //  219  495:new             #178 <Class StringBuilder>
    //  220  498:dup             
    //  221  499:ldc2            #603 <String "Expected upper bound in range, found: '">
    //  222  502:invokespecial   #181 <Method void StringBuilder(String)>
    //  223  505:aload_2         
    //  224  506:getfield        #586 <Field String StreamTokenizer.sval>
    //  225  509:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  226  512:ldc2            #535 <String "'">
    //  227  515:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  228  518:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  229  521:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  230  524:athrow          
                }
            tokenizer.nextToken();
    //  231  525:aload_2         
    //  232  526:invokevirtual   #575 <Method int StreamTokenizer.nextToken()>
    //  233  529:pop             
            if(tokenizer.ttype == 93)
    //* 234  530:aload_2         
    //* 235  531:getfield        #578 <Field int StreamTokenizer.ttype>
    //* 236  534:bipush          93
    //* 237  536:icmpne          547
                m_UpperBoundIsOpen = false;
    //  238  539:aload_0         
    //  239  540:iconst_0        
    //  240  541:putfield        #481 <Field boolean m_UpperBoundIsOpen>
            else
    //* 241  544:goto            592
            if(tokenizer.ttype == 41)
    //* 242  547:aload_2         
    //* 243  548:getfield        #578 <Field int StreamTokenizer.ttype>
    //* 244  551:bipush          41
    //* 245  553:icmpne          564
                m_UpperBoundIsOpen = true;
    //  246  556:aload_0         
    //  247  557:iconst_1        
    //  248  558:putfield        #481 <Field boolean m_UpperBoundIsOpen>
            else
    //* 249  561:goto            592
                throw new IllegalArgumentException((new StringBuilder("Expected closing brace on range, found: ")).append(tokenizer.toString()).toString());
    //  250  564:new             #176 <Class IllegalArgumentException>
    //  251  567:dup             
    //  252  568:new             #178 <Class StringBuilder>
    //  253  571:dup             
    //  254  572:ldc2            #605 <String "Expected closing brace on range, found: ">
    //  255  575:invokespecial   #181 <Method void StringBuilder(String)>
    //  256  578:aload_2         
    //  257  579:invokevirtual   #581 <Method String StreamTokenizer.toString()>
    //  258  582:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  259  585:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  260  588:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  261  591:athrow          
            if(tokenizer.nextToken() != -1)
    //* 262  592:aload_2         
    //* 263  593:invokevirtual   #575 <Method int StreamTokenizer.nextToken()>
    //* 264  596:iconst_m1       
    //* 265  597:icmpeq          660
                throw new IllegalArgumentException((new StringBuilder("Expected end of range string, found: ")).append(tokenizer.toString()).toString());
    //  266  600:new             #176 <Class IllegalArgumentException>
    //  267  603:dup             
    //  268  604:new             #178 <Class StringBuilder>
    //  269  607:dup             
    //  270  608:ldc2            #607 <String "Expected end of range string, found: ">
    //  271  611:invokespecial   #181 <Method void StringBuilder(String)>
    //  272  614:aload_2         
    //  273  615:invokevirtual   #581 <Method String StreamTokenizer.toString()>
    //  274  618:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  275  621:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  276  624:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  277  627:athrow          
        }
    //* 278  628:goto            660
        catch(IOException e)
    //* 279  631:astore_3        
        {
            throw new IllegalArgumentException((new StringBuilder("IOException reading attribute range string: ")).append(e.getMessage()).toString());
    //  280  632:new             #176 <Class IllegalArgumentException>
    //  281  635:dup             
    //  282  636:new             #178 <Class StringBuilder>
    //  283  639:dup             
    //  284  640:ldc2            #609 <String "IOException reading attribute range string: ">
    //  285  643:invokespecial   #181 <Method void StringBuilder(String)>
    //  286  646:aload_3         
    //  287  647:invokevirtual   #614 <Method String IOException.getMessage()>
    //  288  650:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  289  653:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  290  656:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  291  659:athrow          
        }
        if(m_UpperBound < m_LowerBound)
    //* 292  660:aload_0         
    //* 293  661:getfield        #478 <Field double m_UpperBound>
    //* 294  664:aload_0         
    //* 295  665:getfield        #472 <Field double m_LowerBound>
    //* 296  668:dcmpg           
    //* 297  669:ifge            725
            throw new IllegalArgumentException((new StringBuilder("Upper bound (")).append(m_UpperBound).append(") on numeric range is").append(" less than lower bound (").append(m_LowerBound).append(")!").toString());
    //  298  672:new             #176 <Class IllegalArgumentException>
    //  299  675:dup             
    //  300  676:new             #178 <Class StringBuilder>
    //  301  679:dup             
    //  302  680:ldc2            #616 <String "Upper bound (">
    //  303  683:invokespecial   #181 <Method void StringBuilder(String)>
    //  304  686:aload_0         
    //  305  687:getfield        #478 <Field double m_UpperBound>
    //  306  690:invokevirtual   #466 <Method StringBuilder StringBuilder.append(double)>
    //  307  693:ldc2            #618 <String ") on numeric range is">
    //  308  696:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  309  699:ldc2            #620 <String " less than lower bound (">
    //  310  702:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  311  705:aload_0         
    //  312  706:getfield        #472 <Field double m_LowerBound>
    //  313  709:invokevirtual   #466 <Method StringBuilder StringBuilder.append(double)>
    //  314  712:ldc2            #622 <String ")!">
    //  315  715:invokevirtual   #185 <Method StringBuilder StringBuilder.append(String)>
    //  316  718:invokevirtual   #198 <Method String StringBuilder.toString()>
    //  317  721:invokespecial   #199 <Method void IllegalArgumentException(String)>
    //  318  724:athrow          
        else
            return;
    //  319  725:return          
    }

    public static final int NUMERIC = 0;
    public static final int NOMINAL = 1;
    public static final int STRING = 2;
    public static final int DATE = 3;
    public static final int RELATIONAL = 4;
    public static final int ORDERING_SYMBOLIC = 0;
    public static final int ORDERING_ORDERED = 1;
    public static final int ORDERING_MODULO = 2;
    public static final String ASS_ATTRIBUTE = "@attribute";
    public static final String ASS_ATTRIBUTE_INTEGER = "integer";
    public static final String ASS_ATTRIBUTE_REAL = "real";
    public static final String ASS_ATTRIBUTE_NUMERIC = "numeric";
    public static final String ASS_ATTRIBUTE_STRING = "string";
    public static final String ASS_ATTRIBUTE_DATE = "date";
    public static final String ASS_ATTRIBUTE_RELATIONAL = "relational";
    public static final String ASS_END_SUBRELATION = "@end";
    private static final int STRING_COMPRESS_THRESHOLD = 200;
    private String m_Name;
    private int m_Type;
    private FastVector m_Values;
    private Hashtable m_Hashtable;
    private SimpleDateFormat m_DateFormat;
    private int m_Index;
    private ProtectedProperties m_Metadata;
    private int m_Ordering;
    private boolean m_IsRegular;
    private boolean m_IsAveragable;
    private boolean m_HasZeropoint;
    private double m_Weight;
    private double m_LowerBound;
    private boolean m_LowerBoundIsOpen;
    private double m_UpperBound;
    private boolean m_UpperBoundIsOpen;
}

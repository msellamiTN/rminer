// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ConverterFileChooser.java

package rm.gui;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import rm.core.Capabilities;
import rm.core.converters.*;

// Referenced classes of package rm.gui:
//            ExtensionFileFilter

public class ConverterFileChooser extends JFileChooser
{

    public ConverterFileChooser()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #59  <Method void JFileChooser()>
        m_OverwriteWarning = true;
    //    2    4:aload_0         
    //    3    5:iconst_1        
    //    4    6:putfield        #61  <Field boolean m_OverwriteWarning>
        m_FileMustExist = true;
    //    5    9:aload_0         
    //    6   10:iconst_1        
    //    7   11:putfield        #63  <Field boolean m_FileMustExist>
        m_CoreConvertersOnly = false;
    //    8   14:aload_0         
    //    9   15:iconst_0        
    //   10   16:putfield        #65  <Field boolean m_CoreConvertersOnly>
        m_Self = this;
    //   11   19:aload_0         
    //   12   20:aload_0         
    //   13   21:putfield        #67  <Field ConverterFileChooser m_Self>
    //   14   24:return          
    }

    public ConverterFileChooser(File currentDirectory)
    {
        super(currentDirectory);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #71  <Method void JFileChooser(File)>
        m_OverwriteWarning = true;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #61  <Field boolean m_OverwriteWarning>
        m_FileMustExist = true;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #63  <Field boolean m_FileMustExist>
        m_CoreConvertersOnly = false;
    //    9   15:aload_0         
    //   10   16:iconst_0        
    //   11   17:putfield        #65  <Field boolean m_CoreConvertersOnly>
        m_Self = this;
    //   12   20:aload_0         
    //   13   21:aload_0         
    //   14   22:putfield        #67  <Field ConverterFileChooser m_Self>
    //   15   25:return          
    }

    public ConverterFileChooser(String currentDirectory)
    {
        super(currentDirectory);
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokespecial   #76  <Method void JFileChooser(String)>
        m_OverwriteWarning = true;
    //    3    5:aload_0         
    //    4    6:iconst_1        
    //    5    7:putfield        #61  <Field boolean m_OverwriteWarning>
        m_FileMustExist = true;
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:putfield        #63  <Field boolean m_FileMustExist>
        m_CoreConvertersOnly = false;
    //    9   15:aload_0         
    //   10   16:iconst_0        
    //   11   17:putfield        #65  <Field boolean m_CoreConvertersOnly>
        m_Self = this;
    //   12   20:aload_0         
    //   13   21:aload_0         
    //   14   22:putfield        #67  <Field ConverterFileChooser m_Self>
    //   15   25:return          
    }

    protected Vector filterNonCoreLoaderFileFilters(Vector list)
    {
        Vector result;
        if(!getCoreConvertersOnly())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #84  <Method boolean getCoreConvertersOnly()>
    //*   2    4:ifne            12
        {
            result = list;
    //    3    7:aload_1         
    //    4    8:astore_2        
        } else
    //*   5    9:goto            79
        {
            result = new Vector();
    //    6   12:new             #86  <Class Vector>
    //    7   15:dup             
    //    8   16:invokespecial   #87  <Method void Vector()>
    //    9   19:astore_2        
            for(int i = 0; i < list.size(); i++)
    //*  10   20:iconst_0        
    //*  11   21:istore_3        
    //*  12   22:goto            71
            {
                ExtensionFileFilter filter = (ExtensionFileFilter)list.get(i);
    //   13   25:aload_1         
    //   14   26:iload_3         
    //   15   27:invokevirtual   #91  <Method Object Vector.get(int)>
    //   16   30:checkcast       #93  <Class ExtensionFileFilter>
    //   17   33:astore          4
                rm.core.converters.AbstractLoader loader = ConverterUtils.getLoaderForExtension(filter.getExtensions()[0]);
    //   18   35:aload           4
    //   19   37:invokevirtual   #97  <Method String[] ExtensionFileFilter.getExtensions()>
    //   20   40:iconst_0        
    //   21   41:aaload          
    //   22   42:invokestatic    #101 <Method AbstractFileLoader ConverterUtils.getLoaderForExtension(String)>
    //   23   45:astore          5
                if(ConverterUtils.isCoreFileLoader(loader.getClass().getName()))
    //*  24   47:aload           5
    //*  25   49:invokevirtual   #107 <Method Class Object.getClass()>
    //*  26   52:invokevirtual   #113 <Method String Class.getName()>
    //*  27   55:invokestatic    #117 <Method boolean ConverterUtils.isCoreFileLoader(String)>
    //*  28   58:ifeq            68
                    result.add(filter);
    //   29   61:aload_2         
    //   30   62:aload           4
    //   31   64:invokevirtual   #121 <Method boolean Vector.add(Object)>
    //   32   67:pop             
            }

    //   33   68:iinc            3  1
    //   34   71:iload_3         
    //   35   72:aload_1         
    //   36   73:invokevirtual   #125 <Method int Vector.size()>
    //   37   76:icmplt          25
        }
        return result;
    //   38   79:aload_2         
    //   39   80:areturn         
    }

    protected Vector filterNonCoreSaverFileFilters(Vector list)
    {
        Vector result;
        if(!getCoreConvertersOnly())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #84  <Method boolean getCoreConvertersOnly()>
    //*   2    4:ifne            12
        {
            result = list;
    //    3    7:aload_1         
    //    4    8:astore_2        
        } else
    //*   5    9:goto            79
        {
            result = new Vector();
    //    6   12:new             #86  <Class Vector>
    //    7   15:dup             
    //    8   16:invokespecial   #87  <Method void Vector()>
    //    9   19:astore_2        
            for(int i = 0; i < list.size(); i++)
    //*  10   20:iconst_0        
    //*  11   21:istore_3        
    //*  12   22:goto            71
            {
                ExtensionFileFilter filter = (ExtensionFileFilter)list.get(i);
    //   13   25:aload_1         
    //   14   26:iload_3         
    //   15   27:invokevirtual   #91  <Method Object Vector.get(int)>
    //   16   30:checkcast       #93  <Class ExtensionFileFilter>
    //   17   33:astore          4
                AbstractSaver saver = ConverterUtils.getSaverForExtension(filter.getExtensions()[0]);
    //   18   35:aload           4
    //   19   37:invokevirtual   #97  <Method String[] ExtensionFileFilter.getExtensions()>
    //   20   40:iconst_0        
    //   21   41:aaload          
    //   22   42:invokestatic    #138 <Method AbstractFileSaver ConverterUtils.getSaverForExtension(String)>
    //   23   45:astore          5
                if(ConverterUtils.isCoreFileSaver(saver.getClass().getName()))
    //*  24   47:aload           5
    //*  25   49:invokevirtual   #107 <Method Class Object.getClass()>
    //*  26   52:invokevirtual   #113 <Method String Class.getName()>
    //*  27   55:invokestatic    #141 <Method boolean ConverterUtils.isCoreFileSaver(String)>
    //*  28   58:ifeq            68
                    result.add(filter);
    //   29   61:aload_2         
    //   30   62:aload           4
    //   31   64:invokevirtual   #121 <Method boolean Vector.add(Object)>
    //   32   67:pop             
            }

    //   33   68:iinc            3  1
    //   34   71:iload_3         
    //   35   72:aload_1         
    //   36   73:invokevirtual   #125 <Method int Vector.size()>
    //   37   76:icmplt          25
        }
        return result;
    //   38   79:aload_2         
    //   39   80:areturn         
    }

    protected Vector filterSaverFileFilters(Vector list)
    {
        Vector result;
        if(m_CapabilitiesFilter == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #146 <Field Capabilities m_CapabilitiesFilter>
    //*   2    4:ifnonnull       12
        {
            result = list;
    //    3    7:aload_1         
    //    4    8:astore_2        
        } else
    //*   5    9:goto            80
        {
            result = new Vector();
    //    6   12:new             #86  <Class Vector>
    //    7   15:dup             
    //    8   16:invokespecial   #87  <Method void Vector()>
    //    9   19:astore_2        
            for(int i = 0; i < list.size(); i++)
    //*  10   20:iconst_0        
    //*  11   21:istore_3        
    //*  12   22:goto            72
            {
                ExtensionFileFilter filter = (ExtensionFileFilter)list.get(i);
    //   13   25:aload_1         
    //   14   26:iload_3         
    //   15   27:invokevirtual   #91  <Method Object Vector.get(int)>
    //   16   30:checkcast       #93  <Class ExtensionFileFilter>
    //   17   33:astore          4
                AbstractSaver saver = ConverterUtils.getSaverForExtension(filter.getExtensions()[0]);
    //   18   35:aload           4
    //   19   37:invokevirtual   #97  <Method String[] ExtensionFileFilter.getExtensions()>
    //   20   40:iconst_0        
    //   21   41:aaload          
    //   22   42:invokestatic    #138 <Method AbstractFileSaver ConverterUtils.getSaverForExtension(String)>
    //   23   45:astore          5
                if(saver.getCapabilities().supports(m_CapabilitiesFilter))
    //*  24   47:aload           5
    //*  25   49:invokevirtual   #152 <Method Capabilities AbstractSaver.getCapabilities()>
    //*  26   52:aload_0         
    //*  27   53:getfield        #146 <Field Capabilities m_CapabilitiesFilter>
    //*  28   56:invokevirtual   #158 <Method boolean Capabilities.supports(Capabilities)>
    //*  29   59:ifeq            69
                    result.add(filter);
    //   30   62:aload_2         
    //   31   63:aload           4
    //   32   65:invokevirtual   #121 <Method boolean Vector.add(Object)>
    //   33   68:pop             
            }

    //   34   69:iinc            3  1
    //   35   72:iload_3         
    //   36   73:aload_1         
    //   37   74:invokevirtual   #125 <Method int Vector.size()>
    //   38   77:icmplt          25
        }
        return result;
    //   39   80:aload_2         
    //   40   81:areturn         
    }

    protected static void initFilters(boolean loader, Vector classnames)
    {
        if(loader)
    //*   0    0:iload_0         
    //*   1    1:ifeq            17
            m_LoaderFileFilters = new Vector();
    //    2    4:new             #86  <Class Vector>
    //    3    7:dup             
    //    4    8:invokespecial   #87  <Method void Vector()>
    //    5   11:putstatic       #161 <Field Vector m_LoaderFileFilters>
        else
    //*   6   14:goto            27
            m_SaverFileFilters = new Vector();
    //    7   17:new             #86  <Class Vector>
    //    8   20:dup             
    //    9   21:invokespecial   #87  <Method void Vector()>
    //   10   24:putstatic       #163 <Field Vector m_SaverFileFilters>
        for(int i = 0; i < classnames.size(); i++)
    //*  11   27:iconst_0        
    //*  12   28:istore_2        
    //*  13   29:goto            257
        {
            String classname = (String)classnames.get(i);
    //   14   32:aload_1         
    //   15   33:iload_2         
    //   16   34:invokevirtual   #91  <Method Object Vector.get(int)>
    //   17   37:checkcast       #165 <Class String>
    //   18   40:astore          4
            String ext[];
            String desc;
            FileSourcedConverter converter;
            try
            {
                Class cls = Class.forName(classname);
    //   19   42:aload           4
    //   20   44:invokestatic    #169 <Method Class Class.forName(String)>
    //   21   47:astore          5
                converter = (FileSourcedConverter)(FileSourcedConverter)cls.newInstance();
    //   22   49:aload           5
    //   23   51:invokevirtual   #173 <Method Object Class.newInstance()>
    //   24   54:checkcast       #175 <Class FileSourcedConverter>
    //   25   57:checkcast       #175 <Class FileSourcedConverter>
    //   26   60:astore          8
                ext = converter.getFileExtensions();
    //   27   62:aload           8
    //   28   64:invokeinterface #178 <Method String[] FileSourcedConverter.getFileExtensions()>
    //   29   69:astore          6
                desc = converter.getFileDescription();
    //   30   71:aload           8
    //   31   73:invokeinterface #181 <Method String FileSourcedConverter.getFileDescription()>
    //   32   78:astore          7
            }
    //*  33   80:goto            101
            catch(Exception e)
    //*  34   83:astore          10
            {
                Class cls = null;
    //   35   85:aconst_null     
    //   36   86:astore          5
                converter = null;
    //   37   88:aconst_null     
    //   38   89:astore          8
                ext = new String[0];
    //   39   91:iconst_0        
    //   40   92:anewarray       String[]
    //   41   95:astore          6
                desc = "";
    //   42   97:ldc1            #183 <String "">
    //   43   99:astore          7
            }
            if(converter != null)
    //*  44  101:aload           8
    //*  45  103:ifnonnull       109
    //*  46  106:goto            254
                if(loader)
    //*  47  109:iload_0         
    //*  48  110:ifeq            185
                {
                    for(int n = 0; n < ext.length; n++)
    //*  49  113:iconst_0        
    //*  50  114:istore_3        
    //*  51  115:goto            175
                    {
                        ExtensionFileFilter filter = new ExtensionFileFilter(ext[n], (new StringBuilder(String.valueOf(desc))).append(" (*").append(ext[n]).append(")").toString());
    //   52  118:new             #93  <Class ExtensionFileFilter>
    //   53  121:dup             
    //   54  122:aload           6
    //   55  124:iload_3         
    //   56  125:aaload          
    //   57  126:new             #185 <Class StringBuilder>
    //   58  129:dup             
    //   59  130:aload           7
    //   60  132:invokestatic    #189 <Method String String.valueOf(Object)>
    //   61  135:invokespecial   #190 <Method void StringBuilder(String)>
    //   62  138:ldc1            #192 <String " (*">
    //   63  140:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   64  143:aload           6
    //   65  145:iload_3         
    //   66  146:aaload          
    //   67  147:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   68  150:ldc1            #198 <String ")">
    //   69  152:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   70  155:invokevirtual   #201 <Method String StringBuilder.toString()>
    //   71  158:invokespecial   #204 <Method void ExtensionFileFilter(String, String)>
    //   72  161:astore          9
                        m_LoaderFileFilters.add(filter);
    //   73  163:getstatic       #161 <Field Vector m_LoaderFileFilters>
    //   74  166:aload           9
    //   75  168:invokevirtual   #121 <Method boolean Vector.add(Object)>
    //   76  171:pop             
                    }

    //   77  172:iinc            3  1
    //   78  175:iload_3         
    //   79  176:aload           6
    //   80  178:arraylength     
    //   81  179:icmplt          118
                } else
    //*  82  182:goto            254
                {
                    for(int n = 0; n < ext.length; n++)
    //*  83  185:iconst_0        
    //*  84  186:istore_3        
    //*  85  187:goto            247
                    {
                        ExtensionFileFilter filter = new ExtensionFileFilter(ext[n], (new StringBuilder(String.valueOf(desc))).append(" (*").append(ext[n]).append(")").toString());
    //   86  190:new             #93  <Class ExtensionFileFilter>
    //   87  193:dup             
    //   88  194:aload           6
    //   89  196:iload_3         
    //   90  197:aaload          
    //   91  198:new             #185 <Class StringBuilder>
    //   92  201:dup             
    //   93  202:aload           7
    //   94  204:invokestatic    #189 <Method String String.valueOf(Object)>
    //   95  207:invokespecial   #190 <Method void StringBuilder(String)>
    //   96  210:ldc1            #192 <String " (*">
    //   97  212:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   98  215:aload           6
    //   99  217:iload_3         
    //  100  218:aaload          
    //  101  219:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //  102  222:ldc1            #198 <String ")">
    //  103  224:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //  104  227:invokevirtual   #201 <Method String StringBuilder.toString()>
    //  105  230:invokespecial   #204 <Method void ExtensionFileFilter(String, String)>
    //  106  233:astore          9
                        m_SaverFileFilters.add(filter);
    //  107  235:getstatic       #163 <Field Vector m_SaverFileFilters>
    //  108  238:aload           9
    //  109  240:invokevirtual   #121 <Method boolean Vector.add(Object)>
    //  110  243:pop             
                    }

    //  111  244:iinc            3  1
    //  112  247:iload_3         
    //  113  248:aload           6
    //  114  250:arraylength     
    //  115  251:icmplt          190
                }
        }

    //  116  254:iinc            2  1
    //  117  257:iload_2         
    //  118  258:aload_1         
    //  119  259:invokevirtual   #125 <Method int Vector.size()>
    //  120  262:icmplt          32
    //  121  265:return          
    }

    protected void initGUI(int dialogType)
    {
        boolean acceptAll = isAcceptAllFileFilterUsed();
    //    0    0:aload_0         
    //    1    1:invokevirtual   #224 <Method boolean isAcceptAllFileFilterUsed()>
    //    2    4:istore          4
        resetChoosableFileFilters();
    //    3    6:aload_0         
    //    4    7:invokevirtual   #227 <Method void resetChoosableFileFilters()>
        setAcceptAllFileFilterUsed(acceptAll);
    //    5   10:aload_0         
    //    6   11:iload           4
    //    7   13:invokevirtual   #231 <Method void setAcceptAllFileFilterUsed(boolean)>
        Vector list;
        if(dialogType == 1)
    //*   8   16:iload_1         
    //*   9   17:iconst_1        
    //*  10   18:icmpne          32
            list = filterNonCoreLoaderFileFilters(m_LoaderFileFilters);
    //   11   21:aload_0         
    //   12   22:getstatic       #161 <Field Vector m_LoaderFileFilters>
    //   13   25:invokevirtual   #233 <Method Vector filterNonCoreLoaderFileFilters(Vector)>
    //   14   28:astore_2        
        else
    //*  15   29:goto            44
            list = filterSaverFileFilters(filterNonCoreSaverFileFilters(m_SaverFileFilters));
    //   16   32:aload_0         
    //   17   33:aload_0         
    //   18   34:getstatic       #163 <Field Vector m_SaverFileFilters>
    //   19   37:invokevirtual   #235 <Method Vector filterNonCoreSaverFileFilters(Vector)>
    //   20   40:invokevirtual   #237 <Method Vector filterSaverFileFilters(Vector)>
    //   21   43:astore_2        
        for(int i = 0; i < list.size(); i++)
    //*  22   44:iconst_0        
    //*  23   45:istore_3        
    //*  24   46:goto            64
            addChoosableFileFilter((FileFilter)list.get(i));
    //   25   49:aload_0         
    //   26   50:aload_2         
    //   27   51:iload_3         
    //   28   52:invokevirtual   #91  <Method Object Vector.get(int)>
    //   29   55:checkcast       #239 <Class FileFilter>
    //   30   58:invokevirtual   #243 <Method void addChoosableFileFilter(FileFilter)>

    //   31   61:iinc            3  1
    //   32   64:iload_3         
    //   33   65:aload_2         
    //   34   66:invokevirtual   #125 <Method int Vector.size()>
    //   35   69:icmplt          49
        if(list.size() > 0)
    //*  36   72:aload_2         
    //*  37   73:invokevirtual   #125 <Method int Vector.size()>
    //*  38   76:ifle            120
            if(m_LastFilter == null || !list.contains(m_LastFilter))
    //*  39   79:aload_0         
    //*  40   80:getfield        #245 <Field FileFilter m_LastFilter>
    //*  41   83:ifnull          97
    //*  42   86:aload_2         
    //*  43   87:aload_0         
    //*  44   88:getfield        #245 <Field FileFilter m_LastFilter>
    //*  45   91:invokevirtual   #248 <Method boolean Vector.contains(Object)>
    //*  46   94:ifne            112
                setFileFilter((FileFilter)list.get(0));
    //   47   97:aload_0         
    //   48   98:aload_2         
    //   49   99:iconst_0        
    //   50  100:invokevirtual   #91  <Method Object Vector.get(int)>
    //   51  103:checkcast       #239 <Class FileFilter>
    //   52  106:invokevirtual   #251 <Method void setFileFilter(FileFilter)>
            else
    //*  53  109:goto            120
                setFileFilter(m_LastFilter);
    //   54  112:aload_0         
    //   55  113:aload_0         
    //   56  114:getfield        #245 <Field FileFilter m_LastFilter>
    //   57  117:invokevirtual   #251 <Method void setFileFilter(FileFilter)>
        if(m_Listener != null)
    //*  58  120:aload_0         
    //*  59  121:getfield        #253 <Field PropertyChangeListener m_Listener>
    //*  60  124:ifnull          135
            removePropertyChangeListener(m_Listener);
    //   61  127:aload_0         
    //   62  128:aload_0         
    //   63  129:getfield        #253 <Field PropertyChangeListener m_Listener>
    //   64  132:invokevirtual   #257 <Method void removePropertyChangeListener(PropertyChangeListener)>
        m_Listener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt)
            {
                if(evt.getPropertyName().equals("fileFilterChanged"))
            //*   0    0:aload_1         
            //*   1    1:invokevirtual   #28  <Method String PropertyChangeEvent.getPropertyName()>
            //*   2    4:ldc1            #30  <String "fileFilterChanged">
            //*   3    6:invokevirtual   #36  <Method boolean String.equals(Object)>
            //*   4    9:ifeq            19
                    updateCurrentConverter();
            //    5   12:aload_0         
            //    6   13:getfield        #13  <Field ConverterFileChooser this$0>
            //    7   16:invokevirtual   #41  <Method void ConverterFileChooser.updateCurrentConverter()>
            //    8   19:return          
            }

            final ConverterFileChooser this$0;

            
            {
                this$0 = ConverterFileChooser.this;
            //    0    0:aload_0         
            //    1    1:aload_1         
            //    2    2:putfield        #13  <Field ConverterFileChooser this$0>
                super();
            //    3    5:aload_0         
            //    4    6:invokespecial   #16  <Method void Object()>
            //    5    9:return          
            }
        }
;
    //   65  135:aload_0         
    //   66  136:new             #259 <Class ConverterFileChooser$1>
    //   67  139:dup             
    //   68  140:aload_0         
    //   69  141:invokespecial   #262 <Method void ConverterFileChooser$1(ConverterFileChooser)>
    //   70  144:putfield        #253 <Field PropertyChangeListener m_Listener>
        addPropertyChangeListener(m_Listener);
    //   71  147:aload_0         
    //   72  148:aload_0         
    //   73  149:getfield        #253 <Field PropertyChangeListener m_Listener>
    //   74  152:invokevirtual   #265 <Method void addPropertyChangeListener(PropertyChangeListener)>
        updateCurrentConverter();
    //   75  155:aload_0         
    //   76  156:invokevirtual   #268 <Method void updateCurrentConverter()>
    //   77  159:return          
    }

    public void setCapabilitiesFilter(Capabilities value)
    {
        m_CapabilitiesFilter = (Capabilities)value.clone();
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #275 <Method Object Capabilities.clone()>
    //    3    5:checkcast       #154 <Class Capabilities>
    //    4    8:putfield        #146 <Field Capabilities m_CapabilitiesFilter>
    //    5   11:return          
    }

    public Capabilities getCapabilitiesFilter()
    {
        if(m_CapabilitiesFilter != null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #146 <Field Capabilities m_CapabilitiesFilter>
    //*   2    4:ifnull          18
            return (Capabilities)m_CapabilitiesFilter.clone();
    //    3    7:aload_0         
    //    4    8:getfield        #146 <Field Capabilities m_CapabilitiesFilter>
    //    5   11:invokevirtual   #275 <Method Object Capabilities.clone()>
    //    6   14:checkcast       #154 <Class Capabilities>
    //    7   17:areturn         
        else
            return null;
    //    8   18:aconst_null     
    //    9   19:areturn         
    }

    public void setOverwriteWarning(boolean value)
    {
        m_OverwriteWarning = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #61  <Field boolean m_OverwriteWarning>
    //    3    5:return          
    }

    public boolean getOverwriteWarning()
    {
        return m_OverwriteWarning;
    //    0    0:aload_0         
    //    1    1:getfield        #61  <Field boolean m_OverwriteWarning>
    //    2    4:ireturn         
    }

    public void setFileMustExist(boolean value)
    {
        m_FileMustExist = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #63  <Field boolean m_FileMustExist>
    //    3    5:return          
    }

    public boolean getFileMustExist()
    {
        return m_FileMustExist;
    //    0    0:aload_0         
    //    1    1:getfield        #63  <Field boolean m_FileMustExist>
    //    2    4:ireturn         
    }

    public void setCoreConvertersOnly(boolean value)
    {
        m_CoreConvertersOnly = value;
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #65  <Field boolean m_CoreConvertersOnly>
    //    3    5:return          
    }

    public boolean getCoreConvertersOnly()
    {
        return m_CoreConvertersOnly;
    //    0    0:aload_0         
    //    1    1:getfield        #65  <Field boolean m_CoreConvertersOnly>
    //    2    4:ireturn         
    }

    public int showDialog(Component parent, String approveButtonText)
    {
        if(m_DialogType == 0)
    //*   0    0:aload_0         
    //*   1    1:getfield        #286 <Field int m_DialogType>
    //*   2    4:ifne            18
            throw new IllegalStateException("Either use showOpenDialog or showSaveDialog!");
    //    3    7:new             #288 <Class IllegalStateException>
    //    4   10:dup             
    //    5   11:ldc2            #290 <String "Either use showOpenDialog or showSaveDialog!">
    //    6   14:invokespecial   #291 <Method void IllegalStateException(String)>
    //    7   17:athrow          
        else
            return super.showDialog(parent, approveButtonText);
    //    8   18:aload_0         
    //    9   19:aload_1         
    //   10   20:aload_2         
    //   11   21:invokespecial   #293 <Method int JFileChooser.showDialog(Component, String)>
    //   12   24:ireturn         
    }

    public int showOpenDialog(Component parent)
    {
        m_DialogType = 1;
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:putfield        #286 <Field int m_DialogType>
        m_CurrentConverter = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #300 <Field Object m_CurrentConverter>
        initGUI(1);
    //    6   10:aload_0         
    //    7   11:iconst_1        
    //    8   12:invokevirtual   #302 <Method void initGUI(int)>
        int result = super.showOpenDialog(parent);
    //    9   15:aload_0         
    //   10   16:aload_1         
    //   11   17:invokespecial   #304 <Method int JFileChooser.showOpenDialog(Component)>
    //   12   20:istore_2        
        m_DialogType = 0;
    //   13   21:aload_0         
    //   14   22:iconst_0        
    //   15   23:putfield        #286 <Field int m_DialogType>
        removePropertyChangeListener(m_Listener);
    //   16   26:aload_0         
    //   17   27:aload_0         
    //   18   28:getfield        #253 <Field PropertyChangeListener m_Listener>
    //   19   31:invokevirtual   #257 <Method void removePropertyChangeListener(PropertyChangeListener)>
        if(result == 0 && getSelectedFile().isFile() && (getFileFilter() instanceof ExtensionFileFilter))
    //*  20   34:iload_2         
    //*  21   35:ifne            123
    //*  22   38:aload_0         
    //*  23   39:invokevirtual   #308 <Method File getSelectedFile()>
    //*  24   42:invokevirtual   #313 <Method boolean File.isFile()>
    //*  25   45:ifeq            123
    //*  26   48:aload_0         
    //*  27   49:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //*  28   52:instanceof      #93  <Class ExtensionFileFilter>
    //*  29   55:ifeq            123
        {
            String filename = getSelectedFile().getAbsolutePath();
    //   30   58:aload_0         
    //   31   59:invokevirtual   #308 <Method File getSelectedFile()>
    //   32   62:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //   33   65:astore_3        
            String extensions[] = ((ExtensionFileFilter)getFileFilter()).getExtensions();
    //   34   66:aload_0         
    //   35   67:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //   36   70:checkcast       #93  <Class ExtensionFileFilter>
    //   37   73:invokevirtual   #97  <Method String[] ExtensionFileFilter.getExtensions()>
    //   38   76:astore          4
            if(!filename.endsWith(extensions[0]))
    //*  39   78:aload_3         
    //*  40   79:aload           4
    //*  41   81:iconst_0        
    //*  42   82:aaload          
    //*  43   83:invokevirtual   #323 <Method boolean String.endsWith(String)>
    //*  44   86:ifne            123
            {
                filename = (new StringBuilder(String.valueOf(filename))).append(extensions[0]).toString();
    //   45   89:new             #185 <Class StringBuilder>
    //   46   92:dup             
    //   47   93:aload_3         
    //   48   94:invokestatic    #189 <Method String String.valueOf(Object)>
    //   49   97:invokespecial   #190 <Method void StringBuilder(String)>
    //   50  100:aload           4
    //   51  102:iconst_0        
    //   52  103:aaload          
    //   53  104:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   54  107:invokevirtual   #201 <Method String StringBuilder.toString()>
    //   55  110:astore_3        
                setSelectedFile(new File(filename));
    //   56  111:aload_0         
    //   57  112:new             #310 <Class File>
    //   58  115:dup             
    //   59  116:aload_3         
    //   60  117:invokespecial   #324 <Method void File(String)>
    //   61  120:invokevirtual   #327 <Method void setSelectedFile(File)>
            }
        }
        if(result == 0 && getFileMustExist() && getSelectedFile().isFile() && !getSelectedFile().exists())
    //*  62  123:iload_2         
    //*  63  124:ifne            200
    //*  64  127:aload_0         
    //*  65  128:invokevirtual   #329 <Method boolean getFileMustExist()>
    //*  66  131:ifeq            200
    //*  67  134:aload_0         
    //*  68  135:invokevirtual   #308 <Method File getSelectedFile()>
    //*  69  138:invokevirtual   #313 <Method boolean File.isFile()>
    //*  70  141:ifeq            200
    //*  71  144:aload_0         
    //*  72  145:invokevirtual   #308 <Method File getSelectedFile()>
    //*  73  148:invokevirtual   #332 <Method boolean File.exists()>
    //*  74  151:ifne            200
        {
            int retVal = JOptionPane.showConfirmDialog(parent, (new StringBuilder("The file '")).append(getSelectedFile()).append("' does not exist - please select again!").toString());
    //   75  154:aload_1         
    //   76  155:new             #185 <Class StringBuilder>
    //   77  158:dup             
    //   78  159:ldc2            #334 <String "The file '">
    //   79  162:invokespecial   #190 <Method void StringBuilder(String)>
    //   80  165:aload_0         
    //   81  166:invokevirtual   #308 <Method File getSelectedFile()>
    //   82  169:invokevirtual   #337 <Method StringBuilder StringBuilder.append(Object)>
    //   83  172:ldc2            #339 <String "' does not exist - please select again!">
    //   84  175:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   85  178:invokevirtual   #201 <Method String StringBuilder.toString()>
    //   86  181:invokestatic    #345 <Method int JOptionPane.showConfirmDialog(Component, Object)>
    //   87  184:istore_3        
            if(retVal == 0)
    //*  88  185:iload_3         
    //*  89  186:ifne            198
                result = showOpenDialog(parent);
    //   90  189:aload_0         
    //   91  190:aload_1         
    //   92  191:invokevirtual   #346 <Method int showOpenDialog(Component)>
    //   93  194:istore_2        
            else
    //*  94  195:goto            200
                result = 1;
    //   95  198:iconst_1        
    //   96  199:istore_2        
        }
        if(result == 0)
    //*  97  200:iload_2         
    //*  98  201:ifne            217
        {
            m_LastFilter = getFileFilter();
    //   99  204:aload_0         
    //  100  205:aload_0         
    //  101  206:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //  102  209:putfield        #245 <Field FileFilter m_LastFilter>
            configureCurrentConverter(1);
    //  103  212:aload_0         
    //  104  213:iconst_1        
    //  105  214:invokevirtual   #349 <Method void configureCurrentConverter(int)>
        }
        return result;
    //  106  217:iload_2         
    //  107  218:ireturn         
    }

    public int showSaveDialog(Component parent)
    {
        m_DialogType = 2;
    //    0    0:aload_0         
    //    1    1:iconst_2        
    //    2    2:putfield        #286 <Field int m_DialogType>
        m_CurrentConverter = null;
    //    3    5:aload_0         
    //    4    6:aconst_null     
    //    5    7:putfield        #300 <Field Object m_CurrentConverter>
        initGUI(2);
    //    6   10:aload_0         
    //    7   11:iconst_2        
    //    8   12:invokevirtual   #302 <Method void initGUI(int)>
        boolean acceptAll = isAcceptAllFileFilterUsed();
    //    9   15:aload_0         
    //   10   16:invokevirtual   #224 <Method boolean isAcceptAllFileFilterUsed()>
    //   11   19:istore_2        
        FileFilter currentFilter = getFileFilter();
    //   12   20:aload_0         
    //   13   21:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //   14   24:astore_3        
        File currentFile = getSelectedFile();
    //   15   25:aload_0         
    //   16   26:invokevirtual   #308 <Method File getSelectedFile()>
    //   17   29:astore          4
        setAcceptAllFileFilterUsed(false);
    //   18   31:aload_0         
    //   19   32:iconst_0        
    //   20   33:invokevirtual   #231 <Method void setAcceptAllFileFilterUsed(boolean)>
        setFileFilter(currentFilter);
    //   21   36:aload_0         
    //   22   37:aload_3         
    //   23   38:invokevirtual   #251 <Method void setFileFilter(FileFilter)>
        setSelectedFile(currentFile);
    //   24   41:aload_0         
    //   25   42:aload           4
    //   26   44:invokevirtual   #327 <Method void setSelectedFile(File)>
        int result = super.showSaveDialog(parent);
    //   27   47:aload_0         
    //   28   48:aload_1         
    //   29   49:invokespecial   #355 <Method int JFileChooser.showSaveDialog(Component)>
    //   30   52:istore          5
        if(result == 0 && (getFileFilter() instanceof ExtensionFileFilter))
    //*  31   54:iload           5
    //*  32   56:ifne            139
    //*  33   59:aload_0         
    //*  34   60:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //*  35   63:instanceof      #93  <Class ExtensionFileFilter>
    //*  36   66:ifeq            139
        {
            String filename = getSelectedFile().getAbsolutePath();
    //   37   69:aload_0         
    //   38   70:invokevirtual   #308 <Method File getSelectedFile()>
    //   39   73:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //   40   76:astore          6
            String extensions[] = ((ExtensionFileFilter)getFileFilter()).getExtensions();
    //   41   78:aload_0         
    //   42   79:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //   43   82:checkcast       #93  <Class ExtensionFileFilter>
    //   44   85:invokevirtual   #97  <Method String[] ExtensionFileFilter.getExtensions()>
    //   45   88:astore          7
            if(!filename.endsWith(extensions[0]))
    //*  46   90:aload           6
    //*  47   92:aload           7
    //*  48   94:iconst_0        
    //*  49   95:aaload          
    //*  50   96:invokevirtual   #323 <Method boolean String.endsWith(String)>
    //*  51   99:ifne            139
            {
                filename = (new StringBuilder(String.valueOf(filename))).append(extensions[0]).toString();
    //   52  102:new             #185 <Class StringBuilder>
    //   53  105:dup             
    //   54  106:aload           6
    //   55  108:invokestatic    #189 <Method String String.valueOf(Object)>
    //   56  111:invokespecial   #190 <Method void StringBuilder(String)>
    //   57  114:aload           7
    //   58  116:iconst_0        
    //   59  117:aaload          
    //   60  118:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //   61  121:invokevirtual   #201 <Method String StringBuilder.toString()>
    //   62  124:astore          6
                setSelectedFile(new File(filename));
    //   63  126:aload_0         
    //   64  127:new             #310 <Class File>
    //   65  130:dup             
    //   66  131:aload           6
    //   67  133:invokespecial   #324 <Method void File(String)>
    //   68  136:invokevirtual   #327 <Method void setSelectedFile(File)>
            }
        }
        currentFilter = getFileFilter();
    //   69  139:aload_0         
    //   70  140:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //   71  143:astore_3        
        currentFile = getSelectedFile();
    //   72  144:aload_0         
    //   73  145:invokevirtual   #308 <Method File getSelectedFile()>
    //   74  148:astore          4
        setAcceptAllFileFilterUsed(acceptAll);
    //   75  150:aload_0         
    //   76  151:iload_2         
    //   77  152:invokevirtual   #231 <Method void setAcceptAllFileFilterUsed(boolean)>
        setFileFilter(currentFilter);
    //   78  155:aload_0         
    //   79  156:aload_3         
    //   80  157:invokevirtual   #251 <Method void setFileFilter(FileFilter)>
        setSelectedFile(currentFile);
    //   81  160:aload_0         
    //   82  161:aload           4
    //   83  163:invokevirtual   #327 <Method void setSelectedFile(File)>
        m_DialogType = 0;
    //   84  166:aload_0         
    //   85  167:iconst_0        
    //   86  168:putfield        #286 <Field int m_DialogType>
        removePropertyChangeListener(m_Listener);
    //   87  171:aload_0         
    //   88  172:aload_0         
    //   89  173:getfield        #253 <Field PropertyChangeListener m_Listener>
    //   90  176:invokevirtual   #257 <Method void removePropertyChangeListener(PropertyChangeListener)>
        if(result == 0 && getOverwriteWarning() && getSelectedFile().exists())
    //*  91  179:iload           5
    //*  92  181:ifne            263
    //*  93  184:aload_0         
    //*  94  185:invokevirtual   #357 <Method boolean getOverwriteWarning()>
    //*  95  188:ifeq            263
    //*  96  191:aload_0         
    //*  97  192:invokevirtual   #308 <Method File getSelectedFile()>
    //*  98  195:invokevirtual   #332 <Method boolean File.exists()>
    //*  99  198:ifeq            263
        {
            int retVal = JOptionPane.showConfirmDialog(parent, (new StringBuilder("The file '")).append(getSelectedFile()).append("' already exists - overwrite it?").toString());
    //  100  201:aload_1         
    //  101  202:new             #185 <Class StringBuilder>
    //  102  205:dup             
    //  103  206:ldc2            #334 <String "The file '">
    //  104  209:invokespecial   #190 <Method void StringBuilder(String)>
    //  105  212:aload_0         
    //  106  213:invokevirtual   #308 <Method File getSelectedFile()>
    //  107  216:invokevirtual   #337 <Method StringBuilder StringBuilder.append(Object)>
    //  108  219:ldc2            #359 <String "' already exists - overwrite it?">
    //  109  222:invokevirtual   #196 <Method StringBuilder StringBuilder.append(String)>
    //  110  225:invokevirtual   #201 <Method String StringBuilder.toString()>
    //  111  228:invokestatic    #345 <Method int JOptionPane.showConfirmDialog(Component, Object)>
    //  112  231:istore          6
            if(retVal == 0)
    //* 113  233:iload           6
    //* 114  235:ifne            244
                result = 0;
    //  115  238:iconst_0        
    //  116  239:istore          5
            else
    //* 117  241:goto            263
            if(retVal == 1)
    //* 118  244:iload           6
    //* 119  246:iconst_1        
    //* 120  247:icmpne          260
                result = showSaveDialog(parent);
    //  121  250:aload_0         
    //  122  251:aload_1         
    //  123  252:invokevirtual   #360 <Method int showSaveDialog(Component)>
    //  124  255:istore          5
            else
    //* 125  257:goto            263
                result = 1;
    //  126  260:iconst_1        
    //  127  261:istore          5
        }
        if(result == 0)
    //* 128  263:iload           5
    //* 129  265:ifne            281
        {
            m_LastFilter = getFileFilter();
    //  130  268:aload_0         
    //  131  269:aload_0         
    //  132  270:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //  133  273:putfield        #245 <Field FileFilter m_LastFilter>
            configureCurrentConverter(2);
    //  134  276:aload_0         
    //  135  277:iconst_2        
    //  136  278:invokevirtual   #349 <Method void configureCurrentConverter(int)>
        }
        return result;
    //  137  281:iload           5
    //  138  283:ireturn         
    }

    public AbstractFileLoader getLoader()
    {
        configureCurrentConverter(1);
    //    0    0:aload_0         
    //    1    1:iconst_1        
    //    2    2:invokevirtual   #349 <Method void configureCurrentConverter(int)>
        if(m_CurrentConverter instanceof AbstractFileSaver)
    //*   3    5:aload_0         
    //*   4    6:getfield        #300 <Field Object m_CurrentConverter>
    //*   5    9:instanceof      #366 <Class AbstractFileSaver>
    //*   6   12:ifeq            17
            return null;
    //    7   15:aconst_null     
    //    8   16:areturn         
        else
            return (AbstractFileLoader)m_CurrentConverter;
    //    9   17:aload_0         
    //   10   18:getfield        #300 <Field Object m_CurrentConverter>
    //   11   21:checkcast       #368 <Class AbstractFileLoader>
    //   12   24:areturn         
    }

    public AbstractFileSaver getSaver()
    {
        configureCurrentConverter(2);
    //    0    0:aload_0         
    //    1    1:iconst_2        
    //    2    2:invokevirtual   #349 <Method void configureCurrentConverter(int)>
        if(m_CurrentConverter instanceof AbstractFileLoader)
    //*   3    5:aload_0         
    //*   4    6:getfield        #300 <Field Object m_CurrentConverter>
    //*   5    9:instanceof      #368 <Class AbstractFileLoader>
    //*   6   12:ifeq            17
            return null;
    //    7   15:aconst_null     
    //    8   16:areturn         
        else
            return (AbstractFileSaver)m_CurrentConverter;
    //    9   17:aload_0         
    //   10   18:getfield        #300 <Field Object m_CurrentConverter>
    //   11   21:checkcast       #366 <Class AbstractFileSaver>
    //   12   24:areturn         
    }

    protected void updateCurrentConverter()
    {
        if(getFileFilter() == null)
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //*   2    4:ifnonnull       8
            return;
    //    3    7:return          
        if(!isAcceptAllFileFilterUsed())
    //*   4    8:aload_0         
    //*   5    9:invokevirtual   #224 <Method boolean isAcceptAllFileFilterUsed()>
    //*   6   12:ifne            104
        {
            String extensions[] = ((ExtensionFileFilter)getFileFilter()).getExtensions();
    //    7   15:aload_0         
    //    8   16:invokevirtual   #317 <Method FileFilter getFileFilter()>
    //    9   19:checkcast       #93  <Class ExtensionFileFilter>
    //   10   22:invokevirtual   #97  <Method String[] ExtensionFileFilter.getExtensions()>
    //   11   25:astore_1        
            Object newConverter;
            if(m_DialogType == 1)
    //*  12   26:aload_0         
    //*  13   27:getfield        #286 <Field int m_DialogType>
    //*  14   30:iconst_1        
    //*  15   31:icmpne          44
                newConverter = ConverterUtils.getLoaderForExtension(extensions[0]);
    //   16   34:aload_1         
    //   17   35:iconst_0        
    //   18   36:aaload          
    //   19   37:invokestatic    #101 <Method AbstractFileLoader ConverterUtils.getLoaderForExtension(String)>
    //   20   40:astore_2        
            else
    //*  21   41:goto            51
                newConverter = ConverterUtils.getSaverForExtension(extensions[0]);
    //   22   44:aload_1         
    //   23   45:iconst_0        
    //   24   46:aaload          
    //   25   47:invokestatic    #138 <Method AbstractFileSaver ConverterUtils.getSaverForExtension(String)>
    //   26   50:astore_2        
            try
            {
                if(m_CurrentConverter == null)
    //*  27   51:aload_0         
    //*  28   52:getfield        #300 <Field Object m_CurrentConverter>
    //*  29   55:ifnonnull       66
                    m_CurrentConverter = newConverter;
    //   30   58:aload_0         
    //   31   59:aload_2         
    //   32   60:putfield        #300 <Field Object m_CurrentConverter>
                else
    //*  33   63:goto            109
                if(!m_CurrentConverter.getClass().equals(newConverter.getClass()))
    //*  34   66:aload_0         
    //*  35   67:getfield        #300 <Field Object m_CurrentConverter>
    //*  36   70:invokevirtual   #107 <Method Class Object.getClass()>
    //*  37   73:aload_2         
    //*  38   74:invokevirtual   #107 <Method Class Object.getClass()>
    //*  39   77:invokevirtual   #373 <Method boolean Object.equals(Object)>
    //*  40   80:ifne            109
                    m_CurrentConverter = newConverter;
    //   41   83:aload_0         
    //   42   84:aload_2         
    //   43   85:putfield        #300 <Field Object m_CurrentConverter>
            }
    //*  44   88:goto            109
            catch(Exception e)
    //*  45   91:astore_3        
            {
                m_CurrentConverter = null;
    //   46   92:aload_0         
    //   47   93:aconst_null     
    //   48   94:putfield        #300 <Field Object m_CurrentConverter>
                e.printStackTrace();
    //   49   97:aload_3         
    //   50   98:invokevirtual   #376 <Method void Exception.printStackTrace()>
            }
        } else
    //*  51  101:goto            109
        {
            m_CurrentConverter = null;
    //   52  104:aload_0         
    //   53  105:aconst_null     
    //   54  106:putfield        #300 <Field Object m_CurrentConverter>
        }
    //   55  109:return          
    }

    protected void configureCurrentConverter(int dialogType)
    {
        if(getSelectedFile() == null || getSelectedFile().isDirectory())
    //*   0    0:aload_0         
    //*   1    1:invokevirtual   #308 <Method File getSelectedFile()>
    //*   2    4:ifnull          17
    //*   3    7:aload_0         
    //*   4    8:invokevirtual   #308 <Method File getSelectedFile()>
    //*   5   11:invokevirtual   #380 <Method boolean File.isDirectory()>
    //*   6   14:ifeq            18
            return;
    //    7   17:return          
        String filename = getSelectedFile().getAbsolutePath();
    //    8   18:aload_0         
    //    9   19:invokevirtual   #308 <Method File getSelectedFile()>
    //   10   22:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //   11   25:astore_2        
        if(m_CurrentConverter == null)
    //*  12   26:aload_0         
    //*  13   27:getfield        #300 <Field Object m_CurrentConverter>
    //*  14   30:ifnonnull       84
        {
            if(dialogType == 1)
    //*  15   33:iload_1         
    //*  16   34:iconst_1        
    //*  17   35:icmpne          49
                m_CurrentConverter = ConverterUtils.getLoaderForFile(filename);
    //   18   38:aload_0         
    //   19   39:aload_2         
    //   20   40:invokestatic    #383 <Method AbstractFileLoader ConverterUtils.getLoaderForFile(String)>
    //   21   43:putfield        #300 <Field Object m_CurrentConverter>
            else
    //*  22   46:goto            76
            if(dialogType == 2)
    //*  23   49:iload_1         
    //*  24   50:iconst_2        
    //*  25   51:icmpne          65
                m_CurrentConverter = ConverterUtils.getSaverForFile(filename);
    //   26   54:aload_0         
    //   27   55:aload_2         
    //   28   56:invokestatic    #386 <Method AbstractFileSaver ConverterUtils.getSaverForFile(String)>
    //   29   59:putfield        #300 <Field Object m_CurrentConverter>
            else
    //*  30   62:goto            76
                throw new IllegalStateException("Cannot determine loader/saver!");
    //   31   65:new             #288 <Class IllegalStateException>
    //   32   68:dup             
    //   33   69:ldc2            #388 <String "Cannot determine loader/saver!">
    //   34   72:invokespecial   #291 <Method void IllegalStateException(String)>
    //   35   75:athrow          
            if(m_CurrentConverter == null)
    //*  36   76:aload_0         
    //*  37   77:getfield        #300 <Field Object m_CurrentConverter>
    //*  38   80:ifnonnull       84
                return;
    //   39   83:return          
        }
        try
        {
            File currFile = ((FileSourcedConverter)m_CurrentConverter).retrieveFile();
    //   40   84:aload_0         
    //   41   85:getfield        #300 <Field Object m_CurrentConverter>
    //   42   88:checkcast       #175 <Class FileSourcedConverter>
    //   43   91:invokeinterface #391 <Method File FileSourcedConverter.retrieveFile()>
    //   44   96:astore_3        
            if(currFile == null || !currFile.getAbsolutePath().equals(filename))
    //*  45   97:aload_3         
    //*  46   98:ifnull          112
    //*  47  101:aload_3         
    //*  48  102:invokevirtual   #320 <Method String File.getAbsolutePath()>
    //*  49  105:aload_2         
    //*  50  106:invokevirtual   #392 <Method boolean String.equals(Object)>
    //*  51  109:ifne            142
                ((FileSourcedConverter)m_CurrentConverter).setFile(new File(filename));
    //   52  112:aload_0         
    //   53  113:getfield        #300 <Field Object m_CurrentConverter>
    //   54  116:checkcast       #175 <Class FileSourcedConverter>
    //   55  119:new             #310 <Class File>
    //   56  122:dup             
    //   57  123:aload_2         
    //   58  124:invokespecial   #324 <Method void File(String)>
    //   59  127:invokeinterface #395 <Method void FileSourcedConverter.setFile(File)>
        }
    //*  60  132:goto            142
        catch(Exception e)
    //*  61  135:astore          4
        {
            e.printStackTrace();
    //   62  137:aload           4
    //   63  139:invokevirtual   #376 <Method void Exception.printStackTrace()>
        }
    //   64  142:return          
    }

    public static void main(String args[])
        throws Exception
    {
        ConverterFileChooser fc = new ConverterFileChooser();
    //    0    0:new             #2   <Class ConverterFileChooser>
    //    1    3:dup             
    //    2    4:invokespecial   #400 <Method void ConverterFileChooser()>
    //    3    7:astore_1        
        int retVal = fc.showOpenDialog(null);
    //    4    8:aload_1         
    //    5    9:aconst_null     
    //    6   10:invokevirtual   #346 <Method int showOpenDialog(Component)>
    //    7   13:istore_2        
        if(retVal == 0)
    //*   8   14:iload_2         
    //*   9   15:ifne            72
        {
            AbstractFileLoader loader = fc.getLoader();
    //   10   18:aload_1         
    //   11   19:invokevirtual   #402 <Method AbstractFileLoader getLoader()>
    //   12   22:astore_3        
            rm.core.Instances data = loader.getDataSet();
    //   13   23:aload_3         
    //   14   24:invokevirtual   #406 <Method rm.core.Instances AbstractFileLoader.getDataSet()>
    //   15   27:astore          5
            retVal = fc.showSaveDialog(null);
    //   16   29:aload_1         
    //   17   30:aconst_null     
    //   18   31:invokevirtual   #360 <Method int showSaveDialog(Component)>
    //   19   34:istore_2        
            if(retVal == 0)
    //*  20   35:iload_2         
    //*  21   36:ifne            60
            {
                AbstractFileSaver saver = fc.getSaver();
    //   22   39:aload_1         
    //   23   40:invokevirtual   #408 <Method AbstractFileSaver getSaver()>
    //   24   43:astore          4
                saver.setInstances(data);
    //   25   45:aload           4
    //   26   47:aload           5
    //   27   49:invokevirtual   #412 <Method void AbstractFileSaver.setInstances(rm.core.Instances)>
                saver.writeBatch();
    //   28   52:aload           4
    //   29   54:invokevirtual   #415 <Method void AbstractFileSaver.writeBatch()>
            } else
    //*  30   57:goto            81
            {
                System.out.println("Saving aborted!");
    //   31   60:getstatic       #421 <Field PrintStream System.out>
    //   32   63:ldc2            #423 <String "Saving aborted!">
    //   33   66:invokevirtual   #428 <Method void PrintStream.println(String)>
            }
        } else
    //*  34   69:goto            81
        {
            System.out.println("Loading aborted!");
    //   35   72:getstatic       #421 <Field PrintStream System.out>
    //   36   75:ldc2            #430 <String "Loading aborted!">
    //   37   78:invokevirtual   #428 <Method void PrintStream.println(String)>
        }
    //   38   81:return          
    }

    private static final long serialVersionUID = 0xb56f1034e7425ff6L;
    public static final int UNHANDLED_DIALOG = 0;
    public static final int LOADER_DIALOG = 1;
    public static final int SAVER_DIALOG = 2;
    protected ConverterFileChooser m_Self;
    protected static Vector m_LoaderFileFilters;
    protected static Vector m_SaverFileFilters;
    protected int m_DialogType;
    protected Object m_CurrentConverter;
    protected JButton m_ConfigureButton;
    protected PropertyChangeListener m_Listener;
    protected FileFilter m_LastFilter;
    protected Capabilities m_CapabilitiesFilter;
    protected boolean m_OverwriteWarning;
    protected boolean m_FileMustExist;
    protected boolean m_CoreConvertersOnly;

    static 
    {
        initFilters(true, ConverterUtils.getFileLoaders());
    //    0    0:iconst_1        
    //    1    1:invokestatic    #47  <Method Vector ConverterUtils.getFileLoaders()>
    //    2    4:invokestatic    #51  <Method void initFilters(boolean, Vector)>
        initFilters(false, ConverterUtils.getFileSavers());
    //    3    7:iconst_0        
    //    4    8:invokestatic    #54  <Method Vector ConverterUtils.getFileSavers()>
    //    5   11:invokestatic    #51  <Method void initFilters(boolean, Vector)>
    //*   6   14:return          
    }
}

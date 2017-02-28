// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   VisualizeUtils.java

package rm.gui.visualize;

import java.awt.Color;
import java.io.PrintStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import rm.core.Utils;

public class VisualizeUtils
{

    public VisualizeUtils()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #92  <Method void Object()>
    //    2    4:return          
    }

    public static Color processColour(String colourDef, Color defaultColour)
    {
        String colourDefBack = new String(colourDef);
    //    0    0:new             #98  <Class String>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:invokespecial   #99  <Method void String(String)>
    //    4    8:astore_2        
        Color retC = defaultColour;
    //    5    9:aload_1         
    //    6   10:astore_3        
        if(colourDef.indexOf(",") >= 0)
    //*   7   11:aload_0         
    //*   8   12:ldc1            #101 <String ",">
    //*   9   14:invokevirtual   #104 <Method int String.indexOf(String)>
    //*  10   17:iflt            141
            try
            {
                int index = colourDef.indexOf(",");
    //   11   20:aload_0         
    //   12   21:ldc1            #101 <String ",">
    //   13   23:invokevirtual   #104 <Method int String.indexOf(String)>
    //   14   26:istore          4
                int R = Integer.parseInt(colourDef.substring(0, index));
    //   15   28:aload_0         
    //   16   29:iconst_0        
    //   17   30:iload           4
    //   18   32:invokevirtual   #108 <Method String String.substring(int, int)>
    //   19   35:invokestatic    #41  <Method int Integer.parseInt(String)>
    //   20   38:istore          5
                colourDef = colourDef.substring(index + 1, colourDef.length());
    //   21   40:aload_0         
    //   22   41:iload           4
    //   23   43:iconst_1        
    //   24   44:iadd            
    //   25   45:aload_0         
    //   26   46:invokevirtual   #112 <Method int String.length()>
    //   27   49:invokevirtual   #108 <Method String String.substring(int, int)>
    //   28   52:astore_0        
                index = colourDef.indexOf(",");
    //   29   53:aload_0         
    //   30   54:ldc1            #101 <String ",">
    //   31   56:invokevirtual   #104 <Method int String.indexOf(String)>
    //   32   59:istore          4
                int G = Integer.parseInt(colourDef.substring(0, index));
    //   33   61:aload_0         
    //   34   62:iconst_0        
    //   35   63:iload           4
    //   36   65:invokevirtual   #108 <Method String String.substring(int, int)>
    //   37   68:invokestatic    #41  <Method int Integer.parseInt(String)>
    //   38   71:istore          6
                colourDef = colourDef.substring(index + 1, colourDef.length());
    //   39   73:aload_0         
    //   40   74:iload           4
    //   41   76:iconst_1        
    //   42   77:iadd            
    //   43   78:aload_0         
    //   44   79:invokevirtual   #112 <Method int String.length()>
    //   45   82:invokevirtual   #108 <Method String String.substring(int, int)>
    //   46   85:astore_0        
                int B = Integer.parseInt(colourDef);
    //   47   86:aload_0         
    //   48   87:invokestatic    #41  <Method int Integer.parseInt(String)>
    //   49   90:istore          7
                retC = new Color(R, G, B);
    //   50   92:new             #114 <Class Color>
    //   51   95:dup             
    //   52   96:iload           5
    //   53   98:iload           6
    //   54  100:iload           7
    //   55  102:invokespecial   #117 <Method void Color(int, int, int)>
    //   56  105:astore_3        
            }
    //*  57  106:goto            376
            catch(Exception ex)
    //*  58  109:astore          4
            {
                System.err.println((new StringBuilder("VisualizeUtils: Problem parsing colour property value (")).append(colourDefBack).append(").").toString());
    //   59  111:getstatic       #121 <Field PrintStream System.err>
    //   60  114:new             #43  <Class StringBuilder>
    //   61  117:dup             
    //   62  118:ldc1            #123 <String "VisualizeUtils: Problem parsing colour property value (">
    //   63  120:invokespecial   #49  <Method void StringBuilder(String)>
    //   64  123:aload_2         
    //   65  124:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   66  127:ldc1            #125 <String ").">
    //   67  129:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   68  132:invokevirtual   #75  <Method String StringBuilder.toString()>
    //   69  135:invokevirtual   #130 <Method void PrintStream.println(String)>
            }
        else
    //*  70  138:goto            376
        if(colourDef.compareTo("black") == 0)
    //*  71  141:aload_0         
    //*  72  142:ldc1            #132 <String "black">
    //*  73  144:invokevirtual   #135 <Method int String.compareTo(String)>
    //*  74  147:ifne            157
            retC = Color.black;
    //   75  150:getstatic       #138 <Field Color Color.black>
    //   76  153:astore_3        
        else
    //*  77  154:goto            376
        if(colourDef.compareTo("blue") == 0)
    //*  78  157:aload_0         
    //*  79  158:ldc1            #140 <String "blue">
    //*  80  160:invokevirtual   #135 <Method int String.compareTo(String)>
    //*  81  163:ifne            173
            retC = Color.blue;
    //   82  166:getstatic       #142 <Field Color Color.blue>
    //   83  169:astore_3        
        else
    //*  84  170:goto            376
        if(colourDef.compareTo("cyan") == 0)
    //*  85  173:aload_0         
    //*  86  174:ldc1            #144 <String "cyan">
    //*  87  176:invokevirtual   #135 <Method int String.compareTo(String)>
    //*  88  179:ifne            189
            retC = Color.cyan;
    //   89  182:getstatic       #146 <Field Color Color.cyan>
    //   90  185:astore_3        
        else
    //*  91  186:goto            376
        if(colourDef.compareTo("darkGray") == 0)
    //*  92  189:aload_0         
    //*  93  190:ldc1            #148 <String "darkGray">
    //*  94  192:invokevirtual   #135 <Method int String.compareTo(String)>
    //*  95  195:ifne            205
            retC = Color.darkGray;
    //   96  198:getstatic       #150 <Field Color Color.darkGray>
    //   97  201:astore_3        
        else
    //*  98  202:goto            376
        if(colourDef.compareTo("gray") == 0)
    //*  99  205:aload_0         
    //* 100  206:ldc1            #152 <String "gray">
    //* 101  208:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 102  211:ifne            221
            retC = Color.gray;
    //  103  214:getstatic       #154 <Field Color Color.gray>
    //  104  217:astore_3        
        else
    //* 105  218:goto            376
        if(colourDef.compareTo("green") == 0)
    //* 106  221:aload_0         
    //* 107  222:ldc1            #156 <String "green">
    //* 108  224:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 109  227:ifne            237
            retC = Color.green;
    //  110  230:getstatic       #158 <Field Color Color.green>
    //  111  233:astore_3        
        else
    //* 112  234:goto            376
        if(colourDef.compareTo("lightGray") == 0)
    //* 113  237:aload_0         
    //* 114  238:ldc1            #160 <String "lightGray">
    //* 115  240:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 116  243:ifne            253
            retC = Color.lightGray;
    //  117  246:getstatic       #162 <Field Color Color.lightGray>
    //  118  249:astore_3        
        else
    //* 119  250:goto            376
        if(colourDef.compareTo("magenta") == 0)
    //* 120  253:aload_0         
    //* 121  254:ldc1            #164 <String "magenta">
    //* 122  256:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 123  259:ifne            269
            retC = Color.magenta;
    //  124  262:getstatic       #166 <Field Color Color.magenta>
    //  125  265:astore_3        
        else
    //* 126  266:goto            376
        if(colourDef.compareTo("orange") == 0)
    //* 127  269:aload_0         
    //* 128  270:ldc1            #168 <String "orange">
    //* 129  272:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 130  275:ifne            285
            retC = Color.orange;
    //  131  278:getstatic       #170 <Field Color Color.orange>
    //  132  281:astore_3        
        else
    //* 133  282:goto            376
        if(colourDef.compareTo("pink") == 0)
    //* 134  285:aload_0         
    //* 135  286:ldc1            #172 <String "pink">
    //* 136  288:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 137  291:ifne            301
            retC = Color.pink;
    //  138  294:getstatic       #174 <Field Color Color.pink>
    //  139  297:astore_3        
        else
    //* 140  298:goto            376
        if(colourDef.compareTo("red") == 0)
    //* 141  301:aload_0         
    //* 142  302:ldc1            #176 <String "red">
    //* 143  304:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 144  307:ifne            317
            retC = Color.red;
    //  145  310:getstatic       #178 <Field Color Color.red>
    //  146  313:astore_3        
        else
    //* 147  314:goto            376
        if(colourDef.compareTo("white") == 0)
    //* 148  317:aload_0         
    //* 149  318:ldc1            #180 <String "white">
    //* 150  320:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 151  323:ifne            333
            retC = Color.white;
    //  152  326:getstatic       #182 <Field Color Color.white>
    //  153  329:astore_3        
        else
    //* 154  330:goto            376
        if(colourDef.compareTo("yellow") == 0)
    //* 155  333:aload_0         
    //* 156  334:ldc1            #184 <String "yellow">
    //* 157  336:invokevirtual   #135 <Method int String.compareTo(String)>
    //* 158  339:ifne            349
            retC = Color.yellow;
    //  159  342:getstatic       #186 <Field Color Color.yellow>
    //  160  345:astore_3        
        else
    //* 161  346:goto            376
            System.err.println((new StringBuilder("VisualizeUtils: colour property name not recognized (")).append(colourDefBack).append(").").toString());
    //  162  349:getstatic       #121 <Field PrintStream System.err>
    //  163  352:new             #43  <Class StringBuilder>
    //  164  355:dup             
    //  165  356:ldc1            #188 <String "VisualizeUtils: colour property name not recognized (">
    //  166  358:invokespecial   #49  <Method void StringBuilder(String)>
    //  167  361:aload_2         
    //  168  362:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //  169  365:ldc1            #125 <String ").">
    //  170  367:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //  171  370:invokevirtual   #75  <Method String StringBuilder.toString()>
    //  172  373:invokevirtual   #130 <Method void PrintStream.println(String)>
        return retC;
    //  173  376:aload_3         
    //  174  377:areturn         
    }

    protected static String PROPERTY_FILE;
    protected static Properties VISUALIZE_PROPERTIES;
    protected static int MAX_PRECISION = 10;

    static 
    {
        PROPERTY_FILE = "rm/gui/visualize/Visualize.props";
    //    0    0:ldc1            #15  <String "rm/gui/visualize/Visualize.props">
    //    1    2:putstatic       #17  <Field String PROPERTY_FILE>
    //    2    5:bipush          10
    //    3    7:putstatic       #19  <Field int MAX_PRECISION>
        try
        {
            VISUALIZE_PROPERTIES = Utils.readProperties(PROPERTY_FILE);
    //    4   10:getstatic       #17  <Field String PROPERTY_FILE>
    //    5   13:invokestatic    #25  <Method Properties Utils.readProperties(String)>
    //    6   16:putstatic       #27  <Field Properties VISUALIZE_PROPERTIES>
            String precision = VISUALIZE_PROPERTIES.getProperty("weka.gui.visualize.precision");
    //    7   19:getstatic       #27  <Field Properties VISUALIZE_PROPERTIES>
    //    8   22:ldc1            #29  <String "weka.gui.visualize.precision">
    //    9   24:invokevirtual   #35  <Method String Properties.getProperty(String)>
    //   10   27:astore_0        
            if(precision != null)
    //*  11   28:aload_0         
    //*  12   29:ifnull          104
                MAX_PRECISION = Integer.parseInt(precision);
    //   13   32:aload_0         
    //   14   33:invokestatic    #41  <Method int Integer.parseInt(String)>
    //   15   36:putstatic       #19  <Field int MAX_PRECISION>
        }
    //*  16   39:goto            104
        catch(Exception ex)
    //*  17   42:astore_0        
        {
            JOptionPane.showMessageDialog(null, (new StringBuilder("VisualizeUtils: Could not read a visualization configuration file.\nAn example file is included in the Weka distribution.\nThis file should be named \"")).append(PROPERTY_FILE).append("\"  and\n").append("should be placed either in your user home (which is set\n").append("to \"").append(System.getProperties().getProperty("user.home")).append("\")\n").append("or the directory that java was started from\n").toString(), "Plot2D", 0);
    //   18   43:aconst_null     
    //   19   44:new             #43  <Class StringBuilder>
    //   20   47:dup             
    //   21   48:ldc1            #45  <String "VisualizeUtils: Could not read a visualization configuration file.\nAn example file is included in the Weka distribution.\nThis file should be named \"">
    //   22   50:invokespecial   #49  <Method void StringBuilder(String)>
    //   23   53:getstatic       #17  <Field String PROPERTY_FILE>
    //   24   56:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   25   59:ldc1            #55  <String "\"  and\n">
    //   26   61:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   27   64:ldc1            #57  <String "should be placed either in your user home (which is set\n">
    //   28   66:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   29   69:ldc1            #59  <String "to \"">
    //   30   71:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   31   74:invokestatic    #65  <Method Properties System.getProperties()>
    //   32   77:ldc1            #67  <String "user.home">
    //   33   79:invokevirtual   #35  <Method String Properties.getProperty(String)>
    //   34   82:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   35   85:ldc1            #69  <String "\")\n">
    //   36   87:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   37   90:ldc1            #71  <String "or the directory that java was started from\n">
    //   38   92:invokevirtual   #53  <Method StringBuilder StringBuilder.append(String)>
    //   39   95:invokevirtual   #75  <Method String StringBuilder.toString()>
    //   40   98:ldc1            #77  <String "Plot2D">
    //   41  100:iconst_0        
    //   42  101:invokestatic    #83  <Method void JOptionPane.showMessageDialog(java.awt.Component, Object, String, int)>
        }
    //*  43  104:return          
    }
}

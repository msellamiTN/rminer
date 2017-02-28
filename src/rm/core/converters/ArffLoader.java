// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   ArffLoader.java

package rm.core.converters;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import rm.core.*;

// Referenced classes of package rm.core.converters:
//            AbstractFileLoader, BatchConverter, IncrementalConverter

public class ArffLoader extends AbstractFileLoader
    implements BatchConverter, IncrementalConverter
{
    public static class ArffReader
    {

        protected void initBuffers()
        {
            m_ValueBuffer = new double[m_Data.numAttributes()];
        //    0    0:aload_0         
        //    1    1:aload_0         
        //    2    2:getfield        #41  <Field Instances m_Data>
        //    3    5:invokevirtual   #86  <Method int Instances.numAttributes()>
        //    4    8:newarray        double[]
        //    5   10:putfield        #88  <Field double[] m_ValueBuffer>
            m_IndicesBuffer = new int[m_Data.numAttributes()];
        //    6   13:aload_0         
        //    7   14:aload_0         
        //    8   15:getfield        #41  <Field Instances m_Data>
        //    9   18:invokevirtual   #86  <Method int Instances.numAttributes()>
        //   10   21:newarray        int[]
        //   11   23:putfield        #90  <Field int[] m_IndicesBuffer>
        //   12   26:return          
        }

        protected void compactify()
        {
            if(m_Data != null)
        //*   0    0:aload_0         
        //*   1    1:getfield        #41  <Field Instances m_Data>
        //*   2    4:ifnull          14
                m_Data.compactify();
        //    3    7:aload_0         
        //    4    8:getfield        #41  <Field Instances m_Data>
        //    5   11:invokevirtual   #91  <Method void Instances.compactify()>
        //    6   14:return          
        }

        protected void errorMessage(String msg)
            throws IOException
        {
            String str = (new StringBuilder(String.valueOf(msg))).append(", read ").append(m_Tokenizer.toString()).toString();
        //    0    0:new             #94  <Class StringBuilder>
        //    1    3:dup             
        //    2    4:aload_1         
        //    3    5:invokestatic    #100 <Method String String.valueOf(Object)>
        //    4    8:invokespecial   #101 <Method void StringBuilder(String)>
        //    5   11:ldc1            #103 <String ", read ">
        //    6   13:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //    7   16:aload_0         
        //    8   17:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    9   20:invokevirtual   #111 <Method String StreamTokenizer.toString()>
        //   10   23:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //   11   26:invokevirtual   #112 <Method String StringBuilder.toString()>
        //   12   29:astore_2        
            if(m_Lines > 0)
        //*  13   30:aload_0         
        //*  14   31:getfield        #79  <Field int m_Lines>
        //*  15   34:ifle            79
            {
                int line = Integer.parseInt(str.replaceAll(".* line ", ""));
        //   16   37:aload_2         
        //   17   38:ldc1            #114 <String ".* line ">
        //   18   40:ldc1            #116 <String "">
        //   19   42:invokevirtual   #120 <Method String String.replaceAll(String, String)>
        //   20   45:invokestatic    #126 <Method int Integer.parseInt(String)>
        //   21   48:istore_3        
                str = str.replaceAll(" line .*", (new StringBuilder(" line ")).append((m_Lines + line) - 1).toString());
        //   22   49:aload_2         
        //   23   50:ldc1            #128 <String " line .*">
        //   24   52:new             #94  <Class StringBuilder>
        //   25   55:dup             
        //   26   56:ldc1            #130 <String " line ">
        //   27   58:invokespecial   #101 <Method void StringBuilder(String)>
        //   28   61:aload_0         
        //   29   62:getfield        #79  <Field int m_Lines>
        //   30   65:iload_3         
        //   31   66:iadd            
        //   32   67:iconst_1        
        //   33   68:isub            
        //   34   69:invokevirtual   #133 <Method StringBuilder StringBuilder.append(int)>
        //   35   72:invokevirtual   #112 <Method String StringBuilder.toString()>
        //   36   75:invokevirtual   #120 <Method String String.replaceAll(String, String)>
        //   37   78:astore_2        
            }
            throw new IOException(str);
        //   38   79:new             #19  <Class IOException>
        //   39   82:dup             
        //   40   83:aload_2         
        //   41   84:invokespecial   #134 <Method void IOException(String)>
        //   42   87:athrow          
        }

        public int getLineNo()
        {
            return m_Lines + m_Tokenizer.lineno();
        //    0    0:aload_0         
        //    1    1:getfield        #79  <Field int m_Lines>
        //    2    4:aload_0         
        //    3    5:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    4    8:invokevirtual   #142 <Method int StreamTokenizer.lineno()>
        //    5   11:iadd            
        //    6   12:ireturn         
        }

        protected void getFirstToken()
            throws IOException
        {
            while(m_Tokenizer.nextToken() == 10) ;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    2    4:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //    3    7:bipush          10
        //    4    9:icmpeq          0
            if(m_Tokenizer.ttype == 39 || m_Tokenizer.ttype == 34)
        //*   5   12:aload_0         
        //*   6   13:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   7   16:getfield        #149 <Field int StreamTokenizer.ttype>
        //*   8   19:bipush          39
        //*   9   21:icmpeq          36
        //*  10   24:aload_0         
        //*  11   25:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  12   28:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  13   31:bipush          34
        //*  14   33:icmpne          48
                m_Tokenizer.ttype = -3;
        //   15   36:aload_0         
        //   16   37:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   17   40:bipush          -3
        //   18   42:putfield        #149 <Field int StreamTokenizer.ttype>
            else
        //*  19   45:goto            84
            if(m_Tokenizer.ttype == -3 && m_Tokenizer.sval.equals("?"))
        //*  20   48:aload_0         
        //*  21   49:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  22   52:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  23   55:bipush          -3
        //*  24   57:icmpne          84
        //*  25   60:aload_0         
        //*  26   61:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  27   64:getfield        #152 <Field String StreamTokenizer.sval>
        //*  28   67:ldc1            #154 <String "?">
        //*  29   69:invokevirtual   #158 <Method boolean String.equals(Object)>
        //*  30   72:ifeq            84
                m_Tokenizer.ttype = 63;
        //   31   75:aload_0         
        //   32   76:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   33   79:bipush          63
        //   34   81:putfield        #149 <Field int StreamTokenizer.ttype>
        //   35   84:return          
        }

        protected void getIndex()
            throws IOException
        {
            if(m_Tokenizer.nextToken() == 10)
        //*   0    0:aload_0         
        //*   1    1:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   2    4:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //*   3    7:bipush          10
        //*   4    9:icmpne          18
                errorMessage("premature end of line");
        //    5   12:aload_0         
        //    6   13:ldc1            #161 <String "premature end of line">
        //    7   15:invokevirtual   #163 <Method void errorMessage(String)>
            if(m_Tokenizer.ttype == -1)
        //*   8   18:aload_0         
        //*   9   19:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  10   22:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  11   25:iconst_m1       
        //*  12   26:icmpne          35
                errorMessage("premature end of file");
        //   13   29:aload_0         
        //   14   30:ldc1            #165 <String "premature end of file">
        //   15   32:invokevirtual   #163 <Method void errorMessage(String)>
        //   16   35:return          
        }

        protected void getLastToken(boolean endOfFileOk)
            throws IOException
        {
            if(m_Tokenizer.nextToken() != 10 && (m_Tokenizer.ttype != -1 || !endOfFileOk))
        //*   0    0:aload_0         
        //*   1    1:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   2    4:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //*   3    7:bipush          10
        //*   4    9:icmpeq          33
        //*   5   12:aload_0         
        //*   6   13:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   7   16:getfield        #149 <Field int StreamTokenizer.ttype>
        //*   8   19:iconst_m1       
        //*   9   20:icmpne          27
        //*  10   23:iload_1         
        //*  11   24:ifne            33
                errorMessage("end of line expected");
        //   12   27:aload_0         
        //   13   28:ldc1            #169 <String "end of line expected">
        //   14   30:invokevirtual   #163 <Method void errorMessage(String)>
        //   15   33:return          
        }

        protected double getInstanceWeight()
            throws IOException
        {
            double weight = (0.0D / 0.0D);
        //    0    0:ldc2w           #174 <Double (0.0D / 0.0D)>
        //    1    3:dstore_1        
            m_Tokenizer.nextToken();
        //    2    4:aload_0         
        //    3    5:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    4    8:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //    5   11:pop             
            if(m_Tokenizer.ttype == 10 || m_Tokenizer.ttype == -1)
        //*   6   12:aload_0         
        //*   7   13:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   8   16:getfield        #149 <Field int StreamTokenizer.ttype>
        //*   9   19:bipush          10
        //*  10   21:icmpeq          35
        //*  11   24:aload_0         
        //*  12   25:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  13   28:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  14   31:iconst_m1       
        //*  15   32:icmpne          37
                return weight;
        //   16   35:dload_1         
        //   17   36:dreturn         
            if(m_Tokenizer.ttype == 123)
        //*  18   37:aload_0         
        //*  19   38:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  20   41:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  21   44:bipush          123
        //*  22   46:icmpne          103
            {
                m_Tokenizer.nextToken();
        //   23   49:aload_0         
        //   24   50:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   25   53:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //   26   56:pop             
                String weightS = m_Tokenizer.sval;
        //   27   57:aload_0         
        //   28   58:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   29   61:getfield        #152 <Field String StreamTokenizer.sval>
        //   30   64:astore_3        
                try
                {
                    weight = Double.parseDouble(weightS);
        //   31   65:aload_3         
        //   32   66:invokestatic    #181 <Method double Double.parseDouble(String)>
        //   33   69:dstore_1        
                }
        //*  34   70:goto            77
                catch(NumberFormatException e)
        //*  35   73:astore          4
                {
                    return weight;
        //   36   75:dload_1         
        //   37   76:dreturn         
                }
                m_Tokenizer.nextToken();
        //   38   77:aload_0         
        //   39   78:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   40   81:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //   41   84:pop             
                if(m_Tokenizer.ttype != 125)
        //*  42   85:aload_0         
        //*  43   86:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  44   89:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  45   92:bipush          125
        //*  46   94:icmpeq          103
                    errorMessage("Problem reading instance weight");
        //   47   97:aload_0         
        //   48   98:ldc1            #183 <String "Problem reading instance weight">
        //   49  100:invokevirtual   #163 <Method void errorMessage(String)>
            }
            return weight;
        //   50  103:dload_1         
        //   51  104:dreturn         
        }

        protected void getNextToken()
            throws IOException
        {
            if(m_Tokenizer.nextToken() == 10)
        //*   0    0:aload_0         
        //*   1    1:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   2    4:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //*   3    7:bipush          10
        //*   4    9:icmpne          18
                errorMessage("premature end of line");
        //    5   12:aload_0         
        //    6   13:ldc1            #161 <String "premature end of line">
        //    7   15:invokevirtual   #163 <Method void errorMessage(String)>
            if(m_Tokenizer.ttype == -1)
        //*   8   18:aload_0         
        //*   9   19:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  10   22:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  11   25:iconst_m1       
        //*  12   26:icmpne          38
                errorMessage("premature end of file");
        //   13   29:aload_0         
        //   14   30:ldc1            #165 <String "premature end of file">
        //   15   32:invokevirtual   #163 <Method void errorMessage(String)>
            else
        //*  16   35:goto            110
            if(m_Tokenizer.ttype == 39 || m_Tokenizer.ttype == 34)
        //*  17   38:aload_0         
        //*  18   39:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  19   42:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  20   45:bipush          39
        //*  21   47:icmpeq          62
        //*  22   50:aload_0         
        //*  23   51:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  24   54:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  25   57:bipush          34
        //*  26   59:icmpne          74
                m_Tokenizer.ttype = -3;
        //   27   62:aload_0         
        //   28   63:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   29   66:bipush          -3
        //   30   68:putfield        #149 <Field int StreamTokenizer.ttype>
            else
        //*  31   71:goto            110
            if(m_Tokenizer.ttype == -3 && m_Tokenizer.sval.equals("?"))
        //*  32   74:aload_0         
        //*  33   75:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  34   78:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  35   81:bipush          -3
        //*  36   83:icmpne          110
        //*  37   86:aload_0         
        //*  38   87:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  39   90:getfield        #152 <Field String StreamTokenizer.sval>
        //*  40   93:ldc1            #154 <String "?">
        //*  41   95:invokevirtual   #158 <Method boolean String.equals(Object)>
        //*  42   98:ifeq            110
                m_Tokenizer.ttype = 63;
        //   43  101:aload_0         
        //   44  102:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   45  105:bipush          63
        //   46  107:putfield        #149 <Field int StreamTokenizer.ttype>
        //   47  110:return          
        }

        protected void initTokenizer()
        {
            m_Tokenizer.resetSyntax();
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    2    4:invokevirtual   #194 <Method void StreamTokenizer.resetSyntax()>
            m_Tokenizer.whitespaceChars(0, 32);
        //    3    7:aload_0         
        //    4    8:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    5   11:iconst_0        
        //    6   12:bipush          32
        //    7   14:invokevirtual   #198 <Method void StreamTokenizer.whitespaceChars(int, int)>
            m_Tokenizer.wordChars(33, 255);
        //    8   17:aload_0         
        //    9   18:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   10   21:bipush          33
        //   11   23:sipush          255
        //   12   26:invokevirtual   #201 <Method void StreamTokenizer.wordChars(int, int)>
            m_Tokenizer.whitespaceChars(44, 44);
        //   13   29:aload_0         
        //   14   30:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   15   33:bipush          44
        //   16   35:bipush          44
        //   17   37:invokevirtual   #198 <Method void StreamTokenizer.whitespaceChars(int, int)>
            m_Tokenizer.commentChar(37);
        //   18   40:aload_0         
        //   19   41:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   20   44:bipush          37
        //   21   46:invokevirtual   #204 <Method void StreamTokenizer.commentChar(int)>
            m_Tokenizer.quoteChar(34);
        //   22   49:aload_0         
        //   23   50:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   24   53:bipush          34
        //   25   55:invokevirtual   #207 <Method void StreamTokenizer.quoteChar(int)>
            m_Tokenizer.quoteChar(39);
        //   26   58:aload_0         
        //   27   59:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   28   62:bipush          39
        //   29   64:invokevirtual   #207 <Method void StreamTokenizer.quoteChar(int)>
            m_Tokenizer.ordinaryChar(123);
        //   30   67:aload_0         
        //   31   68:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   32   71:bipush          123
        //   33   73:invokevirtual   #210 <Method void StreamTokenizer.ordinaryChar(int)>
            m_Tokenizer.ordinaryChar(125);
        //   34   76:aload_0         
        //   35   77:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   36   80:bipush          125
        //   37   82:invokevirtual   #210 <Method void StreamTokenizer.ordinaryChar(int)>
            m_Tokenizer.eolIsSignificant(true);
        //   38   85:aload_0         
        //   39   86:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   40   89:iconst_1        
        //   41   90:invokevirtual   #213 <Method void StreamTokenizer.eolIsSignificant(boolean)>
        //   42   93:return          
        }

        public Instance readInstance(Instances structure)
            throws IOException
        {
            return readInstance(structure, true);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iconst_1        
        //    3    3:invokevirtual   #216 <Method Instance readInstance(Instances, boolean)>
        //    4    6:areturn         
        }

        public Instance readInstance(Instances structure, boolean flag)
            throws IOException
        {
            return getInstance(structure, flag);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:iload_2         
        //    3    3:invokevirtual   #220 <Method Instance getInstance(Instances, boolean)>
        //    4    6:areturn         
        }

        protected Instance getInstance(Instances structure, boolean flag)
            throws IOException
        {
            m_Data = structure;
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:putfield        #41  <Field Instances m_Data>
            if(m_Data.numAttributes() == 0)
        //*   3    5:aload_0         
        //*   4    6:getfield        #41  <Field Instances m_Data>
        //*   5    9:invokevirtual   #86  <Method int Instances.numAttributes()>
        //*   6   12:ifne            21
                errorMessage("no header information available");
        //    7   15:aload_0         
        //    8   16:ldc1            #223 <String "no header information available">
        //    9   18:invokevirtual   #163 <Method void errorMessage(String)>
            getFirstToken();
        //   10   21:aload_0         
        //   11   22:invokevirtual   #225 <Method void getFirstToken()>
            if(m_Tokenizer.ttype == -1)
        //*  12   25:aload_0         
        //*  13   26:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  14   29:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  15   32:iconst_m1       
        //*  16   33:icmpne          38
                return null;
        //   17   36:aconst_null     
        //   18   37:areturn         
            if(m_Tokenizer.ttype == 123)
        //*  19   38:aload_0         
        //*  20   39:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  21   42:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  22   45:bipush          123
        //*  23   47:icmpne          56
                return getInstanceSparse(flag);
        //   24   50:aload_0         
        //   25   51:iload_2         
        //   26   52:invokevirtual   #229 <Method Instance getInstanceSparse(boolean)>
        //   27   55:areturn         
            else
                return getInstanceFull(flag);
        //   28   56:aload_0         
        //   29   57:iload_2         
        //   30   58:invokevirtual   #232 <Method Instance getInstanceFull(boolean)>
        //   31   61:areturn         
        }

        protected Instance getInstanceSparse(boolean flag)
            throws IOException
        {
            int numValues = 0;
        //    0    0:iconst_0        
        //    1    1:istore_3        
            int maxIndex = -1;
        //    2    2:iconst_m1       
        //    3    3:istore          4
            do
            {
                getIndex();
        //    4    5:aload_0         
        //    5    6:invokevirtual   #234 <Method void getIndex()>
                if(m_Tokenizer.ttype == 125)
        //*   6    9:aload_0         
        //*   7   10:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   8   13:getfield        #149 <Field int StreamTokenizer.ttype>
        //*   9   16:bipush          125
        //*  10   18:icmpne          24
                    break;
        //   11   21:goto            414
                try
                {
                    m_IndicesBuffer[numValues] = Integer.valueOf(m_Tokenizer.sval).intValue();
        //   12   24:aload_0         
        //   13   25:getfield        #90  <Field int[] m_IndicesBuffer>
        //   14   28:iload_3         
        //   15   29:aload_0         
        //   16   30:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   17   33:getfield        #152 <Field String StreamTokenizer.sval>
        //   18   36:invokestatic    #237 <Method Integer Integer.valueOf(String)>
        //   19   39:invokevirtual   #240 <Method int Integer.intValue()>
        //   20   42:iastore         
                }
        //*  21   43:goto            54
                catch(NumberFormatException e)
        //*  22   46:astore          5
                {
                    errorMessage("index number expected");
        //   23   48:aload_0         
        //   24   49:ldc1            #242 <String "index number expected">
        //   25   51:invokevirtual   #163 <Method void errorMessage(String)>
                }
                if(m_IndicesBuffer[numValues] <= maxIndex)
        //*  26   54:aload_0         
        //*  27   55:getfield        #90  <Field int[] m_IndicesBuffer>
        //*  28   58:iload_3         
        //*  29   59:iaload          
        //*  30   60:iload           4
        //*  31   62:icmpgt          71
                    errorMessage("indices have to be ordered");
        //   32   65:aload_0         
        //   33   66:ldc1            #244 <String "indices have to be ordered">
        //   34   68:invokevirtual   #163 <Method void errorMessage(String)>
                if(m_IndicesBuffer[numValues] < 0 || m_IndicesBuffer[numValues] >= m_Data.numAttributes())
        //*  35   71:aload_0         
        //*  36   72:getfield        #90  <Field int[] m_IndicesBuffer>
        //*  37   75:iload_3         
        //*  38   76:iaload          
        //*  39   77:iflt            96
        //*  40   80:aload_0         
        //*  41   81:getfield        #90  <Field int[] m_IndicesBuffer>
        //*  42   84:iload_3         
        //*  43   85:iaload          
        //*  44   86:aload_0         
        //*  45   87:getfield        #41  <Field Instances m_Data>
        //*  46   90:invokevirtual   #86  <Method int Instances.numAttributes()>
        //*  47   93:icmplt          102
                    errorMessage("index out of bounds");
        //   48   96:aload_0         
        //   49   97:ldc1            #246 <String "index out of bounds">
        //   50   99:invokevirtual   #163 <Method void errorMessage(String)>
                maxIndex = m_IndicesBuffer[numValues];
        //   51  102:aload_0         
        //   52  103:getfield        #90  <Field int[] m_IndicesBuffer>
        //   53  106:iload_3         
        //   54  107:iaload          
        //   55  108:istore          4
                getNextToken();
        //   56  110:aload_0         
        //   57  111:invokevirtual   #248 <Method void getNextToken()>
                if(m_Tokenizer.ttype == 63)
        //*  58  114:aload_0         
        //*  59  115:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  60  118:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  61  121:bipush          63
        //*  62  123:icmpne          138
                {
                    m_ValueBuffer[numValues] = Instance.missingValue();
        //   63  126:aload_0         
        //   64  127:getfield        #88  <Field double[] m_ValueBuffer>
        //   65  130:iload_3         
        //   66  131:invokestatic    #253 <Method double Instance.missingValue()>
        //   67  134:dastore         
                } else
        //*  68  135:goto            408
                {
                    if(m_Tokenizer.ttype != -3)
        //*  69  138:aload_0         
        //*  70  139:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  71  142:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  72  145:bipush          -3
        //*  73  147:icmpeq          156
                        errorMessage("not a valid value");
        //   74  150:aload_0         
        //   75  151:ldc1            #255 <String "not a valid value">
        //   76  153:invokevirtual   #163 <Method void errorMessage(String)>
                    switch(m_Data.attribute(m_IndicesBuffer[numValues]).type())
        //*  77  156:aload_0         
        //*  78  157:getfield        #41  <Field Instances m_Data>
        //*  79  160:aload_0         
        //*  80  161:getfield        #90  <Field int[] m_IndicesBuffer>
        //*  81  164:iload_3         
        //*  82  165:iaload          
        //*  83  166:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //*  84  169:invokevirtual   #264 <Method int Attribute.type()>
                    {
        //*  85  172:tableswitch     0 3: default 382
        //                       0 251
        //                       1 204
        //                       2 285
        //                       3 318
                    case 1: // '\001'
                        int valIndex = m_Data.attribute(m_IndicesBuffer[numValues]).indexOfValue(m_Tokenizer.sval);
        //   86  204:aload_0         
        //   87  205:getfield        #41  <Field Instances m_Data>
        //   88  208:aload_0         
        //   89  209:getfield        #90  <Field int[] m_IndicesBuffer>
        //   90  212:iload_3         
        //   91  213:iaload          
        //   92  214:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //   93  217:aload_0         
        //   94  218:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   95  221:getfield        #152 <Field String StreamTokenizer.sval>
        //   96  224:invokevirtual   #267 <Method int Attribute.indexOfValue(String)>
        //   97  227:istore_2        
                        if(valIndex == -1)
        //*  98  228:iload_2         
        //*  99  229:iconst_m1       
        //* 100  230:icmpne          240
                            errorMessage("nominal value not declared in header");
        //  101  233:aload_0         
        //  102  234:ldc2            #269 <String "nominal value not declared in header">
        //  103  237:invokevirtual   #163 <Method void errorMessage(String)>
                        m_ValueBuffer[numValues] = valIndex;
        //  104  240:aload_0         
        //  105  241:getfield        #88  <Field double[] m_ValueBuffer>
        //  106  244:iload_3         
        //  107  245:iload_2         
        //  108  246:i2d             
        //  109  247:dastore         
                        break;
        //  110  248:goto            408

                    case 0: // '\0'
                        try
                        {
                            m_ValueBuffer[numValues] = Double.valueOf(m_Tokenizer.sval).doubleValue();
        //  111  251:aload_0         
        //  112  252:getfield        #88  <Field double[] m_ValueBuffer>
        //  113  255:iload_3         
        //  114  256:aload_0         
        //  115  257:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  116  260:getfield        #152 <Field String StreamTokenizer.sval>
        //  117  263:invokestatic    #272 <Method Double Double.valueOf(String)>
        //  118  266:invokevirtual   #275 <Method double Double.doubleValue()>
        //  119  269:dastore         
                        }
        //* 120  270:goto            408
                        catch(NumberFormatException e)
        //* 121  273:astore          5
                        {
                            errorMessage("number expected");
        //  122  275:aload_0         
        //  123  276:ldc2            #277 <String "number expected">
        //  124  279:invokevirtual   #163 <Method void errorMessage(String)>
                        }
                        break;
        //  125  282:goto            408

                    case 2: // '\002'
                        m_ValueBuffer[numValues] = m_Data.attribute(m_IndicesBuffer[numValues]).addStringValue(m_Tokenizer.sval);
        //  126  285:aload_0         
        //  127  286:getfield        #88  <Field double[] m_ValueBuffer>
        //  128  289:iload_3         
        //  129  290:aload_0         
        //  130  291:getfield        #41  <Field Instances m_Data>
        //  131  294:aload_0         
        //  132  295:getfield        #90  <Field int[] m_IndicesBuffer>
        //  133  298:iload_3         
        //  134  299:iaload          
        //  135  300:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //  136  303:aload_0         
        //  137  304:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  138  307:getfield        #152 <Field String StreamTokenizer.sval>
        //  139  310:invokevirtual   #280 <Method int Attribute.addStringValue(String)>
        //  140  313:i2d             
        //  141  314:dastore         
                        break;
        //  142  315:goto            408

                    case 3: // '\003'
                        try
                        {
                            m_ValueBuffer[numValues] = m_Data.attribute(m_IndicesBuffer[numValues]).parseDate(m_Tokenizer.sval);
        //  143  318:aload_0         
        //  144  319:getfield        #88  <Field double[] m_ValueBuffer>
        //  145  322:iload_3         
        //  146  323:aload_0         
        //  147  324:getfield        #41  <Field Instances m_Data>
        //  148  327:aload_0         
        //  149  328:getfield        #90  <Field int[] m_IndicesBuffer>
        //  150  331:iload_3         
        //  151  332:iaload          
        //  152  333:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //  153  336:aload_0         
        //  154  337:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  155  340:getfield        #152 <Field String StreamTokenizer.sval>
        //  156  343:invokevirtual   #283 <Method double Attribute.parseDate(String)>
        //  157  346:dastore         
                        }
        //* 158  347:goto            408
                        catch(ParseException e)
        //* 159  350:astore          5
                        {
                            errorMessage((new StringBuilder("unparseable date: ")).append(m_Tokenizer.sval).toString());
        //  160  352:aload_0         
        //  161  353:new             #94  <Class StringBuilder>
        //  162  356:dup             
        //  163  357:ldc2            #285 <String "unparseable date: ">
        //  164  360:invokespecial   #101 <Method void StringBuilder(String)>
        //  165  363:aload_0         
        //  166  364:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  167  367:getfield        #152 <Field String StreamTokenizer.sval>
        //  168  370:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  169  373:invokevirtual   #112 <Method String StringBuilder.toString()>
        //  170  376:invokevirtual   #163 <Method void errorMessage(String)>
                        }
                        break;

        //* 171  379:goto            408
                    default:
                        errorMessage((new StringBuilder("unknown attribute type in column ")).append(m_IndicesBuffer[numValues]).toString());
        //  172  382:aload_0         
        //  173  383:new             #94  <Class StringBuilder>
        //  174  386:dup             
        //  175  387:ldc2            #287 <String "unknown attribute type in column ">
        //  176  390:invokespecial   #101 <Method void StringBuilder(String)>
        //  177  393:aload_0         
        //  178  394:getfield        #90  <Field int[] m_IndicesBuffer>
        //  179  397:iload_3         
        //  180  398:iaload          
        //  181  399:invokevirtual   #133 <Method StringBuilder StringBuilder.append(int)>
        //  182  402:invokevirtual   #112 <Method String StringBuilder.toString()>
        //  183  405:invokevirtual   #163 <Method void errorMessage(String)>
                        break;
                    }
                }
                numValues++;
        //  184  408:iinc            3  1
            } while(true);
        //  185  411:goto            5
            double weight = 1.0D;
        //  186  414:dconst_1        
        //  187  415:dstore          5
            if(flag)
        //* 188  417:iload_1         
        //* 189  418:ifeq            446
            {
                weight = getInstanceWeight();
        //  190  421:aload_0         
        //  191  422:invokevirtual   #289 <Method double getInstanceWeight()>
        //  192  425:dstore          5
                if(!Double.isNaN(weight))
        //* 193  427:dload           5
        //* 194  429:invokestatic    #293 <Method boolean Double.isNaN(double)>
        //* 195  432:ifne            443
                    getLastToken(true);
        //  196  435:aload_0         
        //  197  436:iconst_1        
        //  198  437:invokevirtual   #295 <Method void getLastToken(boolean)>
                else
        //* 199  440:goto            446
                    weight = 1.0D;
        //  200  443:dconst_1        
        //  201  444:dstore          5
            }
            double tempValues[] = new double[numValues];
        //  202  446:iload_3         
        //  203  447:newarray        double[]
        //  204  449:astore          7
            int tempIndices[] = new int[numValues];
        //  205  451:iload_3         
        //  206  452:newarray        int[]
        //  207  454:astore          8
            System.arraycopy(m_ValueBuffer, 0, tempValues, 0, numValues);
        //  208  456:aload_0         
        //  209  457:getfield        #88  <Field double[] m_ValueBuffer>
        //  210  460:iconst_0        
        //  211  461:aload           7
        //  212  463:iconst_0        
        //  213  464:iload_3         
        //  214  465:invokestatic    #301 <Method void System.arraycopy(Object, int, Object, int, int)>
            System.arraycopy(m_IndicesBuffer, 0, tempIndices, 0, numValues);
        //  215  468:aload_0         
        //  216  469:getfield        #90  <Field int[] m_IndicesBuffer>
        //  217  472:iconst_0        
        //  218  473:aload           8
        //  219  475:iconst_0        
        //  220  476:iload_3         
        //  221  477:invokestatic    #301 <Method void System.arraycopy(Object, int, Object, int, int)>
            Instance inst = new SparseInstance(weight, tempValues, tempIndices, m_Data.numAttributes());
        //  222  480:new             #303 <Class SparseInstance>
        //  223  483:dup             
        //  224  484:dload           5
        //  225  486:aload           7
        //  226  488:aload           8
        //  227  490:aload_0         
        //  228  491:getfield        #41  <Field Instances m_Data>
        //  229  494:invokevirtual   #86  <Method int Instances.numAttributes()>
        //  230  497:invokespecial   #306 <Method void SparseInstance(double, double[], int[], int)>
        //  231  500:astore          9
            inst.setDataset(m_Data);
        //  232  502:aload           9
        //  233  504:aload_0         
        //  234  505:getfield        #41  <Field Instances m_Data>
        //  235  508:invokevirtual   #310 <Method void Instance.setDataset(Instances)>
            return inst;
        //  236  511:aload           9
        //  237  513:areturn         
        }

        protected Instance getInstanceFull(boolean flag)
            throws IOException
        {
            double instance[] = new double[m_Data.numAttributes()];
        //    0    0:aload_0         
        //    1    1:getfield        #41  <Field Instances m_Data>
        //    2    4:invokevirtual   #86  <Method int Instances.numAttributes()>
        //    3    7:newarray        double[]
        //    4    9:astore_2        
            for(int i = 0; i < m_Data.numAttributes(); i++)
        //*   5   10:iconst_0        
        //*   6   11:istore          4
        //*   7   13:goto            291
            {
                if(i > 0)
        //*   8   16:iload           4
        //*   9   18:ifle            25
                    getNextToken();
        //   10   21:aload_0         
        //   11   22:invokevirtual   #248 <Method void getNextToken()>
                if(m_Tokenizer.ttype == 63)
        //*  12   25:aload_0         
        //*  13   26:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  14   29:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  15   32:bipush          63
        //*  16   34:icmpne          47
                {
                    instance[i] = Instance.missingValue();
        //   17   37:aload_2         
        //   18   38:iload           4
        //   19   40:invokestatic    #253 <Method double Instance.missingValue()>
        //   20   43:dastore         
                } else
        //*  21   44:goto            288
                {
                    if(m_Tokenizer.ttype != -3)
        //*  22   47:aload_0         
        //*  23   48:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  24   51:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  25   54:bipush          -3
        //*  26   56:icmpeq          65
                        errorMessage("not a valid value");
        //   27   59:aload_0         
        //   28   60:ldc1            #255 <String "not a valid value">
        //   29   62:invokevirtual   #163 <Method void errorMessage(String)>
                    switch(m_Data.attribute(i).type())
        //*  30   65:aload_0         
        //*  31   66:getfield        #41  <Field Instances m_Data>
        //*  32   69:iload           4
        //*  33   71:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //*  34   74:invokevirtual   #264 <Method int Attribute.type()>
                    {
        //*  35   77:tableswitch     0 3: default 266
        //                       0 149
        //                       1 108
        //                       2 181
        //                       3 208
                    case 1: // '\001'
                        int index = m_Data.attribute(i).indexOfValue(m_Tokenizer.sval);
        //   36  108:aload_0         
        //   37  109:getfield        #41  <Field Instances m_Data>
        //   38  112:iload           4
        //   39  114:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //   40  117:aload_0         
        //   41  118:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   42  121:getfield        #152 <Field String StreamTokenizer.sval>
        //   43  124:invokevirtual   #267 <Method int Attribute.indexOfValue(String)>
        //   44  127:istore_3        
                        if(index == -1)
        //*  45  128:iload_3         
        //*  46  129:iconst_m1       
        //*  47  130:icmpne          140
                            errorMessage("nominal value not declared in header");
        //   48  133:aload_0         
        //   49  134:ldc2            #269 <String "nominal value not declared in header">
        //   50  137:invokevirtual   #163 <Method void errorMessage(String)>
                        instance[i] = index;
        //   51  140:aload_2         
        //   52  141:iload           4
        //   53  143:iload_3         
        //   54  144:i2d             
        //   55  145:dastore         
                        break;
        //   56  146:goto            288

                    case 0: // '\0'
                        try
                        {
                            instance[i] = Double.valueOf(m_Tokenizer.sval).doubleValue();
        //   57  149:aload_2         
        //   58  150:iload           4
        //   59  152:aload_0         
        //   60  153:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   61  156:getfield        #152 <Field String StreamTokenizer.sval>
        //   62  159:invokestatic    #272 <Method Double Double.valueOf(String)>
        //   63  162:invokevirtual   #275 <Method double Double.doubleValue()>
        //   64  165:dastore         
                        }
        //*  65  166:goto            288
                        catch(NumberFormatException e)
        //*  66  169:astore          5
                        {
                            errorMessage("number expected");
        //   67  171:aload_0         
        //   68  172:ldc2            #277 <String "number expected">
        //   69  175:invokevirtual   #163 <Method void errorMessage(String)>
                        }
                        break;
        //   70  178:goto            288

                    case 2: // '\002'
                        instance[i] = m_Data.attribute(i).addStringValue(m_Tokenizer.sval);
        //   71  181:aload_2         
        //   72  182:iload           4
        //   73  184:aload_0         
        //   74  185:getfield        #41  <Field Instances m_Data>
        //   75  188:iload           4
        //   76  190:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //   77  193:aload_0         
        //   78  194:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   79  197:getfield        #152 <Field String StreamTokenizer.sval>
        //   80  200:invokevirtual   #280 <Method int Attribute.addStringValue(String)>
        //   81  203:i2d             
        //   82  204:dastore         
                        break;
        //   83  205:goto            288

                    case 3: // '\003'
                        try
                        {
                            instance[i] = m_Data.attribute(i).parseDate(m_Tokenizer.sval);
        //   84  208:aload_2         
        //   85  209:iload           4
        //   86  211:aload_0         
        //   87  212:getfield        #41  <Field Instances m_Data>
        //   88  215:iload           4
        //   89  217:invokevirtual   #259 <Method Attribute Instances.attribute(int)>
        //   90  220:aload_0         
        //   91  221:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   92  224:getfield        #152 <Field String StreamTokenizer.sval>
        //   93  227:invokevirtual   #283 <Method double Attribute.parseDate(String)>
        //   94  230:dastore         
                        }
        //*  95  231:goto            288
                        catch(ParseException e)
        //*  96  234:astore          5
                        {
                            errorMessage((new StringBuilder("unparseable date: ")).append(m_Tokenizer.sval).toString());
        //   97  236:aload_0         
        //   98  237:new             #94  <Class StringBuilder>
        //   99  240:dup             
        //  100  241:ldc2            #285 <String "unparseable date: ">
        //  101  244:invokespecial   #101 <Method void StringBuilder(String)>
        //  102  247:aload_0         
        //  103  248:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  104  251:getfield        #152 <Field String StreamTokenizer.sval>
        //  105  254:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  106  257:invokevirtual   #112 <Method String StringBuilder.toString()>
        //  107  260:invokevirtual   #163 <Method void errorMessage(String)>
                        }
                        break;

        //* 108  263:goto            288
                    default:
                        errorMessage((new StringBuilder("unknown attribute type in column ")).append(i).toString());
        //  109  266:aload_0         
        //  110  267:new             #94  <Class StringBuilder>
        //  111  270:dup             
        //  112  271:ldc2            #287 <String "unknown attribute type in column ">
        //  113  274:invokespecial   #101 <Method void StringBuilder(String)>
        //  114  277:iload           4
        //  115  279:invokevirtual   #133 <Method StringBuilder StringBuilder.append(int)>
        //  116  282:invokevirtual   #112 <Method String StringBuilder.toString()>
        //  117  285:invokevirtual   #163 <Method void errorMessage(String)>
                        break;
                    }
                }
            }

        //  118  288:iinc            4  1
        //  119  291:iload           4
        //  120  293:aload_0         
        //  121  294:getfield        #41  <Field Instances m_Data>
        //  122  297:invokevirtual   #86  <Method int Instances.numAttributes()>
        //  123  300:icmplt          16
            double weight = 1.0D;
        //  124  303:dconst_1        
        //  125  304:dstore          4
            if(flag)
        //* 126  306:iload_1         
        //* 127  307:ifeq            335
            {
                weight = getInstanceWeight();
        //  128  310:aload_0         
        //  129  311:invokevirtual   #289 <Method double getInstanceWeight()>
        //  130  314:dstore          4
                if(!Double.isNaN(weight))
        //* 131  316:dload           4
        //* 132  318:invokestatic    #293 <Method boolean Double.isNaN(double)>
        //* 133  321:ifne            332
                    getLastToken(true);
        //  134  324:aload_0         
        //  135  325:iconst_1        
        //  136  326:invokevirtual   #295 <Method void getLastToken(boolean)>
                else
        //* 137  329:goto            335
                    weight = 1.0D;
        //  138  332:dconst_1        
        //  139  333:dstore          4
            }
            Instance inst = new Instance(weight, instance);
        //  140  335:new             #250 <Class Instance>
        //  141  338:dup             
        //  142  339:dload           4
        //  143  341:aload_2         
        //  144  342:invokespecial   #321 <Method void Instance(double, double[])>
        //  145  345:astore          6
            inst.setDataset(m_Data);
        //  146  347:aload           6
        //  147  349:aload_0         
        //  148  350:getfield        #41  <Field Instances m_Data>
        //  149  353:invokevirtual   #310 <Method void Instance.setDataset(Instances)>
            return inst;
        //  150  356:aload           6
        //  151  358:areturn         
        }

        protected void readHeader(int capacity)
            throws IOException
        {
            m_Lines = 0;
        //    0    0:aload_0         
        //    1    1:iconst_0        
        //    2    2:putfield        #79  <Field int m_Lines>
            String relationName = "";
        //    3    5:ldc1            #116 <String "">
        //    4    7:astore_2        
            getFirstToken();
        //    5    8:aload_0         
        //    6    9:invokevirtual   #225 <Method void getFirstToken()>
            if(m_Tokenizer.ttype == -1)
        //*   7   12:aload_0         
        //*   8   13:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*   9   16:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  10   19:iconst_m1       
        //*  11   20:icmpne          29
                errorMessage("premature end of file");
        //   12   23:aload_0         
        //   13   24:ldc1            #165 <String "premature end of file">
        //   14   26:invokevirtual   #163 <Method void errorMessage(String)>
            if("@atributesof".equalsIgnoreCase(m_Tokenizer.sval))
        //*  15   29:ldc2            #326 <String "@atributesof">
        //*  16   32:aload_0         
        //*  17   33:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  18   36:getfield        #152 <Field String StreamTokenizer.sval>
        //*  19   39:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  20   42:ifeq            65
            {
                getNextToken();
        //   21   45:aload_0         
        //   22   46:invokevirtual   #248 <Method void getNextToken()>
                relationName = m_Tokenizer.sval;
        //   23   49:aload_0         
        //   24   50:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   25   53:getfield        #152 <Field String StreamTokenizer.sval>
        //   26   56:astore_2        
                getLastToken(false);
        //   27   57:aload_0         
        //   28   58:iconst_0        
        //   29   59:invokevirtual   #295 <Method void getLastToken(boolean)>
            } else
        //*  30   62:goto            72
            {
                errorMessage("keyword @atributesof expected");
        //   31   65:aload_0         
        //   32   66:ldc2            #332 <String "keyword @atributesof expected">
        //   33   69:invokevirtual   #163 <Method void errorMessage(String)>
            }
            FastVector attributes = new FastVector();
        //   34   72:new             #334 <Class FastVector>
        //   35   75:dup             
        //   36   76:invokespecial   #335 <Method void FastVector()>
        //   37   79:astore_3        
            getFirstToken();
        //   38   80:aload_0         
        //   39   81:invokevirtual   #225 <Method void getFirstToken()>
            if(m_Tokenizer.ttype == -1)
        //*  40   84:aload_0         
        //*  41   85:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  42   88:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  43   91:iconst_m1       
        //*  44   92:icmpne          110
                errorMessage("premature end of file");
        //   45   95:aload_0         
        //   46   96:ldc1            #165 <String "premature end of file">
        //   47   98:invokevirtual   #163 <Method void errorMessage(String)>
        //*  48  101:goto            110
            while("@attribute".equalsIgnoreCase(m_Tokenizer.sval)) 
                attributes = parseAttribute(attributes);
        //   49  104:aload_0         
        //   50  105:aload_3         
        //   51  106:invokevirtual   #339 <Method FastVector parseAttribute(FastVector)>
        //   52  109:astore_3        
        //   53  110:ldc2            #341 <String "@attribute">
        //   54  113:aload_0         
        //   55  114:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   56  117:getfield        #152 <Field String StreamTokenizer.sval>
        //   57  120:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //   58  123:ifne            104
            if(!"@data".equalsIgnoreCase(m_Tokenizer.sval))
        //*  59  126:ldc2            #343 <String "@data">
        //*  60  129:aload_0         
        //*  61  130:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  62  133:getfield        #152 <Field String StreamTokenizer.sval>
        //*  63  136:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  64  139:ifne            149
                errorMessage("keyword @data expected");
        //   65  142:aload_0         
        //   66  143:ldc2            #345 <String "keyword @data expected">
        //   67  146:invokevirtual   #163 <Method void errorMessage(String)>
            if(attributes.size() == 0)
        //*  68  149:aload_3         
        //*  69  150:invokevirtual   #348 <Method int FastVector.size()>
        //*  70  153:ifne            163
                errorMessage("no attributes declared");
        //   71  156:aload_0         
        //   72  157:ldc2            #350 <String "no attributes declared">
        //   73  160:invokevirtual   #163 <Method void errorMessage(String)>
            m_Data = new Instances(relationName, attributes, capacity);
        //   74  163:aload_0         
        //   75  164:new             #43  <Class Instances>
        //   76  167:dup             
        //   77  168:aload_2         
        //   78  169:aload_3         
        //   79  170:iload_1         
        //   80  171:invokespecial   #353 <Method void Instances(String, FastVector, int)>
        //   81  174:putfield        #41  <Field Instances m_Data>
        //   82  177:return          
        }

        protected FastVector parseAttribute(FastVector attributes)
            throws IOException
        {
            getNextToken();
        //    0    0:aload_0         
        //    1    1:invokevirtual   #248 <Method void getNextToken()>
            String attributeName = m_Tokenizer.sval;
        //    2    4:aload_0         
        //    3    5:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    4    8:getfield        #152 <Field String StreamTokenizer.sval>
        //    5   11:astore_2        
            getNextToken();
        //    6   12:aload_0         
        //    7   13:invokevirtual   #248 <Method void getNextToken()>
            if(m_Tokenizer.ttype == -3)
        //*   8   16:aload_0         
        //*   9   17:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  10   20:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  11   23:bipush          -3
        //*  12   25:icmpne          494
            {
                if(m_Tokenizer.sval.equalsIgnoreCase("real") || m_Tokenizer.sval.equalsIgnoreCase("integer") || m_Tokenizer.sval.equalsIgnoreCase("numeric"))
        //*  13   28:aload_0         
        //*  14   29:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  15   32:getfield        #152 <Field String StreamTokenizer.sval>
        //*  16   35:ldc2            #358 <String "real">
        //*  17   38:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  18   41:ifne            76
        //*  19   44:aload_0         
        //*  20   45:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  21   48:getfield        #152 <Field String StreamTokenizer.sval>
        //*  22   51:ldc2            #360 <String "integer">
        //*  23   54:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  24   57:ifne            76
        //*  25   60:aload_0         
        //*  26   61:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  27   64:getfield        #152 <Field String StreamTokenizer.sval>
        //*  28   67:ldc2            #362 <String "numeric">
        //*  29   70:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  30   73:ifeq            99
                {
                    attributes.addElement(new Attribute(attributeName, attributes.size()));
        //   31   76:aload_1         
        //   32   77:new             #261 <Class Attribute>
        //   33   80:dup             
        //   34   81:aload_2         
        //   35   82:aload_1         
        //   36   83:invokevirtual   #348 <Method int FastVector.size()>
        //   37   86:invokespecial   #365 <Method void Attribute(String, int)>
        //   38   89:invokevirtual   #369 <Method void FastVector.addElement(Object)>
                    readTillEOL();
        //   39   92:aload_0         
        //   40   93:invokevirtual   #372 <Method void readTillEOL()>
                } else
        //*  41   96:goto            593
                if(m_Tokenizer.sval.equalsIgnoreCase("string"))
        //*  42   99:aload_0         
        //*  43  100:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  44  103:getfield        #152 <Field String StreamTokenizer.sval>
        //*  45  106:ldc2            #374 <String "string">
        //*  46  109:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  47  112:ifeq            139
                {
                    attributes.addElement(new Attribute(attributeName, null, attributes.size()));
        //   48  115:aload_1         
        //   49  116:new             #261 <Class Attribute>
        //   50  119:dup             
        //   51  120:aload_2         
        //   52  121:aconst_null     
        //   53  122:aload_1         
        //   54  123:invokevirtual   #348 <Method int FastVector.size()>
        //   55  126:invokespecial   #375 <Method void Attribute(String, FastVector, int)>
        //   56  129:invokevirtual   #369 <Method void FastVector.addElement(Object)>
                    readTillEOL();
        //   57  132:aload_0         
        //   58  133:invokevirtual   #372 <Method void readTillEOL()>
                } else
        //*  59  136:goto            593
                if(m_Tokenizer.sval.equalsIgnoreCase("date"))
        //*  60  139:aload_0         
        //*  61  140:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  62  143:getfield        #152 <Field String StreamTokenizer.sval>
        //*  63  146:ldc2            #377 <String "date">
        //*  64  149:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //*  65  152:ifeq            257
                {
                    String format = null;
        //   66  155:aconst_null     
        //   67  156:astore          4
                    if(m_Tokenizer.nextToken() != 10)
        //*  68  158:aload_0         
        //*  69  159:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  70  162:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //*  71  165:bipush          10
        //*  72  167:icmpeq          229
                    {
                        if(m_Tokenizer.ttype != -3 && m_Tokenizer.ttype != 39 && m_Tokenizer.ttype != 34)
        //*  73  170:aload_0         
        //*  74  171:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  75  174:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  76  177:bipush          -3
        //*  77  179:icmpeq          213
        //*  78  182:aload_0         
        //*  79  183:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  80  186:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  81  189:bipush          39
        //*  82  191:icmpeq          213
        //*  83  194:aload_0         
        //*  84  195:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //*  85  198:getfield        #149 <Field int StreamTokenizer.ttype>
        //*  86  201:bipush          34
        //*  87  203:icmpeq          213
                            errorMessage("not a valid date format");
        //   88  206:aload_0         
        //   89  207:ldc2            #379 <String "not a valid date format">
        //   90  210:invokevirtual   #163 <Method void errorMessage(String)>
                        format = m_Tokenizer.sval;
        //   91  213:aload_0         
        //   92  214:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //   93  217:getfield        #152 <Field String StreamTokenizer.sval>
        //   94  220:astore          4
                        readTillEOL();
        //   95  222:aload_0         
        //   96  223:invokevirtual   #372 <Method void readTillEOL()>
                    } else
        //*  97  226:goto            236
                    {
                        m_Tokenizer.pushBack();
        //   98  229:aload_0         
        //   99  230:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  100  233:invokevirtual   #382 <Method void StreamTokenizer.pushBack()>
                    }
                    attributes.addElement(new Attribute(attributeName, format, attributes.size()));
        //  101  236:aload_1         
        //  102  237:new             #261 <Class Attribute>
        //  103  240:dup             
        //  104  241:aload_2         
        //  105  242:aload           4
        //  106  244:aload_1         
        //  107  245:invokevirtual   #348 <Method int FastVector.size()>
        //  108  248:invokespecial   #385 <Method void Attribute(String, String, int)>
        //  109  251:invokevirtual   #369 <Method void FastVector.addElement(Object)>
                } else
        //* 110  254:goto            593
                if(m_Tokenizer.sval.equalsIgnoreCase("relational"))
        //* 111  257:aload_0         
        //* 112  258:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 113  261:getfield        #152 <Field String StreamTokenizer.sval>
        //* 114  264:ldc2            #387 <String "relational">
        //* 115  267:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //* 116  270:ifeq            484
                {
                    readTillEOL();
        //  117  273:aload_0         
        //  118  274:invokevirtual   #372 <Method void readTillEOL()>
                    FastVector atts = attributes;
        //  119  277:aload_1         
        //  120  278:astore          4
                    attributes = new FastVector();
        //  121  280:new             #334 <Class FastVector>
        //  122  283:dup             
        //  123  284:invokespecial   #335 <Method void FastVector()>
        //  124  287:astore_1        
                    getFirstToken();
        //  125  288:aload_0         
        //  126  289:invokevirtual   #225 <Method void getFirstToken()>
                    if(m_Tokenizer.ttype == -1)
        //* 127  292:aload_0         
        //* 128  293:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 129  296:getfield        #149 <Field int StreamTokenizer.ttype>
        //* 130  299:iconst_m1       
        //* 131  300:icmpne          309
                        errorMessage("premature end of file");
        //  132  303:aload_0         
        //  133  304:ldc1            #165 <String "premature end of file">
        //  134  306:invokevirtual   #163 <Method void errorMessage(String)>
                    do
                    {
                        while("@attribute".equalsIgnoreCase(m_Tokenizer.sval)) 
        //* 135  309:ldc2            #341 <String "@attribute">
        //* 136  312:aload_0         
        //* 137  313:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 138  316:getfield        #152 <Field String StreamTokenizer.sval>
        //* 139  319:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //* 140  322:ifeq            334
                            attributes = parseAttribute(attributes);
        //  141  325:aload_0         
        //  142  326:aload_1         
        //  143  327:invokevirtual   #339 <Method FastVector parseAttribute(FastVector)>
        //  144  330:astore_1        
        //* 145  331:goto            445
                        if("@end".equalsIgnoreCase(m_Tokenizer.sval))
        //* 146  334:ldc2            #389 <String "@end">
        //* 147  337:aload_0         
        //* 148  338:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 149  341:getfield        #152 <Field String StreamTokenizer.sval>
        //* 150  344:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //* 151  347:ifeq            408
                        {
                            getNextToken();
        //  152  350:aload_0         
        //  153  351:invokevirtual   #248 <Method void getNextToken()>
                            if(!attributeName.equalsIgnoreCase(m_Tokenizer.sval))
        //* 154  354:aload_2         
        //* 155  355:aload_0         
        //* 156  356:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 157  359:getfield        #152 <Field String StreamTokenizer.sval>
        //* 158  362:invokevirtual   #330 <Method boolean String.equalsIgnoreCase(String)>
        //* 159  365:ifne            448
                                errorMessage((new StringBuilder("declaration of subrelation ")).append(attributeName).append(" must be terminated by ").append("@end ").append(attributeName).toString());
        //  160  368:aload_0         
        //  161  369:new             #94  <Class StringBuilder>
        //  162  372:dup             
        //  163  373:ldc2            #391 <String "declaration of subrelation ">
        //  164  376:invokespecial   #101 <Method void StringBuilder(String)>
        //  165  379:aload_2         
        //  166  380:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  167  383:ldc2            #393 <String " must be terminated by ">
        //  168  386:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  169  389:ldc2            #395 <String "@end ">
        //  170  392:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  171  395:aload_2         
        //  172  396:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  173  399:invokevirtual   #112 <Method String StringBuilder.toString()>
        //  174  402:invokevirtual   #163 <Method void errorMessage(String)>
                            break;
        //  175  405:goto            448
                        }
                        errorMessage((new StringBuilder("declaration of subrelation ")).append(attributeName).append(" must be terminated by ").append("@end ").append(attributeName).toString());
        //  176  408:aload_0         
        //  177  409:new             #94  <Class StringBuilder>
        //  178  412:dup             
        //  179  413:ldc2            #391 <String "declaration of subrelation ">
        //  180  416:invokespecial   #101 <Method void StringBuilder(String)>
        //  181  419:aload_2         
        //  182  420:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  183  423:ldc2            #393 <String " must be terminated by ">
        //  184  426:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  185  429:ldc2            #395 <String "@end ">
        //  186  432:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  187  435:aload_2         
        //  188  436:invokevirtual   #107 <Method StringBuilder StringBuilder.append(String)>
        //  189  439:invokevirtual   #112 <Method String StringBuilder.toString()>
        //  190  442:invokevirtual   #163 <Method void errorMessage(String)>
                    } while(true);
        //  191  445:goto            309
                    Instances relation = new Instances(attributeName, attributes, 0);
        //  192  448:new             #43  <Class Instances>
        //  193  451:dup             
        //  194  452:aload_2         
        //  195  453:aload_1         
        //  196  454:iconst_0        
        //  197  455:invokespecial   #353 <Method void Instances(String, FastVector, int)>
        //  198  458:astore          5
                    attributes = atts;
        //  199  460:aload           4
        //  200  462:astore_1        
                    attributes.addElement(new Attribute(attributeName, relation, attributes.size()));
        //  201  463:aload_1         
        //  202  464:new             #261 <Class Attribute>
        //  203  467:dup             
        //  204  468:aload_2         
        //  205  469:aload           5
        //  206  471:aload_1         
        //  207  472:invokevirtual   #348 <Method int FastVector.size()>
        //  208  475:invokespecial   #398 <Method void Attribute(String, Instances, int)>
        //  209  478:invokevirtual   #369 <Method void FastVector.addElement(Object)>
                } else
        //* 210  481:goto            593
                {
                    errorMessage("no valid attribute type or invalid enumeration");
        //  211  484:aload_0         
        //  212  485:ldc2            #400 <String "no valid attribute type or invalid enumeration">
        //  213  488:invokevirtual   #163 <Method void errorMessage(String)>
                }
            } else
        //* 214  491:goto            593
            {
                FastVector attributeValues = new FastVector();
        //  215  494:new             #334 <Class FastVector>
        //  216  497:dup             
        //  217  498:invokespecial   #335 <Method void FastVector()>
        //  218  501:astore_3        
                m_Tokenizer.pushBack();
        //  219  502:aload_0         
        //  220  503:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  221  506:invokevirtual   #382 <Method void StreamTokenizer.pushBack()>
                if(m_Tokenizer.nextToken() != 123)
        //* 222  509:aload_0         
        //* 223  510:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 224  513:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //* 225  516:bipush          123
        //* 226  518:icmpeq          564
                    errorMessage("{ expected at beginning of enumeration");
        //  227  521:aload_0         
        //  228  522:ldc2            #402 <String "{ expected at beginning of enumeration">
        //  229  525:invokevirtual   #163 <Method void errorMessage(String)>
        //* 230  528:goto            564
                while(m_Tokenizer.nextToken() != 125) 
                    if(m_Tokenizer.ttype == 10)
        //* 231  531:aload_0         
        //* 232  532:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 233  535:getfield        #149 <Field int StreamTokenizer.ttype>
        //* 234  538:bipush          10
        //* 235  540:icmpne          553
                        errorMessage("} expected at end of enumeration");
        //  236  543:aload_0         
        //  237  544:ldc2            #404 <String "} expected at end of enumeration">
        //  238  547:invokevirtual   #163 <Method void errorMessage(String)>
                    else
        //* 239  550:goto            564
                        attributeValues.addElement(m_Tokenizer.sval);
        //  240  553:aload_3         
        //  241  554:aload_0         
        //  242  555:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  243  558:getfield        #152 <Field String StreamTokenizer.sval>
        //  244  561:invokevirtual   #369 <Method void FastVector.addElement(Object)>
        //  245  564:aload_0         
        //  246  565:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //  247  568:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //  248  571:bipush          125
        //  249  573:icmpne          531
                attributes.addElement(new Attribute(attributeName, attributeValues, attributes.size()));
        //  250  576:aload_1         
        //  251  577:new             #261 <Class Attribute>
        //  252  580:dup             
        //  253  581:aload_2         
        //  254  582:aload_3         
        //  255  583:aload_1         
        //  256  584:invokevirtual   #348 <Method int FastVector.size()>
        //  257  587:invokespecial   #375 <Method void Attribute(String, FastVector, int)>
        //  258  590:invokevirtual   #369 <Method void FastVector.addElement(Object)>
            }
            getLastToken(false);
        //  259  593:aload_0         
        //  260  594:iconst_0        
        //  261  595:invokevirtual   #295 <Method void getLastToken(boolean)>
            getFirstToken();
        //  262  598:aload_0         
        //  263  599:invokevirtual   #225 <Method void getFirstToken()>
            if(m_Tokenizer.ttype == -1)
        //* 264  602:aload_0         
        //* 265  603:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //* 266  606:getfield        #149 <Field int StreamTokenizer.ttype>
        //* 267  609:iconst_m1       
        //* 268  610:icmpne          619
                errorMessage("premature end of file");
        //  269  613:aload_0         
        //  270  614:ldc1            #165 <String "premature end of file">
        //  271  616:invokevirtual   #163 <Method void errorMessage(String)>
            return attributes;
        //  272  619:aload_1         
        //  273  620:areturn         
        }

        protected void readTillEOL()
            throws IOException
        {
            while(m_Tokenizer.nextToken() != 10) ;
        //    0    0:aload_0         
        //    1    1:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    2    4:invokevirtual   #146 <Method int StreamTokenizer.nextToken()>
        //    3    7:bipush          10
        //    4    9:icmpne          0
            m_Tokenizer.pushBack();
        //    5   12:aload_0         
        //    6   13:getfield        #29  <Field StreamTokenizer m_Tokenizer>
        //    7   16:invokevirtual   #382 <Method void StreamTokenizer.pushBack()>
        //    8   19:return          
        }

        public Instances getStructure()
        {
            return new Instances(m_Data, 0);
        //    0    0:new             #43  <Class Instances>
        //    1    3:dup             
        //    2    4:aload_0         
        //    3    5:getfield        #41  <Field Instances m_Data>
        //    4    8:iconst_0        
        //    5    9:invokespecial   #82  <Method void Instances(Instances, int)>
        //    6   12:areturn         
        }

        public Instances getData()
        {
            return m_Data;
        //    0    0:aload_0         
        //    1    1:getfield        #41  <Field Instances m_Data>
        //    2    4:areturn         
        }

        protected StreamTokenizer m_Tokenizer;
        protected double m_ValueBuffer[];
        protected int m_IndicesBuffer[];
        protected Instances m_Data;
        protected int m_Lines;

        public ArffReader(Reader reader)
            throws IOException
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #23  <Method void Object()>
            m_Tokenizer = new StreamTokenizer(reader);
        //    2    4:aload_0         
        //    3    5:new             #25  <Class StreamTokenizer>
        //    4    8:dup             
        //    5    9:aload_1         
        //    6   10:invokespecial   #27  <Method void StreamTokenizer(Reader)>
        //    7   13:putfield        #29  <Field StreamTokenizer m_Tokenizer>
            initTokenizer();
        //    8   16:aload_0         
        //    9   17:invokevirtual   #32  <Method void initTokenizer()>
            readHeader(1000);
        //   10   20:aload_0         
        //   11   21:sipush          1000
        //   12   24:invokevirtual   #36  <Method void readHeader(int)>
            initBuffers();
        //   13   27:aload_0         
        //   14   28:invokevirtual   #39  <Method void initBuffers()>
        //*  15   31:goto            42
            Instance inst;
            while((inst = readInstance(m_Data)) != null) 
                m_Data.add(inst);
        //   16   34:aload_0         
        //   17   35:getfield        #41  <Field Instances m_Data>
        //   18   38:aload_2         
        //   19   39:invokevirtual   #47  <Method void Instances.add(Instance)>
        //   20   42:aload_0         
        //   21   43:aload_0         
        //   22   44:getfield        #41  <Field Instances m_Data>
        //   23   47:invokevirtual   #51  <Method Instance readInstance(Instances)>
        //   24   50:dup             
        //   25   51:astore_2        
        //   26   52:ifnonnull       34
            compactify();
        //   27   55:aload_0         
        //   28   56:invokevirtual   #54  <Method void compactify()>
        //   29   59:return          
        }

        public ArffReader(Reader reader, int capacity)
            throws IOException
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #23  <Method void Object()>
            if(capacity < 0)
        //*   2    4:iload_2         
        //*   3    5:ifge            18
            {
                throw new IllegalArgumentException("Capacity has to be positive!");
        //    4    8:new             #65  <Class IllegalArgumentException>
        //    5   11:dup             
        //    6   12:ldc1            #67  <String "Capacity has to be positive!">
        //    7   14:invokespecial   #70  <Method void IllegalArgumentException(String)>
        //    8   17:athrow          
            } else
            {
                m_Tokenizer = new StreamTokenizer(reader);
        //    9   18:aload_0         
        //   10   19:new             #25  <Class StreamTokenizer>
        //   11   22:dup             
        //   12   23:aload_1         
        //   13   24:invokespecial   #27  <Method void StreamTokenizer(Reader)>
        //   14   27:putfield        #29  <Field StreamTokenizer m_Tokenizer>
                initTokenizer();
        //   15   30:aload_0         
        //   16   31:invokevirtual   #32  <Method void initTokenizer()>
                readHeader(capacity);
        //   17   34:aload_0         
        //   18   35:iload_2         
        //   19   36:invokevirtual   #36  <Method void readHeader(int)>
                initBuffers();
        //   20   39:aload_0         
        //   21   40:invokevirtual   #39  <Method void initBuffers()>
                return;
        //   22   43:return          
            }
        }

        public ArffReader(Reader reader, Instances template, int lines)
            throws IOException
        {
            this(reader, template, lines, 100);
        //    0    0:aload_0         
        //    1    1:aload_1         
        //    2    2:aload_2         
        //    3    3:iload_3         
        //    4    4:bipush          100
        //    5    6:invokespecial   #75  <Method void ArffLoader$ArffReader(Reader, Instances, int, int)>
        //*   6    9:goto            21
            Instance inst;
            while((inst = readInstance(m_Data)) != null) 
                m_Data.add(inst);
        //    7   12:aload_0         
        //    8   13:getfield        #41  <Field Instances m_Data>
        //    9   16:aload           4
        //   10   18:invokevirtual   #47  <Method void Instances.add(Instance)>
        //   11   21:aload_0         
        //   12   22:aload_0         
        //   13   23:getfield        #41  <Field Instances m_Data>
        //   14   26:invokevirtual   #51  <Method Instance readInstance(Instances)>
        //   15   29:dup             
        //   16   30:astore          4
        //   17   32:ifnonnull       12
            compactify();
        //   18   35:aload_0         
        //   19   36:invokevirtual   #54  <Method void compactify()>
        //   20   39:return          
        }

        public ArffReader(Reader reader, Instances template, int lines, int capacity)
            throws IOException
        {
        //    0    0:aload_0         
        //    1    1:invokespecial   #23  <Method void Object()>
            m_Lines = lines;
        //    2    4:aload_0         
        //    3    5:iload_3         
        //    4    6:putfield        #79  <Field int m_Lines>
            m_Tokenizer = new StreamTokenizer(reader);
        //    5    9:aload_0         
        //    6   10:new             #25  <Class StreamTokenizer>
        //    7   13:dup             
        //    8   14:aload_1         
        //    9   15:invokespecial   #27  <Method void StreamTokenizer(Reader)>
        //   10   18:putfield        #29  <Field StreamTokenizer m_Tokenizer>
            initTokenizer();
        //   11   21:aload_0         
        //   12   22:invokevirtual   #32  <Method void initTokenizer()>
            m_Data = new Instances(template, capacity);
        //   13   25:aload_0         
        //   14   26:new             #43  <Class Instances>
        //   15   29:dup             
        //   16   30:aload_2         
        //   17   31:iload           4
        //   18   33:invokespecial   #82  <Method void Instances(Instances, int)>
        //   19   36:putfield        #41  <Field Instances m_Data>
            initBuffers();
        //   20   39:aload_0         
        //   21   40:invokevirtual   #39  <Method void initBuffers()>
        //   22   43:return          
        }
    }


    public ArffLoader()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #56  <Method void AbstractFileLoader()>
        m_URL = "http://";
    //    2    4:aload_0         
    //    3    5:ldc1            #58  <String "http://">
    //    4    7:putfield        #60  <Field String m_URL>
        m_sourceReader = null;
    //    5   10:aload_0         
    //    6   11:aconst_null     
    //    7   12:putfield        #62  <Field Reader m_sourceReader>
        m_ArffReader = null;
    //    8   15:aload_0         
    //    9   16:aconst_null     
    //   10   17:putfield        #64  <Field ArffLoader$ArffReader m_ArffReader>
    //   11   20:return          
    }

    public String globalInfo()
    {
        return "Reads a source that is in arff (attribute relation file format) format. ";
    //    0    0:ldc1            #69  <String "Reads a source that is in arff (attribute relation file format) format. ">
    //    1    2:areturn         
    }

    public String getFileExtension()
    {
        return FILE_EXTENSION;
    //    0    0:getstatic       #24  <Field String FILE_EXTENSION>
    //    1    3:areturn         
    }

    public String[] getFileExtensions()
    {
        return (new String[] {
            FILE_EXTENSION, FILE_EXTENSION_COMPRESSED, SERIALIZED_OBJ_FILE_EXTENSION
        });
    //    0    0:iconst_3        
    //    1    1:anewarray       String[]
    //    2    4:dup             
    //    3    5:iconst_0        
    //    4    6:getstatic       #24  <Field String FILE_EXTENSION>
    //    5    9:aastore         
    //    6   10:dup             
    //    7   11:iconst_1        
    //    8   12:getstatic       #48  <Field String FILE_EXTENSION_COMPRESSED>
    //    9   15:aastore         
    //   10   16:dup             
    //   11   17:iconst_2        
    //   12   18:getstatic       #52  <Field String SERIALIZED_OBJ_FILE_EXTENSION>
    //   13   21:aastore         
    //   14   22:areturn         
    }

    public String getFileDescription()
    {
        return "Ass data files";
    //    0    0:ldc1            #75  <String "Ass data files">
    //    1    2:areturn         
    }

    public void reset()
        throws IOException
    {
        m_structure = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #83  <Field Instances m_structure>
        setRetrieval(0);
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:invokevirtual   #87  <Method void setRetrieval(int)>
        if(m_File != null && !(new File(m_File)).isDirectory())
    //*   6   10:aload_0         
    //*   7   11:getfield        #90  <Field String m_File>
    //*   8   14:ifnull          52
    //*   9   17:new             #92  <Class File>
    //*  10   20:dup             
    //*  11   21:aload_0         
    //*  12   22:getfield        #90  <Field String m_File>
    //*  13   25:invokespecial   #93  <Method void File(String)>
    //*  14   28:invokevirtual   #97  <Method boolean File.isDirectory()>
    //*  15   31:ifne            52
            setFile(new File(m_File));
    //   16   34:aload_0         
    //   17   35:new             #92  <Class File>
    //   18   38:dup             
    //   19   39:aload_0         
    //   20   40:getfield        #90  <Field String m_File>
    //   21   43:invokespecial   #93  <Method void File(String)>
    //   22   46:invokevirtual   #101 <Method void setFile(File)>
        else
    //*  23   49:goto            79
        if(m_URL != null && !m_URL.equals("http://"))
    //*  24   52:aload_0         
    //*  25   53:getfield        #60  <Field String m_URL>
    //*  26   56:ifnull          79
    //*  27   59:aload_0         
    //*  28   60:getfield        #60  <Field String m_URL>
    //*  29   63:ldc1            #58  <String "http://">
    //*  30   65:invokevirtual   #105 <Method boolean String.equals(Object)>
    //*  31   68:ifne            79
            setURL(m_URL);
    //   32   71:aload_0         
    //   33   72:aload_0         
    //   34   73:getfield        #60  <Field String m_URL>
    //   35   76:invokevirtual   #108 <Method void setURL(String)>
    //   36   79:return          
    }

    public void setSource(URL url)
        throws IOException
    {
        m_structure = null;
    //    0    0:aload_0         
    //    1    1:aconst_null     
    //    2    2:putfield        #83  <Field Instances m_structure>
        setRetrieval(0);
    //    3    5:aload_0         
    //    4    6:iconst_0        
    //    5    7:invokevirtual   #87  <Method void setRetrieval(int)>
        setSource(url.openStream());
    //    6   10:aload_0         
    //    7   11:aload_1         
    //    8   12:invokevirtual   #116 <Method InputStream URL.openStream()>
    //    9   15:invokevirtual   #119 <Method void setSource(InputStream)>
        m_URL = url.toString();
    //   10   18:aload_0         
    //   11   19:aload_1         
    //   12   20:invokevirtual   #120 <Method String URL.toString()>
    //   13   23:putfield        #60  <Field String m_URL>
        m_File = null;
    //   14   26:aload_0         
    //   15   27:aconst_null     
    //   16   28:putfield        #90  <Field String m_File>
    //   17   31:return          
    }

    public File retrieveFile()
    {
        return new File(m_File);
    //    0    0:new             #92  <Class File>
    //    1    3:dup             
    //    2    4:aload_0         
    //    3    5:getfield        #90  <Field String m_File>
    //    4    8:invokespecial   #93  <Method void File(String)>
    //    5   11:areturn         
    }

    public void setFile(File file)
        throws IOException
    {
        m_File = file.getPath();
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:invokevirtual   #127 <Method String File.getPath()>
    //    3    5:putfield        #90  <Field String m_File>
        setSource(file);
    //    4    8:aload_0         
    //    5    9:aload_1         
    //    6   10:invokevirtual   #129 <Method void setSource(File)>
    //    7   13:return          
    }

    public void setURL(String url)
        throws IOException
    {
        m_URL = url;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #60  <Field String m_URL>
        setSource(new URL(url));
    //    3    5:aload_0         
    //    4    6:new             #112 <Class URL>
    //    5    9:dup             
    //    6   10:aload_1         
    //    7   11:invokespecial   #132 <Method void URL(String)>
    //    8   14:invokevirtual   #134 <Method void setSource(URL)>
    //    9   17:return          
    }

    public String retrieveURL()
    {
        return m_URL;
    //    0    0:aload_0         
    //    1    1:getfield        #60  <Field String m_URL>
    //    2    4:areturn         
    }

    public void setSource(InputStream in)
        throws IOException
    {
        m_File = (new File(System.getProperty("user.dir"))).getAbsolutePath();
    //    0    0:aload_0         
    //    1    1:new             #92  <Class File>
    //    2    4:dup             
    //    3    5:ldc1            #137 <String "user.dir">
    //    4    7:invokestatic    #143 <Method String System.getProperty(String)>
    //    5   10:invokespecial   #93  <Method void File(String)>
    //    6   13:invokevirtual   #146 <Method String File.getAbsolutePath()>
    //    7   16:putfield        #90  <Field String m_File>
        m_URL = "http://";
    //    8   19:aload_0         
    //    9   20:ldc1            #58  <String "http://">
    //   10   22:putfield        #60  <Field String m_URL>
        m_sourceReader = new BufferedReader(new InputStreamReader(in));
    //   11   25:aload_0         
    //   12   26:new             #148 <Class BufferedReader>
    //   13   29:dup             
    //   14   30:new             #150 <Class InputStreamReader>
    //   15   33:dup             
    //   16   34:aload_1         
    //   17   35:invokespecial   #152 <Method void InputStreamReader(InputStream)>
    //   18   38:invokespecial   #155 <Method void BufferedReader(Reader)>
    //   19   41:putfield        #62  <Field Reader m_sourceReader>
    //   20   44:return          
    }

    public Instances getStructure()
        throws IOException
    {
        if(m_sourceReader == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #62  <Field Reader m_sourceReader>
    //*   2    4:ifnonnull       17
            throw new IOException("No source has been specified");
    //    3    7:new             #79  <Class IOException>
    //    4   10:dup             
    //    5   11:ldc1            #161 <String "No source has been specified">
    //    6   13:invokespecial   #162 <Method void IOException(String)>
    //    7   16:athrow          
        if(m_structure == null)
    //*   8   17:aload_0         
    //*   9   18:getfield        #83  <Field Instances m_structure>
    //*  10   21:ifnonnull       87
            try
            {
                m_ArffReader = new ArffReader(m_sourceReader, 1);
    //   11   24:aload_0         
    //   12   25:new             #164 <Class ArffLoader$ArffReader>
    //   13   28:dup             
    //   14   29:aload_0         
    //   15   30:getfield        #62  <Field Reader m_sourceReader>
    //   16   33:iconst_1        
    //   17   34:invokespecial   #167 <Method void ArffLoader$ArffReader(Reader, int)>
    //   18   37:putfield        #64  <Field ArffLoader$ArffReader m_ArffReader>
                m_structure = m_ArffReader.getStructure();
    //   19   40:aload_0         
    //   20   41:aload_0         
    //   21   42:getfield        #64  <Field ArffLoader$ArffReader m_ArffReader>
    //   22   45:invokevirtual   #169 <Method Instances ArffLoader$ArffReader.getStructure()>
    //   23   48:putfield        #83  <Field Instances m_structure>
            }
    //*  24   51:goto            87
            catch(Exception ex)
    //*  25   54:astore_1        
            {
                throw new IOException((new StringBuilder("Unable to determine structure as arff (Reason: ")).append(ex.toString()).append(").").toString());
    //   26   55:new             #79  <Class IOException>
    //   27   58:dup             
    //   28   59:new             #26  <Class StringBuilder>
    //   29   62:dup             
    //   30   63:ldc1            #171 <String "Unable to determine structure as arff (Reason: ">
    //   31   65:invokespecial   #36  <Method void StringBuilder(String)>
    //   32   68:aload_1         
    //   33   69:invokevirtual   #174 <Method String Exception.toString()>
    //   34   72:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //   35   75:ldc1            #176 <String ").">
    //   36   77:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //   37   80:invokevirtual   #46  <Method String StringBuilder.toString()>
    //   38   83:invokespecial   #162 <Method void IOException(String)>
    //   39   86:athrow          
            }
        return new Instances(m_structure, 0);
    //   40   87:new             #178 <Class Instances>
    //   41   90:dup             
    //   42   91:aload_0         
    //   43   92:getfield        #83  <Field Instances m_structure>
    //   44   95:iconst_0        
    //   45   96:invokespecial   #181 <Method void Instances(Instances, int)>
    //   46   99:areturn         
    }

    public Instances getDataSet()
        throws IOException
    {
        if(m_sourceReader == null)
    //*   0    0:aload_0         
    //*   1    1:getfield        #62  <Field Reader m_sourceReader>
    //*   2    4:ifnonnull       17
            throw new IOException("No source has been specified");
    //    3    7:new             #79  <Class IOException>
    //    4   10:dup             
    //    5   11:ldc1            #161 <String "No source has been specified">
    //    6   13:invokespecial   #162 <Method void IOException(String)>
    //    7   16:athrow          
        if(getRetrieval() == 2)
    //*   8   17:aload_0         
    //*   9   18:invokevirtual   #188 <Method int getRetrieval()>
    //*  10   21:iconst_2        
    //*  11   22:icmpne          35
            throw new IOException("Cannot mix getting Instances in both incremental and batch modes");
    //   12   25:new             #79  <Class IOException>
    //   13   28:dup             
    //   14   29:ldc1            #190 <String "Cannot mix getting Instances in both incremental and batch modes">
    //   15   31:invokespecial   #162 <Method void IOException(String)>
    //   16   34:athrow          
        setRetrieval(1);
    //   17   35:aload_0         
    //   18   36:iconst_1        
    //   19   37:invokevirtual   #87  <Method void setRetrieval(int)>
        if(m_structure == null)
    //*  20   40:aload_0         
    //*  21   41:getfield        #83  <Field Instances m_structure>
    //*  22   44:ifnonnull       63
            getStructure();
    //   23   47:aload_0         
    //   24   48:invokevirtual   #191 <Method Instances getStructure()>
    //   25   51:pop             
    //*  26   52:goto            63
        Instance inst;
        while((inst = m_ArffReader.readInstance(m_structure)) != null) 
            m_structure.add(inst);
    //   27   55:aload_0         
    //   28   56:getfield        #83  <Field Instances m_structure>
    //   29   59:aload_1         
    //   30   60:invokevirtual   #195 <Method void Instances.add(Instance)>
    //   31   63:aload_0         
    //   32   64:getfield        #64  <Field ArffLoader$ArffReader m_ArffReader>
    //   33   67:aload_0         
    //   34   68:getfield        #83  <Field Instances m_structure>
    //   35   71:invokevirtual   #199 <Method Instance ArffLoader$ArffReader.readInstance(Instances)>
    //   36   74:dup             
    //   37   75:astore_1        
    //   38   76:ifnonnull       55
        Instances readIn = new Instances(m_structure);
    //   39   79:new             #178 <Class Instances>
    //   40   82:dup             
    //   41   83:aload_0         
    //   42   84:getfield        #83  <Field Instances m_structure>
    //   43   87:invokespecial   #202 <Method void Instances(Instances)>
    //   44   90:astore_2        
        m_sourceReader.close();
    //   45   91:aload_0         
    //   46   92:getfield        #62  <Field Reader m_sourceReader>
    //   47   95:invokevirtual   #207 <Method void Reader.close()>
        return readIn;
    //   48   98:aload_2         
    //   49   99:areturn         
    }

    public Instance getNextInstance(Instances structure)
        throws IOException
    {
        m_structure = structure;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #83  <Field Instances m_structure>
        if(getRetrieval() == 1)
    //*   3    5:aload_0         
    //*   4    6:invokevirtual   #188 <Method int getRetrieval()>
    //*   5    9:iconst_1        
    //*   6   10:icmpne          23
            throw new IOException("Cannot mix getting Instances in both incremental and batch modes");
    //    7   13:new             #79  <Class IOException>
    //    8   16:dup             
    //    9   17:ldc1            #190 <String "Cannot mix getting Instances in both incremental and batch modes">
    //   10   19:invokespecial   #162 <Method void IOException(String)>
    //   11   22:athrow          
        setRetrieval(2);
    //   12   23:aload_0         
    //   13   24:iconst_2        
    //   14   25:invokevirtual   #87  <Method void setRetrieval(int)>
        Instance current = m_ArffReader.readInstance(m_structure);
    //   15   28:aload_0         
    //   16   29:getfield        #64  <Field ArffLoader$ArffReader m_ArffReader>
    //   17   32:aload_0         
    //   18   33:getfield        #83  <Field Instances m_structure>
    //   19   36:invokevirtual   #199 <Method Instance ArffLoader$ArffReader.readInstance(Instances)>
    //   20   39:astore_2        
        if(current == null)
    //*  21   40:aload_2         
    //*  22   41:ifnonnull       59
            try
            {
                m_sourceReader.close();
    //   23   44:aload_0         
    //   24   45:getfield        #62  <Field Reader m_sourceReader>
    //   25   48:invokevirtual   #207 <Method void Reader.close()>
            }
    //*  26   51:goto            59
            catch(Exception ex)
    //*  27   54:astore_3        
            {
                ex.printStackTrace();
    //   28   55:aload_3         
    //   29   56:invokevirtual   #214 <Method void Exception.printStackTrace()>
            }
        return current;
    //   30   59:aload_2         
    //   31   60:areturn         
    }

    public static void main(String args[])
    {
        AbstractFileLoader.runFileLoader(new ArffLoader(), args);
    //    0    0:new             #2   <Class ArffLoader>
    //    1    3:dup             
    //    2    4:invokespecial   #219 <Method void ArffLoader()>
    //    3    7:aload_0         
    //    4    8:invokestatic    #223 <Method void AbstractFileLoader.runFileLoader(AbstractFileLoader, String[])>
    //    5   11:return          
    }

    public static String FILE_EXTENSION;
    public static String FILE_EXTENSION_COMPRESSED;
    public static String SERIALIZED_OBJ_FILE_EXTENSION = ".bsi";
    protected String m_URL;
    protected transient Reader m_sourceReader;
    protected transient ArffReader m_ArffReader;

    static 
    {
        FILE_EXTENSION = ".ass";
    //    0    0:ldc1            #22  <String ".ass">
    //    1    2:putstatic       #24  <Field String FILE_EXTENSION>
        FILE_EXTENSION_COMPRESSED = (new StringBuilder(String.valueOf(FILE_EXTENSION))).append(".gz").toString();
    //    2    5:new             #26  <Class StringBuilder>
    //    3    8:dup             
    //    4    9:getstatic       #24  <Field String FILE_EXTENSION>
    //    5   12:invokestatic    #32  <Method String String.valueOf(Object)>
    //    6   15:invokespecial   #36  <Method void StringBuilder(String)>
    //    7   18:ldc1            #38  <String ".gz">
    //    8   20:invokevirtual   #42  <Method StringBuilder StringBuilder.append(String)>
    //    9   23:invokevirtual   #46  <Method String StringBuilder.toString()>
    //   10   26:putstatic       #48  <Field String FILE_EXTENSION_COMPRESSED>
    //   11   29:ldc1            #50  <String ".bsi">
    //   12   31:putstatic       #52  <Field String SERIALIZED_OBJ_FILE_EXTENSION>
    //*  13   34:return          
    }
}

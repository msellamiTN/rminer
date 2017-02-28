// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   AttributePanelEvent.java

package rm.gui.visualize;


public class AttributePanelEvent
{

    public AttributePanelEvent(boolean xChange, boolean yChange, int indexVal)
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #15  <Method void Object()>
        m_xChange = xChange;
    //    2    4:aload_0         
    //    3    5:iload_1         
    //    4    6:putfield        #17  <Field boolean m_xChange>
        m_yChange = yChange;
    //    5    9:aload_0         
    //    6   10:iload_2         
    //    7   11:putfield        #19  <Field boolean m_yChange>
        m_indexVal = indexVal;
    //    8   14:aload_0         
    //    9   15:iload_3         
    //   10   16:putfield        #21  <Field int m_indexVal>
    //   11   19:return          
    }

    public boolean m_xChange;
    public boolean m_yChange;
    public int m_indexVal;
}

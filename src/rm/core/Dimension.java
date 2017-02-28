// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) annotate 
// Source File Name:   Dimension.java

package rm.core;


// Referenced classes of package rm.core:
//            Attribute, Instances

public class Dimension
{

    public Dimension()
    {
    //    0    0:aload_0         
    //    1    1:invokespecial   #18  <Method void Object()>
        DimensionAttribute = new Attribute("");
    //    2    4:aload_0         
    //    3    5:new             #20  <Class Attribute>
    //    4    8:dup             
    //    5    9:ldc1            #22  <String "">
    //    6   11:invokespecial   #25  <Method void Attribute(String)>
    //    7   14:putfield        #27  <Field Attribute DimensionAttribute>
        DimensionInstances = null;
    //    8   17:aload_0         
    //    9   18:aconst_null     
    //   10   19:putfield        #29  <Field Instances DimensionInstances>
    //   11   22:return          
    }

    public Attribute getDimensionAttribute()
    {
        return DimensionAttribute;
    //    0    0:aload_0         
    //    1    1:getfield        #27  <Field Attribute DimensionAttribute>
    //    2    4:areturn         
    }

    public void setDimensionAttribute(Attribute dimensionAttribute)
    {
        DimensionAttribute = dimensionAttribute;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #27  <Field Attribute DimensionAttribute>
    //    3    5:return          
    }

    public Instances getDimensionInstances()
    {
        return DimensionInstances;
    //    0    0:aload_0         
    //    1    1:getfield        #29  <Field Instances DimensionInstances>
    //    2    4:areturn         
    }

    public void setDimensionInstances(Instances dimensionInstances)
    {
        DimensionInstances = dimensionInstances;
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:putfield        #29  <Field Instances DimensionInstances>
    //    3    5:return          
    }

    public String getName()
    {
        return DimensionAttribute.name();
    //    0    0:aload_0         
    //    1    1:getfield        #27  <Field Attribute DimensionAttribute>
    //    2    4:invokevirtual   #48  <Method String Attribute.name()>
    //    3    7:areturn         
    }

    public static final String ASS_DIMENSION = "@dimension";
    protected Attribute DimensionAttribute;
    protected Instances DimensionInstances;
}

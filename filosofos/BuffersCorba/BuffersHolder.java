package BuffersCorba;

/**
* BuffersCorba/BuffersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from buffers.idl
* Sábado, 20 de Abril de 2019 09h19min27s BRT
*/

public final class BuffersHolder implements org.omg.CORBA.portable.Streamable
{
  public BuffersCorba.Buffers value = null;

  public BuffersHolder ()
  {
  }

  public BuffersHolder (BuffersCorba.Buffers initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BuffersCorba.BuffersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BuffersCorba.BuffersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BuffersCorba.BuffersHelper.type ();
  }

}

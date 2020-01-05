package org.guyvernk.fedicircle.core.jsonld;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class JsonLDSerializer<T> extends StdSerializer<T> {
    private static final long serialVersionUID = -8855810085276319792L;

    protected JsonLDSerializer(){
        this(null);
    }
    protected JsonLDSerializer(Class<T> t){
        super(t);
    }

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("@context", o.getClass().getAnnotation(Context.class).value());

        serializeFields(o, jsonGenerator, serializerProvider);

        jsonGenerator.writeEndObject();
    }

    private void serializeFields(Object bean, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        JavaType javaType = provider.constructType(bean.getClass());
        BeanDescription beanDesc = provider.getConfig().introspect(javaType);
        JsonSerializer<Object> serializer = BeanSerializerFactory.instance.findBeanSerializer(provider,
                javaType,
                beanDesc);
        serializer.unwrappingSerializer(null).serialize(bean, gen, provider);
    }

}

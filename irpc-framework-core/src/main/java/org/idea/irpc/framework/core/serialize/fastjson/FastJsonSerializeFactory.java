package org.idea.irpc.framework.core.serialize.fastjson;

import com.alibaba.fastjson.JSON;
import org.idea.irpc.framework.core.serialize.SerializeFactory;

public class FastJsonSerializeFactory implements SerializeFactory {

    @Override
    public <T> byte[] serialize(T t) {
        String jsonStr = JSON.toJSONString(t);
        return jsonStr.getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data),clazz);
    }

}

package org.idea.irpc.framework.core.common.utils.HashImpl;

import org.idea.irpc.framework.core.common.utils.HashStrategy;

public class JDKHashStrategy implements HashStrategy {
    @Override
    public int getHashCode(String key) {
        return key.hashCode();
    }
}

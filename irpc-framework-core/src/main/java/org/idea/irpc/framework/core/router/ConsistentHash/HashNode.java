package org.idea.irpc.framework.core.router.ConsistentHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HashNode {
    String host;
    Integer port;

    public String getIpAndPort() {
        return host + ":" + port;
    }
}

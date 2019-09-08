package com.txku.springstartkit.utility;

import org.apache.commons.codec.digest.DigestUtils;

public class ShaUtil {
    public static String sha(String originalString) {
        return DigestUtils.sha256Hex(originalString);
    }
}

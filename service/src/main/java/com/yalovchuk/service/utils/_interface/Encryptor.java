package com.yalovchuk.service.utils._interface;

import org.springframework.stereotype.Service;

public interface Encryptor {

    String encrypt(String value);

    String decrypt(String encrypted);
}

package com.wxhao.boot.base.component;


import com.wxhao.boot.base.exception.DecryptException;
import com.wxhao.boot.base.exception.EncryptException;
import com.wxhao.boot.base.properties.PrivacyMaskProperties;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;



/**
 * Created by wxhao on 2017/10/31.
 */
public class PrivacyMasks {

    private final PrivacyMaskProperties properties;
    private final Key key;

    public PrivacyMasks(PrivacyMaskProperties properties) {
        this.properties = properties;
        this.key = new SecretKeySpec(Base64.decodeBase64(properties.getAesKey()), "AES");
    }

    public String encryptPrivacy(String unencrypted) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(unencrypted.getBytes());
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
            throw new EncryptException("AES加密异常", e);
        }
    }

    public String decryptPrivacy(String encrypted) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(result);
        } catch (Exception e) {
            throw new DecryptException("AES解密异常", e);
        }
    }

    public String maskIdCard(String idCard) {
        return idCard.substring(0, 3) + "***********" + idCard.substring(idCard.length() - 4, idCard.length());
    }

    public String maskMobile(String mobile) {
        return mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4, mobile.length());
    }

    public String maskBankCard(String bankCard) {
        return bankCard.substring(0, 4) + "***********" + bankCard.substring(bankCard.length() - 4, bankCard.length());
    }

    public String maskIdCardSixTwo(String idCard) {
        return idCard.substring(0, 6) + "**********" + idCard.substring(idCard.length() - 2, idCard.length());
    }

    public String maskInstitutionalReditCode(String institutionalReditCode) {
        return institutionalReditCode.substring(0, 4) + "**********" + institutionalReditCode.substring(institutionalReditCode.length() - 4, institutionalReditCode.length());
    }

}

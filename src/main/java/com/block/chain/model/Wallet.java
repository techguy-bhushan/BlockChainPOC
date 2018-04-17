package com.block.chain.model;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

import static com.block.chain.utility.ConstantUtil.*;

public class Wallet {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Wallet(){
        generateKeyPair();
    }

    private void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ECDSA, BC);
            SecureRandom random = SecureRandom.getInstance(SHA1_PRNG);
            ECGenParameterSpec ecSpec = new ECGenParameterSpec(STD_NAME);
            // Initialize the key generator and generate a KeyPair
            keyGen.initialize(ecSpec, random);   //256 bytes provides an acceptable security level
            KeyPair keyPair = keyGen.generateKeyPair();
            // Set the public and private keys from the keyPair
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}

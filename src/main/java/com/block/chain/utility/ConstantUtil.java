package com.block.chain.utility;

import java.util.regex.Pattern;

public class ConstantUtil {
    public static final String ECDSA = "ECDSA";
    public static final String BC = "BC";
    public static final String SHA1_PRNG = "SHA1PRNG";
    public static final String STD_NAME = "prime192v1";
    public static final int DIFFICULTY = 4;
    public static final Pattern DIFFICULTY_TARGET_PREFIX_PATTERN = Pattern.compile(String.format("^[0]{%d}",DIFFICULTY));
}

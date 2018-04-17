package com.block.chain.model;

import com.block.chain.utility.HashUtil;

import java.util.Date;

import static com.block.chain.utility.ConstantUtil.*;

public class Block {
    private String hash;
    private final String previousHash;
    private final Date date;
    private String data;
    private int nonce;

    public Block(String data, String previousHash) {
        if (data == null) {
            throw new RuntimeException("Data can't be null");
        }
        this.data = data;
        this.previousHash = previousHash;
        this.date = new Date();
        hash = calculateHash();
    }


    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public String getData() {
        return data;
    }

    private String calculateHash() {
        return HashUtil.getHashWithSha512(new StringBuilder(previousHash != null ? previousHash : "").append(nonce).append(data).append(hash).append(date.toString()).toString());
    }

    public void mineBlock() {
        while (!DIFFICULTY_TARGET_PREFIX_PATTERN.matcher(hash).find()) {
            nonce++;
            hash = calculateHash();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Block)) return false;

        Block block = (Block) o;

        if (!hash.equals(block.hash)) return false;
        if (previousHash != null ? !previousHash.equals(block.previousHash) : block.previousHash != null) return false;
        if (!date.equals(block.date)) return false;
        return data.equals(block.data);
    }

    @Override
    public int hashCode() {
        int result = hash.hashCode();
        result = 31 * result + (previousHash != null ? previousHash.hashCode() : 0);
        result = 31 * result + date.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", date=" + date +
                ", data='" + data + '\'' +
                '}';
    }
}

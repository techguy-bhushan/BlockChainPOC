package com.block.chain;

import com.block.chain.model.Block;
import com.block.chain.utility.ChainUtil;

import java.util.ArrayList;

public class TestChain {
    public static void main(String[] args) {
        Block block1  = new Block("Block 1",null);
        block1.mineBlock();
        System.out.println(block1);

        Block block2  = new Block("Block 2",block1.getHash());
        block2.mineBlock();
        System.out.println(block2);

        Block block3  = new Block("Block 5",block2.getHash());
        block3.mineBlock();
        System.out.println(block3);


        ArrayList<Block> linkedList = new ArrayList<Block>();
        linkedList.add(block1);
        linkedList.add(block2);
        linkedList.add(block3);

        System.out.println("Is block is valid: " + ChainUtil.isBlockChainValid(linkedList));

        // Corrupt blocks

        Block block4  = new Block("Block 2",block2.getHash());

        linkedList.add(2, block4);

        System.out.println("Is block is invalid: "+ChainUtil.isBlockChainValid(linkedList));

    }
}

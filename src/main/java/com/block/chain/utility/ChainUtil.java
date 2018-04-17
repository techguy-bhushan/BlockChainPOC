package com.block.chain.utility;

import com.block.chain.model.Block;

import java.util.List;

import static com.block.chain.utility.ConstantUtil.DIFFICULTY_TARGET_PREFIX_PATTERN;

public class ChainUtil {

    /*
    * @block list of block
    * return true if list is valid else false
    * */
    public static Boolean isBlockChainValid(List<Block> blocks) {
        Block previousBlock = null;
        boolean isFirstBlock = true;

        for (Block currentBlock : blocks) {
            if (currentBlock == null) {
                return false;
            }
            if (isFirstBlock) {
                previousBlock = currentBlock;
                isFirstBlock = false;
                continue;
            }
            if (previousBlock.getHash().equals(currentBlock.getPreviousHash()) && DIFFICULTY_TARGET_PREFIX_PATTERN.matcher(currentBlock.getPreviousHash()).find() && DIFFICULTY_TARGET_PREFIX_PATTERN.matcher(currentBlock.getHash()).find()) {
                previousBlock = currentBlock;
            } else {
                return false;
            }

        }
        return true;
    }
}

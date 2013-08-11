package com.antonzherdev.objd.formatter;

import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ObjDBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;
    private final Indent indent;

    protected ObjDBlock(@NotNull ASTNode node, Indent indent, @Nullable Wrap wrap, @Nullable Alignment alignment,
                        SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.indent = indent;
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<Block>();
        IElementType parentType = myNode.getElementType();
        for (ASTNode child = myNode.getFirstChildNode(); child != null; child = child.getTreeNext()) {
            IElementType childType = child.getElementType();
            if(childType == TokenType.WHITE_SPACE || child.getChars().length() == 0) continue;
            Indent indent  = Indent.getNoneIndent();
            Wrap wrap = null;
            if (parentType == ObjDTypes.CLASS_BODY && childType == ObjDTypes.DEF_STATEMENT) {
                wrap = Wrap.createWrap(WrapType.ALWAYS, true);
                indent = Indent.getNormalIndent();
            } else if (parentType == ObjDTypes.EXPR_BRACES && childType != ObjDTypes.OPEN_BRACE &&  childType != ObjDTypes.CLOSE_BRACE) {
                indent = Indent.getNormalIndent();
            }
            blocks.add(new ObjDBlock(child, indent, wrap, null, spacingBuilder));
        }
        return Collections.unmodifiableList(blocks);
    }

    @Override
    public Indent getIndent() {
        return indent;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    @Nullable
    @Override
    protected Indent getChildIndent() {
        IElementType tp = getNode().getElementType();
        if(tp == ObjDTypes.CLASS_BODY || tp == ObjDTypes.EXPR_BRACES) return Indent.getNormalIndent();
        return Indent.getNoneIndent();
    }
}

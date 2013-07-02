// This is a generated file. Not intended for manual editing.
package com.antonzherdev.objd.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.antonzherdev.objd.psi.ObjDTypes.*;
import static com.antonzherdev.objd.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ObjDParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("com.antonzherdev.objd.parser.ObjDParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    if (root_ == CLS) {
      result_ = cls(builder_, level_ + 1);
    }
    else if (root_ == IMP) {
      result_ = imp(builder_, level_ + 1);
    }
    else {
      Marker marker_ = builder_.mark();
      enterErrorRecordingSection(builder_, level_, _SECTION_RECOVER_, null);
      result_ = parse_root_(root_, builder_, level_);
      exitErrorRecordingSection(builder_, level_, result_, true, _SECTION_RECOVER_, TOKEN_ADVANCER);
      marker_.done(root_);
    }
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // W_CLASS IDENT
  public static boolean cls(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cls")) return false;
    if (!nextTokenIs(builder_, W_CLASS)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, W_CLASS, IDENT);
    if (result_) {
      marker_.done(CLS);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // statement_*
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!statement_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "file");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // W_IMPORT IDENT
  public static boolean imp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "imp")) return false;
    if (!nextTokenIs(builder_, W_IMPORT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, W_IMPORT, IDENT);
    if (result_) {
      marker_.done(IMP);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // cls|imp|COMMENT|CRLF
  static boolean statement_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = cls(builder_, level_ + 1);
    if (!result_) result_ = imp(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

}

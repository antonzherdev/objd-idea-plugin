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
    if (root_ == ANNOTATIONS) {
      result_ = annotations_(builder_, level_ + 1);
    }
    else if (root_ == CALL_NAME) {
      result_ = call_name(builder_, level_ + 1);
    }
    else if (root_ == CASE_COND) {
      result_ = case_cond(builder_, level_ + 1);
    }
    else if (root_ == CASE_COND_CONST) {
      result_ = case_cond_const(builder_, level_ + 1);
    }
    else if (root_ == CASE_COND_TP) {
      result_ = case_cond_tp(builder_, level_ + 1);
    }
    else if (root_ == CASE_COND_UNAPPLY) {
      result_ = case_cond_unapply(builder_, level_ + 1);
    }
    else if (root_ == CASE_COND_VAL) {
      result_ = case_cond_val(builder_, level_ + 1);
    }
    else if (root_ == CASE_ITEM) {
      result_ = case_item(builder_, level_ + 1);
    }
    else if (root_ == CLASS_BODY) {
      result_ = class_body(builder_, level_ + 1);
    }
    else if (root_ == CLASS_CONSTRUCTOR_FIELD) {
      result_ = class_constructor_field(builder_, level_ + 1);
    }
    else if (root_ == CLASS_EXTENDS) {
      result_ = class_extends(builder_, level_ + 1);
    }
    else if (root_ == CLASS_GENERIC) {
      result_ = class_generic(builder_, level_ + 1);
    }
    else if (root_ == CLASS_GENERICS) {
      result_ = class_generics(builder_, level_ + 1);
    }
    else if (root_ == CLASS_MODS) {
      result_ = class_mods(builder_, level_ + 1);
    }
    else if (root_ == CLASS_NAME) {
      result_ = class_name(builder_, level_ + 1);
    }
    else if (root_ == CLASS_STATEMENT) {
      result_ = class_statement(builder_, level_ + 1);
    }
    else if (root_ == CLASS_TYPE) {
      result_ = class_type(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE) {
      result_ = data_type(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_COLLECTION) {
      result_ = data_type_collection(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_GENERICS) {
      result_ = data_type_generics(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_LAMBDA) {
      result_ = data_type_lambda(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_OPTION) {
      result_ = data_type_option(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_REF) {
      result_ = data_type_ref(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_SELF) {
      result_ = data_type_self(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_SIMPLE) {
      result_ = data_type_simple(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_TUPLE) {
      result_ = data_type_tuple(builder_, level_ + 1);
    }
    else if (root_ == DEF_NAME) {
      result_ = def_name(builder_, level_ + 1);
    }
    else if (root_ == DEF_PARAMETER) {
      result_ = def_parameter(builder_, level_ + 1);
    }
    else if (root_ == DEF_STATEMENT) {
      result_ = def_statement(builder_, level_ + 1);
    }
    else if (root_ == DOT_LEFT) {
      result_ = dot_left(builder_, level_ + 1);
    }
    else if (root_ == DOT_PART) {
      result_ = dot_part(builder_, level_ + 1);
    }
    else if (root_ == DOT_PART_SIMPLE) {
      result_ = dot_part_simple(builder_, level_ + 1);
    }
    else if (root_ == DOT_RIGHT) {
      result_ = dot_right(builder_, level_ + 1);
    }
    else if (root_ == DOT_TYPE) {
      result_ = dot_type(builder_, level_ + 1);
    }
    else if (root_ == ENUM_ITEM) {
      result_ = enum_item(builder_, level_ + 1);
    }
    else if (root_ == EXPR) {
      result_ = expr_(builder_, level_ + 1);
    }
    else if (root_ == EXPR_ARR) {
      result_ = expr_arr(builder_, level_ + 1);
    }
    else if (root_ == EXPR_BIND) {
      result_ = expr_bind(builder_, level_ + 1);
    }
    else if (root_ == EXPR_BOOL) {
      result_ = expr_bool(builder_, level_ + 1);
    }
    else if (root_ == EXPR_BRACES) {
      result_ = expr_braces(builder_, level_ + 1);
    }
    else if (root_ == EXPR_BRACKETS) {
      result_ = expr_brackets(builder_, level_ + 1);
    }
    else if (root_ == EXPR_CALL) {
      result_ = expr_call(builder_, level_ + 1);
    }
    else if (root_ == EXPR_CALL_PARAM) {
      result_ = expr_call_param(builder_, level_ + 1);
    }
    else if (root_ == EXPR_CALL_PARAMS) {
      result_ = expr_call_params(builder_, level_ + 1);
    }
    else if (root_ == EXPR_CALL_POST_LAMBDA) {
      result_ = expr_call_post_lambda(builder_, level_ + 1);
    }
    else if (root_ == EXPR_CASE) {
      result_ = expr_case(builder_, level_ + 1);
    }
    else if (root_ == EXPR_CLUE) {
      result_ = expr_clue(builder_, level_ + 1);
    }
    else if (root_ == EXPR_COMP) {
      result_ = expr_comp(builder_, level_ + 1);
    }
    else if (root_ == EXPR_DO) {
      result_ = expr_do(builder_, level_ + 1);
    }
    else if (root_ == EXPR_DOT) {
      result_ = expr_dot(builder_, level_ + 1);
    }
    else if (root_ == EXPR_IF) {
      result_ = expr_if(builder_, level_ + 1);
    }
    else if (root_ == EXPR_INDEX) {
      result_ = expr_index(builder_, level_ + 1);
    }
    else if (root_ == EXPR_LAMBDA) {
      result_ = expr_lambda(builder_, level_ + 1);
    }
    else if (root_ == EXPR_MD) {
      result_ = expr_md(builder_, level_ + 1);
    }
    else if (root_ == EXPR_MINUS) {
      result_ = expr_minus(builder_, level_ + 1);
    }
    else if (root_ == EXPR_NOT) {
      result_ = expr_not(builder_, level_ + 1);
    }
    else if (root_ == EXPR_PM) {
      result_ = expr_pm(builder_, level_ + 1);
    }
    else if (root_ == EXPR_RETURN) {
      result_ = expr_return(builder_, level_ + 1);
    }
    else if (root_ == EXPR_SELF) {
      result_ = expr_self(builder_, level_ + 1);
    }
    else if (root_ == EXPR_SET) {
      result_ = expr_set(builder_, level_ + 1);
    }
    else if (root_ == EXPR_STRING_CONST) {
      result_ = expr_string_const(builder_, level_ + 1);
    }
    else if (root_ == EXPR_SUPER) {
      result_ = expr_super(builder_, level_ + 1);
    }
    else if (root_ == EXPR_SYNC) {
      result_ = expr_sync(builder_, level_ + 1);
    }
    else if (root_ == EXPR_THROW) {
      result_ = expr_throw(builder_, level_ + 1);
    }
    else if (root_ == EXPR_TRY) {
      result_ = expr_try(builder_, level_ + 1);
    }
    else if (root_ == EXPR_VAL) {
      result_ = expr_val(builder_, level_ + 1);
    }
    else if (root_ == EXPR_WEAK) {
      result_ = expr_weak(builder_, level_ + 1);
    }
    else if (root_ == EXPR_WHILE) {
      result_ = expr_while(builder_, level_ + 1);
    }
    else if (root_ == FIELD_STATEMENT) {
      result_ = field_statement(builder_, level_ + 1);
    }
    else if (root_ == FINAL_MOD) {
      result_ = final_mod(builder_, level_ + 1);
    }
    else if (root_ == IMPORT_PART) {
      result_ = import_part(builder_, level_ + 1);
    }
    else if (root_ == IMPORT_STATEMENT) {
      result_ = import_statement(builder_, level_ + 1);
    }
    else if (root_ == INDEX_OP) {
      result_ = index_op(builder_, level_ + 1);
    }
    else if (root_ == INLINE_MOD) {
      result_ = inline_mod(builder_, level_ + 1);
    }
    else if (root_ == LAMBDA_PAR) {
      result_ = lambda_par(builder_, level_ + 1);
    }
    else if (root_ == LAZY_MOD) {
      result_ = lazy_mod(builder_, level_ + 1);
    }
    else if (root_ == MAP_TP) {
      result_ = map_tp(builder_, level_ + 1);
    }
    else if (root_ == MOD) {
      result_ = mod(builder_, level_ + 1);
    }
    else if (root_ == MODS) {
      result_ = mods(builder_, level_ + 1);
    }
    else if (root_ == OVERRIDE_MOD) {
      result_ = override_mod(builder_, level_ + 1);
    }
    else if (root_ == PACK_PART) {
      result_ = pack_part(builder_, level_ + 1);
    }
    else if (root_ == PACK_STATEMENT) {
      result_ = pack_statement(builder_, level_ + 1);
    }
    else if (root_ == PAR_MODS) {
      result_ = par_mods(builder_, level_ + 1);
    }
    else if (root_ == PRIVATE_MOD) {
      result_ = private_mod(builder_, level_ + 1);
    }
    else if (root_ == PROTECTED_MOD) {
      result_ = protected_mod(builder_, level_ + 1);
    }
    else if (root_ == PURE_MOD) {
      result_ = pure_mod(builder_, level_ + 1);
    }
    else if (root_ == STATIC_MOD) {
      result_ = static_mod(builder_, level_ + 1);
    }
    else if (root_ == STRING_TOKEN) {
      result_ = string_token(builder_, level_ + 1);
    }
    else if (root_ == TERM) {
      result_ = term_(builder_, level_ + 1);
    }
    else if (root_ == TYPE_STATEMENT) {
      result_ = type_statement(builder_, level_ + 1);
    }
    else if (root_ == WEAK_MOD) {
      result_ = weak_mod(builder_, level_ + 1);
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

  private static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    TokenSet.create(CASE_COND, CASE_COND_CONST, CASE_COND_TP, CASE_COND_UNAPPLY,
      CASE_COND_VAL),
    TokenSet.create(DATA_TYPE, DATA_TYPE_COLLECTION, DATA_TYPE_LAMBDA, DATA_TYPE_OPTION,
      DATA_TYPE_SIMPLE, DATA_TYPE_TUPLE),
    TokenSet.create(DOT_PART, DOT_PART_SIMPLE),
    TokenSet.create(DOT_LEFT, DOT_RIGHT, EXPR, EXPR_ARR,
      EXPR_BIND, EXPR_BOOL, EXPR_BRACES, EXPR_BRACKETS,
      EXPR_CALL, EXPR_CLUE, EXPR_COMP, EXPR_DO,
      EXPR_DOT, EXPR_IF, EXPR_INDEX, EXPR_LAMBDA,
      EXPR_MD, EXPR_MINUS, EXPR_NOT, EXPR_PM,
      EXPR_SELF, EXPR_SET, EXPR_STRING_CONST, EXPR_SUPER,
      EXPR_SYNC, EXPR_THROW, EXPR_TRY, EXPR_VAL,
      EXPR_WHILE, TERM),
    TokenSet.create(FINAL_MOD, INLINE_MOD, LAZY_MOD, MOD,
      OVERRIDE_MOD, PRIVATE_MOD, PROTECTED_MOD, PURE_MOD,
      STATIC_MOD, WEAK_MOD),
  };

  public static boolean type_extends_(IElementType child_, IElementType parent_) {
    for (TokenSet set : EXTENDS_SETS_) {
      if (set.contains(child_) && set.contains(parent_)) return true;
    }
    return false;
  }

  /* ********************************************************** */
  // AT expr_call
  static boolean annotation_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_")) return false;
    if (!nextTokenIs(builder_, AT)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, AT);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_call(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // annotation_*
  public static boolean annotations_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotations_")) return false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<annotations>");
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!annotation_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "annotations_");
        break;
      }
      offset_ = next_offset_;
    }
    marker_.done(ANNOTATIONS);
    exitErrorRecordingSection(builder_, level_, true, false, _SECTION_GENERAL_, null);
    return true;
  }

  /* ********************************************************** */
  // IDENT | W_CLASS | W_TYPE
  public static boolean call_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "call_name")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<call name>");
    result_ = consumeToken(builder_, IDENT);
    if (!result_) result_ = consumeToken(builder_, W_CLASS);
    if (!result_) result_ = consumeToken(builder_, W_TYPE);
    if (result_) {
      marker_.done(CALL_NAME);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // case_cond_unapply | case_cond_val | expr_string_const | case_cond_const
  public static boolean case_cond(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<case cond>");
    result_ = case_cond_unapply(builder_, level_ + 1);
    if (!result_) result_ = case_cond_val(builder_, level_ + 1);
    if (!result_) result_ = expr_string_const(builder_, level_ + 1);
    if (!result_) result_ = case_cond_const(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), CASE_COND)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(CASE_COND);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // INT | FLOAT | W_NIL | W_TRUE | W_FALSE
  public static boolean case_cond_const(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_const")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<case cond const>");
    result_ = consumeToken(builder_, INT);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, W_NIL);
    if (!result_) result_ = consumeToken(builder_, W_TRUE);
    if (!result_) result_ = consumeToken(builder_, W_FALSE);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), CASE_COND_CONST)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(CASE_COND_CONST);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // COLON (data_type_option | data_type_collection | data_type_tuple | data_type_simple | data_type_self)
  public static boolean case_cond_tp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_tp")) return false;
    if (!nextTokenIs(builder_, COLON)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && case_cond_tp_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(CASE_COND_TP);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // data_type_option | data_type_collection | data_type_tuple | data_type_simple | data_type_self
  private static boolean case_cond_tp_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_tp_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_option(builder_, level_ + 1);
    if (!result_) result_ = data_type_collection(builder_, level_ + 1);
    if (!result_) result_ = data_type_tuple(builder_, level_ + 1);
    if (!result_) result_ = data_type_simple(builder_, level_ + 1);
    if (!result_) result_ = data_type_self(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // data_type_ref? (OPEN_BRACKET case_cond (COMMA case_cond)* CLOSE_BRACKET) case_cond_tp?
  public static boolean case_cond_unapply(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_unapply")) return false;
    if (!nextTokenIs(builder_, IDENT) && !nextTokenIs(builder_, OPEN_BRACKET)
        && replaceVariants(builder_, 2, "<case cond unapply>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<case cond unapply>");
    result_ = case_cond_unapply_0(builder_, level_ + 1);
    result_ = result_ && case_cond_unapply_1(builder_, level_ + 1);
    result_ = result_ && case_cond_unapply_2(builder_, level_ + 1);
    if (result_) {
      marker_.done(CASE_COND_UNAPPLY);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // data_type_ref?
  private static boolean case_cond_unapply_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_unapply_0")) return false;
    data_type_ref(builder_, level_ + 1);
    return true;
  }

  // OPEN_BRACKET case_cond (COMMA case_cond)* CLOSE_BRACKET
  private static boolean case_cond_unapply_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_unapply_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
    result_ = result_ && case_cond(builder_, level_ + 1);
    result_ = result_ && case_cond_unapply_1_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (COMMA case_cond)*
  private static boolean case_cond_unapply_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_unapply_1_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!case_cond_unapply_1_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "case_cond_unapply_1_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA case_cond
  private static boolean case_cond_unapply_1_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_unapply_1_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && case_cond(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // case_cond_tp?
  private static boolean case_cond_unapply_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_unapply_2")) return false;
    case_cond_tp(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // def_name case_cond_tp?
  public static boolean case_cond_val(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_val")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<case cond val>");
    result_ = def_name(builder_, level_ + 1);
    result_ = result_ && case_cond_val_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(CASE_COND_VAL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // case_cond_tp?
  private static boolean case_cond_val_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_cond_val_1")) return false;
    case_cond_tp(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // case_cond ARROW expr_
  public static boolean case_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "case_item")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<case item>");
    result_ = case_cond(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    pinned_ = result_; // pin = 2
    result_ = result_ && expr_(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(CASE_ITEM);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // OPEN_BRACE enum_item* (def_statement | field_statement | import_statement)* CLOSE_BRACE
  public static boolean class_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_body")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, class_body_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, class_body_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACE) && result_;
    if (result_ || pinned_) {
      marker_.done(CLASS_BODY);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // enum_item*
  private static boolean class_body_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_body_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!enum_item(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "class_body_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (def_statement | field_statement | import_statement)*
  private static boolean class_body_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_body_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!class_body_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "class_body_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // def_statement | field_statement | import_statement
  private static boolean class_body_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_body_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = def_statement(builder_, level_ + 1);
    if (!result_) result_ = field_statement(builder_, level_ + 1);
    if (!result_) result_ = import_statement(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // mods (W_VAR | W_VAL)? def_name COLON data_type (SET expr_)?
  public static boolean class_constructor_field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<class constructor field>");
    result_ = mods(builder_, level_ + 1);
    result_ = result_ && class_constructor_field_1(builder_, level_ + 1);
    result_ = result_ && def_name(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && class_constructor_field_5(builder_, level_ + 1);
    if (result_) {
      marker_.done(CLASS_CONSTRUCTOR_FIELD);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // (W_VAR | W_VAL)?
  private static boolean class_constructor_field_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field_1")) return false;
    class_constructor_field_1_0(builder_, level_ + 1);
    return true;
  }

  // W_VAR | W_VAL
  private static boolean class_constructor_field_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_VAR);
    if (!result_) result_ = consumeToken(builder_, W_VAL);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (SET expr_)?
  private static boolean class_constructor_field_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field_5")) return false;
    class_constructor_field_5_0(builder_, level_ + 1);
    return true;
  }

  // SET expr_
  private static boolean class_constructor_field_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field_5_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, SET);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_BRACKET class_constructor_field (COMMA class_constructor_field)* CLOSE_BRACKET
  static boolean class_constructor_fields(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_fields")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, class_constructor_field(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, class_constructor_fields_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (COMMA class_constructor_field)*
  private static boolean class_constructor_fields_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_fields_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!class_constructor_fields_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "class_constructor_fields_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA class_constructor_field
  private static boolean class_constructor_fields_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_fields_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && class_constructor_field(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // data_type_ref data_type_generics?
  public static boolean class_extends(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_ref(builder_, level_ + 1);
    result_ = result_ && class_extends_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(CLASS_EXTENDS);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // data_type_generics?
  private static boolean class_extends_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends_1")) return false;
    data_type_generics(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // class_name (W_EXTENDS data_type)?
  public static boolean class_generic(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_generic")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = class_name(builder_, level_ + 1);
    result_ = result_ && class_generic_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(CLASS_GENERIC);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // (W_EXTENDS data_type)?
  private static boolean class_generic_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_generic_1")) return false;
    class_generic_1_0(builder_, level_ + 1);
    return true;
  }

  // W_EXTENDS data_type
  private static boolean class_generic_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_generic_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_EXTENDS);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // LESS class_generic (COMMA class_generic)* MORE
  public static boolean class_generics(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_generics")) return false;
    if (!nextTokenIs(builder_, LESS)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, LESS);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, class_generic(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, class_generics_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, MORE) && result_;
    if (result_ || pinned_) {
      marker_.done(CLASS_GENERICS);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (COMMA class_generic)*
  private static boolean class_generics_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_generics_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!class_generics_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "class_generics_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA class_generic
  private static boolean class_generics_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_generics_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && class_generic(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // (W_STUB | W_ABSTRACT | W_FINAL | W_CASE | W_PRIVATE | W_PACKAGE)*
  public static boolean class_mods(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_mods")) return false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<class mods>");
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!class_mods_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "class_mods");
        break;
      }
      offset_ = next_offset_;
    }
    marker_.done(CLASS_MODS);
    exitErrorRecordingSection(builder_, level_, true, false, _SECTION_GENERAL_, null);
    return true;
  }

  // W_STUB | W_ABSTRACT | W_FINAL | W_CASE | W_PRIVATE | W_PACKAGE
  private static boolean class_mods_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_mods_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_STUB);
    if (!result_) result_ = consumeToken(builder_, W_ABSTRACT);
    if (!result_) result_ = consumeToken(builder_, W_FINAL);
    if (!result_) result_ = consumeToken(builder_, W_CASE);
    if (!result_) result_ = consumeToken(builder_, W_PRIVATE);
    if (!result_) result_ = consumeToken(builder_, W_PACKAGE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean class_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_name")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    if (result_) {
      marker_.done(CLASS_NAME);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // class_type class_name? class_generics? class_constructor_fields? (W_EXTENDS class_extends expr_call_params? (W_WITH class_extends)* )? class_body?
  public static boolean class_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<class statement>");
    result_ = class_type(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, class_statement_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, class_statement_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, class_statement_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, class_statement_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && class_statement_5(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(CLASS_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // class_name?
  private static boolean class_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_1")) return false;
    class_name(builder_, level_ + 1);
    return true;
  }

  // class_generics?
  private static boolean class_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_2")) return false;
    class_generics(builder_, level_ + 1);
    return true;
  }

  // class_constructor_fields?
  private static boolean class_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_3")) return false;
    class_constructor_fields(builder_, level_ + 1);
    return true;
  }

  // (W_EXTENDS class_extends expr_call_params? (W_WITH class_extends)* )?
  private static boolean class_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_4")) return false;
    class_statement_4_0(builder_, level_ + 1);
    return true;
  }

  // W_EXTENDS class_extends expr_call_params? (W_WITH class_extends)*
  private static boolean class_statement_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_4_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_EXTENDS);
    result_ = result_ && class_extends(builder_, level_ + 1);
    result_ = result_ && class_statement_4_0_2(builder_, level_ + 1);
    result_ = result_ && class_statement_4_0_3(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_call_params?
  private static boolean class_statement_4_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_4_0_2")) return false;
    expr_call_params(builder_, level_ + 1);
    return true;
  }

  // (W_WITH class_extends)*
  private static boolean class_statement_4_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_4_0_3")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!class_statement_4_0_3_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "class_statement_4_0_3");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // W_WITH class_extends
  private static boolean class_statement_4_0_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_4_0_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_WITH);
    result_ = result_ && class_extends(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // class_body?
  private static boolean class_statement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_5")) return false;
    class_body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_CLASS | W_OBJECT | W_TRAIT | W_STRUCT | W_ENUM
  public static boolean class_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_type")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<class type>");
    result_ = consumeToken(builder_, W_CLASS);
    if (!result_) result_ = consumeToken(builder_, W_OBJECT);
    if (!result_) result_ = consumeToken(builder_, W_TRAIT);
    if (!result_) result_ = consumeToken(builder_, W_STRUCT);
    if (!result_) result_ = consumeToken(builder_, W_ENUM);
    if (result_) {
      marker_.done(CLASS_TYPE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // COMMA expr_call_param
  static boolean comma_and_par(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comma_and_par")) return false;
    if (!nextTokenIs(builder_, COMMA)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_call_param(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // COMMA expr_?
  static boolean comma_exp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comma_exp")) return false;
    if (!nextTokenIs(builder_, COMMA)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && comma_exp_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean comma_exp_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comma_exp_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET expr_ CLOSE_BRACKET
  static boolean cond_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cond_")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // data_type_lambda | data_type_option | data_type_collection | data_type_tuple | data_type_simple | data_type_self
  public static boolean data_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<data type>");
    result_ = data_type_lambda(builder_, level_ + 1);
    if (!result_) result_ = data_type_option(builder_, level_ + 1);
    if (!result_) result_ = data_type_collection(builder_, level_ + 1);
    if (!result_) result_ = data_type_tuple(builder_, level_ + 1);
    if (!result_) result_ = data_type_simple(builder_, level_ + 1);
    if (!result_) result_ = data_type_self(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), DATA_TYPE)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(DATA_TYPE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // OPEN_SQUARE_BRACKET data_type map_tp? CLOSE_SQUARE_BRACKET
  public static boolean data_type_collection(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_collection")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, data_type(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, data_type_collection_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_SQUARE_BRACKET) && result_;
    if (result_ || pinned_) {
      marker_.done(DATA_TYPE_COLLECTION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // map_tp?
  private static boolean data_type_collection_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_collection_2")) return false;
    map_tp(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // LESS data_type (COMMA data_type)* MORE
  public static boolean data_type_generics(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_generics")) return false;
    if (!nextTokenIs(builder_, LESS)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, LESS);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, data_type(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, data_type_generics_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, MORE) && result_;
    if (result_ || pinned_) {
      marker_.done(DATA_TYPE_GENERICS);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (COMMA data_type)*
  private static boolean data_type_generics_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_generics_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!data_type_generics_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "data_type_generics_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA data_type
  private static boolean data_type_generics_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_generics_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // (data_type_option | data_type_collection | data_type_tuple | data_type_simple | data_type_self) ARROW data_type
  public static boolean data_type_lambda(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_lambda")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<data type lambda>");
    result_ = data_type_lambda_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (result_) {
      marker_.done(DATA_TYPE_LAMBDA);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // data_type_option | data_type_collection | data_type_tuple | data_type_simple | data_type_self
  private static boolean data_type_lambda_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_lambda_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_option(builder_, level_ + 1);
    if (!result_) result_ = data_type_collection(builder_, level_ + 1);
    if (!result_) result_ = data_type_tuple(builder_, level_ + 1);
    if (!result_) result_ = data_type_simple(builder_, level_ + 1);
    if (!result_) result_ = data_type_self(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // (data_type_simple| data_type_collection | data_type_tuple | data_type_self) WHAT
  public static boolean data_type_option(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_option")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<data type option>");
    result_ = data_type_option_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, WHAT);
    pinned_ = result_; // pin = 2
    if (result_ || pinned_) {
      marker_.done(DATA_TYPE_OPTION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // data_type_simple| data_type_collection | data_type_tuple | data_type_self
  private static boolean data_type_option_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_option_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_simple(builder_, level_ + 1);
    if (!result_) result_ = data_type_collection(builder_, level_ + 1);
    if (!result_) result_ = data_type_tuple(builder_, level_ + 1);
    if (!result_) result_ = data_type_self(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_SQUARE_BRACKET INT? CLOSE_SQUARE_BRACKET
  static boolean data_type_post_arr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_post_arr")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, data_type_post_arr_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, CLOSE_SQUARE_BRACKET) && result_;
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // INT?
  private static boolean data_type_post_arr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_post_arr_1")) return false;
    consumeToken(builder_, INT);
    return true;
  }

  /* ********************************************************** */
  // IDENT !DOT
  public static boolean data_type_ref(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_ref")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    result_ = result_ && data_type_ref_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(DATA_TYPE_REF);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // !DOT
  private static boolean data_type_ref_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_ref_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_NOT_, null);
    result_ = !consumeToken(builder_, DOT);
    marker_.rollbackTo();
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_NOT_, null);
    return result_;
  }

  /* ********************************************************** */
  // W_SELF
  public static boolean data_type_self(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_self")) return false;
    if (!nextTokenIs(builder_, W_SELF)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_SELF);
    if (result_) {
      marker_.done(DATA_TYPE_SELF);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // (data_type_ref | TP_BOOL | TP_STRING | TP_ANY| TP_CHAR|
  //     TP_INT4 | TP_UINT4 | TP_INT8 | TP_UINT8 | TP_INT | TP_UINT | TP_FLOAT | TP_FLOAT8 | TP_FLOAT4 | TP_BYTE | TP_UBYTE | TP_VOID) data_type_generics? data_type_post_arr?
  public static boolean data_type_simple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<data type simple>");
    result_ = data_type_simple_0(builder_, level_ + 1);
    result_ = result_ && data_type_simple_1(builder_, level_ + 1);
    result_ = result_ && data_type_simple_2(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), DATA_TYPE_SIMPLE)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(DATA_TYPE_SIMPLE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // data_type_ref | TP_BOOL | TP_STRING | TP_ANY| TP_CHAR|
  //     TP_INT4 | TP_UINT4 | TP_INT8 | TP_UINT8 | TP_INT | TP_UINT | TP_FLOAT | TP_FLOAT8 | TP_FLOAT4 | TP_BYTE | TP_UBYTE | TP_VOID
  private static boolean data_type_simple_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_ref(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TP_BOOL);
    if (!result_) result_ = consumeToken(builder_, TP_STRING);
    if (!result_) result_ = consumeToken(builder_, TP_ANY);
    if (!result_) result_ = consumeToken(builder_, TP_CHAR);
    if (!result_) result_ = consumeToken(builder_, TP_INT4);
    if (!result_) result_ = consumeToken(builder_, TP_UINT4);
    if (!result_) result_ = consumeToken(builder_, TP_INT8);
    if (!result_) result_ = consumeToken(builder_, TP_UINT8);
    if (!result_) result_ = consumeToken(builder_, TP_INT);
    if (!result_) result_ = consumeToken(builder_, TP_UINT);
    if (!result_) result_ = consumeToken(builder_, TP_FLOAT);
    if (!result_) result_ = consumeToken(builder_, TP_FLOAT8);
    if (!result_) result_ = consumeToken(builder_, TP_FLOAT4);
    if (!result_) result_ = consumeToken(builder_, TP_BYTE);
    if (!result_) result_ = consumeToken(builder_, TP_UBYTE);
    if (!result_) result_ = consumeToken(builder_, TP_VOID);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // data_type_generics?
  private static boolean data_type_simple_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple_1")) return false;
    data_type_generics(builder_, level_ + 1);
    return true;
  }

  // data_type_post_arr?
  private static boolean data_type_simple_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple_2")) return false;
    data_type_post_arr(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET data_type? (COMMA data_type)* CLOSE_BRACKET
  public static boolean data_type_tuple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_tuple")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, data_type_tuple_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, data_type_tuple_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (result_ || pinned_) {
      marker_.done(DATA_TYPE_TUPLE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // data_type?
  private static boolean data_type_tuple_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_tuple_1")) return false;
    data_type(builder_, level_ + 1);
    return true;
  }

  // (COMMA data_type)*
  private static boolean data_type_tuple_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_tuple_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!data_type_tuple_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "data_type_tuple_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA data_type
  private static boolean data_type_tuple_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_tuple_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // IDENT | W_CLASS | W_TYPE
  public static boolean def_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_name")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<def name>");
    result_ = consumeToken(builder_, IDENT);
    if (!result_) result_ = consumeToken(builder_, W_CLASS);
    if (!result_) result_ = consumeToken(builder_, W_TYPE);
    if (result_) {
      marker_.done(DEF_NAME);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // par_mods (def_name | W_SELF)? COLON data_type (SET expr_)?
  public static boolean def_parameter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<def parameter>");
    result_ = par_mods(builder_, level_ + 1);
    result_ = result_ && def_parameter_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && def_parameter_4(builder_, level_ + 1);
    if (result_) {
      marker_.done(DEF_PARAMETER);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // (def_name | W_SELF)?
  private static boolean def_parameter_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_1")) return false;
    def_parameter_1_0(builder_, level_ + 1);
    return true;
  }

  // def_name | W_SELF
  private static boolean def_parameter_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = def_name(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, W_SELF);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (SET expr_)?
  private static boolean def_parameter_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_4")) return false;
    def_parameter_4_0(builder_, level_ + 1);
    return true;
  }

  // SET expr_
  private static boolean def_parameter_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_4_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, SET);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_BRACKET def_parameter? (COMMA def_parameter)* CLOSE_BRACKET
  static boolean def_parameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameters")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, def_parameters_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, def_parameters_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // def_parameter?
  private static boolean def_parameters_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameters_1")) return false;
    def_parameter(builder_, level_ + 1);
    return true;
  }

  // (COMMA def_parameter)*
  private static boolean def_parameters_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameters_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!def_parameters_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "def_parameters_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA def_parameter
  private static boolean def_parameters_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameters_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && def_parameter(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // mods W_DEF def_name class_generics? def_parameters? val_tp? (set_val| expr_braces)?
  public static boolean def_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<def statement>");
    result_ = mods(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, W_DEF);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, def_name(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, def_statement_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, def_statement_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, def_statement_5(builder_, level_ + 1)) && result_;
    result_ = pinned_ && def_statement_6(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(DEF_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // class_generics?
  private static boolean def_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_3")) return false;
    class_generics(builder_, level_ + 1);
    return true;
  }

  // def_parameters?
  private static boolean def_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_4")) return false;
    def_parameters(builder_, level_ + 1);
    return true;
  }

  // val_tp?
  private static boolean def_statement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_5")) return false;
    val_tp(builder_, level_ + 1);
    return true;
  }

  // (set_val| expr_braces)?
  private static boolean def_statement_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_6")) return false;
    def_statement_6_0(builder_, level_ + 1);
    return true;
  }

  // set_val| expr_braces
  private static boolean def_statement_6_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_6_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = set_val(builder_, level_ + 1);
    if (!result_) result_ = expr_braces(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expr_index
  public static boolean dot_left(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_left")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<dot left>");
    result_ = expr_index(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), DOT_LEFT)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(DOT_LEFT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // dot_part_simple
  public static boolean dot_part(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_part")) return false;
    if (!nextTokenIs(builder_, DOT) && !nextTokenIs(builder_, NULLDOT)
        && replaceVariants(builder_, 2, "<dot part>")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<dot part>");
    result_ = dot_part_simple(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), DOT_PART)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(DOT_PART);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // dot_type dot_right?
  public static boolean dot_part_simple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_part_simple")) return false;
    if (!nextTokenIs(builder_, DOT) && !nextTokenIs(builder_, NULLDOT)
        && replaceVariants(builder_, 2, "<dot part simple>")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<dot part simple>");
    result_ = dot_type(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && dot_part_simple_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(DOT_PART_SIMPLE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // dot_right?
  private static boolean dot_part_simple_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_part_simple_1")) return false;
    dot_right(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // expr_index
  public static boolean dot_right(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_right")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<dot right>");
    result_ = expr_index(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), DOT_RIGHT)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(DOT_RIGHT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // DOT | NULLDOT
  public static boolean dot_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_type")) return false;
    if (!nextTokenIs(builder_, DOT) && !nextTokenIs(builder_, NULLDOT)
        && replaceVariants(builder_, 2, "<dot type>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<dot type>");
    result_ = consumeToken(builder_, DOT);
    if (!result_) result_ = consumeToken(builder_, NULLDOT);
    if (result_) {
      marker_.done(DOT_TYPE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // def_name expr_call_params?
  public static boolean enum_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_item")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<enum item>");
    result_ = def_name(builder_, level_ + 1);
    result_ = result_ && enum_item_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(ENUM_ITEM);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_call_params?
  private static boolean enum_item_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_item_1")) return false;
    expr_call_params(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // expr_val | expr_clue
  public static boolean expr_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr>");
    result_ = expr_val(builder_, level_ + 1);
    if (!result_) result_ = expr_clue(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // OPEN_SQUARE_BRACKET expr_? (COMMA expr_)* CLOSE_SQUARE_BRACKET
  public static boolean expr_arr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_arr")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_arr_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_arr_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_SQUARE_BRACKET) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_ARR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_arr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_arr_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  // (COMMA expr_)*
  private static boolean expr_arr_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_arr_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_arr_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_arr_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA expr_
  private static boolean expr_arr_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_arr_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expr_set expr_bind_r?
  public static boolean expr_bind(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bind")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr bind>");
    result_ = expr_set(builder_, level_ + 1);
    result_ = result_ && expr_bind_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_BIND)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_BIND);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_bind_r?
  private static boolean expr_bind_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bind_1")) return false;
    expr_bind_r(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // MORE MORE expr_bind?
  static boolean expr_bind_r(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bind_r")) return false;
    if (!nextTokenIs(builder_, MORE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeTokens(builder_, 1, MORE, MORE);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_bind_r_2(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_bind?
  private static boolean expr_bind_r_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bind_r_2")) return false;
    expr_bind(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // expr_comp expr_bool_r?
  public static boolean expr_bool(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bool")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr bool>");
    result_ = expr_comp(builder_, level_ + 1);
    result_ = result_ && expr_bool_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_BOOL)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_BOOL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_bool_r?
  private static boolean expr_bool_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bool_1")) return false;
    expr_bool_r(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (AND | OR) expr_bool?
  static boolean expr_bool_r(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bool_r")) return false;
    if (!nextTokenIs(builder_, AND) && !nextTokenIs(builder_, OR)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = expr_bool_r_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_bool_r_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // AND | OR
  private static boolean expr_bool_r_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bool_r_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, OR);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_bool?
  private static boolean expr_bool_r_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_bool_r_1")) return false;
    expr_bool(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACE expr_* CLOSE_BRACE
  public static boolean expr_braces(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_braces")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_braces_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACE) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_BRACES);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_*
  private static boolean expr_braces_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_braces_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_braces_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET expr_? (comma_exp)* CLOSE_BRACKET
  public static boolean expr_brackets(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_brackets")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_brackets_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_brackets_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_BRACKETS);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_brackets_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_brackets_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  // (comma_exp)*
  private static boolean expr_brackets_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_brackets_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_brackets_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_brackets_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (comma_exp)
  private static boolean expr_brackets_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_brackets_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = comma_exp(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // call_name expr_call_generics? expr_call_params? expr_call_post_lambda?
  public static boolean expr_call(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr call>");
    result_ = call_name(builder_, level_ + 1);
    result_ = result_ && expr_call_1(builder_, level_ + 1);
    result_ = result_ && expr_call_2(builder_, level_ + 1);
    result_ = result_ && expr_call_3(builder_, level_ + 1);
    if (result_) {
      marker_.done(EXPR_CALL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_call_generics?
  private static boolean expr_call_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_1")) return false;
    expr_call_generics(builder_, level_ + 1);
    return true;
  }

  // expr_call_params?
  private static boolean expr_call_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_2")) return false;
    expr_call_params(builder_, level_ + 1);
    return true;
  }

  // expr_call_post_lambda?
  private static boolean expr_call_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_3")) return false;
    expr_call_post_lambda(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // LESS data_type (COMMA data_type)* MORE
  static boolean expr_call_generics(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_generics")) return false;
    if (!nextTokenIs(builder_, LESS)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, LESS);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && expr_call_generics_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MORE);
    pinned_ = result_; // pin = 4
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (COMMA data_type)*
  private static boolean expr_call_generics_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_generics_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_call_generics_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_call_generics_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA data_type
  private static boolean expr_call_generics_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_generics_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // (def_name SET)? expr_?
  public static boolean expr_call_param(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr call param>");
    result_ = expr_call_param_0(builder_, level_ + 1);
    result_ = result_ && expr_call_param_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(EXPR_CALL_PARAM);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // (def_name SET)?
  private static boolean expr_call_param_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param_0")) return false;
    expr_call_param_0_0(builder_, level_ + 1);
    return true;
  }

  // def_name SET
  private static boolean expr_call_param_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = def_name(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_?
  private static boolean expr_call_param_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET expr_call_param comma_and_par* CLOSE_BRACKET
  public static boolean expr_call_params(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_params")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_call_param(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_call_params_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_CALL_PARAMS);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // comma_and_par*
  private static boolean expr_call_params_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_params_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!comma_and_par(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_call_params_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACE (lambda_par (COMMA lambda_par)* ARROW)? expr_* CLOSE_BRACE
  public static boolean expr_call_post_lambda(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_post_lambda")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_call_post_lambda_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_call_post_lambda_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACE) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_CALL_POST_LAMBDA);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (lambda_par (COMMA lambda_par)* ARROW)?
  private static boolean expr_call_post_lambda_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_post_lambda_1")) return false;
    expr_call_post_lambda_1_0(builder_, level_ + 1);
    return true;
  }

  // lambda_par (COMMA lambda_par)* ARROW
  private static boolean expr_call_post_lambda_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_post_lambda_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = lambda_par(builder_, level_ + 1);
    result_ = result_ && expr_call_post_lambda_1_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (COMMA lambda_par)*
  private static boolean expr_call_post_lambda_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_post_lambda_1_0_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_call_post_lambda_1_0_1_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_call_post_lambda_1_0_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA lambda_par
  private static boolean expr_call_post_lambda_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_post_lambda_1_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && lambda_par(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_*
  private static boolean expr_call_post_lambda_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_post_lambda_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_call_post_lambda_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // W_CASE OPEN_BRACKET expr_ CLOSE_BRACKET ((OPEN_BRACE case_item+ CLOSE_BRACE) | case_item+)
  public static boolean expr_case(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_case")) return false;
    if (!nextTokenIs(builder_, W_CASE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeTokens(builder_, 1, W_CASE, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, CLOSE_BRACKET)) && result_;
    result_ = pinned_ && expr_case_4(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_CASE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (OPEN_BRACE case_item+ CLOSE_BRACE) | case_item+
  private static boolean expr_case_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_case_4")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_case_4_0(builder_, level_ + 1);
    if (!result_) result_ = expr_case_4_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // OPEN_BRACE case_item+ CLOSE_BRACE
  private static boolean expr_case_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_case_4_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACE);
    result_ = result_ && expr_case_4_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // case_item+
  private static boolean expr_case_4_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_case_4_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = case_item(builder_, level_ + 1);
    int offset_ = builder_.getCurrentOffset();
    while (result_) {
      if (!case_item(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_case_4_0_1");
        break;
      }
      offset_ = next_offset_;
    }
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // case_item+
  private static boolean expr_case_4_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_case_4_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = case_item(builder_, level_ + 1);
    int offset_ = builder_.getCurrentOffset();
    while (result_) {
      if (!case_item(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_case_4_1");
        break;
      }
      offset_ = next_offset_;
    }
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expr_bind expr_clue_r? post_op?
  public static boolean expr_clue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_clue")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr clue>");
    result_ = expr_bind(builder_, level_ + 1);
    result_ = result_ && expr_clue_1(builder_, level_ + 1);
    result_ = result_ && expr_clue_2(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_CLUE)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_CLUE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_clue_r?
  private static boolean expr_clue_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_clue_1")) return false;
    expr_clue_r(builder_, level_ + 1);
    return true;
  }

  // post_op?
  private static boolean expr_clue_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_clue_2")) return false;
    post_op(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (CLUE | CLONE) expr_clue?
  static boolean expr_clue_r(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_clue_r")) return false;
    if (!nextTokenIs(builder_, CLONE) && !nextTokenIs(builder_, CLUE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = expr_clue_r_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_clue_r_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // CLUE | CLONE
  private static boolean expr_clue_r_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_clue_r_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, CLUE);
    if (!result_) result_ = consumeToken(builder_, CLONE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_clue?
  private static boolean expr_clue_r_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_clue_r_1")) return false;
    expr_clue(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // expr_pm expr_comp_r?
  public static boolean expr_comp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_comp")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr comp>");
    result_ = expr_pm(builder_, level_ + 1);
    result_ = result_ && expr_comp_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_COMP)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_COMP);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_comp_r?
  private static boolean expr_comp_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_comp_1")) return false;
    expr_comp_r(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (EXACT_EQ| EXACT_NOT_EQ | EQ| MORE | LESS| MOREEQ| LESSEQ | NOT_EQ) expr_pm?
  static boolean expr_comp_r(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_comp_r")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = expr_comp_r_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_comp_r_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // EXACT_EQ| EXACT_NOT_EQ | EQ| MORE | LESS| MOREEQ| LESSEQ | NOT_EQ
  private static boolean expr_comp_r_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_comp_r_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, EXACT_EQ);
    if (!result_) result_ = consumeToken(builder_, EXACT_NOT_EQ);
    if (!result_) result_ = consumeToken(builder_, EQ);
    if (!result_) result_ = consumeToken(builder_, MORE);
    if (!result_) result_ = consumeToken(builder_, LESS);
    if (!result_) result_ = consumeToken(builder_, MOREEQ);
    if (!result_) result_ = consumeToken(builder_, LESSEQ);
    if (!result_) result_ = consumeToken(builder_, NOT_EQ);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_pm?
  private static boolean expr_comp_r_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_comp_r_1")) return false;
    expr_pm(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_DO expr_? W_WHILE? cond_?
  public static boolean expr_do(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_do")) return false;
    if (!nextTokenIs(builder_, W_DO)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_DO);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_do_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_do_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && expr_do_3(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_DO);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_do_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_do_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  // W_WHILE?
  private static boolean expr_do_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_do_2")) return false;
    consumeToken(builder_, W_WHILE);
    return true;
  }

  // cond_?
  private static boolean expr_do_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_do_3")) return false;
    cond_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // dot_left dot_part*
  public static boolean expr_dot(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_dot")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr dot>");
    result_ = dot_left(builder_, level_ + 1);
    result_ = result_ && expr_dot_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_DOT)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_DOT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // dot_part*
  private static boolean expr_dot_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_dot_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!dot_part(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_dot_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // W_IF cond_? expr_? (W_ELSE expr_)?
  public static boolean expr_if(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if")) return false;
    if (!nextTokenIs(builder_, W_IF)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_IF);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_if_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_if_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && expr_if_3(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_IF);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // cond_?
  private static boolean expr_if_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if_1")) return false;
    cond_(builder_, level_ + 1);
    return true;
  }

  // expr_?
  private static boolean expr_if_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if_2")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  // (W_ELSE expr_)?
  private static boolean expr_if_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if_3")) return false;
    expr_if_3_0(builder_, level_ + 1);
    return true;
  }

  // W_ELSE expr_
  private static boolean expr_if_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_ELSE);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // term_ index_op?
  public static boolean expr_index(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_index")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr index>");
    result_ = term_(builder_, level_ + 1);
    result_ = result_ && expr_index_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_INDEX)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_INDEX);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // index_op?
  private static boolean expr_index_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_index_1")) return false;
    index_op(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (lambda_par | lambda_pars) ARROW expr_
  public static boolean expr_lambda(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_lambda")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr lambda>");
    result_ = expr_lambda_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    pinned_ = result_; // pin = 2
    result_ = result_ && expr_(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(EXPR_LAMBDA);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // lambda_par | lambda_pars
  private static boolean expr_lambda_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_lambda_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = lambda_par(builder_, level_ + 1);
    if (!result_) result_ = lambda_pars(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expr_dot expr_md_r?
  public static boolean expr_md(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_md")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr md>");
    result_ = expr_dot(builder_, level_ + 1);
    result_ = result_ && expr_md_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_MD)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_MD);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_md_r?
  private static boolean expr_md_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_md_1")) return false;
    expr_md_r(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (MUL | DIV) expr_md?
  static boolean expr_md_r(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_md_r")) return false;
    if (!nextTokenIs(builder_, DIV) && !nextTokenIs(builder_, MUL)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = expr_md_r_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_md_r_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // MUL | DIV
  private static boolean expr_md_r_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_md_r_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, MUL);
    if (!result_) result_ = consumeToken(builder_, DIV);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_md?
  private static boolean expr_md_r_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_md_r_1")) return false;
    expr_md(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // MINUS expr_?
  public static boolean expr_minus(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_minus")) return false;
    if (!nextTokenIs(builder_, MINUS)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, MINUS);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_minus_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(EXPR_MINUS);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_minus_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_minus_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // EXCLAMATION expr_?
  public static boolean expr_not(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_not")) return false;
    if (!nextTokenIs(builder_, EXCLAMATION)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, EXCLAMATION);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_not_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(EXPR_NOT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_not_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_not_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // expr_md expr_pr_r?
  public static boolean expr_pm(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_pm")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr pm>");
    result_ = expr_md(builder_, level_ + 1);
    result_ = result_ && expr_pm_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_PM)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_PM);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_pr_r?
  private static boolean expr_pm_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_pm_1")) return false;
    expr_pr_r(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (PLUS | MINUS) expr_pm?
  static boolean expr_pr_r(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_pr_r")) return false;
    if (!nextTokenIs(builder_, MINUS) && !nextTokenIs(builder_, PLUS)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = expr_pr_r_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_pr_r_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // PLUS | MINUS
  private static boolean expr_pr_r_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_pr_r_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_pm?
  private static boolean expr_pr_r_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_pr_r_1")) return false;
    expr_pm(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_RETURN expr_?
  public static boolean expr_return(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_return")) return false;
    if (!nextTokenIs(builder_, W_RETURN)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_RETURN);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_return_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(EXPR_RETURN);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_return_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_return_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_SELF
  public static boolean expr_self(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_self")) return false;
    if (!nextTokenIs(builder_, W_SELF)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_SELF);
    pinned_ = result_; // pin = 1
    if (result_ || pinned_) {
      marker_.done(EXPR_SELF);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // expr_bool expr_set_right?
  public static boolean expr_set(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_set")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr set>");
    result_ = expr_bool(builder_, level_ + 1);
    result_ = result_ && expr_set_1(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_SET)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(EXPR_SET);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // expr_set_right?
  private static boolean expr_set_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_set_1")) return false;
    expr_set_right(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (SET | PLUS_SET| MINUS_SET | MUL_SET | DIV_SET) expr_bool?
  static boolean expr_set_right(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_set_right")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = expr_set_right_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_set_right_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // SET | PLUS_SET| MINUS_SET | MUL_SET | DIV_SET
  private static boolean expr_set_right_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_set_right_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, SET);
    if (!result_) result_ = consumeToken(builder_, PLUS_SET);
    if (!result_) result_ = consumeToken(builder_, MINUS_SET);
    if (!result_) result_ = consumeToken(builder_, MUL_SET);
    if (!result_) result_ = consumeToken(builder_, DIV_SET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_bool?
  private static boolean expr_set_right_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_set_right_1")) return false;
    expr_bool(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // string_token+
  public static boolean expr_string_const(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_string_const")) return false;
    if (!nextTokenIs(builder_, STRING) && !nextTokenIs(builder_, STRING_EXPR)
        && replaceVariants(builder_, 2, "<expr string const>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr string const>");
    result_ = string_token(builder_, level_ + 1);
    int offset_ = builder_.getCurrentOffset();
    while (result_) {
      if (!string_token(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_string_const");
        break;
      }
      offset_ = next_offset_;
    }
    if (result_) {
      marker_.done(EXPR_STRING_CONST);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // W_SUPER
  public static boolean expr_super(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_super")) return false;
    if (!nextTokenIs(builder_, W_SUPER)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_SUPER);
    pinned_ = result_; // pin = 1
    if (result_ || pinned_) {
      marker_.done(EXPR_SUPER);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // W_SYNC cond_? expr_?
  public static boolean expr_sync(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_sync")) return false;
    if (!nextTokenIs(builder_, W_SYNC)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_SYNC);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_sync_1(builder_, level_ + 1));
    result_ = pinned_ && expr_sync_2(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_SYNC);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // cond_?
  private static boolean expr_sync_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_sync_1")) return false;
    cond_(builder_, level_ + 1);
    return true;
  }

  // expr_?
  private static boolean expr_sync_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_sync_2")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_THROW expr_?
  public static boolean expr_throw(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_throw")) return false;
    if (!nextTokenIs(builder_, W_THROW)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_THROW);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_throw_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(EXPR_THROW);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_throw_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_throw_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_TRY expr_? W_FINALLY? expr_?
  public static boolean expr_try(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_try")) return false;
    if (!nextTokenIs(builder_, W_TRY)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_TRY);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_try_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_try_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && expr_try_3(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_TRY);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_try_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_try_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  // W_FINALLY?
  private static boolean expr_try_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_try_2")) return false;
    consumeToken(builder_, W_FINALLY);
    return true;
  }

  // expr_?
  private static boolean expr_try_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_try_3")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (W_WEAK)* (W_VAL | W_VAR) def_name val_tp? set_val?
  public static boolean expr_val(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr val>");
    result_ = expr_val_0(builder_, level_ + 1);
    result_ = result_ && expr_val_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, def_name(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, expr_val_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && expr_val_4(builder_, level_ + 1) && result_;
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), EXPR_VAL)) {
      marker_.drop();
    }
    else if (result_ || pinned_) {
      marker_.done(EXPR_VAL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (W_WEAK)*
  private static boolean expr_val_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_0")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_val_0_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_val_0");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (W_WEAK)
  private static boolean expr_val_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_WEAK);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_VAL | W_VAR
  private static boolean expr_val_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_VAL);
    if (!result_) result_ = consumeToken(builder_, W_VAR);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // val_tp?
  private static boolean expr_val_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_3")) return false;
    val_tp(builder_, level_ + 1);
    return true;
  }

  // set_val?
  private static boolean expr_val_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_4")) return false;
    set_val(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_WEAK expr_?
  public static boolean expr_weak(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_weak")) return false;
    if (!nextTokenIs(builder_, W_WEAK)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_WEAK);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr_weak_1(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(EXPR_WEAK);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean expr_weak_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_weak_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_WHILE cond_? expr_?
  public static boolean expr_while(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_while")) return false;
    if (!nextTokenIs(builder_, W_WHILE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_WHILE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr_while_1(builder_, level_ + 1));
    result_ = pinned_ && expr_while_2(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(EXPR_WHILE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // cond_?
  private static boolean expr_while_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_while_1")) return false;
    cond_(builder_, level_ + 1);
    return true;
  }

  // expr_?
  private static boolean expr_while_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_while_2")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // mods (W_VAR | W_VAL) def_name val_tp? set_val?
  public static boolean field_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<field statement>");
    result_ = mods(builder_, level_ + 1);
    result_ = result_ && field_statement_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, def_name(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, field_statement_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && field_statement_4(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(FIELD_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // W_VAR | W_VAL
  private static boolean field_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_VAR);
    if (!result_) result_ = consumeToken(builder_, W_VAL);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // val_tp?
  private static boolean field_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_3")) return false;
    val_tp(builder_, level_ + 1);
    return true;
  }

  // set_val?
  private static boolean field_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_4")) return false;
    set_val(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // pack_statement statement_*
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    if (!nextTokenIs(builder_, W_PACKAGE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = pack_statement(builder_, level_ + 1);
    result_ = result_ && file_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // statement_*
  private static boolean file_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!statement_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "file_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // W_FINAL
  public static boolean final_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "final_mod")) return false;
    if (!nextTokenIs(builder_, W_FINAL)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_FINAL);
    if (result_) {
      marker_.done(FINAL_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean import_part(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_part")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    if (result_) {
      marker_.done(IMPORT_PART);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_IMPORT import_part (DOT import_part)*
  public static boolean import_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_statement")) return false;
    if (!nextTokenIs(builder_, W_IMPORT)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_IMPORT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, import_part(builder_, level_ + 1));
    result_ = pinned_ && import_statement_2(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(IMPORT_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (DOT import_part)*
  private static boolean import_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_statement_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!import_statement_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "import_statement_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // DOT import_part
  private static boolean import_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_statement_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && import_part(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_SQUARE_BRACKET expr_? CLOSE_SQUARE_BRACKET index_op?
  public static boolean index_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_op")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, index_op_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, CLOSE_SQUARE_BRACKET)) && result_;
    result_ = pinned_ && index_op_3(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(INDEX_OP);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean index_op_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_op_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  // index_op?
  private static boolean index_op_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_op_3")) return false;
    index_op(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_INLINE
  public static boolean inline_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inline_mod")) return false;
    if (!nextTokenIs(builder_, W_INLINE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_INLINE);
    if (result_) {
      marker_.done(INLINE_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // def_name val_tp?
  public static boolean lambda_par(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_par")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<lambda par>");
    result_ = def_name(builder_, level_ + 1);
    result_ = result_ && lambda_par_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(LAMBDA_PAR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // val_tp?
  private static boolean lambda_par_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_par_1")) return false;
    val_tp(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET lambda_par? (COMMA lambda_par)* CLOSE_BRACKET
  static boolean lambda_pars(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_pars")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, OPEN_BRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, lambda_pars_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, lambda_pars_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, CLOSE_BRACKET) && result_;
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // lambda_par?
  private static boolean lambda_pars_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_pars_1")) return false;
    lambda_par(builder_, level_ + 1);
    return true;
  }

  // (COMMA lambda_par)*
  private static boolean lambda_pars_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_pars_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!lambda_pars_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "lambda_pars_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA lambda_par
  private static boolean lambda_pars_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_pars_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && lambda_par(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_LAZY
  public static boolean lazy_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lazy_mod")) return false;
    if (!nextTokenIs(builder_, W_LAZY)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_LAZY);
    if (result_) {
      marker_.done(LAZY_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // COLON data_type
  public static boolean map_tp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_tp")) return false;
    if (!nextTokenIs(builder_, COLON)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && data_type(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(MAP_TP);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // static_mod | weak_mod | private_mod | protected_mod | lazy_mod | pure_mod | final_mod | override_mod | inline_mod
  public static boolean mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mod")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<mod>");
    result_ = static_mod(builder_, level_ + 1);
    if (!result_) result_ = weak_mod(builder_, level_ + 1);
    if (!result_) result_ = private_mod(builder_, level_ + 1);
    if (!result_) result_ = protected_mod(builder_, level_ + 1);
    if (!result_) result_ = lazy_mod(builder_, level_ + 1);
    if (!result_) result_ = pure_mod(builder_, level_ + 1);
    if (!result_) result_ = final_mod(builder_, level_ + 1);
    if (!result_) result_ = override_mod(builder_, level_ + 1);
    if (!result_) result_ = inline_mod(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), MOD)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(MOD);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // mod*
  public static boolean mods(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mods")) return false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<mods>");
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!mod(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "mods");
        break;
      }
      offset_ = next_offset_;
    }
    marker_.done(MODS);
    exitErrorRecordingSection(builder_, level_, true, false, _SECTION_GENERAL_, null);
    return true;
  }

  /* ********************************************************** */
  // W_OVERRIDE
  public static boolean override_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "override_mod")) return false;
    if (!nextTokenIs(builder_, W_OVERRIDE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_OVERRIDE);
    if (result_) {
      marker_.done(OVERRIDE_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean pack_part(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pack_part")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    if (result_) {
      marker_.done(PACK_PART);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_PACKAGE pack_part (DOT pack_part)*
  public static boolean pack_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pack_statement")) return false;
    if (!nextTokenIs(builder_, W_PACKAGE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_PACKAGE);
    result_ = result_ && pack_part(builder_, level_ + 1);
    result_ = result_ && pack_statement_2(builder_, level_ + 1);
    if (result_) {
      marker_.done(PACK_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // (DOT pack_part)*
  private static boolean pack_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pack_statement_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!pack_statement_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "pack_statement_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // DOT pack_part
  private static boolean pack_statement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pack_statement_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && pack_part(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // (W_WEAK)*
  public static boolean par_mods(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "par_mods")) return false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<par mods>");
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!par_mods_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "par_mods");
        break;
      }
      offset_ = next_offset_;
    }
    marker_.done(PAR_MODS);
    exitErrorRecordingSection(builder_, level_, true, false, _SECTION_GENERAL_, null);
    return true;
  }

  // (W_WEAK)
  private static boolean par_mods_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "par_mods_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_WEAK);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // PLUS_PLUS | MINUS_MINUS
  static boolean post_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "post_op")) return false;
    if (!nextTokenIs(builder_, MINUS_MINUS) && !nextTokenIs(builder_, PLUS_PLUS)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, PLUS_PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS_MINUS);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_PRIVATE
  public static boolean private_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "private_mod")) return false;
    if (!nextTokenIs(builder_, W_PRIVATE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_PRIVATE);
    if (result_) {
      marker_.done(PRIVATE_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_PROTECTED
  public static boolean protected_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "protected_mod")) return false;
    if (!nextTokenIs(builder_, W_PROTECTED)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_PROTECTED);
    if (result_) {
      marker_.done(PROTECTED_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_PURE
  public static boolean pure_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "pure_mod")) return false;
    if (!nextTokenIs(builder_, W_PURE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_PURE);
    if (result_) {
      marker_.done(PURE_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // SET expr_?
  static boolean set_val(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_val")) return false;
    if (!nextTokenIs(builder_, SET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, SET);
    pinned_ = result_; // pin = 1
    result_ = result_ && set_val_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // expr_?
  private static boolean set_val_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "set_val_1")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (annotations_ (class_mods class_statement | type_statement)) | import_statement | COMMENT
  static boolean statement_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = statement__0(builder_, level_ + 1);
    if (!result_) result_ = import_statement(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // annotations_ (class_mods class_statement | type_statement)
  private static boolean statement__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement__0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = annotations_(builder_, level_ + 1);
    result_ = result_ && statement__0_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // class_mods class_statement | type_statement
  private static boolean statement__0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement__0_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = statement__0_1_0(builder_, level_ + 1);
    if (!result_) result_ = type_statement(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // class_mods class_statement
  private static boolean statement__0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement__0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = class_mods(builder_, level_ + 1);
    result_ = result_ && class_statement(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_STATIC
  public static boolean static_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "static_mod")) return false;
    if (!nextTokenIs(builder_, W_STATIC)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_STATIC);
    if (result_) {
      marker_.done(STATIC_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // STRING+ |
  //     STRING_EXPR (
  //         W_IF OPEN_BRACKET expr_ CLOSE_BRACKET |
  //         W_WHEN OPEN_BRACKET expr_ CLOSE_BRACKET |
  //         W_ELSE | W_ENDIF |
  //         expr_)
  public static boolean string_token(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_token")) return false;
    if (!nextTokenIs(builder_, STRING) && !nextTokenIs(builder_, STRING_EXPR)
        && replaceVariants(builder_, 2, "<string token>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<string token>");
    result_ = string_token_0(builder_, level_ + 1);
    if (!result_) result_ = string_token_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(STRING_TOKEN);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // STRING+
  private static boolean string_token_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_token_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STRING);
    int offset_ = builder_.getCurrentOffset();
    while (result_) {
      if (!consumeToken(builder_, STRING)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "string_token_0");
        break;
      }
      offset_ = next_offset_;
    }
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // STRING_EXPR (
  //         W_IF OPEN_BRACKET expr_ CLOSE_BRACKET |
  //         W_WHEN OPEN_BRACKET expr_ CLOSE_BRACKET |
  //         W_ELSE | W_ENDIF |
  //         expr_)
  private static boolean string_token_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_token_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, STRING_EXPR);
    result_ = result_ && string_token_1_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_IF OPEN_BRACKET expr_ CLOSE_BRACKET |
  //         W_WHEN OPEN_BRACKET expr_ CLOSE_BRACKET |
  //         W_ELSE | W_ENDIF |
  //         expr_
  private static boolean string_token_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_token_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = string_token_1_1_0(builder_, level_ + 1);
    if (!result_) result_ = string_token_1_1_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, W_ELSE);
    if (!result_) result_ = consumeToken(builder_, W_ENDIF);
    if (!result_) result_ = expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_IF OPEN_BRACKET expr_ CLOSE_BRACKET
  private static boolean string_token_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_token_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, W_IF, OPEN_BRACKET);
    result_ = result_ && expr_(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_WHEN OPEN_BRACKET expr_ CLOSE_BRACKET
  private static boolean string_token_1_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_token_1_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, W_WHEN, OPEN_BRACKET);
    result_ = result_ && expr_(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expr_case | expr_throw | expr_not | expr_if | expr_lambda | expr_braces | expr_call | expr_arr | expr_brackets |
  //     expr_minus | W_NIL | TP_VOID | W_TRUE | W_FALSE | expr_string_const | INT | FLOAT | expr_self | expr_super | expr_while |
  //     expr_sync | expr_try | expr_do | W_BREAK | expr_return | expr_weak
  public static boolean term_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "term_")) return false;
    boolean result_ = false;
    int start_ = builder_.getCurrentOffset();
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<term>");
    result_ = expr_case(builder_, level_ + 1);
    if (!result_) result_ = expr_throw(builder_, level_ + 1);
    if (!result_) result_ = expr_not(builder_, level_ + 1);
    if (!result_) result_ = expr_if(builder_, level_ + 1);
    if (!result_) result_ = expr_lambda(builder_, level_ + 1);
    if (!result_) result_ = expr_braces(builder_, level_ + 1);
    if (!result_) result_ = expr_call(builder_, level_ + 1);
    if (!result_) result_ = expr_arr(builder_, level_ + 1);
    if (!result_) result_ = expr_brackets(builder_, level_ + 1);
    if (!result_) result_ = expr_minus(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, W_NIL);
    if (!result_) result_ = consumeToken(builder_, TP_VOID);
    if (!result_) result_ = consumeToken(builder_, W_TRUE);
    if (!result_) result_ = consumeToken(builder_, W_FALSE);
    if (!result_) result_ = expr_string_const(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, INT);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = expr_self(builder_, level_ + 1);
    if (!result_) result_ = expr_super(builder_, level_ + 1);
    if (!result_) result_ = expr_while(builder_, level_ + 1);
    if (!result_) result_ = expr_sync(builder_, level_ + 1);
    if (!result_) result_ = expr_try(builder_, level_ + 1);
    if (!result_) result_ = expr_do(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, W_BREAK);
    if (!result_) result_ = expr_return(builder_, level_ + 1);
    if (!result_) result_ = expr_weak(builder_, level_ + 1);
    LighterASTNode last_ = result_? builder_.getLatestDoneMarker() : null;
    if (last_ != null && last_.getStartOffset() == start_ && type_extends_(last_.getTokenType(), TERM)) {
      marker_.drop();
    }
    else if (result_) {
      marker_.done(TERM);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // W_TYPE class_name class_generics? SET class_extends
  public static boolean type_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type_statement")) return false;
    if (!nextTokenIs(builder_, W_TYPE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, W_TYPE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, class_name(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, type_statement_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, SET)) && result_;
    result_ = pinned_ && class_extends(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(TYPE_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // class_generics?
  private static boolean type_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type_statement_2")) return false;
    class_generics(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON data_type?
  static boolean val_tp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "val_tp")) return false;
    if (!nextTokenIs(builder_, COLON)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && val_tp_1(builder_, level_ + 1);
    if (!result_ && !pinned_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // data_type?
  private static boolean val_tp_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "val_tp_1")) return false;
    data_type(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // W_WEAK
  public static boolean weak_mod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "weak_mod")) return false;
    if (!nextTokenIs(builder_, W_WEAK)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_WEAK);
    if (result_) {
      marker_.done(WEAK_MOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

}

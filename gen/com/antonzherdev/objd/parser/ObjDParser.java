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
    if (root_ == CLASS_BODY) {
      result_ = class_body(builder_, level_ + 1);
    }
    else if (root_ == CLASS_NAME) {
      result_ = class_name(builder_, level_ + 1);
    }
    else if (root_ == CLASS_STATEMENT) {
      result_ = class_statement(builder_, level_ + 1);
    }
    else if (root_ == DATA_TYPE_REF) {
      result_ = data_type_ref(builder_, level_ + 1);
    }
    else if (root_ == DEF_STATEMENT) {
      result_ = def_statement(builder_, level_ + 1);
    }
    else if (root_ == FIELD_STATEMENT) {
      result_ = field_statement(builder_, level_ + 1);
    }
    else if (root_ == IMPORT_OD_FILE) {
      result_ = import_od_file(builder_, level_ + 1);
    }
    else if (root_ == IMPORT_STATEMENT) {
      result_ = import_statement(builder_, level_ + 1);
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
  // OPEN_BRACE enum_item* (def_statement | field_statement)* CLOSE_BRACE
  public static boolean class_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_body")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACE);
    result_ = result_ && class_body_1(builder_, level_ + 1);
    result_ = result_ && class_body_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACE);
    if (result_) {
      marker_.done(CLASS_BODY);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
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

  // (def_statement | field_statement)*
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

  // def_statement | field_statement
  private static boolean class_body_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_body_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = def_statement(builder_, level_ + 1);
    if (!result_) result_ = field_statement(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_WEAK? (W_VAR | W_VAL)? IDENT COLON data_type (SET expr_)?
  static boolean class_constructor_field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = class_constructor_field_0(builder_, level_ + 1);
    result_ = result_ && class_constructor_field_1(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, IDENT, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && class_constructor_field_5(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_WEAK?
  private static boolean class_constructor_field_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_constructor_field_0")) return false;
    consumeToken(builder_, W_WEAK);
    return true;
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
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
    result_ = result_ && class_constructor_field(builder_, level_ + 1);
    result_ = result_ && class_constructor_fields_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // W_EXTENDS IDENT data_type_generics?
  static boolean class_extends(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends")) return false;
    if (!nextTokenIs(builder_, W_EXTENDS)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, W_EXTENDS, IDENT);
    result_ = result_ && class_extends_2(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // data_type_generics?
  private static boolean class_extends_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends_2")) return false;
    data_type_generics(builder_, level_ + 1);
    return true;
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
  // (W_CLASS | W_TRAIT | W_STRUCT | W_ENUM) class_name expr_call_generics? class_constructor_fields? class_extends? class_body?
  public static boolean class_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<class statement>");
    result_ = class_statement_0(builder_, level_ + 1);
    result_ = result_ && class_name(builder_, level_ + 1);
    result_ = result_ && class_statement_2(builder_, level_ + 1);
    result_ = result_ && class_statement_3(builder_, level_ + 1);
    result_ = result_ && class_statement_4(builder_, level_ + 1);
    result_ = result_ && class_statement_5(builder_, level_ + 1);
    if (result_) {
      marker_.done(CLASS_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // W_CLASS | W_TRAIT | W_STRUCT | W_ENUM
  private static boolean class_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_CLASS);
    if (!result_) result_ = consumeToken(builder_, W_TRAIT);
    if (!result_) result_ = consumeToken(builder_, W_STRUCT);
    if (!result_) result_ = consumeToken(builder_, W_ENUM);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_call_generics?
  private static boolean class_statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_2")) return false;
    expr_call_generics(builder_, level_ + 1);
    return true;
  }

  // class_constructor_fields?
  private static boolean class_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_3")) return false;
    class_constructor_fields(builder_, level_ + 1);
    return true;
  }

  // class_extends?
  private static boolean class_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_4")) return false;
    class_extends(builder_, level_ + 1);
    return true;
  }

  // class_body?
  private static boolean class_statement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_statement_5")) return false;
    class_body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (data_type_simple| data_type_collection | data_type_tuple) WHAT? (ARROW data_type)?
  static boolean data_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_0(builder_, level_ + 1);
    result_ = result_ && data_type_1(builder_, level_ + 1);
    result_ = result_ && data_type_2(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // data_type_simple| data_type_collection | data_type_tuple
  private static boolean data_type_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_simple(builder_, level_ + 1);
    if (!result_) result_ = data_type_collection(builder_, level_ + 1);
    if (!result_) result_ = data_type_tuple(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // WHAT?
  private static boolean data_type_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_1")) return false;
    consumeToken(builder_, WHAT);
    return true;
  }

  // (ARROW data_type)?
  private static boolean data_type_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_2")) return false;
    data_type_2_0(builder_, level_ + 1);
    return true;
  }

  // ARROW data_type
  private static boolean data_type_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ARROW);
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
  // OPEN_SQUARE_BRACKET data_type CLOSE_SQUARE_BRACKET
  static boolean data_type_collection(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_collection")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // LESS data_type (COMMA data_type)* MORE
  static boolean data_type_generics(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_generics")) return false;
    if (!nextTokenIs(builder_, LESS)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LESS);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && data_type_generics_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MORE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // IDENT
  public static boolean data_type_ref(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_ref")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    if (result_) {
      marker_.done(DATA_TYPE_REF);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // (data_type_ref | TP_BOOL | TP_STRING | TP_INT | TP_UINT | TP_FLOAT | TP_VOID) data_type_generics? (ARROW data_type)?
  static boolean data_type_simple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_simple_0(builder_, level_ + 1);
    result_ = result_ && data_type_simple_1(builder_, level_ + 1);
    result_ = result_ && data_type_simple_2(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // data_type_ref | TP_BOOL | TP_STRING | TP_INT | TP_UINT | TP_FLOAT | TP_VOID
  private static boolean data_type_simple_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = data_type_ref(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TP_BOOL);
    if (!result_) result_ = consumeToken(builder_, TP_STRING);
    if (!result_) result_ = consumeToken(builder_, TP_INT);
    if (!result_) result_ = consumeToken(builder_, TP_UINT);
    if (!result_) result_ = consumeToken(builder_, TP_FLOAT);
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

  // (ARROW data_type)?
  private static boolean data_type_simple_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple_2")) return false;
    data_type_simple_2_0(builder_, level_ + 1);
    return true;
  }

  // ARROW data_type
  private static boolean data_type_simple_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_simple_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ARROW);
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
  // OPEN_BRACKET data_type? (COMMA data_type)* CLOSE_BRACKET
  static boolean data_type_tuple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_type_tuple")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
    result_ = result_ && data_type_tuple_1(builder_, level_ + 1);
    result_ = result_ && data_type_tuple_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // W_PRIVATE | W_STATIC
  static boolean def_mods(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_mods")) return false;
    if (!nextTokenIs(builder_, W_PRIVATE) && !nextTokenIs(builder_, W_STATIC)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_PRIVATE);
    if (!result_) result_ = consumeToken(builder_, W_STATIC);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // param_name? COLON data_type (SET expr_)?
  static boolean def_parameter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = def_parameter_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && def_parameter_3(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // param_name?
  private static boolean def_parameter_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_0")) return false;
    param_name(builder_, level_ + 1);
    return true;
  }

  // (SET expr_)?
  private static boolean def_parameter_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_3")) return false;
    def_parameter_3_0(builder_, level_ + 1);
    return true;
  }

  // SET expr_
  private static boolean def_parameter_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameter_3_0")) return false;
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
  // OPEN_BRACKET def_parameter (COMMA def_parameter)* CLOSE_BRACKET
  static boolean def_parameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_parameters")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
    result_ = result_ && def_parameter(builder_, level_ + 1);
    result_ = result_ && def_parameters_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // def_mods* W_DEF IDENT expr_call_generics? def_parameters? (COLON data_type)? SET? expr_?
  public static boolean def_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<def statement>");
    result_ = def_statement_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, W_DEF, IDENT);
    result_ = result_ && def_statement_3(builder_, level_ + 1);
    result_ = result_ && def_statement_4(builder_, level_ + 1);
    result_ = result_ && def_statement_5(builder_, level_ + 1);
    result_ = result_ && def_statement_6(builder_, level_ + 1);
    result_ = result_ && def_statement_7(builder_, level_ + 1);
    if (result_) {
      marker_.done(DEF_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // def_mods*
  private static boolean def_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_0")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!def_mods(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "def_statement_0");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // expr_call_generics?
  private static boolean def_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_3")) return false;
    expr_call_generics(builder_, level_ + 1);
    return true;
  }

  // def_parameters?
  private static boolean def_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_4")) return false;
    def_parameters(builder_, level_ + 1);
    return true;
  }

  // (COLON data_type)?
  private static boolean def_statement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_5")) return false;
    def_statement_5_0(builder_, level_ + 1);
    return true;
  }

  // COLON data_type
  private static boolean def_statement_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_5_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // SET?
  private static boolean def_statement_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_6")) return false;
    consumeToken(builder_, SET);
    return true;
  }

  // expr_?
  private static boolean def_statement_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "def_statement_7")) return false;
    expr_(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENT expr_call_params?
  static boolean enum_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_item")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    result_ = result_ && enum_item_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_call_params?
  private static boolean enum_item_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enum_item_1")) return false;
    expr_call_params(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (expr_throw | expr_not | expr_if | expr_lambda | expr_braces | expr_call | expr_arr | expr_val | expr_brackets | expr_minus | W_NIL | W_TRUE | W_FALSE | STRING | INT | FLOAT | W_SELF) (expr_op | index_op | post_op)?
  static boolean expr_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr__0(builder_, level_ + 1);
    result_ = result_ && expr__1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_throw | expr_not | expr_if | expr_lambda | expr_braces | expr_call | expr_arr | expr_val | expr_brackets | expr_minus | W_NIL | W_TRUE | W_FALSE | STRING | INT | FLOAT | W_SELF
  private static boolean expr__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr__0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_throw(builder_, level_ + 1);
    if (!result_) result_ = expr_not(builder_, level_ + 1);
    if (!result_) result_ = expr_if(builder_, level_ + 1);
    if (!result_) result_ = expr_lambda(builder_, level_ + 1);
    if (!result_) result_ = expr_braces(builder_, level_ + 1);
    if (!result_) result_ = expr_call(builder_, level_ + 1);
    if (!result_) result_ = expr_arr(builder_, level_ + 1);
    if (!result_) result_ = expr_val(builder_, level_ + 1);
    if (!result_) result_ = expr_brackets(builder_, level_ + 1);
    if (!result_) result_ = expr_minus(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, W_NIL);
    if (!result_) result_ = consumeToken(builder_, W_TRUE);
    if (!result_) result_ = consumeToken(builder_, W_FALSE);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, INT);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, W_SELF);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (expr_op | index_op | post_op)?
  private static boolean expr__1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr__1")) return false;
    expr__1_0(builder_, level_ + 1);
    return true;
  }

  // expr_op | index_op | post_op
  private static boolean expr__1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr__1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_op(builder_, level_ + 1);
    if (!result_) result_ = index_op(builder_, level_ + 1);
    if (!result_) result_ = post_op(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_SQUARE_BRACKET expr_? (COMMA expr_)* CLOSE_SQUARE_BRACKET
  static boolean expr_arr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_arr")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    result_ = result_ && expr_arr_1(builder_, level_ + 1);
    result_ = result_ && expr_arr_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // OPEN_BRACE expr_* CLOSE_BRACE
  static boolean expr_braces(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_braces")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACE)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACE);
    result_ = result_ && expr_braces_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // OPEN_BRACKET expr_ CLOSE_BRACKET
  static boolean expr_brackets(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_brackets")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
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
  // IDENT expr_call_generics? expr_call_params?
  static boolean expr_call(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    result_ = result_ && expr_call_1(builder_, level_ + 1);
    result_ = result_ && expr_call_2(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
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

  /* ********************************************************** */
  // LESS data_type (COMMA data_type)* MORE
  static boolean expr_call_generics(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_generics")) return false;
    if (!nextTokenIs(builder_, LESS)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LESS);
    result_ = result_ && data_type(builder_, level_ + 1);
    result_ = result_ && expr_call_generics_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, MORE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // (param_name SET)? expr_
  static boolean expr_call_param(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_call_param_0(builder_, level_ + 1);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (param_name SET)?
  private static boolean expr_call_param_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param_0")) return false;
    expr_call_param_0_0(builder_, level_ + 1);
    return true;
  }

  // param_name SET
  private static boolean expr_call_param_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_param_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = param_name(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_BRACKET expr_call_param? (COMMA expr_call_param)* CLOSE_BRACKET
  static boolean expr_call_params(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_params")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
    result_ = result_ && expr_call_params_1(builder_, level_ + 1);
    result_ = result_ && expr_call_params_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr_call_param?
  private static boolean expr_call_params_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_params_1")) return false;
    expr_call_param(builder_, level_ + 1);
    return true;
  }

  // (COMMA expr_call_param)*
  private static boolean expr_call_params_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_params_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!expr_call_params_2_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "expr_call_params_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // COMMA expr_call_param
  private static boolean expr_call_params_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_call_params_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expr_call_param(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_IF OPEN_BRACKET expr_ CLOSE_BRACKET expr_ (W_ELSE expr_)?
  static boolean expr_if(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if")) return false;
    if (!nextTokenIs(builder_, W_IF)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, W_IF, OPEN_BRACKET);
    result_ = result_ && expr_(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    result_ = result_ && expr_(builder_, level_ + 1);
    result_ = result_ && expr_if_5(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (W_ELSE expr_)?
  private static boolean expr_if_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if_5")) return false;
    expr_if_5_0(builder_, level_ + 1);
    return true;
  }

  // W_ELSE expr_
  private static boolean expr_if_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_if_5_0")) return false;
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
  // (lambda_par | lambda_pars) ARROW expr_
  static boolean expr_lambda(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_lambda")) return false;
    if (!nextTokenIs(builder_, IDENT) && !nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_lambda_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // MINUS expr_
  static boolean expr_minus(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_minus")) return false;
    if (!nextTokenIs(builder_, MINUS)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, MINUS);
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
  // EXCLAMATION expr_
  static boolean expr_not(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_not")) return false;
    if (!nextTokenIs(builder_, EXCLAMATION)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, EXCLAMATION);
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
  // (DOT | SET | PLUS | MINUS | MUL | DIV | AND | OR | EQ| MORE | LESS| MOREEQ| LESSEQ | PLUS_SET| MINUS_SET | MUL_SET | DIV_SET | NOT_EQ) expr_
  static boolean expr_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_op")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_op_0(builder_, level_ + 1);
    result_ = result_ && expr_(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // DOT | SET | PLUS | MINUS | MUL | DIV | AND | OR | EQ| MORE | LESS| MOREEQ| LESSEQ | PLUS_SET| MINUS_SET | MUL_SET | DIV_SET | NOT_EQ
  private static boolean expr_op_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_op_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, DOT);
    if (!result_) result_ = consumeToken(builder_, SET);
    if (!result_) result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    if (!result_) result_ = consumeToken(builder_, MUL);
    if (!result_) result_ = consumeToken(builder_, DIV);
    if (!result_) result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, OR);
    if (!result_) result_ = consumeToken(builder_, EQ);
    if (!result_) result_ = consumeToken(builder_, MORE);
    if (!result_) result_ = consumeToken(builder_, LESS);
    if (!result_) result_ = consumeToken(builder_, MOREEQ);
    if (!result_) result_ = consumeToken(builder_, LESSEQ);
    if (!result_) result_ = consumeToken(builder_, PLUS_SET);
    if (!result_) result_ = consumeToken(builder_, MINUS_SET);
    if (!result_) result_ = consumeToken(builder_, MUL_SET);
    if (!result_) result_ = consumeToken(builder_, DIV_SET);
    if (!result_) result_ = consumeToken(builder_, NOT_EQ);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_THROW expr_
  static boolean expr_throw(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_throw")) return false;
    if (!nextTokenIs(builder_, W_THROW)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_THROW);
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
  // (W_VAL | W_VAR) IDENT (COLON data_type)? (SET expr_)?
  static boolean expr_val(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val")) return false;
    if (!nextTokenIs(builder_, W_VAL) && !nextTokenIs(builder_, W_VAR)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr_val_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENT);
    result_ = result_ && expr_val_2(builder_, level_ + 1);
    result_ = result_ && expr_val_3(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_VAL | W_VAR
  private static boolean expr_val_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_0")) return false;
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

  // (COLON data_type)?
  private static boolean expr_val_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_2")) return false;
    expr_val_2_0(builder_, level_ + 1);
    return true;
  }

  // COLON data_type
  private static boolean expr_val_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (SET expr_)?
  private static boolean expr_val_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_3")) return false;
    expr_val_3_0(builder_, level_ + 1);
    return true;
  }

  // SET expr_
  private static boolean expr_val_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_val_3_0")) return false;
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
  // W_PRIVATE | W_STATIC | W_WEAK
  static boolean field_mods(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_mods")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_PRIVATE);
    if (!result_) result_ = consumeToken(builder_, W_STATIC);
    if (!result_) result_ = consumeToken(builder_, W_WEAK);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // field_mods* (W_VAR | W_VAL)? IDENT (COLON data_type)? (SET expr_)?
  public static boolean field_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<field statement>");
    result_ = field_statement_0(builder_, level_ + 1);
    result_ = result_ && field_statement_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENT);
    result_ = result_ && field_statement_3(builder_, level_ + 1);
    result_ = result_ && field_statement_4(builder_, level_ + 1);
    if (result_) {
      marker_.done(FIELD_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // field_mods*
  private static boolean field_statement_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_0")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!field_mods(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "field_statement_0");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (W_VAR | W_VAL)?
  private static boolean field_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_1")) return false;
    field_statement_1_0(builder_, level_ + 1);
    return true;
  }

  // W_VAR | W_VAL
  private static boolean field_statement_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_1_0")) return false;
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

  // (COLON data_type)?
  private static boolean field_statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_3")) return false;
    field_statement_3_0(builder_, level_ + 1);
    return true;
  }

  // COLON data_type
  private static boolean field_statement_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_3_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && data_type(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (SET expr_)?
  private static boolean field_statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_4")) return false;
    field_statement_4_0(builder_, level_ + 1);
    return true;
  }

  // SET expr_
  private static boolean field_statement_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_statement_4_0")) return false;
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
  // IDENT
  public static boolean import_od_file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_od_file")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    if (result_) {
      marker_.done(IMPORT_OD_FILE);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // W_IMPORT (import_od_file | STRING | (LESS IDENT MORE))
  public static boolean import_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_statement")) return false;
    if (!nextTokenIs(builder_, W_IMPORT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, W_IMPORT);
    result_ = result_ && import_statement_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(IMPORT_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // import_od_file | STRING | (LESS IDENT MORE)
  private static boolean import_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_statement_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = import_od_file(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = import_statement_1_2(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // LESS IDENT MORE
  private static boolean import_statement_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_statement_1_2")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, LESS, IDENT, MORE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // OPEN_SQUARE_BRACKET expr_ CLOSE_SQUARE_BRACKET
  static boolean index_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_op")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_SQUARE_BRACKET);
    result_ = result_ && expr_(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // IDENT (COLON data_type)?
  static boolean lambda_par(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_par")) return false;
    if (!nextTokenIs(builder_, IDENT)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    result_ = result_ && lambda_par_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (COLON data_type)?
  private static boolean lambda_par_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_par_1")) return false;
    lambda_par_1_0(builder_, level_ + 1);
    return true;
  }

  // COLON data_type
  private static boolean lambda_par_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_par_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COLON);
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
  // OPEN_BRACKET lambda_par (COMMA lambda_par)* CLOSE_BRACKET
  static boolean lambda_pars(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_pars")) return false;
    if (!nextTokenIs(builder_, OPEN_BRACKET)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, OPEN_BRACKET);
    result_ = result_ && lambda_par(builder_, level_ + 1);
    result_ = result_ && lambda_pars_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
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
  // IDENT | W_ELSE | W_DEF
  static boolean param_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "param_name")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, IDENT);
    if (!result_) result_ = consumeToken(builder_, W_ELSE);
    if (!result_) result_ = consumeToken(builder_, W_DEF);
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
  // (W_STUB? (class_statement | def_statement | field_statement))|import_statement |COMMENT
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

  // W_STUB? (class_statement | def_statement | field_statement)
  private static boolean statement__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement__0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = statement__0_0(builder_, level_ + 1);
    result_ = result_ && statement__0_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // W_STUB?
  private static boolean statement__0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement__0_0")) return false;
    consumeToken(builder_, W_STUB);
    return true;
  }

  // class_statement | def_statement | field_statement
  private static boolean statement__0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement__0_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = class_statement(builder_, level_ + 1);
    if (!result_) result_ = def_statement(builder_, level_ + 1);
    if (!result_) result_ = field_statement(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

}

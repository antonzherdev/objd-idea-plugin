/* The following code was generated by JFlex 1.4.3 on 25.09.13 11:51 */

package com.antonzherdev.objd;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 25.09.13 11:51 from the specification file
 * <tt>/Users/antonzherdev/dev/objd-idea-plugin/src/com/antonzherdev/objd/ObjD.flex</tt>
 */
class ObjDLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int COMMENT_STATE = 2;
  public static final int YYINITIAL = 0;
  public static final int STRING_STATE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\1\0\10\0\1\1\1\65\1\0\1\1\1\3\22\0\1\1\1\64"+
    "\1\11\3\0\1\61\1\0\1\53\1\54\1\4\1\62\1\55\1\6"+
    "\1\10\1\2\4\7\1\43\3\7\1\44\1\7\1\56\1\0\1\57"+
    "\1\60\1\46\1\63\1\0\32\5\1\51\1\66\1\52\1\0\1\5"+
    "\1\0\1\13\1\35\1\14\1\30\1\17\1\31\1\16\1\37\1\22"+
    "\1\42\1\15\1\20\1\23\1\33\1\24\1\12\1\5\1\25\1\21"+
    "\1\26\1\34\1\27\1\36\1\32\1\40\1\41\1\47\1\45\1\50"+
    "\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\21\5\1\1\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\1"+
    "\1\25\1\26\1\27\3\30\3\31\1\32\1\31\1\30"+
    "\1\33\1\34\1\35\1\0\1\36\1\37\1\7\1\40"+
    "\1\41\1\0\15\5\1\42\11\5\1\43\13\5\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\3\5\1\57\14\5\1\60\6\5\1\61"+
    "\1\62\1\5\1\63\2\5\1\64\13\5\1\65\1\5"+
    "\1\66\1\67\1\5\1\70\1\71\1\72\3\5\1\73"+
    "\1\5\1\74\1\75\3\5\1\76\2\5\1\77\2\5"+
    "\1\100\1\5\1\101\1\5\1\102\1\103\1\104\4\5"+
    "\1\105\7\5\1\106\1\107\1\5\1\110\1\111\1\112"+
    "\1\113\1\114\1\115\1\116\4\5\1\117\1\120\1\121"+
    "\1\122\1\123\1\124\1\5\1\125\1\126\1\127\1\130"+
    "\1\5\1\131\1\132\1\5\1\133";

  private static int [] zzUnpackAction() {
    int [] result = new int[224];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\67\0\156\0\245\0\334\0\u0113\0\u014a\0\u0181"+
    "\0\u01b8\0\u01ef\0\245\0\245\0\u0226\0\u025d\0\u0294\0\u02cb"+
    "\0\u0302\0\u0339\0\u0370\0\u03a7\0\u03de\0\u0415\0\u044c\0\u0483"+
    "\0\u04ba\0\u04f1\0\u0528\0\u055f\0\u0596\0\u05cd\0\u0604\0\245"+
    "\0\245\0\245\0\245\0\245\0\245\0\245\0\245\0\u063b"+
    "\0\u0672\0\u06a9\0\u06e0\0\245\0\u0717\0\245\0\334\0\u074e"+
    "\0\245\0\334\0\u0785\0\245\0\u07bc\0\u07f3\0\245\0\245"+
    "\0\245\0\u082a\0\245\0\245\0\u0861\0\245\0\245\0\u0898"+
    "\0\u08cf\0\u0906\0\u093d\0\u0974\0\u09ab\0\u09e2\0\u0a19\0\u0a50"+
    "\0\u0a87\0\u0abe\0\u0af5\0\u0b2c\0\u0b63\0\u0181\0\u0b9a\0\u0bd1"+
    "\0\u0c08\0\u0c3f\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b\0\u0d52\0\u0181"+
    "\0\u0d89\0\u0dc0\0\u0df7\0\u0e2e\0\u0e65\0\u0e9c\0\u0ed3\0\u0f0a"+
    "\0\u0f41\0\u0f78\0\u0faf\0\245\0\245\0\245\0\245\0\245"+
    "\0\245\0\245\0\245\0\245\0\245\0\u0898\0\u0fe6\0\u101d"+
    "\0\u1054\0\u0181\0\u108b\0\u10c2\0\u10f9\0\u1130\0\u1167\0\u119e"+
    "\0\u11d5\0\u120c\0\u1243\0\u127a\0\u12b1\0\u12e8\0\u131f\0\u1356"+
    "\0\u138d\0\u13c4\0\u13fb\0\u1432\0\u1469\0\u0181\0\u0181\0\u14a0"+
    "\0\u0181\0\u14d7\0\u150e\0\u0181\0\u1545\0\u157c\0\u15b3\0\u15ea"+
    "\0\u1621\0\u1658\0\u168f\0\u16c6\0\u16fd\0\u1734\0\u176b\0\u0181"+
    "\0\u17a2\0\u0181\0\u0181\0\u17d9\0\u0181\0\u0181\0\u0181\0\u1810"+
    "\0\u1847\0\u187e\0\u0181\0\u18b5\0\u0181\0\u0181\0\u18ec\0\u1923"+
    "\0\u195a\0\u0181\0\u1991\0\u19c8\0\u0181\0\u19ff\0\u1a36\0\u1a6d"+
    "\0\u1aa4\0\u0181\0\u1adb\0\u0181\0\u0181\0\u0181\0\u1b12\0\u1b49"+
    "\0\u1b80\0\u1bb7\0\u0181\0\u1bee\0\u1c25\0\u1c5c\0\u1c93\0\u1cca"+
    "\0\u1d01\0\u1d38\0\u0181\0\u0181\0\u1d6f\0\u0181\0\u1da6\0\u0181"+
    "\0\u0181\0\u0181\0\u0181\0\u0181\0\u1ddd\0\u1e14\0\u1e4b\0\u1e82"+
    "\0\u0181\0\u0181\0\u0181\0\u0181\0\u0181\0\u0181\0\u1eb9\0\u0181"+
    "\0\u0181\0\u0181\0\u0181\0\u1ef0\0\u0181\0\u0181\0\u1f27\0\u0181";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[224];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\5\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\2\10\1\20\1\21"+
    "\1\22\1\23\1\10\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\10\1\32\1\33\1\34\1\35\4\10\2\12"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
    "\1\5\1\4\1\56\1\57\1\56\1\57\1\60\60\56"+
    "\1\5\1\56\1\61\1\62\1\61\1\62\1\61\1\63"+
    "\1\61\1\63\1\61\1\64\33\63\20\61\1\5\1\65"+
    "\70\0\1\5\1\0\1\5\61\0\1\5\3\0\1\66"+
    "\1\0\1\67\53\0\1\70\12\0\1\71\40\0\1\72"+
    "\12\0\1\73\13\0\1\10\1\0\1\10\2\0\33\10"+
    "\30\0\1\74\1\75\33\0\2\75\1\0\1\76\11\0"+
    "\1\77\13\0\1\10\1\0\1\12\1\100\1\0\31\10"+
    "\2\12\27\0\1\10\1\0\1\10\2\0\1\10\1\101"+
    "\11\10\1\102\17\10\27\0\1\10\1\0\1\10\2\0"+
    "\21\10\1\103\11\10\27\0\1\10\1\0\1\10\2\0"+
    "\1\10\1\104\4\10\1\105\16\10\1\106\5\10\27\0"+
    "\1\10\1\0\1\10\2\0\6\10\1\107\11\10\1\110"+
    "\1\111\11\10\27\0\1\10\1\0\1\10\2\0\1\10"+
    "\1\112\31\10\27\0\1\10\1\0\1\10\2\0\5\10"+
    "\1\113\6\10\1\114\16\10\27\0\1\10\1\0\1\10"+
    "\2\0\11\10\1\115\5\10\1\116\1\10\1\117\11\10"+
    "\27\0\1\10\1\0\1\10\2\0\23\10\1\120\7\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\121\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\13\10\1\122\11\10"+
    "\1\123\1\124\4\10\27\0\1\10\1\0\1\10\2\0"+
    "\1\10\1\125\10\10\1\126\20\10\27\0\1\10\1\0"+
    "\1\10\2\0\5\10\1\127\4\10\1\130\20\10\27\0"+
    "\1\10\1\0\1\10\2\0\1\10\1\131\4\10\1\132"+
    "\24\10\27\0\1\10\1\0\1\10\2\0\10\10\1\133"+
    "\22\10\27\0\1\10\1\0\1\10\2\0\10\10\1\134"+
    "\12\10\1\135\7\10\27\0\1\10\1\0\1\10\2\0"+
    "\12\10\1\136\1\137\12\10\1\140\4\10\27\0\1\10"+
    "\1\0\1\10\2\0\5\10\1\141\2\10\1\142\14\10"+
    "\1\143\5\10\67\0\1\144\101\0\1\145\66\0\1\146"+
    "\66\0\1\147\67\0\1\150\65\0\1\151\1\0\1\152"+
    "\64\0\1\153\10\0\1\154\71\0\1\63\1\0\1\63"+
    "\2\0\33\63\33\0\1\61\54\0\1\61\3\66\1\0"+
    "\61\66\1\0\1\66\4\0\1\155\71\0\1\75\1\100"+
    "\32\0\2\75\31\0\1\156\33\0\2\156\27\0\1\10"+
    "\1\0\1\10\2\0\2\10\1\157\30\10\27\0\1\10"+
    "\1\0\1\10\2\0\10\10\1\160\1\10\1\161\20\10"+
    "\27\0\1\10\1\0\1\10\2\0\26\10\1\162\4\10"+
    "\27\0\1\10\1\0\1\10\2\0\7\10\1\163\23\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\164\31\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\165\31\10"+
    "\27\0\1\10\1\0\1\10\2\0\7\10\1\166\23\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\167\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\22\10\1\170\10\10"+
    "\27\0\1\10\1\0\1\10\2\0\27\10\1\171\3\10"+
    "\27\0\1\10\1\0\1\10\2\0\6\10\1\172\24\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\173\11\10"+
    "\1\174\6\10\1\175\10\10\27\0\1\10\1\0\1\10"+
    "\2\0\1\176\32\10\27\0\1\10\1\0\1\10\2\0"+
    "\14\10\1\177\16\10\27\0\1\10\1\0\1\10\2\0"+
    "\30\10\1\200\2\10\27\0\1\10\1\0\1\10\2\0"+
    "\14\10\1\201\16\10\27\0\1\10\1\0\1\10\2\0"+
    "\1\10\1\202\20\10\1\203\10\10\27\0\1\10\1\0"+
    "\1\10\2\0\13\10\1\204\17\10\27\0\1\10\1\0"+
    "\1\10\2\0\1\205\32\10\27\0\1\10\1\0\1\10"+
    "\2\0\6\10\1\206\4\10\1\207\17\10\27\0\1\10"+
    "\1\0\1\10\2\0\10\10\1\210\22\10\27\0\1\10"+
    "\1\0\1\10\2\0\17\10\1\211\13\10\27\0\1\10"+
    "\1\0\1\10\2\0\6\10\1\212\24\10\27\0\1\10"+
    "\1\0\1\10\2\0\12\10\1\213\20\10\27\0\1\10"+
    "\1\0\1\10\2\0\6\10\1\214\24\10\27\0\1\10"+
    "\1\0\1\10\2\0\21\10\1\215\11\10\27\0\1\10"+
    "\1\0\1\10\2\0\26\10\1\216\4\10\27\0\1\10"+
    "\1\0\1\10\2\0\12\10\1\217\20\10\27\0\1\10"+
    "\1\0\1\10\2\0\5\10\1\220\25\10\27\0\1\10"+
    "\1\0\1\10\2\0\14\10\1\221\16\10\27\0\1\10"+
    "\1\0\1\10\2\0\1\10\1\222\31\10\27\0\1\10"+
    "\1\0\1\10\2\0\14\10\1\223\16\10\27\0\1\10"+
    "\1\0\1\10\2\0\10\10\1\224\22\10\27\0\1\10"+
    "\1\0\1\10\2\0\3\10\1\225\27\10\27\0\1\10"+
    "\1\0\1\10\2\0\15\10\1\226\15\10\27\0\1\10"+
    "\1\0\1\10\2\0\14\10\1\227\16\10\27\0\1\10"+
    "\1\0\1\10\2\0\5\10\1\230\25\10\27\0\1\10"+
    "\1\0\1\10\2\0\7\10\1\231\23\10\27\0\1\10"+
    "\1\0\1\10\2\0\13\10\1\232\17\10\27\0\1\10"+
    "\1\0\1\10\2\0\5\10\1\233\25\10\27\0\1\10"+
    "\1\0\1\10\2\0\5\10\1\234\25\10\27\0\1\10"+
    "\1\0\1\10\2\0\11\10\1\235\21\10\27\0\1\10"+
    "\1\0\1\10\2\0\26\10\1\236\4\10\27\0\1\10"+
    "\1\0\1\10\2\0\17\10\1\237\13\10\27\0\1\10"+
    "\1\0\1\10\2\0\14\10\1\240\16\10\27\0\1\10"+
    "\1\0\1\10\2\0\10\10\1\241\11\10\1\242\10\10"+
    "\27\0\1\10\1\0\1\10\2\0\23\10\1\243\7\10"+
    "\27\0\1\10\1\0\1\10\2\0\12\10\1\244\20\10"+
    "\27\0\1\10\1\0\1\10\2\0\31\10\1\245\1\246"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\247\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\22\10\1\250\10\10"+
    "\27\0\1\10\1\0\1\10\2\0\10\10\1\251\22\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\252\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\12\10\1\253\20\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\254\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\16\10\1\255\14\10"+
    "\27\0\1\10\1\0\1\10\2\0\7\10\1\256\23\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\257\31\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\260\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\261\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\6\10\1\262\24\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\263\31\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\264\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\3\10\1\265\27\10"+
    "\27\0\1\10\1\0\1\10\2\0\25\10\1\266\5\10"+
    "\27\0\1\10\1\0\1\10\2\0\6\10\1\267\24\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\270\31\10"+
    "\27\0\1\10\1\0\1\10\2\0\1\10\1\271\31\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\272\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\7\10\1\273\23\10"+
    "\27\0\1\10\1\0\1\10\2\0\21\10\1\274\11\10"+
    "\27\0\1\10\1\0\1\10\2\0\10\10\1\275\22\10"+
    "\27\0\1\10\1\0\1\10\2\0\21\10\1\276\11\10"+
    "\27\0\1\10\1\0\1\10\2\0\2\10\1\277\30\10"+
    "\27\0\1\10\1\0\1\10\2\0\13\10\1\300\17\10"+
    "\27\0\1\10\1\0\1\10\2\0\2\10\1\301\30\10"+
    "\27\0\1\10\1\0\1\10\2\0\13\10\1\302\17\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\303\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\24\10\1\304\6\10"+
    "\27\0\1\10\1\0\1\10\2\0\16\10\1\305\14\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\306\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\307\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\31\10\1\310\1\311"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\312\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\3\10\1\313\27\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\314\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\4\10\1\315\26\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\316\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\2\10\1\317\30\10"+
    "\27\0\1\10\1\0\1\10\2\0\16\10\1\320\14\10"+
    "\27\0\1\10\1\0\1\10\2\0\2\10\1\321\30\10"+
    "\27\0\1\10\1\0\1\10\2\0\4\10\1\322\26\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\323\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\324\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\325\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\21\10\1\326\11\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\327\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\31\10\1\330\1\331"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\332\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\333\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\14\10\1\334\16\10"+
    "\27\0\1\10\1\0\1\10\2\0\7\10\1\335\23\10"+
    "\27\0\1\10\1\0\1\10\2\0\17\10\1\336\13\10"+
    "\27\0\1\10\1\0\1\10\2\0\5\10\1\337\25\10"+
    "\27\0\1\10\1\0\1\10\2\0\16\10\1\340\14\10"+
    "\22\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8030];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\6\1\2\11\23\1\10\11\4\1\1\11"+
    "\1\1\1\11\2\1\1\11\2\1\1\11\2\1\3\11"+
    "\1\0\2\11\1\1\2\11\1\0\43\1\12\11\163\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[224];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  ObjDLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  ObjDLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 142) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 41: 
          { return ObjDTypes.PLUS_SET;
          }
        case 92: break;
        case 74: 
          { return ObjDTypes.TP_UINT4;
          }
        case 93: break;
        case 53: 
          { return ObjDTypes.W_CASE;
          }
        case 94: break;
        case 60: 
          { return ObjDTypes.TP_INT4;
          }
        case 95: break;
        case 79: 
          { return ObjDTypes.W_STATIC;
          }
        case 96: break;
        case 52: 
          { return ObjDTypes.W_NIL;
          }
        case 97: break;
        case 88: 
          { return ObjDTypes.W_PRIVATE;
          }
        case 98: break;
        case 20: 
          { return ObjDTypes.SET;
          }
        case 99: break;
        case 42: 
          { return ObjDTypes.PLUS_PLUS;
          }
        case 100: break;
        case 23: 
          { return ObjDTypes.EXCLAMATION;
          }
        case 101: break;
        case 35: 
          { return ObjDTypes.W_DO;
          }
        case 102: break;
        case 6: 
          { return ObjDTypes.MINUS;
          }
        case 103: break;
        case 78: 
          { return ObjDTypes.W_WHILE;
          }
        case 104: break;
        case 85: 
          { return ObjDTypes.TP_FLOAT4;
          }
        case 105: break;
        case 9: 
          { yybegin(STRING_STATE); return ObjDTypes.STRING;
          }
        case 106: break;
        case 37: 
          { return ObjDTypes.MOREEQ;
          }
        case 107: break;
        case 11: 
          { return ObjDTypes.OPEN_BRACE;
          }
        case 108: break;
        case 14: 
          { return ObjDTypes.CLOSE_SQUARE_BRACKET;
          }
        case 109: break;
        case 58: 
          { return ObjDTypes.W_SELF;
          }
        case 110: break;
        case 32: 
          { return ObjDTypes.ARROW;
          }
        case 111: break;
        case 30: 
          { return ObjDTypes.MUL_SET;
          }
        case 112: break;
        case 62: 
          { return ObjDTypes.W_TRUE;
          }
        case 113: break;
        case 84: 
          { return ObjDTypes.W_RETURN;
          }
        case 114: break;
        case 83: 
          { return ObjDTypes.W_OBJECT;
          }
        case 115: break;
        case 91: 
          { return ObjDTypes.W_PROTECTED;
          }
        case 116: break;
        case 77: 
          { return ObjDTypes.W_BREAK;
          }
        case 117: break;
        case 39: 
          { return ObjDTypes.EQ;
          }
        case 118: break;
        case 3: 
          { return ObjDTypes.DIV;
          }
        case 119: break;
        case 70: 
          { return ObjDTypes.W_TRAIT;
          }
        case 120: break;
        case 43: 
          { return ObjDTypes.NOT_EQ;
          }
        case 121: break;
        case 16: 
          { return ObjDTypes.CLOSE_BRACKET;
          }
        case 122: break;
        case 2: 
          { return TokenType.WHITE_SPACE;
          }
        case 123: break;
        case 5: 
          { return ObjDTypes.IDENT;
          }
        case 124: break;
        case 25: 
          { return ObjDTypes.STRING;
          }
        case 125: break;
        case 89: 
          { return ObjDTypes.W_EXTENDS;
          }
        case 126: break;
        case 81: 
          { return ObjDTypes.W_STRUCT;
          }
        case 127: break;
        case 75: 
          { return ObjDTypes.TP_UINT8;
          }
        case 128: break;
        case 8: 
          { return ObjDTypes.DOT;
          }
        case 129: break;
        case 19: 
          { return ObjDTypes.LESS;
          }
        case 130: break;
        case 18: 
          { return ObjDTypes.COLON;
          }
        case 131: break;
        case 63: 
          { return ObjDTypes.TP_VOID;
          }
        case 132: break;
        case 33: 
          { return ObjDTypes.MINUS_SET;
          }
        case 133: break;
        case 12: 
          { return ObjDTypes.CLOSE_BRACE;
          }
        case 134: break;
        case 61: 
          { return ObjDTypes.TP_INT8;
          }
        case 135: break;
        case 34: 
          { return ObjDTypes.W_IF;
          }
        case 136: break;
        case 31: 
          { return ObjDTypes.MINUS_MINUS;
          }
        case 137: break;
        case 29: 
          { return ObjDTypes.CLUE;
          }
        case 138: break;
        case 44: 
          { yybegin(YYINITIAL); return ObjDTypes.COMMENT;
          }
        case 139: break;
        case 86: 
          { return ObjDTypes.TP_FLOAT8;
          }
        case 140: break;
        case 45: 
          { return ObjDTypes.CLONE;
          }
        case 141: break;
        case 73: 
          { return ObjDTypes.TP_FLOAT;
          }
        case 142: break;
        case 49: 
          { return ObjDTypes.W_VAL;
          }
        case 143: break;
        case 7: 
          { return ObjDTypes.INT;
          }
        case 144: break;
        case 69: 
          { return ObjDTypes.W_CLASS;
          }
        case 145: break;
        case 1: 
          { return TokenType.BAD_CHARACTER;
          }
        case 146: break;
        case 13: 
          { return ObjDTypes.OPEN_SQUARE_BRACKET;
          }
        case 147: break;
        case 90: 
          { return ObjDTypes.W_TYPE;
          }
        case 148: break;
        case 50: 
          { return ObjDTypes.W_VAR;
          }
        case 149: break;
        case 24: 
          { return ObjDTypes.COMMENT;
          }
        case 150: break;
        case 17: 
          { return ObjDTypes.COMMA;
          }
        case 151: break;
        case 27: 
          { yybegin(COMMENT_STATE); return ObjDTypes.COMMENT;
          }
        case 152: break;
        case 15: 
          { return ObjDTypes.OPEN_BRACKET;
          }
        case 153: break;
        case 56: 
          { return ObjDTypes.W_ENUM;
          }
        case 154: break;
        case 87: 
          { return ObjDTypes.W_PACKAGE;
          }
        case 155: break;
        case 72: 
          { return ObjDTypes.W_FALSE;
          }
        case 156: break;
        case 64: 
          { return ObjDTypes.TP_UINT;
          }
        case 157: break;
        case 65: 
          { return ObjDTypes.TP_BOOL;
          }
        case 158: break;
        case 26: 
          { yybegin(YYINITIAL); return ObjDTypes.STRING;
          }
        case 159: break;
        case 28: 
          { return ObjDTypes.DIV_SET;
          }
        case 160: break;
        case 4: 
          { return ObjDTypes.MUL;
          }
        case 161: break;
        case 82: 
          { return ObjDTypes.W_IMPORT;
          }
        case 162: break;
        case 21: 
          { return ObjDTypes.PLUS;
          }
        case 163: break;
        case 10: 
          { return ObjDTypes.MORE;
          }
        case 164: break;
        case 36: 
          { return ObjDTypes.OR;
          }
        case 165: break;
        case 54: 
          { return ObjDTypes.TP_CHAR;
          }
        case 166: break;
        case 80: 
          { return ObjDTypes.TP_STRING;
          }
        case 167: break;
        case 22: 
          { return ObjDTypes.WHAT;
          }
        case 168: break;
        case 76: 
          { return ObjDTypes.TP_UBYTE;
          }
        case 169: break;
        case 57: 
          { return ObjDTypes.W_LAZY;
          }
        case 170: break;
        case 71: 
          { return ObjDTypes.W_THROW;
          }
        case 171: break;
        case 66: 
          { return ObjDTypes.TP_BYTE;
          }
        case 172: break;
        case 51: 
          { return ObjDTypes.W_DEF;
          }
        case 173: break;
        case 38: 
          { return ObjDTypes.LESSEQ;
          }
        case 174: break;
        case 40: 
          { return ObjDTypes.AND;
          }
        case 175: break;
        case 47: 
          { return ObjDTypes.TP_ANY;
          }
        case 176: break;
        case 59: 
          { return ObjDTypes.W_STUB;
          }
        case 177: break;
        case 55: 
          { return ObjDTypes.W_ELSE;
          }
        case 178: break;
        case 68: 
          { return ObjDTypes.W_WITH;
          }
        case 179: break;
        case 46: 
          { return ObjDTypes.FLOAT;
          }
        case 180: break;
        case 48: 
          { return ObjDTypes.TP_INT;
          }
        case 181: break;
        case 67: 
          { return ObjDTypes.W_WEAK;
          }
        case 182: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

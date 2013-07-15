/* The following code was generated by JFlex 1.4.3 on 15.07.13 10:40 */

package com.antonzherdev.objd;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.antonzherdev.objd.psi.ObjDTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10.07.13 10:58 from the specification file
 * <tt>/Users/antonzherdev/dev/ObjDPlugin/src/com/antonzherdev/objd/ObjD.flex</tt>
 */
class ObjDLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int COMMENT_STATE = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\1\0\10\0\1\1\1\6\1\0\1\1\1\3\22\0\1\1\1\57"+
    "\1\5\3\0\1\53\1\0\1\44\1\45\1\4\1\55\1\46\1\10"+
    "\1\54\1\2\12\11\1\47\1\0\1\50\1\51\1\37\1\56\1\0"+
    "\32\7\1\42\1\0\1\43\1\0\1\7\1\0\1\14\1\33\1\12"+
    "\1\25\1\26\1\27\1\36\1\7\1\16\1\7\1\35\1\13\1\17"+
    "\1\31\1\21\1\20\1\7\1\22\1\15\1\23\1\32\1\24\1\34"+
    "\1\30\2\7\1\40\1\52\1\41\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\7\15\5\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\2\1\1\23\1\24"+
    "\1\25\1\26\4\27\1\30\1\31\1\32\1\0\1\33"+
    "\1\34\1\7\1\35\1\36\1\0\1\5\1\7\4\5"+
    "\1\37\17\5\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\7\3\51\6\5\1\52\3\5"+
    "\1\53\1\54\1\5\1\55\5\5\1\56\3\5\1\51"+
    "\4\5\1\57\1\60\3\5\1\61\1\62\1\63\1\5"+
    "\1\64\2\5\1\65\1\66\1\67\1\70\5\5\1\71"+
    "\1\5\1\72\1\73\1\74\1\75\1\76\1\77\2\5"+
    "\1\100\1\101";

  private static int [] zzUnpackAction() {
    int [] result = new int[150];
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
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0\0\u02d0"+
    "\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420\0\u0450"+
    "\0\140\0\140\0\140\0\140\0\140\0\140\0\140\0\140"+
    "\0\u0480\0\u04b0\0\u04e0\0\u0510\0\140\0\u0540\0\140\0\u0570"+
    "\0\140\0\220\0\u05a0\0\u05d0\0\140\0\140\0\140\0\u0120"+
    "\0\u0120\0\140\0\u0600\0\140\0\140\0\u0630\0\u0660\0\u0690"+
    "\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0150\0\u0780\0\u07b0\0\u07e0"+
    "\0\u0810\0\u0840\0\u0870\0\u08a0\0\u08d0\0\u0900\0\u0930\0\u0960"+
    "\0\u0990\0\u09c0\0\u09f0\0\u0a20\0\140\0\140\0\140\0\140"+
    "\0\140\0\140\0\140\0\140\0\140\0\u0a50\0\u0630\0\u0660"+
    "\0\u0690\0\u0a80\0\u0ab0\0\u0ae0\0\u0b10\0\u0b40\0\u0b70\0\u0150"+
    "\0\u0ba0\0\u0bd0\0\u0c00\0\u0150\0\u0150\0\u0c30\0\u0150\0\u0c60"+
    "\0\u0c90\0\u0cc0\0\u0cf0\0\u0d20\0\u0150\0\u0d50\0\u0d80\0\u0db0"+
    "\0\u0a50\0\u0de0\0\u0e10\0\u0e40\0\u0e70\0\u0150\0\u0150\0\u0ea0"+
    "\0\u0ed0\0\u0f00\0\u0150\0\u0150\0\u0150\0\u0f30\0\u0150\0\u0f60"+
    "\0\u0f90\0\u0150\0\u0150\0\u0150\0\u0150\0\u0fc0\0\u0ff0\0\u1020"+
    "\0\u1050\0\u1080\0\u0150\0\u10b0\0\u0150\0\u0150\0\u0150\0\u0150"+
    "\0\u0150\0\u0150\0\u10e0\0\u1110\0\u0150\0\u0150";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[150];
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
    "\1\3\1\4\1\5\1\4\1\6\1\7\1\4\1\10"+
    "\1\11\1\12\1\13\2\10\1\14\1\15\1\10\1\16"+
    "\2\10\1\17\1\20\1\21\1\22\1\23\1\10\1\24"+
    "\1\25\1\26\1\27\2\10\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\51"+
    "\1\52\1\53\1\51\1\4\51\51\61\0\1\4\1\0"+
    "\1\4\2\0\1\4\53\0\1\54\1\0\1\55\44\0"+
    "\1\56\57\0\1\57\6\0\5\60\1\61\1\0\51\60"+
    "\7\0\1\10\1\0\26\10\31\0\1\62\1\63\25\0"+
    "\1\64\11\0\1\65\6\0\6\66\1\0\1\67\1\66"+
    "\1\70\25\67\21\66\7\0\1\10\1\0\2\10\1\71"+
    "\23\10\30\0\1\10\1\0\12\10\1\72\2\10\1\73"+
    "\10\10\30\0\1\10\1\0\6\10\1\74\7\10\1\75"+
    "\1\10\1\76\5\10\30\0\1\10\1\0\11\10\1\77"+
    "\14\10\30\0\1\10\1\0\11\10\1\100\14\10\30\0"+
    "\1\10\1\0\3\10\1\101\4\10\1\102\15\10\30\0"+
    "\1\10\1\0\15\10\1\103\10\10\30\0\1\10\1\0"+
    "\2\10\1\104\14\10\1\105\1\106\5\10\30\0\1\10"+
    "\1\0\2\10\1\107\1\110\22\10\30\0\1\10\1\0"+
    "\5\10\1\111\20\10\30\0\1\10\1\0\5\10\1\112"+
    "\20\10\30\0\1\10\1\0\10\10\1\113\15\10\30\0"+
    "\1\10\1\0\15\10\1\114\10\10\72\0\1\115\57\0"+
    "\1\116\57\0\1\117\60\0\1\120\60\0\1\121\55\0"+
    "\1\122\3\0\1\123\53\0\1\124\10\0\1\125\55\0"+
    "\3\54\1\0\2\54\1\0\51\54\6\66\1\0\2\66"+
    "\1\126\46\66\11\0\1\127\55\0\1\10\1\0\1\130"+
    "\25\10\21\0\6\66\1\0\1\67\1\66\1\131\25\67"+
    "\21\66\7\0\1\10\1\0\3\10\1\132\22\10\30\0"+
    "\1\10\1\0\3\10\1\133\5\10\1\134\7\10\1\135"+
    "\4\10\30\0\1\10\1\0\2\10\1\136\23\10\30\0"+
    "\1\10\1\0\7\10\1\137\16\10\30\0\1\10\1\0"+
    "\12\10\1\140\13\10\30\0\1\10\1\0\5\10\1\141"+
    "\20\10\30\0\1\10\1\0\3\10\1\142\15\10\1\143"+
    "\4\10\30\0\1\10\1\0\2\10\1\144\6\10\1\145"+
    "\14\10\30\0\1\10\1\0\5\10\1\146\20\10\30\0"+
    "\1\10\1\0\16\10\1\147\7\10\30\0\1\10\1\0"+
    "\4\10\1\150\21\10\30\0\1\10\1\0\12\10\1\151"+
    "\13\10\30\0\1\10\1\0\21\10\1\152\4\10\30\0"+
    "\1\10\1\0\10\10\1\153\15\10\30\0\1\10\1\0"+
    "\2\10\1\154\23\10\30\0\1\10\1\0\2\10\1\155"+
    "\23\10\30\0\1\10\1\0\20\10\1\156\5\10\30\0"+
    "\1\10\1\0\10\10\1\157\15\10\30\0\1\10\1\0"+
    "\3\10\1\160\22\10\21\0\6\66\1\0\2\66\1\161"+
    "\46\66\7\0\1\10\1\0\4\10\1\162\21\10\30\0"+
    "\1\10\1\0\12\10\1\163\13\10\30\0\1\10\1\0"+
    "\5\10\1\164\13\10\1\165\4\10\30\0\1\10\1\0"+
    "\22\10\1\166\3\10\30\0\1\10\1\0\16\10\1\167"+
    "\7\10\30\0\1\10\1\0\10\10\1\170\15\10\30\0"+
    "\1\10\1\0\13\10\1\171\12\10\30\0\1\10\1\0"+
    "\5\10\1\172\20\10\30\0\1\10\1\0\15\10\1\173"+
    "\10\10\30\0\1\10\1\0\14\10\1\174\11\10\30\0"+
    "\1\10\1\0\15\10\1\175\10\10\30\0\1\10\1\0"+
    "\15\10\1\176\10\10\30\0\1\10\1\0\6\10\1\177"+
    "\17\10\30\0\1\10\1\0\3\10\1\200\22\10\30\0"+
    "\1\10\1\0\4\10\1\201\21\10\30\0\1\10\1\0"+
    "\12\10\1\202\13\10\30\0\1\10\1\0\2\10\1\203"+
    "\23\10\30\0\1\10\1\0\24\10\1\204\1\10\30\0"+
    "\1\10\1\0\4\10\1\205\21\10\30\0\1\10\1\0"+
    "\5\10\1\206\20\10\30\0\1\10\1\0\20\10\1\207"+
    "\5\10\30\0\1\10\1\0\1\10\1\210\24\10\30\0"+
    "\1\10\1\0\11\10\1\211\14\10\30\0\1\10\1\0"+
    "\3\10\1\212\22\10\30\0\1\10\1\0\12\10\1\213"+
    "\13\10\30\0\1\10\1\0\20\10\1\214\5\10\30\0"+
    "\1\10\1\0\12\10\1\215\13\10\30\0\1\10\1\0"+
    "\15\10\1\216\10\10\30\0\1\10\1\0\1\10\1\217"+
    "\24\10\30\0\1\10\1\0\25\10\1\220\30\0\1\10"+
    "\1\0\12\10\1\221\13\10\30\0\1\10\1\0\12\10"+
    "\1\222\13\10\30\0\1\10\1\0\12\10\1\223\13\10"+
    "\30\0\1\10\1\0\14\10\1\224\11\10\30\0\1\10"+
    "\1\0\15\10\1\225\10\10\30\0\1\10\1\0\4\10"+
    "\1\226\21\10\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4416];
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
    "\2\0\1\11\25\1\10\11\4\1\1\11\1\1\1\11"+
    "\1\1\1\11\3\1\3\11\1\0\1\1\1\11\1\1"+
    "\2\11\1\0\26\1\11\11\101\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[150];
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
    while (i < 132) {
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
        case 9: 
          { return ObjDTypes.OPEN_BRACE;
          }
        case 66: break;
        case 63: 
          { return ObjDTypes.W_IMPORT;
          }
        case 67: break;
        case 6: 
          { return ObjDTypes.MINUS;
          }
        case 68: break;
        case 48: 
          { return ObjDTypes.W_SELF;
          }
        case 69: break;
        case 43: 
          { return ObjDTypes.W_VAL;
          }
        case 70: break;
        case 59: 
          { return ObjDTypes.W_FALSE;
          }
        case 71: break;
        case 44: 
          { return ObjDTypes.W_VAR;
          }
        case 72: break;
        case 4: 
          { return ObjDTypes.MUL;
          }
        case 73: break;
        case 58: 
          { return ObjDTypes.TP_FLOAT;
          }
        case 74: break;
        case 5: 
          { return ObjDTypes.IDENT;
          }
        case 75: break;
        case 45: 
          { return ObjDTypes.W_DEF;
          }
        case 76: break;
        case 38: 
          { return ObjDTypes.PLUS_PLUS;
          }
        case 77: break;
        case 40: 
          { yybegin(YYINITIAL); return ObjDTypes.COMMENT;
          }
        case 78: break;
        case 25: 
          { return ObjDTypes.DIV_SET;
          }
        case 79: break;
        case 32: 
          { return ObjDTypes.MOREEQ;
          }
        case 80: break;
        case 52: 
          { return ObjDTypes.W_ENUM;
          }
        case 81: break;
        case 2: 
          { return TokenType.WHITE_SPACE;
          }
        case 82: break;
        case 24: 
          { yybegin(COMMENT_STATE); return ObjDTypes.COMMENT;
          }
        case 83: break;
        case 51: 
          { return ObjDTypes.W_ELSE;
          }
        case 84: break;
        case 14: 
          { return ObjDTypes.CLOSE_BRACKET;
          }
        case 85: break;
        case 22: 
          { return ObjDTypes.EXCLAMATION;
          }
        case 86: break;
        case 62: 
          { return ObjDTypes.W_STRUCT;
          }
        case 87: break;
        case 11: 
          { return ObjDTypes.OPEN_SQUARE_BRACKET;
          }
        case 88: break;
        case 13: 
          { return ObjDTypes.OPEN_BRACKET;
          }
        case 89: break;
        case 21: 
          { return ObjDTypes.WHAT;
          }
        case 90: break;
        case 39: 
          { return ObjDTypes.NOT_EQ;
          }
        case 91: break;
        case 17: 
          { return ObjDTypes.LESS;
          }
        case 92: break;
        case 49: 
          { return ObjDTypes.W_TRUE;
          }
        case 93: break;
        case 57: 
          { return ObjDTypes.W_TRAIT;
          }
        case 94: break;
        case 60: 
          { return ObjDTypes.W_STATIC;
          }
        case 95: break;
        case 29: 
          { return ObjDTypes.ARROW;
          }
        case 96: break;
        case 34: 
          { return ObjDTypes.EQ;
          }
        case 97: break;
        case 56: 
          { return ObjDTypes.W_CLASS;
          }
        case 98: break;
        case 31: 
          { return ObjDTypes.W_IF;
          }
        case 99: break;
        case 47: 
          { return ObjDTypes.W_STUB;
          }
        case 100: break;
        case 64: 
          { return ObjDTypes.W_PRIVATE;
          }
        case 101: break;
        case 19: 
          { return ObjDTypes.DOT;
          }
        case 102: break;
        case 3: 
          { return ObjDTypes.DIV;
          }
        case 103: break;
        case 28: 
          { return ObjDTypes.MINUS_MINUS;
          }
        case 104: break;
        case 33: 
          { return ObjDTypes.LESSEQ;
          }
        case 105: break;
        case 65: 
          { return ObjDTypes.W_EXTENDS;
          }
        case 106: break;
        case 55: 
          { return ObjDTypes.W_WEAK;
          }
        case 107: break;
        case 36: 
          { return ObjDTypes.AND;
          }
        case 108: break;
        case 23: 
          { return ObjDTypes.COMMENT;
          }
        case 109: break;
        case 12: 
          { return ObjDTypes.CLOSE_SQUARE_BRACKET;
          }
        case 110: break;
        case 15: 
          { return ObjDTypes.COMMA;
          }
        case 111: break;
        case 7: 
          { return ObjDTypes.INT;
          }
        case 112: break;
        case 1: 
          { return TokenType.BAD_CHARACTER;
          }
        case 113: break;
        case 50: 
          { return ObjDTypes.TP_VOID;
          }
        case 114: break;
        case 53: 
          { return ObjDTypes.TP_UINT;
          }
        case 115: break;
        case 27: 
          { return ObjDTypes.STRING;
          }
        case 116: break;
        case 16: 
          { return ObjDTypes.COLON;
          }
        case 117: break;
        case 61: 
          { return ObjDTypes.TP_STRING;
          }
        case 118: break;
        case 37: 
          { return ObjDTypes.PLUS_SET;
          }
        case 119: break;
        case 26: 
          { return ObjDTypes.MUL_SET;
          }
        case 120: break;
        case 18: 
          { return ObjDTypes.SET;
          }
        case 121: break;
        case 30: 
          { return ObjDTypes.MINUS_SET;
          }
        case 122: break;
        case 42: 
          { return ObjDTypes.TP_INT;
          }
        case 123: break;
        case 46: 
          { return ObjDTypes.W_NIL;
          }
        case 124: break;
        case 54: 
          { return ObjDTypes.TP_BOOL;
          }
        case 125: break;
        case 8: 
          { return ObjDTypes.MORE;
          }
        case 126: break;
        case 10: 
          { return ObjDTypes.CLOSE_BRACE;
          }
        case 127: break;
        case 20: 
          { return ObjDTypes.PLUS;
          }
        case 128: break;
        case 35: 
          { return ObjDTypes.OR;
          }
        case 129: break;
        case 41: 
          { return ObjDTypes.FLOAT;
          }
        case 130: break;
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

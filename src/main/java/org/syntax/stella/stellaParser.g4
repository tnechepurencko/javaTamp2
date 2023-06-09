// -*- Java -*- File generated by the BNF Converter (bnfc 2.9.4.1).

// Parser definition for use with ANTLRv4
parser grammar stellaParser;

options {
  tokenVocab = stellaLexer;
}


start_ListStellaIdent returns [ stella.Absyn.ListStellaIdent result ]
  : x=listStellaIdent EOF
    { $result = $x.result; }
  ;
start_Program returns [ stella.Absyn.Program result ]
  : x=program EOF
    { $result = $x.result; }
  ;
start_LanguageDecl returns [ stella.Absyn.LanguageDecl result ]
  : x=languageDecl EOF
    { $result = $x.result; }
  ;
start_Extension returns [ stella.Absyn.Extension result ]
  : x=extension EOF
    { $result = $x.result; }
  ;
start_ListExtensionName returns [ stella.Absyn.ListExtensionName result ]
  : x=listExtensionName EOF
    { $result = $x.result; }
  ;
start_ListExtension returns [ stella.Absyn.ListExtension result ]
  : x=listExtension EOF
    { $result = $x.result; }
  ;
start_Decl returns [ stella.Absyn.Decl result ]
  : x=decl EOF
    { $result = $x.result; }
  ;
start_ListDecl returns [ stella.Absyn.ListDecl result ]
  : x=listDecl EOF
    { $result = $x.result; }
  ;
start_LocalDecl returns [ stella.Absyn.LocalDecl result ]
  : x=localDecl EOF
    { $result = $x.result; }
  ;
start_ListLocalDecl returns [ stella.Absyn.ListLocalDecl result ]
  : x=listLocalDecl EOF
    { $result = $x.result; }
  ;
start_Annotation returns [ stella.Absyn.Annotation result ]
  : x=annotation EOF
    { $result = $x.result; }
  ;
start_ListAnnotation returns [ stella.Absyn.ListAnnotation result ]
  : x=listAnnotation EOF
    { $result = $x.result; }
  ;
start_ParamDecl returns [ stella.Absyn.ParamDecl result ]
  : x=paramDecl EOF
    { $result = $x.result; }
  ;
start_ListParamDecl returns [ stella.Absyn.ListParamDecl result ]
  : x=listParamDecl EOF
    { $result = $x.result; }
  ;
start_ReturnType returns [ stella.Absyn.ReturnType result ]
  : x=returnType EOF
    { $result = $x.result; }
  ;
start_ThrowType returns [ stella.Absyn.ThrowType result ]
  : x=throwType EOF
    { $result = $x.result; }
  ;
start_Expr returns [ stella.Absyn.Expr result ]
  : x=expr EOF
    { $result = $x.result; }
  ;
start_ListExpr returns [ stella.Absyn.ListExpr result ]
  : x=listExpr EOF
    { $result = $x.result; }
  ;
start_MatchCase returns [ stella.Absyn.MatchCase result ]
  : x=matchCase EOF
    { $result = $x.result; }
  ;
start_ListMatchCase returns [ stella.Absyn.ListMatchCase result ]
  : x=listMatchCase EOF
    { $result = $x.result; }
  ;
start_OptionalTyping returns [ stella.Absyn.OptionalTyping result ]
  : x=optionalTyping EOF
    { $result = $x.result; }
  ;
start_PatternData returns [ stella.Absyn.PatternData result ]
  : x=patternData EOF
    { $result = $x.result; }
  ;
start_ExprData returns [ stella.Absyn.ExprData result ]
  : x=exprData EOF
    { $result = $x.result; }
  ;
start_Pattern returns [ stella.Absyn.Pattern result ]
  : x=pattern EOF
    { $result = $x.result; }
  ;
start_ListPattern returns [ stella.Absyn.ListPattern result ]
  : x=listPattern EOF
    { $result = $x.result; }
  ;
start_LabelledPattern returns [ stella.Absyn.LabelledPattern result ]
  : x=labelledPattern EOF
    { $result = $x.result; }
  ;
start_ListLabelledPattern returns [ stella.Absyn.ListLabelledPattern result ]
  : x=listLabelledPattern EOF
    { $result = $x.result; }
  ;
start_Binding returns [ stella.Absyn.Binding result ]
  : x=binding EOF
    { $result = $x.result; }
  ;
start_ListBinding returns [ stella.Absyn.ListBinding result ]
  : x=listBinding EOF
    { $result = $x.result; }
  ;
start_Expr1 returns [ stella.Absyn.Expr result ]
  : x=expr1 EOF
    { $result = $x.result; }
  ;
start_Expr2 returns [ stella.Absyn.Expr result ]
  : x=expr2 EOF
    { $result = $x.result; }
  ;
start_Expr3 returns [ stella.Absyn.Expr result ]
  : x=expr3 EOF
    { $result = $x.result; }
  ;
start_Expr4 returns [ stella.Absyn.Expr result ]
  : x=expr4 EOF
    { $result = $x.result; }
  ;
start_Expr5 returns [ stella.Absyn.Expr result ]
  : x=expr5 EOF
    { $result = $x.result; }
  ;
start_Expr6 returns [ stella.Absyn.Expr result ]
  : x=expr6 EOF
    { $result = $x.result; }
  ;
start_Type returns [ stella.Absyn.Type result ]
  : x=type EOF
    { $result = $x.result; }
  ;
start_Type1 returns [ stella.Absyn.Type result ]
  : x=type1 EOF
    { $result = $x.result; }
  ;
start_Type2 returns [ stella.Absyn.Type result ]
  : x=type2 EOF
    { $result = $x.result; }
  ;
start_Type3 returns [ stella.Absyn.Type result ]
  : x=type3 EOF
    { $result = $x.result; }
  ;
start_ListType returns [ stella.Absyn.ListType result ]
  : x=listType EOF
    { $result = $x.result; }
  ;
start_VariantFieldType returns [ stella.Absyn.VariantFieldType result ]
  : x=variantFieldType EOF
    { $result = $x.result; }
  ;
start_ListVariantFieldType returns [ stella.Absyn.ListVariantFieldType result ]
  : x=listVariantFieldType EOF
    { $result = $x.result; }
  ;
start_RecordFieldType returns [ stella.Absyn.RecordFieldType result ]
  : x=recordFieldType EOF
    { $result = $x.result; }
  ;
start_ListRecordFieldType returns [ stella.Absyn.ListRecordFieldType result ]
  : x=listRecordFieldType EOF
    { $result = $x.result; }
  ;
start_Typing returns [ stella.Absyn.Typing result ]
  : x=typing EOF
    { $result = $x.result; }
  ;

listStellaIdent returns [ stella.Absyn.ListStellaIdent result ]
  :  /* empty */
    { $result = new stella.Absyn.ListStellaIdent(); }
  | p_2_1=StellaIdent
    { $result = new stella.Absyn.ListStellaIdent(); $result.addLast($p_2_1.getText()); }
  | p_3_1=StellaIdent Surrogate_id_SYMB_0 p_3_3=listStellaIdent
    { $result = $p_3_3.result; $result.addFirst($p_3_1.getText()); }
  ;
program returns [ stella.Absyn.Program result ]
  : p_1_1=languageDecl p_1_2=listExtension p_1_3=listDecl
    { $result = new stella.Absyn.AProgram($p_1_1.result,$p_1_2.result,$p_1_3.result); }
  ;
languageDecl returns [ stella.Absyn.LanguageDecl result ]
  : Surrogate_id_SYMB_45 Surrogate_id_SYMB_35 Surrogate_id_SYMB_1
    { $result = new stella.Absyn.LanguageCore(); }
  ;
extension returns [ stella.Absyn.Extension result ]
  : Surrogate_id_SYMB_37 Surrogate_id_SYMB_59 p_1_3=listExtensionName
    { $result = new stella.Absyn.AnExtension($p_1_3.result); }
  ;
listExtensionName returns [ stella.Absyn.ListExtensionName result ]
  :  /* empty */
    { $result = new stella.Absyn.ListExtensionName(); }
  | p_2_1=ExtensionName
    { $result = new stella.Absyn.ListExtensionName(); $result.addLast($p_2_1.getText()); }
  | p_3_1=ExtensionName Surrogate_id_SYMB_0 p_3_3=listExtensionName
    { $result = $p_3_3.result; $result.addFirst($p_3_1.getText()); }
  ;
listExtension returns [ stella.Absyn.ListExtension result ]
  :  /* empty */
    { $result = new stella.Absyn.ListExtension(); }
  | p_2_1=listExtension p_2_2=extension Surrogate_id_SYMB_1
    { $result = $p_2_1.result; $result.addLast($p_2_2.result); }
  ;
decl returns [ stella.Absyn.Decl result ]
  : p_1_1=listAnnotation Surrogate_id_SYMB_40 p_1_3=StellaIdent Surrogate_id_SYMB_2 p_1_5=listParamDecl Surrogate_id_SYMB_3 p_1_7=returnType p_1_8=throwType Surrogate_id_SYMB_4 p_1_10=listDecl Surrogate_id_SYMB_51 p_1_12=expr Surrogate_id_SYMB_1 Surrogate_id_SYMB_5
    { $result = new stella.Absyn.DeclFun($p_1_1.result,$p_1_3.getText(),$p_1_5.result,$p_1_7.result,$p_1_8.result,$p_1_10.result,$p_1_12.result); }
  | Surrogate_id_SYMB_56 p_2_2=StellaIdent Surrogate_id_SYMB_6 p_2_4=type
    { $result = new stella.Absyn.DeclTypeAlias($p_2_2.getText(),$p_2_4.result); }
  ;
listDecl returns [ stella.Absyn.ListDecl result ]
  :  /* empty */
    { $result = new stella.Absyn.ListDecl(); }
  | p_2_1=listDecl p_2_2=decl
    { $result = $p_2_1.result; $result.addLast($p_2_2.result); }
  ;
localDecl returns [ stella.Absyn.LocalDecl result ]
  : p_1_1=decl
    { $result = new stella.Absyn.ALocalDecl($p_1_1.result); }
  ;
listLocalDecl returns [ stella.Absyn.ListLocalDecl result ]
  :  /* empty */
    { $result = new stella.Absyn.ListLocalDecl(); }
  | p_2_1=listLocalDecl p_2_2=localDecl Surrogate_id_SYMB_1
    { $result = $p_2_1.result; $result.addLast($p_2_2.result); }
  ;
annotation returns [ stella.Absyn.Annotation result ]
  : Surrogate_id_SYMB_44
    { $result = new stella.Absyn.InlineAnnotation(); }
  ;
listAnnotation returns [ stella.Absyn.ListAnnotation result ]
  :  /* empty */
    { $result = new stella.Absyn.ListAnnotation(); }
  | p_2_1=listAnnotation p_2_2=annotation
    { $result = $p_2_1.result; $result.addLast($p_2_2.result); }
  ;
paramDecl returns [ stella.Absyn.ParamDecl result ]
  : p_1_1=StellaIdent Surrogate_id_SYMB_7 p_1_3=type
    { $result = new stella.Absyn.AParamDecl($p_1_1.getText(),$p_1_3.result); }
  ;
listParamDecl returns [ stella.Absyn.ListParamDecl result ]
  :  /* empty */
    { $result = new stella.Absyn.ListParamDecl(); }
  | p_2_1=paramDecl
    { $result = new stella.Absyn.ListParamDecl(); $result.addLast($p_2_1.result); }
  | p_3_1=paramDecl Surrogate_id_SYMB_0 p_3_3=listParamDecl
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
returnType returns [ stella.Absyn.ReturnType result ]
  :  /* empty */
    { $result = new stella.Absyn.NoReturnType(); }
  | Surrogate_id_SYMB_8 p_2_2=type
    { $result = new stella.Absyn.SomeReturnType($p_2_2.result); }
  ;
throwType returns [ stella.Absyn.ThrowType result ]
  :  /* empty */
    { $result = new stella.Absyn.NoThrowType(); }
  | Surrogate_id_SYMB_54 p_2_2=listType
    { $result = new stella.Absyn.SomeThrowType($p_2_2.result); }
  ;
expr returns [ stella.Absyn.Expr result ]
  : Surrogate_id_SYMB_42 p_1_2=expr Surrogate_id_SYMB_53 p_1_4=expr Surrogate_id_SYMB_36 p_1_6=expr
    { $result = new stella.Absyn.If($p_1_2.result,$p_1_4.result,$p_1_6.result); }
  | Surrogate_id_SYMB_46 p_2_2=StellaIdent Surrogate_id_SYMB_6 p_2_4=expr Surrogate_id_SYMB_43 p_2_6=expr
    { $result = new stella.Absyn.Let($p_2_2.getText(),$p_2_4.result,$p_2_6.result); }
  | p_3_1=expr1
    { $result = $p_3_1.result; }
  ;
listExpr returns [ stella.Absyn.ListExpr result ]
  :  /* empty */
    { $result = new stella.Absyn.ListExpr(); }
  | p_2_1=expr
    { $result = new stella.Absyn.ListExpr(); $result.addLast($p_2_1.result); }
  | p_3_1=expr Surrogate_id_SYMB_0 p_3_3=listExpr
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
matchCase returns [ stella.Absyn.MatchCase result ]
  : p_1_1=pattern Surrogate_id_SYMB_9 p_1_3=expr
    { $result = new stella.Absyn.AMatchCase($p_1_1.result,$p_1_3.result); }
  ;
listMatchCase returns [ stella.Absyn.ListMatchCase result ]
  :  /* empty */
    { $result = new stella.Absyn.ListMatchCase(); }
  | p_2_1=matchCase
    { $result = new stella.Absyn.ListMatchCase(); $result.addLast($p_2_1.result); }
  | p_3_1=matchCase Surrogate_id_SYMB_1 p_3_3=listMatchCase
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
optionalTyping returns [ stella.Absyn.OptionalTyping result ]
  :  /* empty */
    { $result = new stella.Absyn.NoTyping(); }
  | Surrogate_id_SYMB_7 p_2_2=type
    { $result = new stella.Absyn.SomeTyping($p_2_2.result); }
  ;
patternData returns [ stella.Absyn.PatternData result ]
  :  /* empty */
    { $result = new stella.Absyn.NoPatternData(); }
  | Surrogate_id_SYMB_6 p_2_2=pattern
    { $result = new stella.Absyn.SomePatternData($p_2_2.result); }
  ;
exprData returns [ stella.Absyn.ExprData result ]
  :  /* empty */
    { $result = new stella.Absyn.NoExprData(); }
  | Surrogate_id_SYMB_6 p_2_2=expr
    { $result = new stella.Absyn.SomeExprData($p_2_2.result); }
  ;
pattern returns [ stella.Absyn.Pattern result ]
  : Surrogate_id_SYMB_10 p_1_2=StellaIdent p_1_3=patternData Surrogate_id_SYMB_11
    { $result = new stella.Absyn.PatternVariant($p_1_2.getText(),$p_1_3.result); }
  | Surrogate_id_SYMB_4 p_2_2=listPattern Surrogate_id_SYMB_5
    { $result = new stella.Absyn.PatternTuple($p_2_2.result); }
  | Surrogate_id_SYMB_50 Surrogate_id_SYMB_4 p_3_3=listLabelledPattern Surrogate_id_SYMB_5
    { $result = new stella.Absyn.PatternRecord($p_3_3.result); }
  | Surrogate_id_SYMB_12 p_4_2=listPattern Surrogate_id_SYMB_13
    { $result = new stella.Absyn.PatternList($p_4_2.result); }
  | Surrogate_id_SYMB_34 Surrogate_id_SYMB_2 p_5_3=pattern Surrogate_id_SYMB_0 p_5_5=pattern Surrogate_id_SYMB_3
    { $result = new stella.Absyn.PatternCons($p_5_3.result,$p_5_5.result); }
  | Surrogate_id_SYMB_38
    { $result = new stella.Absyn.PatternFalse(); }
  | Surrogate_id_SYMB_55
    { $result = new stella.Absyn.PatternTrue(); }
  | p_8_1=INTEGER
    { $result = new stella.Absyn.PatternInt(Integer.parseInt($p_8_1.getText())); }
  | Surrogate_id_SYMB_52 Surrogate_id_SYMB_2 p_9_3=pattern Surrogate_id_SYMB_3
    { $result = new stella.Absyn.PatternSucc($p_9_3.result); }
  | p_10_1=StellaIdent
    { $result = new stella.Absyn.PatternVar($p_10_1.getText()); }
  | Surrogate_id_SYMB_2 p_11_2=pattern Surrogate_id_SYMB_3
    { $result = $p_11_2.result; }
  ;
listPattern returns [ stella.Absyn.ListPattern result ]
  :  /* empty */
    { $result = new stella.Absyn.ListPattern(); }
  | p_2_1=pattern
    { $result = new stella.Absyn.ListPattern(); $result.addLast($p_2_1.result); }
  | p_3_1=pattern Surrogate_id_SYMB_0 p_3_3=listPattern
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
labelledPattern returns [ stella.Absyn.LabelledPattern result ]
  : p_1_1=StellaIdent Surrogate_id_SYMB_6 p_1_3=pattern
    { $result = new stella.Absyn.ALabelledPattern($p_1_1.getText(),$p_1_3.result); }
  ;
listLabelledPattern returns [ stella.Absyn.ListLabelledPattern result ]
  :  /* empty */
    { $result = new stella.Absyn.ListLabelledPattern(); }
  | p_2_1=labelledPattern
    { $result = new stella.Absyn.ListLabelledPattern(); $result.addLast($p_2_1.result); }
  | p_3_1=labelledPattern Surrogate_id_SYMB_0 p_3_3=listLabelledPattern
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
binding returns [ stella.Absyn.Binding result ]
  : p_1_1=StellaIdent Surrogate_id_SYMB_6 p_1_3=expr
    { $result = new stella.Absyn.ABinding($p_1_1.getText(),$p_1_3.result); }
  ;
listBinding returns [ stella.Absyn.ListBinding result ]
  :  /* empty */
    { $result = new stella.Absyn.ListBinding(); }
  | p_2_1=binding
    { $result = new stella.Absyn.ListBinding(); $result.addLast($p_2_1.result); }
  | p_3_1=binding Surrogate_id_SYMB_0 p_3_3=listBinding
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
expr1 returns [ stella.Absyn.Expr result ]
  : p_1_1=expr2 Surrogate_id_SYMB_14 p_1_3=expr2
    { $result = new stella.Absyn.LessThan($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr2 Surrogate_id_SYMB_15 p_2_3=expr2
    { $result = new stella.Absyn.LessThanOrEqual($p_2_1.result,$p_2_3.result); }
  | p_3_1=expr2 Surrogate_id_SYMB_16 p_3_3=expr2
    { $result = new stella.Absyn.GreaterThan($p_3_1.result,$p_3_3.result); }
  | p_4_1=expr2 Surrogate_id_SYMB_17 p_4_3=expr2
    { $result = new stella.Absyn.GreaterThanOrEqual($p_4_1.result,$p_4_3.result); }
  | p_5_1=expr2 Surrogate_id_SYMB_18 p_5_3=expr2
    { $result = new stella.Absyn.Equal($p_5_1.result,$p_5_3.result); }
  | p_6_1=expr2 Surrogate_id_SYMB_19 p_6_3=expr2
    { $result = new stella.Absyn.NotEqual($p_6_1.result,$p_6_3.result); }
  | p_7_1=expr2
    { $result = $p_7_1.result; }
  ;
expr2 returns [ stella.Absyn.Expr result ]
  : p_1_1=expr2 Surrogate_id_SYMB_33 p_1_3=type
    { $result = new stella.Absyn.TypeAsc($p_1_1.result,$p_1_3.result); }
  | Surrogate_id_SYMB_40 Surrogate_id_SYMB_2 p_2_3=listParamDecl Surrogate_id_SYMB_3 Surrogate_id_SYMB_4 Surrogate_id_SYMB_51 p_2_7=expr Surrogate_id_SYMB_1 Surrogate_id_SYMB_5
    { $result = new stella.Absyn.Abstraction($p_2_3.result,$p_2_7.result); }
  | Surrogate_id_SYMB_4 p_3_2=listExpr Surrogate_id_SYMB_5
    { $result = new stella.Absyn.Tuple($p_3_2.result); }
  | Surrogate_id_SYMB_50 Surrogate_id_SYMB_4 p_4_3=listBinding Surrogate_id_SYMB_5
    { $result = new stella.Absyn.Record($p_4_3.result); }
  | Surrogate_id_SYMB_10 p_5_2=StellaIdent p_5_3=exprData Surrogate_id_SYMB_11
    { $result = new stella.Absyn.Variant($p_5_2.getText(),$p_5_3.result); }
  | Surrogate_id_SYMB_47 p_6_2=expr1 Surrogate_id_SYMB_4 p_6_4=listMatchCase Surrogate_id_SYMB_5
    { $result = new stella.Absyn.Match($p_6_2.result,$p_6_4.result); }
  | Surrogate_id_SYMB_12 p_7_2=listExpr Surrogate_id_SYMB_13
    { $result = new stella.Absyn.List($p_7_2.result); }
  | p_8_1=expr2 Surrogate_id_SYMB_20 p_8_3=expr3
    { $result = new stella.Absyn.Add($p_8_1.result,$p_8_3.result); }
  | p_9_1=expr2 Surrogate_id_SYMB_49 p_9_3=expr3
    { $result = new stella.Absyn.LogicOr($p_9_1.result,$p_9_3.result); }
  | p_10_1=expr3
    { $result = $p_10_1.result; }
  ;
expr3 returns [ stella.Absyn.Expr result ]
  : p_1_1=expr3 Surrogate_id_SYMB_21 p_1_3=expr4
    { $result = new stella.Absyn.Multiply($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr3 Surrogate_id_SYMB_32 p_2_3=expr4
    { $result = new stella.Absyn.LogicAnd($p_2_1.result,$p_2_3.result); }
  | p_3_1=expr4
    { $result = $p_3_1.result; }
  ;
expr4 returns [ stella.Absyn.Expr result ]
  : p_1_1=expr4 Surrogate_id_SYMB_2 p_1_3=listExpr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.Application($p_1_1.result,$p_1_3.result); }
  | p_2_1=expr5
    { $result = $p_2_1.result; }
  ;
expr5 returns [ stella.Absyn.Expr result ]
  : Surrogate_id_SYMB_34 Surrogate_id_SYMB_2 p_1_3=expr Surrogate_id_SYMB_0 p_1_5=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.ConsList($p_1_3.result,$p_1_5.result); }
  | Surrogate_id_SYMB_22 Surrogate_id_SYMB_2 p_2_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.Head($p_2_3.result); }
  | Surrogate_id_SYMB_23 Surrogate_id_SYMB_2 p_3_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.IsEmpty($p_3_3.result); }
  | Surrogate_id_SYMB_24 Surrogate_id_SYMB_2 p_4_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.Tail($p_4_3.result); }
  | Surrogate_id_SYMB_52 Surrogate_id_SYMB_2 p_5_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.Succ($p_5_3.result); }
  | Surrogate_id_SYMB_48 Surrogate_id_SYMB_2 p_6_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.LogicNot($p_6_3.result); }
  | Surrogate_id_SYMB_25 Surrogate_id_SYMB_2 p_7_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.Pred($p_7_3.result); }
  | Surrogate_id_SYMB_26 Surrogate_id_SYMB_2 p_8_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.IsZero($p_8_3.result); }
  | Surrogate_id_SYMB_39 Surrogate_id_SYMB_2 p_9_3=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.Fix($p_9_3.result); }
  | Surrogate_id_SYMB_27 Surrogate_id_SYMB_2 p_10_3=expr Surrogate_id_SYMB_0 p_10_5=expr Surrogate_id_SYMB_0 p_10_7=expr Surrogate_id_SYMB_3
    { $result = new stella.Absyn.NatRec($p_10_3.result,$p_10_5.result,$p_10_7.result); }
  | Surrogate_id_SYMB_41 Surrogate_id_SYMB_12 p_11_3=type Surrogate_id_SYMB_13 p_11_5=expr6
    { $result = new stella.Absyn.Fold($p_11_3.result,$p_11_5.result); }
  | Surrogate_id_SYMB_57 Surrogate_id_SYMB_12 p_12_3=type Surrogate_id_SYMB_13 p_12_5=expr6
    { $result = new stella.Absyn.Unfold($p_12_3.result,$p_12_5.result); }
  | p_13_1=expr6
    { $result = $p_13_1.result; }
  ;
expr6 returns [ stella.Absyn.Expr result ]
  : p_1_1=expr6 Surrogate_id_SYMB_28 p_1_3=StellaIdent
    { $result = new stella.Absyn.DotRecord($p_1_1.result,$p_1_3.getText()); }
  | p_2_1=expr6 Surrogate_id_SYMB_28 p_2_3=INTEGER
    { $result = new stella.Absyn.DotTuple($p_2_1.result,Integer.parseInt($p_2_3.getText())); }
  | Surrogate_id_SYMB_55
    { $result = new stella.Absyn.ConstTrue(); }
  | Surrogate_id_SYMB_38
    { $result = new stella.Absyn.ConstFalse(); }
  | p_5_1=INTEGER
    { $result = new stella.Absyn.ConstInt(Integer.parseInt($p_5_1.getText())); }
  | p_6_1=StellaIdent
    { $result = new stella.Absyn.Var($p_6_1.getText()); }
  | Surrogate_id_SYMB_2 p_7_2=expr Surrogate_id_SYMB_3
    { $result = $p_7_2.result; }
  ;
type returns [ stella.Absyn.Type result ]
  : Surrogate_id_SYMB_40 Surrogate_id_SYMB_2 p_1_3=listType Surrogate_id_SYMB_3 Surrogate_id_SYMB_8 p_1_6=type
    { $result = new stella.Absyn.TypeFun($p_1_3.result,$p_1_6.result); }
  | Surrogate_id_SYMB_60 p_2_2=StellaIdent Surrogate_id_SYMB_28 p_2_4=type
    { $result = new stella.Absyn.TypeRec($p_2_2.getText(),$p_2_4.result); }
  | p_3_1=type1
    { $result = $p_3_1.result; }
  ;
type1 returns [ stella.Absyn.Type result ]
  : p_1_1=type2 Surrogate_id_SYMB_20 p_1_3=type2
    { $result = new stella.Absyn.TypeSum($p_1_1.result,$p_1_3.result); }
  | p_2_1=type2
    { $result = $p_2_1.result; }
  ;
type2 returns [ stella.Absyn.Type result ]
  : Surrogate_id_SYMB_4 p_1_2=listType Surrogate_id_SYMB_5
    { $result = new stella.Absyn.TypeTuple($p_1_2.result); }
  | Surrogate_id_SYMB_50 Surrogate_id_SYMB_4 p_2_3=listRecordFieldType Surrogate_id_SYMB_5
    { $result = new stella.Absyn.TypeRecord($p_2_3.result); }
  | Surrogate_id_SYMB_58 Surrogate_id_SYMB_10 p_3_3=listVariantFieldType Surrogate_id_SYMB_11
    { $result = new stella.Absyn.TypeVariant($p_3_3.result); }
  | Surrogate_id_SYMB_12 p_4_2=type Surrogate_id_SYMB_13
    { $result = new stella.Absyn.TypeList($p_4_2.result); }
  | p_5_1=type3
    { $result = $p_5_1.result; }
  ;
type3 returns [ stella.Absyn.Type result ]
  : Surrogate_id_SYMB_29
    { $result = new stella.Absyn.TypeBool(); }
  | Surrogate_id_SYMB_30
    { $result = new stella.Absyn.TypeNat(); }
  | Surrogate_id_SYMB_31
    { $result = new stella.Absyn.TypeUnit(); }
  | p_4_1=StellaIdent
    { $result = new stella.Absyn.TypeVar($p_4_1.getText()); }
  | Surrogate_id_SYMB_2 p_5_2=type Surrogate_id_SYMB_3
    { $result = $p_5_2.result; }
  ;
listType returns [ stella.Absyn.ListType result ]
  :  /* empty */
    { $result = new stella.Absyn.ListType(); }
  | p_2_1=type
    { $result = new stella.Absyn.ListType(); $result.addLast($p_2_1.result); }
  | p_3_1=type Surrogate_id_SYMB_0 p_3_3=listType
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
variantFieldType returns [ stella.Absyn.VariantFieldType result ]
  : p_1_1=StellaIdent p_1_2=optionalTyping
    { $result = new stella.Absyn.AVariantFieldType($p_1_1.getText(),$p_1_2.result); }
  ;
listVariantFieldType returns [ stella.Absyn.ListVariantFieldType result ]
  :  /* empty */
    { $result = new stella.Absyn.ListVariantFieldType(); }
  | p_2_1=variantFieldType
    { $result = new stella.Absyn.ListVariantFieldType(); $result.addLast($p_2_1.result); }
  | p_3_1=variantFieldType Surrogate_id_SYMB_0 p_3_3=listVariantFieldType
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
recordFieldType returns [ stella.Absyn.RecordFieldType result ]
  : p_1_1=StellaIdent Surrogate_id_SYMB_7 p_1_3=type
    { $result = new stella.Absyn.ARecordFieldType($p_1_1.getText(),$p_1_3.result); }
  ;
listRecordFieldType returns [ stella.Absyn.ListRecordFieldType result ]
  :  /* empty */
    { $result = new stella.Absyn.ListRecordFieldType(); }
  | p_2_1=recordFieldType
    { $result = new stella.Absyn.ListRecordFieldType(); $result.addLast($p_2_1.result); }
  | p_3_1=recordFieldType Surrogate_id_SYMB_0 p_3_3=listRecordFieldType
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
typing returns [ stella.Absyn.Typing result ]
  : p_1_1=expr Surrogate_id_SYMB_7 p_1_3=type
    { $result = new stella.Absyn.ATyping($p_1_1.result,$p_1_3.result); }
  ;


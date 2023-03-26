// File generated by the BNF Converter (bnfc 2.9.4.1).

package org.syntax.stella;
import org.syntax.stella.Absyn.*;

/*** Visitor Design Pattern Skeleton. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements org.syntax.stella.Absyn.Program.Visitor<R,A>
  {
    public String checkProgram(AProgram aProgram) {
      ProgramVisitor<String, String> programVisitor = new ProgramVisitor<>();
      return programVisitor.visit(aProgram, "someArgs");
    }

    public R visit(org.syntax.stella.Absyn.AProgram p, A arg)
    { /* Code for AProgram goes here */
      p.languagedecl_.accept(new LanguageDeclVisitor<R,A>(), arg);
      for (org.syntax.stella.Absyn.Extension x: p.listextension_) {
        x.accept(new ExtensionVisitor<R,A>(), arg);
      }
      for (org.syntax.stella.Absyn.Decl x: p.listdecl_) {
        x.accept(new DeclVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class LanguageDeclVisitor<R,A> implements org.syntax.stella.Absyn.LanguageDecl.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.LanguageCore p, A arg)
    { /* Code for LanguageCore goes here */
      return null;
    }
  }
  public class ExtensionVisitor<R,A> implements org.syntax.stella.Absyn.Extension.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.AnExtension p, A arg)
    { /* Code for AnExtension goes here */
      for (String x: p.listextensionname_) {
        //x;
      }
      return null;
    }
  }
  public class DeclVisitor<R,A> implements org.syntax.stella.Absyn.Decl.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.DeclFun p, A arg)
    { /* Code for DeclFun goes here */
      for (org.syntax.stella.Absyn.Annotation x: p.listannotation_) {
        x.accept(new AnnotationVisitor<R,A>(), arg);
      }
      //p.stellaident_;
      for (org.syntax.stella.Absyn.ParamDecl x: p.listparamdecl_) {
        x.accept(new ParamDeclVisitor<R,A>(), arg);
      }
      p.returntype_.accept(new ReturnTypeVisitor<R,A>(), arg);
      p.throwtype_.accept(new ThrowTypeVisitor<R,A>(), arg);
      for (org.syntax.stella.Absyn.Decl x: p.listdecl_) {
        x.accept(new DeclVisitor<R,A>(), arg);
      }
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.DeclTypeAlias p, A arg)
    { /* Code for DeclTypeAlias goes here */
      //p.stellaident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class LocalDeclVisitor<R,A> implements org.syntax.stella.Absyn.LocalDecl.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.ALocalDecl p, A arg)
    { /* Code for ALocalDecl goes here */
      p.decl_.accept(new DeclVisitor<R,A>(), arg);
      return null;
    }
  }
  public class AnnotationVisitor<R,A> implements org.syntax.stella.Absyn.Annotation.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.InlineAnnotation p, A arg)
    { /* Code for InlineAnnotation goes here */
      return null;
    }
  }
  public class ParamDeclVisitor<R,A> implements org.syntax.stella.Absyn.ParamDecl.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.AParamDecl p, A arg)
    { /* Code for AParamDecl goes here */
      //p.stellaident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ReturnTypeVisitor<R,A> implements org.syntax.stella.Absyn.ReturnType.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.NoReturnType p, A arg)
    { /* Code for NoReturnType goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.SomeReturnType p, A arg)
    { /* Code for SomeReturnType goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ThrowTypeVisitor<R,A> implements org.syntax.stella.Absyn.ThrowType.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.NoThrowType p, A arg)
    { /* Code for NoThrowType goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.SomeThrowType p, A arg)
    { /* Code for SomeThrowType goes here */
      for (org.syntax.stella.Absyn.Type x: p.listtype_) {
        x.accept(new TypeVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class ExprVisitor<R,A> implements org.syntax.stella.Absyn.Expr.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.If p, A arg)
    { /* Code for If goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Let p, A arg)
    { /* Code for Let goes here */
      //p.stellaident_;
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.LessThan p, A arg)
    { /* Code for LessThan goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.LessThanOrEqual p, A arg)
    { /* Code for LessThanOrEqual goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.GreaterThan p, A arg)
    { /* Code for GreaterThan goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.GreaterThanOrEqual p, A arg)
    { /* Code for GreaterThanOrEqual goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Equal p, A arg)
    { /* Code for Equal goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.NotEqual p, A arg)
    { /* Code for NotEqual goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeAsc p, A arg)
    { /* Code for TypeAsc goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Abstraction p, A arg)
    { /* Code for Abstraction goes here */
      for (org.syntax.stella.Absyn.ParamDecl x: p.listparamdecl_) {
        x.accept(new ParamDeclVisitor<R,A>(), arg);
      }
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Tuple p, A arg)
    { /* Code for Tuple goes here */
      for (org.syntax.stella.Absyn.Expr x: p.listexpr_) {
        x.accept(new ExprVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Record p, A arg)
    { /* Code for Record goes here */
      for (org.syntax.stella.Absyn.Binding x: p.listbinding_) {
        x.accept(new BindingVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Variant p, A arg)
    { /* Code for Variant goes here */
      //p.stellaident_;
      p.exprdata_.accept(new ExprDataVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Match p, A arg)
    { /* Code for Match goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      for (org.syntax.stella.Absyn.MatchCase x: p.listmatchcase_) {
        x.accept(new MatchCaseVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.List p, A arg)
    { /* Code for List goes here */
      for (org.syntax.stella.Absyn.Expr x: p.listexpr_) {
        x.accept(new ExprVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Add p, A arg)
    { /* Code for Add goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.LogicOr p, A arg)
    { /* Code for LogicOr goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Multiply p, A arg)
    { /* Code for Multiply goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.LogicAnd p, A arg)
    { /* Code for LogicAnd goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Application p, A arg)
    { /* Code for Application goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      for (org.syntax.stella.Absyn.Expr x: p.listexpr_) {
        x.accept(new ExprVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.ConsList p, A arg)
    { /* Code for ConsList goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Head p, A arg)
    { /* Code for Head goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.IsEmpty p, A arg)
    { /* Code for IsEmpty goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Tail p, A arg)
    { /* Code for Tail goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Succ p, A arg)
    { /* Code for Succ goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.LogicNot p, A arg)
    { /* Code for LogicNot goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Pred p, A arg)
    { /* Code for Pred goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.IsZero p, A arg)
    { /* Code for IsZero goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Fix p, A arg)
    { /* Code for Fix goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.NatRec p, A arg)
    { /* Code for NatRec goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Fold p, A arg)
    { /* Code for Fold goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Unfold p, A arg)
    { /* Code for Unfold goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.DotRecord p, A arg)
    { /* Code for DotRecord goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      //p.stellaident_;
      return null;
    }
    public R visit(org.syntax.stella.Absyn.DotTuple p, A arg)
    { /* Code for DotTuple goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      //p.integer_;
      return null;
    }
    public R visit(org.syntax.stella.Absyn.ConstTrue p, A arg)
    { /* Code for ConstTrue goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.ConstFalse p, A arg)
    { /* Code for ConstFalse goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.ConstInt p, A arg)
    { /* Code for ConstInt goes here */
      //p.integer_;
      return null;
    }
    public R visit(org.syntax.stella.Absyn.Var p, A arg)
    { /* Code for Var goes here */
      //p.stellaident_;
      return null;
    }
  }
  public class MatchCaseVisitor<R,A> implements org.syntax.stella.Absyn.MatchCase.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.AMatchCase p, A arg)
    { /* Code for AMatchCase goes here */
      p.pattern_.accept(new PatternVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class OptionalTypingVisitor<R,A> implements org.syntax.stella.Absyn.OptionalTyping.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.NoTyping p, A arg)
    { /* Code for NoTyping goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.SomeTyping p, A arg)
    { /* Code for SomeTyping goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PatternDataVisitor<R,A> implements org.syntax.stella.Absyn.PatternData.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.NoPatternData p, A arg)
    { /* Code for NoPatternData goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.SomePatternData p, A arg)
    { /* Code for SomePatternData goes here */
      p.pattern_.accept(new PatternVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ExprDataVisitor<R,A> implements org.syntax.stella.Absyn.ExprData.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.NoExprData p, A arg)
    { /* Code for NoExprData goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.SomeExprData p, A arg)
    { /* Code for SomeExprData goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PatternVisitor<R,A> implements org.syntax.stella.Absyn.Pattern.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.PatternVariant p, A arg)
    { /* Code for PatternVariant goes here */
      //p.stellaident_;
      p.patterndata_.accept(new PatternDataVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternTuple p, A arg)
    { /* Code for PatternTuple goes here */
      for (org.syntax.stella.Absyn.Pattern x: p.listpattern_) {
        x.accept(new PatternVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternRecord p, A arg)
    { /* Code for PatternRecord goes here */
      for (org.syntax.stella.Absyn.LabelledPattern x: p.listlabelledpattern_) {
        x.accept(new LabelledPatternVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternList p, A arg)
    { /* Code for PatternList goes here */
      for (org.syntax.stella.Absyn.Pattern x: p.listpattern_) {
        x.accept(new PatternVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternCons p, A arg)
    { /* Code for PatternCons goes here */
      p.pattern_1.accept(new PatternVisitor<R,A>(), arg);
      p.pattern_2.accept(new PatternVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternFalse p, A arg)
    { /* Code for PatternFalse goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternTrue p, A arg)
    { /* Code for PatternTrue goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternInt p, A arg)
    { /* Code for PatternInt goes here */
      //p.integer_;
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternSucc p, A arg)
    { /* Code for PatternSucc goes here */
      p.pattern_.accept(new PatternVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.PatternVar p, A arg)
    { /* Code for PatternVar goes here */
      //p.stellaident_;
      return null;
    }
  }
  public class LabelledPatternVisitor<R,A> implements org.syntax.stella.Absyn.LabelledPattern.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.ALabelledPattern p, A arg)
    { /* Code for ALabelledPattern goes here */
      //p.stellaident_;
      p.pattern_.accept(new PatternVisitor<R,A>(), arg);
      return null;
    }
  }
  public class BindingVisitor<R,A> implements org.syntax.stella.Absyn.Binding.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.ABinding p, A arg)
    { /* Code for ABinding goes here */
      //p.stellaident_;
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypeVisitor<R,A> implements org.syntax.stella.Absyn.Type.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.TypeFun p, A arg)
    { /* Code for TypeFun goes here */
      for (org.syntax.stella.Absyn.Type x: p.listtype_) {
        x.accept(new TypeVisitor<R,A>(), arg);
      }
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeRec p, A arg)
    { /* Code for TypeRec goes here */
      //p.stellaident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeSum p, A arg)
    { /* Code for TypeSum goes here */
      p.type_1.accept(new TypeVisitor<R,A>(), arg);
      p.type_2.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeTuple p, A arg)
    { /* Code for TypeTuple goes here */
      for (org.syntax.stella.Absyn.Type x: p.listtype_) {
        x.accept(new TypeVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeRecord p, A arg)
    { /* Code for TypeRecord goes here */
      for (org.syntax.stella.Absyn.RecordFieldType x: p.listrecordfieldtype_) {
        x.accept(new RecordFieldTypeVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeVariant p, A arg)
    { /* Code for TypeVariant goes here */
      for (org.syntax.stella.Absyn.VariantFieldType x: p.listvariantfieldtype_) {
        x.accept(new VariantFieldTypeVisitor<R,A>(), arg);
      }
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeList p, A arg)
    { /* Code for TypeList goes here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeBool p, A arg)
    { /* Code for TypeBool goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeNat p, A arg)
    { /* Code for TypeNat goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeUnit p, A arg)
    { /* Code for TypeUnit goes here */
      return null;
    }
    public R visit(org.syntax.stella.Absyn.TypeVar p, A arg)
    { /* Code for TypeVar goes here */
      //p.stellaident_;
      return null;
    }
  }
  public class VariantFieldTypeVisitor<R,A> implements org.syntax.stella.Absyn.VariantFieldType.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.AVariantFieldType p, A arg)
    { /* Code for AVariantFieldType goes here */
      //p.stellaident_;
      p.optionaltyping_.accept(new OptionalTypingVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RecordFieldTypeVisitor<R,A> implements org.syntax.stella.Absyn.RecordFieldType.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.ARecordFieldType p, A arg)
    { /* Code for ARecordFieldType goes here */
      //p.stellaident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypingVisitor<R,A> implements org.syntax.stella.Absyn.Typing.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.ATyping p, A arg)
    { /* Code for ATyping goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
}

// File generated by the BNF Converter (bnfc 2.9.4.1).

package org.stella.typecheck;

import org.antlr.v4.runtime.misc.Pair;
import org.syntax.stella.Absyn.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*** Visitor Design Pattern for TypeCheck. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitTypeCheck
{
  HashMap<String, Type> params;
  Stack<Expr> callsVars;
  Queue<Pair<String, Type>> abstractionParams;
  HashMap<String, Pair<String, Type>> functions;
//  LinkedList<String> globalParams;
  HashMap<String, LinkedList<Type>> globalParams;

  public VisitTypeCheck() {
    this.params = new HashMap<>();
    this.callsVars = new Stack<>();
    this.abstractionParams = new LinkedList<>();
    this.functions = new HashMap<>();
    this.globalParams = new HashMap<>();
  }
  public class ProgramVisitor<R,A> implements org.syntax.stella.Absyn.Program.Visitor<R,A>
  {
    public R visit(org.syntax.stella.Absyn.AProgram p, A arg)
    { /* Code for AProgram goes here */
      p.languagedecl_.accept(new LanguageDeclVisitor<R,A>(), arg); // TODO check language core
      for (org.syntax.stella.Absyn.Extension x: p.listextension_) {
        x.accept(new ExtensionVisitor<R,A>(), arg);
      }
      for (org.syntax.stella.Absyn.Decl x: p.listdecl_) {
        var res = x.accept(new DeclVisitor<R,A>(), arg);
        if (res != null) {
          return res;
        }

        if (x instanceof DeclFun) {
          AParamDecl apd = (AParamDecl) ((DeclFun) x).listparamdecl_.get(0);
          Pair parameters = new Pair(apd.stellaident_, apd.type_);
          functions.put(((DeclFun) x).stellaident_, parameters);
        }
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
    public R checkNatRec(org.syntax.stella.Absyn.NatRec p, Type expectedType) {
//      Abstraction expr = (Abstraction) p.expr_3;
//      Application app = (Application) ((Abstraction) expr.expr_).expr_;
//      LinkedList<Type> funReturn = globalParams.get(((Var) app.expr_).stellaident_);
//      app = (Application) app.listexpr_.get(0);
      return null;
    }

    public R checkFunctionReturn(org.syntax.stella.Absyn.DeclFun p, A arg) {
      LinkedList<Type> localReturn = new LinkedList<>();
      AParamDecl var = (AParamDecl) p.listparamdecl_.get(0);
      Pair<String, Type> localVar = new Pair<>(var.stellaident_, var.type_);

      if (p.returntype_ instanceof SomeReturnType) {
        Type type = ((SomeReturnType) p.returntype_).type_;
        localReturn.add(type);
        while (type instanceof TypeFun) {
          type = ((TypeFun) type).type_;
          localReturn.add(type);
        }

        globalParams.put(p.stellaident_, new LinkedList<>(localReturn));

        Expr expr = p.expr_;
        while (!localReturn.isEmpty()) {
          type = localReturn.remove();
          if (expr instanceof Abstraction && type instanceof TypeFun) {
            expr = ((Abstraction) expr).expr_;
          } else if (expr instanceof Application) {
            expr = ((Application) expr).expr_;
          } else if (expr instanceof NatRec && (type instanceof TypeNat || type instanceof TypeBool)) {
//            return null;
            return checkNatRec((NatRec) expr, type);
          } else if (expr instanceof Succ && type instanceof TypeNat) {
            return null;
          } else if (expr instanceof If && type instanceof TypeBool) {
            return null;
          } else if (expr instanceof Var) {
            if (!(((Var) expr).stellaident_.equals(localVar.a)) && !(globalParams.containsKey(((Var) expr).stellaident_))) {
              return (R) ("TypeError in DeclVisitor.checkFunctionReturn(): unknown variable" + ((Var) expr).stellaident_);
            }
          } else {
            return (R) ("TypeError in DeclVisitor.checkFunctionReturn(): expected " + type.getClass() + ", got " + expr.getClass());
          }
        }
      }
      return null;
    }

    public R visit(org.syntax.stella.Absyn.DeclFun p, A arg)
    { /* Code for DeclFun goes here */
      System.out.println("Visiting declaration of function " + p.stellaident_);

      var res = checkFunctionReturn(p, null);
      if (res != null) {
        return res;
      }

      // TODO CHECK PARAMS
//      HashMap<String, Type> params = new HashMap<>();
      for (org.syntax.stella.Absyn.ParamDecl x: p.listparamdecl_) {
        AParamDecl s = (AParamDecl) x;
        params.put(((AParamDecl) x).stellaident_, ((AParamDecl) x).type_);
      }

      if (p.returntype_ instanceof SomeReturnType) {
        SomeReturnType someReturnType = (SomeReturnType) p.returntype_;
        if (someReturnType.type_ instanceof TypeFun && !(p.expr_ instanceof Abstraction) && !(p.expr_ instanceof Var)) { // TODO CHECK TYPE OF VAR
          return (R) ("TypeError in DeclVisitor.visit(): expected Abstraction, got " + p.expr_.getClass());
        } else if (someReturnType.type_ instanceof TypeNat) {
          if (!(p.expr_ instanceof NatRec) && !(p.expr_ instanceof Succ) && !(p.expr_ instanceof Var) && !(p.expr_ instanceof Application)) { // TODO maybe not NatRec but ConstInt // TODO CHECK TYPE OF VAR
            if (p.expr_ instanceof Application) {// TODO CHECK TYPE OF APP // TODO CHECK TYPE OF VAR
              return (R) ("TypeError in DeclVisitor.visit(): expected NatRec, got " + p.expr_.getClass());
            }
          }
        }
      }

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
      res = p.expr_.accept(new ExprVisitor<R,A>(), arg);
      if (res != null) {
        return res;
      }
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
      var res = p.expr_1.accept(new ExprVisitor<R,A>(), arg); // TODO if not bool
      if (res != null) {
        return res;
      }
      res = p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      if (res != null) {
        return res;
      }
      res = p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      if (res != null) {
        return res;
      }
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
//      HashMap<String, Type> tempParams = new HashMap<>();
      for (org.syntax.stella.Absyn.ParamDecl x: p.listparamdecl_) {
        AParamDecl s = (AParamDecl) x;
        abstractionParams.add(new Pair<>(s.stellaident_, s.type_));
//        tempParams.put(((AParamDecl) x).stellaident_, ((AParamDecl) x).type_);
        x.accept(new ParamDeclVisitor<R,A>(), arg);
      }

      if (p.expr_ instanceof Application && ((Application) p.expr_).expr_ instanceof Var) {
        Var v = (Var) ((Application) p.expr_).expr_;
        for (var pair:abstractionParams) {
          if (pair.a.equals(v.stellaident_) && !(pair.b instanceof TypeFun)) {
            return (R) ("TypeError in DeclVisitor.visit(): expected TypeFun, got " + pair.b.getClass());
          }
        }
      }

//      abstractionParams.push(tempParams);

      var res = p.expr_.accept(new ExprVisitor<R,A>(), arg);
      if (res != null) {
        return res;
      } else if (!callsVars.empty()) {
        var cv = callsVars.peek();
        var ap = abstractionParams.peek();
        if (ap.b instanceof TypeNat && !(cv instanceof ConstInt) && !(cv instanceof Var)) { // TODO checkvar
          return (R) ("TypeError in DeclVisitor.visit(): expected ConstInt, got " + cv.getClass());
        } else if (ap.b instanceof TypeBool && !((cv instanceof ConstTrue) || (cv instanceof ConstFalse))) {
          if (cv instanceof Abstraction && !(((Abstraction) cv).expr_ instanceof If)) {
            return (R) ("TypeError in DeclVisitor.visit(): expected TypeBool, got " + cv.getClass());
          }
        }
      }

      abstractionParams.remove();
      if (!callsVars.empty()) {
        callsVars.pop();
      }
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

    public void addParams(org.syntax.stella.Absyn.Application p) {
      Expr expr = p.listexpr_.get(0);
      if (expr instanceof Abstraction) {
        AParamDecl apd = (AParamDecl) ((Abstraction) expr).listparamdecl_.get(0);
        params.put(apd.stellaident_, apd.type_);
      }
    }

    public R visit(org.syntax.stella.Absyn.Application p, A arg)
    { /* Code for Application goes here */
      callsVars.push(p.listexpr_.get(0));
      addParams(p);

      if (p.expr_ instanceof Var) {
        String name = ((Var)p.expr_).stellaident_;
        if (params.containsKey(name) && !(params.get(name) instanceof TypeFun)) { //&& !(params.get(name) instanceof TypeFun)
          return (R) ("TypeError in DeclVisitor.visit(): expected TypeFun, got " + params.get(name).getClass());
        }
      } else if (p.expr_ instanceof Succ) {
        return (R) ("TypeError in DeclVisitor.visit(): expected TypeFun, got " + p.expr_.getClass());
      }

      if (p.expr_ instanceof Var) {
        if (functions.containsKey(((Var)p.expr_).stellaident_)) {
          Type type = functions.get(((Var)p.expr_).stellaident_).b;
          if (type instanceof TypeFun) {
            var argOfInnerFun = ((TypeFun) type).listtype_.get(0);
            if (p.listexpr_.get(0) instanceof Abstraction) {
              if (((Abstraction)p.listexpr_.get(0)).listparamdecl_.get(0) instanceof AParamDecl) {
                AParamDecl apd = (AParamDecl) ((Abstraction)p.listexpr_.get(0)).listparamdecl_.get(0);
                if (apd.type_.getClass() != argOfInnerFun.getClass()) {
                  String ret = "TypeError in DeclVisitor.visit(): expected" + apd.type_.getClass() + ", got" + argOfInnerFun.getClass();
                  return (R) (ret);
                }
              }
            }
          }
        }
      }

      var res = p.expr_.accept(new ExprVisitor<R,A>(), arg);
      if (res != null) {
        return res;
      } else if (p.expr_ instanceof Abstraction && callsVars.size() != 0) {
        return (R) ("TypeError in DeclVisitor.visit(): expected TypeFun as a return type");
      }

      for (org.syntax.stella.Absyn.Expr x: p.listexpr_) {
        res = x.accept(new ExprVisitor<R,A>(), arg);
        if (res != null) {
          return res;
        }
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
      if (!(p.expr_ instanceof ConstInt) && !(p.expr_ instanceof Succ) && !(p.expr_ instanceof Var)) { // TODO CHECK TYPE OF VAR
        if (p.expr_ instanceof If) {
          If ifExpr = (If) p.expr_;
          if (!(ifExpr.expr_2 instanceof Succ) && !(ifExpr.expr_2 instanceof ConstInt)) {
            return (R) ("TypeError in ExprVisitor.visit(): expected ConstInt, got " + ifExpr.expr_2.getClass());
          } else if (!(ifExpr.expr_3 instanceof Succ) && !(ifExpr.expr_3 instanceof ConstInt)) {
            return (R) ("TypeError in ExprVisitor.visit(): expected ConstInt, got " + ifExpr.expr_2.getClass());
          }
        } else {
          return (R) ("TypeError in ExprVisitor.visit(): expected ConstInt, got " + p.expr_.getClass());
        }
      }
      var res = p.expr_.accept(new ExprVisitor<R,A>(), arg);
      if (res != null) {
        return res;
      }
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
      if (!params.containsKey(p.stellaident_) && !globalParams.containsKey(p.stellaident_)) {
        return (R) ("TypeError in ExprVisitor.visit(): unknown variable " + p.stellaident_);
      }
//      if (functions.containsKey(p.stellaident_)) {
//        Type type = functions.get(p.stellaident_).b;
//        if (type instanceof TypeFun) {
//          var argOfInnerFun = ((TypeFun) type).listtype_.get(0);
//          if (!(p.))
//        }
//
//      }
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

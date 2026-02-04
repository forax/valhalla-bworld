import java.util.List;
import java.util.Map;

public sealed interface Expr {
  int lineNumber();

  sealed interface Statement {
    // maker interface for expressions that return void
  }

  record Block(List<Expr>! exprs, int lineNumber) implements Expr, Statement {
    public Block {
      lineNumber = exprs.stream().mapToInt(Expr::lineNumber).findFirst().orElse(lineNumber);
    }
  }

  record FieldAccess(Expr! receiver, String! name, int lineNumber) implements Expr { }

  record FieldAssignment(Expr! receiver, String! name, Expr! expr, int lineNumber) implements Expr, Statement { }

  record Fun(String! name, List<String>! parameters, boolean toplevel, Block! body, int lineNumber) implements Expr { }

  record Call(Expr! qualifier, List<Expr>! args, int lineNumber) implements Expr { }

  record If(Expr! condition, Block! trueBlock, Block! falseBlock, int lineNumber) implements Expr, Statement { }

  record Literal(Object! value, int lineNumber) implements Expr {
    @Override
    public String toString() {
      return value.toString();
    }
  }

  record Identifier(String! name, int lineNumber) implements Expr { }

  record VarAssignment(String! name, Expr! expr, boolean declaration, int lineNumber) implements Expr, Statement { }

  record MethodCall(Expr! receiver, String! name, List<Expr>! args, int lineNumber) implements Expr { }

  record ObjectLiteral(Map<String, Expr>! initMap, int lineNumber) implements Expr { }

  record Return(Expr! expr, int lineNumber) implements Expr, Statement { }
}

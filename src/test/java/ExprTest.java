import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ExprTest {

  @Test
  @DisplayName("Block should throw NPE when exprs is null")
  public void blockWithNullExprs() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.Block(null, 1);
    });
  }

  @Test
  @DisplayName("FieldAccess should throw NPE when receiver is null")
  public void fieldAccessWithNullReceiver() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.FieldAccess(null, "field", 1);
    });
  }

  @Test
  @DisplayName("FieldAccess should throw NPE when name is null")
  public void fieldAccessWithNullName() {
    Expr.Literal receiver = new Expr.Literal("obj", 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.FieldAccess(receiver, null, 1);
    });
  }

  @Test
  @DisplayName("FieldAssignment should throw NPE when receiver is null")
  public void fieldAssignmentWithNullReceiver() {
    Expr.Literal value = new Expr.Literal(42, 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.FieldAssignment(null, "field", value, 1);
    });
  }

  @Test
  @DisplayName("FieldAssignment should throw NPE when name is null")
  public void fieldAssignmentWithNullName() {
    Expr.Literal receiver = new Expr.Literal("obj", 1);
    Expr.Literal value = new Expr.Literal(42, 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.FieldAssignment(receiver, null, value, 1);
    });
  }

  @Test
  @DisplayName("FieldAssignment should throw NPE when expr is null")
  public void fieldAssignmentWithNullExpr() {
    Expr.Literal receiver = new Expr.Literal("obj", 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.FieldAssignment(receiver, "field", null, 1);
    });
  }

  @Test
  @DisplayName("Fun should throw NPE when name is null")
  public void funWithNullName() {
    Expr.Block body = new Expr.Block(List.of(), 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.Fun(null, List.of(), false, body, 1);
    });
  }

  @Test
  @DisplayName("Fun should throw NPE when parameters is null")
  public void funWithNullParameters() {
    Expr.Block body = new Expr.Block(List.of(), 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.Fun("func", null, false, body, 1);
    });
  }

  @Test
  @DisplayName("Fun should throw NPE when body is null")
  public void funWithNullBody() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.Fun("func", List.of(), false, null, 1);
    });
  }

  @Test
  @DisplayName("Call should throw NPE when qualifier is null")
  public void callWithNullQualifier() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.Call(null, List.of(), 1);
    });
  }

  @Test
  @DisplayName("Call should throw NPE when args is null")
  public void callWithNullArgs() {
    Expr.Identifier qualifier = new Expr.Identifier("func", 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.Call(qualifier, null, 1);
    });
  }

  @Test
  @DisplayName("If should throw NPE when condition is null")
  public void ifWithNullCondition() {
    Expr.Block trueBlock = new Expr.Block(List.of(), 1);
    Expr.Block falseBlock = new Expr.Block(List.of(), 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.If(null, trueBlock, falseBlock, 1);
    });
  }

  @Test
  @DisplayName("If should throw NPE when trueBlock is null")
  public void ifWithNullTrueBlock() {
    Expr.Literal condition = new Expr.Literal(true, 1);
    Expr.Block falseBlock = new Expr.Block(List.of(), 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.If(condition, null, falseBlock, 1);
    });
  }

  @Test
  @DisplayName("If should throw NPE when falseBlock is null")
  public void ifWithNullFalseBlock() {
    Expr.Literal condition = new Expr.Literal(true, 1);
    Expr.Block trueBlock = new Expr.Block(List.of(), 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.If(condition, trueBlock, null, 1);
    });
  }

  @Test
  @DisplayName("Literal should throw NPE when value is null")
  public void literalWithNullValue() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.Literal(null, 1);
    });
  }

  @Test
  @DisplayName("Identifier should throw NPE when name is null")
  public void identifierWithNullName() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.Identifier(null, 1);
    });
  }

  @Test
  @DisplayName("VarAssignment should throw NPE when name is null")
  public void varAssignmentWithNullName() {
    Expr.Literal value = new Expr.Literal(42, 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.VarAssignment(null, value, true, 1);
    });
  }

  @Test
  @DisplayName("VarAssignment should throw NPE when expr is null")
  public void varAssignmentWithNullExpr() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.VarAssignment("x", null, true, 1);
    });
  }

  @Test
  @DisplayName("MethodCall should throw NPE when receiver is null")
  public void methodCallWithNullReceiver() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.MethodCall(null, "method", List.of(), 1);
    });
  }

  @Test
  @DisplayName("MethodCall should throw NPE when name is null")
  public void methodCallWithNullName() {
    Expr.Literal receiver = new Expr.Literal("obj", 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.MethodCall(receiver, null, List.of(), 1);
    });
  }

  @Test
  @DisplayName("MethodCall should throw NPE when args is null")
  public void methodCallWithNullArgs() {
    Expr.Literal receiver = new Expr.Literal("obj", 1);
    assertThrows(NullPointerException.class, () -> {
      new Expr.MethodCall(receiver, "method", null, 1);
    });
  }

  @Test
  @DisplayName("ObjectLiteral should throw NPE when initMap is null")
  public void objectLiteralWithNullInitMap() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.ObjectLiteral(null, 1);
    });
  }

  @Test
  @DisplayName("Return should throw NPE when expr is null")
  public void returnWithNullExpr() {
    assertThrows(NullPointerException.class, () -> {
      new Expr.Return(null, 1);
    });
  }
}
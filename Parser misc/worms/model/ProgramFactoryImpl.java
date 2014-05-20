package worms.model;

import java.util.List;

import worms.model.AssignStatement;
import worms.model.BooleanAndExpression;
import worms.model.BooleanLiteralExpression;
import worms.model.BooleanNotExpression;
import worms.model.BooleanOrExpression;
import worms.model.DoubleAdditionExpression;
import worms.model.DoubleCosinusExpression;
import worms.model.DoubleDivisionExpression;
import worms.model.DoubleGreaterThanExpression;
import worms.model.DoubleGreaterThanOrEqualToExpression;
import worms.model.DoubleLessThanExpression;
import worms.model.DoubleLessThanOrEqualToExpression;
import worms.model.DoubleLiteralExpression;
import worms.model.DoubleMultiplyExpression;
import worms.model.DoubleSinusExpression;
import worms.model.DoubleSqrtExpression;
import worms.model.DoubleSubtractionExpression;
import worms.model.EqualityExpression;
import worms.model.Expression;
import worms.model.FireStatement;
import worms.model.ForEachStatement;
import worms.model.GetActionPointsExpression;
import worms.model.GetDirectionExpression;
import worms.model.GetHitPointsExpression;
import worms.model.GetMaxActionPointsExpression;
import worms.model.GetMaxHitPointsExpression;
import worms.model.GetRadiusExpression;
import worms.model.GetSameTeamExpression;
import worms.model.GetXExpression;
import worms.model.GetYExpression;
import worms.model.IfStatement;
import worms.model.InequalityExpression;
import worms.model.IsFoodExpression;
import worms.model.IsWormExpression;
import worms.model.JumpStatement;
import worms.model.MoveStatement;
import worms.model.NullExpression;
import worms.model.PrintStatement;
import worms.model.SearchObjectExpression;
import worms.model.SelfExpression;
import worms.model.SequenceOfStatements;
import worms.model.SkipStatement;
import worms.model.Statement;
import worms.model.ToggleWeaponStatement;
import worms.model.TurnStatement;
import worms.model.WhileStatement;
import worms.model.programs.ProgramFactory;



public class ProgramFactoryImpl
  implements ProgramFactory<Expression, Statement, Type>{

  @Override
  public Expression createDoubleLiteral(int line, int column, double d) {
    return new DoubleLiteralExpression(d);
  
  }

  @Override
  public Expression createBooleanLiteral(int line, int column, boolean b) {
    return new BooleanLiteralExpression(b);
  }

  @Override
  public Expression createAnd(int line, int column, Expression e1,
    Expression e2) {
    return new BooleanAndExpression((BooleanExpression) e1,(BooleanExpression) e2);
  }

  @Override
  public Expression createOr(int line, int column, Expression e1,
    Expression e2) {
    return new BooleanOrExpression((BooleanExpression) e1,(BooleanExpression) e2);
  }

  @Override
  public Expression createNot(int line, int column, Expression e) {
    return new BooleanNotExpression((BooleanExpression) e);
  }

  @Override
  public Expression createNull(int line, int column) {
    return new NullExpression();
  }

  @Override
  public Expression createSelf(int line, int column) {
    return new SelfExpression();
  }

  @Override
  public Expression createGetX(int line, int column, Expression e) {
    return new GetXExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetY(int line, int column, Expression e) {
    return new GetYExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetRadius(int line, int column, Expression e) {
    return new GetRadiusExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetDir(int line, int column, Expression e) {
    return new GetDirectionExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetAP(int line, int column, Expression e) {
    return new GetActionPointsExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetMaxAP(int line, int column, Expression e) {
    return new GetMaxActionPointsExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetHP(int line, int column, Expression e) {
    return new GetHitPointsExpression((EntityExpression) e);
  }

  @Override
  public Expression createGetMaxHP(int line, int column, Expression e) {
    return new GetMaxHitPointsExpression((EntityExpression) e);
  }

  @Override
  public Expression createSameTeam(int line, int column, Expression e) {
    return new GetSameTeamExpression((EntityExpression) e);
  }

  @Override
  public Expression createSearchObj(int line, int column, Expression e) {
    return new SearchObjectExpression((DoubleExpression) e);
  }

  @Override
  public Expression createIsWorm(int line, int column, Expression e) {
    return new IsWormExpression((EntityExpression) e);
  }

  @Override
  public Expression createIsFood(int line, int column, Expression e) {
    return new IsFoodExpression((EntityExpression) e);
  }

//  public E IsTerrain(int line, int column, E e);

  @Override
  public Expression createVariableAccess(int line, int column, String name) {
    return null;
  }

  @Override
  public Expression createLessThan(int line, int column, Expression e1, Expression e2) {
    return new DoubleLessThanExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createGreaterThan(int line, int column, Expression e1, Expression e2) {
    return new DoubleGreaterThanExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createLessThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return new DoubleLessThanOrEqualToExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createGreaterThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return new DoubleGreaterThanOrEqualToExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createEquality(int line, int column, Expression e1, Expression e2) {
    return  new EqualityExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createInequality(int line, int column, Expression e1, Expression e2) {
    return new InequalityExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createAdd(int line, int column, Expression e1, Expression e2) {
    return new DoubleAdditionExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createSubtraction(int line, int column, Expression e1, Expression e2) {
    return new DoubleSubtractionExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createMul(int line, int column, Expression e1, Expression e2) {
    return new DoubleMultiplyExpression((DoubleExpression) e1,(DoubleExpression) e2);
    		
  }

  @Override
  public Expression createDivision(int line, int column, Expression e1, Expression e2) {
    return new DoubleDivisionExpression((DoubleExpression) e1,(DoubleExpression) e2);
  }

  @Override
  public Expression createSqrt(int line, int column, Expression e) {
    return new DoubleSqrtExpression((DoubleExpression) e);
  }

  @Override
  public Expression createSin(int line, int column, Expression e) {
    return new DoubleSinusExpression((DoubleExpression) e);
  }

  @Override
  public Expression createCos(int line, int column, Expression e) {
    return new DoubleCosinusExpression((DoubleExpression) e);
  }

  @Override
  public Statement createTurn(int line, int column, Expression angle) {
    return new TurnStatement((DoubleExpression) angle);
  }

  @Override
  public Statement createMove(int line, int column) {
    return new MoveStatement();
  }

  @Override
  public Statement createJump(int line, int column) {
    return new JumpStatement();
  }

  @Override
  public Statement createToggleWeap(int line, int column) {
    return new ToggleWeaponStatement();
  }

  @Override
  public Statement createFire(int line, int column, Expression yield) {
    return new FireStatement((DoubleExpression) yield);
  }

  @Override
  public Statement createAssignment(int line, int column, String variable, Expression rhs) {
    return new AssignStatement(variable,rhs);
  }

  @Override
  public Statement createIf(int line, int column, Expression condition, Statement then, Statement otherwise) {
    return new IfStatement((BooleanExpression) condition,then,otherwise);
  }

  @Override
  public Statement createWhile(int line, int column, Expression condition, Statement body) {
    return new WhileStatement((BooleanExpression) condition,body);
  }

  @Override
  public Statement createForeach(int line, int column, ForeachType type, String variableName, Statement body) {
    return new ForEachStatement(type,variableName,body);
  }

  @Override
  public Statement createSkip(int line, int column) {
    return new SkipStatement();
  }

  @Override
  public Statement createSequence(int line, int column, List<Statement> statements) {
    return new SequenceOfStatements(statements);
  }

  @Override
  public Statement createPrint(int line, int column, Expression e) {
    return new PrintStatement(e);
  }

  @Override
  public Type createDoubleType() {
    return new MyDoubleType();
  }

  @Override
  public Type createBooleanType() {
    return new MyBooleanType();
  }

  @Override
  public Type createEntityType() {
    return new EntityType();
  }

@Override
public Expression createVariableAccess(int line, int column, String name,
		Type type) {
	return type.createVariableExpression(name);
}
}


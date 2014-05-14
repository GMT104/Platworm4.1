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
import worms.model.VariableExpression;
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
    return new BooleanAndExpression(e1,e2);
  }

  @Override
  public Expression createOr(int line, int column, Expression e1,
    Expression e2) {
    return new BooleanOrExpression(e1,e2);
  }

  @Override
  public Expression createNot(int line, int column, Expression e) {
    return new BooleanNotExpression(e);
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
    return new GetXExpression(e);
  }

  @Override
  public Expression createGetY(int line, int column, Expression e) {
    return new GetYExpression(e);
  }

  @Override
  public Expression createGetRadius(int line, int column, Expression e) {
    return new GetRadiusExpression(e);
  }

  @Override
  public Expression createGetDir(int line, int column, Expression e) {
    return new GetDirectionExpression(e);
  }

  @Override
  public Expression createGetAP(int line, int column, Expression e) {
    return new GetActionPointsExpression(e);
  }

  @Override
  public Expression createGetMaxAP(int line, int column, Expression e) {
    return new GetMaxActionPointsExpression(e);
  }

  @Override
  public Expression createGetHP(int line, int column, Expression e) {
    return new GetHitPointsExpression(e);
  }

  @Override
  public Expression createGetMaxHP(int line, int column, Expression e) {
    return new GetMaxHitPointsExpression(e);
  }

  @Override
  public Expression createSameTeam(int line, int column, Expression e) {
    return new GetSameTeamExpression(e);
  }

  @Override
  public Expression createSearchObj(int line, int column, Expression e) {
    return new SearchObjectExpression(e);
  }

  @Override
  public Expression createIsWorm(int line, int column, Expression e) {
    return new IsWormExpression(e);
  }

  @Override
  public Expression createIsFood(int line, int column, Expression e) {
    return new IsFoodExpression(e);
  }

//  public E IsTerrain(int line, int column, E e);

  @Override
  public Expression createVariableAccess(int line, int column, String name) {
    return new VariableExpression(name);
  }

  @Override
  public Expression createLessThan(int line, int column, Expression e1, Expression e2) {
    return new DoubleLessThanExpression(e1,e2);
  }

  @Override
  public Expression createGreaterThan(int line, int column, Expression e1, Expression e2) {
    return new DoubleGreaterThanExpression(e1,e2);
  }

  @Override
  public Expression createLessThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return new DoubleLessThanOrEqualToExpression(e1,e2);
  }

  @Override
  public Expression createGreaterThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return new DoubleGreaterThanOrEqualToExpression(e1,e2);
  }

  @Override
  public Expression createEquality(int line, int column, Expression e1, Expression e2) {
    return  new EqualityExpression(e1,e2);
  }

  @Override
  public Expression createInequality(int line, int column, Expression e1, Expression e2) {
    return new InequalityExpression(e1,e2);
  }

  @Override
  public Expression createAdd(int line, int column, Expression e1, Expression e2) {
    return new DoubleAdditionExpression(e1,e2);
  }

  @Override
  public Expression createSubtraction(int line, int column, Expression e1, Expression e2) {
    return new DoubleSubtractionExpression(e1,e2);
  }

  @Override
  public Expression createMul(int line, int column, Expression e1, Expression e2) {
    return new DoubleMultiplyExpression(e1,e2);
    		
  }

  @Override
  public Expression createDivision(int line, int column, Expression e1, Expression e2) {
    return new DoubleDivisionExpression(e1,e2);
  }

  @Override
  public Expression createSqrt(int line, int column, Expression e) {
    return new DoubleSqrtExpression(e);
  }

  @Override
  public Expression createSin(int line, int column, Expression e) {
    return new DoubleSinusExpression(e);
  }

  @Override
  public Expression createCos(int line, int column, Expression e) {
    return new DoubleCosinusExpression(e);
  }

  @Override
  public Statement createTurn(int line, int column, Expression angle) {
    return new TurnStatement(angle);
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
    return new FireStatement(yield);
  }

  @Override
  public Statement createAssignment(int line, int column, String variable, Expression rhs) {
    return new AssignStatement(variable,rhs);
  }

  @Override
  public Statement createIf(int line, int column, Expression condition, Statement then, Statement otherwise) {
    return new IfStatement(condition,then,otherwise);
  }

  @Override
  public Statement createWhile(int line, int column, Expression condition, Statement body) {
    return new WhileStatement(condition,body);
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
	// TODO Auto-generated method stub
	return null;
}
}


package worms.model.programs.parser;

import java.util.List;

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
    return GetXExpression(e);
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
    return (null);
  }

  @Override
  public Expression createIsFood(int line, int column, Expression e) {
    return (null);
  }

//  public E IsTerrain(int line, int column, E e);

  @Override
  public Expression createVariableAccess(int line, int column, String name) {
    return (null);
  }

  @Override
  public Expression createLessThan(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createGreaterThan(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createLessThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createGreaterThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createEquality(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createInequality(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createAdd(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createSubtraction(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createMul(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createDivision(int line, int column, Expression e1, Expression e2) {
    return (null);
  }

  @Override
  public Expression createSqrt(int line, int column, Expression e) {
    return (null);
  }

  @Override
  public Expression createSin(int line, int column, Expression e) {
    return (null);
  }

  @Override
  public Expression createCos(int line, int column, Expression e) {
    return (null);
  }

  @Override
  public Statement createTurn(int line, int column, Expression angle) {
    return (null);
  }

  @Override
  public Statement createMove(int line, int column) {
    return (null);
  }

  @Override
  public Statement createJump(int line, int column) {
    return (null);
  }

  @Override
  public Statement createToggleWeap(int line, int column) {
    return (null);
  }

  @Override
  public Statement createFire(int line, int column, Expression yield) {
    return (null);
  }

  @Override
  public Statement createAssignment(int line, int column, String variable, Expression rhs) {
    return (null);
  }

  @Override
  public Statement createIf(int line, int column, Expression condition, Statement then, Statement otherwise) {
    return (null);
  }

  @Override
  public Statement createWhile(int line, int column, Expression condition, Statement body) {
    return (null);
  }

  @Override
  public Statement createForeach(int line, int column, ForeachType type, String variableName, Statement body) {
    return (null);
  }

  @Override
  public Statement createSkip(int line, int column) {
    return (null);
  }

  @Override
  public Statement createSequence(int line, int column, List<Statement> statements) {
    return (null);
  }

  @Override
  public Statement createPrint(int line, int column, Expression e) {
    return (null);
  }

  @Override
  public Type createDoubleType() {
    return (null);
  }

  @Override
  public Type createBooleanType() {
    return (null);
  }

  @Override
  public Type createEntityType() {
    return (null);
  }
}


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
  implements ProgramFactory<Expression<?>, Statement, Type>{

  @Override
  public Expression<MyDouble> createDoubleLiteral(int line, int column, double d) {
    return new DoubleLiteralExpression(d);
  
  }

  @Override
  public Expression<MyBoolean> createBooleanLiteral(int line, int column, boolean b) {
    return new BooleanLiteralExpression(b);
  }

  @Override
  public Expression<MyBoolean> createAnd(int line, int column, Expression<?> e1,
    Expression<?> e2) {
    return new BooleanAndExpression((Expression<MyBoolean>) e1,(Expression<MyBoolean>) e2);
  }

  @Override
  public Expression<MyBoolean> createOr(int line, int column, Expression<?> e1,
    Expression<?> e2) {
    return new BooleanOrExpression((Expression<MyBoolean>) e1,(Expression<MyBoolean>) e2);
  }

  @Override
  public Expression<MyBoolean> createNot(int line, int column, Expression e) {
    return new BooleanNotExpression((Expression<MyBoolean>) e);
  }

  @Override
  public Expression<Type> createNull(int line, int column) {
    return new NullExpression();
  }

  @Override
  public Expression<Entity> createSelf(int line, int column) {
    return new SelfExpression();
  }

  @Override
  public Expression<MyDouble> createGetX(int line, int column, Expression e) {
    return new GetXExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyDouble>  createGetY(int line, int column, Expression<?> e) {
    return new GetYExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyDouble>  createGetRadius(int line, int column, Expression<?> e) {
    return new GetRadiusExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyDouble>  createGetDir(int line, int column, Expression e) {
    return new GetDirectionExpression((Expression<Entity>) e);
  }
  
  @Override
  public Expression<MyDouble>  createGetAP(int line, int column, Expression e) {
    return new GetActionPointsExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyDouble>  createGetMaxAP(int line, int column, Expression e) {
    return new GetMaxActionPointsExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyDouble>  createGetHP(int line, int column, Expression e) {
    return new GetHitPointsExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyDouble>  createGetMaxHP(int line, int column, Expression e) {
    return new GetMaxHitPointsExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyBoolean>  createSameTeam(int line, int column, Expression e) {
    return new GetSameTeamExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<Entity>  createSearchObj(int line, int column, Expression e) {
    return new SearchObjectExpression((Expression<MyDouble>) e);
  }

  @Override
  public Expression<MyBoolean>  createIsWorm(int line, int column, Expression e) {
    return new IsWormExpression((Expression<Entity>) e);
  }

  @Override
  public Expression<MyBoolean> createIsFood(int line, int column, Expression e) {
    return new IsFoodExpression((Expression<Entity>) e);
  }

//  public E IsTerrain(int line, int column, E e);

  @Override
  public Expression createVariableAccess(int line, int column, String name) {
    return null;
  }

  @Override
  public Expression<MyBoolean> createLessThan(int line, int column, Expression e1, Expression e2) {
    return new DoubleLessThanExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyBoolean> createGreaterThan(int line, int column, Expression e1, Expression e2) {
    return new DoubleGreaterThanExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyBoolean> createLessThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return new DoubleLessThanOrEqualToExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyBoolean> createGreaterThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
    return new DoubleGreaterThanOrEqualToExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyBoolean> createEquality(int line, int column, Expression e1, Expression e2) {
    return  new EqualityExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyBoolean> createInequality(int line, int column, Expression e1, Expression e2) {
    return new InequalityExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyDouble> createAdd(int line, int column, Expression e1, Expression e2) {
    return new DoubleAdditionExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyDouble> createSubtraction(int line, int column, Expression e1, Expression e2) {
    return new DoubleSubtractionExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyDouble> createMul(int line, int column, Expression e1, Expression e2) {
    return new DoubleMultiplyExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
    		
  }

  @Override
  public Expression<MyDouble> createDivision(int line, int column, Expression e1, Expression e2) {
    return new DoubleDivisionExpression((Expression<MyDouble>) e1,(Expression<MyDouble>) e2);
  }

  @Override
  public Expression<MyDouble> createSqrt(int line, int column, Expression e) {
    return new DoubleSqrtExpression((Expression<MyDouble>) e);
  }

  @Override
  public Expression<MyDouble> createSin(int line, int column, Expression e) {
    return new DoubleSinusExpression((Expression<MyDouble>) e);
  }

  @Override
  public Expression<MyDouble> createCos(int line, int column, Expression e) {
    return new DoubleCosinusExpression((Expression<MyDouble>) e);
  }

  @Override
  public Statement createTurn(int line, int column, Expression angle) {
    return new TurnStatement((Expression<MyDouble>) angle);
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
    return new FireStatement((Expression<MyDouble>) yield);
  }

  @Override
  public Statement createAssignment(int line, int column, String variable, Expression<?> rhs) {
//    if (rhs instanceof Expression<MyBoolean>)
//	  	return new AssignStatement(variable,(Expression<MyBoolean>) rhs);
//    else if (rhs instanceof Expression<MyDouble>)
//	  	return new AssignStatement(variable,(Expression<MyDouble>) rhs);
//    else
//	  	return new AssignStatement(variable,((Expression<Entity>) rhs);
	  return new AssignStatement(variable, rhs);
  }

  @Override
  public Statement createIf(int line, int column, Expression condition, Statement then, Statement otherwise) {
    return new IfStatement((Expression<MyBoolean>) condition,then,otherwise);
  }

  @Override
  public Statement createWhile(int line, int column, Expression condition, Statement body) {
    return new WhileStatement((Expression<MyBoolean>) condition,body);
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
    return new MyDouble();
  }

  @Override
  public Type createBooleanType() {
    return new MyBoolean();
  }

  @Override
  public Type createEntityType() {
    return new Entity();
  }

@Override
public Expression createVariableAccess(int line, int column, String name,
		Type type) {
	return new VariableExpression<Type>(name);
	
	// Als we geen twee aparte hierarchien hadden con ik gewoon VariableExpression<Type> doen.
}
}


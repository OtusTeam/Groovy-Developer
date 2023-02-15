package lesson12

import groovy.transform.CompileStatic
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@CompileStatic
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class LoggableAstTransformation implements ASTTransformation{
    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        MethodNode method = nodes[1] as MethodNode
        // Starting <name> <timestamp>
        // Ending <name> <timestamp>
        Statement startMessage = createPrintlnCodeFragment("Starting ${method.name}")
        Statement endMessage = createPrintlnCodeFragment("Ending ${method.name}")

        def existedStatements = ((BlockStatement) method.code).statements
        existedStatements.add(0, startMessage)
        existedStatements.add(endMessage)

        /*
        def startTime = System.nanotime()
        println(endTime-startTime)
         */
    }

    private static Statement createPrintlnCodeFragment(String message) {
        def argumentListExpression = new ArgumentListExpression(new ConstantExpression(message))
        def methodCallExpression = new MethodCallExpression(
                new VariableExpression("this"),
                new ConstantExpression("println"),
                argumentListExpression
        )
        new ExpressionStatement(methodCallExpression)
    }
}

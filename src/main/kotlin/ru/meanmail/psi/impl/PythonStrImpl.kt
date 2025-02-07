package ru.meanmail.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import ru.meanmail.psi.PythonDquoteStr
import ru.meanmail.psi.PythonSquoteStr
import ru.meanmail.psi.PythonStr
import ru.meanmail.psi.Visitor

class PythonStrImpl(node: ASTNode) :
    ASTWrapperPsiElement(node), PythonStr {

    fun accept(visitor: Visitor) {
        visitor.visitPythonStr(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is Visitor) {
            accept(visitor)
        } else {
            super.accept(visitor)
        }
    }

    override val pythonDquoteStr: PythonDquoteStr?
        get() = findChildByClass(PythonDquoteStr::class.java)

    override val pythonSquoteStr: PythonSquoteStr?
        get() = findChildByClass(PythonSquoteStr::class.java)
}

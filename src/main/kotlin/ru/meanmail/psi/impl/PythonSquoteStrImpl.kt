package ru.meanmail.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import ru.meanmail.psi.PythonSquoteStr
import ru.meanmail.psi.Visitor

class PythonSquoteStrImpl(node: ASTNode) : ASTWrapperPsiElement(node), PythonSquoteStr {
    fun accept(visitor: Visitor) {
        visitor.visitPythonSquoteStr(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is Visitor) accept(visitor) else super.accept(visitor)
    }
}

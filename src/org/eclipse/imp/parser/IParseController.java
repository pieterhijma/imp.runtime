package org.eclipse.uide.parser;

import java.util.List;

import lpg.runtime.IMessageHandler;
import lpg.runtime.IToken;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uide.core.ILanguageService;

public interface IParseController extends ILanguageService {
    void initialize(IPath projRelFilePath, IProject project, IMessageHandler handler);

    IProject getProject();

    /**
     * @return either a project-relative path, if getProject() is non-null, or an absolute path.
     */
    IPath getPath();

    IParser getParser();

    ILexer getLexer();

    Object getCurrentAst();

    boolean isKeyword(int kind);

    char [][] getKeywords();

    public int getTokenIndexAtCharacter(int offset);

    public IToken getTokenAtCharacter(int offset);

    IASTNodeLocator getNodeLocator();

    boolean hasErrors();

    /**
     * @return a List of ParseError
     */
    List getErrors();

    Object parse(String input, boolean scanOnly, IProgressMonitor monitor);
}

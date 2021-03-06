/*******************************************************************************
* Copyright (c) 2010 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.editor.internal;

import java.util.Map;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.editor.quickfix.IAnnotation;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.jface.text.source.Annotation;

public class DefaultAnnotation extends Annotation implements IAnnotation {
	private Map<String, Object> attributes;
	private UniversalEditor editor;

	public DefaultAnnotation(String type, boolean isPersistent, String text, UniversalEditor editor,
			Map<String, Object> attributes) {
		super(type, isPersistent, text);
		this.editor = editor;
		this.attributes = attributes;
	}

	public DefaultAnnotation(boolean isPersistent) {
		super(isPersistent);
	}

	public int getId() {
		if (attributes.containsKey(IMessageHandler.ERROR_CODE_KEY)) {
			return (Integer) attributes.get(IMessageHandler.ERROR_CODE_KEY);
		}
		return -1;
	}

	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	public int getSeverity() {
		if (attributes.containsKey(IMessageHandler.SEVERITY_KEY)) {
			return (Integer) attributes.get(IMessageHandler.SEVERITY_KEY);
		}
		return IAnnotation.ERROR;
	}

	public UniversalEditor getEditor() {
		return editor;
	}
}

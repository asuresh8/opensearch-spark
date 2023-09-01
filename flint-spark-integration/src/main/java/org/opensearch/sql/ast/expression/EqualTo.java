/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.sql.ast.expression;

import org.opensearch.sql.ast.AbstractNodeVisitor;

import java.util.Arrays;
import java.util.List;

/** Expression node of binary operator or comparison relation EQUAL. */

public class EqualTo extends UnresolvedExpression {
   private UnresolvedExpression left;
   private UnresolvedExpression right;

    public EqualTo(UnresolvedExpression left, UnresolvedExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
  public List<UnresolvedExpression> getChild() {
    return Arrays.asList(left, right);
  }

  @Override
  public <R, C> R accept(AbstractNodeVisitor<R, C> nodeVisitor, C context) {
    return nodeVisitor.visitEqualTo(this, context);
  }
}

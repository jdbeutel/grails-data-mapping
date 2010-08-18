/* Copyright (C) 2010 SpringSource
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.datastore.query;

import java.util.Collection;
import java.util.List;

/**
 * Factory for creating {@link org.springframework.datastore.query.Query.Criterion} instances
 */
public class Restrictions {

    /**
     * Restricts the property to be equal to the given value
     * @param property The property
     * @param value The value
     * @return An instance of Query.Equals
     */
    public static Query.Equals eq(String property, Object value) {
        return new Query.Equals(property, value);
    }

    /**
     * Restricts the property to be in the list of given values
     * @param property The property
     * @param values The values
     * @return An instance of Query.In
     */
    public static Query.In in(String property, Collection values) {
        return new Query.In(property, values);
    }

    /**
     * Restricts the property match the given String expressions. Expressions use SQL-like % to denote wildcards
     * @param property The property name
     * @param expression The expression
     * @return An instance of Query.Like
     */
    public static Query.Like like(String property, String expression) {
        return new Query.Like(property, expression);
    }

    public static Query.Criterion and(Query.Criterion a, Query.Criterion b) {
        return new Query.Conjunction().add(a).add(b);
    }

    public static Query.Criterion or(Query.Criterion a, Query.Criterion b) {
        return new Query.Disjunction().add(a).add(b);
    }

    /**
     * Restricts the results by the given property value range
     *
     * @param property The name of the property
     * @param start The start of the range
     * @param end The end of the range
     * @return This query instance
     */

    public static Query.Between between(String property, Object start, Object end) {
        return new Query.Between(property, start, end);
    }
}

/**
 * h2spatial is a library that brings spatial support to the H2 Java database.
 *
 * h2spatial is distributed under GPL 3 license. It is produced by the "Atelier SIG"
 * team of the IRSTV Institute <http://www.irstv.fr/> CNRS FR 2488.
 *
 * Copyright (C) 2007-2012 IRSTV (FR CNRS 2488)
 *
 * h2patial is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * h2spatial is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * h2spatial. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */

package org.h2spatial.internal.function.spatial.operators;

import com.vividsolutions.jts.geom.Geometry;
import org.h2spatial.ValueGeometry;
import org.h2spatialapi.ScalarFunction;

/**
 * Compute the intersection between two geometries
 * @author Nicolas Fortin
 */
public class ST_Intersection implements ScalarFunction {
    @Override
    public String getJavaStaticMethod() {
        return "intersection";
    }

    @Override
    public Object getProperty(String propertyName) {
        if(propertyName.equals(ScalarFunction.PROP_DETERMINISTIC)) {
            return true;
        }
        return null;
    }

    /**
     * @param a Geometry instance.
     * @param b Geometry instance
     * @return the intersection between two geometries
     */
    public static ValueGeometry intersection(Geometry a,Geometry b) {
        if(a==null || b==null) {
            return null;
        }
        return new ValueGeometry(a.intersection(b));
    }
}
